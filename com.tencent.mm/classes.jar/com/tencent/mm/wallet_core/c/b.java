package com.tencent.mm.wallet_core.c;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public final class b
{
  public String bOE = "";
  public String title = "";
  public String wAh = "";
  public String wAi = "";
  public String wAj = "";
  
  public b() {}
  
  public b(String paramString)
  {
    if (bk.bl(paramString)) {
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      this.title = paramString.optString("title");
      this.wAh = paramString.optString("body1");
      this.wAi = paramString.optString("body2");
      this.wAj = paramString.optString("button");
      return;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.CrtRtnWoding", "crtwoding error %s", new Object[] { paramString.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.b
 * JD-Core Version:    0.7.0.1
 */