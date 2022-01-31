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
    AppMethodBeat.i(12628);
    if (!SQLiteSession.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(12628);
      return;
    }
  }
  
  public SQLiteSession(SQLiteConnectionPool paramSQLiteConnectionPool)
  {
    AppMethodBeat.i(12601);
    if (paramSQLiteConnectionPool == null)
    {
      paramSQLiteConnectionPool = new IllegalArgumentException("connectionPool must not be null");
      AppMethodBeat.o(12601);
      throw paramSQLiteConnectionPool;
    }
    this.mConnectionPool = paramSQLiteConnectionPool;
    AppMethodBeat.o(12601);
  }
  
  private void acquireConnection(String paramString, int paramInt, boolean paramBoolean, CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(12618);
    if (this.mConnection == null)
    {
      this.mConnection = this.mConnectionPool.acquireConnection(paramString, paramInt, paramCancellationSignal);
      this.mConnectionFlags = paramInt;
      this.mConnection.setAcquisitionState(true, paramBoolean);
    }
    this.mConnectionUseCount += 1;
    AppMethodBeat.o(12618);
  }
  
  private void beginTransactionUnchecked(int paramInt1, SQLiteTransactionListener paramSQLiteTransactionListener, int paramInt2, CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(12603);
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
        AppMethodBeat.o(12603);
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
        AppMethodBeat.o(12603);
        return;
      }
      catch (RuntimeException paramSQLiteTransactionListener)
      {
        if (this.mTransactionStack != null) {
          break label194;
        }
        this.mConnection.execute("ROLLBACK;", null, paramCancellationSignal);
        AppMethodBeat.o(12603);
        throw paramSQLiteTransactionListener;
      }
      this.mConnection.execute("BEGIN IMMEDIATE;", null, paramCancellationSignal);
      continue;
      this.mConnection.execute("BEGIN EXCLUSIVE;", null, paramCancellationSignal);
      continue;
      label194:
      label202:
      AppMethodBeat.o(12603);
      return;
    }
  }
  
  private void endTransactionUnchecked(CancellationSignal paramCancellationSignal, boolean paramBoolean)
  {
    int j = 0;
    Object localObject = null;
    AppMethodBeat.i(12606);
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
          AppMethodBeat.o(12606);
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
          AppMethodBeat.o(12606);
        }
        this.mConnection.execute("ROLLBACK;", null, paramCancellationSignal);
        continue;
        AppMethodBeat.o(12606);
        return;
      }
    }
  }
  
  private boolean executeSpecial(String paramString, Object[] paramArrayOfObject, int paramInt, CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(12617);
    if (paramCancellationSignal != null) {
      paramCancellationSignal.throwIfCanceled();
    }
    switch (DatabaseUtils.getSqlStatementType(paramString))
    {
    default: 
      AppMethodBeat.o(12617);
      return false;
    case 4: 
      beginTransaction(2, null, paramInt, paramCancellationSignal);
      AppMethodBeat.o(12617);
      return true;
    case 5: 
      setTransactionSuccessful();
      endTransaction(paramCancellationSignal);
      AppMethodBeat.o(12617);
      return true;
    }
    endTransaction(paramCancellationSignal);
    AppMethodBeat.o(12617);
    return true;
  }
  
  private Transaction obtainTransaction(int paramInt, SQLiteTransactionListener paramSQLiteTransactionListener)
  {
    AppMethodBeat.i(12627);
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
      AppMethodBeat.o(12627);
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
    AppMethodBeat.i(12619);
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
        AppMethodBeat.o(12619);
      }
    }
    AppMethodBeat.o(12619);
  }
  
  private void throwIfNestedTransaction()
  {
    AppMethodBeat.i(12626);
    if (hasNestedTransaction())
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Cannot perform this operation because a nested transaction is in progress.");
      AppMethodBeat.o(12626);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(12626);
  }
  
  private void throwIfNoTransaction()
  {
    AppMethodBeat.i(12624);
    if (this.mTransactionStack == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Cannot perform this operation because there is no current transaction.");
      AppMethodBeat.o(12624);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(12624);
  }
  
  private void throwIfTransactionMarkedSuccessful()
  {
    AppMethodBeat.i(12625);
    if ((this.mTransactionStack != null) && (this.mTransactionStack.mMarkedSuccessful))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Cannot perform this operation because the transaction has already been marked successful.  The only thing you can do now is call endTransaction().");
      AppMethodBeat.o(12625);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(12625);
  }
  
  private boolean yieldTransactionUnchecked(long paramLong, CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(12608);
    if (paramCancellationSignal != null) {
      paramCancellationSignal.throwIfCanceled();
    }
    if (!this.mConnectionPool.shouldYieldConnection(this.mConnection, this.mConnectionFlags))
    {
      AppMethodBeat.o(12608);
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
      AppMethodBeat.o(12608);
      return true;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label80;
    }
  }
  
  final SQLiteConnection acquireConnectionForNativeHandle(int paramInt)
  {
    AppMethodBeat.i(12620);
    acquireConnection(null, paramInt, true, null);
    SQLiteConnection localSQLiteConnection = this.mConnection;
    AppMethodBeat.o(12620);
    return localSQLiteConnection;
  }
  
  final SQLiteConnection.PreparedStatement acquirePreparedStatement(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(156525);
    acquireConnection(paramString, paramInt, paramBoolean, null);
    paramString = this.mConnection.acquirePreparedStatement(paramString);
    AppMethodBeat.o(156525);
    return paramString;
  }
  
  public final void beginTransaction(int paramInt1, SQLiteTransactionListener paramSQLiteTransactionListener, int paramInt2, CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(12602);
    throwIfTransactionMarkedSuccessful();
    beginTransactionUnchecked(paramInt1, paramSQLiteTransactionListener, paramInt2, paramCancellationSignal);
    AppMethodBeat.o(12602);
  }
  
  public final void endTransaction(CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(12605);
    throwIfNoTransaction();
    if ((!$assertionsDisabled) && (this.mConnection == null))
    {
      paramCancellationSignal = new AssertionError();
      AppMethodBeat.o(12605);
      throw paramCancellationSignal;
    }
    endTransactionUnchecked(paramCancellationSignal, false);
    AppMethodBeat.o(12605);
  }
  
  public final void execute(String paramString, Object[] paramArrayOfObject, int paramInt, CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(12610);
    if (paramString == null)
    {
      paramString = new IllegalArgumentException("sql must not be null.");
      AppMethodBeat.o(12610);
      throw paramString;
    }
    if (executeSpecial(paramString, paramArrayOfObject, paramInt, paramCancellationSignal))
    {
      AppMethodBeat.o(12610);
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
      AppMethodBeat.o(12610);
    }
  }
  
  public final int executeForChangedRowCount(String paramString, Object[] paramArrayOfObject, int paramInt, CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(12613);
    if (paramString == null)
    {
      paramString = new IllegalArgumentException("sql must not be null.");
      AppMethodBeat.o(12613);
      throw paramString;
    }
    if (executeSpecial(paramString, paramArrayOfObject, paramInt, paramCancellationSignal))
    {
      AppMethodBeat.o(12613);
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
      AppMethodBeat.o(12613);
    }
  }
  
  public final int executeForCursorWindow(String paramString, Object[] paramArrayOfObject, CursorWindow paramCursorWindow, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(12615);
    if (paramString == null)
    {
      paramString = new IllegalArgumentException("sql must not be null.");
      AppMethodBeat.o(12615);
      throw paramString;
    }
    if (paramCursorWindow == null)
    {
      paramString = new IllegalArgumentException("window must not be null.");
      AppMethodBeat.o(12615);
      throw paramString;
    }
    if (executeSpecial(paramString, paramArrayOfObject, paramInt3, paramCancellationSignal))
    {
      paramCursorWindow.clear();
      AppMethodBeat.o(12615);
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
      AppMethodBeat.o(12615);
    }
  }
  
  public final long executeForLastInsertedRowId(String paramString, Object[] paramArrayOfObject, int paramInt, CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(12614);
    if (paramString == null)
    {
      paramString = new IllegalArgumentException("sql must not be null.");
      AppMethodBeat.o(12614);
      throw paramString;
    }
    if (executeSpecial(paramString, paramArrayOfObject, paramInt, paramCancellationSignal))
    {
      AppMethodBeat.o(12614);
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
      AppMethodBeat.o(12614);
    }
  }
  
  public final long executeForLong(String paramString, Object[] paramArrayOfObject, int paramInt, CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(12611);
    if (paramString == null)
    {
      paramString = new IllegalArgumentException("sql must not be null.");
      AppMethodBeat.o(12611);
      throw paramString;
    }
    if (executeSpecial(paramString, paramArrayOfObject, paramInt, paramCancellationSignal))
    {
      AppMethodBeat.o(12611);
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
      AppMethodBeat.o(12611);
    }
  }
  
  public final String executeForString(String paramString, Object[] paramArrayOfObject, int paramInt, CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(12612);
    if (paramString == null)
    {
      paramString = new IllegalArgumentException("sql must not be null.");
      AppMethodBeat.o(12612);
      throw paramString;
    }
    if (executeSpecial(paramString, paramArrayOfObject, paramInt, paramCancellationSignal))
    {
      AppMethodBeat.o(12612);
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
      AppMethodBeat.o(12612);
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
    AppMethodBeat.i(12609);
    if (paramString == null)
    {
      paramString = new IllegalArgumentException("sql must not be null.");
      AppMethodBeat.o(12609);
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
      AppMethodBeat.o(12609);
    }
  }
  
  final void releaseConnectionForNativeHandle(Exception paramException)
  {
    AppMethodBeat.i(12621);
    if (this.mConnection != null) {
      this.mConnection.endNativeHandle(paramException);
    }
    releaseConnection();
    AppMethodBeat.o(12621);
  }
  
  final void releasePreparedStatement(SQLiteConnection.PreparedStatement paramPreparedStatement)
  {
    AppMethodBeat.i(12623);
    if (this.mConnection != null)
    {
      this.mConnection.releasePreparedStatement(paramPreparedStatement);
      releaseConnection();
    }
    AppMethodBeat.o(12623);
  }
  
  public final void setTransactionSuccessful()
  {
    AppMethodBeat.i(12604);
    throwIfNoTransaction();
    throwIfTransactionMarkedSuccessful();
    this.mTransactionStack.mMarkedSuccessful = true;
    AppMethodBeat.o(12604);
  }
  
  public final Pair<Integer, Integer> walCheckpoint(String paramString, int paramInt)
  {
    AppMethodBeat.i(12616);
    acquireConnection(null, paramInt, false, null);
    try
    {
      paramString = this.mConnection.walCheckpoint(paramString);
      return paramString;
    }
    finally
    {
      releaseConnection();
      AppMethodBeat.o(12616);
    }
  }
  
  public final boolean yieldTransaction(long paramLong, boolean paramBoolean, CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(12607);
    if (paramBoolean)
    {
      throwIfNoTransaction();
      throwIfTransactionMarkedSuccessful();
      throwIfNestedTransaction();
    }
    while ((!$assertionsDisabled) && (this.mConnection == null))
    {
      paramCancellationSignal = new AssertionError();
      AppMethodBeat.o(12607);
      throw paramCancellationSignal;
      if ((this.mTransactionStack == null) || (this.mTransactionStack.mMarkedSuccessful) || (this.mTransactionStack.mParent != null))
      {
        AppMethodBeat.o(12607);
        return false;
      }
    }
    if (this.mTransactionStack.mChildFailed)
    {
      AppMethodBeat.o(12607);
      return false;
    }
    paramBoolean = yieldTransactionUnchecked(paramLong, paramCancellationSignal);
    AppMethodBeat.o(12607);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteSession
 * JD-Core Version:    0.7.0.1
 */