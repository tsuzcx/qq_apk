package com.tencent.mm.plugin.recordvideo.plugin;

import a.f.b.j;
import a.l;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.c.b;
import com.tencent.mm.plugin.recordvideo.plugin.doodle.PhotoDoodlePlugin;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.ui.aj;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoPencilPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "viewGroup", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "editPhotoDoodlePlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin;", "isSelected", "", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "view", "Landroid/widget/ImageView;", "getViewGroup", "()Landroid/view/ViewGroup;", "setViewGroup", "(Landroid/view/ViewGroup;)V", "checkDoodleStatus", "", "hideDooldeLayout", "onBackPress", "onClick", "v", "Landroid/view/View;", "reset", "plugin-recordvideo_release"})
public final class i
  implements View.OnClickListener, q
{
  private boolean gDG;
  private final ImageView mCy;
  private d qbI;
  public final PhotoDoodlePlugin qcn;
  private ViewGroup qco;
  
  public i(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(150651);
    this.qco = paramViewGroup;
    this.qbI = paramd;
    paramViewGroup = this.qco.findViewById(2131828713);
    j.p(paramViewGroup, "viewGroup.findViewById(R.id.doddle_layout)");
    this.qcn = ((PhotoDoodlePlugin)paramViewGroup);
    this.qcn.setStatus(this.qbI);
    paramViewGroup = this.qco.findViewById(2131828700);
    j.p(paramViewGroup, "viewGroup.findViewById(R.id.editor_add_pencil)");
    this.mCy = ((ImageView)paramViewGroup);
    this.mCy.setVisibility(0);
    this.mCy.setImageDrawable(aj.g(this.mCy.getContext(), 2131231455, -1));
    this.mCy.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(150651);
  }
  
  public final boolean cgq()
  {
    return false;
  }
  
  public final void cgy()
  {
    AppMethodBeat.i(150650);
    if (this.gDG)
    {
      this.qcn.setVisibility(0);
      AppMethodBeat.o(150650);
      return;
    }
    this.qcn.setVisibility(4);
    AppMethodBeat.o(150650);
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(150648);
    boolean bool;
    if (!this.gDG)
    {
      bool = true;
      this.gDG = bool;
      if (!this.gDG) {
        break label90;
      }
      paramView = b.qfu;
      b.Ya("KEY_CLICK_DOODLE_COUNT_INT");
      paramView = b.qfu;
      b.Cs(7);
      this.mCy.setImageDrawable(aj.g(this.mCy.getContext(), 2131231455, this.mCy.getResources().getColor(2131690701)));
    }
    for (;;)
    {
      cgy();
      AppMethodBeat.o(150648);
      return;
      bool = false;
      break;
      label90:
      d.b.a(this.qbI, d.c.qeW);
      this.mCy.setImageDrawable(aj.g(this.mCy.getContext(), 2131231455, -1));
    }
  }
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset()
  {
    AppMethodBeat.i(150649);
    this.gDG = false;
    d.b.a(this.qbI, d.c.qeW);
    this.mCy.setImageDrawable(aj.g(this.mCy.getContext(), 2131231455, -1));
    AppMethodBeat.o(150649);
  }
  
  public final void setVisibility(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.i
 * JD-Core Version:    0.7.0.1
 */