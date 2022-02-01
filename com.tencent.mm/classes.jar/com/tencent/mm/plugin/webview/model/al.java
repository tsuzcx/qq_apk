package com.tencent.mm.plugin.webview.model;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class al
{
  private static final Set<String> Eme;
  
  static
  {
    AppMethodBeat.i(78986);
    Object localObject = new HashSet();
    Eme = (Set)localObject;
    ((Set)localObject).add("file:///android_asset/");
    localObject = b.asc();
    if (!bu.isNullOrNil((String)localObject)) {
      localObject = b.asc().replace("/data/user/0", "/data/data");
    }
    for (;;)
    {
      k localk1 = new k(ad.WN(0));
      Eme.add("file://" + w.B(localk1.fTh()));
      Eme.add("file://" + ((j)com.tencent.mm.kernel.g.ab(j.class)).ePs());
      k localk2 = new k(b.asj(), ad.ePL());
      Eme.add("file://" + w.B(localk2.fTh()));
      k localk3 = new k((String)localObject, "wenote/res");
      Eme.add("file://" + w.B(localk3.fTh()));
      localk3 = new k(b.asj(), "wenote/res");
      Eme.add("file://" + w.B(localk3.fTh()));
      ae.i("MicroMsg.URLFilter", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s", new Object[] { w.B(localk1.fTh()), w.B(localk2.fTh()) });
      localObject = new k((String)localObject, "emoji/res");
      Eme.add("file://" + w.B(((k)localObject).fTh()));
      localk1 = new k(b.asj(), "emoji/res");
      Eme.add("file://" + w.B(localk1.fTh()));
      ae.i("MicroMsg.URLFilter", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s", new Object[] { w.B(((k)localObject).fTh()), w.B(localk1.fTh()) });
      localObject = Eme.iterator();
      while (((Iterator)localObject).hasNext()) {
        ae.i("MicroMsg.URLFilter", "WebViewUI white list path : %s", new Object[] { (String)((Iterator)localObject).next() });
      }
      AppMethodBeat.o(78986);
      return;
    }
  }
  
  public static boolean aIG(String paramString)
  {
    AppMethodBeat.i(78985);
    if (ac.iRE)
    {
      ae.w("MicroMsg.URLFilter", "skipLoadUrlCheck");
      AppMethodBeat.o(78985);
      return true;
    }
    if (bu.isNullOrNil(paramString))
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
      if (bu.isNullOrNil(paramString.getHost()))
      {
        AppMethodBeat.o(78985);
        return true;
      }
      if (!paramString.getHost().contains(com.tencent.luggage.h.g.Fy()))
      {
        AppMethodBeat.o(78985);
        return true;
      }
      AppMethodBeat.o(78985);
      return false;
    }
    Iterator localIterator = Eme.iterator();
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