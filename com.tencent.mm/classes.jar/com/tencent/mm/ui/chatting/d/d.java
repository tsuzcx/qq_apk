package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.bd.f;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.ak;
import com.tencent.mm.ui.chatting.d.b.e;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.af;
import com.tencent.mm.ui.contact.w;
import com.tencent.mm.ui.transmit.SelectConversationUI;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(hRc=e.class)
public class d
  extends a
  implements e
{
  public final boolean co(ca paramca)
  {
    AppMethodBeat.i(35130);
    if (paramca.hzy())
    {
      if (!this.fgR.getTalkerUserName().equals("medianote"))
      {
        bh.beI();
        c.bbK().d(new f(paramca.field_talker, paramca.field_msgSvrId));
      }
      ak.cg(paramca);
      this.fgR.Gi(true);
      AppMethodBeat.o(35130);
      return true;
    }
    AppMethodBeat.o(35130);
    return false;
  }
  
  public final void hGU()
  {
    AppMethodBeat.i(35133);
    Object localObject2 = this.fgR.WQv.getContext().getIntent();
    String str1 = ((Intent)localObject2).getStringExtra("Chat_User");
    Object localObject1 = ((Intent)localObject2).getStringExtra("send_card_username");
    Object localObject4;
    if (!Util.isNullOrNil((String)localObject1))
    {
      boolean bool = ((Intent)localObject2).getBooleanExtra("Is_Chatroom", false);
      localObject2 = ((Intent)localObject2).getStringExtra("send_card_edittext");
      if (!bool) {
        break label174;
      }
      localObject3 = Util.nullAs(str1, "");
      str2 = af.bAj((String)localObject1);
      localObject4 = o.WI((String)localObject3);
      ((o.e)localObject4).toUser = ((String)localObject3);
      ((o.e)localObject4).content = str2;
      if (!as.bvK((String)localObject1)) {
        break label168;
      }
    }
    label168:
    for (int i = 66;; i = 42)
    {
      localObject1 = ((o.e)localObject4).wD(i);
      ((o.e)localObject1).cUP = 0;
      ((o.e)localObject1).lUq = 4;
      ((o.e)localObject1).bnl().aEv();
      if (localObject2 != null) {
        g.eRW().iQ((String)localObject2, str1);
      }
      AppMethodBeat.o(35133);
      return;
    }
    label174:
    Object localObject3 = Util.stringsToList(Util.nullAs(str1, "").split(","));
    String str2 = af.bAj((String)localObject1);
    i = 0;
    label200:
    o.e locale;
    if (i < ((List)localObject3).size())
    {
      localObject4 = (String)((List)localObject3).get(i);
      locale = o.WI((String)localObject4);
      locale.toUser = ((String)localObject4);
      locale.content = str2;
      if (!as.bvK((String)localObject1)) {
        break label292;
      }
    }
    label292:
    for (int j = 66;; j = 42)
    {
      localObject4 = locale.wD(j);
      ((o.e)localObject4).cUP = 0;
      ((o.e)localObject4).lUq = 4;
      ((o.e)localObject4).bnl().aEv();
      i += 1;
      break label200;
      break;
    }
  }
  
  public final void hOw()
  {
    AppMethodBeat.i(35131);
    Intent localIntent = new Intent(this.fgR.WQv.getContext(), SelectContactUI.class);
    if ((as.bvK(this.fgR.getTalkerUserName())) || (ab.PQ(this.fgR.getTalkerUserName()))) {
      localIntent.putExtra("list_attr", w.P(new int[] { w.XtO, 1, 16777216 }));
    }
    for (;;)
    {
      localIntent.putExtra("list_type", 4);
      localIntent.putExtra("received_card_name", this.fgR.getTalkerUserName());
      localIntent.putExtra("block_contact", this.fgR.getTalkerUserName());
      localIntent.putExtra("Add_SendCard", true);
      localIntent.putExtra("titile", this.fgR.WQv.getMMResources().getString(R.l.address_title_select_contact));
      localIntent.putExtra("scene", 16);
      this.fgR.WQv.startActivityForResult(localIntent, 223);
      AppMethodBeat.o(35131);
      return;
      localIntent.putExtra("list_attr", w.P(new int[] { w.XtO, 1, 2048, 16777216 }));
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(35132);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(35132);
      return;
      Object localObject;
      String str2;
      final String str1;
      final boolean bool;
      o.a locala;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        localObject = paramIntent.getStringExtra("be_send_card_name");
        if (this.fgR.hRi()) {
          as.bvK((String)localObject);
        }
        str2 = aa.PJ((String)localObject);
        str1 = paramIntent.getStringExtra("received_card_name");
        bool = paramIntent.getBooleanExtra("Is_Chatroom", false);
        locala = new o.a(this.fgR.WQv.getContext());
        com.tencent.mm.am.d.a((String)localObject, true, -1, null);
        bh.beI();
        paramIntent = c.bbL().bwg((String)localObject);
        if (!ab.uL(paramIntent.field_verifyFlag)) {
          break label241;
        }
        paramIntent = this.fgR.WQv.getResources().getString(R.l.app_friend_card_biz);
      }
      for (;;)
      {
        paramIntent = paramIntent + str2;
        {
          public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
          {
            AppMethodBeat.i(35129);
            d.this.fgR.hideVKB();
            if (paramAnonymousBoolean)
            {
              g.eRW().u(this.iXL, str1, bool);
              g.eRW().iQ(paramAnonymousString, str1);
            }
            AppMethodBeat.o(35129);
          }
        }.show();
        AppMethodBeat.o(35132);
        return;
        label241:
        if (as.bvK((String)localObject)) {
          paramIntent = SelectConversationUI.c(MMApplicationContext.getContext(), paramIntent);
        } else {
          paramIntent = this.fgR.WQv.getResources().getString(R.l.app_friend_card_personal);
        }
      }
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        localObject = paramIntent.getStringExtra("be_send_card_name");
        str1 = paramIntent.getStringExtra("received_card_name");
        str2 = paramIntent.getStringExtra("custom_send_text");
        bool = paramIntent.getBooleanExtra("Is_Chatroom", false);
        paramIntent = new Intent(this.fgR.WQv.getContext(), ChattingUI.class);
        paramIntent.putExtra("Chat_User", str1);
        paramIntent.putExtra("send_card_username", (String)localObject);
        paramIntent.putExtra("send_card_edittext", str2);
        paramIntent.putExtra("Is_Chatroom", bool);
        localObject = this.fgR.WQv;
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.b(localObject, paramIntent.aFh(), "com/tencent/mm/ui/chatting/component/CardComponent", "dealWithRequestCode", "(IILandroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MMFragment)localObject).startActivity((Intent)paramIntent.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/ui/chatting/component/CardComponent", "dealWithRequestCode", "(IILandroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.d
 * JD-Core Version:    0.7.0.1
 */