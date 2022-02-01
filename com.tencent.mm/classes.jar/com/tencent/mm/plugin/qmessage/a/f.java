package com.tencent.mm.plugin.qmessage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.b;
import com.tencent.mm.al.f.c;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import java.util.Map;
import junit.framework.Assert;

public final class f
  implements com.tencent.mm.al.f
{
  public final f.b b(com.tencent.mm.al.f.a parama)
  {
    AppMethodBeat.i(27725);
    cs localcs = parama.fTo;
    if (localcs == null)
    {
      ad.e("MicroMsg.QMsgExtension", "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(27725);
      return null;
    }
    if ((localcs.saz != 36) && (localcs.saz != 39))
    {
      ad.e("MicroMsg.QMsgExtension", "onPreAddMessage cmdAM.type:%d", new Object[] { Integer.valueOf(localcs.saz) });
      AppMethodBeat.o(27725);
      return null;
    }
    Object localObject2 = z.a(localcs.Cxz);
    String str1 = z.a(localcs.Cxx);
    Object localObject1 = z.a(localcs.Cxy);
    ad.d("MicroMsg.QMsgExtension", "parseQMsg content:".concat(String.valueOf(localObject2)));
    az.arV();
    String str2 = (String)c.afk().get(2, null);
    bl localbl;
    if (str2.equals(str1))
    {
      az.arV();
      localbl = c.apO().aD((String)localObject1, localcs.uKZ);
      ad.d("MicroMsg.QMsgExtension", "dkmsgid parseQMsg svrid:%d localid:%d", new Object[] { Long.valueOf(localcs.uKZ), Long.valueOf(localbl.field_msgId) });
      if ((localbl.field_msgId != 0L) && (localbl.field_createTime + 604800000L < bi.y(str1, localcs.CreateTime)))
      {
        ad.w("MicroMsg.QMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", new Object[] { Long.valueOf(localcs.uKZ), Long.valueOf(localbl.field_msgId) });
        bi.lW(localbl.field_msgId);
        localbl.setMsgId(0L);
      }
      if (localbl.field_msgId != 0L) {
        break label1093;
      }
      localbl = new bl();
      localbl.kX(localcs.uKZ);
      localbl.kY(bi.y(str1, localcs.CreateTime));
    }
    label786:
    label812:
    label1090:
    label1093:
    for (;;)
    {
      localbl.setType(localcs.saz);
      localbl.nY((String)localObject1);
      Object localObject3 = g.ddJ().akO((String)localObject1);
      if ((localObject3 == null) || (bt.nullAsNil(((d)localObject3).getUsername()).length() <= 0))
      {
        localObject3 = new d();
        ((d)localObject3).username = ((String)localObject1);
        ((d)localObject3).uKc = 1;
        ((d)localObject3).dtM = 9;
        if (!g.ddJ().a((d)localObject3)) {
          ad.e("MicroMsg.QMsgExtension", "parseQMsg : insert QContact failed : username = " + ((d)localObject3).getUsername());
        }
      }
      long l2 = -1L;
      long l1 = l2;
      if (localcs.CxA == 2)
      {
        l1 = l2;
        if (localbl.field_msgId == 0L)
        {
          localObject1 = z.a(localcs.CxB);
          localObject3 = new PString();
          PInt localPInt1 = new PInt();
          PInt localPInt2 = new PInt();
          l2 = o.ayF().a((byte[])localObject1, localcs.uKZ, false, "", (PString)localObject3, localPInt1, localPInt2);
          l1 = l2;
          if (l2 > 0L)
          {
            localbl.nZ(((PString)localObject3).value);
            localbl.kh(localPInt1.value);
            localbl.ki(localPInt2.value);
            l1 = l2;
          }
        }
      }
      boolean bool;
      label609:
      label631:
      int i;
      if (localcs.saz == 36)
      {
        Assert.assertTrue(true);
        if (bt.nullAsNil((String)localObject2).length() <= 0) {
          break label968;
        }
        bool = true;
        Assert.assertTrue(bool);
        if (bt.nullAsNil(localbl.field_talker).length() <= 0) {
          break label974;
        }
        bool = true;
        Assert.assertTrue(bool);
        i = 0;
        az.arV();
        localObject1 = c.apM().aHY(localbl.field_talker);
        if ((localObject1 != null) && (bt.nullAsNil(((au)localObject1).field_username).length() > 0)) {
          break label1090;
        }
        i = 1;
        localObject1 = new af(localbl.field_talker);
      }
      for (;;)
      {
        localObject3 = new a((byte)0);
        localObject2 = bw.K((String)localObject2, "msg");
        if (localObject2 != null)
        {
          ((a)localObject3).fyo = ((String)((Map)localObject2).get(".msg.from.displayname"));
          ((a)localObject3).content = ((String)((Map)localObject2).get(".msg.content.t"));
        }
        if (((a)localObject3).fyo == null)
        {
          localObject2 = "";
          label766:
          ((af)localObject1).nb((String)localObject2);
          if (((a)localObject3).content != null) {
            break label990;
          }
          localObject2 = "";
          localbl.setContent((String)localObject2);
          if (i == 0) {
            break label1000;
          }
          az.arV();
          c.apM().af((af)localObject1);
          az.arV();
          if ((!c.apU().has(str1)) && (!str2.equals(str1))) {
            break label1023;
          }
          i = 1;
          label841:
          if (i == 0) {
            break label1028;
          }
          localbl.jV(1);
          i = localcs.mBi;
          label857:
          localbl.setStatus(i);
          localbl.mZ(localcs.CxC);
          bi.a(localbl, parama);
          if (localbl.field_msgId != 0L) {
            break label1057;
          }
          localbl.setMsgId(bi.u(localbl));
          if (localcs.CxA == 2)
          {
            parama = o.ayF().b(Long.valueOf(l1));
            parama.mq((int)localbl.field_msgId);
            o.ayF().a(Long.valueOf(l1), parama);
          }
        }
        for (parama = new f.b(localbl, true);; parama = new f.b(localbl, false))
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
          localObject2 = ((a)localObject3).fyo;
          break label766;
          label990:
          localObject2 = ((a)localObject3).content;
          break label786;
          label1000:
          az.arV();
          c.apM().c(((au)localObject1).field_username, (af)localObject1);
          break label812;
          label1023:
          i = 0;
          break label841;
          localbl.jV(0);
          if (localcs.mBi > 3)
          {
            i = localcs.mBi;
            break label857;
          }
          i = 3;
          break label857;
          az.arV();
          c.apO().b(localcs.uKZ, localbl);
        }
      }
    }
  }
  
  public final void b(f.c paramc)
  {
    AppMethodBeat.i(27726);
    o.ayF().J(paramc.drF);
    AppMethodBeat.o(27726);
  }
  
  public static final class a
  {
    String content = "";
    String fyo = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.a.f
 * JD-Core Version:    0.7.0.1
 */