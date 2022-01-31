package com.tencent.mm.plugin.webview.fts.b.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  public static final a uPR;
  private Map<String, com.tencent.mm.plugin.webview.fts.b.a.a.a> uPQ;
  
  static
  {
    AppMethodBeat.i(5775);
    uPR = new a();
    AppMethodBeat.o(5775);
  }
  
  public a()
  {
    AppMethodBeat.i(5773);
    this.uPQ = new HashMap();
    AppMethodBeat.o(5773);
  }
  
  public static com.tencent.mm.plugin.webview.fts.b.a.a.a agL(String paramString)
  {
    AppMethodBeat.i(5774);
    if ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("//test-widget-ui")))
    {
      ab.w("SearchWidgetTestUiMgr", "not test-widget-ui formate");
      AppMethodBeat.o(5774);
      return null;
    }
    paramString = paramString.split("\\s+");
    if (paramString.length != 2)
    {
      ab.w("SearchWidgetTestUiMgr", "test-widget-ui arg length illegal");
      AppMethodBeat.o(5774);
      return null;
    }
    paramString = paramString[1];
    try
    {
      paramString = new com.tencent.mm.plugin.webview.fts.b.a.a.a(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(5774);
        return null;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.printErrStackTrace("SearchWidgetTestUiMgr", paramString, "", new Object[0]);
        paramString = null;
      }
      uPR.uPQ.put(paramString.cwc, paramString);
      ab.i("SearchWidgetTestUiMgr", "test-widget-ui args %s, %s, %s, %s", new Object[] { paramString.uPU, paramString.cwc, paramString.uPS, paramString.uPT });
      AppMethodBeat.o(5774);
    }
    return paramString;
  }
  
  public static a daG()
  {
    return uPR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.b.a.a
 * JD-Core Version:    0.7.0.1
 */