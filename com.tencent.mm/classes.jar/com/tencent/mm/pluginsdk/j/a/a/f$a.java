package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.j.a.c.l;
import com.tencent.mm.pluginsdk.j.a.c.q;
import com.tencent.mm.pluginsdk.j.a.c.q.a;
import com.tencent.mm.pluginsdk.j.a.c.s;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

final class f$a
{
  static void a(boolean paramBoolean1, boolean paramBoolean2, s params, g paramg)
  {
    AppMethodBeat.i(151956);
    ae.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "sendIORequest, fileAppend = %b, fileUpdate = %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if ((params.field_maxRetryTimes > 0) && (params.field_retryTimes <= 0) && (!paramBoolean2))
    {
      ae.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "record_maxRetryTimes = %d, record_retryTimes = %d, retry times out, skip", new Object[] { Integer.valueOf(params.field_maxRetryTimes), Integer.valueOf(params.field_retryTimes) });
      AppMethodBeat.o(151956);
      return;
    }
    params.field_reportId = paramg.DRK;
    params.field_status = 0;
    if (paramBoolean2)
    {
      params.field_maxRetryTimes = paramg.FhH;
      params.field_retryTimes = paramg.FhH;
      params.field_fileUpdated = true;
      params.field_priority = paramg.priority;
      if (paramg.fileSize > 0L) {
        params.field_fileSize = paramg.fileSize;
      }
      q.a.feQ().h(params);
    }
    while (q.a.feQ().aNF(paramg.Fhz))
    {
      ae.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "urlKey = %s is already downloading", new Object[] { paramg.Fhz });
      if (paramg.dnF)
      {
        j.A(paramg.DRK, 9L);
        j.A(paramg.DRK, 44L);
      }
      AppMethodBeat.o(151956);
      return;
      params.field_retryTimes -= 1;
      params.field_priority = paramg.priority;
      q.a.feQ().h(params);
      j.A(params.field_reportId, 12L);
    }
    ae.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "urlKey = %s, post network task", new Object[] { paramg.Fhz });
    if ((paramBoolean2) && (!paramBoolean1)) {
      b.fes().g(params.field_resType, params.field_subType, 0, bu.nullAsNil(params.field_groupId2).equals("NewXml"));
    }
    params = c.d(params);
    params.Ecd = paramBoolean1;
    params.Fie = paramg.Fie;
    if (!paramBoolean1)
    {
      com.tencent.mm.pluginsdk.j.a.d.a.aNH(i.Uq(params.Fhz));
      com.tencent.mm.pluginsdk.j.a.d.a.aNH(i.Uq(params.Fhz) + ".decompressed");
      com.tencent.mm.pluginsdk.j.a.d.a.aNH(i.Uq(params.Fhz) + ".decrypted");
    }
    q.a.feQ().d(params);
    AppMethodBeat.o(151956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.a.f.a
 * JD-Core Version:    0.7.0.1
 */