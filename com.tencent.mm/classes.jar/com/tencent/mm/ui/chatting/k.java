package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.R.g;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.ah.p;
import com.tencent.mm.ai.z;
import com.tencent.mm.h.a.nd;
import com.tencent.mm.h.a.nd.b;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.j.f.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.q;
import com.tencent.mm.model.u.b;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class k
{
  static void a(Context paramContext, com.tencent.mm.as.e parame, bi parambi, int paramInt, String paramString1, String paramString2)
  {
    Object localObject2 = com.tencent.mm.as.o.OJ().o(com.tencent.mm.as.f.c(parame), "", "");
    Object localObject1 = new PString();
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    ((PString)localObject1).value = ((String)localObject2);
    int i = parame.ent;
    long l1 = com.tencent.mm.as.o.OJ().a((String)localObject2, i, paramInt, 0, (PString)localObject1, localPInt1, localPInt2);
    localObject2 = com.tencent.mm.as.o.OJ().b(Long.valueOf(l1));
    ((com.tencent.mm.as.e)localObject2).iF(1);
    bi localbi = new bi();
    localbi.setType(com.tencent.mm.model.s.hX(paramString1));
    localbi.ec(paramString1);
    localbi.fA(1);
    localbi.setStatus(1);
    localbi.ed(((PString)localObject1).value);
    localbi.fK(localPInt1.value);
    localbi.fL(localPInt2.value);
    localbi.bg(bd.iK(localbi.field_talker));
    if (com.tencent.mm.ai.f.eW(localbi.field_talker)) {
      parambi.cY(com.tencent.mm.ai.a.e.HR());
    }
    au.Hx();
    long l2 = com.tencent.mm.model.c.Fy().T(localbi);
    if (l2 >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      y.i("MicroMsg.ChattingEditModeLogic", "NetSceneUploadMsgImg: local msgId = " + l2);
      ((com.tencent.mm.as.e)localObject2).bV((int)l2);
      com.tencent.mm.as.o.OJ().a(Long.valueOf(l1), (com.tencent.mm.as.e)localObject2);
      localObject1 = new HashMap();
      ((HashMap)localObject1).put(Long.valueOf(l2), parame);
      com.tencent.mm.as.o.OK().a(parame.enp, parambi.field_msgId, i, localObject1, R.g.chat_img_template, new k.3(paramContext, paramString1, parame, paramString2));
      return;
    }
  }
  
  public static void a(Context paramContext, String paramString, bi parambi)
  {
    if (!a(paramContext, paramString, parambi, "emoji")) {
      return;
    }
    String str = com.tencent.mm.storage.ap.abP(parambi.field_content).bIW;
    if ((str == null) || (str.endsWith("-1"))) {}
    for (parambi = parambi.field_imgPath;; parambi = str)
    {
      if (parambi == null)
      {
        y.w("MicroMsg.ChattingEditModeLogic", "showAcceptEmojiConnector: filePath is null");
        return;
      }
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().m(paramContext, paramString, parambi);
      return;
    }
  }
  
  public static void a(Context paramContext, String paramString, bi parambi, boolean paramBoolean)
  {
    if (!a(paramContext, paramString, parambi, "text")) {
      return;
    }
    String str = s(parambi.field_content, parambi.field_isSend, paramBoolean);
    paramContext = str;
    if (parambi.cvB())
    {
      paramContext = s(parambi.field_transContent, parambi.field_isSend, paramBoolean);
      paramContext = str + "\n\n" + paramContext;
    }
    if ((paramContext == null) || (paramContext.equals("")))
    {
      y.e("MicroMsg.ChattingEditModeLogic", "Transfer text erro: content null");
      return;
    }
    com.tencent.mm.plugin.messenger.a.g.bhI().D(paramString, paramContext, com.tencent.mm.model.s.hW(paramString));
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    try
    {
      bi localbi = new bi();
      localbi.setContent(paramString2);
      localbi.fA(paramInt);
      paramInt = paramString2.indexOf("<msg>");
      String str = paramString2;
      if (paramInt > 0)
      {
        str = paramString2;
        if (paramInt < paramString2.length()) {
          str = paramString2.substring(paramInt).trim();
        }
      }
      paramString2 = bn.s(str, "msg");
      if ((paramString2 != null) && (paramString2.size() > 0)) {
        localbi.ee(ba.au(paramString2));
      }
      b(paramContext, paramString1, localbi, paramBoolean);
      return;
    }
    catch (Exception paramContext)
    {
      y.printErrStackTrace("MicroMsg.ChattingEditModeLogic", paramContext, "", new Object[0]);
      y.e("MicroMsg.ChattingEditModeLogic", "retransmit sigle app msg error : %s", new Object[] { paramContext.getLocalizedMessage() });
    }
  }
  
  static boolean a(Context paramContext, String paramString1, bi parambi, String paramString2)
  {
    if (paramContext == null)
    {
      y.w("MicroMsg.ChattingEditModeLogic", "send %s fail, context is null", new Object[] { paramString2 });
      return false;
    }
    if (bk.bl(paramString1))
    {
      y.w("MicroMsg.ChattingEditModeLogic", "send %s fail, username is null", new Object[] { paramString2 });
      return false;
    }
    if (parambi == null)
    {
      y.w("MicroMsg.ChattingEditModeLogic", "send %s fail, msg is null", new Object[] { paramString2 });
      return false;
    }
    return true;
  }
  
  public static boolean a(List<bi> paramList, aj paramaj)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    if ((paramList == null) || (paramList.isEmpty()))
    {
      y.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to friend msg error, select item empty");
      bool2 = false;
    }
    do
    {
      return bool2;
      if ((paramList.size() != 1) || (paramaj == null) || (!paramaj.cDf())) {
        break;
      }
      paramList = (bi)paramList.get(0);
    } while ((!az(paramList)) && (!paramList.ctA()) && (!ao(paramList)) && (!aq(paramList)) && (!ar(paramList)) && (paramList.getType() != -1879048186) && (paramList.getType() != 318767153) && (!ay(paramList)) && (!as(paramList)) && (!aA(paramList)) && (!ax(paramList)) && (!at(paramList)));
    return false;
    paramList = paramList.iterator();
    bi localbi;
    for (;;)
    {
      bool2 = bool1;
      if (!paramList.hasNext()) {
        break;
      }
      localbi = (bi)paramList.next();
      if ((paramaj == null) || (!paramaj.cDf())) {
        break label352;
      }
      if ((!localbi.ctA()) && (!ao(localbi)) && (!aq(localbi)) && (!ar(localbi)) && (localbi.getType() != -1879048186) && (!ay(localbi)) && (!as(localbi)) && ((!au(localbi)) || ((paramaj != null) && (paramaj.cDf()))) && ((!av(localbi)) || ((paramaj != null) && (paramaj.cDf()))) && (localbi.getType() != 318767153) && (!az(localbi)) && (!aA(localbi)) && (!ax(localbi)) && (!at(localbi))) {
        break label379;
      }
      paramList.remove();
      bool1 = false;
    }
    label352:
    if ((au(localbi)) || (av(localbi)))
    {
      paramList.remove();
      bool1 = false;
    }
    label379:
    for (;;)
    {
      break;
    }
  }
  
  private static boolean aA(bi parambi)
  {
    if ((parambi != null) && (parambi.aVK()))
    {
      parambi = g.a.gp(parambi.field_content);
      if ((parambi != null) && (parambi.type == 6) && ((parambi.dQz != 0) || (parambi.dQv > 26214400))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean aB(bi parambi)
  {
    if ((parambi != null) && (parambi.aVK()))
    {
      parambi = g.a.gp(parambi.field_content);
      if ((parambi != null) && (parambi.type == 6)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean ao(bi parambi)
  {
    if (parambi == null)
    {
      y.w("MicroMsg.ChattingEditModeLogic", "check is store emoji error, msg is null");
      return true;
    }
    if (parambi.cvp())
    {
      com.tencent.mm.storage.ap localap = new com.tencent.mm.storage.ap(parambi.field_content);
      parambi = g.a.M(parambi.field_content, parambi.field_reserved);
      if (parambi != null) {
        break label180;
      }
      parambi = new g.a();
      parambi.dQx = localap.bIW;
    }
    label180:
    for (;;)
    {
      for (parambi = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().As(parambi.dQx); (parambi != null) && ((parambi.field_catalog == EmojiInfo.uCZ) || ((!bk.bl(parambi.field_groupId)) && (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Ax(parambi.field_groupId)))); parambi = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().As(parambi.field_imgPath)) {
        return false;
      }
      return (parambi != null) && (parambi.cwE());
    }
  }
  
  public static boolean ap(bi parambi)
  {
    if (parambi.cvp())
    {
      com.tencent.mm.storage.ap localap = new com.tencent.mm.storage.ap(parambi.field_content);
      parambi = g.a.M(parambi.field_content, parambi.field_reserved);
      if (parambi != null) {
        break label80;
      }
      parambi = new g.a();
      parambi.dQx = localap.bIW;
    }
    label80:
    for (;;)
    {
      return ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().As(parambi.dQx) != null;
    }
  }
  
  public static boolean aq(bi parambi)
  {
    if (parambi == null)
    {
      y.w("MicroMsg.ChattingEditModeLogic", "check is game msg error, msg is null");
      return true;
    }
    if (parambi.field_isSend == 0) {}
    for (parambi = bd.iJ(parambi.field_content);; parambi = parambi.field_content)
    {
      parambi = g.a.gp(parambi);
      if (parambi != null) {
        break;
      }
      y.w("MicroMsg.ChattingEditModeLogic", "parse app message content fail");
      return false;
    }
    parambi = com.tencent.mm.pluginsdk.model.app.g.by(parambi.appId, false);
    return (parambi != null) && (parambi.ZH());
  }
  
  public static boolean ar(bi parambi)
  {
    return parambi.getType() == 419430449;
  }
  
  public static boolean as(bi parambi)
  {
    return (parambi.getType() == 436207665) || (parambi.getType() == 469762097);
  }
  
  public static boolean at(bi parambi)
  {
    if (parambi == null)
    {
      y.w("MicroMsg.ChattingEditModeLogic", "isAppbrandForbidForwardMsg, check msg error, msg is null");
      return true;
    }
    if (parambi.field_isSend == 0) {}
    for (parambi = bd.iJ(parambi.field_content);; parambi = parambi.field_content)
    {
      parambi = g.a.gp(parambi);
      if (parambi != null) {
        break;
      }
      y.w("MicroMsg.ChattingEditModeLogic", "isAppbrandForbidForwardMsg, parse app message content fail");
      return false;
    }
    return (parambi.type == 33) && (parambi.dTa == 3);
  }
  
  private static boolean au(bi parambi)
  {
    if (parambi != null)
    {
      parambi = g.a.gp(parambi.field_content);
      if ((parambi != null) && (parambi.type == 19))
      {
        Object localObject = new nd();
        ((nd)localObject).bWJ.type = 0;
        ((nd)localObject).bWJ.bWL = parambi.dRd;
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
        localObject = ((nd)localObject).bWK.bWT;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.protocal.b.a.c)localObject).dTx.iterator();
          while (((Iterator)localObject).hasNext())
          {
            xv localxv = (xv)((Iterator)localObject).next();
            if (!bk.bl(localxv.sVY))
            {
              y.e("MicroMsg.ChattingEditModeLogic", "record type subDataItem contain tpurl, type:%d", new Object[] { Integer.valueOf(localxv.aYU) });
              return true;
            }
          }
        }
        return (parambi.dRd != null) && (parambi.dRd.contains("<recordxml>"));
      }
    }
    return false;
  }
  
  private static boolean av(bi parambi)
  {
    if (parambi != null)
    {
      parambi = g.a.gp(parambi.field_content);
      if ((parambi != null) && (parambi.type == 24)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean aw(bi parambi)
  {
    if (parambi != null)
    {
      parambi = g.a.gp(parambi.field_content);
      if (parambi != null) {
        break label18;
      }
    }
    label18:
    while ((parambi.type != 6) && (parambi.type != 5) && (parambi.type != 19)) {
      return false;
    }
    return true;
  }
  
  public static boolean ax(bi parambi)
  {
    if ((parambi == null) || (!parambi.ctz())) {
      return false;
    }
    return com.tencent.mm.ae.i.e(parambi.field_msgId, parambi.field_content);
  }
  
  static boolean ay(bi parambi)
  {
    if (parambi != null)
    {
      parambi = g.a.gp(parambi.field_content);
      if ((parambi != null) && (parambi.type == 16)) {}
      while ((parambi != null) && (parambi.type == 34)) {
        return true;
      }
    }
    return false;
  }
  
  static boolean az(bi parambi)
  {
    if (!parambi.cvn()) {}
    do
    {
      return false;
      au.Hx();
      parambi = com.tencent.mm.model.c.Fy().HN(parambi.field_content);
      if ((parambi == null) || (bk.bl(parambi.pyp))) {
        return true;
      }
    } while (com.tencent.mm.model.s.hl(parambi.pyp));
    return true;
  }
  
  public static void b(Context paramContext, String paramString, bi parambi)
  {
    if (!a(paramContext, paramString, parambi, "image")) {}
    Object localObject1;
    Object localObject2;
    int i;
    String str1;
    label342:
    do
    {
      for (;;)
      {
        return;
        localObject1 = null;
        if (parambi.field_msgId > 0L) {
          localObject1 = com.tencent.mm.as.o.OJ().bY(parambi.field_msgId);
        }
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((com.tencent.mm.as.e)localObject1).enp > 0L) {}
        }
        else
        {
          localObject2 = localObject1;
          if (parambi.field_msgSvrId > 0L) {
            localObject2 = com.tencent.mm.as.o.OJ().bX(parambi.field_msgSvrId);
          }
        }
        if (localObject2 != null)
        {
          int j = 0;
          i = j;
          if (((com.tencent.mm.as.e)localObject2).Or())
          {
            i = j;
            if (!com.tencent.mm.as.f.a((com.tencent.mm.as.e)localObject2).enq.startsWith("SERVERID://")) {
              i = 1;
            }
          }
          localObject1 = com.tencent.mm.as.o.OJ().o(com.tencent.mm.as.f.c((com.tencent.mm.as.e)localObject2), "", "");
          str1 = com.tencent.mm.as.o.OJ().o(((com.tencent.mm.as.e)localObject2).ens, "th_", "");
          if ((((com.tencent.mm.as.e)localObject2).offset >= ((com.tencent.mm.as.e)localObject2).ebK) && (((com.tencent.mm.as.e)localObject2).ebK != 0)) {
            break;
          }
          String str2 = q.Gj();
          String str3 = ((com.tencent.mm.as.e)localObject2).enA;
          Object localObject3 = bn.s(((com.tencent.mm.as.e)localObject2).enA, "msg");
          if (localObject3 == null)
          {
            y.e("MicroMsg.ChattingEditModeLogic", "parse cdnInfo failed. [%s]", new Object[] { ((com.tencent.mm.as.e)localObject2).enA });
            i = 0;
          }
          while (i == 0)
          {
            a(paramContext, (com.tencent.mm.as.e)localObject2, parambi, 4, paramString, str1);
            return;
            j = ((com.tencent.mm.as.e)localObject2).ent;
            if (j != 1) {
              localObject1 = (String)((Map)localObject3).get(".msg.img.$cdnmidimgurl");
            }
            for (i = 2;; i = 1)
            {
              y.d("MicroMsg.ChattingEditModeLogic", "cdntra read xml  comptype:%d url:[%s]", new Object[] { Integer.valueOf(j), localObject1 });
              if (!bk.bl((String)localObject1)) {
                break label342;
              }
              y.e("MicroMsg.ChattingEditModeLogic", "cdntra get cdnUrlfailed.");
              i = 0;
              break;
              localObject1 = (String)((Map)localObject3).get(".msg.img.$cdnbigimgurl");
            }
            String str4 = (String)((Map)localObject3).get(".msg.img.$aeskey");
            if (bk.bl(str4))
            {
              y.e("MicroMsg.ChattingEditModeLogic", "cdntra get aes key failed.");
              i = 0;
            }
            else if (bk.bl(com.tencent.mm.ak.c.a("downimg", ((com.tencent.mm.as.e)localObject2).enw, parambi.field_talker, parambi.field_msgId)))
            {
              y.w("MicroMsg.ChattingEditModeLogic", "cdntra genClientId failed not use cdn imgLocalId:%d", new Object[] { Long.valueOf(parambi.field_msgSvrId) });
              i = 0;
            }
            else
            {
              localObject3 = (String)((Map)localObject3).get(".msg.img.$md5");
              com.tencent.mm.j.f localf = new com.tencent.mm.j.f();
              localf.dlP = new k.1(parambi, i, paramString, str2, str3, (String)localObject3, j, (com.tencent.mm.as.e)localObject2, paramContext);
              localf.field_mediaId = com.tencent.mm.ak.c.a("checkExist", bk.UY(), paramString, parambi.field_msgId);
              localf.field_fileId = ((String)localObject1);
              localf.field_aesKey = str4;
              localf.field_filemd5 = ((String)localObject3);
              localf.field_fileType = i;
              localf.field_talker = paramString;
              localf.field_priority = com.tencent.mm.j.a.dlk;
              localf.field_svr_signature = "";
              localf.field_onlycheckexist = true;
              localf.field_trysafecdn = true;
              if (!com.tencent.mm.ak.f.Nd().c(localf))
              {
                y.e("MicroMsg.ChattingEditModeLogic", "check exist fail! download img before retransmit");
                i = 0;
              }
              else
              {
                i = 1;
              }
            }
          }
        }
      }
    } while (bk.bl((String)localObject1));
    com.tencent.mm.plugin.messenger.a.g.bhI().a(paramContext, paramString, (String)localObject1, i, ((com.tencent.mm.as.e)localObject2).enA, str1);
  }
  
  public static void b(Context paramContext, String paramString, bi parambi, boolean paramBoolean)
  {
    if (!a(paramContext, paramString, parambi, "appmsg")) {}
    do
    {
      return;
      if (paramContext == null)
      {
        y.w("MicroMsg.ChattingEditModeLogic", "getReaderAppMsgContent: context is null");
        return;
      }
      if (parambi == null)
      {
        y.w("MicroMsg.ChattingEditModeLogic", "getReaderAppMsgContent: msg is null");
        return;
      }
      au.Hx();
    } while (!com.tencent.mm.model.c.isSDCardAvailable());
    paramContext = com.tencent.mm.as.o.OJ().b(parambi.field_imgPath, false, false);
    if ((!ah.bl(paramContext)) && (!paramContext.endsWith("hd")) && (com.tencent.mm.vfs.e.bK(paramContext + "hd"))) {
      paramContext = paramContext + "hd";
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject1 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.biz.a.a.class)).d(parambi.field_msgId, parambi.field_content);
        localObject2 = ((com.tencent.mm.ae.l)localObject1).dTx;
        if ((localObject2 == null) || (((List)localObject2).size() <= 0))
        {
          if ((parambi == null) || ((!parambi.aVK()) && (!parambi.ctz()))) {
            break label613;
          }
          localObject1 = com.tencent.mm.model.u.ij(parambi.field_msgSvrId);
          localObject2 = com.tencent.mm.model.u.Hc().v((String)localObject1, true);
          ((u.b)localObject2).h("prePublishId", "msg_" + parambi.field_msgSvrId);
          ((u.b)localObject2).h("preUsername", com.tencent.mm.ui.chatting.viewitems.c.a(parambi, paramBoolean, false));
          ((u.b)localObject2).h("preChatName", parambi.field_talker);
          ((u.b)localObject2).h("preMsgIndex", Integer.valueOf(0));
          ((u.b)localObject2).h("sendAppMsgScene", Integer.valueOf(1));
          ((com.tencent.mm.plugin.sns.b.i)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.sns.b.i.class)).a("adExtStr", (u.b)localObject2, parambi);
          com.tencent.mm.plugin.messenger.a.g.bhI().a(paramString, bk.readFromFile(paramContext), bk.ZQ(parambi.field_content), (String)localObject1);
          return;
        }
      }
      catch (Exception paramContext)
      {
        y.printErrStackTrace("MicroMsg.ChattingEditModeLogic", paramContext, "", new Object[0]);
        y.e("MicroMsg.ChattingEditModeLogic", "send app msg error : %s", new Object[] { paramContext.getLocalizedMessage() });
        return;
      }
      parambi = ((List)localObject2).iterator();
      while (parambi.hasNext())
      {
        Object localObject3 = (com.tencent.mm.ae.m)parambi.next();
        localObject2 = new g.a();
        if (com.tencent.mm.ae.i.gr(((com.tencent.mm.ae.m)localObject3).dTI))
        {
          m.b(paramString, m.a(paramString, (com.tencent.mm.ae.m)localObject3), ((com.tencent.mm.ae.m)localObject3).dTN);
        }
        else
        {
          ((g.a)localObject2).title = ((com.tencent.mm.ae.m)localObject3).title;
          ((g.a)localObject2).description = ((com.tencent.mm.ae.m)localObject3).dTF;
          ((g.a)localObject2).action = "view";
          ((g.a)localObject2).type = 5;
          ((g.a)localObject2).url = ((com.tencent.mm.ae.m)localObject3).url;
          ((g.a)localObject2).bYG = ((com.tencent.mm.ae.l)localObject1).bYG;
          ((g.a)localObject2).bYH = ((com.tencent.mm.ae.l)localObject1).bYH;
          ((g.a)localObject2).cQF = ((com.tencent.mm.ae.l)localObject1).cQF;
          ((g.a)localObject2).thumburl = ((com.tencent.mm.ae.m)localObject3).dTD;
          if ((bk.bl(((g.a)localObject2).thumburl)) && (!bk.bl(((g.a)localObject2).bYG)))
          {
            localObject3 = com.tencent.mm.ag.o.Kh().kp(((g.a)localObject2).bYG);
            if (localObject3 != null) {
              ((g.a)localObject2).thumburl = ((com.tencent.mm.ag.h)localObject3).JX();
            }
          }
          localObject2 = g.a.a((g.a)localObject2, null, null);
          com.tencent.mm.plugin.messenger.a.g.bhI().a(paramString, bk.readFromFile(paramContext), bk.ZQ((String)localObject2), null);
        }
      }
      break;
      label613:
      Object localObject1 = null;
    }
  }
  
  public static void b(EmojiInfo paramEmojiInfo, String paramString)
  {
    WXMediaMessage localWXMediaMessage = new WXMediaMessage();
    Object localObject = new StringBuilder();
    au.Hx();
    localObject = com.tencent.mm.model.c.FL() + paramEmojiInfo.Wv();
    if (com.tencent.mm.vfs.e.aeQ((String)localObject + "_thumb") > 0L)
    {
      int i = (int)com.tencent.mm.vfs.e.aeQ((String)localObject + "_thumb");
      localWXMediaMessage.thumbData = com.tencent.mm.vfs.e.c((String)localObject + "_thumb", 0, i);
    }
    for (;;)
    {
      localWXMediaMessage.mediaObject = new WXEmojiObject((String)localObject);
      com.tencent.mm.pluginsdk.model.app.l.a(localWXMediaMessage, paramEmojiInfo.field_app_id, null, paramString, 1, paramEmojiInfo.Wv());
      return;
      try
      {
        InputStream localInputStream = com.tencent.mm.vfs.e.openRead((String)localObject);
        localWXMediaMessage.setThumbImage(BackwardSupportUtil.b.a(localInputStream, 1.0F));
        localInputStream.close();
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.ChattingEditModeLogic", localException, "", new Object[0]);
        y.e("MicroMsg.ChattingEditModeLogic", "sendAppMsgEmoji Fail cause there is no thumb");
      }
    }
  }
  
  public static void b(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3)
  {
    y.d("MicroMsg.ChattingEditModeLogic", "copy video fileName %s userName %s export %d videoLength %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    String str1 = t.nR(q.Gj());
    com.tencent.mm.modelvideo.o.Sr();
    String str2 = t.nS(paramString1);
    String str3 = t.nS(str1);
    paramString1 = t.nT(paramString1);
    String str4 = t.nT(str1);
    y.d("MicroMsg.ChattingEditModeLogic", "copy video: srcFullPath[%s] destFullPath[%s] srcThumbPath[%s] destThumbPath[%s]", new Object[] { str2, str3, paramString1, str4 });
    com.tencent.mm.vfs.e.r(str2, str3);
    com.tencent.mm.vfs.e.r(paramString1, str4);
    com.tencent.mm.modelvideo.u.a(str1, paramInt2, paramString2, null, paramInt1, paramString3, paramInt3);
    com.tencent.mm.modelvideo.u.nZ(str1);
  }
  
  public static void c(Context paramContext, final String paramString, final bi parambi)
  {
    if ((!a(paramContext, paramString, parambi, "video")) || (parambi == null)) {}
    for (;;)
    {
      return;
      if ((parambi == null) || (!parambi.aRR()) || (!com.tencent.mm.modelvideo.u.og(parambi.field_imgPath)))
      {
        paramContext = com.tencent.mm.modelvideo.u.oe(parambi.field_imgPath);
        if ((paramContext != null) && (paramContext.status == 199))
        {
          b(parambi.field_imgPath, paramString, paramContext.eHL, paramContext.eHH, paramContext.SD(), parambi.getType());
          return;
        }
        Object localObject = bn.s(paramContext.SD(), "msg");
        final int i;
        if (localObject == null)
        {
          y.w("MicroMsg.ChattingEditModeLogic", "%s cdntra parse video recv xml failed");
          i = 0;
        }
        while (i == 0)
        {
          e(paramString, parambi);
          return;
          paramContext = (String)((Map)localObject).get(".msg.videomsg.$cdnvideourl");
          if (bk.bl(paramContext))
          {
            i = 0;
          }
          else
          {
            final String str1 = (String)((Map)localObject).get(".msg.videomsg.$aeskey");
            final String str2 = (String)((Map)localObject).get(".msg.videomsg.$md5");
            final String str3 = (String)((Map)localObject).get(".msg.videomsg.$newmd5");
            i = Integer.valueOf((String)((Map)localObject).get(".msg.videomsg.$length")).intValue();
            final int j = bk.getInt((String)((Map)localObject).get(".msg.videomsg.$playlength"), 0);
            final int k = bk.getInt((String)((Map)localObject).get(".msg.videomsg.$cdnthumblength"), 0);
            localObject = new com.tencent.mm.j.f();
            ((com.tencent.mm.j.f)localObject).dlP = new f.a()
            {
              public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.j.c paramAnonymousc, com.tencent.mm.j.d paramAnonymousd, boolean paramAnonymousBoolean)
              {
                if ((paramAnonymousd != null) && (paramAnonymousd.field_exist_whencheck))
                {
                  paramAnonymousd.field_fileId = this.val$url;
                  paramAnonymousd.field_aesKey = str1;
                  paramAnonymousd.field_thumbimgLength = k;
                  paramAnonymousd.field_fileLength = i;
                  paramAnonymousd.field_toUser = paramString;
                  paramAnonymousd.field_filemd5 = str2;
                  paramAnonymousd.field_mp4identifymd5 = str3;
                  y.i("MicroMsg.ChattingEditModeLogic", "support second!! sceneResult: %s", new Object[] { paramAnonymousd });
                  paramAnonymousString = t.nR(q.Gj());
                  com.tencent.mm.modelvideo.o.Sr();
                  paramAnonymousc = t.nT(paramAnonymousString);
                  com.tencent.mm.modelvideo.o.Sr();
                  com.tencent.mm.vfs.e.r(t.nT(parambi.field_imgPath), paramAnonymousc);
                  paramAnonymousc = "<msg><videomsg aeskey=\"" + str1 + "\" cdnthumbaeskey=\"" + str1 + "\" cdnvideourl=\"" + this.val$url + "\" ";
                  paramAnonymousc = paramAnonymousc + "cdnthumburl=\"" + this.val$url + "\" ";
                  paramAnonymousc = paramAnonymousc + "length=\"" + i + "\" ";
                  paramAnonymousc = paramAnonymousc + "cdnthumblength=\"" + k + "\"/></msg>";
                  y.i("MicroMsg.ChattingEditModeLogic", "cdn callback new build cdnInfo:%s", new Object[] { paramAnonymousc });
                  com.tencent.mm.modelvideo.u.d(paramAnonymousString, j, paramString, paramAnonymousc);
                  com.tencent.mm.kernel.g.Dk().a(new com.tencent.mm.modelvideo.h(paramAnonymousString, 0, paramAnonymousd, new k.4.1(this, paramAnonymousString)), 0);
                  return 0;
                }
                k.e(paramString, parambi);
                return 0;
              }
              
              public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
              
              public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
              {
                return new byte[0];
              }
            };
            ((com.tencent.mm.j.f)localObject).field_mediaId = com.tencent.mm.ak.c.a("checkExist", bk.UY(), paramString, parambi.field_msgId);
            ((com.tencent.mm.j.f)localObject).field_fileId = paramContext;
            ((com.tencent.mm.j.f)localObject).field_aesKey = str1;
            ((com.tencent.mm.j.f)localObject).field_filemd5 = str2;
            ((com.tencent.mm.j.f)localObject).field_fileType = com.tencent.mm.j.a.MediaType_VIDEO;
            ((com.tencent.mm.j.f)localObject).field_talker = paramString;
            ((com.tencent.mm.j.f)localObject).field_priority = com.tencent.mm.j.a.dlk;
            ((com.tencent.mm.j.f)localObject).field_svr_signature = "";
            ((com.tencent.mm.j.f)localObject).field_onlycheckexist = true;
            ((com.tencent.mm.j.f)localObject).field_trysafecdn = true;
            if (!com.tencent.mm.ak.f.Nd().c((com.tencent.mm.j.f)localObject))
            {
              y.e("MicroMsg.ChattingEditModeLogic", "check exist fail! download video before retransmit");
              i = 0;
            }
            else
            {
              i = 1;
            }
          }
        }
      }
    }
  }
  
  public static void c(Context paramContext, String paramString, bi parambi, boolean paramBoolean)
  {
    if (!a(paramContext, paramString, parambi, "location")) {
      return;
    }
    paramContext = s(parambi.field_content, parambi.field_isSend, paramBoolean);
    com.tencent.mm.plugin.messenger.a.g.bhI().D(paramString, paramContext, 48);
  }
  
  public static List<String> cCx()
  {
    Object localObject1 = z.My().in(25);
    Object localObject2 = z.My();
    Object localObject3 = new ArrayList();
    Object localObject4 = new StringBuilder();
    com.tencent.mm.ai.e.a((StringBuilder)localObject4);
    com.tencent.mm.ai.e.c((StringBuilder)localObject4);
    com.tencent.mm.ai.e.d((StringBuilder)localObject4);
    com.tencent.mm.ai.e.a((StringBuilder)localObject4, true);
    ((StringBuilder)localObject4).append(" order by ");
    ((StringBuilder)localObject4).append(com.tencent.mm.ai.e.Md());
    localObject4 = ((StringBuilder)localObject4).toString();
    y.i("MicroMsg.BizInfoStorage", "getEnterpriseBizChatLst sql %s", new Object[] { localObject4 });
    localObject2 = ((com.tencent.mm.ai.e)localObject2).rawQuery((String)localObject4, new String[0]);
    if (localObject2 != null)
    {
      if (((Cursor)localObject2).moveToFirst()) {
        do
        {
          ((ArrayList)localObject3).add(((Cursor)localObject2).getString(0));
        } while (((Cursor)localObject2).moveToNext());
      }
      ((Cursor)localObject2).close();
    }
    localObject2 = new HashMap();
    localObject3 = ((List)localObject3).iterator();
    String str;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (String)((Iterator)localObject3).next();
      str = com.tencent.mm.ai.f.kX((String)localObject4).LG();
      if (!bk.bl(str)) {
        ((HashMap)localObject2).put(str, localObject4);
      }
    }
    localObject3 = new LinkedList();
    localObject4 = new LinkedList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      str = (String)((Iterator)localObject1).next();
      if (com.tencent.mm.ai.f.la(str))
      {
        if (com.tencent.mm.ai.f.le(str))
        {
          str = com.tencent.mm.ai.f.kX(str).field_enterpriseFather;
          if ((!((List)localObject4).contains(str)) && (com.tencent.mm.ai.f.lc(str)))
          {
            ((List)localObject4).add(str);
            str = (String)((HashMap)localObject2).get(str);
            if (!bk.bl(str)) {
              ((List)localObject4).add(str);
            }
          }
        }
      }
      else {
        ((List)localObject3).add(str);
      }
    }
    localObject1 = ((HashMap)localObject2).values().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if ((!bk.bl((String)localObject2)) && (!((List)localObject4).contains(localObject2))) {
        ((List)localObject4).add(localObject2);
      }
    }
    ((List)localObject3).addAll((Collection)localObject4);
    y.d("MicroMsg.ChattingEditModeLogic", "get selected accept list, size %d", new Object[] { Integer.valueOf(((List)localObject3).size()) });
    return localObject3;
  }
  
  public static List<String> cCy()
  {
    Object localObject = z.My().in(25);
    LinkedList localLinkedList = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!com.tencent.mm.ai.f.la(str)) {
        localLinkedList.add(str);
      }
    }
    y.d("MicroMsg.ChattingEditModeLogic", "get selected accept list without enterprise, size %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    return localLinkedList;
  }
  
  public static boolean dO(List<bi> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      y.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to brand msg error, selected item empty");
      return true;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bi localbi = (bi)paramList.next();
      if ((localbi.ctA()) || (ao(localbi)) || (localbi.cvn()) || (aq(localbi)) || (ar(localbi)) || (localbi.getType() == -1879048186) || (ay(localbi)) || (as(localbi)) || (ax(localbi)) || (at(localbi)) || (aB(localbi))) {
        return true;
      }
    }
    return false;
  }
  
  public static int dP(List<bi> paramList)
  {
    if (paramList == null)
    {
      y.w("MicroMsg.ChattingEditModeLogic", "get invalid send to friend msg num error, select item empty");
      return 0;
    }
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      bi localbi = (bi)paramList.next();
      if ((!localbi.ctA()) && (!ao(localbi)) && (!localbi.aVM()) && (!aq(localbi)) && (!ar(localbi)) && (!as(localbi))) {
        break label93;
      }
      i += 1;
    }
    label93:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public static boolean dQ(List<bi> paramList)
  {
    if (paramList == null)
    {
      y.w("MicroMsg.ChattingEditModeLogic", "check contain undownload file, select item empty");
      return false;
    }
    Iterator localIterator = paramList.iterator();
    label322:
    label323:
    for (;;)
    {
      bi localbi;
      if (localIterator.hasNext())
      {
        localbi = (bi)localIterator.next();
        if ((localbi.ctB()) || (localbi.cvr()))
        {
          paramList = null;
          if (localbi.field_msgId > 0L) {
            paramList = com.tencent.mm.as.o.OJ().bY(localbi.field_msgId);
          }
          if (((paramList != null) && (paramList.enp > 0L)) || (localbi.field_msgSvrId <= 0L)) {
            break label322;
          }
          paramList = com.tencent.mm.as.o.OJ().bX(localbi.field_msgSvrId);
        }
      }
      for (;;)
      {
        if ((paramList == null) || ((paramList.offset >= paramList.ebK) && (paramList.ebK != 0))) {
          break label323;
        }
        return true;
        if (localbi.aRQ())
        {
          paramList = com.tencent.mm.modelvideo.o.Sr().nQ(localbi.field_imgPath);
          if ((paramList == null) || (paramList.status == 199) || (paramList.status == 199)) {
            break;
          }
          return true;
        }
        if (localbi.cvp())
        {
          if (ap(localbi)) {
            break;
          }
          return true;
        }
        if (localbi.aVK())
        {
          paramList = g.a.M(localbi.field_content, localbi.field_content);
          if (paramList == null) {
            return true;
          }
          switch (paramList.type)
          {
          default: 
            break;
          case 6: 
            paramList = com.tencent.mm.pluginsdk.model.app.ap.avh().VQ(paramList.bFE);
            if (paramList == null) {
              return true;
            }
            if (new com.tencent.mm.vfs.b(paramList.field_fileFullPath).exists()) {
              break;
            }
            return true;
          }
        }
        if (!localbi.aRR()) {
          break;
        }
        paramList = com.tencent.mm.modelvideo.u.oe(localbi.field_imgPath);
        if ((paramList == null) || (paramList.status == 199) || (paramList.status == 199)) {
          break;
        }
        return true;
        return false;
      }
    }
  }
  
  public static boolean dR(List<bi> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bi localbi = (bi)paramList.next();
      if ((localbi.aRQ()) && (j.VM(localbi.field_imgPath))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean dS(List<bi> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((bi)paramList.next()).aRR()) {
        return true;
      }
    }
    return false;
  }
  
  static void e(String paramString, bi parambi)
  {
    au.DS().O(new k.5(parambi, paramString));
  }
  
  public static String s(String paramString, int paramInt, boolean paramBoolean)
  {
    String str = paramString;
    if (paramBoolean)
    {
      str = paramString;
      if (paramString != null)
      {
        str = paramString;
        if (paramInt == 0) {
          str = bd.iJ(paramString);
        }
      }
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k
 * JD-Core Version:    0.7.0.1
 */