package com.tencent.mm.plugin.multitalk.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MultiTalkMainUI$8
  implements DialogInterface.OnClickListener
{
  MultiTalkMainUI$8(MultiTalkMainUI paramMultiTalkMainUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(54125);
    this.oVe.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    AppMethodBeat.o(54125);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI.8
 * JD-Core Version:    0.7.0.1
 */