package com.tencent.mm.plugin.webview.model;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.n;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class aj
{
  private static final Set<String> uWd;
  
  static
  {
    AppMethodBeat.i(6696);
    Object localObject = new HashSet();
    uWd = (Set)localObject;
    ((Set)localObject).add("file:///android_asset/");
    localObject = e.eQw;
    if (!bo.isNullOrNil((String)localObject)) {
      localObject = e.eQw.replace("/data/user/0", "/data/data");
    }
    for (;;)
    {
      File localFile1 = new File(aa.Jk(0));
      uWd.add("file://" + localFile1.getAbsolutePath());
      uWd.add("file://" + ((n)g.E(n.class)).cYZ());
      File localFile2 = new File(e.eQz, aa.Ji(0));
      uWd.add("file://" + localFile2.getAbsolutePath());
      File localFile3 = new File((String)localObject, "wenote/res");
      uWd.add("file://" + localFile3.getAbsolutePath());
      localFile3 = new File(e.eQz, "wenote/res");
      uWd.add("file://" + localFile3.getAbsolutePath());
      ab.i("MicroMsg.URLFilter", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s", new Object[] { localFile1.getAbsolutePath(), localFile2.getAbsolutePath() });
      localObject = new File((String)localObject, "emoji/res");
      uWd.add("file://" + ((File)localObject).getAbsolutePath());
      localFile1 = new File(e.eQz, "emoji/res");
      uWd.add("file://" + localFile1.getAbsolutePath());
      ab.i("MicroMsg.URLFilter", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s", new Object[] { ((File)localObject).getAbsolutePath(), localFile1.getAbsolutePath() });
      localObject = uWd.iterator();
      while (((Iterator)localObject).hasNext()) {
        ab.i("MicroMsg.URLFilter", "WebViewUI white list path : %s", new Object[] { (String)((Iterator)localObject).next() });
      }
      AppMethodBeat.o(6696);
      return;
    }
  }
  
  public static boolean ahc(String paramString)
  {
    AppMethodBeat.i(6695);
    if (ae.gkH)
    {
      ab.w("MicroMsg.URLFilter", "skipLoadUrlCheck");
      AppMethodBeat.o(6695);
      return true;
    }
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(6695);
      return true;
    }
    paramString = paramString.toLowerCase();
    if (paramString.startsWith("about:blank"))
    {
      AppMethodBeat.o(6695);
      return false;
    }
    if (!paramString.startsWith("file://"))
    {
      paramString = Uri.parse(paramString);
      if (bo.isNullOrNil(paramString.getHost()))
      {
        AppMethodBeat.o(6695);
        return true;
      }
      if (!paramString.getHost().contains(u.bQm()))
      {
        AppMethodBeat.o(6695);
        return true;
      }
      AppMethodBeat.o(6695);
      return false;
    }
    Iterator localIterator = uWd.iterator();
    while (localIterator.hasNext()) {
      if (paramString.startsWith((String)localIterator.next()))
      {
        AppMethodBeat.o(6695);
        return true;
      }
    }
    AppMethodBeat.o(6695);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.aj
 * JD-Core Version:    0.7.0.1
 */