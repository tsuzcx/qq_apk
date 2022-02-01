package com.tencent.mm.pluginsdk.h.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.h.a.b.e;
import com.tencent.mm.pluginsdk.h.a.c.l;
import com.tencent.mm.pluginsdk.h.a.c.m;
import com.tencent.mm.pluginsdk.h.a.c.n.a;
import com.tencent.mm.pluginsdk.h.a.d.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

final class d
  extends n.a<c>
{
  public d(c paramc)
  {
    super(paramc);
  }
  
  public final boolean aXh()
  {
    AppMethodBeat.i(151947);
    if (super.aXh())
    {
      j.A(((c)aXi()).Dki, 12L);
      AppMethodBeat.o(151947);
      return true;
    }
    j.A(((c)aXi()).Dki, 27L);
    AppMethodBeat.o(151947);
    return false;
  }
  
  public final String azp()
  {
    return "CheckResUpdate";
  }
  
  public final m b(com.tencent.mm.pluginsdk.h.a.c.j paramj)
  {
    AppMethodBeat.i(151948);
    c localc = (c)aXi();
    String str1 = i.Qc(localc.Dkb);
    String str2 = localc.md5;
    if ((localc.CgY) && (bs.nullAsNil(com.tencent.mm.vfs.i.aKe(i.Qc(localc.Dkb))).equals(str2)))
    {
      ac.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "file already cached and valid, send complete status");
      paramj = new m(localc, a.fD(str1));
      AppMethodBeat.o(151948);
      return paramj;
    }
    if ((!bs.cv(((c)aXi()).DkH)) && (a.x(i.Qc(((c)aXi()).Dkb), ((c)aXi()).DkH)) && (bs.nullAsNil(com.tencent.mm.vfs.i.aKe(i.Qc(((c)aXi()).Dkb))).equals(((c)aXi()).md5)))
    {
      paramj = new m((l)aXi(), a.fD(i.Qc(((c)aXi()).Dkb)));
      AppMethodBeat.o(151948);
      return paramj;
    }
    paramj = super.b(paramj);
    ac.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: network get over, received response = ".concat(String.valueOf(paramj)), new Object[] { localc.Dkb });
    if (paramj == null)
    {
      paramj = new m("CheckResUpdate", eLF(), getURL(), getFilePath(), 0L, "", 3, new e());
      AppMethodBeat.o(151948);
      return paramj;
    }
    if (paramj.status == 2)
    {
      if ((!bs.isNullOrNil(((c)aXi()).md5)) && (((c)aXi()).md5.equals(com.tencent.mm.vfs.i.aKe(getFilePath())))) {
        ac.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: file valid, md5 ok", new Object[] { localc.Dkb });
      }
    }
    else
    {
      AppMethodBeat.o(151948);
      return paramj;
    }
    ac.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: file invalid, md5 not match", new Object[] { localc.Dkb });
    paramj = new m("CheckResUpdate", eLF(), getURL(), getFilePath(), paramj.aMd, paramj.contentType, 3, new com.tencent.mm.pluginsdk.h.a.b.c());
    AppMethodBeat.o(151948);
    return paramj;
  }
  
  public final boolean qG(long paramLong)
  {
    AppMethodBeat.i(151946);
    if ((((c)aXi()).fileSize > 0L) && (((c)aXi()).fileSize != a.fD(getFilePath()) + paramLong))
    {
      AppMethodBeat.o(151946);
      return false;
    }
    boolean bool = super.qG(paramLong);
    AppMethodBeat.o(151946);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.a.d
 * JD-Core Version:    0.7.0.1
 */