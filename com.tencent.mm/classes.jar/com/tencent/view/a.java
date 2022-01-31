package com.tencent.view;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public final class a
{
  EGL10 mEGL;
  EGLConfig mEGLConfig;
  EGLConfig[] mEGLConfigs;
  EGLContext mEGLContext;
  EGLDisplay mEGLDisplay;
  EGLSurface mEGLSurface;
  
  public a()
  {
    int[] arrayOfInt1 = new int[2];
    this.mEGL = ((EGL10)EGLContext.getEGL());
    this.mEGLDisplay = this.mEGL.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    this.mEGL.eglInitialize(this.mEGLDisplay, arrayOfInt1);
    arrayOfInt1 = new int[15];
    int[] tmp57_56 = arrayOfInt1;
    tmp57_56[0] = 12325;
    int[] tmp63_57 = tmp57_56;
    tmp63_57[1] = 0;
    int[] tmp67_63 = tmp63_57;
    tmp67_63[2] = 12326;
    int[] tmp73_67 = tmp67_63;
    tmp73_67[3] = 0;
    int[] tmp77_73 = tmp73_67;
    tmp77_73[4] = 12324;
    int[] tmp83_77 = tmp77_73;
    tmp83_77[5] = 8;
    int[] tmp88_83 = tmp83_77;
    tmp88_83[6] = 12323;
    int[] tmp95_88 = tmp88_83;
    tmp95_88[7] = 8;
    int[] tmp101_95 = tmp95_88;
    tmp101_95[8] = 12322;
    int[] tmp108_101 = tmp101_95;
    tmp108_101[9] = 8;
    int[] tmp114_108 = tmp108_101;
    tmp114_108[10] = 12321;
    int[] tmp121_114 = tmp114_108;
    tmp121_114[11] = 8;
    int[] tmp127_121 = tmp121_114;
    tmp127_121[12] = 12352;
    int[] tmp134_127 = tmp127_121;
    tmp134_127[13] = 4;
    int[] tmp139_134 = tmp134_127;
    tmp139_134[14] = 12344;
    tmp139_134;
    int[] arrayOfInt2 = new int[1];
    this.mEGL.eglChooseConfig(this.mEGLDisplay, arrayOfInt1, null, 0, arrayOfInt2);
    int i = arrayOfInt2[0];
    if (i > 0)
    {
      this.mEGLConfigs = new EGLConfig[i];
      this.mEGL.eglChooseConfig(this.mEGLDisplay, arrayOfInt1, this.mEGLConfigs, i, arrayOfInt2);
      localEGLConfig = this.mEGLConfigs[0];
    }
    this.mEGLConfig = localEGLConfig;
    if (this.mEGLConfig != null)
    {
      this.mEGLContext = this.mEGL.eglCreateContext(this.mEGLDisplay, this.mEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
      this.mEGLSurface = this.mEGL.eglCreatePbufferSurface(this.mEGLDisplay, this.mEGLConfig, new int[] { 12375, 100, 12374, 100, 12344 });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.view.a
 * JD-Core Version:    0.7.0.1
 */