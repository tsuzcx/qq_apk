package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.g.a.qk;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.network.ac;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.c.b.z;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.s.e;

public final class an$c
  extends s.e
{
  public static boolean zMW = false;
  
  public an$c(com.tencent.mm.ui.chatting.d.a parama)
  {
    super(parama);
  }
  
  private void i(s params)
  {
    AppMethodBeat.i(33348);
    aw.aaz();
    if (!c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.t.ii(this.zzP.zJz.getContext());
      AppMethodBeat.o(33348);
      return;
    }
    if (params.status == 198)
    {
      u.vp(params.getFileName());
      AppMethodBeat.o(33348);
      return;
    }
    if ((!ac.cm(this.zzP.zJz.getContext())) && (!zMW))
    {
      zMW = true;
      com.tencent.mm.ui.base.h.a(this.zzP.zJz.getContext(), 2131304515, 2131297087, new an.c.1(this, params), new an.c.2(this));
      AppMethodBeat.o(33348);
      return;
    }
    u.vn(params.getFileName());
    AppMethodBeat.o(33348);
  }
  
  public final void a(View paramView, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(33347);
    parama = (az)paramView.getTag();
    b.fRu.F(parama.cEE);
    parama = (an.e)parama;
    com.tencent.mm.modelstat.a.a(parama.cEE, com.tencent.mm.modelstat.a.a.fRr);
    Object localObject2;
    int j;
    if (2 == parama.kwo)
    {
      if ((com.tencent.mm.r.a.bO(this.zzP.zJz.getContext())) || (com.tencent.mm.r.a.bM(this.zzP.zJz.getContext())))
      {
        ab.i("MicroMsg.DesignerClickListener", "Voip or multitalk is running, can't do this");
        AppMethodBeat.o(33347);
        return;
      }
      parambi = parama.cEE;
      localObject2 = new int[2];
      j = 0;
      if (paramView == null) {
        break label1427;
      }
      paramView.getLocationInWindow((int[])localObject2);
      j = paramView.getWidth();
    }
    label1427:
    for (int i = paramView.getHeight();; i = 0)
    {
      long l1 = parambi.field_msgId;
      long l2 = parambi.field_msgSvrId;
      paramView = parama.userName;
      Object localObject3 = parama.chatroomName;
      ab.i("MicroMsg.DesignerClickListener", "[ImageGalleryUI] showImgGallery");
      Object localObject1 = new Intent(this.zzP.zJz.getContext(), ImageGalleryUI.class);
      ((Intent)localObject1).putExtra("show_search_chat_content_result", ((z)this.zzP.ay(z.class)).dJb());
      ((Intent)localObject1).putExtra("img_gallery_msg_id", l1);
      ((Intent)localObject1).putExtra("key_is_biz_chat", ((d)this.zzP.ay(d.class)).dHv());
      ((Intent)localObject1).putExtra("key_biz_chat_id", ((d)this.zzP.ay(d.class)).dHI());
      ((Intent)localObject1).putExtra("img_gallery_msg_svr_id", l2);
      ((Intent)localObject1).putExtra("img_gallery_talker", paramView);
      ((Intent)localObject1).putExtra("img_gallery_chatroom_name", (String)localObject3);
      ((Intent)localObject1).putExtra("img_gallery_left", localObject2[0]);
      ((Intent)localObject1).putExtra("img_gallery_top", localObject2[1]);
      ((Intent)localObject1).putExtra("img_gallery_width", j);
      ((Intent)localObject1).putExtra("img_gallery_height", i);
      ((Intent)localObject1).putExtra("img_gallery_enter_from_chatting_ui", ((z)this.zzP.ay(z.class)).dIW());
      localObject2 = this.zzP.getTalkerUserName();
      if (parambi.field_isSend == 1)
      {
        paramView = this.zzP.dJD();
        localObject3 = new Bundle();
        if (!this.zzP.dJG()) {
          break label565;
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
        this.zzP.startActivity((Intent)localObject1);
        this.zzP.zJz.overridePendingTransition(0, 0);
        if ((!parambi.byk()) || (parama.userName == null)) {
          break label606;
        }
        com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.a.zuY, parambi);
        if (!parama.userName.toLowerCase().endsWith("@chatroom")) {
          break label586;
        }
        com.tencent.mm.plugin.report.service.h.qsU.e(11444, new Object[] { Integer.valueOf(2) });
        AppMethodBeat.o(33347);
        return;
        break;
        label565:
        if (com.tencent.mm.model.t.nU((String)localObject2)) {
          i = 7;
        } else {
          i = 1;
        }
      }
      label586:
      com.tencent.mm.plugin.report.service.h.qsU.e(11444, new Object[] { Integer.valueOf(1) });
      label606:
      AppMethodBeat.o(33347);
      return;
      paramView = parama.cEE;
      if (paramView.field_isSend == 0)
      {
        parambi = parama.cEE;
        localObject1 = u.vr(parambi.field_imgPath);
        ab.i("MicroMsg.DesignerClickListener", "videoReceiverEvent video status:" + ((s)localObject1).status + " is sender:" + parambi.field_isSend);
        switch (parama.kwo)
        {
        }
      }
      while (paramView.field_isSend == 1)
      {
        paramView = parama.cEE;
        if (paramView == null)
        {
          ab.w("MicroMsg.DesignerClickListener", "videoSendEvent but msg is null ");
          AppMethodBeat.o(33347);
          return;
          aw.aaz();
          if (!c.isSDCardAvailable())
          {
            com.tencent.mm.ui.base.t.ii(this.zzP.zJz.getContext());
          }
          else
          {
            u.vo(parambi.field_imgPath);
            continue;
            i((s)localObject1);
          }
        }
        else
        {
          parambi = o.alE().vd(paramView.field_imgPath);
          if (parambi == null)
          {
            ab.w("MicroMsg.DesignerClickListener", "videoSendEvent but video info is null [%s]", new Object[] { paramView.field_imgPath });
            AppMethodBeat.o(33347);
            return;
          }
          i = parambi.status;
          ab.i("MicroMsg.DesignerClickListener", " videoSendEvent status : ".concat(String.valueOf(i)));
          switch (parama.kwo)
          {
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(33347);
        return;
        aw.aaz();
        if (!c.isSDCardAvailable())
        {
          com.tencent.mm.ui.base.t.ii(this.zzP.zJz.getContext());
          AppMethodBeat.o(33347);
          return;
        }
        if (i == 112)
        {
          ab.i("MicroMsg.DesignerClickListener", "this video come from pc weixin, user pause recv now.");
          u.vo(paramView.field_imgPath);
          AppMethodBeat.o(33347);
          return;
        }
        parama = paramView.field_imgPath;
        parambi = u.vr(parama);
        if (parambi == null)
        {
          ab.e("MicroMsg.VideoLogic", "ERR:" + g.Ml() + " getinfo failed: " + parama);
          g.getLine();
        }
        for (;;)
        {
          ab.d("MicroMsg.DesignerClickListener", "pause video, publish SendMsgFailEvent");
          parama = new qk();
          parama.cGZ.cmQ = paramView;
          com.tencent.mm.sdk.b.a.ymk.l(parama);
          AppMethodBeat.o(33347);
          return;
          if ((parambi.status != 104) && (parambi.status != 103))
          {
            ab.e("MicroMsg.VideoLogic", "ERR:" + g.Ml() + " get status failed: " + parama + " status:" + parambi.status);
            g.getLine();
          }
          else
          {
            parambi.status = 105;
            parambi.fXv = bo.aox();
            parambi.bsY = 1280;
            if (!u.f(parambi))
            {
              ab.e("MicroMsg.VideoLogic", "ERR:" + g.Ml() + " update failed: " + parama);
              g.getLine();
            }
          }
        }
        aw.aaz();
        if (!c.isSDCardAvailable())
        {
          com.tencent.mm.ui.base.t.ii(this.zzP.zJz.getContext());
          AppMethodBeat.o(33347);
          return;
        }
        if (i == 113)
        {
          ab.i("MicroMsg.DesignerClickListener", "this video come from pc weixin, user restart now.");
          i(parambi);
          AppMethodBeat.o(33347);
          return;
        }
        if (parambi.alQ())
        {
          ab.e("MicroMsg.DesignerClickListener", "this video come from gallery, but it is illegal.");
          paramView = this.zzP.zJz.getContext().getString(2131304513);
          if (i == 142) {
            paramView = this.zzP.zJz.getContext().getString(2131304513);
          }
          for (;;)
          {
            com.tencent.mm.ui.base.h.b(this.zzP.zJz.getContext(), paramView, this.zzP.zJz.getContext().getString(2131304313), true);
            AppMethodBeat.o(33347);
            return;
            if (i == 141) {
              paramView = this.zzP.zJz.getContext().getString(2131304514);
            } else if (i == 140) {
              paramView = this.zzP.zJz.getContext().getString(2131304512);
            }
          }
        }
        paramView.dye();
        aw.aaz();
        c.YC().a(paramView.field_msgId, paramView);
        if (parambi.status == 198)
        {
          u.vq(paramView.field_imgPath);
          AppMethodBeat.o(33347);
          return;
        }
        u.vm(paramView.field_imgPath);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.an.c
 * JD-Core Version:    0.7.0.1
 */