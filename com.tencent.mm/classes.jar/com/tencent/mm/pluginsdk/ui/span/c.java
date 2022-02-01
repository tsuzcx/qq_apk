package com.tencent.mm.pluginsdk.ui.span;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public static c KqA;
  public int Kqx;
  public int Kqy;
  public a Kqz;
  
  static
  {
    AppMethodBeat.i(152264);
    KqA = new c();
    AppMethodBeat.o(152264);
  }
  
  public final void bff(String paramString)
  {
    AppMethodBeat.i(152262);
    if (this.Kqz == null) {
      this.Kqz = new a((byte)0);
    }
    char[] arrayOfChar = paramString.toUpperCase().toCharArray();
    paramString = this.Kqz;
    int i = 0;
    if (i < arrayOfChar.length)
    {
      int j = arrayOfChar[i];
      this.Kqx += 1;
      if (j <= 57) {
        j -= 48;
      }
      for (;;)
      {
        if (paramString.KqB == null)
        {
          paramString.KqB = new a[36];
          this.Kqy += 36;
        }
        if (paramString.KqB[j] == null)
        {
          paramString.KqB[j] = new a(0);
          this.Kqy += 1;
        }
        paramString = paramString.KqB[j];
        if (i == arrayOfChar.length - 1) {
          paramString.wXs = true;
        }
        i += 1;
        break;
        j = j - 65 + 10;
      }
    }
    AppMethodBeat.o(152262);
  }
  
  public final boolean bfg(String paramString)
  {
    AppMethodBeat.i(152263);
    if (this.Kqz == null)
    {
      AppMethodBeat.o(152263);
      return false;
    }
    a locala = this.Kqz;
    char[] arrayOfChar = paramString.toUpperCase().toCharArray();
    int i = 0;
    paramString = locala;
    while (i < arrayOfChar.length)
    {
      int j = arrayOfChar[i];
      if (j <= 57) {
        j -= 48;
      }
      while ((paramString == null) || (paramString.KqB == null))
      {
        AppMethodBeat.o(152263);
        return false;
        j = j - 65 + 10;
      }
      paramString = paramString.KqB[j];
      i += 1;
    }
    if (paramString != null)
    {
      boolean bool = paramString.wXs;
      AppMethodBeat.o(152263);
      return bool;
    }
    AppMethodBeat.o(152263);
    return false;
  }
  
  final class a
  {
    a[] KqB;
    boolean wXs;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.c
 * JD-Core Version:    0.7.0.1
 */