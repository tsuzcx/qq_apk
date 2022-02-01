package org.libpag;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;

public class GPUDecoder
  implements SurfaceTexture.OnFrameAvailableListener
{
  private static final int END_OF_STREAM = -3;
  private static final int ERROR = -2;
  private static int HandlerThreadCount = 0;
  private static final int SUCCESS = 0;
  private static String TAG;
  private static final int TIMEOUT_US = 1000;
  private static final int TRY_AGAIN_LATER = -1;
  private static final Object handlerLock;
  private static HandlerThread handlerThread;
  private MediaCodec.BufferInfo bufferInfo;
  private MediaCodec decoder;
  private boolean frameAvailable;
  private final Object frameSyncObject;
  private int lastOutputBufferIndex;
  private MediaFormat outputFormat;
  private Surface outputSurface;
  private boolean released;
  private OutputFrame successFrame;
  private SurfaceTexture surfaceTexture;
  private int targetHeight;
  private int targetWidth;
  
  static
  {
    AppMethodBeat.i(216886);
    TAG = "MicroMsg.libpag.GPUDecoder";
    HandlerThreadCount = 0;
    handlerLock = new Object();
    AppMethodBeat.o(216886);
  }
  
  public GPUDecoder()
  {
    AppMethodBeat.i(216864);
    this.frameSyncObject = new Object();
    this.frameAvailable = false;
    this.outputFormat = null;
    this.targetWidth = 0;
    this.targetHeight = 0;
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.lastOutputBufferIndex = -1;
    this.successFrame = new OutputFrame(null);
    this.released = false;
    AppMethodBeat.o(216864);
  }
  
  private static GPUDecoder Create(int paramInt)
  {
    AppMethodBeat.i(216866);
    if (forceSoftwareDecoder())
    {
      AppMethodBeat.o(216866);
      return null;
    }
    GPUDecoder localGPUDecoder = new GPUDecoder();
    synchronized (handlerLock)
    {
      StartHandlerThread();
      localGPUDecoder.surfaceTexture = new SurfaceTexture(paramInt);
      if (Build.VERSION.SDK_INT >= 21)
      {
        localGPUDecoder.surfaceTexture.setOnFrameAvailableListener(localGPUDecoder, new Handler(handlerThread.getLooper()));
        new StringBuilder("Create GPUDecoder:").append(localGPUDecoder);
        localGPUDecoder.outputSurface = new Surface(localGPUDecoder.surfaceTexture);
        AppMethodBeat.o(216866);
        return localGPUDecoder;
      }
      localGPUDecoder.surfaceTexture.setOnFrameAvailableListener(localGPUDecoder);
      localGPUDecoder.reflectLooper();
    }
  }
  
  private static void StartHandlerThread()
  {
    try
    {
      AppMethodBeat.i(216865);
      HandlerThreadCount += 1;
      if (handlerThread == null)
      {
        HandlerThread localHandlerThread = new HandlerThread("libpag_GPUDecoder");
        handlerThread = localHandlerThread;
        localHandlerThread.start();
      }
      AppMethodBeat.o(216865);
      return;
    }
    finally {}
  }
  
  private boolean attachToGLContext(int paramInt)
  {
    AppMethodBeat.i(216885);
    if (this.surfaceTexture == null)
    {
      AppMethodBeat.o(216885);
      return false;
    }
    try
    {
      this.surfaceTexture.detachFromGLContext();
      this.surfaceTexture.attachToGLContext(paramInt);
      AppMethodBeat.o(216885);
      return true;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(216885);
    }
    return false;
  }
  
  private boolean awaitNewImage()
  {
    AppMethodBeat.i(216869);
    int i = 10;
    synchronized (this.frameSyncObject)
    {
      for (;;)
      {
        boolean bool = this.frameAvailable;
        if ((bool) || (i <= 0)) {
          break;
        }
        i -= 1;
        try
        {
          this.frameSyncObject.wait(50L);
        }
        catch (InterruptedException localInterruptedException) {}
      }
      this.frameAvailable = false;
      if (i == 0)
      {
        AppMethodBeat.o(216869);
        return false;
      }
    }
    try
    {
      this.surfaceTexture.updateTexImage();
      AppMethodBeat.o(216869);
      return true;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(216869);
    }
    localObject2 = finally;
    AppMethodBeat.o(216869);
    throw localObject2;
    return false;
  }
  
  private int dequeueInputBuffer()
  {
    AppMethodBeat.i(216874);
    try
    {
      int i = this.decoder.dequeueInputBuffer(1000L);
      AppMethodBeat.o(216874);
      return i;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(216874);
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
    AppMethodBeat.i(216873);
    try
    {
      int i = this.decoder.dequeueOutputBuffer(this.bufferInfo, 1000L);
      AppMethodBeat.o(216873);
      return i;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(216873);
    }
    return -1;
  }
  
  private static boolean forceSoftwareDecoder()
  {
    return Build.VERSION.SDK_INT < 21;
  }
  
  private ByteBuffer getInputBuffer(int paramInt)
  {
    AppMethodBeat.i(216875);
    try
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        localByteBuffer = this.decoder.getInputBuffer(paramInt);
        AppMethodBeat.o(216875);
        return localByteBuffer;
      }
      ByteBuffer localByteBuffer = this.decoder.getInputBuffers()[paramInt];
      AppMethodBeat.o(216875);
      return localByteBuffer;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(216875);
      return null;
    }
    catch (Error localError)
    {
      label47:
      break label47;
    }
  }
  
  private boolean onConfigure(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(216872);
    if (this.outputSurface == null)
    {
      AppMethodBeat.o(216872);
      return false;
    }
    this.targetWidth = paramMediaFormat.getInteger("width");
    this.targetHeight = paramMediaFormat.getInteger("height");
    this.outputFormat = paramMediaFormat;
    try
    {
      this.decoder = MediaCodec.createDecoderByType(paramMediaFormat.getString("mime"));
      this.decoder.configure(paramMediaFormat, this.outputSurface, null, 0);
      this.decoder.start();
      AppMethodBeat.o(216872);
      return true;
    }
    catch (Exception paramMediaFormat)
    {
      if (this.decoder != null)
      {
        this.decoder.release();
        this.decoder = null;
      }
      AppMethodBeat.o(216872);
    }
    return false;
  }
  
  private int onDecodeFrame()
  {
    AppMethodBeat.i(216881);
    releaseOutputBuffer();
    try
    {
      int i = dequeueOutputBuffer();
      if ((this.bufferInfo.flags & 0x4) != 0)
      {
        if (i >= 0) {
          this.lastOutputBufferIndex = i;
        }
        AppMethodBeat.o(216881);
        return -3;
      }
      if (i >= 0) {
        this.lastOutputBufferIndex = i;
      }
      while (this.lastOutputBufferIndex != -1)
      {
        AppMethodBeat.o(216881);
        return 0;
        if (i == -2) {
          this.outputFormat = this.decoder.getOutputFormat();
        }
      }
      AppMethodBeat.o(216881);
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(216881);
      return -2;
    }
    return -1;
  }
  
  private int onEndOfStream()
  {
    AppMethodBeat.i(216880);
    int i = dequeueInputBuffer();
    if (i >= 0)
    {
      i = queueInputBuffer(i, 0, 0, 0L, 4);
      AppMethodBeat.o(216880);
      return i;
    }
    AppMethodBeat.o(216880);
    return -1;
  }
  
  private void onFlush()
  {
    AppMethodBeat.i(216882);
    try
    {
      this.decoder.flush();
      this.bufferInfo = new MediaCodec.BufferInfo();
      this.lastOutputBufferIndex = -1;
      AppMethodBeat.o(216882);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(216882);
    }
  }
  
  private void onRelease()
  {
    AppMethodBeat.i(216884);
    if (this.released)
    {
      AppMethodBeat.o(216884);
      return;
    }
    new StringBuilder("Destroy GPUDecoder:").append(this);
    this.released = true;
    releaseOutputBuffer();
    synchronized (handlerLock)
    {
      int i = HandlerThreadCount - 1;
      HandlerThreadCount = i;
      if (i == 0)
      {
        handlerThread.quit();
        handlerThread = null;
      }
      if (this.decoder == null) {}
    }
    try
    {
      this.decoder.stop();
      try
      {
        label91:
        this.decoder.release();
        label98:
        this.decoder = null;
        if (this.outputSurface != null)
        {
          this.outputSurface.release();
          this.outputSurface = null;
        }
        if (this.surfaceTexture != null)
        {
          this.surfaceTexture.release();
          this.surfaceTexture = null;
        }
        AppMethodBeat.o(216884);
        return;
        localObject2 = finally;
        AppMethodBeat.o(216884);
        throw localObject2;
      }
      catch (Exception localException1)
      {
        break label98;
      }
    }
    catch (Exception localException2)
    {
      break label91;
    }
  }
  
  private OutputFrame onRenderFrame()
  {
    AppMethodBeat.i(216883);
    if (this.lastOutputBufferIndex != -1)
    {
      int i = releaseOutputBuffer(this.lastOutputBufferIndex, true);
      this.lastOutputBufferIndex = -1;
      if ((i == 0) && (awaitNewImage()))
      {
        OutputFrame localOutputFrame = this.successFrame;
        AppMethodBeat.o(216883);
        return localOutputFrame;
      }
    }
    AppMethodBeat.o(216883);
    return null;
  }
  
  private int onSendBytes(ByteBuffer paramByteBuffer, long paramLong)
  {
    AppMethodBeat.i(216879);
    int i = dequeueInputBuffer();
    if (i >= 0)
    {
      ByteBuffer localByteBuffer = getInputBuffer(i);
      if (localByteBuffer == null)
      {
        AppMethodBeat.o(216879);
        return -2;
      }
      localByteBuffer.clear();
      paramByteBuffer.position(0);
      localByteBuffer.put(paramByteBuffer);
      i = queueInputBuffer(i, 0, paramByteBuffer.limit(), paramLong, 0);
      AppMethodBeat.o(216879);
      return i;
    }
    AppMethodBeat.o(216879);
    return -1;
  }
  
  private long presentationTime()
  {
    return this.bufferInfo.presentationTimeUs;
  }
  
  private int queueInputBuffer(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    AppMethodBeat.i(216876);
    try
    {
      this.decoder.queueInputBuffer(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
      AppMethodBeat.o(216876);
      return 0;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(216876);
      return -2;
    }
    catch (Error localError)
    {
      label30:
      break label30;
    }
  }
  
  private void reflectLooper()
  {
    AppMethodBeat.i(216867);
    Object localObject3 = SurfaceTexture.class.getDeclaredClasses();
    int j = localObject3.length;
    int i = 0;
    Object localObject1;
    if (i < j)
    {
      localObject1 = localObject3[i];
      if (!localObject1.getName().toLowerCase().contains("handler")) {}
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        AppMethodBeat.o(216867);
        return;
        i += 1;
        break;
      }
      try
      {
        localObject1 = localObject1.getConstructor(new Class[] { SurfaceTexture.class, Looper.class }).newInstance(new Object[] { this.surfaceTexture, handlerThread.getLooper() });
        localObject3 = this.surfaceTexture.getClass().getDeclaredField("mEventHandler");
        ((Field)localObject3).setAccessible(true);
        ((Field)localObject3).set(this.surfaceTexture, localObject1);
        AppMethodBeat.o(216867);
        return;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(216867);
        return;
      }
      Object localObject2 = null;
    }
  }
  
  private int releaseOutputBuffer(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(216878);
    try
    {
      this.decoder.releaseOutputBuffer(paramInt, paramBoolean);
      AppMethodBeat.o(216878);
      return 0;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(216878);
      return -2;
    }
    catch (Error localError)
    {
      label24:
      break label24;
    }
  }
  
  private void releaseOutputBuffer()
  {
    AppMethodBeat.i(216877);
    if (this.lastOutputBufferIndex != -1)
    {
      releaseOutputBuffer(this.lastOutputBufferIndex, false);
      this.lastOutputBufferIndex = -1;
    }
    AppMethodBeat.o(216877);
  }
  
  private float videoHeight()
  {
    AppMethodBeat.i(216871);
    float[] arrayOfFloat = new float[16];
    this.surfaceTexture.getTransformMatrix(arrayOfFloat);
    float f = Math.abs(arrayOfFloat[5]);
    if (f > 0.0F)
    {
      f = this.targetHeight / f;
      AppMethodBeat.o(216871);
      return f;
    }
    f = this.targetHeight;
    AppMethodBeat.o(216871);
    return f;
  }
  
  private float videoWidth()
  {
    AppMethodBeat.i(216870);
    float[] arrayOfFloat = new float[16];
    this.surfaceTexture.getTransformMatrix(arrayOfFloat);
    float f = Math.abs(arrayOfFloat[0]);
    if (f > 0.0F)
    {
      f = this.targetWidth / f;
      AppMethodBeat.o(216870);
      return f;
    }
    f = this.targetWidth;
    AppMethodBeat.o(216870);
    return f;
  }
  
  public void onFrameAvailable(SurfaceTexture arg1)
  {
    AppMethodBeat.i(216868);
    synchronized (this.frameSyncObject)
    {
      if (this.frameAvailable)
      {
        new RuntimeException("frameAvailable already set, frame could be dropped");
        AppMethodBeat.o(216868);
        return;
      }
      this.frameAvailable = true;
      this.frameSyncObject.notifyAll();
      AppMethodBeat.o(216868);
      return;
    }
  }
  
  static class OutputFrame
  {
    public long[] data;
    public int[] lineSize;
    
    private OutputFrame()
    {
      AppMethodBeat.i(216863);
      this.data = new long[3];
      this.lineSize = new int[3];
      AppMethodBeat.o(216863);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.libpag.GPUDecoder
 * JD-Core Version:    0.7.0.1
 */