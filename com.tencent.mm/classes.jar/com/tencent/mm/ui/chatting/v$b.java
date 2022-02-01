package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.report.f.d;
import com.tencent.mm.plugin.finder.view.w;
import com.tencent.mm.plugin.finder.view.w.a;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.bp;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.findersdk.a.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.component.api.g;
import com.tencent.mm.ui.chatting.component.api.i;
import com.tencent.mm.ui.chatting.viewitems.bz;

public class v$b
  implements View.OnClickListener
{
  private com.tencent.mm.ui.chatting.d.a aeiK;
  
  public v$b(com.tencent.mm.ui.chatting.d.a parama)
  {
    this.aeiK = parama;
  }
  
  public void a(Intent paramIntent, bz parambz) {}
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    AppMethodBeat.i(34590);
    Object localObject1 = new b();
    ((b)localObject1).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).aYj());
    Object localObject2 = (bz)paramView.getTag();
    if (localObject2 == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(34590);
      return;
    }
    localObject1 = ((bz)localObject2).userName;
    if ((localObject1 == null) || (((String)localObject1).equals("")))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(34590);
      return;
    }
    if (((com.tencent.mm.ui.chatting.component.api.af)this.aeiK.cm(com.tencent.mm.ui.chatting.component.api.af.class)).jtc())
    {
      paramView = this.aeiK.aezO.getContext();
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
    if (((i)this.aeiK.cm(i.class)).jrA())
    {
      paramView = "";
      if (((i)this.aeiK.cm(i.class)).bwV((String)localObject1)) {
        paramView = (View)localObject1;
      }
      for (;;)
      {
        localObject3 = com.tencent.mm.plugin.finder.report.f.FnM;
        localObject3 = com.tencent.mm.plugin.finder.report.f.eMm();
        ((f.d)localObject3).Fok += 1L;
        if (!((i)this.aeiK.cm(i.class)).bwV(paramView)) {
          break;
        }
        if (((String)localObject1).equals(z.bAW())) {
          paramView = (View)localObject1;
        }
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("finder_username", paramView);
        ((Intent)localObject2).putExtra("key_enter_profile_type", 10);
        paramView = as.GSQ;
        as.a.a(this.aeiK.aezO.getContext(), (Intent)localObject2, 0L, null, 0, 10, false);
        ((Intent)localObject2).putExtra("KEY_FINDER_SELF_FLAG", ((String)localObject1).equals(z.bAW()));
        ((cn)com.tencent.mm.kernel.h.az(cn.class)).enterFinderProfileUI(this.aeiK.aezO.getContext(), (Intent)localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(34590);
        return;
        if (au.aAy((String)localObject1)) {
          paramView = ((bp)com.tencent.mm.kernel.h.ax(bp.class)).aAw((String)localObject1);
        } else if (au.bwU((String)localObject1)) {
          paramView = (View)localObject1;
        }
      }
      if (((i)this.aeiK.cm(i.class)).bAM(paramView))
      {
        localObject1 = new Intent();
        paramView = ((y)com.tencent.mm.kernel.h.ax(y.class)).aAm(paramView);
        localObject2 = w.GEc;
        w.a.a(paramView, (Intent)localObject1);
        ((Intent)localObject1).putExtra("IsPoster", true);
        paramView = w.GEc;
        w.a.a(this.aeiK.aezO.getContext(), (Intent)localObject1, 2, null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(34590);
        return;
      }
      if (au.bwU((String)localObject1))
      {
        localObject1 = new Intent();
        paramView = ((y)com.tencent.mm.kernel.h.ax(y.class)).aAn(paramView);
        localObject2 = w.GEc;
        w.a.a(paramView, (Intent)localObject1);
        ((Intent)localObject1).putExtra("IsPoster", true);
        paramView = w.GEc;
        w.a.a(this.aeiK.aezO.getContext(), (Intent)localObject1, 2, null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(34590);
        return;
      }
    }
    if (((com.tencent.mm.ui.chatting.component.api.r)this.aeiK.cm(com.tencent.mm.ui.chatting.component.api.r.class)).jrT())
    {
      ((com.tencent.mm.plugin.textstatus.a.r)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.textstatus.a.r.class)).bV(this.aeiK.aezO.getContext(), (String)localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(34590);
      return;
    }
    if (((com.tencent.mm.ui.chatting.component.api.k)this.aeiK.cm(com.tencent.mm.ui.chatting.component.api.k.class)).jrF())
    {
      ((com.tencent.mm.plugin.gamelife.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.gamelife.c.class)).enterGameLifeProfileUI(this.aeiK.aezO.getContext(), (String)localObject1, com.tencent.mm.plugin.gamelife.a.IYW);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(34590);
      return;
    }
    paramView = (com.tencent.mm.ui.chatting.component.api.e)this.aeiK.cm(com.tencent.mm.ui.chatting.component.api.e.class);
    if (paramView.jqV())
    {
      paramView = paramView.jqT().MX((String)localObject1);
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
        com.tencent.mm.an.af.bHp().bB(paramView.field_userId, paramView.field_brandUserName);
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", paramView.field_profileUrl);
        ((Intent)localObject1).putExtra("useJs", true);
        com.tencent.mm.br.c.b(this.aeiK.aezO.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(34590);
      return;
    }
    Object localObject3 = new Intent();
    ((Intent)localObject3).putExtra("Contact_User", (String)localObject1);
    a((Intent)localObject3, (bz)localObject2);
    bh.bCz();
    Object localObject4 = com.tencent.mm.model.c.bzA().JE((String)localObject1);
    if ((localObject4 != null) && ((int)((d)localObject4).maN > 0) && (d.rs(((az)localObject4).field_type))) {
      com.tencent.mm.ui.contact.e.a((Intent)localObject3, (String)localObject1);
    }
    if (au.bwE(this.aeiK.getTalkerUserName()))
    {
      bh.bCz();
      localObject4 = com.tencent.mm.model.c.bzK().Jv(this.aeiK.getTalkerUserName());
      ((Intent)localObject3).putExtra("Contact_RoomNickname", ((aj)localObject4).getDisplayName((String)localObject1));
      ((Intent)localObject3).putExtra("Contact_Scene", 14);
      ((Intent)localObject3).putExtra("Contact_ChatRoomId", this.aeiK.getTalkerUserName());
      ((Intent)localObject3).putExtra("room_name", this.aeiK.getTalkerUserName());
      if (((aj)localObject4).field_roomowner == null) {
        ((Intent)localObject3).putExtra("Is_RoomOwner", bool);
      }
    }
    else if (((bz)localObject2).hTm != null)
    {
      switch (((bz)localObject2).hTm.getType())
      {
      }
    }
    for (;;)
    {
      if (!paramView.a(this.aeiK, (bz)localObject2)) {
        break label1307;
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(34590);
      return;
      bool = ((aj)localObject4).field_roomowner.equals(z.bAM());
      break;
      ((Intent)localObject3).putExtra("Contact_Scene", 34);
      ((Intent)localObject3).putExtra("Contact_IsLBSFriend", true);
    }
    label1307:
    if (this.aeiK.juG()) {}
    for (int i = 3;; i = 2)
    {
      ((Intent)localObject3).putExtra("CONTACT_INFO_UI_SOURCE", i);
      com.tencent.mm.br.c.b(this.aeiK.aezO.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject3, 213);
      if ((this.aeiK.juG()) && (((g)this.aeiK.cm(g.class)).jrp())) {
        ((com.tencent.mm.plugin.textstatus.a.f)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.textstatus.a.f.class)).report22210((String)localObject1, 5L);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$AvatarClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(34590);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.v.b
 * JD-Core Version:    0.7.0.1
 */