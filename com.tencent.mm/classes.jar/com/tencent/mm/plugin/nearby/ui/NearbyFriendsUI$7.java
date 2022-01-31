package com.tencent.mm.plugin.nearby.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.sdk.platformtools.ab;

final class NearbyFriendsUI$7
  implements DialogInterface.OnCancelListener
{
  NearbyFriendsUI$7(NearbyFriendsUI paramNearbyFriendsUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(55447);
    this.pdm.eUJ = true;
    com.tencent.mm.plugin.report.service.g.Cz(11);
    if (NearbyFriendsUI.b(this.pdm) != null) {
      com.tencent.mm.kernel.g.Rc().a(NearbyFriendsUI.b(this.pdm));
    }
    ab.i("MicroMsg.NearbyFriend", "[MonsterzDai]  [loading cancel] cancel in loading");
    if (!NearbyFriendsUI.c(this.pdm))
    {
      this.pdm.finish();
      ab.i("MicroMsg.NearbyFriend", "[MonsterzDai]  [loading cancel] cancel in first loading");
    }
    AppMethodBeat.o(55447);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.7
 * JD-Core Version:    0.7.0.1
 */