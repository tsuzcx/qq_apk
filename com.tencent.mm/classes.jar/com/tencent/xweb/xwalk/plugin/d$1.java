package com.tencent.xweb.xwalk.plugin;

import com.tencent.xweb.util.e;
import com.tencent.xweb.xwalk.a.a;
import com.tencent.xweb.xwalk.a.a.c;
import com.tencent.xweb.xwalk.a.a.d;
import com.tencent.xweb.xwalk.a.f.c;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xwalk.core.Log;
import org.xwalk.core.NetworkUtil;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkLibraryLoader.DownloadListener;
import org.xwalk.core.XWalkLibraryLoader.HttpDownloadTask;
import org.xwalk.core.XWalkLibraryLoader.WXFileDownloaderTask;

final class d$1
  implements com.tencent.xweb.xwalk.a.b
{
  d$1(d paramd) {}
  
  private static com.tencent.xweb.xwalk.a.a.b a(a.d paramd, int paramInt)
  {
    if ((paramd == null) || (paramd.xmY == null) || (paramd.xmY.length == 0))
    {
      paramd = null;
      return paramd;
    }
    com.tencent.xweb.xwalk.a.a.b[] arrayOfb = paramd.xmY;
    int j = arrayOfb.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label65;
      }
      com.tencent.xweb.xwalk.a.a.b localb = arrayOfb[i];
      paramd = localb;
      if (localb.xmR == paramInt) {
        break;
      }
      i += 1;
    }
    label65:
    return null;
  }
  
  private static a.d a(a.c paramc, String paramString, int paramInt)
  {
    if ((paramc == null) || (paramc.xmU == null) || (paramc.xmU.length == 0) || (paramString == null) || (paramString.isEmpty()))
    {
      Log.e("XWalkPluginUp", "findMatchedPluginInfo params error");
      paramc = null;
      return paramc;
    }
    a.d[] arrayOfd = paramc.xmU;
    int j = arrayOfd.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label108;
      }
      a.d locald = arrayOfd[i];
      if ((paramString.equals(locald.xmV)) && (locald.xmW > paramInt))
      {
        paramc = locald;
        if (locald.xiX.cSF()) {
          break;
        }
      }
      i += 1;
    }
    label108:
    return null;
  }
  
  public final void a(f.c paramc)
  {
    e.cTm();
    paramc = paramc.mFilePath;
    if (paramc == null)
    {
      XWalkInitializer.addXWalkInitializeLog("parse plugin config failed ,path is empty");
      paramc = null;
    }
    while (paramc == null)
    {
      XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "parse plugin config failed");
      e.cTo();
      d.a(this.xmH, -6);
      return;
      paramc = new File(paramc);
      if (!paramc.exists())
      {
        XWalkInitializer.addXWalkInitializeLog("parse plugin config failed ,file not exist");
        paramc = null;
      }
      else
      {
        paramc = a.j(paramc, a.a(paramc, (int)paramc.length(), "<Plugins>"));
      }
    }
    if ((paramc.xmU == null) || (paramc.xmU.length == 0))
    {
      XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "plugin config contains no plugin");
      d.a(this.xmH, -7);
      return;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = XWalkPluginManager.cTF().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb == null) {
        XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "process plugin null");
      } else {
        label736:
        if ((d.a(this.xmH)) && (!d.b(this.xmH).equals(localb.cTE())))
        {
          XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "set only update " + d.b(this.xmH) + ", skip " + localb.cTE());
        }
        else
        {
          XWalkEnvironment.isForbidDownloadCode();
          int i = localb.xmr;
          Object localObject1 = a(paramc, localb.cTE(), i);
          label622:
          if (localObject1 == null)
          {
            XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "no matched plugin version, skip " + localb.cTE());
          }
          else
          {
            c.a locala = new c.a();
            locala.version = ((a.d)localObject1).xmW;
            Object localObject2 = a((a.d)localObject1, i);
            if (localObject2 == null)
            {
              locala.url = ((a.d)localObject1).xmS;
              locala.bIW = ((a.d)localObject1).xmN;
              locala.path = localb.az(locala.version, false);
              locala.xmw = ((a.d)localObject1).xmT;
              locala.xmx = ((a.d)localObject1).bUseCdn;
            }
            for (locala.isPatch = false;; locala.isPatch = true)
            {
              if ((locala.path != null) && (!locala.path.isEmpty())) {
                break label509;
              }
              XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "download path is empty, skip " + localb.cTE());
              break;
              locala.url = ((com.tencent.xweb.xwalk.a.a.b)localObject2).xmS;
              locala.bIW = ((com.tencent.xweb.xwalk.a.a.b)localObject2).xmN;
              locala.path = localb.az(locala.version, true);
              locala.xmw = ((com.tencent.xweb.xwalk.a.a.b)localObject2).xmT;
              locala.xmx = ((com.tencent.xweb.xwalk.a.a.b)localObject2).bUseCdn;
            }
            label509:
            if (!NetworkUtil.isNetworkAvailable())
            {
              XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "network is not available, skip " + localb.cTE());
            }
            else if ((!locala.xmw) && (!NetworkUtil.isWifiAvailable()))
            {
              XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "can not use cellular, skip " + localb.cTE());
            }
            else
            {
              localObject1 = new d.b();
              localObject2 = new d.c(this.xmH, localb, locala);
              if (locala.isPatch)
              {
                i = 2;
                XWalkLibraryLoader.WXFileDownloaderTask localWXFileDownloaderTask = new XWalkLibraryLoader.WXFileDownloaderTask(false, (XWalkLibraryLoader.DownloadListener)localObject2, locala.url, locala.path, i);
                if ((!locala.xmx) || (!localWXFileDownloaderTask.isValid())) {
                  break label736;
                }
                XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "use wx file downloader, plugin: " + localb.cTE() + "isPatch: " + locala.isPatch);
                ((d.b)localObject1).eFk = localWXFileDownloaderTask;
              }
              for (((d.b)localObject1).type = 2;; ((d.b)localObject1).type = 1)
              {
                localHashMap.put(localb.cTE(), localObject1);
                break;
                i = 1;
                break label622;
                XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "use default file downloader, plugin: " + localb.cTE() + "isPatch: " + locala.isPatch);
                ((d.b)localObject1).eFk = new XWalkLibraryLoader.HttpDownloadTask(false, (XWalkLibraryLoader.DownloadListener)localObject2, locala.url, locala.path);
              }
            }
          }
        }
      }
    }
    if (localHashMap.size() == 0)
    {
      XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "no available update, no task");
      d.a(this.xmH, -8);
      return;
    }
    d.a(this.xmH, localHashMap);
  }
  
  public final void b(f.c paramc)
  {
    XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "plugin config download failed: " + paramc.xnx);
    e.cTn();
    d.a(this.xmH, -5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.xwalk.plugin.d.1
 * JD-Core Version:    0.7.0.1
 */