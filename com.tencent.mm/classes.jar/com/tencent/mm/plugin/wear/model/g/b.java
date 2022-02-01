package com.tencent.mm.plugin.wear.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.b;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.g.a.yk;
import com.tencent.mm.g.a.yk.b;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import java.util.LinkedHashMap;

public final class b
  implements f
{
  public final f.b b(f.a parama)
  {
    AppMethodBeat.i(30138);
    ??? = parama.fXi;
    az.ayM();
    if (bs.isNullOrNil((String)c.agA().get(2, "")))
    {
      AppMethodBeat.o(30138);
      return null;
    }
    parama = z.a(((cu)???).DPT);
    Object localObject2 = z.a(((cu)???).DPU);
    if ((bs.isNullOrNil(parama)) || (bs.isNullOrNil((String)localObject2)))
    {
      ac.e("MicroMsg.YoExtension", "neither from-user nor to-user can be empty");
      AppMethodBeat.o(30138);
      return null;
    }
    Object localObject3 = z.a(((cu)???).DPV);
    ac.i("MicroMsg.YoExtension", "from  " + parama + "content " + (String)localObject3);
    localObject2 = com.tencent.mm.plugin.wear.model.a.ewr();
    synchronized (((a)localObject2).BXv)
    {
      yk localyk = a.aAk(parama);
      if ((!((a)localObject2).BXv.containsKey(parama)) && (localyk.dBZ.dCa != 1))
      {
        ac.i("MicroMsg.wear.WearYoLogic", "Can add Yo Message %s", new Object[] { parama });
        localObject3 = new a.a((a)localObject2, parama, (String)localObject3);
        ((a)localObject2).BXv.put(parama, localObject3);
        com.tencent.mm.plugin.wear.model.a.ewr().ewK();
        AppMethodBeat.o(30138);
        return null;
      }
      ac.i("MicroMsg.wear.WearYoLogic", "Can not add Yo Message %s", new Object[] { parama });
      localObject2 = new yk();
      ((yk)localObject2).dBY.cZu = 2;
      ((yk)localObject2).dBY.username = parama;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
    }
  }
  
  public final void b(f.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.g.b
 * JD-Core Version:    0.7.0.1
 */