package com.tencent.mm.plugin.wallet_index.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;

public final class b
{
  public int DHw = 0;
  public int uPh;
  public String uPi;
  
  private b(int paramInt, String paramString)
  {
    this.uPh = paramInt;
    this.uPi = paramString;
  }
  
  public static b cr(int paramInt, String paramString)
  {
    int m = 6;
    int k = 2131766347;
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
      ae.i("MicroMsg.IapResult", "code : " + paramInt + ", errMsg : " + str + ", convert to errCode : " + i);
      if (!bu.isNullOrNil(str)) {
        break;
      }
      paramString = new b(i, ak.getContext().getString(j));
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
        j = 2131766346;
        i = paramInt;
        str = paramString;
        break;
      case 1: 
      case 7: 
        j = 2131766348;
        i = paramInt;
        str = paramString;
        break;
      case 103: 
      case 104: 
      case 100000002: 
        i = 100000002;
        j = 2131766345;
        str = paramString;
        break;
      case 6: 
        paramString = new b(6, paramString);
        AppMethodBeat.o(71810);
        return paramString;
      case 109: 
        j = 2131766349;
        i = paramInt;
        str = paramString;
        break;
      case 110: 
        j = 2131766351;
        i = paramInt;
        str = paramString;
        break;
      case 111: 
        j = 2131766352;
        i = paramInt;
        str = paramString;
        break;
      case 112: 
        j = 2131766350;
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
        j = 2131766886;
        i = paramInt;
        str = paramString;
      }
    }
    paramString = new b(i, str);
    AppMethodBeat.o(71810);
    return paramString;
  }
  
  public final boolean eMG()
  {
    return (this.uPh == 104) || (this.uPh == 100000002);
  }
  
  public final boolean eMH()
  {
    AppMethodBeat.i(71811);
    if (this.uPh == 0) {}
    for (int i = 1; (i == 0) && (!eMG()); i = 0)
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
    String str = "IapResult: " + this.uPi;
    AppMethodBeat.o(71812);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.b
 * JD-Core Version:    0.7.0.1
 */