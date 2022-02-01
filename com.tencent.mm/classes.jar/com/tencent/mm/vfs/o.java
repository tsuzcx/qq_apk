package com.tencent.mm.vfs;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.graphics.MMBitmapFactory.b;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor;
import com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.File;
import java.io.InputStream;
import java.security.Key;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import javax.crypto.spec.SecretKeySpec;

public final class o
{
  private static volatile boolean AEC;
  private static final a LlP;
  private static boolean LlQ;
  private static volatile boolean LlR;
  private static volatile boolean LlS;
  private static final HashSet<String> LlT;
  private static volatile String LlU;
  private static String LlV;
  private static String LlW;
  private static String LlX;
  
  static
  {
    AppMethodBeat.i(176883);
    LlP = new a((byte)0);
    LlQ = false;
    LlR = false;
    LlS = false;
    HashSet localHashSet = new HashSet();
    LlT = localHashSet;
    localHashSet.add("attachment");
    LlT.add("Download");
    LlT.add("voice");
    LlT.add("voice2");
    LlT.add("image");
    LlT.add("image2");
    LlT.add("oldimage2");
    LlT.add("video");
    LlT.add("emoji");
    LlT.add("oneday");
    LlT.add("finder");
    LlT.add("sns_ad_landingpages");
    LlU = "";
    LlV = null;
    LlW = null;
    LlX = null;
    AppMethodBeat.o(176883);
  }
  
  private static a.a a(a.a parama)
  {
    try
    {
      AppMethodBeat.i(185096);
      if (LlV != null)
      {
        parama.aYk("camera-path-remapfs");
        parama.aYl(LlV);
      }
      if ((LlW != null) || (LlX != null))
      {
        parama.aYk("sdcard-path-remapfs");
        if (LlW != null) {
          parama.aYl(LlW);
        }
        if (LlX != null) {
          parama.aYl(LlX);
        }
      }
      String str1 = b.asf();
      String str2 = b.arQ() + "/MicroMsg/";
      String str3 = b.arT();
      ExtStorageMigrateMonitor.fjf().i("VFS.VFSStrategy", "[+] updateMigratePathRemappings, lastMountNewCameraPath: %s, lastMountNewSDCardPath: %s, lastMountOldSDCardPath: %s, newCameraPath: %s, newSDCardPath: %s, oldSDCardPath: %s", new Object[] { LlV, LlW, LlX, str1, str2, str3 });
      if (b.asf().equals(b.ase()))
      {
        ExtStorageMigrateMonitor.fjf().e("VFS.VFSStrategy", "[-] Fail to get new camera path, and we use old camera path for fallback.", new Object[0]);
        if (aj.cmR()) {
          ExtStorageMigrateMonitor.CQ(142L);
        }
      }
      LlV = str1;
      LlW = str2;
      LlX = str3;
      parama.a("sdcard-path-remapfs", new MigrationFileSystem(new NativeFileSystem(str2), new FileSystem[] { new NativeFileSystem(str3) })).a("camera-path-remapfs", new MigrationFileSystem(new NativeFileSystem(str1), new FileSystem[] { new NativeFileSystem(str3 + "WeChat/"), new NativeFileSystem(str3 + "WeiXin/") })).mv(str2, "sdcard-path-remapfs").mv(str1, "camera-path-remapfs").mv(str3, "sdcard-path-remapfs").mv(str3 + "WeChat/", "camera-path-remapfs").mv(str3 + "WeiXin/", "camera-path-remapfs");
      AppMethodBeat.o(185096);
      return parama;
    }
    finally {}
  }
  
