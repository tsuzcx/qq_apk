package com.tencent.mm.plugin.voip.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

final class a
  implements GLTextureView.e
{
  private static int EGL_OPENGL_ES2_BIT = 4;
  private static int[] nDD = { 12324, 4, 12323, 4, 12322, 4, 12352, EGL_OPENGL_ES2_BIT, 12344 };
  private int[] mcA;
  protected int mcB;
  protected int mcC;
  protected int mcD;
  protected int mcE;
  protected int mcF;
  protected int mcG;
  
  public a()
  {
    AppMethodBeat.i(115569);
    this.mcA = new int[1];
    this.mcB = 5;
    this.mcC = 6;
    this.mcD = 5;
    this.mcE = 0;
    this.mcF = 0;
    this.mcG = 0;
    AppMethodBeat.o(115569);
  }
  
  private int b(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt)
  {
    AppMethodBeat.i(115572);
    if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt, this.mcA))
    {
      paramInt = this.mcA[0];
      AppMethodBeat.o(115572);
      return paramInt;
    }
    AppMethodBeat.o(115572);
    return 0;
  }
  
  private EGLConfig b(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
  {
    AppMethodBeat.i(115571);
    int j = paramArrayOfEGLConfig.length;
    int i = 0;
    while (i < j)
    {
      EGLConfig localEGLConfig = paramArrayOfEGLConfig[i];
      int k = b(paramEGL10, paramEGLDisplay, localEGLConfig, 12325);
      int m = b(paramEGL10, paramEGLDisplay, localEGLConfig, 12326);
      if ((k >= this.mcF) && (m >= this.mcG))
      {
        k = b(paramEGL10, paramEGLDisplay, localEGLConfig, 12324);
        m = b(paramEGL10, paramEGLDisplay, localEGLConfig, 12323);
        int n = b(paramEGL10, paramEGLDisplay, localEGLConfig, 12322);
        int i1 = b(paramEGL10, paramEGLDisplay, localEGLConfig, 12321);
        if ((k == this.mcB) && (m == this.mcC) && (n == this.mcD) && (i1 == this.mcE))
        {
          AppMethodBeat.o(115571);
          return localEGLConfig;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(115571);
    return null;
  }
  
  public final EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
  {
    AppMethodBeat.i(115570);
    int[] arrayOfInt = new int[1];
    paramEGL10.eglChooseConfig(paramEGLDisplay, nDD, null, 0, arrayOfInt);
    int i = arrayOfInt[0];
    if (i <= 0)
    {
      paramEGL10 = new IllegalArgumentException("No configs match configSpec");
      AppMethodBeat.o(115570);
      throw paramEGL10;
    }
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
    paramEGL10.eglChooseConfig(paramEGLDisplay, nDD, arrayOfEGLConfig, i, arrayOfInt);
    paramEGL10 = b(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
    AppMethodBeat.o(115570);
    return paramEGL10;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.a
 * JD-Core Version:    0.7.0.1
 */