package com.tencent.mm.plugin.priority.model.a;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.mm.plugin.priority.model.b;
import com.tencent.mm.pluginsdk.i.i;
import com.tencent.mm.protocal.protobuf.cvh;
import com.tencent.mm.sdk.platformtools.ad;
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
  private b wKA;
  public SQLiteStatement wLb;
  public SQLiteStatement wLc;
  public SQLiteStatement wLd;
  private SQLiteStatement wLe;
  
  public a(b paramb)
  {
    this.wKA = paramb;
    if (this.wKA.ad(dzm(), 0L) != 1L)
    {
      if (this.wKA.akg(getTableName())) {
        this.wKA.auw(getTableName());
      }
      this.wKA.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (chat TEXT, talker TEXT, date INTEGER, dayreceivecount INTEGER, dayclickcount INTEGER, weekreceivecount INTEGER, weekclickcount INTEGER, monthreceivecount INTEGER, monthclickcount INTEGER, dayclickrate FLOAT, weekclickrate FLOAT, monthclickrate FLOAT, PRIMARY KEY(chat, talker, date));", new Object[] { getTableName() }));
      this.wKA.ae(dzm(), 1L);
    }
    for (;;)
    {
      this.wLb = this.wKA.compileStatement(String.format("INSERT OR REPLACE INTO %s (chat, talker, date, dayreceivecount, dayclickcount, weekreceivecount, weekclickcount, monthreceivecount, monthclickcount, dayclickrate, weekclickrate, monthclickrate) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)", new Object[] { getTableName() }));
      this.wLc = this.wKA.compileStatement(String.format("UPDATE %s SET dayreceivecount = ?, weekreceivecount = ?, monthreceivecount = ?, dayclickrate = ?, weekclickrate = ?, monthclickrate = ? WHERE chat = ? AND talker = ? AND date = ?", new Object[] { getTableName() }));
      this.wLd = this.wKA.compileStatement(String.format("UPDATE %s SET dayclickcount = ?, weekclickcount = ?, monthclickcount = ?, dayclickrate = ?, weekclickrate = ?, monthclickrate = ? WHERE chat = ? AND talker = ? AND date = ?", new Object[] { getTableName() }));
      this.wLe = this.wKA.compileStatement(String.format("DELETE FROM %s WHERE chat = ?;", new Object[] { getTableName() }));
      return;
      int i = this.wKA.auv(getTableName());
      ad.i("MicroMsg.Priority.C2CMsgBaseUsageStorage", "Exist Table %s %d", new Object[] { getTableName(), Integer.valueOf(i) });
    }
  }
  
  private boolean a(String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    cvh localcvh = h(paramString1, paramString2, paramLong);
    if (localcvh != null)
    {
      label156:
      int i;
      String str;
      if (paramBoolean)
      {
        localcvh.Hns += 1;
        localcvh.Hnu += 1;
        localcvh.Hnw += 1;
        localcvh.Hnx = ha(localcvh.Hns, localcvh.Hnr);
        localcvh.Hny = ha(localcvh.Hnu, localcvh.Hnt);
        localcvh.Hnz = ha(localcvh.Hnw, localcvh.Hnv);
        if (!paramBoolean) {
          break label442;
        }
        localObject = this.wLd;
        ((SQLiteStatement)localObject).bindLong(1, localcvh.Hns);
        ((SQLiteStatement)localObject).bindLong(2, localcvh.Hnu);
        ((SQLiteStatement)localObject).bindLong(3, localcvh.Hnw);
        ((SQLiteStatement)localObject).bindDouble(4, localcvh.Hnx);
        ((SQLiteStatement)localObject).bindDouble(5, localcvh.Hny);
        ((SQLiteStatement)localObject).bindDouble(6, localcvh.Hnz);
        ((SQLiteStatement)localObject).bindString(7, localcvh.FVu);
        ((SQLiteStatement)localObject).bindString(8, localcvh.Hnp);
        ((SQLiteStatement)localObject).bindLong(9, localcvh.Hnq);
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
        ad.i("MicroMsg.Priority.C2CMsgBaseUsageStorage", "%s Update %s Res %s %s %d %d %d %d %d %d %d DayClickRate %.2f WeekClickRate %.2f MonthClickRate %.2f", new Object[] { str, localObject, paramString1, paramString2, Integer.valueOf(i), Integer.valueOf(localcvh.Hns), Integer.valueOf(localcvh.Hnu), Integer.valueOf(localcvh.Hnw), Integer.valueOf(localcvh.Hnr), Integer.valueOf(localcvh.Hnt), Integer.valueOf(localcvh.Hnv), Float.valueOf(localcvh.Hnx), Float.valueOf(localcvh.Hny), Float.valueOf(localcvh.Hnz) });
        if (i <= 0) {
          break label494;
        }
        return true;
        localcvh.Hnr += 1;
        localcvh.Hnt += 1;
        localcvh.Hnv += 1;
        break;
        localObject = this.wLc;
        ((SQLiteStatement)localObject).bindLong(1, localcvh.Hnr);
        ((SQLiteStatement)localObject).bindLong(2, localcvh.Hnt);
        ((SQLiteStatement)localObject).bindLong(3, localcvh.Hnv);
        break label156;
      }
      label494:
      return false;
    }
    return false;
  }
  
  private void b(String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    cvh localcvh = new cvh();
    localcvh.FVu = paramString1;
    localcvh.Hnp = paramString2;
    localcvh.Hnq = paramLong;
    Object localObject = String.format("SELECT sum(dayreceivecount), sum(dayclickcount) FROM %s WHERE chat = ? AND talker = ? AND date >= %d", new Object[] { getTableName(), Long.valueOf(paramLong - 2505600000L) });
    localObject = this.wKA.rawQuery((String)localObject, new String[] { paramString1, paramString2 });
    if (((Cursor)localObject).moveToNext())
    {
      localcvh.Hnv = ((Cursor)localObject).getInt(0);
      localcvh.Hnw = ((Cursor)localObject).getInt(1);
    }
    ((Cursor)localObject).close();
    localObject = String.format("SELECT sum(dayreceivecount), sum(dayclickcount) FROM %s WHERE chat = ? AND talker = ? AND date >= %d", new Object[] { getTableName(), Long.valueOf(paramLong - 518400000L) });
    localObject = this.wKA.rawQuery((String)localObject, new String[] { paramString1, paramString2 });
    if (((Cursor)localObject).moveToNext())
    {
      localcvh.Hnt = ((Cursor)localObject).getInt(0);
      localcvh.Hnu = ((Cursor)localObject).getInt(1);
    }
    ((Cursor)localObject).close();
    if (paramBoolean)
    {
      localcvh.Hns += 1;
      localcvh.Hnw += 1;
      localcvh.Hnu += 1;
    }
    for (;;)
    {
      localcvh.Hnx = ha(localcvh.Hns, localcvh.Hnr);
      localcvh.Hny = ha(localcvh.Hnu, localcvh.Hnt);
      localcvh.Hnz = ha(localcvh.Hnw, localcvh.Hnv);
      this.wLb.bindString(1, localcvh.FVu);
      this.wLb.bindString(2, localcvh.Hnp);
      this.wLb.bindLong(3, localcvh.Hnq);
      this.wLb.bindLong(4, localcvh.Hnr);
      this.wLb.bindLong(5, localcvh.Hns);
      this.wLb.bindLong(6, localcvh.Hnt);
      this.wLb.bindLong(7, localcvh.Hnu);
      this.wLb.bindLong(8, localcvh.Hnv);
      this.wLb.bindLong(9, localcvh.Hnw);
      this.wLb.bindDouble(10, localcvh.Hnx);
      this.wLb.bindDouble(11, localcvh.Hny);
      this.wLb.bindDouble(12, localcvh.Hnz);
      ad.i("MicroMsg.Priority.C2CMsgBaseUsageStorage", "insert %d usage %s %s %s %d %d %d %d %.2f %.2f", new Object[] { Long.valueOf(this.wLb.executeInsert()), paramString1, paramString2, i.formatTime("yyyy-MM-dd", paramLong / 1000L), Integer.valueOf(localcvh.Hnt), Integer.valueOf(localcvh.Hnu), Integer.valueOf(localcvh.Hnv), Integer.valueOf(localcvh.Hnw), Float.valueOf(localcvh.Hny), Float.valueOf(localcvh.Hnz) });
      return;
      localcvh.Hnr += 1;
      localcvh.Hnv += 1;
      localcvh.Hnt += 1;
    }
  }
  
  private cvh h(String paramString1, String paramString2, long paramLong)
  {
    String str = String.format("SELECT * FROM %s WHERE chat = ? AND talker = ? AND date = ?", new Object[] { getTableName() });
    paramString1 = this.wKA.rawQuery(str, new String[] { paramString1, paramString2, String.valueOf(paramLong) });
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
  
  private static float ha(int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 0) && (paramInt1 > 0)) {
      return 1.0F;
    }
    if ((paramInt2 == 0) && (paramInt1 == 0)) {
      return 0.0F;
    }
    return Math.min(paramInt1 / paramInt2, 1.0F);
  }
  
  private float i(String paramString1, String paramString2, long paramLong)
  {
    String str = String.format("SELECT sum(dayreceivecount), sum(dayclickcount) FROM %s WHERE chat = ? AND talker = ? AND date >= %d", new Object[] { getTableName(), Long.valueOf(paramLong - 518400000L) });
    paramString1 = this.wKA.rawQuery(str, new String[] { paramString1, paramString2 });
    try
    {
      if (paramString1.moveToNext())
      {
        int i = paramString1.getInt(0);
        float f = ha(paramString1.getInt(1), i);
        return f;
      }
      return 0.0F;
    }
    finally
    {
      paramString1.close();
    }
  }
  
  private float j(String paramString1, String paramString2, long paramLong)
  {
    String str = String.format("SELECT sum(dayreceivecount), sum(dayclickcount) FROM %s WHERE chat = ? AND talker = ? AND date >= %d", new Object[] { getTableName(), Long.valueOf(paramLong - 2505600000L) });
    paramString1 = this.wKA.rawQuery(str, new String[] { paramString1, paramString2 });
    try
    {
      if (paramString1.moveToNext())
      {
        int i = paramString1.getInt(0);
        float f = ha(paramString1.getInt(1), i);
        return f;
      }
      return 0.0F;
    }
    finally
    {
      paramString1.close();
    }
  }
  
  private static cvh k(Cursor paramCursor)
  {
    cvh localcvh = new cvh();
    localcvh.FVu = paramCursor.getString(0);
    localcvh.Hnp = paramCursor.getString(1);
    localcvh.Hnq = paramCursor.getLong(2);
    localcvh.Hnr = paramCursor.getInt(3);
    localcvh.Hns = paramCursor.getInt(4);
    localcvh.Hnt = paramCursor.getInt(5);
    localcvh.Hnu = paramCursor.getInt(6);
    localcvh.Hnv = paramCursor.getInt(7);
    localcvh.Hnw = paramCursor.getInt(8);
    localcvh.Hnx = paramCursor.getFloat(9);
    localcvh.Hny = paramCursor.getFloat(10);
    localcvh.Hnz = paramCursor.getFloat(11);
    return localcvh;
  }
  
  public final List<cvh> aux(String paramString)
  {
    Object localObject = String.format("SELECT *, max(monthreceivecount) FROM %s WHERE chat = ? AND talker <> '%s' GROUP BY chat, talker;", new Object[] { getTableName(), "@all" });
    paramString = this.wKA.rawQuery((String)localObject, new String[] { paramString });
    localObject = new ArrayList(10);
    while (paramString.moveToNext()) {
      ((List)localObject).add(k(paramString));
    }
    paramString.close();
    Collections.sort((List)localObject, new Comparator() {});
    return localObject;
  }
  
  public final void auy(String paramString)
  {
    this.wLe.bindString(1, paramString);
    ad.i("MicroMsg.Priority.C2CMsgBaseUsageStorage", "delete %d img usage %s", new Object[] { Integer.valueOf(this.wLe.executeUpdateDelete()), paramString });
  }
  
  protected abstract long dzm();
  
  protected abstract String getTableName();
  
  public final int iA(String paramString1, String paramString2)
  {
    int i = 0;
    long l = com.tencent.mm.plugin.priority.a.a.a.dzh();
    String str = String.format("SELECT dayreceivecount FROM %s WHERE chat = ? AND talker = ? AND date = ?", new Object[] { getTableName() });
    paramString1 = this.wKA.rawQuery(str, new String[] { paramString1, paramString2, String.valueOf(l) });
    if (paramString1.moveToNext()) {
      i = paramString1.getInt(0);
    }
    paramString1.close();
    return i;
  }
  
  public final int iB(String paramString1, String paramString2)
  {
    int i = 0;
    long l = com.tencent.mm.plugin.priority.a.a.a.dzh();
    String str = String.format("SELECT sum(dayreceivecount) FROM %s WHERE chat = ? AND talker = ? AND date >= ?", new Object[] { getTableName() });
    paramString1 = this.wKA.rawQuery(str, new String[] { paramString1, paramString2, String.valueOf(l - 518400000L) });
    if (paramString1.moveToNext()) {
      i = paramString1.getInt(0);
    }
    paramString1.close();
    return i;
  }
  
  public final void ix(String paramString1, String paramString2)
  {
    long l = com.tencent.mm.plugin.priority.a.a.a.dzh();
    if (!a(paramString1, paramString2, l, false)) {
      b(paramString1, paramString2, l, false);
    }
  }
  
  public final void iy(String paramString1, String paramString2)
  {
    long l = com.tencent.mm.plugin.priority.a.a.a.dzh();
    if (!a(paramString1, paramString2, l, true)) {
      b(paramString1, paramString2, l, true);
    }
  }
  
  public final double[] iz(String paramString1, String paramString2)
  {
    long l = com.tencent.mm.plugin.priority.a.a.a.dzh();
    Object localObject = String.format("SELECT dayclickrate, weekclickrate, monthclickrate FROM %s WHERE chat = ? AND talker = ? AND date = ?", new Object[] { getTableName() });
    localObject = this.wKA.rawQuery((String)localObject, new String[] { paramString1, paramString2, String.valueOf(l) });
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
    arrayOfDouble[1] = i(paramString1, paramString2, l);
    arrayOfDouble[2] = j(paramString1, paramString2, l);
    return arrayOfDouble;
  }
  
  public final List<Pair<String, String>> yv(long paramLong)
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = String.format("SELECT chat, MMSumDivision(dayreceivecount, dayclickcount, 0) FROM %s WHERE date = ? AND ((chat like '%%@chatroom' AND talker = '@all') OR (chat = talker)) GROUP BY chat", new Object[] { getTableName() });
    localObject1 = this.wKA.rawQuery((String)localObject1, new String[] { String.valueOf(paramLong) });
    while (((Cursor)localObject1).moveToNext()) {
      localHashMap.put(((Cursor)localObject1).getString(0), Double.valueOf(((Cursor)localObject1).getDouble(1)));
    }
    ((Cursor)localObject1).close();
    localObject1 = new HashMap();
    Object localObject2 = String.format("SELECT chat, MMSumDivision(dayreceivecount, dayclickcount, 0) FROM %s WHERE date >= ? AND ((chat like '%%@chatroom' AND talker = '@all') OR (chat = talker)) GROUP BY chat", new Object[] { getTableName() });
    localObject2 = this.wKA.rawQuery((String)localObject2, new String[] { String.valueOf(paramLong - 518400000L) });
    while (((Cursor)localObject2).moveToNext()) {
      ((HashMap)localObject1).put(((Cursor)localObject2).getString(0), Double.valueOf(((Cursor)localObject2).getDouble(1)));
    }
    ((Cursor)localObject2).close();
    localObject2 = new HashMap();
    Object localObject3 = String.format("SELECT chat, MMSumDivision(dayreceivecount, dayclickcount, 0) FROM %s WHERE date >= ? AND ((chat like '%%@chatroom' AND talker = '@all') OR (chat = talker)) GROUP BY chat", new Object[] { getTableName() });
    localObject3 = this.wKA.rawQuery((String)localObject3, new String[] { String.valueOf(paramLong - 2505600000L) });
    while (((Cursor)localObject3).moveToNext()) {
      ((HashMap)localObject2).put(((Cursor)localObject3).getString(0), Double.valueOf(((Cursor)localObject3).getDouble(1)));
    }
    ((Cursor)localObject3).close();
    localObject3 = new ArrayList();
    ((List)localObject3).addAll(((HashMap)localObject2).entrySet());
    Collections.sort((List)localObject3, new Comparator() {});
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.a.a
 * JD-Core Version:    0.7.0.1
 */