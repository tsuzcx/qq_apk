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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.u;
import com.tencent.mm.ai.v;
import com.tencent.mm.aw.e;
import com.tencent.mm.aw.o;
import com.tencent.mm.bs.d.a;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.b;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.c.b.ai;
import com.tencent.mm.ui.chatting.c.j;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.viewitems.bi;
import com.tencent.mm.ui.chatting.viewitems.e.g;
import com.tencent.mm.ui.chatting.viewitems.e.h;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.vfs.i;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedList;

public final class r
{
  public static void a(int paramInt, Context paramContext, String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(34584);
    paramString1 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(paramLong1, paramString1);
    if (paramString1 == null)
    {
      ad.w("MicroMsg.ChattingItemHelper", "transmitAppBrandMsg reader is null");
      AppMethodBeat.o(34584);
      return;
    }
    if ((paramInt >= 0) && (paramInt < paramString1.gKs.size()))
    {
      paramString1 = (v)paramString1.gKs.get(paramInt);
      Object localObject = k.b.a(l.a(paramString2, paramString1), null, null);
      if (bt.isNullOrNil((String)localObject))
      {
        AppMethodBeat.o(34584);
        return;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("desc", paramString1.gKF);
      localHashMap.put("type", Integer.valueOf(2));
      localHashMap.put("title", paramString1.title);
      localHashMap.put("app_id", paramString1.gKM);
      localHashMap.put("pkg_type", Integer.valueOf(paramString1.gKL));
      localHashMap.put("pkg_version", Integer.valueOf(paramString1.gKK));
      localHashMap.put("img_url", paramString1.gKN);
      localHashMap.put("is_dynamic", Boolean.FALSE);
      localHashMap.put("cache_key", "");
      localHashMap.put("path", paramString1.gKJ);
      paramString1 = new Intent(paramContext, MsgRetransmitUI.class);
      paramString1.putExtra("appbrand_params", localHashMap);
      paramString1.putExtra("Retr_Msg_content", (String)localObject);
      paramString1.putExtra("Retr_Msg_Type", 2);
      paramString1.putExtra("Retr_Biz_Msg_Selected_Msg_Index", paramInt);
      paramString1.putExtra("Retr_Msg_Id", paramLong1);
      paramString1.putExtra("Retr_MsgFromScene", 3);
      localObject = y.tD(String.valueOf(paramLong2));
      paramString1.putExtra("reportSessionId", (String)localObject);
      localObject = y.arz().E((String)localObject, true);
      ((y.b)localObject).m("prePublishId", "msg_".concat(String.valueOf(paramLong2)));
      ((y.b)localObject).m("preUsername", paramString2);
      ((y.b)localObject).m("preChatName", paramString2);
      ((y.b)localObject).m("preMsgIndex", Integer.valueOf(paramInt));
      ((y.b)localObject).m("sendAppMsgScene", Integer.valueOf(1));
      paramString1 = new com.tencent.mm.hellhoundlib.b.a().bd(paramString1);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString1.adn(), "com/tencent/mm/ui/chatting/ChattingItemHelper", "transmitAppBrandMsg", "(ILandroid/content/Context;Ljava/lang/String;Ljava/lang/String;JJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString1.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/chatting/ChattingItemHelper", "transmitAppBrandMsg", "(ILandroid/content/Context;Ljava/lang/String;Ljava/lang/String;JJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(34584);
  }
  
  public static void a(long paramLong, int paramInt, Context paramContext, Fragment paramFragment, Activity paramActivity, bl parambl)
  {
    AppMethodBeat.i(34585);
    Object localObject = parambl.field_talker;
    String str = y.tD(parambl.field_msgSvrId);
    y.b localb = y.arz().E(str, true);
    localb.m("prePublishId", "msg_" + parambl.field_msgSvrId);
    localb.m("preUsername", localObject);
    localb.m("preChatName", localObject);
    localb.m("preMsgIndex", Integer.valueOf(paramInt));
    localb.m("sendAppMsgScene", Integer.valueOf(1));
    localObject = new cs();
    ((cs)localObject).deQ.deU = paramInt;
    ((cs)localObject).deQ.sessionId = str;
    ((cs)localObject).deQ.fragment = paramFragment;
    ((cs)localObject).deQ.activity = paramActivity;
    ((cs)localObject).deQ.deW = 40;
    com.tencent.mm.pluginsdk.model.g.e((cs)localObject, parambl);
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    if (((cs)localObject).deR.ret == 0)
    {
      paramFragment = k.b.rx(m.a(paramContext, paramInt, parambl.field_content, parambl.field_talker, parambl.field_msgId));
      if (!parambl.cxB()) {
        break label416;
      }
      paramContext = com.tencent.mm.modelstat.b.huc;
      if (paramFragment == null) {
        break label411;
      }
      paramInt = paramFragment.type;
      paramContext.c(parambl, paramInt);
    }
    for (;;)
    {
      if ((paramFragment != null) && (paramFragment.type == 5) && (paramFragment.url != null))
      {
        ad.d("MicroMsg.ChattingItemHelper", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), paramFragment.url, Long.valueOf(paramLong), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1) });
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
          ad.printErrStackTrace("MicroMsg.ChattingItemHelper", paramFragment, "", new Object[0]);
        }
      }
      com.tencent.mm.plugin.report.service.h.vKh.f(13378, new Object[] { paramContext, Long.valueOf(paramLong), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1) });
      AppMethodBeat.o(34585);
      return;
      label411:
      paramInt = 0;
      break;
      label416:
      com.tencent.mm.modelstat.b.huc.P(parambl);
    }
  }
  
  public static void a(View paramView, Context paramContext, String paramString)
  {
    AppMethodBeat.i(34582);
    bi localbi = (bi)paramView.getTag();
    String str = localbi.dft;
    paramView = str;
    if (TextUtils.isEmpty(str)) {
      paramView = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().TG(localbi.eOT);
    }
    if (TextUtils.isEmpty(paramView))
    {
      paramView = new Intent();
      paramView.putExtra("geta8key_username", paramString);
      paramView.putExtra("rawUrl", localbi.eOT);
      com.tencent.mm.bs.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramView);
      AppMethodBeat.o(34582);
      return;
    }
    paramString = new Intent();
    paramString.putExtra("extra_id", paramView);
    paramString.putExtra("extra_name", localbi.title);
    if (localbi.GQR)
    {
      paramString.putExtra("download_entrance_scene", 20);
      paramString.putExtra("preceding_scence", 3);
      paramString.putExtra("reward_tip", true);
      com.tencent.mm.plugin.report.service.h.vKh.f(12953, new Object[] { Integer.valueOf(1), paramView });
    }
    for (;;)
    {
      com.tencent.mm.bs.d.b(paramContext, "emoji", ".ui.EmojiStoreDetailUI", paramString);
      AppMethodBeat.o(34582);
      return;
      if (localbi.GQS)
      {
        paramString.putExtra("download_entrance_scene", 25);
        paramString.putExtra("preceding_scence", 9);
        paramString.putExtra("reward_tip", true);
      }
      else
      {
        paramString.putExtra("download_entrance_scene", 22);
        paramString.putExtra("preceding_scence", 122);
        com.tencent.mm.plugin.report.service.h.vKh.f(10993, new Object[] { Integer.valueOf(2), paramView });
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
        paramAnonymousView = (bi)paramAnonymousView.getTag();
        ad.i("MicroMsg.ChattingItemHelper", "on app brand(%s) button1 click", new Object[] { this.naH.gKI });
        uj localuj = new uj();
        localuj.dzH.userName = this.naH.gKI;
        localuj.dzH.dzJ = this.naH.gKJ;
        localuj.dzH.dzK = this.naH.gKL;
        localuj.dzH.aAS = this.naH.gKK;
        localuj.dzH.dzN = true;
        localuj.dzH.scene = 1076;
        localuj.dzH.dbt = (paramString + ":" + paramAnonymousView.drF.field_msgSvrId + ":" + paramAnonymousView.AYK);
        com.tencent.mm.sdk.b.a.ESL.l(localuj);
        AppMethodBeat.o(34578);
      }
    });
    AppMethodBeat.o(34583);
  }
  
  public static void a(bl parambl, Context paramContext, com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(34586);
    az.arV();
    if (!c.isSDCardAvailable())
    {
      t.g(paramContext, parama.GzJ.getContentView());
      AppMethodBeat.o(34586);
      return;
    }
    Object localObject = null;
    if (parambl.field_msgId > 0L) {
      localObject = o.ayF().ms(parambl.field_msgId);
    }
    if (((localObject == null) || (((e)localObject).deI <= 0L)) && (parambl.field_msgSvrId > 0L)) {
      localObject = o.ayF().mr(parambl.field_msgSvrId);
    }
    for (;;)
    {
      if (localObject == null)
      {
        AppMethodBeat.o(34586);
        return;
      }
      int i;
      if (parambl.field_isSend == 1) {
        if (((e)localObject).ayi()) {
          i = 1;
        }
      }
      while (parambl.eMl())
      {
        ad.i("MicroMsg.ChattingItemHelper", "image is clean!!!");
        com.tencent.mm.ui.base.h.d(paramContext, paramContext.getString(2131760321), paramContext.getString(2131755906), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(34586);
        return;
        i = 0;
        continue;
        if (!((e)localObject).ayi())
        {
          i = 0;
        }
        else
        {
          e locale = com.tencent.mm.aw.f.a((e)localObject);
          if (!i.eK(o.ayF().p(locale.hgj, "", ""))) {
            i = 0;
          } else {
            i = 1;
          }
        }
      }
      if (j.e(parambl, o.ayF().p(com.tencent.mm.aw.f.c((e)localObject), "", "")))
      {
        ad.i("MicroMsg.ChattingItemHelper", "img is expired or clean!!!");
        ad.i("MicroMsg.ChattingItemHelper", "[ImageGalleryUI] enter");
        localObject = new Intent(paramContext, ImageGalleryUI.class);
        ((Intent)localObject).putExtra("img_gallery_msg_id", parambl.field_msgId);
        ((Intent)localObject).putExtra("img_gallery_msg_svr_id", parambl.field_msgSvrId);
        ((Intent)localObject).putExtra("img_gallery_talker", parambl.field_talker);
        ((Intent)localObject).putExtra("img_gallery_chatroom_name", parambl.field_talker);
        ((Intent)localObject).putExtra("img_gallery_is_restransmit_after_download", true);
        ((Intent)localObject).putExtra("Retr_show_success_tips", true);
        if (parama != null) {
          j.a(parama, parambl, (Intent)localObject);
        }
        for (;;)
        {
          parambl = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, parambl.adn(), "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)parambl.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(34586);
          return;
          a(parambl, (Intent)localObject);
        }
      }
      if ((((e)localObject).offset >= ((e)localObject).gTY) && (((e)localObject).gTY != 0))
      {
        parama = new Intent(paramContext, MsgRetransmitUI.class);
        parama.putExtra("Retr_File_Name", o.ayF().p(com.tencent.mm.aw.f.c((e)localObject), "", ""));
        parama.putExtra("Retr_Msg_Id", parambl.field_msgId);
        parama.putExtra("Retr_Msg_Type", 0);
        parama.putExtra("Retr_show_success_tips", true);
        parama.putExtra("Retr_Compress_Type", i);
        parambl = new com.tencent.mm.hellhoundlib.b.a().bd(parama);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, parambl.adn(), "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)parambl.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(34586);
        return;
      }
      parama = new Intent(paramContext, MsgRetransmitUI.class);
      parama.putExtra("Retr_File_Name", o.ayF().Q(parambl.field_imgPath, true));
      parama.putExtra("Retr_Msg_Id", parambl.field_msgId);
      parama.putExtra("Retr_Msg_Type", 0);
      parama.putExtra("Retr_show_success_tips", true);
      parama.putExtra("Retr_Compress_Type", i);
      parambl = new com.tencent.mm.hellhoundlib.b.a().bd(parama);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, parambl.adn(), "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)parambl.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(34586);
      return;
    }
  }
  
  private static void a(bl parambl, Intent paramIntent)
  {
    AppMethodBeat.i(34587);
    if (parambl == null)
    {
      AppMethodBeat.o(34587);
      return;
    }
    String str1 = parambl.field_talker;
    String str2 = parambl.field_talker;
    Bundle localBundle = new Bundle();
    if (w.sE(str1)) {}
    for (int i = 7;; i = 1)
    {
      localBundle.putInt("stat_scene", i);
      localBundle.putString("stat_msg_id", "msg_" + Long.toString(parambl.field_msgSvrId));
      localBundle.putString("stat_chat_talker_username", str1);
      localBundle.putString("stat_send_msg_user", str2);
      paramIntent.putExtra("_stat_obj", localBundle);
      AppMethodBeat.o(34587);
      return;
    }
  }
  
  public static void a(com.tencent.mm.ui.chatting.d.a parama, long paramLong, int paramInt)
  {
    AppMethodBeat.i(34588);
    ad.i("MicroMsg.ChattingItemHelper", "gotoEditUI() msgId:%s scene:%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    bl localbl = ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().rm(paramLong);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_group_solitatire_create", false);
    localIntent.putExtra("key_group_solitatire_key", localbl.ePf);
    localIntent.putExtra("key_group_solitatire_chatroom_username", localbl.field_talker);
    localIntent.putExtra("key_group_solitatire_scene", paramInt);
    com.tencent.mm.bs.d.a(parama.GzG, "groupsolitaire", ".ui.GroupSolitatireEditUI", localIntent, 3001, new d.a()
    {
      public final void onActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(34579);
        if (paramAnonymousInt1 == 3001)
        {
          ad.i("MicroMsg.ChattingItemHelper", "gotoEditUI() REQUEST_CODE_VIEW_GROUP_SOLITATIRE resultCode:%s", new Object[] { Integer.valueOf(paramAnonymousInt2) });
          if ((-1 == paramAnonymousInt2) && (paramAnonymousIntent != null)) {
            ((ai)this.GmY.be(ai.class)).adu(paramAnonymousIntent.getStringExtra("key_group_solitatire_content"));
          }
        }
        AppMethodBeat.o(34579);
      }
    });
    AppMethodBeat.o(34588);
  }
  
  private static boolean amF(String paramString)
  {
    AppMethodBeat.i(34581);
    com.tencent.mm.az.f localf = com.tencent.mm.az.a.azI();
    if ((localf != null) && (localf.hnp != null) && (localf.hnn == 0) && (com.tencent.mm.az.a.azF())) {
      try
      {
        boolean bool = bt.kU(localf.hnp, paramString);
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
  
  public static void fH(View paramView)
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
      if (paramView.GKn != null)
      {
        paramView = paramView.GKn;
        if (amF(paramView.Btj))
        {
          com.tencent.mm.az.a.azD();
          AppMethodBeat.o(34580);
          return;
        }
        localObject1 = paramView.coverUrl;
        localObject2 = paramView.title;
        localObject3 = paramView.gKR;
        str1 = paramView.url;
        str2 = paramView.url;
        str3 = paramView.playUrl;
        str4 = paramView.Btj;
        az.arV();
        com.tencent.mm.az.a.c(com.tencent.mm.az.h.a(0, (String)localObject1, (String)localObject2, (String)localObject3, str1, str2, str3, str4, c.getAccPath(), paramView.coverUrl, "", ""));
        AppMethodBeat.o(34580);
        return;
      }
      if (paramView.GKo == -1)
      {
        az.arV();
        localObject1 = c.apO().rm(paramView.msgId);
        boolean bool;
        if (amF(String.valueOf(l1)))
        {
          com.tencent.mm.plugin.report.service.h.vKh.kvStat(10231, "1");
          com.tencent.mm.az.a.azD();
          if (((du)localObject1).field_msgId == l1)
          {
            paramView = com.tencent.mm.modelstat.b.huc;
            bool = false;
            i = com.tencent.mm.ai.l.r((bl)localObject1);
          }
        }
        for (;;)
        {
          paramView.a((bl)localObject1, bool, i);
          do
          {
            AppMethodBeat.o(34580);
            return;
            localObject2 = k.b.rx(paramView.dsv);
            if (localObject2 != null)
            {
              com.tencent.mm.plugin.report.service.h.vKh.kvStat(10090, "0,1");
              long l2 = paramView.msgId;
              localObject3 = paramView.dpa;
              az.arV();
              com.tencent.mm.az.a.c(com.tencent.mm.az.h.a((k.b)localObject2, String.valueOf(l2), (String)localObject3, c.getAccPath(), paramView.dpa));
            }
          } while (((du)localObject1).field_msgId != l1);
          paramView = com.tencent.mm.modelstat.b.huc;
          bool = true;
          if (localObject2 != null) {
            i = ((k.b)localObject2).type;
          } else {
            i = 0;
          }
        }
      }
      Object localObject2 = paramView.msgId + "_" + paramView.GKo;
      az.arV();
      localObject1 = c.apO().rm(paramView.msgId);
      Object localObject3 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(paramView.msgId, paramView.dsv);
      if (amF((String)localObject2))
      {
        com.tencent.mm.plugin.report.service.h.vKh.kvStat(10231, "1");
        com.tencent.mm.az.a.azD();
        if (((du)localObject1).field_msgId == l1) {
          com.tencent.mm.modelstat.b.huc.a((bl)localObject1, false, com.tencent.mm.ai.l.r((bl)localObject1));
        }
        if ((localObject3 != null) && (((u)localObject3).gKs != null) && (((u)localObject3).gKs.size() > paramView.GKo))
        {
          paramView = (v)((u)localObject3).gKs.get(paramView.GKo);
          localObject1 = com.tencent.mm.plugin.report.service.h.vKh;
          if (paramView.type == 6) {}
          for (i = 1;; i = 0)
          {
            ((com.tencent.mm.plugin.report.service.h)localObject1).f(14972, new Object[] { Integer.valueOf(i), Integer.valueOf(1) });
            AppMethodBeat.o(34580);
            return;
          }
        }
      }
      else if ((localObject3 != null) && (((u)localObject3).gKs != null) && (((u)localObject3).gKs.size() > paramView.GKo))
      {
        com.tencent.mm.plugin.report.service.h.vKh.kvStat(10090, "0,1");
        localObject3 = (v)((u)localObject3).gKs.get(paramView.GKo);
        str1 = paramView.dpa;
        str2 = ((v)localObject3).title;
        str3 = ((v)localObject3).gKR;
        str4 = ((v)localObject3).url;
        String str5 = ((v)localObject3).url;
        String str6 = ((v)localObject3).gKQ;
        az.arV();
        com.tencent.mm.az.a.c(com.tencent.mm.az.h.a(0, str1, str2, str3, str4, str5, str6, (String)localObject2, c.getAccPath(), paramView.dpa, "", ""));
        paramView = com.tencent.mm.plugin.report.service.h.vKh;
        if (((v)localObject3).type != 6) {
          break label760;
        }
      }
    }
    label760:
    for (int i = 1;; i = 0)
    {
      paramView.f(14972, new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
      if (((du)localObject1).field_msgId == l1) {
        com.tencent.mm.modelstat.b.huc.a((bl)localObject1, true, com.tencent.mm.ai.l.r((bl)localObject1));
      }
      AppMethodBeat.o(34580);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.r
 * JD-Core Version:    0.7.0.1
 */