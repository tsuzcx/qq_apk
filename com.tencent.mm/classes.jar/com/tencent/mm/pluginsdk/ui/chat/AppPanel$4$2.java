package com.tencent.mm.pluginsdk.ui.chat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppPanel$4$2
  implements DialogInterface.OnClickListener
{
  AppPanel$4$2(AppPanel.4 param4) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(27745);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(27745);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.AppPanel.4.2
 * JD-Core Version:    0.7.0.1
 */