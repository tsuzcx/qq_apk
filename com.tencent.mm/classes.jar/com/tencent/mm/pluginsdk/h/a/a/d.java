package com.tencent.mm.pluginsdk.h.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.h.a.b.e;
import com.tencent.mm.pluginsdk.h.a.c.l;
import com.tencent.mm.pluginsdk.h.a.c.m;
import com.tencent.mm.pluginsdk.h.a.c.n.a;
import com.tencent.mm.pluginsdk.h.a.d.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

final class d
  extends n.a<c>
{
  public d(c paramc)
  {
    super(paramc);
  }
  
  public final boolean aQp()
  {
    AppMethodBeat.i(151947);
    if (super.aQp())
    {
      j.D(((c)aQq()).BRS, 12L);
      AppMethodBeat.o(151947);
      return true;
    }
    j.D(((c)aQq()).BRS, 27L);
    AppMethodBeat.o(151947);
    return false;
  }
  
  public final String asy()
  {
    return "CheckResUpdate";
  }
  
  public final m b(com.tencent.mm.pluginsdk.h.a.c.j paramj)
  {
    AppMethodBeat.i(151948);
    c localc = (c)aQq();
    String str1 = i.LW(localc.BRL);
    String str2 = localc.md5;
    if ((localc.AOH) && (bt.nullAsNil(com.tencent.mm.vfs.i.aEN(i.LW(localc.BRL))).equals(str2)))
    {
      ad.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "file already cached and valid, send complete status");
      paramj = new m(localc, a.fN(str1));
      AppMethodBeat.o(151948);
      return paramj;
    }
    if ((!bt.cw(((c)aQq()).BSr)) && (a.x(i.LW(((c)aQq()).BRL), ((c)aQq()).BSr)) && (bt.nullAsNil(com.tencent.mm.vfs.i.aEN(i.LW(((c)aQq()).BRL))).equals(((c)aQq()).md5)))
    {
      paramj = new m((l)aQq(), a.fN(i.LW(((c)aQq()).BRL)));
      AppMethodBeat.o(151948);
      return paramj;
    }
    paramj = super.b(paramj);
    ad.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: network get over, received response = ".concat(String.valueOf(paramj)), new Object[] { localc.BRL });
    if (paramj == null)
    {
      paramj = new m("CheckResUpdate", ewl(), getURL(), getFilePath(), 0L, "", 3, new e());
      AppMethodBeat.o(151948);
      return paramj;
    }
    if (paramj.status == 2)
    {
      if ((!bt.isNullOrNil(((c)aQq()).md5)) && (((c)aQq()).md5.equals(com.tencent.mm.vfs.i.aEN(getFilePath())))) {
        ad.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: file valid, md5 ok", new Object[] { localc.BRL });
      }
    }
    else
    {
      AppMethodBeat.o(151948);
      return paramj;
    }
    ad.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: file invalid, md5 not match", new Object[] { localc.BRL });
    paramj = new m("CheckResUpdate", ewl(), getURL(), getFilePath(), paramj.aLn, paramj.bxn, 3, new com.tencent.mm.pluginsdk.h.a.b.c());
    AppMethodBeat.o(151948);
    return paramj;
  }
  
  public final boolean mR(long paramLong)
  {
    AppMethodBeat.i(151946);
    if ((((c)aQq()).fileSize > 0L) && (((c)aQq()).fileSize != a.fN(getFilePath()) + paramLong))
    {
      AppMethodBeat.o(151946);
      return false;
    }
    boolean bool = super.mR(paramLong);
    AppMethodBeat.o(151946);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.a.d
 * JD-Core Version:    0.7.0.1
 */