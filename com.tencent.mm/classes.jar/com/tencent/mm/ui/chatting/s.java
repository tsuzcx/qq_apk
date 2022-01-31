package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.ae.l;
import com.tencent.mm.as.f;
import com.tencent.mm.as.o;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.h.a.cj.b;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.viewitems.aw;
import com.tencent.mm.ui.chatting.viewitems.d.f;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedList;

public final class s
{
  private static boolean Ma(String paramString)
  {
    boolean bool2 = false;
    com.tencent.mm.av.e locale = com.tencent.mm.av.a.Pw();
    boolean bool1 = bool2;
    if (locale != null)
    {
      bool1 = bool2;
      if (locale.eux != null)
      {
        bool1 = bool2;
        if (locale.euv == 0)
        {
          bool1 = bool2;
          if (!com.tencent.mm.av.a.Pu()) {}
        }
      }
    }
    try
    {
      boolean bool3 = bk.isEqual(locale.eux, paramString);
      bool1 = bool2;
      if (bool3) {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static void a(int paramInt, Context paramContext, String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    paramString1 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.biz.a.a.class)).d(paramLong1, paramString1);
    if (paramString1 == null) {
      y.w("MicroMsg.ChattingItemHelper", "transmitAppBrandMsg reader is null");
    }
    do
    {
      do
      {
        return;
      } while ((paramInt < 0) || (paramInt >= paramString1.dTx.size()));
      paramString1 = (com.tencent.mm.ae.m)paramString1.dTx.get(paramInt);
      localObject = g.a.a(m.a(paramString2, paramString1), null, null);
    } while (bk.bl((String)localObject));
    HashMap localHashMap = new HashMap();
    localHashMap.put("desc", paramString1.dTF);
    localHashMap.put("type", Integer.valueOf(2));
    localHashMap.put("title", paramString1.title);
    localHashMap.put("app_id", paramString1.dTM);
    localHashMap.put("pkg_type", Integer.valueOf(paramString1.dTL));
    localHashMap.put("pkg_version", Integer.valueOf(paramString1.dTK));
    localHashMap.put("img_url", paramString1.dTN);
    localHashMap.put("is_dynamic", Boolean.valueOf(false));
    localHashMap.put("cache_key", "");
    localHashMap.put("path", paramString1.dTJ);
    paramString1 = new Intent(paramContext, MsgRetransmitUI.class);
    paramString1.putExtra("appbrand_params", localHashMap);
    paramString1.putExtra("Retr_Msg_content", (String)localObject);
    paramString1.putExtra("Retr_Msg_Type", 2);
    paramString1.putExtra("Retr_Biz_Msg_Selected_Msg_Index", paramInt);
    paramString1.putExtra("Retr_Msg_Id", paramLong1);
    paramString1.putExtra("Retr_MsgFromScene", 3);
    Object localObject = u.ij(String.valueOf(paramLong2));
    paramString1.putExtra("reportSessionId", (String)localObject);
    localObject = u.Hc().v((String)localObject, true);
    ((u.b)localObject).h("prePublishId", "msg_" + paramLong2);
    ((u.b)localObject).h("preUsername", paramString2);
    ((u.b)localObject).h("preChatName", paramString2);
    ((u.b)localObject).h("preMsgIndex", Integer.valueOf(paramInt));
    ((u.b)localObject).h("sendAppMsgScene", Integer.valueOf(1));
    paramContext.startActivity(paramString1);
  }
  
  public static void a(long paramLong, int paramInt, Context paramContext, Fragment paramFragment, Activity paramActivity, bi parambi)
  {
    Object localObject = parambi.field_talker;
    String str = u.ij(parambi.field_msgSvrId);
    u.b localb = u.Hc().v(str, true);
    localb.h("prePublishId", "msg_" + parambi.field_msgSvrId);
    localb.h("preUsername", localObject);
    localb.h("preChatName", localObject);
    localb.h("preMsgIndex", Integer.valueOf(paramInt));
    localb.h("sendAppMsgScene", Integer.valueOf(1));
    localObject = new cj();
    ((cj)localObject).bIw.bIA = paramInt;
    ((cj)localObject).bIw.bIB = str;
    ((cj)localObject).bIw.uD = paramFragment;
    ((cj)localObject).bIw.activity = paramActivity;
    ((cj)localObject).bIw.bID = 40;
    com.tencent.mm.pluginsdk.model.e.a((cj)localObject, parambi);
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
    if (((cj)localObject).bIx.ret == 0)
    {
      paramFragment = g.a.gp(com.tencent.mm.ae.i.a(paramContext, paramInt, parambi.field_content, parambi.field_talker, parambi.field_msgId));
      if (!parambi.aVK()) {
        break label404;
      }
      paramContext = com.tencent.mm.modelstat.b.eBD;
      if (paramFragment == null) {
        break label399;
      }
      paramInt = paramFragment.type;
      paramContext.b(parambi, paramInt);
    }
    for (;;)
    {
      if ((paramFragment != null) && (paramFragment.type == 5) && (paramFragment.url != null))
      {
        y.d("MicroMsg.ChattingItemHelper", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), paramFragment.url, Long.valueOf(paramLong), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1) });
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
          y.printErrStackTrace("MicroMsg.ChattingItemHelper", paramFragment, "", new Object[0]);
        }
      }
      com.tencent.mm.plugin.report.service.h.nFQ.f(13378, new Object[] { paramContext, Long.valueOf(paramLong), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1) });
      return;
      label399:
      paramInt = 0;
      break;
      label404:
      com.tencent.mm.modelstat.b.eBD.x(parambi);
    }
  }
  
  public static void a(View paramView, Context paramContext, String paramString)
  {
    aw localaw = (aw)paramView.getTag();
    String str = localaw.bJd;
    paramView = str;
    if (TextUtils.isEmpty(str)) {
      paramView = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Az(localaw.cQF);
    }
    if (TextUtils.isEmpty(paramView))
    {
      paramView = new Intent();
      paramView.putExtra("geta8key_username", paramString);
      paramView.putExtra("rawUrl", localaw.cQF);
      com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramView);
      return;
    }
    paramString = new Intent();
    paramString.putExtra("extra_id", paramView);
    paramString.putExtra("extra_name", localaw.title);
    if (localaw.vHl)
    {
      paramString.putExtra("download_entrance_scene", 20);
      paramString.putExtra("preceding_scence", 3);
      paramString.putExtra("reward_tip", true);
      com.tencent.mm.plugin.report.service.h.nFQ.f(12953, new Object[] { Integer.valueOf(1), paramView });
    }
    for (;;)
    {
      com.tencent.mm.br.d.b(paramContext, "emoji", ".ui.EmojiStoreDetailUI", paramString);
      return;
      if (localaw.vHm)
      {
        paramString.putExtra("download_entrance_scene", 25);
        paramString.putExtra("preceding_scence", 9);
        paramString.putExtra("reward_tip", true);
      }
      else
      {
        paramString.putExtra("download_entrance_scene", 22);
        paramString.putExtra("preceding_scence", 122);
        com.tencent.mm.plugin.report.service.h.nFQ.f(10993, new Object[] { Integer.valueOf(2), paramView });
      }
    }
  }
  
  public static void a(com.tencent.mm.ae.m paramm, View paramView, String paramString)
  {
    if ((paramView == null) || (paramm == null)) {
      return;
    }
    paramView.setOnClickListener(new s.1(paramm, paramString));
  }
  
  public static void a(bi parambi, Context paramContext, com.tencent.mm.ui.chatting.c.a parama)
  {
    int j = 1;
    au.Hx();
    if (!c.isSDCardAvailable()) {
      com.tencent.mm.ui.base.s.gM(paramContext);
    }
    for (;;)
    {
      return;
      Object localObject1 = null;
      if (parambi.field_msgId > 0L) {
        localObject1 = o.OJ().bY(parambi.field_msgId);
      }
      if (((localObject1 == null) || (((com.tencent.mm.as.e)localObject1).enp <= 0L)) && (parambi.field_msgSvrId > 0L)) {
        localObject1 = o.OJ().bX(parambi.field_msgSvrId);
      }
      while (localObject1 != null)
      {
        int i;
        if (parambi.field_isSend == 1) {
          if (((com.tencent.mm.as.e)localObject1).Or()) {
            i = 1;
          }
        }
        Object localObject2;
        while (parambi.cvx())
        {
          y.i("MicroMsg.ChattingItemHelper", "image is clean!!!");
          com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(R.l.imgdownload_cleaned), paramContext.getString(R.l.app_tip), new s.2());
          return;
          i = 0;
          continue;
          if (!((com.tencent.mm.as.e)localObject1).Or())
          {
            i = 0;
          }
          else
          {
            localObject2 = f.a((com.tencent.mm.as.e)localObject1);
            if (!com.tencent.mm.vfs.e.bK(o.OJ().o(((com.tencent.mm.as.e)localObject2).enq, "", ""))) {
              i = 0;
            } else {
              i = 1;
            }
          }
        }
        if (com.tencent.mm.ui.chatting.b.i.e(parambi, o.OJ().o(f.c((com.tencent.mm.as.e)localObject1), "", "")))
        {
          y.i("MicroMsg.ChattingItemHelper", "img is expired or clean!!!");
          localObject1 = new Intent(paramContext, ImageGalleryUI.class);
          ((Intent)localObject1).putExtra("img_gallery_msg_id", parambi.field_msgId);
          ((Intent)localObject1).putExtra("img_gallery_msg_svr_id", parambi.field_msgSvrId);
          ((Intent)localObject1).putExtra("img_gallery_talker", parambi.field_talker);
          ((Intent)localObject1).putExtra("img_gallery_chatroom_name", parambi.field_talker);
          ((Intent)localObject1).putExtra("img_gallery_is_restransmit_after_download", true);
          ((Intent)localObject1).putExtra("Retr_show_success_tips", true);
          if (parama != null) {
            com.tencent.mm.ui.chatting.b.i.a(parama, parambi, (Intent)localObject1);
          }
          for (;;)
          {
            paramContext.startActivity((Intent)localObject1);
            return;
            if (parambi != null)
            {
              parama = parambi.field_talker;
              localObject2 = parambi.field_talker;
              Bundle localBundle = new Bundle();
              i = j;
              if (com.tencent.mm.model.s.hl(parama)) {
                i = 7;
              }
              localBundle.putInt("stat_scene", i);
              localBundle.putString("stat_msg_id", "msg_" + Long.toString(parambi.field_msgSvrId));
              localBundle.putString("stat_chat_talker_username", parama);
              localBundle.putString("stat_send_msg_user", (String)localObject2);
              ((Intent)localObject1).putExtra("_stat_obj", localBundle);
            }
          }
        }
        if ((((com.tencent.mm.as.e)localObject1).offset >= ((com.tencent.mm.as.e)localObject1).ebK) && (((com.tencent.mm.as.e)localObject1).ebK != 0))
        {
          parama = new Intent(paramContext, MsgRetransmitUI.class);
          parama.putExtra("Retr_File_Name", o.OJ().o(f.c((com.tencent.mm.as.e)localObject1), "", ""));
          parama.putExtra("Retr_Msg_Id", parambi.field_msgId);
          parama.putExtra("Retr_Msg_Type", 0);
          parama.putExtra("Retr_show_success_tips", true);
          parama.putExtra("Retr_Compress_Type", i);
          paramContext.startActivity(parama);
          return;
        }
        parama = new Intent(paramContext, MsgRetransmitUI.class);
        parama.putExtra("Retr_File_Name", o.OJ().F(parambi.field_imgPath, true));
        parama.putExtra("Retr_Msg_Id", parambi.field_msgId);
        parama.putExtra("Retr_Msg_Type", 0);
        parama.putExtra("Retr_show_success_tips", true);
        parama.putExtra("Retr_Compress_Type", i);
        paramContext.startActivity(parama);
        return;
      }
    }
  }
  
  public static void dH(View paramView)
  {
    long l1;
    Object localObject2;
    boolean bool;
    if ((paramView.getTag() instanceof d.f))
    {
      paramView = (d.f)paramView.getTag();
      l1 = paramView.bIt;
      if (paramView.vCm != -1) {
        break label364;
      }
      au.Hx();
      localObject2 = c.Fy().fd(paramView.bIt);
      if (!Ma(String.valueOf(l1))) {
        break label107;
      }
      com.tencent.mm.plugin.report.service.h.nFQ.aC(10231, "1");
      com.tencent.mm.av.a.Ps();
      if (((cs)localObject2).field_msgId == l1)
      {
        paramView = com.tencent.mm.modelstat.b.eBD;
        bool = false;
        i = com.tencent.mm.ae.h.g((bi)localObject2);
        paramView.a((bi)localObject2, bool, i);
      }
    }
    label107:
    Object localObject3;
    String str2;
    String str1;
    label364:
    do
    {
      long l2;
      do
      {
        return;
        localObject3 = g.a.gp(paramView.bUr);
        if (localObject3 != null)
        {
          com.tencent.mm.plugin.report.service.h.nFQ.aC(10090, "0,1");
          l2 = paramView.bIt;
          str2 = paramView.imgPath;
          au.Hx();
          str1 = c.FU();
          paramView = paramView.imgPath;
          if (localObject3 != null) {
            break;
          }
          paramView = null;
          com.tencent.mm.av.a.b(paramView);
        }
      } while (((cs)localObject2).field_msgId != l1);
      paramView = com.tencent.mm.modelstat.b.eBD;
      bool = true;
      if (localObject3 != null)
      {
        i = ((g.a)localObject3).type;
        break;
        localObject1 = new com.tencent.mm.av.e();
        ((com.tencent.mm.av.e)localObject1).euv = 0;
        ((com.tencent.mm.av.e)localObject1).eux = String.valueOf(l2);
        ((com.tencent.mm.av.e)localObject1).euy = 0.0F;
        ((com.tencent.mm.av.e)localObject1).euB = "";
        ((com.tencent.mm.av.e)localObject1).euC = str2;
        ((com.tencent.mm.av.e)localObject1).euH = paramView;
        ((com.tencent.mm.av.e)localObject1).euw = 1;
        ((com.tencent.mm.av.e)localObject1).euG = null;
        ((com.tencent.mm.av.e)localObject1).euz = ((g.a)localObject3).title;
        ((com.tencent.mm.av.e)localObject1).euA = ((g.a)localObject3).description;
        ((com.tencent.mm.av.e)localObject1).euF = ((g.a)localObject3).url;
        if (!bk.bl(((g.a)localObject3).dQV)) {}
        for (paramView = ((g.a)localObject3).dQV;; paramView = ((g.a)localObject3).dQu)
        {
          ((com.tencent.mm.av.e)localObject1).euE = paramView;
          ((com.tencent.mm.av.e)localObject1).euD = ((g.a)localObject3).dQU;
          ((com.tencent.mm.av.e)localObject1).euK = ((g.a)localObject3).appId;
          ((com.tencent.mm.av.e)localObject1).euI = str1;
          paramView = (View)localObject1;
          break;
        }
      }
      i = 0;
      break;
      localObject2 = paramView.bIt + "_" + paramView.vCm;
      au.Hx();
      localObject1 = c.Fy().fd(paramView.bIt);
      localObject3 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.biz.a.a.class)).d(paramView.bIt, paramView.bUr);
      if (!Ma((String)localObject2)) {
        break label576;
      }
      com.tencent.mm.plugin.report.service.h.nFQ.aC(10231, "1");
      com.tencent.mm.av.a.Ps();
      if (((cs)localObject1).field_msgId == l1) {
        com.tencent.mm.modelstat.b.eBD.a((bi)localObject1, false, com.tencent.mm.ae.h.g((bi)localObject1));
      }
    } while ((localObject3 == null) || (((l)localObject3).dTx == null) || (((l)localObject3).dTx.size() <= paramView.vCm));
    paramView = (com.tencent.mm.ae.m)((l)localObject3).dTx.get(paramView.vCm);
    Object localObject1 = com.tencent.mm.plugin.report.service.h.nFQ;
    if (paramView.type == 6) {}
    for (int i = 1;; i = 0)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject1).f(14972, new Object[] { Integer.valueOf(i), Integer.valueOf(1) });
      return;
    }
    label576:
    if ((localObject3 != null) && (((l)localObject3).dTx != null) && (((l)localObject3).dTx.size() > paramView.vCm))
    {
      com.tencent.mm.plugin.report.service.h.nFQ.aC(10090, "0,1");
      localObject3 = (com.tencent.mm.ae.m)((l)localObject3).dTx.get(paramView.vCm);
      str1 = paramView.imgPath;
      str2 = ((com.tencent.mm.ae.m)localObject3).title;
      String str3 = ((com.tencent.mm.ae.m)localObject3).dTR;
      String str4 = ((com.tencent.mm.ae.m)localObject3).url;
      String str5 = ((com.tencent.mm.ae.m)localObject3).url;
      String str6 = ((com.tencent.mm.ae.m)localObject3).dTQ;
      au.Hx();
      com.tencent.mm.av.a.b(com.tencent.mm.av.g.a(0, str1, str2, str3, str4, str5, str6, (String)localObject2, c.FU(), paramView.imgPath, "", ""));
      paramView = com.tencent.mm.plugin.report.service.h.nFQ;
      if (((com.tencent.mm.ae.m)localObject3).type != 6) {
        break label776;
      }
    }
    label776:
    for (i = 1;; i = 0)
    {
      paramView.f(14972, new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
      if (((cs)localObject1).field_msgId != l1) {
        break;
      }
      com.tencent.mm.modelstat.b.eBD.a((bi)localObject1, true, com.tencent.mm.ae.h.g((bi)localObject1));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s
 * JD-Core Version:    0.7.0.1
 */