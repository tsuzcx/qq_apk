package com.tencent.mm.plugin.wallet_index.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
{
  public int Pjt = 0;
  public String mMessage;
  public int mResponse;
  
  private c(int paramInt, String paramString)
  {
    this.mResponse = paramInt;
    this.mMessage = paramString;
  }
  
  public static c cK(int paramInt, String paramString)
  {
    int j = 6;
    AppMethodBeat.i(71810);
    int i = a.i.wxwallet_result_unknown;
    if (paramInt <= -15001) {
      j = paramInt;
    }
    for (;;)
    {
      Log.i("MicroMsg.IapResult", "code : " + paramInt + ", errMsg : " + paramString + ", convert to errCode : " + j);
      if (!Util.isNullOrNil(paramString)) {
        break;
      }
      paramString = new c(j, MMApplicationContext.getContext().getString(i));
      AppMethodBeat.o(71810);
      return paramString;
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
      case 7: 
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
        paramString = new c(6, paramString);
        AppMethodBeat.o(71810);
        return paramString;
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
        break;
      case 8: 
        i = a.i.wxwallet_result_purchase_error;
        j = paramInt;
      }
    }
    paramString = new c(j, paramString);
    AppMethodBeat.o(71810);
    return paramString;
  }
  
  public final boolean gMV()
  {
    return (this.mResponse == 104) || (this.mResponse == 100000002);
  }
  
  public final boolean isFailure()
  {
    AppMethodBeat.i(71811);
    if (this.mResponse == 0) {}
    for (int i = 1; (i == 0) && (!gMV()); i = 0)
    {
      AppMethodBeat.o(71811);
      return true;
    }
    AppMethodBeat.o(71811);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(71812);
    String str = "IapResult: " + this.mMessage;
    AppMethodBeat.o(71812);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.c
 * JD-Core Version:    0.7.0.1
 */