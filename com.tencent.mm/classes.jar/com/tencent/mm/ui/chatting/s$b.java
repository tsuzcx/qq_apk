package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.a.h;
import com.tencent.mm.am.a.k;
import com.tencent.mm.am.af;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.c.b.y;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.viewitems.bi;
import com.tencent.mm.ui.contact.e;

public class s$b
  implements View.OnClickListener
{
  private a Gob;
  
  public s$b(a parama)
  {
    this.Gob = parama;
  }
  
  public void a(Intent paramIntent, bi parambi) {}
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    AppMethodBeat.i(34590);
    Object localObject1 = (bi)paramView.getTag();
    if (localObject1 == null)
    {
      AppMethodBeat.o(34590);
      return;
    }
    paramView = ((bi)localObject1).userName;
    if ((paramView == null) || (paramView.equals("")))
    {
      AppMethodBeat.o(34590);
      return;
    }
    if (((y)this.Gob.be(y.class)).eYj())
    {
      localObject1 = this.Gob.GzJ.getContext();
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("Contact_User", paramView);
      ((Intent)localObject2).putExtra("Contact_Encryptusername", true);
      ((Intent)localObject2).putExtra("Contact_IsLBSFriend", true);
      ((Intent)localObject2).putExtra("Contact_IsLbsChattingProfile", true);
      com.tencent.mm.bs.d.b((Context)localObject1, "profile", ".ui.ContactInfoUI", (Intent)localObject2);
      AppMethodBeat.o(34590);
      return;
    }
    Object localObject2 = (com.tencent.mm.ui.chatting.c.b.d)this.Gob.be(com.tencent.mm.ui.chatting.c.b.d.class);
    if (((com.tencent.mm.ui.chatting.c.b.d)localObject2).eWC())
    {
      paramView = ((com.tencent.mm.ui.chatting.c.b.d)localObject2).eWA().xh(paramView);
      if (paramView != null)
      {
        if ((paramView == null) || (bt.isNullOrNil(paramView.field_profileUrl)))
        {
          if (paramView == null) {}
          for (bool = true;; bool = false)
          {
            ad.w("MicroMsg.ChattingListAvatarListener", "onClick userInfo == null:%s", new Object[] { Boolean.valueOf(bool) });
            AppMethodBeat.o(34590);
            return;
          }
        }
        ad.i("MicroMsg.ChattingListAvatarListener", "onClick Url:%s", new Object[] { paramView.field_profileUrl });
        af.awm().aZ(paramView.field_userId, paramView.field_brandUserName);
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", paramView.field_profileUrl);
        ((Intent)localObject1).putExtra("useJs", true);
        com.tencent.mm.bs.d.b(this.Gob.GzJ.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
      }
      AppMethodBeat.o(34590);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", paramView);
    a(localIntent, (bi)localObject1);
    az.arV();
    Object localObject3 = com.tencent.mm.model.c.apM().aHY(paramView);
    if ((localObject3 != null) && ((int)((b)localObject3).fId > 0) && (b.ls(((au)localObject3).field_type))) {
      e.a(localIntent, paramView);
    }
    if (com.tencent.mm.model.w.pF(this.Gob.getTalkerUserName()))
    {
      az.arV();
      localObject3 = com.tencent.mm.model.c.apV().tI(this.Gob.getTalkerUserName());
      localIntent.putExtra("Contact_RoomNickname", ((com.tencent.mm.storage.w)localObject3).sh(paramView));
      localIntent.putExtra("Contact_Scene", 14);
      localIntent.putExtra("Contact_ChatRoomId", this.Gob.getTalkerUserName());
      localIntent.putExtra("room_name", this.Gob.getTalkerUserName());
      if (((com.tencent.mm.storage.w)localObject3).field_roomowner == null) {
        localIntent.putExtra("Is_RoomOwner", bool);
      }
    }
    else if (((bi)localObject1).drF != null)
    {
      switch (((bi)localObject1).drF.getType())
      {
      }
    }
    for (;;)
    {
      if (!((com.tencent.mm.ui.chatting.c.b.d)localObject2).a(this.Gob, (bi)localObject1)) {
        break label603;
      }
      AppMethodBeat.o(34590);
      return;
      bool = ((com.tencent.mm.storage.w)localObject3).field_roomowner.equals(u.aqG());
      break;
      localIntent.putExtra("Contact_Scene", 34);
      localIntent.putExtra("Contact_IsLBSFriend", true);
    }
    label603:
    if (this.Gob.eZb()) {}
    for (int i = 3;; i = 2)
    {
      localIntent.putExtra("CONTACT_INFO_UI_SOURCE", i);
      com.tencent.mm.bs.d.b(this.Gob.GzJ.getContext(), "profile", ".ui.ContactInfoUI", localIntent, 213);
      AppMethodBeat.o(34590);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s.b
 * JD-Core Version:    0.7.0.1
 */