package com.tencent.mm.storage;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.al.a.c;
import com.tencent.mm.al.a.d;
import com.tencent.mm.al.a.l;
import com.tencent.mm.al.af;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.az;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.plugin.messenger.foundation.a.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class q
  implements e, com.tencent.mm.plugin.messenger.foundation.a.f
{
  private bk GBR;
  
  public q(bk parambk)
  {
    AppMethodBeat.i(124594);
    af.aDk();
    this.GBR = parambk;
    this.GBR.a(this);
    this.GBR.a(this);
    AppMethodBeat.o(124594);
  }
  
  private void a(String paramString, ap paramap1, int paramInt1, int paramInt2, h.c paramc, ap paramap2)
  {
    AppMethodBeat.i(209580);
    bo localbo;
    a locala;
    c localc;
    Object localObject1;
    Object localObject2;
    label372:
    Object localObject3;
    if ((paramap1 != null) && (paramc != null) && (paramc.nxq != -1L) && (paramap1.lr(8388608)))
    {
      localbo = ((com.tencent.mm.al.p)g.ab(com.tencent.mm.al.p.class)).awE().bW(paramString, paramc.nxq);
      locala = af.aCZ().pT(paramc.nxq);
      localc = af.aCY().bd(paramc.nxq);
      if (localc.field_bizChatServId == null)
      {
        ac.w("MicroMsg.BizConversationStorage", "willen updateBizChatConversation bizChatInfo == null");
        AppMethodBeat.o(209580);
        return;
      }
      if ((localbo == null) || (localbo.field_msgId == 0L))
      {
        ac.i("MicroMsg.BizConversationStorage", "update null BizChatConversation with talker ".concat(String.valueOf(paramString)));
        locala.field_status = 0;
        locala.field_isSend = 0;
        locala.field_content = "";
        locala.field_msgType = "0";
        locala.field_unReadCount = 0;
        locala.field_digest = "";
        locala.field_digestUser = "";
        af.aCZ();
        com.tencent.mm.al.a.b.a(locala, paramInt2, paramInt1);
        af.aCZ().b(locala);
        AppMethodBeat.o(209580);
        return;
      }
      boolean bool = localc.isGroup();
      locala.field_brandUserName = paramString;
      if (localbo.fbA())
      {
        locala.field_content = localbo.fci();
        localObject1 = new PString();
        this.GBR.Ls().a(localbo, (PString)localObject1, new PString(), new PInt(), false);
        localObject1 = ((PString)localObject1).value;
        localObject2 = af.aDa().dP(localbo.field_bizChatUserId);
        if (!bool) {
          break label1008;
        }
        if ((localbo.field_isSend != 1) || (localObject2 == null)) {
          break label936;
        }
        locala.field_digest = (com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131755809) + ":" + (String)localObject1);
        ((com.tencent.mm.al.a.k)localObject2).field_userName = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131755809);
        localObject1 = null;
        localObject2 = this.GBR.cI(localbo.getType(), localbo.field_content);
        localObject3 = bs.nullAsNil(locala.field_digest);
        if ((!bs.isNullOrNil((String)localObject2)) && (!((String)localObject3).endsWith((String)localObject2))) {
          locala.field_digest = ((String)localObject3 + " " + (String)localObject2);
        }
        locala.field_digestUser = "";
        locala.field_chatType = localc.field_chatType;
        locala.field_lastMsgID = localbo.field_msgId;
        if (!localbo.crv()) {
          break label1021;
        }
      }
    }
    label1038:
    label1178:
    for (;;)
    {
      long l = localbo.field_createTime;
      label494:
      locala.field_lastMsgTime = l;
      locala.field_status = localbo.field_status;
      locala.field_isSend = localbo.field_isSend;
      locala.field_msgType = Integer.toString(localbo.getType());
      locala.field_flag = com.tencent.mm.al.a.b.a(locala, 1, localbo.field_createTime);
      int j = 0;
      int i;
      if ((!paramc.uHb.equals("insert")) || (paramc.rnT <= 0))
      {
        i = j;
        if (paramc.uHb.equals("update"))
        {
          i = j;
          if (locala.field_unReadCount + paramc.rnT < 0) {}
        }
      }
      else
      {
        locala.field_unReadCount += paramc.rnT;
        locala.field_newUnReadCount += paramc.rnT;
        i = j;
        if (paramc.rnT > 0)
        {
          i = j;
          if (localc.hc(1))
          {
            i = paramap1.field_unReadCount - paramc.rnT;
            if (i > 0) {
              break label1038;
            }
            paramap1.jR(0);
          }
        }
      }
      for (;;)
      {
        paramap1.jX(paramap1.field_unReadMuteCount + paramc.rnT);
        i = 1;
        j = i;
        if (!paramc.uHb.equals("insert")) {
          break label1051;
        }
        j = i;
        if (paramc.gtT.size() <= 0) {
          break label1051;
        }
        j = i;
        if (!localc.isGroup()) {
          break label1051;
        }
        localObject2 = af.aDa().dQ(localbo.field_talker);
        paramc = paramc.gtT.iterator();
        while (paramc.hasNext())
        {
          localObject3 = (bo)paramc.next();
          if ((localObject2 != null) && (((dy)localObject3).field_isSend != 1) && (((bo)localObject3).isText()))
          {
            if (((bo)localObject3).aOj((String)localObject2))
            {
              locala.field_atCount += 1;
              paramap1.jW(paramap1.field_atCount + 1);
              if (paramap2 != null) {
                paramap2.jW(paramap2.field_atCount + 1);
              }
              i = 1;
            }
            if (aMI(((dy)localObject3).eul))
            {
              locala.field_atAll = 1;
              paramap1.jW(paramap1.field_atCount + 4096);
              if (paramap2 != null) {
                paramap2.jW(paramap2.field_atCount + 1);
              }
              i = 1;
            }
          }
        }
        locala.field_content = localbo.field_content;
        break;
        label936:
        if ((localObject2 != null) && (!bs.isNullOrNil(((com.tencent.mm.al.a.k)localObject2).field_userName)))
        {
          locala.field_digest = (((com.tencent.mm.al.a.k)localObject2).field_userName + ":" + (String)localObject1);
          localObject1 = ((com.tencent.mm.al.a.k)localObject2).field_userName;
          break label372;
        }
        locala.field_digest = ((String)localObject1);
        localObject1 = null;
        break label372;
        label1008:
        locala.field_digest = ((String)localObject1);
        localObject1 = null;
        break label372;
        label1021:
        if (localbo.field_status != 1) {
          break label1178;
        }
        l = 9223372036854775807L;
        break label494;
        paramap1.jR(i);
      }
      j = i;
      label1051:
      af.aCZ();
      com.tencent.mm.al.a.b.a(locala, paramInt2, paramInt1);
      paramc = (h.c)localObject1;
      if (bs.isNullOrNil((String)localObject1)) {
        paramc = localc.wk(localbo.field_bizChatUserId);
      }
      ac.i("MicroMsg.BizConversationStorage", "updateBizChatConversation brandUserName:%s, bizChatId:%s, userId:%s, displayName:%s", new Object[] { paramString, localc.field_bizChatServId, localbo.field_bizChatUserId, paramc });
      af.aCZ().b(locala);
      if (j != 0)
      {
        this.GBR.a(paramap1, paramString);
        if (paramap2 != null) {
          this.GBR.a(paramap2, paramap2.field_username);
        }
      }
      AppMethodBeat.o(209580);
      return;
    }
  }
  
  private static boolean aMI(String paramString)
  {
    AppMethodBeat.i(124599);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(124599);
      return false;
    }
    paramString = bv.L(paramString, "msgsource");
    if (paramString == null)
    {
      AppMethodBeat.o(124599);
      return false;
    }
    try
    {
      if (Integer.parseInt((String)paramString.get(".msgsource.atall")) > 0)
      {
        AppMethodBeat.o(124599);
        return true;
      }
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(124599);
      return false;
    }
    AppMethodBeat.o(124599);
    return false;
  }
  
  public static void aMK(String paramString)
  {
    AppMethodBeat.i(124601);
    bk localbk = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG();
    paramString = new ap(paramString);
    paramString.qT("officialaccounts");
    b(paramString, localbk);
    AppMethodBeat.o(124601);
  }
  
  public static void b(ap paramap, bk parambk)
  {
    AppMethodBeat.i(124602);
    if ((paramap == null) || (parambk == null))
    {
      AppMethodBeat.o(124602);
      return;
    }
    ap localap;
    if ((w.wH(paramap.field_username)) && (!bs.isNullOrNil(paramap.field_parentRef)))
    {
      if ((v.bIO()) && (w.xg(paramap.field_parentRef)))
      {
        AppMethodBeat.o(124602);
        return;
      }
      localap = parambk.aNI(paramap.field_parentRef);
      ac.v("MicroMsg.BizConversationStorage", "postConvExt, username = %s, parentRef = %s", new Object[] { paramap.field_username, paramap.field_parentRef });
      if (paramap.field_parentRef.equals("officialaccounts")) {
        break label550;
      }
    }
    label550:
    for (int i = 1;; i = 0)
    {
      if (localap == null)
      {
        localap = new ap(paramap.field_parentRef);
        if (i != 0) {
          localap.lp(2097152);
        }
      }
      for (int j = 1;; j = 0)
      {
        if ((i != 0) && (localap.field_attrflag == 0))
        {
          localap.lp(2097152);
          ac.v("MicroMsg.BizConversationStorage", "Enterprise cvs reset attr flag!");
        }
        ac.i("MicroMsg.BizConversationStorage", "enterprise cvs count is %d", new Object[] { Integer.valueOf(localap.field_unReadCount) });
        Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().aNV(paramap.field_parentRef);
        bo localbo = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().alk((String)localObject);
        if ((localbo != null) && (localbo.field_msgId > 0L))
        {
          localap.aI(localbo);
          localap.setContent(localbo.field_talker + ":" + localbo.field_content);
          localap.qQ(Integer.toString(localbo.getType()));
          localObject = parambk.Ls();
          if (localObject != null)
          {
            PString localPString1 = new PString();
            PString localPString2 = new PString();
            PInt localPInt = new PInt();
            localbo.re(paramap.field_parentRef);
            localbo.setContent(localap.field_content);
            ((bk.b)localObject).a(localbo, localPString1, localPString2, localPInt, true);
            localap.qR(localPString1.value);
            localap.qS(localPString2.value);
            localap.jU(localPInt.value);
          }
        }
        for (;;)
        {
          int m = 0;
          int k = m;
          if (i != 0)
          {
            k = m;
            if (parambk.aNU(localap.field_username) <= 0) {
              k = 1;
            }
          }
          if (k == 0) {
            break;
          }
          parambk.aNG(localap.field_username);
          AppMethodBeat.o(124602);
          return;
          localap.faH();
          ac.i("MicroMsg.BizConversationStorage", "lastOfMsg is null or MsgId <= 0, lastConvBiz is %s", new Object[] { localObject });
        }
        if (j != 0)
        {
          parambk.e(localap);
          AppMethodBeat.o(124602);
          return;
        }
        parambk.a(localap, localap.field_username);
        AppMethodBeat.o(124602);
        return;
      }
    }
  }
  
  private static boolean b(h.c paramc)
  {
    AppMethodBeat.i(209581);
    try
    {
      boolean bool = af.aCY().bd(paramc.nxq).hc(1);
      AppMethodBeat.o(209581);
      return bool;
    }
    catch (Throwable paramc)
    {
      AppMethodBeat.o(209581);
    }
    return false;
  }
  
  public final void a(bo parambo, ap paramap)
  {
    Object localObject = null;
    AppMethodBeat.i(124595);
    if ((paramap != null) && (parambo != null) && (parambo.field_bizChatId != -1L) && (paramap.lr(8388608)))
    {
      c localc = af.aCY().bd(parambo.field_bizChatId);
      String str2 = paramap.field_digest;
      if (!bs.isNullOrNil(parambo.field_bizChatUserId))
      {
        com.tencent.mm.al.a.k localk = af.aDa().dP(parambo.field_bizChatUserId);
        String str1;
        boolean bool;
        if (localk != null)
        {
          str1 = localk.field_userName;
          bool = parambo.field_bizChatUserId.equals(af.aDa().dQ(parambo.field_talker));
          if ((localk == null) || (!bool)) {
            break label218;
          }
          paramap.qR(com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131755809) + ":" + str2);
        }
        for (;;)
        {
          if (!localc.isGroup())
          {
            if ((!bool) && (str1 != null) && (str1.length() > 0) && (!str1.equals(localc.field_chatName)))
            {
              localc.field_chatName = str1;
              af.aCY().b(localc);
              AppMethodBeat.o(124595);
              return;
              str1 = null;
              break;
              label218:
              if ((localk == null) || (bs.isNullOrNil(localk.field_userName))) {
                continue;
              }
              paramap.qR(localk.field_userName + ":" + str2);
              continue;
            }
            paramap = af.aDa().dP(localc.field_bizChatServId);
            parambo = localObject;
            if (paramap != null) {
              parambo = paramap.field_userName;
            }
            if ((parambo != null) && (parambo.length() > 0) && (!parambo.equals(localc.field_chatName)))
            {
              localc.field_chatName = parambo;
              af.aCY().b(localc);
            }
          }
        }
        AppMethodBeat.o(124595);
        return;
      }
      ac.w("MicroMsg.BizConversationStorage", "BizChatUserId is null:%s %s", new Object[] { localc.field_bizChatServId, localc.field_chatName });
    }
    AppMethodBeat.o(124595);
  }
  
  public final void a(bo parambo, ap paramap, boolean paramBoolean, h.c paramc)
  {
    AppMethodBeat.i(124596);
    if (paramc == null)
    {
      ac.e("MicroMsg.BizConversationStorage", "compose notifyInfo is null");
      AppMethodBeat.o(124596);
      return;
    }
    String str = paramc.talker;
    if (paramBoolean)
    {
      if ((parambo != null) && (parambo.field_isSend != 1) && ((com.tencent.mm.model.bk.w(parambo) & 0x1) != 0))
      {
        ac.i("MicroMsg.BizConversationStorage", "create a temp session conversation.");
        paramap.lp(4194304);
      }
      if ((parambo != null) && (com.tencent.mm.al.f.so(str)))
      {
        ac.i("MicroMsg.BizConversationStorage", "create a bitChat conversation.");
        paramap.lp(8388608);
      }
    }
    for (;;)
    {
      if ((paramc != null) && (!paramc.gtT.isEmpty()) && (paramc.gtT.get(0) != null))
      {
        paramap.jT(((bo)paramc.gtT.get(0)).field_isSend);
        if (paramc.uHb.equals("insert")) {
          paramap.GWX = ((bo)paramc.gtT.get(paramc.gtT.size() - 1));
        }
      }
      AppMethodBeat.o(124596);
      return;
      ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(str);
      if ((localai != null) && (localai.fad()) && (!com.tencent.mm.n.b.ln(localai.field_type)) && (parambo != null) && (parambo.field_isSend != 1) && (!paramap.lr(4194304)) && ((paramap.field_conversationTime < af.aDk()) || ((com.tencent.mm.model.bk.w(parambo) & 0x1) != 0)))
      {
        paramap.lp(4194304);
        ac.i("MicroMsg.BizConversationStorage", "onNotifyChange is old temp session, %s", new Object[] { str });
      }
      if ((parambo != null) && (com.tencent.mm.al.f.so(str)))
      {
        ac.i("MicroMsg.BizConversationStorage", "onNotifyChange a bitChat conversation, %s", new Object[] { str });
        paramap.lp(8388608);
      }
    }
  }
  
  public final void aMJ(String paramString)
  {
    AppMethodBeat.i(124600);
    if ((paramString == null) || (!w.wH(paramString)) || (!com.tencent.mm.al.f.AR(paramString)))
    {
      AppMethodBeat.o(124600);
      return;
    }
    ap localap = this.GBR.aNI(paramString);
    if (localap == null)
    {
      AppMethodBeat.o(124600);
      return;
    }
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().aNV(paramString);
    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().alk((String)localObject);
    if ((localObject != null) && (((dy)localObject).field_msgId > 0L))
    {
      localap.aI((bo)localObject);
      localap.setContent(((dy)localObject).field_talker + ":" + ((dy)localObject).field_content);
      localap.qQ(Integer.toString(((bo)localObject).getType()));
      bk.b localb = this.GBR.Ls();
      if (localb == null) {
        break label277;
      }
      PString localPString1 = new PString();
      PString localPString2 = new PString();
      PInt localPInt = new PInt();
      ((bo)localObject).re(paramString);
      ((bo)localObject).setContent(localap.field_content);
      localb.a((bo)localObject, localPString1, localPString2, localPInt, true);
      localap.qR(localPString1.value);
      localap.qS(localPString2.value);
      localap.jU(localPInt.value);
    }
    for (;;)
    {
      this.GBR.a(localap, localap.field_username);
      AppMethodBeat.o(124600);
      return;
      label277:
      localap.faH();
    }
  }
  
  public final void b(bo parambo, ap paramap, boolean paramBoolean, h.c paramc)
  {
    AppMethodBeat.i(124597);
    bk localbk = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG();
    String str;
    if (paramc == null)
    {
      str = null;
      if ((paramc == null) || (!paramc.uHb.equals("delete")) || (paramc.uHd <= 0)) {
        break label948;
      }
    }
    label673:
    label948:
    for (int i = paramc.uHd;; i = 0)
    {
      if ((paramc != null) && (paramc.uHb.equals("insert")) && (paramc.uHc > 0)) {}
      for (int j = paramc.uHc;; j = 0)
      {
        Object localObject1;
        label243:
        Object localObject3;
        Object localObject2;
        PString localPString;
        PInt localPInt;
        if (!bs.isNullOrNil(paramap.field_parentRef))
        {
          parambo = localbk.aNI(paramap.field_parentRef);
          if ((parambo != null) && (parambo.lr(2097152))) {
            if (j > 0)
            {
              if (((paramc.uHb.equals("insert")) && (paramc.rnT > 0)) || ((paramc.uHb.equals("update")) && (parambo.field_unReadCount + paramc.rnT >= 0)))
              {
                localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(str);
                if ((localObject1 != null) && ((((ai)localObject1).Nw()) || (b(paramc)))) {
                  parambo.jX(parambo.field_unReadMuteCount + j);
                }
              }
              else
              {
                localbk.a(paramap, i, j);
              }
            }
            else
            {
              localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().aNV(paramap.field_parentRef);
              localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().alk((String)localObject1);
              if ((localObject3 == null) || (((dy)localObject3).field_msgId <= 0L)) {
                break label711;
              }
              parambo.aI((bo)localObject3);
              parambo.setContent(((dy)localObject3).field_talker + ":" + ((dy)localObject3).field_content);
              parambo.qQ(Integer.toString(((bo)localObject3).getType()));
              if (localbk.Ls() != null)
              {
                localObject2 = new PString();
                localPString = new PString();
                localPInt = new PInt();
                ((bo)localObject3).re(paramap.field_parentRef);
                ((bo)localObject3).setContent(parambo.field_content);
                localbk.Ls().a((bo)localObject3, (PString)localObject2, localPString, localPInt, true);
                localObject1 = localbk.cI(((bo)localObject3).getType(), ((dy)localObject3).field_content);
                if (((dy)localObject3).field_bizChatId == -1L) {
                  break label673;
                }
              }
            }
          }
        }
        for (;;)
        {
          try
          {
            localObject3 = af.aDa().dP(((dy)localObject3).field_bizChatUserId);
            ((PString)localObject2).value = String.format(((PString)localObject2).value, new Object[] { ((com.tencent.mm.al.a.k)localObject3).field_userName });
            parambo.qS("");
            localObject2 = bs.nullAsNil(((PString)localObject2).value);
            if (bs.isNullOrNil((String)localObject1))
            {
              localObject1 = "";
              parambo.qR(((String)localObject2).concat((String)localObject1));
              parambo.jU(localPInt.value);
              if (localbk.a(parambo, paramap.field_parentRef) > 0)
              {
                ac.d("MicroMsg.BizConversationStorage", "hakon update parent conversation's unread %s, %d", new Object[] { paramap.field_parentRef, Integer.valueOf(parambo.field_unReadCount + j) });
                localbk.b(3, (n)localbk, paramap.field_parentRef);
              }
              a(str, paramap, j, i, paramc, parambo);
              AppMethodBeat.o(124597);
              return;
              str = paramc.talker;
              break;
              parambo.jR(parambo.field_unReadCount + j);
              break label243;
              parambo.qS(localPString.value);
              continue;
            }
            localObject1 = " " + bs.nullAsNil((String)localObject1);
            continue;
            label711:
            parambo.faH();
            continue;
            if ((parambo != null) && ("officialaccounts".equals(parambo.field_username)))
            {
              if ((j > 0) && (!v.bIO()) && (((paramc.uHb.equals("insert")) && (paramc.rnT > 0)) || ((paramc.uHb.equals("update")) && (parambo.field_unReadCount + paramc.rnT >= 0))))
              {
                parambo.jR(parambo.field_unReadCount + j);
                localbk.a(parambo, paramap.field_parentRef);
              }
            }
            else if ((parambo != null) && ("appbrandcustomerservicemsg".equals(parambo.field_username)) && (j > 0))
            {
              if (((paramc.uHb.equals("insert")) && (paramc.rnT > 0)) || ((paramc.uHb.equals("update")) && (parambo.field_unReadCount + paramc.rnT >= 0))) {
                parambo.jR(parambo.field_unReadCount + j);
              }
              localbk.a(paramap, i, j);
              localbk.a(parambo, paramap.field_parentRef);
            }
            continue;
          }
          catch (Throwable localThrowable)
          {
            continue;
          }
          parambo = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.q
 * JD-Core Version:    0.7.0.1
 */