package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.ui.ao;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiEditCropPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Landroid/view/View$OnClickListener;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "iconView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "onClick", "", "v", "Landroid/view/View;", "setVisibility", "visibility", "", "plugin-vlog_release"})
public final class k
  implements View.OnClickListener, t
{
  private ViewGroup gsV;
  private d tbP;
  private final ImageView vl;
  
  public k(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(191696);
    this.gsV = paramViewGroup;
    this.tbP = paramd;
    this.vl = ((ImageView)this.gsV.findViewById(2131299289));
    this.vl.setImageDrawable(ao.k(this.gsV.getContext(), 2131691603, -1));
    this.vl.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(191696);
  }
  
  public final boolean aoQ()
  {
    return false;
  }
  
  public final void azm() {}
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(191694);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/vlog/ui/plugin/MultiEditCropPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    paramView = new Bundle();
    this.tbP.a(d.c.xUJ, paramView);
    a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MultiEditCropPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(191694);
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(191697);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(191697);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(191695);
    ImageView localImageView = this.vl;
    p.g(localImageView, "iconView");
    localImageView.setVisibility(paramInt);
    AppMethodBeat.o(191695);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.k
 * JD-Core Version:    0.7.0.1
 */