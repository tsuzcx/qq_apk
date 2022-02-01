package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.sl;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.s.e;

public final class ax$c
  extends s.e
{
  public static boolean Idk = false;
  private int scene;
  
  public ax$c(com.tencent.mm.ui.chatting.d.a parama)
  {
    super(parama);
    this.scene = 0;
  }
  
  public ax$c(com.tencent.mm.ui.chatting.d.a parama, bo parambo, View paramView)
  {
    super(parama);
    AppMethodBeat.i(37449);
    this.scene = 0;
    this.scene = 1;
    if (this.scene == 1)
    {
      b.hUE.R(parambo);
      parama = new ax.e(parambo, this.HNS.foQ(), 0, parambo.field_talker);
      parama.oeH = 2;
      a(parama, paramView);
    }
    AppMethodBeat.o(37449);
  }
  
  private void a(ax.e parame)
  {
    AppMethodBeat.i(37452);
    bo localbo = parame.dpq;
    s locals = u.Ej(localbo.field_imgPath);
    ac.i("MicroMsg.DesignerClickListener", "videoReceiverEvent video status:" + locals.status + " is sender:" + localbo.field_isSend);
    switch (parame.oeH)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(37452);
      return;
      az.ayM();
      if (!c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.t.g(this.HNS.HZF.getContext(), this.HNS.HZF.getContentView());
        AppMethodBeat.o(37452);
        return;
      }
      u.Ef(localbo.field_imgPath);
      AppMethodBeat.o(37452);
      return;
      i(locals);
    }
  }
  
  private void a(ax.e parame, View paramView)
  {
    AppMethodBeat.i(37451);
    com.tencent.mm.modelstat.a.a(parame.dpq, com.tencent.mm.modelstat.a.a.hUB);
    if (2 == parame.oeH)
    {
      if ((com.tencent.mm.r.a.ci(this.HNS.HZF.getContext())) || (com.tencent.mm.r.a.cf(this.HNS.HZF.getContext())) || (com.tencent.mm.r.a.ck(this.HNS.HZF.getContext())))
      {
        ac.i("MicroMsg.DesignerClickListener", "Voip or multitalk is running, can't do this");
        AppMethodBeat.o(37451);
        return;
      }
      bo localbo = parame.dpq;
      int[] arrayOfInt = new int[2];
      int i = 0;
      int j = 0;
      if (paramView != null)
      {
        paramView.getLocationInWindow(arrayOfInt);
        i = paramView.getWidth();
        j = paramView.getHeight();
      }
      a(localbo, localbo.field_msgId, localbo.field_msgSvrId, parame.userName, parame.chatroomName, arrayOfInt, i, j, this.scene);
      if ((localbo.crv()) && (parame.userName != null))
      {
        com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.a.HIY, localbo);
        if (parame.userName.toLowerCase().endsWith("@chatroom"))
        {
          com.tencent.mm.plugin.report.service.h.wUl.f(11444, new Object[] { Integer.valueOf(2) });
          AppMethodBeat.o(37451);
          return;
        }
        com.tencent.mm.plugin.report.service.h.wUl.f(11444, new Object[] { Integer.valueOf(1) });
      }
      AppMethodBeat.o(37451);
      return;
    }
    paramView = parame.dpq;
    if (paramView.field_isSend == 0) {
      a(parame);
    }
    if (paramView.field_isSend == 1) {
      b(parame);
    }
    AppMethodBeat.o(37451);
  }
  
  private boolean a(bo parambo, long paramLong1, long paramLong2, String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(37455);
    ac.i("MicroMsg.DesignerClickListener", "[ImageGalleryUI] showImgGallery");
    Intent localIntent = new Intent(this.HNS.HZF.getContext(), ImageGalleryUI.class);
    localIntent.putExtra("show_search_chat_content_result", ((com.tencent.mm.ui.chatting.c.b.ae)this.HNS.bf(com.tencent.mm.ui.chatting.c.b.ae.class)).foi());
    localIntent.putExtra("img_gallery_msg_id", paramLong1);
    localIntent.putExtra("key_is_biz_chat", ((d)this.HNS.bf(d.class)).fmo());
    localIntent.putExtra("key_biz_chat_id", ((d)this.HNS.bf(d.class)).fmB());
    localIntent.putExtra("img_gallery_msg_svr_id", paramLong2);
    localIntent.putExtra("img_gallery_talker", paramString1);
    localIntent.putExtra("img_gallery_chatroom_name", paramString2);
    localIntent.putExtra("img_gallery_left", paramArrayOfInt[0]);
    localIntent.putExtra("img_gallery_top", paramArrayOfInt[1]);
    localIntent.putExtra("img_gallery_width", paramInt1);
    localIntent.putExtra("img_gallery_height", paramInt2);
    localIntent.putExtra("KOpenArticleSceneFromScene", 1);
    localIntent.putExtra("img_gallery_enter_from_chatting_ui", ((com.tencent.mm.ui.chatting.c.b.ae)this.HNS.bf(com.tencent.mm.ui.chatting.c.b.ae.class)).fod());
    localIntent.putExtra("msg_type", paramInt3);
    if (paramInt3 == 1) {
      localIntent.putExtra("show_enter_grid", false);
    }
    paramString2 = this.HNS.getTalkerUserName();
    if (parambo.field_isSend == 1) {
      paramString1 = this.HNS.foM();
    }
    parambo = new Bundle();
    if (this.HNS.foQ()) {
      paramInt1 = 2;
    }
    for (;;)
    {
      parambo.putInt("stat_scene", paramInt1);
      parambo.putString("stat_msg_id", "msg_" + Long.toString(paramLong2));
      parambo.putString("stat_chat_talker_username", paramString2);
      parambo.putString("stat_send_msg_user", paramString1);
      localIntent.putExtra("_stat_obj", parambo);
      parambo = this.HNS;
      paramString1 = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(parambo, paramString1.aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVideo$VideoClickListener", "showImgGallery", "(Lcom/tencent/mm/storage/MsgInfo;JJLjava/lang/String;Ljava/lang/String;[IIII)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parambo.startActivity((Intent)paramString1.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(parambo, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVideo$VideoClickListener", "showImgGallery", "(Lcom/tencent/mm/storage/MsgInfo;JJLjava/lang/String;Ljava/lang/String;[IIII)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      this.HNS.HZF.overridePendingTransition(0, 0);
      AppMethodBeat.o(37455);
      return true;
      if (w.wH(paramString2)) {
        paramInt1 = 7;
      } else {
        paramInt1 = 1;
      }
    }
  }
  
  private void b(ax.e parame)
  {
    AppMethodBeat.i(37454);
    bo localbo = parame.dpq;
    if (localbo == null)
    {
      ac.w("MicroMsg.DesignerClickListener", "videoSendEvent but msg is null ");
      AppMethodBeat.o(37454);
      return;
    }
    s locals = o.aJy().DT(localbo.field_imgPath);
    if (locals == null)
    {
      ac.w("MicroMsg.DesignerClickListener", "videoSendEvent but video info is null [%s]", new Object[] { localbo.field_imgPath });
      AppMethodBeat.o(37454);
      return;
    }
    int i = locals.status;
    ac.i("MicroMsg.DesignerClickListener", " videoSendEvent status : ".concat(String.valueOf(i)));
    switch (parame.oeH)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(37454);
      return;
      az.ayM();
      if (!c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.t.g(this.HNS.HZF.getContext(), this.HNS.HZF.getContentView());
        AppMethodBeat.o(37454);
        return;
      }
      if (i == 112)
      {
        ac.i("MicroMsg.DesignerClickListener", "this video come from pc weixin, user pause recv now.");
        u.Ef(localbo.field_imgPath);
        AppMethodBeat.o(37454);
        return;
      }
      u.Ed(localbo.field_imgPath);
      ac.d("MicroMsg.DesignerClickListener", "pause video, publish SendMsgFailEvent");
      parame = new sl();
      parame.dvx.cZc = localbo;
      com.tencent.mm.sdk.b.a.GpY.l(parame);
      AppMethodBeat.o(37454);
      return;
      az.ayM();
      if (!c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.t.g(this.HNS.HZF.getContext(), this.HNS.HZF.getContentView());
        AppMethodBeat.o(37454);
        return;
      }
      if (i == 113)
      {
        ac.i("MicroMsg.DesignerClickListener", "this video come from pc weixin, user restart now.");
        i(locals);
        AppMethodBeat.o(37454);
        return;
      }
      if (locals.aJL())
      {
        ac.e("MicroMsg.DesignerClickListener", "this video come from gallery, but it is illegal.");
        parame = this.HNS.HZF.getContext().getString(2131764674);
        if (i == 142) {
          parame = this.HNS.HZF.getContext().getString(2131764674);
        }
        for (;;)
        {
          com.tencent.mm.ui.base.h.c(this.HNS.HZF.getContext(), parame, this.HNS.HZF.getContext().getString(2131764439), true);
          AppMethodBeat.o(37454);
          return;
          if (i == 141) {
            parame = this.HNS.HZF.getContext().getString(2131764675);
          } else if (i == 140) {
            parame = this.HNS.HZF.getContext().getString(2131764673);
          }
        }
      }
      localbo.fbV();
      az.ayM();
      c.awD().a(localbo.field_msgId, localbo);
      if (locals.status == 198)
      {
        u.Eh(localbo.field_imgPath);
        AppMethodBeat.o(37454);
        return;
      }
      u.Ec(localbo.field_imgPath);
    }
  }
  
  private void i(final s params)
  {
    AppMethodBeat.i(37453);
    az.ayM();
    if (!c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.t.g(this.HNS.HZF.getContext(), this.HNS.HZF.getContentView());
      AppMethodBeat.o(37453);
      return;
    }
    if (params.status == 198)
    {
      u.Eg(params.getFileName());
      AppMethodBeat.o(37453);
      return;
    }
    if ((!com.tencent.mm.network.ae.cS(this.HNS.HZF.getContext())) && (!Idk))
    {
      Idk = true;
      com.tencent.mm.ui.base.h.a(this.HNS.HZF.getContext(), 2131764676, 2131755906, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(37448);
          ax.c.aQN(params.getFileName());
          AppMethodBeat.o(37448);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(37453);
      return;
    }
    u.Ee(params.getFileName());
    AppMethodBeat.o(37453);
  }
  
  public final void a(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(37450);
    parama = (bj)paramView.getTag();
    b.hUE.R(parama.dpq);
    a((ax.e)parama, paramView);
    AppMethodBeat.o(37450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ax.c
 * JD-Core Version:    0.7.0.1
 */