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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.ao;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordSwitchCameraPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Landroid/widget/ImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/ImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "enable", "", "lastRotation", "", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Landroid/widget/ImageView;", "setView", "(Landroid/widget/ImageView;)V", "onClick", "", "v", "Landroid/view/View;", "onPause", "onResume", "release", "updateCameraInfo", "front", "updateOrientation", "degree", "Companion", "plugin-recordvideo_release"})
public final class aa
  implements View.OnClickListener, t
{
  public static final aa.a xBP;
  private boolean enable;
  private ImageView rCL;
  private d sQE;
  private float xBO;
  
  static
  {
    AppMethodBeat.i(75646);
    xBP = new aa.a((byte)0);
    AppMethodBeat.o(75646);
  }
  
  public aa(ImageView paramImageView, d paramd)
  {
    AppMethodBeat.i(75645);
    this.rCL = paramImageView;
    this.sQE = paramd;
    this.enable = true;
    this.rCL.setOnClickListener((View.OnClickListener)this);
    this.rCL.setImageDrawable(ao.k(this.rCL.getContext(), 2131690362, -1));
    AppMethodBeat.o(75645);
  }
  
  public final boolean aoB()
  {
    return false;
  }
  
  public final void ayX() {}
  
  public final void bu(float paramFloat)
  {
    AppMethodBeat.i(200360);
    if ((!this.enable) || (this.xBO == paramFloat) || (!AppForegroundDelegate.cSQ.LH()))
    {
      AppMethodBeat.o(200360);
      return;
    }
    ad.i("MicroMsg.RecordSwitchCameraPlugin", "updateOrientation " + paramFloat + "  " + this.rCL.getRotation());
    this.xBO = paramFloat;
    this.rCL.animate().cancel();
    this.rCL.animate().rotation(paramFloat).setDuration(100L).start();
    AppMethodBeat.o(200360);
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
    a.b("com/tencent/mm/plugin/recordvideo/plugin/RecordSwitchCameraPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    ad.i("MicroMsg.RecordSwitchCameraPlugin", "RecordSwitchCameraPlugin switch");
    d.b.a(this.sQE, d.c.xDZ);
    paramView = c.xHa;
    c.NN(1);
    paramView = c.xHa;
    c.NM(1);
    a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/RecordSwitchCameraPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(75641);
  }
  
  public final void onDetach() {}
  
  public final void onPause()
  {
    AppMethodBeat.i(75643);
    ad.i("MicroMsg.RecordSwitchCameraPlugin", "onPause");
    this.enable = false;
    AppMethodBeat.o(75643);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(200361);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(200361);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(75642);
    ad.i("MicroMsg.RecordSwitchCameraPlugin", "onResume");
    this.enable = true;
    AppMethodBeat.o(75642);
  }
  
  public final void pM(boolean paramBoolean)
  {
    AppMethodBeat.i(200359);
    if (paramBoolean)
    {
      this.rCL.setContentDescription((CharSequence)this.rCL.getContext().getString(2131762251));
      AppMethodBeat.o(200359);
      return;
    }
    this.rCL.setContentDescription((CharSequence)this.rCL.getContext().getString(2131762252));
    AppMethodBeat.o(200359);
  }
  
  public final void release()
  {
    AppMethodBeat.i(75644);
    ad.i("MicroMsg.RecordSwitchCameraPlugin", "release");
    this.enable = false;
    AppMethodBeat.o(75644);
  }
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.aa
 * JD-Core Version:    0.7.0.1
 */