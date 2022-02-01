package com.tencent.mm.plugin.vlog.ui.plugin;

import android.view.ViewGroup;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout;
import com.tencent.mm.plugin.vlog.player.VLogCompositionPlayView;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewProvider;", "", "getCropLayout", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "getOperationLayout", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "getParentLayout", "Landroid/view/ViewGroup;", "getVideoView", "Lcom/tencent/mm/plugin/vlog/player/VLogCompositionPlayView;", "plugin-vlog_release"})
public abstract interface d
{
  public abstract ViewGroup egg();
  
  public abstract CropLayout egh();
  
  public abstract VLogCompositionPlayView egi();
  
  public abstract WxCropOperationLayout getOperationLayout();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.d
 * JD-Core Version:    0.7.0.1
 */