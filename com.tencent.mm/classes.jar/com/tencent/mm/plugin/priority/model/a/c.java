package com.tencent.mm.plugin.priority.model.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.model.b;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends a
{
  private static void a(b paramb, String paramString, long paramLong, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(87869);
    long l = com.tencent.mm.plugin.priority.a.a.a.gzM();
    String str1 = paramString + "temp";
    if (paramb.aDZ(str1)) {
      paramb.aRI(str1);
    }
    Object localObject1 = paramString + "count";
    String str2 = paramString + "totalcount";
    String str3 = paramString + "frequency";
    String str4 = paramString + "recent";
    paramb.execSQL(String.format("CREATE TABLE %s AS SELECT chat, cast(MMDecaySum(%d, date, %s, %d, %d) AS DOUBLE) AS %s, cast(MMFrequency(%s) AS DOUBLE) AS %s, cast(MMRecent(%d, %s, %s, 30) AS DOUBLE) AS %s FROM %s WHERE date >= ? GROUP BY chat;", new Object[] { str1, Long.valueOf(l), localObject1, Integer.valueOf(7), Integer.valueOf(2), str2, localObject1, str3, Long.valueOf(paramLong), "date", localObject1, str4, "C2CChatUsage" }), new String[] { String.valueOf(l - 2505600000L) });
    if (paramb.aRH(str1) == 0)
    {
      AppMethodBeat.o(87869);
      return;
    }
    Object localObject2 = String.format("SELECT avg(%s), avg(%s), avg(%s) FROM %s", new Object[] { str2, str3, str4, str1 });
    localObject1 = new double[3];
    localObject2 = paramb.rawQuery((String)localObject2, null);
    if (((Cursor)localObject2).moveToNext())
    {
      localObject1[0] = ((Cursor)localObject2).getDouble(0);
      localObject1[1] = ((Cursor)localObject2).getDouble(1);
      localObject1[2] = ((Cursor)localObject2).getDouble(2);
    }
    ((Cursor)localObject2).close();
    Object localObject3 = String.format("SELECT MMStdev(%s, %f), MMStdev(%s, %f), MMStdev(%s, %f) FROM %s", new Object[] { str2, Double.valueOf(localObject1[0]), str3, Double.valueOf(localObject1[1]), str4, Double.valueOf(localObject1[2]), str1 });
    localObject2 = new double[3];
    localObject3 = paramb.rawQuery((String)localObject3, null);
    if (((Cursor)localObject3).moveToNext())
    {
      localObject2[0] = ((Cursor)localObject3).getDouble(0);
      localObject2[1] = ((Cursor)localObject3).getDouble(1);
      localObject2[2] = ((Cursor)localObject3).getDouble(2);
    }
    ((Cursor)localObject3).close();
    Log.i("MicroMsg.Priority.CalC2CChatPriorityTask", "calculateStdev %s %.2f %.2f %.2f %.2f %.2f %.2f", new Object[] { paramString, Double.valueOf(localObject1[0]), Double.valueOf(localObject1[1]), Double.valueOf(localObject1[2]), Double.valueOf(localObject2[0]), Double.valueOf(localObject2[1]), Double.valueOf(localObject2[2]) });
    localObject3 = paramString + "temp2";
    if (paramb.aDZ((String)localObject3)) {
      paramb.aRI((String)localObject3);
    }
    String str5 = paramString + "totalcountdev";
    String str6 = paramString + "frequencydev";
    String str7 = paramString + "recentdev";
    paramb.execSQL(String.format("CREATE TABLE %s AS SELECT chat, cast(MMNormalization(%s, %f, %f) AS DOUBLE) AS %s, cast(MMNormalization(%s, %f, %f) AS DOUBLE) AS %s, cast(MMNormalization(%s, %f, %f) AS DOUBLE) AS %s FROM %s", new Object[] { localObject3, str2, Double.valueOf(localObject1[0]), Double.valueOf(localObject2[0]), str5, str3, Double.valueOf(localObject1[1]), Double.valueOf(localObject2[1]), str6, str4, Double.valueOf(localObject1[2]), Double.valueOf(localObject2[2]), str7, str1 }));
    if (paramb.aRH((String)localObject3) == 0)
    {
      AppMethodBeat.o(87869);
      return;
    }
    paramb.execSQL(String.format("UPDATE %s SET %s = (SELECT MMDWeightAverage(%s, %f, %s, %f, %s, %f) FROM %s B WHERE %s.chat = B.chat);", new Object[] { "C2CChatUsageResult", paramString + "rmf", str5, Float.valueOf(paramFloat1), str6, Float.valueOf(paramFloat2), str7, Float.valueOf(paramFloat3), localObject3, "C2CChatUsageResult" }));
    AppMethodBeat.o(87869);
  }
  
  public static boolean gzX()
  {
    AppMethodBeat.i(87870);
    try
    {
      long l1 = com.tencent.mm.plugin.priority.a.a.a.gzM();
      long l2 = ((PluginPriority)h.az(PluginPriority.class)).getPriorityDB().aY(16777219L, 0L);
      if (l2 < l1)
      {
        AppMethodBeat.o(87870);
        return true;
      }
      AppMethodBeat.o(87870);
      return false;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(87870);
    }
    return false;
  }
  
  public final String getName()
  {
    return "Priority.CalC2CChatPriorityTask";
  }
  
  public final void run()
  {
    AppMethodBeat.i(87868);
    if (!gzX())
    {
      Log.i("MicroMsg.Priority.CalC2CChatPriorityTask", "no need to cal usage result");
      AppMethodBeat.o(87868);
      return;
    }
    b localb = ((PluginPriority)h.az(PluginPriority.class)).getPriorityDB();
    if (localb.aRH("C2CChatUsage") == 0)
    {
      AppMethodBeat.o(87868);
      return;
    }
    f.Ozc.idkeyStat(1252L, 1L, 1L, false);
    long l1 = com.tencent.mm.plugin.priority.a.a.a.gzM();
    long l2 = System.currentTimeMillis();
    localb.execSQL(String.format("INSERT OR REPLACE INTO %s(chat) SELECT distinct(chat) AS chat FROM %s WHERE date >= ?;", new Object[] { "C2CChatUsageResult", "C2CChatUsage" }), new String[] { String.valueOf(l1 - 2505600000L) });
    a(localb, "open", l2, 0.4F, 0.4F, 0.2F);
    a(localb, "sendmsg", l2, 0.7F, 0.2F, 0.1F);
    a(localb, "consumemsg", l2, 0.3F, 0.3F, 0.4F);
    l2 = com.tencent.mm.plugin.priority.a.a.a.gzM();
    String str1 = "staytime" + "total";
    String str2 = "staytime" + "peropen";
    String str3 = "staytime" + "temp";
    if (localb.aDZ(str3)) {
      localb.aRI(str3);
    }
    localb.execSQL(String.format("CREATE TABLE %s AS SELECT chat, cast(MMDecaySum(%d, date, %s, %d, %d) AS DOUBLE) AS %s, cast(MMSumDivision(%s, %s, 0) AS DOUBLE) AS %s FROM %s WHERE date >= ? GROUP BY chat;", new Object[] { str3, Long.valueOf(l2), "staytime", Integer.valueOf(7), Integer.valueOf(2), str1, "opencount", "staytime", str2, "C2CChatUsage" }), new String[] { String.valueOf(l2 - 2505600000L) });
    Object localObject1 = String.format("SELECT avg(%s), avg(%s) FROM %s", new Object[] { str1, str2, str3 });
    double[] arrayOfDouble = new double[2];
    localObject1 = localb.rawQuery((String)localObject1, null);
    if (((Cursor)localObject1).moveToNext())
    {
      arrayOfDouble[0] = ((Cursor)localObject1).getDouble(0);
      arrayOfDouble[1] = ((Cursor)localObject1).getDouble(1);
    }
    ((Cursor)localObject1).close();
    Object localObject2 = String.format("SELECT MMStdev(%s, %f), MMStdev(%s, %f) FROM %s", new Object[] { str1, Double.valueOf(arrayOfDouble[0]), str2, Double.valueOf(arrayOfDouble[1]), str3 });
    localObject1 = new double[2];
    localObject2 = localb.rawQuery((String)localObject2, null);
    if (((Cursor)localObject2).moveToNext())
    {
      localObject1[0] = ((Cursor)localObject2).getDouble(0);
      localObject1[1] = ((Cursor)localObject2).getDouble(1);
    }
    ((Cursor)localObject2).close();
    Log.i("MicroMsg.Priority.CalC2CChatPriorityTask", "calculateStayTime %.2f %.2f %.2f %.2f", new Object[] { Double.valueOf(arrayOfDouble[0]), Double.valueOf(arrayOfDouble[1]), Double.valueOf(localObject1[0]), Double.valueOf(localObject1[1]) });
    localObject2 = "staytime" + "temp2";
    if (localb.aDZ((String)localObject2)) {
      localb.aRI((String)localObject2);
    }
    String str4 = str1 + "dev";
    String str5 = str2 + "dev";
    localb.execSQL(String.format("CREATE TABLE %s AS SELECT chat, cast(MMNormalization(%s, %f, %f) AS DOUBLE) AS %s, cast(MMNormalization(%s, %f, %f) AS DOUBLE) AS %s FROM %s", new Object[] { localObject2, str1, Double.valueOf(arrayOfDouble[0]), Double.valueOf(localObject1[0]), str4, str2, Double.valueOf(arrayOfDouble[1]), Double.valueOf(localObject1[1]), str5, str3 }));
    localb.execSQL(String.format("UPDATE %s SET staytimedev = (SELECT MMDWeightAverage(%s, %f, %s, %f) FROM %s E WHERE %s.chat = E.chat);", new Object[] { "C2CChatUsageResult", str4, Double.valueOf(0.5D), str5, Double.valueOf(0.5D), localObject2, "C2CChatUsageResult" }));
    double d = (2.2847D - 4.729D * Math.pow(0.9D, 2.0D) + 3.937D * Math.pow(0.9D, 3.0D)) / 0.9D * 0.09999999999999998D;
    Log.i("MicroMsg.Priority.CalC2CChatPriorityTask", "d: %.2f r: %.4f", new Object[] { Double.valueOf(0.9D), Double.valueOf(d) });
    localb.execSQL(String.format("UPDATE %s SET totallsp = MMLSP(%f, %d, %s, %f, %s, %f, %s, %f, %s, %f)", new Object[] { "C2CChatUsageResult", Double.valueOf(d), Integer.valueOf(4), "openrmf", Double.valueOf(0.1D), "sendmsgrmf", Double.valueOf(0.3D), "staytimedev", Double.valueOf(0.3D), "consumemsgrmf", Double.valueOf(0.3D) }));
    if (localb.aDZ("lsptemp")) {
      localb.aRI("lsptemp");
    }
    localb.execSQL(String.format("CREATE TABLE %s AS SELECT chat, cast(RANK() OVER (ORDER BY totallsp DESC) AS INTEGER) as rank FROM %s", new Object[] { "lsptemp", "C2CChatUsageResult" }));
    localb.execSQL(String.format("UPDATE %s SET rank=(SELECT E.rank FROM %s E WHERE %s.chat=E.chat);", new Object[] { "C2CChatUsageResult", "lsptemp", "C2CChatUsageResult" }));
    ((PluginPriority)h.az(PluginPriority.class)).getPriorityDB().aZ(16777219L, l1);
    f.Ozc.idkeyStat(1252L, 0L, 1L, false);
    AppMethodBeat.o(87868);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.a.c
 * JD-Core Version:    0.7.0.1
 */