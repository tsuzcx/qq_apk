package com.tencent.mm.plugin.traceroute.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class NetworkDiagnoseAllInOneUI$5
  implements DialogInterface.OnClickListener
{
  NetworkDiagnoseAllInOneUI$5(NetworkDiagnoseAllInOneUI paramNetworkDiagnoseAllInOneUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.pJe.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseAllInOneUI.5
 * JD-Core Version:    0.7.0.1
 */