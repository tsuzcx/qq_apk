package com.tencent.mm.ui.conversation;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

final class l$4
  implements DialogInterface.OnClickListener
{
  l$4(SharedPreferences paramSharedPreferences, boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(34582);
    this.AlL.edit().putInt("show_rating_flag", 4).commit();
    if (this.AlM)
    {
      this.AlL.edit().putBoolean("show_rating_again", false).commit();
      h.qsU.e(11216, new Object[] { Integer.valueOf(3), Integer.valueOf(this.AlN), Integer.valueOf(this.AlO) });
    }
    for (;;)
    {
      if (paramDialogInterface != null) {
        paramDialogInterface.dismiss();
      }
      l.dNa();
      AppMethodBeat.o(34582);
      return;
      ab.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]need to show rating dialog again.");
      this.AlL.edit().putBoolean("show_rating_again", true).commit();
      h.qsU.e(11216, new Object[] { Integer.valueOf(6), Integer.valueOf(this.AlN), Integer.valueOf(this.AlO) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.l.4
 * JD-Core Version:    0.7.0.1
 */