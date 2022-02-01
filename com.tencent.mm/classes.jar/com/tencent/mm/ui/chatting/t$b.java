package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.k;
import com.tencent.mm.al.ag;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.finder.report.b.d;
import com.tencent.mm.plugin.finder.view.l;
import com.tencent.mm.plugin.finder.view.l.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.i.a.f;
import com.tencent.mm.plugin.i.a.p;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.chatting.d.b.i;
import com.tencent.mm.ui.chatting.viewitems.bk;
import com.tencent.mm.ui.contact.e;

public class t$b
  implements View.OnClickListener
{
  private com.tencent.mm.ui.chatting.e.a JWz;
  
  public t$b(com.tencent.mm.ui.chatting.e.a parama)
  {
    this.JWz = parama;
  }
  
  public void a(Intent paramIntent, bk parambk) {}
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    AppMethodBeat.i(34590);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
    Object localObject2 = (bk)paramView.getTag();
    if (localObject2 == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(34590);
      return;
    }
    localObject1 = ((bk)localObject2).userName;
    if ((localObject1 == null) || (((String)localObject1).equals("")))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(34590);
      return;
    }
    if (((aa)this.JWz.bh(aa.class)).fIw())
    {
      paramView = this.JWz.Kkd.getContext();
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("Contact_User", (String)localObject1);
      ((Intent)localObject2).putExtra("Contact_Encryptusername", true);
      ((Intent)localObject2).putExtra("Contact_IsLBSFriend", true);
      ((Intent)localObject2).putExtra("Contact_IsLbsChattingProfile", true);
      com.tencent.mm.br.d.b(paramView, "profile", ".ui.ContactInfoUI", (Intent)localObject2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(34590);
      return;
    }
    if (((com.tencent.mm.ui.chatting.d.b.h)this.JWz.bh(com.tencent.mm.ui.chatting.d.b.h.class)).fHo())
    {
      paramView = "";
      if (((com.tencent.mm.ui.chatting.d.b.h)this.JWz.bh(com.tencent.mm.ui.chatting.d.b.h.class)).aUu((String)localObject1)) {
        paramView = (View)localObject1;
      }
      for (;;)
      {
        localObject3 = com.tencent.mm.plugin.finder.report.b.sxb;
        localObject3 = com.tencent.mm.plugin.finder.report.b.cFf();
        ((b.d)localObject3).sxu += 1L;
        if (!((com.tencent.mm.ui.chatting.d.b.h)this.JWz.bh(com.tencent.mm.ui.chatting.d.b.h.class)).aUu(paramView)) {
          break;
        }
        if (((String)localObject1).equals(v.aAK())) {
          paramView = (View)localObject1;
        }
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("finder_username", paramView);
        ((Intent)localObject2).putExtra("key_enter_profile_type", 10);
        paramView = FinderReporterUIC.tnG;
        FinderReporterUIC.a.a(this.JWz.Kkd.getContext(), (Intent)localObject2, 0L, 10, false);
        ((Intent)localObject2).putExtra("KEY_FINDER_SELF_FLAG", ((String)localObject1).equals(v.aAK()));
        ((t)g.ad(t.class)).enterFinderProfileUI(this.JWz.Kkd.getContext(), (Intent)localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(34590);
        return;
        if (an.aji((String)localObject1)) {
          paramView = ((p)g.ab(p.class)).ajf((String)localObject1);
        }
      }
      if (((com.tencent.mm.ui.chatting.d.b.h)this.JWz.bh(com.tencent.mm.ui.chatting.d.b.h.class)).aXD(paramView))
      {
        ((p)g.ab(p.class)).ajg(paramView);
        localObject1 = new Intent();
        paramView = ((f)g.ab(f.class)).aiY(paramView);
        localObject2 = l.thN;
        l.a.a(paramView, (Intent)localObject1);
        paramView = l.thN;
        l.a.X(this.JWz.Kkd.getContext(), (Intent)localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(34590);
        return;
      }
    }
    if (((i)this.JWz.bh(i.class)).fHq())
    {
      ((com.tencent.mm.plugin.gamelife.c)g.ad(com.tencent.mm.plugin.gamelife.c.class)).enterGameLifeProfileUI(this.JWz.Kkd.getContext(), (String)localObject1, com.tencent.mm.plugin.gamelife.a.uHM);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(34590);
      return;
    }
    paramView = (com.tencent.mm.ui.chatting.d.b.d)this.JWz.bh(com.tencent.mm.ui.chatting.d.b.d.class);
    if (paramView.fGJ())
    {
      paramView = paramView.fGH().EO((String)localObject1);
      if (paramView != null)
      {
        if ((paramView == null) || (bu.isNullOrNil(paramView.field_profileUrl)))
        {
          if (paramView == null) {}
          for (bool = true;; bool = false)
          {
            ae.w("MicroMsg.ChattingListAvatarListener", "onClick userInfo == null:%s", new Object[] { Boolean.valueOf(bool) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(34590);
            return;
          }
        }
        ae.i("MicroMsg.ChattingListAvatarListener", "onClick Url:%s", new Object[] { paramView.field_profileUrl });
        ag.aGx().bi(paramView.field_userId, paramView.field_brandUserName);
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", paramView.field_profileUrl);
        ((Intent)localObject1).putExtra("useJs", true);
        com.tencent.mm.br.d.b(this.JWz.Kkd.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(34590);
      return;
    }
    Object localObject3 = new Intent();
    ((Intent)localObject3).putExtra("Contact_User", (String)localObject1);
    a((Intent)localObject3, (bk)localObject2);
    bc.aCg();
    Object localObject4 = com.tencent.mm.model.c.azF().BH((String)localObject1);
    if ((localObject4 != null) && ((int)((com.tencent.mm.contact.c)localObject4).ght > 0) && (com.tencent.mm.contact.c.lO(((aw)localObject4).field_type))) {
      e.a((Intent)localObject3, (String)localObject1);
    }
    if (x.wb(this.JWz.getTalkerUserName()))
    {
      bc.aCg();
      localObject4 = com.tencent.mm.model.c.azP().By(this.JWz.getTalkerUserName());
      ((Intent)localObject3).putExtra("Contact_RoomNickname", ((ac)localObject4).zP((String)localObject1));
      ((Intent)localObject3).putExtra("Contact_Scene", 14);
      ((Intent)localObject3).putExtra("Contact_ChatRoomId", this.JWz.getTalkerUserName());
      ((Intent)localObject3).putExtra("room_name", this.JWz.getTalkerUserName());
      if (((ac)localObject4).field_roomowner == null) {
        ((Intent)localObject3).putExtra("Is_RoomOwner", bool);
      }
    }
    else if (((bk)localObject2).dCi != null)
    {
      switch (((bk)localObject2).dCi.getType())
      {
      }
    }
    for (;;)
    {
      if (!paramView.a(this.JWz, (bk)localObject2)) {
        break label1139;
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(34590);
      return;
      bool = ((ac)localObject4).field_roomowner.equals(v.aAC());
      break;
      ((Intent)localObject3).putExtra("Contact_Scene", 34);
      ((Intent)localObject3).putExtra("Contact_IsLBSFriend", true);
    }
    label1139:
    if (this.JWz.fJC()) {}
    for (int i = 3;; i = 2)
    {
      ((Intent)localObject3).putExtra("CONTACT_INFO_UI_SOURCE", i);
      com.tencent.mm.br.d.b(this.JWz.Kkd.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject3, 213);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(34590);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.t.b
 * JD-Core Version:    0.7.0.1
 */