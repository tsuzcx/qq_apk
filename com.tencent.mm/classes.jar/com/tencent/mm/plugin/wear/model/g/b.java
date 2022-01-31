package com.tencent.mm.plugin.wear.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.ai.e.c;
import com.tencent.mm.g.a.vz;
import com.tencent.mm.g.a.vz.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.LinkedHashMap;

public final class b
  implements e
{
  public final void a(e.c paramc) {}
  
  public final e.b b(e.a parama)
  {
    AppMethodBeat.i(26456);
    ??? = parama.eyJ;
    aw.aaz();
    if (bo.isNullOrNil((String)c.Ru().get(2, "")))
    {
      AppMethodBeat.o(26456);
      return null;
    }
    parama = aa.a(((cm)???).woP);
    Object localObject2 = aa.a(((cm)???).woQ);
    if ((bo.isNullOrNil(parama)) || (bo.isNullOrNil((String)localObject2)))
    {
      ab.e("MicroMsg.YoExtension", "neither from-user nor to-user can be empty");
      AppMethodBeat.o(26456);
      return null;
    }
    Object localObject3 = aa.a(((cm)???).woR);
    ab.i("MicroMsg.YoExtension", "from  " + parama + "content " + (String)localObject3);
    localObject2 = com.tencent.mm.plugin.wear.model.a.cYy().uGJ;
    synchronized (((a)localObject2).uHW)
    {
      vz localvz = a.agi(parama);
      if ((!((a)localObject2).uHW.containsKey(parama)) && (localvz.cNp.cNq != 1))
      {
        ab.i("MicroMsg.wear.WearYoLogic", "Can add Yo Message %s", new Object[] { parama });
        localObject3 = new a.a((a)localObject2, parama, (String)localObject3);
        ((a)localObject2).uHW.put(parama, localObject3);
        com.tencent.mm.plugin.wear.model.a.cYy().uGJ.cYO();
        AppMethodBeat.o(26456);
        return null;
      }
      ab.i("MicroMsg.wear.WearYoLogic", "Can not add Yo Message %s", new Object[] { parama });
      localObject2 = new vz();
      ((vz)localObject2).cNo.coO = 2;
      ((vz)localObject2).cNo.username = parama;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.g.b
 * JD-Core Version:    0.7.0.1
 */