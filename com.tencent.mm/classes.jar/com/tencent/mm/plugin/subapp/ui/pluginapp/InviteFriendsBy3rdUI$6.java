package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.AppCompatActivity;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.i.a;
import com.tencent.mm.ui.s;

final class InviteFriendsBy3rdUI$6
  implements DialogInterface.OnClickListener
{
  InviteFriendsBy3rdUI$6(InviteFriendsBy3rdUI paramInviteFriendsBy3rdUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.pyd;
    AppCompatActivity localAppCompatActivity = this.pyd.mController.uMN;
    this.pyd.mController.uMN.getString(R.l.app_tip);
    InviteFriendsBy3rdUI.a(paramDialogInterface, h.b(localAppCompatActivity, this.pyd.mController.uMN.getString(R.l.twitter_loading), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    }));
    InviteFriendsBy3rdUI.a(this.pyd).a(this.pyd, this.pyd.mController.uMN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.InviteFriendsBy3rdUI.6
 * JD-Core Version:    0.7.0.1
 */