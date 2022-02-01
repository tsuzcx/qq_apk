package com.tencent.mm.plugin.vlog.ui.plugin;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.plugin.vlog.a.h;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiEditCropPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseIconPlugin;", "Landroid/view/View$OnClickListener;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "iconView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "onClick", "", "v", "Landroid/view/View;", "resetIconColor", "iconColor", "", "setVisibility", "visibility", "plugin-vlog_release"})
public final class l
  extends com.tencent.mm.plugin.recordvideo.plugin.a
  implements View.OnClickListener
{
  private d APl;
  private final ImageView bFS;
  private ViewGroup parent;
  
  public l(ViewGroup paramViewGroup, d paramd)
  {
    super(paramd, (byte)0);
    AppMethodBeat.i(249333);
    this.parent = paramViewGroup;
    this.APl = paramd;
    this.bFS = ((ImageView)this.parent.findViewById(a.f.editor_crop_video));
    this.bFS.setImageDrawable(au.o(this.parent.getContext(), a.h.icons_filled_scissor, -1));
    this.bFS.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(249333);
  }
  
  public final void acl(int paramInt)
  {
    AppMethodBeat.i(249332);
    this.bFS.setImageDrawable(au.o(this.parent.getContext(), a.h.icons_filled_scissor, paramInt));
    AppMethodBeat.o(249332);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(249327);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/MultiEditCropPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    paramView = new Bundle();
    this.APl.a(d.c.HSb, paramView);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MultiEditCropPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(249327);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(249329);
    super.setVisibility(paramInt);
    ImageView localImageView = this.bFS;
    p.j(localImageView, "iconView");
    localImageView.setVisibility(paramInt);
    AppMethodBeat.o(249329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.l
 * JD-Core Version:    0.7.0.1
 */