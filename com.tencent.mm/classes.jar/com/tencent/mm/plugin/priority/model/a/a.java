package com.tencent.mm.plugin.priority.model.a;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.mm.plugin.priority.model.b;
import com.tencent.mm.pluginsdk.g.h;
import com.tencent.mm.protocal.protobuf.cqc;
import com.tencent.mm.sdk.platformtools.ac;
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
  public SQLiteStatement vDV;
  public SQLiteStatement vDW;
  public SQLiteStatement vDX;
  private SQLiteStatement vDY;
  private b vDu;
  
  public a(b paramb)
  {
    this.vDu = paramb;
    if (this.vDu.ab(doK(), 0L) != 1L)
    {
      if (this.vDu.afI(getTableName())) {
        this.vDu.apq(getTableName());
      }
      this.vDu.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (chat TEXT, talker TEXT, date INTEGER, dayreceivecount INTEGER, dayclickcount INTEGER, weekreceivecount INTEGER, weekclickcount INTEGER, monthreceivecount INTEGER, monthclickcount INTEGER, dayclickrate FLOAT, weekclickrate FLOAT, monthclickrate FLOAT, PRIMARY KEY(chat, talker, date));", new Object[] { getTableName() }));
      this.vDu.ac(doK(), 1L);
    }
    for (;;)
    {
      this.vDV = this.vDu.compileStatement(String.format("INSERT OR REPLACE INTO %s (chat, talker, date, dayreceivecount, dayclickcount, weekreceivecount, weekclickcount, monthreceivecount, monthclickcount, dayclickrate, weekclickrate, monthclickrate) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)", new Object[] { getTableName() }));
      this.vDW = this.vDu.compileStatement(String.format("UPDATE %s SET dayreceivecount = ?, weekreceivecount = ?, monthreceivecount = ?, dayclickrate = ?, weekclickrate = ?, monthclickrate = ? WHERE chat = ? AND talker = ? AND date = ?", new Object[] { getTableName() }));
      this.vDX = this.vDu.compileStatement(String.format("UPDATE %s SET dayclickcount = ?, weekclickcount = ?, monthclickcount = ?, dayclickrate = ?, weekclickrate = ?, monthclickrate = ? WHERE chat = ? AND talker = ? AND date = ?", new Object[] { getTableName() }));
      this.vDY = this.vDu.compileStatement(String.format("DELETE FROM %s WHERE chat = ?;", new Object[] { getTableName() }));
      return;
      int i = this.vDu.app(getTableName());
      ac.i("MicroMsg.Priority.C2CMsgBaseUsageStorage", "Exist Table %s %d", new Object[] { getTableName(), Integer.valueOf(i) });
    }
  }
  
  private boolean a(String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    cqc localcqc = t(paramString1, paramString2, paramLong);
    if (localcqc != null)
    {
      label156:
      int i;
      String str;
      if (paramBoolean)
      {
        localcqc.FDf += 1;
        localcqc.FDh += 1;
        localcqc.FDj += 1;
        localcqc.FDk = gI(localcqc.FDf, localcqc.FDe);
        localcqc.FDl = gI(localcqc.FDh, localcqc.FDg);
        localcqc.FDm = gI(localcqc.FDj, localcqc.FDi);
        if (!paramBoolean) {
          break label442;
        }
        localObject = this.vDX;
        ((SQLiteStatement)localObject).bindLong(1, localcqc.FDf);
        ((SQLiteStatement)localObject).bindLong(2, localcqc.FDh);
        ((SQLiteStatement)localObject).bindLong(3, localcqc.FDj);
        ((SQLiteStatement)localObject).bindDouble(4, localcqc.FDk);
        ((SQLiteStatement)localObject).bindDouble(5, localcqc.FDl);
        ((SQLiteStatement)localObject).bindDouble(6, localcqc.FDm);
        ((SQLiteStatement)localObject).bindString(7, localcqc.Eol);
        ((SQLiteStatement)localObject).bindString(8, localcqc.FDc);
        ((SQLiteStatement)localObject).bindLong(9, localcqc.FDd);
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
        ac.i("MicroMsg.Priority.C2CMsgBaseUsageStorage", "%s Update %s Res %s %s %d %d %d %d %d %d %d DayClickRate %.2f WeekClickRate %.2f MonthClickRate %.2f", new Object[] { str, localObject, paramString1, paramString2, Integer.valueOf(i), Integer.valueOf(localcqc.FDf), Integer.valueOf(localcqc.FDh), Integer.valueOf(localcqc.FDj), Integer.valueOf(localcqc.FDe), Integer.valueOf(localcqc.FDg), Integer.valueOf(localcqc.FDi), Float.valueOf(localcqc.FDk), Float.valueOf(localcqc.FDl), Float.valueOf(localcqc.FDm) });
        if (i <= 0) {
          break label494;
        }
        return true;
        localcqc.FDe += 1;
        localcqc.FDg += 1;
        localcqc.FDi += 1;
        break;
        localObject = this.vDW;
        ((SQLiteStatement)localObject).bindLong(1, localcqc.FDe);
        ((SQLiteStatement)localObject).bindLong(2, localcqc.FDg);
        ((SQLiteStatement)localObject).bindLong(3, localcqc.FDi);
        break label156;
      }
      label494:
      return false;
    }
    return false;
  }
  
  private void b(String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    cqc localcqc = new cqc();
    localcqc.Eol = paramString1;
    localcqc.FDc = paramString2;
    localcqc.FDd = paramLong;
    Object localObject = String.format("SELECT sum(dayreceivecount), sum(dayclickcount) FROM %s WHERE chat = ? AND talker = ? AND date >= %d", new Object[] { getTableName(), Long.valueOf(paramLong - 2505600000L) });
    localObject = this.vDu.rawQuery((String)localObject, new String[] { paramString1, paramString2 });
    if (((Cursor)localObject).moveToNext())
    {
      localcqc.FDi = ((Cursor)localObject).getInt(0);
      localcqc.FDj = ((Cursor)localObject).getInt(1);
    }
    ((Cursor)localObject).close();
    localObject = String.format("SELECT sum(dayreceivecount), sum(dayclickcount) FROM %s WHERE chat = ? AND talker = ? AND date >= %d", new Object[] { getTableName(), Long.valueOf(paramLong - 518400000L) });
    localObject = this.vDu.rawQuery((String)localObject, new String[] { paramString1, paramString2 });
    if (((Cursor)localObject).moveToNext())
    {
      localcqc.FDg = ((Cursor)localObject).getInt(0);
      localcqc.FDh = ((Cursor)localObject).getInt(1);
    }
    ((Cursor)localObject).close();
    if (paramBoolean)
    {
      localcqc.FDf += 1;
      localcqc.FDj += 1;
      localcqc.FDh += 1;
    }
    for (;;)
    {
      localcqc.FDk = gI(localcqc.FDf, localcqc.FDe);
      localcqc.FDl = gI(localcqc.FDh, localcqc.FDg);
      localcqc.FDm = gI(localcqc.FDj, localcqc.FDi);
      this.vDV.bindString(1, localcqc.Eol);
      this.vDV.bindString(2, localcqc.FDc);
      this.vDV.bindLong(3, localcqc.FDd);
      this.vDV.bindLong(4, localcqc.FDe);
      this.vDV.bindLong(5, localcqc.FDf);
      this.vDV.bindLong(6, localcqc.FDg);
      this.vDV.bindLong(7, localcqc.FDh);
      this.vDV.bindLong(8, localcqc.FDi);
      this.vDV.bindLong(9, localcqc.FDj);
      this.vDV.bindDouble(10, localcqc.FDk);
      this.vDV.bindDouble(11, localcqc.FDl);
      this.vDV.bindDouble(12, localcqc.FDm);
      ac.i("MicroMsg.Priority.C2CMsgBaseUsageStorage", "insert %d usage %s %s %s %d %d %d %d %.2f %.2f", new Object[] { Long.valueOf(this.vDV.executeInsert()), paramString1, paramString2, h.formatTime("yyyy-MM-dd", paramLong / 1000L), Integer.valueOf(localcqc.FDg), Integer.valueOf(localcqc.FDh), Integer.valueOf(localcqc.FDi), Integer.valueOf(localcqc.FDj), Float.valueOf(localcqc.FDl), Float.valueOf(localcqc.FDm) });
      return;
      localcqc.FDe += 1;
      localcqc.FDi += 1;
      localcqc.FDg += 1;
    }
  }
  
  private static float gI(int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 0) && (paramInt1 > 0)) {
      return 1.0F;
    }
    if ((paramInt2 == 0) && (paramInt1 == 0)) {
      return 0.0F;
    }
    return Math.min(paramInt1 / paramInt2, 1.0F);
  }
  
  private static cqc k(Cursor paramCursor)
  {
    cqc localcqc = new cqc();
    localcqc.Eol = paramCursor.getString(0);
    localcqc.FDc = paramCursor.getString(1);
    localcqc.FDd = paramCursor.getLong(2);
    localcqc.FDe = paramCursor.getInt(3);
    localcqc.FDf = paramCursor.getInt(4);
    localcqc.FDg = paramCursor.getInt(5);
    localcqc.FDh = paramCursor.getInt(6);
    localcqc.FDi = paramCursor.getInt(7);
    localcqc.FDj = paramCursor.getInt(8);
    localcqc.FDk = paramCursor.getFloat(9);
    localcqc.FDl = paramCursor.getFloat(10);
    localcqc.FDm = paramCursor.getFloat(11);
    return localcqc;
  }
  
  private cqc t(String paramString1, String paramString2, long paramLong)
  {
    String str = String.format("SELECT * FROM %s WHERE chat = ? AND talker = ? AND date = ?", new Object[] { getTableName() });
    paramString1 = this.vDu.rawQuery(str, new String[] { paramString1, paramString2, String.valueOf(paramLong) });
    try
    {
      if (paramString1.moveToNext())
      {
        paramString2 = k(paramString1);
        return paramString2;
      }
      return null;
    }
    finally
    {
      paramString1.close();
    }
  }
  
  private float u(String paramString1, String paramString2, long paramLong)
  {
    String str = String.format("SELECT sum(dayreceivecount), sum(dayclickcount) FROM %s WHERE chat = ? AND talker = ? AND date >= %d", new Object[] { getTableName(), Long.valueOf(paramLong - 518400000L) });
    paramString1 = this.vDu.rawQuery(str, new String[] { paramString1, paramString2 });
    try
    {
      if (paramString1.moveToNext())
      {
        int i = paramString1.getInt(0);
        float f = gI(paramString1.getInt(1), i);
        return f;
      }
      return 0.0F;
    }
    finally
    {
      paramString1.close();
    }
  }
  
  private float v(String paramString1, String paramString2, long paramLong)
  {
    String str = String.format("SELECT sum(dayreceivecount), sum(dayclickcount) FROM %s WHERE chat = ? AND talker = ? AND date >= %d", new Object[] { getTableName(), Long.valueOf(paramLong - 2505600000L) });
    paramString1 = this.vDu.rawQuery(str, new String[] { paramString1, paramString2 });
    try
    {
      if (paramString1.moveToNext())
      {
        int i = paramString1.getInt(0);
        float f = gI(paramString1.getInt(1), i);
        return f;
      }
      return 0.0F;
    }
    finally
    {
      paramString1.close();
    }
  }
  
  public final List<cqc> apr(String paramString)
  {
    Object localObject = String.format("SELECT *, max(monthreceivecount) FROM %s WHERE chat = ? AND talker <> '%s' GROUP BY chat, talker;", new Object[] { getTableName(), "@all" });
    paramString = this.vDu.rawQuery((String)localObject, new String[] { paramString });
    localObject = new ArrayList(10);
    while (paramString.moveToNext()) {
      ((List)localObject).add(k(paramString));
    }
    paramString.close();
    Collections.sort((List)localObject, new Comparator() {});
    return localObject;
  }
  
  public final void aps(String paramString)
  {
    this.vDY.bindString(1, paramString);
    ac.i("MicroMsg.Priority.C2CMsgBaseUsageStorage", "delete %d img usage %s", new Object[] { Integer.valueOf(this.vDY.executeUpdateDelete()), paramString });
  }
  
  protected abstract long doK();
  
  protected abstract String getTableName();
  
  public final void ij(String paramString1, String paramString2)
  {
    long l = com.tencent.mm.plugin.priority.a.a.a.doF();
    if (!a(paramString1, paramString2, l, false)) {
      b(paramString1, paramString2, l, false);
    }
  }
  
  public final void ik(String paramString1, String paramString2)
  {
    long l = com.tencent.mm.plugin.priority.a.a.a.doF();
    if (!a(paramString1, paramString2, l, true)) {
      b(paramString1, paramString2, l, true);
    }
  }
  
  public final double[] il(String paramString1, String paramString2)
  {
    long l = com.tencent.mm.plugin.priority.a.a.a.doF();
    Object localObject = String.format("SELECT dayclickrate, weekclickrate, monthclickrate FROM %s WHERE chat = ? AND talker = ? AND date = ?", new Object[] { getTableName() });
    localObject = this.vDu.rawQuery((String)localObject, new String[] { paramString1, paramString2, String.valueOf(l) });
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
    arrayOfDouble[1] = u(paramString1, paramString2, l);
    arrayOfDouble[2] = v(paramString1, paramString2, l);
    return arrayOfDouble;
  }
  
  public final int im(String paramString1, String paramString2)
  {
    int i = 0;
    long l = com.tencent.mm.plugin.priority.a.a.a.doF();
    String str = String.format("SELECT dayreceivecount FROM %s WHERE chat = ? AND talker = ? AND date = ?", new Object[] { getTableName() });
    paramString1 = this.vDu.rawQuery(str, new String[] { paramString1, paramString2, String.valueOf(l) });
    if (paramString1.moveToNext()) {
      i = paramString1.getInt(0);
    }
    paramString1.close();
    return i;
  }
  
  public final int in(String paramString1, String paramString2)
  {
    int i = 0;
    long l = com.tencent.mm.plugin.priority.a.a.a.doF();
    String str = String.format("SELECT sum(dayreceivecount) FROM %s WHERE chat = ? AND talker = ? AND date >= ?", new Object[] { getTableName() });
    paramString1 = this.vDu.rawQuery(str, new String[] { paramString1, paramString2, String.valueOf(l - 518400000L) });
    if (paramString1.moveToNext()) {
      i = paramString1.getInt(0);
    }
    paramString1.close();
    return i;
  }
  
  public final List<Pair<String, String>> wk(long paramLong)
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = String.format("SELECT chat, MMSumDivision(dayreceivecount, dayclickcount, 0) FROM %s WHERE date = ? AND ((chat like '%%@chatroom' AND talker = '@all') OR (chat = talker)) GROUP BY chat", new Object[] { getTableName() });
    localObject1 = this.vDu.rawQuery((String)localObject1, new String[] { String.valueOf(paramLong) });
    while (((Cursor)localObject1).moveToNext()) {
      localHashMap.put(((Cursor)localObject1).getString(0), Double.valueOf(((Cursor)localObject1).getDouble(1)));
    }
    ((Cursor)localObject1).close();
    localObject1 = new HashMap();
    Object localObject2 = String.format("SELECT chat, MMSumDivision(dayreceivecount, dayclickcount, 0) FROM %s WHERE date >= ? AND ((chat like '%%@chatroom' AND talker = '@all') OR (chat = talker)) GROUP BY chat", new Object[] { getTableName() });
    localObject2 = this.vDu.rawQuery((String)localObject2, new String[] { String.valueOf(paramLong - 518400000L) });
    while (((Cursor)localObject2).moveToNext()) {
      ((HashMap)localObject1).put(((Cursor)localObject2).getString(0), Double.valueOf(((Cursor)localObject2).getDouble(1)));
    }
    ((Cursor)localObject2).close();
    localObject2 = new HashMap();
    Object localObject3 = String.format("SELECT chat, MMSumDivision(dayreceivecount, dayclickcount, 0) FROM %s WHERE date >= ? AND ((chat like '%%@chatroom' AND talker = '@all') OR (chat = talker)) GROUP BY chat", new Object[] { getTableName() });
    localObject3 = this.vDu.rawQuery((String)localObject3, new String[] { String.valueOf(paramLong - 2505600000L) });
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.a.a
 * JD-Core Version:    0.7.0.1
 */