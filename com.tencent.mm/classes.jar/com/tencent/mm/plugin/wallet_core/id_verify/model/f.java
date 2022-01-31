package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f
  extends m
{
  public String uel;
  public String uem;
  public String uen;
  public String ueo;
  public String uep;
  
  public f(String paramString)
  {
    AppMethodBeat.i(46648);
    HashMap localHashMap = new HashMap();
    localHashMap.put("channel", "1");
    setRequestData(localHashMap);
    this.uep = paramString;
    AppMethodBeat.o(46648);
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
    AppMethodBeat.i(46649);
    if ((paramInt == 0) && (paramJSONObject != null))
    {
      this.uel = paramJSONObject.optString("guide_flag");
      this.uem = paramJSONObject.optString("guide_wording");
      this.uen = paramJSONObject.optString("left_button_wording");
      this.ueo = paramJSONObject.optString("right_button_wording");
    }
    AppMethodBeat.o(46649);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.f
 * JD-Core Version:    0.7.0.1
 */