package com.tencent.wcdb.database;

import android.os.Environment;
import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class SQLiteGlobal
{
  private static final String TAG = "WCDB.SQLiteGlobal";
  public static final String defaultJournalMode = "PERSIST";
  public static final int defaultPageSize;
  public static final String defaultSyncMode = "FULL";
  public static final int journalSizeLimit = 524288;
  public static final int walAutoCheckpoint = 100;
  public static final int walConnectionPoolSize = 4;
  public static final String walSyncMode = "FULL";
  
  static
  {
    AppMethodBeat.i(3268);
    if (!WCDBInitializationProbe.libLoaded) {
      System.loadLibrary("wcdb");
    }
    try
    {
      i = new StatFs(Environment.getDataDirectory().getAbsolutePath()).getBlockSize();
      defaultPageSize = i;
      AppMethodBeat.o(3268);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        int i = 4096;
      }
    }
  }
  
  public static void initialize()
  {
    AppMethodBeat.i(188621);
    Initializer.init();
    AppMethodBeat.o(188621);
  }
  
  public static void loadLib() {}
  
  private static native void nativeInitialize(int paramInt);
  
  private static native int nativeReleaseMemory();
  
  public static int releaseMemory()
  {
    AppMethodBeat.i(3267);
    int i = nativeReleaseMemory();
    AppMethodBeat.o(3267);
    return i;
  }
  
  static class Initializer
  {
    static
    {
      AppMethodBeat.i(188604);
      SQLiteGlobal.access$000(SQLiteGlobal.defaultPageSize);
      AppMethodBeat.o(188604);
    }
    
    static void init() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteGlobal
 * JD-Core Version:    0.7.0.1
 */