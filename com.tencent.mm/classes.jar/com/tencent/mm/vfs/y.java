package com.tencent.mm.vfs;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.co;
import com.tencent.mm.graphics.MMBitmapFactory.b;
import com.tencent.mm.kernel.a;
import com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor;
import com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.File;
import java.io.InputStream;
import java.security.Key;
import java.util.LinkedHashSet;
import java.util.Map;
import javax.crypto.spec.SecretKeySpec;

public final class y
{
  private static volatile boolean FgY;
  private static volatile boolean ReA;
  private static volatile boolean ReB;
  private static volatile boolean ReC;
  private static volatile String ReD;
  private static String ReE;
  private static String ReF;
  private static String ReG;
  private static final o ReH;
  private static final o ReI;
  private static final a Rey;
  private static boolean Rez;
  
  static
  {
    o localo1 = null;
    AppMethodBeat.i(176883);
    Rey = new a((byte)0);
    Rez = false;
    ReA = false;
    ReB = false;
    ReC = false;
    ReD = "";
    ReE = null;
    ReF = null;
    ReG = null;
    ReH = new o(o.X(MMApplicationContext.getContext().getCacheDir()), "temp");
    o localo2 = o.X(MMApplicationContext.getContext().getExternalCacheDir());
    if (localo2 == null) {}
    for (;;)
    {
      ReI = localo1;
      AppMethodBeat.o(176883);
      return;
      localo1 = new o(localo2, "temp");
    }
  }
  
  private static void Dy(boolean paramBoolean)
  {
    AppMethodBeat.i(197250);
    Log.i("VFS.VFSStrategy", "Broadcasting enabled.");
    g localg = g.hRR();
    ??? = localg.hRT();
    d.b((g.a)???);
    d.c((g.a)???);
    b.a((g.a)???);
    ((g.a)???).commit();
    d.init();
    localg.Uvq = true;
    synchronized (localg.mLock)
    {
      Object localObject3 = localg.Uve;
      localg.a((l)localObject3);
      if (paramBoolean)
      {
        ??? = h.Rco;
        localObject3 = localg.Uvp;
        localg.Uvp = ((g.d)???);
        localg.aP(420000L, 86400000L);
      }
      AppMethodBeat.o(197250);
      return;
    }
  }
  
  /* Error */
  public static void Dz(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iconst_0
    //   3: istore_1
    //   4: ldc 2
    //   6: monitorenter
    //   7: ldc 173
    //   9: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: ldc 101
    //   14: ldc 175
    //   16: invokestatic 108	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: iconst_1
    //   20: putstatic 46	com/tencent/mm/vfs/y:ReA	Z
    //   23: ldc 2
    //   25: monitorenter
    //   26: iload_3
    //   27: istore_2
    //   28: getstatic 177	com/tencent/mm/vfs/y:FgY	Z
    //   31: ifeq +31 -> 62
    //   34: iload_3
    //   35: istore_2
    //   36: getstatic 48	com/tencent/mm/vfs/y:ReB	Z
    //   39: ifeq +23 -> 62
    //   42: getstatic 50	com/tencent/mm/vfs/y:ReC	Z
    //   45: ifne +5 -> 50
    //   48: iconst_1
    //   49: istore_1
    //   50: iload_1
    //   51: istore_2
    //   52: iload_1
    //   53: ifeq +9 -> 62
    //   56: iconst_1
    //   57: putstatic 50	com/tencent/mm/vfs/y:ReC	Z
    //   60: iload_1
    //   61: istore_2
    //   62: ldc 2
    //   64: monitorexit
    //   65: iload_2
    //   66: ifeq +7 -> 73
    //   69: iload_0
    //   70: invokestatic 179	com/tencent/mm/vfs/y:Dy	(Z)V
    //   73: ldc 173
    //   75: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: ldc 2
    //   80: monitorexit
    //   81: return
    //   82: astore 4
    //   84: ldc 2
    //   86: monitorexit
    //   87: ldc 173
    //   89: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   84	87	82	finally
    //   7	26	95	finally
    //   69	73	95	finally
    //   73	78	95	finally
    //   87	95	95	finally
  }
  
