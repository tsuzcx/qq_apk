package com.tencent.sqlitelint.behaviour.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.sqlitelint.util.SLog;

public enum c
{
  private volatile a wRE;
  
  private c() {}
  
  public final SQLiteDatabase getDatabase()
  {
    if (this.wRE == null) {
      throw new IllegalStateException("getIssueStorage db not ready");
    }
    return this.wRE.getWritableDatabase();
  }
  
  public final void initialize(Context paramContext)
  {
    if (this.wRE == null) {
      try
      {
        if (this.wRE == null) {
          this.wRE = new a(paramContext);
        }
        return;
      }
      finally {}
    }
  }
  
  private static final class a
    extends SQLiteOpenHelper
  {
    a(Context paramContext)
    {
      super("SQLiteLintInternal.db", null, 1);
    }
    
    public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      int i = 0;
      SLog.i("SQLiteLint.SQLiteLintOwnDatabase", "onCreate", new Object[0]);
      paramSQLiteDatabase.execSQL(a.wRA);
      while (i < a.wRB.length)
      {
        paramSQLiteDatabase.execSQL(a.wRB[i]);
        i += 1;
      }
    }
    
    public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.sqlitelint.behaviour.a.c
 * JD-Core Version:    0.7.0.1
 */