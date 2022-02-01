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
    AppMethodBeat.i(187450);
    b.loadLibrary("pag");
    nativeInit();
    if (b.getAppContext() != null) {
      AVReportCenter.getInstance().init(b.getAppContext());
    }
    AppMethodBeat.o(187450);
  }
  
  private PAGSurface(long paramLong)
  {
    this.nativeSurface = paramLong;
  }
  
  public static PAGSurface FromSurface(Surface paramSurface)
  {
    AppMethodBeat.i(187365);
    paramSurface = FromSurface(paramSurface, EGL14.EGL_NO_CONTEXT);
    AppMethodBeat.o(187365);
    return paramSurface;
  }
  
  public static PAGSurface FromSurface(Surface paramSurface, EGLContext paramEGLContext)
  {
    AppMethodBeat.i(187370);
    if (paramSurface == null)
    {
      AppMethodBeat.o(187370);
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
        AppMethodBeat.o(187370);
        return null;
        l = paramEGLContext.getHandle();
      }
      else
      {
        paramEGLContext = new PAGSurface(l);
        paramEGLContext.surface = paramSurface;
        AppMethodBeat.o(187370);
        return paramEGLContext;
        l = 0L;
      }
    }
  }
  
  public static PAGSurface FromSurfaceTexture(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(187349);
    paramSurfaceTexture = FromSurfaceTexture(paramSurfaceTexture, EGL14.EGL_NO_CONTEXT);
    AppMethodBeat.o(187349);
    return paramSurfaceTexture;
  }
  
  public static PAGSurface FromSurfaceTexture(SurfaceTexture paramSurfaceTexture, EGLContext paramEGLContext)
  {
    AppMethodBeat.i(187359);
    if (paramSurfaceTexture == null)
    {
      AppMethodBeat.o(187359);
      return null;
    }
    paramSurfaceTexture = FromSurface(new Surface(paramSurfaceTexture), paramEGLContext);
    AppMethodBeat.o(187359);
    return paramSurfaceTexture;
  }
  
  public static PAGSurface FromTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(187378);
    PAGSurface localPAGSurface = FromTexture(paramInt1, paramInt2, paramInt3, false);
    AppMethodBeat.o(187378);
    return localPAGSurface;
  }
  
  public static PAGSurface FromTexture(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(187385);
    long l = SetupFromTexture(paramInt1, paramInt2, paramInt3, paramBoolean, false);
    if (l == 0L)
    {
      AppMethodBeat.o(187385);
      return null;
    }
    PAGSurface localPAGSurface = new PAGSurface(l);
    localPAGSurface.textureID = paramInt1;
    AppMethodBeat.o(187385);
    return localPAGSurface;
  }
  
  public static PAGSurface FromTextureForAsyncThread(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(187392);
    PAGSurface localPAGSurface = FromTextureForAsyncThread(paramInt1, paramInt2, paramInt3, false);
    AppMethodBeat.o(187392);
    return localPAGSurface;
  }
  
  public static PAGSurface FromTextureForAsyncThread(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(187396);
    long l = SetupFromTexture(paramInt1, paramInt2, paramInt3, paramBoolean, true);
    if (l == 0L)
    {
      AppMethodBeat.o(187396);
      return null;
    }
    PAGSurface localPAGSurface = new PAGSurface(l);
    localPAGSurface.textureID = paramInt1;
    AppMethodBeat.o(187396);
    return localPAGSurface;
  }
  
  public static void OnReportData(HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(187443);
    if ((paramHashMap == null) || (paramHashMap.isEmpty()))
    {
      AppMethodBeat.o(187443);
      return;
    }
    AVReportCenter.getInstance().commit(paramHashMap);
    AppMethodBeat.o(187443);
  }
  
  private static native long SetupFromSurfaceWithGLContext(Surface paramSurface, long paramLong);
  
  public static native long SetupFromTexture(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2);
  
  private native void nativeFinalize();
  
  private static native void nativeInit();
  
  private native void nativeRelease();
  
  public native boolean clearAll();
  
  protected void finalize()
  {
    AppMethodBeat.i(187501);
    nativeFinalize();
    AppMethodBeat.o(187501);
  }
  
  public native void freeCache();
  
  public native int height();
  
  @Deprecated
  public native boolean present();
  
  public void release()
  {
    AppMethodBeat.i(187494);
    nativeRelease();
    AppMethodBeat.o(187494);
  }
  
  public native void updateSize();
  
  public native int width();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.libpag.PAGSurface
 * JD-Core Version:    0.7.0.1
 */