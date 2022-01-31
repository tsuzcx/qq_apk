package com.tencent.xweb.xwalk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.Log;

public final class j$b
{
  public int BKc;
  public int BKd;
  public int BKe;
  public int BKf;
  public String BKg;
  public String BKh;
  public String xNn;
  public String xNo;
  public String xNp;
  
  public static b c(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4)
  {
    k = 1;
    AppMethodBeat.i(85295);
    b localb = new b();
    localb.xNn = paramString1;
    localb.BKh = paramString2;
    localb.BKc = paramInt1;
    localb.BKe = paramInt2;
    localb.xNo = paramString3;
    localb.xNp = paramString4;
    if (paramInt1 > 0) {
      for (;;)
      {
        try
        {
          paramString2 = new StringBuffer(paramString3).reverse().toString();
          j = 0;
          i = paramInt1;
        }
        catch (Exception paramString1)
        {
          int j;
          Log.e("XWWebView", "SelectInfo getSelectInfo error:" + paramString1.getMessage());
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
    break label397;
    m = paramInt2 * -1;
    str = new StringBuffer(paramString1).reverse().toString() + new StringBuffer(paramString3).reverse().toString();
    break label411;
    while (paramInt1 <= str.length())
    {
      if (m <= str.substring(0, paramInt1).getBytes().length) {
        break label426;
      }
      i = paramInt1;
      paramInt1 += 1;
    }
    if (paramString1.length() + i + paramInt2 <= 0)
    {
      Log.e("XWWebView", "getSelectInfo error prefixIndex:" + i + ",suffixIndex:" + paramInt2);
      paramInt2 = 0;
      paramInt1 = 0;
      localb.BKd = paramInt1;
      localb.BKf = paramInt2;
      localb.BKg = (paramString3 + paramString1 + paramString4).substring(paramString3.length() - paramInt1, paramInt2 + (paramString3.length() + paramString1.length()));
      AppMethodBeat.o(85295);
      return localb;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(85296);
    try
    {
      String str = "SelectInfo PickedWord:" + this.xNn + ",PrefixText:" + this.xNo + ",SuffixText:" + this.xNp + ",PrefixOffset:" + this.BKc + ",prefixIndex:" + this.BKd + ",SuffixOffset:" + this.BKe + ",SuffixIndex:" + this.BKf + ",ResultPickedWord:" + this.BKh + ",OffsetedPickedWord:" + this.BKg;
      AppMethodBeat.o(85296);
      return str;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(85296);
    }
    return "SelectInfo toString error";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.xwalk.j.b
 * JD-Core Version:    0.7.0.1
 */