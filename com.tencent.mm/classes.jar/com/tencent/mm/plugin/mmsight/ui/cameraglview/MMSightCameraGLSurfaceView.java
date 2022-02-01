package com.tencent.mm.plugin.mmsight.ui.cameraglview;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.opengl.GLSurfaceView.EGLContextFactory;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public class MMSightCameraGLSurfaceView
  extends GLSurfaceView
{
  int hwV;
  int jxn;
  int jxo;
  private int jxy;
  b wjD;
  
  public MMSightCameraGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94779);
    this.wjD = null;
    this.jxy = 0;
    getHolder().addCallback(this);
    try
    {
      getHolder().setType(2);
      setEGLContextFactory(new b());
      setEGLConfigChooser(new a());
      this.wjD = new b();
      setRenderer(this.wjD);
      setRenderMode(0);
      AppMethodBeat.o(94779);
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
  
  public final void al(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(94780);
    ae.i("MicroMsg.MMSightCameraGLSurfaceView", "setFrameInfo, width: %s, height: %s, rotate: %s this: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), this });
    this.jxn = paramInt1;
    this.jxo = paramInt2;
    this.hwV = paramInt3;
    AppMethodBeat.o(94780);
  }
  
  public final void amC()
  {
    AppMethodBeat.i(94782);
    if (this.wjD != null)
    {
      this.wjD.jxt = true;
      requestRender();
    }
    AppMethodBeat.o(94782);
  }
  
  public final void e(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(94781);
    if ((paramArrayOfByte != null) && (this.wjD != null) && (!this.wjD.jxm))
    {
      this.wjD.b(paramArrayOfByte, this.jxn, this.jxo, paramInt, paramBoolean);
      requestRender();
      AppMethodBeat.o(94781);
      return;
    }
    ae.v("MicroMsg.MMSightCameraGLSurfaceView", "passing draw");
    AppMethodBeat.o(94781);
  }
  
  public int getFrameHeight()
  {
    return this.jxo;
  }
  
  public int getFrameRotate()
  {
    return this.hwV;
  }
  
  public int getFrameWidth()
  {
    return this.jxn;
  }
  
  public b getRenderer()
  {
    return this.wjD;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(94785);
    super.surfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
    ae.i("MicroMsg.MMSightCameraGLSurfaceView", "surfaceChanged, format: %s, w: %s, h: %s this: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), this });
    AppMethodBeat.o(94785);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(94783);
    super.surfaceCreated(paramSurfaceHolder);
    ae.i("MicroMsg.MMSightCameraGLSurfaceView", "surfaceCreated: %s this: %s %s", new Object[] { paramSurfaceHolder, this, Integer.valueOf(getId()) });
    AppMethodBeat.o(94783);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(94784);
    super.surfaceDestroyed(paramSurfaceHolder);
    ae.i("MicroMsg.MMSightCameraGLSurfaceView", "surfaceDestroyed: %s this: %s", new Object[] { paramSurfaceHolder, this });
    AppMethodBeat.o(94784);
  }
  
  final class a
    implements GLSurfaceView.EGLConfigChooser
  {
    private int EGL_OPENGL_ES2_BIT;
    private int[] giU;
    protected int giV;
    protected int giW;
    protected int giX;
    protected int giY;
    protected int giZ;
    protected int gja;
    private int[] hqg;
    
    public a()
    {
      AppMethodBeat.i(94772);
      this.EGL_OPENGL_ES2_BIT = 4;
      this.hqg = new int[] { 12324, 4, 12323, 4, 12322, 4, 12352, this.EGL_OPENGL_ES2_BIT, 12344 };
      this.giU = new int[1];
      this.giV = 5;
      this.giW = 6;
      this.giX = 5;
      this.giY = 0;
      this.giZ = 0;
      this.gja = 0;
      AppMethodBeat.o(94772);
    }
    
    private int a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt)
    {
      AppMethodBeat.i(94775);
      if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt, this.giU))
      {
        paramInt = this.giU[0];
        AppMethodBeat.o(94775);
        return paramInt;
      }
      AppMethodBeat.o(94775);
      return 0;
    }
    
    private EGLConfig b(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
    {
      AppMethodBeat.i(94774);
      int j = paramArrayOfEGLConfig.length;
      int i = 0;
      while (i < j)
      {
        EGLConfig localEGLConfig = paramArrayOfEGLConfig[i];
        int k = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12325);
        int m = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12326);
        if ((k >= this.giZ) && (m >= this.gja))
        {
          k = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12324);
          m = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12323);
          int n = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12322);
          int i1 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12321);
          if ((k == this.giV) && (m == this.giW) && (n == this.giX) && (i1 == this.giY))
          {
            AppMethodBeat.o(94774);
            return localEGLConfig;
          }
        }
        i += 1;
      }
      AppMethodBeat.o(94774);
      return null;
    }
    
    private static void c(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
    {
      AppMethodBeat.i(94776);
      int k = paramArrayOfEGLConfig.length;
      ae.i("GLConfigChooser", String.format("%d configurations", new Object[] { Integer.valueOf(k) }));
      int i = 0;
      while (i < k)
      {
        ae.i("GLConfigChooser", String.format("Configuration %d:\n", new Object[] { Integer.valueOf(i) }));
        EGLConfig localEGLConfig = paramArrayOfEGLConfig[i];
        int[] arrayOfInt = new int[1];
        int j = 0;
        while (j < 33)
        {
          paramEGL10.eglGetConfigAttrib(paramEGLDisplay, localEGLConfig, new int[] { 12320, 12321, 12322, 12323, 12324, 12325, 12326, 12327, 12328, 12329, 12330, 12331, 12332, 12333, 12334, 12335, 12336, 12337, 12338, 12339, 12340, 12343, 12342, 12341, 12345, 12346, 12347, 12348, 12349, 12350, 12351, 12352, 12354 }[j], arrayOfInt);
          j += 1;
        }
        i += 1;
      }
      AppMethodBeat.o(94776);
    }
    
    public final EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
    {
      AppMethodBeat.i(94773);
      int[] arrayOfInt = new int[1];
      paramEGL10.eglChooseConfig(paramEGLDisplay, this.hqg, null, 0, arrayOfInt);
      int i = arrayOfInt[0];
      if (i <= 0)
      {
        paramEGL10 = new IllegalArgumentException("No configs match configSpec");
        AppMethodBeat.o(94773);
        throw paramEGL10;
      }
      EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
      paramEGL10.eglChooseConfig(paramEGLDisplay, this.hqg, arrayOfEGLConfig, i, arrayOfInt);
      c(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
      paramEGL10 = b(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
      AppMethodBeat.o(94773);
      return paramEGL10;
    }
  }
  
  final class b
    implements GLSurfaceView.EGLContextFactory
  {
    private int EGL_CONTEXT_CLIENT_VERSION = 12440;
    
    b() {}
    
    public final EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
    {
      AppMethodBeat.i(94777);
      ae.w("MicroMsg.MMSightCameraGLSurfaceView", "creating OpenGL ES 2.0 context");
      int i = this.EGL_CONTEXT_CLIENT_VERSION;
      paramEGL10 = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { i, 2, 12344 });
      AppMethodBeat.o(94777);
      return paramEGL10;
    }
    
    public final void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
    {
      AppMethodBeat.i(94778);
      paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext);
      AppMethodBeat.o(94778);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.cameraglview.MMSightCameraGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */