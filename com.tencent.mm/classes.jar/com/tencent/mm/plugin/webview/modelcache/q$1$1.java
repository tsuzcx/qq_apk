package com.tencent.mm.plugin.webview.modelcache;

import android.util.SparseArray;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.pluginsdk.g.a.b.d;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.net.SocketTimeoutException;
import java.util.Iterator;
import java.util.List;

final class q$1$1
  implements Runnable
{
  q$1$1(q.1 param1, com.tencent.mm.plugin.webview.modelcache.downloaderimpl.f paramf) {}
  
  public final void run()
  {
    com.tencent.mm.plugin.webview.modelcache.downloaderimpl.f localf = this.rhE;
    if (localf == null) {}
    label166:
    label350:
    label1387:
    label1399:
    label1916:
    label1919:
    for (;;)
    {
      return;
      if ((bk.bl(localf.appId)) || (bk.bl(localf.ceG)) || (bk.bl(localf.filePath)))
      {
        y.i("MicroMsg.WebViewCacheDownloadResponseLogic", "onResponse, invalid response = %s", new Object[] { localf });
        return;
      }
      y.i("MicroMsg.WebViewCacheDownloadResponseLogic", "onResponse, response = %s", new Object[] { localf });
      List localList = q.a.ccy().rhA.s(localf.url, localf.appId, localf.ceG, localf.ceH);
      Object localObject1 = localf.exception;
      Object localObject3;
      Object localObject4;
      Object localObject5;
      Object localObject2;
      if (localObject1 != null)
      {
        y.i("MicroMsg.WebViewCacheDownloadResponseLogic", "onResponse, response.exception = %s", new Object[] { localObject1 });
        if (!bk.dk(localList))
        {
          if ((localObject1 instanceof SocketTimeoutException))
          {
            localObject1 = "timeout";
            localObject3 = localList.iterator();
          }
          for (;;)
          {
            if (!((Iterator)localObject3).hasNext()) {
              break label388;
            }
            localObject4 = (e.c)((Iterator)localObject3).next();
            localObject5 = h.Db(((e.c)localObject4).rhg);
            i = ((e.c)localObject4).rhh;
            if (localf.ceI == 3) {}
            for (localObject2 = "publicCache";; localObject2 = "cache")
            {
              ((com.tencent.mm.plugin.webview.ui.tools.jsapi.g)localObject5).A(i, (String)localObject2, (String)localObject1);
              if (localf.ceI != 1) {
                break label350;
              }
              q.a.ccy().rhA.a(((e.c)localObject4).rhg, localf.appId, localf.ceG, localf.ceH, localf.ceI, localf.url);
              break label166;
              if ((localObject1 instanceof d))
              {
                localObject1 = "not support redirect resource";
                break;
              }
              if ((localObject1 instanceof com.tencent.mm.pluginsdk.g.a.b.g))
              {
                localObject1 = "not support 0kb resource";
                break;
              }
              if (((localObject1 instanceof com.tencent.mm.pluginsdk.g.a.b.a)) && (localf.ceJ >= 5242880L))
              {
                localObject1 = "exceed cache threshold";
                break;
              }
              localObject1 = "batch download fail";
              break;
            }
            q.a.ccy().rhA.a(((e.c)localObject4).rhg, localf.appId, localf.ceG, localf.ceH, localf.ceI);
          }
        }
      }
      for (int i = 1; i != 0; i = 0)
      {
        m.gR(7L);
        return;
      }
      if (com.tencent.mm.a.e.bJ(localf.filePath) == 0)
      {
        y.i("MicroMsg.WebViewCacheDownloadResponseLogic", "onResponse, readFileLength = 0, return");
        if (!bk.dk(localList))
        {
          localObject2 = localList.iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (e.c)((Iterator)localObject2).next();
            localObject4 = h.Db(((e.c)localObject3).rhg);
            i = ((e.c)localObject3).rhh;
            if (localf.ceI == 3) {}
            for (localObject1 = "publicCache";; localObject1 = "cache")
            {
              ((com.tencent.mm.plugin.webview.ui.tools.jsapi.g)localObject4).A(i, (String)localObject1, "batch download fail");
              q.a.ccy().rhA.a(((e.c)localObject3).rhg, localf.appId, localf.ceG, localf.ceH, localf.ceI, localf.url);
              break;
            }
          }
        }
        i = 0;
      }
      while (i == 0)
      {
        m.gR(8L);
        return;
        localObject4 = p.Sz(localf.url);
        localObject3 = q.a.ccy();
        localObject5 = localf.appId;
        Object localObject6 = localf.ceG;
        i = localf.ceI;
        String str1 = localf.ceH;
        if ((bk.bl((String)localObject5)) || (bk.bl((String)localObject6)) || (bk.bl((String)localObject4)))
        {
          y.e("MicroMsg.WebViewCacheWorkerManager", "getWebViewCacheWriter, invalid params | appId = %s, domain = %s, mainURL = %s", new Object[] { localObject5, localObject6, localObject4 });
          localObject2 = null;
          i = 0;
          if (localObject2 != null)
          {
            localObject1 = localf.filePath;
            localObject4 = localf.version;
            localObject5 = localf.aRN;
            if (!bk.bl((String)localObject1)) {
              break label939;
            }
            y.e("MicroMsg.WebViewCacheResWriter", "writeRes with filePath, filePath is null or nil");
            i = -1;
            if (i != 0) {
              break label1387;
            }
            i = 1;
          }
          if (i != 0) {
            break label1442;
          }
          if (bk.dk(localList)) {
            break label1437;
          }
          localObject2 = localList.iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label1437;
          }
          localObject3 = (e.c)((Iterator)localObject2).next();
          localObject4 = h.Db(((e.c)localObject3).rhg);
          i = ((e.c)localObject3).rhh;
          if (localf.ceI == 3) {}
          for (localObject1 = "publicCache";; localObject1 = "cache")
          {
            ((com.tencent.mm.plugin.webview.ui.tools.jsapi.g)localObject4).A(i, (String)localObject1, "batch save fail");
            if (localf.ceI != 1) {
              break label1399;
            }
            q.a.ccy().rhA.a(((e.c)localObject3).rhg, localf.appId, localf.ceG, localf.ceH, localf.ceI, localf.url);
            break label732;
            int j = String.format("%s_%s_%s_%s", new Object[] { localObject5, localObject6, Integer.valueOf(i), localObject4 }).hashCode();
            localObject2 = (l)((q)localObject3).rhy.get(j);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = new l((String)localObject5, (String)localObject6, i, (String)localObject4, str1);
              ((q)localObject3).rhy.put(j, localObject1);
            }
            localObject2 = localObject1;
            break;
            if (!com.tencent.mm.a.e.bK((String)localObject1))
            {
              y.e("MicroMsg.WebViewCacheResWriter", "writeRes with filePath, file not exists");
              i = -1;
              break label705;
            }
            if (com.tencent.mm.a.e.bJ((String)localObject1) <= 0)
            {
              y.i("MicroMsg.WebViewCacheResWriter", "writeRes with filePath, file size = 0kb");
              i = 6;
              break label705;
            }
            if (bk.bl((String)localObject4))
            {
              y.e("MicroMsg.WebViewCacheResWriter", "writeRes with filePath, resVersion is null or nil, return");
              i = -1;
              break label705;
            }
            if (((l)localObject2).rhm == null)
            {
              y.e("MicroMsg.WebViewCacheResWriter", "writeRes with filePath, appIdDir is null, return");
              i = -1;
              break label705;
            }
            localObject3 = ((l)localObject2).rhm;
            localObject6 = ((l)localObject2).bTY;
            long l1;
            String str2;
            String str3;
            if ((bk.bl((String)localObject1)) || (bk.bl((String)localObject6)))
            {
              l1 = 0L;
              localObject6 = k.ccv();
              localObject1 = ((l)localObject2).appId;
              str1 = ((l)localObject2).ceG;
              i = ((l)localObject2).ceI;
              str2 = ((l)localObject2).rhl;
              str3 = ((l)localObject2).ceH;
              if (!((k)localObject6).gaO) {
                break label1307;
              }
              if ((!bk.bl((String)localObject1)) && (!bk.bl(str1)) && (!bk.bl(str2)) && (!bk.bl(str3))) {
                break label1210;
              }
              localObject1 = null;
            }
            for (;;)
            {
              if (localObject1 != null) {
                break label1313;
              }
              y.e("MicroMsg.WebViewCacheResWriter", "writeRes with filePath, no db record stored");
              i = -1;
              break;
              long l2 = com.tencent.mm.vfs.e.r((String)localObject1, (String)localObject6);
              l1 = l2;
              if (l2 <= 0L) {
                break label1054;
              }
              l1 = l2;
              if (!((String)localObject6).startsWith(((a)localObject3).path)) {
                break label1054;
              }
              a.b.a(((a)localObject3).rgX, ((a)localObject3).appId, l2);
              l1 = l2;
              break label1054;
              localObject3 = new f();
              ((f)localObject3).field_appId = ((String)localObject1);
              ((f)localObject3).field_domain = str1;
              ((f)localObject3).field_cacheType = i;
              ((f)localObject3).field_urlMd5Hashcode = ad.bB(str2).hashCode();
              ((f)localObject3).field_packageId = str3;
              localObject1 = localObject3;
              if (!((k)localObject6).b((c)localObject3, new String[] { "appId", "domain", "cacheType", "urlMd5Hashcode", "packageId" })) {
                localObject1 = null;
              }
            }
            ((f)localObject1).field_localPath = ((l)localObject2).bTY;
            ((f)localObject1).field_version = ((String)localObject4);
            ((f)localObject1).field_contentType = ((String)localObject5);
            ((f)localObject1).field_contentMd5 = p.SC(((f)localObject1).field_localPath);
            ((f)localObject1).field_contentLength = l1;
            k.ccv().b((f)localObject1);
            y.i("MicroMsg.WebViewCacheResWriter", "writeRes with filePath, updated record = %s", new Object[] { localObject1 });
            i = 0;
            break label705;
            i = 0;
            break label711;
          }
          q.a.ccy().rhA.a(((e.c)localObject3).rhg, localf.appId, localf.ceG, localf.ceH, localf.ceI);
        }
        i = 0;
        continue;
        i = 1;
      }
      if (localf.ceI == 1)
      {
        if (!bk.dk(localList))
        {
          localObject1 = localList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (e.c)((Iterator)localObject1).next();
            h.Db(((e.c)localObject2).rhg).A(((e.c)localObject2).rhh, "cache", "ok");
            q.a.ccy().rhA.a(((e.c)localObject2).rhg, localf.appId, localf.ceG, localf.ceH, localf.ceI, localf.url);
          }
        }
      }
      else
      {
        localObject1 = k.ccv();
        localObject2 = localf.appId;
        localObject3 = localf.ceG;
        localObject4 = localf.ceH;
        boolean bool;
        if (!((k)localObject1).gaO)
        {
          localObject1 = null;
          if (bk.dk((List)localObject1)) {
            break label1843;
          }
          localObject1 = ((List)localObject1).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label1916;
          }
          localObject2 = (f)((Iterator)localObject1).next();
          if (localObject2 != null) {
            break label1845;
          }
          bool = false;
          if (bool) {
            break label1908;
          }
        }
        for (i = 0;; i = 1)
        {
          if ((i == 0) || (bk.dk(localList))) {
            break label1919;
          }
          localObject1 = localList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (e.c)((Iterator)localObject1).next();
            h.Db(((e.c)localObject2).rhg).A(((e.c)localObject2).rhh, "cache", "ok");
            q.a.ccy().rhA.a(((e.c)localObject2).rhg, localf.appId, localf.ceG, localf.ceH, localf.ceI);
          }
          break;
          if ((bk.bl((String)localObject2)) || (bk.bl((String)localObject3)) || (bk.bl((String)localObject4)))
          {
            localObject1 = null;
            break label1596;
          }
          localObject1 = ((k)localObject1).m(String.format("select * from %s where %s=? and %s=? and %s=?", new Object[] { "WebViewResourceCache", "appId", "domain", "packageId" }), new String[] { localObject2, localObject3, localObject4 });
          break label1596;
          break;
          if ((!bk.bl(((f)localObject2).field_contentMd5)) && (bk.pm(p.SC(((f)localObject2).field_localPath)).equals(((f)localObject2).field_contentMd5))) {}
          for (bool = true;; bool = false)
          {
            y.d("MicroMsg.WebViewCacheUtils", "isCacheResValid, cacheRes = %s, ret = %b", new Object[] { localObject2, Boolean.valueOf(bool) });
            break label1643;
            break;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modelcache.q.1.1
 * JD-Core Version:    0.7.0.1
 */