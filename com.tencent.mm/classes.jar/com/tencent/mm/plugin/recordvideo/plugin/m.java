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
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoPencilPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "viewGroup", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "editPhotoDoodlePlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin;", "isSelected", "", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "view", "Landroid/widget/ImageView;", "getViewGroup", "()Landroid/view/ViewGroup;", "setViewGroup", "(Landroid/view/ViewGroup;)V", "checkDoodleStatus", "", "hideDooldeLayout", "hideMosaic", "hide", "onBackPress", "onClick", "v", "Landroid/view/View;", "reset", "setVisibility", "visibility", "", "plugin-recordvideo_release"})
public final class m
  implements View.OnClickListener, t
{
  public final PhotoDoodlePlugin BQL;
  private boolean isSelected;
  private final ImageView tkI;
  private d wgr;
  private ViewGroup zQH;
  
  public m(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(75562);
    this.zQH = paramViewGroup;
    this.wgr = paramd;
    paramViewGroup = this.zQH.findViewById(2131299726);
    p.g(paramViewGroup, "viewGroup.findViewById(R.id.doddle_layout)");
    this.BQL = ((PhotoDoodlePlugin)paramViewGroup);
    this.BQL.setStatus(this.wgr);
    paramViewGroup = this.zQH.findViewById(2131299868);
    p.g(paramViewGroup, "viewGroup.findViewById(R.id.editor_add_pencil)");
    this.tkI = ((ImageView)paramViewGroup);
    this.tkI.setImageDrawable(ar.m(this.tkI.getContext(), 2131690543, -1));
    this.tkI.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(75562);
  }
  
  public final void aSs() {}
  
  public final void eox()
  {
    AppMethodBeat.i(75561);
    if (this.isSelected)
    {
      this.BQL.setVisibility(0);
      AppMethodBeat.o(75561);
      return;
    }
    this.BQL.setVisibility(4);
    AppMethodBeat.o(75561);
  }
  
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
    AppMethodBeat.i(75559);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/recordvideo/plugin/EditPhotoPencilPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
      a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/EditPhotoPencilPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(75559);
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
    AppMethodBeat.i(237294);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(237294);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset()
  {
    AppMethodBeat.i(75560);
    this.isSelected = false;
    eox();
    d.b.a(this.wgr, d.c.BVI);
    this.tkI.setImageDrawable(ar.m(this.tkI.getContext(), 2131690543, -1));
    AppMethodBeat.o(75560);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(237293);
    this.tkI.setVisibility(paramInt);
    AppMethodBeat.o(237293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.m
 * JD-Core Version:    0.7.0.1
 */