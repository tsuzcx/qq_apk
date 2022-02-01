package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.s;

final class w$13
  implements DialogInterface.OnCancelListener
{
  w$13(w paramw, s params) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(97908);
    if (this.Erd.oUs != 0)
    {
      g.aAi();
      g.aAg().hqi.a(this.EpC);
      this.Erd.oUs = 0;
    }
    AppMethodBeat.o(97908);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.w.13
 * JD-Core Version:    0.7.0.1
 */