package com.tencent.mm.plugin.priority.model.a;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.mm.plugin.priority.model.b;
import com.tencent.mm.pluginsdk.j.f;
import com.tencent.mm.protocal.protobuf.dyq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public abstract class a
{
  private b GRO;
  public SQLiteStatement GSp;
  public SQLiteStatement GSq;
  public SQLiteStatement GSr;
  private SQLiteStatement GSs;
  
  public a(b paramb)
  {
    this.GRO = paramb;
    if (this.GRO.ao(foO(), 0L) != 1L)
    {
      if (this.GRO.aHB(getTableName())) {
        this.GRO.aUA(getTableName());
      }
      this.GRO.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (chat TEXT, talker TEXT, date INTEGER, dayreceivecount INTEGER, dayclickcount INTEGER, weekreceivecount INTEGER, weekclickcount INTEGER, monthreceivecount INTEGER, monthclickcount INTEGER, dayclickrate FLOAT, weekclickrate FLOAT, monthclickrate FLOAT, PRIMARY KEY(chat, talker, date));", new Object[] { getTableName() }));
      this.GRO.ap(foO(), 1L);
    }
    for (;;)
    {
      this.GSp = this.GRO.compileStatement(String.format("INSERT OR REPLACE INTO %s (chat, talker, date, dayreceivecount, dayclickcount, weekreceivecount, weekclickcount, monthreceivecount, monthclickcount, dayclickrate, weekclickrate, monthclickrate) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)", new Object[] { getTableName() }));
      this.GSq = this.GRO.compileStatement(String.format("UPDATE %s SET dayreceivecount = ?, weekreceivecount = ?, monthreceivecount = ?, dayclickrate = ?, weekclickrate = ?, monthclickrate = ? WHERE chat = ? AND talker = ? AND date = ?", new Object[] { getTableName() }));
      this.GSr = this.GRO.compileStatement(String.format("UPDATE %s SET dayclickcount = ?, weekclickcount = ?, monthclickcount = ?, dayclickrate = ?, weekclickrate = ?, monthclickrate = ? WHERE chat = ? AND talker = ? AND date = ?", new Object[] { getTableName() }));
      this.GSs = this.GRO.compileStatement(String.format("DELETE FROM %s WHERE chat = ?;", new Object[] { getTableName() }));
      return;
      int i = this.GRO.aUz(getTableName());
      Log.i("MicroMsg.Priority.C2CMsgBaseUsageStorage", "Exist Table %s %d", new Object[] { getTableName(), Integer.valueOf(i) });
    }
  }
  
  private boolean b(String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    dyq localdyq = m(paramString1, paramString2, paramLong);
    if (localdyq != null)
    {
      label156:
      int i;
      String str;
      if (paramBoolean)
      {
        localdyq.Uej += 1;
        localdyq.Uel += 1;
        localdyq.Uen += 1;
        localdyq.Ueo = iR(localdyq.Uej, localdyq.Uei);
        localdyq.Uep = iR(localdyq.Uel, localdyq.Uek);
        localdyq.Ueq = iR(localdyq.Uen, localdyq.Uem);
        if (!paramBoolean) {
          break label442;
        }
        localObject = this.GSr;
        ((SQLiteStatement)localObject).bindLong(1, localdyq.Uej);
        ((SQLiteStatement)localObject).bindLong(2, localdyq.Uel);
        ((SQLiteStatement)localObject).bindLong(3, localdyq.Uen);
        ((SQLiteStatement)localObject).bindDouble(4, localdyq.Ueo);
        ((SQLiteStatement)localObject).bindDouble(5, localdyq.Uep);
        ((SQLiteStatement)localObject).bindDouble(6, localdyq.Ueq);
        ((SQLiteStatement)localObject).bindString(7, localdyq.SjX);
        ((SQLiteStatement)localObject).bindString(8, localdyq.Ueg);
        ((SQLiteStatement)localObject).bindLong(9, localdyq.Ueh);
        i = ((SQLiteStatement)localObject).executeUpdateDelete();
        str = getTableName();
        if (!paramBoolean) {
          break label487;
        }
      }
      label442:
      label487:
      for (Object localObject = "Open";; localObject = "Receive")
      {
        Log.i("MicroMsg.Priority.C2CMsgBaseUsageStorage", "%s Update %s Res %s %s %d %d %d %d %d %d %d DayClickRate %.2f WeekClickRate %.2f MonthClickRate %.2f", new Object[] { str, localObject, paramString1, paramString2, Integer.valueOf(i), Integer.valueOf(localdyq.Uej), Integer.valueOf(localdyq.Uel), Integer.valueOf(localdyq.Uen), Integer.valueOf(localdyq.Uei), Integer.valueOf(localdyq.Uek), Integer.valueOf(localdyq.Uem), Float.valueOf(localdyq.Ueo), Float.valueOf(localdyq.Uep), Float.valueOf(localdyq.Ueq) });
        if (i <= 0) {
          break label494;
        }
        return true;
        localdyq.Uei += 1;
        localdyq.Uek += 1;
        localdyq.Uem += 1;
        break;
        localObject = this.GSq;
        ((SQLiteStatement)localObject).bindLong(1, localdyq.Uei);
        ((SQLiteStatement)localObject).bindLong(2, localdyq.Uek);
        ((SQLiteStatement)localObject).bindLong(3, localdyq.Uem);
        break label156;
      }
      label494:
      return false;
    }
    return false;
  }
  
  private void c(String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    dyq localdyq = new dyq();
    localdyq.SjX = paramString1;
    localdyq.Ueg = paramString2;
    localdyq.Ueh = paramLong;
    Object localObject = String.format("SELECT sum(dayreceivecount), sum(dayclickcount) FROM %s WHERE chat = ? AND talker = ? AND date >= %d", new Object[] { getTableName(), Long.valueOf(paramLong - 2505600000L) });
    localObject = this.GRO.rawQuery((String)localObject, new String[] { paramString1, paramString2 });
    if (((Cursor)localObject).moveToNext())
    {
      localdyq.Uem = ((Cursor)localObject).getInt(0);
      localdyq.Uen = ((Cursor)localObject).getInt(1);
    }
    ((Cursor)localObject).close();
    localObject = String.format("SELECT sum(dayreceivecount), sum(dayclickcount) FROM %s WHERE chat = ? AND talker = ? AND date >= %d", new Object[] { getTableName(), Long.valueOf(paramLong - 518400000L) });
    localObject = this.GRO.rawQuery((String)localObject, new String[] { paramString1, paramString2 });
    if (((Cursor)localObject).moveToNext())
    {
      localdyq.Uek = ((Cursor)localObject).getInt(0);
      localdyq.Uel = ((Cursor)localObject).getInt(1);
    }
    ((Cursor)localObject).close();
    if (paramBoolean)
    {
      localdyq.Uej += 1;
      localdyq.Uen += 1;
      localdyq.Uel += 1;
    }
    for (;;)
    {
      localdyq.Ueo = iR(localdyq.Uej, localdyq.Uei);
      localdyq.Uep = iR(localdyq.Uel, localdyq.Uek);
      localdyq.Ueq = iR(localdyq.Uen, localdyq.Uem);
      this.GSp.bindString(1, localdyq.SjX);
      this.GSp.bindString(2, localdyq.Ueg);
      this.GSp.bindLong(3, localdyq.Ueh);
      this.GSp.bindLong(4, localdyq.Uei);
      this.GSp.bindLong(5, localdyq.Uej);
      this.GSp.bindLong(6, localdyq.Uek);
      this.GSp.bindLong(7, localdyq.Uel);
      this.GSp.bindLong(8, localdyq.Uem);
      this.GSp.bindLong(9, localdyq.Uen);
      this.GSp.bindDouble(10, localdyq.Ueo);
      this.GSp.bindDouble(11, localdyq.Uep);
      this.GSp.bindDouble(12, localdyq.Ueq);
      Log.i("MicroMsg.Priority.C2CMsgBaseUsageStorage", "insert %d usage %s %s %s %d %d %d %d %.2f %.2f", new Object[] { Long.valueOf(this.GSp.executeInsert()), paramString1, paramString2, f.formatTime("yyyy-MM-dd", paramLong / 1000L), Integer.valueOf(localdyq.Uek), Integer.valueOf(localdyq.Uel), Integer.valueOf(localdyq.Uem), Integer.valueOf(localdyq.Uen), Float.valueOf(localdyq.Uep), Float.valueOf(localdyq.Ueq) });
      return;
      localdyq.Uei += 1;
      localdyq.Uem += 1;
      localdyq.Uek += 1;
    }
  }
  
  private static float iR(int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 0) && (paramInt1 > 0)) {
      return 1.0F;
    }
    if ((paramInt2 == 0) && (paramInt1 == 0)) {
      return 0.0F;
    }
    return Math.min(paramInt1 / paramInt2, 1.0F);
  }
  
  private dyq m(String paramString1, String paramString2, long paramLong)
  {
    String str = String.format("SELECT * FROM %s WHERE chat = ? AND talker = ? AND date = ?", new Object[] { getTableName() });
    paramString1 = this.GRO.rawQuery(str, new String[] { paramString1, paramString2, String.valueOf(paramLong) });
    try
    {
      if (paramString1.moveToNext())
      {
        paramString2 = n(paramString1);
        return paramString2;
      }
      return null;
    }
    finally
    {
      paramString1.close();
    }
  }
  
  private float n(String paramString1, String paramString2, long paramLong)
  {
    String str = String.format("SELECT sum(dayreceivecount), sum(dayclickcount) FROM %s WHERE chat = ? AND talker = ? AND date >= %d", new Object[] { getTableName(), Long.valueOf(paramLong - 518400000L) });
    paramString1 = this.GRO.rawQuery(str, new String[] { paramString1, paramString2 });
    try
    {
      if (paramString1.moveToNext())
      {
        int i = paramString1.getInt(0);
        float f = iR(paramString1.getInt(1), i);
        return f;
      }
      return 0.0F;
    }
    finally
    {
      paramString1.close();
    }
  }
  
  private static dyq n(Cursor paramCursor)
  {
    dyq localdyq = new dyq();
    localdyq.SjX = paramCursor.getString(0);
    localdyq.Ueg = paramCursor.getString(1);
    localdyq.Ueh = paramCursor.getLong(2);
    localdyq.Uei = paramCursor.getInt(3);
    localdyq.Uej = paramCursor.getInt(4);
    localdyq.Uek = paramCursor.getInt(5);
    localdyq.Uel = paramCursor.getInt(6);
    localdyq.Uem = paramCursor.getInt(7);
    localdyq.Uen = paramCursor.getInt(8);
    localdyq.Ueo = paramCursor.getFloat(9);
    localdyq.Uep = paramCursor.getFloat(10);
    localdyq.Ueq = paramCursor.getFloat(11);
    return localdyq;
  }
  
  private float o(String paramString1, String paramString2, long paramLong)
  {
    String str = String.format("SELECT sum(dayreceivecount), sum(dayclickcount) FROM %s WHERE chat = ? AND talker = ? AND date >= %d", new Object[] { getTableName(), Long.valueOf(paramLong - 2505600000L) });
    paramString1 = this.GRO.rawQuery(str, new String[] { paramString1, paramString2 });
    try
    {
      if (paramString1.moveToNext())
      {
        int i = paramString1.getInt(0);
        float f = iR(paramString1.getInt(1), i);
        return f;
      }
      return 0.0F;
    }
    finally
    {
      paramString1.close();
    }
  }
  
  public final List<Pair<String, String>> Pe(long paramLong)
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = String.format("SELECT chat, MMSumDivision(dayreceivecount, dayclickcount, 0) FROM %s WHERE date = ? AND ((chat like '%%@chatroom' AND talker = '@all') OR (chat = talker)) GROUP BY chat", new Object[] { getTableName() });
    localObject1 = this.GRO.rawQuery((String)localObject1, new String[] { String.valueOf(paramLong) });
    while (((Cursor)localObject1).moveToNext()) {
      localHashMap.put(((Cursor)localObject1).getString(0), Double.valueOf(((Cursor)localObject1).getDouble(1)));
    }
    ((Cursor)localObject1).close();
    localObject1 = new HashMap();
    Object localObject2 = String.format("SELECT chat, MMSumDivision(dayreceivecount, dayclickcount, 0) FROM %s WHERE date >= ? AND ((chat like '%%@chatroom' AND talker = '@all') OR (chat = talker)) GROUP BY chat", new Object[] { getTableName() });
    localObject2 = this.GRO.rawQuery((String)localObject2, new String[] { String.valueOf(paramLong - 518400000L) });
    while (((Cursor)localObject2).moveToNext()) {
      ((HashMap)localObject1).put(((Cursor)localObject2).getString(0), Double.valueOf(((Cursor)localObject2).getDouble(1)));
    }
    ((Cursor)localObject2).close();
    localObject2 = new HashMap();
    Object localObject3 = String.format("SELECT chat, MMSumDivision(dayreceivecount, dayclickcount, 0) FROM %s WHERE date >= ? AND ((chat like '%%@chatroom' AND talker = '@all') OR (chat = talker)) GROUP BY chat", new Object[] { getTableName() });
    localObject3 = this.GRO.rawQuery((String)localObject3, new String[] { String.valueOf(paramLong - 2505600000L) });
    while (((Cursor)localObject3).moveToNext()) {
      ((HashMap)localObject2).put(((Cursor)localObject3).getString(0), Double.valueOf(((Cursor)localObject3).getDouble(1)));
    }
    ((Cursor)localObject3).close();
    localObject3 = new ArrayList();
    ((List)localObject3).addAll(((HashMap)localObject2).entrySet());
    Collections.sort((List)localObject3, new a.2(this));
    localObject2 = new ArrayList();
    localObject3 = ((List)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
      double d1 = 0.0D;
      if (localHashMap.containsKey(localEntry.getKey())) {
        d1 = ((Double)localHashMap.get(localEntry.getKey())).doubleValue();
      }
      double d2 = 0.0D;
      if (localHashMap.containsKey(localEntry.getKey())) {
        d2 = ((Double)((HashMap)localObject1).get(localEntry.getKey())).doubleValue();
      }
      String str = String.format("%.2f,%.2f,%.2f", new Object[] { Double.valueOf(d1), Double.valueOf(d2), localEntry.getValue() });
      ((List)localObject2).add(new Pair(localEntry.getKey(), str));
    }
    return localObject2;
  }
  
  public final List<dyq> aUB(String paramString)
  {
    Object localObject = String.format("SELECT *, max(monthreceivecount) FROM %s WHERE chat = ? AND talker <> '%s' GROUP BY chat, talker;", new Object[] { getTableName(), "@all" });
    paramString = this.GRO.rawQuery((String)localObject, new String[] { paramString });
    localObject = new ArrayList(10);
    while (paramString.moveToNext()) {
      ((List)localObject).add(n(paramString));
    }
    paramString.close();
    Collections.sort((List)localObject, new Comparator() {});
    return localObject;
  }
  
  public final void aUC(String paramString)
  {
    this.GSs.bindString(1, paramString);
    Log.i("MicroMsg.Priority.C2CMsgBaseUsageStorage", "delete %d img usage %s", new Object[] { Integer.valueOf(this.GSs.executeUpdateDelete()), paramString });
  }
  
  protected abstract long foO();
  
  protected abstract String getTableName();
  
  public final void jB(String paramString1, String paramString2)
  {
    long l = com.tencent.mm.plugin.priority.a.a.a.foJ();
    if (!b(paramString1, paramString2, l, false)) {
      c(paramString1, paramString2, l, false);
    }
  }
  
  public final void jC(String paramString1, String paramString2)
  {
    long l = com.tencent.mm.plugin.priority.a.a.a.foJ();
    if (!b(paramString1, paramString2, l, true)) {
      c(paramString1, paramString2, l, true);
    }
  }
  
  public final double[] jD(String paramString1, String paramString2)
  {
    long l = com.tencent.mm.plugin.priority.a.a.a.foJ();
    Object localObject = String.format("SELECT dayclickrate, weekclickrate, monthclickrate FROM %s WHERE chat = ? AND talker = ? AND date = ?", new Object[] { getTableName() });
    localObject = this.GRO.rawQuery((String)localObject, new String[] { paramString1, paramString2, String.valueOf(l) });
    double[] arrayOfDouble = new double[3];
    if (((Cursor)localObject).moveToNext())
    {
      arrayOfDouble[0] = ((Cursor)localObject).getDouble(0);
      arrayOfDouble[1] = ((Cursor)localObject).getDouble(1);
      arrayOfDouble[2] = ((Cursor)localObject).getDouble(2);
      ((Cursor)localObject).close();
      return arrayOfDouble;
    }
    ((Cursor)localObject).close();
    arrayOfDouble[0] = 0.0D;
    arrayOfDouble[1] = n(paramString1, paramString2, l);
    arrayOfDouble[2] = o(paramString1, paramString2, l);
    return arrayOfDouble;
  }
  
  public final int jE(String paramString1, String paramString2)
  {
    int i = 0;
    long l = com.tencent.mm.plugin.priority.a.a.a.foJ();
    String str = String.format("SELECT dayreceivecount FROM %s WHERE chat = ? AND talker = ? AND date = ?", new Object[] { getTableName() });
    paramString1 = this.GRO.rawQuery(str, new String[] { paramString1, paramString2, String.valueOf(l) });
    if (paramString1.moveToNext()) {
      i = paramString1.getInt(0);
    }
    paramString1.close();
    return i;
  }
  
  public final int jF(String paramString1, String paramString2)
  {
    int i = 0;
    long l = com.tencent.mm.plugin.priority.a.a.a.foJ();
    String str = String.format("SELECT sum(dayreceivecount) FROM %s WHERE chat = ? AND talker = ? AND date >= ?", new Object[] { getTableName() });
    paramString1 = this.GRO.rawQuery(str, new String[] { paramString1, paramString2, String.valueOf(l - 518400000L) });
    if (paramString1.moveToNext()) {
      i = paramString1.getInt(0);
    }
    paramString1.close();
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.a.a
 * JD-Core Version:    0.7.0.1
 */