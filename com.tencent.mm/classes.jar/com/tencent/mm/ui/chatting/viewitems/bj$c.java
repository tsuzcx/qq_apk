package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.f.a.va;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.modelvideo.y;
import com.tencent.mm.network.ag;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.an;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.t.e;

public final class bj$c
  extends t.e
{
  public static boolean WUP = false;
  private int scene;
  
  public bj$c(com.tencent.mm.ui.chatting.e.a parama)
  {
    super(parama);
    this.scene = 0;
  }
  
  public bj$c(com.tencent.mm.ui.chatting.e.a parama, ca paramca, View paramView)
  {
    super(parama);
    AppMethodBeat.i(37449);
    this.scene = 0;
    this.scene = 1;
    if (this.scene == 1)
    {
      b.mcf.am(paramca);
      parama = new bj.e(paramca, this.WBq.hRi(), 0, paramca.field_talker);
      parama.viewType = 2;
      a(parama, paramView);
    }
    AppMethodBeat.o(37449);
  }
  
  private void a(bj.e parame)
  {
    AppMethodBeat.i(37452);
    ca localca = parame.fNz;
    com.tencent.mm.modelvideo.w localw = y.Yk(localca.field_imgPath);
    Log.i("MicroMsg.DesignerClickListener", "videoReceiverEvent video status:" + localw.status + " is sender:" + localca.field_isSend);
    switch (parame.viewType)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(37452);
      return;
      bh.beI();
      if (!c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.w.g(this.WBq.WQv.getContext(), this.WBq.WQv.getContentView());
        AppMethodBeat.o(37452);
        return;
      }
      y.Yg(localca.field_imgPath);
      AppMethodBeat.o(37452);
      return;
      i(localw);
    }
  }
  
  private void a(bj.e parame, View paramView)
  {
    AppMethodBeat.i(37451);
    com.tencent.mm.modelstat.a.a(parame.fNz, com.tencent.mm.modelstat.a.a.mcb);
    if (2 == parame.viewType)
    {
      if ((com.tencent.mm.q.a.cy(this.WBq.WQv.getContext())) || (com.tencent.mm.q.a.cw(this.WBq.WQv.getContext())) || (com.tencent.mm.q.a.cB(this.WBq.WQv.getContext())))
      {
        Log.i("MicroMsg.DesignerClickListener", "Voip or multitalk is running, can't do this");
        AppMethodBeat.o(37451);
        return;
      }
      ca localca = parame.fNz;
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
      if ((localca.dlT()) && (parame.userName != null))
      {
        com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.a.WvU, localca);
        if (parame.userName.toLowerCase().endsWith("@chatroom"))
        {
          com.tencent.mm.plugin.report.service.h.IzE.a(11444, new Object[] { Integer.valueOf(2) });
          AppMethodBeat.o(37451);
          return;
        }
        com.tencent.mm.plugin.report.service.h.IzE.a(11444, new Object[] { Integer.valueOf(1) });
      }
      AppMethodBeat.o(37451);
      return;
    }
    paramView = parame.fNz;
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
    Intent localIntent = new Intent(this.WBq.WQv.getContext(), ImageGalleryUI.class);
    localIntent.putExtra("show_search_chat_content_result", ((an)this.WBq.bC(an.class)).hQw());
    localIntent.putExtra("img_gallery_msg_id", paramLong1);
    localIntent.putExtra("key_is_biz_chat", ((d)this.WBq.bC(d.class)).hOe());
    localIntent.putExtra("key_biz_chat_id", ((d)this.WBq.bC(d.class)).hOs());
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
    paramString2 = this.WBq.getTalkerUserName();
    if (paramca.field_isSend == 1) {
      paramString1 = this.WBq.getSelfUserName();
    }
    paramArrayOfInt = new Bundle();
    if (this.WBq.hRi()) {
      paramInt1 = 2;
    }
    for (;;)
    {
      paramArrayOfInt.putInt("stat_scene", paramInt1);
      paramArrayOfInt.putString("stat_msg_id", "msg_" + Long.toString(paramLong2));
      paramArrayOfInt.putString("stat_chat_talker_username", paramString2);
      paramArrayOfInt.putString("stat_send_msg_user", paramString1);
      localIntent.putExtra("_stat_obj", paramArrayOfInt);
      if (paramca.dlS()) {
        localIntent.putExtra("img_gallery_mp_video_click_from", 2);
      }
      paramca = this.WBq;
      paramString1 = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramca, paramString1.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVideo$VideoClickListener", "showImgGallery", "(Lcom/tencent/mm/storage/MsgInfo;JJLjava/lang/String;Ljava/lang/String;[IIII)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramca.startActivity((Intent)paramString1.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramca, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVideo$VideoClickListener", "showImgGallery", "(Lcom/tencent/mm/storage/MsgInfo;JJLjava/lang/String;Ljava/lang/String;[IIII)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      this.WBq.WQv.overridePendingTransition(0, 0);
      AppMethodBeat.o(37455);
      return true;
      if (ab.Qm(paramString2)) {
        paramInt1 = 7;
      } else {
        paramInt1 = 1;
      }
    }
  }
  
  private void b(bj.e parame)
  {
    AppMethodBeat.i(37454);
    ca localca = parame.fNz;
    if (localca == null)
    {
      Log.w("MicroMsg.DesignerClickListener", "videoSendEvent but msg is null ");
      AppMethodBeat.o(37454);
      return;
    }
    com.tencent.mm.modelvideo.w localw = s.bqB().XN(localca.field_imgPath);
    if (localw == null)
    {
      Log.w("MicroMsg.DesignerClickListener", "videoSendEvent but video info is null [%s]", new Object[] { localca.field_imgPath });
      AppMethodBeat.o(37454);
      return;
    }
    int i = localw.status;
    Log.i("MicroMsg.DesignerClickListener", " videoSendEvent status : ".concat(String.valueOf(i)));
    switch (parame.viewType)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(37454);
      return;
      bh.beI();
      if (!c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.w.g(this.WBq.WQv.getContext(), this.WBq.WQv.getContentView());
        AppMethodBeat.o(37454);
        return;
      }
      if (i == 112)
      {
        Log.i("MicroMsg.DesignerClickListener", "this video come from pc weixin, user pause recv now.");
        y.Yg(localca.field_imgPath);
        AppMethodBeat.o(37454);
        return;
      }
      y.Ye(localca.field_imgPath);
      Log.d("MicroMsg.DesignerClickListener", "pause video, publish SendMsgFailEvent");
      parame = new va();
      parame.fUo.fvt = localca;
      EventCenter.instance.publish(parame);
      AppMethodBeat.o(37454);
      return;
      bh.beI();
      if (!c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.w.g(this.WBq.WQv.getContext(), this.WBq.WQv.getContentView());
        AppMethodBeat.o(37454);
        return;
      }
      if (i == 113)
      {
        Log.i("MicroMsg.DesignerClickListener", "this video come from pc weixin, user restart now.");
        i(localw);
        AppMethodBeat.o(37454);
        return;
      }
      if (localw.bqQ())
      {
        Log.e("MicroMsg.DesignerClickListener", "this video come from gallery, but it is illegal.");
        parame = this.WBq.WQv.getContext().getString(R.l.video_export_file_error);
        if (i == 142) {
          parame = this.WBq.WQv.getContext().getString(R.l.video_export_file_error);
        }
        for (;;)
        {
          com.tencent.mm.ui.base.h.c(this.WBq.WQv.getContext(), parame, this.WBq.WQv.getContext().getString(R.l.tip_title), true);
          AppMethodBeat.o(37454);
          return;
          if (i == 141) {
            parame = this.WBq.WQv.getContext().getString(R.l.video_export_file_too_big);
          } else if (i == 140) {
            parame = this.WBq.WQv.getContext().getString(R.l.video_export_duration_too_long);
          }
        }
      }
      localca.unsetOmittedFailResend();
      bh.beI();
      c.bbO().a(localca.field_msgId, localca);
      if (localw.status == 198)
      {
        y.Yi(localca.field_imgPath);
        AppMethodBeat.o(37454);
        return;
      }
      y.Yd(localca.field_imgPath);
    }
  }
  
  private void i(final com.tencent.mm.modelvideo.w paramw)
  {
    AppMethodBeat.i(37453);
    bh.beI();
    if (!c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.w.g(this.WBq.WQv.getContext(), this.WBq.WQv.getContentView());
      AppMethodBeat.o(37453);
      return;
    }
    if (paramw.status == 198)
    {
      y.Yh(paramw.getFileName());
      AppMethodBeat.o(37453);
      return;
    }
    if ((!ag.dj(this.WBq.WQv.getContext())) && (!WUP))
    {
      WUP = true;
      com.tencent.mm.ui.base.h.a(this.WBq.WQv.getContext(), R.l.video_export_file_warning, R.l.app_tip, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(37448);
          bj.c.bzN(paramw.getFileName());
          AppMethodBeat.o(37448);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(37453);
      return;
    }
    y.Yf(paramw.getFileName());
    AppMethodBeat.o(37453);
  }
  
  public final void a(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(37450);
    parama = (by)paramView.getTag();
    b.mcf.am(parama.fNz);
    a((bj.e)parama, paramView);
    AppMethodBeat.o(37450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bj.c
 * JD-Core Version:    0.7.0.1
 */