package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

final class InviteFriendsBy3rdUI$4
  implements DialogInterface.OnClickListener
{
  InviteFriendsBy3rdUI$4(InviteFriendsBy3rdUI paramInviteFriendsBy3rdUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(25541);
    d.b(this.sZR.getContext(), "account", ".ui.FacebookAuthUI", new Intent());
    AppMethodBeat.o(25541);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.InviteFriendsBy3rdUI.4
 * JD-Core Version:    0.7.0.1
 */