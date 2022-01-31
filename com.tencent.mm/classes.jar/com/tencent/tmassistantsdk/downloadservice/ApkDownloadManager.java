package com.tencent.tmassistantsdk.downloadservice;

import com.tencent.tmassistantsdk.storage.DBManager;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ApkDownloadManager
  implements NetworkMonitorReceiver.INetworkChangedObserver
{
  protected static final long INTERVAL = 180000L;
  protected static final String TAG = "ApkDownloadManager";
  protected static ApkDownloadManager mApkDownloadManager = null;
  final Map<String, DownloadInfo> mDownloads = new ConcurrentHashMap();
  
  public static ApkDownloadManager getInstance()
  {
    if (mApkDownloadManager == null) {
      mApkDownloadManager = new ApkDownloadManager();
    }
    return mApkDownloadManager;
  }
  
  public void AddDownloadListener(IDownloadManagerListener paramIDownloadManagerListener)
  {
    TMLog.i("ApkDownloadManager", "call AddDownloadListener, dl: " + paramIDownloadManagerListener);
    DownloadListenerManager.getInstance().Add(paramIDownloadManagerListener);
  }
  
  public void RemoveDownloadListener(IDownloadManagerListener paramIDownloadManagerListener)
  {
    TMLog.i("ApkDownloadManager", "call RemoveDownloadListener, dl: " + paramIDownloadManagerListener);
    DownloadListenerManager.getInstance().Remove(paramIDownloadManagerListener);
  }
  
  public void cancelDownload(String paramString)
  {
    TMLog.i("ApkDownloadManager", "call cancelDownload, url: " + paramString);
    paramString = (DownloadInfo)this.mDownloads.remove(paramString);
    if (paramString != null) {
      paramString.stopDownload();
    }
  }
  
  public void init()
  {
    TMLog.i("ApkDownloadManager", "Start to load DownloadInfo list.");
    this.mDownloads.clear();
    Object localObject = DBManager.getInstance().queryDownloadInfoList();
    if (localObject != null)
    {
      TMLog.i("ApkDownloadManager", "The size of downloadinfo_list: " + ((ArrayList)localObject).size());
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)((Iterator)localObject).next();
        TMLog.i("ApkDownloadManager", "---------------load download info---------------");
        localDownloadInfo.dump("ApkDownloadManager");
        this.mDownloads.put(localDownloadInfo.mURL, localDownloadInfo);
        if (!localDownloadInfo.hasFinished()) {
          localDownloadInfo.updateStatus(3, false);
        }
      }
    }
    TMLog.i("ApkDownloadManager", "Add NetworkChangedObserver to NetworkMonitorReceiver");
    NetworkMonitorReceiver.getInstance().addNetworkChangedObserver(this);
  }
  
  public Boolean isAllDownloadFinished()
  {
    Iterator localIterator = this.mDownloads.keySet().iterator();
    while (localIterator.hasNext()) {
      if (!((DownloadInfo)this.mDownloads.get(localIterator.next())).hasFinished()) {
        return Boolean.valueOf(false);
      }
    }
    return Boolean.valueOf(true);
  }
  
  public void onNetworkChanged()
  {
    TMLog.i("ApkDownloadManager", "onNetworkChanged");
    if ((DownloadHelper.isNetworkConncted()) && (DownloadSetting.getInstance().isAutoDownload()))
    {
      String str = DownloadHelper.getNetStatus();
      TMLog.i("ApkDownloadManager", "currentNetType = " + str);
      Iterator localIterator = this.mDownloads.keySet().iterator();
      while (localIterator.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)this.mDownloads.get(localIterator.next());
        if (DownloadSetting.getInstance().isAutoDownload(localDownloadInfo.mNetType, str))
        {
          TMLog.i("ApkDownloadManager", "onNetworkChanged, errCode = " + localDownloadInfo.mDownloadFailedErrCode);
          if ((localDownloadInfo.mDownloadFailedErrCode == 601) || (localDownloadInfo.mDownloadFailedErrCode == 602) || (localDownloadInfo.mDownloadFailedErrCode == 605) || (localDownloadInfo.mDownloadFailedErrCode == 603) || (localDownloadInfo.mDownloadFailedErrCode == 606))
          {
            long l = System.currentTimeMillis();
            TMLog.i("ApkDownloadManager", "onNetworkChanged, currentTime = " + l + ", DownloadFailedTime = " + localDownloadInfo.mDownloadFailedTime);
            if (l - localDownloadInfo.mDownloadFailedTime < 180000L) {
              localDownloadInfo.startDownloadIfReady(true);
            }
          }
        }
      }
    }
  }
  
  public void pauseDownload(String paramString)
  {
    TMLog.i("ApkDownloadManager", "call pauseDownload, url: " + paramString);
    paramString = (DownloadInfo)this.mDownloads.get(paramString);
    if (paramString != null) {
      paramString.pauseDownload();
    }
  }
  
  public DownloadInfo queryDownloadInfo(String paramString)
  {
    TMLog.i("ApkDownloadManager", "call queryDownloadInfo, url: " + paramString);
    Object localObject2 = (DownloadInfo)this.mDownloads.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = DBManager.getInstance().queryDownloadInfoByUrl(paramString);
    }
    boolean bool = false;
    if (localObject1 != null) {
      if (!((DownloadInfo)localObject1).mContentType.equals("application/tm.android.apkdiff")) {
        break label127;
      }
    }
    label127:
    for (bool = DownloadHelper.isDownloadFileExisted(paramString, ((DownloadInfo)localObject1).mContentType);; bool = DownloadHelper.isDownloadFileExisted(((DownloadInfo)localObject1).mFileName))
    {
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((DownloadInfo)localObject1).hasReceivedAllDataBytes())
        {
          localObject2 = localObject1;
          if (!bool)
          {
            this.mDownloads.remove(paramString);
            DBManager.getInstance().deleteDownloadInfo(paramString);
            localObject2 = null;
          }
        }
      }
      return localObject2;
    }
  }
  
  public int startDownload(String paramString1, String paramString2, long paramLong, int paramInt, String paramString3, String paramString4, Map<String, String> paramMap)
  {
    TMLog.i("ApkDownloadManager", "call startDownload, url: " + paramString1 + "priority: " + paramInt);
    if (!DownloadHelper.isNetworkConncted())
    {
      TMLog.i("ApkDownloadManager", "call startDownload, return errCode: 1");
      return 1;
    }
    if ((!DownloadHelper.getNetStatus().equalsIgnoreCase("wifi")) && (DownloadSetting.getInstance().getIsDownloadWifiOnly()))
    {
      TMLog.i("ApkDownloadManager", "call startDownload, return errCode: 2");
      return 2;
    }
    if (!DownloadHelper.isValidURL(paramString1))
    {
      TMLog.i("ApkDownloadManager", "call startDownload, return errCode: 3");
      return 3;
    }
    if (DownloadHelper.isDownloadFileExisted(paramString1, paramString3))
    {
      TMLog.i("ApkDownloadManager", "call startDownload, return errCode: 4");
      return 4;
    }
    Object localObject1 = (DownloadInfo)this.mDownloads.get(paramString1);
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = DBManager.getInstance().queryDownloadInfoByUrl(paramString1);
      if (localObject1 == null)
      {
        localObject2 = new DownloadInfo(paramString1, paramString2, paramLong, paramInt, paramString3);
        localObject1 = localObject2;
        if (((DownloadInfo)localObject2).mContentType.equals("resource/tm.android.unknown"))
        {
          ((DownloadInfo)localObject2).mFileName = paramString4;
          localObject1 = localObject2;
        }
        this.mDownloads.put(paramString1, localObject1);
      }
    }
    for (;;)
    {
      ((DownloadInfo)localObject1).setHeaderParams((HashMap)paramMap);
      if (((DownloadInfo)localObject1).mContentType.equals("application/tm.android.apkdiff")) {}
      for (boolean bool = DownloadHelper.isDownloadFileExisted(paramString1, ((DownloadInfo)localObject1).mContentType);; bool = DownloadHelper.isDownloadFileExisted(((DownloadInfo)localObject1).mFileName))
      {
        TMLog.i("ApkDownloadManager", "fileExited = " + bool);
        if (!bool) {
          break label337;
        }
        return 4;
        if (((DownloadInfo)localObject1).mContentType.equals("application/tm.android.apkdiff")) {}
        for (bool = DownloadHelper.isDownloadFileExisted(paramString1, ((DownloadInfo)localObject1).mContentType); bool; bool = DownloadHelper.isDownloadFileExisted(((DownloadInfo)localObject1).mFileName))
        {
          TMLog.i("ApkDownloadManager", "call startDownload, return errCode: 4");
          return 4;
        }
        break;
      }
      label337:
      localObject2 = localObject1;
      if (((DownloadInfo)localObject1).hasReceivedAllDataBytes())
      {
        localObject2 = localObject1;
        if (!bool)
        {
          this.mDownloads.remove(paramString1);
          DBManager.getInstance().deleteDownloadInfo(paramString1);
          localObject2 = new DownloadInfo(paramString1, paramString2, paramLong, paramInt, paramString3);
          if (((DownloadInfo)localObject2).mContentType.equals("resource/tm.android.unknown")) {
            ((DownloadInfo)localObject2).mFileName = paramString4;
          }
          ((DownloadInfo)localObject2).setHeaderParams((HashMap)paramMap);
          this.mDownloads.put(paramString1, localObject2);
        }
      }
      paramInt = ((DownloadInfo)localObject2).startDownloadIfReady();
      TMLog.i("ApkDownloadManager", "call startDownload, return errCode: " + paramInt);
      return paramInt;
    }
  }
  
  public void uninit()
  {
    NetworkMonitorReceiver.getInstance().removeNetworkChangedObserver(this);
    ArrayList localArrayList = new ArrayList();
    if (!this.mDownloads.isEmpty())
    {
      Iterator localIterator = this.mDownloads.keySet().iterator();
      while (localIterator.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)this.mDownloads.get(localIterator.next());
        if (localDownloadInfo.mStatus == 2) {
          pauseDownload(localDownloadInfo.mURL);
        }
        localArrayList.add(localDownloadInfo);
      }
    }
    TMLog.i("ApkDownloadManager", "Start to save DownloadInfo list.");
    DBManager.getInstance().saveDownloadInfoList(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.ApkDownloadManager
 * JD-Core Version:    0.7.0.1
 */