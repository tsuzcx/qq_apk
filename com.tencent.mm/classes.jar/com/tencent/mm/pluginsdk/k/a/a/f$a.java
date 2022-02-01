package com.tencent.mm.pluginsdk.k.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.k.a.c.k;
import com.tencent.mm.pluginsdk.k.a.c.p;
import com.tencent.mm.pluginsdk.k.a.c.p.a;
import com.tencent.mm.pluginsdk.k.a.c.r;
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
    paramr.field_reportId = paramg.PvW;
    paramr.field_status = 0;
    if (paramBoolean2)
    {
      paramr.field_maxRetryTimes = paramg.QZc;
      paramr.field_retryTimes = paramg.QZc;
      paramr.field_fileUpdated = true;
      paramr.field_priority = paramg.priority;
      if (paramg.fileSize > 0L) {
        paramr.field_fileSize = paramg.fileSize;
      }
      paramr.field_filePath = i.alY(paramg.QYU);
      p.a.hiK().h(paramr);
    }
    while (p.a.hiK().bqD(paramg.QYU))
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "urlKey = %s is already downloading", new Object[] { paramg.QYU });
      if (paramg.fxI)
      {
        j.F(paramg.PvW, 9L);
        j.F(paramg.PvW, 44L);
      }
      AppMethodBeat.o(151956);
      return;
      paramr.field_retryTimes -= 1;
      paramr.field_priority = paramg.priority;
      p.a.hiK().h(paramr);
      j.F(paramr.field_reportId, 12L);
    }
    Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "urlKey = %s, post network task", new Object[] { paramg.QYU });
    if ((paramBoolean2) && (!paramBoolean1)) {
      b.hii().h(paramr.field_resType, paramr.field_subType, 0, Util.nullAsNil(paramr.field_groupId2).equals("NewXml"));
    }
    c localc = c.d(paramr);
    localc.PKG = paramBoolean1;
    localc.QZA = paramg.QZA;
    if (!paramBoolean1)
    {
      com.tencent.mm.pluginsdk.k.a.d.a.bqF(i.alY(localc.QYU));
      com.tencent.mm.pluginsdk.k.a.d.a.bqF(i.alY(localc.QYU) + ".decompressed");
      com.tencent.mm.pluginsdk.k.a.d.a.bqF(i.alY(localc.QYU) + ".decrypted");
    }
    j.p(paramr.field_resType, paramr.field_subType, Util.getInt(paramr.field_fileVersion, 0), (int)paramr.field_reportId, 76);
    p.a.hiK().d(localc);
    AppMethodBeat.o(151956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.k.a.a.f.a
 * JD-Core Version:    0.7.0.1
 */