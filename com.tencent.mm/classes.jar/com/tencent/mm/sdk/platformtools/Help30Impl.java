package com.tencent.mm.sdk.platformtools;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES10;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

class Help30Impl
{
  private static final String GPU_TAG = "MicroMsg.GPU_TAG";
  private static final int MIN_TEXTURE_SIZE = 2048;
  private EGLContext mEGLContext;
  private EGLDisplay mEGLDisplay;
  private EGLSurface mEGLSurface;
  private int maxTextureSize;
  
  private Help30Impl()
  {
    AppMethodBeat.i(157557);
    this.maxTextureSize = 2048;
    Log.i("MicroMsg.GPU_TAG", "pennqin, init Help30Impl.");
    AppMethodBeat.o(157557);
  }
  
  private void eglSetup()
  {
    AppMethodBeat.i(230304);
    this.mEGLDisplay = EGL14.eglGetDisplay(0);
    if (this.mEGLDisplay == EGL14.EGL_NO_DISPLAY)
    {
      Log.e("MicroMsg.GPU_TAG", "EGL_NO_DISPLAY");
      AppMethodBeat.o(230304);
      return;
    }
    Object localObject = new int[2];
    if (!EGL14.eglInitialize(this.mEGLDisplay, (int[])localObject, 0, (int[])localObject, 1))
    {
      Log.e("MicroMsg.GPU_TAG", "eglInitialize");
      AppMethodBeat.o(230304);
      return;
    }
    localObject = new EGLConfig[1];
    int[] arrayOfInt = new int[1];
    EGL14.eglChooseConfig(this.mEGLDisplay, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344 }, 0, (EGLConfig[])localObject, 0, 1, arrayOfInt, 0);
    this.mEGLContext = EGL14.eglCreateContext(this.mEGLDisplay, localObject[0], EGL14.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 }, 0);
    this.mEGLSurface = EGL14.eglCreatePbufferSurface(this.mEGLDisplay, localObject[0], new int[] { 12344 }, 0);
    EGL14.eglMakeCurrent(this.mEGLDisplay, this.mEGLSurface, this.mEGLSurface, this.mEGLContext);
    AppMethodBeat.o(230304);
  }
  
  public static Help30Impl getInstance()
  {
    return Singleton.instance;
  }
  
  private void release()
  {
    AppMethodBeat.i(185117);
    if (EGL14.EGL_NO_DISPLAY != this.mEGLDisplay)
    {
      EGLDisplay localEGLDisplay = this.mEGLDisplay;
      EGLSurface localEGLSurface = EGL14.EGL_NO_SURFACE;
      EGL14.eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, EGL14.EGL_NO_CONTEXT);
      EGL14.eglDestroySurface(this.mEGLDisplay, this.mEGLSurface);
      EGL14.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
      EGL14.eglReleaseThread();
      EGL14.eglTerminate(this.mEGLDisplay);
    }
    this.mEGLDisplay = EGL14.EGL_NO_DISPLAY;
    this.mEGLContext = EGL14.EGL_NO_CONTEXT;
    this.mEGLSurface = EGL14.EGL_NO_SURFACE;
    AppMethodBeat.o(185117);
  }
  
  public boolean canUseHardwareAcceleration(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(230303);
    Log.d("MicroMsg.GPU_TAG", "canUseHardwareAcceleration maxTextureSize %s w %s h %s.", new Object[] { Integer.valueOf(this.maxTextureSize), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 < this.maxTextureSize) && (paramInt2 < this.maxTextureSize))
    {
      AppMethodBeat.o(230303);
      return true;
    }
    AppMethodBeat.o(230303);
    return false;
  }
  
  public void decideLayerType(View paramView, int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(230302);
    Log.d("MicroMsg.GPU_TAG", "decideLayerType maxTextureSize %s.", new Object[] { Integer.valueOf(this.maxTextureSize) });
    if (paramInt1 < this.maxTextureSize)
    {
      paramInt1 = i;
      if (paramInt2 < this.maxTextureSize) {}
    }
    else
    {
      paramInt1 = 1;
    }
    if (paramView.getLayerType() != paramInt1) {
      paramView.setLayerType(paramInt1, null);
    }
    AppMethodBeat.o(230302);
  }
  
  public int getMaxTextureSize()
  {
    return this.maxTextureSize;
  }
  
  public void setLayerType(View paramView)
  {
    AppMethodBeat.i(230301);
    if (paramView.getLayerType() == 1)
    {
      AppMethodBeat.o(230301);
      return;
    }
    paramView.setLayerType(1, null);
    AppMethodBeat.o(230301);
  }
  
  public void updateTextureMaxSize()
  {
    int i = 2048;
    AppMethodBeat.i(230300);
    Log.i("MicroMsg.GPU_TAG", "pennqin, updateTextureMaxSize, before: %s.", new Object[] { Integer.valueOf(this.maxTextureSize) });
    try
    {
      eglSetup();
      int[] arrayOfInt = new int[1];
      GLES10.glGetIntegerv(3379, arrayOfInt, 0);
      if (arrayOfInt[0] > 2048) {
        i = arrayOfInt[0];
      }
      this.maxTextureSize = i;
      Log.i("MicroMsg.GPU_TAG", "pennqin, get max texture size: %s %s.", new Object[] { Integer.valueOf(arrayOfInt[0]), Integer.valueOf(this.maxTextureSize) });
      ForceGpuUtil.canGetTextureSize = false;
      try
      {
        release();
        AppMethodBeat.o(230300);
        return;
      }
      catch (Throwable localThrowable1)
      {
        Log.printErrStackTrace("MicroMsg.GPU_TAG", localThrowable1, "release err: %s", new Object[] { localThrowable1.getMessage() });
        AppMethodBeat.o(230300);
        return;
      }
      try
      {
        release();
        AppMethodBeat.o(230300);
        throw localObject;
      }
      catch (Throwable localThrowable4)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.GPU_TAG", localThrowable4, "release err: %s", new Object[] { localThrowable4.getMessage() });
        }
      }
    }
    catch (Throwable localThrowable2)
    {
      Log.printErrStackTrace("MicroMsg.GPU_TAG", localThrowable2, "err: %s", new Object[] { localThrowable2.getMessage() });
      ForceGpuUtil.canGetTextureSize = false;
      try
      {
        release();
        AppMethodBeat.o(230300);
        return;
      }
      catch (Throwable localThrowable3)
      {
        Log.printErrStackTrace("MicroMsg.GPU_TAG", localThrowable3, "release err: %s", new Object[] { localThrowable3.getMessage() });
        AppMethodBeat.o(230300);
        return;
      }
    }
    finally
    {
      ForceGpuUtil.canGetTextureSize = false;
    }
  }
  
  static class Singleton
  {
    static Help30Impl instance;
    
    static
    {
      AppMethodBeat.i(157556);
      instance = new Help30Impl(null);
      AppMethodBeat.o(157556);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.Help30Impl
 * JD-Core Version:    0.7.0.1
 */