package com.tencent.mm.wallet_core.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class h$9
  implements DialogInterface.OnClickListener
{
  h$9(WalletBaseUI paramWalletBaseUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(49133);
    paramDialogInterface = new Bundle();
    paramDialogInterface.putBoolean("key_is_bind_bankcard", false);
    a.a(this.tVi, "BindCardProcess", paramDialogInterface, new h.9.1(this));
    AppMethodBeat.o(49133);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.wallet_core.d.h.9
 * JD-Core Version:    0.7.0.1
 */