package com.tencent.mm.ui.tools;

import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class f
  implements InputFilter
{
  private int mce;
  private a mcf;
  
  public f(int paramInt, a parama)
  {
    this.mce = paramInt;
    this.mcf = parama;
  }
  
  public static int a(String paramString, a parama)
  {
    AppMethodBeat.i(133834);
    int i;
    if (parama == a.Hrl)
    {
      i = aLK(paramString);
      AppMethodBeat.o(133834);
      return i;
    }
    if (parama == a.Hrm)
    {
      i = aLJ(paramString);
      AppMethodBeat.o(133834);
      return i;
    }
    AppMethodBeat.o(133834);
    return 0;
  }
  
  public static int aLJ(String paramString)
  {
    AppMethodBeat.i(133835);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(133835);
      return 0;
    }
    int i = paramString.length();
    int j = aLL(paramString);
    int k = aLM(paramString);
    AppMethodBeat.o(133835);
    return i + j + k;
  }
  
  private static int aLK(String paramString)
  {
    AppMethodBeat.i(133836);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(133836);
      return 0;
    }
    int i = paramString.length();
    AppMethodBeat.o(133836);
    return i;
  }
  
  public static int aLL(String paramString)
  {
    AppMethodBeat.i(133837);
    if (bt.isNullOrNil(paramString))
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
  
  private static int aLM(String paramString)
  {
    AppMethodBeat.i(133838);
    if (bt.isNullOrNil(paramString))
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
      k = aLL(paramString);
      AppMethodBeat.o(133838);
      return j - (k + i);
    }
  }
  
  public static int cJ(int paramInt, String paramString)
  {
    AppMethodBeat.i(133839);
    if (ac.eFq())
    {
      i = aLJ(paramString);
      AppMethodBeat.o(133839);
      return paramInt - i;
    }
    int i = aLJ(paramString);
    AppMethodBeat.o(133839);
    return paramInt - i;
  }
  
  public static int cK(int paramInt, String paramString)
  {
    AppMethodBeat.i(133840);
    if (ac.eFq())
    {
      paramInt = Math.round((Math.round(aLJ(paramString)) - paramInt) / 2.0F);
      AppMethodBeat.o(133840);
      return paramInt;
    }
    int i = aLJ(paramString);
    AppMethodBeat.o(133840);
    return i - paramInt;
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(133833);
    if (a(paramSpanned.toString(), this.mcf) + a(paramCharSequence.toString(), this.mcf) > this.mce)
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
      Hrl = new a("MODE_CHINESE_AS_1", 0);
      Hrm = new a("MODE_CHINESE_AS_2", 1);
      Hrn = new a[] { Hrl, Hrm };
      AppMethodBeat.o(133832);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.f
 * JD-Core Version:    0.7.0.1
 */