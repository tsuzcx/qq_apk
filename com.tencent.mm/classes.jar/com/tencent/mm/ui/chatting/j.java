package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.v;
import com.tencent.mm.ah.z;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.af;
import com.tencent.mm.av.d.a;
import com.tencent.mm.av.m.a;
import com.tencent.mm.g.a.pw;
import com.tencent.mm.g.a.pw.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.i.g.a;
import com.tencent.mm.l.a.a;
import com.tencent.mm.model.az;
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
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.dni;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bo.a;
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
  static void a(Context paramContext, final com.tencent.mm.av.e parame, bo parambo, int paramInt, final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(34428);
    Object localObject2 = com.tencent.mm.av.o.aFx().p(com.tencent.mm.av.f.c(parame), "", "");
    Object localObject1 = new PString();
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    ((PString)localObject1).value = ((String)localObject2);
    int i = parame.hGP;
    long l1 = com.tencent.mm.av.o.aFx().a((String)localObject2, i, paramInt, (PString)localObject1, localPInt1, localPInt2);
    localObject2 = com.tencent.mm.av.o.aFx().c(Long.valueOf(l1));
    ((com.tencent.mm.av.e)localObject2).oP(1);
    bo localbo = new bo();
    localbo.setType(w.xu(paramString1));
    localbo.re(paramString1);
    localbo.jT(1);
    localbo.setStatus(1);
    localbo.rf(((PString)localObject1).value);
    localbo.ke(localPInt1.value);
    localbo.kf(localPInt2.value);
    localbo.oA(com.tencent.mm.model.bi.yp(localbo.field_talker));
    if (com.tencent.mm.al.f.so(localbo.field_talker)) {
      parambo.qf(com.tencent.mm.al.a.e.TG());
    }
    az.ayM();
    long l2 = com.tencent.mm.model.c.awD().ap(localbo);
    if (l2 >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ac.i("MicroMsg.ChattingEditModeLogic", "NetSceneUploadMsgImg: local msgId = ".concat(String.valueOf(l2)));
      ((com.tencent.mm.av.e)localObject2).qe((int)l2);
      com.tencent.mm.av.o.aFx().a(Long.valueOf(l1), (com.tencent.mm.av.e)localObject2);
      localObject1 = new HashMap();
      ((HashMap)localObject1).put(Long.valueOf(l2), parame);
      com.tencent.mm.av.o.aFy().a(parame.dcd, parambo.field_msgId, i, localObject1, 2131231564, new d.a()
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
              paramAnonymousn = (com.tencent.mm.av.e)paramAnonymousn.getValue();
              paramAnonymousn = com.tencent.mm.av.o.aFx().p(com.tencent.mm.av.f.c(paramAnonymousn), "", "");
              if (paramAnonymousInt2 != 0)
              {
                az.ayM();
                com.tencent.mm.model.c.awD().vQ(paramAnonymousString.longValue());
                com.tencent.mm.plugin.messenger.a.j.dck().a(this.val$context, paramString1, paramAnonymousn, paramAnonymousInt1, parame.hGY, paramString2, paramAnonymousLong2, null);
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
  
  public static void a(Context paramContext, String paramString, bo parambo)
  {
    AppMethodBeat.i(34426);
    if (!a(paramContext, paramString, parambo, "emoji"))
    {
      AppMethodBeat.o(34426);
      return;
    }
    String str = au.aOb(parambo.field_content).md5;
    if ((str == null) || (str.endsWith("-1"))) {}
    for (parambo = parambo.field_imgPath;; parambo = str)
    {
      if (parambo == null)
      {
        ac.w("MicroMsg.ChattingEditModeLogic", "showAcceptEmojiConnector: filePath is null");
        AppMethodBeat.o(34426);
        return;
      }
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().u(paramContext, paramString, parambo);
      AppMethodBeat.o(34426);
      return;
    }
  }
  
  public static void a(Context paramContext, String paramString, bo parambo, boolean paramBoolean)
  {
    AppMethodBeat.i(34431);
    if (!a(paramContext, paramString, parambo, "text"))
    {
      AppMethodBeat.o(34431);
      return;
    }
    paramContext = x(parambo.field_content, parambo.field_isSend, paramBoolean);
    if ((paramContext == null) || (paramContext.equals("")))
    {
      ac.e("MicroMsg.ChattingEditModeLogic", "Transfer text erro: content null");
      AppMethodBeat.o(34431);
      return;
    }
    com.tencent.mm.plugin.messenger.a.j.dck().X(paramString, paramContext, w.xt(paramString));
    AppMethodBeat.o(34431);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(34435);
    try
    {
      bo localbo = new bo();
      localbo.setContent(paramString2);
      localbo.jT(paramInt);
      paramInt = paramString2.indexOf("<msg>");
      String str = paramString2;
      if (paramInt > 0)
      {
        str = paramString2;
        if (paramInt < paramString2.length()) {
          str = paramString2.substring(paramInt).trim();
        }
      }
      paramString2 = bv.L(str, "msg");
      if ((paramString2 != null) && (paramString2.size() > 0)) {
        localbo.rg(com.tencent.mm.sdk.platformtools.bi.bF(paramString2));
      }
      b(paramContext, paramString1, localbo, paramBoolean);
      AppMethodBeat.o(34435);
      return;
    }
    catch (Exception paramContext)
    {
      ac.printErrStackTrace("MicroMsg.ChattingEditModeLogic", paramContext, "", new Object[0]);
      ac.e("MicroMsg.ChattingEditModeLogic", "retransmit sigle app msg error : %s", new Object[] { paramContext.getLocalizedMessage() });
      AppMethodBeat.o(34435);
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(163284);
    ac.d("MicroMsg.ChattingEditModeLogic", "copy video fileName %s userName %s export %d videoLength %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    String str1 = t.DU(com.tencent.mm.model.u.axw());
    com.tencent.mm.modelvideo.o.aJy();
    String str2 = t.DV(paramString1);
    String str3 = t.DV(str1);
    paramString1 = t.DW(paramString1);
    String str4 = t.DW(str1);
    ac.d("MicroMsg.ChattingEditModeLogic", "copy video: srcFullPath[%s] destFullPath[%s] srcThumbPath[%s] destThumbPath[%s]", new Object[] { str2, str3, paramString1, str4 });
    com.tencent.mm.vfs.i.lZ(str2, str3);
    com.tencent.mm.vfs.i.lZ(paramString1, str4);
    com.tencent.mm.modelvideo.u.a(str1, paramInt2, paramString2, null, paramInt1, paramString3, paramInt3, (int)paramLong);
    com.tencent.mm.modelvideo.u.Ec(str1);
    AppMethodBeat.o(163284);
  }
  
  static boolean a(Context paramContext, String paramString1, bo parambo, String paramString2)
  {
    AppMethodBeat.i(34425);
    if (paramContext == null)
    {
      ac.w("MicroMsg.ChattingEditModeLogic", "send %s fail, context is null", new Object[] { paramString2 });
      AppMethodBeat.o(34425);
      return false;
    }
    if (bs.isNullOrNil(paramString1))
    {
      ac.w("MicroMsg.ChattingEditModeLogic", "send %s fail, username is null", new Object[] { paramString2 });
      AppMethodBeat.o(34425);
      return false;
    }
    if (parambo == null)
    {
      ac.w("MicroMsg.ChattingEditModeLogic", "send %s fail, msg is null", new Object[] { paramString2 });
      AppMethodBeat.o(34425);
      return false;
    }
    AppMethodBeat.o(34425);
    return true;
  }
  
  public static boolean a(boolean paramBoolean, List<bo> paramList, String paramString, z paramz)
  {
    AppMethodBeat.i(34404);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ac.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to friend msg error, select item empty");
      AppMethodBeat.o(34404);
      return false;
    }
    int i;
    if ((paramList.size() == 1) && (((paramz != null) && (paramz.awt())) || (paramBoolean)))
    {
      paramList = (bo)paramList.get(0);
      if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pUi, 0) == 1) {}
      for (i = 1; ((bc(paramList)) && ((i == 0) || (ba(paramList)) || (d(paramList, paramString)))) || (paramList.eZl()) || (aP(paramList)) || (aR(paramList)) || (aS(paramList)) || (paramList.getType() == -1879048186) || (paramList.getType() == 318767153) || ((paramList.getType() == 486539313) && (paramBoolean)) || (aZ(paramList)) || (aT(paramList)) || (bd(paramList)) || (aY(paramList)) || (aU(paramList)) || (d(paramList, paramBoolean)) || (paramList.getType() == 788529201) || (paramList.getType() == 889192497); i = 0)
      {
        AppMethodBeat.o(34404);
        return false;
      }
      AppMethodBeat.o(34404);
      return true;
    }
    paramList = paramList.iterator();
    boolean bool = true;
    bo localbo;
    if (paramList.hasNext())
    {
      localbo = (bo)paramList.next();
      if (((paramz != null) && (paramz.awt())) || (paramBoolean)) {
        if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pUi, 0) == 1)
        {
          i = 1;
          label344:
          if ((!localbo.eZl()) && (!aP(localbo)) && (!aR(localbo)) && (!aS(localbo)) && (localbo.getType() != -1879048186) && ((localbo.getType() != 486539313) || (!paramBoolean)) && (!aZ(localbo)) && (!aT(localbo)) && ((!aV(localbo)) || ((paramz != null) && (paramz.awt()))) && ((!aW(localbo)) || ((paramz != null) && (paramz.awt()))) && (localbo.getType() != 318767153) && ((!bc(localbo)) || ((i != 0) && (!ba(localbo)) && (!d(localbo, paramString)))) && (!bd(localbo)) && (!aY(localbo)) && (!aU(localbo)) && (!d(localbo, paramBoolean)) && (localbo.getType() != 788529201) && (localbo.getType() != 889192497)) {
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
      if ((aV(localbo)) || (aW(localbo)) || (localbo.getType() == 788529201) || (localbo.getType() == 889192497))
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
  
  public static boolean aP(bo parambo)
  {
    AppMethodBeat.i(34397);
    if (parambo == null)
    {
      ac.w("MicroMsg.ChattingEditModeLogic", "check is store emoji error, msg is null");
      AppMethodBeat.o(34397);
      return true;
    }
    if (parambo.fbD())
    {
      au localau = new au(parambo.field_content);
      parambo = k.b.az(parambo.field_content, parambo.field_reserved);
      if (parambo != null) {
        break label314;
      }
      parambo = new k.b();
      parambo.hhH = localau.md5;
    }
    label314:
    for (;;)
    {
      for (parambo = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XL(parambo.hhH); (parambo != null) && ((parambo.field_catalog == EmojiInfo.Jsy) || ((!bs.isNullOrNil(parambo.field_groupId)) && (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XQ(parambo.field_groupId)))); parambo = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XL(parambo.field_imgPath))
      {
        AppMethodBeat.o(34397);
        return false;
      }
      if (parambo != null)
      {
        if ((bs.isNullOrNil(parambo.field_app_id)) && (!bs.isNullOrNil(parambo.field_groupId)) && (!parambo.field_groupId.equals(String.valueOf(EmojiGroupInfo.Jsq))) && (!parambo.field_groupId.equals(String.valueOf(EmojiGroupInfo.Jsp))) && (!parambo.field_groupId.equals(String.valueOf(EmojiGroupInfo.Jsr))) && (!parambo.field_groupId.equals(String.valueOf(EmojiInfo.Jss))) && (!parambo.field_groupId.equals("capture"))) {}
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
  
  public static boolean aQ(bo parambo)
  {
    AppMethodBeat.i(34398);
    if (parambo.fbD())
    {
      au localau = new au(parambo.field_content);
      parambo = k.b.az(parambo.field_content, parambo.field_reserved);
      if (parambo != null) {
        break label99;
      }
      parambo = new k.b();
      parambo.hhH = localau.md5;
    }
    label99:
    for (;;)
    {
      if (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XL(parambo.hhH) == null)
      {
        AppMethodBeat.o(34398);
        return false;
      }
      AppMethodBeat.o(34398);
      return true;
    }
  }
  
  public static boolean aR(bo parambo)
  {
    AppMethodBeat.i(34399);
    if (parambo == null)
    {
      ac.w("MicroMsg.ChattingEditModeLogic", "check is game msg error, msg is null");
      AppMethodBeat.o(34399);
      return true;
    }
    if (parambo.field_isSend == 0) {}
    for (parambo = com.tencent.mm.model.bi.ym(parambo.field_content);; parambo = parambo.field_content)
    {
      parambo = k.b.vA(parambo);
      if (parambo != null) {
        break;
      }
      ac.w("MicroMsg.ChattingEditModeLogic", "parse app message content fail");
      AppMethodBeat.o(34399);
      return false;
    }
    parambo = com.tencent.mm.pluginsdk.model.app.h.k(parambo.appId, false, false);
    if ((parambo != null) && (parambo.CC()))
    {
      AppMethodBeat.o(34399);
      return true;
    }
    AppMethodBeat.o(34399);
    return false;
  }
  
  public static boolean aS(bo parambo)
  {
    AppMethodBeat.i(34400);
    if (parambo.getType() == 419430449)
    {
      AppMethodBeat.o(34400);
      return true;
    }
    AppMethodBeat.o(34400);
    return false;
  }
  
  public static boolean aT(bo parambo)
  {
    AppMethodBeat.i(34401);
    if ((parambo.getType() == 436207665) || (parambo.getType() == 469762097))
    {
      AppMethodBeat.o(34401);
      return true;
    }
    AppMethodBeat.o(34401);
    return false;
  }
  
  public static boolean aU(bo parambo)
  {
    AppMethodBeat.i(34402);
    if (parambo == null)
    {
      ac.w("MicroMsg.ChattingEditModeLogic", "isAppbrandForbidForwardMsg, check msg error, msg is null");
      AppMethodBeat.o(34402);
      return true;
    }
    if (parambo.field_isSend == 0) {}
    for (parambo = com.tencent.mm.model.bi.ym(parambo.field_content);; parambo = parambo.field_content)
    {
      parambo = k.b.vA(parambo);
      if (parambo != null) {
        break;
      }
      ac.w("MicroMsg.ChattingEditModeLogic", "isAppbrandForbidForwardMsg, parse app message content fail");
      AppMethodBeat.o(34402);
      return false;
    }
    if ((parambo.hkn != 0) || ((parambo.type == 33) && (parambo.hkg == 3)) || ((parambo.type == 46) && (parambo.hkg == 3)) || ((parambo.type == 44) && ((parambo.hkg == 3) || (!parambo.et(false)))) || ((parambo.type == 48) && (parambo.hkg == 3)))
    {
      AppMethodBeat.o(34402);
      return true;
    }
    AppMethodBeat.o(34402);
    return false;
  }
  
  private static boolean aV(bo parambo)
  {
    AppMethodBeat.i(34405);
    if (parambo != null)
    {
      parambo = k.b.vA(parambo.field_content);
      if ((parambo != null) && (parambo.type == 19))
      {
        Object localObject = new pw();
        ((pw)localObject).dsN.type = 0;
        ((pw)localObject).dsN.dsP = parambo.hij;
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
        localObject = ((pw)localObject).dsO.dsX;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.protocal.b.a.c)localObject).hkS.iterator();
          while (((Iterator)localObject).hasNext())
          {
            agx localagx = (agx)((Iterator)localObject).next();
            if (!bs.isNullOrNil(localagx.EAx))
            {
              ac.e("MicroMsg.ChattingEditModeLogic", "record type subDataItem contain tpurl, type:%d", new Object[] { Integer.valueOf(localagx.dataType) });
              AppMethodBeat.o(34405);
              return true;
            }
          }
        }
        if ((parambo.hij != null) && (parambo.hij.contains("<recordxml>")))
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
  
  private static boolean aW(bo parambo)
  {
    AppMethodBeat.i(34406);
    if (parambo != null)
    {
      parambo = k.b.vA(parambo.field_content);
      if ((parambo != null) && (parambo.type == 24))
      {
        AppMethodBeat.o(34406);
        return true;
      }
    }
    AppMethodBeat.o(34406);
    return false;
  }
  
  public static boolean aX(bo parambo)
  {
    AppMethodBeat.i(34407);
    if (parambo != null)
    {
      parambo = k.b.vA(parambo.field_content);
      if (parambo == null)
      {
        AppMethodBeat.o(34407);
        return false;
      }
      if ((parambo.type == 6) || (parambo.type == 5) || (parambo.type == 19))
      {
        AppMethodBeat.o(34407);
        return true;
      }
    }
    AppMethodBeat.o(34407);
    return false;
  }
  
  public static boolean aY(bo parambo)
  {
    AppMethodBeat.i(34408);
    if ((parambo == null) || (!parambo.eZj()))
    {
      AppMethodBeat.o(34408);
      return false;
    }
    boolean bool = com.tencent.mm.ah.m.c(parambo.field_msgId, parambo.field_content);
    AppMethodBeat.o(34408);
    return bool;
  }
  
  static boolean aZ(bo parambo)
  {
    AppMethodBeat.i(34409);
    if (parambo != null)
    {
      parambo = k.b.vA(parambo.field_content);
      if ((parambo != null) && (parambo.type == 16))
      {
        AppMethodBeat.o(34409);
        return true;
      }
      if ((parambo != null) && (parambo.type == 34))
      {
        AppMethodBeat.o(34409);
        return true;
      }
    }
    AppMethodBeat.o(34409);
    return false;
  }
  
  public static void b(final Context paramContext, final String paramString, bo parambo)
  {
    AppMethodBeat.i(34427);
    if (!a(paramContext, paramString, parambo, "image"))
    {
      AppMethodBeat.o(34427);
      return;
    }
    Object localObject1 = null;
    if (parambo.field_msgId > 0L) {
      localObject1 = com.tencent.mm.av.o.aFx().qg(parambo.field_msgId);
    }
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((com.tencent.mm.av.e)localObject1).dcd > 0L) {}
    }
    else
    {
      localObject2 = localObject1;
      if (parambo.field_msgSvrId > 0L) {
        localObject2 = com.tencent.mm.av.o.aFx().qf(parambo.field_msgSvrId);
      }
    }
    if (localObject2 == null)
    {
      AppMethodBeat.o(34427);
      return;
    }
    final int j = 0;
    final int i = j;
    if (((com.tencent.mm.av.e)localObject2).aFa())
    {
      i = j;
      if (!com.tencent.mm.av.f.a((com.tencent.mm.av.e)localObject2).hGM.startsWith("SERVERID://")) {
        i = 1;
      }
    }
    localObject1 = com.tencent.mm.av.o.aFx().p(com.tencent.mm.av.f.c((com.tencent.mm.av.e)localObject2), "", "");
    String str1 = com.tencent.mm.av.o.aFx().p(((com.tencent.mm.av.e)localObject2).hGO, "th_", "");
    if ((((com.tencent.mm.av.e)localObject2).offset < ((com.tencent.mm.av.e)localObject2).hux) || (((com.tencent.mm.av.e)localObject2).hux == 0))
    {
      final String str2 = com.tencent.mm.model.u.axw();
      final String str3 = ((com.tencent.mm.av.e)localObject2).hGY;
      Object localObject3 = bv.L(((com.tencent.mm.av.e)localObject2).hGY, "msg");
      if (localObject3 == null)
      {
        ac.e("MicroMsg.ChattingEditModeLogic", "parse cdnInfo failed. [%s]", new Object[] { ((com.tencent.mm.av.e)localObject2).hGY });
        i = 0;
      }
      for (;;)
      {
        if (i == 0) {
          a(paramContext, (com.tencent.mm.av.e)localObject2, parambo, 4, paramString, str1);
        }
        AppMethodBeat.o(34427);
        return;
        j = ((com.tencent.mm.av.e)localObject2).hGP;
        if (j != 1) {
          localObject1 = (String)((Map)localObject3).get(".msg.img.$cdnmidimgurl");
        }
        for (i = 2;; i = 1)
        {
          ac.d("MicroMsg.ChattingEditModeLogic", "cdntra read xml  comptype:%d url:[%s]", new Object[] { Integer.valueOf(j), localObject1 });
          if (!bs.isNullOrNil((String)localObject1)) {
            break label367;
          }
          ac.e("MicroMsg.ChattingEditModeLogic", "cdntra get cdnUrlfailed.");
          i = 0;
          break;
          localObject1 = (String)((Map)localObject3).get(".msg.img.$cdnbigimgurl");
        }
        label367:
        String str4 = (String)((Map)localObject3).get(".msg.img.$aeskey");
        if (bs.isNullOrNil(str4))
        {
          ac.e("MicroMsg.ChattingEditModeLogic", "cdntra get aes key failed.");
          i = 0;
        }
        else if (bs.isNullOrNil(com.tencent.mm.an.c.a("downimg", ((com.tencent.mm.av.e)localObject2).hGU, parambo.field_talker, parambo.field_msgId)))
        {
          ac.w("MicroMsg.ChattingEditModeLogic", "cdntra genClientId failed not use cdn imgLocalId:%d", new Object[] { Long.valueOf(parambo.field_msgSvrId) });
          i = 0;
        }
        else
        {
          localObject3 = (String)((Map)localObject3).get(".msg.img.$md5");
          com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
          localg.frb = new g.a()
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
              bo localbo;
              long l3;
              if (paramAnonymousd != null)
              {
                if (!paramAnonymousd.field_exist_whencheck) {
                  break label752;
                }
                ac.d("MicroMsg.ChattingEditModeLogic", "support second !! sceneResult:[%s]", new Object[] { paramAnonymousd });
                localObject1 = this.hmq;
                i = this.iqF;
                paramAnonymousc = paramString;
                str1 = str2;
                paramAnonymousString = str3;
                str2 = this.laP;
                j = j;
                str3 = com.tencent.mm.av.o.aFx().R(((dy)localObject1).field_imgPath, true);
                localObject2 = new PString();
                localObject3 = new PInt();
                localObject4 = new PInt();
                ((PString)localObject2).value = "";
                localbo = new bo();
                localbo.setType(w.xu(paramAnonymousc));
                localbo.re(paramAnonymousc);
                localbo.jT(1);
                localbo.setStatus(1);
                localbo.oA(com.tencent.mm.model.bi.yp(localbo.field_talker));
                localbo.setContent(paramAnonymousString);
                a.a.Xf().n(localbo);
                l3 = ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().ap(localbo);
                if (l3 < 0L) {
                  break label746;
                }
                paramAnonymousBoolean = true;
                Assert.assertTrue(paramAnonymousBoolean);
                ac.i("MicroMsg.ChattingEditModeLogic", "NetSceneUploadMsgImg: local msgId = ".concat(String.valueOf(l3)));
                if (j != 1) {
                  break label815;
                }
              }
              label815:
              for (long l1 = com.tencent.mm.av.o.aFx().a(null, l3, true, localbo.field_content, (PString)localObject2, (PInt)localObject3, (PInt)localObject4);; l1 = 0L)
              {
                long l2 = com.tencent.mm.av.o.aFx().a(null, l3, false, localbo.field_content, (PString)localObject2, (PInt)localObject3, (PInt)localObject4);
                localObject3 = bv.L(paramAnonymousString, "msg");
                paramAnonymousInt = bs.getInt((String)((Map)localObject3).get(".msg.img.$length"), paramAnonymousd.field_thumbimgLength);
                paramAnonymousString = com.tencent.mm.av.o.aFx().c(Long.valueOf(l2));
                paramAnonymousString.qe((int)l3);
                if (l2 > 0L)
                {
                  localObject4 = com.tencent.mm.av.o.aFx().a(((PString)localObject2).value, "th_", "", false);
                  ac.i("MicroMsg.ChattingEditModeLogic", "deal send img for cdn [%s]", new Object[] { localObject4 });
                  com.tencent.mm.vfs.i.lZ(str3, (String)localObject4);
                  localbo.rf(((PString)localObject2).value);
                  localbo.ke(((dy)localObject1).eSc);
                  localbo.kf(((dy)localObject1).eSd);
                  if (l1 > 0L)
                  {
                    paramAnonymousString.oQ(1);
                    paramAnonymousString.oM((int)l1);
                    paramAnonymousInt = bs.getInt((String)((Map)localObject3).get(".msg.img.$hdlength"), paramAnonymousd.field_thumbimgLength);
                  }
                }
                for (;;)
                {
                  com.tencent.mm.av.o.aFx().a(Long.valueOf(l2), paramAnonymousString);
                  if (j == 1) {
                    paramAnonymousString = com.tencent.mm.av.o.aFx().c(Long.valueOf(l1));
                  }
                  for (;;)
                  {
                    ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().a(l3, localbo);
                    com.tencent.mm.av.o.aFx().a(Long.valueOf(l1), paramAnonymousString);
                    localObject1 = com.tencent.mm.an.c.a("upimg", localbo.field_createTime, localbo.field_talker, localbo.field_msgId + "_" + l1 + "_" + j);
                    localObject2 = new dni();
                    ((dni)localObject2).DPT = new crm().aJV(str1);
                    ((dni)localObject2).DPU = new crm().aJV(paramAnonymousc);
                    ((dni)localObject2).tit = localbo.getType();
                    ((dni)localObject2).DPY = localbo.eul;
                    ((dni)localObject2).EhD = paramAnonymousString.hGQ;
                    ((dni)localObject2).FUT = new crm().aJV((String)localObject1);
                    ((dni)localObject2).ERj = j;
                    paramAnonymousd.field_filemd5 = str2;
                    paramAnonymousd.field_thumbimgLength = ((int)com.tencent.mm.vfs.i.aSp(str3));
                    paramAnonymousd.field_fileLength = paramAnonymousInt;
                    paramAnonymousString = new com.tencent.mm.av.m(i, (dni)localObject2, paramAnonymousString, paramAnonymousd, new j.2(l2, l3));
                    com.tencent.mm.kernel.g.agi().a(paramAnonymousString, 0);
                    for (;;)
                    {
                      AppMethodBeat.o(34390);
                      return 0;
                      label746:
                      paramAnonymousBoolean = false;
                      break;
                      label752:
                      ac.d("MicroMsg.ChattingEditModeLogic", "not support second !! dealDownLoadImg");
                      paramAnonymousString = com.tencent.mm.av.o.aFx().p(this.hIE.hGO, "th_", "");
                      j.a(paramContext, this.hIE, this.hmq, this.iqF, paramString, paramAnonymousString);
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
          localg.field_mediaId = com.tencent.mm.an.c.a("checkExist", bs.eWj(), paramString, parambo.field_msgId);
          localg.field_fileId = ((String)localObject1);
          localg.field_aesKey = str4;
          localg.field_filemd5 = ((String)localObject3);
          localg.field_fileType = i;
          localg.field_talker = paramString;
          localg.field_priority = com.tencent.mm.i.a.fqp;
          localg.field_svr_signature = "";
          localg.field_onlycheckexist = true;
          localg.field_trysafecdn = true;
          if (!com.tencent.mm.an.f.aDD().f(localg))
          {
            ac.e("MicroMsg.ChattingEditModeLogic", "check exist fail! download img before retransmit");
            i = 0;
          }
          else
          {
            i = 1;
          }
        }
      }
    }
    if (!bs.isNullOrNil((String)localObject1)) {
      com.tencent.mm.plugin.messenger.a.j.dck().a(paramContext, paramString, (String)localObject1, i, ((com.tencent.mm.av.e)localObject2).hGY, str1, parambo.field_msgId, null);
    }
    AppMethodBeat.o(34427);
  }
  
  public static void b(Context paramContext, String paramString, bo parambo, boolean paramBoolean)
  {
    AppMethodBeat.i(34432);
    if (!a(paramContext, paramString, parambo, "appmsg"))
    {
      AppMethodBeat.o(34432);
      return;
    }
    if (paramContext == null)
    {
      ac.w("MicroMsg.ChattingEditModeLogic", "getReaderAppMsgContent: context is null");
      AppMethodBeat.o(34432);
      return;
    }
    if (parambo == null)
    {
      ac.w("MicroMsg.ChattingEditModeLogic", "getReaderAppMsgContent: msg is null");
      AppMethodBeat.o(34432);
      return;
    }
    az.ayM();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      AppMethodBeat.o(34432);
      return;
    }
    paramContext = com.tencent.mm.av.o.aFx().b(parambo.field_imgPath, false, false);
    if ((!ae.isNullOrNil(paramContext)) && (!paramContext.endsWith("hd")) && (com.tencent.mm.vfs.i.eA(paramContext + "hd"))) {
      paramContext = paramContext + "hd";
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject1 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(parambo.field_msgId, parambo.field_content);
        localObject2 = ((com.tencent.mm.ah.u)localObject1).hkS;
        if ((localObject2 == null) || (((List)localObject2).size() <= 0))
        {
          if ((parambo == null) || ((!parambo.cKN()) && (!parambo.eZj()))) {
            break label759;
          }
          localObject1 = y.xJ(parambo.field_msgSvrId);
          localObject2 = y.ayq().F((String)localObject1, true);
          ((y.b)localObject2).l("prePublishId", "msg_" + parambo.field_msgSvrId);
          ((y.b)localObject2).l("preUsername", com.tencent.mm.ui.chatting.viewitems.c.a(parambo, paramBoolean, false));
          ((y.b)localObject2).l("preChatName", parambo.field_talker);
          ((y.b)localObject2).l("preMsgIndex", Integer.valueOf(0));
          ((y.b)localObject2).l("sendAppMsgScene", Integer.valueOf(1));
          ((com.tencent.mm.plugin.sns.b.j)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.sns.b.j.class)).a("adExtStr", (y.b)localObject2, parambo);
          com.tencent.mm.plugin.messenger.a.j.dck().a(paramString, bs.readFromFile(paramContext), bs.aLx(parambo.field_content), (String)localObject1);
          AppMethodBeat.o(34432);
          return;
        }
      }
      catch (Exception paramContext)
      {
        ac.printErrStackTrace("MicroMsg.ChattingEditModeLogic", paramContext, "", new Object[0]);
        ac.e("MicroMsg.ChattingEditModeLogic", "send app msg error : %s", new Object[] { paramContext.getLocalizedMessage() });
        AppMethodBeat.o(34432);
        return;
      }
      parambo = ((List)localObject2).iterator();
      while (parambo.hasNext())
      {
        Object localObject3 = (v)parambo.next();
        localObject2 = new k.b();
        if (com.tencent.mm.ah.m.vC(((v)localObject3).hli))
        {
          l.b(paramString, l.a(paramString, (v)localObject3), ((v)localObject3).hln);
        }
        else
        {
          ((k.b)localObject2).title = ((v)localObject3).title;
          ((k.b)localObject2).description = ((v)localObject3).hlf;
          ((k.b)localObject2).action = "view";
          ((k.b)localObject2).type = 5;
          ((k.b)localObject2).url = ((v)localObject3).url;
          ((k.b)localObject2).dvl = ((com.tencent.mm.ah.u)localObject1).dvl;
          ((k.b)localObject2).dvm = ((com.tencent.mm.ah.u)localObject1).dvm;
          ((k.b)localObject2).eSb = ((com.tencent.mm.ah.u)localObject1).eSb;
          ((k.b)localObject2).thumburl = com.tencent.mm.ah.m.a((v)localObject3);
          com.tencent.mm.ah.e locale = new com.tencent.mm.ah.e();
          locale.hgY = ((v)localObject3).type;
          locale.hhb = ((v)localObject3).hhb;
          if (((v)localObject3).type == 5)
          {
            locale.hhd = ((v)localObject3).hhd;
            locale.hgZ = ((int)((v)localObject3).time);
            locale.duration = ((v)localObject3).hlh;
            locale.videoWidth = ((v)localObject3).videoWidth;
            locale.videoHeight = ((v)localObject3).videoHeight;
          }
          ((k.b)localObject2).a(locale);
          if ((bs.isNullOrNil(((k.b)localObject2).thumburl)) && (!bs.isNullOrNil(((k.b)localObject2).dvl)))
          {
            localObject3 = p.aBw().Ak(((k.b)localObject2).dvl);
            if (localObject3 != null) {
              ((k.b)localObject2).thumburl = ((com.tencent.mm.aj.i)localObject3).aBo();
            }
          }
          localObject2 = k.b.a((k.b)localObject2, null, null);
          com.tencent.mm.plugin.messenger.a.j.dck().a(paramString, bs.readFromFile(paramContext), bs.aLx((String)localObject2), null);
        }
      }
      AppMethodBeat.o(34432);
      return;
      label759:
      Object localObject1 = null;
    }
  }
  
  public static boolean ba(bo parambo)
  {
    AppMethodBeat.i(34412);
    az.ayM();
    bo.a locala = com.tencent.mm.model.c.awD().alw(parambo.field_content);
    if ((locala.zTO == null) || (locala.zTO.length() <= 0)) {
      ac.e("MicroMsg.ChattingEditModeLogic", "getView : parse possible friend msg failed");
    }
    if ((!w.nN(locala.Chb)) && (parambo.getType() == 42))
    {
      boolean bool = parambo.fbS();
      AppMethodBeat.o(34412);
      return bool;
    }
    AppMethodBeat.o(34412);
    return false;
  }
  
  public static boolean bb(bo parambo)
  {
    AppMethodBeat.i(34413);
    az.ayM();
    bo.a locala = com.tencent.mm.model.c.awD().alw(parambo.field_content);
    if ((locala.zTO == null) || (locala.zTO.length() <= 0)) {
      ac.e("MicroMsg.ChattingEditModeLogic", "getView : parse possible friend msg failed");
    }
    if ((!w.nN(locala.Chb)) && (parambo.getType() == 42))
    {
      if ((parambo.euk & 0x800) > 0)
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
  
  static boolean bc(bo parambo)
  {
    AppMethodBeat.i(34414);
    if (!parambo.fbB())
    {
      AppMethodBeat.o(34414);
      return false;
    }
    az.ayM();
    parambo = com.tencent.mm.model.c.awD().alw(parambo.field_content);
    if ((parambo == null) || (bs.isNullOrNil(parambo.zTO)))
    {
      AppMethodBeat.o(34414);
      return true;
    }
    if (w.wH(parambo.zTO))
    {
      AppMethodBeat.o(34414);
      return false;
    }
    AppMethodBeat.o(34414);
    return true;
  }
  
  private static boolean bd(bo parambo)
  {
    AppMethodBeat.i(34415);
    if ((parambo != null) && (parambo.cKN()))
    {
      parambo = k.b.vA(parambo.field_content);
      if ((parambo != null) && (parambo.type == 6) && ((parambo.hhJ != 0) || (parambo.hhF > 26214400)))
      {
        AppMethodBeat.o(34415);
        return true;
      }
    }
    AppMethodBeat.o(34415);
    return false;
  }
  
  public static boolean be(bo parambo)
  {
    AppMethodBeat.i(34416);
    if ((parambo != null) && (parambo.cKN()))
    {
      parambo = k.b.vA(parambo.field_content);
      if ((parambo != null) && (parambo.type == 6))
      {
        AppMethodBeat.o(34416);
        return true;
      }
    }
    AppMethodBeat.o(34416);
    return false;
  }
  
  public static void c(Context paramContext, final String paramString, final bo parambo)
  {
    AppMethodBeat.i(34430);
    if ((!a(paramContext, paramString, parambo, "video")) || (parambo == null))
    {
      AppMethodBeat.o(34430);
      return;
    }
    if ((parambo != null) && (parambo.crv()) && (com.tencent.mm.modelvideo.u.El(parambo.field_imgPath)))
    {
      AppMethodBeat.o(34430);
      return;
    }
    Object localObject = com.tencent.mm.modelvideo.u.Ej(parambo.field_imgPath);
    if ((localObject != null) && (((s)localObject).status == 199))
    {
      a(parambo.field_imgPath, paramString, ((s)localObject).iaM, ((s)localObject).hpy, ((s)localObject).aJK(), parambo.getType(), parambo.field_msgId);
      AppMethodBeat.o(34430);
      return;
    }
    Map localMap = bv.L(((s)localObject).aJK(), "msg");
    final int i;
    if (localMap == null)
    {
      ac.w("MicroMsg.ChattingEditModeLogic", "%s cdntra parse video recv xml failed");
      i = 0;
    }
    for (;;)
    {
      if (i == 0) {
        f(paramString, parambo);
      }
      AppMethodBeat.o(34430);
      return;
      paramContext = (String)localMap.get(".msg.videomsg.$cdnvideourl");
      if (bs.isNullOrNil(paramContext))
      {
        i = 0;
      }
      else
      {
        final String str1 = (String)localMap.get(".msg.videomsg.$aeskey");
        final String str2 = (String)localMap.get(".msg.videomsg.$md5");
        final String str3 = (String)localMap.get(".msg.videomsg.$newmd5");
        i = bs.getInt((String)localMap.get(".msg.videomsg.$length"), 0);
        final int j = bs.getInt((String)localMap.get(".msg.videomsg.$playlength"), 0);
        final int k = bs.getInt((String)localMap.get(".msg.videomsg.$cdnthumblength"), 0);
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1328L, 12L, 1L, true);
        if (bs.isNullOrNil(str2))
        {
          com.tencent.mm.modelvideo.o.aJy();
          if (!com.tencent.mm.vfs.i.eA(t.DV(((s)localObject).getFileName())))
          {
            ac.i("MicroMsg.ChattingEditModeLogic", "checkVideoCdnInfo md5 %s", new Object[] { str2 });
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1328L, 2L, 1L, true);
            i = 0;
            continue;
          }
        }
        localObject = new com.tencent.mm.i.g();
        ((com.tencent.mm.i.g)localObject).frb = new g.a()
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
              ac.i("MicroMsg.ChattingEditModeLogic", "support second!! sceneResult: %s", new Object[] { paramAnonymousd });
              paramAnonymousString = t.DU(com.tencent.mm.model.u.axw());
              com.tencent.mm.modelvideo.o.aJy();
              paramAnonymousc = t.DW(paramAnonymousString);
              com.tencent.mm.modelvideo.o.aJy();
              com.tencent.mm.vfs.i.lZ(t.DW(parambo.field_imgPath), paramAnonymousc);
              paramAnonymousc = "<msg><videomsg aeskey=\"" + str1 + "\" cdnthumbaeskey=\"" + str1 + "\" cdnvideourl=\"" + this.val$url + "\" ";
              paramAnonymousc = paramAnonymousc + "cdnthumburl=\"" + this.val$url + "\" ";
              paramAnonymousc = paramAnonymousc + "length=\"" + i + "\" ";
              paramAnonymousc = paramAnonymousc + "cdnthumblength=\"" + k + "\"/></msg>";
              ac.i("MicroMsg.ChattingEditModeLogic", "cdn callback new build cdnInfo:%s", new Object[] { paramAnonymousc });
              com.tencent.mm.modelvideo.u.b(paramAnonymousString, j, paramString, paramAnonymousc, (int)parambo.field_msgId);
              com.tencent.mm.kernel.g.agi().a(new com.tencent.mm.modelvideo.h(paramAnonymousString, 0, paramAnonymousd, new h.a()
              {
                public final void dm(int paramAnonymous2Int1, int paramAnonymous2Int2)
                {
                  AppMethodBeat.i(34393);
                  s locals = com.tencent.mm.modelvideo.u.Ej(paramAnonymousString);
                  locals.status = 111;
                  locals.drx = 256;
                  com.tencent.mm.modelvideo.o.aJy().c(locals);
                  ac.d("MicroMsg.ChattingEditModeLogic", "NetSceneUploadVideoForCdn callback, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
                  AppMethodBeat.o(34393);
                }
              }), 0);
            }
            for (;;)
            {
              AppMethodBeat.o(34394);
              return 0;
              label350:
              j.f(paramString, parambo);
            }
          }
          
          public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
          
          public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
          {
            return new byte[0];
          }
        };
        ((com.tencent.mm.i.g)localObject).field_mediaId = com.tencent.mm.an.c.a("checkExist", bs.eWj(), paramString, parambo.field_msgId);
        ((com.tencent.mm.i.g)localObject).field_fileId = paramContext;
        ((com.tencent.mm.i.g)localObject).field_aesKey = str1;
        ((com.tencent.mm.i.g)localObject).field_filemd5 = str2;
        ((com.tencent.mm.i.g)localObject).field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
        ((com.tencent.mm.i.g)localObject).field_talker = paramString;
        ((com.tencent.mm.i.g)localObject).field_priority = com.tencent.mm.i.a.fqp;
        ((com.tencent.mm.i.g)localObject).field_svr_signature = "";
        ((com.tencent.mm.i.g)localObject).field_onlycheckexist = true;
        ((com.tencent.mm.i.g)localObject).field_trysafecdn = true;
        if (!com.tencent.mm.an.f.aDD().f((com.tencent.mm.i.g)localObject))
        {
          ac.e("MicroMsg.ChattingEditModeLogic", "check exist fail! download video before retransmit");
          i = 0;
        }
        else
        {
          i = 1;
        }
      }
    }
  }
  
  public static void c(Context paramContext, String paramString, bo parambo, boolean paramBoolean)
  {
    AppMethodBeat.i(34433);
    if (!a(paramContext, paramString, parambo, "location"))
    {
      AppMethodBeat.o(34433);
      return;
    }
    paramContext = x(parambo.field_content, parambo.field_isSend, paramBoolean);
    com.tencent.mm.plugin.messenger.a.j.dck().X(paramString, paramContext, 48);
    AppMethodBeat.o(34433);
  }
  
  public static void c(EmojiInfo paramEmojiInfo, String paramString)
  {
    AppMethodBeat.i(34436);
    WXMediaMessage localWXMediaMessage = new WXMediaMessage();
    Object localObject = new StringBuilder();
    az.ayM();
    localObject = com.tencent.mm.model.c.awQ() + paramEmojiInfo.JC();
    if (com.tencent.mm.vfs.i.aSp((String)localObject + "_thumb") > 0L)
    {
      int i = (int)com.tencent.mm.vfs.i.aSp((String)localObject + "_thumb");
      localWXMediaMessage.thumbData = com.tencent.mm.vfs.i.aU((String)localObject + "_thumb", 0, i);
    }
    for (;;)
    {
      localWXMediaMessage.mediaObject = new WXEmojiObject((String)localObject);
      com.tencent.mm.pluginsdk.model.app.m.a(localWXMediaMessage, paramEmojiInfo.field_app_id, null, paramString, 1, paramEmojiInfo.JC());
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
        ac.printErrStackTrace("MicroMsg.ChattingEditModeLogic", localException, "", new Object[0]);
        ac.e("MicroMsg.ChattingEditModeLogic", "sendAppMsgEmoji Fail cause there is no thumb");
      }
    }
  }
  
  private static boolean d(bo parambo, String paramString)
  {
    AppMethodBeat.i(34411);
    az.ayM();
    bo.a locala = com.tencent.mm.model.c.awD().alw(parambo.field_content);
    if ((locala.zTO == null) || (locala.zTO.length() <= 0))
    {
      ac.e("MicroMsg.ChattingEditModeLogic", "getView : parse possible friend msg failed");
      AppMethodBeat.o(34411);
      return false;
    }
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pUi, 0) == 1) {}
    for (int i = 1; (i != 0) && ((ai.aNc(paramString)) || (ai.aNd(paramString)) || (parambo.getType() == 66)); i = 0)
    {
      AppMethodBeat.o(34411);
      return true;
    }
    AppMethodBeat.o(34411);
    return false;
  }
  
  private static boolean d(bo parambo, boolean paramBoolean)
  {
    AppMethodBeat.i(34410);
    if (!paramBoolean)
    {
      AppMethodBeat.o(34410);
      return false;
    }
    if (parambo != null)
    {
      parambo = k.b.vA(parambo.field_content);
      if ((parambo != null) && (parambo.type == 33) && (parambo.hkg == 1))
      {
        AppMethodBeat.o(34410);
        return true;
      }
    }
    AppMethodBeat.o(34410);
    return false;
  }
  
  static void f(final String paramString, bo parambo)
  {
    AppMethodBeat.i(34429);
    az.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34396);
        com.tencent.mm.modelvideo.o.aJD().a(this.hmq.field_imgPath, new t.a()
        {
          public final void a(t.a.a paramAnonymous2a)
          {
            AppMethodBeat.i(34395);
            paramAnonymous2a = com.tencent.mm.modelvideo.u.Ej(paramAnonymous2a.fileName);
            if ((paramAnonymous2a != null) && (paramAnonymous2a.status == 199)) {
              j.a(j.5.this.hmq.field_imgPath, j.5.this.fur, paramAnonymous2a.iaM, paramAnonymous2a.hpy, paramAnonymous2a.aJK(), j.5.this.hmq.getType(), j.5.this.hmq.field_msgId);
            }
            AppMethodBeat.o(34395);
          }
        });
        AppMethodBeat.o(34396);
      }
    });
    AppMethodBeat.o(34429);
  }
  
  public static List<String> fkV()
  {
    AppMethodBeat.i(34422);
    Object localObject1 = af.aCW().ov(25);
    Object localObject2 = af.aCW();
    Object localObject3 = new ArrayList();
    Object localObject4 = new StringBuilder();
    com.tencent.mm.al.e.a((StringBuilder)localObject4);
    com.tencent.mm.al.e.c((StringBuilder)localObject4);
    com.tencent.mm.al.e.d((StringBuilder)localObject4);
    com.tencent.mm.al.e.a((StringBuilder)localObject4, true);
    ((StringBuilder)localObject4).append(" order by ");
    ((StringBuilder)localObject4).append(com.tencent.mm.al.e.aCs());
    localObject4 = ((StringBuilder)localObject4).toString();
    ac.i("MicroMsg.BizInfoStorage", "getEnterpriseBizChatLst sql %s", new Object[] { localObject4 });
    localObject2 = ((com.tencent.mm.al.e)localObject2).rawQuery((String)localObject4, new String[0]);
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
      str = com.tencent.mm.al.f.dX((String)localObject4).IV();
      if (!bs.isNullOrNil(str)) {
        ((HashMap)localObject2).put(str, localObject4);
      }
    }
    localObject3 = new LinkedList();
    localObject4 = new LinkedList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      str = (String)((Iterator)localObject1).next();
      if (com.tencent.mm.al.f.AP(str))
      {
        if (com.tencent.mm.al.f.AT(str))
        {
          str = com.tencent.mm.al.f.dX(str).field_enterpriseFather;
          if ((!((List)localObject4).contains(str)) && (com.tencent.mm.al.f.AR(str)))
          {
            ((List)localObject4).add(str);
            str = (String)((HashMap)localObject2).get(str);
            if (!bs.isNullOrNil(str)) {
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
      if ((!bs.isNullOrNil((String)localObject2)) && (!((List)localObject4).contains(localObject2))) {
        ((List)localObject4).add(localObject2);
      }
    }
    ((List)localObject3).addAll((Collection)localObject4);
    ac.d("MicroMsg.ChattingEditModeLogic", "get selected accept list, size %d", new Object[] { Integer.valueOf(((List)localObject3).size()) });
    AppMethodBeat.o(34422);
    return localObject3;
  }
  
  public static List<String> fkW()
  {
    AppMethodBeat.i(34423);
    Object localObject = af.aCW().ov(25);
    LinkedList localLinkedList = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!com.tencent.mm.al.f.AP(str)) {
        localLinkedList.add(str);
      }
    }
    ac.d("MicroMsg.ChattingEditModeLogic", "get selected accept list without enterprise, size %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    AppMethodBeat.o(34423);
    return localLinkedList;
  }
  
  public static boolean hH(List<bo> paramList)
  {
    AppMethodBeat.i(34403);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ac.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to brand msg error, selected item empty");
      AppMethodBeat.o(34403);
      return true;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bo localbo = (bo)paramList.next();
      if ((localbo.eZl()) || (aP(localbo)) || (localbo.fbB()) || (aR(localbo)) || (aS(localbo)) || (localbo.getType() == -1879048186) || (aZ(localbo)) || (aT(localbo)) || (aY(localbo)) || (aU(localbo)) || (be(localbo)))
      {
        AppMethodBeat.o(34403);
        return true;
      }
    }
    AppMethodBeat.o(34403);
    return false;
  }
  
  public static int hI(List<bo> paramList)
  {
    AppMethodBeat.i(34417);
    if (paramList == null)
    {
      ac.w("MicroMsg.ChattingEditModeLogic", "get invalid send to friend msg num error, select item empty");
      AppMethodBeat.o(34417);
      return 0;
    }
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      bo localbo = (bo)paramList.next();
      if ((!localbo.eZl()) && (!aP(localbo)) && (!localbo.cKP()) && (!aR(localbo)) && (!aS(localbo)) && (!aT(localbo))) {
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
  
  public static boolean hJ(List<bo> paramList)
  {
    AppMethodBeat.i(34418);
    if (paramList == null)
    {
      ac.w("MicroMsg.ChattingEditModeLogic", "check contain undownload file, select item empty");
      AppMethodBeat.o(34418);
      return false;
    }
    Iterator localIterator = paramList.iterator();
    label382:
    label383:
    for (;;)
    {
      bo localbo;
      if (localIterator.hasNext())
      {
        localbo = (bo)localIterator.next();
        if ((localbo.eZm()) || (localbo.fbG()))
        {
          paramList = null;
          if (localbo.field_msgId > 0L) {
            paramList = com.tencent.mm.av.o.aFx().qg(localbo.field_msgId);
          }
          if (((paramList != null) && (paramList.dcd > 0L)) || (localbo.field_msgSvrId <= 0L)) {
            break label382;
          }
          paramList = com.tencent.mm.av.o.aFx().qf(localbo.field_msgSvrId);
        }
      }
      for (;;)
      {
        if ((paramList == null) || ((paramList.offset >= paramList.hux) && (paramList.hux != 0))) {
          break label383;
        }
        AppMethodBeat.o(34418);
        return true;
        if (localbo.crt())
        {
          paramList = com.tencent.mm.modelvideo.o.aJy().DT(localbo.field_imgPath);
          if ((paramList == null) || (paramList.status == 199) || (paramList.status == 199)) {
            break;
          }
          AppMethodBeat.o(34418);
          return true;
        }
        if (localbo.fbD())
        {
          if (aQ(localbo)) {
            break;
          }
          AppMethodBeat.o(34418);
          return true;
        }
        if (localbo.cKN())
        {
          paramList = k.b.az(localbo.field_content, localbo.field_content);
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
            paramList = com.tencent.mm.pluginsdk.model.app.ap.bEO().aGd(paramList.cZa);
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
        if (!localbo.crv()) {
          break;
        }
        paramList = com.tencent.mm.modelvideo.u.Ej(localbo.field_imgPath);
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
  
  public static boolean hK(List<bo> paramList)
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
      bo localbo = (bo)paramList.next();
      if ((localbo.crt()) && (com.tencent.mm.pluginsdk.model.l.aFZ(localbo.field_imgPath)))
      {
        AppMethodBeat.o(34419);
        return true;
      }
    }
    AppMethodBeat.o(34419);
    return false;
  }
  
  public static boolean hL(List<bo> paramList)
  {
    AppMethodBeat.i(34420);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(34420);
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((bo)paramList.next()).crv())
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
          str = com.tencent.mm.model.bi.ym(paramString);
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