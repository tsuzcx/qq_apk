package com.tencent.ttpic.recorder;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.filter.h;
import com.tencent.filter.o;
import com.tencent.ttpic.VideoModuleConfig;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.util.g;
import com.tencent.view.f;
import java.io.IOException;
import java.nio.ByteBuffer;

@TargetApi(18)
public class ActVideoDecoder
{
  private static final String TAG = ActVideoDecoder.class.getSimpleName();
  private static final int TIMEOUT_MS = 2500;
  private static final int TIMEOUT_US = 10000;
  private MediaCodec.BufferInfo info = new MediaCodec.BufferInfo();
  private ByteBuffer[] inputBuffers;
  private volatile boolean isDecoding;
  private boolean isEOS = false;
  private long mCurFrameIndex = -1L;
  private MediaCodec mDecoder;
  private Surface mDecoderSurface;
  private int mDstTex;
  private long mDuration;
  private MediaExtractor mExtractor;
  private String mFilename;
  private h mFrame = new h();
  private boolean mFrameAvailable;
  private Handler mHandler;
  private boolean mHasNewFrame;
  private int mHeight;
  private final Object mInitLock = new Object();
  private boolean mInited;
  private long mLastFrameIndex = -1L;
  private o mSurfaceTexFilter = new o();
  private SurfaceTexture mSurfaceTexture;
  private int mTempTex;
  private final float[] mTransformMatrix = new float[16];
  private final Object mUpdateFrameLock = new Object();
  private int mWidth;
  
  public ActVideoDecoder(String arg1, int paramInt)
  {
    this.mFilename = ???;
    this.mDstTex = paramInt;
    this.mTempTex = f.cRo();
    this.mSurfaceTexFilter.ApplyGLSLFilter();
    this.mSurfaceTexFilter.nativeSetRotationAndFlip(0, 0, 1);
    ??? = new HandlerThread("ActVideoDecoder rt");
    ???.start();
    this.mHandler = new Handler(???.getLooper());
    this.mHandler.post(new ActVideoDecoder.1(this));
    synchronized (this.mInitLock)
    {
      for (;;)
      {
        boolean bool = this.mInited;
        if (bool) {
          break;
        }
        try
        {
          this.mInitLock.wait();
        }
        catch (InterruptedException localInterruptedException) {}
      }
      this.mDecoderSurface = new Surface(this.mSurfaceTexture);
      this.mExtractor = new MediaExtractor();
    }
    try
    {
      setExtractorDataSource(this.mExtractor, this.mFilename);
      prepare();
      return;
    }
    catch (IOException ???) {}
    localObject = finally;
    throw localObject;
  }
  
  private int decodeNext()
  {
    int j = -1;
    int k = 0;
    int i;
    if (this.mDecoder == null)
    {
      if (VideoModuleConfig.DEBUG) {
        throw new RuntimeException("ActVideoDecoder init fail!");
      }
    }
    else {
      i = 0;
    }
    label308:
    for (;;)
    {
      j = k;
      int m;
      if (!Thread.interrupted())
      {
        BenchUtil.benchStart("[decodeNext] dequeueInputBuffer");
        if (!this.isEOS)
        {
          j = this.mDecoder.dequeueInputBuffer(10000L);
          if (j >= 0)
          {
            ByteBuffer localByteBuffer = this.inputBuffers[j];
            m = this.mExtractor.readSampleData(localByteBuffer, 0);
            if (m >= 0) {
              break label233;
            }
            g.h(TAG, "extractor read sample to EOS");
            this.mDecoder.queueInputBuffer(j, 0, 0, 0L, 4);
            this.isEOS = true;
          }
        }
        BenchUtil.benchEnd("[decodeNext] dequeueInputBuffer");
        BenchUtil.benchStart("[decodeNext] wait");
        m = this.mDecoder.dequeueOutputBuffer(this.info, 10000L);
        BenchUtil.benchEnd("[decodeNext] wait");
        j = k;
        if ((this.info.flags & 0x4) == 0) {
          switch (m)
          {
          case -3: 
          case -2: 
          default: 
            this.mCurFrameIndex += 1L;
            if (this.mCurFrameIndex != this.mLastFrameIndex) {
              break;
            }
            this.mHasNewFrame = true;
            this.mDecoder.releaseOutputBuffer(m, true);
          }
        }
      }
      for (j = k;; j = -1)
      {
        return j;
        label233:
        this.mDecoder.queueInputBuffer(j, 0, m, this.mExtractor.getSampleTime(), 0);
        this.mExtractor.advance();
        break;
        j = i + 1;
        i = j;
        if (j <= 10) {
          break label308;
        }
        new StringBuilder("dequeueOutputBuffer timed out! eos = ").append(this.isEOS);
      }
      this.mDecoder.releaseOutputBuffer(m, false);
    }
  }
  
