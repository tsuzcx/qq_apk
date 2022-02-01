package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public final class d
{
  public String LxM;
  public String LxN;
  public String LxO;
  public String duO;
  public String title;
  
  public d()
  {
    this.title = "";
    this.LxM = "";
    this.LxN = "";
    this.LxO = "";
    this.duO = "";
  }
  
  public d(String paramString)
  {
    AppMethodBeat.i(72741);
    this.title = "";
    this.LxM = "";
    this.LxN = "";
    this.LxO = "";
    this.duO = "";
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(72741);
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      this.title = paramString.optString("title");
      this.LxM = paramString.optString("body1");
      this.LxN = paramString.optString("body2");
      this.LxO = paramString.optString("button");
      AppMethodBeat.o(72741);
      return;
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.CrtRtnWoding", "crtwoding error %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(72741);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.d
 * JD-Core Version:    0.7.0.1
 */