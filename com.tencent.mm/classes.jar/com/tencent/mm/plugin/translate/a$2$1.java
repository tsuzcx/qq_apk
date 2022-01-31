package com.tencent.mm.plugin.translate;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.g.a.tt.a;
import com.tencent.mm.plugin.translate.a.c;
import com.tencent.mm.plugin.translate.a.c.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

final class a$2$1
  implements Runnable
{
  a$2$1(a.2 param2, tt paramtt) {}
  
  public final void run()
  {
    AppMethodBeat.i(26050);
    c localc = this.toO.toK.toF;
    Object localObject = this.toN.cKm.cKn;
    String str1 = this.toN.cKm.id;
    int i = this.toN.cKm.type;
    String str2 = this.toN.cKm.source;
    boolean bool = this.toN.cKm.cKo;
    byte[] arrayOfByte = this.toN.cKm.cKp;
    ab.d("MicroMsg.TranslateServiceManager", "doTranslate msgId : %s, type: %d", new Object[] { str1, Integer.valueOf(i) });
    if (localc.aew(str1))
    {
      ab.d("MicroMsg.TranslateServiceManager", "doTranslate msgId %s is inQueue", new Object[] { str1 });
      AppMethodBeat.o(26050);
      return;
    }
    localObject = new c.c((String)localObject, str1, i, str2, arrayOfByte);
    if (bool) {
      ((LinkedList)localc.toR).add(0, localObject);
    }
    for (;;)
    {
      localc.toS.put(((c.c)localObject).id, Integer.valueOf(((c.c)localObject).toU));
      ab.d("MicroMsg.TranslateServiceManager", "requestCount : %s", new Object[] { Integer.valueOf(localc.evn) });
      localc.cKT();
      AppMethodBeat.o(26050);
      return;
      localc.toR.add(localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.translate.a.2.1
 * JD-Core Version:    0.7.0.1
 */