  private static AbstractFileSystem a(String paramString, String[] paramArrayOfString, int paramInt)
  {
    AppMethodBeat.i(197248);
    if ((paramArrayOfString.length == 1) || ((paramInt & 0x40) != 0))
    {
      paramString = au(paramString, paramArrayOfString[0], paramInt);
      AppMethodBeat.o(197248);
      return paramString;
    }
    FileSystem[] arrayOfFileSystem = new FileSystem[paramArrayOfString.length - 1];
    int i = 1;
    while (i < paramArrayOfString.length)
    {
      arrayOfFileSystem[(i - 1)] = au(paramString, paramArrayOfString[i], paramInt);
      i += 1;
    }
    int j;
    label93:
    String str1;
    label101:
    String str2;
    if ((paramInt & 0x80) == 0)
    {
      i = 1;
      if ((paramInt & 0x400) == 0) {
        break label154;
      }
      j = 1;
      if (i == 0) {
        break label160;
      }
      str1 = "${sdFrom}";
      if (i == 0) {
        break label166;
      }
      str2 = "${sdFrom}";
      label109:
      if (j == 0) {
        break label172;
      }
    }
    label154:
    label160:
    label166:
    label172:
    for (String str3 = "${sdFrom}";; str3 = null)
    {
      paramString = new MigrationFileSystem(str1, str2, str3, au(paramString, paramArrayOfString[0], paramInt), arrayOfFileSystem);
      AppMethodBeat.o(197248);
      return paramString;
      i = 0;
      break;
      j = 0;
      break label93;
      str1 = null;
      break label101;
      str2 = null;
      break label109;
    }
  }
  
  public static g.a a(g.a parama, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(133524);
    Log.i("VFS.VFSStrategy", "Update account migration: sysPath = " + paramString + ", useSaltPath = " + paramBoolean);
    String str = ReD;
    if (paramBoolean)
    {
      if (com.tencent.mm.loader.j.b.aKD().equals(com.tencent.mm.loader.j.b.aKE())) {}
      for (MigrationFileSystem localMigrationFileSystem = new MigrationFileSystem("${sdFrom}", "${sdFrom}", new NativeFileSystem(paramString + "${accountSalt}"), new FileSystem[] { new NativeFileSystem(paramString + "${account}") });; localMigrationFileSystem = new MigrationFileSystem("${sdFrom}", "${sdFrom}", new NativeFileSystem(paramString + "${accountSalt}"), new FileSystem[] { new NativeFileSystem(paramString + "${account}"), new NativeFileSystem(com.tencent.mm.loader.j.b.aKI() + "${accountSalt}"), new NativeFileSystem(com.tencent.mm.loader.j.b.aKI() + "${account}") }))
      {
        ReD = paramString;
        parama = parama.a("accPathMigration", localMigrationFileSystem).boP(str + "${accountSalt}").boP(str + "${account}").ns(paramString + "${accountSalt}", "accPathMigration").ns(paramString + "${account}", "accPathMigration");
        AppMethodBeat.o(133524);
        return parama;
      }
    }
    ReD = "";
    parama = parama.boO("accPathMigration").boP(str + "${accountSalt}").boP(str + "${account}");
    AppMethodBeat.o(133524);
    return parama;
  }
  
  public static g.a a(g.a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(133523);
    Object localObject = MMApplicationContext.getContext();
    Log.i("VFS.VFSStrategy", "Update SDCard status: isSDCardAvailAndSysPathOk = ".concat(String.valueOf(paramBoolean1)));
    if (paramBoolean1)
    {
      String str1 = com.tencent.mm.loader.j.b.aKE() + "/tencent";
      String str2 = com.tencent.mm.loader.j.b.aKF();
      localObject = ((Context)localObject).getExternalCacheDir();
      if (!paramBoolean2)
      {
        Log.w("VFS.VFSStrategy", "do not use external private storage.");
        localObject = null;
      }
      g.a locala = parama.nt("sdFrom", str1);
      if (localObject == null)
      {
        parama = str1;
        locala = locala.nt("sdTo", parama);
        if (localObject != null) {
          break label166;
        }
      }
      label166:
      for (parama = str1 + "/MicroMsg";; parama = ((File)localObject).getPath())
      {
        parama = locala.nt("sdToCache", parama).nt("extSDFrom", str2);
        AppMethodBeat.o(133523);
        return parama;
        parama = ((File)localObject).getParent();
        break;
      }
    }
    localObject = ((Context)localObject).getCacheDir();
    parama = parama.boQ("sdFrom").boQ("extSDFrom").nt("sdTo", ((File)localObject).getParent()).nt("sdToCache", ((File)localObject).getPath());
    AppMethodBeat.o(133523);
    return parama;
  }
  
