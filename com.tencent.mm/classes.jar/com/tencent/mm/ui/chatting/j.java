package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.af.p;
import com.tencent.mm.af.q;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.a.oa;
import com.tencent.mm.g.a.oa.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.modelvideo.y.a;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class j
{
  static void a(Context paramContext, com.tencent.mm.at.e parame, bi parambi, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(30566);
    Object localObject2 = com.tencent.mm.at.o.ahC().q(com.tencent.mm.at.f.c(parame), "", "");
    Object localObject1 = new PString();
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    ((PString)localObject1).value = ((String)localObject2);
    int i = parame.fDP;
    long l1 = com.tencent.mm.at.o.ahC().a((String)localObject2, i, paramInt, (PString)localObject1, localPInt1, localPInt2);
    localObject2 = com.tencent.mm.at.o.ahC().b(Long.valueOf(l1));
    ((com.tencent.mm.at.e)localObject2).lt(1);
    bi localbi = new bi();
    localbi.setType(com.tencent.mm.model.t.oG(paramString1));
    localbi.kj(paramString1);
    localbi.hL(1);
    localbi.setStatus(1);
    localbi.kk(((PString)localObject1).value);
    localbi.hW(localPInt1.value);
    localbi.hX(localPInt2.value);
    localbi.fQ(bf.py(localbi.field_talker));
    if (com.tencent.mm.aj.f.lg(localbi.field_talker)) {
      parambi.jl(com.tencent.mm.aj.a.e.aaQ());
    }
    aw.aaz();
    long l2 = com.tencent.mm.model.c.YC().Z(localbi);
    if (l2 >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ab.i("MicroMsg.ChattingEditModeLogic", "NetSceneUploadMsgImg: local msgId = ".concat(String.valueOf(l2)));
      ((com.tencent.mm.at.e)localObject2).gQ((int)l2);
      com.tencent.mm.at.o.ahC().a(Long.valueOf(l1), (com.tencent.mm.at.e)localObject2);
      localObject1 = new HashMap();
      ((HashMap)localObject1).put(Long.valueOf(l2), parame);
      com.tencent.mm.at.o.ahD().a(parame.fDL, parambi.field_msgId, i, localObject1, 2130838228, new j.3(paramContext, paramString1, parame, paramString2));
      AppMethodBeat.o(30566);
      return;
    }
  }
  
  public static void a(Context paramContext, String paramString, bi parambi)
  {
    AppMethodBeat.i(30564);
    if (!a(paramContext, paramString, parambi, "emoji"))
    {
      AppMethodBeat.o(30564);
      return;
    }
    String str = ap.arZ(parambi.field_content).cqq;
    if ((str == null) || (str.endsWith("-1"))) {}
    for (parambi = parambi.field_imgPath;; parambi = str)
    {
      if (parambi == null)
      {
        ab.w("MicroMsg.ChattingEditModeLogic", "showAcceptEmojiConnector: filePath is null");
        AppMethodBeat.o(30564);
        return;
      }
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().r(paramContext, paramString, parambi);
      AppMethodBeat.o(30564);
      return;
    }
  }
  
  public static void a(Context paramContext, String paramString, bi parambi, boolean paramBoolean)
  {
    AppMethodBeat.i(30569);
    if (!a(paramContext, paramString, parambi, "text"))
    {
      AppMethodBeat.o(30569);
      return;
    }
    String str = v(parambi.field_content, parambi.field_isSend, paramBoolean);
    paramContext = str;
    if (parambi.dyh())
    {
      paramContext = v(parambi.field_transContent, parambi.field_isSend, paramBoolean);
      paramContext = str + "\n\n" + paramContext;
    }
    if ((paramContext == null) || (paramContext.equals("")))
    {
      ab.e("MicroMsg.ChattingEditModeLogic", "Transfer text erro: content null");
      AppMethodBeat.o(30569);
      return;
    }
    com.tencent.mm.plugin.messenger.a.g.bPJ().K(paramString, paramContext, com.tencent.mm.model.t.oF(paramString));
    AppMethodBeat.o(30569);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(30572);
    try
    {
      bi localbi = new bi();
      localbi.setContent(paramString2);
      localbi.hL(paramInt);
      paramInt = paramString2.indexOf("<msg>");
      String str = paramString2;
      if (paramInt > 0)
      {
        str = paramString2;
        if (paramInt < paramString2.length()) {
          str = paramString2.substring(paramInt).trim();
        }
      }
      paramString2 = br.F(str, "msg");
      if ((paramString2 != null) && (paramString2.size() > 0)) {
        localbi.kl(be.aT(paramString2));
      }
      b(paramContext, paramString1, localbi, paramBoolean);
      AppMethodBeat.o(30572);
      return;
    }
    catch (Exception paramContext)
    {
      ab.printErrStackTrace("MicroMsg.ChattingEditModeLogic", paramContext, "", new Object[0]);
      ab.e("MicroMsg.ChattingEditModeLogic", "retransmit sigle app msg error : %s", new Object[] { paramContext.getLocalizedMessage() });
      AppMethodBeat.o(30572);
    }
  }
  
  static boolean a(Context paramContext, String paramString1, bi parambi, String paramString2)
  {
    AppMethodBeat.i(30563);
    if (paramContext == null)
    {
      ab.w("MicroMsg.ChattingEditModeLogic", "send %s fail, context is null", new Object[] { paramString2 });
      AppMethodBeat.o(30563);
      return false;
    }
    if (bo.isNullOrNil(paramString1))
    {
      ab.w("MicroMsg.ChattingEditModeLogic", "send %s fail, username is null", new Object[] { paramString2 });
      AppMethodBeat.o(30563);
      return false;
    }
    if (parambi == null)
    {
      ab.w("MicroMsg.ChattingEditModeLogic", "send %s fail, msg is null", new Object[] { paramString2 });
      AppMethodBeat.o(30563);
      return false;
    }
    AppMethodBeat.o(30563);
    return true;
  }
  
  public static boolean a(boolean paramBoolean, List<bi> paramList, com.tencent.mm.af.t paramt)
  {
    boolean bool = true;
    AppMethodBeat.i(153826);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ab.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to friend msg error, select item empty");
      AppMethodBeat.o(153826);
      return false;
    }
    if ((paramList.size() == 1) && (((paramt != null) && (paramt.Yr())) || (paramBoolean)))
    {
      paramList = (bi)paramList.get(0);
      if ((aH(paramList)) || (paramList.dvW()) || (aw(paramList)) || (ay(paramList)) || (az(paramList)) || (paramList.getType() == -1879048186) || (paramList.getType() == 318767153) || (aG(paramList)) || (aA(paramList)) || (aI(paramList)) || (aF(paramList)) || (aB(paramList)))
      {
        AppMethodBeat.o(153826);
        return false;
      }
      AppMethodBeat.o(153826);
      return true;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bi localbi = (bi)paramList.next();
      if (((paramt != null) && (paramt.Yr())) || (paramBoolean))
      {
        if ((!localbi.dvW()) && (!aw(localbi)) && (!ay(localbi)) && (!az(localbi)) && (localbi.getType() != -1879048186) && (!aG(localbi)) && (!aA(localbi)) && ((!aC(localbi)) || ((paramt != null) && (paramt.Yr()))) && ((!aD(localbi)) || ((paramt != null) && (paramt.Yr()))) && (localbi.getType() != 318767153) && (!aH(localbi)) && (!aI(localbi)) && (!aF(localbi)) && (!aB(localbi))) {
          break label415;
        }
        paramList.remove();
        bool = false;
      }
      else
      {
        if ((!aC(localbi)) && (!aD(localbi))) {
          break label415;
        }
        paramList.remove();
        bool = false;
      }
    }
    label415:
    for (;;)
    {
      break;
      AppMethodBeat.o(153826);
      return bool;
    }
  }
  
  public static boolean aA(bi parambi)
  {
    AppMethodBeat.i(30543);
    if ((parambi.getType() == 436207665) || (parambi.getType() == 469762097))
    {
      AppMethodBeat.o(30543);
      return true;
    }
    AppMethodBeat.o(30543);
    return false;
  }
  
  public static boolean aB(bi parambi)
  {
    AppMethodBeat.i(30544);
    if (parambi == null)
    {
      ab.w("MicroMsg.ChattingEditModeLogic", "isAppbrandForbidForwardMsg, check msg error, msg is null");
      AppMethodBeat.o(30544);
      return true;
    }
    if (parambi.field_isSend == 0) {}
    for (parambi = bf.pv(parambi.field_content);; parambi = parambi.field_content)
    {
      parambi = j.b.mY(parambi);
      if (parambi != null) {
        break;
      }
      ab.w("MicroMsg.ChattingEditModeLogic", "isAppbrandForbidForwardMsg, parse app message content fail");
      AppMethodBeat.o(30544);
      return false;
    }
    if (((parambi.type == 33) && (parambi.fiZ == 3)) || ((parambi.type == 46) && (parambi.fiZ == 3)) || ((parambi.type == 44) && ((parambi.fiZ == 3) || (parambi.fjg != 0) || (!parambi.cH(false)))) || ((parambi.type == 48) && (parambi.fiZ == 3)))
    {
      AppMethodBeat.o(30544);
      return true;
    }
    AppMethodBeat.o(30544);
    return false;
  }
  
  private static boolean aC(bi parambi)
  {
    AppMethodBeat.i(30547);
    if (parambi != null)
    {
      parambi = j.b.mY(parambi.field_content);
      if ((parambi != null) && (parambi.type == 19))
      {
        Object localObject = new oa();
        ((oa)localObject).cEz.type = 0;
        ((oa)localObject).cEz.cEB = parambi.fhc;
        com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
        localObject = ((oa)localObject).cEA.cEK;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.protocal.b.a.c)localObject).fjy.iterator();
          while (((Iterator)localObject).hasNext())
          {
            aca localaca = (aca)((Iterator)localObject).next();
            if (!bo.isNullOrNil(localaca.wTU))
            {
              ab.e("MicroMsg.ChattingEditModeLogic", "record type subDataItem contain tpurl, type:%d", new Object[] { Integer.valueOf(localaca.dataType) });
              AppMethodBeat.o(30547);
              return true;
            }
          }
        }
        if ((parambi.fhc != null) && (parambi.fhc.contains("<recordxml>")))
        {
          AppMethodBeat.o(30547);
          return true;
        }
        AppMethodBeat.o(30547);
        return false;
      }
    }
    AppMethodBeat.o(30547);
    return false;
  }
  
  private static boolean aD(bi parambi)
  {
    AppMethodBeat.i(30548);
    if (parambi != null)
    {
      parambi = j.b.mY(parambi.field_content);
      if ((parambi != null) && (parambi.type == 24))
      {
        AppMethodBeat.o(30548);
        return true;
      }
    }
    AppMethodBeat.o(30548);
    return false;
  }
  
  public static boolean aE(bi parambi)
  {
    AppMethodBeat.i(30549);
    if (parambi != null)
    {
      parambi = j.b.mY(parambi.field_content);
      if (parambi == null)
      {
        AppMethodBeat.o(30549);
        return false;
      }
      if ((parambi.type == 6) || (parambi.type == 5) || (parambi.type == 19))
      {
        AppMethodBeat.o(30549);
        return true;
      }
    }
    AppMethodBeat.o(30549);
    return false;
  }
  
  public static boolean aF(bi parambi)
  {
    AppMethodBeat.i(30550);
    if ((parambi == null) || (!parambi.dvV()))
    {
      AppMethodBeat.o(30550);
      return false;
    }
    boolean bool = com.tencent.mm.af.l.c(parambi.field_msgId, parambi.field_content);
    AppMethodBeat.o(30550);
    return bool;
  }
  
  static boolean aG(bi parambi)
  {
    AppMethodBeat.i(30551);
    if (parambi != null)
    {
      parambi = j.b.mY(parambi.field_content);
      if ((parambi != null) && (parambi.type == 16))
      {
        AppMethodBeat.o(30551);
        return true;
      }
      if ((parambi != null) && (parambi.type == 34))
      {
        AppMethodBeat.o(30551);
        return true;
      }
    }
    AppMethodBeat.o(30551);
    return false;
  }
  
  static boolean aH(bi parambi)
  {
    AppMethodBeat.i(30552);
    if (!parambi.dxR())
    {
      AppMethodBeat.o(30552);
      return false;
    }
    aw.aaz();
    parambi = com.tencent.mm.model.c.YC().Ty(parambi.field_content);
    if ((parambi == null) || (bo.isNullOrNil(parambi.tac)))
    {
      AppMethodBeat.o(30552);
      return true;
    }
    if (com.tencent.mm.model.t.nU(parambi.tac))
    {
      AppMethodBeat.o(30552);
      return false;
    }
    AppMethodBeat.o(30552);
    return true;
  }
  
  private static boolean aI(bi parambi)
  {
    AppMethodBeat.i(30553);
    if ((parambi != null) && (parambi.bCn()))
    {
      parambi = j.b.mY(parambi.field_content);
      if ((parambi != null) && (parambi.type == 6) && ((parambi.fgA != 0) || (parambi.fgw > 26214400)))
      {
        AppMethodBeat.o(30553);
        return true;
      }
    }
    AppMethodBeat.o(30553);
    return false;
  }
  
  public static boolean aJ(bi parambi)
  {
    AppMethodBeat.i(30554);
    if ((parambi != null) && (parambi.bCn()))
    {
      parambi = j.b.mY(parambi.field_content);
      if ((parambi != null) && (parambi.type == 6))
      {
        AppMethodBeat.o(30554);
        return true;
      }
    }
    AppMethodBeat.o(30554);
    return false;
  }
  
  public static boolean aw(bi parambi)
  {
    AppMethodBeat.i(30539);
    if (parambi == null)
    {
      ab.w("MicroMsg.ChattingEditModeLogic", "check is store emoji error, msg is null");
      AppMethodBeat.o(30539);
      return true;
    }
    if (parambi.dxT())
    {
      ap localap = new ap(parambi.field_content);
      parambi = j.b.ab(parambi.field_content, parambi.field_reserved);
      if (parambi != null) {
        break label210;
      }
      parambi = new j.b();
      parambi.fgy = localap.cqq;
    }
    label210:
    for (;;)
    {
      for (parambi = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kt(parambi.fgy); (parambi != null) && ((parambi.field_catalog == EmojiInfo.yPm) || ((!bo.isNullOrNil(parambi.field_groupId)) && (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Ky(parambi.field_groupId)))); parambi = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kt(parambi.field_imgPath))
      {
        AppMethodBeat.o(30539);
        return false;
      }
      if ((parambi != null) && (parambi.dzs()))
      {
        AppMethodBeat.o(30539);
        return true;
      }
      AppMethodBeat.o(30539);
      return false;
    }
  }
  
  public static boolean ax(bi parambi)
  {
    AppMethodBeat.i(30540);
    if (parambi.dxT())
    {
      ap localap = new ap(parambi.field_content);
      parambi = j.b.ab(parambi.field_content, parambi.field_reserved);
      if (parambi != null) {
        break label98;
      }
      parambi = new j.b();
      parambi.fgy = localap.cqq;
    }
    label98:
    for (;;)
    {
      if (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kt(parambi.fgy) == null)
      {
        AppMethodBeat.o(30540);
        return false;
      }
      AppMethodBeat.o(30540);
      return true;
    }
  }
  
  public static boolean ay(bi parambi)
  {
    AppMethodBeat.i(30541);
    if (parambi == null)
    {
      ab.w("MicroMsg.ChattingEditModeLogic", "check is game msg error, msg is null");
      AppMethodBeat.o(30541);
      return true;
    }
    if (parambi.field_isSend == 0) {}
    for (parambi = bf.pv(parambi.field_content);; parambi = parambi.field_content)
    {
      parambi = j.b.mY(parambi);
      if (parambi != null) {
        break;
      }
      ab.w("MicroMsg.ChattingEditModeLogic", "parse app message content fail");
      AppMethodBeat.o(30541);
      return false;
    }
    parambi = com.tencent.mm.pluginsdk.model.app.g.ca(parambi.appId, false);
    if ((parambi != null) && (parambi.vY()))
    {
      AppMethodBeat.o(30541);
      return true;
    }
    AppMethodBeat.o(30541);
    return false;
  }
  
  public static boolean az(bi parambi)
  {
    AppMethodBeat.i(30542);
    if (parambi.getType() == 419430449)
    {
      AppMethodBeat.o(30542);
      return true;
    }
    AppMethodBeat.o(30542);
    return false;
  }
  
  public static void b(Context paramContext, String paramString, bi parambi)
  {
    AppMethodBeat.i(30565);
    if (!a(paramContext, paramString, parambi, "image"))
    {
      AppMethodBeat.o(30565);
      return;
    }
    Object localObject1 = null;
    if (parambi.field_msgId > 0L) {
      localObject1 = com.tencent.mm.at.o.ahC().gT(parambi.field_msgId);
    }
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((com.tencent.mm.at.e)localObject1).fDL > 0L) {}
    }
    else
    {
      localObject2 = localObject1;
      if (parambi.field_msgSvrId > 0L) {
        localObject2 = com.tencent.mm.at.o.ahC().gS(parambi.field_msgSvrId);
      }
    }
    if (localObject2 == null)
    {
      AppMethodBeat.o(30565);
      return;
    }
    int j = 0;
    int i = j;
    if (((com.tencent.mm.at.e)localObject2).ahh())
    {
      i = j;
      if (!com.tencent.mm.at.f.a((com.tencent.mm.at.e)localObject2).fDM.startsWith("SERVERID://")) {
        i = 1;
      }
    }
    localObject1 = com.tencent.mm.at.o.ahC().q(com.tencent.mm.at.f.c((com.tencent.mm.at.e)localObject2), "", "");
    String str1 = com.tencent.mm.at.o.ahC().q(((com.tencent.mm.at.e)localObject2).fDO, "th_", "");
    if ((((com.tencent.mm.at.e)localObject2).offset < ((com.tencent.mm.at.e)localObject2).fsd) || (((com.tencent.mm.at.e)localObject2).fsd == 0))
    {
      String str2 = r.Zn();
      String str3 = ((com.tencent.mm.at.e)localObject2).fDX;
      Object localObject3 = br.F(((com.tencent.mm.at.e)localObject2).fDX, "msg");
      if (localObject3 == null)
      {
        ab.e("MicroMsg.ChattingEditModeLogic", "parse cdnInfo failed. [%s]", new Object[] { ((com.tencent.mm.at.e)localObject2).fDX });
        i = 0;
      }
      for (;;)
      {
        if (i == 0) {
          a(paramContext, (com.tencent.mm.at.e)localObject2, parambi, 4, paramString, str1);
        }
        AppMethodBeat.o(30565);
        return;
        j = ((com.tencent.mm.at.e)localObject2).fDP;
        if (j != 1) {
          localObject1 = (String)((Map)localObject3).get(".msg.img.$cdnmidimgurl");
        }
        for (i = 2;; i = 1)
        {
          ab.d("MicroMsg.ChattingEditModeLogic", "cdntra read xml  comptype:%d url:[%s]", new Object[] { Integer.valueOf(j), localObject1 });
          if (!bo.isNullOrNil((String)localObject1)) {
            break label367;
          }
          ab.e("MicroMsg.ChattingEditModeLogic", "cdntra get cdnUrlfailed.");
          i = 0;
          break;
          localObject1 = (String)((Map)localObject3).get(".msg.img.$cdnbigimgurl");
        }
        label367:
        String str4 = (String)((Map)localObject3).get(".msg.img.$aeskey");
        if (bo.isNullOrNil(str4))
        {
          ab.e("MicroMsg.ChattingEditModeLogic", "cdntra get aes key failed.");
          i = 0;
        }
        else if (bo.isNullOrNil(com.tencent.mm.al.c.a("downimg", ((com.tencent.mm.at.e)localObject2).fDT, parambi.field_talker, parambi.field_msgId)))
        {
          ab.w("MicroMsg.ChattingEditModeLogic", "cdntra genClientId failed not use cdn imgLocalId:%d", new Object[] { Long.valueOf(parambi.field_msgSvrId) });
          i = 0;
        }
        else
        {
          localObject3 = (String)((Map)localObject3).get(".msg.img.$md5");
          com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
          localg.edp = new j.1(parambi, i, paramString, str2, str3, (String)localObject3, j, (com.tencent.mm.at.e)localObject2, paramContext);
          localg.field_mediaId = com.tencent.mm.al.c.a("checkExist", bo.aoy(), paramString, parambi.field_msgId);
          localg.field_fileId = ((String)localObject1);
          localg.field_aesKey = str4;
          localg.field_filemd5 = ((String)localObject3);
          localg.field_fileType = i;
          localg.field_talker = paramString;
          localg.field_priority = com.tencent.mm.i.a.ecF;
          localg.field_svr_signature = "";
          localg.field_onlycheckexist = true;
          localg.field_trysafecdn = true;
          if (!com.tencent.mm.al.f.afO().e(localg))
          {
            ab.e("MicroMsg.ChattingEditModeLogic", "check exist fail! download img before retransmit");
            i = 0;
          }
          else
          {
            i = 1;
          }
        }
      }
    }
    if (!bo.isNullOrNil((String)localObject1)) {
      com.tencent.mm.plugin.messenger.a.g.bPJ().a(paramContext, paramString, (String)localObject1, i, ((com.tencent.mm.at.e)localObject2).fDX, str1);
    }
    AppMethodBeat.o(30565);
  }
  
  public static void b(Context paramContext, String paramString, bi parambi, boolean paramBoolean)
  {
    AppMethodBeat.i(30570);
    if (!a(paramContext, paramString, parambi, "appmsg"))
    {
      AppMethodBeat.o(30570);
      return;
    }
    if (paramContext == null)
    {
      ab.w("MicroMsg.ChattingEditModeLogic", "getReaderAppMsgContent: context is null");
      AppMethodBeat.o(30570);
      return;
    }
    if (parambi == null)
    {
      ab.w("MicroMsg.ChattingEditModeLogic", "getReaderAppMsgContent: msg is null");
      AppMethodBeat.o(30570);
      return;
    }
    aw.aaz();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      AppMethodBeat.o(30570);
      return;
    }
    paramContext = com.tencent.mm.at.o.ahC().c(parambi.field_imgPath, false, false);
    if ((!ah.isNullOrNil(paramContext)) && (!paramContext.endsWith("hd")) && (com.tencent.mm.vfs.e.cN(paramContext + "hd"))) {
      paramContext = paramContext + "hd";
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject1 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.biz.a.a.class)).b(parambi.field_msgId, parambi.field_content);
        localObject2 = ((p)localObject1).fjy;
        if ((localObject2 == null) || (((List)localObject2).size() <= 0))
        {
          if ((parambi == null) || ((!parambi.bCn()) && (!parambi.dvV()))) {
            break label749;
          }
          localObject1 = v.oQ(parambi.field_msgSvrId);
          localObject2 = v.aae().z((String)localObject1, true);
          ((v.b)localObject2).i("prePublishId", "msg_" + parambi.field_msgSvrId);
          ((v.b)localObject2).i("preUsername", com.tencent.mm.ui.chatting.viewitems.c.a(parambi, paramBoolean, false));
          ((v.b)localObject2).i("preChatName", parambi.field_talker);
          ((v.b)localObject2).i("preMsgIndex", Integer.valueOf(0));
          ((v.b)localObject2).i("sendAppMsgScene", Integer.valueOf(1));
          ((com.tencent.mm.plugin.sns.b.i)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.sns.b.i.class)).a("adExtStr", (v.b)localObject2, parambi);
          com.tencent.mm.plugin.messenger.a.g.bPJ().a(paramString, bo.readFromFile(paramContext), bo.apU(parambi.field_content), (String)localObject1);
          AppMethodBeat.o(30570);
          return;
        }
      }
      catch (Exception paramContext)
      {
        ab.printErrStackTrace("MicroMsg.ChattingEditModeLogic", paramContext, "", new Object[0]);
        ab.e("MicroMsg.ChattingEditModeLogic", "send app msg error : %s", new Object[] { paramContext.getLocalizedMessage() });
        AppMethodBeat.o(30570);
        return;
      }
      parambi = ((List)localObject2).iterator();
      while (parambi.hasNext())
      {
        Object localObject3 = (q)parambi.next();
        localObject2 = new j.b();
        if (com.tencent.mm.af.l.na(((q)localObject3).fjO))
        {
          l.b(paramString, l.a(paramString, (q)localObject3), ((q)localObject3).fjT);
        }
        else
        {
          ((j.b)localObject2).title = ((q)localObject3).title;
          ((j.b)localObject2).description = ((q)localObject3).fjL;
          ((j.b)localObject2).action = "view";
          ((j.b)localObject2).type = 5;
          ((j.b)localObject2).url = ((q)localObject3).url;
          ((j.b)localObject2).cGN = ((p)localObject1).cGN;
          ((j.b)localObject2).cGO = ((p)localObject1).cGO;
          ((j.b)localObject2).dGR = ((p)localObject1).dGR;
          ((j.b)localObject2).thumburl = com.tencent.mm.af.l.a((q)localObject3);
          com.tencent.mm.af.e locale = new com.tencent.mm.af.e();
          locale.fgh = ((q)localObject3).type;
          if (((q)localObject3).type == 5)
          {
            locale.fgl = ((q)localObject3).fgl;
            locale.fgi = ((int)((q)localObject3).time);
            locale.duration = ((q)localObject3).fjN;
            locale.videoWidth = ((q)localObject3).videoWidth;
            locale.videoHeight = ((q)localObject3).videoHeight;
          }
          ((j.b)localObject2).a(locale);
          if ((bo.isNullOrNil(((j.b)localObject2).thumburl)) && (!bo.isNullOrNil(((j.b)localObject2).cGN)))
          {
            localObject3 = com.tencent.mm.ah.o.adg().rj(((j.b)localObject2).cGN);
            if (localObject3 != null) {
              ((j.b)localObject2).thumburl = ((com.tencent.mm.ah.h)localObject3).acX();
            }
          }
          localObject2 = j.b.a((j.b)localObject2, null, null);
          com.tencent.mm.plugin.messenger.a.g.bPJ().a(paramString, bo.readFromFile(paramContext), bo.apU((String)localObject2), null);
        }
      }
      AppMethodBeat.o(30570);
      return;
      label749:
      Object localObject1 = null;
    }
  }
  
  public static void b(EmojiInfo paramEmojiInfo, String paramString)
  {
    AppMethodBeat.i(30573);
    WXMediaMessage localWXMediaMessage = new WXMediaMessage();
    Object localObject = new StringBuilder();
    aw.aaz();
    localObject = com.tencent.mm.model.c.YP() + paramEmojiInfo.Al();
    if (com.tencent.mm.vfs.e.avI((String)localObject + "_thumb") > 0L)
    {
      int i = (int)com.tencent.mm.vfs.e.avI((String)localObject + "_thumb");
      localWXMediaMessage.thumbData = com.tencent.mm.vfs.e.i((String)localObject + "_thumb", 0, i);
    }
    for (;;)
    {
      localWXMediaMessage.mediaObject = new WXEmojiObject((String)localObject);
      com.tencent.mm.pluginsdk.model.app.l.a(localWXMediaMessage, paramEmojiInfo.field_app_id, null, paramString, 1, paramEmojiInfo.Al());
      AppMethodBeat.o(30573);
      return;
      try
      {
        InputStream localInputStream = com.tencent.mm.vfs.e.openRead((String)localObject);
        localWXMediaMessage.setThumbImage(BackwardSupportUtil.b.b(localInputStream, 1.0F));
        localInputStream.close();
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.ChattingEditModeLogic", localException, "", new Object[0]);
        ab.e("MicroMsg.ChattingEditModeLogic", "sendAppMsgEmoji Fail cause there is no thumb");
      }
    }
  }
  
  public static void c(Context paramContext, String paramString, bi parambi)
  {
    AppMethodBeat.i(30568);
    if ((!a(paramContext, paramString, parambi, "video")) || (parambi == null))
    {
      AppMethodBeat.o(30568);
      return;
    }
    if ((parambi != null) && (parambi.byk()) && (u.vt(parambi.field_imgPath)))
    {
      AppMethodBeat.o(30568);
      return;
    }
    paramContext = u.vr(parambi.field_imgPath);
    if ((paramContext != null) && (paramContext.status == 199))
    {
      c(parambi.field_imgPath, paramString, paramContext.fXB, paramContext.fXx, paramContext.alP(), parambi.getType());
      AppMethodBeat.o(30568);
      return;
    }
    Object localObject = br.F(paramContext.alP(), "msg");
    int i;
    if (localObject == null)
    {
      ab.w("MicroMsg.ChattingEditModeLogic", "%s cdntra parse video recv xml failed");
      i = 0;
    }
    for (;;)
    {
      if (i == 0) {
        e(paramString, parambi);
      }
      AppMethodBeat.o(30568);
      return;
      paramContext = (String)((Map)localObject).get(".msg.videomsg.$cdnvideourl");
      if (bo.isNullOrNil(paramContext))
      {
        i = 0;
      }
      else
      {
        String str1 = (String)((Map)localObject).get(".msg.videomsg.$aeskey");
        String str2 = (String)((Map)localObject).get(".msg.videomsg.$md5");
        String str3 = (String)((Map)localObject).get(".msg.videomsg.$newmd5");
        i = Integer.valueOf((String)((Map)localObject).get(".msg.videomsg.$length")).intValue();
        int j = bo.getInt((String)((Map)localObject).get(".msg.videomsg.$playlength"), 0);
        int k = bo.getInt((String)((Map)localObject).get(".msg.videomsg.$cdnthumblength"), 0);
        localObject = new com.tencent.mm.i.g();
        ((com.tencent.mm.i.g)localObject).edp = new j.4(paramContext, str1, k, i, paramString, str2, str3, parambi, j);
        ((com.tencent.mm.i.g)localObject).field_mediaId = com.tencent.mm.al.c.a("checkExist", bo.aoy(), paramString, parambi.field_msgId);
        ((com.tencent.mm.i.g)localObject).field_fileId = paramContext;
        ((com.tencent.mm.i.g)localObject).field_aesKey = str1;
        ((com.tencent.mm.i.g)localObject).field_filemd5 = str2;
        ((com.tencent.mm.i.g)localObject).field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
        ((com.tencent.mm.i.g)localObject).field_talker = paramString;
        ((com.tencent.mm.i.g)localObject).field_priority = com.tencent.mm.i.a.ecF;
        ((com.tencent.mm.i.g)localObject).field_svr_signature = "";
        ((com.tencent.mm.i.g)localObject).field_onlycheckexist = true;
        ((com.tencent.mm.i.g)localObject).field_trysafecdn = true;
        if (!com.tencent.mm.al.f.afO().e((com.tencent.mm.i.g)localObject))
        {
          ab.e("MicroMsg.ChattingEditModeLogic", "check exist fail! download video before retransmit");
          i = 0;
        }
        else
        {
          i = 1;
        }
      }
    }
  }
  
  public static void c(Context paramContext, String paramString, bi parambi, boolean paramBoolean)
  {
    AppMethodBeat.i(30571);
    if (!a(paramContext, paramString, parambi, "location"))
    {
      AppMethodBeat.o(30571);
      return;
    }
    paramContext = v(parambi.field_content, parambi.field_isSend, paramBoolean);
    com.tencent.mm.plugin.messenger.a.g.bPJ().K(paramString, paramContext, 48);
    AppMethodBeat.o(30571);
  }
  
  public static void c(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3)
  {
    AppMethodBeat.i(30562);
    ab.d("MicroMsg.ChattingEditModeLogic", "copy video fileName %s userName %s export %d videoLength %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    String str1 = com.tencent.mm.modelvideo.t.ve(r.Zn());
    com.tencent.mm.modelvideo.o.alE();
    String str2 = com.tencent.mm.modelvideo.t.vf(paramString1);
    String str3 = com.tencent.mm.modelvideo.t.vf(str1);
    paramString1 = com.tencent.mm.modelvideo.t.vg(paramString1);
    String str4 = com.tencent.mm.modelvideo.t.vg(str1);
    ab.d("MicroMsg.ChattingEditModeLogic", "copy video: srcFullPath[%s] destFullPath[%s] srcThumbPath[%s] destThumbPath[%s]", new Object[] { str2, str3, paramString1, str4 });
    com.tencent.mm.vfs.e.C(str2, str3);
    com.tencent.mm.vfs.e.C(paramString1, str4);
    u.a(str1, paramInt2, paramString2, null, paramInt1, paramString3, paramInt3);
    u.vm(str1);
    AppMethodBeat.o(30562);
  }
  
  public static List<String> dGk()
  {
    AppMethodBeat.i(30560);
    Object localObject1 = z.afi().la(25);
    Object localObject2 = z.afi();
    Object localObject3 = new ArrayList();
    Object localObject4 = new StringBuilder();
    com.tencent.mm.aj.e.a((StringBuilder)localObject4);
    com.tencent.mm.aj.e.c((StringBuilder)localObject4);
    com.tencent.mm.aj.e.d((StringBuilder)localObject4);
    com.tencent.mm.aj.e.a((StringBuilder)localObject4, true);
    ((StringBuilder)localObject4).append(" order by ");
    ((StringBuilder)localObject4).append(com.tencent.mm.aj.e.aeK());
    localObject4 = ((StringBuilder)localObject4).toString();
    ab.i("MicroMsg.BizInfoStorage", "getEnterpriseBizChatLst sql %s", new Object[] { localObject4 });
    localObject2 = ((com.tencent.mm.aj.e)localObject2).rawQuery((String)localObject4, new String[0]);
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
      str = com.tencent.mm.aj.f.rS((String)localObject4).aeo();
      if (!bo.isNullOrNil(str)) {
        ((HashMap)localObject2).put(str, localObject4);
      }
    }
    localObject3 = new LinkedList();
    localObject4 = new LinkedList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      str = (String)((Iterator)localObject1).next();
      if (com.tencent.mm.aj.f.rV(str))
      {
        if (com.tencent.mm.aj.f.rZ(str))
        {
          str = com.tencent.mm.aj.f.rS(str).field_enterpriseFather;
          if ((!((List)localObject4).contains(str)) && (com.tencent.mm.aj.f.rX(str)))
          {
            ((List)localObject4).add(str);
            str = (String)((HashMap)localObject2).get(str);
            if (!bo.isNullOrNil(str)) {
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
      if ((!bo.isNullOrNil((String)localObject2)) && (!((List)localObject4).contains(localObject2))) {
        ((List)localObject4).add(localObject2);
      }
    }
    ((List)localObject3).addAll((Collection)localObject4);
    ab.d("MicroMsg.ChattingEditModeLogic", "get selected accept list, size %d", new Object[] { Integer.valueOf(((List)localObject3).size()) });
    AppMethodBeat.o(30560);
    return localObject3;
  }
  
  public static List<String> dGl()
  {
    AppMethodBeat.i(30561);
    Object localObject = z.afi().la(25);
    LinkedList localLinkedList = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!com.tencent.mm.aj.f.rV(str)) {
        localLinkedList.add(str);
      }
    }
    ab.d("MicroMsg.ChattingEditModeLogic", "get selected accept list without enterprise, size %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    AppMethodBeat.o(30561);
    return localLinkedList;
  }
  
  static void e(final String paramString, bi parambi)
  {
    AppMethodBeat.i(30567);
    aw.RO().ac(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30538);
        com.tencent.mm.modelvideo.o.alJ().a(this.fkH.field_imgPath, new j.5.1(this));
        AppMethodBeat.o(30538);
      }
    });
    AppMethodBeat.o(30567);
  }
  
  public static boolean eX(List<bi> paramList)
  {
    AppMethodBeat.i(30545);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ab.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to brand msg error, selected item empty");
      AppMethodBeat.o(30545);
      return true;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bi localbi = (bi)paramList.next();
      if ((localbi.dvW()) || (aw(localbi)) || (localbi.dxR()) || (ay(localbi)) || (az(localbi)) || (localbi.getType() == -1879048186) || (aG(localbi)) || (aA(localbi)) || (aF(localbi)) || (aB(localbi)) || (aJ(localbi)))
      {
        AppMethodBeat.o(30545);
        return true;
      }
    }
    AppMethodBeat.o(30545);
    return false;
  }
  
  public static int eY(List<bi> paramList)
  {
    AppMethodBeat.i(30555);
    if (paramList == null)
    {
      ab.w("MicroMsg.ChattingEditModeLogic", "get invalid send to friend msg num error, select item empty");
      AppMethodBeat.o(30555);
      return 0;
    }
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      bi localbi = (bi)paramList.next();
      if ((!localbi.dvW()) && (!aw(localbi)) && (!localbi.bCp()) && (!ay(localbi)) && (!az(localbi)) && (!aA(localbi))) {
        break label111;
      }
      i += 1;
    }
    label111:
    for (;;)
    {
      break;
      AppMethodBeat.o(30555);
      return i;
    }
  }
  
  public static boolean eZ(List<bi> paramList)
  {
    AppMethodBeat.i(30556);
    if (paramList == null)
    {
      ab.w("MicroMsg.ChattingEditModeLogic", "check contain undownload file, select item empty");
      AppMethodBeat.o(30556);
      return false;
    }
    Iterator localIterator = paramList.iterator();
    label382:
    label383:
    for (;;)
    {
      bi localbi;
      if (localIterator.hasNext())
      {
        localbi = (bi)localIterator.next();
        if ((localbi.dvX()) || (localbi.dxV()))
        {
          paramList = null;
          if (localbi.field_msgId > 0L) {
            paramList = com.tencent.mm.at.o.ahC().gT(localbi.field_msgId);
          }
          if (((paramList != null) && (paramList.fDL > 0L)) || (localbi.field_msgSvrId <= 0L)) {
            break label382;
          }
          paramList = com.tencent.mm.at.o.ahC().gS(localbi.field_msgSvrId);
        }
      }
      for (;;)
      {
        if ((paramList == null) || ((paramList.offset >= paramList.fsd) && (paramList.fsd != 0))) {
          break label383;
        }
        AppMethodBeat.o(30556);
        return true;
        if (localbi.byj())
        {
          paramList = com.tencent.mm.modelvideo.o.alE().vd(localbi.field_imgPath);
          if ((paramList == null) || (paramList.status == 199) || (paramList.status == 199)) {
            break;
          }
          AppMethodBeat.o(30556);
          return true;
        }
        if (localbi.dxT())
        {
          if (ax(localbi)) {
            break;
          }
          AppMethodBeat.o(30556);
          return true;
        }
        if (localbi.bCn())
        {
          paramList = j.b.ab(localbi.field_content, localbi.field_content);
          if (paramList == null)
          {
            AppMethodBeat.o(30556);
            return true;
          }
          switch (paramList.type)
          {
          default: 
            break;
          case 6: 
            paramList = com.tencent.mm.pluginsdk.model.app.al.aUJ().alo(paramList.cmN);
            if (paramList == null)
            {
              AppMethodBeat.o(30556);
              return true;
            }
            if (new com.tencent.mm.vfs.b(paramList.field_fileFullPath).exists()) {
              break;
            }
            AppMethodBeat.o(30556);
            return true;
          }
        }
        if (!localbi.byk()) {
          break;
        }
        paramList = u.vr(localbi.field_imgPath);
        if ((paramList == null) || (paramList.status == 199) || (paramList.status == 199)) {
          break;
        }
        AppMethodBeat.o(30556);
        return true;
        AppMethodBeat.o(30556);
        return false;
      }
    }
  }
  
  public static boolean fa(List<bi> paramList)
  {
    AppMethodBeat.i(30557);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(30557);
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bi localbi = (bi)paramList.next();
      if ((localbi.byj()) && (com.tencent.mm.pluginsdk.model.j.alk(localbi.field_imgPath)))
      {
        AppMethodBeat.o(30557);
        return true;
      }
    }
    AppMethodBeat.o(30557);
    return false;
  }
  
  public static boolean fb(List<bi> paramList)
  {
    AppMethodBeat.i(30558);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(30558);
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((bi)paramList.next()).byk())
      {
        AppMethodBeat.o(30558);
        return true;
      }
    }
    AppMethodBeat.o(30558);
    return false;
  }
  
  public static String v(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(30559);
    String str = paramString;
    if (paramBoolean)
    {
      str = paramString;
      if (paramString != null)
      {
        str = paramString;
        if (paramInt == 0) {
          str = bf.pv(paramString);
        }
      }
    }
    AppMethodBeat.o(30559);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.j
 * JD-Core Version:    0.7.0.1
 */