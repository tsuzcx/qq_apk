package com.tencent.mm.plugin.webview.model;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class al
{
  private static final Set<String> PVx;
  
  static
  {
    AppMethodBeat.i(78986);
    Object localObject = new HashSet();
    PVx = (Set)localObject;
    ((Set)localObject).add("file:///android_asset/");
    localObject = b.aSE();
    if (!Util.isNullOrNil((String)localObject)) {
      localObject = b.aSE();
    }
    for (;;)
    {
      q localq1 = new q(ai.ank(0));
      PVx.add("file://" + localq1.bOF());
      PVx.add("file://" + ((j)com.tencent.mm.kernel.h.ae(j.class)).gQl());
      q localq2 = new q(b.aSL(), ai.anj(0));
      PVx.add("file://" + localq2.bOF());
      q localq3 = new q((String)localObject, "wenote/res");
      PVx.add("file://" + localq3.bOF());
      localq3 = new q(b.aSL(), "wenote/res");
      PVx.add("file://" + localq3.bOF());
      Log.i("MicroMsg.URLFilter", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s", new Object[] { localq1.bOF(), localq2.bOF() });
      localObject = new q((String)localObject, "emoji/res");
      PVx.add("file://" + ((q)localObject).bOF());
      localq1 = new q(b.aSL(), "emoji/res");
      PVx.add("file://" + localq1.bOF());
      Log.i("MicroMsg.URLFilter", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s", new Object[] { ((q)localObject).bOF(), localq1.bOF() });
      localObject = PVx.iterator();
      while (((Iterator)localObject).hasNext()) {
        Log.i("MicroMsg.URLFilter", "WebViewUI white list path : %s", new Object[] { (String)((Iterator)localObject).next() });
      }
      AppMethodBeat.o(78986);
      return;
    }
  }
  
  public static boolean bkB(String paramString)
  {
    AppMethodBeat.i(78985);
    if (ac.mFJ)
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
      if (!paramString.getHost().contains(com.tencent.luggage.k.h.SH()))
      {
        AppMethodBeat.o(78985);
        return true;
      }
      AppMethodBeat.o(78985);
      return false;
    }
    Iterator localIterator = PVx.iterator();
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