package com.tencent.mm.vfs;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.ci;
import com.tencent.mm.graphics.MMBitmapFactory.b;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor;
import com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.io.File;
import java.io.InputStream;
import java.security.Key;
import java.util.LinkedHashSet;
import java.util.Map;
import javax.crypto.spec.SecretKeySpec;

public final class o
{
  private static final a HTA;
  private static boolean HTB;
  private static volatile boolean HTC;
  private static volatile boolean HTD;
  private static volatile String HTE;
  private static String HTF;
  private static String HTG;
  private static String HTH;
  private static volatile boolean xZI;
  
  static
  {
    AppMethodBeat.i(176883);
    HTA = new a((byte)0);
    HTB = false;
    HTC = false;
    HTD = false;
    HTE = "";
    HTF = null;
    HTG = null;
    HTH = null;
    AppMethodBeat.o(176883);
  }
  
  private static a.a a(a.a parama)
  {
    try
    {
      AppMethodBeat.i(185096);
      if (HTF != null)
      {
        parama.aMJ("camera-path-remapfs");
        parama.aMK(HTF);
      }
      if ((HTG != null) || (HTH != null))
      {
        parama.aMJ("sdcard-path-remapfs");
        if (HTG != null) {
          parama.aMK(HTG);
        }
        if (HTH != null) {
          parama.aMK(HTH);
        }
      }
      String str1 = b.air();
      String str2 = b.aid() + "/MicroMsg/";
      String str3 = b.aig();
      ExtStorageMigrateMonitor.eEi().i("VFS.VFSStrategy", "[+] updateMigratePathRemappings, lastMountNewCameraPath: %s, lastMountNewSDCardPath: %s, lastMountOldSDCardPath: %s, newCameraPath: %s, newSDCardPath: %s, oldSDCardPath: %s", new Object[] { HTF, HTG, HTH, str1, str2, str3 });
      if (b.air().equals(b.aiq()))
      {
        ExtStorageMigrateMonitor.eEi().e("VFS.VFSStrategy", "[-] Fail to get new camera path, and we use old camera path for fallback.", new Object[0]);
        if (aj.cbe()) {
          ExtStorageMigrateMonitor.at(1315L, 142L);
        }
      }
      HTF = str1;
      HTG = str2;
      HTH = str3;
      parama.a("sdcard-path-remapfs", new MigrationFileSystem(new NativeFileSystem(str2), new FileSystem[] { new NativeFileSystem(str3) })).a("camera-path-remapfs", new MigrationFileSystem(new NativeFileSystem(str1), new FileSystem[] { new NativeFileSystem(str3 + "WeChat/"), new NativeFileSystem(str3 + "WeiXin/") })).ly(str2, "sdcard-path-remapfs").ly(str1, "camera-path-remapfs").ly(str3, "sdcard-path-remapfs").ly(str3 + "WeChat/", "camera-path-remapfs").ly(str3 + "WeiXin/", "camera-path-remapfs");
      AppMethodBeat.o(185096);
      return parama;
    }
    finally {}
  }
  
