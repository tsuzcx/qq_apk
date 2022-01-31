package com.tencent.mm.plugin.wallet_index.c;

import android.content.Context;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class b
{
  public int ljp;
  public String ljq;
  public int qLg = 0;
  
  private b(int paramInt, String paramString)
  {
    this.ljp = paramInt;
    this.ljq = paramString;
  }
  
  public static b aP(int paramInt, String paramString)
  {
    int j = 6;
    int i = a.i.wxwallet_result_unknown;
    if (paramInt <= -15001) {
      j = paramInt;
    }
    for (;;)
    {
      y.i("MicroMsg.IapResult", "code : " + paramInt + ", errMsg : " + paramString + ", convert to errCode : " + j);
      if (!bk.bl(paramString)) {
        break;
      }
      return new b(j, ae.getContext().getString(i));
      switch (paramInt)
      {
      default: 
        i = a.i.wxwallet_result_unknown;
        break;
      case 0: 
        i = a.i.wxwallet_result_success;
        j = paramInt;
        break;
      case 1: 
        i = a.i.wxwallet_result_user_canceled;
        j = paramInt;
        break;
      case 103: 
      case 104: 
      case 100000002: 
        j = 100000002;
        i = a.i.wxwallet_result_item_already_owned;
        break;
      case 6: 
        return new b(6, paramString);
      case 109: 
        i = a.i.wxwallet_result_wco_invalid_purchase;
        j = paramInt;
        break;
      case 110: 
        i = a.i.wxwallet_result_wco_invalid_purchase_quota_day;
        j = paramInt;
        break;
      case 111: 
        i = a.i.wxwallet_result_wco_invalid_purchase_quota_week;
        j = paramInt;
        break;
      case 112: 
        i = a.i.wxwallet_result_wco_invalid_purchase_freq_limit;
        j = paramInt;
        break;
      case 113: 
        i = a.i.wxwallet_result_unknown;
        j = paramInt;
        break;
      case 3: 
      case 105: 
        j = 3;
        paramString = "Google Play not install";
        break;
      case 106: 
      case 100000001: 
        i = a.i.wxwallet_result_unknown;
      }
    }
    return new b(j, paramString);
  }
  
  public final boolean bXy()
  {
    return (this.ljp == 104) || (this.ljp == 100000002);
  }
  
  public final boolean isFailure()
  {
    if (this.ljp == 0) {}
    for (int i = 1; (i == 0) && (!bXy()); i = 0) {
      return true;
    }
    return false;
  }
  
  public final String toString()
  {
    return "IapResult: " + this.ljq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.b
 * JD-Core Version:    0.7.0.1
 */