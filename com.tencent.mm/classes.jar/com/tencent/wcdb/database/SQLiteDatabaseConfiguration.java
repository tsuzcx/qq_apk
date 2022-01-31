package com.tencent.wcdb.database;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.extension.SQLiteExtension;
import java.util.LinkedHashSet;
import java.util.Locale;

public final class SQLiteDatabaseConfiguration
{
  public static final String MEMORY_DB_PATH = ":memory:";
  public boolean customWALHookEnabled;
  public final LinkedHashSet<SQLiteExtension> extensions;
  public boolean foreignKeyConstraintsEnabled;
  public final String label;
  public Locale locale;
  public int maxSqlCacheSize;
  public int openFlags;
  public final String path;
  public int synchronousMode;
  public boolean updateNotificationEnabled;
  public boolean updateNotificationRowID;
  public String vfsName;
  
  public SQLiteDatabaseConfiguration(SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration)
  {
    AppMethodBeat.i(12541);
    this.extensions = new LinkedHashSet();
    if (paramSQLiteDatabaseConfiguration == null)
    {
      paramSQLiteDatabaseConfiguration = new IllegalArgumentException("other must not be null.");
      AppMethodBeat.o(12541);
      throw paramSQLiteDatabaseConfiguration;
    }
    this.path = paramSQLiteDatabaseConfiguration.path;
    this.label = paramSQLiteDatabaseConfiguration.label;
    updateParametersFrom(paramSQLiteDatabaseConfiguration);
    AppMethodBeat.o(12541);
  }
  
  public SQLiteDatabaseConfiguration(String paramString, int paramInt)
  {
    AppMethodBeat.i(12540);
    this.extensions = new LinkedHashSet();
    if (paramString == null)
    {
      paramString = new IllegalArgumentException("path must not be null.");
      AppMethodBeat.o(12540);
      throw paramString;
    }
    this.path = paramString;
    this.label = paramString;
    this.openFlags = paramInt;
    this.synchronousMode = 2;
    this.maxSqlCacheSize = 25;
    this.locale = Locale.getDefault();
    if ((paramInt & 0x100) != 0) {}
    for (paramString = "vfslog";; paramString = null)
    {
      this.vfsName = paramString;
      AppMethodBeat.o(12540);
      return;
    }
  }
  
  public final boolean isInMemoryDb()
  {
    AppMethodBeat.i(12543);
    boolean bool = this.path.equalsIgnoreCase(":memory:");
    AppMethodBeat.o(12543);
    return bool;
  }
  
  public final void updateParametersFrom(SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration)
  {
    AppMethodBeat.i(12542);
    if (paramSQLiteDatabaseConfiguration == null)
    {
      paramSQLiteDatabaseConfiguration = new IllegalArgumentException("other must not be null.");
      AppMethodBeat.o(12542);
      throw paramSQLiteDatabaseConfiguration;
    }
    if (!this.path.equals(paramSQLiteDatabaseConfiguration.path))
    {
      paramSQLiteDatabaseConfiguration = new IllegalArgumentException("other configuration must refer to the same database.");
      AppMethodBeat.o(12542);
      throw paramSQLiteDatabaseConfiguration;
    }
    this.openFlags = paramSQLiteDatabaseConfiguration.openFlags;
    this.maxSqlCacheSize = paramSQLiteDatabaseConfiguration.maxSqlCacheSize;
    this.locale = paramSQLiteDatabaseConfiguration.locale;
    this.foreignKeyConstraintsEnabled = paramSQLiteDatabaseConfiguration.foreignKeyConstraintsEnabled;
    this.customWALHookEnabled = paramSQLiteDatabaseConfiguration.customWALHookEnabled;
    this.updateNotificationEnabled = paramSQLiteDatabaseConfiguration.updateNotificationEnabled;
    this.updateNotificationRowID = paramSQLiteDatabaseConfiguration.updateNotificationRowID;
    this.synchronousMode = paramSQLiteDatabaseConfiguration.synchronousMode;
    this.vfsName = paramSQLiteDatabaseConfiguration.vfsName;
    this.extensions.clear();
    this.extensions.addAll(paramSQLiteDatabaseConfiguration.extensions);
    AppMethodBeat.o(12542);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteDatabaseConfiguration
 * JD-Core Version:    0.7.0.1
 */