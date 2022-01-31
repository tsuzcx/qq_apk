package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;

final class a$7
  implements DialogInterface.OnClickListener
{
  a$7(a parama, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(46672);
    com.tencent.mm.wallet_core.ui.e.a(2, bo.aox(), this.ueO);
    if ((this.ueQ.ueL != null) && (this.ueQ.ueL.get() != null))
    {
      g.RM();
      g.RK().eHt.a(385, this.ueQ);
      paramDialogInterface = new com.tencent.mm.plugin.wallet_core.id_verify.model.a(this.ueQ.mScene);
      ((com.tencent.mm.wallet_core.d.e)this.ueQ.ueL.get()).a(paramDialogInterface, true);
    }
    AppMethodBeat.o(46672);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.util.a.7
 * JD-Core Version:    0.7.0.1
 */