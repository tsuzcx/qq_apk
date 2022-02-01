package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.plugin.recordvideo.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.am;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordSwitchCameraPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Landroid/widget/ImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/ImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "enable", "", "lastRotation", "", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Landroid/widget/ImageView;", "setView", "(Landroid/widget/ImageView;)V", "onClick", "", "v", "Landroid/view/View;", "onPause", "onResume", "release", "updateCameraInfo", "front", "updateOrientation", "degree", "Companion", "plugin-recordvideo_release"})
public final class aa
  implements View.OnClickListener, t
{
  public static final a vln;
  private boolean enable;
  private ImageView qkg;
  private d vjo;
  private float vlm;
  
  static
  {
    AppMethodBeat.i(75646);
    vln = new a((byte)0);
    AppMethodBeat.o(75646);
  }
  
  public aa(ImageView paramImageView, d paramd)
  {
    AppMethodBeat.i(75645);
    this.qkg = paramImageView;
    this.vjo = paramd;
    this.enable = true;
    this.qkg.setOnClickListener((View.OnClickListener)this);
    this.qkg.setImageDrawable(am.i(this.qkg.getContext(), 2131690362, -1));
    AppMethodBeat.o(75645);
  }
  
  public final void apt() {}
  
  public final void cb(float paramFloat)
  {
    AppMethodBeat.i(204137);
    if ((!this.enable) || (this.vlm == paramFloat) || (!AppForegroundDelegate.cKE.Kx()))
    {
      AppMethodBeat.o(204137);
      return;
    }
    ad.i("MicroMsg.RecordSwitchCameraPlugin", "updateOrientation " + paramFloat + "  " + this.qkg.getRotation());
    this.vlm = paramFloat;
    this.qkg.animate().cancel();
    this.qkg.animate().rotation(paramFloat).setDuration(100L).start();
    AppMethodBeat.o(204137);
  }
  
  public final boolean dia()
  {
    return false;
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(75641);
    ad.i("MicroMsg.RecordSwitchCameraPlugin", "RecordSwitchCameraPlugin switch");
    d.b.a(this.vjo, d.c.vnw);
    paramView = b.vpp;
    b.Kp(1);
    paramView = b.vpp;
    b.Ko(1);
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
  
  public final void onResume()
  {
    AppMethodBeat.i(75642);
    ad.i("MicroMsg.RecordSwitchCameraPlugin", "onResume");
    this.enable = true;
    AppMethodBeat.o(75642);
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
  
  public final void zc(boolean paramBoolean)
  {
    AppMethodBeat.i(204136);
    if (paramBoolean)
    {
      this.qkg.setContentDescription((CharSequence)this.qkg.getContext().getString(2131762251));
      AppMethodBeat.o(204136);
      return;
    }
    this.qkg.setContentDescription((CharSequence)this.qkg.getContext().getString(2131762252));
    AppMethodBeat.o(204136);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordSwitchCameraPlugin$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.aa
 * JD-Core Version:    0.7.0.1
 */