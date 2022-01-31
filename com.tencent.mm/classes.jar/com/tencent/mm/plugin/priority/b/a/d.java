package com.tencent.mm.plugin.priority.b.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.priority.b.b;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.protocal.protobuf.awh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public final class d
{
  public SQLiteStatement ptM;
  public SQLiteStatement ptN;
  public SQLiteStatement ptO;
  public b pte;
  
  public d(b paramb)
  {
    AppMethodBeat.i(54923);
    this.pte = paramb;
    if (this.pte.T(17L, 0L) != 1L)
    {
      if (this.pte.OS("C2CMsgImgUsage")) {
        this.pte.WT("C2CMsgImgUsage");
      }
      this.pte.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (chat TEXT, talker TEXT, date INTEGER, dayreceivecount INTEGER, dayclickcount INTEGER, weekreceivecount INTEGER, weekclickcount INTEGER, monthreceivecount INTEGER, monthclickcount INTEGER, dayclickrate FLOAT, weekclickrate FLOAT, monthclickrate FLOAT, PRIMARY KEY(chat, talker, date));", new Object[] { "C2CMsgImgUsage" }));
      this.pte.U(17L, 1L);
    }
    for (;;)
    {
      this.ptM = this.pte.compileStatement(String.format("INSERT OR REPLACE INTO %s (chat, talker, date, dayreceivecount, dayclickcount, weekreceivecount, weekclickcount, monthreceivecount, monthclickcount, dayclickrate, weekclickrate, monthclickrate) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)", new Object[] { "C2CMsgImgUsage" }));
      this.ptN = this.pte.compileStatement(String.format("UPDATE %s SET dayreceivecount = ?, weekreceivecount = ?, monthreceivecount = ?, dayclickrate = ?, weekclickrate = ?, monthclickrate = ? WHERE chat = ? AND talker = ? AND date = ?", new Object[] { "C2CMsgImgUsage" }));
      this.ptO = this.pte.compileStatement(String.format("UPDATE %s SET dayclickcount = ?, weekclickcount = ?, monthclickcount = ?, dayclickrate = ?, weekclickrate = ?, monthclickrate = ? WHERE chat = ? AND talker = ? AND date = ?", new Object[] { "C2CMsgImgUsage" }));
      AppMethodBeat.o(54923);
      return;
      ab.i("MicroMsg.Priority.C2CMsgImgUsageStorage", "Exist Table %s %d", new Object[] { "C2CMsgImgUsage", Integer.valueOf(this.pte.WS("C2CMsgImgUsage")) });
    }
  }
  
  private boolean a(String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(54930);
    awh localawh = k(paramString1, paramString2, paramLong);
    if (localawh != null)
    {
      label161:
      int i;
      if (paramBoolean)
      {
        localawh.xlK += 1;
        localawh.xlM += 1;
        localawh.xlO += 1;
        localawh.xlP = fg(localawh.xlK, localawh.xlJ);
        localawh.xlQ = fg(localawh.xlM, localawh.xlL);
        localawh.xlR = fg(localawh.xlO, localawh.xlN);
        if (!paramBoolean) {
          break label440;
        }
        localObject = this.ptO;
        ((SQLiteStatement)localObject).bindLong(1, localawh.xlK);
        ((SQLiteStatement)localObject).bindLong(2, localawh.xlM);
        ((SQLiteStatement)localObject).bindLong(3, localawh.xlO);
        ((SQLiteStatement)localObject).bindDouble(4, localawh.xlP);
        ((SQLiteStatement)localObject).bindDouble(5, localawh.xlQ);
        ((SQLiteStatement)localObject).bindDouble(6, localawh.xlR);
        ((SQLiteStatement)localObject).bindString(7, localawh.xlG);
        ((SQLiteStatement)localObject).bindString(8, localawh.xlH);
        ((SQLiteStatement)localObject).bindLong(9, localawh.xlI);
        i = ((SQLiteStatement)localObject).executeUpdateDelete();
        if (!paramBoolean) {
          break label485;
        }
      }
      label440:
      label485:
      for (Object localObject = "Open";; localObject = "Receive")
      {
        ab.i("MicroMsg.Priority.C2CMsgImgUsageStorage", "Update %s Img %s %s %d %d %d %d %d %d %d DayClickRate %.2f WeekClickRate %.2f MonthClickRate %.2f", new Object[] { localObject, paramString1, paramString2, Integer.valueOf(i), Integer.valueOf(localawh.xlK), Integer.valueOf(localawh.xlM), Integer.valueOf(localawh.xlO), Integer.valueOf(localawh.xlJ), Integer.valueOf(localawh.xlL), Integer.valueOf(localawh.xlN), Float.valueOf(localawh.xlP), Float.valueOf(localawh.xlQ), Float.valueOf(localawh.xlR) });
        if (i <= 0) {
          break label492;
        }
        AppMethodBeat.o(54930);
        return true;
        localawh.xlJ += 1;
        localawh.xlL += 1;
        localawh.xlN += 1;
        break;
        localObject = this.ptN;
        ((SQLiteStatement)localObject).bindLong(1, localawh.xlJ);
        ((SQLiteStatement)localObject).bindLong(2, localawh.xlL);
        ((SQLiteStatement)localObject).bindLong(3, localawh.xlN);
        break label161;
      }
      label492:
      AppMethodBeat.o(54930);
      return false;
    }
    AppMethodBeat.o(54930);
    return false;
  }
  
  private void b(String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(54931);
    awh localawh = new awh();
    localawh.xlG = paramString1;
    localawh.xlH = paramString2;
    localawh.xlI = paramLong;
    Object localObject = String.format("SELECT sum(dayreceivecount), sum(dayclickcount) FROM %s WHERE chat = ? AND talker = ? AND date >= %d", new Object[] { "C2CMsgImgUsage", Long.valueOf(paramLong - 2505600000L) });
    localObject = this.pte.rawQuery((String)localObject, new String[] { paramString1, paramString2 });
    if (((Cursor)localObject).moveToNext())
    {
      localawh.xlN = ((Cursor)localObject).getInt(0);
      localawh.xlO = ((Cursor)localObject).getInt(1);
    }
    ((Cursor)localObject).close();
    localObject = String.format("SELECT sum(dayreceivecount), sum(dayclickcount) FROM %s WHERE chat = ? AND talker = ? AND date >= %d", new Object[] { "C2CMsgImgUsage", Long.valueOf(paramLong - 518400000L) });
    localObject = this.pte.rawQuery((String)localObject, new String[] { paramString1, paramString2 });
    if (((Cursor)localObject).moveToNext())
    {
      localawh.xlL = ((Cursor)localObject).getInt(0);
      localawh.xlM = ((Cursor)localObject).getInt(1);
    }
    ((Cursor)localObject).close();
    if (paramBoolean)
    {
      localawh.xlK += 1;
      localawh.xlO += 1;
      localawh.xlM += 1;
    }
    for (;;)
    {
      localawh.xlP = fg(localawh.xlK, localawh.xlJ);
      localawh.xlQ = fg(localawh.xlM, localawh.xlL);
      localawh.xlR = fg(localawh.xlO, localawh.xlN);
      this.ptM.bindString(1, localawh.xlG);
      this.ptM.bindString(2, localawh.xlH);
      this.ptM.bindLong(3, localawh.xlI);
      this.ptM.bindLong(4, localawh.xlJ);
      this.ptM.bindLong(5, localawh.xlK);
      this.ptM.bindLong(6, localawh.xlL);
      this.ptM.bindLong(7, localawh.xlM);
      this.ptM.bindLong(8, localawh.xlN);
      this.ptM.bindLong(9, localawh.xlO);
      this.ptM.bindDouble(10, localawh.xlP);
      this.ptM.bindDouble(11, localawh.xlQ);
      this.ptM.bindDouble(12, localawh.xlR);
      ab.i("MicroMsg.Priority.C2CMsgImgUsageStorage", "insert %d usage %s %s %s %d %d %d %d %.2f %.2f", new Object[] { Long.valueOf(this.ptM.executeInsert()), paramString1, paramString2, h.formatTime("yyyy-MM-dd", paramLong / 1000L), Integer.valueOf(localawh.xlL), Integer.valueOf(localawh.xlM), Integer.valueOf(localawh.xlN), Integer.valueOf(localawh.xlO), Float.valueOf(localawh.xlQ), Float.valueOf(localawh.xlR) });
      AppMethodBeat.o(54931);
      return;
      localawh.xlJ += 1;
      localawh.xlN += 1;
      localawh.xlL += 1;
    }
  }
  
  public static long caS()
  {
    AppMethodBeat.i(54928);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    long l = localCalendar.getTimeInMillis();
    AppMethodBeat.o(54928);
    return l;
  }
  
  private static float fg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(54927);
    if ((paramInt2 == 0) && (paramInt1 > 0))
    {
      AppMethodBeat.o(54927);
      return 1.0F;
    }
    if ((paramInt2 == 0) && (paramInt1 == 0))
    {
      AppMethodBeat.o(54927);
      return 0.0F;
    }
    float f = Math.min(paramInt1 / paramInt2, 1.0F);
    AppMethodBeat.o(54927);
    return f;
  }
  
  private awh k(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(54924);
    String str = String.format("SELECT * FROM %s WHERE chat = ? AND talker = ? AND date = ?", new Object[] { "C2CMsgImgUsage" });
    paramString1 = this.pte.rawQuery(str, new String[] { paramString1, paramString2, String.valueOf(paramLong) });
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
      AppMethodBeat.o(54924);
    }
  }
  
  private float l(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(54932);
    String str = String.format("SELECT sum(dayreceivecount), sum(dayclickcount) FROM %s WHERE chat = ? AND talker = ? AND date >= %d", new Object[] { "C2CMsgImgUsage", Long.valueOf(paramLong - 518400000L) });
    paramString1 = this.pte.rawQuery(str, new String[] { paramString1, paramString2 });
    try
    {
      if (paramString1.moveToNext())
      {
        int i = paramString1.getInt(0);
        float f = fg(paramString1.getInt(1), i);
        return f;
      }
      return 0.0F;
    }
    finally
    {
      paramString1.close();
      AppMethodBeat.o(54932);
    }
  }
  
  private static awh l(Cursor paramCursor)
  {
    AppMethodBeat.i(54925);
    awh localawh = new awh();
    localawh.xlG = paramCursor.getString(0);
    localawh.xlH = paramCursor.getString(1);
    localawh.xlI = paramCursor.getLong(2);
    localawh.xlJ = paramCursor.getInt(3);
    localawh.xlK = paramCursor.getInt(4);
    localawh.xlL = paramCursor.getInt(5);
    localawh.xlM = paramCursor.getInt(6);
    localawh.xlN = paramCursor.getInt(7);
    localawh.xlO = paramCursor.getInt(8);
    localawh.xlP = paramCursor.getFloat(9);
    localawh.xlQ = paramCursor.getFloat(10);
    localawh.xlR = paramCursor.getFloat(11);
    AppMethodBeat.o(54925);
    return localawh;
  }
  
  private float m(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(54933);
    String str = String.format("SELECT sum(dayreceivecount), sum(dayclickcount) FROM %s WHERE chat = ? AND talker = ? AND date >= %d", new Object[] { "C2CMsgImgUsage", Long.valueOf(paramLong - 2505600000L) });
    paramString1 = this.pte.rawQuery(str, new String[] { paramString1, paramString2 });
    try
    {
      if (paramString1.moveToNext())
      {
        int i = paramString1.getInt(0);
        float f = fg(paramString1.getInt(1), i);
        return f;
      }
      return 0.0F;
    }
    finally
    {
      paramString1.close();
      AppMethodBeat.o(54933);
    }
  }
  
  public final List<awh> WU(String paramString)
  {
    AppMethodBeat.i(54935);
    Object localObject = String.format("SELECT *, max(monthreceivecount) FROM %s WHERE chat = ? AND talker <> '%s' GROUP BY chat, talker;", new Object[] { "C2CMsgImgUsage", "@all" });
    paramString = this.pte.rawQuery((String)localObject, new String[] { paramString });
    localObject = new ArrayList(10);
    while (paramString.moveToNext()) {
      ((List)localObject).add(l(paramString));
    }
    paramString.close();
    Collections.sort((List)localObject, new d.1(this));
    AppMethodBeat.o(54935);
    return localObject;
  }
  
  public final void fJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(54926);
    long l = caS();
    if (!a(paramString1, paramString2, l, false)) {
      b(paramString1, paramString2, l, false);
    }
    AppMethodBeat.o(54926);
  }
  
  public final void fK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(54929);
    long l = caS();
    if (!a(paramString1, paramString2, l, true)) {
      b(paramString1, paramString2, l, true);
    }
    AppMethodBeat.o(54929);
  }
  
  public final double[] fL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(54934);
    long l = caS();
    Object localObject = String.format("SELECT dayclickrate, weekclickrate, monthclickrate FROM %s WHERE chat = ? AND talker = ? AND date = ?", new Object[] { "C2CMsgImgUsage" });
    localObject = this.pte.rawQuery((String)localObject, new String[] { paramString1, paramString2, String.valueOf(l) });
    double[] arrayOfDouble = new double[3];
    if (((Cursor)localObject).moveToNext())
    {
      arrayOfDouble[0] = ((Cursor)localObject).getDouble(0);
      arrayOfDouble[1] = ((Cursor)localObject).getDouble(1);
      arrayOfDouble[2] = ((Cursor)localObject).getDouble(2);
      ((Cursor)localObject).close();
    }
    for (;;)
    {
      AppMethodBeat.o(54934);
      return arrayOfDouble;
      ((Cursor)localObject).close();
      arrayOfDouble[0] = 0.0D;
      arrayOfDouble[1] = l(paramString1, paramString2, l);
      arrayOfDouble[2] = m(paramString1, paramString2, l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.b.a.d
 * JD-Core Version:    0.7.0.1
 */