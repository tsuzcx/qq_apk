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
import com.tencent.mm.aw.q;
import com.tencent.mm.az.f;
import com.tencent.mm.bs.d.a;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.cv.b;
import com.tencent.mm.g.a.vm;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.d.b.am;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.viewitems.bk;
import com.tencent.mm.ui.chatting.viewitems.e.g;
import com.tencent.mm.ui.chatting.viewitems.e.h;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
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
    if ((paramInt >= 0) && (paramInt < paramString1.hDb.size()))
    {
      paramString1 = (v)paramString1.hDb.get(paramInt);
      Object localObject = k.b.a(l.a(paramString2, paramString1), null, null);
      if (bt.isNullOrNil((String)localObject))
      {
        AppMethodBeat.o(34584);
        return;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("desc", paramString1.hDo);
      localHashMap.put("type", Integer.valueOf(2));
      localHashMap.put("title", paramString1.title);
      localHashMap.put("app_id", paramString1.hDv);
      localHashMap.put("pkg_type", Integer.valueOf(paramString1.hDu));
      localHashMap.put("pkg_version", Integer.valueOf(paramString1.hDt));
      localHashMap.put("img_url", paramString1.hDw);
      localHashMap.put("is_dynamic", Boolean.FALSE);
      localHashMap.put("cache_key", "");
      localHashMap.put("path", paramString1.hDs);
      paramString1 = new Intent(paramContext, MsgRetransmitUI.class);
      paramString1.putExtra("appbrand_params", localHashMap);
      paramString1.putExtra("Retr_Msg_content", (String)localObject);
      paramString1.putExtra("Retr_Msg_Type", 2);
      paramString1.putExtra("Retr_Biz_Msg_Selected_Msg_Index", paramInt);
      paramString1.putExtra("Retr_Msg_Id", paramLong1);
      paramString1.putExtra("Retr_MsgFromScene", 3);
      localObject = y.AH(String.valueOf(paramLong2));
      paramString1.putExtra("reportSessionId", (String)localObject);
      localObject = y.aBq().F((String)localObject, true);
      ((y.b)localObject).k("prePublishId", "msg_".concat(String.valueOf(paramLong2)));
      ((y.b)localObject).k("preUsername", paramString2);
      ((y.b)localObject).k("preChatName", paramString2);
      ((y.b)localObject).k("preMsgIndex", Integer.valueOf(paramInt));
      ((y.b)localObject).k("sendAppMsgScene", Integer.valueOf(1));
      paramString1 = new com.tencent.mm.hellhoundlib.b.a().bc(paramString1);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString1.ahp(), "com/tencent/mm/ui/chatting/ChattingItemHelper", "transmitAppBrandMsg", "(ILandroid/content/Context;Ljava/lang/String;Ljava/lang/String;JJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString1.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/chatting/ChattingItemHelper", "transmitAppBrandMsg", "(ILandroid/content/Context;Ljava/lang/String;Ljava/lang/String;JJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(34584);
  }
  
  public static void a(long paramLong, int paramInt, Context paramContext, Fragment paramFragment, Activity paramActivity, bu parambu)
  {
    AppMethodBeat.i(34585);
    Object localObject = parambu.field_talker;
    String str = y.AH(parambu.field_msgSvrId);
    y.b localb = y.aBq().F(str, true);
    localb.k("prePublishId", "msg_" + parambu.field_msgSvrId);
    localb.k("preUsername", localObject);
    localb.k("preChatName", localObject);
    localb.k("preMsgIndex", Integer.valueOf(paramInt));
    localb.k("sendAppMsgScene", Integer.valueOf(1));
    localObject = new cv();
    ((cv)localObject).dnG.dnK = paramInt;
    ((cv)localObject).dnG.sessionId = str;
    ((cv)localObject).dnG.fragment = paramFragment;
    ((cv)localObject).dnG.activity = paramActivity;
    ((cv)localObject).dnG.dnM = 40;
    com.tencent.mm.pluginsdk.model.g.e((cv)localObject, parambu);
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    if (((cv)localObject).dnH.ret == 0)
    {
      paramFragment = k.b.yr(m.a(paramContext, paramInt, parambu.field_content, parambu.field_talker, parambu.field_msgId));
      if (!parambu.cTc()) {
        break label416;
      }
      paramContext = com.tencent.mm.modelstat.b.inZ;
      if (paramFragment == null) {
        break label411;
      }
      paramInt = paramFragment.type;
      paramContext.c(parambu, paramInt);
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
      com.tencent.mm.plugin.report.service.g.yhR.f(13378, new Object[] { paramContext, Long.valueOf(paramLong), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1) });
      AppMethodBeat.o(34585);
      return;
      label411:
      paramInt = 0;
      break;
      label416:
      com.tencent.mm.modelstat.b.inZ.S(parambu);
    }
  }
  
  public static void a(View paramView, Context paramContext, String paramString)
  {
    AppMethodBeat.i(34582);
    bk localbk = (bk)paramView.getTag();
    String str = localbk.dok;
    paramView = str;
    if (TextUtils.isEmpty(str)) {
      paramView = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aby(localbk.fkq);
    }
    if (TextUtils.isEmpty(paramView))
    {
      paramView = new Intent();
      paramView.putExtra("geta8key_username", paramString);
      paramView.putExtra("rawUrl", localbk.fkq);
      com.tencent.mm.bs.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramView);
      AppMethodBeat.o(34582);
      return;
    }
    paramString = new Intent();
    paramString.putExtra("extra_id", paramView);
    paramString.putExtra("extra_name", localbk.title);
    if (localbk.Khv)
    {
      paramString.putExtra("download_entrance_scene", 20);
      paramString.putExtra("preceding_scence", 3);
      paramString.putExtra("reward_tip", true);
      com.tencent.mm.plugin.report.service.g.yhR.f(12953, new Object[] { Integer.valueOf(1), paramView });
    }
    for (;;)
    {
      com.tencent.mm.bs.d.b(paramContext, "emoji", ".ui.EmojiStoreDetailUI", paramString);
      AppMethodBeat.o(34582);
      return;
      if (localbk.Khw)
      {
        paramString.putExtra("download_entrance_scene", 25);
        paramString.putExtra("preceding_scence", 9);
        paramString.putExtra("reward_tip", true);
      }
      else
      {
        paramString.putExtra("download_entrance_scene", 22);
        paramString.putExtra("preceding_scence", 122);
        com.tencent.mm.plugin.report.service.g.yhR.f(10993, new Object[] { Integer.valueOf(2), paramView });
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
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingItemHelper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        paramAnonymousView = (bk)paramAnonymousView.getTag();
        ad.i("MicroMsg.ChattingItemHelper", "on app brand(%s) button1 click", new Object[] { this.ofE.hDr });
        localObject = new vm();
        ((vm)localObject).dJF.userName = this.ofE.hDr;
        ((vm)localObject).dJF.dJH = this.ofE.hDs;
        ((vm)localObject).dJF.dJI = this.ofE.hDu;
        ((vm)localObject).dJF.aDD = this.ofE.hDt;
        ((vm)localObject).dJF.dJL = true;
        ((vm)localObject).dJF.scene = 1076;
        ((vm)localObject).dJF.dkh = (paramString + ":" + paramAnonymousView.dBd.field_msgSvrId + ":" + paramAnonymousView.DUB);
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingItemHelper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(34578);
      }
    });
    AppMethodBeat.o(34583);
  }
  
  public static void a(bu parambu, Context paramContext, com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(34586);
    ba.aBQ();
    if (!c.isSDCardAvailable())
    {
      t.g(paramContext, parama.JOR.getContentView());
      AppMethodBeat.o(34586);
      return;
    }
    Object localObject = null;
    if (parambu.field_msgId > 0L) {
      localObject = q.aIF().G(parambu.field_talker, parambu.field_msgId);
    }
    if (((localObject == null) || (((com.tencent.mm.aw.g)localObject).dnz <= 0L)) && (parambu.field_msgSvrId > 0L)) {
      localObject = q.aIF().F(parambu.field_talker, parambu.field_msgSvrId);
    }
    for (;;)
    {
      if (localObject == null)
      {
        AppMethodBeat.o(34586);
        return;
      }
      int i;
      if (parambu.field_isSend == 1) {
        if (((com.tencent.mm.aw.g)localObject).aIj()) {
          i = 1;
        }
      }
      while (parambu.frT())
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
        if (!((com.tencent.mm.aw.g)localObject).aIj())
        {
          i = 0;
        }
        else
        {
          com.tencent.mm.aw.g localg = com.tencent.mm.aw.h.a((com.tencent.mm.aw.g)localObject);
          if (!com.tencent.mm.vfs.i.fv(q.aIF().o(localg.hZw, "", ""))) {
            i = 0;
          } else {
            i = 1;
          }
        }
      }
      if (com.tencent.mm.ui.chatting.d.l.e(parambu, q.aIF().o(com.tencent.mm.aw.h.c((com.tencent.mm.aw.g)localObject), "", "")))
      {
        ad.i("MicroMsg.ChattingItemHelper", "img is expired or clean!!!");
        ad.i("MicroMsg.ChattingItemHelper", "[ImageGalleryUI] enter");
        localObject = new Intent(paramContext, ImageGalleryUI.class);
        ((Intent)localObject).putExtra("img_gallery_msg_id", parambu.field_msgId);
        ((Intent)localObject).putExtra("img_gallery_msg_svr_id", parambu.field_msgSvrId);
        ((Intent)localObject).putExtra("img_gallery_talker", parambu.field_talker);
        ((Intent)localObject).putExtra("img_gallery_chatroom_name", parambu.field_talker);
        ((Intent)localObject).putExtra("img_gallery_is_restransmit_after_download", true);
        ((Intent)localObject).putExtra("Retr_show_success_tips", true);
        if (parama != null) {
          com.tencent.mm.ui.chatting.d.l.a(parama, parambu, (Intent)localObject);
        }
        for (;;)
        {
          parambu = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, parambu.ahp(), "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)parambu.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(34586);
          return;
          a(parambu, (Intent)localObject);
        }
      }
      if ((((com.tencent.mm.aw.g)localObject).offset >= ((com.tencent.mm.aw.g)localObject).hMP) && (((com.tencent.mm.aw.g)localObject).hMP != 0))
      {
        parama = new Intent(paramContext, MsgRetransmitUI.class);
        parama.putExtra("Retr_File_Name", q.aIF().o(com.tencent.mm.aw.h.c((com.tencent.mm.aw.g)localObject), "", ""));
        parama.putExtra("Retr_Msg_Id", parambu.field_msgId);
        parama.putExtra("Retr_Msg_Type", 0);
        parama.putExtra("Retr_show_success_tips", true);
        parama.putExtra("Retr_Compress_Type", i);
        parambu = new com.tencent.mm.hellhoundlib.b.a().bc(parama);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, parambu.ahp(), "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)parambu.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(34586);
        return;
      }
      parama = new Intent(paramContext, MsgRetransmitUI.class);
      parama.putExtra("Retr_File_Name", q.aIF().R(parambu.field_imgPath, true));
      parama.putExtra("Retr_Msg_Id", parambu.field_msgId);
      parama.putExtra("Retr_Msg_Type", 0);
      parama.putExtra("Retr_show_success_tips", true);
      parama.putExtra("Retr_Compress_Type", i);
      parambu = new com.tencent.mm.hellhoundlib.b.a().bc(parama);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, parambu.ahp(), "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)parambu.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(34586);
      return;
    }
  }
  
  private static void a(bu parambu, Intent paramIntent)
  {
    AppMethodBeat.i(34587);
    if (parambu == null)
    {
      AppMethodBeat.o(34587);
      return;
    }
    String str1 = parambu.field_talker;
    String str2 = parambu.field_talker;
    Bundle localBundle = new Bundle();
    if (w.zE(str1)) {}
    for (int i = 7;; i = 1)
    {
      localBundle.putInt("stat_scene", i);
      localBundle.putString("stat_msg_id", "msg_" + Long.toString(parambu.field_msgSvrId));
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
    ad.i("MicroMsg.ChattingItemHelper", "gotoEditUI() msgId:%s scene:%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    bu localbu = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().xY(paramLong);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_group_solitatire_create", false);
    localIntent.putExtra("key_group_solitatire_key", localbu.fkC);
    localIntent.putExtra("key_group_solitatire_chatroom_username", localbu.field_talker);
    localIntent.putExtra("key_group_solitatire_scene", paramInt);
    com.tencent.mm.bs.d.a(parama.JOO, "groupsolitaire", ".ui.GroupSolitatireEditUI", localIntent, 3001, new d.a()
    {
      public final void onActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(34579);
        if (paramAnonymousInt1 == 3001)
        {
          ad.i("MicroMsg.ChattingItemHelper", "gotoEditUI() REQUEST_CODE_VIEW_GROUP_SOLITATIRE resultCode:%s", new Object[] { Integer.valueOf(paramAnonymousInt2) });
          if ((-1 == paramAnonymousInt2) && (paramAnonymousIntent != null)) {
            ((am)this.JAE.bh(am.class)).amZ(paramAnonymousIntent.getStringExtra("key_group_solitatire_content"));
          }
        }
        AppMethodBeat.o(34579);
      }
    });
    AppMethodBeat.o(34588);
  }
  
  private static boolean awP(String paramString)
  {
    AppMethodBeat.i(34581);
    f localf = com.tencent.mm.az.a.aJJ();
    if ((localf != null) && (localf.ihg != null) && (localf.ihe == 0) && (com.tencent.mm.az.a.aJG())) {
      try
      {
        boolean bool = bt.lQ(localf.ihg, paramString);
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
  
  public static void gj(View paramView)
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
      if (paramView.KaI != null)
      {
        paramView = paramView.KaI;
        if (awP(paramView.Epf))
        {
          com.tencent.mm.az.a.aJE();
          AppMethodBeat.o(34580);
          return;
        }
        localObject1 = paramView.coverUrl;
        localObject2 = paramView.title;
        localObject3 = paramView.hDA;
        str1 = paramView.url;
        str2 = paramView.url;
        str3 = paramView.playUrl;
        str4 = paramView.Epf;
        ba.aBQ();
        com.tencent.mm.az.a.c(com.tencent.mm.az.h.a(0, (String)localObject1, (String)localObject2, (String)localObject3, str1, str2, str3, str4, c.getAccPath(), paramView.coverUrl, "", ""));
        AppMethodBeat.o(34580);
        return;
      }
      if (paramView.KaJ == -1)
      {
        ba.aBQ();
        localObject1 = c.azs().xY(paramView.msgId);
        boolean bool;
        if (awP(String.valueOf(l1)))
        {
          com.tencent.mm.plugin.report.service.g.yhR.kvStat(10231, "1");
          com.tencent.mm.az.a.aJE();
          if (((ei)localObject1).field_msgId == l1)
          {
            paramView = com.tencent.mm.modelstat.b.inZ;
            bool = false;
            i = com.tencent.mm.ai.l.r((bu)localObject1);
          }
        }
        for (;;)
        {
          paramView.a((bu)localObject1, bool, i);
          do
          {
            AppMethodBeat.o(34580);
            return;
            localObject2 = k.b.yr(paramView.dBS);
            if (localObject2 != null)
            {
              com.tencent.mm.plugin.report.service.g.yhR.kvStat(10090, "0,1");
              long l2 = paramView.msgId;
              localObject3 = paramView.dyy;
              ba.aBQ();
              com.tencent.mm.az.a.c(com.tencent.mm.az.h.a((k.b)localObject2, String.valueOf(l2), (String)localObject3, c.getAccPath(), paramView.dyy));
            }
          } while (((ei)localObject1).field_msgId != l1);
          paramView = com.tencent.mm.modelstat.b.inZ;
          bool = true;
          if (localObject2 != null) {
            i = ((k.b)localObject2).type;
          } else {
            i = 0;
          }
        }
      }
      Object localObject2 = paramView.msgId + "_" + paramView.KaJ;
      ba.aBQ();
      localObject1 = c.azs().xY(paramView.msgId);
      Object localObject3 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(paramView.msgId, paramView.dBS);
      if (awP((String)localObject2))
      {
        com.tencent.mm.plugin.report.service.g.yhR.kvStat(10231, "1");
        com.tencent.mm.az.a.aJE();
        if (((ei)localObject1).field_msgId == l1) {
          com.tencent.mm.modelstat.b.inZ.a((bu)localObject1, false, com.tencent.mm.ai.l.r((bu)localObject1));
        }
        if ((localObject3 != null) && (((u)localObject3).hDb != null) && (((u)localObject3).hDb.size() > paramView.KaJ))
        {
          paramView = (v)((u)localObject3).hDb.get(paramView.KaJ);
          localObject1 = com.tencent.mm.plugin.report.service.g.yhR;
          if (paramView.type == 6) {}
          for (i = 1;; i = 0)
          {
            ((com.tencent.mm.plugin.report.service.g)localObject1).f(14972, new Object[] { Integer.valueOf(i), Integer.valueOf(1) });
            AppMethodBeat.o(34580);
            return;
          }
        }
      }
      else if ((localObject3 != null) && (((u)localObject3).hDb != null) && (((u)localObject3).hDb.size() > paramView.KaJ))
      {
        com.tencent.mm.plugin.report.service.g.yhR.kvStat(10090, "0,1");
        localObject3 = (v)((u)localObject3).hDb.get(paramView.KaJ);
        str1 = paramView.dyy;
        str2 = ((v)localObject3).title;
        str3 = ((v)localObject3).hDA;
        str4 = ((v)localObject3).url;
        String str5 = ((v)localObject3).url;
        String str6 = ((v)localObject3).hDz;
        ba.aBQ();
        com.tencent.mm.az.a.c(com.tencent.mm.az.h.a(0, str1, str2, str3, str4, str5, str6, (String)localObject2, c.getAccPath(), paramView.dyy, "", ""));
        paramView = com.tencent.mm.plugin.report.service.g.yhR;
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
        com.tencent.mm.modelstat.b.inZ.a((bu)localObject1, true, com.tencent.mm.ai.l.r((bu)localObject1));
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