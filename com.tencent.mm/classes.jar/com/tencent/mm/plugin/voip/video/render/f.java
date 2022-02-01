package com.tencent.mm.plugin.voip.video.render;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "", "surface", "Landroid/view/Surface;", "x", "", "y", "width", "height", "(Landroid/view/Surface;IIII)V", "Landroid/graphics/SurfaceTexture;", "(Landroid/graphics/SurfaceTexture;IIII)V", "Landroid/view/SurfaceHolder;", "(Landroid/view/SurfaceHolder;IIII)V", "Landroid/view/SurfaceView;", "(Landroid/view/SurfaceView;IIII)V", "(Landroid/view/SurfaceHolder;II)V", "(Landroid/view/Surface;II)V", "(Landroid/view/SurfaceView;II)V", "(Landroid/graphics/SurfaceTexture;II)V", "eglSurface", "Landroid/opengl/EGLSurface;", "kotlin.jvm.PlatformType", "type", "viewport", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface$Viewport;", "getEglSurface", "getSurface", "getViewport", "setEglSurface", "", "setViewport", "Companion", "Viewport", "plugin-voip_release"})
public final class f
{
  public static final f.a Hnw;
  Object Hnu;
  b Hnv;
  EGLSurface eglSurface;
  private int type;
  
  static
  {
    AppMethodBeat.i(236213);
    Hnw = new f.a((byte)0);
    AppMethodBeat.o(236213);
  }
  
  private f(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(236210);
    this.eglSurface = EGL14.EGL_NO_SURFACE;
    this.Hnv = new b();
    jM(0, 0);
    this.Hnu = paramSurfaceTexture;
    this.type = 0;
    AppMethodBeat.o(236210);
  }
  
  public f(SurfaceTexture paramSurfaceTexture, byte paramByte)
  {
    this(paramSurfaceTexture);
    AppMethodBeat.i(236212);
    AppMethodBeat.o(236212);
  }
  
  private f(Surface paramSurface)
  {
    AppMethodBeat.i(236209);
    this.eglSurface = EGL14.EGL_NO_SURFACE;
    this.Hnv = new b();
    jM(0, 0);
    this.Hnu = paramSurface;
    this.type = 0;
    AppMethodBeat.o(236209);
  }
  
  public f(Surface paramSurface, byte paramByte)
  {
    this(paramSurface);
    AppMethodBeat.i(236211);
    AppMethodBeat.o(236211);
  }
  
  private final void jM(int paramInt1, int paramInt2)
  {
    this.Hnv.x = 0;
    this.Hnv.y = 0;
    this.Hnv.width = 0;
    this.Hnv.height = 0;
  }
  
  public final EGLSurface fLS()
  {
    AppMethodBeat.i(236208);
    EGLSurface localEGLSurface = this.eglSurface;
    p.g(localEGLSurface, "eglSurface");
    AppMethodBeat.o(236208);
    return localEGLSurface;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface$Viewport;", "", "()V", "height", "", "getHeight", "()I", "setHeight", "(I)V", "width", "getWidth", "setWidth", "x", "getX", "setX", "y", "getY", "setY", "plugin-voip_release"})
  public static final class b
  {
    int height;
    int width;
    int x;
    int y;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.f
 * JD-Core Version:    0.7.0.1
 */