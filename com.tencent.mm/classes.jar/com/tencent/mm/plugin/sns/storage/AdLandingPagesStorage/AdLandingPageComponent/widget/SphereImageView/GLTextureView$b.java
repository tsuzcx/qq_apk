package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView;

import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

class GLTextureView$b
  extends GLTextureView.a
{
  protected int rAi;
  protected int rAj;
  protected int rAk;
  protected int rAl;
  protected int rAm;
  protected int rAn;
  private int[] value;
  
  public GLTextureView$b(GLTextureView paramGLTextureView, int paramInt)
  {
    super(paramGLTextureView, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 0, 12325, paramInt, 12326, 0, 12344 });
    AppMethodBeat.i(145334);
    this.value = new int[1];
    this.rAi = 8;
    this.rAj = 8;
    this.rAk = 8;
    this.rAl = 0;
    this.rAm = paramInt;
    this.rAn = 0;
    AppMethodBeat.o(145334);
  }
  
  private int a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt)
  {
    AppMethodBeat.i(145336);
    if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt, this.value))
    {
      paramInt = this.value[0];
      AppMethodBeat.o(145336);
      return paramInt;
    }
    AppMethodBeat.o(145336);
    return 0;
  }
  
  public final EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
  {
    AppMethodBeat.i(145335);
    int j = paramArrayOfEGLConfig.length;
    int i = 0;
    while (i < j)
    {
      EGLConfig localEGLConfig = paramArrayOfEGLConfig[i];
      int k = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12325);
      int m = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12326);
      if ((k >= this.rAm) && (m >= this.rAn))
      {
        k = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12324);
        m = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12323);
        int n = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12322);
        int i1 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12321);
        if ((k == this.rAi) && (m == this.rAj) && (n == this.rAk) && (i1 == this.rAl))
        {
          AppMethodBeat.o(145335);
          return localEGLConfig;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(145335);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.b
 * JD-Core Version:    0.7.0.1
 */