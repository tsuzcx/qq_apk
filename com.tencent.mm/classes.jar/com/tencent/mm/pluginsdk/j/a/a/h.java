package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.j.a.c.q;
import com.tencent.mm.pluginsdk.j.a.c.q.a;
import com.tencent.mm.pluginsdk.j.a.c.s;
import com.tencent.mm.pluginsdk.j.a.c.t;
import com.tencent.mm.pluginsdk.j.a.d.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.util.Iterator;
import java.util.Set;

final class h
  implements com.tencent.mm.pluginsdk.j.a.c.h
{
  private static void a(s params, boolean paramBoolean)
  {
    AppMethodBeat.i(151965);
    q.a.fbc().Pd(params.field_urlKey);
    a.aMl(params.field_filePath);
    a.aMl(params.field_filePath + ".decompressed");
    a.aMl(params.field_filePath + ".decrypted");
    if ((2 == params.field_status) && (!paramBoolean))
    {
      ad.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "delete completed but invalid file, but forceDL = false, skip this downloading");
      AppMethodBeat.o(151965);
      return;
    }
    if ((params.field_maxRetryTimes > 0) && (params.field_retryTimes <= 0))
    {
      ad.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "record_maxRetryTimes = %d, record_retryTimes = %d, retry times out, skip ", new Object[] { Integer.valueOf(params.field_maxRetryTimes), Integer.valueOf(params.field_retryTimes) });
      AppMethodBeat.o(151965);
      return;
    }
    params.field_retryTimes -= 1;
    params.field_fileUpdated = true;
    q.a.fbc().h(params);
    j.A(params.field_reportId, 12L);
    ad.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "post network task");
    params = c.d(params);
    params.DKf = false;
    q.a.fbc().d(params);
    AppMethodBeat.o(151965);
  }
  
  private static boolean e(s params)
  {
    AppMethodBeat.i(151964);
    boolean bool = bt.nullAsNil(i.aPK(params.field_filePath)).equals(params.field_md5);
    AppMethodBeat.o(151964);
    return bool;
  }
  
  private static void f(s params)
  {
    AppMethodBeat.i(151966);
    if ((!params.field_fileCompress) && (!params.field_fileEncrypt))
    {
      b.faE().a(params.field_resType, params.field_subType, params.field_filePath, bt.getInt(params.field_fileVersion, 0), params.field_originalMd5);
      AppMethodBeat.o(151966);
      return;
    }
    ad.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "send query and decrypt request");
    b.faE().b(params);
    AppMethodBeat.o(151966);
  }
  
  public final void a(s params, int paramInt)
  {
    AppMethodBeat.i(151963);
    Object localObject1;
    Object localObject2;
    if ((params.field_expireTime != 0L) && (params.field_expireTime <= bt.aQJ()))
    {
      ad.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "urlKey(%s) exceed expire time(%d), delete", new Object[] { params.field_urlKey, Long.valueOf(params.field_expireTime) });
      localObject1 = q.a.fbc();
      localObject2 = params.field_urlKey;
      if (((q)localObject1).kld) {
        ((q)localObject1).EQW.CA((String)localObject2);
      }
      a.aMl(params.field_filePath);
      a.aMl(params.field_filePath + ".decompressed");
      a.aMl(params.field_filePath + ".decrypted");
      q.a.fbc().Pd(params.field_urlKey);
      AppMethodBeat.o(151963);
      return;
    }
    if (paramInt == 0)
    {
      ad.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "network unavailable, skip");
      AppMethodBeat.o(151963);
      return;
    }
    if ((2 == paramInt) && (1 == params.field_networkType))
    {
      ad.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "network type = gprs, record network type = wifi, skip this ");
      AppMethodBeat.o(151963);
      return;
    }
    if (params.field_deleted)
    {
      ad.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "record(%s), should have been deleted", new Object[] { params.field_urlKey });
      a.aMl(params.field_filePath);
      a.aMl(params.field_filePath + ".decompressed");
      a.aMl(params.field_filePath + ".decrypted");
      AppMethodBeat.o(151963);
      return;
    }
    if (!params.field_needRetry)
    {
      ad.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "no need retry, resType %d, subType %d, version %s", new Object[] { Integer.valueOf(params.field_resType), Integer.valueOf(params.field_subType), params.field_fileVersion });
      AppMethodBeat.o(151963);
      return;
    }
    if (params.field_status == 2)
    {
      long l = a.gy(params.field_filePath);
      if (params.field_contentLength > l)
      {
        ad.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "content-length > fileSize, resume download");
        if (0L == l)
        {
          if (!params.field_needRetry)
          {
            ad.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "no need retry, resType %d, subType %d, version %s", new Object[] { Integer.valueOf(params.field_resType), Integer.valueOf(params.field_subType), params.field_fileVersion });
            AppMethodBeat.o(151963);
            return;
          }
          if (1 != paramInt)
          {
            ad.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "fileSize = 0, completed file may be deleted by user, skip this because it's not wifi");
            AppMethodBeat.o(151963);
            return;
          }
          localObject1 = b.faE().faD().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (b.b)((Iterator)localObject1).next();
            bt.getInt(params.field_fileVersion, 0);
            if (((b.b)localObject2).faI())
            {
              ad.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "filterNotRetry by %s, resType %d, subType %d, version %s", new Object[] { localObject2.getClass().getName(), Integer.valueOf(params.field_resType), Integer.valueOf(params.field_subType), params.field_fileVersion });
              AppMethodBeat.o(151963);
              return;
            }
          }
          params.field_fileUpdated = true;
          b.faE().g(params.field_resType, params.field_subType, 0, bt.nullAsNil(params.field_groupId2).equals("NewXml"));
          q.a.fbc().h(params);
        }
        q.a.fbc().d(c.d(params));
        AppMethodBeat.o(151963);
        return;
      }
      if (!e(params))
      {
        ad.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "file invalid, re-download");
        if (1 == paramInt) {}
        for (boolean bool = true;; bool = false)
        {
          a(params, bool);
          AppMethodBeat.o(151963);
          return;
        }
      }
      ad.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "md5 check ok, file download complete, throw event to do decrypt");
      f(params);
      AppMethodBeat.o(151963);
      return;
    }
    if ((params.field_status == 1) || (params.field_status == 0))
    {
      ad.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "db status: downloading or waiting, db content-length %d", new Object[] { Long.valueOf(params.field_contentLength) });
      if (!q.a.fbc().aMj(params.field_urlKey))
      {
        ad.d("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "check md5");
        if (e(params))
        {
          ad.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "md5 match, request complete, throw event to do decrypt");
          params.field_status = 2;
          params.field_contentLength = a.gy(params.field_filePath);
          q.a.fbc().h(params);
          f(params);
          AppMethodBeat.o(151963);
          return;
        }
        if (0L == a.gy(params.field_filePath))
        {
          params.field_fileUpdated = true;
          q.a.fbc().h(params);
          b.faE().g(params.field_resType, params.field_subType, 0, bt.nullAsNil(params.field_groupId2).equals("NewXml"));
        }
        ad.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "md5 not match,  download");
        q.a.fbc().d(c.d(params));
        AppMethodBeat.o(151963);
        return;
      }
      ad.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "request already in downloading queue");
      AppMethodBeat.o(151963);
      return;
    }
    if ((params.field_status == 4) || (params.field_status == 3))
    {
      ad.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "file invalid, re-download");
      params.field_status = 0;
      a(params, true);
    }
    AppMethodBeat.o(151963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.a.h
 * JD-Core Version:    0.7.0.1
 */