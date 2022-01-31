package com.tencent.mm.plugin.voip.video;

import android.opengl.GLSurfaceView.EGLConfigChooser;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

public final class b
  implements GLSurfaceView.EGLConfigChooser
{
  private static int EGL_OPENGL_ES2_BIT = 4;
  private static int[] fwv = { 12324, 4, 12323, 4, 12322, 4, 12352, EGL_OPENGL_ES2_BIT, 12344 };
  protected int fwA;
  protected int fwB;
  private int[] fwC = new int[1];
  protected int fww;
  protected int fwx;
  protected int fwy;
  protected int fwz;
  
  public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.fww = paramInt1;
    this.fwx = paramInt2;
    this.fwy = paramInt3;
    this.fwz = paramInt4;
    this.fwA = 0;
    this.fwB = 0;
  }
  
  private int a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt)
  {
    int i = 0;
    if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt, this.fwC)) {
      i = this.fwC[0];
    }
    return i;
  }
  
  private EGLConfig b(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
  {
    int j = paramArrayOfEGLConfig.length;
    int i = 0;
    while (i < j)
    {
      EGLConfig localEGLConfig = paramArrayOfEGLConfig[i];
      int k = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12325);
      int m = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12326);
      if ((k >= this.fwA) && (m >= this.fwB))
      {
        k = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12324);
        m = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12323);
        int n = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12322);
        int i1 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12321);
        if ((k == this.fww) && (m == this.fwx) && (n == this.fwy) && (i1 == this.fwz)) {
          return localEGLConfig;
        }
      }
      i += 1;
    }
    return null;
  }
  
  public final EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
  {
    int[] arrayOfInt = new int[1];
    paramEGL10.eglChooseConfig(paramEGLDisplay, fwv, null, 0, arrayOfInt);
    int i = arrayOfInt[0];
    if (i <= 0) {
      throw new IllegalArgumentException("No configs match configSpec");
    }
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
    paramEGL10.eglChooseConfig(paramEGLDisplay, fwv, arrayOfEGLConfig, i, arrayOfInt);
    return b(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.b
 * JD-Core Version:    0.7.0.1
 */