package com.tencent.mm.ui.tools;

import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class f
  implements InputFilter
{
  private int jmo;
  private a jmp;
  
  public f(int paramInt, a parama)
  {
    this.jmo = paramInt;
    this.jmp = parama;
  }
  
  public static int a(String paramString, a parama)
  {
    AppMethodBeat.i(67859);
    int i;
    if (parama == a.Avm)
    {
      i = auR(paramString);
      AppMethodBeat.o(67859);
      return i;
    }
    if (parama == a.Avn)
    {
      i = auQ(paramString);
      AppMethodBeat.o(67859);
      return i;
    }
    AppMethodBeat.o(67859);
    return 0;
  }
  
  public static int auQ(String paramString)
  {
    AppMethodBeat.i(67860);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(67860);
      return 0;
    }
    int i = paramString.length();
    int j = auS(paramString);
    int k = auT(paramString);
    AppMethodBeat.o(67860);
    return i + j + k;
  }
  
  private static int auR(String paramString)
  {
    AppMethodBeat.i(67861);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(67861);
      return 0;
    }
    int i = paramString.length();
    AppMethodBeat.o(67861);
    return i;
  }
  
  public static int auS(String paramString)
  {
    AppMethodBeat.i(67862);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(67862);
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
    AppMethodBeat.o(67862);
    return i;
  }
  
  private static int auT(String paramString)
  {
    AppMethodBeat.i(67863);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(67863);
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
      k = auS(paramString);
      AppMethodBeat.o(67863);
      return j - (k + i);
    }
  }
  
  public static int bO(int paramInt, String paramString)
  {
    AppMethodBeat.i(67864);
    if (aa.dsC())
    {
      paramInt = Math.round((paramInt - Math.round(auQ(paramString))) / 2.0F);
      AppMethodBeat.o(67864);
      return paramInt;
    }
    int i = auQ(paramString);
    AppMethodBeat.o(67864);
    return paramInt - i;
  }
  
  public static int bP(int paramInt, String paramString)
  {
    AppMethodBeat.i(67865);
    if (aa.dsC())
    {
      paramInt = Math.round((Math.round(auQ(paramString)) - paramInt) / 2.0F);
      AppMethodBeat.o(67865);
      return paramInt;
    }
    int i = auQ(paramString);
    AppMethodBeat.o(67865);
    return i - paramInt;
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(67858);
    if (a(paramSpanned.toString(), this.jmp) + a(paramCharSequence.toString(), this.jmp) > this.jmo)
    {
      AppMethodBeat.o(67858);
      return "";
    }
    AppMethodBeat.o(67858);
    return paramCharSequence;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(67857);
      Avm = new a("MODE_CHINESE_AS_1", 0);
      Avn = new a("MODE_CHINESE_AS_2", 1);
      Avo = new a[] { Avm, Avn };
      AppMethodBeat.o(67857);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.f
 * JD-Core Version:    0.7.0.1
 */