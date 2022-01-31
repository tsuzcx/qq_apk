package com.tencent.ttpic.view;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

abstract class GLSurfaceView$BaseConfigChooser
  implements GLSurfaceView.EGLConfigChooser
{
  protected int[] mConfigSpec = filterConfigSpec(paramArrayOfInt);
  
  public GLSurfaceView$BaseConfigChooser(GLSurfaceView paramGLSurfaceView, int[] paramArrayOfInt) {}
  
  private int[] filterConfigSpec(int[] paramArrayOfInt)
  {
    if ((GLSurfaceView.access$200(this.this$0) != 2) && (GLSurfaceView.access$200(this.this$0) != 3)) {
      return paramArrayOfInt;
    }
    int i = paramArrayOfInt.length;
    int[] arrayOfInt = new int[i + 2];
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, i - 1);
    arrayOfInt[(i - 1)] = 12352;
    if (GLSurfaceView.access$200(this.this$0) == 2) {
      arrayOfInt[i] = 4;
    }
    for (;;)
    {
      arrayOfInt[(i + 1)] = 12344;
      return arrayOfInt;
      arrayOfInt[i] = 64;
    }
  }
  
  public EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
  {
    int[] arrayOfInt = new int[1];
    if (!paramEGL10.eglChooseConfig(paramEGLDisplay, this.mConfigSpec, null, 0, arrayOfInt)) {
      throw new IllegalArgumentException("eglChooseConfig failed");
    }
    int i = arrayOfInt[0];
    if (i <= 0) {
      throw new IllegalArgumentException("No configs match configSpec");
    }
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
    if (!paramEGL10.eglChooseConfig(paramEGLDisplay, this.mConfigSpec, arrayOfEGLConfig, i, arrayOfInt)) {
      throw new IllegalArgumentException("eglChooseConfig#2 failed");
    }
    paramEGL10 = chooseConfig(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
    if (paramEGL10 == null) {
      throw new IllegalArgumentException("No config chosen");
    }
    return paramEGL10;
  }
  
  abstract EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.view.GLSurfaceView.BaseConfigChooser
 * JD-Core Version:    0.7.0.1
 */