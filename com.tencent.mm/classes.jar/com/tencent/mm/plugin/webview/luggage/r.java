package com.tencent.mm.plugin.webview.luggage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c.d;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public final class r
{
  public final HashMap<String, String> uSQ;
  public final HashMap<String, c.d> uSR;
  public e uSb;
  
  public r(e parame)
  {
    AppMethodBeat.i(6230);
    this.uSQ = new HashMap();
    this.uSR = new HashMap();
    this.uSb = parame;
    AppMethodBeat.o(6230);
  }
  
  public static String agP(String paramString)
  {
    AppMethodBeat.i(6232);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(6232);
      return paramString;
    }
    int i = paramString.indexOf("#");
    if (i < 0)
    {
      AppMethodBeat.o(6232);
      return paramString;
    }
    paramString = paramString.substring(0, i);
    AppMethodBeat.o(6232);
    return paramString;
  }
  
  public final String getAppId()
  {
    AppMethodBeat.i(6231);
    String str = this.uSb.getUrl();
    if (bo.isNullOrNil(str))
    {
      AppMethodBeat.o(6231);
      return null;
    }
    str = agP(str);
    str = (String)this.uSQ.get(str);
    AppMethodBeat.o(6231);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.r
 * JD-Core Version:    0.7.0.1
 */