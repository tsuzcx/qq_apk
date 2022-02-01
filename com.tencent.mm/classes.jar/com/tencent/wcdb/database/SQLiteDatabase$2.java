package com.tencent.wcdb.database;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileFilter;

final class SQLiteDatabase$2
  implements FileFilter
{
  SQLiteDatabase$2(String paramString) {}
  
  public final boolean accept(File paramFile)
  {
    AppMethodBeat.i(3108);
    boolean bool = paramFile.getName().startsWith(this.val$prefix);
    AppMethodBeat.o(3108);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteDatabase.2
 * JD-Core Version:    0.7.0.1
 */