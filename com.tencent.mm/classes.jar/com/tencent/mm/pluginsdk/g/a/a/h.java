package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.a.g;
import com.tencent.mm.pluginsdk.g.a.c.q;
import com.tencent.mm.pluginsdk.g.a.c.q.a;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.pluginsdk.g.a.c.t;
import com.tencent.mm.pluginsdk.g.a.d.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.Set;

final class h
  implements com.tencent.mm.pluginsdk.g.a.c.h
{
  private static void a(s params, boolean paramBoolean)
  {
    q.a.clL().Wn(params.field_urlKey);
    a.Wp(params.field_filePath);
    a.Wp(params.field_filePath + ".decompressed");
    a.Wp(params.field_filePath + ".decrypted");
    if ((2 == params.field_status) && (!paramBoolean))
    {
      y.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "delete completed but invalid file, but forceDL = false, skip this downloading");
      return;
    }
    if ((params.field_maxRetryTimes > 0) && (params.field_retryTimes <= 0))
    {
      y.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "record_maxRetryTimes = %d, record_retryTimes = %d, retry times out, skip ", new Object[] { Integer.valueOf(params.field_maxRetryTimes), Integer.valueOf(params.field_retryTimes) });
      return;
    }
    params.field_retryTimes -= 1;
    params.field_fileUpdated = true;
    q.a.clL().g(params);
    j.s(params.field_reportId, 12L);
    y.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "post network task");
    params = c.c(params);
    params.qZj = false;
    q.a.clL().d(params);
  }
  
  private static boolean d(s params)
  {
    return bk.pm(g.bQ(params.field_filePath)).equals(params.field_md5);
  }
  
  private static void e(s params)
  {
    if ((!params.field_fileCompress) && (!params.field_fileEncrypt))
    {
      b.c.clv().e(params.field_resType, params.field_subType, params.field_filePath, bk.getInt(params.field_fileVersion, 0));
      return;
    }
    y.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "send query and decrypt request");
    b.c.clv().b(params);
  }
  
  public final void a(s params, int paramInt)
  {
    Object localObject1;
    Object localObject2;
    if ((params.field_expireTime != 0L) && (params.field_expireTime <= bk.UX()))
    {
      y.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "urlKey(%s) exceed expire time(%d), delete", new Object[] { params.field_urlKey, Long.valueOf(params.field_expireTime) });
      localObject1 = q.a.clL();
      localObject2 = params.field_urlKey;
      if (((q)localObject1).gaO) {
        ((q)localObject1).rXN.jJ((String)localObject2);
      }
      a.Wp(params.field_filePath);
      a.Wp(params.field_filePath + ".decompressed");
      a.Wp(params.field_filePath + ".decrypted");
      q.a.clL().Wn(params.field_urlKey);
    }
    do
    {
      return;
      if (paramInt == 0)
      {
        y.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "network unavailable, skip");
        return;
      }
      if ((2 == paramInt) && (1 == params.field_networkType))
      {
        y.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "network type = gprs, record network type = wifi, skip this ");
        return;
      }
      if (params.field_deleted)
      {
        y.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "record(%s), should have been deleted", new Object[] { params.field_urlKey });
        a.Wp(params.field_filePath);
        a.Wp(params.field_filePath + ".decompressed");
        a.Wp(params.field_filePath + ".decrypted");
        return;
      }
      if (!params.field_needRetry)
      {
        y.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "no need retry, resType %d, subType %d, version %s", new Object[] { Integer.valueOf(params.field_resType), Integer.valueOf(params.field_subType), params.field_fileVersion });
        return;
      }
      if (params.field_status == 2)
      {
        long l = a.Jr(params.field_filePath);
        if (params.field_contentLength > l)
        {
          y.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "content-length > fileSize, resume download");
          if (0L == l)
          {
            if (!params.field_needRetry)
            {
              y.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "no need retry, resType %d, subType %d, version %s", new Object[] { Integer.valueOf(params.field_resType), Integer.valueOf(params.field_subType), params.field_fileVersion });
              return;
            }
            if (1 != paramInt)
            {
              y.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "fileSize = 0, completed file may be deleted by user, skip this because it's not wifi");
              return;
            }
            localObject1 = b.c.clv().clt().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (b.b)((Iterator)localObject1).next();
              paramInt = params.field_resType;
              paramInt = params.field_subType;
              bk.getInt(params.field_fileVersion, 0);
              if (((b.b)localObject2).clu())
              {
                y.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "filterNotRetry by %s, resType %d, subType %d, version %s", new Object[] { localObject2.getClass().getName(), Integer.valueOf(params.field_resType), Integer.valueOf(params.field_subType), params.field_fileVersion });
                return;
              }
            }
            params.field_fileUpdated = true;
            b.c.clv().e(params.field_resType, params.field_subType, 0, bk.pm(params.field_groupId2).equals("NewXml"));
            q.a.clL().g(params);
          }
          q.a.clL().d(c.c(params));
          return;
        }
        if (!d(params))
        {
          y.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "file invalid, re-download");
          if (1 == paramInt) {}
          for (boolean bool = true;; bool = false)
          {
            a(params, bool);
            return;
          }
        }
        y.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "md5 check ok, file download complete, throw event to do decrypt");
        e(params);
        return;
      }
      if ((params.field_status == 1) || (params.field_status == 0))
      {
        y.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "db status: downloading or waiting, db content-length %d", new Object[] { Long.valueOf(params.field_contentLength) });
        if (!q.a.clL().Wm(params.field_urlKey))
        {
          y.d("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "check md5");
          if (d(params))
          {
            y.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "md5 match, request complete, throw event to do decrypt");
            params.field_status = 2;
            params.field_contentLength = a.Jr(params.field_filePath);
            q.a.clL().g(params);
            e(params);
            return;
          }
          if (0L == a.Jr(params.field_filePath))
          {
            params.field_fileUpdated = true;
            q.a.clL().g(params);
            b.c.clv().e(params.field_resType, params.field_subType, 0, bk.pm(params.field_groupId2).equals("NewXml"));
          }
          y.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "md5 not match,  download");
          q.a.clL().d(c.c(params));
          return;
        }
        y.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "request already in downloading queue");
        return;
      }
    } while ((params.field_status != 4) && (params.field_status != 3));
    y.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "file invalid, re-download");
    params.field_status = 0;
    a(params, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.h
 * JD-Core Version:    0.7.0.1
 */