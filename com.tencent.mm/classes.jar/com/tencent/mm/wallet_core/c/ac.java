package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class ac
{
  public String HAE;
  public String HMB;
  public String LyF;
  public String LyG;
  public int LyH;
  
  public ac()
  {
    this.LyF = "";
    this.HMB = "";
    this.LyG = "";
    this.HAE = "";
    this.LyH = 0;
  }
  
  public ac(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72811);
    this.LyF = "";
    this.HMB = "";
    this.LyG = "";
    this.HAE = "";
    this.LyH = 0;
    this.LyF = paramJSONObject.optString("device_id");
    this.HMB = paramJSONObject.optString("device_name");
    this.LyG = paramJSONObject.optString("device_os");
    this.LyH = paramJSONObject.optInt("Is_cur_device");
    this.HAE = paramJSONObject.optString("crt_no");
    AppMethodBeat.o(72811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.ac
 * JD-Core Version:    0.7.0.1
 */