package com.tencent.mm.ui.chatting.c;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.i;

final class j$2$1
  implements DialogInterface.OnClickListener
{
  j$2$1(j.2 param2, Context paramContext, h paramh) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(31307);
    ab.i("MicroMsg.ChattingMoreBtnBarHelper", "delete message");
    i.a(this.val$context, this.zEU.dGZ(), this.zEV.zET);
    this.zEV.zET.dHU();
    AppMethodBeat.o(31307);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.j.2.1
 * JD-Core Version:    0.7.0.1
 */