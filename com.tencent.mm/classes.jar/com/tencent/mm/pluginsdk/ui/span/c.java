package com.tencent.mm.pluginsdk.ui.span;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public static c RrH;
  public int RrE;
  public int RrF;
  public a RrG;
  
  static
  {
    AppMethodBeat.i(152264);
    RrH = new c();
    AppMethodBeat.o(152264);
  }
  
  public final void brB(String paramString)
  {
    AppMethodBeat.i(152262);
    if (this.RrG == null) {
      this.RrG = new a((byte)0);
    }
    char[] arrayOfChar = paramString.toUpperCase().toCharArray();
    paramString = this.RrG;
    int i = 0;
    if (i < arrayOfChar.length)
    {
      int j = arrayOfChar[i];
      this.RrE += 1;
      if (j <= 57) {
        j -= 48;
      }
      for (;;)
      {
        if (paramString.RrI == null)
        {
          paramString.RrI = new a[36];
          this.RrF += 36;
        }
        if (paramString.RrI[j] == null)
        {
          paramString.RrI[j] = new a(0);
          this.RrF += 1;
        }
        paramString = paramString.RrI[j];
        if (i == arrayOfChar.length - 1) {
          paramString.BJo = true;
        }
        i += 1;
        break;
        j = j - 65 + 10;
      }
    }
    AppMethodBeat.o(152262);
  }
  
  public final boolean brC(String paramString)
  {
    AppMethodBeat.i(152263);
    if (this.RrG == null)
    {
      AppMethodBeat.o(152263);
      return false;
    }
    a locala = this.RrG;
    char[] arrayOfChar = paramString.toUpperCase().toCharArray();
    int i = 0;
    paramString = locala;
    while (i < arrayOfChar.length)
    {
      int j = arrayOfChar[i];
      if (j <= 57) {
        j -= 48;
      }
      while ((paramString == null) || (paramString.RrI == null))
      {
        AppMethodBeat.o(152263);
        return false;
        j = j - 65 + 10;
      }
      paramString = paramString.RrI[j];
      i += 1;
    }
    if (paramString != null)
    {
      boolean bool = paramString.BJo;
      AppMethodBeat.o(152263);
      return bool;
    }
    AppMethodBeat.o(152263);
    return false;
  }
  
  final class a
  {
    boolean BJo;
    a[] RrI;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.c
 * JD-Core Version:    0.7.0.1
 */