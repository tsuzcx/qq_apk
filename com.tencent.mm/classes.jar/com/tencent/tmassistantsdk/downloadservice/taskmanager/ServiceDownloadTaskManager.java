package com.tencent.tmassistantsdk.downloadservice.taskmanager;

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
  protected IServiceDownloadTaskManagerListener mListener = null;
  protected ArrayList<ServiceDownloadTask> mServiceTaskList = new ArrayList();
  
  public ServiceDownloadTaskManager(ArrayList<ServiceDownloadTask> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
      this.mServiceTaskList.addAll(paramArrayList);
    }
  }
  
  public void OnDownloadProgressChanged(String paramString, long paramLong1, long paramLong2)
  {
    if (this.mListener == null) {}
    for (;;)
    {
      return;
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
    }
  }
  
  public void OnDownloadStateChanged(String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mListener == null) {}
    for (;;)
    {
      return;
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
    }
  }
  
  public void cancelDownload(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    TMLog.i("ServiceDownloadTaskManager", "cancelDownload,clientKey:" + paramString1);
    Object localObject = findDownloadTask(paramString1, paramString2);
    if (localObject != null)
    {
      this.mServiceTaskList.remove(localObject);
      TMLog.i("ServiceDownloadTaskManager", "cancelDownload,clientKey:" + paramString1 + ",remove taskItem");
    }
    for (;;)
    {
      localObject = findDownloadTask(paramString2);
      if ((localObject != null) && (((ArrayList)localObject).size() != 0)) {
        break;
      }
      TMLog.i("ServiceDownloadTaskManager", "cancelDownload,clientKey:" + paramString1 + ",taskItem is the only on cancelAll");
      ApkDownloadManager.getInstance().cancelDownload(paramString2);
      return;
      TMLog.w("ServiceDownloadTaskManager", "cancelDownload,clientKey:" + paramString1 + ",taskItem is null");
    }
  }
  
  protected ServiceDownloadTask findDownloadTask(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      paramString1 = null;
    }
    for (;;)
    {
      return paramString1;
      try
      {
        Iterator localIterator = this.mServiceTaskList.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            ServiceDownloadTask localServiceDownloadTask = (ServiceDownloadTask)localIterator.next();
            if ((localServiceDownloadTask.mClientKey != null) && (localServiceDownloadTask.mClientKey.equals(paramString1)))
            {
              boolean bool = localServiceDownloadTask.mUrl.equals(paramString2);
              if (bool)
              {
                paramString1 = localServiceDownloadTask;
                break;
              }
            }
          }
        }
        paramString1 = null;
      }
      finally {}
    }
  }
  
  protected ArrayList<ServiceDownloadTask> findDownloadTask(String paramString)
  {
    if (paramString == null) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      try
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.mServiceTaskList.iterator();
        while (localIterator.hasNext())
        {
          ServiceDownloadTask localServiceDownloadTask = (ServiceDownloadTask)localIterator.next();
          if (localServiceDownloadTask.mUrl.equals(paramString)) {
            localArrayList.add(localServiceDownloadTask);
          }
        }
        paramString = localArrayList;
      }
      finally {}
    }
  }
  
  public TMAssistantDownloadTaskInfo getDownloadTaskInfo(String paramString1, String paramString2)
  {
    paramString1 = ApkDownloadManager.getInstance().queryDownloadInfo(paramString2);
    if (paramString1 != null) {
      return new TMAssistantDownloadTaskInfo(paramString1.mURL, TMAssistantFile.getSaveFilePath(paramString1.mFileName), paramString1.mStatus, paramString1.mReceivedBytes, paramString1.getTotalSize(), paramString1.mContentType);
    }
    Object localObject;
    if (DownloadHelper.isDownloadFileExisted(paramString2, "application/vnd.android.package-archive"))
    {
      localObject = DownloadHelper.generateFileNameFromURL(paramString2, "application/vnd.android.package-archive");
      paramString1 = TMAssistantFile.getSaveFilePath((String)localObject);
      localObject = new TMAssistantFile((String)localObject, (String)localObject);
      return new TMAssistantDownloadTaskInfo(paramString2, paramString1, 4, ((TMAssistantFile)localObject).length(), ((TMAssistantFile)localObject).length(), "application/vnd.android.package-archive");
    }
    if (DownloadHelper.isDownloadFileExisted(paramString2, "application/tm.android.apkdiff"))
    {
      localObject = DownloadHelper.generateFileNameFromURL(paramString2, "application/tm.android.apkdiff");
      paramString1 = TMAssistantFile.getSaveFilePath((String)localObject);
      localObject = new TMAssistantFile((String)localObject, (String)localObject);
      return new TMAssistantDownloadTaskInfo(paramString2, paramString1, 4, ((TMAssistantFile)localObject).length(), ((TMAssistantFile)localObject).length(), "application/tm.android.apkdiff");
    }
    removeDownloadTask(paramString2);
    return null;
  }
  
  public void pauseDownload(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    TMLog.i("ServiceDownloadTaskManager", "pauseDownload,clientKey:" + paramString1);
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
      TMLog.i("ServiceDownloadTaskManager", "pauseDownload end,clientKey:" + paramString1);
      return;
      TMLog.w("ServiceDownloadTaskManager", "pauseDownload,clientKey:" + paramString1 + ",taskItem is null");
    }
  }
  
  public void registerApkDownloadManagerListener()
  {
    if (this != null) {
      ApkDownloadManager.getInstance().AddDownloadListener(this);
    }
  }
  
  protected void removeDownloadTask(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return;
      ArrayList localArrayList;
      try
      {
        localArrayList = new ArrayList();
        Iterator localIterator = this.mServiceTaskList.iterator();
        while (localIterator.hasNext())
        {
          ServiceDownloadTask localServiceDownloadTask = (ServiceDownloadTask)localIterator.next();
          if (localServiceDownloadTask.mUrl.equals(paramString)) {
            localArrayList.add(localServiceDownloadTask);
          }
        }
        if (localArrayList.size() <= 0) {
          continue;
        }
      }
      finally {}
      this.mServiceTaskList.removeAll(localArrayList);
    }
  }
  
  public void setListener(IServiceDownloadTaskManagerListener paramIServiceDownloadTaskManagerListener)
  {
    this.mListener = paramIServiceDownloadTaskManagerListener;
  }
  
  public int startDownload(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt, String paramString4, String paramString5, Map<String, String> paramMap)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return 3;
    }
    TMLog.i("ServiceDownloadTaskManager", "startDownload,clientKey:" + paramString1);
    if (findDownloadTask(paramString1, paramString2) != null)
    {
      TMLog.i("ServiceDownloadTaskManager", "startDownload,clientKey:" + paramString1 + ",taskItem isn't null");
      return ApkDownloadManager.getInstance().startDownload(paramString2, paramString3, paramLong, paramInt, paramString4, paramString5, paramMap);
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
          break label360;
        }
        i = 1;
      }
    }
    label360:
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
          return 0;
          if (i == 1) {
            localServiceDownloadTask1.mState = 1;
          }
        }
      }
      TMLog.i("ServiceDownloadTaskManager", "startDownload,clientKey:" + paramString1 + ",start newTask download");
      return ApkDownloadManager.getInstance().startDownload(paramString2, paramString3, paramLong, paramInt, paramString4, paramString5, paramMap);
    }
  }
  
  public void unRegisterApkDownloadManagerListener()
  {
    if (this != null) {
      ApkDownloadManager.getInstance().RemoveDownloadListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.taskmanager.ServiceDownloadTaskManager
 * JD-Core Version:    0.7.0.1
 */