package com.tencent.mm.plugin.vlog.ui.plugin;

import android.graphics.Rect;
import android.util.Size;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.i;
import com.tencent.mm.plugin.vlog.model.r;
import com.tencent.mm.ui.widget.cropview.CropLayout.c;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewImpl;", "", "getCropChangeListener", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "getCropInView", "Landroid/graphics/Rect;", "getCropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "path", "", "getOperationCallback", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "onActiveChange", "", "active", "", "onPreview", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "setVideoSize", "size", "Landroid/util/Size;", "setVisibleRect", "rect", "Landroid/graphics/RectF;", "plugin-vlog_release"})
public abstract interface c
{
  public abstract void a(Size paramSize);
  
  public abstract Rect ege();
  
  public abstract CropLayout.c egl();
  
  public abstract WxCropOperationLayout.i egm();
  
  public abstract void h(r paramr);
  
  public abstract void sn(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.c
 * JD-Core Version:    0.7.0.1
 */