package com.tencent.wcdb.database;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SQLiteDebug$IOTraceStats
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteDebug.IOTraceStats
 * JD-Core Version:    0.7.0.1
 */