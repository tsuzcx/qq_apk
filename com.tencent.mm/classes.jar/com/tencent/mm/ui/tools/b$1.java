package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.storage.ad;

final class b$1
  implements DialogInterface.OnClickListener
{
  b$1(d paramd, Activity paramActivity, ad paramad, boolean paramBoolean, int paramInt, Runnable paramRunnable) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(34785);
    b.a(this.Aqz, this.gjR, this.ego, this.AqA, this.AqB);
    if (this.AqC != null) {
      this.AqC.run();
    }
    AppMethodBeat.o(34785);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.b.1
 * JD-Core Version:    0.7.0.1
 */