package com.tencent.mm.plugin.webview.luggage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.d;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;

public final class t
{
  public f ASM;
  public final HashMap<String, String> AUG;
  public final HashMap<String, a.d> AUH;
  public final HashMap<String, String> AUI;
  
  public t(f paramf)
  {
    AppMethodBeat.i(78474);
    this.AUG = new HashMap();
    this.AUH = new HashMap();
    this.AUI = new HashMap();
    this.ASM = paramf;
    AppMethodBeat.o(78474);
  }
  
  public static String awm(String paramString)
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
  
  public final String elv()
  {
    AppMethodBeat.i(78477);
    String str = getAppId();
    if (bt.isNullOrNil(str))
    {
      AppMethodBeat.o(78477);
      return null;
    }
    str = (String)this.AUI.get(str);
    AppMethodBeat.o(78477);
    return str;
  }
  
  public final String getAppId()
  {
    AppMethodBeat.i(78475);
    String str = this.ASM.getUrl();
    if (bt.isNullOrNil(str))
    {
      AppMethodBeat.o(78475);
      return null;
    }
    str = awm(str);
    str = (String)this.AUG.get(str);
    AppMethodBeat.o(78475);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.t
 * JD-Core Version:    0.7.0.1
 */