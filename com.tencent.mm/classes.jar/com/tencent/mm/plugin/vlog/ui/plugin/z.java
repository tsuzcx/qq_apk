package com.tencent.mm.plugin.vlog.ui.plugin;

import android.graphics.Rect;
import android.util.Size;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.i;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.ui.widget.cropview.CropLayout.c;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewImpl;", "", "currentPlayingTrack", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "getCropChangeListener", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "getCropInView", "Landroid/graphics/Rect;", "getCropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "path", "", "getOperationCallback", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "onActiveChange", "", "active", "", "onPreview", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "onUpdate", "playAfterUpdate", "seekToOriginPosition", "seekTo", "", "setMaxVisibleRect", "rect", "Landroid/graphics/RectF;", "setVideoSize", "size", "Landroid/util/Size;", "setVisibleRect", "showVideoLabel", "plugin-vlog_release"})
public abstract interface z
{
  public abstract void a(Size paramSize);
  
  public abstract void a(ac paramac, boolean paramBoolean1, boolean paramBoolean2, long paramLong);
  
  public abstract CropLayout.c fDH();
  
  public abstract WxCropOperationLayout.i fDI();
  
  public abstract void fDK();
  
  public abstract Rect fDa();
  
  public abstract void wH(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.z
 * JD-Core Version:    0.7.0.1
 */