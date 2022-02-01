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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/plugin/filter/EditPhotoFilterPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "viewGroup", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "filterPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/filter/PhotoFilterPlugin;", "isSelected", "", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "view", "Landroid/widget/ImageView;", "getViewGroup", "()Landroid/view/ViewGroup;", "setViewGroup", "(Landroid/view/ViewGroup;)V", "checkFilterStatus", "", "name", "", "onClick", "v", "Landroid/view/View;", "release", "reset", "setPreImage", "bitmap", "Landroid/graphics/Bitmap;", "setVisibility", "visibility", "", "plugin-recordvideo_release"})
public final class a
  implements View.OnClickListener, t
{
  private boolean isSelected;
  private final ImageView rKW;
  private d tbP;
  private ViewGroup xQO;
  public final PhotoFilterPlugin xSJ;
  
  public a(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(163448);
    this.xQO = paramViewGroup;
    this.tbP = paramd;
    paramViewGroup = this.xQO.findViewById(2131299960);
    p.g(paramViewGroup, "viewGroup.findViewById(R.id.filter_layout)");
    this.xSJ = ((PhotoFilterPlugin)paramViewGroup);
    this.xSJ.setStatus(this.tbP);
    paramViewGroup = this.xQO.findViewById(2131299276);
    p.g(paramViewGroup, "viewGroup.findViewById(R.id.editor_add_filter)");
    this.rKW = ((ImageView)paramViewGroup);
    this.rKW.setVisibility(0);
    this.rKW.setImageDrawable(ao.k(this.rKW.getContext(), 2131690571, -1));
    this.rKW.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(163448);
  }
  
  private void dJT()
  {
    AppMethodBeat.i(163444);
    if (this.isSelected)
    {
      this.xSJ.setVisibility(0);
      AppMethodBeat.o(163444);
      return;
    }
    this.xSJ.setVisibility(4);
    AppMethodBeat.o(163444);
  }
  
  public final boolean aoQ()
  {
    return false;
  }
  
  public final void azm() {}
  
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
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/plugin/filter/EditPhotoFilterPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    boolean bool;
    if (!this.isSelected)
    {
      bool = true;
      this.isSelected = bool;
      if (!this.isSelected) {
        break label113;
      }
      this.rKW.setImageDrawable(ao.k(this.rKW.getContext(), 2131690571, this.rKW.getResources().getColor(2131099777)));
    }
    for (;;)
    {
      dJT();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/filter/EditPhotoFilterPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(163443);
      return;
      bool = false;
      break;
      label113:
      d.b.a(this.tbP, d.c.xVl);
      this.rKW.setImageDrawable(ao.k(this.rKW.getContext(), 2131690571, -1));
    }
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(206631);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(206631);
  }
  
  public final void onResume() {}
  
  public final void release()
  {
    AppMethodBeat.i(163447);
    com.tencent.mm.x.a locala = com.tencent.mm.x.a.gvJ;
    com.tencent.mm.x.a.stop();
    AppMethodBeat.o(163447);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(163445);
    this.isSelected = false;
    dJT();
    d.b.a(this.tbP, d.c.xVl);
    this.rKW.setImageDrawable(ao.k(this.rKW.getContext(), 2131690571, -1));
    AppMethodBeat.o(163445);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(163446);
    this.rKW.setVisibility(paramInt);
    AppMethodBeat.o(163446);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.filter.a
 * JD-Core Version:    0.7.0.1
 */