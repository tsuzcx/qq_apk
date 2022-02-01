package com.tencent.mm.plugin.voip.video.render;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "", "surface", "Landroid/view/Surface;", "x", "", "y", "width", "height", "(Landroid/view/Surface;IIII)V", "Landroid/graphics/SurfaceTexture;", "(Landroid/graphics/SurfaceTexture;IIII)V", "Landroid/view/SurfaceHolder;", "(Landroid/view/SurfaceHolder;IIII)V", "Landroid/view/SurfaceView;", "(Landroid/view/SurfaceView;IIII)V", "(Landroid/view/SurfaceHolder;II)V", "(Landroid/view/Surface;II)V", "(Landroid/view/SurfaceView;II)V", "(Landroid/graphics/SurfaceTexture;II)V", "eglSurface", "Landroid/opengl/EGLSurface;", "kotlin.jvm.PlatformType", "type", "viewport", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface$Viewport;", "getEglSurface", "getSurface", "getViewport", "setEglSurface", "", "setViewport", "Companion", "Viewport", "plugin-voip_release"})
public final class g
{
  public static final a Oev;
  Object Oet;
  b Oeu;
  private EGLSurface eglSurface;
  private int type;
  
  static
  {
    AppMethodBeat.i(241792);
    Oev = new a((byte)0);
    AppMethodBeat.o(241792);
  }
  
  private g(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(241787);
    this.eglSurface = EGL14.EGL_NO_SURFACE;
    this.Oeu = new b();
    ld(0, 0);
    this.Oet = paramSurfaceTexture;
    this.type = 0;
    AppMethodBeat.o(241787);
  }
  
  public g(SurfaceTexture paramSurfaceTexture, byte paramByte)
  {
    this(paramSurfaceTexture);
    AppMethodBeat.i(241791);
    AppMethodBeat.o(241791);
  }
  
  private g(Surface paramSurface)
  {
    AppMethodBeat.i(241785);
    this.eglSurface = EGL14.EGL_NO_SURFACE;
    this.Oeu = new b();
    ld(0, 0);
    this.Oet = paramSurface;
    this.type = 0;
    AppMethodBeat.o(241785);
  }
  
  public g(Surface paramSurface, byte paramByte)
  {
    this(paramSurface);
    AppMethodBeat.i(241789);
    AppMethodBeat.o(241789);
  }
  
  public final void a(EGLSurface paramEGLSurface)
  {
    AppMethodBeat.i(241784);
    p.k(paramEGLSurface, "eglSurface");
    this.eglSurface = paramEGLSurface;
    AppMethodBeat.o(241784);
  }
  
  public final EGLSurface gEt()
  {
    AppMethodBeat.i(241783);
    EGLSurface localEGLSurface = this.eglSurface;
    p.j(localEGLSurface, "eglSurface");
    AppMethodBeat.o(241783);
    return localEGLSurface;
  }
  
  public final void ld(int paramInt1, int paramInt2)
  {
    this.Oeu.x = 0;
    this.Oeu.y = 0;
    this.Oeu.width = paramInt1;
    this.Oeu.height = paramInt2;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface$Companion;", "", "()V", "TAG", "", "TYPE_PBUFFER_SURFACE", "", "TYPE_PIXMAP_SURFACE", "TYPE_WINDOW_SURFACE", "plugin-voip_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface$Viewport;", "", "()V", "height", "", "getHeight", "()I", "setHeight", "(I)V", "width", "getWidth", "setWidth", "x", "getX", "setX", "y", "getY", "setY", "plugin-voip_release"})
  public static final class b
  {
    int height;
    int width;
    int x;
    int y;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.g
 * JD-Core Version:    0.7.0.1
 */