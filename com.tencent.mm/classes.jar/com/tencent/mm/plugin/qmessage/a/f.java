package com.tencent.mm.plugin.qmessage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.av.q;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.de;
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
    de localde = parama.heO;
    if (localde == null)
    {
      Log.e("MicroMsg.QMsgExtension", "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(27725);
      return null;
    }
    if ((localde.xKb != 36) && (localde.xKb != 39))
    {
      Log.e("MicroMsg.QMsgExtension", "onPreAddMessage cmdAM.type:%d", new Object[] { Integer.valueOf(localde.xKb) });
      AppMethodBeat.o(27725);
      return null;
    }
    Object localObject2 = z.a(localde.KHn);
    String str1 = z.a(localde.KHl);
    Object localObject1 = z.a(localde.KHm);
    Log.d("MicroMsg.QMsgExtension", "parseQMsg content:".concat(String.valueOf(localObject2)));
    bg.aVF();
    String str2 = (String)c.azQ().get(2, null);
    ca localca;
    if (str2.equals(str1))
    {
      bg.aVF();
      localca = c.aSQ().aJ((String)localObject1, localde.Brn);
      Log.d("MicroMsg.QMsgExtension", "dkmsgid parseQMsg svrid:%d localid:%d", new Object[] { Long.valueOf(localde.Brn), Long.valueOf(localca.field_msgId) });
      if ((localca.field_msgId != 0L) && (localca.field_createTime + 604800000L < bp.C(str1, localde.CreateTime)))
      {
        Log.w("MicroMsg.QMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", new Object[] { Long.valueOf(localde.Brn), Long.valueOf(localca.field_msgId) });
        bp.Ad(localca.field_msgId);
        localca.setMsgId(0L);
      }
      if (localca.field_msgId != 0L) {
        break label1092;
      }
      localca = new ca();
      localca.yF(localde.Brn);
      localca.setCreateTime(bp.C(str1, localde.CreateTime));
    }
    label778:
    label804:
    label833:
    label1092:
    for (;;)
    {
      localca.setType(localde.xKb);
      localca.Cy((String)localObject1);
      Object localObject3 = g.eFZ().aKB((String)localObject1);
      if ((localObject3 == null) || (Util.nullAsNil(((d)localObject3).getUsername()).length() <= 0))
      {
        localObject3 = new d();
        ((d)localObject3).username = ((String)localObject1);
        ((d)localObject3).Bqg = 1;
        ((d)localObject3).cSx = 9;
        if (!g.eFZ().a((d)localObject3)) {
          Log.e("MicroMsg.QMsgExtension", "parseQMsg : insert QContact failed : username = " + ((d)localObject3).getUsername());
        }
      }
      long l2;
      if ((localde.KHo == 2) && (localca.field_msgId == 0L))
      {
        localObject3 = z.a(localde.KHp);
        PString localPString = new PString();
        PInt localPInt1 = new PInt();
        PInt localPInt2 = new PInt();
        l2 = q.bcR().a((String)localObject1, (byte[])localObject3, localde.Brn, false, "", localPString, localPInt1, localPInt2);
        l1 = l2;
        if (l2 > 0L)
        {
          localca.Cz(localPString.value);
          localca.nG(localPInt1.value);
          localca.nH(localPInt2.value);
        }
      }
      for (long l1 = l2;; l1 = -1L)
      {
        boolean bool;
        label600:
        label622:
        int i;
        if (localde.xKb == 36)
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
          bg.aVF();
          localObject1 = c.aSN().Kn(localca.field_talker);
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
            ((a)localObject3).gCv = ((String)((Map)localObject2).get(".msg.from.displayname"));
            ((a)localObject3).content = ((String)((Map)localObject2).get(".msg.content.t"));
          }
          if (((a)localObject3).gCv == null)
          {
            localObject2 = "";
            label758:
            ((as)localObject1).BD((String)localObject2);
            if (((a)localObject3).content != null) {
              break label982;
            }
            localObject2 = "";
            localca.setContent((String)localObject2);
            if (i == 0) {
              break label992;
            }
            bg.aVF();
            c.aSN().ap((as)localObject1);
            bg.aVF();
            if ((!c.aSW().has(str1)) && (!str2.equals(str1))) {
              break label1015;
            }
            i = 1;
            if (i == 0) {
              break label1020;
            }
            localca.nv(1);
            i = localde.oTW;
            label849:
            localca.setStatus(i);
            localca.BB(localde.KHq);
            bp.a(localca, parama);
            if (localca.field_msgId != 0L) {
              break label1049;
            }
            localca.setMsgId(bp.x(localca));
            if (localde.KHo == 2)
            {
              parama = q.bcR().c(Long.valueOf(l1));
              parama.Aw((int)localca.field_msgId);
              q.bcR().a(Long.valueOf(l1), parama);
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
            localObject2 = ((a)localObject3).gCv;
            break label758;
            label982:
            localObject2 = ((a)localObject3).content;
            break label778;
            label992:
            bg.aVF();
            c.aSN().c(((ax)localObject1).field_username, (as)localObject1);
            break label804;
            label1015:
            i = 0;
            break label833;
            label1020:
            localca.nv(0);
            if (localde.oTW > 3)
            {
              i = localde.oTW;
              break label849;
            }
            i = 3;
            break label849;
            bg.aVF();
            c.aSQ().b(localde.Brn, localca);
          }
        }
      }
    }
  }
  
  public final void b(h.c paramc)
  {
    AppMethodBeat.i(27726);
    q.bcR().V(paramc.dTX);
    AppMethodBeat.o(27726);
  }
  
  public static final class a
  {
    String content = "";
    String gCv = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.a.f
 * JD-Core Version:    0.7.0.1
 */