package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.j.a.b.e;
import com.tencent.mm.pluginsdk.j.a.c.l;
import com.tencent.mm.pluginsdk.j.a.c.m;
import com.tencent.mm.pluginsdk.j.a.c.n.a;
import com.tencent.mm.pluginsdk.j.a.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

final class d
  extends n.a<c>
{
  public d(c paramc)
  {
    super(paramc);
  }
  
  public final boolean AX(long paramLong)
  {
    AppMethodBeat.i(151946);
    if ((((c)bwt()).fileSize > 0L) && (((c)bwt()).fileSize != a.hv(getFilePath()) + paramLong))
    {
      AppMethodBeat.o(151946);
      return false;
    }
    boolean bool = super.AX(paramLong);
    AppMethodBeat.o(151946);
    return bool;
  }
  
  public final m a(com.tencent.mm.pluginsdk.j.a.c.j paramj)
  {
    AppMethodBeat.i(151948);
    c localc = (c)bwt();
    String str1 = i.aee(localc.JYs);
    String str2 = localc.md5;
    if ((localc.IOp) && (Util.nullAsNil(s.bhK(i.aee(localc.JYs))).equals(str2)))
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "file already cached and valid, send complete status");
      paramj = new m(localc, a.hv(str1));
      AppMethodBeat.o(151948);
      return paramj;
    }
    if ((!Util.isNullOrNil(((c)bwt()).JYY)) && (a.y(i.aee(((c)bwt()).JYs), ((c)bwt()).JYY)) && (Util.nullAsNil(s.bhK(i.aee(((c)bwt()).JYs))).equals(((c)bwt()).md5)))
    {
      paramj = new m((l)bwt(), a.hv(i.aee(((c)bwt()).JYs)));
      AppMethodBeat.o(151948);
      return paramj;
    }
    paramj = super.a(paramj);
    Log.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: network get over, received response = ".concat(String.valueOf(paramj)), new Object[] { localc.JYs });
    if (paramj == null)
    {
      paramj = new m("CheckResUpdate", gnA(), getURL(), getFilePath(), 0L, "", 3, new e());
      AppMethodBeat.o(151948);
      return paramj;
    }
    if (paramj.status == 2)
    {
      if ((!Util.isNullOrNil(((c)bwt()).md5)) && (((c)bwt()).md5.equals(s.bhK(getFilePath())))) {
        Log.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: file valid, md5 ok", new Object[] { localc.JYs });
      }
    }
    else
    {
      AppMethodBeat.o(151948);
      return paramj;
    }
    Log.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: file invalid, md5 not match", new Object[] { localc.JYs });
    paramj = new m("CheckResUpdate", gnA(), getURL(), getFilePath(), paramj.contentLength, paramj.contentType, 3, new com.tencent.mm.pluginsdk.j.a.b.c());
    AppMethodBeat.o(151948);
    return paramj;
  }
  
  public final String avy()
  {
    return "CheckResUpdate";
  }
  
  public final boolean bws()
  {
    AppMethodBeat.i(151947);
    if (super.bws())
    {
      j.F(((c)bwt()).IBJ, 12L);
      AppMethodBeat.o(151947);
      return true;
    }
    j.F(((c)bwt()).IBJ, 27L);
    AppMethodBeat.o(151947);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.a.d
 * JD-Core Version:    0.7.0.1
 */