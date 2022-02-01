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
    AppMethodBeat.i(220132);
    TAG = "MicroMsg.libpag.GPUDecoder";
    HandlerThreadCount = 0;
    handlerLock = new Object();
    AppMethodBeat.o(220132);
  }
  
  public GPUDecoder()
  {
    AppMethodBeat.i(220110);
    this.frameSyncObject = new Object();
    this.frameAvailable = false;
    this.outputFormat = null;
    this.targetWidth = 0;
    this.targetHeight = 0;
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.lastOutputBufferIndex = -1;
    this.successFrame = new OutputFrame(null);
    this.released = false;
    AppMethodBeat.o(220110);
  }
  
  private static GPUDecoder Create(int paramInt)
  {
    AppMethodBeat.i(220112);
    if (forceSoftwareDecoder())
    {
      AppMethodBeat.o(220112);
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
        AppMethodBeat.o(220112);
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
      AppMethodBeat.i(220111);
      HandlerThreadCount += 1;
      if (handlerThread == null)
      {
        HandlerThread localHandlerThread = new HandlerThread("libpag_GPUDecoder");
        handlerThread = localHandlerThread;
        localHandlerThread.start();
      }
      AppMethodBeat.o(220111);
      return;
    }
    finally {}
  }
  
  private boolean attachToGLContext(int paramInt)
  {
    AppMethodBeat.i(220131);
    if (this.surfaceTexture == null)
    {
      AppMethodBeat.o(220131);
      return false;
    }
    try
    {
      this.surfaceTexture.detachFromGLContext();
      this.surfaceTexture.attachToGLContext(paramInt);
      AppMethodBeat.o(220131);
      return true;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(220131);
    }
    return false;
  }
  
  private boolean awaitNewImage()
  {
    AppMethodBeat.i(220115);
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
        AppMethodBeat.o(220115);
        return false;
      }
    }
    try
    {
      this.surfaceTexture.updateTexImage();
      AppMethodBeat.o(220115);
      return true;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(220115);
    }
    localObject2 = finally;
    AppMethodBeat.o(220115);
    throw localObject2;
    return false;
  }
  
  private int dequeueInputBuffer()
  {
    AppMethodBeat.i(220120);
    try
    {
      int i = this.decoder.dequeueInputBuffer(1000L);
      AppMethodBeat.o(220120);
      return i;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(220120);
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
    AppMethodBeat.i(220119);
    try
    {
      int i = this.decoder.dequeueOutputBuffer(this.bufferInfo, 1000L);
      AppMethodBeat.o(220119);
      return i;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(220119);
    }
    return -1;
  }
  
  private static boolean forceSoftwareDecoder()
  {
    return Build.VERSION.SDK_INT < 21;
  }
  
  private ByteBuffer getInputBuffer(int paramInt)
  {
    AppMethodBeat.i(220121);
    try
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        localByteBuffer = this.decoder.getInputBuffer(paramInt);
        AppMethodBeat.o(220121);
        return localByteBuffer;
      }
      ByteBuffer localByteBuffer = this.decoder.getInputBuffers()[paramInt];
      AppMethodBeat.o(220121);
      return localByteBuffer;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(220121);
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
    AppMethodBeat.i(220118);
    if (this.outputSurface == null)
    {
      AppMethodBeat.o(220118);
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
      AppMethodBeat.o(220118);
      return true;
    }
    catch (Exception paramMediaFormat)
    {
      if (this.decoder != null)
      {
        this.decoder.release();
        this.decoder = null;
      }
      AppMethodBeat.o(220118);
    }
    return false;
  }
  
  private int onDecodeFrame()
  {
    AppMethodBeat.i(220127);
    releaseOutputBuffer();
    try
    {
      int i = dequeueOutputBuffer();
      if ((this.bufferInfo.flags & 0x4) != 0)
      {
        if (i >= 0) {
          this.lastOutputBufferIndex = i;
        }
        AppMethodBeat.o(220127);
        return -3;
      }
      if (i >= 0) {
        this.lastOutputBufferIndex = i;
      }
      while (this.lastOutputBufferIndex != -1)
      {
        AppMethodBeat.o(220127);
        return 0;
        if (i == -2) {
          this.outputFormat = this.decoder.getOutputFormat();
        }
      }
      AppMethodBeat.o(220127);
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(220127);
      return -2;
    }
    return -1;
  }
  
  private int onEndOfStream()
  {
    AppMethodBeat.i(220126);
    int i = dequeueInputBuffer();
    if (i >= 0)
    {
      i = queueInputBuffer(i, 0, 0, 0L, 4);
      AppMethodBeat.o(220126);
      return i;
    }
    AppMethodBeat.o(220126);
    return -1;
  }
  
  private void onFlush()
  {
    AppMethodBeat.i(220128);
    try
    {
      this.decoder.flush();
      this.bufferInfo = new MediaCodec.BufferInfo();
      this.lastOutputBufferIndex = -1;
      AppMethodBeat.o(220128);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(220128);
    }
  }
  
  private void onRelease()
  {
    AppMethodBeat.i(220130);
    if (this.released)
    {
      AppMethodBeat.o(220130);
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
        AppMethodBeat.o(220130);
        return;
        localObject2 = finally;
        AppMethodBeat.o(220130);
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
    AppMethodBeat.i(220129);
    if (this.lastOutputBufferIndex != -1)
    {
      int i = releaseOutputBuffer(this.lastOutputBufferIndex, true);
      this.lastOutputBufferIndex = -1;
      if ((i == 0) && (awaitNewImage()))
      {
        OutputFrame localOutputFrame = this.successFrame;
        AppMethodBeat.o(220129);
        return localOutputFrame;
      }
    }
    AppMethodBeat.o(220129);
    return null;
  }
  
  private int onSendBytes(ByteBuffer paramByteBuffer, long paramLong)
  {
    AppMethodBeat.i(220125);
    int i = dequeueInputBuffer();
    if (i >= 0)
    {
      ByteBuffer localByteBuffer = getInputBuffer(i);
      if (localByteBuffer == null)
      {
        AppMethodBeat.o(220125);
        return -2;
      }
      localByteBuffer.clear();
      paramByteBuffer.position(0);
      localByteBuffer.put(paramByteBuffer);
      i = queueInputBuffer(i, 0, paramByteBuffer.limit(), paramLong, 0);
      AppMethodBeat.o(220125);
      return i;
    }
    AppMethodBeat.o(220125);
    return -1;
  }
  
  private long presentationTime()
  {
    return this.bufferInfo.presentationTimeUs;
  }
  
  private int queueInputBuffer(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    AppMethodBeat.i(220122);
    try
    {
      this.decoder.queueInputBuffer(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
      AppMethodBeat.o(220122);
      return 0;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(220122);
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
    AppMethodBeat.i(220113);
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
        AppMethodBeat.o(220113);
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
        AppMethodBeat.o(220113);
        return;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(220113);
        return;
      }
      Object localObject2 = null;
    }
  }
  
  private int releaseOutputBuffer(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(220124);
    try
    {
      this.decoder.releaseOutputBuffer(paramInt, paramBoolean);
      AppMethodBeat.o(220124);
      return 0;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(220124);
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
    AppMethodBeat.i(220123);
    if (this.lastOutputBufferIndex != -1)
    {
      releaseOutputBuffer(this.lastOutputBufferIndex, false);
      this.lastOutputBufferIndex = -1;
    }
    AppMethodBeat.o(220123);
  }
  
  private float videoHeight()
  {
    AppMethodBeat.i(220117);
    float[] arrayOfFloat = new float[16];
    this.surfaceTexture.getTransformMatrix(arrayOfFloat);
    float f = Math.abs(arrayOfFloat[5]);
    if (f > 0.0F)
    {
      f = this.targetHeight / f;
      AppMethodBeat.o(220117);
      return f;
    }
    f = this.targetHeight;
    AppMethodBeat.o(220117);
    return f;
  }
  
  private float videoWidth()
  {
    AppMethodBeat.i(220116);
    float[] arrayOfFloat = new float[16];
    this.surfaceTexture.getTransformMatrix(arrayOfFloat);
    float f = Math.abs(arrayOfFloat[0]);
    if (f > 0.0F)
    {
      f = this.targetWidth / f;
      AppMethodBeat.o(220116);
      return f;
    }
    f = this.targetWidth;
    AppMethodBeat.o(220116);
    return f;
  }
  
  public void onFrameAvailable(SurfaceTexture arg1)
  {
    AppMethodBeat.i(220114);
    synchronized (this.frameSyncObject)
    {
      if (this.frameAvailable)
      {
        new RuntimeException("frameAvailable already set, frame could be dropped");
        AppMethodBeat.o(220114);
        return;
      }
      this.frameAvailable = true;
      this.frameSyncObject.notifyAll();
      AppMethodBeat.o(220114);
      return;
    }
  }
  
  static class OutputFrame
  {
    public long[] data;
    public int[] lineSize;
    
    private OutputFrame()
    {
      AppMethodBeat.i(220109);
      this.data = new long[3];
      this.lineSize = new int[3];
      AppMethodBeat.o(220109);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.libpag.GPUDecoder
 * JD-Core Version:    0.7.0.1
 */