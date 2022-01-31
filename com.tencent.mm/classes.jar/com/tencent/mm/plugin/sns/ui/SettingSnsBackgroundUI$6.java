package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingSnsBackgroundUI$6
  implements DialogInterface.OnClickListener
{
  SettingSnsBackgroundUI$6(SettingSnsBackgroundUI paramSettingSnsBackgroundUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(38558);
    this.rLd.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    AppMethodBeat.o(38558);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SettingSnsBackgroundUI.6
 * JD-Core Version:    0.7.0.1
 */