package com.tencent.mm.pluginsdk.res.downloader.checkresupdate;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.res.downloader.a.e;
import com.tencent.mm.pluginsdk.res.downloader.b.a;
import com.tencent.mm.pluginsdk.res.downloader.model.k;
import com.tencent.mm.pluginsdk.res.downloader.model.l;
import com.tencent.mm.pluginsdk.res.downloader.model.m.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;

final class d
  extends m.a<c>
{
  public d(c paramc)
  {
    super(paramc);
  }
  
  public final l a(com.tencent.mm.pluginsdk.res.downloader.model.j paramj)
  {
    AppMethodBeat.i(151948);
    c localc = (c)cgY();
    String str1 = i.afg(localc.XUX);
    String str2 = localc.md5;
    if ((localc.WAT) && (Util.nullAsNil(y.bub(i.afg(localc.XUX))).equals(str2)))
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "file already cached and valid, send complete status");
      paramj = new l(localc, a.jK(str1));
      AppMethodBeat.o(151948);
      return paramj;
    }
    if ((!Util.isNullOrNil(((c)cgY()).XVE)) && (a.H(i.afg(((c)cgY()).XUX), ((c)cgY()).XVE)) && (Util.nullAsNil(y.bub(i.afg(((c)cgY()).XUX))).equals(((c)cgY()).md5)))
    {
      paramj = new l((k)cgY(), a.jK(i.afg(((c)cgY()).XUX)));
      AppMethodBeat.o(151948);
      return paramj;
    }
    paramj = super.a(paramj);
    Log.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: network get over, received response = ".concat(String.valueOf(paramj)), new Object[] { localc.XUX });
    if (paramj == null)
    {
      paramj = new l("CheckResUpdate", iJd(), cgR(), getFilePath(), 0L, "", 3, new e());
      AppMethodBeat.o(151948);
      return paramj;
    }
    if (paramj.status == 2)
    {
      if ((!Util.isNullOrNil(((c)cgY()).md5)) && (((c)cgY()).md5.equals(y.bub(getFilePath())))) {
        Log.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: file valid, md5 ok", new Object[] { localc.XUX });
      }
    }
    else
    {
      AppMethodBeat.o(151948);
      return paramj;
    }
    Log.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: file invalid, md5 not match", new Object[] { localc.XUX });
    paramj = new l("CheckResUpdate", iJd(), cgR(), getFilePath(), paramj.contentLength, paramj.contentType, 3, new com.tencent.mm.pluginsdk.res.downloader.a.c());
    AppMethodBeat.o(151948);
    return paramj;
  }
  
  public final String aVp()
  {
    return "CheckResUpdate";
  }
  
  public final boolean cgX()
  {
    AppMethodBeat.i(151947);
    if (super.cgX())
    {
      j.ac(((c)cgY()).Wmc, 12L);
      AppMethodBeat.o(151947);
      return true;
    }
    j.ac(((c)cgY()).Wmc, 27L);
    AppMethodBeat.o(151947);
    return false;
  }
  
  public final boolean jz(long paramLong)
  {
    AppMethodBeat.i(151946);
    if ((((c)cgY()).fileSize > 0L) && (((c)cgY()).fileSize != a.jK(getFilePath()) + paramLong))
    {
      AppMethodBeat.o(151946);
      return false;
    }
    boolean bool = super.jz(paramLong);
    AppMethodBeat.o(151946);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.res.downloader.checkresupdate.d
 * JD-Core Version:    0.7.0.1
 */