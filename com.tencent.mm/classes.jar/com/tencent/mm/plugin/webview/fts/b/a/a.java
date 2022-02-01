package com.tencent.mm.plugin.webview.fts.b.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  public static final a Cib;
  private Map<String, com.tencent.mm.plugin.webview.fts.b.a.a.a> Cia;
  
  static
  {
    AppMethodBeat.i(77987);
    Cib = new a();
    AppMethodBeat.o(77987);
  }
  
  public a()
  {
    AppMethodBeat.i(77985);
    this.Cia = new HashMap();
    AppMethodBeat.o(77985);
  }
  
  public static com.tencent.mm.plugin.webview.fts.b.a.a.a aBh(String paramString)
  {
    AppMethodBeat.i(77986);
    if ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("//test-widget-ui")))
    {
      ac.w("SearchWidgetTestUiMgr", "not test-widget-ui formate");
      AppMethodBeat.o(77986);
      return null;
    }
    paramString = paramString.split("\\s+");
    if (paramString.length != 2)
    {
      ac.w("SearchWidgetTestUiMgr", "test-widget-ui arg length illegal");
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
        ac.printErrStackTrace("SearchWidgetTestUiMgr", paramString, "", new Object[0]);
        paramString = null;
      }
      Cib.Cia.put(paramString.djj, paramString);
      ac.i("SearchWidgetTestUiMgr", "test-widget-ui args %s, %s, %s, %s", new Object[] { paramString.Cie, paramString.djj, paramString.Cic, paramString.Cid });
      AppMethodBeat.o(77986);
    }
    return paramString;
  }
  
  public static a ezu()
  {
    return Cib;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.b.a.a
 * JD-Core Version:    0.7.0.1
 */