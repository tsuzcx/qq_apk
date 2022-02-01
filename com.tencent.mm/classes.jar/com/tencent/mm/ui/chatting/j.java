package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ai.v;
import com.tencent.mm.ai.z;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.aw.d.a;
import com.tencent.mm.aw.m.a;
import com.tencent.mm.g.a.pn;
import com.tencent.mm.g.a.pn.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.i.g.a;
import com.tencent.mm.l.a.a;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.w;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelvideo.h.a;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.y.a;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.dht;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bl.a;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
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
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.Assert;

public final class j
{
  static void a(Context paramContext, final com.tencent.mm.aw.e parame, bl parambl, int paramInt, final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(34428);
    Object localObject2 = com.tencent.mm.aw.o.ayF().p(com.tencent.mm.aw.f.c(parame), "", "");
    Object localObject1 = new PString();
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    ((PString)localObject1).value = ((String)localObject2);
    int i = parame.hgm;
    long l1 = com.tencent.mm.aw.o.ayF().a((String)localObject2, i, paramInt, (PString)localObject1, localPInt1, localPInt2);
    localObject2 = com.tencent.mm.aw.o.ayF().b(Long.valueOf(l1));
    ((com.tencent.mm.aw.e)localObject2).ob(1);
    bl localbl = new bl();
    localbl.setType(w.tr(paramString1));
    localbl.nY(paramString1);
    localbl.jV(1);
    localbl.setStatus(1);
    localbl.nZ(((PString)localObject1).value);
    localbl.kh(localPInt1.value);
    localbl.ki(localPInt2.value);
    localbl.kY(bi.uj(localbl.field_talker));
    if (com.tencent.mm.am.f.pc(localbl.field_talker)) {
      parambl.mZ(com.tencent.mm.am.a.e.SM());
    }
    az.arV();
    long l2 = com.tencent.mm.model.c.apO().an(localbl);
    if (l2 >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ad.i("MicroMsg.ChattingEditModeLogic", "NetSceneUploadMsgImg: local msgId = ".concat(String.valueOf(l2)));
      ((com.tencent.mm.aw.e)localObject2).mq((int)l2);
      com.tencent.mm.aw.o.ayF().a(Long.valueOf(l1), (com.tencent.mm.aw.e)localObject2);
      localObject1 = new HashMap();
      ((HashMap)localObject1).put(Long.valueOf(l2), parame);
      com.tencent.mm.aw.o.ayG().a(parame.deI, parambl.field_msgId, i, localObject1, 2131231564, new d.a()
      {
        public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject) {}
        
        public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, n paramAnonymousn) {}
        
        public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(34392);
          if ((paramAnonymousInt3 == 0) && (paramAnonymousInt4 == 0)) {}
          for (paramAnonymousInt2 = 1; (paramAnonymousObject instanceof HashMap); paramAnonymousInt2 = 0)
          {
            paramAnonymousObject = (HashMap)paramAnonymousObject;
            if (paramAnonymousObject == null) {
              break;
            }
            paramAnonymousObject = paramAnonymousObject.entrySet().iterator();
            while (paramAnonymousObject.hasNext())
            {
              paramAnonymousn = (Map.Entry)paramAnonymousObject.next();
              paramAnonymousString = (Long)paramAnonymousn.getKey();
              paramAnonymousn = (com.tencent.mm.aw.e)paramAnonymousn.getValue();
              paramAnonymousn = com.tencent.mm.aw.o.ayF().p(com.tencent.mm.aw.f.c(paramAnonymousn), "", "");
              if (paramAnonymousInt2 != 0)
              {
                az.arV();
                com.tencent.mm.model.c.apO().rn(paramAnonymousString.longValue());
                com.tencent.mm.plugin.messenger.a.j.cOB().a(this.val$context, paramString1, paramAnonymousn, paramAnonymousInt1, parame.hgv, paramString2, paramAnonymousLong2, null);
              }
            }
          }
          AppMethodBeat.o(34392);
        }
      });
      AppMethodBeat.o(34428);
      return;
    }
  }
  
  public static void a(Context paramContext, String paramString, bl parambl)
  {
    AppMethodBeat.i(34426);
    if (!a(paramContext, paramString, parambl, "emoji"))
    {
      AppMethodBeat.o(34426);
      return;
    }
    String str = ar.aIF(parambl.field_content).md5;
    if ((str == null) || (str.endsWith("-1"))) {}
    for (parambl = parambl.field_imgPath;; parambl = str)
    {
      if (parambl == null)
      {
        ad.w("MicroMsg.ChattingEditModeLogic", "showAcceptEmojiConnector: filePath is null");
        AppMethodBeat.o(34426);
        return;
      }
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().v(paramContext, paramString, parambl);
      AppMethodBeat.o(34426);
      return;
    }
  }
  
  public static void a(Context paramContext, String paramString, bl parambl, boolean paramBoolean)
  {
    AppMethodBeat.i(34431);
    if (!a(paramContext, paramString, parambl, "text"))
    {
      AppMethodBeat.o(34431);
      return;
    }
    String str = x(parambl.field_content, parambl.field_isSend, paramBoolean);
    paramContext = str;
    if (parambl.eMt())
    {
      paramContext = x(parambl.field_transContent, parambl.field_isSend, paramBoolean);
      paramContext = str + "\n\n" + paramContext;
    }
    if ((paramContext == null) || (paramContext.equals("")))
    {
      ad.e("MicroMsg.ChattingEditModeLogic", "Transfer text erro: content null");
      AppMethodBeat.o(34431);
      return;
    }
    com.tencent.mm.plugin.messenger.a.j.cOB().W(paramString, paramContext, w.tq(paramString));
    AppMethodBeat.o(34431);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(34435);
    try
    {
      bl localbl = new bl();
      localbl.setContent(paramString2);
      localbl.jV(paramInt);
      paramInt = paramString2.indexOf("<msg>");
      String str = paramString2;
      if (paramInt > 0)
      {
        str = paramString2;
        if (paramInt < paramString2.length()) {
          str = paramString2.substring(paramInt).trim();
        }
      }
      paramString2 = bw.K(str, "msg");
      if ((paramString2 != null) && (paramString2.size() > 0)) {
        localbl.oa(bj.bA(paramString2));
      }
      b(paramContext, paramString1, localbl, paramBoolean);
      AppMethodBeat.o(34435);
      return;
    }
    catch (Exception paramContext)
    {
      ad.printErrStackTrace("MicroMsg.ChattingEditModeLogic", paramContext, "", new Object[0]);
      ad.e("MicroMsg.ChattingEditModeLogic", "retransmit sigle app msg error : %s", new Object[] { paramContext.getLocalizedMessage() });
      AppMethodBeat.o(34435);
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(163284);
    ad.d("MicroMsg.ChattingEditModeLogic", "copy video fileName %s userName %s export %d videoLength %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    String str1 = t.zP(com.tencent.mm.model.u.aqG());
    com.tencent.mm.modelvideo.o.aCI();
    String str2 = t.zQ(paramString1);
    String str3 = t.zQ(str1);
    paramString1 = t.zR(paramString1);
    String str4 = t.zR(str1);
    ad.d("MicroMsg.ChattingEditModeLogic", "copy video: srcFullPath[%s] destFullPath[%s] srcThumbPath[%s] destThumbPath[%s]", new Object[] { str2, str3, paramString1, str4 });
    com.tencent.mm.vfs.i.lC(str2, str3);
    com.tencent.mm.vfs.i.lC(paramString1, str4);
    com.tencent.mm.modelvideo.u.a(str1, paramInt2, paramString2, null, paramInt1, paramString3, paramInt3, (int)paramLong);
    com.tencent.mm.modelvideo.u.zX(str1);
    AppMethodBeat.o(163284);
  }
  
  static boolean a(Context paramContext, String paramString1, bl parambl, String paramString2)
  {
    AppMethodBeat.i(34425);
    if (paramContext == null)
    {
      ad.w("MicroMsg.ChattingEditModeLogic", "send %s fail, context is null", new Object[] { paramString2 });
      AppMethodBeat.o(34425);
      return false;
    }
    if (bt.isNullOrNil(paramString1))
    {
      ad.w("MicroMsg.ChattingEditModeLogic", "send %s fail, username is null", new Object[] { paramString2 });
      AppMethodBeat.o(34425);
      return false;
    }
    if (parambl == null)
    {
      ad.w("MicroMsg.ChattingEditModeLogic", "send %s fail, msg is null", new Object[] { paramString2 });
      AppMethodBeat.o(34425);
      return false;
    }
    AppMethodBeat.o(34425);
    return true;
  }
  
  public static boolean a(boolean paramBoolean, List<bl> paramList, String paramString, z paramz)
  {
    AppMethodBeat.i(34404);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ad.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to friend msg error, select item empty");
      AppMethodBeat.o(34404);
      return false;
    }
    int i;
    if ((paramList.size() == 1) && (((paramz != null) && (paramz.apE())) || (paramBoolean)))
    {
      paramList = (bl)paramList.get(0);
      if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pqv, 0) == 1) {}
      for (i = 1; ((ba(paramList)) && ((i == 0) || (aY(paramList)) || (d(paramList, paramString)))) || (paramList.eJN()) || (aN(paramList)) || (aP(paramList)) || (aQ(paramList)) || (paramList.getType() == -1879048186) || (paramList.getType() == 318767153) || ((paramList.getType() == 486539313) && (paramBoolean)) || (aX(paramList)) || (aR(paramList)) || (bb(paramList)) || (aW(paramList)) || (aS(paramList)) || (d(paramList, paramBoolean)) || (paramList.getType() == 788529201) || (paramList.getType() == 889192497); i = 0)
      {
        AppMethodBeat.o(34404);
        return false;
      }
      AppMethodBeat.o(34404);
      return true;
    }
    paramList = paramList.iterator();
    boolean bool = true;
    bl localbl;
    if (paramList.hasNext())
    {
      localbl = (bl)paramList.next();
      if (((paramz != null) && (paramz.apE())) || (paramBoolean)) {
        if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pqv, 0) == 1)
        {
          i = 1;
          label344:
          if ((!localbl.eJN()) && (!aN(localbl)) && (!aP(localbl)) && (!aQ(localbl)) && (localbl.getType() != -1879048186) && ((localbl.getType() != 486539313) || (!paramBoolean)) && (!aX(localbl)) && (!aR(localbl)) && ((!aT(localbl)) || ((paramz != null) && (paramz.apE()))) && ((!aU(localbl)) || ((paramz != null) && (paramz.apE()))) && (localbl.getType() != 318767153) && ((!ba(localbl)) || ((i != 0) && (!aY(localbl)) && (!d(localbl, paramString)))) && (!bb(localbl)) && (!aW(localbl)) && (!aS(localbl)) && (!d(localbl, paramBoolean)) && (localbl.getType() != 788529201) && (localbl.getType() != 889192497)) {
            break label636;
          }
          paramList.remove();
          bool = false;
        }
      }
    }
    label636:
    for (;;)
    {
      break;
      i = 0;
      break label344;
      if ((aT(localbl)) || (aU(localbl)) || (localbl.getType() == 788529201) || (localbl.getType() == 889192497))
      {
        paramList.remove();
        bool = false;
      }
      for (;;)
      {
        break;
        AppMethodBeat.o(34404);
        return bool;
      }
    }
  }
  
  public static boolean aN(bl parambl)
  {
    AppMethodBeat.i(34397);
    if (parambl == null)
    {
      ad.w("MicroMsg.ChattingEditModeLogic", "check is store emoji error, msg is null");
      AppMethodBeat.o(34397);
      return true;
    }
    if (parambl.eLZ())
    {
      ar localar = new ar(parambl.field_content);
      parambl = k.b.ar(parambl.field_content, parambl.field_reserved);
      if (parambl != null) {
        break label314;
      }
      parambl = new k.b();
      parambl.gHg = localar.md5;
    }
    label314:
    for (;;)
    {
      for (parambl = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Tz(parambl.gHg); (parambl != null) && ((parambl.field_catalog == EmojiInfo.LBW) || ((!bt.isNullOrNil(parambl.field_groupId)) && (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().TE(parambl.field_groupId)))); parambl = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Tz(parambl.field_imgPath))
      {
        AppMethodBeat.o(34397);
        return false;
      }
      if (parambl != null)
      {
        if ((bt.isNullOrNil(parambl.field_app_id)) && (!bt.isNullOrNil(parambl.field_groupId)) && (!parambl.field_groupId.equals(String.valueOf(EmojiGroupInfo.LBO))) && (!parambl.field_groupId.equals(String.valueOf(EmojiGroupInfo.LBN))) && (!parambl.field_groupId.equals(String.valueOf(EmojiGroupInfo.LBP))) && (!parambl.field_groupId.equals(String.valueOf(EmojiInfo.LBQ))) && (!parambl.field_groupId.equals("capture"))) {}
        for (int i = 1; i != 0; i = 0)
        {
          AppMethodBeat.o(34397);
          return true;
        }
      }
      AppMethodBeat.o(34397);
      return false;
    }
  }
  
  public static boolean aO(bl parambl)
  {
    AppMethodBeat.i(34398);
    if (parambl.eLZ())
    {
      ar localar = new ar(parambl.field_content);
      parambl = k.b.ar(parambl.field_content, parambl.field_reserved);
      if (parambl != null) {
        break label99;
      }
      parambl = new k.b();
      parambl.gHg = localar.md5;
    }
    label99:
    for (;;)
    {
      if (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Tz(parambl.gHg) == null)
      {
        AppMethodBeat.o(34398);
        return false;
      }
      AppMethodBeat.o(34398);
      return true;
    }
  }
  
  public static boolean aP(bl parambl)
  {
    AppMethodBeat.i(34399);
    if (parambl == null)
    {
      ad.w("MicroMsg.ChattingEditModeLogic", "check is game msg error, msg is null");
      AppMethodBeat.o(34399);
      return true;
    }
    if (parambl.field_isSend == 0) {}
    for (parambl = bi.ug(parambl.field_content);; parambl = parambl.field_content)
    {
      parambl = k.b.rx(parambl);
      if (parambl != null) {
        break;
      }
      ad.w("MicroMsg.ChattingEditModeLogic", "parse app message content fail");
      AppMethodBeat.o(34399);
      return false;
    }
    parambl = com.tencent.mm.pluginsdk.model.app.h.j(parambl.appId, false, false);
    if ((parambl != null) && (parambl.CZ()))
    {
      AppMethodBeat.o(34399);
      return true;
    }
    AppMethodBeat.o(34399);
    return false;
  }
  
  public static boolean aQ(bl parambl)
  {
    AppMethodBeat.i(34400);
    if (parambl.getType() == 419430449)
    {
      AppMethodBeat.o(34400);
      return true;
    }
    AppMethodBeat.o(34400);
    return false;
  }
  
  public static boolean aR(bl parambl)
  {
    AppMethodBeat.i(34401);
    if ((parambl.getType() == 436207665) || (parambl.getType() == 469762097))
    {
      AppMethodBeat.o(34401);
      return true;
    }
    AppMethodBeat.o(34401);
    return false;
  }
  
  public static boolean aS(bl parambl)
  {
    AppMethodBeat.i(34402);
    if (parambl == null)
    {
      ad.w("MicroMsg.ChattingEditModeLogic", "isAppbrandForbidForwardMsg, check msg error, msg is null");
      AppMethodBeat.o(34402);
      return true;
    }
    if (parambl.field_isSend == 0) {}
    for (parambl = bi.ug(parambl.field_content);; parambl = parambl.field_content)
    {
      parambl = k.b.rx(parambl);
      if (parambl != null) {
        break;
      }
      ad.w("MicroMsg.ChattingEditModeLogic", "isAppbrandForbidForwardMsg, parse app message content fail");
      AppMethodBeat.o(34402);
      return false;
    }
    if ((parambl.gJN != 0) || ((parambl.type == 33) && (parambl.gJG == 3)) || ((parambl.type == 46) && (parambl.gJG == 3)) || ((parambl.type == 44) && ((parambl.gJG == 3) || (!parambl.dY(false)))) || ((parambl.type == 48) && (parambl.gJG == 3)))
    {
      AppMethodBeat.o(34402);
      return true;
    }
    AppMethodBeat.o(34402);
    return false;
  }
  
  private static boolean aT(bl parambl)
  {
    AppMethodBeat.i(34405);
    if (parambl != null)
    {
      parambl = k.b.rx(parambl.field_content);
      if ((parambl != null) && (parambl.type == 19))
      {
        Object localObject = new pn();
        ((pn)localObject).dvb.type = 0;
        ((pn)localObject).dvb.dvd = parambl.gHI;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
        localObject = ((pn)localObject).dvc.dvl;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.protocal.b.a.c)localObject).gKs.iterator();
          while (((Iterator)localObject).hasNext())
          {
            afy localafy = (afy)((Iterator)localObject).next();
            if (!bt.isNullOrNil(localafy.Dhr))
            {
              ad.e("MicroMsg.ChattingEditModeLogic", "record type subDataItem contain tpurl, type:%d", new Object[] { Integer.valueOf(localafy.dataType) });
              AppMethodBeat.o(34405);
              return true;
            }
          }
        }
        if ((parambl.gHI != null) && (parambl.gHI.contains("<recordxml>")))
        {
          AppMethodBeat.o(34405);
          return true;
        }
        AppMethodBeat.o(34405);
        return false;
      }
    }
    AppMethodBeat.o(34405);
    return false;
  }
  
  private static boolean aU(bl parambl)
  {
    AppMethodBeat.i(34406);
    if (parambl != null)
    {
      parambl = k.b.rx(parambl.field_content);
      if ((parambl != null) && (parambl.type == 24))
      {
        AppMethodBeat.o(34406);
        return true;
      }
    }
    AppMethodBeat.o(34406);
    return false;
  }
  
  public static boolean aV(bl parambl)
  {
    AppMethodBeat.i(34407);
    if (parambl != null)
    {
      parambl = k.b.rx(parambl.field_content);
      if (parambl == null)
      {
        AppMethodBeat.o(34407);
        return false;
      }
      if ((parambl.type == 6) || (parambl.type == 5) || (parambl.type == 19))
      {
        AppMethodBeat.o(34407);
        return true;
      }
    }
    AppMethodBeat.o(34407);
    return false;
  }
  
  public static boolean aW(bl parambl)
  {
    AppMethodBeat.i(34408);
    if ((parambl == null) || (!parambl.eJL()))
    {
      AppMethodBeat.o(34408);
      return false;
    }
    boolean bool = com.tencent.mm.ai.m.c(parambl.field_msgId, parambl.field_content);
    AppMethodBeat.o(34408);
    return bool;
  }
  
  static boolean aX(bl parambl)
  {
    AppMethodBeat.i(34409);
    if (parambl != null)
    {
      parambl = k.b.rx(parambl.field_content);
      if ((parambl != null) && (parambl.type == 16))
      {
        AppMethodBeat.o(34409);
        return true;
      }
      if ((parambl != null) && (parambl.type == 34))
      {
        AppMethodBeat.o(34409);
        return true;
      }
    }
    AppMethodBeat.o(34409);
    return false;
  }
  
  public static boolean aY(bl parambl)
  {
    AppMethodBeat.i(34412);
    az.arV();
    bl.a locala = com.tencent.mm.model.c.apO().agC(parambl.field_content);
    if ((locala.yGA == null) || (locala.yGA.length() <= 0)) {
      ad.e("MicroMsg.ChattingEditModeLogic", "getView : parse possible friend msg failed");
    }
    if ((!w.mZ(locala.AOL)) && (parambl.getType() == 42))
    {
      boolean bool = parambl.eMn();
      AppMethodBeat.o(34412);
      return bool;
    }
    AppMethodBeat.o(34412);
    return false;
  }
  
  public static boolean aZ(bl parambl)
  {
    AppMethodBeat.i(34413);
    az.arV();
    bl.a locala = com.tencent.mm.model.c.apO().agC(parambl.field_content);
    if ((locala.yGA == null) || (locala.yGA.length() <= 0)) {
      ad.e("MicroMsg.ChattingEditModeLogic", "getView : parse possible friend msg failed");
    }
    if ((!w.mZ(locala.AOL)) && (parambl.getType() == 42))
    {
      if ((parambl.esg & 0x800) > 0)
      {
        AppMethodBeat.o(34413);
        return true;
      }
      AppMethodBeat.o(34413);
      return false;
    }
    AppMethodBeat.o(34413);
    return false;
  }
  
  public static void b(final Context paramContext, final String paramString, bl parambl)
  {
    AppMethodBeat.i(34427);
    if (!a(paramContext, paramString, parambl, "image"))
    {
      AppMethodBeat.o(34427);
      return;
    }
    Object localObject1 = null;
    if (parambl.field_msgId > 0L) {
      localObject1 = com.tencent.mm.aw.o.ayF().ms(parambl.field_msgId);
    }
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((com.tencent.mm.aw.e)localObject1).deI > 0L) {}
    }
    else
    {
      localObject2 = localObject1;
      if (parambl.field_msgSvrId > 0L) {
        localObject2 = com.tencent.mm.aw.o.ayF().mr(parambl.field_msgSvrId);
      }
    }
    if (localObject2 == null)
    {
      AppMethodBeat.o(34427);
      return;
    }
    final int j = 0;
    final int i = j;
    if (((com.tencent.mm.aw.e)localObject2).ayi())
    {
      i = j;
      if (!com.tencent.mm.aw.f.a((com.tencent.mm.aw.e)localObject2).hgj.startsWith("SERVERID://")) {
        i = 1;
      }
    }
    localObject1 = com.tencent.mm.aw.o.ayF().p(com.tencent.mm.aw.f.c((com.tencent.mm.aw.e)localObject2), "", "");
    String str1 = com.tencent.mm.aw.o.ayF().p(((com.tencent.mm.aw.e)localObject2).hgl, "th_", "");
    if ((((com.tencent.mm.aw.e)localObject2).offset < ((com.tencent.mm.aw.e)localObject2).gTY) || (((com.tencent.mm.aw.e)localObject2).gTY == 0))
    {
      final String str2 = com.tencent.mm.model.u.aqG();
      final String str3 = ((com.tencent.mm.aw.e)localObject2).hgv;
      Object localObject3 = bw.K(((com.tencent.mm.aw.e)localObject2).hgv, "msg");
      if (localObject3 == null)
      {
        ad.e("MicroMsg.ChattingEditModeLogic", "parse cdnInfo failed. [%s]", new Object[] { ((com.tencent.mm.aw.e)localObject2).hgv });
        i = 0;
      }
      for (;;)
      {
        if (i == 0) {
          a(paramContext, (com.tencent.mm.aw.e)localObject2, parambl, 4, paramString, str1);
        }
        AppMethodBeat.o(34427);
        return;
        j = ((com.tencent.mm.aw.e)localObject2).hgm;
        if (j != 1) {
          localObject1 = (String)((Map)localObject3).get(".msg.img.$cdnmidimgurl");
        }
        for (i = 2;; i = 1)
        {
          ad.d("MicroMsg.ChattingEditModeLogic", "cdntra read xml  comptype:%d url:[%s]", new Object[] { Integer.valueOf(j), localObject1 });
          if (!bt.isNullOrNil((String)localObject1)) {
            break label367;
          }
          ad.e("MicroMsg.ChattingEditModeLogic", "cdntra get cdnUrlfailed.");
          i = 0;
          break;
          localObject1 = (String)((Map)localObject3).get(".msg.img.$cdnbigimgurl");
        }
        label367:
        String str4 = (String)((Map)localObject3).get(".msg.img.$aeskey");
        if (bt.isNullOrNil(str4))
        {
          ad.e("MicroMsg.ChattingEditModeLogic", "cdntra get aes key failed.");
          i = 0;
        }
        else if (bt.isNullOrNil(com.tencent.mm.ao.c.a("downimg", ((com.tencent.mm.aw.e)localObject2).hgr, parambl.field_talker, parambl.field_msgId)))
        {
          ad.w("MicroMsg.ChattingEditModeLogic", "cdntra genClientId failed not use cdn imgLocalId:%d", new Object[] { Long.valueOf(parambl.field_msgSvrId) });
          i = 0;
        }
        else
        {
          localObject3 = (String)((Map)localObject3).get(".msg.img.$md5");
          com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
          localg.fnH = new g.a()
          {
            public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(34390);
              Object localObject1;
              int i;
              String str1;
              String str2;
              int j;
              String str3;
              Object localObject2;
              Object localObject3;
              Object localObject4;
              bl localbl;
              long l3;
              if (paramAnonymousd != null)
              {
                if (!paramAnonymousd.field_exist_whencheck) {
                  break label752;
                }
                ad.d("MicroMsg.ChattingEditModeLogic", "support second !! sceneResult:[%s]", new Object[] { paramAnonymousd });
                localObject1 = this.gLQ;
                i = this.hQA;
                paramAnonymousc = paramString;
                str1 = str2;
                paramAnonymousString = str3;
                str2 = this.kzy;
                j = j;
                str3 = com.tencent.mm.aw.o.ayF().Q(((du)localObject1).field_imgPath, true);
                localObject2 = new PString();
                localObject3 = new PInt();
                localObject4 = new PInt();
                ((PString)localObject2).value = "";
                localbl = new bl();
                localbl.setType(w.tr(paramAnonymousc));
                localbl.nY(paramAnonymousc);
                localbl.jV(1);
                localbl.setStatus(1);
                localbl.kY(bi.uj(localbl.field_talker));
                localbl.setContent(paramAnonymousString);
                a.a.Wh().n(localbl);
                l3 = ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().an(localbl);
                if (l3 < 0L) {
                  break label746;
                }
                paramAnonymousBoolean = true;
                Assert.assertTrue(paramAnonymousBoolean);
                ad.i("MicroMsg.ChattingEditModeLogic", "NetSceneUploadMsgImg: local msgId = ".concat(String.valueOf(l3)));
                if (j != 1) {
                  break label815;
                }
              }
              label815:
              for (long l1 = com.tencent.mm.aw.o.ayF().a(null, l3, true, localbl.field_content, (PString)localObject2, (PInt)localObject3, (PInt)localObject4);; l1 = 0L)
              {
                long l2 = com.tencent.mm.aw.o.ayF().a(null, l3, false, localbl.field_content, (PString)localObject2, (PInt)localObject3, (PInt)localObject4);
                localObject3 = bw.K(paramAnonymousString, "msg");
                paramAnonymousInt = bt.getInt((String)((Map)localObject3).get(".msg.img.$length"), paramAnonymousd.field_thumbimgLength);
                paramAnonymousString = com.tencent.mm.aw.o.ayF().b(Long.valueOf(l2));
                paramAnonymousString.mq((int)l3);
                if (l2 > 0L)
                {
                  localObject4 = com.tencent.mm.aw.o.ayF().a(((PString)localObject2).value, "th_", "", false);
                  ad.i("MicroMsg.ChattingEditModeLogic", "deal send img for cdn [%s]", new Object[] { localObject4 });
                  com.tencent.mm.vfs.i.lC(str3, (String)localObject4);
                  localbl.nZ(((PString)localObject2).value);
                  localbl.kh(((du)localObject1).eOU);
                  localbl.ki(((du)localObject1).eOV);
                  if (l1 > 0L)
                  {
                    paramAnonymousString.oc(1);
                    paramAnonymousString.nY((int)l1);
                    paramAnonymousInt = bt.getInt((String)((Map)localObject3).get(".msg.img.$hdlength"), paramAnonymousd.field_thumbimgLength);
                  }
                }
                for (;;)
                {
                  com.tencent.mm.aw.o.ayF().a(Long.valueOf(l2), paramAnonymousString);
                  if (j == 1) {
                    paramAnonymousString = com.tencent.mm.aw.o.ayF().b(Long.valueOf(l1));
                  }
                  for (;;)
                  {
                    ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().a(l3, localbl);
                    com.tencent.mm.aw.o.ayF().a(Long.valueOf(l1), paramAnonymousString);
                    localObject1 = com.tencent.mm.ao.c.a("upimg", localbl.field_createTime, localbl.field_talker, localbl.field_msgId + "_" + l1 + "_" + j);
                    localObject2 = new dht();
                    ((dht)localObject2).Cxx = new cmf().aEE(str1);
                    ((dht)localObject2).Cxy = new cmf().aEE(paramAnonymousc);
                    ((dht)localObject2).saz = localbl.getType();
                    ((dht)localObject2).CxC = localbl.esh;
                    ((dht)localObject2).COS = paramAnonymousString.hgn;
                    ((dht)localObject2).ExR = new cmf().aEE((String)localObject1);
                    ((dht)localObject2).DvO = j;
                    paramAnonymousd.field_filemd5 = str2;
                    paramAnonymousd.field_thumbimgLength = ((int)com.tencent.mm.vfs.i.aMN(str3));
                    paramAnonymousd.field_fileLength = paramAnonymousInt;
                    paramAnonymousString = new com.tencent.mm.aw.m(i, (dht)localObject2, paramAnonymousString, paramAnonymousd, new j.2(l2, l3));
                    com.tencent.mm.kernel.g.aeS().a(paramAnonymousString, 0);
                    for (;;)
                    {
                      AppMethodBeat.o(34390);
                      return 0;
                      label746:
                      paramAnonymousBoolean = false;
                      break;
                      label752:
                      ad.d("MicroMsg.ChattingEditModeLogic", "not support second !! dealDownLoadImg");
                      paramAnonymousString = com.tencent.mm.aw.o.ayF().p(this.hib.hgl, "th_", "");
                      j.a(paramContext, this.hib, this.gLQ, this.hQA, paramString, paramAnonymousString);
                    }
                    l1 = l2;
                  }
                }
              }
            }
            
            public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
            
            public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
            {
              return new byte[0];
            }
          };
          localg.field_mediaId = com.tencent.mm.ao.c.a("checkExist", bt.eGO(), paramString, parambl.field_msgId);
          localg.field_fileId = ((String)localObject1);
          localg.field_aesKey = str4;
          localg.field_filemd5 = ((String)localObject3);
          localg.field_fileType = i;
          localg.field_talker = paramString;
          localg.field_priority = com.tencent.mm.i.a.fmV;
          localg.field_svr_signature = "";
          localg.field_onlycheckexist = true;
          localg.field_trysafecdn = true;
          if (!com.tencent.mm.ao.f.awL().e(localg))
          {
            ad.e("MicroMsg.ChattingEditModeLogic", "check exist fail! download img before retransmit");
            i = 0;
          }
          else
          {
            i = 1;
          }
        }
      }
    }
    if (!bt.isNullOrNil((String)localObject1)) {
      com.tencent.mm.plugin.messenger.a.j.cOB().a(paramContext, paramString, (String)localObject1, i, ((com.tencent.mm.aw.e)localObject2).hgv, str1, parambl.field_msgId, null);
    }
    AppMethodBeat.o(34427);
  }
  
  public static void b(Context paramContext, String paramString, bl parambl, boolean paramBoolean)
  {
    AppMethodBeat.i(34432);
    if (!a(paramContext, paramString, parambl, "appmsg"))
    {
      AppMethodBeat.o(34432);
      return;
    }
    if (paramContext == null)
    {
      ad.w("MicroMsg.ChattingEditModeLogic", "getReaderAppMsgContent: context is null");
      AppMethodBeat.o(34432);
      return;
    }
    if (parambl == null)
    {
      ad.w("MicroMsg.ChattingEditModeLogic", "getReaderAppMsgContent: msg is null");
      AppMethodBeat.o(34432);
      return;
    }
    az.arV();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      AppMethodBeat.o(34432);
      return;
    }
    paramContext = com.tencent.mm.aw.o.ayF().b(parambl.field_imgPath, false, false);
    if ((!ae.isNullOrNil(paramContext)) && (!paramContext.endsWith("hd")) && (com.tencent.mm.vfs.i.eK(paramContext + "hd"))) {
      paramContext = paramContext + "hd";
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject1 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(parambl.field_msgId, parambl.field_content);
        localObject2 = ((com.tencent.mm.ai.u)localObject1).gKs;
        if ((localObject2 == null) || (((List)localObject2).size() <= 0))
        {
          if ((parambl == null) || ((!parambl.cxB()) && (!parambl.eJL()))) {
            break label759;
          }
          localObject1 = y.tD(parambl.field_msgSvrId);
          localObject2 = y.arz().E((String)localObject1, true);
          ((y.b)localObject2).m("prePublishId", "msg_" + parambl.field_msgSvrId);
          ((y.b)localObject2).m("preUsername", com.tencent.mm.ui.chatting.viewitems.c.a(parambl, paramBoolean, false));
          ((y.b)localObject2).m("preChatName", parambl.field_talker);
          ((y.b)localObject2).m("preMsgIndex", Integer.valueOf(0));
          ((y.b)localObject2).m("sendAppMsgScene", Integer.valueOf(1));
          ((com.tencent.mm.plugin.sns.c.j)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.sns.c.j.class)).a("adExtStr", (y.b)localObject2, parambl);
          com.tencent.mm.plugin.messenger.a.j.cOB().a(paramString, bt.readFromFile(paramContext), bt.aGg(parambl.field_content), (String)localObject1);
          AppMethodBeat.o(34432);
          return;
        }
      }
      catch (Exception paramContext)
      {
        ad.printErrStackTrace("MicroMsg.ChattingEditModeLogic", paramContext, "", new Object[0]);
        ad.e("MicroMsg.ChattingEditModeLogic", "send app msg error : %s", new Object[] { paramContext.getLocalizedMessage() });
        AppMethodBeat.o(34432);
        return;
      }
      parambl = ((List)localObject2).iterator();
      while (parambl.hasNext())
      {
        Object localObject3 = (v)parambl.next();
        localObject2 = new k.b();
        if (com.tencent.mm.ai.m.rz(((v)localObject3).gKI))
        {
          l.b(paramString, l.a(paramString, (v)localObject3), ((v)localObject3).gKN);
        }
        else
        {
          ((k.b)localObject2).title = ((v)localObject3).title;
          ((k.b)localObject2).description = ((v)localObject3).gKF;
          ((k.b)localObject2).action = "view";
          ((k.b)localObject2).type = 5;
          ((k.b)localObject2).url = ((v)localObject3).url;
          ((k.b)localObject2).dxz = ((com.tencent.mm.ai.u)localObject1).dxz;
          ((k.b)localObject2).dxA = ((com.tencent.mm.ai.u)localObject1).dxA;
          ((k.b)localObject2).eOT = ((com.tencent.mm.ai.u)localObject1).eOT;
          ((k.b)localObject2).thumburl = com.tencent.mm.ai.m.a((v)localObject3);
          com.tencent.mm.ai.e locale = new com.tencent.mm.ai.e();
          locale.gGx = ((v)localObject3).type;
          locale.gGA = ((v)localObject3).gGA;
          if (((v)localObject3).type == 5)
          {
            locale.gGC = ((v)localObject3).gGC;
            locale.gGy = ((int)((v)localObject3).time);
            locale.duration = ((v)localObject3).gKH;
            locale.videoWidth = ((v)localObject3).videoWidth;
            locale.videoHeight = ((v)localObject3).videoHeight;
          }
          ((k.b)localObject2).a(locale);
          if ((bt.isNullOrNil(((k.b)localObject2).thumburl)) && (!bt.isNullOrNil(((k.b)localObject2).dxz)))
          {
            localObject3 = p.auF().we(((k.b)localObject2).dxz);
            if (localObject3 != null) {
              ((k.b)localObject2).thumburl = ((com.tencent.mm.ak.i)localObject3).aux();
            }
          }
          localObject2 = k.b.a((k.b)localObject2, null, null);
          com.tencent.mm.plugin.messenger.a.j.cOB().a(paramString, bt.readFromFile(paramContext), bt.aGg((String)localObject2), null);
        }
      }
      AppMethodBeat.o(34432);
      return;
      label759:
      Object localObject1 = null;
    }
  }
  
  public static void b(EmojiInfo paramEmojiInfo, String paramString)
  {
    AppMethodBeat.i(34436);
    WXMediaMessage localWXMediaMessage = new WXMediaMessage();
    Object localObject = new StringBuilder();
    az.arV();
    localObject = com.tencent.mm.model.c.aqb() + paramEmojiInfo.JS();
    if (com.tencent.mm.vfs.i.aMN((String)localObject + "_thumb") > 0L)
    {
      int i = (int)com.tencent.mm.vfs.i.aMN((String)localObject + "_thumb");
      localWXMediaMessage.thumbData = com.tencent.mm.vfs.i.aR((String)localObject + "_thumb", 0, i);
    }
    for (;;)
    {
      localWXMediaMessage.mediaObject = new WXEmojiObject((String)localObject);
      com.tencent.mm.pluginsdk.model.app.m.a(localWXMediaMessage, paramEmojiInfo.field_app_id, null, paramString, 1, paramEmojiInfo.JS());
      AppMethodBeat.o(34436);
      return;
      try
      {
        InputStream localInputStream = com.tencent.mm.vfs.i.openRead((String)localObject);
        localWXMediaMessage.setThumbImage(BackwardSupportUtil.b.b(localInputStream, 1.0F));
        localInputStream.close();
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.ChattingEditModeLogic", localException, "", new Object[0]);
        ad.e("MicroMsg.ChattingEditModeLogic", "sendAppMsgEmoji Fail cause there is no thumb");
      }
    }
  }
  
  static boolean ba(bl parambl)
  {
    AppMethodBeat.i(34414);
    if (!parambl.eLX())
    {
      AppMethodBeat.o(34414);
      return false;
    }
    az.arV();
    parambl = com.tencent.mm.model.c.apO().agC(parambl.field_content);
    if ((parambl == null) || (bt.isNullOrNil(parambl.yGA)))
    {
      AppMethodBeat.o(34414);
      return true;
    }
    if (w.sE(parambl.yGA))
    {
      AppMethodBeat.o(34414);
      return false;
    }
    AppMethodBeat.o(34414);
    return true;
  }
  
  private static boolean bb(bl parambl)
  {
    AppMethodBeat.i(34415);
    if ((parambl != null) && (parambl.cxB()))
    {
      parambl = k.b.rx(parambl.field_content);
      if ((parambl != null) && (parambl.type == 6) && ((parambl.gHi != 0) || (parambl.gHe > 26214400)))
      {
        AppMethodBeat.o(34415);
        return true;
      }
    }
    AppMethodBeat.o(34415);
    return false;
  }
  
  public static boolean bc(bl parambl)
  {
    AppMethodBeat.i(34416);
    if ((parambl != null) && (parambl.cxB()))
    {
      parambl = k.b.rx(parambl.field_content);
      if ((parambl != null) && (parambl.type == 6))
      {
        AppMethodBeat.o(34416);
        return true;
      }
    }
    AppMethodBeat.o(34416);
    return false;
  }
  
  public static void c(Context paramContext, final String paramString, final bl parambl)
  {
    AppMethodBeat.i(34430);
    if ((!a(paramContext, paramString, parambl, "video")) || (parambl == null))
    {
      AppMethodBeat.o(34430);
      return;
    }
    if ((parambl != null) && (parambl.cjO()) && (com.tencent.mm.modelvideo.u.Ag(parambl.field_imgPath)))
    {
      AppMethodBeat.o(34430);
      return;
    }
    Object localObject = com.tencent.mm.modelvideo.u.Ae(parambl.field_imgPath);
    if ((localObject != null) && (((s)localObject).status == 199))
    {
      a(parambl.field_imgPath, paramString, ((s)localObject).hAl, ((s)localObject).gOY, ((s)localObject).aCT(), parambl.getType(), parambl.field_msgId);
      AppMethodBeat.o(34430);
      return;
    }
    Map localMap = bw.K(((s)localObject).aCT(), "msg");
    final int i;
    if (localMap == null)
    {
      ad.w("MicroMsg.ChattingEditModeLogic", "%s cdntra parse video recv xml failed");
      i = 0;
    }
    for (;;)
    {
      if (i == 0) {
        f(paramString, parambl);
      }
      AppMethodBeat.o(34430);
      return;
      paramContext = (String)localMap.get(".msg.videomsg.$cdnvideourl");
      if (bt.isNullOrNil(paramContext))
      {
        i = 0;
      }
      else
      {
        final String str1 = (String)localMap.get(".msg.videomsg.$aeskey");
        final String str2 = (String)localMap.get(".msg.videomsg.$md5");
        final String str3 = (String)localMap.get(".msg.videomsg.$newmd5");
        i = bt.getInt((String)localMap.get(".msg.videomsg.$length"), 0);
        final int j = bt.getInt((String)localMap.get(".msg.videomsg.$playlength"), 0);
        final int k = bt.getInt((String)localMap.get(".msg.videomsg.$cdnthumblength"), 0);
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1328L, 12L, 1L, true);
        if (bt.isNullOrNil(str2))
        {
          com.tencent.mm.modelvideo.o.aCI();
          if (!com.tencent.mm.vfs.i.eK(t.zQ(((s)localObject).getFileName())))
          {
            ad.i("MicroMsg.ChattingEditModeLogic", "checkVideoCdnInfo md5 %s", new Object[] { str2 });
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1328L, 2L, 1L, true);
            i = 0;
            continue;
          }
        }
        localObject = new com.tencent.mm.i.g();
        ((com.tencent.mm.i.g)localObject).fnH = new g.a()
        {
          public final int a(final String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(34394);
            if (paramAnonymousd != null)
            {
              if (!paramAnonymousd.field_exist_whencheck) {
                break label350;
              }
              paramAnonymousd.field_fileId = this.val$url;
              paramAnonymousd.field_aesKey = str1;
              paramAnonymousd.field_thumbimgLength = k;
              paramAnonymousd.field_fileLength = i;
              paramAnonymousd.field_toUser = paramString;
              paramAnonymousd.field_filemd5 = str2;
              paramAnonymousd.field_mp4identifymd5 = str3;
              ad.i("MicroMsg.ChattingEditModeLogic", "support second!! sceneResult: %s", new Object[] { paramAnonymousd });
              paramAnonymousString = t.zP(com.tencent.mm.model.u.aqG());
              com.tencent.mm.modelvideo.o.aCI();
              paramAnonymousc = t.zR(paramAnonymousString);
              com.tencent.mm.modelvideo.o.aCI();
              com.tencent.mm.vfs.i.lC(t.zR(parambl.field_imgPath), paramAnonymousc);
              paramAnonymousc = "<msg><videomsg aeskey=\"" + str1 + "\" cdnthumbaeskey=\"" + str1 + "\" cdnvideourl=\"" + this.val$url + "\" ";
              paramAnonymousc = paramAnonymousc + "cdnthumburl=\"" + this.val$url + "\" ";
              paramAnonymousc = paramAnonymousc + "length=\"" + i + "\" ";
              paramAnonymousc = paramAnonymousc + "cdnthumblength=\"" + k + "\"/></msg>";
              ad.i("MicroMsg.ChattingEditModeLogic", "cdn callback new build cdnInfo:%s", new Object[] { paramAnonymousc });
              com.tencent.mm.modelvideo.u.b(paramAnonymousString, j, paramString, paramAnonymousc, (int)parambl.field_msgId);
              com.tencent.mm.kernel.g.aeS().a(new com.tencent.mm.modelvideo.h(paramAnonymousString, 0, paramAnonymousd, new h.a()
              {
                public final void dm(int paramAnonymous2Int1, int paramAnonymous2Int2)
                {
                  AppMethodBeat.i(34393);
                  s locals = com.tencent.mm.modelvideo.u.Ae(paramAnonymousString);
                  locals.status = 111;
                  locals.dtM = 256;
                  com.tencent.mm.modelvideo.o.aCI().c(locals);
                  ad.d("MicroMsg.ChattingEditModeLogic", "NetSceneUploadVideoForCdn callback, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
                  AppMethodBeat.o(34393);
                }
              }), 0);
            }
            for (;;)
            {
              AppMethodBeat.o(34394);
              return 0;
              label350:
              j.f(paramString, parambl);
            }
          }
          
          public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
          
          public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
          {
            return new byte[0];
          }
        };
        ((com.tencent.mm.i.g)localObject).field_mediaId = com.tencent.mm.ao.c.a("checkExist", bt.eGO(), paramString, parambl.field_msgId);
        ((com.tencent.mm.i.g)localObject).field_fileId = paramContext;
        ((com.tencent.mm.i.g)localObject).field_aesKey = str1;
        ((com.tencent.mm.i.g)localObject).field_filemd5 = str2;
        ((com.tencent.mm.i.g)localObject).field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
        ((com.tencent.mm.i.g)localObject).field_talker = paramString;
        ((com.tencent.mm.i.g)localObject).field_priority = com.tencent.mm.i.a.fmV;
        ((com.tencent.mm.i.g)localObject).field_svr_signature = "";
        ((com.tencent.mm.i.g)localObject).field_onlycheckexist = true;
        ((com.tencent.mm.i.g)localObject).field_trysafecdn = true;
        if (!com.tencent.mm.ao.f.awL().e((com.tencent.mm.i.g)localObject))
        {
          ad.e("MicroMsg.ChattingEditModeLogic", "check exist fail! download video before retransmit");
          i = 0;
        }
        else
        {
          i = 1;
        }
      }
    }
  }
  
  public static void c(Context paramContext, String paramString, bl parambl, boolean paramBoolean)
  {
    AppMethodBeat.i(34433);
    if (!a(paramContext, paramString, parambl, "location"))
    {
      AppMethodBeat.o(34433);
      return;
    }
    paramContext = x(parambl.field_content, parambl.field_isSend, paramBoolean);
    com.tencent.mm.plugin.messenger.a.j.cOB().W(paramString, paramContext, 48);
    AppMethodBeat.o(34433);
  }
  
  public static void d(Context paramContext, String paramString, bl parambl, boolean paramBoolean)
  {
    AppMethodBeat.i(34434);
    for (;;)
    {
      com.tencent.mm.ai.u localu;
      Object localObject2;
      k.b localb;
      try
      {
        localu = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(parambl.field_msgId, parambl.field_content);
        Object localObject1 = localu.gKs;
        if (localObject1 == null) {
          break;
        }
        localObject1 = ((List)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (v)((Iterator)localObject1).next();
        localb = new k.b();
        if (com.tencent.mm.ai.m.rz(((v)localObject2).gKI))
        {
          l.b(paramString, l.a(paramString, (v)localObject2), ((v)localObject2).gKN);
          continue;
        }
        localb.title = ((v)localObject2).title;
      }
      catch (Exception paramContext)
      {
        ad.printErrStackTrace("MicroMsg.ChattingEditModeLogic", paramContext, "", new Object[0]);
        ad.e("MicroMsg.ChattingEditModeLogic", "[oneliang]retransmit multi app msg error : %s", new Object[] { paramContext.getLocalizedMessage() });
        AppMethodBeat.o(34434);
        return;
      }
      localb.description = ((v)localObject2).gKF;
      localb.action = "view";
      localb.type = 5;
      localb.url = ((v)localObject2).url;
      localb.dxz = localu.dxz;
      localb.dxA = localu.dxA;
      localb.eOT = localu.eOT;
      localb.thumburl = com.tencent.mm.ai.m.a((v)localObject2);
      com.tencent.mm.ai.e locale = new com.tencent.mm.ai.e();
      locale.gGx = ((v)localObject2).type;
      locale.gGA = ((v)localObject2).gGA;
      if (((v)localObject2).type == 5)
      {
        locale.gGC = ((v)localObject2).gGC;
        locale.gGy = ((int)((v)localObject2).time);
        locale.duration = ((v)localObject2).gKH;
        locale.videoWidth = ((v)localObject2).videoWidth;
        locale.videoHeight = ((v)localObject2).videoHeight;
      }
      localb.a(locale);
      if (bt.isNullOrNil(localb.thumburl))
      {
        localObject2 = p.auF().we(parambl.field_talker);
        if (localObject2 != null) {
          localb.thumburl = ((com.tencent.mm.ak.i)localObject2).aux();
        }
      }
      a(paramContext, paramString, k.b.a(localb, null, null), parambl.field_isSend, paramBoolean);
    }
    AppMethodBeat.o(34434);
  }
  
  private static boolean d(bl parambl, String paramString)
  {
    AppMethodBeat.i(34411);
    az.arV();
    bl.a locala = com.tencent.mm.model.c.apO().agC(parambl.field_content);
    if ((locala.yGA == null) || (locala.yGA.length() <= 0))
    {
      ad.e("MicroMsg.ChattingEditModeLogic", "getView : parse possible friend msg failed");
      AppMethodBeat.o(34411);
      return false;
    }
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pqv, 0) == 1) {}
    for (int i = 1; (i != 0) && ((com.tencent.mm.storage.af.aHH(paramString)) || (com.tencent.mm.storage.af.aHI(paramString)) || (parambl.getType() == 66)); i = 0)
    {
      AppMethodBeat.o(34411);
      return true;
    }
    AppMethodBeat.o(34411);
    return false;
  }
  
  private static boolean d(bl parambl, boolean paramBoolean)
  {
    AppMethodBeat.i(34410);
    if (!paramBoolean)
    {
      AppMethodBeat.o(34410);
      return false;
    }
    if (parambl != null)
    {
      parambl = k.b.rx(parambl.field_content);
      if ((parambl != null) && (parambl.type == 33) && (parambl.gJG == 1))
      {
        AppMethodBeat.o(34410);
        return true;
      }
    }
    AppMethodBeat.o(34410);
    return false;
  }
  
  public static List<String> eVj()
  {
    AppMethodBeat.i(34422);
    Object localObject1 = com.tencent.mm.am.af.awe().nH(25);
    Object localObject2 = com.tencent.mm.am.af.awe();
    Object localObject3 = new ArrayList();
    Object localObject4 = new StringBuilder();
    com.tencent.mm.am.e.a((StringBuilder)localObject4);
    com.tencent.mm.am.e.c((StringBuilder)localObject4);
    com.tencent.mm.am.e.d((StringBuilder)localObject4);
    com.tencent.mm.am.e.a((StringBuilder)localObject4, true);
    ((StringBuilder)localObject4).append(" order by ");
    ((StringBuilder)localObject4).append(com.tencent.mm.am.e.avz());
    localObject4 = ((StringBuilder)localObject4).toString();
    ad.i("MicroMsg.BizInfoStorage", "getEnterpriseBizChatLst sql %s", new Object[] { localObject4 });
    localObject2 = ((com.tencent.mm.am.e)localObject2).rawQuery((String)localObject4, new String[0]);
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
      str = com.tencent.mm.am.f.ei((String)localObject4).Jm();
      if (!bt.isNullOrNil(str)) {
        ((HashMap)localObject2).put(str, localObject4);
      }
    }
    localObject3 = new LinkedList();
    localObject4 = new LinkedList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      str = (String)((Iterator)localObject1).next();
      if (com.tencent.mm.am.f.wJ(str))
      {
        if (com.tencent.mm.am.f.wN(str))
        {
          str = com.tencent.mm.am.f.ei(str).field_enterpriseFather;
          if ((!((List)localObject4).contains(str)) && (com.tencent.mm.am.f.wL(str)))
          {
            ((List)localObject4).add(str);
            str = (String)((HashMap)localObject2).get(str);
            if (!bt.isNullOrNil(str)) {
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
      if ((!bt.isNullOrNil((String)localObject2)) && (!((List)localObject4).contains(localObject2))) {
        ((List)localObject4).add(localObject2);
      }
    }
    ((List)localObject3).addAll((Collection)localObject4);
    ad.d("MicroMsg.ChattingEditModeLogic", "get selected accept list, size %d", new Object[] { Integer.valueOf(((List)localObject3).size()) });
    AppMethodBeat.o(34422);
    return localObject3;
  }
  
  public static List<String> eVk()
  {
    AppMethodBeat.i(34423);
    Object localObject = com.tencent.mm.am.af.awe().nH(25);
    LinkedList localLinkedList = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!com.tencent.mm.am.f.wJ(str)) {
        localLinkedList.add(str);
      }
    }
    ad.d("MicroMsg.ChattingEditModeLogic", "get selected accept list without enterprise, size %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    AppMethodBeat.o(34423);
    return localLinkedList;
  }
  
  static void f(final String paramString, bl parambl)
  {
    AppMethodBeat.i(34429);
    az.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34396);
        com.tencent.mm.modelvideo.o.aCN().a(this.gLQ.field_imgPath, new t.a()
        {
          public final void a(t.a.a paramAnonymous2a)
          {
            AppMethodBeat.i(34395);
            paramAnonymous2a = com.tencent.mm.modelvideo.u.Ae(paramAnonymous2a.fileName);
            if ((paramAnonymous2a != null) && (paramAnonymous2a.status == 199)) {
              j.a(j.5.this.gLQ.field_imgPath, j.5.this.fqK, paramAnonymous2a.hAl, paramAnonymous2a.gOY, paramAnonymous2a.aCT(), j.5.this.gLQ.getType(), j.5.this.gLQ.field_msgId);
            }
            AppMethodBeat.o(34395);
          }
        });
        AppMethodBeat.o(34396);
      }
    });
    AppMethodBeat.o(34429);
  }
  
  public static boolean hu(List<bl> paramList)
  {
    AppMethodBeat.i(34403);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ad.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to brand msg error, selected item empty");
      AppMethodBeat.o(34403);
      return true;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bl localbl = (bl)paramList.next();
      if ((localbl.eJN()) || (aN(localbl)) || (localbl.eLX()) || (aP(localbl)) || (aQ(localbl)) || (localbl.getType() == -1879048186) || (aX(localbl)) || (aR(localbl)) || (aW(localbl)) || (aS(localbl)) || (bc(localbl)))
      {
        AppMethodBeat.o(34403);
        return true;
      }
    }
    AppMethodBeat.o(34403);
    return false;
  }
  
  public static int hv(List<bl> paramList)
  {
    AppMethodBeat.i(34417);
    if (paramList == null)
    {
      ad.w("MicroMsg.ChattingEditModeLogic", "get invalid send to friend msg num error, select item empty");
      AppMethodBeat.o(34417);
      return 0;
    }
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      bl localbl = (bl)paramList.next();
      if ((!localbl.eJN()) && (!aN(localbl)) && (!localbl.cxD()) && (!aP(localbl)) && (!aQ(localbl)) && (!aR(localbl))) {
        break label111;
      }
      i += 1;
    }
    label111:
    for (;;)
    {
      break;
      AppMethodBeat.o(34417);
      return i;
    }
  }
  
  public static boolean hw(List<bl> paramList)
  {
    AppMethodBeat.i(34418);
    if (paramList == null)
    {
      ad.w("MicroMsg.ChattingEditModeLogic", "check contain undownload file, select item empty");
      AppMethodBeat.o(34418);
      return false;
    }
    Iterator localIterator = paramList.iterator();
    label382:
    label383:
    for (;;)
    {
      bl localbl;
      if (localIterator.hasNext())
      {
        localbl = (bl)localIterator.next();
        if ((localbl.eJO()) || (localbl.eMb()))
        {
          paramList = null;
          if (localbl.field_msgId > 0L) {
            paramList = com.tencent.mm.aw.o.ayF().ms(localbl.field_msgId);
          }
          if (((paramList != null) && (paramList.deI > 0L)) || (localbl.field_msgSvrId <= 0L)) {
            break label382;
          }
          paramList = com.tencent.mm.aw.o.ayF().mr(localbl.field_msgSvrId);
        }
      }
      for (;;)
      {
        if ((paramList == null) || ((paramList.offset >= paramList.gTY) && (paramList.gTY != 0))) {
          break label383;
        }
        AppMethodBeat.o(34418);
        return true;
        if (localbl.cjM())
        {
          paramList = com.tencent.mm.modelvideo.o.aCI().zO(localbl.field_imgPath);
          if ((paramList == null) || (paramList.status == 199) || (paramList.status == 199)) {
            break;
          }
          AppMethodBeat.o(34418);
          return true;
        }
        if (localbl.eLZ())
        {
          if (aO(localbl)) {
            break;
          }
          AppMethodBeat.o(34418);
          return true;
        }
        if (localbl.cxB())
        {
          paramList = k.b.ar(localbl.field_content, localbl.field_content);
          if (paramList == null)
          {
            AppMethodBeat.o(34418);
            return true;
          }
          switch (paramList.type)
          {
          default: 
            break;
          case 6: 
            paramList = ap.bxS().aAL(paramList.dbA);
            if (paramList == null)
            {
              AppMethodBeat.o(34418);
              return true;
            }
            if (new com.tencent.mm.vfs.e(paramList.field_fileFullPath).exists()) {
              break;
            }
            AppMethodBeat.o(34418);
            return true;
          }
        }
        if (!localbl.cjO()) {
          break;
        }
        paramList = com.tencent.mm.modelvideo.u.Ae(localbl.field_imgPath);
        if ((paramList == null) || (paramList.status == 199) || (paramList.status == 199)) {
          break;
        }
        AppMethodBeat.o(34418);
        return true;
        AppMethodBeat.o(34418);
        return false;
      }
    }
  }
  
  public static boolean hx(List<bl> paramList)
  {
    AppMethodBeat.i(34419);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(34419);
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bl localbl = (bl)paramList.next();
      if ((localbl.cjM()) && (com.tencent.mm.pluginsdk.model.l.aAH(localbl.field_imgPath)))
      {
        AppMethodBeat.o(34419);
        return true;
      }
    }
    AppMethodBeat.o(34419);
    return false;
  }
  
  public static boolean hy(List<bl> paramList)
  {
    AppMethodBeat.i(34420);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(34420);
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((bl)paramList.next()).cjO())
      {
        AppMethodBeat.o(34420);
        return true;
      }
    }
    AppMethodBeat.o(34420);
    return false;
  }
  
  public static String x(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(34421);
    String str = paramString;
    if (paramBoolean)
    {
      str = paramString;
      if (paramString != null)
      {
        str = paramString;
        if (paramInt == 0) {
          str = bi.ug(paramString);
        }
      }
    }
    AppMethodBeat.o(34421);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.j
 * JD-Core Version:    0.7.0.1
 */