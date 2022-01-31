package com.tencent.mm.plugin.wepkg.downloader;

import com.tencent.mm.sdk.platformtools.y;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Future;

public final class d
{
  private static Object lock = new Object();
  private static volatile d rOp;
  HashMap<String, c> rOq = new HashMap();
  
  private boolean a(c paramc)
  {
    if (this.rOq.containsKey(paramc.rOg.rOD))
    {
      paramc.rOm = true;
      try
      {
        if (paramc.rOi != null) {
          paramc.rOi.disconnect();
        }
        if (paramc.rOh != null) {
          paramc.rOh.cancel(false);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.i("MicroMsg.Wepkg.WePkgDownloadTask", "stop, " + localException.getMessage());
        }
      }
      this.rOq.remove(paramc.rOg.rOD);
      return true;
    }
    return false;
  }
  
  public static d cjS()
  {
    if (rOp == null) {}
    synchronized (lock)
    {
      if (rOp == null) {
        rOp = new d();
      }
      return rOp;
    }
  }
  
  public final boolean Vc(String paramString)
  {
    if (this.rOq.containsKey(paramString)) {
      this.rOq.remove(paramString);
    }
    return true;
  }
  
  public final boolean cjT()
  {
    if ((this.rOq == null) || (this.rOq.size() == 0)) {
      return false;
    }
    Object localObject = this.rOq.values();
    ArrayList localArrayList = new ArrayList();
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add((c)((Iterator)localObject).next());
    }
    localObject = localArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      c localc = (c)((Iterator)localObject).next();
      if (localc.rOg.rOI) {
        a(localc);
      }
    }
    localArrayList.clear();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.downloader.d
 * JD-Core Version:    0.7.0.1
 */