package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.model.x;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.aj;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.t.e;

public final class ay$c
  extends t.e
{
  public static boolean Kom = false;
  private int scene;
  
  public ay$c(com.tencent.mm.ui.chatting.e.a parama)
  {
    super(parama);
    this.scene = 0;
  }
  
  public ay$c(com.tencent.mm.ui.chatting.e.a parama, bv parambv, View paramView)
  {
    super(parama);
    AppMethodBeat.i(37449);
    this.scene = 0;
    this.scene = 1;
    if (this.scene == 1)
    {
      b.iqT.U(parambv);
      parama = new ay.e(parambv, this.JWz.fJC(), 0, parambv.field_talker);
      parama.oOD = 2;
      a(parama, paramView);
    }
    AppMethodBeat.o(37449);
  }
  
  private void a(ay.e parame)
  {
    AppMethodBeat.i(37452);
    bv localbv = parame.dCi;
    s locals = u.Ia(localbv.field_imgPath);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.DesignerClickListener", "videoReceiverEvent video status:" + locals.status + " is sender:" + localbv.field_isSend);
    switch (parame.oOD)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(37452);
      return;
      bc.aCg();
      if (!c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.t.g(this.JWz.Kkd.getContext(), this.JWz.Kkd.getContentView());
        AppMethodBeat.o(37452);
        return;
      }
      u.HW(localbv.field_imgPath);
      AppMethodBeat.o(37452);
      return;
      i(locals);
    }
  }
  
  private void a(ay.e parame, View paramView)
  {
    AppMethodBeat.i(37451);
    com.tencent.mm.modelstat.a.a(parame.dCi, com.tencent.mm.modelstat.a.a.iqQ);
    if (2 == parame.oOD)
    {
      if ((com.tencent.mm.r.a.ch(this.JWz.Kkd.getContext())) || (com.tencent.mm.r.a.cf(this.JWz.Kkd.getContext())) || (com.tencent.mm.r.a.cj(this.JWz.Kkd.getContext())))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.DesignerClickListener", "Voip or multitalk is running, can't do this");
        AppMethodBeat.o(37451);
        return;
      }
      bv localbv = parame.dCi;
      int[] arrayOfInt = new int[2];
      int i = 0;
      int j = 0;
      if (paramView != null)
      {
        paramView.getLocationInWindow(arrayOfInt);
        i = paramView.getWidth();
        j = paramView.getHeight();
      }
      a(localbv, localbv.field_msgId, localbv.field_msgSvrId, parame.userName, parame.chatroomName, arrayOfInt, i, j, this.scene);
      if ((localbv.cyI()) && (parame.userName != null))
      {
        com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.a.JRF, localbv);
        if (parame.userName.toLowerCase().endsWith("@chatroom"))
        {
          g.yxI.f(11444, new Object[] { Integer.valueOf(2) });
          AppMethodBeat.o(37451);
          return;
        }
        g.yxI.f(11444, new Object[] { Integer.valueOf(1) });
      }
      AppMethodBeat.o(37451);
      return;
    }
    paramView = parame.dCi;
    if (paramView.field_isSend == 0) {
      a(parame);
    }
    if (paramView.field_isSend == 1) {
      b(parame);
    }
    AppMethodBeat.o(37451);
  }
  
  private boolean a(bv parambv, long paramLong1, long paramLong2, String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(37455);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.DesignerClickListener", "[ImageGalleryUI] showImgGallery");
    Intent localIntent = new Intent(this.JWz.Kkd.getContext(), ImageGalleryUI.class);
    localIntent.putExtra("show_search_chat_content_result", ((aj)this.JWz.bh(aj.class)).fIP());
    localIntent.putExtra("img_gallery_msg_id", paramLong1);
    localIntent.putExtra("key_is_biz_chat", ((d)this.JWz.bh(d.class)).fGJ());
    localIntent.putExtra("key_biz_chat_id", ((d)this.JWz.bh(d.class)).fGW());
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
    paramString2 = this.JWz.getTalkerUserName();
    if (parambv.field_isSend == 1) {
      paramString1 = this.JWz.fJy();
    }
    paramArrayOfInt = new Bundle();
    if (this.JWz.fJC()) {
      paramInt1 = 2;
    }
    for (;;)
    {
      paramArrayOfInt.putInt("stat_scene", paramInt1);
      paramArrayOfInt.putString("stat_msg_id", "msg_" + Long.toString(paramLong2));
      paramArrayOfInt.putString("stat_chat_talker_username", paramString2);
      paramArrayOfInt.putString("stat_send_msg_user", paramString1);
      localIntent.putExtra("_stat_obj", paramArrayOfInt);
      if (parambv.cyH()) {
        localIntent.putExtra("img_gallery_mp_video_click_from", 2);
      }
      parambv = this.JWz;
      paramString1 = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(parambv, paramString1.ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVideo$VideoClickListener", "showImgGallery", "(Lcom/tencent/mm/storage/MsgInfo;JJLjava/lang/String;Ljava/lang/String;[IIII)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parambv.startActivity((Intent)paramString1.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(parambv, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVideo$VideoClickListener", "showImgGallery", "(Lcom/tencent/mm/storage/MsgInfo;JJLjava/lang/String;Ljava/lang/String;[IIII)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      this.JWz.Kkd.overridePendingTransition(0, 0);
      AppMethodBeat.o(37455);
      return true;
      if (x.Ao(paramString2)) {
        paramInt1 = 7;
      } else {
        paramInt1 = 1;
      }
    }
  }
  
  private void b(ay.e parame)
  {
    AppMethodBeat.i(37454);
    bv localbv = parame.dCi;
    if (localbv == null)
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.DesignerClickListener", "videoSendEvent but msg is null ");
      AppMethodBeat.o(37454);
      return;
    }
    s locals = o.aNh().HD(localbv.field_imgPath);
    if (locals == null)
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.DesignerClickListener", "videoSendEvent but video info is null [%s]", new Object[] { localbv.field_imgPath });
      AppMethodBeat.o(37454);
      return;
    }
    int i = locals.status;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.DesignerClickListener", " videoSendEvent status : ".concat(String.valueOf(i)));
    switch (parame.oOD)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(37454);
      return;
      bc.aCg();
      if (!c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.t.g(this.JWz.Kkd.getContext(), this.JWz.Kkd.getContentView());
        AppMethodBeat.o(37454);
        return;
      }
      if (i == 112)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.DesignerClickListener", "this video come from pc weixin, user pause recv now.");
        u.HW(localbv.field_imgPath);
        AppMethodBeat.o(37454);
        return;
      }
      u.HU(localbv.field_imgPath);
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.DesignerClickListener", "pause video, publish SendMsgFailEvent");
      parame = new sz();
      parame.dIE.dlw = localbv;
      com.tencent.mm.sdk.b.a.IvT.l(parame);
      AppMethodBeat.o(37454);
      return;
      bc.aCg();
      if (!c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.t.g(this.JWz.Kkd.getContext(), this.JWz.Kkd.getContentView());
        AppMethodBeat.o(37454);
        return;
      }
      if (i == 113)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.DesignerClickListener", "this video come from pc weixin, user restart now.");
        i(locals);
        AppMethodBeat.o(37454);
        return;
      }
      if (locals.aNu())
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.DesignerClickListener", "this video come from gallery, but it is illegal.");
        parame = this.JWz.Kkd.getContext().getString(2131764674);
        if (i == 142) {
          parame = this.JWz.Kkd.getContext().getString(2131764674);
        }
        for (;;)
        {
          h.c(this.JWz.Kkd.getContext(), parame, this.JWz.Kkd.getContext().getString(2131764439), true);
          AppMethodBeat.o(37454);
          return;
          if (i == 141) {
            parame = this.JWz.Kkd.getContext().getString(2131764675);
          } else if (i == 140) {
            parame = this.JWz.Kkd.getContext().getString(2131764673);
          }
        }
      }
      localbv.fvZ();
      bc.aCg();
      c.azI().a(localbv.field_msgId, localbv);
      if (locals.status == 198)
      {
        u.HY(localbv.field_imgPath);
        AppMethodBeat.o(37454);
        return;
      }
      u.HT(localbv.field_imgPath);
    }
  }
  
  private void i(final s params)
  {
    AppMethodBeat.i(37453);
    bc.aCg();
    if (!c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.t.g(this.JWz.Kkd.getContext(), this.JWz.Kkd.getContentView());
      AppMethodBeat.o(37453);
      return;
    }
    if (params.status == 198)
    {
      u.HX(params.getFileName());
      AppMethodBeat.o(37453);
      return;
    }
    if ((!com.tencent.mm.network.ae.cR(this.JWz.Kkd.getContext())) && (!Kom))
    {
      Kom = true;
      h.a(this.JWz.Kkd.getContext(), 2131764676, 2131755906, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(37448);
          ay.c.aYi(params.getFileName());
          AppMethodBeat.o(37448);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(37453);
      return;
    }
    u.HV(params.getFileName());
    AppMethodBeat.o(37453);
  }
  
  public final void a(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(37450);
    parama = (bk)paramView.getTag();
    b.iqT.U(parama.dCi);
    a((ay.e)parama, paramView);
    AppMethodBeat.o(37450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ay.c
 * JD-Core Version:    0.7.0.1
 */