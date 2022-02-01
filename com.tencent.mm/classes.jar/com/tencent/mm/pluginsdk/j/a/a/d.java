package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.j.a.b.e;
import com.tencent.mm.pluginsdk.j.a.c.l;
import com.tencent.mm.pluginsdk.j.a.c.m;
import com.tencent.mm.pluginsdk.j.a.c.n.a;
import com.tencent.mm.pluginsdk.j.a.d.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;

final class d
  extends n.a<c>
{
  public d(c paramc)
  {
    super(paramc);
  }
  
  public final String afK()
  {
    return "CheckResUpdate";
  }
  
  public final m b(com.tencent.mm.pluginsdk.j.a.c.j paramj)
  {
    AppMethodBeat.i(151948);
    c localc = (c)bbf();
    String str1 = i.Uq(localc.Fhz);
    String str2 = localc.md5;
    if ((localc.Ecd) && (bu.nullAsNil(o.aRh(i.Uq(localc.Fhz))).equals(str2)))
    {
      ae.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "file already cached and valid, send complete status");
      paramj = new m(localc, a.gE(str1));
      AppMethodBeat.o(151948);
      return paramj;
    }
    if ((!bu.cF(((c)bbf()).Fie)) && (a.y(i.Uq(((c)bbf()).Fhz), ((c)bbf()).Fie)) && (bu.nullAsNil(o.aRh(i.Uq(((c)bbf()).Fhz))).equals(((c)bbf()).md5)))
    {
      paramj = new m((l)bbf(), a.gE(i.Uq(((c)bbf()).Fhz)));
      AppMethodBeat.o(151948);
      return paramj;
    }
    paramj = super.b(paramj);
    ae.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: network get over, received response = ".concat(String.valueOf(paramj)), new Object[] { localc.Fhz });
    if (paramj == null)
    {
      paramj = new m("CheckResUpdate", feq(), getURL(), getFilePath(), 0L, "", 3, new e());
      AppMethodBeat.o(151948);
      return paramj;
    }
    if (paramj.status == 2)
    {
      if ((!bu.isNullOrNil(((c)bbf()).md5)) && (((c)bbf()).md5.equals(o.aRh(getFilePath())))) {
        ae.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: file valid, md5 ok", new Object[] { localc.Fhz });
      }
    }
    else
    {
      AppMethodBeat.o(151948);
      return paramj;
    }
    ae.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: file invalid, md5 not match", new Object[] { localc.Fhz });
    paramj = new m("CheckResUpdate", feq(), getURL(), getFilePath(), paramj.aNU, paramj.contentType, 3, new com.tencent.mm.pluginsdk.j.a.b.c());
    AppMethodBeat.o(151948);
    return paramj;
  }
  
  public final boolean bbe()
  {
    AppMethodBeat.i(151947);
    if (super.bbe())
    {
      j.A(((c)bbf()).DRK, 12L);
      AppMethodBeat.o(151947);
      return true;
    }
    j.A(((c)bbf()).DRK, 27L);
    AppMethodBeat.o(151947);
    return false;
  }
  
  public final boolean sR(long paramLong)
  {
    AppMethodBeat.i(151946);
    if ((((c)bbf()).fileSize > 0L) && (((c)bbf()).fileSize != a.gE(getFilePath()) + paramLong))
    {
      AppMethodBeat.o(151946);
      return false;
    }
    boolean bool = super.sR(paramLong);
    AppMethodBeat.o(151946);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.a.d
 * JD-Core Version:    0.7.0.1
 */