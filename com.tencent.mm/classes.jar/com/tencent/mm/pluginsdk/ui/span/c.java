package com.tencent.mm.pluginsdk.ui.span;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public static c YnV;
  public int YnS;
  public int YnT;
  public a YnU;
  
  static
  {
    AppMethodBeat.i(152264);
    YnV = new c();
    AppMethodBeat.o(152264);
  }
  
  public final void brp(String paramString)
  {
    AppMethodBeat.i(152262);
    if (this.YnU == null) {
      this.YnU = new a((byte)0);
    }
    char[] arrayOfChar = paramString.toUpperCase().toCharArray();
    paramString = this.YnU;
    int i = 0;
    if (i < arrayOfChar.length)
    {
      int j = arrayOfChar[i];
      this.YnS += 1;
      if (j <= 57) {
        j -= 48;
      }
      for (;;)
      {
        if (paramString.YnW == null)
        {
          paramString.YnW = new a[36];
          this.YnT += 36;
        }
        if (paramString.YnW[j] == null)
        {
          paramString.YnW[j] = new a(0);
          this.YnT += 1;
        }
        paramString = paramString.YnW[j];
        if (i == arrayOfChar.length - 1) {
          paramString.HtY = true;
        }
        i += 1;
        break;
        j = j - 65 + 10;
      }
    }
    AppMethodBeat.o(152262);
  }
  
  public final boolean brq(String paramString)
  {
    AppMethodBeat.i(152263);
    if (this.YnU == null)
    {
      AppMethodBeat.o(152263);
      return false;
    }
    a locala = this.YnU;
    char[] arrayOfChar = paramString.toUpperCase().toCharArray();
    int i = 0;
    paramString = locala;
    while (i < arrayOfChar.length)
    {
      int j = arrayOfChar[i];
      if (j <= 57) {
        j -= 48;
      }
      while ((paramString == null) || (paramString.YnW == null))
      {
        AppMethodBeat.o(152263);
        return false;
        j = j - 65 + 10;
      }
      paramString = paramString.YnW[j];
      i += 1;
    }
    if (paramString != null)
    {
      boolean bool = paramString.HtY;
      AppMethodBeat.o(152263);
      return bool;
    }
    AppMethodBeat.o(152263);
    return false;
  }
  
  final class a
  {
    boolean HtY;
    a[] YnW;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.c
 * JD-Core Version:    0.7.0.1
 */