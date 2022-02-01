package com.tencent.mm.plugin.webwx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.c;
import com.tencent.mm.f.a.un;
import com.tencent.mm.model.ck.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

final class g$1
  implements ck.a
{
  g$1(g paramg) {}
  
  public final void a(h.a parama)
  {
    AppMethodBeat.i(30183);
    String str = (String)XmlParser.parseXml(z.a(parama.jQG.RIF), "sysmsg", null).get(".sysmsg.pushloginurl.url");
    if (Util.isNullOrNil(str)) {
      Log.e("MicroMsg.SubCoreWebWX.pushloginurl", "pushloginurl is null");
    }
    un localun = new un();
    localun.fTP.fTQ = str;
    localun.fTP.type = 1;
    EventCenter.instance.publish(localun);
    parama.jQG.RIJ = null;
    AppMethodBeat.o(30183);
  }
  
  public final void a(h.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.a.g.1
 * JD-Core Version:    0.7.0.1
 */