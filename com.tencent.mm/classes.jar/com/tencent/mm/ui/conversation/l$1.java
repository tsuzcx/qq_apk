package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class l$1
  implements DialogInterface.OnClickListener
{
  l$1(SharedPreferences paramSharedPreferences, Context paramContext) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(34579);
    this.AlL.edit().putInt("show_rating_flag", 1).commit();
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    l.dNa();
    l.it(this.val$context);
    ab.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show rating dialog from enjoy app dialog.");
    AppMethodBeat.o(34579);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.l.1
 * JD-Core Version:    0.7.0.1
 */