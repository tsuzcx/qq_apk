package com.tencent.mm.plugin.rubbishbin.a;

import android.annotation.SuppressLint;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.openglapihook.FuncSeeker;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class a
  implements b
{
  private EGLConfig jUW;
  private EGLContext jUX;
  private EGLSurface jUY;
  private EGLDisplay mEGLDisplay;
  
  @SuppressLint({"LongLogTag"})
  public final void execute()
  {
    AppMethodBeat.i(205400);
    if (!((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vtR, true))
    {
      AppMethodBeat.o(205400);
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
          this.jUW = arrayOfEGLConfig[0];
          this.jUX = EGL14.eglCreateContext(this.mEGLDisplay, this.jUW, EGL14.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 }, 0);
          if (this.jUX != EGL14.EGL_NO_CONTEXT)
          {
            this.jUY = EGL14.eglCreatePbufferSurface(this.mEGLDisplay, this.jUW, new int[] { 12375, 64, 12374, 64, 12344 }, 0);
            if ((this.jUY != EGL14.EGL_NO_SURFACE) && (EGL14.eglMakeCurrent(this.mEGLDisplay, this.jUY, this.jUY, this.jUX))) {
              GLES20.glFlush();
            }
          }
        }
      }
    }
    int i = FuncSeeker.getFuncIndex("glGenTextures");
    Log.e("MicroMsg.GpuHookIndexTask", "glGenTexturesIndex = ".concat(String.valueOf(i)));
    int j = FuncSeeker.getFuncIndex("glDeleteTextures");
    Log.e("MicroMsg.GpuHookIndexTask", "glDeleteTexturesIndex = ".concat(String.valueOf(j)));
    int k = FuncSeeker.getFuncIndex("glGenBuffers");
    Log.e("MicroMsg.GpuHookIndexTask", "glGenBuffersIndex = ".concat(String.valueOf(k)));
    int m = FuncSeeker.getFuncIndex("glDeleteBuffers");
    Log.e("MicroMsg.GpuHookIndexTask", "glDeleteBuffersIndex = ".concat(String.valueOf(m)));
    int n = FuncSeeker.getFuncIndex("glGenFramebuffers");
    Log.e("MicroMsg.GpuHookIndexTask", "glGenFramebuffersIndex = ".concat(String.valueOf(n)));
    int i1 = FuncSeeker.getFuncIndex("glDeleteFramebuffers");
    Log.e("MicroMsg.GpuHookIndexTask", "glDeleteFramebuffersIndex = ".concat(String.valueOf(i1)));
    int i2 = FuncSeeker.getFuncIndex("glGenRenderbuffers");
    Log.e("MicroMsg.GpuHookIndexTask", "glGenRenderbuffersIndex = ".concat(String.valueOf(i2)));
    int i3 = FuncSeeker.getFuncIndex("glDeleteRenderbuffers");
    Log.e("MicroMsg.GpuHookIndexTask", "glDeleteRenderbuffersIndex = ".concat(String.valueOf(i3)));
    int i4 = FuncSeeker.getFuncIndex("glGetError");
    Log.e("MicroMsg.GpuHookIndexTask", "glGetErrorIndex = ".concat(String.valueOf(i4)));
    localMultiProcessMMKV.putInt("glGenTextures_index", i);
    localMultiProcessMMKV.putInt("glDeleteTextures_index", j);
    localMultiProcessMMKV.putInt("glGenBuffers_index", k);
    localMultiProcessMMKV.putInt("glDeleteBuffers_index", m);
    localMultiProcessMMKV.putInt("glGenFramebuffers_index", n);
    localMultiProcessMMKV.putInt("glDeleteFramebuffers_index", i1);
    localMultiProcessMMKV.putInt("glGenRenderbuffers_index", i2);
    localMultiProcessMMKV.putInt("glDeleteRenderbuffers_index", i3);
    localMultiProcessMMKV.putInt("glGetError_index", i4);
    localMultiProcessMMKV.putBoolean("key_finish_function_seek", true);
    localMultiProcessMMKV.commit();
    Log.i("MicroMsg.GpuHookIndexTask", "release");
    EGL14.eglDestroySurface(this.mEGLDisplay, this.jUY);
    EGL14.eglDestroyContext(this.mEGLDisplay, this.jUX);
    EGL14.eglReleaseThread();
    EGL14.eglTerminate(this.mEGLDisplay);
    this.mEGLDisplay = null;
    this.jUW = null;
    this.jUX = null;
    this.jUY = null;
    Log.e("MicroMsg.GpuHookIndexTask", MMApplicationContext.getProcessName() + ": System.exit()");
    AppMethodBeat.o(205400);
  }
  
  public final String fBG()
  {
    return "OpenGL_Api_Hook";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.rubbishbin.a.a
 * JD-Core Version:    0.7.0.1
 */