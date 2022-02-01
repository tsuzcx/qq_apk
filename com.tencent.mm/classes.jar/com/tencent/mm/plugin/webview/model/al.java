package com.tencent.mm.plugin.webview.model;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class al
{
  private static final Set<String> WMe;
  
  static
  {
    AppMethodBeat.i(78986);
    Object localObject = new HashSet();
    WMe = (Set)localObject;
    ((Set)localObject).add("file:///android_asset/");
    localObject = b.bms();
    if (!Util.isNullOrNil((String)localObject)) {
      localObject = b.bms();
    }
    for (;;)
    {
      u localu1 = new u(aj.atb(0));
      WMe.add("file://" + ah.v(localu1.jKT()));
      WMe.add("file://" + ((j)com.tencent.mm.kernel.h.ax(j.class)).ipC());
      u localu2 = new u(b.bmz(), aj.ata(0));
      WMe.add("file://" + ah.v(localu2.jKT()));
      u localu3 = new u((String)localObject, "wenote/res");
      WMe.add("file://" + ah.v(localu3.jKT()));
      localu3 = new u(b.bmz(), "wenote/res");
      WMe.add("file://" + ah.v(localu3.jKT()));
      Log.i("MicroMsg.URLFilter", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s", new Object[] { ah.v(localu1.jKT()), ah.v(localu2.jKT()) });
      localObject = new u((String)localObject, "emoji/res");
      WMe.add("file://" + ah.v(((u)localObject).jKT()));
      localu1 = new u(b.bmz(), "emoji/res");
      WMe.add("file://" + ah.v(localu1.jKT()));
      Log.i("MicroMsg.URLFilter", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s", new Object[] { ah.v(((u)localObject).jKT()), ah.v(localu1.jKT()) });
      localObject = WMe.iterator();
      while (((Iterator)localObject).hasNext()) {
        Log.i("MicroMsg.URLFilter", "WebViewUI white list path : %s", new Object[] { (String)((Iterator)localObject).next() });
      }
      AppMethodBeat.o(78986);
      return;
    }
  }
  
  public static boolean bkm(String paramString)
  {
    AppMethodBeat.i(78985);
    if (z.pCj)
    {
      Log.w("MicroMsg.URLFilter", "skipLoadUrlCheck");
      AppMethodBeat.o(78985);
      return true;
    }
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(78985);
      return true;
    }
    paramString = paramString.toLowerCase();
    if (paramString.startsWith("about:blank"))
    {
      AppMethodBeat.o(78985);
      return false;
    }
    if (!paramString.startsWith("file://"))
    {
      paramString = Uri.parse(paramString);
      if (Util.isNullOrNil(paramString.getHost()))
      {
        AppMethodBeat.o(78985);
        return true;
      }
      if (!paramString.getHost().contains(com.tencent.luggage.l.h.atl()))
      {
        AppMethodBeat.o(78985);
        return true;
      }
      AppMethodBeat.o(78985);
      return false;
    }
    Iterator localIterator = WMe.iterator();
    while (localIterator.hasNext()) {
      if (paramString.startsWith((String)localIterator.next()))
      {
        AppMethodBeat.o(78985);
        return true;
      }
    }
    AppMethodBeat.o(78985);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.al
 * JD-Core Version:    0.7.0.1
 */