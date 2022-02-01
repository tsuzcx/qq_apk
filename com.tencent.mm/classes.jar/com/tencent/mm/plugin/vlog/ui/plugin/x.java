package com.tencent.mm.plugin.vlog.ui.plugin;

import android.graphics.Rect;
import android.util.Size;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.i;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.ui.widget.cropview.CropLayout.c;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewImpl;", "", "currentPlayingTrack", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "getCropChangeListener", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "getCropInView", "Landroid/graphics/Rect;", "getCropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "path", "", "getOperationCallback", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "onActiveChange", "", "active", "", "onPreview", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "onUpdate", "playAfterUpdate", "seekToOriginPosition", "seekTo", "", "setMaxVisibleRect", "rect", "Landroid/graphics/RectF;", "setVideoSize", "size", "Landroid/util/Size;", "setVisibleRect", "showVideoLabel", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface x
{
  public abstract void FU(boolean paramBoolean);
  
  public abstract void a(ac paramac, boolean paramBoolean1, boolean paramBoolean2, long paramLong);
  
  public abstract void h(Size paramSize);
  
  public abstract Rect hSP();
  
  public abstract CropLayout.c hTu();
  
  public abstract WxCropOperationLayout.i hTv();
  
  public abstract void hTx();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.x
 * JD-Core Version:    0.7.0.1
 */