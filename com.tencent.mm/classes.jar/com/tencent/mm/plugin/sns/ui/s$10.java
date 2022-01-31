package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.r;

final class s$10
  implements DialogInterface.OnCancelListener
{
  s$10(s params, r paramr) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(38258);
    if (this.rHr.jKp != 0)
    {
      g.RM();
      g.RK().eHt.a(this.rHu);
      this.rHr.jKp = 0;
    }
    AppMethodBeat.o(38258);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.s.10
 * JD-Core Version:    0.7.0.1
 */