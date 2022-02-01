package com.tencent.mm.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class d
{
  public String Zvo;
  public String agSK;
  public String agSL;
  public String hMi;
  public String title;
  
  public d()
  {
    this.title = "";
    this.agSK = "";
    this.agSL = "";
    this.Zvo = "";
    this.hMi = "";
  }
  
  public d(String paramString)
  {
    AppMethodBeat.i(72741);
    this.title = "";
    this.agSK = "";
    this.agSL = "";
    this.Zvo = "";
    this.hMi = "";
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(72741);
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      this.title = paramString.optString("title");
      this.agSK = paramString.optString("body1");
      this.agSL = paramString.optString("body2");
      this.Zvo = paramString.optString("button");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.model.d
 * JD-Core Version:    0.7.0.1
 */