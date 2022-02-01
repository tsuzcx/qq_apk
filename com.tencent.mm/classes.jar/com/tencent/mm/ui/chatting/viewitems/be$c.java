package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tx;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.network.ag;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.am;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.t.e;

public final class be$c
  extends t.e
{
  public static boolean PAp = false;
  private int scene;
  
  public be$c(com.tencent.mm.ui.chatting.e.a parama)
  {
    super(parama);
    this.scene = 0;
  }
  
  public be$c(com.tencent.mm.ui.chatting.e.a parama, ca paramca, View paramView)
  {
    super(parama);
    AppMethodBeat.i(37449);
    this.scene = 0;
    this.scene = 1;
    if (this.scene == 1)
    {
      b.jmd.ae(paramca);
      parama = new be.e(paramca, this.PhN.gRM(), 0, paramca.field_talker);
      parama.qcr = 2;
      a(parama, paramView);
    }
    AppMethodBeat.o(37449);
  }
  
  private void a(be.e parame)
  {
    AppMethodBeat.i(37452);
    ca localca = parame.dTX;
    s locals = com.tencent.mm.modelvideo.u.QN(localca.field_imgPath);
    Log.i("MicroMsg.DesignerClickListener", "videoReceiverEvent video status:" + locals.status + " is sender:" + localca.field_isSend);
    switch (parame.qcr)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(37452);
      return;
      bg.aVF();
      if (!c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.u.g(this.PhN.Pwc.getContext(), this.PhN.Pwc.getContentView());
        AppMethodBeat.o(37452);
        return;
      }
      com.tencent.mm.modelvideo.u.QJ(localca.field_imgPath);
      AppMethodBeat.o(37452);
      return;
      i(locals);
    }
  }
  
  private void a(be.e parame, View paramView)
  {
    AppMethodBeat.i(37451);
    com.tencent.mm.modelstat.a.a(parame.dTX, com.tencent.mm.modelstat.a.a.jma);
    if (2 == parame.qcr)
    {
      if ((com.tencent.mm.q.a.cC(this.PhN.Pwc.getContext())) || (com.tencent.mm.q.a.cA(this.PhN.Pwc.getContext())) || (com.tencent.mm.q.a.cE(this.PhN.Pwc.getContext())))
      {
        Log.i("MicroMsg.DesignerClickListener", "Voip or multitalk is running, can't do this");
        AppMethodBeat.o(37451);
        return;
      }
      ca localca = parame.dTX;
      int[] arrayOfInt = new int[2];
      int i = 0;
      int j = 0;
      if (paramView != null)
      {
        paramView.getLocationOnScreen(arrayOfInt);
        i = paramView.getWidth();
        j = paramView.getHeight();
      }
      a(localca, localca.field_msgId, localca.field_msgSvrId, parame.userName, parame.chatroomName, arrayOfInt, i, j, this.scene);
      if ((localca.cWL()) && (parame.userName != null))
      {
        com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.a.PcJ, localca);
        if (parame.userName.toLowerCase().endsWith("@chatroom"))
        {
          com.tencent.mm.plugin.report.service.h.CyF.a(11444, new Object[] { Integer.valueOf(2) });
          AppMethodBeat.o(37451);
          return;
        }
        com.tencent.mm.plugin.report.service.h.CyF.a(11444, new Object[] { Integer.valueOf(1) });
      }
      AppMethodBeat.o(37451);
      return;
    }
    paramView = parame.dTX;
    if (paramView.field_isSend == 0) {
      a(parame);
    }
    if (paramView.field_isSend == 1) {
      b(parame);
    }
    AppMethodBeat.o(37451);
  }
  
  private boolean a(ca paramca, long paramLong1, long paramLong2, String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(37455);
    Log.i("MicroMsg.DesignerClickListener", "[ImageGalleryUI] showImgGallery");
    Intent localIntent = new Intent(this.PhN.Pwc.getContext(), ImageGalleryUI.class);
    localIntent.putExtra("show_search_chat_content_result", ((am)this.PhN.bh(am.class)).gQZ());
    localIntent.putExtra("img_gallery_msg_id", paramLong1);
    localIntent.putExtra("key_is_biz_chat", ((d)this.PhN.bh(d.class)).gOP());
    localIntent.putExtra("key_biz_chat_id", ((d)this.PhN.bh(d.class)).gPc());
    localIntent.putExtra("img_gallery_msg_svr_id", paramLong2);
    localIntent.putExtra("img_gallery_talker", paramString1);
    localIntent.putExtra("img_gallery_chatroom_name", paramString2);
    localIntent.putExtra("img_gallery_left", paramArrayOfInt[0]);
    localIntent.putExtra("img_gallery_top", paramArrayOfInt[1]);
    localIntent.putExtra("img_gallery_width", paramInt1);
    localIntent.putExtra("img_gallery_height", paramInt2);
    localIntent.putExtra("KOpenArticleSceneFromScene", 1);
    localIntent.putExtra("img_gallery_enter_from_chatting_ui", true);
    localIntent.putExtra("msg_type", paramInt3);
    if (paramInt3 == 1) {
      localIntent.putExtra("show_enter_grid", false);
    }
    paramString2 = this.PhN.getTalkerUserName();
    if (paramca.field_isSend == 1) {
      paramString1 = this.PhN.gRI();
    }
    paramArrayOfInt = new Bundle();
    if (this.PhN.gRM()) {
      paramInt1 = 2;
    }
    for (;;)
    {
      paramArrayOfInt.putInt("stat_scene", paramInt1);
      paramArrayOfInt.putString("stat_msg_id", "msg_" + Long.toString(paramLong2));
      paramArrayOfInt.putString("stat_chat_talker_username", paramString2);
      paramArrayOfInt.putString("stat_send_msg_user", paramString1);
      localIntent.putExtra("_stat_obj", paramArrayOfInt);
      if (paramca.cWK()) {
        localIntent.putExtra("img_gallery_mp_video_click_from", 2);
      }
      paramca = this.PhN;
      paramString1 = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramca, paramString1.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVideo$VideoClickListener", "showImgGallery", "(Lcom/tencent/mm/storage/MsgInfo;JJLjava/lang/String;Ljava/lang/String;[IIII)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramca.startActivity((Intent)paramString1.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramca, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVideo$VideoClickListener", "showImgGallery", "(Lcom/tencent/mm/storage/MsgInfo;JJLjava/lang/String;Ljava/lang/String;[IIII)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      this.PhN.Pwc.overridePendingTransition(0, 0);
      AppMethodBeat.o(37455);
      return true;
      if (ab.IT(paramString2)) {
        paramInt1 = 7;
      } else {
        paramInt1 = 1;
      }
    }
  }
  
  private void b(be.e parame)
  {
    AppMethodBeat.i(37454);
    ca localca = parame.dTX;
    if (localca == null)
    {
      Log.w("MicroMsg.DesignerClickListener", "videoSendEvent but msg is null ");
      AppMethodBeat.o(37454);
      return;
    }
    s locals = o.bhj().Qq(localca.field_imgPath);
    if (locals == null)
    {
      Log.w("MicroMsg.DesignerClickListener", "videoSendEvent but video info is null [%s]", new Object[] { localca.field_imgPath });
      AppMethodBeat.o(37454);
      return;
    }
    int i = locals.status;
    Log.i("MicroMsg.DesignerClickListener", " videoSendEvent status : ".concat(String.valueOf(i)));
    switch (parame.qcr)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(37454);
      return;
      bg.aVF();
      if (!c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.u.g(this.PhN.Pwc.getContext(), this.PhN.Pwc.getContentView());
        AppMethodBeat.o(37454);
        return;
      }
      if (i == 112)
      {
        Log.i("MicroMsg.DesignerClickListener", "this video come from pc weixin, user pause recv now.");
        com.tencent.mm.modelvideo.u.QJ(localca.field_imgPath);
        AppMethodBeat.o(37454);
        return;
      }
      com.tencent.mm.modelvideo.u.QH(localca.field_imgPath);
      Log.d("MicroMsg.DesignerClickListener", "pause video, publish SendMsgFailEvent");
      parame = new tx();
      parame.ear.dCM = localca;
      EventCenter.instance.publish(parame);
      AppMethodBeat.o(37454);
      return;
      bg.aVF();
      if (!c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.u.g(this.PhN.Pwc.getContext(), this.PhN.Pwc.getContentView());
        AppMethodBeat.o(37454);
        return;
      }
      if (i == 113)
      {
        Log.i("MicroMsg.DesignerClickListener", "this video come from pc weixin, user restart now.");
        i(locals);
        AppMethodBeat.o(37454);
        return;
      }
      if (locals.bhw())
      {
        Log.e("MicroMsg.DesignerClickListener", "this video come from gallery, but it is illegal.");
        parame = this.PhN.Pwc.getContext().getString(2131767067);
        if (i == 142) {
          parame = this.PhN.Pwc.getContext().getString(2131767067);
        }
        for (;;)
        {
          com.tencent.mm.ui.base.h.c(this.PhN.Pwc.getContext(), parame, this.PhN.Pwc.getContext().getString(2131766783), true);
          AppMethodBeat.o(37454);
          return;
          if (i == 141) {
            parame = this.PhN.Pwc.getContext().getString(2131767068);
          } else if (i == 140) {
            parame = this.PhN.Pwc.getContext().getString(2131767066);
          }
        }
      }
      localca.unsetOmittedFailResend();
      bg.aVF();
      c.aSQ().a(localca.field_msgId, localca);
      if (locals.status == 198)
      {
        com.tencent.mm.modelvideo.u.QL(localca.field_imgPath);
        AppMethodBeat.o(37454);
        return;
      }
      com.tencent.mm.modelvideo.u.QG(localca.field_imgPath);
    }
  }
  
  private void i(final s params)
  {
    AppMethodBeat.i(37453);
    bg.aVF();
    if (!c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.u.g(this.PhN.Pwc.getContext(), this.PhN.Pwc.getContentView());
      AppMethodBeat.o(37453);
      return;
    }
    if (params.status == 198)
    {
      com.tencent.mm.modelvideo.u.QK(params.getFileName());
      AppMethodBeat.o(37453);
      return;
    }
    if ((!ag.dm(this.PhN.Pwc.getContext())) && (!PAp))
    {
      PAp = true;
      com.tencent.mm.ui.base.h.a(this.PhN.Pwc.getContext(), 2131767069, 2131755998, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(37448);
          be.c.bnm(params.getFileName());
          AppMethodBeat.o(37448);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(37453);
      return;
    }
    com.tencent.mm.modelvideo.u.QI(params.getFileName());
    AppMethodBeat.o(37453);
  }
  
  public final void a(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(37450);
    parama = (bq)paramView.getTag();
    b.jmd.ae(parama.dTX);
    a((be.e)parama, paramView);
    AppMethodBeat.o(37450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.be.c
 * JD-Core Version:    0.7.0.1
 */