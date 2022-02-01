package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.doodle.PhotoDoodlePlugin;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.ui.am;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoPencilPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "viewGroup", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "editPhotoDoodlePlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin;", "isSelected", "", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "view", "Landroid/widget/ImageView;", "getViewGroup", "()Landroid/view/ViewGroup;", "setViewGroup", "(Landroid/view/ViewGroup;)V", "checkDoodleStatus", "", "hideDooldeLayout", "hideMosaic", "hide", "onBackPress", "onClick", "v", "Landroid/view/View;", "reset", "setVisibility", "visibility", "", "plugin-recordvideo_release"})
public final class m
  implements View.OnClickListener, t
{
  private boolean ira;
  private final ImageView qkg;
  private d vjo;
  public final PhotoDoodlePlugin vkq;
  private ViewGroup vkr;
  
  public m(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(75562);
    this.vkr = paramViewGroup;
    this.vjo = paramd;
    paramViewGroup = this.vkr.findViewById(2131299181);
    k.g(paramViewGroup, "viewGroup.findViewById(R.id.doddle_layout)");
    this.vkq = ((PhotoDoodlePlugin)paramViewGroup);
    this.vkq.setStatus(this.vjo);
    paramViewGroup = this.vkr.findViewById(2131299280);
    k.g(paramViewGroup, "viewGroup.findViewById(R.id.editor_add_pencil)");
    this.qkg = ((ImageView)paramViewGroup);
    this.qkg.setImageDrawable(am.i(this.qkg.getContext(), 2131690394, -1));
    this.qkg.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(75562);
  }
  
  public final void apt() {}
  
  public final boolean dia()
  {
    return false;
  }
  
  public final void dip()
  {
    AppMethodBeat.i(75561);
    if (this.ira)
    {
      this.vkq.setVisibility(0);
      AppMethodBeat.o(75561);
      return;
    }
    this.vkq.setVisibility(4);
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
    if (!this.ira)
    {
      bool = true;
      this.ira = bool;
      if (!this.ira) {
        break label100;
      }
      paramView = b.vpp;
      b.alO("KEY_CLICK_DOODLE_COUNT_INT");
      paramView = b.vpp;
      b.Ko(7);
      this.qkg.setImageDrawable(am.i(this.qkg.getContext(), 2131690394, this.qkg.getResources().getColor(2131101171)));
      d.b.a(this.vjo, d.c.vom);
    }
    for (;;)
    {
      dip();
      AppMethodBeat.o(75559);
      return;
      bool = false;
      break;
      label100:
      d.b.a(this.vjo, d.c.voq);
      this.qkg.setImageDrawable(am.i(this.qkg.getContext(), 2131690394, -1));
    }
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset()
  {
    AppMethodBeat.i(75560);
    this.ira = false;
    dip();
    d.b.a(this.vjo, d.c.voq);
    this.qkg.setImageDrawable(am.i(this.qkg.getContext(), 2131690394, -1));
    AppMethodBeat.o(75560);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(204079);
    this.qkg.setVisibility(paramInt);
    AppMethodBeat.o(204079);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.m
 * JD-Core Version:    0.7.0.1
 */