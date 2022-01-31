package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.j;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;

final class aj
  extends Handler
{
  aj(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    boolean bool3 = true;
    int i;
    label67:
    boolean bool1;
    Object localObject2;
    Object localObject1;
    switch (paramMessage.what)
    {
    case 105: 
    case 106: 
    case 107: 
    default: 
      return;
    case 100: 
      if (paramMessage.arg1 == 1)
      {
        i = 1;
        bool1 = TbsDownloader.a(true, false);
        if ((paramMessage.obj != null) && ((paramMessage.obj instanceof TbsDownloader.TbsDownloaderCallback)))
        {
          TbsLog.i("TbsDownload", "needDownload-onNeedDownloadFinish needStartDownload=" + bool1);
          localObject2 = "";
          localObject1 = localObject2;
          if (TbsDownloader.a() != null)
          {
            localObject1 = localObject2;
            if (TbsDownloader.a().getApplicationContext() != null)
            {
              localObject1 = localObject2;
              if (TbsDownloader.a().getApplicationContext().getApplicationInfo() != null) {
                localObject1 = TbsDownloader.a().getApplicationContext().getApplicationInfo().packageName;
              }
            }
          }
          if ((bool1) && (i == 0)) {
            break label231;
          }
          ((TbsDownloader.TbsDownloaderCallback)paramMessage.obj).onNeedDownloadFinish(bool1, TbsDownloadConfig.getInstance(TbsDownloader.a()).mPreferences.getInt("tbs_download_version", 0));
        }
      }
      while ((TbsShareManager.isThirdPartyApp(TbsDownloader.a())) && (bool1))
      {
        TbsDownloader.startDownload(TbsDownloader.a());
        return;
        i = 0;
        break label67;
        if ("com.tencent.mm".equals(localObject1))
        {
          TbsLog.i("TbsDownload", "needDownload-onNeedDownloadFinish in mm callback needStartDownload=" + bool1);
          ((TbsDownloader.TbsDownloaderCallback)paramMessage.obj).onNeedDownloadFinish(bool1, TbsDownloadConfig.getInstance(TbsDownloader.a()).mPreferences.getInt("tbs_download_version", 0));
        }
      }
    case 101: 
    case 108: 
      localObject1 = null;
      localObject2 = "tbs_download_lock_file" + TbsDownloadConfig.getInstance(TbsDownloader.a()).mPreferences.getInt("tbs_download_version", 0) + ".txt";
      FileOutputStream localFileOutputStream = j.b(TbsDownloader.a(), false, (String)localObject2);
      if (localFileOutputStream != null)
      {
        localObject2 = j.a(TbsDownloader.a(), localFileOutputStream);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          TbsLog.i("TbsDownload", "file lock locked,wx or qq is downloading");
          TbsDownloadConfig.getInstance(TbsDownloader.a()).setDownloadInterruptCode(-203);
          TbsLog.i("TbsDownload", "MSG_START_DOWNLOAD_DECOUPLECORE return #1");
        }
      }
      else if (j.a(TbsDownloader.a()))
      {
        TbsDownloadConfig.getInstance(TbsDownloader.a()).setDownloadInterruptCode(-204);
        TbsLog.i("TbsDownload", "MSG_START_DOWNLOAD_DECOUPLECORE return #2");
        return;
      }
      boolean bool2;
      if (paramMessage.arg1 == 1)
      {
        bool1 = true;
        localObject2 = TbsDownloadConfig.getInstance(TbsDownloader.a());
        if (108 != paramMessage.what) {
          break label539;
        }
        bool2 = true;
        if (!TbsDownloader.a(false, bool1, bool2)) {
          break label621;
        }
        if ((!bool1) || (!an.a().b(TbsDownloader.a(), TbsDownloadConfig.getInstance(TbsDownloader.a()).mPreferences.getInt("tbs_download_version", 0)))) {
          break label545;
        }
        QbSdk.m.onDownloadFinish(122);
        ((TbsDownloadConfig)localObject2).setDownloadInterruptCode(-213);
      }
      for (;;)
      {
        TbsLog.i("TbsDownload", "------freeFileLock called :");
        j.a((FileLock)localObject1, localFileOutputStream);
        return;
        bool1 = false;
        break;
        bool2 = false;
        break label458;
        if (((TbsDownloadConfig)localObject2).mPreferences.getBoolean("tbs_needdownload", false))
        {
          TbsDownloadConfig.getInstance(TbsDownloader.a()).setDownloadInterruptCode(-215);
          localObject2 = TbsDownloader.b();
          if (108 == paramMessage.what) {}
          for (bool2 = bool3;; bool2 = false)
          {
            ((ag)localObject2).b(bool1, bool2);
            break;
          }
        }
        QbSdk.m.onDownloadFinish(110);
        continue;
        QbSdk.m.onDownloadFinish(110);
      }
    case 102: 
      TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_REPORT_DOWNLOAD_STAT");
      if (TbsShareManager.isThirdPartyApp(TbsDownloader.a())) {}
      for (i = TbsShareManager.a(TbsDownloader.a(), false);; i = an.a().n(TbsDownloader.a()))
      {
        TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] localTbsVersion=" + i);
        TbsDownloader.b().a(i);
        TbsLogReport.getInstance(TbsDownloader.a()).dailyReport();
        return;
      }
    case 104: 
      label231:
      label621:
      TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_UPLOAD_TBSLOG");
      label458:
      TbsLogReport.getInstance(TbsDownloader.a()).reportTbsLog();
      label539:
      label545:
      return;
    }
    TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_CONTINUEINSTALL_TBSCORE");
    if (paramMessage.arg1 == 0)
    {
      an.a().a((Context)paramMessage.obj, true);
      return;
    }
    an.a().a((Context)paramMessage.obj, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.aj
 * JD-Core Version:    0.7.0.1
 */