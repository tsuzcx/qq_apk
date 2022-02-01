package com.tencent.mm.plugin.recordvideo.plugin;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.ui.au;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditBackToRecordPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseIconPlugin;", "view", "Landroid/widget/ImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/ImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Landroid/widget/ImageView;", "setView", "(Landroid/widget/ImageView;)V", "onClick", "", "v", "Landroid/view/View;", "resetIconColor", "iconColor", "", "setVisibility", "visibility", "plugin-recordvideo_release"})
public final class f
  extends a
  implements View.OnClickListener
{
  private d APl;
  private ImageView wRg;
  
  public f(ImageView paramImageView, d paramd)
  {
    super(paramd, (byte)0);
    AppMethodBeat.i(75485);
    this.wRg = paramImageView;
    this.APl = paramd;
    this.wRg.setImageDrawable(au.o(this.wRg.getContext(), b.g.icons_filled_previous2, -1));
    this.wRg.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(75485);
  }
  
  public final void acl(int paramInt)
  {
    AppMethodBeat.i(216558);
    this.wRg.setImageDrawable(au.o(this.wRg.getContext(), b.g.icons_filled_previous2, paramInt));
    AppMethodBeat.o(216558);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(75483);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/plugin/EditBackToRecordPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    d.b.a(this.APl, d.c.HRD);
    paramView = c.HUw;
    c.acq(11);
    paramView = c.HUw;
    c.acr(12);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/EditBackToRecordPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(75483);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75484);
    this.wRg.setVisibility(paramInt);
    AppMethodBeat.o(75484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.f
 * JD-Core Version:    0.7.0.1
 */