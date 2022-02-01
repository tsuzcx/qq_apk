package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.b;
import com.tencent.mm.al.f.c;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.protocal.protobuf.dmk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bl;
import java.util.Map;

public final class p
  implements com.tencent.mm.al.f
{
  public final f.b b(f.a parama)
  {
    AppMethodBeat.i(114962);
    cs localcs = parama.fTo;
    String str1 = z.a(localcs.Cxx);
    Object localObject1 = z.a(localcs.Cxy);
    String str2 = z.a(localcs.Cxz);
    ad.d("MicroMsg.VoipExtension", "voip msg, from: %s, content: %s", new Object[] { str1, str2 });
    Object localObject2 = ((k)g.ab(k.class)).cOI();
    Object localObject3 = (String)g.afB().afk().get(2, "");
    if (((String)localObject3).length() <= 0)
    {
      AppMethodBeat.o(114962);
      return null;
    }
    if (((String)localObject3).equals(str1)) {}
    for (;;)
    {
      localObject1 = ((h)localObject2).aD((String)localObject1, localcs.uKZ);
      if (((du)localObject1).field_msgId == 0L)
      {
        localObject1 = new bl();
        ((bl)localObject1).kX(localcs.uKZ);
        ((bl)localObject1).kY(bi.y(str1, localcs.CreateTime));
      }
      for (;;)
      {
        c.dRQ();
        localObject3 = u.atf(str2);
        int i;
        if (localObject3 == null)
        {
          ad.e("MicroMsg.VoipExtension", "parse voip message failed, voipMessage is null!");
          try
          {
            localObject1 = bw.K(str2, "voipwarnmsg");
            if ((localObject1 != null) && (((Map)localObject1).get(".voipwarnmsg.type") != null) && (bt.getInt((String)((Map)localObject1).get(".voipwarnmsg.type"), 0) == 1))
            {
              parama = (String)((Map)localObject1).get(".voipwarnmsg.warntips");
              if ((parama != null) && (!parama.equals("")))
              {
                ad.i("MicroMsg.VoipExtension", "got risk tips back:".concat(String.valueOf(parama)));
                if (((Map)localObject1).get(".voipwarnmsg.roomid") != null)
                {
                  if (com.tencent.mm.m.f.Yk()) {
                    break label341;
                  }
                  ad.i("MicroMsg.VoipExtension", "set voipmsg not notification...");
                }
                label341:
                while (bt.getInt((String)((Map)localObject1).get(".voipwarnmsg.roomid"), 0) == c.dRQ().zlR.zfA.ziZ.roomId)
                {
                  c.dRQ().zhw = parama;
                  localObject1 = c.dRQ();
                  i = 0;
                  while (i < 2)
                  {
                    aq.n(new u.4((u)localObject1, parama), 1000L);
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
        Object localObject4;
        if (((a)localObject3).status == a.zkX)
        {
          i = 1;
          if (i == 0) {
            break label622;
          }
          ad.i("MicroMsg.VoipExtension", "recv voip cancel message");
          localObject4 = c.dRQ();
          if ((str2 != null) && (str2.length() != 0)) {
            break label503;
          }
        }
        for (;;)
        {
          if (((a)localObject3).zkT == c.dRQ().zlY)
          {
            ad.i("MicroMsg.VoipExtension", "already ignore the invite, don't add the message to db");
            AppMethodBeat.o(114962);
            return null;
            i = 0;
            break;
            label503:
            localObject2 = new a();
            if ((((a)localObject2).parse(str2)) && (((a)localObject2).status == 2))
            {
              ((u)localObject4).Qk(((a)localObject2).zkT);
              localObject4 = ((u)localObject4).zlR;
              ad.i("MicroMsg.Voip.VoipServiceEx", "onCancelInviteMessage, roomId: " + ((a)localObject2).zkT);
              if ((((v)localObject4).zfA.zje != null) && (((a)localObject2).zkT == ((v)localObject4).zfA.zje.DdZ))
              {
                ((v)localObject4).dUZ();
                ((v)localObject4).zfA.shutdown();
                continue;
                label622:
                if (((a)localObject3).status == a.zkZ) {}
                for (i = 1; i != 0; i = 0)
                {
                  AppMethodBeat.o(114962);
                  return null;
                }
                if (((a)localObject3).status == a.zkW) {}
                for (i = 1; i != 0; i = 0)
                {
                  ad.i("MicroMsg.VoipExtension", "recv voip invite delay");
                  c.dRQ().az(((a)localObject3).zkT, ((a)localObject3).zkU);
                  AppMethodBeat.o(114962);
                  return null;
                }
                if (((a)localObject3).dTF())
                {
                  ad.i("MicroMsg.VoipExtension", "receive invite busy message");
                  ((bl)localObject1).kX(0L);
                }
                else
                {
                  AppMethodBeat.o(114962);
                  return null;
                }
              }
            }
          }
        }
        ((bl)localObject1).setType(localcs.saz);
        if (((a)localObject3).dTE())
        {
          localObject2 = bl.FzN;
          ((bl)localObject1).setContent((String)localObject2);
          ((bl)localObject1).jV(0);
          ((bl)localObject1).nY(str1);
          if (localcs.mBi <= 3) {
            break label968;
          }
          i = localcs.mBi;
          label789:
          ((bl)localObject1).setStatus(i);
          if (!((a)localObject3).dTF()) {
            break label973;
          }
          ((bl)localObject1).mZ(aj.getContext().getString(2131764793));
          label815:
          bi.a((bl)localObject1, parama);
          ad.d("MicroMsg.VoipExtension", "voipMessage==null: %b", new Object[] { localObject3 });
          if (((du)localObject1).field_msgId != 0L) {
            break label1027;
          }
          if (localObject3 != null) {
            break label1064;
          }
          parama = new a();
          parama.parse(str2);
        }
        for (;;)
        {
          ad.d("MicroMsg.VoipExtension", "add or update msg, roomid: %s", new Object[] { Integer.valueOf(parama.zkT) });
          if (c.dRQ().zlX.get(Integer.valueOf(parama.zkT)) == null)
          {
            ((bl)localObject1).setMsgId(bi.u((bl)localObject1));
            c.dRQ().zlX.put(Integer.valueOf(parama.zkT), Long.valueOf(((du)localObject1).field_msgId));
          }
          label943:
          for (parama = new f.b((bl)localObject1, true);; parama = new f.b((bl)localObject1, false))
          {
            AppMethodBeat.o(114962);
            return parama;
            localObject2 = bl.FzM;
            break;
            label968:
            i = 3;
            break label789;
            label973:
            ((bl)localObject1).mZ(null);
            break label815;
            ((k)g.ab(k.class)).cOI().a(((Long)c.dRQ().zlX.get(Integer.valueOf(parama.zkT))).longValue(), (bl)localObject1);
            break label943;
            ((k)g.ab(k.class)).cOI().b(localcs.uKZ, (bl)localObject1);
          }
          label1027:
          label1064:
          parama = (f.a)localObject3;
        }
      }
      localObject1 = str1;
    }
  }
  
  public final void b(f.c paramc) {}
  
  public static final class a
  {
    public static int zkW = 1;
    public static int zkX = 2;
    public static int zkY = 3;
    public static int zkZ = 4;
    public static int zla = 5;
    public static int zlb = 0;
    public static int zlc = 1;
    public int status;
    public int zkT;
    public long zkU;
    public int zkV;
    
    public final boolean dTE()
    {
      return this.zkV == zlb;
    }
    
    public final boolean dTF()
    {
      return this.status == zla;
    }
    
    public final boolean parse(String paramString)
    {
      AppMethodBeat.i(114961);
      this.zkV = zlb;
      try
      {
        paramString = bw.K(paramString, "voipinvitemsg");
        if (paramString != null)
        {
          if (paramString.get(".voipinvitemsg.roomid") != null) {
            this.zkT = bt.getInt((String)paramString.get(".voipinvitemsg.roomid"), 0);
          }
          if (paramString.get(".voipinvitemsg.key") != null) {
            this.zkU = bt.getLong((String)paramString.get(".voipinvitemsg.key"), 0L);
          }
          if (paramString.get(".voipinvitemsg.status") != null) {
            this.status = bt.getInt((String)paramString.get(".voipinvitemsg.status"), 0);
          }
          if (paramString.get(".voipinvitemsg.invitetype") != null) {
            this.zkV = bt.getInt((String)paramString.get(".voipinvitemsg.invitetype"), 0);
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