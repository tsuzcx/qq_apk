package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.j.a.c.l;
import com.tencent.mm.pluginsdk.j.a.c.q;
import com.tencent.mm.pluginsdk.j.a.c.q.a;
import com.tencent.mm.pluginsdk.j.a.c.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

final class f$a
{
  static void a(boolean paramBoolean1, boolean paramBoolean2, s params, g paramg)
  {
    AppMethodBeat.i(151956);
    ad.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "sendIORequest, fileAppend = %b, fileUpdate = %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if ((params.field_maxRetryTimes > 0) && (params.field_retryTimes <= 0) && (!paramBoolean2))
    {
      ad.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "record_maxRetryTimes = %d, record_retryTimes = %d, retry times out, skip", new Object[] { Integer.valueOf(params.field_maxRetryTimes), Integer.valueOf(params.field_retryTimes) });
      AppMethodBeat.o(151956);
      return;
    }
    params.field_reportId = paramg.DAq;
    params.field_status = 0;
    if (paramBoolean2)
    {
      params.field_maxRetryTimes = paramg.EPm;
      params.field_retryTimes = paramg.EPm;
      params.field_fileUpdated = true;
      params.field_priority = paramg.priority;
      if (paramg.fileSize > 0L) {
        params.field_fileSize = paramg.fileSize;
      }
      q.a.fbc().h(params);
    }
    while (q.a.fbc().aMj(paramg.EPe))
    {
      ad.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "urlKey = %s is already downloading", new Object[] { paramg.EPe });
      if (paramg.dmD)
      {
        j.A(paramg.DAq, 9L);
        j.A(paramg.DAq, 44L);
      }
      AppMethodBeat.o(151956);
      return;
      params.field_retryTimes -= 1;
      params.field_priority = paramg.priority;
      q.a.fbc().h(params);
      j.A(params.field_reportId, 12L);
    }
    ad.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "urlKey = %s, post network task", new Object[] { paramg.EPe });
    if ((paramBoolean2) && (!paramBoolean1)) {
      b.faE().g(params.field_resType, params.field_subType, 0, bt.nullAsNil(params.field_groupId2).equals("NewXml"));
    }
    params = c.d(params);
    params.DKf = paramBoolean1;
    params.EPJ = paramg.EPJ;
    if (!paramBoolean1)
    {
      com.tencent.mm.pluginsdk.j.a.d.a.aMl(i.TH(params.EPe));
      com.tencent.mm.pluginsdk.j.a.d.a.aMl(i.TH(params.EPe) + ".decompressed");
      com.tencent.mm.pluginsdk.j.a.d.a.aMl(i.TH(params.EPe) + ".decrypted");
    }
    q.a.fbc().d(params);
    AppMethodBeat.o(151956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.a.f.a
 * JD-Core Version:    0.7.0.1
 */