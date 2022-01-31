package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.g.a.c.l;
import com.tencent.mm.pluginsdk.g.a.c.q;
import com.tencent.mm.pluginsdk.g.a.c.q.a;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class f$a
{
  static void a(boolean paramBoolean1, boolean paramBoolean2, s params, g paramg)
  {
    AppMethodBeat.i(79513);
    ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "sendIORequest, fileAppend = %b, fileUpdate = %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if ((params.field_maxRetryTimes > 0) && (params.field_retryTimes <= 0) && (!paramBoolean2))
    {
      ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "record_maxRetryTimes = %d, record_retryTimes = %d, retry times out, skip", new Object[] { Integer.valueOf(params.field_maxRetryTimes), Integer.valueOf(params.field_retryTimes) });
      AppMethodBeat.o(79513);
      return;
    }
    params.field_reportId = paramg.vMR;
    params.field_status = 0;
    if (paramBoolean2)
    {
      params.field_maxRetryTimes = paramg.vMT;
      params.field_retryTimes = paramg.vMT;
      params.field_fileUpdated = true;
      params.field_priority = paramg.priority;
      if (paramg.fileSize > 0L) {
        params.field_fileSize = paramg.fileSize;
      }
      q.a.dmz().h(params);
    }
    while (q.a.dmz().alR(paramg.vMK))
    {
      ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "urlKey = %s is already downloading", new Object[] { paramg.vMK });
      if (paramg.coQ)
      {
        j.B(paramg.vMR, 9L);
        j.B(paramg.vMR, 44L);
      }
      AppMethodBeat.o(79513);
      return;
      params.field_retryTimes -= 1;
      params.field_priority = paramg.priority;
      q.a.dmz().h(params);
      j.B(params.field_reportId, 12L);
    }
    ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "urlKey = %s, post network task", new Object[] { paramg.vMK });
    if ((paramBoolean2) && (!paramBoolean1)) {
      b.c.dmg().f(params.field_resType, params.field_subType, 0, bo.nullAsNil(params.field_groupId2).equals("NewXml"));
    }
    params = c.d(params);
    params.uOQ = paramBoolean1;
    params.vNq = paramg.vNq;
    if (!paramBoolean1)
    {
      com.tencent.mm.pluginsdk.g.a.d.a.alT(i.alH(params.vMK));
      com.tencent.mm.pluginsdk.g.a.d.a.alT(i.alH(params.vMK) + ".decompressed");
      com.tencent.mm.pluginsdk.g.a.d.a.alT(i.alH(params.vMK) + ".decrypted");
    }
    q.a.dmz().d(params);
    AppMethodBeat.o(79513);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.f.a
 * JD-Core Version:    0.7.0.1
 */