package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdcard_migrate.b;
import com.tencent.mm.sdk.platformtools.aw;

public final class p
{
  private static Boolean Juq = null;
  private static Boolean Jur = null;
  private static Boolean Jus = null;
  private static Boolean Jut = null;
  private static Boolean Juu = null;
  
  public static void btF()
  {
    AppMethodBeat.i(182929);
    aw localaw = aw.aKT("VFSStrategy");
    long l1 = localaw.getLong("VFSSwitchReportTime", 0L);
    long l2 = System.currentTimeMillis();
    if ((l1 <= 0L) || (l2 - l1 >= 259200000L))
    {
      localaw.encode("VFSSwitchReportTime", l2);
      e.wTc.idkeyStat(1317L, 0L, 1L, true);
      if (fyv()) {
        e.wTc.idkeyStat(1317L, 1L, 1L, true);
      }
      if (fyw()) {
        e.wTc.idkeyStat(1317L, 3L, 1L, true);
      }
      if (fyy()) {
        e.wTc.idkeyStat(1317L, 5L, 1L, true);
      }
      if (fyx()) {
        e.wTc.idkeyStat(1317L, 7L, 1L, true);
      }
      if (fyz()) {
        e.wTc.idkeyStat(1317L, 9L, 1L, true);
      }
    }
    AppMethodBeat.o(182929);
  }
  
  public static boolean fyv()
  {
    try
    {
      AppMethodBeat.i(182930);
      if (Juu == null) {
        Juu = Boolean.valueOf(b.eTQ());
      }
      boolean bool = Juu.booleanValue();
      AppMethodBeat.o(182930);
      return bool;
    }
    finally {}
  }
  
