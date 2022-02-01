package com.tencent.tbs.one.impl;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.impl.a.f;
import com.tencent.tbs.one.impl.a.f.b;
import com.tencent.tbs.one.impl.common.d;
import com.tencent.tbs.one.impl.common.d.a;
import com.tencent.tbs.one.impl.common.h.a;
import com.tencent.tbs.one.impl.common.statistic.StatisticReport;
import com.tencent.tbs.one.impl.e.a.b;
import com.tencent.tbs.one.impl.e.h;
import com.tencent.tbs.one.impl.e.i;
import java.io.File;
import java.util.Map;

public final class a
{
  private static final String[] a;
  private static final Object b;
  private static boolean c;
  
  static
  {
    AppMethodBeat.i(174175);
    a = new String[] { "com.tencent.mm", "com.tencent.mobileqq", "com.tencent.tbs" };
    b = new Object();
    AppMethodBeat.o(174175);
  }
  
  public static com.tencent.tbs.one.impl.a.a<com.tencent.tbs.one.impl.e.e<d>> a(i parami, int paramInt, File paramFile, Bundle paramBundle)
  {
    AppMethodBeat.i(219208);
    parami = new b(parami.a, parami.b, parami.f(), parami.e(), paramInt, paramFile, paramBundle);
    AppMethodBeat.o(219208);
    return parami;
  }
  
  public static com.tencent.tbs.one.impl.a.a<com.tencent.tbs.one.impl.e.e<File>> a(i parami, d.a parama, File paramFile, Bundle paramBundle)
  {
    AppMethodBeat.i(219213);
    parami = new com.tencent.tbs.one.impl.e.a.a(parami.a, parami.b, parami.f(), parami.e(), parama, paramFile, paramBundle);
    AppMethodBeat.o(219213);
    return parami;
  }
  
