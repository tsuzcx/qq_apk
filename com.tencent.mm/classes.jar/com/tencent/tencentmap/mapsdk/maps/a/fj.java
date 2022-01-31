package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class fj
{
  private final String[] a;
  
  fj()
  {
    AppMethodBeat.i(147935);
    this.a = new String[1024];
    AppMethodBeat.o(147935);
  }
  
  public final String a(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(147936);
    if (paramInt2 > 20)
    {
      paramArrayOfChar = new String(paramArrayOfChar, paramInt1, paramInt2);
      AppMethodBeat.o(147936);
      return paramArrayOfChar;
    }
    paramInt3 = paramInt3 >>> 20 ^ paramInt3 >>> 12 ^ paramInt3;
    int i = (paramInt3 ^ paramInt3 >>> 7 ^ paramInt3 >>> 4) & this.a.length - 1;
    String str = this.a[i];
    if ((str == null) || (str.length() != paramInt2))
    {
      paramArrayOfChar = new String(paramArrayOfChar, paramInt1, paramInt2);
      this.a[i] = paramArrayOfChar;
      AppMethodBeat.o(147936);
      return paramArrayOfChar;
    }
    paramInt3 = 0;
    while (paramInt3 < paramInt2)
    {
      if (str.charAt(paramInt3) != paramArrayOfChar[(paramInt1 + paramInt3)])
      {
        paramArrayOfChar = new String(paramArrayOfChar, paramInt1, paramInt2);
        this.a[i] = paramArrayOfChar;
        AppMethodBeat.o(147936);
        return paramArrayOfChar;
      }
      paramInt3 += 1;
    }
    AppMethodBeat.o(147936);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.fj
 * JD-Core Version:    0.7.0.1
 */