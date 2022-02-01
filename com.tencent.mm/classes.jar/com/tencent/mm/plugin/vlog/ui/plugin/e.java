package com.tencent.mm.plugin.vlog.ui.plugin;

import android.view.ViewGroup;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout;
import com.tencent.mm.plugin.vlog.player.VLogCompositionPlayView;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewProvider;", "", "getCropLayout", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "getOperationLayout", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "getParentLayout", "Landroid/view/ViewGroup;", "getVideoView", "Lcom/tencent/mm/plugin/vlog/player/VLogCompositionPlayView;", "plugin-vlog_release"})
public abstract interface e
{
  public abstract ViewGroup fZg();
  
  public abstract CropLayout fZh();
  
  public abstract VLogCompositionPlayView fZi();
  
  public abstract WxCropOperationLayout getOperationLayout();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.e
 * JD-Core Version:    0.7.0.1
 */