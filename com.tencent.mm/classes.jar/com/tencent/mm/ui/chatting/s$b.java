package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.ag;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.finder.report.b.d;
import com.tencent.mm.plugin.finder.view.k.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.i.a.f;
import com.tencent.mm.plugin.i.a.p;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.chatting.d.b.i;
import com.tencent.mm.ui.chatting.viewitems.bk;
import com.tencent.mm.ui.contact.e;

public class s$b
  implements View.OnClickListener
{
  private com.tencent.mm.ui.chatting.e.a JBI;
  
  public s$b(com.tencent.mm.ui.chatting.e.a parama)
  {
    this.JBI = parama;
  }
  
  public void a(Intent paramIntent, bk parambk) {}
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    AppMethodBeat.i(34590);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
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
    if (((aa)this.JBI.bh(aa.class)).fEs())
    {
      paramView = this.JBI.JOR.getContext();
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("Contact_User", (String)localObject1);
      ((Intent)localObject2).putExtra("Contact_Encryptusername", true);
      ((Intent)localObject2).putExtra("Contact_IsLBSFriend", true);
      ((Intent)localObject2).putExtra("Contact_IsLbsChattingProfile", true);
      com.tencent.mm.bs.d.b(paramView, "profile", ".ui.ContactInfoUI", (Intent)localObject2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(34590);
      return;
    }
    if (((com.tencent.mm.ui.chatting.d.b.h)this.JBI.bh(com.tencent.mm.ui.chatting.d.b.h.class)).fDl())
    {
      paramView = "";
      if (((com.tencent.mm.ui.chatting.d.b.h)this.JBI.bh(com.tencent.mm.ui.chatting.d.b.h.class)).aSU((String)localObject1)) {
        paramView = (View)localObject1;
      }
      for (;;)
      {
        localObject3 = com.tencent.mm.plugin.finder.report.b.snk;
        localObject3 = com.tencent.mm.plugin.finder.report.b.cDn();
        ((b.d)localObject3).snD += 1L;
        if (!((com.tencent.mm.ui.chatting.d.b.h)this.JBI.bh(com.tencent.mm.ui.chatting.d.b.h.class)).aSU(paramView)) {
          break;
        }
        if (((String)localObject1).equals(u.aAu())) {
          paramView = (View)localObject1;
        }
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("finder_username", paramView);
        paramView = FinderReporterUIC.tcM;
        FinderReporterUIC.a.a(this.JBI.JOR.getContext(), (Intent)localObject2, 0L, 10, false);
        ((Intent)localObject2).putExtra("KEY_FINDER_SELF_FLAG", ((String)localObject1).equals(u.aAu()));
        ((t)g.ad(t.class)).enterFinderProfileUI(this.JBI.JOR.getContext(), (Intent)localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(34590);
        return;
        if (am.ail((String)localObject1)) {
          paramView = ((p)g.ab(p.class)).aii((String)localObject1);
        }
      }
      if (((com.tencent.mm.ui.chatting.d.b.h)this.JBI.bh(com.tencent.mm.ui.chatting.d.b.h.class)).aWc(paramView))
      {
        ((p)g.ab(p.class)).aij(paramView);
        localObject1 = new Intent();
        paramView = ((f)g.ab(f.class)).aia(paramView);
        localObject2 = com.tencent.mm.plugin.finder.view.k.sWA;
        k.a.a(paramView, (Intent)localObject1);
        paramView = com.tencent.mm.plugin.finder.view.k.sWA;
        k.a.X(this.JBI.JOR.getContext(), (Intent)localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(34590);
        return;
      }
    }
    if (((i)this.JBI.bh(i.class)).fDn())
    {
      ((com.tencent.mm.plugin.gamelife.c)g.ad(com.tencent.mm.plugin.gamelife.c.class)).enterGameLifeProfileUI(this.JBI.JOR.getContext(), (String)localObject1, com.tencent.mm.plugin.gamelife.a.uwn);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(34590);
      return;
    }
    paramView = (com.tencent.mm.ui.chatting.d.b.d)this.JBI.bh(com.tencent.mm.ui.chatting.d.b.d.class);
    if (paramView.fCH())
    {
      paramView = paramView.fCF().Em((String)localObject1);
      if (paramView != null)
      {
        if ((paramView == null) || (bt.isNullOrNil(paramView.field_profileUrl)))
        {
          if (paramView == null) {}
          for (bool = true;; bool = false)
          {
            ad.w("MicroMsg.ChattingListAvatarListener", "onClick userInfo == null:%s", new Object[] { Boolean.valueOf(bool) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(34590);
            return;
          }
        }
        ad.i("MicroMsg.ChattingListAvatarListener", "onClick Url:%s", new Object[] { paramView.field_profileUrl });
        ag.aGh().bi(paramView.field_userId, paramView.field_brandUserName);
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", paramView.field_profileUrl);
        ((Intent)localObject1).putExtra("useJs", true);
        com.tencent.mm.bs.d.b(this.JBI.JOR.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(34590);
      return;
    }
    Object localObject3 = new Intent();
    ((Intent)localObject3).putExtra("Contact_User", (String)localObject1);
    a((Intent)localObject3, (bk)localObject2);
    ba.aBQ();
    Object localObject4 = com.tencent.mm.model.c.azp().Bf((String)localObject1);
    if ((localObject4 != null) && ((int)((com.tencent.mm.o.b)localObject4).gfj > 0) && (com.tencent.mm.o.b.lM(((aw)localObject4).field_type))) {
      e.a((Intent)localObject3, (String)localObject1);
    }
    if (w.vF(this.JBI.getTalkerUserName()))
    {
      ba.aBQ();
      localObject4 = com.tencent.mm.model.c.azz().AO(this.JBI.getTalkerUserName());
      ((Intent)localObject3).putExtra("Contact_RoomNickname", ((ab)localObject4).zf((String)localObject1));
      ((Intent)localObject3).putExtra("Contact_Scene", 14);
      ((Intent)localObject3).putExtra("Contact_ChatRoomId", this.JBI.getTalkerUserName());
      ((Intent)localObject3).putExtra("room_name", this.JBI.getTalkerUserName());
      if (((ab)localObject4).field_roomowner == null) {
        ((Intent)localObject3).putExtra("Is_RoomOwner", bool);
      }
    }
    else if (((bk)localObject2).dBd != null)
    {
      switch (((bk)localObject2).dBd.getType())
      {
      }
    }
    for (;;)
    {
      if (!paramView.a(this.JBI, (bk)localObject2)) {
        break label1127;
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(34590);
      return;
      bool = ((ab)localObject4).field_roomowner.equals(u.aAm());
      break;
      ((Intent)localObject3).putExtra("Contact_Scene", 34);
      ((Intent)localObject3).putExtra("Contact_IsLBSFriend", true);
    }
    label1127:
    if (this.JBI.fFv()) {}
    for (int i = 3;; i = 2)
    {
      ((Intent)localObject3).putExtra("CONTACT_INFO_UI_SOURCE", i);
      com.tencent.mm.bs.d.b(this.JBI.JOR.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject3, 213);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(34590);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s.b
 * JD-Core Version:    0.7.0.1
 */