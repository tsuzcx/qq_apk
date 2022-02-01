package com.tencent.mm.plugin.webview.luggage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.d;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;

public final class u
{
  public g DOl;
  public final HashMap<String, String> DQo;
  public final HashMap<String, a.d> DQp;
  public final HashMap<String, String> DQq;
  
  public u(g paramg)
  {
    AppMethodBeat.i(78474);
    this.DQo = new HashMap();
    this.DQp = new HashMap();
    this.DQq = new HashMap();
    this.DOl = paramg;
    AppMethodBeat.o(78474);
  }
  
  public static String aHc(String paramString)
  {
    AppMethodBeat.i(78476);
    if (bt.isNullOrNil(paramString))
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
  
  public final String ePJ()
  {
    AppMethodBeat.i(78477);
    String str = getAppId();
    if (bt.isNullOrNil(str))
    {
      AppMethodBeat.o(78477);
      return null;
    }
    str = (String)this.DQq.get(str);
    AppMethodBeat.o(78477);
    return str;
  }
  
  public final String getAppId()
  {
    AppMethodBeat.i(78475);
    String str = this.DOl.getUrl();
    if (bt.isNullOrNil(str))
    {
      AppMethodBeat.o(78475);
      return null;
    }
    str = aHc(str);
    str = (String)this.DQo.get(str);
    AppMethodBeat.o(78475);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.u
 * JD-Core Version:    0.7.0.1
 */