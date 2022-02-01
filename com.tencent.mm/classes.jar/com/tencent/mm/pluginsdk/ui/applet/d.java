package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.e;
import com.tencent.mm.al.a.k;
import com.tencent.mm.al.a.l;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.g;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.sdk.platformtools.Util;

public final class d
  implements x
{
  public final boolean beE(String paramString)
  {
    AppMethodBeat.i(124373);
    boolean bool = g.DQ(paramString);
    AppMethodBeat.o(124373);
    return bool;
  }
  
  public final Object beF(String paramString)
  {
    AppMethodBeat.i(124374);
    k localk2 = ag.bal().fB(paramString);
    k localk1;
    if ((localk2 != null) && (!Util.isNullOrNil(localk2.field_userId)))
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
  
  public final c beG(String paramString)
  {
    AppMethodBeat.i(124375);
    c.a locala = new c.a();
    locala.prefixPath = e.NN(paramString);
    locala.jbf = true;
    locala.hZF = true;
    locala.jbq = 2131690042;
    paramString = locala.bdv();
    AppMethodBeat.o(124375);
    return paramString;
  }
  
  public final String dX(Object paramObject)
  {
    return ((k)paramObject).field_userName;
  }
  
  public final String dY(Object paramObject)
  {
    return ((k)paramObject).field_headImageUrl;
  }
  
  public final String dZ(Object paramObject)
  {
    return ((k)paramObject).field_userId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.d
 * JD-Core Version:    0.7.0.1
 */