package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ai.a.h;
import com.tencent.mm.ai.a.j;
import com.tencent.mm.ai.z;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.ct;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.af;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.chatting.viewitems.aw;

public final class t
{
  public static final class a
    extends t.b
  {
    public a(com.tencent.mm.ui.chatting.c.a parama)
    {
      super();
    }
    
    public final void a(Intent paramIntent, aw paramaw)
    {
      if (!bk.bl(paramaw.vHn)) {
        paramIntent.putExtra("Contact_BIZ_KF_WORKER_ID", paramaw.vHn);
      }
    }
  }
  
  public static class b
    implements View.OnClickListener
  {
    private com.tencent.mm.ui.chatting.c.a vko;
    
    public b(com.tencent.mm.ui.chatting.c.a parama)
    {
      this.vko = parama;
    }
    
    public void a(Intent paramIntent, aw paramaw) {}
    
    public void onClick(View paramView)
    {
      boolean bool = false;
      Object localObject1 = (aw)paramView.getTag();
      paramView = ((aw)localObject1).userName;
      if ((paramView == null) || (paramView.equals(""))) {}
      do
      {
        return;
        if (((com.tencent.mm.ui.chatting.b.b.s)this.vko.ac(com.tencent.mm.ui.chatting.b.b.s.class)).cEW())
        {
          localObject1 = this.vko.vtz.getContext();
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("Contact_User", paramView);
          ((Intent)localObject2).putExtra("Contact_Encryptusername", true);
          ((Intent)localObject2).putExtra("Contact_IsLBSFriend", true);
          ((Intent)localObject2).putExtra("Contact_IsLbsChattingProfile", true);
          d.b((Context)localObject1, "profile", ".ui.ContactInfoUI", (Intent)localObject2);
          return;
        }
        localObject2 = (com.tencent.mm.ui.chatting.b.b.c)this.vko.ac(com.tencent.mm.ui.chatting.b.b.c.class);
        if (!((com.tencent.mm.ui.chatting.b.b.c)localObject2).cDG()) {
          break;
        }
        paramView = ((com.tencent.mm.ui.chatting.b.b.c)localObject2).cDE().lo(paramView);
      } while (paramView == null);
      if ((paramView == null) || (bk.bl(paramView.field_profileUrl)))
      {
        if (paramView == null) {}
        for (bool = true;; bool = false)
        {
          y.w("MicroMsg.ChattingListAvatarListener", "onClick userInfo == null:%s", new Object[] { Boolean.valueOf(bool) });
          return;
        }
      }
      y.i("MicroMsg.ChattingListAvatarListener", "onClick Url:%s", new Object[] { paramView.field_profileUrl });
      z.MG().aq(paramView.field_userId, paramView.field_brandUserName);
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("rawUrl", paramView.field_profileUrl);
      ((Intent)localObject1).putExtra("useJs", true);
      d.b(this.vko.vtz.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
      return;
      Object localObject2 = new Intent();
      ((Intent)localObject2).putExtra("Contact_User", paramView);
      a((Intent)localObject2, (aw)localObject1);
      au.Hx();
      Object localObject3 = com.tencent.mm.model.c.Fw().abl(paramView);
      if ((localObject3 != null) && ((int)((com.tencent.mm.n.a)localObject3).dBe > 0) && (com.tencent.mm.n.a.gR(((ao)localObject3).field_type))) {
        com.tencent.mm.ui.contact.e.a((Intent)localObject2, paramView);
      }
      if (com.tencent.mm.model.s.fn(this.vko.getTalkerUserName()))
      {
        au.Hx();
        localObject3 = com.tencent.mm.model.c.FF().io(this.vko.getTalkerUserName());
        ((Intent)localObject2).putExtra("Contact_RoomNickname", ((u)localObject3).gV(paramView));
        ((Intent)localObject2).putExtra("Contact_Scene", 14);
        ((Intent)localObject2).putExtra("Contact_ChatRoomId", this.vko.getTalkerUserName());
        ((Intent)localObject2).putExtra("room_name", this.vko.getTalkerUserName());
        if (((u)localObject3).field_roomowner == null) {
          ((Intent)localObject2).putExtra("Is_RoomOwner", bool);
        }
      }
      else
      {
        if (((aw)localObject1).bWO != null) {}
        switch (((aw)localObject1).bWO.getType())
        {
        case 56: 
        default: 
          label504:
          if (!this.vko.cFE()) {
            break;
          }
        }
      }
      for (int i = 3;; i = 2)
      {
        ((Intent)localObject2).putExtra("CONTACT_INFO_UI_SOURCE", i);
        d.b(this.vko.vtz.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject2, 213);
        return;
        bool = ((u)localObject3).field_roomowner.equals(q.Gj());
        break;
        ((Intent)localObject2).putExtra("Contact_Scene", 34);
        ((Intent)localObject2).putExtra("Contact_IsLBSFriend", true);
        break label504;
      }
    }
  }
  
  public static final class h
    extends t.d
  {
    public h(com.tencent.mm.ui.chatting.c.a parama)
    {
      super();
    }
    
    public final void a(View paramView, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
    {
      paramView = (aw)paramView.getTag();
      int i = paramView.designerUIN;
      parambi = paramView.designerName;
      String str = paramView.designerRediretctUrl;
      if (i != 0)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("geta8key_username", parama.getTalkerUserName());
        localIntent.putExtra("rawUrl", paramView.cQF);
        localIntent.putExtra("uin", i);
        localIntent.putExtra("name", parambi);
        localIntent.putExtra("rediret_url", str);
        localIntent.putExtra("extra_scence", 22);
        d.b(parama.vtz.getContext(), "emoji", ".ui.v2.EmojiStoreV2DesignerUI", localIntent);
      }
    }
  }
  
  public static final class i
    extends t.d
  {
    public i(com.tencent.mm.ui.chatting.c.a parama)
    {
      super();
    }
    
    public final void a(View paramView, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
    {
      paramView = (aw)paramView.getTag();
      int i = paramView.tid;
      parambi = paramView.dSN;
      String str1 = paramView.desc;
      String str2 = paramView.iconUrl;
      String str3 = paramView.secondUrl;
      int j = paramView.pageType;
      if (i != 0)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("geta8key_username", parama.getTalkerUserName());
        localIntent.putExtra("rawUrl", paramView.cQF);
        localIntent.putExtra("set_id", i);
        localIntent.putExtra("set_title", parambi);
        localIntent.putExtra("set_iconURL", str2);
        localIntent.putExtra("set_desc", str1);
        localIntent.putExtra("headurl", str3);
        localIntent.putExtra("pageType", j);
        d.b(parama.vtz.getContext(), "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", localIntent);
        return;
      }
      y.i("MicroMsg.DesignerClickListener", "topic id is zero.");
    }
  }
  
  public static final class k
    extends t.d
  {
    public k(com.tencent.mm.ui.chatting.c.a parama)
    {
      super();
    }
    
    public final void a(View paramView, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
    {
      paramView = (aw)paramView.getTag();
      int i = paramView.tid;
      parambi = paramView.dSN;
      String str1 = paramView.desc;
      String str2 = paramView.iconUrl;
      String str3 = paramView.secondUrl;
      if (i != 0)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("geta8key_username", parama.getTalkerUserName());
        localIntent.putExtra("rawUrl", paramView.cQF);
        localIntent.putExtra("topic_id", i);
        localIntent.putExtra("topic_name", parambi);
        localIntent.putExtra("topic_desc", str1);
        localIntent.putExtra("topic_icon_url", str2);
        localIntent.putExtra("topic_ad_url", str3);
        localIntent.putExtra("extra_scence", 22);
        d.b(parama.vtz.getContext(), "emoji", ".ui.EmojiStoreTopicUI", localIntent);
        return;
      }
      y.i("MicroMsg.DesignerClickListener", "topic id is zero.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.t
 * JD-Core Version:    0.7.0.1
 */