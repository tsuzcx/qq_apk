package com.tencent.mm.plugin.recordvideo.plugin;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.plugin.recordvideo.f.c;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.ui.bb;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditBackToRecordPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseIconPlugin;", "view", "Landroid/widget/ImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/ImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Landroid/widget/ImageView;", "setView", "(Landroid/widget/ImageView;)V", "onClick", "", "v", "Landroid/view/View;", "resetIconColor", "iconColor", "", "setVisibility", "visibility", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends a
  implements View.OnClickListener
{
  private ImageView cqj;
  
  public g(ImageView paramImageView, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    super(parama);
    AppMethodBeat.i(75485);
    this.cqj = paramImageView;
    this.cqj.setImageDrawable(bb.m(this.cqj.getContext(), b.g.icons_filled_previous2, -1));
    this.cqj.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(75485);
  }
  
  public final void agy(int paramInt)
  {
    AppMethodBeat.i(280859);
    this.cqj.setImageDrawable(bb.m(this.cqj.getContext(), b.g.icons_filled_previous2, paramInt));
    AppMethodBeat.o(280859);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(75483);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/plugin/EditBackToRecordPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    a.b.a(this.GrC, a.c.NOj);
    paramView = c.NRf;
    c.agG(11);
    paramView = c.NRf;
    c.agH(12);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/EditBackToRecordPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(75483);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75484);
    this.cqj.setVisibility(paramInt);
    AppMethodBeat.o(75484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.g
 * JD-Core Version:    0.7.0.1
 */