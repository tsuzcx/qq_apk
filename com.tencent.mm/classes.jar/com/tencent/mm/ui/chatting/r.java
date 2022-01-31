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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.af.k;
import com.tencent.mm.af.p;
import com.tencent.mm.af.q;
import com.tencent.mm.at.f;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.cm.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.i;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.viewitems.az;
import com.tencent.mm.ui.chatting.viewitems.d.f;
import com.tencent.mm.ui.chatting.viewitems.d.g;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedList;

public final class r
{
  private static boolean YC(String paramString)
  {
    AppMethodBeat.i(30710);
    com.tencent.mm.aw.e locale = com.tencent.mm.aw.a.aiz();
    if ((locale != null) && (locale.fKj != null) && (locale.fKh == 0) && (com.tencent.mm.aw.a.aiw())) {
      try
      {
        boolean bool = bo.isEqual(locale.fKj, paramString);
        if (bool)
        {
          AppMethodBeat.o(30710);
          return true;
        }
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(30710);
        return false;
      }
    }
    AppMethodBeat.o(30710);
    return false;
  }
  
  public static void a(int paramInt, Context paramContext, String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(30713);
    paramString1 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.biz.a.a.class)).b(paramLong1, paramString1);
    if (paramString1 == null)
    {
      ab.w("MicroMsg.ChattingItemHelper", "transmitAppBrandMsg reader is null");
      AppMethodBeat.o(30713);
      return;
    }
    if ((paramInt >= 0) && (paramInt < paramString1.fjy.size()))
    {
      paramString1 = (q)paramString1.fjy.get(paramInt);
      Object localObject = j.b.a(l.a(paramString2, paramString1), null, null);
      if (bo.isNullOrNil((String)localObject))
      {
        AppMethodBeat.o(30713);
        return;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("desc", paramString1.fjL);
      localHashMap.put("type", Integer.valueOf(2));
      localHashMap.put("title", paramString1.title);
      localHashMap.put("app_id", paramString1.fjS);
      localHashMap.put("pkg_type", Integer.valueOf(paramString1.fjR));
      localHashMap.put("pkg_version", Integer.valueOf(paramString1.fjQ));
      localHashMap.put("img_url", paramString1.fjT);
      localHashMap.put("is_dynamic", Boolean.FALSE);
      localHashMap.put("cache_key", "");
      localHashMap.put("path", paramString1.fjP);
      paramString1 = new Intent(paramContext, MsgRetransmitUI.class);
      paramString1.putExtra("appbrand_params", localHashMap);
      paramString1.putExtra("Retr_Msg_content", (String)localObject);
      paramString1.putExtra("Retr_Msg_Type", 2);
      paramString1.putExtra("Retr_Biz_Msg_Selected_Msg_Index", paramInt);
      paramString1.putExtra("Retr_Msg_Id", paramLong1);
      paramString1.putExtra("Retr_MsgFromScene", 3);
      localObject = v.oQ(String.valueOf(paramLong2));
      paramString1.putExtra("reportSessionId", (String)localObject);
      localObject = v.aae().z((String)localObject, true);
      ((v.b)localObject).i("prePublishId", "msg_".concat(String.valueOf(paramLong2)));
      ((v.b)localObject).i("preUsername", paramString2);
      ((v.b)localObject).i("preChatName", paramString2);
      ((v.b)localObject).i("preMsgIndex", Integer.valueOf(paramInt));
      ((v.b)localObject).i("sendAppMsgScene", Integer.valueOf(1));
      paramContext.startActivity(paramString1);
    }
    AppMethodBeat.o(30713);
  }
  
  public static void a(long paramLong, int paramInt, Context paramContext, Fragment paramFragment, Activity paramActivity, bi parambi)
  {
    AppMethodBeat.i(30714);
    Object localObject = parambi.field_talker;
    String str = v.oQ(parambi.field_msgSvrId);
    v.b localb = v.aae().z(str, true);
    localb.i("prePublishId", "msg_" + parambi.field_msgSvrId);
    localb.i("preUsername", localObject);
    localb.i("preChatName", localObject);
    localb.i("preMsgIndex", Integer.valueOf(paramInt));
    localb.i("sendAppMsgScene", Integer.valueOf(1));
    localObject = new cm();
    ((cm)localObject).cpR.cpV = paramInt;
    ((cm)localObject).cpR.cpW = str;
    ((cm)localObject).cpR.fragment = paramFragment;
    ((cm)localObject).cpR.activity = paramActivity;
    ((cm)localObject).cpR.cpY = 40;
    com.tencent.mm.pluginsdk.model.e.d((cm)localObject, parambi);
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    if (((cm)localObject).cpS.ret == 0)
    {
      paramFragment = j.b.mY(com.tencent.mm.af.l.a(paramContext, paramInt, parambi.field_content, parambi.field_talker, parambi.field_msgId));
      if (!parambi.bCn()) {
        break label416;
      }
      paramContext = com.tencent.mm.modelstat.b.fRu;
      if (paramFragment == null) {
        break label411;
      }
      paramInt = paramFragment.type;
      paramContext.b(parambi, paramInt);
    }
    for (;;)
    {
      if ((paramFragment != null) && (paramFragment.type == 5) && (paramFragment.url != null))
      {
        ab.d("MicroMsg.ChattingItemHelper", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), paramFragment.url, Long.valueOf(paramLong), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1) });
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
          ab.printErrStackTrace("MicroMsg.ChattingItemHelper", paramFragment, "", new Object[0]);
        }
      }
      com.tencent.mm.plugin.report.service.h.qsU.e(13378, new Object[] { paramContext, Long.valueOf(paramLong), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1) });
      AppMethodBeat.o(30714);
      return;
      label411:
      paramInt = 0;
      break;
      label416:
      com.tencent.mm.modelstat.b.fRu.D(parambi);
    }
  }
  
  public static void a(View paramView, Context paramContext, String paramString)
  {
    AppMethodBeat.i(30711);
    az localaz = (az)paramView.getTag();
    String str = localaz.cqx;
    paramView = str;
    if (TextUtils.isEmpty(str)) {
      paramView = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().KA(localaz.dGR);
    }
    if (TextUtils.isEmpty(paramView))
    {
      paramView = new Intent();
      paramView.putExtra("geta8key_username", paramString);
      paramView.putExtra("rawUrl", localaz.dGR);
      com.tencent.mm.bq.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramView);
      AppMethodBeat.o(30711);
      return;
    }
    paramString = new Intent();
    paramString.putExtra("extra_id", paramView);
    paramString.putExtra("extra_name", localaz.title);
    if (localaz.zYH)
    {
      paramString.putExtra("download_entrance_scene", 20);
      paramString.putExtra("preceding_scence", 3);
      paramString.putExtra("reward_tip", true);
      com.tencent.mm.plugin.report.service.h.qsU.e(12953, new Object[] { Integer.valueOf(1), paramView });
    }
    for (;;)
    {
      com.tencent.mm.bq.d.b(paramContext, "emoji", ".ui.EmojiStoreDetailUI", paramString);
      AppMethodBeat.o(30711);
      return;
      if (localaz.zYI)
      {
        paramString.putExtra("download_entrance_scene", 25);
        paramString.putExtra("preceding_scence", 9);
        paramString.putExtra("reward_tip", true);
      }
      else
      {
        paramString.putExtra("download_entrance_scene", 22);
        paramString.putExtra("preceding_scence", 122);
        com.tencent.mm.plugin.report.service.h.qsU.e(10993, new Object[] { Integer.valueOf(2), paramView });
      }
    }
  }
  
  public static void a(q paramq, View paramView, String paramString)
  {
    AppMethodBeat.i(30712);
    if ((paramView == null) || (paramq == null))
    {
      AppMethodBeat.o(30712);
      return;
    }
    paramView.setOnClickListener(new r.1(paramq, paramString));
    AppMethodBeat.o(30712);
  }
  
  public static void a(bi parambi, Context paramContext, com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(30715);
    aw.aaz();
    if (!c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.t.ii(paramContext);
      AppMethodBeat.o(30715);
      return;
    }
    Object localObject = null;
    if (parambi.field_msgId > 0L) {
      localObject = o.ahC().gT(parambi.field_msgId);
    }
    if (((localObject == null) || (((com.tencent.mm.at.e)localObject).fDL <= 0L)) && (parambi.field_msgSvrId > 0L)) {
      localObject = o.ahC().gS(parambi.field_msgSvrId);
    }
    for (;;)
    {
      if (localObject == null)
      {
        AppMethodBeat.o(30715);
        return;
      }
      int i;
      if (parambi.field_isSend == 1) {
        if (((com.tencent.mm.at.e)localObject).ahh()) {
          i = 1;
        }
      }
      while (parambi.dyc())
      {
        ab.i("MicroMsg.ChattingItemHelper", "image is clean!!!");
        com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131300724), paramContext.getString(2131297087), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(30715);
        return;
        i = 0;
        continue;
        if (!((com.tencent.mm.at.e)localObject).ahh())
        {
          i = 0;
        }
        else
        {
          com.tencent.mm.at.e locale = f.a((com.tencent.mm.at.e)localObject);
          if (!com.tencent.mm.vfs.e.cN(o.ahC().q(locale.fDM, "", ""))) {
            i = 0;
          } else {
            i = 1;
          }
        }
      }
      if (i.e(parambi, o.ahC().q(f.c((com.tencent.mm.at.e)localObject), "", "")))
      {
        ab.i("MicroMsg.ChattingItemHelper", "img is expired or clean!!!");
        ab.i("MicroMsg.ChattingItemHelper", "[ImageGalleryUI] enter");
        localObject = new Intent(paramContext, ImageGalleryUI.class);
        ((Intent)localObject).putExtra("img_gallery_msg_id", parambi.field_msgId);
        ((Intent)localObject).putExtra("img_gallery_msg_svr_id", parambi.field_msgSvrId);
        ((Intent)localObject).putExtra("img_gallery_talker", parambi.field_talker);
        ((Intent)localObject).putExtra("img_gallery_chatroom_name", parambi.field_talker);
        ((Intent)localObject).putExtra("img_gallery_is_restransmit_after_download", true);
        ((Intent)localObject).putExtra("Retr_show_success_tips", true);
        if (parama != null) {
          i.a(parama, parambi, (Intent)localObject);
        }
        for (;;)
        {
          paramContext.startActivity((Intent)localObject);
          AppMethodBeat.o(30715);
          return;
          a(parambi, (Intent)localObject);
        }
      }
      if ((((com.tencent.mm.at.e)localObject).offset >= ((com.tencent.mm.at.e)localObject).fsd) && (((com.tencent.mm.at.e)localObject).fsd != 0))
      {
        parama = new Intent(paramContext, MsgRetransmitUI.class);
        parama.putExtra("Retr_File_Name", o.ahC().q(f.c((com.tencent.mm.at.e)localObject), "", ""));
        parama.putExtra("Retr_Msg_Id", parambi.field_msgId);
        parama.putExtra("Retr_Msg_Type", 0);
        parama.putExtra("Retr_show_success_tips", true);
        parama.putExtra("Retr_Compress_Type", i);
        paramContext.startActivity(parama);
        AppMethodBeat.o(30715);
        return;
      }
      parama = new Intent(paramContext, MsgRetransmitUI.class);
      parama.putExtra("Retr_File_Name", o.ahC().J(parambi.field_imgPath, true));
      parama.putExtra("Retr_Msg_Id", parambi.field_msgId);
      parama.putExtra("Retr_Msg_Type", 0);
      parama.putExtra("Retr_show_success_tips", true);
      parama.putExtra("Retr_Compress_Type", i);
      paramContext.startActivity(parama);
      AppMethodBeat.o(30715);
      return;
    }
  }
  
  private static void a(bi parambi, Intent paramIntent)
  {
    AppMethodBeat.i(30716);
    if (parambi == null)
    {
      AppMethodBeat.o(30716);
      return;
    }
    String str1 = parambi.field_talker;
    String str2 = parambi.field_talker;
    Bundle localBundle = new Bundle();
    if (com.tencent.mm.model.t.nU(str1)) {}
    for (int i = 7;; i = 1)
    {
      localBundle.putInt("stat_scene", i);
      localBundle.putString("stat_msg_id", "msg_" + Long.toString(parambi.field_msgSvrId));
      localBundle.putString("stat_chat_talker_username", str1);
      localBundle.putString("stat_send_msg_user", str2);
      paramIntent.putExtra("_stat_obj", localBundle);
      AppMethodBeat.o(30716);
      return;
    }
  }
  
  public static void eQ(View paramView)
  {
    AppMethodBeat.i(30709);
    long l1;
    Object localObject1;
    if ((paramView.getTag() instanceof d.f))
    {
      paramView = (d.f)paramView.getTag();
      l1 = paramView.cpO;
      String str1;
      String str2;
      String str3;
      String str4;
      if (paramView.zTe != null)
      {
        paramView = paramView.zTe;
        if (YC(paramView.zTg))
        {
          com.tencent.mm.aw.a.aiu();
          AppMethodBeat.o(30709);
          return;
        }
        localObject1 = paramView.lHo;
        localObject2 = paramView.title;
        localObject3 = paramView.fjX;
        str1 = paramView.url;
        str2 = paramView.url;
        str3 = paramView.playUrl;
        str4 = paramView.zTg;
        aw.aaz();
        com.tencent.mm.aw.a.b(com.tencent.mm.aw.g.a(0, (String)localObject1, (String)localObject2, (String)localObject3, str1, str2, str3, str4, c.getAccPath(), paramView.lHo, "", ""));
        AppMethodBeat.o(30709);
        return;
      }
      if (paramView.zTf == -1)
      {
        aw.aaz();
        localObject1 = c.YC().kB(paramView.cpO);
        boolean bool;
        if (YC(String.valueOf(l1)))
        {
          com.tencent.mm.plugin.report.service.h.qsU.kvStat(10231, "1");
          com.tencent.mm.aw.a.aiu();
          if (((dd)localObject1).field_msgId == l1)
          {
            paramView = com.tencent.mm.modelstat.b.fRu;
            bool = false;
            i = k.k((bi)localObject1);
          }
        }
        for (;;)
        {
          paramView.a((bi)localObject1, bool, i);
          do
          {
            AppMethodBeat.o(30709);
            return;
            localObject2 = j.b.mY(paramView.cBW);
            if (localObject2 != null)
            {
              com.tencent.mm.plugin.report.service.h.qsU.kvStat(10090, "0,1");
              long l2 = paramView.cpO;
              localObject3 = paramView.imgPath;
              aw.aaz();
              com.tencent.mm.aw.a.b(com.tencent.mm.aw.g.a((j.b)localObject2, String.valueOf(l2), (String)localObject3, c.getAccPath(), paramView.imgPath));
            }
          } while (((dd)localObject1).field_msgId != l1);
          paramView = com.tencent.mm.modelstat.b.fRu;
          bool = true;
          if (localObject2 != null) {
            i = ((j.b)localObject2).type;
          } else {
            i = 0;
          }
        }
      }
      Object localObject2 = paramView.cpO + "_" + paramView.zTf;
      aw.aaz();
      localObject1 = c.YC().kB(paramView.cpO);
      Object localObject3 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.biz.a.a.class)).b(paramView.cpO, paramView.cBW);
      if (YC((String)localObject2))
      {
        com.tencent.mm.plugin.report.service.h.qsU.kvStat(10231, "1");
        com.tencent.mm.aw.a.aiu();
        if (((dd)localObject1).field_msgId == l1) {
          com.tencent.mm.modelstat.b.fRu.a((bi)localObject1, false, k.k((bi)localObject1));
        }
        if ((localObject3 != null) && (((p)localObject3).fjy != null) && (((p)localObject3).fjy.size() > paramView.zTf))
        {
          paramView = (q)((p)localObject3).fjy.get(paramView.zTf);
          localObject1 = com.tencent.mm.plugin.report.service.h.qsU;
          if (paramView.type == 6) {}
          for (i = 1;; i = 0)
          {
            ((com.tencent.mm.plugin.report.service.h)localObject1).e(14972, new Object[] { Integer.valueOf(i), Integer.valueOf(1) });
            AppMethodBeat.o(30709);
            return;
          }
        }
      }
      else if ((localObject3 != null) && (((p)localObject3).fjy != null) && (((p)localObject3).fjy.size() > paramView.zTf))
      {
        com.tencent.mm.plugin.report.service.h.qsU.kvStat(10090, "0,1");
        localObject3 = (q)((p)localObject3).fjy.get(paramView.zTf);
        str1 = paramView.imgPath;
        str2 = ((q)localObject3).title;
        str3 = ((q)localObject3).fjX;
        str4 = ((q)localObject3).url;
        String str5 = ((q)localObject3).url;
        String str6 = ((q)localObject3).fjW;
        aw.aaz();
        com.tencent.mm.aw.a.b(com.tencent.mm.aw.g.a(0, str1, str2, str3, str4, str5, str6, (String)localObject2, c.getAccPath(), paramView.imgPath, "", ""));
        paramView = com.tencent.mm.plugin.report.service.h.qsU;
        if (((q)localObject3).type != 6) {
          break label760;
        }
      }
    }
    label760:
    for (int i = 1;; i = 0)
    {
      paramView.e(14972, new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
      if (((dd)localObject1).field_msgId == l1) {
        com.tencent.mm.modelstat.b.fRu.a((bi)localObject1, true, k.k((bi)localObject1));
      }
      AppMethodBeat.o(30709);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.r
 * JD-Core Version:    0.7.0.1
 */