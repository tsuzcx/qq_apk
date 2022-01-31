package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.pluginsdk.ui.applet.a.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.a;

final class NormalUserFooterPreference$c$4
  implements a.b
{
  NormalUserFooterPreference$c$4(NormalUserFooterPreference.c paramc, String paramString1, String paramString2) {}
  
  public final boolean pE(String paramString)
  {
    String str = NormalUserFooterPreference.b(this.mYO.mYC).getIntent().getStringExtra("room_name");
    Intent localIntent = new Intent(NormalUserFooterPreference.b(this.mYO.mYC), SayHiWithSnsPermissionUI.class);
    localIntent.putExtra("Contact_User", NormalUserFooterPreference.a(this.mYO.mYC).field_username);
    localIntent.putExtra("Contact_Nick", NormalUserFooterPreference.a(this.mYO.mYC).field_nickname);
    localIntent.putExtra("Contact_RemarkName", NormalUserFooterPreference.a(this.mYO.mYC).field_conRemark);
    if ((NormalUserFooterPreference.l(this.mYO.mYC) == 14) || (NormalUserFooterPreference.l(this.mYO.mYC) == 8)) {
      localIntent.putExtra("Contact_RoomNickname", NormalUserFooterPreference.b(this.mYO.mYC).getIntent().getStringExtra("Contact_RoomNickname"));
    }
    localIntent.putExtra("Contact_Scene", NormalUserFooterPreference.l(this.mYO.mYC));
    localIntent.putExtra("room_name", str);
    localIntent.putExtra("source_from_user_name", this.mYP);
    localIntent.putExtra("source_from_nick_name", this.mYQ);
    localIntent.putExtra("sayhi_with_sns_perm_send_verify", true);
    localIntent.putExtra("sayhi_with_sns_perm_add_remark", true);
    localIntent.putExtra("sayhi_with_sns_perm_set_label", false);
    localIntent.putExtra(e.a.uHO, paramString);
    NormalUserFooterPreference.b(this.mYO.mYC).startActivityForResult(localIntent, 0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.c.4
 * JD-Core Version:    0.7.0.1
 */