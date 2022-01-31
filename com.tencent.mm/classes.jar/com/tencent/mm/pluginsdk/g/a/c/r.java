package com.tencent.mm.pluginsdk.g.a.c;

import android.annotation.SuppressLint;
import com.tencent.mm.pluginsdk.g.a.a.b.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@SuppressLint({"UseSparseArrays"})
public final class r
{
  private static final HashMap<Integer, g> rXR;
  private static volatile List<g> rXS;
  
  static
  {
    Object localObject = new HashMap(2);
    rXR = (HashMap)localObject;
    ((HashMap)localObject).put(Integer.valueOf("CheckResUpdatePlugin".hashCode()), new b.a());
    try
    {
      localObject = Class.forName("com.tencent.mm.plugin.webview.modelcache.downloaderimpl.WebViewCacheDownloadHelper$ResDownloaderPlugin").newInstance();
      rXR.put(Integer.valueOf("WebViewCacheDownload".hashCode()), (g)localObject);
      rXS = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.ResDownloaderPluginMap", localException, "", new Object[0]);
      }
    }
  }
  
  public static Collection<g> clM()
  {
    if (rXS != null) {
      return rXS;
    }
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = rXR.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      g localg = (g)rXR.get(Integer.valueOf(i));
      if (localg != null) {
        localLinkedList.add(localg);
      }
    }
    rXS = localLinkedList;
    return localLinkedList;
  }
  
  public static void init() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.c.r
 * JD-Core Version:    0.7.0.1
 */