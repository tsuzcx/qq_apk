package com.tencent.mm.plugin.setting.ui.qrcode;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import com.tencent.mm.plugin.account.ui.FacebookAuthUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class ShareToQQUI$3
  implements DialogInterface.OnClickListener
{
  ShareToQQUI$3(ShareToQQUI paramShareToQQUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.nRC.mController.uMN, FacebookAuthUI.class);
    paramDialogInterface.putExtra("is_force_unbind", true);
    this.nRC.mController.uMN.startActivity(paramDialogInterface);
    this.nRC.XM();
    this.nRC.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.qrcode.ShareToQQUI.3
 * JD-Core Version:    0.7.0.1
 */