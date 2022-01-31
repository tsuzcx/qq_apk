package com.tencent.mm.plugin.recordvideo.plugin;

import a.l;
import a.v;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.c.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordClosePlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Landroid/view/View;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/View;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "onClick", "", "v", "setVisibility", "visibility", "", "Companion", "plugin-recordvideo_release"})
public final class t
  implements View.OnClickListener, q
{
  public static final a qcW;
  private View view;
  
  static
  {
    AppMethodBeat.i(150715);
    qcW = new a((byte)0);
    AppMethodBeat.o(150715);
  }
  
  public t(View paramView, d paramd)
  {
    AppMethodBeat.i(150714);
    this.view = paramView;
    this.view.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(150714);
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
    AppMethodBeat.i(150712);
    ab.i("MicroMsg.RecordClosePlugin", "RecordClosePlugin close");
    paramView = this.view.getContext();
    if (paramView == null)
    {
      paramView = new v("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(150712);
      throw paramView;
    }
    ((Activity)paramView).finish();
    paramView = b.qfu;
    b.Cs(3);
    AppMethodBeat.o(150712);
  }
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(150713);
    this.view.setVisibility(paramInt);
    AppMethodBeat.o(150713);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordClosePlugin$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.t
 * JD-Core Version:    0.7.0.1
 */