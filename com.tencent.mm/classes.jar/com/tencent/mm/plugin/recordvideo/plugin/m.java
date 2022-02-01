package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.doodle.PhotoDoodlePlugin;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.ui.am;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoPencilPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "viewGroup", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "editPhotoDoodlePlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin;", "isSelected", "", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "view", "Landroid/widget/ImageView;", "getViewGroup", "()Landroid/view/ViewGroup;", "setViewGroup", "(Landroid/view/ViewGroup;)V", "checkDoodleStatus", "", "hideDooldeLayout", "hideMosaic", "hide", "onBackPress", "onClick", "v", "Landroid/view/View;", "reset", "setVisibility", "visibility", "", "plugin-recordvideo_release"})
public final class m
  implements View.OnClickListener, t
{
  private boolean isSelected;
  private final ImageView qSI;
  private d rTT;
  public final PhotoDoodlePlugin wsS;
  private ViewGroup wsT;
  
  public m(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(75562);
    this.wsT = paramViewGroup;
    this.rTT = paramd;
    paramViewGroup = this.wsT.findViewById(2131299181);
    k.g(paramViewGroup, "viewGroup.findViewById(R.id.doddle_layout)");
    this.wsS = ((PhotoDoodlePlugin)paramViewGroup);
    this.wsS.setStatus(this.rTT);
    paramViewGroup = this.wsT.findViewById(2131299280);
    k.g(paramViewGroup, "viewGroup.findViewById(R.id.editor_add_pencil)");
    this.qSI = ((ImageView)paramViewGroup);
    this.qSI.setImageDrawable(am.k(this.qSI.getContext(), 2131690394, -1));
    this.qSI.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(75562);
  }
  
  public final boolean alO()
  {
    return false;
  }
  
  public final void awk() {}
  
  public final void dvZ()
  {
    AppMethodBeat.i(75561);
    if (this.isSelected)
    {
      this.wsS.setVisibility(0);
      AppMethodBeat.o(75561);
      return;
    }
    this.wsS.setVisibility(4);
    AppMethodBeat.o(75561);
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(75559);
    boolean bool;
    if (!this.isSelected)
    {
      bool = true;
      this.isSelected = bool;
      if (!this.isSelected) {
        break label100;
      }
      paramView = c.wyg;
      c.aqO("KEY_CLICK_DOODLE_COUNT_INT");
      paramView = c.wyg;
      c.Mn(7);
      this.qSI.setImageDrawable(am.k(this.qSI.getContext(), 2131690394, this.qSI.getResources().getColor(2131101171)));
      d.b.a(this.rTT, d.c.wwT);
    }
    for (;;)
    {
      dvZ();
      AppMethodBeat.o(75559);
      return;
      bool = false;
      break;
      label100:
      d.b.a(this.rTT, d.c.wwX);
      this.qSI.setImageDrawable(am.k(this.qSI.getContext(), 2131690394, -1));
    }
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset()
  {
    AppMethodBeat.i(75560);
    this.isSelected = false;
    dvZ();
    d.b.a(this.rTT, d.c.wwX);
    this.qSI.setImageDrawable(am.k(this.qSI.getContext(), 2131690394, -1));
    AppMethodBeat.o(75560);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(199267);
    this.qSI.setVisibility(paramInt);
    AppMethodBeat.o(199267);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.m
 * JD-Core Version:    0.7.0.1
 */