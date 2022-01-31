package com.tencent.mm.plugin.nearby.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.sdk.platformtools.y;

final class NearbyFriendsUI$7
  implements DialogInterface.OnCancelListener
{
  NearbyFriendsUI$7(NearbyFriendsUI paramNearbyFriendsUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    this.mDs.edT = true;
    com.tencent.mm.plugin.report.service.g.wK(11);
    if (NearbyFriendsUI.b(this.mDs) != null) {
      com.tencent.mm.kernel.g.Dk().c(NearbyFriendsUI.b(this.mDs));
    }
    y.i("MicroMsg.NearbyFriend", "[MonsterzDai]  [loading cancel] cancel in loading");
    if (!NearbyFriendsUI.c(this.mDs))
    {
      this.mDs.finish();
      y.i("MicroMsg.NearbyFriend", "[MonsterzDai]  [loading cancel] cancel in first loading");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.7
 * JD-Core Version:    0.7.0.1
 */