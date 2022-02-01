package com.tencent.wcdb.database;

import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.support.CancellationSignal;
import java.util.Arrays;

public abstract class SQLiteProgram
  extends SQLiteClosable
{
  private static final String[] EMPTY_STRING_ARRAY = new String[0];
  private static final String TAG = "WCDB.SQLiteProgram";
  private final Object[] mBindArgs;
  private SQLiteSession mBoundSession;
  private final String[] mColumnNames;
  private final SQLiteDatabase mDatabase;
  private final int mNumParameters;
  protected SQLiteConnection.PreparedStatement mPreparedStatement;
  private final boolean mReadOnly;
  private final String mSql;
  
  protected SQLiteProgram(SQLiteDatabase paramSQLiteDatabase, String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    this.mDatabase = paramSQLiteDatabase;
    this.mSql = paramString.trim();
    int i = DatabaseUtils.getSqlStatementType(this.mSql);
    switch (i)
    {
    default: 
      if (i == 1)
      {
        bool1 = true;
        paramString = new SQLiteStatementInfo();
        paramSQLiteDatabase.getThreadSession().prepare(this.mSql, paramSQLiteDatabase.getThreadDefaultConnectionFlags(bool1), paramCancellationSignal, paramString);
        if ((i == 8) || (!paramString.readOnly)) {
          break label214;
        }
      }
      break;
    }
    label214:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.mReadOnly = bool1;
      this.mColumnNames = paramString.columnNames;
      for (this.mNumParameters = paramString.numParameters; (paramArrayOfObject != null) && (paramArrayOfObject.length > this.mNumParameters); this.mNumParameters = 0)
      {
        throw new IllegalArgumentException("Too many bind arguments.  " + paramArrayOfObject.length + " arguments were provided but the statement needs " + this.mNumParameters + " arguments.");
        this.mReadOnly = false;
        this.mColumnNames = EMPTY_STRING_ARRAY;
      }
      bool1 = false;
      break;
    }
    if (this.mNumParameters != 0)
    {
      this.mBindArgs = new Object[this.mNumParameters];
      if (paramArrayOfObject != null) {
        System.arraycopy(paramArrayOfObject, 0, this.mBindArgs, 0, paramArrayOfObject.length);
      }
    }
    for (;;)
    {
      this.mPreparedStatement = null;
      this.mBoundSession = null;
      return;
      this.mBindArgs = null;
    }
  }
  
  private void bind(int paramInt, Object paramObject)
  {
    if ((paramInt <= 0) || (paramInt > this.mNumParameters)) {
      throw new IllegalArgumentException("Cannot bind argument at index " + paramInt + " because the index is out of range.  The statement has " + this.mNumParameters + " parameters.");
    }
    this.mBindArgs[(paramInt - 1)] = paramObject;
  }
  
  protected boolean acquirePreparedStatement(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        SQLiteSession localSQLiteSession1 = this.mDatabase.getThreadSession();
        SQLiteSession localSQLiteSession2 = this.mBoundSession;
        if (localSQLiteSession1 == localSQLiteSession2)
        {
          paramBoolean = false;
          return paramBoolean;
        }
        if (this.mBoundSession != null) {
          throw new IllegalStateException("SQLiteProgram has bound to another thread.");
        }
      }
      finally {}
      this.mPreparedStatement = localObject.acquirePreparedStatement(this.mSql, this.mDatabase.getThreadDefaultConnectionFlags(this.mReadOnly), paramBoolean);
      this.mPreparedStatement.bindArguments(this.mBindArgs);
      this.mBoundSession = localObject;
      paramBoolean = true;
    }
  }
  
  public void bindAllArgs(Object[] paramArrayOfObject)
  {
    int i = paramArrayOfObject.length;
    while (i != 0)
    {
      bind(i, paramArrayOfObject[(i - 1)]);
      i -= 1;
    }
  }
  
  public void bindAllArgsAsStrings(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      int i = paramArrayOfString.length;
      while (i != 0)
      {
        bindString(i, paramArrayOfString[(i - 1)]);
        i -= 1;
      }
    }
  }
  
  public void bindBlob(int paramInt, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("the bind value at index " + paramInt + " is null");
    }
    bind(paramInt, paramArrayOfByte);
  }
  
  public void bindDouble(int paramInt, double paramDouble)
  {
    bind(paramInt, Double.valueOf(paramDouble));
  }
  
  public void bindLong(int paramInt, long paramLong)
  {
    bind(paramInt, Long.valueOf(paramLong));
  }
  
  public void bindNull(int paramInt)
  {
    bind(paramInt, null);
  }
  
  public void bindString(int paramInt, String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("the bind value at index " + paramInt + " is null");
    }
    bind(paramInt, paramString);
  }
  
  protected final void checkCorruption(SQLiteException paramSQLiteException)
  {
    int i = 1;
    if ((paramSQLiteException instanceof SQLiteDatabaseCorruptException)) {}
    for (;;)
    {
      if (i != 0)
      {
        SQLiteDebug.collectLastIOTraceStats(this.mDatabase);
        this.mDatabase.onCorruption();
      }
      return;
      if ((!(paramSQLiteException instanceof SQLiteFullException)) || (!this.mReadOnly)) {
        i = 0;
      }
    }
  }
  
  public void clearBindings()
  {
    if (this.mBindArgs != null) {
      Arrays.fill(this.mBindArgs, null);
    }
  }
  
  /* Error */
  protected void finalize()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 121	com/tencent/wcdb/database/SQLiteProgram:mBoundSession	Lcom/tencent/wcdb/database/SQLiteSession;
    //   6: ifnonnull +10 -> 16
    //   9: aload_0
    //   10: getfield 119	com/tencent/wcdb/database/SQLiteProgram:mPreparedStatement	Lcom/tencent/wcdb/database/SQLiteConnection$PreparedStatement;
    //   13: ifnull +18 -> 31
    //   16: new 202	com/tencent/wcdb/database/SQLiteMisuseException
    //   19: dup
    //   20: ldc 204
    //   22: invokespecial 205	com/tencent/wcdb/database/SQLiteMisuseException:<init>	(Ljava/lang/String;)V
    //   25: athrow
    //   26: astore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_1
    //   30: athrow
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_0
    //   34: invokespecial 207	java/lang/Object:finalize	()V
    //   37: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	SQLiteProgram
    //   26	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	26	finally
    //   16	26	26	finally
    //   27	29	26	finally
    //   31	33	26	finally
  }
  
  protected final Object[] getBindArgs()
  {
    return this.mBindArgs;
  }
  
  public final String[] getColumnNames()
  {
    return this.mColumnNames;
  }
  
  protected final int getConnectionFlags()
  {
    return this.mDatabase.getThreadDefaultConnectionFlags(this.mReadOnly);
  }
  
  public final SQLiteDatabase getDatabase()
  {
    return this.mDatabase;
  }
  
  protected final SQLiteSession getSession()
  {
    return this.mDatabase.getThreadSession();
  }
  
  protected final String getSql()
  {
    return this.mSql;
  }
  
  @Deprecated
  public final int getUniqueId()
  {
    return -1;
  }
  
  protected void onAllReferencesReleased()
  {
    releasePreparedStatement();
    clearBindings();
  }
  
  protected void releasePreparedStatement()
  {
    for (;;)
    {
      try
      {
        if (this.mBoundSession == null)
        {
          SQLiteConnection.PreparedStatement localPreparedStatement = this.mPreparedStatement;
          if (localPreparedStatement == null) {
            return;
          }
        }
        if ((this.mBoundSession == null) || (this.mPreparedStatement == null)) {
          throw new IllegalStateException("Internal state error.");
        }
      }
      finally {}
      if (this.mBoundSession != this.mDatabase.getThreadSession()) {
        throw new IllegalStateException("SQLiteProgram has bound to another thread.");
      }
      this.mBoundSession.releasePreparedStatement(this.mPreparedStatement);
      this.mPreparedStatement = null;
      this.mBoundSession = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteProgram
 * JD-Core Version:    0.7.0.1
 */