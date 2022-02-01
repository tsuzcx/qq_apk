package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.u;
import com.tencent.mm.ah.v;
import com.tencent.mm.av.q;
import com.tencent.mm.ay.f;
import com.tencent.mm.br.d.a;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.a.cw.b;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.model.x;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.d.b.an;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.viewitems.bk;
import com.tencent.mm.ui.chatting.viewitems.e.g;
import com.tencent.mm.ui.chatting.viewitems.e.h;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.vfs.o;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedList;

public final class s
{
  public static void a(int paramInt, Context paramContext, String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(34584);
    paramString1 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(paramLong1, paramString1);
    if (paramString1 == null)
    {
      ae.w("MicroMsg.ChattingItemHelper", "transmitAppBrandMsg reader is null");
      AppMethodBeat.o(34584);
      return;
    }
    if ((paramInt >= 0) && (paramInt < paramString1.hFT.size()))
    {
      paramString1 = (v)paramString1.hFT.get(paramInt);
      Object localObject = k.b.a(m.a(paramString2, paramString1), null, null);
      if (bu.isNullOrNil((String)localObject))
      {
        AppMethodBeat.o(34584);
        return;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("desc", paramString1.hGg);
      localHashMap.put("type", Integer.valueOf(2));
      localHashMap.put("title", paramString1.title);
      localHashMap.put("app_id", paramString1.hGn);
      localHashMap.put("pkg_type", Integer.valueOf(paramString1.hGm));
      localHashMap.put("pkg_version", Integer.valueOf(paramString1.hGl));
      localHashMap.put("img_url", paramString1.hGo);
      localHashMap.put("is_dynamic", Boolean.FALSE);
      localHashMap.put("cache_key", "");
      localHashMap.put("path", paramString1.hGk);
      paramString1 = new Intent(paramContext, MsgRetransmitUI.class);
      paramString1.putExtra("appbrand_params", localHashMap);
      paramString1.putExtra("Retr_Msg_content", (String)localObject);
      paramString1.putExtra("Retr_Msg_Type", 2);
      paramString1.putExtra("Retr_Biz_Msg_Selected_Msg_Index", paramInt);
      paramString1.putExtra("Retr_Msg_Id", paramLong1);
      paramString1.putExtra("Retr_MsgFromScene", 3);
      localObject = z.Br(String.valueOf(paramLong2));
      paramString1.putExtra("reportSessionId", (String)localObject);
      localObject = z.aBG().F((String)localObject, true);
      ((z.b)localObject).k("prePublishId", "msg_".concat(String.valueOf(paramLong2)));
      ((z.b)localObject).k("preUsername", paramString2);
      ((z.b)localObject).k("preChatName", paramString2);
      ((z.b)localObject).k("preMsgIndex", Integer.valueOf(paramInt));
      ((z.b)localObject).k("sendAppMsgScene", Integer.valueOf(1));
      paramString1 = new com.tencent.mm.hellhoundlib.b.a().bc(paramString1);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString1.ahE(), "com/tencent/mm/ui/chatting/ChattingItemHelper", "transmitAppBrandMsg", "(ILandroid/content/Context;Ljava/lang/String;Ljava/lang/String;JJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString1.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/chatting/ChattingItemHelper", "transmitAppBrandMsg", "(ILandroid/content/Context;Ljava/lang/String;Ljava/lang/String;JJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(34584);
  }
  
  public static void a(long paramLong, int paramInt, Context paramContext, Fragment paramFragment, Activity paramActivity, bv parambv)
  {
    AppMethodBeat.i(34585);
    Object localObject = parambv.field_talker;
    String str = z.Br(parambv.field_msgSvrId);
    z.b localb = z.aBG().F(str, true);
    localb.k("prePublishId", "msg_" + parambv.field_msgSvrId);
    localb.k("preUsername", localObject);
    localb.k("preChatName", localObject);
    localb.k("preMsgIndex", Integer.valueOf(paramInt));
    localb.k("sendAppMsgScene", Integer.valueOf(1));
    localObject = new cw();
    ((cw)localObject).doL.doP = paramInt;
    ((cw)localObject).doL.sessionId = str;
    ((cw)localObject).doL.fragment = paramFragment;
    ((cw)localObject).doL.activity = paramActivity;
    ((cw)localObject).doL.doR = 40;
    com.tencent.mm.pluginsdk.model.g.e((cw)localObject, parambv);
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    if (((cw)localObject).doM.ret == 0)
    {
      paramFragment = k.b.zb(com.tencent.mm.ah.m.a(paramContext, paramInt, parambv.field_content, parambv.field_talker, parambv.field_msgId));
      if (!parambv.cVH()) {
        break label416;
      }
      paramContext = com.tencent.mm.modelstat.b.iqT;
      if (paramFragment == null) {
        break label411;
      }
      paramInt = paramFragment.type;
      paramContext.c(parambv, paramInt);
    }
    for (;;)
    {
      if ((paramFragment != null) && (paramFragment.type == 5) && (paramFragment.url != null))
      {
        ae.d("MicroMsg.ChattingItemHelper", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), paramFragment.url, Long.valueOf(paramLong), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1) });
        paramContext = "";
      }
      try
      {
        paramFragment = URLEncoder.encode(paramFragment.url, "UTF-8");
        paramContext = paramFragment;
      }
      catch (UnsupportedEncodingException paramFragment)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.ChattingItemHelper", paramFragment, "", new Object[0]);
        }
      }
      com.tencent.mm.plugin.report.service.g.yxI.f(13378, new Object[] { paramContext, Long.valueOf(paramLong), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1) });
      AppMethodBeat.o(34585);
      return;
      label411:
      paramInt = 0;
      break;
      label416:
      com.tencent.mm.modelstat.b.iqT.S(parambv);
    }
  }
  
  public static void a(View paramView, Context paramContext, String paramString)
  {
    AppMethodBeat.i(34582);
    bk localbk = (bk)paramView.getTag();
    String str = localbk.dpp;
    paramView = str;
    if (TextUtils.isEmpty(str)) {
      paramView = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().acp(localbk.fmn);
    }
    if (TextUtils.isEmpty(paramView))
    {
      paramView = new Intent();
      paramView.putExtra("geta8key_username", paramString);
      paramView.putExtra("rawUrl", localbk.fmn);
      com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramView);
      AppMethodBeat.o(34582);
      return;
    }
    paramString = new Intent();
    paramString.putExtra("extra_id", paramView);
    paramString.putExtra("extra_name", localbk.title);
    if (localbk.KDQ)
    {
      paramString.putExtra("download_entrance_scene", 20);
      paramString.putExtra("preceding_scence", 3);
      paramString.putExtra("reward_tip", true);
      com.tencent.mm.plugin.report.service.g.yxI.f(12953, new Object[] { Integer.valueOf(1), paramView });
    }
    for (;;)
    {
      com.tencent.mm.br.d.b(paramContext, "emoji", ".ui.EmojiStoreDetailUI", paramString);
      AppMethodBeat.o(34582);
      return;
      if (localbk.KDR)
      {
        paramString.putExtra("download_entrance_scene", 25);
        paramString.putExtra("preceding_scence", 9);
        paramString.putExtra("reward_tip", true);
      }
      else
      {
        paramString.putExtra("download_entrance_scene", 22);
        paramString.putExtra("preceding_scence", 122);
        com.tencent.mm.plugin.report.service.g.yxI.f(10993, new Object[] { Integer.valueOf(2), paramView });
      }
    }
  }
  
  public static void a(v paramv, View paramView, final String paramString)
  {
    AppMethodBeat.i(34583);
    if ((paramView == null) || (paramv == null))
    {
      AppMethodBeat.o(34583);
      return;
    }
    paramView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34578);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingItemHelper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        paramAnonymousView = (bk)paramAnonymousView.getTag();
        ae.i("MicroMsg.ChattingItemHelper", "on app brand(%s) button1 click", new Object[] { this.ogC.hGj });
        localObject = new vq();
        ((vq)localObject).dKT.userName = this.ogC.hGj;
        ((vq)localObject).dKT.dKV = this.ogC.hGk;
        ((vq)localObject).dKT.dKW = this.ogC.hGm;
        ((vq)localObject).dKT.aDD = this.ogC.hGl;
        ((vq)localObject).dKT.dLa = true;
        ((vq)localObject).dKT.scene = 1076;
        ((vq)localObject).dKT.dlj = (paramString + ":" + paramAnonymousView.dCi.field_msgSvrId + ":" + paramAnonymousView.EmA);
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingItemHelper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(34578);
      }
    });
    AppMethodBeat.o(34583);
  }
  
  public static void a(bv parambv, Context paramContext, com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(34586);
    bc.aCg();
    if (!c.isSDCardAvailable())
    {
      t.g(paramContext, parama.Kkd.getContentView());
      AppMethodBeat.o(34586);
      return;
    }
    Object localObject = null;
    if (parambv.field_msgId > 0L) {
      localObject = q.aIX().G(parambv.field_talker, parambv.field_msgId);
    }
    if (((localObject == null) || (((com.tencent.mm.av.g)localObject).doE <= 0L)) && (parambv.field_msgSvrId > 0L)) {
      localObject = q.aIX().F(parambv.field_talker, parambv.field_msgSvrId);
    }
    for (;;)
    {
      if (localObject == null)
      {
        AppMethodBeat.o(34586);
        return;
      }
      int i;
      if (parambv.field_isSend == 1) {
        if (((com.tencent.mm.av.g)localObject).aIB()) {
          i = 1;
        }
      }
      while (parambv.fvU())
      {
        ae.i("MicroMsg.ChattingItemHelper", "image is clean!!!");
        com.tencent.mm.ui.base.h.d(paramContext, paramContext.getString(2131760321), paramContext.getString(2131755906), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(34586);
        return;
        i = 0;
        continue;
        if (!((com.tencent.mm.av.g)localObject).aIB())
        {
          i = 0;
        }
        else
        {
          com.tencent.mm.av.g localg = com.tencent.mm.av.h.a((com.tencent.mm.av.g)localObject);
          if (!o.fB(q.aIX().o(localg.ico, "", ""))) {
            i = 0;
          } else {
            i = 1;
          }
        }
      }
      if (com.tencent.mm.ui.chatting.d.l.f(parambv, q.aIX().o(com.tencent.mm.av.h.c((com.tencent.mm.av.g)localObject), "", "")))
      {
        ae.i("MicroMsg.ChattingItemHelper", "img is expired or clean!!!");
        ae.i("MicroMsg.ChattingItemHelper", "[ImageGalleryUI] enter");
        localObject = new Intent(paramContext, ImageGalleryUI.class);
        ((Intent)localObject).putExtra("img_gallery_msg_id", parambv.field_msgId);
        ((Intent)localObject).putExtra("img_gallery_msg_svr_id", parambv.field_msgSvrId);
        ((Intent)localObject).putExtra("img_gallery_talker", parambv.field_talker);
        ((Intent)localObject).putExtra("img_gallery_chatroom_name", parambv.field_talker);
        ((Intent)localObject).putExtra("img_gallery_is_restransmit_after_download", true);
        ((Intent)localObject).putExtra("Retr_show_success_tips", true);
        if (parama != null) {
          com.tencent.mm.ui.chatting.d.l.a(parama, parambv, (Intent)localObject);
        }
        for (;;)
        {
          parambv = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, parambv.ahE(), "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)parambv.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(34586);
          return;
          a(parambv, (Intent)localObject);
        }
      }
      if ((((com.tencent.mm.av.g)localObject).offset >= ((com.tencent.mm.av.g)localObject).hPI) && (((com.tencent.mm.av.g)localObject).hPI != 0))
      {
        parama = new Intent(paramContext, MsgRetransmitUI.class);
        parama.putExtra("Retr_File_Name", q.aIX().o(com.tencent.mm.av.h.c((com.tencent.mm.av.g)localObject), "", ""));
        parama.putExtra("Retr_Msg_Id", parambv.field_msgId);
        parama.putExtra("Retr_Msg_Type", 0);
        parama.putExtra("Retr_show_success_tips", true);
        parama.putExtra("Retr_Compress_Type", i);
        parambv = new com.tencent.mm.hellhoundlib.b.a().bc(parama);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, parambv.ahE(), "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)parambv.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(34586);
        return;
      }
      parama = new Intent(paramContext, MsgRetransmitUI.class);
      parama.putExtra("Retr_File_Name", q.aIX().R(parambv.field_imgPath, true));
      parama.putExtra("Retr_Msg_Id", parambv.field_msgId);
      parama.putExtra("Retr_Msg_Type", 0);
      parama.putExtra("Retr_show_success_tips", true);
      parama.putExtra("Retr_Compress_Type", i);
      parambv = new com.tencent.mm.hellhoundlib.b.a().bc(parama);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, parambv.ahE(), "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)parambv.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(34586);
      return;
    }
  }
  
  private static void a(bv parambv, Intent paramIntent)
  {
    AppMethodBeat.i(34587);
    if (parambv == null)
    {
      AppMethodBeat.o(34587);
      return;
    }
    String str1 = parambv.field_talker;
    String str2 = parambv.field_talker;
    Bundle localBundle = new Bundle();
    if (x.Ao(str1)) {}
    for (int i = 7;; i = 1)
    {
      localBundle.putInt("stat_scene", i);
      localBundle.putString("stat_msg_id", "msg_" + Long.toString(parambv.field_msgSvrId));
      localBundle.putString("stat_chat_talker_username", str1);
      localBundle.putString("stat_send_msg_user", str2);
      paramIntent.putExtra("_stat_obj", localBundle);
      AppMethodBeat.o(34587);
      return;
    }
  }
  
  public static void a(com.tencent.mm.ui.chatting.e.a parama, long paramLong, int paramInt)
  {
    AppMethodBeat.i(34588);
    ae.i("MicroMsg.ChattingItemHelper", "gotoEditUI() msgId:%s scene:%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    bv localbv = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ys(paramLong);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_group_solitatire_create", false);
    localIntent.putExtra("key_group_solitatire_key", localbv.fmz);
    localIntent.putExtra("key_group_solitatire_chatroom_username", localbv.field_talker);
    localIntent.putExtra("key_group_solitatire_scene", paramInt);
    com.tencent.mm.br.d.a(parama.Kka, "groupsolitaire", ".ui.GroupSolitatireEditUI", localIntent, 3001, new d.a()
    {
      public final void onActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(34579);
        if (paramAnonymousInt1 == 3001)
        {
          ae.i("MicroMsg.ChattingItemHelper", "gotoEditUI() REQUEST_CODE_VIEW_GROUP_SOLITATIRE resultCode:%s", new Object[] { Integer.valueOf(paramAnonymousInt2) });
          if ((-1 == paramAnonymousInt2) && (paramAnonymousIntent != null)) {
            ((an)this.JVv.bh(an.class)).aoa(paramAnonymousIntent.getStringExtra("key_group_solitatire_content"));
          }
        }
        AppMethodBeat.o(34579);
      }
    });
    AppMethodBeat.o(34588);
  }
  
  private static boolean aye(String paramString)
  {
    AppMethodBeat.i(34581);
    f localf = com.tencent.mm.ay.a.aKc();
    if ((localf != null) && (localf.ijZ != null) && (localf.ijX == 0) && (com.tencent.mm.ay.a.aJZ())) {
      try
      {
        boolean bool = bu.lX(localf.ijZ, paramString);
        if (bool)
        {
          AppMethodBeat.o(34581);
          return true;
        }
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(34581);
        return false;
      }
    }
    AppMethodBeat.o(34581);
    return false;
  }
  
  public static void gi(View paramView)
  {
    AppMethodBeat.i(34580);
    long l1;
    Object localObject1;
    if ((paramView.getTag() instanceof e.g))
    {
      paramView = (e.g)paramView.getTag();
      l1 = paramView.msgId;
      String str1;
      String str2;
      String str3;
      String str4;
      if (paramView.Kxb != null)
      {
        paramView = paramView.Kxb;
        if (aye(paramView.EHk))
        {
          com.tencent.mm.ay.a.aJX();
          AppMethodBeat.o(34580);
          return;
        }
        localObject1 = paramView.coverUrl;
        localObject2 = paramView.title;
        localObject3 = paramView.hGs;
        str1 = paramView.url;
        str2 = paramView.url;
        str3 = paramView.playUrl;
        str4 = paramView.EHk;
        bc.aCg();
        com.tencent.mm.ay.a.c(com.tencent.mm.ay.h.a(0, (String)localObject1, (String)localObject2, (String)localObject3, str1, str2, str3, str4, c.getAccPath(), paramView.coverUrl, "", ""));
        AppMethodBeat.o(34580);
        return;
      }
      if (paramView.Kxc == -1)
      {
        bc.aCg();
        localObject1 = c.azI().ys(paramView.msgId);
        boolean bool;
        if (aye(String.valueOf(l1)))
        {
          com.tencent.mm.plugin.report.service.g.yxI.kvStat(10231, "1");
          com.tencent.mm.ay.a.aJX();
          if (((ei)localObject1).field_msgId == l1)
          {
            paramView = com.tencent.mm.modelstat.b.iqT;
            bool = false;
            i = com.tencent.mm.ah.l.r((bv)localObject1);
          }
        }
        for (;;)
        {
          paramView.a((bv)localObject1, bool, i);
          do
          {
            AppMethodBeat.o(34580);
            return;
            localObject2 = k.b.zb(paramView.dCX);
            if (localObject2 != null)
            {
              com.tencent.mm.plugin.report.service.g.yxI.kvStat(10090, "0,1");
              long l2 = paramView.msgId;
              localObject3 = paramView.dzD;
              bc.aCg();
              com.tencent.mm.ay.a.c(com.tencent.mm.ay.h.a((k.b)localObject2, String.valueOf(l2), (String)localObject3, c.getAccPath(), paramView.dzD));
            }
          } while (((ei)localObject1).field_msgId != l1);
          paramView = com.tencent.mm.modelstat.b.iqT;
          bool = true;
          if (localObject2 != null) {
            i = ((k.b)localObject2).type;
          } else {
            i = 0;
          }
        }
      }
      Object localObject2 = paramView.msgId + "_" + paramView.Kxc;
      bc.aCg();
      localObject1 = c.azI().ys(paramView.msgId);
      Object localObject3 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(paramView.msgId, paramView.dCX);
      if (aye((String)localObject2))
      {
        com.tencent.mm.plugin.report.service.g.yxI.kvStat(10231, "1");
        com.tencent.mm.ay.a.aJX();
        if (((ei)localObject1).field_msgId == l1) {
          com.tencent.mm.modelstat.b.iqT.a((bv)localObject1, false, com.tencent.mm.ah.l.r((bv)localObject1));
        }
        if ((localObject3 != null) && (((u)localObject3).hFT != null) && (((u)localObject3).hFT.size() > paramView.Kxc))
        {
          paramView = (v)((u)localObject3).hFT.get(paramView.Kxc);
          localObject1 = com.tencent.mm.plugin.report.service.g.yxI;
          if (paramView.type == 6) {}
          for (i = 1;; i = 0)
          {
            ((com.tencent.mm.plugin.report.service.g)localObject1).f(14972, new Object[] { Integer.valueOf(i), Integer.valueOf(1) });
            AppMethodBeat.o(34580);
            return;
          }
        }
      }
      else if ((localObject3 != null) && (((u)localObject3).hFT != null) && (((u)localObject3).hFT.size() > paramView.Kxc))
      {
        com.tencent.mm.plugin.report.service.g.yxI.kvStat(10090, "0,1");
        localObject3 = (v)((u)localObject3).hFT.get(paramView.Kxc);
        str1 = paramView.dzD;
        str2 = ((v)localObject3).title;
        str3 = ((v)localObject3).hGs;
        str4 = ((v)localObject3).url;
        String str5 = ((v)localObject3).url;
        String str6 = ((v)localObject3).hGr;
        bc.aCg();
        com.tencent.mm.ay.a.c(com.tencent.mm.ay.h.a(0, str1, str2, str3, str4, str5, str6, (String)localObject2, c.getAccPath(), paramView.dzD, "", ""));
        paramView = com.tencent.mm.plugin.report.service.g.yxI;
        if (((v)localObject3).type != 6) {
          break label760;
        }
      }
    }
    label760:
    for (int i = 1;; i = 0)
    {
      paramView.f(14972, new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
      if (((ei)localObject1).field_msgId == l1) {
        com.tencent.mm.modelstat.b.iqT.a((bv)localObject1, true, com.tencent.mm.ah.l.r((bv)localObject1));
      }
      AppMethodBeat.o(34580);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s
 * JD-Core Version:    0.7.0.1
 */