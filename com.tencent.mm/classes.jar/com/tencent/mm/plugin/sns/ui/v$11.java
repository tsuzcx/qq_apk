package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.r;

final class v$11
  implements DialogInterface.OnCancelListener
{
  v$11(v paramv, r paramr) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(97907);
    if (this.Aiy.nJx != 0)
    {
      g.ajS();
      g.ajQ().gDv.a(this.Ahg);
      this.Aiy.nJx = 0;
    }
    AppMethodBeat.o(97907);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.v.11
 * JD-Core Version:    0.7.0.1
 */