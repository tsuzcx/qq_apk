package com.tencent.mm.plugin.nearby.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;

final class NearbyFriendsUI$14$1$1
  implements DialogInterface.OnCancelListener
{
  NearbyFriendsUI$14$1$1(NearbyFriendsUI.14.1 param1) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(55455);
    g.Rc().a(NearbyFriendsUI.x(this.pdq.pdp.pdm));
    AppMethodBeat.o(55455);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.14.1.1
 * JD-Core Version:    0.7.0.1
 */