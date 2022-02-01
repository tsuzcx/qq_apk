package com.tencent.mm.vfs;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.ci;
import com.tencent.mm.graphics.MMBitmapFactory.b;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor;
import com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.File;
import java.io.InputStream;
import java.security.Key;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import javax.crypto.spec.SecretKeySpec;

public final class o
{
  private static final a Juh;
  private static boolean Jui;
  private static volatile boolean Juj;
  private static volatile boolean Juk;
  private static final HashSet<String> Jul;
  private static volatile String Jum;
  private static String Jun;
  private static String Juo;
  private static String Jup;
  private static volatile boolean zmI;
  
  static
  {
    AppMethodBeat.i(176883);
    Juh = new a((byte)0);
    Jui = false;
    Juj = false;
    Juk = false;
    HashSet localHashSet = new HashSet();
    Jul = localHashSet;
    localHashSet.add("attachment");
    Jul.add("Download");
    Jul.add("voice");
    Jul.add("voice2");
    Jul.add("image");
    Jul.add("image2");
    Jul.add("oldimage2");
    Jul.add("video");
    Jul.add("emoji");
    Jul.add("oneday");
    Jul.add("finder");
    Jul.add("sns_ad_landingpages");
    Jum = "";
    Jun = null;
    Juo = null;
    Jup = null;
    AppMethodBeat.o(176883);
  }
  
  private static a.a a(a.a parama)
  {
    try
    {
      AppMethodBeat.i(185096);
      if (Jun != null)
      {
        parama.aSl("camera-path-remapfs");
        parama.aSm(Jun);
      }
      if ((Juo != null) || (Jup != null))
      {
        parama.aSl("sdcard-path-remapfs");
        if (Juo != null) {
          parama.aSm(Juo);
        }
        if (Jup != null) {
          parama.aSm(Jup);
        }
      }
      String str1 = com.tencent.mm.loader.j.b.apr();
      String str2 = com.tencent.mm.loader.j.b.apd() + "/MicroMsg/";
      String str3 = com.tencent.mm.loader.j.b.apg();
      ExtStorageMigrateMonitor.eTC().i("VFS.VFSStrategy", "[+] updateMigratePathRemappings, lastMountNewCameraPath: %s, lastMountNewSDCardPath: %s, lastMountOldSDCardPath: %s, newCameraPath: %s, newSDCardPath: %s, oldSDCardPath: %s", new Object[] { Jun, Juo, Jup, str1, str2, str3 });
      if (com.tencent.mm.loader.j.b.apr().equals(com.tencent.mm.loader.j.b.apq()))
      {
        ExtStorageMigrateMonitor.eTC().e("VFS.VFSStrategy", "[-] Fail to get new camera path, and we use old camera path for fallback.", new Object[0]);
        if (ai.cin()) {
          ExtStorageMigrateMonitor.as(1315L, 142L);
        }
      }
      Jun = str1;
      Juo = str2;
      Jup = str3;
      parama.a("sdcard-path-remapfs", new MigrationFileSystem(new NativeFileSystem(str2), new FileSystem[] { new NativeFileSystem(str3) })).a("camera-path-remapfs", new MigrationFileSystem(new NativeFileSystem(str1), new FileSystem[] { new NativeFileSystem(str3 + "WeChat/"), new NativeFileSystem(str3 + "WeiXin/") })).lV(str2, "sdcard-path-remapfs").lV(str1, "camera-path-remapfs").lV(str3, "sdcard-path-remapfs").lV(str3 + "WeChat/", "camera-path-remapfs").lV(str3 + "WeiXin/", "camera-path-remapfs");
      AppMethodBeat.o(185096);
      return parama;
    }
    finally {}
  }
  
