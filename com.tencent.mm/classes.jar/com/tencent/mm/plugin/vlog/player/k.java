package com.tencent.mm.plugin.vlog.player;

import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.view.Surface;
import com.tencent.mm.media.g.d;
import kotlin.g.a.a;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/player/VLogSurface;", "", "width", "", "height", "(II)V", "consumer", "Landroid/view/Surface;", "getConsumer", "()Landroid/view/Surface;", "setConsumer", "(Landroid/view/Surface;)V", "getHeight", "()I", "productionTexObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "getProductionTexObj", "()Lcom/tencent/mm/media/globject/GLTextureObject;", "setProductionTexObj", "(Lcom/tencent/mm/media/globject/GLTextureObject;)V", "getWidth", "attachConsumer", "", "surface", "bindPreloadConsumer", "eglContext", "Landroid/opengl/EGLContext;", "eglDisplay", "Landroid/opengl/EGLDisplay;", "clearTask", "getProductionTex", "queueEvent", "task", "Lkotlin/Function0;", "release", "submitProduction", "ptsMS", "", "unbindPreloadConsumer", "plugin-vlog_release"})
public abstract class k
{
  d GCg;
  Surface GCh;
  final int height;
  final int width;
  
  public k(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public abstract void KY(long paramLong);
  
  public abstract void a(EGLContext paramEGLContext, EGLDisplay paramEGLDisplay, Surface paramSurface, int paramInt1, int paramInt2);
  
  public abstract void clearTask();
  
  public abstract void fCo();
  
  public final int fCq()
  {
    d locald = this.GCg;
    if (locald != null) {
      return locald.igv;
    }
    return -1;
  }
  
  public abstract void j(a<x> parama);
  
  public abstract void k(Surface paramSurface);
  
  public abstract void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.k
 * JD-Core Version:    0.7.0.1
 */