  public static a.a a(a.a parama, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(133524);
    ad.i("VFS.VFSStrategy", "Update account migration: sysPath = " + paramString + ", useSaltPath = " + paramBoolean);
    String str = HTE;
    if (paramBoolean)
    {
      if (b.aib().equals(b.aic())) {}
      for (MigrationFileSystem localMigrationFileSystem = new MigrationFileSystem("${sdFrom}", "${sdFrom}", new NativeFileSystem(paramString + "${accountSalt}"), new FileSystem[] { new NativeFileSystem(paramString + "${account}") });; localMigrationFileSystem = new MigrationFileSystem("${sdFrom}", "${sdFrom}", new NativeFileSystem(paramString + "${accountSalt}"), new FileSystem[] { new NativeFileSystem(paramString + "${account}"), new NativeFileSystem(b.aig() + "${accountSalt}"), new NativeFileSystem(b.aig() + "${account}") }))
      {
        HTE = paramString;
        parama = parama.a("accPathMigration", localMigrationFileSystem).aMK(str + "${accountSalt}").aMK(str + "${account}").ly(paramString + "${accountSalt}", "accPathMigration").ly(paramString + "${account}", "accPathMigration");
        AppMethodBeat.o(133524);
        return parama;
      }
    }
    HTE = "";
    parama = parama.aMJ("accPathMigration").aMK(str + "${accountSalt}").aMK(str + "${account}");
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
      String str1 = b.aic() + "/tencent";
      String str2 = b.aid();
      localObject = ((Context)localObject).getExternalCacheDir();
      if (!paramBoolean2)
      {
        ad.w("VFS.VFSStrategy", "do not use external private storage.");
        localObject = null;
      }
      a.a locala = parama.lz("sdFrom", str1);
      if (localObject == null)
      {
        parama = str1;
        locala = locala.lz("sdTo", parama);
        if (localObject != null) {
          break label156;
        }
      }
      label156:
      for (parama = str1 + "/MicroMsg";; parama = ((File)localObject).getPath())
      {
        parama = locala.lz("sdToCache", parama).lz("extSDFrom", str2);
        AppMethodBeat.o(133523);
        return parama;
        parama = ((File)localObject).getParent();
        break;
      }
    }
    localObject = ((Context)localObject).getCacheDir();
    parama = parama.aML("sdFrom").aML("extSDFrom").lz("sdTo", ((File)localObject).getParent()).lz("sdToCache", ((File)localObject).getPath());
    AppMethodBeat.o(133523);
    return parama;
  }
  
  private static void a(String paramString, FileSystem paramFileSystem, String[] paramArrayOfString, int paramInt)
  {
    AppMethodBeat.i(192929);
    paramFileSystem = a.gap().gar().a(paramString, paramFileSystem);
    if ((paramInt & 0x200) == 0)
    {
      int i = paramArrayOfString.length;
      paramInt = 0;
      while (paramInt < i)
      {
        paramFileSystem.ly(paramArrayOfString[paramInt], paramString);
        paramInt += 1;
      }
    }
    paramFileSystem.commit();
    AppMethodBeat.o(192929);
  }
  
  public static void a(String paramString1, String paramString2, long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(177561);
    if (!xZI)
    {
      AppMethodBeat.o(177561);
      return;
    }
    if ((!paramBoolean) && (!p.fil()))
    {
      AppMethodBeat.o(177561);
      return;
    }
    paramString1 = aMV(paramString1);
    paramString2 = gl(aMV(paramString2), paramInt);
    QuotaFileSystem localQuotaFileSystem = new QuotaFileSystem(b(paramString1, paramString2, paramInt), paramLong / 2L, paramLong);
    localQuotaFileSystem.a(paramString1, n.fhX());
    a(paramString1, localQuotaFileSystem, paramString2, paramInt);
    AppMethodBeat.o(177561);
  }
  
  private static String aMV(String paramString)
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
  
  public static void abe(int paramInt)
  {
    AppMethodBeat.i(133522);
    com.tencent.mm.sdk.b.a.ESL.b(new c() {});
    AppMethodBeat.o(133522);
  }
  
  private static AbstractFileSystem ai(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(192927);
    paramString2 = new NativeFileSystem(paramString2);
    if ((paramInt & 0x8) == 0)
    {
      AppMethodBeat.o(192927);
      return paramString2;
    }
    paramString1 = new RC4EncryptedFileSystem(paramString2, paramString1);
    AppMethodBeat.o(192927);
    return paramString1;
  }
  
  private static AbstractFileSystem b(String paramString, String[] paramArrayOfString, int paramInt)
  {
    AppMethodBeat.i(192928);
    if ((paramArrayOfString.length == 1) || ((paramInt & 0x40) != 0))
    {
      paramString = ai(paramString, paramArrayOfString[0], paramInt);
      AppMethodBeat.o(192928);
      return paramString;
    }
    FileSystem[] arrayOfFileSystem = new FileSystem[paramArrayOfString.length - 1];
    int i = 1;
    while (i < paramArrayOfString.length)
    {
      arrayOfFileSystem[(i - 1)] = ai(paramString, paramArrayOfString[i], paramInt);
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
      paramString = new MigrationFileSystem(str1, str2, str3, ai(paramString, paramArrayOfString[0], paramInt), arrayOfFileSystem);
      AppMethodBeat.o(192928);
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
  
  public static void b(String paramString1, String paramString2, long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(176881);
    if (!xZI)
    {
      AppMethodBeat.o(176881);
      return;
    }
    if ((!paramBoolean) && (!p.fil()))
    {
      AppMethodBeat.o(176881);
      return;
    }
    paramString1 = aMV(paramString1);
    paramString2 = aMV(paramString2);
    paramInt |= 0x20;
    paramString2 = gl(paramString2, paramInt);
    ExpireFileSystem localExpireFileSystem = new ExpireFileSystem(b(paramString1, paramString2, paramInt), paramLong);
    localExpireFileSystem.a(paramString1, n.fhX());
    a(paramString1, localExpireFileSystem, paramString2, paramInt);
    AppMethodBeat.o(176881);
  }
  
  /* Error */
  public static void f(com.tencent.mm.kernel.b.g paramg)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc_w 364
    //   8: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_0
    //   12: invokevirtual 369	com/tencent/mm/kernel/b/g:agu	()Z
    //   15: istore_2
    //   16: iload_2
    //   17: putstatic 271	com/tencent/mm/vfs/o:xZI	Z
    //   20: aload_0
    //   21: getfield 373	com/tencent/mm/kernel/b/g:ca	Landroid/app/Application;
    //   24: invokestatic 377	com/tencent/mm/vfs/a:setContext	(Landroid/content/Context;)V
    //   27: iload_2
    //   28: ifne +132 -> 160
    //   31: iload_1
    //   32: invokestatic 381	com/tencent/mm/vfs/a:zj	(Z)V
    //   35: getstatic 38	com/tencent/mm/vfs/o:HTA	Lcom/tencent/mm/vfs/o$a;
    //   38: invokestatic 384	com/tencent/mm/vfs/a:a	(Lcom/tencent/mm/vfs/a$b;)V
    //   41: ldc 106
    //   43: new 81	java/lang/StringBuilder
    //   46: dup
    //   47: ldc_w 386
    //   50: invokespecial 169	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   53: iload_2
    //   54: invokevirtual 174	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   57: ldc_w 388
    //   60: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokestatic 276	com/tencent/mm/vfs/p:fil	()Z
    //   66: invokevirtual 174	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   69: ldc_w 390
    //   72: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokestatic 393	com/tencent/mm/vfs/p:fij	()Z
    //   78: invokevirtual 174	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   81: ldc_w 395
    //   84: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokestatic 398	com/tencent/mm/vfs/p:fik	()Z
    //   90: invokevirtual 174	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   93: ldc_w 400
    //   96: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokestatic 403	com/tencent/mm/vfs/p:fii	()Z
    //   102: invokevirtual 174	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   105: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 179	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: invokestatic 406	com/tencent/mm/vfs/p:fim	()Z
    //   114: ifeq +36 -> 150
    //   117: invokestatic 104	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:eEi	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
    //   120: ldc 106
    //   122: ldc_w 408
    //   125: iconst_1
    //   126: anewarray 4	java/lang/Object
    //   129: dup
    //   130: iconst_0
    //   131: invokestatic 86	com/tencent/mm/loader/j/b:aid	()Ljava/lang/String;
    //   134: aastore
    //   135: invokeinterface 113 4 0
    //   140: invokestatic 411	com/tencent/mm/loader/j/b:aje	()V
    //   143: invokestatic 86	com/tencent/mm/loader/j/b:aid	()Ljava/lang/String;
    //   146: iconst_1
    //   147: invokestatic 415	com/tencent/mm/loader/j/b:y	(Ljava/lang/String;Z)V
    //   150: ldc_w 364
    //   153: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static void fig()
  {
    try
    {
      AppMethodBeat.i(133520);
      ad.i("VFS.VFSStrategy", "Configuration done.");
      HTD = true;
      if ((xZI) && (HTC))
      {
        ad.i("VFS.VFSStrategy", "Broadcasting enabled.");
        a locala = a.gap();
        locala.LDw = true;
        locala.gas();
        if (e.XG()) {
          locala.gat();
        }
      }
      AppMethodBeat.o(133520);
      return;
    }
    finally {}
  }
  
  public static void fih()
  {
    AppMethodBeat.i(185097);
    ExtStorageMigrateMonitor.eEi().i("VFS.VFSStrategy", "[+] updateSdCardPathOnDemand called.", new Object[0]);
    if (p.fim())
    {
      ExtStorageMigrateMonitor.eEi().i("VFS.VFSStrategy", "[+] updateSdCardPathOnDemand, isPathRemapOpened, NEW_SDCARD_ROOT: %s", new Object[] { b.aid() });
      b.aje();
      b.y(b.aid(), true);
      if (aj.cbe()) {
        a(a.gap().gar()).commit();
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
    //   5: ldc_w 443
    //   8: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_0
    //   12: invokevirtual 369	com/tencent/mm/kernel/b/g:agu	()Z
    //   15: istore_2
    //   16: iload_2
    //   17: putstatic 271	com/tencent/mm/vfs/o:xZI	Z
    //   20: iconst_1
    //   21: putstatic 40	com/tencent/mm/vfs/o:HTB	Z
    //   24: iload_2
    //   25: ifne +196 -> 221
    //   28: iload_1
    //   29: invokestatic 381	com/tencent/mm/vfs/a:zj	(Z)V
    //   32: getstatic 38	com/tencent/mm/vfs/o:HTA	Lcom/tencent/mm/vfs/o$a;
    //   35: invokestatic 384	com/tencent/mm/vfs/a:a	(Lcom/tencent/mm/vfs/a$b;)V
    //   38: iload_2
    //   39: ifeq +162 -> 201
    //   42: new 357	com/tencent/mm/vfs/ExpireFileSystem
    //   45: dup
    //   46: new 145	com/tencent/mm/vfs/NativeFileSystem
    //   49: dup
    //   50: ldc_w 445
    //   53: invokespecial 148	com/tencent/mm/vfs/NativeFileSystem:<init>	(Ljava/lang/String;)V
    //   56: ldc2_w 446
    //   59: invokespecial 360	com/tencent/mm/vfs/ExpireFileSystem:<init>	(Lcom/tencent/mm/vfs/FileSystem;J)V
    //   62: pop
    //   63: invokestatic 260	com/tencent/mm/vfs/a:gap	()Lcom/tencent/mm/vfs/a;
    //   66: astore_0
    //   67: aload_0
    //   68: iconst_0
    //   69: putfield 424	com/tencent/mm/vfs/a:LDw	Z
    //   72: aload_0
    //   73: invokevirtual 264	com/tencent/mm/vfs/a:gar	()Lcom/tencent/mm/vfs/a$a;
    //   76: astore_0
    //   77: aload_0
    //   78: getfield 451	com/tencent/mm/vfs/a$a:HRW	Ljava/util/HashMap;
    //   81: invokevirtual 456	java/util/HashMap:clear	()V
    //   84: aload_0
    //   85: getfield 460	com/tencent/mm/vfs/a$a:HRX	Ljava/util/TreeMap;
    //   88: invokevirtual 463	java/util/TreeMap:clear	()V
    //   91: aload_0
    //   92: getfield 466	com/tencent/mm/vfs/a$a:HRY	Ljava/util/HashMap;
    //   95: invokevirtual 456	java/util/HashMap:clear	()V
    //   98: aload_0
    //   99: aconst_null
    //   100: putfield 470	com/tencent/mm/vfs/a$a:HRZ	Lcom/tencent/mm/vfs/FileSystem;
    //   103: aload_0
    //   104: iconst_1
    //   105: putfield 473	com/tencent/mm/vfs/a$a:HSa	Z
    //   108: aload_0
    //   109: ldc_w 475
    //   112: invokestatic 481	com/tencent/mm/vfs/AssetsSchemeResolver:fhz	()Lcom/tencent/mm/vfs/AssetsSchemeResolver;
    //   115: invokevirtual 484	com/tencent/mm/vfs/a$a:a	(Ljava/lang/String;Lcom/tencent/mm/vfs/SchemeResolver;)Lcom/tencent/mm/vfs/a$a;
    //   118: ldc_w 486
    //   121: invokestatic 492	com/tencent/mm/vfs/ContentsSchemeResolver:fhC	()Lcom/tencent/mm/vfs/ContentsSchemeResolver;
    //   124: invokevirtual 484	com/tencent/mm/vfs/a$a:a	(Ljava/lang/String;Lcom/tencent/mm/vfs/SchemeResolver;)Lcom/tencent/mm/vfs/a$a;
    //   127: ldc_w 494
    //   130: new 145	com/tencent/mm/vfs/NativeFileSystem
    //   133: dup
    //   134: ldc_w 496
    //   137: invokespecial 148	com/tencent/mm/vfs/NativeFileSystem:<init>	(Ljava/lang/String;)V
    //   140: invokevirtual 156	com/tencent/mm/vfs/a$a:a	(Ljava/lang/String;Lcom/tencent/mm/vfs/FileSystem;)Lcom/tencent/mm/vfs/a$a;
    //   143: ldc_w 498
    //   146: new 145	com/tencent/mm/vfs/NativeFileSystem
    //   149: dup
    //   150: ldc_w 500
    //   153: invokespecial 148	com/tencent/mm/vfs/NativeFileSystem:<init>	(Ljava/lang/String;)V
    //   156: invokevirtual 156	com/tencent/mm/vfs/a$a:a	(Ljava/lang/String;Lcom/tencent/mm/vfs/FileSystem;)Lcom/tencent/mm/vfs/a$a;
    //   159: ldc_w 496
    //   162: ldc_w 494
    //   165: invokevirtual 164	com/tencent/mm/vfs/a$a:ly	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/vfs/a$a;
    //   168: ldc_w 500
    //   171: ldc_w 498
    //   174: invokevirtual 164	com/tencent/mm/vfs/a$a:ly	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/vfs/a$a;
    //   177: astore_0
    //   178: invokestatic 406	com/tencent/mm/vfs/p:fim	()Z
    //   181: ifeq +8 -> 189
    //   184: aload_0
    //   185: invokestatic 441	com/tencent/mm/vfs/o:a	(Lcom/tencent/mm/vfs/a$a;)Lcom/tencent/mm/vfs/a$a;
    //   188: pop
    //   189: aload_0
    //   190: invokestatic 432	com/tencent/mm/compatible/util/e:XG	()Z
    //   193: iconst_1
    //   194: invokestatic 502	com/tencent/mm/vfs/o:a	(Lcom/tencent/mm/vfs/a$a;ZZ)Lcom/tencent/mm/vfs/a$a;
    //   197: iconst_0
    //   198: invokevirtual 505	com/tencent/mm/vfs/a$a:xf	(Z)V
    //   201: new 6	com/tencent/mm/vfs/o$1
    //   204: dup
    //   205: invokespecial 506	com/tencent/mm/vfs/o$1:<init>	()V
    //   208: invokestatic 512	com/tencent/mm/graphics/MMBitmapFactory:setStreamProvider	(Lcom/tencent/mm/graphics/MMBitmapFactory$b;)V
    //   211: ldc_w 443
    //   214: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private static String[] gl(String paramString, int paramInt)
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
      if ((j != 0) && (p.fim()))
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
      if ((j != 0) && (p.fim()))
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
  
  public static void i(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(176879);
    if (!xZI)
    {
      AppMethodBeat.o(176879);
      return;
    }
    if ((!paramBoolean) && (!p.fil()))
    {
      AppMethodBeat.o(176879);
      return;
    }
    paramString1 = aMV(paramString1);
    paramString2 = gl(aMV(paramString2), paramInt);
    AbstractFileSystem localAbstractFileSystem = b(paramString1, paramString2, paramInt);
    localAbstractFileSystem.a(paramString1, n.fhX());
    a(paramString1, localAbstractFileSystem, paramString2, paramInt);
    AppMethodBeat.o(176879);
  }
  
  public static void xg(boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(133521);
      ad.i("VFS.VFSStrategy", "Account ready.");
      HTC = true;
      if ((xZI) && (HTD))
      {
        ad.i("VFS.VFSStrategy", "Broadcasting enabled.");
        a locala = a.gap();
        locala.LDw = true;
        locala.gas();
        if (paramBoolean) {
          locala.gat();
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
    public final Key O(String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(176878);
      if (paramMap.get("account") == null)
      {
        AppMethodBeat.o(176878);
        return null;
      }
      ad.i("VFS.Debug", "KeyGen.generate: ".concat(String.valueOf(paramString)));
      if (((h)com.tencent.mm.kernel.g.afy().aeZ()).agu()) {
        com.tencent.mm.kernel.g.afz();
      }
      for (paramMap = com.tencent.mm.kernel.a.aeo();; paramMap = new com.tencent.mm.b.p(com.tencent.mm.kernel.a.aeL()).toString())
      {
        paramString = new SecretKeySpec(com.tencent.mm.b.g.E((paramMap + paramString).getBytes()), "RC4");
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