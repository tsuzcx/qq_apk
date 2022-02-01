package com.tencent.mm.vfs;

import android.content.Context;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.graphics.MMBitmapFactory.b;
import com.tencent.mm.plugin.expt.e.d;
import com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor;
import com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public final class af
{
  private static final af.a agAS;
  static boolean agAT;
  private static boolean agAU;
  private static volatile boolean agAV;
  private static volatile boolean agAW;
  private static volatile boolean agAX;
  private static final ArrayList<FileSystem> agAY;
  private static final HashSet<String> agAZ;
  private static volatile String agBa;
  private static String agBb;
  private static final u agBc;
  private static final u agBd;
  private static volatile boolean rgc;
  
  static
  {
    u localu1 = null;
    AppMethodBeat.i(176883);
    agAS = new af.a((byte)0);
    agAU = false;
    agAV = false;
    agAW = false;
    agAX = false;
    agAY = new ArrayList();
    agAZ = new HashSet();
    agBa = "";
    agBb = null;
    agBc = new u(u.V(MMApplicationContext.getContext().getCacheDir()), "temp");
    u localu2 = u.V(MMApplicationContext.getContext().getExternalCacheDir());
    if (localu2 == null) {}
    for (;;)
    {
      agBd = localu1;
      AppMethodBeat.o(176883);
      return;
      localu1 = new u(localu2, "temp");
    }
  }
  
  private static void NT(boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(238181);
    Log.i("VFS.VFSStrategy", "Broadcasting enabled.");
    k localk = k.kMs();
    Object localObject2 = localk.kMv();
    g.c((k.a)localObject2);
    g.d((k.a)localObject2);
    c.a((k.a)localObject2);
    Object localObject3 = b.jKe();
    ??? = ah.aA(k.kMs().kMx(), "account");
    Object localObject5 = ((List)localObject3).iterator();
    Object localObject6;
    while (((Iterator)localObject5).hasNext())
    {
      localObject6 = (Pair)((Iterator)localObject5).next();
      if ((((String)((Pair)localObject6).first).equals(???)) || (((String)((Pair)localObject6).first).equals("ee1da3ae2100e09165c2e52382cfe79f"))) {
        ((Iterator)localObject5).remove();
      } else {
        Log.i("VFS.VFSStrategy", " * Other account pair: %s / %s", new Object[] { ((Pair)localObject6).first, ((Pair)localObject6).second });
      }
    }
    if (!((List)localObject3).isEmpty())
    {
      localObject5 = new ArrayList();
      synchronized (agAY)
      {
        localObject6 = agAY.iterator();
        if (((Iterator)localObject6).hasNext()) {
          ((ArrayList)localObject5).add(new i.a((FileSystem)((Iterator)localObject6).next(), "${accountOtherList}", "account|accountSd"));
        }
      }
      agAY.clear();
      ((k.a)localObject2).b("@MigrateOther", new MaintenanceGroup((Collection)localObject5));
      ??? = new String[((List)localObject3).size()];
      while (i < ???.length)
      {
        localObject5 = (Pair)((List)localObject3).get(i);
        ???[i] = ((String)((Pair)localObject5).first + '|' + (String)((Pair)localObject5).second);
        Log.i("VFS.VFSStrategy", " * Other account env: " + ???[i]);
        i += 1;
      }
      ((k.a)localObject2).r("accountOtherList", (String[])???);
    }
    ((k.a)localObject2).commit();
    g.init();
    localObject1.akmI = true;
    localObject1.publish();
    if (paramBoolean)
    {
      localObject2 = l.agxP;
      localObject3 = localObject1.akmE;
      localObject1.akmE = ((k.d)localObject2);
      localObject1.bK(420000L, 86400000L);
    }
    AppMethodBeat.o(238181);
  }
  
  /* Error */
  public static void NU(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iconst_0
    //   3: istore_1
    //   4: ldc 2
    //   6: monitorenter
    //   7: ldc_w 298
    //   10: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   13: ldc 109
    //   15: ldc_w 300
    //   18: invokestatic 116	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: iconst_1
    //   22: putstatic 48	com/tencent/mm/vfs/af:agAV	Z
    //   25: ldc 2
    //   27: monitorenter
    //   28: iload_3
    //   29: istore_2
    //   30: getstatic 302	com/tencent/mm/vfs/af:rgc	Z
    //   33: ifeq +31 -> 64
    //   36: iload_3
    //   37: istore_2
    //   38: getstatic 50	com/tencent/mm/vfs/af:agAW	Z
    //   41: ifeq +23 -> 64
    //   44: getstatic 52	com/tencent/mm/vfs/af:agAX	Z
    //   47: ifne +5 -> 52
    //   50: iconst_1
    //   51: istore_1
    //   52: iload_1
    //   53: istore_2
    //   54: iload_1
    //   55: ifeq +9 -> 64
    //   58: iconst_1
    //   59: putstatic 52	com/tencent/mm/vfs/af:agAX	Z
    //   62: iload_1
    //   63: istore_2
    //   64: ldc 2
    //   66: monitorexit
    //   67: iload_2
    //   68: ifeq +7 -> 75
    //   71: iload_0
    //   72: invokestatic 304	com/tencent/mm/vfs/af:NT	(Z)V
    //   75: ldc_w 298
    //   78: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: ldc 2
    //   83: monitorexit
    //   84: return
    //   85: astore 4
    //   87: ldc 2
    //   89: monitorexit
    //   90: ldc_w 298
    //   93: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: aload 4
    //   98: athrow
    //   99: astore 4
    //   101: ldc 2
    //   103: monitorexit
    //   104: aload 4
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	paramBoolean	boolean
    //   3	60	1	i	int
    //   29	39	2	j	int
    //   1	36	3	k	int
    //   85	12	4	localObject1	Object
    //   99	6	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   30	36	85	finally
    //   38	44	85	finally
    //   44	50	85	finally
    //   58	62	85	finally
    //   64	67	85	finally
    //   7	28	99	finally
    //   71	75	99	finally
    //   75	81	99	finally
    //   87	99	99	finally
  }
  
  private static AbstractFileSystem a(String paramString, String[] paramArrayOfString, int paramInt)
  {
    ArrayList localArrayList1 = null;
    Object localObject1 = null;
    int i = 1;
    AppMethodBeat.i(238144);
    if ((paramArrayOfString.length == 1) || ((paramInt & 0x40) != 0))
    {
      paramString = aS(paramString, paramArrayOfString[0], paramInt);
      AppMethodBeat.o(238144);
      return paramString;
    }
    int j;
    if ((paramInt & 0x400) != 0)
    {
      j = 1;
      if ((paramInt & 0x83) != 131) {
        break label164;
      }
    }
    label164:
    for (;;)
    {
      label66:
      if (i != 0)
      {
        localArrayList1 = new ArrayList();
        localArrayList2 = new ArrayList();
        AbstractFileSystem localAbstractFileSystem = aS(paramString, paramArrayOfString[0], paramInt);
        i = 0;
        for (;;)
        {
          if (i < paramArrayOfString.length)
          {
            localObject2 = paramArrayOfString[i];
            if (!((String)localObject2).contains("${sd"))
            {
              localObject2 = aT(paramString, (String)localObject2, paramInt);
              if ((i != 0) || (!(localObject2 instanceof FileSystem))) {
                localArrayList1.add(localObject2);
              }
              i += 1;
              continue;
              j = 0;
              break;
              i = 0;
              break label66;
            }
          }
        }
        if (i >= paramArrayOfString.length)
        {
          paramString = new RuntimeException("No SDCard paths?!");
          AppMethodBeat.o(238144);
          throw paramString;
        }
        Object localObject2 = aS(paramString, paramArrayOfString[i], paramInt);
        while (i < paramArrayOfString.length)
        {
          Object localObject3 = aT(paramString, paramArrayOfString[i], paramInt);
          if ((i != 0) || (!(localObject3 instanceof FileSystem))) {
            localArrayList2.add(localObject3);
          }
          i += 1;
        }
        paramString = (String)localObject1;
        if (j != 0) {
          paramString = "${sdFrom}";
        }
        localArrayList1.add(new MigrationFileSystem("${sdFrom}", "${sdFrom}", paramString, (FileSystem)localObject2, localArrayList2.toArray()));
        paramString = new MigrationFileSystem(localAbstractFileSystem, localArrayList1.toArray());
        AppMethodBeat.o(238144);
        return paramString;
      }
    }
    ArrayList localArrayList2 = new ArrayList(paramArrayOfString.length);
    i = 0;
    while (i < paramArrayOfString.length)
    {
      localObject1 = aT(paramString, paramArrayOfString[i], paramInt);
      if ((i != 0) || (!(localObject1 instanceof FileSystem))) {
        localArrayList2.add(localObject1);
      }
      i += 1;
    }
    localObject1 = localArrayList1;
    if (j != 0) {
      localObject1 = "${sdFrom}";
    }
    paramString = new MigrationFileSystem("${sdFrom}", "${sdFrom}", (String)localObject1, aS(paramString, paramArrayOfString[0], paramInt), localArrayList2.toArray());
    AppMethodBeat.o(238144);
    return paramString;
  }
  
  public static k.a a(k.a parama, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(133524);
    Log.i("VFS.VFSStrategy", "Update account migration: sysPath = " + paramString + ", useSaltPath = " + paramBoolean);
    String str = agBa;
    if (paramBoolean)
    {
      MigrationFileSystem localMigrationFileSystem = new MigrationFileSystem("${sdFrom}", "${sdFrom}", new NativeFileSystem(paramString + "${accountSalt}"), new Object[] { new NativeFileSystem(paramString + "${account}"), new NativeFileSystem(com.tencent.mm.loader.i.b.bmy() + "${accountSalt}"), new NativeFileSystem(com.tencent.mm.loader.i.b.bmy() + "${account}") });
      agBa = paramString;
      parama = parama.a("accPathMigration", localMigrationFileSystem).bEc(str + "${accountSalt}").bEc(str + "${account}").qg(paramString + "${accountSalt}", "accPathMigration").qg(paramString + "${account}", "accPathMigration");
      AppMethodBeat.o(133524);
      return parama;
    }
    agBa = "";
    parama = parama.bEb("accPathMigration").bEc(str + "${accountSalt}").bEc(str + "${account}");
    AppMethodBeat.o(133524);
    return parama;
  }
  
  public static k.a a(k.a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(133523);
    Object localObject = MMApplicationContext.getContext();
    Log.i("VFS.VFSStrategy", "Update SDCard status: isSDCardAvailAndSysPathOk = ".concat(String.valueOf(paramBoolean1)));
    if (paramBoolean1)
    {
      String str1 = com.tencent.mm.loader.i.b.bmu() + "/tencent";
      String str2 = com.tencent.mm.loader.i.b.bmv();
      localObject = ((Context)localObject).getExternalCacheDir();
      if (!paramBoolean2)
      {
        Log.w("VFS.VFSStrategy", "do not use external private storage.");
        localObject = null;
      }
      k.a locala = parama.qh("sdFrom", str1);
      if (localObject == null)
      {
        parama = str1;
        locala = locala.qh("sdTo", parama);
        if (localObject != null) {
          break label166;
        }
      }
      label166:
      for (parama = str1 + "/MicroMsg";; parama = ((File)localObject).getPath())
      {
        parama = locala.qh("sdToCache", parama).qh("extSDFrom", str2);
        AppMethodBeat.o(133523);
        return parama;
        parama = ((File)localObject).getParent();
        break;
      }
    }
    localObject = ((Context)localObject).getCacheDir();
    parama = parama.bEd("sdFrom").bEd("extSDFrom").qh("sdTo", ((File)localObject).getParent()).qh("sdToCache", ((File)localObject).getPath());
    AppMethodBeat.o(133523);
    return parama;
  }
  
  private static void a(String paramString, FileSystem paramFileSystem, String[] paramArrayOfString, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(238154);
    synchronized (agAZ)
    {
      if (!agAZ.add(paramString))
      {
        paramString = new AssertionError("Duplicated name for filesystems: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(238154);
        throw paramString;
      }
    }
    ??? = k.kMs().kMv().a(paramString, paramFileSystem);
    int k = paramArrayOfString.length;
    int i = 0;
    while (i < k)
    {
      ((k.a)???).qg(paramArrayOfString[i], paramString);
      i += 1;
    }
    if (((paramInt & 0x40) != 0) && (paramArrayOfString.length > 1)) {
      if (paramArrayOfString.length != 2) {
        break label181;
      }
    }
    for (paramFileSystem = new DeleteAllFileSystem(new NativeFileSystem(paramArrayOfString[1]));; paramFileSystem = new MaintenanceGroup(paramFileSystem))
    {
      ((k.a)???).b("@DeleteAll-".concat(String.valueOf(paramString)), paramFileSystem);
      ((k.a)???).commit();
      AppMethodBeat.o(238154);
      return;
      label181:
      paramFileSystem = new Object[paramArrayOfString.length - 1];
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
    AppMethodBeat.i(238117);
    if (!rgc)
    {
      AppMethodBeat.o(238117);
      return;
    }
    paramString1 = bEt(paramString1);
    paramString2 = bEt(paramString2);
    paramInt |= 0x20;
    String[] arrayOfString = jl(paramString2, paramInt);
    Object localObject = new StatisticsFileSystem(a(paramString1, arrayOfString, paramInt));
    ((AbstractFileSystem)localObject).a(paramString1, new g(arrayOfString[0], 3, paramInt, 0L, paramLong));
    localObject = new ExpireFileSystem((FileSystem)localObject, paramLong);
    ((ExpireFileSystem)localObject).a(paramString1, ae.jLb());
    a(paramString1, (FileSystem)localObject, arrayOfString, paramInt);
    g.aQ(paramString1, paramString2, paramInt);
    b.bEa(paramString1);
    AppMethodBeat.o(238117);
  }
  
  public static void aFJ(int paramInt)
  {
    AppMethodBeat.i(133522);
    new VFSStrategy.2(f.hfK, paramInt).alive();
    AppMethodBeat.o(133522);
  }
  
  public static void aR(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(133511);
    if (!rgc)
    {
      AppMethodBeat.o(133511);
      return;
    }
    paramString1 = bEt(paramString1);
    paramString2 = bEt(paramString2);
    String[] arrayOfString = jl(paramString2, paramInt);
    AbstractFileSystem localAbstractFileSystem = a(paramString1, arrayOfString, paramInt);
    localAbstractFileSystem.a(paramString1, ae.jLb());
    if (Arrays.binarySearch(e.agwq, paramString1) >= 0) {}
    synchronized (agAY)
    {
      agAY.add(localAbstractFileSystem);
      ??? = new StatisticsFileSystem(localAbstractFileSystem);
      ((AbstractFileSystem)???).a(paramString1, new g(arrayOfString[0], 1, paramInt, 0L, 0L));
      a(paramString1, (FileSystem)???, arrayOfString, paramInt);
      g.aQ(paramString1, paramString2, paramInt);
      AppMethodBeat.o(133511);
      return;
    }
  }
  
  private static AbstractFileSystem aS(String paramString1, String paramString2, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(238130);
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
          AppMethodBeat.o(238130);
          throw paramString1;
          i = 0;
          break;
          label70:
          paramInt = 0;
          continue;
        }
        paramString1 = new RC4EncryptedFileSystem(paramString2, paramString1);
        AppMethodBeat.o(238130);
        return paramString1;
      }
    }
    if (paramInt != 0)
    {
      paramString1 = new RefCountedFileSystem(paramString2);
      AppMethodBeat.o(238130);
      return paramString1;
    }
    AppMethodBeat.o(238130);
    return paramString2;
  }
  
  private static Object aT(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(238136);
    paramString1 = aS(paramString1, paramString2, paramInt);
    if (paramString2.contains("${accountSd}"))
    {
      paramString1 = new i.a(paramString1, "${accountSd}", "accountSd");
      AppMethodBeat.o(238136);
      return paramString1;
    }
    AppMethodBeat.o(238136);
    return paramString1;
  }
  
  public static void b(String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(238113);
    if (!rgc)
    {
      AppMethodBeat.o(238113);
      return;
    }
    paramString1 = bEt(paramString1);
    paramString2 = bEt(paramString2);
    String[] arrayOfString = jl(paramString2, paramInt);
    Object localObject = new StatisticsFileSystem(a(paramString1, arrayOfString, paramInt));
    ((AbstractFileSystem)localObject).a(paramString1, new g(arrayOfString[0], 4, paramInt, paramLong1 / 2L, paramLong2));
    localObject = new QuotaFileSystem((FileSystem)localObject, paramLong1 / 2L, paramLong1, paramLong2);
    ((QuotaFileSystem)localObject).a(paramString1, ae.jLb());
    a(paramString1, (FileSystem)localObject, arrayOfString, paramInt);
    g.aQ(paramString1, paramString2, paramInt);
    b.bEa(paramString1);
    AppMethodBeat.o(238113);
  }
  
  private static String bEt(String paramString)
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
  
  public static u eC(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(238212);
    Object localObject;
    if (!paramBoolean)
    {
      localObject = agBc;
      if (paramString != null) {
        break label67;
      }
    }
    for (;;)
    {
      ((u)localObject).jKY();
      AppMethodBeat.o(238212);
      return localObject;
      if (agBd != null)
      {
        localObject = agBd;
        break;
      }
      u localu = u.V(MMApplicationContext.getContext().getExternalCacheDir());
      localObject = localu;
      if (localu != null) {
        break;
      }
      localObject = agBc;
      break;
      label67:
      localObject = new u((u)localObject, paramString);
    }
  }
  
  private static k.a g(k.a parama)
  {
    try
    {
      AppMethodBeat.i(185096);
      if (agBb != null)
      {
        parama.bEb("camera-path-remapfs");
        parama.bEc(agBb);
      }
      String str1 = com.tencent.mm.loader.i.b.bmK();
      String str2 = com.tencent.mm.loader.i.b.bmy();
      ExtStorageMigrateMonitor.iSO().i("VFS.VFSStrategy", "[+] updateMigratePathRemappings, lastMountNewCameraPath: %s, newCameraPath: %s", new Object[] { agBb, str1 });
      if (com.tencent.mm.loader.i.b.bmK().equals(com.tencent.mm.loader.i.b.bmJ()))
      {
        ExtStorageMigrateMonitor.iSO().e("VFS.VFSStrategy", "[-] Fail to get new camera path, and we use old camera path for fallback.", new Object[0]);
        if (MMApplicationContext.isMainProcess()) {
          ExtStorageMigrateMonitor.yy(142L);
        }
      }
      agBb = str1;
      parama.a("camera-path-remapfs", new MigrationFileSystem(new NativeFileSystem(str1), new Object[] { new NativeFileSystem(str2 + "WeChat/"), new NativeFileSystem(str2 + "WeiXin/") })).qg(str1, "camera-path-remapfs").qg(str2 + "WeChat/", "camera-path-remapfs").qg(str2 + "WeiXin/", "camera-path-remapfs");
      AppMethodBeat.o(185096);
      return parama;
    }
    finally {}
  }
  
  public static void i(com.tencent.mm.kernel.b.g paramg)
  {
    boolean bool2 = true;
    try
    {
      AppMethodBeat.i(176882);
      bool3 = paramg.bbA();
      rgc = bool3;
      if (new File(paramg.bGP.getFilesDir().getParentFile(), ".vfs").exists()) {
        break label165;
      }
      bool1 = true;
    }
    finally
    {
      try
      {
        for (;;)
        {
          boolean bool3;
          ExtStorageMigrateMonitor.iSO().i("VFS.VFSStrategy", "Early init, isMainProcess: " + bool3 + ", VFSSwitch.isAsyncMigrationOpen():true, asyncMigrationDynCfgOpen:true, syncMigrationDynCfgOpen:true, isNewInstalled:" + ag.jLE(), new Object[0]);
          ExtStorageMigrateMonitor.iSO().i("VFS.VFSStrategy", "[+] updateSdCardPathOnDemand, isPathRemapOpened, NEW_SDCARD_ROOT: %s", new Object[] { com.tencent.mm.loader.i.b.bmv() });
          return;
          bool1 = false;
        }
        boolean bool1 = false;
      }
      finally
      {
        for (;;)
        {
          ExtStorageMigrateMonitor.iSO().printErrStackTrace("VFS.VFSStrategy", paramg, "Rarely exception.", new Object[0]);
        }
        paramg = finally;
      }
    }
    agAT = bool1;
    k.setContext(paramg.bGP);
    if (!bool3)
    {
      bool1 = bool2;
      k.Qd(bool1);
      k.a(agAS);
      k.kMs();
    }
  }
  
  /* Error */
  public static void j(com.tencent.mm.kernel.b.g paramg)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc_w 684
    //   8: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_0
    //   12: invokevirtual 628	com/tencent/mm/kernel/b/g:bbA	()Z
    //   15: istore_2
    //   16: iload_2
    //   17: putstatic 302	com/tencent/mm/vfs/af:rgc	Z
    //   20: iconst_1
    //   21: putstatic 46	com/tencent/mm/vfs/af:agAU	Z
    //   24: iload_2
    //   25: ifne +276 -> 301
    //   28: iload_1
    //   29: invokestatic 655	com/tencent/mm/vfs/k:Qd	(Z)V
    //   32: getstatic 44	com/tencent/mm/vfs/af:agAS	Lcom/tencent/mm/vfs/af$a;
    //   35: invokestatic 658	com/tencent/mm/vfs/k:a	(Lcom/tencent/mm/vfs/k$b;)V
    //   38: iload_2
    //   39: ifeq +242 -> 281
    //   42: new 476	com/tencent/mm/vfs/ExpireFileSystem
    //   45: dup
    //   46: new 352	com/tencent/mm/vfs/NativeFileSystem
    //   49: dup
    //   50: ldc_w 686
    //   53: invokespecial 355	com/tencent/mm/vfs/NativeFileSystem:<init>	(Ljava/lang/String;)V
    //   56: ldc2_w 687
    //   59: invokespecial 479	com/tencent/mm/vfs/ExpireFileSystem:<init>	(Lcom/tencent/mm/vfs/FileSystem;J)V
    //   62: astore_0
    //   63: new 476	com/tencent/mm/vfs/ExpireFileSystem
    //   66: dup
    //   67: new 352	com/tencent/mm/vfs/NativeFileSystem
    //   70: dup
    //   71: ldc_w 690
    //   74: invokespecial 355	com/tencent/mm/vfs/NativeFileSystem:<init>	(Ljava/lang/String;)V
    //   77: ldc2_w 687
    //   80: invokespecial 479	com/tencent/mm/vfs/ExpireFileSystem:<init>	(Lcom/tencent/mm/vfs/FileSystem;J)V
    //   83: astore_3
    //   84: invokestatic 122	com/tencent/mm/vfs/k:kMs	()Lcom/tencent/mm/vfs/k;
    //   87: astore 4
    //   89: aload 4
    //   91: iconst_0
    //   92: putfield 275	com/tencent/mm/vfs/k:akmI	Z
    //   95: aload 4
    //   97: invokevirtual 126	com/tencent/mm/vfs/k:kMv	()Lcom/tencent/mm/vfs/k$a;
    //   100: astore 4
    //   102: aload 4
    //   104: new 692	com/tencent/mm/vfs/p
    //   107: dup
    //   108: invokespecial 693	com/tencent/mm/vfs/p:<init>	()V
    //   111: putfield 697	com/tencent/mm/vfs/k$a:agxI	Lcom/tencent/mm/vfs/p;
    //   114: aload 4
    //   116: iconst_1
    //   117: putfield 700	com/tencent/mm/vfs/k$a:agxJ	Z
    //   120: aload 4
    //   122: ldc_w 702
    //   125: invokestatic 708	com/tencent/mm/vfs/AssetsSchemeResolver:jKb	()Lcom/tencent/mm/vfs/AssetsSchemeResolver;
    //   128: invokevirtual 711	com/tencent/mm/vfs/k$a:a	(Ljava/lang/String;Lcom/tencent/mm/vfs/SchemeResolver;)Lcom/tencent/mm/vfs/k$a;
    //   131: ldc_w 713
    //   134: invokestatic 719	com/tencent/mm/vfs/ContentsSchemeResolver:jKg	()Lcom/tencent/mm/vfs/SchemeResolver;
    //   137: invokevirtual 711	com/tencent/mm/vfs/k$a:a	(Ljava/lang/String;Lcom/tencent/mm/vfs/SchemeResolver;)Lcom/tencent/mm/vfs/k$a;
    //   140: ldc_w 721
    //   143: new 352	com/tencent/mm/vfs/NativeFileSystem
    //   146: dup
    //   147: ldc_w 723
    //   150: invokespecial 355	com/tencent/mm/vfs/NativeFileSystem:<init>	(Ljava/lang/String;)V
    //   153: invokevirtual 369	com/tencent/mm/vfs/k$a:a	(Ljava/lang/String;Lcom/tencent/mm/vfs/FileSystem;)Lcom/tencent/mm/vfs/k$a;
    //   156: ldc_w 725
    //   159: new 352	com/tencent/mm/vfs/NativeFileSystem
    //   162: dup
    //   163: ldc_w 727
    //   166: invokespecial 355	com/tencent/mm/vfs/NativeFileSystem:<init>	(Ljava/lang/String;)V
    //   169: invokevirtual 369	com/tencent/mm/vfs/k$a:a	(Ljava/lang/String;Lcom/tencent/mm/vfs/FileSystem;)Lcom/tencent/mm/vfs/k$a;
    //   172: ldc 89
    //   174: aload_0
    //   175: invokevirtual 369	com/tencent/mm/vfs/k$a:a	(Ljava/lang/String;Lcom/tencent/mm/vfs/FileSystem;)Lcom/tencent/mm/vfs/k$a;
    //   178: ldc_w 729
    //   181: aload_3
    //   182: invokevirtual 369	com/tencent/mm/vfs/k$a:a	(Ljava/lang/String;Lcom/tencent/mm/vfs/FileSystem;)Lcom/tencent/mm/vfs/k$a;
    //   185: ldc_w 723
    //   188: ldc_w 721
    //   191: invokevirtual 377	com/tencent/mm/vfs/k$a:qg	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/vfs/k$a;
    //   194: ldc_w 727
    //   197: ldc_w 725
    //   200: invokevirtual 377	com/tencent/mm/vfs/k$a:qg	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/vfs/k$a;
    //   203: ldc_w 686
    //   206: ldc 89
    //   208: invokevirtual 377	com/tencent/mm/vfs/k$a:qg	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/vfs/k$a;
    //   211: ldc_w 690
    //   214: ldc_w 729
    //   217: invokevirtual 377	com/tencent/mm/vfs/k$a:qg	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/vfs/k$a;
    //   220: astore_0
    //   221: getstatic 734	com/tencent/mm/sdk/platformtools/BuildInfo:DEBUG	Z
    //   224: ifne +21 -> 245
    //   227: getstatic 737	com/tencent/mm/sdk/platformtools/BuildInfo:IS_FLAVOR_RED	Z
    //   230: ifne +15 -> 245
    //   233: getstatic 740	com/tencent/mm/sdk/platformtools/BuildInfo:IS_FLAVOR_BLUE	Z
    //   236: ifne +9 -> 245
    //   239: getstatic 743	com/tencent/mm/sdk/platformtools/BuildInfo:IS_FLAVOR_PURPLE	Z
    //   242: ifeq +7 -> 249
    //   245: aload_0
    //   246: invokestatic 748	com/tencent/mm/vfs/t:f	(Lcom/tencent/mm/vfs/k$a;)V
    //   249: aload_0
    //   250: invokestatic 750	com/tencent/mm/vfs/af:g	(Lcom/tencent/mm/vfs/k$a;)Lcom/tencent/mm/vfs/k$a;
    //   253: pop
    //   254: aload_0
    //   255: invokestatic 754	com/tencent/mm/vfs/MigrationStatistics:e	(Lcom/tencent/mm/vfs/k$a;)V
    //   258: aload_0
    //   259: invokestatic 759	com/tencent/mm/compatible/util/e:aPU	()Z
    //   262: iconst_1
    //   263: invokestatic 761	com/tencent/mm/vfs/af:a	(Lcom/tencent/mm/vfs/k$a;ZZ)Lcom/tencent/mm/vfs/k$a;
    //   266: iconst_0
    //   267: invokevirtual 764	com/tencent/mm/vfs/k$a:NS	(Z)V
    //   270: ldc 89
    //   272: invokestatic 495	com/tencent/mm/vfs/b:bEa	(Ljava/lang/String;)V
    //   275: ldc_w 729
    //   278: invokestatic 495	com/tencent/mm/vfs/b:bEa	(Ljava/lang/String;)V
    //   281: new 6	com/tencent/mm/vfs/af$1
    //   284: dup
    //   285: invokespecial 765	com/tencent/mm/vfs/af$1:<init>	()V
    //   288: invokestatic 771	com/tencent/mm/graphics/MMBitmapFactory:setStreamProvider	(Lcom/tencent/mm/graphics/MMBitmapFactory$b;)V
    //   291: ldc_w 684
    //   294: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   297: ldc 2
    //   299: monitorexit
    //   300: return
    //   301: iconst_0
    //   302: istore_1
    //   303: goto -275 -> 28
    //   306: astore_0
    //   307: ldc 2
    //   309: monitorexit
    //   310: aload_0
    //   311: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	paramg	com.tencent.mm.kernel.b.g
    //   1	302	1	bool1	boolean
    //   15	24	2	bool2	boolean
    //   83	99	3	localExpireFileSystem	ExpireFileSystem
    //   87	34	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	24	306	finally
    //   28	38	306	finally
    //   42	245	306	finally
    //   245	249	306	finally
    //   249	281	306	finally
    //   281	297	306	finally
  }
  
  public static void jLB()
  {
    int k = 0;
    int i = 0;
    AppMethodBeat.i(133520);
    Log.i("VFS.VFSStrategy", "Configuration done.");
    agAW = true;
    int j = k;
    try
    {
      if (rgc)
      {
        j = k;
        if (agAV)
        {
          if (!agAX) {
            i = 1;
          }
          j = i;
          if (i != 0)
          {
            agAX = true;
            j = i;
          }
        }
      }
      if (j != 0) {
        NT(com.tencent.mm.compatible.util.e.aPU());
      }
      AppMethodBeat.o(133520);
      return;
    }
    finally
    {
      AppMethodBeat.o(133520);
    }
  }
  
  public static void jLC()
  {
    AppMethodBeat.i(185097);
    ExtStorageMigrateMonitor.iSO().i("VFS.VFSStrategy", "[+] updateSdCardPathOnDemand called.", new Object[0]);
    ExtStorageMigrateMonitor.iSO().i("VFS.VFSStrategy", "[+] updateSdCardPathOnDemand, isPathRemapOpened, NEW_SDCARD_ROOT: %s", new Object[] { com.tencent.mm.loader.i.b.bmv() });
    com.tencent.mm.loader.i.b.bnC();
    com.tencent.mm.loader.i.b.F(com.tencent.mm.loader.i.b.bmv(), true);
    if (MMApplicationContext.isMainProcess()) {
      g(k.kMs().kMv()).commit();
    }
    AppMethodBeat.o(185097);
  }
  
  private static String[] jl(String paramString, int paramInt)
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
    if (i != 0)
    {
      str1 = "";
      if (paramInt != 0)
      {
        if (j == 0) {
          break label356;
        }
        str2 = "${account}/";
        label148:
        if (k != 0) {
          localLinkedHashSet.add("${dataCache}/" + str2 + paramString);
        }
        localLinkedHashSet.add("${data}/" + str1 + str2 + paramString);
      }
      if (m != 0) {
        if (j == 0) {
          break label363;
        }
      }
    }
    label356:
    label363:
    for (String str2 = "${accountSd}/";; str2 = "")
    {
      if (k != 0) {
        localLinkedHashSet.add("${sdToCache}/" + str2 + paramString);
      }
      localLinkedHashSet.add("${sdTo}/" + str1 + str2 + paramString);
      localLinkedHashSet.add("${sdFrom}/" + str1 + str2 + paramString);
      paramString = (String[])localLinkedHashSet.toArray(new String[0]);
      AppMethodBeat.o(133514);
      return paramString;
      str1 = "MicroMsg/";
      break;
      str2 = "";
      break label148;
    }
  }
  
  public static void qs(String paramString1, String paramString2)
  {
    AppMethodBeat.i(238119);
    if (!rgc)
    {
      AppMethodBeat.o(238119);
      return;
    }
    paramString1 = bEt(paramString1);
    paramString2 = bEt(paramString2);
    String[] arrayOfString = new String[1];
    arrayOfString[0] = paramString2;
    Object localObject = new StatisticsFileSystem(aS(paramString1, arrayOfString[0], 100));
    ((AbstractFileSystem)localObject).a(paramString1, new g(arrayOfString[0], 3, 100, 0L, 604800000L));
    localObject = new ExpireFileSystem((FileSystem)localObject, 604800000L);
    ((ExpireFileSystem)localObject).a(paramString1, ae.jLb());
    a(paramString1, (FileSystem)localObject, arrayOfString, 100);
    g.aQ(paramString1, paramString2, 100);
    AppMethodBeat.o(238119);
  }
  
  public static void qt(String paramString1, String paramString2)
  {
    int i = 1;
    AppMethodBeat.i(238122);
    if (Util.getInt(d.dNI().a("clicfg_clean_expire_switch", "1", false, true), 1) > 0) {}
    while (i == 0)
    {
      a(paramString1, paramString2, 604800000L, 17);
      AppMethodBeat.o(238122);
      return;
      i = 0;
    }
    if (!rgc)
    {
      AppMethodBeat.o(238122);
      return;
    }
    paramString1 = bEt(paramString1);
    paramString2 = bEt(paramString2);
    String[] arrayOfString = jl(paramString2, 49);
    Object localObject = new StatisticsFileSystem(a(paramString1, arrayOfString, 49));
    ((AbstractFileSystem)localObject).a(paramString1, new g(arrayOfString[0], 3, 49, 0L, 604800000L));
    localObject = new CleanExpireFileSystem((FileSystem)localObject);
    ((CleanExpireFileSystem)localObject).a(paramString1, ae.jLb());
    a(paramString1, (FileSystem)localObject, arrayOfString, 49);
    g.aQ(paramString1, paramString2, 49);
    b.bEa(paramString1);
    AppMethodBeat.o(238122);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.af
 * JD-Core Version:    0.7.0.1
 */