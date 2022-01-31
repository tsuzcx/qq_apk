package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.pluginsdk.ui.applet.a.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.b;

final class NormalUserFooterPreference$c$4
  implements a.b
{
  NormalUserFooterPreference$c$4(NormalUserFooterPreference.c paramc, String paramString1, String paramString2) {}
  
  public final boolean wU(String paramString)
  {
    AppMethodBeat.i(23702);
    String str = NormalUserFooterPreference.b(this.pCn.pCe).getIntent().getStringExtra("room_name");
    Intent localIntent = new Intent(NormalUserFooterPreference.b(this.pCn.pCe), SayHiWithSnsPermissionUI.class);
    localIntent.putExtra("Contact_User", NormalUserFooterPreference.a(this.pCn.pCe).field_username);
    localIntent.putExtra("Contact_Nick", NormalUserFooterPreference.a(this.pCn.pCe).field_nickname);
    localIntent.putExtra("Contact_RemarkName", NormalUserFooterPreference.a(this.pCn.pCe).field_conRemark);
    if ((NormalUserFooterPreference.l(this.pCn.pCe) == 14) || (NormalUserFooterPreference.l(this.pCn.pCe) == 8)) {
      localIntent.putExtra("Contact_RoomNickname", NormalUserFooterPreference.b(this.pCn.pCe).getIntent().getStringExtra("Contact_RoomNickname"));
    }
    localIntent.putExtra("Contact_Scene", NormalUserFooterPreference.l(this.pCn.pCe));
    localIntent.putExtra("room_name", str);
    localIntent.putExtra("source_from_user_name", this.pxy);
    localIntent.putExtra("source_from_nick_name", this.pxz);
    localIntent.putExtra("sayhi_with_sns_perm_send_verify", true);
    localIntent.putExtra("sayhi_with_sns_perm_add_remark", true);
    localIntent.putExtra("sayhi_with_sns_perm_set_label", false);
    localIntent.putExtra(e.b.yUZ, paramString);
    NormalUserFooterPreference.b(this.pCn.pCe).startActivityForResult(localIntent, 0);
    AppMethodBeat.o(23702);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.c.4
 * JD-Core Version:    0.7.0.1
 */