package com.tencent.mm.storage;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a.b;
import com.tencent.mm.aj.a.c;
import com.tencent.mm.aj.a.d;
import com.tencent.mm.aj.a.k;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.plugin.messenger.foundation.a.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;

public final class p
  implements e, com.tencent.mm.plugin.messenger.foundation.a.f
{
  private be ywz;
  
  public p(be parambe)
  {
    AppMethodBeat.i(11844);
    z.afw();
    this.ywz = parambe;
    this.ywz.a(this);
    this.ywz.a(this);
    AppMethodBeat.o(11844);
  }
  
  private void a(String paramString, ak paramak, int paramInt1, int paramInt2, h.c paramc)
  {
    AppMethodBeat.i(11848);
    bi localbi;
    com.tencent.mm.aj.a.a locala;
    c localc;
    Object localObject1;
    Object localObject2;
    label375:
    Object localObject3;
    if ((paramak != null) && (paramc != null) && (paramc.jUy != -1L) && (paramak.ji(8388608)))
    {
      localbi = ((com.tencent.mm.aj.o)g.E(com.tencent.mm.aj.o.class)).YD().bb(paramString, paramc.jUy);
      locala = z.afl().gF(paramc.jUy);
      localc = z.afk().aG(paramc.jUy);
      if (localc.field_bizChatServId == null)
      {
        ab.w("MicroMsg.BizConversationStorage", "willen updateBizChatConversation bizChatInfo == null");
        AppMethodBeat.o(11848);
        return;
      }
      if ((localbi == null) || (localbi.field_msgId == 0L))
      {
        ab.i("MicroMsg.BizConversationStorage", "update null BizChatConversation with talker ".concat(String.valueOf(paramString)));
        locala.field_status = 0;
        locala.field_isSend = 0;
        locala.field_content = "";
        locala.field_msgType = "0";
        locala.field_unReadCount = 0;
        locala.field_digest = "";
        locala.field_digestUser = "";
        z.afl();
        b.a(locala, paramInt2, paramInt1);
        z.afl().b(locala);
        AppMethodBeat.o(11848);
        return;
      }
      boolean bool = localc.isGroup();
      locala.field_brandUserName = paramString;
      if (localbi.dxQ())
      {
        locala.field_content = localbi.dyr();
        localObject1 = new PString();
        this.ywz.BX().a(localbi, (PString)localObject1, new PString(), new PInt(), false);
        localObject1 = ((PString)localObject1).value;
        localObject2 = z.afm().df(localbi.field_bizChatUserId);
        if (!bool) {
          break label920;
        }
        if ((localbi.field_isSend != 1) || (localObject2 == null)) {
          break label848;
        }
        locala.field_digest = (ah.getContext().getString(2131296992) + ":" + (String)localObject1);
        ((com.tencent.mm.aj.a.j)localObject2).field_userName = ah.getContext().getString(2131296992);
        localObject1 = null;
        localObject2 = this.ywz.ac(localbi.getType(), localbi.field_content);
        localObject3 = bo.nullAsNil(locala.field_digest);
        if (!bo.isNullOrNil((String)localObject2)) {
          break label933;
        }
        localObject2 = "";
        label418:
        locala.field_digest = ((String)localObject3).concat((String)localObject2);
        locala.field_digestUser = "";
        locala.field_chatType = localc.field_chatType;
        locala.field_lastMsgID = localbi.field_msgId;
        if (!localbi.byk()) {
          break label959;
        }
      }
    }
    label668:
    label933:
    label959:
    label1095:
    label1098:
    for (;;)
    {
      long l = localbi.field_createTime;
      label472:
      locala.field_lastMsgTime = l;
      locala.field_status = localbi.field_status;
      locala.field_isSend = localbi.field_isSend;
      locala.field_msgType = Integer.toString(localbi.getType());
      locala.field_flag = b.a(locala, 1, localbi.field_createTime);
      int j = 0;
      int i;
      if ((!paramc.oDP.equals("insert")) || (paramc.oDR <= 0))
      {
        i = j;
        if (paramc.oDP.equals("update"))
        {
          i = j;
          if (locala.field_unReadCount + paramc.oDR < 0) {}
        }
      }
      else
      {
        locala.field_unReadCount += paramc.oDR;
        locala.field_newUnReadCount += paramc.oDR;
        i = j;
        if (paramc.oDR > 0)
        {
          i = j;
          if (localc.kY(1))
          {
            i = paramak.field_unReadCount - paramc.oDR;
            if (i > 0) {
              break label976;
            }
            paramak.hJ(0);
            paramak.hP(paramak.field_unReadMuteCount + paramc.oDR);
            i = 1;
          }
        }
      }
      j = i;
      if (paramc.oDP.equals("insert"))
      {
        j = i;
        if (paramc.oDQ.size() > 0)
        {
          j = i;
          if (localc.isGroup())
          {
            localObject2 = z.afm().dg(localbi.field_talker);
            paramc = paramc.oDQ.iterator();
            label753:
            if (paramc.hasNext())
            {
              localObject3 = (bi)paramc.next();
              if ((localObject2 == null) || (((dd)localObject3).field_isSend == 1) || (!((bi)localObject3).isText()) || (!((bi)localObject3).asi((String)localObject2))) {
                break label1095;
              }
              locala.field_atCount += 1;
              paramak.hO(paramak.field_atCount + 1);
              i = 1;
            }
          }
        }
      }
      for (;;)
      {
        break label753;
        locala.field_content = localbi.field_content;
        break;
        label848:
        if ((localObject2 != null) && (!bo.isNullOrNil(((com.tencent.mm.aj.a.j)localObject2).field_userName)))
        {
          locala.field_digest = (((com.tencent.mm.aj.a.j)localObject2).field_userName + ":" + (String)localObject1);
          localObject1 = ((com.tencent.mm.aj.a.j)localObject2).field_userName;
          break label375;
        }
        locala.field_digest = ((String)localObject1);
        localObject1 = null;
        break label375;
        locala.field_digest = ((String)localObject1);
        localObject1 = null;
        break label375;
        localObject2 = " " + bo.nullAsNil((String)localObject2);
        break label418;
        if (localbi.field_status != 1) {
          break label1098;
        }
        l = 9223372036854775807L;
        break label472;
        label976:
        paramak.hJ(i);
        break label668;
        j = i;
        z.afl();
        b.a(locala, paramInt2, paramInt1);
        paramc = (h.c)localObject1;
        if (bo.isNullOrNil((String)localObject1)) {
          paramc = localc.nE(localbi.field_bizChatUserId);
        }
        ab.i("MicroMsg.BizConversationStorage", "updateBizChatConversation brandUserName:%s, bizChatId:%s, userId:%s, displayName:%s", new Object[] { paramString, localc.field_bizChatServId, localbi.field_bizChatUserId, paramc });
        z.afl().b(locala);
        if (j != 0) {
          this.ywz.a(paramak, paramString);
        }
        AppMethodBeat.o(11848);
        return;
      }
    }
  }
  
  public static void aqS(String paramString)
  {
    AppMethodBeat.i(11850);
    be localbe = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YF();
    paramString = new ak(paramString);
    paramString.jY("officialaccounts");
    b(paramString, localbe);
    AppMethodBeat.o(11850);
  }
  
  public static void b(ak paramak, be parambe)
  {
    AppMethodBeat.i(11851);
    if ((paramak == null) || (parambe == null))
    {
      AppMethodBeat.o(11851);
      return;
    }
    ak localak;
    if ((t.nU(paramak.field_username)) && (!bo.isNullOrNil(paramak.field_parentRef)))
    {
      if ((s.aWl()) && (t.ot(paramak.field_parentRef)))
      {
        AppMethodBeat.o(11851);
        return;
      }
      localak = parambe.arH(paramak.field_parentRef);
      ab.v("MicroMsg.BizConversationStorage", "postConvExt, username = %s, parentRef = %s", new Object[] { paramak.field_username, paramak.field_parentRef });
      if (paramak.field_parentRef.equals("officialaccounts")) {
        break label550;
      }
    }
    label550:
    for (int i = 1;; i = 0)
    {
      if (localak == null)
      {
        localak = new ak(paramak.field_parentRef);
        if (i != 0) {
          localak.jg(2097152);
        }
      }
      for (int j = 1;; j = 0)
      {
        if ((i != 0) && (localak.field_attrflag == 0))
        {
          localak.jg(2097152);
          ab.v("MicroMsg.BizConversationStorage", "Enterprise cvs reset attr flag!");
        }
        ab.i("MicroMsg.BizConversationStorage", "enterprise cvs count is %d", new Object[] { Integer.valueOf(localak.field_unReadCount) });
        Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YF().arT(paramak.field_parentRef);
        bi localbi = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().Tm((String)localObject);
        if ((localbi != null) && (localbi.field_msgId > 0L))
        {
          localak.aq(localbi);
          localak.setContent(localbi.field_talker + ":" + localbi.field_content);
          localak.jV(Integer.toString(localbi.getType()));
          localObject = parambe.BX();
          if (localObject != null)
          {
            PString localPString1 = new PString();
            PString localPString2 = new PString();
            PInt localPInt = new PInt();
            localbi.kj(paramak.field_parentRef);
            localbi.setContent(localak.field_content);
            ((be.b)localObject).a(localbi, localPString1, localPString2, localPInt, true);
            localak.jW(localPString1.value);
            localak.jX(localPString2.value);
            localak.hM(localPInt.value);
          }
        }
        for (;;)
        {
          int m = 0;
          int k = m;
          if (i != 0)
          {
            k = m;
            if (parambe.arS(localak.field_username) <= 0) {
              k = 1;
            }
          }
          if (k == 0) {
            break;
          }
          parambe.arF(localak.field_username);
          AppMethodBeat.o(11851);
          return;
          localak.dxc();
          ab.i("MicroMsg.BizConversationStorage", "lastOfMsg is null or MsgId <= 0, lastConvBiz is %s", new Object[] { localObject });
        }
        if (j != 0)
        {
          parambe.d(localak);
          AppMethodBeat.o(11851);
          return;
        }
        parambe.a(localak, localak.field_username);
        AppMethodBeat.o(11851);
        return;
      }
    }
  }
  
  public final void a(bi parambi, ak paramak)
  {
    Object localObject = null;
    AppMethodBeat.i(11845);
    if ((paramak != null) && (parambi != null) && (parambi.field_bizChatId != -1L) && (paramak.ji(8388608)))
    {
      c localc = z.afk().aG(parambi.field_bizChatId);
      String str2 = paramak.field_digest;
      if (!bo.isNullOrNil(parambi.field_bizChatUserId))
      {
        com.tencent.mm.aj.a.j localj = z.afm().df(parambi.field_bizChatUserId);
        String str1;
        boolean bool;
        if (localj != null)
        {
          str1 = localj.field_userName;
          bool = parambi.field_bizChatUserId.equals(z.afm().dg(parambi.field_talker));
          if ((localj == null) || (!bool)) {
            break label218;
          }
          paramak.jW(ah.getContext().getString(2131296992) + ":" + str2);
        }
        for (;;)
        {
          if (!localc.isGroup())
          {
            if ((!bool) && (str1 != null) && (str1.length() > 0) && (!str1.equals(localc.field_chatName)))
            {
              localc.field_chatName = str1;
              z.afk().b(localc);
              AppMethodBeat.o(11845);
              return;
              str1 = null;
              break;
              label218:
              if ((localj == null) || (bo.isNullOrNil(localj.field_userName))) {
                continue;
              }
              paramak.jW(localj.field_userName + ":" + str2);
              continue;
            }
            paramak = z.afm().df(localc.field_bizChatServId);
            parambi = localObject;
            if (paramak != null) {
              parambi = paramak.field_userName;
            }
            if ((parambi != null) && (parambi.length() > 0) && (!parambi.equals(localc.field_chatName)))
            {
              localc.field_chatName = parambi;
              z.afk().b(localc);
            }
          }
        }
        AppMethodBeat.o(11845);
        return;
      }
      ab.w("MicroMsg.BizConversationStorage", "BizChatUserId is null:%s %s", new Object[] { localc.field_bizChatServId, localc.field_chatName });
    }
    AppMethodBeat.o(11845);
  }
  
  public final void a(bi parambi, ak paramak, boolean paramBoolean, h.c paramc)
  {
    AppMethodBeat.i(11846);
    if (paramc == null)
    {
      ab.e("MicroMsg.BizConversationStorage", "compose notifyInfo is null");
      AppMethodBeat.o(11846);
      return;
    }
    String str = paramc.talker;
    if (paramBoolean)
    {
      if ((parambi != null) && (parambi.field_isSend != 1) && ((bh.n(parambi) & 0x1) != 0))
      {
        ab.i("MicroMsg.BizConversationStorage", "create a temp session conversation.");
        paramak.jg(4194304);
      }
      if ((parambi != null) && (com.tencent.mm.aj.f.lg(str)))
      {
        ab.i("MicroMsg.BizConversationStorage", "create a bitChat conversation.");
        paramak.jg(8388608);
      }
    }
    for (;;)
    {
      if ((paramc != null) && (!paramc.oDQ.isEmpty()) && (paramc.oDQ.get(0) != null))
      {
        paramak.hL(((bi)paramc.oDQ.get(0)).field_isSend);
        if (paramc.oDP.equals("insert")) {
          paramak.yMq = ((bi)paramc.oDQ.get(paramc.oDQ.size() - 1));
        }
      }
      AppMethodBeat.o(11846);
      return;
      ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(str);
      if ((localad != null) && (localad.dwz()) && (!com.tencent.mm.n.a.je(localad.field_type)) && (parambi != null) && (parambi.field_isSend != 1) && (!paramak.ji(4194304)) && ((paramak.field_conversationTime < z.afw()) || ((bh.n(parambi) & 0x1) != 0)))
      {
        paramak.jg(4194304);
        ab.i("MicroMsg.BizConversationStorage", "onNotifyChange is old temp session, %s", new Object[] { str });
      }
      if ((parambi != null) && (com.tencent.mm.aj.f.lg(str)))
      {
        ab.i("MicroMsg.BizConversationStorage", "onNotifyChange a bitChat conversation, %s", new Object[] { str });
        paramak.jg(8388608);
      }
    }
  }
  
  public final void aqR(String paramString)
  {
    AppMethodBeat.i(11849);
    if ((paramString == null) || (!t.nU(paramString)) || (!com.tencent.mm.aj.f.rX(paramString)))
    {
      AppMethodBeat.o(11849);
      return;
    }
    ak localak = this.ywz.arH(paramString);
    if (localak == null)
    {
      AppMethodBeat.o(11849);
      return;
    }
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YF().arT(paramString);
    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().Tm((String)localObject);
    if ((localObject != null) && (((dd)localObject).field_msgId > 0L))
    {
      localak.aq((bi)localObject);
      localak.setContent(((dd)localObject).field_talker + ":" + ((dd)localObject).field_content);
      localak.jV(Integer.toString(((bi)localObject).getType()));
      be.b localb = this.ywz.BX();
      if (localb == null) {
        break label277;
      }
      PString localPString1 = new PString();
      PString localPString2 = new PString();
      PInt localPInt = new PInt();
      ((bi)localObject).kj(paramString);
      ((bi)localObject).setContent(localak.field_content);
      localb.a((bi)localObject, localPString1, localPString2, localPInt, true);
      localak.jW(localPString1.value);
      localak.jX(localPString2.value);
      localak.hM(localPInt.value);
    }
    for (;;)
    {
      this.ywz.a(localak, localak.field_username);
      AppMethodBeat.o(11849);
      return;
      label277:
      localak.dxc();
    }
  }
  
  public final void b(bi parambi, ak paramak, boolean paramBoolean, h.c paramc)
  {
    AppMethodBeat.i(11847);
    be localbe = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YF();
    if (paramc == null)
    {
      parambi = null;
      if ((paramc == null) || (!paramc.oDP.equals("delete")) || (paramc.oDT <= 0)) {
        break label896;
      }
    }
    label896:
    for (int i = paramc.oDT;; i = 0)
    {
      if ((paramc != null) && (paramc.oDP.equals("insert")) && (paramc.oDS > 0)) {}
      for (int j = paramc.oDS;; j = 0)
      {
        ak localak;
        Object localObject1;
        label239:
        String str;
        if (!bo.isNullOrNil(paramak.field_parentRef))
        {
          localak = localbe.arH(paramak.field_parentRef);
          if ((localak == null) || (!localak.ji(2097152))) {
            break label664;
          }
          if (j > 0)
          {
            if (((paramc.oDP.equals("insert")) && (paramc.oDR > 0)) || ((paramc.oDP.equals("update")) && (localak.field_unReadCount + paramc.oDR >= 0)))
            {
              localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(parambi);
              if ((localObject1 == null) || (!((ad)localObject1).DP())) {
                break label614;
              }
              localak.hP(localak.field_unReadMuteCount + j);
            }
            localbe.a(paramak, i, j);
          }
          localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YF().arT(paramak.field_parentRef);
          Object localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().Tm((String)localObject1);
          if ((localObject2 == null) || (((dd)localObject2).field_msgId <= 0L)) {
            break label656;
          }
          localak.aq((bi)localObject2);
          localak.setContent(((dd)localObject2).field_talker + ":" + ((dd)localObject2).field_content);
          localak.jV(Integer.toString(((bi)localObject2).getType()));
          if (localbe.BX() != null)
          {
            localObject1 = new PString();
            PString localPString = new PString();
            PInt localPInt = new PInt();
            ((bi)localObject2).kj(paramak.field_parentRef);
            ((bi)localObject2).setContent(localak.field_content);
            localbe.BX().a((bi)localObject2, (PString)localObject1, localPString, localPInt, true);
            str = localbe.ac(((bi)localObject2).getType(), ((dd)localObject2).field_content);
            localObject2 = bo.nullAsNil(((PString)localObject1).value);
            if (!bo.isNullOrNil(str)) {
              break label630;
            }
            localObject1 = "";
            label488:
            localak.jW(((String)localObject2).concat((String)localObject1));
            localak.jX(localPString.value);
            localak.hM(localPInt.value);
          }
          label520:
          if (localbe.a(localak, paramak.field_parentRef) > 0)
          {
            ab.d("MicroMsg.BizConversationStorage", "hakon update parent conversation's unread %s, %d", new Object[] { paramak.field_parentRef, Integer.valueOf(localak.field_unReadCount + j) });
            localbe.b(3, (n)localbe, paramak.field_parentRef);
          }
        }
        for (;;)
        {
          a(parambi, paramak, j, i, paramc);
          AppMethodBeat.o(11847);
          return;
          parambi = paramc.talker;
          break;
          label614:
          localak.hJ(localak.field_unReadCount + j);
          break label239;
          label630:
          localObject1 = " " + bo.nullAsNil(str);
          break label488;
          label656:
          localak.dxc();
          break label520;
          label664:
          if ((localak != null) && ("officialaccounts".equals(localak.field_username)))
          {
            if ((j > 0) && (!s.aWl()) && (((paramc.oDP.equals("insert")) && (paramc.oDR > 0)) || ((paramc.oDP.equals("update")) && (localak.field_unReadCount + paramc.oDR >= 0))))
            {
              localak.hJ(localak.field_unReadCount + j);
              localbe.a(localak, paramak.field_parentRef);
            }
          }
          else if ((localak != null) && ("appbrandcustomerservicemsg".equals(localak.field_username)) && (j > 0))
          {
            if (((paramc.oDP.equals("insert")) && (paramc.oDR > 0)) || ((paramc.oDP.equals("update")) && (localak.field_unReadCount + paramc.oDR >= 0))) {
              localak.hJ(localak.field_unReadCount + j);
            }
            localbe.a(paramak, i, j);
            localbe.a(localak, paramak.field_parentRef);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.storage.p
 * JD-Core Version:    0.7.0.1
 */