  /* Error */
  public static boolean fyw()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_0
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc 112
    //   7: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: getstatic 14	com/tencent/mm/vfs/p:Juq	Ljava/lang/Boolean;
    //   13: ifnonnull +113 -> 126
    //   16: ldc 33
    //   18: ldc 114
    //   20: invokestatic 118	com/tencent/mm/vfs/p:me	(Ljava/lang/String;Ljava/lang/String;)[Z
    //   23: astore_1
    //   24: aload_1
    //   25: iconst_0
    //   26: baload
    //   27: invokestatic 108	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   30: putstatic 14	com/tencent/mm/vfs/p:Juq	Ljava/lang/Boolean;
    //   33: aload_1
    //   34: iconst_1
    //   35: baload
    //   36: ifeq +12 -> 48
    //   39: ldc2_w 64
    //   42: ldc2_w 119
    //   45: invokestatic 126	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:as	(JJ)V
    //   48: getstatic 14	com/tencent/mm/vfs/p:Juq	Ljava/lang/Boolean;
    //   51: invokevirtual 111	java/lang/Boolean:booleanValue	()Z
    //   54: ifne +72 -> 126
    //   57: invokestatic 132	com/tencent/mm/plugin/expt/e/b:cmk	()Lcom/tencent/mm/plugin/expt/e/b;
    //   60: ldc 134
    //   62: ldc 136
    //   64: iconst_0
    //   65: iconst_1
    //   66: invokevirtual 140	com/tencent/mm/plugin/expt/e/b:b	(Ljava/lang/String;Ljava/lang/String;ZZ)Ljava/lang/String;
    //   69: iconst_0
    //   70: invokestatic 146	com/tencent/mm/sdk/platformtools/bs:getInt	(Ljava/lang/String;I)I
    //   73: ifle +70 -> 143
    //   76: iload_0
    //   77: invokestatic 108	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   80: astore_1
    //   81: aload_1
    //   82: putstatic 14	com/tencent/mm/vfs/p:Juq	Ljava/lang/Boolean;
    //   85: aload_1
    //   86: invokevirtual 111	java/lang/Boolean:booleanValue	()Z
    //   89: ifeq +37 -> 126
    //   92: ldc 33
    //   94: ldc 114
    //   96: invokestatic 150	com/tencent/mm/vfs/p:mf	(Ljava/lang/String;Ljava/lang/String;)Z
    //   99: pop
    //   100: ldc 152
    //   102: ldc 154
    //   104: iconst_1
    //   105: anewarray 4	java/lang/Object
    //   108: dup
    //   109: iconst_0
    //   110: ldc 33
    //   112: ldc 114
    //   114: invokestatic 118	com/tencent/mm/vfs/p:me	(Ljava/lang/String;Ljava/lang/String;)[Z
    //   117: iconst_0
    //   118: baload
    //   119: invokestatic 108	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   122: aastore
    //   123: invokestatic 159	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   126: getstatic 14	com/tencent/mm/vfs/p:Juq	Ljava/lang/Boolean;
    //   129: invokevirtual 111	java/lang/Boolean:booleanValue	()Z
    //   132: istore_0
    //   133: ldc 112
    //   135: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: ldc 2
    //   140: monitorexit
    //   141: iload_0
    //   142: ireturn
    //   143: iconst_0
    //   144: istore_0
    //   145: goto -69 -> 76
    //   148: astore_1
    //   149: ldc 2
    //   151: monitorexit
    //   152: aload_1
    //   153: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	144	0	bool	boolean
    //   23	63	1	localObject1	Object
    //   148	5	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   5	33	148	finally
    //   39	48	148	finally
    //   48	76	148	finally
    //   76	126	148	finally
    //   126	138	148	finally
  }
  
  public static boolean fyx()
  {
    try
    {
      AppMethodBeat.i(182932);
      if (Jur == null) {
        Jur = Boolean.valueOf(b.eTZ());
      }
      boolean bool = Jur.booleanValue();
      AppMethodBeat.o(182932);
      return bool;
    }
    finally {}
  }
  
  public static boolean fyy()
  {
    try
    {
      AppMethodBeat.i(182933);
      if (Jus == null) {
        Jus = Boolean.valueOf(fyw());
      }
      boolean bool = Jus.booleanValue();
      AppMethodBeat.o(182933);
      return bool;
    }
    finally {}
  }
  
  public static boolean fyz()
  {
    label64:
    for (;;)
    {
      try
      {
        AppMethodBeat.i(182934);
        if (Jut == null)
        {
          if (fyw()) {
            break label64;
          }
          if (fyx())
          {
            break label64;
            Jut = Boolean.valueOf(bool);
          }
        }
        else
        {
          bool = Jut.booleanValue();
          AppMethodBeat.o(182934);
          return bool;
        }
        boolean bool = false;
        continue;
        bool = true;
      }
      finally {}
    }
  }
  
  public static boolean[] me(String paramString1, String paramString2)
  {
    AppMethodBeat.i(206989);
    Object localObject = paramString1 + "@@1";
    paramString1 = aw.aKT(paramString1);
    localObject = aw.aKT((String)localObject);
    boolean bool1 = paramString1.decodeBool(paramString2, false);
    boolean bool2 = ((aw)localObject).decodeBool(paramString2, false);
    int i;
    if ((bool1) || (bool2))
    {
      i = 1;
      if (i == 0) {
        break label129;
      }
      if (bool1) {
        break label124;
      }
      paramString1.encode(paramString2, true);
      bool1 = true;
      label82:
      if (!bool2)
      {
        bool1 = ((aw)localObject).containsKey(paramString2);
        ((aw)localObject).encode(paramString2, true);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(206989);
      return new boolean[] { i, bool1 };
      i = 0;
      break;
      label124:
      bool1 = false;
      break label82;
      label129:
      bool1 = false;
    }
  }
  
  public static boolean mf(String paramString1, String paramString2)
  {
    AppMethodBeat.i(206990);
    boolean bool1 = aw.aKT(paramString1).encode(paramString2, true);
    boolean bool2 = aw.aKT(paramString1 + "@@1").encode(paramString2, true);
    if ((bool1) || (bool2))
    {
      AppMethodBeat.o(206990);
      return true;
    }
    AppMethodBeat.o(206990);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.p
 * JD-Core Version:    0.7.0.1
 */