  public static a.a a(a.a parama, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(133524);
    ad.i("VFS.VFSStrategy", "Update account migration: sysPath = " + paramString + ", useSaltPath = " + paramBoolean);
    String str = LlU;
    if (paramBoolean)
    {
      if (b.arO().equals(b.arP())) {}
      for (MigrationFileSystem localMigrationFileSystem = new MigrationFileSystem("${sdFrom}", "${sdFrom}", new NativeFileSystem(paramString + "${accountSalt}"), new FileSystem[] { new NativeFileSystem(paramString + "${account}") });; localMigrationFileSystem = new MigrationFileSystem("${sdFrom}", "${sdFrom}", new NativeFileSystem(paramString + "${accountSalt}"), new FileSystem[] { new NativeFileSystem(paramString + "${account}"), new NativeFileSystem(b.arT() + "${accountSalt}"), new NativeFileSystem(b.arT() + "${account}") }))
      {
        LlU = paramString;
        parama = parama.a("accPathMigration", localMigrationFileSystem).aYl(str + "${accountSalt}").aYl(str + "${account}").mv(paramString + "${accountSalt}", "accPathMigration").mv(paramString + "${account}", "accPathMigration");
        AppMethodBeat.o(133524);
        return parama;
      }
    }
    LlU = "";
    parama = parama.aYk("accPathMigration").aYl(str + "${accountSalt}").aYl(str + "${account}");
    AppMethodBeat.o(133524);
    return parama;
  }
  
  public static a.a a(a.a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(133523);
    Object localObject = aj.getContext();
    ad.i("VFS.VFSStrategy", "Update SDCard status: isSDCardAvailAndSysPathOk = ".concat(String.valueOf(paramBoolean1)));
    if (paramBoolean1)
    {
      String str1 = b.arP() + "/tencent";
      String str2 = b.arQ();
      localObject = ((Context)localObject).getExternalCacheDir();
      if (!paramBoolean2)
      {
        ad.w("VFS.VFSStrategy", "do not use external private storage.");
        localObject = null;
      }
      a.a locala = parama.mw("sdFrom", str1);
      if (localObject == null)
      {
        parama = str1;
        locala = locala.mw("sdTo", parama);
        if (localObject != null) {
          break label161;
        }
      }
      label161:
      for (parama = str1 + "/MicroMsg";; parama = ((File)localObject).getPath())
      {
        parama = locala.mw("sdToCache", parama).mw("extSDFrom", str2);
        AppMethodBeat.o(133523);
        return parama;
        parama = ((File)localObject).getParent();
        break;
      }
    }
    localObject = ((Context)localObject).getCacheDir();
    parama = parama.aYm("sdFrom").aYm("extSDFrom").mw("sdTo", ((File)localObject).getParent()).mw("sdToCache", ((File)localObject).getPath());
    AppMethodBeat.o(133523);
    return parama;
  }
  
  private static void a(String paramString, FileSystem paramFileSystem, String[] paramArrayOfString, int paramInt)
  {
    AppMethodBeat.i(189956);
    paramFileSystem = a.gzU().gzW().a(paramString, paramFileSystem);
    if ((paramInt & 0x200) == 0)
    {
      int i = paramArrayOfString.length;
      paramInt = 0;
      while (paramInt < i)
      {
        paramFileSystem.mv(paramArrayOfString[paramInt], paramString);
        paramInt += 1;
      }
    }
    paramFileSystem.commit();
    AppMethodBeat.o(189956);
  }
  
