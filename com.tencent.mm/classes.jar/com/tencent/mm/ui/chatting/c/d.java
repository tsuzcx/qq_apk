package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.ba.f;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.a.j;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.aj;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.ad;
import com.tencent.mm.ui.contact.u;
import com.tencent.mm.ui.transmit.SelectConversationUI;
import java.util.List;

@com.tencent.mm.ui.chatting.c.a.a(foJ=com.tencent.mm.ui.chatting.c.b.e.class)
public class d
  extends a
  implements com.tencent.mm.ui.chatting.c.b.e
{
  public final boolean bz(bo parambo)
  {
    AppMethodBeat.i(35130);
    if (parambo.fbB())
    {
      if (!this.cLy.getTalkerUserName().equals("medianote"))
      {
        az.ayM();
        com.tencent.mm.model.c.awA().c(new f(parambo.field_talker, parambo.field_msgSvrId));
      }
      aj.bu(parambo);
      this.cLy.xg(true);
      AppMethodBeat.o(35130);
      return true;
    }
    AppMethodBeat.o(35130);
    return false;
  }
  
  public final void fgg()
  {
    AppMethodBeat.i(35133);
    Object localObject2 = this.cLy.HZF.getContext().getIntent();
    String str1 = ((Intent)localObject2).getStringExtra("Chat_User");
    Object localObject1 = ((Intent)localObject2).getStringExtra("send_card_username");
    if (!bs.isNullOrNil((String)localObject1))
    {
      boolean bool = ((Intent)localObject2).getBooleanExtra("Is_Chatroom", false);
      localObject2 = ((Intent)localObject2).getStringExtra("send_card_edittext");
      if (!bool) {
        break label149;
      }
      localObject3 = bs.bG(str1, "");
      str2 = ad.aRb((String)localObject1);
      if (!com.tencent.mm.storage.ai.aNc((String)localObject1)) {
        break label143;
      }
    }
    label143:
    for (int i = 66;; i = 42)
    {
      localObject1 = new com.tencent.mm.modelmulti.i((String)localObject3, str2, i, 0);
      az.agi().a((n)localObject1, 0);
      if (localObject2 != null) {
        j.dck().hF((String)localObject2, str1);
      }
      AppMethodBeat.o(35133);
      return;
    }
    label149:
    Object localObject3 = bs.S(bs.bG(str1, "").split(","));
    String str2 = ad.aRb((String)localObject1);
    i = 0;
    label175:
    Object localObject4;
    if (i < ((List)localObject3).size())
    {
      localObject4 = (String)((List)localObject3).get(i);
      if (!com.tencent.mm.storage.ai.aNc((String)localObject1)) {
        break label242;
      }
    }
    label242:
    for (int j = 66;; j = 42)
    {
      localObject4 = new com.tencent.mm.modelmulti.i((String)localObject4, str2, j, 0);
      az.agi().a((n)localObject4, 0);
      i += 1;
      break label175;
      break;
    }
  }
  
  public final void fmF()
  {
    AppMethodBeat.i(35131);
    Intent localIntent = new Intent(this.cLy.HZF.getContext(), SelectContactUI.class);
    if ((com.tencent.mm.storage.ai.aNc(this.cLy.getTalkerUserName())) || (w.wq(this.cLy.getTalkerUserName()))) {
      localIntent.putExtra("list_attr", u.I(new int[] { u.IwT, 1, 16777216 }));
    }
    for (;;)
    {
      localIntent.putExtra("list_type", 4);
      localIntent.putExtra("received_card_name", this.cLy.getTalkerUserName());
      localIntent.putExtra("block_contact", this.cLy.getTalkerUserName());
      localIntent.putExtra("Add_SendCard", true);
      localIntent.putExtra("titile", this.cLy.HZF.getMMResources().getString(2131755234));
      this.cLy.HZF.startActivityForResult(localIntent, 223);
      AppMethodBeat.o(35131);
      return;
      localIntent.putExtra("list_attr", u.I(new int[] { u.IwT, 1, 2048, 16777216 }));
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
        if (this.cLy.foQ()) {
          com.tencent.mm.storage.ai.aNc((String)localObject);
        }
        str2 = v.wk((String)localObject);
        str1 = paramIntent.getStringExtra("received_card_name");
        bool = paramIntent.getBooleanExtra("Is_Chatroom", false);
        locala = new o.a(this.cLy.HZF.getContext());
        com.tencent.mm.aj.c.a((String)localObject, true, -1, null);
        az.ayM();
        paramIntent = com.tencent.mm.model.c.awB().aNr((String)localObject);
        if (!w.nN(paramIntent.field_verifyFlag)) {
          break label241;
        }
        paramIntent = this.cLy.HZF.getResources().getString(2131755783);
      }
      for (;;)
      {
        paramIntent = paramIntent + str2;
        {
          public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
          {
            AppMethodBeat.i(35129);
            d.this.cLy.hideVKB();
            if (paramAnonymousBoolean)
            {
              j.dck().q(this.hyc, str1, bool);
              j.dck().hF(paramAnonymousString, str1);
            }
            AppMethodBeat.o(35129);
          }
        }.show();
        AppMethodBeat.o(35132);
        return;
        label241:
        if (com.tencent.mm.storage.ai.aNc((String)localObject)) {
          paramIntent = SelectConversationUI.c(com.tencent.mm.sdk.platformtools.ai.getContext(), paramIntent);
        } else {
          paramIntent = this.cLy.HZF.getResources().getString(2131755784);
        }
      }
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        localObject = paramIntent.getStringExtra("be_send_card_name");
        str1 = paramIntent.getStringExtra("received_card_name");
        str2 = paramIntent.getStringExtra("custom_send_text");
        bool = paramIntent.getBooleanExtra("Is_Chatroom", false);
        paramIntent = new Intent(this.cLy.HZF.getContext(), ChattingUI.class);
        paramIntent.putExtra("Chat_User", str1);
        paramIntent.putExtra("send_card_username", (String)localObject);
        paramIntent.putExtra("send_card_edittext", str2);
        paramIntent.putExtra("Is_Chatroom", bool);
        localObject = this.cLy.HZF;
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramIntent.aeD(), "com/tencent/mm/ui/chatting/component/CardComponent", "dealWithRequestCode", "(IILandroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MMFragment)localObject).startActivity((Intent)paramIntent.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/chatting/component/CardComponent", "dealWithRequestCode", "(IILandroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.d
 * JD-Core Version:    0.7.0.1
 */