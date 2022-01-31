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
    AppMethodBeat.i(12582);
    if (!WCDBInitializationProbe.libLoaded) {
      System.loadLibrary("wcdb");
    }
    try
    {
      i = new StatFs(Environment.getDataDirectory().getAbsolutePath()).getBlockSize();
      defaultPageSize = i;
      nativeSetDefaultCipherSettings(i);
      AppMethodBeat.o(12582);
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
  
  public static void loadLib() {}
  
  private static native int nativeReleaseMemory();
  
  private static native void nativeSetDefaultCipherSettings(int paramInt);
  
  public static int releaseMemory()
  {
    AppMethodBeat.i(12581);
    int i = nativeReleaseMemory();
    AppMethodBeat.o(12581);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteGlobal
 * JD-Core Version:    0.7.0.1
 */