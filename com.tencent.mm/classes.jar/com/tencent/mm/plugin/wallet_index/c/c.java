package com.tencent.mm.plugin.wallet_index.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
{
  public int IqK = 0;
  public String mMessage;
  public int mResponse;
  
  private c(int paramInt, String paramString)
  {
    this.mResponse = paramInt;
    this.mMessage = paramString;
  }
  
  public static c cJ(int paramInt, String paramString)
  {
    int m = 6;
    int k = 2131768862;
    AppMethodBeat.i(71810);
    int i;
    String str;
    int j;
    if (paramInt <= -15001)
    {
      i = paramInt;
      str = paramString;
      j = k;
    }
    for (;;)
    {
      Log.i("MicroMsg.IapResult", "code : " + paramInt + ", errMsg : " + str + ", convert to errCode : " + i);
      if (!Util.isNullOrNil(str)) {
        break;
      }
      paramString = new c(i, MMApplicationContext.getContext().getString(j));
      AppMethodBeat.o(71810);
      return paramString;
      j = k;
      i = m;
      str = paramString;
      switch (paramInt)
      {
      case 106: 
      case 100000001: 
      default: 
        j = k;
        i = m;
        str = paramString;
        break;
      case 0: 
        j = 2131768861;
        i = paramInt;
        str = paramString;
        break;
      case 1: 
      case 7: 
        j = 2131768863;
        i = paramInt;
        str = paramString;
        break;
      case 103: 
      case 104: 
      case 100000002: 
        i = 100000002;
        j = 2131768859;
        str = paramString;
        break;
      case 6: 
        paramString = new c(6, paramString);
        AppMethodBeat.o(71810);
        return paramString;
      case 109: 
        j = 2131768864;
        i = paramInt;
        str = paramString;
        break;
      case 110: 
        j = 2131768866;
        i = paramInt;
        str = paramString;
        break;
      case 111: 
        j = 2131768867;
        i = paramInt;
        str = paramString;
        break;
      case 112: 
        j = 2131768865;
        i = paramInt;
        str = paramString;
        break;
      case 113: 
        i = paramInt;
        j = k;
        str = paramString;
        break;
      case 3: 
      case 105: 
        i = 3;
        str = "Google Play not install";
        j = k;
        break;
      case 8: 
        j = 2131768860;
        i = paramInt;
        str = paramString;
      }
    }
    paramString = new c(i, str);
    AppMethodBeat.o(71810);
    return paramString;
  }
  
  public final boolean fUp()
  {
    return (this.mResponse == 104) || (this.mResponse == 100000002);
  }
  
  public final boolean isFailure()
  {
    AppMethodBeat.i(71811);
    if (this.mResponse == 0) {}
    for (int i = 1; (i == 0) && (!fUp()); i = 0)
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