package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.b;
import com.tencent.mm.an.h.c;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.bq;
import com.tencent.mm.n.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.b.a;
import com.tencent.mm.plugin.voip.b.a.a;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.protocal.protobuf.fee;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ca;
import java.util.Map;

public final class p
  implements com.tencent.mm.an.h
{
  public final h.b b(h.a parama)
  {
    AppMethodBeat.i(114962);
    db localdb = parama.jQG;
    String str1 = z.a(localdb.RID);
    Object localObject1 = z.a(localdb.RIE);
    String str2 = z.a(localdb.RIF);
    Log.d("MicroMsg.VoipExtension", "voip msg, from: %s, content: %s", new Object[] { str1, str2 });
    Object localObject2 = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe();
    Object localObject3 = (String)com.tencent.mm.kernel.h.aHG().aHp().b(2, "");
    if (((String)localObject3).length() <= 0)
    {
      AppMethodBeat.o(114962);
      return null;
    }
    if (((String)localObject3).equals(str1)) {}
    for (;;)
    {
      localObject1 = ((i)localObject2).aL((String)localObject1, localdb.HlH);
      if (((et)localObject1).field_msgId == 0L)
      {
        localObject1 = new ca();
        ((ca)localObject1).EG(localdb.HlH);
        ((ca)localObject1).setCreateTime(bq.z(str1, localdb.CreateTime));
      }
      for (;;)
      {
        c.gxs();
        localObject3 = u.bge(str2);
        int i;
        if (localObject3 == null)
        {
          Log.e("MicroMsg.VoipExtension", "parse voip message failed, voipMessage is null!");
          try
          {
            localObject1 = XmlParser.parseXml(str2, "voipwarnmsg", null);
            if ((localObject1 != null) && (((Map)localObject1).get(".voipwarnmsg.type") != null) && (Util.getInt((String)((Map)localObject1).get(".voipwarnmsg.type"), 0) == 1))
            {
              parama = (String)((Map)localObject1).get(".voipwarnmsg.warntips");
              if ((parama != null) && (!parama.equals("")))
              {
                Log.i("MicroMsg.VoipExtension", "got risk tips back:".concat(String.valueOf(parama)));
                if (((Map)localObject1).get(".voipwarnmsg.roomid") != null)
                {
                  if (g.awi()) {
                    break label342;
                  }
                  Log.i("MicroMsg.VoipExtension", "set voipmsg not notification...");
                }
                label342:
                while (Util.getInt((String)((Map)localObject1).get(".voipwarnmsg.roomid"), 0) == c.gxs().NPf.NJk.NMi.roomId)
                {
                  c.gxs().NKK = parama;
                  localObject1 = c.gxs();
                  i = 0;
                  while (i < 2)
                  {
                    MMHandlerThread.postToMainThreadDelayed(new u.5((u)localObject1, parama), 1000L);
                    i += 1;
                  }
                }
                Log.i("MicroMsg.VoipExtension", "wrong roomid,now return..");
                AppMethodBeat.o(114962);
                return null;
              }
            }
          }
          catch (Exception parama)
          {
            Log.printErrStackTrace("MicroMsg.VoipExtension", parama, "", new Object[0]);
            Log.e("MicroMsg.VoipExtension", "parse voip message error: %s", new Object[] { parama.getMessage() });
            AppMethodBeat.o(114962);
            return null;
          }
        }
        c.gxs();
        if (v.gAM()) {
          ((ca)localObject1).EG(0L);
        }
        while (((a)localObject3).NOc == c.gxs().NPn)
        {
          Log.i("MicroMsg.VoipExtension", "already ignore the invite, don't add the message to db");
          AppMethodBeat.o(114962);
          return null;
          if (((a)localObject3).status == a.NOg) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label644;
            }
            Log.i("MicroMsg.VoipExtension", "recv voip cancel message");
            Object localObject4 = c.gxs();
            if ((str2 == null) || (str2.length() == 0)) {
              break;
            }
            localObject2 = new a();
            if ((!((a)localObject2).bgd(str2)) || (((a)localObject2).status != 2)) {
              break;
            }
            ((u)localObject4).gAg();
            localObject4 = ((u)localObject4).NPf;
            Log.i("MicroMsg.Voip.VoipServiceEx", "onCancelInviteMessage, roomId: " + ((a)localObject2).NOc);
            if ((((v)localObject4).NJk.NMn == null) || (((a)localObject2).NOc != ((v)localObject4).NJk.NMn.Svu)) {
              break;
            }
            localObject2 = a.NTi;
            a.a(a.a.NTl);
            ((v)localObject4).gAO();
            ((v)localObject4).NJk.shutdown();
            break;
          }
          label644:
          if (((a)localObject3).status == a.NOi) {}
          for (i = 1; i != 0; i = 0)
          {
            AppMethodBeat.o(114962);
            return null;
          }
          if (((a)localObject3).status == a.NOf) {}
          for (i = 1; i != 0; i = 0)
          {
            Log.i("MicroMsg.VoipExtension", "recv voip invite delay");
            c.gxs().aZ(((a)localObject3).NOc, ((a)localObject3).NOd);
            AppMethodBeat.o(114962);
            return null;
          }
          if (((a)localObject3).gzn())
          {
            Log.i("MicroMsg.VoipExtension", "receive invite busy message");
            ((ca)localObject1).EG(0L);
          }
          else
          {
            AppMethodBeat.o(114962);
            return null;
          }
        }
        ((ca)localObject1).setType(localdb.COi);
        if (((a)localObject3).gzm())
        {
          localObject2 = ca.VGy;
          ((ca)localObject1).setContent((String)localObject2);
          ((ca)localObject1).pJ(0);
          ((ca)localObject1).Jm(str1);
          if (localdb.rVU <= 3) {
            break label1000;
          }
          i = localdb.rVU;
          label811:
          ((ca)localObject1).setStatus(i);
          if (!((a)localObject3).gzn())
          {
            c.gxs();
            if (!v.gAM()) {
              break label1005;
            }
          }
          ((ca)localObject1).Ip(MMApplicationContext.getContext().getString(b.g.voip_busy_msg_content));
          label847:
          bq.a((ca)localObject1, parama);
          Log.d("MicroMsg.VoipExtension", "voipMessage==null: %b", new Object[] { localObject3 });
          if (((et)localObject1).field_msgId != 0L) {
            break label1059;
          }
          if (localObject3 != null) {
            break label1096;
          }
          parama = new a();
          parama.bgd(str2);
        }
        for (;;)
        {
          Log.d("MicroMsg.VoipExtension", "add or update msg, roomid: %s", new Object[] { Integer.valueOf(parama.NOc) });
          if (c.gxs().NPm.get(Integer.valueOf(parama.NOc)) == null)
          {
            ((ca)localObject1).setMsgId(bq.z((ca)localObject1));
            c.gxs().NPm.put(Integer.valueOf(parama.NOc), Long.valueOf(((et)localObject1).field_msgId));
          }
          label975:
          for (parama = new h.b((ca)localObject1, true);; parama = new h.b((ca)localObject1, false))
          {
            AppMethodBeat.o(114962);
            return parama;
            localObject2 = ca.VGx;
            break;
            label1000:
            i = 3;
            break label811;
            label1005:
            ((ca)localObject1).Ip(null);
            break label847;
            ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(((Long)c.gxs().NPm.get(Integer.valueOf(parama.NOc))).longValue(), (ca)localObject1);
            break label975;
            ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().b(localdb.HlH, (ca)localObject1);
          }
          label1059:
          label1096:
          parama = (h.a)localObject3;
        }
      }
      localObject1 = str1;
    }
  }
  
  public final void b(h.c paramc) {}
  
  public static final class a
  {
    public static int NOf = 1;
    public static int NOg = 2;
    public static int NOh = 3;
    public static int NOi = 4;
    public static int NOj = 5;
    public static int NOk = 0;
    public static int NOl = 1;
    public int NOc;
    public long NOd;
    public int NOe;
    public int status;
    
    public final boolean bgd(String paramString)
    {
      AppMethodBeat.i(114961);
      this.NOe = NOk;
      try
      {
        paramString = XmlParser.parseXml(paramString, "voipinvitemsg", null);
        if (paramString != null)
        {
          if (paramString.get(".voipinvitemsg.roomid") != null) {
            this.NOc = Util.getInt((String)paramString.get(".voipinvitemsg.roomid"), 0);
          }
          if (paramString.get(".voipinvitemsg.key") != null) {
            this.NOd = Util.getLong((String)paramString.get(".voipinvitemsg.key"), 0L);
          }
          if (paramString.get(".voipinvitemsg.status") != null) {
            this.status = Util.getInt((String)paramString.get(".voipinvitemsg.status"), 0);
          }
          if (paramString.get(".voipinvitemsg.invitetype") != null) {
            this.NOe = Util.getInt((String)paramString.get(".voipinvitemsg.invitetype"), 0);
          }
          AppMethodBeat.o(114961);
          return true;
        }
        AppMethodBeat.o(114961);
        return false;
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.VoipExtension", paramString, "", new Object[0]);
        Log.e("MicroMsg.VoipExtension", "parse voip message error: %s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(114961);
      }
      return false;
    }
    
    public final boolean gzm()
    {
      return this.NOe == NOk;
    }
    
    public final boolean gzn()
    {
      return this.status == NOj;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.p
 * JD-Core Version:    0.7.0.1
 */