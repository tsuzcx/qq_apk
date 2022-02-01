package com.tencent.mm.ui.chatting.viewitems;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.e.a;

final class f$c$1
  implements DialogInterface.OnClickListener
{
  f$c$1(f.c paramc, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(36853);
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("key_scene", 1);
    paramDialogInterface.putExtra("key_receiver", this.Qsk);
    paramDialogInterface.putExtra("key_receivertitle", this.Xfd);
    paramDialogInterface.putExtra("key_sendertitle", this.Xfe);
    paramDialogInterface.putExtra("key_sender_des", this.Xff);
    paramDialogInterface.putExtra("key_receiver_des", this.Xfg);
    paramDialogInterface.putExtra("key_url", this.val$url);
    paramDialogInterface.putExtra("key_templateid", this.Xfh);
    paramDialogInterface.putExtra("key_sceneid", this.Xfi);
    c.b(this.QWD.WQv.getContext(), "wallet_index", ".ui.WalletSendC2CMsgUI", paramDialogInterface);
    AppMethodBeat.o(36853);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.f.c.1
 * JD-Core Version:    0.7.0.1
 */