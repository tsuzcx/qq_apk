package com.tencent.mm.plugin.webview.model;

import android.net.Uri;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class ae
{
  private static final Set<String> rfP;
  
  static
  {
    Object localObject1 = new HashSet();
    rfP = (Set)localObject1;
    ((Set)localObject1).add("file:///android_asset/");
    Object localObject2 = e.dOQ;
    localObject1 = localObject2;
    if (!bk.bl((String)localObject2)) {
      localObject1 = e.dOQ.replace("/data/user/0", "/data/data");
    }
    localObject2 = new File(aa.Bw(0));
    rfP.add("file://" + ((File)localObject2).getAbsolutePath());
    File localFile1 = new File(e.bkH, aa.Bu(0));
    rfP.add("file://" + localFile1.getAbsolutePath());
    File localFile2 = new File((String)localObject1, "wenote/res");
    rfP.add("file://" + localFile2.getAbsolutePath());
    localFile2 = new File(e.bkH, "wenote/res");
    rfP.add("file://" + localFile2.getAbsolutePath());
    y.i("MicroMsg.URLFilter", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s", new Object[] { ((File)localObject2).getAbsolutePath(), localFile1.getAbsolutePath() });
    localObject1 = new File((String)localObject1, "emoji/res");
    rfP.add("file://" + ((File)localObject1).getAbsolutePath());
    localObject2 = new File(e.bkH, "emoji/res");
    rfP.add("file://" + ((File)localObject2).getAbsolutePath());
    y.i("MicroMsg.URLFilter", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s", new Object[] { ((File)localObject1).getAbsolutePath(), ((File)localObject2).getAbsolutePath() });
    localObject1 = rfP.iterator();
    while (((Iterator)localObject1).hasNext()) {
      y.i("MicroMsg.URLFilter", "WebViewUI white list path : %s", new Object[] { (String)((Iterator)localObject1).next() });
    }
  }
  
  public static boolean Sg(String paramString)
  {
    if (com.tencent.mm.platformtools.ae.eSM)
    {
      y.w("MicroMsg.URLFilter", "skipLoadUrlCheck");
      return true;
    }
    if (bk.bl(paramString)) {
      return true;
    }
    paramString = paramString.toLowerCase();
    if (paramString.startsWith("about:blank")) {
      return false;
    }
    if (!paramString.startsWith("file://"))
    {
      paramString = Uri.parse(paramString);
      if (bk.bl(paramString.getHost())) {
        return true;
      }
      return !paramString.getHost().contains(s.bil());
    }
    Iterator localIterator = rfP.iterator();
    while (localIterator.hasNext()) {
      if (paramString.startsWith((String)localIterator.next())) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ae
 * JD-Core Version:    0.7.0.1
 */