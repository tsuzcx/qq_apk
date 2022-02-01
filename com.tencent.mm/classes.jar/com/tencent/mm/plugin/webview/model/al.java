package com.tencent.mm.plugin.webview.model;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class al
{
  private static final Set<String> DUf;
  
  static
  {
    AppMethodBeat.i(78986);
    Object localObject = new HashSet();
    DUf = (Set)localObject;
    ((Set)localObject).add("file:///android_asset/");
    localObject = b.arN();
    if (!bt.isNullOrNil((String)localObject)) {
      localObject = b.arN().replace("/data/user/0", "/data/data");
    }
    for (;;)
    {
      e locale1 = new e(com.tencent.mm.plugin.websearch.api.ad.Wg(0));
      DUf.add("file://" + q.B(locale1.fOK()));
      DUf.add("file://" + ((j)com.tencent.mm.kernel.g.ab(j.class)).eLJ());
      e locale2 = new e(b.arU(), com.tencent.mm.plugin.websearch.api.ad.eMc());
      DUf.add("file://" + q.B(locale2.fOK()));
      e locale3 = new e((String)localObject, "wenote/res");
      DUf.add("file://" + q.B(locale3.fOK()));
      locale3 = new e(b.arU(), "wenote/res");
      DUf.add("file://" + q.B(locale3.fOK()));
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.URLFilter", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s", new Object[] { q.B(locale1.fOK()), q.B(locale2.fOK()) });
      localObject = new e((String)localObject, "emoji/res");
      DUf.add("file://" + q.B(((e)localObject).fOK()));
      locale1 = new e(b.arU(), "emoji/res");
      DUf.add("file://" + q.B(locale1.fOK()));
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.URLFilter", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s", new Object[] { q.B(((e)localObject).fOK()), q.B(locale1.fOK()) });
      localObject = DUf.iterator();
      while (((Iterator)localObject).hasNext()) {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.URLFilter", "WebViewUI white list path : %s", new Object[] { (String)((Iterator)localObject).next() });
      }
      AppMethodBeat.o(78986);
      return;
    }
  }
  
  public static boolean aHn(String paramString)
  {
    AppMethodBeat.i(78985);
    if (ac.iOK)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.URLFilter", "skipLoadUrlCheck");
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
      if (!paramString.getHost().contains(com.tencent.luggage.h.g.Fs()))
      {
        AppMethodBeat.o(78985);
        return true;
      }
      AppMethodBeat.o(78985);
      return false;
    }
    Iterator localIterator = DUf.iterator();
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