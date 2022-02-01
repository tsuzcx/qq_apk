package com.tencent.mm.plugin.vlog.ui.plugin;

import android.graphics.Rect;
import android.util.Size;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.i;
import com.tencent.mm.plugin.vlog.model.v;
import com.tencent.mm.ui.widget.cropview.CropLayout.b;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewImpl;", "", "getCropChangeListener", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "getCropInView", "Landroid/graphics/Rect;", "getCropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "path", "", "getOperationCallback", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "onActiveChange", "", "active", "", "onPreview", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "setVideoSize", "size", "Landroid/util/Size;", "setVisibleRect", "rect", "Landroid/graphics/RectF;", "plugin-vlog_release"})
public abstract interface d
{
  public abstract void a(Size paramSize);
  
  public abstract Rect fZe();
  
  public abstract CropLayout.b fZl();
  
  public abstract WxCropOperationLayout.i fZm();
  
  public abstract void h(v paramv);
  
  public abstract void zg(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.d
 * JD-Core Version:    0.7.0.1
 */