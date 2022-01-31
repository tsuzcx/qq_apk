package com.tencent.mm.plugin.webview.modelcache;

import android.database.Cursor;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.List;

public final class k
  extends i<f>
{
  private static volatile k rhk = null;
  private final e dXw;
  public final boolean gaO;
  
  private k(e parame)
  {
    super(parame, f.buS, "WebViewResourceCache", null);
    this.dXw = parame;
    if (parame != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.gaO = bool;
      if (!this.gaO) {
        y.e("MicroMsg.WebViewCacheResStorage", "storage can not work!!!");
      }
      return;
    }
  }
  
  static String Cf(int paramInt)
  {
    String str = "1=1";
    if ((!b.a.Cc(paramInt)) || (!b.a.Cb(paramInt))) {
      str = String.format(" %s=%s ", new Object[] { "protocol", Integer.valueOf(paramInt) });
    }
    return str;
  }
  
  private boolean a(f paramf)
  {
    if (!this.gaO) {
      return false;
    }
    if (bk.bl(paramf.field_url))
    {
      y.d("MicroMsg.WebViewCacheResStorage", "insertWebViewCacheRes, url is null or nil");
      return false;
    }
    String str = ad.bB(paramf.field_url);
    if (bk.bl(str))
    {
      y.e("MicroMsg.WebViewCacheResStorage", "insertWebViewCacheRes, get md5 is null or nil , url = %s", new Object[] { paramf.field_url });
      return false;
    }
    paramf.field_urlMd5Hashcode = str.hashCode();
    long l = bk.UX();
    paramf.field_accessTime = l;
    paramf.field_createTime = l;
    return a(paramf, false);
  }
  
  public static List<d.a> ccu()
  {
    LinkedList localLinkedList = new LinkedList();
    String str = i.a(f.buS, "WebViewResourceCache");
    localLinkedList.add(new d.a("WEBVIEW_RESOURCE_CACHE_TABLE".hashCode(), new String[] { str }));
    return localLinkedList;
  }
  
  public static k ccv()
  {
    if (!au.DK()) {
      return new k(null);
    }
    if (rhk == null) {}
    try
    {
      if ((rhk == null) || (!rhk.gaO))
      {
        au.Hx();
        rhk = new k(c.Dv());
      }
      return rhk;
    }
    finally {}
  }
  
  public final boolean b(f paramf)
  {
    if (!this.gaO) {
      return false;
    }
    if (bk.bl(paramf.field_url))
    {
      y.d("MicroMsg.WebViewCacheResStorage", "updateWebViewCacheRes, url is null or nil");
      return false;
    }
    long l = bk.UX();
    paramf.field_accessTime = l;
    paramf.field_createTime = l;
    y.d("MicroMsg.WebViewCacheResStorage", "updateWebViewCacheRes, record = " + paramf);
    return b(paramf, false, new String[] { "urlMd5Hashcode", "appId", "domain", "cacheType", "packageId" });
  }
  
  public final boolean checkIsCached(String paramString, int paramInt)
  {
    if (!this.gaO) {}
    do
    {
      do
      {
        return false;
      } while (bk.bl(paramString));
      paramString = rawQuery(String.format("select * from %s where %s=? and %s", new Object[] { "WebViewResourceCache", "urlMd5Hashcode", Cf(paramInt) }), new String[] { String.valueOf(ad.bB(paramString).hashCode()) });
    } while (paramString == null);
    if (paramString.getCount() > 0)
    {
      paramString.close();
      return true;
    }
    paramString.close();
    return false;
  }
  
  public final boolean insert(f paramf, int paramInt1, int paramInt2)
  {
    return a(paramf);
  }
  
  public final List<f> m(String paramString, String... paramVarArgs)
  {
    paramString = rawQuery(paramString, paramVarArgs);
    if (paramString == null) {
      return null;
    }
    if (paramString.moveToFirst())
    {
      paramVarArgs = new LinkedList();
      do
      {
        f localf = new f();
        localf.d(paramString);
        paramVarArgs.add(localf);
      } while (paramString.moveToNext());
      paramString.close();
      return paramVarArgs;
    }
    paramString.close();
    return null;
  }
  
  public final boolean update(f paramf, int paramInt1, int paramInt2)
  {
    return b(paramf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modelcache.k
 * JD-Core Version:    0.7.0.1
 */