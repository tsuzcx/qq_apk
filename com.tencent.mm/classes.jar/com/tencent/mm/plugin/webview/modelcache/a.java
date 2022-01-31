package com.tencent.mm.plugin.webview.modelcache;

import android.util.SparseArray;
import com.tencent.mm.h.c.ey;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;

public final class a
{
  private static final SparseArray<a> rgY = new SparseArray();
  private static volatile a.b rgZ = null;
  private static final byte[] rha = new byte[0];
  public final String appId;
  public final String path;
  public final a.b rgX;
  
  private a(String paramString)
  {
    this.appId = paramString;
    com.tencent.mm.vfs.e.nb(com.tencent.mm.compatible.util.e.dzP + "sfs");
    this.path = (com.tencent.mm.compatible.util.e.dzP + String.valueOf(paramString.hashCode()));
    com.tencent.mm.vfs.e.nb(this.path);
    this.rgX = ccr();
  }
  
  public static a Su(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    int i = paramString.hashCode();
    a locala = (a)rgY.get(i);
    if (locala == null)
    {
      paramString = new a(paramString);
      rgY.put(i, paramString);
      return paramString;
    }
    com.tencent.mm.vfs.e.nb(locala.path);
    return locala;
  }
  
  public static d.a ccq()
  {
    return new d.a("WEBVIEW_RESOURCE_CACHE_APPID_OCCUPATION_TABLE".hashCode(), new String[] { i.a(ey.vg(), "WebViewCacheAppIdOccupation") });
  }
  
  private static a.b ccr()
  {
    if (!au.DK()) {
      return new a.b(null);
    }
    synchronized (rha)
    {
      if ((rgZ == null) || (!rgZ.gaO))
      {
        au.Hx();
        rgZ = new a.b(c.Dv());
      }
      a.b localb = rgZ;
      return localb;
    }
  }
  
  static void clearCache()
  {
    rgY.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modelcache.a
 * JD-Core Version:    0.7.0.1
 */