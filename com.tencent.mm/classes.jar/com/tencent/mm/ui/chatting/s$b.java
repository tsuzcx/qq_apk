package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.h;
import com.tencent.mm.al.a.k;
import com.tencent.mm.al.af;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.chatting.c.b.y;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.contact.e;

public class s$b
  implements View.OnClickListener
{
  private a HNS;
  
  public s$b(a parama)
  {
    this.HNS = parama;
  }
  
  public void a(Intent paramIntent, com.tencent.mm.ui.chatting.viewitems.bj parambj) {}
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    AppMethodBeat.i(34590);
    Object localObject1 = (com.tencent.mm.ui.chatting.viewitems.bj)paramView.getTag();
    if (localObject1 == null)
    {
      AppMethodBeat.o(34590);
      return;
    }
    paramView = ((com.tencent.mm.ui.chatting.viewitems.bj)localObject1).userName;
    if ((paramView == null) || (paramView.equals("")))
    {
      AppMethodBeat.o(34590);
      return;
    }
    if (((y)this.HNS.bf(y.class)).fnV())
    {
      localObject1 = this.HNS.HZF.getContext();
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("Contact_User", paramView);
      ((Intent)localObject2).putExtra("Contact_Encryptusername", true);
      ((Intent)localObject2).putExtra("Contact_IsLBSFriend", true);
      ((Intent)localObject2).putExtra("Contact_IsLbsChattingProfile", true);
      com.tencent.mm.br.d.b((Context)localObject1, "profile", ".ui.ContactInfoUI", (Intent)localObject2);
      AppMethodBeat.o(34590);
      return;
    }
    Object localObject2 = (com.tencent.mm.ui.chatting.c.b.d)this.HNS.bf(com.tencent.mm.ui.chatting.c.b.d.class);
    if (((com.tencent.mm.ui.chatting.c.b.d)localObject2).fmo())
    {
      paramView = ((com.tencent.mm.ui.chatting.c.b.d)localObject2).fmm().Bn(paramView);
      if (paramView != null)
      {
        if ((paramView == null) || (bs.isNullOrNil(paramView.field_profileUrl)))
        {
          if (paramView == null) {}
          for (bool = true;; bool = false)
          {
            ac.w("MicroMsg.ChattingListAvatarListener", "onClick userInfo == null:%s", new Object[] { Boolean.valueOf(bool) });
            AppMethodBeat.o(34590);
            return;
          }
        }
        ac.i("MicroMsg.ChattingListAvatarListener", "onClick Url:%s", new Object[] { paramView.field_profileUrl });
        af.aDe().bh(paramView.field_userId, paramView.field_brandUserName);
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", paramView.field_profileUrl);
        ((Intent)localObject1).putExtra("useJs", true);
        com.tencent.mm.br.d.b(this.HNS.HZF.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
      }
      AppMethodBeat.o(34590);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", paramView);
    a(localIntent, (com.tencent.mm.ui.chatting.viewitems.bj)localObject1);
    az.ayM();
    Object localObject3 = com.tencent.mm.model.c.awB().aNt(paramView);
    if ((localObject3 != null) && ((int)((b)localObject3).fLJ > 0) && (b.ln(((av)localObject3).field_type))) {
      e.a(localIntent, paramView);
    }
    if (w.sQ(this.HNS.getTalkerUserName()))
    {
      az.ayM();
      localObject3 = com.tencent.mm.model.c.awK().xO(this.HNS.getTalkerUserName());
      localIntent.putExtra("Contact_RoomNickname", ((x)localObject3).wk(paramView));
      localIntent.putExtra("Contact_Scene", 14);
      localIntent.putExtra("Contact_ChatRoomId", this.HNS.getTalkerUserName());
      localIntent.putExtra("room_name", this.HNS.getTalkerUserName());
      if (((x)localObject3).field_roomowner == null) {
        localIntent.putExtra("Is_RoomOwner", bool);
      }
    }
    else if (((com.tencent.mm.ui.chatting.viewitems.bj)localObject1).dpq != null)
    {
      switch (((com.tencent.mm.ui.chatting.viewitems.bj)localObject1).dpq.getType())
      {
      }
    }
    for (;;)
    {
      if (!((com.tencent.mm.ui.chatting.c.b.d)localObject2).a(this.HNS, (com.tencent.mm.ui.chatting.viewitems.bj)localObject1)) {
        break label603;
      }
      AppMethodBeat.o(34590);
      return;
      bool = ((x)localObject3).field_roomowner.equals(u.axw());
      break;
      localIntent.putExtra("Contact_Scene", 34);
      localIntent.putExtra("Contact_IsLBSFriend", true);
    }
    label603:
    if (this.HNS.foQ()) {}
    for (int i = 3;; i = 2)
    {
      localIntent.putExtra("CONTACT_INFO_UI_SOURCE", i);
      com.tencent.mm.br.d.b(this.HNS.HZF.getContext(), "profile", ".ui.ContactInfoUI", localIntent, 213);
      AppMethodBeat.o(34590);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s.b
 * JD-Core Version:    0.7.0.1
 */