  public static void a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    AppMethodBeat.i(133512);
    if (!AEC)
    {
      AppMethodBeat.o(133512);
      return;
    }
    if (aYw(paramString1)) {
      p.fPs();
    }
    paramString1 = aYx(paramString1);
    paramString2 = gM(aYx(paramString2), paramInt);
    QuotaFileSystem localQuotaFileSystem = new QuotaFileSystem(b(paramString1, paramString2, paramInt), paramLong / 2L, paramLong);
    localQuotaFileSystem.a(paramString1, n.fON());
    a(paramString1, localQuotaFileSystem, paramString2, paramInt);
    AppMethodBeat.o(133512);
  }
  
  private static boolean aYw(String paramString)
  {
    AppMethodBeat.i(189951);
    ad.i("VFS.VFSStrategy", "isVFSSecondPhase: %s, %s", new Object[] { paramString, Boolean.valueOf(LlT.contains(paramString)) });
    boolean bool = LlT.contains(paramString);
    AppMethodBeat.o(189951);
    return bool;
  }
  
  private static String aYx(String paramString)
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
  
  public static void afU(int paramInt)
  {
    AppMethodBeat.i(133522);
    com.tencent.mm.sdk.b.a.IbL.b(new c() {});
    AppMethodBeat.o(133522);
  }
  
  public static void an(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(133511);
    if (!AEC)
    {
      AppMethodBeat.o(133511);
      return;
    }
    if (aYw(paramString1)) {
      p.fPs();
    }
    paramString1 = aYx(paramString1);
    paramString2 = gM(aYx(paramString2), paramInt);
    AbstractFileSystem localAbstractFileSystem = b(paramString1, paramString2, paramInt);
    localAbstractFileSystem.a(paramString1, n.fON());
    a(paramString1, localAbstractFileSystem, paramString2, paramInt);
    AppMethodBeat.o(133511);
  }
  
  private static AbstractFileSystem ao(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(189954);
    paramString2 = new NativeFileSystem(paramString2);
    if ((paramInt & 0x8) == 0)
    {
      AppMethodBeat.o(189954);
      return paramString2;
    }
    paramString1 = new RC4EncryptedFileSystem(paramString2, paramString1);
    AppMethodBeat.o(189954);
    return paramString1;
  }
  
  private static AbstractFileSystem b(String paramString, String[] paramArrayOfString, int paramInt)
  {
    AppMethodBeat.i(189955);
    if ((paramArrayOfString.length == 1) || ((paramInt & 0x40) != 0))
    {
      paramString = ao(paramString, paramArrayOfString[0], paramInt);
      AppMethodBeat.o(189955);
      return paramString;
    }
    FileSystem[] arrayOfFileSystem = new FileSystem[paramArrayOfString.length - 1];
    int i = 1;
    while (i < paramArrayOfString.length)
    {
      arrayOfFileSystem[(i - 1)] = ao(paramString, paramArrayOfString[i], paramInt);
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
      paramString = new MigrationFileSystem(str1, str2, str3, ao(paramString, paramArrayOfString[0], paramInt), arrayOfFileSystem);
      AppMethodBeat.o(189955);
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
    AppMethodBeat.i(189952);
    if (!AEC)
    {
      AppMethodBeat.o(189952);
      return;
    }
    if (aYw(paramString1)) {
      p.fPs();
    }
    paramString1 = aYx(paramString1);
    paramString2 = aYx(paramString2);
    paramInt |= 0x20;
    paramString2 = gM(paramString2, paramInt);
    ExpireFileSystem localExpireFileSystem = new ExpireFileSystem(b(paramString1, paramString2, paramInt), paramLong);
    localExpireFileSystem.a(paramString1, n.fON());
    a(paramString1, localExpireFileSystem, paramString2, paramInt);
    AppMethodBeat.o(189952);
  }
  
  /* Error */
  public static void f(com.tencent.mm.kernel.b.g paramg)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc_w 418
    //   8: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_0
    //   12: invokevirtual 423	com/tencent/mm/kernel/b/g:akw	()Z
    //   15: istore_2
    //   16: iload_2
    //   17: putstatic 304	com/tencent/mm/vfs/o:AEC	Z
    //   20: aload_0
    //   21: getfield 427	com/tencent/mm/kernel/b/g:ca	Landroid/app/Application;
    //   24: invokestatic 431	com/tencent/mm/vfs/a:setContext	(Landroid/content/Context;)V
    //   27: iload_2
    //   28: ifne +141 -> 169
    //   31: iload_1
    //   32: invokestatic 435	com/tencent/mm/vfs/a:AC	(Z)V
    //   35: getstatic 41	com/tencent/mm/vfs/o:LlP	Lcom/tencent/mm/vfs/o$a;
    //   38: invokestatic 438	com/tencent/mm/vfs/a:a	(Lcom/tencent/mm/vfs/a$b;)V
    //   41: invokestatic 140	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:fjf	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
    //   44: ldc 142
    //   46: new 118	java/lang/StringBuilder
    //   49: dup
    //   50: ldc_w 440
    //   53: invokespecial 202	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   56: iload_2
    //   57: invokevirtual 207	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   60: ldc_w 442
    //   63: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokestatic 313	com/tencent/mm/vfs/p:fPs	()Z
    //   69: invokevirtual 207	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   72: ldc_w 444
    //   75: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokestatic 313	com/tencent/mm/vfs/p:fPs	()Z
    //   81: invokevirtual 207	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   84: ldc_w 446
    //   87: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokestatic 449	com/tencent/mm/vfs/p:fPr	()Z
    //   93: invokevirtual 207	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   96: ldc_w 451
    //   99: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokestatic 454	com/tencent/mm/vfs/p:fPq	()Z
    //   105: invokevirtual 207	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   108: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: iconst_0
    //   112: anewarray 4	java/lang/Object
    //   115: invokeinterface 149 4 0
    //   120: invokestatic 457	com/tencent/mm/vfs/p:fPt	()Z
    //   123: ifeq +36 -> 159
    //   126: invokestatic 140	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:fjf	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
    //   129: ldc 142
    //   131: ldc_w 459
    //   134: iconst_1
    //   135: anewarray 4	java/lang/Object
    //   138: dup
    //   139: iconst_0
    //   140: invokestatic 122	com/tencent/mm/loader/j/b:arQ	()Ljava/lang/String;
    //   143: aastore
    //   144: invokeinterface 149 4 0
    //   149: invokestatic 462	com/tencent/mm/loader/j/b:asT	()V
    //   152: invokestatic 122	com/tencent/mm/loader/j/b:arQ	()Ljava/lang/String;
    //   155: iconst_1
    //   156: invokestatic 466	com/tencent/mm/loader/j/b:z	(Ljava/lang/String;Z)V
    //   159: ldc_w 418
    //   162: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   165: ldc 2
    //   167: monitorexit
    //   168: return
    //   169: iconst_0
    //   170: istore_1
    //   171: goto -140 -> 31
    //   174: astore_0
    //   175: ldc 2
    //   177: monitorexit
    //   178: aload_0
    //   179: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	paramg	com.tencent.mm.kernel.b.g
    //   1	170	1	bool1	boolean
    //   15	42	2	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   5	27	174	finally
    //   31	159	174	finally
    //   159	165	174	finally
  }
  
  public static void fPo()
  {
    try
    {
      AppMethodBeat.i(133520);
      ad.i("VFS.VFSStrategy", "Configuration done.");
      LlS = true;
      if ((AEC) && (LlR))
      {
        ad.i("VFS.VFSStrategy", "Broadcasting enabled.");
        a locala = a.gzU();
        locala.OfH = true;
        locala.gzX();
        if (e.abf()) {
          locala.aC(420000L, 86400000L);
        }
      }
      AppMethodBeat.o(133520);
      return;
    }
    finally {}
  }
  
  public static void fPp()
  {
    AppMethodBeat.i(185097);
    ExtStorageMigrateMonitor.fjf().i("VFS.VFSStrategy", "[+] updateSdCardPathOnDemand called.", new Object[0]);
    if (p.fPt())
    {
      ExtStorageMigrateMonitor.fjf().i("VFS.VFSStrategy", "[+] updateSdCardPathOnDemand, isPathRemapOpened, NEW_SDCARD_ROOT: %s", new Object[] { b.arQ() });
      b.asT();
      b.z(b.arQ(), true);
      if (aj.cmR()) {
        a(a.gzU().gzW()).commit();
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
    //   5: ldc_w 499
    //   8: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_0
    //   12: invokevirtual 423	com/tencent/mm/kernel/b/g:akw	()Z
    //   15: istore_2
    //   16: iload_2
    //   17: putstatic 304	com/tencent/mm/vfs/o:AEC	Z
    //   20: iconst_1
    //   21: putstatic 43	com/tencent/mm/vfs/o:LlQ	Z
    //   24: iload_2
    //   25: ifne +196 -> 221
    //   28: iload_1
    //   29: invokestatic 435	com/tencent/mm/vfs/a:AC	(Z)V
    //   32: getstatic 41	com/tencent/mm/vfs/o:LlP	Lcom/tencent/mm/vfs/o$a;
    //   35: invokestatic 438	com/tencent/mm/vfs/a:a	(Lcom/tencent/mm/vfs/a$b;)V
    //   38: iload_2
    //   39: ifeq +162 -> 201
    //   42: new 411	com/tencent/mm/vfs/ExpireFileSystem
    //   45: dup
    //   46: new 178	com/tencent/mm/vfs/NativeFileSystem
    //   49: dup
    //   50: ldc_w 501
    //   53: invokespecial 181	com/tencent/mm/vfs/NativeFileSystem:<init>	(Ljava/lang/String;)V
    //   56: ldc2_w 502
    //   59: invokespecial 414	com/tencent/mm/vfs/ExpireFileSystem:<init>	(Lcom/tencent/mm/vfs/FileSystem;J)V
    //   62: pop
    //   63: invokestatic 293	com/tencent/mm/vfs/a:gzU	()Lcom/tencent/mm/vfs/a;
    //   66: astore_0
    //   67: aload_0
    //   68: iconst_0
    //   69: putfield 475	com/tencent/mm/vfs/a:OfH	Z
    //   72: aload_0
    //   73: invokevirtual 297	com/tencent/mm/vfs/a:gzW	()Lcom/tencent/mm/vfs/a$a;
    //   76: astore_0
    //   77: aload_0
    //   78: getfield 507	com/tencent/mm/vfs/a$a:Lkg	Ljava/util/HashMap;
    //   81: invokevirtual 512	java/util/HashMap:clear	()V
    //   84: aload_0
    //   85: getfield 516	com/tencent/mm/vfs/a$a:Lkh	Ljava/util/TreeMap;
    //   88: invokevirtual 519	java/util/TreeMap:clear	()V
    //   91: aload_0
    //   92: getfield 522	com/tencent/mm/vfs/a$a:Lki	Ljava/util/HashMap;
    //   95: invokevirtual 512	java/util/HashMap:clear	()V
    //   98: aload_0
    //   99: aconst_null
    //   100: putfield 526	com/tencent/mm/vfs/a$a:Lkj	Lcom/tencent/mm/vfs/FileSystem;
    //   103: aload_0
    //   104: iconst_1
    //   105: putfield 529	com/tencent/mm/vfs/a$a:Lkk	Z
    //   108: aload_0
    //   109: ldc_w 531
    //   112: invokestatic 537	com/tencent/mm/vfs/AssetsSchemeResolver:fOo	()Lcom/tencent/mm/vfs/AssetsSchemeResolver;
    //   115: invokevirtual 540	com/tencent/mm/vfs/a$a:a	(Ljava/lang/String;Lcom/tencent/mm/vfs/SchemeResolver;)Lcom/tencent/mm/vfs/a$a;
    //   118: ldc_w 542
    //   121: invokestatic 548	com/tencent/mm/vfs/ContentsSchemeResolver:fOr	()Lcom/tencent/mm/vfs/ContentsSchemeResolver;
    //   124: invokevirtual 540	com/tencent/mm/vfs/a$a:a	(Ljava/lang/String;Lcom/tencent/mm/vfs/SchemeResolver;)Lcom/tencent/mm/vfs/a$a;
    //   127: ldc_w 550
    //   130: new 178	com/tencent/mm/vfs/NativeFileSystem
    //   133: dup
    //   134: ldc_w 552
    //   137: invokespecial 181	com/tencent/mm/vfs/NativeFileSystem:<init>	(Ljava/lang/String;)V
    //   140: invokevirtual 189	com/tencent/mm/vfs/a$a:a	(Ljava/lang/String;Lcom/tencent/mm/vfs/FileSystem;)Lcom/tencent/mm/vfs/a$a;
    //   143: ldc_w 554
    //   146: new 178	com/tencent/mm/vfs/NativeFileSystem
    //   149: dup
    //   150: ldc_w 556
    //   153: invokespecial 181	com/tencent/mm/vfs/NativeFileSystem:<init>	(Ljava/lang/String;)V
    //   156: invokevirtual 189	com/tencent/mm/vfs/a$a:a	(Ljava/lang/String;Lcom/tencent/mm/vfs/FileSystem;)Lcom/tencent/mm/vfs/a$a;
    //   159: ldc_w 552
    //   162: ldc_w 550
    //   165: invokevirtual 197	com/tencent/mm/vfs/a$a:mv	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/vfs/a$a;
    //   168: ldc_w 556
    //   171: ldc_w 554
    //   174: invokevirtual 197	com/tencent/mm/vfs/a$a:mv	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/vfs/a$a;
    //   177: astore_0
    //   178: invokestatic 457	com/tencent/mm/vfs/p:fPt	()Z
    //   181: ifeq +8 -> 189
    //   184: aload_0
    //   185: invokestatic 497	com/tencent/mm/vfs/o:a	(Lcom/tencent/mm/vfs/a$a;)Lcom/tencent/mm/vfs/a$a;
    //   188: pop
    //   189: aload_0
    //   190: invokestatic 483	com/tencent/mm/compatible/util/e:abf	()Z
    //   193: iconst_1
    //   194: invokestatic 558	com/tencent/mm/vfs/o:a	(Lcom/tencent/mm/vfs/a$a;ZZ)Lcom/tencent/mm/vfs/a$a;
    //   197: iconst_0
    //   198: invokevirtual 561	com/tencent/mm/vfs/a$a:za	(Z)V
    //   201: new 6	com/tencent/mm/vfs/o$1
    //   204: dup
    //   205: invokespecial 562	com/tencent/mm/vfs/o$1:<init>	()V
    //   208: invokestatic 568	com/tencent/mm/graphics/MMBitmapFactory:setStreamProvider	(Lcom/tencent/mm/graphics/MMBitmapFactory$b;)V
    //   211: ldc_w 499
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
  
  private static String[] gM(String paramString, int paramInt)
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
      if ((j != 0) && (p.fPt()))
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
      if ((j != 0) && (p.fPt()))
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
  
  public static void mD(String paramString1, String paramString2)
  {
    int i = 1;
    AppMethodBeat.i(189953);
    if (bt.getInt(com.tencent.mm.plugin.expt.h.d.crP().b("clicfg_clean_expire_switch", "1", false, true), 1) > 0) {}
    while (i == 0)
    {
      b(paramString1, paramString2, 604800000L, 19);
      AppMethodBeat.o(189953);
      return;
      i = 0;
    }
    if (!AEC)
    {
      AppMethodBeat.o(189953);
      return;
    }
    paramString1 = aYx(paramString1);
    paramString2 = gM(aYx(paramString2), 51);
    CleanExpireFileSystem localCleanExpireFileSystem = new CleanExpireFileSystem(b(paramString1, paramString2, 51));
    localCleanExpireFileSystem.a(paramString1, n.fON());
    a(paramString1, localCleanExpireFileSystem, paramString2, 51);
    AppMethodBeat.o(189953);
  }
  
  public static void zb(boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(133521);
      ad.i("VFS.VFSStrategy", "Account ready.");
      LlR = true;
      if ((AEC) && (LlS))
      {
        ad.i("VFS.VFSStrategy", "Broadcasting enabled.");
        a locala = a.gzU();
        locala.OfH = true;
        locala.gzX();
        if (paramBoolean) {
          locala.aC(420000L, 86400000L);
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
    public final Key R(String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(176878);
      if (paramMap.get("account") == null)
      {
        AppMethodBeat.o(176878);
        return null;
      }
      ad.i("VFS.Debug", "KeyGen.generate: ".concat(String.valueOf(paramString)));
      if (((h)com.tencent.mm.kernel.g.ajz().ajb()).akw()) {
        com.tencent.mm.kernel.g.ajA();
      }
      for (paramMap = com.tencent.mm.kernel.a.aiq();; paramMap = new com.tencent.mm.b.p(com.tencent.mm.kernel.a.aiN()).toString())
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