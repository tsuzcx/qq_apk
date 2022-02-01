package com.tencent.mm.plugin.thumbplayer.render;

import android.graphics.Bitmap;
import android.view.Surface;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/render/IMMRenderView;", "", "getBitmap", "Landroid/graphics/Bitmap;", "getLogTag", "", "getScaleType", "", "getSurface", "Landroid/view/Surface;", "reset", "", "setCropRect", "cropRect", "Landroid/graphics/Rect;", "setOpaqueInfo", "isOpaque", "", "setOriginVideoWidthAndHeight", "width", "", "height", "setScaleType", "type", "setSurfaceListener", "listener", "Lcom/tencent/mm/plugin/thumbplayer/render/IMMRenderView$IOnSurfaceListener;", "setTagPrefix", "tag", "setVideoWidthAndHeight", "IOnSurfaceListener", "MMRenderScaleType", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface a
{
  public abstract Bitmap getBitmap();
  
  public abstract Surface getSurface();
  
  public abstract void mj(int paramInt1, int paramInt2);
  
  public abstract void reset();
  
  public abstract void setOpaqueInfo(boolean paramBoolean);
  
  public abstract void setScaleType(int paramInt);
  
  public abstract void setSurfaceListener(a parama);
  
  public abstract void setTagPrefix(String paramString);
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/render/IMMRenderView$IOnSurfaceListener;", "", "onSurfaceAvailable", "", "surface", "onSurfaceChange", "width", "", "height", "onSurfaceDestroy", "", "onSurfaceUpdate", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void fE(Object paramObject);
    
    public abstract void fF(Object paramObject);
    
    public abstract boolean fG(Object paramObject);
    
    public abstract void h(Object paramObject, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.render.a
 * JD-Core Version:    0.7.0.1
 */