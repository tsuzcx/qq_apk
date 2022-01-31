package com.tencent.mm.plugin.recordvideo.plugin;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoEditPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Landroid/view/View;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/View;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "onBackPress", "", "onClick", "", "v", "onPause", "onResume", "release", "Companion", "plugin-recordvideo_release"})
public final class o
  implements View.OnClickListener, q
{
  public static final o.a qcz;
  private d qbI;
  private View view;
  
  static
  {
    AppMethodBeat.i(150674);
    qcz = new o.a((byte)0);
    AppMethodBeat.o(150674);
  }
  
  public o(View paramView, d paramd)
  {
    AppMethodBeat.i(150673);
    this.view = paramView;
    this.qbI = paramd;
    this.view.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(150673);
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
    AppMethodBeat.i(150672);
    ab.i("MicroMsg.EditRevertPlugin", "EditRevertPlugin click");
    d.b.a(this.qbI, d.c.qeu);
    AppMethodBeat.o(150672);
  }
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.o
 * JD-Core Version:    0.7.0.1
 */