package com.tencent.mm.plugin.multitalk.ui.a;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.ui.widget.k;
import com.tencent.mm.plugin.multitalk.ui.widget.k.a;
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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/editor/MultitalkScreenEditPhotoPencilPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "viewGroup", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "editPhotoDoodlePlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin;", "editPhotoDoodlePluginRoot", "Landroid/widget/RelativeLayout;", "isSelected", "", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "view", "Landroid/widget/ImageView;", "getViewGroup", "()Landroid/view/ViewGroup;", "setViewGroup", "(Landroid/view/ViewGroup;)V", "checkDoodleStatus", "", "onBackPress", "onClick", "v", "Landroid/view/View;", "refreshDoodleLayout", "isLand", "reset", "setVisibility", "visibility", "", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements View.OnClickListener, v
{
  private com.tencent.mm.plugin.recordvideo.plugin.parent.a GrC;
  private ViewGroup Lst;
  public com.tencent.mm.plugin.recordvideo.plugin.doodle.b Lsu;
  public final RelativeLayout Lsv;
  private final ImageView cqj;
  private boolean isSelected;
  
  public c(ViewGroup paramViewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    AppMethodBeat.i(285297);
    this.Lst = paramViewGroup;
    this.GrC = parama;
    paramViewGroup = this.Lst.findViewById(b.e.doddle_layout_root);
    s.s(paramViewGroup, "viewGroup.findViewById(R.id.doddle_layout_root)");
    this.Lsv = ((RelativeLayout)paramViewGroup);
    paramViewGroup = k.Lvg;
    paramViewGroup = this.Lst.getContext();
    s.s(paramViewGroup, "viewGroup.context");
    if (k.a.iY(paramViewGroup) != 90)
    {
      paramViewGroup = k.Lvg;
      paramViewGroup = this.Lst.getContext();
      s.s(paramViewGroup, "viewGroup.context");
      if (k.a.iY(paramViewGroup) != 270) {
        break label217;
      }
    }
    label217:
    for (boolean bool = true;; bool = false)
    {
      this.Lsu = new com.tencent.mm.plugin.recordvideo.plugin.doodle.b(bool, this.Lsv);
      paramViewGroup = this.Lsu;
      if (paramViewGroup != null)
      {
        parama = this.GrC;
        s.u(parama, "status");
        paramViewGroup.NMm = parama;
      }
      paramViewGroup = this.Lst.findViewById(b.e.editor_add_pencil);
      s.s(paramViewGroup, "viewGroup.findViewById(R.id.editor_add_pencil)");
      this.cqj = ((ImageView)paramViewGroup);
      this.cqj.setImageDrawable(bb.m(this.cqj.getContext(), b.g.icons_filled_duddle, -1));
      this.cqj.setOnClickListener((View.OnClickListener)this);
      AppMethodBeat.o(285297);
      return;
    }
  }
  
  private void ghk()
  {
    AppMethodBeat.i(285302);
    com.tencent.mm.plugin.recordvideo.plugin.doodle.b localb;
    if (this.isSelected)
    {
      localb = this.Lsu;
      if (localb != null)
      {
        localb.A(Integer.valueOf(0));
        AppMethodBeat.o(285302);
      }
    }
    else
    {
      localb = this.Lsu;
      if (localb != null) {
        localb.A(Integer.valueOf(4));
      }
    }
    AppMethodBeat.o(285302);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(285342);
    v.a.a(this, paramRecordConfigProvider);
    AppMethodBeat.o(285342);
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(285355);
    s.u(this, "this");
    AppMethodBeat.o(285355);
  }
  
  public final String name()
  {
    AppMethodBeat.i(285348);
    String str = v.a.b(this);
    AppMethodBeat.o(285348);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(285351);
    s.u(this, "this");
    AppMethodBeat.o(285351);
  }
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(285313);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/editor/MultitalkScreenEditPhotoPencilPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    boolean bool;
    if (!this.isSelected)
    {
      bool = true;
      this.isSelected = bool;
      if (!this.isSelected) {
        break label143;
      }
      paramView = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.aTg("KEY_CLICK_DOODLE_COUNT_INT");
      paramView = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.agG(7);
      this.cqj.setImageDrawable(bb.m(this.cqj.getContext(), b.g.icons_filled_duddle, this.cqj.getResources().getColor(b.b.wechat_green)));
      a.b.a(this.GrC, a.c.NOY);
    }
    for (;;)
    {
      ghk();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/editor/MultitalkScreenEditPhotoPencilPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(285313);
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
    AppMethodBeat.i(285359);
    s.u(this, "this");
    AppMethodBeat.o(285359);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(285363);
    s.u(this, "this");
    AppMethodBeat.o(285363);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(285369);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(285369);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(285376);
    s.u(this, "this");
    AppMethodBeat.o(285376);
  }
  
  public final void release()
  {
    AppMethodBeat.i(285385);
    s.u(this, "this");
    AppMethodBeat.o(285385);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(285322);
    this.isSelected = false;
    ghk();
    a.b.a(this.GrC, a.c.NPc);
    this.cqj.setImageDrawable(bb.m(this.cqj.getContext(), b.g.icons_filled_duddle, -1));
    AppMethodBeat.o(285322);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(285328);
    s.u((v)this, "this");
    this.cqj.setVisibility(paramInt);
    RelativeLayout localRelativeLayout = this.Lsv;
    if (localRelativeLayout != null) {
      localRelativeLayout.setVisibility(paramInt);
    }
    AppMethodBeat.o(285328);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.a.c
 * JD-Core Version:    0.7.0.1
 */