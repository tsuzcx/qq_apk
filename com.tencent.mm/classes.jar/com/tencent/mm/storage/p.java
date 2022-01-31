package com.tencent.mm.storage;

import android.content.Context;
import com.tencent.mm.ai.a.b;
import com.tencent.mm.ai.a.c;
import com.tencent.mm.ai.a.d;
import com.tencent.mm.ai.a.k;
import com.tencent.mm.ai.z;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.as;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.bf;
import com.tencent.mm.plugin.biz.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.c;
import com.tencent.mm.plugin.messenger.foundation.a.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;

public final class p
  implements e, com.tencent.mm.plugin.messenger.foundation.a.f
{
  private be umT;
  
  public p(be parambe)
  {
    z.MM();
    this.umT = parambe;
    this.umT.a(this);
    this.umT.a(this);
  }
  
  private void a(String paramString, ak paramak, int paramInt1, int paramInt2, g.c paramc)
  {
    bi localbi;
    com.tencent.mm.ai.a.a locala;
    c localc;
    if ((paramak != null) && (paramc != null) && (paramc.idK != -1L) && (paramak.gV(8388608)))
    {
      localbi = ((com.tencent.mm.ai.o)com.tencent.mm.kernel.g.r(com.tencent.mm.ai.o.class)).Fz().at(paramString, paramc.idK);
      locala = z.MB().bK(paramc.idK);
      localc = z.MA().aj(paramc.idK);
      if (localc.field_bizChatServId == null) {
        y.w("MicroMsg.BizConversationStorage", "willen updateBizChatConversation bizChatInfo == null");
      }
    }
    else
    {
      return;
    }
    if ((localbi == null) || (localbi.field_msgId == 0L))
    {
      y.i("MicroMsg.BizConversationStorage", "update null BizChatConversation with talker " + paramString);
      locala.field_status = 0;
      locala.field_isSend = 0;
      locala.field_content = "";
      locala.field_msgType = "0";
      locala.field_unReadCount = 0;
      locala.field_digest = "";
      locala.field_digestUser = "";
      z.MB();
      b.a(locala, paramInt2, paramInt1);
      z.MB().b(locala);
      return;
    }
    boolean bool = localc.isGroup();
    locala.field_brandUserName = paramString;
    label231:
    Object localObject1;
    Object localObject2;
    label366:
    Object localObject3;
    if (localbi.cvm())
    {
      locala.field_content = localbi.cvK();
      localObject1 = new PString();
      this.umT.tt().a(localbi, (PString)localObject1, new PString(), new PInt(), false);
      localObject1 = ((PString)localObject1).value;
      localObject2 = z.MC().bY(localbi.field_bizChatUserId);
      if (!bool) {
        break label911;
      }
      if ((localbi.field_isSend != 1) || (localObject2 == null)) {
        break label839;
      }
      locala.field_digest = (ae.getContext().getString(b.b.app_me) + ":" + (String)localObject1);
      ((com.tencent.mm.ai.a.j)localObject2).field_userName = ae.getContext().getString(b.b.app_me);
      localObject1 = null;
      localObject2 = this.umT.bd(localbi.getType(), localbi.field_content);
      localObject3 = bk.pm(locala.field_digest);
      if (!bk.bl((String)localObject2)) {
        break label924;
      }
      localObject2 = "";
      label409:
      locala.field_digest = ((String)localObject3).concat((String)localObject2);
      locala.field_digestUser = "";
      locala.field_chatType = localc.field_chatType;
      locala.field_lastMsgID = localbi.field_msgId;
      if (!localbi.aRR()) {
        break label950;
      }
    }
    label659:
    label924:
    label950:
    label1080:
    label1083:
    for (;;)
    {
      long l = localbi.field_createTime;
      label463:
      locala.field_lastMsgTime = l;
      locala.field_status = localbi.field_status;
      locala.field_isSend = localbi.field_isSend;
      locala.field_msgType = Integer.toString(localbi.getType());
      locala.field_flag = b.a(locala, 1, localbi.field_createTime);
      int j = 0;
      int i;
      if ((!paramc.mdt.equals("insert")) || (paramc.mdv <= 0))
      {
        i = j;
        if (paramc.mdt.equals("update"))
        {
          i = j;
          if (locala.field_unReadCount + paramc.mdv < 0) {}
        }
      }
      else
      {
        locala.field_unReadCount += paramc.mdv;
        locala.field_newUnReadCount += paramc.mdv;
        i = j;
        if (paramc.mdv > 0)
        {
          i = j;
          if (localc.il(1))
          {
            i = paramak.field_unReadCount - paramc.mdv;
            if (i > 0) {
              break label967;
            }
            paramak.fy(0);
            paramak.fE(paramak.field_unReadMuteCount + paramc.mdv);
            i = 1;
          }
        }
      }
      j = i;
      if (paramc.mdt.equals("insert"))
      {
        j = i;
        if (paramc.mdu.size() > 0)
        {
          j = i;
          if (localc.isGroup())
          {
            localObject2 = z.MC().bZ(localbi.field_talker);
            paramc = paramc.mdu.iterator();
            label744:
            if (paramc.hasNext())
            {
              localObject3 = (bi)paramc.next();
              if ((localObject2 == null) || (((cs)localObject3).field_isSend == 1) || (!((bi)localObject3).isText()) || (!((bi)localObject3).abY((String)localObject2))) {
                break label1080;
              }
              locala.field_atCount += 1;
              paramak.fD(paramak.field_atCount + 1);
              i = 1;
            }
          }
        }
      }
      for (;;)
      {
        break label744;
        locala.field_content = localbi.field_content;
        break label231;
        label839:
        if ((localObject2 != null) && (!bk.bl(((com.tencent.mm.ai.a.j)localObject2).field_userName)))
        {
          locala.field_digest = (((com.tencent.mm.ai.a.j)localObject2).field_userName + ":" + (String)localObject1);
          localObject1 = ((com.tencent.mm.ai.a.j)localObject2).field_userName;
          break label366;
        }
        locala.field_digest = ((String)localObject1);
        localObject1 = null;
        break label366;
        locala.field_digest = ((String)localObject1);
        localObject1 = null;
        break label366;
        localObject2 = " " + bk.pm((String)localObject2);
        break label409;
        if (localbi.field_status != 1) {
          break label1083;
        }
        l = 9223372036854775807L;
        break label463;
        label967:
        paramak.fy(i);
        break label659;
        j = i;
        z.MB();
        b.a(locala, paramInt2, paramInt1);
        paramc = (g.c)localObject1;
        if (bk.bl((String)localObject1)) {
          paramc = localc.gV(localbi.field_bizChatUserId);
        }
        y.i("MicroMsg.BizConversationStorage", "updateBizChatConversation brandUserName:%s, bizChatId:%s, userId:%s, displayName:%s", new Object[] { paramString, localc.field_bizChatServId, localbi.field_bizChatUserId, paramc });
        z.MB().b(locala);
        if (j == 0) {
          break;
        }
        this.umT.a(paramak, paramString);
        return;
      }
    }
  }
  
  public static void aaH(String paramString)
  {
    be localbe = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FB();
    paramString = new ak(paramString);
    paramString.dS("officialaccounts");
    b(paramString, localbe);
  }
  
  public static void b(ak paramak, be parambe)
  {
    int m = 0;
    if ((paramak == null) || (parambe == null)) {}
    while ((!com.tencent.mm.model.s.hl(paramak.field_username)) || (bk.bl(paramak.field_parentRef)) || ((s.ctL()) && (com.tencent.mm.model.s.hK(paramak.field_parentRef)))) {
      return;
    }
    ak localak = parambe.abv(paramak.field_parentRef);
    y.v("MicroMsg.BizConversationStorage", "postConvExt, username = %s, parentRef = %s", new Object[] { paramak.field_username, paramak.field_parentRef });
    if (!paramak.field_parentRef.equals("officialaccounts")) {}
    for (int i = 1;; i = 0)
    {
      if (localak == null)
      {
        localak = new ak(paramak.field_parentRef);
        if (i != 0) {
          localak.gT(2097152);
        }
      }
      for (int j = 1;; j = 0)
      {
        y.i("MicroMsg.BizConversationStorage", "enterprise cvs count is %d", new Object[] { Integer.valueOf(localak.field_unReadCount) });
        Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FB().abJ(paramak.field_parentRef);
        bi localbi = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().HA((String)localObject);
        if ((localbi != null) && (localbi.field_msgId > 0L))
        {
          localak.ai(localbi);
          localak.setContent(localbi.field_talker + ":" + localbi.field_content);
          localak.dP(Integer.toString(localbi.getType()));
          localObject = parambe.tt();
          if (localObject != null)
          {
            PString localPString1 = new PString();
            PString localPString2 = new PString();
            PInt localPInt = new PInt();
            localbi.ec(paramak.field_parentRef);
            localbi.setContent(localak.field_content);
            ((be.b)localObject).a(localbi, localPString1, localPString2, localPInt, true);
            localak.dQ(localPString1.value);
            localak.dR(localPString2.value);
            localak.fB(localPInt.value);
          }
        }
        for (;;)
        {
          int k = m;
          if (i != 0)
          {
            k = m;
            if (parambe.abI(localak.field_username) <= 0) {
              k = 1;
            }
          }
          if (k == 0) {
            break;
          }
          parambe.abu(localak.field_username);
          return;
          localak.cuB();
          y.i("MicroMsg.BizConversationStorage", "lastOfMsg is null or MsgId <= 0, lastConvBiz is %s", new Object[] { localObject });
        }
        if (j != 0)
        {
          parambe.d(localak);
          return;
        }
        parambe.a(localak, localak.field_username);
        return;
      }
    }
  }
  
  public final void a(bi parambi, ak paramak)
  {
    Object localObject = null;
    c localc;
    String str2;
    com.tencent.mm.ai.a.j localj;
    String str1;
    if ((paramak != null) && (parambi != null) && (parambi.field_bizChatId != -1L) && (paramak.gV(8388608)))
    {
      localc = z.MA().aj(parambi.field_bizChatId);
      str2 = paramak.field_digest;
      if (bk.bl(parambi.field_bizChatUserId)) {
        break label321;
      }
      localj = z.MC().bY(parambi.field_bizChatUserId);
      if (localj == null) {
        break label201;
      }
      str1 = localj.field_userName;
      boolean bool = parambi.field_bizChatUserId.equals(z.MC().bZ(parambi.field_talker));
      if ((localj == null) || (!bool)) {
        break label207;
      }
      paramak.dQ(ae.getContext().getString(b.b.app_me) + ":" + str2);
      label146:
      if (!localc.isGroup())
      {
        if ((bool) || (str1 == null) || (str1.length() <= 0) || (str1.equals(localc.field_chatName))) {
          break label258;
        }
        localc.field_chatName = str1;
        z.MA().b(localc);
      }
    }
    label201:
    label207:
    do
    {
      return;
      str1 = null;
      break;
      if ((localj == null) || (bk.bl(localj.field_userName))) {
        break label146;
      }
      paramak.dQ(localj.field_userName + ":" + str2);
      break label146;
      paramak = z.MC().bY(localc.field_bizChatServId);
      parambi = localObject;
      if (paramak != null) {
        parambi = paramak.field_userName;
      }
    } while ((parambi == null) || (parambi.length() <= 0) || (parambi.equals(localc.field_chatName)));
    label258:
    localc.field_chatName = parambi;
    z.MA().b(localc);
    return;
    label321:
    y.w("MicroMsg.BizConversationStorage", "BizChatUserId is null:%s %s", new Object[] { localc.field_bizChatServId, localc.field_chatName });
  }
  
  public final void a(bi parambi, ak paramak, boolean paramBoolean, g.c paramc)
  {
    if (paramc == null) {
      y.e("MicroMsg.BizConversationStorage", "compose notifyInfo is null");
    }
    label323:
    for (;;)
    {
      return;
      String str = paramc.talker;
      if (paramBoolean)
      {
        if ((parambi != null) && (parambi.field_isSend != 1) && ((bf.j(parambi) & 0x1) != 0))
        {
          y.i("MicroMsg.BizConversationStorage", "create a temp session conversation.");
          paramak.gT(4194304);
        }
        if ((parambi != null) && (com.tencent.mm.ai.f.eW(str)))
        {
          y.i("MicroMsg.BizConversationStorage", "create a bitChat conversation.");
          paramak.gT(8388608);
        }
      }
      for (;;)
      {
        if ((paramc == null) || (paramc.mdu.isEmpty()) || (paramc.mdu.get(0) == null)) {
          break label323;
        }
        paramak.fA(((bi)paramc.mdu.get(0)).field_isSend);
        if (!paramc.mdt.equals("insert")) {
          break;
        }
        paramak.uAh = ((bi)paramc.mdu.get(paramc.mdu.size() - 1));
        return;
        ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(str);
        if ((localad != null) && (localad.cua()) && (!com.tencent.mm.n.a.gR(localad.field_type)) && (parambi != null) && (parambi.field_isSend != 1) && (!paramak.gV(4194304)) && ((paramak.field_conversationTime < z.MM()) || ((bf.j(parambi) & 0x1) != 0)))
        {
          paramak.gT(4194304);
          y.i("MicroMsg.BizConversationStorage", "onNotifyChange is old temp session, %s", new Object[] { str });
        }
        if ((parambi != null) && (com.tencent.mm.ai.f.eW(str)))
        {
          y.i("MicroMsg.BizConversationStorage", "onNotifyChange a bitChat conversation, %s", new Object[] { str });
          paramak.gT(8388608);
        }
      }
    }
  }
  
  public final void aaG(String paramString)
  {
    if ((paramString == null) || (!com.tencent.mm.model.s.hl(paramString)) || (!com.tencent.mm.ai.f.lc(paramString))) {}
    ak localak;
    Object localObject;
    do
    {
      do
      {
        return;
        localak = this.umT.abv(paramString);
      } while (localak == null);
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FB().abJ(paramString);
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().HA((String)localObject);
    } while ((localObject == null) || (((cs)localObject).field_msgId <= 0L));
    localak.ai((bi)localObject);
    localak.setContent(((cs)localObject).field_talker + ":" + ((cs)localObject).field_content);
    localak.dP(Integer.toString(((bi)localObject).getType()));
    be.b localb = this.umT.tt();
    if (localb != null)
    {
      PString localPString1 = new PString();
      PString localPString2 = new PString();
      PInt localPInt = new PInt();
      ((bi)localObject).ec(paramString);
      ((bi)localObject).setContent(localak.field_content);
      localb.a((bi)localObject, localPString1, localPString2, localPInt, true);
      localak.dQ(localPString1.value);
      localak.dR(localPString2.value);
      localak.fB(localPInt.value);
    }
    for (;;)
    {
      this.umT.a(localak, localak.field_username);
      return;
      localak.cuB();
    }
  }
  
  public final void b(bi parambi, ak paramak, boolean paramBoolean, g.c paramc)
  {
    be localbe = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FB();
    if (paramc == null)
    {
      parambi = null;
      if ((paramc == null) || (!paramc.mdt.equals("delete")) || (paramc.mdx <= 0)) {
        break label884;
      }
    }
    label233:
    label618:
    label884:
    for (int i = paramc.mdx;; i = 0)
    {
      if ((paramc != null) && (paramc.mdt.equals("insert")) && (paramc.mdw > 0)) {}
      for (int j = paramc.mdw;; j = 0)
      {
        ak localak;
        Object localObject1;
        String str;
        if (!bk.bl(paramak.field_parentRef))
        {
          localak = localbe.abv(paramak.field_parentRef);
          if ((localak == null) || (!localak.gV(2097152))) {
            break label652;
          }
          if (j > 0)
          {
            if (((paramc.mdt.equals("insert")) && (paramc.mdv > 0)) || ((paramc.mdt.equals("update")) && (localak.field_unReadCount + paramc.mdv >= 0)))
            {
              localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(parambi);
              if ((localObject1 == null) || (!((ad)localObject1).Bj())) {
                break label602;
              }
              localak.fE(localak.field_unReadMuteCount + j);
            }
            localbe.a(paramak, i, j);
          }
          localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FB().abJ(paramak.field_parentRef);
          Object localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().HA((String)localObject1);
          if ((localObject2 == null) || (((cs)localObject2).field_msgId <= 0L)) {
            break label644;
          }
          localak.ai((bi)localObject2);
          localak.setContent(((cs)localObject2).field_talker + ":" + ((cs)localObject2).field_content);
          localak.dP(Integer.toString(((bi)localObject2).getType()));
          if (localbe.tt() != null)
          {
            localObject1 = new PString();
            PString localPString = new PString();
            PInt localPInt = new PInt();
            ((bi)localObject2).ec(paramak.field_parentRef);
            ((bi)localObject2).setContent(localak.field_content);
            localbe.tt().a((bi)localObject2, (PString)localObject1, localPString, localPInt, true);
            str = localbe.bd(((bi)localObject2).getType(), ((cs)localObject2).field_content);
            localObject2 = bk.pm(((PString)localObject1).value);
            if (!bk.bl(str)) {
              break label618;
            }
            localObject1 = "";
            localak.dQ(((String)localObject2).concat((String)localObject1));
            localak.dR(localPString.value);
            localak.fB(localPInt.value);
          }
          if (localbe.a(localak, paramak.field_parentRef) > 0)
          {
            y.d("MicroMsg.BizConversationStorage", "hakon update parent conversation's unread %s, %d", new Object[] { paramak.field_parentRef, Integer.valueOf(localak.field_unReadCount + j) });
            localbe.b(3, (m)localbe, paramak.field_parentRef);
          }
        }
        for (;;)
        {
          a(parambi, paramak, j, i, paramc);
          return;
          parambi = paramc.talker;
          break;
          localak.fy(localak.field_unReadCount + j);
          break label233;
          localObject1 = " " + bk.pm(str);
          break label482;
          localak.cuB();
          break label514;
          if ((localak != null) && ("officialaccounts".equals(localak.field_username)))
          {
            if ((j > 0) && (!s.ctL()) && (((paramc.mdt.equals("insert")) && (paramc.mdv > 0)) || ((paramc.mdt.equals("update")) && (localak.field_unReadCount + paramc.mdv >= 0))))
            {
              localak.fy(localak.field_unReadCount + j);
              localbe.a(localak, paramak.field_parentRef);
            }
          }
          else if ((localak != null) && ("appbrandcustomerservicemsg".equals(localak.field_username)) && (j > 0))
          {
            if (((paramc.mdt.equals("insert")) && (paramc.mdv > 0)) || ((paramc.mdt.equals("update")) && (localak.field_unReadCount + paramc.mdv >= 0))) {
              localak.fy(localak.field_unReadCount + j);
            }
            localbe.a(paramak, i, j);
            localbe.a(localak, paramak.field_parentRef);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.storage.p
 * JD-Core Version:    0.7.0.1
 */