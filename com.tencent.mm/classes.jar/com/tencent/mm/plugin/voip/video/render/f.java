package com.tencent.mm.plugin.voip.video.render;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "", "surface", "Landroid/view/Surface;", "x", "", "y", "width", "height", "(Landroid/view/Surface;IIII)V", "Landroid/graphics/SurfaceTexture;", "(Landroid/graphics/SurfaceTexture;IIII)V", "Landroid/view/SurfaceHolder;", "(Landroid/view/SurfaceHolder;IIII)V", "Landroid/view/SurfaceView;", "(Landroid/view/SurfaceView;IIII)V", "(Landroid/view/SurfaceHolder;II)V", "(Landroid/view/Surface;II)V", "(Landroid/view/SurfaceView;II)V", "(Landroid/graphics/SurfaceTexture;II)V", "eglSurface", "Landroid/opengl/EGLSurface;", "kotlin.jvm.PlatformType", "type", "viewport", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface$Viewport;", "getEglSurface", "getSurface", "getViewport", "setEglSurface", "", "setViewport", "Companion", "Viewport", "plugin-voip_release"})
public final class f
{
  public static final f.a CJy;
  Object CJw;
  b CJx;
  private EGLSurface eglSurface;
  private int type;
  
  static
  {
    AppMethodBeat.i(210549);
    CJy = new f.a((byte)0);
    AppMethodBeat.o(210549);
  }
  
  private f(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(210546);
    this.eglSurface = EGL14.EGL_NO_SURFACE;
    this.CJx = new b();
    eEP();
    this.CJw = paramSurfaceTexture;
    this.type = 0;
    AppMethodBeat.o(210546);
  }
  
  public f(SurfaceTexture paramSurfaceTexture, byte paramByte)
  {
    this(paramSurfaceTexture);
    AppMethodBeat.i(210548);
    AppMethodBeat.o(210548);
  }
  
  private f(Surface paramSurface)
  {
    AppMethodBeat.i(210545);
    this.eglSurface = EGL14.EGL_NO_SURFACE;
    this.CJx = new b();
    eEP();
    this.CJw = paramSurface;
    this.type = 0;
    AppMethodBeat.o(210545);
  }
  
  public f(Surface paramSurface, byte paramByte)
  {
    this(paramSurface);
    AppMethodBeat.i(210547);
    AppMethodBeat.o(210547);
  }
  
  private final void eEP()
  {
    this.CJx.x = 0;
    this.CJx.y = 0;
    this.CJx.width = 0;
    this.CJx.height = 0;
  }
  
  public final void a(EGLSurface paramEGLSurface)
  {
    AppMethodBeat.i(210544);
    p.h(paramEGLSurface, "eglSurface");
    this.eglSurface = paramEGLSurface;
    AppMethodBeat.o(210544);
  }
  
  public final EGLSurface eEQ()
  {
    AppMethodBeat.i(210543);
    EGLSurface localEGLSurface = this.eglSurface;
    p.g(localEGLSurface, "eglSurface");
    AppMethodBeat.o(210543);
    return localEGLSurface;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface$Viewport;", "", "()V", "height", "", "getHeight", "()I", "setHeight", "(I)V", "width", "getWidth", "setWidth", "x", "getX", "setX", "y", "getY", "setY", "plugin-voip_release"})
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