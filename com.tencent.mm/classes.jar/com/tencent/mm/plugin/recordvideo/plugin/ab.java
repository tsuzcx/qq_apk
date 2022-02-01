package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.am;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordSwitchCameraPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Landroid/widget/ImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/ImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "enable", "", "lastRotation", "", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Landroid/widget/ImageView;", "setView", "(Landroid/widget/ImageView;)V", "onClick", "", "v", "Landroid/view/View;", "onPause", "onResume", "release", "updateCameraInfo", "front", "updateOrientation", "degree", "Companion", "plugin-recordvideo_release"})
public final class ab
  implements View.OnClickListener, t
{
  public static final ab.a wtT;
  private boolean enable;
  private ImageView qSI;
  private d rTT;
  private float wtS;
  
  static
  {
    AppMethodBeat.i(75646);
    wtT = new ab.a((byte)0);
    AppMethodBeat.o(75646);
  }
  
  public ab(ImageView paramImageView, d paramd)
  {
    AppMethodBeat.i(75645);
    this.qSI = paramImageView;
    this.rTT = paramd;
    this.enable = true;
    this.qSI.setOnClickListener((View.OnClickListener)this);
    this.qSI.setImageDrawable(am.k(this.qSI.getContext(), 2131690362, -1));
    AppMethodBeat.o(75645);
  }
  
  public final boolean alO()
  {
    return false;
  }
  
  public final void awk() {}
  
  public final void br(float paramFloat)
  {
    AppMethodBeat.i(199323);
    if ((!this.enable) || (this.wtS == paramFloat) || (!AppForegroundDelegate.cHM.Ki()))
    {
      AppMethodBeat.o(199323);
      return;
    }
    ac.i("MicroMsg.RecordSwitchCameraPlugin", "updateOrientation " + paramFloat + "  " + this.qSI.getRotation());
    this.wtS = paramFloat;
    this.qSI.animate().cancel();
    this.qSI.animate().rotation(paramFloat).setDuration(100L).start();
    AppMethodBeat.o(199323);
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(75641);
    ac.i("MicroMsg.RecordSwitchCameraPlugin", "RecordSwitchCameraPlugin switch");
    d.b.a(this.rTT, d.c.wvR);
    paramView = c.wyg;
    c.Mo(1);
    paramView = c.wyg;
    c.Mn(1);
    AppMethodBeat.o(75641);
  }
  
  public final void onDetach() {}
  
  public final void onPause()
  {
    AppMethodBeat.i(75643);
    ac.i("MicroMsg.RecordSwitchCameraPlugin", "onPause");
    this.enable = false;
    AppMethodBeat.o(75643);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(75642);
    ac.i("MicroMsg.RecordSwitchCameraPlugin", "onResume");
    this.enable = true;
    AppMethodBeat.o(75642);
  }
  
  public final void pq(boolean paramBoolean)
  {
    AppMethodBeat.i(199322);
    if (paramBoolean)
    {
      this.qSI.setContentDescription((CharSequence)this.qSI.getContext().getString(2131762251));
      AppMethodBeat.o(199322);
      return;
    }
    this.qSI.setContentDescription((CharSequence)this.qSI.getContext().getString(2131762252));
    AppMethodBeat.o(199322);
  }
  
  public final void release()
  {
    AppMethodBeat.i(75644);
    ac.i("MicroMsg.RecordSwitchCameraPlugin", "release");
    this.enable = false;
    AppMethodBeat.o(75644);
  }
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.ab
 * JD-Core Version:    0.7.0.1
 */