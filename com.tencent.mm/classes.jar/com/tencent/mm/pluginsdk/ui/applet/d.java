package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a.e;
import com.tencent.mm.aj.a.j;
import com.tencent.mm.aj.a.k;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.z;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.sdk.platformtools.bo;

public final class d
  implements p
{
  public final boolean ami(String paramString)
  {
    AppMethodBeat.i(11682);
    boolean bool = f.lg(paramString);
    AppMethodBeat.o(11682);
    return bool;
  }
  
  public final Object amj(String paramString)
  {
    AppMethodBeat.i(11683);
    j localj2 = z.afm().df(paramString);
    j localj1;
    if ((localj2 != null) && (!bo.isNullOrNil(localj2.field_userId)))
    {
      localj1 = localj2;
      if (localj2.field_userId.equals(paramString)) {}
    }
    else
    {
      localj1 = new j();
      localj1.field_userId = paramString;
    }
    AppMethodBeat.o(11683);
    return localj1;
  }
  
  public final c amk(String paramString)
  {
    AppMethodBeat.i(11684);
    c.a locala = new c.a();
    locala.eNP = e.su(paramString);
    locala.eNM = true;
    locala.eOe = true;
    locala.eNY = 2131231207;
    paramString = locala.ahY();
    AppMethodBeat.o(11684);
    return paramString;
  }
  
  public final String cn(Object paramObject)
  {
    return ((j)paramObject).field_userName;
  }
  
  public final String co(Object paramObject)
  {
    return ((j)paramObject).field_headImageUrl;
  }
  
  public final String cp(Object paramObject)
  {
    return ((j)paramObject).field_userId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.d
 * JD-Core Version:    0.7.0.1
 */