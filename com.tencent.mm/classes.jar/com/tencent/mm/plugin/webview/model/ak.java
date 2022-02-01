package com.tencent.mm.plugin.webview.model;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class ak
{
  private static final Set<String> AYp;
  
  static
  {
    AppMethodBeat.i(78986);
    Object localObject = new HashSet();
    AYp = (Set)localObject;
    ((Set)localObject).add("file:///android_asset/");
    localObject = b.aia();
    if (!bt.isNullOrNil((String)localObject)) {
      localObject = b.aia().replace("/data/user/0", "/data/data");
    }
    for (;;)
    {
      e locale1 = new e(aa.Sd(0));
      AYp.add("file://" + q.B(locale1.fhU()));
      AYp.add("file://" + ((j)com.tencent.mm.kernel.g.ab(j.class)).ehB());
      e locale2 = new e(b.aih(), aa.ehR());
      AYp.add("file://" + q.B(locale2.fhU()));
      e locale3 = new e((String)localObject, "wenote/res");
      AYp.add("file://" + q.B(locale3.fhU()));
      locale3 = new e(b.aih(), "wenote/res");
      AYp.add("file://" + q.B(locale3.fhU()));
      ad.i("MicroMsg.URLFilter", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s", new Object[] { q.B(locale1.fhU()), q.B(locale2.fhU()) });
      localObject = new e((String)localObject, "emoji/res");
      AYp.add("file://" + q.B(((e)localObject).fhU()));
      locale1 = new e(b.aih(), "emoji/res");
      AYp.add("file://" + q.B(locale1.fhU()));
      ad.i("MicroMsg.URLFilter", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s", new Object[] { q.B(((e)localObject).fhU()), q.B(locale1.fhU()) });
      localObject = AYp.iterator();
      while (((Iterator)localObject).hasNext()) {
        ad.i("MicroMsg.URLFilter", "WebViewUI white list path : %s", new Object[] { (String)((Iterator)localObject).next() });
      }
      AppMethodBeat.o(78986);
      return;
    }
  }
  
  public static boolean awv(String paramString)
  {
    AppMethodBeat.i(78985);
    if (ab.hVz)
    {
      ad.w("MicroMsg.URLFilter", "skipLoadUrlCheck");
      AppMethodBeat.o(78985);
      return true;
    }
    if (bt.isNullOrNil(paramString))
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
      if (bt.isNullOrNil(paramString.getHost()))
      {
        AppMethodBeat.o(78985);
        return true;
      }
      if (!paramString.getHost().contains(com.tencent.luggage.h.g.Ep()))
      {
        AppMethodBeat.o(78985);
        return true;
      }
      AppMethodBeat.o(78985);
      return false;
    }
    Iterator localIterator = AYp.iterator();
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
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ak
 * JD-Core Version:    0.7.0.1
 */