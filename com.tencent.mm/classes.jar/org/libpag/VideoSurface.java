package org.libpag;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class VideoSurface
  implements SurfaceTexture.OnFrameAvailableListener
{
  private static int HandlerThreadCount;
  private static final Object handlerLock;
  private static HandlerThread handlerThread;
  private boolean frameAvailable;
  private final Object frameSyncObject;
  private int height;
  private Surface outputSurface;
  private boolean released;
  private SurfaceTexture surfaceTexture;
  private int width;
  
  static
  {
    AppMethodBeat.i(187394);
    HandlerThreadCount = 0;
    handlerLock = new Object();
    AppMethodBeat.o(187394);
  }
  
  public VideoSurface()
  {
    AppMethodBeat.i(187320);
    this.width = 0;
    this.height = 0;
    this.frameSyncObject = new Object();
    this.frameAvailable = false;
    this.released = false;
    AppMethodBeat.o(187320);
  }
  
  private static VideoSurface Make(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187345);
    VideoSurface localVideoSurface = new VideoSurface();
    localVideoSurface.width = paramInt1;
    localVideoSurface.height = paramInt2;
    for (;;)
    {
      synchronized (handlerLock)
      {
        StartHandlerThread();
        if (Build.VERSION.SDK_INT >= 26)
        {
          localVideoSurface.surfaceTexture = new SurfaceTexture(false);
          if (Build.VERSION.SDK_INT >= 21)
          {
            localVideoSurface.surfaceTexture.setOnFrameAvailableListener(localVideoSurface, new Handler(handlerThread.getLooper()));
            localVideoSurface.outputSurface = new Surface(localVideoSurface.surfaceTexture);
            AppMethodBeat.o(187345);
            return localVideoSurface;
          }
        }
        else
        {
          localVideoSurface.surfaceTexture = new SurfaceTexture(0);
          localVideoSurface.surfaceTexture.detachFromGLContext();
        }
      }
      localOnFrameAvailableListener.surfaceTexture.setOnFrameAvailableListener(localOnFrameAvailableListener);
      localOnFrameAvailableListener.reflectLooper();
    }
  }
  
  private static void StartHandlerThread()
  {
    try
    {
      AppMethodBeat.i(187330);
      HandlerThreadCount += 1;
      if (handlerThread == null)
      {
        HandlerThread localHandlerThread = new HandlerThread("libpag_VideoSurface");
        handlerThread = localHandlerThread;
        localHandlerThread.start();
      }
      AppMethodBeat.o(187330);
      return;
    }
    finally {}
  }
  
  private boolean attachToGLContext(int paramInt)
  {
    AppMethodBeat.i(187386);
    try
    {
      this.surfaceTexture.attachToGLContext(paramInt);
      AppMethodBeat.o(187386);
      return true;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(187386);
    }
    return false;
  }
  
  private Surface getOutputSurface()
  {
    return this.outputSurface;
  }
  
  private void onRelease()
  {
    AppMethodBeat.i(187391);
    if (this.released)
    {
      AppMethodBeat.o(187391);
      return;
    }
    this.released = true;
    synchronized (handlerLock)
    {
      int i = HandlerThreadCount - 1;
      HandlerThreadCount = i;
      if (i == 0)
      {
        handlerThread.quit();
        handlerThread = null;
      }
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
      AppMethodBeat.o(187391);
      return;
    }
  }
  
  private void reflectLooper()
  {
    AppMethodBeat.i(187353);
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
        AppMethodBeat.o(187353);
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
        AppMethodBeat.o(187353);
        return;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(187353);
        return;
      }
      Object localObject2 = null;
    }
  }
  
  private boolean updateTexImage()
  {
    AppMethodBeat.i(187379);
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
        AppMethodBeat.o(187379);
        return false;
      }
    }
    try
    {
      this.surfaceTexture.updateTexImage();
      AppMethodBeat.o(187379);
      return true;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(187379);
    }
    localObject2 = finally;
    AppMethodBeat.o(187379);
    throw localObject2;
    return false;
  }
  
  private int videoHeight()
  {
    AppMethodBeat.i(187372);
    float[] arrayOfFloat = new float[16];
    this.surfaceTexture.getTransformMatrix(arrayOfFloat);
    float f = Math.abs(arrayOfFloat[5]);
    if (f > 0.0F)
    {
      i = Math.round(this.height / ((arrayOfFloat[13] - f) * 2.0F + f));
      AppMethodBeat.o(187372);
      return i;
    }
    int i = this.height;
    AppMethodBeat.o(187372);
    return i;
  }
  
  private int videoWidth()
  {
    AppMethodBeat.i(187367);
    float[] arrayOfFloat = new float[16];
    this.surfaceTexture.getTransformMatrix(arrayOfFloat);
    float f = Math.abs(arrayOfFloat[0]);
    if (f > 0.0F)
    {
      i = Math.round(this.width / (arrayOfFloat[12] * 2.0F + f));
      AppMethodBeat.o(187367);
      return i;
    }
    int i = this.width;
    AppMethodBeat.o(187367);
    return i;
  }
  
  public void onFrameAvailable(SurfaceTexture arg1)
  {
    AppMethodBeat.i(187402);
    synchronized (this.frameSyncObject)
    {
      if (this.frameAvailable)
      {
        new RuntimeException("frameAvailable already set, frame could be dropped");
        AppMethodBeat.o(187402);
        return;
      }
      this.frameAvailable = true;
      this.frameSyncObject.notifyAll();
      AppMethodBeat.o(187402);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.libpag.VideoSurface
 * JD-Core Version:    0.7.0.1
 */