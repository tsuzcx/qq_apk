package com.tencent.mm.plugin.voip.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

final class b
  implements GLTextureView.e
{
  private static int EGL_OPENGL_ES2_BIT = 4;
  private static int[] hqg = { 12324, 4, 12323, 4, 12322, 4, 12352, EGL_OPENGL_ES2_BIT, 12344 };
  private int[] giU;
  protected int giV;
  protected int giW;
  protected int giX;
  protected int giY;
  protected int giZ;
  protected int gja;
  
  public b()
  {
    AppMethodBeat.i(115569);
    this.giU = new int[1];
    this.giV = 5;
    this.giW = 6;
    this.giX = 5;
    this.giY = 0;
    this.giZ = 0;
    this.gja = 0;
    AppMethodBeat.o(115569);
  }
  
  private int a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt)
  {
    AppMethodBeat.i(115572);
    if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt, this.giU))
    {
      paramInt = this.giU[0];
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
    paramEGL10.eglChooseConfig(paramEGLDisplay, hqg, null, 0, arrayOfInt);
    int i = arrayOfInt[0];
    if (i <= 0)
    {
      paramEGL10 = new IllegalArgumentException("No configs match configSpec");
      AppMethodBeat.o(115570);
      throw paramEGL10;
    }
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
    paramEGL10.eglChooseConfig(paramEGLDisplay, hqg, arrayOfEGLConfig, i, arrayOfInt);
    paramEGL10 = b(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
    AppMethodBeat.o(115570);
    return paramEGL10;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.b
 * JD-Core Version:    0.7.0.1
 */