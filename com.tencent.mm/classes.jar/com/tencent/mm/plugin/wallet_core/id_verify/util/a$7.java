package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.wallet_core.ui.e;

final class a$7
  implements DialogInterface.OnClickListener
{
  a$7(a parama, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    e.a(1, bk.UX(), this.qsC);
    this.qsE.e(1, -1, "cancel", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.util.a.7
 * JD-Core Version:    0.7.0.1
 */