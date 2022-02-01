package com.tencent.mm.pluginsdk.ui.span;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static b Fha;
  public int FgX;
  public int FgY;
  public a FgZ;
  
  static
  {
    AppMethodBeat.i(152264);
    Fha = new b();
    AppMethodBeat.o(152264);
  }
  
  public final void aNg(String paramString)
  {
    AppMethodBeat.i(152262);
    if (this.FgZ == null) {
      this.FgZ = new a((byte)0);
    }
    char[] arrayOfChar = paramString.toUpperCase().toCharArray();
    paramString = this.FgZ;
    int i = 0;
    if (i < arrayOfChar.length)
    {
      int j = arrayOfChar[i];
      this.FgX += 1;
      if (j <= 57) {
        j -= 48;
      }
      for (;;)
      {
        if (paramString.Fhb == null)
        {
          paramString.Fhb = new a[36];
          this.FgY += 36;
        }
        if (paramString.Fhb[j] == null)
        {
          paramString.Fhb[j] = new a(0);
          this.FgY += 1;
        }
        paramString = paramString.Fhb[j];
        if (i == arrayOfChar.length - 1) {
          paramString.tvC = true;
        }
        i += 1;
        break;
        j = j - 65 + 10;
      }
    }
    AppMethodBeat.o(152262);
  }
  
  public final boolean aNh(String paramString)
  {
    AppMethodBeat.i(152263);
    if (this.FgZ == null)
    {
      AppMethodBeat.o(152263);
      return false;
    }
    a locala = this.FgZ;
    char[] arrayOfChar = paramString.toUpperCase().toCharArray();
    int i = 0;
    paramString = locala;
    while (i < arrayOfChar.length)
    {
      int j = arrayOfChar[i];
      if (j <= 57) {
        j -= 48;
      }
      while ((paramString == null) || (paramString.Fhb == null))
      {
        AppMethodBeat.o(152263);
        return false;
        j = j - 65 + 10;
      }
      paramString = paramString.Fhb[j];
      i += 1;
    }
    if (paramString != null)
    {
      boolean bool = paramString.tvC;
      AppMethodBeat.o(152263);
      return bool;
    }
    AppMethodBeat.o(152263);
    return false;
  }
  
  final class a
  {
    a[] Fhb;
    boolean tvC;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.b
 * JD-Core Version:    0.7.0.1
 */