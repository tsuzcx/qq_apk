package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.aj.l;
import com.tencent.mm.aj.v;
import com.tencent.mm.ay.e;
import com.tencent.mm.ay.g;
import com.tencent.mm.ay.q;
import com.tencent.mm.bb.f;
import com.tencent.mm.by.c.a;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.dd.b;
import com.tencent.mm.f.a.xw;
import com.tencent.mm.f.b.a.ig;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.findersdk.a.al;
import com.tencent.mm.plugin.findersdk.a.an;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.protocal.protobuf.dbr;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.chatting.d.b.ar;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.viewitems.by;
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
    paramString1 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.biz.a.a.class)).b(paramLong1, paramString1);
    if (paramString1 == null)
    {
      Log.w("MicroMsg.ChattingItemHelper", "transmitAppBrandMsg reader is null");
      AppMethodBeat.o(34584);
      return;
    }
    if ((paramInt >= 0) && (paramInt < paramString1.lpz.size()))
    {
      paramString1 = (v)paramString1.lpz.get(paramInt);
      Object localObject = k.b.a(m.a(paramString2, paramString1), null, null);
      if (Util.isNullOrNil((String)localObject))
      {
        AppMethodBeat.o(34584);
        return;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("desc", paramString1.lpM);
      localHashMap.put("type", Integer.valueOf(2));
      localHashMap.put("title", paramString1.title);
      localHashMap.put("app_id", paramString1.lpT);
      localHashMap.put("pkg_type", Integer.valueOf(paramString1.lpS));
      localHashMap.put("pkg_version", Integer.valueOf(paramString1.lpR));
      localHashMap.put("img_url", paramString1.lpU);
      localHashMap.put("is_dynamic", Boolean.FALSE);
      localHashMap.put("cache_key", "");
      localHashMap.put("path", paramString1.lpQ);
      paramString1 = new Intent(paramContext, MsgRetransmitUI.class);
      paramString1.putExtra("appbrand_params", localHashMap);
      paramString1.putExtra("Retr_Msg_content", (String)localObject);
      paramString1.putExtra("Retr_Msg_Type", 2);
      paramString1.putExtra("Retr_Biz_Msg_Selected_Msg_Index", paramInt);
      paramString1.putExtra("Retr_Msg_Id", paramLong1);
      paramString1.putExtra("Retr_MsgFromScene", 3);
      localObject = ad.Rp(String.valueOf(paramLong2));
      paramString1.putExtra("reportSessionId", (String)localObject);
      localObject = ad.beh().I((String)localObject, true);
      ((ad.b)localObject).k("prePublishId", "msg_".concat(String.valueOf(paramLong2)));
      ((ad.b)localObject).k("preUsername", paramString2);
      ((ad.b)localObject).k("preChatName", paramString2);
      ((ad.b)localObject).k("preMsgIndex", Integer.valueOf(paramInt));
      ((ad.b)localObject).k("sendAppMsgScene", Integer.valueOf(1));
      paramString1 = new com.tencent.mm.hellhoundlib.b.a().bm(paramString1);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString1.aFh(), "com/tencent/mm/ui/chatting/ChattingItemHelper", "transmitAppBrandMsg", "(ILandroid/content/Context;Ljava/lang/String;Ljava/lang/String;JJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString1.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/ui/chatting/ChattingItemHelper", "transmitAppBrandMsg", "(ILandroid/content/Context;Ljava/lang/String;Ljava/lang/String;JJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(34584);
  }
  
  public static void a(long paramLong, int paramInt, Context paramContext, Fragment paramFragment, Activity paramActivity, ca paramca)
  {
    AppMethodBeat.i(285904);
    Object localObject = paramca.field_talker;
    String str = ad.Rp(paramca.field_msgSvrId);
    ad.b localb = ad.beh().I(str, true);
    localb.k("prePublishId", "msg_" + paramca.field_msgSvrId);
    localb.k("preUsername", localObject);
    localb.k("preChatName", localObject);
    localb.k("preMsgIndex", Integer.valueOf(paramInt));
    localb.k("sendAppMsgScene", Integer.valueOf(1));
    localObject = new dd();
    ((dd)localObject).fyI.fyM = paramInt;
    ((dd)localObject).fyI.sessionId = str;
    ((dd)localObject).fyI.fragment = paramFragment;
    ((dd)localObject).fyI.activity = paramActivity;
    ((dd)localObject).fyI.fyP = 40;
    j.d((dd)localObject, paramca);
    EventCenter.instance.publish((IEvent)localObject);
    if (((dd)localObject).fyJ.ret == 0)
    {
      paramFragment = k.b.OQ(com.tencent.mm.aj.m.a(paramContext, paramInt, paramca.field_content, paramca.field_talker, paramca.field_msgId));
      if (!paramca.erk()) {
        break label416;
      }
      paramContext = com.tencent.mm.modelstat.b.mcf;
      if (paramFragment == null) {
        break label411;
      }
      paramInt = paramFragment.type;
      paramContext.e(paramca, paramInt);
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
      com.tencent.mm.plugin.report.service.h.IzE.a(13378, new Object[] { paramContext, Long.valueOf(paramLong), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1) });
      AppMethodBeat.o(285904);
      return;
      label411:
      paramInt = 0;
      break;
      label416:
      com.tencent.mm.modelstat.b.mcf.aj(paramca);
    }
  }
  
  public static void a(View paramView, Context paramContext, String paramString)
  {
    AppMethodBeat.i(34582);
    by localby = (by)paramView.getTag();
    String str = localby.productId;
    paramView = str;
    if (TextUtils.isEmpty(str)) {
      paramView = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().auk(localby.ilh);
    }
    if (TextUtils.isEmpty(paramView))
    {
      paramView = new Intent();
      paramView.putExtra("geta8key_username", paramString);
      paramView.putExtra("rawUrl", localby.ilh);
      com.tencent.mm.by.c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramView);
      AppMethodBeat.o(34582);
      return;
    }
    paramString = new Intent();
    paramString.putExtra("extra_id", paramView);
    paramString.putExtra("extra_name", localby.title);
    if (localby.XmJ)
    {
      paramString.putExtra("download_entrance_scene", 20);
      paramString.putExtra("preceding_scence", 3);
      paramString.putExtra("reward_tip", true);
      com.tencent.mm.plugin.report.service.h.IzE.a(12953, new Object[] { Integer.valueOf(1), paramView });
    }
    for (;;)
    {
      com.tencent.mm.by.c.b(paramContext, "emoji", ".ui.EmojiStoreDetailUI", paramString);
      AppMethodBeat.o(34582);
      return;
      if (localby.XmK)
      {
        paramString.putExtra("download_entrance_scene", 25);
        paramString.putExtra("preceding_scence", 9);
        paramString.putExtra("reward_tip", true);
      }
      else
      {
        paramString.putExtra("download_entrance_scene", 22);
        paramString.putExtra("preceding_scence", 122);
        com.tencent.mm.plugin.report.service.h.IzE.a(10993, new Object[] { Integer.valueOf(2), paramView });
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
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/ChattingItemHelper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = (by)paramAnonymousView.getTag();
        Log.i("MicroMsg.ChattingItemHelper", "on app brand(%s) button1 click", new Object[] { this.sHy.lpP });
        localObject = new xw();
        ((xw)localObject).fWN.userName = this.sHy.lpP;
        ((xw)localObject).fWN.fWP = this.sHy.lpQ;
        ((xw)localObject).fWN.fWQ = this.sHy.lpS;
        ((xw)localObject).fWN.appVersion = this.sHy.lpR;
        ((xw)localObject).fWN.fWU = true;
        ((xw)localObject).fWN.scene = 1076;
        ((xw)localObject).fWN.fvd = (paramString + ":" + paramAnonymousView.fNz.field_msgSvrId + ":" + paramAnonymousView.PVU);
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
    bh.beI();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      w.g(paramContext, parama.WQv.getContentView());
      AppMethodBeat.o(34586);
      return;
    }
    Object localObject = null;
    if (paramca.field_msgId > 0L) {
      localObject = q.bmh().D(paramca.field_talker, paramca.field_msgId);
    }
    if (((localObject == null) || (((g)localObject).localId <= 0L)) && (paramca.field_msgSvrId > 0L)) {
      localObject = q.bmh().C(paramca.field_talker, paramca.field_msgSvrId);
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
        if (((g)localObject).blK()) {
          i = 1;
        }
      }
      int j;
      for (;;)
      {
        j = i;
        if (i == 1)
        {
          j = i;
          if (q.bmi().a(((g)localObject).localId, paramca.field_msgId, 1)) {
            j = 0;
          }
        }
        if (!paramca.Ic()) {
          break;
        }
        Log.i("MicroMsg.ChattingItemHelper", "image is clean!!!");
        com.tencent.mm.ui.base.h.d(paramContext, paramContext.getString(R.l.eHV), paramContext.getString(R.l.app_tip), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(34586);
        return;
        i = 0;
        continue;
        if (!((g)localObject).blK())
        {
          i = 0;
        }
        else
        {
          g localg = com.tencent.mm.ay.h.a((g)localObject);
          if (!com.tencent.mm.vfs.u.agG(q.bmh().r(localg.lNH, "", ""))) {
            i = 0;
          } else {
            i = 1;
          }
        }
      }
      if (com.tencent.mm.ui.chatting.d.m.j(paramca, q.bmh().r(com.tencent.mm.ay.h.c((g)localObject), "", "")))
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
          com.tencent.mm.ui.chatting.d.m.a(parama, paramca, (Intent)localObject);
        }
        for (;;)
        {
          paramca = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramca.aFh(), "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramca.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(34586);
          return;
          a(paramca, (Intent)localObject);
        }
      }
      if ((((g)localObject).offset >= ((g)localObject).lAW) && (((g)localObject).lAW != 0))
      {
        parama = new Intent(paramContext, MsgRetransmitUI.class);
        parama.putExtra("Retr_File_Name", q.bmh().r(com.tencent.mm.ay.h.c((g)localObject), "", ""));
        parama.putExtra("Retr_Msg_Id", paramca.field_msgId);
        parama.putExtra("Retr_Msg_Type", 0);
        parama.putExtra("Retr_show_success_tips", true);
        parama.putExtra("Retr_Compress_Type", j);
        paramca = new com.tencent.mm.hellhoundlib.b.a().bm(parama);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramca.aFh(), "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramca.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(34586);
        return;
      }
      parama = new Intent(paramContext, MsgRetransmitUI.class);
      parama.putExtra("Retr_File_Name", q.bmh().T(paramca.field_imgPath, true));
      parama.putExtra("Retr_Msg_Id", paramca.field_msgId);
      parama.putExtra("Retr_Msg_Type", 0);
      parama.putExtra("Retr_show_success_tips", true);
      parama.putExtra("Retr_Compress_Type", j);
      paramca = new com.tencent.mm.hellhoundlib.b.a().bm(parama);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramca.aFh(), "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramca.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
    if (ab.Qm(str1)) {}
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
  
  public static void a(ca paramca, k.b paramb, String paramString)
  {
    AppMethodBeat.i(285901);
    String str = String.format("%d_msg", new Object[] { Long.valueOf(paramca.field_msgId) });
    Object localObject;
    if (!aXq(str)) {
      if (paramb != null)
      {
        com.tencent.mm.plugin.report.service.h.IzE.kvStat(10090, "0,1");
        if (paramb == null) {
          break label194;
        }
        localObject = (com.tencent.mm.pluginsdk.ui.tools.b)paramb.ar(com.tencent.mm.pluginsdk.ui.tools.b.class);
        if (localObject == null) {
          break label205;
        }
        localObject = an.a(paramb, (com.tencent.mm.pluginsdk.ui.tools.b)localObject);
      }
    }
    for (;;)
    {
      if (localObject != null) {
        ((dbr)localObject).lVZ = paramString;
      }
      paramString = paramca.field_imgPath;
      bh.beI();
      paramString = com.tencent.mm.bb.i.a(paramb, str, paramString, com.tencent.mm.model.c.getAccPath(), paramca.field_imgPath, com.tencent.mm.bb.h.a(str, (dbr)localObject));
      Log.d("MicroMsg.ChattingItemHelper", "doPlayMusic, songName:%s, singer:%s, wrapper.songWebUrl:%s, wifiUrl:%s", new Object[] { paramString.lVv, paramString.lVw, paramString.lVB, paramString.lVz });
      com.tencent.mm.bb.a.c(paramString);
      paramString = com.tencent.mm.modelstat.b.mcf;
      if (paramb != null) {}
      for (int i = paramb.type;; i = 0)
      {
        paramString.a(paramca, true, i);
        AppMethodBeat.o(285901);
        return;
        label194:
        localObject = null;
        break;
      }
      label205:
      localObject = null;
    }
  }
  
  public static void a(com.tencent.mm.ui.chatting.e.a parama, long paramLong, int paramInt)
  {
    AppMethodBeat.i(34588);
    Log.i("MicroMsg.ChattingItemHelper", "gotoEditUI() msgId:%s scene:%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    ca localca = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(paramLong);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_group_solitatire_create", false);
    localIntent.putExtra("key_group_solitatire_key", localca.ilt);
    localIntent.putExtra("key_group_solitatire_chatroom_username", localca.field_talker);
    localIntent.putExtra("key_group_solitatire_scene", paramInt);
    com.tencent.mm.by.c.a(parama.WQt, "groupsolitaire", ".ui.GroupSolitatireEditUI", localIntent, 3001, new c.a()
    {
      public final void onActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(34579);
        if (paramAnonymousInt1 == 3001)
        {
          Log.i("MicroMsg.ChattingItemHelper", "gotoEditUI() REQUEST_CODE_VIEW_GROUP_SOLITATIRE resultCode:%s", new Object[] { Integer.valueOf(paramAnonymousInt2) });
          if ((-1 == paramAnonymousInt2) && (paramAnonymousIntent != null)) {
            ((ar)this.WAa.bC(ar.class)).aLh(paramAnonymousIntent.getStringExtra("key_group_solitatire_content"));
          }
        }
        AppMethodBeat.o(34579);
      }
    });
    AppMethodBeat.o(34588);
  }
  
  private static boolean aXq(String paramString)
  {
    AppMethodBeat.i(34581);
    f localf = com.tencent.mm.bb.a.bnA();
    if ((localf != null) && (localf.lVt != null) && (localf.lVr == 0) && (com.tencent.mm.bb.a.bnx())) {
      try
      {
        boolean bool = Util.isEqual(localf.lVt, paramString);
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
  
  public static void hL(View paramView)
  {
    AppMethodBeat.i(34580);
    long l;
    Object localObject1;
    if ((paramView.getTag() instanceof e.g))
    {
      if (!WeChatBrands.Business.Entries.SessionMusic.checkAvailable(paramView.getContext()))
      {
        AppMethodBeat.o(34580);
        return;
      }
      paramView = (e.g)paramView.getTag();
      l = paramView.msgId;
      String str1;
      String str2;
      String str3;
      String str4;
      String str5;
      String str6;
      if (paramView.XeN != null)
      {
        localObject1 = paramView.XeN;
        localObject2 = String.format("%s_msg", new Object[] { ((e.h)localObject1).QuD });
        if (aXq((String)localObject2))
        {
          com.tencent.mm.bb.a.bnv();
          AppMethodBeat.o(34580);
          return;
        }
        localObject3 = ((e.h)localObject1).coverUrl;
        str1 = ((e.h)localObject1).title;
        str2 = ((e.h)localObject1).lpY;
        str3 = ((e.h)localObject1).url;
        str4 = ((e.h)localObject1).playUrl;
        str5 = ((e.h)localObject1).playUrl;
        str6 = ((e.h)localObject1).QuD;
        bh.beI();
        com.tencent.mm.bb.a.c(com.tencent.mm.bb.i.a(0, (String)localObject3, str1, str2, str3, str4, str5, str6, com.tencent.mm.model.c.getAccPath(), ((e.h)localObject1).coverUrl, "", "", com.tencent.mm.bb.h.a((String)localObject2, paramView.lVY)));
        AppMethodBeat.o(34580);
        return;
      }
      if (paramView.XeO == -1)
      {
        bh.beI();
        localObject1 = com.tencent.mm.model.c.bbO().Oq(paramView.msgId);
        localObject3 = String.format("%d_msg", new Object[] { Long.valueOf(l) });
        boolean bool;
        if (aXq((String)localObject3))
        {
          if (paramView.lnm != 0)
          {
            localObject2 = new ig();
            ((ig)localObject2).xV(paramView.TJa);
            ((ig)localObject2).giq = 2L;
            ((ig)localObject2).gnP = 2L;
            al.a((ig)localObject2);
          }
          com.tencent.mm.plugin.report.service.h.IzE.kvStat(10231, "1");
          com.tencent.mm.bb.a.bnv();
          if (((et)localObject1).field_msgId == l)
          {
            paramView = com.tencent.mm.modelstat.b.mcf;
            bool = false;
            i = l.v((ca)localObject1);
          }
        }
        for (;;)
        {
          paramView.a((ca)localObject1, bool, i);
          do
          {
            AppMethodBeat.o(34580);
            return;
            localObject2 = k.b.OQ(paramView.xml);
            if (localObject2 != null)
            {
              com.tencent.mm.plugin.report.service.h.IzE.kvStat(10090, "0,1");
              str1 = paramView.fKH;
              bh.beI();
              com.tencent.mm.bb.a.c(com.tencent.mm.bb.i.a((k.b)localObject2, (String)localObject3, str1, com.tencent.mm.model.c.getAccPath(), paramView.fKH, com.tencent.mm.bb.h.a((String)localObject3, paramView.lVY)));
            }
            if (paramView.lnm != 0)
            {
              localObject3 = new ig();
              ((ig)localObject3).xV(paramView.TJa);
              ((ig)localObject3).giq = 1L;
              ((ig)localObject3).gnP = 2L;
              al.a((ig)localObject3);
            }
          } while (((et)localObject1).field_msgId != l);
          paramView = com.tencent.mm.modelstat.b.mcf;
          bool = true;
          if (localObject2 != null) {
            i = ((k.b)localObject2).type;
          } else {
            i = 0;
          }
        }
      }
      Object localObject2 = paramView.msgId + "_" + paramView.XeO + "_msg";
      bh.beI();
      localObject1 = com.tencent.mm.model.c.bbO().Oq(paramView.msgId);
      Object localObject3 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.biz.a.a.class)).b(paramView.msgId, paramView.xml);
      if (aXq((String)localObject2))
      {
        com.tencent.mm.plugin.report.service.h.IzE.kvStat(10231, "1");
        com.tencent.mm.bb.a.bnv();
        if (((et)localObject1).field_msgId == l) {
          com.tencent.mm.modelstat.b.mcf.a((ca)localObject1, false, l.v((ca)localObject1));
        }
        if ((localObject3 != null) && (((com.tencent.mm.aj.u)localObject3).lpz != null) && (((com.tencent.mm.aj.u)localObject3).lpz.size() > paramView.XeO))
        {
          paramView = (v)((com.tencent.mm.aj.u)localObject3).lpz.get(paramView.XeO);
          localObject1 = com.tencent.mm.plugin.report.service.h.IzE;
          if (paramView.type == 6) {}
          for (i = 1;; i = 0)
          {
            ((com.tencent.mm.plugin.report.service.h)localObject1).a(14972, new Object[] { Integer.valueOf(i), Integer.valueOf(1) });
            AppMethodBeat.o(34580);
            return;
          }
        }
      }
      else if ((localObject3 != null) && (((com.tencent.mm.aj.u)localObject3).lpz != null) && (((com.tencent.mm.aj.u)localObject3).lpz.size() > paramView.XeO))
      {
        com.tencent.mm.plugin.report.service.h.IzE.kvStat(10090, "0,1");
        localObject3 = (v)((com.tencent.mm.aj.u)localObject3).lpz.get(paramView.XeO);
        str1 = paramView.fKH;
        str2 = ((v)localObject3).title;
        str3 = ((v)localObject3).lpY;
        str4 = ((v)localObject3).url;
        str5 = ((v)localObject3).lpX;
        str6 = ((v)localObject3).lpX;
        bh.beI();
        com.tencent.mm.bb.a.c(com.tencent.mm.bb.i.a(0, str1, str2, str3, str4, str5, str6, (String)localObject2, com.tencent.mm.model.c.getAccPath(), paramView.fKH, "", "", com.tencent.mm.bb.h.a((String)localObject2, paramView.lVY)));
        paramView = com.tencent.mm.plugin.report.service.h.IzE;
        if (((v)localObject3).type != 6) {
          break label940;
        }
      }
    }
    label940:
    for (int i = 1;; i = 0)
    {
      paramView.a(14972, new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
      if (((et)localObject1).field_msgId == l) {
        com.tencent.mm.modelstat.b.mcf.a((ca)localObject1, true, l.v((ca)localObject1));
      }
      AppMethodBeat.o(34580);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s
 * JD-Core Version:    0.7.0.1
 */