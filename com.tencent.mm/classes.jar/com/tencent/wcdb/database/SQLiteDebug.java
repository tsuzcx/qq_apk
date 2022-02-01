package com.tencent.wcdb.database;

import android.annotation.SuppressLint;
import android.util.Printer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.support.Log;
import java.util.ArrayList;

public final class SQLiteDebug
{
  private static final String TAG = "WCDB.SQLiteDebug";
  private static volatile int sLastErrorLine;
  private static volatile ArrayList<IOTraceStats> sLastIOTraceStats;
  
  static
  {
    AppMethodBeat.i(3237);
    SQLiteGlobal.initialize();
    AppMethodBeat.o(3237);
  }
  
  static void collectLastIOTraceStats(SQLiteConnection paramSQLiteConnection)
  {
    AppMethodBeat.i(3234);
    try
    {
      sLastErrorLine = nativeGetLastErrorLine();
      ArrayList localArrayList = new ArrayList();
      long l = paramSQLiteConnection.getNativeHandle(null);
      if (l != 0L)
      {
        nativeGetIOTraceStats(l, localArrayList);
        paramSQLiteConnection.endNativeHandle(null);
      }
      sLastIOTraceStats = localArrayList;
      AppMethodBeat.o(3234);
      return;
    }
    catch (RuntimeException paramSQLiteConnection)
    {
      Log.e("WCDB.SQLiteDebug", "Cannot collect I/O trace statistics: " + paramSQLiteConnection.getMessage());
      AppMethodBeat.o(3234);
    }
  }
  
  static void collectLastIOTraceStats(SQLiteDatabase paramSQLiteDatabase)
  {
    AppMethodBeat.i(3235);
    try
    {
      sLastErrorLine = nativeGetLastErrorLine();
      ArrayList localArrayList = new ArrayList();
      long l = paramSQLiteDatabase.acquireNativeConnectionHandle("collectIoStat", false, false);
      if (l != 0L) {
        nativeGetIOTraceStats(l, localArrayList);
      }
      paramSQLiteDatabase.releaseNativeConnection(l, null);
      sLastIOTraceStats = localArrayList;
      AppMethodBeat.o(3235);
      return;
    }
    catch (RuntimeException paramSQLiteDatabase)
    {
      Log.e("WCDB.SQLiteDebug", "Cannot collect I/O trace statistics: " + paramSQLiteDatabase.getMessage());
      AppMethodBeat.o(3235);
    }
  }
  
  public static void dump(Printer paramPrinter, String[] paramArrayOfString)
  {
    AppMethodBeat.i(3236);
    int j = paramArrayOfString.length;
    int i = 0;
    boolean bool = false;
    while (i < j)
    {
      if (paramArrayOfString[i].equals("-v")) {
        bool = true;
      }
      i += 1;
    }
    SQLiteDatabase.dumpAll(paramPrinter, bool);
    AppMethodBeat.o(3236);
  }
  
  public static PagerStats getDatabaseInfo()
  {
    AppMethodBeat.i(3232);
    PagerStats localPagerStats = new PagerStats();
    nativeGetPagerStats(localPagerStats);
    localPagerStats.dbStats = SQLiteDatabase.getDbStats();
    AppMethodBeat.o(3232);
    return localPagerStats;
  }
  
  public static int getLastErrorLine()
  {
    return sLastErrorLine;
  }
  
  public static ArrayList<IOTraceStats> getLastIOTraceStats()
  {
    return sLastIOTraceStats;
  }
  
  private static native void nativeGetIOTraceStats(long paramLong, ArrayList<IOTraceStats> paramArrayList);
  
  private static native int nativeGetLastErrorLine();
  
  private static native void nativeGetPagerStats(PagerStats paramPagerStats);
  
  private static native void nativeSetIOTraceFlags(int paramInt);
  
  public static void setIOTraceFlags(int paramInt)
  {
    AppMethodBeat.i(3233);
    nativeSetIOTraceFlags(paramInt);
    AppMethodBeat.o(3233);
  }
  
  public static final boolean shouldLogSlowQuery(long paramLong)
  {
    return paramLong > 300L;
  }
  
  public static class IOTraceStats
  {
    public String dbName;
    public String journalMode;
    public long lastJournalReadOffset;
    public byte[] lastJournalReadPage;
    public long lastJournalWriteOffset;
    public byte[] lastJournalWritePage;
    public long lastReadOffset;
    public byte[] lastReadPage;
    public long lastWriteOffset;
    public byte[] lastWritePage;
    public long pageCount;
    public long pageSize;
    public String path;
    
    @SuppressLint({"DefaultLocale"})
    public String toString()
    {
      AppMethodBeat.i(3231);
      String str = String.format("[%s | %s] pageSize: %d, pageCount: %d, journal: %s, lastRead: %d, lastWrite: %d, lastJournalRead: %d, lastJournalWrite: %d", new Object[] { this.dbName, this.path, Long.valueOf(this.pageSize), Long.valueOf(this.pageCount), this.journalMode, Long.valueOf(this.lastReadOffset), Long.valueOf(this.lastWriteOffset), Long.valueOf(this.lastJournalReadOffset), Long.valueOf(this.lastJournalWriteOffset) });
      AppMethodBeat.o(3231);
      return str;
    }
  }
  
  public static class PagerStats
  {
    public ArrayList<SQLiteDebug.DbStats> dbStats;
    public int largestMemAlloc;
    public int memoryUsed;
    public int pageCacheOverflow;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteDebug
 * JD-Core Version:    0.7.0.1
 */