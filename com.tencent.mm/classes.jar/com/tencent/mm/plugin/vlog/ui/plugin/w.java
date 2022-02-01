package com.tencent.mm.plugin.vlog.ui.plugin;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.a;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.vlog.a.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/NormalModeContainerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "imageView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "videoView", "view", "setVisibility", "", "visibility", "", "setupImage", "setupVideo", "plugin-vlog_release"})
public final class w
  extends a
{
  private d APl;
  private final View Nwa;
  private final View Nwb;
  private ViewGroup parent;
  private View view;
  
  public w(ViewGroup paramViewGroup, d paramd)
  {
    super(paramd, (byte)0);
    AppMethodBeat.i(227814);
    this.parent = paramViewGroup;
    this.APl = paramd;
    this.Nwa = this.parent.findViewById(a.f.normal_mode_image_container);
    this.Nwb = this.parent.findViewById(a.f.vlog_editor_thumb_view);
    this.view = this.Nwb;
    AppMethodBeat.o(227814);
  }
  
  public final void gvJ()
  {
    this.view = this.Nwa;
  }
  
  public final void gvK()
  {
    AppMethodBeat.i(227806);
    View localView = this.Nwa;
    p.j(localView, "imageView");
    localView.setVisibility(8);
    this.view = this.Nwb;
    AppMethodBeat.o(227806);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(227808);
    View localView = this.view;
    p.j(localView, "view");
    localView.setVisibility(paramInt);
    AppMethodBeat.o(227808);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.w
 * JD-Core Version:    0.7.0.1
 */