  public static a.a a(a.a parama, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(133524);
    ac.i("VFS.VFSStrategy", "Update account migration: sysPath = " + paramString + ", useSaltPath = " + paramBoolean);
    String str = Jum;
    if (paramBoolean)
    {
      if (com.tencent.mm.loader.j.b.apb().equals(com.tencent.mm.loader.j.b.apc())) {}
      for (MigrationFileSystem localMigrationFileSystem = new MigrationFileSystem("${sdFrom}", "${sdFrom}", new NativeFileSystem(paramString + "${accountSalt}"), new FileSystem[] { new NativeFileSystem(paramString + "${account}") });; localMigrationFileSystem = new MigrationFileSystem("${sdFrom}", "${sdFrom}", new NativeFileSystem(paramString + "${accountSalt}"), new FileSystem[] { new NativeFileSystem(paramString + "${account}"), new NativeFileSystem(com.tencent.mm.loader.j.b.apg() + "${accountSalt}"), new NativeFileSystem(com.tencent.mm.loader.j.b.apg() + "${account}") }))
      {
        Jum = paramString;
        parama = parama.a("accPathMigration", localMigrationFileSystem).aSm(str + "${accountSalt}").aSm(str + "${account}").lV(paramString + "${accountSalt}", "accPathMigration").lV(paramString + "${account}", "accPathMigration");
        AppMethodBeat.o(133524);
        return parama;
      }
    }
    Jum = "";
    parama = parama.aSl("accPathMigration").aSm(str + "${accountSalt}").aSm(str + "${account}");
    AppMethodBeat.o(133524);
    return parama;
  }
  
  public static a.a a(a.a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(133523);
    Object localObject = ai.getContext();
    ac.i("VFS.VFSStrategy", "Update SDCard status: isSDCardAvailAndSysPathOk = ".concat(String.valueOf(paramBoolean1)));
    if (paramBoolean1)
    {
      String str1 = com.tencent.mm.loader.j.b.apc() + "/tencent";
      String str2 = com.tencent.mm.loader.j.b.apd();
      localObject = ((Context)localObject).getExternalCacheDir();
      if (!paramBoolean2)
      {
        ac.w("VFS.VFSStrategy", "do not use external private storage.");
        localObject = null;
      }
      a.a locala = parama.lW("sdFrom", str1);
      if (localObject == null)
      {
        parama = str1;
        locala = locala.lW("sdTo", parama);
        if (localObject != null) {
          break label162;
        }
      }
      label162:
      for (parama = str1 + "/MicroMsg";; parama = ((File)localObject).getPath())
      {
        parama = locala.lW("sdToCache", parama).lW("extSDFrom", str2);
        AppMethodBeat.o(133523);
        return parama;
        parama = ((File)localObject).getParent();
        break;
      }
    }
    localObject = ((Context)localObject).getCacheDir();
    parama = parama.aSn("sdFrom").aSn("extSDFrom").lW("sdTo", ((File)localObject).getParent()).lW("sdToCache", ((File)localObject).getPath());
    AppMethodBeat.o(133523);
    return parama;
  }
  
  private static void a(String paramString, FileSystem paramFileSystem, String[] paramArrayOfString, int paramInt)
  {
    AppMethodBeat.i(206988);
    paramFileSystem = a.ghk().ghm().a(paramString, paramFileSystem);
    if ((paramInt & 0x200) == 0)
    {
      int i = paramArrayOfString.length;
      paramInt = 0;
      while (paramInt < i)
      {
        paramFileSystem.lV(paramArrayOfString[paramInt], paramString);
        paramInt += 1;
      }
    }
    paramFileSystem.commit();
    AppMethodBeat.o(206988);
  }
  
