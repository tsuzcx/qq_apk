package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.plugin.webview.modelcache.a;
import com.tencent.mm.plugin.webview.modelcache.a.a;
import com.tencent.mm.plugin.webview.modelcache.a.b;
import com.tencent.mm.plugin.webview.modelcache.downloaderimpl.WebViewCacheDownloadHelper;
import com.tencent.mm.plugin.webview.modelcache.f;
import com.tencent.mm.plugin.webview.modelcache.k;
import com.tencent.mm.plugin.webview.modelcache.q.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.vfs.e;
import java.util.Iterator;
import java.util.List;

final class g$122
  implements Runnable
{
  g$122(g paramg, String paramString) {}
  
  public final void run()
  {
    Object localObject1 = null;
    q.a.ccy();
    String str = this.rAG;
    Object localObject2;
    if (!bk.bl(str))
    {
      localObject2 = k.ccv();
      if (!((k)localObject2).gaO)
      {
        if (bk.dk((List)localObject1)) {
          break label285;
        }
        localObject1 = ((List)localObject1).iterator();
      }
    }
    label47:
    label324:
    label327:
    for (;;)
    {
      Object localObject3;
      if (((Iterator)localObject1).hasNext())
      {
        localObject3 = (f)((Iterator)localObject1).next();
        localObject2 = a.Su(((f)localObject3).field_appId);
        if (localObject2 == null) {
          continue;
        }
        localObject3 = ((f)localObject3).field_localPath;
        if (bk.bl((String)localObject3)) {
          continue;
        }
        if (!((String)localObject3).startsWith(((a)localObject2).path)) {
          break label324;
        }
      }
      for (long l = e.aeQ((String)localObject3);; l = 0L)
      {
        if ((!e.deleteFile((String)localObject3)) || (!((String)localObject3).startsWith(((a)localObject2).path))) {
          break label327;
        }
        localObject3 = ((a)localObject2).rgX;
        localObject2 = ((a)localObject2).appId;
        if (!((a.b)localObject3).gaO) {
          break label47;
        }
        a.a locala = new a.a((byte)0);
        locala.field_appId = ((String)localObject2);
        if (!((a.b)localObject3).b(locala, new String[0])) {
          break label47;
        }
        locala.field_occupation = Math.max(0L, locala.field_occupation - l);
        ((a.b)localObject3).c(locala, new String[0]);
        break label47;
        if (bk.bl(str)) {
          break;
        }
        localObject1 = ((k)localObject2).m(String.format("select * from %s where %s=? ", new Object[] { "WebViewResourceCache", "domain" }), new String[] { str });
        break;
        localObject1 = k.ccv();
        if ((!((k)localObject1).gaO) || (bk.bl(str))) {}
        for (;;)
        {
          WebViewCacheDownloadHelper.ccA();
          return;
          localObject2 = new f();
          ((f)localObject2).field_domain = str;
          ((k)localObject1).a((c)localObject2, new String[] { "domain" });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.122
 * JD-Core Version:    0.7.0.1
 */