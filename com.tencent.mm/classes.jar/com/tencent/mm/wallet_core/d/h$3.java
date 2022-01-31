package com.tencent.mm.wallet_core.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class h$3
  implements DialogInterface.OnClickListener
{
  h$3(WalletBaseUI paramWalletBaseUI, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(49127);
    a.b(this.tVi, this.tVi.getInput(), this.val$errCode);
    if ((this.tVi.isTransparent()) || (this.tVi.getContentViewVisibility() != 0)) {
      this.tVi.finish();
    }
    AppMethodBeat.o(49127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.d.h.3
 * JD-Core Version:    0.7.0.1
 */