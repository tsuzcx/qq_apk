package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.n;
import com.tencent.mm.al.ag;
import com.tencent.mm.av.e.a;
import com.tencent.mm.av.o.a;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.qi;
import com.tencent.mm.g.a.qi.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.i.g.a;
import com.tencent.mm.m.a.a;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.x;
import com.tencent.mm.model.z.b;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.e;
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
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.dtw;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bv.a;
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

public final class k
{
  static void a(Context paramContext, final com.tencent.mm.av.g paramg, bv parambv, int paramInt, final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(34428);
    Object localObject2 = q.aIX().o(com.tencent.mm.av.h.c(paramg), "", "");
    Object localObject1 = new PString();
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    ((PString)localObject1).value = ((String)localObject2);
    int i = paramg.icr;
    long l1 = q.aIX().a(parambv.field_talker, (String)localObject2, i, paramInt, (PString)localObject1, localPInt1, localPInt2);
    localObject2 = q.aIX().c(Long.valueOf(l1));
    ((com.tencent.mm.av.g)localObject2).pu(1);
    bv localbv = new bv();
    localbv.setType(x.Bc(paramString1));
    localbv.ui(paramString1);
    localbv.kt(1);
    localbv.setStatus(1);
    localbv.uj(((PString)localObject1).value);
    localbv.kD(localPInt1.value);
    localbv.kE(localPInt2.value);
    localbv.qN(bl.BQ(localbv.field_talker));
    if (com.tencent.mm.al.g.vz(localbv.field_talker)) {
      parambv.tk(com.tencent.mm.al.a.e.We());
    }
    bc.aCg();
    long l2 = com.tencent.mm.model.c.azI().ar(localbv);
    if (l2 >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ae.i("MicroMsg.ChattingEditModeLogic", "NetSceneUploadMsgImg: local msgId = ".concat(String.valueOf(l2)));
      ((com.tencent.mm.av.g)localObject2).sq((int)l2);
      q.aIX().a(Long.valueOf(l1), (com.tencent.mm.av.g)localObject2);
      localObject1 = new HashMap();
      ((HashMap)localObject1).put(Long.valueOf(l2), paramg);
      q.aIY().a(paramg.doE, parambv.field_msgId, i, localObject1, 2131231564, new e.a()
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
              paramAnonymousn = (com.tencent.mm.av.g)paramAnonymousn.getValue();
              paramAnonymousn = q.aIX().o(com.tencent.mm.av.h.c(paramAnonymousn), "", "");
              if (paramAnonymousInt2 != 0)
              {
                bc.aCg();
                com.tencent.mm.model.c.azI().yt(paramAnonymousString.longValue());
                com.tencent.mm.plugin.messenger.a.g.doC().a(this.val$context, paramString1, paramAnonymousn, paramAnonymousInt1, paramg.icA, paramString2, paramAnonymousLong2, null);
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
  
  public static void a(Context paramContext, String paramString, bv parambv)
  {
    AppMethodBeat.i(34426);
    if (!a(paramContext, paramString, parambv, "emoji"))
    {
      AppMethodBeat.o(34426);
      return;
    }
    String str = az.aVt(parambv.field_content).md5;
    if ((str == null) || (str.endsWith("-1"))) {}
    for (parambv = parambv.field_imgPath;; parambv = str)
    {
      if (parambv == null)
      {
        ae.w("MicroMsg.ChattingEditModeLogic", "showAcceptEmojiConnector: filePath is null");
        AppMethodBeat.o(34426);
        return;
      }
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().v(paramContext, paramString, parambv);
      AppMethodBeat.o(34426);
      return;
    }
  }
  
  public static void a(Context paramContext, String paramString, bv parambv, boolean paramBoolean)
  {
    AppMethodBeat.i(34431);
    if (!a(paramContext, paramString, parambv, "text"))
    {
      AppMethodBeat.o(34431);
      return;
    }
    paramContext = x(parambv.field_content, parambv.field_isSend, paramBoolean);
    if ((paramContext == null) || (paramContext.equals("")))
    {
      ae.e("MicroMsg.ChattingEditModeLogic", "Transfer text erro: content null");
      AppMethodBeat.o(34431);
      return;
    }
    com.tencent.mm.plugin.messenger.a.g.doC().aa(paramString, paramContext, x.Bb(paramString));
    AppMethodBeat.o(34431);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(34435);
    try
    {
      bv localbv = new bv();
      localbv.setContent(paramString2);
      localbv.kt(paramInt);
      paramInt = paramString2.indexOf("<msg>");
      String str = paramString2;
      if (paramInt > 0)
      {
        str = paramString2;
        if (paramInt < paramString2.length()) {
          str = paramString2.substring(paramInt).trim();
        }
      }
      paramString2 = bx.M(str, "msg");
      if ((paramString2 != null) && (paramString2.size() > 0)) {
        localbv.uk(bk.bO(paramString2));
      }
      b(paramContext, paramString1, localbv, paramBoolean);
      AppMethodBeat.o(34435);
      return;
    }
    catch (Exception paramContext)
    {
      ae.printErrStackTrace("MicroMsg.ChattingEditModeLogic", paramContext, "", new Object[0]);
      ae.e("MicroMsg.ChattingEditModeLogic", "retransmit sigle app msg error : %s", new Object[] { paramContext.getLocalizedMessage() });
      AppMethodBeat.o(34435);
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(163284);
    ae.d("MicroMsg.ChattingEditModeLogic", "copy video fileName %s userName %s export %d videoLength %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    String str1 = t.HI(paramString2);
    com.tencent.mm.modelvideo.o.aNh();
    String str2 = t.HJ(paramString1);
    String str3 = t.HJ(str1);
    paramString1 = t.HK(paramString1);
    String str4 = t.HK(str1);
    ae.d("MicroMsg.ChattingEditModeLogic", "copy video: srcFullPath[%s] destFullPath[%s] srcThumbPath[%s] destThumbPath[%s]", new Object[] { str2, str3, paramString1, str4 });
    com.tencent.mm.vfs.o.mF(str2, str3);
    com.tencent.mm.vfs.o.mF(paramString1, str4);
    com.tencent.mm.modelvideo.u.a(str1, paramInt2, paramString2, null, paramInt1, paramString3, paramInt3, (int)paramLong);
    com.tencent.mm.modelvideo.u.HT(str1);
    AppMethodBeat.o(163284);
  }
  
  static boolean a(Context paramContext, String paramString1, bv parambv, String paramString2)
  {
    AppMethodBeat.i(34425);
    if (paramContext == null)
    {
      ae.w("MicroMsg.ChattingEditModeLogic", "send %s fail, context is null", new Object[] { paramString2 });
      AppMethodBeat.o(34425);
      return false;
    }
    if (bu.isNullOrNil(paramString1))
    {
      ae.w("MicroMsg.ChattingEditModeLogic", "send %s fail, username is null", new Object[] { paramString2 });
      AppMethodBeat.o(34425);
      return false;
    }
    if (parambv == null)
    {
      ae.w("MicroMsg.ChattingEditModeLogic", "send %s fail, msg is null", new Object[] { paramString2 });
      AppMethodBeat.o(34425);
      return false;
    }
    AppMethodBeat.o(34425);
    return true;
  }
  
  public static boolean a(boolean paramBoolean, List<bv> paramList, String paramString, com.tencent.mm.ah.z paramz)
  {
    AppMethodBeat.i(34404);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ae.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to friend msg error, select item empty");
      AppMethodBeat.o(34404);
      return false;
    }
    int i;
    if ((paramList.size() == 1) && (((paramz != null) && (paramz.azv())) || (paramBoolean)))
    {
      paramList = (bv)paramList.get(0);
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFU, 0) == 1) {}
      for (i = 1; ((be(paramList)) && ((i == 0) || (bc(paramList)) || (e(paramList, paramString)))) || (paramList.ftf()) || (aR(paramList)) || (aT(paramList)) || (aU(paramList)) || (paramList.getType() == -1879048186) || (paramList.getType() == 318767153) || ((paramList.getType() == 486539313) && (paramBoolean)) || (bb(paramList)) || (aV(paramList)) || (bf(paramList)) || (ba(paramList)) || (aW(paramList)) || (e(paramList, paramBoolean)) || (paramList.getType() == 788529201) || (paramList.getType() == 889192497) || (paramList.getType() == 922746929); i = 0)
      {
        AppMethodBeat.o(34404);
        return false;
      }
      AppMethodBeat.o(34404);
      return true;
    }
    paramList = paramList.iterator();
    boolean bool = true;
    bv localbv;
    if (paramList.hasNext())
    {
      localbv = (bv)paramList.next();
      if (((paramz != null) && (paramz.azv())) || (paramBoolean)) {
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFU, 0) == 1)
        {
          i = 1;
          label354:
          if ((!localbv.ftf()) && (!aR(localbv)) && (!aT(localbv)) && (!aU(localbv)) && (localbv.getType() != -1879048186) && ((localbv.getType() != 486539313) || (!paramBoolean)) && (!bb(localbv)) && (!aV(localbv)) && ((!aX(localbv)) || ((paramz != null) && (paramz.azv()))) && ((!aY(localbv)) || ((paramz != null) && (paramz.azv()))) && (localbv.getType() != 318767153) && ((!be(localbv)) || ((i != 0) && (!bc(localbv)) && (!e(localbv, paramString)))) && (!bf(localbv)) && (!ba(localbv)) && (!aW(localbv)) && (!e(localbv, paramBoolean)) && (localbv.getType() != 788529201) && (localbv.getType() != 889192497) && (localbv.getType() != 922746929)) {
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
      if ((aX(localbv)) || (aY(localbv)) || (localbv.getType() == 788529201) || (localbv.getType() == 889192497) || (localbv.getType() == 922746929))
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
  
  public static boolean aR(bv parambv)
  {
    AppMethodBeat.i(34397);
    if (parambv == null)
    {
      ae.w("MicroMsg.ChattingEditModeLogic", "check is store emoji error, msg is null");
      AppMethodBeat.o(34397);
      return true;
    }
    if (parambv.fvH())
    {
      az localaz = new az(parambv.field_content);
      parambv = k.b.aB(parambv.field_content, parambv.field_reserved);
      if (parambv != null) {
        break label314;
      }
      parambv = new k.b();
      parambv.hCE = localaz.md5;
    }
    label314:
    for (;;)
    {
      for (parambv = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aci(parambv.hCE); (parambv != null) && ((parambv.field_catalog == EmojiInfo.OAa) || ((!bu.isNullOrNil(parambv.field_groupId)) && (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().acn(parambv.field_groupId)))); parambv = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aci(parambv.field_imgPath))
      {
        AppMethodBeat.o(34397);
        return false;
      }
      if (parambv != null)
      {
        if ((bu.isNullOrNil(parambv.field_app_id)) && (!bu.isNullOrNil(parambv.field_groupId)) && (!parambv.field_groupId.equals(String.valueOf(EmojiGroupInfo.OzS))) && (!parambv.field_groupId.equals(String.valueOf(EmojiGroupInfo.OzR))) && (!parambv.field_groupId.equals(String.valueOf(EmojiGroupInfo.OzT))) && (!parambv.field_groupId.equals(String.valueOf(EmojiInfo.OzU))) && (!parambv.field_groupId.equals("capture"))) {}
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
  
  public static boolean aS(bv parambv)
  {
    AppMethodBeat.i(34398);
    if (parambv.fvH())
    {
      az localaz = new az(parambv.field_content);
      parambv = k.b.aB(parambv.field_content, parambv.field_reserved);
      if (parambv != null) {
        break label99;
      }
      parambv = new k.b();
      parambv.hCE = localaz.md5;
    }
    label99:
    for (;;)
    {
      if (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aci(parambv.hCE) == null)
      {
        AppMethodBeat.o(34398);
        return false;
      }
      AppMethodBeat.o(34398);
      return true;
    }
  }
  
  public static boolean aT(bv parambv)
  {
    AppMethodBeat.i(34399);
    if (parambv == null)
    {
      ae.w("MicroMsg.ChattingEditModeLogic", "check is game msg error, msg is null");
      AppMethodBeat.o(34399);
      return true;
    }
    if (parambv.field_isSend == 0) {}
    for (parambv = bl.BN(parambv.field_content);; parambv = parambv.field_content)
    {
      parambv = k.b.zb(parambv);
      if (parambv != null) {
        break;
      }
      ae.w("MicroMsg.ChattingEditModeLogic", "parse app message content fail");
      AppMethodBeat.o(34399);
      return false;
    }
    parambv = com.tencent.mm.pluginsdk.model.app.h.m(parambv.appId, false, false);
    if ((parambv != null) && (parambv.Ee()))
    {
      AppMethodBeat.o(34399);
      return true;
    }
    AppMethodBeat.o(34399);
    return false;
  }
  
  public static boolean aU(bv parambv)
  {
    AppMethodBeat.i(34400);
    if (parambv.getType() == 419430449)
    {
      AppMethodBeat.o(34400);
      return true;
    }
    AppMethodBeat.o(34400);
    return false;
  }
  
  public static boolean aV(bv parambv)
  {
    AppMethodBeat.i(34401);
    if ((parambv.getType() == 436207665) || (parambv.getType() == 469762097))
    {
      AppMethodBeat.o(34401);
      return true;
    }
    AppMethodBeat.o(34401);
    return false;
  }
  
  public static boolean aW(bv parambv)
  {
    AppMethodBeat.i(34402);
    if (parambv == null)
    {
      ae.w("MicroMsg.ChattingEditModeLogic", "isAppbrandForbidForwardMsg, check msg error, msg is null");
      AppMethodBeat.o(34402);
      return true;
    }
    if (parambv.field_isSend == 0) {}
    for (parambv = bl.BN(parambv.field_content);; parambv = parambv.field_content)
    {
      parambv = k.b.zb(parambv);
      if (parambv != null) {
        break;
      }
      ae.w("MicroMsg.ChattingEditModeLogic", "isAppbrandForbidForwardMsg, parse app message content fail");
      AppMethodBeat.o(34402);
      return false;
    }
    if ((parambv.hFl != 0) || ((parambv.type == 33) && (parambv.hFe == 3)) || ((parambv.type == 36) && (parambv.hFe == 3)) || ((parambv.type == 46) && (parambv.hFe == 3)) || ((parambv.type == 44) && ((parambv.hFe == 3) || (!parambv.ex(false)))) || ((parambv.type == 48) && (parambv.hFe == 3)))
    {
      AppMethodBeat.o(34402);
      return true;
    }
    AppMethodBeat.o(34402);
    return false;
  }
  
  private static boolean aX(bv parambv)
  {
    AppMethodBeat.i(34405);
    if (parambv != null)
    {
      parambv = k.b.zb(parambv.field_content);
      if ((parambv != null) && (parambv.type == 19))
      {
        Object localObject = new qi();
        ((qi)localObject).dFS.type = 0;
        ((qi)localObject).dFS.dFU = parambv.hDg;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
        localObject = ((qi)localObject).dFT.dGd;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.protocal.b.a.c)localObject).hFT.iterator();
          while (((Iterator)localObject).hasNext())
          {
            ajx localajx = (ajx)((Iterator)localObject).next();
            if (!bu.isNullOrNil(localajx.GAS))
            {
              ae.e("MicroMsg.ChattingEditModeLogic", "record type subDataItem contain tpurl, type:%d", new Object[] { Integer.valueOf(localajx.dataType) });
              AppMethodBeat.o(34405);
              return true;
            }
          }
        }
        if ((parambv.hDg != null) && (parambv.hDg.contains("<recordxml>")))
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
  
  private static boolean aY(bv parambv)
  {
    AppMethodBeat.i(34406);
    if (parambv != null)
    {
      parambv = k.b.zb(parambv.field_content);
      if ((parambv != null) && (parambv.type == 24))
      {
        AppMethodBeat.o(34406);
        return true;
      }
    }
    AppMethodBeat.o(34406);
    return false;
  }
  
  public static boolean aZ(bv parambv)
  {
    AppMethodBeat.i(34407);
    if (parambv != null)
    {
      parambv = k.b.zb(parambv.field_content);
      if (parambv == null)
      {
        AppMethodBeat.o(34407);
        return false;
      }
      if ((parambv.type == 6) || (parambv.type == 5) || (parambv.type == 19))
      {
        AppMethodBeat.o(34407);
        return true;
      }
    }
    AppMethodBeat.o(34407);
    return false;
  }
  
  public static void b(final Context paramContext, final String paramString, bv parambv)
  {
    AppMethodBeat.i(34427);
    if (!a(paramContext, paramString, parambv, "image"))
    {
      AppMethodBeat.o(34427);
      return;
    }
    Object localObject1 = null;
    if (parambv.field_msgId > 0L) {
      localObject1 = q.aIX().G(parambv.field_talker, parambv.field_msgId);
    }
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((com.tencent.mm.av.g)localObject1).doE > 0L) {}
    }
    else
    {
      localObject2 = localObject1;
      if (parambv.field_msgSvrId > 0L) {
        localObject2 = q.aIX().F(parambv.field_talker, parambv.field_msgSvrId);
      }
    }
    if (localObject2 == null)
    {
      AppMethodBeat.o(34427);
      return;
    }
    final int j = 0;
    final int i = j;
    if (((com.tencent.mm.av.g)localObject2).aIB())
    {
      i = j;
      if (!com.tencent.mm.av.h.a((com.tencent.mm.av.g)localObject2).ico.startsWith("SERVERID://")) {
        i = 1;
      }
    }
    localObject1 = q.aIX().o(com.tencent.mm.av.h.c((com.tencent.mm.av.g)localObject2), "", "");
    String str1 = q.aIX().o(((com.tencent.mm.av.g)localObject2).icq, "th_", "");
    if ((((com.tencent.mm.av.g)localObject2).offset < ((com.tencent.mm.av.g)localObject2).hPI) || (((com.tencent.mm.av.g)localObject2).hPI == 0))
    {
      final String str2 = com.tencent.mm.model.v.aAC();
      final String str3 = ((com.tencent.mm.av.g)localObject2).icA;
      Object localObject3 = bx.M(((com.tencent.mm.av.g)localObject2).icA, "msg");
      if (localObject3 == null)
      {
        ae.e("MicroMsg.ChattingEditModeLogic", "parse cdnInfo failed. [%s]", new Object[] { ((com.tencent.mm.av.g)localObject2).icA });
        i = 0;
      }
      for (;;)
      {
        if (i == 0) {
          a(paramContext, (com.tencent.mm.av.g)localObject2, parambv, 4, paramString, str1);
        }
        AppMethodBeat.o(34427);
        return;
        j = ((com.tencent.mm.av.g)localObject2).icr;
        if (j != 1) {
          localObject1 = (String)((Map)localObject3).get(".msg.img.$cdnmidimgurl");
        }
        for (i = 2;; i = 1)
        {
          ae.d("MicroMsg.ChattingEditModeLogic", "cdntra read xml  comptype:%d url:[%s]", new Object[] { Integer.valueOf(j), localObject1 });
          if (!bu.isNullOrNil((String)localObject1)) {
            break label375;
          }
          ae.e("MicroMsg.ChattingEditModeLogic", "cdntra get cdnUrlfailed.");
          i = 0;
          break;
          localObject1 = (String)((Map)localObject3).get(".msg.img.$cdnbigimgurl");
        }
        label375:
        String str4 = (String)((Map)localObject3).get(".msg.img.$aeskey");
        if (bu.isNullOrNil(str4))
        {
          ae.e("MicroMsg.ChattingEditModeLogic", "cdntra get aes key failed.");
          i = 0;
        }
        else if (bu.isNullOrNil(com.tencent.mm.an.c.a("downimg", ((com.tencent.mm.av.g)localObject2).icw, parambv.field_talker, parambv.field_msgId)))
        {
          ae.w("MicroMsg.ChattingEditModeLogic", "cdntra genClientId failed not use cdn imgLocalId:%d", new Object[] { Long.valueOf(parambv.field_msgSvrId) });
          i = 0;
        }
        else
        {
          localObject3 = (String)((Map)localObject3).get(".msg.img.$md5");
          com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
          localg.fLl = "task_ChattingEditModeLogic_1";
          localg.fLm = new g.a()
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
                ae.d("MicroMsg.ChattingEditModeLogic", "support second !! sceneResult:[%s]", new Object[] { paramAnonymousd });
                localObject2 = this.hHv;
                i = this.ohh;
                localObject1 = paramString;
                str1 = str2;
                paramAnonymousString = str3;
                str2 = this.lCn;
                j = j;
                str3 = q.aIX().R(((ei)localObject2).field_imgPath, true);
                localObject3 = new PString();
                localObject4 = new PInt();
                localObject5 = new PInt();
                ((PString)localObject3).value = "";
                paramAnonymousc = new bv();
                paramAnonymousc.setType(x.Bc((String)localObject1));
                paramAnonymousc.ui((String)localObject1);
                paramAnonymousc.kt(1);
                paramAnonymousc.setStatus(1);
                paramAnonymousc.qN(bl.BQ(paramAnonymousc.field_talker));
                paramAnonymousc.setContent(paramAnonymousString);
                a.a.ZP().n(paramAnonymousc);
                l3 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ar(paramAnonymousc);
                if (l3 < 0L) {
                  break label764;
                }
                paramAnonymousBoolean = true;
                Assert.assertTrue(paramAnonymousBoolean);
                ae.i("MicroMsg.ChattingEditModeLogic", "NetSceneUploadMsgImg: local msgId = ".concat(String.valueOf(l3)));
                if (j != 1) {
                  break label833;
                }
              }
              label770:
              label833:
              for (long l1 = q.aIX().a((String)localObject1, null, l3, true, paramAnonymousc.field_content, (PString)localObject3, (PInt)localObject4, (PInt)localObject5);; l1 = 0L)
              {
                long l2 = q.aIX().a((String)localObject1, null, l3, false, paramAnonymousc.field_content, (PString)localObject3, (PInt)localObject4, (PInt)localObject5);
                localObject4 = bx.M(paramAnonymousString, "msg");
                paramAnonymousInt = bu.getInt((String)((Map)localObject4).get(".msg.img.$length"), paramAnonymousd.field_thumbimgLength);
                paramAnonymousString = q.aIX().c(Long.valueOf(l2));
                paramAnonymousString.sq((int)l3);
                if (l2 > 0L)
                {
                  localObject5 = q.aIX().a(((PString)localObject3).value, "th_", "", false);
                  ae.i("MicroMsg.ChattingEditModeLogic", "deal send img for cdn [%s]", new Object[] { localObject5 });
                  com.tencent.mm.vfs.o.mF(str3, (String)localObject5);
                  paramAnonymousc.uj(((PString)localObject3).value);
                  paramAnonymousc.kD(((ei)localObject2).fmo);
                  paramAnonymousc.kE(((ei)localObject2).fmp);
                  if (l1 > 0L)
                  {
                    paramAnonymousString.pv(1);
                    paramAnonymousString.pr((int)l1);
                    paramAnonymousInt = bu.getInt((String)((Map)localObject4).get(".msg.img.$hdlength"), paramAnonymousd.field_thumbimgLength);
                  }
                }
                for (;;)
                {
                  q.aIX().a(Long.valueOf(l2), paramAnonymousString);
                  if (j == 1) {
                    paramAnonymousString = q.aIX().c(Long.valueOf(l1));
                  }
                  for (;;)
                  {
                    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().a(l3, paramAnonymousc);
                    q.aIX().a(Long.valueOf(l1), paramAnonymousString);
                    localObject3 = com.tencent.mm.an.c.a("upimg", paramAnonymousc.field_createTime, paramAnonymousc.field_talker, paramAnonymousc.field_msgId + "_" + l1 + "_" + j);
                    localObject2 = new dtw();
                    ((dtw)localObject2).FNG = new cxn().aQV(str1);
                    ((dtw)localObject2).FNH = new cxn().aQV((String)localObject1);
                    ((dtw)localObject2).urJ = paramAnonymousc.getType();
                    ((dtw)localObject2).FNL = paramAnonymousc.eNd;
                    ((dtw)localObject2).Ghj = paramAnonymousString.ics;
                    ((dtw)localObject2).HZu = new cxn().aQV((String)localObject3);
                    ((dtw)localObject2).GUb = j;
                    paramAnonymousd.field_filemd5 = str2;
                    paramAnonymousd.field_thumbimgLength = ((int)com.tencent.mm.vfs.o.aZR(str3));
                    paramAnonymousd.field_fileLength = paramAnonymousInt;
                    localObject1 = com.tencent.mm.av.c.aIt();
                    ((com.tencent.mm.av.c)localObject1).gzx = i;
                    ((com.tencent.mm.av.c)localObject1).ibY = ((dtw)localObject2);
                    ((com.tencent.mm.av.c)localObject1).ibZ = paramAnonymousString;
                    ((com.tencent.mm.av.c)localObject1).gzD = paramAnonymousd;
                    ((com.tencent.mm.av.c)localObject1).ica = new k.2(l2, l3);
                    ((o.e)localObject1).toUser = paramAnonymousc.field_talker;
                    ((o.e)localObject1).aJO().execute();
                    for (;;)
                    {
                      AppMethodBeat.o(34390);
                      return 0;
                      label764:
                      paramAnonymousBoolean = false;
                      break;
                      ae.d("MicroMsg.ChattingEditModeLogic", "not support second !! dealDownLoadImg");
                      paramAnonymousString = q.aIX().o(this.iel.icq, "th_", "");
                      k.a(paramContext, this.iel, this.hHv, this.ohh, paramString, paramAnonymousString);
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
          localg.field_mediaId = com.tencent.mm.an.c.a("checkExist", bu.fpO(), paramString, parambv.field_msgId);
          localg.field_fileId = ((String)localObject1);
          localg.field_aesKey = str4;
          localg.field_filemd5 = ((String)localObject3);
          localg.field_fileType = i;
          localg.field_talker = paramString;
          localg.field_priority = com.tencent.mm.i.a.fKA;
          localg.field_svr_signature = "";
          localg.field_onlycheckexist = true;
          localg.field_trysafecdn = true;
          if (!com.tencent.mm.an.f.aGZ().f(localg))
          {
            ae.e("MicroMsg.ChattingEditModeLogic", "check exist fail! download img before retransmit");
            i = 0;
          }
          else
          {
            i = 1;
          }
        }
      }
    }
    if (!bu.isNullOrNil((String)localObject1)) {
      com.tencent.mm.plugin.messenger.a.g.doC().a(paramContext, paramString, (String)localObject1, i, ((com.tencent.mm.av.g)localObject2).icA, str1, parambv.field_msgId, null);
    }
    AppMethodBeat.o(34427);
  }
  
  public static void b(Context paramContext, String paramString, bv parambv, boolean paramBoolean)
  {
    AppMethodBeat.i(34432);
    if (!a(paramContext, paramString, parambv, "appmsg"))
    {
      AppMethodBeat.o(34432);
      return;
    }
    if (paramContext == null)
    {
      ae.w("MicroMsg.ChattingEditModeLogic", "getReaderAppMsgContent: context is null");
      AppMethodBeat.o(34432);
      return;
    }
    if (parambv == null)
    {
      ae.w("MicroMsg.ChattingEditModeLogic", "getReaderAppMsgContent: msg is null");
      AppMethodBeat.o(34432);
      return;
    }
    bc.aCg();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      AppMethodBeat.o(34432);
      return;
    }
    paramContext = q.aIX().c(parambv.field_imgPath, false, false);
    if ((!af.isNullOrNil(paramContext)) && (!paramContext.endsWith("hd")) && (com.tencent.mm.vfs.o.fB(paramContext + "hd"))) {
      paramContext = paramContext + "hd";
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject1 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(parambv.field_msgId, parambv.field_content);
        localObject2 = ((com.tencent.mm.ah.u)localObject1).hFT;
        if ((localObject2 == null) || (((List)localObject2).size() <= 0))
        {
          if ((parambv == null) || ((!parambv.cVH()) && (!parambv.fta()))) {
            break label759;
          }
          localObject1 = com.tencent.mm.model.z.Br(parambv.field_msgSvrId);
          localObject2 = com.tencent.mm.model.z.aBG().F((String)localObject1, true);
          ((z.b)localObject2).k("prePublishId", "msg_" + parambv.field_msgSvrId);
          ((z.b)localObject2).k("preUsername", com.tencent.mm.ui.chatting.viewitems.c.a(parambv, paramBoolean, false));
          ((z.b)localObject2).k("preChatName", parambv.field_talker);
          ((z.b)localObject2).k("preMsgIndex", Integer.valueOf(0));
          ((z.b)localObject2).k("sendAppMsgScene", Integer.valueOf(1));
          ((com.tencent.mm.plugin.sns.b.j)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.sns.b.j.class)).a("adExtStr", (z.b)localObject2, parambv);
          com.tencent.mm.plugin.messenger.a.g.doC().a(paramString, bu.readFromFile(paramContext), bu.aSA(parambv.field_content), (String)localObject1);
          AppMethodBeat.o(34432);
          return;
        }
      }
      catch (Exception paramContext)
      {
        ae.printErrStackTrace("MicroMsg.ChattingEditModeLogic", paramContext, "", new Object[0]);
        ae.e("MicroMsg.ChattingEditModeLogic", "send app msg error : %s", new Object[] { paramContext.getLocalizedMessage() });
        AppMethodBeat.o(34432);
        return;
      }
      parambv = ((List)localObject2).iterator();
      while (parambv.hasNext())
      {
        Object localObject3 = (com.tencent.mm.ah.v)parambv.next();
        localObject2 = new k.b();
        if (com.tencent.mm.ah.m.zd(((com.tencent.mm.ah.v)localObject3).hGj))
        {
          m.b(paramString, m.a(paramString, (com.tencent.mm.ah.v)localObject3), ((com.tencent.mm.ah.v)localObject3).hGo);
        }
        else
        {
          ((k.b)localObject2).title = ((com.tencent.mm.ah.v)localObject3).title;
          ((k.b)localObject2).description = ((com.tencent.mm.ah.v)localObject3).hGg;
          ((k.b)localObject2).action = "view";
          ((k.b)localObject2).type = 5;
          ((k.b)localObject2).url = ((com.tencent.mm.ah.v)localObject3).url;
          ((k.b)localObject2).dIt = ((com.tencent.mm.ah.u)localObject1).dIt;
          ((k.b)localObject2).dIu = ((com.tencent.mm.ah.u)localObject1).dIu;
          ((k.b)localObject2).fmn = ((com.tencent.mm.ah.u)localObject1).fmn;
          ((k.b)localObject2).thumburl = com.tencent.mm.ah.m.a((com.tencent.mm.ah.v)localObject3);
          com.tencent.mm.ah.e locale = new com.tencent.mm.ah.e();
          locale.hBV = ((com.tencent.mm.ah.v)localObject3).type;
          locale.hBY = ((com.tencent.mm.ah.v)localObject3).hBY;
          if (((com.tencent.mm.ah.v)localObject3).type == 5)
          {
            locale.hCa = ((com.tencent.mm.ah.v)localObject3).hCa;
            locale.hBW = ((int)((com.tencent.mm.ah.v)localObject3).time);
            locale.duration = ((com.tencent.mm.ah.v)localObject3).hGi;
            locale.videoWidth = ((com.tencent.mm.ah.v)localObject3).videoWidth;
            locale.videoHeight = ((com.tencent.mm.ah.v)localObject3).videoHeight;
          }
          ((k.b)localObject2).a(locale);
          if ((bu.isNullOrNil(((k.b)localObject2).thumburl)) && (!bu.isNullOrNil(((k.b)localObject2).dIt)))
          {
            localObject3 = p.aEN().DL(((k.b)localObject2).dIt);
            if (localObject3 != null) {
              ((k.b)localObject2).thumburl = ((com.tencent.mm.aj.i)localObject3).aEG();
            }
          }
          localObject2 = k.b.a((k.b)localObject2, null, null);
          com.tencent.mm.plugin.messenger.a.g.doC().a(paramString, bu.readFromFile(paramContext), bu.aSA((String)localObject2), null);
        }
      }
      AppMethodBeat.o(34432);
      return;
      label759:
      Object localObject1 = null;
    }
  }
  
  public static boolean ba(bv parambv)
  {
    AppMethodBeat.i(34408);
    if ((parambv == null) || (!parambv.fta()))
    {
      AppMethodBeat.o(34408);
      return false;
    }
    boolean bool = com.tencent.mm.ah.m.c(parambv.field_msgId, parambv.field_content);
    AppMethodBeat.o(34408);
    return bool;
  }
  
  static boolean bb(bv parambv)
  {
    AppMethodBeat.i(34409);
    if (parambv != null)
    {
      parambv = k.b.zb(parambv.field_content);
      if ((parambv != null) && (parambv.type == 16))
      {
        AppMethodBeat.o(34409);
        return true;
      }
      if ((parambv != null) && (parambv.type == 34))
      {
        AppMethodBeat.o(34409);
        return true;
      }
    }
    AppMethodBeat.o(34409);
    return false;
  }
  
  public static boolean bc(bv parambv)
  {
    AppMethodBeat.i(34412);
    bc.aCg();
    bv.a locala = com.tencent.mm.model.c.azI().arp(parambv.field_content);
    if ((locala.cUA == null) || (locala.cUA.length() <= 0)) {
      ae.e("MicroMsg.ChattingEditModeLogic", "getView : parse possible friend msg failed");
    }
    if ((!x.oq(locala.Ecg)) && (parambv.getType() == 42))
    {
      boolean bool = parambv.fvW();
      AppMethodBeat.o(34412);
      return bool;
    }
    AppMethodBeat.o(34412);
    return false;
  }
  
  public static boolean bd(bv parambv)
  {
    AppMethodBeat.i(34413);
    bc.aCg();
    bv.a locala = com.tencent.mm.model.c.azI().arp(parambv.field_content);
    if ((locala.cUA == null) || (locala.cUA.length() <= 0)) {
      ae.e("MicroMsg.ChattingEditModeLogic", "getView : parse possible friend msg failed");
    }
    if ((!x.oq(locala.Ecg)) && (parambv.getType() == 42))
    {
      if ((parambv.eNc & 0x800) > 0)
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
  
  static boolean be(bv parambv)
  {
    AppMethodBeat.i(34414);
    if (!parambv.fvE())
    {
      AppMethodBeat.o(34414);
      return false;
    }
    bc.aCg();
    parambv = com.tencent.mm.model.c.azI().arp(parambv.field_content);
    if ((parambv == null) || (bu.isNullOrNil(parambv.cUA)))
    {
      AppMethodBeat.o(34414);
      return true;
    }
    if (x.Ao(parambv.cUA))
    {
      AppMethodBeat.o(34414);
      return false;
    }
    AppMethodBeat.o(34414);
    return true;
  }
  
  private static boolean bf(bv parambv)
  {
    AppMethodBeat.i(187139);
    if ((parambv != null) && (parambv.cVH()))
    {
      parambv = k.b.zb(parambv.field_content);
      if ((parambv != null) && (parambv.type == 6) && (parambv.hCC >= 1073741824))
      {
        AppMethodBeat.o(187139);
        return true;
      }
    }
    AppMethodBeat.o(187139);
    return false;
  }
  
  public static boolean bg(bv parambv)
  {
    AppMethodBeat.i(34416);
    if ((parambv != null) && (parambv.cVH()))
    {
      parambv = k.b.zb(parambv.field_content);
      if ((parambv != null) && (parambv.type == 6))
      {
        AppMethodBeat.o(34416);
        return true;
      }
    }
    AppMethodBeat.o(34416);
    return false;
  }
  
  public static void c(Context paramContext, final String paramString, final bv parambv)
  {
    AppMethodBeat.i(34430);
    if ((!a(paramContext, paramString, parambv, "video")) || (parambv == null))
    {
      AppMethodBeat.o(34430);
      return;
    }
    if ((parambv != null) && (parambv.cyI()) && (com.tencent.mm.modelvideo.u.Ic(parambv.field_imgPath)))
    {
      AppMethodBeat.o(34430);
      return;
    }
    Object localObject = com.tencent.mm.modelvideo.u.Ia(parambv.field_imgPath);
    if ((localObject != null) && (((com.tencent.mm.modelvideo.s)localObject).status == 199))
    {
      a(parambv.field_imgPath, paramString, ((com.tencent.mm.modelvideo.s)localObject).ixc, ((com.tencent.mm.modelvideo.s)localObject).hKI, ((com.tencent.mm.modelvideo.s)localObject).aNt(), parambv.getType(), parambv.field_msgId);
      AppMethodBeat.o(34430);
      return;
    }
    Map localMap = bx.M(((com.tencent.mm.modelvideo.s)localObject).aNt(), "msg");
    final int i;
    if (localMap == null)
    {
      ae.w("MicroMsg.ChattingEditModeLogic", "%s cdntra parse video recv xml failed");
      i = 0;
    }
    for (;;)
    {
      if (i == 0) {
        f(paramString, parambv);
      }
      AppMethodBeat.o(34430);
      return;
      paramContext = (String)localMap.get(".msg.videomsg.$cdnvideourl");
      if (bu.isNullOrNil(paramContext))
      {
        i = 0;
      }
      else
      {
        final String str1 = (String)localMap.get(".msg.videomsg.$aeskey");
        final String str2 = (String)localMap.get(".msg.videomsg.$md5");
        final String str3 = (String)localMap.get(".msg.videomsg.$newmd5");
        i = bu.getInt((String)localMap.get(".msg.videomsg.$length"), 0);
        final int j = bu.getInt((String)localMap.get(".msg.videomsg.$playlength"), 0);
        final int k = bu.getInt((String)localMap.get(".msg.videomsg.$cdnthumblength"), 0);
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1328L, 12L, 1L, true);
        if (bu.isNullOrNil(str2))
        {
          com.tencent.mm.modelvideo.o.aNh();
          if (!com.tencent.mm.vfs.o.fB(t.HJ(((com.tencent.mm.modelvideo.s)localObject).getFileName())))
          {
            ae.i("MicroMsg.ChattingEditModeLogic", "checkVideoCdnInfo md5 %s", new Object[] { str2 });
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1328L, 2L, 1L, true);
            i = 0;
            continue;
          }
        }
        localObject = new com.tencent.mm.i.g();
        ((com.tencent.mm.i.g)localObject).fLl = "task_ChattingEditModeLogic_2";
        ((com.tencent.mm.i.g)localObject).fLm = new g.a()
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
              ae.i("MicroMsg.ChattingEditModeLogic", "support second!! sceneResult: %s", new Object[] { paramAnonymousd });
              paramAnonymousString = t.HI(paramString);
              com.tencent.mm.modelvideo.o.aNh();
              paramAnonymousc = t.HK(paramAnonymousString);
              com.tencent.mm.modelvideo.o.aNh();
              com.tencent.mm.vfs.o.mF(t.HK(parambv.field_imgPath), paramAnonymousc);
              paramAnonymousc = "<msg><videomsg aeskey=\"" + str1 + "\" cdnthumbaeskey=\"" + str1 + "\" cdnvideourl=\"" + this.val$url + "\" ";
              paramAnonymousc = paramAnonymousc + "cdnthumburl=\"" + this.val$url + "\" ";
              paramAnonymousc = paramAnonymousc + "length=\"" + i + "\" ";
              paramAnonymousc = paramAnonymousc + "cdnthumblength=\"" + k + "\"/></msg>";
              ae.i("MicroMsg.ChattingEditModeLogic", "cdn callback new build cdnInfo:%s", new Object[] { paramAnonymousc });
              com.tencent.mm.modelvideo.u.b(paramAnonymousString, j, paramString, paramAnonymousc, (int)parambv.field_msgId);
              paramAnonymousc = com.tencent.mm.av.s.aJe();
              paramAnonymousc.fileName = paramAnonymousString;
              paramAnonymousc.ifG = 0;
              paramAnonymousc.ifH = paramAnonymousd;
              paramAnonymousc.ifI = new com.tencent.mm.av.f()
              {
                public final void dg(int paramAnonymous2Int1, int paramAnonymous2Int2)
                {
                  AppMethodBeat.i(34393);
                  com.tencent.mm.modelvideo.s locals = com.tencent.mm.modelvideo.u.Ia(paramAnonymousString);
                  locals.status = 111;
                  locals.dEu = 256;
                  com.tencent.mm.modelvideo.o.aNh().c(locals);
                  ae.d("MicroMsg.ChattingEditModeLogic", "NetSceneUploadVideoForCdn callback, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
                  AppMethodBeat.o(34393);
                }
              };
              paramAnonymousc.iiV = 4;
              paramAnonymousc.aJO().execute();
            }
            for (;;)
            {
              AppMethodBeat.o(34394);
              return 0;
              label369:
              k.f(paramString, parambv);
            }
          }
          
          public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
          
          public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
          {
            return new byte[0];
          }
        };
        ((com.tencent.mm.i.g)localObject).field_mediaId = com.tencent.mm.an.c.a("checkExist", bu.fpO(), paramString, parambv.field_msgId);
        ((com.tencent.mm.i.g)localObject).field_fileId = paramContext;
        ((com.tencent.mm.i.g)localObject).field_aesKey = str1;
        ((com.tencent.mm.i.g)localObject).field_filemd5 = str2;
        ((com.tencent.mm.i.g)localObject).field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
        ((com.tencent.mm.i.g)localObject).field_talker = paramString;
        ((com.tencent.mm.i.g)localObject).field_priority = com.tencent.mm.i.a.fKA;
        ((com.tencent.mm.i.g)localObject).field_svr_signature = "";
        ((com.tencent.mm.i.g)localObject).field_onlycheckexist = true;
        ((com.tencent.mm.i.g)localObject).field_trysafecdn = true;
        if (!com.tencent.mm.an.f.aGZ().f((com.tencent.mm.i.g)localObject))
        {
          ae.e("MicroMsg.ChattingEditModeLogic", "check exist fail! download video before retransmit");
          i = 0;
        }
        else
        {
          i = 1;
        }
      }
    }
  }
  
  public static void c(Context paramContext, String paramString, bv parambv, boolean paramBoolean)
  {
    AppMethodBeat.i(34433);
    if (!a(paramContext, paramString, parambv, "location"))
    {
      AppMethodBeat.o(34433);
      return;
    }
    paramContext = x(parambv.field_content, parambv.field_isSend, paramBoolean);
    com.tencent.mm.plugin.messenger.a.g.doC().aa(paramString, paramContext, 48);
    AppMethodBeat.o(34433);
  }
  
  public static void c(EmojiInfo paramEmojiInfo, String paramString)
  {
    AppMethodBeat.i(34436);
    WXMediaMessage localWXMediaMessage = new WXMediaMessage();
    String str = paramEmojiInfo.fSQ();
    if (com.tencent.mm.vfs.o.aZR(str + "_thumb") > 0L)
    {
      int i = (int)com.tencent.mm.vfs.o.aZR(str + "_thumb");
      localWXMediaMessage.thumbData = com.tencent.mm.vfs.o.bb(str + "_thumb", 0, i);
    }
    for (;;)
    {
      localWXMediaMessage.mediaObject = new WXEmojiObject(str);
      com.tencent.mm.pluginsdk.model.app.m.a(localWXMediaMessage, paramEmojiInfo.field_app_id, null, paramString, 1, paramEmojiInfo.Lj());
      AppMethodBeat.o(34436);
      return;
      try
      {
        InputStream localInputStream = com.tencent.mm.vfs.o.openRead(str);
        localWXMediaMessage.setThumbImage(BackwardSupportUtil.b.b(localInputStream, 1.0F));
        localInputStream.close();
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.ChattingEditModeLogic", localException, "", new Object[0]);
        ae.e("MicroMsg.ChattingEditModeLogic", "sendAppMsgEmoji Fail cause there is no thumb");
      }
    }
  }
  
  private static boolean e(bv parambv, String paramString)
  {
    AppMethodBeat.i(34411);
    bc.aCg();
    bv.a locala = com.tencent.mm.model.c.azI().arp(parambv.field_content);
    if ((locala.cUA == null) || (locala.cUA.length() <= 0))
    {
      ae.e("MicroMsg.ChattingEditModeLogic", "getView : parse possible friend msg failed");
      AppMethodBeat.o(34411);
      return false;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFU, 0) == 1) {}
    for (int i = 1; (i != 0) && ((an.aUq(paramString)) || (an.aUr(paramString)) || (parambv.getType() == 66)); i = 0)
    {
      AppMethodBeat.o(34411);
      return true;
    }
    AppMethodBeat.o(34411);
    return false;
  }
  
  private static boolean e(bv parambv, boolean paramBoolean)
  {
    AppMethodBeat.i(34410);
    if (!paramBoolean)
    {
      AppMethodBeat.o(34410);
      return false;
    }
    if (parambv != null)
    {
      parambv = k.b.zb(parambv.field_content);
      if ((parambv != null) && (parambv.type == 33) && (parambv.hFe == 1))
      {
        AppMethodBeat.o(34410);
        return true;
      }
    }
    AppMethodBeat.o(34410);
    return false;
  }
  
  static void f(final String paramString, bv parambv)
  {
    AppMethodBeat.i(34429);
    bc.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34396);
        com.tencent.mm.modelvideo.o.aNm().a(this.hHv.field_imgPath, new t.a()
        {
          public final void a(t.a.a paramAnonymous2a)
          {
            AppMethodBeat.i(34395);
            paramAnonymous2a = com.tencent.mm.modelvideo.u.Ia(paramAnonymous2a.fileName);
            if ((paramAnonymous2a != null) && (paramAnonymous2a.status == 199)) {
              k.a(k.5.this.hHv.field_imgPath, k.5.this.fOj, paramAnonymous2a.ixc, paramAnonymous2a.hKI, paramAnonymous2a.aNt(), k.5.this.hHv.getType(), k.5.this.hHv.field_msgId);
            }
            AppMethodBeat.o(34395);
          }
        });
        AppMethodBeat.o(34396);
      }
    });
    AppMethodBeat.o(34429);
  }
  
