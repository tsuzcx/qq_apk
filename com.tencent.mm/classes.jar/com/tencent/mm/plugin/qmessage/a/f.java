package com.tencent.mm.plugin.qmessage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.b;
import com.tencent.mm.al.e.c;
import com.tencent.mm.aw.q;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import java.util.Map;
import junit.framework.Assert;

public final class f
  implements com.tencent.mm.al.e
{
  public final e.b b(e.a parama)
  {
    AppMethodBeat.i(27725);
    cv localcv = parama.gqE;
    if (localcv == null)
    {
      ad.e("MicroMsg.QMsgExtension", "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(27725);
      return null;
    }
    if ((localcv.ugm != 36) && (localcv.ugm != 39))
    {
      ad.e("MicroMsg.QMsgExtension", "onPreAddMessage cmdAM.type:%d", new Object[] { Integer.valueOf(localcv.ugm) });
      AppMethodBeat.o(27725);
      return null;
    }
    Object localObject2 = z.a(localcv.Fvk);
    String str1 = z.a(localcv.Fvi);
    Object localObject1 = z.a(localcv.Fvj);
    ad.d("MicroMsg.QMsgExtension", "parseQMsg content:".concat(String.valueOf(localObject2)));
    ba.aBQ();
    String str2 = (String)c.ajl().get(2, null);
    bu localbu;
    if (str2.equals(str1))
    {
      ba.aBQ();
      localbu = c.azs().aI((String)localObject1, localcv.xbt);
      ad.d("MicroMsg.QMsgExtension", "dkmsgid parseQMsg svrid:%d localid:%d", new Object[] { Long.valueOf(localcv.xbt), Long.valueOf(localbu.field_msgId) });
      if ((localbu.field_msgId != 0L) && (localbu.field_createTime + 604800000L < bj.B(str1, localcv.CreateTime)))
      {
        ad.w("MicroMsg.QMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", new Object[] { Long.valueOf(localcv.xbt), Long.valueOf(localbu.field_msgId) });
        bj.rJ(localbu.field_msgId);
        localbu.setMsgId(0L);
      }
      if (localbu.field_msgId != 0L) {
        break label1091;
      }
      localbu = new bu();
      localbu.qz(localcv.xbt);
      localbu.qA(bj.B(str1, localcv.CreateTime));
    }
    label777:
    label803:
    label832:
    label1091:
    for (;;)
    {
      localbu.setType(localcv.ugm);
      localbu.tN((String)localObject1);
      Object localObject3 = g.dBT().auT((String)localObject1);
      if ((localObject3 == null) || (bt.nullAsNil(((d)localObject3).getUsername()).length() <= 0))
      {
        localObject3 = new d();
        ((d)localObject3).username = ((String)localObject1);
        ((d)localObject3).xad = 1;
        ((d)localObject3).dDp = 9;
        if (!g.dBT().a((d)localObject3)) {
          ad.e("MicroMsg.QMsgExtension", "parseQMsg : insert QContact failed : username = " + ((d)localObject3).getUsername());
        }
      }
      long l2;
      if ((localcv.Fvl == 2) && (localbu.field_msgId == 0L))
      {
        localObject3 = z.a(localcv.Fvm);
        PString localPString = new PString();
        PInt localPInt1 = new PInt();
        PInt localPInt2 = new PInt();
        l2 = q.aIF().a((String)localObject1, (byte[])localObject3, localcv.xbt, false, "", localPString, localPInt1, localPInt2);
        l1 = l2;
        if (l2 > 0L)
        {
          localbu.tO(localPString.value);
          localbu.kB(localPInt1.value);
          localbu.kC(localPInt2.value);
        }
      }
      for (long l1 = l2;; l1 = -1L)
      {
        boolean bool;
        label600:
        label622:
        int i;
        if (localcv.ugm == 36)
        {
          Assert.assertTrue(true);
          if (bt.nullAsNil((String)localObject2).length() <= 0) {
            break label959;
          }
          bool = true;
          Assert.assertTrue(bool);
          if (bt.nullAsNil(localbu.field_talker).length() <= 0) {
            break label965;
          }
          bool = true;
          Assert.assertTrue(bool);
          i = 0;
          ba.aBQ();
          localObject1 = c.azp().Bf(localbu.field_talker);
          if ((localObject1 != null) && (bt.nullAsNil(((aw)localObject1).field_username).length() > 0)) {
            break label1081;
          }
          i = 1;
          localObject1 = new am(localbu.field_talker);
        }
        for (;;)
        {
          localObject3 = new a((byte)0);
          localObject2 = bw.M((String)localObject2, "msg");
          if (localObject2 != null)
          {
            ((a)localObject3).fVj = ((String)((Map)localObject2).get(".msg.from.displayname"));
            ((a)localObject3).content = ((String)((Map)localObject2).get(".msg.content.t"));
          }
          if (((a)localObject3).fVj == null)
          {
            localObject2 = "";
            label757:
            ((am)localObject1).sR((String)localObject2);
            if (((a)localObject3).content != null) {
              break label981;
            }
            localObject2 = "";
            localbu.setContent((String)localObject2);
            if (i == 0) {
              break label991;
            }
            ba.aBQ();
            c.azp().ag((am)localObject1);
            ba.aBQ();
            if ((!c.azy().has(str1)) && (!str2.equals(str1))) {
              break label1014;
            }
            i = 1;
            if (i == 0) {
              break label1019;
            }
            localbu.kr(1);
            i = localcv.nDG;
            label848:
            localbu.setStatus(i);
            localbu.sP(localcv.Fvn);
            bj.a(localbu, parama);
            if (localbu.field_msgId != 0L) {
              break label1048;
            }
            localbu.setMsgId(bj.v(localbu));
            if (localcv.Fvl == 2)
            {
              parama = q.aIF().c(Long.valueOf(l1));
              parama.sd((int)localbu.field_msgId);
              q.aIF().a(Long.valueOf(l1), parama);
            }
          }
          for (parama = new e.b(localbu, true);; parama = new e.b(localbu, false))
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
            localObject2 = ((a)localObject3).fVj;
            break label757;
            label981:
            localObject2 = ((a)localObject3).content;
            break label777;
            label991:
            ba.aBQ();
            c.azp().c(((aw)localObject1).field_username, (am)localObject1);
            break label803;
            label1014:
            i = 0;
            break label832;
            label1019:
            localbu.kr(0);
            if (localcv.nDG > 3)
            {
              i = localcv.nDG;
              break label848;
            }
            i = 3;
            break label848;
            ba.aBQ();
            c.azs().b(localcv.xbt, localbu);
          }
        }
      }
    }
  }
  
  public final void b(e.c paramc)
  {
    AppMethodBeat.i(27726);
    q.aIF().M(paramc.dBd);
    AppMethodBeat.o(27726);
  }
  
  public static final class a
  {
    String content = "";
    String fVj = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.a.f
 * JD-Core Version:    0.7.0.1
 */