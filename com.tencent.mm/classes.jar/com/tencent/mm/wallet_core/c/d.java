package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public final class d
{
  public String Idg;
  public String Idh;
  public String Idi;
  public String dlu;
  public String title;
  
  public d()
  {
    this.title = "";
    this.Idg = "";
    this.Idh = "";
    this.Idi = "";
    this.dlu = "";
  }
  
  public d(String paramString)
  {
    AppMethodBeat.i(72741);
    this.title = "";
    this.Idg = "";
    this.Idh = "";
    this.Idi = "";
    this.dlu = "";
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(72741);
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      this.title = paramString.optString("title");
      this.Idg = paramString.optString("body1");
      this.Idh = paramString.optString("body2");
      this.Idi = paramString.optString("button");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.d
 * JD-Core Version:    0.7.0.1
 */