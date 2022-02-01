package com.tencent.mm.plugin.qmessage.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.b;
import com.tencent.mm.am.g.c;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.modelimage.h;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import java.util.Map;
import junit.framework.Assert;

public final class e
  implements g
{
  public final g.b b(g.a parama)
  {
    AppMethodBeat.i(27725);
    dl localdl = parama.mpN;
    if (localdl == null)
    {
      Log.e("MicroMsg.QMsgExtension", "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(27725);
      return null;
    }
    if ((localdl.IIs != 36) && (localdl.IIs != 39))
    {
      Log.e("MicroMsg.QMsgExtension", "onPreAddMessage cmdAM.type:%d", new Object[] { Integer.valueOf(localdl.IIs) });
      AppMethodBeat.o(27725);
      return null;
    }
    Object localObject2 = w.a(localdl.YFG);
    String str1 = w.a(localdl.YFE);
    Object localObject1 = w.a(localdl.YFF);
    Log.d("MicroMsg.QMsgExtension", "parseQMsg content:".concat(String.valueOf(localObject2)));
    bh.bCz();
    String str2 = (String)com.tencent.mm.model.c.ban().d(2, null);
    cc localcc;
    if (str2.equals(str1))
    {
      bh.bCz();
      localcc = com.tencent.mm.model.c.bzD().aU((String)localObject1, localdl.Njv);
      Log.d("MicroMsg.QMsgExtension", "dkmsgid parseQMsg svrid:%d localid:%d", new Object[] { Long.valueOf(localdl.Njv), Long.valueOf(localcc.field_msgId) });
      if ((localcc.field_msgId != 0L) && (localcc.getCreateTime() + 604800000L < br.D(str1, localdl.CreateTime)))
      {
        Log.w("MicroMsg.QMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", new Object[] { Long.valueOf(localdl.Njv), Long.valueOf(localcc.field_msgId) });
        br.iu(localcc.field_msgId);
        localcc.setMsgId(0L);
      }
      if (localcc.field_msgId != 0L) {
        break label1107;
      }
      localcc = new cc();
      localcc.gX(localdl.Njv);
      localcc.setCreateTime(br.D(str1, localdl.CreateTime));
    }
    label590:
    label975:
    label1107:
    for (;;)
    {
      localcc.setType(localdl.IIs);
      localcc.BS((String)localObject1);
      Object localObject3 = f.gDI().aSj((String)localObject1);
      if ((localObject3 == null) || (Util.nullAsNil(((c)localObject3).getUsername()).length() <= 0))
      {
        localObject3 = new c();
        ((c)localObject3).username = ((String)localObject1);
        ((c)localObject3).Nim = 1;
        ((c)localObject3).eQp = 9;
        if (!f.gDI().a((c)localObject3)) {
          Log.e("MicroMsg.QMsgExtension", "parseQMsg : insert QContact failed : username = " + ((c)localObject3).getUsername());
        }
      }
      long l2;
      if ((localdl.YFH == 2) && (localcc.field_msgId == 0L))
      {
        localObject3 = w.a(localdl.YFI);
        PString localPString = new PString();
        PInt localPInt1 = new PInt();
        PInt localPInt2 = new PInt();
        l2 = r.bKa().a((String)localObject1, (byte[])localObject3, localdl.Njv, false, "", localPString, localPInt1, localPInt2);
        l1 = l2;
        if (l2 > 0L)
        {
          localcc.BT(localPString.value);
          localcc.pW(localPInt1.value);
          localcc.pX(localPInt2.value);
        }
      }
      for (long l1 = l2;; l1 = -1L)
      {
        boolean bool;
        label609:
        label631:
        int i;
        if (localdl.IIs == 36)
        {
          if (localcc == null) {
            break label969;
          }
          bool = true;
          Assert.assertTrue(bool);
          if (Util.nullAsNil((String)localObject2).length() <= 0) {
            break label975;
          }
          bool = true;
          Assert.assertTrue(bool);
          if (Util.nullAsNil(localcc.field_talker).length() <= 0) {
            break label981;
          }
          bool = true;
          Assert.assertTrue(bool);
          i = 0;
          bh.bCz();
          localObject1 = com.tencent.mm.model.c.bzA().JE(localcc.field_talker);
          if ((localObject1 != null) && (Util.nullAsNil(((az)localObject1).field_username).length() > 0)) {
            break label1097;
          }
          i = 1;
          localObject1 = new au(localcc.field_talker);
        }
        for (;;)
        {
          localObject3 = new a((byte)0);
          localObject2 = XmlParser.parseXml((String)localObject2, "msg", null);
          if (localObject2 != null)
          {
            ((a)localObject3).displayName = ((String)((Map)localObject2).get(".msg.from.displayname"));
            ((a)localObject3).content = ((String)((Map)localObject2).get(".msg.content.t"));
          }
          if (((a)localObject3).displayName == null)
          {
            localObject2 = "";
            label767:
            ((au)localObject1).AW((String)localObject2);
            if (((a)localObject3).content != null) {
              break label997;
            }
            localObject2 = "";
            localcc.setContent((String)localObject2);
            if (i == 0) {
              break label1007;
            }
            bh.bCz();
            com.tencent.mm.model.c.bzA().aB((au)localObject1);
            bh.bCz();
            if ((!com.tencent.mm.model.c.bzJ().has(str1)) && (!str2.equals(str1))) {
              break label1030;
            }
            i = 1;
            if (i == 0) {
              break label1035;
            }
            localcc.pI(1);
            i = localdl.vhk;
            label858:
            localcc.setStatus(i);
            localcc.AU(localdl.YFJ);
            br.a(localcc, parama);
            if (localcc.field_msgId != 0L) {
              break label1064;
            }
            localcc.setMsgId(br.B(localcc));
            if (localdl.YFH == 2)
            {
              parama = r.bKa().b(Long.valueOf(l1));
              parama.iP((int)localcc.field_msgId);
              r.bKa().a(Long.valueOf(l1), parama);
            }
          }
          for (parama = new g.b(localcc, true);; parama = new g.b(localcc, false))
          {
            AppMethodBeat.o(27725);
            return parama;
            localObject1 = str1;
            break;
            bool = false;
            break label590;
            bool = false;
            break label609;
            label981:
            bool = false;
            break label631;
            localObject2 = ((a)localObject3).displayName;
            break label767;
            label997:
            localObject2 = ((a)localObject3).content;
            break label787;
            label1007:
            bh.bCz();
            com.tencent.mm.model.c.bzA().d(((az)localObject1).field_username, (au)localObject1);
            break label813;
            i = 0;
            break label842;
            localcc.pI(0);
            if (localdl.vhk > 3)
            {
              i = localdl.vhk;
              break label858;
            }
            i = 3;
            break label858;
            bh.bCz();
            com.tencent.mm.model.c.bzD().b(localdl.Njv, localcc);
          }
        }
      }
    }
  }
  
  public final void b(g.c paramc)
  {
    AppMethodBeat.i(27726);
    r.bKa().ag(paramc.hTm);
    AppMethodBeat.o(27726);
  }
  
  public static final class a
  {
    String content = "";
    String displayName = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.model.e
 * JD-Core Version:    0.7.0.1
 */