package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.pluginsdk.g.a.c.l;
import com.tencent.mm.pluginsdk.g.a.c.q;
import com.tencent.mm.pluginsdk.g.a.c.q.a;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class f$a
{
  static void a(s params, g paramg)
  {
    if (params == null)
    {
      y.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record is null");
      if ((params == null) || (!params.field_deleted) || (paramg.Wf(params.field_fileVersion) > 0)) {
        break label266;
      }
      y.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "deletedFile.version = %s, cacheReq.version = %s, this file should have been deleted, skip this cache-op", new Object[] { params.field_fileVersion, paramg.rXl });
    }
    label266:
    do
    {
      return;
      y.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record: urlKey = %s, url = %s, contentLength = %d, deleted = %b, eccSignature = %s, expireTime = %d, fileCompress = %b, fileEncrypt = %b, filePath = %s, fileUpdated = %b, fileVersion = %s, from = %s, keyVersion = %s, (encryptKey == null) = %b, maxRetryTimes = %d, retriedTimes = %d, sampleId = %s, dlStatus = %d", new Object[] { params.field_urlKey, params.field_url, Long.valueOf(params.field_contentLength), Boolean.valueOf(params.field_deleted), params.field_eccSignature, Long.valueOf(params.field_expireTime), Boolean.valueOf(params.field_fileCompress), Boolean.valueOf(params.field_fileEncrypt), params.field_filePath, Boolean.valueOf(params.field_fileUpdated), params.field_fileVersion, params.field_groupId2, Integer.valueOf(params.field_keyVersion), Boolean.valueOf(bk.bl(params.field_encryptKey)), Integer.valueOf(params.field_maxRetryTimes), Integer.valueOf(params.field_retryTimes), params.field_sampleId, Integer.valueOf(params.field_status) });
      y.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record.encryptKey = %s", new Object[] { params.field_encryptKey });
      break;
      if (params == null)
      {
        params = paramg.clx();
        params.field_fileUpdated = true;
        params.field_needRetry = true;
        if (bk.bl(params.field_encryptKey)) {
          params.field_keyVersion = -1;
        }
        y.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "new record " + params);
        q.a.clL().g(params);
        b.c.clv().e(paramg.bHv, paramg.brC, 0, paramg.bHB);
        a(true, true, params, paramg);
        return;
      }
      y.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "record is not null");
      params.field_networkType = paramg.networkType;
      if (bk.bl(params.field_originalMd5)) {
        params.field_originalMd5 = paramg.rVZ;
      }
      if (paramg.Wf(params.field_fileVersion) > 0)
      {
        y.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "new version of file, re-download");
        s locals = paramg.clx();
        if (params.field_keyVersion >= paramg.rVX)
        {
          locals.field_keyVersion = params.field_keyVersion;
          locals.field_encryptKey = params.field_encryptKey;
        }
        locals.field_fileUpdated = true;
        locals.field_needRetry = true;
        locals.field_deleted = false;
        q.a.clL().g(locals);
        b.c.clv().e(paramg.bHv, paramg.brC, 0, paramg.bHB);
        q.a.clL().Wn(paramg.rVT);
        a(false, true, locals, paramg);
        return;
      }
      if ((paramg.Wf(params.field_fileVersion) == 0) && (!params.field_needRetry))
      {
        y.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "no need retry, resType %d, subType %d, version %s", new Object[] { Integer.valueOf(params.field_resType), Integer.valueOf(params.field_subType), params.field_fileVersion });
        return;
      }
      if ((params.field_status == 2) || (params.field_status == 1) || (params.field_status == 0))
      {
        long l = com.tencent.mm.pluginsdk.g.a.d.a.Jr(params.field_filePath);
        if (params.field_contentLength > l)
        {
          y.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "content-length(%d) > fileSize(%d), resume download", new Object[] { Long.valueOf(params.field_contentLength), Long.valueOf(l) });
          if (0L == l)
          {
            b.c.clv().e(paramg.bHv, paramg.brC, 0, paramg.bHB);
            a(false, true, params, paramg);
            return;
          }
          a(true, false, params, paramg);
          return;
        }
        if (!bk.pm(com.tencent.mm.a.g.bQ(i.Wg(paramg.rVT))).equals(params.field_md5))
        {
          y.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "file invalid, re-download");
          a(false, true, params, paramg);
          return;
        }
        y.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "md5 check ok, file download complete, throw event to do decrypt %s", new Object[] { params.field_urlKey });
        params.field_status = 2;
        params.field_contentLength = com.tencent.mm.pluginsdk.g.a.d.a.Jr(params.field_filePath);
        params.field_fileUpdated = false;
        params.field_reportId = paramg.rWb;
        q.a.clL().g(params);
        j.s(params.field_reportId, 13L);
        j.s(params.field_reportId, 44L);
        j.a(params.field_resType, params.field_subType, params.field_url, bk.getInt(params.field_fileVersion, 0), j.a.rWU, true, "NewXml".equalsIgnoreCase(params.field_groupId2), true, params.field_sampleId);
        if ((!paramg.rWz) && (!paramg.rWA))
        {
          b.c.clv().e(paramg.bHv, paramg.brC, i.Wg(paramg.rVT), bk.getInt(paramg.rXl, 0));
          return;
        }
        y.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "send query and decrypt request %s", new Object[] { paramg.rVT });
        f.b.a(params, false, false);
        return;
      }
    } while ((params.field_status != 4) && (params.field_status != 3));
    y.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "file invalid, re-download %s", new Object[] { params.field_urlKey });
    a(false, true, params, paramg);
  }
  
  private static void a(boolean paramBoolean1, boolean paramBoolean2, s params, g paramg)
  {
    y.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "sendIORequest, fileAppend = %b, fileUpdate = %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if ((params.field_maxRetryTimes > 0) && (params.field_retryTimes <= 0) && (!paramBoolean2))
    {
      y.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "record_maxRetryTimes = %d, record_retryTimes = %d, retry times out, skip", new Object[] { Integer.valueOf(params.field_maxRetryTimes), Integer.valueOf(params.field_retryTimes) });
      return;
    }
    params.field_reportId = paramg.rWb;
    params.field_status = 0;
    if (paramBoolean2)
    {
      params.field_maxRetryTimes = paramg.rWd;
      params.field_retryTimes = paramg.rWd;
      params.field_fileUpdated = true;
      params.field_priority = paramg.priority;
      if (paramg.fileSize > 0L) {
        params.field_fileSize = paramg.fileSize;
      }
      q.a.clL().g(params);
    }
    for (;;)
    {
      if (!q.a.clL().Wm(paramg.rVT)) {
        break label245;
      }
      y.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "urlKey = %s is already downloading", new Object[] { paramg.rVT });
      if (!paramg.bHB) {
        break;
      }
      j.s(paramg.rWb, 9L);
      j.s(paramg.rWb, 44L);
      return;
      params.field_retryTimes -= 1;
      params.field_priority = paramg.priority;
      q.a.clL().g(params);
      j.s(params.field_reportId, 12L);
    }
    label245:
    y.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "urlKey = %s, post network task", new Object[] { paramg.rVT });
    if ((paramBoolean2) && (!paramBoolean1)) {
      b.c.clv().e(params.field_resType, params.field_subType, 0, bk.pm(params.field_groupId2).equals("NewXml"));
    }
    params = c.c(params);
    params.qZj = paramBoolean1;
    params.rWy = paramg.rWy;
    if (!paramBoolean1)
    {
      com.tencent.mm.pluginsdk.g.a.d.a.Wp(i.Wg(params.rVT));
      com.tencent.mm.pluginsdk.g.a.d.a.Wp(i.Wg(params.rVT) + ".decompressed");
      com.tencent.mm.pluginsdk.g.a.d.a.Wp(i.Wg(params.rVT) + ".decrypted");
    }
    q.a.clL().d(params);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.f.a
 * JD-Core Version:    0.7.0.1
 */