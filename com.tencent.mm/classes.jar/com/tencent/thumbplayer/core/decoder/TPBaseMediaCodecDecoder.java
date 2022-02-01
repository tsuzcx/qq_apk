package com.tencent.thumbplayer.core.decoder;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.Callback;
import android.media.MediaCodec.CodecException;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPNativeLog;
import com.tencent.thumbplayer.core.common.TPUnitendCodecUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public abstract class TPBaseMediaCodecDecoder
  implements ITPMediaCodecDecoder
{
  private static final int MEDIA_CODEC_ERROR_INDEX = -1000;
  private static long MEDIA_CODEC_INPUT_TIMEOUT_US = 10000L;
  private static long MEDIA_CODEC_OUTPUT_TIMEOUT_US = 10000L;
  private static final int MSG_FLUSH = 1002;
  private static final int MSG_RELEASE = 1003;
  private static final int MSG_RELEASE_OUTPUT_BUFFER = 1000;
  private static final int MSG_SET_OUTPUT_SURFACE = 1001;
  private MediaCodec mCodec = null;
  private MediaCodec.CryptoInfo mCryptoInfo = null;
  private HandlerThread mDecodeThread = null;
  private AsyncDecodeHandler mDecoderHandler = null;
  protected int mDrmType = -1;
  private boolean mEnableAsyncMode = false;
  private boolean mEnableAudioPassThrough = false;
  private boolean mEnableSetOutputSurfaceApi = false;
  private TPFrameInfo mFrameInfo = new TPFrameInfo();
  private int mHandlerResult = 0;
  private BlockingQueue<Integer> mInputQueue = new LinkedBlockingQueue();
  private BlockingQueue<TPFrameInfo> mOutputQueue = new LinkedBlockingQueue();
  private boolean mRestartCodecOnException = false;
  private boolean mStarted = false;
  protected Surface mSurface = null;
  private final Object mThreadLock = new Object();
  
  private int decodeAsync(byte[] paramArrayOfByte, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    Object localObject1 = (Integer)this.mInputQueue.poll();
    if (localObject1 == null) {
      return 1;
    }
    for (;;)
    {
      try
      {
        Object localObject2 = this.mCodec.getInputBuffer(((Integer)localObject1).intValue());
        if (localObject2 != null) {
          ((ByteBuffer)localObject2).put(paramArrayOfByte);
        }
        int j;
        if ((paramBoolean2) && (this.mCryptoInfo != null))
        {
          paramArrayOfByte = this.mCodec;
          j = ((Integer)localObject1).intValue();
          localObject1 = this.mCryptoInfo;
          if (!paramBoolean1) {
            break label154;
          }
          i = 1;
          paramArrayOfByte.queueSecureInputBuffer(j, 0, (MediaCodec.CryptoInfo)localObject1, paramLong, i);
        }
        else
        {
          localObject2 = this.mCodec;
          j = ((Integer)localObject1).intValue();
          int k = paramArrayOfByte.length;
          if (paramBoolean1)
          {
            i = 1;
            ((MediaCodec)localObject2).queueInputBuffer(j, 0, k, paramLong, i);
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
      label154:
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
      this.mCodec.flush();
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
      this.mCodec.stop();
      this.mCodec.release();
      return 0;
    }
    catch (Exception localException)
    {
      TPNativeLog.printLog(4, getLogTag(), "release: failed!" + getStackTrace(localException));
      return 3;
    }
    finally
    {
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
    Surface localSurface;
    do
    {
      return 0;
      localSurface = this.mSurface;
      this.mSurface = paramSurface;
    } while (this.mCodec == null);
    if ((localSurface != null) && (paramSurface != null)) {
      try
      {
        if ((paramSurface.isValid()) && (Build.VERSION.SDK_INT >= 23) && (this.mEnableSetOutputSurfaceApi))
        {
          this.mCodec.setOutputSurface(paramSurface);
          return 0;
        }
      }
      catch (Exception paramSurface)
      {
        return onMediaCodecException(paramSurface);
      }
    }
    this.mCodec.stop();
    this.mCodec.release();
    initMediaCodecInternal();
    return 4;
  }
  
  private int handleSignalEndOfStream(int paramInt)
  {
    try
    {
      this.mCodec.queueInputBuffer(paramInt, 0, 0, 0L, 4);
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
    try
    {
      Object localObject = selectCodec(getMimeType());
      if (localObject == null)
      {
        TPNativeLog.printLog(3, getLogTag(), "initMediaCodec failed! no such codec by mime type: " + getMimeType());
        return false;
      }
      if (getMimeType().equals("audio/vnd.dts"))
      {
        TPNativeLog.printLog(2, getLogTag(), "initMediaCodec current mime type:" + getMimeType() + " is audio dts, need set input timeout to 0!");
        MEDIA_CODEC_INPUT_TIMEOUT_US = 0L;
        MEDIA_CODEC_OUTPUT_TIMEOUT_US = 0L;
      }
      if (2 == this.mDrmType) {}
      for (localObject = TPUnitendCodecUtils.getSecureDecoderName(getMimeType());; localObject = ((MediaCodecInfo)localObject).getName())
      {
        this.mCodec = MediaCodec.createByCodecName((String)localObject);
        TPNativeLog.printLog(2, getLogTag(), "initMediaCodec codec name: ".concat(String.valueOf(localObject)));
        if ((this.mEnableAsyncMode) && (Build.VERSION.SDK_INT >= 23))
        {
          TPNativeLog.printLog(2, getLogTag(), "MediaCodec EnableAsyncMode！");
          this.mDecodeThread = new HandlerThread("MediaCodecThread");
          this.mDecodeThread.start();
          this.mDecoderHandler = new AsyncDecodeHandler(this.mDecodeThread.getLooper());
          this.mCodec.setCallback(new BufferCallback(null), this.mDecoderHandler);
        }
        configCodec(this.mCodec);
        this.mCodec.start();
        this.mStarted = true;
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      TPNativeLog.printLog(4, getLogTag(), getStackTrace(localException));
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
    ByteBuffer[] arrayOfByteBuffer = this.mCodec.getInputBuffers();
    int i = 103;
    int j;
    try
    {
      j = this.mCodec.dequeueInputBuffer(MEDIA_CODEC_INPUT_TIMEOUT_US);
      if (j >= 0)
      {
        arrayOfByteBuffer[j].put(paramArrayOfByte);
        if ((paramBoolean) && (this.mCryptoInfo != null)) {
          this.mCodec.queueSecureInputBuffer(j, 0, this.mCryptoInfo, paramLong, 0);
        } else {
          this.mCodec.queueInputBuffer(j, 0, paramArrayOfByte.length, paramLong, 0);
        }
      }
    }
    catch (Exception paramArrayOfByte)
    {
      return onMediaCodecException(paramArrayOfByte);
    }
    if (j == -1)
    {
      return 1;
      i = 0;
    }
    return i;
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
  
  abstract void configCodec(MediaCodec paramMediaCodec);
  
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
        i = this.mCodec.dequeueOutputBuffer(localBufferInfo, MEDIA_CODEC_OUTPUT_TIMEOUT_US);
        if (i < 0) {
          break label208;
        }
        if (localBufferInfo.flags == 4)
        {
          TPNativeLog.printLog(2, getLogTag(), "dequeueOutputBuffer: BUFFER_FLAG_END_OF_STREAM");
          this.mFrameInfo.errCode = 2;
          return this.mFrameInfo;
        }
      }
      catch (Exception localException)
      {
        this.mFrameInfo.errCode = onMediaCodecException(localException);
        return this.mFrameInfo;
      }
      if ((localException.flags == 2) && (this.mEnableAudioPassThrough))
      {
        TPNativeLog.printLog(2, getLogTag(), "dequeueOutputBuffer: BUFFER_FLAG_CODEC_CONFIG, AudioPassThrough");
        this.mFrameInfo.bufferIndex = i;
        this.mFrameInfo.ptsUs = localException.presentationTimeUs;
        processOutputConfigData(this.mCodec, i, localException, this.mFrameInfo);
      }
      else
      {
        this.mFrameInfo.bufferIndex = i;
        this.mFrameInfo.ptsUs = localException.presentationTimeUs;
        this.mFrameInfo.errCode = 0;
        processOutputBuffer(this.mCodec, i, localException, this.mFrameInfo);
        continue;
        label208:
        if (i == -2)
        {
          processOutputFormatChanged(this.mCodec.getOutputFormat());
          this.mFrameInfo.errCode = 1;
        }
        else if (i == -1)
        {
          this.mFrameInfo.errCode = 1;
        }
        else if (i == -3)
        {
          TPNativeLog.printLog(2, getLogTag(), "dequeueOutputBuffer: INFO_OUTPUT_BUFFERS_CHANGED!");
          this.mFrameInfo.errCode = 1;
        }
        else if (localException.flags == 4)
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
  
  abstract void processOutputBuffer(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo, TPFrameInfo paramTPFrameInfo);
  
  abstract void processOutputConfigData(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo, TPFrameInfo paramTPFrameInfo);
  
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
      }
    }
  }
  
  public boolean setParamBytes(int paramInt, byte[] paramArrayOfByte)
  {
    return false;
  }
  
  public boolean setParamInt(int paramInt1, int paramInt2)
  {
    return false;
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
    return false;
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
      AppMethodBeat.i(220526);
      for (;;)
      {
        synchronized (TPBaseMediaCodecDecoder.this.mThreadLock)
        {
          switch (paramMessage.what)
          {
          case 1000: 
            TPBaseMediaCodecDecoder.this.handleMessageComplete(i);
            AppMethodBeat.o(220526);
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
    extends MediaCodec.Callback
  {
    private BufferCallback() {}
    
    public void onError(MediaCodec paramMediaCodec, MediaCodec.CodecException paramCodecException)
    {
      AppMethodBeat.i(220529);
      TPNativeLog.printLog(4, TPBaseMediaCodecDecoder.this.getLogTag(), "onError: " + TPBaseMediaCodecDecoder.this.getStackTrace(paramCodecException));
      TPBaseMediaCodecDecoder.this.handleRelease();
      AppMethodBeat.o(220529);
    }
    
    public void onInputBufferAvailable(MediaCodec paramMediaCodec, int paramInt)
    {
      AppMethodBeat.i(220527);
      try
      {
        TPBaseMediaCodecDecoder.this.mInputQueue.put(Integer.valueOf(paramInt));
        AppMethodBeat.o(220527);
        return;
      }
      catch (Exception paramMediaCodec)
      {
        TPNativeLog.printLog(3, TPBaseMediaCodecDecoder.this.getLogTag(), TPBaseMediaCodecDecoder.this.getStackTrace(paramMediaCodec));
        AppMethodBeat.o(220527);
      }
    }
    
    public void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
    {
      AppMethodBeat.i(220528);
      try
      {
        TPFrameInfo localTPFrameInfo = new TPFrameInfo();
        localTPFrameInfo.errCode = 0;
        localTPFrameInfo.bufferIndex = paramInt;
        localTPFrameInfo.ptsUs = paramBufferInfo.presentationTimeUs;
        TPBaseMediaCodecDecoder.this.processOutputBuffer(paramMediaCodec, paramInt, paramBufferInfo, localTPFrameInfo);
        TPBaseMediaCodecDecoder.this.mOutputQueue.put(localTPFrameInfo);
        AppMethodBeat.o(220528);
        return;
      }
      catch (Exception paramMediaCodec)
      {
        TPNativeLog.printLog(3, TPBaseMediaCodecDecoder.this.getLogTag(), TPBaseMediaCodecDecoder.this.getStackTrace(paramMediaCodec));
        AppMethodBeat.o(220528);
      }
    }
    
    public void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
    {
      AppMethodBeat.i(220530);
      TPBaseMediaCodecDecoder.this.processOutputFormatChanged(paramMediaFormat);
      AppMethodBeat.o(220530);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.thumbplayer.core.decoder.TPBaseMediaCodecDecoder
 * JD-Core Version:    0.7.0.1
 */