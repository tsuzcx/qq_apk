package com.tencent.mm.plugin.wear.model.g;

import com.tencent.mm.ah.e;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.ah.e.b;
import com.tencent.mm.ah.e.c;
import com.tencent.mm.h.a.ud;
import com.tencent.mm.h.a.ud.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.LinkedHashMap;

public final class b
  implements e
{
  public final void a(e.c paramc) {}
  
  public final e.b b(e.a parama)
  {
    ??? = parama.dBs;
    au.Hx();
    if (bk.bl((String)c.Dz().get(2, ""))) {
      return null;
    }
    parama = aa.a(((cd)???).svF);
    Object localObject2 = aa.a(((cd)???).svG);
    if ((bk.bl(parama)) || (bk.bl((String)localObject2)))
    {
      y.e("MicroMsg.YoExtension", "neither from-user nor to-user can be empty");
      return null;
    }
    Object localObject3 = aa.a(((cd)???).svH);
    y.i("MicroMsg.YoExtension", "from  " + parama + "content " + (String)localObject3);
    localObject2 = com.tencent.mm.plugin.wear.model.a.bYL().qRB;
    synchronized (((a)localObject2).qSP)
    {
      ud localud = a.Rl(parama);
      if ((!((a)localObject2).qSP.containsKey(parama)) && (localud.ceC.ceD != 1))
      {
        y.i("MicroMsg.wear.WearYoLogic", "Can add Yo Message %s", new Object[] { parama });
        localObject3 = new a.a((a)localObject2, parama, (String)localObject3);
        ((a)localObject2).qSP.put(parama, localObject3);
        com.tencent.mm.plugin.wear.model.a.bYL().qRB.bZb();
        return null;
      }
      y.i("MicroMsg.wear.WearYoLogic", "Can not add Yo Message %s", new Object[] { parama });
      localObject2 = new ud();
      ((ud)localObject2).ceB.bHz = 2;
      ((ud)localObject2).ceB.username = parama;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.g.b
 * JD-Core Version:    0.7.0.1
 */