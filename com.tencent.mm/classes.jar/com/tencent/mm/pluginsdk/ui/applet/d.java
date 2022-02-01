package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.a.e;
import com.tencent.mm.ao.a.k;
import com.tencent.mm.ao.a.l;
import com.tencent.mm.ao.af;
import com.tencent.mm.ao.g;
import com.tencent.mm.ay.a.a.c;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.plugin.biz.b.e;
import com.tencent.mm.sdk.platformtools.Util;

public final class d
  implements x
{
  public final boolean bra(String paramString)
  {
    AppMethodBeat.i(124373);
    boolean bool = g.KI(paramString);
    AppMethodBeat.o(124373);
    return bool;
  }
  
  public final Object brb(String paramString)
  {
    AppMethodBeat.i(124374);
    k localk2 = af.bjz().gm(paramString);
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
  
  public final c brc(String paramString)
  {
    AppMethodBeat.i(124375);
    c.a locala = new c.a();
    locala.prefixPath = e.Vj(paramString);
    locala.lRD = true;
    locala.kOl = true;
    locala.lRP = b.e.default_avatar;
    paramString = locala.bmL();
    AppMethodBeat.o(124375);
    return paramString;
  }
  
  public final String eb(Object paramObject)
  {
    return ((k)paramObject).field_userName;
  }
  
  public final String ec(Object paramObject)
  {
    return ((k)paramObject).field_headImageUrl;
  }
  
  public final String ed(Object paramObject)
  {
    return ((k)paramObject).field_userId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.d
 * JD-Core Version:    0.7.0.1
 */