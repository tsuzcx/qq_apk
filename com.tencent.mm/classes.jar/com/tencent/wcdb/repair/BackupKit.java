package com.tencent.wcdb.repair;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.CancellationSignal.OnCancelListener;
import java.util.Arrays;

public class BackupKit
  implements CancellationSignal.OnCancelListener
{
  public static final int FLAG_FIX_CORRUPTION = 4;
  public static final int FLAG_INCREMENTAL = 16;
  public static final int FLAG_NO_CIPHER = 1;
  public static final int FLAG_NO_COMPRESS = 2;
  public static final int FLAG_NO_CREATE_TABLE = 8;
  public static final int RESULT_CANCELED = 1;
  public static final int RESULT_FAILED = -1;
  public static final int RESULT_OK = 0;
  static final String TAG = "WCDB.DBBackup";
  private SQLiteDatabase mDB;
  private String mLastError;
  private long mNativePtr;
  private int mStatementCount;
  private String[] mTableDesc;
  
  public BackupKit(SQLiteDatabase paramSQLiteDatabase, String paramString, byte[] paramArrayOfByte, int paramInt, String[] paramArrayOfString)
  {
    AppMethodBeat.i(3328);
    this.mDB = paramSQLiteDatabase;
    this.mLastError = null;
    paramSQLiteDatabase = localObject;
    if (paramArrayOfString != null) {
      paramSQLiteDatabase = (String[])Arrays.copyOf(paramArrayOfString, paramArrayOfString.length);
    }
    this.mTableDesc = paramSQLiteDatabase;
    if (paramString == null)
    {
      paramSQLiteDatabase = new IllegalArgumentException();
      AppMethodBeat.o(3328);
      throw paramSQLiteDatabase;
    }
    this.mNativePtr = nativeInit(paramString, paramArrayOfByte, paramInt);
    if (this.mNativePtr == 0L)
    {
      paramSQLiteDatabase = new SQLiteException("Failed initialize backup context.");
      AppMethodBeat.o(3328);
      throw paramSQLiteDatabase;
    }
    AppMethodBeat.o(3328);
  }
  
  private static native void nativeCancel(long paramLong);
  
  private static native void nativeFinish(long paramLong);
  
  private static native long nativeInit(String paramString, byte[] paramArrayOfByte, int paramInt);
  
  private static native String nativeLastError(long paramLong);
  
  private static native int nativeRun(long paramLong1, long paramLong2, String[] paramArrayOfString);
  
  private static native int nativeStatementCount(long paramLong);
  
  protected void finalize()
  {
    AppMethodBeat.i(3333);
    release();
    super.finalize();
    AppMethodBeat.o(3333);
  }
  
  public String lastError()
  {
    return this.mLastError;
  }
  
  public void onCancel()
  {
    AppMethodBeat.i(3331);
    if (this.mNativePtr != 0L) {
      nativeCancel(this.mNativePtr);
    }
    AppMethodBeat.o(3331);
  }
  
  public void release()
  {
    AppMethodBeat.i(3332);
    if (this.mNativePtr != 0L)
    {
      nativeFinish(this.mNativePtr);
      this.mNativePtr = 0L;
    }
    AppMethodBeat.o(3332);
  }
  
  public int run()
  {
    AppMethodBeat.i(3329);
    if (this.mNativePtr == 0L)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("BackupKit not initialized.");
      AppMethodBeat.o(3329);
      throw localIllegalStateException;
    }
    long l = this.mDB.acquireNativeConnectionHandle("backup", false, false);
    int i = nativeRun(this.mNativePtr, l, this.mTableDesc);
    this.mDB.releaseNativeConnection(l, null);
    this.mStatementCount = nativeStatementCount(this.mNativePtr);
    this.mLastError = nativeLastError(this.mNativePtr);
    nativeFinish(this.mNativePtr);
    this.mNativePtr = 0L;
    AppMethodBeat.o(3329);
    return i;
  }
  
  public int run(CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(3330);
    if (paramCancellationSignal.isCanceled())
    {
      AppMethodBeat.o(3330);
      return 1;
    }
    paramCancellationSignal.setOnCancelListener(this);
    int i = run();
    paramCancellationSignal.setOnCancelListener(null);
    AppMethodBeat.o(3330);
    return i;
  }
  
  public int statementCount()
  {
    return this.mStatementCount;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wcdb.repair.BackupKit
 * JD-Core Version:    0.7.0.1
 */