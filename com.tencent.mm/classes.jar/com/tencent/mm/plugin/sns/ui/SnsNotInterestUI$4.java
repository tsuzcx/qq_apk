package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;

final class SnsNotInterestUI$4
  implements DialogInterface.OnCancelListener
{
  SnsNotInterestUI$4(SnsNotInterestUI paramSnsNotInterestUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(39126);
    g.RM();
    g.RK().eHt.a(this.rTQ.rTP);
    AppMethodBeat.o(39126);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsNotInterestUI.4
 * JD-Core Version:    0.7.0.1
 */