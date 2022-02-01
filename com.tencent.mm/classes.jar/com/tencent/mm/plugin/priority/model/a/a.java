package com.tencent.mm.plugin.priority.model.a;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.mm.plugin.priority.model.b;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.protocal.protobuf.dou;
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
  private b AXQ;
  public SQLiteStatement AYr;
  public SQLiteStatement AYs;
  public SQLiteStatement AYt;
  private SQLiteStatement AYu;
  
  public a(b paramb)
  {
    this.AXQ = paramb;
    if (this.AXQ.ag(eCV(), 0L) != 1L)
    {
      if (this.AXQ.ayi(getTableName())) {
        this.AXQ.aKd(getTableName());
      }
      this.AXQ.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (chat TEXT, talker TEXT, date INTEGER, dayreceivecount INTEGER, dayclickcount INTEGER, weekreceivecount INTEGER, weekclickcount INTEGER, monthreceivecount INTEGER, monthclickcount INTEGER, dayclickrate FLOAT, weekclickrate FLOAT, monthclickrate FLOAT, PRIMARY KEY(chat, talker, date));", new Object[] { getTableName() }));
      this.AXQ.ah(eCV(), 1L);
    }
    for (;;)
    {
      this.AYr = this.AXQ.compileStatement(String.format("INSERT OR REPLACE INTO %s (chat, talker, date, dayreceivecount, dayclickcount, weekreceivecount, weekclickcount, monthreceivecount, monthclickcount, dayclickrate, weekclickrate, monthclickrate) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)", new Object[] { getTableName() }));
      this.AYs = this.AXQ.compileStatement(String.format("UPDATE %s SET dayreceivecount = ?, weekreceivecount = ?, monthreceivecount = ?, dayclickrate = ?, weekclickrate = ?, monthclickrate = ? WHERE chat = ? AND talker = ? AND date = ?", new Object[] { getTableName() }));
      this.AYt = this.AXQ.compileStatement(String.format("UPDATE %s SET dayclickcount = ?, weekclickcount = ?, monthclickcount = ?, dayclickrate = ?, weekclickrate = ?, monthclickrate = ? WHERE chat = ? AND talker = ? AND date = ?", new Object[] { getTableName() }));
      this.AYu = this.AXQ.compileStatement(String.format("DELETE FROM %s WHERE chat = ?;", new Object[] { getTableName() }));
      return;
      int i = this.AXQ.aKc(getTableName());
      Log.i("MicroMsg.Priority.C2CMsgBaseUsageStorage", "Exist Table %s %d", new Object[] { getTableName(), Integer.valueOf(i) });
    }
  }
  
  private boolean a(String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    dou localdou = k(paramString1, paramString2, paramLong);
    if (localdou != null)
    {
      label156:
      int i;
      String str;
      if (paramBoolean)
      {
        localdou.MSc += 1;
        localdou.MSe += 1;
        localdou.MSg += 1;
        localdou.MSh = hM(localdou.MSc, localdou.MSb);
        localdou.MSi = hM(localdou.MSe, localdou.MSd);
        localdou.MSj = hM(localdou.MSg, localdou.MSf);
        if (!paramBoolean) {
          break label442;
        }
        localObject = this.AYt;
        ((SQLiteStatement)localObject).bindLong(1, localdou.MSc);
        ((SQLiteStatement)localObject).bindLong(2, localdou.MSe);
        ((SQLiteStatement)localObject).bindLong(3, localdou.MSg);
        ((SQLiteStatement)localObject).bindDouble(4, localdou.MSh);
        ((SQLiteStatement)localObject).bindDouble(5, localdou.MSi);
        ((SQLiteStatement)localObject).bindDouble(6, localdou.MSj);
        ((SQLiteStatement)localObject).bindString(7, localdou.LiG);
        ((SQLiteStatement)localObject).bindString(8, localdou.MRZ);
        ((SQLiteStatement)localObject).bindLong(9, localdou.MSa);
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
        Log.i("MicroMsg.Priority.C2CMsgBaseUsageStorage", "%s Update %s Res %s %s %d %d %d %d %d %d %d DayClickRate %.2f WeekClickRate %.2f MonthClickRate %.2f", new Object[] { str, localObject, paramString1, paramString2, Integer.valueOf(i), Integer.valueOf(localdou.MSc), Integer.valueOf(localdou.MSe), Integer.valueOf(localdou.MSg), Integer.valueOf(localdou.MSb), Integer.valueOf(localdou.MSd), Integer.valueOf(localdou.MSf), Float.valueOf(localdou.MSh), Float.valueOf(localdou.MSi), Float.valueOf(localdou.MSj) });
        if (i <= 0) {
          break label494;
        }
        return true;
        localdou.MSb += 1;
        localdou.MSd += 1;
        localdou.MSf += 1;
        break;
        localObject = this.AYs;
        ((SQLiteStatement)localObject).bindLong(1, localdou.MSb);
        ((SQLiteStatement)localObject).bindLong(2, localdou.MSd);
        ((SQLiteStatement)localObject).bindLong(3, localdou.MSf);
        break label156;
      }
      label494:
      return false;
    }
    return false;
  }
  
  private void b(String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    dou localdou = new dou();
    localdou.LiG = paramString1;
    localdou.MRZ = paramString2;
    localdou.MSa = paramLong;
    Object localObject = String.format("SELECT sum(dayreceivecount), sum(dayclickcount) FROM %s WHERE chat = ? AND talker = ? AND date >= %d", new Object[] { getTableName(), Long.valueOf(paramLong - 2505600000L) });
    localObject = this.AXQ.rawQuery((String)localObject, new String[] { paramString1, paramString2 });
    if (((Cursor)localObject).moveToNext())
    {
      localdou.MSf = ((Cursor)localObject).getInt(0);
      localdou.MSg = ((Cursor)localObject).getInt(1);
    }
    ((Cursor)localObject).close();
    localObject = String.format("SELECT sum(dayreceivecount), sum(dayclickcount) FROM %s WHERE chat = ? AND talker = ? AND date >= %d", new Object[] { getTableName(), Long.valueOf(paramLong - 518400000L) });
    localObject = this.AXQ.rawQuery((String)localObject, new String[] { paramString1, paramString2 });
    if (((Cursor)localObject).moveToNext())
    {
      localdou.MSd = ((Cursor)localObject).getInt(0);
      localdou.MSe = ((Cursor)localObject).getInt(1);
    }
    ((Cursor)localObject).close();
    if (paramBoolean)
    {
      localdou.MSc += 1;
      localdou.MSg += 1;
      localdou.MSe += 1;
    }
    for (;;)
    {
      localdou.MSh = hM(localdou.MSc, localdou.MSb);
      localdou.MSi = hM(localdou.MSe, localdou.MSd);
      localdou.MSj = hM(localdou.MSg, localdou.MSf);
      this.AYr.bindString(1, localdou.LiG);
      this.AYr.bindString(2, localdou.MRZ);
      this.AYr.bindLong(3, localdou.MSa);
      this.AYr.bindLong(4, localdou.MSb);
      this.AYr.bindLong(5, localdou.MSc);
      this.AYr.bindLong(6, localdou.MSd);
      this.AYr.bindLong(7, localdou.MSe);
      this.AYr.bindLong(8, localdou.MSf);
      this.AYr.bindLong(9, localdou.MSg);
      this.AYr.bindDouble(10, localdou.MSh);
      this.AYr.bindDouble(11, localdou.MSi);
      this.AYr.bindDouble(12, localdou.MSj);
      Log.i("MicroMsg.Priority.C2CMsgBaseUsageStorage", "insert %d usage %s %s %s %d %d %d %d %.2f %.2f", new Object[] { Long.valueOf(this.AYr.executeInsert()), paramString1, paramString2, f.formatTime("yyyy-MM-dd", paramLong / 1000L), Integer.valueOf(localdou.MSd), Integer.valueOf(localdou.MSe), Integer.valueOf(localdou.MSf), Integer.valueOf(localdou.MSg), Float.valueOf(localdou.MSi), Float.valueOf(localdou.MSj) });
      return;
      localdou.MSb += 1;
      localdou.MSf += 1;
      localdou.MSd += 1;
    }
  }
  
  private static float hM(int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 0) && (paramInt1 > 0)) {
      return 1.0F;
    }
    if ((paramInt2 == 0) && (paramInt1 == 0)) {
      return 0.0F;
    }
    return Math.min(paramInt1 / paramInt2, 1.0F);
  }
  
  private static dou k(Cursor paramCursor)
  {
    dou localdou = new dou();
    localdou.LiG = paramCursor.getString(0);
    localdou.MRZ = paramCursor.getString(1);
    localdou.MSa = paramCursor.getLong(2);
    localdou.MSb = paramCursor.getInt(3);
    localdou.MSc = paramCursor.getInt(4);
    localdou.MSd = paramCursor.getInt(5);
    localdou.MSe = paramCursor.getInt(6);
    localdou.MSf = paramCursor.getInt(7);
    localdou.MSg = paramCursor.getInt(8);
    localdou.MSh = paramCursor.getFloat(9);
    localdou.MSi = paramCursor.getFloat(10);
    localdou.MSj = paramCursor.getFloat(11);
    return localdou;
  }
  
  private dou k(String paramString1, String paramString2, long paramLong)
  {
    String str = String.format("SELECT * FROM %s WHERE chat = ? AND talker = ? AND date = ?", new Object[] { getTableName() });
    paramString1 = this.AXQ.rawQuery(str, new String[] { paramString1, paramString2, String.valueOf(paramLong) });
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
  
  private float l(String paramString1, String paramString2, long paramLong)
  {
    String str = String.format("SELECT sum(dayreceivecount), sum(dayclickcount) FROM %s WHERE chat = ? AND talker = ? AND date >= %d", new Object[] { getTableName(), Long.valueOf(paramLong - 518400000L) });
    paramString1 = this.AXQ.rawQuery(str, new String[] { paramString1, paramString2 });
    try
    {
      if (paramString1.moveToNext())
      {
        int i = paramString1.getInt(0);
        float f = hM(paramString1.getInt(1), i);
        return f;
      }
      return 0.0F;
    }
    finally
    {
      paramString1.close();
    }
  }
  
  private float m(String paramString1, String paramString2, long paramLong)
  {
    String str = String.format("SELECT sum(dayreceivecount), sum(dayclickcount) FROM %s WHERE chat = ? AND talker = ? AND date >= %d", new Object[] { getTableName(), Long.valueOf(paramLong - 2505600000L) });
    paramString1 = this.AXQ.rawQuery(str, new String[] { paramString1, paramString2 });
    try
    {
      if (paramString1.moveToNext())
      {
        int i = paramString1.getInt(0);
        float f = hM(paramString1.getInt(1), i);
        return f;
      }
      return 0.0F;
    }
    finally
    {
      paramString1.close();
    }
  }
  
  public final List<Pair<String, String>> HK(long paramLong)
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = String.format("SELECT chat, MMSumDivision(dayreceivecount, dayclickcount, 0) FROM %s WHERE date = ? AND ((chat like '%%@chatroom' AND talker = '@all') OR (chat = talker)) GROUP BY chat", new Object[] { getTableName() });
    localObject1 = this.AXQ.rawQuery((String)localObject1, new String[] { String.valueOf(paramLong) });
    while (((Cursor)localObject1).moveToNext()) {
      localHashMap.put(((Cursor)localObject1).getString(0), Double.valueOf(((Cursor)localObject1).getDouble(1)));
    }
    ((Cursor)localObject1).close();
    localObject1 = new HashMap();
    Object localObject2 = String.format("SELECT chat, MMSumDivision(dayreceivecount, dayclickcount, 0) FROM %s WHERE date >= ? AND ((chat like '%%@chatroom' AND talker = '@all') OR (chat = talker)) GROUP BY chat", new Object[] { getTableName() });
    localObject2 = this.AXQ.rawQuery((String)localObject2, new String[] { String.valueOf(paramLong - 518400000L) });
    while (((Cursor)localObject2).moveToNext()) {
      ((HashMap)localObject1).put(((Cursor)localObject2).getString(0), Double.valueOf(((Cursor)localObject2).getDouble(1)));
    }
    ((Cursor)localObject2).close();
    localObject2 = new HashMap();
    Object localObject3 = String.format("SELECT chat, MMSumDivision(dayreceivecount, dayclickcount, 0) FROM %s WHERE date >= ? AND ((chat like '%%@chatroom' AND talker = '@all') OR (chat = talker)) GROUP BY chat", new Object[] { getTableName() });
    localObject3 = this.AXQ.rawQuery((String)localObject3, new String[] { String.valueOf(paramLong - 2505600000L) });
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
  
  public final List<dou> aKe(String paramString)
  {
    Object localObject = String.format("SELECT *, max(monthreceivecount) FROM %s WHERE chat = ? AND talker <> '%s' GROUP BY chat, talker;", new Object[] { getTableName(), "@all" });
    paramString = this.AXQ.rawQuery((String)localObject, new String[] { paramString });
    localObject = new ArrayList(10);
    while (paramString.moveToNext()) {
      ((List)localObject).add(k(paramString));
    }
    paramString.close();
    Collections.sort((List)localObject, new Comparator() {});
    return localObject;
  }
  
  public final void aKf(String paramString)
  {
    this.AYu.bindString(1, paramString);
    Log.i("MicroMsg.Priority.C2CMsgBaseUsageStorage", "delete %d img usage %s", new Object[] { Integer.valueOf(this.AYu.executeUpdateDelete()), paramString });
  }
  
  protected abstract long eCV();
  
  protected abstract String getTableName();
  
  public final void jp(String paramString1, String paramString2)
  {
    long l = com.tencent.mm.plugin.priority.a.a.a.eCQ();
    if (!a(paramString1, paramString2, l, false)) {
      b(paramString1, paramString2, l, false);
    }
  }
  
  public final void jq(String paramString1, String paramString2)
  {
    long l = com.tencent.mm.plugin.priority.a.a.a.eCQ();
    if (!a(paramString1, paramString2, l, true)) {
      b(paramString1, paramString2, l, true);
    }
  }
  
  public final double[] jr(String paramString1, String paramString2)
  {
    long l = com.tencent.mm.plugin.priority.a.a.a.eCQ();
    Object localObject = String.format("SELECT dayclickrate, weekclickrate, monthclickrate FROM %s WHERE chat = ? AND talker = ? AND date = ?", new Object[] { getTableName() });
    localObject = this.AXQ.rawQuery((String)localObject, new String[] { paramString1, paramString2, String.valueOf(l) });
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
    arrayOfDouble[1] = l(paramString1, paramString2, l);
    arrayOfDouble[2] = m(paramString1, paramString2, l);
    return arrayOfDouble;
  }
  
  public final int js(String paramString1, String paramString2)
  {
    int i = 0;
    long l = com.tencent.mm.plugin.priority.a.a.a.eCQ();
    String str = String.format("SELECT dayreceivecount FROM %s WHERE chat = ? AND talker = ? AND date = ?", new Object[] { getTableName() });
    paramString1 = this.AXQ.rawQuery(str, new String[] { paramString1, paramString2, String.valueOf(l) });
    if (paramString1.moveToNext()) {
      i = paramString1.getInt(0);
    }
    paramString1.close();
    return i;
  }
  
  public final int jt(String paramString1, String paramString2)
  {
    int i = 0;
    long l = com.tencent.mm.plugin.priority.a.a.a.eCQ();
    String str = String.format("SELECT sum(dayreceivecount) FROM %s WHERE chat = ? AND talker = ? AND date >= ?", new Object[] { getTableName() });
    paramString1 = this.AXQ.rawQuery(str, new String[] { paramString1, paramString2, String.valueOf(l - 518400000L) });
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