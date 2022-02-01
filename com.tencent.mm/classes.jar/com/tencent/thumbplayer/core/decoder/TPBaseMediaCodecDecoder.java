package com.tencent.thumbplayer.core.decoder;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPCodecUtils;
import com.tencent.thumbplayer.core.common.TPNativeLog;
import com.tencent.thumbplayer.core.common.TPUnitendCodecUtils;
import com.tencent.tmediacodec.b.a;
import com.tencent.tmediacodec.b.c;
import com.tencent.tmediacodec.b.c;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public abstract class TPBaseMediaCodecDecoder
  implements ITPMediaCodecDecoder
{
  private static final int MEDIA_CODEC_ERROR_INDEX = -1000;
  private static long MEDIA_CODEC_INPUT_TIMEOUT_US = 2000L;
  private static long MEDIA_CODEC_OUTPUT_TIMEOUT_US = 2000L;
  private static final int MSG_FLUSH = 1002;
  private static final int MSG_RELEASE = 1003;
  private static final int MSG_RELEASE_OUTPUT_BUFFER = 1000;
  private static final int MSG_SET_OUTPUT_SURFACE = 1001;
  private com.tencent.tmediacodec.b mCodec = null;
  protected int mCodecId;
  private MediaCodec.CryptoInfo mCryptoInfo = null;
  private HandlerThread mDecodeThread = null;
  private AsyncDecodeHandler mDecoderHandler = null;
  protected int mDolbyVisionLevel = 0;
  protected int mDolbyVisionProfile = 0;
  protected int mDrmType = -1;
  protected boolean mEnableAsyncMode = false;
  private boolean mEnableAudioPassThrough = false;
  protected boolean mEnableMediaCodecReuse = false;
  protected int mEnableRendererSharpen = 0;
  private boolean mEnableSetOutputSurfaceApi = false;
  private TPFrameInfo mFrameInfo = new TPFrameInfo();
  private int mHandlerResult = 0;
  private BlockingQueue<Integer> mInputQueue = new LinkedBlockingQueue();
  private BlockingQueue<TPFrameInfo> mOutputQueue = new LinkedBlockingQueue();
  private boolean mRestartCodecOnException = false;
  protected String mSharpenShaderPath = "assets/shaders";
  private boolean mStarted = false;
  protected Surface mSurface = null;
  protected boolean mSwitchEnableRendererSharpen = true;
  private final Object mThreadLock = new Object();
  
  public TPBaseMediaCodecDecoder(int paramInt)
  {
    this.mCodecId = paramInt;
  }
  
  private int decodeAsync(byte[] paramArrayOfByte, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    Integer localInteger = (Integer)this.mInputQueue.poll();
    if (localInteger == null) {
      return 1;
    }
    for (;;)
    {
      try
      {
        localObject = this.mCodec;
        i = localInteger.intValue();
        if (((com.tencent.tmediacodec.b)localObject).ahSX == null) {
          break label176;
        }
        localObject = ((com.tencent.tmediacodec.b)localObject).ahSX.kcs().getInputBuffer(i);
        if (localObject != null) {
          ((ByteBuffer)localObject).put(paramArrayOfByte);
        }
        int j;
        if ((paramBoolean2) && (this.mCryptoInfo != null))
        {
          paramArrayOfByte = this.mCodec;
          j = localInteger.intValue();
          localObject = this.mCryptoInfo;
          if (!paramBoolean1) {
            break label182;
          }
          i = 1;
          paramArrayOfByte.a(j, (MediaCodec.CryptoInfo)localObject, paramLong, i);
        }
        else
        {
          localObject = this.mCodec;
          j = localInteger.intValue();
          int k = paramArrayOfByte.length;
          if (paramBoolean1)
          {
            i = 1;
            ((com.tencent.tmediacodec.b)localObject).a(j, k, paramLong, i);
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        return onMediaCodecException(paramArrayOfByte);
      }
      int i = 0;
      continue;
      return 0;
      label176:
      Object localObject = null;
      continue;
      label182:
      i = 0;
    }
  }
  
  private TPFrameInfo dequeueOutputBufferAsync()
  {
    this.mFrameInfo.errCode = 1;
    TPFrameInfo localTPFrameInfo2 = (TPFrameInfo)this.mOutputQueue.poll();
    TPFrameInfo localTPFrameInfo1 = localTPFrameInfo2;
    if (localTPFrameInfo2 == null) {
      localTPFrameInfo1 = this.mFrameInfo;
    }
    return localTPFrameInfo1;
  }
  
  private void exitDecodeThread()
  {
    if (this.mDecodeThread != null)
    {
      if (Build.VERSION.SDK_INT < 18) {
        break label31;
      }
      this.mDecodeThread.quitSafely();
    }
    for (;;)
    {
      label31:
      try
      {
        this.mDecodeThread.join();
        return;
      }
      catch (InterruptedException localInterruptedException) {}
      this.mDecodeThread.quit();
    }
  }
  
  private int flushAsync()
  {
    TPNativeLog.printLog(2, getLogTag(), "flushAsync: ");
    Message localMessage = this.mDecoderHandler.obtainMessage();
    localMessage.what = 1002;
    return waitingForHandleMessage(localMessage);
  }
  
  private int handleFlush()
  {
    TPNativeLog.printLog(2, getLogTag(), "handleFlush: ");
    if (this.mCodec == null) {
      return 104;
    }
    try
    {
      com.tencent.tmediacodec.b localb = this.mCodec;
      if (localb.ahSX != null) {
        localb.ahSX.flush();
      }
      return 0;
    }
    catch (Exception localException)
    {
      return onMediaCodecException(localException);
    }
  }
  
  private void handleMessageComplete(int paramInt)
  {
    this.mHandlerResult = paramInt;
    this.mThreadLock.notify();
  }
  
  private int handleRelease()
  {
    if (this.mCodec == null) {
      return 101;
    }
    this.mStarted = false;
    try
    {
      com.tencent.tmediacodec.b localb = this.mCodec;
      if (localb.ahSX != null) {
        localb.ahSX.stop();
      }
      return 0;
    }
    catch (Exception localException)
    {
      TPNativeLog.printLog(4, getLogTag(), "release: failed!" + getStackTrace(localException));
      return 3;
    }
    finally
    {
      this.mCodec.release();
      this.mCodec = null;
    }
  }
  
  private int handleReleaseOutputBuffer(int paramInt, boolean paramBoolean)
  {
    if ((this.mCodec == null) || (paramInt < 0)) {
      return 3;
    }
    try
    {
      this.mCodec.releaseOutputBuffer(paramInt, paramBoolean);
      return 0;
    }
    catch (Exception localException)
    {
      return onMediaCodecException(localException);
    }
  }
  
  private int handleSetOutputSurface(Surface paramSurface)
  {
    TPNativeLog.printLog(2, getLogTag(), "setOutputSurface: ".concat(String.valueOf(paramSurface)));
    if (this.mSurface == paramSurface) {
      TPNativeLog.printLog(3, getLogTag(), "setOutputSurface: set the same surface.");
    }
    for (;;)
    {
      return 0;
      Object localObject = this.mSurface;
      this.mSurface = paramSurface;
      if (this.mCodec != null) {
        if ((localObject != null) && (paramSurface != null)) {
          try
          {
            if ((paramSurface.isValid()) && (Build.VERSION.SDK_INT >= 23) && (this.mEnableSetOutputSurfaceApi))
            {
              localObject = this.mCodec;
              if (((com.tencent.tmediacodec.b)localObject).ahSX == null) {
                continue;
              }
              ((com.tencent.tmediacodec.b)localObject).ahSX.setOutputSurface(paramSurface);
              return 0;
            }
          }
          catch (Exception paramSurface)
          {
            TPNativeLog.printLog(4, getLogTag(), "setOutputSurface onMediaCodecException:\n" + getStackTrace(paramSurface));
            return 3;
          }
        }
      }
    }
    return 3;
  }
  
  private int handleSignalEndOfStream(int paramInt)
  {
    try
    {
      this.mCodec.a(paramInt, 0, 0L, 4);
      return 0;
    }
    catch (Exception localException)
    {
      TPNativeLog.printLog(4, getLogTag(), "handleSignalEndOfStream: failed!" + getStackTrace(localException));
    }
    return 3;
  }
  
  private boolean initMediaCodecInternal()
  {
    for (;;)
    {
      try
      {
        if (getMimeType().equals("audio/vnd.dts"))
        {
          TPNativeLog.printLog(2, getLogTag(), "initMediaCodec current mime type:" + getMimeType() + " is audio dts, need set input timeout to 0!");
          MEDIA_CODEC_INPUT_TIMEOUT_US = 0L;
          MEDIA_CODEC_OUTPUT_TIMEOUT_US = 0L;
        }
        TPNativeLog.printLog(2, getLogTag(), "initMediaCodec mime:" + getMimeType() + " profile:" + this.mDolbyVisionProfile + " level:" + this.mDolbyVisionLevel + " mDrmType:" + this.mDrmType);
        Object localObject1;
        if (this.mDolbyVisionProfile > 0)
        {
          if (2 != this.mDrmType) {
            break label488;
          }
          bool = true;
          localObject1 = TPUnitendCodecUtils.getDolbyVisionDecoderName(getMimeType(), this.mDolbyVisionProfile, this.mDolbyVisionLevel, bool);
          TPNativeLog.printLog(2, getLogTag(), "initMediaCodec Dolby Vision codecName:".concat(String.valueOf(localObject1)));
          TPNativeLog.printLog(2, getLogTag(), "initMediaCodec codecName:".concat(String.valueOf(localObject1)));
          if (localObject1 == null)
          {
            TPNativeLog.printLog(4, getLogTag(), "initMediaCodec failed, codecName is null.");
            return false;
          }
        }
        else
        {
          if (2 == this.mDrmType)
          {
            localObject1 = TPUnitendCodecUtils.getSecureDecoderName(getMimeType());
            continue;
          }
          localObject1 = TPCodecUtils.getDecoderName(getMimeType(), false);
          continue;
        }
        this.mCodec = com.tencent.tmediacodec.b.bGq((String)localObject1);
        Object localObject2 = this.mCodec;
        if ((!this.mEnableMediaCodecReuse) || (this.mEnableAsyncMode)) {
          break label493;
        }
        bool = true;
        ((com.tencent.tmediacodec.b)localObject2).ahTa = bool;
        this.mCodec.ahSY = new com.tencent.tmediacodec.a.b()
        {
          public void onReuseCodecAPIException(String paramAnonymousString, Throwable paramAnonymousThrowable)
          {
            AppMethodBeat.i(227476);
            super.onReuseCodecAPIException(paramAnonymousString, paramAnonymousThrowable);
            TPMediaCodecManager.onMediaCodecException(TPBaseMediaCodecDecoder.this.mCodecId, paramAnonymousString);
            AppMethodBeat.o(227476);
          }
          
          public void onStarted(Boolean paramAnonymousBoolean, String paramAnonymousString)
          {
            AppMethodBeat.i(227467);
            super.onStarted(paramAnonymousBoolean, paramAnonymousString);
            TPMediaCodecManager.onMediaCodecReady(TPBaseMediaCodecDecoder.this.mCodecId, paramAnonymousString);
            AppMethodBeat.o(227467);
          }
        };
        TPNativeLog.printLog(2, getLogTag(), "initMediaCodec codec name: ".concat(String.valueOf(localObject1)));
        AsyncDecodeHandler localAsyncDecodeHandler;
        if ((this.mEnableAsyncMode) && (Build.VERSION.SDK_INT >= 23))
        {
          TPNativeLog.printLog(2, getLogTag(), "MediaCodec EnableAsyncMode！");
          this.mDecodeThread = new HandlerThread("MediaCodecThread");
          this.mDecodeThread.start();
          this.mDecoderHandler = new AsyncDecodeHandler(this.mDecodeThread.getLooper());
          localObject1 = this.mCodec;
          localObject2 = new BufferCallback(null);
          localAsyncDecodeHandler = this.mDecoderHandler;
          if (Build.VERSION.SDK_INT < 23) {
            com.tencent.tmediacodec.g.b.R("TMediaCodec");
          }
        }
        else
        {
          configCodec(this.mCodec);
          this.mCodec.start();
          this.mStarted = true;
          return true;
        }
        if (((com.tencent.tmediacodec.b)localObject1).ahSX == null) {
          continue;
        }
        MediaCodec localMediaCodec = ((com.tencent.tmediacodec.b)localObject1).ahSX.kcs();
        if (localMediaCodec == null) {
          continue;
        }
        localMediaCodec.setCallback(new b.c((com.tencent.tmediacodec.b)localObject1, (b.a)localObject2), localAsyncDecodeHandler);
        continue;
        bool = false;
      }
      catch (Exception localException)
      {
        TPNativeLog.printLog(4, getLogTag(), getStackTrace(localException));
        return false;
      }
      label488:
      continue;
      label493:
      boolean bool = false;
    }
  }
  
  private int onFlush()
  {
    this.mInputQueue.clear();
    this.mOutputQueue.clear();
    int i = handleFlush();
    this.mCodec.start();
    return i;
  }
  
  private int onMediaCodecException(Exception paramException)
  {
    TPNativeLog.printLog(4, getLogTag(), "onMediaCodecException!\n" + getStackTrace(paramException));
    resetFrameInfo();
    processMediaCodecException(paramException);
    if (this.mRestartCodecOnException)
    {
      initMediaCodecInternal();
      return 4;
    }
    release();
    return 103;
  }
  
  private int onRelease()
  {
    this.mInputQueue.clear();
    this.mOutputQueue.clear();
    return handleRelease();
  }
  
  private int onReleaseOutputBuffer(int paramInt, boolean paramBoolean)
  {
    return handleReleaseOutputBuffer(paramInt, paramBoolean);
  }
  
  private int onSetOutputSurface(Surface paramSurface)
  {
    return handleSetOutputSurface(paramSurface);
  }
  
  private int queueInputBuffer(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean)
  {
    Object localObject = this.mCodec;
    if (((com.tencent.tmediacodec.b)localObject).ahSX != null)
    {
      localObject = ((com.tencent.tmediacodec.b)localObject).ahSX.kcs();
      if (localObject == null) {}
    }
    for (localObject = ((MediaCodec)localObject).getInputBuffers();; localObject = null)
    {
      int i;
      try
      {
        i = this.mCodec.dequeueInputBuffer(MEDIA_CODEC_INPUT_TIMEOUT_US);
        if (i >= 0)
        {
          localObject[i].put(paramArrayOfByte);
          if ((paramBoolean) && (this.mCryptoInfo != null)) {
            this.mCodec.a(i, this.mCryptoInfo, paramLong, 0);
          } else {
            this.mCodec.a(i, paramArrayOfByte.length, paramLong, 0);
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        return onMediaCodecException(paramArrayOfByte);
      }
      if (i == -1) {
        return 1;
      }
      return 103;
      return 0;
    }
  }
  
  private int releaseAsync()
  {
    TPNativeLog.printLog(2, getLogTag(), "releaseAsync: ");
    Message localMessage = this.mDecoderHandler.obtainMessage();
    localMessage.what = 1003;
    int i = waitingForHandleMessage(localMessage);
    exitDecodeThread();
    return i;
  }
  
  private int releaseOutputBufferAsync(int paramInt, boolean paramBoolean)
  {
    Message localMessage = this.mDecoderHandler.obtainMessage();
    localMessage.what = 1000;
    localMessage.arg1 = paramInt;
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      localMessage.arg2 = paramInt;
      return waitingForHandleMessage(localMessage);
    }
  }
  
  private void resetFrameInfo()
  {
    this.mFrameInfo.bufferIndex = -1000;
    this.mFrameInfo.ptsUs = -1L;
    this.mFrameInfo.data = null;
    this.mFrameInfo.errCode = 103;
  }
  
  private MediaCodecInfo selectCodec(String paramString)
  {
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    while (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (!localMediaCodecInfo.isEncoder())
      {
        String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
        int m = arrayOfString.length;
        int j = 0;
        while (j < m)
        {
          if (arrayOfString[j].equalsIgnoreCase(paramString)) {
            return localMediaCodecInfo;
          }
          j += 1;
        }
      }
      i += 1;
    }
    return null;
  }
  
  private int setOutputSurfaceAsync(Surface paramSurface)
  {
    TPNativeLog.printLog(2, getLogTag(), "setOutputSurfaceAsync: ".concat(String.valueOf(paramSurface)));
    Message localMessage = this.mDecoderHandler.obtainMessage();
    localMessage.what = 1001;
    localMessage.obj = paramSurface;
    return waitingForHandleMessage(localMessage);
  }
  
  private int signalEndOfStreamAsync()
  {
    Integer localInteger = (Integer)this.mInputQueue.poll();
    if (localInteger == null) {
      return 1;
    }
    return handleSignalEndOfStream(localInteger.intValue());
  }
  
  private int waitingForHandleMessage(Message paramMessage)
  {
    synchronized (this.mThreadLock)
    {
      paramMessage.sendToTarget();
    }
    try
    {
      this.mThreadLock.wait();
      label18:
      return this.mHandlerResult;
      paramMessage = finally;
      throw paramMessage;
    }
    catch (InterruptedException paramMessage)
    {
      break label18;
    }
  }
  
  abstract void configCodec(com.tencent.tmediacodec.b paramb);
  
  public int decode(byte[] paramArrayOfByte, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    if ((!this.mStarted) || (this.mCodec == null)) {
      return 101;
    }
    if ((this.mEnableAsyncMode) && (Build.VERSION.SDK_INT >= 23)) {
      return decodeAsync(paramArrayOfByte, paramBoolean1, paramLong, paramBoolean2);
    }
    return queueInputBuffer(paramArrayOfByte, paramLong, paramBoolean2);
  }
  
  public TPFrameInfo dequeueOutputBuffer()
  {
    if (this.mCodec == null) {
      return this.mFrameInfo;
    }
    resetFrameInfo();
    if (this.mEnableAsyncMode) {
      return dequeueOutputBufferAsync();
    }
    MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
    for (;;)
    {
      int i;
      try
      {
        com.tencent.tmediacodec.b localb = this.mCodec;
        long l = MEDIA_CODEC_OUTPUT_TIMEOUT_US;
        if (localb.ahSX != null)
        {
          i = localb.ahSX.dequeueOutputBuffer(localBufferInfo, l);
          if (i < 0) {
            break label244;
          }
          if (localBufferInfo.flags == 4)
          {
            TPNativeLog.printLog(2, getLogTag(), "dequeueOutputBuffer: BUFFER_FLAG_END_OF_STREAM");
            this.mFrameInfo.errCode = 2;
            return this.mFrameInfo;
          }
        }
        else
        {
          i = -1000;
          continue;
        }
        if (localException.flags != 2) {
          break label198;
        }
      }
      catch (Exception localException)
      {
        this.mFrameInfo.errCode = onMediaCodecException(localException);
        return this.mFrameInfo;
      }
      if (this.mEnableAudioPassThrough)
      {
        TPNativeLog.printLog(2, getLogTag(), "dequeueOutputBuffer: BUFFER_FLAG_CODEC_CONFIG, AudioPassThrough");
        this.mFrameInfo.bufferIndex = i;
        this.mFrameInfo.ptsUs = localException.presentationTimeUs;
        processOutputConfigData(this.mCodec, i, localException, this.mFrameInfo);
      }
      else
      {
        label198:
        this.mFrameInfo.bufferIndex = i;
        this.mFrameInfo.ptsUs = localException.presentationTimeUs;
        this.mFrameInfo.errCode = 0;
        processOutputBuffer(this.mCodec, i, localException, this.mFrameInfo);
        continue;
        label244:
        Object localObject;
        if (i == -2)
        {
          localObject = this.mCodec;
          if (((com.tencent.tmediacodec.b)localObject).ahSX != null)
          {
            localObject = ((com.tencent.tmediacodec.b)localObject).ahSX.kcs();
            if (localObject == null) {}
          }
          for (localObject = ((MediaCodec)localObject).getOutputFormat();; localObject = null)
          {
            processOutputFormatChanged((MediaFormat)localObject);
            this.mFrameInfo.errCode = 1;
            break;
          }
        }
        if (i == -1)
        {
          this.mFrameInfo.errCode = 1;
        }
        else if (i == -3)
        {
          TPNativeLog.printLog(2, getLogTag(), "dequeueOutputBuffer: INFO_OUTPUT_BUFFERS_CHANGED!");
          this.mFrameInfo.errCode = 1;
        }
        else if (((MediaCodec.BufferInfo)localObject).flags == 4)
        {
          TPNativeLog.printLog(2, getLogTag(), "dequeueOutputBuffer: BUFFER_FLAG_END_OF_STREAM!");
          this.mFrameInfo.errCode = 2;
        }
        else
        {
          TPNativeLog.printLog(4, getLogTag(), "dequeueOutputBuffer: TP_ERROR_DECODE_FAILED! index = ".concat(String.valueOf(i)));
          this.mFrameInfo.errCode = 103;
        }
      }
    }
  }
  
  public int flush()
  {
    TPNativeLog.printLog(2, getLogTag(), "flush: ");
    if (this.mCodec == null) {
      return 104;
    }
    if (this.mEnableAsyncMode) {
      return flushAsync();
    }
    return handleFlush();
  }
  
  abstract String getLogTag();
  
  abstract String getMimeType();
  
  protected String getStackTrace(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    return localStringWriter.toString();
  }
  
  abstract void processMediaCodecException(Exception paramException);
  
  abstract void processOutputBuffer(com.tencent.tmediacodec.b paramb, int paramInt, MediaCodec.BufferInfo paramBufferInfo, TPFrameInfo paramTPFrameInfo);
  
  abstract void processOutputConfigData(com.tencent.tmediacodec.b paramb, int paramInt, MediaCodec.BufferInfo paramBufferInfo, TPFrameInfo paramTPFrameInfo);
  
  abstract void processOutputFormatChanged(MediaFormat paramMediaFormat);
  
  public int release()
  {
    if (this.mEnableAsyncMode) {
      return releaseAsync();
    }
    return handleRelease();
  }
  
  public int releaseOutputBuffer(int paramInt, boolean paramBoolean)
  {
    if ((this.mCodec == null) || (paramInt < 0)) {
      return 3;
    }
    if (this.mEnableAsyncMode) {
      return releaseOutputBufferAsync(paramInt, paramBoolean);
    }
    return handleReleaseOutputBuffer(paramInt, paramBoolean);
  }
  
  public void setCryptoInfo(int paramInt1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2)
  {
    if (this.mCryptoInfo == null) {
      this.mCryptoInfo = new MediaCodec.CryptoInfo();
    }
    this.mCryptoInfo.set(paramInt1, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfByte1, paramArrayOfByte2, paramInt2);
  }
  
  public int setOperateRate(float paramFloat)
  {
    if (this.mCodec != null) {}
    try
    {
      if (Build.VERSION.SDK_INT >= 19)
      {
        TPNativeLog.printLog(2, getLogTag(), "setOperateRate: ".concat(String.valueOf(paramFloat)));
        Bundle localBundle = new Bundle();
        localBundle.putShort("priority", (short)0);
        localBundle.putFloat("operating-rate", paramFloat);
        Object localObject = this.mCodec.ahSX;
        if (localObject != null)
        {
          localObject = ((c)localObject).kcs();
          if (localObject != null) {
            ((MediaCodec)localObject).setParameters(localBundle);
          }
        }
      }
      return 0;
    }
    catch (Exception localException)
    {
      TPNativeLog.printLog(3, getLogTag(), "setOperateRate: " + paramFloat + " failed.");
    }
    return 0;
  }
  
  public int setOutputSurface(Surface paramSurface)
  {
    if (this.mEnableAsyncMode) {
      return setOutputSurfaceAsync(paramSurface);
    }
    return handleSetOutputSurface(paramSurface);
  }
  
  public boolean setParamBool(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      TPNativeLog.printLog(3, getLogTag(), "Unknown paramKey: ".concat(String.valueOf(paramInt)));
      return false;
    case 0: 
      this.mEnableSetOutputSurfaceApi = paramBoolean;
    }
    for (;;)
    {
      return true;
      if (!this.mStarted)
      {
        this.mEnableAsyncMode = paramBoolean;
      }
      else
      {
        TPNativeLog.printLog(3, getLogTag(), "BOOL_ENABLE_ASYNC_MODE must setup before started!");
        continue;
        this.mEnableAudioPassThrough = paramBoolean;
        TPNativeLog.printLog(2, getLogTag(), "BOOL_SET_IS_AUDIO_PASSTHROUGH mEnableAudioPassThrough:" + this.mEnableAudioPassThrough);
        continue;
        this.mEnableMediaCodecReuse = paramBoolean;
      }
    }
  }
  
  public boolean setParamBytes(int paramInt, byte[] paramArrayOfByte)
  {
    return false;
  }
  
  public boolean setParamInt(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      TPNativeLog.printLog(3, getLogTag(), "Unknown paramKey: ".concat(String.valueOf(paramInt1)));
      return false;
    }
    this.mEnableRendererSharpen = paramInt2;
    return true;
  }
  
  public boolean setParamLong(int paramInt, long paramLong)
  {
    return false;
  }
  
  public boolean setParamObject(int paramInt, Object paramObject)
  {
    return false;
  }
  
  public boolean setParamString(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      TPNativeLog.printLog(3, getLogTag(), "Unknown paramKey: ".concat(String.valueOf(paramInt)));
      return false;
    }
    this.mSharpenShaderPath = paramString;
    return true;
  }
  
  public int setSharpenSwitch()
  {
    if (!this.mSwitchEnableRendererSharpen) {}
    for (boolean bool = true;; bool = false)
    {
      this.mSwitchEnableRendererSharpen = bool;
      return 0;
    }
  }
  
  public int signalEndOfStream()
  {
    TPNativeLog.printLog(2, getLogTag(), "signalEndOfStream: ");
    if (this.mCodec == null) {}
    int i;
    do
    {
      return 3;
      if (this.mEnableAsyncMode) {
        return signalEndOfStreamAsync();
      }
      i = this.mCodec.dequeueInputBuffer(MEDIA_CODEC_INPUT_TIMEOUT_US);
      if (i >= 0) {
        return handleSignalEndOfStream(i);
      }
    } while (i != -1);
    return 1;
  }
  
  public boolean startDecoder()
  {
    return initMediaCodecInternal();
  }
  
  class AsyncDecodeHandler
    extends Handler
  {
    AsyncDecodeHandler(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      boolean bool = false;
      int i = 0;
      AppMethodBeat.i(227488);
      for (;;)
      {
        synchronized (TPBaseMediaCodecDecoder.this.mThreadLock)
        {
          switch (paramMessage.what)
          {
          case 1000: 
            TPBaseMediaCodecDecoder.this.handleMessageComplete(i);
            AppMethodBeat.o(227488);
            return;
            TPBaseMediaCodecDecoder localTPBaseMediaCodecDecoder = TPBaseMediaCodecDecoder.this;
            i = paramMessage.arg1;
            if (paramMessage.arg2 == 1) {
              bool = true;
            }
            i = localTPBaseMediaCodecDecoder.onReleaseOutputBuffer(i, bool);
            break;
          case 1001: 
            i = TPBaseMediaCodecDecoder.this.onSetOutputSurface((Surface)paramMessage.obj);
            break;
          case 1002: 
            i = TPBaseMediaCodecDecoder.this.onFlush();
            break;
          case 1003: 
            i = TPBaseMediaCodecDecoder.this.onRelease();
          }
        }
      }
    }
  }
  
  class BufferCallback
    extends b.a
  {
    private BufferCallback() {}
    
    public void onError(com.tencent.tmediacodec.b paramb, MediaCodec.CodecException paramCodecException)
    {
      AppMethodBeat.i(227536);
      TPNativeLog.printLog(4, TPBaseMediaCodecDecoder.this.getLogTag(), "onError: " + TPBaseMediaCodecDecoder.this.getStackTrace(paramCodecException));
      TPBaseMediaCodecDecoder.this.handleRelease();
      AppMethodBeat.o(227536);
    }
    
    public void onInputBufferAvailable(com.tencent.tmediacodec.b paramb, int paramInt)
    {
      AppMethodBeat.i(227521);
      try
      {
        TPBaseMediaCodecDecoder.this.mInputQueue.put(Integer.valueOf(paramInt));
        AppMethodBeat.o(227521);
        return;
      }
      catch (Exception paramb)
      {
        TPNativeLog.printLog(3, TPBaseMediaCodecDecoder.this.getLogTag(), TPBaseMediaCodecDecoder.this.getStackTrace(paramb));
        AppMethodBeat.o(227521);
      }
    }
    
    public void onOutputBufferAvailable(com.tencent.tmediacodec.b paramb, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
    {
      AppMethodBeat.i(227529);
      try
      {
        TPFrameInfo localTPFrameInfo = new TPFrameInfo();
        localTPFrameInfo.errCode = 0;
        localTPFrameInfo.bufferIndex = paramInt;
        localTPFrameInfo.ptsUs = paramBufferInfo.presentationTimeUs;
        TPBaseMediaCodecDecoder.this.processOutputBuffer(paramb, paramInt, paramBufferInfo, localTPFrameInfo);
        TPBaseMediaCodecDecoder.this.mOutputQueue.put(localTPFrameInfo);
        AppMethodBeat.o(227529);
        return;
      }
      catch (Exception paramb)
      {
        TPNativeLog.printLog(3, TPBaseMediaCodecDecoder.this.getLogTag(), TPBaseMediaCodecDecoder.this.getStackTrace(paramb));
        AppMethodBeat.o(227529);
      }
    }
    
    public void onOutputFormatChanged(com.tencent.tmediacodec.b paramb, MediaFormat paramMediaFormat)
    {
      AppMethodBeat.i(227543);
      TPBaseMediaCodecDecoder.this.processOutputFormatChanged(paramMediaFormat);
      AppMethodBeat.o(227543);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.core.decoder.TPBaseMediaCodecDecoder
 * JD-Core Version:    0.7.0.1
 */