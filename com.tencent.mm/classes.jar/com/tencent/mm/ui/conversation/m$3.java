package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

final class m$3
  implements DialogInterface.OnClickListener
{
  m$3(SharedPreferences paramSharedPreferences, Context paramContext, boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.vTP.edit().putInt("show_rating_flag", 4).commit();
    String str = "market://details?id=" + ae.getPackageName();
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(Uri.parse(str));
    this.val$context.startActivity(localIntent);
    y.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]start market intent");
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    this.vTP.edit().putBoolean("show_rating_again", false).commit();
    m.cIu();
    if (this.vTQ)
    {
      h.nFQ.f(11216, new Object[] { Integer.valueOf(5), Integer.valueOf(this.vTR), Integer.valueOf(this.vTS) });
      return;
    }
    h.nFQ.f(11216, new Object[] { Integer.valueOf(4), Integer.valueOf(this.vTR), Integer.valueOf(this.vTS) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.m.3
 * JD-Core Version:    0.7.0.1
 */