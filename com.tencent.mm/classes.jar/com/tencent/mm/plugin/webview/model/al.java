package com.tencent.mm.plugin.webview.model;

import android.net.Uri;
import com.tencent.luggage.h.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class al
{
  private static final Set<String> IZe;
  
  static
  {
    AppMethodBeat.i(78986);
    Object localObject = new HashSet();
    IZe = (Set)localObject;
    ((Set)localObject).add("file:///android_asset/");
    localObject = b.aKC();
    if (!Util.isNullOrNil((String)localObject)) {
      localObject = b.aKC().replace("/data/user/0", "/data/data");
    }
    for (;;)
    {
      o localo1 = new o(ai.afw(0));
      IZe.add("file://" + aa.z(localo1.her()));
      IZe.add("file://" + ((j)g.af(j.class)).fXy());
      o localo2 = new o(b.aKJ(), ai.afv(0));
      IZe.add("file://" + aa.z(localo2.her()));
      o localo3 = new o((String)localObject, "wenote/res");
      IZe.add("file://" + aa.z(localo3.her()));
      localo3 = new o(b.aKJ(), "wenote/res");
      IZe.add("file://" + aa.z(localo3.her()));
      Log.i("MicroMsg.URLFilter", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s", new Object[] { aa.z(localo1.her()), aa.z(localo2.her()) });
      localObject = new o((String)localObject, "emoji/res");
      IZe.add("file://" + aa.z(((o)localObject).her()));
      localo1 = new o(b.aKJ(), "emoji/res");
      IZe.add("file://" + aa.z(localo1.her()));
      Log.i("MicroMsg.URLFilter", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s", new Object[] { aa.z(((o)localObject).her()), aa.z(localo1.her()) });
      localObject = IZe.iterator();
      while (((Iterator)localObject).hasNext()) {
        Log.i("MicroMsg.URLFilter", "WebViewUI white list path : %s", new Object[] { (String)((Iterator)localObject).next() });
      }
      AppMethodBeat.o(78986);
      return;
    }
  }
  
  public static boolean aYH(String paramString)
  {
    AppMethodBeat.i(78985);
    if (ac.jOz)
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
      if (!paramString.getHost().contains(h.Ph()))
      {
        AppMethodBeat.o(78985);
        return true;
      }
      AppMethodBeat.o(78985);
      return false;
    }
    Iterator localIterator = IZe.iterator();
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