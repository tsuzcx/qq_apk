package com.tencent.mm.plugin.radar.b;

import a.d.b.g;
import a.h.e;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import java.util.Map;

public final class c$g
  implements bx.a
{
  private final String nkK = ".sysmsg.addcontact.type";
  private final String nkL = ".sysmsg.addcontact.username";
  private final String nkM = ".sysmsg.addcontact.encryptusername";
  
  public final void a(e.a parama)
  {
    g.k(parama, "addMsgInfo");
    parama = aa.a(parama.dBs.svH);
    Object localObject2 = bn.s(parama, "sysmsg");
    if (localObject2 == null) {}
    while (!g.e((String)((Map)localObject2).get(this.nkK), "1")) {
      return;
    }
    Object localObject1 = (String)((Map)localObject2).get(this.nkL);
    localObject2 = (String)((Map)localObject2).get(this.nkM);
    CharSequence localCharSequence = (CharSequence)localObject1;
    if ((localCharSequence == null) || (e.X(localCharSequence)))
    {
      i = 1;
      if (i == 0)
      {
        localCharSequence = (CharSequence)localObject2;
        if ((localCharSequence != null) && (!e.X(localCharSequence))) {
          break label161;
        }
      }
    }
    label161:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label166;
      }
      localObject1 = c.nkz;
      y.e(c.access$getTAG$cp(), "error! server return incorrect content! : %s", new Object[] { parama });
      return;
      i = 0;
      break;
    }
    label166:
    parama = new ad();
    parama.setUsername((String)localObject1);
    parama.dq((String)localObject2);
    c.c(this.nkD, parama);
    localObject1 = c.nkz;
    y.d(c.access$getTAG$cp(), "receive contact added system message useranme %s, encypt %s", new Object[] { parama.getUsername(), parama.vp() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.c.g
 * JD-Core Version:    0.7.0.1
 */