package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ai.v;
import com.tencent.mm.ai.z;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.n;
import com.tencent.mm.am.ag;
import com.tencent.mm.aw.e.a;
import com.tencent.mm.aw.k;
import com.tencent.mm.aw.o.a;
import com.tencent.mm.aw.q;
import com.tencent.mm.g.a.qh;
import com.tencent.mm.g.a.qh.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.i.g.a;
import com.tencent.mm.m.a.a;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.w;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.y.a;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.dsz;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bu.a;
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
  static void a(Context paramContext, final com.tencent.mm.aw.g paramg, bu parambu, int paramInt, final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(34428);
    Object localObject2 = q.aIF().o(com.tencent.mm.aw.h.c(paramg), "", "");
    Object localObject1 = new PString();
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    ((PString)localObject1).value = ((String)localObject2);
    int i = paramg.hZz;
    long l1 = q.aIF().a(parambu.field_talker, (String)localObject2, i, paramInt, (PString)localObject1, localPInt1, localPInt2);
    localObject2 = q.aIF().c(Long.valueOf(l1));
    ((com.tencent.mm.aw.g)localObject2).pr(1);
    bu localbu = new bu();
    localbu.setType(w.As(paramString1));
    localbu.tN(paramString1);
    localbu.kr(1);
    localbu.setStatus(1);
    localbu.tO(((PString)localObject1).value);
    localbu.kB(localPInt1.value);
    localbu.kC(localPInt2.value);
    localbu.qA(com.tencent.mm.model.bj.Bo(localbu.field_talker));
    if (com.tencent.mm.am.g.vd(localbu.field_talker)) {
      parambu.sP(com.tencent.mm.am.a.e.VW());
    }
    ba.aBQ();
    long l2 = com.tencent.mm.model.c.azs().as(localbu);
    if (l2 >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ad.i("MicroMsg.ChattingEditModeLogic", "NetSceneUploadMsgImg: local msgId = ".concat(String.valueOf(l2)));
      ((com.tencent.mm.aw.g)localObject2).sd((int)l2);
      q.aIF().a(Long.valueOf(l1), (com.tencent.mm.aw.g)localObject2);
      localObject1 = new HashMap();
      ((HashMap)localObject1).put(Long.valueOf(l2), paramg);
      q.aIG().a(paramg.dnz, parambu.field_msgId, i, localObject1, 2131231564, new e.a()
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
              paramAnonymousn = (com.tencent.mm.aw.g)paramAnonymousn.getValue();
              paramAnonymousn = q.aIF().o(com.tencent.mm.aw.h.c(paramAnonymousn), "", "");
              if (paramAnonymousInt2 != 0)
              {
                ba.aBQ();
                com.tencent.mm.model.c.azs().xZ(paramAnonymousString.longValue());
                com.tencent.mm.plugin.messenger.a.g.dlD().a(this.val$context, paramString1, paramAnonymousn, paramAnonymousInt1, paramg.hZI, paramString2, paramAnonymousLong2, null);
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
  
  public static void a(Context paramContext, String paramString, bu parambu)
  {
    AppMethodBeat.i(34426);
    if (!a(paramContext, paramString, parambu, "emoji"))
    {
      AppMethodBeat.o(34426);
      return;
    }
    String str = ay.aTS(parambu.field_content).md5;
    if ((str == null) || (str.endsWith("-1"))) {}
    for (parambu = parambu.field_imgPath;; parambu = str)
    {
      if (parambu == null)
      {
        ad.w("MicroMsg.ChattingEditModeLogic", "showAcceptEmojiConnector: filePath is null");
        AppMethodBeat.o(34426);
        return;
      }
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().v(paramContext, paramString, parambu);
      AppMethodBeat.o(34426);
      return;
    }
  }
  
  public static void a(Context paramContext, String paramString, bu parambu, boolean paramBoolean)
  {
    AppMethodBeat.i(34431);
    if (!a(paramContext, paramString, parambu, "text"))
    {
      AppMethodBeat.o(34431);
      return;
    }
    paramContext = x(parambu.field_content, parambu.field_isSend, paramBoolean);
    if ((paramContext == null) || (paramContext.equals("")))
    {
      ad.e("MicroMsg.ChattingEditModeLogic", "Transfer text erro: content null");
      AppMethodBeat.o(34431);
      return;
    }
    com.tencent.mm.plugin.messenger.a.g.dlD().aa(paramString, paramContext, w.Ar(paramString));
    AppMethodBeat.o(34431);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(34435);
    try
    {
      bu localbu = new bu();
      localbu.setContent(paramString2);
      localbu.kr(paramInt);
      paramInt = paramString2.indexOf("<msg>");
      String str = paramString2;
      if (paramInt > 0)
      {
        str = paramString2;
        if (paramInt < paramString2.length()) {
          str = paramString2.substring(paramInt).trim();
        }
      }
      paramString2 = bw.M(str, "msg");
      if ((paramString2 != null) && (paramString2.size() > 0)) {
        localbu.tP(com.tencent.mm.sdk.platformtools.bj.bI(paramString2));
      }
      b(paramContext, paramString1, localbu, paramBoolean);
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
    String str1 = t.Hg(paramString2);
    o.aMJ();
    String str2 = t.Hh(paramString1);
    String str3 = t.Hh(str1);
    paramString1 = t.Hi(paramString1);
    String str4 = t.Hi(str1);
    ad.d("MicroMsg.ChattingEditModeLogic", "copy video: srcFullPath[%s] destFullPath[%s] srcThumbPath[%s] destThumbPath[%s]", new Object[] { str2, str3, paramString1, str4 });
    com.tencent.mm.vfs.i.mz(str2, str3);
    com.tencent.mm.vfs.i.mz(paramString1, str4);
    com.tencent.mm.modelvideo.u.a(str1, paramInt2, paramString2, null, paramInt1, paramString3, paramInt3, (int)paramLong);
    com.tencent.mm.modelvideo.u.Hr(str1);
    AppMethodBeat.o(163284);
  }
  
  static boolean a(Context paramContext, String paramString1, bu parambu, String paramString2)
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
    if (parambu == null)
    {
      ad.w("MicroMsg.ChattingEditModeLogic", "send %s fail, msg is null", new Object[] { paramString2 });
      AppMethodBeat.o(34425);
      return false;
    }
    AppMethodBeat.o(34425);
    return true;
  }
  
  public static boolean a(boolean paramBoolean, List<bu> paramList, String paramString, z paramz)
  {
    AppMethodBeat.i(34404);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ad.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to friend msg error, select item empty");
      AppMethodBeat.o(34404);
      return false;
    }
    int i;
    if ((paramList.size() == 1) && (((paramz != null) && (paramz.azg())) || (paramBoolean)))
    {
      paramList = (bu)paramList.get(0);
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qyO, 0) == 1) {}
      for (i = 1; ((bf(paramList)) && ((i == 0) || (bd(paramList)) || (d(paramList, paramString)))) || (paramList.fph()) || (aS(paramList)) || (aU(paramList)) || (aV(paramList)) || (paramList.getType() == -1879048186) || (paramList.getType() == 318767153) || ((paramList.getType() == 486539313) && (paramBoolean)) || (bc(paramList)) || (aW(paramList)) || (bg(paramList)) || (bb(paramList)) || (aX(paramList)) || (d(paramList, paramBoolean)) || (paramList.getType() == 788529201) || (paramList.getType() == 889192497) || (paramList.getType() == 922746929); i = 0)
      {
        AppMethodBeat.o(34404);
        return false;
      }
      AppMethodBeat.o(34404);
      return true;
    }
    paramList = paramList.iterator();
    boolean bool = true;
    bu localbu;
    if (paramList.hasNext())
    {
      localbu = (bu)paramList.next();
      if (((paramz != null) && (paramz.azg())) || (paramBoolean)) {
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qyO, 0) == 1)
        {
          i = 1;
          label354:
          if ((!localbu.fph()) && (!aS(localbu)) && (!aU(localbu)) && (!aV(localbu)) && (localbu.getType() != -1879048186) && ((localbu.getType() != 486539313) || (!paramBoolean)) && (!bc(localbu)) && (!aW(localbu)) && ((!aY(localbu)) || ((paramz != null) && (paramz.azg()))) && ((!aZ(localbu)) || ((paramz != null) && (paramz.azg()))) && (localbu.getType() != 318767153) && ((!bf(localbu)) || ((i != 0) && (!bd(localbu)) && (!d(localbu, paramString)))) && (!bg(localbu)) && (!bb(localbu)) && (!aX(localbu)) && (!d(localbu, paramBoolean)) && (localbu.getType() != 788529201) && (localbu.getType() != 889192497) && (localbu.getType() != 922746929)) {
            break label668;
          }
          paramList.remove();
          bool = false;
        }
      }
    }
    label668:
    for (;;)
    {
      break;
      i = 0;
      break label354;
      if ((aY(localbu)) || (aZ(localbu)) || (localbu.getType() == 788529201) || (localbu.getType() == 889192497) || (localbu.getType() == 922746929))
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
  
  public static boolean aS(bu parambu)
  {
    AppMethodBeat.i(34397);
    if (parambu == null)
    {
      ad.w("MicroMsg.ChattingEditModeLogic", "check is store emoji error, msg is null");
      AppMethodBeat.o(34397);
      return true;
    }
    if (parambu.frH())
    {
      ay localay = new ay(parambu.field_content);
      parambu = k.b.aA(parambu.field_content, parambu.field_reserved);
      if (parambu != null) {
        break label314;
      }
      parambu = new k.b();
      parambu.hzQ = localay.md5;
    }
    label314:
    for (;;)
    {
      for (parambu = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abr(parambu.hzQ); (parambu != null) && ((parambu.field_catalog == EmojiInfo.OeT) || ((!bt.isNullOrNil(parambu.field_groupId)) && (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abw(parambu.field_groupId)))); parambu = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abr(parambu.field_imgPath))
      {
        AppMethodBeat.o(34397);
        return false;
      }
      if (parambu != null)
      {
        if ((bt.isNullOrNil(parambu.field_app_id)) && (!bt.isNullOrNil(parambu.field_groupId)) && (!parambu.field_groupId.equals(String.valueOf(EmojiGroupInfo.OeL))) && (!parambu.field_groupId.equals(String.valueOf(EmojiGroupInfo.OeK))) && (!parambu.field_groupId.equals(String.valueOf(EmojiGroupInfo.OeM))) && (!parambu.field_groupId.equals(String.valueOf(EmojiInfo.OeN))) && (!parambu.field_groupId.equals("capture"))) {}
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
  
  public static boolean aT(bu parambu)
  {
    AppMethodBeat.i(34398);
    if (parambu.frH())
    {
      ay localay = new ay(parambu.field_content);
      parambu = k.b.aA(parambu.field_content, parambu.field_reserved);
      if (parambu != null) {
        break label99;
      }
      parambu = new k.b();
      parambu.hzQ = localay.md5;
    }
    label99:
    for (;;)
    {
      if (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abr(parambu.hzQ) == null)
      {
        AppMethodBeat.o(34398);
        return false;
      }
      AppMethodBeat.o(34398);
      return true;
    }
  }
  
  public static boolean aU(bu parambu)
  {
    AppMethodBeat.i(34399);
    if (parambu == null)
    {
      ad.w("MicroMsg.ChattingEditModeLogic", "check is game msg error, msg is null");
      AppMethodBeat.o(34399);
      return true;
    }
    if (parambu.field_isSend == 0) {}
    for (parambu = com.tencent.mm.model.bj.Bl(parambu.field_content);; parambu = parambu.field_content)
    {
      parambu = k.b.yr(parambu);
      if (parambu != null) {
        break;
      }
      ad.w("MicroMsg.ChattingEditModeLogic", "parse app message content fail");
      AppMethodBeat.o(34399);
      return false;
    }
    parambu = com.tencent.mm.pluginsdk.model.app.h.m(parambu.appId, false, false);
    if ((parambu != null) && (parambu.Eb()))
    {
      AppMethodBeat.o(34399);
      return true;
    }
    AppMethodBeat.o(34399);
    return false;
  }
  
  public static boolean aV(bu parambu)
  {
    AppMethodBeat.i(34400);
    if (parambu.getType() == 419430449)
    {
      AppMethodBeat.o(34400);
      return true;
    }
    AppMethodBeat.o(34400);
    return false;
  }
  
  public static boolean aW(bu parambu)
  {
    AppMethodBeat.i(34401);
    if ((parambu.getType() == 436207665) || (parambu.getType() == 469762097))
    {
      AppMethodBeat.o(34401);
      return true;
    }
    AppMethodBeat.o(34401);
    return false;
  }
  
  public static boolean aX(bu parambu)
  {
    AppMethodBeat.i(34402);
    if (parambu == null)
    {
      ad.w("MicroMsg.ChattingEditModeLogic", "isAppbrandForbidForwardMsg, check msg error, msg is null");
      AppMethodBeat.o(34402);
      return true;
    }
    if (parambu.field_isSend == 0) {}
    for (parambu = com.tencent.mm.model.bj.Bl(parambu.field_content);; parambu = parambu.field_content)
    {
      parambu = k.b.yr(parambu);
      if (parambu != null) {
        break;
      }
      ad.w("MicroMsg.ChattingEditModeLogic", "isAppbrandForbidForwardMsg, parse app message content fail");
      AppMethodBeat.o(34402);
      return false;
    }
    if ((parambu.hCw != 0) || ((parambu.type == 33) && (parambu.hCp == 3)) || ((parambu.type == 36) && (parambu.hCp == 3)) || ((parambu.type == 46) && (parambu.hCp == 3)) || ((parambu.type == 44) && ((parambu.hCp == 3) || (!parambu.ev(false)))) || ((parambu.type == 48) && (parambu.hCp == 3)))
    {
      AppMethodBeat.o(34402);
      return true;
    }
    AppMethodBeat.o(34402);
    return false;
  }
  
  private static boolean aY(bu parambu)
  {
    AppMethodBeat.i(34405);
    if (parambu != null)
    {
      parambu = k.b.yr(parambu.field_content);
      if ((parambu != null) && (parambu.type == 19))
      {
        Object localObject = new qh();
        ((qh)localObject).dEN.type = 0;
        ((qh)localObject).dEN.dEP = parambu.hAs;
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
        localObject = ((qh)localObject).dEO.dEY;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.protocal.b.a.c)localObject).hDb.iterator();
          while (((Iterator)localObject).hasNext())
          {
            ajn localajn = (ajn)((Iterator)localObject).next();
            if (!bt.isNullOrNil(localajn.Gij))
            {
              ad.e("MicroMsg.ChattingEditModeLogic", "record type subDataItem contain tpurl, type:%d", new Object[] { Integer.valueOf(localajn.dataType) });
              AppMethodBeat.o(34405);
              return true;
            }
          }
        }
        if ((parambu.hAs != null) && (parambu.hAs.contains("<recordxml>")))
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
  
  private static boolean aZ(bu parambu)
  {
    AppMethodBeat.i(34406);
    if (parambu != null)
    {
      parambu = k.b.yr(parambu.field_content);
      if ((parambu != null) && (parambu.type == 24))
      {
        AppMethodBeat.o(34406);
        return true;
      }
    }
    AppMethodBeat.o(34406);
    return false;
  }
  
  public static void b(final Context paramContext, final String paramString, bu parambu)
  {
    AppMethodBeat.i(34427);
    if (!a(paramContext, paramString, parambu, "image"))
    {
      AppMethodBeat.o(34427);
      return;
    }
    Object localObject1 = null;
    if (parambu.field_msgId > 0L) {
      localObject1 = q.aIF().G(parambu.field_talker, parambu.field_msgId);
    }
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((com.tencent.mm.aw.g)localObject1).dnz > 0L) {}
    }
    else
    {
      localObject2 = localObject1;
      if (parambu.field_msgSvrId > 0L) {
        localObject2 = q.aIF().F(parambu.field_talker, parambu.field_msgSvrId);
      }
    }
    if (localObject2 == null)
    {
      AppMethodBeat.o(34427);
      return;
    }
    final int j = 0;
    final int i = j;
    if (((com.tencent.mm.aw.g)localObject2).aIj())
    {
      i = j;
      if (!com.tencent.mm.aw.h.a((com.tencent.mm.aw.g)localObject2).hZw.startsWith("SERVERID://")) {
        i = 1;
      }
    }
    localObject1 = q.aIF().o(com.tencent.mm.aw.h.c((com.tencent.mm.aw.g)localObject2), "", "");
    String str1 = q.aIF().o(((com.tencent.mm.aw.g)localObject2).hZy, "th_", "");
    if ((((com.tencent.mm.aw.g)localObject2).offset < ((com.tencent.mm.aw.g)localObject2).hMP) || (((com.tencent.mm.aw.g)localObject2).hMP == 0))
    {
      final String str2 = com.tencent.mm.model.u.aAm();
      final String str3 = ((com.tencent.mm.aw.g)localObject2).hZI;
      Object localObject3 = bw.M(((com.tencent.mm.aw.g)localObject2).hZI, "msg");
      if (localObject3 == null)
      {
        ad.e("MicroMsg.ChattingEditModeLogic", "parse cdnInfo failed. [%s]", new Object[] { ((com.tencent.mm.aw.g)localObject2).hZI });
        i = 0;
      }
      for (;;)
      {
        if (i == 0) {
          a(paramContext, (com.tencent.mm.aw.g)localObject2, parambu, 4, paramString, str1);
        }
        AppMethodBeat.o(34427);
        return;
        j = ((com.tencent.mm.aw.g)localObject2).hZz;
        if (j != 1) {
          localObject1 = (String)((Map)localObject3).get(".msg.img.$cdnmidimgurl");
        }
        for (i = 2;; i = 1)
        {
          ad.d("MicroMsg.ChattingEditModeLogic", "cdntra read xml  comptype:%d url:[%s]", new Object[] { Integer.valueOf(j), localObject1 });
          if (!bt.isNullOrNil((String)localObject1)) {
            break label375;
          }
          ad.e("MicroMsg.ChattingEditModeLogic", "cdntra get cdnUrlfailed.");
          i = 0;
          break;
          localObject1 = (String)((Map)localObject3).get(".msg.img.$cdnbigimgurl");
        }
        label375:
        String str4 = (String)((Map)localObject3).get(".msg.img.$aeskey");
        if (bt.isNullOrNil(str4))
        {
          ad.e("MicroMsg.ChattingEditModeLogic", "cdntra get aes key failed.");
          i = 0;
        }
        else if (bt.isNullOrNil(com.tencent.mm.ao.c.a("downimg", ((com.tencent.mm.aw.g)localObject2).hZE, parambu.field_talker, parambu.field_msgId)))
        {
          ad.w("MicroMsg.ChattingEditModeLogic", "cdntra genClientId failed not use cdn imgLocalId:%d", new Object[] { Long.valueOf(parambu.field_msgSvrId) });
          i = 0;
        }
        else
        {
          localObject3 = (String)((Map)localObject3).get(".msg.img.$md5");
          com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
          localg.fJi = "task_ChattingEditModeLogic_1";
          localg.fJj = new g.a()
          {
            public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(34390);
              Object localObject2;
              int i;
              Object localObject1;
              String str1;
              String str2;
              int j;
              String str3;
              Object localObject3;
              Object localObject4;
              Object localObject5;
              long l3;
              if (paramAnonymousd != null)
              {
                if (!paramAnonymousd.field_exist_whencheck) {
                  break label770;
                }
                ad.d("MicroMsg.ChattingEditModeLogic", "support second !! sceneResult:[%s]", new Object[] { paramAnonymousd });
                localObject2 = this.hED;
                i = this.obr;
                localObject1 = paramString;
                str1 = str2;
                paramAnonymousString = str3;
                str2 = this.lxP;
                j = j;
                str3 = q.aIF().R(((ei)localObject2).field_imgPath, true);
                localObject3 = new PString();
                localObject4 = new PInt();
                localObject5 = new PInt();
                ((PString)localObject3).value = "";
                paramAnonymousc = new bu();
                paramAnonymousc.setType(w.As((String)localObject1));
                paramAnonymousc.tN((String)localObject1);
                paramAnonymousc.kr(1);
                paramAnonymousc.setStatus(1);
                paramAnonymousc.qA(com.tencent.mm.model.bj.Bo(paramAnonymousc.field_talker));
                paramAnonymousc.setContent(paramAnonymousString);
                a.a.ZG().n(paramAnonymousc);
                l3 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().as(paramAnonymousc);
                if (l3 < 0L) {
                  break label764;
                }
                paramAnonymousBoolean = true;
                Assert.assertTrue(paramAnonymousBoolean);
                ad.i("MicroMsg.ChattingEditModeLogic", "NetSceneUploadMsgImg: local msgId = ".concat(String.valueOf(l3)));
                if (j != 1) {
                  break label833;
                }
              }
              label770:
              label833:
              for (long l1 = q.aIF().a((String)localObject1, null, l3, true, paramAnonymousc.field_content, (PString)localObject3, (PInt)localObject4, (PInt)localObject5);; l1 = 0L)
              {
                long l2 = q.aIF().a((String)localObject1, null, l3, false, paramAnonymousc.field_content, (PString)localObject3, (PInt)localObject4, (PInt)localObject5);
                localObject4 = bw.M(paramAnonymousString, "msg");
                paramAnonymousInt = bt.getInt((String)((Map)localObject4).get(".msg.img.$length"), paramAnonymousd.field_thumbimgLength);
                paramAnonymousString = q.aIF().c(Long.valueOf(l2));
                paramAnonymousString.sd((int)l3);
                if (l2 > 0L)
                {
                  localObject5 = q.aIF().a(((PString)localObject3).value, "th_", "", false);
                  ad.i("MicroMsg.ChattingEditModeLogic", "deal send img for cdn [%s]", new Object[] { localObject5 });
                  com.tencent.mm.vfs.i.mz(str3, (String)localObject5);
                  paramAnonymousc.tO(((PString)localObject3).value);
                  paramAnonymousc.kB(((ei)localObject2).fkr);
                  paramAnonymousc.kC(((ei)localObject2).fks);
                  if (l1 > 0L)
                  {
                    paramAnonymousString.ps(1);
                    paramAnonymousString.po((int)l1);
                    paramAnonymousInt = bt.getInt((String)((Map)localObject4).get(".msg.img.$hdlength"), paramAnonymousd.field_thumbimgLength);
                  }
                }
                for (;;)
                {
                  q.aIF().a(Long.valueOf(l2), paramAnonymousString);
                  if (j == 1) {
                    paramAnonymousString = q.aIF().c(Long.valueOf(l1));
                  }
                  for (;;)
                  {
                    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().a(l3, paramAnonymousc);
                    q.aIF().a(Long.valueOf(l1), paramAnonymousString);
                    localObject3 = com.tencent.mm.ao.c.a("upimg", paramAnonymousc.field_createTime, paramAnonymousc.field_talker, paramAnonymousc.field_msgId + "_" + l1 + "_" + j);
                    localObject2 = new dsz();
                    ((dsz)localObject2).Fvi = new cwt().aPy(str1);
                    ((dsz)localObject2).Fvj = new cwt().aPy((String)localObject1);
                    ((dsz)localObject2).ugm = paramAnonymousc.getType();
                    ((dsz)localObject2).Fvn = paramAnonymousc.eLs;
                    ((dsz)localObject2).FOK = paramAnonymousString.hZA;
                    ((dsz)localObject2).HFH = new cwt().aPy((String)localObject3);
                    ((dsz)localObject2).GAB = j;
                    paramAnonymousd.field_filemd5 = str2;
                    paramAnonymousd.field_thumbimgLength = ((int)com.tencent.mm.vfs.i.aYo(str3));
                    paramAnonymousd.field_fileLength = paramAnonymousInt;
                    localObject1 = com.tencent.mm.aw.c.aIc();
                    ((com.tencent.mm.aw.c)localObject1).gwQ = i;
                    ((com.tencent.mm.aw.c)localObject1).hZg = ((dsz)localObject2);
                    ((com.tencent.mm.aw.c)localObject1).hZh = paramAnonymousString;
                    ((com.tencent.mm.aw.c)localObject1).gwW = paramAnonymousd;
                    ((com.tencent.mm.aw.c)localObject1).hZi = new j.2(l2, l3);
                    ((o.e)localObject1).toUser = paramAnonymousc.field_talker;
                    ((o.e)localObject1).aJv().execute();
                    for (;;)
                    {
                      AppMethodBeat.o(34390);
                      return 0;
                      label764:
                      paramAnonymousBoolean = false;
                      break;
                      ad.d("MicroMsg.ChattingEditModeLogic", "not support second !! dealDownLoadImg");
                      paramAnonymousString = q.aIF().o(this.ibs.hZy, "th_", "");
                      j.a(paramContext, this.ibs, this.hED, this.obr, paramString, paramAnonymousString);
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
          localg.field_mediaId = com.tencent.mm.ao.c.a("checkExist", bt.flT(), paramString, parambu.field_msgId);
          localg.field_fileId = ((String)localObject1);
          localg.field_aesKey = str4;
          localg.field_filemd5 = ((String)localObject3);
          localg.field_fileType = i;
          localg.field_talker = paramString;
          localg.field_priority = com.tencent.mm.i.a.fIw;
          localg.field_svr_signature = "";
          localg.field_onlycheckexist = true;
          localg.field_trysafecdn = true;
          if (!com.tencent.mm.ao.f.aGI().f(localg))
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
      com.tencent.mm.plugin.messenger.a.g.dlD().a(paramContext, paramString, (String)localObject1, i, ((com.tencent.mm.aw.g)localObject2).hZI, str1, parambu.field_msgId, null);
    }
    AppMethodBeat.o(34427);
  }
  
  public static void b(Context paramContext, String paramString, bu parambu, boolean paramBoolean)
  {
    AppMethodBeat.i(34432);
    if (!a(paramContext, paramString, parambu, "appmsg"))
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
    if (parambu == null)
    {
      ad.w("MicroMsg.ChattingEditModeLogic", "getReaderAppMsgContent: msg is null");
      AppMethodBeat.o(34432);
      return;
    }
    ba.aBQ();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      AppMethodBeat.o(34432);
      return;
    }
    paramContext = q.aIF().c(parambu.field_imgPath, false, false);
    if ((!af.isNullOrNil(paramContext)) && (!paramContext.endsWith("hd")) && (com.tencent.mm.vfs.i.fv(paramContext + "hd"))) {
      paramContext = paramContext + "hd";
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject1 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(parambu.field_msgId, parambu.field_content);
        localObject2 = ((com.tencent.mm.ai.u)localObject1).hDb;
        if ((localObject2 == null) || (((List)localObject2).size() <= 0))
        {
          if ((parambu == null) || ((!parambu.cTc()) && (!parambu.fpd()))) {
            break label759;
          }
          localObject1 = y.AH(parambu.field_msgSvrId);
          localObject2 = y.aBq().F((String)localObject1, true);
          ((y.b)localObject2).k("prePublishId", "msg_" + parambu.field_msgSvrId);
          ((y.b)localObject2).k("preUsername", com.tencent.mm.ui.chatting.viewitems.c.a(parambu, paramBoolean, false));
          ((y.b)localObject2).k("preChatName", parambu.field_talker);
          ((y.b)localObject2).k("preMsgIndex", Integer.valueOf(0));
          ((y.b)localObject2).k("sendAppMsgScene", Integer.valueOf(1));
          ((com.tencent.mm.plugin.sns.b.j)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.sns.b.j.class)).a("adExtStr", (y.b)localObject2, parambu);
          com.tencent.mm.plugin.messenger.a.g.dlD().a(paramString, bt.readFromFile(paramContext), bt.aRd(parambu.field_content), (String)localObject1);
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
      parambu = ((List)localObject2).iterator();
      while (parambu.hasNext())
      {
        Object localObject3 = (v)parambu.next();
        localObject2 = new k.b();
        if (com.tencent.mm.ai.m.yt(((v)localObject3).hDr))
        {
          l.b(paramString, l.a(paramString, (v)localObject3), ((v)localObject3).hDw);
        }
        else
        {
          ((k.b)localObject2).title = ((v)localObject3).title;
          ((k.b)localObject2).description = ((v)localObject3).hDo;
          ((k.b)localObject2).action = "view";
          ((k.b)localObject2).type = 5;
          ((k.b)localObject2).url = ((v)localObject3).url;
          ((k.b)localObject2).dHo = ((com.tencent.mm.ai.u)localObject1).dHo;
          ((k.b)localObject2).dHp = ((com.tencent.mm.ai.u)localObject1).dHp;
          ((k.b)localObject2).fkq = ((com.tencent.mm.ai.u)localObject1).fkq;
          ((k.b)localObject2).thumburl = com.tencent.mm.ai.m.a((v)localObject3);
          com.tencent.mm.ai.e locale = new com.tencent.mm.ai.e();
          locale.hzh = ((v)localObject3).type;
          locale.hzk = ((v)localObject3).hzk;
          if (((v)localObject3).type == 5)
          {
            locale.hzm = ((v)localObject3).hzm;
            locale.hzi = ((int)((v)localObject3).time);
            locale.duration = ((v)localObject3).hDq;
            locale.videoWidth = ((v)localObject3).videoWidth;
            locale.videoHeight = ((v)localObject3).videoHeight;
          }
          ((k.b)localObject2).a(locale);
          if ((bt.isNullOrNil(((k.b)localObject2).thumburl)) && (!bt.isNullOrNil(((k.b)localObject2).dHo)))
          {
            localObject3 = p.aEx().Dj(((k.b)localObject2).dHo);
            if (localObject3 != null) {
              ((k.b)localObject2).thumburl = ((com.tencent.mm.ak.i)localObject3).aEq();
            }
          }
          localObject2 = k.b.a((k.b)localObject2, null, null);
          com.tencent.mm.plugin.messenger.a.g.dlD().a(paramString, bt.readFromFile(paramContext), bt.aRd((String)localObject2), null);
        }
      }
      AppMethodBeat.o(34432);
      return;
      label759:
      Object localObject1 = null;
    }
  }
  
  public static boolean ba(bu parambu)
  {
    AppMethodBeat.i(34407);
    if (parambu != null)
    {
      parambu = k.b.yr(parambu.field_content);
      if (parambu == null)
      {
        AppMethodBeat.o(34407);
        return false;
      }
      if ((parambu.type == 6) || (parambu.type == 5) || (parambu.type == 19))
      {
        AppMethodBeat.o(34407);
        return true;
      }
    }
    AppMethodBeat.o(34407);
    return false;
  }
  
  public static boolean bb(bu parambu)
  {
    AppMethodBeat.i(34408);
    if ((parambu == null) || (!parambu.fpd()))
    {
      AppMethodBeat.o(34408);
      return false;
    }
    boolean bool = com.tencent.mm.ai.m.c(parambu.field_msgId, parambu.field_content);
    AppMethodBeat.o(34408);
    return bool;
  }
  
  static boolean bc(bu parambu)
  {
    AppMethodBeat.i(34409);
    if (parambu != null)
    {
      parambu = k.b.yr(parambu.field_content);
      if ((parambu != null) && (parambu.type == 16))
      {
        AppMethodBeat.o(34409);
        return true;
      }
      if ((parambu != null) && (parambu.type == 34))
      {
        AppMethodBeat.o(34409);
        return true;
      }
    }
    AppMethodBeat.o(34409);
    return false;
  }
  
  public static boolean bd(bu parambu)
  {
    AppMethodBeat.i(34412);
    ba.aBQ();
    bu.a locala = com.tencent.mm.model.c.azs().aqk(parambu.field_content);
    if ((locala.dHm == null) || (locala.dHm.length() <= 0)) {
      ad.e("MicroMsg.ChattingEditModeLogic", "getView : parse possible friend msg failed");
    }
    if ((!w.on(locala.DKi)) && (parambu.getType() == 42))
    {
      boolean bool = parambu.frV();
      AppMethodBeat.o(34412);
      return bool;
    }
    AppMethodBeat.o(34412);
    return false;
  }
  
  public static boolean be(bu parambu)
  {
    AppMethodBeat.i(34413);
    ba.aBQ();
    bu.a locala = com.tencent.mm.model.c.azs().aqk(parambu.field_content);
    if ((locala.dHm == null) || (locala.dHm.length() <= 0)) {
      ad.e("MicroMsg.ChattingEditModeLogic", "getView : parse possible friend msg failed");
    }
    if ((!w.on(locala.DKi)) && (parambu.getType() == 42))
    {
      if ((parambu.eLr & 0x800) > 0)
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
  
  static boolean bf(bu parambu)
  {
    AppMethodBeat.i(34414);
    if (!parambu.frE())
    {
      AppMethodBeat.o(34414);
      return false;
    }
    ba.aBQ();
    parambu = com.tencent.mm.model.c.azs().aqk(parambu.field_content);
    if ((parambu == null) || (bt.isNullOrNil(parambu.dHm)))
    {
      AppMethodBeat.o(34414);
      return true;
    }
    if (w.zE(parambu.dHm))
    {
      AppMethodBeat.o(34414);
      return false;
    }
    AppMethodBeat.o(34414);
    return true;
  }
  
  private static boolean bg(bu parambu)
  {
    AppMethodBeat.i(193843);
    if ((parambu != null) && (parambu.cTc()))
    {
      parambu = k.b.yr(parambu.field_content);
      if ((parambu != null) && (parambu.type == 6) && (parambu.hzO >= 1073741824))
      {
        AppMethodBeat.o(193843);
        return true;
      }
    }
    AppMethodBeat.o(193843);
    return false;
  }
  
  public static boolean bh(bu parambu)
  {
    AppMethodBeat.i(34416);
    if ((parambu != null) && (parambu.cTc()))
    {
      parambu = k.b.yr(parambu.field_content);
      if ((parambu != null) && (parambu.type == 6))
      {
        AppMethodBeat.o(34416);
        return true;
      }
    }
    AppMethodBeat.o(34416);
    return false;
  }
  
  public static void c(Context paramContext, final String paramString, final bu parambu)
  {
    AppMethodBeat.i(34430);
    if ((!a(paramContext, paramString, parambu, "video")) || (parambu == null))
    {
      AppMethodBeat.o(34430);
      return;
    }
    if ((parambu != null) && (parambu.cxh()) && (com.tencent.mm.modelvideo.u.HA(parambu.field_imgPath)))
    {
      AppMethodBeat.o(34430);
      return;
    }
    Object localObject = com.tencent.mm.modelvideo.u.Hy(parambu.field_imgPath);
    if ((localObject != null) && (((com.tencent.mm.modelvideo.s)localObject).status == 199))
    {
      a(parambu.field_imgPath, paramString, ((com.tencent.mm.modelvideo.s)localObject).iui, ((com.tencent.mm.modelvideo.s)localObject).hHQ, ((com.tencent.mm.modelvideo.s)localObject).aMV(), parambu.getType(), parambu.field_msgId);
      AppMethodBeat.o(34430);
      return;
    }
    Map localMap = bw.M(((com.tencent.mm.modelvideo.s)localObject).aMV(), "msg");
    final int i;
    if (localMap == null)
    {
      ad.w("MicroMsg.ChattingEditModeLogic", "%s cdntra parse video recv xml failed");
      i = 0;
    }
    for (;;)
    {
      if (i == 0) {
        f(paramString, parambu);
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
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1328L, 12L, 1L, true);
        if (bt.isNullOrNil(str2))
        {
          o.aMJ();
          if (!com.tencent.mm.vfs.i.fv(t.Hh(((com.tencent.mm.modelvideo.s)localObject).getFileName())))
          {
            ad.i("MicroMsg.ChattingEditModeLogic", "checkVideoCdnInfo md5 %s", new Object[] { str2 });
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1328L, 2L, 1L, true);
            i = 0;
            continue;
          }
        }
        localObject = new com.tencent.mm.i.g();
        ((com.tencent.mm.i.g)localObject).fJi = "task_ChattingEditModeLogic_2";
        ((com.tencent.mm.i.g)localObject).fJj = new g.a()
        {
          public final int a(final String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(34394);
            if (paramAnonymousd != null)
            {
              if (!paramAnonymousd.field_exist_whencheck) {
                break label369;
              }
              paramAnonymousd.field_fileId = this.val$url;
              paramAnonymousd.field_aesKey = str1;
              paramAnonymousd.field_thumbimgLength = k;
              paramAnonymousd.field_fileLength = i;
              paramAnonymousd.field_toUser = paramString;
              paramAnonymousd.field_filemd5 = str2;
              paramAnonymousd.field_mp4identifymd5 = str3;
              ad.i("MicroMsg.ChattingEditModeLogic", "support second!! sceneResult: %s", new Object[] { paramAnonymousd });
              paramAnonymousString = t.Hg(paramString);
              o.aMJ();
              paramAnonymousc = t.Hi(paramAnonymousString);
              o.aMJ();
              com.tencent.mm.vfs.i.mz(t.Hi(parambu.field_imgPath), paramAnonymousc);
              paramAnonymousc = "<msg><videomsg aeskey=\"" + str1 + "\" cdnthumbaeskey=\"" + str1 + "\" cdnvideourl=\"" + this.val$url + "\" ";
              paramAnonymousc = paramAnonymousc + "cdnthumburl=\"" + this.val$url + "\" ";
              paramAnonymousc = paramAnonymousc + "length=\"" + i + "\" ";
              paramAnonymousc = paramAnonymousc + "cdnthumblength=\"" + k + "\"/></msg>";
              ad.i("MicroMsg.ChattingEditModeLogic", "cdn callback new build cdnInfo:%s", new Object[] { paramAnonymousc });
              com.tencent.mm.modelvideo.u.b(paramAnonymousString, j, paramString, paramAnonymousc, (int)parambu.field_msgId);
              paramAnonymousc = com.tencent.mm.aw.s.aIM();
              paramAnonymousc.fileName = paramAnonymousString;
              paramAnonymousc.icN = 0;
              paramAnonymousc.icO = paramAnonymousd;
              paramAnonymousc.icP = new com.tencent.mm.aw.f()
              {
                public final void dg(int paramAnonymous2Int1, int paramAnonymous2Int2)
                {
                  AppMethodBeat.i(34393);
                  com.tencent.mm.modelvideo.s locals = com.tencent.mm.modelvideo.u.Hy(paramAnonymousString);
                  locals.status = 111;
                  locals.dDp = 256;
                  o.aMJ().c(locals);
                  ad.d("MicroMsg.ChattingEditModeLogic", "NetSceneUploadVideoForCdn callback, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
                  AppMethodBeat.o(34393);
                }
              };
              paramAnonymousc.igc = 4;
              paramAnonymousc.aJv().execute();
            }
            for (;;)
            {
              AppMethodBeat.o(34394);
              return 0;
              label369:
              j.f(paramString, parambu);
            }
          }
          
          public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
          
          public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
          {
            return new byte[0];
          }
        };
        ((com.tencent.mm.i.g)localObject).field_mediaId = com.tencent.mm.ao.c.a("checkExist", bt.flT(), paramString, parambu.field_msgId);
        ((com.tencent.mm.i.g)localObject).field_fileId = paramContext;
        ((com.tencent.mm.i.g)localObject).field_aesKey = str1;
        ((com.tencent.mm.i.g)localObject).field_filemd5 = str2;
        ((com.tencent.mm.i.g)localObject).field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
        ((com.tencent.mm.i.g)localObject).field_talker = paramString;
        ((com.tencent.mm.i.g)localObject).field_priority = com.tencent.mm.i.a.fIw;
        ((com.tencent.mm.i.g)localObject).field_svr_signature = "";
        ((com.tencent.mm.i.g)localObject).field_onlycheckexist = true;
        ((com.tencent.mm.i.g)localObject).field_trysafecdn = true;
        if (!com.tencent.mm.ao.f.aGI().f((com.tencent.mm.i.g)localObject))
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
  
  public static void c(Context paramContext, String paramString, bu parambu, boolean paramBoolean)
  {
    AppMethodBeat.i(34433);
    if (!a(paramContext, paramString, parambu, "location"))
    {
      AppMethodBeat.o(34433);
      return;
    }
    paramContext = x(parambu.field_content, parambu.field_isSend, paramBoolean);
    com.tencent.mm.plugin.messenger.a.g.dlD().aa(paramString, paramContext, 48);
    AppMethodBeat.o(34433);
  }
  
  public static void c(EmojiInfo paramEmojiInfo, String paramString)
  {
    AppMethodBeat.i(34436);
    WXMediaMessage localWXMediaMessage = new WXMediaMessage();
    String str = paramEmojiInfo.gzQ();
    if (com.tencent.mm.vfs.i.aYo(str + "_thumb") > 0L)
    {
      int i = (int)com.tencent.mm.vfs.i.aYo(str + "_thumb");
      localWXMediaMessage.thumbData = com.tencent.mm.vfs.i.aY(str + "_thumb", 0, i);
    }
    for (;;)
    {
      localWXMediaMessage.mediaObject = new WXEmojiObject(str);
      com.tencent.mm.pluginsdk.model.app.m.a(localWXMediaMessage, paramEmojiInfo.field_app_id, null, paramString, 1, paramEmojiInfo.Lb());
      AppMethodBeat.o(34436);
      return;
      try
      {
        InputStream localInputStream = com.tencent.mm.vfs.i.openRead(str);
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
  
  private static boolean d(bu parambu, String paramString)
  {
    AppMethodBeat.i(34411);
    ba.aBQ();
    bu.a locala = com.tencent.mm.model.c.azs().aqk(parambu.field_content);
    if ((locala.dHm == null) || (locala.dHm.length() <= 0))
    {
      ad.e("MicroMsg.ChattingEditModeLogic", "getView : parse possible friend msg failed");
      AppMethodBeat.o(34411);
      return false;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qyO, 0) == 1) {}
    for (int i = 1; (i != 0) && ((am.aSQ(paramString)) || (am.aSR(paramString)) || (parambu.getType() == 66)); i = 0)
    {
      AppMethodBeat.o(34411);
      return true;
    }
    AppMethodBeat.o(34411);
    return false;
  }
  
  private static boolean d(bu parambu, boolean paramBoolean)
  {
    AppMethodBeat.i(34410);
    if (!paramBoolean)
    {
      AppMethodBeat.o(34410);
      return false;
    }
    if (parambu != null)
    {
      parambu = k.b.yr(parambu.field_content);
      if ((parambu != null) && (parambu.type == 33) && (parambu.hCp == 1))
      {
        AppMethodBeat.o(34410);
        return true;
      }
    }
    AppMethodBeat.o(34410);
    return false;
  }
  
  static void f(final String paramString, bu parambu)
  {
    AppMethodBeat.i(34429);
    ba.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34396);
        o.aMO().a(this.hED.field_imgPath, new t.a()
        {
          public final void a(t.a.a paramAnonymous2a)
          {
            AppMethodBeat.i(34395);
            paramAnonymous2a = com.tencent.mm.modelvideo.u.Hy(paramAnonymous2a.fileName);
            if ((paramAnonymous2a != null) && (paramAnonymous2a.status == 199)) {
              j.a(j.5.this.hED.field_imgPath, j.5.this.fNr, paramAnonymous2a.iui, paramAnonymous2a.hHQ, paramAnonymous2a.aMV(), j.5.this.hED.getType(), j.5.this.hED.field_msgId);
            }
            AppMethodBeat.o(34395);
          }
        });
        AppMethodBeat.o(34396);
      }
    });
    AppMethodBeat.o(34429);
  }
  
  public static List<String> fBk()
  {
    AppMethodBeat.i(34422);
    Object localObject1 = ag.aFZ().oW(25);
    Object localObject2 = ag.aFZ();
    Object localObject3 = new ArrayList();
    Object localObject4 = new StringBuilder();
    com.tencent.mm.am.f.a((StringBuilder)localObject4);
    com.tencent.mm.am.f.c((StringBuilder)localObject4);
    com.tencent.mm.am.f.d((StringBuilder)localObject4);
    com.tencent.mm.am.f.a((StringBuilder)localObject4, true);
    ((StringBuilder)localObject4).append(" order by ");
    ((StringBuilder)localObject4).append(com.tencent.mm.am.f.aFv());
    localObject4 = ((StringBuilder)localObject4).toString();
    ad.i("MicroMsg.BizInfoStorage", "getEnterpriseBizChatLst sql %s", new Object[] { localObject4 });
    localObject2 = ((com.tencent.mm.am.f)localObject2).rawQuery((String)localObject4, new String[0]);
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
      str = com.tencent.mm.am.g.eS((String)localObject4).Kv();
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
      if (com.tencent.mm.am.g.DO(str))
      {
        if (com.tencent.mm.am.g.DS(str))
        {
          str = com.tencent.mm.am.g.eS(str).field_enterpriseFather;
          if ((!((List)localObject4).contains(str)) && (com.tencent.mm.am.g.DQ(str)))
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
  
  public static List<String> fBl()
  {
    AppMethodBeat.i(34423);
    Object localObject = ag.aFZ().oW(25);
    LinkedList localLinkedList = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!com.tencent.mm.am.g.DO(str)) {
        localLinkedList.add(str);
      }
    }
    ad.d("MicroMsg.ChattingEditModeLogic", "get selected accept list without enterprise, size %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    AppMethodBeat.o(34423);
    return localLinkedList;
  }
  
  public static boolean hT(List<bu> paramList)
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
      bu localbu = (bu)paramList.next();
      if ((localbu.fph()) || (aS(localbu)) || (localbu.frE()) || (aU(localbu)) || (aV(localbu)) || (localbu.getType() == -1879048186) || (bc(localbu)) || (aW(localbu)) || (bb(localbu)) || (aX(localbu)) || (bh(localbu)))
      {
        AppMethodBeat.o(34403);
        return true;
      }
    }
    AppMethodBeat.o(34403);
    return false;
  }
  
  public static int hU(List<bu> paramList)
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
      bu localbu = (bu)paramList.next();
      if ((!localbu.fph()) && (!aS(localbu)) && (!localbu.cTe()) && (!aU(localbu)) && (!aV(localbu)) && (!aW(localbu))) {
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
  
  public static boolean hV(List<bu> paramList)
  {
    AppMethodBeat.i(34418);
    if (paramList == null)
    {
      ad.w("MicroMsg.ChattingEditModeLogic", "check contain undownload file, select item empty");
      AppMethodBeat.o(34418);
      return false;
    }
    Iterator localIterator = paramList.iterator();
    label390:
    label391:
    for (;;)
    {
      bu localbu;
      if (localIterator.hasNext())
      {
        localbu = (bu)localIterator.next();
        if ((localbu.fpi()) || (localbu.frK()))
        {
          paramList = null;
          if (localbu.field_msgId > 0L) {
            paramList = q.aIF().G(localbu.field_talker, localbu.field_msgId);
          }
          if (((paramList != null) && (paramList.dnz > 0L)) || (localbu.field_msgSvrId <= 0L)) {
            break label390;
          }
          paramList = q.aIF().F(localbu.field_talker, localbu.field_msgSvrId);
        }
      }
      for (;;)
      {
        if ((paramList == null) || ((paramList.offset >= paramList.hMP) && (paramList.hMP != 0))) {
          break label391;
        }
        AppMethodBeat.o(34418);
        return true;
        if (localbu.cxf())
        {
          paramList = o.aMJ().Hb(localbu.field_imgPath);
          if ((paramList == null) || (paramList.status == 199) || (paramList.status == 199)) {
            break;
          }
          AppMethodBeat.o(34418);
          return true;
        }
        if (localbu.frH())
        {
          if (aT(localbu)) {
            break;
          }
          AppMethodBeat.o(34418);
          return true;
        }
        if (localbu.cTc())
        {
          paramList = k.b.aA(localbu.field_content, localbu.field_content);
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
            paramList = ao.bIX().aLD(paramList.dks);
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
        if (!localbu.cxh()) {
          break;
        }
        paramList = com.tencent.mm.modelvideo.u.Hy(localbu.field_imgPath);
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
  
  public static boolean hW(List<bu> paramList)
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
      bu localbu = (bu)paramList.next();
      if ((localbu.cxf()) && (com.tencent.mm.pluginsdk.model.l.aLz(localbu.field_imgPath)))
      {
        AppMethodBeat.o(34419);
        return true;
      }
    }
    AppMethodBeat.o(34419);
    return false;
  }
  
  public static boolean hX(List<bu> paramList)
  {
    AppMethodBeat.i(34420);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(34420);
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((bu)paramList.next()).cxh())
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
          str = com.tencent.mm.model.bj.Bl(paramString);
        }
      }
    }
    AppMethodBeat.o(34421);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.j
 * JD-Core Version:    0.7.0.1
 */