package com.tencent.ttpic.view;

import android.opengl.GLDebugHelper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Writer;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;

class GLSurfaceView$EglHelper
{
  EGL10 mEgl;
  EGLConfig mEglConfig;
  EGLContext mEglContext;
  EGLDisplay mEglDisplay;
  EGLSurface mEglSurface;
  private WeakReference<GLSurfaceView> mGLSurfaceViewWeakRef;
  
  public GLSurfaceView$EglHelper(WeakReference<GLSurfaceView> paramWeakReference)
  {
    this.mGLSurfaceViewWeakRef = paramWeakReference;
  }
  
  private void destroySurfaceImp()
  {
    AppMethodBeat.i(84440);
    if ((this.mEglSurface != null) && (this.mEglSurface != EGL10.EGL_NO_SURFACE))
    {
      Object localObject = this.mEgl;
      EGLDisplay localEGLDisplay = this.mEglDisplay;
      EGLSurface localEGLSurface = EGL10.EGL_NO_SURFACE;
      ((EGL10)localObject).eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, EGL10.EGL_NO_CONTEXT);
      localObject = (GLSurfaceView)this.mGLSurfaceViewWeakRef.get();
      if (localObject != null) {
        GLSurfaceView.access$500((GLSurfaceView)localObject).destroySurface(this.mEgl, this.mEglDisplay, this.mEglSurface);
      }
      this.mEglSurface = null;
    }
    AppMethodBeat.o(84440);
  }
  
  public static String formatEglError(String paramString, int paramInt)
  {
    AppMethodBeat.i(84445);
    paramString = paramString + " failed: " + paramInt;
    AppMethodBeat.o(84445);
    return paramString;
  }
  
  public static void logEglErrorAsWarning(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(84444);
    formatEglError(paramString2, paramInt);
    AppMethodBeat.o(84444);
  }
  
  private void throwEglException(String paramString)
  {
    AppMethodBeat.i(84442);
    throwEglException(paramString, this.mEgl.eglGetError());
    AppMethodBeat.o(84442);
  }
  
  public static void throwEglException(String paramString, int paramInt)
  {
    AppMethodBeat.i(84443);
    paramString = new RuntimeException(formatEglError(paramString, paramInt));
    AppMethodBeat.o(84443);
    throw paramString;
  }
  
  GL createGL()
  {
    AppMethodBeat.i(84437);
    GL localGL2 = this.mEglContext.getGL();
    GLSurfaceView localGLSurfaceView = (GLSurfaceView)this.mGLSurfaceViewWeakRef.get();
    Object localObject = localGL2;
    GL localGL1;
    int i;
    if (localGLSurfaceView != null)
    {
      localGL1 = localGL2;
      if (GLSurfaceView.access$600(localGLSurfaceView) != null) {
        localGL1 = GLSurfaceView.access$600(localGLSurfaceView).wrap(localGL2);
      }
      localObject = localGL1;
      if ((GLSurfaceView.access$700(localGLSurfaceView) & 0x3) != 0)
      {
        i = 0;
        if ((GLSurfaceView.access$700(localGLSurfaceView) & 0x1) != 0) {
          i = 1;
        }
        if ((GLSurfaceView.access$700(localGLSurfaceView) & 0x2) == 0) {
          break label116;
        }
      }
    }
    label116:
    for (localObject = new GLSurfaceView.LogWriter();; localObject = null)
    {
      localObject = GLDebugHelper.wrap(localGL1, i, (Writer)localObject);
      AppMethodBeat.o(84437);
      return localObject;
    }
  }
  
  public boolean createSurface()
  {
    AppMethodBeat.i(84436);
    if (this.mEgl == null)
    {
      localObject = new RuntimeException("egl not initialized");
      AppMethodBeat.o(84436);
      throw ((Throwable)localObject);
    }
    if (this.mEglDisplay == null)
    {
      localObject = new RuntimeException("eglDisplay not initialized");
      AppMethodBeat.o(84436);
      throw ((Throwable)localObject);
    }
    if (this.mEglConfig == null)
    {
      localObject = new RuntimeException("mEglConfig not initialized");
      AppMethodBeat.o(84436);
      throw ((Throwable)localObject);
    }
    destroySurfaceImp();
    Object localObject = (GLSurfaceView)this.mGLSurfaceViewWeakRef.get();
    if (localObject != null) {}
    for (this.mEglSurface = GLSurfaceView.access$500((GLSurfaceView)localObject).createWindowSurface(this.mEgl, this.mEglDisplay, this.mEglConfig, ((GLSurfaceView)localObject).getHolder()); (this.mEglSurface == null) || (this.mEglSurface == EGL10.EGL_NO_SURFACE); this.mEglSurface = null)
    {
      this.mEgl.eglGetError();
      AppMethodBeat.o(84436);
      return false;
    }
    if (!this.mEgl.eglMakeCurrent(this.mEglDisplay, this.mEglSurface, this.mEglSurface, this.mEglContext))
    {
      logEglErrorAsWarning("EGLHelper", "eglMakeCurrent", this.mEgl.eglGetError());
      AppMethodBeat.o(84436);
      return false;
    }
    AppMethodBeat.o(84436);
    return true;
  }
  
  public void destroySurface()
  {
    AppMethodBeat.i(84439);
    destroySurfaceImp();
    AppMethodBeat.o(84439);
  }
  
  public void finish()
  {
    AppMethodBeat.i(84441);
    if (this.mEglContext != null)
    {
      GLSurfaceView localGLSurfaceView = (GLSurfaceView)this.mGLSurfaceViewWeakRef.get();
      if (localGLSurfaceView != null) {
        GLSurfaceView.access$400(localGLSurfaceView).destroyContext(this.mEgl, this.mEglDisplay, this.mEglContext);
      }
      this.mEglContext = null;
    }
    if (this.mEglDisplay != null)
    {
      this.mEgl.eglTerminate(this.mEglDisplay);
      this.mEglDisplay = null;
    }
    AppMethodBeat.o(84441);
  }
  
  public void start()
  {
    AppMethodBeat.i(84435);
    this.mEgl = ((EGL10)EGLContext.getEGL());
    this.mEglDisplay = this.mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    if (this.mEglDisplay == EGL10.EGL_NO_DISPLAY)
    {
      localObject = new RuntimeException("eglGetDisplay failed");
      AppMethodBeat.o(84435);
      throw ((Throwable)localObject);
    }
    Object localObject = new int[2];
    if (!this.mEgl.eglInitialize(this.mEglDisplay, (int[])localObject))
    {
      localObject = new RuntimeException("eglInitialize failed");
      AppMethodBeat.o(84435);
      throw ((Throwable)localObject);
    }
    localObject = (GLSurfaceView)this.mGLSurfaceViewWeakRef.get();
    if (localObject == null) {
      this.mEglConfig = null;
    }
    for (this.mEglContext = null;; this.mEglContext = GLSurfaceView.access$400((GLSurfaceView)localObject).createContext(this.mEgl, this.mEglDisplay, this.mEglConfig))
    {
      if ((this.mEglContext == null) || (this.mEglContext == EGL10.EGL_NO_CONTEXT))
      {
        this.mEglContext = null;
        throwEglException("createContext");
      }
      this.mEglSurface = null;
      AppMethodBeat.o(84435);
      return;
      this.mEglConfig = GLSurfaceView.access$300((GLSurfaceView)localObject).chooseConfig(this.mEgl, this.mEglDisplay);
    }
  }
  
  public int swap()
  {
    AppMethodBeat.i(84438);
    if (!this.mEgl.eglSwapBuffers(this.mEglDisplay, this.mEglSurface))
    {
      int i = this.mEgl.eglGetError();
      AppMethodBeat.o(84438);
      return i;
    }
    AppMethodBeat.o(84438);
    return 12288;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.view.GLSurfaceView.EglHelper
 * JD-Core Version:    0.7.0.1
 */