package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.j.a.c.q;
import com.tencent.mm.pluginsdk.j.a.c.q.a;
import com.tencent.mm.pluginsdk.j.a.c.s;
import com.tencent.mm.pluginsdk.j.a.c.t;
import com.tencent.mm.pluginsdk.j.a.d.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import java.util.Iterator;
import java.util.Set;

final class h
  implements com.tencent.mm.pluginsdk.j.a.c.h
{
  private static void a(s params, boolean paramBoolean)
  {
    AppMethodBeat.i(151965);
    q.a.feQ().PL(params.field_urlKey);
    a.aNH(params.field_filePath);
    a.aNH(params.field_filePath + ".decompressed");
    a.aNH(params.field_filePath + ".decrypted");
    if ((2 == params.field_status) && (!paramBoolean))
    {
      ae.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "delete completed but invalid file, but forceDL = false, skip this downloading");
      AppMethodBeat.o(151965);
      return;
    }
    if ((params.field_maxRetryTimes > 0) && (params.field_retryTimes <= 0))
    {
      ae.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "record_maxRetryTimes = %d, record_retryTimes = %d, retry times out, skip ", new Object[] { Integer.valueOf(params.field_maxRetryTimes), Integer.valueOf(params.field_retryTimes) });
      AppMethodBeat.o(151965);
      return;
    }
    params.field_retryTimes -= 1;
    params.field_fileUpdated = true;
    q.a.feQ().h(params);
    j.A(params.field_reportId, 12L);
    ae.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "post network task");
    params = c.d(params);
    params.Ecd = false;
    q.a.feQ().d(params);
    AppMethodBeat.o(151965);
  }
  
  private static boolean e(s params)
  {
    AppMethodBeat.i(151964);
    boolean bool = bu.nullAsNil(o.aRh(params.field_filePath)).equals(params.field_md5);
    AppMethodBeat.o(151964);
    return bool;
  }
  
  private static void f(s params)
  {
    AppMethodBeat.i(151966);
    if ((!params.field_fileCompress) && (!params.field_fileEncrypt))
    {
      b.fes().a(params.field_resType, params.field_subType, params.field_filePath, bu.getInt(params.field_fileVersion, 0), params.field_originalMd5);
      AppMethodBeat.o(151966);
      return;
    }
    ae.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "send query and decrypt request");
    b.fes().b(params);
    AppMethodBeat.o(151966);
  }
  
  public final void a(s params, int paramInt)
  {
    AppMethodBeat.i(151963);
    Object localObject1;
    Object localObject2;
    if ((params.field_expireTime != 0L) && (params.field_expireTime <= bu.aRi()))
    {
      ae.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "urlKey(%s) exceed expire time(%d), delete", new Object[] { params.field_urlKey, Long.valueOf(params.field_expireTime) });
      localObject1 = q.a.feQ();
      localObject2 = params.field_urlKey;
      if (((q)localObject1).kot) {
        ((q)localObject1).Fjr.Dc((String)localObject2);
      }
      a.aNH(params.field_filePath);
      a.aNH(params.field_filePath + ".decompressed");
      a.aNH(params.field_filePath + ".decrypted");
      q.a.feQ().PL(params.field_urlKey);
      AppMethodBeat.o(151963);
      return;
    }
    if (paramInt == 0)
    {
      ae.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "network unavailable, skip");
      AppMethodBeat.o(151963);
      return;
    }
    if ((2 == paramInt) && (1 == params.field_networkType))
    {
      ae.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "network type = gprs, record network type = wifi, skip this ");
      AppMethodBeat.o(151963);
      return;
    }
    if (params.field_deleted)
    {
      ae.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "record(%s), should have been deleted", new Object[] { params.field_urlKey });
      a.aNH(params.field_filePath);
      a.aNH(params.field_filePath + ".decompressed");
      a.aNH(params.field_filePath + ".decrypted");
      AppMethodBeat.o(151963);
      return;
    }
    if (!params.field_needRetry)
    {
      ae.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "no need retry, resType %d, subType %d, version %s", new Object[] { Integer.valueOf(params.field_resType), Integer.valueOf(params.field_subType), params.field_fileVersion });
      AppMethodBeat.o(151963);
      return;
    }
    if (params.field_status == 2)
    {
      long l = a.gE(params.field_filePath);
      if (params.field_contentLength > l)
      {
        ae.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "content-length > fileSize, resume download");
        if (0L == l)
        {
          if (!params.field_needRetry)
          {
            ae.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "no need retry, resType %d, subType %d, version %s", new Object[] { Integer.valueOf(params.field_resType), Integer.valueOf(params.field_subType), params.field_fileVersion });
            AppMethodBeat.o(151963);
            return;
          }
          if (1 != paramInt)
          {
            ae.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "fileSize = 0, completed file may be deleted by user, skip this because it's not wifi");
            AppMethodBeat.o(151963);
            return;
          }
          localObject1 = b.fes().fer().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (b.b)((Iterator)localObject1).next();
            bu.getInt(params.field_fileVersion, 0);
            if (((b.b)localObject2).few())
            {
              ae.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "filterNotRetry by %s, resType %d, subType %d, version %s", new Object[] { localObject2.getClass().getName(), Integer.valueOf(params.field_resType), Integer.valueOf(params.field_subType), params.field_fileVersion });
              AppMethodBeat.o(151963);
              return;
            }
          }
          params.field_fileUpdated = true;
          b.fes().g(params.field_resType, params.field_subType, 0, bu.nullAsNil(params.field_groupId2).equals("NewXml"));
          q.a.feQ().h(params);
        }
        q.a.feQ().d(c.d(params));
        AppMethodBeat.o(151963);
        return;
      }
      if (!e(params))
      {
        ae.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "file invalid, re-download");
        if (1 == paramInt) {}
        for (boolean bool = true;; bool = false)
        {
          a(params, bool);
          AppMethodBeat.o(151963);
          return;
        }
      }
      ae.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "md5 check ok, file download complete, throw event to do decrypt");
      f(params);
      AppMethodBeat.o(151963);
      return;
    }
    if ((params.field_status == 1) || (params.field_status == 0))
    {
      ae.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "db status: downloading or waiting, db content-length %d", new Object[] { Long.valueOf(params.field_contentLength) });
      if (!q.a.feQ().aNF(params.field_urlKey))
      {
        ae.d("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "check md5");
        if (e(params))
        {
          ae.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "md5 match, request complete, throw event to do decrypt");
          params.field_status = 2;
          params.field_contentLength = a.gE(params.field_filePath);
          q.a.feQ().h(params);
          f(params);
          AppMethodBeat.o(151963);
          return;
        }
        if (0L == a.gE(params.field_filePath))
        {
          params.field_fileUpdated = true;
          q.a.feQ().h(params);
          b.fes().g(params.field_resType, params.field_subType, 0, bu.nullAsNil(params.field_groupId2).equals("NewXml"));
        }
        ae.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "md5 not match,  download");
        q.a.feQ().d(c.d(params));
        AppMethodBeat.o(151963);
        return;
      }
      ae.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "request already in downloading queue");
      AppMethodBeat.o(151963);
      return;
    }
    if ((params.field_status == 4) || (params.field_status == 3))
    {
      ae.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "file invalid, re-download");
      params.field_status = 0;
      a(params, true);
    }
    AppMethodBeat.o(151963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.a.h
 * JD-Core Version:    0.7.0.1
 */