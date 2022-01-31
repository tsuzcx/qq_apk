package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.bind.ui.MobileFriendUI;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.s;

final class FMessageConversationUI$4
  implements View.OnClickListener
{
  FMessageConversationUI$4(FMessageConversationUI paramFMessageConversationUI) {}
  
  public final void onClick(View paramView)
  {
    au.Hx();
    if (!bk.bl((String)c.Dz().get(6, null)))
    {
      paramView = new Intent(this.pwx, MobileFriendUI.class);
      this.pwx.startActivity(paramView);
      return;
    }
    paramView = new Intent(this.pwx.mController.uMN, BindMContactIntroUI.class);
    paramView.putExtra("key_upload_scene", 5);
    MMWizardActivity.C(this.pwx, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI.4
 * JD-Core Version:    0.7.0.1
 */