package com.tencent.mm.pluginsdk.res.downloader.checkresupdate;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.res.downloader.b.a;
import com.tencent.mm.pluginsdk.res.downloader.model.p;
import com.tencent.mm.pluginsdk.res.downloader.model.p.a;
import com.tencent.mm.pluginsdk.res.downloader.model.r;
import com.tencent.mm.pluginsdk.res.downloader.model.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import java.util.Set;

final class h
  implements com.tencent.mm.pluginsdk.res.downloader.model.h
{
  private static void a(r paramr, boolean paramBoolean)
  {
    AppMethodBeat.i(151965);
    p.a.iJK().ZJ(paramr.field_urlKey);
    a.bqu(paramr.field_filePath);
    a.bqu(paramr.field_filePath + ".decompressed");
    a.bqu(paramr.field_filePath + ".decrypted");
    if ((2 == paramr.field_status) && (!paramBoolean))
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "delete completed but invalid file, but forceDL = false, skip this downloading");
      AppMethodBeat.o(151965);
      return;
    }
    if ((paramr.field_maxRetryTimes > 0) && (paramr.field_retryTimes <= 0))
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "record_maxRetryTimes = %d, record_retryTimes = %d, retry times out, skip ", new Object[] { Integer.valueOf(paramr.field_maxRetryTimes), Integer.valueOf(paramr.field_retryTimes) });
      AppMethodBeat.o(151965);
      return;
    }
    paramr.field_retryTimes -= 1;
    paramr.field_fileUpdated = true;
    p.a.iJK().h(paramr);
    j.ac(paramr.field_reportId, 12L);
    Log.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "post network task");
    c localc = c.d(paramr);
    localc.WAT = false;
    j.r(paramr.field_resType, paramr.field_subType, Util.getInt(paramr.field_fileVersion, 0), (int)paramr.field_reportId, 76);
    p.a.iJK().d(localc);
    AppMethodBeat.o(151965);
  }
  
  private static boolean e(r paramr)
  {
    AppMethodBeat.i(151964);
    boolean bool = Util.nullAsNil(y.bub(paramr.field_filePath)).equals(paramr.field_md5);
    AppMethodBeat.o(151964);
    return bool;
  }
  
  private static void f(r paramr)
  {
    AppMethodBeat.i(151966);
    if ((!paramr.field_fileCompress) && (!paramr.field_fileEncrypt))
    {
      b.iJf().c(paramr.field_resType, paramr.field_subType, paramr.field_filePath, Util.getInt(paramr.field_fileVersion, 0), paramr.field_originalMd5);
      AppMethodBeat.o(151966);
      return;
    }
    Log.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "send query and decrypt request");
    b.iJf().b(paramr);
    AppMethodBeat.o(151966);
  }
  
  public final void a(r paramr, int paramInt)
  {
    AppMethodBeat.i(151963);
    Object localObject1;
    Object localObject2;
    if ((paramr.field_expireTime != 0L) && (paramr.field_expireTime <= Util.nowSecond()))
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "urlKey(%s) exceed expire time(%d), delete", new Object[] { paramr.field_urlKey, Long.valueOf(paramr.field_expireTime) });
      localObject1 = p.a.iJK();
      localObject2 = paramr.field_urlKey;
      if (((p)localObject1).rqI) {
        ((p)localObject1).XWT.iP((String)localObject2);
      }
      a.bqu(paramr.field_filePath);
      a.bqu(paramr.field_filePath + ".decompressed");
      a.bqu(paramr.field_filePath + ".decrypted");
      p.a.iJK().ZJ(paramr.field_urlKey);
      AppMethodBeat.o(151963);
      return;
    }
    if (paramInt == 0)
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "network unavailable, skip");
      AppMethodBeat.o(151963);
      return;
    }
    if ((2 == paramInt) && (1 == paramr.field_networkType))
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "network type = gprs, record network type = wifi, skip this ");
      AppMethodBeat.o(151963);
      return;
    }
    if (paramr.field_deleted)
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "record(%s), should have been deleted", new Object[] { paramr.field_urlKey });
      a.bqu(paramr.field_filePath);
      a.bqu(paramr.field_filePath + ".decompressed");
      a.bqu(paramr.field_filePath + ".decrypted");
      AppMethodBeat.o(151963);
      return;
    }
    if (!paramr.field_needRetry)
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "no need retry, resType %d, subType %d, version %s", new Object[] { Integer.valueOf(paramr.field_resType), Integer.valueOf(paramr.field_subType), paramr.field_fileVersion });
      AppMethodBeat.o(151963);
      return;
    }
    if (paramr.field_status == 2)
    {
      long l = a.jK(paramr.field_filePath);
      if (paramr.field_contentLength > l)
      {
        Log.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "content-length > fileSize, resume download");
        if (0L == l)
        {
          if (!paramr.field_needRetry)
          {
            Log.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "no need retry, resType %d, subType %d, version %s", new Object[] { Integer.valueOf(paramr.field_resType), Integer.valueOf(paramr.field_subType), paramr.field_fileVersion });
            AppMethodBeat.o(151963);
            return;
          }
          if (1 != paramInt)
          {
            Log.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "fileSize = 0, completed file may be deleted by user, skip this because it's not wifi");
            AppMethodBeat.o(151963);
            return;
          }
          localObject1 = b.iJf().iJe().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (b.b)((Iterator)localObject1).next();
            Util.getInt(paramr.field_fileVersion, 0);
            if (((b.b)localObject2).iJk())
            {
              Log.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "filterNotRetry by %s, resType %d, subType %d, version %s", new Object[] { localObject2.getClass().getName(), Integer.valueOf(paramr.field_resType), Integer.valueOf(paramr.field_subType), paramr.field_fileVersion });
              AppMethodBeat.o(151963);
              return;
            }
          }
          paramr.field_fileUpdated = true;
          b.iJf().g(paramr.field_resType, paramr.field_subType, 0, Util.nullAsNil(paramr.field_groupId2).equals("NewXml"));
          p.a.iJK().h(paramr);
        }
        j.r(paramr.field_resType, paramr.field_subType, Util.getInt(paramr.field_fileVersion, 0), (int)paramr.field_reportId, 76);
        p.a.iJK().d(c.d(paramr));
        AppMethodBeat.o(151963);
        return;
      }
      if (!e(paramr))
      {
        Log.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "file invalid, re-download");
        if (1 == paramInt) {}
        for (boolean bool = true;; bool = false)
        {
          a(paramr, bool);
          AppMethodBeat.o(151963);
          return;
        }
      }
      Log.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "md5 check ok, file download complete, throw event to do decrypt");
      f(paramr);
      AppMethodBeat.o(151963);
      return;
    }
    if ((paramr.field_status == 1) || (paramr.field_status == 0))
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "db status: downloading or waiting, db content-length %d", new Object[] { Long.valueOf(paramr.field_contentLength) });
      if (!p.a.iJK().bqs(paramr.field_urlKey))
      {
        Log.d("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "check md5");
        if (e(paramr))
        {
          Log.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "md5 match, request complete, throw event to do decrypt");
          paramr.field_status = 2;
          paramr.field_contentLength = a.jK(paramr.field_filePath);
          p.a.iJK().h(paramr);
          f(paramr);
          AppMethodBeat.o(151963);
          return;
        }
        if (0L == a.jK(paramr.field_filePath))
        {
          paramr.field_fileUpdated = true;
          p.a.iJK().h(paramr);
          b.iJf().g(paramr.field_resType, paramr.field_subType, 0, Util.nullAsNil(paramr.field_groupId2).equals("NewXml"));
        }
        Log.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "md5 not match,  download");
        j.r(paramr.field_resType, paramr.field_subType, Util.getInt(paramr.field_fileVersion, 0), (int)paramr.field_reportId, 76);
        p.a.iJK().d(c.d(paramr));
        AppMethodBeat.o(151963);
        return;
      }
      Log.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "request already in downloading queue");
      AppMethodBeat.o(151963);
      return;
    }
    if ((paramr.field_status == 4) || (paramr.field_status == 3))
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "file invalid, re-download");
      paramr.field_status = 0;
      a(paramr, true);
    }
    AppMethodBeat.o(151963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.res.downloader.checkresupdate.h
 * JD-Core Version:    0.7.0.1
 */