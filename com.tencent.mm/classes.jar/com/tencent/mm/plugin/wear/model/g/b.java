package com.tencent.mm.plugin.wear.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.g.a.aar;
import com.tencent.mm.g.a.aar.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.de;
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
    ??? = parama.heO;
    bg.aVF();
    if (Util.isNullOrNil((String)c.azQ().get(2, "")))
    {
      AppMethodBeat.o(30138);
      return null;
    }
    parama = z.a(((de)???).KHl);
    Object localObject2 = z.a(((de)???).KHm);
    if ((Util.isNullOrNil(parama)) || (Util.isNullOrNil((String)localObject2)))
    {
      Log.e("MicroMsg.YoExtension", "neither from-user nor to-user can be empty");
      AppMethodBeat.o(30138);
      return null;
    }
    Object localObject3 = z.a(((de)???).KHn);
    Log.i("MicroMsg.YoExtension", "from  " + parama + "content " + (String)localObject3);
    localObject2 = com.tencent.mm.plugin.wear.model.a.fVO();
    synchronized (((a)localObject2).IyJ)
    {
      aar localaar = a.aWq(parama);
      if ((!((a)localObject2).IyJ.containsKey(parama)) && (localaar.ehF.ehG != 1))
      {
        Log.i("MicroMsg.wear.WearYoLogic", "Can add Yo Message %s", new Object[] { parama });
        localObject3 = new a.a((a)localObject2, parama, (String)localObject3);
        ((a)localObject2).IyJ.put(parama, localObject3);
        com.tencent.mm.plugin.wear.model.a.fVO().fWh();
        AppMethodBeat.o(30138);
        return null;
      }
      Log.i("MicroMsg.wear.WearYoLogic", "Can not add Yo Message %s", new Object[] { parama });
      localObject2 = new aar();
      ((aar)localObject2).ehE.dDe = 2;
      ((aar)localObject2).ehE.username = parama;
      EventCenter.instance.publish((IEvent)localObject2);
    }
  }
  
  public final void b(h.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.g.b
 * JD-Core Version:    0.7.0.1
 */