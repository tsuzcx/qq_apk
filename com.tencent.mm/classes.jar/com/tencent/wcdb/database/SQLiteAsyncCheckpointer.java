package com.tencent.wcdb.database;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;

public class SQLiteAsyncCheckpointer
  implements Handler.Callback, SQLiteCheckpointListener
{
  private static final int DEFAULT_BLOCKING_THRESHOLD = 300;
  private static final int DEFAULT_THRESHOLD = 100;
  private static HandlerThread gDefaultThread;
  private static final Object gDefaultThreadLock;
  private static int gDefaultThreadRefCount;
  private int mBlockingThreshold;
  private Handler mHandler;
  private int mLastSyncMode;
  private Looper mLooper;
  private final HashSet<Pair<SQLiteDatabase, String>> mPendingCheckpoints;
  private int mThreshold;
  private boolean mUseDefaultLooper;
  
  static
  {
    AppMethodBeat.i(12238);
    gDefaultThreadLock = new Object();
    gDefaultThreadRefCount = 0;
    AppMethodBeat.o(12238);
  }
  
  public SQLiteAsyncCheckpointer()
  {
    this(null, 100, 300);
  }
  
  public SQLiteAsyncCheckpointer(Looper paramLooper)
  {
    this(paramLooper, 100, 300);
  }
  
  public SQLiteAsyncCheckpointer(Looper paramLooper, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12231);
    this.mLooper = paramLooper;
    this.mThreshold = paramInt1;
    this.mBlockingThreshold = paramInt2;
    this.mPendingCheckpoints = new HashSet();
    AppMethodBeat.o(12231);
  }
  
  private static Looper acquireDefaultLooper()
  {
    AppMethodBeat.i(12236);
    synchronized (gDefaultThreadLock)
    {
      int i = gDefaultThreadRefCount;
      gDefaultThreadRefCount = i + 1;
      if (i != 0) {
        break label80;
      }
      if (gDefaultThread != null)
      {
        AssertionError localAssertionError = new AssertionError("gDefaultThread == null");
        AppMethodBeat.o(12236);
        throw localAssertionError;
      }
    }
    Object localObject3 = new HandlerThread("WCDB.AsyncCheckpointer", 4);
    gDefaultThread = (HandlerThread)localObject3;
    ((HandlerThread)localObject3).start();
    label80:
    localObject3 = gDefaultThread.getLooper();
    AppMethodBeat.o(12236);
    return localObject3;
  }
  
  private static void releaseDefaultLooper()
  {
    AppMethodBeat.i(12237);
    synchronized (gDefaultThreadLock)
    {
      int i = gDefaultThreadRefCount - 1;
      gDefaultThreadRefCount = i;
      if (i > 0) {
        break label72;
      }
      if (gDefaultThreadRefCount < 0)
      {
        AssertionError localAssertionError = new AssertionError("gDefaultThreadRefCount == 0");
        AppMethodBeat.o(12237);
        throw localAssertionError;
      }
    }
    gDefaultThread.quit();
    gDefaultThread = null;
    label72:
    AppMethodBeat.o(12237);
  }
  
  public boolean handleMessage(Message arg1)
  {
    AppMethodBeat.i(12235);
    Object localObject1 = (Pair)???.obj;
    SQLiteDatabase localSQLiteDatabase = (SQLiteDatabase)((Pair)localObject1).first;
    String str = (String)((Pair)localObject1).second;
    boolean bool;
    if (???.arg1 != 0) {
      bool = true;
    }
    try
    {
      long l = SystemClock.uptimeMillis();
      ??? = localSQLiteDatabase.walCheckpoint(str, bool);
      onCheckpointResult(localSQLiteDatabase, ((Integer)???.first).intValue(), ((Integer)???.second).intValue(), SystemClock.uptimeMillis() - l);
      localSQLiteDatabase.releaseReference();
      synchronized (this.mPendingCheckpoints)
      {
        if (!this.mPendingCheckpoints.remove(localObject1))
        {
          localObject1 = new AssertionError("mPendingCheckpoints.remove(p)");
          AppMethodBeat.o(12235);
          throw ((Throwable)localObject1);
        }
      }
      return true;
    }
    finally
    {
      localSQLiteDatabase.releaseReference();
      AppMethodBeat.o(12235);
    }
  }
  
  public void onAttach(SQLiteDatabase paramSQLiteDatabase)
  {
    AppMethodBeat.i(12232);
    if (this.mLooper == null)
    {
      this.mLooper = acquireDefaultLooper();
      this.mUseDefaultLooper = true;
    }
    this.mHandler = new Handler(this.mLooper, this);
    this.mLastSyncMode = paramSQLiteDatabase.getSynchronousMode();
    paramSQLiteDatabase.setSynchronousMode(1);
    AppMethodBeat.o(12232);
  }
  
  protected void onCheckpointResult(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2, long paramLong) {}
  
  public void onDetach(SQLiteDatabase paramSQLiteDatabase)
  {
    AppMethodBeat.i(12234);
    paramSQLiteDatabase.setSynchronousMode(this.mLastSyncMode);
    this.mHandler = null;
    if (this.mUseDefaultLooper)
    {
      this.mLooper = null;
      releaseDefaultLooper();
      this.mUseDefaultLooper = false;
    }
    AppMethodBeat.o(12234);
  }
  
  public void onWALCommit(SQLiteDatabase paramSQLiteDatabase, String paramString, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(12233);
    if (paramInt < this.mThreshold)
    {
      AppMethodBeat.o(12233);
      return;
    }
    if (paramInt >= this.mBlockingThreshold) {
      paramInt = 1;
    }
    for (;;)
    {
      paramString = new Pair(paramSQLiteDatabase, paramString);
      synchronized (this.mPendingCheckpoints)
      {
        boolean bool = this.mPendingCheckpoints.add(paramString);
        if (!bool)
        {
          AppMethodBeat.o(12233);
          return;
          paramInt = 0;
        }
      }
    }
    paramSQLiteDatabase.acquireReference();
    paramSQLiteDatabase = this.mHandler;
    if (paramInt != 0) {}
    for (paramInt = i;; paramInt = 0)
    {
      paramSQLiteDatabase = paramSQLiteDatabase.obtainMessage(0, paramInt, 0, paramString);
      this.mHandler.sendMessage(paramSQLiteDatabase);
      AppMethodBeat.o(12233);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteAsyncCheckpointer
 * JD-Core Version:    0.7.0.1
 */