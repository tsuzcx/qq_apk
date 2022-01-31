package com.tencent.mm.ui.tools;

import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class f
  implements InputFilter
{
  private int hui;
  private a huj;
  
  public f(int paramInt, a parama)
  {
    this.hui = paramInt;
    this.huj = parama;
  }
  
  public static int a(String paramString, a parama)
  {
    if (parama == a.wcS) {
      if (!bk.bl(paramString)) {}
    }
    while (parama != a.wcT)
    {
      return 0;
      return paramString.length();
    }
    return aek(paramString);
  }
  
  public static int aek(String paramString)
  {
    int i = 0;
    if (bk.bl(paramString)) {
      return 0;
    }
    int k = paramString.length();
    int m = ael(paramString);
    if (bk.bl(paramString)) {
      return i + (k + m);
    }
    int j = 0;
    i = 0;
    label40:
    if (j < paramString.length())
    {
      int n = paramString.charAt(j);
      if ((n < 0) || (n > 127)) {
        break label93;
      }
      i += 1;
    }
    label93:
    for (;;)
    {
      j += 1;
      break label40;
      i = paramString.length() - (ael(paramString) + i);
      break;
    }
  }
  
  public static int ael(String paramString)
  {
    if (bk.bl(paramString)) {
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
    return i;
  }
  
  public static int bi(int paramInt, String paramString)
  {
    if (x.cqF()) {
      return Math.round((paramInt - Math.round(aek(paramString))) / 2.0F);
    }
    return paramInt - aek(paramString);
  }
  
  public static int bj(int paramInt, String paramString)
  {
    if (x.cqF()) {
      return Math.round((Math.round(aek(paramString)) - paramInt) / 2.0F);
    }
    return aek(paramString) - paramInt;
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    Object localObject = paramCharSequence;
    if (a(paramSpanned.toString(), this.huj) + a(paramCharSequence.toString(), this.huj) > this.hui) {
      localObject = "";
    }
    return localObject;
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.f
 * JD-Core Version:    0.7.0.1
 */