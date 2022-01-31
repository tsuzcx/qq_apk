package com.tencent.mm.ui.conversation;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

final class m$4
  implements DialogInterface.OnClickListener
{
  m$4(SharedPreferences paramSharedPreferences, boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.vTP.edit().putInt("show_rating_flag", 4).commit();
    if (this.vTQ)
    {
      this.vTP.edit().putBoolean("show_rating_again", false).commit();
      h.nFQ.f(11216, new Object[] { Integer.valueOf(3), Integer.valueOf(this.vTR), Integer.valueOf(this.vTS) });
    }
    for (;;)
    {
      if (paramDialogInterface != null) {
        paramDialogInterface.dismiss();
      }
      m.cIu();
      return;
      y.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]need to show rating dialog again.");
      this.vTP.edit().putBoolean("show_rating_again", true).commit();
      h.nFQ.f(11216, new Object[] { Integer.valueOf(6), Integer.valueOf(this.vTR), Integer.valueOf(this.vTS) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.m.4
 * JD-Core Version:    0.7.0.1
 */