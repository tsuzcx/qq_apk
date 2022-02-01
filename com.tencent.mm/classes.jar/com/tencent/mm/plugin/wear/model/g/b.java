package com.tencent.mm.plugin.wear.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.b;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.g.a.zk;
import com.tencent.mm.g.a.zk.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import java.util.LinkedHashMap;

public final class b
  implements e
{
  public final e.b b(e.a parama)
  {
    AppMethodBeat.i(30138);
    ??? = parama.gte;
    bc.aCg();
    if (bu.isNullOrNil((String)c.ajA().get(2, "")))
    {
      AppMethodBeat.o(30138);
      return null;
    }
    parama = z.a(((cv)???).FNG);
    Object localObject2 = z.a(((cv)???).FNH);
    if ((bu.isNullOrNil(parama)) || (bu.isNullOrNil((String)localObject2)))
    {
      ae.e("MicroMsg.YoExtension", "neither from-user nor to-user can be empty");
      AppMethodBeat.o(30138);
      return null;
    }
    Object localObject3 = z.a(((cv)???).FNI);
    ae.i("MicroMsg.YoExtension", "from  " + parama + "content " + (String)localObject3);
    localObject2 = com.tencent.mm.plugin.wear.model.a.eOf();
    synchronized (((a)localObject2).DPt)
    {
      zk localzk = a.aGO(parama);
      if ((!((a)localObject2).DPt.containsKey(parama)) && (localzk.dPC.dPD != 1))
      {
        ae.i("MicroMsg.wear.WearYoLogic", "Can add Yo Message %s", new Object[] { parama });
        localObject3 = new a.a((a)localObject2, parama, (String)localObject3);
        ((a)localObject2).DPt.put(parama, localObject3);
        com.tencent.mm.plugin.wear.model.a.eOf().eOy();
        AppMethodBeat.o(30138);
        return null;
      }
      ae.i("MicroMsg.wear.WearYoLogic", "Can not add Yo Message %s", new Object[] { parama });
      localObject2 = new zk();
      ((zk)localObject2).dPB.dlO = 2;
      ((zk)localObject2).dPB.username = parama;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
    }
  }
  
  public final void b(e.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.g.b
 * JD-Core Version:    0.7.0.1
 */