package com.tencent.mm.plugin.vlog.ui.plugin;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.plugin.vlog.a.h;
import com.tencent.mm.ui.bb;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiEditCropPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseIconPlugin;", "Landroid/view/View$OnClickListener;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "iconView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "onClick", "", "v", "Landroid/view/View;", "resetIconColor", "iconColor", "", "setVisibility", "visibility", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends com.tencent.mm.plugin.recordvideo.plugin.a
  implements View.OnClickListener
{
  private final ImageView dyS;
  private ViewGroup parent;
  
  public l(ViewGroup paramViewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    super(parama);
    AppMethodBeat.i(282322);
    this.parent = paramViewGroup;
    this.dyS = ((ImageView)this.parent.findViewById(a.f.editor_crop_video));
    this.dyS.setImageDrawable(bb.m(this.parent.getContext(), a.h.icons_filled_scissor, -1));
    this.dyS.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(282322);
  }
  
  public final void agy(int paramInt)
  {
    AppMethodBeat.i(282346);
    this.dyS.setImageDrawable(bb.m(this.parent.getContext(), a.h.icons_filled_scissor, paramInt));
    AppMethodBeat.o(282346);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(282333);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/MultiEditCropPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    paramView = new Bundle();
    this.GrC.a(a.c.NOH, paramView);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MultiEditCropPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(282333);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(282338);
    super.setVisibility(paramInt);
    this.dyS.setVisibility(paramInt);
    AppMethodBeat.o(282338);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.l
 * JD-Core Version:    0.7.0.1
 */