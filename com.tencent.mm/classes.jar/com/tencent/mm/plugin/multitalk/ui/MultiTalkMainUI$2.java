package com.tencent.mm.plugin.multitalk.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MultiTalkMainUI$2
  implements DialogInterface.OnClickListener
{
  MultiTalkMainUI$2(MultiTalkMainUI paramMultiTalkMainUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(239434);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(239434);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI.2
 * JD-Core Version:    0.7.0.1
 */