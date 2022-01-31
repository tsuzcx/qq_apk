package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class c
{
  public String AWJ;
  public String AWK;
  public String AWL;
  public String cvV;
  public String title;
  
  public c()
  {
    this.title = "";
    this.AWJ = "";
    this.AWK = "";
    this.AWL = "";
    this.cvV = "";
  }
  
  public c(String paramString)
  {
    AppMethodBeat.i(49036);
    this.title = "";
    this.AWJ = "";
    this.AWK = "";
    this.AWL = "";
    this.cvV = "";
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(49036);
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      this.title = paramString.optString("title");
      this.AWJ = paramString.optString("body1");
      this.AWK = paramString.optString("body2");
      this.AWL = paramString.optString("button");
      AppMethodBeat.o(49036);
      return;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.CrtRtnWoding", "crtwoding error %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(49036);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.c
 * JD-Core Version:    0.7.0.1
 */