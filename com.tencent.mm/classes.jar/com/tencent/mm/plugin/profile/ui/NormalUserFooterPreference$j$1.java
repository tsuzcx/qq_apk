package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.ui.MMActivity;

final class NormalUserFooterPreference$j$1
  implements View.OnClickListener
{
  NormalUserFooterPreference$j$1(NormalUserFooterPreference.j paramj) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(23725);
    NormalUserFooterPreference.b(this.pCq.pCe).getIntent().removeExtra("Accept_NewFriend_FromOutside");
    paramView = new Intent(NormalUserFooterPreference.b(this.pCq.pCe), SayHiWithSnsPermissionUI.class);
    paramView.putExtra("Contact_User", NormalUserFooterPreference.a(this.pCq.pCe).field_username);
    paramView.putExtra("room_name", NormalUserFooterPreference.b(this.pCq.pCe).getIntent().getStringExtra("room_name"));
    paramView.putExtra("Contact_Nick", NormalUserFooterPreference.a(this.pCq.pCe).field_nickname);
    paramView.putExtra("Contact_RemarkName", NormalUserFooterPreference.a(this.pCq.pCe).field_conRemark);
    if ((NormalUserFooterPreference.l(this.pCq.pCe) == 14) || (NormalUserFooterPreference.l(this.pCq.pCe) == 8)) {
      paramView.putExtra("Contact_RoomNickname", NormalUserFooterPreference.b(this.pCq.pCe).getIntent().getStringExtra("Contact_RoomNickname"));
    }
    paramView.putExtra("Contact_Scene", NormalUserFooterPreference.l(this.pCq.pCe));
    paramView.putExtra("Verify_ticket", NormalUserFooterPreference.y(this.pCq.pCe));
    paramView.putExtra("sayhi_with_sns_perm_send_verify", false);
    paramView.putExtra("sayhi_with_sns_perm_add_remark", true);
    paramView.putExtra("sayhi_with_sns_perm_set_label", true);
    NormalUserFooterPreference.b(this.pCq.pCe).startActivityForResult(paramView, 0);
    AppMethodBeat.o(23725);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.j.1
 * JD-Core Version:    0.7.0.1
 */