  /* Error */
  public static h a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 79
    //   2: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 81	java/io/File
    //   8: dup
    //   9: new 81	java/io/File
    //   12: dup
    //   13: new 81	java/io/File
    //   16: dup
    //   17: new 81	java/io/File
    //   20: dup
    //   21: new 81	java/io/File
    //   24: dup
    //   25: invokestatic 87	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   28: ldc 89
    //   30: invokespecial 92	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   33: ldc 94
    //   35: invokespecial 92	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   38: aload_0
    //   39: invokevirtual 99	android/content/Context:getPackageName	()Ljava/lang/String;
    //   42: invokespecial 92	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   45: aload_1
    //   46: invokespecial 92	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   49: ldc 101
    //   51: invokespecial 92	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   54: astore_3
    //   55: aload_3
    //   56: invokevirtual 105	java/io/File:exists	()Z
    //   59: ifeq +93 -> 152
    //   62: ldc 107
    //   64: astore_2
    //   65: aload_3
    //   66: invokevirtual 105	java/io/File:exists	()Z
    //   69: invokestatic 113	com/tencent/tbs/one/impl/common/statistic/StatisticReport:shiftRepService	(Z)V
    //   72: new 56	com/tencent/tbs/one/impl/e/i
    //   75: dup
    //   76: aload_0
    //   77: aload_1
    //   78: ldc 115
    //   80: aload_2
    //   81: getstatic 33	com/tencent/tbs/one/impl/a:a	[Ljava/lang/String;
    //   84: invokespecial 118	com/tencent/tbs/one/impl/e/i:<init>	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   87: astore_0
    //   88: ldc 120
    //   90: aload_1
    //   91: invokevirtual 124	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   94: ifeq +51 -> 145
    //   97: aload_0
    //   98: getfield 128	com/tencent/tbs/one/impl/e/i:m	Landroid/content/SharedPreferences;
    //   101: astore_3
    //   102: aload_3
    //   103: ldc 130
    //   105: invokeinterface 136 2 0
    //   110: ifne +35 -> 145
    //   113: getstatic 142	com/tencent/tbs/b/a:ahzM	Ljava/util/Map;
    //   116: invokeinterface 148 1 0
    //   121: astore_2
    //   122: aload_3
    //   123: invokeinterface 152 1 0
    //   128: astore_3
    //   129: aload_3
    //   130: ldc 130
    //   132: aload_2
    //   133: invokeinterface 158 3 0
    //   138: pop
    //   139: aload_3
    //   140: invokeinterface 161 1 0
    //   145: ldc 79
    //   147: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: aload_0
    //   151: areturn
    //   152: ldc 163
    //   154: astore_2
    //   155: goto -90 -> 65
    //   158: astore_2
    //   159: ldc 165
    //   161: iconst_2
    //   162: anewarray 4	java/lang/Object
    //   165: dup
    //   166: iconst_0
    //   167: aload_1
    //   168: aastore
    //   169: dup
    //   170: iconst_1
    //   171: aload_2
    //   172: aastore
    //   173: invokestatic 170	com/tencent/tbs/one/impl/a/f:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   176: goto -31 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	paramContext	Context
    //   0	179	1	paramString	String
    //   64	91	2	localObject1	Object
    //   158	14	2	localObject2	Object
    //   54	86	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   113	145	158	finally
  }
  
  public static void a(Context paramContext)
  {
    AppMethodBeat.i(174171);
    synchronized (b)
    {
      if (!c)
      {
        com.tencent.tbs.a.e.dp(paramContext.getApplicationContext(), "onelog");
        f.a(new f.b()
        {
          public final void a(int paramAnonymousInt, String paramAnonymousString)
          {
            AppMethodBeat.i(173887);
            com.tencent.tbs.a.e.a(paramAnonymousInt, "TBSOne", paramAnonymousString);
            AppMethodBeat.o(173887);
          }
        });
        StatisticReport.initialize(paramContext.getApplicationContext());
        com.tencent.tbs.one.impl.common.h.a = new h.a()
        {
          public final void a(String paramAnonymousString, int paramAnonymousInt, Map paramAnonymousMap)
          {
            AppMethodBeat.i(173886);
            if ("TBSOneAction".equals(paramAnonymousString))
            {
              StatisticReport.create(paramAnonymousString, paramAnonymousInt).report();
              AppMethodBeat.o(173886);
              return;
            }
            if ((paramAnonymousInt == 201) || (paramAnonymousInt == 209) || (paramAnonymousInt == 214) || (paramAnonymousInt == 506))
            {
              AppMethodBeat.o(173886);
              return;
            }
            StatisticReport localStatisticReport = StatisticReport.create(paramAnonymousString, paramAnonymousInt);
            if (paramAnonymousMap != null)
            {
              if (paramAnonymousMap.containsKey("DEPS_VERSION_CODE")) {
                localStatisticReport.setDEPSCode(((Integer)paramAnonymousMap.get("DEPS_VERSION_CODE")).intValue());
              }
              if (!paramAnonymousMap.containsKey("COMPONENT_NAME")) {
                break label239;
              }
            }
            label239:
            for (paramAnonymousString = (String)paramAnonymousMap.get("COMPONENT_NAME");; paramAnonymousString = "")
            {
              paramAnonymousInt = -1;
              if (paramAnonymousMap.containsKey("COMPONENT_VERSION_CODE")) {
                paramAnonymousInt = ((Integer)paramAnonymousMap.get("COMPONENT_VERSION_CODE")).intValue();
              }
              localStatisticReport.setComponent(paramAnonymousString, paramAnonymousInt);
              if (paramAnonymousMap.containsKey("DESCRIPTION")) {}
              for (paramAnonymousString = (String)paramAnonymousMap.get("DESCRIPTION");; paramAnonymousString = "")
              {
                Throwable localThrowable = null;
                if (paramAnonymousMap.containsKey("THROWABLE")) {
                  localThrowable = (Throwable)paramAnonymousMap.get("THROWABLE");
                }
                localStatisticReport.setDescription(paramAnonymousString, localThrowable);
                localStatisticReport.report();
                AppMethodBeat.o(173886);
                return;
              }
            }
          }
        };
        Runtime.getRuntime().addShutdownHook(new com.tencent.tbs.one.impl.e.a(paramContext.getDir("tbs", 0)));
        c = true;
      }
      AppMethodBeat.o(174171);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tbs.one.impl.a
 * JD-Core Version:    0.7.0.1
 */