package com.tencent.mm.pluginsdk.permission;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class PermissionActivity$3
  implements DialogInterface.OnClickListener
{
  PermissionActivity$3(PermissionActivity paramPermissionActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(79429);
    ab.i("MicroMsg.PermissionActivity", "onResume() goIgnoreBatteryOptimizations ");
    PermissionActivity.c(this.vMx);
    AppMethodBeat.o(79429);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.permission.PermissionActivity.3
 * JD-Core Version:    0.7.0.1
 */