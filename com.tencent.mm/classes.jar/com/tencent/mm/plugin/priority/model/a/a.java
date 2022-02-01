package com.tencent.mm.plugin.priority.model.a;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.mm.plugin.priority.model.b;
import com.tencent.mm.pluginsdk.g.h;
import com.tencent.mm.protocal.protobuf.ckv;
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
  private b uuB;
  public SQLiteStatement uvc;
  public SQLiteStatement uvd;
  public SQLiteStatement uve;
  private SQLiteStatement uvf;
  
  public a(b paramb)
  {
    this.uuB = paramb;
    if (this.uuB.ae(dbc(), 0L) != 1L)
    {
      if (this.uuB.aaQ(getTableName())) {
        this.uuB.akr(getTableName());
      }
      this.uuB.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (chat TEXT, talker TEXT, date INTEGER, dayreceivecount INTEGER, dayclickcount INTEGER, weekreceivecount INTEGER, weekclickcount INTEGER, monthreceivecount INTEGER, monthclickcount INTEGER, dayclickrate FLOAT, weekclickrate FLOAT, monthclickrate FLOAT, PRIMARY KEY(chat, talker, date));", new Object[] { getTableName() }));
      this.uuB.af(dbc(), 1L);
    }
    for (;;)
    {
      this.uvc = this.uuB.compileStatement(String.format("INSERT OR REPLACE INTO %s (chat, talker, date, dayreceivecount, dayclickcount, weekreceivecount, weekclickcount, monthreceivecount, monthclickcount, dayclickrate, weekclickrate, monthclickrate) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)", new Object[] { getTableName() }));
      this.uvd = this.uuB.compileStatement(String.format("UPDATE %s SET dayreceivecount = ?, weekreceivecount = ?, monthreceivecount = ?, dayclickrate = ?, weekclickrate = ?, monthclickrate = ? WHERE chat = ? AND talker = ? AND date = ?", new Object[] { getTableName() }));
      this.uve = this.uuB.compileStatement(String.format("UPDATE %s SET dayclickcount = ?, weekclickcount = ?, monthclickcount = ?, dayclickrate = ?, weekclickrate = ?, monthclickrate = ? WHERE chat = ? AND talker = ? AND date = ?", new Object[] { getTableName() }));
      this.uvf = this.uuB.compileStatement(String.format("DELETE FROM %s WHERE chat = ?;", new Object[] { getTableName() }));
      return;
      int i = this.uuB.akq(getTableName());
      ad.i("MicroMsg.Priority.C2CMsgBaseUsageStorage", "Exist Table %s %d", new Object[] { getTableName(), Integer.valueOf(i) });
    }
  }
  
  private boolean a(String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    ckv localckv = t(paramString1, paramString2, paramLong);
    if (localckv != null)
    {
      label156:
      int i;
      String str;
      if (paramBoolean)
      {
        localckv.Egf += 1;
        localckv.Egh += 1;
        localckv.Egj += 1;
        localckv.Egk = gB(localckv.Egf, localckv.Ege);
        localckv.Egl = gB(localckv.Egh, localckv.Egg);
        localckv.Egm = gB(localckv.Egj, localckv.Egi);
        if (!paramBoolean) {
          break label442;
        }
        localObject = this.uve;
        ((SQLiteStatement)localObject).bindLong(1, localckv.Egf);
        ((SQLiteStatement)localObject).bindLong(2, localckv.Egh);
        ((SQLiteStatement)localObject).bindLong(3, localckv.Egj);
        ((SQLiteStatement)localObject).bindDouble(4, localckv.Egk);
        ((SQLiteStatement)localObject).bindDouble(5, localckv.Egl);
        ((SQLiteStatement)localObject).bindDouble(6, localckv.Egm);
        ((SQLiteStatement)localObject).bindString(7, localckv.CVB);
        ((SQLiteStatement)localObject).bindString(8, localckv.Egc);
        ((SQLiteStatement)localObject).bindLong(9, localckv.Egd);
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
        ad.i("MicroMsg.Priority.C2CMsgBaseUsageStorage", "%s Update %s Res %s %s %d %d %d %d %d %d %d DayClickRate %.2f WeekClickRate %.2f MonthClickRate %.2f", new Object[] { str, localObject, paramString1, paramString2, Integer.valueOf(i), Integer.valueOf(localckv.Egf), Integer.valueOf(localckv.Egh), Integer.valueOf(localckv.Egj), Integer.valueOf(localckv.Ege), Integer.valueOf(localckv.Egg), Integer.valueOf(localckv.Egi), Float.valueOf(localckv.Egk), Float.valueOf(localckv.Egl), Float.valueOf(localckv.Egm) });
        if (i <= 0) {
          break label494;
        }
        return true;
        localckv.Ege += 1;
        localckv.Egg += 1;
        localckv.Egi += 1;
        break;
        localObject = this.uvd;
        ((SQLiteStatement)localObject).bindLong(1, localckv.Ege);
        ((SQLiteStatement)localObject).bindLong(2, localckv.Egg);
        ((SQLiteStatement)localObject).bindLong(3, localckv.Egi);
        break label156;
      }
      label494:
      return false;
    }
    return false;
  }
  
  private void b(String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    ckv localckv = new ckv();
    localckv.CVB = paramString1;
    localckv.Egc = paramString2;
    localckv.Egd = paramLong;
    Object localObject = String.format("SELECT sum(dayreceivecount), sum(dayclickcount) FROM %s WHERE chat = ? AND talker = ? AND date >= %d", new Object[] { getTableName(), Long.valueOf(paramLong - 2505600000L) });
    localObject = this.uuB.rawQuery((String)localObject, new String[] { paramString1, paramString2 });
    if (((Cursor)localObject).moveToNext())
    {
      localckv.Egi = ((Cursor)localObject).getInt(0);
      localckv.Egj = ((Cursor)localObject).getInt(1);
    }
    ((Cursor)localObject).close();
    localObject = String.format("SELECT sum(dayreceivecount), sum(dayclickcount) FROM %s WHERE chat = ? AND talker = ? AND date >= %d", new Object[] { getTableName(), Long.valueOf(paramLong - 518400000L) });
    localObject = this.uuB.rawQuery((String)localObject, new String[] { paramString1, paramString2 });
    if (((Cursor)localObject).moveToNext())
    {
      localckv.Egg = ((Cursor)localObject).getInt(0);
      localckv.Egh = ((Cursor)localObject).getInt(1);
    }
    ((Cursor)localObject).close();
    if (paramBoolean)
    {
      localckv.Egf += 1;
      localckv.Egj += 1;
      localckv.Egh += 1;
    }
    for (;;)
    {
      localckv.Egk = gB(localckv.Egf, localckv.Ege);
      localckv.Egl = gB(localckv.Egh, localckv.Egg);
      localckv.Egm = gB(localckv.Egj, localckv.Egi);
      this.uvc.bindString(1, localckv.CVB);
      this.uvc.bindString(2, localckv.Egc);
      this.uvc.bindLong(3, localckv.Egd);
      this.uvc.bindLong(4, localckv.Ege);
      this.uvc.bindLong(5, localckv.Egf);
      this.uvc.bindLong(6, localckv.Egg);
      this.uvc.bindLong(7, localckv.Egh);
      this.uvc.bindLong(8, localckv.Egi);
      this.uvc.bindLong(9, localckv.Egj);
      this.uvc.bindDouble(10, localckv.Egk);
      this.uvc.bindDouble(11, localckv.Egl);
      this.uvc.bindDouble(12, localckv.Egm);
      ad.i("MicroMsg.Priority.C2CMsgBaseUsageStorage", "insert %d usage %s %s %s %d %d %d %d %.2f %.2f", new Object[] { Long.valueOf(this.uvc.executeInsert()), paramString1, paramString2, h.formatTime("yyyy-MM-dd", paramLong / 1000L), Integer.valueOf(localckv.Egg), Integer.valueOf(localckv.Egh), Integer.valueOf(localckv.Egi), Integer.valueOf(localckv.Egj), Float.valueOf(localckv.Egl), Float.valueOf(localckv.Egm) });
      return;
      localckv.Ege += 1;
      localckv.Egi += 1;
      localckv.Egg += 1;
    }
  }
  
  private static float gB(int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 0) && (paramInt1 > 0)) {
      return 1.0F;
    }
    if ((paramInt2 == 0) && (paramInt1 == 0)) {
      return 0.0F;
    }
    return Math.min(paramInt1 / paramInt2, 1.0F);
  }
  
  private static ckv l(Cursor paramCursor)
  {
    ckv localckv = new ckv();
    localckv.CVB = paramCursor.getString(0);
    localckv.Egc = paramCursor.getString(1);
    localckv.Egd = paramCursor.getLong(2);
    localckv.Ege = paramCursor.getInt(3);
    localckv.Egf = paramCursor.getInt(4);
    localckv.Egg = paramCursor.getInt(5);
    localckv.Egh = paramCursor.getInt(6);
    localckv.Egi = paramCursor.getInt(7);
    localckv.Egj = paramCursor.getInt(8);
    localckv.Egk = paramCursor.getFloat(9);
    localckv.Egl = paramCursor.getFloat(10);
    localckv.Egm = paramCursor.getFloat(11);
    return localckv;
  }
  
  private ckv t(String paramString1, String paramString2, long paramLong)
  {
    String str = String.format("SELECT * FROM %s WHERE chat = ? AND talker = ? AND date = ?", new Object[] { getTableName() });
    paramString1 = this.uuB.rawQuery(str, new String[] { paramString1, paramString2, String.valueOf(paramLong) });
    try
    {
      if (paramString1.moveToNext())
      {
        paramString2 = l(paramString1);
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
    paramString1 = this.uuB.rawQuery(str, new String[] { paramString1, paramString2 });
    try
    {
      if (paramString1.moveToNext())
      {
        int i = paramString1.getInt(0);
        float f = gB(paramString1.getInt(1), i);
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
    paramString1 = this.uuB.rawQuery(str, new String[] { paramString1, paramString2 });
    try
    {
      if (paramString1.moveToNext())
      {
        int i = paramString1.getInt(0);
        float f = gB(paramString1.getInt(1), i);
        return f;
      }
      return 0.0F;
    }
    finally
    {
      paramString1.close();
    }
  }
  
  public final List<ckv> aks(String paramString)
  {
    Object localObject = String.format("SELECT *, max(monthreceivecount) FROM %s WHERE chat = ? AND talker <> '%s' GROUP BY chat, talker;", new Object[] { getTableName(), "@all" });
    paramString = this.uuB.rawQuery((String)localObject, new String[] { paramString });
    localObject = new ArrayList(10);
    while (paramString.moveToNext()) {
      ((List)localObject).add(l(paramString));
    }
    paramString.close();
    Collections.sort((List)localObject, new Comparator() {});
    return localObject;
  }
  
  public final void akt(String paramString)
  {
    this.uvf.bindString(1, paramString);
    ad.i("MicroMsg.Priority.C2CMsgBaseUsageStorage", "delete %d img usage %s", new Object[] { Integer.valueOf(this.uvf.executeUpdateDelete()), paramString });
  }
  
  protected abstract long dbc();
  
  protected abstract String getTableName();
  
  public final void hQ(String paramString1, String paramString2)
  {
    long l = com.tencent.mm.plugin.priority.a.a.a.daX();
    if (!a(paramString1, paramString2, l, false)) {
      b(paramString1, paramString2, l, false);
    }
  }
  
  public final void hR(String paramString1, String paramString2)
  {
    long l = com.tencent.mm.plugin.priority.a.a.a.daX();
    if (!a(paramString1, paramString2, l, true)) {
      b(paramString1, paramString2, l, true);
    }
  }
  
  public final double[] hS(String paramString1, String paramString2)
  {
    long l = com.tencent.mm.plugin.priority.a.a.a.daX();
    Object localObject = String.format("SELECT dayclickrate, weekclickrate, monthclickrate FROM %s WHERE chat = ? AND talker = ? AND date = ?", new Object[] { getTableName() });
    localObject = this.uuB.rawQuery((String)localObject, new String[] { paramString1, paramString2, String.valueOf(l) });
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
  
  public final int hT(String paramString1, String paramString2)
  {
    int i = 0;
    long l = com.tencent.mm.plugin.priority.a.a.a.daX();
    String str = String.format("SELECT dayreceivecount FROM %s WHERE chat = ? AND talker = ? AND date = ?", new Object[] { getTableName() });
    paramString1 = this.uuB.rawQuery(str, new String[] { paramString1, paramString2, String.valueOf(l) });
    if (paramString1.moveToNext()) {
      i = paramString1.getInt(0);
    }
    paramString1.close();
    return i;
  }
  
  public final int hU(String paramString1, String paramString2)
  {
    int i = 0;
    long l = com.tencent.mm.plugin.priority.a.a.a.daX();
    String str = String.format("SELECT sum(dayreceivecount) FROM %s WHERE chat = ? AND talker = ? AND date >= ?", new Object[] { getTableName() });
    paramString1 = this.uuB.rawQuery(str, new String[] { paramString1, paramString2, String.valueOf(l - 518400000L) });
    if (paramString1.moveToNext()) {
      i = paramString1.getInt(0);
    }
    paramString1.close();
    return i;
  }
  
  public final List<Pair<String, String>> rH(long paramLong)
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = String.format("SELECT chat, MMSumDivision(dayreceivecount, dayclickcount, 0) FROM %s WHERE date = ? AND ((chat like '%%@chatroom' AND talker = '@all') OR (chat = talker)) GROUP BY chat", new Object[] { getTableName() });
    localObject1 = this.uuB.rawQuery((String)localObject1, new String[] { String.valueOf(paramLong) });
    while (((Cursor)localObject1).moveToNext()) {
      localHashMap.put(((Cursor)localObject1).getString(0), Double.valueOf(((Cursor)localObject1).getDouble(1)));
    }
    ((Cursor)localObject1).close();
    localObject1 = new HashMap();
    Object localObject2 = String.format("SELECT chat, MMSumDivision(dayreceivecount, dayclickcount, 0) FROM %s WHERE date >= ? AND ((chat like '%%@chatroom' AND talker = '@all') OR (chat = talker)) GROUP BY chat", new Object[] { getTableName() });
    localObject2 = this.uuB.rawQuery((String)localObject2, new String[] { String.valueOf(paramLong - 518400000L) });
    while (((Cursor)localObject2).moveToNext()) {
      ((HashMap)localObject1).put(((Cursor)localObject2).getString(0), Double.valueOf(((Cursor)localObject2).getDouble(1)));
    }
    ((Cursor)localObject2).close();
    localObject2 = new HashMap();
    Object localObject3 = String.format("SELECT chat, MMSumDivision(dayreceivecount, dayclickcount, 0) FROM %s WHERE date >= ? AND ((chat like '%%@chatroom' AND talker = '@all') OR (chat = talker)) GROUP BY chat", new Object[] { getTableName() });
    localObject3 = this.uuB.rawQuery((String)localObject3, new String[] { String.valueOf(paramLong - 2505600000L) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.a.a
 * JD-Core Version:    0.7.0.1
 */