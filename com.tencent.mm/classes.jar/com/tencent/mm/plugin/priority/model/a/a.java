package com.tencent.mm.plugin.priority.model.a;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.mm.plugin.priority.model.b;
import com.tencent.mm.pluginsdk.i.i;
import com.tencent.mm.protocal.protobuf.cwb;
import com.tencent.mm.sdk.platformtools.ae;
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
  public SQLiteStatement xaP;
  public SQLiteStatement xaQ;
  public SQLiteStatement xaR;
  private SQLiteStatement xaS;
  private b xao;
  
  public a(b paramb)
  {
    this.xao = paramb;
    if (this.xao.ac(dCD(), 0L) != 1L)
    {
      if (this.xao.ale(getTableName())) {
        this.xao.avL(getTableName());
      }
      this.xao.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (chat TEXT, talker TEXT, date INTEGER, dayreceivecount INTEGER, dayclickcount INTEGER, weekreceivecount INTEGER, weekclickcount INTEGER, monthreceivecount INTEGER, monthclickcount INTEGER, dayclickrate FLOAT, weekclickrate FLOAT, monthclickrate FLOAT, PRIMARY KEY(chat, talker, date));", new Object[] { getTableName() }));
      this.xao.ad(dCD(), 1L);
    }
    for (;;)
    {
      this.xaP = this.xao.compileStatement(String.format("INSERT OR REPLACE INTO %s (chat, talker, date, dayreceivecount, dayclickcount, weekreceivecount, weekclickcount, monthreceivecount, monthclickcount, dayclickrate, weekclickrate, monthclickrate) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)", new Object[] { getTableName() }));
      this.xaQ = this.xao.compileStatement(String.format("UPDATE %s SET dayreceivecount = ?, weekreceivecount = ?, monthreceivecount = ?, dayclickrate = ?, weekclickrate = ?, monthclickrate = ? WHERE chat = ? AND talker = ? AND date = ?", new Object[] { getTableName() }));
      this.xaR = this.xao.compileStatement(String.format("UPDATE %s SET dayclickcount = ?, weekclickcount = ?, monthclickcount = ?, dayclickrate = ?, weekclickrate = ?, monthclickrate = ? WHERE chat = ? AND talker = ? AND date = ?", new Object[] { getTableName() }));
      this.xaS = this.xao.compileStatement(String.format("DELETE FROM %s WHERE chat = ?;", new Object[] { getTableName() }));
      return;
      int i = this.xao.avK(getTableName());
      ae.i("MicroMsg.Priority.C2CMsgBaseUsageStorage", "Exist Table %s %d", new Object[] { getTableName(), Integer.valueOf(i) });
    }
  }
  
  private boolean a(String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    cwb localcwb = h(paramString1, paramString2, paramLong);
    if (localcwb != null)
    {
      label156:
      int i;
      String str;
      if (paramBoolean)
      {
        localcwb.HGS += 1;
        localcwb.HGU += 1;
        localcwb.HGW += 1;
        localcwb.HGX = hc(localcwb.HGS, localcwb.HGR);
        localcwb.HGY = hc(localcwb.HGU, localcwb.HGT);
        localcwb.HGZ = hc(localcwb.HGW, localcwb.HGV);
        if (!paramBoolean) {
          break label442;
        }
        localObject = this.xaR;
        ((SQLiteStatement)localObject).bindLong(1, localcwb.HGS);
        ((SQLiteStatement)localObject).bindLong(2, localcwb.HGU);
        ((SQLiteStatement)localObject).bindLong(3, localcwb.HGW);
        ((SQLiteStatement)localObject).bindDouble(4, localcwb.HGX);
        ((SQLiteStatement)localObject).bindDouble(5, localcwb.HGY);
        ((SQLiteStatement)localObject).bindDouble(6, localcwb.HGZ);
        ((SQLiteStatement)localObject).bindString(7, localcwb.GnT);
        ((SQLiteStatement)localObject).bindString(8, localcwb.HGP);
        ((SQLiteStatement)localObject).bindLong(9, localcwb.HGQ);
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
        ae.i("MicroMsg.Priority.C2CMsgBaseUsageStorage", "%s Update %s Res %s %s %d %d %d %d %d %d %d DayClickRate %.2f WeekClickRate %.2f MonthClickRate %.2f", new Object[] { str, localObject, paramString1, paramString2, Integer.valueOf(i), Integer.valueOf(localcwb.HGS), Integer.valueOf(localcwb.HGU), Integer.valueOf(localcwb.HGW), Integer.valueOf(localcwb.HGR), Integer.valueOf(localcwb.HGT), Integer.valueOf(localcwb.HGV), Float.valueOf(localcwb.HGX), Float.valueOf(localcwb.HGY), Float.valueOf(localcwb.HGZ) });
        if (i <= 0) {
          break label494;
        }
        return true;
        localcwb.HGR += 1;
        localcwb.HGT += 1;
        localcwb.HGV += 1;
        break;
        localObject = this.xaQ;
        ((SQLiteStatement)localObject).bindLong(1, localcwb.HGR);
        ((SQLiteStatement)localObject).bindLong(2, localcwb.HGT);
        ((SQLiteStatement)localObject).bindLong(3, localcwb.HGV);
        break label156;
      }
      label494:
      return false;
    }
    return false;
  }
  
  private void b(String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    cwb localcwb = new cwb();
    localcwb.GnT = paramString1;
    localcwb.HGP = paramString2;
    localcwb.HGQ = paramLong;
    Object localObject = String.format("SELECT sum(dayreceivecount), sum(dayclickcount) FROM %s WHERE chat = ? AND talker = ? AND date >= %d", new Object[] { getTableName(), Long.valueOf(paramLong - 2505600000L) });
    localObject = this.xao.rawQuery((String)localObject, new String[] { paramString1, paramString2 });
    if (((Cursor)localObject).moveToNext())
    {
      localcwb.HGV = ((Cursor)localObject).getInt(0);
      localcwb.HGW = ((Cursor)localObject).getInt(1);
    }
    ((Cursor)localObject).close();
    localObject = String.format("SELECT sum(dayreceivecount), sum(dayclickcount) FROM %s WHERE chat = ? AND talker = ? AND date >= %d", new Object[] { getTableName(), Long.valueOf(paramLong - 518400000L) });
    localObject = this.xao.rawQuery((String)localObject, new String[] { paramString1, paramString2 });
    if (((Cursor)localObject).moveToNext())
    {
      localcwb.HGT = ((Cursor)localObject).getInt(0);
      localcwb.HGU = ((Cursor)localObject).getInt(1);
    }
    ((Cursor)localObject).close();
    if (paramBoolean)
    {
      localcwb.HGS += 1;
      localcwb.HGW += 1;
      localcwb.HGU += 1;
    }
    for (;;)
    {
      localcwb.HGX = hc(localcwb.HGS, localcwb.HGR);
      localcwb.HGY = hc(localcwb.HGU, localcwb.HGT);
      localcwb.HGZ = hc(localcwb.HGW, localcwb.HGV);
      this.xaP.bindString(1, localcwb.GnT);
      this.xaP.bindString(2, localcwb.HGP);
      this.xaP.bindLong(3, localcwb.HGQ);
      this.xaP.bindLong(4, localcwb.HGR);
      this.xaP.bindLong(5, localcwb.HGS);
      this.xaP.bindLong(6, localcwb.HGT);
      this.xaP.bindLong(7, localcwb.HGU);
      this.xaP.bindLong(8, localcwb.HGV);
      this.xaP.bindLong(9, localcwb.HGW);
      this.xaP.bindDouble(10, localcwb.HGX);
      this.xaP.bindDouble(11, localcwb.HGY);
      this.xaP.bindDouble(12, localcwb.HGZ);
      ae.i("MicroMsg.Priority.C2CMsgBaseUsageStorage", "insert %d usage %s %s %s %d %d %d %d %.2f %.2f", new Object[] { Long.valueOf(this.xaP.executeInsert()), paramString1, paramString2, i.formatTime("yyyy-MM-dd", paramLong / 1000L), Integer.valueOf(localcwb.HGT), Integer.valueOf(localcwb.HGU), Integer.valueOf(localcwb.HGV), Integer.valueOf(localcwb.HGW), Float.valueOf(localcwb.HGY), Float.valueOf(localcwb.HGZ) });
      return;
      localcwb.HGR += 1;
      localcwb.HGV += 1;
      localcwb.HGT += 1;
    }
  }
  
  private cwb h(String paramString1, String paramString2, long paramLong)
  {
    String str = String.format("SELECT * FROM %s WHERE chat = ? AND talker = ? AND date = ?", new Object[] { getTableName() });
    paramString1 = this.xao.rawQuery(str, new String[] { paramString1, paramString2, String.valueOf(paramLong) });
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
  
  private static float hc(int paramInt1, int paramInt2)
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
    paramString1 = this.xao.rawQuery(str, new String[] { paramString1, paramString2 });
    try
    {
      if (paramString1.moveToNext())
      {
        int i = paramString1.getInt(0);
        float f = hc(paramString1.getInt(1), i);
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
    paramString1 = this.xao.rawQuery(str, new String[] { paramString1, paramString2 });
    try
    {
      if (paramString1.moveToNext())
      {
        int i = paramString1.getInt(0);
        float f = hc(paramString1.getInt(1), i);
        return f;
      }
      return 0.0F;
    }
    finally
    {
      paramString1.close();
    }
  }
  
  private static cwb k(Cursor paramCursor)
  {
    cwb localcwb = new cwb();
    localcwb.GnT = paramCursor.getString(0);
    localcwb.HGP = paramCursor.getString(1);
    localcwb.HGQ = paramCursor.getLong(2);
    localcwb.HGR = paramCursor.getInt(3);
    localcwb.HGS = paramCursor.getInt(4);
    localcwb.HGT = paramCursor.getInt(5);
    localcwb.HGU = paramCursor.getInt(6);
    localcwb.HGV = paramCursor.getInt(7);
    localcwb.HGW = paramCursor.getInt(8);
    localcwb.HGX = paramCursor.getFloat(9);
    localcwb.HGY = paramCursor.getFloat(10);
    localcwb.HGZ = paramCursor.getFloat(11);
    return localcwb;
  }
  
  public final List<cwb> avM(String paramString)
  {
    Object localObject = String.format("SELECT *, max(monthreceivecount) FROM %s WHERE chat = ? AND talker <> '%s' GROUP BY chat, talker;", new Object[] { getTableName(), "@all" });
    paramString = this.xao.rawQuery((String)localObject, new String[] { paramString });
    localObject = new ArrayList(10);
    while (paramString.moveToNext()) {
      ((List)localObject).add(k(paramString));
    }
    paramString.close();
    Collections.sort((List)localObject, new Comparator() {});
    return localObject;
  }
  
  public final void avN(String paramString)
  {
    this.xaS.bindString(1, paramString);
    ae.i("MicroMsg.Priority.C2CMsgBaseUsageStorage", "delete %d img usage %s", new Object[] { Integer.valueOf(this.xaS.executeUpdateDelete()), paramString });
  }
  
  protected abstract long dCD();
  
  protected abstract String getTableName();
  
  public final void iD(String paramString1, String paramString2)
  {
    long l = com.tencent.mm.plugin.priority.a.a.a.dCy();
    if (!a(paramString1, paramString2, l, false)) {
      b(paramString1, paramString2, l, false);
    }
  }
  
  public final void iE(String paramString1, String paramString2)
  {
    long l = com.tencent.mm.plugin.priority.a.a.a.dCy();
    if (!a(paramString1, paramString2, l, true)) {
      b(paramString1, paramString2, l, true);
    }
  }
  
  public final double[] iF(String paramString1, String paramString2)
  {
    long l = com.tencent.mm.plugin.priority.a.a.a.dCy();
    Object localObject = String.format("SELECT dayclickrate, weekclickrate, monthclickrate FROM %s WHERE chat = ? AND talker = ? AND date = ?", new Object[] { getTableName() });
    localObject = this.xao.rawQuery((String)localObject, new String[] { paramString1, paramString2, String.valueOf(l) });
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
  
  public final int iG(String paramString1, String paramString2)
  {
    int i = 0;
    long l = com.tencent.mm.plugin.priority.a.a.a.dCy();
    String str = String.format("SELECT dayreceivecount FROM %s WHERE chat = ? AND talker = ? AND date = ?", new Object[] { getTableName() });
    paramString1 = this.xao.rawQuery(str, new String[] { paramString1, paramString2, String.valueOf(l) });
    if (paramString1.moveToNext()) {
      i = paramString1.getInt(0);
    }
    paramString1.close();
    return i;
  }
  
  public final int iH(String paramString1, String paramString2)
  {
    int i = 0;
    long l = com.tencent.mm.plugin.priority.a.a.a.dCy();
    String str = String.format("SELECT sum(dayreceivecount) FROM %s WHERE chat = ? AND talker = ? AND date >= ?", new Object[] { getTableName() });
    paramString1 = this.xao.rawQuery(str, new String[] { paramString1, paramString2, String.valueOf(l - 518400000L) });
    if (paramString1.moveToNext()) {
      i = paramString1.getInt(0);
    }
    paramString1.close();
    return i;
  }
  
  public final List<Pair<String, String>> yU(long paramLong)
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = String.format("SELECT chat, MMSumDivision(dayreceivecount, dayclickcount, 0) FROM %s WHERE date = ? AND ((chat like '%%@chatroom' AND talker = '@all') OR (chat = talker)) GROUP BY chat", new Object[] { getTableName() });
    localObject1 = this.xao.rawQuery((String)localObject1, new String[] { String.valueOf(paramLong) });
    while (((Cursor)localObject1).moveToNext()) {
      localHashMap.put(((Cursor)localObject1).getString(0), Double.valueOf(((Cursor)localObject1).getDouble(1)));
    }
    ((Cursor)localObject1).close();
    localObject1 = new HashMap();
    Object localObject2 = String.format("SELECT chat, MMSumDivision(dayreceivecount, dayclickcount, 0) FROM %s WHERE date >= ? AND ((chat like '%%@chatroom' AND talker = '@all') OR (chat = talker)) GROUP BY chat", new Object[] { getTableName() });
    localObject2 = this.xao.rawQuery((String)localObject2, new String[] { String.valueOf(paramLong - 518400000L) });
    while (((Cursor)localObject2).moveToNext()) {
      ((HashMap)localObject1).put(((Cursor)localObject2).getString(0), Double.valueOf(((Cursor)localObject2).getDouble(1)));
    }
    ((Cursor)localObject2).close();
    localObject2 = new HashMap();
    Object localObject3 = String.format("SELECT chat, MMSumDivision(dayreceivecount, dayclickcount, 0) FROM %s WHERE date >= ? AND ((chat like '%%@chatroom' AND talker = '@all') OR (chat = talker)) GROUP BY chat", new Object[] { getTableName() });
    localObject3 = this.xao.rawQuery((String)localObject3, new String[] { String.valueOf(paramLong - 2505600000L) });
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