package com.tencent.qqmusic.mediaplayer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class DataRangeTracker
{
  private static final long LOCK_INTERVAL = 1000L;
  private static final String TAG = "DataRangeTracker";
  private final ReentrantReadWriteLock lock;
  private Comparator<Range> mComparator;
  private final ArrayList<Range> mDownloadDataList;
  private long mFileTotalSize;
  private long waitingPosition;
  private int waitingSize;
  
  public DataRangeTracker()
  {
    AppMethodBeat.i(76725);
    this.mDownloadDataList = new ArrayList();
    this.lock = new ReentrantReadWriteLock();
    this.mFileTotalSize = 0L;
    this.mComparator = new Comparator()
    {
      public int compare(DataRangeTracker.Range paramAnonymousRange1, DataRangeTracker.Range paramAnonymousRange2)
      {
        AppMethodBeat.i(76414);
        int i = (int)(DataRangeTracker.Range.access$200(paramAnonymousRange1) - DataRangeTracker.Range.access$200(paramAnonymousRange2));
        AppMethodBeat.o(76414);
        return i;
      }
    };
    AppMethodBeat.o(76725);
  }
  
  private void lockRead()
  {
    AppMethodBeat.i(76737);
    this.lock.readLock().lock();
    AppMethodBeat.o(76737);
  }
  
  private void unlock()
  {
    try
    {
      AppMethodBeat.i(76739);
      Logger.i("DataRangeTracker", "[unlock].");
      notifyAll();
      AppMethodBeat.o(76739);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void unlockRead()
  {
    AppMethodBeat.i(76738);
    this.lock.readLock().unlock();
    AppMethodBeat.o(76738);
  }
  
  public void abandonLock()
  {
    AppMethodBeat.i(76735);
    Logger.i("DataRangeTracker", "[abandonLock]");
    unblock();
    unlock();
    AppMethodBeat.o(76735);
  }
  
  public void addRange(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(212359);
    if (paramLong1 > paramLong2)
    {
      Logger.e("DataRangeTracker", "[addRange] illegal arguments! beginPos(%s) > endPos(%s)", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      AppMethodBeat.o(212359);
      return;
    }
    this.lock.writeLock().lock();
    for (;;)
    {
      ArrayList localArrayList;
      try
      {
        localArrayList = new ArrayList();
        this.mDownloadDataList.add(new Range(paramLong1, paramLong2, null));
        Collections.sort(this.mDownloadDataList, this.mComparator);
        int j = this.mDownloadDataList.size() - 1;
        Range localRange1 = (Range)this.mDownloadDataList.get(0);
        if (j <= 0) {
          break label291;
        }
        i = 1;
        if (i <= j)
        {
          Range localRange2 = (Range)this.mDownloadDataList.get(i);
          if (localRange1.second + 1L < localRange2.first)
          {
            localArrayList.add(new Range(localRange1.first, localRange1.second, null));
            localRange1 = new Range(localRange2.first, localRange2.second, null);
            if (i < j) {
              break label433;
            }
            localArrayList.add(localRange1);
            break label433;
          }
          paramLong1 = Math.max(localRange1.second, localRange2.second);
          localRange1 = new Range(localRange1.first, paramLong1, null);
          continue;
        }
        this.mDownloadDataList.clear();
      }
      finally
      {
        this.lock.writeLock().unlock();
        AppMethodBeat.o(212359);
      }
      this.mDownloadDataList.addAll(localArrayList);
      label291:
      if ((this.waitingPosition >= 0L) && (this.waitingSize > 0))
      {
        boolean bool = isCached(this.waitingPosition, this.waitingSize);
        if (!bool) {}
      }
      for (int i = 1;; i = 0)
      {
        this.lock.writeLock().unlock();
        if (i == 0) {
          break;
        }
        Logger.i("DataRangeTracker", "[addRange] notify position: " + this.waitingPosition + ", size: " + this.waitingSize);
        if (paramBoolean) {}
        try
        {
          unlock();
          this.waitingPosition = 0L;
          this.waitingSize = 0;
          return;
        }
        finally
        {
          AppMethodBeat.o(212359);
        }
      }
      AppMethodBeat.o(212359);
      return;
      label433:
      i += 1;
    }
  }
  
  public void block()
  {
    AppMethodBeat.i(76733);
    Logger.i("DataRangeTracker", "[block]");
    AppMethodBeat.o(76733);
  }
  
  long findEnd(long paramLong)
  {
    AppMethodBeat.i(76728);
    lockRead();
    try
    {
      int j = this.mDownloadDataList.size();
      if (j == 0) {
        return -1L;
      }
      int i = 0;
      while (i < j)
      {
        if (paramLong < ((Range)this.mDownloadDataList.get(i)).first)
        {
          paramLong = ((Range)this.mDownloadDataList.get(i)).first;
          return paramLong - 1L;
        }
        if ((paramLong <= ((Range)this.mDownloadDataList.get(i)).second) && (i + 1 < j))
        {
          paramLong = ((Range)this.mDownloadDataList.get(i + 1)).first;
          return paramLong - 1L;
        }
        i += 1;
      }
      return 0L;
    }
    finally
    {
      unlockRead();
      AppMethodBeat.o(76728);
    }
  }
  
  public long findStart(long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(76727);
    lockRead();
    try
    {
      int j = this.mDownloadDataList.size();
      if (j == 0) {
        return -1L;
      }
      long l1 = ((Range)this.mDownloadDataList.get(0)).second + 1L;
      while (i < j)
      {
        long l2 = ((Range)this.mDownloadDataList.get(i)).first;
        if (paramLong < l2) {
          return l1;
        }
        l1 = ((Range)this.mDownloadDataList.get(i)).second + 1L;
        if (paramLong <= ((Range)this.mDownloadDataList.get(i)).second)
        {
          paramLong = ((Range)this.mDownloadDataList.get(i)).second;
          return paramLong + 1L;
        }
        i += 1;
      }
      paramLong = ((Range)this.mDownloadDataList.get(this.mDownloadDataList.size() - 1)).second;
      return paramLong + 1L;
    }
    finally
    {
      unlockRead();
      AppMethodBeat.o(76727);
    }
  }
  
  public long getContinuousEnd()
  {
    AppMethodBeat.i(76731);
    lockRead();
    try
    {
      int i = this.mDownloadDataList.size();
      if (i == 0) {
        return -1L;
      }
      long l = ((Range)this.mDownloadDataList.get(0)).second;
      return l;
    }
    finally
    {
      unlockRead();
      AppMethodBeat.o(76731);
    }
  }
  
  public long getContinuousStart()
  {
    AppMethodBeat.i(76730);
    lockRead();
    try
    {
      int i = this.mDownloadDataList.size();
      if (i == 0) {
        return -1L;
      }
      long l = ((Range)this.mDownloadDataList.get(0)).first;
      return l;
    }
    finally
    {
      unlockRead();
      AppMethodBeat.o(76730);
    }
  }
  
  public boolean isCached(long paramLong, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(76729);
    lockRead();
    try
    {
      long l2 = findStart(paramLong);
      long l1 = findStart(paramInt + paramLong);
      long l3 = findEnd(paramLong);
      long l4 = findEnd(paramInt + paramLong);
      if ((l2 != l1) || (l3 != l4)) {
        return false;
      }
      if (l3 == -1L) {
        return false;
      }
      l1 = paramInt + paramLong;
      paramLong = l1;
      if (this.mFileTotalSize > 0L)
      {
        paramLong = l1;
        if (l1 > this.mFileTotalSize) {
          paramLong = this.mFileTotalSize;
        }
      }
      if (paramLong <= l2) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      unlockRead();
      AppMethodBeat.o(76729);
    }
  }
  
  public boolean lock(long paramLong1, int paramInt, long paramLong2, LockJudgerCallback paramLockJudgerCallback)
  {
    for (;;)
    {
      int j;
      int i;
      try
      {
        AppMethodBeat.i(212361);
        Logger.i("DataRangeTracker", "[lock] position = [" + paramLong1 + "]. size = [" + paramInt + "]. timeout = [" + paramLong2 + "].");
        this.waitingPosition = paramLong1;
        this.waitingSize = paramInt;
        j = (int)(paramLong2 / 1000L);
        i = j;
        if (j > 0) {
          break label266;
        }
        i = 1;
      }
      finally {}
      if (j < i)
      {
        wait(1000L);
        if ((paramLockJudgerCallback != null) && (paramLockJudgerCallback.isToAbandonLock())) {
          Logger.i("DataRangeTracker", "lockJudgerCallback.isToAbandonLock() is true, exit the wait loop");
        }
      }
      else
      {
        AppMethodBeat.o(212361);
        return true;
      }
      if (isCached(this.waitingPosition, this.waitingSize))
      {
        Logger.i("DataRangeTracker", "isCached(waitingPosition, waitingSize) is true, exit the wait loop, wawaitingPosition = " + this.waitingPosition + ", waitingSize = " + this.waitingSize);
      }
      else
      {
        Logger.i("DataRangeTracker", "continue [lock] position = [" + paramLong1 + "]. size = [" + paramInt + "]. totalSize = [" + this.mFileTotalSize + "]. findStart(position) = [" + findStart(paramLong1) + "]. i = " + j);
        j += 1;
        continue;
        label266:
        j = 0;
      }
    }
  }
  
  public void setFileTotalSize(long paramLong)
  {
    this.mFileTotalSize = paramLong;
  }
  
  public void unblock()
  {
    AppMethodBeat.i(76734);
    Logger.i("DataRangeTracker", "[unblock]");
    AppMethodBeat.o(76734);
  }
  
  public static abstract interface LockJudgerCallback
  {
    public abstract boolean isToAbandonLock();
  }
  
  static class Range
  {
    private final long first;
    private final long second;
    
    private Range(long paramLong1, long paramLong2)
    {
      this.first = paramLong1;
      this.second = paramLong2;
    }
    
    public String toString()
    {
      AppMethodBeat.i(76669);
      String str = "[" + this.first + ", " + this.second + ']';
      AppMethodBeat.o(76669);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.DataRangeTracker
 * JD-Core Version:    0.7.0.1
 */