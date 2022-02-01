package com.tencent.wcdb.repair;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.CancellationSignal.OnCancelListener;

public class RecoverKit
  implements CancellationSignal.OnCancelListener
{
  public static final int RESULT_CANCELED = 1;
  public static final int RESULT_FAILED = -1;
  public static final int RESULT_OK = 0;
  static final String TAG = "WCDB.DBBackup";
  private SQLiteDatabase mDB;
  private int mFailedCount;
  private String mLastError;
  private long mNativePtr;
  private int mSuccessCount;
  
  public RecoverKit(SQLiteDatabase paramSQLiteDatabase, String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(3340);
    this.mDB = paramSQLiteDatabase;
    this.mLastError = null;
    this.mNativePtr = nativeInit(paramString, paramArrayOfByte);
    if (this.mNativePtr == 0L)
    {
      paramSQLiteDatabase = new SQLiteException("Failed initialize recover context.");
      AppMethodBeat.o(3340);
      throw paramSQLiteDatabase;
    }
    AppMethodBeat.o(3340);
  }
  
  private static native void nativeCancel(long paramLong);
  
  private static native int nativeFailureCount(long paramLong);
  
  private static native void nativeFinish(long paramLong);
  
  private static native long nativeInit(String paramString, byte[] paramArrayOfByte);
  
  private static native String nativeLastError(long paramLong);
  
  private static native int nativeRun(long paramLong1, long paramLong2, boolean paramBoolean);
  
  private static native int nativeSuccessCount(long paramLong);
  
  public int failureCount()
  {
    return this.mFailedCount;
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(3345);
    release();
    super.finalize();
    AppMethodBeat.o(3345);
  }
  
  public String lastError()
  {
    return this.mLastError;
  }
  
  public void onCancel()
  {
    AppMethodBeat.i(3343);
    if (this.mNativePtr != 0L) {
      nativeCancel(this.mNativePtr);
    }
    AppMethodBeat.o(3343);
  }
  
  public void release()
  {
    AppMethodBeat.i(3344);
    if (this.mNativePtr != 0L)
    {
      nativeFinish(this.mNativePtr);
      this.mNativePtr = 0L;
    }
    AppMethodBeat.o(3344);
  }
  
  public int run(boolean paramBoolean)
  {
    AppMethodBeat.i(3341);
    if (this.mNativePtr == 0L)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("RecoverKit not initialized.");
      AppMethodBeat.o(3341);
      throw localIllegalStateException;
    }
    long l = this.mDB.acquireNativeConnectionHandle("recover", false, false);
    int i = nativeRun(this.mNativePtr, l, paramBoolean);
    this.mDB.releaseNativeConnection(l, null);
    this.mSuccessCount = nativeSuccessCount(this.mNativePtr);
    this.mFailedCount = nativeFailureCount(this.mNativePtr);
    this.mLastError = nativeLastError(this.mNativePtr);
    nativeFinish(this.mNativePtr);
    this.mNativePtr = 0L;
    AppMethodBeat.o(3341);
    return i;
  }
  
  public int run(boolean paramBoolean, CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(3342);
    if (paramCancellationSignal.isCanceled())
    {
      AppMethodBeat.o(3342);
      return 1;
    }
    paramCancellationSignal.setOnCancelListener(this);
    int i = run(paramBoolean);
    paramCancellationSignal.setOnCancelListener(null);
    AppMethodBeat.o(3342);
    return i;
  }
  
  public int successCount()
  {
    return this.mSuccessCount;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wcdb.repair.RecoverKit
 * JD-Core Version:    0.7.0.1
 */