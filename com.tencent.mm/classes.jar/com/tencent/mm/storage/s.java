package com.tencent.mm.storage;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.a.a;
import com.tencent.mm.am.a.c;
import com.tencent.mm.am.a.d;
import com.tencent.mm.am.a.k;
import com.tencent.mm.am.ag;
import com.tencent.mm.am.q;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.f;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class s
  implements f, com.tencent.mm.plugin.messenger.foundation.a.g
{
  private bq Iof;
  
  public s(bq parambq)
  {
    AppMethodBeat.i(124594);
    ag.aGn();
    this.Iof = parambq;
    this.Iof.a(this);
    this.Iof.a(this);
    AppMethodBeat.o(124594);
  }
  
  private void a(String paramString, at paramat1, int paramInt1, int paramInt2, i.c paramc, at paramat2)
  {
    AppMethodBeat.i(207265);
    bu localbu;
    a locala;
    c localc;
    Object localObject1;
    Object localObject2;
    label372:
    Object localObject3;
    if ((paramat1 != null) && (paramc != null) && (paramc.nYO != -1L) && (paramat1.lQ(8388608)))
    {
      localbu = ((q)com.tencent.mm.kernel.g.ab(q.class)).azt().ca(paramString, paramc.nYO);
      locala = ag.aGc().rS(paramc.nYO);
      localc = ag.aGb().bd(paramc.nYO);
      if (localc.field_bizChatServId == null)
      {
        ad.w("MicroMsg.BizConversationStorage", "willen updateBizChatConversation bizChatInfo == null");
        AppMethodBeat.o(207265);
        return;
      }
      if ((localbu == null) || (localbu.field_msgId == 0L))
      {
        ad.i("MicroMsg.BizConversationStorage", "update null BizChatConversation with talker ".concat(String.valueOf(paramString)));
        locala.field_status = 0;
        locala.field_isSend = 0;
        locala.field_content = "";
        locala.field_msgType = "0";
        locala.field_unReadCount = 0;
        locala.field_digest = "";
        locala.field_digestUser = "";
        ag.aGc();
        com.tencent.mm.am.a.b.a(locala, paramInt2, paramInt1);
        ag.aGc().b(locala);
        AppMethodBeat.o(207265);
        return;
      }
      boolean bool = localc.isGroup();
      locala.field_brandUserName = paramString;
      if (localbu.frD())
      {
        locala.field_content = localbu.fsp();
        localObject1 = new PString();
        this.Iof.Na().a(localbu, (PString)localObject1, new PString(), new PInt(), false);
        localObject1 = ((PString)localObject1).value;
        localObject2 = ag.aGd().eK(localbu.field_bizChatUserId);
        if (!bool) {
          break label1008;
        }
        if ((localbu.field_isSend != 1) || (localObject2 == null)) {
          break label936;
        }
        locala.field_digest = (aj.getContext().getString(2131755809) + ":" + (String)localObject1);
        ((k)localObject2).field_userName = aj.getContext().getString(2131755809);
        localObject1 = null;
        localObject2 = this.Iof.cP(localbu.getType(), localbu.field_content);
        localObject3 = bt.nullAsNil(locala.field_digest);
        if ((!bt.isNullOrNil((String)localObject2)) && (!((String)localObject3).endsWith((String)localObject2))) {
          locala.field_digest = ((String)localObject3 + " " + (String)localObject2);
        }
        locala.field_digestUser = "";
        locala.field_chatType = localc.field_chatType;
        locala.field_lastMsgID = localbu.field_msgId;
        if (!localbu.cxh()) {
          break label1021;
        }
      }
    }
    label1038:
    label1178:
    for (;;)
    {
      long l = localbu.field_createTime;
      label494:
      locala.field_lastMsgTime = l;
      locala.field_status = localbu.field_status;
      locala.field_isSend = localbu.field_isSend;
      locala.field_msgType = Integer.toString(localbu.getType());
      locala.field_flag = com.tencent.mm.am.a.b.a(locala, 1, localbu.field_createTime);
      int j = 0;
      int i;
      if ((!paramc.vKe.equals("insert")) || (paramc.scY <= 0))
      {
        i = j;
        if (paramc.vKe.equals("update"))
        {
          i = j;
          if (locala.field_unReadCount + paramc.scY < 0) {}
        }
      }
      else
      {
        locala.field_unReadCount += paramc.scY;
        locala.field_newUnReadCount += paramc.scY;
        i = j;
        if (paramc.scY > 0)
        {
          i = j;
          if (localc.hj(1))
          {
            i = paramat1.field_unReadCount - paramc.scY;
            if (i > 0) {
              break label1038;
            }
            paramat1.kp(0);
          }
        }
      }
      for (;;)
      {
        paramat1.kv(paramat1.field_unReadMuteCount + paramc.scY);
        i = 1;
        j = i;
        if (!paramc.vKe.equals("insert")) {
          break label1051;
        }
        j = i;
        if (paramc.gNE.size() <= 0) {
          break label1051;
        }
        j = i;
        if (!localc.isGroup()) {
          break label1051;
        }
        localObject2 = ag.aGd().eL(localbu.field_talker);
        paramc = paramc.gNE.iterator();
        while (paramc.hasNext())
        {
          localObject3 = (bu)paramc.next();
          if ((localObject2 != null) && (((ei)localObject3).field_isSend != 1) && (((bu)localObject3).isText()))
          {
            if (((bu)localObject3).aUa((String)localObject2))
            {
              locala.field_atCount += 1;
              paramat1.ku(paramat1.field_atCount + 1);
              if (paramat2 != null) {
                paramat2.ku(paramat2.field_atCount + 1);
              }
              i = 1;
            }
            if (aSu(((ei)localObject3).eLs))
            {
              locala.field_atAll = 1;
              paramat1.ku(paramat1.field_atCount + 4096);
              if (paramat2 != null) {
                paramat2.ku(paramat2.field_atCount + 1);
              }
              i = 1;
            }
          }
        }
        locala.field_content = localbu.field_content;
        break;
        label936:
        if ((localObject2 != null) && (!bt.isNullOrNil(((k)localObject2).field_userName)))
        {
          locala.field_digest = (((k)localObject2).field_userName + ":" + (String)localObject1);
          localObject1 = ((k)localObject2).field_userName;
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
        if (localbu.field_status != 1) {
          break label1178;
        }
        l = 9223372036854775807L;
        break label494;
        paramat1.kp(i);
      }
      j = i;
      label1051:
      ag.aGc();
      com.tencent.mm.am.a.b.a(locala, paramInt2, paramInt1);
      paramc = (i.c)localObject1;
      if (bt.isNullOrNil((String)localObject1)) {
        paramc = localc.zf(localbu.field_bizChatUserId);
      }
      ad.i("MicroMsg.BizConversationStorage", "updateBizChatConversation brandUserName:%s, bizChatId:%s, userId:%s, displayName:%s", new Object[] { paramString, localc.field_bizChatServId, localbu.field_bizChatUserId, paramc });
      ag.aGc().b(locala);
      if (j != 0)
      {
        this.Iof.a(paramat1, paramString);
        if (paramat2 != null) {
          this.Iof.a(paramat2, paramat2.field_username);
        }
      }
      AppMethodBeat.o(207265);
      return;
    }
  }
  
  private static boolean aSu(String paramString)
  {
    AppMethodBeat.i(124599);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(124599);
      return false;
    }
    paramString = bw.M(paramString, "msgsource");
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
  
  public static void aSw(String paramString)
  {
    AppMethodBeat.i(124601);
    bq localbq = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azv();
    paramString = new at(paramString);
    paramString.tD("officialaccounts");
    b(paramString, localbq);
    AppMethodBeat.o(124601);
  }
  
  public static void b(at paramat, bq parambq)
  {
    AppMethodBeat.i(124602);
    if ((paramat == null) || (parambq == null))
    {
      AppMethodBeat.o(124602);
      return;
    }
    at localat;
    if ((w.zE(paramat.field_username)) && (!bt.isNullOrNil(paramat.field_parentRef)))
    {
      if ((y.bNf()) && (w.Ad(paramat.field_parentRef)))
      {
        AppMethodBeat.o(124602);
        return;
      }
      localat = parambq.aTz(paramat.field_parentRef);
      ad.v("MicroMsg.BizConversationStorage", "postConvExt, username = %s, parentRef = %s", new Object[] { paramat.field_username, paramat.field_parentRef });
      if (paramat.field_parentRef.equals("officialaccounts")) {
        break label550;
      }
    }
    label550:
    for (int i = 1;; i = 0)
    {
      if (localat == null)
      {
        localat = new at(paramat.field_parentRef);
        if (i != 0) {
          localat.lO(2097152);
        }
      }
      for (int j = 1;; j = 0)
      {
        if ((i != 0) && (localat.field_attrflag == 0))
        {
          localat.lO(2097152);
          ad.v("MicroMsg.BizConversationStorage", "Enterprise cvs reset attr flag!");
        }
        ad.i("MicroMsg.BizConversationStorage", "enterprise cvs count is %d", new Object[] { Integer.valueOf(localat.field_unReadCount) });
        Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azv().aTM(paramat.field_parentRef);
        bu localbu = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().apX((String)localObject);
        if ((localbu != null) && (localbu.field_msgId > 0L))
        {
          localat.aL(localbu);
          localat.setContent(localbu.field_talker + ":" + localbu.field_content);
          localat.tA(Integer.toString(localbu.getType()));
          localObject = parambq.Na();
          if (localObject != null)
          {
            PString localPString1 = new PString();
            PString localPString2 = new PString();
            PInt localPInt = new PInt();
            localbu.tN(paramat.field_parentRef);
            localbu.setContent(localat.field_content);
            ((bq.b)localObject).a(localbu, localPString1, localPString2, localPInt, true);
            localat.tB(localPString1.value);
            localat.tC(localPString2.value);
            localat.ks(localPInt.value);
          }
        }
        for (;;)
        {
          int m = 0;
          int k = m;
          if (i != 0)
          {
            k = m;
            if (parambq.aTL(localat.field_username) <= 0) {
              k = 1;
            }
          }
          if (k == 0) {
            break;
          }
          parambq.aTx(localat.field_username);
          AppMethodBeat.o(124602);
          return;
          localat.fqK();
          ad.i("MicroMsg.BizConversationStorage", "lastOfMsg is null or MsgId <= 0, lastConvBiz is %s", new Object[] { localObject });
        }
        if (j != 0)
        {
          parambq.e(localat);
          AppMethodBeat.o(124602);
          return;
        }
        parambq.a(localat, localat.field_username);
        AppMethodBeat.o(124602);
        return;
      }
    }
  }
  
  private static boolean b(i.c paramc)
  {
    AppMethodBeat.i(207266);
    try
    {
      boolean bool = ag.aGb().bd(paramc.nYO).hj(1);
      AppMethodBeat.o(207266);
      return bool;
    }
    catch (Throwable paramc)
    {
      AppMethodBeat.o(207266);
    }
    return false;
  }
  
  public final void a(bu parambu, i.c paramc, boolean[] paramArrayOfBoolean) {}
  
  public final void a(bu parambu, at paramat)
  {
    Object localObject = null;
    AppMethodBeat.i(124595);
    if ((paramat != null) && (parambu != null) && (parambu.field_bizChatId != -1L) && (paramat.lQ(8388608)))
    {
      c localc = ag.aGb().bd(parambu.field_bizChatId);
      String str2 = paramat.field_digest;
      if (!bt.isNullOrNil(parambu.field_bizChatUserId))
      {
        k localk = ag.aGd().eK(parambu.field_bizChatUserId);
        String str1;
        boolean bool;
        if (localk != null)
        {
          str1 = localk.field_userName;
          bool = parambu.field_bizChatUserId.equals(ag.aGd().eL(parambu.field_talker));
          if ((localk == null) || (!bool)) {
            break label218;
          }
          paramat.tB(aj.getContext().getString(2131755809) + ":" + str2);
        }
        for (;;)
        {
          if (!localc.isGroup())
          {
            if ((!bool) && (str1 != null) && (str1.length() > 0) && (!str1.equals(localc.field_chatName)))
            {
              localc.field_chatName = str1;
              ag.aGb().b(localc);
              AppMethodBeat.o(124595);
              return;
              str1 = null;
              break;
              label218:
              if ((localk == null) || (bt.isNullOrNil(localk.field_userName))) {
                continue;
              }
              paramat.tB(localk.field_userName + ":" + str2);
              continue;
            }
            paramat = ag.aGd().eK(localc.field_bizChatServId);
            parambu = localObject;
            if (paramat != null) {
              parambu = paramat.field_userName;
            }
            if ((parambu != null) && (parambu.length() > 0) && (!parambu.equals(localc.field_chatName)))
            {
              localc.field_chatName = parambu;
              ag.aGb().b(localc);
            }
          }
        }
        AppMethodBeat.o(124595);
        return;
      }
      ad.w("MicroMsg.BizConversationStorage", "BizChatUserId is null:%s %s", new Object[] { localc.field_bizChatServId, localc.field_chatName });
    }
    AppMethodBeat.o(124595);
  }
  
  public final void a(bu parambu, at paramat, boolean paramBoolean, i.c paramc)
  {
    AppMethodBeat.i(124596);
    if (paramc == null)
    {
      ad.e("MicroMsg.BizConversationStorage", "compose notifyInfo is null");
      AppMethodBeat.o(124596);
      return;
    }
    String str = paramc.talker;
    if (paramBoolean)
    {
      if ((parambu != null) && (parambu.field_isSend != 1) && ((bl.y(parambu) & 0x1) != 0))
      {
        ad.i("MicroMsg.BizConversationStorage", "create a temp session conversation.");
        paramat.lO(4194304);
      }
      if ((parambu != null) && (com.tencent.mm.am.g.vd(str)))
      {
        ad.i("MicroMsg.BizConversationStorage", "create a bitChat conversation.");
        paramat.lO(8388608);
      }
    }
    for (;;)
    {
      if ((paramc != null) && (!paramc.gNE.isEmpty()) && (paramc.gNE.get(0) != null))
      {
        paramat.kr(((bu)paramc.gNE.get(0)).field_isSend);
        if (paramc.vKe.equals("insert")) {
          paramat.IKk = ((bu)paramc.gNE.get(paramc.gNE.size() - 1));
        }
      }
      AppMethodBeat.o(124596);
      return;
      am localam = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(str);
      if ((localam != null) && (localam.fqg()) && (!com.tencent.mm.o.b.lM(localam.field_type)) && (parambu != null) && (parambu.field_isSend != 1) && (!paramat.lQ(4194304)) && ((paramat.field_conversationTime < ag.aGn()) || ((bl.y(parambu) & 0x1) != 0)))
      {
        paramat.lO(4194304);
        ad.i("MicroMsg.BizConversationStorage", "onNotifyChange is old temp session, %s", new Object[] { str });
      }
      if ((parambu != null) && (com.tencent.mm.am.g.vd(str)))
      {
        ad.i("MicroMsg.BizConversationStorage", "onNotifyChange a bitChat conversation, %s", new Object[] { str });
        paramat.lO(8388608);
      }
    }
  }
  
  public final void aSv(String paramString)
  {
    AppMethodBeat.i(124600);
    if ((paramString == null) || (!w.zE(paramString)) || (!com.tencent.mm.am.g.DQ(paramString)))
    {
      AppMethodBeat.o(124600);
      return;
    }
    at localat = this.Iof.aTz(paramString);
    if (localat == null)
    {
      AppMethodBeat.o(124600);
      return;
    }
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azv().aTM(paramString);
    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().apX((String)localObject);
    if ((localObject != null) && (((ei)localObject).field_msgId > 0L))
    {
      localat.aL((bu)localObject);
      localat.setContent(((ei)localObject).field_talker + ":" + ((ei)localObject).field_content);
      localat.tA(Integer.toString(((bu)localObject).getType()));
      bq.b localb = this.Iof.Na();
      if (localb == null) {
        break label277;
      }
      PString localPString1 = new PString();
      PString localPString2 = new PString();
      PInt localPInt = new PInt();
      ((bu)localObject).tN(paramString);
      ((bu)localObject).setContent(localat.field_content);
      localb.a((bu)localObject, localPString1, localPString2, localPInt, true);
      localat.tB(localPString1.value);
      localat.tC(localPString2.value);
      localat.ks(localPInt.value);
    }
    for (;;)
    {
      this.Iof.a(localat, localat.field_username);
      AppMethodBeat.o(124600);
      return;
      label277:
      localat.fqK();
    }
  }
  
  public final void b(bu parambu, at paramat, boolean paramBoolean, i.c paramc)
  {
    AppMethodBeat.i(124597);
    bq localbq = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azv();
    String str;
    if (paramc == null)
    {
      str = null;
      if ((paramc == null) || (!paramc.vKe.equals("delete")) || (paramc.vKg <= 0)) {
        break label948;
      }
    }
    label673:
    label948:
    for (int i = paramc.vKg;; i = 0)
    {
      if ((paramc != null) && (paramc.vKe.equals("insert")) && (paramc.vKf > 0)) {}
      for (int j = paramc.vKf;; j = 0)
      {
        Object localObject1;
        label243:
        Object localObject3;
        Object localObject2;
        PString localPString;
        PInt localPInt;
        if (!bt.isNullOrNil(paramat.field_parentRef))
        {
          parambu = localbq.aTz(paramat.field_parentRef);
          if ((parambu != null) && (parambu.lQ(2097152))) {
            if (j > 0)
            {
              if (((paramc.vKe.equals("insert")) && (paramc.scY > 0)) || ((paramc.vKe.equals("update")) && (parambu.field_unReadCount + paramc.scY >= 0)))
              {
                localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(str);
                if ((localObject1 != null) && ((((am)localObject1).Pf()) || (b(paramc)))) {
                  parambu.kv(parambu.field_unReadMuteCount + j);
                }
              }
              else
              {
                localbq.a(paramat, i, j);
              }
            }
            else
            {
              localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azv().aTM(paramat.field_parentRef);
              localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().apX((String)localObject1);
              if ((localObject3 == null) || (((ei)localObject3).field_msgId <= 0L)) {
                break label711;
              }
              parambu.aL((bu)localObject3);
              parambu.setContent(((ei)localObject3).field_talker + ":" + ((ei)localObject3).field_content);
              parambu.tA(Integer.toString(((bu)localObject3).getType()));
              if (localbq.Na() != null)
              {
                localObject2 = new PString();
                localPString = new PString();
                localPInt = new PInt();
                ((bu)localObject3).tN(paramat.field_parentRef);
                ((bu)localObject3).setContent(parambu.field_content);
                localbq.Na().a((bu)localObject3, (PString)localObject2, localPString, localPInt, true);
                localObject1 = localbq.cP(((bu)localObject3).getType(), ((ei)localObject3).field_content);
                if (((ei)localObject3).field_bizChatId == -1L) {
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
            localObject3 = ag.aGd().eK(((ei)localObject3).field_bizChatUserId);
            ((PString)localObject2).value = String.format(((PString)localObject2).value, new Object[] { ((k)localObject3).field_userName });
            parambu.tC("");
            localObject2 = bt.nullAsNil(((PString)localObject2).value);
            if (bt.isNullOrNil((String)localObject1))
            {
              localObject1 = "";
              parambu.tB(((String)localObject2).concat((String)localObject1));
              parambu.ks(localPInt.value);
              if (localbq.a(parambu, paramat.field_parentRef) > 0)
              {
                ad.d("MicroMsg.BizConversationStorage", "hakon update parent conversation's unread %s, %d", new Object[] { paramat.field_parentRef, Integer.valueOf(parambu.field_unReadCount + j) });
                localbq.b(3, (n)localbq, paramat.field_parentRef);
              }
              a(str, paramat, j, i, paramc, parambu);
              AppMethodBeat.o(124597);
              return;
              str = paramc.talker;
              break;
              parambu.kp(parambu.field_unReadCount + j);
              break label243;
              parambu.tC(localPString.value);
              continue;
            }
            localObject1 = " " + bt.nullAsNil((String)localObject1);
            continue;
            label711:
            parambu.fqK();
            continue;
            if ((parambu != null) && ("officialaccounts".equals(parambu.field_username)))
            {
              if ((j > 0) && (!y.bNf()) && (((paramc.vKe.equals("insert")) && (paramc.scY > 0)) || ((paramc.vKe.equals("update")) && (parambu.field_unReadCount + paramc.scY >= 0))))
              {
                parambu.kp(parambu.field_unReadCount + j);
                localbq.a(parambu, paramat.field_parentRef);
              }
            }
            else if ((parambu != null) && ("appbrandcustomerservicemsg".equals(parambu.field_username)) && (j > 0))
            {
              if (((paramc.vKe.equals("insert")) && (paramc.scY > 0)) || ((paramc.vKe.equals("update")) && (parambu.field_unReadCount + paramc.scY >= 0))) {
                parambu.kp(parambu.field_unReadCount + j);
              }
              localbq.a(paramat, i, j);
              localbq.a(parambu, paramat.field_parentRef);
            }
            continue;
          }
          catch (Throwable localThrowable)
          {
            continue;
          }
          parambu = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.s
 * JD-Core Version:    0.7.0.1
 */