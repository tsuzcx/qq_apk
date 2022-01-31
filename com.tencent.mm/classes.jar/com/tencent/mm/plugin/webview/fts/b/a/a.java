package com.tencent.mm.plugin.webview.fts.b.a;

import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  public static final a rak = new a();
  private Map<String, com.tencent.mm.plugin.webview.fts.b.a.a.a> raj = new HashMap();
  
  public static com.tencent.mm.plugin.webview.fts.b.a.a.a RI(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("//test-widget-ui"))) {
      y.w("SearchWidgetTestUiMgr", "not test-widget-ui formate");
    }
    for (;;)
    {
      return null;
      paramString = paramString.split("\\s+");
      if (paramString.length != 2)
      {
        y.w("SearchWidgetTestUiMgr", "test-widget-ui arg length illegal");
        return null;
      }
      paramString = paramString[1];
      try
      {
        paramString = new com.tencent.mm.plugin.webview.fts.b.a.a.a(paramString);
        if (paramString == null) {
          continue;
        }
        rak.raj.put(paramString.bOL, paramString);
        y.i("SearchWidgetTestUiMgr", "test-widget-ui args %s, %s, %s, %s", new Object[] { paramString.ran, paramString.bOL, paramString.ral, paramString.ram });
        return paramString;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          y.printErrStackTrace("SearchWidgetTestUiMgr", paramString, "", new Object[0]);
          paramString = null;
        }
      }
    }
  }
  
  public static a caH()
  {
    return rak;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.b.a.a
 * JD-Core Version:    0.7.0.1
 */