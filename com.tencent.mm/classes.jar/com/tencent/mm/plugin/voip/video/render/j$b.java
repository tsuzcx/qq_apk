package com.tencent.mm.plugin.voip.video.render;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "", "onViewCreated", "", "remoteMode", "", "surface", "Landroid/view/Surface;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "onViewDestroy", "onViewRenderReset", "onViewSizeChanged", "w", "h", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface j$b
{
  public abstract void a(int paramInt, Surface paramSurface, SurfaceTexture paramSurfaceTexture);
  
  public abstract void ary(int paramInt);
  
  public abstract void bm(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void idx();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.j.b
 * JD-Core Version:    0.7.0.1
 */