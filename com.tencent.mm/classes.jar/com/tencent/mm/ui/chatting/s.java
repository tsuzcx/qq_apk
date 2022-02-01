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
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ag.v;
import com.tencent.mm.av.q;
import com.tencent.mm.ay.f;
import com.tencent.mm.br.c.a;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.cz.b;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.d.b.aq;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.viewitems.bq;
import com.tencent.mm.ui.chatting.viewitems.e.g;
import com.tencent.mm.ui.chatting.viewitems.e.h;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedList;

public final class s
{
  public static void a(int paramInt, Context paramContext, String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(34584);
    paramString1 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).a(paramLong1, paramString1);
    if (paramString1 == null)
    {
      Log.w("MicroMsg.ChattingItemHelper", "transmitAppBrandMsg reader is null");
      AppMethodBeat.o(34584);
      return;
    }
    if ((paramInt >= 0) && (paramInt < paramString1.iAd.size()))
    {
      paramString1 = (v)paramString1.iAd.get(paramInt);
      Object localObject = k.b.a(m.a(paramString2, paramString1), null, null);
      if (Util.isNullOrNil((String)localObject))
      {
        AppMethodBeat.o(34584);
        return;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("desc", paramString1.iAq);
      localHashMap.put("type", Integer.valueOf(2));
      localHashMap.put("title", paramString1.title);
      localHashMap.put("app_id", paramString1.iAv);
      localHashMap.put("pkg_type", Integer.valueOf(paramString1.iAu));
      localHashMap.put("pkg_version", Integer.valueOf(paramString1.weappVersion));
      localHashMap.put("img_url", paramString1.iAw);
      localHashMap.put("is_dynamic", Boolean.FALSE);
      localHashMap.put("cache_key", "");
      localHashMap.put("path", paramString1.weappPath);
      paramString1 = new Intent(paramContext, MsgRetransmitUI.class);
      paramString1.putExtra("appbrand_params", localHashMap);
      paramString1.putExtra("Retr_Msg_content", (String)localObject);
      paramString1.putExtra("Retr_Msg_Type", 2);
      paramString1.putExtra("Retr_Biz_Msg_Selected_Msg_Index", paramInt);
      paramString1.putExtra("Retr_Msg_Id", paramLong1);
      paramString1.putExtra("Retr_MsgFromScene", 3);
      localObject = ad.JX(String.valueOf(paramLong2));
      paramString1.putExtra("reportSessionId", (String)localObject);
      localObject = ad.aVe().G((String)localObject, true);
      ((ad.b)localObject).l("prePublishId", "msg_".concat(String.valueOf(paramLong2)));
      ((ad.b)localObject).l("preUsername", paramString2);
      ((ad.b)localObject).l("preChatName", paramString2);
      ((ad.b)localObject).l("preMsgIndex", Integer.valueOf(paramInt));
      ((ad.b)localObject).l("sendAppMsgScene", Integer.valueOf(1));
      paramString1 = new com.tencent.mm.hellhoundlib.b.a().bl(paramString1);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString1.axQ(), "com/tencent/mm/ui/chatting/ChattingItemHelper", "transmitAppBrandMsg", "(ILandroid/content/Context;Ljava/lang/String;Ljava/lang/String;JJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString1.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/chatting/ChattingItemHelper", "transmitAppBrandMsg", "(ILandroid/content/Context;Ljava/lang/String;Ljava/lang/String;JJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(34584);
  }
  
  public static void a(long paramLong, int paramInt, Context paramContext, Fragment paramFragment, Activity paramActivity, ca paramca)
  {
    AppMethodBeat.i(34585);
    Object localObject = paramca.field_talker;
    String str = ad.JX(paramca.field_msgSvrId);
    ad.b localb = ad.aVe().G(str, true);
    localb.l("prePublishId", "msg_" + paramca.field_msgSvrId);
    localb.l("preUsername", localObject);
    localb.l("preChatName", localObject);
    localb.l("preMsgIndex", Integer.valueOf(paramInt));
    localb.l("sendAppMsgScene", Integer.valueOf(1));
    localObject = new cz();
    ((cz)localObject).dFZ.dGd = paramInt;
    ((cz)localObject).dFZ.sessionId = str;
    ((cz)localObject).dFZ.fragment = paramFragment;
    ((cz)localObject).dFZ.activity = paramActivity;
    ((cz)localObject).dFZ.dGf = 40;
    com.tencent.mm.pluginsdk.model.h.d((cz)localObject, paramca);
    EventCenter.instance.publish((IEvent)localObject);
    if (((cz)localObject).dGa.ret == 0)
    {
      paramFragment = k.b.HD(com.tencent.mm.ag.m.a(paramContext, paramInt, paramca.field_content, paramca.field_talker, paramca.field_msgId));
      if (!paramca.dOQ()) {
        break label416;
      }
      paramContext = com.tencent.mm.modelstat.b.jmd;
      if (paramFragment == null) {
        break label411;
      }
      paramInt = paramFragment.type;
      paramContext.c(paramca, paramInt);
    }
    for (;;)
    {
      if ((paramFragment != null) && (paramFragment.type == 5) && (paramFragment.url != null))
      {
        Log.d("MicroMsg.ChattingItemHelper", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), paramFragment.url, Long.valueOf(paramLong), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1) });
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
          Log.printErrStackTrace("MicroMsg.ChattingItemHelper", paramFragment, "", new Object[0]);
        }
      }
      com.tencent.mm.plugin.report.service.h.CyF.a(13378, new Object[] { paramContext, Long.valueOf(paramLong), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1) });
      AppMethodBeat.o(34585);
      return;
      label411:
      paramInt = 0;
      break;
      label416:
      com.tencent.mm.modelstat.b.jmd.ac(paramca);
    }
  }
  
  public static void a(View paramView, Context paramContext, String paramString)
  {
    AppMethodBeat.i(34582);
    bq localbq = (bq)paramView.getTag();
    String str = localbq.productId;
    paramView = str;
    if (TextUtils.isEmpty(str)) {
      paramView = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().ams(localbq.fQR);
    }
    if (TextUtils.isEmpty(paramView))
    {
      paramView = new Intent();
      paramView.putExtra("geta8key_username", paramString);
      paramView.putExtra("rawUrl", localbq.fQR);
      com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramView);
      AppMethodBeat.o(34582);
      return;
    }
    paramString = new Intent();
    paramString.putExtra("extra_id", paramView);
    paramString.putExtra("extra_name", localbq.title);
    if (localbq.PQD)
    {
      paramString.putExtra("download_entrance_scene", 20);
      paramString.putExtra("preceding_scence", 3);
      paramString.putExtra("reward_tip", true);
      com.tencent.mm.plugin.report.service.h.CyF.a(12953, new Object[] { Integer.valueOf(1), paramView });
    }
    for (;;)
    {
      com.tencent.mm.br.c.b(paramContext, "emoji", ".ui.EmojiStoreDetailUI", paramString);
      AppMethodBeat.o(34582);
      return;
      if (localbq.PQE)
      {
        paramString.putExtra("download_entrance_scene", 25);
        paramString.putExtra("preceding_scence", 9);
        paramString.putExtra("reward_tip", true);
      }
      else
      {
        paramString.putExtra("download_entrance_scene", 22);
        paramString.putExtra("preceding_scence", 122);
        com.tencent.mm.plugin.report.service.h.CyF.a(10993, new Object[] { Integer.valueOf(2), paramView });
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
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingItemHelper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramAnonymousView = (bq)paramAnonymousView.getTag();
        Log.i("MicroMsg.ChattingItemHelper", "on app brand(%s) button1 click", new Object[] { this.pxW.iAt });
        localObject = new wq();
        ((wq)localObject).ecI.userName = this.pxW.iAt;
        ((wq)localObject).ecI.ecK = this.pxW.weappPath;
        ((wq)localObject).ecI.ecL = this.pxW.iAu;
        ((wq)localObject).ecI.appVersion = this.pxW.weappVersion;
        ((wq)localObject).ecI.ecP = true;
        ((wq)localObject).ecI.scene = 1076;
        ((wq)localObject).ecI.dCw = (paramString + ":" + paramAnonymousView.dTX.field_msgSvrId + ":" + paramAnonymousView.IZD);
        EventCenter.instance.publish((IEvent)localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingItemHelper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(34578);
      }
    });
    AppMethodBeat.o(34583);
  }
  
  public static void a(ca paramca, Context paramContext, com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(34586);
    bg.aVF();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.u.g(paramContext, parama.Pwc.getContentView());
      AppMethodBeat.o(34586);
      return;
    }
    Object localObject = null;
    if (paramca.field_msgId > 0L) {
      localObject = q.bcR().H(paramca.field_talker, paramca.field_msgId);
    }
    if (((localObject == null) || (((com.tencent.mm.av.g)localObject).localId <= 0L)) && (paramca.field_msgSvrId > 0L)) {
      localObject = q.bcR().G(paramca.field_talker, paramca.field_msgSvrId);
    }
    for (;;)
    {
      if (localObject == null)
      {
        AppMethodBeat.o(34586);
        return;
      }
      int i;
      if (paramca.field_isSend == 1) {
        if (((com.tencent.mm.av.g)localObject).bcv()) {
          i = 1;
        }
      }
      while (paramca.gDB())
      {
        Log.i("MicroMsg.ChattingItemHelper", "image is clean!!!");
        com.tencent.mm.ui.base.h.d(paramContext, paramContext.getString(2131761765), paramContext.getString(2131755998), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(34586);
        return;
        i = 0;
        continue;
        if (!((com.tencent.mm.av.g)localObject).bcv())
        {
          i = 0;
        }
        else
        {
          com.tencent.mm.av.g localg = com.tencent.mm.av.h.a((com.tencent.mm.av.g)localObject);
          if (!com.tencent.mm.vfs.s.YS(q.bcR().o(localg.iXm, "", ""))) {
            i = 0;
          } else {
            i = 1;
          }
        }
      }
      if (com.tencent.mm.ui.chatting.d.l.h(paramca, q.bcR().o(com.tencent.mm.av.h.c((com.tencent.mm.av.g)localObject), "", "")))
      {
        Log.i("MicroMsg.ChattingItemHelper", "img is expired or clean!!!");
        Log.i("MicroMsg.ChattingItemHelper", "[ImageGalleryUI] enter");
        localObject = new Intent(paramContext, ImageGalleryUI.class);
        ((Intent)localObject).putExtra("img_gallery_msg_id", paramca.field_msgId);
        ((Intent)localObject).putExtra("img_gallery_msg_svr_id", paramca.field_msgSvrId);
        ((Intent)localObject).putExtra("img_gallery_talker", paramca.field_talker);
        ((Intent)localObject).putExtra("img_gallery_chatroom_name", paramca.field_talker);
        ((Intent)localObject).putExtra("img_gallery_is_restransmit_after_download", true);
        ((Intent)localObject).putExtra("Retr_show_success_tips", true);
        if (parama != null) {
          com.tencent.mm.ui.chatting.d.l.a(parama, paramca, (Intent)localObject);
        }
        for (;;)
        {
          paramca = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramca.axQ(), "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramca.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(34586);
          return;
          a(paramca, (Intent)localObject);
        }
      }
      if ((((com.tencent.mm.av.g)localObject).offset >= ((com.tencent.mm.av.g)localObject).iKP) && (((com.tencent.mm.av.g)localObject).iKP != 0))
      {
        parama = new Intent(paramContext, MsgRetransmitUI.class);
        parama.putExtra("Retr_File_Name", q.bcR().o(com.tencent.mm.av.h.c((com.tencent.mm.av.g)localObject), "", ""));
        parama.putExtra("Retr_Msg_Id", paramca.field_msgId);
        parama.putExtra("Retr_Msg_Type", 0);
        parama.putExtra("Retr_show_success_tips", true);
        parama.putExtra("Retr_Compress_Type", i);
        paramca = new com.tencent.mm.hellhoundlib.b.a().bl(parama);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramca.axQ(), "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramca.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(34586);
        return;
      }
      parama = new Intent(paramContext, MsgRetransmitUI.class);
      parama.putExtra("Retr_File_Name", q.bcR().R(paramca.field_imgPath, true));
      parama.putExtra("Retr_Msg_Id", paramca.field_msgId);
      parama.putExtra("Retr_Msg_Type", 0);
      parama.putExtra("Retr_show_success_tips", true);
      parama.putExtra("Retr_Compress_Type", i);
      paramca = new com.tencent.mm.hellhoundlib.b.a().bl(parama);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramca.axQ(), "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramca.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(34586);
      return;
    }
  }
  
  private static void a(ca paramca, Intent paramIntent)
  {
    AppMethodBeat.i(34587);
    if (paramca == null)
    {
      AppMethodBeat.o(34587);
      return;
    }
    String str1 = paramca.field_talker;
    String str2 = paramca.field_talker;
    Bundle localBundle = new Bundle();
    if (ab.IT(str1)) {}
    for (int i = 7;; i = 1)
    {
      localBundle.putInt("stat_scene", i);
      localBundle.putString("stat_msg_id", "msg_" + Long.toString(paramca.field_msgSvrId));
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
    Log.i("MicroMsg.ChattingItemHelper", "gotoEditUI() msgId:%s scene:%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    ca localca = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hb(paramLong);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_group_solitatire_create", false);
    localIntent.putExtra("key_group_solitatire_key", localca.fRd);
    localIntent.putExtra("key_group_solitatire_chatroom_username", localca.field_talker);
    localIntent.putExtra("key_group_solitatire_scene", paramInt);
    com.tencent.mm.br.c.a(parama.Pwa, "groupsolitaire", ".ui.GroupSolitatireEditUI", localIntent, 3001, new c.a()
    {
      public final void onActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(34579);
        if (paramAnonymousInt1 == 3001)
        {
          Log.i("MicroMsg.ChattingItemHelper", "gotoEditUI() REQUEST_CODE_VIEW_GROUP_SOLITATIRE resultCode:%s", new Object[] { Integer.valueOf(paramAnonymousInt2) });
          if ((-1 == paramAnonymousInt2) && (paramAnonymousIntent != null)) {
            ((aq)this.PgH.bh(aq.class)).aBt(paramAnonymousIntent.getStringExtra("key_group_solitatire_content"));
          }
        }
        AppMethodBeat.o(34579);
      }
    });
    AppMethodBeat.o(34588);
  }
  
  public static boolean aMJ(String paramString)
  {
    AppMethodBeat.i(34581);
    f localf = com.tencent.mm.ay.a.bef();
    if ((localf != null) && (localf.jeV != null) && (localf.jeT == 0) && (com.tencent.mm.ay.a.bec())) {
      try
      {
        boolean bool = Util.isEqual(localf.jeV, paramString);
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
  
  public static void gA(View paramView)
  {
    AppMethodBeat.i(34580);
    long l1;
    Object localObject1;
    if ((paramView.getTag() instanceof e.g))
    {
      if (!WeChatBrands.Business.Entries.SessionMusic.checkAvailable(paramView.getContext()))
      {
        AppMethodBeat.o(34580);
        return;
      }
      paramView = (e.g)paramView.getTag();
      l1 = paramView.msgId;
      String str1;
      String str2;
      String str3;
      String str4;
      String str5;
      if (paramView.PJr != null)
      {
        localObject1 = paramView.PJr;
        if (aMJ(((e.h)localObject1).JwO))
        {
          com.tencent.mm.ay.a.bea();
          AppMethodBeat.o(34580);
          return;
        }
        localObject2 = ((e.h)localObject1).coverUrl;
        localObject3 = ((e.h)localObject1).title;
        str1 = ((e.h)localObject1).iAA;
        str2 = ((e.h)localObject1).url;
        str3 = ((e.h)localObject1).url;
        str4 = ((e.h)localObject1).playUrl;
        str5 = ((e.h)localObject1).JwO;
        bg.aVF();
        com.tencent.mm.ay.a.c(com.tencent.mm.ay.i.a(0, (String)localObject2, (String)localObject3, str1, str2, str3, str4, str5, com.tencent.mm.model.c.getAccPath(), ((e.h)localObject1).coverUrl, "", "", com.tencent.mm.ay.h.a(((e.h)localObject1).JwO, paramView.jfy)));
        AppMethodBeat.o(34580);
        return;
      }
      if (paramView.PJs == -1)
      {
        bg.aVF();
        localObject1 = com.tencent.mm.model.c.aSQ().Hb(paramView.msgId);
        boolean bool;
        if (aMJ(String.valueOf(l1)))
        {
          com.tencent.mm.plugin.report.service.h.CyF.kvStat(10231, "1");
          com.tencent.mm.ay.a.bea();
          if (((eo)localObject1).field_msgId == l1)
          {
            paramView = com.tencent.mm.modelstat.b.jmd;
            bool = false;
            i = com.tencent.mm.ag.l.t((ca)localObject1);
          }
        }
        for (;;)
        {
          paramView.a((ca)localObject1, bool, i);
          do
          {
            AppMethodBeat.o(34580);
            return;
            localObject2 = k.b.HD(paramView.xml);
            if (localObject2 != null)
            {
              com.tencent.mm.plugin.report.service.h.CyF.kvStat(10090, "0,1");
              long l2 = paramView.msgId;
              localObject3 = paramView.dRr;
              bg.aVF();
              com.tencent.mm.ay.a.c(com.tencent.mm.ay.i.a((k.b)localObject2, String.valueOf(l2), (String)localObject3, com.tencent.mm.model.c.getAccPath(), paramView.dRr, com.tencent.mm.ay.h.a(String.valueOf(paramView.msgId), paramView.jfy)));
            }
          } while (((eo)localObject1).field_msgId != l1);
          paramView = com.tencent.mm.modelstat.b.jmd;
          bool = true;
          if (localObject2 != null) {
            i = ((k.b)localObject2).type;
          } else {
            i = 0;
          }
        }
      }
      Object localObject2 = paramView.msgId + "_" + paramView.PJs;
      bg.aVF();
      localObject1 = com.tencent.mm.model.c.aSQ().Hb(paramView.msgId);
      Object localObject3 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).a(paramView.msgId, paramView.xml);
      if (aMJ((String)localObject2))
      {
        com.tencent.mm.plugin.report.service.h.CyF.kvStat(10231, "1");
        com.tencent.mm.ay.a.bea();
        if (((eo)localObject1).field_msgId == l1) {
          com.tencent.mm.modelstat.b.jmd.a((ca)localObject1, false, com.tencent.mm.ag.l.t((ca)localObject1));
        }
        if ((localObject3 != null) && (((com.tencent.mm.ag.u)localObject3).iAd != null) && (((com.tencent.mm.ag.u)localObject3).iAd.size() > paramView.PJs))
        {
          paramView = (v)((com.tencent.mm.ag.u)localObject3).iAd.get(paramView.PJs);
          localObject1 = com.tencent.mm.plugin.report.service.h.CyF;
          if (paramView.type == 6) {}
          for (i = 1;; i = 0)
          {
            ((com.tencent.mm.plugin.report.service.h)localObject1).a(14972, new Object[] { Integer.valueOf(i), Integer.valueOf(1) });
            AppMethodBeat.o(34580);
            return;
          }
        }
      }
      else if ((localObject3 != null) && (((com.tencent.mm.ag.u)localObject3).iAd != null) && (((com.tencent.mm.ag.u)localObject3).iAd.size() > paramView.PJs))
      {
        com.tencent.mm.plugin.report.service.h.CyF.kvStat(10090, "0,1");
        localObject3 = (v)((com.tencent.mm.ag.u)localObject3).iAd.get(paramView.PJs);
        str1 = paramView.dRr;
        str2 = ((v)localObject3).title;
        str3 = ((v)localObject3).iAA;
        str4 = ((v)localObject3).url;
        str5 = ((v)localObject3).url;
        String str6 = ((v)localObject3).iAz;
        bg.aVF();
        com.tencent.mm.ay.a.c(com.tencent.mm.ay.i.a(0, str1, str2, str3, str4, str5, str6, (String)localObject2, com.tencent.mm.model.c.getAccPath(), paramView.dRr, "", "", com.tencent.mm.ay.h.a((String)localObject2, paramView.jfy)));
        paramView = com.tencent.mm.plugin.report.service.h.CyF;
        if (((v)localObject3).type != 6) {
          break label825;
        }
      }
    }
    label825:
    for (int i = 1;; i = 0)
    {
      paramView.a(14972, new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
      if (((eo)localObject1).field_msgId == l1) {
        com.tencent.mm.modelstat.b.jmd.a((ca)localObject1, true, com.tencent.mm.ag.l.t((ca)localObject1));
      }
      AppMethodBeat.o(34580);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s
 * JD-Core Version:    0.7.0.1
 */