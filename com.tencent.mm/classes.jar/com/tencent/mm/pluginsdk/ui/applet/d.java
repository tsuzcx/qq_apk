package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.a.e;
import com.tencent.mm.an.a.k;
import com.tencent.mm.an.a.l;
import com.tencent.mm.an.af;
import com.tencent.mm.an.g;
import com.tencent.mm.modelimage.loader.a.c;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.plugin.biz.b.e;
import com.tencent.mm.sdk.platformtools.Util;

public final class d
  implements x
{
  public final boolean bqO(String paramString)
  {
    AppMethodBeat.i(124373);
    boolean bool = g.Dn(paramString);
    AppMethodBeat.o(124373);
    return bool;
  }
  
  public final Object bqP(String paramString)
  {
    AppMethodBeat.i(124374);
    k localk2 = af.bHj().hM(paramString);
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
  
  public final c bqQ(String paramString)
  {
    AppMethodBeat.i(124375);
    c.a locala = new c.a();
    locala.prefixPath = e.Ni(paramString);
    locala.oKp = true;
    locala.nqa = true;
    locala.oKB = b.e.default_avatar;
    paramString = locala.bKx();
    AppMethodBeat.o(124375);
    return paramString;
  }
  
  public final String gx(Object paramObject)
  {
    return ((k)paramObject).field_userName;
  }
  
  public final String gy(Object paramObject)
  {
    return ((k)paramObject).field_headImageUrl;
  }
  
  public final String gz(Object paramObject)
  {
    return ((k)paramObject).field_userId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.d
 * JD-Core Version:    0.7.0.1
 */