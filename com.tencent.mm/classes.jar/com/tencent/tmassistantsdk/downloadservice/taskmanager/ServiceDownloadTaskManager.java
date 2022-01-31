package com.tencent.tmassistantsdk.downloadservice.taskmanager;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.downloadservice.ApkDownloadManager;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.downloadservice.IDownloadManagerListener;
import com.tencent.tmassistantsdk.storage.TMAssistantFile;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class ServiceDownloadTaskManager
  implements IDownloadManagerListener
{
  protected static final String TAG = "ServiceDownloadTaskManager";
  protected IServiceDownloadTaskManagerListener mListener;
  protected ArrayList<ServiceDownloadTask> mServiceTaskList;
  
  public ServiceDownloadTaskManager(ArrayList<ServiceDownloadTask> paramArrayList)
  {
    AppMethodBeat.i(75796);
    this.mServiceTaskList = new ArrayList();
    this.mListener = null;
    if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
      this.mServiceTaskList.addAll(paramArrayList);
    }
    AppMethodBeat.o(75796);
  }
  
  public void OnDownloadProgressChanged(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(75807);
    if (this.mListener == null)
    {
      AppMethodBeat.o(75807);
      return;
    }
    Object localObject = findDownloadTask(paramString);
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      long l = System.currentTimeMillis();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ServiceDownloadTask localServiceDownloadTask = (ServiceDownloadTask)((Iterator)localObject).next();
        if (localServiceDownloadTask.checkIsNeedUpdateProgress(paramLong1, paramLong2, l) == true)
        {
          TMLog.i("ServiceDownloadTaskManager", "OnDownloadProgressChanged,clientKey:" + localServiceDownloadTask.mClientKey + ",receivedLen:" + paramLong1 + ",url:" + paramString.hashCode());
          this.mListener.OnDownloadProgressChanged(localServiceDownloadTask.mClientKey, paramString, paramLong1, paramLong2);
        }
      }
    }
    AppMethodBeat.o(75807);
  }
  
  public void OnDownloadStateChanged(String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(75806);
    if (this.mListener == null)
    {
      AppMethodBeat.o(75806);
      return;
    }
    Object localObject = findDownloadTask(paramString1);
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ServiceDownloadTask localServiceDownloadTask = (ServiceDownloadTask)((Iterator)localObject).next();
        TMLog.i("ServiceDownloadTaskManager", "OnDownloadStateChanged,clientKey:" + localServiceDownloadTask.mClientKey + ",state:" + paramInt1 + ",errorcode:" + paramInt2 + ",url:" + paramString1.hashCode());
        localServiceDownloadTask.mState = paramInt1;
        this.mListener.OnDownloadStateChanged(localServiceDownloadTask.mClientKey, paramString1, paramInt1, paramInt2, paramString2, paramBoolean1, paramBoolean2);
      }
    }
    AppMethodBeat.o(75806);
  }
  
  public void cancelDownload(String paramString1, String paramString2)
  {
    AppMethodBeat.i(75800);
    if ((paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(75800);
      return;
    }
    TMLog.i("ServiceDownloadTaskManager", "cancelDownload,clientKey:".concat(String.valueOf(paramString1)));
    Object localObject = findDownloadTask(paramString1, paramString2);
    if (localObject != null)
    {
      this.mServiceTaskList.remove(localObject);
      TMLog.i("ServiceDownloadTaskManager", "cancelDownload,clientKey:" + paramString1 + ",remove taskItem");
    }
    for (;;)
    {
      localObject = findDownloadTask(paramString2);
      if ((localObject == null) || (((ArrayList)localObject).size() == 0))
      {
        TMLog.i("ServiceDownloadTaskManager", "cancelDownload,clientKey:" + paramString1 + ",taskItem is the only on cancelAll");
        ApkDownloadManager.getInstance().cancelDownload(paramString2);
      }
      AppMethodBeat.o(75800);
      return;
      TMLog.w("ServiceDownloadTaskManager", "cancelDownload,clientKey:" + paramString1 + ",taskItem is null");
    }
  }
  
  protected ServiceDownloadTask findDownloadTask(String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(75803);
        if ((paramString1 == null) || (paramString2 == null))
        {
          AppMethodBeat.o(75803);
          paramString1 = null;
          return paramString1;
        }
        Iterator localIterator = this.mServiceTaskList.iterator();
        if (localIterator.hasNext())
        {
          ServiceDownloadTask localServiceDownloadTask = (ServiceDownloadTask)localIterator.next();
          if ((localServiceDownloadTask.mClientKey == null) || (!localServiceDownloadTask.mClientKey.equals(paramString1)) || (!localServiceDownloadTask.mUrl.equals(paramString2))) {
            continue;
          }
          AppMethodBeat.o(75803);
          paramString1 = localServiceDownloadTask;
          continue;
        }
        AppMethodBeat.o(75803);
      }
      finally {}
      paramString1 = null;
    }
  }
  
  protected ArrayList<ServiceDownloadTask> findDownloadTask(String paramString)
  {
    for (;;)
    {
      ArrayList localArrayList;
      try
      {
        AppMethodBeat.i(75804);
        if (paramString == null)
        {
          paramString = null;
          AppMethodBeat.o(75804);
          return paramString;
        }
        localArrayList = new ArrayList();
        Iterator localIterator = this.mServiceTaskList.iterator();
        if (localIterator.hasNext())
        {
          ServiceDownloadTask localServiceDownloadTask = (ServiceDownloadTask)localIterator.next();
          if (!localServiceDownloadTask.mUrl.equals(paramString)) {
            continue;
          }
          localArrayList.add(localServiceDownloadTask);
          continue;
        }
        AppMethodBeat.o(75804);
      }
      finally {}
      paramString = localArrayList;
    }
  }
  
  public TMAssistantDownloadTaskInfo getDownloadTaskInfo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(75797);
    paramString1 = ApkDownloadManager.getInstance().queryDownloadInfo(paramString2);
    if (paramString1 != null)
    {
      paramString1 = new TMAssistantDownloadTaskInfo(paramString1.mURL, TMAssistantFile.getSaveFilePath(paramString1.mFileName), paramString1.mStatus, paramString1.mReceivedBytes, paramString1.getTotalSize(), paramString1.mContentType);
      AppMethodBeat.o(75797);
      return paramString1;
    }
    Object localObject;
    if (DownloadHelper.isDownloadFileExisted(paramString2, "application/vnd.android.package-archive"))
    {
      localObject = DownloadHelper.generateFileNameFromURL(paramString2, "application/vnd.android.package-archive");
      paramString1 = TMAssistantFile.getSaveFilePath((String)localObject);
      localObject = new TMAssistantFile((String)localObject, (String)localObject);
      paramString1 = new TMAssistantDownloadTaskInfo(paramString2, paramString1, 4, ((TMAssistantFile)localObject).length(), ((TMAssistantFile)localObject).length(), "application/vnd.android.package-archive");
      AppMethodBeat.o(75797);
      return paramString1;
    }
    if (DownloadHelper.isDownloadFileExisted(paramString2, "application/tm.android.apkdiff"))
    {
      localObject = DownloadHelper.generateFileNameFromURL(paramString2, "application/tm.android.apkdiff");
      paramString1 = TMAssistantFile.getSaveFilePath((String)localObject);
      localObject = new TMAssistantFile((String)localObject, (String)localObject);
      paramString1 = new TMAssistantDownloadTaskInfo(paramString2, paramString1, 4, ((TMAssistantFile)localObject).length(), ((TMAssistantFile)localObject).length(), "application/tm.android.apkdiff");
      AppMethodBeat.o(75797);
      return paramString1;
    }
    removeDownloadTask(paramString2);
    AppMethodBeat.o(75797);
    return null;
  }
  
  public void pauseDownload(String paramString1, String paramString2)
  {
    AppMethodBeat.i(75799);
    if ((paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(75799);
      return;
    }
    TMLog.i("ServiceDownloadTaskManager", "pauseDownload,clientKey:".concat(String.valueOf(paramString1)));
    ServiceDownloadTask localServiceDownloadTask = findDownloadTask(paramString1, paramString2);
    if (localServiceDownloadTask != null)
    {
      localServiceDownloadTask.mState = 3;
      this.mServiceTaskList.remove(localServiceDownloadTask);
      TMLog.i("ServiceDownloadTaskManager", "pauseDownload,clientKey:" + paramString1 + ",remove taskItem");
      ArrayList localArrayList = findDownloadTask(paramString2);
      if ((localArrayList == null) || (localArrayList.size() == 0))
      {
        TMLog.i("ServiceDownloadTaskManager", "pauseDownload,clientKey:" + paramString1 + ",taskItem is the only on pauseAll");
        ApkDownloadManager.getInstance().pauseDownload(paramString2);
        TMLog.i("ServiceDownloadTaskManager", "pauseDownload end,clientKey:" + paramString1 + ",taskItem is the only on pauseAll");
      }
      if (this.mListener != null) {
        this.mListener.OnDownloadStateChanged(paramString1, paramString2, localServiceDownloadTask.mState, 0, null, false, false);
      }
    }
    for (;;)
    {
      TMLog.i("ServiceDownloadTaskManager", "pauseDownload end,clientKey:".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(75799);
      return;
      TMLog.w("ServiceDownloadTaskManager", "pauseDownload,clientKey:" + paramString1 + ",taskItem is null");
    }
  }
  
  public void registerApkDownloadManagerListener()
  {
    AppMethodBeat.i(75801);
    ApkDownloadManager.getInstance().AddDownloadListener(this);
    AppMethodBeat.o(75801);
  }
  
  protected void removeDownloadTask(String paramString)
  {
    for (;;)
    {
      ArrayList localArrayList;
      try
      {
        AppMethodBeat.i(75805);
        if (paramString == null)
        {
          AppMethodBeat.o(75805);
          return;
        }
        localArrayList = new ArrayList();
        Iterator localIterator = this.mServiceTaskList.iterator();
        if (localIterator.hasNext())
        {
          ServiceDownloadTask localServiceDownloadTask = (ServiceDownloadTask)localIterator.next();
          if (!localServiceDownloadTask.mUrl.equals(paramString)) {
            continue;
          }
          localArrayList.add(localServiceDownloadTask);
          continue;
        }
        if (localArrayList.size() <= 0) {
          break label100;
        }
      }
      finally {}
      this.mServiceTaskList.removeAll(localArrayList);
      label100:
      AppMethodBeat.o(75805);
    }
  }
  
  public void setListener(IServiceDownloadTaskManagerListener paramIServiceDownloadTaskManagerListener)
  {
    this.mListener = paramIServiceDownloadTaskManagerListener;
  }
  
  public int startDownload(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt, String paramString4, String paramString5, Map<String, String> paramMap)
  {
    AppMethodBeat.i(75798);
    if ((paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(75798);
      return 3;
    }
    TMLog.i("ServiceDownloadTaskManager", "startDownload,clientKey:".concat(String.valueOf(paramString1)));
    if (findDownloadTask(paramString1, paramString2) != null)
    {
      TMLog.i("ServiceDownloadTaskManager", "startDownload,clientKey:" + paramString1 + ",taskItem isn't null");
      paramInt = ApkDownloadManager.getInstance().startDownload(paramString2, paramString3, paramLong, paramInt, paramString4, paramString5, paramMap);
      AppMethodBeat.o(75798);
      return paramInt;
    }
    Object localObject = findDownloadTask(paramString2);
    int i = 0;
    ServiceDownloadTask localServiceDownloadTask1 = new ServiceDownloadTask(paramString1, paramString2);
    localServiceDownloadTask1.mState = 1;
    this.mServiceTaskList.add(localServiceDownloadTask1);
    TMLog.i("ServiceDownloadTaskManager", "startDownload,clientKey:" + paramString1 + ",add newTask");
    localObject = ((ArrayList)localObject).iterator();
    int j = 0;
    while (((Iterator)localObject).hasNext())
    {
      ServiceDownloadTask localServiceDownloadTask2 = (ServiceDownloadTask)((Iterator)localObject).next();
      if (localServiceDownloadTask2.mState == 2)
      {
        j = 1;
      }
      else
      {
        if (localServiceDownloadTask2.mState != 1) {
          break label397;
        }
        i = 1;
      }
    }
    label397:
    for (;;)
    {
      break;
      if ((j == 1) || (i == 1))
      {
        if (j == 1) {
          localServiceDownloadTask1.mState = 2;
        }
        for (;;)
        {
          if (this.mListener != null) {
            this.mListener.OnDownloadStateChanged(paramString1, paramString2, localServiceDownloadTask1.mState, 0, null, false, false);
          }
          TMLog.i("ServiceDownloadTaskManager", "startDownload,clientKey:" + paramString1 + ",newTask is downloading, state = " + localServiceDownloadTask1.mState);
          AppMethodBeat.o(75798);
          return 0;
          if (i == 1) {
            localServiceDownloadTask1.mState = 1;
          }
        }
      }
      TMLog.i("ServiceDownloadTaskManager", "startDownload,clientKey:" + paramString1 + ",start newTask download");
      paramInt = ApkDownloadManager.getInstance().startDownload(paramString2, paramString3, paramLong, paramInt, paramString4, paramString5, paramMap);
      AppMethodBeat.o(75798);
      return paramInt;
    }
  }
  
  public void unRegisterApkDownloadManagerListener()
  {
    AppMethodBeat.i(75802);
    ApkDownloadManager.getInstance().RemoveDownloadListener(this);
    AppMethodBeat.o(75802);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.taskmanager.ServiceDownloadTaskManager
 * JD-Core Version:    0.7.0.1
 */