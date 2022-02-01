package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.model.az;
import com.tencent.mm.modelmulti.h;

final class InviteFriendsBy3rdUI$9
  implements DialogInterface.OnCancelListener
{
  InviteFriendsBy3rdUI$9(InviteFriendsBy3rdUI paramInviteFriendsBy3rdUI, h paramh) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(29234);
    az.aeS().a(this.sJy);
    AppMethodBeat.o(29234);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.InviteFriendsBy3rdUI.9
 * JD-Core Version:    0.7.0.1
 */