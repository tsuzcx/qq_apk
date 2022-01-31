package com.tencent.mm.plugin.radar.b;

import a.f.b.j;
import a.l;
import a.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ad;
import java.util.Map;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/radar/model/RadarAddContact$msgListener$1", "Lcom/tencent/mm/model/SysCmdMsgExtension$ISysCmdMsgListener;", "NODE_ENCRYPT_USERNAME", "", "NODE_TYPE", "NODE_USERNAME", "onRecieveMsg", "", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "plugin-radar_release"})
public final class c$g
  implements bz.a
{
  private final String pQa = ".sysmsg.addcontact.type";
  private final String pQb = ".sysmsg.addcontact.username";
  private final String pQc = ".sysmsg.addcontact.encryptusername";
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(102877);
    j.q(parama, "addMsgInfo");
    Object localObject1 = aa.a(parama.eyJ.woR);
    Object localObject2 = br.F((String)localObject1, "sysmsg");
    if (localObject2 == null)
    {
      AppMethodBeat.o(102877);
      return;
    }
    if (j.e((String)((Map)localObject2).get(this.pQa), "1"))
    {
      parama = (String)((Map)localObject2).get(this.pQb);
      localObject2 = (String)((Map)localObject2).get(this.pQc);
      CharSequence localCharSequence = (CharSequence)parama;
      if ((localCharSequence == null) || (m.ap(localCharSequence)))
      {
        i = 1;
        if (i == 0)
        {
          localCharSequence = (CharSequence)localObject2;
          if ((localCharSequence != null) && (!m.ap(localCharSequence))) {
            break label172;
          }
        }
      }
      label172:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label177;
        }
        ab.e(c.access$getTAG$cp(), "error! server return incorrect content! : %s", new Object[] { localObject1 });
        AppMethodBeat.o(102877);
        return;
        i = 0;
        break;
      }
      label177:
      localObject1 = new ad();
      ((ad)localObject1).setUsername(parama);
      ((ad)localObject1).jv((String)localObject2);
      c.c(this.pPT, (ad)localObject1);
      ab.d(c.access$getTAG$cp(), "receive contact added system message useranme %s, encypt %s", new Object[] { ((ad)localObject1).getUsername(), ((ad)localObject1).Hv() });
    }
    AppMethodBeat.o(102877);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.c.g
 * JD-Core Version:    0.7.0.1
 */