package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;

final class u$12
  implements DialogInterface.OnCancelListener
{
  u$12(u paramu, com.tencent.mm.plugin.sns.model.q paramq) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(97908);
    if (this.yAb.ndF != 0)
    {
      g.agS();
      g.agQ().ghe.a(this.yyN);
      this.yAb.ndF = 0;
    }
    AppMethodBeat.o(97908);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.u.12
 * JD-Core Version:    0.7.0.1
 */