  public static List<String> fFm()
  {
    AppMethodBeat.i(34422);
    Object localObject1 = ag.aGp().oZ(25);
    Object localObject2 = ag.aGp();
    Object localObject3 = new ArrayList();
    Object localObject4 = new StringBuilder();
    com.tencent.mm.al.f.a((StringBuilder)localObject4);
    com.tencent.mm.al.f.c((StringBuilder)localObject4);
    com.tencent.mm.al.f.d((StringBuilder)localObject4);
    com.tencent.mm.al.f.a((StringBuilder)localObject4, true);
    ((StringBuilder)localObject4).append(" order by ");
    ((StringBuilder)localObject4).append(com.tencent.mm.al.f.aFL());
    localObject4 = ((StringBuilder)localObject4).toString();
    ae.i("MicroMsg.BizInfoStorage", "getEnterpriseBizChatLst sql %s", new Object[] { localObject4 });
    localObject2 = ((com.tencent.mm.al.f)localObject2).rawQuery((String)localObject4, new String[0]);
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
      str = com.tencent.mm.al.g.eX((String)localObject4).KD();
      if (!bu.isNullOrNil(str)) {
        ((HashMap)localObject2).put(str, localObject4);
      }
    }
    localObject3 = new LinkedList();
    localObject4 = new LinkedList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      str = (String)((Iterator)localObject1).next();
      if (com.tencent.mm.al.g.Eq(str))
      {
        if (com.tencent.mm.al.g.Eu(str))
        {
          str = com.tencent.mm.al.g.eX(str).field_enterpriseFather;
          if ((!((List)localObject4).contains(str)) && (com.tencent.mm.al.g.Es(str)))
          {
            ((List)localObject4).add(str);
            str = (String)((HashMap)localObject2).get(str);
            if (!bu.isNullOrNil(str)) {
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
      if ((!bu.isNullOrNil((String)localObject2)) && (!((List)localObject4).contains(localObject2))) {
        ((List)localObject4).add(localObject2);
      }
    }
    ((List)localObject3).addAll((Collection)localObject4);
    ae.d("MicroMsg.ChattingEditModeLogic", "get selected accept list, size %d", new Object[] { Integer.valueOf(((List)localObject3).size()) });
    AppMethodBeat.o(34422);
    return localObject3;
  }
  
  public static List<String> fFn()
  {
    AppMethodBeat.i(34423);
    Object localObject = ag.aGp().oZ(25);
    LinkedList localLinkedList = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!com.tencent.mm.al.g.Eq(str)) {
        localLinkedList.add(str);
      }
    }
    ae.d("MicroMsg.ChattingEditModeLogic", "get selected accept list without enterprise, size %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    AppMethodBeat.o(34423);
    return localLinkedList;
  }
  
  public static boolean id(List<bv> paramList)
  {
    AppMethodBeat.i(34403);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ae.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to brand msg error, selected item empty");
      AppMethodBeat.o(34403);
      return true;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bv localbv = (bv)paramList.next();
      if ((localbv.ftf()) || (aR(localbv)) || (localbv.fvE()) || (aT(localbv)) || (aU(localbv)) || (localbv.getType() == -1879048186) || (bb(localbv)) || (aV(localbv)) || (ba(localbv)) || (aW(localbv)) || (bg(localbv)))
      {
        AppMethodBeat.o(34403);
        return true;
      }
    }
    AppMethodBeat.o(34403);
    return false;
  }
  
