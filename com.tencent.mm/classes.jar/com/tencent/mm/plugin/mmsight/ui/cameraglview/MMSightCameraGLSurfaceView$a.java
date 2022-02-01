package com.tencent.mm.plugin.mmsight.ui.cameraglview;

import android.opengl.GLSurfaceView.EGLConfigChooser;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

final class MMSightCameraGLSurfaceView$a
  implements GLSurfaceView.EGLConfigChooser
{
  private int EGL_OPENGL_ES2_BIT;
  private int[] jCM;
  protected int jCN;
  protected int jCO;
  protected int jCP;
  protected int jCQ;
  protected int jCR;
  protected int jCS;
  private int[] kYv;
  
  public MMSightCameraGLSurfaceView$a(MMSightCameraGLSurfaceView paramMMSightCameraGLSurfaceView)
  {
    AppMethodBeat.i(94772);
    this.EGL_OPENGL_ES2_BIT = 4;
    this.kYv = new int[] { 12324, 4, 12323, 4, 12322, 4, 12352, this.EGL_OPENGL_ES2_BIT, 12344 };
    this.jCM = new int[1];
    this.jCN = 5;
    this.jCO = 6;
    this.jCP = 5;
    this.jCQ = 0;
    this.jCR = 0;
    this.jCS = 0;
    AppMethodBeat.o(94772);
  }
  
  private int a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt)
  {
    AppMethodBeat.i(94775);
    if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt, this.jCM))
    {
      paramInt = this.jCM[0];
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
      if ((k >= this.jCR) && (m >= this.jCS))
      {
        k = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12324);
        m = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12323);
        int n = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12322);
        int i1 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12321);
        if ((k == this.jCN) && (m == this.jCO) && (n == this.jCP) && (i1 == this.jCQ))
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
    Log.i("GLConfigChooser", String.format("%d configurations", new Object[] { Integer.valueOf(k) }));
    int i = 0;
    while (i < k)
    {
      Log.i("GLConfigChooser", String.format("Configuration %d:\n", new Object[] { Integer.valueOf(i) }));
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
    paramEGL10.eglChooseConfig(paramEGLDisplay, this.kYv, null, 0, arrayOfInt);
    int i = arrayOfInt[0];
    if (i <= 0)
    {
      paramEGL10 = new IllegalArgumentException("No configs match configSpec");
      AppMethodBeat.o(94773);
      throw paramEGL10;
    }
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
    paramEGL10.eglChooseConfig(paramEGLDisplay, this.kYv, arrayOfEGLConfig, i, arrayOfInt);
    c(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
    paramEGL10 = b(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
    AppMethodBeat.o(94773);
    return paramEGL10;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.cameraglview.MMSightCameraGLSurfaceView.a
 * JD-Core Version:    0.7.0.1
 */