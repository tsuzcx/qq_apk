package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.a;
import com.tencent.tencentmap.mapsdk.a.b;

final class fk$1
  implements gd.b<String>
{
  fk$1(Class paramClass, b paramb) {}
  
  public final void a(String paramString)
  {
    AppMethodBeat.i(147937);
    fr.b("http get return data:\n" + paramString.toString());
    paramString = (a)fl.a(paramString.toString(), this.a);
    if (this.b != null)
    {
      if ((paramString != null) && (paramString.a()))
      {
        this.b.a(paramString.b, paramString);
        AppMethodBeat.o(147937);
        return;
      }
      if (paramString != null)
      {
        this.b.a(paramString.b, paramString.a, null);
        AppMethodBeat.o(147937);
        return;
      }
      this.b.a(-1, "unknown error", null);
    }
    AppMethodBeat.o(147937);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.fk.1
 * JD-Core Version:    0.7.0.1
 */