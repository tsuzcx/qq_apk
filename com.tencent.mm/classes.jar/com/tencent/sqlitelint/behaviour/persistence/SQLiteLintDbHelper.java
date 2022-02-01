package com.tencent.sqlitelint.behaviour.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.util.SLog;

public enum SQLiteLintDbHelper
{
  private static final String DB_NAME = "SQLiteLintInternal.db";
  private static final String TAG = "SQLiteLint.SQLiteLintOwnDatabase";
  private static final int VERSION_1 = 1;
  private volatile InternalDbHelper mHelper;
  
  static
  {
    AppMethodBeat.i(52928);
    INSTANCE = new SQLiteLintDbHelper("INSTANCE", 0);
    $VALUES = new SQLiteLintDbHelper[] { INSTANCE };
    AppMethodBeat.o(52928);
  }
  
  private SQLiteLintDbHelper() {}
  
  public final SQLiteDatabase getDatabase()
  {
    AppMethodBeat.i(52926);
    if (this.mHelper == null)
    {
      localObject = new IllegalStateException("getIssueStorage db not ready");
      AppMethodBeat.o(52926);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mHelper.getWritableDatabase();
    AppMethodBeat.o(52926);
    return localObject;
  }
  
  public final void initialize(Context paramContext)
  {
    AppMethodBeat.i(52927);
    if (this.mHelper == null) {
      try
      {
        if (this.mHelper == null) {
          this.mHelper = new InternalDbHelper(paramContext);
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(52927);
      }
    }
    AppMethodBeat.o(52927);
  }
  
  static final class InternalDbHelper
    extends SQLiteOpenHelper
  {
    private static final String DB_NAME = "SQLiteLintInternal.db";
    private static final int VERSION_1 = 1;
    
    InternalDbHelper(Context paramContext)
    {
      super("SQLiteLintInternal.db", null, 1);
    }
    
    public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      int i = 0;
      AppMethodBeat.i(52923);
      SLog.i("SQLiteLint.SQLiteLintOwnDatabase", "onCreate", new Object[0]);
      paramSQLiteDatabase.execSQL(IssueStorage.DB_VERSION_1_CREATE_SQL);
      while (i < IssueStorage.DB_VERSION_1_CREATE_INDEX.length)
      {
        paramSQLiteDatabase.execSQL(IssueStorage.DB_VERSION_1_CREATE_INDEX[i]);
        i += 1;
      }
      AppMethodBeat.o(52923);
    }
    
    public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.sqlitelint.behaviour.persistence.SQLiteLintDbHelper
 * JD-Core Version:    0.7.0.1
 */