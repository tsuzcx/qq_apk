package com.tencent.mm.plugin.vlog.ui.plugin;

import android.view.ViewGroup;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.videocomposition.play.VideoCompositionPlayView;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewProvider;", "", "getCropLayout", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "getOperationLayout", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "getParentLayout", "Landroid/view/ViewGroup;", "getVideoView", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;", "tryPlayVideo", "", "plugin-vlog_release"})
public abstract interface w
{
  public abstract VideoCompositionPlayView ewO();
  
  public abstract ViewGroup ewT();
  
  public abstract CropLayout ewU();
  
  public abstract void ewV();
  
  public abstract WxCropOperationLayout getOperationLayout();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.w
 * JD-Core Version:    0.7.0.1
 */