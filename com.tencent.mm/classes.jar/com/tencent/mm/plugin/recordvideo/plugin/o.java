package com.tencent.mm.plugin.recordvideo.plugin;

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
import com.tencent.mm.plugin.recordvideo.f.c;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.doodle.PhotoDoodlePlugin;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.ui.bb;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoPencilPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "viewGroup", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "editPhotoDoodlePlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin;", "isSelected", "", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "view", "Landroid/widget/ImageView;", "getViewGroup", "()Landroid/view/ViewGroup;", "setViewGroup", "(Landroid/view/ViewGroup;)V", "checkDoodleStatus", "", "hideDooldeLayout", "hideMosaic", "hide", "onBackPress", "onClick", "v", "Landroid/view/View;", "reset", "setVisibility", "visibility", "", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  implements View.OnClickListener, v
{
  private com.tencent.mm.plugin.recordvideo.plugin.parent.a GrC;
  private ViewGroup Lst;
  public final PhotoDoodlePlugin NKx;
  private final ImageView cqj;
  private boolean isSelected;
  
  public o(ViewGroup paramViewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    AppMethodBeat.i(75562);
    this.Lst = paramViewGroup;
    this.GrC = parama;
    paramViewGroup = this.Lst.findViewById(b.e.doddle_layout);
    s.s(paramViewGroup, "viewGroup.findViewById(R.id.doddle_layout)");
    this.NKx = ((PhotoDoodlePlugin)paramViewGroup);
    this.NKx.setStatus(this.GrC);
    paramViewGroup = this.Lst.findViewById(b.e.editor_add_pencil);
    s.s(paramViewGroup, "viewGroup.findViewById(R.id.editor_add_pencil)");
    this.cqj = ((ImageView)paramViewGroup);
    this.cqj.setImageDrawable(bb.m(this.cqj.getContext(), b.g.icons_filled_duddle, -1));
    this.cqj.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(75562);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(280712);
    v.a.a(this, paramRecordConfigProvider);
    AppMethodBeat.o(280712);
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(280732);
    s.u(this, "this");
    AppMethodBeat.o(280732);
  }
  
  public final void ghk()
  {
    AppMethodBeat.i(75561);
    if (this.isSelected)
    {
      this.NKx.setVisibility(0);
      AppMethodBeat.o(75561);
      return;
    }
    this.NKx.setVisibility(4);
    AppMethodBeat.o(75561);
  }
  
  public final String name()
  {
    AppMethodBeat.i(280718);
    String str = v.a.b(this);
    AppMethodBeat.o(280718);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(280726);
    s.u(this, "this");
    AppMethodBeat.o(280726);
  }
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(75559);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/plugin/EditPhotoPencilPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    boolean bool;
    if (!this.isSelected)
    {
      bool = true;
      this.isSelected = bool;
      if (!this.isSelected) {
        break label143;
      }
      paramView = c.NRf;
      c.aTg("KEY_CLICK_DOODLE_COUNT_INT");
      paramView = c.NRf;
      c.agG(7);
      this.cqj.setImageDrawable(bb.m(this.cqj.getContext(), b.g.icons_filled_duddle, this.cqj.getResources().getColor(b.b.wechat_green)));
      a.b.a(this.GrC, a.c.NOY);
    }
    for (;;)
    {
      ghk();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/EditPhotoPencilPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(75559);
      return;
      bool = false;
      break;
      label143:
      a.b.a(this.GrC, a.c.NPc);
      this.cqj.setImageDrawable(bb.m(this.cqj.getContext(), b.g.icons_filled_duddle, -1));
    }
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(280742);
    s.u(this, "this");
    AppMethodBeat.o(280742);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(280749);
    s.u(this, "this");
    AppMethodBeat.o(280749);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(280758);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(280758);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(280765);
    s.u(this, "this");
    AppMethodBeat.o(280765);
  }
  
  public final void release()
  {
    AppMethodBeat.i(280776);
    s.u(this, "this");
    AppMethodBeat.o(280776);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(75560);
    this.isSelected = false;
    ghk();
    a.b.a(this.GrC, a.c.NPc);
    this.cqj.setImageDrawable(bb.m(this.cqj.getContext(), b.g.icons_filled_duddle, -1));
    AppMethodBeat.o(75560);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(280702);
    s.u((v)this, "this");
    this.cqj.setVisibility(paramInt);
    AppMethodBeat.o(280702);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.o
 * JD-Core Version:    0.7.0.1
 */