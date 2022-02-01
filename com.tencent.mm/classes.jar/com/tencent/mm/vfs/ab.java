package com.tencent.mm.vfs;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.cs;
import com.tencent.mm.graphics.MMBitmapFactory.b;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor;
import com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

public final class ab
{
  private static volatile boolean LvD;
  private static final q YFA;
  private static final ab.a YFq;
  static boolean YFr;
  private static boolean YFs;
  private static volatile boolean YFt;
  private static volatile boolean YFu;
  private static volatile boolean YFv;
  private static final HashSet<String> YFw;
  private static volatile String YFx;
  private static String YFy;
  private static final q YFz;
  
  static
  {
    q localq1 = null;
    AppMethodBeat.i(176883);
    YFq = new ab.a((byte)0);
    YFs = false;
    YFt = false;
    YFu = false;
    YFv = false;
    YFw = new HashSet();
    YFx = "";
    YFy = null;
    YFz = new q(q.Q(MMApplicationContext.getContext().getCacheDir()), "temp");
    q localq2 = q.Q(MMApplicationContext.getContext().getExternalCacheDir());
    if (localq2 == null) {}
    for (;;)
    {
      YFA = localq1;
      AppMethodBeat.o(176883);
      return;
      localq1 = new q(localq2, "temp");
    }
  }
  
  private static void HY(boolean paramBoolean)
  {
    AppMethodBeat.i(196599);
    Log.i("VFS.VFSStrategy", "Broadcasting enabled.");
    h localh = h.iWH();
    h.a locala = localh.iWK();
    e.c(locala);
    e.d(locala);
    c.a(locala);
    locala.commit();
    e.init();
    localh.ER(true);
    localh.publish();
    if (paramBoolean)
    {
      localh.a(i.YCR);
      localh.bh(420000L, 86400000L);
    }
    AppMethodBeat.o(196599);
  }
  
  /* Error */
  public static void HZ(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iconst_0
    //   3: istore_1
    //   4: ldc 2
    //   6: monitorenter
    //   7: ldc 167
    //   9: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: ldc 103
    //   14: ldc 169
    //   16: invokestatic 110	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: iconst_1
    //   20: putstatic 47	com/tencent/mm/vfs/ab:YFt	Z
    //   23: ldc 2
    //   25: monitorenter
    //   26: iload_3
    //   27: istore_2
    //   28: getstatic 171	com/tencent/mm/vfs/ab:LvD	Z
    //   31: ifeq +31 -> 62
    //   34: iload_3
    //   35: istore_2
    //   36: getstatic 49	com/tencent/mm/vfs/ab:YFu	Z
    //   39: ifeq +23 -> 62
    //   42: getstatic 51	com/tencent/mm/vfs/ab:YFv	Z
    //   45: ifne +5 -> 50
    //   48: iconst_1
    //   49: istore_1
    //   50: iload_1
    //   51: istore_2
    //   52: iload_1
    //   53: ifeq +9 -> 62
    //   56: iconst_1
    //   57: putstatic 51	com/tencent/mm/vfs/ab:YFv	Z
    //   60: iload_1
    //   61: istore_2
    //   62: ldc 2
    //   64: monitorexit
    //   65: iload_2
    //   66: ifeq +7 -> 73
    //   69: iload_0
    //   70: invokestatic 173	com/tencent/mm/vfs/ab:HY	(Z)V
    //   73: ldc 167
    //   75: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: ldc 2
    //   80: monitorexit
    //   81: return
    //   82: astore 4
    //   84: ldc 2
    //   86: monitorexit
    //   87: ldc 167
    //   89: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: aload 4
    //   94: athrow
    //   95: astore 4
    //   97: ldc 2
    //   99: monitorexit
    //   100: aload 4
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	paramBoolean	boolean
    //   3	58	1	i	int
    //   27	39	2	j	int
    //   1	34	3	k	int
    //   82	11	4	localObject1	Object
    //   95	6	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   28	34	82	finally
    //   36	42	82	finally
    //   42	48	82	finally
    //   56	60	82	finally
    //   62	65	82	finally
    //   7	26	95	finally
    //   69	73	95	finally
    //   73	78	95	finally
    //   84	95	95	finally
  }
  
