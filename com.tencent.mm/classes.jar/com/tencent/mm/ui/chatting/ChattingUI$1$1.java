package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pa;
import com.tencent.mm.sdk.b.a;

final class ChattingUI$1$1
  implements DialogInterface.OnClickListener
{
  ChattingUI$1$1(ChattingUI.1 param1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(30817);
    paramDialogInterface = new pa();
    a.ymk.l(paramDialogInterface);
    AppMethodBeat.o(30817);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingUI.1.1
 * JD-Core Version:    0.7.0.1
 */