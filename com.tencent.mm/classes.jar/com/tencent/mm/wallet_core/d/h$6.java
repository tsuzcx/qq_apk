package com.tencent.mm.wallet_core.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class h$6
  implements DialogInterface.OnClickListener
{
  h$6(WalletBaseUI paramWalletBaseUI, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(49130);
    a.b(this.tVi, null, this.val$errCode);
    if (this.tVi.isTransparent()) {
      this.tVi.finish();
    }
    AppMethodBeat.o(49130);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.wallet_core.d.h.6
 * JD-Core Version:    0.7.0.1
 */