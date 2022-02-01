package com.tencent.wcdb.database;

import android.database.sqlite.SQLiteTransactionListener;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.CursorWindow;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.support.CancellationSignal;

public final class SQLiteSession
{
  public static final int TRANSACTION_MODE_DEFERRED = 0;
  public static final int TRANSACTION_MODE_EXCLUSIVE = 2;
  public static final int TRANSACTION_MODE_IMMEDIATE = 1;
  private SQLiteConnection mConnection;
  private int mConnectionFlags;
  private final SQLiteConnectionPool mConnectionPool;
  private int mConnectionUseCount;
  private Transaction mTransactionPool;
  private Transaction mTransactionStack;
  
  static
  {
    AppMethodBeat.i(3314);
    if (!SQLiteSession.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(3314);
      return;
    }
  }
  
  public SQLiteSession(SQLiteConnectionPool paramSQLiteConnectionPool)
  {
    AppMethodBeat.i(3287);
    if (paramSQLiteConnectionPool == null)
    {
      paramSQLiteConnectionPool = new IllegalArgumentException("connectionPool must not be null");
      AppMethodBeat.o(3287);
      throw paramSQLiteConnectionPool;
    }
    this.mConnectionPool = paramSQLiteConnectionPool;
    AppMethodBeat.o(3287);
  }
  
  private void acquireConnection(String paramString, int paramInt, boolean paramBoolean, CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(3304);
    if (this.mConnection == null)
    {
      this.mConnection = this.mConnectionPool.acquireConnection(paramString, paramInt, paramCancellationSignal);
      this.mConnectionFlags = paramInt;
      this.mConnection.setAcquisitionState(true, paramBoolean);
    }
    this.mConnectionUseCount += 1;
    AppMethodBeat.o(3304);
  }
  
  private void beginTransactionUnchecked(int paramInt1, SQLiteTransactionListener paramSQLiteTransactionListener, int paramInt2, CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(3289);
    if (paramCancellationSignal != null) {
      paramCancellationSignal.throwIfCanceled();
    }
    if (this.mTransactionStack == null) {
      acquireConnection(null, paramInt2, true, paramCancellationSignal);
    }
    for (;;)
    {
      try
      {
        if (this.mTransactionStack == null) {}
        switch (paramInt1)
        {
        case 1: 
          this.mConnection.execute("BEGIN;", null, paramCancellationSignal);
          if (paramSQLiteTransactionListener == null) {}
          break;
        }
      }
      finally
      {
        if (this.mTransactionStack == null) {
          releaseConnection();
        }
        AppMethodBeat.o(3289);
      }
      try
      {
        paramSQLiteTransactionListener.onBegin();
        paramSQLiteTransactionListener = obtainTransaction(paramInt1, paramSQLiteTransactionListener);
        paramSQLiteTransactionListener.mParent = this.mTransactionStack;
        this.mTransactionStack = paramSQLiteTransactionListener;
        if (this.mTransactionStack != null) {
          break label202;
        }
        releaseConnection();
        AppMethodBeat.o(3289);
        return;
      }
      catch (RuntimeException paramSQLiteTransactionListener)
      {
        if (this.mTransactionStack != null) {
          break label194;
        }
        this.mConnection.execute("ROLLBACK;", null, paramCancellationSignal);
        AppMethodBeat.o(3289);
        throw paramSQLiteTransactionListener;
      }
      this.mConnection.execute("BEGIN IMMEDIATE;", null, paramCancellationSignal);
      continue;
      this.mConnection.execute("BEGIN EXCLUSIVE;", null, paramCancellationSignal);
      continue;
      label194:
      label202:
      AppMethodBeat.o(3289);
      return;
    }
  }
  
  private void endTransactionUnchecked(CancellationSignal paramCancellationSignal, boolean paramBoolean)
  {
    int j = 0;
    Object localObject = null;
    AppMethodBeat.i(3292);
    if (paramCancellationSignal != null) {
      paramCancellationSignal.throwIfCanceled();
    }
    Transaction localTransaction = this.mTransactionStack;
    int i;
    SQLiteTransactionListener localSQLiteTransactionListener;
    if (((localTransaction.mMarkedSuccessful) || (paramBoolean)) && (!localTransaction.mChildFailed))
    {
      i = 1;
      localSQLiteTransactionListener = localTransaction.mListener;
      if (localSQLiteTransactionListener == null) {
        break label198;
      }
      if (i == 0) {
        break label124;
      }
    }
    label198:
    for (;;)
    {
      try
      {
        localSQLiteTransactionListener.onCommit();
        this.mTransactionStack = localTransaction.mParent;
        recycleTransaction(localTransaction);
        if (this.mTransactionStack != null)
        {
          if (i == 0) {
            this.mTransactionStack.mChildFailed = true;
          }
          if (localObject == null) {
            continue;
          }
          AppMethodBeat.o(3292);
          throw localObject;
          i = 0;
          break;
          label124:
          localSQLiteTransactionListener.onRollback();
          continue;
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        i = j;
        continue;
        if (i != 0) {}
        try
        {
          this.mConnection.execute("COMMIT;", null, paramCancellationSignal);
          releaseConnection();
          continue;
        }
        finally
        {
          releaseConnection();
          AppMethodBeat.o(3292);
        }
        this.mConnection.execute("ROLLBACK;", null, paramCancellationSignal);
        continue;
        AppMethodBeat.o(3292);
        return;
      }
    }
  }
  
  private boolean executeSpecial(String paramString, Object[] paramArrayOfObject, int paramInt, CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(3303);
    if (paramCancellationSignal != null) {
      paramCancellationSignal.throwIfCanceled();
    }
    switch (DatabaseUtils.getSqlStatementType(paramString))
    {
    default: 
      AppMethodBeat.o(3303);
      return false;
    case 4: 
      beginTransaction(2, null, paramInt, paramCancellationSignal);
      AppMethodBeat.o(3303);
      return true;
    case 5: 
      setTransactionSuccessful();
      endTransaction(paramCancellationSignal);
      AppMethodBeat.o(3303);
      return true;
    }
    endTransaction(paramCancellationSignal);
    AppMethodBeat.o(3303);
    return true;
  }
  
  private Transaction obtainTransaction(int paramInt, SQLiteTransactionListener paramSQLiteTransactionListener)
  {
    AppMethodBeat.i(3313);
    Transaction localTransaction = this.mTransactionPool;
    if (localTransaction != null)
    {
      this.mTransactionPool = localTransaction.mParent;
      localTransaction.mParent = null;
      localTransaction.mMarkedSuccessful = false;
      localTransaction.mChildFailed = false;
    }
    for (;;)
    {
      localTransaction.mMode = paramInt;
      localTransaction.mListener = paramSQLiteTransactionListener;
      AppMethodBeat.o(3313);
      return localTransaction;
      localTransaction = new Transaction(null);
    }
  }
  
  private void recycleTransaction(Transaction paramTransaction)
  {
    paramTransaction.mParent = this.mTransactionPool;
    paramTransaction.mListener = null;
    this.mTransactionPool = paramTransaction;
  }
  
  private void releaseConnection()
  {
    AppMethodBeat.i(3305);
    int i = this.mConnectionUseCount - 1;
    this.mConnectionUseCount = i;
    if (i == 0) {
      try
      {
        this.mConnection.setAcquisitionState(false, false);
        this.mConnectionPool.releaseConnection(this.mConnection);
        return;
      }
      finally
      {
        this.mConnection = null;
        AppMethodBeat.o(3305);
      }
    }
    AppMethodBeat.o(3305);
  }
  
  private void throwIfNestedTransaction()
  {
    AppMethodBeat.i(3312);
    if (hasNestedTransaction())
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Cannot perform this operation because a nested transaction is in progress.");
      AppMethodBeat.o(3312);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(3312);
  }
  
  private void throwIfNoTransaction()
  {
    AppMethodBeat.i(3310);
    if (this.mTransactionStack == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Cannot perform this operation because there is no current transaction.");
      AppMethodBeat.o(3310);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(3310);
  }
  
  private void throwIfTransactionMarkedSuccessful()
  {
    AppMethodBeat.i(3311);
    if ((this.mTransactionStack != null) && (this.mTransactionStack.mMarkedSuccessful))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Cannot perform this operation because the transaction has already been marked successful.  The only thing you can do now is call endTransaction().");
      AppMethodBeat.o(3311);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(3311);
  }
  
  private boolean yieldTransactionUnchecked(long paramLong, CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(3294);
    if (paramCancellationSignal != null) {
      paramCancellationSignal.throwIfCanceled();
    }
    if (!this.mConnectionPool.shouldYieldConnection(this.mConnection, this.mConnectionFlags))
    {
      AppMethodBeat.o(3294);
      return false;
    }
    int i = this.mTransactionStack.mMode;
    SQLiteTransactionListener localSQLiteTransactionListener = this.mTransactionStack.mListener;
    int j = this.mConnectionFlags;
    endTransactionUnchecked(paramCancellationSignal, true);
    if (paramLong > 0L) {}
    try
    {
      Thread.sleep(paramLong);
      label80:
      beginTransactionUnchecked(i, localSQLiteTransactionListener, j, paramCancellationSignal);
      AppMethodBeat.o(3294);
      return true;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label80;
    }
  }
  
  final SQLiteConnection acquireConnectionForNativeHandle(int paramInt)
  {
    AppMethodBeat.i(3306);
    acquireConnection(null, paramInt, true, null);
    SQLiteConnection localSQLiteConnection = this.mConnection;
    AppMethodBeat.o(3306);
    return localSQLiteConnection;
  }
  
  final SQLiteConnection.PreparedStatement acquirePreparedStatement(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(3308);
    acquireConnection(paramString, paramInt, paramBoolean, null);
    paramString = this.mConnection.acquirePreparedStatement(paramString);
    AppMethodBeat.o(3308);
    return paramString;
  }
  
  public final void beginTransaction(int paramInt1, SQLiteTransactionListener paramSQLiteTransactionListener, int paramInt2, CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(3288);
    throwIfTransactionMarkedSuccessful();
    beginTransactionUnchecked(paramInt1, paramSQLiteTransactionListener, paramInt2, paramCancellationSignal);
    AppMethodBeat.o(3288);
  }
  
  public final void endTransaction(CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(3291);
    throwIfNoTransaction();
    if ((!$assertionsDisabled) && (this.mConnection == null))
    {
      paramCancellationSignal = new AssertionError();
      AppMethodBeat.o(3291);
      throw paramCancellationSignal;
    }
    endTransactionUnchecked(paramCancellationSignal, false);
    AppMethodBeat.o(3291);
  }
  
  public final void execute(String paramString, Object[] paramArrayOfObject, int paramInt, CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(3296);
    if (paramString == null)
    {
      paramString = new IllegalArgumentException("sql must not be null.");
      AppMethodBeat.o(3296);
      throw paramString;
    }
    if (executeSpecial(paramString, paramArrayOfObject, paramInt, paramCancellationSignal))
    {
      AppMethodBeat.o(3296);
      return;
    }
    acquireConnection(paramString, paramInt, false, paramCancellationSignal);
    try
    {
      this.mConnection.execute(paramString, paramArrayOfObject, paramCancellationSignal);
      return;
    }
    finally
    {
      releaseConnection();
      AppMethodBeat.o(3296);
    }
  }
  
  public final int executeForChangedRowCount(String paramString, Object[] paramArrayOfObject, int paramInt, CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(3299);
    if (paramString == null)
    {
      paramString = new IllegalArgumentException("sql must not be null.");
      AppMethodBeat.o(3299);
      throw paramString;
    }
    if (executeSpecial(paramString, paramArrayOfObject, paramInt, paramCancellationSignal))
    {
      AppMethodBeat.o(3299);
      return 0;
    }
    acquireConnection(paramString, paramInt, false, paramCancellationSignal);
    try
    {
      paramInt = this.mConnection.executeForChangedRowCount(paramString, paramArrayOfObject, paramCancellationSignal);
      return paramInt;
    }
    finally
    {
      releaseConnection();
      AppMethodBeat.o(3299);
    }
  }
  
  public final int executeForCursorWindow(String paramString, Object[] paramArrayOfObject, CursorWindow paramCursorWindow, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(3301);
    if (paramString == null)
    {
      paramString = new IllegalArgumentException("sql must not be null.");
      AppMethodBeat.o(3301);
      throw paramString;
    }
    if (paramCursorWindow == null)
    {
      paramString = new IllegalArgumentException("window must not be null.");
      AppMethodBeat.o(3301);
      throw paramString;
    }
    if (executeSpecial(paramString, paramArrayOfObject, paramInt3, paramCancellationSignal))
    {
      paramCursorWindow.clear();
      AppMethodBeat.o(3301);
      return 0;
    }
    acquireConnection(paramString, paramInt3, false, paramCancellationSignal);
    try
    {
      paramInt1 = this.mConnection.executeForCursorWindow(paramString, paramArrayOfObject, paramCursorWindow, paramInt1, paramInt2, paramBoolean, paramCancellationSignal);
      return paramInt1;
    }
    finally
    {
      releaseConnection();
      AppMethodBeat.o(3301);
    }
  }
  
  public final long executeForLastInsertedRowId(String paramString, Object[] paramArrayOfObject, int paramInt, CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(3300);
    if (paramString == null)
    {
      paramString = new IllegalArgumentException("sql must not be null.");
      AppMethodBeat.o(3300);
      throw paramString;
    }
    if (executeSpecial(paramString, paramArrayOfObject, paramInt, paramCancellationSignal))
    {
      AppMethodBeat.o(3300);
      return 0L;
    }
    acquireConnection(paramString, paramInt, false, paramCancellationSignal);
    try
    {
      long l = this.mConnection.executeForLastInsertedRowId(paramString, paramArrayOfObject, paramCancellationSignal);
      return l;
    }
    finally
    {
      releaseConnection();
      AppMethodBeat.o(3300);
    }
  }
  
  public final long executeForLong(String paramString, Object[] paramArrayOfObject, int paramInt, CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(3297);
    if (paramString == null)
    {
      paramString = new IllegalArgumentException("sql must not be null.");
      AppMethodBeat.o(3297);
      throw paramString;
    }
    if (executeSpecial(paramString, paramArrayOfObject, paramInt, paramCancellationSignal))
    {
      AppMethodBeat.o(3297);
      return 0L;
    }
    acquireConnection(paramString, paramInt, false, paramCancellationSignal);
    try
    {
      long l = this.mConnection.executeForLong(paramString, paramArrayOfObject, paramCancellationSignal);
      return l;
    }
    finally
    {
      releaseConnection();
      AppMethodBeat.o(3297);
    }
  }
  
  public final String executeForString(String paramString, Object[] paramArrayOfObject, int paramInt, CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(3298);
    if (paramString == null)
    {
      paramString = new IllegalArgumentException("sql must not be null.");
      AppMethodBeat.o(3298);
      throw paramString;
    }
    if (executeSpecial(paramString, paramArrayOfObject, paramInt, paramCancellationSignal))
    {
      AppMethodBeat.o(3298);
      return null;
    }
    acquireConnection(paramString, paramInt, false, paramCancellationSignal);
    try
    {
      paramString = this.mConnection.executeForString(paramString, paramArrayOfObject, paramCancellationSignal);
      return paramString;
    }
    finally
    {
      releaseConnection();
      AppMethodBeat.o(3298);
    }
  }
  
  public final boolean hasConnection()
  {
    return this.mConnection != null;
  }
  
  public final boolean hasNestedTransaction()
  {
    return (this.mTransactionStack != null) && (this.mTransactionStack.mParent != null);
  }
  
  public final boolean hasTransaction()
  {
    return this.mTransactionStack != null;
  }
  
  public final void prepare(String paramString, int paramInt, CancellationSignal paramCancellationSignal, SQLiteStatementInfo paramSQLiteStatementInfo)
  {
    AppMethodBeat.i(3295);
    if (paramString == null)
    {
      paramString = new IllegalArgumentException("sql must not be null.");
      AppMethodBeat.o(3295);
      throw paramString;
    }
    if (paramCancellationSignal != null) {
      paramCancellationSignal.throwIfCanceled();
    }
    acquireConnection(paramString, paramInt, false, paramCancellationSignal);
    try
    {
      this.mConnection.prepare(paramString, paramSQLiteStatementInfo);
      return;
    }
    finally
    {
      releaseConnection();
      AppMethodBeat.o(3295);
    }
  }
  
  final void releaseConnectionForNativeHandle(Exception paramException)
  {
    AppMethodBeat.i(3307);
    if (this.mConnection != null) {
      this.mConnection.endNativeHandle(paramException);
    }
    releaseConnection();
    AppMethodBeat.o(3307);
  }
  
  final void releasePreparedStatement(SQLiteConnection.PreparedStatement paramPreparedStatement)
  {
    AppMethodBeat.i(3309);
    if (this.mConnection != null)
    {
      this.mConnection.releasePreparedStatement(paramPreparedStatement);
      releaseConnection();
    }
    AppMethodBeat.o(3309);
  }
  
  public final void setTransactionSuccessful()
  {
    AppMethodBeat.i(3290);
    throwIfNoTransaction();
    throwIfTransactionMarkedSuccessful();
    this.mTransactionStack.mMarkedSuccessful = true;
    AppMethodBeat.o(3290);
  }
  
  public final Pair<Integer, Integer> walCheckpoint(String paramString, int paramInt)
  {
    AppMethodBeat.i(3302);
    acquireConnection(null, paramInt, false, null);
    try
    {
      paramString = this.mConnection.walCheckpoint(paramString);
      return paramString;
    }
    finally
    {
      releaseConnection();
      AppMethodBeat.o(3302);
    }
  }
  
  public final boolean yieldTransaction(long paramLong, boolean paramBoolean, CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(3293);
    if (paramBoolean)
    {
      throwIfNoTransaction();
      throwIfTransactionMarkedSuccessful();
      throwIfNestedTransaction();
    }
    while ((!$assertionsDisabled) && (this.mConnection == null))
    {
      paramCancellationSignal = new AssertionError();
      AppMethodBeat.o(3293);
      throw paramCancellationSignal;
      if ((this.mTransactionStack == null) || (this.mTransactionStack.mMarkedSuccessful) || (this.mTransactionStack.mParent != null))
      {
        AppMethodBeat.o(3293);
        return false;
      }
    }
    if (this.mTransactionStack.mChildFailed)
    {
      AppMethodBeat.o(3293);
      return false;
    }
    paramBoolean = yieldTransactionUnchecked(paramLong, paramCancellationSignal);
    AppMethodBeat.o(3293);
    return paramBoolean;
  }
  
  static final class Transaction
  {
    public boolean mChildFailed;
    public SQLiteTransactionListener mListener;
    public boolean mMarkedSuccessful;
    public int mMode;
    public Transaction mParent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteSession
 * JD-Core Version:    0.7.0.1
 */