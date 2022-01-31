package com.tencent.mm.ui.chatting.viewitems;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.e;

final class e$c$1
  implements DialogInterface.OnClickListener
{
  e$c$1(e.c paramc, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("key_scene", 1);
    paramDialogInterface.putExtra("key_receiver", this.rzT);
    paramDialogInterface.putExtra("key_receivertitle", this.vCs);
    paramDialogInterface.putExtra("key_sendertitle", this.vCt);
    paramDialogInterface.putExtra("key_sender_des", this.vCu);
    paramDialogInterface.putExtra("key_receiver_des", this.vCv);
    paramDialogInterface.putExtra("key_url", this.val$url);
    paramDialogInterface.putExtra("key_templateid", this.gBq);
    paramDialogInterface.putExtra("key_sceneid", this.vCw);
    d.b(this.vBl.vtz.getContext(), "wallet_index", ".ui.WalletSendC2CMsgUI", paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.e.c.1
 * JD-Core Version:    0.7.0.1
 */