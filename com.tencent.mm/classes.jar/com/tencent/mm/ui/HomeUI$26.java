package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;

final class HomeUI$26
  implements DialogInterface.OnClickListener
{
  HomeUI$26(HomeUI paramHomeUI, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(33205);
    try
    {
      NetStatusUtil.startSettingItent(HomeUI.c(this.adBf), this.val$type);
      AppMethodBeat.o(33205);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      Log.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", paramDialogInterface, "", new Object[0]);
      AppMethodBeat.o(33205);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.26
 * JD-Core Version:    0.7.0.1
 */