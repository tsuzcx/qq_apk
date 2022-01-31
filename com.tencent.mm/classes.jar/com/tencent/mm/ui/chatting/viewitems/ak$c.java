package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.R.l;
import com.tencent.mm.h.a.pf;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.network.ab;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.t.d;
import com.tencent.mm.ui.x;

public final class ak$c
  extends t.d
{
  public static boolean vwL = false;
  
  public ak$c(com.tencent.mm.ui.chatting.c.a parama)
  {
    super(parama);
  }
  
  private void i(com.tencent.mm.modelvideo.s params)
  {
    au.Hx();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.s.gM(this.vko.vtz.getContext());
      return;
    }
    if (params.status == 198)
    {
      u.oc(params.getFileName());
      return;
    }
    if ((!ab.bG(this.vko.vtz.getContext())) && (!vwL))
    {
      vwL = true;
      com.tencent.mm.ui.base.h.a(this.vko.vtz.getContext(), R.l.video_export_file_warning, R.l.app_tip, new ak.c.1(this, params), new ak.c.2(this));
      return;
    }
    u.oa(params.getFileName());
  }
  
  public final void a(View paramView, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    parama = (aw)paramView.getTag();
    b.eBD.z(parama.bWO);
    parama = (ak.e)parama;
    com.tencent.mm.modelstat.a.a(parama.bWO, com.tencent.mm.modelstat.a.a.eBA);
    Object localObject2;
    int j;
    if (2 == parama.ivk)
    {
      if ((com.tencent.mm.r.a.bk(this.vko.vtz.getContext())) || (com.tencent.mm.r.a.bi(this.vko.vtz.getContext())))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.DesignerClickListener", "Voip or multitalk is running, can't do this");
        return;
      }
      parambi = parama.bWO;
      localObject2 = new int[2];
      j = 0;
      if (paramView == null) {
        break label1357;
      }
      paramView.getLocationInWindow((int[])localObject2);
      j = paramView.getWidth();
    }
    label541:
    label562:
    label1357:
    for (int i = paramView.getHeight();; i = 0)
    {
      long l1 = parambi.field_msgId;
      long l2 = parambi.field_msgSvrId;
      paramView = parama.userName;
      Object localObject3 = parama.chatroomName;
      Object localObject1 = new Intent(this.vko.vtz.getContext(), ImageGalleryUI.class);
      ((Intent)localObject1).putExtra("show_search_chat_content_result", ((com.tencent.mm.ui.chatting.b.b.y)this.vko.ac(com.tencent.mm.ui.chatting.b.b.y.class)).cFj());
      ((Intent)localObject1).putExtra("img_gallery_msg_id", l1);
      ((Intent)localObject1).putExtra("key_is_biz_chat", ((com.tencent.mm.ui.chatting.b.b.c)this.vko.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDG());
      ((Intent)localObject1).putExtra("key_biz_chat_id", ((com.tencent.mm.ui.chatting.b.b.c)this.vko.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDS());
      ((Intent)localObject1).putExtra("img_gallery_msg_svr_id", l2);
      ((Intent)localObject1).putExtra("img_gallery_talker", paramView);
      ((Intent)localObject1).putExtra("img_gallery_chatroom_name", (String)localObject3);
      ((Intent)localObject1).putExtra("img_gallery_left", localObject2[0]);
      ((Intent)localObject1).putExtra("img_gallery_top", localObject2[1]);
      ((Intent)localObject1).putExtra("img_gallery_width", j);
      ((Intent)localObject1).putExtra("img_gallery_height", i);
      ((Intent)localObject1).putExtra("img_gallery_enter_from_chatting_ui", ((com.tencent.mm.ui.chatting.b.b.y)this.vko.ac(com.tencent.mm.ui.chatting.b.b.y.class)).cFe());
      localObject2 = this.vko.getTalkerUserName();
      if (parambi.field_isSend == 1)
      {
        paramView = this.vko.cFB();
        label368:
        localObject3 = new Bundle();
        if (!this.vko.cFE()) {
          break label541;
        }
        i = 2;
      }
      for (;;)
      {
        ((Bundle)localObject3).putInt("stat_scene", i);
        ((Bundle)localObject3).putString("stat_msg_id", "msg_" + Long.toString(l2));
        ((Bundle)localObject3).putString("stat_chat_talker_username", (String)localObject2);
        ((Bundle)localObject3).putString("stat_send_msg_user", paramView);
        ((Intent)localObject1).putExtra("_stat_obj", (Bundle)localObject3);
        this.vko.startActivity((Intent)localObject1);
        this.vko.vtz.overridePendingTransition(0, 0);
        if ((!parambi.aRR()) || (parama.userName == null)) {
          break;
        }
        com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.a.vgb, parambi);
        if (!parama.userName.toLowerCase().endsWith("@chatroom")) {
          break label562;
        }
        com.tencent.mm.plugin.report.service.h.nFQ.f(11444, new Object[] { Integer.valueOf(2) });
        return;
        break label368;
        if (com.tencent.mm.model.s.hl((String)localObject2)) {
          i = 7;
        } else {
          i = 1;
        }
      }
      com.tencent.mm.plugin.report.service.h.nFQ.f(11444, new Object[] { Integer.valueOf(1) });
      return;
      paramView = parama.bWO;
      if (paramView.field_isSend == 0)
      {
        parambi = parama.bWO;
        localObject1 = u.oe(parambi.field_imgPath);
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.DesignerClickListener", "videoReceiverEvent video status:" + ((com.tencent.mm.modelvideo.s)localObject1).status + " is sender:" + parambi.field_isSend);
        switch (parama.ivk)
        {
        }
      }
      while (paramView.field_isSend == 1)
      {
        paramView = parama.bWO;
        if (paramView != null) {
          break label748;
        }
        com.tencent.mm.sdk.platformtools.y.w("MicroMsg.DesignerClickListener", "videoSendEvent but msg is null ");
        return;
        au.Hx();
        if (!com.tencent.mm.model.c.isSDCardAvailable())
        {
          com.tencent.mm.ui.base.s.gM(this.vko.vtz.getContext());
        }
        else
        {
          u.ob(parambi.field_imgPath);
          continue;
          i((com.tencent.mm.modelvideo.s)localObject1);
        }
      }
      break;
      label748:
      parambi = o.Sr().nQ(paramView.field_imgPath);
      if (parambi == null)
      {
        com.tencent.mm.sdk.platformtools.y.w("MicroMsg.DesignerClickListener", "videoSendEvent but video info is null [%s]", new Object[] { paramView.field_imgPath });
        return;
      }
      i = parambi.status;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.DesignerClickListener", " videoSendEvent status : " + i);
      switch (parama.ivk)
      {
      default: 
        return;
      case 3: 
        au.Hx();
        if (!com.tencent.mm.model.c.isSDCardAvailable())
        {
          com.tencent.mm.ui.base.s.gM(this.vko.vtz.getContext());
          return;
        }
        break;
      case 4: 
        au.Hx();
        if (!com.tencent.mm.model.c.isSDCardAvailable())
        {
          com.tencent.mm.ui.base.s.gM(this.vko.vtz.getContext());
          return;
        }
        if (i == 112)
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.DesignerClickListener", "this video come from pc weixin, user pause recv now.");
          u.ob(paramView.field_imgPath);
          return;
        }
        parama = paramView.field_imgPath;
        parambi = u.oe(parama);
        if (parambi == null)
        {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.zI() + " getinfo failed: " + parama);
          com.tencent.mm.compatible.util.g.getLine();
        }
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.y.d("MicroMsg.DesignerClickListener", "pause video, publish SendMsgFailEvent");
          parama = new pf();
          parama.bYS.bFH = paramView;
          com.tencent.mm.sdk.b.a.udP.m(parama);
          return;
          if ((parambi.status != 104) && (parambi.status != 103))
          {
            com.tencent.mm.sdk.platformtools.y.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.zI() + " get status failed: " + parama + " status:" + parambi.status);
            com.tencent.mm.compatible.util.g.getLine();
          }
          else
          {
            parambi.status = 105;
            parambi.eHF = bk.UX();
            parambi.bcw = 1280;
            if (!u.f(parambi))
            {
              com.tencent.mm.sdk.platformtools.y.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.zI() + " update failed: " + parama);
              com.tencent.mm.compatible.util.g.getLine();
            }
          }
        }
      }
      if (i == 113)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.DesignerClickListener", "this video come from pc weixin, user restart now.");
        i(parambi);
        return;
      }
      if (parambi.SE())
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.DesignerClickListener", "this video come from gallery, but it is illegal.");
        paramView = this.vko.vtz.getContext().getString(R.l.video_export_file_error);
        if (i == 142) {
          paramView = this.vko.vtz.getContext().getString(R.l.video_export_file_error);
        }
        for (;;)
        {
          com.tencent.mm.ui.base.h.b(this.vko.vtz.getContext(), paramView, this.vko.vtz.getContext().getString(R.l.tip_title), true);
          return;
          if (i == 141) {
            paramView = this.vko.vtz.getContext().getString(R.l.video_export_file_too_big);
          } else if (i == 140) {
            paramView = this.vko.vtz.getContext().getString(R.l.video_export_duration_too_long);
          }
        }
      }
      paramView.cvz();
      au.Hx();
      com.tencent.mm.model.c.Fy().a(paramView.field_msgId, paramView);
      if (parambi.status == 198)
      {
        u.od(paramView.field_imgPath);
        return;
      }
      u.nZ(paramView.field_imgPath);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ak.c
 * JD-Core Version:    0.7.0.1
 */