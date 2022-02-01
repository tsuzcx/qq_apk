package com.tencent.mm.plugin.webview.fts.b.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  public static final a Edg;
  private Map<String, com.tencent.mm.plugin.webview.fts.b.a.a.a> Edf;
  
  static
  {
    AppMethodBeat.i(77987);
    Edg = new a();
    AppMethodBeat.o(77987);
  }
  
  public a()
  {
    AppMethodBeat.i(77985);
    this.Edf = new HashMap();
    AppMethodBeat.o(77985);
  }
  
  public static com.tencent.mm.plugin.webview.fts.b.a.a.a aHW(String paramString)
  {
    AppMethodBeat.i(77986);
    if ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("//test-widget-ui")))
    {
      ae.w("SearchWidgetTestUiMgr", "not test-widget-ui formate");
      AppMethodBeat.o(77986);
      return null;
    }
    paramString = paramString.split("\\s+");
    if (paramString.length != 2)
    {
      ae.w("SearchWidgetTestUiMgr", "test-widget-ui arg length illegal");
      AppMethodBeat.o(77986);
      return null;
    }
    paramString = paramString[1];
    try
    {
      paramString = new com.tencent.mm.plugin.webview.fts.b.a.a.a(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(77986);
        return null;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ae.printErrStackTrace("SearchWidgetTestUiMgr", paramString, "", new Object[0]);
        paramString = null;
      }
      Edg.Edf.put(paramString.dwb, paramString);
      ae.i("SearchWidgetTestUiMgr", "test-widget-ui args %s, %s, %s, %s", new Object[] { paramString.Edj, paramString.dwb, paramString.Edh, paramString.Edi });
      AppMethodBeat.o(77986);
    }
    return paramString;
  }
  
  public static a eRU()
  {
    return Edg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.b.a.a
 * JD-Core Version:    0.7.0.1
 */