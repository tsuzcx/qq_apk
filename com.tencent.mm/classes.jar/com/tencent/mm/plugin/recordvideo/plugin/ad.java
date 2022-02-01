package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.plugin.recordvideo.b.h;
import com.tencent.mm.plugin.recordvideo.f.c;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bb;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordSwitchCameraPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseIconPlugin;", "view", "Landroid/widget/ImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/ImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "enable", "", "lastRotation", "", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Landroid/widget/ImageView;", "setView", "(Landroid/widget/ImageView;)V", "onClick", "", "v", "Landroid/view/View;", "onPause", "onResume", "release", "resetIconColor", "iconColor", "", "setVisibility", "visibility", "updateCameraInfo", "front", "updateOrientation", "degree", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ad
  implements View.OnClickListener, v
{
  public static final ad.a NLo;
  private com.tencent.mm.plugin.recordvideo.plugin.parent.a GrC;
  private float NLp;
  public ImageView cqj;
  private boolean enable;
  
  static
  {
    AppMethodBeat.i(75646);
    NLo = new ad.a((byte)0);
    AppMethodBeat.o(75646);
  }
  
  public ad(ImageView paramImageView, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    AppMethodBeat.i(75645);
    this.cqj = paramImageView;
    this.GrC = parama;
    this.enable = true;
    this.cqj.setOnClickListener((View.OnClickListener)this);
    this.cqj.setImageDrawable(bb.m(this.cqj.getContext(), b.g.icons_filled_camera_switch, -1));
    AppMethodBeat.o(75645);
  }
  
  public final void Ba(boolean paramBoolean)
  {
    AppMethodBeat.i(280756);
    if (paramBoolean)
    {
      this.cqj.setContentDescription((CharSequence)this.cqj.getContext().getString(b.h.record_tap_switch_camera_back));
      AppMethodBeat.o(280756);
      return;
    }
    this.cqj.setContentDescription((CharSequence)this.cqj.getContext().getString(b.h.record_tap_switch_camera_front));
    AppMethodBeat.o(280756);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(280792);
    v.a.a(this, paramRecordConfigProvider);
    AppMethodBeat.o(280792);
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(280823);
    s.u(this, "this");
    AppMethodBeat.o(280823);
  }
  
  public final void cX(float paramFloat)
  {
    AppMethodBeat.i(280768);
    if (this.enable) {
      if (this.NLp != paramFloat) {
        break label42;
      }
    }
    label42:
    for (int i = 1; (i != 0) || (!AppForegroundDelegate.heY.eLx); i = 0)
    {
      AppMethodBeat.o(280768);
      return;
    }
    Log.i("MicroMsg.RecordSwitchCameraPlugin", "updateOrientation " + paramFloat + "  " + this.cqj.getRotation());
    this.NLp = paramFloat;
    this.cqj.animate().cancel();
    this.cqj.animate().rotation(paramFloat).setDuration(100L).start();
    AppMethodBeat.o(280768);
  }
  
  public final String name()
  {
    AppMethodBeat.i(280803);
    String str = v.a.b(this);
    AppMethodBeat.o(280803);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(280815);
    s.u(this, "this");
    AppMethodBeat.o(280815);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(280830);
    s.u(this, "this");
    AppMethodBeat.o(280830);
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(75641);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/plugin/RecordSwitchCameraPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.i("MicroMsg.RecordSwitchCameraPlugin", "RecordSwitchCameraPlugin switch");
    a.b.a(this.GrC, a.c.NNK);
    paramView = c.NRf;
    c.agH(1);
    paramView = c.NRf;
    c.agG(1);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/RecordSwitchCameraPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(75641);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(280836);
    s.u(this, "this");
    AppMethodBeat.o(280836);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(75643);
    Log.i("MicroMsg.RecordSwitchCameraPlugin", "onPause");
    s.u((v)this, "this");
    this.enable = false;
    AppMethodBeat.o(75643);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(280843);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(280843);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(75642);
    Log.i("MicroMsg.RecordSwitchCameraPlugin", "onResume");
    s.u((v)this, "this");
    this.enable = true;
    AppMethodBeat.o(75642);
  }
  
  public final void release()
  {
    AppMethodBeat.i(75644);
    Log.i("MicroMsg.RecordSwitchCameraPlugin", "release");
    s.u((v)this, "this");
    this.enable = false;
    AppMethodBeat.o(75644);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(280850);
    s.u(this, "this");
    AppMethodBeat.o(280850);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(280779);
    s.u((v)this, "this");
    this.cqj.setVisibility(paramInt);
    AppMethodBeat.o(280779);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.ad
 * JD-Core Version:    0.7.0.1
 */