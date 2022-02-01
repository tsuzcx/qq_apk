package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.mm.wallet_core.tenpay.model.m;
import org.json.JSONObject;

public final class j
  extends m
{
  public final int getFuncId()
  {
    return 1923;
  }
  
  public final int getTenpayCgicmd()
  {
    return 1923;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/realnamesendsms";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.j
 * JD-Core Version:    0.7.0.1
 */