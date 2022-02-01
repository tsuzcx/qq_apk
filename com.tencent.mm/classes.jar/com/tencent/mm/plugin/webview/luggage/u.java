package com.tencent.mm.plugin.webview.luggage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.d;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;

public final class u
{
  public g Egl;
  public final HashMap<String, String> Eio;
  public final HashMap<String, a.d> Eip;
  public final HashMap<String, String> Eiq;
  
  public u(g paramg)
  {
    AppMethodBeat.i(78474);
    this.Eio = new HashMap();
    this.Eip = new HashMap();
    this.Eiq = new HashMap();
    this.Egl = paramg;
    AppMethodBeat.o(78474);
  }
  
  public static String aIw(String paramString)
  {
    AppMethodBeat.i(78476);
    if (bu.isNullOrNil(paramString))
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
  
  public final String eTv()
  {
    AppMethodBeat.i(78477);
    String str = getAppId();
    if (bu.isNullOrNil(str))
    {
      AppMethodBeat.o(78477);
      return null;
    }
    str = (String)this.Eiq.get(str);
    AppMethodBeat.o(78477);
    return str;
  }
  
  public final String getAppId()
  {
    AppMethodBeat.i(78475);
    String str = this.Egl.getUrl();
    if (bu.isNullOrNil(str))
    {
      AppMethodBeat.o(78475);
      return null;
    }
    str = aIw(str);
    str = (String)this.Eio.get(str);
    AppMethodBeat.o(78475);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.u
 * JD-Core Version:    0.7.0.1
 */