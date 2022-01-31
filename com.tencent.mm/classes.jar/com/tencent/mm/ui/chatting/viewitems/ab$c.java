package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.as.o;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.t.d;
import com.tencent.mm.ui.x;
import java.util.Map;

public final class ab$c
  extends t.d
{
  private c vEX;
  
  public ab$c(com.tencent.mm.ui.chatting.c.a parama, c paramc)
  {
    super(parama);
    this.vEX = paramc;
  }
  
  private void a(long paramLong1, long paramLong2, String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(this.vko.vtz.getContext(), ImageGalleryUI.class);
    localIntent.putExtra("img_gallery_msg_id", paramLong1);
    localIntent.putExtra("show_search_chat_content_result", ((com.tencent.mm.ui.chatting.b.b.y)this.vko.ac(com.tencent.mm.ui.chatting.b.b.y.class)).cFj());
    localIntent.putExtra("img_gallery_msg_svr_id", paramLong2);
    localIntent.putExtra("key_is_biz_chat", ((com.tencent.mm.ui.chatting.b.b.c)this.vko.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDG());
    localIntent.putExtra("key_biz_chat_id", ((com.tencent.mm.ui.chatting.b.b.c)this.vko.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDS());
    localIntent.putExtra("img_gallery_talker", paramString1);
    localIntent.putExtra("img_gallery_chatroom_name", paramString2);
    localIntent.putExtra("img_gallery_left", paramArrayOfInt[0]);
    localIntent.putExtra("img_gallery_top", paramArrayOfInt[1]);
    localIntent.putExtra("img_gallery_width", paramInt1);
    localIntent.putExtra("img_gallery_height", paramInt2);
    localIntent.putExtra("img_gallery_enter_from_chatting_ui", ((com.tencent.mm.ui.chatting.b.b.y)this.vko.ac(com.tencent.mm.ui.chatting.b.b.y.class)).cFe());
    localIntent.putExtra("img_gallery_enter_from_appbrand_service_chatting_ui", ad.gr(paramString1));
    paramString2 = this.vko.getTalkerUserName();
    paramArrayOfInt = new Bundle();
    if (this.vko.cFE()) {
      paramInt1 = 2;
    }
    for (;;)
    {
      paramArrayOfInt.putInt("stat_scene", paramInt1);
      paramArrayOfInt.putString("stat_msg_id", "msg_" + Long.toString(paramLong2));
      paramArrayOfInt.putString("stat_chat_talker_username", paramString2);
      paramArrayOfInt.putString("stat_send_msg_user", paramString1);
      localIntent.putExtra("_stat_obj", paramArrayOfInt);
      this.vko.startActivity(localIntent);
      this.vko.vtz.overridePendingTransition(0, 0);
      return;
      if (com.tencent.mm.model.s.hl(paramString2)) {
        paramInt1 = 7;
      } else {
        paramInt1 = 1;
      }
    }
  }
  
  public static void a(com.tencent.mm.ui.chatting.c.a parama, bi parambi, long paramLong1, long paramLong2, String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Intent localIntent = new Intent(parama.vtz.getContext(), ImageGalleryUI.class);
    localIntent.putExtra("img_gallery_msg_id", paramLong1);
    localIntent.putExtra("img_gallery_msg_svr_id", paramLong2);
    localIntent.putExtra("show_search_chat_content_result", ((com.tencent.mm.ui.chatting.b.b.y)parama.ac(com.tencent.mm.ui.chatting.b.b.y.class)).cFj());
    localIntent.putExtra("key_is_biz_chat", ((com.tencent.mm.ui.chatting.b.b.c)parama.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDG());
    localIntent.putExtra("key_biz_chat_id", ((com.tencent.mm.ui.chatting.b.b.c)parama.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDS());
    localIntent.putExtra("img_gallery_talker", paramString1);
    localIntent.putExtra("img_gallery_chatroom_name", paramString2);
    localIntent.putExtra("img_gallery_left", paramArrayOfInt[0]);
    localIntent.putExtra("img_gallery_top", paramArrayOfInt[1]);
    localIntent.putExtra("img_gallery_width", paramInt1);
    localIntent.putExtra("img_gallery_height", paramInt2);
    localIntent.putExtra("img_gallery_enter_from_chatting_ui", ((com.tencent.mm.ui.chatting.b.b.y)parama.ac(com.tencent.mm.ui.chatting.b.b.y.class)).cFe());
    localIntent.putExtra("img_gallery_enter_PhotoEditUI", paramBoolean);
    localIntent.putExtra("img_gallery_enter_from_appbrand_service_chatting_ui", ad.gr(paramString1));
    paramString2 = parama.getTalkerUserName();
    if (parambi.field_isSend == 1) {
      paramString1 = parama.cFB();
    }
    parambi = new Bundle();
    if (parama.cFD()) {
      paramInt1 = 2;
    }
    for (;;)
    {
      parambi.putInt("stat_scene", paramInt1);
      parambi.putString("stat_msg_id", "msg_" + Long.toString(paramLong2));
      parambi.putString("stat_chat_talker_username", paramString2);
      parambi.putString("stat_send_msg_user", paramString1);
      localIntent.putExtra("_stat_obj", parambi);
      parama.vtz.startActivity(localIntent);
      parama.vtz.overridePendingTransition(0, 0);
      return;
      if (com.tencent.mm.model.s.hl(paramString2)) {
        paramInt1 = 7;
      } else {
        paramInt1 = 1;
      }
    }
  }
  
  public final void a(View paramView, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    Object localObject2 = (aw)paramView.getTag();
    b.eBD.z(((aw)localObject2).bWO);
    bi localbi = ((aw)localObject2).bWO;
    com.tencent.mm.modelstat.a.a(localbi, a.a.eBA);
    int[] arrayOfInt = new int[2];
    int i = 0;
    int j = 0;
    if (paramView != null)
    {
      paramView.getLocationInWindow(arrayOfInt);
      i = paramView.getWidth();
      j = paramView.getHeight();
    }
    if (localbi.field_isSend == 1)
    {
      paramView = o.OJ().bY(localbi.field_msgId);
      if (paramView.enp != 0L) {}
    }
    else
    {
      paramView = o.OJ().bX(localbi.field_msgSvrId);
    }
    for (;;)
    {
      Object localObject1 = bn.s(localbi.field_content, "msg");
      if (localObject1 != null) {
        bk.getLong((String)((Map)localObject1).get(".msg.img.$hdlength"), 0L);
      }
      au.Hx();
      if (!com.tencent.mm.model.c.isSDCardAvailable()) {
        com.tencent.mm.ui.base.s.gM(this.vko.vtz.getContext());
      }
      for (;;)
      {
        localObject1 = g.a.go(parambi.field_content);
        if ((localObject1 != null) && (!bk.bl(((g.a)localObject1).appId)) && (this.vEX != null))
        {
          localObject2 = com.tencent.mm.pluginsdk.model.app.g.by(((g.a)localObject1).appId, false);
          if ((localObject2 != null) && (((com.tencent.mm.pluginsdk.model.app.f)localObject2).ZH()))
          {
            if (!(this.vEX instanceof ab.a)) {
              break label649;
            }
            paramView = c.d(parama, parambi);
            label241:
            c.a(parama, (g.a)localObject1, paramView, (com.tencent.mm.pluginsdk.model.app.f)localObject2, parambi.field_msgSvrId);
          }
        }
        return;
        if (localbi.field_isSend != 1) {
          break;
        }
        localObject1 = com.tencent.mm.as.f.c(paramView);
        if (com.tencent.mm.vfs.e.bK(o.OJ().o((String)localObject1, "", "")))
        {
          a(this.vko, localbi, paramView.enx, paramView.bXr, ((aw)localObject2).userName, ((aw)localObject2).chatroomName, arrayOfInt, i, j, false);
        }
        else
        {
          localObject1 = paramView.enq;
          if (com.tencent.mm.vfs.e.bK(o.OJ().o((String)localObject1, "", ""))) {
            a(this.vko, localbi, paramView.enx, paramView.bXr, ((aw)localObject2).userName, ((aw)localObject2).chatroomName, arrayOfInt, i, j, false);
          } else {
            a(localbi.field_msgId, localbi.field_msgSvrId, ((aw)localObject2).userName, ((aw)localObject2).chatroomName, arrayOfInt, i, j);
          }
        }
      }
      Object localObject3;
      if (paramView.Oq())
      {
        localObject1 = paramView.enq;
        if (!paramView.Or()) {
          break label656;
        }
        localObject3 = com.tencent.mm.as.f.a(paramView);
        if ((localObject3 == null) || (((com.tencent.mm.as.e)localObject3).enp <= 0L) || (!((com.tencent.mm.as.e)localObject3).Oq()) || (!com.tencent.mm.vfs.e.bK(o.OJ().o(((com.tencent.mm.as.e)localObject3).enq, "", "")))) {
          break label656;
        }
        localObject1 = ((com.tencent.mm.as.e)localObject3).enq;
      }
      label649:
      label656:
      for (;;)
      {
        localObject3 = this.vko;
        o.OJ().o((String)localObject1, "", "");
        a((com.tencent.mm.ui.chatting.c.a)localObject3, localbi, paramView.enx, paramView.bXr, ((aw)localObject2).userName, ((aw)localObject2).chatroomName, arrayOfInt, i, j, false);
        break;
        if (paramView.status == -1)
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.DesignerClickListener", "retry downloadImg, %d", new Object[] { Long.valueOf(paramView.enp) });
          paramView.setStatus(0);
          paramView.bcw = 256;
          o.OJ().a(Long.valueOf(paramView.enp), paramView);
        }
        a(localbi.field_msgId, localbi.field_msgSvrId, ((aw)localObject2).userName, ((aw)localObject2).chatroomName, arrayOfInt, i, j);
        break;
        paramView = q.Gj();
        break label241;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ab.c
 * JD-Core Version:    0.7.0.1
 */