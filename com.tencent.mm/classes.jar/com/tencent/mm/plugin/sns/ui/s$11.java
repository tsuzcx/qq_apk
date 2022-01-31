package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.r;

final class s$11
  implements DialogInterface.OnCancelListener
{
  s$11(s params, r paramr) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(38259);
    if (this.rHr.jKp != 0)
    {
      g.RM();
      g.RK().eHt.a(this.rHu);
      this.rHr.jKp = 0;
    }
    AppMethodBeat.o(38259);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.s.11
 * JD-Core Version:    0.7.0.1
 */