package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.s;
import com.tencent.mm.modelmulti.h;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.ui.applet.g.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.aj;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.aa;
import com.tencent.mm.ui.transmit.SelectConversationUI;
import java.util.List;

@com.tencent.mm.ui.chatting.c.a.a(dJy=com.tencent.mm.ui.chatting.c.b.e.class)
public class d
  extends a
  implements com.tencent.mm.ui.chatting.c.b.e
{
  public final boolean bc(bi parambi)
  {
    AppMethodBeat.i(31238);
    if (parambi.dxR())
    {
      if (!this.caz.getTalkerUserName().equals("medianote"))
      {
        aw.aaz();
        com.tencent.mm.model.c.Yz().c(new com.tencent.mm.az.e(parambi.field_talker, parambi.field_msgSvrId));
      }
      aj.aX(parambi);
      this.caz.qT(true);
      AppMethodBeat.o(31238);
      return true;
    }
    AppMethodBeat.o(31238);
    return false;
  }
  
  public final void dBY()
  {
    AppMethodBeat.i(31241);
    Object localObject2 = this.caz.zJz.getContext().getIntent();
    String str1 = ((Intent)localObject2).getStringExtra("Chat_User");
    Object localObject1 = ((Intent)localObject2).getStringExtra("send_card_username");
    if (!bo.isNullOrNil((String)localObject1))
    {
      boolean bool = ((Intent)localObject2).getBooleanExtra("Is_Chatroom", false);
      localObject2 = ((Intent)localObject2).getStringExtra("send_card_edittext");
      if (!bool) {
        break label150;
      }
      localObject3 = bo.bf(str1, "");
      str2 = aa.auE((String)localObject1);
      if (!ad.arf((String)localObject1)) {
        break label144;
      }
    }
    label144:
    for (int i = 66;; i = 42)
    {
      localObject1 = new h((String)localObject3, str2, i);
      aw.Rc().a((m)localObject1, 0);
      if (localObject2 != null) {
        g.bPJ().fh((String)localObject2, str1);
      }
      AppMethodBeat.o(31241);
      return;
    }
    label150:
    Object localObject3 = bo.P(bo.bf(str1, "").split(","));
    String str2 = aa.auE((String)localObject1);
    i = 0;
    label176:
    Object localObject4;
    if (i < ((List)localObject3).size())
    {
      localObject4 = (String)((List)localObject3).get(i);
      if (!ad.arf((String)localObject1)) {
        break label242;
      }
    }
    label242:
    for (int j = 66;; j = 42)
    {
      localObject4 = new h((String)localObject4, str2, j);
      aw.Rc().a((m)localObject4, 0);
      i += 1;
      break label176;
      break;
    }
  }
  
  public final void dHM()
  {
    AppMethodBeat.i(31239);
    Intent localIntent = new Intent(this.caz.zJz.getContext(), SelectContactUI.class);
    if ((ad.arf(this.caz.getTalkerUserName())) || (com.tencent.mm.model.t.nK(this.caz.getTalkerUserName()))) {
      localIntent.putExtra("list_attr", com.tencent.mm.ui.contact.t.F(new int[] { com.tencent.mm.ui.contact.t.AdX, 1, 16777216 }));
    }
    for (;;)
    {
      localIntent.putExtra("list_type", 4);
      localIntent.putExtra("received_card_name", this.caz.getTalkerUserName());
      localIntent.putExtra("block_contact", this.caz.getTalkerUserName());
      localIntent.putExtra("Add_SendCard", true);
      localIntent.putExtra("titile", this.caz.zJz.getMMResources().getString(2131296502));
      this.caz.zJz.startActivityForResult(localIntent, 223);
      AppMethodBeat.o(31239);
      return;
      localIntent.putExtra("list_attr", com.tencent.mm.ui.contact.t.F(new int[] { com.tencent.mm.ui.contact.t.AdX, 2048, 16777216 }));
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(31240);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(31240);
      return;
      String str1;
      String str3;
      String str2;
      boolean bool;
      g.a locala;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        str1 = paramIntent.getStringExtra("be_send_card_name");
        if (this.caz.dJG()) {
          ad.arf(str1);
        }
        str3 = s.nE(str1);
        str2 = paramIntent.getStringExtra("received_card_name");
        bool = paramIntent.getBooleanExtra("Is_Chatroom", false);
        locala = new g.a(this.caz.zJz.getContext());
        b.b(str1, true, -1);
        aw.aaz();
        paramIntent = com.tencent.mm.model.c.YA().aru(str1);
        if (!com.tencent.mm.model.t.ku(paramIntent.field_verifyFlag)) {
          break label240;
        }
        paramIntent = this.caz.zJz.getResources().getString(2131296968);
      }
      for (;;)
      {
        paramIntent = paramIntent + str3;
        locala.cq(str2).amm(paramIntent).i(Boolean.TRUE).LU(2131297067).a(new d.1(this, str1, str2, bool)).gwf.show();
        AppMethodBeat.o(31240);
        return;
        label240:
        if (ad.arf(str1)) {
          paramIntent = SelectConversationUI.c(ah.getContext(), paramIntent);
        } else {
          paramIntent = this.caz.zJz.getResources().getString(2131296969);
        }
      }
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        str1 = paramIntent.getStringExtra("be_send_card_name");
        str2 = paramIntent.getStringExtra("received_card_name");
        str3 = paramIntent.getStringExtra("custom_send_text");
        bool = paramIntent.getBooleanExtra("Is_Chatroom", false);
        paramIntent = new Intent(this.caz.zJz.getContext(), ChattingUI.class);
        paramIntent.putExtra("Chat_User", str2);
        paramIntent.putExtra("send_card_username", str1);
        paramIntent.putExtra("send_card_edittext", str3);
        paramIntent.putExtra("Is_Chatroom", bool);
        this.caz.zJz.startActivity(paramIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.d
 * JD-Core Version:    0.7.0.1
 */