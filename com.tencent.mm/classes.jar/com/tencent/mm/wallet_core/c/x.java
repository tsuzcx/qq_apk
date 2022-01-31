package com.tencent.mm.wallet_core.c;

import org.json.JSONObject;

public final class x
{
  public String tNl = "";
  public String tVv = "";
  public String wAO = "";
  public String wAP = "";
  public int wAQ = 0;
  
  public x() {}
  
  public x(JSONObject paramJSONObject)
  {
    this.wAO = paramJSONObject.optString("device_id");
    this.tVv = paramJSONObject.optString("device_name");
    this.wAP = paramJSONObject.optString("device_os");
    this.wAQ = paramJSONObject.optInt("Is_cur_device");
    this.tNl = paramJSONObject.optString("crt_no");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.x
 * JD-Core Version:    0.7.0.1
 */