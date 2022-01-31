package com.tencent.mm.plugin.mmsight.ui.cameraglview;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.EGLContextFactory;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import com.tencent.mm.sdk.platformtools.y;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public class MMSightCameraGLSurfaceView
  extends GLSurfaceView
{
  int fvY;
  int fvZ;
  private int fwt = 0;
  int fwu;
  b mrc = null;
  
  public MMSightCameraGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    getHolder().addCallback(this);
    try
    {
      getHolder().setType(2);
      setEGLContextFactory(new b());
      setEGLConfigChooser(new MMSightCameraGLSurfaceView.a(this));
      this.mrc = new b();
      setRenderer(this.mrc);
      setRenderMode(0);
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        try
        {
          getHolder().setType(1);
        }
        catch (Exception paramContext)
        {
          try
          {
            getHolder().setType(0);
          }
          catch (Exception paramContext) {}
        }
      }
    }
  }
  
  public int getFrameHeight()
  {
    return this.fvZ;
  }
  
  public int getFrameRotate()
  {
    return this.fwu;
  }
  
  public int getFrameWidth()
  {
    return this.fvY;
  }
  
  public b getRenderer()
  {
    return this.mrc;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    super.surfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
    y.i("MicroMsg.MMSightCameraGLSurfaceView", "surfaceChanged, format: %s, w: %s, h: %s this: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), this });
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    super.surfaceCreated(paramSurfaceHolder);
    y.i("MicroMsg.MMSightCameraGLSurfaceView", "surfaceCreated: %s this: %s %s", new Object[] { paramSurfaceHolder, this, Integer.valueOf(getId()) });
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    super.surfaceDestroyed(paramSurfaceHolder);
    y.i("MicroMsg.MMSightCameraGLSurfaceView", "surfaceDestroyed: %s this: %s", new Object[] { paramSurfaceHolder, this });
  }
  
  final class b
    implements GLSurfaceView.EGLContextFactory
  {
    private int EGL_CONTEXT_CLIENT_VERSION = 12440;
    
    b() {}
    
    public final EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
    {
      y.w("MicroMsg.MMSightCameraGLSurfaceView", "creating OpenGL ES 2.0 context");
      int i = this.EGL_CONTEXT_CLIENT_VERSION;
      return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { i, 2, 12344 });
    }
    
    public final void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
    {
      paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.cameraglview.MMSightCameraGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */