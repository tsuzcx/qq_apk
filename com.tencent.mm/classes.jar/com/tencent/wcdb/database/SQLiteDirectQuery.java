package com.tencent.wcdb.database;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;

public class SQLiteDirectQuery
  extends SQLiteProgram
{
  private static final int[] SQLITE_TYPE_MAPPING = { 3, 1, 2, 3, 4, 0 };
  private static final String TAG = "WCDB.SQLiteDirectQuery";
  private final CancellationSignal mCancellationSignal;
  
  public SQLiteDirectQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    super(paramSQLiteDatabase, paramString, paramArrayOfObject, paramCancellationSignal);
    this.mCancellationSignal = paramCancellationSignal;
  }
  
  private static native byte[] nativeGetBlob(long paramLong, int paramInt);
  
  private static native double nativeGetDouble(long paramLong, int paramInt);
  
  private static native long nativeGetLong(long paramLong, int paramInt);
  
  private static native String nativeGetString(long paramLong, int paramInt);
  
  private static native int nativeGetType(long paramLong, int paramInt);
  
  private static native int nativeStep(long paramLong, int paramInt);
  
  public byte[] getBlob(int paramInt)
  {
    AppMethodBeat.i(12576);
    byte[] arrayOfByte = nativeGetBlob(this.mPreparedStatement.getPtr(), paramInt);
    AppMethodBeat.o(12576);
    return arrayOfByte;
  }
  
  public double getDouble(int paramInt)
  {
    AppMethodBeat.i(12574);
    double d = nativeGetDouble(this.mPreparedStatement.getPtr(), paramInt);
    AppMethodBeat.o(12574);
    return d;
  }
  
  public long getLong(int paramInt)
  {
    AppMethodBeat.i(12573);
    long l = nativeGetLong(this.mPreparedStatement.getPtr(), paramInt);
    AppMethodBeat.o(12573);
    return l;
  }
  
  public String getString(int paramInt)
  {
    AppMethodBeat.i(12575);
    String str = nativeGetString(this.mPreparedStatement.getPtr(), paramInt);
    AppMethodBeat.o(12575);
    return str;
  }
  
  public int getType(int paramInt)
  {
    AppMethodBeat.i(12577);
    paramInt = SQLITE_TYPE_MAPPING[nativeGetType(this.mPreparedStatement.getPtr(), paramInt)];
    AppMethodBeat.o(12577);
    return paramInt;
  }
  
  protected void onAllReferencesReleased()
  {
    AppMethodBeat.i(12580);
    try
    {
      if (this.mPreparedStatement != null)
      {
        this.mPreparedStatement.detachCancellationSignal(this.mCancellationSignal);
        this.mPreparedStatement.endOperation(null);
      }
      super.onAllReferencesReleased();
      AppMethodBeat.o(12580);
      return;
    }
    finally
    {
      AppMethodBeat.o(12580);
    }
  }
  
  public void reset(boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(12579);
      if (this.mPreparedStatement != null)
      {
        this.mPreparedStatement.reset(false);
        if (paramBoolean)
        {
          this.mPreparedStatement.detachCancellationSignal(this.mCancellationSignal);
          this.mPreparedStatement.endOperation(null);
          releasePreparedStatement();
        }
      }
      AppMethodBeat.o(12579);
      return;
    }
    finally {}
  }
  
  public int step(int paramInt)
  {
    AppMethodBeat.i(12578);
    try
    {
      if (acquirePreparedStatement(false))
      {
        this.mPreparedStatement.beginOperation("directQuery", getBindArgs());
        this.mPreparedStatement.attachCancellationSignal(this.mCancellationSignal);
      }
      paramInt = nativeStep(this.mPreparedStatement.getPtr(), paramInt);
      AppMethodBeat.o(12578);
      return paramInt;
    }
    catch (RuntimeException localRuntimeException)
    {
      if ((localRuntimeException instanceof SQLiteException))
      {
        Log.e("WCDB.SQLiteDirectQuery", "Got exception on stepping: " + localRuntimeException.getMessage() + ", SQL: " + getSql());
        checkCorruption((SQLiteException)localRuntimeException);
      }
      if (this.mPreparedStatement != null)
      {
        this.mPreparedStatement.detachCancellationSignal(this.mCancellationSignal);
        this.mPreparedStatement.failOperation(localRuntimeException);
      }
      releasePreparedStatement();
      AppMethodBeat.o(12578);
      throw localRuntimeException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteDirectQuery
 * JD-Core Version:    0.7.0.1
 */