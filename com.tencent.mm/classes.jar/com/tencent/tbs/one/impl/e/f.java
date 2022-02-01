package com.tencent.tbs.one.impl.e;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.a.c;
import com.tencent.tbs.one.impl.a.i;
import com.tencent.tbs.one.impl.a.j;
import com.tencent.tbs.one.impl.a.k;
import com.tencent.tbs.one.impl.a.k.a;
import com.tencent.tbs.one.impl.common.b;
import com.tencent.tbs.one.impl.common.d.a;
import com.tencent.tbs.one.impl.common.e;
import com.tencent.tbs.one.impl.common.e.a;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public final class f
{
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(173989);
    paramInt1 = Math.min(Math.max(0, paramInt1), 100);
    float f = paramInt2;
    paramInt1 = (int)(paramInt1 / 100.0F * (paramInt3 - paramInt2) + f);
    AppMethodBeat.o(173989);
    return paramInt1;
  }
  
  private static int a(com.tencent.tbs.one.impl.common.d paramd, String paramString)
  {
    AppMethodBeat.i(173988);
    if (paramd != null)
    {
      paramd = paramd.b(paramString);
      if (paramd != null)
      {
        int i = paramd.c;
        AppMethodBeat.o(173988);
        return i;
      }
    }
    AppMethodBeat.o(173988);
    return -1;
  }
  
  private static String a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(173979);
    paramString1 = paramString1.substring(paramString2.length(), paramString1.length() - 3);
    AppMethodBeat.o(173979);
    return paramString1;
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(192426);
    int k = paramArrayOfByte.length;
    char[] arrayOfChar = new char[k * 2];
    int i = 0;
    if (i < k)
    {
      int m = paramArrayOfByte[i];
      int j = m >> 4 & 0xF;
      if (j >= 10)
      {
        j = j + 97 - 10;
        label49:
        arrayOfChar[(i * 2)] = ((char)j);
        j = m & 0xF;
        if (j < 10) {
          break label102;
        }
        j = j + 97 - 10;
      }
      for (;;)
      {
        arrayOfChar[(i * 2 + 1)] = ((char)j);
        i += 1;
        break;
        j += 48;
        break label49;
        label102:
        j += 48;
      }
    }
    paramArrayOfByte = new String(arrayOfChar);
    AppMethodBeat.o(192426);
    return paramArrayOfByte;
  }
  
  public static MessageDigest a()
  {
    AppMethodBeat.i(173981);
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      AppMethodBeat.o(173981);
      return localMessageDigest;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      TBSOneException localTBSOneException = new TBSOneException(106, "Failed to find md5 algorithm", localNoSuchAlgorithmException);
      AppMethodBeat.o(173981);
      throw localTBSOneException;
    }
  }
  
  public static void a(Context paramContext)
  {
    AppMethodBeat.i(173986);
    com.tencent.tbs.one.impl.a.f.a("Cleaning Proc directory", new Object[0]);
    File[] arrayOfFile = com.tencent.tbs.one.impl.common.f.b(paramContext).listFiles();
    if (arrayOfFile == null)
    {
      AppMethodBeat.o(173986);
      return;
    }
    int k = Process.myPid();
    if ((arrayOfFile.length == 1) && (arrayOfFile[0].getName().equals(String.valueOf(k))))
    {
      AppMethodBeat.o(173986);
      return;
    }
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    if (paramContext == null) {}
    for (paramContext = null; paramContext == null; paramContext = paramContext.getRunningAppProcesses())
    {
      AppMethodBeat.o(173986);
      return;
    }
    int m = arrayOfFile.length;
    int j = 0;
    File localFile;
    int i;
    if (j < m)
    {
      localFile = arrayOfFile[j];
      int n = Integer.valueOf(localFile.getName()).intValue();
      if (n != k)
      {
        Iterator localIterator = paramContext.iterator();
        i = 0;
        label150:
        if (localIterator.hasNext())
        {
          if (((ActivityManager.RunningAppProcessInfo)localIterator.next()).pid != n) {
            break label206;
          }
          i = 1;
        }
      }
    }
    label206:
    for (;;)
    {
      break label150;
      if (i == 0) {
        c.a(localFile);
      }
      j += 1;
      break;
      AppMethodBeat.o(173986);
      return;
    }
  }
  
  public static void a(File paramFile)
  {
    AppMethodBeat.i(192417);
    paramFile = paramFile.listFiles();
    int j = paramFile.length;
    int i = 0;
    while (i < j)
    {
      File localFile = paramFile[i];
      if (localFile.isDirectory())
      {
        localFile.setExecutable(true, false);
        a(localFile);
      }
      i += 1;
    }
    AppMethodBeat.o(192417);
  }
  
  public static void a(File paramFile, int paramInt)
  {
    AppMethodBeat.i(173983);
    Object localObject1 = e.a(new File(paramFile, "MANIFEST"));
    int i = ((e)localObject1).a;
    if (paramInt != i)
    {
      paramFile = new TBSOneException(417, "Failed to verify version code, expected " + paramInt + " but was " + i);
      AppMethodBeat.o(173983);
      throw paramFile;
    }
    e.a[] arrayOfa = ((e)localObject1).e;
    if (arrayOfa != null)
    {
      localObject1 = null;
      i = arrayOfa.length;
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = arrayOfa[paramInt];
        File localFile = new File(paramFile, ((e.a)localObject2).a);
        if (!localFile.exists())
        {
          paramFile = new TBSOneException(105, "Failed to find component file " + localFile.getAbsolutePath());
          AppMethodBeat.o(173983);
          throw paramFile;
        }
        String str = ((e.a)localObject2).b;
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(str))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = a();
          }
          a((MessageDigest)localObject2, localFile, str);
        }
        paramInt += 1;
        localObject1 = localObject2;
      }
    }
    AppMethodBeat.o(173983);
  }
  
  public static void a(File paramFile, long paramLong)
  {
    AppMethodBeat.i(173994);
    paramFile = com.tencent.tbs.one.impl.common.f.e(paramFile, ".failed");
    try
    {
      if ((paramFile.exists()) || (paramFile.createNewFile()))
      {
        if (!paramFile.setLastModified(paramLong))
        {
          com.tencent.tbs.one.impl.a.f.c("Failed to touch file %s, cannot set last modified with %d", new Object[] { paramFile.getAbsolutePath(), Long.valueOf(paramLong) });
          AppMethodBeat.o(173994);
        }
      }
      else {
        com.tencent.tbs.one.impl.a.f.c("Failed to touch file %s, cannot create new file", new Object[] { paramFile.getAbsolutePath() });
      }
      AppMethodBeat.o(173994);
      return;
    }
    catch (IOException localIOException)
    {
      com.tencent.tbs.one.impl.a.f.c("Failed to touch file %s", new Object[] { paramFile.getAbsolutePath(), localIOException });
      AppMethodBeat.o(173994);
    }
  }
  
  public static void a(File paramFile1, File paramFile2)
  {
    AppMethodBeat.i(173980);
    com.tencent.tbs.one.impl.a.f.a("Extracting from installation package %s to %s", new Object[] { paramFile1.getAbsolutePath(), paramFile2.getAbsolutePath() });
    File localFile1 = new File(paramFile1, "jni");
    String[] arrayOfString;
    int j;
    int m;
    int i;
    if (Build.VERSION.SDK_INT < 21)
    {
      arrayOfString = new String[2];
      arrayOfString[0] = Build.CPU_ABI;
      arrayOfString[1] = Build.CPU_ABI2;
      j = 1;
      m = arrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      if (i >= m) {
        break label418;
      }
      Object localObject1 = arrayOfString[i];
      Object localObject2 = new File(localFile1, (String)localObject1);
      int k = j;
      if (((File)localObject2).exists())
      {
        File[] arrayOfFile = ((File)localObject2).listFiles();
        k = j;
        if (arrayOfFile != null)
        {
          k = j;
          if (arrayOfFile.length > 0)
          {
            com.tencent.tbs.one.impl.a.f.a("  ABI: %s", new Object[] { localObject1 });
            k = arrayOfFile.length;
            j = 0;
            label162:
            if (j < k)
            {
              File localFile2 = arrayOfFile[j];
              localObject2 = localFile2.getName();
              Object localObject3;
              if (((String)localObject2).startsWith("libtbs="))
              {
                localObject3 = new String(Base64.decode(a((String)localObject2, "libtbs="), 2), b.a);
                localObject1 = localObject3;
                if (((String)localObject3).contains(File.separator)) {
                  localObject1 = ((String)localObject3).substring(((String)localObject3).indexOf(File.separatorChar) + 1);
                }
                label248:
                localObject3 = new File(paramFile2, (String)localObject1);
                if (!((File)localObject3).exists()) {
                  break label334;
                }
                com.tencent.tbs.one.impl.a.f.a("    %s -> %s, already exist", new Object[] { localObject2, localObject1 });
              }
              for (;;)
              {
                j += 1;
                break label162;
                arrayOfString = Build.SUPPORTED_ABIS;
                break;
                if (((String)localObject2).startsWith("libtbs"))
                {
                  localObject1 = a((String)localObject2, "libtbs");
                  break label248;
                }
                localObject1 = localObject2;
                break label248;
                label334:
                com.tencent.tbs.one.impl.a.f.a("    %s -> %s", new Object[] { localObject2, localObject1 });
                try
                {
                  c.c(localFile2, (File)localObject3);
                }
                catch (IOException paramFile1)
                {
                  paramFile1 = new TBSOneException(316, "Failed to extract component files in " + paramFile2.getAbsolutePath(), paramFile1);
                  AppMethodBeat.o(173980);
                  throw paramFile1;
                }
              }
            }
            k = 0;
          }
        }
      }
      i += 1;
      j = k;
    }
    label418:
    if (j != 0) {
      com.tencent.tbs.one.impl.a.f.b("No files to extract from %s", new Object[] { paramFile1.getAbsolutePath() });
    }
    AppMethodBeat.o(173980);
  }
  
  public static void a(InputStream paramInputStream, String paramString, long paramLong, File paramFile1, File paramFile2, k.a parama)
  {
    AppMethodBeat.i(192418);
    com.tencent.tbs.one.impl.a.f.a("Unzipping from download stream to %s, sdcard backup file is %s", new Object[] { paramFile1.getAbsolutePath(), paramFile2 });
    if (!TextUtils.isEmpty(paramString)) {}
    for (MessageDigest localMessageDigest = a();; localMessageDigest = null)
    {
      if (localMessageDigest != null) {}
      for (paramInputStream = new k(new DigestInputStream(paramInputStream, localMessageDigest), paramLong);; paramInputStream = new k(paramInputStream, paramLong))
      {
        paramInputStream.b = parama;
        try
        {
          c.a(paramInputStream, paramFile1, paramFile2);
          if (paramLong <= 0L) {
            break;
          }
          long l = paramInputStream.a;
          if (l == paramLong) {
            break;
          }
          paramInputStream = new TBSOneException(221, "Failed to verify download stream length, expected " + paramLong + " but was " + l);
          AppMethodBeat.o(192418);
          throw paramInputStream;
        }
        catch (IOException paramInputStream)
        {
          paramInputStream = new TBSOneException(315, "Failed to unzip online component from " + paramFile1.getAbsolutePath() + " to " + paramFile1.getAbsolutePath(), paramInputStream);
          AppMethodBeat.o(192418);
          throw paramInputStream;
        }
      }
      if (localMessageDigest != null)
      {
        paramInputStream = com.tencent.tbs.one.impl.a.d.a(localMessageDigest.digest());
        if (!paramInputStream.equals(paramString))
        {
          paramInputStream = new TBSOneException(108, "Failed to verify download stream md5, expected " + paramString + " but was " + paramInputStream);
          AppMethodBeat.o(192418);
          throw paramInputStream;
        }
      }
      AppMethodBeat.o(192418);
      return;
    }
  }
  
  public static void a(MessageDigest paramMessageDigest, File paramFile, String paramString)
  {
    AppMethodBeat.i(173982);
    try
    {
      c.a(new DigestInputStream(new FileInputStream(paramFile), paramMessageDigest), i.a);
      paramMessageDigest = com.tencent.tbs.one.impl.a.d.a(paramMessageDigest.digest());
      if (!paramMessageDigest.equals(paramString))
      {
        paramMessageDigest = new TBSOneException(108, "Failed to verify md5 for component file " + paramFile.getAbsolutePath() + ", expected " + paramString + " but was " + paramMessageDigest);
        AppMethodBeat.o(173982);
        throw paramMessageDigest;
      }
    }
    catch (IOException paramMessageDigest)
    {
      paramMessageDigest = new TBSOneException(107, "Failed to compute md5 for component file " + paramFile.getAbsolutePath(), paramMessageDigest);
      AppMethodBeat.o(173982);
      throw paramMessageDigest;
    }
    AppMethodBeat.o(173982);
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(192416);
    int i = -1;
    for (;;)
    {
      try
      {
        int j = paramString.hashCode();
        switch (j)
        {
        default: 
          switch (i)
          {
          default: 
            AppMethodBeat.o(192416);
            return false;
          }
        case -973170826: 
          if (!paramString.equals("com.tencent.mm")) {
            continue;
          }
          i = 0;
          break;
        case 361910168: 
          if (!paramString.equals("com.tencent.mobileqq")) {
            continue;
          }
          i = 1;
          break;
        }
        if (!paramString.equals("com.tencent.tbs")) {
          continue;
        }
        i = 2;
        continue;
      }
      catch (Exception paramContext)
      {
        boolean bool;
        com.tencent.tbs.one.impl.a.f.c("verify app exception,e=" + Log.getStackTraceString(paramContext), new Object[0]);
        AppMethodBeat.o(192416);
        return false;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        continue;
        String str = "308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499";
        continue;
        str = "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a";
        continue;
      }
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 64);
      if (paramContext != null) {
        continue;
      }
      AppMethodBeat.o(192416);
      return false;
      str = "30820253308201bca00302010202044bbb0361300d06092a864886f70d0101050500306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b30090603550403130251513020170d3130303430363039343831375a180f32323834303132303039343831375a306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b300906035504031302515130819f300d06092a864886f70d010101050003818d0030818902818100a15e9756216f694c5915e0b529095254367c4e64faeff07ae13488d946615a58ddc31a415f717d019edc6d30b9603d3e2a7b3de0ab7e0cf52dfee39373bc472fa997027d798d59f81d525a69ecf156e885fd1e2790924386b2230cc90e3b7adc95603ddcf4c40bdc72f22db0f216a99c371d3bf89cba6578c60699e8a0d536950203010001300d06092a864886f70d01010505000381810094a9b80e80691645dd42d6611775a855f71bcd4d77cb60a8e29404035a5e00b21bcc5d4a562482126bd91b6b0e50709377ceb9ef8c2efd12cc8b16afd9a159f350bb270b14204ff065d843832720702e28b41491fbc3a205f5f2f42526d67f17614d8a974de6487b2c866efede3b4e49a0f916baa3c1336fd2ee1b1629652049";
    }
    bool = str.equals(paramContext.signatures[0].toCharsString());
    if (bool)
    {
      AppMethodBeat.o(192416);
      return true;
    }
  }
  
  private static Certificate[] a(JarFile paramJarFile, JarEntry paramJarEntry, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(192427);
    paramJarFile = paramJarFile.getInputStream(paramJarEntry);
    while (paramJarFile.read(paramArrayOfByte, 0, 8192) != -1) {}
    paramJarFile.close();
    if (paramJarEntry != null)
    {
      paramJarFile = paramJarEntry.getCertificates();
      AppMethodBeat.o(192427);
      return paramJarFile;
    }
    AppMethodBeat.o(192427);
    return null;
  }
  
  public static void b(File paramFile)
  {
    int i = 0;
    AppMethodBeat.i(173987);
    com.tencent.tbs.one.impl.a.f.a("shareFileIfNeeded,directory=%s", new Object[] { paramFile });
    if ((paramFile != null) && (paramFile.exists()))
    {
      paramFile.setReadable(true, false);
      if (paramFile.isDirectory())
      {
        paramFile = paramFile.listFiles();
        int j = paramFile.length;
        while (i < j)
        {
          b(paramFile[i]);
          i += 1;
        }
      }
    }
    AppMethodBeat.o(173987);
  }
  
  public static int c(File paramFile)
  {
    AppMethodBeat.i(192419);
    paramFile = paramFile.listFiles(new FileFilter()
    {
      public final boolean accept(File paramAnonymousFile)
      {
        AppMethodBeat.i(174020);
        boolean bool = paramAnonymousFile.isDirectory();
        AppMethodBeat.o(174020);
        return bool;
      }
    });
    if (paramFile == null)
    {
      AppMethodBeat.o(192419);
      return -1;
    }
    int m = paramFile.length;
    int k = 0;
    int i = -1;
    File localFile;
    if (k < m)
    {
      localFile = paramFile[k];
      if (!g(localFile)) {
        break label123;
      }
    }
    for (;;)
    {
      try
      {
        j = Integer.parseInt(localFile.getName());
        if ((j == -1) || (j <= i)) {
          break label123;
        }
        k += 1;
        i = j;
      }
      catch (Exception localException)
      {
        com.tencent.tbs.one.impl.a.f.c("Failed to parse component version from path %s", new Object[] { localFile.getAbsolutePath(), localException });
        j = -1;
        continue;
      }
      AppMethodBeat.o(192419);
      return i;
      label123:
      int j = i;
    }
  }
  
  public static void d(File paramFile)
  {
    AppMethodBeat.i(173991);
    String str1 = paramFile.getName();
    com.tencent.tbs.one.impl.a.f.a("[%s] Cleaning useless components", new Object[] { str1 });
    Object localObject1 = com.tencent.tbs.one.impl.common.f.b(paramFile);
    if (!((File)localObject1).exists())
    {
      com.tencent.tbs.one.impl.a.f.a("[%s] %s no DEPS file exists", new Object[] { str1, "Early out for cleanup useless components," });
      AppMethodBeat.o(173991);
      return;
    }
    Object localObject2 = j.a(com.tencent.tbs.one.impl.common.f.e((File)localObject1, ".lock"));
    if (localObject2 == null)
    {
      com.tencent.tbs.one.impl.a.f.a("[%s] %s the DEPS installation lock is busy", new Object[] { str1, "Early out for cleanup useless components," });
      AppMethodBeat.o(173991);
      return;
    }
    Object localObject4 = com.tencent.tbs.one.impl.common.f.c(paramFile);
    Object localObject3 = j.a(com.tencent.tbs.one.impl.common.f.e((File)localObject4, ".lock"));
    localObject2 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(173976);
        this.a.a();
        if (this.b != null) {
          this.b.a();
        }
        AppMethodBeat.o(173976);
      }
    };
    if (localObject3 == null)
    {
      com.tencent.tbs.one.impl.a.f.a("[%s] %s the update lock is busy", new Object[] { str1, "Early out for cleanup useless components," });
      ((Runnable)localObject2).run();
      AppMethodBeat.o(173991);
      return;
    }
    try
    {
      localObject3 = com.tencent.tbs.one.impl.common.d.a((File)localObject1);
      localObject1 = null;
      if (((File)localObject4).exists()) {}
      k = paramFile.length;
    }
    catch (TBSOneException paramFile)
    {
      try
      {
        localObject1 = com.tencent.tbs.one.impl.common.d.a((File)localObject4);
        paramFile = com.tencent.tbs.one.impl.common.f.d(paramFile).listFiles();
        if (paramFile != null) {
          break label318;
        }
        ((Runnable)localObject2).run();
        AppMethodBeat.o(173991);
        return;
      }
      catch (TBSOneException paramFile)
      {
        com.tencent.tbs.one.impl.a.f.c("[%s] Failed to parse latest DEPS %s", new Object[] { str1, " to clean useless components", paramFile });
        ((Runnable)localObject2).run();
        AppMethodBeat.o(173991);
        return;
      }
      paramFile = paramFile;
      com.tencent.tbs.one.impl.a.f.c("[%s] Failed to parse current DEPS %s", new Object[] { str1, " to clean useless components", paramFile });
      ((Runnable)localObject2).run();
      AppMethodBeat.o(173991);
      return;
    }
    label318:
    int k;
    int i = 0;
    if (i < k)
    {
      localObject4 = paramFile[i];
      String str2 = ((File)localObject4).getName();
      int m = a((com.tencent.tbs.one.impl.common.d)localObject3, str2);
      int n = a((com.tencent.tbs.one.impl.common.d)localObject1, str2);
      if ((m == -1) && (n == -1)) {
        c.a((File)localObject4);
      }
      do
      {
        i += 1;
        break;
        localObject4 = ((File)localObject4).listFiles();
      } while (localObject4 == null);
      int i1 = localObject4.length;
      int j = 0;
      label402:
      String str3;
      if (j < i1)
      {
        str2 = localObject4[j];
        if (!str2.isDirectory()) {
          break label491;
        }
        str3 = str2.getName();
        if ((!str3.equals(String.valueOf(m))) && (!str3.equals(String.valueOf(n))))
        {
          com.tencent.tbs.one.impl.a.f.a("[%s] Deleting unreferenced component version directory %s", new Object[] { str1, str2.getAbsolutePath() });
          c.a(str2);
        }
      }
      for (;;)
      {
        j += 1;
        break label402;
        break;
        label491:
        str3 = str2.getName();
        if (str3.endsWith(".incomplete"))
        {
          if (!new File(str2.getParent(), str3.substring(0, str3.length() - 11)).exists())
          {
            com.tencent.tbs.one.impl.a.f.a("[%s] Deleting unused incomplete flag file %s", new Object[] { str1, str2.getAbsolutePath() });
            c.a(str2);
          }
        }
        else if (str3.endsWith(".failed"))
        {
          if (System.currentTimeMillis() - str2.lastModified() >= 86400000L)
          {
            com.tencent.tbs.one.impl.a.f.a("[%s] Deleting expired failed flag file %s", new Object[] { str1, str2.getAbsolutePath() });
            c.a(str2);
          }
        }
        else
        {
          com.tencent.tbs.one.impl.a.f.a("[%s] Deleting unknown file %s", new Object[] { str1, str2.getAbsolutePath() });
          c.a(str2);
        }
      }
    }
    ((Runnable)localObject2).run();
    AppMethodBeat.o(173991);
  }
  
  public static void e(File paramFile)
  {
    AppMethodBeat.i(192420);
    paramFile = com.tencent.tbs.one.impl.common.f.e(paramFile, ".incomplete");
    if (!paramFile.exists()) {
      c.b(paramFile);
    }
    AppMethodBeat.o(192420);
  }
  
  public static void f(File paramFile)
  {
    AppMethodBeat.i(192421);
    paramFile = com.tencent.tbs.one.impl.common.f.e(paramFile, ".incomplete");
    if (paramFile.exists()) {
      c.c(paramFile);
    }
    AppMethodBeat.o(192421);
  }
  
  public static boolean g(File paramFile)
  {
    AppMethodBeat.i(192422);
    if (!com.tencent.tbs.one.impl.common.f.e(paramFile, ".incomplete").exists())
    {
      AppMethodBeat.o(192422);
      return true;
    }
    AppMethodBeat.o(192422);
    return false;
  }
  
  public static long h(File paramFile)
  {
    AppMethodBeat.i(192423);
    paramFile = com.tencent.tbs.one.impl.common.f.e(paramFile, ".failed");
    if (paramFile.exists())
    {
      long l = paramFile.lastModified();
      AppMethodBeat.o(192423);
      return l;
    }
    AppMethodBeat.o(192423);
    return 0L;
  }
  
  public static void i(File paramFile)
  {
    AppMethodBeat.i(192424);
    c.c(com.tencent.tbs.one.impl.common.f.e(paramFile, ".failed"));
    AppMethodBeat.o(192424);
  }
  
  public static boolean j(File paramFile)
  {
    AppMethodBeat.i(192425);
    com.tencent.tbs.one.impl.a.f.a("verifyPkgLegality,path=%s", new Object[] { paramFile });
    if (!paramFile.exists())
    {
      com.tencent.tbs.one.impl.a.f.a("verify file signature failed,path=", new Object[] { paramFile });
      AppMethodBeat.o(192425);
      return false;
    }
    try
    {
      JarFile localJarFile = new JarFile(paramFile);
      Enumeration localEnumeration = localJarFile.entries();
      localObject1 = null;
      byte[] arrayOfByte = new byte[8192];
      for (;;)
      {
        if (!localEnumeration.hasMoreElements()) {
          break label217;
        }
        localJarEntry = (JarEntry)localEnumeration.nextElement();
        if ((!localJarEntry.isDirectory()) && (!localJarEntry.getName().startsWith("META-INF/")))
        {
          Object localObject2 = a(localJarFile, localJarEntry, arrayOfByte);
          if (localObject2 == null) {
            break;
          }
          localObject2 = a(localObject2[0].getEncoded());
          if (localObject1 != null)
          {
            if (localObject1.equals(localObject2)) {
              break label300;
            }
            com.tencent.tbs.one.impl.a.f.a("verify file signature failed,origin entry=%s,signature=%s,target=%s", new Object[] { localJarEntry.getName(), localObject2, localObject1 });
            AppMethodBeat.o(192425);
            return false;
          }
          localObject1 = localObject2;
        }
      }
    }
    catch (CertificateEncodingException paramFile)
    {
      for (;;)
      {
        Object localObject1;
        JarEntry localJarEntry;
        com.tencent.tbs.one.impl.a.f.a("verifyPkgLegality failed,exception=%s,stack=", new Object[] { paramFile, Log.getStackTraceString(paramFile) });
      }
    }
    catch (IOException paramFile)
    {
      for (;;) {}
    }
    com.tencent.tbs.one.impl.a.f.a("verify file signature failed,origin entry=%s,signature is null", new Object[] { localJarEntry.getName() });
    AppMethodBeat.o(192425);
    return false;
    label217:
    if (localObject1.equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a"))
    {
      com.tencent.tbs.one.impl.a.f.a("verify file signature success,path=%s", new Object[] { paramFile });
      AppMethodBeat.o(192425);
      return true;
    }
    com.tencent.tbs.one.impl.a.f.a("verify file not success,signature=%s", new Object[] { localObject1 });
    AppMethodBeat.o(192425);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.f
 * JD-Core Version:    0.7.0.1
 */