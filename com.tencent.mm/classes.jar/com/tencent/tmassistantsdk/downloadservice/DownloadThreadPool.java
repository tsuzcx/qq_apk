package com.tencent.tmassistantsdk.downloadservice;

import android.os.PowerManager.WakeLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class DownloadThreadPool
{
  public static final String TAG = "DownloadThreadPool";
  protected static DownloadThreadPool mDownloadThreadPool = null;
  final ArrayList<TaskThread> mDownloadThreadList;
  final ArrayList<DownloadTask> mExecList;
  protected final Comparator<DownloadTask> mPriorityQueueComparator;
  final Object mTaskLock;
  final Object mThreadlock;
  final PriorityQueue<DownloadTask> mWaitingList;
  
  private DownloadThreadPool()
  {
    AppMethodBeat.i(102009);
    this.mPriorityQueueComparator = new Comparator()
    {
      public int compare(DownloadTask paramAnonymousDownloadTask1, DownloadTask paramAnonymousDownloadTask2)
      {
        AppMethodBeat.i(102003);
        if (paramAnonymousDownloadTask1.getPriority() > paramAnonymousDownloadTask2.getPriority())
        {
          AppMethodBeat.o(102003);
          return 1;
        }
        if (paramAnonymousDownloadTask1.getPriority() == paramAnonymousDownloadTask2.getPriority())
        {
          AppMethodBeat.o(102003);
          return 0;
        }
        AppMethodBeat.o(102003);
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
      TaskThread localTaskThread = new TaskThread(i);
      this.mDownloadThreadList.add(localTaskThread);
      i += 1;
    }
    AppMethodBeat.o(102009);
  }
  
  public static DownloadThreadPool getInstance()
  {
    AppMethodBeat.i(102008);
    if (mDownloadThreadPool == null) {
      mDownloadThreadPool = new DownloadThreadPool();
    }
    DownloadThreadPool localDownloadThreadPool = mDownloadThreadPool;
    AppMethodBeat.o(102008);
    return localDownloadThreadPool;
  }
  
  int addDownloadTask(DownloadTask paramDownloadTask)
  {
    AppMethodBeat.i(102010);
    synchronized (this.mTaskLock)
    {
      this.mWaitingList.add(paramDownloadTask);
      synchronized (this.mThreadlock)
      {
        this.mThreadlock.notifyAll();
        int i = paramDownloadTask.getTaskId();
        AppMethodBeat.o(102010);
        return i;
      }
    }
  }
  
  void cancelDownloadTask(final int paramInt)
  {
    AppMethodBeat.i(102011);
    new Thread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(102005);
        synchronized (DownloadThreadPool.this.mTaskLock)
        {
          Iterator localIterator = DownloadThreadPool.this.mExecList.iterator();
          DownloadTask localDownloadTask;
          while (localIterator.hasNext())
          {
            localDownloadTask = (DownloadTask)localIterator.next();
            if (localDownloadTask.getTaskId() == paramInt)
            {
              localDownloadTask.cancel();
              DownloadThreadPool.this.mExecList.remove(localDownloadTask);
              AppMethodBeat.o(102005);
              return;
            }
          }
          localIterator = DownloadThreadPool.this.mWaitingList.iterator();
          while (localIterator.hasNext())
          {
            localDownloadTask = (DownloadTask)localIterator.next();
            if (localDownloadTask.getTaskId() == paramInt)
            {
              localDownloadTask.cancel();
              DownloadThreadPool.this.mWaitingList.remove(localDownloadTask);
              AppMethodBeat.o(102005);
              return;
            }
          }
          AppMethodBeat.o(102005);
          return;
        }
      }
    }).start();
    AppMethodBeat.o(102011);
  }
  
  public DownloadTask getDownloadTask(String paramString)
  {
    AppMethodBeat.i(102013);
    synchronized (this.mTaskLock)
    {
      Iterator localIterator = this.mExecList.iterator();
      DownloadTask localDownloadTask;
      while (localIterator.hasNext())
      {
        localDownloadTask = (DownloadTask)localIterator.next();
        if (localDownloadTask.getDownloadURI().equals(paramString))
        {
          AppMethodBeat.o(102013);
          return localDownloadTask;
        }
      }
      localIterator = this.mWaitingList.iterator();
      while (localIterator.hasNext())
      {
        localDownloadTask = (DownloadTask)localIterator.next();
        if (localDownloadTask.getDownloadURI().equals(paramString))
        {
          AppMethodBeat.o(102013);
          return localDownloadTask;
        }
      }
      AppMethodBeat.o(102013);
      return null;
    }
  }
  
  boolean hasWaitingTask()
  {
    AppMethodBeat.i(102012);
    synchronized (this.mTaskLock)
    {
      if (this.mWaitingList.size() > 0)
      {
        bool = true;
        AppMethodBeat.o(102012);
        return bool;
      }
      boolean bool = false;
    }
  }
  
  class TaskThread
    extends Thread
  {
    private byte _hellAccFlag_;
    private int mIndex;
    
    public TaskThread(int paramInt)
    {
      AppMethodBeat.i(102006);
      this.mIndex = 0;
      this.mIndex = paramInt;
      setName("download_thread_" + this.mIndex);
      start();
      AppMethodBeat.o(102006);
    }
    
    public void run()
    {
      AppMethodBeat.i(102007);
      TMLog.i("DownloadThreadPool", "Thread " + this.mIndex + " starts running...");
      synchronized (DownloadThreadPool.this.mThreadlock)
      {
        try
        {
          TMLog.i("DownloadThreadPool", "Thread " + this.mIndex + " is waitting...");
          DownloadThreadPool.this.mThreadlock.wait();
          if (!Thread.currentThread().isInterrupted()) {
            break label309;
          }
          TMLog.i("DownloadThreadPool", "Thread " + this.mIndex + " is interrupted...");
          AppMethodBeat.o(102007);
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          TMLog.i("DownloadThreadPool", "Thread " + this.mIndex + " is interrupted...");
          Log.printErrStackTrace("DownloadThreadPool", localInterruptedException, "", new Object[0]);
          AppMethodBeat.o(102007);
          return;
        }
      }
      label189:
      if (??? != null)
      {
        TMLog.i("DownloadThreadPool", "TaskThread::Run ThreadName: " + getName() + " url: " + ((DownloadTask)???).getDownloadURI());
        ??? = DownloadHelper.getWakeLock();
        ((DownloadTask)???).exec(getName());
        if (??? != null)
        {
          a.b(???, "com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool$TaskThread", "run", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
          ((PowerManager.WakeLock)???).release();
          a.c(???, "com/tencent/tmassistantsdk/downloadservice/DownloadThreadPool$TaskThread", "run", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
        }
      }
      ??? = DownloadThreadPool.this.mTaskLock;
      if (??? != null) {}
      for (;;)
      {
        try
        {
          for (;;)
          {
            DownloadThreadPool.this.mExecList.remove(???);
            label309:
            if (!DownloadThreadPool.this.hasWaitingTask()) {
              break;
            }
            synchronized (DownloadThreadPool.this.mTaskLock)
            {
              if (DownloadThreadPool.this.mWaitingList.size() > 0)
              {
                ??? = (DownloadTask)DownloadThreadPool.this.mWaitingList.remove();
                DownloadThreadPool.this.mExecList.add(???);
                if (!Thread.currentThread().isInterrupted()) {
                  break label189;
                }
                TMLog.i("DownloadThreadPool", "Thread " + this.mIndex + " is interrupted...");
                AppMethodBeat.o(102007);
                return;
              }
            }
          }
          Object localObject4 = null;
        }
        finally
        {
          AppMethodBeat.o(102007);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.DownloadThreadPool
 * JD-Core Version:    0.7.0.1
 */