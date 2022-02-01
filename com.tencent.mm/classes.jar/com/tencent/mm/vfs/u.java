package com.tencent.mm.vfs;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.graphics.MMBitmapFactory.b;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor;
import com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.File;
import java.io.InputStream;
import java.security.Key;
import java.util.LinkedHashSet;
import java.util.Map;
import javax.crypto.spec.SecretKeySpec;

public final class u
{
  private static volatile boolean AWf;
  private static volatile boolean LIA;
  private static volatile String LIB;
  private static String LIC;
  private static String LID;
  private static String LIE;
  private static final k LIF;
  private static final k LIG;
  private static final a LIx;
  private static boolean LIy;
  private static volatile boolean LIz;
  
  static
  {
    k localk1 = null;
    AppMethodBeat.i(176883);
    LIx = new a((byte)0);
    LIy = false;
    LIz = false;
    LIA = false;
    LIB = "";
    LIC = null;
    LID = null;
    LIE = null;
    LIF = new k(k.W(ak.getContext().getCacheDir()), "temp");
    k localk2 = k.W(ak.getContext().getExternalCacheDir());
    if (localk2 == null) {}
    for (;;)
    {
      LIG = localk1;
      AppMethodBeat.o(176883);
      return;
      localk1 = new k(localk2, "temp");
    }
  }
  
  private static e.a a(e.a parama)
  {
    try
    {
      AppMethodBeat.i(185096);
      if (LIC != null)
      {
        parama.aZJ("camera-path-remapfs");
        parama.aZK(LIC);
      }
      if ((LID != null) || (LIE != null))
      {
        parama.aZJ("sdcard-path-remapfs");
        if (LID != null) {
          parama.aZK(LID);
        }
        if (LIE != null) {
          parama.aZK(LIE);
        }
      }
      String str1 = b.asu();
      String str2 = b.asf() + "/MicroMsg/";
      String str3 = b.asi();
      ExtStorageMigrateMonitor.fmX().i("VFS.VFSStrategy", "[+] updateMigratePathRemappings, lastMountNewCameraPath: %s, lastMountNewSDCardPath: %s, lastMountOldSDCardPath: %s, newCameraPath: %s, newSDCardPath: %s, oldSDCardPath: %s", new Object[] { LIC, LID, LIE, str1, str2, str3 });
      if (b.asu().equals(b.ast()))
      {
        ExtStorageMigrateMonitor.fmX().e("VFS.VFSStrategy", "[-] Fail to get new camera path, and we use old camera path for fallback.", new Object[0]);
        if (ak.coh()) {
          ExtStorageMigrateMonitor.Do(142L);
        }
      }
      LIC = str1;
      LID = str2;
      LIE = str3;
      parama.a("sdcard-path-remapfs", new MigrationFileSystem(new NativeFileSystem(str2), new FileSystem[] { new NativeFileSystem(str3) })).a("camera-path-remapfs", new MigrationFileSystem(new NativeFileSystem(str1), new FileSystem[] { new NativeFileSystem(str3 + "WeChat/"), new NativeFileSystem(str3 + "WeiXin/") })).mB(str2, "sdcard-path-remapfs").mB(str1, "camera-path-remapfs").mB(str3, "sdcard-path-remapfs").mB(str3 + "WeChat/", "camera-path-remapfs").mB(str3 + "WeiXin/", "camera-path-remapfs");
      AppMethodBeat.o(185096);
      return parama;
    }
    finally {}
  }
  
  public static e.a a(e.a parama, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(133524);
    ae.i("VFS.VFSStrategy", "Update account migration: sysPath = " + paramString + ", useSaltPath = " + paramBoolean);
    String str = LIB;
    if (paramBoolean)
    {
      if (b.asd().equals(b.ase())) {}
      for (MigrationFileSystem localMigrationFileSystem = new MigrationFileSystem("${sdFrom}", "${sdFrom}", new NativeFileSystem(paramString + "${accountSalt}"), new FileSystem[] { new NativeFileSystem(paramString + "${account}") });; localMigrationFileSystem = new MigrationFileSystem("${sdFrom}", "${sdFrom}", new NativeFileSystem(paramString + "${accountSalt}"), new FileSystem[] { new NativeFileSystem(paramString + "${account}"), new NativeFileSystem(b.asi() + "${accountSalt}"), new NativeFileSystem(b.asi() + "${account}") }))
      {
        LIB = paramString;
        parama = parama.a("accPathMigration", localMigrationFileSystem).aZK(str + "${accountSalt}").aZK(str + "${account}").mB(paramString + "${accountSalt}", "accPathMigration").mB(paramString + "${account}", "accPathMigration");
        AppMethodBeat.o(133524);
        return parama;
      }
    }
    LIB = "";
    parama = parama.aZJ("accPathMigration").aZK(str + "${accountSalt}").aZK(str + "${account}");
    AppMethodBeat.o(133524);
    return parama;
  }
  
