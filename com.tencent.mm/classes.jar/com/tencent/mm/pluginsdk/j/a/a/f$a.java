package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.j.a.c.l;
import com.tencent.mm.pluginsdk.j.a.c.q;
import com.tencent.mm.pluginsdk.j.a.c.q.a;
import com.tencent.mm.pluginsdk.j.a.c.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class f$a
{
  static void a(boolean paramBoolean1, boolean paramBoolean2, s params, g paramg)
  {
    AppMethodBeat.i(151956);
    Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "sendIORequest, fileAppend = %b, fileUpdate = %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if ((params.field_maxRetryTimes > 0) && (params.field_retryTimes <= 0) && (!paramBoolean2))
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "record_maxRetryTimes = %d, record_retryTimes = %d, retry times out, skip", new Object[] { Integer.valueOf(params.field_maxRetryTimes), Integer.valueOf(params.field_retryTimes) });
      AppMethodBeat.o(151956);
      return;
    }
    params.field_reportId = paramg.IBJ;
    params.field_status = 0;
    if (paramBoolean2)
    {
      params.field_maxRetryTimes = paramg.JYA;
      params.field_retryTimes = paramg.JYA;
      params.field_fileUpdated = true;
      params.field_priority = paramg.priority;
      if (paramg.fileSize > 0L) {
        params.field_fileSize = paramg.fileSize;
      }
      q.a.goa().h(params);
    }
    while (q.a.goa().beh(paramg.JYs))
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "urlKey = %s is already downloading", new Object[] { paramg.JYs });
      if (paramg.dEU)
      {
        j.F(paramg.IBJ, 9L);
        j.F(paramg.IBJ, 44L);
      }
      AppMethodBeat.o(151956);
      return;
      params.field_retryTimes -= 1;
      params.field_priority = paramg.priority;
      q.a.goa().h(params);
      j.F(params.field_reportId, 12L);
    }
    Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "urlKey = %s, post network task", new Object[] { paramg.JYs });
    if ((paramBoolean2) && (!paramBoolean1)) {
      b.gnC().h(params.field_resType, params.field_subType, 0, Util.nullAsNil(params.field_groupId2).equals("NewXml"));
    }
    c localc = c.d(params);
    localc.IOp = paramBoolean1;
    localc.JYY = paramg.JYY;
    if (!paramBoolean1)
    {
      com.tencent.mm.pluginsdk.j.a.d.a.bej(i.aee(localc.JYs));
      com.tencent.mm.pluginsdk.j.a.d.a.bej(i.aee(localc.JYs) + ".decompressed");
      com.tencent.mm.pluginsdk.j.a.d.a.bej(i.aee(localc.JYs) + ".decrypted");
    }
    j.m(params.field_resType, params.field_subType, Util.getInt(params.field_fileVersion, 0), (int)params.field_reportId, 76);
    q.a.goa().d(localc);
    AppMethodBeat.o(151956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.a.f.a
 * JD-Core Version:    0.7.0.1
 */