package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.ai.e.c;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.f;
import com.tencent.mm.model.bf;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.voip.b;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.util.Map;

public final class o
  implements com.tencent.mm.ai.e
{
  public final void a(e.c paramc) {}
  
  public final e.b b(e.a parama)
  {
    AppMethodBeat.i(4456);
    cm localcm = parama.eyJ;
    String str1 = aa.a(localcm.woP);
    Object localObject1 = aa.a(localcm.woQ);
    String str2 = aa.a(localcm.woR);
    ab.d("MicroMsg.VoipExtension", "voip msg, from: %s, content: %s", new Object[] { str1, str2 });
    Object localObject2 = ((j)g.E(j.class)).bPQ();
    Object localObject3 = (String)g.RL().Ru().get(2, "");
    if (((String)localObject3).length() <= 0)
    {
      AppMethodBeat.o(4456);
      return null;
    }
    if (((String)localObject3).equals(str1)) {}
    for (;;)
    {
      localObject1 = ((h)localObject2).ag((String)localObject1, localcm.pIG);
      if (((dd)localObject1).field_msgId == 0L)
      {
        localObject1 = new bi();
        ((bi)localObject1).fP(localcm.pIG);
        ((bi)localObject1).fQ(bf.x(str1, localcm.CreateTime));
      }
      for (;;)
      {
        b.cLC();
        localObject3 = t.aeF(str2);
        int i;
        if (localObject3 == null)
        {
          ab.e("MicroMsg.VoipExtension", "parse voip message failed, voipMessage is null!");
          try
          {
            localObject1 = br.F(str2, "voipwarnmsg");
            if ((localObject1 != null) && (((Map)localObject1).get(".voipwarnmsg.type") != null) && (bo.getInt((String)((Map)localObject1).get(".voipwarnmsg.type"), 0) == 1))
            {
              parama = (String)((Map)localObject1).get(".voipwarnmsg.warntips");
              if ((parama != null) && (!parama.equals("")))
              {
                ab.i("MicroMsg.VoipExtension", "got risk tips back:".concat(String.valueOf(parama)));
                if (((Map)localObject1).get(".voipwarnmsg.roomid") != null)
                {
                  if (f.Mz()) {
                    break label343;
                  }
                  ab.i("MicroMsg.VoipExtension", "set voipmsg not notification...");
                }
                label343:
                while (bo.getInt((String)((Map)localObject1).get(".voipwarnmsg.roomid"), 0) == b.cLC().tyR.ttm.tvj.nMZ)
                {
                  b.cLC().txI = parama;
                  localObject1 = b.cLC();
                  i = 0;
                  while (i < 2)
                  {
                    al.p(new t.4((t)localObject1, parama), 1000L);
                    i += 1;
                  }
                }
                ab.i("MicroMsg.VoipExtension", "wrong roomid,now return..");
                AppMethodBeat.o(4456);
                return null;
              }
            }
          }
          catch (Exception parama)
          {
            ab.printErrStackTrace("MicroMsg.VoipExtension", parama, "", new Object[0]);
            ab.e("MicroMsg.VoipExtension", "parse voip message error: %s", new Object[] { parama.getMessage() });
            AppMethodBeat.o(4456);
            return null;
          }
        }
        Object localObject4;
        if (((o.a)localObject3).status == o.a.twT)
        {
          i = 1;
          if (i == 0) {
            break label633;
          }
          ab.i("MicroMsg.VoipExtension", "recv voip cancel message");
          localObject4 = b.cLC();
          if ((str2 != null) && (str2.length() != 0)) {
            break label508;
          }
        }
        for (;;)
        {
          if (((o.a)localObject3).twP == b.cLC().tyX)
          {
            ab.i("MicroMsg.VoipExtension", "already ignore the invite, don't add the message to db");
            AppMethodBeat.o(4456);
            return null;
            i = 0;
            break;
            label508:
            localObject2 = new o.a();
            if ((((o.a)localObject2).parse(str2)) && (((o.a)localObject2).status == 2))
            {
              b.cLC().cNT();
              ((t)localObject4).Hy(((o.a)localObject2).twP);
              localObject4 = ((t)localObject4).tyR;
              ab.i("MicroMsg.Voip.VoipServiceEx", "onCancelInviteMessage, roomId: " + ((o.a)localObject2).twP);
              if ((((u)localObject4).ttm.tvo != null) && (((o.a)localObject2).twP == ((u)localObject4).ttm.tvo.wQP))
              {
                ((u)localObject4).cOj();
                ((u)localObject4).ttm.shutdown();
                continue;
                label633:
                if (((o.a)localObject3).status == o.a.twV) {}
                for (i = 1; i != 0; i = 0)
                {
                  AppMethodBeat.o(4456);
                  return null;
                }
                if (((o.a)localObject3).status == o.a.twS) {}
                for (i = 1; i != 0; i = 0)
                {
                  ab.i("MicroMsg.VoipExtension", "recv voip invite delay");
                  b.cLC().ah(((o.a)localObject3).twP, ((o.a)localObject3).twQ);
                  AppMethodBeat.o(4456);
                  return null;
                }
                if (((o.a)localObject3).cMz())
                {
                  ab.i("MicroMsg.VoipExtension", "receive invite busy message");
                  ((bi)localObject1).fP(0L);
                }
                else
                {
                  AppMethodBeat.o(4456);
                  return null;
                }
              }
            }
          }
        }
        ((bi)localObject1).setType(localcm.nqW);
        if (((o.a)localObject3).cMy())
        {
          localObject2 = bi.yOc;
          ((bi)localObject1).setContent((String)localObject2);
          ((bi)localObject1).hL(0);
          ((bi)localObject1).kj(str1);
          if (localcm.jJS <= 3) {
            break label983;
          }
          i = localcm.jJS;
          label803:
          ((bi)localObject1).setStatus(i);
          if (!((o.a)localObject3).cMz()) {
            break label988;
          }
          ((bi)localObject1).jl(ah.getContext().getString(2131304617));
          label829:
          bf.a((bi)localObject1, parama);
          ab.d("MicroMsg.VoipExtension", "voipMessage==null: %b", new Object[] { localObject3 });
          if (((dd)localObject1).field_msgId != 0L) {
            break label1042;
          }
          if (localObject3 != null) {
            break label1079;
          }
          parama = new o.a();
          parama.parse(str2);
        }
        for (;;)
        {
          ab.d("MicroMsg.VoipExtension", "add or update msg, roomid: %s", new Object[] { Integer.valueOf(parama.twP) });
          if (b.cLC().tyW.get(Integer.valueOf(parama.twP)) == null)
          {
            ((bi)localObject1).setMsgId(bf.l((bi)localObject1));
            b.cLC().tyW.put(Integer.valueOf(parama.twP), Long.valueOf(((dd)localObject1).field_msgId));
          }
          label957:
          for (parama = new e.b((bi)localObject1, true);; parama = new e.b((bi)localObject1, false))
          {
            AppMethodBeat.o(4456);
            return parama;
            localObject2 = bi.yOb;
            break;
            label983:
            i = 3;
            break label803;
            label988:
            ((bi)localObject1).jl(null);
            break label829;
            ((j)g.E(j.class)).bPQ().a(((Long)b.cLC().tyW.get(Integer.valueOf(parama.twP))).longValue(), (bi)localObject1);
            break label957;
            ((j)g.E(j.class)).bPQ().b(localcm.pIG, (bi)localObject1);
          }
          label1042:
          label1079:
          parama = (e.a)localObject3;
        }
      }
      localObject1 = str1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.o
 * JD-Core Version:    0.7.0.1
 */