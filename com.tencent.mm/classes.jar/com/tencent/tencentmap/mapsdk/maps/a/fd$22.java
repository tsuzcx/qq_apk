package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class fd$22
  implements ec
{
  fd$22(Class paramClass1, Class paramClass2, eb parameb) {}
  
  public final <T> eb<T> a(dk paramdk, fe<T> paramfe)
  {
    AppMethodBeat.i(147792);
    paramdk = paramfe.a();
    if ((paramdk == this.a) || (paramdk == this.b))
    {
      paramdk = this.c;
      AppMethodBeat.o(147792);
      return paramdk;
    }
    AppMethodBeat.o(147792);
    return null;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(147793);
    String str = "Factory[type=" + this.b.getName() + "+" + this.a.getName() + ",adapter=" + this.c + "]";
    AppMethodBeat.o(147793);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.fd.22
 * JD-Core Version:    0.7.0.1
 */