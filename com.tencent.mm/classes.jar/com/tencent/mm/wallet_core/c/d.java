package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class d
{
  public String Rtr;
  public String Rts;
  public String Rtt;
  public String dNA;
  public String title;
  
  public d()
  {
    this.title = "";
    this.Rtr = "";
    this.Rts = "";
    this.Rtt = "";
    this.dNA = "";
  }
  
  public d(String paramString)
  {
    AppMethodBeat.i(72741);
    this.title = "";
    this.Rtr = "";
    this.Rts = "";
    this.Rtt = "";
    this.dNA = "";
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(72741);
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      this.title = paramString.optString("title");
      this.Rtr = paramString.optString("body1");
      this.Rts = paramString.optString("body2");
      this.Rtt = paramString.optString("button");
      AppMethodBeat.o(72741);
      return;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.CrtRtnWoding", "crtwoding error %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(72741);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.d
 * JD-Core Version:    0.7.0.1
 */