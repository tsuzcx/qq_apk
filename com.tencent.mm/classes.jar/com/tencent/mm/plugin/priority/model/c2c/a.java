package com.tencent.mm.plugin.priority.model.c2c;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.mm.plugin.priority.model.b;
import com.tencent.mm.pluginsdk.platformtools.f;
import com.tencent.mm.protocal.protobuf.eru;
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
  public SQLiteStatement MPT;
  public SQLiteStatement MPU;
  public SQLiteStatement MPV;
  private SQLiteStatement MPW;
  private b MPs;
  
  public a(b paramb)
  {
    this.MPs = paramb;
    if (this.MPs.aY(gzR(), 0L) != gzS())
    {
      if (this.MPs.aDZ(getTableName())) {
        this.MPs.aRI(getTableName());
      }
      this.MPs.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (chat TEXT, talker TEXT, date INTEGER, dayreceivecount INTEGER, dayclickcount INTEGER, weekreceivecount INTEGER, weekclickcount INTEGER, monthreceivecount INTEGER, monthclickcount INTEGER, dayclickrate FLOAT, weekclickrate FLOAT, monthclickrate FLOAT, PRIMARY KEY(chat, talker, date));", new Object[] { getTableName() }));
      this.MPs.aZ(gzR(), gzS());
    }
    for (;;)
    {
      this.MPT = this.MPs.compileStatement(String.format("INSERT OR REPLACE INTO %s (chat, talker, date, dayreceivecount, dayclickcount, weekreceivecount, weekclickcount, monthreceivecount, monthclickcount, dayclickrate, weekclickrate, monthclickrate) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)", new Object[] { getTableName() }));
      this.MPU = this.MPs.compileStatement(String.format("UPDATE %s SET dayreceivecount = ?, weekreceivecount = ?, monthreceivecount = ?, dayclickrate = ?, weekclickrate = ?, monthclickrate = ? WHERE chat = ? AND talker = ? AND date = ?", new Object[] { getTableName() }));
      this.MPV = this.MPs.compileStatement(String.format("UPDATE %s SET dayclickcount = ?, weekclickcount = ?, monthclickcount = ?, dayclickrate = ?, weekclickrate = ?, monthclickrate = ? WHERE chat = ? AND talker = ? AND date = ?", new Object[] { getTableName() }));
      this.MPW = this.MPs.compileStatement(String.format("DELETE FROM %s WHERE chat = ?;", new Object[] { getTableName() }));
      return;
      int i = this.MPs.aRH(getTableName());
      Log.i("MicroMsg.Priority.C2CMsgBaseUsageStorage", "Exist Table %s %d", new Object[] { getTableName(), Integer.valueOf(i) });
    }
  }
  
  private boolean c(String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    eru localeru = n(paramString1, paramString2, paramLong);
    if (localeru != null)
    {
      label156:
      int i;
      String str;
      if (paramBoolean)
      {
        localeru.abvx += 1;
        localeru.abvz += 1;
        localeru.abvB += 1;
        localeru.abvC = kx(localeru.abvx, localeru.abvw);
        localeru.abvD = kx(localeru.abvz, localeru.abvy);
        localeru.abvE = kx(localeru.abvB, localeru.abvA);
        if (!paramBoolean) {
          break label442;
        }
        localObject = this.MPV;
        ((SQLiteStatement)localObject).bindLong(1, localeru.abvx);
        ((SQLiteStatement)localObject).bindLong(2, localeru.abvz);
        ((SQLiteStatement)localObject).bindLong(3, localeru.abvB);
        ((SQLiteStatement)localObject).bindDouble(4, localeru.abvC);
        ((SQLiteStatement)localObject).bindDouble(5, localeru.abvD);
        ((SQLiteStatement)localObject).bindDouble(6, localeru.abvE);
        ((SQLiteStatement)localObject).bindString(7, localeru.Zid);
        ((SQLiteStatement)localObject).bindString(8, localeru.abvu);
        ((SQLiteStatement)localObject).bindLong(9, localeru.abvv);
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
        Log.i("MicroMsg.Priority.C2CMsgBaseUsageStorage", "%s Update %s Res %s %s %d %d %d %d %d %d %d DayClickRate %.2f WeekClickRate %.2f MonthClickRate %.2f", new Object[] { str, localObject, paramString1, paramString2, Integer.valueOf(i), Integer.valueOf(localeru.abvx), Integer.valueOf(localeru.abvz), Integer.valueOf(localeru.abvB), Integer.valueOf(localeru.abvw), Integer.valueOf(localeru.abvy), Integer.valueOf(localeru.abvA), Float.valueOf(localeru.abvC), Float.valueOf(localeru.abvD), Float.valueOf(localeru.abvE) });
        if (i <= 0) {
          break label494;
        }
        return true;
        localeru.abvw += 1;
        localeru.abvy += 1;
        localeru.abvA += 1;
        break;
        localObject = this.MPU;
        ((SQLiteStatement)localObject).bindLong(1, localeru.abvw);
        ((SQLiteStatement)localObject).bindLong(2, localeru.abvy);
        ((SQLiteStatement)localObject).bindLong(3, localeru.abvA);
        break label156;
      }
      label494:
      return false;
    }
    return false;
  }
  
  private void d(String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    eru localeru = new eru();
    localeru.Zid = paramString1;
    localeru.abvu = paramString2;
    localeru.abvv = paramLong;
    Object localObject = String.format("SELECT sum(dayreceivecount), sum(dayclickcount) FROM %s WHERE chat = ? AND talker = ? AND date >= %d", new Object[] { getTableName(), Long.valueOf(paramLong - 2505600000L) });
    localObject = this.MPs.rawQuery((String)localObject, new String[] { paramString1, paramString2 });
    if (((Cursor)localObject).moveToNext())
    {
      localeru.abvA = ((Cursor)localObject).getInt(0);
      localeru.abvB = ((Cursor)localObject).getInt(1);
    }
    ((Cursor)localObject).close();
    localObject = String.format("SELECT sum(dayreceivecount), sum(dayclickcount) FROM %s WHERE chat = ? AND talker = ? AND date >= %d", new Object[] { getTableName(), Long.valueOf(paramLong - 518400000L) });
    localObject = this.MPs.rawQuery((String)localObject, new String[] { paramString1, paramString2 });
    if (((Cursor)localObject).moveToNext())
    {
      localeru.abvy = ((Cursor)localObject).getInt(0);
      localeru.abvz = ((Cursor)localObject).getInt(1);
    }
    ((Cursor)localObject).close();
    if (paramBoolean)
    {
      localeru.abvx += 1;
      localeru.abvB += 1;
      localeru.abvz += 1;
    }
    for (;;)
    {
      localeru.abvC = kx(localeru.abvx, localeru.abvw);
      localeru.abvD = kx(localeru.abvz, localeru.abvy);
      localeru.abvE = kx(localeru.abvB, localeru.abvA);
      this.MPT.bindString(1, localeru.Zid);
      this.MPT.bindString(2, localeru.abvu);
      this.MPT.bindLong(3, localeru.abvv);
      this.MPT.bindLong(4, localeru.abvw);
      this.MPT.bindLong(5, localeru.abvx);
      this.MPT.bindLong(6, localeru.abvy);
      this.MPT.bindLong(7, localeru.abvz);
      this.MPT.bindLong(8, localeru.abvA);
      this.MPT.bindLong(9, localeru.abvB);
      this.MPT.bindDouble(10, localeru.abvC);
      this.MPT.bindDouble(11, localeru.abvD);
      this.MPT.bindDouble(12, localeru.abvE);
      Log.i("MicroMsg.Priority.C2CMsgBaseUsageStorage", "insert %d usage %s %s %s %d %d %d %d %.2f %.2f", new Object[] { Long.valueOf(this.MPT.executeInsert()), paramString1, paramString2, f.formatTime("yyyy-MM-dd", paramLong / 1000L), Integer.valueOf(localeru.abvy), Integer.valueOf(localeru.abvz), Integer.valueOf(localeru.abvA), Integer.valueOf(localeru.abvB), Float.valueOf(localeru.abvD), Float.valueOf(localeru.abvE) });
      return;
      localeru.abvw += 1;
      localeru.abvA += 1;
      localeru.abvy += 1;
    }
  }
  
  private static float kx(int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 0) && (paramInt1 > 0)) {
      return 1.0F;
    }
    if ((paramInt2 == 0) && (paramInt1 == 0)) {
      return 0.0F;
    }
    return Math.min(paramInt1 / paramInt2, 1.0F);
  }
  
  private eru n(String paramString1, String paramString2, long paramLong)
  {
    String str = String.format("SELECT * FROM %s WHERE chat = ? AND talker = ? AND date = ?", new Object[] { getTableName() });
    paramString1 = this.MPs.rawQuery(str, new String[] { paramString1, paramString2, String.valueOf(paramLong) });
    try
    {
      if (paramString1.moveToNext())
      {
        paramString2 = o(paramString1);
        return paramString2;
      }
      return null;
    }
    finally
    {
      paramString1.close();
    }
  }
  
  private float o(String paramString1, String paramString2, long paramLong)
  {
    String str = String.format("SELECT sum(dayreceivecount), sum(dayclickcount) FROM %s WHERE chat = ? AND talker = ? AND date >= %d", new Object[] { getTableName(), Long.valueOf(paramLong - 518400000L) });
    paramString1 = this.MPs.rawQuery(str, new String[] { paramString1, paramString2 });
    try
    {
      if (paramString1.moveToNext())
      {
        int i = paramString1.getInt(0);
        float f = kx(paramString1.getInt(1), i);
        return f;
      }
      return 0.0F;
    }
    finally
    {
      paramString1.close();
    }
  }
  
  private static eru o(Cursor paramCursor)
  {
    eru localeru = new eru();
    localeru.Zid = paramCursor.getString(0);
    localeru.abvu = paramCursor.getString(1);
    localeru.abvv = paramCursor.getLong(2);
    localeru.abvw = paramCursor.getInt(3);
    localeru.abvx = paramCursor.getInt(4);
    localeru.abvy = paramCursor.getInt(5);
    localeru.abvz = paramCursor.getInt(6);
    localeru.abvA = paramCursor.getInt(7);
    localeru.abvB = paramCursor.getInt(8);
    localeru.abvC = paramCursor.getFloat(9);
    localeru.abvD = paramCursor.getFloat(10);
    localeru.abvE = paramCursor.getFloat(11);
    return localeru;
  }
  
  private float p(String paramString1, String paramString2, long paramLong)
  {
    String str = String.format("SELECT sum(dayreceivecount), sum(dayclickcount) FROM %s WHERE chat = ? AND talker = ? AND date >= %d", new Object[] { getTableName(), Long.valueOf(paramLong - 2505600000L) });
    paramString1 = this.MPs.rawQuery(str, new String[] { paramString1, paramString2 });
    try
    {
      if (paramString1.moveToNext())
      {
        int i = paramString1.getInt(0);
        float f = kx(paramString1.getInt(1), i);
        return f;
      }
      return 0.0F;
    }
    finally
    {
      paramString1.close();
    }
  }
  
  public final List<eru> aRJ(String paramString)
  {
    Object localObject = String.format("SELECT *, max(monthreceivecount) FROM %s WHERE chat = ? AND talker <> '%s' GROUP BY chat, talker;", new Object[] { getTableName(), "@all" });
    paramString = this.MPs.rawQuery((String)localObject, new String[] { paramString });
    localObject = new ArrayList(10);
    while (paramString.moveToNext()) {
      ((List)localObject).add(o(paramString));
    }
    paramString.close();
    Collections.sort((List)localObject, new Comparator() {});
    return localObject;
  }
  
  public final void aRK(String paramString)
  {
    this.MPW.bindString(1, paramString);
    Log.i("MicroMsg.Priority.C2CMsgBaseUsageStorage", "delete %d img usage %s", new Object[] { Integer.valueOf(this.MPW.executeUpdateDelete()), paramString });
  }
  
  protected abstract String getTableName();
  
  protected abstract long gzR();
  
  protected abstract long gzS();
  
  public final void kV(String paramString1, String paramString2)
  {
    long l = com.tencent.mm.plugin.priority.a.a.a.gzM();
    if (!c(paramString1, paramString2, l, false)) {
      d(paramString1, paramString2, l, false);
    }
  }
  
  public final void kW(String paramString1, String paramString2)
  {
    long l = com.tencent.mm.plugin.priority.a.a.a.gzM();
    if (!c(paramString1, paramString2, l, true)) {
      d(paramString1, paramString2, l, true);
    }
  }
  
  public final double[] kX(String paramString1, String paramString2)
  {
    long l = com.tencent.mm.plugin.priority.a.a.a.gzM();
    Object localObject = String.format("SELECT dayclickrate, weekclickrate, monthclickrate FROM %s WHERE chat = ? AND talker = ? AND date = ?", new Object[] { getTableName() });
    localObject = this.MPs.rawQuery((String)localObject, new String[] { paramString1, paramString2, String.valueOf(l) });
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
    arrayOfDouble[1] = o(paramString1, paramString2, l);
    arrayOfDouble[2] = p(paramString1, paramString2, l);
    return arrayOfDouble;
  }
  
  public final int kY(String paramString1, String paramString2)
  {
    int i = 0;
    long l = com.tencent.mm.plugin.priority.a.a.a.gzM();
    String str = String.format("SELECT dayreceivecount FROM %s WHERE chat = ? AND talker = ? AND date = ?", new Object[] { getTableName() });
    paramString1 = this.MPs.rawQuery(str, new String[] { paramString1, paramString2, String.valueOf(l) });
    if (paramString1.moveToNext()) {
      i = paramString1.getInt(0);
    }
    paramString1.close();
    return i;
  }
  
  public final int kZ(String paramString1, String paramString2)
  {
    int i = 0;
    long l = com.tencent.mm.plugin.priority.a.a.a.gzM();
    String str = String.format("SELECT sum(dayreceivecount) FROM %s WHERE chat = ? AND talker = ? AND date >= ?", new Object[] { getTableName() });
    paramString1 = this.MPs.rawQuery(str, new String[] { paramString1, paramString2, String.valueOf(l - 518400000L) });
    if (paramString1.moveToNext()) {
      i = paramString1.getInt(0);
    }
    paramString1.close();
    return i;
  }
  
  public final List<Pair<String, String>> tg(long paramLong)
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = String.format("SELECT chat, MMSumDivision(dayreceivecount, dayclickcount, 0) FROM %s WHERE date = ? AND ((chat like '%%@chatroom' AND talker = '@all') OR (chat = talker)) GROUP BY chat", new Object[] { getTableName() });
    localObject1 = this.MPs.rawQuery((String)localObject1, new String[] { String.valueOf(paramLong) });
    while (((Cursor)localObject1).moveToNext()) {
      localHashMap.put(((Cursor)localObject1).getString(0), Double.valueOf(((Cursor)localObject1).getDouble(1)));
    }
    ((Cursor)localObject1).close();
    localObject1 = new HashMap();
    Object localObject2 = String.format("SELECT chat, MMSumDivision(dayreceivecount, dayclickcount, 0) FROM %s WHERE date >= ? AND ((chat like '%%@chatroom' AND talker = '@all') OR (chat = talker)) GROUP BY chat", new Object[] { getTableName() });
    localObject2 = this.MPs.rawQuery((String)localObject2, new String[] { String.valueOf(paramLong - 518400000L) });
    while (((Cursor)localObject2).moveToNext()) {
      ((HashMap)localObject1).put(((Cursor)localObject2).getString(0), Double.valueOf(((Cursor)localObject2).getDouble(1)));
    }
    ((Cursor)localObject2).close();
    localObject2 = new HashMap();
    Object localObject3 = String.format("SELECT chat, MMSumDivision(dayreceivecount, dayclickcount, 0) FROM %s WHERE date >= ? AND ((chat like '%%@chatroom' AND talker = '@all') OR (chat = talker)) GROUP BY chat", new Object[] { getTableName() });
    localObject3 = this.MPs.rawQuery((String)localObject3, new String[] { String.valueOf(paramLong - 2505600000L) });
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
      ((List)localObject2).add(new Pair((String)localEntry.getKey(), str));
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.c2c.a
 * JD-Core Version:    0.7.0.1
 */