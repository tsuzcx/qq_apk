package com.tencent.tmassistantsdk.downloadservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class DownloadThreadPool
{
  public static final String TAG = "DownloadThreadPool";
  protected static DownloadThreadPool mDownloadThreadPool = null;
  final ArrayList<DownloadThreadPool.TaskThread> mDownloadThreadList;
  final ArrayList<DownloadTask> mExecList;
  protected final Comparator<DownloadTask> mPriorityQueueComparator;
  final Object mTaskLock;
  final Object mThreadlock;
  final PriorityQueue<DownloadTask> mWaitingList;
  
  private DownloadThreadPool()
  {
    AppMethodBeat.i(75763);
    this.mPriorityQueueComparator = new Comparator()
    {
      public int compare(DownloadTask paramAnonymousDownloadTask1, DownloadTask paramAnonymousDownloadTask2)
      {
        AppMethodBeat.i(75757);
        if (paramAnonymousDownloadTask1.getPriority() > paramAnonymousDownloadTask2.getPriority())
        {
          AppMethodBeat.o(75757);
          return 1;
        }
        if (paramAnonymousDownloadTask1.getPriority() == paramAnonymousDownloadTask2.getPriority())
        {
          AppMethodBeat.o(75757);
          return 0;
        }
        AppMethodBeat.o(75757);
        return -1;
      }
    };
    this.mWaitingList = new PriorityQueue(16, this.mPriorityQueueComparator);
    this.mExecList = new ArrayList();
    this.mDownloadThreadList = new ArrayList();
    this.mThreadlock = new Object();
    this.mTaskLock = new Object();
    int j = DownloadSetting.getInstance().getMaxTaskNum();
    int i = 0;
    while (i < j)
    {
      DownloadThreadPool.TaskThread localTaskThread = new DownloadThreadPool.TaskThread(this, i);
      this.mDownloadThreadList.add(localTaskThread);
      i += 1;
    }
    AppMethodBeat.o(75763);
  }
  
  public static DownloadThreadPool getInstance()
  {
    AppMethodBeat.i(75762);
    if (mDownloadThreadPool == null) {
      mDownloadThreadPool = new DownloadThreadPool();
    }
    DownloadThreadPool localDownloadThreadPool = mDownloadThreadPool;
    AppMethodBeat.o(75762);
    return localDownloadThreadPool;
  }
  
  int addDownloadTask(DownloadTask paramDownloadTask)
  {
    AppMethodBeat.i(75764);
    synchronized (this.mTaskLock)
    {
      this.mWaitingList.add(paramDownloadTask);
      synchronized (this.mThreadlock)
      {
        this.mThreadlock.notifyAll();
        int i = paramDownloadTask.getTaskId();
        AppMethodBeat.o(75764);
        return i;
      }
    }
  }
  
  void cancelDownloadTask(int paramInt)
  {
    AppMethodBeat.i(75765);
    new Thread(new DownloadThreadPool.2(this, paramInt)).start();
    AppMethodBeat.o(75765);
  }
  
  public DownloadTask getDownloadTask(String paramString)
  {
    AppMethodBeat.i(75767);
    synchronized (this.mTaskLock)
    {
      Iterator localIterator = this.mExecList.iterator();
      DownloadTask localDownloadTask;
      while (localIterator.hasNext())
      {
        localDownloadTask = (DownloadTask)localIterator.next();
        if (localDownloadTask.getDownloadURI().equals(paramString))
        {
          AppMethodBeat.o(75767);
          return localDownloadTask;
        }
      }
      localIterator = this.mWaitingList.iterator();
      while (localIterator.hasNext())
      {
        localDownloadTask = (DownloadTask)localIterator.next();
        if (localDownloadTask.getDownloadURI().equals(paramString))
        {
          AppMethodBeat.o(75767);
          return localDownloadTask;
        }
      }
      AppMethodBeat.o(75767);
      return null;
    }
  }
  
  boolean hasWaitingTask()
  {
    AppMethodBeat.i(75766);
    synchronized (this.mTaskLock)
    {
      if (this.mWaitingList.size() > 0)
      {
        bool = true;
        AppMethodBeat.o(75766);
        return bool;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.DownloadThreadPool
 * JD-Core Version:    0.7.0.1
 */