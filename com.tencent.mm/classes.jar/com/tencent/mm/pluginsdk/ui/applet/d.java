package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.a.e;
import com.tencent.mm.am.a.k;
import com.tencent.mm.am.a.l;
import com.tencent.mm.am.af;
import com.tencent.mm.am.f;
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.sdk.platformtools.bt;

public final class d
  implements x
{
  public final boolean aBL(String paramString)
  {
    AppMethodBeat.i(124373);
    boolean bool = f.pc(paramString);
    AppMethodBeat.o(124373);
    return bool;
  }
  
  public final Object aBM(String paramString)
  {
    AppMethodBeat.i(124374);
    k localk2 = af.awi().ea(paramString);
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
  
  public final c aBN(String paramString)
  {
    AppMethodBeat.i(124375);
    c.a locala = new c.a();
    locala.prefixPath = e.xs(paramString);
    locala.hjU = true;
    locala.gjA = true;
    locala.hkf = 2131690013;
    paramString = locala.azc();
    AppMethodBeat.o(124375);
    return paramString;
  }
  
  public final String dI(Object paramObject)
  {
    return ((k)paramObject).field_userName;
  }
  
  public final String dJ(Object paramObject)
  {
    return ((k)paramObject).field_headImageUrl;
  }
  
  public final String dK(Object paramObject)
  {
    return ((k)paramObject).field_userId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.d
 * JD-Core Version:    0.7.0.1
 */