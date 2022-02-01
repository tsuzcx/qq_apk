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
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/editor/MultitalkScreenEditPhotoPencilPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "viewGroup", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "editPhotoDoodlePlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin;", "editPhotoDoodlePluginRoot", "Landroid/widget/RelativeLayout;", "isSelected", "", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "view", "Landroid/widget/ImageView;", "getViewGroup", "()Landroid/view/ViewGroup;", "setViewGroup", "(Landroid/view/ViewGroup;)V", "checkDoodleStatus", "", "onBackPress", "onClick", "v", "Landroid/view/View;", "refreshDoodleLayout", "isLand", "reset", "setVisibility", "visibility", "", "plugin-multitalk_release"})
public final class d
  implements View.OnClickListener, t
{
  private boolean isSelected;
  private final ImageView tkI;
  private com.tencent.mm.plugin.recordvideo.plugin.parent.d wgr;
  public com.tencent.mm.plugin.recordvideo.plugin.doodle.b zQF;
  public final RelativeLayout zQG;
  private ViewGroup zQH;
  
  public d(ViewGroup paramViewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(239755);
    this.zQH = paramViewGroup;
    this.wgr = paramd;
    paramViewGroup = this.zQH.findViewById(2131299727);
    p.g(paramViewGroup, "viewGroup.findViewById(R.id.doddle_layout_root)");
    this.zQG = ((RelativeLayout)paramViewGroup);
    paramViewGroup = k.zTz;
    paramViewGroup = this.zQH.getContext();
    p.g(paramViewGroup, "viewGroup.context");
    if (k.a.gE(paramViewGroup) != 90)
    {
      paramViewGroup = k.zTz;
      paramViewGroup = this.zQH.getContext();
      p.g(paramViewGroup, "viewGroup.context");
      if (k.a.gE(paramViewGroup) != 270) {
        break label214;
      }
    }
    label214:
    for (boolean bool = true;; bool = false)
    {
      this.zQF = new com.tencent.mm.plugin.recordvideo.plugin.doodle.b(bool, this.zQG);
      paramViewGroup = this.zQF;
      if (paramViewGroup != null)
      {
        paramd = this.wgr;
        p.h(paramd, "status");
        paramViewGroup.BSR = paramd;
      }
      paramViewGroup = this.zQH.findViewById(2131299868);
      p.g(paramViewGroup, "viewGroup.findViewById(R.id.editor_add_pencil)");
      this.tkI = ((ImageView)paramViewGroup);
      this.tkI.setImageDrawable(ar.m(this.tkI.getContext(), 2131690543, -1));
      this.tkI.setOnClickListener((View.OnClickListener)this);
      AppMethodBeat.o(239755);
      return;
    }
  }
  
  private void eox()
  {
    AppMethodBeat.i(239754);
    if (this.isSelected)
    {
      localb = this.zQF;
      if (localb != null)
      {
        localb.l(Integer.valueOf(0));
        AppMethodBeat.o(239754);
        return;
      }
      AppMethodBeat.o(239754);
      return;
    }
    com.tencent.mm.plugin.recordvideo.plugin.doodle.b localb = this.zQF;
    if (localb != null)
    {
      localb.l(Integer.valueOf(4));
      AppMethodBeat.o(239754);
      return;
    }
    AppMethodBeat.o(239754);
  }
  
  public final void aSs() {}
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(239751);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/multitalk/ui/editor/MultitalkScreenEditPhotoPencilPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    boolean bool;
    if (!this.isSelected)
    {
      bool = true;
      this.isSelected = bool;
      if (!this.isSelected) {
        break label141;
      }
      paramView = c.BXI;
      c.aLu("KEY_CLICK_DOODLE_COUNT_INT");
      paramView = c.BXI;
      c.VH(7);
      this.tkI.setImageDrawable(ar.m(this.tkI.getContext(), 2131690543, this.tkI.getResources().getColor(2131101414)));
      d.b.a(this.wgr, d.c.BVE);
    }
    for (;;)
    {
      eox();
      a.a(this, "com/tencent/mm/plugin/multitalk/ui/editor/MultitalkScreenEditPhotoPencilPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(239751);
      return;
      bool = false;
      break;
      label141:
      d.b.a(this.wgr, d.c.BVI);
      this.tkI.setImageDrawable(ar.m(this.tkI.getContext(), 2131690543, -1));
    }
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(239756);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(239756);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset()
  {
    AppMethodBeat.i(239752);
    this.isSelected = false;
    eox();
    d.b.a(this.wgr, d.c.BVI);
    this.tkI.setImageDrawable(ar.m(this.tkI.getContext(), 2131690543, -1));
    AppMethodBeat.o(239752);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(239753);
    this.tkI.setVisibility(paramInt);
    RelativeLayout localRelativeLayout = this.zQG;
    if (localRelativeLayout != null)
    {
      localRelativeLayout.setVisibility(paramInt);
      AppMethodBeat.o(239753);
      return;
    }
    AppMethodBeat.o(239753);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.a.d
 * JD-Core Version:    0.7.0.1
 */