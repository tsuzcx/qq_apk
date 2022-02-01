package com.tencent.smtt.sdk;

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
    AppMethodBeat.i(219501);
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
      AppMethodBeat.o(219501);
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
      finally
      {
        Context localContext;
        continue;
      }
      e();
      this.x = null;
      this.y = -1;
      AppMethodBeat.o(219501);
      return;
      this.l = new File(f.a(localContext, 4));
    }
  }
  
  private long a(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(219566);
    long l1 = System.currentTimeMillis();
    this.w.setDownConsumeTime(l1 - paramLong1);
    this.w.setDownloadSize(paramLong2);
    AppMethodBeat.o(219566);
    return l1;
  }
  
  private static File a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(219645);
    File localFile = new File(f.a(paramContext, paramInt));
    if ((!localFile.exists()) || (!localFile.isDirectory()))
    {
      AppMethodBeat.o(219645);
      return null;
    }
    if (TbsDownloader.getOverSea(paramContext)) {}
    for (paramContext = "x5.oversea.tbs.org"; new File(localFile, paramContext).exists(); paramContext = TbsDownloader.getBackupFileName(false))
    {
      AppMethodBeat.o(219645);
      return localFile;
    }
    AppMethodBeat.o(219645);
    return null;
  }
  
  private String a(Throwable paramThrowable)
  {
    AppMethodBeat.i(219581);
    paramThrowable = Log.getStackTraceString(paramThrowable);
    if (paramThrowable.length() > 1024)
    {
      paramThrowable = paramThrowable.substring(0, 1024);
      AppMethodBeat.o(219581);
      return paramThrowable;
    }
    AppMethodBeat.o(219581);
    return paramThrowable;
  }
  
  private String a(URL paramURL)
  {
    AppMethodBeat.i(219634);
    String str = "";
    try
    {
      paramURL = InetAddress.getByName(paramURL.getHost()).getHostAddress();
      AppMethodBeat.o(219634);
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
    AppMethodBeat.i(219574);
    if ((paramBoolean) || (this.q > this.C))
    {
      this.w.setErrorCode(paramInt);
      this.w.setFailDetail(paramString);
    }
    AppMethodBeat.o(219574);
  }
  
  private void a(long paramLong)
  {
    AppMethodBeat.i(219607);
    this.q += 1;
    long l1 = paramLong;
    if (paramLong <= 0L) {}
    try
    {
      l1 = l();
      Thread.sleep(l1);
      AppMethodBeat.o(219607);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(219607);
    }
  }
  
  public static void a(Context paramContext)
  {
    AppMethodBeat.i(219599);
    try
    {
      TbsLog.i("TbsDownload", "clearDecoupleDirOld #00");
      File localFile = paramContext.getDir("tbs_64", 0);
      localFile = q.a().a(paramContext, localFile);
      f.b(localFile);
      if (localFile != null) {
        TbsLog.i("TbsDownload", "clearDecoupleDirOld dir is " + localFile.getAbsolutePath());
      }
      localFile = paramContext.getDir("tbs", 0);
      paramContext = q.a().a(paramContext, localFile);
      f.b(paramContext);
      if (paramContext != null) {
        TbsLog.i("TbsDownload", "clearDecoupleDirOld dir is " + paramContext.getAbsolutePath());
      }
      AppMethodBeat.o(219599);
      return;
    }
    finally
    {
      TbsLog.i("TbsDownload", "clearDecoupleDirOld stack is " + Log.getStackTraceString(paramContext));
      AppMethodBeat.o(219599);
    }
  }
  
  private void a(Closeable paramCloseable)
  {
    AppMethodBeat.i(219604);
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        AppMethodBeat.o(219604);
        return;
      }
      catch (IOException paramCloseable) {}
    }
    AppMethodBeat.o(219604);
  }
  
  public static void a(File paramFile, Context paramContext)
  {
    i1 = 0;
    AppMethodBeat.i(219647);
    if (paramFile != null) {}
    for (;;)
    {
      try
      {
        if (!paramFile.exists()) {
          return;
        }
      }
      finally
      {
        File localFile;
        Object localObject1;
        boolean bool1;
        boolean bool2;
        int i2;
        Object localObject2;
        AppMethodBeat.o(219647);
      }
      try
      {
        localFile = c(paramContext);
        if (localFile == null) {
          continue;
        }
        if (!TbsDownloader.getOverSea(paramContext)) {
          continue;
        }
        localObject1 = "x5.oversea.tbs.org";
        localObject1 = new File(localFile, (String)localObject1);
        ((File)localObject1).delete();
        f.b(paramFile, (File)localObject1);
        TbsLog.i("TbsDownload", "[TbsApkDownloader.backupTbsApk]tbsApk is " + paramFile.getAbsolutePath());
        TbsLog.i("TbsDownload", "[TbsApkDownloader.backupTbsApk]backUpApk is " + ((File)localObject1).getAbsolutePath());
        bool1 = ((File)localObject1).getName().contains("tbs.org");
        bool2 = ((File)localObject1).getName().contains("x5.tbs.decouple");
        if ((!bool2) && (!bool1)) {
          continue;
        }
        paramFile = localFile.listFiles();
        localObject1 = Pattern.compile(a.a(bool2) + "(.*)");
        i2 = paramFile.length;
      }
      catch (Exception paramFile)
      {
        continue;
        i1 += 1;
        continue;
      }
      if (i1 >= i2) {
        continue;
      }
      localObject2 = paramFile[i1];
      if ((!((Pattern)localObject1).matcher(localObject2.getName()).find()) || (!localObject2.isFile()) || (!localObject2.exists())) {
        break label384;
      }
      localObject2.delete();
      break label384;
      localObject1 = TbsDownloader.getBackupFileName(false);
    }
    i1 = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_download_version", 0);
    paramFile = new File(localFile, a.a(bool2) + "." + i1);
    if (paramFile.exists())
    {
      TbsLog.e("TbsDownload", "[TbsApkDownloader.backupTbsApk]delete bacup config file error ");
      AppMethodBeat.o(219647);
      return;
    }
    paramFile.createNewFile();
    AppMethodBeat.o(219647);
  }
  
  private void a(String paramString)
  {
    AppMethodBeat.i(219519);
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
      AppMethodBeat.o(219519);
      return;
    }
    finally
    {
      for (;;)
      {
        TbsLog.e("TbsDownload", "[initHttpRequest] mHttpRequest.disconnect() Throwable:" + localObject.toString());
      }
    }
  }
  
  private boolean a(File paramFile)
  {
    AppMethodBeat.i(219611);
    int i2 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("use_backup_version", 0);
    int i1 = i2;
    if (i2 == 0) {
      i1 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_download_version", 0);
    }
    boolean bool = a.a(this.g, paramFile, 0L, i1);
    AppMethodBeat.o(219611);
    return bool;
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2, File paramFile)
  {
    long l1 = 0L;
    AppMethodBeat.i(219618);
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
        break label829;
      }
      localObject1 = paramFile;
    }
    label395:
    label792:
    label829:
    for (;;)
    {
      if (!((File)localObject1).exists())
      {
        AppMethodBeat.o(219618);
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
        AppMethodBeat.o(219618);
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
              break label395;
            }
            l1 = ((File)localObject1).length();
            l2 = l1;
            if (l3 == l1) {
              break label395;
            }
            l2 = l1;
          }
        }
        TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1 + " filelength failed");
        this.w.setCheckErrorDetail("fileLength:" + l2 + ",contentLength:" + l3);
        AppMethodBeat.o(219618);
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
            AppMethodBeat.o(219618);
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
              break label707;
            }
          }
          label707:
          for (paramFile = "null";; paramFile = Integer.valueOf(str.length()))
          {
            ((TbsLogReport.TbsLogInfo)localObject1).setCheckErrorDetail(paramFile);
            AppMethodBeat.o(219618);
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
          break label792;
        }
        a(109, a(paramFile), true);
        AppMethodBeat.o(219618);
        return false;
      }
      paramBoolean2 = false;
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] rename(" + paramBoolean2 + ") successful!");
      AppMethodBeat.o(219618);
      return true;
    }
  }
  
  public static void b(Context paramContext)
  {
    AppMethodBeat.i(219600);
    try
    {
      if (!TbsShareManager.isThirdPartyApp(paramContext))
      {
        boolean bool = r.b(paramContext);
        if (!bool)
        {
          AppMethodBeat.o(219600);
          return;
        }
      }
      TbsLog.i("TbsDownload", "clearOldBackup #00");
      paramContext = new File(f.a(paramContext, 3));
      f.b(paramContext);
      TbsLog.i("TbsDownload", "clearOldBackup dir is " + paramContext.getAbsolutePath());
      AppMethodBeat.o(219600);
      return;
    }
    finally
    {
      TbsLog.i("TbsDownload", "clearOldBackup stack is " + Log.getStackTraceString(paramContext));
      AppMethodBeat.o(219600);
    }
  }
  
  private boolean b(int paramInt)
  {
    AppMethodBeat.i(219557);
    try
    {
      File localFile1 = new File(this.k, "x5.tbs");
      File localFile2 = c(this.g);
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
          AppMethodBeat.o(219557);
          return false;
        }
      }
      AppMethodBeat.o(219557);
      return false;
    }
    catch (Exception localException)
    {
      TbsLog.e("TbsDownload", "[TbsApkDownloader.copyTbsApkFromBackupToInstall] Exception is " + localException.getMessage());
      AppMethodBeat.o(219557);
      return false;
    }
    AppMethodBeat.o(219557);
    return true;
  }
  
  static File c(Context paramContext)
  {
    AppMethodBeat.i(219639);
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
          AppMethodBeat.o(219639);
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        TbsLog.e("TbsDownload", "[TbsApkDownloader.backupApkPath] Exception is " + paramContext.getMessage());
        AppMethodBeat.o(219639);
        return null;
      }
      paramContext = null;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    AppMethodBeat.i(219596);
    r.a(this.g);
    Object localObject3 = TbsDownloadConfig.getInstance(this.g);
    ((TbsDownloadConfig)localObject3).mSyncMap.put("request_full_package", Boolean.FALSE);
    ((TbsDownloadConfig)localObject3).mSyncMap.put("tbs_needdownload", Boolean.FALSE);
    ((TbsDownloadConfig)localObject3).mSyncMap.put("tbs_download_interrupt_code_reason", Integer.valueOf(-123));
    ((TbsDownloadConfig)localObject3).commit();
    Object localObject1 = QbSdk.l;
    int i1;
    int i2;
    int i3;
    label334:
    boolean bool;
    label532:
    if (paramBoolean)
    {
      i1 = 100;
      ((TbsListener)localObject1).onDownloadFinish(i1);
      i2 = ((TbsDownloadConfig)localObject3).mPreferences.getInt("tbs_responsecode", 0);
      paramBoolean = TbsDownloader.a(this.g);
      if (paramBoolean)
      {
        localObject1 = "downloadVersion=is=" + TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_download_version", 0);
        localObject1 = (String)localObject1 + "_apkSize=is=" + TbsDownloadConfig.getInstance(this.g).mPreferences.getLong("tbs_apkfilesize", 0L);
        r.a(this.g, "download_ok", (String)localObject1);
      }
    }
    for (;;)
    {
      try
      {
        i3 = ((TbsDownloadConfig)localObject3).mPreferences.getInt("tbs_cpu_type_other_stable_core", 0);
        TbsLog.i("TbsDownload", "downloadSuccess #1  cpuTypeForOtherStableCore is " + i3 + " isDownloadDecoupleCore is " + paramBoolean);
        TbsLog.i("TbsDownload", "downloadSuccess #1  responseCode is ".concat(String.valueOf(i2)));
        if ((paramBoolean) && (r.c(this.g)) && (i2 != 3))
        {
          localObject1 = this.l.listFiles();
          Pattern localPattern = Pattern.compile(a.a(false, i3));
          int i4 = localObject1.length;
          i1 = 0;
          if (i1 < i4)
          {
            Object localObject4 = localObject1[i1];
            if ((!localPattern.matcher(localObject4.getName()).find()) || (!localObject4.isFile()) || (!localObject4.exists())) {
              break label1224;
            }
            localObject4.delete();
            break label1224;
          }
          localObject1 = new File(this.l, a.a(false, i3) + "." + ((TbsDownloadConfig)localObject3).mPreferences.getInt("tbs_download_version", 0));
          if (!((File)localObject1).exists()) {
            ((File)localObject1).createNewFile();
          }
        }
      }
      finally
      {
        TbsLog.i("TbsDownload", "downloadSuccess stack is " + Log.getStackTraceString(localThrowable2));
        continue;
        if (!paramBoolean) {
          continue;
        }
        localObject3 = "downloadVersion=is=" + TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_download_version", 0);
        localObject3 = (String)localObject3 + "_apkSize=is=" + TbsDownloadConfig.getInstance(this.g).mPreferences.getLong("tbs_apkfilesize", 0L);
        localObject3 = (String)localObject3 + "_responseCode=is=" + i2;
        r.a(this.g, "tpatch_pre_bundle_ok", (String)localObject3);
        TbsLog.i("TbsDownload", "downloadSuccess RESPONSECODE_TPATCH bundle is ".concat(String.valueOf(localThrowable2)));
        q.a().b(this.g, localThrowable2);
        a(this.g);
        b(this.g);
        AppMethodBeat.o(219596);
        return;
      }
      try
      {
        bool = new File(this.l, TbsDownloader.getBackupFileName(false) + ".tmp").renameTo(new File(this.l, TbsDownloader.getBackupFileName(false, i3)));
        localObject1 = "none";
        if (i3 != 0) {
          break label1237;
        }
        if (!b.b()) {
          continue;
        }
        localObject1 = "stable_64_tpatch_fail";
        n.a(this.g).a((String)localObject1, 0);
        TbsLog.i("TbsDownload", "downloadSuccess setStatus " + (String)localObject1 + " is 0");
        TbsLog.i("TbsDownload", "downloadSuccess renameResult is ".concat(String.valueOf(bool)));
      }
      finally
      {
        TbsLog.i("TbsDownload", "downloadSuccess stack is " + Log.getStackTraceString(localThrowable1));
        continue;
      }
      TbsLog.i("TbsDownload", "downloadSuccess getTbsStableCoreVersion is " + TbsShareManager.getTbsStableCoreVersion(this.g, i3));
      localObject1 = "cpu=is=".concat(String.valueOf(i3));
      r.a(this.g, "rename_whole_file_ok", (String)localObject1);
      if ((i2 == 5) || (i2 == 3))
      {
        localObject1 = a(i2, paramBoolean);
        if (localObject1 == null)
        {
          TbsLog.i("TbsDownload", "downloadSuccess RESPONSECODE_TPATCH bundle is null ");
          a(this.g);
          b(this.g);
          AppMethodBeat.o(219596);
          return;
          localObject1 = "stable_32_tpatch_fail";
          continue;
          if (i3 != 64) {
            continue;
          }
          localObject1 = "stable_64_tpatch_fail";
          continue;
        }
      }
      Object localObject2;
      if ((i2 == 3) || (i2 > 10000))
      {
        localObject2 = c(this.g);
        if (localObject2 != null)
        {
          localObject2 = a(i2, (File)localObject2, paramBoolean);
          q.a().b(this.g, (Bundle)localObject2);
        }
        else
        {
          c();
          ((TbsDownloadConfig)localObject3).mSyncMap.put("tbs_needdownload", Boolean.TRUE);
          ((TbsDownloadConfig)localObject3).commit();
        }
      }
      else
      {
        i1 = ((TbsDownloadConfig)localObject3).mPreferences.getInt("tbs_download_version", 0);
        q.a().a(this.g, new File(this.k, "x5.tbs").getAbsolutePath(), i1);
        if (!r.c(this.g))
        {
          a(new File(this.k, "x5.tbs"), this.g);
        }
        else
        {
          i2 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_decouplecoreversion", 0);
          TbsLog.i("TbsDownload", "downloadSuccess tbsCorVer is " + i1 + " stableCoreVersionServer is " + i2);
          if (i1 == i2)
          {
            TbsLog.i("TbsDownload", "downloadSuccess backup");
            a(new File(this.k, "x5.tbs"), this.g);
          }
          else
          {
            TbsLog.i("TbsDownload", "downloadSuccess not backup");
            continue;
            label1224:
            i1 += 1;
            break label334;
            i1 = 120;
            break;
            label1237:
            if (i3 != 32) {
              break label532;
            }
            localObject2 = "stable_32_tpatch_fail";
          }
        }
      }
    }
  }
  
  private boolean c(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(219613);
    paramBoolean1 = a(paramBoolean1, paramBoolean2, null);
    AppMethodBeat.o(219613);
    return paramBoolean1;
  }
  
  static File d(Context paramContext)
  {
    AppMethodBeat.i(219642);
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
          AppMethodBeat.o(219642);
          return localObject1;
        }
      }
      catch (Exception paramContext)
      {
        TbsLog.e("TbsDownload", "[TbsApkDownloader.backupApkPath] Exception is " + paramContext.getMessage());
        AppMethodBeat.o(219642);
        return null;
      }
      Object localObject1 = null;
    }
  }
  
  private boolean d(boolean paramBoolean)
  {
    AppMethodBeat.i(219620);
    TbsLog.i("TbsDownload", "[TbsApkDownloader.deleteFile] isApk=".concat(String.valueOf(paramBoolean)));
    if (paramBoolean) {}
    for (File localFile = new File(this.k, "x5.tbs");; localFile = new File(this.k, "x5.tbs.temp"))
    {
      if (localFile.exists()) {
        f.b(localFile);
      }
      AppMethodBeat.o(219620);
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
  
  public static void e(Context paramContext)
  {
    int i2 = 0;
    AppMethodBeat.i(219650);
    for (;;)
    {
      int i1;
      try
      {
        q.a();
        Object localObject1 = q.t(paramContext);
        new File((File)localObject1, "x5.tbs").delete();
        new File((File)localObject1, "x5.tbs.temp").delete();
        paramContext = c(paramContext);
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
        AppMethodBeat.o(219650);
        return;
      }
      catch (Exception paramContext)
      {
        AppMethodBeat.o(219650);
        return;
      }
      label281:
      i1 += 1;
    }
  }
  
  private void f()
  {
    AppMethodBeat.i(219549);
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
      TbsLog.i("TbsDownload", "[TbsApkDownloader.closeHttpRequest] mHttpRequest set null");
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
            break label325;
          }
          TbsLogReport.getInstance(this.g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE, this.w);
          this.w.resetArgs();
          if (i1 != 100) {
            QbSdk.l.onDownloadFinish(i1);
          }
          AppMethodBeat.o(219549);
          return;
        }
      }
    }
    finally
    {
      for (;;)
      {
        TbsLog.e("TbsDownload", "[closeHttpRequest] mHttpRequest.disconnect() Throwable:" + localObject.toString());
        continue;
        if (!k())
        {
          a(101, null, true);
          continue;
          label325:
          TbsLogReport.getInstance(this.g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, this.w);
        }
      }
      TbsDownloader.a = false;
      AppMethodBeat.o(219549);
    }
  }
  
  private File g()
  {
    AppMethodBeat.i(219610);
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
      AppMethodBeat.o(219610);
      return localObject;
      localObject = TbsDownloader.getBackupFileName(false);
      break;
    }
  }
  
  private void h()
  {
    AppMethodBeat.i(219622);
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
      AppMethodBeat.o(219622);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(219622);
    }
  }
  
  private boolean i()
  {
    AppMethodBeat.i(219624);
    boolean bool = false;
    if (new File(this.k, "x5.tbs.temp").exists()) {
      bool = true;
    }
    AppMethodBeat.o(219624);
    return bool;
  }
  
  private long j()
  {
    AppMethodBeat.i(219626);
    long l1 = 0L;
    File localFile = new File(this.k, "x5.tbs.temp");
    if (localFile.exists()) {
      l1 = localFile.length();
    }
    AppMethodBeat.o(219626);
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
    //   6: ldc_w 847
    //   9: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: invokestatic 853	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   15: astore 6
    //   17: aload 6
    //   19: ldc_w 855
    //   22: ldc_w 857
    //   25: invokestatic 715	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   28: invokevirtual 464	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   31: invokevirtual 861	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   34: invokevirtual 867	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   37: astore 8
    //   39: new 869	java/io/InputStreamReader
    //   42: dup
    //   43: aload 8
    //   45: invokespecial 872	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   48: astore 7
    //   50: new 874	java/io/BufferedReader
    //   53: dup
    //   54: aload 7
    //   56: invokespecial 877	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   59: astore 6
    //   61: iconst_0
    //   62: istore_1
    //   63: aload 6
    //   65: invokevirtual 880	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   68: astore 9
    //   70: iload 4
    //   72: istore_3
    //   73: aload 9
    //   75: ifnull +29 -> 104
    //   78: aload 9
    //   80: ldc_w 882
    //   83: invokevirtual 339	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   86: ifne +16 -> 102
    //   89: aload 9
    //   91: ldc_w 884
    //   94: invokevirtual 339	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   97: istore_3
    //   98: iload_3
    //   99: ifeq +31 -> 130
    //   102: iconst_1
    //   103: istore_3
    //   104: aload_0
    //   105: aload 8
    //   107: invokespecial 886	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   110: aload_0
    //   111: aload 7
    //   113: invokespecial 886	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   116: aload_0
    //   117: aload 6
    //   119: invokespecial 886	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   122: ldc_w 847
    //   125: invokestatic 151	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   161: invokespecial 886	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   164: aload_0
    //   165: aload 7
    //   167: invokespecial 886	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   170: aload_0
    //   171: aload 6
    //   173: invokespecial 886	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   176: iload 5
    //   178: istore_3
    //   179: goto -57 -> 122
    //   182: astore 6
    //   184: aconst_null
    //   185: astore 6
    //   187: aconst_null
    //   188: astore 7
    //   190: goto -32 -> 158
    //   193: astore 6
    //   195: aconst_null
    //   196: astore 6
    //   198: goto -40 -> 158
    //   201: astore 9
    //   203: goto -45 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	m
    //   62	74	1	i1	int
    //   133	6	2	i2	int
    //   72	107	3	bool1	boolean
    //   4	138	4	bool2	boolean
    //   1	176	5	bool3	boolean
    //   15	103	6	localObject1	Object
    //   147	1	6	localObject2	Object
    //   150	22	6	localCloseable	Closeable
    //   182	1	6	localObject3	Object
    //   185	1	6	localObject4	Object
    //   193	1	6	localObject5	Object
    //   196	1	6	localObject6	Object
    //   48	141	7	localInputStreamReader	java.io.InputStreamReader
    //   37	123	8	localInputStream	java.io.InputStream
    //   68	22	9	str	String
    //   201	1	9	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   17	39	147	finally
    //   39	50	182	finally
    //   50	61	193	finally
    //   63	70	201	finally
    //   78	98	201	finally
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
    //   1: astore 6
    //   3: iconst_1
    //   4: istore 4
    //   6: iconst_0
    //   7: istore 5
    //   9: ldc_w 893
    //   12: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   15: aload_0
    //   16: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   19: invokestatic 797	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   22: iconst_3
    //   23: if_icmpne +255 -> 278
    //   26: iconst_1
    //   27: istore_3
    //   28: ldc_w 277
    //   31: ldc_w 895
    //   34: iload_3
    //   35: invokestatic 460	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   38: invokevirtual 464	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   41: invokestatic 284	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: iload 5
    //   46: istore_2
    //   47: iload_3
    //   48: ifeq +123 -> 171
    //   51: aload_0
    //   52: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   55: invokestatic 898	com/tencent/smtt/utils/Apn:getWifiSSID	(Landroid/content/Context;)Ljava/lang/String;
    //   58: astore 6
    //   60: ldc_w 277
    //   63: ldc_w 900
    //   66: aload 6
    //   68: invokestatic 715	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   71: invokevirtual 464	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   74: invokestatic 284	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: new 244	java/net/URL
    //   80: dup
    //   81: ldc_w 902
    //   84: invokespecial 399	java/net/URL:<init>	(Ljava/lang/String;)V
    //   87: invokevirtual 410	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   90: checkcast 403	java/net/HttpURLConnection
    //   93: astore 7
    //   95: aload 7
    //   97: iconst_0
    //   98: invokevirtual 431	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   101: aload 7
    //   103: sipush 10000
    //   106: invokevirtual 434	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   109: aload 7
    //   111: sipush 10000
    //   114: invokevirtual 437	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   117: aload 7
    //   119: iconst_0
    //   120: invokevirtual 905	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   123: aload 7
    //   125: invokevirtual 906	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   128: pop
    //   129: aload 7
    //   131: invokevirtual 909	java/net/HttpURLConnection:getResponseCode	()I
    //   134: istore_1
    //   135: ldc_w 277
    //   138: ldc_w 911
    //   141: iload_1
    //   142: invokestatic 654	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   145: invokevirtual 464	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   148: invokestatic 284	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: iload_1
    //   152: sipush 204
    //   155: if_icmpne +128 -> 283
    //   158: iload 4
    //   160: istore_2
    //   161: aload 7
    //   163: ifnull +170 -> 333
    //   166: aload 7
    //   168: invokevirtual 406	java/net/HttpURLConnection:disconnect	()V
    //   171: iload_2
    //   172: ifne +68 -> 240
    //   175: aload 6
    //   177: invokestatic 916	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   180: ifne +60 -> 240
    //   183: aload_0
    //   184: getfield 114	com/tencent/smtt/sdk/m:B	Ljava/util/Set;
    //   187: aload 6
    //   189: invokeinterface 920 2 0
    //   194: ifne +46 -> 240
    //   197: aload_0
    //   198: getfield 114	com/tencent/smtt/sdk/m:B	Ljava/util/Set;
    //   201: aload 6
    //   203: invokeinterface 923 2 0
    //   208: pop
    //   209: aload_0
    //   210: invokespecial 925	com/tencent/smtt/sdk/m:n	()V
    //   213: aload_0
    //   214: getfield 927	com/tencent/smtt/sdk/m:A	Landroid/os/Handler;
    //   217: sipush 150
    //   220: aload 6
    //   222: invokevirtual 933	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   225: astore 7
    //   227: aload_0
    //   228: getfield 927	com/tencent/smtt/sdk/m:A	Landroid/os/Handler;
    //   231: aload 7
    //   233: ldc2_w 934
    //   236: invokevirtual 939	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   239: pop
    //   240: iload_2
    //   241: ifeq +29 -> 270
    //   244: aload_0
    //   245: getfield 114	com/tencent/smtt/sdk/m:B	Ljava/util/Set;
    //   248: aload 6
    //   250: invokeinterface 920 2 0
    //   255: ifeq +15 -> 270
    //   258: aload_0
    //   259: getfield 114	com/tencent/smtt/sdk/m:B	Ljava/util/Set;
    //   262: aload 6
    //   264: invokeinterface 942 2 0
    //   269: pop
    //   270: ldc_w 893
    //   273: invokestatic 151	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   276: iload_2
    //   277: ireturn
    //   278: iconst_0
    //   279: istore_3
    //   280: goto -252 -> 28
    //   283: iconst_0
    //   284: istore_2
    //   285: goto -124 -> 161
    //   288: astore 7
    //   290: goto -119 -> 171
    //   293: astore 7
    //   295: aconst_null
    //   296: astore 7
    //   298: aload 7
    //   300: ifnull +27 -> 327
    //   303: aload 7
    //   305: invokevirtual 406	java/net/HttpURLConnection:disconnect	()V
    //   308: iload 5
    //   310: istore_2
    //   311: goto -140 -> 171
    //   314: astore 7
    //   316: iload 5
    //   318: istore_2
    //   319: goto -148 -> 171
    //   322: astore 8
    //   324: goto -26 -> 298
    //   327: iload 5
    //   329: istore_2
    //   330: goto -159 -> 171
    //   333: goto -162 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	336	0	this	m
    //   134	22	1	i1	int
    //   46	284	2	bool1	boolean
    //   27	253	3	bool2	boolean
    //   4	155	4	bool3	boolean
    //   7	321	5	bool4	boolean
    //   1	262	6	str	String
    //   93	139	7	localObject1	Object
    //   288	1	7	localException1	Exception
    //   293	1	7	localObject2	Object
    //   296	8	7	localObject3	Object
    //   314	1	7	localException2	Exception
    //   322	1	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   166	171	288	java/lang/Exception
    //   77	95	293	finally
    //   303	308	314	java/lang/Exception
    //   95	151	322	finally
  }
  
  private void n()
  {
    AppMethodBeat.i(219658);
    if (this.A == null) {
      this.A = new Handler(o.a().getLooper())
      {
        public void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(219656);
          if (paramAnonymousMessage.what == 150) {
            m.a(m.this);
          }
          AppMethodBeat.o(219656);
        }
      };
    }
    AppMethodBeat.o(219658);
  }
  
  public Bundle a(int paramInt, File paramFile, boolean paramBoolean)
  {
    AppMethodBeat.i(219725);
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
      AppMethodBeat.o(219725);
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
    AppMethodBeat.i(219720);
    String str = "not_stable";
    int i2;
    Object localObject1;
    int i1;
    Object localObject4;
    Object localObject2;
    if (paramBoolean) {
      if (r.c(this.g))
      {
        i2 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_cpu_type_other_stable_core", 0);
        localObject1 = new File(this.l, TbsDownloader.getBackupFileName(false, i2));
        i1 = TbsShareManager.getTbsStableCoreVersion(this.g, i2);
        str = "stable_core_".concat(String.valueOf(i2));
        localObject4 = new File(this.k, "x5.tbs");
        if (!((File)localObject4).exists()) {
          break label280;
        }
        localObject2 = ((File)localObject4).getAbsolutePath();
        label119:
        if ((!paramBoolean) || (!r.c(this.g))) {
          break label601;
        }
        localObject4 = new File(this.l, TbsDownloader.getBackupFileName(false) + ".tmp");
        if (!((File)localObject4).exists()) {
          break label286;
        }
        localObject2 = ((File)localObject4).getAbsolutePath();
      }
    }
    label184:
    label601:
    for (Object localObject3 = localObject2;; localObject3 = localObject2)
    {
      if (localObject3 == null)
      {
        TbsLog.i("TbsDownload", "gettpatchBundle tbsApkFile is " + ((File)localObject4).getAbsolutePath());
        AppMethodBeat.o(219720);
        return null;
        localObject1 = q.a().q(this.g);
        i1 = q.a().i(this.g);
        break;
        localObject1 = q.a().r(this.g);
        i1 = q.a().j(this.g);
        break;
        localObject2 = null;
        break label119;
        localObject2 = null;
        break label184;
      }
      i2 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_download_version", 0);
      if (paramBoolean) {
        if (r.c(this.g)) {
          localObject2 = new File(this.l, TbsDownloader.getBackupFileName(false) + ".tpatch.tmp");
        }
      }
      for (;;)
      {
        localObject4 = new Bundle();
        ((Bundle)localObject4).putInt("operation", paramInt);
        ((Bundle)localObject4).putInt("old_core_ver", i1);
        ((Bundle)localObject4).putInt("new_core_ver", i2);
        ((Bundle)localObject4).putString("old_apk_location", ((File)localObject1).getAbsolutePath());
        ((Bundle)localObject4).putString("new_apk_location", ((File)localObject2).getAbsolutePath());
        ((Bundle)localObject4).putString("diff_file_location", localObject3);
        ((Bundle)localObject4).putString("core_type_tpatch", str);
        localObject1 = f.a(this.g, 7);
        localObject2 = new File((String)localObject1);
        if (!((File)localObject2).exists()) {
          ((File)localObject2).mkdirs();
        }
        ((Bundle)localObject4).putString("backup_apk", new File((String)localObject1, i2 + ".tbs").getAbsolutePath());
        if ((paramBoolean) && (r.c(this.g))) {
          ((Bundle)localObject4).putInt("for_stable_core", 1);
        }
        if (!paramBoolean) {
          ((Bundle)localObject4).putInt("for_self_core", 1);
        }
        AppMethodBeat.o(219720);
        return localObject4;
        localObject2 = q.a().f(this.g, 6);
        continue;
        localObject2 = q.a().f(this.g, 5);
      }
    }
  }
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(219750);
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
        AppMethodBeat.o(219750);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(219750);
  }
  
  public boolean a()
  {
    AppMethodBeat.i(219675);
    TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #1");
    for (;;)
    {
      int i2;
      try
      {
        File localFile;
        if (r.c(this.g))
        {
          localFile = new File(f.a(this.g, "com.tencent.mm", 4, true), TbsDownloader.getBackupFileName(false));
          TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup backupFile is " + localFile.getAbsolutePath());
          if (localFile.exists())
          {
            TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #2");
            if (!a.a(this.g, localFile, 0L, TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_decouplecoreversion", -1))) {
              continue;
            }
            TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #3");
            if (!r.c(this.g)) {
              break label616;
            }
            TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup isStableCoreForHostEnable and return true");
            AppMethodBeat.o(219675);
            return true;
          }
        }
        else
        {
          localFile = new File(f.a(this.g, 4), TbsDownloader.getBackupFileName(true));
          continue;
        }
        Object localObject1 = TbsDownloader.b(TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_decouplecoreversion", -1));
        if (localObject1 != null) {
          TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup getExistBackupCoreForDecouple is " + ((File)localObject1).getAbsolutePath());
        }
        if ((localObject1 != null) && (((File)localObject1).exists())) {
          f.b((File)localObject1, localFile);
        }
        try
        {
          localObject1 = ((File)localObject1).getName();
          TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup fileNameSource is ".concat(String.valueOf(localObject1)));
          if (!((String)localObject1).contains("64")) {
            break label646;
          }
          i1 = 64;
          if (!r.c(this.g)) {
            continue;
          }
          localObject1 = this.l.listFiles();
          Pattern localPattern = Pattern.compile(a.a(false, i1));
          int i3 = localObject1.length;
          i2 = 0;
          if (i2 < i3)
          {
            Object localObject2 = localObject1[i2];
            if ((!localPattern.matcher(localObject2.getName()).find()) || (!localObject2.isFile()) || (!localObject2.exists())) {
              break label652;
            }
            localObject2.delete();
            TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup delete file " + localObject2.getAbsolutePath());
            break label652;
          }
          localObject1 = new File(this.l, a.a(false, i1) + "." + TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_decouplecoreversion", -1));
          if (!((File)localObject1).exists()) {
            break label580;
          }
          TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup  file already exist " + ((File)localObject1).getAbsolutePath());
          continue;
        }
        finally
        {
          TbsLog.i("TbsApkDownloader", "stack is " + Log.getStackTraceString(localThrowable));
        }
        continue;
        localThrowable.createNewFile();
      }
      catch (Exception localException)
      {
        TbsLog.i("TbsApkDownloader", "stack is " + Log.getStackTraceString(localException));
        AppMethodBeat.o(219675);
        return false;
      }
      label580:
      TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup create file " + localThrowable.getAbsolutePath());
      continue;
      label616:
      TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup goto installDecoupleCoreFromBackup");
      boolean bool = q.a().f(this.g);
      AppMethodBeat.o(219675);
      return bool;
      label646:
      int i1 = 32;
      continue;
      label652:
      i2 += 1;
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    AppMethodBeat.i(219714);
    if ((paramBoolean) && (!m()) && ((!QbSdk.getDownloadWithoutWifi()) || (!Apn.isNetworkAvailable(this.g))))
    {
      AppMethodBeat.o(219714);
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
      AppMethodBeat.o(219714);
      return true;
    }
    AppMethodBeat.o(219714);
    return false;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(219669);
    if (Build.VERSION.SDK_INT == 23)
    {
      AppMethodBeat.o(219669);
      return false;
    }
    int i1 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("use_backup_version", 0);
    int i2 = q.a().j(this.g);
    if (i1 == 0) {
      i1 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_download_version", 0);
    }
    for (this.a = "by default key"; (i1 == 0) || (i1 == i2); this.a = "by new key")
    {
      AppMethodBeat.o(219669);
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
          AppMethodBeat.o(219669);
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
      if (!r.c(this.g)) {
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
      AppMethodBeat.o(219669);
      return true;
    }
    if ((!d(true)) && (!d(true)))
    {
      TbsLog.e("TbsDownload", "[TbsApkDownloader] delete file failed!");
      TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-301);
    }
    AppMethodBeat.o(219669);
    return false;
  }
  
  public int b(boolean paramBoolean)
  {
    AppMethodBeat.i(219732);
    File localFile = c(this.g);
    int i1;
    if (paramBoolean)
    {
      if (localFile == null)
      {
        AppMethodBeat.o(219732);
        return 0;
      }
      i1 = a.a(this.g, new File(localFile, TbsDownloader.getBackupFileName(true)));
      AppMethodBeat.o(219732);
      return i1;
    }
    if (localFile == null)
    {
      AppMethodBeat.o(219732);
      return 0;
    }
    Context localContext = this.g;
    if (TbsDownloader.getOverSea(this.g)) {}
    for (String str = "x5.oversea.tbs.org";; str = TbsDownloader.getBackupFileName(false))
    {
      i1 = a.a(localContext, new File(localFile, str));
      AppMethodBeat.o(219732);
      return i1;
    }
  }
  
  public void b()
  {
    AppMethodBeat.i(219741);
    this.s = true;
    if (TbsShareManager.isThirdPartyApp(this.g))
    {
      TbsLogReport.TbsLogInfo localTbsLogInfo = TbsLogReport.getInstance(this.g).tbsLogInfo();
      localTbsLogInfo.setErrorCode(-309);
      localTbsLogInfo.setFailDetail(new Exception());
      if (TbsDownloader.a(this.g))
      {
        TbsLogReport.getInstance(this.g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE, localTbsLogInfo);
        AppMethodBeat.o(219741);
        return;
      }
      TbsLogReport.getInstance(this.g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, localTbsLogInfo);
    }
    AppMethodBeat.o(219741);
  }
  
  /* Error */
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: ldc_w 1088
    //   3: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   10: invokestatic 1093	com/tencent/smtt/sdk/TbsOneGreyInfoHelper:isTbsOneModeEnable	(Landroid/content/Context;)Z
    //   13: ifeq +12 -> 25
    //   16: ldc_w 1095
    //   19: ldc_w 1097
    //   22: invokestatic 284	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: invokestatic 139	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   28: aload_0
    //   29: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   32: invokevirtual 1099	com/tencent/smtt/sdk/q:d	(Landroid/content/Context;)Z
    //   35: ifeq +31 -> 66
    //   38: iload_1
    //   39: ifne +27 -> 66
    //   42: iconst_0
    //   43: putstatic 834	com/tencent/smtt/sdk/TbsDownloader:a	Z
    //   46: aload_0
    //   47: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   50: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   53: sipush -322
    //   56: invokevirtual 1067	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   59: ldc_w 1088
    //   62: invokestatic 151	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: return
    //   66: aload_0
    //   67: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   70: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   73: getfield 377	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   76: ldc_w 633
    //   79: iconst_0
    //   80: invokeinterface 385 3 0
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
    //   112: invokevirtual 1101	com/tencent/smtt/sdk/m:a	(ZZ)Z
    //   115: ifeq +20 -> 135
    //   118: iconst_0
    //   119: putstatic 834	com/tencent/smtt/sdk/TbsDownloader:a	Z
    //   122: ldc_w 1088
    //   125: invokestatic 151	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: return
    //   129: iconst_0
    //   130: istore 9
    //   132: goto -28 -> 104
    //   135: aload_0
    //   136: iload_1
    //   137: putfield 1103	com/tencent/smtt/sdk/m:D	Z
    //   140: aload_0
    //   141: aload_0
    //   142: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   145: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   148: getfield 377	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   151: ldc_w 1105
    //   154: aconst_null
    //   155: invokeinterface 476 3 0
    //   160: putfield 1107	com/tencent/smtt/sdk/m:h	Ljava/lang/String;
    //   163: aload_0
    //   164: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   167: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   170: getfield 377	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   173: ldc_w 1109
    //   176: aconst_null
    //   177: invokeinterface 476 3 0
    //   182: astore 30
    //   184: ldc_w 277
    //   187: ldc_w 1111
    //   190: aload 30
    //   192: invokestatic 715	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   195: invokevirtual 464	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   198: iconst_1
    //   199: invokestatic 1114	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   202: aload_0
    //   203: aconst_null
    //   204: putfield 87	com/tencent/smtt/sdk/m:b	[Ljava/lang/String;
    //   207: aload_0
    //   208: iconst_0
    //   209: putfield 89	com/tencent/smtt/sdk/m:c	I
    //   212: iload_1
    //   213: ifne +36 -> 249
    //   216: aload 30
    //   218: ifnull +31 -> 249
    //   221: ldc 242
    //   223: aload 30
    //   225: invokevirtual 1117	java/lang/String:trim	()Ljava/lang/String;
    //   228: invokevirtual 483	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   231: ifne +18 -> 249
    //   234: aload_0
    //   235: aload 30
    //   237: invokevirtual 1117	java/lang/String:trim	()Ljava/lang/String;
    //   240: ldc_w 1119
    //   243: invokevirtual 1123	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   246: putfield 87	com/tencent/smtt/sdk/m:b	[Ljava/lang/String;
    //   249: ldc_w 277
    //   252: new 116	java/lang/StringBuilder
    //   255: dup
    //   256: ldc_w 1125
    //   259: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   262: aload_0
    //   263: getfield 1107	com/tencent/smtt/sdk/m:h	Ljava/lang/String;
    //   266: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: ldc_w 1127
    //   272: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload 30
    //   277: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: ldc_w 1129
    //   283: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: aload_0
    //   287: getfield 760	com/tencent/smtt/sdk/m:j	Ljava/lang/String;
    //   290: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: ldc_w 1131
    //   296: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload_0
    //   300: getfield 764	com/tencent/smtt/sdk/m:s	Z
    //   303: invokevirtual 486	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   306: ldc_w 1133
    //   309: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: aload_0
    //   313: getfield 401	com/tencent/smtt/sdk/m:u	Ljava/net/HttpURLConnection;
    //   316: invokevirtual 543	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   319: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: invokestatic 284	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   325: aload_0
    //   326: getfield 1107	com/tencent/smtt/sdk/m:h	Ljava/lang/String;
    //   329: ifnonnull +40 -> 369
    //   332: aload_0
    //   333: getfield 760	com/tencent/smtt/sdk/m:j	Ljava/lang/String;
    //   336: ifnonnull +33 -> 369
    //   339: getstatic 626	com/tencent/smtt/sdk/QbSdk:l	Lcom/tencent/smtt/sdk/TbsListener;
    //   342: bipush 110
    //   344: invokeinterface 631 2 0
    //   349: aload_0
    //   350: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   353: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   356: sipush -302
    //   359: invokevirtual 1067	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   362: ldc_w 1088
    //   365: invokestatic 151	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   368: return
    //   369: aload_0
    //   370: getfield 401	com/tencent/smtt/sdk/m:u	Ljava/net/HttpURLConnection;
    //   373: ifnull +40 -> 413
    //   376: aload_0
    //   377: getfield 764	com/tencent/smtt/sdk/m:s	Z
    //   380: ifne +33 -> 413
    //   383: getstatic 626	com/tencent/smtt/sdk/QbSdk:l	Lcom/tencent/smtt/sdk/TbsListener;
    //   386: bipush 110
    //   388: invokeinterface 631 2 0
    //   393: aload_0
    //   394: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   397: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   400: sipush -303
    //   403: invokevirtual 1067	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   406: ldc_w 1088
    //   409: invokestatic 151	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   412: return
    //   413: iload_1
    //   414: ifne +61 -> 475
    //   417: aload_0
    //   418: getfield 114	com/tencent/smtt/sdk/m:B	Ljava/util/Set;
    //   421: aload_0
    //   422: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   425: invokestatic 898	com/tencent/smtt/utils/Apn:getWifiSSID	(Landroid/content/Context;)Ljava/lang/String;
    //   428: invokeinterface 920 2 0
    //   433: ifeq +42 -> 475
    //   436: ldc_w 277
    //   439: ldc_w 1135
    //   442: invokestatic 284	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   445: getstatic 626	com/tencent/smtt/sdk/QbSdk:l	Lcom/tencent/smtt/sdk/TbsListener;
    //   448: bipush 110
    //   450: invokeinterface 631 2 0
    //   455: aload_0
    //   456: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   459: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   462: sipush -304
    //   465: invokevirtual 1067	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   468: ldc_w 1088
    //   471: invokestatic 151	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   474: return
    //   475: aload_0
    //   476: invokespecial 171	com/tencent/smtt/sdk/m:e	()V
    //   479: ldc_w 277
    //   482: ldc_w 1137
    //   485: iconst_1
    //   486: invokestatic 1114	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   489: aload_0
    //   490: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   493: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   496: invokevirtual 1140	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMaxflow	()J
    //   499: lstore 28
    //   501: iconst_0
    //   502: istore 6
    //   504: aload_0
    //   505: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   508: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   511: getfield 377	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   514: ldc_w 1142
    //   517: lconst_0
    //   518: invokeinterface 503 4 0
    //   523: lstore 10
    //   525: iload_1
    //   526: ifeq +439 -> 965
    //   529: aload_0
    //   530: getstatic 54	com/tencent/smtt/sdk/m:e	I
    //   533: putfield 85	com/tencent/smtt/sdk/m:C	I
    //   536: lload 10
    //   538: lstore 14
    //   540: iload 6
    //   542: istore 5
    //   544: iload_2
    //   545: ifeq +105 -> 650
    //   548: new 116	java/lang/StringBuilder
    //   551: dup
    //   552: ldc_w 636
    //   555: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   558: aload_0
    //   559: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   562: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   565: getfield 377	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   568: ldc_w 379
    //   571: iconst_0
    //   572: invokeinterface 385 3 0
    //   577: invokevirtual 390	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   580: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   583: astore 30
    //   585: new 116	java/lang/StringBuilder
    //   588: dup
    //   589: invokespecial 346	java/lang/StringBuilder:<init>	()V
    //   592: aload 30
    //   594: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: ldc_w 638
    //   600: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: aload_0
    //   604: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   607: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   610: getfield 377	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   613: ldc_w 499
    //   616: lconst_0
    //   617: invokeinterface 503 4 0
    //   622: invokevirtual 512	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   625: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   628: astore 30
    //   630: aload_0
    //   631: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   634: ldc_w 1144
    //   637: aload 30
    //   639: invokestatic 643	com/tencent/smtt/utils/r:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   642: iload 6
    //   644: istore 5
    //   646: lload 10
    //   648: lstore 14
    //   650: iload 5
    //   652: istore 6
    //   654: aload_0
    //   655: getfield 260	com/tencent/smtt/sdk/m:q	I
    //   658: aload_0
    //   659: getfield 85	com/tencent/smtt/sdk/m:C	I
    //   662: if_icmpgt +37 -> 699
    //   665: aload_0
    //   666: getfield 754	com/tencent/smtt/sdk/m:r	I
    //   669: bipush 8
    //   671: if_icmple +304 -> 975
    //   674: aload_0
    //   675: bipush 123
    //   677: aconst_null
    //   678: iconst_1
    //   679: invokespecial 557	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   682: aload_0
    //   683: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   686: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   689: sipush -306
    //   692: invokevirtual 1067	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   695: iload 5
    //   697: istore 6
    //   699: aload_0
    //   700: getfield 764	com/tencent/smtt/sdk/m:s	Z
    //   703: ifne +251 -> 954
    //   706: iload 6
    //   708: istore_1
    //   709: aload_0
    //   710: getfield 766	com/tencent/smtt/sdk/m:t	Z
    //   713: ifeq +170 -> 883
    //   716: iload 6
    //   718: istore_1
    //   719: aload_0
    //   720: getfield 87	com/tencent/smtt/sdk/m:b	[Ljava/lang/String;
    //   723: ifnonnull +67 -> 790
    //   726: iload 6
    //   728: istore_1
    //   729: iload 6
    //   731: ifne +59 -> 790
    //   734: iload_2
    //   735: ifeq +5684 -> 6419
    //   738: aload_0
    //   739: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   742: invokestatic 656	com/tencent/smtt/utils/r:c	(Landroid/content/Context;)Z
    //   745: ifeq +5674 -> 6419
    //   748: aload_0
    //   749: iconst_1
    //   750: iload 9
    //   752: new 161	java/io/File
    //   755: dup
    //   756: aload_0
    //   757: getfield 169	com/tencent/smtt/sdk/m:l	Ljava/io/File;
    //   760: new 116	java/lang/StringBuilder
    //   763: dup
    //   764: invokespecial 346	java/lang/StringBuilder:<init>	()V
    //   767: iconst_0
    //   768: invokestatic 219	com/tencent/smtt/sdk/TbsDownloader:getBackupFileName	(Z)Ljava/lang/String;
    //   771: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   774: ldc_w 661
    //   777: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   780: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   783: invokespecial 215	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   786: invokespecial 745	com/tencent/smtt/sdk/m:a	(ZZLjava/io/File;)Z
    //   789: istore_1
    //   790: aload_0
    //   791: getfield 109	com/tencent/smtt/sdk/m:w	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   794: astore 30
    //   796: iload_1
    //   797: ifeq +5633 -> 6430
    //   800: iconst_1
    //   801: istore_3
    //   802: aload 30
    //   804: iload_3
    //   805: invokevirtual 1147	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setUnpkgFlag	(I)V
    //   808: iload 9
    //   810: ifne +5630 -> 6440
    //   813: aload_0
    //   814: getfield 109	com/tencent/smtt/sdk/m:w	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   817: astore 30
    //   819: iload_1
    //   820: ifeq +5615 -> 6435
    //   823: iconst_1
    //   824: istore_3
    //   825: aload 30
    //   827: iload_3
    //   828: invokevirtual 1150	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setPatchUpdateFlag	(I)V
    //   831: ldc_w 277
    //   834: ldc_w 1152
    //   837: iload_1
    //   838: invokestatic 460	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   841: invokevirtual 464	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   844: invokestatic 284	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   847: iload_1
    //   848: ifeq +5603 -> 6451
    //   851: aload_0
    //   852: invokespecial 1154	com/tencent/smtt/sdk/m:f	()V
    //   855: aload_0
    //   856: iconst_1
    //   857: invokespecial 1069	com/tencent/smtt/sdk/m:c	(Z)V
    //   860: aload_0
    //   861: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   864: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   867: sipush -317
    //   870: invokevirtual 1067	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   873: aload_0
    //   874: bipush 100
    //   876: ldc_w 1156
    //   879: iconst_1
    //   880: invokespecial 557	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   883: aload_0
    //   884: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   887: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   890: astore 30
    //   892: iload_1
    //   893: ifeq +5580 -> 6473
    //   896: aload 30
    //   898: getfield 377	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   901: ldc_w 1158
    //   904: iconst_0
    //   905: invokeinterface 385 3 0
    //   910: istore_3
    //   911: aload 30
    //   913: getfield 600	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   916: ldc_w 1158
    //   919: iload_3
    //   920: iconst_1
    //   921: iadd
    //   922: invokestatic 548	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   925: invokeinterface 614 3 0
    //   930: pop
    //   931: aload 30
    //   933: invokevirtual 621	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   936: aload_0
    //   937: getfield 109	com/tencent/smtt/sdk/m:w	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   940: astore 30
    //   942: iload_1
    //   943: ifeq +5591 -> 6534
    //   946: iconst_1
    //   947: istore_3
    //   948: aload 30
    //   950: iload_3
    //   951: invokevirtual 1161	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownFinalFlag	(I)V
    //   954: aload_0
    //   955: invokespecial 1154	com/tencent/smtt/sdk/m:f	()V
    //   958: ldc_w 1088
    //   961: invokestatic 151	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   964: return
    //   965: aload_0
    //   966: getstatic 52	com/tencent/smtt/sdk/m:d	I
    //   969: putfield 85	com/tencent/smtt/sdk/m:C	I
    //   972: goto -436 -> 536
    //   975: invokestatic 186	java/lang/System:currentTimeMillis	()J
    //   978: lstore 24
    //   980: lload 14
    //   982: lstore 10
    //   984: iload_1
    //   985: ifne +408 -> 1393
    //   988: lload 14
    //   990: lstore 12
    //   992: iload 5
    //   994: istore 6
    //   996: lload 24
    //   998: aload_0
    //   999: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   1002: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1005: getfield 377	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1008: ldc_w 1163
    //   1011: lconst_0
    //   1012: invokeinterface 503 4 0
    //   1017: lsub
    //   1018: ldc2_w 1164
    //   1021: lcmp
    //   1022: ifle +230 -> 1252
    //   1025: lload 14
    //   1027: lstore 12
    //   1029: iload 5
    //   1031: istore 6
    //   1033: ldc_w 277
    //   1036: ldc_w 1167
    //   1039: invokestatic 284	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1042: lload 14
    //   1044: lstore 12
    //   1046: iload 5
    //   1048: istore 6
    //   1050: aload_0
    //   1051: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   1054: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1057: getfield 600	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1060: ldc_w 1163
    //   1063: lload 24
    //   1065: invokestatic 1172	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1068: invokeinterface 614 3 0
    //   1073: pop
    //   1074: lload 14
    //   1076: lstore 12
    //   1078: iload 5
    //   1080: istore 6
    //   1082: aload_0
    //   1083: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   1086: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1089: getfield 600	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1092: ldc_w 1142
    //   1095: lconst_0
    //   1096: invokestatic 1172	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1099: invokeinterface 614 3 0
    //   1104: pop
    //   1105: lload 14
    //   1107: lstore 12
    //   1109: iload 5
    //   1111: istore 6
    //   1113: aload_0
    //   1114: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   1117: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1120: invokevirtual 621	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1123: lconst_0
    //   1124: lstore 16
    //   1126: lload 16
    //   1128: lstore 10
    //   1130: lload 16
    //   1132: lstore 12
    //   1134: iload 5
    //   1136: istore 6
    //   1138: aload_0
    //   1139: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   1142: invokestatic 1173	com/tencent/smtt/utils/f:b	(Landroid/content/Context;)Z
    //   1145: ifne +248 -> 1393
    //   1148: lload 16
    //   1150: lstore 12
    //   1152: iload 5
    //   1154: istore 6
    //   1156: ldc_w 277
    //   1159: ldc_w 1175
    //   1162: iconst_1
    //   1163: invokestatic 1114	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1166: lload 16
    //   1168: lstore 12
    //   1170: iload 5
    //   1172: istore 6
    //   1174: aload_0
    //   1175: bipush 105
    //   1177: aconst_null
    //   1178: iconst_1
    //   1179: invokespecial 557	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   1182: lload 16
    //   1184: lstore 12
    //   1186: iload 5
    //   1188: istore 6
    //   1190: aload_0
    //   1191: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   1194: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1197: sipush -308
    //   1200: invokevirtual 1067	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   1203: iload 5
    //   1205: istore 6
    //   1207: iload_1
    //   1208: ifne -509 -> 699
    //   1211: aload_0
    //   1212: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   1215: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1218: getfield 600	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1221: ldc_w 1142
    //   1224: lload 16
    //   1226: invokestatic 1172	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1229: invokeinterface 614 3 0
    //   1234: pop
    //   1235: aload_0
    //   1236: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   1239: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1242: invokevirtual 621	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1245: iload 5
    //   1247: istore 6
    //   1249: goto -550 -> 699
    //   1252: lload 14
    //   1254: lstore 12
    //   1256: iload 5
    //   1258: istore 6
    //   1260: ldc_w 277
    //   1263: ldc_w 1177
    //   1266: lload 14
    //   1268: invokestatic 1180	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1271: invokevirtual 464	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1274: invokestatic 284	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1277: lload 14
    //   1279: lstore 16
    //   1281: lload 14
    //   1283: lload 28
    //   1285: lcmp
    //   1286: iflt -160 -> 1126
    //   1289: lload 14
    //   1291: lstore 12
    //   1293: iload 5
    //   1295: istore 6
    //   1297: ldc_w 277
    //   1300: ldc_w 1182
    //   1303: iconst_1
    //   1304: invokestatic 1114	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1307: lload 14
    //   1309: lstore 12
    //   1311: iload 5
    //   1313: istore 6
    //   1315: aload_0
    //   1316: bipush 112
    //   1318: aconst_null
    //   1319: iconst_1
    //   1320: invokespecial 557	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   1323: lload 14
    //   1325: lstore 12
    //   1327: iload 5
    //   1329: istore 6
    //   1331: aload_0
    //   1332: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   1335: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1338: sipush -307
    //   1341: invokevirtual 1067	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   1344: iload 5
    //   1346: istore 6
    //   1348: iload_1
    //   1349: ifne -650 -> 699
    //   1352: aload_0
    //   1353: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   1356: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1359: getfield 600	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1362: ldc_w 1142
    //   1365: lload 14
    //   1367: invokestatic 1172	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1370: invokeinterface 614 3 0
    //   1375: pop
    //   1376: aload_0
    //   1377: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   1380: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1383: invokevirtual 621	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1386: iload 5
    //   1388: istore 6
    //   1390: goto -691 -> 699
    //   1393: lload 10
    //   1395: lstore 12
    //   1397: iload 5
    //   1399: istore 6
    //   1401: aload_0
    //   1402: iconst_1
    //   1403: putfield 768	com/tencent/smtt/sdk/m:z	Z
    //   1406: lload 10
    //   1408: lstore 12
    //   1410: iload 5
    //   1412: istore 6
    //   1414: aload_0
    //   1415: getfield 760	com/tencent/smtt/sdk/m:j	Ljava/lang/String;
    //   1418: ifnull +711 -> 2129
    //   1421: lload 10
    //   1423: lstore 12
    //   1425: iload 5
    //   1427: istore 6
    //   1429: aload_0
    //   1430: getfield 760	com/tencent/smtt/sdk/m:j	Ljava/lang/String;
    //   1433: astore 30
    //   1435: lload 10
    //   1437: lstore 12
    //   1439: iload 5
    //   1441: istore 6
    //   1443: ldc_w 277
    //   1446: new 116	java/lang/StringBuilder
    //   1449: dup
    //   1450: ldc_w 1184
    //   1453: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1456: aload 30
    //   1458: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1461: ldc_w 1186
    //   1464: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1467: aload_0
    //   1468: getfield 260	com/tencent/smtt/sdk/m:q	I
    //   1471: invokevirtual 390	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1474: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1477: iconst_1
    //   1478: invokestatic 1114	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1481: lload 10
    //   1483: lstore 12
    //   1485: iload 5
    //   1487: istore 6
    //   1489: aload 30
    //   1491: aload_0
    //   1492: getfield 1188	com/tencent/smtt/sdk/m:i	Ljava/lang/String;
    //   1495: invokevirtual 483	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1498: ifne +20 -> 1518
    //   1501: lload 10
    //   1503: lstore 12
    //   1505: iload 5
    //   1507: istore 6
    //   1509: aload_0
    //   1510: getfield 109	com/tencent/smtt/sdk/m:w	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   1513: aload 30
    //   1515: invokevirtual 1191	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownloadUrl	(Ljava/lang/String;)V
    //   1518: lload 10
    //   1520: lstore 12
    //   1522: iload 5
    //   1524: istore 6
    //   1526: aload_0
    //   1527: aload 30
    //   1529: putfield 1188	com/tencent/smtt/sdk/m:i	Ljava/lang/String;
    //   1532: lload 10
    //   1534: lstore 12
    //   1536: iload 5
    //   1538: istore 6
    //   1540: aload_0
    //   1541: aload 30
    //   1543: invokespecial 1193	com/tencent/smtt/sdk/m:a	(Ljava/lang/String;)V
    //   1546: lconst_0
    //   1547: lstore 14
    //   1549: lload 10
    //   1551: lstore 12
    //   1553: iload 5
    //   1555: istore 6
    //   1557: aload_0
    //   1558: getfield 762	com/tencent/smtt/sdk/m:p	Z
    //   1561: ifne +127 -> 1688
    //   1564: lload 10
    //   1566: lstore 12
    //   1568: iload 5
    //   1570: istore 6
    //   1572: aload_0
    //   1573: invokespecial 1195	com/tencent/smtt/sdk/m:j	()J
    //   1576: lstore 14
    //   1578: lload 10
    //   1580: lstore 12
    //   1582: iload 5
    //   1584: istore 6
    //   1586: ldc_w 277
    //   1589: ldc_w 1197
    //   1592: lload 14
    //   1594: invokestatic 1180	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1597: invokevirtual 464	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1600: invokestatic 284	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1603: lload 10
    //   1605: lstore 12
    //   1607: iload 5
    //   1609: istore 6
    //   1611: aload_0
    //   1612: getfield 758	com/tencent/smtt/sdk/m:m	J
    //   1615: lconst_0
    //   1616: lcmp
    //   1617: ifgt +529 -> 2146
    //   1620: lload 10
    //   1622: lstore 12
    //   1624: iload 5
    //   1626: istore 6
    //   1628: ldc_w 277
    //   1631: ldc_w 1199
    //   1634: lload 14
    //   1636: invokestatic 1180	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1639: invokevirtual 464	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1642: iconst_1
    //   1643: invokestatic 1114	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1646: lload 10
    //   1648: lstore 12
    //   1650: iload 5
    //   1652: istore 6
    //   1654: aload_0
    //   1655: getfield 401	com/tencent/smtt/sdk/m:u	Ljava/net/HttpURLConnection;
    //   1658: ldc_w 1201
    //   1661: new 116	java/lang/StringBuilder
    //   1664: dup
    //   1665: ldc_w 1203
    //   1668: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1671: lload 14
    //   1673: invokevirtual 512	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1676: ldc_w 1205
    //   1679: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1682: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1685: invokevirtual 418	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1688: lload 10
    //   1690: lstore 12
    //   1692: iload 5
    //   1694: istore 6
    //   1696: aload_0
    //   1697: getfield 109	com/tencent/smtt/sdk/m:w	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   1700: astore 30
    //   1702: lload 14
    //   1704: lconst_0
    //   1705: lcmp
    //   1706: ifne +689 -> 2395
    //   1709: iconst_0
    //   1710: istore_3
    //   1711: lload 10
    //   1713: lstore 12
    //   1715: iload 5
    //   1717: istore 6
    //   1719: aload 30
    //   1721: iload_3
    //   1722: invokevirtual 1208	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownloadCancel	(I)V
    //   1725: lload 10
    //   1727: lstore 12
    //   1729: iload 5
    //   1731: istore 6
    //   1733: aload_0
    //   1734: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   1737: invokestatic 797	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   1740: istore_3
    //   1741: lload 10
    //   1743: lstore 12
    //   1745: iload 5
    //   1747: istore 6
    //   1749: aload_0
    //   1750: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   1753: invokestatic 793	com/tencent/smtt/utils/Apn:getApnInfo	(Landroid/content/Context;)Ljava/lang/String;
    //   1756: astore 30
    //   1758: lload 10
    //   1760: lstore 12
    //   1762: iload 5
    //   1764: istore 6
    //   1766: aload_0
    //   1767: getfield 173	com/tencent/smtt/sdk/m:x	Ljava/lang/String;
    //   1770: ifnonnull +630 -> 2400
    //   1773: lload 10
    //   1775: lstore 12
    //   1777: iload 5
    //   1779: istore 6
    //   1781: aload_0
    //   1782: getfield 175	com/tencent/smtt/sdk/m:y	I
    //   1785: iconst_m1
    //   1786: if_icmpne +614 -> 2400
    //   1789: lload 10
    //   1791: lstore 12
    //   1793: iload 5
    //   1795: istore 6
    //   1797: aload_0
    //   1798: aload 30
    //   1800: putfield 173	com/tencent/smtt/sdk/m:x	Ljava/lang/String;
    //   1803: lload 10
    //   1805: lstore 12
    //   1807: iload 5
    //   1809: istore 6
    //   1811: aload_0
    //   1812: iload_3
    //   1813: putfield 175	com/tencent/smtt/sdk/m:y	I
    //   1816: lload 10
    //   1818: lstore 12
    //   1820: iload 5
    //   1822: istore 6
    //   1824: aload_0
    //   1825: getfield 260	com/tencent/smtt/sdk/m:q	I
    //   1828: ifle +25 -> 1853
    //   1831: lload 10
    //   1833: lstore 12
    //   1835: iload 5
    //   1837: istore 6
    //   1839: aload_0
    //   1840: getfield 401	com/tencent/smtt/sdk/m:u	Ljava/net/HttpURLConnection;
    //   1843: ldc_w 1210
    //   1846: aload_0
    //   1847: getfield 1107	com/tencent/smtt/sdk/m:h	Ljava/lang/String;
    //   1850: invokevirtual 1213	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1853: lload 10
    //   1855: lstore 12
    //   1857: iload 5
    //   1859: istore 6
    //   1861: aload_0
    //   1862: getfield 401	com/tencent/smtt/sdk/m:u	Ljava/net/HttpURLConnection;
    //   1865: invokevirtual 909	java/net/HttpURLConnection:getResponseCode	()I
    //   1868: istore_3
    //   1869: lload 10
    //   1871: lstore 12
    //   1873: iload 5
    //   1875: istore 6
    //   1877: ldc_w 277
    //   1880: ldc_w 1215
    //   1883: iload_3
    //   1884: invokestatic 654	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1887: invokevirtual 464	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1890: invokestatic 284	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1893: lload 10
    //   1895: lstore 12
    //   1897: iload 5
    //   1899: istore 6
    //   1901: aload_0
    //   1902: getfield 109	com/tencent/smtt/sdk/m:w	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   1905: iload_3
    //   1906: invokevirtual 1218	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setHttpCode	(I)V
    //   1909: iload_1
    //   1910: ifne +134 -> 2044
    //   1913: lload 10
    //   1915: lstore 12
    //   1917: iload 5
    //   1919: istore 6
    //   1921: aload_0
    //   1922: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   1925: invokestatic 210	com/tencent/smtt/sdk/TbsDownloader:getOverSea	(Landroid/content/Context;)Z
    //   1928: ifne +116 -> 2044
    //   1931: lload 10
    //   1933: lstore 12
    //   1935: iload 5
    //   1937: istore 6
    //   1939: aload_0
    //   1940: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   1943: invokestatic 797	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   1946: iconst_3
    //   1947: if_icmpne +21 -> 1968
    //   1950: lload 10
    //   1952: lstore 12
    //   1954: iload 5
    //   1956: istore 6
    //   1958: aload_0
    //   1959: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   1962: invokestatic 797	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   1965: ifne +79 -> 2044
    //   1968: lload 10
    //   1970: lstore 12
    //   1972: iload 5
    //   1974: istore 6
    //   1976: invokestatic 1049	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   1979: ifne +65 -> 2044
    //   1982: lload 10
    //   1984: lstore 12
    //   1986: iload 5
    //   1988: istore 6
    //   1990: aload_0
    //   1991: invokevirtual 1219	com/tencent/smtt/sdk/m:b	()V
    //   1994: lload 10
    //   1996: lstore 12
    //   1998: iload 5
    //   2000: istore 6
    //   2002: getstatic 626	com/tencent/smtt/sdk/QbSdk:l	Lcom/tencent/smtt/sdk/TbsListener;
    //   2005: ifnull +21 -> 2026
    //   2008: lload 10
    //   2010: lstore 12
    //   2012: iload 5
    //   2014: istore 6
    //   2016: getstatic 626	com/tencent/smtt/sdk/QbSdk:l	Lcom/tencent/smtt/sdk/TbsListener;
    //   2019: bipush 111
    //   2021: invokeinterface 631 2 0
    //   2026: lload 10
    //   2028: lstore 12
    //   2030: iload 5
    //   2032: istore 6
    //   2034: ldc_w 277
    //   2037: ldc_w 1221
    //   2040: iconst_0
    //   2041: invokestatic 1114	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   2044: lload 10
    //   2046: lstore 12
    //   2048: iload 5
    //   2050: istore 6
    //   2052: aload_0
    //   2053: getfield 764	com/tencent/smtt/sdk/m:s	Z
    //   2056: ifeq +4593 -> 6649
    //   2059: lload 10
    //   2061: lstore 12
    //   2063: iload 5
    //   2065: istore 6
    //   2067: aload_0
    //   2068: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   2071: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2074: sipush -309
    //   2077: invokevirtual 1067	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2080: iload 5
    //   2082: istore 6
    //   2084: iload_1
    //   2085: ifne -1386 -> 699
    //   2088: aload_0
    //   2089: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   2092: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2095: getfield 600	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2098: ldc_w 1142
    //   2101: lload 10
    //   2103: invokestatic 1172	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2106: invokeinterface 614 3 0
    //   2111: pop
    //   2112: aload_0
    //   2113: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   2116: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2119: invokevirtual 621	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2122: iload 5
    //   2124: istore 6
    //   2126: goto -1427 -> 699
    //   2129: lload 10
    //   2131: lstore 12
    //   2133: iload 5
    //   2135: istore 6
    //   2137: aload_0
    //   2138: getfield 1107	com/tencent/smtt/sdk/m:h	Ljava/lang/String;
    //   2141: astore 30
    //   2143: goto -708 -> 1435
    //   2146: lload 10
    //   2148: lstore 12
    //   2150: iload 5
    //   2152: istore 6
    //   2154: ldc_w 277
    //   2157: new 116	java/lang/StringBuilder
    //   2160: dup
    //   2161: ldc_w 1223
    //   2164: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2167: lload 14
    //   2169: invokevirtual 512	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2172: ldc_w 1225
    //   2175: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2178: aload_0
    //   2179: getfield 758	com/tencent/smtt/sdk/m:m	J
    //   2182: invokevirtual 512	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2185: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2188: iconst_1
    //   2189: invokestatic 1114	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   2192: lload 10
    //   2194: lstore 12
    //   2196: iload 5
    //   2198: istore 6
    //   2200: aload_0
    //   2201: getfield 401	com/tencent/smtt/sdk/m:u	Ljava/net/HttpURLConnection;
    //   2204: ldc_w 1201
    //   2207: new 116	java/lang/StringBuilder
    //   2210: dup
    //   2211: ldc_w 1203
    //   2214: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2217: lload 14
    //   2219: invokevirtual 512	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2222: ldc_w 1205
    //   2225: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2228: aload_0
    //   2229: getfield 758	com/tencent/smtt/sdk/m:m	J
    //   2232: invokevirtual 512	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2235: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2238: invokevirtual 418	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   2241: goto -553 -> 1688
    //   2244: astore 30
    //   2246: iload 6
    //   2248: istore 7
    //   2250: aload 30
    //   2252: instanceof 1227
    //   2255: ifeq +4028 -> 6283
    //   2258: iload_1
    //   2259: ifne +4024 -> 6283
    //   2262: aload_0
    //   2263: getfield 87	com/tencent/smtt/sdk/m:b	[Ljava/lang/String;
    //   2266: ifnull +4017 -> 6283
    //   2269: aload_0
    //   2270: iconst_0
    //   2271: invokevirtual 1229	com/tencent/smtt/sdk/m:a	(Z)Z
    //   2274: ifeq +4009 -> 6283
    //   2277: ldc_w 277
    //   2280: new 116	java/lang/StringBuilder
    //   2283: dup
    //   2284: ldc_w 1231
    //   2287: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2290: aload_0
    //   2291: getfield 760	com/tencent/smtt/sdk/m:j	Ljava/lang/String;
    //   2294: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2297: ldc_w 1233
    //   2300: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2303: aload 30
    //   2305: invokevirtual 442	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2308: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2311: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2314: invokestatic 394	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2317: aload_0
    //   2318: bipush 125
    //   2320: aconst_null
    //   2321: iconst_1
    //   2322: invokespecial 557	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   2325: aload_0
    //   2326: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   2329: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2332: sipush -316
    //   2335: invokevirtual 1067	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2338: lload 12
    //   2340: lstore 14
    //   2342: iload 7
    //   2344: istore 5
    //   2346: iload_1
    //   2347: ifne -1697 -> 650
    //   2350: aload_0
    //   2351: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   2354: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2357: getfield 600	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2360: ldc_w 1142
    //   2363: lload 12
    //   2365: invokestatic 1172	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2368: invokeinterface 614 3 0
    //   2373: pop
    //   2374: aload_0
    //   2375: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   2378: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2381: invokevirtual 621	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2384: lload 12
    //   2386: lstore 14
    //   2388: iload 7
    //   2390: istore 5
    //   2392: goto -1742 -> 650
    //   2395: iconst_1
    //   2396: istore_3
    //   2397: goto -686 -> 1711
    //   2400: lload 10
    //   2402: lstore 12
    //   2404: iload 5
    //   2406: istore 6
    //   2408: iload_3
    //   2409: aload_0
    //   2410: getfield 175	com/tencent/smtt/sdk/m:y	I
    //   2413: if_icmpne +23 -> 2436
    //   2416: lload 10
    //   2418: lstore 12
    //   2420: iload 5
    //   2422: istore 6
    //   2424: aload 30
    //   2426: aload_0
    //   2427: getfield 173	com/tencent/smtt/sdk/m:x	Ljava/lang/String;
    //   2430: invokevirtual 483	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2433: ifne -617 -> 1816
    //   2436: lload 10
    //   2438: lstore 12
    //   2440: iload 5
    //   2442: istore 6
    //   2444: aload_0
    //   2445: getfield 109	com/tencent/smtt/sdk/m:w	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   2448: iconst_0
    //   2449: invokevirtual 806	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setNetworkChange	(I)V
    //   2452: lload 10
    //   2454: lstore 12
    //   2456: iload 5
    //   2458: istore 6
    //   2460: aload_0
    //   2461: aload 30
    //   2463: putfield 173	com/tencent/smtt/sdk/m:x	Ljava/lang/String;
    //   2466: lload 10
    //   2468: lstore 12
    //   2470: iload 5
    //   2472: istore 6
    //   2474: aload_0
    //   2475: iload_3
    //   2476: putfield 175	com/tencent/smtt/sdk/m:y	I
    //   2479: goto -663 -> 1816
    //   2482: lload 10
    //   2484: lstore 12
    //   2486: iload 5
    //   2488: istore 6
    //   2490: aload_0
    //   2491: aload_0
    //   2492: getfield 401	com/tencent/smtt/sdk/m:u	Ljava/net/HttpURLConnection;
    //   2495: invokevirtual 1236	java/net/HttpURLConnection:getContentLength	()I
    //   2498: i2l
    //   2499: lload 14
    //   2501: ladd
    //   2502: putfield 758	com/tencent/smtt/sdk/m:m	J
    //   2505: lload 10
    //   2507: lstore 12
    //   2509: iload 5
    //   2511: istore 6
    //   2513: ldc_w 277
    //   2516: new 116	java/lang/StringBuilder
    //   2519: dup
    //   2520: ldc_w 1238
    //   2523: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2526: aload_0
    //   2527: getfield 758	com/tencent/smtt/sdk/m:m	J
    //   2530: invokevirtual 512	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2533: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2536: invokestatic 284	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2539: lload 10
    //   2541: lstore 12
    //   2543: iload 5
    //   2545: istore 6
    //   2547: aload_0
    //   2548: getfield 109	com/tencent/smtt/sdk/m:w	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   2551: aload_0
    //   2552: getfield 758	com/tencent/smtt/sdk/m:m	J
    //   2555: invokevirtual 1241	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setPkgSize	(J)V
    //   2558: lload 10
    //   2560: lstore 12
    //   2562: iload 5
    //   2564: istore 6
    //   2566: aload_0
    //   2567: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   2570: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2573: getfield 377	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   2576: ldc_w 499
    //   2579: lconst_0
    //   2580: invokeinterface 503 4 0
    //   2585: lstore 16
    //   2587: lload 16
    //   2589: lconst_0
    //   2590: lcmp
    //   2591: ifeq +360 -> 2951
    //   2594: lload 10
    //   2596: lstore 12
    //   2598: iload 5
    //   2600: istore 6
    //   2602: aload_0
    //   2603: getfield 758	com/tencent/smtt/sdk/m:m	J
    //   2606: lload 16
    //   2608: lcmp
    //   2609: ifeq +342 -> 2951
    //   2612: lload 10
    //   2614: lstore 12
    //   2616: iload 5
    //   2618: istore 6
    //   2620: ldc_w 277
    //   2623: new 116	java/lang/StringBuilder
    //   2626: dup
    //   2627: ldc_w 1243
    //   2630: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2633: lload 16
    //   2635: invokevirtual 512	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2638: ldc_w 1245
    //   2641: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2644: aload_0
    //   2645: getfield 758	com/tencent/smtt/sdk/m:m	J
    //   2648: invokevirtual 512	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2651: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2654: iconst_1
    //   2655: invokestatic 1114	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   2658: iload_1
    //   2659: ifne +250 -> 2909
    //   2662: lload 10
    //   2664: lstore 12
    //   2666: iload 5
    //   2668: istore 6
    //   2670: aload_0
    //   2671: invokespecial 446	com/tencent/smtt/sdk/m:m	()Z
    //   2674: ifne +35 -> 2709
    //   2677: lload 10
    //   2679: lstore 12
    //   2681: iload 5
    //   2683: istore 6
    //   2685: invokestatic 1049	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   2688: ifeq +221 -> 2909
    //   2691: lload 10
    //   2693: lstore 12
    //   2695: iload 5
    //   2697: istore 6
    //   2699: aload_0
    //   2700: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   2703: invokestatic 812	com/tencent/smtt/utils/Apn:isNetworkAvailable	(Landroid/content/Context;)Z
    //   2706: ifeq +203 -> 2909
    //   2709: lload 10
    //   2711: lstore 12
    //   2713: iload 5
    //   2715: istore 6
    //   2717: aload_0
    //   2718: getfield 87	com/tencent/smtt/sdk/m:b	[Ljava/lang/String;
    //   2721: ifnull +72 -> 2793
    //   2724: lload 10
    //   2726: lstore 12
    //   2728: iload 5
    //   2730: istore 6
    //   2732: aload_0
    //   2733: iconst_0
    //   2734: invokevirtual 1229	com/tencent/smtt/sdk/m:a	(Z)Z
    //   2737: istore 7
    //   2739: iload 7
    //   2741: ifeq +52 -> 2793
    //   2744: lload 10
    //   2746: lstore 14
    //   2748: iload_1
    //   2749: ifne -2099 -> 650
    //   2752: aload_0
    //   2753: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   2756: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2759: getfield 600	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2762: ldc_w 1142
    //   2765: lload 10
    //   2767: invokestatic 1172	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2770: invokeinterface 614 3 0
    //   2775: pop
    //   2776: aload_0
    //   2777: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   2780: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2783: invokevirtual 621	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2786: lload 10
    //   2788: lstore 14
    //   2790: goto -2140 -> 650
    //   2793: lload 10
    //   2795: lstore 12
    //   2797: iload 5
    //   2799: istore 6
    //   2801: aload_0
    //   2802: bipush 113
    //   2804: new 116	java/lang/StringBuilder
    //   2807: dup
    //   2808: ldc_w 1247
    //   2811: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2814: lload 16
    //   2816: invokevirtual 512	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2819: ldc_w 1245
    //   2822: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2825: aload_0
    //   2826: getfield 758	com/tencent/smtt/sdk/m:m	J
    //   2829: invokevirtual 512	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2832: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2835: iconst_1
    //   2836: invokespecial 557	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   2839: lload 10
    //   2841: lstore 12
    //   2843: iload 5
    //   2845: istore 6
    //   2847: aload_0
    //   2848: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   2851: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2854: sipush -310
    //   2857: invokevirtual 1067	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2860: iload 5
    //   2862: istore 6
    //   2864: iload_1
    //   2865: ifne -2166 -> 699
    //   2868: aload_0
    //   2869: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   2872: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2875: getfield 600	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2878: ldc_w 1142
    //   2881: lload 10
    //   2883: invokestatic 1172	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2886: invokeinterface 614 3 0
    //   2891: pop
    //   2892: aload_0
    //   2893: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   2896: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2899: invokevirtual 621	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2902: iload 5
    //   2904: istore 6
    //   2906: goto -2207 -> 699
    //   2909: lload 10
    //   2911: lstore 12
    //   2913: iload 5
    //   2915: istore 6
    //   2917: aload_0
    //   2918: bipush 101
    //   2920: ldc_w 1249
    //   2923: iconst_1
    //   2924: invokespecial 557	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   2927: lload 10
    //   2929: lstore 12
    //   2931: iload 5
    //   2933: istore 6
    //   2935: aload_0
    //   2936: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   2939: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2942: sipush -304
    //   2945: invokevirtual 1067	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2948: goto -88 -> 2860
    //   2951: aconst_null
    //   2952: astore 34
    //   2954: aconst_null
    //   2955: astore 30
    //   2957: aconst_null
    //   2958: astore 32
    //   2960: lload 10
    //   2962: lstore 12
    //   2964: iload 5
    //   2966: istore 6
    //   2968: ldc_w 277
    //   2971: ldc_w 1251
    //   2974: invokestatic 284	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2977: aload_0
    //   2978: getfield 401	com/tencent/smtt/sdk/m:u	Ljava/net/HttpURLConnection;
    //   2981: invokevirtual 906	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   2984: astore 31
    //   2986: aload 31
    //   2988: ifnull +1700 -> 4688
    //   2991: aload_0
    //   2992: getfield 401	com/tencent/smtt/sdk/m:u	Ljava/net/HttpURLConnection;
    //   2995: invokevirtual 1254	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   2998: astore 30
    //   3000: aload 30
    //   3002: ifnull +364 -> 3366
    //   3005: aload 30
    //   3007: ldc_w 1256
    //   3010: invokevirtual 339	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3013: ifeq +353 -> 3366
    //   3016: new 1258	java/util/zip/GZIPInputStream
    //   3019: dup
    //   3020: aload 31
    //   3022: invokespecial 1259	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   3025: astore 30
    //   3027: sipush 8192
    //   3030: newarray byte
    //   3032: astore 35
    //   3034: iload_2
    //   3035: ifeq +534 -> 3569
    //   3038: aload_0
    //   3039: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   3042: invokestatic 656	com/tencent/smtt/utils/r:c	(Landroid/content/Context;)Z
    //   3045: ifeq +524 -> 3569
    //   3048: new 161	java/io/File
    //   3051: dup
    //   3052: aload_0
    //   3053: getfield 169	com/tencent/smtt/sdk/m:l	Ljava/io/File;
    //   3056: new 116	java/lang/StringBuilder
    //   3059: dup
    //   3060: invokespecial 346	java/lang/StringBuilder:<init>	()V
    //   3063: iconst_0
    //   3064: invokestatic 219	com/tencent/smtt/sdk/TbsDownloader:getBackupFileName	(Z)Ljava/lang/String;
    //   3067: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3070: ldc_w 661
    //   3073: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3076: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3079: invokespecial 215	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   3082: astore 33
    //   3084: aload 33
    //   3086: astore 32
    //   3088: aload 33
    //   3090: invokevirtual 201	java/io/File:exists	()Z
    //   3093: ifeq +13 -> 3106
    //   3096: aload 33
    //   3098: invokevirtual 323	java/io/File:delete	()Z
    //   3101: pop
    //   3102: aload 33
    //   3104: astore 32
    //   3106: ldc_w 277
    //   3109: new 116	java/lang/StringBuilder
    //   3112: dup
    //   3113: ldc_w 1261
    //   3116: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3119: aload 32
    //   3121: invokevirtual 301	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   3124: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3127: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3130: iconst_1
    //   3131: invokestatic 1114	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   3134: new 1263	java/io/FileOutputStream
    //   3137: dup
    //   3138: aload 32
    //   3140: iconst_1
    //   3141: invokespecial 1266	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   3144: astore 33
    //   3146: lload 10
    //   3148: lstore 12
    //   3150: lload 10
    //   3152: lstore 18
    //   3154: invokestatic 186	java/lang/System:currentTimeMillis	()J
    //   3157: lstore 16
    //   3159: iconst_0
    //   3160: istore_3
    //   3161: lload 14
    //   3163: lstore 22
    //   3165: iload 5
    //   3167: istore 6
    //   3169: lload 10
    //   3171: lstore 18
    //   3173: iload 5
    //   3175: istore 8
    //   3177: lload 10
    //   3179: lstore 20
    //   3181: aload_0
    //   3182: getfield 764	com/tencent/smtt/sdk/m:s	Z
    //   3185: ifeq +432 -> 3617
    //   3188: iload 5
    //   3190: istore 6
    //   3192: lload 10
    //   3194: lstore 18
    //   3196: iload 5
    //   3198: istore 8
    //   3200: lload 10
    //   3202: lstore 20
    //   3204: ldc_w 277
    //   3207: ldc_w 1268
    //   3210: iconst_1
    //   3211: invokestatic 1114	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   3214: iload 5
    //   3216: istore 6
    //   3218: lload 10
    //   3220: lstore 18
    //   3222: iload 5
    //   3224: istore 8
    //   3226: lload 10
    //   3228: lstore 20
    //   3230: aload_0
    //   3231: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   3234: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3237: sipush -309
    //   3240: invokevirtual 1067	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3243: iload 5
    //   3245: istore 7
    //   3247: lload 10
    //   3249: lstore 14
    //   3251: iload 7
    //   3253: istore 5
    //   3255: aload 30
    //   3257: astore 34
    //   3259: aload 33
    //   3261: astore 32
    //   3263: iload_3
    //   3264: ifeq +1434 -> 4698
    //   3267: lload 10
    //   3269: lstore 12
    //   3271: iload 7
    //   3273: istore 6
    //   3275: aload_0
    //   3276: aload 33
    //   3278: invokespecial 886	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   3281: lload 10
    //   3283: lstore 12
    //   3285: iload 7
    //   3287: istore 6
    //   3289: aload_0
    //   3290: aload 30
    //   3292: invokespecial 886	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   3295: lload 10
    //   3297: lstore 12
    //   3299: iload 7
    //   3301: istore 6
    //   3303: aload_0
    //   3304: aload 31
    //   3306: invokespecial 886	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   3309: lload 10
    //   3311: lstore 14
    //   3313: iload 7
    //   3315: istore 5
    //   3317: iload_1
    //   3318: ifne -2668 -> 650
    //   3321: aload_0
    //   3322: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   3325: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3328: getfield 600	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   3331: ldc_w 1142
    //   3334: lload 10
    //   3336: invokestatic 1172	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3339: invokeinterface 614 3 0
    //   3344: pop
    //   3345: aload_0
    //   3346: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   3349: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3352: invokevirtual 621	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   3355: lload 10
    //   3357: lstore 14
    //   3359: iload 7
    //   3361: istore 5
    //   3363: goto -2713 -> 650
    //   3366: aload 30
    //   3368: ifnull +194 -> 3562
    //   3371: aload 30
    //   3373: ldc_w 1270
    //   3376: invokevirtual 339	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3379: ifeq +183 -> 3562
    //   3382: new 1272	java/util/zip/InflaterInputStream
    //   3385: dup
    //   3386: aload 31
    //   3388: new 1274	java/util/zip/Inflater
    //   3391: dup
    //   3392: iconst_1
    //   3393: invokespecial 1276	java/util/zip/Inflater:<init>	(Z)V
    //   3396: invokespecial 1279	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Inflater;)V
    //   3399: astore 30
    //   3401: goto -374 -> 3027
    //   3404: astore 35
    //   3406: aload 31
    //   3408: astore 30
    //   3410: aload 34
    //   3412: astore 33
    //   3414: aload 35
    //   3416: astore 31
    //   3418: iload 5
    //   3420: istore 7
    //   3422: aload 31
    //   3424: instanceof 1281
    //   3427: ifne +11 -> 3438
    //   3430: aload 31
    //   3432: instanceof 1283
    //   3435: ifeq +1390 -> 4825
    //   3438: aload_0
    //   3439: ldc_w 1284
    //   3442: putfield 81	com/tencent/smtt/sdk/m:n	I
    //   3445: aload_0
    //   3446: lconst_0
    //   3447: invokespecial 1286	com/tencent/smtt/sdk/m:a	(J)V
    //   3450: aload_0
    //   3451: bipush 103
    //   3453: aload_0
    //   3454: aload 31
    //   3456: invokespecial 555	com/tencent/smtt/sdk/m:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3459: iconst_0
    //   3460: invokespecial 557	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   3463: lload 10
    //   3465: lstore 12
    //   3467: iload 7
    //   3469: istore 6
    //   3471: aload_0
    //   3472: aload 33
    //   3474: invokespecial 886	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   3477: lload 10
    //   3479: lstore 12
    //   3481: iload 7
    //   3483: istore 6
    //   3485: aload_0
    //   3486: aload 32
    //   3488: invokespecial 886	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   3491: lload 10
    //   3493: lstore 12
    //   3495: iload 7
    //   3497: istore 6
    //   3499: aload_0
    //   3500: aload 30
    //   3502: invokespecial 886	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   3505: lload 10
    //   3507: lstore 14
    //   3509: iload 7
    //   3511: istore 5
    //   3513: iload_1
    //   3514: ifne -2864 -> 650
    //   3517: aload_0
    //   3518: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   3521: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3524: getfield 600	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   3527: ldc_w 1142
    //   3530: lload 10
    //   3532: invokestatic 1172	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3535: invokeinterface 614 3 0
    //   3540: pop
    //   3541: aload_0
    //   3542: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   3545: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3548: invokevirtual 621	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   3551: lload 10
    //   3553: lstore 14
    //   3555: iload 7
    //   3557: istore 5
    //   3559: goto -2909 -> 650
    //   3562: aload 31
    //   3564: astore 30
    //   3566: goto -539 -> 3027
    //   3569: new 161	java/io/File
    //   3572: dup
    //   3573: aload_0
    //   3574: getfield 144	com/tencent/smtt/sdk/m:k	Ljava/io/File;
    //   3577: ldc_w 470
    //   3580: invokespecial 215	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   3583: astore 32
    //   3585: goto -479 -> 3106
    //   3588: astore 32
    //   3590: aload 31
    //   3592: astore 33
    //   3594: iload 5
    //   3596: istore 7
    //   3598: aload 32
    //   3600: astore 31
    //   3602: aload 30
    //   3604: astore 32
    //   3606: aload 33
    //   3608: astore 30
    //   3610: aload 34
    //   3612: astore 33
    //   3614: goto -192 -> 3422
    //   3617: iload 5
    //   3619: istore 6
    //   3621: lload 10
    //   3623: lstore 18
    //   3625: iload 5
    //   3627: istore 8
    //   3629: lload 10
    //   3631: lstore 20
    //   3633: aload 30
    //   3635: aload 35
    //   3637: iconst_0
    //   3638: sipush 8192
    //   3641: invokevirtual 1292	java/io/InputStream:read	([BII)I
    //   3644: istore 4
    //   3646: iload 4
    //   3648: ifgt +199 -> 3847
    //   3651: iload 5
    //   3653: istore 6
    //   3655: lload 10
    //   3657: lstore 18
    //   3659: iload 5
    //   3661: istore 8
    //   3663: lload 10
    //   3665: lstore 20
    //   3667: aload_0
    //   3668: getfield 87	com/tencent/smtt/sdk/m:b	[Ljava/lang/String;
    //   3671: ifnull +93 -> 3764
    //   3674: iload 5
    //   3676: istore 6
    //   3678: lload 10
    //   3680: lstore 18
    //   3682: iload 5
    //   3684: istore 8
    //   3686: lload 10
    //   3688: lstore 20
    //   3690: aload_0
    //   3691: iconst_1
    //   3692: iload 9
    //   3694: invokespecial 1075	com/tencent/smtt/sdk/m:c	(ZZ)Z
    //   3697: ifne +67 -> 3764
    //   3700: iload_1
    //   3701: ifne +36 -> 3737
    //   3704: iload 5
    //   3706: istore 6
    //   3708: lload 10
    //   3710: lstore 18
    //   3712: iload 5
    //   3714: istore 8
    //   3716: lload 10
    //   3718: lstore 20
    //   3720: aload_0
    //   3721: iconst_0
    //   3722: invokevirtual 1229	com/tencent/smtt/sdk/m:a	(Z)Z
    //   3725: ifeq +12 -> 3737
    //   3728: iconst_1
    //   3729: istore_3
    //   3730: iload 5
    //   3732: istore 7
    //   3734: goto -487 -> 3247
    //   3737: iload 5
    //   3739: istore 6
    //   3741: lload 10
    //   3743: lstore 18
    //   3745: iload 5
    //   3747: istore 8
    //   3749: lload 10
    //   3751: lstore 20
    //   3753: aload_0
    //   3754: iconst_1
    //   3755: putfield 766	com/tencent/smtt/sdk/m:t	Z
    //   3758: iconst_0
    //   3759: istore 7
    //   3761: goto -514 -> 3247
    //   3764: iload 5
    //   3766: istore 6
    //   3768: lload 10
    //   3770: lstore 18
    //   3772: iload 5
    //   3774: istore 8
    //   3776: lload 10
    //   3778: lstore 20
    //   3780: aload_0
    //   3781: iconst_1
    //   3782: putfield 766	com/tencent/smtt/sdk/m:t	Z
    //   3785: iload 5
    //   3787: istore 7
    //   3789: iload 5
    //   3791: istore 6
    //   3793: lload 10
    //   3795: lstore 18
    //   3797: iload 5
    //   3799: istore 8
    //   3801: lload 10
    //   3803: lstore 20
    //   3805: aload_0
    //   3806: getfield 87	com/tencent/smtt/sdk/m:b	[Ljava/lang/String;
    //   3809: ifnull +6 -> 3815
    //   3812: iconst_1
    //   3813: istore 7
    //   3815: iload 7
    //   3817: istore 6
    //   3819: lload 10
    //   3821: lstore 18
    //   3823: iload 7
    //   3825: istore 8
    //   3827: lload 10
    //   3829: lstore 20
    //   3831: aload_0
    //   3832: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   3835: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3838: sipush -311
    //   3841: invokevirtual 1067	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3844: goto -597 -> 3247
    //   3847: iload 5
    //   3849: istore 6
    //   3851: lload 10
    //   3853: lstore 18
    //   3855: iload 5
    //   3857: istore 8
    //   3859: lload 10
    //   3861: lstore 20
    //   3863: aload 33
    //   3865: aload 35
    //   3867: iconst_0
    //   3868: iload 4
    //   3870: invokevirtual 1296	java/io/FileOutputStream:write	([BII)V
    //   3873: iload 5
    //   3875: istore 6
    //   3877: lload 10
    //   3879: lstore 18
    //   3881: iload 5
    //   3883: istore 8
    //   3885: lload 10
    //   3887: lstore 20
    //   3889: aload 33
    //   3891: invokevirtual 1299	java/io/FileOutputStream:flush	()V
    //   3894: lload 10
    //   3896: lstore 12
    //   3898: iload_1
    //   3899: ifne +276 -> 4175
    //   3902: iload 4
    //   3904: i2l
    //   3905: lload 10
    //   3907: ladd
    //   3908: lstore 10
    //   3910: lload 10
    //   3912: lload 28
    //   3914: lcmp
    //   3915: iflt +93 -> 4008
    //   3918: lload 10
    //   3920: lstore 12
    //   3922: lload 10
    //   3924: lstore 18
    //   3926: ldc_w 277
    //   3929: ldc_w 1182
    //   3932: iconst_1
    //   3933: invokestatic 1114	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   3936: lload 10
    //   3938: lstore 12
    //   3940: lload 10
    //   3942: lstore 18
    //   3944: aload_0
    //   3945: bipush 112
    //   3947: new 116	java/lang/StringBuilder
    //   3950: dup
    //   3951: ldc_w 1301
    //   3954: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3957: lload 10
    //   3959: invokevirtual 512	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3962: ldc_w 1303
    //   3965: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3968: lload 28
    //   3970: invokevirtual 512	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3973: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3976: iconst_1
    //   3977: invokespecial 557	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   3980: lload 10
    //   3982: lstore 12
    //   3984: lload 10
    //   3986: lstore 18
    //   3988: aload_0
    //   3989: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   3992: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3995: sipush -307
    //   3998: invokevirtual 1067	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4001: iload 5
    //   4003: istore 7
    //   4005: goto -758 -> 3247
    //   4008: lload 10
    //   4010: lstore 12
    //   4012: lload 10
    //   4014: lstore 18
    //   4016: aload_0
    //   4017: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   4020: invokestatic 1173	com/tencent/smtt/utils/f:b	(Landroid/content/Context;)Z
    //   4023: ifne +148 -> 4171
    //   4026: lload 10
    //   4028: lstore 12
    //   4030: lload 10
    //   4032: lstore 18
    //   4034: ldc_w 277
    //   4037: ldc_w 1305
    //   4040: iconst_1
    //   4041: invokestatic 1114	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   4044: lload 10
    //   4046: lstore 12
    //   4048: lload 10
    //   4050: lstore 18
    //   4052: aload_0
    //   4053: bipush 105
    //   4055: new 116	java/lang/StringBuilder
    //   4058: dup
    //   4059: ldc_w 1307
    //   4062: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4065: invokestatic 1309	com/tencent/smtt/utils/r:a	()J
    //   4068: invokevirtual 512	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4071: ldc_w 1311
    //   4074: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4077: aload_0
    //   4078: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   4081: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4084: invokevirtual 1314	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   4087: invokevirtual 512	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4090: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4093: iconst_1
    //   4094: invokespecial 557	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   4097: lload 10
    //   4099: lstore 12
    //   4101: lload 10
    //   4103: lstore 18
    //   4105: aload_0
    //   4106: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   4109: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4112: sipush -308
    //   4115: invokevirtual 1067	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4118: iload 5
    //   4120: istore 7
    //   4122: goto -875 -> 3247
    //   4125: astore 32
    //   4127: lload 12
    //   4129: lstore 10
    //   4131: aload_0
    //   4132: aload 33
    //   4134: invokespecial 886	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   4137: aload_0
    //   4138: aload 30
    //   4140: invokespecial 886	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   4143: aload_0
    //   4144: aload 31
    //   4146: invokespecial 886	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   4149: ldc_w 1088
    //   4152: invokestatic 151	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4155: aload 32
    //   4157: athrow
    //   4158: astore 30
    //   4160: lload 10
    //   4162: lstore 12
    //   4164: iload 5
    //   4166: istore 7
    //   4168: goto -1918 -> 2250
    //   4171: lload 10
    //   4173: lstore 12
    //   4175: iload 4
    //   4177: i2l
    //   4178: lstore 10
    //   4180: iload 5
    //   4182: istore 6
    //   4184: lload 12
    //   4186: lstore 18
    //   4188: iload 5
    //   4190: istore 8
    //   4192: lload 12
    //   4194: lstore 20
    //   4196: aload_0
    //   4197: lload 24
    //   4199: lload 10
    //   4201: invokespecial 1316	com/tencent/smtt/sdk/m:a	(JJ)J
    //   4204: lstore 24
    //   4206: iload 5
    //   4208: istore 6
    //   4210: lload 12
    //   4212: lstore 18
    //   4214: iload 5
    //   4216: istore 8
    //   4218: lload 12
    //   4220: lstore 20
    //   4222: invokestatic 186	java/lang/System:currentTimeMillis	()J
    //   4225: lstore 26
    //   4227: lload 22
    //   4229: iload 4
    //   4231: i2l
    //   4232: ladd
    //   4233: lstore 22
    //   4235: lload 26
    //   4237: lload 16
    //   4239: lsub
    //   4240: ldc2_w 1317
    //   4243: lcmp
    //   4244: ifle +2394 -> 6638
    //   4247: iload 5
    //   4249: istore 6
    //   4251: lload 12
    //   4253: lstore 18
    //   4255: iload 5
    //   4257: istore 8
    //   4259: lload 12
    //   4261: lstore 20
    //   4263: ldc_w 277
    //   4266: new 116	java/lang/StringBuilder
    //   4269: dup
    //   4270: ldc_w 1320
    //   4273: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4276: lload 22
    //   4278: invokevirtual 512	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4281: ldc_w 1225
    //   4284: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4287: aload_0
    //   4288: getfield 758	com/tencent/smtt/sdk/m:m	J
    //   4291: invokevirtual 512	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4294: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4297: iconst_1
    //   4298: invokestatic 1114	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   4301: iload 5
    //   4303: istore 6
    //   4305: lload 12
    //   4307: lstore 18
    //   4309: iload 5
    //   4311: istore 8
    //   4313: lload 12
    //   4315: lstore 20
    //   4317: getstatic 626	com/tencent/smtt/sdk/QbSdk:l	Lcom/tencent/smtt/sdk/TbsListener;
    //   4320: ifnull +94 -> 4414
    //   4323: iload 5
    //   4325: istore 6
    //   4327: lload 12
    //   4329: lstore 18
    //   4331: iload 5
    //   4333: istore 8
    //   4335: lload 12
    //   4337: lstore 20
    //   4339: lload 22
    //   4341: l2d
    //   4342: aload_0
    //   4343: getfield 758	com/tencent/smtt/sdk/m:m	J
    //   4346: l2d
    //   4347: ddiv
    //   4348: ldc2_w 1321
    //   4351: dmul
    //   4352: d2i
    //   4353: istore 4
    //   4355: iload 5
    //   4357: istore 6
    //   4359: lload 12
    //   4361: lstore 18
    //   4363: iload 5
    //   4365: istore 8
    //   4367: lload 12
    //   4369: lstore 20
    //   4371: ldc_w 1014
    //   4374: ldc_w 1324
    //   4377: iload 4
    //   4379: invokestatic 654	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   4382: invokevirtual 464	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   4385: invokestatic 1326	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   4388: iload 5
    //   4390: istore 6
    //   4392: lload 12
    //   4394: lstore 18
    //   4396: iload 5
    //   4398: istore 8
    //   4400: lload 12
    //   4402: lstore 20
    //   4404: getstatic 626	com/tencent/smtt/sdk/QbSdk:l	Lcom/tencent/smtt/sdk/TbsListener;
    //   4407: iload 4
    //   4409: invokeinterface 1329 2 0
    //   4414: iload_1
    //   4415: ifne +2212 -> 6627
    //   4418: lload 22
    //   4420: lload 14
    //   4422: lsub
    //   4423: ldc2_w 1330
    //   4426: lcmp
    //   4427: ifle +2200 -> 6627
    //   4430: iload 5
    //   4432: istore 6
    //   4434: lload 12
    //   4436: lstore 18
    //   4438: iload 5
    //   4440: istore 8
    //   4442: lload 12
    //   4444: lstore 20
    //   4446: aload_0
    //   4447: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   4450: invokestatic 210	com/tencent/smtt/sdk/TbsDownloader:getOverSea	(Landroid/content/Context;)Z
    //   4453: ifne +212 -> 4665
    //   4456: iload 5
    //   4458: istore 6
    //   4460: lload 12
    //   4462: lstore 18
    //   4464: iload 5
    //   4466: istore 8
    //   4468: lload 12
    //   4470: lstore 20
    //   4472: aload_0
    //   4473: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   4476: invokestatic 797	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   4479: iconst_3
    //   4480: if_icmpne +29 -> 4509
    //   4483: iload 5
    //   4485: istore 6
    //   4487: lload 12
    //   4489: lstore 18
    //   4491: iload 5
    //   4493: istore 8
    //   4495: lload 12
    //   4497: lstore 20
    //   4499: aload_0
    //   4500: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   4503: invokestatic 797	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   4506: ifne +159 -> 4665
    //   4509: iload 5
    //   4511: istore 6
    //   4513: lload 12
    //   4515: lstore 18
    //   4517: iload 5
    //   4519: istore 8
    //   4521: lload 12
    //   4523: lstore 20
    //   4525: invokestatic 1049	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   4528: ifne +137 -> 4665
    //   4531: iload 5
    //   4533: istore 6
    //   4535: lload 12
    //   4537: lstore 18
    //   4539: iload 5
    //   4541: istore 8
    //   4543: lload 12
    //   4545: lstore 20
    //   4547: aload_0
    //   4548: invokevirtual 1219	com/tencent/smtt/sdk/m:b	()V
    //   4551: iload 5
    //   4553: istore 6
    //   4555: lload 12
    //   4557: lstore 18
    //   4559: iload 5
    //   4561: istore 8
    //   4563: lload 12
    //   4565: lstore 20
    //   4567: getstatic 626	com/tencent/smtt/sdk/QbSdk:l	Lcom/tencent/smtt/sdk/TbsListener;
    //   4570: ifnull +29 -> 4599
    //   4573: iload 5
    //   4575: istore 6
    //   4577: lload 12
    //   4579: lstore 18
    //   4581: iload 5
    //   4583: istore 8
    //   4585: lload 12
    //   4587: lstore 20
    //   4589: getstatic 626	com/tencent/smtt/sdk/QbSdk:l	Lcom/tencent/smtt/sdk/TbsListener;
    //   4592: bipush 111
    //   4594: invokeinterface 631 2 0
    //   4599: iload 5
    //   4601: istore 6
    //   4603: lload 12
    //   4605: lstore 18
    //   4607: iload 5
    //   4609: istore 8
    //   4611: lload 12
    //   4613: lstore 20
    //   4615: ldc_w 277
    //   4618: ldc_w 1333
    //   4621: iconst_0
    //   4622: invokestatic 1114	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   4625: iload 5
    //   4627: istore 6
    //   4629: lload 12
    //   4631: lstore 18
    //   4633: iload 5
    //   4635: istore 8
    //   4637: lload 12
    //   4639: lstore 20
    //   4641: aload_0
    //   4642: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   4645: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4648: sipush -304
    //   4651: invokevirtual 1067	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4654: lload 12
    //   4656: lstore 10
    //   4658: iload 5
    //   4660: istore 7
    //   4662: goto -1415 -> 3247
    //   4665: lload 22
    //   4667: lstore 10
    //   4669: lload 26
    //   4671: lstore 14
    //   4673: lload 14
    //   4675: lstore 16
    //   4677: lload 10
    //   4679: lstore 14
    //   4681: lload 12
    //   4683: lstore 10
    //   4685: goto -1520 -> 3165
    //   4688: aconst_null
    //   4689: astore 34
    //   4691: aconst_null
    //   4692: astore 32
    //   4694: lload 10
    //   4696: lstore 14
    //   4698: lload 14
    //   4700: lstore 12
    //   4702: iload 5
    //   4704: istore 6
    //   4706: aload_0
    //   4707: aload 32
    //   4709: invokespecial 886	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   4712: lload 14
    //   4714: lstore 12
    //   4716: iload 5
    //   4718: istore 6
    //   4720: aload_0
    //   4721: aload 34
    //   4723: invokespecial 886	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   4726: lload 14
    //   4728: lstore 12
    //   4730: iload 5
    //   4732: istore 6
    //   4734: aload_0
    //   4735: aload 31
    //   4737: invokespecial 886	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   4740: lload 14
    //   4742: lstore 12
    //   4744: iload 5
    //   4746: istore 6
    //   4748: aload_0
    //   4749: getfield 766	com/tencent/smtt/sdk/m:t	Z
    //   4752: ifne +24 -> 4776
    //   4755: lload 14
    //   4757: lstore 12
    //   4759: iload 5
    //   4761: istore 6
    //   4763: aload_0
    //   4764: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   4767: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4770: sipush -319
    //   4773: invokevirtual 1067	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4776: iload 5
    //   4778: istore 6
    //   4780: iload_1
    //   4781: ifne -4082 -> 699
    //   4784: aload_0
    //   4785: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   4788: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4791: getfield 600	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   4794: ldc_w 1142
    //   4797: lload 14
    //   4799: invokestatic 1172	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4802: invokeinterface 614 3 0
    //   4807: pop
    //   4808: aload_0
    //   4809: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   4812: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4815: invokevirtual 621	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   4818: iload 5
    //   4820: istore 6
    //   4822: goto -4123 -> 699
    //   4825: iload_1
    //   4826: ifne +162 -> 4988
    //   4829: aload_0
    //   4830: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   4833: invokestatic 1173	com/tencent/smtt/utils/f:b	(Landroid/content/Context;)Z
    //   4836: ifne +152 -> 4988
    //   4839: aload_0
    //   4840: bipush 105
    //   4842: new 116	java/lang/StringBuilder
    //   4845: dup
    //   4846: ldc_w 1307
    //   4849: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4852: invokestatic 1309	com/tencent/smtt/utils/r:a	()J
    //   4855: invokevirtual 512	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4858: ldc_w 1311
    //   4861: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4864: aload_0
    //   4865: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   4868: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4871: invokevirtual 1314	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   4874: invokevirtual 512	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4877: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4880: iconst_1
    //   4881: invokespecial 557	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   4884: aload_0
    //   4885: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   4888: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4891: sipush -308
    //   4894: invokevirtual 1067	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4897: lload 10
    //   4899: lstore 12
    //   4901: iload 7
    //   4903: istore 6
    //   4905: aload_0
    //   4906: aload 33
    //   4908: invokespecial 886	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   4911: lload 10
    //   4913: lstore 12
    //   4915: iload 7
    //   4917: istore 6
    //   4919: aload_0
    //   4920: aload 32
    //   4922: invokespecial 886	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   4925: lload 10
    //   4927: lstore 12
    //   4929: iload 7
    //   4931: istore 6
    //   4933: aload_0
    //   4934: aload 30
    //   4936: invokespecial 886	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   4939: iload 7
    //   4941: istore 6
    //   4943: iload_1
    //   4944: ifne -4245 -> 699
    //   4947: aload_0
    //   4948: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   4951: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4954: getfield 600	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   4957: ldc_w 1142
    //   4960: lload 10
    //   4962: invokestatic 1172	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4965: invokeinterface 614 3 0
    //   4970: pop
    //   4971: aload_0
    //   4972: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   4975: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4978: invokevirtual 621	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   4981: iload 7
    //   4983: istore 6
    //   4985: goto -4286 -> 699
    //   4988: aload_0
    //   4989: lconst_0
    //   4990: invokespecial 1286	com/tencent/smtt/sdk/m:a	(J)V
    //   4993: aload_0
    //   4994: invokespecial 1335	com/tencent/smtt/sdk/m:i	()Z
    //   4997: ifne +115 -> 5112
    //   5000: aload_0
    //   5001: bipush 106
    //   5003: aload_0
    //   5004: aload 31
    //   5006: invokespecial 555	com/tencent/smtt/sdk/m:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   5009: iconst_0
    //   5010: invokespecial 557	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   5013: lload 10
    //   5015: lstore 12
    //   5017: iload 7
    //   5019: istore 6
    //   5021: aload_0
    //   5022: aload 33
    //   5024: invokespecial 886	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   5027: lload 10
    //   5029: lstore 12
    //   5031: iload 7
    //   5033: istore 6
    //   5035: aload_0
    //   5036: aload 32
    //   5038: invokespecial 886	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   5041: lload 10
    //   5043: lstore 12
    //   5045: iload 7
    //   5047: istore 6
    //   5049: aload_0
    //   5050: aload 30
    //   5052: invokespecial 886	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   5055: lload 10
    //   5057: lstore 14
    //   5059: iload 7
    //   5061: istore 5
    //   5063: iload_1
    //   5064: ifne -4414 -> 650
    //   5067: aload_0
    //   5068: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5071: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5074: getfield 600	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5077: ldc_w 1142
    //   5080: lload 10
    //   5082: invokestatic 1172	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5085: invokeinterface 614 3 0
    //   5090: pop
    //   5091: aload_0
    //   5092: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5095: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5098: invokevirtual 621	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5101: lload 10
    //   5103: lstore 14
    //   5105: iload 7
    //   5107: istore 5
    //   5109: goto -4459 -> 650
    //   5112: aload_0
    //   5113: bipush 104
    //   5115: aload_0
    //   5116: aload 31
    //   5118: invokespecial 555	com/tencent/smtt/sdk/m:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   5121: iconst_0
    //   5122: invokespecial 557	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   5125: goto -112 -> 5013
    //   5128: astore 35
    //   5130: aload 32
    //   5132: astore 31
    //   5134: aload 30
    //   5136: astore 34
    //   5138: iload 7
    //   5140: istore 5
    //   5142: aload 35
    //   5144: astore 32
    //   5146: aload 31
    //   5148: astore 30
    //   5150: aload 34
    //   5152: astore 31
    //   5154: goto -1023 -> 4131
    //   5157: iload_3
    //   5158: sipush 300
    //   5161: if_icmplt +213 -> 5374
    //   5164: iload_3
    //   5165: sipush 307
    //   5168: if_icmpgt +206 -> 5374
    //   5171: lload 10
    //   5173: lstore 12
    //   5175: iload 5
    //   5177: istore 6
    //   5179: aload_0
    //   5180: getfield 401	com/tencent/smtt/sdk/m:u	Ljava/net/HttpURLConnection;
    //   5183: ldc_w 1337
    //   5186: invokevirtual 1340	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   5189: astore 30
    //   5191: lload 10
    //   5193: lstore 12
    //   5195: iload 5
    //   5197: istore 6
    //   5199: aload 30
    //   5201: invokestatic 916	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5204: ifne +84 -> 5288
    //   5207: lload 10
    //   5209: lstore 12
    //   5211: iload 5
    //   5213: istore 6
    //   5215: aload_0
    //   5216: aload 30
    //   5218: putfield 760	com/tencent/smtt/sdk/m:j	Ljava/lang/String;
    //   5221: lload 10
    //   5223: lstore 12
    //   5225: iload 5
    //   5227: istore 6
    //   5229: aload_0
    //   5230: aload_0
    //   5231: getfield 754	com/tencent/smtt/sdk/m:r	I
    //   5234: iconst_1
    //   5235: iadd
    //   5236: putfield 754	com/tencent/smtt/sdk/m:r	I
    //   5239: lload 10
    //   5241: lstore 14
    //   5243: iload_1
    //   5244: ifne -4594 -> 650
    //   5247: aload_0
    //   5248: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5251: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5254: getfield 600	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5257: ldc_w 1142
    //   5260: lload 10
    //   5262: invokestatic 1172	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5265: invokeinterface 614 3 0
    //   5270: pop
    //   5271: aload_0
    //   5272: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5275: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5278: invokevirtual 621	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5281: lload 10
    //   5283: lstore 14
    //   5285: goto -4635 -> 650
    //   5288: lload 10
    //   5290: lstore 12
    //   5292: iload 5
    //   5294: istore 6
    //   5296: aload_0
    //   5297: bipush 124
    //   5299: aconst_null
    //   5300: iconst_1
    //   5301: invokespecial 557	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   5304: lload 10
    //   5306: lstore 12
    //   5308: iload 5
    //   5310: istore 6
    //   5312: aload_0
    //   5313: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5316: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5319: sipush -312
    //   5322: invokevirtual 1067	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5325: iload 5
    //   5327: istore 6
    //   5329: iload_1
    //   5330: ifne -4631 -> 699
    //   5333: aload_0
    //   5334: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5337: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5340: getfield 600	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5343: ldc_w 1142
    //   5346: lload 10
    //   5348: invokestatic 1172	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5351: invokeinterface 614 3 0
    //   5356: pop
    //   5357: aload_0
    //   5358: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5361: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5364: invokevirtual 621	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5367: iload 5
    //   5369: istore 6
    //   5371: goto -4672 -> 699
    //   5374: lload 10
    //   5376: lstore 12
    //   5378: iload 5
    //   5380: istore 6
    //   5382: aload_0
    //   5383: bipush 102
    //   5385: iload_3
    //   5386: invokestatic 654	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   5389: iconst_0
    //   5390: invokespecial 557	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   5393: iload_3
    //   5394: sipush 416
    //   5397: if_icmpne +177 -> 5574
    //   5400: lload 10
    //   5402: lstore 12
    //   5404: iload 5
    //   5406: istore 6
    //   5408: aload_0
    //   5409: iconst_1
    //   5410: iload 9
    //   5412: invokespecial 1075	com/tencent/smtt/sdk/m:c	(ZZ)Z
    //   5415: ifeq +75 -> 5490
    //   5418: iconst_1
    //   5419: istore 6
    //   5421: iconst_1
    //   5422: istore 5
    //   5424: lload 10
    //   5426: lstore 12
    //   5428: aload_0
    //   5429: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5432: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5435: sipush -214
    //   5438: invokevirtual 1067	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5441: iload 5
    //   5443: istore 6
    //   5445: iload_1
    //   5446: ifne -4747 -> 699
    //   5449: aload_0
    //   5450: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5453: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5456: getfield 600	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5459: ldc_w 1142
    //   5462: lload 10
    //   5464: invokestatic 1172	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5467: invokeinterface 614 3 0
    //   5472: pop
    //   5473: aload_0
    //   5474: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5477: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5480: invokevirtual 621	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5483: iload 5
    //   5485: istore 6
    //   5487: goto -4788 -> 699
    //   5490: lload 10
    //   5492: lstore 12
    //   5494: iload 5
    //   5496: istore 6
    //   5498: aload_0
    //   5499: iconst_0
    //   5500: invokespecial 1077	com/tencent/smtt/sdk/m:d	(Z)Z
    //   5503: pop
    //   5504: lload 10
    //   5506: lstore 12
    //   5508: iload 5
    //   5510: istore 6
    //   5512: aload_0
    //   5513: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5516: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5519: sipush -313
    //   5522: invokevirtual 1067	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5525: iload 5
    //   5527: istore 6
    //   5529: iload_1
    //   5530: ifne -4831 -> 699
    //   5533: aload_0
    //   5534: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5537: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5540: getfield 600	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5543: ldc_w 1142
    //   5546: lload 10
    //   5548: invokestatic 1172	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5551: invokeinterface 614 3 0
    //   5556: pop
    //   5557: aload_0
    //   5558: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5561: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5564: invokevirtual 621	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5567: iload 5
    //   5569: istore 6
    //   5571: goto -4872 -> 699
    //   5574: iload_3
    //   5575: sipush 403
    //   5578: if_icmpeq +10 -> 5588
    //   5581: iload_3
    //   5582: sipush 406
    //   5585: if_icmpne +92 -> 5677
    //   5588: lload 10
    //   5590: lstore 12
    //   5592: iload 5
    //   5594: istore 6
    //   5596: aload_0
    //   5597: getfield 758	com/tencent/smtt/sdk/m:m	J
    //   5600: ldc2_w 755
    //   5603: lcmp
    //   5604: ifne +73 -> 5677
    //   5607: lload 10
    //   5609: lstore 12
    //   5611: iload 5
    //   5613: istore 6
    //   5615: aload_0
    //   5616: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5619: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5622: sipush -314
    //   5625: invokevirtual 1067	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5628: iload 5
    //   5630: istore 6
    //   5632: iload_1
    //   5633: ifne -4934 -> 699
    //   5636: aload_0
    //   5637: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5640: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5643: getfield 600	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5646: ldc_w 1142
    //   5649: lload 10
    //   5651: invokestatic 1172	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5654: invokeinterface 614 3 0
    //   5659: pop
    //   5660: aload_0
    //   5661: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5664: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5667: invokevirtual 621	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5670: iload 5
    //   5672: istore 6
    //   5674: goto -4975 -> 699
    //   5677: iload_3
    //   5678: sipush 202
    //   5681: if_icmpne +52 -> 5733
    //   5684: lload 10
    //   5686: lstore 14
    //   5688: iload_1
    //   5689: ifne -5039 -> 650
    //   5692: aload_0
    //   5693: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5696: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5699: getfield 600	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5702: ldc_w 1142
    //   5705: lload 10
    //   5707: invokestatic 1172	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5710: invokeinterface 614 3 0
    //   5715: pop
    //   5716: aload_0
    //   5717: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5720: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5723: invokevirtual 621	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5726: lload 10
    //   5728: lstore 14
    //   5730: goto -5080 -> 650
    //   5733: lload 10
    //   5735: lstore 12
    //   5737: iload 5
    //   5739: istore 6
    //   5741: aload_0
    //   5742: getfield 260	com/tencent/smtt/sdk/m:q	I
    //   5745: aload_0
    //   5746: getfield 85	com/tencent/smtt/sdk/m:C	I
    //   5749: if_icmpge +169 -> 5918
    //   5752: iload_3
    //   5753: sipush 503
    //   5756: if_icmpne +162 -> 5918
    //   5759: lload 10
    //   5761: lstore 12
    //   5763: iload 5
    //   5765: istore 6
    //   5767: aload_0
    //   5768: aload_0
    //   5769: getfield 401	com/tencent/smtt/sdk/m:u	Ljava/net/HttpURLConnection;
    //   5772: ldc_w 1342
    //   5775: invokevirtual 1340	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   5778: invokestatic 1346	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   5781: invokespecial 1286	com/tencent/smtt/sdk/m:a	(J)V
    //   5784: lload 10
    //   5786: lstore 12
    //   5788: iload 5
    //   5790: istore 6
    //   5792: aload_0
    //   5793: getfield 764	com/tencent/smtt/sdk/m:s	Z
    //   5796: ifeq +73 -> 5869
    //   5799: lload 10
    //   5801: lstore 12
    //   5803: iload 5
    //   5805: istore 6
    //   5807: aload_0
    //   5808: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5811: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5814: sipush -309
    //   5817: invokevirtual 1067	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5820: iload 5
    //   5822: istore 6
    //   5824: iload_1
    //   5825: ifne -5126 -> 699
    //   5828: aload_0
    //   5829: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5832: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5835: getfield 600	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5838: ldc_w 1142
    //   5841: lload 10
    //   5843: invokestatic 1172	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5846: invokeinterface 614 3 0
    //   5851: pop
    //   5852: aload_0
    //   5853: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5856: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5859: invokevirtual 621	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5862: iload 5
    //   5864: istore 6
    //   5866: goto -5167 -> 699
    //   5869: lload 10
    //   5871: lstore 14
    //   5873: iload_1
    //   5874: ifne -5224 -> 650
    //   5877: aload_0
    //   5878: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5881: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5884: getfield 600	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5887: ldc_w 1142
    //   5890: lload 10
    //   5892: invokestatic 1172	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5895: invokeinterface 614 3 0
    //   5900: pop
    //   5901: aload_0
    //   5902: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5905: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5908: invokevirtual 621	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5911: lload 10
    //   5913: lstore 14
    //   5915: goto -5265 -> 650
    //   5918: lload 10
    //   5920: lstore 12
    //   5922: iload 5
    //   5924: istore 6
    //   5926: aload_0
    //   5927: getfield 260	com/tencent/smtt/sdk/m:q	I
    //   5930: aload_0
    //   5931: getfield 85	com/tencent/smtt/sdk/m:C	I
    //   5934: if_icmpge +178 -> 6112
    //   5937: iload_3
    //   5938: sipush 408
    //   5941: if_icmpeq +24 -> 5965
    //   5944: iload_3
    //   5945: sipush 504
    //   5948: if_icmpeq +17 -> 5965
    //   5951: iload_3
    //   5952: sipush 502
    //   5955: if_icmpeq +10 -> 5965
    //   5958: iload_3
    //   5959: sipush 408
    //   5962: if_icmpne +150 -> 6112
    //   5965: lload 10
    //   5967: lstore 12
    //   5969: iload 5
    //   5971: istore 6
    //   5973: aload_0
    //   5974: lconst_0
    //   5975: invokespecial 1286	com/tencent/smtt/sdk/m:a	(J)V
    //   5978: lload 10
    //   5980: lstore 12
    //   5982: iload 5
    //   5984: istore 6
    //   5986: aload_0
    //   5987: getfield 764	com/tencent/smtt/sdk/m:s	Z
    //   5990: ifeq +73 -> 6063
    //   5993: lload 10
    //   5995: lstore 12
    //   5997: iload 5
    //   5999: istore 6
    //   6001: aload_0
    //   6002: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6005: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6008: sipush -309
    //   6011: invokevirtual 1067	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6014: iload 5
    //   6016: istore 6
    //   6018: iload_1
    //   6019: ifne -5320 -> 699
    //   6022: aload_0
    //   6023: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6026: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6029: getfield 600	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6032: ldc_w 1142
    //   6035: lload 10
    //   6037: invokestatic 1172	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6040: invokeinterface 614 3 0
    //   6045: pop
    //   6046: aload_0
    //   6047: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6050: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6053: invokevirtual 621	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6056: iload 5
    //   6058: istore 6
    //   6060: goto -5361 -> 699
    //   6063: lload 10
    //   6065: lstore 14
    //   6067: iload_1
    //   6068: ifne -5418 -> 650
    //   6071: aload_0
    //   6072: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6075: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6078: getfield 600	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6081: ldc_w 1142
    //   6084: lload 10
    //   6086: invokestatic 1172	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6089: invokeinterface 614 3 0
    //   6094: pop
    //   6095: aload_0
    //   6096: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6099: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6102: invokevirtual 621	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6105: lload 10
    //   6107: lstore 14
    //   6109: goto -5459 -> 650
    //   6112: lload 10
    //   6114: lstore 12
    //   6116: iload 5
    //   6118: istore 6
    //   6120: aload_0
    //   6121: invokespecial 1195	com/tencent/smtt/sdk/m:j	()J
    //   6124: lconst_0
    //   6125: lcmp
    //   6126: ifgt +87 -> 6213
    //   6129: lload 10
    //   6131: lstore 12
    //   6133: iload 5
    //   6135: istore 6
    //   6137: aload_0
    //   6138: getfield 762	com/tencent/smtt/sdk/m:p	Z
    //   6141: ifne +72 -> 6213
    //   6144: iload_3
    //   6145: sipush 410
    //   6148: if_icmpeq +65 -> 6213
    //   6151: lload 10
    //   6153: lstore 12
    //   6155: iload 5
    //   6157: istore 6
    //   6159: aload_0
    //   6160: iconst_1
    //   6161: putfield 762	com/tencent/smtt/sdk/m:p	Z
    //   6164: lload 10
    //   6166: lstore 14
    //   6168: iload_1
    //   6169: ifne -5519 -> 650
    //   6172: aload_0
    //   6173: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6176: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6179: getfield 600	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6182: ldc_w 1142
    //   6185: lload 10
    //   6187: invokestatic 1172	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6190: invokeinterface 614 3 0
    //   6195: pop
    //   6196: aload_0
    //   6197: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6200: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6203: invokevirtual 621	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6206: lload 10
    //   6208: lstore 14
    //   6210: goto -5560 -> 650
    //   6213: lload 10
    //   6215: lstore 12
    //   6217: iload 5
    //   6219: istore 6
    //   6221: aload_0
    //   6222: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6225: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6228: sipush -315
    //   6231: invokevirtual 1067	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6234: iload 5
    //   6236: istore 6
    //   6238: iload_1
    //   6239: ifne -5540 -> 699
    //   6242: aload_0
    //   6243: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6246: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6249: getfield 600	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6252: ldc_w 1142
    //   6255: lload 10
    //   6257: invokestatic 1172	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6260: invokeinterface 614 3 0
    //   6265: pop
    //   6266: aload_0
    //   6267: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6270: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6273: invokevirtual 621	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6276: iload 5
    //   6278: istore 6
    //   6280: goto -5581 -> 699
    //   6283: aload_0
    //   6284: lconst_0
    //   6285: invokespecial 1286	com/tencent/smtt/sdk/m:a	(J)V
    //   6288: aload_0
    //   6289: bipush 107
    //   6291: aload_0
    //   6292: aload 30
    //   6294: invokespecial 555	com/tencent/smtt/sdk/m:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   6297: iconst_0
    //   6298: invokespecial 557	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   6301: aload_0
    //   6302: getfield 764	com/tencent/smtt/sdk/m:s	Z
    //   6305: ifeq -3980 -> 2325
    //   6308: aload_0
    //   6309: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6312: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6315: sipush -309
    //   6318: invokevirtual 1067	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6321: iload 7
    //   6323: istore 6
    //   6325: iload_1
    //   6326: ifne -5627 -> 699
    //   6329: aload_0
    //   6330: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6333: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6336: getfield 600	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6339: ldc_w 1142
    //   6342: lload 12
    //   6344: invokestatic 1172	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6347: invokeinterface 614 3 0
    //   6352: pop
    //   6353: aload_0
    //   6354: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6357: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6360: invokevirtual 621	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6363: iload 7
    //   6365: istore 6
    //   6367: goto -5668 -> 699
    //   6370: astore 30
    //   6372: iload_1
    //   6373: ifne +37 -> 6410
    //   6376: aload_0
    //   6377: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6380: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6383: getfield 600	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6386: ldc_w 1142
    //   6389: lload 12
    //   6391: invokestatic 1172	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6394: invokeinterface 614 3 0
    //   6399: pop
    //   6400: aload_0
    //   6401: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6404: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6407: invokevirtual 621	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6410: ldc_w 1088
    //   6413: invokestatic 151	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   6416: aload 30
    //   6418: athrow
    //   6419: aload_0
    //   6420: iconst_1
    //   6421: iload 9
    //   6423: invokespecial 1075	com/tencent/smtt/sdk/m:c	(ZZ)Z
    //   6426: istore_1
    //   6427: goto -5637 -> 790
    //   6430: iconst_0
    //   6431: istore_3
    //   6432: goto -5630 -> 802
    //   6435: iconst_2
    //   6436: istore_3
    //   6437: goto -5612 -> 825
    //   6440: aload_0
    //   6441: getfield 109	com/tencent/smtt/sdk/m:w	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   6444: iconst_0
    //   6445: invokevirtual 1150	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setPatchUpdateFlag	(I)V
    //   6448: goto -5617 -> 831
    //   6451: aload_0
    //   6452: getfield 97	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6455: invokestatic 373	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6458: sipush -318
    //   6461: invokevirtual 1067	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6464: aload_0
    //   6465: iconst_0
    //   6466: invokespecial 1077	com/tencent/smtt/sdk/m:d	(Z)Z
    //   6469: pop
    //   6470: goto -5587 -> 883
    //   6473: aload 30
    //   6475: getfield 377	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   6478: ldc_w 1348
    //   6481: iconst_0
    //   6482: invokeinterface 385 3 0
    //   6487: istore_3
    //   6488: aload 30
    //   6490: getfield 600	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6493: astore 31
    //   6495: iload_3
    //   6496: iconst_1
    //   6497: iadd
    //   6498: istore_3
    //   6499: aload 31
    //   6501: ldc_w 1348
    //   6504: iload_3
    //   6505: invokestatic 548	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6508: invokeinterface 614 3 0
    //   6513: pop
    //   6514: iload_3
    //   6515: aload 30
    //   6517: invokevirtual 1351	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadFailedMaxRetrytimes	()I
    //   6520: if_icmpne -5589 -> 931
    //   6523: aload_0
    //   6524: getfield 109	com/tencent/smtt/sdk/m:w	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   6527: iconst_2
    //   6528: invokevirtual 1208	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownloadCancel	(I)V
    //   6531: goto -5600 -> 931
    //   6534: iconst_0
    //   6535: istore_3
    //   6536: goto -5588 -> 948
    //   6539: astore 32
    //   6541: aconst_null
    //   6542: astore 30
    //   6544: aconst_null
    //   6545: astore 31
    //   6547: aconst_null
    //   6548: astore 33
    //   6550: goto -2419 -> 4131
    //   6553: astore 32
    //   6555: aconst_null
    //   6556: astore 30
    //   6558: aconst_null
    //   6559: astore 33
    //   6561: goto -2430 -> 4131
    //   6564: astore 32
    //   6566: aconst_null
    //   6567: astore 33
    //   6569: goto -2438 -> 4131
    //   6572: astore 32
    //   6574: iload 6
    //   6576: istore 5
    //   6578: lload 18
    //   6580: lstore 10
    //   6582: goto -2451 -> 4131
    //   6585: astore 31
    //   6587: iload 5
    //   6589: istore 7
    //   6591: aload 34
    //   6593: astore 33
    //   6595: goto -3173 -> 3422
    //   6598: astore 32
    //   6600: aload 31
    //   6602: astore 34
    //   6604: lload 20
    //   6606: lstore 10
    //   6608: iload 8
    //   6610: istore 7
    //   6612: aload 32
    //   6614: astore 31
    //   6616: aload 30
    //   6618: astore 32
    //   6620: aload 34
    //   6622: astore 30
    //   6624: goto -3202 -> 3422
    //   6627: lload 14
    //   6629: lstore 10
    //   6631: lload 26
    //   6633: lstore 14
    //   6635: goto -1962 -> 4673
    //   6638: lload 14
    //   6640: lstore 10
    //   6642: lload 16
    //   6644: lstore 14
    //   6646: goto -1973 -> 4673
    //   6649: iload_3
    //   6650: sipush 200
    //   6653: if_icmpeq -4171 -> 2482
    //   6656: iload_3
    //   6657: sipush 206
    //   6660: if_icmpne -1503 -> 5157
    //   6663: goto -4181 -> 2482
    //   6666: astore 32
    //   6668: aload 31
    //   6670: astore 34
    //   6672: lload 18
    //   6674: lstore 10
    //   6676: iload 5
    //   6678: istore 7
    //   6680: aload 32
    //   6682: astore 31
    //   6684: aload 30
    //   6686: astore 32
    //   6688: aload 34
    //   6690: astore 30
    //   6692: goto -3270 -> 3422
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	6695	0	this	m
    //   0	6695	1	paramBoolean1	boolean
    //   0	6695	2	paramBoolean2	boolean
    //   85	6576	3	i1	int
    //   3644	764	4	i2	int
    //   542	6135	5	bool1	boolean
    //   502	6073	6	bool2	boolean
    //   2248	4431	7	bool3	boolean
    //   3175	3434	8	bool4	boolean
    //   102	6320	9	bool5	boolean
    //   523	6152	10	l1	long
    //   990	5400	12	l2	long
    //   538	6107	14	l3	long
    //   1124	5519	16	l4	long
    //   3152	3521	18	l5	long
    //   3179	3426	20	l6	long
    //   3163	1503	22	l7	long
    //   978	3227	24	l8	long
    //   4225	2407	26	l9	long
    //   499	3470	28	l10	long
    //   182	1960	30	localObject1	Object
    //   2244	218	30	localObject2	Object
    //   2955	1184	30	localObject3	Object
    //   4158	977	30	localCloseable	Closeable
    //   5148	1145	30	localObject4	Object
    //   6370	146	30	localObject5	Object
    //   6542	149	30	localObject6	Object
    //   2984	3562	31	localObject7	Object
    //   6585	16	31	localIOException1	IOException
    //   6614	69	31	localIOException2	IOException
    //   2958	626	32	localObject8	Object
    //   3588	11	32	localIOException3	IOException
    //   3604	1	32	localObject9	Object
    //   4125	31	32	localObject10	Object
    //   4692	453	32	localObject11	Object
    //   6539	1	32	localObject12	Object
    //   6553	1	32	localObject13	Object
    //   6564	1	32	localObject14	Object
    //   6572	1	32	localObject15	Object
    //   6598	15	32	localIOException4	IOException
    //   6618	1	32	localObject16	Object
    //   6666	15	32	localIOException5	IOException
    //   6686	1	32	localObject17	Object
    //   3082	3512	33	localObject18	Object
    //   2952	3737	34	localObject19	Object
    //   3032	1	35	arrayOfByte	byte[]
    //   3404	462	35	localIOException6	IOException
    //   5128	15	35	localObject20	Object
    // Exception table:
    //   from	to	target	type
    //   996	1025	2244	finally
    //   1033	1042	2244	finally
    //   1050	1074	2244	finally
    //   1082	1105	2244	finally
    //   1113	1123	2244	finally
    //   1138	1148	2244	finally
    //   1156	1166	2244	finally
    //   1174	1182	2244	finally
    //   1190	1203	2244	finally
    //   1260	1277	2244	finally
    //   1297	1307	2244	finally
    //   1315	1323	2244	finally
    //   1331	1344	2244	finally
    //   1401	1406	2244	finally
    //   1414	1421	2244	finally
    //   1429	1435	2244	finally
    //   1443	1481	2244	finally
    //   1489	1501	2244	finally
    //   1509	1518	2244	finally
    //   1526	1532	2244	finally
    //   1540	1546	2244	finally
    //   1557	1564	2244	finally
    //   1572	1578	2244	finally
    //   1586	1603	2244	finally
    //   1611	1620	2244	finally
    //   1628	1646	2244	finally
    //   1654	1688	2244	finally
    //   1696	1702	2244	finally
    //   1719	1725	2244	finally
    //   1733	1741	2244	finally
    //   1749	1758	2244	finally
    //   1766	1773	2244	finally
    //   1781	1789	2244	finally
    //   1797	1803	2244	finally
    //   1811	1816	2244	finally
    //   1824	1831	2244	finally
    //   1839	1853	2244	finally
    //   1861	1869	2244	finally
    //   1877	1893	2244	finally
    //   1901	1909	2244	finally
    //   1921	1931	2244	finally
    //   1939	1950	2244	finally
    //   1958	1968	2244	finally
    //   1976	1982	2244	finally
    //   1990	1994	2244	finally
    //   2002	2008	2244	finally
    //   2016	2026	2244	finally
    //   2034	2044	2244	finally
    //   2052	2059	2244	finally
    //   2067	2080	2244	finally
    //   2137	2143	2244	finally
    //   2154	2192	2244	finally
    //   2200	2241	2244	finally
    //   2408	2416	2244	finally
    //   2424	2436	2244	finally
    //   2444	2452	2244	finally
    //   2460	2466	2244	finally
    //   2474	2479	2244	finally
    //   2490	2505	2244	finally
    //   2513	2539	2244	finally
    //   2547	2558	2244	finally
    //   2566	2587	2244	finally
    //   2602	2612	2244	finally
    //   2620	2658	2244	finally
    //   2670	2677	2244	finally
    //   2685	2691	2244	finally
    //   2699	2709	2244	finally
    //   2717	2724	2244	finally
    //   2732	2739	2244	finally
    //   2801	2839	2244	finally
    //   2847	2860	2244	finally
    //   2917	2927	2244	finally
    //   2935	2948	2244	finally
    //   2968	2977	2244	finally
    //   3275	3281	2244	finally
    //   3289	3295	2244	finally
    //   3303	3309	2244	finally
    //   3471	3477	2244	finally
    //   3485	3491	2244	finally
    //   3499	3505	2244	finally
    //   4706	4712	2244	finally
    //   4720	4726	2244	finally
    //   4734	4740	2244	finally
    //   4748	4755	2244	finally
    //   4763	4776	2244	finally
    //   4905	4911	2244	finally
    //   4919	4925	2244	finally
    //   4933	4939	2244	finally
    //   5021	5027	2244	finally
    //   5035	5041	2244	finally
    //   5049	5055	2244	finally
    //   5179	5191	2244	finally
    //   5199	5207	2244	finally
    //   5215	5221	2244	finally
    //   5229	5239	2244	finally
    //   5296	5304	2244	finally
    //   5312	5325	2244	finally
    //   5382	5393	2244	finally
    //   5408	5418	2244	finally
    //   5428	5441	2244	finally
    //   5498	5504	2244	finally
    //   5512	5525	2244	finally
    //   5596	5607	2244	finally
    //   5615	5628	2244	finally
    //   5741	5752	2244	finally
    //   5767	5784	2244	finally
    //   5792	5799	2244	finally
    //   5807	5820	2244	finally
    //   5926	5937	2244	finally
    //   5973	5978	2244	finally
    //   5986	5993	2244	finally
    //   6001	6014	2244	finally
    //   6120	6129	2244	finally
    //   6137	6144	2244	finally
    //   6159	6164	2244	finally
    //   6221	6234	2244	finally
    //   2991	3000	3404	java/io/IOException
    //   3005	3027	3404	java/io/IOException
    //   3371	3401	3404	java/io/IOException
    //   3027	3034	3588	java/io/IOException
    //   3038	3084	3588	java/io/IOException
    //   3088	3102	3588	java/io/IOException
    //   3106	3146	3588	java/io/IOException
    //   3569	3585	3588	java/io/IOException
    //   3154	3159	4125	finally
    //   3926	3936	4125	finally
    //   3944	3980	4125	finally
    //   3988	4001	4125	finally
    //   4016	4026	4125	finally
    //   4034	4044	4125	finally
    //   4052	4097	4125	finally
    //   4105	4118	4125	finally
    //   4131	4158	4158	finally
    //   3422	3438	5128	finally
    //   3438	3463	5128	finally
    //   4829	4897	5128	finally
    //   4988	5013	5128	finally
    //   5112	5125	5128	finally
    //   2250	2258	6370	finally
    //   2262	2325	6370	finally
    //   2325	2338	6370	finally
    //   6283	6321	6370	finally
    //   2977	2986	6539	finally
    //   2991	3000	6553	finally
    //   3005	3027	6553	finally
    //   3371	3401	6553	finally
    //   3027	3034	6564	finally
    //   3038	3084	6564	finally
    //   3088	3102	6564	finally
    //   3106	3146	6564	finally
    //   3569	3585	6564	finally
    //   3181	3188	6572	finally
    //   3204	3214	6572	finally
    //   3230	3243	6572	finally
    //   3633	3646	6572	finally
    //   3667	3674	6572	finally
    //   3690	3700	6572	finally
    //   3720	3728	6572	finally
    //   3753	3758	6572	finally
    //   3780	3785	6572	finally
    //   3805	3812	6572	finally
    //   3831	3844	6572	finally
    //   3863	3873	6572	finally
    //   3889	3894	6572	finally
    //   4196	4206	6572	finally
    //   4222	4227	6572	finally
    //   4263	4301	6572	finally
    //   4317	4323	6572	finally
    //   4339	4355	6572	finally
    //   4371	4388	6572	finally
    //   4404	4414	6572	finally
    //   4446	4456	6572	finally
    //   4472	4483	6572	finally
    //   4499	4509	6572	finally
    //   4525	4531	6572	finally
    //   4547	4551	6572	finally
    //   4567	4573	6572	finally
    //   4589	4599	6572	finally
    //   4615	4625	6572	finally
    //   4641	4654	6572	finally
    //   2977	2986	6585	java/io/IOException
    //   3181	3188	6598	java/io/IOException
    //   3204	3214	6598	java/io/IOException
    //   3230	3243	6598	java/io/IOException
    //   3633	3646	6598	java/io/IOException
    //   3667	3674	6598	java/io/IOException
    //   3690	3700	6598	java/io/IOException
    //   3720	3728	6598	java/io/IOException
    //   3753	3758	6598	java/io/IOException
    //   3780	3785	6598	java/io/IOException
    //   3805	3812	6598	java/io/IOException
    //   3831	3844	6598	java/io/IOException
    //   3863	3873	6598	java/io/IOException
    //   3889	3894	6598	java/io/IOException
    //   4196	4206	6598	java/io/IOException
    //   4222	4227	6598	java/io/IOException
    //   4263	4301	6598	java/io/IOException
    //   4317	4323	6598	java/io/IOException
    //   4339	4355	6598	java/io/IOException
    //   4371	4388	6598	java/io/IOException
    //   4404	4414	6598	java/io/IOException
    //   4446	4456	6598	java/io/IOException
    //   4472	4483	6598	java/io/IOException
    //   4499	4509	6598	java/io/IOException
    //   4525	4531	6598	java/io/IOException
    //   4547	4551	6598	java/io/IOException
    //   4567	4573	6598	java/io/IOException
    //   4589	4599	6598	java/io/IOException
    //   4615	4625	6598	java/io/IOException
    //   4641	4654	6598	java/io/IOException
    //   3154	3159	6666	java/io/IOException
    //   3926	3936	6666	java/io/IOException
    //   3944	3980	6666	java/io/IOException
    //   3988	4001	6666	java/io/IOException
    //   4016	4026	6666	java/io/IOException
    //   4034	4044	6666	java/io/IOException
    //   4052	4097	6666	java/io/IOException
    //   4105	4118	6666	java/io/IOException
  }
  
  public void c()
  {
    AppMethodBeat.i(219747);
    b();
    d(false);
    d(true);
    AppMethodBeat.o(219747);
  }
  
  public boolean d()
  {
    AppMethodBeat.i(219755);
    TbsLog.i("TbsDownload", "[TbsApkDownloader.isDownloadForeground] mIsDownloadForeground=" + this.D);
    boolean bool = this.D;
    AppMethodBeat.o(219755);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.m
 * JD-Core Version:    0.7.0.1
 */