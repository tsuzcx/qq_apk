package com.tencent.mm.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class MMAppMgr$14
  implements DialogInterface.OnClickListener
{
  MMAppMgr$14(Context paramContext) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      this.val$context.startActivity(new Intent("android.settings.APN_SETTINGS"));
      return;
    }
    catch (Exception paramDialogInterface) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.MMAppMgr.14
 * JD-Core Version:    0.7.0.1
 */