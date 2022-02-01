package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.a.e;
import com.tencent.mm.am.a.k;
import com.tencent.mm.am.a.l;
import com.tencent.mm.am.ag;
import com.tencent.mm.am.g;
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.sdk.platformtools.bt;

public final class d
  implements x
{
  public final boolean aMG(String paramString)
  {
    AppMethodBeat.i(124373);
    boolean bool = g.vd(paramString);
    AppMethodBeat.o(124373);
    return bool;
  }
  
  public final Object aMH(String paramString)
  {
    AppMethodBeat.i(124374);
    k localk2 = ag.aGd().eK(paramString);
    k localk1;
    if ((localk2 != null) && (!bt.isNullOrNil(localk2.field_userId)))
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
  
  public final c aMI(String paramString)
  {
    AppMethodBeat.i(124375);
    c.a locala = new c.a();
    locala.prefixPath = e.Ex(paramString);
    locala.idr = true;
    locala.hdX = true;
    locala.idD = 2131690013;
    paramString = locala.aJc();
    AppMethodBeat.o(124375);
    return paramString;
  }
  
  public final String dM(Object paramObject)
  {
    return ((k)paramObject).field_userName;
  }
  
  public final String dN(Object paramObject)
  {
    return ((k)paramObject).field_headImageUrl;
  }
  
  public final String dO(Object paramObject)
  {
    return ((k)paramObject).field_userId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.d
 * JD-Core Version:    0.7.0.1
 */