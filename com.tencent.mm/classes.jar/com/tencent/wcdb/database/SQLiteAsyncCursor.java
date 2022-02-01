package com.tencent.wcdb.database;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.AbstractCursor;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.CursorIndexOutOfBoundsException;
import com.tencent.wcdb.StaleDataException;
import com.tencent.wcdb.support.CancellationSignal;

public class SQLiteAsyncCursor
  extends AbstractCursor
{
  public static final SQLiteDatabase.CursorFactory FACTORY;
  private static final int MAX_KEEP_CHUNKS = 32;
  private static final int MAX_PREFETCH = 256;
  private static final int MIN_FETCH_ROWS = 32;
  private static final String TAG = "WCDB.SQLiteAsyncCursor";
  private final String[] mColumns;
  private volatile int mCount;
  private long mCurrentRow;
  private final SQLiteCursorDriver mDriver;
  private final SQLiteAsyncQuery mQuery;
  private QueryThread mQueryThread;
  private final Object mWaitLock;
  private ChunkedCursorWindow mWindow;
  
  static
  {
    AppMethodBeat.i(2944);
    FACTORY = new SQLiteDatabase.CursorFactory()
    {
      public final Cursor newCursor(SQLiteDatabase paramAnonymousSQLiteDatabase, SQLiteCursorDriver paramAnonymousSQLiteCursorDriver, String paramAnonymousString, SQLiteProgram paramAnonymousSQLiteProgram)
      {
        AppMethodBeat.i(2920);
        paramAnonymousSQLiteDatabase = new SQLiteAsyncCursor(paramAnonymousSQLiteCursorDriver, paramAnonymousString, (SQLiteAsyncQuery)paramAnonymousSQLiteProgram);
        AppMethodBeat.o(2920);
        return paramAnonymousSQLiteDatabase;
      }
      
      public final SQLiteProgram newQuery(SQLiteDatabase paramAnonymousSQLiteDatabase, String paramAnonymousString, Object[] paramAnonymousArrayOfObject, CancellationSignal paramAnonymousCancellationSignal)
      {
        AppMethodBeat.i(2921);
        paramAnonymousSQLiteDatabase = new SQLiteAsyncQuery(paramAnonymousSQLiteDatabase, paramAnonymousString, paramAnonymousArrayOfObject, paramAnonymousCancellationSignal);
        AppMethodBeat.o(2921);
        return paramAnonymousSQLiteDatabase;
      }
    };
    AppMethodBeat.o(2944);
  }
  
  public SQLiteAsyncCursor(SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteAsyncQuery paramSQLiteAsyncQuery)
  {
    AppMethodBeat.i(2925);
    if (paramSQLiteAsyncQuery == null)
    {
      paramSQLiteCursorDriver = new IllegalArgumentException("query object cannot be null");
      AppMethodBeat.o(2925);
      throw paramSQLiteCursorDriver;
    }
    this.mQuery = paramSQLiteAsyncQuery;
    this.mDriver = paramSQLiteCursorDriver;
    this.mColumns = paramSQLiteAsyncQuery.getColumnNames();
    this.mCount = -1;
    this.mWaitLock = new Object();
    this.mWindow = new ChunkedCursorWindow(16777216);
    this.mQueryThread = new QueryThread();
    this.mQueryThread.start();
    AppMethodBeat.o(2925);
  }
  
  private void checkValidRow()
  {
    AppMethodBeat.i(2933);
    if (this.mCurrentRow != 0L)
    {
      AppMethodBeat.o(2933);
      return;
    }
    if (!isValidPosition(this.mPos))
    {
      localObject = new CursorIndexOutOfBoundsException(this.mPos, this.mCount);
      AppMethodBeat.o(2933);
      throw ((Throwable)localObject);
    }
    Object localObject = new StaleDataException("Cannot get valid Row object");
    AppMethodBeat.o(2933);
    throw ((Throwable)localObject);
  }
  
  private boolean isValidPosition(int paramInt)
  {
    AppMethodBeat.i(2930);
    if ((paramInt >= 0) && (paramInt < getCount()))
    {
      AppMethodBeat.o(2930);
      return true;
    }
    AppMethodBeat.o(2930);
    return false;
  }
  
  private boolean requestRow()
  {
    AppMethodBeat.i(2932);
    if (this.mWindow == null)
    {
      AppMethodBeat.o(2932);
      return false;
    }
    if (!isValidPosition(this.mPos))
    {
      AppMethodBeat.o(2932);
      return false;
    }
    this.mQueryThread.requestPos(this.mPos);
    this.mCurrentRow = this.mWindow.getRowUnsafe(this.mPos);
    if (this.mCurrentRow == 0L) {
      this.mCurrentRow = waitForRow(this.mPos);
    }
    if (this.mCurrentRow != 0L)
    {
      AppMethodBeat.o(2932);
      return true;
    }
    AppMethodBeat.o(2932);
    return false;
  }
  
  private long waitForRow(int paramInt)
  {
    AppMethodBeat.i(2931);
    long l;
    for (;;)
    {
      try
      {
        synchronized (this.mWaitLock)
        {
          l = this.mWindow.getRowUnsafe(paramInt);
          if (l != 0L) {
            break;
          }
          if (!isValidPosition(paramInt))
          {
            CursorIndexOutOfBoundsException localCursorIndexOutOfBoundsException = new CursorIndexOutOfBoundsException(this.mPos, this.mCount);
            AppMethodBeat.o(2931);
            throw localCursorIndexOutOfBoundsException;
          }
        }
        this.mWaitLock.wait();
      }
      catch (InterruptedException localInterruptedException)
      {
        AppMethodBeat.o(2931);
        return 0L;
      }
    }
    AppMethodBeat.o(2931);
    return l;
  }
  
  public void close()
  {
    AppMethodBeat.i(2926);
    super.close();
    this.mQuery.close();
    this.mDriver.cursorClosed();
    AppMethodBeat.o(2926);
  }
  
  public void deactivate()
  {
    AppMethodBeat.i(2927);
    super.deactivate();
    this.mDriver.cursorDeactivated();
    AppMethodBeat.o(2927);
  }
  
  public byte[] getBlob(int paramInt)
  {
    AppMethodBeat.i(2936);
    checkValidRow();
    byte[] arrayOfByte = this.mWindow.getBlobUnsafe(this.mCurrentRow, paramInt);
    AppMethodBeat.o(2936);
    return arrayOfByte;
  }
  
  public String[] getColumnNames()
  {
    return this.mColumns;
  }
  
  public int getCount()
  {
    AppMethodBeat.i(2929);
    int i;
    if (this.mCount >= 0)
    {
      i = this.mCount;
      AppMethodBeat.o(2929);
      return i;
    }
    if (this.mWindow == null)
    {
      AppMethodBeat.o(2929);
      return -1;
    }
    try
    {
      synchronized (this.mWaitLock)
      {
        if (this.mCount >= 0) {
          break label90;
        }
        this.mWaitLock.wait();
      }
      i = this.mCount;
    }
    catch (InterruptedException localInterruptedException) {}
    label90:
    for (;;)
    {
      AppMethodBeat.o(2929);
      return i;
    }
  }
  
  public double getDouble(int paramInt)
  {
    AppMethodBeat.i(2942);
    checkValidRow();
    double d = this.mWindow.getDoubleUnsafe(this.mCurrentRow, paramInt);
    AppMethodBeat.o(2942);
    return d;
  }
  
  public float getFloat(int paramInt)
  {
    AppMethodBeat.i(2941);
    float f = (float)getDouble(paramInt);
    AppMethodBeat.o(2941);
    return f;
  }
  
  public int getInt(int paramInt)
  {
    AppMethodBeat.i(2939);
    paramInt = (int)getLong(paramInt);
    AppMethodBeat.o(2939);
    return paramInt;
  }
  
  public long getLong(int paramInt)
  {
    AppMethodBeat.i(2940);
    checkValidRow();
    long l = this.mWindow.getLongUnsafe(this.mCurrentRow, paramInt);
    AppMethodBeat.o(2940);
    return l;
  }
  
  public short getShort(int paramInt)
  {
    AppMethodBeat.i(2938);
    short s = (short)(int)getLong(paramInt);
    AppMethodBeat.o(2938);
    return s;
  }
  
  public String getString(int paramInt)
  {
    AppMethodBeat.i(2937);
    checkValidRow();
    String str = this.mWindow.getStringUnsafe(this.mCurrentRow, paramInt);
    AppMethodBeat.o(2937);
    return str;
  }
  
  public int getType(int paramInt)
  {
    AppMethodBeat.i(2935);
    checkValidRow();
    paramInt = this.mWindow.getTypeUnsafe(this.mCurrentRow, paramInt);
    AppMethodBeat.o(2935);
    return paramInt;
  }
  
  public boolean isNull(int paramInt)
  {
    AppMethodBeat.i(2943);
    if (getType(paramInt) == 0)
    {
      AppMethodBeat.o(2943);
      return true;
    }
    AppMethodBeat.o(2943);
    return false;
  }
  
  public boolean moveToPosition(int paramInt)
  {
    AppMethodBeat.i(2934);
    int i = paramInt;
    if (paramInt < -1) {
      i = -1;
    }
    if (i != this.mPos)
    {
      this.mWindow.endRowUnsafe(this.mCurrentRow);
      this.mCurrentRow = 0L;
    }
    paramInt = getCount();
    if (i >= paramInt)
    {
      this.mPos = paramInt;
      AppMethodBeat.o(2934);
      return false;
    }
    this.mPos = i;
    if ((i >= 0) && (requestRow()))
    {
      AppMethodBeat.o(2934);
      return true;
    }
    AppMethodBeat.o(2934);
    return false;
  }
  
  public void onDeactivateOrClose()
  {
    AppMethodBeat.i(2928);
    if (this.mCurrentRow != 0L)
    {
      this.mWindow.endRowUnsafe(this.mCurrentRow);
      this.mCurrentRow = 0L;
    }
    if (this.mQueryThread != null) {
      this.mQueryThread.quit();
    }
    try
    {
      this.mQueryThread.join();
      label52:
      this.mQueryThread = null;
      if (this.mWindow != null)
      {
        this.mWindow.close();
        this.mWindow = null;
      }
      this.mCount = -1;
      this.mPos = -1;
      super.onDeactivateOrClose();
      AppMethodBeat.o(2928);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label52;
    }
  }
  
  class QueryThread
    extends Thread
  {
    private int mFetchPos = 0;
    private int mMinPos = 0;
    private volatile int mRequestPos = 0;
    
    QueryThread()
    {
      super();
    }
    
    void quit()
    {
      AppMethodBeat.i(2924);
      interrupt();
      AppMethodBeat.o(2924);
    }
    
    void requestPos(int paramInt)
    {
      AppMethodBeat.i(2923);
      try
      {
        this.mRequestPos = paramInt;
        notifyAll();
        return;
      }
      finally
      {
        AppMethodBeat.o(2923);
      }
    }
    
    public void run()
    {
      AppMethodBeat.i(2922);
      for (;;)
      {
        int i;
        try
        {
          i = SQLiteAsyncCursor.this.mQuery.getCount();
          i = this.mRequestPos;
        }
        catch (InterruptedException localInterruptedException) {}finally
        {
          SQLiteAsyncCursor.this.mQuery.release();
          AppMethodBeat.o(2922);
        }
        if (i < this.mMinPos)
        {
          SQLiteAsyncCursor.this.mQuery.reset();
          this.mFetchPos = 0;
          SQLiteAsyncCursor.this.mWindow.clear();
          this.mMinPos = 0;
        }
        if (this.mFetchPos < i + 256)
        {
          if (SQLiteAsyncCursor.this.mWindow.getNumChunks() > 32)
          {
            long l = SQLiteAsyncCursor.this.mWindow.removeChunk(this.mMinPos);
            if (l != -1L) {
              this.mMinPos = ((int)l);
            }
          }
          synchronized (SQLiteAsyncCursor.this.mWaitLock)
          {
            int j = SQLiteAsyncCursor.this.mQuery.fillRows(SQLiteAsyncCursor.this.mWindow, this.mFetchPos, 32);
            if ((this.mFetchPos <= i) && (this.mFetchPos + j > i)) {
              SQLiteAsyncCursor.this.mWaitLock.notifyAll();
            }
            this.mFetchPos += j;
          }
        }
      }
      SQLiteAsyncCursor.this.mQuery.release();
      AppMethodBeat.o(2922);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteAsyncCursor
 * JD-Core Version:    0.7.0.1
 */