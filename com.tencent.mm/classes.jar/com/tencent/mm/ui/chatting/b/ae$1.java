package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;

final class ae$1
  implements DialogInterface.OnCancelListener
{
  ae$1(ae paramae, bi parambi, t paramt) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    y.i("MicroMsg.ChattingUI.VerifyUserComponent", "cancel revoke msg:%d", new Object[] { Long.valueOf(this.dUH.field_msgId) });
    au.Dk().c(this.vrL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.ae.1
 * JD-Core Version:    0.7.0.1
 */