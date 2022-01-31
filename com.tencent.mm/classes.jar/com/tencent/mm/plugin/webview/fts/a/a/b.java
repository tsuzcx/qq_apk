package com.tencent.mm.plugin.webview.fts.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class b
{
  private static final b uPL;
  private b.a uPM;
  
  static
  {
    AppMethodBeat.i(5772);
    uPL = new b();
    AppMethodBeat.o(5772);
  }
  
  public static boolean a(c paramc)
  {
    AppMethodBeat.i(5770);
    if ("1".equals(paramc.dvN().get("canPreloadWidget")))
    {
      AppMethodBeat.o(5770);
      return true;
    }
    ab.i("WidgetPkgPreDownloadMgr", "abtest close preDownload");
    AppMethodBeat.o(5770);
    return false;
  }
  
  public static b daE()
  {
    return uPL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.a.a.b
 * JD-Core Version:    0.7.0.1
 */