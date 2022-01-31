package com.tencent.mm.plugin.voip.video;

import android.opengl.GLSurfaceView.EGLConfigChooser;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

public final class b
  implements GLSurfaceView.EGLConfigChooser
{
  private static int EGL_OPENGL_ES2_BIT = 4;
  private static int[] eYs = { 12324, 4, 12323, 4, 12322, 4, 12352, EGL_OPENGL_ES2_BIT, 12344 };
  protected int mAlphaSize;
  protected int mBlueSize;
  protected int mDepthSize;
  protected int mGreenSize;
  protected int mRedSize;
  protected int mStencilSize;
  private int[] mValue;
  
  public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(5046);
    this.mValue = new int[1];
    this.mRedSize = paramInt1;
    this.mGreenSize = paramInt2;
    this.mBlueSize = paramInt3;
    this.mAlphaSize = paramInt4;
    this.mDepthSize = 0;
    this.mStencilSize = 0;
    AppMethodBeat.o(5046);
  }
  
  private int a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt)
  {
    AppMethodBeat.i(5049);
    if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt, this.mValue))
    {
      paramInt = this.mValue[0];
      AppMethodBeat.o(5049);
      return paramInt;
    }
    AppMethodBeat.o(5049);
    return 0;
  }
  
  private EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
  {
    AppMethodBeat.i(5048);
    int j = paramArrayOfEGLConfig.length;
    int i = 0;
    while (i < j)
    {
      EGLConfig localEGLConfig = paramArrayOfEGLConfig[i];
      int k = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12325);
      int m = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12326);
      if ((k >= this.mDepthSize) && (m >= this.mStencilSize))
      {
        k = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12324);
        m = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12323);
        int n = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12322);
        int i1 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12321);
        if ((k == this.mRedSize) && (m == this.mGreenSize) && (n == this.mBlueSize) && (i1 == this.mAlphaSize))
        {
          AppMethodBeat.o(5048);
          return localEGLConfig;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(5048);
    return null;
  }
  
  public final EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
  {
    AppMethodBeat.i(5047);
    int[] arrayOfInt = new int[1];
    paramEGL10.eglChooseConfig(paramEGLDisplay, eYs, null, 0, arrayOfInt);
    int i = arrayOfInt[0];
    if (i <= 0)
    {
      paramEGL10 = new IllegalArgumentException("No configs match configSpec");
      AppMethodBeat.o(5047);
      throw paramEGL10;
    }
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
    paramEGL10.eglChooseConfig(paramEGLDisplay, eYs, arrayOfEGLConfig, i, arrayOfInt);
    paramEGL10 = chooseConfig(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
    AppMethodBeat.o(5047);
    return paramEGL10;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.b
 * JD-Core Version:    0.7.0.1
 */