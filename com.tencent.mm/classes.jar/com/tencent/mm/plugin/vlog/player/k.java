package com.tencent.mm.plugin.vlog.player;

import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.view.Surface;
import com.tencent.mm.media.g.d;
import d.g.a.a;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/player/VLogSurface;", "", "width", "", "height", "(II)V", "consumer", "Landroid/view/Surface;", "getConsumer", "()Landroid/view/Surface;", "setConsumer", "(Landroid/view/Surface;)V", "getHeight", "()I", "productionTexObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "getProductionTexObj", "()Lcom/tencent/mm/media/globject/GLTextureObject;", "setProductionTexObj", "(Lcom/tencent/mm/media/globject/GLTextureObject;)V", "getWidth", "attachConsumer", "", "surface", "bindPreloadConsumer", "eglContext", "Landroid/opengl/EGLContext;", "eglDisplay", "Landroid/opengl/EGLDisplay;", "clearTask", "getProductionTex", "queueEvent", "task", "Lkotlin/Function0;", "release", "submitProduction", "ptsMS", "", "unbindPreloadConsumer", "plugin-vlog_release"})
public abstract class k
{
  d BIU;
  Surface BIV;
  final int height;
  final int width;
  
  public k(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public abstract void Bp(long paramLong);
  
  public abstract void a(EGLContext paramEGLContext, EGLDisplay paramEGLDisplay, Surface paramSurface, int paramInt1, int paramInt2);
  
  public abstract void clearTask();
  
  public abstract void esI();
  
  public final int esK()
  {
    d locald = this.BIU;
    if (locald != null) {
      return locald.hko;
    }
    return -1;
  }
  
  public abstract void h(a<z> parama);
  
  public abstract void k(Surface paramSurface);
  
  public abstract void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.k
 * JD-Core Version:    0.7.0.1
 */