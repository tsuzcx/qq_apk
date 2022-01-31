package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.j.a;

final class InviteFriendsBy3rdUI$6
  implements DialogInterface.OnClickListener
{
  InviteFriendsBy3rdUI$6(InviteFriendsBy3rdUI paramInviteFriendsBy3rdUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(25542);
    paramDialogInterface = this.sZR;
    AppCompatActivity localAppCompatActivity = this.sZR.getContext();
    this.sZR.getContext().getString(2131297087);
    InviteFriendsBy3rdUI.a(paramDialogInterface, h.b(localAppCompatActivity, this.sZR.getContext().getString(2131304397), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    }));
    InviteFriendsBy3rdUI.a(this.sZR).a(this.sZR, this.sZR.getContext());
    AppMethodBeat.o(25542);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.InviteFriendsBy3rdUI.6
 * JD-Core Version:    0.7.0.1
 */