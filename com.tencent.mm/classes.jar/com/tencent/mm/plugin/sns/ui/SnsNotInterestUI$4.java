package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;

final class SnsNotInterestUI$4
  implements DialogInterface.OnCancelListener
{
  SnsNotInterestUI$4(SnsNotInterestUI paramSnsNotInterestUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(98922);
    g.aAi();
    g.aAg().hqi.a(this.EHe.EHd);
    AppMethodBeat.o(98922);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsNotInterestUI.4
 * JD-Core Version:    0.7.0.1
 */