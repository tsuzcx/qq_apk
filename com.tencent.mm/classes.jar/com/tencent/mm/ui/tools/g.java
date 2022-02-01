package com.tencent.mm.ui.tools;

import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class g
  implements InputFilter
{
  private int rvB;
  private a rvC;
  
  public g(int paramInt, a parama)
  {
    this.rvB = paramInt;
    this.rvC = parama;
  }
  
  public static int N(char paramChar)
  {
    if (paramChar <= '') {
      return 1;
    }
    return 2;
  }
  
  public static int a(String paramString, a parama)
  {
    AppMethodBeat.i(133834);
    int i;
    if (parama == a.XSt)
    {
      i = bAD(paramString);
      AppMethodBeat.o(133834);
      return i;
    }
    if (parama == a.XSu)
    {
      i = bAB(paramString);
      AppMethodBeat.o(133834);
      return i;
    }
    if (parama == a.XSv)
    {
      i = bAC(paramString);
      AppMethodBeat.o(133834);
      return i;
    }
    AppMethodBeat.o(133834);
    return 0;
  }
  
  public static int axu(int paramInt)
  {
    if (paramInt % 2 != 0) {
      return (paramInt + 1) / 2;
    }
    return paramInt / 2;
  }
  
  public static int bAB(String paramString)
  {
    AppMethodBeat.i(133835);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(133835);
      return 0;
    }
    int i = paramString.length();
    int j = bAE(paramString);
    int k = bAF(paramString);
    AppMethodBeat.o(133835);
    return i + j + k;
  }
  
  private static int bAC(String paramString)
  {
    AppMethodBeat.i(237713);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(237713);
      return 0;
    }
    int k = paramString.length();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += N(paramString.charAt(i));
      i += 1;
    }
    i = axu(j);
    AppMethodBeat.o(237713);
    return i;
  }
  
  private static int bAD(String paramString)
  {
    AppMethodBeat.i(133836);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(133836);
      return 0;
    }
    int i = paramString.length();
    AppMethodBeat.o(133836);
    return i;
  }
  
  public static int bAE(String paramString)
  {
    AppMethodBeat.i(133837);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(133837);
      return 0;
    }
    paramString = Pattern.compile("[\\u4e00-\\u9fa5]").matcher(paramString);
    int i = 0;
    if (paramString.find())
    {
      int k = 0;
      int j = i;
      for (;;)
      {
        i = j;
        if (k > paramString.groupCount()) {
          break;
        }
        j += 1;
        k += 1;
      }
    }
    AppMethodBeat.o(133837);
    return i;
  }
  
  private static int bAF(String paramString)
  {
    AppMethodBeat.i(133838);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(133838);
      return 0;
    }
    int j = 0;
    int i = 0;
    int k;
    if (j < paramString.length())
    {
      k = paramString.charAt(j);
      if ((k < 0) || (k > 127)) {
        break label79;
      }
      i += 1;
    }
    label79:
    for (;;)
    {
      j += 1;
      break;
      j = paramString.length();
      k = bAE(paramString);
      AppMethodBeat.o(133838);
      return j - (k + i);
    }
  }
  
  public static int dp(int paramInt, String paramString)
  {
    AppMethodBeat.i(237727);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(237727);
      return -1;
    }
    Pattern localPattern = Pattern.compile("[\\u4e00-\\u9fa5]");
    int j = 0;
    int i = 0;
    while (j < paramString.length())
    {
      if (localPattern.matcher(paramString.charAt(j)).find()) {
        i += 2;
      }
      while (i >= paramInt)
      {
        AppMethodBeat.o(237727);
        return j;
        i += 1;
      }
      j += 1;
    }
    AppMethodBeat.o(237727);
    return -1;
  }
  
  public static int dq(int paramInt, String paramString)
  {
    AppMethodBeat.i(133839);
    if (LocaleUtil.isChineseAppLang())
    {
      i = bAB(paramString);
      AppMethodBeat.o(133839);
      return paramInt - i;
    }
    int i = bAB(paramString);
    AppMethodBeat.o(133839);
    return paramInt - i;
  }
  
  public static int dr(int paramInt, String paramString)
  {
    AppMethodBeat.i(133840);
    if (LocaleUtil.isChineseAppLang())
    {
      paramInt = Math.round((Math.round(bAB(paramString)) - paramInt) / 2.0F);
      AppMethodBeat.o(133840);
      return paramInt;
    }
    int i = bAB(paramString);
    AppMethodBeat.o(133840);
    return i - paramInt;
  }
  
  public static String hV(String paramString, int paramInt)
  {
    AppMethodBeat.i(237731);
    int i = 0;
    int j = 0;
    while (i < paramString.length())
    {
      if (paramString.charAt(i) > '') {}
      for (int k = 2;; k = 1)
      {
        j += k;
        if (j <= paramInt) {
          break;
        }
        paramString = paramString.substring(0, i);
        AppMethodBeat.o(237731);
        return paramString;
      }
      i += 1;
    }
    AppMethodBeat.o(237731);
    return paramString;
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(133833);
    if (a(paramSpanned.toString(), this.rvC) + a(paramCharSequence.toString(), this.rvC) > this.rvB)
    {
      AppMethodBeat.o(133833);
      return "";
    }
    AppMethodBeat.o(133833);
    return paramCharSequence;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(133832);
      XSt = new a("MODE_CHINESE_AS_1", 0);
      XSu = new a("MODE_CHINESE_AS_2", 1);
      XSv = new a("MODE_CHINESE_AS_3", 2);
      XSw = new a[] { XSt, XSu, XSv };
      AppMethodBeat.o(133832);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.g
 * JD-Core Version:    0.7.0.1
 */