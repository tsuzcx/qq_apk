package com.tencent.mm.ui.conversation;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.plugin.report.service.h;

final class m$6
  implements DialogInterface.OnClickListener
{
  m$6(SharedPreferences paramSharedPreferences, int paramInt1, int paramInt2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.vTP.edit().putInt("show_rating_flag", 4).commit();
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    m.cIu();
    h.nFQ.f(11216, new Object[] { Integer.valueOf(1), Integer.valueOf(this.vTR), Integer.valueOf(this.vTS) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.m.6
 * JD-Core Version:    0.7.0.1
 */