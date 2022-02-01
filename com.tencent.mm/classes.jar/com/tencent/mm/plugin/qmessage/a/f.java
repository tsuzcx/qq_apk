package com.tencent.mm.plugin.qmessage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.b;
import com.tencent.mm.an.h.c;
import com.tencent.mm.ay.q;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import java.util.Map;
import junit.framework.Assert;

public final class f
  implements h
{
  public final h.b b(h.a parama)
  {
    AppMethodBeat.i(27725);
    db localdb = parama.jQG;
    if (localdb == null)
    {
      Log.e("MicroMsg.QMsgExtension", "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(27725);
      return null;
    }
    if ((localdb.COi != 36) && (localdb.COi != 39))
    {
      Log.e("MicroMsg.QMsgExtension", "onPreAddMessage cmdAM.type:%d", new Object[] { Integer.valueOf(localdb.COi) });
      AppMethodBeat.o(27725);
      return null;
    }
    Object localObject2 = z.a(localdb.RIF);
    String str1 = z.a(localdb.RID);
    Object localObject1 = z.a(localdb.RIE);
    Log.d("MicroMsg.QMsgExtension", "parseQMsg content:".concat(String.valueOf(localObject2)));
    bh.beI();
    String str2 = (String)c.aHp().b(2, null);
    ca localca;
    if (str2.equals(str1))
    {
      bh.beI();
      localca = c.bbO().aL((String)localObject1, localdb.HlH);
      Log.d("MicroMsg.QMsgExtension", "dkmsgid parseQMsg svrid:%d localid:%d", new Object[] { Long.valueOf(localdb.HlH), Long.valueOf(localca.field_msgId) });
      if ((localca.field_msgId != 0L) && (localca.field_createTime + 604800000L < bq.z(str1, localdb.CreateTime)))
      {
        Log.w("MicroMsg.QMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", new Object[] { Long.valueOf(localdb.HlH), Long.valueOf(localca.field_msgId) });
        bq.Gk(localca.field_msgId);
        localca.setMsgId(0L);
      }
      if (localca.field_msgId != 0L) {
        break label1092;
      }
      localca = new ca();
      localca.EG(localdb.HlH);
      localca.setCreateTime(bq.z(str1, localdb.CreateTime));
    }
    label778:
    label804:
    label833:
    label1092:
    for (;;)
    {
      localca.setType(localdb.COi);
      localca.Jm((String)localObject1);
      Object localObject3 = g.fsa().aVb((String)localObject1);
      if ((localObject3 == null) || (Util.nullAsNil(((d)localObject3).getUsername()).length() <= 0))
      {
        localObject3 = new d();
        ((d)localObject3).username = ((String)localObject1);
        ((d)localObject3).Hkz = 1;
        ((d)localObject3).cUP = 9;
        if (!g.fsa().a((d)localObject3)) {
          Log.e("MicroMsg.QMsgExtension", "parseQMsg : insert QContact failed : username = " + ((d)localObject3).getUsername());
        }
      }
      long l2;
      if ((localdb.RIG == 2) && (localca.field_msgId == 0L))
      {
        localObject3 = z.a(localdb.RIH);
        PString localPString = new PString();
        PInt localPInt1 = new PInt();
        PInt localPInt2 = new PInt();
        l2 = q.bmh().a((String)localObject1, (byte[])localObject3, localdb.HlH, false, "", localPString, localPInt1, localPInt2);
        l1 = l2;
        if (l2 > 0L)
        {
          localca.Jn(localPString.value);
          localca.pW(localPInt1.value);
          localca.pX(localPInt2.value);
        }
      }
      for (long l1 = l2;; l1 = -1L)
      {
        boolean bool;
        label600:
        label622:
        int i;
        if (localdb.COi == 36)
        {
          Assert.assertTrue(true);
          if (Util.nullAsNil((String)localObject2).length() <= 0) {
            break label960;
          }
          bool = true;
          Assert.assertTrue(bool);
          if (Util.nullAsNil(localca.field_talker).length() <= 0) {
            break label966;
          }
          bool = true;
          Assert.assertTrue(bool);
          i = 0;
          bh.beI();
          localObject1 = c.bbL().RG(localca.field_talker);
          if ((localObject1 != null) && (Util.nullAsNil(((ax)localObject1).field_username).length() > 0)) {
            break label1082;
          }
          i = 1;
          localObject1 = new as(localca.field_talker);
        }
        for (;;)
        {
          localObject3 = new a((byte)0);
          localObject2 = XmlParser.parseXml((String)localObject2, "msg", null);
          if (localObject2 != null)
          {
            ((a)localObject3).jmB = ((String)((Map)localObject2).get(".msg.from.displayname"));
            ((a)localObject3).content = ((String)((Map)localObject2).get(".msg.content.t"));
          }
          if (((a)localObject3).jmB == null)
          {
            localObject2 = "";
            label758:
            ((as)localObject1).Ir((String)localObject2);
            if (((a)localObject3).content != null) {
              break label982;
            }
            localObject2 = "";
            localca.setContent((String)localObject2);
            if (i == 0) {
              break label992;
            }
            bh.beI();
            c.bbL().av((as)localObject1);
            bh.beI();
            if ((!c.bbU().has(str1)) && (!str2.equals(str1))) {
              break label1015;
            }
            i = 1;
            if (i == 0) {
              break label1020;
            }
            localca.pJ(1);
            i = localdb.rVU;
            label849:
            localca.setStatus(i);
            localca.Ip(localdb.RII);
            bq.a(localca, parama);
            if (localca.field_msgId != 0L) {
              break label1049;
            }
            localca.setMsgId(bq.z(localca));
            if (localdb.RIG == 2)
            {
              parama = q.bmh().b(Long.valueOf(l1));
              parama.GE((int)localca.field_msgId);
              q.bmh().a(Long.valueOf(l1), parama);
            }
          }
          for (parama = new h.b(localca, true);; parama = new h.b(localca, false))
          {
            AppMethodBeat.o(27725);
            return parama;
            localObject1 = str1;
            break;
            bool = false;
            break label600;
            label966:
            bool = false;
            break label622;
            localObject2 = ((a)localObject3).jmB;
            break label758;
            label982:
            localObject2 = ((a)localObject3).content;
            break label778;
            label992:
            bh.beI();
            c.bbL().c(((ax)localObject1).field_username, (as)localObject1);
            break label804;
            label1015:
            i = 0;
            break label833;
            label1020:
            localca.pJ(0);
            if (localdb.rVU > 3)
            {
              i = localdb.rVU;
              break label849;
            }
            i = 3;
            break label849;
            bh.beI();
            c.bbO().b(localdb.HlH, localca);
          }
        }
      }
    }
  }
  
  public final void b(h.c paramc)
  {
    AppMethodBeat.i(27726);
    q.bmh().ab(paramc.fNz);
    AppMethodBeat.o(27726);
  }
  
  public static final class a
  {
    String content = "";
    String jmB = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.a.f
 * JD-Core Version:    0.7.0.1
 */