package com.tencent.mm.plugin.vlog.ui.plugin;

import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.videocomposition.play.VideoCompositionPlayView;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewProvider;", "", "getCropLayout", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "getOperationLayout", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "getParentLayout", "Landroid/view/ViewGroup;", "getSceneDescTv", "Landroid/widget/TextView;", "getVideoView", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;", "tryPlayVideo", "", "plugin-vlog_release"})
public abstract interface z
{
  public abstract WxCropOperationLayout getOperationLayout();
  
  public abstract VideoCompositionPlayView guT();
  
  public abstract ViewGroup gve();
  
  public abstract CropLayout gvf();
  
  public abstract void gvg();
  
  public abstract TextView gvh();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.z
 * JD-Core Version:    0.7.0.1
 */