  public static e.a a(e.a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(133523);
    Object localObject = ak.getContext();
    ae.i("VFS.VFSStrategy", "Update SDCard status: isSDCardAvailAndSysPathOk = ".concat(String.valueOf(paramBoolean1)));
    if (paramBoolean1)
    {
      String str1 = b.ase() + "/tencent";
      String str2 = b.asf();
      localObject = ((Context)localObject).getExternalCacheDir();
      if (!paramBoolean2)
      {
        ae.w("VFS.VFSStrategy", "do not use external private storage.");
        localObject = null;
      }
      e.a locala = parama.mC("sdFrom", str1);
      if (localObject == null)
      {
        parama = str1;
        locala = locala.mC("sdTo", parama);
        if (localObject != null) {
          break label157;
        }
      }
      label157:
      for (parama = str1 + "/MicroMsg";; parama = ((File)localObject).getPath())
      {
        parama = locala.mC("sdToCache", parama).mC("extSDFrom", str2);
        AppMethodBeat.o(133523);
        return parama;
        parama = ((File)localObject).getParent();
        break;
      }
    }
    localObject = ((Context)localObject).getCacheDir();
    parama = parama.aZL("sdFrom").aZL("extSDFrom").mC("sdTo", ((File)localObject).getParent()).mC("sdToCache", ((File)localObject).getPath());
    AppMethodBeat.o(133523);
    return parama;
  }
  
  private static void a(String paramString, FileSystem paramFileSystem, String[] paramArrayOfString, int paramInt)
  {
    AppMethodBeat.i(193660);
    paramFileSystem = e.fSU().gEk().a(paramString, paramFileSystem);
    if ((paramInt & 0x200) == 0)
    {
      int i = paramArrayOfString.length;
      paramInt = 0;
      while (paramInt < i)
      {
        paramFileSystem.mB(paramArrayOfString[paramInt], paramString);
        paramInt += 1;
      }
    }
    paramFileSystem.commit();
    AppMethodBeat.o(193660);
  }
  
