package com.tencent.mm.plugin.recordvideo.plugin;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.c.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.aj;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordSwitchCameraPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Landroid/widget/ImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/ImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "enable", "", "lastRotation", "", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Landroid/widget/ImageView;", "setView", "(Landroid/widget/ImageView;)V", "onClick", "", "v", "Landroid/view/View;", "onPause", "onResume", "release", "updateOrientation", "degree", "Companion", "plugin-recordvideo_release"})
public final class v
  implements View.OnClickListener, q
{
  public static final v.a qda;
  public boolean enable;
  public ImageView mCy;
  private d qbI;
  public float qcZ;
  
  static
  {
    AppMethodBeat.i(150724);
    qda = new v.a((byte)0);
    AppMethodBeat.o(150724);
  }
  
  public v(ImageView paramImageView, d paramd)
  {
    AppMethodBeat.i(150723);
    this.mCy = paramImageView;
    this.qbI = paramd;
    this.enable = true;
    this.mCy.setOnClickListener((View.OnClickListener)this);
    this.mCy.setImageDrawable(aj.g(this.mCy.getContext(), 2131231443, -1));
    AppMethodBeat.o(150723);
  }
  
  public final boolean cgq()
  {
    return false;
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(150722);
    ab.i("MicroMsg.RecordSwitchCameraPlugin", "RecordSwitchCameraPlugin switch");
    d.b.a(this.qbI, d.c.qen);
    paramView = b.qfu;
    b.Cs(1);
    AppMethodBeat.o(150722);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(156355);
    ab.i("MicroMsg.RecordSwitchCameraPlugin", "onPause");
    this.enable = false;
    AppMethodBeat.o(156355);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(156354);
    ab.i("MicroMsg.RecordSwitchCameraPlugin", "onResume");
    this.enable = true;
    AppMethodBeat.o(156354);
  }
  
  public final void release()
  {
    AppMethodBeat.i(156356);
    ab.i("MicroMsg.RecordSwitchCameraPlugin", "release");
    this.enable = false;
    AppMethodBeat.o(156356);
  }
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.v
 * JD-Core Version:    0.7.0.1
 */