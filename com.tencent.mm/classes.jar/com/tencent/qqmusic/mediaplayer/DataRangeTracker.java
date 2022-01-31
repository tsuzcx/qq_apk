package com.tencent.qqmusic.mediaplayer;

import com.tencent.matrix.trace.core.AppMethodBeat;
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
  private final ReentrantReadWriteLock lock;
  private Comparator<DataRangeTracker.Range> mComparator;
  private final ArrayList<DataRangeTracker.Range> mDownloadDataList;
  private long mFileTotalSize;
  private long waitingPosition;
  private int waitingSize;
  
  public DataRangeTracker()
  {
    AppMethodBeat.i(104672);
    this.mDownloadDataList = new ArrayList();
    this.lock = new ReentrantReadWriteLock();
    this.mFileTotalSize = 0L;
    this.mComparator = new DataRangeTracker.1(this);
    AppMethodBeat.o(104672);
  }
  
  private void lockRead()
  {
    AppMethodBeat.i(104683);
    this.lock.readLock().lock();
    AppMethodBeat.o(104683);
  }
  
  private void unlock()
  {
    try
    {
      AppMethodBeat.i(104685);
      Logger.i("DataRangeTracker", "[unlock].");
      notifyAll();
      AppMethodBeat.o(104685);
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
    AppMethodBeat.i(104684);
    this.lock.readLock().unlock();
    AppMethodBeat.o(104684);
  }
  
  public void abandonLock()
  {
    AppMethodBeat.i(104681);
    Logger.i("DataRangeTracker", "[abandonLock]");
    unblock();
    unlock();
    AppMethodBeat.o(104681);
  }
  
  public void addRange(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(104673);
    if (paramLong1 > paramLong2)
    {
      Logger.e("DataRangeTracker", "[addRange] illegal arguments! beginPos(%s) > endPos(%s)", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      AppMethodBeat.o(104673);
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
          break label306;
        }
        i = 1;
        if (i > j) {
          break label289;
        }
        DataRangeTracker.Range localRange2 = (DataRangeTracker.Range)this.mDownloadDataList.get(i);
        if (DataRangeTracker.Range.access$100(localRange1) + 1L < DataRangeTracker.Range.access$200(localRange2))
        {
          localArrayList.add(new DataRangeTracker.Range(DataRangeTracker.Range.access$200(localRange1), DataRangeTracker.Range.access$100(localRange1), null));
          localRange1 = new DataRangeTracker.Range(DataRangeTracker.Range.access$200(localRange2), DataRangeTracker.Range.access$100(localRange2), null);
          if (i < j) {
            break label443;
          }
          localArrayList.add(localRange1);
          break label443;
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
        AppMethodBeat.o(104673);
      }
      continue;
      label289:
      this.mDownloadDataList.clear();
      this.mDownloadDataList.addAll(localArrayList);
      label306:
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
        finally
        {
          AppMethodBeat.o(104673);
        }
      }
      AppMethodBeat.o(104673);
      return;
      label443:
      i += 1;
    }
  }
  
  public void block()
  {
    AppMethodBeat.i(104679);
    Logger.i("DataRangeTracker", "[block]");
    AppMethodBeat.o(104679);
  }
  
  public long findEnd(long paramLong)
  {
    AppMethodBeat.i(104675);
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
      AppMethodBeat.o(104675);
    }
  }
  
  public long findStart(long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(104674);
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
      AppMethodBeat.o(104674);
    }
  }
  
  public long getContinuousEnd()
  {
    AppMethodBeat.i(104677);
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
      AppMethodBeat.o(104677);
    }
  }
  
  List<DataRangeTracker.Range> getEmptyContentPairList(long paramLong)
  {
    AppMethodBeat.i(104686);
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
        l = 1L + DataRangeTracker.Range.access$100(localRange);
      }
      if (l < paramLong) {
        localArrayList2.add(new DataRangeTracker.Range(l, paramLong - 1L, null));
      }
      AppMethodBeat.o(104686);
      return localArrayList2;
    }
  }
  
  public boolean isCached(long paramLong, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(104676);
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
      AppMethodBeat.o(104676);
    }
  }
  
  public boolean lock(long paramLong1, int paramInt, long paramLong2)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(104678);
        Logger.i("DataRangeTracker", "[lock] position = [" + paramLong1 + "]. size = [" + paramInt + "]. timeout = [" + paramLong2 + "].");
        this.waitingPosition = paramLong1;
        this.waitingSize = paramInt;
        i = (int)(paramLong2 / 2000L);
        paramInt = i;
        if (i > 0) {
          break label137;
        }
        paramInt = 1;
      }
      finally {}
      if (i < paramInt)
      {
        wait(2000L);
        if (!isCached(this.waitingPosition, this.waitingSize))
        {
          i += 1;
          continue;
        }
      }
      AppMethodBeat.o(104678);
      return true;
      label137:
      int i = 0;
    }
  }
  
  /* Error */
  public String print()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 244
    //   4: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 47	com/tencent/qqmusic/mediaplayer/DataRangeTracker:lock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   11: invokevirtual 66	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   14: invokevirtual 70	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   17: new 162	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   24: astore_2
    //   25: iconst_0
    //   26: istore_1
    //   27: iload_1
    //   28: aload_0
    //   29: getfield 42	com/tencent/qqmusic/mediaplayer/DataRangeTracker:mDownloadDataList	Ljava/util/ArrayList;
    //   32: invokevirtual 133	java/util/ArrayList:size	()I
    //   35: if_icmpge +29 -> 64
    //   38: aload_2
    //   39: aload_0
    //   40: getfield 42	com/tencent/qqmusic/mediaplayer/DataRangeTracker:mDownloadDataList	Ljava/util/ArrayList;
    //   43: iload_1
    //   44: invokevirtual 137	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   47: checkcast 6	com/tencent/qqmusic/mediaplayer/DataRangeTracker$Range
    //   50: invokevirtual 246	com/tencent/qqmusic/mediaplayer/DataRangeTracker$Range:toString	()Ljava/lang/String;
    //   53: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: iload_1
    //   58: iconst_1
    //   59: iadd
    //   60: istore_1
    //   61: goto -34 -> 27
    //   64: aload_2
    //   65: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: astore_2
    //   69: aload_0
    //   70: getfield 47	com/tencent/qqmusic/mediaplayer/DataRangeTracker:lock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   73: invokevirtual 66	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   76: invokevirtual 86	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   79: ldc 244
    //   81: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_2
    //   87: areturn
    //   88: astore_2
    //   89: aload_0
    //   90: getfield 47	com/tencent/qqmusic/mediaplayer/DataRangeTracker:lock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   93: invokevirtual 66	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   96: invokevirtual 86	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   99: ldc 244
    //   101: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: aload_2
    //   105: athrow
    //   106: astore_2
    //   107: aload_0
    //   108: monitorexit
    //   109: aload_2
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	DataRangeTracker
    //   26	35	1	i	int
    //   24	63	2	localObject1	Object
    //   88	17	2	localObject2	Object
    //   106	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   17	25	88	finally
    //   27	57	88	finally
    //   64	69	88	finally
    //   2	17	106	finally
    //   69	84	106	finally
    //   89	106	106	finally
  }
  
  public void setFileTotalSize(long paramLong)
  {
    this.mFileTotalSize = paramLong;
  }
  
  public void unblock()
  {
    AppMethodBeat.i(104680);
    Logger.i("DataRangeTracker", "[unblock]");
    AppMethodBeat.o(104680);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.DataRangeTracker
 * JD-Core Version:    0.7.0.1
 */