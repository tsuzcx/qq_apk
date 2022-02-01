package com.tencent.mm.plugin.recordvideo.plugin.filter;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.ui.am;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/plugin/filter/EditPhotoFilterPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "viewGroup", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "filterPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/filter/PhotoFilterPlugin;", "isSelected", "", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "view", "Landroid/widget/ImageView;", "getViewGroup", "()Landroid/view/ViewGroup;", "setViewGroup", "(Landroid/view/ViewGroup;)V", "checkFilterStatus", "", "name", "", "onClick", "v", "Landroid/view/View;", "release", "reset", "setPreImage", "bitmap", "Landroid/graphics/Bitmap;", "setVisibility", "visibility", "", "plugin-recordvideo_release"})
public final class a
  implements View.OnClickListener, t
{
  private boolean isSelected;
  private final ImageView qSI;
  private d rTT;
  private ViewGroup wsT;
  public final PhotoFilterPlugin wuS;
  
  public a(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(163448);
    this.wsT = paramViewGroup;
    this.rTT = paramd;
    paramViewGroup = this.wsT.findViewById(2131299960);
    k.g(paramViewGroup, "viewGroup.findViewById(R.id.filter_layout)");
    this.wuS = ((PhotoFilterPlugin)paramViewGroup);
    this.wuS.setStatus(this.rTT);
    paramViewGroup = this.wsT.findViewById(2131299276);
    k.g(paramViewGroup, "viewGroup.findViewById(R.id.editor_add_filter)");
    this.qSI = ((ImageView)paramViewGroup);
    this.qSI.setVisibility(0);
    this.qSI.setImageDrawable(am.k(this.qSI.getContext(), 2131690571, -1));
    this.qSI.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(163448);
  }
  
  private void dwg()
  {
    AppMethodBeat.i(163444);
    if (this.isSelected)
    {
      this.wuS.setVisibility(0);
      AppMethodBeat.o(163444);
      return;
    }
    this.wuS.setVisibility(4);
    AppMethodBeat.o(163444);
  }
  
  public final boolean alO()
  {
    return false;
  }
  
  public final void awk() {}
  
  public final String name()
  {
    return "plugin_filter";
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(163443);
    boolean bool;
    if (!this.isSelected)
    {
      bool = true;
      this.isSelected = bool;
      if (!this.isSelected) {
        break label72;
      }
      this.qSI.setImageDrawable(am.k(this.qSI.getContext(), 2131690571, this.qSI.getResources().getColor(2131099777)));
    }
    for (;;)
    {
      dwg();
      AppMethodBeat.o(163443);
      return;
      bool = false;
      break;
      label72:
      d.b.a(this.rTT, d.c.wxh);
      this.qSI.setImageDrawable(am.k(this.qSI.getContext(), 2131690571, -1));
    }
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release()
  {
    AppMethodBeat.i(163447);
    com.tencent.mm.x.a locala = com.tencent.mm.x.a.fZG;
    com.tencent.mm.x.a.stop();
    AppMethodBeat.o(163447);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(163445);
    this.isSelected = false;
    dwg();
    d.b.a(this.rTT, d.c.wxh);
    this.qSI.setImageDrawable(am.k(this.qSI.getContext(), 2131690571, -1));
    AppMethodBeat.o(163445);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(163446);
    this.qSI.setVisibility(paramInt);
    AppMethodBeat.o(163446);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.filter.a
 * JD-Core Version:    0.7.0.1
 */