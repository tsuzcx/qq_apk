package com.tencent.mm.plugin.voip.video.render;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "", "surface", "Landroid/view/Surface;", "x", "", "y", "width", "height", "(Landroid/view/Surface;IIII)V", "Landroid/graphics/SurfaceTexture;", "(Landroid/graphics/SurfaceTexture;IIII)V", "Landroid/view/SurfaceHolder;", "(Landroid/view/SurfaceHolder;IIII)V", "Landroid/view/SurfaceView;", "(Landroid/view/SurfaceView;IIII)V", "(Landroid/view/SurfaceHolder;II)V", "(Landroid/view/Surface;II)V", "(Landroid/view/SurfaceView;II)V", "(Landroid/graphics/SurfaceTexture;II)V", "eglSurface", "Landroid/opengl/EGLSurface;", "kotlin.jvm.PlatformType", "type", "viewport", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface$Viewport;", "getEglSurface", "getSurface", "getViewport", "setEglSurface", "", "setViewport", "Companion", "Viewport", "plugin-voip_release"})
public final class e
{
  public static final e.a ARU;
  Object ARS;
  b ART;
  private EGLSurface eglSurface;
  private int type;
  
  static
  {
    AppMethodBeat.i(208766);
    ARU = new e.a((byte)0);
    AppMethodBeat.o(208766);
  }
  
  private e(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(208763);
    this.eglSurface = EGL14.EGL_NO_SURFACE;
    this.ART = new b();
    enj();
    this.ARS = paramSurfaceTexture;
    this.type = 0;
    AppMethodBeat.o(208763);
  }
  
  public e(SurfaceTexture paramSurfaceTexture, byte paramByte)
  {
    this(paramSurfaceTexture);
    AppMethodBeat.i(208765);
    AppMethodBeat.o(208765);
  }
  
  private e(Surface paramSurface)
  {
    AppMethodBeat.i(208762);
    this.eglSurface = EGL14.EGL_NO_SURFACE;
    this.ART = new b();
    enj();
    this.ARS = paramSurface;
    this.type = 0;
    AppMethodBeat.o(208762);
  }
  
  public e(Surface paramSurface, byte paramByte)
  {
    this(paramSurface);
    AppMethodBeat.i(208764);
    AppMethodBeat.o(208764);
  }
  
  private final void enj()
  {
    this.ART.x = 0;
    this.ART.y = 0;
    this.ART.width = 0;
    this.ART.height = 0;
  }
  
  public final void a(EGLSurface paramEGLSurface)
  {
    AppMethodBeat.i(208761);
    k.h(paramEGLSurface, "eglSurface");
    this.eglSurface = paramEGLSurface;
    AppMethodBeat.o(208761);
  }
  
  public final EGLSurface enk()
  {
    AppMethodBeat.i(208760);
    EGLSurface localEGLSurface = this.eglSurface;
    k.g(localEGLSurface, "eglSurface");
    AppMethodBeat.o(208760);
    return localEGLSurface;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface$Viewport;", "", "()V", "height", "", "getHeight", "()I", "setHeight", "(I)V", "width", "getWidth", "setWidth", "x", "getX", "setX", "y", "getY", "setY", "plugin-voip_release"})
  public static final class b
  {
    int height;
    int width;
    int x;
    int y;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.e
 * JD-Core Version:    0.7.0.1
 */