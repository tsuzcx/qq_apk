package com.tencent.mm.pluginsdk.ui.span;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static b DBT;
  public int DBQ;
  public int DBR;
  public a DBS;
  
  static
  {
    AppMethodBeat.i(152264);
    DBT = new b();
    AppMethodBeat.o(152264);
  }
  
  public final void aHD(String paramString)
  {
    AppMethodBeat.i(152262);
    if (this.DBS == null) {
      this.DBS = new a((byte)0);
    }
    char[] arrayOfChar = paramString.toUpperCase().toCharArray();
    paramString = this.DBS;
    int i = 0;
    if (i < arrayOfChar.length)
    {
      int j = arrayOfChar[i];
      this.DBQ += 1;
      if (j <= 57) {
        j -= 48;
      }
      for (;;)
      {
        if (paramString.DBU == null)
        {
          paramString.DBU = new a[36];
          this.DBR += 36;
        }
        if (paramString.DBU[j] == null)
        {
          paramString.DBU[j] = new a(0);
          this.DBR += 1;
        }
        paramString = paramString.DBU[j];
        if (i == arrayOfChar.length - 1) {
          paramString.szb = true;
        }
        i += 1;
        break;
        j = j - 65 + 10;
      }
    }
    AppMethodBeat.o(152262);
  }
  
  public final boolean aHE(String paramString)
  {
    AppMethodBeat.i(152263);
    if (this.DBS == null)
    {
      AppMethodBeat.o(152263);
      return false;
    }
    a locala = this.DBS;
    char[] arrayOfChar = paramString.toUpperCase().toCharArray();
    int i = 0;
    paramString = locala;
    while (i < arrayOfChar.length)
    {
      int j = arrayOfChar[i];
      if (j <= 57) {
        j -= 48;
      }
      while ((paramString == null) || (paramString.DBU == null))
      {
        AppMethodBeat.o(152263);
        return false;
        j = j - 65 + 10;
      }
      paramString = paramString.DBU[j];
      i += 1;
    }
    if (paramString != null)
    {
      boolean bool = paramString.szb;
      AppMethodBeat.o(152263);
      return bool;
    }
    AppMethodBeat.o(152263);
    return false;
  }
  
  final class a
  {
    a[] DBU;
    boolean szb;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.b
 * JD-Core Version:    0.7.0.1
 */