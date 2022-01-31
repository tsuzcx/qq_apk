package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class l$2
  implements DialogInterface.OnClickListener
{
  l$2(SharedPreferences paramSharedPreferences, Context paramContext) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(34580);
    this.AlL.edit().putInt("show_rating_flag", 2).commit();
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    l.dNa();
    l.iu(this.val$context);
    ab.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show feedback dialog.");
    AppMethodBeat.o(34580);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.l.2
 * JD-Core Version:    0.7.0.1
 */