  private static AbstractFileSystem a(String paramString, String[] paramArrayOfString, int paramInt)
  {
    ArrayList localArrayList = null;
    Object localObject1 = null;
    int m = 1;
    int k = 1;
    AppMethodBeat.i(196570);
    if ((paramArrayOfString.length == 1) || ((paramInt & 0x40) != 0))
    {
      paramString = aF(paramString, paramArrayOfString[0], paramInt);
      AppMethodBeat.o(196570);
      return paramString;
    }
    int i;
    if ((paramInt & 0x400) != 0)
    {
      i = 1;
      if ((paramInt & 0x83) != 131) {
        break label157;
      }
      j = 1;
    }
    label157:
    for (;;)
    {
      label70:
      if (j != 0)
      {
        localArrayList = new ArrayList();
        localObject2 = new ArrayList();
        AbstractFileSystem localAbstractFileSystem = aF(paramString, paramArrayOfString[0], paramInt);
        j = k;
        for (;;)
        {
          if (j < paramArrayOfString.length)
          {
            localObject3 = paramArrayOfString[j];
            if (!((String)localObject3).contains("${sd"))
            {
              localArrayList.add(aF(paramString, (String)localObject3, paramInt));
              j += 1;
              continue;
              i = 0;
              break;
              j = 0;
              break label70;
            }
          }
        }
        if (j >= paramArrayOfString.length)
        {
          paramString = new RuntimeException("No SDCard paths?!");
          AppMethodBeat.o(196570);
          throw paramString;
        }
        Object localObject3 = aF(paramString, paramArrayOfString[j], paramInt);
        j += 1;
        while (j < paramArrayOfString.length)
        {
          ((ArrayList)localObject2).add(aF(paramString, paramArrayOfString[j], paramInt));
          j += 1;
        }
        paramString = (String)localObject1;
        if (i != 0) {
          paramString = "${sdFrom}";
        }
        localArrayList.add(new MigrationFileSystem("${sdFrom}", "${sdFrom}", paramString, (FileSystem)localObject3, (FileSystem[])((ArrayList)localObject2).toArray(new FileSystem[0])));
        paramString = new MigrationFileSystem(localAbstractFileSystem, (FileSystem[])localArrayList.toArray(new FileSystem[0]));
        AppMethodBeat.o(196570);
        return paramString;
      }
    }
    Object localObject2 = new FileSystem[paramArrayOfString.length - 1];
    int j = m;
    while (j < paramArrayOfString.length)
    {
      localObject2[(j - 1)] = aF(paramString, paramArrayOfString[j], paramInt);
      j += 1;
    }
    localObject1 = localArrayList;
    if (i != 0) {
      localObject1 = "${sdFrom}";
    }
    paramString = new MigrationFileSystem("${sdFrom}", "${sdFrom}", (String)localObject1, aF(paramString, paramArrayOfString[0], paramInt), (FileSystem[])localObject2);
    AppMethodBeat.o(196570);
    return paramString;
  }
  
  public static h.a a(h.a parama, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(133524);
    Log.i("VFS.VFSStrategy", "Update account migration: sysPath = " + paramString + ", useSaltPath = " + paramBoolean);
    String str = YFx;
    if (paramBoolean)
    {
      MigrationFileSystem localMigrationFileSystem = new MigrationFileSystem("${sdFrom}", "${sdFrom}", new NativeFileSystem(paramString + "${accountSalt}"), new FileSystem[] { new NativeFileSystem(paramString + "${account}"), new NativeFileSystem(com.tencent.mm.loader.j.b.aSK() + "${accountSalt}"), new NativeFileSystem(com.tencent.mm.loader.j.b.aSK() + "${account}") });
      YFx = paramString;
      parama = parama.a("accPathMigration", localMigrationFileSystem).bBG(str + "${accountSalt}").bBG(str + "${account}").oi(paramString + "${accountSalt}", "accPathMigration").oi(paramString + "${account}", "accPathMigration");
      AppMethodBeat.o(133524);
      return parama;
    }
    YFx = "";
    parama = parama.bBF("accPathMigration").bBG(str + "${accountSalt}").bBG(str + "${account}");
    AppMethodBeat.o(133524);
    return parama;
  }
  
  public static h.a a(h.a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(133523);
    Object localObject = MMApplicationContext.getContext();
    Log.i("VFS.VFSStrategy", "Update SDCard status: isSDCardAvailAndSysPathOk = ".concat(String.valueOf(paramBoolean1)));
    if (paramBoolean1)
    {
      String str1 = com.tencent.mm.loader.j.b.aSG() + "/tencent";
      String str2 = com.tencent.mm.loader.j.b.aSH();
      localObject = ((Context)localObject).getExternalCacheDir();
      if (!paramBoolean2)
      {
        Log.w("VFS.VFSStrategy", "do not use external private storage.");
        localObject = null;
      }
      h.a locala = parama.oj("sdFrom", str1);
      if (localObject == null)
      {
        parama = str1;
        locala = locala.oj("sdTo", parama);
        if (localObject != null) {
          break label166;
        }
      }
      label166:
      for (parama = str1 + "/MicroMsg";; parama = ((File)localObject).getPath())
      {
        parama = locala.oj("sdToCache", parama).oj("extSDFrom", str2);
        AppMethodBeat.o(133523);
        return parama;
        parama = ((File)localObject).getParent();
        break;
      }
    }
    localObject = ((Context)localObject).getCacheDir();
    parama = parama.bBH("sdFrom").bBH("extSDFrom").oj("sdTo", ((File)localObject).getParent()).oj("sdToCache", ((File)localObject).getPath());
    AppMethodBeat.o(133523);
    return parama;
  }
  
