package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.pluginsdk.g.a.c.q;
import com.tencent.mm.pluginsdk.g.a.c.q.a;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.pluginsdk.g.a.c.t;
import com.tencent.mm.pluginsdk.g.a.d.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.Set;

final class h
  implements com.tencent.mm.pluginsdk.g.a.c.h
{
  private static void a(s params, boolean paramBoolean)
  {
    AppMethodBeat.i(79522);
    q.a.dmz().BI(params.field_urlKey);
    a.alT(params.field_filePath);
    a.alT(params.field_filePath + ".decompressed");
    a.alT(params.field_filePath + ".decrypted");
    if ((2 == params.field_status) && (!paramBoolean))
    {
      ab.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "delete completed but invalid file, but forceDL = false, skip this downloading");
      AppMethodBeat.o(79522);
      return;
    }
    if ((params.field_maxRetryTimes > 0) && (params.field_retryTimes <= 0))
    {
      ab.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "record_maxRetryTimes = %d, record_retryTimes = %d, retry times out, skip ", new Object[] { Integer.valueOf(params.field_maxRetryTimes), Integer.valueOf(params.field_retryTimes) });
      AppMethodBeat.o(79522);
      return;
    }
    params.field_retryTimes -= 1;
    params.field_fileUpdated = true;
    q.a.dmz().h(params);
    j.B(params.field_reportId, 12L);
    ab.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "post network task");
    params = c.d(params);
    params.uOQ = false;
    q.a.dmz().d(params);
    AppMethodBeat.o(79522);
  }
  
  private static boolean e(s params)
  {
    AppMethodBeat.i(79521);
    boolean bool = bo.nullAsNil(g.getMD5(params.field_filePath)).equals(params.field_md5);
    AppMethodBeat.o(79521);
    return bool;
  }
  
  private static void f(s params)
  {
    AppMethodBeat.i(79523);
    if ((!params.field_fileCompress) && (!params.field_fileEncrypt))
    {
      b.c.dmg().a(params.field_resType, params.field_subType, params.field_filePath, bo.getInt(params.field_fileVersion, 0), params.field_originalMd5);
      AppMethodBeat.o(79523);
      return;
    }
    ab.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "send query and decrypt request");
    b.c.dmg().b(params);
    AppMethodBeat.o(79523);
  }
  
  public final void a(s params, int paramInt)
  {
    AppMethodBeat.i(79520);
    Object localObject1;
    Object localObject2;
    if ((params.field_expireTime != 0L) && (params.field_expireTime <= bo.aox()))
    {
      ab.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "urlKey(%s) exceed expire time(%d), delete", new Object[] { params.field_urlKey, Long.valueOf(params.field_expireTime) });
      localObject1 = q.a.dmz();
      localObject2 = params.field_urlKey;
      if (((q)localObject1).hsO) {
        ((q)localObject1).vOE.qD((String)localObject2);
      }
      a.alT(params.field_filePath);
      a.alT(params.field_filePath + ".decompressed");
      a.alT(params.field_filePath + ".decrypted");
      q.a.dmz().BI(params.field_urlKey);
      AppMethodBeat.o(79520);
      return;
    }
    if (paramInt == 0)
    {
      ab.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "network unavailable, skip");
      AppMethodBeat.o(79520);
      return;
    }
    if ((2 == paramInt) && (1 == params.field_networkType))
    {
      ab.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "network type = gprs, record network type = wifi, skip this ");
      AppMethodBeat.o(79520);
      return;
    }
    if (params.field_deleted)
    {
      ab.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "record(%s), should have been deleted", new Object[] { params.field_urlKey });
      a.alT(params.field_filePath);
      a.alT(params.field_filePath + ".decompressed");
      a.alT(params.field_filePath + ".decrypted");
      AppMethodBeat.o(79520);
      return;
    }
    if (!params.field_needRetry)
    {
      ab.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "no need retry, resType %d, subType %d, version %s", new Object[] { Integer.valueOf(params.field_resType), Integer.valueOf(params.field_subType), params.field_fileVersion });
      AppMethodBeat.o(79520);
      return;
    }
    if (params.field_status == 2)
    {
      long l = a.eG(params.field_filePath);
      if (params.field_contentLength > l)
      {
        ab.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "content-length > fileSize, resume download");
        if (0L == l)
        {
          if (!params.field_needRetry)
          {
            ab.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "no need retry, resType %d, subType %d, version %s", new Object[] { Integer.valueOf(params.field_resType), Integer.valueOf(params.field_subType), params.field_fileVersion });
            AppMethodBeat.o(79520);
            return;
          }
          if (1 != paramInt)
          {
            ab.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "fileSize = 0, completed file may be deleted by user, skip this because it's not wifi");
            AppMethodBeat.o(79520);
            return;
          }
          localObject1 = b.c.dmg().dma().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (b.b)((Iterator)localObject1).next();
            bo.getInt(params.field_fileVersion, 0);
            if (((b.b)localObject2).dmf())
            {
              ab.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "filterNotRetry by %s, resType %d, subType %d, version %s", new Object[] { localObject2.getClass().getName(), Integer.valueOf(params.field_resType), Integer.valueOf(params.field_subType), params.field_fileVersion });
              AppMethodBeat.o(79520);
              return;
            }
          }
          params.field_fileUpdated = true;
          b.c.dmg().f(params.field_resType, params.field_subType, 0, bo.nullAsNil(params.field_groupId2).equals("NewXml"));
          q.a.dmz().h(params);
        }
        q.a.dmz().d(c.d(params));
        AppMethodBeat.o(79520);
        return;
      }
      if (!e(params))
      {
        ab.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "file invalid, re-download");
        if (1 == paramInt) {}
        for (boolean bool = true;; bool = false)
        {
          a(params, bool);
          AppMethodBeat.o(79520);
          return;
        }
      }
      ab.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "md5 check ok, file download complete, throw event to do decrypt");
      f(params);
      AppMethodBeat.o(79520);
      return;
    }
    if ((params.field_status == 1) || (params.field_status == 0))
    {
      ab.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "db status: downloading or waiting, db content-length %d", new Object[] { Long.valueOf(params.field_contentLength) });
      if (!q.a.dmz().alR(params.field_urlKey))
      {
        ab.d("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "check md5");
        if (e(params))
        {
          ab.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "md5 match, request complete, throw event to do decrypt");
          params.field_status = 2;
          params.field_contentLength = a.eG(params.field_filePath);
          q.a.dmz().h(params);
          f(params);
          AppMethodBeat.o(79520);
          return;
        }
        if (0L == a.eG(params.field_filePath))
        {
          params.field_fileUpdated = true;
          q.a.dmz().h(params);
          b.c.dmg().f(params.field_resType, params.field_subType, 0, bo.nullAsNil(params.field_groupId2).equals("NewXml"));
        }
        ab.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "md5 not match,  download");
        q.a.dmz().d(c.d(params));
        AppMethodBeat.o(79520);
        return;
      }
      ab.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "request already in downloading queue");
      AppMethodBeat.o(79520);
      return;
    }
    if ((params.field_status == 4) || (params.field_status == 3))
    {
      ab.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "file invalid, re-download");
      params.field_status = 0;
      a(params, true);
    }
    AppMethodBeat.o(79520);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.h
 * JD-Core Version:    0.7.0.1
 */