package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.j.a.b.e;
import com.tencent.mm.pluginsdk.j.a.c.l;
import com.tencent.mm.pluginsdk.j.a.c.m;
import com.tencent.mm.pluginsdk.j.a.c.n.a;
import com.tencent.mm.pluginsdk.j.a.d.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

final class d
  extends n.a<c>
{
  public d(c paramc)
  {
    super(paramc);
  }
  
  public final String afw()
  {
    return "CheckResUpdate";
  }
  
  public final m b(com.tencent.mm.pluginsdk.j.a.c.j paramj)
  {
    AppMethodBeat.i(151948);
    c localc = (c)baG();
    String str1 = i.TH(localc.EPe);
    String str2 = localc.md5;
    if ((localc.DKf) && (bt.nullAsNil(com.tencent.mm.vfs.i.aPK(i.TH(localc.EPe))).equals(str2)))
    {
      ad.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "file already cached and valid, send complete status");
      paramj = new m(localc, a.gy(str1));
      AppMethodBeat.o(151948);
      return paramj;
    }
    if ((!bt.cC(((c)baG()).EPJ)) && (a.y(i.TH(((c)baG()).EPe), ((c)baG()).EPJ)) && (bt.nullAsNil(com.tencent.mm.vfs.i.aPK(i.TH(((c)baG()).EPe))).equals(((c)baG()).md5)))
    {
      paramj = new m((l)baG(), a.gy(i.TH(((c)baG()).EPe)));
      AppMethodBeat.o(151948);
      return paramj;
    }
    paramj = super.b(paramj);
    ad.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: network get over, received response = ".concat(String.valueOf(paramj)), new Object[] { localc.EPe });
    if (paramj == null)
    {
      paramj = new m("CheckResUpdate", faC(), getURL(), getFilePath(), 0L, "", 3, new e());
      AppMethodBeat.o(151948);
      return paramj;
    }
    if (paramj.status == 2)
    {
      if ((!bt.isNullOrNil(((c)baG()).md5)) && (((c)baG()).md5.equals(com.tencent.mm.vfs.i.aPK(getFilePath())))) {
        ad.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: file valid, md5 ok", new Object[] { localc.EPe });
      }
    }
    else
    {
      AppMethodBeat.o(151948);
      return paramj;
    }
    ad.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: file invalid, md5 not match", new Object[] { localc.EPe });
    paramj = new m("CheckResUpdate", faC(), getURL(), getFilePath(), paramj.aNU, paramj.contentType, 3, new com.tencent.mm.pluginsdk.j.a.b.c());
    AppMethodBeat.o(151948);
    return paramj;
  }
  
  public final boolean baF()
  {
    AppMethodBeat.i(151947);
    if (super.baF())
    {
      j.A(((c)baG()).DAq, 12L);
      AppMethodBeat.o(151947);
      return true;
    }
    j.A(((c)baG()).DAq, 27L);
    AppMethodBeat.o(151947);
    return false;
  }
  
  public final boolean sE(long paramLong)
  {
    AppMethodBeat.i(151946);
    if ((((c)baG()).fileSize > 0L) && (((c)baG()).fileSize != a.gy(getFilePath()) + paramLong))
    {
      AppMethodBeat.o(151946);
      return false;
    }
    boolean bool = super.sE(paramLong);
    AppMethodBeat.o(151946);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.a.d
 * JD-Core Version:    0.7.0.1
 */