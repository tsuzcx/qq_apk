package com.tencent.mm.storage;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.a.a;
import com.tencent.mm.ao.a.b;
import com.tencent.mm.ao.a.c;
import com.tencent.mm.ao.a.k;
import com.tencent.mm.ao.a.l;
import com.tencent.mm.ao.af;
import com.tencent.mm.ao.g;
import com.tencent.mm.ao.q;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bs;
import com.tencent.mm.plugin.biz.b.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
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
  implements com.tencent.mm.plugin.messenger.foundation.a.h, com.tencent.mm.plugin.messenger.foundation.a.i
{
  private bw Vdp;
  
  public u(bw parambw)
  {
    AppMethodBeat.i(124594);
    af.bjK();
    this.Vdp = parambw;
    this.Vdp.a(this);
    this.Vdp.a(this);
    AppMethodBeat.o(124594);
  }
  
  private void a(String paramString, az paramaz1, int paramInt1, int paramInt2, i.c paramc, az paramaz2)
  {
    AppMethodBeat.i(207950);
    ca localca;
    a locala;
    c localc;
    Object localObject1;
    Object localObject2;
    label374:
    Object localObject3;
    if ((paramaz1 != null) && (paramc != null) && (paramc.syu != -1L) && (paramaz1.rp(8388608)))
    {
      localca = ((q)com.tencent.mm.kernel.h.ae(q.class)).bbP().ce(paramString, paramc.syu);
      locala = af.bjy().Gt(paramc.syu);
      localc = af.bjx().bF(paramc.syu);
      if (localc.field_bizChatServId == null)
      {
        Log.w("MicroMsg.BizConversationStorage", "willen updateBizChatConversation bizChatInfo == null");
        AppMethodBeat.o(207950);
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
        af.bjy();
        b.a(locala, paramInt2, paramInt1);
        af.bjy().b(locala);
        AppMethodBeat.o(207950);
        return;
      }
      boolean bool = localc.bjM();
      locala.field_brandUserName = paramString;
      if (localca.hzx())
      {
        locala.field_content = localca.hAm();
        localObject1 = new PString();
        this.Vdp.abK().a(localca, (PString)localObject1, new PString(), new PInt(), false);
        localObject1 = ((PString)localObject1).value;
        localObject2 = af.bjz().gm(localca.field_bizChatUserId);
        if (!bool) {
          break label1010;
        }
        if ((localca.field_isSend != 1) || (localObject2 == null)) {
          break label938;
        }
        locala.field_digest = (MMApplicationContext.getContext().getString(b.f.app_me) + ":" + (String)localObject1);
        ((k)localObject2).field_userName = MMApplicationContext.getContext().getString(b.f.app_me);
        localObject1 = null;
        localObject2 = this.Vdp.dj(localca.getType(), localca.field_content);
        localObject3 = Util.nullAsNil(locala.field_digest);
        if ((!Util.isNullOrNil((String)localObject2)) && (!((String)localObject3).endsWith((String)localObject2))) {
          locala.field_digest = ((String)localObject3 + " " + (String)localObject2);
        }
        locala.field_digestUser = "";
        locala.field_chatType = localc.field_chatType;
        locala.field_lastMsgID = localca.field_msgId;
        if (!localca.dlT()) {
          break label1023;
        }
      }
    }
    label1040:
    label1180:
    for (;;)
    {
      long l = localca.field_createTime;
      label496:
      locala.field_lastMsgTime = l;
      locala.field_status = localca.field_status;
      locala.field_isSend = localca.field_isSend;
      locala.field_msgType = Integer.toString(localca.getType());
      locala.field_flag = b.a(locala, 1, localca.field_createTime);
      int j = 0;
      int i;
      if ((!paramc.EVM.equals("insert")) || (paramc.xKO <= 0))
      {
        i = j;
        if (paramc.EVM.equals("update"))
        {
          i = j;
          if (locala.field_unReadCount + paramc.xKO < 0) {}
        }
      }
      else
      {
        locala.field_unReadCount += paramc.xKO;
        locala.field_newUnReadCount += paramc.xKO;
        i = j;
        if (paramc.xKO > 0)
        {
          i = j;
          if (localc.jQ(1))
          {
            i = paramaz1.field_unReadCount - paramc.xKO;
            if (i > 0) {
              break label1040;
            }
            paramaz1.pH(0);
          }
        }
      }
      for (;;)
      {
        paramaz1.pN(paramaz1.field_unReadMuteCount + paramc.xKO);
        i = 1;
        j = i;
        if (!paramc.EVM.equals("insert")) {
          break label1053;
        }
        j = i;
        if (paramc.kvM.size() <= 0) {
          break label1053;
        }
        j = i;
        if (!localc.bjM()) {
          break label1053;
        }
        localObject2 = af.bjz().gn(localca.field_talker);
        paramc = paramc.kvM.iterator();
        while (paramc.hasNext())
        {
          localObject3 = (ca)paramc.next();
          if ((localObject2 != null) && (((et)localObject3).field_isSend != 1) && (((ca)localObject3).hwH()))
          {
            if (((ca)localObject3).bwY((String)localObject2))
            {
              locala.field_atCount += 1;
              paramaz1.pM(paramaz1.field_atCount + 1);
              if (paramaz2 != null) {
                paramaz2.pM(paramaz2.field_atCount + 1);
              }
              i = 1;
            }
            if (bvh(((et)localObject3).hxy))
            {
              locala.field_atAll = 1;
              paramaz1.pM(paramaz1.field_atCount + 4096);
              if (paramaz2 != null) {
                paramaz2.pM(paramaz2.field_atCount + 1);
              }
              i = 1;
            }
          }
        }
        locala.field_content = localca.field_content;
        break;
        label938:
        if ((localObject2 != null) && (!Util.isNullOrNil(((k)localObject2).field_userName)))
        {
          locala.field_digest = (((k)localObject2).field_userName + ":" + (String)localObject1);
          localObject1 = ((k)localObject2).field_userName;
          break label374;
        }
        locala.field_digest = ((String)localObject1);
        localObject1 = null;
        break label374;
        label1010:
        locala.field_digest = ((String)localObject1);
        localObject1 = null;
        break label374;
        label1023:
        if (localca.field_status != 1) {
          break label1180;
        }
        l = 9223372036854775807L;
        break label496;
        paramaz1.pH(i);
      }
      j = i;
      label1053:
      af.bjy();
      b.a(locala, paramInt2, paramInt1);
      paramc = (i.c)localObject1;
      if (Util.isNullOrNil((String)localObject1)) {
        paramc = localc.PJ(localca.field_bizChatUserId);
      }
      Log.i("MicroMsg.BizConversationStorage", "updateBizChatConversation brandUserName:%s, bizChatId:%s, userId:%s, displayName:%s", new Object[] { paramString, localc.field_bizChatServId, localca.field_bizChatUserId, paramc });
      af.bjy().b(locala);
      if (j != 0)
      {
        this.Vdp.a(paramaz1, paramString);
        if (paramaz2 != null) {
          this.Vdp.a(paramaz2, paramaz2.field_username);
        }
      }
      AppMethodBeat.o(207950);
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
    if ((ab.Qm(paramaz.field_username)) && (!Util.isNullOrNil(paramaz.field_parentRef)))
    {
      if (ab.QL(paramaz.field_parentRef))
      {
        AppMethodBeat.o(124602);
        return;
      }
      localaz = parambw.bwx(paramaz.field_parentRef);
      Log.v("MicroMsg.BizConversationStorage", "postConvExt, username = %s, parentRef = %s", new Object[] { paramaz.field_username, paramaz.field_parentRef });
      if (paramaz.field_parentRef.equals("officialaccounts")) {
        break label544;
      }
    }
    label544:
    for (int i = 1;; i = 0)
    {
      if (localaz == null)
      {
        localaz = new az(paramaz.field_parentRef);
        if (i != 0) {
          localaz.rn(2097152);
        }
      }
      for (int j = 1;; j = 0)
      {
        if ((i != 0) && (localaz.field_attrflag == 0))
        {
          localaz.rn(2097152);
          Log.v("MicroMsg.BizConversationStorage", "Enterprise cvs reset attr flag!");
        }
        Log.i("MicroMsg.BizConversationStorage", "enterprise cvs count is %d", new Object[] { Integer.valueOf(localaz.field_unReadCount) });
        Object localObject = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwJ(paramaz.field_parentRef);
        ca localca = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOH((String)localObject);
        if ((localca != null) && (localca.field_msgId > 0L))
        {
          localaz.bq(localca);
          localaz.setContent(localca.field_talker + ":" + localca.field_content);
          localaz.IZ(Integer.toString(localca.getType()));
          localObject = parambw.abK();
          if (localObject != null)
          {
            PString localPString1 = new PString();
            PString localPString2 = new PString();
            PInt localPInt = new PInt();
            localca.Jm(paramaz.field_parentRef);
            localca.setContent(localaz.field_content);
            ((bw.b)localObject).a(localca, localPString1, localPString2, localPInt, true);
            localaz.Ja(localPString1.value);
            localaz.Jb(localPString2.value);
            localaz.pK(localPInt.value);
          }
        }
        for (;;)
        {
          int m = 0;
          int k = m;
          if (i != 0)
          {
            k = m;
            if (parambw.bwI(localaz.field_username) <= 0) {
              k = 1;
            }
          }
          if (k == 0) {
            break;
          }
          parambw.bwv(localaz.field_username);
          AppMethodBeat.o(124602);
          return;
          localaz.hyE();
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
    AppMethodBeat.i(207951);
    try
    {
      boolean bool = af.bjx().bF(paramc.syu).jQ(1);
      AppMethodBeat.o(207951);
      return bool;
    }
    catch (Throwable paramc)
    {
      AppMethodBeat.o(207951);
    }
    return false;
  }
  
  private static boolean bvh(String paramString)
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
  
  public static void bvj(String paramString)
  {
    AppMethodBeat.i(124601);
    bw localbw = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR();
    paramString = new az(paramString);
    paramString.Jc("officialaccounts");
    b(paramString, localbw);
    AppMethodBeat.o(124601);
  }
  
  public final void a(ca paramca, i.c paramc, boolean[] paramArrayOfBoolean) {}
  
  public final void a(ca paramca, az paramaz)
  {
    Object localObject = null;
    AppMethodBeat.i(124595);
    if ((paramaz != null) && (paramca != null) && (paramca.field_bizChatId != -1L) && (paramaz.rp(8388608)))
    {
      c localc = af.bjx().bF(paramca.field_bizChatId);
      String str2 = paramaz.field_digest;
      if (!Util.isNullOrNil(paramca.field_bizChatUserId))
      {
        k localk = af.bjz().gm(paramca.field_bizChatUserId);
        String str1;
        boolean bool;
        if (localk != null)
        {
          str1 = localk.field_userName;
          bool = paramca.field_bizChatUserId.equals(af.bjz().gn(paramca.field_talker));
          if ((localk == null) || (!bool)) {
            break label219;
          }
          paramaz.Ja(MMApplicationContext.getContext().getString(b.f.app_me) + ":" + str2);
        }
        for (;;)
        {
          if (!localc.bjM())
          {
            if ((!bool) && (str1 != null) && (str1.length() > 0) && (!str1.equals(localc.field_chatName)))
            {
              localc.field_chatName = str1;
              af.bjx().b(localc);
              AppMethodBeat.o(124595);
              return;
              str1 = null;
              break;
              label219:
              if ((localk == null) || (Util.isNullOrNil(localk.field_userName))) {
                continue;
              }
              paramaz.Ja(localk.field_userName + ":" + str2);
              continue;
            }
            paramaz = af.bjz().gm(localc.field_bizChatServId);
            paramca = localObject;
            if (paramaz != null) {
              paramca = paramaz.field_userName;
            }
            if ((paramca != null) && (paramca.length() > 0) && (!paramca.equals(localc.field_chatName)))
            {
              localc.field_chatName = paramca;
              af.bjx().b(localc);
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
      if ((paramca != null) && (paramca.field_isSend != 1) && ((bs.C(paramca) & 0x1) != 0))
      {
        Log.i("MicroMsg.BizConversationStorage", "create a temp session conversation.");
        paramaz.rn(4194304);
      }
      if ((paramca != null) && (g.KI(str)))
      {
        Log.i("MicroMsg.BizConversationStorage", "create a bitChat conversation.");
        paramaz.rn(8388608);
      }
    }
    for (;;)
    {
      if ((paramc != null) && (!paramc.kvM.isEmpty()) && (paramc.kvM.get(0) != null))
      {
        paramaz.pJ(((ca)paramc.kvM.get(0)).field_isSend);
        if (paramc.EVM.equals("insert")) {
          paramaz.VEF = ((ca)paramc.kvM.get(paramc.kvM.size() - 1));
        }
      }
      AppMethodBeat.o(124596);
      return;
      as localas = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(str);
      if ((localas != null) && (localas.hxX()) && (!com.tencent.mm.contact.d.rk(localas.field_type)) && (paramca != null) && (paramca.field_isSend != 1) && (!paramaz.rp(4194304)) && ((paramaz.field_conversationTime < af.bjK()) || ((bs.C(paramca) & 0x1) != 0)))
      {
        paramaz.rn(4194304);
        Log.i("MicroMsg.BizConversationStorage", "onNotifyChange is old temp session, %s", new Object[] { str });
      }
      if ((paramca != null) && (g.KI(str)))
      {
        Log.i("MicroMsg.BizConversationStorage", "onNotifyChange a bitChat conversation, %s", new Object[] { str });
        paramaz.rn(8388608);
      }
    }
  }
  
  public final void b(ca paramca, az paramaz, boolean paramBoolean, i.c paramc)
  {
    AppMethodBeat.i(124597);
    bw localbw = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR();
    String str;
    if (paramc == null)
    {
      str = null;
      if ((paramc == null) || (!paramc.EVM.equals("delete")) || (paramc.EVO <= 0)) {
        break label861;
      }
    }
    label673:
    label711:
    label861:
    for (int i = paramc.EVO;; i = 0)
    {
      if ((paramc != null) && (paramc.EVM.equals("insert")) && (paramc.EVN > 0)) {}
      for (int j = paramc.EVN;; j = 0)
      {
        Object localObject1;
        label243:
        Object localObject3;
        Object localObject2;
        PString localPString;
        PInt localPInt;
        if (!Util.isNullOrNil(paramaz.field_parentRef))
        {
          paramca = localbw.bwx(paramaz.field_parentRef);
          if ((paramca != null) && (paramca.rp(2097152))) {
            if (j > 0)
            {
              if (((paramc.EVM.equals("insert")) && (paramc.xKO > 0)) || ((paramc.EVM.equals("update")) && (paramca.field_unReadCount + paramc.xKO >= 0)))
              {
                localObject1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(str);
                if ((localObject1 != null) && ((((as)localObject1).aeg()) || (b(paramc)))) {
                  paramca.pN(paramca.field_unReadMuteCount + j);
                }
              }
              else
              {
                localbw.a(paramaz, i, j);
              }
            }
            else
            {
              localObject1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwJ(paramaz.field_parentRef);
              localObject3 = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOH((String)localObject1);
              if ((localObject3 == null) || (((et)localObject3).field_msgId <= 0L)) {
                break label711;
              }
              paramca.bq((ca)localObject3);
              paramca.setContent(((et)localObject3).field_talker + ":" + ((et)localObject3).field_content);
              paramca.IZ(Integer.toString(((ca)localObject3).getType()));
              if (localbw.abK() != null)
              {
                localObject2 = new PString();
                localPString = new PString();
                localPInt = new PInt();
                ((ca)localObject3).Jm(paramaz.field_parentRef);
                ((ca)localObject3).setContent(paramca.field_content);
                localbw.abK().a((ca)localObject3, (PString)localObject2, localPString, localPInt, true);
                localObject1 = localbw.dj(((ca)localObject3).getType(), ((et)localObject3).field_content);
                if (((et)localObject3).field_bizChatId == -1L) {
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
            localObject3 = af.bjz().gm(((et)localObject3).field_bizChatUserId);
            ((PString)localObject2).value = String.format(((PString)localObject2).value, new Object[] { ((k)localObject3).field_userName });
            paramca.Jb("");
            localObject2 = Util.nullAsNil(((PString)localObject2).value);
            if (Util.isNullOrNil((String)localObject1))
            {
              localObject1 = "";
              paramca.Ja(((String)localObject2).concat((String)localObject1));
              paramca.pK(localPInt.value);
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
              paramca.pH(paramca.field_unReadCount + j);
              break label243;
              paramca.Jb(localPString.value);
              continue;
            }
            localObject1 = " " + Util.nullAsNil((String)localObject1);
            continue;
            paramca.hyE();
            continue;
            if (((paramca == null) || (!"officialaccounts".equals(paramca.field_username))) && (paramca != null) && ("appbrandcustomerservicemsg".equals(paramca.field_username)) && (j > 0))
            {
              if (((paramc.EVM.equals("insert")) && (paramc.xKO > 0)) || ((paramc.EVM.equals("update")) && (paramca.field_unReadCount + paramc.xKO >= 0))) {
                paramca.pH(paramca.field_unReadCount + j);
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
  
  public final void bvi(String paramString)
  {
    AppMethodBeat.i(124600);
    if ((paramString == null) || (!ab.Qm(paramString)) || (!g.UC(paramString)))
    {
      AppMethodBeat.o(124600);
      return;
    }
    az localaz = this.Vdp.bwx(paramString);
    if (localaz == null)
    {
      AppMethodBeat.o(124600);
      return;
    }
    Object localObject = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwJ(paramString);
    localObject = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOH((String)localObject);
    if ((localObject != null) && (((et)localObject).field_msgId > 0L))
    {
      localaz.bq((ca)localObject);
      localaz.setContent(((et)localObject).field_talker + ":" + ((et)localObject).field_content);
      localaz.IZ(Integer.toString(((ca)localObject).getType()));
      bw.b localb = this.Vdp.abK();
      if (localb == null) {
        break label277;
      }
      PString localPString1 = new PString();
      PString localPString2 = new PString();
      PInt localPInt = new PInt();
      ((ca)localObject).Jm(paramString);
      ((ca)localObject).setContent(localaz.field_content);
      localb.a((ca)localObject, localPString1, localPString2, localPInt, true);
      localaz.Ja(localPString1.value);
      localaz.Jb(localPString2.value);
      localaz.pK(localPInt.value);
    }
    for (;;)
    {
      this.Vdp.a(localaz, localaz.field_username);
      AppMethodBeat.o(124600);
      return;
      label277:
      localaz.hyE();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.u
 * JD-Core Version:    0.7.0.1
 */