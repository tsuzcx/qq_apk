package com.tencent.mm.plugin.multitalk.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MultiTalkMainUI$9
  implements DialogInterface.OnClickListener
{
  MultiTalkMainUI$9(MultiTalkMainUI paramMultiTalkMainUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(54126);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(54126);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI.9
 * JD-Core Version:    0.7.0.1
 */