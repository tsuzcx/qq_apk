package com.tencent.ttpic.recorder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.util.i;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class VideoEncodeContext
{
  static final boolean LIST_CONFIGS = false;
  static final String TAG;
  EGL10 mEGL;
  EGLConfig mEGLConfig;
  EGLConfig[] mEGLConfigs;
  EGLContext mEGLContext;
  EGLDisplay mEGLDisplay;
  EGLSurface mEGLSurface;
  
  static
  {
    AppMethodBeat.i(83726);
    TAG = VideoEncodeContext.class.getSimpleName();
    AppMethodBeat.o(83726);
  }
  
  public VideoEncodeContext()
  {
    AppMethodBeat.i(83720);
    int[] arrayOfInt = new int[2];
    this.mEGL = ((EGL10)EGLContext.getEGL());
    this.mEGLDisplay = this.mEGL.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    this.mEGL.eglInitialize(this.mEGLDisplay, arrayOfInt);
    this.mEGLConfig = chooseConfig();
    if (this.mEGLConfig != null)
    {
      this.mEGLContext = this.mEGL.eglCreateContext(this.mEGLDisplay, this.mEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
      this.mEGLSurface = this.mEGL.eglCreatePbufferSurface(this.mEGLDisplay, this.mEGLConfig, new int[] { 12375, 100, 12374, 100, 12344 });
    }
    AppMethodBeat.o(83720);
  }
  
  private EGLConfig chooseConfig()
  {
    AppMethodBeat.i(83722);
    Object localObject = new int[15];
    Object tmp11_10 = localObject;
    tmp11_10[0] = 12325;
    Object tmp17_11 = tmp11_10;
    tmp17_11[1] = 0;
    Object tmp21_17 = tmp17_11;
    tmp21_17[2] = 12326;
    Object tmp27_21 = tmp21_17;
    tmp27_21[3] = 0;
    Object tmp31_27 = tmp27_21;
    tmp31_27[4] = 12324;
    Object tmp37_31 = tmp31_27;
    tmp37_31[5] = 8;
    Object tmp42_37 = tmp37_31;
    tmp42_37[6] = 12323;
    Object tmp49_42 = tmp42_37;
    tmp49_42[7] = 8;
    Object tmp55_49 = tmp49_42;
    tmp55_49[8] = 12322;
    Object tmp62_55 = tmp55_49;
    tmp62_55[9] = 8;
    Object tmp68_62 = tmp62_55;
    tmp68_62[10] = 12321;
    Object tmp75_68 = tmp68_62;
    tmp75_68[11] = 8;
    Object tmp81_75 = tmp75_68;
    tmp81_75[12] = 12352;
    Object tmp88_81 = tmp81_75;
    tmp88_81[13] = 4;
    Object tmp93_88 = tmp88_81;
    tmp93_88[14] = 12344;
    tmp93_88;
    int[] arrayOfInt = new int[1];
    this.mEGL.eglChooseConfig(this.mEGLDisplay, (int[])localObject, null, 0, arrayOfInt);
    int i = arrayOfInt[0];
    if (i > 0)
    {
      this.mEGLConfigs = new EGLConfig[i];
      this.mEGL.eglChooseConfig(this.mEGLDisplay, (int[])localObject, this.mEGLConfigs, i, arrayOfInt);
      localObject = this.mEGLConfigs[0];
      AppMethodBeat.o(83722);
      return localObject;
    }
    AppMethodBeat.o(83722);
    return null;
  }
  
  private int getConfigAttrib(EGLConfig paramEGLConfig, int paramInt)
  {
    AppMethodBeat.i(83724);
    int[] arrayOfInt = new int[1];
    if (this.mEGL.eglGetConfigAttrib(this.mEGLDisplay, paramEGLConfig, paramInt, arrayOfInt))
    {
      paramInt = arrayOfInt[0];
      AppMethodBeat.o(83724);
      return paramInt;
    }
    AppMethodBeat.o(83724);
    return 0;
  }
  
  private void listConfig()
  {
    AppMethodBeat.i(83723);
    i.k(TAG, "Config List {");
    EGLConfig[] arrayOfEGLConfig = this.mEGLConfigs;
    int j = arrayOfEGLConfig.length;
    int i = 0;
    while (i < j)
    {
      EGLConfig localEGLConfig = arrayOfEGLConfig[i];
      int k = getConfigAttrib(localEGLConfig, 12325);
      int m = getConfigAttrib(localEGLConfig, 12326);
      int n = getConfigAttrib(localEGLConfig, 12324);
      int i1 = getConfigAttrib(localEGLConfig, 12323);
      int i2 = getConfigAttrib(localEGLConfig, 12322);
      int i3 = getConfigAttrib(localEGLConfig, 12321);
      i.k(TAG, "    <d,s,r,g,b,a> = <" + k + "," + m + "," + n + "," + i1 + "," + i2 + "," + i3 + ">");
      i += 1;
    }
    i.k(TAG, "}");
    AppMethodBeat.o(83723);
  }
  
  public void destroyEgl()
  {
    AppMethodBeat.i(83721);
    EGL10 localEGL10 = this.mEGL;
    EGLDisplay localEGLDisplay = this.mEGLDisplay;
    EGLSurface localEGLSurface = EGL10.EGL_NO_SURFACE;
    localEGL10.eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, EGL10.EGL_NO_CONTEXT);
    if (this.mEGLConfig != null)
    {
      this.mEGL.eglDestroySurface(this.mEGLDisplay, this.mEGLSurface);
      this.mEGL.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
    }
    this.mEGL.eglTerminate(this.mEGLDisplay);
    AppMethodBeat.o(83721);
  }
  
  public boolean usecurruntContext()
  {
    AppMethodBeat.i(83725);
    if (this.mEGLConfig == null)
    {
      AppMethodBeat.o(83725);
      return false;
    }
    boolean bool = this.mEGL.eglMakeCurrent(this.mEGLDisplay, this.mEGLSurface, this.mEGLSurface, this.mEGLContext);
    AppMethodBeat.o(83725);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.recorder.VideoEncodeContext
 * JD-Core Version:    0.7.0.1
 */