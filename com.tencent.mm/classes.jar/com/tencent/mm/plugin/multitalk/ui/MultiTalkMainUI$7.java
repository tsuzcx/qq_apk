package com.tencent.mm.plugin.multitalk.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MultiTalkMainUI$7
  implements DialogInterface.OnClickListener
{
  MultiTalkMainUI$7(MultiTalkMainUI paramMultiTalkMainUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(54124);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(54124);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI.7
 * JD-Core Version:    0.7.0.1
 */