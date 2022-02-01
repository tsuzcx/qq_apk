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
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.u;
import com.tencent.mm.ah.v;
import com.tencent.mm.av.e;
import com.tencent.mm.av.o;
import com.tencent.mm.br.d.a;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.b;
import com.tencent.mm.g.a.ut;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.c.b.ai;
import com.tencent.mm.ui.chatting.c.j;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.viewitems.bj;
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
      ac.w("MicroMsg.ChattingItemHelper", "transmitAppBrandMsg reader is null");
      AppMethodBeat.o(34584);
      return;
    }
    if ((paramInt >= 0) && (paramInt < paramString1.hkS.size()))
    {
      paramString1 = (v)paramString1.hkS.get(paramInt);
      Object localObject = k.b.a(l.a(paramString2, paramString1), null, null);
      if (bs.isNullOrNil((String)localObject))
      {
        AppMethodBeat.o(34584);
        return;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("desc", paramString1.hlf);
      localHashMap.put("type", Integer.valueOf(2));
      localHashMap.put("title", paramString1.title);
      localHashMap.put("app_id", paramString1.hlm);
      localHashMap.put("pkg_type", Integer.valueOf(paramString1.hll));
      localHashMap.put("pkg_version", Integer.valueOf(paramString1.hlk));
      localHashMap.put("img_url", paramString1.hln);
      localHashMap.put("is_dynamic", Boolean.FALSE);
      localHashMap.put("cache_key", "");
      localHashMap.put("path", paramString1.hlj);
      paramString1 = new Intent(paramContext, MsgRetransmitUI.class);
      paramString1.putExtra("appbrand_params", localHashMap);
      paramString1.putExtra("Retr_Msg_content", (String)localObject);
      paramString1.putExtra("Retr_Msg_Type", 2);
      paramString1.putExtra("Retr_Biz_Msg_Selected_Msg_Index", paramInt);
      paramString1.putExtra("Retr_Msg_Id", paramLong1);
      paramString1.putExtra("Retr_MsgFromScene", 3);
      localObject = y.xJ(String.valueOf(paramLong2));
      paramString1.putExtra("reportSessionId", (String)localObject);
      localObject = y.ayq().F((String)localObject, true);
      ((y.b)localObject).l("prePublishId", "msg_".concat(String.valueOf(paramLong2)));
      ((y.b)localObject).l("preUsername", paramString2);
      ((y.b)localObject).l("preChatName", paramString2);
      ((y.b)localObject).l("preMsgIndex", Integer.valueOf(paramInt));
      ((y.b)localObject).l("sendAppMsgScene", Integer.valueOf(1));
      paramString1 = new com.tencent.mm.hellhoundlib.b.a().ba(paramString1);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString1.aeD(), "com/tencent/mm/ui/chatting/ChattingItemHelper", "transmitAppBrandMsg", "(ILandroid/content/Context;Ljava/lang/String;Ljava/lang/String;JJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString1.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/chatting/ChattingItemHelper", "transmitAppBrandMsg", "(ILandroid/content/Context;Ljava/lang/String;Ljava/lang/String;JJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(34584);
  }
  
  public static void a(long paramLong, int paramInt, Context paramContext, Fragment paramFragment, Activity paramActivity, bo parambo)
  {
    AppMethodBeat.i(34585);
    Object localObject = parambo.field_talker;
    String str = y.xJ(parambo.field_msgSvrId);
    y.b localb = y.ayq().F(str, true);
    localb.l("prePublishId", "msg_" + parambo.field_msgSvrId);
    localb.l("preUsername", localObject);
    localb.l("preChatName", localObject);
    localb.l("preMsgIndex", Integer.valueOf(paramInt));
    localb.l("sendAppMsgScene", Integer.valueOf(1));
    localObject = new cs();
    ((cs)localObject).dck.dco = paramInt;
    ((cs)localObject).dck.sessionId = str;
    ((cs)localObject).dck.fragment = paramFragment;
    ((cs)localObject).dck.activity = paramActivity;
    ((cs)localObject).dck.dcq = 40;
    com.tencent.mm.pluginsdk.model.g.e((cs)localObject, parambo);
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    if (((cs)localObject).dcl.ret == 0)
    {
      paramFragment = k.b.vA(m.a(paramContext, paramInt, parambo.field_content, parambo.field_talker, parambo.field_msgId));
      if (!parambo.cKN()) {
        break label416;
      }
      paramContext = com.tencent.mm.modelstat.b.hUE;
      if (paramFragment == null) {
        break label411;
      }
      paramInt = paramFragment.type;
      paramContext.c(parambo, paramInt);
    }
    for (;;)
    {
      if ((paramFragment != null) && (paramFragment.type == 5) && (paramFragment.url != null))
      {
        ac.d("MicroMsg.ChattingItemHelper", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), paramFragment.url, Long.valueOf(paramLong), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1) });
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
          ac.printErrStackTrace("MicroMsg.ChattingItemHelper", paramFragment, "", new Object[0]);
        }
      }
      com.tencent.mm.plugin.report.service.h.wUl.f(13378, new Object[] { paramContext, Long.valueOf(paramLong), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1) });
      AppMethodBeat.o(34585);
      return;
      label411:
      paramInt = 0;
      break;
      label416:
      com.tencent.mm.modelstat.b.hUE.P(parambo);
    }
  }
  
  public static void a(View paramView, Context paramContext, String paramString)
  {
    AppMethodBeat.i(34582);
    bj localbj = (bj)paramView.getTag();
    String str = localbj.dcO;
    paramView = str;
    if (TextUtils.isEmpty(str)) {
      paramView = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XS(localbj.eSb);
    }
    if (TextUtils.isEmpty(paramView))
    {
      paramView = new Intent();
      paramView.putExtra("geta8key_username", paramString);
      paramView.putExtra("rawUrl", localbj.eSb);
      com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramView);
      AppMethodBeat.o(34582);
      return;
    }
    paramString = new Intent();
    paramString.putExtra("extra_id", paramView);
    paramString.putExtra("extra_name", localbj.title);
    if (localbj.IqS)
    {
      paramString.putExtra("download_entrance_scene", 20);
      paramString.putExtra("preceding_scence", 3);
      paramString.putExtra("reward_tip", true);
      com.tencent.mm.plugin.report.service.h.wUl.f(12953, new Object[] { Integer.valueOf(1), paramView });
    }
    for (;;)
    {
      com.tencent.mm.br.d.b(paramContext, "emoji", ".ui.EmojiStoreDetailUI", paramString);
      AppMethodBeat.o(34582);
      return;
      if (localbj.IqT)
      {
        paramString.putExtra("download_entrance_scene", 25);
        paramString.putExtra("preceding_scence", 9);
        paramString.putExtra("reward_tip", true);
      }
      else
      {
        paramString.putExtra("download_entrance_scene", 22);
        paramString.putExtra("preceding_scence", 122);
        com.tencent.mm.plugin.report.service.h.wUl.f(10993, new Object[] { Integer.valueOf(2), paramView });
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
        paramAnonymousView = (bj)paramAnonymousView.getTag();
        ac.i("MicroMsg.ChattingItemHelper", "on app brand(%s) button1 click", new Object[] { this.nDf.hli });
        ut localut = new ut();
        localut.dxt.userName = this.nDf.hli;
        localut.dxt.dxv = this.nDf.hlj;
        localut.dxt.dxw = this.nDf.hll;
        localut.dxt.aBM = this.nDf.hlk;
        localut.dxt.dxz = true;
        localut.dxt.scene = 1076;
        localut.dxt.cYP = (paramString + ":" + paramAnonymousView.dpq.field_msgSvrId + ":" + paramAnonymousView.CqX);
        com.tencent.mm.sdk.b.a.GpY.l(localut);
        AppMethodBeat.o(34578);
      }
    });
    AppMethodBeat.o(34583);
  }
  
  public static void a(bo parambo, Context paramContext, com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(34586);
    az.ayM();
    if (!c.isSDCardAvailable())
    {
      t.g(paramContext, parama.HZF.getContentView());
      AppMethodBeat.o(34586);
      return;
    }
    Object localObject = null;
    if (parambo.field_msgId > 0L) {
      localObject = o.aFx().qg(parambo.field_msgId);
    }
    if (((localObject == null) || (((e)localObject).dcd <= 0L)) && (parambo.field_msgSvrId > 0L)) {
      localObject = o.aFx().qf(parambo.field_msgSvrId);
    }
    for (;;)
    {
      if (localObject == null)
      {
        AppMethodBeat.o(34586);
        return;
      }
      int i;
      if (parambo.field_isSend == 1) {
        if (((e)localObject).aFa()) {
          i = 1;
        }
      }
      while (parambo.fbQ())
      {
        ac.i("MicroMsg.ChattingItemHelper", "image is clean!!!");
        com.tencent.mm.ui.base.h.d(paramContext, paramContext.getString(2131760321), paramContext.getString(2131755906), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(34586);
        return;
        i = 0;
        continue;
        if (!((e)localObject).aFa())
        {
          i = 0;
        }
        else
        {
          e locale = com.tencent.mm.av.f.a((e)localObject);
          if (!i.eA(o.aFx().p(locale.hGM, "", ""))) {
            i = 0;
          } else {
            i = 1;
          }
        }
      }
      if (j.e(parambo, o.aFx().p(com.tencent.mm.av.f.c((e)localObject), "", "")))
      {
        ac.i("MicroMsg.ChattingItemHelper", "img is expired or clean!!!");
        ac.i("MicroMsg.ChattingItemHelper", "[ImageGalleryUI] enter");
        localObject = new Intent(paramContext, ImageGalleryUI.class);
        ((Intent)localObject).putExtra("img_gallery_msg_id", parambo.field_msgId);
        ((Intent)localObject).putExtra("img_gallery_msg_svr_id", parambo.field_msgSvrId);
        ((Intent)localObject).putExtra("img_gallery_talker", parambo.field_talker);
        ((Intent)localObject).putExtra("img_gallery_chatroom_name", parambo.field_talker);
        ((Intent)localObject).putExtra("img_gallery_is_restransmit_after_download", true);
        ((Intent)localObject).putExtra("Retr_show_success_tips", true);
        if (parama != null) {
          j.a(parama, parambo, (Intent)localObject);
        }
        for (;;)
        {
          parambo = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, parambo.aeD(), "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)parambo.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(34586);
          return;
          a(parambo, (Intent)localObject);
        }
      }
      if ((((e)localObject).offset >= ((e)localObject).hux) && (((e)localObject).hux != 0))
      {
        parama = new Intent(paramContext, MsgRetransmitUI.class);
        parama.putExtra("Retr_File_Name", o.aFx().p(com.tencent.mm.av.f.c((e)localObject), "", ""));
        parama.putExtra("Retr_Msg_Id", parambo.field_msgId);
        parama.putExtra("Retr_Msg_Type", 0);
        parama.putExtra("Retr_show_success_tips", true);
        parama.putExtra("Retr_Compress_Type", i);
        parambo = new com.tencent.mm.hellhoundlib.b.a().ba(parama);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, parambo.aeD(), "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)parambo.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(34586);
        return;
      }
      parama = new Intent(paramContext, MsgRetransmitUI.class);
      parama.putExtra("Retr_File_Name", o.aFx().R(parambo.field_imgPath, true));
      parama.putExtra("Retr_Msg_Id", parambo.field_msgId);
      parama.putExtra("Retr_Msg_Type", 0);
      parama.putExtra("Retr_show_success_tips", true);
      parama.putExtra("Retr_Compress_Type", i);
      parambo = new com.tencent.mm.hellhoundlib.b.a().ba(parama);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, parambo.aeD(), "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)parambo.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(34586);
      return;
    }
  }
  
  private static void a(bo parambo, Intent paramIntent)
  {
    AppMethodBeat.i(34587);
    if (parambo == null)
    {
      AppMethodBeat.o(34587);
      return;
    }
    String str1 = parambo.field_talker;
    String str2 = parambo.field_talker;
    Bundle localBundle = new Bundle();
    if (w.wH(str1)) {}
    for (int i = 7;; i = 1)
    {
      localBundle.putInt("stat_scene", i);
      localBundle.putString("stat_msg_id", "msg_" + Long.toString(parambo.field_msgSvrId));
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
    ac.i("MicroMsg.ChattingItemHelper", "gotoEditUI() msgId:%s scene:%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    bo localbo = ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().vP(paramLong);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_group_solitatire_create", false);
    localIntent.putExtra("key_group_solitatire_key", localbo.eSn);
    localIntent.putExtra("key_group_solitatire_chatroom_username", localbo.field_talker);
    localIntent.putExtra("key_group_solitatire_scene", paramInt);
    com.tencent.mm.br.d.a(parama.HZC, "groupsolitaire", ".ui.GroupSolitatireEditUI", localIntent, 3001, new d.a()
    {
      public final void onActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(34579);
        if (paramAnonymousInt1 == 3001)
        {
          ac.i("MicroMsg.ChattingItemHelper", "gotoEditUI() REQUEST_CODE_VIEW_GROUP_SOLITATIRE resultCode:%s", new Object[] { Integer.valueOf(paramAnonymousInt2) });
          if ((-1 == paramAnonymousInt2) && (paramAnonymousIntent != null)) {
            ((ai)this.HMO.bf(ai.class)).aim(paramAnonymousIntent.getStringExtra("key_group_solitatire_content"));
          }
        }
        AppMethodBeat.o(34579);
      }
    });
    AppMethodBeat.o(34588);
  }
  
  private static boolean arO(String paramString)
  {
    AppMethodBeat.i(34581);
    com.tencent.mm.ay.f localf = com.tencent.mm.ay.a.aGy();
    if ((localf != null) && (localf.hNS != null) && (localf.hNQ == 0) && (com.tencent.mm.ay.a.aGv())) {
      try
      {
        boolean bool = bs.lr(localf.hNS, paramString);
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
  
  public static void fU(View paramView)
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
      if (paramView.Ikk != null)
      {
        paramView = paramView.Ikk;
        if (arO(paramView.CLp))
        {
          com.tencent.mm.ay.a.aGt();
          AppMethodBeat.o(34580);
          return;
        }
        localObject1 = paramView.coverUrl;
        localObject2 = paramView.title;
        localObject3 = paramView.hlr;
        str1 = paramView.url;
        str2 = paramView.url;
        str3 = paramView.playUrl;
        str4 = paramView.CLp;
        az.ayM();
        com.tencent.mm.ay.a.c(com.tencent.mm.ay.h.a(0, (String)localObject1, (String)localObject2, (String)localObject3, str1, str2, str3, str4, c.getAccPath(), paramView.coverUrl, "", ""));
        AppMethodBeat.o(34580);
        return;
      }
      if (paramView.Ikl == -1)
      {
        az.ayM();
        localObject1 = c.awD().vP(paramView.msgId);
        boolean bool;
        if (arO(String.valueOf(l1)))
        {
          com.tencent.mm.plugin.report.service.h.wUl.kvStat(10231, "1");
          com.tencent.mm.ay.a.aGt();
          if (((dy)localObject1).field_msgId == l1)
          {
            paramView = com.tencent.mm.modelstat.b.hUE;
            bool = false;
            i = com.tencent.mm.ah.l.r((bo)localObject1);
          }
        }
        for (;;)
        {
          paramView.a((bo)localObject1, bool, i);
          do
          {
            AppMethodBeat.o(34580);
            return;
            localObject2 = k.b.vA(paramView.dqf);
            if (localObject2 != null)
            {
              com.tencent.mm.plugin.report.service.h.wUl.kvStat(10090, "0,1");
              long l2 = paramView.msgId;
              localObject3 = paramView.dmK;
              az.ayM();
              com.tencent.mm.ay.a.c(com.tencent.mm.ay.h.a((k.b)localObject2, String.valueOf(l2), (String)localObject3, c.getAccPath(), paramView.dmK));
            }
          } while (((dy)localObject1).field_msgId != l1);
          paramView = com.tencent.mm.modelstat.b.hUE;
          bool = true;
          if (localObject2 != null) {
            i = ((k.b)localObject2).type;
          } else {
            i = 0;
          }
        }
      }
      Object localObject2 = paramView.msgId + "_" + paramView.Ikl;
      az.ayM();
      localObject1 = c.awD().vP(paramView.msgId);
      Object localObject3 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(paramView.msgId, paramView.dqf);
      if (arO((String)localObject2))
      {
        com.tencent.mm.plugin.report.service.h.wUl.kvStat(10231, "1");
        com.tencent.mm.ay.a.aGt();
        if (((dy)localObject1).field_msgId == l1) {
          com.tencent.mm.modelstat.b.hUE.a((bo)localObject1, false, com.tencent.mm.ah.l.r((bo)localObject1));
        }
        if ((localObject3 != null) && (((u)localObject3).hkS != null) && (((u)localObject3).hkS.size() > paramView.Ikl))
        {
          paramView = (v)((u)localObject3).hkS.get(paramView.Ikl);
          localObject1 = com.tencent.mm.plugin.report.service.h.wUl;
          if (paramView.type == 6) {}
          for (i = 1;; i = 0)
          {
            ((com.tencent.mm.plugin.report.service.h)localObject1).f(14972, new Object[] { Integer.valueOf(i), Integer.valueOf(1) });
            AppMethodBeat.o(34580);
            return;
          }
        }
      }
      else if ((localObject3 != null) && (((u)localObject3).hkS != null) && (((u)localObject3).hkS.size() > paramView.Ikl))
      {
        com.tencent.mm.plugin.report.service.h.wUl.kvStat(10090, "0,1");
        localObject3 = (v)((u)localObject3).hkS.get(paramView.Ikl);
        str1 = paramView.dmK;
        str2 = ((v)localObject3).title;
        str3 = ((v)localObject3).hlr;
        str4 = ((v)localObject3).url;
        String str5 = ((v)localObject3).url;
        String str6 = ((v)localObject3).hlq;
        az.ayM();
        com.tencent.mm.ay.a.c(com.tencent.mm.ay.h.a(0, str1, str2, str3, str4, str5, str6, (String)localObject2, c.getAccPath(), paramView.dmK, "", ""));
        paramView = com.tencent.mm.plugin.report.service.h.wUl;
        if (((v)localObject3).type != 6) {
          break label760;
        }
      }
    }
    label760:
    for (int i = 1;; i = 0)
    {
      paramView.f(14972, new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
      if (((dy)localObject1).field_msgId == l1) {
        com.tencent.mm.modelstat.b.hUE.a((bo)localObject1, true, com.tencent.mm.ah.l.r((bo)localObject1));
      }
      AppMethodBeat.o(34580);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.r
 * JD-Core Version:    0.7.0.1
 */