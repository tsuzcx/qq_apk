package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bi.d;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.h;

final class b$3
  implements View.OnClickListener
{
  b$3(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(25349);
    if ((paramView.getTag() instanceof com.tencent.mm.pluginsdk.ui.preference.b))
    {
      ab.d("MicroMsg.FMessageConversationUI", "verifyOkOnClick onClick");
      Object localObject1 = (com.tencent.mm.pluginsdk.ui.preference.b)paramView.getTag();
      Object localObject2 = com.tencent.mm.bi.d.alh().ase(((com.tencent.mm.pluginsdk.ui.preference.b)localObject1).username);
      if ((localObject2 == null) || (((ax)localObject2).field_msgContent == null))
      {
        ab.e("MicroMsg.FMessageConversationUI", "lastRecvFmsg is null, verify fail, talker = " + ((com.tencent.mm.pluginsdk.ui.preference.b)localObject1).username);
        AppMethodBeat.o(25349);
        return;
      }
      paramView = bi.d.asm(((ax)localObject2).field_msgContent);
      ab.d("MicroMsg.FMessageConversationUI", "try to addcontact, username = " + ((com.tencent.mm.pluginsdk.ui.preference.b)localObject1).username + ", opcode = MM_VERIFYUSER_VERIFYOK");
      if (paramView.yOy == 1)
      {
        h.a(b.a(this.sXN), paramView.yOz, null, b.a(this.sXN).getString(2131300006), b.a(this.sXN).getString(2131296888), true, new b.3.1(this, (ax)localObject2), null);
        AppMethodBeat.o(25349);
        return;
      }
      aw.aaz();
      bv localbv = c.YB().TM(((com.tencent.mm.pluginsdk.ui.preference.b)localObject1).username);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("Contact_User", ((com.tencent.mm.pluginsdk.ui.preference.b)localObject1).username);
      ((Intent)localObject2).putExtra("Contact_Nick", ((com.tencent.mm.pluginsdk.ui.preference.b)localObject1).nickname);
      if (localbv != null) {
        ((Intent)localObject2).putExtra("Contact_RemarkName", localbv.field_conRemark);
      }
      if (!bo.isNullOrNil(paramView.chatroomName))
      {
        aw.aaz();
        localObject1 = c.YJ().oU(paramView.chatroomName);
        if (localObject1 != null)
        {
          ((Intent)localObject2).putExtra("Contact_RoomNickname", ((u)localObject1).nE(paramView.tac));
          ((Intent)localObject2).putExtra("room_name", paramView.chatroomName);
        }
      }
      ((Intent)localObject2).putExtra("Contact_Scene", paramView.scene);
      ((Intent)localObject2).putExtra("Verify_ticket", paramView.mVw);
      ((Intent)localObject2).putExtra("sayhi_with_sns_perm_send_verify", false);
      ((Intent)localObject2).putExtra("sayhi_with_sns_perm_add_remark", true);
      ((Intent)localObject2).putExtra("sayhi_with_sns_perm_set_label", true);
      ((Intent)localObject2).putExtra("sayhi_with_jump_to_profile", true);
      com.tencent.mm.bq.d.b(b.a(this.sXN), "profile", ".ui.SayHiWithSnsPermissionUI", (Intent)localObject2);
    }
    AppMethodBeat.o(25349);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.friend.b.3
 * JD-Core Version:    0.7.0.1
 */