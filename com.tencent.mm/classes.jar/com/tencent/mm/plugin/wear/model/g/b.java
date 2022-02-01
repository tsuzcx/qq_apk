package com.tencent.mm.plugin.wear.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.b;
import com.tencent.mm.an.h.c;
import com.tencent.mm.f.a.aby;
import com.tencent.mm.f.a.aby.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import java.util.LinkedHashMap;

public final class b
  implements h
{
  public final h.b b(h.a parama)
  {
    AppMethodBeat.i(30138);
    ??? = parama.jQG;
    bh.beI();
    if (Util.isNullOrNil((String)c.aHp().b(2, "")))
    {
      AppMethodBeat.o(30138);
      return null;
    }
    parama = z.a(((db)???).RID);
    Object localObject2 = z.a(((db)???).RIE);
    if ((Util.isNullOrNil(parama)) || (Util.isNullOrNil((String)localObject2)))
    {
      Log.e("MicroMsg.YoExtension", "neither from-user nor to-user can be empty");
      AppMethodBeat.o(30138);
      return null;
    }
    Object localObject3 = z.a(((db)???).RIF);
    Log.i("MicroMsg.YoExtension", "from  " + parama + "content " + (String)localObject3);
    localObject2 = com.tencent.mm.plugin.wear.model.a.gOv();
    synchronized (((a)localObject2).PsM)
    {
      aby localaby = a.bhX(parama);
      if ((!((a)localObject2).PsM.containsKey(parama)) && (localaby.gbV.gbW != 1))
      {
        Log.i("MicroMsg.wear.WearYoLogic", "Can add Yo Message %s", new Object[] { parama });
        localObject3 = new a.a((a)localObject2, parama, (String)localObject3);
        ((a)localObject2).PsM.put(parama, localObject3);
        com.tencent.mm.plugin.wear.model.a.gOv().gOQ();
        AppMethodBeat.o(30138);
        return null;
      }
      Log.i("MicroMsg.wear.WearYoLogic", "Can not add Yo Message %s", new Object[] { parama });
      localObject2 = new aby();
      ((aby)localObject2).gbU.fvK = 2;
      ((aby)localObject2).gbU.username = parama;
      EventCenter.instance.publish((IEvent)localObject2);
    }
  }
  
  public final void b(h.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.g.b
 * JD-Core Version:    0.7.0.1
 */