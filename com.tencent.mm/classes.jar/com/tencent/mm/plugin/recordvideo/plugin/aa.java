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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordSwitchCameraPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseIconPlugin;", "view", "Landroid/widget/ImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/ImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "enable", "", "lastRotation", "", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Landroid/widget/ImageView;", "setView", "(Landroid/widget/ImageView;)V", "onClick", "", "v", "Landroid/view/View;", "onPause", "onResume", "release", "resetIconColor", "iconColor", "", "updateCameraInfo", "front", "updateOrientation", "degree", "Companion", "plugin-recordvideo_release"})
public final class aa
  implements View.OnClickListener, t
{
  public static final aa.a BRO;
  private float BRN;
  private boolean enable;
  public ImageView tkI;
  private d wgr;
  
  static
  {
    AppMethodBeat.i(75646);
    BRO = new aa.a((byte)0);
    AppMethodBeat.o(75646);
  }
  
  public aa(ImageView paramImageView, d paramd)
  {
    AppMethodBeat.i(75645);
    this.tkI = paramImageView;
    this.wgr = paramd;
    this.enable = true;
    this.tkI.setOnClickListener((View.OnClickListener)this);
    this.tkI.setImageDrawable(ar.m(this.tkI.getContext(), 2131690502, -1));
    AppMethodBeat.o(75645);
  }
  
  public final void aSs() {}
  
  public final void bN(float paramFloat)
  {
    AppMethodBeat.i(237350);
    if ((!this.enable) || (this.BRN == paramFloat) || (!AppForegroundDelegate.djR.Wc()))
    {
      AppMethodBeat.o(237350);
      return;
    }
    Log.i("MicroMsg.RecordSwitchCameraPlugin", "updateOrientation " + paramFloat + "  " + this.tkI.getRotation());
    this.BRN = paramFloat;
    this.tkI.animate().cancel();
    this.tkI.animate().rotation(paramFloat).setDuration(100L).start();
    AppMethodBeat.o(237350);
  }
  
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
    AppMethodBeat.i(75641);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/recordvideo/plugin/RecordSwitchCameraPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i("MicroMsg.RecordSwitchCameraPlugin", "RecordSwitchCameraPlugin switch");
    d.b.a(this.wgr, d.c.BUt);
    paramView = c.BXI;
    c.VI(1);
    paramView = c.BXI;
    c.VH(1);
    a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/RecordSwitchCameraPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(75641);
  }
  
  public final void onDetach() {}
  
  public final void onPause()
  {
    AppMethodBeat.i(75643);
    Log.i("MicroMsg.RecordSwitchCameraPlugin", "onPause");
    this.enable = false;
    AppMethodBeat.o(75643);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(237351);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(237351);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(75642);
    Log.i("MicroMsg.RecordSwitchCameraPlugin", "onResume");
    this.enable = true;
    AppMethodBeat.o(75642);
  }
  
  public final void release()
  {
    AppMethodBeat.i(75644);
    Log.i("MicroMsg.RecordSwitchCameraPlugin", "release");
    this.enable = false;
    AppMethodBeat.o(75644);
  }
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
  
  public final void tf(boolean paramBoolean)
  {
    AppMethodBeat.i(237349);
    if (paramBoolean)
    {
      this.tkI.setContentDescription((CharSequence)this.tkI.getContext().getString(2131764311));
      AppMethodBeat.o(237349);
      return;
    }
    this.tkI.setContentDescription((CharSequence)this.tkI.getContext().getString(2131764312));
    AppMethodBeat.o(237349);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.aa
 * JD-Core Version:    0.7.0.1
 */