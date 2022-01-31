package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;

final class HomeUI$20
  implements DialogInterface.OnClickListener
{
  HomeUI$20(HomeUI paramHomeUI, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(29366);
    try
    {
      at.startSettingItent(HomeUI.b(this.yYw), this.bHS);
      AppMethodBeat.o(29366);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      ab.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", paramDialogInterface, "", new Object[0]);
      AppMethodBeat.o(29366);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.20
 * JD-Core Version:    0.7.0.1
 */