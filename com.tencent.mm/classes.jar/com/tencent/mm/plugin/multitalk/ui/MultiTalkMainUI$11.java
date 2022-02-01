package com.tencent.mm.plugin.multitalk.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MultiTalkMainUI$11
  implements DialogInterface.OnClickListener
{
  MultiTalkMainUI$11(MultiTalkMainUI paramMultiTalkMainUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(114660);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(114660);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI.11
 * JD-Core Version:    0.7.0.1
 */