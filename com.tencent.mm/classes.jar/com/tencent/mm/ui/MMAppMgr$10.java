package com.tencent.mm.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMAppMgr$10
  implements DialogInterface.OnClickListener
{
  MMAppMgr$10(Context paramContext) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(29560);
    try
    {
      this.val$context.startActivity(new Intent("android.settings.APN_SETTINGS"));
      AppMethodBeat.o(29560);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      AppMethodBeat.o(29560);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.MMAppMgr.10
 * JD-Core Version:    0.7.0.1
 */