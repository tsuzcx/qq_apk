package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.dn.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.kn;
import com.tencent.mm.aw.f;
import com.tencent.mm.message.k.b;
import com.tencent.mm.message.m;
import com.tencent.mm.message.v;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.findersdk.a.cp;
import com.tencent.mm.plugin.findersdk.a.cr;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.viewitems.bz;
import com.tencent.mm.ui.chatting.viewitems.e.g;
import com.tencent.mm.ui.chatting.viewitems.e.h;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.vfs.y;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedList;

public final class u
{
  public static void a(int paramInt, Context paramContext, String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(34584);
    paramString1 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.biz.a.a.class)).c(paramLong1, paramString1);
    if (paramString1 == null)
    {
      Log.w("MicroMsg.ChattingItemHelper", "transmitAppBrandMsg reader is null");
      AppMethodBeat.o(34584);
      return;
    }
    if ((paramInt >= 0) && (paramInt < paramString1.nUC.size()))
    {
      paramString1 = (v)paramString1.nUC.get(paramInt);
      Object localObject = k.b.a(o.a(paramString2, paramString1), null, null);
      if (Util.isNullOrNil((String)localObject))
      {
        AppMethodBeat.o(34584);
        return;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("desc", paramString1.nUO);
      localHashMap.put("type", Integer.valueOf(2));
      localHashMap.put("title", paramString1.title);
      localHashMap.put("app_id", paramString1.nUV);
      localHashMap.put("pkg_type", Integer.valueOf(paramString1.nUU));
      localHashMap.put("pkg_version", Integer.valueOf(paramString1.nUT));
      localHashMap.put("img_url", paramString1.nUW);
      localHashMap.put("is_dynamic", Boolean.FALSE);
      localHashMap.put("cache_key", "");
      localHashMap.put("path", paramString1.nUS);
      paramString1 = new Intent(paramContext, MsgRetransmitUI.class);
      paramString1.putExtra("appbrand_params", localHashMap);
      paramString1.putExtra("Retr_Msg_content", (String)localObject);
      paramString1.putExtra("Retr_Msg_Type", 2);
      paramString1.putExtra("Retr_Biz_Msg_Selected_Msg_Index", paramInt);
      paramString1.putExtra("Retr_Msg_Id", paramLong1);
      paramString1.putExtra("Retr_MsgFromScene", 3);
      localObject = ad.Jo(String.valueOf(paramLong2));
      paramString1.putExtra("reportSessionId", (String)localObject);
      localObject = ad.bCb().M((String)localObject, true);
      ((ad.b)localObject).q("prePublishId", "msg_".concat(String.valueOf(paramLong2)));
      ((ad.b)localObject).q("preUsername", paramString2);
      ((ad.b)localObject).q("preChatName", paramString2);
      ((ad.b)localObject).q("preMsgIndex", Integer.valueOf(paramInt));
      ((ad.b)localObject).q("sendAppMsgScene", Integer.valueOf(1));
      paramString1 = new com.tencent.mm.hellhoundlib.b.a().cG(paramString1);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString1.aYi(), "com/tencent/mm/ui/chatting/ChattingItemHelper", "transmitAppBrandMsg", "(ILandroid/content/Context;Ljava/lang/String;Ljava/lang/String;JJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString1.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/ui/chatting/ChattingItemHelper", "transmitAppBrandMsg", "(ILandroid/content/Context;Ljava/lang/String;Ljava/lang/String;JJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(34584);
  }
  
  public static void a(long paramLong, int paramInt, Context paramContext, Fragment paramFragment, Activity paramActivity, cc paramcc)
  {
    AppMethodBeat.i(253959);
    Object localObject = paramcc.field_talker;
    String str = ad.Jo(paramcc.field_msgSvrId);
    ad.b localb = ad.bCb().M(str, true);
    localb.q("prePublishId", "msg_" + paramcc.field_msgSvrId);
    localb.q("preUsername", localObject);
    localb.q("preChatName", localObject);
    localb.q("preMsgIndex", Integer.valueOf(paramInt));
    localb.q("sendAppMsgScene", Integer.valueOf(1));
    localObject = new dn();
    ((dn)localObject).hDr.hDv = paramInt;
    ((dn)localObject).hDr.sessionId = str;
    ((dn)localObject).hDr.fragment = paramFragment;
    ((dn)localObject).hDr.activity = paramActivity;
    ((dn)localObject).hDr.hDy = 40;
    com.tencent.mm.pluginsdk.model.l.d((dn)localObject, paramcc);
    ((dn)localObject).publish();
    if (((dn)localObject).hDs.ret == 0)
    {
      paramFragment = k.b.Hf(m.a(paramContext, paramInt, paramcc.field_content, paramcc.field_talker, paramcc.field_msgId));
      if (!paramcc.fxR()) {
        break label411;
      }
      paramContext = com.tencent.mm.modelstat.b.oUZ;
      if (paramFragment == null) {
        break label406;
      }
      paramInt = paramFragment.type;
      paramContext.e(paramcc, paramInt);
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
      com.tencent.mm.plugin.report.service.h.OAn.b(13378, new Object[] { paramContext, Long.valueOf(paramLong), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1) });
      AppMethodBeat.o(253959);
      return;
      label406:
      paramInt = 0;
      break;
      label411:
      com.tencent.mm.modelstat.b.oUZ.ao(paramcc);
    }
  }
  
  public static void a(View paramView, Context paramContext, String paramString)
  {
    AppMethodBeat.i(34582);
    bz localbz = (bz)paramView.getTag();
    String str = localbz.productId;
    paramView = str;
    if (TextUtils.isEmpty(str)) {
      paramView = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aol(localbz.kLg);
    }
    if (TextUtils.isEmpty(paramView))
    {
      paramView = new Intent();
      paramView.putExtra("geta8key_username", paramString);
      paramView.putExtra("rawUrl", localbz.kLg);
      com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramView);
      AppMethodBeat.o(34582);
      return;
    }
    paramString = new Intent();
    paramString.putExtra("extra_id", paramView);
    paramString.putExtra("extra_name", localbz.title);
    if (localbz.aeXO)
    {
      paramString.putExtra("download_entrance_scene", 20);
      paramString.putExtra("preceding_scence", 3);
      paramString.putExtra("reward_tip", true);
      com.tencent.mm.plugin.report.service.h.OAn.b(12953, new Object[] { Integer.valueOf(1), paramView });
    }
    for (;;)
    {
      com.tencent.mm.br.c.b(paramContext, "emoji", ".ui.EmojiStoreDetailUI", paramString);
      AppMethodBeat.o(34582);
      return;
      if (localbz.aeXP)
      {
        paramString.putExtra("download_entrance_scene", 25);
        paramString.putExtra("preceding_scence", 9);
        paramString.putExtra("reward_tip", true);
      }
      else
      {
        paramString.putExtra("download_entrance_scene", 22);
        paramString.putExtra("preceding_scence", 122);
        com.tencent.mm.plugin.report.service.h.OAn.b(10993, new Object[] { Integer.valueOf(2), paramView });
      }
    }
  }
  
  public static void a(v paramv, View paramView, String paramString)
  {
    AppMethodBeat.i(34583);
    if ((paramView == null) || (paramv == null))
    {
      AppMethodBeat.o(34583);
      return;
    }
    paramView.setOnClickListener(new u.1(paramv, paramString));
    AppMethodBeat.o(34583);
  }
  
  public static void a(cc paramcc, Context paramContext, com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(34586);
    bh.bCz();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      aa.j(paramContext, parama.aezO.getContentView());
      AppMethodBeat.o(34586);
      return;
    }
    Object localObject = null;
    if (paramcc.field_msgId > 0L) {
      localObject = r.bKa().H(paramcc.field_talker, paramcc.field_msgId);
    }
    if (((localObject == null) || (((com.tencent.mm.modelimage.h)localObject).localId <= 0L)) && (paramcc.field_msgSvrId > 0L)) {
      localObject = r.bKa().G(paramcc.field_talker, paramcc.field_msgSvrId);
    }
    for (;;)
    {
      if (localObject == null)
      {
        AppMethodBeat.o(34586);
        return;
      }
      int i;
      if (paramcc.field_isSend == 1) {
        if (((com.tencent.mm.modelimage.h)localObject).bJE()) {
          i = 1;
        }
      }
      while (paramcc.isClean())
      {
        Log.i("MicroMsg.ChattingItemHelper", "image is clean!!!");
        k.d(paramContext, paramContext.getString(R.l.gJC), paramContext.getString(R.l.app_tip), new u.2());
        AppMethodBeat.o(34586);
        return;
        i = 0;
        continue;
        if (!((com.tencent.mm.modelimage.h)localObject).bJE())
        {
          i = 0;
        }
        else
        {
          com.tencent.mm.modelimage.h localh = com.tencent.mm.modelimage.i.a((com.tencent.mm.modelimage.h)localObject);
          String str = r.bKa().v(localh.oGr, "", "");
          Log.i("MicroMsg.ChattingItemHelper", "retransmitImg hdImgInfo hdFullPath:%s completed:%s", new Object[] { Boolean.valueOf(y.ZC(str)), Boolean.valueOf(localh.bJD()) });
          if ((!y.ZC(str)) || (!localh.bJD())) {
            i = 0;
          } else {
            i = 1;
          }
        }
      }
      if (com.tencent.mm.ui.chatting.component.n.j(paramcc, r.bKa().v(com.tencent.mm.modelimage.i.c((com.tencent.mm.modelimage.h)localObject), "", "")))
      {
        Log.i("MicroMsg.ChattingItemHelper", "img is expired or clean!!!");
        Log.i("MicroMsg.ChattingItemHelper", "[ImageGalleryUI] enter");
        localObject = new Intent(paramContext, ImageGalleryUI.class);
        ((Intent)localObject).putExtra("img_gallery_msg_id", paramcc.field_msgId);
        ((Intent)localObject).putExtra("img_gallery_msg_svr_id", paramcc.field_msgSvrId);
        ((Intent)localObject).putExtra("img_gallery_talker", paramcc.field_talker);
        ((Intent)localObject).putExtra("img_gallery_chatroom_name", paramcc.field_talker);
        ((Intent)localObject).putExtra("img_gallery_is_restransmit_after_download", true);
        ((Intent)localObject).putExtra("Retr_show_success_tips", true);
        if (parama != null) {
          com.tencent.mm.ui.chatting.component.n.a(parama, paramcc, (Intent)localObject);
        }
        for (;;)
        {
          paramcc = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramcc.aYi(), "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramcc.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(34586);
          return;
          a(paramcc, (Intent)localObject);
        }
      }
      if ((((com.tencent.mm.modelimage.h)localObject).offset >= ((com.tencent.mm.modelimage.h)localObject).osy) && (((com.tencent.mm.modelimage.h)localObject).osy != 0))
      {
        parama = new Intent(paramContext, MsgRetransmitUI.class);
        parama.putExtra("Retr_File_Name", r.bKa().v(com.tencent.mm.modelimage.i.c((com.tencent.mm.modelimage.h)localObject), "", ""));
        parama.putExtra("Retr_Msg_Id", paramcc.field_msgId);
        parama.putExtra("Retr_Msg_Type", 0);
        parama.putExtra("Retr_show_success_tips", true);
        parama.putExtra("Retr_Compress_Type", i);
        paramcc = new com.tencent.mm.hellhoundlib.b.a().cG(parama);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramcc.aYi(), "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramcc.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(34586);
        return;
      }
      parama = new Intent(paramContext, MsgRetransmitUI.class);
      parama.putExtra("Retr_File_Name", r.bKa().X(paramcc.field_imgPath, true));
      parama.putExtra("Retr_Msg_Id", paramcc.field_msgId);
      parama.putExtra("Retr_Msg_Type", 0);
      parama.putExtra("Retr_show_success_tips", true);
      parama.putExtra("Retr_Compress_Type", i);
      paramcc = new com.tencent.mm.hellhoundlib.b.a().cG(parama);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramcc.aYi(), "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramcc.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/ui/chatting/ChattingItemHelper", "retransmitImg", "(Lcom/tencent/mm/storage/MsgInfo;Landroid/content/Context;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(34586);
      return;
    }
  }
  
  private static void a(cc paramcc, Intent paramIntent)
  {
    AppMethodBeat.i(34587);
    if (paramcc == null)
    {
      AppMethodBeat.o(34587);
      return;
    }
    String str1 = paramcc.field_talker;
    String str2 = paramcc.field_talker;
    Bundle localBundle = new Bundle();
    if (ab.IS(str1)) {}
    for (int i = 7;; i = 1)
    {
      localBundle.putInt("stat_scene", i);
      localBundle.putString("stat_msg_id", "msg_" + Long.toString(paramcc.field_msgSvrId));
      localBundle.putString("stat_chat_talker_username", str1);
      localBundle.putString("stat_send_msg_user", str2);
      paramIntent.putExtra("_stat_obj", localBundle);
      AppMethodBeat.o(34587);
      return;
    }
  }
  
  public static void a(cc paramcc, k.b paramb, String paramString)
  {
    AppMethodBeat.i(253935);
    String str = String.format("%d_msg", new Object[] { Long.valueOf(paramcc.field_msgId) });
    Object localObject;
    if (!aUY(str)) {
      if (paramb != null)
      {
        com.tencent.mm.plugin.report.service.h.OAn.kvStat(10090, "0,1");
        if (paramb == null) {
          break label194;
        }
        localObject = (com.tencent.mm.pluginsdk.ui.tools.b)paramb.aK(com.tencent.mm.pluginsdk.ui.tools.b.class);
        if (localObject == null) {
          break label205;
        }
        localObject = cr.a(paramb, (com.tencent.mm.pluginsdk.ui.tools.b)localObject);
      }
    }
    for (;;)
    {
      if (localObject != null) {
        ((dtj)localObject).oPc = paramString;
      }
      paramString = paramcc.field_imgPath;
      bh.bCz();
      paramString = com.tencent.mm.aw.i.a(paramb, str, paramString, com.tencent.mm.model.c.getAccPath(), paramcc.field_imgPath, com.tencent.mm.aw.h.a(str, (dtj)localObject));
      Log.d("MicroMsg.ChattingItemHelper", "doPlayMusic, songName:%s, singer:%s, wrapper.songWebUrl:%s, wifiUrl:%s", new Object[] { paramString.oOx, paramString.oOy, paramString.oOD, paramString.oOB });
      com.tencent.mm.aw.a.c(paramString);
      paramString = com.tencent.mm.modelstat.b.oUZ;
      if (paramb != null) {}
      for (int i = paramb.type;; i = 0)
      {
        paramString.a(paramcc, true, i);
        AppMethodBeat.o(253935);
        return;
        label194:
        localObject = null;
        break;
      }
      label205:
      localObject = null;
    }
  }
  
  public static void a(com.tencent.mm.ui.chatting.d.a parama, long paramLong, int paramInt)
  {
    AppMethodBeat.i(34588);
    Log.i("MicroMsg.ChattingItemHelper", "gotoEditUI() msgId:%s scene:%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    cc localcc = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().sl(paramLong);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_group_solitatire_create", false);
    localIntent.putExtra("key_group_solitatire_key", localcc.kLs);
    localIntent.putExtra("key_group_solitatire_chatroom_username", localcc.field_talker);
    localIntent.putExtra("key_group_solitatire_scene", paramInt);
    com.tencent.mm.br.c.a(parama.aezM, "groupsolitaire", ".ui.GroupSolitatireEditUI", localIntent, 3001, new u.3(parama));
    AppMethodBeat.o(34588);
  }
  
  private static boolean aUY(String paramString)
  {
    AppMethodBeat.i(34581);
    f localf = com.tencent.mm.aw.a.bLn();
    if ((localf != null) && (localf.oOv != null) && (localf.oOt == 0) && (com.tencent.mm.aw.a.bLk())) {
      try
      {
        boolean bool = Util.isEqual(localf.oOv, paramString);
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
  
  public static void li(View paramView)
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
      if (paramView.aeOL != null)
      {
        localObject1 = paramView.aeOL;
        localObject2 = String.format("%s_msg", new Object[] { ((e.h)localObject1).XmC });
        if (aUY((String)localObject2))
        {
          com.tencent.mm.aw.a.bLi();
          AppMethodBeat.o(34580);
          return;
        }
        localObject3 = ((e.h)localObject1).coverUrl;
        str1 = ((e.h)localObject1).title;
        str2 = ((e.h)localObject1).nVa;
        str3 = ((e.h)localObject1).url;
        str4 = ((e.h)localObject1).playUrl;
        str5 = ((e.h)localObject1).playUrl;
        str6 = ((e.h)localObject1).XmC;
        bh.bCz();
        com.tencent.mm.aw.a.c(com.tencent.mm.aw.i.a(0, (String)localObject3, str1, str2, str3, str4, str5, str6, com.tencent.mm.model.c.getAccPath(), ((e.h)localObject1).coverUrl, "", "", com.tencent.mm.aw.h.a((String)localObject2, paramView.oPb)));
        AppMethodBeat.o(34580);
        return;
      }
      if (paramView.aeOM == -1)
      {
        bh.bCz();
        localObject1 = com.tencent.mm.model.c.bzD().sl(paramView.msgId);
        localObject3 = String.format("%d_msg", new Object[] { Long.valueOf(l) });
        boolean bool;
        if (aUY((String)localObject3))
        {
          if (paramView.nSq != 0)
          {
            localObject2 = new kn();
            ((kn)localObject2).sX(paramView.aaYQ);
            ((kn)localObject2).ioV = 2L;
            ((kn)localObject2).iqr = 2L;
            cp.a((kn)localObject2);
          }
          com.tencent.mm.plugin.report.service.h.OAn.kvStat(10231, "1");
          com.tencent.mm.aw.a.bLi();
          if ((localObject1 != null) && (((fi)localObject1).field_msgId == l))
          {
            paramView = com.tencent.mm.modelstat.b.oUZ;
            bool = false;
            i = com.tencent.mm.message.l.v((cc)localObject1);
          }
        }
        for (;;)
        {
          paramView.a((cc)localObject1, bool, i);
          do
          {
            AppMethodBeat.o(34580);
            return;
            localObject2 = k.b.Hf(paramView.xml);
            if (localObject2 != null)
            {
              com.tencent.mm.plugin.report.service.h.OAn.kvStat(10090, "0,1");
              str1 = paramView.hQn;
              bh.bCz();
              com.tencent.mm.aw.a.c(com.tencent.mm.aw.i.a((k.b)localObject2, (String)localObject3, str1, com.tencent.mm.model.c.getAccPath(), paramView.hQn, com.tencent.mm.aw.h.a((String)localObject3, paramView.oPb)));
            }
            if (paramView.nSq != 0)
            {
              localObject3 = new kn();
              ((kn)localObject3).sX(paramView.aaYQ);
              ((kn)localObject3).ioV = 1L;
              ((kn)localObject3).iqr = 2L;
              cp.a((kn)localObject3);
            }
          } while ((localObject1 == null) || (((fi)localObject1).field_msgId != l));
          paramView = com.tencent.mm.modelstat.b.oUZ;
          bool = true;
          if (localObject2 != null) {
            i = ((k.b)localObject2).type;
          } else {
            i = 0;
          }
        }
      }
      Object localObject2 = paramView.msgId + "_" + paramView.aeOM + "_msg";
      bh.bCz();
      localObject1 = com.tencent.mm.model.c.bzD().sl(paramView.msgId);
      Object localObject3 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.biz.a.a.class)).c(paramView.msgId, paramView.xml);
      if (aUY((String)localObject2))
      {
        com.tencent.mm.plugin.report.service.h.OAn.kvStat(10231, "1");
        com.tencent.mm.aw.a.bLi();
        if ((localObject1 != null) && (((fi)localObject1).field_msgId == l)) {
          com.tencent.mm.modelstat.b.oUZ.a((cc)localObject1, false, com.tencent.mm.message.l.v((cc)localObject1));
        }
        if ((localObject3 != null) && (((com.tencent.mm.message.u)localObject3).nUC != null) && (((com.tencent.mm.message.u)localObject3).nUC.size() > paramView.aeOM))
        {
          paramView = (v)((com.tencent.mm.message.u)localObject3).nUC.get(paramView.aeOM);
          localObject1 = com.tencent.mm.plugin.report.service.h.OAn;
          if (paramView.type == 6) {}
          for (i = 1;; i = 0)
          {
            ((com.tencent.mm.plugin.report.service.h)localObject1).b(14972, new Object[] { Integer.valueOf(i), Integer.valueOf(1) });
            AppMethodBeat.o(34580);
            return;
          }
        }
      }
      else if ((localObject3 != null) && (((com.tencent.mm.message.u)localObject3).nUC != null) && (((com.tencent.mm.message.u)localObject3).nUC.size() > paramView.aeOM))
      {
        com.tencent.mm.plugin.report.service.h.OAn.kvStat(10090, "0,1");
        localObject3 = (v)((com.tencent.mm.message.u)localObject3).nUC.get(paramView.aeOM);
        str1 = paramView.hQn;
        str2 = ((v)localObject3).title;
        str3 = ((v)localObject3).nVa;
        str4 = ((v)localObject3).url;
        str5 = ((v)localObject3).nUZ;
        str6 = ((v)localObject3).nUZ;
        bh.bCz();
        com.tencent.mm.aw.a.c(com.tencent.mm.aw.i.a(0, str1, str2, str3, str4, str5, str6, (String)localObject2, com.tencent.mm.model.c.getAccPath(), paramView.hQn, "", "", com.tencent.mm.aw.h.a((String)localObject2, paramView.oPb)));
        paramView = com.tencent.mm.plugin.report.service.h.OAn;
        if (((v)localObject3).type != 6) {
          break label960;
        }
      }
    }
    label960:
    for (int i = 1;; i = 0)
    {
      paramView.b(14972, new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
      if ((localObject1 != null) && (((fi)localObject1).field_msgId == l)) {
        com.tencent.mm.modelstat.b.oUZ.a((cc)localObject1, true, com.tencent.mm.message.l.v((cc)localObject1));
      }
      AppMethodBeat.o(34580);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.u
 * JD-Core Version:    0.7.0.1
 */