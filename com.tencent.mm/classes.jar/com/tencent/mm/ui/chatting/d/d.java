package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.f;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.d.b.e;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.ad;
import com.tencent.mm.ui.contact.u;
import com.tencent.mm.ui.transmit.SelectConversationUI;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(fFo=e.class)
public class d
  extends a
  implements e
{
  public final boolean bF(bu parambu)
  {
    AppMethodBeat.i(35130);
    if (parambu.frE())
    {
      if (!this.cWM.getTalkerUserName().equals("medianote"))
      {
        ba.aBQ();
        com.tencent.mm.model.c.azo().c(new f(parambu.field_talker, parambu.field_msgSvrId));
      }
      com.tencent.mm.ui.chatting.aj.by(parambu);
      this.cWM.xR(true);
      AppMethodBeat.o(35130);
      return true;
    }
    AppMethodBeat.o(35130);
    return false;
  }
  
  public final void fCY()
  {
    AppMethodBeat.i(35131);
    Intent localIntent = new Intent(this.cWM.JOR.getContext(), SelectContactUI.class);
    if ((am.aSQ(this.cWM.getTalkerUserName())) || (w.zl(this.cWM.getTalkerUserName()))) {
      localIntent.putExtra("list_attr", u.I(new int[] { u.KnB, 1, 16777216 }));
    }
    for (;;)
    {
      localIntent.putExtra("list_type", 4);
      localIntent.putExtra("received_card_name", this.cWM.getTalkerUserName());
      localIntent.putExtra("block_contact", this.cWM.getTalkerUserName());
      localIntent.putExtra("Add_SendCard", true);
      localIntent.putExtra("titile", this.cWM.JOR.getMMResources().getString(2131755234));
      this.cWM.JOR.startActivityForResult(localIntent, 223);
      AppMethodBeat.o(35131);
      return;
      localIntent.putExtra("list_attr", u.I(new int[] { u.KnB, 1, 2048, 16777216 }));
    }
  }
  
  public final void fws()
  {
    AppMethodBeat.i(35133);
    Object localObject1 = this.cWM.JOR.getContext().getIntent();
    String str1 = ((Intent)localObject1).getStringExtra("Chat_User");
    String str2 = ((Intent)localObject1).getStringExtra("send_card_username");
    Object localObject3;
    if (!bt.isNullOrNil(str2))
    {
      boolean bool = ((Intent)localObject1).getBooleanExtra("Is_Chatroom", false);
      localObject1 = ((Intent)localObject1).getStringExtra("send_card_edittext");
      if (!bool) {
        break label172;
      }
      localObject2 = bt.bI(str1, "");
      str3 = ad.aWZ(str2);
      localObject3 = o.FX((String)localObject2);
      ((o.e)localObject3).toUser = ((String)localObject2);
      ((o.e)localObject3).content = str3;
      if (!am.aSQ(str2)) {
        break label166;
      }
    }
    label166:
    for (int i = 66;; i = 42)
    {
      ((o.e)localObject3).type = i;
      ((o.e)localObject3).dDp = 0;
      ((o.e)localObject3).igc = 4;
      ((o.e)localObject3).aJv().execute();
      if (localObject1 != null) {
        g.dlD().hP((String)localObject1, str1);
      }
      AppMethodBeat.o(35133);
      return;
    }
    label172:
    Object localObject2 = bt.U(bt.bI(str1, "").split(","));
    String str3 = ad.aWZ(str2);
    i = 0;
    label199:
    o.e locale;
    if (i < ((List)localObject2).size())
    {
      localObject3 = (String)((List)localObject2).get(i);
      locale = o.FX((String)localObject3);
      locale.toUser = ((String)localObject3);
      locale.content = str3;
      if (!am.aSQ(str2)) {
        break label289;
      }
    }
    label289:
    for (int j = 66;; j = 42)
    {
      locale.type = j;
      locale.dDp = 0;
      locale.igc = 4;
      locale.aJv().execute();
      i += 1;
      break label199;
      break;
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
        if (this.cWM.fFv()) {
          am.aSQ((String)localObject);
        }
        str2 = v.zf((String)localObject);
        str1 = paramIntent.getStringExtra("received_card_name");
        bool = paramIntent.getBooleanExtra("Is_Chatroom", false);
        locala = new o.a(this.cWM.JOR.getContext());
        com.tencent.mm.ak.c.a((String)localObject, true, -1, null);
        ba.aBQ();
        paramIntent = com.tencent.mm.model.c.azp().aTj((String)localObject);
        if (!w.on(paramIntent.field_verifyFlag)) {
          break label241;
        }
        paramIntent = this.cWM.JOR.getResources().getString(2131755783);
      }
      for (;;)
      {
        paramIntent = paramIntent + str2;
        {
          public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
          {
            AppMethodBeat.i(35129);
            d.this.cWM.hideVKB();
            if (paramAnonymousBoolean)
            {
              g.dlD().q(this.fNT, str1, bool);
              g.dlD().hP(paramAnonymousString, str1);
            }
            AppMethodBeat.o(35129);
          }
        }.show();
        AppMethodBeat.o(35132);
        return;
        label241:
        if (am.aSQ((String)localObject)) {
          paramIntent = SelectConversationUI.c(com.tencent.mm.sdk.platformtools.aj.getContext(), paramIntent);
        } else {
          paramIntent = this.cWM.JOR.getResources().getString(2131755784);
        }
      }
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        localObject = paramIntent.getStringExtra("be_send_card_name");
        str1 = paramIntent.getStringExtra("received_card_name");
        str2 = paramIntent.getStringExtra("custom_send_text");
        bool = paramIntent.getBooleanExtra("Is_Chatroom", false);
        paramIntent = new Intent(this.cWM.JOR.getContext(), ChattingUI.class);
        paramIntent.putExtra("Chat_User", str1);
        paramIntent.putExtra("send_card_username", (String)localObject);
        paramIntent.putExtra("send_card_edittext", str2);
        paramIntent.putExtra("Is_Chatroom", bool);
        localObject = this.cWM.JOR;
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramIntent.ahp(), "com/tencent/mm/ui/chatting/component/CardComponent", "dealWithRequestCode", "(IILandroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MMFragment)localObject).startActivity((Intent)paramIntent.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/chatting/component/CardComponent", "dealWithRequestCode", "(IILandroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.d
 * JD-Core Version:    0.7.0.1
 */