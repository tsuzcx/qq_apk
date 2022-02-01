package com.tencent.mm.plugin.nearby.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;

final class NearbyFriendsUI$3
  implements DialogInterface.OnCancelListener
{
  NearbyFriendsUI$3(NearbyFriendsUI paramNearbyFriendsUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(89841);
    g.azz().a(NearbyFriendsUI.z(this.AAi));
    AppMethodBeat.o(89841);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.3
 * JD-Core Version:    0.7.0.1
 */