package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.b;
import com.tencent.mm.al.e.c;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bj;
import com.tencent.mm.n.f;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.dxv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bu;
import java.util.Map;

public final class p
  implements com.tencent.mm.al.e
{
  public final e.b b(e.a parama)
  {
    AppMethodBeat.i(114962);
    cv localcv = parama.gqE;
    String str1 = z.a(localcv.Fvi);
    Object localObject1 = z.a(localcv.Fvj);
    String str2 = z.a(localcv.Fvk);
    ad.d("MicroMsg.VoipExtension", "voip msg, from: %s, content: %s", new Object[] { str1, str2 });
    Object localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK();
    Object localObject3 = (String)g.ajC().ajl().get(2, "");
    if (((String)localObject3).length() <= 0)
    {
      AppMethodBeat.o(114962);
      return null;
    }
    if (((String)localObject3).equals(str1)) {}
    for (;;)
    {
      localObject1 = ((i)localObject2).aI((String)localObject1, localcv.xbt);
      if (((ei)localObject1).field_msgId == 0L)
      {
        localObject1 = new bu();
        ((bu)localObject1).qz(localcv.xbt);
        ((bu)localObject1).qA(bj.B(str1, localcv.CreateTime));
      }
      for (;;)
      {
        c.euM();
        localObject3 = u.aDF(str2);
        int i;
        if (localObject3 == null)
        {
          ad.e("MicroMsg.VoipExtension", "parse voip message failed, voipMessage is null!");
          try
          {
            localObject1 = bw.M(str2, "voipwarnmsg");
            if ((localObject1 != null) && (((Map)localObject1).get(".voipwarnmsg.type") != null) && (bt.getInt((String)((Map)localObject1).get(".voipwarnmsg.type"), 0) == 1))
            {
              parama = (String)((Map)localObject1).get(".voipwarnmsg.warntips");
              if ((parama != null) && (!parama.equals("")))
              {
                ad.i("MicroMsg.VoipExtension", "got risk tips back:".concat(String.valueOf(parama)));
                if (((Map)localObject1).get(".voipwarnmsg.roomid") != null)
                {
                  if (f.abH()) {
                    break label341;
                  }
                  ad.i("MicroMsg.VoipExtension", "set voipmsg not notification...");
                }
                label341:
                while (bt.getInt((String)((Map)localObject1).get(".voipwarnmsg.roomid"), 0) == c.euM().CdF.BXC.CaI.roomId)
                {
                  c.euM().BZf = parama;
                  localObject1 = c.euM();
                  i = 0;
                  while (i < 2)
                  {
                    aq.o(new u.4((u)localObject1, parama), 1000L);
                    i += 1;
                  }
                }
                ad.i("MicroMsg.VoipExtension", "wrong roomid,now return..");
                AppMethodBeat.o(114962);
                return null;
              }
            }
          }
          catch (Exception parama)
          {
            ad.printErrStackTrace("MicroMsg.VoipExtension", parama, "", new Object[0]);
            ad.e("MicroMsg.VoipExtension", "parse voip message error: %s", new Object[] { parama.getMessage() });
            AppMethodBeat.o(114962);
            return null;
          }
        }
        c.euM();
        if (v.exQ()) {
          ((bu)localObject1).qz(0L);
        }
        while (((a)localObject3).CcE == c.euM().CdM)
        {
          ad.i("MicroMsg.VoipExtension", "already ignore the invite, don't add the message to db");
          AppMethodBeat.o(114962);
          return null;
          if (((a)localObject3).status == a.CcI) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label637;
            }
            ad.i("MicroMsg.VoipExtension", "recv voip cancel message");
            Object localObject4 = c.euM();
            if ((str2 == null) || (str2.length() == 0)) {
              break;
            }
            localObject2 = new a();
            if ((!((a)localObject2).parse(str2)) || (((a)localObject2).status != 2)) {
              break;
            }
            ((u)localObject4).Ul(((a)localObject2).CcE);
            localObject4 = ((u)localObject4).CdF;
            ad.i("MicroMsg.Voip.VoipServiceEx", "onCancelInviteMessage, roomId: " + ((a)localObject2).CcE);
            if ((((v)localObject4).BXC.CaN == null) || (((a)localObject2).CcE != ((v)localObject4).BXC.CaN.GeI)) {
              break;
            }
            ((v)localObject4).exW();
            ((v)localObject4).BXC.shutdown();
            break;
          }
          label637:
          if (((a)localObject3).status == a.CcK) {}
          for (i = 1; i != 0; i = 0)
          {
            AppMethodBeat.o(114962);
            return null;
          }
          if (((a)localObject3).status == a.CcH) {}
          for (i = 1; i != 0; i = 0)
          {
            ad.i("MicroMsg.VoipExtension", "recv voip invite delay");
            c.euM().aI(((a)localObject3).CcE, ((a)localObject3).CcF);
            AppMethodBeat.o(114962);
            return null;
          }
          if (((a)localObject3).ewC())
          {
            ad.i("MicroMsg.VoipExtension", "receive invite busy message");
            ((bu)localObject1).qz(0L);
          }
          else
          {
            AppMethodBeat.o(114962);
            return null;
          }
        }
        ((bu)localObject1).setType(localcv.ugm);
        if (((a)localObject3).ewB())
        {
          localObject2 = bu.IMe;
          ((bu)localObject1).setContent((String)localObject2);
          ((bu)localObject1).kr(0);
          ((bu)localObject1).tN(str1);
          if (localcv.nDG <= 3) {
            break label993;
          }
          i = localcv.nDG;
          label804:
          ((bu)localObject1).setStatus(i);
          if (!((a)localObject3).ewC())
          {
            c.euM();
            if (!v.exQ()) {
              break label998;
            }
          }
          ((bu)localObject1).sP(aj.getContext().getString(2131764793));
          label840:
          bj.a((bu)localObject1, parama);
          ad.d("MicroMsg.VoipExtension", "voipMessage==null: %b", new Object[] { localObject3 });
          if (((ei)localObject1).field_msgId != 0L) {
            break label1052;
          }
          if (localObject3 != null) {
            break label1089;
          }
          parama = new a();
          parama.parse(str2);
        }
        for (;;)
        {
          ad.d("MicroMsg.VoipExtension", "add or update msg, roomid: %s", new Object[] { Integer.valueOf(parama.CcE) });
          if (c.euM().CdL.get(Integer.valueOf(parama.CcE)) == null)
          {
            ((bu)localObject1).setMsgId(bj.v((bu)localObject1));
            c.euM().CdL.put(Integer.valueOf(parama.CcE), Long.valueOf(((ei)localObject1).field_msgId));
          }
          label968:
          for (parama = new e.b((bu)localObject1, true);; parama = new e.b((bu)localObject1, false))
          {
            AppMethodBeat.o(114962);
            return parama;
            localObject2 = bu.IMd;
            break;
            label993:
            i = 3;
            break label804;
            label998:
            ((bu)localObject1).sP(null);
            break label840;
            ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().a(((Long)c.euM().CdL.get(Integer.valueOf(parama.CcE))).longValue(), (bu)localObject1);
            break label968;
            ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().b(localcv.xbt, (bu)localObject1);
          }
          label1052:
          label1089:
          parama = (e.a)localObject3;
        }
      }
      localObject1 = str1;
    }
  }
  
  public final void b(e.c paramc) {}
  
  public static final class a
  {
    public static int CcH = 1;
    public static int CcI = 2;
    public static int CcJ = 3;
    public static int CcK = 4;
    public static int CcL = 5;
    public static int CcM = 0;
    public static int CcN = 1;
    public int CcE;
    public long CcF;
    public int CcG;
    public int status;
    
    public final boolean ewB()
    {
      return this.CcG == CcM;
    }
    
    public final boolean ewC()
    {
      return this.status == CcL;
    }
    
    public final boolean parse(String paramString)
    {
      AppMethodBeat.i(114961);
      this.CcG = CcM;
      try
      {
        paramString = bw.M(paramString, "voipinvitemsg");
        if (paramString != null)
        {
          if (paramString.get(".voipinvitemsg.roomid") != null) {
            this.CcE = bt.getInt((String)paramString.get(".voipinvitemsg.roomid"), 0);
          }
          if (paramString.get(".voipinvitemsg.key") != null) {
            this.CcF = bt.getLong((String)paramString.get(".voipinvitemsg.key"), 0L);
          }
          if (paramString.get(".voipinvitemsg.status") != null) {
            this.status = bt.getInt((String)paramString.get(".voipinvitemsg.status"), 0);
          }
          if (paramString.get(".voipinvitemsg.invitetype") != null) {
            this.CcG = bt.getInt((String)paramString.get(".voipinvitemsg.invitetype"), 0);
          }
          AppMethodBeat.o(114961);
          return true;
        }
        AppMethodBeat.o(114961);
        return false;
      }
      catch (Exception paramString)
      {
        ad.printErrStackTrace("MicroMsg.VoipExtension", paramString, "", new Object[0]);
        ad.e("MicroMsg.VoipExtension", "parse voip message error: %s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(114961);
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.p
 * JD-Core Version:    0.7.0.1
 */