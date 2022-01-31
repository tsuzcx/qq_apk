package com.tencent.mm.pluginsdk.permission;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RequestFloatWindowPermissionDialog$1
  implements DialogInterface.OnCancelListener
{
  RequestFloatWindowPermissionDialog$1(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(79437);
    this.vMA.finish();
    AppMethodBeat.o(79437);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.1
 * JD-Core Version:    0.7.0.1
 */