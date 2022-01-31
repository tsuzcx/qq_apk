package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.ah.e.b;
import com.tencent.mm.ah.e.c;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.m.f;
import com.tencent.mm.model.bd;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.voip.a.e;
import com.tencent.mm.plugin.voip.b;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.protocal.c.cfe;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.util.Map;

public final class n
  implements com.tencent.mm.ah.e
{
  public final void a(e.c paramc) {}
  
  public final e.b b(e.a parama)
  {
    cd localcd = parama.dBs;
    String str1 = aa.a(localcd.svF);
    Object localObject1 = aa.a(localcd.svG);
    String str2 = aa.a(localcd.svH);
    y.d("MicroMsg.VoipExtension", "voip msg, from: %s, content: %s", new Object[] { str1, str2 });
    Object localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO();
    Object localObject3 = (String)com.tencent.mm.kernel.g.DP().Dz().get(2, "");
    if (((String)localObject3).length() <= 0) {
      return null;
    }
    if (((String)localObject3).equals(str1)) {}
    for (;;)
    {
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.a.g)localObject2).O((String)localObject1, localcd.ndp);
      if (((cs)localObject1).field_msgId == 0L)
      {
        localObject1 = new bi();
        ((bi)localObject1).bf(localcd.ndp);
        ((bi)localObject1).bg(bd.o(str1, localcd.mPL));
      }
      for (;;)
      {
        b.bPx();
        localObject3 = r.PZ(str2);
        if (localObject3 == null)
        {
          y.e("MicroMsg.VoipExtension", "parse voip message failed, voipMessage is null!");
          try
          {
            parama = bn.s(str2, "voipwarnmsg");
            if ((parama == null) || (parama.get(".voipwarnmsg.type") == null) || (bk.getInt((String)parama.get(".voipwarnmsg.type"), 0) != 1)) {
              break;
            }
            localObject1 = (String)parama.get(".voipwarnmsg.warntips");
            if ((localObject1 == null) || (((String)localObject1).equals(""))) {
              break;
            }
            y.i("MicroMsg.VoipExtension", "got risk tips back:" + (String)localObject1);
            if (parama.get(".voipwarnmsg.roomid") != null)
            {
              if (f.zR()) {
                break label315;
              }
              y.i("MicroMsg.VoipExtension", "set voipmsg not notification...");
            }
            label315:
            while (bk.getInt((String)parama.get(".voipwarnmsg.roomid"), 0) == b.bPx().pTq.pNq.pQe.lpD)
            {
              b.bPx().pSz = ((String)localObject1);
              b.bPx().Qa((String)localObject1);
              break;
            }
            y.i("MicroMsg.VoipExtension", "wrong roomid,now return..");
            return null;
          }
          catch (Exception parama)
          {
            y.printErrStackTrace("MicroMsg.VoipExtension", parama, "", new Object[0]);
            y.e("MicroMsg.VoipExtension", "parse voip message error: %s", new Object[] { parama.getMessage() });
          }
        }
        int i;
        Object localObject4;
        if (((n.a)localObject3).status == n.a.pRM)
        {
          i = 1;
          if (i == 0) {
            break label580;
          }
          y.i("MicroMsg.VoipExtension", "recv voip cancel message");
          localObject4 = b.bPx();
          if ((str2 != null) && (str2.length() != 0)) {
            break label461;
          }
        }
        for (;;)
        {
          if (((n.a)localObject3).pRI == b.bPx().pTw)
          {
            y.i("MicroMsg.VoipExtension", "already ignore the invite, don't add the message to db");
            return null;
            i = 0;
            break;
            label461:
            localObject2 = new n.a();
            if ((((n.a)localObject2).parse(str2)) && (((n.a)localObject2).status == 2))
            {
              ((r)localObject4).Aj(((n.a)localObject2).pRI);
              localObject4 = ((r)localObject4).pTq;
              y.i("MicroMsg.Voip.VoipServiceEx", "onCancelInviteMessage, roomId: " + ((n.a)localObject2).pRI);
              if ((((s)localObject4).pNq.pQj != null) && (((n.a)localObject2).pRI == ((s)localObject4).pNq.pQj.sST))
              {
                ((s)localObject4).bRu();
                ((s)localObject4).pNq.shutdown();
                continue;
                label580:
                if (((n.a)localObject3).status == n.a.pRO) {}
                for (i = 1; i != 0; i = 0) {
                  return null;
                }
                if (((n.a)localObject3).status == n.a.pRL) {}
                for (i = 1; i != 0; i = 0)
                {
                  y.i("MicroMsg.VoipExtension", "recv voip invite delay");
                  b.bPx().T(((n.a)localObject3).pRI, ((n.a)localObject3).pRJ);
                  return null;
                }
                if (((n.a)localObject3).bQq())
                {
                  y.i("MicroMsg.VoipExtension", "receive invite busy message");
                  ((bi)localObject1).bf(0L);
                }
                else
                {
                  return null;
                }
              }
            }
          }
        }
        ((bi)localObject1).setType(localcd.kSW);
        if (((n.a)localObject3).bQp())
        {
          localObject2 = bi.uBQ;
          ((bi)localObject1).setContent((String)localObject2);
          ((bi)localObject1).fA(0);
          ((bi)localObject1).ec(str1);
          if (localcd.hQq <= 3) {
            break label904;
          }
          i = localcd.hQq;
          label732:
          ((bi)localObject1).setStatus(i);
          if (!((n.a)localObject3).bQq()) {
            break label909;
          }
          ((bi)localObject1).cY(ae.getContext().getString(a.e.voip_busy_msg_content));
          label758:
          bd.a((bi)localObject1, parama);
          y.d("MicroMsg.VoipExtension", "voipMessage==null: %b", new Object[] { localObject3 });
          if (((cs)localObject1).field_msgId != 0L) {
            break label963;
          }
          if (localObject3 != null) {
            break label997;
          }
          parama = new n.a();
          parama.parse(str2);
        }
        for (;;)
        {
          y.d("MicroMsg.VoipExtension", "add or update msg, roomid: %s", new Object[] { Integer.valueOf(parama.pRI) });
          if (b.bPx().pTv.get(Integer.valueOf(parama.pRI)) == null)
          {
            ((bi)localObject1).setMsgId(bd.h((bi)localObject1));
            b.bPx().pTv.put(Integer.valueOf(parama.pRI), Long.valueOf(((cs)localObject1).field_msgId));
          }
          for (;;)
          {
            return new e.b((bi)localObject1, true);
            localObject2 = bi.uBP;
            break;
            label904:
            i = 3;
            break label732;
            label909:
            ((bi)localObject1).cY(null);
            break label758;
            ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().a(((Long)b.bPx().pTv.get(Integer.valueOf(parama.pRI))).longValue(), (bi)localObject1);
          }
          label963:
          ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().b(localcd.ndp, (bi)localObject1);
          return new e.b((bi)localObject1, false);
          label997:
          parama = (e.a)localObject3;
        }
      }
      return null;
      localObject1 = str1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.n
 * JD-Core Version:    0.7.0.1
 */