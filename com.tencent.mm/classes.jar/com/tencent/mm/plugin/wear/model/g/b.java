package com.tencent.mm.plugin.wear.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.b;
import com.tencent.mm.am.g.c;
import com.tencent.mm.autogen.a.adv;
import com.tencent.mm.autogen.a.adv.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import java.util.LinkedHashMap;

public final class b
  implements g
{
  public final g.b b(g.a parama)
  {
    AppMethodBeat.i(30138);
    ??? = parama.mpN;
    bh.bCz();
    if (Util.isNullOrNil((String)c.ban().d(2, "")))
    {
      AppMethodBeat.o(30138);
      return null;
    }
    parama = w.a(((dl)???).YFE);
    Object localObject2 = w.a(((dl)???).YFF);
    if ((Util.isNullOrNil(parama)) || (Util.isNullOrNil((String)localObject2)))
    {
      Log.e("MicroMsg.YoExtension", "neither from-user nor to-user can be empty");
      AppMethodBeat.o(30138);
      return null;
    }
    Object localObject3 = w.a(((dl)???).YFG);
    Log.i("MicroMsg.YoExtension", "from  " + parama + "content " + (String)localObject3);
    localObject2 = com.tencent.mm.plugin.wear.model.a.inK();
    synchronized (((a)localObject2).Wjz)
    {
      adv localadv = a.bhG(parama);
      if ((!((a)localObject2).Wjz.containsKey(parama)) && (localadv.iih.iii != 1))
      {
        Log.i("MicroMsg.wear.WearYoLogic", "Can add Yo Message %s", new Object[] { parama });
        localObject3 = new a.a((a)localObject2, parama, (String)localObject3);
        ((a)localObject2).Wjz.put(parama, localObject3);
        com.tencent.mm.plugin.wear.model.a.inK().ioe();
        AppMethodBeat.o(30138);
        return null;
      }
      Log.i("MicroMsg.wear.WearYoLogic", "Can not add Yo Message %s", new Object[] { parama });
      localObject2 = new adv();
      ((adv)localObject2).iig.hAf = 2;
      ((adv)localObject2).iig.username = parama;
      ((adv)localObject2).publish();
    }
  }
  
  public final void b(g.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.g.b
 * JD-Core Version:    0.7.0.1
 */