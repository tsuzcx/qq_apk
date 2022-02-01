package com.tencent.mm.pluginsdk.res.downloader.checkresupdate;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.res.downloader.model.k;
import com.tencent.mm.pluginsdk.res.downloader.model.p;
import com.tencent.mm.pluginsdk.res.downloader.model.p.a;
import com.tencent.mm.pluginsdk.res.downloader.model.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class f$a
{
  static void a(boolean paramBoolean1, boolean paramBoolean2, r paramr, g paramg)
  {
    AppMethodBeat.i(151956);
    Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "sendIORequest, fileAppend = %b, fileUpdate = %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if ((paramr.field_maxRetryTimes > 0) && (paramr.field_retryTimes <= 0) && (!paramBoolean2))
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "record_maxRetryTimes = %d, record_retryTimes = %d, retry times out, skip", new Object[] { Integer.valueOf(paramr.field_maxRetryTimes), Integer.valueOf(paramr.field_retryTimes) });
      AppMethodBeat.o(151956);
      return;
    }
    paramr.field_reportId = paramg.Wmc;
    paramr.field_status = 0;
    if (paramBoolean2)
    {
      paramr.field_maxRetryTimes = paramg.XVf;
      paramr.field_retryTimes = paramg.XVf;
      paramr.field_fileUpdated = true;
      paramr.field_priority = paramg.priority;
      if (paramg.fileSize > 0L) {
        paramr.field_fileSize = paramg.fileSize;
      }
      paramr.field_filePath = i.afg(paramg.XUX);
      p.a.iJK().h(paramr);
    }
    while (p.a.iJK().bqs(paramg.XUX))
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "urlKey = %s is already downloading", new Object[] { paramg.XUX });
      if (paramg.hCn)
      {
        j.ac(paramg.Wmc, 9L);
        j.ac(paramg.Wmc, 44L);
      }
      AppMethodBeat.o(151956);
      return;
      paramr.field_retryTimes -= 1;
      paramr.field_priority = paramg.priority;
      p.a.iJK().h(paramr);
      j.ac(paramr.field_reportId, 12L);
    }
    Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "urlKey = %s, post network task", new Object[] { paramg.XUX });
    if ((paramBoolean2) && (!paramBoolean1)) {
      b.iJf().g(paramr.field_resType, paramr.field_subType, 0, Util.nullAsNil(paramr.field_groupId2).equals("NewXml"));
    }
    c localc = c.d(paramr);
    localc.WAT = paramBoolean1;
    localc.XVE = paramg.XVE;
    if (!paramBoolean1)
    {
      com.tencent.mm.pluginsdk.res.downloader.b.a.bqu(i.afg(localc.XUX));
      com.tencent.mm.pluginsdk.res.downloader.b.a.bqu(i.afg(localc.XUX) + ".decompressed");
      com.tencent.mm.pluginsdk.res.downloader.b.a.bqu(i.afg(localc.XUX) + ".decrypted");
    }
    j.r(paramr.field_resType, paramr.field_subType, Util.getInt(paramr.field_fileVersion, 0), (int)paramr.field_reportId, 76);
    p.a.iJK().d(localc);
    AppMethodBeat.o(151956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.res.downloader.checkresupdate.f.a
 * JD-Core Version:    0.7.0.1
 */