package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bk;
import java.lang.ref.WeakReference;

final class a$6
  implements DialogInterface.OnClickListener
{
  a$6(a parama, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    com.tencent.mm.wallet_core.ui.e.a(2, bk.UX(), this.qsC);
    if ((this.qsE.qsz != null) && (this.qsE.qsz.get() != null))
    {
      g.DQ();
      g.DO().dJT.a(385, this.qsE);
      paramDialogInterface = new com.tencent.mm.plugin.wallet_core.id_verify.model.a(this.qsE.fzn);
      ((com.tencent.mm.wallet_core.d.e)this.qsE.qsz.get()).a(paramDialogInterface, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.util.a.6
 * JD-Core Version:    0.7.0.1
 */