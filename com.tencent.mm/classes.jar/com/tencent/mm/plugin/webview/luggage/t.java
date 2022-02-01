package com.tencent.mm.plugin.webview.luggage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.d;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;

public final class t
{
  public f CkZ;
  public final HashMap<String, String> CmT;
  public final HashMap<String, a.d> CmU;
  public final HashMap<String, String> CmV;
  
  public t(f paramf)
  {
    AppMethodBeat.i(78474);
    this.CmT = new HashMap();
    this.CmU = new HashMap();
    this.CmV = new HashMap();
    this.CkZ = paramf;
    AppMethodBeat.o(78474);
  }
  
  public static String aBE(String paramString)
  {
    AppMethodBeat.i(78476);
    if (bs.isNullOrNil(paramString))
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
  
  public final String eAR()
  {
    AppMethodBeat.i(78477);
    String str = getAppId();
    if (bs.isNullOrNil(str))
    {
      AppMethodBeat.o(78477);
      return null;
    }
    str = (String)this.CmV.get(str);
    AppMethodBeat.o(78477);
    return str;
  }
  
  public final String getAppId()
  {
    AppMethodBeat.i(78475);
    String str = this.CkZ.getUrl();
    if (bs.isNullOrNil(str))
    {
      AppMethodBeat.o(78475);
      return null;
    }
    str = aBE(str);
    str = (String)this.CmT.get(str);
    AppMethodBeat.o(78475);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.t
 * JD-Core Version:    0.7.0.1
 */