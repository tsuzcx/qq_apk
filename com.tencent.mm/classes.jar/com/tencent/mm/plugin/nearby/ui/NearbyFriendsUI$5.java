package com.tencent.mm.plugin.nearby.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class NearbyFriendsUI$5
  implements DialogInterface.OnClickListener
{
  NearbyFriendsUI$5(NearbyFriendsUI paramNearbyFriendsUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(55446);
    this.pdm.finish();
    AppMethodBeat.o(55446);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.5
 * JD-Core Version:    0.7.0.1
 */