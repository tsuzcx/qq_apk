package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.mm.wallet_core.c.e;
import java.util.HashMap;
import org.json.JSONObject;

public abstract class p
  extends m
  implements a
{
  private static final String TAG = "MicroMsg.NetSceneTenpayRetriableBase";
  private boolean can_pay_retry2;
  private int errCode = 0;
  private String errMsg = "";
  private boolean hasCGiRetried = false;
  private boolean hasRetried = false;
  public boolean isPaySuccess = false;
  private ITenpaySave.RetryPayInfo retryPayInfo;
  private boolean shouldRetr = false;
  
  public boolean canPayRetry()
  {
    return this.can_pay_retry2;
  }
  
  public boolean canRetry()
  {
    return false;
  }
  
  public boolean checkPaySuccess()
  {
    return this.isPaySuccess;
  }
  
  public void configRequest(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.configRequest(paramBoolean1, paramBoolean2);
  }
  
  public int getErrCode()
  {
    return this.errCode;
  }
  
  public String getErrMsg()
  {
    return this.errMsg;
  }
  
  public boolean getHasRetried()
  {
    return this.hasRetried;
  }
  
  public ITenpaySave.RetryPayInfo getRetryPayInfo()
  {
    return this.retryPayInfo;
  }
  
  public boolean isShouldRetr()
  {
    return this.shouldRetr;
  }
  
  public boolean ishasCGiRetried()
  {
    return this.hasCGiRetried;
  }
  
  public void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    this.errCode = paramInt;
    this.errMsg = paramString;
  }
  
  public void onGYNetEnd2(e parame, JSONObject paramJSONObject)
  {
    boolean bool = true;
    super.onGYNetEnd2(parame, paramJSONObject);
    if ((paramJSONObject != null) && (paramJSONObject.optInt("can_pay_retry") == 1)) {}
    for (;;)
    {
      this.can_pay_retry2 = bool;
      this.retryPayInfo = new ITenpaySave.RetryPayInfo();
      this.retryPayInfo.bk(paramJSONObject);
      return;
      bool = false;
    }
  }
  
  public void resetForRetry()
  {
    reset();
    this.hasCGiRetried = true;
    this.isFake = false;
  }
  
  public void setErrCode(int paramInt)
  {
    this.errCode = paramInt;
  }
  
  public void setErrMsg(String paramString)
  {
    this.errMsg = paramString;
  }
  
  public void setHasRetried(boolean paramBoolean)
  {
    this.hasRetried = paramBoolean;
  }
  
  public void setPaySuccess(boolean paramBoolean)
  {
    this.isPaySuccess = paramBoolean;
  }
  
  public void setRetry()
  {
    reset();
    HashMap localHashMap = new HashMap();
    localHashMap.put("is_retry_pay", "1");
    addRequestData(localHashMap);
    this.hasCGiRetried = true;
    this.isFake = false;
  }
  
  public void setShouldRetr(boolean paramBoolean)
  {
    this.shouldRetr = paramBoolean;
  }
  
  public boolean shouldResolveJsonWhenError()
  {
    return !getHasRetried();
  }
  
  public void updateConfig(int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("retry_count", String.valueOf(paramInt1));
    localHashMap.put("is_last_retry", String.valueOf(paramInt2));
    addRequestData(localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.tenpay.model.p
 * JD-Core Version:    0.7.0.1
 */