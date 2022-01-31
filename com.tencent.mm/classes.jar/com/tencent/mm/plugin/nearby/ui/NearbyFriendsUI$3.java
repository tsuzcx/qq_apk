package com.tencent.mm.plugin.nearby.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;

final class NearbyFriendsUI$3
  implements DialogInterface.OnCancelListener
{
  NearbyFriendsUI$3(NearbyFriendsUI paramNearbyFriendsUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(55444);
    g.Rc().a(NearbyFriendsUI.z(this.pdm));
    AppMethodBeat.o(55444);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.3
 * JD-Core Version:    0.7.0.1
 */