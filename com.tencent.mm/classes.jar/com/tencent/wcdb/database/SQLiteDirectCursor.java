package com.tencent.wcdb.database;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.AbstractCursor;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;

public class SQLiteDirectCursor
  extends AbstractCursor
{
  public static final SQLiteDatabase.CursorFactory FACTORY;
  private static final String TAG = "WCDB.SQLiteDirectCursor";
  private final String[] mColumns;
  private int mCount;
  private boolean mCountFinished;
  private final SQLiteCursorDriver mDriver;
  private final SQLiteDirectQuery mQuery;
  
  static
  {
    AppMethodBeat.i(3255);
    FACTORY = new SQLiteDatabase.CursorFactory()
    {
      public final Cursor newCursor(SQLiteDatabase paramAnonymousSQLiteDatabase, SQLiteCursorDriver paramAnonymousSQLiteCursorDriver, String paramAnonymousString, SQLiteProgram paramAnonymousSQLiteProgram)
      {
        AppMethodBeat.i(3238);
        paramAnonymousSQLiteDatabase = new SQLiteDirectCursor(paramAnonymousSQLiteCursorDriver, paramAnonymousString, (SQLiteDirectQuery)paramAnonymousSQLiteProgram);
        AppMethodBeat.o(3238);
        return paramAnonymousSQLiteDatabase;
      }
      
      public final SQLiteProgram newQuery(SQLiteDatabase paramAnonymousSQLiteDatabase, String paramAnonymousString, Object[] paramAnonymousArrayOfObject, CancellationSignal paramAnonymousCancellationSignal)
      {
        AppMethodBeat.i(3239);
        paramAnonymousSQLiteDatabase = new SQLiteDirectQuery(paramAnonymousSQLiteDatabase, paramAnonymousString, paramAnonymousArrayOfObject, paramAnonymousCancellationSignal);
        AppMethodBeat.o(3239);
        return paramAnonymousSQLiteDatabase;
      }
    };
    AppMethodBeat.o(3255);
  }
  
  public SQLiteDirectCursor(SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteDirectQuery paramSQLiteDirectQuery)
  {
    AppMethodBeat.i(3240);
    if (paramSQLiteDirectQuery == null)
    {
      paramSQLiteCursorDriver = new IllegalArgumentException("query object cannot be null");
      AppMethodBeat.o(3240);
      throw paramSQLiteCursorDriver;
    }
    this.mQuery = paramSQLiteDirectQuery;
    this.mDriver = paramSQLiteCursorDriver;
    this.mColumns = paramSQLiteDirectQuery.getColumnNames();
    this.mCount = -1;
    this.mCountFinished = false;
    AppMethodBeat.o(3240);
  }
  
  public void close()
  {
    AppMethodBeat.i(3241);
    super.close();
    this.mQuery.close();
    this.mDriver.cursorClosed();
    AppMethodBeat.o(3241);
  }
  
  public void deactivate()
  {
    AppMethodBeat.i(3242);
    super.deactivate();
    this.mDriver.cursorDeactivated();
    AppMethodBeat.o(3242);
  }
  
  public byte[] getBlob(int paramInt)
  {
    AppMethodBeat.i(3244);
    byte[] arrayOfByte = this.mQuery.getBlob(paramInt);
    AppMethodBeat.o(3244);
    return arrayOfByte;
  }
  
  public String[] getColumnNames()
  {
    return this.mColumns;
  }
  
  public int getCount()
  {
    AppMethodBeat.i(3253);
    if (!this.mCountFinished)
    {
      Log.w("WCDB.SQLiteDirectCursor", "Count query on SQLiteDirectCursor is slow. Iterate through the end to get count or use other implementations.");
      this.mCount = (this.mPos + this.mQuery.step(2147483647) + 1);
      this.mCountFinished = true;
      this.mQuery.reset(false);
      this.mPos = (this.mQuery.step(this.mPos + 1) - 1);
    }
    int i = this.mCount;
    AppMethodBeat.o(3253);
    return i;
  }
  
  public double getDouble(int paramInt)
  {
    AppMethodBeat.i(3249);
    double d = this.mQuery.getDouble(paramInt);
    AppMethodBeat.o(3249);
    return d;
  }
  
  public float getFloat(int paramInt)
  {
    AppMethodBeat.i(3248);
    float f = (float)this.mQuery.getDouble(paramInt);
    AppMethodBeat.o(3248);
    return f;
  }
  
  public int getInt(int paramInt)
  {
    AppMethodBeat.i(3246);
    paramInt = (int)this.mQuery.getLong(paramInt);
    AppMethodBeat.o(3246);
    return paramInt;
  }
  
  public long getLong(int paramInt)
  {
    AppMethodBeat.i(3247);
    long l = this.mQuery.getLong(paramInt);
    AppMethodBeat.o(3247);
    return l;
  }
  
  public short getShort(int paramInt)
  {
    AppMethodBeat.i(3245);
    short s = (short)(int)this.mQuery.getLong(paramInt);
    AppMethodBeat.o(3245);
    return s;
  }
  
  public String getString(int paramInt)
  {
    AppMethodBeat.i(3243);
    String str = this.mQuery.getString(paramInt);
    AppMethodBeat.o(3243);
    return str;
  }
  
  public int getType(int paramInt)
  {
    AppMethodBeat.i(3250);
    paramInt = this.mQuery.getType(paramInt);
    AppMethodBeat.o(3250);
    return paramInt;
  }
  
  public boolean isNull(int paramInt)
  {
    AppMethodBeat.i(3251);
    if (getType(paramInt) == 0)
    {
      AppMethodBeat.o(3251);
      return true;
    }
    AppMethodBeat.o(3251);
    return false;
  }
  
  public boolean moveToPosition(int paramInt)
  {
    AppMethodBeat.i(3252);
    if (paramInt < 0)
    {
      this.mQuery.reset(false);
      this.mPos = -1;
      AppMethodBeat.o(3252);
      return false;
    }
    if ((this.mCountFinished) && (paramInt >= this.mCount))
    {
      this.mPos = this.mCount;
      AppMethodBeat.o(3252);
      return false;
    }
    int i;
    if (paramInt < this.mPos)
    {
      Log.w("WCDB.SQLiteDirectCursor", "Moving backward on SQLiteDirectCursor is slow. Get rid of backward movement or use other implementations.");
      this.mQuery.reset(false);
      i = this.mQuery.step(paramInt + 1) - 1;
      if (i >= paramInt) {
        break label180;
      }
      this.mCount = (i + 1);
      this.mCountFinished = true;
      this.mPos = this.mCount;
    }
    for (;;)
    {
      if (this.mPos >= this.mCount) {
        break label208;
      }
      AppMethodBeat.o(3252);
      return true;
      if (paramInt == this.mPos)
      {
        AppMethodBeat.o(3252);
        return true;
      }
      i = this.mPos + this.mQuery.step(paramInt - this.mPos);
      break;
      label180:
      this.mPos = i;
      if (i >= this.mCount)
      {
        this.mCount = (i + 1);
        this.mCountFinished = false;
      }
    }
    label208:
    AppMethodBeat.o(3252);
    return false;
  }
  
  /* Error */
  public boolean requery()
  {
    // Byte code:
    //   0: sipush 3254
    //   3: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 138	com/tencent/wcdb/database/SQLiteDirectCursor:isClosed	()Z
    //   10: ifeq +11 -> 21
    //   13: sipush 3254
    //   16: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: iconst_0
    //   20: ireturn
    //   21: aload_0
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield 50	com/tencent/wcdb/database/SQLiteDirectCursor:mQuery	Lcom/tencent/wcdb/database/SQLiteDirectQuery;
    //   27: invokevirtual 142	com/tencent/wcdb/database/SQLiteDirectQuery:getDatabase	()Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   30: invokevirtual 147	com/tencent/wcdb/database/SQLiteDatabase:isOpen	()Z
    //   33: ifne +13 -> 46
    //   36: aload_0
    //   37: monitorexit
    //   38: sipush 3254
    //   41: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: iconst_0
    //   45: ireturn
    //   46: aload_0
    //   47: iconst_m1
    //   48: putfield 96	com/tencent/wcdb/database/SQLiteDirectCursor:mPos	I
    //   51: aload_0
    //   52: iconst_0
    //   53: putfield 64	com/tencent/wcdb/database/SQLiteDirectCursor:mCountFinished	Z
    //   56: aload_0
    //   57: iconst_m1
    //   58: putfield 62	com/tencent/wcdb/database/SQLiteDirectCursor:mCount	I
    //   61: aload_0
    //   62: getfield 52	com/tencent/wcdb/database/SQLiteDirectCursor:mDriver	Lcom/tencent/wcdb/database/SQLiteCursorDriver;
    //   65: aload_0
    //   66: invokeinterface 151 2 0
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_0
    //   74: getfield 50	com/tencent/wcdb/database/SQLiteDirectCursor:mQuery	Lcom/tencent/wcdb/database/SQLiteDirectQuery;
    //   77: iconst_0
    //   78: invokevirtual 105	com/tencent/wcdb/database/SQLiteDirectQuery:reset	(Z)V
    //   81: aload_0
    //   82: invokespecial 153	com/tencent/wcdb/AbstractCursor:requery	()Z
    //   85: istore_1
    //   86: sipush 3254
    //   89: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: iload_1
    //   93: ireturn
    //   94: astore_2
    //   95: aload_0
    //   96: monitorexit
    //   97: sipush 3254
    //   100: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: aload_2
    //   104: athrow
    //   105: astore_2
    //   106: ldc 12
    //   108: new 155	java/lang/StringBuilder
    //   111: dup
    //   112: ldc 157
    //   114: invokespecial 158	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   117: aload_2
    //   118: invokevirtual 162	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   121: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: iconst_1
    //   128: anewarray 171	java/lang/Object
    //   131: dup
    //   132: iconst_0
    //   133: aload_2
    //   134: aastore
    //   135: invokestatic 174	com/tencent/wcdb/support/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   138: sipush 3254
    //   141: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   144: iconst_0
    //   145: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	SQLiteDirectCursor
    //   85	8	1	bool	boolean
    //   94	10	2	localObject	Object
    //   105	29	2	localIllegalStateException	java.lang.IllegalStateException
    // Exception table:
    //   from	to	target	type
    //   23	38	94	finally
    //   46	73	94	finally
    //   81	86	105	java/lang/IllegalStateException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteDirectCursor
 * JD-Core Version:    0.7.0.1
 */