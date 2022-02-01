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
  
  public void addRange(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(76726);
    if (paramLong1 > paramLong2)
    {
      Logger.e("DataRangeTracker", "[addRange] illegal arguments! beginPos(%s) > endPos(%s)", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      AppMethodBeat.o(76726);
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
          break label306;
        }
        i = 1;
        if (i > j) {
          break label289;
        }
        Range localRange2 = (Range)this.mDownloadDataList.get(i);
        if (localRange1.second + 1L < localRange2.first)
        {
          localArrayList.add(new Range(localRange1.first, localRange1.second, null));
          localRange1 = new Range(localRange2.first, localRange2.second, null);
          if (i < j) {
            break label439;
          }
          localArrayList.add(localRange1);
          break label439;
        }
        if (localRange1.second > localRange2.second)
        {
          paramLong1 = localRange1.second;
          localRange1 = new Range(localRange1.first, paramLong1, null);
          continue;
        }
        paramLong1 = localRange2.second;
      }
      finally
      {
        this.lock.writeLock().unlock();
        AppMethodBeat.o(76726);
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
          this.waitingPosition = 0L;
          this.waitingSize = 0;
          return;
        }
        finally
        {
          AppMethodBeat.o(76726);
        }
      }
      AppMethodBeat.o(76726);
      return;
      label439:
      i += 1;
    }
  }
  
  public void block()
  {
    AppMethodBeat.i(76733);
    Logger.i("DataRangeTracker", "[block]");
    AppMethodBeat.o(76733);
  }
  
  public long findEnd(long paramLong)
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
  
  List<Range> getEmptyContentPairList(long paramLong)
  {
    AppMethodBeat.i(76740);
    ArrayList localArrayList2 = new ArrayList();
    long l = 0L;
    synchronized (this.mDownloadDataList)
    {
      Iterator localIterator = this.mDownloadDataList.iterator();
      while (localIterator.hasNext())
      {
        Range localRange = (Range)localIterator.next();
        if (l < localRange.first) {
          localArrayList2.add(new Range(l, localRange.first - 1L, null));
        }
        l = 1L + localRange.second;
      }
      if (l < paramLong) {
        localArrayList2.add(new Range(l, paramLong - 1L, null));
      }
      AppMethodBeat.o(76740);
      return localArrayList2;
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
  
  public boolean lock(long paramLong1, int paramInt, long paramLong2)
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(76732);
        Logger.i("DataRangeTracker", "[lock] position = [" + paramLong1 + "]. size = [" + paramInt + "]. timeout = [" + paramLong2 + "].");
        this.waitingPosition = paramLong1;
        this.waitingSize = paramInt;
        j = (int)(paramLong2 / 1000L);
        i = j;
        if (j > 0) {
          break label200;
        }
        i = 1;
      }
      finally {}
      if (j < i)
      {
        wait(1000L);
        if (!isCached(this.waitingPosition, this.waitingSize))
        {
          Logger.i("DataRangeTracker", "continue [lock] position = [" + paramLong1 + "]. size = [" + paramInt + "]. totalSize = [" + this.mFileTotalSize + "]. findStart(position) = [" + findStart(paramLong1) + "].");
          j += 1;
          continue;
        }
      }
      AppMethodBeat.o(76732);
      return true;
      label200:
      int j = 0;
    }
  }
  
  /* Error */
  public String print()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 253
    //   4: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 50	com/tencent/qqmusic/mediaplayer/DataRangeTracker:lock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   11: invokevirtual 67	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   14: invokevirtual 71	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   17: new 163	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   24: astore_2
    //   25: iconst_0
    //   26: istore_1
    //   27: iload_1
    //   28: aload_0
    //   29: getfield 45	com/tencent/qqmusic/mediaplayer/DataRangeTracker:mDownloadDataList	Ljava/util/ArrayList;
    //   32: invokevirtual 134	java/util/ArrayList:size	()I
    //   35: if_icmpge +29 -> 64
    //   38: aload_2
    //   39: aload_0
    //   40: getfield 45	com/tencent/qqmusic/mediaplayer/DataRangeTracker:mDownloadDataList	Ljava/util/ArrayList;
    //   43: iload_1
    //   44: invokevirtual 138	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   47: checkcast 8	com/tencent/qqmusic/mediaplayer/DataRangeTracker$Range
    //   50: invokevirtual 255	com/tencent/qqmusic/mediaplayer/DataRangeTracker$Range:toString	()Ljava/lang/String;
    //   53: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: iload_1
    //   58: iconst_1
    //   59: iadd
    //   60: istore_1
    //   61: goto -34 -> 27
    //   64: aload_2
    //   65: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: astore_2
    //   69: aload_0
    //   70: getfield 50	com/tencent/qqmusic/mediaplayer/DataRangeTracker:lock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   73: invokevirtual 67	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   76: invokevirtual 87	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   79: ldc 253
    //   81: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_2
    //   87: areturn
    //   88: astore_2
    //   89: aload_0
    //   90: getfield 50	com/tencent/qqmusic/mediaplayer/DataRangeTracker:lock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   93: invokevirtual 67	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   96: invokevirtual 87	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   99: ldc 253
    //   101: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(76734);
    Logger.i("DataRangeTracker", "[unblock]");
    AppMethodBeat.o(76734);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.DataRangeTracker
 * JD-Core Version:    0.7.0.1
 */