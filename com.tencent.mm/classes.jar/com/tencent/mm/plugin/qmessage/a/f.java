package com.tencent.mm.plugin.qmessage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.b;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.av.o;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
import java.util.Map;
import junit.framework.Assert;

public final class f
  implements com.tencent.mm.ak.f
{
  public final f.b b(com.tencent.mm.ak.f.a parama)
  {
    AppMethodBeat.i(27725);
    cu localcu = parama.fXi;
    if (localcu == null)
    {
      ac.e("MicroMsg.QMsgExtension", "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(27725);
      return null;
    }
    if ((localcu.tit != 36) && (localcu.tit != 39))
    {
      ac.e("MicroMsg.QMsgExtension", "onPreAddMessage cmdAM.type:%d", new Object[] { Integer.valueOf(localcu.tit) });
      AppMethodBeat.o(27725);
      return null;
    }
    Object localObject2 = z.a(localcu.DPV);
    String str1 = z.a(localcu.DPT);
    Object localObject1 = z.a(localcu.DPU);
    ac.d("MicroMsg.QMsgExtension", "parseQMsg content:".concat(String.valueOf(localObject2)));
    az.ayM();
    String str2 = (String)c.agA().get(2, null);
    bo localbo;
    if (str2.equals(str1))
    {
      az.ayM();
      localbo = c.awD().aF((String)localObject1, localcu.vTQ);
      ac.d("MicroMsg.QMsgExtension", "dkmsgid parseQMsg svrid:%d localid:%d", new Object[] { Long.valueOf(localcu.vTQ), Long.valueOf(localbo.field_msgId) });
      if ((localbo.field_msgId != 0L) && (localbo.field_createTime + 604800000L < bi.z(str1, localcu.CreateTime)))
      {
        ac.w("MicroMsg.QMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", new Object[] { Long.valueOf(localcu.vTQ), Long.valueOf(localbo.field_msgId) });
        bi.pK(localbo.field_msgId);
        localbo.setMsgId(0L);
      }
      if (localbo.field_msgId != 0L) {
        break label1093;
      }
      localbo = new bo();
      localbo.oz(localcu.vTQ);
      localbo.oA(bi.z(str1, localcu.CreateTime));
    }
    label786:
    label812:
    label1090:
    label1093:
    for (;;)
    {
      localbo.setType(localcu.tit);
      localbo.re((String)localObject1);
      Object localObject3 = g.drr().apN((String)localObject1);
      if ((localObject3 == null) || (bs.nullAsNil(((d)localObject3).getUsername()).length() <= 0))
      {
        localObject3 = new d();
        ((d)localObject3).username = ((String)localObject1);
        ((d)localObject3).vST = 1;
        ((d)localObject3).drx = 9;
        if (!g.drr().a((d)localObject3)) {
          ac.e("MicroMsg.QMsgExtension", "parseQMsg : insert QContact failed : username = " + ((d)localObject3).getUsername());
        }
      }
      long l2 = -1L;
      long l1 = l2;
      if (localcu.DPW == 2)
      {
        l1 = l2;
        if (localbo.field_msgId == 0L)
        {
          localObject1 = z.a(localcu.DPX);
          localObject3 = new PString();
          PInt localPInt1 = new PInt();
          PInt localPInt2 = new PInt();
          l2 = o.aFx().a((byte[])localObject1, localcu.vTQ, false, "", (PString)localObject3, localPInt1, localPInt2);
          l1 = l2;
          if (l2 > 0L)
          {
            localbo.rf(((PString)localObject3).value);
            localbo.ke(localPInt1.value);
            localbo.kf(localPInt2.value);
            l1 = l2;
          }
        }
      }
      boolean bool;
      label609:
      label631:
      int i;
      if (localcu.tit == 36)
      {
        Assert.assertTrue(true);
        if (bs.nullAsNil((String)localObject2).length() <= 0) {
          break label968;
        }
        bool = true;
        Assert.assertTrue(bool);
        if (bs.nullAsNil(localbo.field_talker).length() <= 0) {
          break label974;
        }
        bool = true;
        Assert.assertTrue(bool);
        i = 0;
        az.ayM();
        localObject1 = c.awB().aNt(localbo.field_talker);
        if ((localObject1 != null) && (bs.nullAsNil(((av)localObject1).field_username).length() > 0)) {
          break label1090;
        }
        i = 1;
        localObject1 = new ai(localbo.field_talker);
      }
      for (;;)
      {
        localObject3 = new a((byte)0);
        localObject2 = bv.L((String)localObject2, "msg");
        if (localObject2 != null)
        {
          ((a)localObject3).fBV = ((String)((Map)localObject2).get(".msg.from.displayname"));
          ((a)localObject3).content = ((String)((Map)localObject2).get(".msg.content.t"));
        }
        if (((a)localObject3).fBV == null)
        {
          localObject2 = "";
          label766:
          ((ai)localObject1).qh((String)localObject2);
          if (((a)localObject3).content != null) {
            break label990;
          }
          localObject2 = "";
          localbo.setContent((String)localObject2);
          if (i == 0) {
            break label1000;
          }
          az.ayM();
          c.awB().ag((ai)localObject1);
          az.ayM();
          if ((!c.awJ().has(str1)) && (!str2.equals(str1))) {
            break label1023;
          }
          i = 1;
          label841:
          if (i == 0) {
            break label1028;
          }
          localbo.jT(1);
          i = localcu.ndj;
          label857:
          localbo.setStatus(i);
          localbo.qf(localcu.DPY);
          bi.a(localbo, parama);
          if (localbo.field_msgId != 0L) {
            break label1057;
          }
          localbo.setMsgId(bi.u(localbo));
          if (localcu.DPW == 2)
          {
            parama = o.aFx().c(Long.valueOf(l1));
            parama.qe((int)localbo.field_msgId);
            o.aFx().a(Long.valueOf(l1), parama);
          }
        }
        for (parama = new f.b(localbo, true);; parama = new f.b(localbo, false))
        {
          AppMethodBeat.o(27725);
          return parama;
          localObject1 = str1;
          break;
          label968:
          bool = false;
          break label609;
          label974:
          bool = false;
          break label631;
          localObject2 = ((a)localObject3).fBV;
          break label766;
          label990:
          localObject2 = ((a)localObject3).content;
          break label786;
          label1000:
          az.ayM();
          c.awB().c(((av)localObject1).field_username, (ai)localObject1);
          break label812;
          label1023:
          i = 0;
          break label841;
          localbo.jT(0);
          if (localcu.ndj > 3)
          {
            i = localcu.ndj;
            break label857;
          }
          i = 3;
          break label857;
          az.ayM();
          c.awD().b(localcu.vTQ, localbo);
        }
      }
    }
  }
  
  public final void b(f.c paramc)
  {
    AppMethodBeat.i(27726);
    o.aFx().J(paramc.dpq);
    AppMethodBeat.o(27726);
  }
  
  public static final class a
  {
    String content = "";
    String fBV = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.a.f
 * JD-Core Version:    0.7.0.1
 */