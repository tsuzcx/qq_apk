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
  private int uGH;
  private a uGI;
  
  public g(int paramInt, a parama)
  {
    this.uGH = paramInt;
    this.uGI = parama;
  }
  
  public static int G(char paramChar)
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
    if (parama == a.afIH)
    {
      i = bCz(paramString);
      AppMethodBeat.o(133834);
      return i;
    }
    if (parama == a.afII)
    {
      i = bCx(paramString);
      AppMethodBeat.o(133834);
      return i;
    }
    if (parama == a.afIJ)
    {
      i = bCy(paramString);
      AppMethodBeat.o(133834);
      return i;
    }
    AppMethodBeat.o(133834);
    return 0;
  }
  
  public static int aEd(int paramInt)
  {
    if (paramInt % 2 != 0) {
      return (paramInt + 1) / 2;
    }
    return paramInt / 2;
  }
  
  public static int bCA(String paramString)
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
  
  private static int bCB(String paramString)
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
      k = bCA(paramString);
      AppMethodBeat.o(133838);
      return j - (k + i);
    }
  }
  
  public static int bCx(String paramString)
  {
    AppMethodBeat.i(133835);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(133835);
      return 0;
    }
    int i = paramString.length();
    int j = bCA(paramString);
    int k = bCB(paramString);
    AppMethodBeat.o(133835);
    return i + j + k;
  }
  
  public static int bCy(String paramString)
  {
    AppMethodBeat.i(251044);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(251044);
      return 0;
    }
    int k = paramString.length();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += G(paramString.charAt(i));
      i += 1;
    }
    i = aEd(j);
    AppMethodBeat.o(251044);
    return i;
  }
  
  private static int bCz(String paramString)
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
  
  public static int ei(int paramInt, String paramString)
  {
    AppMethodBeat.i(251052);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(251052);
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
        AppMethodBeat.o(251052);
        return j;
        i += 1;
      }
      j += 1;
    }
    AppMethodBeat.o(251052);
    return -1;
  }
  
  public static int ej(int paramInt, String paramString)
  {
    AppMethodBeat.i(133839);
    if (LocaleUtil.isChineseAppLang())
    {
      i = bCx(paramString);
      AppMethodBeat.o(133839);
      return paramInt - i;
    }
    int i = bCx(paramString);
    AppMethodBeat.o(133839);
    return paramInt - i;
  }
  
  public static int ek(int paramInt, String paramString)
  {
    AppMethodBeat.i(133840);
    if (LocaleUtil.isChineseAppLang())
    {
      paramInt = Math.round((Math.round(bCx(paramString)) - paramInt) / 2.0F);
      AppMethodBeat.o(133840);
      return paramInt;
    }
    int i = bCx(paramString);
    AppMethodBeat.o(133840);
    return i - paramInt;
  }
  
  public static String jd(String paramString, int paramInt)
  {
    AppMethodBeat.i(251058);
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
        AppMethodBeat.o(251058);
        return paramString;
      }
      i += 1;
    }
    AppMethodBeat.o(251058);
    return paramString;
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(133833);
    if (a(paramSpanned.toString(), this.uGI) + a(paramCharSequence.toString(), this.uGI) > this.uGH)
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
      afIH = new a("MODE_CHINESE_AS_1", 0);
      afII = new a("MODE_CHINESE_AS_2", 1);
      afIJ = new a("MODE_CHINESE_AS_3", 2);
      afIK = new a[] { afIH, afII, afIJ };
      AppMethodBeat.o(133832);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.g
 * JD-Core Version:    0.7.0.1
 */