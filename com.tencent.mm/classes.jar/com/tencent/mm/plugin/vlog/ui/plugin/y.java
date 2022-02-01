package com.tencent.mm.plugin.vlog.ui.plugin;

import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.videocomposition.play.VideoCompositionPlayView;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewProvider;", "", "getCropLayout", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "getOperationLayout", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "getParentLayout", "Landroid/view/ViewGroup;", "getSceneDescTv", "Landroid/widget/TextView;", "getVideoView", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;", "tryPlayVideo", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface y
{
  public abstract WxCropOperationLayout getOperationLayout();
  
  public abstract VideoCompositionPlayView hSJ();
  
  public abstract ViewGroup hSU();
  
  public abstract CropLayout hSV();
  
  public abstract void hSW();
  
  public abstract TextView hSX();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.y
 * JD-Core Version:    0.7.0.1
 */