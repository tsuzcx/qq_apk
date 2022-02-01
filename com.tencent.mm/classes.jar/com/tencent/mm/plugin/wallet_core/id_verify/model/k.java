package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.mm.wallet_core.tenpay.model.m;
import org.json.JSONObject;

public final class k
  extends m
{
  public final int getFuncId()
  {
    return 2752;
  }
  
  public final int getTenpayCgicmd()
  {
    return 2752;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/realnameverifysms";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.k
 * JD-Core Version:    0.7.0.1
 */