package com.tencent.mm.pluginsdk.k.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.k.a.b.e;
import com.tencent.mm.pluginsdk.k.a.c.k;
import com.tencent.mm.pluginsdk.k.a.c.l;
import com.tencent.mm.pluginsdk.k.a.c.m.a;
import com.tencent.mm.pluginsdk.k.a.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;

final class d
  extends m.a<c>
{
  public d(c paramc)
  {
    super(paramc);
  }
  
  public final boolean Hj(long paramLong)
  {
    AppMethodBeat.i(151946);
    if ((((c)bHA()).fileSize > 0L) && (((c)bHA()).fileSize != a.ij(getFilePath()) + paramLong))
    {
      AppMethodBeat.o(151946);
      return false;
    }
    boolean bool = super.Hj(paramLong);
    AppMethodBeat.o(151946);
    return bool;
  }
  
  public final l a(com.tencent.mm.pluginsdk.k.a.c.j paramj)
  {
    AppMethodBeat.i(151948);
    c localc = (c)bHA();
    String str1 = i.alY(localc.QYU);
    String str2 = localc.md5;
    if ((localc.PKG) && (Util.nullAsNil(u.buc(i.alY(localc.QYU))).equals(str2)))
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "file already cached and valid, send complete status");
      paramj = new l(localc, a.ij(str1));
      AppMethodBeat.o(151948);
      return paramj;
    }
    if ((!Util.isNullOrNil(((c)bHA()).QZA)) && (a.D(i.alY(((c)bHA()).QYU), ((c)bHA()).QZA)) && (Util.nullAsNil(u.buc(i.alY(((c)bHA()).QYU))).equals(((c)bHA()).md5)))
    {
      paramj = new l((k)bHA(), a.ij(i.alY(((c)bHA()).QYU)));
      AppMethodBeat.o(151948);
      return paramj;
    }
    paramj = super.a(paramj);
    Log.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: network get over, received response = ".concat(String.valueOf(paramj)), new Object[] { localc.QYU });
    if (paramj == null)
    {
      paramj = new l("CheckResUpdate", hig(), btD(), getFilePath(), 0L, "", 3, new e());
      AppMethodBeat.o(151948);
      return paramj;
    }
    if (paramj.status == 2)
    {
      if ((!Util.isNullOrNil(((c)bHA()).md5)) && (((c)bHA()).md5.equals(u.buc(getFilePath())))) {
        Log.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: file valid, md5 ok", new Object[] { localc.QYU });
      }
    }
    else
    {
      AppMethodBeat.o(151948);
      return paramj;
    }
    Log.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: file invalid, md5 not match", new Object[] { localc.QYU });
    paramj = new l("CheckResUpdate", hig(), btD(), getFilePath(), paramj.contentLength, paramj.contentType, 3, new com.tencent.mm.pluginsdk.k.a.b.c());
    AppMethodBeat.o(151948);
    return paramj;
  }
  
  public final String aCt()
  {
    return "CheckResUpdate";
  }
  
  public final boolean bHz()
  {
    AppMethodBeat.i(151947);
    if (super.bHz())
    {
      j.F(((c)bHA()).PvW, 12L);
      AppMethodBeat.o(151947);
      return true;
    }
    j.F(((c)bHA()).PvW, 27L);
    AppMethodBeat.o(151947);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.k.a.a.d
 * JD-Core Version:    0.7.0.1
 */