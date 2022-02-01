package com.tencent.mm.plugin.webview.fts.b.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  public static final a IPG;
  private Map<String, com.tencent.mm.plugin.webview.fts.b.a.a.a> IPF;
  
  static
  {
    AppMethodBeat.i(77987);
    IPG = new a();
    AppMethodBeat.o(77987);
  }
  
  public a()
  {
    AppMethodBeat.i(77985);
    this.IPF = new HashMap();
    AppMethodBeat.o(77985);
  }
  
  public static com.tencent.mm.plugin.webview.fts.b.a.a.a aXY(String paramString)
  {
    AppMethodBeat.i(77986);
    if ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("//test-widget-ui")))
    {
      Log.w("SearchWidgetTestUiMgr", "not test-widget-ui formate");
      AppMethodBeat.o(77986);
      return null;
    }
    paramString = paramString.split("\\s+");
    if (paramString.length != 2)
    {
      Log.w("SearchWidgetTestUiMgr", "test-widget-ui arg length illegal");
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
        Log.printErrStackTrace("SearchWidgetTestUiMgr", paramString, "", new Object[0]);
        paramString = null;
      }
      IPG.IPF.put(paramString.dNI, paramString);
      Log.i("SearchWidgetTestUiMgr", "test-widget-ui args %s, %s, %s, %s", new Object[] { paramString.IPJ, paramString.dNI, paramString.IPH, paramString.IPI });
      AppMethodBeat.o(77986);
    }
    return paramString;
  }
  
  public static a gaG()
  {
    return IPG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.b.a.a
 * JD-Core Version:    0.7.0.1
 */