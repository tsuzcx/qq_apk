package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;

final class HomeUI$25
  implements DialogInterface.OnClickListener
{
  HomeUI$25(HomeUI paramHomeUI, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(33203);
    try
    {
      NetStatusUtil.startSettingItent(HomeUI.c(this.VWJ), this.val$type);
      AppMethodBeat.o(33203);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      Log.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", paramDialogInterface, "", new Object[0]);
      AppMethodBeat.o(33203);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.25
 * JD-Core Version:    0.7.0.1
 */