  public static void a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    AppMethodBeat.i(133512);
    if (!AWf)
    {
      AppMethodBeat.o(133512);
      return;
    }
    paramString1 = aZZ(paramString1);
    paramString2 = gV(aZZ(paramString2), paramInt);
    QuotaFileSystem localQuotaFileSystem = new QuotaFileSystem(b(paramString1, paramString2, paramInt), paramLong / 2L, paramLong);
    localQuotaFileSystem.a(paramString1, t.fTk());
    a(paramString1, localQuotaFileSystem, paramString2, paramInt);
    AppMethodBeat.o(133512);
  }
  
  private static String aZZ(String paramString)
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
  
  public static void agD(int paramInt)
  {
    AppMethodBeat.i(133522);
    com.tencent.mm.sdk.b.a.IvT.b(new c() {});
    AppMethodBeat.o(133522);
  }
  
  public static void ap(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(133511);
    if (!AWf)
    {
      AppMethodBeat.o(133511);
      return;
    }
    paramString1 = aZZ(paramString1);
    paramString2 = gV(aZZ(paramString2), paramInt);
    AbstractFileSystem localAbstractFileSystem = b(paramString1, paramString2, paramInt);
    localAbstractFileSystem.a(paramString1, t.fTk());
    a(paramString1, localAbstractFileSystem, paramString2, paramInt);
    AppMethodBeat.o(133511);
  }
  
  private static AbstractFileSystem aq(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(193658);
    paramString2 = new NativeFileSystem(paramString2);
    if ((paramInt & 0x8) == 0)
    {
      AppMethodBeat.o(193658);
      return paramString2;
    }
    paramString1 = new RC4EncryptedFileSystem(paramString2, paramString1);
    AppMethodBeat.o(193658);
    return paramString1;
  }
  
  private static AbstractFileSystem b(String paramString, String[] paramArrayOfString, int paramInt)
  {
    AppMethodBeat.i(193659);
    if ((paramArrayOfString.length == 1) || ((paramInt & 0x40) != 0))
    {
      paramString = aq(paramString, paramArrayOfString[0], paramInt);
      AppMethodBeat.o(193659);
      return paramString;
    }
    FileSystem[] arrayOfFileSystem = new FileSystem[paramArrayOfString.length - 1];
    int i = 1;
    while (i < paramArrayOfString.length)
    {
      arrayOfFileSystem[(i - 1)] = aq(paramString, paramArrayOfString[i], paramInt);
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
      paramString = new MigrationFileSystem(str1, str2, str3, aq(paramString, paramArrayOfString[0], paramInt), arrayOfFileSystem);
      AppMethodBeat.o(193659);
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
    AppMethodBeat.i(193656);
    if (!AWf)
    {
      AppMethodBeat.o(193656);
      return;
    }
    paramString1 = aZZ(paramString1);
    paramString2 = aZZ(paramString2);
    paramInt |= 0x20;
    paramString2 = gV(paramString2, paramInt);
    ExpireFileSystem localExpireFileSystem = new ExpireFileSystem(b(paramString1, paramString2, paramInt), paramLong);
    localExpireFileSystem.a(paramString1, t.fTk());
    a(paramString1, localExpireFileSystem, paramString2, paramInt);
    AppMethodBeat.o(193656);
  }
  
  public static void fTL()
  {
    try
    {
      AppMethodBeat.i(133520);
      ae.i("VFS.VFSStrategy", "Configuration done.");
      LIA = true;
      if ((AWf) && (LIz))
      {
        ae.i("VFS.VFSStrategy", "Broadcasting enabled.");
        e locale = e.fSU();
        locale.OAO = true;
        locale.gEl();
        if (com.tencent.mm.compatible.util.e.abo()) {
          locale.aB(420000L, 86400000L);
        }
      }
      AppMethodBeat.o(133520);
      return;
    }
    finally {}
  }
  
  public static void fTM()
  {
    AppMethodBeat.i(185097);
    ExtStorageMigrateMonitor.fmX().i("VFS.VFSStrategy", "[+] updateSdCardPathOnDemand called.", new Object[0]);
    if (v.fTQ())
    {
      ExtStorageMigrateMonitor.fmX().i("VFS.VFSStrategy", "[+] updateSdCardPathOnDemand, isPathRemapOpened, NEW_SDCARD_ROOT: %s", new Object[] { b.asf() });
      b.ati();
      b.z(b.asf(), true);
      if (ak.coh()) {
        a(e.fSU().gEk()).commit();
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
    //   5: ldc_w 426
    //   8: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_0
    //   12: invokevirtual 431	com/tencent/mm/kernel/b/g:akL	()Z
    //   15: istore_2
    //   16: iload_2
    //   17: putstatic 287	com/tencent/mm/vfs/u:AWf	Z
    //   20: aload_0
    //   21: getfield 435	com/tencent/mm/kernel/b/g:ca	Landroid/app/Application;
    //   24: invokestatic 439	com/tencent/mm/vfs/e:setContext	(Landroid/content/Context;)V
    //   27: iload_2
    //   28: ifne +141 -> 169
    //   31: iload_1
    //   32: invokestatic 443	com/tencent/mm/vfs/e:zn	(Z)V
    //   35: getstatic 41	com/tencent/mm/vfs/u:LIx	Lcom/tencent/mm/vfs/u$a;
    //   38: invokestatic 446	com/tencent/mm/vfs/e:a	(Lcom/tencent/mm/vfs/e$b;)V
    //   41: invokestatic 137	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:fmX	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
    //   44: ldc 139
    //   46: new 114	java/lang/StringBuilder
    //   49: dup
    //   50: ldc_w 448
    //   53: invokespecial 198	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   56: iload_2
    //   57: invokevirtual 203	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   60: ldc_w 450
    //   63: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokestatic 453	com/tencent/mm/vfs/v:fTP	()Z
    //   69: invokevirtual 203	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   72: ldc_w 455
    //   75: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokestatic 453	com/tencent/mm/vfs/v:fTP	()Z
    //   81: invokevirtual 203	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   84: ldc_w 457
    //   87: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokestatic 460	com/tencent/mm/vfs/v:fTO	()Z
    //   93: invokevirtual 203	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   96: ldc_w 462
    //   99: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokestatic 465	com/tencent/mm/vfs/v:fTN	()Z
    //   105: invokevirtual 203	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   108: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: iconst_0
    //   112: anewarray 4	java/lang/Object
    //   115: invokeinterface 146 4 0
    //   120: invokestatic 412	com/tencent/mm/vfs/v:fTQ	()Z
    //   123: ifeq +36 -> 159
    //   126: invokestatic 137	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:fmX	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
    //   129: ldc 139
    //   131: ldc_w 414
    //   134: iconst_1
    //   135: anewarray 4	java/lang/Object
    //   138: dup
    //   139: iconst_0
    //   140: invokestatic 119	com/tencent/mm/loader/j/b:asf	()Ljava/lang/String;
    //   143: aastore
    //   144: invokeinterface 146 4 0
    //   149: invokestatic 417	com/tencent/mm/loader/j/b:ati	()V
    //   152: invokestatic 119	com/tencent/mm/loader/j/b:asf	()Ljava/lang/String;
    //   155: iconst_1
    //   156: invokestatic 421	com/tencent/mm/loader/j/b:z	(Ljava/lang/String;Z)V
    //   159: ldc_w 426
    //   162: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private static String[] gV(String paramString, int paramInt)
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
      if ((j != 0) && (v.fTQ()))
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
      if ((j != 0) && (v.fTQ()))
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
  
  /* Error */
  public static void h(com.tencent.mm.kernel.b.g paramg)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc_w 505
    //   8: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_0
    //   12: invokevirtual 431	com/tencent/mm/kernel/b/g:akL	()Z
    //   15: istore_2
    //   16: iload_2
    //   17: putstatic 287	com/tencent/mm/vfs/u:AWf	Z
    //   20: iconst_1
    //   21: putstatic 43	com/tencent/mm/vfs/u:LIy	Z
    //   24: iload_2
    //   25: ifne +257 -> 282
    //   28: iload_1
    //   29: invokestatic 443	com/tencent/mm/vfs/e:zn	(Z)V
    //   32: getstatic 41	com/tencent/mm/vfs/u:LIx	Lcom/tencent/mm/vfs/u$a;
    //   35: invokestatic 446	com/tencent/mm/vfs/e:a	(Lcom/tencent/mm/vfs/e$b;)V
    //   38: iload_2
    //   39: ifeq +223 -> 262
    //   42: new 374	com/tencent/mm/vfs/ExpireFileSystem
    //   45: dup
    //   46: new 174	com/tencent/mm/vfs/NativeFileSystem
    //   49: dup
    //   50: ldc_w 507
    //   53: invokespecial 177	com/tencent/mm/vfs/NativeFileSystem:<init>	(Ljava/lang/String;)V
    //   56: ldc2_w 508
    //   59: invokespecial 377	com/tencent/mm/vfs/ExpireFileSystem:<init>	(Lcom/tencent/mm/vfs/FileSystem;J)V
    //   62: astore_0
    //   63: new 374	com/tencent/mm/vfs/ExpireFileSystem
    //   66: dup
    //   67: new 174	com/tencent/mm/vfs/NativeFileSystem
    //   70: dup
    //   71: ldc_w 511
    //   74: invokespecial 177	com/tencent/mm/vfs/NativeFileSystem:<init>	(Ljava/lang/String;)V
    //   77: ldc2_w 508
    //   80: invokespecial 377	com/tencent/mm/vfs/ExpireFileSystem:<init>	(Lcom/tencent/mm/vfs/FileSystem;J)V
    //   83: astore_3
    //   84: invokestatic 276	com/tencent/mm/vfs/e:fSU	()Lcom/tencent/mm/vfs/e;
    //   87: astore 4
    //   89: aload 4
    //   91: iconst_0
    //   92: putfield 387	com/tencent/mm/vfs/e:OAO	Z
    //   95: aload 4
    //   97: invokevirtual 280	com/tencent/mm/vfs/e:gEk	()Lcom/tencent/mm/vfs/e$a;
    //   100: astore 4
    //   102: aload 4
    //   104: getfield 515	com/tencent/mm/vfs/e$a:LGz	Ljava/util/HashMap;
    //   107: invokevirtual 520	java/util/HashMap:clear	()V
    //   110: aload 4
    //   112: getfield 524	com/tencent/mm/vfs/e$a:LGA	Ljava/util/TreeMap;
    //   115: invokevirtual 527	java/util/TreeMap:clear	()V
    //   118: aload 4
    //   120: getfield 530	com/tencent/mm/vfs/e$a:LGB	Ljava/util/HashMap;
    //   123: invokevirtual 520	java/util/HashMap:clear	()V
    //   126: aload 4
    //   128: aconst_null
    //   129: putfield 534	com/tencent/mm/vfs/e$a:LGC	Lcom/tencent/mm/vfs/d;
    //   132: aload 4
    //   134: iconst_1
    //   135: putfield 537	com/tencent/mm/vfs/e$a:LGD	Z
    //   138: aload 4
    //   140: ldc_w 539
    //   143: invokestatic 545	com/tencent/mm/vfs/AssetsSchemeResolver:fSJ	()Lcom/tencent/mm/vfs/AssetsSchemeResolver;
    //   146: invokevirtual 548	com/tencent/mm/vfs/e$a:a	(Ljava/lang/String;Lcom/tencent/mm/vfs/SchemeResolver;)Lcom/tencent/mm/vfs/e$a;
    //   149: ldc_w 550
    //   152: invokestatic 556	com/tencent/mm/vfs/ContentsSchemeResolver:fSN	()Lcom/tencent/mm/vfs/SchemeResolver;
    //   155: invokevirtual 548	com/tencent/mm/vfs/e$a:a	(Ljava/lang/String;Lcom/tencent/mm/vfs/SchemeResolver;)Lcom/tencent/mm/vfs/e$a;
    //   158: ldc_w 558
    //   161: new 174	com/tencent/mm/vfs/NativeFileSystem
    //   164: dup
    //   165: ldc_w 560
    //   168: invokespecial 177	com/tencent/mm/vfs/NativeFileSystem:<init>	(Ljava/lang/String;)V
    //   171: invokevirtual 185	com/tencent/mm/vfs/e$a:a	(Ljava/lang/String;Lcom/tencent/mm/vfs/FileSystem;)Lcom/tencent/mm/vfs/e$a;
    //   174: ldc_w 562
    //   177: new 174	com/tencent/mm/vfs/NativeFileSystem
    //   180: dup
    //   181: ldc_w 564
    //   184: invokespecial 177	com/tencent/mm/vfs/NativeFileSystem:<init>	(Ljava/lang/String;)V
    //   187: invokevirtual 185	com/tencent/mm/vfs/e$a:a	(Ljava/lang/String;Lcom/tencent/mm/vfs/FileSystem;)Lcom/tencent/mm/vfs/e$a;
    //   190: ldc 77
    //   192: aload_0
    //   193: invokevirtual 185	com/tencent/mm/vfs/e$a:a	(Ljava/lang/String;Lcom/tencent/mm/vfs/FileSystem;)Lcom/tencent/mm/vfs/e$a;
    //   196: ldc_w 566
    //   199: aload_3
    //   200: invokevirtual 185	com/tencent/mm/vfs/e$a:a	(Ljava/lang/String;Lcom/tencent/mm/vfs/FileSystem;)Lcom/tencent/mm/vfs/e$a;
    //   203: ldc_w 560
    //   206: ldc_w 558
    //   209: invokevirtual 193	com/tencent/mm/vfs/e$a:mB	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/vfs/e$a;
    //   212: ldc_w 564
    //   215: ldc_w 562
    //   218: invokevirtual 193	com/tencent/mm/vfs/e$a:mB	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/vfs/e$a;
    //   221: ldc_w 507
    //   224: ldc 77
    //   226: invokevirtual 193	com/tencent/mm/vfs/e$a:mB	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/vfs/e$a;
    //   229: ldc_w 511
    //   232: ldc_w 566
    //   235: invokevirtual 193	com/tencent/mm/vfs/e$a:mB	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/vfs/e$a;
    //   238: astore_0
    //   239: invokestatic 412	com/tencent/mm/vfs/v:fTQ	()Z
    //   242: ifeq +8 -> 250
    //   245: aload_0
    //   246: invokestatic 423	com/tencent/mm/vfs/u:a	(Lcom/tencent/mm/vfs/e$a;)Lcom/tencent/mm/vfs/e$a;
    //   249: pop
    //   250: aload_0
    //   251: invokestatic 395	com/tencent/mm/compatible/util/e:abo	()Z
    //   254: iconst_1
    //   255: invokestatic 568	com/tencent/mm/vfs/u:a	(Lcom/tencent/mm/vfs/e$a;ZZ)Lcom/tencent/mm/vfs/e$a;
    //   258: iconst_0
    //   259: invokevirtual 571	com/tencent/mm/vfs/e$a:zo	(Z)V
    //   262: new 6	com/tencent/mm/vfs/u$1
    //   265: dup
    //   266: invokespecial 572	com/tencent/mm/vfs/u$1:<init>	()V
    //   269: invokestatic 578	com/tencent/mm/graphics/MMBitmapFactory:setStreamProvider	(Lcom/tencent/mm/graphics/MMBitmapFactory$b;)V
    //   272: ldc_w 505
    //   275: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   278: ldc 2
    //   280: monitorexit
    //   281: return
    //   282: iconst_0
    //   283: istore_1
    //   284: goto -256 -> 28
    //   287: astore_0
    //   288: ldc 2
    //   290: monitorexit
    //   291: aload_0
    //   292: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	paramg	com.tencent.mm.kernel.b.g
    //   1	283	1	bool1	boolean
    //   15	24	2	bool2	boolean
    //   83	117	3	localExpireFileSystem	ExpireFileSystem
    //   87	52	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	24	287	finally
    //   28	38	287	finally
    //   42	250	287	finally
    //   250	262	287	finally
    //   262	278	287	finally
  }
  
  public static void mJ(String paramString1, String paramString2)
  {
    int i = 1;
    AppMethodBeat.i(193657);
    if (bu.getInt(com.tencent.mm.plugin.expt.h.d.ctr().b("clicfg_clean_expire_switch", "1", false, true), 1) > 0) {}
    while (i == 0)
    {
      b(paramString1, paramString2, 604800000L, 19);
      AppMethodBeat.o(193657);
      return;
      i = 0;
    }
    if (!AWf)
    {
      AppMethodBeat.o(193657);
      return;
    }
    paramString1 = aZZ(paramString1);
    paramString2 = gV(aZZ(paramString2), 51);
    CleanExpireFileSystem localCleanExpireFileSystem = new CleanExpireFileSystem(b(paramString1, paramString2, 51));
    localCleanExpireFileSystem.a(paramString1, t.fTk());
    a(paramString1, localCleanExpireFileSystem, paramString2, 51);
    AppMethodBeat.o(193657);
  }
  
  public static void zp(boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(133521);
      ae.i("VFS.VFSStrategy", "Account ready.");
      LIz = true;
      if ((AWf) && (LIA))
      {
        ae.i("VFS.VFSStrategy", "Broadcasting enabled.");
        e locale = e.fSU();
        locale.OAO = true;
        locale.gEl();
        if (paramBoolean) {
          locale.aB(420000L, 86400000L);
        }
      }
      AppMethodBeat.o(133521);
      return;
    }
    finally {}
  }
  
  static final class a
    implements e.b
  {
    public final Key S(String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(176878);
      if (paramMap.get("account") == null)
      {
        AppMethodBeat.o(176878);
        return null;
      }
      ae.i("VFS.Debug", "KeyGen.generate: ".concat(String.valueOf(paramString)));
      if (((h)com.tencent.mm.kernel.g.ajO().ajq()).akL()) {
        com.tencent.mm.kernel.g.ajP();
      }
      for (paramMap = com.tencent.mm.kernel.a.aiF();; paramMap = new p(com.tencent.mm.kernel.a.ajc()).toString())
      {
        paramString = new SecretKeySpec(com.tencent.mm.b.g.C((paramMap + paramString).getBytes()), "RC4");
        AppMethodBeat.o(176878);
        return paramString;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.u
 * JD-Core Version:    0.7.0.1
 */