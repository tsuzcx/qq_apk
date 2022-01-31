package com.tencent.tmassistantsdk.downloadservice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class DownloadThreadPool
{
  public static final String TAG = "DownloadThreadPool";
  protected static DownloadThreadPool mDownloadThreadPool = null;
  final ArrayList<DownloadThreadPool.TaskThread> mDownloadThreadList = new ArrayList();
  final ArrayList<DownloadTask> mExecList = new ArrayList();
  protected final Comparator<DownloadTask> mPriorityQueueComparator = new Comparator()
  {
    public int compare(DownloadTask paramAnonymousDownloadTask1, DownloadTask paramAnonymousDownloadTask2)
    {
      if (paramAnonymousDownloadTask1.getPriority() > paramAnonymousDownloadTask2.getPriority()) {
        return 1;
      }
      if (paramAnonymousDownloadTask1.getPriority() == paramAnonymousDownloadTask2.getPriority()) {
        return 0;
      }
      return -1;
    }
  };
  final Object mTaskLock = new Object();
  final Object mThreadlock = new Object();
  final PriorityQueue<DownloadTask> mWaitingList = new PriorityQueue(16, this.mPriorityQueueComparator);
  
  private DownloadThreadPool()
  {
    int j = DownloadSetting.getInstance().getMaxTaskNum();
    int i = 0;
    while (i < j)
    {
      DownloadThreadPool.TaskThread localTaskThread = new DownloadThreadPool.TaskThread(this, i);
      this.mDownloadThreadList.add(localTaskThread);
      i += 1;
    }
  }
  
  public static DownloadThreadPool getInstance()
  {
    if (mDownloadThreadPool == null) {
      mDownloadThreadPool = new DownloadThreadPool();
    }
    return mDownloadThreadPool;
  }
  
  int addDownloadTask(DownloadTask paramDownloadTask)
  {
    synchronized (this.mTaskLock)
    {
      this.mWaitingList.add(paramDownloadTask);
      synchronized (this.mThreadlock)
      {
        this.mThreadlock.notifyAll();
        int i = paramDownloadTask.getTaskId();
        return i;
      }
    }
  }
  
  void cancelDownloadTask(int paramInt)
  {
    synchronized (this.mTaskLock)
    {
      Iterator localIterator = this.mExecList.iterator();
      DownloadTask localDownloadTask;
      while (localIterator.hasNext())
      {
        localDownloadTask = (DownloadTask)localIterator.next();
        if (localDownloadTask.getTaskId() == paramInt)
        {
          localDownloadTask.cancel();
          this.mExecList.remove(localDownloadTask);
          return;
        }
      }
      localIterator = this.mWaitingList.iterator();
      while (localIterator.hasNext())
      {
        localDownloadTask = (DownloadTask)localIterator.next();
        if (localDownloadTask.getTaskId() == paramInt)
        {
          localDownloadTask.cancel();
          this.mWaitingList.remove(localDownloadTask);
          return;
        }
      }
    }
  }
  
  public DownloadTask getDownloadTask(String paramString)
  {
    synchronized (this.mTaskLock)
    {
      Iterator localIterator = this.mExecList.iterator();
      DownloadTask localDownloadTask;
      while (localIterator.hasNext())
      {
        localDownloadTask = (DownloadTask)localIterator.next();
        if (localDownloadTask.getDownloadURI().equals(paramString)) {
          return localDownloadTask;
        }
      }
      localIterator = this.mWaitingList.iterator();
      while (localIterator.hasNext())
      {
        localDownloadTask = (DownloadTask)localIterator.next();
        if (localDownloadTask.getDownloadURI().equals(paramString)) {
          return localDownloadTask;
        }
      }
    }
    return null;
  }
  
  boolean hasWaitingTask()
  {
    for (;;)
    {
      synchronized (this.mTaskLock)
      {
        if (this.mWaitingList.size() > 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.DownloadThreadPool
 * JD-Core Version:    0.7.0.1
 */