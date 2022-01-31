package com.tencent.mm.pluginsdk.permission;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class PermissionActivity$2
  implements DialogInterface.OnClickListener
{
  PermissionActivity$2(PermissionActivity paramPermissionActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(79428);
    this.vMx.finish();
    AppMethodBeat.o(79428);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.permission.PermissionActivity.2
 * JD-Core Version:    0.7.0.1
 */