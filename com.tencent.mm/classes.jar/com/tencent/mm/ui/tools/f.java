package com.tencent.mm.ui.tools;

import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class f
  implements InputFilter
{
  private int otr;
  private a ots;
  
  public f(int paramInt, a parama)
  {
    this.otr = paramInt;
    this.ots = parama;
  }
  
  public static int a(String paramString, a parama)
  {
    AppMethodBeat.i(133834);
    int i;
    if (parama == a.Quh)
    {
      i = bnQ(paramString);
      AppMethodBeat.o(133834);
      return i;
    }
    if (parama == a.Qui)
    {
      i = bnP(paramString);
      AppMethodBeat.o(133834);
      return i;
    }
    AppMethodBeat.o(133834);
    return 0;
  }
  
  public static int bnP(String paramString)
  {
    AppMethodBeat.i(133835);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(133835);
      return 0;
    }
    int i = paramString.length();
    int j = bnR(paramString);
    int k = bnS(paramString);
    AppMethodBeat.o(133835);
    return i + j + k;
  }
  
  private static int bnQ(String paramString)
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
  
  public static int bnR(String paramString)
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
  
  private static int bnS(String paramString)
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
      k = bnR(paramString);
      AppMethodBeat.o(133838);
      return j - (k + i);
    }
  }
  
  public static int dp(int paramInt, String paramString)
  {
    AppMethodBeat.i(133839);
    if (LocaleUtil.isChineseAppLang())
    {
      i = bnP(paramString);
      AppMethodBeat.o(133839);
      return paramInt - i;
    }
    int i = bnP(paramString);
    AppMethodBeat.o(133839);
    return paramInt - i;
  }
  
  public static int dq(int paramInt, String paramString)
  {
    AppMethodBeat.i(133840);
    if (LocaleUtil.isChineseAppLang())
    {
      paramInt = Math.round((Math.round(bnP(paramString)) - paramInt) / 2.0F);
      AppMethodBeat.o(133840);
      return paramInt;
    }
    int i = bnP(paramString);
    AppMethodBeat.o(133840);
    return i - paramInt;
  }
  
  public static String hm(String paramString, int paramInt)
  {
    AppMethodBeat.i(196233);
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
        AppMethodBeat.o(196233);
        return paramString;
      }
      i += 1;
    }
    AppMethodBeat.o(196233);
    return paramString;
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(133833);
    if (a(paramSpanned.toString(), this.ots) + a(paramCharSequence.toString(), this.ots) > this.otr)
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
      Quh = new a("MODE_CHINESE_AS_1", 0);
      Qui = new a("MODE_CHINESE_AS_2", 1);
      Quj = new a[] { Quh, Qui };
      AppMethodBeat.o(133832);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.f
 * JD-Core Version:    0.7.0.1
 */