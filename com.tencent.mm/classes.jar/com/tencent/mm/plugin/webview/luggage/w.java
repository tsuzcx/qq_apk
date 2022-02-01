package com.tencent.mm.plugin.webview.luggage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.d;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public final class w
{
  public g ISU;
  public final HashMap<String, String> IVj;
  public final HashMap<String, a.d> IVk;
  public final HashMap<String, String> IVl;
  
  public w(g paramg)
  {
    AppMethodBeat.i(78474);
    this.IVj = new HashMap();
    this.IVk = new HashMap();
    this.IVl = new HashMap();
    this.ISU = paramg;
    AppMethodBeat.o(78474);
  }
  
  public static String aYy(String paramString)
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
    String str = this.ISU.getUrl();
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(78475);
      return null;
    }
    str = aYy(str);
    str = (String)this.IVj.get(str);
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
    str = (String)this.IVl.get(str);
    AppMethodBeat.o(78477);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.w
 * JD-Core Version:    0.7.0.1
 */