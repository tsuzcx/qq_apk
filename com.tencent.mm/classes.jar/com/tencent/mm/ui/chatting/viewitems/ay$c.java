package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.network.ae;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.ai;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.s.e;

public final class ay$c
  extends s.e
{
  public static boolean JSM = false;
  private int scene;
  
  public ay$c(com.tencent.mm.ui.chatting.e.a parama)
  {
    super(parama);
    this.scene = 0;
  }
  
  public ay$c(com.tencent.mm.ui.chatting.e.a parama, bu parambu, View paramView)
  {
    super(parama);
    AppMethodBeat.i(37449);
    this.scene = 0;
    this.scene = 1;
    if (this.scene == 1)
    {
      b.inZ.U(parambu);
      parama = new ay.e(parambu, this.JBI.fFv(), 0, parambu.field_talker);
      parama.oIb = 2;
      a(parama, paramView);
    }
    AppMethodBeat.o(37449);
  }
  
  private void a(ay.e parame)
  {
    AppMethodBeat.i(37452);
    bu localbu = parame.dBd;
    s locals = u.Hy(localbu.field_imgPath);
    ad.i("MicroMsg.DesignerClickListener", "videoReceiverEvent video status:" + locals.status + " is sender:" + localbu.field_isSend);
    switch (parame.oIb)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(37452);
      return;
      ba.aBQ();
      if (!c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.t.g(this.JBI.JOR.getContext(), this.JBI.JOR.getContentView());
        AppMethodBeat.o(37452);
        return;
      }
      u.Hu(localbu.field_imgPath);
      AppMethodBeat.o(37452);
      return;
      i(locals);
    }
  }
  
  private void a(ay.e parame, View paramView)
  {
    AppMethodBeat.i(37451);
    com.tencent.mm.modelstat.a.a(parame.dBd, com.tencent.mm.modelstat.a.a.inW);
    if (2 == parame.oIb)
    {
      if ((com.tencent.mm.s.a.cf(this.JBI.JOR.getContext())) || (com.tencent.mm.s.a.cd(this.JBI.JOR.getContext())) || (com.tencent.mm.s.a.ch(this.JBI.JOR.getContext())))
      {
        ad.i("MicroMsg.DesignerClickListener", "Voip or multitalk is running, can't do this");
        AppMethodBeat.o(37451);
        return;
      }
      bu localbu = parame.dBd;
      int[] arrayOfInt = new int[2];
      int i = 0;
      int j = 0;
      if (paramView != null)
      {
        paramView.getLocationInWindow(arrayOfInt);
        i = paramView.getWidth();
        j = paramView.getHeight();
      }
      a(localbu, localbu.field_msgId, localbu.field_msgSvrId, parame.userName, parame.chatroomName, arrayOfInt, i, j, this.scene);
      if ((localbu.cxh()) && (parame.userName != null))
      {
        com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.a.JwP, localbu);
        if (parame.userName.toLowerCase().endsWith("@chatroom"))
        {
          g.yhR.f(11444, new Object[] { Integer.valueOf(2) });
          AppMethodBeat.o(37451);
          return;
        }
        g.yhR.f(11444, new Object[] { Integer.valueOf(1) });
      }
      AppMethodBeat.o(37451);
      return;
    }
    paramView = parame.dBd;
    if (paramView.field_isSend == 0) {
      a(parame);
    }
    if (paramView.field_isSend == 1) {
      b(parame);
    }
    AppMethodBeat.o(37451);
  }
  
  private boolean a(bu parambu, long paramLong1, long paramLong2, String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(37455);
    ad.i("MicroMsg.DesignerClickListener", "[ImageGalleryUI] showImgGallery");
    Intent localIntent = new Intent(this.JBI.JOR.getContext(), ImageGalleryUI.class);
    localIntent.putExtra("show_search_chat_content_result", ((ai)this.JBI.bh(ai.class)).fEM());
    localIntent.putExtra("img_gallery_msg_id", paramLong1);
    localIntent.putExtra("key_is_biz_chat", ((d)this.JBI.bh(d.class)).fCH());
    localIntent.putExtra("key_biz_chat_id", ((d)this.JBI.bh(d.class)).fCU());
    localIntent.putExtra("img_gallery_msg_svr_id", paramLong2);
    localIntent.putExtra("img_gallery_talker", paramString1);
    localIntent.putExtra("img_gallery_chatroom_name", paramString2);
    localIntent.putExtra("img_gallery_left", paramArrayOfInt[0]);
    localIntent.putExtra("img_gallery_top", paramArrayOfInt[1]);
    localIntent.putExtra("img_gallery_width", paramInt1);
    localIntent.putExtra("img_gallery_height", paramInt2);
    localIntent.putExtra("KOpenArticleSceneFromScene", 1);
    localIntent.putExtra("img_gallery_enter_from_chatting_ui", ((ai)this.JBI.bh(ai.class)).fEH());
    localIntent.putExtra("msg_type", paramInt3);
    if (paramInt3 == 1) {
      localIntent.putExtra("show_enter_grid", false);
    }
    paramString2 = this.JBI.getTalkerUserName();
    if (parambu.field_isSend == 1) {
      paramString1 = this.JBI.fFr();
    }
    paramArrayOfInt = new Bundle();
    if (this.JBI.fFv()) {
      paramInt1 = 2;
    }
    for (;;)
    {
      paramArrayOfInt.putInt("stat_scene", paramInt1);
      paramArrayOfInt.putString("stat_msg_id", "msg_" + Long.toString(paramLong2));
      paramArrayOfInt.putString("stat_chat_talker_username", paramString2);
      paramArrayOfInt.putString("stat_send_msg_user", paramString1);
      localIntent.putExtra("_stat_obj", paramArrayOfInt);
      if (parambu.cxg()) {
        localIntent.putExtra("img_gallery_mp_video_click_from", 2);
      }
      parambu = this.JBI;
      paramString1 = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(parambu, paramString1.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVideo$VideoClickListener", "showImgGallery", "(Lcom/tencent/mm/storage/MsgInfo;JJLjava/lang/String;Ljava/lang/String;[IIII)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parambu.startActivity((Intent)paramString1.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(parambu, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVideo$VideoClickListener", "showImgGallery", "(Lcom/tencent/mm/storage/MsgInfo;JJLjava/lang/String;Ljava/lang/String;[IIII)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      this.JBI.JOR.overridePendingTransition(0, 0);
      AppMethodBeat.o(37455);
      return true;
      if (w.zE(paramString2)) {
        paramInt1 = 7;
      } else {
        paramInt1 = 1;
      }
    }
  }
  
  private void b(ay.e parame)
  {
    AppMethodBeat.i(37454);
    bu localbu = parame.dBd;
    if (localbu == null)
    {
      ad.w("MicroMsg.DesignerClickListener", "videoSendEvent but msg is null ");
      AppMethodBeat.o(37454);
      return;
    }
    s locals = o.aMJ().Hb(localbu.field_imgPath);
    if (locals == null)
    {
      ad.w("MicroMsg.DesignerClickListener", "videoSendEvent but video info is null [%s]", new Object[] { localbu.field_imgPath });
      AppMethodBeat.o(37454);
      return;
    }
    int i = locals.status;
    ad.i("MicroMsg.DesignerClickListener", " videoSendEvent status : ".concat(String.valueOf(i)));
    switch (parame.oIb)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(37454);
      return;
      ba.aBQ();
      if (!c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.t.g(this.JBI.JOR.getContext(), this.JBI.JOR.getContentView());
        AppMethodBeat.o(37454);
        return;
      }
      if (i == 112)
      {
        ad.i("MicroMsg.DesignerClickListener", "this video come from pc weixin, user pause recv now.");
        u.Hu(localbu.field_imgPath);
        AppMethodBeat.o(37454);
        return;
      }
      u.Hs(localbu.field_imgPath);
      ad.d("MicroMsg.DesignerClickListener", "pause video, publish SendMsgFailEvent");
      parame = new sy();
      parame.dHA.dku = localbu;
      com.tencent.mm.sdk.b.a.IbL.l(parame);
      AppMethodBeat.o(37454);
      return;
      ba.aBQ();
      if (!c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.t.g(this.JBI.JOR.getContext(), this.JBI.JOR.getContentView());
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
      if (locals.aMW())
      {
        ad.e("MicroMsg.DesignerClickListener", "this video come from gallery, but it is illegal.");
        parame = this.JBI.JOR.getContext().getString(2131764674);
        if (i == 142) {
          parame = this.JBI.JOR.getContext().getString(2131764674);
        }
        for (;;)
        {
          h.c(this.JBI.JOR.getContext(), parame, this.JBI.JOR.getContext().getString(2131764439), true);
          AppMethodBeat.o(37454);
          return;
          if (i == 141) {
            parame = this.JBI.JOR.getContext().getString(2131764675);
          } else if (i == 140) {
            parame = this.JBI.JOR.getContext().getString(2131764673);
          }
        }
      }
      localbu.frY();
      ba.aBQ();
      c.azs().a(localbu.field_msgId, localbu);
      if (locals.status == 198)
      {
        u.Hw(localbu.field_imgPath);
        AppMethodBeat.o(37454);
        return;
      }
      u.Hr(localbu.field_imgPath);
    }
  }
  
  private void i(final s params)
  {
    AppMethodBeat.i(37453);
    ba.aBQ();
    if (!c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.t.g(this.JBI.JOR.getContext(), this.JBI.JOR.getContentView());
      AppMethodBeat.o(37453);
      return;
    }
    if (params.status == 198)
    {
      u.Hv(params.getFileName());
      AppMethodBeat.o(37453);
      return;
    }
    if ((!ae.cP(this.JBI.JOR.getContext())) && (!JSM))
    {
      JSM = true;
      h.a(this.JBI.JOR.getContext(), 2131764676, 2131755906, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(37448);
          ay.c.aWH(params.getFileName());
          AppMethodBeat.o(37448);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(37453);
      return;
    }
    u.Ht(params.getFileName());
    AppMethodBeat.o(37453);
  }
  
  public final void a(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(37450);
    parama = (bk)paramView.getTag();
    b.inZ.U(parama.dBd);
    a((ay.e)parama, paramView);
    AppMethodBeat.o(37450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ay.c
 * JD-Core Version:    0.7.0.1
 */