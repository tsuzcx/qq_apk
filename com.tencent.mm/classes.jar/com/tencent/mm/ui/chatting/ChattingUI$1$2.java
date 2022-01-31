package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lm;
import com.tencent.mm.sdk.b.a;

final class ChattingUI$1$2
  implements DialogInterface.OnClickListener
{
  ChattingUI$1$2(ChattingUI.1 param1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(30818);
    paramDialogInterface = new lm();
    a.ymk.l(paramDialogInterface);
    AppMethodBeat.o(30818);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingUI.1.2
 * JD-Core Version:    0.7.0.1
 */