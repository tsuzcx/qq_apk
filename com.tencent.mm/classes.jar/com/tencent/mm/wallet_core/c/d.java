package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONObject;

public final class d
{
  public String JEI;
  public String JEJ;
  public String JEK;
  public String djc;
  public String title;
  
  public d()
  {
    this.title = "";
    this.JEI = "";
    this.JEJ = "";
    this.JEK = "";
    this.djc = "";
  }
  
  public d(String paramString)
  {
    AppMethodBeat.i(72741);
    this.title = "";
    this.JEI = "";
    this.JEJ = "";
    this.JEK = "";
    this.djc = "";
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(72741);
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      this.title = paramString.optString("title");
      this.JEI = paramString.optString("body1");
      this.JEJ = paramString.optString("body2");
      this.JEK = paramString.optString("button");
      AppMethodBeat.o(72741);
      return;
    }
    catch (Exception paramString)
    {
      ac.e("MicroMsg.CrtRtnWoding", "crtwoding error %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(72741);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.d
 * JD-Core Version:    0.7.0.1
 */