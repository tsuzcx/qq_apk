package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.a;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.f;
import com.tencent.smtt.utils.r;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class m
{
  private static int d = 5;
  private static int e = 1;
  private static final String[] f = { "tbs_downloading_com.tencent.mtt", "tbs_downloading_com.tencent.mm", "tbs_downloading_com.tencent.mobileqq", "tbs_downloading_com.tencent.tbs", "tbs_downloading_com.qzone" };
  private Handler A;
  private Set<String> B;
  private int C;
  private boolean D;
  String a;
  String[] b;
  int c;
  private Context g;
  private String h;
  private String i;
  private String j;
  private File k;
  private File l;
  private long m;
  private int n;
  private int o;
  private boolean p;
  private int q;
  private int r;
  private boolean s;
  private boolean t;
  private HttpURLConnection u;
  private String v;
  private TbsLogReport.TbsLogInfo w;
  private String x;
  private int y;
  private boolean z;
  
  public m(Context paramContext)
  {
    AppMethodBeat.i(195074);
    this.n = 30000;
    this.o = 20000;
    this.C = d;
    this.b = null;
    this.c = 0;
    this.g = paramContext.getApplicationContext();
    this.w = TbsLogReport.getInstance(this.g).tbsLogInfo();
    this.B = new HashSet();
    this.v = ("tbs_downloading_" + this.g.getPackageName());
    q.a();
    this.k = q.t(this.g);
    if (this.k == null)
    {
      paramContext = new NullPointerException("TbsCorePrivateDir is null!");
      AppMethodBeat.o(195074);
      throw paramContext;
    }
    for (;;)
    {
      try
      {
        localContext = TbsShareManager.getPackageContext(paramContext, "com.tencent.mm", false);
        if (localContext != null) {
          continue;
        }
        this.l = new File(f.a(paramContext, "com.tencent.mm", 4, true));
      }
      catch (Throwable paramContext)
      {
        Context localContext;
        continue;
      }
      e();
      this.x = null;
      this.y = -1;
      AppMethodBeat.o(195074);
      return;
      this.l = new File(f.a(localContext, 4));
    }
  }
  
  private long a(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(195129);
    long l1 = System.currentTimeMillis();
    this.w.setDownConsumeTime(l1 - paramLong1);
    this.w.setDownloadSize(paramLong2);
    AppMethodBeat.o(195129);
    return l1;
  }
  
  @TargetApi(8)
  static File a(Context paramContext)
  {
    AppMethodBeat.i(195205);
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 8)
        {
          paramContext = new File(f.a(paramContext, 4));
          if ((paramContext != null) && (!paramContext.exists()) && (!paramContext.isDirectory())) {
            paramContext.mkdirs();
          }
          AppMethodBeat.o(195205);
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        TbsLog.e("TbsDownload", "[TbsApkDownloader.backupApkPath] Exception is " + paramContext.getMessage());
        AppMethodBeat.o(195205);
        return null;
      }
      paramContext = null;
    }
  }
  
  private static File a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(195211);
    File localFile = new File(f.a(paramContext, paramInt));
    if ((!localFile.exists()) || (!localFile.isDirectory()))
    {
      AppMethodBeat.o(195211);
      return null;
    }
    if (TbsDownloader.getOverSea(paramContext)) {}
    for (paramContext = "x5.oversea.tbs.org"; new File(localFile, paramContext).exists(); paramContext = TbsDownloader.getBackupFileName(false))
    {
      AppMethodBeat.o(195211);
      return localFile;
    }
    AppMethodBeat.o(195211);
    return null;
  }
  
  private String a(Throwable paramThrowable)
  {
    AppMethodBeat.i(195138);
    paramThrowable = Log.getStackTraceString(paramThrowable);
    if (paramThrowable.length() > 1024)
    {
      paramThrowable = paramThrowable.substring(0, 1024);
      AppMethodBeat.o(195138);
      return paramThrowable;
    }
    AppMethodBeat.o(195138);
    return paramThrowable;
  }
  
  private String a(URL paramURL)
  {
    AppMethodBeat.i(195202);
    String str = "";
    try
    {
      paramURL = InetAddress.getByName(paramURL.getHost()).getHostAddress();
      AppMethodBeat.o(195202);
      return paramURL;
    }
    catch (Error paramURL)
    {
      for (;;)
      {
        paramURL = str;
      }
    }
    catch (Exception paramURL)
    {
      for (;;)
      {
        paramURL = str;
      }
    }
  }
  
  private void a(int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(195134);
    if ((paramBoolean) || (this.q > this.C))
    {
      this.w.setErrorCode(paramInt);
      this.w.setFailDetail(paramString);
    }
    AppMethodBeat.o(195134);
  }
  
  private void a(long paramLong)
  {
    AppMethodBeat.i(195163);
    this.q += 1;
    long l1 = paramLong;
    if (paramLong <= 0L) {}
    try
    {
      l1 = l();
      Thread.sleep(l1);
      AppMethodBeat.o(195163);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(195163);
    }
  }
  
  private void a(Closeable paramCloseable)
  {
    AppMethodBeat.i(195162);
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        AppMethodBeat.o(195162);
        return;
      }
      catch (IOException paramCloseable) {}
    }
    AppMethodBeat.o(195162);
  }
  
  public static void a(File paramFile, Context paramContext)
  {
    int i1 = 0;
    AppMethodBeat.i(195226);
    if (paramFile != null) {}
    label516:
    for (;;)
    {
      try
      {
        if (!paramFile.exists()) {
          return;
        }
        File localFile;
        boolean bool2;
        try
        {
          localFile = a(paramContext);
          if (localFile != null)
          {
            if (TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_download_version_type", 0) == 1)
            {
              localObject1 = new File(localFile, TbsDownloader.getBackupFileName(true));
              ((File)localObject1).delete();
              f.b(paramFile, (File)localObject1);
              boolean bool1 = ((File)localObject1).getName().contains("tbs.org");
              bool2 = ((File)localObject1).getName().contains("x5.tbs.decouple");
              if ((!bool2) && (!bool1)) {
                continue;
              }
              localObject1 = localFile.listFiles();
              Pattern localPattern = Pattern.compile(a.a(bool2) + "(.*)");
              int i2 = localObject1.length;
              if (i1 >= i2) {
                continue;
              }
              Object localObject2 = localObject1[i1];
              if ((!localPattern.matcher(localObject2.getName()).find()) || (!localObject2.isFile()) || (!localObject2.exists())) {
                break label516;
              }
              localObject2.delete();
              break label516;
            }
            if (!TbsDownloader.getOverSea(paramContext)) {
              continue;
            }
            localObject1 = "x5.oversea.tbs.org";
            localObject1 = new File(localFile, (String)localObject1);
            continue;
          }
          localObject1 = TbsDownloader.getBackupFileName(false);
        }
        catch (Exception paramFile)
        {
          return;
        }
        continue;
        i1 = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_download_version", 0);
        Object localObject1 = new File(localFile, a.a(bool2) + "." + i1);
        if (((File)localObject1).exists())
        {
          TbsLog.e("TbsDownload", "[TbsApkDownloader.backupTbsApk]delete bacup config file error ");
          return;
        }
        ((File)localObject1).createNewFile();
        if ((TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_download_version_type", 0) != 1) && (TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_decouplecoreversion", 0) == a.a(paramContext, paramFile)))
        {
          i1 = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_responsecode", 0);
          if ((i1 == 5) || (i1 == 3)) {
            TbsLog.i("TbsApkDownloader", "response code=" + i1 + "return backup decouple apk");
          }
          localObject1 = new File(localFile, TbsDownloader.getBackupFileName(true));
          if (a.a(paramContext, paramFile) != a.a(paramContext, (File)localObject1))
          {
            ((File)localObject1).delete();
            f.b(paramFile, (File)localObject1);
            continue;
            i1 += 1;
          }
        }
      }
      finally
      {
        AppMethodBeat.o(195226);
      }
    }
  }
  
  private void a(String paramString)
  {
    AppMethodBeat.i(195081);
    paramString = new URL(paramString);
    if (this.u != null) {}
    try
    {
      this.u.disconnect();
      this.u = ((HttpURLConnection)paramString.openConnection());
      this.u.setRequestProperty("User-Agent", TbsDownloader.b(this.g));
      this.u.setRequestProperty("Accept-Encoding", "identity");
      this.u.setRequestMethod("GET");
      this.u.setInstanceFollowRedirects(false);
      this.u.setConnectTimeout(this.o);
      this.u.setReadTimeout(this.n);
      AppMethodBeat.o(195081);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        TbsLog.e("TbsDownload", "[initHttpRequest] mHttpRequest.disconnect() Throwable:" + localThrowable.toString());
      }
    }
  }
  
  private boolean a(File paramFile)
  {
    AppMethodBeat.i(195172);
    int i2 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("use_backup_version", 0);
    int i1 = i2;
    if (i2 == 0) {
      i1 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_download_version", 0);
    }
    boolean bool = a.a(this.g, paramFile, 0L, i1);
    AppMethodBeat.o(195172);
    return bool;
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2, File paramFile)
  {
    long l1 = 0L;
    AppMethodBeat.i(195183);
    TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=".concat(String.valueOf(paramBoolean1)));
    if (paramFile != null) {
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk]  verifyFile is " + paramFile.getAbsolutePath());
    }
    Object localObject2 = this.k;
    Object localObject1;
    if (!paramBoolean1)
    {
      localObject1 = "x5.tbs";
      localObject1 = new File((File)localObject2, (String)localObject1);
      if (paramFile == null) {
        break label818;
      }
      localObject1 = paramFile;
    }
    label390:
    label782:
    label818:
    for (;;)
    {
      if (!((File)localObject1).exists())
      {
        AppMethodBeat.o(195183);
        return false;
        localObject1 = "x5.tbs.temp";
        break;
      }
      localObject2 = TbsDownloadConfig.getInstance(this.g).mPreferences.getString("tbs_apk_md5", null);
      String str = a.a((File)localObject1);
      if ((localObject2 == null) || (!((String)localObject2).equals(str)))
      {
        TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1 + " md5 failed");
        if (paramBoolean1) {
          this.w.setCheckErrorDetail("fileMd5 not match");
        }
        AppMethodBeat.o(195183);
        return false;
      }
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] md5(" + str + ") successful!");
      long l2 = l1;
      if (paramBoolean1)
      {
        long l3 = TbsDownloadConfig.getInstance(this.g).mPreferences.getLong("tbs_apkfilesize", 0L);
        l2 = l1;
        if (localObject1 != null)
        {
          l2 = l1;
          if (((File)localObject1).exists())
          {
            l2 = l1;
            if (l3 <= 0L) {
              break label390;
            }
            l1 = ((File)localObject1).length();
            l2 = l1;
            if (l3 == l1) {
              break label390;
            }
            l2 = l1;
          }
        }
        TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1 + " filelength failed");
        this.w.setCheckErrorDetail("fileLength:" + l2 + ",contentLength:" + l3);
        AppMethodBeat.o(195183);
        return false;
      }
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] length(" + l2 + ") successful!");
      int i2 = -1;
      int i1 = i2;
      if (paramBoolean2)
      {
        i1 = i2;
        if (!paramBoolean1)
        {
          i2 = a.a(this.g, (File)localObject1);
          int i3 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_download_version", 0);
          i1 = i2;
          if (i3 != i2)
          {
            TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1 + " versionCode failed");
            if (paramBoolean1) {
              this.w.setCheckErrorDetail("fileVersion:" + i2 + ",configVersion:" + i3);
            }
            AppMethodBeat.o(195183);
            return false;
          }
        }
      }
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] tbsApkVersionCode(" + i1 + ") successful!");
      if ((paramBoolean2) && (!paramBoolean1))
      {
        str = b.a(this.g, false, (File)localObject1);
        if (!"3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(str))
        {
          TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1 + " signature failed");
          if (paramBoolean1)
          {
            localObject1 = this.w;
            localObject2 = new StringBuilder("signature:");
            if (str != null) {
              break label698;
            }
          }
          label698:
          for (paramFile = "null";; paramFile = Integer.valueOf(str.length()))
          {
            ((TbsLogReport.TbsLogInfo)localObject1).setCheckErrorDetail(paramFile);
            AppMethodBeat.o(195183);
            return false;
          }
        }
      }
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] signature successful!");
      if ((paramBoolean1) && (paramFile == null))
      {
        try
        {
          paramBoolean1 = ((File)localObject1).renameTo(new File(this.k, "x5.tbs"));
          paramFile = null;
        }
        catch (Exception paramFile)
        {
          for (;;)
          {
            paramBoolean1 = false;
          }
        }
        paramBoolean2 = paramBoolean1;
        if (paramBoolean1) {
          break label782;
        }
        a(109, a(paramFile), true);
        AppMethodBeat.o(195183);
        return false;
      }
      paramBoolean2 = false;
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] rename(" + paramBoolean2 + ") successful!");
      AppMethodBeat.o(195183);
      return true;
    }
  }
  
  @TargetApi(8)
  static File b(Context paramContext)
  {
    AppMethodBeat.i(195209);
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 8)
        {
          Object localObject2 = a(paramContext, 4);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = a(paramContext, 3);
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = a(paramContext, 2);
          }
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = a(paramContext, 1);
          }
          AppMethodBeat.o(195209);
          return localObject1;
        }
      }
      catch (Exception paramContext)
      {
        TbsLog.e("TbsDownload", "[TbsApkDownloader.backupApkPath] Exception is " + paramContext.getMessage());
        AppMethodBeat.o(195209);
        return null;
      }
      Object localObject1 = null;
    }
  }
  
  private boolean b(int paramInt)
  {
    AppMethodBeat.i(195099);
    try
    {
      File localFile1 = new File(this.k, "x5.tbs");
      File localFile2 = a(this.g);
      if (localFile2 != null)
      {
        if (TbsDownloader.getOverSea(this.g)) {}
        for (Object localObject = "x5.oversea.tbs.org";; localObject = TbsDownloader.getBackupFileName(false))
        {
          localObject = new File(localFile2, (String)localObject);
          localFile1.delete();
          f.b((File)localObject, localFile1);
          if (a.a(this.g, localFile1, 0L, paramInt)) {
            break;
          }
          TbsLog.i("TbsDownload", "[TbsApkDownloader.copyTbsApkFromBackupToInstall] verifyTbsApk error!!");
          AppMethodBeat.o(195099);
          return false;
        }
      }
      AppMethodBeat.o(195099);
      return false;
    }
    catch (Exception localException)
    {
      TbsLog.e("TbsDownload", "[TbsApkDownloader.copyTbsApkFromBackupToInstall] Exception is " + localException.getMessage());
      AppMethodBeat.o(195099);
      return false;
    }
    AppMethodBeat.o(195099);
    return true;
  }
  
  public static void c(Context paramContext)
  {
    int i2 = 0;
    AppMethodBeat.i(195229);
    for (;;)
    {
      int i1;
      try
      {
        q.a();
        Object localObject1 = q.t(paramContext);
        new File((File)localObject1, "x5.tbs").delete();
        new File((File)localObject1, "x5.tbs.temp").delete();
        paramContext = a(paramContext);
        if (paramContext != null)
        {
          new File(paramContext, TbsDownloader.getBackupFileName(false)).delete();
          new File(paramContext, "x5.oversea.tbs.org").delete();
          paramContext = paramContext.listFiles();
          localObject1 = Pattern.compile(a.a(true) + "(.*)");
          int i3 = paramContext.length;
          i1 = 0;
          Object localObject2;
          if (i1 < i3)
          {
            localObject2 = paramContext[i1];
            if ((!((Pattern)localObject1).matcher(localObject2.getName()).find()) || (!localObject2.isFile()) || (!localObject2.exists())) {
              break label281;
            }
            localObject2.delete();
            break label281;
          }
          localObject1 = Pattern.compile(a.a(false) + "(.*)");
          i3 = paramContext.length;
          i1 = i2;
          if (i1 < i3)
          {
            localObject2 = paramContext[i1];
            if ((((Pattern)localObject1).matcher(localObject2.getName()).find()) && (localObject2.isFile()) && (localObject2.exists())) {
              localObject2.delete();
            }
            i1 += 1;
            continue;
          }
        }
        AppMethodBeat.o(195229);
        return;
      }
      catch (Exception paramContext)
      {
        AppMethodBeat.o(195229);
        return;
      }
      label281:
      i1 += 1;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    AppMethodBeat.i(195153);
    r.a(this.g);
    Object localObject1 = TbsDownloadConfig.getInstance(this.g);
    ((TbsDownloadConfig)localObject1).mSyncMap.put("request_full_package", Boolean.FALSE);
    ((TbsDownloadConfig)localObject1).mSyncMap.put("tbs_needdownload", Boolean.FALSE);
    ((TbsDownloadConfig)localObject1).mSyncMap.put("tbs_download_interrupt_code_reason", Integer.valueOf(-123));
    ((TbsDownloadConfig)localObject1).commit();
    Object localObject2 = QbSdk.l;
    if (paramBoolean) {}
    for (int i1 = 100;; i1 = 120)
    {
      ((TbsListener)localObject2).onDownloadFinish(i1);
      int i2 = ((TbsDownloadConfig)localObject1).mPreferences.getInt("tbs_responsecode", 0);
      paramBoolean = TbsDownloader.a(this.g);
      for (;;)
      {
        try
        {
          i3 = ((TbsDownloadConfig)localObject1).mPreferences.getInt("tbs_cpu_type_other_stable_core", 0);
          TbsLog.i("TbsDownload", "downloadSuccess #1  cpuTypeForOtherStableCore is ".concat(String.valueOf(i3)));
          if ((paramBoolean) && (r.b(this.g)))
          {
            localObject2 = this.l.listFiles();
            Pattern localPattern = Pattern.compile(a.a(false, i3));
            int i4 = localObject2.length;
            i1 = 0;
            if (i1 < i4)
            {
              Object localObject3 = localObject2[i1];
              if ((!localPattern.matcher(localObject3.getName()).find()) || (!localObject3.isFile()) || (!localObject3.exists())) {
                break label692;
              }
              localObject3.delete();
              break label692;
            }
            localObject2 = new File(this.l, a.a(false, i3) + "." + ((TbsDownloadConfig)localObject1).mPreferences.getInt("tbs_download_version", 0));
            if (!((File)localObject2).exists()) {
              ((File)localObject2).createNewFile();
            }
          }
        }
        catch (Throwable localThrowable2)
        {
          int i3;
          TbsLog.i("TbsDownload", "downloadSuccess stack is " + Log.getStackTraceString(localThrowable2));
          continue;
          q.a().b(this.g, (Bundle)localObject1);
          AppMethodBeat.o(195153);
          return;
        }
        try
        {
          TbsLog.i("TbsDownload", "downloadSuccess renameResult is ".concat(String.valueOf(new File(this.l, TbsDownloader.getBackupFileName(false) + ".tmp").renameTo(new File(this.l, TbsDownloader.getBackupFileName(false, i3))))));
          TbsLog.i("TbsDownload", "downloadSuccess getTbsStableCoreVersion is " + TbsShareManager.getTbsStableCoreVersion(this.g, i3));
          if (i2 == 5)
          {
            localObject1 = a(i2, paramBoolean);
            if (localObject1 == null)
            {
              AppMethodBeat.o(195153);
              return;
            }
          }
        }
        catch (Throwable localThrowable1)
        {
          TbsLog.i("TbsDownload", "downloadSuccess stack is " + Log.getStackTraceString(localThrowable1));
          continue;
        }
        if ((i2 == 3) || (i2 > 10000))
        {
          File localFile = a(this.g);
          if (localFile != null)
          {
            localObject1 = a(i2, localFile, paramBoolean);
            q.a().b(this.g, (Bundle)localObject1);
            AppMethodBeat.o(195153);
            return;
          }
          c();
          ((TbsDownloadConfig)localObject1).mSyncMap.put("tbs_needdownload", Boolean.TRUE);
          ((TbsDownloadConfig)localObject1).commit();
          AppMethodBeat.o(195153);
          return;
        }
        i1 = ((TbsDownloadConfig)localObject1).mPreferences.getInt("tbs_download_version", 0);
        q.a().a(this.g, new File(this.k, "x5.tbs").getAbsolutePath(), i1);
        if (!r.b(this.g)) {
          a(new File(this.k, "x5.tbs"), this.g);
        }
        AppMethodBeat.o(195153);
        return;
        label692:
        i1 += 1;
      }
    }
  }
  
  private boolean c(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(195174);
    paramBoolean1 = a(paramBoolean1, paramBoolean2, null);
    AppMethodBeat.o(195174);
    return paramBoolean1;
  }
  
  private boolean d(boolean paramBoolean)
  {
    AppMethodBeat.i(195187);
    TbsLog.i("TbsDownload", "[TbsApkDownloader.deleteFile] isApk=".concat(String.valueOf(paramBoolean)));
    if (paramBoolean) {}
    for (File localFile = new File(this.k, "x5.tbs");; localFile = new File(this.k, "x5.tbs.temp"))
    {
      if (localFile.exists()) {
        f.b(localFile);
      }
      AppMethodBeat.o(195187);
      return true;
    }
  }
  
  private void e()
  {
    this.q = 0;
    this.r = 0;
    this.m = -1L;
    this.j = null;
    this.p = false;
    this.s = false;
    this.t = false;
    this.z = false;
  }
  
  private void f()
  {
    AppMethodBeat.i(195093);
    TbsLog.i("TbsDownload", "[TbsApkDownloader.closeHttpRequest]");
    if (this.u != null) {
      if (!this.s) {
        this.w.setResolveIp(a(this.u.getURL()));
      }
    }
    try
    {
      this.u.disconnect();
      this.u = null;
      int i1 = this.w.a;
      if ((!this.s) && (this.z))
      {
        this.w.setEventTime(System.currentTimeMillis());
        String str2 = Apn.getApnInfo(this.g);
        String str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        int i2 = Apn.getApnType(this.g);
        this.w.setApn(str1);
        this.w.setNetworkType(i2);
        if ((i2 != this.y) || (!str1.equals(this.x))) {
          this.w.setNetworkChange(0);
        }
        if (((this.w.a == 0) || (this.w.a == 107)) && (this.w.getDownFinalFlag() == 0))
        {
          if (!Apn.isNetworkAvailable(this.g)) {
            a(101, null, true);
          }
        }
        else
        {
          if (!TbsDownloader.a(this.g)) {
            break label315;
          }
          TbsLogReport.getInstance(this.g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE, this.w);
          this.w.resetArgs();
          if (i1 != 100) {
            QbSdk.l.onDownloadFinish(i1);
          }
          AppMethodBeat.o(195093);
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        TbsLog.e("TbsDownload", "[closeHttpRequest] mHttpRequest.disconnect() Throwable:" + localThrowable.toString());
        continue;
        if (!k())
        {
          a(101, null, true);
          continue;
          label315:
          TbsLogReport.getInstance(this.g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, this.w);
        }
      }
      TbsDownloader.a = false;
      AppMethodBeat.o(195093);
    }
  }
  
  private File g()
  {
    AppMethodBeat.i(195166);
    String str = f.a(this.g, 4);
    Object localObject;
    if (TbsDownloader.getOverSea(this.g))
    {
      localObject = "x5.oversea.tbs.org";
      localObject = new File(str, (String)localObject);
      if (!TbsDownloader.a(this.g)) {
        break label84;
      }
      localObject = new File(f.a(this.g, 4), TbsDownloader.getBackupFileName(true));
    }
    label84:
    for (;;)
    {
      AppMethodBeat.o(195166);
      return localObject;
      localObject = TbsDownloader.getBackupFileName(false);
      break;
    }
  }
  
  private void h()
  {
    AppMethodBeat.i(195193);
    try
    {
      Object localObject = g();
      if ((localObject != null) && (((File)localObject).exists()))
      {
        f.b((File)localObject);
        localObject = ((File)localObject).getParentFile().listFiles();
        Pattern localPattern = Pattern.compile(a.a(TbsDownloader.a(this.g)) + "(.*)");
        int i2 = localObject.length;
        int i1 = 0;
        while (i1 < i2)
        {
          File localFile = localObject[i1];
          if ((localPattern.matcher(localFile.getName()).find()) && (localFile.isFile()) && (localFile.exists())) {
            f.b(localFile);
          }
          i1 += 1;
        }
      }
      AppMethodBeat.o(195193);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(195193);
    }
  }
  
  private boolean i()
  {
    AppMethodBeat.i(195194);
    boolean bool = false;
    if (new File(this.k, "x5.tbs.temp").exists()) {
      bool = true;
    }
    AppMethodBeat.o(195194);
    return bool;
  }
  
  private long j()
  {
    AppMethodBeat.i(195195);
    long l1 = 0L;
    File localFile = new File(this.k, "x5.tbs.temp");
    if (localFile.exists()) {
      l1 = localFile.length();
    }
    AppMethodBeat.o(195195);
    return l1;
  }
  
  /* Error */
  private boolean k()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 4
    //   6: ldc_w 763
    //   9: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: invokestatic 769	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   15: astore 6
    //   17: aload 6
    //   19: ldc_w 771
    //   22: ldc_w 773
    //   25: invokestatic 776	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   28: invokevirtual 469	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   31: invokevirtual 780	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   34: invokevirtual 786	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   37: astore 8
    //   39: new 788	java/io/InputStreamReader
    //   42: dup
    //   43: aload 8
    //   45: invokespecial 791	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   48: astore 9
    //   50: new 793	java/io/BufferedReader
    //   53: dup
    //   54: aload 9
    //   56: invokespecial 796	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   59: astore 7
    //   61: iconst_0
    //   62: istore_1
    //   63: aload 7
    //   65: invokevirtual 799	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   68: astore 6
    //   70: iload 4
    //   72: istore_3
    //   73: aload 6
    //   75: ifnull +29 -> 104
    //   78: aload 6
    //   80: ldc_w 801
    //   83: invokevirtual 348	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   86: ifne +16 -> 102
    //   89: aload 6
    //   91: ldc_w 803
    //   94: invokevirtual 348	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   97: istore_3
    //   98: iload_3
    //   99: ifeq +31 -> 130
    //   102: iconst_1
    //   103: istore_3
    //   104: aload_0
    //   105: aload 8
    //   107: invokespecial 805	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   110: aload_0
    //   111: aload 9
    //   113: invokespecial 805	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   116: aload_0
    //   117: aload 7
    //   119: invokespecial 805	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   122: ldc_w 763
    //   125: invokestatic 153	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: iload_3
    //   129: ireturn
    //   130: iload_1
    //   131: iconst_1
    //   132: iadd
    //   133: istore_2
    //   134: iload_2
    //   135: istore_1
    //   136: iload_2
    //   137: iconst_5
    //   138: if_icmplt -75 -> 63
    //   141: iload 4
    //   143: istore_3
    //   144: goto -40 -> 104
    //   147: astore 6
    //   149: aconst_null
    //   150: astore 6
    //   152: aconst_null
    //   153: astore 7
    //   155: aconst_null
    //   156: astore 8
    //   158: aload_0
    //   159: aload 8
    //   161: invokespecial 805	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   164: aload_0
    //   165: aload 7
    //   167: invokespecial 805	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   170: aload_0
    //   171: aload 6
    //   173: invokespecial 805	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   176: iload 5
    //   178: istore_3
    //   179: goto -57 -> 122
    //   182: astore 6
    //   184: aconst_null
    //   185: astore 7
    //   187: aconst_null
    //   188: astore 9
    //   190: aconst_null
    //   191: astore 8
    //   193: aload_0
    //   194: aload 8
    //   196: invokespecial 805	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   199: aload_0
    //   200: aload 9
    //   202: invokespecial 805	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   205: aload_0
    //   206: aload 7
    //   208: invokespecial 805	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   211: ldc_w 763
    //   214: invokestatic 153	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   217: aload 6
    //   219: athrow
    //   220: astore 6
    //   222: aconst_null
    //   223: astore 7
    //   225: aconst_null
    //   226: astore 9
    //   228: goto -35 -> 193
    //   231: astore 6
    //   233: aconst_null
    //   234: astore 7
    //   236: goto -43 -> 193
    //   239: astore 6
    //   241: goto -48 -> 193
    //   244: astore 6
    //   246: aconst_null
    //   247: astore 6
    //   249: aconst_null
    //   250: astore 7
    //   252: goto -94 -> 158
    //   255: astore 6
    //   257: aconst_null
    //   258: astore 6
    //   260: aload 9
    //   262: astore 7
    //   264: goto -106 -> 158
    //   267: astore 6
    //   269: aload 7
    //   271: astore 6
    //   273: aload 9
    //   275: astore 7
    //   277: goto -119 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	this	m
    //   62	74	1	i1	int
    //   133	6	2	i2	int
    //   72	107	3	bool1	boolean
    //   4	138	4	bool2	boolean
    //   1	176	5	bool3	boolean
    //   15	75	6	localObject1	Object
    //   147	1	6	localThrowable1	Throwable
    //   150	22	6	localCloseable	Closeable
    //   182	36	6	localObject2	Object
    //   220	1	6	localObject3	Object
    //   231	1	6	localObject4	Object
    //   239	1	6	localObject5	Object
    //   244	1	6	localThrowable2	Throwable
    //   247	1	6	localObject6	Object
    //   255	1	6	localThrowable3	Throwable
    //   258	1	6	localObject7	Object
    //   267	1	6	localThrowable4	Throwable
    //   271	1	6	localObject8	Object
    //   59	217	7	localObject9	Object
    //   37	158	8	localInputStream	java.io.InputStream
    //   48	226	9	localInputStreamReader	java.io.InputStreamReader
    // Exception table:
    //   from	to	target	type
    //   17	39	147	java/lang/Throwable
    //   17	39	182	finally
    //   39	50	220	finally
    //   50	61	231	finally
    //   63	70	239	finally
    //   78	98	239	finally
    //   39	50	244	java/lang/Throwable
    //   50	61	255	java/lang/Throwable
    //   63	70	267	java/lang/Throwable
    //   78	98	267	java/lang/Throwable
  }
  
  private long l()
  {
    switch (this.q)
    {
    default: 
      return 200000L;
    case 1: 
    case 2: 
      return 20000L * this.q;
    }
    return 100000L;
  }
  
  /* Error */
  private boolean m()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 6
    //   6: iconst_1
    //   7: istore 4
    //   9: iconst_0
    //   10: istore 5
    //   12: ldc_w 812
    //   15: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   18: aload_0
    //   19: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   22: invokestatic 713	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   25: iconst_3
    //   26: if_icmpne +252 -> 278
    //   29: iconst_1
    //   30: istore_3
    //   31: ldc 220
    //   33: ldc_w 814
    //   36: iload_3
    //   37: invokestatic 465	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   40: invokevirtual 469	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   43: invokestatic 404	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: iload 5
    //   48: istore_2
    //   49: iload_3
    //   50: ifeq +121 -> 171
    //   53: aload_0
    //   54: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   57: invokestatic 817	com/tencent/smtt/utils/Apn:getWifiSSID	(Landroid/content/Context;)Ljava/lang/String;
    //   60: astore 6
    //   62: ldc 220
    //   64: ldc_w 819
    //   67: aload 6
    //   69: invokestatic 776	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   72: invokevirtual 469	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   75: invokestatic 404	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: new 271	java/net/URL
    //   81: dup
    //   82: ldc_w 821
    //   85: invokespecial 406	java/net/URL:<init>	(Ljava/lang/String;)V
    //   88: invokevirtual 417	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   91: checkcast 410	java/net/HttpURLConnection
    //   94: astore 7
    //   96: aload 7
    //   98: iconst_0
    //   99: invokevirtual 438	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   102: aload 7
    //   104: sipush 10000
    //   107: invokevirtual 441	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   110: aload 7
    //   112: sipush 10000
    //   115: invokevirtual 444	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   118: aload 7
    //   120: iconst_0
    //   121: invokevirtual 824	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   124: aload 7
    //   126: invokevirtual 825	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   129: pop
    //   130: aload 7
    //   132: invokevirtual 828	java/net/HttpURLConnection:getResponseCode	()I
    //   135: istore_1
    //   136: ldc 220
    //   138: ldc_w 830
    //   141: iload_1
    //   142: invokestatic 622	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   145: invokevirtual 469	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   148: invokestatic 404	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: iload_1
    //   152: sipush 204
    //   155: if_icmpne +128 -> 283
    //   158: iload 4
    //   160: istore_2
    //   161: aload 7
    //   163: ifnull +205 -> 368
    //   166: aload 7
    //   168: invokevirtual 413	java/net/HttpURLConnection:disconnect	()V
    //   171: iload_2
    //   172: ifne +68 -> 240
    //   175: aload 6
    //   177: invokestatic 835	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   180: ifne +60 -> 240
    //   183: aload_0
    //   184: getfield 116	com/tencent/smtt/sdk/m:B	Ljava/util/Set;
    //   187: aload 6
    //   189: invokeinterface 839 2 0
    //   194: ifne +46 -> 240
    //   197: aload_0
    //   198: getfield 116	com/tencent/smtt/sdk/m:B	Ljava/util/Set;
    //   201: aload 6
    //   203: invokeinterface 842 2 0
    //   208: pop
    //   209: aload_0
    //   210: invokespecial 844	com/tencent/smtt/sdk/m:n	()V
    //   213: aload_0
    //   214: getfield 846	com/tencent/smtt/sdk/m:A	Landroid/os/Handler;
    //   217: sipush 150
    //   220: aload 6
    //   222: invokevirtual 852	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   225: astore 7
    //   227: aload_0
    //   228: getfield 846	com/tencent/smtt/sdk/m:A	Landroid/os/Handler;
    //   231: aload 7
    //   233: ldc2_w 853
    //   236: invokevirtual 858	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   239: pop
    //   240: iload_2
    //   241: ifeq +29 -> 270
    //   244: aload_0
    //   245: getfield 116	com/tencent/smtt/sdk/m:B	Ljava/util/Set;
    //   248: aload 6
    //   250: invokeinterface 839 2 0
    //   255: ifeq +15 -> 270
    //   258: aload_0
    //   259: getfield 116	com/tencent/smtt/sdk/m:B	Ljava/util/Set;
    //   262: aload 6
    //   264: invokeinterface 861 2 0
    //   269: pop
    //   270: ldc_w 812
    //   273: invokestatic 153	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   276: iload_2
    //   277: ireturn
    //   278: iconst_0
    //   279: istore_3
    //   280: goto -249 -> 31
    //   283: iconst_0
    //   284: istore_2
    //   285: goto -124 -> 161
    //   288: astore 7
    //   290: goto -119 -> 171
    //   293: astore 7
    //   295: aconst_null
    //   296: astore 7
    //   298: aload 7
    //   300: ifnull +62 -> 362
    //   303: aload 7
    //   305: invokevirtual 413	java/net/HttpURLConnection:disconnect	()V
    //   308: iload 5
    //   310: istore_2
    //   311: goto -140 -> 171
    //   314: astore 7
    //   316: iload 5
    //   318: istore_2
    //   319: goto -148 -> 171
    //   322: astore 6
    //   324: aload 8
    //   326: astore 7
    //   328: aload 7
    //   330: ifnull +8 -> 338
    //   333: aload 7
    //   335: invokevirtual 413	java/net/HttpURLConnection:disconnect	()V
    //   338: ldc_w 812
    //   341: invokestatic 153	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   344: aload 6
    //   346: athrow
    //   347: astore 7
    //   349: goto -11 -> 338
    //   352: astore 6
    //   354: goto -26 -> 328
    //   357: astore 8
    //   359: goto -61 -> 298
    //   362: iload 5
    //   364: istore_2
    //   365: goto -194 -> 171
    //   368: goto -197 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	371	0	this	m
    //   135	21	1	i1	int
    //   48	317	2	bool1	boolean
    //   30	250	3	bool2	boolean
    //   7	152	4	bool3	boolean
    //   10	353	5	bool4	boolean
    //   4	259	6	str	String
    //   322	23	6	localObject1	Object
    //   352	1	6	localObject2	Object
    //   94	138	7	localObject3	Object
    //   288	1	7	localException1	Exception
    //   293	1	7	localThrowable1	Throwable
    //   296	8	7	localObject4	Object
    //   314	1	7	localException2	Exception
    //   326	8	7	localObject5	Object
    //   347	1	7	localException3	Exception
    //   1	324	8	localObject6	Object
    //   357	1	8	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   166	171	288	java/lang/Exception
    //   78	96	293	java/lang/Throwable
    //   303	308	314	java/lang/Exception
    //   78	96	322	finally
    //   333	338	347	java/lang/Exception
    //   96	151	352	finally
    //   96	151	357	java/lang/Throwable
  }
  
  private void n()
  {
    AppMethodBeat.i(195234);
    if (this.A == null) {
      this.A = new Handler(o.a().getLooper())
      {
        public void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(192995);
          if (paramAnonymousMessage.what == 150) {
            m.a(m.this);
          }
          AppMethodBeat.o(192995);
        }
      };
    }
    AppMethodBeat.o(195234);
  }
  
  public Bundle a(int paramInt, File paramFile, boolean paramBoolean)
  {
    AppMethodBeat.i(195160);
    int i1;
    if (paramBoolean)
    {
      paramFile = new File(paramFile, TbsDownloader.getBackupFileName(true));
      i1 = a.a(this.g, paramFile);
      localObject = new File(this.k, "x5.tbs");
      if (!((File)localObject).exists()) {
        break label201;
      }
    }
    label201:
    for (Object localObject = ((File)localObject).getAbsolutePath();; localObject = null)
    {
      int i2 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_download_version", 0);
      Bundle localBundle = new Bundle();
      localBundle.putInt("operation", paramInt);
      localBundle.putInt("old_core_ver", i1);
      localBundle.putInt("new_core_ver", i2);
      localBundle.putString("old_apk_location", paramFile.getAbsolutePath());
      localBundle.putString("new_apk_location", (String)localObject);
      localBundle.putString("diff_file_location", (String)localObject);
      AppMethodBeat.o(195160);
      return localBundle;
      if (TbsDownloader.getOverSea(this.g)) {}
      for (localObject = "x5.oversea.tbs.org";; localObject = TbsDownloader.getBackupFileName(false))
      {
        paramFile = new File(paramFile, (String)localObject);
        break;
      }
    }
  }
  
  public Bundle a(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(195158);
    Object localObject1;
    int i1;
    if (paramBoolean)
    {
      localObject1 = q.a().q(this.g);
      i1 = q.a().i(this.g);
      localObject2 = new File(this.k, "x5.tbs");
      if (!((File)localObject2).exists()) {
        break label103;
      }
    }
    label103:
    for (Object localObject2 = ((File)localObject2).getAbsolutePath();; localObject2 = null)
    {
      if (localObject2 != null) {
        break label109;
      }
      AppMethodBeat.o(195158);
      return null;
      localObject1 = q.a().r(this.g);
      i1 = q.a().j(this.g);
      break;
    }
    label109:
    int i2 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_download_version", 0);
    if (paramBoolean) {}
    for (File localFile = q.a().f(this.g, 6);; localFile = q.a().f(this.g, 5))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("operation", paramInt);
      localBundle.putInt("old_core_ver", i1);
      localBundle.putInt("new_core_ver", i2);
      localBundle.putString("old_apk_location", ((File)localObject1).getAbsolutePath());
      localBundle.putString("new_apk_location", localFile.getAbsolutePath());
      localBundle.putString("diff_file_location", (String)localObject2);
      localObject1 = f.a(this.g, 7);
      localObject2 = new File((String)localObject1);
      if (!((File)localObject2).exists()) {
        ((File)localObject2).mkdirs();
      }
      localBundle.putString("backup_apk", new File((String)localObject1, i2 + ".tbs").getAbsolutePath());
      AppMethodBeat.o(195158);
      return localBundle;
    }
  }
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(195222);
    if (q.a().u(this.g))
    {
      q.a().b();
      try
      {
        File localFile = new File(this.k, "x5.tbs");
        int i1 = a.a(this.g, localFile);
        if ((-1 == i1) || ((paramInt > 0) && (paramInt == i1))) {
          f.b(localFile);
        }
        AppMethodBeat.o(195222);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(195222);
  }
  
  public boolean a()
  {
    AppMethodBeat.i(195111);
    TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #1");
    try
    {
      File localFile1 = new File(f.a(this.g, 4), TbsDownloader.getBackupFileName(true));
      if (localFile1.exists()) {
        TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #2");
      }
      while (a.a(this.g, localFile1, 0L, TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_decouplecoreversion", -1)))
      {
        TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #3");
        boolean bool = q.a().f(this.g);
        AppMethodBeat.o(195111);
        return bool;
        File localFile2 = TbsDownloader.b(TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_decouplecoreversion", -1));
        if ((localFile2 != null) && (localFile2.exists())) {
          f.b(localFile2, localFile1);
        }
      }
      return false;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(195111);
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    AppMethodBeat.i(195128);
    if ((paramBoolean) && (!m()) && ((!QbSdk.getDownloadWithoutWifi()) || (!Apn.isNetworkAvailable(this.g))))
    {
      AppMethodBeat.o(195128);
      return false;
    }
    if ((this.b != null) && (this.c >= 0) && (this.c < this.b.length))
    {
      String[] arrayOfString = this.b;
      int i1 = this.c;
      this.c = (i1 + 1);
      this.j = arrayOfString[i1];
      this.q = 0;
      this.r = 0;
      this.m = -1L;
      this.p = false;
      this.s = false;
      this.t = false;
      this.z = false;
      AppMethodBeat.o(195128);
      return true;
    }
    AppMethodBeat.o(195128);
    return false;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(195103);
    if (Build.VERSION.SDK_INT == 23)
    {
      AppMethodBeat.o(195103);
      return false;
    }
    int i1 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("use_backup_version", 0);
    int i2 = q.a().j(this.g);
    if (i1 == 0) {
      i1 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_download_version", 0);
    }
    for (this.a = "by default key"; (i1 == 0) || (i1 == i2); this.a = "by new key")
    {
      AppMethodBeat.o(195103);
      return false;
    }
    if (paramBoolean2)
    {
      File localFile = TbsDownloader.a(i1);
      Object localObject;
      if ((localFile != null) && (localFile.exists()))
      {
        String str = f.a(this.g, 4);
        if (TbsDownloader.getOverSea(this.g))
        {
          localObject = "x5.oversea.tbs.org";
          localObject = new File(str, (String)localObject);
        }
      }
      for (;;)
      {
        try
        {
          if (TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_download_version_type", 0) == 1) {
            break label371;
          }
          f.b(localFile, (File)localObject);
          i2 = 1;
          localObject = g();
          if ((localObject == null) || (!((File)localObject).exists()) || (!a((File)localObject))) {
            break label397;
          }
          if (!b(i1)) {
            break label456;
          }
          TbsDownloadConfig.getInstance(this.g).mSyncMap.put("tbs_download_interrupt_code_reason", Integer.valueOf(-214));
          TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-214);
          c(false);
          if (i2 != 0)
          {
            a(100, "use local backup apk in startDownload" + this.a, true);
            if (!TbsDownloader.a(this.g)) {
              break label377;
            }
            TbsLogReport.getInstance(this.g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE, this.w);
            this.w.resetArgs();
          }
          AppMethodBeat.o(195103);
          return true;
        }
        catch (Exception localException) {}
        localObject = TbsDownloader.getBackupFileName(false);
        break;
        label371:
        i2 = 0;
        continue;
        label377:
        TbsLogReport.getInstance(this.g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, this.w);
      }
      label397:
      if (!r.b(this.g)) {
        h();
      }
      if ((localFile != null) && (localFile.exists()) && (!a.a(this.g, localFile, 0L, i1)) && (localFile != null) && (localFile.exists())) {
        f.b(localFile);
      }
    }
    label456:
    if (c(false, paramBoolean2))
    {
      TbsDownloadConfig.getInstance(this.g).mSyncMap.put("tbs_download_interrupt_code_reason", Integer.valueOf(-214));
      TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-214);
      c(false);
      AppMethodBeat.o(195103);
      return true;
    }
    if ((!d(true)) && (!d(true)))
    {
      TbsLog.e("TbsDownload", "[TbsApkDownloader] delete file failed!");
      TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-301);
    }
    AppMethodBeat.o(195103);
    return false;
  }
  
  public int b(boolean paramBoolean)
  {
    AppMethodBeat.i(195215);
    File localFile = a(this.g);
    int i1;
    if (paramBoolean)
    {
      if (localFile == null)
      {
        AppMethodBeat.o(195215);
        return 0;
      }
      i1 = a.a(this.g, new File(localFile, TbsDownloader.getBackupFileName(true)));
      AppMethodBeat.o(195215);
      return i1;
    }
    if (localFile == null)
    {
      AppMethodBeat.o(195215);
      return 0;
    }
    Context localContext = this.g;
    if (TbsDownloader.getOverSea(this.g)) {}
    for (String str = "x5.oversea.tbs.org";; str = TbsDownloader.getBackupFileName(false))
    {
      i1 = a.a(localContext, new File(localFile, str));
      AppMethodBeat.o(195215);
      return i1;
    }
  }
  
  public void b()
  {
    AppMethodBeat.i(195219);
    this.s = true;
    if (TbsShareManager.isThirdPartyApp(this.g))
    {
      TbsLogReport.TbsLogInfo localTbsLogInfo = TbsLogReport.getInstance(this.g).tbsLogInfo();
      localTbsLogInfo.setErrorCode(-309);
      localTbsLogInfo.setFailDetail(new Exception());
      if (TbsDownloader.a(this.g))
      {
        TbsLogReport.getInstance(this.g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE, localTbsLogInfo);
        AppMethodBeat.o(195219);
        return;
      }
      TbsLogReport.getInstance(this.g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, localTbsLogInfo);
    }
    AppMethodBeat.o(195219);
  }
  
  /* Error */
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: ldc_w 973
    //   3: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   10: invokestatic 978	com/tencent/smtt/sdk/TbsOneGreyInfoHelper:isTbsOneModeEnable	(Landroid/content/Context;)Z
    //   13: ifeq +12 -> 25
    //   16: ldc_w 980
    //   19: ldc_w 982
    //   22: invokestatic 404	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: invokestatic 141	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   28: aload_0
    //   29: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   32: invokevirtual 984	com/tencent/smtt/sdk/q:d	(Landroid/content/Context;)Z
    //   35: ifeq +31 -> 66
    //   38: iload_1
    //   39: ifne +27 -> 66
    //   42: iconst_0
    //   43: putstatic 750	com/tencent/smtt/sdk/TbsDownloader:a	Z
    //   46: aload_0
    //   47: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   50: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   53: sipush -322
    //   56: invokevirtual 949	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   59: ldc_w 973
    //   62: invokestatic 153	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: return
    //   66: aload_0
    //   67: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   70: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   73: getfield 325	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   76: ldc_w 396
    //   79: iconst_0
    //   80: invokeinterface 333 3 0
    //   85: istore_3
    //   86: iload_3
    //   87: iconst_1
    //   88: if_icmpeq +13 -> 101
    //   91: iload_3
    //   92: iconst_2
    //   93: if_icmpeq +8 -> 101
    //   96: iload_3
    //   97: iconst_4
    //   98: if_icmpne +31 -> 129
    //   101: iconst_1
    //   102: istore 9
    //   104: iload_2
    //   105: ifne +30 -> 135
    //   108: aload_0
    //   109: iload_1
    //   110: iload 9
    //   112: invokevirtual 986	com/tencent/smtt/sdk/m:a	(ZZ)Z
    //   115: ifeq +20 -> 135
    //   118: iconst_0
    //   119: putstatic 750	com/tencent/smtt/sdk/TbsDownloader:a	Z
    //   122: ldc_w 973
    //   125: invokestatic 153	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: return
    //   129: iconst_0
    //   130: istore 9
    //   132: goto -28 -> 104
    //   135: aload_0
    //   136: iload_1
    //   137: putfield 988	com/tencent/smtt/sdk/m:D	Z
    //   140: aload_0
    //   141: aload_0
    //   142: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   145: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   148: getfield 325	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   151: ldc_w 990
    //   154: aconst_null
    //   155: invokeinterface 484 3 0
    //   160: putfield 992	com/tencent/smtt/sdk/m:h	Ljava/lang/String;
    //   163: aload_0
    //   164: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   167: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   170: getfield 325	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   173: ldc_w 994
    //   176: aconst_null
    //   177: invokeinterface 484 3 0
    //   182: astore 30
    //   184: ldc 220
    //   186: ldc_w 996
    //   189: aload 30
    //   191: invokestatic 776	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   194: invokevirtual 469	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   197: iconst_1
    //   198: invokestatic 999	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   201: aload_0
    //   202: aconst_null
    //   203: putfield 89	com/tencent/smtt/sdk/m:b	[Ljava/lang/String;
    //   206: aload_0
    //   207: iconst_0
    //   208: putfield 91	com/tencent/smtt/sdk/m:c	I
    //   211: iload_1
    //   212: ifne +37 -> 249
    //   215: aload 30
    //   217: ifnull +32 -> 249
    //   220: ldc_w 269
    //   223: aload 30
    //   225: invokevirtual 1002	java/lang/String:trim	()Ljava/lang/String;
    //   228: invokevirtual 491	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   231: ifne +18 -> 249
    //   234: aload_0
    //   235: aload 30
    //   237: invokevirtual 1002	java/lang/String:trim	()Ljava/lang/String;
    //   240: ldc_w 1004
    //   243: invokevirtual 1008	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   246: putfield 89	com/tencent/smtt/sdk/m:b	[Ljava/lang/String;
    //   249: ldc 220
    //   251: new 118	java/lang/StringBuilder
    //   254: dup
    //   255: ldc_w 1010
    //   258: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   261: aload_0
    //   262: getfield 992	com/tencent/smtt/sdk/m:h	Ljava/lang/String;
    //   265: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: ldc_w 1012
    //   271: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: aload 30
    //   276: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: ldc_w 1014
    //   282: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: aload_0
    //   286: getfield 679	com/tencent/smtt/sdk/m:j	Ljava/lang/String;
    //   289: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: ldc_w 1016
    //   295: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: aload_0
    //   299: getfield 683	com/tencent/smtt/sdk/m:s	Z
    //   302: invokevirtual 494	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   305: ldc_w 1018
    //   308: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: aload_0
    //   312: getfield 408	com/tencent/smtt/sdk/m:u	Ljava/net/HttpURLConnection;
    //   315: invokevirtual 548	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   318: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokestatic 404	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   324: aload_0
    //   325: getfield 992	com/tencent/smtt/sdk/m:h	Ljava/lang/String;
    //   328: ifnonnull +40 -> 368
    //   331: aload_0
    //   332: getfield 679	com/tencent/smtt/sdk/m:j	Ljava/lang/String;
    //   335: ifnonnull +33 -> 368
    //   338: getstatic 609	com/tencent/smtt/sdk/QbSdk:l	Lcom/tencent/smtt/sdk/TbsListener;
    //   341: bipush 110
    //   343: invokeinterface 614 2 0
    //   348: aload_0
    //   349: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   352: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   355: sipush -302
    //   358: invokevirtual 949	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   361: ldc_w 973
    //   364: invokestatic 153	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   367: return
    //   368: aload_0
    //   369: getfield 408	com/tencent/smtt/sdk/m:u	Ljava/net/HttpURLConnection;
    //   372: ifnull +40 -> 412
    //   375: aload_0
    //   376: getfield 683	com/tencent/smtt/sdk/m:s	Z
    //   379: ifne +33 -> 412
    //   382: getstatic 609	com/tencent/smtt/sdk/QbSdk:l	Lcom/tencent/smtt/sdk/TbsListener;
    //   385: bipush 110
    //   387: invokeinterface 614 2 0
    //   392: aload_0
    //   393: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   396: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   399: sipush -303
    //   402: invokevirtual 949	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   405: ldc_w 973
    //   408: invokestatic 153	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   411: return
    //   412: iload_1
    //   413: ifne +60 -> 473
    //   416: aload_0
    //   417: getfield 116	com/tencent/smtt/sdk/m:B	Ljava/util/Set;
    //   420: aload_0
    //   421: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   424: invokestatic 817	com/tencent/smtt/utils/Apn:getWifiSSID	(Landroid/content/Context;)Ljava/lang/String;
    //   427: invokeinterface 839 2 0
    //   432: ifeq +41 -> 473
    //   435: ldc 220
    //   437: ldc_w 1020
    //   440: invokestatic 404	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   443: getstatic 609	com/tencent/smtt/sdk/QbSdk:l	Lcom/tencent/smtt/sdk/TbsListener;
    //   446: bipush 110
    //   448: invokeinterface 614 2 0
    //   453: aload_0
    //   454: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   457: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   460: sipush -304
    //   463: invokevirtual 949	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   466: ldc_w 973
    //   469: invokestatic 153	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   472: return
    //   473: aload_0
    //   474: invokespecial 173	com/tencent/smtt/sdk/m:e	()V
    //   477: ldc 220
    //   479: ldc_w 1022
    //   482: iconst_1
    //   483: invokestatic 999	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   486: aload_0
    //   487: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   490: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   493: invokevirtual 1025	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMaxflow	()J
    //   496: lstore 28
    //   498: iconst_0
    //   499: istore 5
    //   501: aload_0
    //   502: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   505: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   508: getfield 325	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   511: ldc_w 1027
    //   514: lconst_0
    //   515: invokeinterface 511 4 0
    //   520: lstore 14
    //   522: iload_1
    //   523: ifeq +320 -> 843
    //   526: aload_0
    //   527: getstatic 54	com/tencent/smtt/sdk/m:e	I
    //   530: putfield 87	com/tencent/smtt/sdk/m:C	I
    //   533: iload 5
    //   535: istore 6
    //   537: aload_0
    //   538: getfield 287	com/tencent/smtt/sdk/m:q	I
    //   541: aload_0
    //   542: getfield 87	com/tencent/smtt/sdk/m:C	I
    //   545: if_icmpgt +37 -> 582
    //   548: aload_0
    //   549: getfield 673	com/tencent/smtt/sdk/m:r	I
    //   552: bipush 8
    //   554: if_icmple +299 -> 853
    //   557: aload_0
    //   558: bipush 123
    //   560: aconst_null
    //   561: iconst_1
    //   562: invokespecial 562	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   565: aload_0
    //   566: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   569: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   572: sipush -306
    //   575: invokevirtual 949	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   578: iload 5
    //   580: istore 6
    //   582: aload_0
    //   583: getfield 683	com/tencent/smtt/sdk/m:s	Z
    //   586: ifne +246 -> 832
    //   589: iload 6
    //   591: istore_1
    //   592: aload_0
    //   593: getfield 685	com/tencent/smtt/sdk/m:t	Z
    //   596: ifeq +165 -> 761
    //   599: iload 6
    //   601: istore_1
    //   602: aload_0
    //   603: getfield 89	com/tencent/smtt/sdk/m:b	[Ljava/lang/String;
    //   606: ifnonnull +67 -> 673
    //   609: iload 6
    //   611: istore_1
    //   612: iload 6
    //   614: ifne +59 -> 673
    //   617: iload_2
    //   618: ifeq +6181 -> 6799
    //   621: aload_0
    //   622: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   625: invokestatic 624	com/tencent/smtt/utils/r:b	(Landroid/content/Context;)Z
    //   628: ifeq +6171 -> 6799
    //   631: aload_0
    //   632: iconst_1
    //   633: iload 9
    //   635: new 163	java/io/File
    //   638: dup
    //   639: aload_0
    //   640: getfield 171	com/tencent/smtt/sdk/m:l	Ljava/io/File;
    //   643: new 118	java/lang/StringBuilder
    //   646: dup
    //   647: invokespecial 355	java/lang/StringBuilder:<init>	()V
    //   650: iconst_0
    //   651: invokestatic 248	com/tencent/smtt/sdk/TbsDownloader:getBackupFileName	(Z)Ljava/lang/String;
    //   654: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   657: ldc_w 631
    //   660: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   663: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   666: invokespecial 244	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   669: invokespecial 664	com/tencent/smtt/sdk/m:a	(ZZLjava/io/File;)Z
    //   672: istore_1
    //   673: aload_0
    //   674: getfield 111	com/tencent/smtt/sdk/m:w	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   677: astore 30
    //   679: iload_1
    //   680: ifeq +6130 -> 6810
    //   683: iconst_1
    //   684: istore_3
    //   685: aload 30
    //   687: iload_3
    //   688: invokevirtual 1030	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setUnpkgFlag	(I)V
    //   691: iload 9
    //   693: ifne +6127 -> 6820
    //   696: aload_0
    //   697: getfield 111	com/tencent/smtt/sdk/m:w	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   700: astore 30
    //   702: iload_1
    //   703: ifeq +6112 -> 6815
    //   706: iconst_1
    //   707: istore_3
    //   708: aload 30
    //   710: iload_3
    //   711: invokevirtual 1033	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setPatchUpdateFlag	(I)V
    //   714: ldc 220
    //   716: ldc_w 1035
    //   719: iload_1
    //   720: invokestatic 465	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   723: invokevirtual 469	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   726: invokestatic 404	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   729: iload_1
    //   730: ifeq +6101 -> 6831
    //   733: aload_0
    //   734: iconst_1
    //   735: invokespecial 951	com/tencent/smtt/sdk/m:c	(Z)V
    //   738: aload_0
    //   739: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   742: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   745: sipush -317
    //   748: invokevirtual 949	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   751: aload_0
    //   752: bipush 100
    //   754: ldc_w 1037
    //   757: iconst_1
    //   758: invokespecial 562	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   761: aload_0
    //   762: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   765: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   768: astore 30
    //   770: iload_1
    //   771: ifeq +6082 -> 6853
    //   774: aload 30
    //   776: getfield 325	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   779: ldc_w 1039
    //   782: iconst_0
    //   783: invokeinterface 333 3 0
    //   788: istore_3
    //   789: aload 30
    //   791: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   794: ldc_w 1039
    //   797: iload_3
    //   798: iconst_1
    //   799: iadd
    //   800: invokestatic 553	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   803: invokeinterface 597 3 0
    //   808: pop
    //   809: aload 30
    //   811: invokevirtual 604	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   814: aload_0
    //   815: getfield 111	com/tencent/smtt/sdk/m:w	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   818: astore 30
    //   820: iload_1
    //   821: ifeq +6093 -> 6914
    //   824: iconst_1
    //   825: istore_3
    //   826: aload 30
    //   828: iload_3
    //   829: invokevirtual 1042	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownFinalFlag	(I)V
    //   832: aload_0
    //   833: invokespecial 1044	com/tencent/smtt/sdk/m:f	()V
    //   836: ldc_w 973
    //   839: invokestatic 153	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   842: return
    //   843: aload_0
    //   844: getstatic 52	com/tencent/smtt/sdk/m:d	I
    //   847: putfield 87	com/tencent/smtt/sdk/m:C	I
    //   850: goto -317 -> 533
    //   853: invokestatic 188	java/lang/System:currentTimeMillis	()J
    //   856: lstore 24
    //   858: lload 14
    //   860: lstore 10
    //   862: iload_1
    //   863: ifne +456 -> 1319
    //   866: lload 14
    //   868: lstore 16
    //   870: iload 5
    //   872: istore 6
    //   874: lload 14
    //   876: lstore 12
    //   878: lload 24
    //   880: aload_0
    //   881: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   884: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   887: getfield 325	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   890: ldc_w 1046
    //   893: lconst_0
    //   894: invokeinterface 511 4 0
    //   899: lsub
    //   900: ldc2_w 1047
    //   903: lcmp
    //   904: ifle +260 -> 1164
    //   907: lload 14
    //   909: lstore 16
    //   911: iload 5
    //   913: istore 6
    //   915: lload 14
    //   917: lstore 12
    //   919: ldc 220
    //   921: ldc_w 1050
    //   924: invokestatic 404	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   927: lload 14
    //   929: lstore 16
    //   931: iload 5
    //   933: istore 6
    //   935: lload 14
    //   937: lstore 12
    //   939: aload_0
    //   940: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   943: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   946: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   949: ldc_w 1046
    //   952: lload 24
    //   954: invokestatic 1055	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   957: invokeinterface 597 3 0
    //   962: pop
    //   963: lload 14
    //   965: lstore 16
    //   967: iload 5
    //   969: istore 6
    //   971: lload 14
    //   973: lstore 12
    //   975: aload_0
    //   976: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   979: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   982: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   985: ldc_w 1027
    //   988: lconst_0
    //   989: invokestatic 1055	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   992: invokeinterface 597 3 0
    //   997: pop
    //   998: lload 14
    //   1000: lstore 16
    //   1002: iload 5
    //   1004: istore 6
    //   1006: lload 14
    //   1008: lstore 12
    //   1010: aload_0
    //   1011: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   1014: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1017: invokevirtual 604	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1020: lconst_0
    //   1021: lstore 18
    //   1023: lload 18
    //   1025: lstore 10
    //   1027: lload 18
    //   1029: lstore 16
    //   1031: iload 5
    //   1033: istore 6
    //   1035: lload 18
    //   1037: lstore 12
    //   1039: aload_0
    //   1040: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   1043: invokestatic 1056	com/tencent/smtt/utils/f:b	(Landroid/content/Context;)Z
    //   1046: ifne +273 -> 1319
    //   1049: lload 18
    //   1051: lstore 16
    //   1053: iload 5
    //   1055: istore 6
    //   1057: lload 18
    //   1059: lstore 12
    //   1061: ldc 220
    //   1063: ldc_w 1058
    //   1066: iconst_1
    //   1067: invokestatic 999	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1070: lload 18
    //   1072: lstore 16
    //   1074: iload 5
    //   1076: istore 6
    //   1078: lload 18
    //   1080: lstore 12
    //   1082: aload_0
    //   1083: bipush 105
    //   1085: aconst_null
    //   1086: iconst_1
    //   1087: invokespecial 562	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   1090: lload 18
    //   1092: lstore 16
    //   1094: iload 5
    //   1096: istore 6
    //   1098: lload 18
    //   1100: lstore 12
    //   1102: aload_0
    //   1103: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   1106: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1109: sipush -308
    //   1112: invokevirtual 949	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   1115: iload 5
    //   1117: istore 6
    //   1119: iload_1
    //   1120: ifne -538 -> 582
    //   1123: aload_0
    //   1124: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   1127: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1130: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1133: ldc_w 1027
    //   1136: lload 18
    //   1138: invokestatic 1055	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1141: invokeinterface 597 3 0
    //   1146: pop
    //   1147: aload_0
    //   1148: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   1151: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1154: invokevirtual 604	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1157: iload 5
    //   1159: istore 6
    //   1161: goto -579 -> 582
    //   1164: lload 14
    //   1166: lstore 16
    //   1168: iload 5
    //   1170: istore 6
    //   1172: lload 14
    //   1174: lstore 12
    //   1176: ldc 220
    //   1178: ldc_w 1060
    //   1181: lload 14
    //   1183: invokestatic 1063	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1186: invokevirtual 469	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1189: invokestatic 404	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1192: lload 14
    //   1194: lstore 18
    //   1196: lload 14
    //   1198: lload 28
    //   1200: lcmp
    //   1201: iflt -178 -> 1023
    //   1204: lload 14
    //   1206: lstore 16
    //   1208: iload 5
    //   1210: istore 6
    //   1212: lload 14
    //   1214: lstore 12
    //   1216: ldc 220
    //   1218: ldc_w 1065
    //   1221: iconst_1
    //   1222: invokestatic 999	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1225: lload 14
    //   1227: lstore 16
    //   1229: iload 5
    //   1231: istore 6
    //   1233: lload 14
    //   1235: lstore 12
    //   1237: aload_0
    //   1238: bipush 112
    //   1240: aconst_null
    //   1241: iconst_1
    //   1242: invokespecial 562	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   1245: lload 14
    //   1247: lstore 16
    //   1249: iload 5
    //   1251: istore 6
    //   1253: lload 14
    //   1255: lstore 12
    //   1257: aload_0
    //   1258: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   1261: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1264: sipush -307
    //   1267: invokevirtual 949	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   1270: iload 5
    //   1272: istore 6
    //   1274: iload_1
    //   1275: ifne -693 -> 582
    //   1278: aload_0
    //   1279: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   1282: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1285: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1288: ldc_w 1027
    //   1291: lload 14
    //   1293: invokestatic 1055	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1296: invokeinterface 597 3 0
    //   1301: pop
    //   1302: aload_0
    //   1303: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   1306: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1309: invokevirtual 604	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1312: iload 5
    //   1314: istore 6
    //   1316: goto -734 -> 582
    //   1319: lload 10
    //   1321: lstore 16
    //   1323: iload 5
    //   1325: istore 6
    //   1327: lload 10
    //   1329: lstore 12
    //   1331: aload_0
    //   1332: iconst_1
    //   1333: putfield 687	com/tencent/smtt/sdk/m:z	Z
    //   1336: lload 10
    //   1338: lstore 16
    //   1340: iload 5
    //   1342: istore 6
    //   1344: lload 10
    //   1346: lstore 12
    //   1348: aload_0
    //   1349: getfield 679	com/tencent/smtt/sdk/m:j	Ljava/lang/String;
    //   1352: ifnull +846 -> 2198
    //   1355: lload 10
    //   1357: lstore 16
    //   1359: iload 5
    //   1361: istore 6
    //   1363: lload 10
    //   1365: lstore 12
    //   1367: aload_0
    //   1368: getfield 679	com/tencent/smtt/sdk/m:j	Ljava/lang/String;
    //   1371: astore 30
    //   1373: lload 10
    //   1375: lstore 16
    //   1377: iload 5
    //   1379: istore 6
    //   1381: lload 10
    //   1383: lstore 12
    //   1385: ldc 220
    //   1387: new 118	java/lang/StringBuilder
    //   1390: dup
    //   1391: ldc_w 1067
    //   1394: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1397: aload 30
    //   1399: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1402: ldc_w 1069
    //   1405: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1408: aload_0
    //   1409: getfield 287	com/tencent/smtt/sdk/m:q	I
    //   1412: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1415: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1418: iconst_1
    //   1419: invokestatic 999	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1422: lload 10
    //   1424: lstore 16
    //   1426: iload 5
    //   1428: istore 6
    //   1430: lload 10
    //   1432: lstore 12
    //   1434: aload 30
    //   1436: aload_0
    //   1437: getfield 1071	com/tencent/smtt/sdk/m:i	Ljava/lang/String;
    //   1440: invokevirtual 491	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1443: ifne +24 -> 1467
    //   1446: lload 10
    //   1448: lstore 16
    //   1450: iload 5
    //   1452: istore 6
    //   1454: lload 10
    //   1456: lstore 12
    //   1458: aload_0
    //   1459: getfield 111	com/tencent/smtt/sdk/m:w	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   1462: aload 30
    //   1464: invokevirtual 1074	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownloadUrl	(Ljava/lang/String;)V
    //   1467: lload 10
    //   1469: lstore 16
    //   1471: iload 5
    //   1473: istore 6
    //   1475: lload 10
    //   1477: lstore 12
    //   1479: aload_0
    //   1480: aload 30
    //   1482: putfield 1071	com/tencent/smtt/sdk/m:i	Ljava/lang/String;
    //   1485: lload 10
    //   1487: lstore 16
    //   1489: iload 5
    //   1491: istore 6
    //   1493: lload 10
    //   1495: lstore 12
    //   1497: aload_0
    //   1498: aload 30
    //   1500: invokespecial 1076	com/tencent/smtt/sdk/m:a	(Ljava/lang/String;)V
    //   1503: lconst_0
    //   1504: lstore 14
    //   1506: lload 10
    //   1508: lstore 16
    //   1510: iload 5
    //   1512: istore 6
    //   1514: lload 10
    //   1516: lstore 12
    //   1518: aload_0
    //   1519: getfield 681	com/tencent/smtt/sdk/m:p	Z
    //   1522: ifne +145 -> 1667
    //   1525: lload 10
    //   1527: lstore 16
    //   1529: iload 5
    //   1531: istore 6
    //   1533: lload 10
    //   1535: lstore 12
    //   1537: aload_0
    //   1538: invokespecial 1078	com/tencent/smtt/sdk/m:j	()J
    //   1541: lstore 14
    //   1543: lload 10
    //   1545: lstore 16
    //   1547: iload 5
    //   1549: istore 6
    //   1551: lload 10
    //   1553: lstore 12
    //   1555: ldc 220
    //   1557: ldc_w 1080
    //   1560: lload 14
    //   1562: invokestatic 1063	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1565: invokevirtual 469	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1568: invokestatic 404	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1571: lload 10
    //   1573: lstore 16
    //   1575: iload 5
    //   1577: istore 6
    //   1579: lload 10
    //   1581: lstore 12
    //   1583: aload_0
    //   1584: getfield 677	com/tencent/smtt/sdk/m:m	J
    //   1587: lconst_0
    //   1588: lcmp
    //   1589: ifgt +630 -> 2219
    //   1592: lload 10
    //   1594: lstore 16
    //   1596: iload 5
    //   1598: istore 6
    //   1600: lload 10
    //   1602: lstore 12
    //   1604: ldc 220
    //   1606: ldc_w 1082
    //   1609: lload 14
    //   1611: invokestatic 1063	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1614: invokevirtual 469	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1617: iconst_1
    //   1618: invokestatic 999	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1621: lload 10
    //   1623: lstore 16
    //   1625: iload 5
    //   1627: istore 6
    //   1629: lload 10
    //   1631: lstore 12
    //   1633: aload_0
    //   1634: getfield 408	com/tencent/smtt/sdk/m:u	Ljava/net/HttpURLConnection;
    //   1637: ldc_w 1084
    //   1640: new 118	java/lang/StringBuilder
    //   1643: dup
    //   1644: ldc_w 1086
    //   1647: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1650: lload 14
    //   1652: invokevirtual 520	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1655: ldc_w 1088
    //   1658: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1661: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1664: invokevirtual 425	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1667: lload 10
    //   1669: lstore 16
    //   1671: iload 5
    //   1673: istore 6
    //   1675: lload 10
    //   1677: lstore 12
    //   1679: aload_0
    //   1680: getfield 111	com/tencent/smtt/sdk/m:w	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   1683: astore 30
    //   1685: lload 14
    //   1687: lconst_0
    //   1688: lcmp
    //   1689: ifne +809 -> 2498
    //   1692: iconst_0
    //   1693: istore_3
    //   1694: lload 10
    //   1696: lstore 16
    //   1698: iload 5
    //   1700: istore 6
    //   1702: lload 10
    //   1704: lstore 12
    //   1706: aload 30
    //   1708: iload_3
    //   1709: invokevirtual 1091	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownloadCancel	(I)V
    //   1712: lload 10
    //   1714: lstore 16
    //   1716: iload 5
    //   1718: istore 6
    //   1720: lload 10
    //   1722: lstore 12
    //   1724: aload_0
    //   1725: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   1728: invokestatic 713	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   1731: istore_3
    //   1732: lload 10
    //   1734: lstore 16
    //   1736: iload 5
    //   1738: istore 6
    //   1740: lload 10
    //   1742: lstore 12
    //   1744: aload_0
    //   1745: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   1748: invokestatic 709	com/tencent/smtt/utils/Apn:getApnInfo	(Landroid/content/Context;)Ljava/lang/String;
    //   1751: astore 30
    //   1753: lload 10
    //   1755: lstore 16
    //   1757: iload 5
    //   1759: istore 6
    //   1761: lload 10
    //   1763: lstore 12
    //   1765: aload_0
    //   1766: getfield 175	com/tencent/smtt/sdk/m:x	Ljava/lang/String;
    //   1769: ifnonnull +734 -> 2503
    //   1772: lload 10
    //   1774: lstore 16
    //   1776: iload 5
    //   1778: istore 6
    //   1780: lload 10
    //   1782: lstore 12
    //   1784: aload_0
    //   1785: getfield 177	com/tencent/smtt/sdk/m:y	I
    //   1788: iconst_m1
    //   1789: if_icmpne +714 -> 2503
    //   1792: lload 10
    //   1794: lstore 16
    //   1796: iload 5
    //   1798: istore 6
    //   1800: lload 10
    //   1802: lstore 12
    //   1804: aload_0
    //   1805: aload 30
    //   1807: putfield 175	com/tencent/smtt/sdk/m:x	Ljava/lang/String;
    //   1810: lload 10
    //   1812: lstore 16
    //   1814: iload 5
    //   1816: istore 6
    //   1818: lload 10
    //   1820: lstore 12
    //   1822: aload_0
    //   1823: iload_3
    //   1824: putfield 177	com/tencent/smtt/sdk/m:y	I
    //   1827: lload 10
    //   1829: lstore 16
    //   1831: iload 5
    //   1833: istore 6
    //   1835: lload 10
    //   1837: lstore 12
    //   1839: aload_0
    //   1840: getfield 287	com/tencent/smtt/sdk/m:q	I
    //   1843: ifle +29 -> 1872
    //   1846: lload 10
    //   1848: lstore 16
    //   1850: iload 5
    //   1852: istore 6
    //   1854: lload 10
    //   1856: lstore 12
    //   1858: aload_0
    //   1859: getfield 408	com/tencent/smtt/sdk/m:u	Ljava/net/HttpURLConnection;
    //   1862: ldc_w 1093
    //   1865: aload_0
    //   1866: getfield 992	com/tencent/smtt/sdk/m:h	Ljava/lang/String;
    //   1869: invokevirtual 1096	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1872: lload 10
    //   1874: lstore 16
    //   1876: iload 5
    //   1878: istore 6
    //   1880: lload 10
    //   1882: lstore 12
    //   1884: aload_0
    //   1885: getfield 408	com/tencent/smtt/sdk/m:u	Ljava/net/HttpURLConnection;
    //   1888: invokevirtual 828	java/net/HttpURLConnection:getResponseCode	()I
    //   1891: istore_3
    //   1892: lload 10
    //   1894: lstore 16
    //   1896: iload 5
    //   1898: istore 6
    //   1900: lload 10
    //   1902: lstore 12
    //   1904: ldc 220
    //   1906: ldc_w 1098
    //   1909: iload_3
    //   1910: invokestatic 622	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1913: invokevirtual 469	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1916: invokestatic 404	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1919: lload 10
    //   1921: lstore 16
    //   1923: iload 5
    //   1925: istore 6
    //   1927: lload 10
    //   1929: lstore 12
    //   1931: aload_0
    //   1932: getfield 111	com/tencent/smtt/sdk/m:w	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   1935: iload_3
    //   1936: invokevirtual 1101	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setHttpCode	(I)V
    //   1939: iload_1
    //   1940: ifne +165 -> 2105
    //   1943: lload 10
    //   1945: lstore 16
    //   1947: iload 5
    //   1949: istore 6
    //   1951: lload 10
    //   1953: lstore 12
    //   1955: aload_0
    //   1956: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   1959: invokestatic 239	com/tencent/smtt/sdk/TbsDownloader:getOverSea	(Landroid/content/Context;)Z
    //   1962: ifne +143 -> 2105
    //   1965: lload 10
    //   1967: lstore 16
    //   1969: iload 5
    //   1971: istore 6
    //   1973: lload 10
    //   1975: lstore 12
    //   1977: aload_0
    //   1978: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   1981: invokestatic 713	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   1984: iconst_3
    //   1985: if_icmpne +25 -> 2010
    //   1988: lload 10
    //   1990: lstore 16
    //   1992: iload 5
    //   1994: istore 6
    //   1996: lload 10
    //   1998: lstore 12
    //   2000: aload_0
    //   2001: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   2004: invokestatic 713	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   2007: ifne +98 -> 2105
    //   2010: lload 10
    //   2012: lstore 16
    //   2014: iload 5
    //   2016: istore 6
    //   2018: lload 10
    //   2020: lstore 12
    //   2022: invokestatic 933	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   2025: ifne +80 -> 2105
    //   2028: lload 10
    //   2030: lstore 16
    //   2032: iload 5
    //   2034: istore 6
    //   2036: lload 10
    //   2038: lstore 12
    //   2040: aload_0
    //   2041: invokevirtual 1102	com/tencent/smtt/sdk/m:b	()V
    //   2044: lload 10
    //   2046: lstore 16
    //   2048: iload 5
    //   2050: istore 6
    //   2052: lload 10
    //   2054: lstore 12
    //   2056: getstatic 609	com/tencent/smtt/sdk/QbSdk:l	Lcom/tencent/smtt/sdk/TbsListener;
    //   2059: ifnull +25 -> 2084
    //   2062: lload 10
    //   2064: lstore 16
    //   2066: iload 5
    //   2068: istore 6
    //   2070: lload 10
    //   2072: lstore 12
    //   2074: getstatic 609	com/tencent/smtt/sdk/QbSdk:l	Lcom/tencent/smtt/sdk/TbsListener;
    //   2077: bipush 111
    //   2079: invokeinterface 614 2 0
    //   2084: lload 10
    //   2086: lstore 16
    //   2088: iload 5
    //   2090: istore 6
    //   2092: lload 10
    //   2094: lstore 12
    //   2096: ldc 220
    //   2098: ldc_w 1104
    //   2101: iconst_0
    //   2102: invokestatic 999	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   2105: lload 10
    //   2107: lstore 16
    //   2109: iload 5
    //   2111: istore 6
    //   2113: lload 10
    //   2115: lstore 12
    //   2117: aload_0
    //   2118: getfield 683	com/tencent/smtt/sdk/m:s	Z
    //   2121: ifeq +537 -> 2658
    //   2124: lload 10
    //   2126: lstore 16
    //   2128: iload 5
    //   2130: istore 6
    //   2132: lload 10
    //   2134: lstore 12
    //   2136: aload_0
    //   2137: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   2140: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2143: sipush -309
    //   2146: invokevirtual 949	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2149: iload 5
    //   2151: istore 6
    //   2153: iload_1
    //   2154: ifne -1572 -> 582
    //   2157: aload_0
    //   2158: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   2161: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2164: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2167: ldc_w 1027
    //   2170: lload 10
    //   2172: invokestatic 1055	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2175: invokeinterface 597 3 0
    //   2180: pop
    //   2181: aload_0
    //   2182: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   2185: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2188: invokevirtual 604	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2191: iload 5
    //   2193: istore 6
    //   2195: goto -1613 -> 582
    //   2198: lload 10
    //   2200: lstore 16
    //   2202: iload 5
    //   2204: istore 6
    //   2206: lload 10
    //   2208: lstore 12
    //   2210: aload_0
    //   2211: getfield 992	com/tencent/smtt/sdk/m:h	Ljava/lang/String;
    //   2214: astore 30
    //   2216: goto -843 -> 1373
    //   2219: lload 10
    //   2221: lstore 16
    //   2223: iload 5
    //   2225: istore 6
    //   2227: lload 10
    //   2229: lstore 12
    //   2231: ldc 220
    //   2233: new 118	java/lang/StringBuilder
    //   2236: dup
    //   2237: ldc_w 1106
    //   2240: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2243: lload 14
    //   2245: invokevirtual 520	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2248: ldc_w 1108
    //   2251: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2254: aload_0
    //   2255: getfield 677	com/tencent/smtt/sdk/m:m	J
    //   2258: invokevirtual 520	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2261: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2264: iconst_1
    //   2265: invokestatic 999	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   2268: lload 10
    //   2270: lstore 16
    //   2272: iload 5
    //   2274: istore 6
    //   2276: lload 10
    //   2278: lstore 12
    //   2280: aload_0
    //   2281: getfield 408	com/tencent/smtt/sdk/m:u	Ljava/net/HttpURLConnection;
    //   2284: ldc_w 1084
    //   2287: new 118	java/lang/StringBuilder
    //   2290: dup
    //   2291: ldc_w 1086
    //   2294: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2297: lload 14
    //   2299: invokevirtual 520	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2302: ldc_w 1088
    //   2305: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2308: aload_0
    //   2309: getfield 677	com/tencent/smtt/sdk/m:m	J
    //   2312: invokevirtual 520	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2315: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2318: invokevirtual 425	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   2321: goto -654 -> 1667
    //   2324: astore 30
    //   2326: iload 6
    //   2328: istore 7
    //   2330: lload 16
    //   2332: lstore 12
    //   2334: aload 30
    //   2336: instanceof 1110
    //   2339: ifeq +4357 -> 6696
    //   2342: iload_1
    //   2343: ifne +4353 -> 6696
    //   2346: lload 16
    //   2348: lstore 12
    //   2350: aload_0
    //   2351: getfield 89	com/tencent/smtt/sdk/m:b	[Ljava/lang/String;
    //   2354: ifnull +4342 -> 6696
    //   2357: lload 16
    //   2359: lstore 12
    //   2361: aload_0
    //   2362: iconst_0
    //   2363: invokevirtual 1112	com/tencent/smtt/sdk/m:a	(Z)Z
    //   2366: ifeq +4330 -> 6696
    //   2369: lload 16
    //   2371: lstore 12
    //   2373: ldc 220
    //   2375: new 118	java/lang/StringBuilder
    //   2378: dup
    //   2379: ldc_w 1114
    //   2382: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2385: aload_0
    //   2386: getfield 679	com/tencent/smtt/sdk/m:j	Ljava/lang/String;
    //   2389: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2392: ldc_w 1116
    //   2395: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2398: aload 30
    //   2400: invokevirtual 447	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2403: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2406: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2409: invokestatic 230	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2412: lload 16
    //   2414: lstore 12
    //   2416: aload_0
    //   2417: bipush 125
    //   2419: aconst_null
    //   2420: iconst_1
    //   2421: invokespecial 562	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   2424: lload 16
    //   2426: lstore 12
    //   2428: aload_0
    //   2429: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   2432: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2435: sipush -316
    //   2438: invokevirtual 949	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2441: lload 16
    //   2443: lstore 14
    //   2445: iload 7
    //   2447: istore 5
    //   2449: iload_1
    //   2450: ifne -1917 -> 533
    //   2453: aload_0
    //   2454: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   2457: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2460: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2463: ldc_w 1027
    //   2466: lload 16
    //   2468: invokestatic 1055	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2471: invokeinterface 597 3 0
    //   2476: pop
    //   2477: aload_0
    //   2478: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   2481: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2484: invokevirtual 604	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2487: lload 16
    //   2489: lstore 14
    //   2491: iload 7
    //   2493: istore 5
    //   2495: goto -1962 -> 533
    //   2498: iconst_1
    //   2499: istore_3
    //   2500: goto -806 -> 1694
    //   2503: lload 10
    //   2505: lstore 16
    //   2507: iload 5
    //   2509: istore 6
    //   2511: lload 10
    //   2513: lstore 12
    //   2515: iload_3
    //   2516: aload_0
    //   2517: getfield 177	com/tencent/smtt/sdk/m:y	I
    //   2520: if_icmpne +27 -> 2547
    //   2523: lload 10
    //   2525: lstore 16
    //   2527: iload 5
    //   2529: istore 6
    //   2531: lload 10
    //   2533: lstore 12
    //   2535: aload 30
    //   2537: aload_0
    //   2538: getfield 175	com/tencent/smtt/sdk/m:x	Ljava/lang/String;
    //   2541: invokevirtual 491	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2544: ifne -717 -> 1827
    //   2547: lload 10
    //   2549: lstore 16
    //   2551: iload 5
    //   2553: istore 6
    //   2555: lload 10
    //   2557: lstore 12
    //   2559: aload_0
    //   2560: getfield 111	com/tencent/smtt/sdk/m:w	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   2563: iconst_0
    //   2564: invokevirtual 722	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setNetworkChange	(I)V
    //   2567: lload 10
    //   2569: lstore 16
    //   2571: iload 5
    //   2573: istore 6
    //   2575: lload 10
    //   2577: lstore 12
    //   2579: aload_0
    //   2580: aload 30
    //   2582: putfield 175	com/tencent/smtt/sdk/m:x	Ljava/lang/String;
    //   2585: lload 10
    //   2587: lstore 16
    //   2589: iload 5
    //   2591: istore 6
    //   2593: lload 10
    //   2595: lstore 12
    //   2597: aload_0
    //   2598: iload_3
    //   2599: putfield 177	com/tencent/smtt/sdk/m:y	I
    //   2602: goto -775 -> 1827
    //   2605: astore 30
    //   2607: lload 12
    //   2609: lstore 10
    //   2611: iload_1
    //   2612: ifne +37 -> 2649
    //   2615: aload_0
    //   2616: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   2619: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2622: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2625: ldc_w 1027
    //   2628: lload 10
    //   2630: invokestatic 1055	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2633: invokeinterface 597 3 0
    //   2638: pop
    //   2639: aload_0
    //   2640: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   2643: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2646: invokevirtual 604	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2649: ldc_w 973
    //   2652: invokestatic 153	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2655: aload 30
    //   2657: athrow
    //   2658: iload_3
    //   2659: sipush 200
    //   2662: if_icmpeq +10 -> 2672
    //   2665: iload_3
    //   2666: sipush 206
    //   2669: if_icmpne +2801 -> 5470
    //   2672: lload 10
    //   2674: lstore 16
    //   2676: iload 5
    //   2678: istore 6
    //   2680: lload 10
    //   2682: lstore 12
    //   2684: aload_0
    //   2685: aload_0
    //   2686: getfield 408	com/tencent/smtt/sdk/m:u	Ljava/net/HttpURLConnection;
    //   2689: invokevirtual 1119	java/net/HttpURLConnection:getContentLength	()I
    //   2692: i2l
    //   2693: lload 14
    //   2695: ladd
    //   2696: putfield 677	com/tencent/smtt/sdk/m:m	J
    //   2699: lload 10
    //   2701: lstore 16
    //   2703: iload 5
    //   2705: istore 6
    //   2707: lload 10
    //   2709: lstore 12
    //   2711: ldc 220
    //   2713: new 118	java/lang/StringBuilder
    //   2716: dup
    //   2717: ldc_w 1121
    //   2720: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2723: aload_0
    //   2724: getfield 677	com/tencent/smtt/sdk/m:m	J
    //   2727: invokevirtual 520	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2730: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2733: invokestatic 404	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2736: lload 10
    //   2738: lstore 16
    //   2740: iload 5
    //   2742: istore 6
    //   2744: lload 10
    //   2746: lstore 12
    //   2748: aload_0
    //   2749: getfield 111	com/tencent/smtt/sdk/m:w	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   2752: aload_0
    //   2753: getfield 677	com/tencent/smtt/sdk/m:m	J
    //   2756: invokevirtual 1124	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setPkgSize	(J)V
    //   2759: lload 10
    //   2761: lstore 16
    //   2763: iload 5
    //   2765: istore 6
    //   2767: lload 10
    //   2769: lstore 12
    //   2771: aload_0
    //   2772: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   2775: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2778: getfield 325	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   2781: ldc_w 507
    //   2784: lconst_0
    //   2785: invokeinterface 511 4 0
    //   2790: lstore 18
    //   2792: lload 18
    //   2794: lconst_0
    //   2795: lcmp
    //   2796: ifeq +403 -> 3199
    //   2799: lload 10
    //   2801: lstore 16
    //   2803: iload 5
    //   2805: istore 6
    //   2807: lload 10
    //   2809: lstore 12
    //   2811: aload_0
    //   2812: getfield 677	com/tencent/smtt/sdk/m:m	J
    //   2815: lload 18
    //   2817: lcmp
    //   2818: ifeq +381 -> 3199
    //   2821: lload 10
    //   2823: lstore 16
    //   2825: iload 5
    //   2827: istore 6
    //   2829: lload 10
    //   2831: lstore 12
    //   2833: ldc 220
    //   2835: new 118	java/lang/StringBuilder
    //   2838: dup
    //   2839: ldc_w 1126
    //   2842: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2845: lload 18
    //   2847: invokevirtual 520	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2850: ldc_w 1128
    //   2853: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2856: aload_0
    //   2857: getfield 677	com/tencent/smtt/sdk/m:m	J
    //   2860: invokevirtual 520	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2863: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2866: iconst_1
    //   2867: invokestatic 999	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   2870: iload_1
    //   2871: ifne +278 -> 3149
    //   2874: lload 10
    //   2876: lstore 16
    //   2878: iload 5
    //   2880: istore 6
    //   2882: lload 10
    //   2884: lstore 12
    //   2886: aload_0
    //   2887: invokespecial 451	com/tencent/smtt/sdk/m:m	()Z
    //   2890: ifne +43 -> 2933
    //   2893: lload 10
    //   2895: lstore 16
    //   2897: iload 5
    //   2899: istore 6
    //   2901: lload 10
    //   2903: lstore 12
    //   2905: invokestatic 933	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   2908: ifeq +241 -> 3149
    //   2911: lload 10
    //   2913: lstore 16
    //   2915: iload 5
    //   2917: istore 6
    //   2919: lload 10
    //   2921: lstore 12
    //   2923: aload_0
    //   2924: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   2927: invokestatic 728	com/tencent/smtt/utils/Apn:isNetworkAvailable	(Landroid/content/Context;)Z
    //   2930: ifeq +219 -> 3149
    //   2933: lload 10
    //   2935: lstore 16
    //   2937: iload 5
    //   2939: istore 6
    //   2941: lload 10
    //   2943: lstore 12
    //   2945: aload_0
    //   2946: getfield 89	com/tencent/smtt/sdk/m:b	[Ljava/lang/String;
    //   2949: ifnull +76 -> 3025
    //   2952: lload 10
    //   2954: lstore 16
    //   2956: iload 5
    //   2958: istore 6
    //   2960: lload 10
    //   2962: lstore 12
    //   2964: aload_0
    //   2965: iconst_0
    //   2966: invokevirtual 1112	com/tencent/smtt/sdk/m:a	(Z)Z
    //   2969: istore 7
    //   2971: iload 7
    //   2973: ifeq +52 -> 3025
    //   2976: lload 10
    //   2978: lstore 14
    //   2980: iload_1
    //   2981: ifne -2448 -> 533
    //   2984: aload_0
    //   2985: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   2988: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2991: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2994: ldc_w 1027
    //   2997: lload 10
    //   2999: invokestatic 1055	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3002: invokeinterface 597 3 0
    //   3007: pop
    //   3008: aload_0
    //   3009: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   3012: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3015: invokevirtual 604	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   3018: lload 10
    //   3020: lstore 14
    //   3022: goto -2489 -> 533
    //   3025: lload 10
    //   3027: lstore 16
    //   3029: iload 5
    //   3031: istore 6
    //   3033: lload 10
    //   3035: lstore 12
    //   3037: aload_0
    //   3038: bipush 113
    //   3040: new 118	java/lang/StringBuilder
    //   3043: dup
    //   3044: ldc_w 1130
    //   3047: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3050: lload 18
    //   3052: invokevirtual 520	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3055: ldc_w 1128
    //   3058: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3061: aload_0
    //   3062: getfield 677	com/tencent/smtt/sdk/m:m	J
    //   3065: invokevirtual 520	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3068: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3071: iconst_1
    //   3072: invokespecial 562	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   3075: lload 10
    //   3077: lstore 16
    //   3079: iload 5
    //   3081: istore 6
    //   3083: lload 10
    //   3085: lstore 12
    //   3087: aload_0
    //   3088: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   3091: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3094: sipush -310
    //   3097: invokevirtual 949	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3100: iload 5
    //   3102: istore 6
    //   3104: iload_1
    //   3105: ifne -2523 -> 582
    //   3108: aload_0
    //   3109: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   3112: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3115: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   3118: ldc_w 1027
    //   3121: lload 10
    //   3123: invokestatic 1055	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3126: invokeinterface 597 3 0
    //   3131: pop
    //   3132: aload_0
    //   3133: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   3136: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3139: invokevirtual 604	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   3142: iload 5
    //   3144: istore 6
    //   3146: goto -2564 -> 582
    //   3149: lload 10
    //   3151: lstore 16
    //   3153: iload 5
    //   3155: istore 6
    //   3157: lload 10
    //   3159: lstore 12
    //   3161: aload_0
    //   3162: bipush 101
    //   3164: ldc_w 1132
    //   3167: iconst_1
    //   3168: invokespecial 562	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   3171: lload 10
    //   3173: lstore 16
    //   3175: iload 5
    //   3177: istore 6
    //   3179: lload 10
    //   3181: lstore 12
    //   3183: aload_0
    //   3184: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   3187: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3190: sipush -304
    //   3193: invokevirtual 949	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3196: goto -96 -> 3100
    //   3199: aconst_null
    //   3200: astore 34
    //   3202: aconst_null
    //   3203: astore 30
    //   3205: aconst_null
    //   3206: astore 32
    //   3208: lload 10
    //   3210: lstore 16
    //   3212: iload 5
    //   3214: istore 6
    //   3216: lload 10
    //   3218: lstore 12
    //   3220: ldc 220
    //   3222: ldc_w 1134
    //   3225: invokestatic 404	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3228: aload_0
    //   3229: getfield 408	com/tencent/smtt/sdk/m:u	Ljava/net/HttpURLConnection;
    //   3232: invokevirtual 825	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   3235: astore 31
    //   3237: aload 31
    //   3239: ifnull +1718 -> 4957
    //   3242: aload_0
    //   3243: getfield 408	com/tencent/smtt/sdk/m:u	Ljava/net/HttpURLConnection;
    //   3246: invokevirtual 1137	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   3249: astore 30
    //   3251: aload 30
    //   3253: ifnull +374 -> 3627
    //   3256: aload 30
    //   3258: ldc_w 1139
    //   3261: invokevirtual 348	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3264: ifeq +363 -> 3627
    //   3267: new 1141	java/util/zip/GZIPInputStream
    //   3270: dup
    //   3271: aload 31
    //   3273: invokespecial 1142	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   3276: astore 30
    //   3278: sipush 8192
    //   3281: newarray byte
    //   3283: astore 35
    //   3285: iload_2
    //   3286: ifeq +556 -> 3842
    //   3289: aload_0
    //   3290: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   3293: invokestatic 624	com/tencent/smtt/utils/r:b	(Landroid/content/Context;)Z
    //   3296: ifeq +546 -> 3842
    //   3299: new 163	java/io/File
    //   3302: dup
    //   3303: aload_0
    //   3304: getfield 171	com/tencent/smtt/sdk/m:l	Ljava/io/File;
    //   3307: new 118	java/lang/StringBuilder
    //   3310: dup
    //   3311: invokespecial 355	java/lang/StringBuilder:<init>	()V
    //   3314: iconst_0
    //   3315: invokestatic 248	com/tencent/smtt/sdk/TbsDownloader:getBackupFileName	(Z)Ljava/lang/String;
    //   3318: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3321: ldc_w 631
    //   3324: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3327: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3330: invokespecial 244	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   3333: astore 33
    //   3335: aload 33
    //   3337: astore 32
    //   3339: aload 33
    //   3341: invokevirtual 212	java/io/File:exists	()Z
    //   3344: ifeq +13 -> 3357
    //   3347: aload 33
    //   3349: invokevirtual 336	java/io/File:delete	()Z
    //   3352: pop
    //   3353: aload 33
    //   3355: astore 32
    //   3357: ldc 220
    //   3359: new 118	java/lang/StringBuilder
    //   3362: dup
    //   3363: ldc_w 1144
    //   3366: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3369: aload 32
    //   3371: invokevirtual 474	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   3374: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3377: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3380: iconst_1
    //   3381: invokestatic 999	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   3384: new 1146	java/io/FileOutputStream
    //   3387: dup
    //   3388: aload 32
    //   3390: iconst_1
    //   3391: invokespecial 1149	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   3394: astore 33
    //   3396: lload 10
    //   3398: lstore 12
    //   3400: lload 10
    //   3402: lstore 18
    //   3404: invokestatic 188	java/lang/System:currentTimeMillis	()J
    //   3407: lstore 16
    //   3409: iconst_0
    //   3410: istore_3
    //   3411: lload 14
    //   3413: lstore 22
    //   3415: iload 5
    //   3417: istore 6
    //   3419: lload 10
    //   3421: lstore 18
    //   3423: iload 5
    //   3425: istore 8
    //   3427: lload 10
    //   3429: lstore 20
    //   3431: aload_0
    //   3432: getfield 683	com/tencent/smtt/sdk/m:s	Z
    //   3435: ifeq +455 -> 3890
    //   3438: iload 5
    //   3440: istore 6
    //   3442: lload 10
    //   3444: lstore 18
    //   3446: iload 5
    //   3448: istore 8
    //   3450: lload 10
    //   3452: lstore 20
    //   3454: ldc 220
    //   3456: ldc_w 1151
    //   3459: iconst_1
    //   3460: invokestatic 999	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   3463: iload 5
    //   3465: istore 6
    //   3467: lload 10
    //   3469: lstore 18
    //   3471: iload 5
    //   3473: istore 8
    //   3475: lload 10
    //   3477: lstore 20
    //   3479: aload_0
    //   3480: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   3483: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3486: sipush -309
    //   3489: invokevirtual 949	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3492: iload 5
    //   3494: istore 7
    //   3496: lload 10
    //   3498: lstore 14
    //   3500: iload 7
    //   3502: istore 5
    //   3504: aload 30
    //   3506: astore 34
    //   3508: aload 33
    //   3510: astore 32
    //   3512: iload_3
    //   3513: ifeq +1454 -> 4967
    //   3516: lload 10
    //   3518: lstore 16
    //   3520: iload 7
    //   3522: istore 6
    //   3524: lload 10
    //   3526: lstore 12
    //   3528: aload_0
    //   3529: aload 33
    //   3531: invokespecial 805	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   3534: lload 10
    //   3536: lstore 16
    //   3538: iload 7
    //   3540: istore 6
    //   3542: lload 10
    //   3544: lstore 12
    //   3546: aload_0
    //   3547: aload 30
    //   3549: invokespecial 805	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   3552: lload 10
    //   3554: lstore 16
    //   3556: iload 7
    //   3558: istore 6
    //   3560: lload 10
    //   3562: lstore 12
    //   3564: aload_0
    //   3565: aload 31
    //   3567: invokespecial 805	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   3570: lload 10
    //   3572: lstore 14
    //   3574: iload 7
    //   3576: istore 5
    //   3578: iload_1
    //   3579: ifne -3046 -> 533
    //   3582: aload_0
    //   3583: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   3586: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3589: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   3592: ldc_w 1027
    //   3595: lload 10
    //   3597: invokestatic 1055	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3600: invokeinterface 597 3 0
    //   3605: pop
    //   3606: aload_0
    //   3607: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   3610: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3613: invokevirtual 604	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   3616: lload 10
    //   3618: lstore 14
    //   3620: iload 7
    //   3622: istore 5
    //   3624: goto -3091 -> 533
    //   3627: aload 30
    //   3629: ifnull +206 -> 3835
    //   3632: aload 30
    //   3634: ldc_w 1153
    //   3637: invokevirtual 348	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3640: ifeq +195 -> 3835
    //   3643: new 1155	java/util/zip/InflaterInputStream
    //   3646: dup
    //   3647: aload 31
    //   3649: new 1157	java/util/zip/Inflater
    //   3652: dup
    //   3653: iconst_1
    //   3654: invokespecial 1159	java/util/zip/Inflater:<init>	(Z)V
    //   3657: invokespecial 1162	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Inflater;)V
    //   3660: astore 30
    //   3662: goto -384 -> 3278
    //   3665: astore 35
    //   3667: aload 31
    //   3669: astore 30
    //   3671: aload 34
    //   3673: astore 33
    //   3675: aload 35
    //   3677: astore 31
    //   3679: iload 5
    //   3681: istore 7
    //   3683: aload 31
    //   3685: instanceof 1164
    //   3688: ifne +11 -> 3699
    //   3691: aload 31
    //   3693: instanceof 1166
    //   3696: ifeq +1418 -> 5114
    //   3699: aload_0
    //   3700: ldc_w 1167
    //   3703: putfield 83	com/tencent/smtt/sdk/m:n	I
    //   3706: aload_0
    //   3707: lconst_0
    //   3708: invokespecial 1169	com/tencent/smtt/sdk/m:a	(J)V
    //   3711: aload_0
    //   3712: bipush 103
    //   3714: aload_0
    //   3715: aload 31
    //   3717: invokespecial 560	com/tencent/smtt/sdk/m:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3720: iconst_0
    //   3721: invokespecial 562	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   3724: lload 10
    //   3726: lstore 16
    //   3728: iload 7
    //   3730: istore 6
    //   3732: lload 10
    //   3734: lstore 12
    //   3736: aload_0
    //   3737: aload 33
    //   3739: invokespecial 805	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   3742: lload 10
    //   3744: lstore 16
    //   3746: iload 7
    //   3748: istore 6
    //   3750: lload 10
    //   3752: lstore 12
    //   3754: aload_0
    //   3755: aload 32
    //   3757: invokespecial 805	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   3760: lload 10
    //   3762: lstore 16
    //   3764: iload 7
    //   3766: istore 6
    //   3768: lload 10
    //   3770: lstore 12
    //   3772: aload_0
    //   3773: aload 30
    //   3775: invokespecial 805	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   3778: lload 10
    //   3780: lstore 14
    //   3782: iload 7
    //   3784: istore 5
    //   3786: iload_1
    //   3787: ifne -3254 -> 533
    //   3790: aload_0
    //   3791: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   3794: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3797: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   3800: ldc_w 1027
    //   3803: lload 10
    //   3805: invokestatic 1055	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3808: invokeinterface 597 3 0
    //   3813: pop
    //   3814: aload_0
    //   3815: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   3818: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3821: invokevirtual 604	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   3824: lload 10
    //   3826: lstore 14
    //   3828: iload 7
    //   3830: istore 5
    //   3832: goto -3299 -> 533
    //   3835: aload 31
    //   3837: astore 30
    //   3839: goto -561 -> 3278
    //   3842: new 163	java/io/File
    //   3845: dup
    //   3846: aload_0
    //   3847: getfield 146	com/tencent/smtt/sdk/m:k	Ljava/io/File;
    //   3850: ldc_w 478
    //   3853: invokespecial 244	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   3856: astore 32
    //   3858: goto -501 -> 3357
    //   3861: astore 32
    //   3863: aload 31
    //   3865: astore 33
    //   3867: iload 5
    //   3869: istore 7
    //   3871: aload 32
    //   3873: astore 31
    //   3875: aload 30
    //   3877: astore 32
    //   3879: aload 33
    //   3881: astore 30
    //   3883: aload 34
    //   3885: astore 33
    //   3887: goto -204 -> 3683
    //   3890: iload 5
    //   3892: istore 6
    //   3894: lload 10
    //   3896: lstore 18
    //   3898: iload 5
    //   3900: istore 8
    //   3902: lload 10
    //   3904: lstore 20
    //   3906: aload 30
    //   3908: aload 35
    //   3910: iconst_0
    //   3911: sipush 8192
    //   3914: invokevirtual 1175	java/io/InputStream:read	([BII)I
    //   3917: istore 4
    //   3919: iload 4
    //   3921: ifgt +199 -> 4120
    //   3924: iload 5
    //   3926: istore 6
    //   3928: lload 10
    //   3930: lstore 18
    //   3932: iload 5
    //   3934: istore 8
    //   3936: lload 10
    //   3938: lstore 20
    //   3940: aload_0
    //   3941: getfield 89	com/tencent/smtt/sdk/m:b	[Ljava/lang/String;
    //   3944: ifnull +93 -> 4037
    //   3947: iload 5
    //   3949: istore 6
    //   3951: lload 10
    //   3953: lstore 18
    //   3955: iload 5
    //   3957: istore 8
    //   3959: lload 10
    //   3961: lstore 20
    //   3963: aload_0
    //   3964: iconst_1
    //   3965: iload 9
    //   3967: invokespecial 957	com/tencent/smtt/sdk/m:c	(ZZ)Z
    //   3970: ifne +67 -> 4037
    //   3973: iload_1
    //   3974: ifne +36 -> 4010
    //   3977: iload 5
    //   3979: istore 6
    //   3981: lload 10
    //   3983: lstore 18
    //   3985: iload 5
    //   3987: istore 8
    //   3989: lload 10
    //   3991: lstore 20
    //   3993: aload_0
    //   3994: iconst_0
    //   3995: invokevirtual 1112	com/tencent/smtt/sdk/m:a	(Z)Z
    //   3998: ifeq +12 -> 4010
    //   4001: iconst_1
    //   4002: istore_3
    //   4003: iload 5
    //   4005: istore 7
    //   4007: goto -511 -> 3496
    //   4010: iload 5
    //   4012: istore 6
    //   4014: lload 10
    //   4016: lstore 18
    //   4018: iload 5
    //   4020: istore 8
    //   4022: lload 10
    //   4024: lstore 20
    //   4026: aload_0
    //   4027: iconst_1
    //   4028: putfield 685	com/tencent/smtt/sdk/m:t	Z
    //   4031: iconst_0
    //   4032: istore 7
    //   4034: goto -538 -> 3496
    //   4037: iload 5
    //   4039: istore 6
    //   4041: lload 10
    //   4043: lstore 18
    //   4045: iload 5
    //   4047: istore 8
    //   4049: lload 10
    //   4051: lstore 20
    //   4053: aload_0
    //   4054: iconst_1
    //   4055: putfield 685	com/tencent/smtt/sdk/m:t	Z
    //   4058: iload 5
    //   4060: istore 7
    //   4062: iload 5
    //   4064: istore 6
    //   4066: lload 10
    //   4068: lstore 18
    //   4070: iload 5
    //   4072: istore 8
    //   4074: lload 10
    //   4076: lstore 20
    //   4078: aload_0
    //   4079: getfield 89	com/tencent/smtt/sdk/m:b	[Ljava/lang/String;
    //   4082: ifnull +6 -> 4088
    //   4085: iconst_1
    //   4086: istore 7
    //   4088: iload 7
    //   4090: istore 6
    //   4092: lload 10
    //   4094: lstore 18
    //   4096: iload 7
    //   4098: istore 8
    //   4100: lload 10
    //   4102: lstore 20
    //   4104: aload_0
    //   4105: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   4108: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4111: sipush -311
    //   4114: invokevirtual 949	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4117: goto -621 -> 3496
    //   4120: iload 5
    //   4122: istore 6
    //   4124: lload 10
    //   4126: lstore 18
    //   4128: iload 5
    //   4130: istore 8
    //   4132: lload 10
    //   4134: lstore 20
    //   4136: aload 33
    //   4138: aload 35
    //   4140: iconst_0
    //   4141: iload 4
    //   4143: invokevirtual 1179	java/io/FileOutputStream:write	([BII)V
    //   4146: iload 5
    //   4148: istore 6
    //   4150: lload 10
    //   4152: lstore 18
    //   4154: iload 5
    //   4156: istore 8
    //   4158: lload 10
    //   4160: lstore 20
    //   4162: aload 33
    //   4164: invokevirtual 1182	java/io/FileOutputStream:flush	()V
    //   4167: lload 10
    //   4169: lstore 12
    //   4171: iload_1
    //   4172: ifne +274 -> 4446
    //   4175: iload 4
    //   4177: i2l
    //   4178: lload 10
    //   4180: ladd
    //   4181: lstore 10
    //   4183: lload 10
    //   4185: lload 28
    //   4187: lcmp
    //   4188: iflt +92 -> 4280
    //   4191: lload 10
    //   4193: lstore 12
    //   4195: lload 10
    //   4197: lstore 18
    //   4199: ldc 220
    //   4201: ldc_w 1065
    //   4204: iconst_1
    //   4205: invokestatic 999	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   4208: lload 10
    //   4210: lstore 12
    //   4212: lload 10
    //   4214: lstore 18
    //   4216: aload_0
    //   4217: bipush 112
    //   4219: new 118	java/lang/StringBuilder
    //   4222: dup
    //   4223: ldc_w 1184
    //   4226: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4229: lload 10
    //   4231: invokevirtual 520	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4234: ldc_w 1186
    //   4237: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4240: lload 28
    //   4242: invokevirtual 520	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4245: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4248: iconst_1
    //   4249: invokespecial 562	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   4252: lload 10
    //   4254: lstore 12
    //   4256: lload 10
    //   4258: lstore 18
    //   4260: aload_0
    //   4261: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   4264: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4267: sipush -307
    //   4270: invokevirtual 949	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4273: iload 5
    //   4275: istore 7
    //   4277: goto -781 -> 3496
    //   4280: lload 10
    //   4282: lstore 12
    //   4284: lload 10
    //   4286: lstore 18
    //   4288: aload_0
    //   4289: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   4292: invokestatic 1056	com/tencent/smtt/utils/f:b	(Landroid/content/Context;)Z
    //   4295: ifne +147 -> 4442
    //   4298: lload 10
    //   4300: lstore 12
    //   4302: lload 10
    //   4304: lstore 18
    //   4306: ldc 220
    //   4308: ldc_w 1188
    //   4311: iconst_1
    //   4312: invokestatic 999	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   4315: lload 10
    //   4317: lstore 12
    //   4319: lload 10
    //   4321: lstore 18
    //   4323: aload_0
    //   4324: bipush 105
    //   4326: new 118	java/lang/StringBuilder
    //   4329: dup
    //   4330: ldc_w 1190
    //   4333: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4336: invokestatic 1192	com/tencent/smtt/utils/r:a	()J
    //   4339: invokevirtual 520	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4342: ldc_w 1194
    //   4345: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4348: aload_0
    //   4349: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   4352: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4355: invokevirtual 1197	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   4358: invokevirtual 520	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4361: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4364: iconst_1
    //   4365: invokespecial 562	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   4368: lload 10
    //   4370: lstore 12
    //   4372: lload 10
    //   4374: lstore 18
    //   4376: aload_0
    //   4377: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   4380: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4383: sipush -308
    //   4386: invokevirtual 949	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4389: iload 5
    //   4391: istore 7
    //   4393: goto -897 -> 3496
    //   4396: astore 32
    //   4398: lload 12
    //   4400: lstore 10
    //   4402: aload_0
    //   4403: aload 33
    //   4405: invokespecial 805	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   4408: aload_0
    //   4409: aload 30
    //   4411: invokespecial 805	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   4414: aload_0
    //   4415: aload 31
    //   4417: invokespecial 805	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   4420: ldc_w 973
    //   4423: invokestatic 153	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4426: aload 32
    //   4428: athrow
    //   4429: astore 30
    //   4431: lload 10
    //   4433: lstore 16
    //   4435: iload 5
    //   4437: istore 7
    //   4439: goto -2109 -> 2330
    //   4442: lload 10
    //   4444: lstore 12
    //   4446: iload 4
    //   4448: i2l
    //   4449: lstore 10
    //   4451: iload 5
    //   4453: istore 6
    //   4455: lload 12
    //   4457: lstore 18
    //   4459: iload 5
    //   4461: istore 8
    //   4463: lload 12
    //   4465: lstore 20
    //   4467: aload_0
    //   4468: lload 24
    //   4470: lload 10
    //   4472: invokespecial 1199	com/tencent/smtt/sdk/m:a	(JJ)J
    //   4475: lstore 24
    //   4477: iload 5
    //   4479: istore 6
    //   4481: lload 12
    //   4483: lstore 18
    //   4485: iload 5
    //   4487: istore 8
    //   4489: lload 12
    //   4491: lstore 20
    //   4493: invokestatic 188	java/lang/System:currentTimeMillis	()J
    //   4496: lstore 26
    //   4498: lload 22
    //   4500: iload 4
    //   4502: i2l
    //   4503: ladd
    //   4504: lstore 22
    //   4506: lload 26
    //   4508: lload 16
    //   4510: lsub
    //   4511: ldc2_w 1200
    //   4514: lcmp
    //   4515: ifle +2508 -> 7023
    //   4518: iload 5
    //   4520: istore 6
    //   4522: lload 12
    //   4524: lstore 18
    //   4526: iload 5
    //   4528: istore 8
    //   4530: lload 12
    //   4532: lstore 20
    //   4534: ldc 220
    //   4536: new 118	java/lang/StringBuilder
    //   4539: dup
    //   4540: ldc_w 1203
    //   4543: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4546: lload 22
    //   4548: invokevirtual 520	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4551: ldc_w 1108
    //   4554: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4557: aload_0
    //   4558: getfield 677	com/tencent/smtt/sdk/m:m	J
    //   4561: invokevirtual 520	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4564: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4567: iconst_1
    //   4568: invokestatic 999	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   4571: iload 5
    //   4573: istore 6
    //   4575: lload 12
    //   4577: lstore 18
    //   4579: iload 5
    //   4581: istore 8
    //   4583: lload 12
    //   4585: lstore 20
    //   4587: getstatic 609	com/tencent/smtt/sdk/QbSdk:l	Lcom/tencent/smtt/sdk/TbsListener;
    //   4590: ifnull +94 -> 4684
    //   4593: iload 5
    //   4595: istore 6
    //   4597: lload 12
    //   4599: lstore 18
    //   4601: iload 5
    //   4603: istore 8
    //   4605: lload 12
    //   4607: lstore 20
    //   4609: lload 22
    //   4611: l2d
    //   4612: aload_0
    //   4613: getfield 677	com/tencent/smtt/sdk/m:m	J
    //   4616: l2d
    //   4617: ddiv
    //   4618: ldc2_w 1204
    //   4621: dmul
    //   4622: d2i
    //   4623: istore 4
    //   4625: iload 5
    //   4627: istore 6
    //   4629: lload 12
    //   4631: lstore 18
    //   4633: iload 5
    //   4635: istore 8
    //   4637: lload 12
    //   4639: lstore 20
    //   4641: ldc_w 398
    //   4644: ldc_w 1207
    //   4647: iload 4
    //   4649: invokestatic 622	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   4652: invokevirtual 469	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   4655: invokestatic 1209	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   4658: iload 5
    //   4660: istore 6
    //   4662: lload 12
    //   4664: lstore 18
    //   4666: iload 5
    //   4668: istore 8
    //   4670: lload 12
    //   4672: lstore 20
    //   4674: getstatic 609	com/tencent/smtt/sdk/QbSdk:l	Lcom/tencent/smtt/sdk/TbsListener;
    //   4677: iload 4
    //   4679: invokeinterface 1212 2 0
    //   4684: iload_1
    //   4685: ifne +2327 -> 7012
    //   4688: lload 22
    //   4690: lload 14
    //   4692: lsub
    //   4693: ldc2_w 1213
    //   4696: lcmp
    //   4697: ifle +2315 -> 7012
    //   4700: iload 5
    //   4702: istore 6
    //   4704: lload 12
    //   4706: lstore 18
    //   4708: iload 5
    //   4710: istore 8
    //   4712: lload 12
    //   4714: lstore 20
    //   4716: aload_0
    //   4717: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   4720: invokestatic 239	com/tencent/smtt/sdk/TbsDownloader:getOverSea	(Landroid/content/Context;)Z
    //   4723: ifne +211 -> 4934
    //   4726: iload 5
    //   4728: istore 6
    //   4730: lload 12
    //   4732: lstore 18
    //   4734: iload 5
    //   4736: istore 8
    //   4738: lload 12
    //   4740: lstore 20
    //   4742: aload_0
    //   4743: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   4746: invokestatic 713	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   4749: iconst_3
    //   4750: if_icmpne +29 -> 4779
    //   4753: iload 5
    //   4755: istore 6
    //   4757: lload 12
    //   4759: lstore 18
    //   4761: iload 5
    //   4763: istore 8
    //   4765: lload 12
    //   4767: lstore 20
    //   4769: aload_0
    //   4770: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   4773: invokestatic 713	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   4776: ifne +158 -> 4934
    //   4779: iload 5
    //   4781: istore 6
    //   4783: lload 12
    //   4785: lstore 18
    //   4787: iload 5
    //   4789: istore 8
    //   4791: lload 12
    //   4793: lstore 20
    //   4795: invokestatic 933	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   4798: ifne +136 -> 4934
    //   4801: iload 5
    //   4803: istore 6
    //   4805: lload 12
    //   4807: lstore 18
    //   4809: iload 5
    //   4811: istore 8
    //   4813: lload 12
    //   4815: lstore 20
    //   4817: aload_0
    //   4818: invokevirtual 1102	com/tencent/smtt/sdk/m:b	()V
    //   4821: iload 5
    //   4823: istore 6
    //   4825: lload 12
    //   4827: lstore 18
    //   4829: iload 5
    //   4831: istore 8
    //   4833: lload 12
    //   4835: lstore 20
    //   4837: getstatic 609	com/tencent/smtt/sdk/QbSdk:l	Lcom/tencent/smtt/sdk/TbsListener;
    //   4840: ifnull +29 -> 4869
    //   4843: iload 5
    //   4845: istore 6
    //   4847: lload 12
    //   4849: lstore 18
    //   4851: iload 5
    //   4853: istore 8
    //   4855: lload 12
    //   4857: lstore 20
    //   4859: getstatic 609	com/tencent/smtt/sdk/QbSdk:l	Lcom/tencent/smtt/sdk/TbsListener;
    //   4862: bipush 111
    //   4864: invokeinterface 614 2 0
    //   4869: iload 5
    //   4871: istore 6
    //   4873: lload 12
    //   4875: lstore 18
    //   4877: iload 5
    //   4879: istore 8
    //   4881: lload 12
    //   4883: lstore 20
    //   4885: ldc 220
    //   4887: ldc_w 1216
    //   4890: iconst_0
    //   4891: invokestatic 999	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   4894: iload 5
    //   4896: istore 6
    //   4898: lload 12
    //   4900: lstore 18
    //   4902: iload 5
    //   4904: istore 8
    //   4906: lload 12
    //   4908: lstore 20
    //   4910: aload_0
    //   4911: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   4914: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4917: sipush -304
    //   4920: invokevirtual 949	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4923: lload 12
    //   4925: lstore 10
    //   4927: iload 5
    //   4929: istore 7
    //   4931: goto -1435 -> 3496
    //   4934: lload 22
    //   4936: lstore 10
    //   4938: lload 26
    //   4940: lstore 14
    //   4942: lload 14
    //   4944: lstore 16
    //   4946: lload 10
    //   4948: lstore 14
    //   4950: lload 12
    //   4952: lstore 10
    //   4954: goto -1539 -> 3415
    //   4957: aconst_null
    //   4958: astore 34
    //   4960: aconst_null
    //   4961: astore 32
    //   4963: lload 10
    //   4965: lstore 14
    //   4967: lload 14
    //   4969: lstore 16
    //   4971: iload 5
    //   4973: istore 6
    //   4975: lload 14
    //   4977: lstore 12
    //   4979: aload_0
    //   4980: aload 32
    //   4982: invokespecial 805	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   4985: lload 14
    //   4987: lstore 16
    //   4989: iload 5
    //   4991: istore 6
    //   4993: lload 14
    //   4995: lstore 12
    //   4997: aload_0
    //   4998: aload 34
    //   5000: invokespecial 805	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   5003: lload 14
    //   5005: lstore 16
    //   5007: iload 5
    //   5009: istore 6
    //   5011: lload 14
    //   5013: lstore 12
    //   5015: aload_0
    //   5016: aload 31
    //   5018: invokespecial 805	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   5021: lload 14
    //   5023: lstore 16
    //   5025: iload 5
    //   5027: istore 6
    //   5029: lload 14
    //   5031: lstore 12
    //   5033: aload_0
    //   5034: getfield 685	com/tencent/smtt/sdk/m:t	Z
    //   5037: ifne +28 -> 5065
    //   5040: lload 14
    //   5042: lstore 16
    //   5044: iload 5
    //   5046: istore 6
    //   5048: lload 14
    //   5050: lstore 12
    //   5052: aload_0
    //   5053: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5056: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5059: sipush -319
    //   5062: invokevirtual 949	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5065: iload 5
    //   5067: istore 6
    //   5069: iload_1
    //   5070: ifne -4488 -> 582
    //   5073: aload_0
    //   5074: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5077: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5080: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5083: ldc_w 1027
    //   5086: lload 14
    //   5088: invokestatic 1055	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5091: invokeinterface 597 3 0
    //   5096: pop
    //   5097: aload_0
    //   5098: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5101: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5104: invokevirtual 604	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5107: iload 5
    //   5109: istore 6
    //   5111: goto -4529 -> 582
    //   5114: iload_1
    //   5115: ifne +174 -> 5289
    //   5118: aload_0
    //   5119: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5122: invokestatic 1056	com/tencent/smtt/utils/f:b	(Landroid/content/Context;)Z
    //   5125: ifne +164 -> 5289
    //   5128: aload_0
    //   5129: bipush 105
    //   5131: new 118	java/lang/StringBuilder
    //   5134: dup
    //   5135: ldc_w 1190
    //   5138: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   5141: invokestatic 1192	com/tencent/smtt/utils/r:a	()J
    //   5144: invokevirtual 520	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5147: ldc_w 1194
    //   5150: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5153: aload_0
    //   5154: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5157: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5160: invokevirtual 1197	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   5163: invokevirtual 520	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5166: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5169: iconst_1
    //   5170: invokespecial 562	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   5173: aload_0
    //   5174: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5177: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5180: sipush -308
    //   5183: invokevirtual 949	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5186: lload 10
    //   5188: lstore 16
    //   5190: iload 7
    //   5192: istore 6
    //   5194: lload 10
    //   5196: lstore 12
    //   5198: aload_0
    //   5199: aload 33
    //   5201: invokespecial 805	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   5204: lload 10
    //   5206: lstore 16
    //   5208: iload 7
    //   5210: istore 6
    //   5212: lload 10
    //   5214: lstore 12
    //   5216: aload_0
    //   5217: aload 32
    //   5219: invokespecial 805	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   5222: lload 10
    //   5224: lstore 16
    //   5226: iload 7
    //   5228: istore 6
    //   5230: lload 10
    //   5232: lstore 12
    //   5234: aload_0
    //   5235: aload 30
    //   5237: invokespecial 805	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   5240: iload 7
    //   5242: istore 6
    //   5244: iload_1
    //   5245: ifne -4663 -> 582
    //   5248: aload_0
    //   5249: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5252: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5255: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5258: ldc_w 1027
    //   5261: lload 10
    //   5263: invokestatic 1055	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5266: invokeinterface 597 3 0
    //   5271: pop
    //   5272: aload_0
    //   5273: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5276: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5279: invokevirtual 604	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5282: iload 7
    //   5284: istore 6
    //   5286: goto -4704 -> 582
    //   5289: aload_0
    //   5290: lconst_0
    //   5291: invokespecial 1169	com/tencent/smtt/sdk/m:a	(J)V
    //   5294: aload_0
    //   5295: invokespecial 1218	com/tencent/smtt/sdk/m:i	()Z
    //   5298: ifne +127 -> 5425
    //   5301: aload_0
    //   5302: bipush 106
    //   5304: aload_0
    //   5305: aload 31
    //   5307: invokespecial 560	com/tencent/smtt/sdk/m:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   5310: iconst_0
    //   5311: invokespecial 562	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   5314: lload 10
    //   5316: lstore 16
    //   5318: iload 7
    //   5320: istore 6
    //   5322: lload 10
    //   5324: lstore 12
    //   5326: aload_0
    //   5327: aload 33
    //   5329: invokespecial 805	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   5332: lload 10
    //   5334: lstore 16
    //   5336: iload 7
    //   5338: istore 6
    //   5340: lload 10
    //   5342: lstore 12
    //   5344: aload_0
    //   5345: aload 32
    //   5347: invokespecial 805	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   5350: lload 10
    //   5352: lstore 16
    //   5354: iload 7
    //   5356: istore 6
    //   5358: lload 10
    //   5360: lstore 12
    //   5362: aload_0
    //   5363: aload 30
    //   5365: invokespecial 805	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   5368: lload 10
    //   5370: lstore 14
    //   5372: iload 7
    //   5374: istore 5
    //   5376: iload_1
    //   5377: ifne -4844 -> 533
    //   5380: aload_0
    //   5381: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5384: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5387: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5390: ldc_w 1027
    //   5393: lload 10
    //   5395: invokestatic 1055	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5398: invokeinterface 597 3 0
    //   5403: pop
    //   5404: aload_0
    //   5405: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5408: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5411: invokevirtual 604	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5414: lload 10
    //   5416: lstore 14
    //   5418: iload 7
    //   5420: istore 5
    //   5422: goto -4889 -> 533
    //   5425: aload_0
    //   5426: bipush 104
    //   5428: aload_0
    //   5429: aload 31
    //   5431: invokespecial 560	com/tencent/smtt/sdk/m:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   5434: iconst_0
    //   5435: invokespecial 562	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   5438: goto -124 -> 5314
    //   5441: astore 35
    //   5443: aload 32
    //   5445: astore 31
    //   5447: aload 30
    //   5449: astore 34
    //   5451: iload 7
    //   5453: istore 5
    //   5455: aload 35
    //   5457: astore 32
    //   5459: aload 31
    //   5461: astore 30
    //   5463: aload 34
    //   5465: astore 31
    //   5467: goto -1065 -> 4402
    //   5470: iload_3
    //   5471: sipush 300
    //   5474: if_icmplt +237 -> 5711
    //   5477: iload_3
    //   5478: sipush 307
    //   5481: if_icmpgt +230 -> 5711
    //   5484: lload 10
    //   5486: lstore 16
    //   5488: iload 5
    //   5490: istore 6
    //   5492: lload 10
    //   5494: lstore 12
    //   5496: aload_0
    //   5497: getfield 408	com/tencent/smtt/sdk/m:u	Ljava/net/HttpURLConnection;
    //   5500: ldc_w 1220
    //   5503: invokevirtual 1223	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   5506: astore 30
    //   5508: lload 10
    //   5510: lstore 16
    //   5512: iload 5
    //   5514: istore 6
    //   5516: lload 10
    //   5518: lstore 12
    //   5520: aload 30
    //   5522: invokestatic 835	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5525: ifne +92 -> 5617
    //   5528: lload 10
    //   5530: lstore 16
    //   5532: iload 5
    //   5534: istore 6
    //   5536: lload 10
    //   5538: lstore 12
    //   5540: aload_0
    //   5541: aload 30
    //   5543: putfield 679	com/tencent/smtt/sdk/m:j	Ljava/lang/String;
    //   5546: lload 10
    //   5548: lstore 16
    //   5550: iload 5
    //   5552: istore 6
    //   5554: lload 10
    //   5556: lstore 12
    //   5558: aload_0
    //   5559: aload_0
    //   5560: getfield 673	com/tencent/smtt/sdk/m:r	I
    //   5563: iconst_1
    //   5564: iadd
    //   5565: putfield 673	com/tencent/smtt/sdk/m:r	I
    //   5568: lload 10
    //   5570: lstore 14
    //   5572: iload_1
    //   5573: ifne -5040 -> 533
    //   5576: aload_0
    //   5577: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5580: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5583: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5586: ldc_w 1027
    //   5589: lload 10
    //   5591: invokestatic 1055	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5594: invokeinterface 597 3 0
    //   5599: pop
    //   5600: aload_0
    //   5601: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5604: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5607: invokevirtual 604	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5610: lload 10
    //   5612: lstore 14
    //   5614: goto -5081 -> 533
    //   5617: lload 10
    //   5619: lstore 16
    //   5621: iload 5
    //   5623: istore 6
    //   5625: lload 10
    //   5627: lstore 12
    //   5629: aload_0
    //   5630: bipush 124
    //   5632: aconst_null
    //   5633: iconst_1
    //   5634: invokespecial 562	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   5637: lload 10
    //   5639: lstore 16
    //   5641: iload 5
    //   5643: istore 6
    //   5645: lload 10
    //   5647: lstore 12
    //   5649: aload_0
    //   5650: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5653: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5656: sipush -312
    //   5659: invokevirtual 949	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5662: iload 5
    //   5664: istore 6
    //   5666: iload_1
    //   5667: ifne -5085 -> 582
    //   5670: aload_0
    //   5671: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5674: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5677: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5680: ldc_w 1027
    //   5683: lload 10
    //   5685: invokestatic 1055	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5688: invokeinterface 597 3 0
    //   5693: pop
    //   5694: aload_0
    //   5695: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5698: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5701: invokevirtual 604	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5704: iload 5
    //   5706: istore 6
    //   5708: goto -5126 -> 582
    //   5711: lload 10
    //   5713: lstore 16
    //   5715: iload 5
    //   5717: istore 6
    //   5719: lload 10
    //   5721: lstore 12
    //   5723: aload_0
    //   5724: bipush 102
    //   5726: iload_3
    //   5727: invokestatic 622	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   5730: iconst_0
    //   5731: invokespecial 562	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   5734: iload_3
    //   5735: sipush 416
    //   5738: if_icmpne +193 -> 5931
    //   5741: lload 10
    //   5743: lstore 16
    //   5745: iload 5
    //   5747: istore 6
    //   5749: lload 10
    //   5751: lstore 12
    //   5753: aload_0
    //   5754: iconst_1
    //   5755: iload 9
    //   5757: invokespecial 957	com/tencent/smtt/sdk/m:c	(ZZ)Z
    //   5760: ifeq +79 -> 5839
    //   5763: iconst_1
    //   5764: istore 6
    //   5766: iconst_1
    //   5767: istore 5
    //   5769: lload 10
    //   5771: lstore 16
    //   5773: lload 10
    //   5775: lstore 12
    //   5777: aload_0
    //   5778: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5781: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5784: sipush -214
    //   5787: invokevirtual 949	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5790: iload 5
    //   5792: istore 6
    //   5794: iload_1
    //   5795: ifne -5213 -> 582
    //   5798: aload_0
    //   5799: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5802: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5805: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5808: ldc_w 1027
    //   5811: lload 10
    //   5813: invokestatic 1055	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5816: invokeinterface 597 3 0
    //   5821: pop
    //   5822: aload_0
    //   5823: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5826: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5829: invokevirtual 604	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5832: iload 5
    //   5834: istore 6
    //   5836: goto -5254 -> 582
    //   5839: lload 10
    //   5841: lstore 16
    //   5843: iload 5
    //   5845: istore 6
    //   5847: lload 10
    //   5849: lstore 12
    //   5851: aload_0
    //   5852: iconst_0
    //   5853: invokespecial 959	com/tencent/smtt/sdk/m:d	(Z)Z
    //   5856: pop
    //   5857: lload 10
    //   5859: lstore 16
    //   5861: iload 5
    //   5863: istore 6
    //   5865: lload 10
    //   5867: lstore 12
    //   5869: aload_0
    //   5870: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5873: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5876: sipush -313
    //   5879: invokevirtual 949	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5882: iload 5
    //   5884: istore 6
    //   5886: iload_1
    //   5887: ifne -5305 -> 582
    //   5890: aload_0
    //   5891: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5894: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5897: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5900: ldc_w 1027
    //   5903: lload 10
    //   5905: invokestatic 1055	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5908: invokeinterface 597 3 0
    //   5913: pop
    //   5914: aload_0
    //   5915: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5918: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5921: invokevirtual 604	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5924: iload 5
    //   5926: istore 6
    //   5928: goto -5346 -> 582
    //   5931: iload_3
    //   5932: sipush 403
    //   5935: if_icmpeq +10 -> 5945
    //   5938: iload_3
    //   5939: sipush 406
    //   5942: if_icmpne +100 -> 6042
    //   5945: lload 10
    //   5947: lstore 16
    //   5949: iload 5
    //   5951: istore 6
    //   5953: lload 10
    //   5955: lstore 12
    //   5957: aload_0
    //   5958: getfield 677	com/tencent/smtt/sdk/m:m	J
    //   5961: ldc2_w 674
    //   5964: lcmp
    //   5965: ifne +77 -> 6042
    //   5968: lload 10
    //   5970: lstore 16
    //   5972: iload 5
    //   5974: istore 6
    //   5976: lload 10
    //   5978: lstore 12
    //   5980: aload_0
    //   5981: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5984: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5987: sipush -314
    //   5990: invokevirtual 949	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5993: iload 5
    //   5995: istore 6
    //   5997: iload_1
    //   5998: ifne -5416 -> 582
    //   6001: aload_0
    //   6002: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6005: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6008: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6011: ldc_w 1027
    //   6014: lload 10
    //   6016: invokestatic 1055	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6019: invokeinterface 597 3 0
    //   6024: pop
    //   6025: aload_0
    //   6026: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6029: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6032: invokevirtual 604	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6035: iload 5
    //   6037: istore 6
    //   6039: goto -5457 -> 582
    //   6042: iload_3
    //   6043: sipush 202
    //   6046: if_icmpne +52 -> 6098
    //   6049: lload 10
    //   6051: lstore 14
    //   6053: iload_1
    //   6054: ifne -5521 -> 533
    //   6057: aload_0
    //   6058: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6061: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6064: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6067: ldc_w 1027
    //   6070: lload 10
    //   6072: invokestatic 1055	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6075: invokeinterface 597 3 0
    //   6080: pop
    //   6081: aload_0
    //   6082: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6085: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6088: invokevirtual 604	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6091: lload 10
    //   6093: lstore 14
    //   6095: goto -5562 -> 533
    //   6098: lload 10
    //   6100: lstore 16
    //   6102: iload 5
    //   6104: istore 6
    //   6106: lload 10
    //   6108: lstore 12
    //   6110: aload_0
    //   6111: getfield 287	com/tencent/smtt/sdk/m:q	I
    //   6114: aload_0
    //   6115: getfield 87	com/tencent/smtt/sdk/m:C	I
    //   6118: if_icmpge +181 -> 6299
    //   6121: iload_3
    //   6122: sipush 503
    //   6125: if_icmpne +174 -> 6299
    //   6128: lload 10
    //   6130: lstore 16
    //   6132: iload 5
    //   6134: istore 6
    //   6136: lload 10
    //   6138: lstore 12
    //   6140: aload_0
    //   6141: aload_0
    //   6142: getfield 408	com/tencent/smtt/sdk/m:u	Ljava/net/HttpURLConnection;
    //   6145: ldc_w 1225
    //   6148: invokevirtual 1223	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   6151: invokestatic 1229	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   6154: invokespecial 1169	com/tencent/smtt/sdk/m:a	(J)V
    //   6157: lload 10
    //   6159: lstore 16
    //   6161: iload 5
    //   6163: istore 6
    //   6165: lload 10
    //   6167: lstore 12
    //   6169: aload_0
    //   6170: getfield 683	com/tencent/smtt/sdk/m:s	Z
    //   6173: ifeq +77 -> 6250
    //   6176: lload 10
    //   6178: lstore 16
    //   6180: iload 5
    //   6182: istore 6
    //   6184: lload 10
    //   6186: lstore 12
    //   6188: aload_0
    //   6189: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6192: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6195: sipush -309
    //   6198: invokevirtual 949	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6201: iload 5
    //   6203: istore 6
    //   6205: iload_1
    //   6206: ifne -5624 -> 582
    //   6209: aload_0
    //   6210: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6213: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6216: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6219: ldc_w 1027
    //   6222: lload 10
    //   6224: invokestatic 1055	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6227: invokeinterface 597 3 0
    //   6232: pop
    //   6233: aload_0
    //   6234: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6237: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6240: invokevirtual 604	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6243: iload 5
    //   6245: istore 6
    //   6247: goto -5665 -> 582
    //   6250: lload 10
    //   6252: lstore 14
    //   6254: iload_1
    //   6255: ifne -5722 -> 533
    //   6258: aload_0
    //   6259: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6262: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6265: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6268: ldc_w 1027
    //   6271: lload 10
    //   6273: invokestatic 1055	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6276: invokeinterface 597 3 0
    //   6281: pop
    //   6282: aload_0
    //   6283: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6286: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6289: invokevirtual 604	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6292: lload 10
    //   6294: lstore 14
    //   6296: goto -5763 -> 533
    //   6299: lload 10
    //   6301: lstore 16
    //   6303: iload 5
    //   6305: istore 6
    //   6307: lload 10
    //   6309: lstore 12
    //   6311: aload_0
    //   6312: getfield 287	com/tencent/smtt/sdk/m:q	I
    //   6315: aload_0
    //   6316: getfield 87	com/tencent/smtt/sdk/m:C	I
    //   6319: if_icmpge +190 -> 6509
    //   6322: iload_3
    //   6323: sipush 408
    //   6326: if_icmpeq +24 -> 6350
    //   6329: iload_3
    //   6330: sipush 504
    //   6333: if_icmpeq +17 -> 6350
    //   6336: iload_3
    //   6337: sipush 502
    //   6340: if_icmpeq +10 -> 6350
    //   6343: iload_3
    //   6344: sipush 408
    //   6347: if_icmpne +162 -> 6509
    //   6350: lload 10
    //   6352: lstore 16
    //   6354: iload 5
    //   6356: istore 6
    //   6358: lload 10
    //   6360: lstore 12
    //   6362: aload_0
    //   6363: lconst_0
    //   6364: invokespecial 1169	com/tencent/smtt/sdk/m:a	(J)V
    //   6367: lload 10
    //   6369: lstore 16
    //   6371: iload 5
    //   6373: istore 6
    //   6375: lload 10
    //   6377: lstore 12
    //   6379: aload_0
    //   6380: getfield 683	com/tencent/smtt/sdk/m:s	Z
    //   6383: ifeq +77 -> 6460
    //   6386: lload 10
    //   6388: lstore 16
    //   6390: iload 5
    //   6392: istore 6
    //   6394: lload 10
    //   6396: lstore 12
    //   6398: aload_0
    //   6399: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6402: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6405: sipush -309
    //   6408: invokevirtual 949	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6411: iload 5
    //   6413: istore 6
    //   6415: iload_1
    //   6416: ifne -5834 -> 582
    //   6419: aload_0
    //   6420: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6423: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6426: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6429: ldc_w 1027
    //   6432: lload 10
    //   6434: invokestatic 1055	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6437: invokeinterface 597 3 0
    //   6442: pop
    //   6443: aload_0
    //   6444: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6447: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6450: invokevirtual 604	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6453: iload 5
    //   6455: istore 6
    //   6457: goto -5875 -> 582
    //   6460: lload 10
    //   6462: lstore 14
    //   6464: iload_1
    //   6465: ifne -5932 -> 533
    //   6468: aload_0
    //   6469: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6472: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6475: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6478: ldc_w 1027
    //   6481: lload 10
    //   6483: invokestatic 1055	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6486: invokeinterface 597 3 0
    //   6491: pop
    //   6492: aload_0
    //   6493: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6496: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6499: invokevirtual 604	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6502: lload 10
    //   6504: lstore 14
    //   6506: goto -5973 -> 533
    //   6509: lload 10
    //   6511: lstore 16
    //   6513: iload 5
    //   6515: istore 6
    //   6517: lload 10
    //   6519: lstore 12
    //   6521: aload_0
    //   6522: invokespecial 1078	com/tencent/smtt/sdk/m:j	()J
    //   6525: lconst_0
    //   6526: lcmp
    //   6527: ifgt +95 -> 6622
    //   6530: lload 10
    //   6532: lstore 16
    //   6534: iload 5
    //   6536: istore 6
    //   6538: lload 10
    //   6540: lstore 12
    //   6542: aload_0
    //   6543: getfield 681	com/tencent/smtt/sdk/m:p	Z
    //   6546: ifne +76 -> 6622
    //   6549: iload_3
    //   6550: sipush 410
    //   6553: if_icmpeq +69 -> 6622
    //   6556: lload 10
    //   6558: lstore 16
    //   6560: iload 5
    //   6562: istore 6
    //   6564: lload 10
    //   6566: lstore 12
    //   6568: aload_0
    //   6569: iconst_1
    //   6570: putfield 681	com/tencent/smtt/sdk/m:p	Z
    //   6573: lload 10
    //   6575: lstore 14
    //   6577: iload_1
    //   6578: ifne -6045 -> 533
    //   6581: aload_0
    //   6582: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6585: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6588: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6591: ldc_w 1027
    //   6594: lload 10
    //   6596: invokestatic 1055	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6599: invokeinterface 597 3 0
    //   6604: pop
    //   6605: aload_0
    //   6606: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6609: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6612: invokevirtual 604	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6615: lload 10
    //   6617: lstore 14
    //   6619: goto -6086 -> 533
    //   6622: lload 10
    //   6624: lstore 16
    //   6626: iload 5
    //   6628: istore 6
    //   6630: lload 10
    //   6632: lstore 12
    //   6634: aload_0
    //   6635: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6638: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6641: sipush -315
    //   6644: invokevirtual 949	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6647: iload 5
    //   6649: istore 6
    //   6651: iload_1
    //   6652: ifne -6070 -> 582
    //   6655: aload_0
    //   6656: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6659: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6662: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6665: ldc_w 1027
    //   6668: lload 10
    //   6670: invokestatic 1055	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6673: invokeinterface 597 3 0
    //   6678: pop
    //   6679: aload_0
    //   6680: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6683: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6686: invokevirtual 604	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6689: iload 5
    //   6691: istore 6
    //   6693: goto -6111 -> 582
    //   6696: lload 16
    //   6698: lstore 12
    //   6700: aload_0
    //   6701: lconst_0
    //   6702: invokespecial 1169	com/tencent/smtt/sdk/m:a	(J)V
    //   6705: lload 16
    //   6707: lstore 12
    //   6709: aload_0
    //   6710: bipush 107
    //   6712: aload_0
    //   6713: aload 30
    //   6715: invokespecial 560	com/tencent/smtt/sdk/m:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   6718: iconst_0
    //   6719: invokespecial 562	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   6722: lload 16
    //   6724: lstore 12
    //   6726: aload_0
    //   6727: getfield 683	com/tencent/smtt/sdk/m:s	Z
    //   6730: ifeq -4306 -> 2424
    //   6733: lload 16
    //   6735: lstore 12
    //   6737: aload_0
    //   6738: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6741: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6744: sipush -309
    //   6747: invokevirtual 949	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6750: iload 7
    //   6752: istore 6
    //   6754: iload_1
    //   6755: ifne -6173 -> 582
    //   6758: aload_0
    //   6759: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6762: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6765: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6768: ldc_w 1027
    //   6771: lload 16
    //   6773: invokestatic 1055	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6776: invokeinterface 597 3 0
    //   6781: pop
    //   6782: aload_0
    //   6783: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6786: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6789: invokevirtual 604	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6792: iload 7
    //   6794: istore 6
    //   6796: goto -6214 -> 582
    //   6799: aload_0
    //   6800: iconst_1
    //   6801: iload 9
    //   6803: invokespecial 957	com/tencent/smtt/sdk/m:c	(ZZ)Z
    //   6806: istore_1
    //   6807: goto -6134 -> 673
    //   6810: iconst_0
    //   6811: istore_3
    //   6812: goto -6127 -> 685
    //   6815: iconst_2
    //   6816: istore_3
    //   6817: goto -6109 -> 708
    //   6820: aload_0
    //   6821: getfield 111	com/tencent/smtt/sdk/m:w	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   6824: iconst_0
    //   6825: invokevirtual 1033	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setPatchUpdateFlag	(I)V
    //   6828: goto -6114 -> 714
    //   6831: aload_0
    //   6832: getfield 99	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6835: invokestatic 321	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6838: sipush -318
    //   6841: invokevirtual 949	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6844: aload_0
    //   6845: iconst_0
    //   6846: invokespecial 959	com/tencent/smtt/sdk/m:d	(Z)Z
    //   6849: pop
    //   6850: goto -6089 -> 761
    //   6853: aload 30
    //   6855: getfield 325	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   6858: ldc_w 1231
    //   6861: iconst_0
    //   6862: invokeinterface 333 3 0
    //   6867: istore_3
    //   6868: aload 30
    //   6870: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6873: astore 31
    //   6875: iload_3
    //   6876: iconst_1
    //   6877: iadd
    //   6878: istore_3
    //   6879: aload 31
    //   6881: ldc_w 1231
    //   6884: iload_3
    //   6885: invokestatic 553	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6888: invokeinterface 597 3 0
    //   6893: pop
    //   6894: iload_3
    //   6895: aload 30
    //   6897: invokevirtual 1234	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadFailedMaxRetrytimes	()I
    //   6900: if_icmpne -6091 -> 809
    //   6903: aload_0
    //   6904: getfield 111	com/tencent/smtt/sdk/m:w	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   6907: iconst_2
    //   6908: invokevirtual 1091	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownloadCancel	(I)V
    //   6911: goto -6102 -> 809
    //   6914: iconst_0
    //   6915: istore_3
    //   6916: goto -6090 -> 826
    //   6919: astore 30
    //   6921: goto -4310 -> 2611
    //   6924: astore 32
    //   6926: aconst_null
    //   6927: astore 30
    //   6929: aconst_null
    //   6930: astore 31
    //   6932: aconst_null
    //   6933: astore 33
    //   6935: goto -2533 -> 4402
    //   6938: astore 32
    //   6940: aconst_null
    //   6941: astore 30
    //   6943: aconst_null
    //   6944: astore 33
    //   6946: goto -2544 -> 4402
    //   6949: astore 32
    //   6951: aconst_null
    //   6952: astore 33
    //   6954: goto -2552 -> 4402
    //   6957: astore 32
    //   6959: iload 6
    //   6961: istore 5
    //   6963: lload 18
    //   6965: lstore 10
    //   6967: goto -2565 -> 4402
    //   6970: astore 31
    //   6972: iload 5
    //   6974: istore 7
    //   6976: aload 34
    //   6978: astore 33
    //   6980: goto -3297 -> 3683
    //   6983: astore 32
    //   6985: aload 31
    //   6987: astore 34
    //   6989: lload 20
    //   6991: lstore 10
    //   6993: iload 8
    //   6995: istore 7
    //   6997: aload 32
    //   6999: astore 31
    //   7001: aload 30
    //   7003: astore 32
    //   7005: aload 34
    //   7007: astore 30
    //   7009: goto -3326 -> 3683
    //   7012: lload 14
    //   7014: lstore 10
    //   7016: lload 26
    //   7018: lstore 14
    //   7020: goto -2078 -> 4942
    //   7023: lload 14
    //   7025: lstore 10
    //   7027: lload 16
    //   7029: lstore 14
    //   7031: goto -2089 -> 4942
    //   7034: astore 32
    //   7036: aload 31
    //   7038: astore 34
    //   7040: lload 18
    //   7042: lstore 10
    //   7044: iload 5
    //   7046: istore 7
    //   7048: aload 32
    //   7050: astore 31
    //   7052: aload 30
    //   7054: astore 32
    //   7056: aload 34
    //   7058: astore 30
    //   7060: goto -3377 -> 3683
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	7063	0	this	m
    //   0	7063	1	paramBoolean1	boolean
    //   0	7063	2	paramBoolean2	boolean
    //   85	6831	3	i1	int
    //   3917	761	4	i2	int
    //   499	6546	5	bool1	boolean
    //   535	6425	6	bool2	boolean
    //   2328	4719	7	bool3	boolean
    //   3425	3569	8	bool4	boolean
    //   102	6700	9	bool5	boolean
    //   860	6183	10	l1	long
    //   876	5860	12	l2	long
    //   520	6510	14	l3	long
    //   868	6160	16	l4	long
    //   1021	6020	18	l5	long
    //   3429	3561	20	l6	long
    //   3413	1522	22	l7	long
    //   856	3620	24	l8	long
    //   4496	2521	26	l9	long
    //   496	3745	28	l10	long
    //   182	2033	30	localObject1	Object
    //   2324	257	30	localThrowable1	Throwable
    //   2605	51	30	localObject2	Object
    //   3203	1207	30	localObject3	Object
    //   4429	1019	30	localThrowable2	Throwable
    //   5461	1435	30	localObject4	Object
    //   6919	1	30	localObject5	Object
    //   6927	132	30	localObject6	Object
    //   3235	3696	31	localObject7	Object
    //   6970	16	31	localIOException1	IOException
    //   6999	52	31	localIOException2	IOException
    //   3206	651	32	localObject8	Object
    //   3861	11	32	localIOException3	IOException
    //   3877	1	32	localObject9	Object
    //   4396	31	32	localObject10	Object
    //   4961	497	32	localObject11	Object
    //   6924	1	32	localObject12	Object
    //   6938	1	32	localObject13	Object
    //   6949	1	32	localObject14	Object
    //   6957	1	32	localObject15	Object
    //   6983	15	32	localIOException4	IOException
    //   7003	1	32	localObject16	Object
    //   7034	15	32	localIOException5	IOException
    //   7054	1	32	localObject17	Object
    //   3333	3646	33	localObject18	Object
    //   3200	3857	34	localObject19	Object
    //   3283	1	35	arrayOfByte	byte[]
    //   3665	474	35	localIOException6	IOException
    //   5441	15	35	localObject20	Object
    // Exception table:
    //   from	to	target	type
    //   878	907	2324	java/lang/Throwable
    //   919	927	2324	java/lang/Throwable
    //   939	963	2324	java/lang/Throwable
    //   975	998	2324	java/lang/Throwable
    //   1010	1020	2324	java/lang/Throwable
    //   1039	1049	2324	java/lang/Throwable
    //   1061	1070	2324	java/lang/Throwable
    //   1082	1090	2324	java/lang/Throwable
    //   1102	1115	2324	java/lang/Throwable
    //   1176	1192	2324	java/lang/Throwable
    //   1216	1225	2324	java/lang/Throwable
    //   1237	1245	2324	java/lang/Throwable
    //   1257	1270	2324	java/lang/Throwable
    //   1331	1336	2324	java/lang/Throwable
    //   1348	1355	2324	java/lang/Throwable
    //   1367	1373	2324	java/lang/Throwable
    //   1385	1422	2324	java/lang/Throwable
    //   1434	1446	2324	java/lang/Throwable
    //   1458	1467	2324	java/lang/Throwable
    //   1479	1485	2324	java/lang/Throwable
    //   1497	1503	2324	java/lang/Throwable
    //   1518	1525	2324	java/lang/Throwable
    //   1537	1543	2324	java/lang/Throwable
    //   1555	1571	2324	java/lang/Throwable
    //   1583	1592	2324	java/lang/Throwable
    //   1604	1621	2324	java/lang/Throwable
    //   1633	1667	2324	java/lang/Throwable
    //   1679	1685	2324	java/lang/Throwable
    //   1706	1712	2324	java/lang/Throwable
    //   1724	1732	2324	java/lang/Throwable
    //   1744	1753	2324	java/lang/Throwable
    //   1765	1772	2324	java/lang/Throwable
    //   1784	1792	2324	java/lang/Throwable
    //   1804	1810	2324	java/lang/Throwable
    //   1822	1827	2324	java/lang/Throwable
    //   1839	1846	2324	java/lang/Throwable
    //   1858	1872	2324	java/lang/Throwable
    //   1884	1892	2324	java/lang/Throwable
    //   1904	1919	2324	java/lang/Throwable
    //   1931	1939	2324	java/lang/Throwable
    //   1955	1965	2324	java/lang/Throwable
    //   1977	1988	2324	java/lang/Throwable
    //   2000	2010	2324	java/lang/Throwable
    //   2022	2028	2324	java/lang/Throwable
    //   2040	2044	2324	java/lang/Throwable
    //   2056	2062	2324	java/lang/Throwable
    //   2074	2084	2324	java/lang/Throwable
    //   2096	2105	2324	java/lang/Throwable
    //   2117	2124	2324	java/lang/Throwable
    //   2136	2149	2324	java/lang/Throwable
    //   2210	2216	2324	java/lang/Throwable
    //   2231	2268	2324	java/lang/Throwable
    //   2280	2321	2324	java/lang/Throwable
    //   2515	2523	2324	java/lang/Throwable
    //   2535	2547	2324	java/lang/Throwable
    //   2559	2567	2324	java/lang/Throwable
    //   2579	2585	2324	java/lang/Throwable
    //   2597	2602	2324	java/lang/Throwable
    //   2684	2699	2324	java/lang/Throwable
    //   2711	2736	2324	java/lang/Throwable
    //   2748	2759	2324	java/lang/Throwable
    //   2771	2792	2324	java/lang/Throwable
    //   2811	2821	2324	java/lang/Throwable
    //   2833	2870	2324	java/lang/Throwable
    //   2886	2893	2324	java/lang/Throwable
    //   2905	2911	2324	java/lang/Throwable
    //   2923	2933	2324	java/lang/Throwable
    //   2945	2952	2324	java/lang/Throwable
    //   2964	2971	2324	java/lang/Throwable
    //   3037	3075	2324	java/lang/Throwable
    //   3087	3100	2324	java/lang/Throwable
    //   3161	3171	2324	java/lang/Throwable
    //   3183	3196	2324	java/lang/Throwable
    //   3220	3228	2324	java/lang/Throwable
    //   3528	3534	2324	java/lang/Throwable
    //   3546	3552	2324	java/lang/Throwable
    //   3564	3570	2324	java/lang/Throwable
    //   3736	3742	2324	java/lang/Throwable
    //   3754	3760	2324	java/lang/Throwable
    //   3772	3778	2324	java/lang/Throwable
    //   4979	4985	2324	java/lang/Throwable
    //   4997	5003	2324	java/lang/Throwable
    //   5015	5021	2324	java/lang/Throwable
    //   5033	5040	2324	java/lang/Throwable
    //   5052	5065	2324	java/lang/Throwable
    //   5198	5204	2324	java/lang/Throwable
    //   5216	5222	2324	java/lang/Throwable
    //   5234	5240	2324	java/lang/Throwable
    //   5326	5332	2324	java/lang/Throwable
    //   5344	5350	2324	java/lang/Throwable
    //   5362	5368	2324	java/lang/Throwable
    //   5496	5508	2324	java/lang/Throwable
    //   5520	5528	2324	java/lang/Throwable
    //   5540	5546	2324	java/lang/Throwable
    //   5558	5568	2324	java/lang/Throwable
    //   5629	5637	2324	java/lang/Throwable
    //   5649	5662	2324	java/lang/Throwable
    //   5723	5734	2324	java/lang/Throwable
    //   5753	5763	2324	java/lang/Throwable
    //   5777	5790	2324	java/lang/Throwable
    //   5851	5857	2324	java/lang/Throwable
    //   5869	5882	2324	java/lang/Throwable
    //   5957	5968	2324	java/lang/Throwable
    //   5980	5993	2324	java/lang/Throwable
    //   6110	6121	2324	java/lang/Throwable
    //   6140	6157	2324	java/lang/Throwable
    //   6169	6176	2324	java/lang/Throwable
    //   6188	6201	2324	java/lang/Throwable
    //   6311	6322	2324	java/lang/Throwable
    //   6362	6367	2324	java/lang/Throwable
    //   6379	6386	2324	java/lang/Throwable
    //   6398	6411	2324	java/lang/Throwable
    //   6521	6530	2324	java/lang/Throwable
    //   6542	6549	2324	java/lang/Throwable
    //   6568	6573	2324	java/lang/Throwable
    //   6634	6647	2324	java/lang/Throwable
    //   878	907	2605	finally
    //   919	927	2605	finally
    //   939	963	2605	finally
    //   975	998	2605	finally
    //   1010	1020	2605	finally
    //   1039	1049	2605	finally
    //   1061	1070	2605	finally
    //   1082	1090	2605	finally
    //   1102	1115	2605	finally
    //   1176	1192	2605	finally
    //   1216	1225	2605	finally
    //   1237	1245	2605	finally
    //   1257	1270	2605	finally
    //   1331	1336	2605	finally
    //   1348	1355	2605	finally
    //   1367	1373	2605	finally
    //   1385	1422	2605	finally
    //   1434	1446	2605	finally
    //   1458	1467	2605	finally
    //   1479	1485	2605	finally
    //   1497	1503	2605	finally
    //   1518	1525	2605	finally
    //   1537	1543	2605	finally
    //   1555	1571	2605	finally
    //   1583	1592	2605	finally
    //   1604	1621	2605	finally
    //   1633	1667	2605	finally
    //   1679	1685	2605	finally
    //   1706	1712	2605	finally
    //   1724	1732	2605	finally
    //   1744	1753	2605	finally
    //   1765	1772	2605	finally
    //   1784	1792	2605	finally
    //   1804	1810	2605	finally
    //   1822	1827	2605	finally
    //   1839	1846	2605	finally
    //   1858	1872	2605	finally
    //   1884	1892	2605	finally
    //   1904	1919	2605	finally
    //   1931	1939	2605	finally
    //   1955	1965	2605	finally
    //   1977	1988	2605	finally
    //   2000	2010	2605	finally
    //   2022	2028	2605	finally
    //   2040	2044	2605	finally
    //   2056	2062	2605	finally
    //   2074	2084	2605	finally
    //   2096	2105	2605	finally
    //   2117	2124	2605	finally
    //   2136	2149	2605	finally
    //   2210	2216	2605	finally
    //   2231	2268	2605	finally
    //   2280	2321	2605	finally
    //   2334	2342	2605	finally
    //   2350	2357	2605	finally
    //   2361	2369	2605	finally
    //   2373	2412	2605	finally
    //   2416	2424	2605	finally
    //   2428	2441	2605	finally
    //   2515	2523	2605	finally
    //   2535	2547	2605	finally
    //   2559	2567	2605	finally
    //   2579	2585	2605	finally
    //   2597	2602	2605	finally
    //   2684	2699	2605	finally
    //   2711	2736	2605	finally
    //   2748	2759	2605	finally
    //   2771	2792	2605	finally
    //   2811	2821	2605	finally
    //   2833	2870	2605	finally
    //   2886	2893	2605	finally
    //   2905	2911	2605	finally
    //   2923	2933	2605	finally
    //   2945	2952	2605	finally
    //   2964	2971	2605	finally
    //   3037	3075	2605	finally
    //   3087	3100	2605	finally
    //   3161	3171	2605	finally
    //   3183	3196	2605	finally
    //   3220	3228	2605	finally
    //   3528	3534	2605	finally
    //   3546	3552	2605	finally
    //   3564	3570	2605	finally
    //   3736	3742	2605	finally
    //   3754	3760	2605	finally
    //   3772	3778	2605	finally
    //   4979	4985	2605	finally
    //   4997	5003	2605	finally
    //   5015	5021	2605	finally
    //   5033	5040	2605	finally
    //   5052	5065	2605	finally
    //   5198	5204	2605	finally
    //   5216	5222	2605	finally
    //   5234	5240	2605	finally
    //   5326	5332	2605	finally
    //   5344	5350	2605	finally
    //   5362	5368	2605	finally
    //   5496	5508	2605	finally
    //   5520	5528	2605	finally
    //   5540	5546	2605	finally
    //   5558	5568	2605	finally
    //   5629	5637	2605	finally
    //   5649	5662	2605	finally
    //   5723	5734	2605	finally
    //   5753	5763	2605	finally
    //   5777	5790	2605	finally
    //   5851	5857	2605	finally
    //   5869	5882	2605	finally
    //   5957	5968	2605	finally
    //   5980	5993	2605	finally
    //   6110	6121	2605	finally
    //   6140	6157	2605	finally
    //   6169	6176	2605	finally
    //   6188	6201	2605	finally
    //   6311	6322	2605	finally
    //   6362	6367	2605	finally
    //   6379	6386	2605	finally
    //   6398	6411	2605	finally
    //   6521	6530	2605	finally
    //   6542	6549	2605	finally
    //   6568	6573	2605	finally
    //   6634	6647	2605	finally
    //   6700	6705	2605	finally
    //   6709	6722	2605	finally
    //   6726	6733	2605	finally
    //   6737	6750	2605	finally
    //   3242	3251	3665	java/io/IOException
    //   3256	3278	3665	java/io/IOException
    //   3632	3662	3665	java/io/IOException
    //   3278	3285	3861	java/io/IOException
    //   3289	3335	3861	java/io/IOException
    //   3339	3353	3861	java/io/IOException
    //   3357	3396	3861	java/io/IOException
    //   3842	3858	3861	java/io/IOException
    //   3404	3409	4396	finally
    //   4199	4208	4396	finally
    //   4216	4252	4396	finally
    //   4260	4273	4396	finally
    //   4288	4298	4396	finally
    //   4306	4315	4396	finally
    //   4323	4368	4396	finally
    //   4376	4389	4396	finally
    //   4402	4429	4429	java/lang/Throwable
    //   3683	3699	5441	finally
    //   3699	3724	5441	finally
    //   5118	5186	5441	finally
    //   5289	5314	5441	finally
    //   5425	5438	5441	finally
    //   4402	4429	6919	finally
    //   3228	3237	6924	finally
    //   3242	3251	6938	finally
    //   3256	3278	6938	finally
    //   3632	3662	6938	finally
    //   3278	3285	6949	finally
    //   3289	3335	6949	finally
    //   3339	3353	6949	finally
    //   3357	3396	6949	finally
    //   3842	3858	6949	finally
    //   3431	3438	6957	finally
    //   3454	3463	6957	finally
    //   3479	3492	6957	finally
    //   3906	3919	6957	finally
    //   3940	3947	6957	finally
    //   3963	3973	6957	finally
    //   3993	4001	6957	finally
    //   4026	4031	6957	finally
    //   4053	4058	6957	finally
    //   4078	4085	6957	finally
    //   4104	4117	6957	finally
    //   4136	4146	6957	finally
    //   4162	4167	6957	finally
    //   4467	4477	6957	finally
    //   4493	4498	6957	finally
    //   4534	4571	6957	finally
    //   4587	4593	6957	finally
    //   4609	4625	6957	finally
    //   4641	4658	6957	finally
    //   4674	4684	6957	finally
    //   4716	4726	6957	finally
    //   4742	4753	6957	finally
    //   4769	4779	6957	finally
    //   4795	4801	6957	finally
    //   4817	4821	6957	finally
    //   4837	4843	6957	finally
    //   4859	4869	6957	finally
    //   4885	4894	6957	finally
    //   4910	4923	6957	finally
    //   3228	3237	6970	java/io/IOException
    //   3431	3438	6983	java/io/IOException
    //   3454	3463	6983	java/io/IOException
    //   3479	3492	6983	java/io/IOException
    //   3906	3919	6983	java/io/IOException
    //   3940	3947	6983	java/io/IOException
    //   3963	3973	6983	java/io/IOException
    //   3993	4001	6983	java/io/IOException
    //   4026	4031	6983	java/io/IOException
    //   4053	4058	6983	java/io/IOException
    //   4078	4085	6983	java/io/IOException
    //   4104	4117	6983	java/io/IOException
    //   4136	4146	6983	java/io/IOException
    //   4162	4167	6983	java/io/IOException
    //   4467	4477	6983	java/io/IOException
    //   4493	4498	6983	java/io/IOException
    //   4534	4571	6983	java/io/IOException
    //   4587	4593	6983	java/io/IOException
    //   4609	4625	6983	java/io/IOException
    //   4641	4658	6983	java/io/IOException
    //   4674	4684	6983	java/io/IOException
    //   4716	4726	6983	java/io/IOException
    //   4742	4753	6983	java/io/IOException
    //   4769	4779	6983	java/io/IOException
    //   4795	4801	6983	java/io/IOException
    //   4817	4821	6983	java/io/IOException
    //   4837	4843	6983	java/io/IOException
    //   4859	4869	6983	java/io/IOException
    //   4885	4894	6983	java/io/IOException
    //   4910	4923	6983	java/io/IOException
    //   3404	3409	7034	java/io/IOException
    //   4199	4208	7034	java/io/IOException
    //   4216	4252	7034	java/io/IOException
    //   4260	4273	7034	java/io/IOException
    //   4288	4298	7034	java/io/IOException
    //   4306	4315	7034	java/io/IOException
    //   4323	4368	7034	java/io/IOException
    //   4376	4389	7034	java/io/IOException
  }
  
  public void c()
  {
    AppMethodBeat.i(195221);
    b();
    d(false);
    d(true);
    AppMethodBeat.o(195221);
  }
  
  public boolean d()
  {
    AppMethodBeat.i(195236);
    TbsLog.i("TbsDownload", "[TbsApkDownloader.isDownloadForeground] mIsDownloadForeground=" + this.D);
    boolean bool = this.D;
    AppMethodBeat.o(195236);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.m
 * JD-Core Version:    0.7.0.1
 */