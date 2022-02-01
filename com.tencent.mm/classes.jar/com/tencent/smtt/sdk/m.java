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
  private Set<String> A;
  private int B;
  private boolean C;
  String a;
  String[] b;
  int c;
  private Context g;
  private String h;
  private String i;
  private String j;
  private File k;
  private long l;
  private int m;
  private int n;
  private boolean o;
  private int p;
  private int q;
  private boolean r;
  private boolean s;
  private HttpURLConnection t;
  private String u;
  private TbsLogReport.TbsLogInfo v;
  private String w;
  private int x;
  private boolean y;
  private Handler z;
  
  public m(Context paramContext)
  {
    AppMethodBeat.i(192500);
    this.m = 30000;
    this.n = 20000;
    this.B = d;
    this.b = null;
    this.c = 0;
    this.g = paramContext.getApplicationContext();
    this.v = TbsLogReport.getInstance(this.g).tbsLogInfo();
    this.A = new HashSet();
    this.u = ("tbs_downloading_" + this.g.getPackageName());
    q.a();
    this.k = q.t(this.g);
    if (this.k == null)
    {
      paramContext = new NullPointerException("TbsCorePrivateDir is null!");
      AppMethodBeat.o(192500);
      throw paramContext;
    }
    e();
    this.w = null;
    this.x = -1;
    AppMethodBeat.o(192500);
  }
  
  private long a(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(192508);
    long l1 = System.currentTimeMillis();
    this.v.setDownConsumeTime(l1 - paramLong1);
    this.v.setDownloadSize(paramLong2);
    AppMethodBeat.o(192508);
    return l1;
  }
  
  @TargetApi(8)
  static File a(Context paramContext)
  {
    AppMethodBeat.i(192525);
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
          AppMethodBeat.o(192525);
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        TbsLog.e("TbsDownload", "[TbsApkDownloader.backupApkPath] Exception is " + paramContext.getMessage());
        AppMethodBeat.o(192525);
        return null;
      }
      paramContext = null;
    }
  }
  
  private static File a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(192527);
    File localFile = new File(f.a(paramContext, paramInt));
    if ((!localFile.exists()) || (!localFile.isDirectory()))
    {
      AppMethodBeat.o(192527);
      return null;
    }
    if (TbsDownloader.getOverSea(paramContext)) {}
    for (paramContext = "x5.oversea.tbs.org"; new File(localFile, paramContext).exists(); paramContext = TbsDownloader.getBackupFileName(false))
    {
      AppMethodBeat.o(192527);
      return localFile;
    }
    AppMethodBeat.o(192527);
    return null;
  }
  
  private String a(Throwable paramThrowable)
  {
    AppMethodBeat.i(192510);
    paramThrowable = Log.getStackTraceString(paramThrowable);
    if (paramThrowable.length() > 1024)
    {
      paramThrowable = paramThrowable.substring(0, 1024);
      AppMethodBeat.o(192510);
      return paramThrowable;
    }
    AppMethodBeat.o(192510);
    return paramThrowable;
  }
  
  private String a(URL paramURL)
  {
    AppMethodBeat.i(192524);
    String str = "";
    try
    {
      paramURL = InetAddress.getByName(paramURL.getHost()).getHostAddress();
      AppMethodBeat.o(192524);
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
    AppMethodBeat.i(192509);
    if ((paramBoolean) || (this.p > this.B))
    {
      this.v.setErrorCode(paramInt);
      this.v.setFailDetail(paramString);
    }
    AppMethodBeat.o(192509);
  }
  
  private void a(long paramLong)
  {
    AppMethodBeat.i(192515);
    this.p += 1;
    long l1 = paramLong;
    if (paramLong <= 0L) {}
    try
    {
      l1 = l();
      Thread.sleep(l1);
      AppMethodBeat.o(192515);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(192515);
    }
  }
  
  private void a(Closeable paramCloseable)
  {
    AppMethodBeat.i(192514);
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        AppMethodBeat.o(192514);
        return;
      }
      catch (IOException paramCloseable) {}
    }
    AppMethodBeat.o(192514);
  }
  
  public static void a(File paramFile, Context paramContext)
  {
    int i1 = 0;
    AppMethodBeat.i(192532);
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
        AppMethodBeat.o(192532);
      }
    }
  }
  
  private void a(String paramString)
  {
    AppMethodBeat.i(192501);
    paramString = new URL(paramString);
    if (this.t != null) {}
    try
    {
      this.t.disconnect();
      this.t = ((HttpURLConnection)paramString.openConnection());
      this.t.setRequestProperty("User-Agent", TbsDownloader.b(this.g));
      this.t.setRequestProperty("Accept-Encoding", "identity");
      this.t.setRequestMethod("GET");
      this.t.setInstanceFollowRedirects(false);
      this.t.setConnectTimeout(this.n);
      this.t.setReadTimeout(this.m);
      AppMethodBeat.o(192501);
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
    AppMethodBeat.i(192517);
    int i2 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("use_backup_version", 0);
    int i1 = i2;
    if (i2 == 0) {
      i1 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_download_version", 0);
    }
    boolean bool = a.a(this.g, paramFile, 0L, i1);
    AppMethodBeat.o(192517);
    return bool;
  }
  
  @TargetApi(8)
  static File b(Context paramContext)
  {
    AppMethodBeat.i(192526);
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
          AppMethodBeat.o(192526);
          return localObject1;
        }
      }
      catch (Exception paramContext)
      {
        TbsLog.e("TbsDownload", "[TbsApkDownloader.backupApkPath] Exception is " + paramContext.getMessage());
        AppMethodBeat.o(192526);
        return null;
      }
      Object localObject1 = null;
    }
  }
  
  private boolean b(int paramInt)
  {
    AppMethodBeat.i(192503);
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
          AppMethodBeat.o(192503);
          return false;
        }
      }
      AppMethodBeat.o(192503);
      return false;
    }
    catch (Exception localException)
    {
      TbsLog.e("TbsDownload", "[TbsApkDownloader.copyTbsApkFromBackupToInstall] Exception is " + localException.getMessage());
      AppMethodBeat.o(192503);
      return false;
    }
    AppMethodBeat.o(192503);
    return true;
  }
  
  public static void c(Context paramContext)
  {
    int i2 = 0;
    AppMethodBeat.i(192533);
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
        AppMethodBeat.o(192533);
        return;
      }
      catch (Exception paramContext)
      {
        AppMethodBeat.o(192533);
        return;
      }
      label281:
      i1 += 1;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    AppMethodBeat.i(192511);
    com.tencent.smtt.utils.q.a(this.g);
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
      i1 = ((TbsDownloadConfig)localObject1).mPreferences.getInt("tbs_responsecode", 0);
      paramBoolean = TbsDownloader.a(this.g);
      if (i1 != 5) {
        break label165;
      }
      localObject1 = a(i1, paramBoolean);
      if (localObject1 != null) {
        break;
      }
      AppMethodBeat.o(192511);
      return;
    }
    q.a().b(this.g, (Bundle)localObject1);
    AppMethodBeat.o(192511);
    return;
    label165:
    if ((i1 == 3) || (i1 > 10000))
    {
      localObject2 = a(this.g);
      if (localObject2 != null)
      {
        localObject1 = a(i1, (File)localObject2, paramBoolean);
        q.a().b(this.g, (Bundle)localObject1);
        AppMethodBeat.o(192511);
        return;
      }
      c();
      ((TbsDownloadConfig)localObject1).mSyncMap.put("tbs_needdownload", Boolean.TRUE);
      ((TbsDownloadConfig)localObject1).commit();
      AppMethodBeat.o(192511);
      return;
    }
    i1 = ((TbsDownloadConfig)localObject1).mPreferences.getInt("tbs_download_version", 0);
    q.a().a(this.g, new File(this.k, "x5.tbs").getAbsolutePath(), i1);
    a(new File(this.k, "x5.tbs"), this.g);
    AppMethodBeat.o(192511);
  }
  
  private boolean c(boolean paramBoolean1, boolean paramBoolean2)
  {
    long l2 = 0L;
    AppMethodBeat.i(192518);
    TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=".concat(String.valueOf(paramBoolean1)));
    Object localObject2 = this.k;
    if (!paramBoolean1) {}
    for (Object localObject1 = "x5.tbs";; localObject1 = "x5.tbs.temp")
    {
      localObject1 = new File((File)localObject2, (String)localObject1);
      if (((File)localObject1).exists()) {
        break;
      }
      AppMethodBeat.o(192518);
      return false;
    }
    localObject2 = TbsDownloadConfig.getInstance(this.g).mPreferences.getString("tbs_apk_md5", null);
    Object localObject3 = a.a((File)localObject1);
    if ((localObject2 == null) || (!((String)localObject2).equals(localObject3)))
    {
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1 + " md5 failed");
      if (paramBoolean1) {
        this.v.setCheckErrorDetail("fileMd5 not match");
      }
      AppMethodBeat.o(192518);
      return false;
    }
    TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] md5(" + (String)localObject3 + ") successful!");
    long l1 = l2;
    long l3;
    if (paramBoolean1)
    {
      l3 = TbsDownloadConfig.getInstance(this.g).mPreferences.getLong("tbs_apkfilesize", 0L);
      if (!((File)localObject1).exists()) {
        break label759;
      }
      l1 = l2;
      if (l3 > 0L)
      {
        l1 = ((File)localObject1).length();
        if (l3 == l1) {}
      }
    }
    for (;;)
    {
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1 + " filelength failed");
      this.v.setCheckErrorDetail("fileLength:" + l1 + ",contentLength:" + l3);
      AppMethodBeat.o(192518);
      return false;
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] length(" + l1 + ") successful!");
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
              this.v.setCheckErrorDetail("fileVersion:" + i2 + ",configVersion:" + i3);
            }
            AppMethodBeat.o(192518);
            return false;
          }
        }
      }
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] tbsApkVersionCode(" + i1 + ") successful!");
      if ((paramBoolean2) && (!paramBoolean1))
      {
        String str = b.a(this.g, false, (File)localObject1);
        if (!"3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(str))
        {
          TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1 + " signature failed");
          if (paramBoolean1)
          {
            localObject2 = this.v;
            localObject3 = new StringBuilder("signature:");
            if (str != null) {
              break label639;
            }
          }
          label639:
          for (localObject1 = "null";; localObject1 = Integer.valueOf(str.length()))
          {
            ((TbsLogReport.TbsLogInfo)localObject2).setCheckErrorDetail(localObject1);
            AppMethodBeat.o(192518);
            return false;
          }
        }
      }
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] signature successful!");
      if (paramBoolean1)
      {
        try
        {
          paramBoolean1 = ((File)localObject1).renameTo(new File(this.k, "x5.tbs"));
          localObject1 = null;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            paramBoolean1 = false;
          }
        }
        paramBoolean2 = paramBoolean1;
        if (paramBoolean1) {
          break label723;
        }
        a(109, a((Throwable)localObject1), true);
        AppMethodBeat.o(192518);
        return false;
      }
      paramBoolean2 = false;
      label723:
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] rename(" + paramBoolean2 + ") successful!");
      AppMethodBeat.o(192518);
      return true;
      label759:
      l1 = 0L;
    }
  }
  
  private boolean d(boolean paramBoolean)
  {
    AppMethodBeat.i(192519);
    TbsLog.i("TbsDownload", "[TbsApkDownloader.deleteFile] isApk=".concat(String.valueOf(paramBoolean)));
    if (paramBoolean) {}
    for (File localFile = new File(this.k, "x5.tbs");; localFile = new File(this.k, "x5.tbs.temp"))
    {
      if (localFile.exists()) {
        f.b(localFile);
      }
      AppMethodBeat.o(192519);
      return true;
    }
  }
  
  private void e()
  {
    this.p = 0;
    this.q = 0;
    this.l = -1L;
    this.j = null;
    this.o = false;
    this.r = false;
    this.s = false;
    this.y = false;
  }
  
  private void f()
  {
    AppMethodBeat.i(192502);
    TbsLog.i("TbsDownload", "[TbsApkDownloader.closeHttpRequest]");
    if (this.t != null) {
      if (!this.r) {
        this.v.setResolveIp(a(this.t.getURL()));
      }
    }
    try
    {
      this.t.disconnect();
      this.t = null;
      int i1 = this.v.a;
      if ((!this.r) && (this.y))
      {
        this.v.setEventTime(System.currentTimeMillis());
        String str2 = Apn.getApnInfo(this.g);
        String str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        int i2 = Apn.getApnType(this.g);
        this.v.setApn(str1);
        this.v.setNetworkType(i2);
        if ((i2 != this.x) || (!str1.equals(this.w))) {
          this.v.setNetworkChange(0);
        }
        if (((this.v.a == 0) || (this.v.a == 107)) && (this.v.getDownFinalFlag() == 0))
        {
          if (!Apn.isNetworkAvailable(this.g)) {
            a(101, null, true);
          }
        }
        else
        {
          if (!TbsDownloader.a(this.g)) {
            break label314;
          }
          TbsLogReport.getInstance(this.g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE, this.v);
          this.v.resetArgs();
          if (i1 != 100) {
            QbSdk.l.onDownloadFinish(i1);
          }
          AppMethodBeat.o(192502);
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
          label314:
          TbsLogReport.getInstance(this.g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, this.v);
        }
      }
      TbsDownloader.a = false;
      AppMethodBeat.o(192502);
    }
  }
  
  private File g()
  {
    AppMethodBeat.i(192516);
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
      AppMethodBeat.o(192516);
      return localObject;
      localObject = TbsDownloader.getBackupFileName(false);
      break;
    }
  }
  
  private void h()
  {
    AppMethodBeat.i(192520);
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
      AppMethodBeat.o(192520);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(192520);
    }
  }
  
  private boolean i()
  {
    AppMethodBeat.i(192521);
    boolean bool = false;
    if (new File(this.k, "x5.tbs.temp").exists()) {
      bool = true;
    }
    AppMethodBeat.o(192521);
    return bool;
  }
  
  private long j()
  {
    AppMethodBeat.i(192522);
    long l1 = 0L;
    File localFile = new File(this.k, "x5.tbs.temp");
    if (localFile.exists()) {
      l1 = localFile.length();
    }
    AppMethodBeat.o(192522);
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
    //   6: ldc_w 717
    //   9: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: invokestatic 723	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   15: astore 6
    //   17: aload 6
    //   19: ldc_w 725
    //   22: ldc_w 727
    //   25: invokestatic 730	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   28: invokevirtual 537	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   31: invokevirtual 734	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   34: invokevirtual 740	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   37: astore 8
    //   39: new 742	java/io/InputStreamReader
    //   42: dup
    //   43: aload 8
    //   45: invokespecial 745	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   48: astore 9
    //   50: new 747	java/io/BufferedReader
    //   53: dup
    //   54: aload 9
    //   56: invokespecial 750	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   59: astore 7
    //   61: iconst_0
    //   62: istore_1
    //   63: aload 7
    //   65: invokevirtual 753	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   68: astore 6
    //   70: iload 4
    //   72: istore_3
    //   73: aload 6
    //   75: ifnull +29 -> 104
    //   78: aload 6
    //   80: ldc_w 755
    //   83: invokevirtual 332	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   86: ifne +16 -> 102
    //   89: aload 6
    //   91: ldc_w 757
    //   94: invokevirtual 332	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   97: istore_3
    //   98: iload_3
    //   99: ifeq +31 -> 130
    //   102: iconst_1
    //   103: istore_3
    //   104: aload_0
    //   105: aload 8
    //   107: invokespecial 759	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   110: aload_0
    //   111: aload 9
    //   113: invokespecial 759	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   116: aload_0
    //   117: aload 7
    //   119: invokespecial 759	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   122: ldc_w 717
    //   125: invokestatic 150	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   161: invokespecial 759	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   164: aload_0
    //   165: aload 7
    //   167: invokespecial 759	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   170: aload_0
    //   171: aload 6
    //   173: invokespecial 759	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
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
    //   196: invokespecial 759	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   199: aload_0
    //   200: aload 9
    //   202: invokespecial 759	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   205: aload_0
    //   206: aload 7
    //   208: invokespecial 759	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   211: ldc_w 717
    //   214: invokestatic 150	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    switch (this.p)
    {
    default: 
      return 200000L;
    case 1: 
    case 2: 
      return 20000L * this.p;
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
    //   12: ldc_w 766
    //   15: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   18: aload_0
    //   19: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   22: invokestatic 667	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   25: iconst_3
    //   26: if_icmpne +252 -> 278
    //   29: iconst_1
    //   30: istore_3
    //   31: ldc 204
    //   33: ldc_w 768
    //   36: iload_3
    //   37: invokestatic 533	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   40: invokevirtual 537	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   43: invokestatic 388	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: iload 5
    //   48: istore_2
    //   49: iload_3
    //   50: ifeq +121 -> 171
    //   53: aload_0
    //   54: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   57: invokestatic 771	com/tencent/smtt/utils/Apn:getWifiSSID	(Landroid/content/Context;)Ljava/lang/String;
    //   60: astore 6
    //   62: ldc 204
    //   64: ldc_w 773
    //   67: aload 6
    //   69: invokestatic 730	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   72: invokevirtual 537	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   75: invokestatic 388	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: new 255	java/net/URL
    //   81: dup
    //   82: ldc_w 775
    //   85: invokespecial 392	java/net/URL:<init>	(Ljava/lang/String;)V
    //   88: invokevirtual 403	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   91: checkcast 396	java/net/HttpURLConnection
    //   94: astore 7
    //   96: aload 7
    //   98: iconst_0
    //   99: invokevirtual 424	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   102: aload 7
    //   104: sipush 10000
    //   107: invokevirtual 427	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   110: aload 7
    //   112: sipush 10000
    //   115: invokevirtual 430	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   118: aload 7
    //   120: iconst_0
    //   121: invokevirtual 778	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   124: aload 7
    //   126: invokevirtual 779	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   129: pop
    //   130: aload 7
    //   132: invokevirtual 782	java/net/HttpURLConnection:getResponseCode	()I
    //   135: istore_1
    //   136: ldc 204
    //   138: ldc_w 784
    //   141: iload_1
    //   142: invokestatic 787	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   145: invokevirtual 537	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   148: invokestatic 388	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: iload_1
    //   152: sipush 204
    //   155: if_icmpne +128 -> 283
    //   158: iload 4
    //   160: istore_2
    //   161: aload 7
    //   163: ifnull +205 -> 368
    //   166: aload 7
    //   168: invokevirtual 399	java/net/HttpURLConnection:disconnect	()V
    //   171: iload_2
    //   172: ifne +68 -> 240
    //   175: aload 6
    //   177: invokestatic 792	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   180: ifne +60 -> 240
    //   183: aload_0
    //   184: getfield 113	com/tencent/smtt/sdk/m:A	Ljava/util/Set;
    //   187: aload 6
    //   189: invokeinterface 796 2 0
    //   194: ifne +46 -> 240
    //   197: aload_0
    //   198: getfield 113	com/tencent/smtt/sdk/m:A	Ljava/util/Set;
    //   201: aload 6
    //   203: invokeinterface 799 2 0
    //   208: pop
    //   209: aload_0
    //   210: invokespecial 801	com/tencent/smtt/sdk/m:n	()V
    //   213: aload_0
    //   214: getfield 803	com/tencent/smtt/sdk/m:z	Landroid/os/Handler;
    //   217: sipush 150
    //   220: aload 6
    //   222: invokevirtual 809	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   225: astore 7
    //   227: aload_0
    //   228: getfield 803	com/tencent/smtt/sdk/m:z	Landroid/os/Handler;
    //   231: aload 7
    //   233: ldc2_w 810
    //   236: invokevirtual 815	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   239: pop
    //   240: iload_2
    //   241: ifeq +29 -> 270
    //   244: aload_0
    //   245: getfield 113	com/tencent/smtt/sdk/m:A	Ljava/util/Set;
    //   248: aload 6
    //   250: invokeinterface 796 2 0
    //   255: ifeq +15 -> 270
    //   258: aload_0
    //   259: getfield 113	com/tencent/smtt/sdk/m:A	Ljava/util/Set;
    //   262: aload 6
    //   264: invokeinterface 818 2 0
    //   269: pop
    //   270: ldc_w 766
    //   273: invokestatic 150	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   305: invokevirtual 399	java/net/HttpURLConnection:disconnect	()V
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
    //   335: invokevirtual 399	java/net/HttpURLConnection:disconnect	()V
    //   338: ldc_w 766
    //   341: invokestatic 150	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(192535);
    if (this.z == null) {
      this.z = new Handler(o.a().getLooper())
      {
        public void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(192598);
          if (paramAnonymousMessage.what == 150) {
            m.a(m.this);
          }
          AppMethodBeat.o(192598);
        }
      };
    }
    AppMethodBeat.o(192535);
  }
  
  public Bundle a(int paramInt, File paramFile, boolean paramBoolean)
  {
    AppMethodBeat.i(192513);
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
      AppMethodBeat.o(192513);
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
    AppMethodBeat.i(192512);
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
      AppMethodBeat.o(192512);
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
      AppMethodBeat.o(192512);
      return localBundle;
    }
  }
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(192531);
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
        AppMethodBeat.o(192531);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(192531);
  }
  
  public boolean a()
  {
    AppMethodBeat.i(192505);
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
        AppMethodBeat.o(192505);
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
      AppMethodBeat.o(192505);
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    AppMethodBeat.i(192507);
    if ((paramBoolean) && (!m()) && ((!QbSdk.getDownloadWithoutWifi()) || (!Apn.isNetworkAvailable(this.g))))
    {
      AppMethodBeat.o(192507);
      return false;
    }
    if ((this.b != null) && (this.c >= 0) && (this.c < this.b.length))
    {
      String[] arrayOfString = this.b;
      int i1 = this.c;
      this.c = (i1 + 1);
      this.j = arrayOfString[i1];
      this.p = 0;
      this.q = 0;
      this.l = -1L;
      this.o = false;
      this.r = false;
      this.s = false;
      this.y = false;
      AppMethodBeat.o(192507);
      return true;
    }
    AppMethodBeat.o(192507);
    return false;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(192504);
    if (Build.VERSION.SDK_INT == 23)
    {
      AppMethodBeat.o(192504);
      return false;
    }
    int i1 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("use_backup_version", 0);
    int i2 = q.a().j(this.g);
    if (i1 == 0) {
      i1 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_download_version", 0);
    }
    for (this.a = "by default key"; (i1 == 0) || (i1 == i2); this.a = "by new key")
    {
      AppMethodBeat.o(192504);
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
            break label446;
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
            TbsLogReport.getInstance(this.g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE, this.v);
            this.v.resetArgs();
          }
          AppMethodBeat.o(192504);
          return true;
        }
        catch (Exception localException) {}
        localObject = TbsDownloader.getBackupFileName(false);
        break;
        label371:
        i2 = 0;
        continue;
        label377:
        TbsLogReport.getInstance(this.g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, this.v);
      }
      label397:
      h();
      if ((localFile != null) && (localFile.exists()) && (!a.a(this.g, localFile, 0L, i1)) && (localFile != null) && (localFile.exists())) {
        f.b(localFile);
      }
    }
    label446:
    if (c(false, paramBoolean2))
    {
      TbsDownloadConfig.getInstance(this.g).mSyncMap.put("tbs_download_interrupt_code_reason", Integer.valueOf(-214));
      TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-214);
      c(false);
      AppMethodBeat.o(192504);
      return true;
    }
    if ((!d(true)) && (!d(true)))
    {
      TbsLog.e("TbsDownload", "[TbsApkDownloader] delete file failed!");
      TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-301);
    }
    AppMethodBeat.o(192504);
    return false;
  }
  
  public int b(boolean paramBoolean)
  {
    AppMethodBeat.i(192528);
    File localFile = a(this.g);
    int i1;
    if (paramBoolean)
    {
      if (localFile == null)
      {
        AppMethodBeat.o(192528);
        return 0;
      }
      i1 = a.a(this.g, new File(localFile, TbsDownloader.getBackupFileName(true)));
      AppMethodBeat.o(192528);
      return i1;
    }
    if (localFile == null)
    {
      AppMethodBeat.o(192528);
      return 0;
    }
    Context localContext = this.g;
    if (TbsDownloader.getOverSea(this.g)) {}
    for (String str = "x5.oversea.tbs.org";; str = TbsDownloader.getBackupFileName(false))
    {
      i1 = a.a(localContext, new File(localFile, str));
      AppMethodBeat.o(192528);
      return i1;
    }
  }
  
  public void b()
  {
    AppMethodBeat.i(192529);
    this.r = true;
    if (TbsShareManager.isThirdPartyApp(this.g))
    {
      TbsLogReport.TbsLogInfo localTbsLogInfo = TbsLogReport.getInstance(this.g).tbsLogInfo();
      localTbsLogInfo.setErrorCode(-309);
      localTbsLogInfo.setFailDetail(new Exception());
      if (TbsDownloader.a(this.g))
      {
        TbsLogReport.getInstance(this.g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE, localTbsLogInfo);
        AppMethodBeat.o(192529);
        return;
      }
      TbsLogReport.getInstance(this.g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, localTbsLogInfo);
    }
    AppMethodBeat.o(192529);
  }
  
  /* Error */
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: ldc_w 932
    //   3: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   10: invokestatic 937	com/tencent/smtt/sdk/TbsOneGreyInfoHelper:isTbsOneModeEnable	(Landroid/content/Context;)Z
    //   13: ifeq +12 -> 25
    //   16: ldc_w 939
    //   19: ldc_w 941
    //   22: invokestatic 388	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: invokestatic 138	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   28: aload_0
    //   29: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   32: invokevirtual 943	com/tencent/smtt/sdk/q:d	(Landroid/content/Context;)Z
    //   35: ifeq +31 -> 66
    //   38: iload_1
    //   39: ifne +27 -> 66
    //   42: iconst_0
    //   43: putstatic 704	com/tencent/smtt/sdk/TbsDownloader:a	Z
    //   46: aload_0
    //   47: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   50: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   53: sipush -322
    //   56: invokevirtual 906	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   59: ldc_w 932
    //   62: invokestatic 150	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: return
    //   66: aload_0
    //   67: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   70: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   73: getfield 309	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   76: ldc_w 380
    //   79: iconst_0
    //   80: invokeinterface 317 3 0
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
    //   102: istore 8
    //   104: iload_2
    //   105: ifne +30 -> 135
    //   108: aload_0
    //   109: iload_1
    //   110: iload 8
    //   112: invokevirtual 945	com/tencent/smtt/sdk/m:a	(ZZ)Z
    //   115: ifeq +20 -> 135
    //   118: iconst_0
    //   119: putstatic 704	com/tencent/smtt/sdk/TbsDownloader:a	Z
    //   122: ldc_w 932
    //   125: invokestatic 150	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: return
    //   129: iconst_0
    //   130: istore 8
    //   132: goto -28 -> 104
    //   135: aload_0
    //   136: iload_1
    //   137: putfield 947	com/tencent/smtt/sdk/m:C	Z
    //   140: aload_0
    //   141: aload_0
    //   142: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   145: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   148: getfield 309	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   151: ldc_w 949
    //   154: aconst_null
    //   155: invokeinterface 543 3 0
    //   160: putfield 951	com/tencent/smtt/sdk/m:h	Ljava/lang/String;
    //   163: aload_0
    //   164: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   167: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   170: getfield 309	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   173: ldc_w 953
    //   176: aconst_null
    //   177: invokeinterface 543 3 0
    //   182: astore 29
    //   184: ldc 204
    //   186: ldc_w 955
    //   189: aload 29
    //   191: invokestatic 730	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   194: invokevirtual 537	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   197: iconst_1
    //   198: invokestatic 958	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   201: aload_0
    //   202: aconst_null
    //   203: putfield 86	com/tencent/smtt/sdk/m:b	[Ljava/lang/String;
    //   206: aload_0
    //   207: iconst_0
    //   208: putfield 88	com/tencent/smtt/sdk/m:c	I
    //   211: iload_1
    //   212: ifne +36 -> 248
    //   215: aload 29
    //   217: ifnull +31 -> 248
    //   220: ldc 253
    //   222: aload 29
    //   224: invokevirtual 961	java/lang/String:trim	()Ljava/lang/String;
    //   227: invokevirtual 550	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   230: ifne +18 -> 248
    //   233: aload_0
    //   234: aload 29
    //   236: invokevirtual 961	java/lang/String:trim	()Ljava/lang/String;
    //   239: ldc_w 963
    //   242: invokevirtual 967	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   245: putfield 86	com/tencent/smtt/sdk/m:b	[Ljava/lang/String;
    //   248: ldc 204
    //   250: new 115	java/lang/StringBuilder
    //   253: dup
    //   254: ldc_w 969
    //   257: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   260: aload_0
    //   261: getfield 951	com/tencent/smtt/sdk/m:h	Ljava/lang/String;
    //   264: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: ldc_w 971
    //   270: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: aload 29
    //   275: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: ldc_w 973
    //   281: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: aload_0
    //   285: getfield 633	com/tencent/smtt/sdk/m:j	Ljava/lang/String;
    //   288: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: ldc_w 975
    //   294: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: aload_0
    //   298: getfield 637	com/tencent/smtt/sdk/m:r	Z
    //   301: invokevirtual 553	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   304: ldc_w 977
    //   307: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: aload_0
    //   311: getfield 394	com/tencent/smtt/sdk/m:t	Ljava/net/HttpURLConnection;
    //   314: invokevirtual 607	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   317: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokestatic 388	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   323: aload_0
    //   324: getfield 951	com/tencent/smtt/sdk/m:h	Ljava/lang/String;
    //   327: ifnonnull +40 -> 367
    //   330: aload_0
    //   331: getfield 633	com/tencent/smtt/sdk/m:j	Ljava/lang/String;
    //   334: ifnonnull +33 -> 367
    //   337: getstatic 499	com/tencent/smtt/sdk/QbSdk:l	Lcom/tencent/smtt/sdk/TbsListener;
    //   340: bipush 110
    //   342: invokeinterface 504 2 0
    //   347: aload_0
    //   348: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   351: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   354: sipush -302
    //   357: invokevirtual 906	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   360: ldc_w 932
    //   363: invokestatic 150	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   366: return
    //   367: aload_0
    //   368: getfield 394	com/tencent/smtt/sdk/m:t	Ljava/net/HttpURLConnection;
    //   371: ifnull +40 -> 411
    //   374: aload_0
    //   375: getfield 637	com/tencent/smtt/sdk/m:r	Z
    //   378: ifne +33 -> 411
    //   381: getstatic 499	com/tencent/smtt/sdk/QbSdk:l	Lcom/tencent/smtt/sdk/TbsListener;
    //   384: bipush 110
    //   386: invokeinterface 504 2 0
    //   391: aload_0
    //   392: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   395: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   398: sipush -303
    //   401: invokevirtual 906	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   404: ldc_w 932
    //   407: invokestatic 150	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   410: return
    //   411: iload_1
    //   412: ifne +60 -> 472
    //   415: aload_0
    //   416: getfield 113	com/tencent/smtt/sdk/m:A	Ljava/util/Set;
    //   419: aload_0
    //   420: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   423: invokestatic 771	com/tencent/smtt/utils/Apn:getWifiSSID	(Landroid/content/Context;)Ljava/lang/String;
    //   426: invokeinterface 796 2 0
    //   431: ifeq +41 -> 472
    //   434: ldc 204
    //   436: ldc_w 979
    //   439: invokestatic 388	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   442: getstatic 499	com/tencent/smtt/sdk/QbSdk:l	Lcom/tencent/smtt/sdk/TbsListener;
    //   445: bipush 110
    //   447: invokeinterface 504 2 0
    //   452: aload_0
    //   453: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   456: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   459: sipush -304
    //   462: invokevirtual 906	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   465: ldc_w 932
    //   468: invokestatic 150	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   471: return
    //   472: aload_0
    //   473: invokespecial 152	com/tencent/smtt/sdk/m:e	()V
    //   476: ldc 204
    //   478: ldc_w 981
    //   481: iconst_1
    //   482: invokestatic 958	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   485: aload_0
    //   486: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   489: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   492: invokevirtual 984	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMaxflow	()J
    //   495: lstore 27
    //   497: iconst_0
    //   498: istore_2
    //   499: aload_0
    //   500: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   503: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   506: getfield 309	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   509: ldc_w 986
    //   512: lconst_0
    //   513: invokeinterface 570 4 0
    //   518: lstore 13
    //   520: iload_1
    //   521: ifeq +255 -> 776
    //   524: aload_0
    //   525: getstatic 53	com/tencent/smtt/sdk/m:e	I
    //   528: putfield 84	com/tencent/smtt/sdk/m:B	I
    //   531: iload_2
    //   532: istore 5
    //   534: aload_0
    //   535: getfield 271	com/tencent/smtt/sdk/m:p	I
    //   538: aload_0
    //   539: getfield 84	com/tencent/smtt/sdk/m:B	I
    //   542: if_icmpgt +36 -> 578
    //   545: aload_0
    //   546: getfield 627	com/tencent/smtt/sdk/m:q	I
    //   549: bipush 8
    //   551: if_icmple +235 -> 786
    //   554: aload_0
    //   555: bipush 123
    //   557: aconst_null
    //   558: iconst_1
    //   559: invokespecial 616	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   562: aload_0
    //   563: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   566: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   569: sipush -306
    //   572: invokevirtual 906	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   575: iload_2
    //   576: istore 5
    //   578: aload_0
    //   579: getfield 637	com/tencent/smtt/sdk/m:r	Z
    //   582: ifne +183 -> 765
    //   585: iload 5
    //   587: istore_1
    //   588: aload_0
    //   589: getfield 639	com/tencent/smtt/sdk/m:s	Z
    //   592: ifeq +102 -> 694
    //   595: iload 5
    //   597: istore_1
    //   598: aload_0
    //   599: getfield 86	com/tencent/smtt/sdk/m:b	[Ljava/lang/String;
    //   602: ifnonnull +19 -> 621
    //   605: iload 5
    //   607: istore_1
    //   608: iload 5
    //   610: ifne +11 -> 621
    //   613: aload_0
    //   614: iconst_1
    //   615: iload 8
    //   617: invokespecial 914	com/tencent/smtt/sdk/m:c	(ZZ)Z
    //   620: istore_1
    //   621: aload_0
    //   622: getfield 108	com/tencent/smtt/sdk/m:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   625: astore 29
    //   627: iload_1
    //   628: ifeq +5767 -> 6395
    //   631: iconst_1
    //   632: istore_3
    //   633: aload 29
    //   635: iload_3
    //   636: invokevirtual 989	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setUnpkgFlag	(I)V
    //   639: iload 8
    //   641: ifne +5764 -> 6405
    //   644: aload_0
    //   645: getfield 108	com/tencent/smtt/sdk/m:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   648: astore 29
    //   650: iload_1
    //   651: ifeq +5749 -> 6400
    //   654: iconst_1
    //   655: istore_3
    //   656: aload 29
    //   658: iload_3
    //   659: invokevirtual 992	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setPatchUpdateFlag	(I)V
    //   662: iload_1
    //   663: ifeq +5753 -> 6416
    //   666: aload_0
    //   667: iconst_1
    //   668: invokespecial 908	com/tencent/smtt/sdk/m:c	(Z)V
    //   671: aload_0
    //   672: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   675: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   678: sipush -317
    //   681: invokevirtual 906	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   684: aload_0
    //   685: bipush 100
    //   687: ldc_w 994
    //   690: iconst_1
    //   691: invokespecial 616	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   694: aload_0
    //   695: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   698: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   701: astore 29
    //   703: iload_1
    //   704: ifeq +5734 -> 6438
    //   707: aload 29
    //   709: getfield 309	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   712: ldc_w 996
    //   715: iconst_0
    //   716: invokeinterface 317 3 0
    //   721: istore_3
    //   722: aload 29
    //   724: getfield 467	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   727: ldc_w 996
    //   730: iload_3
    //   731: iconst_1
    //   732: iadd
    //   733: invokestatic 491	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   736: invokeinterface 481 3 0
    //   741: pop
    //   742: aload 29
    //   744: invokevirtual 494	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   747: aload_0
    //   748: getfield 108	com/tencent/smtt/sdk/m:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   751: astore 29
    //   753: iload_1
    //   754: ifeq +5745 -> 6499
    //   757: iconst_1
    //   758: istore_3
    //   759: aload 29
    //   761: iload_3
    //   762: invokevirtual 999	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownFinalFlag	(I)V
    //   765: aload_0
    //   766: invokespecial 1001	com/tencent/smtt/sdk/m:f	()V
    //   769: ldc_w 932
    //   772: invokestatic 150	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   775: return
    //   776: aload_0
    //   777: getstatic 51	com/tencent/smtt/sdk/m:d	I
    //   780: putfield 84	com/tencent/smtt/sdk/m:B	I
    //   783: goto -252 -> 531
    //   786: invokestatic 164	java/lang/System:currentTimeMillis	()J
    //   789: lstore 23
    //   791: lload 13
    //   793: lstore 9
    //   795: iload_1
    //   796: ifne +439 -> 1235
    //   799: lload 13
    //   801: lstore 15
    //   803: iload_2
    //   804: istore 5
    //   806: lload 13
    //   808: lstore 11
    //   810: lload 23
    //   812: aload_0
    //   813: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   816: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   819: getfield 309	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   822: ldc_w 1003
    //   825: lconst_0
    //   826: invokeinterface 570 4 0
    //   831: lsub
    //   832: ldc2_w 1004
    //   835: lcmp
    //   836: ifle +250 -> 1086
    //   839: lload 13
    //   841: lstore 15
    //   843: iload_2
    //   844: istore 5
    //   846: lload 13
    //   848: lstore 11
    //   850: ldc 204
    //   852: ldc_w 1007
    //   855: invokestatic 388	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   858: lload 13
    //   860: lstore 15
    //   862: iload_2
    //   863: istore 5
    //   865: lload 13
    //   867: lstore 11
    //   869: aload_0
    //   870: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   873: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   876: getfield 467	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   879: ldc_w 1003
    //   882: lload 23
    //   884: invokestatic 1012	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   887: invokeinterface 481 3 0
    //   892: pop
    //   893: lload 13
    //   895: lstore 15
    //   897: iload_2
    //   898: istore 5
    //   900: lload 13
    //   902: lstore 11
    //   904: aload_0
    //   905: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   908: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   911: getfield 467	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   914: ldc_w 986
    //   917: lconst_0
    //   918: invokestatic 1012	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   921: invokeinterface 481 3 0
    //   926: pop
    //   927: lload 13
    //   929: lstore 15
    //   931: iload_2
    //   932: istore 5
    //   934: lload 13
    //   936: lstore 11
    //   938: aload_0
    //   939: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   942: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   945: invokevirtual 494	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   948: lconst_0
    //   949: lstore 17
    //   951: lload 17
    //   953: lstore 9
    //   955: lload 17
    //   957: lstore 15
    //   959: iload_2
    //   960: istore 5
    //   962: lload 17
    //   964: lstore 11
    //   966: aload_0
    //   967: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   970: invokestatic 1014	com/tencent/smtt/utils/f:b	(Landroid/content/Context;)Z
    //   973: ifne +262 -> 1235
    //   976: lload 17
    //   978: lstore 15
    //   980: iload_2
    //   981: istore 5
    //   983: lload 17
    //   985: lstore 11
    //   987: ldc 204
    //   989: ldc_w 1016
    //   992: iconst_1
    //   993: invokestatic 958	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   996: lload 17
    //   998: lstore 15
    //   1000: iload_2
    //   1001: istore 5
    //   1003: lload 17
    //   1005: lstore 11
    //   1007: aload_0
    //   1008: bipush 105
    //   1010: aconst_null
    //   1011: iconst_1
    //   1012: invokespecial 616	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   1015: lload 17
    //   1017: lstore 15
    //   1019: iload_2
    //   1020: istore 5
    //   1022: lload 17
    //   1024: lstore 11
    //   1026: aload_0
    //   1027: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   1030: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1033: sipush -308
    //   1036: invokevirtual 906	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   1039: iload_2
    //   1040: istore 5
    //   1042: iload_1
    //   1043: ifne -465 -> 578
    //   1046: aload_0
    //   1047: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   1050: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1053: getfield 467	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1056: ldc_w 986
    //   1059: lload 17
    //   1061: invokestatic 1012	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1064: invokeinterface 481 3 0
    //   1069: pop
    //   1070: aload_0
    //   1071: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   1074: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1077: invokevirtual 494	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1080: iload_2
    //   1081: istore 5
    //   1083: goto -505 -> 578
    //   1086: lload 13
    //   1088: lstore 15
    //   1090: iload_2
    //   1091: istore 5
    //   1093: lload 13
    //   1095: lstore 11
    //   1097: ldc 204
    //   1099: ldc_w 1018
    //   1102: lload 13
    //   1104: invokestatic 1021	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1107: invokevirtual 537	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1110: invokestatic 388	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1113: lload 13
    //   1115: lstore 17
    //   1117: lload 13
    //   1119: lload 27
    //   1121: lcmp
    //   1122: iflt -171 -> 951
    //   1125: lload 13
    //   1127: lstore 15
    //   1129: iload_2
    //   1130: istore 5
    //   1132: lload 13
    //   1134: lstore 11
    //   1136: ldc 204
    //   1138: ldc_w 1023
    //   1141: iconst_1
    //   1142: invokestatic 958	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1145: lload 13
    //   1147: lstore 15
    //   1149: iload_2
    //   1150: istore 5
    //   1152: lload 13
    //   1154: lstore 11
    //   1156: aload_0
    //   1157: bipush 112
    //   1159: aconst_null
    //   1160: iconst_1
    //   1161: invokespecial 616	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   1164: lload 13
    //   1166: lstore 15
    //   1168: iload_2
    //   1169: istore 5
    //   1171: lload 13
    //   1173: lstore 11
    //   1175: aload_0
    //   1176: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   1179: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1182: sipush -307
    //   1185: invokevirtual 906	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   1188: iload_2
    //   1189: istore 5
    //   1191: iload_1
    //   1192: ifne -614 -> 578
    //   1195: aload_0
    //   1196: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   1199: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1202: getfield 467	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1205: ldc_w 986
    //   1208: lload 13
    //   1210: invokestatic 1012	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1213: invokeinterface 481 3 0
    //   1218: pop
    //   1219: aload_0
    //   1220: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   1223: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1226: invokevirtual 494	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1229: iload_2
    //   1230: istore 5
    //   1232: goto -654 -> 578
    //   1235: lload 9
    //   1237: lstore 15
    //   1239: iload_2
    //   1240: istore 5
    //   1242: lload 9
    //   1244: lstore 11
    //   1246: aload_0
    //   1247: iconst_1
    //   1248: putfield 641	com/tencent/smtt/sdk/m:y	Z
    //   1251: lload 9
    //   1253: lstore 15
    //   1255: iload_2
    //   1256: istore 5
    //   1258: lload 9
    //   1260: lstore 11
    //   1262: aload_0
    //   1263: getfield 633	com/tencent/smtt/sdk/m:j	Ljava/lang/String;
    //   1266: ifnull +809 -> 2075
    //   1269: lload 9
    //   1271: lstore 15
    //   1273: iload_2
    //   1274: istore 5
    //   1276: lload 9
    //   1278: lstore 11
    //   1280: aload_0
    //   1281: getfield 633	com/tencent/smtt/sdk/m:j	Ljava/lang/String;
    //   1284: astore 29
    //   1286: lload 9
    //   1288: lstore 15
    //   1290: iload_2
    //   1291: istore 5
    //   1293: lload 9
    //   1295: lstore 11
    //   1297: ldc 204
    //   1299: new 115	java/lang/StringBuilder
    //   1302: dup
    //   1303: ldc_w 1025
    //   1306: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1309: aload 29
    //   1311: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1314: ldc_w 1027
    //   1317: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1320: aload_0
    //   1321: getfield 271	com/tencent/smtt/sdk/m:p	I
    //   1324: invokevirtual 368	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1327: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1330: iconst_1
    //   1331: invokestatic 958	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1334: lload 9
    //   1336: lstore 15
    //   1338: iload_2
    //   1339: istore 5
    //   1341: lload 9
    //   1343: lstore 11
    //   1345: aload 29
    //   1347: aload_0
    //   1348: getfield 1029	com/tencent/smtt/sdk/m:i	Ljava/lang/String;
    //   1351: invokevirtual 550	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1354: ifne +23 -> 1377
    //   1357: lload 9
    //   1359: lstore 15
    //   1361: iload_2
    //   1362: istore 5
    //   1364: lload 9
    //   1366: lstore 11
    //   1368: aload_0
    //   1369: getfield 108	com/tencent/smtt/sdk/m:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   1372: aload 29
    //   1374: invokevirtual 1032	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownloadUrl	(Ljava/lang/String;)V
    //   1377: lload 9
    //   1379: lstore 15
    //   1381: iload_2
    //   1382: istore 5
    //   1384: lload 9
    //   1386: lstore 11
    //   1388: aload_0
    //   1389: aload 29
    //   1391: putfield 1029	com/tencent/smtt/sdk/m:i	Ljava/lang/String;
    //   1394: lload 9
    //   1396: lstore 15
    //   1398: iload_2
    //   1399: istore 5
    //   1401: lload 9
    //   1403: lstore 11
    //   1405: aload_0
    //   1406: aload 29
    //   1408: invokespecial 1034	com/tencent/smtt/sdk/m:a	(Ljava/lang/String;)V
    //   1411: lconst_0
    //   1412: lstore 13
    //   1414: lload 9
    //   1416: lstore 15
    //   1418: iload_2
    //   1419: istore 5
    //   1421: lload 9
    //   1423: lstore 11
    //   1425: aload_0
    //   1426: getfield 635	com/tencent/smtt/sdk/m:o	Z
    //   1429: ifne +140 -> 1569
    //   1432: lload 9
    //   1434: lstore 15
    //   1436: iload_2
    //   1437: istore 5
    //   1439: lload 9
    //   1441: lstore 11
    //   1443: aload_0
    //   1444: invokespecial 1036	com/tencent/smtt/sdk/m:j	()J
    //   1447: lstore 13
    //   1449: lload 9
    //   1451: lstore 15
    //   1453: iload_2
    //   1454: istore 5
    //   1456: lload 9
    //   1458: lstore 11
    //   1460: ldc 204
    //   1462: ldc_w 1038
    //   1465: lload 13
    //   1467: invokestatic 1021	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1470: invokevirtual 537	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1473: invokestatic 388	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1476: lload 9
    //   1478: lstore 15
    //   1480: iload_2
    //   1481: istore 5
    //   1483: lload 9
    //   1485: lstore 11
    //   1487: aload_0
    //   1488: getfield 631	com/tencent/smtt/sdk/m:l	J
    //   1491: lconst_0
    //   1492: lcmp
    //   1493: ifgt +602 -> 2095
    //   1496: lload 9
    //   1498: lstore 15
    //   1500: iload_2
    //   1501: istore 5
    //   1503: lload 9
    //   1505: lstore 11
    //   1507: ldc 204
    //   1509: ldc_w 1040
    //   1512: lload 13
    //   1514: invokestatic 1021	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1517: invokevirtual 537	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1520: iconst_1
    //   1521: invokestatic 958	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1524: lload 9
    //   1526: lstore 15
    //   1528: iload_2
    //   1529: istore 5
    //   1531: lload 9
    //   1533: lstore 11
    //   1535: aload_0
    //   1536: getfield 394	com/tencent/smtt/sdk/m:t	Ljava/net/HttpURLConnection;
    //   1539: ldc_w 1042
    //   1542: new 115	java/lang/StringBuilder
    //   1545: dup
    //   1546: ldc_w 1044
    //   1549: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1552: lload 13
    //   1554: invokevirtual 579	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1557: ldc_w 1046
    //   1560: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1563: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1566: invokevirtual 411	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1569: lload 9
    //   1571: lstore 15
    //   1573: iload_2
    //   1574: istore 5
    //   1576: lload 9
    //   1578: lstore 11
    //   1580: aload_0
    //   1581: getfield 108	com/tencent/smtt/sdk/m:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   1584: astore 29
    //   1586: lload 13
    //   1588: lconst_0
    //   1589: lcmp
    //   1590: ifne +780 -> 2370
    //   1593: iconst_0
    //   1594: istore_3
    //   1595: lload 9
    //   1597: lstore 15
    //   1599: iload_2
    //   1600: istore 5
    //   1602: lload 9
    //   1604: lstore 11
    //   1606: aload 29
    //   1608: iload_3
    //   1609: invokevirtual 1049	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownloadCancel	(I)V
    //   1612: lload 9
    //   1614: lstore 15
    //   1616: iload_2
    //   1617: istore 5
    //   1619: lload 9
    //   1621: lstore 11
    //   1623: aload_0
    //   1624: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   1627: invokestatic 667	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   1630: istore_3
    //   1631: lload 9
    //   1633: lstore 15
    //   1635: iload_2
    //   1636: istore 5
    //   1638: lload 9
    //   1640: lstore 11
    //   1642: aload_0
    //   1643: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   1646: invokestatic 663	com/tencent/smtt/utils/Apn:getApnInfo	(Landroid/content/Context;)Ljava/lang/String;
    //   1649: astore 29
    //   1651: lload 9
    //   1653: lstore 15
    //   1655: iload_2
    //   1656: istore 5
    //   1658: lload 9
    //   1660: lstore 11
    //   1662: aload_0
    //   1663: getfield 154	com/tencent/smtt/sdk/m:w	Ljava/lang/String;
    //   1666: ifnonnull +709 -> 2375
    //   1669: lload 9
    //   1671: lstore 15
    //   1673: iload_2
    //   1674: istore 5
    //   1676: lload 9
    //   1678: lstore 11
    //   1680: aload_0
    //   1681: getfield 156	com/tencent/smtt/sdk/m:x	I
    //   1684: iconst_m1
    //   1685: if_icmpne +690 -> 2375
    //   1688: lload 9
    //   1690: lstore 15
    //   1692: iload_2
    //   1693: istore 5
    //   1695: lload 9
    //   1697: lstore 11
    //   1699: aload_0
    //   1700: aload 29
    //   1702: putfield 154	com/tencent/smtt/sdk/m:w	Ljava/lang/String;
    //   1705: lload 9
    //   1707: lstore 15
    //   1709: iload_2
    //   1710: istore 5
    //   1712: lload 9
    //   1714: lstore 11
    //   1716: aload_0
    //   1717: iload_3
    //   1718: putfield 156	com/tencent/smtt/sdk/m:x	I
    //   1721: lload 9
    //   1723: lstore 15
    //   1725: iload_2
    //   1726: istore 5
    //   1728: lload 9
    //   1730: lstore 11
    //   1732: aload_0
    //   1733: getfield 271	com/tencent/smtt/sdk/m:p	I
    //   1736: ifle +28 -> 1764
    //   1739: lload 9
    //   1741: lstore 15
    //   1743: iload_2
    //   1744: istore 5
    //   1746: lload 9
    //   1748: lstore 11
    //   1750: aload_0
    //   1751: getfield 394	com/tencent/smtt/sdk/m:t	Ljava/net/HttpURLConnection;
    //   1754: ldc_w 1051
    //   1757: aload_0
    //   1758: getfield 951	com/tencent/smtt/sdk/m:h	Ljava/lang/String;
    //   1761: invokevirtual 1054	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1764: lload 9
    //   1766: lstore 15
    //   1768: iload_2
    //   1769: istore 5
    //   1771: lload 9
    //   1773: lstore 11
    //   1775: aload_0
    //   1776: getfield 394	com/tencent/smtt/sdk/m:t	Ljava/net/HttpURLConnection;
    //   1779: invokevirtual 782	java/net/HttpURLConnection:getResponseCode	()I
    //   1782: istore_3
    //   1783: lload 9
    //   1785: lstore 15
    //   1787: iload_2
    //   1788: istore 5
    //   1790: lload 9
    //   1792: lstore 11
    //   1794: ldc 204
    //   1796: ldc_w 1056
    //   1799: iload_3
    //   1800: invokestatic 787	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1803: invokevirtual 537	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1806: invokestatic 388	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1809: lload 9
    //   1811: lstore 15
    //   1813: iload_2
    //   1814: istore 5
    //   1816: lload 9
    //   1818: lstore 11
    //   1820: aload_0
    //   1821: getfield 108	com/tencent/smtt/sdk/m:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   1824: iload_3
    //   1825: invokevirtual 1059	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setHttpCode	(I)V
    //   1828: iload_1
    //   1829: ifne +157 -> 1986
    //   1832: lload 9
    //   1834: lstore 15
    //   1836: iload_2
    //   1837: istore 5
    //   1839: lload 9
    //   1841: lstore 11
    //   1843: aload_0
    //   1844: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   1847: invokestatic 223	com/tencent/smtt/sdk/TbsDownloader:getOverSea	(Landroid/content/Context;)Z
    //   1850: ifne +136 -> 1986
    //   1853: lload 9
    //   1855: lstore 15
    //   1857: iload_2
    //   1858: istore 5
    //   1860: lload 9
    //   1862: lstore 11
    //   1864: aload_0
    //   1865: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   1868: invokestatic 667	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   1871: iconst_3
    //   1872: if_icmpne +24 -> 1896
    //   1875: lload 9
    //   1877: lstore 15
    //   1879: iload_2
    //   1880: istore 5
    //   1882: lload 9
    //   1884: lstore 11
    //   1886: aload_0
    //   1887: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   1890: invokestatic 667	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   1893: ifne +93 -> 1986
    //   1896: lload 9
    //   1898: lstore 15
    //   1900: iload_2
    //   1901: istore 5
    //   1903: lload 9
    //   1905: lstore 11
    //   1907: invokestatic 890	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   1910: ifne +76 -> 1986
    //   1913: lload 9
    //   1915: lstore 15
    //   1917: iload_2
    //   1918: istore 5
    //   1920: lload 9
    //   1922: lstore 11
    //   1924: aload_0
    //   1925: invokevirtual 1060	com/tencent/smtt/sdk/m:b	()V
    //   1928: lload 9
    //   1930: lstore 15
    //   1932: iload_2
    //   1933: istore 5
    //   1935: lload 9
    //   1937: lstore 11
    //   1939: getstatic 499	com/tencent/smtt/sdk/QbSdk:l	Lcom/tencent/smtt/sdk/TbsListener;
    //   1942: ifnull +24 -> 1966
    //   1945: lload 9
    //   1947: lstore 15
    //   1949: iload_2
    //   1950: istore 5
    //   1952: lload 9
    //   1954: lstore 11
    //   1956: getstatic 499	com/tencent/smtt/sdk/QbSdk:l	Lcom/tencent/smtt/sdk/TbsListener;
    //   1959: bipush 111
    //   1961: invokeinterface 504 2 0
    //   1966: lload 9
    //   1968: lstore 15
    //   1970: iload_2
    //   1971: istore 5
    //   1973: lload 9
    //   1975: lstore 11
    //   1977: ldc 204
    //   1979: ldc_w 1062
    //   1982: iconst_0
    //   1983: invokestatic 958	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1986: lload 9
    //   1988: lstore 15
    //   1990: iload_2
    //   1991: istore 5
    //   1993: lload 9
    //   1995: lstore 11
    //   1997: aload_0
    //   1998: getfield 637	com/tencent/smtt/sdk/m:r	Z
    //   2001: ifeq +524 -> 2525
    //   2004: lload 9
    //   2006: lstore 15
    //   2008: iload_2
    //   2009: istore 5
    //   2011: lload 9
    //   2013: lstore 11
    //   2015: aload_0
    //   2016: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   2019: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2022: sipush -309
    //   2025: invokevirtual 906	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2028: iload_2
    //   2029: istore 5
    //   2031: iload_1
    //   2032: ifne -1454 -> 578
    //   2035: aload_0
    //   2036: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   2039: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2042: getfield 467	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2045: ldc_w 986
    //   2048: lload 9
    //   2050: invokestatic 1012	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2053: invokeinterface 481 3 0
    //   2058: pop
    //   2059: aload_0
    //   2060: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   2063: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2066: invokevirtual 494	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2069: iload_2
    //   2070: istore 5
    //   2072: goto -1494 -> 578
    //   2075: lload 9
    //   2077: lstore 15
    //   2079: iload_2
    //   2080: istore 5
    //   2082: lload 9
    //   2084: lstore 11
    //   2086: aload_0
    //   2087: getfield 951	com/tencent/smtt/sdk/m:h	Ljava/lang/String;
    //   2090: astore 29
    //   2092: goto -806 -> 1286
    //   2095: lload 9
    //   2097: lstore 15
    //   2099: iload_2
    //   2100: istore 5
    //   2102: lload 9
    //   2104: lstore 11
    //   2106: ldc 204
    //   2108: new 115	java/lang/StringBuilder
    //   2111: dup
    //   2112: ldc_w 1064
    //   2115: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2118: lload 13
    //   2120: invokevirtual 579	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2123: ldc_w 1066
    //   2126: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2129: aload_0
    //   2130: getfield 631	com/tencent/smtt/sdk/m:l	J
    //   2133: invokevirtual 579	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2136: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2139: iconst_1
    //   2140: invokestatic 958	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   2143: lload 9
    //   2145: lstore 15
    //   2147: iload_2
    //   2148: istore 5
    //   2150: lload 9
    //   2152: lstore 11
    //   2154: aload_0
    //   2155: getfield 394	com/tencent/smtt/sdk/m:t	Ljava/net/HttpURLConnection;
    //   2158: ldc_w 1042
    //   2161: new 115	java/lang/StringBuilder
    //   2164: dup
    //   2165: ldc_w 1044
    //   2168: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2171: lload 13
    //   2173: invokevirtual 579	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2176: ldc_w 1046
    //   2179: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2182: aload_0
    //   2183: getfield 631	com/tencent/smtt/sdk/m:l	J
    //   2186: invokevirtual 579	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2189: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2192: invokevirtual 411	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   2195: goto -626 -> 1569
    //   2198: astore 29
    //   2200: iload 5
    //   2202: istore 6
    //   2204: lload 15
    //   2206: lstore 11
    //   2208: aload 29
    //   2210: instanceof 1068
    //   2213: ifeq +4079 -> 6292
    //   2216: iload_1
    //   2217: ifne +4075 -> 6292
    //   2220: lload 15
    //   2222: lstore 11
    //   2224: aload_0
    //   2225: getfield 86	com/tencent/smtt/sdk/m:b	[Ljava/lang/String;
    //   2228: ifnull +4064 -> 6292
    //   2231: lload 15
    //   2233: lstore 11
    //   2235: aload_0
    //   2236: iconst_0
    //   2237: invokevirtual 1070	com/tencent/smtt/sdk/m:a	(Z)Z
    //   2240: ifeq +4052 -> 6292
    //   2243: lload 15
    //   2245: lstore 11
    //   2247: ldc 204
    //   2249: new 115	java/lang/StringBuilder
    //   2252: dup
    //   2253: ldc_w 1072
    //   2256: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2259: aload_0
    //   2260: getfield 633	com/tencent/smtt/sdk/m:j	Ljava/lang/String;
    //   2263: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2266: ldc_w 1074
    //   2269: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2272: aload 29
    //   2274: invokevirtual 433	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2277: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2280: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2283: invokestatic 214	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2286: lload 15
    //   2288: lstore 11
    //   2290: aload_0
    //   2291: bipush 125
    //   2293: aconst_null
    //   2294: iconst_1
    //   2295: invokespecial 616	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   2298: lload 15
    //   2300: lstore 11
    //   2302: aload_0
    //   2303: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   2306: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2309: sipush -316
    //   2312: invokevirtual 906	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2315: lload 15
    //   2317: lstore 13
    //   2319: iload 6
    //   2321: istore_2
    //   2322: iload_1
    //   2323: ifne -1792 -> 531
    //   2326: aload_0
    //   2327: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   2330: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2333: getfield 467	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2336: ldc_w 986
    //   2339: lload 15
    //   2341: invokestatic 1012	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2344: invokeinterface 481 3 0
    //   2349: pop
    //   2350: aload_0
    //   2351: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   2354: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2357: invokevirtual 494	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2360: lload 15
    //   2362: lstore 13
    //   2364: iload 6
    //   2366: istore_2
    //   2367: goto -1836 -> 531
    //   2370: iconst_1
    //   2371: istore_3
    //   2372: goto -777 -> 1595
    //   2375: lload 9
    //   2377: lstore 15
    //   2379: iload_2
    //   2380: istore 5
    //   2382: lload 9
    //   2384: lstore 11
    //   2386: iload_3
    //   2387: aload_0
    //   2388: getfield 156	com/tencent/smtt/sdk/m:x	I
    //   2391: if_icmpne +26 -> 2417
    //   2394: lload 9
    //   2396: lstore 15
    //   2398: iload_2
    //   2399: istore 5
    //   2401: lload 9
    //   2403: lstore 11
    //   2405: aload 29
    //   2407: aload_0
    //   2408: getfield 154	com/tencent/smtt/sdk/m:w	Ljava/lang/String;
    //   2411: invokevirtual 550	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2414: ifne -693 -> 1721
    //   2417: lload 9
    //   2419: lstore 15
    //   2421: iload_2
    //   2422: istore 5
    //   2424: lload 9
    //   2426: lstore 11
    //   2428: aload_0
    //   2429: getfield 108	com/tencent/smtt/sdk/m:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   2432: iconst_0
    //   2433: invokevirtual 676	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setNetworkChange	(I)V
    //   2436: lload 9
    //   2438: lstore 15
    //   2440: iload_2
    //   2441: istore 5
    //   2443: lload 9
    //   2445: lstore 11
    //   2447: aload_0
    //   2448: aload 29
    //   2450: putfield 154	com/tencent/smtt/sdk/m:w	Ljava/lang/String;
    //   2453: lload 9
    //   2455: lstore 15
    //   2457: iload_2
    //   2458: istore 5
    //   2460: lload 9
    //   2462: lstore 11
    //   2464: aload_0
    //   2465: iload_3
    //   2466: putfield 156	com/tencent/smtt/sdk/m:x	I
    //   2469: goto -748 -> 1721
    //   2472: astore 29
    //   2474: lload 11
    //   2476: lstore 9
    //   2478: iload_1
    //   2479: ifne +37 -> 2516
    //   2482: aload_0
    //   2483: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   2486: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2489: getfield 467	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2492: ldc_w 986
    //   2495: lload 9
    //   2497: invokestatic 1012	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2500: invokeinterface 481 3 0
    //   2505: pop
    //   2506: aload_0
    //   2507: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   2510: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2513: invokevirtual 494	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2516: ldc_w 932
    //   2519: invokestatic 150	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2522: aload 29
    //   2524: athrow
    //   2525: iload_3
    //   2526: sipush 200
    //   2529: if_icmpeq +10 -> 2539
    //   2532: iload_3
    //   2533: sipush 206
    //   2536: if_icmpne +2569 -> 5105
    //   2539: lload 9
    //   2541: lstore 15
    //   2543: iload_2
    //   2544: istore 5
    //   2546: lload 9
    //   2548: lstore 11
    //   2550: aload_0
    //   2551: aload_0
    //   2552: getfield 394	com/tencent/smtt/sdk/m:t	Ljava/net/HttpURLConnection;
    //   2555: invokevirtual 1077	java/net/HttpURLConnection:getContentLength	()I
    //   2558: i2l
    //   2559: lload 13
    //   2561: ladd
    //   2562: putfield 631	com/tencent/smtt/sdk/m:l	J
    //   2565: lload 9
    //   2567: lstore 15
    //   2569: iload_2
    //   2570: istore 5
    //   2572: lload 9
    //   2574: lstore 11
    //   2576: ldc 204
    //   2578: new 115	java/lang/StringBuilder
    //   2581: dup
    //   2582: ldc_w 1079
    //   2585: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2588: aload_0
    //   2589: getfield 631	com/tencent/smtt/sdk/m:l	J
    //   2592: invokevirtual 579	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2595: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2598: invokestatic 388	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2601: lload 9
    //   2603: lstore 15
    //   2605: iload_2
    //   2606: istore 5
    //   2608: lload 9
    //   2610: lstore 11
    //   2612: aload_0
    //   2613: getfield 108	com/tencent/smtt/sdk/m:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   2616: aload_0
    //   2617: getfield 631	com/tencent/smtt/sdk/m:l	J
    //   2620: invokevirtual 1082	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setPkgSize	(J)V
    //   2623: lload 9
    //   2625: lstore 15
    //   2627: iload_2
    //   2628: istore 5
    //   2630: lload 9
    //   2632: lstore 11
    //   2634: aload_0
    //   2635: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   2638: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2641: getfield 309	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   2644: ldc_w 566
    //   2647: lconst_0
    //   2648: invokeinterface 570 4 0
    //   2653: lstore 17
    //   2655: lload 17
    //   2657: lconst_0
    //   2658: lcmp
    //   2659: ifeq +390 -> 3049
    //   2662: lload 9
    //   2664: lstore 15
    //   2666: iload_2
    //   2667: istore 5
    //   2669: lload 9
    //   2671: lstore 11
    //   2673: aload_0
    //   2674: getfield 631	com/tencent/smtt/sdk/m:l	J
    //   2677: lload 17
    //   2679: lcmp
    //   2680: ifeq +369 -> 3049
    //   2683: lload 9
    //   2685: lstore 15
    //   2687: iload_2
    //   2688: istore 5
    //   2690: lload 9
    //   2692: lstore 11
    //   2694: ldc 204
    //   2696: new 115	java/lang/StringBuilder
    //   2699: dup
    //   2700: ldc_w 1084
    //   2703: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2706: lload 17
    //   2708: invokevirtual 579	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2711: ldc_w 1086
    //   2714: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2717: aload_0
    //   2718: getfield 631	com/tencent/smtt/sdk/m:l	J
    //   2721: invokevirtual 579	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2724: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2727: iconst_1
    //   2728: invokestatic 958	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   2731: iload_1
    //   2732: ifne +269 -> 3001
    //   2735: lload 9
    //   2737: lstore 15
    //   2739: iload_2
    //   2740: istore 5
    //   2742: lload 9
    //   2744: lstore 11
    //   2746: aload_0
    //   2747: invokespecial 437	com/tencent/smtt/sdk/m:m	()Z
    //   2750: ifne +41 -> 2791
    //   2753: lload 9
    //   2755: lstore 15
    //   2757: iload_2
    //   2758: istore 5
    //   2760: lload 9
    //   2762: lstore 11
    //   2764: invokestatic 890	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   2767: ifeq +234 -> 3001
    //   2770: lload 9
    //   2772: lstore 15
    //   2774: iload_2
    //   2775: istore 5
    //   2777: lload 9
    //   2779: lstore 11
    //   2781: aload_0
    //   2782: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   2785: invokestatic 682	com/tencent/smtt/utils/Apn:isNetworkAvailable	(Landroid/content/Context;)Z
    //   2788: ifeq +213 -> 3001
    //   2791: lload 9
    //   2793: lstore 15
    //   2795: iload_2
    //   2796: istore 5
    //   2798: lload 9
    //   2800: lstore 11
    //   2802: aload_0
    //   2803: getfield 86	com/tencent/smtt/sdk/m:b	[Ljava/lang/String;
    //   2806: ifnull +75 -> 2881
    //   2809: lload 9
    //   2811: lstore 15
    //   2813: iload_2
    //   2814: istore 5
    //   2816: lload 9
    //   2818: lstore 11
    //   2820: aload_0
    //   2821: iconst_0
    //   2822: invokevirtual 1070	com/tencent/smtt/sdk/m:a	(Z)Z
    //   2825: istore 6
    //   2827: iload 6
    //   2829: ifeq +52 -> 2881
    //   2832: lload 9
    //   2834: lstore 13
    //   2836: iload_1
    //   2837: ifne -2306 -> 531
    //   2840: aload_0
    //   2841: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   2844: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2847: getfield 467	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2850: ldc_w 986
    //   2853: lload 9
    //   2855: invokestatic 1012	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2858: invokeinterface 481 3 0
    //   2863: pop
    //   2864: aload_0
    //   2865: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   2868: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2871: invokevirtual 494	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2874: lload 9
    //   2876: lstore 13
    //   2878: goto -2347 -> 531
    //   2881: lload 9
    //   2883: lstore 15
    //   2885: iload_2
    //   2886: istore 5
    //   2888: lload 9
    //   2890: lstore 11
    //   2892: aload_0
    //   2893: bipush 113
    //   2895: new 115	java/lang/StringBuilder
    //   2898: dup
    //   2899: ldc_w 1088
    //   2902: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2905: lload 17
    //   2907: invokevirtual 579	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2910: ldc_w 1086
    //   2913: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2916: aload_0
    //   2917: getfield 631	com/tencent/smtt/sdk/m:l	J
    //   2920: invokevirtual 579	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2923: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2926: iconst_1
    //   2927: invokespecial 616	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   2930: lload 9
    //   2932: lstore 15
    //   2934: iload_2
    //   2935: istore 5
    //   2937: lload 9
    //   2939: lstore 11
    //   2941: aload_0
    //   2942: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   2945: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2948: sipush -310
    //   2951: invokevirtual 906	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2954: iload_2
    //   2955: istore 5
    //   2957: iload_1
    //   2958: ifne -2380 -> 578
    //   2961: aload_0
    //   2962: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   2965: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2968: getfield 467	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2971: ldc_w 986
    //   2974: lload 9
    //   2976: invokestatic 1012	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2979: invokeinterface 481 3 0
    //   2984: pop
    //   2985: aload_0
    //   2986: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   2989: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2992: invokevirtual 494	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2995: iload_2
    //   2996: istore 5
    //   2998: goto -2420 -> 578
    //   3001: lload 9
    //   3003: lstore 15
    //   3005: iload_2
    //   3006: istore 5
    //   3008: lload 9
    //   3010: lstore 11
    //   3012: aload_0
    //   3013: bipush 101
    //   3015: ldc_w 1090
    //   3018: iconst_1
    //   3019: invokespecial 616	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   3022: lload 9
    //   3024: lstore 15
    //   3026: iload_2
    //   3027: istore 5
    //   3029: lload 9
    //   3031: lstore 11
    //   3033: aload_0
    //   3034: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   3037: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3040: sipush -304
    //   3043: invokevirtual 906	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3046: goto -92 -> 2954
    //   3049: aconst_null
    //   3050: astore 33
    //   3052: aconst_null
    //   3053: astore 29
    //   3055: aconst_null
    //   3056: astore 31
    //   3058: lload 9
    //   3060: lstore 15
    //   3062: iload_2
    //   3063: istore 5
    //   3065: lload 9
    //   3067: lstore 11
    //   3069: ldc 204
    //   3071: ldc_w 1092
    //   3074: invokestatic 388	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3077: aload_0
    //   3078: getfield 394	com/tencent/smtt/sdk/m:t	Ljava/net/HttpURLConnection;
    //   3081: invokevirtual 779	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   3084: astore 30
    //   3086: aload 30
    //   3088: ifnull +1514 -> 4602
    //   3091: aload_0
    //   3092: getfield 394	com/tencent/smtt/sdk/m:t	Ljava/net/HttpURLConnection;
    //   3095: invokevirtual 1095	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   3098: astore 29
    //   3100: aload 29
    //   3102: ifnull +277 -> 3379
    //   3105: aload 29
    //   3107: ldc_w 1097
    //   3110: invokevirtual 332	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3113: ifeq +266 -> 3379
    //   3116: new 1099	java/util/zip/GZIPInputStream
    //   3119: dup
    //   3120: aload 30
    //   3122: invokespecial 1100	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   3125: astore 29
    //   3127: sipush 8192
    //   3130: newarray byte
    //   3132: astore 31
    //   3134: new 1102	java/io/FileOutputStream
    //   3137: dup
    //   3138: new 186	java/io/File
    //   3141: dup
    //   3142: aload_0
    //   3143: getfield 143	com/tencent/smtt/sdk/m:k	Ljava/io/File;
    //   3146: ldc_w 458
    //   3149: invokespecial 228	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   3152: iconst_1
    //   3153: invokespecial 1105	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   3156: astore 32
    //   3158: lload 9
    //   3160: lstore 11
    //   3162: lload 9
    //   3164: lstore 17
    //   3166: invokestatic 164	java/lang/System:currentTimeMillis	()J
    //   3169: lstore 15
    //   3171: iconst_0
    //   3172: istore_3
    //   3173: lload 13
    //   3175: lstore 21
    //   3177: iload_2
    //   3178: istore 5
    //   3180: lload 9
    //   3182: lstore 17
    //   3184: iload_2
    //   3185: istore 7
    //   3187: lload 9
    //   3189: lstore 19
    //   3191: aload_0
    //   3192: getfield 637	com/tencent/smtt/sdk/m:r	Z
    //   3195: ifeq +396 -> 3591
    //   3198: iload_2
    //   3199: istore 5
    //   3201: lload 9
    //   3203: lstore 17
    //   3205: iload_2
    //   3206: istore 7
    //   3208: lload 9
    //   3210: lstore 19
    //   3212: ldc 204
    //   3214: ldc_w 1107
    //   3217: iconst_1
    //   3218: invokestatic 958	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   3221: iload_2
    //   3222: istore 5
    //   3224: lload 9
    //   3226: lstore 17
    //   3228: iload_2
    //   3229: istore 7
    //   3231: lload 9
    //   3233: lstore 19
    //   3235: aload_0
    //   3236: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   3239: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3242: sipush -309
    //   3245: invokevirtual 906	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3248: iload_2
    //   3249: istore 6
    //   3251: lload 9
    //   3253: lstore 13
    //   3255: iload 6
    //   3257: istore_2
    //   3258: aload 29
    //   3260: astore 33
    //   3262: aload 32
    //   3264: astore 31
    //   3266: iload_3
    //   3267: ifeq +1345 -> 4612
    //   3270: lload 9
    //   3272: lstore 15
    //   3274: iload 6
    //   3276: istore 5
    //   3278: lload 9
    //   3280: lstore 11
    //   3282: aload_0
    //   3283: aload 32
    //   3285: invokespecial 759	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   3288: lload 9
    //   3290: lstore 15
    //   3292: iload 6
    //   3294: istore 5
    //   3296: lload 9
    //   3298: lstore 11
    //   3300: aload_0
    //   3301: aload 29
    //   3303: invokespecial 759	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   3306: lload 9
    //   3308: lstore 15
    //   3310: iload 6
    //   3312: istore 5
    //   3314: lload 9
    //   3316: lstore 11
    //   3318: aload_0
    //   3319: aload 30
    //   3321: invokespecial 759	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   3324: lload 9
    //   3326: lstore 13
    //   3328: iload 6
    //   3330: istore_2
    //   3331: iload_1
    //   3332: ifne -2801 -> 531
    //   3335: aload_0
    //   3336: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   3339: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3342: getfield 467	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   3345: ldc_w 986
    //   3348: lload 9
    //   3350: invokestatic 1012	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3353: invokeinterface 481 3 0
    //   3358: pop
    //   3359: aload_0
    //   3360: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   3363: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3366: invokevirtual 494	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   3369: lload 9
    //   3371: lstore 13
    //   3373: iload 6
    //   3375: istore_2
    //   3376: goto -2845 -> 531
    //   3379: aload 29
    //   3381: ifnull +203 -> 3584
    //   3384: aload 29
    //   3386: ldc_w 1109
    //   3389: invokevirtual 332	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3392: ifeq +192 -> 3584
    //   3395: new 1111	java/util/zip/InflaterInputStream
    //   3398: dup
    //   3399: aload 30
    //   3401: new 1113	java/util/zip/Inflater
    //   3404: dup
    //   3405: iconst_1
    //   3406: invokespecial 1115	java/util/zip/Inflater:<init>	(Z)V
    //   3409: invokespecial 1118	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Inflater;)V
    //   3412: astore 29
    //   3414: goto -287 -> 3127
    //   3417: astore 34
    //   3419: aload 30
    //   3421: astore 29
    //   3423: aload 33
    //   3425: astore 32
    //   3427: aload 34
    //   3429: astore 30
    //   3431: iload_2
    //   3432: istore 6
    //   3434: aload 30
    //   3436: instanceof 1120
    //   3439: ifne +11 -> 3450
    //   3442: aload 30
    //   3444: instanceof 1122
    //   3447: ifeq +1305 -> 4752
    //   3450: aload_0
    //   3451: ldc_w 1123
    //   3454: putfield 80	com/tencent/smtt/sdk/m:m	I
    //   3457: aload_0
    //   3458: lconst_0
    //   3459: invokespecial 1125	com/tencent/smtt/sdk/m:a	(J)V
    //   3462: aload_0
    //   3463: bipush 103
    //   3465: aload_0
    //   3466: aload 30
    //   3468: invokespecial 614	com/tencent/smtt/sdk/m:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3471: iconst_0
    //   3472: invokespecial 616	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   3475: lload 9
    //   3477: lstore 15
    //   3479: iload 6
    //   3481: istore 5
    //   3483: lload 9
    //   3485: lstore 11
    //   3487: aload_0
    //   3488: aload 32
    //   3490: invokespecial 759	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   3493: lload 9
    //   3495: lstore 15
    //   3497: iload 6
    //   3499: istore 5
    //   3501: lload 9
    //   3503: lstore 11
    //   3505: aload_0
    //   3506: aload 31
    //   3508: invokespecial 759	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   3511: lload 9
    //   3513: lstore 15
    //   3515: iload 6
    //   3517: istore 5
    //   3519: lload 9
    //   3521: lstore 11
    //   3523: aload_0
    //   3524: aload 29
    //   3526: invokespecial 759	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   3529: lload 9
    //   3531: lstore 13
    //   3533: iload 6
    //   3535: istore_2
    //   3536: iload_1
    //   3537: ifne -3006 -> 531
    //   3540: aload_0
    //   3541: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   3544: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3547: getfield 467	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   3550: ldc_w 986
    //   3553: lload 9
    //   3555: invokestatic 1012	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3558: invokeinterface 481 3 0
    //   3563: pop
    //   3564: aload_0
    //   3565: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   3568: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3571: invokevirtual 494	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   3574: lload 9
    //   3576: lstore 13
    //   3578: iload 6
    //   3580: istore_2
    //   3581: goto -3050 -> 531
    //   3584: aload 30
    //   3586: astore 29
    //   3588: goto -461 -> 3127
    //   3591: iload_2
    //   3592: istore 5
    //   3594: lload 9
    //   3596: lstore 17
    //   3598: iload_2
    //   3599: istore 7
    //   3601: lload 9
    //   3603: lstore 19
    //   3605: aload 29
    //   3607: aload 31
    //   3609: iconst_0
    //   3610: sipush 8192
    //   3613: invokevirtual 1131	java/io/InputStream:read	([BII)I
    //   3616: istore 4
    //   3618: iload 4
    //   3620: ifgt +185 -> 3805
    //   3623: iload_2
    //   3624: istore 5
    //   3626: lload 9
    //   3628: lstore 17
    //   3630: iload_2
    //   3631: istore 7
    //   3633: lload 9
    //   3635: lstore 19
    //   3637: aload_0
    //   3638: getfield 86	com/tencent/smtt/sdk/m:b	[Ljava/lang/String;
    //   3641: ifnull +86 -> 3727
    //   3644: iload_2
    //   3645: istore 5
    //   3647: lload 9
    //   3649: lstore 17
    //   3651: iload_2
    //   3652: istore 7
    //   3654: lload 9
    //   3656: lstore 19
    //   3658: aload_0
    //   3659: iconst_1
    //   3660: iload 8
    //   3662: invokespecial 914	com/tencent/smtt/sdk/m:c	(ZZ)Z
    //   3665: ifne +62 -> 3727
    //   3668: iload_1
    //   3669: ifne +33 -> 3702
    //   3672: iload_2
    //   3673: istore 5
    //   3675: lload 9
    //   3677: lstore 17
    //   3679: iload_2
    //   3680: istore 7
    //   3682: lload 9
    //   3684: lstore 19
    //   3686: aload_0
    //   3687: iconst_0
    //   3688: invokevirtual 1070	com/tencent/smtt/sdk/m:a	(Z)Z
    //   3691: ifeq +11 -> 3702
    //   3694: iconst_1
    //   3695: istore_3
    //   3696: iload_2
    //   3697: istore 6
    //   3699: goto -448 -> 3251
    //   3702: iload_2
    //   3703: istore 5
    //   3705: lload 9
    //   3707: lstore 17
    //   3709: iload_2
    //   3710: istore 7
    //   3712: lload 9
    //   3714: lstore 19
    //   3716: aload_0
    //   3717: iconst_1
    //   3718: putfield 639	com/tencent/smtt/sdk/m:s	Z
    //   3721: iconst_0
    //   3722: istore 6
    //   3724: goto -473 -> 3251
    //   3727: iload_2
    //   3728: istore 5
    //   3730: lload 9
    //   3732: lstore 17
    //   3734: iload_2
    //   3735: istore 7
    //   3737: lload 9
    //   3739: lstore 19
    //   3741: aload_0
    //   3742: iconst_1
    //   3743: putfield 639	com/tencent/smtt/sdk/m:s	Z
    //   3746: iload_2
    //   3747: istore 6
    //   3749: iload_2
    //   3750: istore 5
    //   3752: lload 9
    //   3754: lstore 17
    //   3756: iload_2
    //   3757: istore 7
    //   3759: lload 9
    //   3761: lstore 19
    //   3763: aload_0
    //   3764: getfield 86	com/tencent/smtt/sdk/m:b	[Ljava/lang/String;
    //   3767: ifnull +6 -> 3773
    //   3770: iconst_1
    //   3771: istore 6
    //   3773: iload 6
    //   3775: istore 5
    //   3777: lload 9
    //   3779: lstore 17
    //   3781: iload 6
    //   3783: istore 7
    //   3785: lload 9
    //   3787: lstore 19
    //   3789: aload_0
    //   3790: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   3793: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3796: sipush -311
    //   3799: invokevirtual 906	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3802: goto -551 -> 3251
    //   3805: iload_2
    //   3806: istore 5
    //   3808: lload 9
    //   3810: lstore 17
    //   3812: iload_2
    //   3813: istore 7
    //   3815: lload 9
    //   3817: lstore 19
    //   3819: aload 32
    //   3821: aload 31
    //   3823: iconst_0
    //   3824: iload 4
    //   3826: invokevirtual 1135	java/io/FileOutputStream:write	([BII)V
    //   3829: iload_2
    //   3830: istore 5
    //   3832: lload 9
    //   3834: lstore 17
    //   3836: iload_2
    //   3837: istore 7
    //   3839: lload 9
    //   3841: lstore 19
    //   3843: aload 32
    //   3845: invokevirtual 1138	java/io/FileOutputStream:flush	()V
    //   3848: lload 9
    //   3850: lstore 11
    //   3852: iload_1
    //   3853: ifne +271 -> 4124
    //   3856: iload 4
    //   3858: i2l
    //   3859: lload 9
    //   3861: ladd
    //   3862: lstore 9
    //   3864: lload 9
    //   3866: lload 27
    //   3868: lcmp
    //   3869: iflt +91 -> 3960
    //   3872: lload 9
    //   3874: lstore 11
    //   3876: lload 9
    //   3878: lstore 17
    //   3880: ldc 204
    //   3882: ldc_w 1023
    //   3885: iconst_1
    //   3886: invokestatic 958	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   3889: lload 9
    //   3891: lstore 11
    //   3893: lload 9
    //   3895: lstore 17
    //   3897: aload_0
    //   3898: bipush 112
    //   3900: new 115	java/lang/StringBuilder
    //   3903: dup
    //   3904: ldc_w 1140
    //   3907: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3910: lload 9
    //   3912: invokevirtual 579	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3915: ldc_w 1142
    //   3918: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3921: lload 27
    //   3923: invokevirtual 579	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3926: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3929: iconst_1
    //   3930: invokespecial 616	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   3933: lload 9
    //   3935: lstore 11
    //   3937: lload 9
    //   3939: lstore 17
    //   3941: aload_0
    //   3942: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   3945: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3948: sipush -307
    //   3951: invokevirtual 906	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3954: iload_2
    //   3955: istore 6
    //   3957: goto -706 -> 3251
    //   3960: lload 9
    //   3962: lstore 11
    //   3964: lload 9
    //   3966: lstore 17
    //   3968: aload_0
    //   3969: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   3972: invokestatic 1014	com/tencent/smtt/utils/f:b	(Landroid/content/Context;)Z
    //   3975: ifne +145 -> 4120
    //   3978: lload 9
    //   3980: lstore 11
    //   3982: lload 9
    //   3984: lstore 17
    //   3986: ldc 204
    //   3988: ldc_w 1144
    //   3991: iconst_1
    //   3992: invokestatic 958	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   3995: lload 9
    //   3997: lstore 11
    //   3999: lload 9
    //   4001: lstore 17
    //   4003: aload_0
    //   4004: bipush 105
    //   4006: new 115	java/lang/StringBuilder
    //   4009: dup
    //   4010: ldc_w 1146
    //   4013: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4016: invokestatic 1148	com/tencent/smtt/utils/q:a	()J
    //   4019: invokevirtual 579	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4022: ldc_w 1150
    //   4025: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4028: aload_0
    //   4029: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   4032: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4035: invokevirtual 1153	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   4038: invokevirtual 579	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4041: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4044: iconst_1
    //   4045: invokespecial 616	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   4048: lload 9
    //   4050: lstore 11
    //   4052: lload 9
    //   4054: lstore 17
    //   4056: aload_0
    //   4057: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   4060: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4063: sipush -308
    //   4066: invokevirtual 906	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4069: iload_2
    //   4070: istore 6
    //   4072: goto -821 -> 3251
    //   4075: astore 31
    //   4077: lload 11
    //   4079: lstore 9
    //   4081: aload_0
    //   4082: aload 32
    //   4084: invokespecial 759	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   4087: aload_0
    //   4088: aload 29
    //   4090: invokespecial 759	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   4093: aload_0
    //   4094: aload 30
    //   4096: invokespecial 759	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   4099: ldc_w 932
    //   4102: invokestatic 150	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4105: aload 31
    //   4107: athrow
    //   4108: astore 29
    //   4110: lload 9
    //   4112: lstore 15
    //   4114: iload_2
    //   4115: istore 6
    //   4117: goto -1913 -> 2204
    //   4120: lload 9
    //   4122: lstore 11
    //   4124: iload 4
    //   4126: i2l
    //   4127: lstore 9
    //   4129: iload_2
    //   4130: istore 5
    //   4132: lload 11
    //   4134: lstore 17
    //   4136: iload_2
    //   4137: istore 7
    //   4139: lload 11
    //   4141: lstore 19
    //   4143: aload_0
    //   4144: lload 23
    //   4146: lload 9
    //   4148: invokespecial 1155	com/tencent/smtt/sdk/m:a	(JJ)J
    //   4151: lstore 23
    //   4153: iload_2
    //   4154: istore 5
    //   4156: lload 11
    //   4158: lstore 17
    //   4160: iload_2
    //   4161: istore 7
    //   4163: lload 11
    //   4165: lstore 19
    //   4167: invokestatic 164	java/lang/System:currentTimeMillis	()J
    //   4170: lstore 25
    //   4172: lload 21
    //   4174: iload 4
    //   4176: i2l
    //   4177: ladd
    //   4178: lstore 21
    //   4180: lload 25
    //   4182: lload 15
    //   4184: lsub
    //   4185: ldc2_w 1156
    //   4188: lcmp
    //   4189: ifle +2445 -> 6634
    //   4192: iload_2
    //   4193: istore 5
    //   4195: lload 11
    //   4197: lstore 17
    //   4199: iload_2
    //   4200: istore 7
    //   4202: lload 11
    //   4204: lstore 19
    //   4206: ldc 204
    //   4208: new 115	java/lang/StringBuilder
    //   4211: dup
    //   4212: ldc_w 1159
    //   4215: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4218: lload 21
    //   4220: invokevirtual 579	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4223: ldc_w 1066
    //   4226: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4229: aload_0
    //   4230: getfield 631	com/tencent/smtt/sdk/m:l	J
    //   4233: invokevirtual 579	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4236: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4239: iconst_1
    //   4240: invokestatic 958	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   4243: iload_2
    //   4244: istore 5
    //   4246: lload 11
    //   4248: lstore 17
    //   4250: iload_2
    //   4251: istore 7
    //   4253: lload 11
    //   4255: lstore 19
    //   4257: getstatic 499	com/tencent/smtt/sdk/QbSdk:l	Lcom/tencent/smtt/sdk/TbsListener;
    //   4260: ifnull +88 -> 4348
    //   4263: iload_2
    //   4264: istore 5
    //   4266: lload 11
    //   4268: lstore 17
    //   4270: iload_2
    //   4271: istore 7
    //   4273: lload 11
    //   4275: lstore 19
    //   4277: lload 21
    //   4279: l2d
    //   4280: aload_0
    //   4281: getfield 631	com/tencent/smtt/sdk/m:l	J
    //   4284: l2d
    //   4285: ddiv
    //   4286: ldc2_w 1160
    //   4289: dmul
    //   4290: d2i
    //   4291: istore 4
    //   4293: iload_2
    //   4294: istore 5
    //   4296: lload 11
    //   4298: lstore 17
    //   4300: iload_2
    //   4301: istore 7
    //   4303: lload 11
    //   4305: lstore 19
    //   4307: ldc_w 382
    //   4310: ldc_w 1163
    //   4313: iload 4
    //   4315: invokestatic 787	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   4318: invokevirtual 537	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   4321: invokestatic 1165	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   4324: iload_2
    //   4325: istore 5
    //   4327: lload 11
    //   4329: lstore 17
    //   4331: iload_2
    //   4332: istore 7
    //   4334: lload 11
    //   4336: lstore 19
    //   4338: getstatic 499	com/tencent/smtt/sdk/QbSdk:l	Lcom/tencent/smtt/sdk/TbsListener;
    //   4341: iload 4
    //   4343: invokeinterface 1168 2 0
    //   4348: iload_1
    //   4349: ifne +2274 -> 6623
    //   4352: lload 21
    //   4354: lload 13
    //   4356: lsub
    //   4357: ldc2_w 1169
    //   4360: lcmp
    //   4361: ifle +2262 -> 6623
    //   4364: iload_2
    //   4365: istore 5
    //   4367: lload 11
    //   4369: lstore 17
    //   4371: iload_2
    //   4372: istore 7
    //   4374: lload 11
    //   4376: lstore 19
    //   4378: aload_0
    //   4379: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   4382: invokestatic 223	com/tencent/smtt/sdk/TbsDownloader:getOverSea	(Landroid/content/Context;)Z
    //   4385: ifne +194 -> 4579
    //   4388: iload_2
    //   4389: istore 5
    //   4391: lload 11
    //   4393: lstore 17
    //   4395: iload_2
    //   4396: istore 7
    //   4398: lload 11
    //   4400: lstore 19
    //   4402: aload_0
    //   4403: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   4406: invokestatic 667	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   4409: iconst_3
    //   4410: if_icmpne +27 -> 4437
    //   4413: iload_2
    //   4414: istore 5
    //   4416: lload 11
    //   4418: lstore 17
    //   4420: iload_2
    //   4421: istore 7
    //   4423: lload 11
    //   4425: lstore 19
    //   4427: aload_0
    //   4428: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   4431: invokestatic 667	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   4434: ifne +145 -> 4579
    //   4437: iload_2
    //   4438: istore 5
    //   4440: lload 11
    //   4442: lstore 17
    //   4444: iload_2
    //   4445: istore 7
    //   4447: lload 11
    //   4449: lstore 19
    //   4451: invokestatic 890	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   4454: ifne +125 -> 4579
    //   4457: iload_2
    //   4458: istore 5
    //   4460: lload 11
    //   4462: lstore 17
    //   4464: iload_2
    //   4465: istore 7
    //   4467: lload 11
    //   4469: lstore 19
    //   4471: aload_0
    //   4472: invokevirtual 1060	com/tencent/smtt/sdk/m:b	()V
    //   4475: iload_2
    //   4476: istore 5
    //   4478: lload 11
    //   4480: lstore 17
    //   4482: iload_2
    //   4483: istore 7
    //   4485: lload 11
    //   4487: lstore 19
    //   4489: getstatic 499	com/tencent/smtt/sdk/QbSdk:l	Lcom/tencent/smtt/sdk/TbsListener;
    //   4492: ifnull +27 -> 4519
    //   4495: iload_2
    //   4496: istore 5
    //   4498: lload 11
    //   4500: lstore 17
    //   4502: iload_2
    //   4503: istore 7
    //   4505: lload 11
    //   4507: lstore 19
    //   4509: getstatic 499	com/tencent/smtt/sdk/QbSdk:l	Lcom/tencent/smtt/sdk/TbsListener;
    //   4512: bipush 111
    //   4514: invokeinterface 504 2 0
    //   4519: iload_2
    //   4520: istore 5
    //   4522: lload 11
    //   4524: lstore 17
    //   4526: iload_2
    //   4527: istore 7
    //   4529: lload 11
    //   4531: lstore 19
    //   4533: ldc 204
    //   4535: ldc_w 1172
    //   4538: iconst_0
    //   4539: invokestatic 958	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   4542: iload_2
    //   4543: istore 5
    //   4545: lload 11
    //   4547: lstore 17
    //   4549: iload_2
    //   4550: istore 7
    //   4552: lload 11
    //   4554: lstore 19
    //   4556: aload_0
    //   4557: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   4560: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4563: sipush -304
    //   4566: invokevirtual 906	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4569: lload 11
    //   4571: lstore 9
    //   4573: iload_2
    //   4574: istore 6
    //   4576: goto -1325 -> 3251
    //   4579: lload 21
    //   4581: lstore 9
    //   4583: lload 25
    //   4585: lstore 13
    //   4587: lload 13
    //   4589: lstore 15
    //   4591: lload 9
    //   4593: lstore 13
    //   4595: lload 11
    //   4597: lstore 9
    //   4599: goto -1422 -> 3177
    //   4602: aconst_null
    //   4603: astore 33
    //   4605: aconst_null
    //   4606: astore 31
    //   4608: lload 9
    //   4610: lstore 13
    //   4612: lload 13
    //   4614: lstore 15
    //   4616: iload_2
    //   4617: istore 5
    //   4619: lload 13
    //   4621: lstore 11
    //   4623: aload_0
    //   4624: aload 31
    //   4626: invokespecial 759	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   4629: lload 13
    //   4631: lstore 15
    //   4633: iload_2
    //   4634: istore 5
    //   4636: lload 13
    //   4638: lstore 11
    //   4640: aload_0
    //   4641: aload 33
    //   4643: invokespecial 759	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   4646: lload 13
    //   4648: lstore 15
    //   4650: iload_2
    //   4651: istore 5
    //   4653: lload 13
    //   4655: lstore 11
    //   4657: aload_0
    //   4658: aload 30
    //   4660: invokespecial 759	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   4663: lload 13
    //   4665: lstore 15
    //   4667: iload_2
    //   4668: istore 5
    //   4670: lload 13
    //   4672: lstore 11
    //   4674: aload_0
    //   4675: getfield 639	com/tencent/smtt/sdk/m:s	Z
    //   4678: ifne +27 -> 4705
    //   4681: lload 13
    //   4683: lstore 15
    //   4685: iload_2
    //   4686: istore 5
    //   4688: lload 13
    //   4690: lstore 11
    //   4692: aload_0
    //   4693: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   4696: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4699: sipush -319
    //   4702: invokevirtual 906	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4705: iload_2
    //   4706: istore 5
    //   4708: iload_1
    //   4709: ifne -4131 -> 578
    //   4712: aload_0
    //   4713: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   4716: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4719: getfield 467	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   4722: ldc_w 986
    //   4725: lload 13
    //   4727: invokestatic 1012	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4730: invokeinterface 481 3 0
    //   4735: pop
    //   4736: aload_0
    //   4737: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   4740: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4743: invokevirtual 494	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   4746: iload_2
    //   4747: istore 5
    //   4749: goto -4171 -> 578
    //   4752: iload_1
    //   4753: ifne +174 -> 4927
    //   4756: aload_0
    //   4757: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   4760: invokestatic 1014	com/tencent/smtt/utils/f:b	(Landroid/content/Context;)Z
    //   4763: ifne +164 -> 4927
    //   4766: aload_0
    //   4767: bipush 105
    //   4769: new 115	java/lang/StringBuilder
    //   4772: dup
    //   4773: ldc_w 1146
    //   4776: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4779: invokestatic 1148	com/tencent/smtt/utils/q:a	()J
    //   4782: invokevirtual 579	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4785: ldc_w 1150
    //   4788: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4791: aload_0
    //   4792: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   4795: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4798: invokevirtual 1153	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   4801: invokevirtual 579	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4804: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4807: iconst_1
    //   4808: invokespecial 616	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   4811: aload_0
    //   4812: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   4815: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4818: sipush -308
    //   4821: invokevirtual 906	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4824: lload 9
    //   4826: lstore 15
    //   4828: iload 6
    //   4830: istore 5
    //   4832: lload 9
    //   4834: lstore 11
    //   4836: aload_0
    //   4837: aload 32
    //   4839: invokespecial 759	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   4842: lload 9
    //   4844: lstore 15
    //   4846: iload 6
    //   4848: istore 5
    //   4850: lload 9
    //   4852: lstore 11
    //   4854: aload_0
    //   4855: aload 31
    //   4857: invokespecial 759	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   4860: lload 9
    //   4862: lstore 15
    //   4864: iload 6
    //   4866: istore 5
    //   4868: lload 9
    //   4870: lstore 11
    //   4872: aload_0
    //   4873: aload 29
    //   4875: invokespecial 759	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   4878: iload 6
    //   4880: istore 5
    //   4882: iload_1
    //   4883: ifne -4305 -> 578
    //   4886: aload_0
    //   4887: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   4890: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4893: getfield 467	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   4896: ldc_w 986
    //   4899: lload 9
    //   4901: invokestatic 1012	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4904: invokeinterface 481 3 0
    //   4909: pop
    //   4910: aload_0
    //   4911: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   4914: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4917: invokevirtual 494	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   4920: iload 6
    //   4922: istore 5
    //   4924: goto -4346 -> 578
    //   4927: aload_0
    //   4928: lconst_0
    //   4929: invokespecial 1125	com/tencent/smtt/sdk/m:a	(J)V
    //   4932: aload_0
    //   4933: invokespecial 1174	com/tencent/smtt/sdk/m:i	()Z
    //   4936: ifne +125 -> 5061
    //   4939: aload_0
    //   4940: bipush 106
    //   4942: aload_0
    //   4943: aload 30
    //   4945: invokespecial 614	com/tencent/smtt/sdk/m:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   4948: iconst_0
    //   4949: invokespecial 616	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   4952: lload 9
    //   4954: lstore 15
    //   4956: iload 6
    //   4958: istore 5
    //   4960: lload 9
    //   4962: lstore 11
    //   4964: aload_0
    //   4965: aload 32
    //   4967: invokespecial 759	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   4970: lload 9
    //   4972: lstore 15
    //   4974: iload 6
    //   4976: istore 5
    //   4978: lload 9
    //   4980: lstore 11
    //   4982: aload_0
    //   4983: aload 31
    //   4985: invokespecial 759	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   4988: lload 9
    //   4990: lstore 15
    //   4992: iload 6
    //   4994: istore 5
    //   4996: lload 9
    //   4998: lstore 11
    //   5000: aload_0
    //   5001: aload 29
    //   5003: invokespecial 759	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   5006: lload 9
    //   5008: lstore 13
    //   5010: iload 6
    //   5012: istore_2
    //   5013: iload_1
    //   5014: ifne -4483 -> 531
    //   5017: aload_0
    //   5018: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5021: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5024: getfield 467	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5027: ldc_w 986
    //   5030: lload 9
    //   5032: invokestatic 1012	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5035: invokeinterface 481 3 0
    //   5040: pop
    //   5041: aload_0
    //   5042: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5045: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5048: invokevirtual 494	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5051: lload 9
    //   5053: lstore 13
    //   5055: iload 6
    //   5057: istore_2
    //   5058: goto -4527 -> 531
    //   5061: aload_0
    //   5062: bipush 104
    //   5064: aload_0
    //   5065: aload 30
    //   5067: invokespecial 614	com/tencent/smtt/sdk/m:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   5070: iconst_0
    //   5071: invokespecial 616	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   5074: goto -122 -> 4952
    //   5077: astore 34
    //   5079: aload 31
    //   5081: astore 30
    //   5083: aload 29
    //   5085: astore 33
    //   5087: iload 6
    //   5089: istore_2
    //   5090: aload 34
    //   5092: astore 31
    //   5094: aload 30
    //   5096: astore 29
    //   5098: aload 33
    //   5100: astore 30
    //   5102: goto -1021 -> 4081
    //   5105: iload_3
    //   5106: sipush 300
    //   5109: if_icmplt +229 -> 5338
    //   5112: iload_3
    //   5113: sipush 307
    //   5116: if_icmpgt +222 -> 5338
    //   5119: lload 9
    //   5121: lstore 15
    //   5123: iload_2
    //   5124: istore 5
    //   5126: lload 9
    //   5128: lstore 11
    //   5130: aload_0
    //   5131: getfield 394	com/tencent/smtt/sdk/m:t	Ljava/net/HttpURLConnection;
    //   5134: ldc_w 1176
    //   5137: invokevirtual 1179	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   5140: astore 29
    //   5142: lload 9
    //   5144: lstore 15
    //   5146: iload_2
    //   5147: istore 5
    //   5149: lload 9
    //   5151: lstore 11
    //   5153: aload 29
    //   5155: invokestatic 792	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5158: ifne +90 -> 5248
    //   5161: lload 9
    //   5163: lstore 15
    //   5165: iload_2
    //   5166: istore 5
    //   5168: lload 9
    //   5170: lstore 11
    //   5172: aload_0
    //   5173: aload 29
    //   5175: putfield 633	com/tencent/smtt/sdk/m:j	Ljava/lang/String;
    //   5178: lload 9
    //   5180: lstore 15
    //   5182: iload_2
    //   5183: istore 5
    //   5185: lload 9
    //   5187: lstore 11
    //   5189: aload_0
    //   5190: aload_0
    //   5191: getfield 627	com/tencent/smtt/sdk/m:q	I
    //   5194: iconst_1
    //   5195: iadd
    //   5196: putfield 627	com/tencent/smtt/sdk/m:q	I
    //   5199: lload 9
    //   5201: lstore 13
    //   5203: iload_1
    //   5204: ifne -4673 -> 531
    //   5207: aload_0
    //   5208: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5211: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5214: getfield 467	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5217: ldc_w 986
    //   5220: lload 9
    //   5222: invokestatic 1012	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5225: invokeinterface 481 3 0
    //   5230: pop
    //   5231: aload_0
    //   5232: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5235: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5238: invokevirtual 494	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5241: lload 9
    //   5243: lstore 13
    //   5245: goto -4714 -> 531
    //   5248: lload 9
    //   5250: lstore 15
    //   5252: iload_2
    //   5253: istore 5
    //   5255: lload 9
    //   5257: lstore 11
    //   5259: aload_0
    //   5260: bipush 124
    //   5262: aconst_null
    //   5263: iconst_1
    //   5264: invokespecial 616	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   5267: lload 9
    //   5269: lstore 15
    //   5271: iload_2
    //   5272: istore 5
    //   5274: lload 9
    //   5276: lstore 11
    //   5278: aload_0
    //   5279: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5282: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5285: sipush -312
    //   5288: invokevirtual 906	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5291: iload_2
    //   5292: istore 5
    //   5294: iload_1
    //   5295: ifne -4717 -> 578
    //   5298: aload_0
    //   5299: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5302: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5305: getfield 467	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5308: ldc_w 986
    //   5311: lload 9
    //   5313: invokestatic 1012	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5316: invokeinterface 481 3 0
    //   5321: pop
    //   5322: aload_0
    //   5323: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5326: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5329: invokevirtual 494	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5332: iload_2
    //   5333: istore 5
    //   5335: goto -4757 -> 578
    //   5338: lload 9
    //   5340: lstore 15
    //   5342: iload_2
    //   5343: istore 5
    //   5345: lload 9
    //   5347: lstore 11
    //   5349: aload_0
    //   5350: bipush 102
    //   5352: iload_3
    //   5353: invokestatic 787	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   5356: iconst_0
    //   5357: invokespecial 616	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   5360: iload_3
    //   5361: sipush 416
    //   5364: if_icmpne +185 -> 5549
    //   5367: lload 9
    //   5369: lstore 15
    //   5371: iload_2
    //   5372: istore 5
    //   5374: lload 9
    //   5376: lstore 11
    //   5378: aload_0
    //   5379: iconst_1
    //   5380: iload 8
    //   5382: invokespecial 914	com/tencent/smtt/sdk/m:c	(ZZ)Z
    //   5385: ifeq +76 -> 5461
    //   5388: iconst_1
    //   5389: istore 5
    //   5391: iconst_1
    //   5392: istore_2
    //   5393: lload 9
    //   5395: lstore 15
    //   5397: lload 9
    //   5399: lstore 11
    //   5401: aload_0
    //   5402: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5405: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5408: sipush -214
    //   5411: invokevirtual 906	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5414: iload_2
    //   5415: istore 5
    //   5417: iload_1
    //   5418: ifne -4840 -> 578
    //   5421: aload_0
    //   5422: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5425: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5428: getfield 467	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5431: ldc_w 986
    //   5434: lload 9
    //   5436: invokestatic 1012	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5439: invokeinterface 481 3 0
    //   5444: pop
    //   5445: aload_0
    //   5446: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5449: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5452: invokevirtual 494	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5455: iload_2
    //   5456: istore 5
    //   5458: goto -4880 -> 578
    //   5461: lload 9
    //   5463: lstore 15
    //   5465: iload_2
    //   5466: istore 5
    //   5468: lload 9
    //   5470: lstore 11
    //   5472: aload_0
    //   5473: iconst_0
    //   5474: invokespecial 916	com/tencent/smtt/sdk/m:d	(Z)Z
    //   5477: pop
    //   5478: lload 9
    //   5480: lstore 15
    //   5482: iload_2
    //   5483: istore 5
    //   5485: lload 9
    //   5487: lstore 11
    //   5489: aload_0
    //   5490: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5493: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5496: sipush -313
    //   5499: invokevirtual 906	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5502: iload_2
    //   5503: istore 5
    //   5505: iload_1
    //   5506: ifne -4928 -> 578
    //   5509: aload_0
    //   5510: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5513: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5516: getfield 467	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5519: ldc_w 986
    //   5522: lload 9
    //   5524: invokestatic 1012	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5527: invokeinterface 481 3 0
    //   5532: pop
    //   5533: aload_0
    //   5534: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5537: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5540: invokevirtual 494	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5543: iload_2
    //   5544: istore 5
    //   5546: goto -4968 -> 578
    //   5549: iload_3
    //   5550: sipush 403
    //   5553: if_icmpeq +10 -> 5563
    //   5556: iload_3
    //   5557: sipush 406
    //   5560: if_icmpne +96 -> 5656
    //   5563: lload 9
    //   5565: lstore 15
    //   5567: iload_2
    //   5568: istore 5
    //   5570: lload 9
    //   5572: lstore 11
    //   5574: aload_0
    //   5575: getfield 631	com/tencent/smtt/sdk/m:l	J
    //   5578: ldc2_w 628
    //   5581: lcmp
    //   5582: ifne +74 -> 5656
    //   5585: lload 9
    //   5587: lstore 15
    //   5589: iload_2
    //   5590: istore 5
    //   5592: lload 9
    //   5594: lstore 11
    //   5596: aload_0
    //   5597: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5600: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5603: sipush -314
    //   5606: invokevirtual 906	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5609: iload_2
    //   5610: istore 5
    //   5612: iload_1
    //   5613: ifne -5035 -> 578
    //   5616: aload_0
    //   5617: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5620: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5623: getfield 467	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5626: ldc_w 986
    //   5629: lload 9
    //   5631: invokestatic 1012	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5634: invokeinterface 481 3 0
    //   5639: pop
    //   5640: aload_0
    //   5641: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5644: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5647: invokevirtual 494	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5650: iload_2
    //   5651: istore 5
    //   5653: goto -5075 -> 578
    //   5656: iload_3
    //   5657: sipush 202
    //   5660: if_icmpne +52 -> 5712
    //   5663: lload 9
    //   5665: lstore 13
    //   5667: iload_1
    //   5668: ifne -5137 -> 531
    //   5671: aload_0
    //   5672: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5675: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5678: getfield 467	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5681: ldc_w 986
    //   5684: lload 9
    //   5686: invokestatic 1012	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5689: invokeinterface 481 3 0
    //   5694: pop
    //   5695: aload_0
    //   5696: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5699: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5702: invokevirtual 494	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5705: lload 9
    //   5707: lstore 13
    //   5709: goto -5178 -> 531
    //   5712: lload 9
    //   5714: lstore 15
    //   5716: iload_2
    //   5717: istore 5
    //   5719: lload 9
    //   5721: lstore 11
    //   5723: aload_0
    //   5724: getfield 271	com/tencent/smtt/sdk/m:p	I
    //   5727: aload_0
    //   5728: getfield 84	com/tencent/smtt/sdk/m:B	I
    //   5731: if_icmpge +176 -> 5907
    //   5734: iload_3
    //   5735: sipush 503
    //   5738: if_icmpne +169 -> 5907
    //   5741: lload 9
    //   5743: lstore 15
    //   5745: iload_2
    //   5746: istore 5
    //   5748: lload 9
    //   5750: lstore 11
    //   5752: aload_0
    //   5753: aload_0
    //   5754: getfield 394	com/tencent/smtt/sdk/m:t	Ljava/net/HttpURLConnection;
    //   5757: ldc_w 1181
    //   5760: invokevirtual 1179	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   5763: invokestatic 1185	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   5766: invokespecial 1125	com/tencent/smtt/sdk/m:a	(J)V
    //   5769: lload 9
    //   5771: lstore 15
    //   5773: iload_2
    //   5774: istore 5
    //   5776: lload 9
    //   5778: lstore 11
    //   5780: aload_0
    //   5781: getfield 637	com/tencent/smtt/sdk/m:r	Z
    //   5784: ifeq +74 -> 5858
    //   5787: lload 9
    //   5789: lstore 15
    //   5791: iload_2
    //   5792: istore 5
    //   5794: lload 9
    //   5796: lstore 11
    //   5798: aload_0
    //   5799: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5802: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5805: sipush -309
    //   5808: invokevirtual 906	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5811: iload_2
    //   5812: istore 5
    //   5814: iload_1
    //   5815: ifne -5237 -> 578
    //   5818: aload_0
    //   5819: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5822: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5825: getfield 467	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5828: ldc_w 986
    //   5831: lload 9
    //   5833: invokestatic 1012	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5836: invokeinterface 481 3 0
    //   5841: pop
    //   5842: aload_0
    //   5843: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5846: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5849: invokevirtual 494	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5852: iload_2
    //   5853: istore 5
    //   5855: goto -5277 -> 578
    //   5858: lload 9
    //   5860: lstore 13
    //   5862: iload_1
    //   5863: ifne -5332 -> 531
    //   5866: aload_0
    //   5867: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5870: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5873: getfield 467	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5876: ldc_w 986
    //   5879: lload 9
    //   5881: invokestatic 1012	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5884: invokeinterface 481 3 0
    //   5889: pop
    //   5890: aload_0
    //   5891: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   5894: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5897: invokevirtual 494	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5900: lload 9
    //   5902: lstore 13
    //   5904: goto -5373 -> 531
    //   5907: lload 9
    //   5909: lstore 15
    //   5911: iload_2
    //   5912: istore 5
    //   5914: lload 9
    //   5916: lstore 11
    //   5918: aload_0
    //   5919: getfield 271	com/tencent/smtt/sdk/m:p	I
    //   5922: aload_0
    //   5923: getfield 84	com/tencent/smtt/sdk/m:B	I
    //   5926: if_icmpge +185 -> 6111
    //   5929: iload_3
    //   5930: sipush 408
    //   5933: if_icmpeq +24 -> 5957
    //   5936: iload_3
    //   5937: sipush 504
    //   5940: if_icmpeq +17 -> 5957
    //   5943: iload_3
    //   5944: sipush 502
    //   5947: if_icmpeq +10 -> 5957
    //   5950: iload_3
    //   5951: sipush 408
    //   5954: if_icmpne +157 -> 6111
    //   5957: lload 9
    //   5959: lstore 15
    //   5961: iload_2
    //   5962: istore 5
    //   5964: lload 9
    //   5966: lstore 11
    //   5968: aload_0
    //   5969: lconst_0
    //   5970: invokespecial 1125	com/tencent/smtt/sdk/m:a	(J)V
    //   5973: lload 9
    //   5975: lstore 15
    //   5977: iload_2
    //   5978: istore 5
    //   5980: lload 9
    //   5982: lstore 11
    //   5984: aload_0
    //   5985: getfield 637	com/tencent/smtt/sdk/m:r	Z
    //   5988: ifeq +74 -> 6062
    //   5991: lload 9
    //   5993: lstore 15
    //   5995: iload_2
    //   5996: istore 5
    //   5998: lload 9
    //   6000: lstore 11
    //   6002: aload_0
    //   6003: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6006: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6009: sipush -309
    //   6012: invokevirtual 906	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6015: iload_2
    //   6016: istore 5
    //   6018: iload_1
    //   6019: ifne -5441 -> 578
    //   6022: aload_0
    //   6023: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6026: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6029: getfield 467	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6032: ldc_w 986
    //   6035: lload 9
    //   6037: invokestatic 1012	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6040: invokeinterface 481 3 0
    //   6045: pop
    //   6046: aload_0
    //   6047: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6050: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6053: invokevirtual 494	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6056: iload_2
    //   6057: istore 5
    //   6059: goto -5481 -> 578
    //   6062: lload 9
    //   6064: lstore 13
    //   6066: iload_1
    //   6067: ifne -5536 -> 531
    //   6070: aload_0
    //   6071: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6074: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6077: getfield 467	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6080: ldc_w 986
    //   6083: lload 9
    //   6085: invokestatic 1012	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6088: invokeinterface 481 3 0
    //   6093: pop
    //   6094: aload_0
    //   6095: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6098: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6101: invokevirtual 494	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6104: lload 9
    //   6106: lstore 13
    //   6108: goto -5577 -> 531
    //   6111: lload 9
    //   6113: lstore 15
    //   6115: iload_2
    //   6116: istore 5
    //   6118: lload 9
    //   6120: lstore 11
    //   6122: aload_0
    //   6123: invokespecial 1036	com/tencent/smtt/sdk/m:j	()J
    //   6126: lconst_0
    //   6127: lcmp
    //   6128: ifgt +93 -> 6221
    //   6131: lload 9
    //   6133: lstore 15
    //   6135: iload_2
    //   6136: istore 5
    //   6138: lload 9
    //   6140: lstore 11
    //   6142: aload_0
    //   6143: getfield 635	com/tencent/smtt/sdk/m:o	Z
    //   6146: ifne +75 -> 6221
    //   6149: iload_3
    //   6150: sipush 410
    //   6153: if_icmpeq +68 -> 6221
    //   6156: lload 9
    //   6158: lstore 15
    //   6160: iload_2
    //   6161: istore 5
    //   6163: lload 9
    //   6165: lstore 11
    //   6167: aload_0
    //   6168: iconst_1
    //   6169: putfield 635	com/tencent/smtt/sdk/m:o	Z
    //   6172: lload 9
    //   6174: lstore 13
    //   6176: iload_1
    //   6177: ifne -5646 -> 531
    //   6180: aload_0
    //   6181: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6184: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6187: getfield 467	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6190: ldc_w 986
    //   6193: lload 9
    //   6195: invokestatic 1012	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6198: invokeinterface 481 3 0
    //   6203: pop
    //   6204: aload_0
    //   6205: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6208: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6211: invokevirtual 494	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6214: lload 9
    //   6216: lstore 13
    //   6218: goto -5687 -> 531
    //   6221: lload 9
    //   6223: lstore 15
    //   6225: iload_2
    //   6226: istore 5
    //   6228: lload 9
    //   6230: lstore 11
    //   6232: aload_0
    //   6233: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6236: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6239: sipush -315
    //   6242: invokevirtual 906	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6245: iload_2
    //   6246: istore 5
    //   6248: iload_1
    //   6249: ifne -5671 -> 578
    //   6252: aload_0
    //   6253: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6256: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6259: getfield 467	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6262: ldc_w 986
    //   6265: lload 9
    //   6267: invokestatic 1012	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6270: invokeinterface 481 3 0
    //   6275: pop
    //   6276: aload_0
    //   6277: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6280: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6283: invokevirtual 494	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6286: iload_2
    //   6287: istore 5
    //   6289: goto -5711 -> 578
    //   6292: lload 15
    //   6294: lstore 11
    //   6296: aload_0
    //   6297: lconst_0
    //   6298: invokespecial 1125	com/tencent/smtt/sdk/m:a	(J)V
    //   6301: lload 15
    //   6303: lstore 11
    //   6305: aload_0
    //   6306: bipush 107
    //   6308: aload_0
    //   6309: aload 29
    //   6311: invokespecial 614	com/tencent/smtt/sdk/m:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   6314: iconst_0
    //   6315: invokespecial 616	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   6318: lload 15
    //   6320: lstore 11
    //   6322: aload_0
    //   6323: getfield 637	com/tencent/smtt/sdk/m:r	Z
    //   6326: ifeq -4028 -> 2298
    //   6329: lload 15
    //   6331: lstore 11
    //   6333: aload_0
    //   6334: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6337: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6340: sipush -309
    //   6343: invokevirtual 906	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6346: iload 6
    //   6348: istore 5
    //   6350: iload_1
    //   6351: ifne -5773 -> 578
    //   6354: aload_0
    //   6355: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6358: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6361: getfield 467	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6364: ldc_w 986
    //   6367: lload 15
    //   6369: invokestatic 1012	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6372: invokeinterface 481 3 0
    //   6377: pop
    //   6378: aload_0
    //   6379: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6382: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6385: invokevirtual 494	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6388: iload 6
    //   6390: istore 5
    //   6392: goto -5814 -> 578
    //   6395: iconst_0
    //   6396: istore_3
    //   6397: goto -5764 -> 633
    //   6400: iconst_2
    //   6401: istore_3
    //   6402: goto -5746 -> 656
    //   6405: aload_0
    //   6406: getfield 108	com/tencent/smtt/sdk/m:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   6409: iconst_0
    //   6410: invokevirtual 992	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setPatchUpdateFlag	(I)V
    //   6413: goto -5751 -> 662
    //   6416: aload_0
    //   6417: getfield 96	com/tencent/smtt/sdk/m:g	Landroid/content/Context;
    //   6420: invokestatic 305	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6423: sipush -318
    //   6426: invokevirtual 906	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6429: aload_0
    //   6430: iconst_0
    //   6431: invokespecial 916	com/tencent/smtt/sdk/m:d	(Z)Z
    //   6434: pop
    //   6435: goto -5741 -> 694
    //   6438: aload 29
    //   6440: getfield 309	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   6443: ldc_w 1187
    //   6446: iconst_0
    //   6447: invokeinterface 317 3 0
    //   6452: istore_3
    //   6453: aload 29
    //   6455: getfield 467	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6458: astore 30
    //   6460: iload_3
    //   6461: iconst_1
    //   6462: iadd
    //   6463: istore_3
    //   6464: aload 30
    //   6466: ldc_w 1187
    //   6469: iload_3
    //   6470: invokestatic 491	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6473: invokeinterface 481 3 0
    //   6478: pop
    //   6479: iload_3
    //   6480: aload 29
    //   6482: invokevirtual 1190	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadFailedMaxRetrytimes	()I
    //   6485: if_icmpne -5743 -> 742
    //   6488: aload_0
    //   6489: getfield 108	com/tencent/smtt/sdk/m:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   6492: iconst_2
    //   6493: invokevirtual 1049	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownloadCancel	(I)V
    //   6496: goto -5754 -> 742
    //   6499: iconst_0
    //   6500: istore_3
    //   6501: goto -5742 -> 759
    //   6504: astore 29
    //   6506: goto -4028 -> 2478
    //   6509: astore 31
    //   6511: aconst_null
    //   6512: astore 29
    //   6514: aconst_null
    //   6515: astore 30
    //   6517: aconst_null
    //   6518: astore 32
    //   6520: goto -2439 -> 4081
    //   6523: astore 31
    //   6525: aconst_null
    //   6526: astore 29
    //   6528: aconst_null
    //   6529: astore 32
    //   6531: goto -2450 -> 4081
    //   6534: astore 31
    //   6536: aconst_null
    //   6537: astore 32
    //   6539: goto -2458 -> 4081
    //   6542: astore 31
    //   6544: iload 5
    //   6546: istore_2
    //   6547: lload 17
    //   6549: lstore 9
    //   6551: goto -2470 -> 4081
    //   6554: astore 30
    //   6556: iload_2
    //   6557: istore 6
    //   6559: aload 33
    //   6561: astore 32
    //   6563: goto -3129 -> 3434
    //   6566: astore 31
    //   6568: aload 30
    //   6570: astore 32
    //   6572: iload_2
    //   6573: istore 6
    //   6575: aload 31
    //   6577: astore 30
    //   6579: aload 29
    //   6581: astore 31
    //   6583: aload 32
    //   6585: astore 29
    //   6587: aload 33
    //   6589: astore 32
    //   6591: goto -3157 -> 3434
    //   6594: astore 31
    //   6596: aload 30
    //   6598: astore 33
    //   6600: lload 19
    //   6602: lstore 9
    //   6604: iload 7
    //   6606: istore 6
    //   6608: aload 31
    //   6610: astore 30
    //   6612: aload 29
    //   6614: astore 31
    //   6616: aload 33
    //   6618: astore 29
    //   6620: goto -3186 -> 3434
    //   6623: lload 13
    //   6625: lstore 9
    //   6627: lload 25
    //   6629: lstore 13
    //   6631: goto -2044 -> 4587
    //   6634: lload 13
    //   6636: lstore 9
    //   6638: lload 15
    //   6640: lstore 13
    //   6642: goto -2055 -> 4587
    //   6645: astore 31
    //   6647: aload 30
    //   6649: astore 33
    //   6651: lload 17
    //   6653: lstore 9
    //   6655: iload_2
    //   6656: istore 6
    //   6658: aload 31
    //   6660: astore 30
    //   6662: aload 29
    //   6664: astore 31
    //   6666: aload 33
    //   6668: astore 29
    //   6670: goto -3236 -> 3434
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	6673	0	this	m
    //   0	6673	1	paramBoolean1	boolean
    //   0	6673	2	paramBoolean2	boolean
    //   85	6416	3	i1	int
    //   3616	726	4	i2	int
    //   532	6013	5	bool1	boolean
    //   2202	4455	6	bool2	boolean
    //   3185	3420	7	bool3	boolean
    //   102	5279	8	bool4	boolean
    //   793	5861	9	l1	long
    //   808	5524	11	l2	long
    //   518	6123	13	l3	long
    //   801	5838	15	l4	long
    //   949	5703	17	l5	long
    //   3189	3412	19	l6	long
    //   3175	1405	21	l7	long
    //   789	3363	23	l8	long
    //   4170	2458	25	l9	long
    //   495	3427	27	l10	long
    //   182	1909	29	localObject1	Object
    //   2198	251	29	localThrowable1	Throwable
    //   2472	51	29	localObject2	Object
    //   3053	1036	29	localObject3	Object
    //   4108	976	29	localThrowable2	Throwable
    //   5096	1385	29	localObject4	Object
    //   6504	1	29	localObject5	Object
    //   6512	157	29	localObject6	Object
    //   3084	3432	30	localObject7	Object
    //   6554	15	30	localIOException1	IOException
    //   6577	84	30	localIOException2	IOException
    //   3056	766	31	localObject8	Object
    //   4075	31	31	localObject9	Object
    //   4606	487	31	localObject10	Object
    //   6509	1	31	localObject11	Object
    //   6523	1	31	localObject12	Object
    //   6534	1	31	localObject13	Object
    //   6542	1	31	localObject14	Object
    //   6566	10	31	localIOException3	IOException
    //   6581	1	31	localObject15	Object
    //   6594	15	31	localIOException4	IOException
    //   6614	1	31	localObject16	Object
    //   6645	14	31	localIOException5	IOException
    //   6664	1	31	localObject17	Object
    //   3156	3434	32	localObject18	Object
    //   3050	3617	33	localObject19	Object
    //   3417	11	34	localIOException6	IOException
    //   5077	14	34	localObject20	Object
    // Exception table:
    //   from	to	target	type
    //   810	839	2198	java/lang/Throwable
    //   850	858	2198	java/lang/Throwable
    //   869	893	2198	java/lang/Throwable
    //   904	927	2198	java/lang/Throwable
    //   938	948	2198	java/lang/Throwable
    //   966	976	2198	java/lang/Throwable
    //   987	996	2198	java/lang/Throwable
    //   1007	1015	2198	java/lang/Throwable
    //   1026	1039	2198	java/lang/Throwable
    //   1097	1113	2198	java/lang/Throwable
    //   1136	1145	2198	java/lang/Throwable
    //   1156	1164	2198	java/lang/Throwable
    //   1175	1188	2198	java/lang/Throwable
    //   1246	1251	2198	java/lang/Throwable
    //   1262	1269	2198	java/lang/Throwable
    //   1280	1286	2198	java/lang/Throwable
    //   1297	1334	2198	java/lang/Throwable
    //   1345	1357	2198	java/lang/Throwable
    //   1368	1377	2198	java/lang/Throwable
    //   1388	1394	2198	java/lang/Throwable
    //   1405	1411	2198	java/lang/Throwable
    //   1425	1432	2198	java/lang/Throwable
    //   1443	1449	2198	java/lang/Throwable
    //   1460	1476	2198	java/lang/Throwable
    //   1487	1496	2198	java/lang/Throwable
    //   1507	1524	2198	java/lang/Throwable
    //   1535	1569	2198	java/lang/Throwable
    //   1580	1586	2198	java/lang/Throwable
    //   1606	1612	2198	java/lang/Throwable
    //   1623	1631	2198	java/lang/Throwable
    //   1642	1651	2198	java/lang/Throwable
    //   1662	1669	2198	java/lang/Throwable
    //   1680	1688	2198	java/lang/Throwable
    //   1699	1705	2198	java/lang/Throwable
    //   1716	1721	2198	java/lang/Throwable
    //   1732	1739	2198	java/lang/Throwable
    //   1750	1764	2198	java/lang/Throwable
    //   1775	1783	2198	java/lang/Throwable
    //   1794	1809	2198	java/lang/Throwable
    //   1820	1828	2198	java/lang/Throwable
    //   1843	1853	2198	java/lang/Throwable
    //   1864	1875	2198	java/lang/Throwable
    //   1886	1896	2198	java/lang/Throwable
    //   1907	1913	2198	java/lang/Throwable
    //   1924	1928	2198	java/lang/Throwable
    //   1939	1945	2198	java/lang/Throwable
    //   1956	1966	2198	java/lang/Throwable
    //   1977	1986	2198	java/lang/Throwable
    //   1997	2004	2198	java/lang/Throwable
    //   2015	2028	2198	java/lang/Throwable
    //   2086	2092	2198	java/lang/Throwable
    //   2106	2143	2198	java/lang/Throwable
    //   2154	2195	2198	java/lang/Throwable
    //   2386	2394	2198	java/lang/Throwable
    //   2405	2417	2198	java/lang/Throwable
    //   2428	2436	2198	java/lang/Throwable
    //   2447	2453	2198	java/lang/Throwable
    //   2464	2469	2198	java/lang/Throwable
    //   2550	2565	2198	java/lang/Throwable
    //   2576	2601	2198	java/lang/Throwable
    //   2612	2623	2198	java/lang/Throwable
    //   2634	2655	2198	java/lang/Throwable
    //   2673	2683	2198	java/lang/Throwable
    //   2694	2731	2198	java/lang/Throwable
    //   2746	2753	2198	java/lang/Throwable
    //   2764	2770	2198	java/lang/Throwable
    //   2781	2791	2198	java/lang/Throwable
    //   2802	2809	2198	java/lang/Throwable
    //   2820	2827	2198	java/lang/Throwable
    //   2892	2930	2198	java/lang/Throwable
    //   2941	2954	2198	java/lang/Throwable
    //   3012	3022	2198	java/lang/Throwable
    //   3033	3046	2198	java/lang/Throwable
    //   3069	3077	2198	java/lang/Throwable
    //   3282	3288	2198	java/lang/Throwable
    //   3300	3306	2198	java/lang/Throwable
    //   3318	3324	2198	java/lang/Throwable
    //   3487	3493	2198	java/lang/Throwable
    //   3505	3511	2198	java/lang/Throwable
    //   3523	3529	2198	java/lang/Throwable
    //   4623	4629	2198	java/lang/Throwable
    //   4640	4646	2198	java/lang/Throwable
    //   4657	4663	2198	java/lang/Throwable
    //   4674	4681	2198	java/lang/Throwable
    //   4692	4705	2198	java/lang/Throwable
    //   4836	4842	2198	java/lang/Throwable
    //   4854	4860	2198	java/lang/Throwable
    //   4872	4878	2198	java/lang/Throwable
    //   4964	4970	2198	java/lang/Throwable
    //   4982	4988	2198	java/lang/Throwable
    //   5000	5006	2198	java/lang/Throwable
    //   5130	5142	2198	java/lang/Throwable
    //   5153	5161	2198	java/lang/Throwable
    //   5172	5178	2198	java/lang/Throwable
    //   5189	5199	2198	java/lang/Throwable
    //   5259	5267	2198	java/lang/Throwable
    //   5278	5291	2198	java/lang/Throwable
    //   5349	5360	2198	java/lang/Throwable
    //   5378	5388	2198	java/lang/Throwable
    //   5401	5414	2198	java/lang/Throwable
    //   5472	5478	2198	java/lang/Throwable
    //   5489	5502	2198	java/lang/Throwable
    //   5574	5585	2198	java/lang/Throwable
    //   5596	5609	2198	java/lang/Throwable
    //   5723	5734	2198	java/lang/Throwable
    //   5752	5769	2198	java/lang/Throwable
    //   5780	5787	2198	java/lang/Throwable
    //   5798	5811	2198	java/lang/Throwable
    //   5918	5929	2198	java/lang/Throwable
    //   5968	5973	2198	java/lang/Throwable
    //   5984	5991	2198	java/lang/Throwable
    //   6002	6015	2198	java/lang/Throwable
    //   6122	6131	2198	java/lang/Throwable
    //   6142	6149	2198	java/lang/Throwable
    //   6167	6172	2198	java/lang/Throwable
    //   6232	6245	2198	java/lang/Throwable
    //   810	839	2472	finally
    //   850	858	2472	finally
    //   869	893	2472	finally
    //   904	927	2472	finally
    //   938	948	2472	finally
    //   966	976	2472	finally
    //   987	996	2472	finally
    //   1007	1015	2472	finally
    //   1026	1039	2472	finally
    //   1097	1113	2472	finally
    //   1136	1145	2472	finally
    //   1156	1164	2472	finally
    //   1175	1188	2472	finally
    //   1246	1251	2472	finally
    //   1262	1269	2472	finally
    //   1280	1286	2472	finally
    //   1297	1334	2472	finally
    //   1345	1357	2472	finally
    //   1368	1377	2472	finally
    //   1388	1394	2472	finally
    //   1405	1411	2472	finally
    //   1425	1432	2472	finally
    //   1443	1449	2472	finally
    //   1460	1476	2472	finally
    //   1487	1496	2472	finally
    //   1507	1524	2472	finally
    //   1535	1569	2472	finally
    //   1580	1586	2472	finally
    //   1606	1612	2472	finally
    //   1623	1631	2472	finally
    //   1642	1651	2472	finally
    //   1662	1669	2472	finally
    //   1680	1688	2472	finally
    //   1699	1705	2472	finally
    //   1716	1721	2472	finally
    //   1732	1739	2472	finally
    //   1750	1764	2472	finally
    //   1775	1783	2472	finally
    //   1794	1809	2472	finally
    //   1820	1828	2472	finally
    //   1843	1853	2472	finally
    //   1864	1875	2472	finally
    //   1886	1896	2472	finally
    //   1907	1913	2472	finally
    //   1924	1928	2472	finally
    //   1939	1945	2472	finally
    //   1956	1966	2472	finally
    //   1977	1986	2472	finally
    //   1997	2004	2472	finally
    //   2015	2028	2472	finally
    //   2086	2092	2472	finally
    //   2106	2143	2472	finally
    //   2154	2195	2472	finally
    //   2208	2216	2472	finally
    //   2224	2231	2472	finally
    //   2235	2243	2472	finally
    //   2247	2286	2472	finally
    //   2290	2298	2472	finally
    //   2302	2315	2472	finally
    //   2386	2394	2472	finally
    //   2405	2417	2472	finally
    //   2428	2436	2472	finally
    //   2447	2453	2472	finally
    //   2464	2469	2472	finally
    //   2550	2565	2472	finally
    //   2576	2601	2472	finally
    //   2612	2623	2472	finally
    //   2634	2655	2472	finally
    //   2673	2683	2472	finally
    //   2694	2731	2472	finally
    //   2746	2753	2472	finally
    //   2764	2770	2472	finally
    //   2781	2791	2472	finally
    //   2802	2809	2472	finally
    //   2820	2827	2472	finally
    //   2892	2930	2472	finally
    //   2941	2954	2472	finally
    //   3012	3022	2472	finally
    //   3033	3046	2472	finally
    //   3069	3077	2472	finally
    //   3282	3288	2472	finally
    //   3300	3306	2472	finally
    //   3318	3324	2472	finally
    //   3487	3493	2472	finally
    //   3505	3511	2472	finally
    //   3523	3529	2472	finally
    //   4623	4629	2472	finally
    //   4640	4646	2472	finally
    //   4657	4663	2472	finally
    //   4674	4681	2472	finally
    //   4692	4705	2472	finally
    //   4836	4842	2472	finally
    //   4854	4860	2472	finally
    //   4872	4878	2472	finally
    //   4964	4970	2472	finally
    //   4982	4988	2472	finally
    //   5000	5006	2472	finally
    //   5130	5142	2472	finally
    //   5153	5161	2472	finally
    //   5172	5178	2472	finally
    //   5189	5199	2472	finally
    //   5259	5267	2472	finally
    //   5278	5291	2472	finally
    //   5349	5360	2472	finally
    //   5378	5388	2472	finally
    //   5401	5414	2472	finally
    //   5472	5478	2472	finally
    //   5489	5502	2472	finally
    //   5574	5585	2472	finally
    //   5596	5609	2472	finally
    //   5723	5734	2472	finally
    //   5752	5769	2472	finally
    //   5780	5787	2472	finally
    //   5798	5811	2472	finally
    //   5918	5929	2472	finally
    //   5968	5973	2472	finally
    //   5984	5991	2472	finally
    //   6002	6015	2472	finally
    //   6122	6131	2472	finally
    //   6142	6149	2472	finally
    //   6167	6172	2472	finally
    //   6232	6245	2472	finally
    //   6296	6301	2472	finally
    //   6305	6318	2472	finally
    //   6322	6329	2472	finally
    //   6333	6346	2472	finally
    //   3091	3100	3417	java/io/IOException
    //   3105	3127	3417	java/io/IOException
    //   3384	3414	3417	java/io/IOException
    //   3166	3171	4075	finally
    //   3880	3889	4075	finally
    //   3897	3933	4075	finally
    //   3941	3954	4075	finally
    //   3968	3978	4075	finally
    //   3986	3995	4075	finally
    //   4003	4048	4075	finally
    //   4056	4069	4075	finally
    //   4081	4108	4108	java/lang/Throwable
    //   3434	3450	5077	finally
    //   3450	3475	5077	finally
    //   4756	4824	5077	finally
    //   4927	4952	5077	finally
    //   5061	5074	5077	finally
    //   4081	4108	6504	finally
    //   3077	3086	6509	finally
    //   3091	3100	6523	finally
    //   3105	3127	6523	finally
    //   3384	3414	6523	finally
    //   3127	3158	6534	finally
    //   3191	3198	6542	finally
    //   3212	3221	6542	finally
    //   3235	3248	6542	finally
    //   3605	3618	6542	finally
    //   3637	3644	6542	finally
    //   3658	3668	6542	finally
    //   3686	3694	6542	finally
    //   3716	3721	6542	finally
    //   3741	3746	6542	finally
    //   3763	3770	6542	finally
    //   3789	3802	6542	finally
    //   3819	3829	6542	finally
    //   3843	3848	6542	finally
    //   4143	4153	6542	finally
    //   4167	4172	6542	finally
    //   4206	4243	6542	finally
    //   4257	4263	6542	finally
    //   4277	4293	6542	finally
    //   4307	4324	6542	finally
    //   4338	4348	6542	finally
    //   4378	4388	6542	finally
    //   4402	4413	6542	finally
    //   4427	4437	6542	finally
    //   4451	4457	6542	finally
    //   4471	4475	6542	finally
    //   4489	4495	6542	finally
    //   4509	4519	6542	finally
    //   4533	4542	6542	finally
    //   4556	4569	6542	finally
    //   3077	3086	6554	java/io/IOException
    //   3127	3158	6566	java/io/IOException
    //   3191	3198	6594	java/io/IOException
    //   3212	3221	6594	java/io/IOException
    //   3235	3248	6594	java/io/IOException
    //   3605	3618	6594	java/io/IOException
    //   3637	3644	6594	java/io/IOException
    //   3658	3668	6594	java/io/IOException
    //   3686	3694	6594	java/io/IOException
    //   3716	3721	6594	java/io/IOException
    //   3741	3746	6594	java/io/IOException
    //   3763	3770	6594	java/io/IOException
    //   3789	3802	6594	java/io/IOException
    //   3819	3829	6594	java/io/IOException
    //   3843	3848	6594	java/io/IOException
    //   4143	4153	6594	java/io/IOException
    //   4167	4172	6594	java/io/IOException
    //   4206	4243	6594	java/io/IOException
    //   4257	4263	6594	java/io/IOException
    //   4277	4293	6594	java/io/IOException
    //   4307	4324	6594	java/io/IOException
    //   4338	4348	6594	java/io/IOException
    //   4378	4388	6594	java/io/IOException
    //   4402	4413	6594	java/io/IOException
    //   4427	4437	6594	java/io/IOException
    //   4451	4457	6594	java/io/IOException
    //   4471	4475	6594	java/io/IOException
    //   4489	4495	6594	java/io/IOException
    //   4509	4519	6594	java/io/IOException
    //   4533	4542	6594	java/io/IOException
    //   4556	4569	6594	java/io/IOException
    //   3166	3171	6645	java/io/IOException
    //   3880	3889	6645	java/io/IOException
    //   3897	3933	6645	java/io/IOException
    //   3941	3954	6645	java/io/IOException
    //   3968	3978	6645	java/io/IOException
    //   3986	3995	6645	java/io/IOException
    //   4003	4048	6645	java/io/IOException
    //   4056	4069	6645	java/io/IOException
  }
  
  public void c()
  {
    AppMethodBeat.i(192530);
    b();
    d(false);
    d(true);
    AppMethodBeat.o(192530);
  }
  
  public boolean d()
  {
    AppMethodBeat.i(192536);
    TbsLog.i("TbsDownload", "[TbsApkDownloader.isDownloadForeground] mIsDownloadForeground=" + this.C);
    boolean bool = this.C;
    AppMethodBeat.o(192536);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.m
 * JD-Core Version:    0.7.0.1
 */