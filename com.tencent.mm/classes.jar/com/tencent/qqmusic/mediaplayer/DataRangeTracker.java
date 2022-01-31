package com.tencent.qqmusic.mediaplayer;

import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class DataRangeTracker
{
  private static final long LOCK_INTERVAL = 2000L;
  private static final String TAG = "DataRangeTracker";
  private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
  private Comparator<DataRangeTracker.Range> mComparator = new DataRangeTracker.1(this);
  private final ArrayList<DataRangeTracker.Range> mDownloadDataList = new ArrayList();
  private long waitingPosition;
  private int waitingSize;
  
  private void lockRead()
  {
    this.lock.readLock().lock();
  }
  
  private void unlock()
  {
    try
    {
      Logger.i("DataRangeTracker", "[unlock].");
      notifyAll();
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
    this.lock.readLock().unlock();
  }
  
  public void abandonLock()
  {
    Logger.i("DataRangeTracker", "[abandonLock]");
    unblock();
    unlock();
  }
  
  public void addRange(long paramLong1, long paramLong2)
  {
    if (paramLong1 > paramLong2)
    {
      Logger.e("DataRangeTracker", "[addRange] illegal arguments! beginPos(%s) > endPos(%s)", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      return;
    }
    this.lock.writeLock().lock();
    for (;;)
    {
      ArrayList localArrayList;
      try
      {
        localArrayList = new ArrayList();
        this.mDownloadDataList.add(new DataRangeTracker.Range(paramLong1, paramLong2, null));
        Collections.sort(this.mDownloadDataList, this.mComparator);
        int j = this.mDownloadDataList.size() - 1;
        DataRangeTracker.Range localRange1 = (DataRangeTracker.Range)this.mDownloadDataList.get(0);
        if (j <= 0) {
          break label291;
        }
        i = 1;
        if (i > j) {
          break label274;
        }
        DataRangeTracker.Range localRange2 = (DataRangeTracker.Range)this.mDownloadDataList.get(i);
        if (DataRangeTracker.Range.access$100(localRange1) + 1L < DataRangeTracker.Range.access$200(localRange2))
        {
          localArrayList.add(new DataRangeTracker.Range(DataRangeTracker.Range.access$200(localRange1), DataRangeTracker.Range.access$100(localRange1), null));
          localRange1 = new DataRangeTracker.Range(DataRangeTracker.Range.access$200(localRange2), DataRangeTracker.Range.access$100(localRange2), null);
          if (i < j) {
            break label412;
          }
          localArrayList.add(localRange1);
          break label412;
        }
        if (DataRangeTracker.Range.access$100(localRange1) > DataRangeTracker.Range.access$100(localRange2))
        {
          paramLong1 = DataRangeTracker.Range.access$100(localRange1);
          localRange1 = new DataRangeTracker.Range(DataRangeTracker.Range.access$200(localRange1), paramLong1, null);
          continue;
        }
        paramLong1 = DataRangeTracker.Range.access$100(localRange2);
      }
      finally
      {
        this.lock.writeLock().unlock();
      }
      continue;
      label274:
      this.mDownloadDataList.clear();
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
        try
        {
          unlock();
          this.waitingPosition = 0L;
          this.waitingSize = 0;
          return;
        }
        finally {}
      }
      label412:
      i += 1;
    }
  }
  
  public void block()
  {
    Logger.i("DataRangeTracker", "[block]");
  }
  
  public long findEnd(long paramLong)
  {
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
        if (paramLong < DataRangeTracker.Range.access$200((DataRangeTracker.Range)this.mDownloadDataList.get(i)))
        {
          paramLong = DataRangeTracker.Range.access$200((DataRangeTracker.Range)this.mDownloadDataList.get(i));
          return paramLong - 1L;
        }
        if ((paramLong <= DataRangeTracker.Range.access$100((DataRangeTracker.Range)this.mDownloadDataList.get(i))) && (i + 1 < j))
        {
          paramLong = DataRangeTracker.Range.access$200((DataRangeTracker.Range)this.mDownloadDataList.get(i + 1));
          return paramLong - 1L;
        }
        i += 1;
      }
      return 0L;
    }
    finally
    {
      unlockRead();
    }
  }
  
  public long findStart(long paramLong)
  {
    int i = 0;
    lockRead();
    try
    {
      int j = this.mDownloadDataList.size();
      if (j == 0) {
        return -1L;
      }
      long l1 = DataRangeTracker.Range.access$100((DataRangeTracker.Range)this.mDownloadDataList.get(0)) + 1L;
      while (i < j)
      {
        long l2 = DataRangeTracker.Range.access$200((DataRangeTracker.Range)this.mDownloadDataList.get(i));
        if (paramLong < l2) {
          return l1;
        }
        l1 = DataRangeTracker.Range.access$100((DataRangeTracker.Range)this.mDownloadDataList.get(i)) + 1L;
        if (paramLong <= DataRangeTracker.Range.access$100((DataRangeTracker.Range)this.mDownloadDataList.get(i)))
        {
          paramLong = DataRangeTracker.Range.access$100((DataRangeTracker.Range)this.mDownloadDataList.get(i));
          return paramLong + 1L;
        }
        i += 1;
      }
      paramLong = DataRangeTracker.Range.access$100((DataRangeTracker.Range)this.mDownloadDataList.get(this.mDownloadDataList.size() - 1));
      return paramLong + 1L;
    }
    finally
    {
      unlockRead();
    }
  }
  
  public long getContinuousEnd()
  {
    lockRead();
    try
    {
      int i = this.mDownloadDataList.size();
      if (i == 0) {
        return -1L;
      }
      long l = DataRangeTracker.Range.access$100((DataRangeTracker.Range)this.mDownloadDataList.get(0));
      return l;
    }
    finally
    {
      unlockRead();
    }
  }
  
  List<DataRangeTracker.Range> getEmptyContentPairList(long paramLong)
  {
    ArrayList localArrayList2 = new ArrayList();
    long l = 0L;
    synchronized (this.mDownloadDataList)
    {
      Iterator localIterator = this.mDownloadDataList.iterator();
      while (localIterator.hasNext())
      {
        DataRangeTracker.Range localRange = (DataRangeTracker.Range)localIterator.next();
        if (l < DataRangeTracker.Range.access$200(localRange)) {
          localArrayList2.add(new DataRangeTracker.Range(l, DataRangeTracker.Range.access$200(localRange) - 1L, null));
        }
        l = DataRangeTracker.Range.access$100(localRange) + 1L;
      }
      if (l < paramLong) {
        localArrayList2.add(new DataRangeTracker.Range(l, paramLong - 1L, null));
      }
      return localArrayList2;
    }
  }
  
  public boolean isCached(long paramLong, int paramInt)
  {
    boolean bool = false;
    lockRead();
    try
    {
      long l1 = findStart(paramLong);
      long l2 = findStart(paramInt + paramLong);
      long l3 = findEnd(paramLong);
      long l4 = findEnd(paramInt + paramLong);
      if ((l1 != l2) || (l3 != l4)) {
        return false;
      }
      if (l3 == -1L) {
        return false;
      }
      if (paramInt + paramLong <= l1) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      unlockRead();
    }
  }
  
  public boolean lock(long paramLong1, int paramInt, long paramLong2)
  {
    for (;;)
    {
      try
      {
        Logger.i("DataRangeTracker", "[lock] position = [" + paramLong1 + "]. size = [" + paramInt + "]. timeout = [" + paramLong2 + "].");
        this.waitingPosition = paramLong1;
        this.waitingSize = paramInt;
        i = (int)(paramLong2 / 2000L);
        paramInt = i;
        if (i > 0) {
          break label131;
        }
        paramInt = 1;
      }
      finally {}
      if (i < paramInt)
      {
        wait(2000L);
        boolean bool = isCached(this.waitingPosition, this.waitingSize);
        if (!bool)
        {
          i += 1;
          continue;
        }
      }
      return true;
      label131:
      int i = 0;
    }
  }
  
  /* Error */
  public String print()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 39	com/tencent/qqmusic/mediaplayer/DataRangeTracker:lock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   6: invokevirtual 52	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   9: invokevirtual 56	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   12: new 145	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   19: astore_2
    //   20: iconst_0
    //   21: istore_1
    //   22: iload_1
    //   23: aload_0
    //   24: getfield 34	com/tencent/qqmusic/mediaplayer/DataRangeTracker:mDownloadDataList	Ljava/util/ArrayList;
    //   27: invokevirtual 116	java/util/ArrayList:size	()I
    //   30: if_icmpge +29 -> 59
    //   33: aload_2
    //   34: aload_0
    //   35: getfield 34	com/tencent/qqmusic/mediaplayer/DataRangeTracker:mDownloadDataList	Ljava/util/ArrayList;
    //   38: iload_1
    //   39: invokevirtual 120	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   42: checkcast 6	com/tencent/qqmusic/mediaplayer/DataRangeTracker$Range
    //   45: invokevirtual 221	com/tencent/qqmusic/mediaplayer/DataRangeTracker$Range:toString	()Ljava/lang/String;
    //   48: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: iload_1
    //   53: iconst_1
    //   54: iadd
    //   55: istore_1
    //   56: goto -34 -> 22
    //   59: aload_2
    //   60: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: astore_2
    //   64: aload_0
    //   65: getfield 39	com/tencent/qqmusic/mediaplayer/DataRangeTracker:lock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   68: invokevirtual 52	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   71: invokevirtual 71	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_2
    //   77: areturn
    //   78: astore_2
    //   79: aload_0
    //   80: getfield 39	com/tencent/qqmusic/mediaplayer/DataRangeTracker:lock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   83: invokevirtual 52	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   86: invokevirtual 71	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   89: aload_2
    //   90: athrow
    //   91: astore_2
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_2
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	DataRangeTracker
    //   21	35	1	i	int
    //   19	58	2	localObject1	Object
    //   78	12	2	localObject2	Object
    //   91	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   12	20	78	finally
    //   22	52	78	finally
    //   59	64	78	finally
    //   2	12	91	finally
    //   64	74	91	finally
    //   79	91	91	finally
  }
  
  public void unblock()
  {
    Logger.i("DataRangeTracker", "[unblock]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.DataRangeTracker
 * JD-Core Version:    0.7.0.1
 */