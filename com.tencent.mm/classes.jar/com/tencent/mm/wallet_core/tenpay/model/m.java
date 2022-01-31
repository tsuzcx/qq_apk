package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.mm.wallet_core.c.c;
import org.json.JSONObject;

public abstract class m
  extends j
  implements a
{
  private String aox = "";
  private int errCode = 0;
  public boolean nyn = false;
  private ITenpaySave.RetryPayInfo qfp;
  public boolean qno = false;
  private boolean wBE = false;
  public boolean wBF = false;
  public boolean wBG;
  
  public final void L(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.L(paramBoolean1, paramBoolean2);
  }
  
  public void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    this.errCode = paramInt;
    this.aox = paramString;
  }
  
  public void a(c paramc, JSONObject paramJSONObject)
  {
    boolean bool = true;
    super.a(paramc, paramJSONObject);
    if ((paramJSONObject != null) && (paramJSONObject.optInt("can_pay_retry") == 1)) {}
    for (;;)
    {
      this.wBG = bool;
      this.qfp = new ITenpaySave.RetryPayInfo();
      this.qfp.ar(paramJSONObject);
      return;
      bool = false;
    }
  }
  
  public final boolean bwh()
  {
    return !this.nyn;
  }
  
  public boolean cMP()
  {
    return false;
  }
  
  public final void cNb()
  {
    reset();
    this.wBF = true;
    this.wBs = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.tenpay.model.m
 * JD-Core Version:    0.7.0.1
 */