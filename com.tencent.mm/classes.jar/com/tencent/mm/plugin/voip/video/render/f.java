package com.tencent.mm.plugin.voip.video.render;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "", "surface", "Landroid/view/Surface;", "x", "", "y", "width", "height", "(Landroid/view/Surface;IIII)V", "Landroid/graphics/SurfaceTexture;", "(Landroid/graphics/SurfaceTexture;IIII)V", "Landroid/view/SurfaceHolder;", "(Landroid/view/SurfaceHolder;IIII)V", "Landroid/view/SurfaceView;", "(Landroid/view/SurfaceView;IIII)V", "(Landroid/view/SurfaceHolder;II)V", "(Landroid/view/Surface;II)V", "(Landroid/view/SurfaceView;II)V", "(Landroid/graphics/SurfaceTexture;II)V", "eglSurface", "Landroid/opengl/EGLSurface;", "kotlin.jvm.PlatformType", "type", "viewport", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface$Viewport;", "getEglSurface", "getSurface", "getViewport", "setEglSurface", "", "setViewport", "Companion", "Viewport", "plugin-voip_release"})
public final class f
{
  public static final f.a CrU;
  Object CrS;
  b CrT;
  private EGLSurface eglSurface;
  private int type;
  
  static
  {
    AppMethodBeat.i(216128);
    CrU = new f.a((byte)0);
    AppMethodBeat.o(216128);
  }
  
  private f(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(216125);
    this.eglSurface = EGL14.EGL_NO_SURFACE;
    this.CrT = new b();
    eBh();
    this.CrS = paramSurfaceTexture;
    this.type = 0;
    AppMethodBeat.o(216125);
  }
  
  public f(SurfaceTexture paramSurfaceTexture, byte paramByte)
  {
    this(paramSurfaceTexture);
    AppMethodBeat.i(216127);
    AppMethodBeat.o(216127);
  }
  
  private f(Surface paramSurface)
  {
    AppMethodBeat.i(216124);
    this.eglSurface = EGL14.EGL_NO_SURFACE;
    this.CrT = new b();
    eBh();
    this.CrS = paramSurface;
    this.type = 0;
    AppMethodBeat.o(216124);
  }
  
  public f(Surface paramSurface, byte paramByte)
  {
    this(paramSurface);
    AppMethodBeat.i(216126);
    AppMethodBeat.o(216126);
  }
  
  private final void eBh()
  {
    this.CrT.x = 0;
    this.CrT.y = 0;
    this.CrT.width = 0;
    this.CrT.height = 0;
  }
  
  public final void a(EGLSurface paramEGLSurface)
  {
    AppMethodBeat.i(216123);
    p.h(paramEGLSurface, "eglSurface");
    this.eglSurface = paramEGLSurface;
    AppMethodBeat.o(216123);
  }
  
  public final EGLSurface eBi()
  {
    AppMethodBeat.i(216122);
    EGLSurface localEGLSurface = this.eglSurface;
    p.g(localEGLSurface, "eglSurface");
    AppMethodBeat.o(216122);
    return localEGLSurface;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface$Viewport;", "", "()V", "height", "", "getHeight", "()I", "setHeight", "(I)V", "width", "getWidth", "setWidth", "x", "getX", "setX", "y", "getY", "setY", "plugin-voip_release"})
  public static final class b
  {
    int height;
    int width;
    int x;
    int y;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.f
 * JD-Core Version:    0.7.0.1
 */