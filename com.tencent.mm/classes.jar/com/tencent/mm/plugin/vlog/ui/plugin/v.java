package com.tencent.mm.plugin.vlog.ui.plugin;

import android.graphics.Rect;
import android.util.Size;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.i;
import com.tencent.mm.ui.widget.cropview.CropLayout.c;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewImpl;", "", "getCropChangeListener", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "getCropInView", "Landroid/graphics/Rect;", "getCropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "path", "", "getOperationCallback", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "onActiveChange", "", "active", "", "onPreview", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "onUpdate", "playAfterUpdate", "seekToOriginPosition", "seekTo", "", "setMaxVisibleRect", "rect", "Landroid/graphics/RectF;", "setVideoSize", "size", "Landroid/util/Size;", "setVisibleRect", "plugin-vlog_release"})
public abstract interface v
{
  public abstract void a(Size paramSize);
  
  public abstract void a(com.tencent.mm.plugin.vlog.model.v paramv, boolean paramBoolean1, boolean paramBoolean2, long paramLong);
  
  public abstract CropLayout.c etA();
  
  public abstract WxCropOperationLayout.i etB();
  
  public abstract Rect eti();
  
  public abstract void sU(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.v
 * JD-Core Version:    0.7.0.1
 */