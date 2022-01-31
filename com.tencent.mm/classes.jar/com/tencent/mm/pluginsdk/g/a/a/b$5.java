package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.g.a.c.q;
import com.tencent.mm.pluginsdk.g.a.c.q.a;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class b$5
  implements Runnable
{
  b$5(b paramb, String paramString, g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(79473);
    s locals1 = q.a.dmz().alQ(this.vNc);
    g localg = this.vNe;
    if (locals1 == null) {
      ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record is null");
    }
    while ((locals1 != null) && (locals1.field_deleted) && (localg.alG(locals1.field_fileVersion) <= 0))
    {
      ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "deletedFile.version = %s, cacheReq.version = %s, this file should have been deleted, skip this cache-op", new Object[] { locals1.field_fileVersion, localg.vOd });
      AppMethodBeat.o(79473);
      return;
      ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record: urlKey = %s, url = %s, contentLength = %d, deleted = %b, eccSignature = %s, expireTime = %d, fileCompress = %b, fileEncrypt = %b, filePath = %s, fileUpdated = %b, fileVersion = %s, from = %s, keyVersion = %s, (encryptKey == null) = %b, maxRetryTimes = %d, retriedTimes = %d, sampleId = %s, dlStatus = %d", new Object[] { locals1.field_urlKey, locals1.field_url, Long.valueOf(locals1.field_contentLength), Boolean.valueOf(locals1.field_deleted), locals1.field_eccSignature, Long.valueOf(locals1.field_expireTime), Boolean.valueOf(locals1.field_fileCompress), Boolean.valueOf(locals1.field_fileEncrypt), locals1.field_filePath, Boolean.valueOf(locals1.field_fileUpdated), locals1.field_fileVersion, locals1.field_groupId2, Integer.valueOf(locals1.field_keyVersion), Boolean.valueOf(bo.isNullOrNil(locals1.field_encryptKey)), Integer.valueOf(locals1.field_maxRetryTimes), Integer.valueOf(locals1.field_retryTimes), locals1.field_sampleId, Integer.valueOf(locals1.field_status) });
      ab.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record.encryptKey = %s", new Object[] { locals1.field_encryptKey });
    }
    if (locals1 == null)
    {
      locals1 = localg.dmi();
      locals1.field_fileUpdated = true;
      locals1.field_needRetry = true;
      if (bo.isNullOrNil(locals1.field_encryptKey)) {
        locals1.field_keyVersion = -1;
      }
      ab.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "new record ".concat(String.valueOf(locals1)));
      q.a.dmz().h(locals1);
      b.c.dmg().f(localg.coJ, localg.subType, 0, localg.coQ);
      f.a.a(true, true, locals1, localg);
      AppMethodBeat.o(79473);
      return;
    }
    ab.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "record is not null");
    locals1.field_networkType = localg.networkType;
    if (bo.isNullOrNil(locals1.field_originalMd5)) {
      locals1.field_originalMd5 = localg.coM;
    }
    if (localg.alG(locals1.field_fileVersion) > 0)
    {
      ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "new version of file, re-download");
      s locals2 = localg.dmi();
      if (locals1.field_keyVersion >= localg.vMO)
      {
        locals2.field_keyVersion = locals1.field_keyVersion;
        locals2.field_encryptKey = locals1.field_encryptKey;
      }
      locals2.field_fileUpdated = true;
      locals2.field_needRetry = true;
      locals2.field_deleted = false;
      q.a.dmz().h(locals2);
      b.c.dmg().f(localg.coJ, localg.subType, 0, localg.coQ);
      q.a.dmz().BI(localg.vMK);
      f.a.a(false, true, locals2, localg);
      AppMethodBeat.o(79473);
      return;
    }
    if ((localg.alG(locals1.field_fileVersion) == 0) && (!locals1.field_needRetry))
    {
      ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "no need retry, resType %d, subType %d, version %s", new Object[] { Integer.valueOf(locals1.field_resType), Integer.valueOf(locals1.field_subType), locals1.field_fileVersion });
      AppMethodBeat.o(79473);
      return;
    }
    if ((locals1.field_status == 2) || (locals1.field_status == 1) || (locals1.field_status == 0))
    {
      long l = com.tencent.mm.pluginsdk.g.a.d.a.eG(locals1.field_filePath);
      if (locals1.field_contentLength > l)
      {
        ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "content-length(%d) > fileSize(%d), resume download", new Object[] { Long.valueOf(locals1.field_contentLength), Long.valueOf(l) });
        if (0L == l)
        {
          b.c.dmg().f(localg.coJ, localg.subType, 0, localg.coQ);
          f.a.a(false, true, locals1, localg);
          AppMethodBeat.o(79473);
          return;
        }
        f.a.a(true, false, locals1, localg);
        AppMethodBeat.o(79473);
        return;
      }
      if (!bo.nullAsNil(com.tencent.mm.a.g.getMD5(i.alH(localg.vMK))).equals(locals1.field_md5))
      {
        ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "file invalid, re-download");
        f.a.a(false, true, locals1, localg);
        AppMethodBeat.o(79473);
        return;
      }
      ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "md5 check ok, file download complete, throw event to do decrypt %s", new Object[] { locals1.field_urlKey });
      locals1.field_status = 2;
      locals1.field_contentLength = com.tencent.mm.pluginsdk.g.a.d.a.eG(locals1.field_filePath);
      locals1.field_fileUpdated = false;
      locals1.field_reportId = localg.vMR;
      q.a.dmz().h(locals1);
      j.B(locals1.field_reportId, 13L);
      j.B(locals1.field_reportId, 44L);
      j.a(locals1.field_resType, locals1.field_subType, locals1.field_url, bo.getInt(locals1.field_fileVersion, 0), j.a.vNM, true, "NewXml".equalsIgnoreCase(locals1.field_groupId2), true, locals1.field_sampleId);
      if ((!localg.vNr) && (!localg.vNs))
      {
        b.c.dmg().a(localg.coJ, localg.subType, i.alH(localg.vMK), bo.getInt(localg.vOd, 0), localg.coM);
        AppMethodBeat.o(79473);
        return;
      }
      ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "send query and decrypt request %s", new Object[] { localg.vMK });
      f.b.a(locals1, false, false);
      AppMethodBeat.o(79473);
      return;
    }
    if ((locals1.field_status == 4) || (locals1.field_status == 3))
    {
      ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "file invalid, re-download %s", new Object[] { locals1.field_urlKey });
      f.a.a(false, true, locals1, localg);
    }
    AppMethodBeat.o(79473);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.b.5
 * JD-Core Version:    0.7.0.1
 */