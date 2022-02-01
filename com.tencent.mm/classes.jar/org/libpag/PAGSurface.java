package org.libpag;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.os.Build.VERSION;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import org.extra.tools.b;
import org.libpag.reporter.AVReportCenter;

public class PAGSurface
{
  long nativeSurface = 0L;
  private Surface surface = null;
  private int textureID = 0;
  
  static
  {
    AppMethodBeat.i(236933);
    b.loadLibrary("pag");
    nativeInit();
    if (b.getAppContext() != null) {
      AVReportCenter.getInstance().init(b.getAppContext());
    }
    AppMethodBeat.o(236933);
  }
  
  private PAGSurface(long paramLong)
  {
    this.nativeSurface = paramLong;
  }
  
  public static PAGSurface FromSurface(Surface paramSurface)
  {
    AppMethodBeat.i(236926);
    paramSurface = FromSurface(paramSurface, EGL14.EGL_NO_CONTEXT);
    AppMethodBeat.o(236926);
    return paramSurface;
  }
  
  public static PAGSurface FromSurface(Surface paramSurface, EGLContext paramEGLContext)
  {
    AppMethodBeat.i(236927);
    if (paramSurface == null)
    {
      AppMethodBeat.o(236927);
      return null;
    }
    long l;
    if ((paramEGLContext != null) && (paramEGLContext != EGL14.EGL_NO_CONTEXT)) {
      if (Build.VERSION.SDK_INT >= 21) {
        l = paramEGLContext.getNativeHandle();
      }
    }
    for (;;)
    {
      l = SetupFromSurfaceWithGLContext(paramSurface, l);
      if (l == 0L)
      {
        AppMethodBeat.o(236927);
        return null;
        l = paramEGLContext.getHandle();
      }
      else
      {
        paramEGLContext = new PAGSurface(l);
        paramEGLContext.surface = paramSurface;
        AppMethodBeat.o(236927);
        return paramEGLContext;
        l = 0L;
      }
    }
  }
  
  public static PAGSurface FromSurfaceTexture(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(236924);
    paramSurfaceTexture = FromSurfaceTexture(paramSurfaceTexture, EGL14.EGL_NO_CONTEXT);
    AppMethodBeat.o(236924);
    return paramSurfaceTexture;
  }
  
  public static PAGSurface FromSurfaceTexture(SurfaceTexture paramSurfaceTexture, EGLContext paramEGLContext)
  {
    AppMethodBeat.i(236925);
    if (paramSurfaceTexture == null)
    {
      AppMethodBeat.o(236925);
      return null;
    }
    paramSurfaceTexture = FromSurface(new Surface(paramSurfaceTexture), paramEGLContext);
    AppMethodBeat.o(236925);
    return paramSurfaceTexture;
  }
  
  public static PAGSurface FromTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(236928);
    PAGSurface localPAGSurface = FromTexture(paramInt1, paramInt2, paramInt3, false);
    AppMethodBeat.o(236928);
    return localPAGSurface;
  }
  
  public static PAGSurface FromTexture(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(236929);
    long l = SetupFromTexture(paramInt1, paramInt2, paramInt3, paramBoolean);
    if (l == 0L)
    {
      AppMethodBeat.o(236929);
      return null;
    }
    PAGSurface localPAGSurface = new PAGSurface(l);
    localPAGSurface.textureID = paramInt1;
    AppMethodBeat.o(236929);
    return localPAGSurface;
  }
  
  public static void OnReportData(HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(236932);
    if ((paramHashMap == null) || (paramHashMap.isEmpty()))
    {
      AppMethodBeat.o(236932);
      return;
    }
    AVReportCenter.getInstance().commit(paramHashMap);
    AppMethodBeat.o(236932);
  }
  
  private static native long SetupFromSurfaceWithGLContext(Surface paramSurface, long paramLong);
  
  public static native long SetupFromTexture(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
  
  private native void nativeFinalize();
  
  private static native void nativeInit();
  
  private native void nativeRelease();
  
  public native boolean clearAll();
  
  protected void finalize()
  {
    AppMethodBeat.i(236931);
    nativeFinalize();
    AppMethodBeat.o(236931);
  }
  
  public native void freeCache();
  
  public native int height();
  
  public native boolean present();
  
  public void release()
  {
    AppMethodBeat.i(236930);
    nativeRelease();
    AppMethodBeat.o(236930);
  }
  
  public native void updateSize();
  
  public native int width();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.libpag.PAGSurface
 * JD-Core Version:    0.7.0.1
 */