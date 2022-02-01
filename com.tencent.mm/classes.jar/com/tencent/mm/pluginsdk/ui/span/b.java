package com.tencent.mm.pluginsdk.ui.span;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static b Fzy;
  public int Fzv;
  public int Fzw;
  public a Fzx;
  
  static
  {
    AppMethodBeat.i(152264);
    Fzy = new b();
    AppMethodBeat.o(152264);
  }
  
  public final void aOD(String paramString)
  {
    AppMethodBeat.i(152262);
    if (this.Fzx == null) {
      this.Fzx = new a((byte)0);
    }
    char[] arrayOfChar = paramString.toUpperCase().toCharArray();
    paramString = this.Fzx;
    int i = 0;
    if (i < arrayOfChar.length)
    {
      int j = arrayOfChar[i];
      this.Fzv += 1;
      if (j <= 57) {
        j -= 48;
      }
      for (;;)
      {
        if (paramString.Fzz == null)
        {
          paramString.Fzz = new a[36];
          this.Fzw += 36;
        }
        if (paramString.Fzz[j] == null)
        {
          paramString.Fzz[j] = new a(0);
          this.Fzw += 1;
        }
        paramString = paramString.Fzz[j];
        if (i == arrayOfChar.length - 1) {
          paramString.tGt = true;
        }
        i += 1;
        break;
        j = j - 65 + 10;
      }
    }
    AppMethodBeat.o(152262);
  }
  
  public final boolean aOE(String paramString)
  {
    AppMethodBeat.i(152263);
    if (this.Fzx == null)
    {
      AppMethodBeat.o(152263);
      return false;
    }
    a locala = this.Fzx;
    char[] arrayOfChar = paramString.toUpperCase().toCharArray();
    int i = 0;
    paramString = locala;
    while (i < arrayOfChar.length)
    {
      int j = arrayOfChar[i];
      if (j <= 57) {
        j -= 48;
      }
      while ((paramString == null) || (paramString.Fzz == null))
      {
        AppMethodBeat.o(152263);
        return false;
        j = j - 65 + 10;
      }
      paramString = paramString.Fzz[j];
      i += 1;
    }
    if (paramString != null)
    {
      boolean bool = paramString.tGt;
      AppMethodBeat.o(152263);
      return bool;
    }
    AppMethodBeat.o(152263);
    return false;
  }
  
  final class a
  {
    a[] Fzz;
    boolean tGt;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.b
 * JD-Core Version:    0.7.0.1
 */