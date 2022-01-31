package com.tencent.mm.plugin.webview.modelcache.downloaderimpl;

import com.tencent.mm.pluginsdk.g.a.c.m;
import com.tencent.mm.pluginsdk.g.a.c.q;
import com.tencent.mm.pluginsdk.g.a.c.q.a;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.sdk.platformtools.y;

final class b
{
  static void c(String paramString, m paramm)
  {
    s locals = q.a.clL().Wl(paramString);
    if (locals == null)
    {
      y.e("MicroMsg.ResDownloader.WebViewCache.DoResponseLogic", "networkRequest already completed, but get null record with urlKey = %s", new Object[] { paramString });
      return;
    }
    if (!"WebViewCache".equals(locals.field_groupId1))
    {
      y.e("MicroMsg.ResDownloader.WebViewCache.DoResponseLogic", "mismatch groupId, urlKey = %s, record.groupId = %s", new Object[] { paramString, locals.field_groupId1 });
      return;
    }
    locals.field_contentType = paramm.aRN;
    q.a.clL().g(locals);
    paramString = new f(locals.field_url, locals.field_filePath, locals.field_fileVersion, locals.field_appId, locals.field_groupId2, locals.field_packageId, locals.field_wvCacheType, paramm.aRN, paramm.ceJ, paramm.rXE);
    WebViewCacheDownloadHelper.ccz();
    WebViewCacheDownloadHelper.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modelcache.downloaderimpl.b
 * JD-Core Version:    0.7.0.1
 */