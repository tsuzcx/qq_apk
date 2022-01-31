package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f
  extends j
{
  public String qsn;
  public String qso;
  public String qsp;
  public String qsq;
  public String qsr;
  
  public f(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("channel", "1");
    D(localHashMap);
    this.qsr = paramString;
  }
  
  public final int HH()
  {
    return 1630;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if ((paramInt == 0) && (paramJSONObject != null))
    {
      this.qsn = paramJSONObject.optString("guide_flag");
      this.qso = paramJSONObject.optString("guide_wording");
      this.qsp = paramJSONObject.optString("left_button_wording");
      this.qsq = paramJSONObject.optString("right_button_wording");
    }
  }
  
  public final int aEC()
  {
    return 1630;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/realnameguidequery";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.f
 * JD-Core Version:    0.7.0.1
 */