package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.sc;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.s.e;

public final class aw$c
  extends s.e
{
  public static boolean GDn = false;
  private int scene;
  
  public aw$c(com.tencent.mm.ui.chatting.d.a parama)
  {
    super(parama);
    this.scene = 0;
  }
  
  public aw$c(com.tencent.mm.ui.chatting.d.a parama, bl parambl, View paramView)
  {
    super(parama);
    AppMethodBeat.i(37449);
    this.scene = 0;
    this.scene = 1;
    if (this.scene == 1)
    {
      b.huc.R(parambl);
      parama = new aw.e(parambl, this.Gob.eZb(), 0, parambl.field_talker);
      parama.nBH = 2;
      a(parama, paramView);
    }
    AppMethodBeat.o(37449);
  }
  
  private void a(aw.e parame)
  {
    AppMethodBeat.i(37452);
    bl localbl = parame.drF;
    s locals = u.Ae(localbl.field_imgPath);
    ad.i("MicroMsg.DesignerClickListener", "videoReceiverEvent video status:" + locals.status + " is sender:" + localbl.field_isSend);
    switch (parame.nBH)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(37452);
      return;
      az.arV();
      if (!c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.t.g(this.Gob.GzJ.getContext(), this.Gob.GzJ.getContentView());
        AppMethodBeat.o(37452);
        return;
      }
      u.Aa(localbl.field_imgPath);
      AppMethodBeat.o(37452);
      return;
      i(locals);
    }
  }
  
  private void a(aw.e parame, View paramView)
  {
    AppMethodBeat.i(37451);
    com.tencent.mm.modelstat.a.a(parame.drF, com.tencent.mm.modelstat.a.a.htZ);
    if (2 == parame.nBH)
    {
      if ((com.tencent.mm.r.a.ce(this.Gob.GzJ.getContext())) || (com.tencent.mm.r.a.cc(this.Gob.GzJ.getContext())))
      {
        ad.i("MicroMsg.DesignerClickListener", "Voip or multitalk is running, can't do this");
        AppMethodBeat.o(37451);
        return;
      }
      bl localbl = parame.drF;
      int[] arrayOfInt = new int[2];
      int i = 0;
      int j = 0;
      if (paramView != null)
      {
        paramView.getLocationInWindow(arrayOfInt);
        i = paramView.getWidth();
        j = paramView.getHeight();
      }
      a(localbl, localbl.field_msgId, localbl.field_msgSvrId, parame.userName, parame.chatroomName, arrayOfInt, i, j, this.scene);
      if ((localbl.cjO()) && (parame.userName != null))
      {
        com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.a.Gjj, localbl);
        if (parame.userName.toLowerCase().endsWith("@chatroom"))
        {
          com.tencent.mm.plugin.report.service.h.vKh.f(11444, new Object[] { Integer.valueOf(2) });
          AppMethodBeat.o(37451);
          return;
        }
        com.tencent.mm.plugin.report.service.h.vKh.f(11444, new Object[] { Integer.valueOf(1) });
      }
      AppMethodBeat.o(37451);
      return;
    }
    paramView = parame.drF;
    if (paramView.field_isSend == 0) {
      a(parame);
    }
    if (paramView.field_isSend == 1) {
      b(parame);
    }
    AppMethodBeat.o(37451);
  }
  
  private boolean a(bl parambl, long paramLong1, long paramLong2, String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(37455);
    ad.i("MicroMsg.DesignerClickListener", "[ImageGalleryUI] showImgGallery");
    Intent localIntent = new Intent(this.Gob.GzJ.getContext(), ImageGalleryUI.class);
    localIntent.putExtra("show_search_chat_content_result", ((com.tencent.mm.ui.chatting.c.b.ae)this.Gob.be(com.tencent.mm.ui.chatting.c.b.ae.class)).eYw());
    localIntent.putExtra("img_gallery_msg_id", paramLong1);
    localIntent.putExtra("key_is_biz_chat", ((d)this.Gob.be(d.class)).eWC());
    localIntent.putExtra("key_biz_chat_id", ((d)this.Gob.be(d.class)).eWP());
    localIntent.putExtra("img_gallery_msg_svr_id", paramLong2);
    localIntent.putExtra("img_gallery_talker", paramString1);
    localIntent.putExtra("img_gallery_chatroom_name", paramString2);
    localIntent.putExtra("img_gallery_left", paramArrayOfInt[0]);
    localIntent.putExtra("img_gallery_top", paramArrayOfInt[1]);
    localIntent.putExtra("img_gallery_width", paramInt1);
    localIntent.putExtra("img_gallery_height", paramInt2);
    localIntent.putExtra("KOpenArticleSceneFromScene", 1);
    localIntent.putExtra("img_gallery_enter_from_chatting_ui", ((com.tencent.mm.ui.chatting.c.b.ae)this.Gob.be(com.tencent.mm.ui.chatting.c.b.ae.class)).eYr());
    localIntent.putExtra("msg_type", paramInt3);
    if (paramInt3 == 1) {
      localIntent.putExtra("show_enter_grid", false);
    }
    paramString2 = this.Gob.getTalkerUserName();
    if (parambl.field_isSend == 1) {
      paramString1 = this.Gob.eYX();
    }
    parambl = new Bundle();
    if (this.Gob.eZb()) {
      paramInt1 = 2;
    }
    for (;;)
    {
      parambl.putInt("stat_scene", paramInt1);
      parambl.putString("stat_msg_id", "msg_" + Long.toString(paramLong2));
      parambl.putString("stat_chat_talker_username", paramString2);
      parambl.putString("stat_send_msg_user", paramString1);
      localIntent.putExtra("_stat_obj", parambl);
      parambl = this.Gob;
      paramString1 = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(parambl, paramString1.adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVideo$VideoClickListener", "showImgGallery", "(Lcom/tencent/mm/storage/MsgInfo;JJLjava/lang/String;Ljava/lang/String;[IIII)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parambl.startActivity((Intent)paramString1.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(parambl, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVideo$VideoClickListener", "showImgGallery", "(Lcom/tencent/mm/storage/MsgInfo;JJLjava/lang/String;Ljava/lang/String;[IIII)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      this.Gob.GzJ.overridePendingTransition(0, 0);
      AppMethodBeat.o(37455);
      return true;
      if (w.sE(paramString2)) {
        paramInt1 = 7;
      } else {
        paramInt1 = 1;
      }
    }
  }
  
  private void b(aw.e parame)
  {
    AppMethodBeat.i(37454);
    bl localbl = parame.drF;
    if (localbl == null)
    {
      ad.w("MicroMsg.DesignerClickListener", "videoSendEvent but msg is null ");
      AppMethodBeat.o(37454);
      return;
    }
    s locals = o.aCI().zO(localbl.field_imgPath);
    if (locals == null)
    {
      ad.w("MicroMsg.DesignerClickListener", "videoSendEvent but video info is null [%s]", new Object[] { localbl.field_imgPath });
      AppMethodBeat.o(37454);
      return;
    }
    int i = locals.status;
    ad.i("MicroMsg.DesignerClickListener", " videoSendEvent status : ".concat(String.valueOf(i)));
    switch (parame.nBH)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(37454);
      return;
      az.arV();
      if (!c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.t.g(this.Gob.GzJ.getContext(), this.Gob.GzJ.getContentView());
        AppMethodBeat.o(37454);
        return;
      }
      if (i == 112)
      {
        ad.i("MicroMsg.DesignerClickListener", "this video come from pc weixin, user pause recv now.");
        u.Aa(localbl.field_imgPath);
        AppMethodBeat.o(37454);
        return;
      }
      u.zY(localbl.field_imgPath);
      ad.d("MicroMsg.DesignerClickListener", "pause video, publish SendMsgFailEvent");
      parame = new sc();
      parame.dxL.dbD = localbl;
      com.tencent.mm.sdk.b.a.ESL.l(parame);
      AppMethodBeat.o(37454);
      return;
      az.arV();
      if (!c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.t.g(this.Gob.GzJ.getContext(), this.Gob.GzJ.getContentView());
        AppMethodBeat.o(37454);
        return;
      }
      if (i == 113)
      {
        ad.i("MicroMsg.DesignerClickListener", "this video come from pc weixin, user restart now.");
        i(locals);
        AppMethodBeat.o(37454);
        return;
      }
      if (locals.aCU())
      {
        ad.e("MicroMsg.DesignerClickListener", "this video come from gallery, but it is illegal.");
        parame = this.Gob.GzJ.getContext().getString(2131764674);
        if (i == 142) {
          parame = this.Gob.GzJ.getContext().getString(2131764674);
        }
        for (;;)
        {
          com.tencent.mm.ui.base.h.c(this.Gob.GzJ.getContext(), parame, this.Gob.GzJ.getContext().getString(2131764439), true);
          AppMethodBeat.o(37454);
          return;
          if (i == 141) {
            parame = this.Gob.GzJ.getContext().getString(2131764675);
          } else if (i == 140) {
            parame = this.Gob.GzJ.getContext().getString(2131764673);
          }
        }
      }
      localbl.eMq();
      az.arV();
      c.apO().a(localbl.field_msgId, localbl);
      if (locals.status == 198)
      {
        u.Ac(localbl.field_imgPath);
        AppMethodBeat.o(37454);
        return;
      }
      u.zX(localbl.field_imgPath);
    }
  }
  
  private void i(final s params)
  {
    AppMethodBeat.i(37453);
    az.arV();
    if (!c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.t.g(this.Gob.GzJ.getContext(), this.Gob.GzJ.getContentView());
      AppMethodBeat.o(37453);
      return;
    }
    if (params.status == 198)
    {
      u.Ab(params.getFileName());
      AppMethodBeat.o(37453);
      return;
    }
    if ((!com.tencent.mm.network.ae.cJ(this.Gob.GzJ.getContext())) && (!GDn))
    {
      GDn = true;
      com.tencent.mm.ui.base.h.a(this.Gob.GzJ.getContext(), 2131764676, 2131755906, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(37448);
          aw.c.aLj(params.getFileName());
          AppMethodBeat.o(37448);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(37453);
      return;
    }
    u.zZ(params.getFileName());
    AppMethodBeat.o(37453);
  }
  
  public final void a(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(37450);
    parama = (bi)paramView.getTag();
    b.huc.R(parama.drF);
    a((aw.e)parama, paramView);
    AppMethodBeat.o(37450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aw.c
 * JD-Core Version:    0.7.0.1
 */