  private void prepare()
  {
    int i = 0;
    for (;;)
    {
      if (i < this.mExtractor.getTrackCount())
      {
        MediaFormat localMediaFormat = this.mExtractor.getTrackFormat(i);
        String str = localMediaFormat.getString("mime");
        if (str.startsWith("video/"))
        {
          this.mExtractor.selectTrack(i);
          g.h(TAG, "extractor video track selected");
          this.mWidth = localMediaFormat.getInteger("width");
          this.mHeight = localMediaFormat.getInteger("height");
          this.mDuration = (localMediaFormat.getLong("durationUs") / 1000L);
          g.h(TAG, "width = " + this.mWidth + ", height = " + this.mHeight + ", mDuration = " + this.mDuration);
          this.mDecoder = MediaCodec.createDecoderByType(str);
          localMediaFormat.setInteger("max-input-size", 0);
          this.mDecoder.configure(localMediaFormat, this.mDecoderSurface, null, 0);
        }
      }
      else
      {
        if (this.mDecoder != null) {
          break;
        }
        g.i(TAG, "Can't find video info!");
        return;
      }
      i += 1;
    }
    try
    {
      this.mDecoder.start();
      this.inputBuffers = this.mDecoder.getInputBuffers();
      label221:
      this.isEOS = false;
      return;
    }
    catch (Exception localException)
    {
      break label221;
    }
  }
  
  private static void setExtractorDataSource(MediaExtractor paramMediaExtractor, String paramString)
  {
    if (paramString.startsWith("assets://"))
    {
      paramString = paramString.substring(9);
      paramString = VideoGlobalContext.getContext().getAssets().openFd(paramString);
      paramMediaExtractor.setDataSource(paramString.getFileDescriptor(), paramString.getStartOffset(), paramString.getLength());
      paramString.close();
      return;
    }
    paramMediaExtractor.setDataSource(paramString);
  }
  
  public void decodeFrame(long paramLong)
  {
    if (this.mDecoderSurface == null) {
      throw new RuntimeException("You haven't set surfaceTexture?!");
    }
    if (paramLong <= this.mLastFrameIndex) {
      return;
    }
    this.mLastFrameIndex = paramLong;
    try
    {
      BenchUtil.benchStart(TAG + "[decodeNext]");
      decodeNext();
      BenchUtil.benchEnd(TAG + "[decodeNext]");
      return;
    }
    catch (Exception localException)
    {
      g.a(TAG, "decodeNext error: ", localException);
    }
  }
  
  public void decodeFrameAsync(long paramLong)
  {
    if (this.mDecoderSurface == null) {
      throw new RuntimeException("You haven't set surfaceTexture?!");
    }
    if ((this.isDecoding) || (paramLong <= this.mLastFrameIndex)) {
      return;
    }
    this.isDecoding = true;
    this.mLastFrameIndex = paramLong;
    this.mHandler.post(new ActVideoDecoder.2(this));
  }
  
  public long getDuration()
  {
    return this.mDuration;
  }
  
  public int getHeight()
  {
    return this.mHeight;
  }
  
  public int getWidth()
  {
    return this.mWidth;
  }
  
  public boolean isLive()
  {
    return this.mDecoder != null;
  }
  
  public void release()
  {
    f.Ku(this.mTempTex);
    this.mSurfaceTexFilter.clearGLSLSelf();
    this.mFrame.clear();
    if (this.mDecoderSurface != null) {
      this.mDecoderSurface.release();
    }
    if (this.mExtractor != null) {
      this.mExtractor.release();
    }
    if (this.mDecoder != null)
    {
      this.mDecoder.stop();
      this.mDecoder.release();
      g.g(TAG, "mDecoder stop and release");
      this.mDecoder = null;
    }
    if (this.mHandler != null)
    {
      this.mHandler.removeCallbacksAndMessages(null);
      this.mHandler.post(new ActVideoDecoder.4(this));
    }
  }
  
  public void reset()
  {
    try
    {
      if (this.mExtractor != null) {
        this.mExtractor.seekTo(0L, 0);
      }
      if (this.mDecoder != null) {
        this.mDecoder.flush();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (!TextUtils.isEmpty(localException.getMessage())) {
          g.h(TAG, localException.getMessage());
        }
      }
    }
    this.isEOS = false;
    this.mCurFrameIndex = -1L;
    this.mLastFrameIndex = -1L;
  }
  
  public void resetAsync()
  {
    if (this.mHandler != null) {
      this.mHandler.post(new ActVideoDecoder.3(this));
    }
  }
  
  public boolean updateFrame()
  {
    boolean bool1 = this.mHasNewFrame;
    if (this.mHasNewFrame)
    {
      BenchUtil.benchStart(TAG + "[updateFrame] wait");
      synchronized (this.mUpdateFrameLock)
      {
        for (;;)
        {
          boolean bool2 = this.mFrameAvailable;
          if (!bool2) {
            try
            {
              this.mUpdateFrameLock.wait(2500L);
              if (!this.mFrameAvailable) {
                throw new RuntimeException("frame wait timed out");
              }
            }
            catch (InterruptedException localInterruptedException)
            {
              throw new RuntimeException(localInterruptedException);
            }
          }
        }
      }
      this.mFrameAvailable = false;
      BenchUtil.benchEnd(TAG + "[updateFrame] wait");
      BenchUtil.benchStart(TAG + "[updateFrame] render");
    }
    try
    {
      this.mSurfaceTexture.updateTexImage();
      label165:
      this.mSurfaceTexture.getTransformMatrix(this.mTransformMatrix);
      this.mSurfaceTexFilter.nativeUpdateMatrix(this.mTransformMatrix);
      this.mSurfaceTexFilter.RenderProcess(this.mTempTex, getWidth(), getHeight(), this.mDstTex, 0.0D, this.mFrame);
      this.mHasNewFrame = false;
      BenchUtil.benchEnd(TAG + "[updateFrame] render");
      return bool1;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      break label165;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.recorder.ActVideoDecoder
 * JD-Core Version:    0.7.0.1
 */