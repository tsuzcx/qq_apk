package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.pluginsdk.g.a.b.e;
import com.tencent.mm.pluginsdk.g.a.c.l;
import com.tencent.mm.pluginsdk.g.a.c.m;
import com.tencent.mm.pluginsdk.g.a.c.n.a;
import com.tencent.mm.pluginsdk.g.a.d.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class d
  extends n.a<c>
{
  public d(c paramc)
  {
    super(paramc);
  }
  
  public final m a(com.tencent.mm.pluginsdk.g.a.c.j paramj)
  {
    AppMethodBeat.i(79505);
    c localc = (c)avY();
    String str1 = i.alH(localc.vMK);
    String str2 = localc.cqq;
    if ((localc.uOQ) && (bo.nullAsNil(g.getMD5(i.alH(localc.vMK))).equals(str2)))
    {
      ab.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "file already cached and valid, send complete status");
      paramj = new m(localc, a.eG(str1));
      AppMethodBeat.o(79505);
      return paramj;
    }
    if ((!bo.ce(((c)avY()).vNq)) && (a.D(i.alH(((c)avY()).vMK), ((c)avY()).vNq)) && (bo.nullAsNil(g.getMD5(i.alH(((c)avY()).vMK))).equals(((c)avY()).cqq)))
    {
      paramj = new m((l)avY(), a.eG(i.alH(((c)avY()).vMK)));
      AppMethodBeat.o(79505);
      return paramj;
    }
    paramj = super.a(paramj);
    ab.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: network get over, received response = ".concat(String.valueOf(paramj)), new Object[] { localc.vMK });
    if (paramj == null)
    {
      paramj = new m("CheckResUpdate", dlZ(), getURL(), getFilePath(), 0L, "", new e());
      AppMethodBeat.o(79505);
      return paramj;
    }
    if (paramj.status == 2)
    {
      if ((!bo.isNullOrNil(((c)avY()).cqq)) && (((c)avY()).cqq.equals(g.getMD5(getFilePath())))) {
        ab.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: file valid, md5 ok", new Object[] { localc.vMK });
      }
    }
    else
    {
      AppMethodBeat.o(79505);
      return paramj;
    }
    ab.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: file invalid, md5 not match", new Object[] { localc.vMK });
    paramj = new m("CheckResUpdate", dlZ(), getURL(), getFilePath(), paramj.bad, paramj.aZn, new com.tencent.mm.pluginsdk.g.a.b.c());
    AppMethodBeat.o(79505);
    return paramj;
  }
  
  public final String avS()
  {
    return "CheckResUpdate";
  }
  
  public final boolean avX()
  {
    AppMethodBeat.i(79504);
    if (super.avX())
    {
      j.B(((c)avY()).vMR, 12L);
      AppMethodBeat.o(79504);
      return true;
    }
    j.B(((c)avY()).vMR, 27L);
    AppMethodBeat.o(79504);
    return false;
  }
  
  public final boolean hq(long paramLong)
  {
    AppMethodBeat.i(79503);
    if ((((c)avY()).fileSize > 0L) && (((c)avY()).fileSize != a.eG(getFilePath()) + paramLong))
    {
      AppMethodBeat.o(79503);
      return false;
    }
    boolean bool = super.hq(paramLong);
    AppMethodBeat.o(79503);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.d
 * JD-Core Version:    0.7.0.1
 */