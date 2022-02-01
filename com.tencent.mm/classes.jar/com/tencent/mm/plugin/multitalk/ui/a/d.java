package com.tencent.mm.plugin.multitalk.ui.a;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.multitalk.ui.widget.k;
import com.tencent.mm.plugin.multitalk.ui.widget.k.a;
import com.tencent.mm.plugin.recordvideo.b.b;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.u;
import com.tencent.mm.plugin.recordvideo.plugin.u.a;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/editor/MultitalkScreenEditPhotoPencilPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "viewGroup", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "editPhotoDoodlePlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin;", "editPhotoDoodlePluginRoot", "Landroid/widget/RelativeLayout;", "isSelected", "", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "view", "Landroid/widget/ImageView;", "getViewGroup", "()Landroid/view/ViewGroup;", "setViewGroup", "(Landroid/view/ViewGroup;)V", "checkDoodleStatus", "", "onBackPress", "onClick", "v", "Landroid/view/View;", "refreshDoodleLayout", "isLand", "reset", "setVisibility", "visibility", "", "plugin-multitalk_release"})
public final class d
  implements View.OnClickListener, u
{
  private com.tencent.mm.plugin.recordvideo.plugin.parent.d APl;
  public com.tencent.mm.plugin.recordvideo.plugin.doodle.b Fwi;
  public final RelativeLayout Fwj;
  private ViewGroup Fwk;
  private boolean isSelected;
  private final ImageView wRg;
  
  public d(ViewGroup paramViewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(196466);
    this.Fwk = paramViewGroup;
    this.APl = paramd;
    paramViewGroup = this.Fwk.findViewById(b.e.doddle_layout_root);
    p.j(paramViewGroup, "viewGroup.findViewById(R.id.doddle_layout_root)");
    this.Fwj = ((RelativeLayout)paramViewGroup);
    paramViewGroup = k.Fzb;
    paramViewGroup = this.Fwk.getContext();
    p.j(paramViewGroup, "viewGroup.context");
    if (k.a.hB(paramViewGroup) != 90)
    {
      paramViewGroup = k.Fzb;
      paramViewGroup = this.Fwk.getContext();
      p.j(paramViewGroup, "viewGroup.context");
      if (k.a.hB(paramViewGroup) != 270) {
        break label217;
      }
    }
    label217:
    for (boolean bool = true;; bool = false)
    {
      this.Fwi = new com.tencent.mm.plugin.recordvideo.plugin.doodle.b(bool, this.Fwj);
      paramViewGroup = this.Fwi;
      if (paramViewGroup != null)
      {
        paramd = this.APl;
        p.k(paramd, "status");
        paramViewGroup.HPF = paramd;
      }
      paramViewGroup = this.Fwk.findViewById(b.e.editor_add_pencil);
      p.j(paramViewGroup, "viewGroup.findViewById(R.id.editor_add_pencil)");
      this.wRg = ((ImageView)paramViewGroup);
      this.wRg.setImageDrawable(au.o(this.wRg.getContext(), b.g.icons_filled_duddle, -1));
      this.wRg.setOnClickListener((View.OnClickListener)this);
      AppMethodBeat.o(196466);
      return;
    }
  }
  
  private void eYp()
  {
    AppMethodBeat.i(196461);
    if (this.isSelected)
    {
      localb = this.Fwi;
      if (localb != null)
      {
        localb.t(Integer.valueOf(0));
        AppMethodBeat.o(196461);
        return;
      }
      AppMethodBeat.o(196461);
      return;
    }
    com.tencent.mm.plugin.recordvideo.plugin.doodle.b localb = this.Fwi;
    if (localb != null)
    {
      localb.t(Integer.valueOf(4));
      AppMethodBeat.o(196461);
      return;
    }
    AppMethodBeat.o(196461);
  }
  
  public final void bbp() {}
  
  public final String name()
  {
    AppMethodBeat.i(196467);
    String str = getClass().getName();
    AppMethodBeat.o(196467);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(196457);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/multitalk/ui/editor/MultitalkScreenEditPhotoPencilPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    boolean bool;
    if (!this.isSelected)
    {
      bool = true;
      this.isSelected = bool;
      if (!this.isSelected) {
        break label143;
      }
      paramView = c.HUw;
      c.aVY("KEY_CLICK_DOODLE_COUNT_INT");
      paramView = c.HUw;
      c.acq(7);
      this.wRg.setImageDrawable(au.o(this.wRg.getContext(), b.g.icons_filled_duddle, this.wRg.getResources().getColor(b.b.wechat_green)));
      d.b.a(this.APl, d.c.HSs);
    }
    for (;;)
    {
      eYp();
      a.a(this, "com/tencent/mm/plugin/multitalk/ui/editor/MultitalkScreenEditPhotoPencilPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(196457);
      return;
      bool = false;
      break;
      label143:
      d.b.a(this.APl, d.c.HSw);
      this.wRg.setImageDrawable(au.o(this.wRg.getContext(), b.g.icons_filled_duddle, -1));
    }
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(196468);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    u.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(196468);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset()
  {
    AppMethodBeat.i(196458);
    this.isSelected = false;
    eYp();
    d.b.a(this.APl, d.c.HSw);
    this.wRg.setImageDrawable(au.o(this.wRg.getContext(), b.g.icons_filled_duddle, -1));
    AppMethodBeat.o(196458);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(196459);
    this.wRg.setVisibility(paramInt);
    RelativeLayout localRelativeLayout = this.Fwj;
    if (localRelativeLayout != null)
    {
      localRelativeLayout.setVisibility(paramInt);
      AppMethodBeat.o(196459);
      return;
    }
    AppMethodBeat.o(196459);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.a.d
 * JD-Core Version:    0.7.0.1
 */