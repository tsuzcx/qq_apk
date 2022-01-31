package com.tencent.mm.plugin.sport.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.j;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class m
  extends j<com.tencent.mm.plugin.sport.a.e>
{
  public static final String[] spZ;
  private static final String[] sqa;
  
  static
  {
    AppMethodBeat.i(93707);
    spZ = new String[] { j.getCreateSQLs(com.tencent.mm.plugin.sport.a.e.info, "SportStepItem") };
    sqa = new String[] { String.format("CREATE INDEX IF NOT EXISTS %s_date ON %s(date);", new Object[] { "SportStepItem", "SportStepItem" }), String.format("CREATE INDEX IF NOT EXISTS %s_timestamp ON %s(timestamp);", new Object[] { "SportStepItem", "SportStepItem" }) };
    AppMethodBeat.o(93707);
  }
  
  public m()
  {
    super(g.RL().eHS, com.tencent.mm.plugin.sport.a.e.info, "SportStepItem", sqa);
    AppMethodBeat.i(93701);
    AppMethodBeat.o(93701);
  }
  
  public static List<com.tencent.mm.plugin.sport.a.e> Y(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(93702);
    ArrayList localArrayList = new ArrayList();
    Object localObject = String.format("SELECT * FROM %s WHERE timestamp >= ? AND timestamp <= ?;", new Object[] { "SportStepItem" });
    localObject = g.RL().eHS.a((String)localObject, new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) }, 0);
    while (((Cursor)localObject).moveToNext())
    {
      com.tencent.mm.plugin.sport.a.e locale = new com.tencent.mm.plugin.sport.a.e();
      locale.convertFrom((Cursor)localObject);
      localArrayList.add(locale);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(93702);
    return localArrayList;
  }
  
  public static void Z(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(93705);
    String str = String.format("DELETE FROM %s WHERE timestamp >= %d AND timestamp <= endTime", new Object[] { "SportStepItem", Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    g.RL().eHS.execSQL(null, str);
    AppMethodBeat.o(93705);
  }
  
  public static com.tencent.mm.plugin.sport.a.e cyx()
  {
    AppMethodBeat.i(93703);
    Object localObject1 = String.format("SELECT * FROM %s ORDER BY timestamp desc LIMIT 1;", new Object[] { "SportStepItem" });
    localObject1 = g.RL().eHS.a((String)localObject1, null, 0);
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        com.tencent.mm.plugin.sport.a.e locale = new com.tencent.mm.plugin.sport.a.e();
        locale.convertFrom((Cursor)localObject1);
        return locale;
      }
      return null;
    }
    finally
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(93703);
    }
  }
  
  public static void cyy()
  {
    AppMethodBeat.i(93704);
    String str = String.format("DELETE FROM %s;", new Object[] { "SportStepItem" });
    g.RL().eHS.execSQL(null, str);
    AppMethodBeat.o(93704);
  }
  
  public static void dy(List<com.tencent.mm.plugin.sport.a.e> paramList)
  {
    AppMethodBeat.i(93706);
    SQLiteDatabase localSQLiteDatabase = g.RL().eHS.dzV();
    if (!localSQLiteDatabase.inTransaction()) {
      localSQLiteDatabase.beginTransaction();
    }
    SQLiteStatement localSQLiteStatement = localSQLiteDatabase.compileStatement(String.format("INSERT INTO %s (date, step, timestamp) VALUES (?,?,?)", new Object[] { "SportStepItem" }));
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      com.tencent.mm.plugin.sport.a.e locale = (com.tencent.mm.plugin.sport.a.e)paramList.next();
      localSQLiteStatement.bindString(1, locale.field_date);
      localSQLiteStatement.bindLong(2, locale.field_step);
      localSQLiteStatement.bindLong(3, locale.field_timestamp);
      localSQLiteStatement.execute();
    }
    if (localSQLiteDatabase.inTransaction())
    {
      localSQLiteDatabase.setTransactionSuccessful();
      localSQLiteDatabase.endTransaction();
    }
    AppMethodBeat.o(93706);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.m
 * JD-Core Version:    0.7.0.1
 */