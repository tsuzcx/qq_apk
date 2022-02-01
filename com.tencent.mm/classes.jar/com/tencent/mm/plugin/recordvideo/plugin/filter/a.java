package com.tencent.mm.plugin.recordvideo.plugin.filter;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.ui.ao;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/plugin/filter/EditPhotoFilterPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "viewGroup", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "filterPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/filter/PhotoFilterPlugin;", "isSelected", "", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "view", "Landroid/widget/ImageView;", "getViewGroup", "()Landroid/view/ViewGroup;", "setViewGroup", "(Landroid/view/ViewGroup;)V", "checkFilterStatus", "", "name", "", "onClick", "v", "Landroid/view/View;", "release", "reset", "setPreImage", "bitmap", "Landroid/graphics/Bitmap;", "setVisibility", "visibility", "", "plugin-recordvideo_release"})
public final class a
  implements View.OnClickListener, t
{
  private boolean isSelected;
  private final ImageView rCL;
  private d sQE;
  private ViewGroup xAT;
  public final PhotoFilterPlugin xCO;
  
  public a(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(163448);
    this.xAT = paramViewGroup;
    this.sQE = paramd;
    paramViewGroup = this.xAT.findViewById(2131299960);
    p.g(paramViewGroup, "viewGroup.findViewById(R.id.filter_layout)");
    this.xCO = ((PhotoFilterPlugin)paramViewGroup);
    this.xCO.setStatus(this.sQE);
    paramViewGroup = this.xAT.findViewById(2131299276);
    p.g(paramViewGroup, "viewGroup.findViewById(R.id.editor_add_filter)");
    this.rCL = ((ImageView)paramViewGroup);
    this.rCL.setVisibility(0);
    this.rCL.setImageDrawable(ao.k(this.rCL.getContext(), 2131690571, -1));
    this.rCL.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(163448);
  }
  
  private void dGC()
  {
    AppMethodBeat.i(163444);
    if (this.isSelected)
    {
      this.xCO.setVisibility(0);
      AppMethodBeat.o(163444);
      return;
    }
    this.xCO.setVisibility(4);
    AppMethodBeat.o(163444);
  }
  
  public final boolean aoB()
  {
    return false;
  }
  
  public final void ayX() {}
  
  public final String name()
  {
    return "plugin_filter";
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(163443);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/plugin/filter/EditPhotoFilterPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    boolean bool;
    if (!this.isSelected)
    {
      bool = true;
      this.isSelected = bool;
      if (!this.isSelected) {
        break label113;
      }
      this.rCL.setImageDrawable(ao.k(this.rCL.getContext(), 2131690571, this.rCL.getResources().getColor(2131099777)));
    }
    for (;;)
    {
      dGC();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/filter/EditPhotoFilterPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(163443);
      return;
      bool = false;
      break;
      label113:
      d.b.a(this.sQE, d.c.xFq);
      this.rCL.setImageDrawable(ao.k(this.rCL.getContext(), 2131690571, -1));
    }
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(200370);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(200370);
  }
  
  public final void onResume() {}
  
  public final void release()
  {
    AppMethodBeat.i(163447);
    com.tencent.mm.y.a locala = com.tencent.mm.y.a.gtc;
    com.tencent.mm.y.a.stop();
    AppMethodBeat.o(163447);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(163445);
    this.isSelected = false;
    dGC();
    d.b.a(this.sQE, d.c.xFq);
    this.rCL.setImageDrawable(ao.k(this.rCL.getContext(), 2131690571, -1));
    AppMethodBeat.o(163445);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(163446);
    this.rCL.setVisibility(paramInt);
    AppMethodBeat.o(163446);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.filter.a
 * JD-Core Version:    0.7.0.1
 */