package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a.h;
import com.tencent.mm.aj.a.j;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.chatting.viewitems.az;
import com.tencent.mm.ui.contact.e;

public class s$b
  implements View.OnClickListener
{
  private com.tencent.mm.ui.chatting.d.a zzP;
  
  public s$b(com.tencent.mm.ui.chatting.d.a parama)
  {
    this.zzP = parama;
  }
  
  public void a(Intent paramIntent, az paramaz) {}
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    AppMethodBeat.i(30718);
    Object localObject1 = (az)paramView.getTag();
    paramView = ((az)localObject1).userName;
    if ((paramView == null) || (paramView.equals("")))
    {
      AppMethodBeat.o(30718);
      return;
    }
    if (((com.tencent.mm.ui.chatting.c.b.t)this.zzP.ay(com.tencent.mm.ui.chatting.c.b.t.class)).dIO())
    {
      localObject1 = this.zzP.zJz.getContext();
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("Contact_User", paramView);
      ((Intent)localObject2).putExtra("Contact_Encryptusername", true);
      ((Intent)localObject2).putExtra("Contact_IsLBSFriend", true);
      ((Intent)localObject2).putExtra("Contact_IsLbsChattingProfile", true);
      com.tencent.mm.bq.d.b((Context)localObject1, "profile", ".ui.ContactInfoUI", (Intent)localObject2);
      AppMethodBeat.o(30718);
      return;
    }
    Object localObject2 = (com.tencent.mm.ui.chatting.c.b.d)this.zzP.ay(com.tencent.mm.ui.chatting.c.b.d.class);
    if (((com.tencent.mm.ui.chatting.c.b.d)localObject2).dHv())
    {
      paramView = ((com.tencent.mm.ui.chatting.c.b.d)localObject2).dHt().sj(paramView);
      if (paramView != null)
      {
        if ((paramView == null) || (bo.isNullOrNil(paramView.field_profileUrl)))
        {
          if (paramView == null) {}
          for (bool = true;; bool = false)
          {
            ab.w("MicroMsg.ChattingListAvatarListener", "onClick userInfo == null:%s", new Object[] { Boolean.valueOf(bool) });
            AppMethodBeat.o(30718);
            return;
          }
        }
        ab.i("MicroMsg.ChattingListAvatarListener", "onClick Url:%s", new Object[] { paramView.field_profileUrl });
        z.afq().aK(paramView.field_userId, paramView.field_brandUserName);
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", paramView.field_profileUrl);
        ((Intent)localObject1).putExtra("useJs", true);
        com.tencent.mm.bq.d.b(this.zzP.zJz.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
      }
      AppMethodBeat.o(30718);
      return;
    }
    localObject2 = new Intent();
    ((Intent)localObject2).putExtra("Contact_User", paramView);
    a((Intent)localObject2, (az)localObject1);
    aw.aaz();
    Object localObject3 = com.tencent.mm.model.c.YA().arw(paramView);
    if ((localObject3 != null) && ((int)((com.tencent.mm.n.a)localObject3).euF > 0) && (com.tencent.mm.n.a.je(((aq)localObject3).field_type))) {
      e.a((Intent)localObject2, paramView);
    }
    if (com.tencent.mm.model.t.lA(this.zzP.getTalkerUserName()))
    {
      aw.aaz();
      localObject3 = com.tencent.mm.model.c.YJ().oV(this.zzP.getTalkerUserName());
      ((Intent)localObject2).putExtra("Contact_RoomNickname", ((u)localObject3).nE(paramView));
      ((Intent)localObject2).putExtra("Contact_Scene", 14);
      ((Intent)localObject2).putExtra("Contact_ChatRoomId", this.zzP.getTalkerUserName());
      ((Intent)localObject2).putExtra("room_name", this.zzP.getTalkerUserName());
      if (((u)localObject3).field_roomowner == null) {
        ((Intent)localObject2).putExtra("Is_RoomOwner", bool);
      }
    }
    else
    {
      if (((az)localObject1).cEE != null) {}
      switch (((az)localObject1).cEE.getType())
      {
      case 56: 
      default: 
        label536:
        if (!this.zzP.dJG()) {
          break;
        }
      }
    }
    for (int i = 3;; i = 2)
    {
      ((Intent)localObject2).putExtra("CONTACT_INFO_UI_SOURCE", i);
      com.tencent.mm.bq.d.b(this.zzP.zJz.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject2, 213);
      AppMethodBeat.o(30718);
      return;
      bool = ((u)localObject3).field_roomowner.equals(r.Zn());
      break;
      ((Intent)localObject2).putExtra("Contact_Scene", 34);
      ((Intent)localObject2).putExtra("Contact_IsLBSFriend", true);
      break label536;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s.b
 * JD-Core Version:    0.7.0.1
 */