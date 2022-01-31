package com.tencent.mm.plugin.wallet_index.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class b
{
  public int nGE;
  public String nGF;
  public int uAc = 0;
  
  private b(int paramInt, String paramString)
  {
    this.nGE = paramInt;
    this.nGF = paramString;
  }
  
  public static b bu(int paramInt, String paramString)
  {
    int m = 6;
    int k = 2131306084;
    AppMethodBeat.i(48175);
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
      ab.i("MicroMsg.IapResult", "code : " + paramInt + ", errMsg : " + str + ", convert to errCode : " + i);
      if (!bo.isNullOrNil(str)) {
        break;
      }
      paramString = new b(i, ah.getContext().getString(j));
      AppMethodBeat.o(48175);
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
        j = 2131306083;
        i = paramInt;
        str = paramString;
        break;
      case 1: 
      case 7: 
        j = 2131306085;
        i = paramInt;
        str = paramString;
        break;
      case 103: 
      case 104: 
      case 100000002: 
        i = 100000002;
        j = 2131306082;
        str = paramString;
        break;
      case 6: 
        paramString = new b(6, paramString);
        AppMethodBeat.o(48175);
        return paramString;
      case 109: 
        j = 2131306086;
        i = paramInt;
        str = paramString;
        break;
      case 110: 
        j = 2131306088;
        i = paramInt;
        str = paramString;
        break;
      case 111: 
        j = 2131306089;
        i = paramInt;
        str = paramString;
        break;
      case 112: 
        j = 2131306087;
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
      }
    }
    paramString = new b(i, str);
    AppMethodBeat.o(48175);
    return paramString;
  }
  
  public final boolean cXd()
  {
    return (this.nGE == 104) || (this.nGE == 100000002);
  }
  
  public final boolean cXe()
  {
    AppMethodBeat.i(48176);
    if (this.nGE == 0) {}
    for (int i = 1; (i == 0) && (!cXd()); i = 0)
    {
      AppMethodBeat.o(48176);
      return true;
    }
    AppMethodBeat.o(48176);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(48177);
    String str = "IapResult: " + this.nGF;
    AppMethodBeat.o(48177);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.b
 * JD-Core Version:    0.7.0.1
 */