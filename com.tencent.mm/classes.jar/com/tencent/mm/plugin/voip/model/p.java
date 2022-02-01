package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.b;
import com.tencent.mm.am.g.c;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.br;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.d.c;
import com.tencent.mm.plugin.voip.d.c.a;
import com.tencent.mm.plugin.voip.f.d;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.gaq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.cc;
import java.util.Map;

public final class p
  implements g
{
  public final g.b b(g.a parama)
  {
    AppMethodBeat.i(114962);
    dl localdl = parama.mpN;
    String str1 = w.a(localdl.YFE);
    Object localObject1 = w.a(localdl.YFF);
    String str2 = w.a(localdl.YFG);
    Log.d("MicroMsg.VoipExtension", "voip msg, from: %s, content: %s", new Object[] { str1, str2 });
    Object localObject2 = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ();
    Object localObject3 = (String)com.tencent.mm.kernel.h.baE().ban().d(2, "");
    if (((String)localObject3).length() <= 0)
    {
      AppMethodBeat.o(114962);
      return null;
    }
    if (((String)localObject3).equals(str1)) {}
    for (;;)
    {
      localObject1 = ((i)localObject2).aU((String)localObject1, localdl.Njv);
      if (((fi)localObject1).field_msgId == 0L)
      {
        localObject1 = new cc();
        ((cc)localObject1).gX(localdl.Njv);
        ((cc)localObject1).setCreateTime(br.D(str1, localdl.CreateTime));
      }
      for (;;)
      {
        SubCoreVoip.hVp();
        localObject3 = u.bfJ(str2);
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
                  if (com.tencent.mm.k.h.aQH()) {
                    break label342;
                  }
                  Log.i("MicroMsg.VoipExtension", "set voipmsg not notification...");
                }
                label342:
                while (Util.getInt((String)((Map)localObject1).get(".voipwarnmsg.roomid"), 0) == SubCoreVoip.hVp().UBE.UvO.UyU.roomId)
                {
                  SubCoreVoip.hVp().Uxv = parama;
                  localObject1 = SubCoreVoip.hVp();
                  i = 0;
                  while (i < 2)
                  {
                    MMHandlerThread.postToMainThreadDelayed(new u.7((u)localObject1, parama), 1000L);
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
        SubCoreVoip.hVp();
        if (v.hYM()) {
          ((cc)localObject1).gX(0L);
        }
        while (((a)localObject3).UAZ == SubCoreVoip.hVp().UBM)
        {
          Log.i("MicroMsg.VoipExtension", "already ignore the invite, don't add the message to db");
          AppMethodBeat.o(114962);
          return null;
          if (((a)localObject3).status == a.UBd) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label672;
            }
            Log.i("MicroMsg.VoipExtension", "recv voip cancel message");
            Object localObject4 = SubCoreVoip.hVp();
            if ((str2 == null) || (str2.length() == 0)) {
              break;
            }
            localObject2 = new a();
            if ((!((a)localObject2).bfI(str2)) || (((a)localObject2).status != 2)) {
              break;
            }
            ((u)localObject4).hYm();
            if (((u)localObject4).UwR != null)
            {
              ((u)localObject4).UwR.hVY();
              ((u)localObject4).UwR.ged();
              ((u)localObject4).UwR = null;
            }
            localObject4 = ((u)localObject4).UBE;
            Log.i("MicroMsg.Voip.VoipServiceEx", "onCancelInviteMessage, roomId: " + ((a)localObject2).UAZ);
            if ((((v)localObject4).UvO.UyZ == null) || (((a)localObject2).UAZ != ((v)localObject4).UvO.UyZ.Zvz)) {
              break;
            }
            localObject2 = c.UGb;
            c.a(c.a.UGG);
            MMHandlerThread.postToMainThread(new v.1((v)localObject4));
            break;
          }
          label672:
          if (((a)localObject3).status == a.UBf) {}
          for (i = 1; i != 0; i = 0)
          {
            AppMethodBeat.o(114962);
            return null;
          }
          if (((a)localObject3).status == a.UBc) {}
          for (i = 1; i != 0; i = 0)
          {
            Log.i("MicroMsg.VoipExtension", "recv voip invite delay");
            SubCoreVoip.hVp().bh(((a)localObject3).UAZ, ((a)localObject3).UBa);
            AppMethodBeat.o(114962);
            return null;
          }
          if (((a)localObject3).hXj())
          {
            Log.i("MicroMsg.VoipExtension", "receive invite busy message");
            ((cc)localObject1).gX(0L);
          }
          else
          {
            AppMethodBeat.o(114962);
            return null;
          }
        }
        ((cc)localObject1).setType(localdl.IIs);
        if (((a)localObject3).hXi())
        {
          localObject2 = cc.adkp;
          ((cc)localObject1).setContent((String)localObject2);
          ((cc)localObject1).pI(0);
          ((cc)localObject1).BS(str1);
          if (localdl.vhk <= 3) {
            break label1028;
          }
          i = localdl.vhk;
          label839:
          ((cc)localObject1).setStatus(i);
          if (!((a)localObject3).hXj())
          {
            SubCoreVoip.hVp();
            if (!v.hYM()) {
              break label1033;
            }
          }
          ((cc)localObject1).AU(MMApplicationContext.getContext().getString(b.g.voip_busy_msg_content));
          label875:
          br.a((cc)localObject1, parama);
          Log.d("MicroMsg.VoipExtension", "voipMessage==null: %b", new Object[] { localObject3 });
          if (((fi)localObject1).field_msgId != 0L) {
            break label1087;
          }
          if (localObject3 != null) {
            break label1124;
          }
          parama = new a();
          parama.bfI(str2);
        }
        for (;;)
        {
          Log.d("MicroMsg.VoipExtension", "add or update msg, roomid: %s", new Object[] { Integer.valueOf(parama.UAZ) });
          if (SubCoreVoip.hVp().UBL.get(Integer.valueOf(parama.UAZ)) == null)
          {
            ((cc)localObject1).setMsgId(br.B((cc)localObject1));
            SubCoreVoip.hVp().UBL.put(Integer.valueOf(parama.UAZ), Long.valueOf(((fi)localObject1).field_msgId));
          }
          label1003:
          for (parama = new g.b((cc)localObject1, true);; parama = new g.b((cc)localObject1, false))
          {
            AppMethodBeat.o(114962);
            return parama;
            localObject2 = cc.adko;
            break;
            i = 3;
            break label839;
            ((cc)localObject1).AU(null);
            break label875;
            ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(((Long)SubCoreVoip.hVp().UBL.get(Integer.valueOf(parama.UAZ))).longValue(), (cc)localObject1);
            break label1003;
            ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().b(localdl.Njv, (cc)localObject1);
          }
          label1028:
          label1033:
          label1087:
          label1124:
          parama = (g.a)localObject3;
        }
      }
      localObject1 = str1;
    }
  }
  
  public final void b(g.c paramc) {}
  
  public static final class a
  {
    public static int UBc = 1;
    public static int UBd = 2;
    public static int UBe = 3;
    public static int UBf = 4;
    public static int UBg = 5;
    public static int UBh = 0;
    public static int UBi = 1;
    public int UAZ;
    public long UBa;
    public int UBb;
    public int status;
    
    public final boolean bfI(String paramString)
    {
      AppMethodBeat.i(114961);
      this.UBb = UBh;
      try
      {
        paramString = XmlParser.parseXml(paramString, "voipinvitemsg", null);
        if (paramString != null)
        {
          if (paramString.get(".voipinvitemsg.roomid") != null) {
            this.UAZ = Util.getInt((String)paramString.get(".voipinvitemsg.roomid"), 0);
          }
          if (paramString.get(".voipinvitemsg.key") != null) {
            this.UBa = Util.getLong((String)paramString.get(".voipinvitemsg.key"), 0L);
          }
          if (paramString.get(".voipinvitemsg.status") != null) {
            this.status = Util.getInt((String)paramString.get(".voipinvitemsg.status"), 0);
          }
          if (paramString.get(".voipinvitemsg.invitetype") != null) {
            this.UBb = Util.getInt((String)paramString.get(".voipinvitemsg.invitetype"), 0);
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
    
    public final boolean hXi()
    {
      return this.UBb == UBh;
    }
    
    public final boolean hXj()
    {
      return this.status == UBg;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.p
 * JD-Core Version:    0.7.0.1
 */