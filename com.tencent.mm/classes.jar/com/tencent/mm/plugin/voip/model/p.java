package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.bp;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.protocal.protobuf.ett;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ca;
import java.util.Map;

public final class p
  implements h
{
  public final h.b b(h.a parama)
  {
    AppMethodBeat.i(114962);
    de localde = parama.heO;
    String str1 = z.a(localde.KHl);
    Object localObject1 = z.a(localde.KHm);
    String str2 = z.a(localde.KHn);
    Log.d("MicroMsg.VoipExtension", "voip msg, from: %s, content: %s", new Object[] { str1, str2 });
    Object localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy();
    Object localObject3 = (String)com.tencent.mm.kernel.g.aAh().azQ().get(2, "");
    if (((String)localObject3).length() <= 0)
    {
      AppMethodBeat.o(114962);
      return null;
    }
    if (((String)localObject3).equals(str1)) {}
    for (;;)
    {
      localObject1 = ((i)localObject2).aJ((String)localObject1, localde.Brn);
      if (((eo)localObject1).field_msgId == 0L)
      {
        localObject1 = new ca();
        ((ca)localObject1).yF(localde.Brn);
        ((ca)localObject1).setCreateTime(bp.C(str1, localde.CreateTime));
      }
      for (;;)
      {
        c.fFg();
        localObject3 = u.aUy(str2);
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
                  if (com.tencent.mm.n.g.apP()) {
                    break label342;
                  }
                  Log.i("MicroMsg.VoipExtension", "set voipmsg not notification...");
                }
                label342:
                while (Util.getInt((String)((Map)localObject1).get(".voipwarnmsg.roomid"), 0) == c.fFg().GYS.GSZ.GVV.roomId)
                {
                  c.fFg().GUy = parama;
                  localObject1 = c.fFg();
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
        c.fFg();
        if (v.fIs()) {
          ((ca)localObject1).yF(0L);
        }
        while (((a)localObject3).GXO == c.fFg().GYZ)
        {
          Log.i("MicroMsg.VoipExtension", "already ignore the invite, don't add the message to db");
          AppMethodBeat.o(114962);
          return null;
          if (((a)localObject3).status == a.GXS) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label638;
            }
            Log.i("MicroMsg.VoipExtension", "recv voip cancel message");
            Object localObject4 = c.fFg();
            if ((str2 == null) || (str2.length() == 0)) {
              break;
            }
            localObject2 = new a();
            if ((!((a)localObject2).parse(str2)) || (((a)localObject2).status != 2)) {
              break;
            }
            ((u)localObject4).adm(((a)localObject2).GXO);
            localObject4 = ((u)localObject4).GYS;
            Log.i("MicroMsg.Voip.VoipServiceEx", "onCancelInviteMessage, roomId: " + ((a)localObject2).GXO);
            if ((((v)localObject4).GSZ.GWa == null) || (((a)localObject2).GXO != ((v)localObject4).GSZ.GWa.LsZ)) {
              break;
            }
            ((v)localObject4).fIy();
            ((v)localObject4).GSZ.shutdown();
            break;
          }
          label638:
          if (((a)localObject3).status == a.GXU) {}
          for (i = 1; i != 0; i = 0)
          {
            AppMethodBeat.o(114962);
            return null;
          }
          if (((a)localObject3).status == a.GXR) {}
          for (i = 1; i != 0; i = 0)
          {
            Log.i("MicroMsg.VoipExtension", "recv voip invite delay");
            c.fFg().aN(((a)localObject3).GXO, ((a)localObject3).GXP);
            AppMethodBeat.o(114962);
            return null;
          }
          if (((a)localObject3).fGZ())
          {
            Log.i("MicroMsg.VoipExtension", "receive invite busy message");
            ((ca)localObject1).yF(0L);
          }
          else
          {
            AppMethodBeat.o(114962);
            return null;
          }
        }
        ((ca)localObject1).setType(localde.xKb);
        if (((a)localObject3).fGY())
        {
          localObject2 = ca.OqC;
          ((ca)localObject1).setContent((String)localObject2);
          ((ca)localObject1).nv(0);
          ((ca)localObject1).Cy(str1);
          if (localde.oTW <= 3) {
            break label994;
          }
          i = localde.oTW;
          label805:
          ((ca)localObject1).setStatus(i);
          if (!((a)localObject3).fGZ())
          {
            c.fFg();
            if (!v.fIs()) {
              break label999;
            }
          }
          ((ca)localObject1).BB(MMApplicationContext.getContext().getString(2131767231));
          label841:
          bp.a((ca)localObject1, parama);
          Log.d("MicroMsg.VoipExtension", "voipMessage==null: %b", new Object[] { localObject3 });
          if (((eo)localObject1).field_msgId != 0L) {
            break label1053;
          }
          if (localObject3 != null) {
            break label1090;
          }
          parama = new a();
          parama.parse(str2);
        }
        for (;;)
        {
          Log.d("MicroMsg.VoipExtension", "add or update msg, roomid: %s", new Object[] { Integer.valueOf(parama.GXO) });
          if (c.fFg().GYY.get(Integer.valueOf(parama.GXO)) == null)
          {
            ((ca)localObject1).setMsgId(bp.x((ca)localObject1));
            c.fFg().GYY.put(Integer.valueOf(parama.GXO), Long.valueOf(((eo)localObject1).field_msgId));
          }
          label969:
          for (parama = new h.b((ca)localObject1, true);; parama = new h.b((ca)localObject1, false))
          {
            AppMethodBeat.o(114962);
            return parama;
            localObject2 = ca.OqB;
            break;
            label994:
            i = 3;
            break label805;
            label999:
            ((ca)localObject1).BB(null);
            break label841;
            ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().a(((Long)c.fFg().GYY.get(Integer.valueOf(parama.GXO))).longValue(), (ca)localObject1);
            break label969;
            ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().b(localde.Brn, (ca)localObject1);
          }
          label1053:
          label1090:
          parama = (h.a)localObject3;
        }
      }
      localObject1 = str1;
    }
  }
  
  public final void b(h.c paramc) {}
  
  public static final class a
  {
    public static int GXR = 1;
    public static int GXS = 2;
    public static int GXT = 3;
    public static int GXU = 4;
    public static int GXV = 5;
    public static int GXW = 0;
    public static int GXX = 1;
    public int GXO;
    public long GXP;
    public int GXQ;
    public int status;
    
    public final boolean fGY()
    {
      return this.GXQ == GXW;
    }
    
    public final boolean fGZ()
    {
      return this.status == GXV;
    }
    
    public final boolean parse(String paramString)
    {
      AppMethodBeat.i(114961);
      this.GXQ = GXW;
      try
      {
        paramString = XmlParser.parseXml(paramString, "voipinvitemsg", null);
        if (paramString != null)
        {
          if (paramString.get(".voipinvitemsg.roomid") != null) {
            this.GXO = Util.getInt((String)paramString.get(".voipinvitemsg.roomid"), 0);
          }
          if (paramString.get(".voipinvitemsg.key") != null) {
            this.GXP = Util.getLong((String)paramString.get(".voipinvitemsg.key"), 0L);
          }
          if (paramString.get(".voipinvitemsg.status") != null) {
            this.status = Util.getInt((String)paramString.get(".voipinvitemsg.status"), 0);
          }
          if (paramString.get(".voipinvitemsg.invitetype") != null) {
            this.GXQ = Util.getInt((String)paramString.get(".voipinvitemsg.invitetype"), 0);
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.p
 * JD-Core Version:    0.7.0.1
 */