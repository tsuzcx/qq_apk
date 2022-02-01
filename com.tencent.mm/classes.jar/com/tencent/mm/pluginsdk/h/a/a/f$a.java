package com.tencent.mm.pluginsdk.h.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.h.a.c.l;
import com.tencent.mm.pluginsdk.h.a.c.q;
import com.tencent.mm.pluginsdk.h.a.c.q.a;
import com.tencent.mm.pluginsdk.h.a.c.s;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

final class f$a
{
  static void a(boolean paramBoolean1, boolean paramBoolean2, s params, g paramg)
  {
    AppMethodBeat.i(151956);
    ac.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "sendIORequest, fileAppend = %b, fileUpdate = %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if ((params.field_maxRetryTimes > 0) && (params.field_retryTimes <= 0) && (!paramBoolean2))
    {
      ac.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "record_maxRetryTimes = %d, record_retryTimes = %d, retry times out, skip", new Object[] { Integer.valueOf(params.field_maxRetryTimes), Integer.valueOf(params.field_retryTimes) });
      AppMethodBeat.o(151956);
      return;
    }
    params.field_reportId = paramg.Dki;
    params.field_status = 0;
    if (paramBoolean2)
    {
      params.field_maxRetryTimes = paramg.Dkk;
      params.field_retryTimes = paramg.Dkk;
      params.field_fileUpdated = true;
      params.field_priority = paramg.priority;
      if (paramg.fileSize > 0L) {
        params.field_fileSize = paramg.fileSize;
      }
      q.a.eMf().h(params);
    }
    while (q.a.eMf().aGJ(paramg.Dkb))
    {
      ac.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "urlKey = %s is already downloading", new Object[] { paramg.Dkb });
      if (paramg.dbj)
      {
        j.A(paramg.Dki, 9L);
        j.A(paramg.Dki, 44L);
      }
      AppMethodBeat.o(151956);
      return;
      params.field_retryTimes -= 1;
      params.field_priority = paramg.priority;
      q.a.eMf().h(params);
      j.A(params.field_reportId, 12L);
    }
    ac.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "urlKey = %s, post network task", new Object[] { paramg.Dkb });
    if ((paramBoolean2) && (!paramBoolean1)) {
      b.eLH().g(params.field_resType, params.field_subType, 0, bs.nullAsNil(params.field_groupId2).equals("NewXml"));
    }
    params = c.d(params);
    params.CgY = paramBoolean1;
    params.DkH = paramg.DkH;
    if (!paramBoolean1)
    {
      com.tencent.mm.pluginsdk.h.a.d.a.aGL(i.Qc(params.Dkb));
      com.tencent.mm.pluginsdk.h.a.d.a.aGL(i.Qc(params.Dkb) + ".decompressed");
      com.tencent.mm.pluginsdk.h.a.d.a.aGL(i.Qc(params.Dkb) + ".decrypted");
    }
    q.a.eMf().d(params);
    AppMethodBeat.o(151956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.a.f.a
 * JD-Core Version:    0.7.0.1
 */