  private static void a(String paramString, FileSystem paramFileSystem, String[] paramArrayOfString, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(197249);
    g.a locala = g.hRR().hRT().a(paramString, paramFileSystem);
    int k = paramArrayOfString.length;
    int i = 0;
    while (i < k)
    {
      locala.ns(paramArrayOfString[i], paramString);
      i += 1;
    }
    if (((paramInt & 0x40) != 0) && (paramArrayOfString.length > 1)) {
      if (paramArrayOfString.length != 2) {
        break label122;
      }
    }
    for (paramFileSystem = new DeleteAllFileSystem(new NativeFileSystem(paramArrayOfString[1]));; paramFileSystem = new MaintenanceGroup(paramFileSystem))
    {
      locala.b("@DeleteAll-".concat(String.valueOf(paramString)), paramFileSystem);
      locala.commit();
      AppMethodBeat.o(197249);
      return;
      label122:
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
    AppMethodBeat.i(133512);
    if (!FgY)
    {
      AppMethodBeat.o(133512);
      return;
    }
    paramString1 = bpe(paramString1);
    paramString2 = bpe(paramString2);
    String[] arrayOfString = hq(paramString2, paramInt);
    Object localObject = new StatisticsFileSystem(a(paramString1, arrayOfString, paramInt));
    ((AbstractFileSystem)localObject).a(paramString1, new d(arrayOfString[0], 4, paramInt, paramLong / 2L, 7776000000L));
    localObject = new QuotaFileSystem((FileSystem)localObject, paramLong / 2L, paramLong);
    ((QuotaFileSystem)localObject).a(paramString1, x.heu());
    a(paramString1, (FileSystem)localObject, arrayOfString, paramInt);
    d.hp(paramString2, paramInt);
    AppMethodBeat.o(133512);
  }
  
  public static void apG(int paramInt)
  {
    AppMethodBeat.i(133522);
    EventCenter.instance.add(new IListener() {});
    AppMethodBeat.o(133522);
  }
  
  public static void at(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(133511);
    if (!FgY)
    {
      AppMethodBeat.o(133511);
      return;
    }
    paramString1 = bpe(paramString1);
    paramString2 = bpe(paramString2);
    String[] arrayOfString = hq(paramString2, paramInt);
    Object localObject = a(paramString1, arrayOfString, paramInt);
    ((AbstractFileSystem)localObject).a(paramString1, x.heu());
    localObject = new StatisticsFileSystem((FileSystem)localObject);
    ((AbstractFileSystem)localObject).a(paramString1, new d(arrayOfString[0], 1, paramInt, 0L, 0L));
    a(paramString1, (FileSystem)localObject, arrayOfString, paramInt);
    d.hp(paramString2, paramInt);
    AppMethodBeat.o(133511);
  }
  
  private static AbstractFileSystem au(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(197247);
    paramString2 = new NativeFileSystem(paramString2);
    if ((paramInt & 0x8) == 0)
    {
      AppMethodBeat.o(197247);
      return paramString2;
    }
    paramString1 = new RC4EncryptedFileSystem(paramString2, paramString1);
    AppMethodBeat.o(197247);
    return paramString1;
  }
  
  public static void b(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    AppMethodBeat.i(197245);
    if (!FgY)
    {
      AppMethodBeat.o(197245);
      return;
    }
    paramString1 = bpe(paramString1);
    paramString2 = bpe(paramString2);
    paramInt |= 0x20;
    String[] arrayOfString = hq(paramString2, paramInt);
    Object localObject = new StatisticsFileSystem(a(paramString1, arrayOfString, paramInt));
    ((AbstractFileSystem)localObject).a(paramString1, new d(arrayOfString[0], 3, paramInt, 0L, paramLong));
    localObject = new ExpireFileSystem((FileSystem)localObject, paramLong);
    ((ExpireFileSystem)localObject).a(paramString1, x.heu());
    a(paramString1, (FileSystem)localObject, arrayOfString, paramInt);
    d.hp(paramString2, paramInt);
    AppMethodBeat.o(197245);
  }
  
  private static String bpe(String paramString)
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
  
  private static g.a d(g.a parama)
  {
    try
    {
      AppMethodBeat.i(185096);
      if (ReE != null)
      {
        parama.boO("camera-path-remapfs");
        parama.boP(ReE);
      }
      if ((ReF != null) || (ReG != null))
      {
        parama.boO("sdcard-path-remapfs");
        if (ReF != null) {
          parama.boP(ReF);
        }
        if (ReG != null) {
          parama.boP(ReG);
        }
      }
      String str1 = com.tencent.mm.loader.j.b.aKU();
      String str2 = com.tencent.mm.loader.j.b.aKF() + "/MicroMsg/";
      String str3 = com.tencent.mm.loader.j.b.aKI();
      ExtStorageMigrateMonitor.gwK().i("VFS.VFSStrategy", "[+] updateMigratePathRemappings, lastMountNewCameraPath: %s, lastMountNewSDCardPath: %s, lastMountOldSDCardPath: %s, newCameraPath: %s, newSDCardPath: %s, oldSDCardPath: %s", new Object[] { ReE, ReF, ReG, str1, str2, str3 });
      if (com.tencent.mm.loader.j.b.aKU().equals(com.tencent.mm.loader.j.b.aKT()))
      {
        ExtStorageMigrateMonitor.gwK().e("VFS.VFSStrategy", "[-] Fail to get new camera path, and we use old camera path for fallback.", new Object[0]);
        if (MMApplicationContext.isMainProcess()) {
          ExtStorageMigrateMonitor.ME(142L);
        }
      }
      ReE = str1;
      ReF = str2;
      ReG = str3;
      parama.a("sdcard-path-remapfs", new MigrationFileSystem(false, false, new NativeFileSystem(str2), new FileSystem[] { new NativeFileSystem(str3) })).a("camera-path-remapfs", new MigrationFileSystem(false, false, new NativeFileSystem(str1), new FileSystem[] { new NativeFileSystem(str3 + "WeChat/"), new NativeFileSystem(str3 + "WeiXin/") })).ns(str2, "sdcard-path-remapfs").ns(str1, "camera-path-remapfs").ns(str3, "sdcard-path-remapfs").ns(str3 + "WeChat/", "camera-path-remapfs").ns(str3 + "WeiXin/", "camera-path-remapfs");
      AppMethodBeat.o(185096);
      return parama;
    }
    finally {}
  }
  
  /* Error */
  public static void f(com.tencent.mm.kernel.b.g paramg)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc_w 476
    //   8: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_0
    //   12: invokevirtual 481	com/tencent/mm/kernel/b/g:aBb	()Z
    //   15: istore_2
    //   16: iload_2
    //   17: putstatic 177	com/tencent/mm/vfs/y:FgY	Z
    //   20: aload_0
    //   21: getfield 485	com/tencent/mm/kernel/b/g:ca	Landroid/app/Application;
    //   24: invokestatic 489	com/tencent/mm/vfs/g:setContext	(Landroid/content/Context;)V
    //   27: iload_2
    //   28: ifne +103 -> 131
    //   31: iload_1
    //   32: invokestatic 492	com/tencent/mm/vfs/g:Fh	(Z)V
    //   35: getstatic 42	com/tencent/mm/vfs/y:Rey	Lcom/tencent/mm/vfs/y$a;
    //   38: invokestatic 495	com/tencent/mm/vfs/g:a	(Lcom/tencent/mm/vfs/g$b;)V
    //   41: invokestatic 114	com/tencent/mm/vfs/g:hRR	()Lcom/tencent/mm/vfs/g;
    //   44: pop
    //   45: invokestatic 440	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:gwK	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
    //   48: ldc 101
    //   50: new 198	java/lang/StringBuilder
    //   53: dup
    //   54: ldc_w 497
    //   57: invokespecial 203	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   60: iload_2
    //   61: invokevirtual 212	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   64: ldc_w 499
    //   67: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokestatic 504	com/tencent/mm/vfs/z:heY	()Z
    //   73: invokevirtual 212	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   76: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: iconst_0
    //   80: anewarray 4	java/lang/Object
    //   83: invokeinterface 447 4 0
    //   88: invokestatic 440	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:gwK	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
    //   91: ldc 101
    //   93: ldc_w 506
    //   96: iconst_1
    //   97: anewarray 4	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: invokestatic 277	com/tencent/mm/loader/j/b:aKF	()Ljava/lang/String;
    //   105: aastore
    //   106: invokeinterface 447 4 0
    //   111: invokestatic 509	com/tencent/mm/loader/j/b:aLI	()V
    //   114: invokestatic 277	com/tencent/mm/loader/j/b:aKF	()Ljava/lang/String;
    //   117: iconst_1
    //   118: invokestatic 513	com/tencent/mm/loader/j/b:A	(Ljava/lang/String;Z)V
    //   121: ldc_w 476
    //   124: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: ldc 2
    //   129: monitorexit
    //   130: return
    //   131: iconst_0
    //   132: istore_1
    //   133: goto -102 -> 31
    //   136: astore_0
    //   137: invokestatic 440	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:gwK	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
    //   140: ldc 101
    //   142: aload_0
    //   143: ldc_w 515
    //   146: iconst_0
    //   147: anewarray 4	java/lang/Object
    //   150: invokeinterface 519 5 0
    //   155: goto -67 -> 88
    //   158: astore_0
    //   159: ldc 2
    //   161: monitorexit
    //   162: aload_0
    //   163: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	paramg	com.tencent.mm.kernel.b.g
    //   1	132	1	bool1	boolean
    //   15	46	2	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   45	88	136	java/lang/Throwable
    //   5	27	158	finally
    //   31	45	158	finally
    //   45	88	158	finally
    //   88	127	158	finally
    //   137	155	158	finally
  }
  
