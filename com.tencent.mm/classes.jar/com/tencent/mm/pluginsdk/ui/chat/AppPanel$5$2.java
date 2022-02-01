package com.tencent.mm.pluginsdk.ui.chat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppPanel$5$2
  implements DialogInterface.OnClickListener
{
  AppPanel$5$2(AppPanel.5 param5) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(204870);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(204870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.AppPanel.5.2
 * JD-Core Version:    0.7.0.1
 */