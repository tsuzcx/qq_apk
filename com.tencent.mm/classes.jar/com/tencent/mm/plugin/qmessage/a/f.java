package com.tencent.mm.plugin.qmessage.a;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.ah.e.b;
import com.tencent.mm.ah.e.c;
import com.tencent.mm.as.o;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.util.Map;
import junit.framework.Assert;

public final class f
  implements com.tencent.mm.ah.e
{
  public final void a(e.c paramc)
  {
    o.OJ().r(paramc.bWO);
  }
  
  public final e.b b(e.a parama)
  {
    cd localcd = parama.dBs;
    if (localcd == null)
    {
      y.e("MicroMsg.QMsgExtension", "onPreAddMessage cmdAM is null");
      return null;
    }
    if ((localcd.kSW != 36) && (localcd.kSW != 39))
    {
      y.e("MicroMsg.QMsgExtension", "onPreAddMessage cmdAM.type:%d", new Object[] { Integer.valueOf(localcd.kSW) });
      return null;
    }
    Object localObject2 = aa.a(localcd.svH);
    String str1 = aa.a(localcd.svF);
    Object localObject1 = aa.a(localcd.svG);
    y.d("MicroMsg.QMsgExtension", "parseQMsg content:" + (String)localObject2);
    au.Hx();
    String str2 = (String)c.Dz().get(2, null);
    bi localbi;
    if (str2.equals(str1))
    {
      au.Hx();
      localbi = c.Fy().O((String)localObject1, localcd.ndp);
      y.d("MicroMsg.QMsgExtension", "dkmsgid parseQMsg svrid:%d localid:%d", new Object[] { Long.valueOf(localcd.ndp), Long.valueOf(localbi.field_msgId) });
      if ((localbi.field_msgId != 0L) && (localbi.field_createTime + 604800000L < com.tencent.mm.model.bd.o(str1, localcd.mPL)))
      {
        y.w("MicroMsg.QMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", new Object[] { Long.valueOf(localcd.ndp), Long.valueOf(localbi.field_msgId) });
        com.tencent.mm.model.bd.bC(localbi.field_msgId);
        localbi.setMsgId(0L);
      }
      if (localbi.field_msgId != 0L) {
        break label1081;
      }
      localbi = new bi();
      localbi.bf(localcd.ndp);
      localbi.bg(com.tencent.mm.model.bd.o(str1, localcd.mPL));
    }
    label785:
    label811:
    label1078:
    label1081:
    for (;;)
    {
      localbi.setType(localcd.kSW);
      localbi.ec((String)localObject1);
      Object localObject3 = g.btk().Lc((String)localObject1);
      if ((localObject3 == null) || (bk.pm(((d)localObject3).getUsername()).length() <= 0))
      {
        localObject3 = new d();
        ((d)localObject3).username = ((String)localObject1);
        ((d)localObject3).ncu = 1;
        ((d)localObject3).bcw = 9;
        if (!g.btk().a((d)localObject3)) {
          y.e("MicroMsg.QMsgExtension", "parseQMsg : insert QContact failed : username = " + ((d)localObject3).getUsername());
        }
      }
      long l2 = -1L;
      long l1 = l2;
      int i;
      if (localcd.svI == 2)
      {
        l1 = l2;
        if (localbi.field_msgId == 0L)
        {
          localObject1 = aa.a(localcd.svJ);
          localObject3 = new PString();
          PInt localPInt1 = new PInt();
          PInt localPInt2 = new PInt();
          com.tencent.mm.as.g localg = o.OJ();
          i = localcd.svI;
          l2 = localg.a((byte[])localObject1, localcd.ndp, false, "", (PString)localObject3, localPInt1, localPInt2);
          l1 = l2;
          if (l2 > 0L)
          {
            localbi.ed(((PString)localObject3).value);
            localbi.fK(localPInt1.value);
            localbi.fL(localPInt2.value);
            l1 = l2;
          }
        }
      }
      boolean bool;
      if (localcd.kSW == 36)
      {
        Assert.assertTrue(true);
        if (bk.pm((String)localObject2).length() <= 0) {
          break label959;
        }
        bool = true;
        label608:
        Assert.assertTrue(bool);
        if (bk.pm(localbi.field_talker).length() <= 0) {
          break label965;
        }
        bool = true;
        label630:
        Assert.assertTrue(bool);
        i = 0;
        au.Hx();
        localObject1 = c.Fw().abl(localbi.field_talker);
        if ((localObject1 != null) && (bk.pm(((ao)localObject1).field_username).length() > 0)) {
          break label1078;
        }
        i = 1;
        localObject1 = new ad(localbi.field_talker);
      }
      for (;;)
      {
        localObject3 = new f.a((byte)0);
        localObject2 = bn.s((String)localObject2, "msg");
        if (localObject2 != null)
        {
          ((f.a)localObject3).dtK = ((String)((Map)localObject2).get(".msg.from.displayname"));
          ((f.a)localObject3).content = ((String)((Map)localObject2).get(".msg.content.t"));
        }
        if (((f.a)localObject3).dtK == null)
        {
          localObject2 = "";
          label765:
          ((ad)localObject1).df((String)localObject2);
          if (((f.a)localObject3).content != null) {
            break label981;
          }
          localObject2 = "";
          localbi.setContent((String)localObject2);
          if (i == 0) {
            break label991;
          }
          au.Hx();
          c.Fw().V((ad)localObject1);
          au.Hx();
          if ((!c.FE().has(str1)) && (!str2.equals(str1))) {
            break label1014;
          }
          i = 1;
          label840:
          if (i == 0) {
            break label1019;
          }
          localbi.fA(1);
          i = localcd.hQq;
        }
        for (;;)
        {
          localbi.setStatus(i);
          localbi.cY(localcd.svK);
          com.tencent.mm.model.bd.a(localbi, parama);
          if (localbi.field_msgId != 0L) {
            break label1048;
          }
          localbi.setMsgId(com.tencent.mm.model.bd.h(localbi));
          if (localcd.svI == 2)
          {
            parama = o.OJ().b(Long.valueOf(l1));
            parama.bV((int)localbi.field_msgId);
            o.OJ().a(Long.valueOf(l1), parama);
          }
          return new e.b(localbi, true);
          localObject1 = str1;
          break;
          label959:
          bool = false;
          break label608;
          label965:
          bool = false;
          break label630;
          localObject2 = ((f.a)localObject3).dtK;
          break label765;
          label981:
          localObject2 = ((f.a)localObject3).content;
          break label785;
          label991:
          au.Hx();
          c.Fw().a(((ao)localObject1).field_username, (ad)localObject1);
          break label811;
          label1014:
          i = 0;
          break label840;
          label1019:
          localbi.fA(0);
          if (localcd.hQq > 3) {
            i = localcd.hQq;
          } else {
            i = 3;
          }
        }
        au.Hx();
        c.Fy().b(localcd.ndp, localbi);
        return new e.b(localbi, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.a.f
 * JD-Core Version:    0.7.0.1
 */