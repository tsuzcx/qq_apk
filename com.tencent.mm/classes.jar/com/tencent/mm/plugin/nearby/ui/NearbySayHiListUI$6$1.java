package com.tencent.mm.plugin.nearby.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;

final class NearbySayHiListUI$6$1
  implements DialogInterface.OnCancelListener
{
  NearbySayHiListUI$6$1(NearbySayHiListUI.6 param6) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(55499);
    g.Rc().a(NearbySayHiListUI.f(this.pdT.pdR));
    AppMethodBeat.o(55499);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.6.1
 * JD-Core Version:    0.7.0.1
 */