package com.tencent.tmassistantsdk.downloadservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
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
  final Map<String, DownloadInfo> mDownloads;
  
  private ApkDownloadManager()
  {
    AppMethodBeat.i(101927);
    this.mDownloads = new ConcurrentHashMap();
    AppMethodBeat.o(101927);
  }
  
  public static ApkDownloadManager getInstance()
  {
    AppMethodBeat.i(101926);
    if (mApkDownloadManager == null) {
      mApkDownloadManager = new ApkDownloadManager();
    }
    ApkDownloadManager localApkDownloadManager = mApkDownloadManager;
    AppMethodBeat.o(101926);
    return localApkDownloadManager;
  }
  
  public void AddDownloadListener(IDownloadManagerListener paramIDownloadManagerListener)
  {
    AppMethodBeat.i(101935);
    TMLog.i("ApkDownloadManager", "call AddDownloadListener, dl: ".concat(String.valueOf(paramIDownloadManagerListener)));
    DownloadListenerManager.getInstance().Add(paramIDownloadManagerListener);
    AppMethodBeat.o(101935);
  }
  
  public void RemoveDownloadListener(IDownloadManagerListener paramIDownloadManagerListener)
  {
    AppMethodBeat.i(101936);
    TMLog.i("ApkDownloadManager", "call RemoveDownloadListener, dl: ".concat(String.valueOf(paramIDownloadManagerListener)));
    DownloadListenerManager.getInstance().Remove(paramIDownloadManagerListener);
    AppMethodBeat.o(101936);
  }
  
  public void cancelDownload(String paramString)
  {
    AppMethodBeat.i(101932);
    TMLog.i("ApkDownloadManager", "call cancelDownload, url: ".concat(String.valueOf(paramString)));
    paramString = (DownloadInfo)this.mDownloads.remove(paramString);
    if (paramString != null) {
      paramString.stopDownload();
    }
    AppMethodBeat.o(101932);
  }
  
  public void init()
  {
    AppMethodBeat.i(101928);
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
    AppMethodBeat.o(101928);
  }
  
  public Boolean isAllDownloadFinished()
  {
    AppMethodBeat.i(101934);
    Object localObject = this.mDownloads.keySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      if (!((DownloadInfo)this.mDownloads.get(((Iterator)localObject).next())).hasFinished())
      {
        localObject = Boolean.FALSE;
        AppMethodBeat.o(101934);
        return localObject;
      }
    }
    localObject = Boolean.TRUE;
    AppMethodBeat.o(101934);
    return localObject;
  }
  
  public void onNetworkChanged()
  {
    AppMethodBeat.i(101937);
    TMLog.i("ApkDownloadManager", "onNetworkChanged");
    if ((DownloadHelper.isNetworkConncted()) && (DownloadSetting.getInstance().isAutoDownload()))
    {
      String str = DownloadHelper.getNetStatus();
      TMLog.i("ApkDownloadManager", "currentNetType = ".concat(String.valueOf(str)));
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
    AppMethodBeat.o(101937);
  }
  
  public void pauseDownload(String paramString)
  {
    AppMethodBeat.i(101931);
    TMLog.i("ApkDownloadManager", "call pauseDownload, url: ".concat(String.valueOf(paramString)));
    paramString = (DownloadInfo)this.mDownloads.get(paramString);
    if (paramString != null) {
      paramString.pauseDownload();
    }
    AppMethodBeat.o(101931);
  }
  
  public DownloadInfo queryDownloadInfo(String paramString)
  {
    AppMethodBeat.i(101933);
    TMLog.i("ApkDownloadManager", "call queryDownloadInfo, url: ".concat(String.valueOf(paramString)));
    Object localObject2 = (DownloadInfo)this.mDownloads.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = DBManager.getInstance().queryDownloadInfoByUrl(paramString);
    }
    boolean bool = false;
    if (localObject1 != null) {
      if (!((DownloadInfo)localObject1).mContentType.equals("application/tm.android.apkdiff")) {
        break label134;
      }
    }
    label134:
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
      AppMethodBeat.o(101933);
      return localObject2;
    }
  }
  
  public int startDownload(String paramString1, String paramString2, long paramLong, int paramInt, String paramString3, String paramString4, Map<String, String> paramMap)
  {
    AppMethodBeat.i(101930);
    TMLog.i("ApkDownloadManager", "call startDownload, url: " + paramString1 + "priority: " + paramInt);
    if (!DownloadHelper.isNetworkConncted())
    {
      TMLog.i("ApkDownloadManager", "call startDownload, return errCode: 1");
      AppMethodBeat.o(101930);
      return 1;
    }
    if ((!DownloadHelper.getNetStatus().equalsIgnoreCase("wifi")) && (DownloadSetting.getInstance().getIsDownloadWifiOnly()))
    {
      TMLog.i("ApkDownloadManager", "call startDownload, return errCode: 2");
      AppMethodBeat.o(101930);
      return 2;
    }
    if (!DownloadHelper.isValidURL(paramString1))
    {
      TMLog.i("ApkDownloadManager", "call startDownload, return errCode: 3");
      AppMethodBeat.o(101930);
      return 3;
    }
    if (DownloadHelper.isDownloadFileExisted(paramString1, paramString3))
    {
      TMLog.i("ApkDownloadManager", "call startDownload, return errCode: 4");
      AppMethodBeat.o(101930);
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
        TMLog.i("ApkDownloadManager", "fileExited = ".concat(String.valueOf(bool)));
        if (!bool) {
          break label374;
        }
        AppMethodBeat.o(101930);
        return 4;
        if (((DownloadInfo)localObject1).mContentType.equals("application/tm.android.apkdiff")) {}
        for (bool = DownloadHelper.isDownloadFileExisted(paramString1, ((DownloadInfo)localObject1).mContentType); bool; bool = DownloadHelper.isDownloadFileExisted(((DownloadInfo)localObject1).mFileName))
        {
          TMLog.i("ApkDownloadManager", "call startDownload, return errCode: 4");
          AppMethodBeat.o(101930);
          return 4;
        }
        break;
      }
      label374:
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
      TMLog.i("ApkDownloadManager", "call startDownload, return errCode: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(101930);
      return paramInt;
    }
  }
  
  public void uninit()
  {
    AppMethodBeat.i(101929);
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
    AppMethodBeat.o(101929);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.ApkDownloadManager
 * JD-Core Version:    0.7.0.1
 */