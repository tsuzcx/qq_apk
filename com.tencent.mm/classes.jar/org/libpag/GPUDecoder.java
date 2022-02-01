package org.libpag;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

public class GPUDecoder
{
  private static final int DECODER_THREAD_MAX_COUNT = 10;
  private static final int END_OF_STREAM = -3;
  private static final int ERROR = -2;
  private static final int INIT_DECODER_TIMEOUT_MS = 2000;
  private static final int SUCCESS = 0;
  private static final int TIMEOUT_US = 1000;
  private static final int TRY_AGAIN_LATER = -1;
  private static final AtomicInteger decoderThreadCount;
  private MediaCodec.BufferInfo bufferInfo;
  private MediaCodec decoder;
  private boolean disableFlush;
  private int lastOutputBufferIndex;
  private Surface outputSurface;
  private boolean released;
  
  static
  {
    AppMethodBeat.i(187519);
    decoderThreadCount = new AtomicInteger();
    AppMethodBeat.o(187519);
  }
  
  public GPUDecoder()
  {
    AppMethodBeat.i(187363);
    this.outputSurface = null;
    this.disableFlush = true;
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.lastOutputBufferIndex = -1;
    this.released = false;
    AppMethodBeat.o(187363);
  }
  
  private static GPUDecoder Create(Surface paramSurface)
  {
    AppMethodBeat.i(187369);
    if (forceSoftwareDecoder())
    {
      AppMethodBeat.o(187369);
      return null;
    }
    GPUDecoder localGPUDecoder = new GPUDecoder();
    localGPUDecoder.outputSurface = paramSurface;
    AppMethodBeat.o(187369);
    return localGPUDecoder;
  }
  
  private int dequeueInputBuffer()
  {
    AppMethodBeat.i(187401);
    try
    {
      int i = this.decoder.dequeueInputBuffer(1000L);
      AppMethodBeat.o(187401);
      return i;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(187401);
      return -1;
    }
    catch (Error localError)
    {
      label24:
      break label24;
    }
  }
  
  private int dequeueOutputBuffer()
  {
    AppMethodBeat.i(187393);
    try
    {
      int i = this.decoder.dequeueOutputBuffer(this.bufferInfo, 1000L);
      AppMethodBeat.o(187393);
      return i;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(187393);
    }
    return -1;
  }
  
  private static boolean forceSoftwareDecoder()
  {
    return Build.VERSION.SDK_INT < 21;
  }
  
