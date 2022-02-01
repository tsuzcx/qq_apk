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
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiEditCropPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseIconPlugin;", "Landroid/view/View$OnClickListener;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "iconView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "onClick", "", "v", "Landroid/view/View;", "resetIconColor", "iconColor", "", "setVisibility", "visibility", "plugin-vlog_release"})
public final class m
  implements View.OnClickListener, t
{
  private ViewGroup parent;
  private final ImageView vs;
  private d wgr;
  
  public m(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(191314);
    this.parent = paramViewGroup;
    this.wgr = paramd;
    this.vs = ((ImageView)this.parent.findViewById(2131299879));
    this.vs.setImageDrawable(ar.m(this.parent.getContext(), 2131690668, -1));
    this.vs.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(191314);
  }
  
  public final void VC(int paramInt)
  {
    AppMethodBeat.i(191313);
    this.vs.setImageDrawable(ar.m(this.parent.getContext(), 2131690668, paramInt));
    AppMethodBeat.o(191313);
  }
  
  public final void aSs() {}
  
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
    AppMethodBeat.i(191311);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/vlog/ui/plugin/MultiEditCropPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    paramView = new Bundle();
    this.wgr.a(d.c.BVn, paramView);
    a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MultiEditCropPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(191311);
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(191315);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(191315);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(191312);
    ImageView localImageView = this.vs;
    p.g(localImageView, "iconView");
    localImageView.setVisibility(paramInt);
    AppMethodBeat.o(191312);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.m
 * JD-Core Version:    0.7.0.1
 */