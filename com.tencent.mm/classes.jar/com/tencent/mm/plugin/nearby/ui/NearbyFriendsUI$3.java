package com.tencent.mm.plugin.nearby.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;

final class NearbyFriendsUI$3
  implements DialogInterface.OnCancelListener
{
  NearbyFriendsUI$3(NearbyFriendsUI paramNearbyFriendsUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    g.Dk().c(NearbyFriendsUI.x(this.mDs));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.3
 * JD-Core Version:    0.7.0.1
 */