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
    AppMethodBeat.i(195284);
    b.loadLibrary("pag");
    nativeInit();
    if (b.getAppContext() != null) {
      AVReportCenter.getInstance().init(b.getAppContext());
    }
    AppMethodBeat.o(195284);
  }
  
  private PAGSurface(long paramLong)
  {
    this.nativeSurface = paramLong;
  }
  
  public static PAGSurface FromSurface(Surface paramSurface)
  {
    AppMethodBeat.i(195258);
    paramSurface = FromSurface(paramSurface, EGL14.EGL_NO_CONTEXT);
    AppMethodBeat.o(195258);
    return paramSurface;
  }
  
  public static PAGSurface FromSurface(Surface paramSurface, EGLContext paramEGLContext)
  {
    AppMethodBeat.i(195262);
    if (paramSurface == null)
    {
      AppMethodBeat.o(195262);
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
        AppMethodBeat.o(195262);
        return null;
        l = paramEGLContext.getHandle();
      }
      else
      {
        paramEGLContext = new PAGSurface(l);
        paramEGLContext.surface = paramSurface;
        AppMethodBeat.o(195262);
        return paramEGLContext;
        l = 0L;
      }
    }
  }
  
  public static PAGSurface FromSurfaceTexture(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(195254);
    paramSurfaceTexture = FromSurfaceTexture(paramSurfaceTexture, EGL14.EGL_NO_CONTEXT);
    AppMethodBeat.o(195254);
    return paramSurfaceTexture;
  }
  
  public static PAGSurface FromSurfaceTexture(SurfaceTexture paramSurfaceTexture, EGLContext paramEGLContext)
  {
    AppMethodBeat.i(195256);
    if (paramSurfaceTexture == null)
    {
      AppMethodBeat.o(195256);
      return null;
    }
    paramSurfaceTexture = FromSurface(new Surface(paramSurfaceTexture), paramEGLContext);
    AppMethodBeat.o(195256);
    return paramSurfaceTexture;
  }
  
  public static PAGSurface FromTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(195263);
    PAGSurface localPAGSurface = FromTexture(paramInt1, paramInt2, paramInt3, false);
    AppMethodBeat.o(195263);
    return localPAGSurface;
  }
  
  public static PAGSurface FromTexture(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(195266);
    long l = SetupFromTexture(paramInt1, paramInt2, paramInt3, paramBoolean);
    if (l == 0L)
    {
      AppMethodBeat.o(195266);
      return null;
    }
    PAGSurface localPAGSurface = new PAGSurface(l);
    localPAGSurface.textureID = paramInt1;
    AppMethodBeat.o(195266);
    return localPAGSurface;
  }
  
  public static void OnReportData(HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(195283);
    if ((paramHashMap == null) || (paramHashMap.isEmpty()))
    {
      AppMethodBeat.o(195283);
      return;
    }
    AVReportCenter.getInstance().commit(paramHashMap);
    AppMethodBeat.o(195283);
  }
  
  private static native long SetupFromSurfaceWithGLContext(Surface paramSurface, long paramLong);
  
  public static native long SetupFromTexture(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
  
  private native void nativeFinalize();
  
  private static native void nativeInit();
  
  private native void nativeRelease();
  
  public native boolean clearAll();
  
  protected void finalize()
  {
    AppMethodBeat.i(195282);
    nativeFinalize();
    AppMethodBeat.o(195282);
  }
  
  public native void freeCache();
  
  public native int height();
  
  public native boolean present();
  
  public void release()
  {
    AppMethodBeat.i(195278);
    nativeRelease();
    AppMethodBeat.o(195278);
  }
  
  public native void updateSize();
  
  public native int width();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     org.libpag.PAGSurface
 * JD-Core Version:    0.7.0.1
 */