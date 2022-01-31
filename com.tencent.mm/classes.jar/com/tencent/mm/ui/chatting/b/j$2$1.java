package com.tencent.mm.ui.chatting.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.b.b.g;

final class j$2$1
  implements DialogInterface.OnClickListener
{
  j$2$1(j.2 param2, Context paramContext, g paramg) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.ChattingMoreBtnBarHelper", "delete message");
    com.tencent.mm.ui.chatting.j.a(this.val$context, this.vps.cDl(), this.vpt.vpr);
    this.vpt.vpr.cEf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.j.2.1
 * JD-Core Version:    0.7.0.1
 */