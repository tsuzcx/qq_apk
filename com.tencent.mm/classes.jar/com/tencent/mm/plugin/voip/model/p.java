package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.b;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.protocal.protobuf.dsb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bo;
import java.util.Map;

public final class p
  implements com.tencent.mm.ak.f
{
  public final f.b b(f.a parama)
  {
    AppMethodBeat.i(114962);
    cu localcu = parama.fXi;
    String str1 = z.a(localcu.DPT);
    Object localObject1 = z.a(localcu.DPU);
    String str2 = z.a(localcu.DPV);
    ac.d("MicroMsg.VoipExtension", "voip msg, from: %s, content: %s", new Object[] { str1, str2 });
    Object localObject2 = ((k)g.ab(k.class)).dcr();
    Object localObject3 = (String)g.agR().agA().get(2, "");
    if (((String)localObject3).length() <= 0)
    {
      AppMethodBeat.o(114962);
      return null;
    }
    if (((String)localObject3).equals(str1)) {}
    for (;;)
    {
      localObject1 = ((h)localObject2).aF((String)localObject1, localcu.vTQ);
      if (((dy)localObject1).field_msgId == 0L)
      {
        localObject1 = new bo();
        ((bo)localObject1).oz(localcu.vTQ);
        ((bo)localObject1).oA(bi.z(str1, localcu.CreateTime));
      }
      for (;;)
      {
        c.ehb();
        localObject3 = u.ayw(str2);
        int i;
        if (localObject3 == null)
        {
          ac.e("MicroMsg.VoipExtension", "parse voip message failed, voipMessage is null!");
          try
          {
            localObject1 = bv.L(str2, "voipwarnmsg");
            if ((localObject1 != null) && (((Map)localObject1).get(".voipwarnmsg.type") != null) && (bs.getInt((String)((Map)localObject1).get(".voipwarnmsg.type"), 0) == 1))
            {
              parama = (String)((Map)localObject1).get(".voipwarnmsg.warntips");
              if ((parama != null) && (!parama.equals("")))
              {
                ac.i("MicroMsg.VoipExtension", "got risk tips back:".concat(String.valueOf(parama)));
                if (((Map)localObject1).get(".voipwarnmsg.roomid") != null)
                {
                  if (com.tencent.mm.m.f.Zh()) {
                    break label341;
                  }
                  ac.i("MicroMsg.VoipExtension", "set voipmsg not notification...");
                }
                label341:
                while (bs.getInt((String)((Map)localObject1).get(".voipwarnmsg.roomid"), 0) == c.ehb().AEF.Ayh.ABJ.roomId)
                {
                  c.ehb().AAf = parama;
                  localObject1 = c.ehb();
                  i = 0;
                  while (i < 2)
                  {
                    ap.n(new u.4((u)localObject1, parama), 1000L);
                    i += 1;
                  }
                }
                ac.i("MicroMsg.VoipExtension", "wrong roomid,now return..");
                AppMethodBeat.o(114962);
                return null;
              }
            }
          }
          catch (Exception parama)
          {
            ac.printErrStackTrace("MicroMsg.VoipExtension", parama, "", new Object[0]);
            ac.e("MicroMsg.VoipExtension", "parse voip message error: %s", new Object[] { parama.getMessage() });
            AppMethodBeat.o(114962);
            return null;
          }
        }
        c.ehb();
        if (v.ekf()) {
          ((bo)localObject1).oz(0L);
        }
        while (((a)localObject3).ADE == c.ehb().AEM)
        {
          ac.i("MicroMsg.VoipExtension", "already ignore the invite, don't add the message to db");
          AppMethodBeat.o(114962);
          return null;
          if (((a)localObject3).status == a.ADI) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label637;
            }
            ac.i("MicroMsg.VoipExtension", "recv voip cancel message");
            Object localObject4 = c.ehb();
            if ((str2 == null) || (str2.length() == 0)) {
              break;
            }
            localObject2 = new a();
            if ((!((a)localObject2).parse(str2)) || (((a)localObject2).status != 2)) {
              break;
            }
            ((u)localObject4).St(((a)localObject2).ADE);
            localObject4 = ((u)localObject4).AEF;
            ac.i("MicroMsg.Voip.VoipServiceEx", "onCancelInviteMessage, roomId: " + ((a)localObject2).ADE);
            if ((((v)localObject4).Ayh.ABO == null) || (((a)localObject2).ADE != ((v)localObject4).Ayh.ABO.Exf)) {
              break;
            }
            ((v)localObject4).ekl();
            ((v)localObject4).Ayh.shutdown();
            break;
          }
          label637:
          if (((a)localObject3).status == a.ADK) {}
          for (i = 1; i != 0; i = 0)
          {
            AppMethodBeat.o(114962);
            return null;
          }
          if (((a)localObject3).status == a.ADH) {}
          for (i = 1; i != 0; i = 0)
          {
            ac.i("MicroMsg.VoipExtension", "recv voip invite delay");
            c.ehb().az(((a)localObject3).ADE, ((a)localObject3).ADF);
            AppMethodBeat.o(114962);
            return null;
          }
          if (((a)localObject3).eiR())
          {
            ac.i("MicroMsg.VoipExtension", "receive invite busy message");
            ((bo)localObject1).oz(0L);
          }
          else
          {
            AppMethodBeat.o(114962);
            return null;
          }
        }
        ((bo)localObject1).setType(localcu.tit);
        if (((a)localObject3).eiQ())
        {
          localObject2 = bo.GYP;
          ((bo)localObject1).setContent((String)localObject2);
          ((bo)localObject1).jT(0);
          ((bo)localObject1).re(str1);
          if (localcu.ndj <= 3) {
            break label993;
          }
          i = localcu.ndj;
          label804:
          ((bo)localObject1).setStatus(i);
          if (!((a)localObject3).eiR())
          {
            c.ehb();
            if (!v.ekf()) {
              break label998;
            }
          }
          ((bo)localObject1).qf(ai.getContext().getString(2131764793));
          label840:
          bi.a((bo)localObject1, parama);
          ac.d("MicroMsg.VoipExtension", "voipMessage==null: %b", new Object[] { localObject3 });
          if (((dy)localObject1).field_msgId != 0L) {
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
          ac.d("MicroMsg.VoipExtension", "add or update msg, roomid: %s", new Object[] { Integer.valueOf(parama.ADE) });
          if (c.ehb().AEL.get(Integer.valueOf(parama.ADE)) == null)
          {
            ((bo)localObject1).setMsgId(bi.u((bo)localObject1));
            c.ehb().AEL.put(Integer.valueOf(parama.ADE), Long.valueOf(((dy)localObject1).field_msgId));
          }
          label968:
          for (parama = new f.b((bo)localObject1, true);; parama = new f.b((bo)localObject1, false))
          {
            AppMethodBeat.o(114962);
            return parama;
            localObject2 = bo.GYO;
            break;
            label993:
            i = 3;
            break label804;
            label998:
            ((bo)localObject1).qf(null);
            break label840;
            ((k)g.ab(k.class)).dcr().a(((Long)c.ehb().AEL.get(Integer.valueOf(parama.ADE))).longValue(), (bo)localObject1);
            break label968;
            ((k)g.ab(k.class)).dcr().b(localcu.vTQ, (bo)localObject1);
          }
          label1052:
          label1089:
          parama = (f.a)localObject3;
        }
      }
      localObject1 = str1;
    }
  }
  
  public final void b(f.c paramc) {}
  
  public static final class a
  {
    public static int ADH = 1;
    public static int ADI = 2;
    public static int ADJ = 3;
    public static int ADK = 4;
    public static int ADL = 5;
    public static int ADM = 0;
    public static int ADN = 1;
    public int ADE;
    public long ADF;
    public int ADG;
    public int status;
    
    public final boolean eiQ()
    {
      return this.ADG == ADM;
    }
    
    public final boolean eiR()
    {
      return this.status == ADL;
    }
    
    public final boolean parse(String paramString)
    {
      AppMethodBeat.i(114961);
      this.ADG = ADM;
      try
      {
        paramString = bv.L(paramString, "voipinvitemsg");
        if (paramString != null)
        {
          if (paramString.get(".voipinvitemsg.roomid") != null) {
            this.ADE = bs.getInt((String)paramString.get(".voipinvitemsg.roomid"), 0);
          }
          if (paramString.get(".voipinvitemsg.key") != null) {
            this.ADF = bs.getLong((String)paramString.get(".voipinvitemsg.key"), 0L);
          }
          if (paramString.get(".voipinvitemsg.status") != null) {
            this.status = bs.getInt((String)paramString.get(".voipinvitemsg.status"), 0);
          }
          if (paramString.get(".voipinvitemsg.invitetype") != null) {
            this.ADG = bs.getInt((String)paramString.get(".voipinvitemsg.invitetype"), 0);
          }
          AppMethodBeat.o(114961);
          return true;
        }
        AppMethodBeat.o(114961);
        return false;
      }
      catch (Exception paramString)
      {
        ac.printErrStackTrace("MicroMsg.VoipExtension", paramString, "", new Object[0]);
        ac.e("MicroMsg.VoipExtension", "parse voip message error: %s", new Object[] { paramString.getMessage() });
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