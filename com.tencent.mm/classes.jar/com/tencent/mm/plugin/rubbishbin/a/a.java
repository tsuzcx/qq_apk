package com.tencent.mm.plugin.rubbishbin.a;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class a
  implements b
{
  private EGLConfig eYa;
  private EGLContext eYb;
  private EGLSurface eYc;
  private EGLDisplay mEGLDisplay;
  
  public final void execute()
  {
    AppMethodBeat.i(262077);
    if (!((c)h.ax(c.class)).a(c.a.yGv, true))
    {
      AppMethodBeat.o(262077);
      return;
    }
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("mmkv_gpu_service_key_muti");
    localMultiProcessMMKV.putBoolean("key_has_function_seek_start", true);
    this.mEGLDisplay = EGL14.eglGetDisplay(0);
    if (this.mEGLDisplay != EGL14.EGL_NO_DISPLAY)
    {
      int[] arrayOfInt = new int[2];
      if (EGL14.eglInitialize(this.mEGLDisplay, arrayOfInt, 0, arrayOfInt, 1))
      {
        arrayOfInt = new int[1];
        EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
        if (EGL14.eglChooseConfig(this.mEGLDisplay, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12344 }, 0, arrayOfEGLConfig, 0, 1, arrayOfInt, 0))
        {
          this.eYa = arrayOfEGLConfig[0];
          this.eYb = EGL14.eglCreateContext(this.mEGLDisplay, this.eYa, EGL14.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 }, 0);
          if (this.eYb != EGL14.EGL_NO_CONTEXT)
          {
            this.eYc = EGL14.eglCreatePbufferSurface(this.mEGLDisplay, this.eYa, new int[] { 12375, 64, 12374, 64, 12344 }, 0);
            if ((this.eYc != EGL14.EGL_NO_SURFACE) && (EGL14.eglMakeCurrent(this.mEGLDisplay, this.eYc, this.eYc, this.eYb))) {
              GLES20.glFlush();
            }
          }
        }
      }
    }
    localMultiProcessMMKV.putBoolean("key_finish_function_seek", true);
    localMultiProcessMMKV.commit();
    Log.i("MicroMsg.GpuHookIndexTask", "release");
    EGL14.eglDestroySurface(this.mEGLDisplay, this.eYc);
    EGL14.eglDestroyContext(this.mEGLDisplay, this.eYb);
    EGL14.eglReleaseThread();
    EGL14.eglTerminate(this.mEGLDisplay);
    this.mEGLDisplay = null;
    this.eYa = null;
    this.eYb = null;
    this.eYc = null;
    Log.e("MicroMsg.GpuHookIndexTask", MMApplicationContext.getProcessName() + ": System.exit()");
    AppMethodBeat.o(262077);
  }
  
  public final String gPj()
  {
    return "OpenGL_Api_Hook";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.rubbishbin.a.a
 * JD-Core Version:    0.7.0.1
 */