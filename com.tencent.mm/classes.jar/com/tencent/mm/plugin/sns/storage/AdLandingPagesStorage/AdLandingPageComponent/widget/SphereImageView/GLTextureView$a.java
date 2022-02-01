package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

abstract class GLTextureView$a
  implements GLTextureView.e
{
  protected int[] ggA;
  
  public GLTextureView$a(GLTextureView paramGLTextureView, int[] paramArrayOfInt)
  {
    if (GLTextureView.a(this.zJP) != 2) {}
    for (;;)
    {
      this.ggA = paramArrayOfInt;
      return;
      paramGLTextureView = new int[15];
      System.arraycopy(paramArrayOfInt, 0, paramGLTextureView, 0, 12);
      paramGLTextureView[12] = 12352;
      paramGLTextureView[13] = 4;
      paramGLTextureView[14] = 12344;
      paramArrayOfInt = paramGLTextureView;
    }
  }
  
  abstract EGLConfig b(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig);
  
  public final EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
  {
    int[] arrayOfInt = new int[1];
    if (!paramEGL10.eglChooseConfig(paramEGLDisplay, this.ggA, null, 0, arrayOfInt)) {
      throw new IllegalArgumentException("eglChooseConfig failed");
    }
    int i = arrayOfInt[0];
    if (i <= 0) {
      throw new IllegalArgumentException("No configs match configSpec");
    }
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
    if (!paramEGL10.eglChooseConfig(paramEGLDisplay, this.ggA, arrayOfEGLConfig, i, arrayOfInt)) {
      throw new IllegalArgumentException("eglChooseConfig#2 failed");
    }
    paramEGL10 = b(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
    if (paramEGL10 == null) {
      throw new IllegalArgumentException("No config chosen");
    }
    return paramEGL10;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.a
 * JD-Core Version:    0.7.0.1
 */