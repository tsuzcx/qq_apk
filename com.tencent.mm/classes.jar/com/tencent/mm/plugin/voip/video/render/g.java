package com.tencent.mm.plugin.voip.video.render;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.voip.f.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "", "surface", "Landroid/view/Surface;", "x", "", "y", "width", "height", "(Landroid/view/Surface;IIII)V", "Landroid/graphics/SurfaceTexture;", "(Landroid/graphics/SurfaceTexture;IIII)V", "Landroid/view/SurfaceHolder;", "(Landroid/view/SurfaceHolder;IIII)V", "Landroid/view/SurfaceView;", "(Landroid/view/SurfaceView;IIII)V", "(IIII)V", "(Landroid/view/SurfaceHolder;II)V", "(Landroid/view/Surface;II)V", "(Landroid/view/SurfaceView;II)V", "(Landroid/graphics/SurfaceTexture;II)V", "TAG", "", "eglSurface", "Landroid/opengl/EGLSurface;", "kotlin.jvm.PlatformType", "isSurfaceRemoved", "", "surfaceRemoveLock", "Ljava/lang/Object;", "type", "viewport", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface$Viewport;", "getEglSurface", "getSurface", "getViewport", "isSurfaceSupportAutoFit", "isSurfaceValid", "markSurfaceRemoved", "", "remove", "setEglSurface", "setViewport", "Companion", "Viewport", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g.a USy;
  private final String TAG;
  b USA;
  private boolean USB;
  private final Object USC;
  Object USz;
  private EGLSurface eglSurface;
  private int type;
  
  static
  {
    AppMethodBeat.i(293095);
    USy = new g.a((byte)0);
    AppMethodBeat.o(293095);
  }
  
  public g()
  {
    AppMethodBeat.i(293072);
    this.TAG = s.X("MicroMsg.OpenGLSurface@", Integer.valueOf(hashCode()));
    this.eglSurface = EGL14.EGL_NO_SURFACE;
    this.USA = new b();
    this.USC = new Object();
    mO(1, 1);
    this.type = 1;
    AppMethodBeat.o(293072);
  }
  
  private g(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(293069);
    this.TAG = s.X("MicroMsg.OpenGLSurface@", Integer.valueOf(hashCode()));
    this.eglSurface = EGL14.EGL_NO_SURFACE;
    this.USA = new b();
    this.USC = new Object();
    mO(0, 0);
    this.USz = paramSurfaceTexture;
    this.type = 0;
    AppMethodBeat.o(293069);
  }
  
  public g(SurfaceTexture paramSurfaceTexture, byte paramByte)
  {
    this(paramSurfaceTexture);
    AppMethodBeat.i(293085);
    AppMethodBeat.o(293085);
  }
  
  private g(Surface paramSurface, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(293064);
    this.TAG = s.X("MicroMsg.OpenGLSurface@", Integer.valueOf(hashCode()));
    this.eglSurface = EGL14.EGL_NO_SURFACE;
    this.USA = new b();
    this.USC = new Object();
    mO(paramInt1, paramInt2);
    this.USz = paramSurface;
    this.type = 0;
    AppMethodBeat.o(293064);
  }
  
  public g(Surface paramSurface, int paramInt1, int paramInt2, byte paramByte)
  {
    this(paramSurface, paramInt1, paramInt2);
    AppMethodBeat.i(293078);
    AppMethodBeat.o(293078);
  }
  
  public static boolean idm()
  {
    AppMethodBeat.i(293090);
    boolean bool = h.ibz();
    AppMethodBeat.o(293090);
    return bool;
  }
  
  public final void GX(boolean paramBoolean)
  {
    AppMethodBeat.i(293114);
    Log.i(this.TAG, s.X("markSurfaceRemoved:", Boolean.valueOf(paramBoolean)));
    synchronized (this.USC)
    {
      this.USB = paramBoolean;
      ah localah = ah.aiuX;
      AppMethodBeat.o(293114);
      return;
    }
  }
  
  public final void a(EGLSurface paramEGLSurface)
  {
    AppMethodBeat.i(293108);
    s.u(paramEGLSurface, "eglSurface");
    this.eglSurface = paramEGLSurface;
    AppMethodBeat.o(293108);
  }
  
  public final EGLSurface idj()
  {
    AppMethodBeat.i(293104);
    EGLSurface localEGLSurface = this.eglSurface;
    s.s(localEGLSurface, "eglSurface");
    AppMethodBeat.o(293104);
    return localEGLSurface;
  }
  
  public final boolean idk()
  {
    AppMethodBeat.i(293110);
    Object localObject = this.USz;
    if (localObject == null)
    {
      AppMethodBeat.o(293110);
      return false;
    }
    if ((localObject instanceof SurfaceTexture))
    {
      if ((d.rb(26)) && (((SurfaceTexture)localObject).isReleased()))
      {
        AppMethodBeat.o(293110);
        return false;
      }
      AppMethodBeat.o(293110);
      return true;
    }
    if ((localObject instanceof Surface))
    {
      boolean bool = ((Surface)localObject).isValid();
      AppMethodBeat.o(293110);
      return bool;
    }
    AppMethodBeat.o(293110);
    return false;
  }
  
  public final boolean idl()
  {
    synchronized (this.USC)
    {
      boolean bool = this.USB;
      return bool;
    }
  }
  
  public final void mO(int paramInt1, int paramInt2)
  {
    this.USA.x = 0;
    this.USA.y = 0;
    this.USA.width = paramInt1;
    this.USA.height = paramInt2;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface$Viewport;", "", "()V", "height", "", "getHeight", "()I", "setHeight", "(I)V", "width", "getWidth", "setWidth", "x", "getX", "setX", "y", "getY", "setY", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    int height;
    int width;
    int x;
    int y;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.g
 * JD-Core Version:    0.7.0.1
 */