  public static void a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    AppMethodBeat.i(133512);
    if (!zmI)
    {
      AppMethodBeat.o(133512);
      return;
    }
    if ((aSx(paramString1)) && (!p.fyy()))
    {
      AppMethodBeat.o(133512);
      return;
    }
    paramString1 = aSy(paramString1);
    paramString2 = gp(aSy(paramString2), paramInt);
    QuotaFileSystem localQuotaFileSystem = new QuotaFileSystem(b(paramString1, paramString2, paramInt), paramLong / 2L, paramLong);
    localQuotaFileSystem.a(paramString1, n.fxY());
    a(paramString1, localQuotaFileSystem, paramString2, paramInt);
    AppMethodBeat.o(133512);
  }
  
  private static boolean aSx(String paramString)
  {
    AppMethodBeat.i(206983);
    ac.i("VFS.VFSStrategy", "isVFSSecondPhase: %s, %s", new Object[] { paramString, Boolean.valueOf(Jul.contains(paramString)) });
    boolean bool = Jul.contains(paramString);
    AppMethodBeat.o(206983);
    return bool;
  }
  
  private static String aSy(String paramString)
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
  
  public static void adt(int paramInt)
  {
    AppMethodBeat.i(133522);
    com.tencent.mm.sdk.b.a.GpY.b(new c() {});
    AppMethodBeat.o(133522);
  }
  
  public static void aj(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(133511);
    if (!zmI)
    {
      AppMethodBeat.o(133511);
      return;
    }
    if ((aSx(paramString1)) && (!p.fyy()))
    {
      AppMethodBeat.o(133511);
      return;
    }
    paramString1 = aSy(paramString1);
    paramString2 = gp(aSy(paramString2), paramInt);
    AbstractFileSystem localAbstractFileSystem = b(paramString1, paramString2, paramInt);
    localAbstractFileSystem.a(paramString1, n.fxY());
    a(paramString1, localAbstractFileSystem, paramString2, paramInt);
    AppMethodBeat.o(133511);
  }
  
  private static AbstractFileSystem ak(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(206986);
    paramString2 = new NativeFileSystem(paramString2);
    if ((paramInt & 0x8) == 0)
    {
      AppMethodBeat.o(206986);
      return paramString2;
    }
    paramString1 = new RC4EncryptedFileSystem(paramString2, paramString1);
    AppMethodBeat.o(206986);
    return paramString1;
  }
  
  private static AbstractFileSystem b(String paramString, String[] paramArrayOfString, int paramInt)
  {
    AppMethodBeat.i(206987);
    if ((paramArrayOfString.length == 1) || ((paramInt & 0x40) != 0))
    {
      paramString = ak(paramString, paramArrayOfString[0], paramInt);
      AppMethodBeat.o(206987);
      return paramString;
    }
    FileSystem[] arrayOfFileSystem = new FileSystem[paramArrayOfString.length - 1];
    int i = 1;
    while (i < paramArrayOfString.length)
    {
      arrayOfFileSystem[(i - 1)] = ak(paramString, paramArrayOfString[i], paramInt);
      i += 1;
    }
    int j;
    label95:
    String str1;
    label103:
    String str2;
    if ((paramInt & 0x80) == 0)
    {
      i = 1;
      if ((paramInt & 0x400) == 0) {
        break label157;
      }
      j = 1;
      if (i == 0) {
        break label163;
      }
      str1 = "${sdFrom}";
      if (i == 0) {
        break label169;
      }
      str2 = "${sdFrom}";
      label111:
      if (j == 0) {
        break label175;
      }
    }
    label157:
    label163:
    label169:
    label175:
    for (String str3 = "${sdFrom}";; str3 = null)
    {
      paramString = new MigrationFileSystem(str1, str2, str3, ak(paramString, paramArrayOfString[0], paramInt), arrayOfFileSystem);
      AppMethodBeat.o(206987);
      return paramString;
      i = 0;
      break;
      j = 0;
      break label95;
      str1 = null;
      break label103;
      str2 = null;
      break label111;
    }
  }
  
  public static void b(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    AppMethodBeat.i(206984);
    if (!zmI)
    {
      AppMethodBeat.o(206984);
      return;
    }
    if ((aSx(paramString1)) && (!p.fyy()))
    {
      AppMethodBeat.o(206984);
      return;
    }
    paramString1 = aSy(paramString1);
    paramString2 = aSy(paramString2);
    paramInt |= 0x20;
    paramString2 = gp(paramString2, paramInt);
    ExpireFileSystem localExpireFileSystem = new ExpireFileSystem(b(paramString1, paramString2, paramInt), paramLong);
    localExpireFileSystem.a(paramString1, n.fxY());
    a(paramString1, localExpireFileSystem, paramString2, paramInt);
    AppMethodBeat.o(206984);
  }
  
  /* Error */
  public static void f(com.tencent.mm.kernel.b.g paramg)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc_w 420
    //   8: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_0
    //   12: invokevirtual 425	com/tencent/mm/kernel/b/g:ahL	()Z
    //   15: istore_2
    //   16: iload_2
    //   17: putstatic 306	com/tencent/mm/vfs/o:zmI	Z
    //   20: aload_0
    //   21: getfield 429	com/tencent/mm/kernel/b/g:ca	Landroid/app/Application;
    //   24: invokestatic 433	com/tencent/mm/vfs/a:setContext	(Landroid/content/Context;)V
    //   27: iload_2
    //   28: ifne +132 -> 160
    //   31: iload_1
    //   32: invokestatic 437	com/tencent/mm/vfs/a:zM	(Z)V
    //   35: getstatic 41	com/tencent/mm/vfs/o:Juh	Lcom/tencent/mm/vfs/o$a;
    //   38: invokestatic 440	com/tencent/mm/vfs/a:a	(Lcom/tencent/mm/vfs/a$b;)V
    //   41: ldc 142
    //   43: new 118	java/lang/StringBuilder
    //   46: dup
    //   47: ldc_w 442
    //   50: invokespecial 204	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   53: iload_2
    //   54: invokevirtual 209	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   57: ldc_w 444
    //   60: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokestatic 315	com/tencent/mm/vfs/p:fyy	()Z
    //   66: invokevirtual 209	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   69: ldc_w 446
    //   72: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokestatic 449	com/tencent/mm/vfs/p:fyw	()Z
    //   78: invokevirtual 209	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   81: ldc_w 451
    //   84: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokestatic 454	com/tencent/mm/vfs/p:fyx	()Z
    //   90: invokevirtual 209	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   93: ldc_w 456
    //   96: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokestatic 459	com/tencent/mm/vfs/p:fyv	()Z
    //   102: invokevirtual 209	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   105: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 214	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: invokestatic 462	com/tencent/mm/vfs/p:fyz	()Z
    //   114: ifeq +36 -> 150
    //   117: invokestatic 140	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:eTC	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
    //   120: ldc 142
    //   122: ldc_w 464
    //   125: iconst_1
    //   126: anewarray 4	java/lang/Object
    //   129: dup
    //   130: iconst_0
    //   131: invokestatic 122	com/tencent/mm/loader/j/b:apd	()Ljava/lang/String;
    //   134: aastore
    //   135: invokeinterface 149 4 0
    //   140: invokestatic 467	com/tencent/mm/loader/j/b:aqe	()V
    //   143: invokestatic 122	com/tencent/mm/loader/j/b:apd	()Ljava/lang/String;
    //   146: iconst_1
    //   147: invokestatic 471	com/tencent/mm/loader/j/b:z	(Ljava/lang/String;Z)V
    //   150: ldc_w 420
    //   153: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: ldc 2
    //   158: monitorexit
    //   159: return
    //   160: iconst_0
    //   161: istore_1
    //   162: goto -131 -> 31
    //   165: astore_0
    //   166: ldc 2
    //   168: monitorexit
    //   169: aload_0
    //   170: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	paramg	com.tencent.mm.kernel.b.g
    //   1	161	1	bool1	boolean
    //   15	39	2	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   5	27	165	finally
    //   31	150	165	finally
    //   150	156	165	finally
  }
  
  public static void fyt()
  {
    try
    {
      AppMethodBeat.i(133520);
      ac.i("VFS.VFSStrategy", "Configuration done.");
      Juk = true;
      if ((zmI) && (Juj))
      {
        ac.i("VFS.VFSStrategy", "Broadcasting enabled.");
        a locala = a.ghk();
        locala.Kjc = true;
        locala.ghn();
        if (e.YD()) {
          locala.ax(420000L, 86400000L);
        }
      }
      AppMethodBeat.o(133520);
      return;
    }
    finally {}
  }
  
  public static void fyu()
  {
    AppMethodBeat.i(185097);
    ExtStorageMigrateMonitor.eTC().i("VFS.VFSStrategy", "[+] updateSdCardPathOnDemand called.", new Object[0]);
    if (p.fyz())
    {
      ExtStorageMigrateMonitor.eTC().i("VFS.VFSStrategy", "[+] updateSdCardPathOnDemand, isPathRemapOpened, NEW_SDCARD_ROOT: %s", new Object[] { com.tencent.mm.loader.j.b.apd() });
      com.tencent.mm.loader.j.b.aqe();
      com.tencent.mm.loader.j.b.z(com.tencent.mm.loader.j.b.apd(), true);
      if (ai.cin()) {
        a(a.ghk().ghm()).commit();
      }
    }
    AppMethodBeat.o(185097);
  }
  
  /* Error */
  public static void g(com.tencent.mm.kernel.b.g paramg)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc_w 503
    //   8: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_0
    //   12: invokevirtual 425	com/tencent/mm/kernel/b/g:ahL	()Z
    //   15: istore_2
    //   16: iload_2
    //   17: putstatic 306	com/tencent/mm/vfs/o:zmI	Z
    //   20: iconst_1
    //   21: putstatic 43	com/tencent/mm/vfs/o:Jui	Z
    //   24: iload_2
    //   25: ifne +196 -> 221
    //   28: iload_1
    //   29: invokestatic 437	com/tencent/mm/vfs/a:zM	(Z)V
    //   32: getstatic 41	com/tencent/mm/vfs/o:Juh	Lcom/tencent/mm/vfs/o$a;
    //   35: invokestatic 440	com/tencent/mm/vfs/a:a	(Lcom/tencent/mm/vfs/a$b;)V
    //   38: iload_2
    //   39: ifeq +162 -> 201
    //   42: new 413	com/tencent/mm/vfs/ExpireFileSystem
    //   45: dup
    //   46: new 180	com/tencent/mm/vfs/NativeFileSystem
    //   49: dup
    //   50: ldc_w 505
    //   53: invokespecial 183	com/tencent/mm/vfs/NativeFileSystem:<init>	(Ljava/lang/String;)V
    //   56: ldc2_w 506
    //   59: invokespecial 416	com/tencent/mm/vfs/ExpireFileSystem:<init>	(Lcom/tencent/mm/vfs/FileSystem;J)V
    //   62: pop
    //   63: invokestatic 295	com/tencent/mm/vfs/a:ghk	()Lcom/tencent/mm/vfs/a;
    //   66: astore_0
    //   67: aload_0
    //   68: iconst_0
    //   69: putfield 480	com/tencent/mm/vfs/a:Kjc	Z
    //   72: aload_0
    //   73: invokevirtual 299	com/tencent/mm/vfs/a:ghm	()Lcom/tencent/mm/vfs/a$a;
    //   76: astore_0
    //   77: aload_0
    //   78: getfield 511	com/tencent/mm/vfs/a$a:JsB	Ljava/util/HashMap;
    //   81: invokevirtual 516	java/util/HashMap:clear	()V
    //   84: aload_0
    //   85: getfield 520	com/tencent/mm/vfs/a$a:JsC	Ljava/util/TreeMap;
    //   88: invokevirtual 523	java/util/TreeMap:clear	()V
    //   91: aload_0
    //   92: getfield 526	com/tencent/mm/vfs/a$a:JsD	Ljava/util/HashMap;
    //   95: invokevirtual 516	java/util/HashMap:clear	()V
    //   98: aload_0
    //   99: aconst_null
    //   100: putfield 530	com/tencent/mm/vfs/a$a:JsE	Lcom/tencent/mm/vfs/FileSystem;
    //   103: aload_0
    //   104: iconst_1
    //   105: putfield 533	com/tencent/mm/vfs/a$a:JsF	Z
    //   108: aload_0
    //   109: ldc_w 535
    //   112: invokestatic 541	com/tencent/mm/vfs/AssetsSchemeResolver:fxB	()Lcom/tencent/mm/vfs/AssetsSchemeResolver;
    //   115: invokevirtual 544	com/tencent/mm/vfs/a$a:a	(Ljava/lang/String;Lcom/tencent/mm/vfs/SchemeResolver;)Lcom/tencent/mm/vfs/a$a;
    //   118: ldc_w 546
    //   121: invokestatic 552	com/tencent/mm/vfs/ContentsSchemeResolver:fxE	()Lcom/tencent/mm/vfs/ContentsSchemeResolver;
    //   124: invokevirtual 544	com/tencent/mm/vfs/a$a:a	(Ljava/lang/String;Lcom/tencent/mm/vfs/SchemeResolver;)Lcom/tencent/mm/vfs/a$a;
    //   127: ldc_w 554
    //   130: new 180	com/tencent/mm/vfs/NativeFileSystem
    //   133: dup
    //   134: ldc_w 556
    //   137: invokespecial 183	com/tencent/mm/vfs/NativeFileSystem:<init>	(Ljava/lang/String;)V
    //   140: invokevirtual 191	com/tencent/mm/vfs/a$a:a	(Ljava/lang/String;Lcom/tencent/mm/vfs/FileSystem;)Lcom/tencent/mm/vfs/a$a;
    //   143: ldc_w 558
    //   146: new 180	com/tencent/mm/vfs/NativeFileSystem
    //   149: dup
    //   150: ldc_w 560
    //   153: invokespecial 183	com/tencent/mm/vfs/NativeFileSystem:<init>	(Ljava/lang/String;)V
    //   156: invokevirtual 191	com/tencent/mm/vfs/a$a:a	(Ljava/lang/String;Lcom/tencent/mm/vfs/FileSystem;)Lcom/tencent/mm/vfs/a$a;
    //   159: ldc_w 556
    //   162: ldc_w 554
    //   165: invokevirtual 199	com/tencent/mm/vfs/a$a:lV	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/vfs/a$a;
    //   168: ldc_w 560
    //   171: ldc_w 558
    //   174: invokevirtual 199	com/tencent/mm/vfs/a$a:lV	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/vfs/a$a;
    //   177: astore_0
    //   178: invokestatic 462	com/tencent/mm/vfs/p:fyz	()Z
    //   181: ifeq +8 -> 189
    //   184: aload_0
    //   185: invokestatic 501	com/tencent/mm/vfs/o:a	(Lcom/tencent/mm/vfs/a$a;)Lcom/tencent/mm/vfs/a$a;
    //   188: pop
    //   189: aload_0
    //   190: invokestatic 488	com/tencent/mm/compatible/util/e:YD	()Z
    //   193: iconst_1
    //   194: invokestatic 562	com/tencent/mm/vfs/o:a	(Lcom/tencent/mm/vfs/a$a;ZZ)Lcom/tencent/mm/vfs/a$a;
    //   197: iconst_0
    //   198: invokevirtual 565	com/tencent/mm/vfs/a$a:yo	(Z)V
    //   201: new 6	com/tencent/mm/vfs/o$1
    //   204: dup
    //   205: invokespecial 566	com/tencent/mm/vfs/o$1:<init>	()V
    //   208: invokestatic 572	com/tencent/mm/graphics/MMBitmapFactory:setStreamProvider	(Lcom/tencent/mm/graphics/MMBitmapFactory$b;)V
    //   211: ldc_w 503
    //   214: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   217: ldc 2
    //   219: monitorexit
    //   220: return
    //   221: iconst_0
    //   222: istore_1
    //   223: goto -195 -> 28
    //   226: astore_0
    //   227: ldc 2
    //   229: monitorexit
    //   230: aload_0
    //   231: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	paramg	com.tencent.mm.kernel.b.g
    //   1	222	1	bool1	boolean
    //   15	24	2	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   5	24	226	finally
    //   28	38	226	finally
    //   42	189	226	finally
    //   189	201	226	finally
    //   201	217	226	finally
  }
  
  private static String[] gp(String paramString, int paramInt)
  {
    int n = 1;
    AppMethodBeat.i(133514);
    int i;
    int j;
    label26:
    int k;
    label35:
    int m;
    label44:
    label55:
    LinkedHashSet localLinkedHashSet;
    String str2;
    label78:
    String str1;
    if ((paramInt & 0x4) == 0)
    {
      i = 1;
      if ((paramInt & 0x20) == 0) {
        break label307;
      }
      j = 1;
      if ((paramInt & 0x1) == 0) {
        break label312;
      }
      k = 1;
      if ((paramInt & 0x2) == 0) {
        break label318;
      }
      m = 1;
      if ((paramInt & 0x100) == 0) {
        break label324;
      }
      paramInt = n;
      localLinkedHashSet = new LinkedHashSet();
      if (m == 0) {
        break label337;
      }
      if (j == 0) {
        break label329;
      }
      str2 = "${sdToCache}/";
      str1 = str2;
      if (i != 0) {
        str1 = str2 + "${accountSd}/";
      }
      localLinkedHashSet.add(str1 + paramString);
      if (k == 0) {
        break label453;
      }
      if (i == 0) {
        break label388;
      }
      if ((j != 0) && (p.fyz()))
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
      label307:
      j = 0;
      break label26;
      label312:
      k = 0;
      break label35;
      label318:
      m = 0;
      break label44;
      label324:
      paramInt = 0;
      break label55;
      label329:
      str2 = "${sdTo}/MicroMsg/";
      break label78;
      label337:
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
      label388:
      localLinkedHashSet.add("${sdFrom}/MicroMsg/" + paramString);
      if ((j != 0) && (p.fyz()))
      {
        localLinkedHashSet.add("${extSDFrom}/MicroMsg/" + paramString);
        continue;
        label453:
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
  
  public static void md(String paramString1, String paramString2)
  {
    int i = 1;
    AppMethodBeat.i(206985);
    if (bs.getInt(com.tencent.mm.plugin.expt.e.b.cmk().b("clicfg_clean_expire_switch", "1", false, true), 1) > 0) {}
    while (i == 0)
    {
      b(paramString1, paramString2, 604800000L, 19);
      AppMethodBeat.o(206985);
      return;
      i = 0;
    }
    if (!zmI)
    {
      AppMethodBeat.o(206985);
      return;
    }
    paramString1 = aSy(paramString1);
    paramString2 = gp(aSy(paramString2), 51);
    CleanExpireFileSystem localCleanExpireFileSystem = new CleanExpireFileSystem(b(paramString1, paramString2, 51));
    localCleanExpireFileSystem.a(paramString1, n.fxY());
    a(paramString1, localCleanExpireFileSystem, paramString2, 51);
    AppMethodBeat.o(206985);
  }
  
  public static void yp(boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(133521);
      ac.i("VFS.VFSStrategy", "Account ready.");
      Juj = true;
      if ((zmI) && (Juk))
      {
        ac.i("VFS.VFSStrategy", "Broadcasting enabled.");
        a locala = a.ghk();
        locala.Kjc = true;
        locala.ghn();
        if (paramBoolean) {
          locala.ax(420000L, 86400000L);
        }
      }
      AppMethodBeat.o(133521);
      return;
    }
    finally {}
  }
  
  static final class a
    implements a.b
  {
    public final Key P(String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(176878);
      if (paramMap.get("account") == null)
      {
        AppMethodBeat.o(176878);
        return null;
      }
      ac.i("VFS.Debug", "KeyGen.generate: ".concat(String.valueOf(paramString)));
      if (((h)com.tencent.mm.kernel.g.agO().agp()).ahL()) {
        com.tencent.mm.kernel.g.agP();
      }
      for (paramMap = com.tencent.mm.kernel.a.afE();; paramMap = new com.tencent.mm.b.p(com.tencent.mm.kernel.a.agb()).toString())
      {
        paramString = new SecretKeySpec(com.tencent.mm.b.g.C((paramMap + paramString).getBytes()), "RC4");
        AppMethodBeat.o(176878);
        return paramString;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.o
 * JD-Core Version:    0.7.0.1
 */