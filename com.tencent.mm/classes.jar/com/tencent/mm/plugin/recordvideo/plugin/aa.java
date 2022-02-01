package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.ao;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordSwitchCameraPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Landroid/widget/ImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/ImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "enable", "", "lastRotation", "", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Landroid/widget/ImageView;", "setView", "(Landroid/widget/ImageView;)V", "onClick", "", "v", "Landroid/view/View;", "onPause", "onResume", "release", "updateCameraInfo", "front", "updateOrientation", "degree", "Companion", "plugin-recordvideo_release"})
public final class aa
  implements View.OnClickListener, t
{
  public static final aa.a xRK;
  private boolean enable;
  private ImageView rKW;
  private d tbP;
  private float xRJ;
  
  static
  {
    AppMethodBeat.i(75646);
    xRK = new aa.a((byte)0);
    AppMethodBeat.o(75646);
  }
  
  public aa(ImageView paramImageView, d paramd)
  {
    AppMethodBeat.i(75645);
    this.rKW = paramImageView;
    this.tbP = paramd;
    this.enable = true;
    this.rKW.setOnClickListener((View.OnClickListener)this);
    this.rKW.setImageDrawable(ao.k(this.rKW.getContext(), 2131690362, -1));
    AppMethodBeat.o(75645);
  }
  
  public final boolean aoQ()
  {
    return false;
  }
  
  public final void azm() {}
  
  public final void bu(float paramFloat)
  {
    AppMethodBeat.i(206621);
    if ((!this.enable) || (this.xRJ == paramFloat) || (!AppForegroundDelegate.cTA.LP()))
    {
      AppMethodBeat.o(206621);
      return;
    }
    ae.i("MicroMsg.RecordSwitchCameraPlugin", "updateOrientation " + paramFloat + "  " + this.rKW.getRotation());
    this.xRJ = paramFloat;
    this.rKW.animate().cancel();
    this.rKW.animate().rotation(paramFloat).setDuration(100L).start();
    AppMethodBeat.o(206621);
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(75641);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/recordvideo/plugin/RecordSwitchCameraPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    ae.i("MicroMsg.RecordSwitchCameraPlugin", "RecordSwitchCameraPlugin switch");
    d.b.a(this.tbP, d.c.xTU);
    paramView = c.xWV;
    c.Ot(1);
    paramView = c.xWV;
    c.Os(1);
    a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/RecordSwitchCameraPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(75641);
  }
  
  public final void onDetach() {}
  
  public final void onPause()
  {
    AppMethodBeat.i(75643);
    ae.i("MicroMsg.RecordSwitchCameraPlugin", "onPause");
    this.enable = false;
    AppMethodBeat.o(75643);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(206622);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(206622);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(75642);
    ae.i("MicroMsg.RecordSwitchCameraPlugin", "onResume");
    this.enable = true;
    AppMethodBeat.o(75642);
  }
  
  public final void pU(boolean paramBoolean)
  {
    AppMethodBeat.i(206620);
    if (paramBoolean)
    {
      this.rKW.setContentDescription((CharSequence)this.rKW.getContext().getString(2131762251));
      AppMethodBeat.o(206620);
      return;
    }
    this.rKW.setContentDescription((CharSequence)this.rKW.getContext().getString(2131762252));
    AppMethodBeat.o(206620);
  }
  
  public final void release()
  {
    AppMethodBeat.i(75644);
    ae.i("MicroMsg.RecordSwitchCameraPlugin", "release");
    this.enable = false;
    AppMethodBeat.o(75644);
  }
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.aa
 * JD-Core Version:    0.7.0.1
 */