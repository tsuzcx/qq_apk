package com.tencent.mm.plugin.vlog.player;

import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.view.Surface;
import com.tencent.mm.media.f.d;
import d.g.a.a;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/player/VLogSurface;", "", "width", "", "height", "(II)V", "consumer", "Landroid/view/Surface;", "getConsumer", "()Landroid/view/Surface;", "setConsumer", "(Landroid/view/Surface;)V", "getHeight", "()I", "productionTexObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "getProductionTexObj", "()Lcom/tencent/mm/media/globject/GLTextureObject;", "setProductionTexObj", "(Lcom/tencent/mm/media/globject/GLTextureObject;)V", "getWidth", "attachConsumer", "", "surface", "bindPreloadConsumer", "eglContext", "Landroid/opengl/EGLContext;", "eglDisplay", "Landroid/opengl/EGLDisplay;", "clearTask", "getProductionTex", "queueEvent", "task", "Lkotlin/Function0;", "release", "submitProduction", "ptsMS", "", "unbindPreloadConsumer", "plugin-vlog_release"})
public abstract class l
{
  d Aqx;
  Surface Aqy;
  final int height;
  final int width;
  
  public l(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public abstract void a(EGLContext paramEGLContext, EGLDisplay paramEGLDisplay, Surface paramSurface, int paramInt1, int paramInt2);
  
  public abstract void clearTask();
  
  public abstract void efV();
  
  public final int efX()
  {
    d locald = this.Aqx;
    if (locald != null) {
      return locald.gRW;
    }
    return -1;
  }
  
  public abstract void h(a<y> parama);
  
  public abstract void k(Surface paramSurface);
  
  public abstract void release();
  
  public abstract void yM(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.l
 * JD-Core Version:    0.7.0.1
 */