package com.tencent.mm.plugin.vlog.ui.plugin;

import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.videocomposition.play.VideoCompositionPlayView;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewProvider;", "", "getCropLayout", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "getOperationLayout", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "getParentLayout", "Landroid/view/ViewGroup;", "getSceneDescTv", "Landroid/widget/TextView;", "getVideoView", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;", "tryPlayVideo", "", "plugin-vlog_release"})
public abstract interface aa
{
  public abstract VideoCompositionPlayView fCU();
  
  public abstract ViewGroup fDf();
  
  public abstract CropLayout fDg();
  
  public abstract void fDh();
  
  public abstract TextView fDi();
  
  public abstract WxCropOperationLayout getOperationLayout();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.aa
 * JD-Core Version:    0.7.0.1
 */