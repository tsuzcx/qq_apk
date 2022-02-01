package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.k;
import com.tencent.mm.al.ag;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.report.d.d;
import com.tencent.mm.plugin.finder.view.n;
import com.tencent.mm.plugin.finder.view.n.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.i.a.aa;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.i.a.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.d.b.ac;
import com.tencent.mm.ui.chatting.d.b.f;
import com.tencent.mm.ui.chatting.d.b.i;
import com.tencent.mm.ui.chatting.viewitems.bq;
import com.tencent.mm.ui.contact.e;

public class t$b
  implements View.OnClickListener
{
  private com.tencent.mm.ui.chatting.e.a PhN;
  
  public t$b(com.tencent.mm.ui.chatting.e.a parama)
  {
    this.PhN = parama;
  }
  
  public void a(Intent paramIntent, bq parambq) {}
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    AppMethodBeat.i(34590);
    Object localObject1 = new b();
    ((b)localObject1).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).axR());
    Object localObject2 = (bq)paramView.getTag();
    if (localObject2 == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(34590);
      return;
    }
    localObject1 = ((bq)localObject2).userName;
    if ((localObject1 == null) || (((String)localObject1).equals("")))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(34590);
      return;
    }
    if (((ac)this.PhN.bh(ac.class)).gQH())
    {
      paramView = this.PhN.Pwc.getContext();
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("Contact_User", (String)localObject1);
      ((Intent)localObject2).putExtra("Contact_Encryptusername", true);
      ((Intent)localObject2).putExtra("Contact_IsLBSFriend", true);
      ((Intent)localObject2).putExtra("Contact_IsLbsChattingProfile", true);
      com.tencent.mm.br.c.b(paramView, "profile", ".ui.ContactInfoUI", (Intent)localObject2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(34590);
      return;
    }
    if (((com.tencent.mm.ui.chatting.d.b.h)this.PhN.bh(com.tencent.mm.ui.chatting.d.b.h.class)).gPu())
    {
      paramView = "";
      if (((com.tencent.mm.ui.chatting.d.b.h)this.PhN.bh(com.tencent.mm.ui.chatting.d.b.h.class)).bjt((String)localObject1)) {
        paramView = (View)localObject1;
      }
      for (;;)
      {
        localObject3 = com.tencent.mm.plugin.finder.report.d.vdp;
        localObject3 = com.tencent.mm.plugin.finder.report.d.dnJ();
        ((d.d)localObject3).vdH += 1L;
        if (!((com.tencent.mm.ui.chatting.d.b.h)this.PhN.bh(com.tencent.mm.ui.chatting.d.b.h.class)).bjt(paramView)) {
          break;
        }
        if (((String)localObject1).equals(z.aUg())) {
          paramView = (View)localObject1;
        }
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("finder_username", paramView);
        ((Intent)localObject2).putExtra("key_enter_profile_type", 10);
        paramView = FinderReporterUIC.wzC;
        FinderReporterUIC.a.a(this.PhN.Pwc.getContext(), (Intent)localObject2, 0L, 10, false);
        ((Intent)localObject2).putExtra("KEY_FINDER_SELF_FLAG", ((String)localObject1).equals(z.aUg()));
        ((aj)g.ah(aj.class)).enterFinderProfileUI(this.PhN.Pwc.getContext(), (Intent)localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(34590);
        return;
        if (as.avl((String)localObject1)) {
          paramView = ((aa)g.af(aa.class)).avi((String)localObject1);
        }
      }
      if (((com.tencent.mm.ui.chatting.d.b.h)this.PhN.bh(com.tencent.mm.ui.chatting.d.b.h.class)).bmH(paramView))
      {
        ((aa)g.af(aa.class)).avj(paramView);
        localObject1 = new Intent();
        paramView = ((m)g.af(m.class)).avb(paramView);
        localObject2 = n.wpY;
        n.a.a(paramView, (Intent)localObject1);
        paramView = n.wpY;
        n.a.a(this.PhN.Pwc.getContext(), (Intent)localObject1, null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(34590);
        return;
      }
    }
    if (((i)this.PhN.bh(i.class)).gPw())
    {
      ((com.tencent.mm.plugin.gamelife.c)g.ah(com.tencent.mm.plugin.gamelife.c.class)).enterGameLifeProfileUI(this.PhN.Pwc.getContext(), (String)localObject1, com.tencent.mm.plugin.gamelife.a.xZY);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(34590);
      return;
    }
    paramView = (com.tencent.mm.ui.chatting.d.b.d)this.PhN.bh(com.tencent.mm.ui.chatting.d.b.d.class);
    if (paramView.gOP())
    {
      paramView = paramView.gON().NC((String)localObject1);
      if (paramView != null)
      {
        if ((paramView == null) || (Util.isNullOrNil(paramView.field_profileUrl)))
        {
          if (paramView == null) {}
          for (bool = true;; bool = false)
          {
            Log.w("MicroMsg.ChattingListAvatarListener", "onClick userInfo == null:%s", new Object[] { Boolean.valueOf(bool) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(34590);
            return;
          }
        }
        Log.i("MicroMsg.ChattingListAvatarListener", "onClick Url:%s", new Object[] { paramView.field_profileUrl });
        ag.baq().bm(paramView.field_userId, paramView.field_brandUserName);
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", paramView.field_profileUrl);
        ((Intent)localObject1).putExtra("useJs", true);
        com.tencent.mm.br.c.b(this.PhN.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(34590);
      return;
    }
    Object localObject3 = new Intent();
    ((Intent)localObject3).putExtra("Contact_User", (String)localObject1);
    a((Intent)localObject3, (bq)localObject2);
    bg.aVF();
    Object localObject4 = com.tencent.mm.model.c.aSN().Kn((String)localObject1);
    if ((localObject4 != null) && ((int)((com.tencent.mm.contact.c)localObject4).gMZ > 0) && (com.tencent.mm.contact.c.oR(((ax)localObject4).field_type))) {
      e.a((Intent)localObject3, (String)localObject1);
    }
    if (ab.Eq(this.PhN.getTalkerUserName()))
    {
      bg.aVF();
      localObject4 = com.tencent.mm.model.c.aSX().Ke(this.PhN.getTalkerUserName());
      ((Intent)localObject3).putExtra("Contact_RoomNickname", ((ah)localObject4).getDisplayName((String)localObject1));
      ((Intent)localObject3).putExtra("Contact_Scene", 14);
      ((Intent)localObject3).putExtra("Contact_ChatRoomId", this.PhN.getTalkerUserName());
      ((Intent)localObject3).putExtra("room_name", this.PhN.getTalkerUserName());
      if (((ah)localObject4).field_roomowner == null) {
        ((Intent)localObject3).putExtra("Is_RoomOwner", bool);
      }
    }
    else if (((bq)localObject2).dTX != null)
    {
      switch (((bq)localObject2).dTX.getType())
      {
      }
    }
    for (;;)
    {
      if (!paramView.a(this.PhN, (bq)localObject2)) {
        break label1139;
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(34590);
      return;
      bool = ((ah)localObject4).field_roomowner.equals(z.aTY());
      break;
      ((Intent)localObject3).putExtra("Contact_Scene", 34);
      ((Intent)localObject3).putExtra("Contact_IsLBSFriend", true);
    }
    label1139:
    if (this.PhN.gRM()) {}
    for (int i = 3;; i = 2)
    {
      ((Intent)localObject3).putExtra("CONTACT_INFO_UI_SOURCE", i);
      com.tencent.mm.br.c.b(this.PhN.Pwc.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject3, 213);
      if ((this.PhN.gRM()) && (((f)this.PhN.bh(f.class)).gPh())) {
        ((com.tencent.mm.plugin.textstatus.a.c)g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).report22210((String)localObject1, 5L);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(34590);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.t.b
 * JD-Core Version:    0.7.0.1
 */