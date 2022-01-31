package com.tencent.mm.plugin.recordvideo.plugin;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditRevertPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Landroid/view/View;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/View;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "onBackPress", "", "onClick", "", "v", "onPause", "onResume", "release", "showAppearAnimation", "Companion", "plugin-recordvideo_release"})
public final class j
  implements View.OnClickListener, q
{
  public static final j.a qcp;
  private d qbI;
  public View view;
  
  static
  {
    AppMethodBeat.i(150656);
    qcp = new j.a((byte)0);
    AppMethodBeat.o(150656);
  }
  
  public j(View paramView, d paramd)
  {
    AppMethodBeat.i(150655);
    this.view = paramView;
    this.qbI = paramd;
    this.view.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(150655);
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
    AppMethodBeat.i(150654);
    ab.i("MicroMsg.EditRevertPlugin", "EditRevertPlugin click");
    d.b.a(this.qbI, d.c.qes);
    AppMethodBeat.o(150654);
  }
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.j
 * JD-Core Version:    0.7.0.1
 */