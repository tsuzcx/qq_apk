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
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/plugin/filter/EditPhotoFilterPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "viewGroup", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "filterPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/filter/PhotoFilterPlugin;", "isSelected", "", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "view", "Landroid/widget/ImageView;", "getViewGroup", "()Landroid/view/ViewGroup;", "setViewGroup", "(Landroid/view/ViewGroup;)V", "checkFilterStatus", "", "name", "", "onClick", "v", "Landroid/view/View;", "release", "reset", "setPreImage", "bitmap", "Landroid/graphics/Bitmap;", "setVisibility", "visibility", "", "plugin-recordvideo_release"})
public final class a
  implements View.OnClickListener, t
{
  public final PhotoFilterPlugin BTj;
  private boolean isSelected;
  private final ImageView tkI;
  private d wgr;
  private ViewGroup zQH;
  
  public a(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(163448);
    this.zQH = paramViewGroup;
    this.wgr = paramd;
    paramViewGroup = this.zQH.findViewById(2131300708);
    p.g(paramViewGroup, "viewGroup.findViewById(R.id.filter_layout)");
    this.BTj = ((PhotoFilterPlugin)paramViewGroup);
    this.BTj.setStatus(this.wgr);
    paramViewGroup = this.zQH.findViewById(2131299862);
    p.g(paramViewGroup, "viewGroup.findViewById(R.id.editor_add_filter)");
    this.tkI = ((ImageView)paramViewGroup);
    this.tkI.setVisibility(0);
    this.tkI.setImageDrawable(ar.m(this.tkI.getContext(), 2131690800, -1));
    this.tkI.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(163448);
  }
  
  private void eKN()
  {
    AppMethodBeat.i(163444);
    if (this.isSelected)
    {
      this.BTj.setVisibility(0);
      AppMethodBeat.o(163444);
      return;
    }
    this.BTj.setVisibility(4);
    AppMethodBeat.o(163444);
  }
  
  public final void aSs() {}
  
  public final String name()
  {
    return "plugin_filter";
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(163443);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/plugin/filter/EditPhotoFilterPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    boolean bool;
    if (!this.isSelected)
    {
      bool = true;
      this.isSelected = bool;
      if (!this.isSelected) {
        break label113;
      }
      this.tkI.setImageDrawable(ar.m(this.tkI.getContext(), 2131690800, this.tkI.getResources().getColor(2131099792)));
    }
    for (;;)
    {
      eKN();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/filter/EditPhotoFilterPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(163443);
      return;
      bool = false;
      break;
      label113:
      d.b.a(this.wgr, d.c.BVT);
      this.tkI.setImageDrawable(ar.m(this.tkI.getContext(), 2131690800, -1));
    }
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(237396);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(237396);
  }
  
  public final void onResume() {}
  
  public final void release()
  {
    AppMethodBeat.i(163447);
    com.tencent.mm.x.a locala = com.tencent.mm.x.a.hiy;
    com.tencent.mm.x.a.stop();
    AppMethodBeat.o(163447);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(163445);
    this.isSelected = false;
    eKN();
    d.b.a(this.wgr, d.c.BVT);
    this.tkI.setImageDrawable(ar.m(this.tkI.getContext(), 2131690800, -1));
    AppMethodBeat.o(163445);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(163446);
    this.tkI.setVisibility(paramInt);
    AppMethodBeat.o(163446);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.filter.a
 * JD-Core Version:    0.7.0.1
 */