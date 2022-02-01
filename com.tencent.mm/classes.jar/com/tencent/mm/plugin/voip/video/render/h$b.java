package com.tencent.mm.plugin.voip.video.render;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "", "onViewCreated", "", "remoteMode", "", "surface", "Landroid/view/Surface;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "onViewDestroy", "onViewRenderReset", "onViewSizeChanged", "w", "h", "plugin-voip_release"})
public abstract interface h$b
{
  public abstract void QW(int paramInt);
  
  public abstract void a(int paramInt, Surface paramSurface, SurfaceTexture paramSurfaceTexture);
  
  public abstract void av(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void dXR();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.h.b
 * JD-Core Version:    0.7.0.1
 */