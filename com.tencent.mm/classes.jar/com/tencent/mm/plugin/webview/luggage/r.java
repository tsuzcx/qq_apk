package com.tencent.mm.plugin.webview.luggage;

import com.tencent.mm.plugin.webview.ui.tools.jsapi.c.d;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.HashMap;

public final class r
{
  public final HashMap<String, String> rcS = new HashMap();
  public final HashMap<String, c.d> rcT = new HashMap();
  public e rcp;
  
  public r(e parame)
  {
    this.rcp = parame;
  }
  
  public static String RL(String paramString)
  {
    if (bk.bl(paramString)) {}
    int i;
    do
    {
      return paramString;
      i = paramString.indexOf("#");
    } while (i < 0);
    return paramString.substring(0, i);
  }
  
  public final String getAppId()
  {
    String str = this.rcp.getUrl();
    if (bk.bl(str)) {
      return null;
    }
    str = RL(str);
    return (String)this.rcS.get(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.r
 * JD-Core Version:    0.7.0.1
 */