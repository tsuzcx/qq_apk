package com.tencent.mm.storage;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.al.a.b;
import com.tencent.mm.al.a.d;
import com.tencent.mm.al.a.k;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.f;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class s
  implements f, com.tencent.mm.plugin.messenger.foundation.a.g
{
  private br IIv;
  
  public s(br parambr)
  {
    AppMethodBeat.i(124594);
    ag.aGD();
    this.IIv = parambr;
    this.IIv.a(this);
    this.IIv.a(this);
    AppMethodBeat.o(124594);
  }
  
  private void a(String paramString, au paramau1, int paramInt1, int paramInt2, i.c paramc, au paramau2)
  {
    AppMethodBeat.i(188966);
    bv localbv;
    a locala;
    com.tencent.mm.al.a.c localc;
    Object localObject1;
    Object localObject2;
    label372:
    Object localObject3;
    if ((paramau1 != null) && (paramc != null) && (paramc.oex != -1L) && (paramau1.lS(8388608)))
    {
      localbv = ((q)com.tencent.mm.kernel.g.ab(q.class)).azJ().cb(paramString, paramc.oex);
      locala = ag.aGs().sf(paramc.oex);
      localc = ag.aGr().bd(paramc.oex);
      if (localc.field_bizChatServId == null)
      {
        ae.w("MicroMsg.BizConversationStorage", "willen updateBizChatConversation bizChatInfo == null");
        AppMethodBeat.o(188966);
        return;
      }
      if ((localbv == null) || (localbv.field_msgId == 0L))
      {
        ae.i("MicroMsg.BizConversationStorage", "update null BizChatConversation with talker ".concat(String.valueOf(paramString)));
        locala.field_status = 0;
        locala.field_isSend = 0;
        locala.field_content = "";
        locala.field_msgType = "0";
        locala.field_unReadCount = 0;
        locala.field_digest = "";
        locala.field_digestUser = "";
        ag.aGs();
        b.a(locala, paramInt2, paramInt1);
        ag.aGs().b(locala);
        AppMethodBeat.o(188966);
        return;
      }
      boolean bool = localc.isGroup();
      locala.field_brandUserName = paramString;
      if (localbv.fvD())
      {
        locala.field_content = localbv.fwq();
        localObject1 = new PString();
        this.IIv.MV().a(localbv, (PString)localObject1, new PString(), new PInt(), false);
        localObject1 = ((PString)localObject1).value;
        localObject2 = ag.aGt().eP(localbv.field_bizChatUserId);
        if (!bool) {
          break label1008;
        }
        if ((localbv.field_isSend != 1) || (localObject2 == null)) {
          break label936;
        }
        locala.field_digest = (ak.getContext().getString(2131755809) + ":" + (String)localObject1);
        ((k)localObject2).field_userName = ak.getContext().getString(2131755809);
        localObject1 = null;
        localObject2 = this.IIv.cP(localbv.getType(), localbv.field_content);
        localObject3 = bu.nullAsNil(locala.field_digest);
        if ((!bu.isNullOrNil((String)localObject2)) && (!((String)localObject3).endsWith((String)localObject2))) {
          locala.field_digest = ((String)localObject3 + " " + (String)localObject2);
        }
        locala.field_digestUser = "";
        locala.field_chatType = localc.field_chatType;
        locala.field_lastMsgID = localbv.field_msgId;
        if (!localbv.cyI()) {
          break label1021;
        }
      }
    }
    label1038:
    label1178:
    for (;;)
    {
      long l = localbv.field_createTime;
      label494:
      locala.field_lastMsgTime = l;
      locala.field_status = localbv.field_status;
      locala.field_isSend = localbv.field_isSend;
      locala.field_msgType = Integer.toString(localbv.getType());
      locala.field_flag = b.a(locala, 1, localbv.field_createTime);
      int j = 0;
      int i;
      if ((!paramc.vWi.equals("insert")) || (paramc.slP <= 0))
      {
        i = j;
        if (paramc.vWi.equals("update"))
        {
          i = j;
          if (locala.field_unReadCount + paramc.slP < 0) {}
        }
      }
      else
      {
        locala.field_unReadCount += paramc.slP;
        locala.field_newUnReadCount += paramc.slP;
        i = j;
        if (paramc.slP > 0)
        {
          i = j;
          if (localc.hk(1))
          {
            i = paramau1.field_unReadCount - paramc.slP;
            if (i > 0) {
              break label1038;
            }
            paramau1.kr(0);
          }
        }
      }
      for (;;)
      {
        paramau1.kx(paramau1.field_unReadMuteCount + paramc.slP);
        i = 1;
        j = i;
        if (!paramc.vWi.equals("insert")) {
          break label1051;
        }
        j = i;
        if (paramc.gQn.size() <= 0) {
          break label1051;
        }
        j = i;
        if (!localc.isGroup()) {
          break label1051;
        }
        localObject2 = ag.aGt().eQ(localbv.field_talker);
        paramc = paramc.gQn.iterator();
        while (paramc.hasNext())
        {
          localObject3 = (bv)paramc.next();
          if ((localObject2 != null) && (((ei)localObject3).field_isSend != 1) && (((bv)localObject3).isText()))
          {
            if (((bv)localObject3).aVB((String)localObject2))
            {
              locala.field_atCount += 1;
              paramau1.kw(paramau1.field_atCount + 1);
              if (paramau2 != null) {
                paramau2.kw(paramau2.field_atCount + 1);
              }
              i = 1;
            }
            if (aTR(((ei)localObject3).eNd))
            {
              locala.field_atAll = 1;
              paramau1.kw(paramau1.field_atCount + 4096);
              if (paramau2 != null) {
                paramau2.kw(paramau2.field_atCount + 1);
              }
              i = 1;
            }
          }
        }
        locala.field_content = localbv.field_content;
        break;
        label936:
        if ((localObject2 != null) && (!bu.isNullOrNil(((k)localObject2).field_userName)))
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
        if (localbv.field_status != 1) {
          break label1178;
        }
        l = 9223372036854775807L;
        break label494;
        paramau1.kr(i);
      }
      j = i;
      label1051:
      ag.aGs();
      b.a(locala, paramInt2, paramInt1);
      paramc = (i.c)localObject1;
      if (bu.isNullOrNil((String)localObject1)) {
        paramc = localc.zP(localbv.field_bizChatUserId);
      }
      ae.i("MicroMsg.BizConversationStorage", "updateBizChatConversation brandUserName:%s, bizChatId:%s, userId:%s, displayName:%s", new Object[] { paramString, localc.field_bizChatServId, localbv.field_bizChatUserId, paramc });
      ag.aGs().b(locala);
      if (j != 0)
      {
        this.IIv.a(paramau1, paramString);
        if (paramau2 != null) {
          this.IIv.a(paramau2, paramau2.field_username);
        }
      }
      AppMethodBeat.o(188966);
      return;
    }
  }
  
  private static boolean aTR(String paramString)
  {
    AppMethodBeat.i(124599);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(124599);
      return false;
    }
    paramString = bx.M(paramString, "msgsource");
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
  
  public static void aTT(String paramString)
  {
    AppMethodBeat.i(124601);
    br localbr = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL();
    paramString = new au(paramString);
    paramString.tY("officialaccounts");
    b(paramString, localbr);
    AppMethodBeat.o(124601);
  }
  
  public static void b(au paramau, br parambr)
  {
    AppMethodBeat.i(124602);
    if ((paramau == null) || (parambr == null))
    {
      AppMethodBeat.o(124602);
      return;
    }
    au localau;
    if ((x.Ao(paramau.field_username)) && (!bu.isNullOrNil(paramau.field_parentRef)))
    {
      if ((y.bOd()) && (x.AN(paramau.field_parentRef)))
      {
        AppMethodBeat.o(124602);
        return;
      }
      localau = parambr.aVa(paramau.field_parentRef);
      ae.v("MicroMsg.BizConversationStorage", "postConvExt, username = %s, parentRef = %s", new Object[] { paramau.field_username, paramau.field_parentRef });
      if (paramau.field_parentRef.equals("officialaccounts")) {
        break label550;
      }
    }
    label550:
    for (int i = 1;; i = 0)
    {
      if (localau == null)
      {
        localau = new au(paramau.field_parentRef);
        if (i != 0) {
          localau.lQ(2097152);
        }
      }
      for (int j = 1;; j = 0)
      {
        if ((i != 0) && (localau.field_attrflag == 0))
        {
          localau.lQ(2097152);
          ae.v("MicroMsg.BizConversationStorage", "Enterprise cvs reset attr flag!");
        }
        ae.i("MicroMsg.BizConversationStorage", "enterprise cvs count is %d", new Object[] { Integer.valueOf(localau.field_unReadCount) });
        Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL().aVn(paramau.field_parentRef);
        bv localbv = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().arc((String)localObject);
        if ((localbv != null) && (localbv.field_msgId > 0L))
        {
          localau.aK(localbv);
          localau.setContent(localbv.field_talker + ":" + localbv.field_content);
          localau.tV(Integer.toString(localbv.getType()));
          localObject = parambr.MV();
          if (localObject != null)
          {
            PString localPString1 = new PString();
            PString localPString2 = new PString();
            PInt localPInt = new PInt();
            localbv.ui(paramau.field_parentRef);
            localbv.setContent(localau.field_content);
            ((br.b)localObject).a(localbv, localPString1, localPString2, localPInt, true);
            localau.tW(localPString1.value);
            localau.tX(localPString2.value);
            localau.ku(localPInt.value);
          }
        }
        for (;;)
        {
          int m = 0;
          int k = m;
          if (i != 0)
          {
            k = m;
            if (parambr.aVm(localau.field_username) <= 0) {
              k = 1;
            }
          }
          if (k == 0) {
            break;
          }
          parambr.aUY(localau.field_username);
          AppMethodBeat.o(124602);
          return;
          localau.fuK();
          ae.i("MicroMsg.BizConversationStorage", "lastOfMsg is null or MsgId <= 0, lastConvBiz is %s", new Object[] { localObject });
        }
        if (j != 0)
        {
          parambr.e(localau);
          AppMethodBeat.o(124602);
          return;
        }
        parambr.a(localau, localau.field_username);
        AppMethodBeat.o(124602);
        return;
      }
    }
  }
  
  private static boolean b(i.c paramc)
  {
    AppMethodBeat.i(188967);
    try
    {
      boolean bool = ag.aGr().bd(paramc.oex).hk(1);
      AppMethodBeat.o(188967);
      return bool;
    }
    catch (Throwable paramc)
    {
      AppMethodBeat.o(188967);
    }
    return false;
  }
  
  public final void a(bv parambv, i.c paramc, boolean[] paramArrayOfBoolean) {}
  
  public final void a(bv parambv, au paramau)
  {
    Object localObject = null;
    AppMethodBeat.i(124595);
    if ((paramau != null) && (parambv != null) && (parambv.field_bizChatId != -1L) && (paramau.lS(8388608)))
    {
      com.tencent.mm.al.a.c localc = ag.aGr().bd(parambv.field_bizChatId);
      String str2 = paramau.field_digest;
      if (!bu.isNullOrNil(parambv.field_bizChatUserId))
      {
        k localk = ag.aGt().eP(parambv.field_bizChatUserId);
        String str1;
        boolean bool;
        if (localk != null)
        {
          str1 = localk.field_userName;
          bool = parambv.field_bizChatUserId.equals(ag.aGt().eQ(parambv.field_talker));
          if ((localk == null) || (!bool)) {
            break label218;
          }
          paramau.tW(ak.getContext().getString(2131755809) + ":" + str2);
        }
        for (;;)
        {
          if (!localc.isGroup())
          {
            if ((!bool) && (str1 != null) && (str1.length() > 0) && (!str1.equals(localc.field_chatName)))
            {
              localc.field_chatName = str1;
              ag.aGr().b(localc);
              AppMethodBeat.o(124595);
              return;
              str1 = null;
              break;
              label218:
              if ((localk == null) || (bu.isNullOrNil(localk.field_userName))) {
                continue;
              }
              paramau.tW(localk.field_userName + ":" + str2);
              continue;
            }
            paramau = ag.aGt().eP(localc.field_bizChatServId);
            parambv = localObject;
            if (paramau != null) {
              parambv = paramau.field_userName;
            }
            if ((parambv != null) && (parambv.length() > 0) && (!parambv.equals(localc.field_chatName)))
            {
              localc.field_chatName = parambv;
              ag.aGr().b(localc);
            }
          }
        }
        AppMethodBeat.o(124595);
        return;
      }
      ae.w("MicroMsg.BizConversationStorage", "BizChatUserId is null:%s %s", new Object[] { localc.field_bizChatServId, localc.field_chatName });
    }
    AppMethodBeat.o(124595);
  }
  
  public final void a(bv parambv, au paramau, boolean paramBoolean, i.c paramc)
  {
    AppMethodBeat.i(124596);
    if (paramc == null)
    {
      ae.e("MicroMsg.BizConversationStorage", "compose notifyInfo is null");
      AppMethodBeat.o(124596);
      return;
    }
    String str = paramc.talker;
    if (paramBoolean)
    {
      if ((parambv != null) && (parambv.field_isSend != 1) && ((bn.y(parambv) & 0x1) != 0))
      {
        ae.i("MicroMsg.BizConversationStorage", "create a temp session conversation.");
        paramau.lQ(4194304);
      }
      if ((parambv != null) && (com.tencent.mm.al.g.vz(str)))
      {
        ae.i("MicroMsg.BizConversationStorage", "create a bitChat conversation.");
        paramau.lQ(8388608);
      }
    }
    for (;;)
    {
      if ((paramc != null) && (!paramc.gQn.isEmpty()) && (paramc.gQn.get(0) != null))
      {
        paramau.kt(((bv)paramc.gQn.get(0)).field_isSend);
        if (paramc.vWi.equals("insert")) {
          paramau.JeR = ((bv)paramc.gQn.get(paramc.gQn.size() - 1));
        }
      }
      AppMethodBeat.o(124596);
      return;
      an localan = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(str);
      if ((localan != null) && (localan.fug()) && (!com.tencent.mm.contact.c.lO(localan.field_type)) && (parambv != null) && (parambv.field_isSend != 1) && (!paramau.lS(4194304)) && ((paramau.field_conversationTime < ag.aGD()) || ((bn.y(parambv) & 0x1) != 0)))
      {
        paramau.lQ(4194304);
        ae.i("MicroMsg.BizConversationStorage", "onNotifyChange is old temp session, %s", new Object[] { str });
      }
      if ((parambv != null) && (com.tencent.mm.al.g.vz(str)))
      {
        ae.i("MicroMsg.BizConversationStorage", "onNotifyChange a bitChat conversation, %s", new Object[] { str });
        paramau.lQ(8388608);
      }
    }
  }
  
  public final void aTS(String paramString)
  {
    AppMethodBeat.i(124600);
    if ((paramString == null) || (!x.Ao(paramString)) || (!com.tencent.mm.al.g.Es(paramString)))
    {
      AppMethodBeat.o(124600);
      return;
    }
    au localau = this.IIv.aVa(paramString);
    if (localau == null)
    {
      AppMethodBeat.o(124600);
      return;
    }
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL().aVn(paramString);
    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().arc((String)localObject);
    if ((localObject != null) && (((ei)localObject).field_msgId > 0L))
    {
      localau.aK((bv)localObject);
      localau.setContent(((ei)localObject).field_talker + ":" + ((ei)localObject).field_content);
      localau.tV(Integer.toString(((bv)localObject).getType()));
      br.b localb = this.IIv.MV();
      if (localb == null) {
        break label277;
      }
      PString localPString1 = new PString();
      PString localPString2 = new PString();
      PInt localPInt = new PInt();
      ((bv)localObject).ui(paramString);
      ((bv)localObject).setContent(localau.field_content);
      localb.a((bv)localObject, localPString1, localPString2, localPInt, true);
      localau.tW(localPString1.value);
      localau.tX(localPString2.value);
      localau.ku(localPInt.value);
    }
    for (;;)
    {
      this.IIv.a(localau, localau.field_username);
      AppMethodBeat.o(124600);
      return;
      label277:
      localau.fuK();
    }
  }
  
  public final void b(bv parambv, au paramau, boolean paramBoolean, i.c paramc)
  {
    AppMethodBeat.i(124597);
    br localbr = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL();
    String str;
    if (paramc == null)
    {
      str = null;
      if ((paramc == null) || (!paramc.vWi.equals("delete")) || (paramc.vWk <= 0)) {
        break label948;
      }
    }
    label673:
    label948:
    for (int i = paramc.vWk;; i = 0)
    {
      if ((paramc != null) && (paramc.vWi.equals("insert")) && (paramc.vWj > 0)) {}
      for (int j = paramc.vWj;; j = 0)
      {
        Object localObject1;
        label243:
        Object localObject3;
        Object localObject2;
        PString localPString;
        PInt localPInt;
        if (!bu.isNullOrNil(paramau.field_parentRef))
        {
          parambv = localbr.aVa(paramau.field_parentRef);
          if ((parambv != null) && (parambv.lS(2097152))) {
            if (j > 0)
            {
              if (((paramc.vWi.equals("insert")) && (paramc.slP > 0)) || ((paramc.vWi.equals("update")) && (parambv.field_unReadCount + paramc.slP >= 0)))
              {
                localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(str);
                if ((localObject1 != null) && ((((an)localObject1).Pd()) || (b(paramc)))) {
                  parambv.kx(parambv.field_unReadMuteCount + j);
                }
              }
              else
              {
                localbr.a(paramau, i, j);
              }
            }
            else
            {
              localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL().aVn(paramau.field_parentRef);
              localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().arc((String)localObject1);
              if ((localObject3 == null) || (((ei)localObject3).field_msgId <= 0L)) {
                break label711;
              }
              parambv.aK((bv)localObject3);
              parambv.setContent(((ei)localObject3).field_talker + ":" + ((ei)localObject3).field_content);
              parambv.tV(Integer.toString(((bv)localObject3).getType()));
              if (localbr.MV() != null)
              {
                localObject2 = new PString();
                localPString = new PString();
                localPInt = new PInt();
                ((bv)localObject3).ui(paramau.field_parentRef);
                ((bv)localObject3).setContent(parambv.field_content);
                localbr.MV().a((bv)localObject3, (PString)localObject2, localPString, localPInt, true);
                localObject1 = localbr.cP(((bv)localObject3).getType(), ((ei)localObject3).field_content);
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
            localObject3 = ag.aGt().eP(((ei)localObject3).field_bizChatUserId);
            ((PString)localObject2).value = String.format(((PString)localObject2).value, new Object[] { ((k)localObject3).field_userName });
            parambv.tX("");
            localObject2 = bu.nullAsNil(((PString)localObject2).value);
            if (bu.isNullOrNil((String)localObject1))
            {
              localObject1 = "";
              parambv.tW(((String)localObject2).concat((String)localObject1));
              parambv.ku(localPInt.value);
              if (localbr.a(parambv, paramau.field_parentRef) > 0)
              {
                ae.d("MicroMsg.BizConversationStorage", "hakon update parent conversation's unread %s, %d", new Object[] { paramau.field_parentRef, Integer.valueOf(parambv.field_unReadCount + j) });
                localbr.b(3, (n)localbr, paramau.field_parentRef);
              }
              a(str, paramau, j, i, paramc, parambv);
              AppMethodBeat.o(124597);
              return;
              str = paramc.talker;
              break;
              parambv.kr(parambv.field_unReadCount + j);
              break label243;
              parambv.tX(localPString.value);
              continue;
            }
            localObject1 = " " + bu.nullAsNil((String)localObject1);
            continue;
            label711:
            parambv.fuK();
            continue;
            if ((parambv != null) && ("officialaccounts".equals(parambv.field_username)))
            {
              if ((j > 0) && (!y.bOd()) && (((paramc.vWi.equals("insert")) && (paramc.slP > 0)) || ((paramc.vWi.equals("update")) && (parambv.field_unReadCount + paramc.slP >= 0))))
              {
                parambv.kr(parambv.field_unReadCount + j);
                localbr.a(parambv, paramau.field_parentRef);
              }
            }
            else if ((parambv != null) && ("appbrandcustomerservicemsg".equals(parambv.field_username)) && (j > 0))
            {
              if (((paramc.vWi.equals("insert")) && (paramc.slP > 0)) || ((paramc.vWi.equals("update")) && (parambv.field_unReadCount + paramc.slP >= 0))) {
                parambv.kr(parambv.field_unReadCount + j);
              }
              localbr.a(paramau, i, j);
              localbr.a(parambv, paramau.field_parentRef);
            }
            continue;
          }
          catch (Throwable localThrowable)
          {
            continue;
          }
          parambv = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.s
 * JD-Core Version:    0.7.0.1
 */