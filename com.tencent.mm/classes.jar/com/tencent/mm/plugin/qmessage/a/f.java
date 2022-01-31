package com.tencent.mm.plugin.qmessage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.ai.e.c;
import com.tencent.mm.at.o;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.util.Map;
import junit.framework.Assert;

public final class f
  implements com.tencent.mm.ai.e
{
  public final void a(e.c paramc)
  {
    AppMethodBeat.i(24086);
    o.ahC().x(paramc.cEE);
    AppMethodBeat.o(24086);
  }
  
  public final e.b b(e.a parama)
  {
    AppMethodBeat.i(24085);
    cm localcm = parama.eyJ;
    if (localcm == null)
    {
      ab.e("MicroMsg.QMsgExtension", "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(24085);
      return null;
    }
    if ((localcm.nqW != 36) && (localcm.nqW != 39))
    {
      ab.e("MicroMsg.QMsgExtension", "onPreAddMessage cmdAM.type:%d", new Object[] { Integer.valueOf(localcm.nqW) });
      AppMethodBeat.o(24085);
      return null;
    }
    Object localObject2 = aa.a(localcm.woR);
    String str1 = aa.a(localcm.woP);
    Object localObject1 = aa.a(localcm.woQ);
    ab.d("MicroMsg.QMsgExtension", "parseQMsg content:".concat(String.valueOf(localObject2)));
    aw.aaz();
    String str2 = (String)c.Ru().get(2, null);
    bi localbi;
    if (str2.equals(str1))
    {
      aw.aaz();
      localbi = c.YC().ag((String)localObject1, localcm.pIG);
      ab.d("MicroMsg.QMsgExtension", "dkmsgid parseQMsg svrid:%d localid:%d", new Object[] { Long.valueOf(localcm.pIG), Long.valueOf(localbi.field_msgId) });
      if ((localbi.field_msgId != 0L) && (localbi.field_createTime + 604800000L < bf.x(str1, localcm.CreateTime)))
      {
        ab.w("MicroMsg.QMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", new Object[] { Long.valueOf(localcm.pIG), Long.valueOf(localbi.field_msgId) });
        bf.gw(localbi.field_msgId);
        localbi.setMsgId(0L);
      }
      if (localbi.field_msgId != 0L) {
        break label1093;
      }
      localbi = new bi();
      localbi.fP(localcm.pIG);
      localbi.fQ(bf.x(str1, localcm.CreateTime));
    }
    label786:
    label812:
    label1090:
    label1093:
    for (;;)
    {
      localbi.setType(localcm.nqW);
      localbi.kj((String)localObject1);
      Object localObject3 = g.cdr().Xl((String)localObject1);
      if ((localObject3 == null) || (bo.nullAsNil(((d)localObject3).getUsername()).length() <= 0))
      {
        localObject3 = new d();
        ((d)localObject3).username = ((String)localObject1);
        ((d)localObject3).pHM = 1;
        ((d)localObject3).bsY = 9;
        if (!g.cdr().a((d)localObject3)) {
          ab.e("MicroMsg.QMsgExtension", "parseQMsg : insert QContact failed : username = " + ((d)localObject3).getUsername());
        }
      }
      long l2 = -1L;
      long l1 = l2;
      if (localcm.woS == 2)
      {
        l1 = l2;
        if (localbi.field_msgId == 0L)
        {
          localObject1 = aa.a(localcm.woT);
          localObject3 = new PString();
          PInt localPInt1 = new PInt();
          PInt localPInt2 = new PInt();
          l2 = o.ahC().a((byte[])localObject1, localcm.pIG, false, "", (PString)localObject3, localPInt1, localPInt2);
          l1 = l2;
          if (l2 > 0L)
          {
            localbi.kk(((PString)localObject3).value);
            localbi.hW(localPInt1.value);
            localbi.hX(localPInt2.value);
            l1 = l2;
          }
        }
      }
      boolean bool;
      label609:
      label631:
      int i;
      if (localcm.nqW == 36)
      {
        Assert.assertTrue(true);
        if (bo.nullAsNil((String)localObject2).length() <= 0) {
          break label968;
        }
        bool = true;
        Assert.assertTrue(bool);
        if (bo.nullAsNil(localbi.field_talker).length() <= 0) {
          break label974;
        }
        bool = true;
        Assert.assertTrue(bool);
        i = 0;
        aw.aaz();
        localObject1 = c.YA().arw(localbi.field_talker);
        if ((localObject1 != null) && (bo.nullAsNil(((aq)localObject1).field_username).length() > 0)) {
          break label1090;
        }
        i = 1;
        localObject1 = new ad(localbi.field_talker);
      }
      for (;;)
      {
        localObject3 = new f.a((byte)0);
        localObject2 = br.F((String)localObject2, "msg");
        if (localObject2 != null)
        {
          ((f.a)localObject3).elx = ((String)((Map)localObject2).get(".msg.from.displayname"));
          ((f.a)localObject3).content = ((String)((Map)localObject2).get(".msg.content.t"));
        }
        if (((f.a)localObject3).elx == null)
        {
          localObject2 = "";
          label766:
          ((ad)localObject1).jn((String)localObject2);
          if (((f.a)localObject3).content != null) {
            break label990;
          }
          localObject2 = "";
          localbi.setContent((String)localObject2);
          if (i == 0) {
            break label1000;
          }
          aw.aaz();
          c.YA().Y((ad)localObject1);
          aw.aaz();
          if ((!c.YI().has(str1)) && (!str2.equals(str1))) {
            break label1023;
          }
          i = 1;
          label841:
          if (i == 0) {
            break label1028;
          }
          localbi.hL(1);
          i = localcm.jJS;
          label857:
          localbi.setStatus(i);
          localbi.jl(localcm.woU);
          bf.a(localbi, parama);
          if (localbi.field_msgId != 0L) {
            break label1057;
          }
          localbi.setMsgId(bf.l(localbi));
          if (localcm.woS == 2)
          {
            parama = o.ahC().b(Long.valueOf(l1));
            parama.gQ((int)localbi.field_msgId);
            o.ahC().a(Long.valueOf(l1), parama);
          }
        }
        for (parama = new e.b(localbi, true);; parama = new e.b(localbi, false))
        {
          AppMethodBeat.o(24085);
          return parama;
          localObject1 = str1;
          break;
          label968:
          bool = false;
          break label609;
          label974:
          bool = false;
          break label631;
          localObject2 = ((f.a)localObject3).elx;
          break label766;
          label990:
          localObject2 = ((f.a)localObject3).content;
          break label786;
          label1000:
          aw.aaz();
          c.YA().b(((aq)localObject1).field_username, (ad)localObject1);
          break label812;
          label1023:
          i = 0;
          break label841;
          localbi.hL(0);
          if (localcm.jJS > 3)
          {
            i = localcm.jJS;
            break label857;
          }
          i = 3;
          break label857;
          aw.aaz();
          c.YC().b(localcm.pIG, localbi);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.a.f
 * JD-Core Version:    0.7.0.1
 */