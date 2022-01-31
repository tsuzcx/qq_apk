package com.tencent.mm.ui.chatting.b;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.mm.R.l;
import com.tencent.mm.ag.b;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.pluginsdk.ui.applet.g.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.am;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.z;
import com.tencent.mm.ui.transmit.SelectConversationUI;
import com.tencent.mm.ui.x;
import java.util.List;

@com.tencent.mm.ui.chatting.b.a.a(cFA=com.tencent.mm.ui.chatting.b.b.d.class)
public class d
  extends a
  implements com.tencent.mm.ui.chatting.b.b.d
{
  public final boolean aR(bi parambi)
  {
    if (parambi.cvn())
    {
      if (!this.byx.getTalkerUserName().equals("medianote"))
      {
        au.Hx();
        com.tencent.mm.model.c.Fv().b(new com.tencent.mm.ay.d(parambi.field_talker, parambi.field_msgSvrId));
      }
      am.aN(parambi);
      this.byx.cCW();
      return true;
    }
    return false;
  }
  
  public final void cDW()
  {
    Intent localIntent = new Intent(this.byx.vtz.getContext(), SelectContactUI.class);
    if ((ad.aaU(this.byx.getTalkerUserName())) || (com.tencent.mm.model.s.hb(this.byx.getTalkerUserName()))) {
      localIntent.putExtra("list_attr", com.tencent.mm.ui.contact.s.v(new int[] { com.tencent.mm.ui.contact.s.vMv, 1, 16777216 }));
    }
    for (;;)
    {
      localIntent.putExtra("list_type", 4);
      localIntent.putExtra("received_card_name", this.byx.getTalkerUserName());
      localIntent.putExtra("block_contact", this.byx.getTalkerUserName());
      localIntent.putExtra("Add_SendCard", true);
      localIntent.putExtra("titile", this.byx.vtz.getMMResources().getString(R.l.address_title_select_contact));
      this.byx.vtz.startActivityForResult(localIntent, 223);
      return;
      localIntent.putExtra("list_attr", com.tencent.mm.ui.contact.s.v(new int[] { com.tencent.mm.ui.contact.s.vMv, 2048, 16777216 }));
    }
  }
  
  public final void cyM()
  {
    Object localObject2 = this.byx.vtz.getContext().getIntent();
    String str1 = ((Intent)localObject2).getStringExtra("Chat_User");
    Object localObject1 = ((Intent)localObject2).getStringExtra("send_card_username");
    if (!bk.bl((String)localObject1))
    {
      boolean bool = ((Intent)localObject2).getBooleanExtra("Is_Chatroom", false);
      localObject2 = ((Intent)localObject2).getStringExtra("send_card_edittext");
      if (!bool) {
        break label138;
      }
      localObject3 = bk.aM(str1, "");
      str2 = z.adW((String)localObject1);
      if (!ad.aaU((String)localObject1)) {
        break label132;
      }
    }
    label132:
    for (int i = 66;; i = 42)
    {
      localObject1 = new com.tencent.mm.modelmulti.h((String)localObject3, str2, i);
      au.Dk().a((m)localObject1, 0);
      if (localObject2 != null) {
        g.bhI().dO((String)localObject2, str1);
      }
      return;
    }
    label138:
    Object localObject3 = bk.G(bk.aM(str1, "").split(","));
    String str2 = z.adW((String)localObject1);
    i = 0;
    label164:
    Object localObject4;
    if (i < ((List)localObject3).size())
    {
      localObject4 = (String)((List)localObject3).get(i);
      if (!ad.aaU((String)localObject1)) {
        break label230;
      }
    }
    label230:
    for (int j = 66;; j = 42)
    {
      localObject4 = new com.tencent.mm.modelmulti.h((String)localObject4, str2, j);
      au.Dk().a((m)localObject4, 0);
      i += 1;
      break label164;
      break;
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        return;
      } while ((paramInt2 != -1) || (paramIntent == null));
      str1 = paramIntent.getStringExtra("be_send_card_name");
      if (this.byx.cFE()) {
        ad.aaU(str1);
      }
      str3 = r.gV(str1);
      str2 = paramIntent.getStringExtra("received_card_name");
      bool = paramIntent.getBooleanExtra("Is_Chatroom", false);
      g.a locala = new g.a(this.byx.vtz.getContext());
      b.a(str1, true, -1);
      au.Hx();
      paramIntent = com.tencent.mm.model.c.Fw().abj(str1);
      if (com.tencent.mm.model.s.hI(paramIntent.field_verifyFlag)) {
        paramIntent = this.byx.vtz.getResources().getString(R.l.app_friend_card_biz);
      }
      for (;;)
      {
        paramIntent = paramIntent + str3;
        locala.bM(str2).WF(paramIntent).g(Boolean.valueOf(true)).DY(R.l.app_send).a(new d.1(this, str1, str2, bool)).few.show();
        return;
        if (ad.aaU(str1)) {
          paramIntent = SelectConversationUI.d(ae.getContext(), paramIntent);
        } else {
          paramIntent = this.byx.vtz.getResources().getString(R.l.app_friend_card_personal);
        }
      }
    } while ((paramInt2 != -1) || (paramIntent == null));
    String str1 = paramIntent.getStringExtra("be_send_card_name");
    String str2 = paramIntent.getStringExtra("received_card_name");
    String str3 = paramIntent.getStringExtra("custom_send_text");
    boolean bool = paramIntent.getBooleanExtra("Is_Chatroom", false);
    paramIntent = new Intent(this.byx.vtz.getContext(), ChattingUI.class);
    paramIntent.putExtra("Chat_User", str2);
    paramIntent.putExtra("send_card_username", str1);
    paramIntent.putExtra("send_card_edittext", str3);
    paramIntent.putExtra("Is_Chatroom", bool);
    this.byx.vtz.startActivity(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.d
 * JD-Core Version:    0.7.0.1
 */