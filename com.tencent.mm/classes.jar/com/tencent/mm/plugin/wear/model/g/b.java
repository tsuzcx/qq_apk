package com.tencent.mm.plugin.wear.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.b;
import com.tencent.mm.al.f.c;
import com.tencent.mm.g.a.xz;
import com.tencent.mm.g.a.xz.b;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import java.util.LinkedHashMap;

public final class b
  implements f
{
  public final f.b b(f.a parama)
  {
    AppMethodBeat.i(30138);
    ??? = parama.fTo;
    az.arV();
    if (bt.isNullOrNil((String)c.afk().get(2, "")))
    {
      AppMethodBeat.o(30138);
      return null;
    }
    parama = z.a(((cs)???).Cxx);
    Object localObject2 = z.a(((cs)???).Cxy);
    if ((bt.isNullOrNil(parama)) || (bt.isNullOrNil((String)localObject2)))
    {
      ad.e("MicroMsg.YoExtension", "neither from-user nor to-user can be empty");
      AppMethodBeat.o(30138);
      return null;
    }
    Object localObject3 = z.a(((cs)???).Cxz);
    ad.i("MicroMsg.YoExtension", "from  " + parama + "content " + (String)localObject3);
    localObject2 = com.tencent.mm.plugin.wear.model.a.egX();
    synchronized (((a)localObject2).AFb)
    {
      xz localxz = a.auT(parama);
      if ((!((a)localObject2).AFb.containsKey(parama)) && (localxz.dEn.dEo != 1))
      {
        ad.i("MicroMsg.wear.WearYoLogic", "Can add Yo Message %s", new Object[] { parama });
        localObject3 = new a.a((a)localObject2, parama, (String)localObject3);
        ((a)localObject2).AFb.put(parama, localObject3);
        com.tencent.mm.plugin.wear.model.a.egX().ehq();
        AppMethodBeat.o(30138);
        return null;
      }
      ad.i("MicroMsg.wear.WearYoLogic", "Can not add Yo Message %s", new Object[] { parama });
      localObject2 = new xz();
      ((xz)localObject2).dEm.dbV = 2;
      ((xz)localObject2).dEm.username = parama;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
    }
  }
  
  public final void b(f.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.g.b
 * JD-Core Version:    0.7.0.1
 */