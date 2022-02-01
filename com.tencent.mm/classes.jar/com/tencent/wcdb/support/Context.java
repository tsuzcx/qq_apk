package com.tencent.wcdb.support;

import android.content.pm.ApplicationInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.DatabaseErrorHandler;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDatabase.CursorFactory;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.io.File;

public final class Context
{
  public static final int MODE_ENABLE_WRITE_AHEAD_LOGGING = 8;
  
  static
  {
    AppMethodBeat.i(3393);
    SQLiteGlobal.initialize();
    AppMethodBeat.o(3393);
  }
  
  private static File getDataDirFile(android.content.Context paramContext)
  {
    AppMethodBeat.i(3383);
    if (paramContext != null)
    {
      paramContext = paramContext.getApplicationInfo().dataDir;
      if (paramContext != null)
      {
        paramContext = new File(paramContext);
        AppMethodBeat.o(3383);
        return paramContext;
      }
      AppMethodBeat.o(3383);
      return null;
    }
    paramContext = new RuntimeException("Not supported in system context");
    AppMethodBeat.o(3383);
    throw paramContext;
  }
  
  private static File getDatabasesDir(android.content.Context paramContext)
  {
    AppMethodBeat.i(3384);
    File localFile = new File(getDataDirFile(paramContext), "databases");
    paramContext = localFile;
    if (localFile.getPath().equals("databases")) {
      paramContext = new File("/data/system");
    }
    AppMethodBeat.o(3384);
    return paramContext;
  }
  
  private static File makeFilename(File paramFile, String paramString)
  {
    AppMethodBeat.i(3385);
    if (paramString.indexOf(File.separatorChar) < 0)
    {
      paramFile = new File(paramFile, paramString);
      AppMethodBeat.o(3385);
      return paramFile;
    }
    paramFile = new IllegalArgumentException("File " + paramString + " contains a path separator");
    AppMethodBeat.o(3385);
    throw paramFile;
  }
  
  public static SQLiteDatabase openOrCreateDatabase(android.content.Context paramContext, String paramString, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory)
  {
    AppMethodBeat.i(3388);
    paramContext = openOrCreateDatabase(paramContext, paramString, null, null, paramInt, paramCursorFactory, null, 0);
    AppMethodBeat.o(3388);
    return paramContext;
  }
  
  public static SQLiteDatabase openOrCreateDatabase(android.content.Context paramContext, String paramString, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    AppMethodBeat.i(3389);
    paramContext = openOrCreateDatabase(paramContext, paramString, null, null, paramInt, paramCursorFactory, paramDatabaseErrorHandler, 0);
    AppMethodBeat.o(3389);
    return paramContext;
  }
  
  public static SQLiteDatabase openOrCreateDatabase(android.content.Context paramContext, String paramString, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory)
  {
    AppMethodBeat.i(3390);
    paramContext = openOrCreateDatabase(paramContext, paramString, paramArrayOfByte, paramSQLiteCipherSpec, paramInt, paramCursorFactory, null, 0);
    AppMethodBeat.o(3390);
    return paramContext;
  }
  
  public static SQLiteDatabase openOrCreateDatabase(android.content.Context paramContext, String paramString, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    AppMethodBeat.i(3391);
    paramContext = openOrCreateDatabase(paramContext, paramString, paramArrayOfByte, paramSQLiteCipherSpec, paramInt, paramCursorFactory, paramDatabaseErrorHandler, 0);
    AppMethodBeat.o(3391);
    return paramContext;
  }
  
  public static SQLiteDatabase openOrCreateDatabase(android.content.Context paramContext, String paramString, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, int paramInt1, SQLiteDatabase.CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler, int paramInt2)
  {
    AppMethodBeat.i(3392);
    paramContext = validateFilePath(paramContext, paramString, true);
    int i = 268435456;
    if ((paramInt1 & 0x8) != 0) {
      i = 805306368;
    }
    paramString = SQLiteDatabase.openDatabase(paramContext.getPath(), paramArrayOfByte, paramSQLiteCipherSpec, paramCursorFactory, i, paramDatabaseErrorHandler, paramInt2);
    setFilePermissionsFromMode(paramContext.getPath(), paramInt1, 0);
    AppMethodBeat.o(3392);
    return paramString;
  }
  
  private static void setFilePermissionsFromMode(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(3387);
    int i = paramInt2 | 0x1B0;
    paramInt2 = i;
    if ((paramInt1 & 0x1) != 0) {
      paramInt2 = i | 0x4;
    }
    i = paramInt2;
    if ((paramInt1 & 0x2) != 0) {
      i = paramInt2 | 0x2;
    }
    FileUtils.setPermissions(paramString, i, -1, -1);
    AppMethodBeat.o(3387);
  }
  
  private static File validateFilePath(android.content.Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(3386);
    File localFile;
    if (paramString.charAt(0) == File.separatorChar)
    {
      paramContext = new File(paramString.substring(0, paramString.lastIndexOf(File.separatorChar)));
      localFile = new File(paramContext, paramString.substring(paramString.lastIndexOf(File.separatorChar)));
      paramString = paramContext;
      paramContext = localFile;
    }
    for (;;)
    {
      if ((paramBoolean) && (!paramString.isDirectory()) && (paramString.mkdir())) {
        FileUtils.setPermissions(paramString.getPath(), 505, -1, -1);
      }
      AppMethodBeat.o(3386);
      return paramContext;
      localFile = getDatabasesDir(paramContext);
      paramContext = makeFilename(localFile, paramString);
      paramString = localFile;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wcdb.support.Context
 * JD-Core Version:    0.7.0.1
 */