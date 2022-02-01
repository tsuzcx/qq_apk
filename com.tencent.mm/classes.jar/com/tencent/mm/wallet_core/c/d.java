package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONObject;

public final class d
{
  public String LUB;
  public String LUC;
  public String LUD;
  public String dvT;
  public String title;
  
  public d()
  {
    this.title = "";
    this.LUB = "";
    this.LUC = "";
    this.LUD = "";
    this.dvT = "";
  }
  
  public d(String paramString)
  {
    AppMethodBeat.i(72741);
    this.title = "";
    this.LUB = "";
    this.LUC = "";
    this.LUD = "";
    this.dvT = "";
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(72741);
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      this.title = paramString.optString("title");
      this.LUB = paramString.optString("body1");
      this.LUC = paramString.optString("body2");
      this.LUD = paramString.optString("button");
      AppMethodBeat.o(72741);
      return;
    }
    catch (Exception paramString)
    {
      ae.e("MicroMsg.CrtRtnWoding", "crtwoding error %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(72741);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.d
 * JD-Core Version:    0.7.0.1
 */