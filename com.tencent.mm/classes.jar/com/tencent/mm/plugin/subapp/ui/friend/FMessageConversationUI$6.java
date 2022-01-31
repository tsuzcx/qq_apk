package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.bind.ui.MobileFriendUI;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.s;

final class FMessageConversationUI$6
  implements AdapterView.OnItemClickListener
{
  FMessageConversationUI$6(FMessageConversationUI paramFMessageConversationUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt == 0)
    {
      if (l.WP() != l.a.ffT)
      {
        paramAdapterView = new Intent(this.pwx.mController.uMN, BindMContactIntroUI.class);
        paramAdapterView.putExtra("key_upload_scene", 5);
        MMWizardActivity.C(this.pwx.mController.uMN, paramAdapterView);
      }
    }
    else {
      return;
    }
    this.pwx.startActivity(new Intent(this.pwx.mController.uMN, MobileFriendUI.class));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI.6
 * JD-Core Version:    0.7.0.1
 */