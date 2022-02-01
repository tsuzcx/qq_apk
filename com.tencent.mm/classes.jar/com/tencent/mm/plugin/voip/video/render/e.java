package com.tencent.mm.plugin.voip.video.render;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "", "surface", "Landroid/view/Surface;", "x", "", "y", "width", "height", "(Landroid/view/Surface;IIII)V", "Landroid/graphics/SurfaceTexture;", "(Landroid/graphics/SurfaceTexture;IIII)V", "Landroid/view/SurfaceHolder;", "(Landroid/view/SurfaceHolder;IIII)V", "Landroid/view/SurfaceView;", "(Landroid/view/SurfaceView;IIII)V", "(Landroid/view/SurfaceHolder;II)V", "(Landroid/view/Surface;II)V", "(Landroid/view/SurfaceView;II)V", "(Landroid/graphics/SurfaceTexture;II)V", "eglSurface", "Landroid/opengl/EGLSurface;", "kotlin.jvm.PlatformType", "type", "viewport", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface$Viewport;", "getEglSurface", "getSurface", "getViewport", "setEglSurface", "", "setViewport", "Companion", "Viewport", "plugin-voip_release"})
public final class e
{
  public static final e.a zzD;
  private EGLSurface eglSurface;
  private int type;
  Object zzB;
  b zzC;
  
  static
  {
    AppMethodBeat.i(192415);
    zzD = new e.a((byte)0);
    AppMethodBeat.o(192415);
  }
  
  private e(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(192412);
    this.eglSurface = EGL14.EGL_NO_SURFACE;
    this.zzC = new b();
    dXN();
    this.zzB = paramSurfaceTexture;
    this.type = 0;
    AppMethodBeat.o(192412);
  }
  
  public e(SurfaceTexture paramSurfaceTexture, byte paramByte)
  {
    this(paramSurfaceTexture);
    AppMethodBeat.i(192414);
    AppMethodBeat.o(192414);
  }
  
  private e(Surface paramSurface)
  {
    AppMethodBeat.i(192411);
    this.eglSurface = EGL14.EGL_NO_SURFACE;
    this.zzC = new b();
    dXN();
    this.zzB = paramSurface;
    this.type = 0;
    AppMethodBeat.o(192411);
  }
  
  public e(Surface paramSurface, byte paramByte)
  {
    this(paramSurface);
    AppMethodBeat.i(192413);
    AppMethodBeat.o(192413);
  }
  
  private final void dXN()
  {
    this.zzC.x = 0;
    this.zzC.y = 0;
    this.zzC.width = 0;
    this.zzC.height = 0;
  }
  
  public final void a(EGLSurface paramEGLSurface)
  {
    AppMethodBeat.i(192410);
    k.h(paramEGLSurface, "eglSurface");
    this.eglSurface = paramEGLSurface;
    AppMethodBeat.o(192410);
  }
  
  public final EGLSurface dXO()
  {
    AppMethodBeat.i(192409);
    EGLSurface localEGLSurface = this.eglSurface;
    k.g(localEGLSurface, "eglSurface");
    AppMethodBeat.o(192409);
    return localEGLSurface;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface$Viewport;", "", "()V", "height", "", "getHeight", "()I", "setHeight", "(I)V", "width", "getWidth", "setWidth", "x", "getX", "setX", "y", "getY", "setY", "plugin-voip_release"})
  public static final class b
  {
    int height;
    int width;
    int x;
    int y;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.e
 * JD-Core Version:    0.7.0.1
 */