  private static void a(String paramString, FileSystem paramFileSystem, String[] paramArrayOfString, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(196584);
    synchronized (YFw)
    {
      if (!YFw.add(paramString))
      {
        paramString = new AssertionError("Duplicated name for filesystems: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(196584);
        throw paramString;
      }
    }
    ??? = h.iWH().iWK().a(paramString, paramFileSystem);
    int k = paramArrayOfString.length;
    int i = 0;
    while (i < k)
    {
      ((h.a)???).oi(paramArrayOfString[i], paramString);
      i += 1;
    }
    if (((paramInt & 0x40) != 0) && (paramArrayOfString.length > 1)) {
      if (paramArrayOfString.length != 2) {
        break label181;
      }
    }
    for (paramFileSystem = new DeleteAllFileSystem(new NativeFileSystem(paramArrayOfString[1]));; paramFileSystem = new MaintenanceGroup(paramFileSystem))
    {
      ((h.a)???).b("@DeleteAll-".concat(String.valueOf(paramString)), paramFileSystem);
      ((h.a)???).commit();
      AppMethodBeat.o(196584);
      return;
      label181:
      paramFileSystem = new FileSystem[paramArrayOfString.length - 1];
      paramInt = j;
      while (paramInt < paramFileSystem.length)
      {
        paramFileSystem[paramInt] = new DeleteAllFileSystem(new NativeFileSystem(paramArrayOfString[(paramInt + 1)]));
        paramInt += 1;
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    AppMethodBeat.i(196548);
    if (!LvD)
    {
      AppMethodBeat.o(196548);
      return;
    }
    paramString1 = bBZ(paramString1);
    paramString2 = bBZ(paramString2);
    paramInt |= 0x20;
    String[] arrayOfString = hZ(paramString2, paramInt);
    Object localObject = new StatisticsFileSystem(a(paramString1, arrayOfString, paramInt));
    ((AbstractFileSystem)localObject).a(paramString1, new e(arrayOfString[0], 3, paramInt, 0L, paramLong));
    localObject = new ExpireFileSystem((FileSystem)localObject, paramLong);
    ((ExpireFileSystem)localObject).a(paramString1, aa.ifO());
    a(paramString1, (FileSystem)localObject, arrayOfString, paramInt);
    e.hY(paramString2, paramInt);
    b.bBE(paramString1);
    AppMethodBeat.o(196548);
  }
  
  public static void a(String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(196544);
    if (!LvD)
    {
      AppMethodBeat.o(196544);
      return;
    }
    paramString1 = bBZ(paramString1);
    paramString2 = bBZ(paramString2);
    String[] arrayOfString = hZ(paramString2, paramInt);
    Object localObject = new StatisticsFileSystem(a(paramString1, arrayOfString, paramInt));
    ((AbstractFileSystem)localObject).a(paramString1, new e(arrayOfString[0], 4, paramInt, paramLong1 / 2L, paramLong2));
    localObject = new QuotaFileSystem((FileSystem)localObject, paramLong1 / 2L, paramLong1, paramLong2);
    ((QuotaFileSystem)localObject).a(paramString1, aa.ifO());
    a(paramString1, (FileSystem)localObject, arrayOfString, paramInt);
    e.hY(paramString2, paramInt);
    b.bBE(paramString1);
    AppMethodBeat.o(196544);
  }
  
  public static void aE(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(133511);
    if (!LvD)
    {
      AppMethodBeat.o(133511);
      return;
    }
    paramString1 = bBZ(paramString1);
    paramString2 = bBZ(paramString2);
    String[] arrayOfString = hZ(paramString2, paramInt);
    Object localObject = a(paramString1, arrayOfString, paramInt);
    ((AbstractFileSystem)localObject).a(paramString1, aa.ifO());
    localObject = new StatisticsFileSystem((FileSystem)localObject);
    ((AbstractFileSystem)localObject).a(paramString1, new e(arrayOfString[0], 1, paramInt, 0L, 0L));
    a(paramString1, (FileSystem)localObject, arrayOfString, paramInt);
    e.hY(paramString2, paramInt);
    AppMethodBeat.o(133511);
  }
  
  private static AbstractFileSystem aF(String paramString1, String paramString2, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(196566);
    paramString2 = new NativeFileSystem(paramString2);
    int i;
    if ((paramInt & 0x8) != 0)
    {
      i = 1;
      if ((paramInt & 0x100) == 0) {
        break label70;
      }
      paramInt = j;
    }
    for (;;)
    {
      if (i != 0)
      {
        if (paramInt != 0)
        {
          paramString1 = new IllegalArgumentException("Linking and encryption cannot be enabled at the same time.");
          AppMethodBeat.o(196566);
          throw paramString1;
          i = 0;
          break;
          label70:
          paramInt = 0;
          continue;
        }
        paramString1 = new RC4EncryptedFileSystem(paramString2, paramString1);
        AppMethodBeat.o(196566);
        return paramString1;
      }
    }
    if (paramInt != 0)
    {
      paramString1 = new RefCountedFileSystem(paramString2);
      AppMethodBeat.o(196566);
      return paramString1;
    }
    AppMethodBeat.o(196566);
    return paramString2;
  }
  
  public static void azf(int paramInt)
  {
    AppMethodBeat.i(133522);
    EventCenter.instance.add(new IListener() {});
    AppMethodBeat.o(133522);
  }
  
  private static String bBZ(String paramString)
  {
    AppMethodBeat.i(133518);
    String str = paramString;
    if (paramString.startsWith("/")) {
      str = paramString.substring(1);
    }
    paramString = str;
    if (str.endsWith("/")) {
      paramString = str.substring(0, str.length() - 1);
    }
    AppMethodBeat.o(133518);
    return paramString;
  }
  
  public static q bCa(String paramString)
  {
    AppMethodBeat.i(196612);
    paramString = new q(YFz, paramString);
    paramString.ifL();
    AppMethodBeat.o(196612);
    return paramString;
  }
  
  private static h.a f(h.a parama)
  {
    try
    {
      AppMethodBeat.i(185096);
      if (YFy != null)
      {
        parama.bBF("camera-path-remapfs");
        parama.bBG(YFy);
      }
      String str1 = com.tencent.mm.loader.j.b.aSW();
      String str2 = com.tencent.mm.loader.j.b.aSK();
      ExtStorageMigrateMonitor.hsJ().i("VFS.VFSStrategy", "[+] updateMigratePathRemappings, lastMountNewCameraPath: %s, newCameraPath: %s", new Object[] { YFy, str1 });
      if (com.tencent.mm.loader.j.b.aSW().equals(com.tencent.mm.loader.j.b.aSV()))
      {
        ExtStorageMigrateMonitor.hsJ().e("VFS.VFSStrategy", "[-] Fail to get new camera path, and we use old camera path for fallback.", new Object[0]);
        if (MMApplicationContext.isMainProcess()) {
          ExtStorageMigrateMonitor.Um(142L);
        }
      }
      YFy = str1;
      parama.a("camera-path-remapfs", new MigrationFileSystem(new NativeFileSystem(str1), new FileSystem[] { new NativeFileSystem(str2 + "WeChat/"), new NativeFileSystem(str2 + "WeiXin/") })).oi(str1, "camera-path-remapfs").oi(str2 + "WeChat/", "camera-path-remapfs").oi(str2 + "WeiXin/", "camera-path-remapfs");
      AppMethodBeat.o(185096);
      return parama;
    }
    finally {}
  }
  
  /* Error */
  public static void h(com.tencent.mm.kernel.b.g paramg)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc_w 512
    //   8: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_0
    //   12: invokevirtual 517	com/tencent/mm/kernel/b/g:aIE	()Z
    //   15: istore_3
    //   16: iload_3
    //   17: putstatic 171	com/tencent/mm/vfs/ab:LvD	Z
    //   20: new 311	java/io/File
    //   23: dup
    //   24: aload_0
    //   25: getfield 521	com/tencent/mm/kernel/b/g:Zw	Landroid/app/Application;
    //   28: invokevirtual 524	android/content/Context:getFilesDir	()Ljava/io/File;
    //   31: invokevirtual 527	java/io/File:getParentFile	()Ljava/io/File;
    //   34: ldc_w 529
    //   37: invokespecial 532	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   40: invokevirtual 535	java/io/File:exists	()Z
    //   43: ifne +122 -> 165
    //   46: iconst_1
    //   47: istore_1
    //   48: iload_1
    //   49: putstatic 537	com/tencent/mm/vfs/ab:YFr	Z
    //   52: aload_0
    //   53: getfield 521	com/tencent/mm/kernel/b/g:Zw	Landroid/app/Application;
    //   56: invokestatic 541	com/tencent/mm/vfs/h:setContext	(Landroid/content/Context;)V
    //   59: iload_3
    //   60: ifne +110 -> 170
    //   63: iload_2
    //   64: istore_1
    //   65: iload_1
    //   66: invokestatic 544	com/tencent/mm/vfs/h:Bu	(Z)V
    //   69: getstatic 43	com/tencent/mm/vfs/ab:YFq	Lcom/tencent/mm/vfs/ab$a;
    //   72: invokestatic 547	com/tencent/mm/vfs/h:a	(Lcom/tencent/mm/vfs/h$b;)V
    //   75: invokestatic 116	com/tencent/mm/vfs/h:iWH	()Lcom/tencent/mm/vfs/h;
    //   78: pop
    //   79: invokestatic 476	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:hsJ	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
    //   82: ldc 103
    //   84: new 223	java/lang/StringBuilder
    //   87: dup
    //   88: ldc_w 549
    //   91: invokespecial 226	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   94: iload_3
    //   95: invokevirtual 235	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   98: ldc_w 551
    //   101: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokestatic 556	com/tencent/mm/vfs/ac:igr	()Z
    //   107: invokevirtual 235	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   110: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: iconst_0
    //   114: anewarray 4	java/lang/Object
    //   117: invokeinterface 483 4 0
    //   122: invokestatic 476	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:hsJ	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
    //   125: ldc 103
    //   127: ldc_w 558
    //   130: iconst_1
    //   131: anewarray 4	java/lang/Object
    //   134: dup
    //   135: iconst_0
    //   136: invokestatic 291	com/tencent/mm/loader/j/b:aSH	()Ljava/lang/String;
    //   139: aastore
    //   140: invokeinterface 483 4 0
    //   145: invokestatic 561	com/tencent/mm/loader/j/b:aTN	()V
    //   148: invokestatic 291	com/tencent/mm/loader/j/b:aSH	()Ljava/lang/String;
    //   151: iconst_1
    //   152: invokestatic 565	com/tencent/mm/loader/j/b:C	(Ljava/lang/String;Z)V
    //   155: ldc_w 512
    //   158: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: ldc 2
    //   163: monitorexit
    //   164: return
    //   165: iconst_0
    //   166: istore_1
    //   167: goto -119 -> 48
    //   170: iconst_0
    //   171: istore_1
    //   172: goto -107 -> 65
    //   175: astore_0
    //   176: invokestatic 476	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:hsJ	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
    //   179: ldc 103
    //   181: aload_0
    //   182: ldc_w 567
    //   185: iconst_0
    //   186: anewarray 4	java/lang/Object
    //   189: invokeinterface 571 5 0
    //   194: goto -72 -> 122
    //   197: astore_0
    //   198: ldc 2
    //   200: monitorexit
    //   201: aload_0
    //   202: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	paramg	com.tencent.mm.kernel.b.g
    //   47	125	1	bool1	boolean
    //   1	63	2	bool2	boolean
    //   15	80	3	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   79	122	175	java/lang/Throwable
    //   5	46	197	finally
    //   48	59	197	finally
    //   65	79	197	finally
    //   79	122	197	finally
    //   122	161	197	finally
    //   176	194	197	finally
  }
  
  private static String[] hZ(String paramString, int paramInt)
  {
    AppMethodBeat.i(133514);
    int i;
    int j;
    label28:
    int k;
    label46:
    int m;
    if ((paramInt & 0x800) != 0)
    {
      i = 1;
      if ((i != 0) || ((paramInt & 0x4) != 0)) {
        break label96;
      }
      j = 1;
      if (((paramInt & 0x20) == 0) || ((paramInt & 0x200) != 0)) {
        break label101;
      }
      k = 1;
      if ((paramInt & 0x1) == 0) {
        break label107;
      }
      m = 1;
      label55:
      if ((paramInt & 0x2) == 0) {
        break label113;
      }
    }
    label96:
    label101:
    label107:
    label113:
    for (paramInt = 1;; paramInt = 0)
    {
      if ((paramInt != 0) || (m != 0)) {
        break label118;
      }
      paramString = new IllegalArgumentException("At least one of FLAG_SDCARD and FLAG_DATA must be set.");
      AppMethodBeat.o(133514);
      throw paramString;
      i = 0;
      break;
      j = 0;
      break label28;
      k = 0;
      break label46;
      m = 0;
      break label55;
    }
    label118:
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    String str1;
    String str2;
    if (i != 0)
    {
      str1 = "";
      if (paramInt != 0)
      {
        if (j == 0) {
          break label457;
        }
        str2 = "${account}/";
        label148:
        if (k != 0) {
          localLinkedHashSet.add("${dataCache}/" + str2 + paramString);
        }
        localLinkedHashSet.add("${data}/" + str1 + str2 + paramString);
      }
      if (m != 0)
      {
        if (j == 0) {
          break label464;
        }
        str2 = "${accountSalt}/";
        label228:
        if (j == 0) {
          break label471;
        }
      }
    }
    label457:
    label464:
    label471:
    for (String str3 = "${account}/";; str3 = "")
    {
      if (k != 0) {
        localLinkedHashSet.add("${sdToCache}/" + str2 + paramString);
      }
      localLinkedHashSet.add("${sdTo}/" + str1 + str2 + paramString);
      localLinkedHashSet.add("${sdTo}/" + str1 + str3 + paramString);
      localLinkedHashSet.add("${sdFrom}/" + str1 + str2 + paramString);
      localLinkedHashSet.add("${sdFrom}/" + str1 + str3 + paramString);
      paramString = (String[])localLinkedHashSet.toArray(new String[0]);
      if (paramString[0].contains("{$sdTo")) {
        paramString[0] = paramString[0].replace("${accountSalt}", "${accountSd}");
      }
      AppMethodBeat.o(133514);
      return paramString;
      str1 = "MicroMsg/";
      break;
      str2 = "";
      break label148;
      str2 = "";
      break label228;
    }
  }
  
  /* Error */
  public static void i(com.tencent.mm.kernel.b.g paramg)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc_w 606
    //   8: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_0
    //   12: invokevirtual 517	com/tencent/mm/kernel/b/g:aIE	()Z
    //   15: istore_2
    //   16: iload_2
    //   17: putstatic 171	com/tencent/mm/vfs/ab:LvD	Z
    //   20: iconst_1
    //   21: putstatic 45	com/tencent/mm/vfs/ab:YFs	Z
    //   24: iload_2
    //   25: ifne +229 -> 254
    //   28: iload_1
    //   29: invokestatic 544	com/tencent/mm/vfs/h:Bu	(Z)V
    //   32: getstatic 43	com/tencent/mm/vfs/ab:YFq	Lcom/tencent/mm/vfs/ab$a;
    //   35: invokestatic 547	com/tencent/mm/vfs/h:a	(Lcom/tencent/mm/vfs/h$b;)V
    //   38: iload_2
    //   39: ifeq +195 -> 234
    //   42: new 372	com/tencent/mm/vfs/ExpireFileSystem
    //   45: dup
    //   46: new 241	com/tencent/mm/vfs/NativeFileSystem
    //   49: dup
    //   50: ldc_w 608
    //   53: invokespecial 245	com/tencent/mm/vfs/NativeFileSystem:<init>	(Ljava/lang/String;)V
    //   56: ldc2_w 609
    //   59: invokespecial 375	com/tencent/mm/vfs/ExpireFileSystem:<init>	(Lcom/tencent/mm/vfs/FileSystem;J)V
    //   62: astore_0
    //   63: new 372	com/tencent/mm/vfs/ExpireFileSystem
    //   66: dup
    //   67: new 241	com/tencent/mm/vfs/NativeFileSystem
    //   70: dup
    //   71: ldc_w 612
    //   74: invokespecial 245	com/tencent/mm/vfs/NativeFileSystem:<init>	(Ljava/lang/String;)V
    //   77: ldc2_w 609
    //   80: invokespecial 375	com/tencent/mm/vfs/ExpireFileSystem:<init>	(Lcom/tencent/mm/vfs/FileSystem;J)V
    //   83: astore_3
    //   84: invokestatic 116	com/tencent/mm/vfs/h:iWH	()Lcom/tencent/mm/vfs/h;
    //   87: astore 4
    //   89: aload 4
    //   91: iconst_0
    //   92: invokevirtual 145	com/tencent/mm/vfs/h:ER	(Z)V
    //   95: aload 4
    //   97: invokevirtual 120	com/tencent/mm/vfs/h:iWK	()Lcom/tencent/mm/vfs/h$a;
    //   100: invokevirtual 615	com/tencent/mm/vfs/h$a:ifn	()Lcom/tencent/mm/vfs/h$a;
    //   103: ldc_w 617
    //   106: invokestatic 623	com/tencent/mm/vfs/AssetsSchemeResolver:ieW	()Lcom/tencent/mm/vfs/AssetsSchemeResolver;
    //   109: invokevirtual 626	com/tencent/mm/vfs/h$a:a	(Ljava/lang/String;Lcom/tencent/mm/vfs/SchemeResolver;)Lcom/tencent/mm/vfs/h$a;
    //   112: ldc_w 628
    //   115: invokestatic 634	com/tencent/mm/vfs/ContentsSchemeResolver:ifb	()Lcom/tencent/mm/vfs/SchemeResolver;
    //   118: invokevirtual 626	com/tencent/mm/vfs/h$a:a	(Ljava/lang/String;Lcom/tencent/mm/vfs/SchemeResolver;)Lcom/tencent/mm/vfs/h$a;
    //   121: ldc_w 636
    //   124: new 241	com/tencent/mm/vfs/NativeFileSystem
    //   127: dup
    //   128: ldc_w 638
    //   131: invokespecial 245	com/tencent/mm/vfs/NativeFileSystem:<init>	(Ljava/lang/String;)V
    //   134: invokevirtual 260	com/tencent/mm/vfs/h$a:a	(Ljava/lang/String;Lcom/tencent/mm/vfs/FileSystem;)Lcom/tencent/mm/vfs/h$a;
    //   137: ldc_w 640
    //   140: new 241	com/tencent/mm/vfs/NativeFileSystem
    //   143: dup
    //   144: ldc_w 642
    //   147: invokespecial 245	com/tencent/mm/vfs/NativeFileSystem:<init>	(Ljava/lang/String;)V
    //   150: invokevirtual 260	com/tencent/mm/vfs/h$a:a	(Ljava/lang/String;Lcom/tencent/mm/vfs/FileSystem;)Lcom/tencent/mm/vfs/h$a;
    //   153: ldc 83
    //   155: aload_0
    //   156: invokevirtual 260	com/tencent/mm/vfs/h$a:a	(Ljava/lang/String;Lcom/tencent/mm/vfs/FileSystem;)Lcom/tencent/mm/vfs/h$a;
    //   159: ldc_w 644
    //   162: aload_3
    //   163: invokevirtual 260	com/tencent/mm/vfs/h$a:a	(Ljava/lang/String;Lcom/tencent/mm/vfs/FileSystem;)Lcom/tencent/mm/vfs/h$a;
    //   166: ldc_w 638
    //   169: ldc_w 636
    //   172: invokevirtual 268	com/tencent/mm/vfs/h$a:oi	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/vfs/h$a;
    //   175: ldc_w 642
    //   178: ldc_w 640
    //   181: invokevirtual 268	com/tencent/mm/vfs/h$a:oi	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/vfs/h$a;
    //   184: ldc_w 608
    //   187: ldc 83
    //   189: invokevirtual 268	com/tencent/mm/vfs/h$a:oi	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/vfs/h$a;
    //   192: ldc_w 612
    //   195: ldc_w 644
    //   198: invokevirtual 268	com/tencent/mm/vfs/h$a:oi	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/vfs/h$a;
    //   201: astore_0
    //   202: aload_0
    //   203: invokestatic 648	com/tencent/mm/vfs/p:e	(Lcom/tencent/mm/vfs/h$a;)V
    //   206: aload_0
    //   207: invokestatic 650	com/tencent/mm/vfs/ab:f	(Lcom/tencent/mm/vfs/h$a;)Lcom/tencent/mm/vfs/h$a;
    //   210: pop
    //   211: aload_0
    //   212: invokestatic 655	com/tencent/mm/compatible/util/e:avA	()Z
    //   215: iconst_1
    //   216: invokestatic 657	com/tencent/mm/vfs/ab:a	(Lcom/tencent/mm/vfs/h$a;ZZ)Lcom/tencent/mm/vfs/h$a;
    //   219: iconst_0
    //   220: invokevirtual 660	com/tencent/mm/vfs/h$a:HX	(Z)V
    //   223: ldc 83
    //   225: invokestatic 393	com/tencent/mm/vfs/b:bBE	(Ljava/lang/String;)V
    //   228: ldc_w 644
    //   231: invokestatic 393	com/tencent/mm/vfs/b:bBE	(Ljava/lang/String;)V
    //   234: new 6	com/tencent/mm/vfs/ab$1
    //   237: dup
    //   238: invokespecial 661	com/tencent/mm/vfs/ab$1:<init>	()V
    //   241: invokestatic 667	com/tencent/mm/graphics/MMBitmapFactory:setStreamProvider	(Lcom/tencent/mm/graphics/MMBitmapFactory$b;)V
    //   244: ldc_w 606
    //   247: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   250: ldc 2
    //   252: monitorexit
    //   253: return
    //   254: iconst_0
    //   255: istore_1
    //   256: goto -228 -> 28
    //   259: astore_0
    //   260: ldc 2
    //   262: monitorexit
    //   263: aload_0
    //   264: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	paramg	com.tencent.mm.kernel.b.g
    //   1	255	1	bool1	boolean
    //   15	24	2	bool2	boolean
    //   83	80	3	localExpireFileSystem	ExpireFileSystem
    //   87	9	4	localh	h
    // Exception table:
    //   from	to	target	type
    //   5	24	259	finally
    //   28	38	259	finally
    //   42	234	259	finally
    //   234	250	259	finally
  }
  
  public static void igo()
  {
    int k = 0;
    int i = 0;
    AppMethodBeat.i(133520);
    Log.i("VFS.VFSStrategy", "Configuration done.");
    YFu = true;
    int j = k;
    try
    {
      if (LvD)
      {
        j = k;
        if (YFt)
        {
          if (!YFv) {
            i = 1;
          }
          j = i;
          if (i != 0)
          {
            YFv = true;
            j = i;
          }
        }
      }
      if (j != 0) {
        HY(com.tencent.mm.compatible.util.e.avA());
      }
      AppMethodBeat.o(133520);
      return;
    }
    finally
    {
      AppMethodBeat.o(133520);
    }
  }
  
  public static void igp()
  {
    AppMethodBeat.i(185097);
    ExtStorageMigrateMonitor.hsJ().i("VFS.VFSStrategy", "[+] updateSdCardPathOnDemand called.", new Object[0]);
    ExtStorageMigrateMonitor.hsJ().i("VFS.VFSStrategy", "[+] updateSdCardPathOnDemand, isPathRemapOpened, NEW_SDCARD_ROOT: %s", new Object[] { com.tencent.mm.loader.j.b.aSH() });
    com.tencent.mm.loader.j.b.aTN();
    com.tencent.mm.loader.j.b.C(com.tencent.mm.loader.j.b.aSH(), true);
    if (MMApplicationContext.isMainProcess()) {
      f(h.iWH().iWK()).commit();
    }
    AppMethodBeat.o(185097);
  }
  
  public static void ou(String paramString1, String paramString2)
  {
    AppMethodBeat.i(196555);
    if (!LvD)
    {
      AppMethodBeat.o(196555);
      return;
    }
    paramString1 = bBZ(paramString1);
    paramString2 = bBZ(paramString2);
    String[] arrayOfString = new String[1];
    arrayOfString[0] = paramString2;
    Object localObject = new StatisticsFileSystem(aF(paramString1, arrayOfString[0], 100));
    ((AbstractFileSystem)localObject).a(paramString1, new e(arrayOfString[0], 3, 100, 0L, 2592000000L));
    localObject = new ExpireFileSystem((FileSystem)localObject, 2592000000L);
    ((ExpireFileSystem)localObject).a(paramString1, aa.ifO());
    a(paramString1, (FileSystem)localObject, arrayOfString, 100);
    e.hY(paramString2, 100);
    AppMethodBeat.o(196555);
  }
  
  public static void ov(String paramString1, String paramString2)
  {
    int i = 1;
    AppMethodBeat.i(196559);
    if (Util.getInt(d.dgX().a("clicfg_clean_expire_switch", "1", false, true), 1) > 0) {}
    while (i == 0)
    {
      a(paramString1, paramString2, 604800000L, 17);
      AppMethodBeat.o(196559);
      return;
      i = 0;
    }
    if (!LvD)
    {
      AppMethodBeat.o(196559);
      return;
    }
    paramString1 = bBZ(paramString1);
    paramString2 = bBZ(paramString2);
    String[] arrayOfString = hZ(paramString2, 49);
    Object localObject = new StatisticsFileSystem(a(paramString1, arrayOfString, 49));
    ((AbstractFileSystem)localObject).a(paramString1, new e(arrayOfString[0], 3, 49, 0L, 604800000L));
    localObject = new CleanExpireFileSystem((FileSystem)localObject);
    ((CleanExpireFileSystem)localObject).a(paramString1, aa.ifO());
    a(paramString1, (FileSystem)localObject, arrayOfString, 49);
    e.hY(paramString2, 49);
    b.bBE(paramString1);
    AppMethodBeat.o(196559);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.ab
 * JD-Core Version:    0.7.0.1
 */