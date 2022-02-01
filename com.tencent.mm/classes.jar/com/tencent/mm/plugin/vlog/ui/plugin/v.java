package com.tencent.mm.plugin.vlog.ui.plugin;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.a.f;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/NormalModeContainerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "imageView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "videoView", "view", "setVisibility", "", "visibility", "", "setupImage", "setupVideo", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class v
  extends com.tencent.mm.plugin.recordvideo.plugin.a
{
  private final View CCk;
  private final View Ujn;
  private ViewGroup parent;
  private View view;
  
  public v(ViewGroup paramViewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    super(parama);
    AppMethodBeat.i(282476);
    this.parent = paramViewGroup;
    this.CCk = this.parent.findViewById(a.f.normal_mode_image_container);
    this.Ujn = this.parent.findViewById(a.f.vlog_editor_thumb_view);
    this.view = this.Ujn;
    AppMethodBeat.o(282476);
  }
  
  public final void hTy()
  {
    this.view = this.CCk;
  }
  
  public final void hTz()
  {
    AppMethodBeat.i(282494);
    this.CCk.setVisibility(8);
    this.view = this.Ujn;
    AppMethodBeat.o(282494);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(282504);
    this.view.setVisibility(paramInt);
    AppMethodBeat.o(282504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.v
 * JD-Core Version:    0.7.0.1
 */