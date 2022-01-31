package com.tencent.mm.wallet_core.d;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import java.util.HashSet;
import java.util.Iterator;

final class i$2
  implements DialogInterface.OnCancelListener
{
  i$2(i parami) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(49140);
    if ((this.AXG.gKM != null) && (this.AXG.gKK.isEmpty()))
    {
      this.AXG.gKM.dismiss();
      paramDialogInterface = this.AXG.gKL.iterator();
      while (paramDialogInterface.hasNext())
      {
        m localm = (m)paramDialogInterface.next();
        g.RM();
        g.RK().eHt.a(localm);
      }
      this.AXG.gKL.clear();
    }
    AppMethodBeat.o(49140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.d.i.2
 * JD-Core Version:    0.7.0.1
 */