  /* Error */
  public static void g(com.tencent.mm.kernel.b.g paramg)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc_w 521
    //   8: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_0
    //   12: invokevirtual 481	com/tencent/mm/kernel/b/g:aBb	()Z
    //   15: istore_2
    //   16: iload_2
    //   17: putstatic 177	com/tencent/mm/vfs/y:FgY	Z
    //   20: iconst_1
    //   21: putstatic 44	com/tencent/mm/vfs/y:Rez	Z
    //   24: iload_2
    //   25: ifne +251 -> 276
    //   28: iload_1
    //   29: invokestatic 492	com/tencent/mm/vfs/g:Fh	(Z)V
    //   32: getstatic 42	com/tencent/mm/vfs/y:Rey	Lcom/tencent/mm/vfs/y$a;
    //   35: invokestatic 495	com/tencent/mm/vfs/g:a	(Lcom/tencent/mm/vfs/g$b;)V
    //   38: iload_2
    //   39: ifeq +217 -> 256
    //   42: new 397	com/tencent/mm/vfs/ExpireFileSystem
    //   45: dup
    //   46: new 232	com/tencent/mm/vfs/NativeFileSystem
    //   49: dup
    //   50: ldc_w 523
    //   53: invokespecial 236	com/tencent/mm/vfs/NativeFileSystem:<init>	(Ljava/lang/String;)V
    //   56: ldc2_w 524
    //   59: invokespecial 400	com/tencent/mm/vfs/ExpireFileSystem:<init>	(Lcom/tencent/mm/vfs/FileSystem;J)V
    //   62: astore_0
    //   63: new 397	com/tencent/mm/vfs/ExpireFileSystem
    //   66: dup
    //   67: new 232	com/tencent/mm/vfs/NativeFileSystem
    //   70: dup
    //   71: ldc_w 527
    //   74: invokespecial 236	com/tencent/mm/vfs/NativeFileSystem:<init>	(Ljava/lang/String;)V
    //   77: ldc2_w 524
    //   80: invokespecial 400	com/tencent/mm/vfs/ExpireFileSystem:<init>	(Lcom/tencent/mm/vfs/FileSystem;J)V
    //   83: astore_3
    //   84: invokestatic 114	com/tencent/mm/vfs/g:hRR	()Lcom/tencent/mm/vfs/g;
    //   87: astore 4
    //   89: aload 4
    //   91: iconst_0
    //   92: putfield 142	com/tencent/mm/vfs/g:Uvq	Z
    //   95: aload 4
    //   97: invokevirtual 118	com/tencent/mm/vfs/g:hRT	()Lcom/tencent/mm/vfs/g$a;
    //   100: astore 4
    //   102: aload 4
    //   104: getfield 531	com/tencent/mm/vfs/g$a:Rcf	Ljava/util/HashMap;
    //   107: invokevirtual 536	java/util/HashMap:clear	()V
    //   110: aload 4
    //   112: getfield 540	com/tencent/mm/vfs/g$a:Rch	Ljava/util/TreeMap;
    //   115: invokevirtual 543	java/util/TreeMap:clear	()V
    //   118: aload 4
    //   120: getfield 546	com/tencent/mm/vfs/g$a:Rci	Ljava/util/HashMap;
    //   123: invokevirtual 536	java/util/HashMap:clear	()V
    //   126: aload 4
    //   128: aconst_null
    //   129: putfield 550	com/tencent/mm/vfs/g$a:Rcj	Lcom/tencent/mm/vfs/f;
    //   132: aload 4
    //   134: iconst_1
    //   135: putfield 553	com/tencent/mm/vfs/g$a:Rck	Z
    //   138: aload 4
    //   140: ldc_w 555
    //   143: invokestatic 561	com/tencent/mm/vfs/AssetsSchemeResolver:hdP	()Lcom/tencent/mm/vfs/AssetsSchemeResolver;
    //   146: invokevirtual 564	com/tencent/mm/vfs/g$a:a	(Ljava/lang/String;Lcom/tencent/mm/vfs/SchemeResolver;)Lcom/tencent/mm/vfs/g$a;
    //   149: ldc_w 566
    //   152: invokestatic 572	com/tencent/mm/vfs/ContentsSchemeResolver:hdT	()Lcom/tencent/mm/vfs/SchemeResolver;
    //   155: invokevirtual 564	com/tencent/mm/vfs/g$a:a	(Ljava/lang/String;Lcom/tencent/mm/vfs/SchemeResolver;)Lcom/tencent/mm/vfs/g$a;
    //   158: ldc_w 574
    //   161: new 232	com/tencent/mm/vfs/NativeFileSystem
    //   164: dup
    //   165: ldc_w 576
    //   168: invokespecial 236	com/tencent/mm/vfs/NativeFileSystem:<init>	(Ljava/lang/String;)V
    //   171: invokevirtual 246	com/tencent/mm/vfs/g$a:a	(Ljava/lang/String;Lcom/tencent/mm/vfs/FileSystem;)Lcom/tencent/mm/vfs/g$a;
    //   174: ldc_w 578
    //   177: new 232	com/tencent/mm/vfs/NativeFileSystem
    //   180: dup
    //   181: ldc_w 580
    //   184: invokespecial 236	com/tencent/mm/vfs/NativeFileSystem:<init>	(Ljava/lang/String;)V
    //   187: invokevirtual 246	com/tencent/mm/vfs/g$a:a	(Ljava/lang/String;Lcom/tencent/mm/vfs/FileSystem;)Lcom/tencent/mm/vfs/g$a;
    //   190: ldc 80
    //   192: aload_0
    //   193: invokevirtual 246	com/tencent/mm/vfs/g$a:a	(Ljava/lang/String;Lcom/tencent/mm/vfs/FileSystem;)Lcom/tencent/mm/vfs/g$a;
    //   196: ldc_w 582
    //   199: aload_3
    //   200: invokevirtual 246	com/tencent/mm/vfs/g$a:a	(Ljava/lang/String;Lcom/tencent/mm/vfs/FileSystem;)Lcom/tencent/mm/vfs/g$a;
    //   203: ldc_w 576
    //   206: ldc_w 574
    //   209: invokevirtual 254	com/tencent/mm/vfs/g$a:ns	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/vfs/g$a;
    //   212: ldc_w 580
    //   215: ldc_w 578
    //   218: invokevirtual 254	com/tencent/mm/vfs/g$a:ns	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/vfs/g$a;
    //   221: ldc_w 523
    //   224: ldc 80
    //   226: invokevirtual 254	com/tencent/mm/vfs/g$a:ns	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/vfs/g$a;
    //   229: ldc_w 527
    //   232: ldc_w 582
    //   235: invokevirtual 254	com/tencent/mm/vfs/g$a:ns	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/vfs/g$a;
    //   238: astore_0
    //   239: aload_0
    //   240: invokestatic 584	com/tencent/mm/vfs/y:d	(Lcom/tencent/mm/vfs/g$a;)Lcom/tencent/mm/vfs/g$a;
    //   243: pop
    //   244: aload_0
    //   245: invokestatic 589	com/tencent/mm/compatible/util/e:apn	()Z
    //   248: iconst_1
    //   249: invokestatic 591	com/tencent/mm/vfs/y:a	(Lcom/tencent/mm/vfs/g$a;ZZ)Lcom/tencent/mm/vfs/g$a;
    //   252: iconst_0
    //   253: invokevirtual 594	com/tencent/mm/vfs/g$a:Dx	(Z)V
    //   256: new 6	com/tencent/mm/vfs/y$1
    //   259: dup
    //   260: invokespecial 595	com/tencent/mm/vfs/y$1:<init>	()V
    //   263: invokestatic 601	com/tencent/mm/graphics/MMBitmapFactory:setStreamProvider	(Lcom/tencent/mm/graphics/MMBitmapFactory$b;)V
    //   266: ldc_w 521
    //   269: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   272: ldc 2
    //   274: monitorexit
    //   275: return
    //   276: iconst_0
    //   277: istore_1
    //   278: goto -250 -> 28
    //   281: astore_0
    //   282: ldc 2
    //   284: monitorexit
    //   285: aload_0
    //   286: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	paramg	com.tencent.mm.kernel.b.g
    //   1	277	1	bool1	boolean
    //   15	24	2	bool2	boolean
    //   83	117	3	localExpireFileSystem	ExpireFileSystem
    //   87	52	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	24	281	finally
    //   28	38	281	finally
    //   42	256	281	finally
    //   256	272	281	finally
  }
  
  public static void heW()
  {
    int k = 0;
    int i = 0;
    AppMethodBeat.i(133520);
    Log.i("VFS.VFSStrategy", "Configuration done.");
    ReB = true;
    int j = k;
    try
    {
      if (FgY)
      {
        j = k;
        if (ReA)
        {
          if (!ReC) {
            i = 1;
          }
          j = i;
          if (i != 0)
          {
            ReC = true;
            j = i;
          }
        }
      }
      if (j != 0) {
        Dy(e.apn());
      }
      AppMethodBeat.o(133520);
      return;
    }
    finally
    {
      AppMethodBeat.o(133520);
    }
  }
  
  public static void heX()
  {
    AppMethodBeat.i(185097);
    ExtStorageMigrateMonitor.gwK().i("VFS.VFSStrategy", "[+] updateSdCardPathOnDemand called.", new Object[0]);
    ExtStorageMigrateMonitor.gwK().i("VFS.VFSStrategy", "[+] updateSdCardPathOnDemand, isPathRemapOpened, NEW_SDCARD_ROOT: %s", new Object[] { com.tencent.mm.loader.j.b.aKF() });
    com.tencent.mm.loader.j.b.aLI();
    com.tencent.mm.loader.j.b.A(com.tencent.mm.loader.j.b.aKF(), true);
    if (MMApplicationContext.isMainProcess()) {
      d(g.hRR().hRT()).commit();
    }
    AppMethodBeat.o(185097);
  }
  
  private static String[] hq(String paramString, int paramInt)
  {
    int n = 1;
    AppMethodBeat.i(133514);
    int i;
    int j;
    label34:
    int k;
    label43:
    int m;
    label52:
    label63:
    LinkedHashSet localLinkedHashSet;
    String str2;
    label86:
    String str1;
    if ((paramInt & 0x4) == 0)
    {
      i = 1;
      if (((paramInt & 0x20) == 0) || ((paramInt & 0x200) != 0)) {
        break label314;
      }
      j = 1;
      if ((paramInt & 0x1) == 0) {
        break label319;
      }
      k = 1;
      if ((paramInt & 0x2) == 0) {
        break label325;
      }
      m = 1;
      if ((paramInt & 0x100) == 0) {
        break label331;
      }
      paramInt = n;
      localLinkedHashSet = new LinkedHashSet();
      if (m == 0) {
        break label344;
      }
      if (j == 0) {
        break label336;
      }
      str2 = "${sdToCache}/";
      str1 = str2;
      if (i != 0) {
        str1 = str2 + "${accountSd}/";
      }
      localLinkedHashSet.add(str1 + paramString);
      if (k == 0) {
        break label459;
      }
      if (i == 0) {
        break label395;
      }
      if ((j != 0) || (m == 0))
      {
        localLinkedHashSet.add("${extSDFrom}/MicroMsg/" + "${accountSalt}/" + paramString);
        localLinkedHashSet.add("${extSDFrom}/MicroMsg/" + "${account}/" + paramString);
      }
      localLinkedHashSet.add("${sdFrom}/MicroMsg/" + "${accountSalt}/" + paramString);
      localLinkedHashSet.add("${sdFrom}/MicroMsg/" + "${account}/" + paramString);
    }
    for (;;)
    {
      paramString = (String[])localLinkedHashSet.toArray(new String[0]);
      AppMethodBeat.o(133514);
      return paramString;
      i = 0;
      break;
      label314:
      j = 0;
      break label34;
      label319:
      k = 0;
      break label43;
      label325:
      m = 0;
      break label52;
      label331:
      paramInt = 0;
      break label63;
      label336:
      str2 = "${sdTo}/MicroMsg/";
      break label86;
      label344:
      if (j != 0) {}
      for (str2 = "${dataCache}/";; str2 = "${data}/MicroMsg/")
      {
        str1 = str2;
        if (i == 0) {
          break;
        }
        str1 = str2 + "${account}/";
        break;
      }
      label395:
      localLinkedHashSet.add("${sdFrom}/MicroMsg/" + paramString);
      if ((j != 0) || (m == 0))
      {
        localLinkedHashSet.add("${extSDFrom}/MicroMsg/" + paramString);
        continue;
        label459:
        if (paramInt != 0)
        {
          if (i != 0)
          {
            localLinkedHashSet.add("${sdFrom}/MicroMsg/" + "${accountSalt}/" + paramString);
            localLinkedHashSet.add("${sdFrom}/MicroMsg/" + "${account}/" + paramString);
            localLinkedHashSet.add("${sdTo}/MicroMsg/${accountSalt}/".concat(String.valueOf(paramString)));
            localLinkedHashSet.add("${sdTo}/MicroMsg/${account}/".concat(String.valueOf(paramString)));
          }
          else
          {
            localLinkedHashSet.add("${sdFrom}/MicroMsg/" + paramString);
            localLinkedHashSet.add("${sdTo}/MicroMsg/".concat(String.valueOf(paramString)));
          }
        }
        else
        {
          str1 = "${data}/MicroMsg/";
          if (i != 0) {
            str1 = "${data}/MicroMsg/" + "${account}/";
          }
          localLinkedHashSet.add(str1 + paramString);
        }
      }
    }
  }
  
  public static void nA(String paramString1, String paramString2)
  {
    int i = 1;
    AppMethodBeat.i(197246);
    if (Util.getInt(com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_clean_expire_switch", "1", false, true), 1) > 0) {}
    while (i == 0)
    {
      b(paramString1, paramString2, 604800000L, 19);
      AppMethodBeat.o(197246);
      return;
      i = 0;
    }
    if (!FgY)
    {
      AppMethodBeat.o(197246);
      return;
    }
    paramString1 = bpe(paramString1);
    paramString2 = bpe(paramString2);
    String[] arrayOfString = hq(paramString2, 51);
    Object localObject = new StatisticsFileSystem(a(paramString1, arrayOfString, 51));
    ((AbstractFileSystem)localObject).a(paramString1, new d(arrayOfString[0], 3, 51, 0L, 604800000L));
    localObject = new CleanExpireFileSystem((FileSystem)localObject);
    ((CleanExpireFileSystem)localObject).a(paramString1, x.heu());
    a(paramString1, (FileSystem)localObject, arrayOfString, 51);
    d.hp(paramString2, 51);
    AppMethodBeat.o(197246);
  }
  
  static final class a
    implements g.b
  {
    public final Key Z(String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(176878);
      if (paramMap.get("account") == null)
      {
        AppMethodBeat.o(176878);
        return null;
      }
      Log.i("VFS.Debug", "KeyGen.generate: ".concat(String.valueOf(paramString)));
      if (MMApplicationContext.isMainProcess()) {
        com.tencent.mm.kernel.g.aAf();
      }
      for (paramMap = a.ayV();; paramMap = new p(a.azs()).toString())
      {
        paramString = new SecretKeySpec(com.tencent.mm.b.g.Q((paramMap + paramString).getBytes()), "RC4");
        AppMethodBeat.o(176878);
        return paramString;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.y
 * JD-Core Version:    0.7.0.1
 */