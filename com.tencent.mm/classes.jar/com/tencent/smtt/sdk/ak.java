package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.k;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;

final class ak
  extends Handler
{
  ak(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    boolean bool3 = true;
    AppMethodBeat.i(139251);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(139251);
      return;
      label80:
      boolean bool1;
      if (paramMessage.arg1 == 1)
      {
        i = 1;
        if (paramMessage.arg2 != 1) {
          break label254;
        }
        bool1 = true;
        label90:
        bool1 = TbsDownloader.a(true, false, false, bool1);
        if ((paramMessage.obj != null) && ((paramMessage.obj instanceof TbsDownloader.TbsDownloaderCallback)))
        {
          TbsLog.i("TbsDownload", "needDownload-onNeedDownloadFinish needStartDownload=".concat(String.valueOf(bool1)));
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
            break label259;
          }
          ((TbsDownloader.TbsDownloaderCallback)paramMessage.obj).onNeedDownloadFinish(bool1, TbsDownloadConfig.getInstance(TbsDownloader.a()).mPreferences.getInt("tbs_download_version", 0));
        }
      }
      while ((TbsShareManager.isThirdPartyApp(TbsDownloader.a())) && (bool1))
      {
        TbsDownloader.startDownload(TbsDownloader.a());
        AppMethodBeat.o(139251);
        return;
        i = 0;
        break label80;
        label254:
        bool1 = false;
        break label90;
        label259:
        if (("com.tencent.mm".equals(localObject1)) || ("com.tencent.mobileqq".equals(localObject1)))
        {
          TbsLog.i("TbsDownload", "needDownload-onNeedDownloadFinish in mm or QQ callback needStartDownload = ".concat(String.valueOf(bool1)));
          ((TbsDownloader.TbsDownloaderCallback)paramMessage.obj).onNeedDownloadFinish(bool1, TbsDownloadConfig.getInstance(TbsDownloader.a()).mPreferences.getInt("tbs_download_version", 0));
        }
      }
      Object localObject1 = null;
      Object localObject3 = null;
      Object localObject2 = localObject3;
      if (!TbsShareManager.isThirdPartyApp(TbsDownloader.a()))
      {
        localObject1 = "tbs_download_lock_file" + TbsDownloadConfig.getInstance(TbsDownloader.a()).mPreferences.getInt("tbs_download_version", 0) + ".txt";
        localObject1 = k.b(TbsDownloader.a(), false, (String)localObject1);
        if (localObject1 != null)
        {
          localObject3 = k.a(TbsDownloader.a(), (FileOutputStream)localObject1);
          localObject2 = localObject3;
          if (localObject3 == null)
          {
            QbSdk.m.onDownloadFinish(177);
            TbsLog.i("TbsDownload", "file lock locked,wx or qq is downloading");
            TbsDownloadConfig.getInstance(TbsDownloader.a()).setDownloadInterruptCode(-203);
            TbsLog.i("TbsDownload", "MSG_START_DOWNLOAD_DECOUPLECORE return #1");
            AppMethodBeat.o(139251);
          }
        }
        else
        {
          localObject2 = localObject3;
          if (k.a(TbsDownloader.a()))
          {
            TbsDownloadConfig.getInstance(TbsDownloader.a()).setDownloadInterruptCode(-204);
            TbsLog.i("TbsDownload", "MSG_START_DOWNLOAD_DECOUPLECORE return #2");
            AppMethodBeat.o(139251);
            return;
          }
        }
      }
      boolean bool2;
      if (paramMessage.arg1 == 1)
      {
        bool1 = true;
        localObject3 = TbsDownloadConfig.getInstance(TbsDownloader.a());
        if (108 != paramMessage.what) {
          break label617;
        }
        bool2 = true;
        label530:
        if (!TbsDownloader.a(false, bool1, bool2, true)) {
          break label699;
        }
        if ((!bool1) || (!ao.a().b(TbsDownloader.a(), TbsDownloadConfig.getInstance(TbsDownloader.a()).mPreferences.getInt("tbs_download_version", 0)))) {
          break label623;
        }
        QbSdk.m.onDownloadFinish(122);
        ((TbsDownloadConfig)localObject3).setDownloadInterruptCode(-213);
      }
      for (;;)
      {
        TbsLog.i("TbsDownload", "------freeFileLock called :");
        k.a((FileLock)localObject2, (FileOutputStream)localObject1);
        AppMethodBeat.o(139251);
        return;
        bool1 = false;
        break;
        label617:
        bool2 = false;
        break label530;
        label623:
        if (((TbsDownloadConfig)localObject3).mPreferences.getBoolean("tbs_needdownload", false))
        {
          TbsDownloadConfig.getInstance(TbsDownloader.a()).setDownloadInterruptCode(-215);
          localObject3 = TbsDownloader.b();
          if (108 == paramMessage.what) {}
          for (bool2 = bool3;; bool2 = false)
          {
            ((ah)localObject3).b(bool1, bool2);
            break;
          }
        }
        QbSdk.m.onDownloadFinish(110);
        continue;
        label699:
        QbSdk.m.onDownloadFinish(110);
      }
      TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_REPORT_DOWNLOAD_STAT");
      if (TbsShareManager.isThirdPartyApp(TbsDownloader.a())) {}
      for (int i = TbsShareManager.a(TbsDownloader.a(), false);; i = ao.a().m(TbsDownloader.a()))
      {
        TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] localTbsVersion=".concat(String.valueOf(i)));
        TbsDownloader.b().a(i);
        TbsLogReport.getInstance(TbsDownloader.a()).dailyReport();
        AppMethodBeat.o(139251);
        return;
      }
      TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_UPLOAD_TBSLOG");
      TbsLogReport.getInstance(TbsDownloader.a()).reportTbsLog();
      AppMethodBeat.o(139251);
      return;
      TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_CONTINUEINSTALL_TBSCORE");
      if (paramMessage.arg1 == 0)
      {
        ao.a().a((Context)paramMessage.obj, true);
        AppMethodBeat.o(139251);
        return;
      }
      ao.a().a((Context)paramMessage.obj, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.ak
 * JD-Core Version:    0.7.0.1
 */