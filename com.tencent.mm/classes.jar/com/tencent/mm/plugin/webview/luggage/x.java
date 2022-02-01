package com.tencent.mm.plugin.webview.luggage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.d;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public final class x
{
  public g WFG;
  public final HashMap<String, String> WHW;
  public final HashMap<String, a.d> WHX;
  public final HashMap<String, String> WHY;
  
  public x(g paramg)
  {
    AppMethodBeat.i(78474);
    this.WHW = new HashMap();
    this.WHX = new HashMap();
    this.WHY = new HashMap();
    this.WFG = paramg;
    AppMethodBeat.o(78474);
  }
  
  public static String bkc(String paramString)
  {
    AppMethodBeat.i(78476);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(78476);
      return paramString;
    }
    int i = paramString.indexOf("#");
    if (i < 0)
    {
      AppMethodBeat.o(78476);
      return paramString;
    }
    paramString = paramString.substring(0, i);
    AppMethodBeat.o(78476);
    return paramString;
  }
  
  public final String getAppId()
  {
    AppMethodBeat.i(78475);
    String str = this.WFG.getUrl();
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(78475);
      return null;
    }
    str = bkc(str);
    str = (String)this.WHW.get(str);
    AppMethodBeat.o(78475);
    return str;
  }
  
  public final String getIcon()
  {
    AppMethodBeat.i(78477);
    String str = getAppId();
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(78477);
      return null;
    }
    str = (String)this.WHY.get(str);
    AppMethodBeat.o(78477);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.x
 * JD-Core Version:    0.7.0.1
 */