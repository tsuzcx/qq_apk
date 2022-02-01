package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.b;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bl;
import com.tencent.mm.n.f;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.dzm;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.bv;
import java.util.Map;

public final class p
  implements com.tencent.mm.ak.e
{
  public final e.b b(e.a parama)
  {
    AppMethodBeat.i(114962);
    cv localcv = parama.gte;
    String str1 = z.a(localcv.FNG);
    Object localObject1 = z.a(localcv.FNH);
    String str2 = z.a(localcv.FNI);
    ae.d("MicroMsg.VoipExtension", "voip msg, from: %s, content: %s", new Object[] { str1, str2 });
    Object localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ();
    Object localObject3 = (String)g.ajR().ajA().get(2, "");
    if (((String)localObject3).length() <= 0)
    {
      AppMethodBeat.o(114962);
      return null;
    }
    if (((String)localObject3).equals(str1)) {}
    for (;;)
    {
      localObject1 = ((i)localObject2).aJ((String)localObject1, localcv.xrk);
      if (((ei)localObject1).field_msgId == 0L)
      {
        localObject1 = new bv();
        ((bv)localObject1).qM(localcv.xrk);
        ((bv)localObject1).qN(bl.B(str1, localcv.CreateTime));
      }
      for (;;)
      {
        c.eys();
        localObject3 = u.aEY(str2);
        int i;
        if (localObject3 == null)
        {
          ae.e("MicroMsg.VoipExtension", "parse voip message failed, voipMessage is null!");
          try
          {
            localObject1 = bx.M(str2, "voipwarnmsg");
            if ((localObject1 != null) && (((Map)localObject1).get(".voipwarnmsg.type") != null) && (bu.getInt((String)((Map)localObject1).get(".voipwarnmsg.type"), 0) == 1))
            {
              parama = (String)((Map)localObject1).get(".voipwarnmsg.warntips");
              if ((parama != null) && (!parama.equals("")))
              {
                ae.i("MicroMsg.VoipExtension", "got risk tips back:".concat(String.valueOf(parama)));
                if (((Map)localObject1).get(".voipwarnmsg.roomid") != null)
                {
                  if (f.abQ()) {
                    break label341;
                  }
                  ae.i("MicroMsg.VoipExtension", "set voipmsg not notification...");
                }
                label341:
                while (bu.getInt((String)((Map)localObject1).get(".voipwarnmsg.roomid"), 0) == c.eys().Cvg.Cpd.Csj.roomId)
                {
                  c.eys().CqG = parama;
                  localObject1 = c.eys();
                  i = 0;
                  while (i < 2)
                  {
                    ar.o(new u.4((u)localObject1, parama), 1000L);
                    i += 1;
                  }
                }
                ae.i("MicroMsg.VoipExtension", "wrong roomid,now return..");
                AppMethodBeat.o(114962);
                return null;
              }
            }
          }
          catch (Exception parama)
          {
            ae.printErrStackTrace("MicroMsg.VoipExtension", parama, "", new Object[0]);
            ae.e("MicroMsg.VoipExtension", "parse voip message error: %s", new Object[] { parama.getMessage() });
            AppMethodBeat.o(114962);
            return null;
          }
        }
        c.eys();
        if (v.eBy()) {
          ((bv)localObject1).qM(0L);
        }
        while (((a)localObject3).Cuf == c.eys().Cvn)
        {
          ae.i("MicroMsg.VoipExtension", "already ignore the invite, don't add the message to db");
          AppMethodBeat.o(114962);
          return null;
          if (((a)localObject3).status == a.Cuj) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label637;
            }
            ae.i("MicroMsg.VoipExtension", "recv voip cancel message");
            Object localObject4 = c.eys();
            if ((str2 == null) || (str2.length() == 0)) {
              break;
            }
            localObject2 = new a();
            if ((!((a)localObject2).parse(str2)) || (((a)localObject2).status != 2)) {
              break;
            }
            ((u)localObject4).US(((a)localObject2).Cuf);
            localObject4 = ((u)localObject4).Cvg;
            ae.i("MicroMsg.Voip.VoipServiceEx", "onCancelInviteMessage, roomId: " + ((a)localObject2).Cuf);
            if ((((v)localObject4).Cpd.Cso == null) || (((a)localObject2).Cuf != ((v)localObject4).Cpd.Cso.Gxq)) {
              break;
            }
            ((v)localObject4).eBE();
            ((v)localObject4).Cpd.shutdown();
            break;
          }
          label637:
          if (((a)localObject3).status == a.Cul) {}
          for (i = 1; i != 0; i = 0)
          {
            AppMethodBeat.o(114962);
            return null;
          }
          if (((a)localObject3).status == a.Cui) {}
          for (i = 1; i != 0; i = 0)
          {
            ae.i("MicroMsg.VoipExtension", "recv voip invite delay");
            c.eys().aI(((a)localObject3).Cuf, ((a)localObject3).Cug);
            AppMethodBeat.o(114962);
            return null;
          }
          if (((a)localObject3).eAj())
          {
            ae.i("MicroMsg.VoipExtension", "receive invite busy message");
            ((bv)localObject1).qM(0L);
          }
          else
          {
            AppMethodBeat.o(114962);
            return null;
          }
        }
        ((bv)localObject1).setType(localcv.urJ);
        if (((a)localObject3).eAi())
        {
          localObject2 = bv.JgL;
          ((bv)localObject1).setContent((String)localObject2);
          ((bv)localObject1).kt(0);
          ((bv)localObject1).ui(str1);
          if (localcv.nJb <= 3) {
            break label993;
          }
          i = localcv.nJb;
          label804:
          ((bv)localObject1).setStatus(i);
          if (!((a)localObject3).eAj())
          {
            c.eys();
            if (!v.eBy()) {
              break label998;
            }
          }
          ((bv)localObject1).tk(ak.getContext().getString(2131764793));
          label840:
          bl.a((bv)localObject1, parama);
          ae.d("MicroMsg.VoipExtension", "voipMessage==null: %b", new Object[] { localObject3 });
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
          ae.d("MicroMsg.VoipExtension", "add or update msg, roomid: %s", new Object[] { Integer.valueOf(parama.Cuf) });
          if (c.eys().Cvm.get(Integer.valueOf(parama.Cuf)) == null)
          {
            ((bv)localObject1).setMsgId(bl.v((bv)localObject1));
            c.eys().Cvm.put(Integer.valueOf(parama.Cuf), Long.valueOf(((ei)localObject1).field_msgId));
          }
          label968:
          for (parama = new e.b((bv)localObject1, true);; parama = new e.b((bv)localObject1, false))
          {
            AppMethodBeat.o(114962);
            return parama;
            localObject2 = bv.JgK;
            break;
            label993:
            i = 3;
            break label804;
            label998:
            ((bv)localObject1).tk(null);
            break label840;
            ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().a(((Long)c.eys().Cvm.get(Integer.valueOf(parama.Cuf))).longValue(), (bv)localObject1);
            break label968;
            ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().b(localcv.xrk, (bv)localObject1);
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
    public static int Cui = 1;
    public static int Cuj = 2;
    public static int Cuk = 3;
    public static int Cul = 4;
    public static int Cum = 5;
    public static int Cun = 0;
    public static int Cuo = 1;
    public int Cuf;
    public long Cug;
    public int Cuh;
    public int status;
    
    public final boolean eAi()
    {
      return this.Cuh == Cun;
    }
    
    public final boolean eAj()
    {
      return this.status == Cum;
    }
    
    public final boolean parse(String paramString)
    {
      AppMethodBeat.i(114961);
      this.Cuh = Cun;
      try
      {
        paramString = bx.M(paramString, "voipinvitemsg");
        if (paramString != null)
        {
          if (paramString.get(".voipinvitemsg.roomid") != null) {
            this.Cuf = bu.getInt((String)paramString.get(".voipinvitemsg.roomid"), 0);
          }
          if (paramString.get(".voipinvitemsg.key") != null) {
            this.Cug = bu.getLong((String)paramString.get(".voipinvitemsg.key"), 0L);
          }
          if (paramString.get(".voipinvitemsg.status") != null) {
            this.status = bu.getInt((String)paramString.get(".voipinvitemsg.status"), 0);
          }
          if (paramString.get(".voipinvitemsg.invitetype") != null) {
            this.Cuh = bu.getInt((String)paramString.get(".voipinvitemsg.invitetype"), 0);
          }
          AppMethodBeat.o(114961);
          return true;
        }
        AppMethodBeat.o(114961);
        return false;
      }
      catch (Exception paramString)
      {
        ae.printErrStackTrace("MicroMsg.VoipExtension", paramString, "", new Object[0]);
        ae.e("MicroMsg.VoipExtension", "parse voip message error: %s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(114961);
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.p
 * JD-Core Version:    0.7.0.1
 */