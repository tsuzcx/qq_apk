package com.tencent.xweb.xwalk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.Log;

public final class j$b
{
  public String abCq;
  public String abCr;
  public String abCs;
  public int aipg;
  public int aiph;
  public int aipi;
  public int aipj;
  public String aipk;
  public String aipl;
  
  public static b c(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4)
  {
    k = 1;
    AppMethodBeat.i(154354);
    b localb = new b();
    localb.abCq = paramString1;
    localb.aipl = paramString2;
    localb.aipg = paramInt1;
    localb.aipi = paramInt2;
    localb.abCr = paramString3;
    localb.abCs = paramString4;
    if (paramInt1 > 0) {
      for (;;)
      {
        try
        {
          paramString2 = new StringBuffer(paramString3).reverse().toString();
          j = 0;
          i = paramInt1;
        }
        finally
        {
          int j;
          Log.e("XWWebView", "SelectInfo getSelectInfo error:".concat(String.valueOf(paramString1)));
          continue;
          paramInt1 = i;
          continue;
          paramInt1 = i;
          continue;
          if (paramInt2 <= 0) {
            continue;
          }
          String str = paramString4;
          k = 0;
          int m = paramInt2;
          paramInt1 = 0;
          paramInt2 = 0;
          continue;
          paramInt1 = 0;
          int i = 0;
          continue;
          i = paramInt2;
          if (j == 0) {
            continue;
          }
          i = paramInt2 * -1;
          paramInt2 = paramInt1;
          if (k == 0) {
            continue;
          }
          paramInt2 = paramInt1 * -1;
          continue;
        }
        if (paramInt1 > paramString2.length()) {
          continue;
        }
        paramInt2 = paramInt1;
        if (i <= paramString2.substring(0, paramInt1).getBytes().length) {
          continue;
        }
        paramInt2 = paramInt1;
        paramInt1 += 1;
      }
    }
    i = paramInt1 * -1;
    paramString2 = paramString1 + paramString4;
    j = 1;
    break label387;
    m = paramInt2 * -1;
    str = new StringBuffer(paramString1).reverse().toString() + new StringBuffer(paramString3).reverse().toString();
    break label401;
    while (paramInt1 <= str.length())
    {
      if (m <= str.substring(0, paramInt1).getBytes().length) {
        break label416;
      }
      i = paramInt1;
      paramInt1 += 1;
    }
    if (paramString1.length() + i + paramInt2 <= 0)
    {
      Log.e("XWWebView", "getSelectInfo error prefixIndex:" + i + ",suffixIndex:" + paramInt2);
      paramInt2 = 0;
      paramInt1 = 0;
      localb.aiph = paramInt1;
      localb.aipj = paramInt2;
      localb.aipk = (paramString3 + paramString1 + paramString4).substring(paramString3.length() - paramInt1, paramInt2 + (paramString3.length() + paramString1.length()));
      AppMethodBeat.o(154354);
      return localb;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(154355);
    try
    {
      String str = "SelectInfo PickedWord:" + this.abCq + ",PrefixText:" + this.abCr + ",SuffixText:" + this.abCs + ",PrefixOffset:" + this.aipg + ",prefixIndex:" + this.aiph + ",SuffixOffset:" + this.aipi + ",SuffixIndex:" + this.aipj + ",ResultPickedWord:" + this.aipl + ",OffsetedPickedWord:" + this.aipk;
      return str;
    }
    finally
    {
      AppMethodBeat.o(154355);
    }
    return "SelectInfo toString error";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.xwalk.j.b
 * JD-Core Version:    0.7.0.1
 */