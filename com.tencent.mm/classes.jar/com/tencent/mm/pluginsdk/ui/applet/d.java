package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.e;
import com.tencent.mm.al.a.k;
import com.tencent.mm.al.a.l;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.g;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.sdk.platformtools.bu;

public final class d
  implements x
{
  public final boolean aOc(String paramString)
  {
    AppMethodBeat.i(124373);
    boolean bool = g.vz(paramString);
    AppMethodBeat.o(124373);
    return bool;
  }
  
  public final Object aOd(String paramString)
  {
    AppMethodBeat.i(124374);
    k localk2 = ag.aGt().eP(paramString);
    k localk1;
    if ((localk2 != null) && (!bu.isNullOrNil(localk2.field_userId)))
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
  
  public final c aOe(String paramString)
  {
    AppMethodBeat.i(124375);
    c.a locala = new c.a();
    locala.prefixPath = e.EZ(paramString);
    locala.igk = true;
    locala.hgL = true;
    locala.igv = 2131690013;
    paramString = locala.aJu();
    AppMethodBeat.o(124375);
    return paramString;
  }
  
  public final String dN(Object paramObject)
  {
    return ((k)paramObject).field_userName;
  }
  
  public final String dO(Object paramObject)
  {
    return ((k)paramObject).field_headImageUrl;
  }
  
  public final String dP(Object paramObject)
  {
    return ((k)paramObject).field_userId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.d
 * JD-Core Version:    0.7.0.1
 */