package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.at.o;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.c.b.z;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.s.e;
import java.util.Map;

public final class ae
{
  public static final class c
    extends s.e
  {
    private c zWl;
    
    public c(com.tencent.mm.ui.chatting.d.a parama, c paramc)
    {
      super();
      this.zWl = paramc;
    }
    
    private void a(long paramLong1, long paramLong2, String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(33243);
      ab.i("MicroMsg.DesignerClickListener", "[ImageGalleryUI] doGetMsgImg");
      Intent localIntent = new Intent(this.zzP.zJz.getContext(), ImageGalleryUI.class);
      localIntent.putExtra("img_gallery_msg_id", paramLong1);
      localIntent.putExtra("show_search_chat_content_result", ((z)this.zzP.ay(z.class)).dJb());
      localIntent.putExtra("img_gallery_msg_svr_id", paramLong2);
      localIntent.putExtra("key_is_biz_chat", ((d)this.zzP.ay(d.class)).dHv());
      localIntent.putExtra("key_biz_chat_id", ((d)this.zzP.ay(d.class)).dHI());
      localIntent.putExtra("img_gallery_talker", paramString1);
      localIntent.putExtra("img_gallery_chatroom_name", paramString2);
      localIntent.putExtra("img_gallery_left", paramArrayOfInt[0]);
      localIntent.putExtra("img_gallery_top", paramArrayOfInt[1]);
      localIntent.putExtra("img_gallery_width", paramInt1);
      localIntent.putExtra("img_gallery_height", paramInt2);
      localIntent.putExtra("img_gallery_enter_from_chatting_ui", ((z)this.zzP.ay(z.class)).dIW());
      localIntent.putExtra("img_gallery_enter_from_appbrand_service_chatting_ui", ad.na(paramString1));
      paramString2 = this.zzP.getTalkerUserName();
      paramArrayOfInt = new Bundle();
      if (this.zzP.dJG()) {
        paramInt1 = 2;
      }
      for (;;)
      {
        paramArrayOfInt.putInt("stat_scene", paramInt1);
        paramArrayOfInt.putString("stat_msg_id", "msg_" + Long.toString(paramLong2));
        paramArrayOfInt.putString("stat_chat_talker_username", paramString2);
        paramArrayOfInt.putString("stat_send_msg_user", paramString1);
        localIntent.putExtra("_stat_obj", paramArrayOfInt);
        localIntent.putExtra("img_gallery_session_id", d(paramLong2, paramString1, paramString2));
        this.zzP.startActivity(localIntent);
        this.zzP.zJz.overridePendingTransition(0, 0);
        AppMethodBeat.o(33243);
        return;
        if (com.tencent.mm.model.t.nU(paramString2)) {
          paramInt1 = 7;
        } else {
          paramInt1 = 1;
        }
      }
    }
    
    public static void a(com.tencent.mm.ui.chatting.d.a parama, bi parambi, long paramLong1, long paramLong2, String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(33244);
      ab.i("MicroMsg.DesignerClickListener", "[ImageGalleryUI] showImgGallery");
      Intent localIntent = new Intent(parama.zJz.getContext(), ImageGalleryUI.class);
      localIntent.putExtra("img_gallery_msg_id", paramLong1);
      localIntent.putExtra("img_gallery_msg_svr_id", paramLong2);
      localIntent.putExtra("show_search_chat_content_result", ((z)parama.ay(z.class)).dJb());
      localIntent.putExtra("key_is_biz_chat", ((d)parama.ay(d.class)).dHv());
      localIntent.putExtra("key_biz_chat_id", ((d)parama.ay(d.class)).dHI());
      localIntent.putExtra("img_gallery_talker", paramString1);
      localIntent.putExtra("img_gallery_chatroom_name", paramString2);
      localIntent.putExtra("img_gallery_left", paramArrayOfInt[0]);
      localIntent.putExtra("img_gallery_top", paramArrayOfInt[1]);
      localIntent.putExtra("img_gallery_width", paramInt1);
      localIntent.putExtra("img_gallery_height", paramInt2);
      localIntent.putExtra("img_gallery_enter_from_chatting_ui", ((z)parama.ay(z.class)).dIW());
      localIntent.putExtra("img_gallery_enter_PhotoEditUI", paramBoolean);
      localIntent.putExtra("img_gallery_enter_from_appbrand_service_chatting_ui", ad.na(paramString1));
      paramString2 = parama.getTalkerUserName();
      if (parambi.field_isSend == 1) {
        paramString1 = parama.dJD();
      }
      parambi = new Bundle();
      if (parama.dJF()) {
        paramInt1 = 2;
      }
      for (;;)
      {
        parambi.putInt("stat_scene", paramInt1);
        parambi.putString("stat_msg_id", "msg_" + Long.toString(paramLong2));
        parambi.putString("stat_chat_talker_username", paramString2);
        parambi.putString("stat_send_msg_user", paramString1);
        localIntent.putExtra("_stat_obj", parambi);
        localIntent.putExtra("img_gallery_session_id", d(paramLong2, paramString1, paramString2));
        parama.zJz.startActivity(localIntent);
        parama.zJz.overridePendingTransition(0, 0);
        AppMethodBeat.o(33244);
        return;
        if (com.tencent.mm.model.t.nU(paramString2)) {
          paramInt1 = 7;
        } else {
          paramInt1 = 1;
        }
      }
    }
    
    private static String d(long paramLong, String paramString1, String paramString2)
    {
      AppMethodBeat.i(33245);
      String str = v.oQ(String.valueOf(paramLong));
      v.b localb = v.aae().z(str, true);
      localb.i("preUsername", paramString1);
      localb.i("preChatName", paramString2);
      AppMethodBeat.o(33245);
      return str;
    }
    
    public final void a(View paramView, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
    {
      AppMethodBeat.i(33242);
      az localaz = (az)paramView.getTag();
      b.fRu.F(localaz.cEE);
      bi localbi = localaz.cEE;
      com.tencent.mm.modelstat.a.a(localbi, a.a.fRr);
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
        paramView = o.ahC().gT(localbi.field_msgId);
        if (paramView.fDL != 0L) {}
      }
      else
      {
        paramView = o.ahC().gS(localbi.field_msgSvrId);
      }
      for (;;)
      {
        Object localObject1 = br.F(localbi.field_content, "msg");
        if (localObject1 != null) {
          bo.getLong((String)((Map)localObject1).get(".msg.img.$hdlength"), 0L);
        }
        aw.aaz();
        Object localObject2;
        if (!com.tencent.mm.model.c.isSDCardAvailable())
        {
          com.tencent.mm.ui.base.t.ii(this.zzP.zJz.getContext());
          localObject1 = j.b.mX(parambi.field_content);
          if ((localObject1 != null) && (!bo.isNullOrNil(((j.b)localObject1).appId)) && (this.zWl != null))
          {
            localObject2 = com.tencent.mm.pluginsdk.model.app.g.ca(((j.b)localObject1).appId, false);
            if (localObject2 != null) {
              if (!(this.zWl instanceof ae.a)) {
                break label769;
              }
            }
          }
        }
        label769:
        for (paramView = c.d(parama, parambi);; paramView = r.Zn())
        {
          c.a(parama, (j.b)localObject1, paramView, (com.tencent.mm.pluginsdk.model.app.f)localObject2, parambi.field_msgSvrId, parama.getTalkerUserName());
          AppMethodBeat.o(33242);
          return;
          if (localbi.field_isSend == 1)
          {
            localObject1 = com.tencent.mm.at.f.c(paramView);
            if (com.tencent.mm.vfs.e.cN(o.ahC().q((String)localObject1, "", "")))
            {
              a(this.zzP, localbi, paramView.fDU, paramView.cFn, localaz.userName, localaz.chatroomName, arrayOfInt, i, j, false);
              break;
            }
            localObject1 = paramView.fDM;
            if (com.tencent.mm.vfs.e.cN(o.ahC().q((String)localObject1, "", "")))
            {
              a(this.zzP, localbi, paramView.fDU, paramView.cFn, localaz.userName, localaz.chatroomName, arrayOfInt, i, j, false);
              break;
            }
            a(localbi.field_msgId, localbi.field_msgSvrId, localaz.userName, localaz.chatroomName, arrayOfInt, i, j);
            break;
          }
          if (paramView.ahg())
          {
            localObject2 = paramView.fDM;
            localObject1 = localObject2;
            if (paramView.ahh())
            {
              com.tencent.mm.at.e locale = com.tencent.mm.at.f.a(paramView);
              localObject1 = localObject2;
              if (locale != null)
              {
                localObject1 = localObject2;
                if (locale.fDL > 0L)
                {
                  localObject1 = localObject2;
                  if (locale.ahg())
                  {
                    localObject1 = localObject2;
                    if (com.tencent.mm.vfs.e.cN(o.ahC().q(locale.fDM, "", ""))) {
                      localObject1 = locale.fDM;
                    }
                  }
                }
              }
            }
            if (com.tencent.mm.vfs.e.cN(o.ahC().q((String)localObject1, "", "")))
            {
              a(this.zzP, localbi, paramView.fDU, paramView.cFn, localaz.userName, localaz.chatroomName, arrayOfInt, i, j, false);
              break;
            }
            ab.i("MicroMsg.DesignerClickListener", "retry downloadImg, %d", new Object[] { Long.valueOf(paramView.fDL) });
            paramView.sW("SERVERID://" + localbi.field_msgSvrId);
            paramView.bsY = 16;
            paramView.lq(0);
            paramView.bsY = 8;
            paramView.setStatus(0);
            paramView.bsY = 256;
            o.ahC().a(Long.valueOf(paramView.fDL), paramView);
          }
          for (;;)
          {
            a(localbi.field_msgId, localbi.field_msgSvrId, localaz.userName, localaz.chatroomName, arrayOfInt, i, j);
            break;
            if (paramView.status == -1)
            {
              ab.i("MicroMsg.DesignerClickListener", "retry downloadImg, %d", new Object[] { Long.valueOf(paramView.fDL) });
              paramView.setStatus(0);
              paramView.bsY = 256;
              o.ahC().a(Long.valueOf(paramView.fDL), paramView);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ae
 * JD-Core Version:    0.7.0.1
 */