package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.f;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
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
import com.tencent.mm.ui.contact.ad;
import com.tencent.mm.ui.contact.u;
import com.tencent.mm.ui.transmit.SelectConversationUI;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(gRF=e.class)
public class d
  extends a
  implements e
{
  public final boolean bU(ca paramca)
  {
    AppMethodBeat.i(35130);
    if (paramca.gDl())
    {
      if (!this.dom.getTalkerUserName().equals("medianote"))
      {
        bg.aVF();
        com.tencent.mm.model.c.aSM().d(new f(paramca.field_talker, paramca.field_msgSvrId));
      }
      ak.bM(paramca);
      this.dom.BN(true);
      AppMethodBeat.o(35130);
      return true;
    }
    AppMethodBeat.o(35130);
    return false;
  }
  
  public final void gIk()
  {
    AppMethodBeat.i(35133);
    Object localObject2 = this.dom.Pwc.getContext().getIntent();
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
      str2 = ad.bnD((String)localObject1);
      localObject4 = o.Pl((String)localObject3);
      ((o.e)localObject4).toUser = ((String)localObject3);
      ((o.e)localObject4).content = str2;
      if (!as.bjp((String)localObject1)) {
        break label168;
      }
    }
    label168:
    for (int i = 66;; i = 42)
    {
      localObject1 = ((o.e)localObject4).tD(i);
      ((o.e)localObject1).cSx = 0;
      ((o.e)localObject1).jdR = 4;
      ((o.e)localObject1).bdQ().execute();
      if (localObject2 != null) {
        g.eir().iF((String)localObject2, str1);
      }
      AppMethodBeat.o(35133);
      return;
    }
    label174:
    Object localObject3 = Util.stringsToList(Util.nullAs(str1, "").split(","));
    String str2 = ad.bnD((String)localObject1);
    i = 0;
    label200:
    o.e locale;
    if (i < ((List)localObject3).size())
    {
      localObject4 = (String)((List)localObject3).get(i);
      locale = o.Pl((String)localObject4);
      locale.toUser = ((String)localObject4);
      locale.content = str2;
      if (!as.bjp((String)localObject1)) {
        break label292;
      }
    }
    label292:
    for (int j = 66;; j = 42)
    {
      localObject4 = locale.tD(j);
      ((o.e)localObject4).cSx = 0;
      ((o.e)localObject4).jdR = 4;
      ((o.e)localObject4).bdQ().execute();
      i += 1;
      break label200;
      break;
    }
  }
  
  public final void gPg()
  {
    AppMethodBeat.i(35131);
    Intent localIntent = new Intent(this.dom.Pwc.getContext(), SelectContactUI.class);
    if ((as.bjp(this.dom.getTalkerUserName())) || (ab.Iy(this.dom.getTalkerUserName()))) {
      localIntent.putExtra("list_attr", u.Q(new int[] { u.PWW, 1, 16777216 }));
    }
    for (;;)
    {
      localIntent.putExtra("list_type", 4);
      localIntent.putExtra("received_card_name", this.dom.getTalkerUserName());
      localIntent.putExtra("block_contact", this.dom.getTalkerUserName());
      localIntent.putExtra("Add_SendCard", true);
      localIntent.putExtra("titile", this.dom.Pwc.getMMResources().getString(2131755268));
      this.dom.Pwc.startActivityForResult(localIntent, 223);
      AppMethodBeat.o(35131);
      return;
      localIntent.putExtra("list_attr", u.Q(new int[] { u.PWW, 1, 2048, 16777216 }));
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
        if (this.dom.gRM()) {
          as.bjp((String)localObject);
        }
        str2 = aa.getDisplayName((String)localObject);
        str1 = paramIntent.getStringExtra("received_card_name");
        bool = paramIntent.getBooleanExtra("Is_Chatroom", false);
        locala = new o.a(this.dom.Pwc.getContext());
        com.tencent.mm.aj.c.a((String)localObject, true, -1, null);
        bg.aVF();
        paramIntent = com.tencent.mm.model.c.aSN().bjJ((String)localObject);
        if (!ab.rR(paramIntent.field_verifyFlag)) {
          break label241;
        }
        paramIntent = this.dom.Pwc.getResources().getString(2131755863);
      }
      for (;;)
      {
        paramIntent = paramIntent + str2;
        {
          public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
          {
            AppMethodBeat.i(35129);
            d.this.dom.hideVKB();
            if (paramAnonymousBoolean)
            {
              g.eir().s(this.gtz, str1, bool);
              g.eir().iF(paramAnonymousString, str1);
            }
            AppMethodBeat.o(35129);
          }
        }.show();
        AppMethodBeat.o(35132);
        return;
        label241:
        if (as.bjp((String)localObject)) {
          paramIntent = SelectConversationUI.c(MMApplicationContext.getContext(), paramIntent);
        } else {
          paramIntent = this.dom.Pwc.getResources().getString(2131755864);
        }
      }
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        localObject = paramIntent.getStringExtra("be_send_card_name");
        str1 = paramIntent.getStringExtra("received_card_name");
        str2 = paramIntent.getStringExtra("custom_send_text");
        bool = paramIntent.getBooleanExtra("Is_Chatroom", false);
        paramIntent = new Intent(this.dom.Pwc.getContext(), ChattingUI.class);
        paramIntent.putExtra("Chat_User", str1);
        paramIntent.putExtra("send_card_username", (String)localObject);
        paramIntent.putExtra("send_card_edittext", str2);
        paramIntent.putExtra("Is_Chatroom", bool);
        localObject = this.dom.Pwc;
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramIntent.axQ(), "com/tencent/mm/ui/chatting/component/CardComponent", "dealWithRequestCode", "(IILandroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MMFragment)localObject).startActivity((Intent)paramIntent.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/chatting/component/CardComponent", "dealWithRequestCode", "(IILandroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.d
 * JD-Core Version:    0.7.0.1
 */