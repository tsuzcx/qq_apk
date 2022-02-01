package com.tencent.mm.plugin.webview.model;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class ak
{
  private static final Set<String> CqC;
  
  static
  {
    AppMethodBeat.i(78986);
    Object localObject = new HashSet();
    CqC = (Set)localObject;
    ((Set)localObject).add("file:///android_asset/");
    localObject = b.apa();
    if (!bs.isNullOrNil((String)localObject)) {
      localObject = b.apa().replace("/data/user/0", "/data/data");
    }
    for (;;)
    {
      e locale1 = new e(z.Un(0));
      CqC.add("file://" + q.B(locale1.fxV()));
      CqC.add("file://" + ((i)com.tencent.mm.kernel.g.ab(i.class)).ewV());
      e locale2 = new e(b.aph(), z.exl());
      CqC.add("file://" + q.B(locale2.fxV()));
      e locale3 = new e((String)localObject, "wenote/res");
      CqC.add("file://" + q.B(locale3.fxV()));
      locale3 = new e(b.aph(), "wenote/res");
      CqC.add("file://" + q.B(locale3.fxV()));
      ac.i("MicroMsg.URLFilter", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s", new Object[] { q.B(locale1.fxV()), q.B(locale2.fxV()) });
      localObject = new e((String)localObject, "emoji/res");
      CqC.add("file://" + q.B(((e)localObject).fxV()));
      locale1 = new e(b.aph(), "emoji/res");
      CqC.add("file://" + q.B(locale1.fxV()));
      ac.i("MicroMsg.URLFilter", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s", new Object[] { q.B(((e)localObject).fxV()), q.B(locale1.fxV()) });
      localObject = CqC.iterator();
      while (((Iterator)localObject).hasNext()) {
        ac.i("MicroMsg.URLFilter", "WebViewUI white list path : %s", new Object[] { (String)((Iterator)localObject).next() });
      }
      AppMethodBeat.o(78986);
      return;
    }
  }
  
  public static boolean aBN(String paramString)
  {
    AppMethodBeat.i(78985);
    if (ab.ivD)
    {
      ac.w("MicroMsg.URLFilter", "skipLoadUrlCheck");
      AppMethodBeat.o(78985);
      return true;
    }
    if (bs.isNullOrNil(paramString))
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
      if (bs.isNullOrNil(paramString.getHost()))
      {
        AppMethodBeat.o(78985);
        return true;
      }
      if (!paramString.getHost().contains(com.tencent.luggage.h.g.DS()))
      {
        AppMethodBeat.o(78985);
        return true;
      }
      AppMethodBeat.o(78985);
      return false;
    }
    Iterator localIterator = CqC.iterator();
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