package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView;

import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

class GLTextureView$b
  extends GLTextureView.a
{
  private int[] value;
  protected int zJQ;
  protected int zJR;
  protected int zJS;
  protected int zJT;
  protected int zJU;
  protected int zJV;
  
  public GLTextureView$b(GLTextureView paramGLTextureView, int paramInt)
  {
    super(paramGLTextureView, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 0, 12325, paramInt, 12326, 0, 12344 });
    AppMethodBeat.i(97180);
    this.value = new int[1];
    this.zJQ = 8;
    this.zJR = 8;
    this.zJS = 8;
    this.zJT = 0;
    this.zJU = paramInt;
    this.zJV = 0;
    AppMethodBeat.o(97180);
  }
  
  private int a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt)
  {
    AppMethodBeat.i(97182);
    if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt, this.value))
    {
      paramInt = this.value[0];
      AppMethodBeat.o(97182);
      return paramInt;
    }
    AppMethodBeat.o(97182);
    return 0;
  }
  
  public final EGLConfig b(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
  {
    AppMethodBeat.i(97181);
    int j = paramArrayOfEGLConfig.length;
    int i = 0;
    while (i < j)
    {
      EGLConfig localEGLConfig = paramArrayOfEGLConfig[i];
      int k = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12325);
      int m = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12326);
      if ((k >= this.zJU) && (m >= this.zJV))
      {
        k = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12324);
        m = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12323);
        int n = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12322);
        int i1 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12321);
        if ((k == this.zJQ) && (m == this.zJR) && (n == this.zJS) && (i1 == this.zJT))
        {
          AppMethodBeat.o(97181);
          return localEGLConfig;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(97181);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.b
 * JD-Core Version:    0.7.0.1
 */