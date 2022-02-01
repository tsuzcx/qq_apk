package com.tencent.mm.ui.chatting.component;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelmulti.t;
import com.tencent.mm.modelmulti.t.b;
import com.tencent.mm.modelmulti.t.e;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.an;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.ak;
import com.tencent.mm.ui.contact.select.MvvmSelectContactUI;
import com.tencent.mm.ui.contact.w;
import com.tencent.mm.ui.transmit.SelectConversationUI;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.util.b.a;
import java.util.List;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=com.tencent.mm.ui.chatting.component.api.f.class)
public class d
  extends a
  implements com.tencent.mm.ui.chatting.component.api.f
{
  public final boolean cK(cc paramcc)
  {
    AppMethodBeat.i(35130);
    if (paramcc.jbB())
    {
      if (!this.hlc.getTalkerUserName().equals("medianote"))
      {
        bh.bCz();
        com.tencent.mm.model.c.bzz().d(new com.tencent.mm.ay.f(paramcc.field_talker, paramcc.field_msgSvrId));
      }
      an.cu(paramcc);
      this.hlc.jpK();
      AppMethodBeat.o(35130);
      return true;
    }
    AppMethodBeat.o(35130);
    return false;
  }
  
  public final void jjf()
  {
    AppMethodBeat.i(35133);
    Object localObject2 = this.hlc.aezO.getContext().getIntent();
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
      str2 = ak.bCc((String)localObject1);
      localObject4 = t.OH((String)localObject3);
      ((t.e)localObject4).toUser = ((String)localObject3);
      ((t.e)localObject4).content = str2;
      if (!au.bwO((String)localObject1)) {
        break label168;
      }
    }
    label168:
    for (int i = 66;; i = 42)
    {
      localObject1 = ((t.e)localObject4).wF(i);
      ((t.e)localObject1).eQp = 0;
      ((t.e)localObject1).oNj = 4;
      ((t.e)localObject1).bKW().aXz();
      if (localObject2 != null) {
        g.gaI().ke((String)localObject2, str1);
      }
      AppMethodBeat.o(35133);
      return;
    }
    label174:
    Object localObject3 = Util.stringsToList(Util.nullAs(str1, "").split(","));
    String str2 = ak.bCc((String)localObject1);
    i = 0;
    label200:
    t.e locale;
    if (i < ((List)localObject3).size())
    {
      localObject4 = (String)((List)localObject3).get(i);
      locale = t.OH((String)localObject4);
      locale.toUser = ((String)localObject4);
      locale.content = str2;
      if (!au.bwO((String)localObject1)) {
        break label292;
      }
    }
    label292:
    for (int j = 66;; j = 42)
    {
      localObject4 = locale.wF(j);
      ((t.e)localObject4).eQp = 0;
      ((t.e)localObject4).oNj = 4;
      ((t.e)localObject4).bKW().aXz();
      i += 1;
      break label200;
      break;
    }
  }
  
  public final void jro()
  {
    AppMethodBeat.i(35131);
    Intent localIntent;
    if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zpV, b.a.agrV, 0) == 1)
    {
      localIntent = new Intent(this.hlc.aezO.getContext(), MvvmSelectContactUI.class);
      if ((!au.bwO(this.hlc.getTalkerUserName())) && (!au.bwF(this.hlc.getTalkerUserName()))) {
        break label231;
      }
      localIntent.putExtra("list_attr", w.R(new int[] { w.afft, 1, 16777216 }));
    }
    for (;;)
    {
      localIntent.putExtra("list_type", 4);
      localIntent.putExtra("received_card_name", this.hlc.getTalkerUserName());
      localIntent.putExtra("block_contact", this.hlc.getTalkerUserName());
      localIntent.putExtra("Add_SendCard", true);
      localIntent.putExtra("titile", this.hlc.aezO.getMMResources().getString(R.l.address_title_select_contact));
      localIntent.putExtra("scene", 16);
      this.hlc.aezO.startActivityForResult(localIntent, 223);
      AppMethodBeat.o(35131);
      return;
      localIntent = new Intent(this.hlc.aezO.getContext(), SelectContactUI.class);
      break;
      label231:
      localIntent.putExtra("list_attr", w.R(new int[] { w.afft, 1, 2048, 16777216 }));
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
        if (this.hlc.juG()) {
          au.bwO((String)localObject);
        }
        str2 = aa.getDisplayName((String)localObject);
        str1 = paramIntent.getStringExtra("received_card_name");
        bool = paramIntent.getBooleanExtra("Is_Chatroom", false);
        locala = new o.a(this.hlc.aezO.getContext());
        com.tencent.mm.modelavatar.d.a((String)localObject, true, -1, null);
        bh.bCz();
        paramIntent = com.tencent.mm.model.c.bzA().bxu((String)localObject);
        if (!ab.uY(paramIntent.field_verifyFlag)) {
          break label242;
        }
        paramIntent = this.hlc.aezO.getResources().getString(R.l.app_friend_card_biz);
      }
      for (;;)
      {
        paramIntent = paramIntent + str2;
        {
          public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
          {
            AppMethodBeat.i(35129);
            d.this.hlc.hideVKB();
            if (paramAnonymousBoolean)
            {
              g.gaI().B(this.lzH, str1, bool);
              g.gaI().ke(paramAnonymousString, str1);
            }
            AppMethodBeat.o(35129);
          }
        }.show();
        AppMethodBeat.o(35132);
        return;
        label242:
        if (au.bwO((String)localObject)) {
          paramIntent = SelectConversationUI.c(MMApplicationContext.getContext(), paramIntent);
        } else {
          paramIntent = this.hlc.aezO.getResources().getString(R.l.app_friend_card_personal);
        }
      }
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        localObject = paramIntent.getStringExtra("be_send_card_name");
        str1 = paramIntent.getStringExtra("received_card_name");
        str2 = paramIntent.getStringExtra("custom_send_text");
        bool = paramIntent.getBooleanExtra("Is_Chatroom", false);
        paramIntent = new Intent(this.hlc.aezO.getContext(), ChattingUI.class);
        paramIntent.putExtra("Chat_User", str1);
        paramIntent.putExtra("send_card_username", (String)localObject);
        paramIntent.putExtra("send_card_edittext", str2);
        paramIntent.putExtra("Is_Chatroom", bool);
        localObject = this.hlc.aezO;
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.b(localObject, paramIntent.aYi(), "com/tencent/mm/ui/chatting/component/CardComponent", "dealWithRequestCode", "(IILandroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MMFragment)localObject).startActivity((Intent)paramIntent.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/ui/chatting/component/CardComponent", "dealWithRequestCode", "(IILandroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.d
 * JD-Core Version:    0.7.0.1
 */