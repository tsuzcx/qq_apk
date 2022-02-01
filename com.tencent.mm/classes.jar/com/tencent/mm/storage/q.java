package com.tencent.mm.storage;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.a.a;
import com.tencent.mm.am.a.c;
import com.tencent.mm.am.a.d;
import com.tencent.mm.am.a.l;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.plugin.messenger.foundation.a.e;
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

public final class q
  implements e, com.tencent.mm.plugin.messenger.foundation.a.f
{
  private bh Fei;
  
  public q(bh parambh)
  {
    AppMethodBeat.i(124594);
    com.tencent.mm.am.af.aws();
    this.Fei = parambh;
    this.Fei.a(this);
    this.Fei.a(this);
    AppMethodBeat.o(124594);
  }
  
  private void a(String paramString, am paramam1, int paramInt1, int paramInt2, h.c paramc, am paramam2)
  {
    AppMethodBeat.i(191101);
    bl localbl;
    a locala;
    c localc;
    Object localObject1;
    Object localObject2;
    label372:
    Object localObject3;
    if ((paramam1 != null) && (paramc != null) && (paramc.mUQ != -1L) && (paramam1.lw(8388608)))
    {
      localbl = ((com.tencent.mm.am.p)g.ab(com.tencent.mm.am.p.class)).apP().bU(paramString, paramc.mUQ);
      locala = com.tencent.mm.am.af.awh().mf(paramc.mUQ);
      localc = com.tencent.mm.am.af.awg().bg(paramc.mUQ);
      if (localc.field_bizChatServId == null)
      {
        ad.w("MicroMsg.BizConversationStorage", "willen updateBizChatConversation bizChatInfo == null");
        AppMethodBeat.o(191101);
        return;
      }
      if ((localbl == null) || (localbl.field_msgId == 0L))
      {
        ad.i("MicroMsg.BizConversationStorage", "update null BizChatConversation with talker ".concat(String.valueOf(paramString)));
        locala.field_status = 0;
        locala.field_isSend = 0;
        locala.field_content = "";
        locala.field_msgType = "0";
        locala.field_unReadCount = 0;
        locala.field_digest = "";
        locala.field_digestUser = "";
        com.tencent.mm.am.af.awh();
        com.tencent.mm.am.a.b.a(locala, paramInt2, paramInt1);
        com.tencent.mm.am.af.awh().b(locala);
        AppMethodBeat.o(191101);
        return;
      }
      boolean bool = localc.isGroup();
      locala.field_brandUserName = paramString;
      if (localbl.eLW())
      {
        locala.field_content = localbl.eMD();
        localObject1 = new PString();
        this.Fei.Lu().a(localbl, (PString)localObject1, new PString(), new PInt(), false);
        localObject1 = ((PString)localObject1).value;
        localObject2 = com.tencent.mm.am.af.awi().ea(localbl.field_bizChatUserId);
        if (!bool) {
          break label1008;
        }
        if ((localbl.field_isSend != 1) || (localObject2 == null)) {
          break label936;
        }
        locala.field_digest = (aj.getContext().getString(2131755809) + ":" + (String)localObject1);
        ((com.tencent.mm.am.a.k)localObject2).field_userName = aj.getContext().getString(2131755809);
        localObject1 = null;
        localObject2 = this.Fei.cF(localbl.getType(), localbl.field_content);
        localObject3 = bt.nullAsNil(locala.field_digest);
        if ((!bt.isNullOrNil((String)localObject2)) && (!((String)localObject3).endsWith((String)localObject2))) {
          locala.field_digest = ((String)localObject3 + " " + (String)localObject2);
        }
        locala.field_digestUser = "";
        locala.field_chatType = localc.field_chatType;
        locala.field_lastMsgID = localbl.field_msgId;
        if (!localbl.cjO()) {
          break label1021;
        }
      }
    }
    label1038:
    label1178:
    for (;;)
    {
      long l = localbl.field_createTime;
      label494:
      locala.field_lastMsgTime = l;
      locala.field_status = localbl.field_status;
      locala.field_isSend = localbl.field_isSend;
      locala.field_msgType = Integer.toString(localbl.getType());
      locala.field_flag = com.tencent.mm.am.a.b.a(locala, 1, localbl.field_createTime);
      int j = 0;
      int i;
      if ((!paramc.tyD.equals("insert")) || (paramc.qzn <= 0))
      {
        i = j;
        if (paramc.tyD.equals("update"))
        {
          i = j;
          if (locala.field_unReadCount + paramc.qzn < 0) {}
        }
      }
      else
      {
        locala.field_unReadCount += paramc.qzn;
        locala.field_newUnReadCount += paramc.qzn;
        i = j;
        if (paramc.qzn > 0)
        {
          i = j;
          if (localc.ht(1))
          {
            i = paramam1.field_unReadCount - paramc.qzn;
            if (i > 0) {
              break label1038;
            }
            paramam1.jT(0);
          }
        }
      }
      for (;;)
      {
        paramam1.jZ(paramam1.field_unReadMuteCount + paramc.qzn);
        i = 1;
        j = i;
        if (!paramc.tyD.equals("insert")) {
          break label1051;
        }
        j = i;
        if (paramc.tyE.size() <= 0) {
          break label1051;
        }
        j = i;
        if (!localc.isGroup()) {
          break label1051;
        }
        localObject2 = com.tencent.mm.am.af.awi().eb(localbl.field_talker);
        paramc = paramc.tyE.iterator();
        while (paramc.hasNext())
        {
          localObject3 = (bl)paramc.next();
          if ((localObject2 != null) && (((du)localObject3).field_isSend != 1) && (((bl)localObject3).isText()))
          {
            if (((bl)localObject3).aIN((String)localObject2))
            {
              locala.field_atCount += 1;
              paramam1.jY(paramam1.field_atCount + 1);
              if (paramam2 != null) {
                paramam2.jY(paramam2.field_atCount + 1);
              }
              i = 1;
            }
            if (aHo(((du)localObject3).esh))
            {
              locala.field_atAll = 1;
              paramam1.jY(paramam1.field_atCount + 4096);
              if (paramam2 != null) {
                paramam2.jY(paramam2.field_atCount + 1);
              }
              i = 1;
            }
          }
        }
        locala.field_content = localbl.field_content;
        break;
        label936:
        if ((localObject2 != null) && (!bt.isNullOrNil(((com.tencent.mm.am.a.k)localObject2).field_userName)))
        {
          locala.field_digest = (((com.tencent.mm.am.a.k)localObject2).field_userName + ":" + (String)localObject1);
          localObject1 = ((com.tencent.mm.am.a.k)localObject2).field_userName;
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
        if (localbl.field_status != 1) {
          break label1178;
        }
        l = 9223372036854775807L;
        break label494;
        paramam1.jT(i);
      }
      j = i;
      label1051:
      com.tencent.mm.am.af.awh();
      com.tencent.mm.am.a.b.a(locala, paramInt2, paramInt1);
      paramc = (h.c)localObject1;
      if (bt.isNullOrNil((String)localObject1)) {
        paramc = localc.sh(localbl.field_bizChatUserId);
      }
      ad.i("MicroMsg.BizConversationStorage", "updateBizChatConversation brandUserName:%s, bizChatId:%s, userId:%s, displayName:%s", new Object[] { paramString, localc.field_bizChatServId, localbl.field_bizChatUserId, paramc });
      com.tencent.mm.am.af.awh().b(locala);
      if (j != 0)
      {
        this.Fei.a(paramam1, paramString);
        if (paramam2 != null) {
          this.Fei.a(paramam2, paramam2.field_username);
        }
      }
      AppMethodBeat.o(191101);
      return;
    }
  }
  
  private static boolean aHo(String paramString)
  {
    AppMethodBeat.i(124599);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(124599);
      return false;
    }
    paramString = bw.K(paramString, "msgsource");
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
  
  public static void aHq(String paramString)
  {
    AppMethodBeat.i(124601);
    bh localbh = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR();
    paramString = new am(paramString);
    paramString.nN("officialaccounts");
    b(paramString, localbh);
    AppMethodBeat.o(124601);
  }
  
  public static void b(am paramam, bh parambh)
  {
    AppMethodBeat.i(124602);
    if ((paramam == null) || (parambh == null))
    {
      AppMethodBeat.o(124602);
      return;
    }
    am localam;
    if ((w.sE(paramam.field_username)) && (!bt.isNullOrNil(paramam.field_parentRef)))
    {
      if ((u.bBQ()) && (w.td(paramam.field_parentRef)))
      {
        AppMethodBeat.o(124602);
        return;
      }
      localam = parambh.aIn(paramam.field_parentRef);
      ad.v("MicroMsg.BizConversationStorage", "postConvExt, username = %s, parentRef = %s", new Object[] { paramam.field_username, paramam.field_parentRef });
      if (paramam.field_parentRef.equals("officialaccounts")) {
        break label550;
      }
    }
    label550:
    for (int i = 1;; i = 0)
    {
      if (localam == null)
      {
        localam = new am(paramam.field_parentRef);
        if (i != 0) {
          localam.lu(2097152);
        }
      }
      for (int j = 1;; j = 0)
      {
        if ((i != 0) && (localam.field_attrflag == 0))
        {
          localam.lu(2097152);
          ad.v("MicroMsg.BizConversationStorage", "Enterprise cvs reset attr flag!");
        }
        ad.i("MicroMsg.BizConversationStorage", "enterprise cvs count is %d", new Object[] { Integer.valueOf(localam.field_unReadCount) });
        Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().aIz(paramam.field_parentRef);
        bl localbl = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().agq((String)localObject);
        if ((localbl != null) && (localbl.field_msgId > 0L))
        {
          localam.aG(localbl);
          localam.setContent(localbl.field_talker + ":" + localbl.field_content);
          localam.nK(Integer.toString(localbl.getType()));
          localObject = parambh.Lu();
          if (localObject != null)
          {
            PString localPString1 = new PString();
            PString localPString2 = new PString();
            PInt localPInt = new PInt();
            localbl.nY(paramam.field_parentRef);
            localbl.setContent(localam.field_content);
            ((bh.b)localObject).a(localbl, localPString1, localPString2, localPInt, true);
            localam.nL(localPString1.value);
            localam.nM(localPString2.value);
            localam.jW(localPInt.value);
          }
        }
        for (;;)
        {
          int m = 0;
          int k = m;
          if (i != 0)
          {
            k = m;
            if (parambh.aIy(localam.field_username) <= 0) {
              k = 1;
            }
          }
          if (k == 0) {
            break;
          }
          parambh.aIl(localam.field_username);
          AppMethodBeat.o(124602);
          return;
          localam.eLf();
          ad.i("MicroMsg.BizConversationStorage", "lastOfMsg is null or MsgId <= 0, lastConvBiz is %s", new Object[] { localObject });
        }
        if (j != 0)
        {
          parambh.e(localam);
          AppMethodBeat.o(124602);
          return;
        }
        parambh.a(localam, localam.field_username);
        AppMethodBeat.o(124602);
        return;
      }
    }
  }
  
  private static boolean b(h.c paramc)
  {
    AppMethodBeat.i(191102);
    try
    {
      boolean bool = com.tencent.mm.am.af.awg().bg(paramc.mUQ).ht(1);
      AppMethodBeat.o(191102);
      return bool;
    }
    catch (Throwable paramc)
    {
      AppMethodBeat.o(191102);
    }
    return false;
  }
  
  public final void a(bl parambl, am paramam)
  {
    Object localObject = null;
    AppMethodBeat.i(124595);
    if ((paramam != null) && (parambl != null) && (parambl.field_bizChatId != -1L) && (paramam.lw(8388608)))
    {
      c localc = com.tencent.mm.am.af.awg().bg(parambl.field_bizChatId);
      String str2 = paramam.field_digest;
      if (!bt.isNullOrNil(parambl.field_bizChatUserId))
      {
        com.tencent.mm.am.a.k localk = com.tencent.mm.am.af.awi().ea(parambl.field_bizChatUserId);
        String str1;
        boolean bool;
        if (localk != null)
        {
          str1 = localk.field_userName;
          bool = parambl.field_bizChatUserId.equals(com.tencent.mm.am.af.awi().eb(parambl.field_talker));
          if ((localk == null) || (!bool)) {
            break label218;
          }
          paramam.nL(aj.getContext().getString(2131755809) + ":" + str2);
        }
        for (;;)
        {
          if (!localc.isGroup())
          {
            if ((!bool) && (str1 != null) && (str1.length() > 0) && (!str1.equals(localc.field_chatName)))
            {
              localc.field_chatName = str1;
              com.tencent.mm.am.af.awg().b(localc);
              AppMethodBeat.o(124595);
              return;
              str1 = null;
              break;
              label218:
              if ((localk == null) || (bt.isNullOrNil(localk.field_userName))) {
                continue;
              }
              paramam.nL(localk.field_userName + ":" + str2);
              continue;
            }
            paramam = com.tencent.mm.am.af.awi().ea(localc.field_bizChatServId);
            parambl = localObject;
            if (paramam != null) {
              parambl = paramam.field_userName;
            }
            if ((parambl != null) && (parambl.length() > 0) && (!parambl.equals(localc.field_chatName)))
            {
              localc.field_chatName = parambl;
              com.tencent.mm.am.af.awg().b(localc);
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
  
  public final void a(bl parambl, am paramam, boolean paramBoolean, h.c paramc)
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
      if ((parambl != null) && (parambl.field_isSend != 1) && ((bk.w(parambl) & 0x1) != 0))
      {
        ad.i("MicroMsg.BizConversationStorage", "create a temp session conversation.");
        paramam.lu(4194304);
      }
      if ((parambl != null) && (com.tencent.mm.am.f.pc(str)))
      {
        ad.i("MicroMsg.BizConversationStorage", "create a bitChat conversation.");
        paramam.lu(8388608);
      }
    }
    for (;;)
    {
      if ((paramc != null) && (!paramc.tyE.isEmpty()) && (paramc.tyE.get(0) != null))
      {
        paramam.jV(((bl)paramc.tyE.get(0)).field_isSend);
        if (paramc.tyD.equals("insert")) {
          paramam.FxX = ((bl)paramc.tyE.get(paramc.tyE.size() - 1));
        }
      }
      AppMethodBeat.o(124596);
      return;
      af localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(str);
      if ((localaf != null) && (localaf.eKB()) && (!com.tencent.mm.n.b.ls(localaf.field_type)) && (parambl != null) && (parambl.field_isSend != 1) && (!paramam.lw(4194304)) && ((paramam.field_conversationTime < com.tencent.mm.am.af.aws()) || ((bk.w(parambl) & 0x1) != 0)))
      {
        paramam.lu(4194304);
        ad.i("MicroMsg.BizConversationStorage", "onNotifyChange is old temp session, %s", new Object[] { str });
      }
      if ((parambl != null) && (com.tencent.mm.am.f.pc(str)))
      {
        ad.i("MicroMsg.BizConversationStorage", "onNotifyChange a bitChat conversation, %s", new Object[] { str });
        paramam.lu(8388608);
      }
    }
  }
  
  public final void aHp(String paramString)
  {
    AppMethodBeat.i(124600);
    if ((paramString == null) || (!w.sE(paramString)) || (!com.tencent.mm.am.f.wL(paramString)))
    {
      AppMethodBeat.o(124600);
      return;
    }
    am localam = this.Fei.aIn(paramString);
    if (localam == null)
    {
      AppMethodBeat.o(124600);
      return;
    }
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().aIz(paramString);
    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().agq((String)localObject);
    if ((localObject != null) && (((du)localObject).field_msgId > 0L))
    {
      localam.aG((bl)localObject);
      localam.setContent(((du)localObject).field_talker + ":" + ((du)localObject).field_content);
      localam.nK(Integer.toString(((bl)localObject).getType()));
      bh.b localb = this.Fei.Lu();
      if (localb == null) {
        break label277;
      }
      PString localPString1 = new PString();
      PString localPString2 = new PString();
      PInt localPInt = new PInt();
      ((bl)localObject).nY(paramString);
      ((bl)localObject).setContent(localam.field_content);
      localb.a((bl)localObject, localPString1, localPString2, localPInt, true);
      localam.nL(localPString1.value);
      localam.nM(localPString2.value);
      localam.jW(localPInt.value);
    }
    for (;;)
    {
      this.Fei.a(localam, localam.field_username);
      AppMethodBeat.o(124600);
      return;
      label277:
      localam.eLf();
    }
  }
  
  public final void b(bl parambl, am paramam, boolean paramBoolean, h.c paramc)
  {
    AppMethodBeat.i(124597);
    bh localbh = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR();
    String str;
    if (paramc == null)
    {
      str = null;
      if ((paramc == null) || (!paramc.tyD.equals("delete")) || (paramc.tyG <= 0)) {
        break label948;
      }
    }
    label673:
    label948:
    for (int i = paramc.tyG;; i = 0)
    {
      if ((paramc != null) && (paramc.tyD.equals("insert")) && (paramc.tyF > 0)) {}
      for (int j = paramc.tyF;; j = 0)
      {
        Object localObject1;
        label243:
        Object localObject3;
        Object localObject2;
        PString localPString;
        PInt localPInt;
        if (!bt.isNullOrNil(paramam.field_parentRef))
        {
          parambl = localbh.aIn(paramam.field_parentRef);
          if ((parambl != null) && (parambl.lw(2097152))) {
            if (j > 0)
            {
              if (((paramc.tyD.equals("insert")) && (paramc.qzn > 0)) || ((paramc.tyD.equals("update")) && (parambl.field_unReadCount + paramc.qzn >= 0)))
              {
                localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(str);
                if ((localObject1 != null) && ((((af)localObject1).Ny()) || (b(paramc)))) {
                  parambl.jZ(parambl.field_unReadMuteCount + j);
                }
              }
              else
              {
                localbh.a(paramam, i, j);
              }
            }
            else
            {
              localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().aIz(paramam.field_parentRef);
              localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().agq((String)localObject1);
              if ((localObject3 == null) || (((du)localObject3).field_msgId <= 0L)) {
                break label711;
              }
              parambl.aG((bl)localObject3);
              parambl.setContent(((du)localObject3).field_talker + ":" + ((du)localObject3).field_content);
              parambl.nK(Integer.toString(((bl)localObject3).getType()));
              if (localbh.Lu() != null)
              {
                localObject2 = new PString();
                localPString = new PString();
                localPInt = new PInt();
                ((bl)localObject3).nY(paramam.field_parentRef);
                ((bl)localObject3).setContent(parambl.field_content);
                localbh.Lu().a((bl)localObject3, (PString)localObject2, localPString, localPInt, true);
                localObject1 = localbh.cF(((bl)localObject3).getType(), ((du)localObject3).field_content);
                if (((du)localObject3).field_bizChatId == -1L) {
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
            localObject3 = com.tencent.mm.am.af.awi().ea(((du)localObject3).field_bizChatUserId);
            ((PString)localObject2).value = String.format(((PString)localObject2).value, new Object[] { ((com.tencent.mm.am.a.k)localObject3).field_userName });
            parambl.nM("");
            localObject2 = bt.nullAsNil(((PString)localObject2).value);
            if (bt.isNullOrNil((String)localObject1))
            {
              localObject1 = "";
              parambl.nL(((String)localObject2).concat((String)localObject1));
              parambl.jW(localPInt.value);
              if (localbh.a(parambl, paramam.field_parentRef) > 0)
              {
                ad.d("MicroMsg.BizConversationStorage", "hakon update parent conversation's unread %s, %d", new Object[] { paramam.field_parentRef, Integer.valueOf(parambl.field_unReadCount + j) });
                localbh.b(3, (n)localbh, paramam.field_parentRef);
              }
              a(str, paramam, j, i, paramc, parambl);
              AppMethodBeat.o(124597);
              return;
              str = paramc.talker;
              break;
              parambl.jT(parambl.field_unReadCount + j);
              break label243;
              parambl.nM(localPString.value);
              continue;
            }
            localObject1 = " " + bt.nullAsNil((String)localObject1);
            continue;
            label711:
            parambl.eLf();
            continue;
            if ((parambl != null) && ("officialaccounts".equals(parambl.field_username)))
            {
              if ((j > 0) && (!u.bBQ()) && (((paramc.tyD.equals("insert")) && (paramc.qzn > 0)) || ((paramc.tyD.equals("update")) && (parambl.field_unReadCount + paramc.qzn >= 0))))
              {
                parambl.jT(parambl.field_unReadCount + j);
                localbh.a(parambl, paramam.field_parentRef);
              }
            }
            else if ((parambl != null) && ("appbrandcustomerservicemsg".equals(parambl.field_username)) && (j > 0))
            {
              if (((paramc.tyD.equals("insert")) && (paramc.qzn > 0)) || ((paramc.tyD.equals("update")) && (parambl.field_unReadCount + paramc.qzn >= 0))) {
                parambl.jT(parambl.field_unReadCount + j);
              }
              localbh.a(paramam, i, j);
              localbh.a(parambl, paramam.field_parentRef);
            }
            continue;
          }
          catch (Throwable localThrowable)
          {
            continue;
          }
          parambl = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.q
 * JD-Core Version:    0.7.0.1
 */