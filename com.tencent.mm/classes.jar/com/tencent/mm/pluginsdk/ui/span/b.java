package com.tencent.mm.pluginsdk.ui.span;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static b CjC;
  public int CjA;
  public a CjB;
  public int Cjz;
  
  static
  {
    AppMethodBeat.i(152264);
    CjC = new b();
    AppMethodBeat.o(152264);
  }
  
  public final void aCl(String paramString)
  {
    AppMethodBeat.i(152262);
    if (this.CjB == null) {
      this.CjB = new a((byte)0);
    }
    char[] arrayOfChar = paramString.toUpperCase().toCharArray();
    paramString = this.CjB;
    int i = 0;
    if (i < arrayOfChar.length)
    {
      int j = arrayOfChar[i];
      this.Cjz += 1;
      if (j <= 57) {
        j -= 48;
      }
      for (;;)
      {
        if (paramString.CjD == null)
        {
          paramString.CjD = new a[36];
          this.CjA += 36;
        }
        if (paramString.CjD[j] == null)
        {
          paramString.CjD[j] = new a(0);
          this.CjA += 1;
        }
        paramString = paramString.CjD[j];
        if (i == arrayOfChar.length - 1) {
          paramString.rqh = true;
        }
        i += 1;
        break;
        j = j - 65 + 10;
      }
    }
    AppMethodBeat.o(152262);
  }
  
  public final boolean aCm(String paramString)
  {
    AppMethodBeat.i(152263);
    if (this.CjB == null)
    {
      AppMethodBeat.o(152263);
      return false;
    }
    a locala = this.CjB;
    char[] arrayOfChar = paramString.toUpperCase().toCharArray();
    int i = 0;
    paramString = locala;
    while (i < arrayOfChar.length)
    {
      int j = arrayOfChar[i];
      if (j <= 57) {
        j -= 48;
      }
      while ((paramString == null) || (paramString.CjD == null))
      {
        AppMethodBeat.o(152263);
        return false;
        j = j - 65 + 10;
      }
      paramString = paramString.CjD[j];
      i += 1;
    }
    if (paramString != null)
    {
      boolean bool = paramString.rqh;
      AppMethodBeat.o(152263);
      return bool;
    }
    AppMethodBeat.o(152263);
    return false;
  }
  
  final class a
  {
    a[] CjD;
    boolean rqh;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.b
 * JD-Core Version:    0.7.0.1
 */