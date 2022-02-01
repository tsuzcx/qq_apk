package com.tencent.mm.plugin.wear.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.b;
import com.tencent.mm.al.e.c;
import com.tencent.mm.g.a.ze;
import com.tencent.mm.g.a.ze.b;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import java.util.LinkedHashMap;

public final class b
  implements e
{
  public final e.b b(e.a parama)
  {
    AppMethodBeat.i(30138);
    ??? = parama.gqE;
    ba.aBQ();
    if (bt.isNullOrNil((String)c.ajl().get(2, "")))
    {
      AppMethodBeat.o(30138);
      return null;
    }
    parama = z.a(((cv)???).Fvi);
    Object localObject2 = z.a(((cv)???).Fvj);
    if ((bt.isNullOrNil(parama)) || (bt.isNullOrNil((String)localObject2)))
    {
      ad.e("MicroMsg.YoExtension", "neither from-user nor to-user can be empty");
      AppMethodBeat.o(30138);
      return null;
    }
    Object localObject3 = z.a(((cv)???).Fvk);
    ad.i("MicroMsg.YoExtension", "from  " + parama + "content " + (String)localObject3);
    localObject2 = com.tencent.mm.plugin.wear.model.a.eKx();
    synchronized (((a)localObject2).DxO)
    {
      ze localze = a.aFu(parama);
      if ((!((a)localObject2).DxO.containsKey(parama)) && (localze.dOm.dOn != 1))
      {
        ad.i("MicroMsg.wear.WearYoLogic", "Can add Yo Message %s", new Object[] { parama });
        localObject3 = new a.a((a)localObject2, parama, (String)localObject3);
        ((a)localObject2).DxO.put(parama, localObject3);
        com.tencent.mm.plugin.wear.model.a.eKx().eKQ();
        AppMethodBeat.o(30138);
        return null;
      }
      ad.i("MicroMsg.wear.WearYoLogic", "Can not add Yo Message %s", new Object[] { parama });
      localObject2 = new ze();
      ((ze)localObject2).dOl.dkM = 2;
      ((ze)localObject2).dOl.username = parama;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
    }
  }
  
  public final void b(e.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.g.b
 * JD-Core Version:    0.7.0.1
 */