  private ByteBuffer getInputBuffer(int paramInt)
  {
    AppMethodBeat.i(187405);
    try
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        localByteBuffer = this.decoder.getInputBuffer(paramInt);
        AppMethodBeat.o(187405);
        return localByteBuffer;
      }
      ByteBuffer localByteBuffer = this.decoder.getInputBuffers()[paramInt];
      AppMethodBeat.o(187405);
      return localByteBuffer;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(187405);
      return null;
    }
    catch (Error localError)
    {
      label47:
      break label47;
    }
  }
  
  private boolean initDecoder(final MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(187388);
    if (decoderThreadCount.get() >= 10)
    {
      AppMethodBeat.o(187388);
      return false;
    }
    decoderThreadCount.getAndIncrement();
    HandlerThread localHandlerThread = new HandlerThread("libpag_GPUDecoder_init_decoder");
    localHandlerThread.start();
    SynchronizeHandler localSynchronizeHandler = new SynchronizeHandler(localHandlerThread.getLooper());
    final MediaCodec[] arrayOfMediaCodec = new MediaCodec[1];
    arrayOfMediaCodec[0] = null;
    boolean bool = localSynchronizeHandler.runSync(new SynchronizeHandler.TimeoutRunnable()
    {
      private MediaCodec decoder;
      private long startTime;
      
      public void afterRun(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(187460);
        long l1;
        long l2;
        if ((paramAnonymousBoolean) && (this.decoder != null))
        {
          l1 = SystemClock.uptimeMillis();
          l2 = this.startTime;
        }
        try
        {
          this.decoder.stop();
          try
          {
            label33:
            this.decoder.release();
            label40:
            this.decoder = null;
            new RuntimeException("init decoder timeout. cost: " + (l1 - l2) + "ms");
            if (!paramAnonymousBoolean) {
              arrayOfMediaCodec[0] = this.decoder;
            }
            GPUDecoder.decoderThreadCount.getAndDecrement();
            AppMethodBeat.o(187460);
            return;
          }
          catch (Exception localException1)
          {
            break label40;
          }
        }
        catch (Exception localException2)
        {
          break label33;
        }
      }
      
      public void run()
      {
        AppMethodBeat.i(187452);
        this.startTime = SystemClock.uptimeMillis();
        try
        {
          this.decoder = MediaCodec.createDecoderByType(paramMediaFormat.getString("mime"));
          this.decoder.configure(paramMediaFormat, GPUDecoder.this.outputSurface, null, 0);
          this.decoder.start();
          AppMethodBeat.o(187452);
          return;
        }
        catch (Exception localException)
        {
          if (this.decoder != null)
          {
            this.decoder.release();
            this.decoder = null;
          }
          AppMethodBeat.o(187452);
        }
      }
    }, 2000L);
    localHandlerThread.quitSafely();
    if (bool)
    {
      this.decoder = arrayOfMediaCodec[0];
      if (this.decoder != null)
      {
        AppMethodBeat.o(187388);
        return true;
      }
      AppMethodBeat.o(187388);
      return false;
    }
    AppMethodBeat.o(187388);
    return false;
  }
  
  private boolean onConfigure(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(187381);
    if (this.outputSurface == null)
    {
      AppMethodBeat.o(187381);
      return false;
    }
    boolean bool = initDecoder(paramMediaFormat);
    AppMethodBeat.o(187381);
    return bool;
  }
  
  private int onDecodeFrame()
  {
    AppMethodBeat.i(187455);
    releaseOutputBuffer();
    try
    {
      int i = dequeueOutputBuffer();
      if ((this.bufferInfo.flags & 0x4) != 0)
      {
        if (i >= 0) {
          this.lastOutputBufferIndex = i;
        }
        AppMethodBeat.o(187455);
        return -3;
      }
      if (i >= 0) {
        this.lastOutputBufferIndex = i;
      }
      if (this.lastOutputBufferIndex != -1)
      {
        AppMethodBeat.o(187455);
        return 0;
      }
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(187455);
      return -2;
    }
    AppMethodBeat.o(187455);
    return -1;
  }
  
  private int onEndOfStream()
  {
    AppMethodBeat.i(187444);
    int i = dequeueInputBuffer();
    if (i >= 0)
    {
      i = queueInputBuffer(i, 0, 0, 0L, 4);
      AppMethodBeat.o(187444);
      return i;
    }
    AppMethodBeat.o(187444);
    return -1;
  }
  
  private void onFlush()
  {
    AppMethodBeat.i(187463);
    if (this.disableFlush)
    {
      AppMethodBeat.o(187463);
      return;
    }
    try
    {
      this.decoder.flush();
      this.bufferInfo = new MediaCodec.BufferInfo();
      this.lastOutputBufferIndex = -1;
      AppMethodBeat.o(187463);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(187463);
    }
  }
  
  private void onRelease()
  {
    AppMethodBeat.i(187482);
    if (this.released)
    {
      AppMethodBeat.o(187482);
      return;
    }
    this.released = true;
    releaseOutputBuffer();
    releaseDecoder();
    AppMethodBeat.o(187482);
  }
  
  private boolean onRenderFrame()
  {
    AppMethodBeat.i(187478);
    if (this.lastOutputBufferIndex != -1)
    {
      int i = releaseOutputBuffer(this.lastOutputBufferIndex, true);
      this.lastOutputBufferIndex = -1;
      if (i == 0)
      {
        AppMethodBeat.o(187478);
        return true;
      }
      AppMethodBeat.o(187478);
      return false;
    }
    AppMethodBeat.o(187478);
    return false;
  }
  
  private int onSendBytes(ByteBuffer paramByteBuffer, long paramLong)
  {
    AppMethodBeat.i(187437);
    int i = dequeueInputBuffer();
    if (i >= 0)
    {
      ByteBuffer localByteBuffer = getInputBuffer(i);
      if (localByteBuffer == null)
      {
        AppMethodBeat.o(187437);
        return -2;
      }
      localByteBuffer.clear();
      paramByteBuffer.position(0);
      localByteBuffer.put(paramByteBuffer);
      i = queueInputBuffer(i, 0, paramByteBuffer.limit(), paramLong, 0);
      AppMethodBeat.o(187437);
      return i;
    }
    AppMethodBeat.o(187437);
    return -1;
  }
  
  private long presentationTime()
  {
    return this.bufferInfo.presentationTimeUs;
  }
  
  private int queueInputBuffer(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    AppMethodBeat.i(187410);
    try
    {
      this.decoder.queueInputBuffer(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
      this.disableFlush = false;
      AppMethodBeat.o(187410);
      return 0;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(187410);
      return -2;
    }
    catch (Error localError)
    {
      label33:
      break label33;
    }
  }
  
  private void releaseAsync(final Runnable paramRunnable)
  {
    AppMethodBeat.i(187495);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(187495);
      return;
    }
    decoderThreadCount.getAndIncrement();
    final HandlerThread localHandlerThread = new HandlerThread("libpag_GPUDecoder_release_decoder");
    localHandlerThread.start();
    new Handler(localHandlerThread.getLooper()).post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(187433);
        paramRunnable.run();
        GPUDecoder.decoderThreadCount.getAndDecrement();
        new Handler(Looper.getMainLooper()).post(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(187319);
            GPUDecoder.3.this.val$releaseHandlerThread.quitSafely();
            AppMethodBeat.o(187319);
          }
        });
        AppMethodBeat.o(187433);
      }
    });
    AppMethodBeat.o(187495);
  }
  
  private void releaseDecoder()
  {
    AppMethodBeat.i(187488);
    if (this.decoder == null)
    {
      AppMethodBeat.o(187488);
      return;
    }
    releaseAsync(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(187453);
        try
        {
          GPUDecoder.this.decoder.stop();
          try
          {
            label15:
            GPUDecoder.this.decoder.release();
            label25:
            GPUDecoder.access$202(GPUDecoder.this, null);
            AppMethodBeat.o(187453);
            return;
          }
          catch (Exception localException1)
          {
            break label25;
          }
        }
        catch (Exception localException2)
        {
          break label15;
        }
      }
    });
    AppMethodBeat.o(187488);
  }
  
  private int releaseOutputBuffer(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(187427);
    try
    {
      this.decoder.releaseOutputBuffer(paramInt, paramBoolean);
      AppMethodBeat.o(187427);
      return 0;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(187427);
      return -2;
    }
    catch (Error localError)
    {
      label22:
      break label22;
    }
  }
  
  private void releaseOutputBuffer()
  {
    AppMethodBeat.i(187419);
    if (this.lastOutputBufferIndex != -1)
    {
      releaseOutputBuffer(this.lastOutputBufferIndex, false);
      this.lastOutputBufferIndex = -1;
    }
    AppMethodBeat.o(187419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     org.libpag.GPUDecoder
 * JD-Core Version:    0.7.0.1
 */