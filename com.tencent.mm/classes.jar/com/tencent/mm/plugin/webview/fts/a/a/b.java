package com.tencent.mm.plugin.webview.fts.a.a;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class b
{
  private static final b rad = new b();
  private b.a rae;
  
  public static boolean a(c paramc)
  {
    if ("1".equals(paramc.ctr().get("canPreloadWidget"))) {
      return true;
    }
    y.i("WidgetPkgPreDownloadMgr", "abtest close preDownload");
    return false;
  }
  
  public static b caF()
  {
    return rad;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.a.a.b
 * JD-Core Version:    0.7.0.1
 */