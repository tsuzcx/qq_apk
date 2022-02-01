package com.tencent.mm.plugin.sns.ui.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.s;

final class b$2$1
  implements DialogInterface.OnCancelListener
{
  b$2$1(b.2 param2, s params) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(203951);
    g.aAi();
    g.aAg().hqi.a(this.Eph);
    AppMethodBeat.o(203951);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.2.1
 * JD-Core Version:    0.7.0.1
 */