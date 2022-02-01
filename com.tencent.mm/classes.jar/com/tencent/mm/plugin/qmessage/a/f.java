package com.tencent.mm.plugin.qmessage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.b;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.av.q;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import java.util.Map;
import junit.framework.Assert;

public final class f
  implements com.tencent.mm.ak.e
{
  public final e.b b(e.a parama)
  {
    AppMethodBeat.i(27725);
    cv localcv = parama.gte;
    if (localcv == null)
    {
      ae.e("MicroMsg.QMsgExtension", "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(27725);
      return null;
    }
    if ((localcv.urJ != 36) && (localcv.urJ != 39))
    {
      ae.e("MicroMsg.QMsgExtension", "onPreAddMessage cmdAM.type:%d", new Object[] { Integer.valueOf(localcv.urJ) });
      AppMethodBeat.o(27725);
      return null;
    }
    Object localObject2 = z.a(localcv.FNI);
    String str1 = z.a(localcv.FNG);
    Object localObject1 = z.a(localcv.FNH);
    ae.d("MicroMsg.QMsgExtension", "parseQMsg content:".concat(String.valueOf(localObject2)));
    bc.aCg();
    String str2 = (String)c.ajA().get(2, null);
    bv localbv;
    if (str2.equals(str1))
    {
      bc.aCg();
      localbv = c.azI().aJ((String)localObject1, localcv.xrk);
      ae.d("MicroMsg.QMsgExtension", "dkmsgid parseQMsg svrid:%d localid:%d", new Object[] { Long.valueOf(localcv.xrk), Long.valueOf(localbv.field_msgId) });
      if ((localbv.field_msgId != 0L) && (localbv.field_createTime + 604800000L < bl.B(str1, localcv.CreateTime)))
      {
        ae.w("MicroMsg.QMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", new Object[] { Long.valueOf(localcv.xrk), Long.valueOf(localbv.field_msgId) });
        bl.rW(localbv.field_msgId);
        localbv.setMsgId(0L);
      }
      if (localbv.field_msgId != 0L) {
        break label1091;
      }
      localbv = new bv();
      localbv.qM(localcv.xrk);
      localbv.qN(bl.B(str1, localcv.CreateTime));
    }
    label777:
    label803:
    label832:
    label1091:
    for (;;)
    {
      localbv.setType(localcv.urJ);
      localbv.ui((String)localObject1);
      Object localObject3 = g.dFk().awi((String)localObject1);
      if ((localObject3 == null) || (bu.nullAsNil(((d)localObject3).getUsername()).length() <= 0))
      {
        localObject3 = new d();
        ((d)localObject3).username = ((String)localObject1);
        ((d)localObject3).xpU = 1;
        ((d)localObject3).dEu = 9;
        if (!g.dFk().a((d)localObject3)) {
          ae.e("MicroMsg.QMsgExtension", "parseQMsg : insert QContact failed : username = " + ((d)localObject3).getUsername());
        }
      }
      long l2;
      if ((localcv.FNJ == 2) && (localbv.field_msgId == 0L))
      {
        localObject3 = z.a(localcv.FNK);
        PString localPString = new PString();
        PInt localPInt1 = new PInt();
        PInt localPInt2 = new PInt();
        l2 = q.aIX().a((String)localObject1, (byte[])localObject3, localcv.xrk, false, "", localPString, localPInt1, localPInt2);
        l1 = l2;
        if (l2 > 0L)
        {
          localbv.uj(localPString.value);
          localbv.kD(localPInt1.value);
          localbv.kE(localPInt2.value);
        }
      }
      for (long l1 = l2;; l1 = -1L)
      {
        boolean bool;
        label600:
        label622:
        int i;
        if (localcv.urJ == 36)
        {
          Assert.assertTrue(true);
          if (bu.nullAsNil((String)localObject2).length() <= 0) {
            break label959;
          }
          bool = true;
          Assert.assertTrue(bool);
          if (bu.nullAsNil(localbv.field_talker).length() <= 0) {
            break label965;
          }
          bool = true;
          Assert.assertTrue(bool);
          i = 0;
          bc.aCg();
          localObject1 = c.azF().BH(localbv.field_talker);
          if ((localObject1 != null) && (bu.nullAsNil(((aw)localObject1).field_username).length() > 0)) {
            break label1081;
          }
          i = 1;
          localObject1 = new an(localbv.field_talker);
        }
        for (;;)
        {
          localObject3 = new a((byte)0);
          localObject2 = bx.M((String)localObject2, "msg");
          if (localObject2 != null)
          {
            ((a)localObject3).fXp = ((String)((Map)localObject2).get(".msg.from.displayname"));
            ((a)localObject3).content = ((String)((Map)localObject2).get(".msg.content.t"));
          }
          if (((a)localObject3).fXp == null)
          {
            localObject2 = "";
            label757:
            ((an)localObject1).tm((String)localObject2);
            if (((a)localObject3).content != null) {
              break label981;
            }
            localObject2 = "";
            localbv.setContent((String)localObject2);
            if (i == 0) {
              break label991;
            }
            bc.aCg();
            c.azF().an((an)localObject1);
            bc.aCg();
            if ((!c.azO().has(str1)) && (!str2.equals(str1))) {
              break label1014;
            }
            i = 1;
            if (i == 0) {
              break label1019;
            }
            localbv.kt(1);
            i = localcv.nJb;
            label848:
            localbv.setStatus(i);
            localbv.tk(localcv.FNL);
            bl.a(localbv, parama);
            if (localbv.field_msgId != 0L) {
              break label1048;
            }
            localbv.setMsgId(bl.v(localbv));
            if (localcv.FNJ == 2)
            {
              parama = q.aIX().c(Long.valueOf(l1));
              parama.sq((int)localbv.field_msgId);
              q.aIX().a(Long.valueOf(l1), parama);
            }
          }
          for (parama = new e.b(localbv, true);; parama = new e.b(localbv, false))
          {
            AppMethodBeat.o(27725);
            return parama;
            localObject1 = str1;
            break;
            bool = false;
            break label600;
            label965:
            bool = false;
            break label622;
            localObject2 = ((a)localObject3).fXp;
            break label757;
            label981:
            localObject2 = ((a)localObject3).content;
            break label777;
            label991:
            bc.aCg();
            c.azF().c(((aw)localObject1).field_username, (an)localObject1);
            break label803;
            label1014:
            i = 0;
            break label832;
            label1019:
            localbv.kt(0);
            if (localcv.nJb > 3)
            {
              i = localcv.nJb;
              break label848;
            }
            i = 3;
            break label848;
            bc.aCg();
            c.azI().b(localcv.xrk, localbv);
          }
        }
      }
    }
  }
  
  public final void b(e.c paramc)
  {
    AppMethodBeat.i(27726);
    q.aIX().M(paramc.dCi);
    AppMethodBeat.o(27726);
  }
  
  public static final class a
  {
    String content = "";
    String fXp = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.a.f
 * JD-Core Version:    0.7.0.1
 */