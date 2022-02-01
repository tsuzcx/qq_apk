package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.doodle.PhotoDoodlePlugin;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.ui.ao;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoPencilPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "viewGroup", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "editPhotoDoodlePlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin;", "isSelected", "", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "view", "Landroid/widget/ImageView;", "getViewGroup", "()Landroid/view/ViewGroup;", "setViewGroup", "(Landroid/view/ViewGroup;)V", "checkDoodleStatus", "", "hideDooldeLayout", "hideMosaic", "hide", "onBackPress", "onClick", "v", "Landroid/view/View;", "reset", "setVisibility", "visibility", "", "plugin-recordvideo_release"})
public final class m
  implements View.OnClickListener, t
{
  private boolean isSelected;
  private final ImageView rKW;
  private d tbP;
  public final PhotoDoodlePlugin xQN;
  private ViewGroup xQO;
  
  public m(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(75562);
    this.xQO = paramViewGroup;
    this.tbP = paramd;
    paramViewGroup = this.xQO.findViewById(2131299181);
    p.g(paramViewGroup, "viewGroup.findViewById(R.id.doddle_layout)");
    this.xQN = ((PhotoDoodlePlugin)paramViewGroup);
    this.xQN.setStatus(this.tbP);
    paramViewGroup = this.xQO.findViewById(2131299280);
    p.g(paramViewGroup, "viewGroup.findViewById(R.id.editor_add_pencil)");
    this.rKW = ((ImageView)paramViewGroup);
    this.rKW.setImageDrawable(ao.k(this.rKW.getContext(), 2131690394, -1));
    this.rKW.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(75562);
  }
  
  public final boolean aoQ()
  {
    return false;
  }
  
  public final void azm() {}
  
  public final void dJO()
  {
    AppMethodBeat.i(75561);
    if (this.isSelected)
    {
      this.xQN.setVisibility(0);
      AppMethodBeat.o(75561);
      return;
    }
    this.xQN.setVisibility(4);
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
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/recordvideo/plugin/EditPhotoPencilPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    boolean bool;
    if (!this.isSelected)
    {
      bool = true;
      this.isSelected = bool;
      if (!this.isSelected) {
        break label141;
      }
      paramView = c.xWV;
      c.axc("KEY_CLICK_DOODLE_COUNT_INT");
      paramView = c.xWV;
      c.Os(7);
      this.rKW.setImageDrawable(ao.k(this.rKW.getContext(), 2131690394, this.rKW.getResources().getColor(2131101171)));
      d.b.a(this.tbP, d.c.xUX);
    }
    for (;;)
    {
      dJO();
      a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/EditPhotoPencilPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(75559);
      return;
      bool = false;
      break;
      label141:
      d.b.a(this.tbP, d.c.xVb);
      this.rKW.setImageDrawable(ao.k(this.rKW.getContext(), 2131690394, -1));
    }
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(206578);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(206578);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset()
  {
    AppMethodBeat.i(75560);
    this.isSelected = false;
    dJO();
    d.b.a(this.tbP, d.c.xVb);
    this.rKW.setImageDrawable(ao.k(this.rKW.getContext(), 2131690394, -1));
    AppMethodBeat.o(75560);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(206577);
    this.rKW.setVisibility(paramInt);
    AppMethodBeat.o(206577);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.m
 * JD-Core Version:    0.7.0.1
 */