package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.wq;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cn;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.modelvideo.z;
import com.tencent.mm.network.ah;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.au;
import com.tencent.mm.ui.chatting.component.api.e;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.v.e;

public final class bk$c
  extends v.e
{
  public static boolean aeEA = false;
  private int scene;
  
  public bk$c(com.tencent.mm.ui.chatting.d.a parama)
  {
    super(parama);
    this.scene = 0;
  }
  
  public bk$c(com.tencent.mm.ui.chatting.d.a parama, cc paramcc, View paramView)
  {
    super(parama);
    AppMethodBeat.i(37449);
    this.scene = 0;
    this.scene = 1;
    if (this.scene == 1)
    {
      b.oUZ.ar(paramcc);
      parama = new bk.e(paramcc, this.aeiK.juG(), 0, paramcc.field_talker);
      parama.viewType = 2;
      a(parama, paramView);
    }
    AppMethodBeat.o(37449);
  }
  
  private void a(bk.e parame)
  {
    AppMethodBeat.i(37452);
    cc localcc = parame.hTm;
    z localz = com.tencent.mm.modelvideo.ab.Qo(localcc.field_imgPath);
    Log.i("MicroMsg.DesignerClickListener", "videoReceiverEvent video status:" + localz.status + " is sender:" + localcc.field_isSend);
    switch (parame.viewType)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(37452);
      return;
      bh.bCz();
      if (!c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.aa.j(this.aeiK.aezO.getContext(), this.aeiK.aezO.getContentView());
        AppMethodBeat.o(37452);
        return;
      }
      com.tencent.mm.modelvideo.ab.Qk(localcc.field_imgPath);
      AppMethodBeat.o(37452);
      return;
      m(localz);
    }
  }
  
  private void a(bk.e parame, View paramView)
  {
    AppMethodBeat.i(37451);
    com.tencent.mm.modelstat.a.a(parame.hTm, com.tencent.mm.modelstat.a.a.oUW);
    if (2 == parame.viewType)
    {
      if ((com.tencent.mm.n.a.dm(this.aeiK.aezO.getContext())) || (com.tencent.mm.n.a.dl(this.aeiK.aezO.getContext())) || (com.tencent.mm.n.a.dp(this.aeiK.aezO.getContext())))
      {
        Log.i("MicroMsg.DesignerClickListener", "Voip or multitalk is running, can't do this");
        AppMethodBeat.o(37451);
        return;
      }
      cc localcc = parame.hTm;
      int[] arrayOfInt = new int[2];
      int i = 0;
      int j = 0;
      if (paramView != null)
      {
        paramView.getLocationOnScreen(arrayOfInt);
        i = paramView.getWidth();
        j = paramView.getHeight();
      }
      a(localcc, localcc.field_msgId, localcc.field_msgSvrId, parame.userName, parame.chatroomName, arrayOfInt, i, j, this.scene);
      if ((localcc.dSJ()) && (parame.userName != null))
      {
        com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.a.aedl, localcc);
        if (parame.userName.toLowerCase().endsWith("@chatroom"))
        {
          com.tencent.mm.plugin.report.service.h.OAn.b(11444, new Object[] { Integer.valueOf(2) });
          AppMethodBeat.o(37451);
          return;
        }
        com.tencent.mm.plugin.report.service.h.OAn.b(11444, new Object[] { Integer.valueOf(1) });
      }
      AppMethodBeat.o(37451);
      return;
    }
    paramView = parame.hTm;
    if (paramView.field_isSend == 0) {
      a(parame);
    }
    if (paramView.field_isSend == 1) {
      b(parame);
    }
    AppMethodBeat.o(37451);
  }
  
  private boolean a(cc paramcc, long paramLong1, long paramLong2, String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(37455);
    Log.i("MicroMsg.DesignerClickListener", "[ImageGalleryUI] showImgGallery");
    Intent localIntent = new Intent(this.aeiK.aezO.getContext(), ImageGalleryUI.class);
    localIntent.putExtra("show_search_chat_content_result", ((au)this.aeiK.cm(au.class)).jty());
    localIntent.putExtra("img_gallery_msg_id", paramLong1);
    localIntent.putExtra("key_is_biz_chat", ((e)this.aeiK.cm(e.class)).jqV());
    localIntent.putExtra("key_biz_chat_id", ((e)this.aeiK.cm(e.class)).jrk());
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
    paramString2 = this.aeiK.getTalkerUserName();
    if (paramcc.field_isSend == 1) {
      paramString1 = this.aeiK.getSelfUserName();
    }
    paramArrayOfInt = new Bundle();
    if (this.aeiK.juG()) {
      paramInt1 = 2;
    }
    for (;;)
    {
      paramArrayOfInt.putInt("stat_scene", paramInt1);
      paramArrayOfInt.putString("stat_msg_id", "msg_" + Long.toString(paramLong2));
      paramArrayOfInt.putString("stat_chat_talker_username", paramString2);
      paramArrayOfInt.putString("stat_send_msg_user", paramString1);
      localIntent.putExtra("_stat_obj", paramArrayOfInt);
      if (paramcc.dSI()) {
        localIntent.putExtra("img_gallery_mp_video_click_from", 2);
      }
      paramcc = this.aeiK;
      paramString1 = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramcc, paramString1.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVideo$VideoClickListener", "showImgGallery", "(Lcom/tencent/mm/storage/MsgInfo;JJLjava/lang/String;Ljava/lang/String;[IIII)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramcc.startActivity((Intent)paramString1.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramcc, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVideo$VideoClickListener", "showImgGallery", "(Lcom/tencent/mm/storage/MsgInfo;JJLjava/lang/String;Ljava/lang/String;[IIII)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      this.aeiK.aezO.overridePendingTransition(0, 0);
      AppMethodBeat.o(37455);
      return true;
      if (com.tencent.mm.model.ab.IS(paramString2)) {
        paramInt1 = 7;
      } else {
        paramInt1 = 1;
      }
    }
  }
  
  private void b(bk.e parame)
  {
    AppMethodBeat.i(37454);
    cc localcc = parame.hTm;
    if (localcc == null)
    {
      Log.w("MicroMsg.DesignerClickListener", "videoSendEvent but msg is null ");
      AppMethodBeat.o(37454);
      return;
    }
    z localz = v.bOh().PR(localcc.field_imgPath);
    if (localz == null)
    {
      Log.w("MicroMsg.DesignerClickListener", "videoSendEvent but video info is null [%s]", new Object[] { localcc.field_imgPath });
      AppMethodBeat.o(37454);
      return;
    }
    int i = localz.status;
    Log.i("MicroMsg.DesignerClickListener", " videoSendEvent status : ".concat(String.valueOf(i)));
    switch (parame.viewType)
    {
    default: 
      AppMethodBeat.o(37454);
      return;
    case 4: 
    case 6: 
      bh.bCz();
      if (!c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.aa.j(this.aeiK.aezO.getContext(), this.aeiK.aezO.getContentView());
        AppMethodBeat.o(37454);
        return;
      }
      if (i == 112)
      {
        Log.i("MicroMsg.DesignerClickListener", "this video come from pc weixin, user pause recv now.");
        com.tencent.mm.modelvideo.ab.Qk(localcc.field_imgPath);
        AppMethodBeat.o(37454);
        return;
      }
      com.tencent.mm.modelvideo.ab.Qi(localcc.field_imgPath);
      Log.d("MicroMsg.DesignerClickListener", "pause video, publish SendMsgFailEvent");
      parame = new wq();
      parame.ial.hzO = localcc;
      parame.publish();
      AppMethodBeat.o(37454);
      return;
    }
    bh.bCz();
    if (!c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.aa.j(this.aeiK.aezO.getContext(), this.aeiK.aezO.getContentView());
      AppMethodBeat.o(37454);
      return;
    }
    if (i == 113)
    {
      Log.i("MicroMsg.DesignerClickListener", "this video come from pc weixin, user restart now.");
      m(localz);
      AppMethodBeat.o(37454);
      return;
    }
    if (localz.bOv())
    {
      Log.e("MicroMsg.DesignerClickListener", "this video come from gallery, but it is illegal.");
      parame = this.aeiK.aezO.getContext().getString(R.l.video_export_file_error);
      if (i == 142) {
        parame = this.aeiK.aezO.getContext().getString(R.l.video_export_file_error);
      }
      for (;;)
      {
        k.c(this.aeiK.aezO.getContext(), parame, this.aeiK.aezO.getContext().getString(R.l.tip_title), true);
        AppMethodBeat.o(37454);
        return;
        if (i == 141) {
          parame = this.aeiK.aezO.getContext().getString(R.l.video_export_file_too_big);
        } else if (i == 140) {
          parame = this.aeiK.aezO.getContext().getString(R.l.video_export_duration_too_long);
        }
      }
    }
    localcc.unsetOmittedFailResend();
    bh.bCz();
    c.bzD().a(localcc.field_msgId, localcc);
    if (cn.bDu() - localcc.getCreateTime() < 432000000L)
    {
      if (localz.status == 198)
      {
        com.tencent.mm.modelvideo.ab.Qm(localcc.field_imgPath);
        AppMethodBeat.o(37454);
        return;
      }
      parame = localcc.field_imgPath;
      com.tencent.mm.modelvideo.ab.Qh(parame);
      com.tencent.threadpool.h.ahAA.bm(new bk.c..ExternalSyntheticLambda0(parame));
      AppMethodBeat.o(37454);
      return;
    }
    parame = this.aeiK;
    if (localz.status == 198) {}
    for (i = R.l.grK;; i = R.l.grL)
    {
      n.a(parame, localcc, i);
      break;
    }
  }
  
  private void m(final z paramz)
  {
    AppMethodBeat.i(37453);
    bh.bCz();
    if (!c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.aa.j(this.aeiK.aezO.getContext(), this.aeiK.aezO.getContentView());
      AppMethodBeat.o(37453);
      return;
    }
    if (paramz.status == 198)
    {
      com.tencent.mm.modelvideo.ab.Ql(paramz.getFileName());
      AppMethodBeat.o(37453);
      return;
    }
    if ((!ah.eb(this.aeiK.aezO.getContext())) && (!aeEA))
    {
      aeEA = true;
      k.a(this.aeiK.aezO.getContext(), R.l.video_export_file_warning, R.l.app_tip, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(37448);
          bk.c.bBD(paramz.getFileName());
          AppMethodBeat.o(37448);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(37453);
      return;
    }
    com.tencent.mm.modelvideo.ab.Qj(paramz.getFileName());
    AppMethodBeat.o(37453);
  }
  
  public final void a(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(37450);
    parama = (bz)paramView.getTag();
    b.oUZ.ar(parama.hTm);
    a((bk.e)parama, paramView);
    AppMethodBeat.o(37450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bk.c
 * JD-Core Version:    0.7.0.1
 */