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
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.plugin.recordvideo.b.h;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordSwitchCameraPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseIconPlugin;", "view", "Landroid/widget/ImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/ImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "enable", "", "lastRotation", "", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Landroid/widget/ImageView;", "setView", "(Landroid/widget/ImageView;)V", "onClick", "", "v", "Landroid/view/View;", "onPause", "onResume", "release", "resetIconColor", "iconColor", "", "updateCameraInfo", "front", "updateOrientation", "degree", "Companion", "plugin-recordvideo_release"})
public final class ab
  implements View.OnClickListener, u
{
  public static final a HOD;
  private d APl;
  private float HOC;
  private boolean enable;
  public ImageView wRg;
  
  static
  {
    AppMethodBeat.i(75646);
    HOD = new a((byte)0);
    AppMethodBeat.o(75646);
  }
  
  public ab(ImageView paramImageView, d paramd)
  {
    AppMethodBeat.i(75645);
    this.wRg = paramImageView;
    this.APl = paramd;
    this.enable = true;
    this.wRg.setOnClickListener((View.OnClickListener)this);
    this.wRg.setImageDrawable(au.o(this.wRg.getContext(), b.g.icons_filled_camera_switch, -1));
    AppMethodBeat.o(75645);
  }
  
  public final void bT(float paramFloat)
  {
    AppMethodBeat.i(216513);
    if ((!this.enable) || (this.HOC == paramFloat) || (!AppForegroundDelegate.fby.aax()))
    {
      AppMethodBeat.o(216513);
      return;
    }
    Log.i("MicroMsg.RecordSwitchCameraPlugin", "updateOrientation " + paramFloat + "  " + this.wRg.getRotation());
    this.HOC = paramFloat;
    this.wRg.animate().cancel();
    this.wRg.animate().rotation(paramFloat).setDuration(100L).start();
    AppMethodBeat.o(216513);
  }
  
  public final void bbp() {}
  
  public final String name()
  {
    AppMethodBeat.i(216514);
    String str = getClass().getName();
    AppMethodBeat.o(216514);
    return str;
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
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/recordvideo/plugin/RecordSwitchCameraPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    Log.i("MicroMsg.RecordSwitchCameraPlugin", "RecordSwitchCameraPlugin switch");
    d.b.a(this.APl, d.c.HRe);
    paramView = c.HUw;
    c.acr(1);
    paramView = c.HUw;
    c.acq(1);
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
    AppMethodBeat.i(216515);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    u.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(216515);
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
  
  public final void wB(boolean paramBoolean)
  {
    AppMethodBeat.i(216512);
    if (paramBoolean)
    {
      this.wRg.setContentDescription((CharSequence)this.wRg.getContext().getString(b.h.record_tap_switch_camera_back));
      AppMethodBeat.o(216512);
      return;
    }
    this.wRg.setContentDescription((CharSequence)this.wRg.getContext().getString(b.h.record_tap_switch_camera_front));
    AppMethodBeat.o(216512);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordSwitchCameraPlugin$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.ab
 * JD-Core Version:    0.7.0.1
 */