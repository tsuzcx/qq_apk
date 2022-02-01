package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.e;
import com.tencent.mm.al.a.k;
import com.tencent.mm.al.a.l;
import com.tencent.mm.al.af;
import com.tencent.mm.al.f;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.sdk.platformtools.bs;

public final class d
  implements x
{
  public final boolean aHd(String paramString)
  {
    AppMethodBeat.i(124373);
    boolean bool = f.so(paramString);
    AppMethodBeat.o(124373);
    return bool;
  }
  
  public final Object aHe(String paramString)
  {
    AppMethodBeat.i(124374);
    k localk2 = af.aDa().dP(paramString);
    k localk1;
    if ((localk2 != null) && (!bs.isNullOrNil(localk2.field_userId)))
    {
      localk1 = localk2;
      if (localk2.field_userId.equals(paramString)) {}
    }
    else
    {
      localk1 = new k();
      localk1.field_userId = paramString;
    }
    AppMethodBeat.o(124374);
    return localk1;
  }
  
  public final c aHf(String paramString)
  {
    AppMethodBeat.i(124375);
    c.a locala = new c.a();
    locala.prefixPath = e.By(paramString);
    locala.hKx = true;
    locala.gKm = true;
    locala.hKI = 2131690013;
    paramString = locala.aFT();
    AppMethodBeat.o(124375);
    return paramString;
  }
  
  public final String dJ(Object paramObject)
  {
    return ((k)paramObject).field_userName;
  }
  
  public final String dK(Object paramObject)
  {
    return ((k)paramObject).field_headImageUrl;
  }
  
  public final String dL(Object paramObject)
  {
    return ((k)paramObject).field_userId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.d
 * JD-Core Version:    0.7.0.1
 */