package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.a.k;
import com.tencent.mm.ao.af;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.report.d.d;
import com.tencent.mm.plugin.finder.view.t;
import com.tencent.mm.plugin.finder.view.t.a;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.findersdk.a.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.d.b.ac;
import com.tencent.mm.ui.chatting.d.b.f;
import com.tencent.mm.ui.chatting.d.b.i;
import com.tencent.mm.ui.chatting.viewitems.by;
import com.tencent.mm.ui.contact.e;

public class t$b
  implements View.OnClickListener
{
  private com.tencent.mm.ui.chatting.e.a WBq;
  
  public t$b(com.tencent.mm.ui.chatting.e.a parama)
  {
    this.WBq = parama;
  }
  
  public void a(Intent paramIntent, by paramby) {}
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    AppMethodBeat.i(34590);
    Object localObject1 = new b();
    ((b)localObject1).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).aFi());
    Object localObject2 = (by)paramView.getTag();
    if (localObject2 == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(34590);
      return;
    }
    localObject1 = ((by)localObject2).userName;
    if ((localObject1 == null) || (((String)localObject1).equals("")))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(34590);
      return;
    }
    if (((ac)this.WBq.bC(ac.class)).hQe())
    {
      paramView = this.WBq.WQv.getContext();
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("Contact_User", (String)localObject1);
      ((Intent)localObject2).putExtra("Contact_Encryptusername", true);
      ((Intent)localObject2).putExtra("Contact_IsLBSFriend", true);
      ((Intent)localObject2).putExtra("Contact_IsLbsChattingProfile", true);
      com.tencent.mm.by.c.b(paramView, "profile", ".ui.ContactInfoUI", (Intent)localObject2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(34590);
      return;
    }
    if (((com.tencent.mm.ui.chatting.d.b.h)this.WBq.bC(com.tencent.mm.ui.chatting.d.b.h.class)).hOK())
    {
      paramView = "";
      if (((com.tencent.mm.ui.chatting.d.b.h)this.WBq.bC(com.tencent.mm.ui.chatting.d.b.h.class)).bvP((String)localObject1)) {
        paramView = (View)localObject1;
      }
      for (;;)
      {
        localObject3 = com.tencent.mm.plugin.finder.report.d.zUg;
        localObject3 = com.tencent.mm.plugin.finder.report.d.dPg();
        ((d.d)localObject3).zUy += 1L;
        if (!((com.tencent.mm.ui.chatting.d.b.h)this.WBq.bC(com.tencent.mm.ui.chatting.d.b.h.class)).bvP(paramView)) {
          break;
        }
        if (((String)localObject1).equals(z.bdh())) {
          paramView = (View)localObject1;
        }
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("finder_username", paramView);
        ((Intent)localObject2).putExtra("key_enter_profile_type", 10);
        paramView = aj.Bnu;
        aj.a.a(this.WBq.WQv.getContext(), (Intent)localObject2, 0L, 10, false);
        ((Intent)localObject2).putExtra("KEY_FINDER_SELF_FLAG", ((String)localObject1).equals(z.bdh()));
        ((ak)com.tencent.mm.kernel.h.ag(ak.class)).enterFinderProfileUI(this.WBq.WQv.getContext(), (Intent)localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(34590);
        return;
        if (as.aEF((String)localObject1)) {
          paramView = ((com.tencent.mm.plugin.findersdk.a.ab)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.findersdk.a.ab.class)).aED((String)localObject1);
        }
      }
      if (((com.tencent.mm.ui.chatting.d.b.h)this.WBq.bC(com.tencent.mm.ui.chatting.d.b.h.class)).bzi(paramView))
      {
        localObject1 = new Intent();
        paramView = ((m)com.tencent.mm.kernel.h.ae(m.class)).aEt(paramView);
        localObject2 = t.BbG;
        t.a.a(paramView, (Intent)localObject1);
        ((Intent)localObject1).putExtra("IsPoster", true);
        paramView = t.BbG;
        t.a.a(this.WBq.WQv.getContext(), (Intent)localObject1, 2, null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(34590);
        return;
      }
    }
    if (((i)this.WBq.bC(i.class)).hOP())
    {
      ((com.tencent.mm.plugin.gamelife.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.gamelife.c.class)).enterGameLifeProfileUI(this.WBq.WQv.getContext(), (String)localObject1, com.tencent.mm.plugin.gamelife.a.DeF);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(34590);
      return;
    }
    paramView = (com.tencent.mm.ui.chatting.d.b.d)this.WBq.bC(com.tencent.mm.ui.chatting.d.b.d.class);
    if (paramView.hOe())
    {
      paramView = paramView.hOc().UY((String)localObject1);
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
        af.bjE().bq(paramView.field_userId, paramView.field_brandUserName);
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", paramView.field_profileUrl);
        ((Intent)localObject1).putExtra("useJs", true);
        com.tencent.mm.by.c.b(this.WBq.WQv.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(34590);
      return;
    }
    Object localObject3 = new Intent();
    ((Intent)localObject3).putExtra("Contact_User", (String)localObject1);
    a((Intent)localObject3, (by)localObject2);
    bh.beI();
    Object localObject4 = com.tencent.mm.model.c.bbL().RG((String)localObject1);
    if ((localObject4 != null) && ((int)((com.tencent.mm.contact.d)localObject4).jxt > 0) && (com.tencent.mm.contact.d.rk(((ax)localObject4).field_type))) {
      e.a((Intent)localObject3, (String)localObject1);
    }
    if (com.tencent.mm.model.ab.Lj(this.WBq.getTalkerUserName()))
    {
      bh.beI();
      localObject4 = com.tencent.mm.model.c.bbV().Rx(this.WBq.getTalkerUserName());
      ((Intent)localObject3).putExtra("Contact_RoomNickname", ((ah)localObject4).PJ((String)localObject1));
      ((Intent)localObject3).putExtra("Contact_Scene", 14);
      ((Intent)localObject3).putExtra("Contact_ChatRoomId", this.WBq.getTalkerUserName());
      ((Intent)localObject3).putExtra("room_name", this.WBq.getTalkerUserName());
      if (((ah)localObject4).field_roomowner == null) {
        ((Intent)localObject3).putExtra("Is_RoomOwner", bool);
      }
    }
    else if (((by)localObject2).fNz != null)
    {
      switch (((by)localObject2).fNz.getType())
      {
      }
    }
    for (;;)
    {
      if (!paramView.a(this.WBq, (by)localObject2)) {
        break label1135;
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(34590);
      return;
      bool = ((ah)localObject4).field_roomowner.equals(z.bcZ());
      break;
      ((Intent)localObject3).putExtra("Contact_Scene", 34);
      ((Intent)localObject3).putExtra("Contact_IsLBSFriend", true);
    }
    label1135:
    if (this.WBq.hRi()) {}
    for (int i = 3;; i = 2)
    {
      ((Intent)localObject3).putExtra("CONTACT_INFO_UI_SOURCE", i);
      com.tencent.mm.by.c.b(this.WBq.WQv.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject3, 213);
      if ((this.WBq.hRi()) && (((f)this.WBq.bC(f.class)).hOx())) {
        ((com.tencent.mm.plugin.textstatus.a.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.textstatus.a.d.class)).report22210((String)localObject1, 5L);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(34590);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.t.b
 * JD-Core Version:    0.7.0.1
 */