  public static int ie(List<bv> paramList)
  {
    AppMethodBeat.i(34417);
    if (paramList == null)
    {
      ae.w("MicroMsg.ChattingEditModeLogic", "get invalid send to friend msg num error, select item empty");
      AppMethodBeat.o(34417);
      return 0;
    }
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      bv localbv = (bv)paramList.next();
      if ((!localbv.ftf()) && (!aR(localbv)) && (!localbv.cVJ()) && (!aT(localbv)) && (!aU(localbv)) && (!aV(localbv))) {
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
  
  public static boolean jdMethod_if(List<bv> paramList)
  {
    AppMethodBeat.i(34418);
    if (paramList == null)
    {
      ae.w("MicroMsg.ChattingEditModeLogic", "check contain undownload file, select item empty");
      AppMethodBeat.o(34418);
      return false;
    }
    Iterator localIterator = paramList.iterator();
    label390:
    label391:
    for (;;)
    {
      bv localbv;
      if (localIterator.hasNext())
      {
        localbv = (bv)localIterator.next();
        if ((localbv.ftg()) || (localbv.fvK()))
        {
          paramList = null;
          if (localbv.field_msgId > 0L) {
            paramList = q.aIX().G(localbv.field_talker, localbv.field_msgId);
          }
          if (((paramList != null) && (paramList.doE > 0L)) || (localbv.field_msgSvrId <= 0L)) {
            break label390;
          }
          paramList = q.aIX().F(localbv.field_talker, localbv.field_msgSvrId);
        }
      }
      for (;;)
      {
        if ((paramList == null) || ((paramList.offset >= paramList.hPI) && (paramList.hPI != 0))) {
          break label391;
        }
        AppMethodBeat.o(34418);
        return true;
        if (localbv.cyG())
        {
          paramList = com.tencent.mm.modelvideo.o.aNh().HD(localbv.field_imgPath);
          if ((paramList == null) || (paramList.status == 199) || (paramList.status == 199)) {
            break;
          }
          AppMethodBeat.o(34418);
          return true;
        }
        if (localbv.fvH())
        {
          if (aS(localbv)) {
            break;
          }
          AppMethodBeat.o(34418);
          return true;
        }
        if (localbv.cVH())
        {
          paramList = k.b.aB(localbv.field_content, localbv.field_content);
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
            paramList = ao.bJV().aMZ(paramList.dlu);
            if (paramList == null)
            {
              AppMethodBeat.o(34418);
              return true;
            }
            if (new com.tencent.mm.vfs.k(paramList.field_fileFullPath).exists()) {
              break;
            }
            AppMethodBeat.o(34418);
            return true;
          }
        }
        if (!localbv.cyI()) {
          break;
        }
        paramList = com.tencent.mm.modelvideo.u.Ia(localbv.field_imgPath);
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
  
  public static boolean ig(List<bv> paramList)
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
      bv localbv = (bv)paramList.next();
      if ((localbv.cyG()) && (com.tencent.mm.pluginsdk.model.l.aMV(localbv.field_imgPath)))
      {
        AppMethodBeat.o(34419);
        return true;
      }
    }
    AppMethodBeat.o(34419);
    return false;
  }
  
  public static boolean ih(List<bv> paramList)
  {
    AppMethodBeat.i(34420);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(34420);
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((bv)paramList.next()).cyI())
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
          str = bl.BN(paramString);
        }
      }
    }
    AppMethodBeat.o(34421);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k
 * JD-Core Version:    0.7.0.1
 */