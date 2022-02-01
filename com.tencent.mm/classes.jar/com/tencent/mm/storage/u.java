package com.tencent.mm.storage;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.al.a.b;
import com.tencent.mm.al.a.d;
import com.tencent.mm.al.a.k;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.f;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.MStorageEx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class u
  implements f, com.tencent.mm.plugin.messenger.foundation.a.g
{
  private bw NPD;
  
  public u(bw parambw)
  {
    AppMethodBeat.i(124594);
    ag.baw();
    this.NPD = parambw;
    this.NPD.a(this);
    this.NPD.a(this);
    AppMethodBeat.o(124594);
  }
  
  private void a(String paramString, az paramaz1, int paramInt1, int paramInt2, i.c paramc, az paramaz2)
  {
    AppMethodBeat.i(212323);
    ca localca;
    a locala;
    com.tencent.mm.al.a.c localc;
    Object localObject1;
    Object localObject2;
    label372:
    Object localObject3;
    if ((paramaz1 != null) && (paramc != null) && (paramc.ppv != -1L) && (paramaz1.oV(8388608)))
    {
      localca = ((q)com.tencent.mm.kernel.g.af(q.class)).aSR().bX(paramString, paramc.ppv);
      locala = ag.bak().Al(paramc.ppv);
      localc = ag.baj().bs(paramc.ppv);
      if (localc.field_bizChatServId == null)
      {
        Log.w("MicroMsg.BizConversationStorage", "willen updateBizChatConversation bizChatInfo == null");
        AppMethodBeat.o(212323);
        return;
      }
      if ((localca == null) || (localca.field_msgId == 0L))
      {
        Log.i("MicroMsg.BizConversationStorage", "update null BizChatConversation with talker ".concat(String.valueOf(paramString)));
        locala.field_status = 0;
        locala.field_isSend = 0;
        locala.field_content = "";
        locala.field_msgType = "0";
        locala.field_unReadCount = 0;
        locala.field_digest = "";
        locala.field_digestUser = "";
        ag.bak();
        b.a(locala, paramInt2, paramInt1);
        ag.bak().b(locala);
        AppMethodBeat.o(212323);
        return;
      }
      boolean bool = localc.isGroup();
      locala.field_brandUserName = paramString;
      if (localca.gDk())
      {
        locala.field_content = localca.gDW();
        localObject1 = new PString();
        this.NPD.Xh().a(localca, (PString)localObject1, new PString(), new PInt(), false);
        localObject1 = ((PString)localObject1).value;
        localObject2 = ag.bal().fB(localca.field_bizChatUserId);
        if (!bool) {
          break label1008;
        }
        if ((localca.field_isSend != 1) || (localObject2 == null)) {
          break label936;
        }
        locala.field_digest = (MMApplicationContext.getContext().getString(2131755891) + ":" + (String)localObject1);
        ((k)localObject2).field_userName = MMApplicationContext.getContext().getString(2131755891);
        localObject1 = null;
        localObject2 = this.NPD.dk(localca.getType(), localca.field_content);
        localObject3 = Util.nullAsNil(locala.field_digest);
        if ((!Util.isNullOrNil((String)localObject2)) && (!((String)localObject3).endsWith((String)localObject2))) {
          locala.field_digest = ((String)localObject3 + " " + (String)localObject2);
        }
        locala.field_digestUser = "";
        locala.field_chatType = localc.field_chatType;
        locala.field_lastMsgID = localca.field_msgId;
        if (!localca.cWL()) {
          break label1021;
        }
      }
    }
    label1038:
    label1178:
    for (;;)
    {
      long l = localca.field_createTime;
      label494:
      locala.field_lastMsgTime = l;
      locala.field_status = localca.field_status;
      locala.field_isSend = localca.field_isSend;
      locala.field_msgType = Integer.toString(localca.getType());
      locala.field_flag = b.a(locala, 1, localca.field_createTime);
      int j = 0;
      int i;
      if ((!paramc.zqn.equals("insert")) || (paramc.tYD <= 0))
      {
        i = j;
        if (paramc.zqn.equals("update"))
        {
          i = j;
          if (locala.field_unReadCount + paramc.tYD < 0) {}
        }
      }
      else
      {
        locala.field_unReadCount += paramc.tYD;
        locala.field_newUnReadCount += paramc.tYD;
        i = j;
        if (paramc.tYD > 0)
        {
          i = j;
          if (localc.iE(1))
          {
            i = paramaz1.field_unReadCount - paramc.tYD;
            if (i > 0) {
              break label1038;
            }
            paramaz1.nt(0);
          }
        }
      }
      for (;;)
      {
        paramaz1.nz(paramaz1.field_unReadMuteCount + paramc.tYD);
        i = 1;
        j = i;
        if (!paramc.zqn.equals("insert")) {
          break label1051;
        }
        j = i;
        if (paramc.hIs.size() <= 0) {
          break label1051;
        }
        j = i;
        if (!localc.isGroup()) {
          break label1051;
        }
        localObject2 = ag.bal().fC(localca.field_talker);
        paramc = paramc.hIs.iterator();
        while (paramc.hasNext())
        {
          localObject3 = (ca)paramc.next();
          if ((localObject2 != null) && (((eo)localObject3).field_isSend != 1) && (((ca)localObject3).isText()))
          {
            if (((ca)localObject3).bkz((String)localObject2))
            {
              locala.field_atCount += 1;
              paramaz1.ny(paramaz1.field_atCount + 1);
              if (paramaz2 != null) {
                paramaz2.ny(paramaz2.field_atCount + 1);
              }
              i = 1;
            }
            if (biN(((eo)localObject3).fqK))
            {
              locala.field_atAll = 1;
              paramaz1.ny(paramaz1.field_atCount + 4096);
              if (paramaz2 != null) {
                paramaz2.ny(paramaz2.field_atCount + 1);
              }
              i = 1;
            }
          }
        }
        locala.field_content = localca.field_content;
        break;
        label936:
        if ((localObject2 != null) && (!Util.isNullOrNil(((k)localObject2).field_userName)))
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
        if (localca.field_status != 1) {
          break label1178;
        }
        l = 9223372036854775807L;
        break label494;
        paramaz1.nt(i);
      }
      j = i;
      label1051:
      ag.bak();
      b.a(locala, paramInt2, paramInt1);
      paramc = (i.c)localObject1;
      if (Util.isNullOrNil((String)localObject1)) {
        paramc = localc.getDisplayName(localca.field_bizChatUserId);
      }
      Log.i("MicroMsg.BizConversationStorage", "updateBizChatConversation brandUserName:%s, bizChatId:%s, userId:%s, displayName:%s", new Object[] { paramString, localc.field_bizChatServId, localca.field_bizChatUserId, paramc });
      ag.bak().b(locala);
      if (j != 0)
      {
        this.NPD.a(paramaz1, paramString);
        if (paramaz2 != null) {
          this.NPD.a(paramaz2, paramaz2.field_username);
        }
      }
      AppMethodBeat.o(212323);
      return;
    }
  }
  
  public static void b(az paramaz, bw parambw)
  {
    AppMethodBeat.i(124602);
    if ((paramaz == null) || (parambw == null))
    {
      AppMethodBeat.o(124602);
      return;
    }
    az localaz;
    if ((com.tencent.mm.model.ab.IT(paramaz.field_username)) && (!Util.isNullOrNil(paramaz.field_parentRef)))
    {
      if ((ab.clc()) && (com.tencent.mm.model.ab.Js(paramaz.field_parentRef)))
      {
        AppMethodBeat.o(124602);
        return;
      }
      localaz = parambw.bjY(paramaz.field_parentRef);
      Log.v("MicroMsg.BizConversationStorage", "postConvExt, username = %s, parentRef = %s", new Object[] { paramaz.field_username, paramaz.field_parentRef });
      if (paramaz.field_parentRef.equals("officialaccounts")) {
        break label550;
      }
    }
    label550:
    for (int i = 1;; i = 0)
    {
      if (localaz == null)
      {
        localaz = new az(paramaz.field_parentRef);
        if (i != 0) {
          localaz.oT(2097152);
        }
      }
      for (int j = 1;; j = 0)
      {
        if ((i != 0) && (localaz.field_attrflag == 0))
        {
          localaz.oT(2097152);
          Log.v("MicroMsg.BizConversationStorage", "Enterprise cvs reset attr flag!");
        }
        Log.i("MicroMsg.BizConversationStorage", "enterprise cvs count is %d", new Object[] { Integer.valueOf(localaz.field_unReadCount) });
        Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bkl(paramaz.field_parentRef);
        ca localca = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aEx((String)localObject);
        if ((localca != null) && (localca.field_msgId > 0L))
        {
          localaz.aX(localca);
          localaz.setContent(localca.field_talker + ":" + localca.field_content);
          localaz.Cl(Integer.toString(localca.getType()));
          localObject = parambw.Xh();
          if (localObject != null)
          {
            PString localPString1 = new PString();
            PString localPString2 = new PString();
            PInt localPInt = new PInt();
            localca.Cy(paramaz.field_parentRef);
            localca.setContent(localaz.field_content);
            ((bw.b)localObject).a(localca, localPString1, localPString2, localPInt, true);
            localaz.Cm(localPString1.value);
            localaz.Cn(localPString2.value);
            localaz.nw(localPInt.value);
          }
        }
        for (;;)
        {
          int m = 0;
          int k = m;
          if (i != 0)
          {
            k = m;
            if (parambw.bkk(localaz.field_username) <= 0) {
              k = 1;
            }
          }
          if (k == 0) {
            break;
          }
          parambw.bjW(localaz.field_username);
          AppMethodBeat.o(124602);
          return;
          localaz.gCr();
          Log.i("MicroMsg.BizConversationStorage", "lastOfMsg is null or MsgId <= 0, lastConvBiz is %s", new Object[] { localObject });
        }
        if (j != 0)
        {
          parambw.e(localaz);
          AppMethodBeat.o(124602);
          return;
        }
        parambw.a(localaz, localaz.field_username);
        AppMethodBeat.o(124602);
        return;
      }
    }
  }
  
  private static boolean b(i.c paramc)
  {
    AppMethodBeat.i(212324);
    try
    {
      boolean bool = ag.baj().bs(paramc.ppv).iE(1);
      AppMethodBeat.o(212324);
      return bool;
    }
    catch (Throwable paramc)
    {
      AppMethodBeat.o(212324);
    }
    return false;
  }
  
  private static boolean biN(String paramString)
  {
    AppMethodBeat.i(124599);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(124599);
      return false;
    }
    paramString = XmlParser.parseXml(paramString, "msgsource", null);
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
  
  public static void biP(String paramString)
  {
    AppMethodBeat.i(124601);
    bw localbw = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST();
    paramString = new az(paramString);
    paramString.Co("officialaccounts");
    b(paramString, localbw);
    AppMethodBeat.o(124601);
  }
  
  public final void a(ca paramca, i.c paramc, boolean[] paramArrayOfBoolean) {}
  
  public final void a(ca paramca, az paramaz)
  {
    Object localObject = null;
    AppMethodBeat.i(124595);
    if ((paramaz != null) && (paramca != null) && (paramca.field_bizChatId != -1L) && (paramaz.oV(8388608)))
    {
      com.tencent.mm.al.a.c localc = ag.baj().bs(paramca.field_bizChatId);
      String str2 = paramaz.field_digest;
      if (!Util.isNullOrNil(paramca.field_bizChatUserId))
      {
        k localk = ag.bal().fB(paramca.field_bizChatUserId);
        String str1;
        boolean bool;
        if (localk != null)
        {
          str1 = localk.field_userName;
          bool = paramca.field_bizChatUserId.equals(ag.bal().fC(paramca.field_talker));
          if ((localk == null) || (!bool)) {
            break label218;
          }
          paramaz.Cm(MMApplicationContext.getContext().getString(2131755891) + ":" + str2);
        }
        for (;;)
        {
          if (!localc.isGroup())
          {
            if ((!bool) && (str1 != null) && (str1.length() > 0) && (!str1.equals(localc.field_chatName)))
            {
              localc.field_chatName = str1;
              ag.baj().b(localc);
              AppMethodBeat.o(124595);
              return;
              str1 = null;
              break;
              label218:
              if ((localk == null) || (Util.isNullOrNil(localk.field_userName))) {
                continue;
              }
              paramaz.Cm(localk.field_userName + ":" + str2);
              continue;
            }
            paramaz = ag.bal().fB(localc.field_bizChatServId);
            paramca = localObject;
            if (paramaz != null) {
              paramca = paramaz.field_userName;
            }
            if ((paramca != null) && (paramca.length() > 0) && (!paramca.equals(localc.field_chatName)))
            {
              localc.field_chatName = paramca;
              ag.baj().b(localc);
            }
          }
        }
        AppMethodBeat.o(124595);
        return;
      }
      Log.w("MicroMsg.BizConversationStorage", "BizChatUserId is null:%s %s", new Object[] { localc.field_bizChatServId, localc.field_chatName });
    }
    AppMethodBeat.o(124595);
  }
  
  public final void a(ca paramca, az paramaz, boolean paramBoolean, i.c paramc)
  {
    AppMethodBeat.i(124596);
    if (paramc == null)
    {
      Log.e("MicroMsg.BizConversationStorage", "compose notifyInfo is null");
      AppMethodBeat.o(124596);
      return;
    }
    String str = paramc.talker;
    if (paramBoolean)
    {
      if ((paramca != null) && (paramca.field_isSend != 1) && ((br.A(paramca) & 0x1) != 0))
      {
        Log.i("MicroMsg.BizConversationStorage", "create a temp session conversation.");
        paramaz.oT(4194304);
      }
      if ((paramca != null) && (com.tencent.mm.al.g.DQ(str)))
      {
        Log.i("MicroMsg.BizConversationStorage", "create a bitChat conversation.");
        paramaz.oT(8388608);
      }
    }
    for (;;)
    {
      if ((paramc != null) && (!paramc.hIs.isEmpty()) && (paramc.hIs.get(0) != null))
      {
        paramaz.nv(((ca)paramc.hIs.get(0)).field_isSend);
        if (paramc.zqn.equals("insert")) {
          paramaz.OoM = ((ca)paramc.hIs.get(paramc.hIs.size() - 1));
        }
      }
      AppMethodBeat.o(124596);
      return;
      as localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(str);
      if ((localas != null) && (localas.gBM()) && (!com.tencent.mm.contact.c.oR(localas.field_type)) && (paramca != null) && (paramca.field_isSend != 1) && (!paramaz.oV(4194304)) && ((paramaz.field_conversationTime < ag.baw()) || ((br.A(paramca) & 0x1) != 0)))
      {
        paramaz.oT(4194304);
        Log.i("MicroMsg.BizConversationStorage", "onNotifyChange is old temp session, %s", new Object[] { str });
      }
      if ((paramca != null) && (com.tencent.mm.al.g.DQ(str)))
      {
        Log.i("MicroMsg.BizConversationStorage", "onNotifyChange a bitChat conversation, %s", new Object[] { str });
        paramaz.oT(8388608);
      }
    }
  }
  
  public final void b(ca paramca, az paramaz, boolean paramBoolean, i.c paramc)
  {
    AppMethodBeat.i(124597);
    bw localbw = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST();
    String str;
    if (paramc == null)
    {
      str = null;
      if ((paramc == null) || (!paramc.zqn.equals("delete")) || (paramc.zqp <= 0)) {
        break label948;
      }
    }
    label673:
    label948:
    for (int i = paramc.zqp;; i = 0)
    {
      if ((paramc != null) && (paramc.zqn.equals("insert")) && (paramc.zqo > 0)) {}
      for (int j = paramc.zqo;; j = 0)
      {
        Object localObject1;
        label243:
        Object localObject3;
        Object localObject2;
        PString localPString;
        PInt localPInt;
        if (!Util.isNullOrNil(paramaz.field_parentRef))
        {
          paramca = localbw.bjY(paramaz.field_parentRef);
          if ((paramca != null) && (paramca.oV(2097152))) {
            if (j > 0)
            {
              if (((paramc.zqn.equals("insert")) && (paramc.tYD > 0)) || ((paramc.zqn.equals("update")) && (paramca.field_unReadCount + paramc.tYD >= 0)))
              {
                localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(str);
                if ((localObject1 != null) && ((((as)localObject1).Zx()) || (b(paramc)))) {
                  paramca.nz(paramca.field_unReadMuteCount + j);
                }
              }
              else
              {
                localbw.a(paramaz, i, j);
              }
            }
            else
            {
              localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bkl(paramaz.field_parentRef);
              localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aEx((String)localObject1);
              if ((localObject3 == null) || (((eo)localObject3).field_msgId <= 0L)) {
                break label711;
              }
              paramca.aX((ca)localObject3);
              paramca.setContent(((eo)localObject3).field_talker + ":" + ((eo)localObject3).field_content);
              paramca.Cl(Integer.toString(((ca)localObject3).getType()));
              if (localbw.Xh() != null)
              {
                localObject2 = new PString();
                localPString = new PString();
                localPInt = new PInt();
                ((ca)localObject3).Cy(paramaz.field_parentRef);
                ((ca)localObject3).setContent(paramca.field_content);
                localbw.Xh().a((ca)localObject3, (PString)localObject2, localPString, localPInt, true);
                localObject1 = localbw.dk(((ca)localObject3).getType(), ((eo)localObject3).field_content);
                if (((eo)localObject3).field_bizChatId == -1L) {
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
            localObject3 = ag.bal().fB(((eo)localObject3).field_bizChatUserId);
            ((PString)localObject2).value = String.format(((PString)localObject2).value, new Object[] { ((k)localObject3).field_userName });
            paramca.Cn("");
            localObject2 = Util.nullAsNil(((PString)localObject2).value);
            if (Util.isNullOrNil((String)localObject1))
            {
              localObject1 = "";
              paramca.Cm(((String)localObject2).concat((String)localObject1));
              paramca.nw(localPInt.value);
              if (localbw.a(paramca, paramaz.field_parentRef) > 0)
              {
                Log.d("MicroMsg.BizConversationStorage", "hakon update parent conversation's unread %s, %d", new Object[] { paramaz.field_parentRef, Integer.valueOf(paramca.field_unReadCount + j) });
                localbw.doNotify(3, (MStorageEx)localbw, paramaz.field_parentRef);
              }
              a(str, paramaz, j, i, paramc, paramca);
              AppMethodBeat.o(124597);
              return;
              str = paramc.talker;
              break;
              paramca.nt(paramca.field_unReadCount + j);
              break label243;
              paramca.Cn(localPString.value);
              continue;
            }
            localObject1 = " " + Util.nullAsNil((String)localObject1);
            continue;
            label711:
            paramca.gCr();
            continue;
            if ((paramca != null) && ("officialaccounts".equals(paramca.field_username)))
            {
              if ((j > 0) && (!ab.clc()) && (((paramc.zqn.equals("insert")) && (paramc.tYD > 0)) || ((paramc.zqn.equals("update")) && (paramca.field_unReadCount + paramc.tYD >= 0))))
              {
                paramca.nt(paramca.field_unReadCount + j);
                localbw.a(paramca, paramaz.field_parentRef);
              }
            }
            else if ((paramca != null) && ("appbrandcustomerservicemsg".equals(paramca.field_username)) && (j > 0))
            {
              if (((paramc.zqn.equals("insert")) && (paramc.tYD > 0)) || ((paramc.zqn.equals("update")) && (paramca.field_unReadCount + paramc.tYD >= 0))) {
                paramca.nt(paramca.field_unReadCount + j);
              }
              localbw.a(paramaz, i, j);
              localbw.a(paramca, paramaz.field_parentRef);
            }
            continue;
          }
          catch (Throwable localThrowable)
          {
            continue;
          }
          paramca = null;
        }
      }
    }
  }
  
  public final void biO(String paramString)
  {
    AppMethodBeat.i(124600);
    if ((paramString == null) || (!com.tencent.mm.model.ab.IT(paramString)) || (!com.tencent.mm.al.g.Ng(paramString)))
    {
      AppMethodBeat.o(124600);
      return;
    }
    az localaz = this.NPD.bjY(paramString);
    if (localaz == null)
    {
      AppMethodBeat.o(124600);
      return;
    }
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bkl(paramString);
    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aEx((String)localObject);
    if ((localObject != null) && (((eo)localObject).field_msgId > 0L))
    {
      localaz.aX((ca)localObject);
      localaz.setContent(((eo)localObject).field_talker + ":" + ((eo)localObject).field_content);
      localaz.Cl(Integer.toString(((ca)localObject).getType()));
      bw.b localb = this.NPD.Xh();
      if (localb == null) {
        break label277;
      }
      PString localPString1 = new PString();
      PString localPString2 = new PString();
      PInt localPInt = new PInt();
      ((ca)localObject).Cy(paramString);
      ((ca)localObject).setContent(localaz.field_content);
      localb.a((ca)localObject, localPString1, localPString2, localPInt, true);
      localaz.Cm(localPString1.value);
      localaz.Cn(localPString2.value);
      localaz.nw(localPInt.value);
    }
    for (;;)
    {
      this.NPD.a(localaz, localaz.field_username);
      AppMethodBeat.o(124600);
      return;
      label277:
      localaz.gCr();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.u
 * JD-Core Version:    0.7.0.1
 */