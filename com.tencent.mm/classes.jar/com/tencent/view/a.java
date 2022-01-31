package com.tencent.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(86625);
    int[] arrayOfInt1 = new int[2];
    this.mEGL = ((EGL10)EGLContext.getEGL());
    this.mEGLDisplay = this.mEGL.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    this.mEGL.eglInitialize(this.mEGLDisplay, arrayOfInt1);
    arrayOfInt1 = new int[15];
    int[] tmp62_61 = arrayOfInt1;
    tmp62_61[0] = 12325;
    int[] tmp68_62 = tmp62_61;
    tmp68_62[1] = 0;
    int[] tmp72_68 = tmp68_62;
    tmp72_68[2] = 12326;
    int[] tmp78_72 = tmp72_68;
    tmp78_72[3] = 0;
    int[] tmp82_78 = tmp78_72;
    tmp82_78[4] = 12324;
    int[] tmp88_82 = tmp82_78;
    tmp88_82[5] = 8;
    int[] tmp93_88 = tmp88_82;
    tmp93_88[6] = 12323;
    int[] tmp100_93 = tmp93_88;
    tmp100_93[7] = 8;
    int[] tmp106_100 = tmp100_93;
    tmp106_100[8] = 12322;
    int[] tmp113_106 = tmp106_100;
    tmp113_106[9] = 8;
    int[] tmp119_113 = tmp113_106;
    tmp119_113[10] = 12321;
    int[] tmp126_119 = tmp119_113;
    tmp126_119[11] = 8;
    int[] tmp132_126 = tmp126_119;
    tmp132_126[12] = 12352;
    int[] tmp139_132 = tmp132_126;
    tmp139_132[13] = 4;
    int[] tmp144_139 = tmp139_132;
    tmp144_139[14] = 12344;
    tmp144_139;
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
    AppMethodBeat.o(86625);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.view.a
 * JD-Core Version:    0.7.0.1
 */