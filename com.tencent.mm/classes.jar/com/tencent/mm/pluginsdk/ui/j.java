package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.base.h;

public final class j
{
  public static boolean eY(Context paramContext)
  {
    if (!ag.Zm("network_doctor_shown")) {
      return false;
    }
    h.a(paramContext, R.l.network_doctor, R.l.app_tip, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        this.val$context.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
      }
    }, null);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.j
 * JD-Core Version:    0.7.0.1
 */