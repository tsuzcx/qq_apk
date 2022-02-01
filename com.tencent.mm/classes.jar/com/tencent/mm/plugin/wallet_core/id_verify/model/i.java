package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class i
  extends m
{
  public String BsC;
  public String BsD;
  public String BsE;
  public String BsF;
  public String BsG;
  
  public i(String paramString)
  {
    AppMethodBeat.i(70154);
    HashMap localHashMap = new HashMap();
    localHashMap.put("channel", "1");
    setRequestData(localHashMap);
    this.BsG = paramString;
    AppMethodBeat.o(70154);
  }
  
  public final int getFuncId()
  {
    return 1630;
  }
  
  public final int getTenpayCgicmd()
  {
    return 1630;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/realnameguidequery";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70155);
    if ((paramInt == 0) && (paramJSONObject != null))
    {
      this.BsC = paramJSONObject.optString("guide_flag");
      this.BsD = paramJSONObject.optString("guide_wording");
      this.BsE = paramJSONObject.optString("left_button_wording");
      this.BsF = paramJSONObject.optString("right_button_wording");
    }
    AppMethodBeat.o(70155);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.i
 * JD-Core Version:    0.7.0.1
 */