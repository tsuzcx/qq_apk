package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.ui.ao;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditBackToRecordPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Landroid/widget/ImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/ImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Landroid/widget/ImageView;", "setView", "(Landroid/widget/ImageView;)V", "name", "", "onClick", "", "v", "Landroid/view/View;", "setVisibility", "visibility", "", "plugin-recordvideo_release"})
public final class e
  implements View.OnClickListener, t
{
  private ImageView rKW;
  private d tbP;
  
  public e(ImageView paramImageView, d paramd)
  {
    AppMethodBeat.i(75485);
    this.rKW = paramImageView;
    this.tbP = paramd;
    this.rKW.setImageDrawable(ao.k(this.rKW.getContext(), 2131690463, -1));
    this.rKW.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(75485);
  }
  
  public final boolean aoQ()
  {
    return false;
  }
  
  public final void azm() {}
  
  public final String name()
  {
    return "plugin_back";
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(75483);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/recordvideo/plugin/EditBackToRecordPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    d.b.a(this.tbP, d.c.xUo);
    paramView = c.xWV;
    c.Os(11);
    paramView = c.xWV;
    c.Ot(12);
    a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/EditBackToRecordPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(75483);
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(206566);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(206566);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75484);
    this.rKW.setVisibility(paramInt);
    AppMethodBeat.o(75484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.e
 * JD-Core Version:    0.7.0.1
 */