package com.tencent.wcdb.database;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.AbstractWindowedCursor;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.CursorWindow;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;
import java.util.HashMap;
import java.util.Map;

public class SQLiteCursor
  extends AbstractWindowedCursor
{
  public static final SQLiteDatabase.CursorFactory FACTORY;
  static final int NO_COUNT = -1;
  static final String TAG = "WCDB.SQLiteCursor";
  private Map<String, Integer> mColumnNameMap;
  private final String[] mColumns;
  private int mCount;
  private int mCursorWindowCapacity;
  private final SQLiteCursorDriver mDriver;
  private final String mEditTable;
  private final SQLiteQuery mQuery;
  private final Throwable mStackTrace;
  
  static
  {
    AppMethodBeat.i(12419);
    FACTORY = new SQLiteDatabase.CursorFactory()
    {
      public final Cursor newCursor(SQLiteDatabase paramAnonymousSQLiteDatabase, SQLiteCursorDriver paramAnonymousSQLiteCursorDriver, String paramAnonymousString, SQLiteProgram paramAnonymousSQLiteProgram)
      {
        AppMethodBeat.i(12405);
        paramAnonymousSQLiteDatabase = new SQLiteCursor(paramAnonymousSQLiteCursorDriver, paramAnonymousString, (SQLiteQuery)paramAnonymousSQLiteProgram);
        AppMethodBeat.o(12405);
        return paramAnonymousSQLiteDatabase;
      }
      
      public final SQLiteProgram newQuery(SQLiteDatabase paramAnonymousSQLiteDatabase, String paramAnonymousString, Object[] paramAnonymousArrayOfObject, CancellationSignal paramAnonymousCancellationSignal)
      {
        AppMethodBeat.i(12406);
        paramAnonymousSQLiteDatabase = new SQLiteQuery(paramAnonymousSQLiteDatabase, paramAnonymousString, paramAnonymousArrayOfObject, paramAnonymousCancellationSignal);
        AppMethodBeat.o(12406);
        return paramAnonymousSQLiteDatabase;
      }
    };
    AppMethodBeat.o(12419);
  }
  
  public SQLiteCursor(SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteQuery paramSQLiteQuery)
  {
    AppMethodBeat.i(12407);
    this.mCount = -1;
    if (paramSQLiteQuery == null)
    {
      paramSQLiteCursorDriver = new IllegalArgumentException("query object cannot be null");
      AppMethodBeat.o(12407);
      throw paramSQLiteCursorDriver;
    }
    this.mStackTrace = null;
    this.mDriver = paramSQLiteCursorDriver;
    this.mEditTable = paramString;
    this.mColumnNameMap = null;
    this.mQuery = paramSQLiteQuery;
    this.mColumns = paramSQLiteQuery.getColumnNames();
    this.mRowIdColumnIndex = DatabaseUtils.findRowIdColumnIndex(this.mColumns);
    AppMethodBeat.o(12407);
  }
  
  @Deprecated
  public SQLiteCursor(SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteQuery paramSQLiteQuery)
  {
    this(paramSQLiteCursorDriver, paramString, paramSQLiteQuery);
  }
  
  private void fillWindow(int paramInt)
  {
    AppMethodBeat.i(12411);
    clearOrCreateWindow(getDatabase().getPath());
    try
    {
      if (this.mCount == -1)
      {
        i = DatabaseUtils.cursorPickFillWindowStartPosition(paramInt, 0);
        this.mCount = this.mQuery.fillWindow(this.mWindow, i, paramInt, true);
        this.mCursorWindowCapacity = this.mWindow.getNumRows();
        AppMethodBeat.o(12411);
        return;
      }
      int i = DatabaseUtils.cursorPickFillWindowStartPosition(paramInt, this.mCursorWindowCapacity);
      this.mQuery.fillWindow(this.mWindow, i, paramInt, false);
      AppMethodBeat.o(12411);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      closeWindow();
      AppMethodBeat.o(12411);
      throw localRuntimeException;
    }
  }
  
  public void close()
  {
    AppMethodBeat.i(12414);
    super.close();
    try
    {
      this.mQuery.close();
      this.mDriver.cursorClosed();
      return;
    }
    finally
    {
      AppMethodBeat.o(12414);
    }
  }
  
  public void deactivate()
  {
    AppMethodBeat.i(12413);
    super.deactivate();
    this.mDriver.cursorDeactivated();
    AppMethodBeat.o(12413);
  }
  
  public void finalize()
  {
    AppMethodBeat.i(12418);
    try
    {
      if (this.mWindow != null) {
        close();
      }
      return;
    }
    finally
    {
      super.finalize();
      AppMethodBeat.o(12418);
    }
  }
  
  public int getColumnIndex(String paramString)
  {
    AppMethodBeat.i(12412);
    if (this.mColumnNameMap == null)
    {
      localObject = this.mColumns;
      int j = localObject.length;
      HashMap localHashMap = new HashMap(j, 1.0F);
      i = 0;
      while (i < j)
      {
        localHashMap.put(localObject[i], Integer.valueOf(i));
        i += 1;
      }
      this.mColumnNameMap = localHashMap;
    }
    int i = paramString.lastIndexOf('.');
    Object localObject = paramString;
    if (i != -1)
    {
      localObject = new Exception();
      Log.e("WCDB.SQLiteCursor", "requesting column name with table name -- ".concat(String.valueOf(paramString)), new Object[] { localObject });
      localObject = paramString.substring(i + 1);
    }
    paramString = (Integer)this.mColumnNameMap.get(localObject);
    if (paramString != null)
    {
      i = paramString.intValue();
      AppMethodBeat.o(12412);
      return i;
    }
    AppMethodBeat.o(12412);
    return -1;
  }
  
  public String[] getColumnNames()
  {
    return this.mColumns;
  }
  
  public int getCount()
  {
    AppMethodBeat.i(12410);
    if (this.mCount == -1) {
      fillWindow(0);
    }
    int i = this.mCount;
    AppMethodBeat.o(12410);
    return i;
  }
  
  public SQLiteDatabase getDatabase()
  {
    AppMethodBeat.i(12408);
    SQLiteDatabase localSQLiteDatabase = this.mQuery.getDatabase();
    AppMethodBeat.o(12408);
    return localSQLiteDatabase;
  }
  
  public boolean onMove(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12409);
    if ((this.mWindow == null) || (paramInt2 < this.mWindow.getStartPosition()) || (paramInt2 >= this.mWindow.getStartPosition() + this.mWindow.getNumRows())) {
      fillWindow(paramInt2);
    }
    AppMethodBeat.o(12409);
    return true;
  }
  
  /* Error */
  public boolean requery()
  {
    // Byte code:
    //   0: sipush 12415
    //   3: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 218	com/tencent/wcdb/database/SQLiteCursor:isClosed	()Z
    //   10: ifeq +11 -> 21
    //   13: sipush 12415
    //   16: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: iconst_0
    //   20: ireturn
    //   21: aload_0
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield 67	com/tencent/wcdb/database/SQLiteCursor:mQuery	Lcom/tencent/wcdb/database/SQLiteQuery;
    //   27: invokevirtual 206	com/tencent/wcdb/database/SQLiteQuery:getDatabase	()Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   30: invokevirtual 221	com/tencent/wcdb/database/SQLiteDatabase:isOpen	()Z
    //   33: ifne +13 -> 46
    //   36: aload_0
    //   37: monitorexit
    //   38: sipush 12415
    //   41: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: iconst_0
    //   45: ireturn
    //   46: aload_0
    //   47: getfield 113	com/tencent/wcdb/database/SQLiteCursor:mWindow	Lcom/tencent/wcdb/CursorWindow;
    //   50: ifnull +10 -> 60
    //   53: aload_0
    //   54: getfield 113	com/tencent/wcdb/database/SQLiteCursor:mWindow	Lcom/tencent/wcdb/CursorWindow;
    //   57: invokevirtual 224	com/tencent/wcdb/CursorWindow:clear	()V
    //   60: aload_0
    //   61: iconst_m1
    //   62: putfield 227	com/tencent/wcdb/database/SQLiteCursor:mPos	I
    //   65: aload_0
    //   66: iconst_m1
    //   67: putfield 50	com/tencent/wcdb/database/SQLiteCursor:mCount	I
    //   70: aload_0
    //   71: getfield 61	com/tencent/wcdb/database/SQLiteCursor:mDriver	Lcom/tencent/wcdb/database/SQLiteCursorDriver;
    //   74: aload_0
    //   75: invokeinterface 231 2 0
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_0
    //   83: invokespecial 233	com/tencent/wcdb/AbstractWindowedCursor:requery	()Z
    //   86: istore_1
    //   87: sipush 12415
    //   90: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: iload_1
    //   94: ireturn
    //   95: astore_2
    //   96: aload_0
    //   97: monitorexit
    //   98: sipush 12415
    //   101: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: aload_2
    //   105: athrow
    //   106: astore_2
    //   107: ldc 15
    //   109: new 235	java/lang/StringBuilder
    //   112: dup
    //   113: ldc 237
    //   115: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   118: aload_2
    //   119: invokevirtual 241	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   122: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: iconst_1
    //   129: anewarray 183	java/lang/Object
    //   132: dup
    //   133: iconst_0
    //   134: aload_2
    //   135: aastore
    //   136: invokestatic 251	com/tencent/wcdb/support/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   139: sipush 12415
    //   142: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: iconst_0
    //   146: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	SQLiteCursor
    //   86	8	1	bool	boolean
    //   95	10	2	localObject	Object
    //   106	29	2	localIllegalStateException	java.lang.IllegalStateException
    // Exception table:
    //   from	to	target	type
    //   23	38	95	finally
    //   46	60	95	finally
    //   60	82	95	finally
    //   96	98	95	finally
    //   82	87	106	java/lang/IllegalStateException
  }
  
  public void setSelectionArguments(String[] paramArrayOfString)
  {
    AppMethodBeat.i(12417);
    this.mDriver.setBindArguments(paramArrayOfString);
    AppMethodBeat.o(12417);
  }
  
  public void setWindow(CursorWindow paramCursorWindow)
  {
    AppMethodBeat.i(12416);
    super.setWindow(paramCursorWindow);
    this.mCount = -1;
    AppMethodBeat.o(12416);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteCursor
 * JD-Core Version:    0.7.0.1
 */