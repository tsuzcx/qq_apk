package com.tencent.mm.plugin.recordvideo.plugin.filter;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.b.b;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.recordvideo.plugin.v;
import com.tencent.mm.plugin.recordvideo.plugin.v.a;
import com.tencent.mm.ui.bb;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/filter/EditPhotoFilterPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "viewGroup", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "filterPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/filter/PhotoFilterPlugin;", "isSelected", "", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "view", "Landroid/widget/ImageView;", "getViewGroup", "()Landroid/view/ViewGroup;", "setViewGroup", "(Landroid/view/ViewGroup;)V", "checkFilterStatus", "", "name", "", "onClick", "v", "Landroid/view/View;", "release", "reset", "setPreImage", "bitmap", "Landroid/graphics/Bitmap;", "setVisibility", "visibility", "", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements View.OnClickListener, v
{
  private com.tencent.mm.plugin.recordvideo.plugin.parent.a GrC;
  private ViewGroup Lst;
  public final PhotoFilterPlugin NMD;
  private final ImageView cqj;
  private boolean isSelected;
  
  public a(ViewGroup paramViewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    AppMethodBeat.i(163448);
    this.Lst = paramViewGroup;
    this.GrC = parama;
    paramViewGroup = this.Lst.findViewById(b.e.filter_layout);
    s.s(paramViewGroup, "viewGroup.findViewById(R.id.filter_layout)");
    this.NMD = ((PhotoFilterPlugin)paramViewGroup);
    this.NMD.setStatus(this.GrC);
    paramViewGroup = this.Lst.findViewById(b.e.editor_add_filter);
    s.s(paramViewGroup, "viewGroup.findViewById(R.id.editor_add_filter)");
    this.cqj = ((ImageView)paramViewGroup);
    this.cqj.setVisibility(0);
    this.cqj.setImageDrawable(bb.m(this.cqj.getContext(), b.g.icons_outlined_filters, -1));
    this.cqj.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(163448);
  }
  
  private void gIT()
  {
    AppMethodBeat.i(163444);
    if (this.isSelected)
    {
      this.NMD.setVisibility(0);
      AppMethodBeat.o(163444);
      return;
    }
    this.NMD.setVisibility(4);
    AppMethodBeat.o(163444);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(281018);
    v.a.a(this, paramRecordConfigProvider);
    AppMethodBeat.o(281018);
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(281032);
    s.u(this, "this");
    AppMethodBeat.o(281032);
  }
  
  public final String name()
  {
    return "plugin_filter";
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(281024);
    s.u(this, "this");
    AppMethodBeat.o(281024);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(281035);
    s.u(this, "this");
    AppMethodBeat.o(281035);
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(163443);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/plugin/filter/EditPhotoFilterPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    boolean bool;
    if (!this.isSelected)
    {
      bool = true;
      this.isSelected = bool;
      if (!this.isSelected) {
        break label115;
      }
      this.cqj.setImageDrawable(bb.m(this.cqj.getContext(), b.g.icons_outlined_filters, this.cqj.getResources().getColor(b.b.Orange)));
    }
    for (;;)
    {
      gIT();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/filter/EditPhotoFilterPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(163443);
      return;
      bool = false;
      break;
      label115:
      a.b.a(this.GrC, a.c.NPn);
      this.cqj.setImageDrawable(bb.m(this.cqj.getContext(), b.g.icons_outlined_filters, -1));
    }
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(281040);
    s.u(this, "this");
    AppMethodBeat.o(281040);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(281043);
    s.u(this, "this");
    AppMethodBeat.o(281043);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(281046);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(281046);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(281051);
    s.u(this, "this");
    AppMethodBeat.o(281051);
  }
  
  public final void release()
  {
    AppMethodBeat.i(163447);
    s.u((v)this, "this");
    com.tencent.mm.y.a locala = com.tencent.mm.y.a.muK;
    com.tencent.mm.y.a.stop();
    AppMethodBeat.o(163447);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(163445);
    this.isSelected = false;
    gIT();
    a.b.a(this.GrC, a.c.NPn);
    this.cqj.setImageDrawable(bb.m(this.cqj.getContext(), b.g.icons_outlined_filters, -1));
    AppMethodBeat.o(163445);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(163446);
    s.u((v)this, "this");
    this.cqj.setVisibility(paramInt);
    AppMethodBeat.o(163446);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.filter.a
 * JD-Core Version:    0.7.0.1
 */