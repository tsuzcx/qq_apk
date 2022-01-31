package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.a;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.j;
import com.tencent.smtt.utils.v;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class ag
{
  private static int d = 5;
  private static int e = 1;
  private static final String[] f = { "tbs_downloading_com.tencent.mtt", "tbs_downloading_com.tencent.mm", "tbs_downloading_com.tencent.mobileqq", "tbs_downloading_com.tencent.tbs", "tbs_downloading_com.qzone" };
  private Set<String> A;
  private int B = d;
  private boolean C;
  String a;
  String[] b = null;
  int c = 0;
  private Context g;
  private String h;
  private String i;
  private String j;
  private File k;
  private long l;
  private int m = 30000;
  private int n = 20000;
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
  
  public ag(Context paramContext)
  {
    this.g = paramContext.getApplicationContext();
    this.v = TbsLogReport.getInstance(this.g).tbsLogInfo();
    this.A = new HashSet();
    this.u = ("tbs_downloading_" + this.g.getPackageName());
    an.a();
    this.k = an.t(this.g);
    if (this.k == null) {
      throw new NullPointerException("TbsCorePrivateDir is null!");
    }
    f();
    this.w = null;
    this.x = -1;
  }
  
  private long a(long paramLong1, long paramLong2)
  {
    long l1 = System.currentTimeMillis();
    this.v.setDownConsumeTime(l1 - paramLong1);
    this.v.setDownloadSize(paramLong2);
    return l1;
  }
  
  @TargetApi(8)
  static File a(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 8)
        {
          paramContext = new File(j.a(paramContext, 4));
          if ((paramContext != null) && (!paramContext.exists()) && (!paramContext.isDirectory())) {
            paramContext.mkdirs();
          }
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        TbsLog.e("TbsDownload", "[TbsApkDownloader.backupApkPath] Exception is " + paramContext.getMessage());
        return null;
      }
      paramContext = null;
    }
  }
  
  private static File a(Context paramContext, int paramInt)
  {
    File localFile = new File(j.a(paramContext, paramInt));
    if ((!localFile.exists()) || (!localFile.isDirectory())) {
      return null;
    }
    if (TbsDownloader.getOverSea(paramContext)) {}
    for (paramContext = "x5.oversea.tbs.org"; new File(localFile, paramContext).exists(); paramContext = "x5.tbs.org") {
      return localFile;
    }
    return null;
  }
  
  private String a(Throwable paramThrowable)
  {
    String str = Log.getStackTraceString(paramThrowable);
    paramThrowable = str;
    if (str.length() > 1024) {
      paramThrowable = str.substring(0, 1024);
    }
    return paramThrowable;
  }
  
  private String a(URL paramURL)
  {
    try
    {
      paramURL = InetAddress.getByName(paramURL.getHost()).getHostAddress();
      return paramURL;
    }
    catch (Error paramURL)
    {
      return "";
    }
    catch (Exception paramURL) {}
    return "";
  }
  
  private void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) || (this.p > this.B))
    {
      this.v.setErrorCode(paramInt);
      this.v.setFailDetail(paramString);
    }
  }
  
  private void a(long paramLong)
  {
    this.p += 1;
    long l1 = paramLong;
    if (paramLong <= 0L) {}
    try
    {
      l1 = m();
      Thread.sleep(l1);
      return;
    }
    catch (Exception localException) {}
  }
  
  private void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  public static void a(File paramFile, Context paramContext)
  {
    if ((paramFile == null) || (!paramFile.exists())) {}
    for (;;)
    {
      return;
      try
      {
        File localFile = a(paramContext);
        if (localFile == null) {
          continue;
        }
        if (TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_download_version_type", 0) == 1)
        {
          localObject = new File(localFile, "x5.tbs.decouple");
          ((File)localObject).delete();
          j.b(paramFile, (File)localObject);
          if ((TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_download_version_type", 0) == 1) || (TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_decouplecoreversion", 0) != a.a(paramContext, paramFile))) {
            continue;
          }
          localObject = new File(localFile, "x5.tbs.decouple");
          if (a.a(paramContext, paramFile) == a.a(paramContext, (File)localObject)) {
            continue;
          }
          ((File)localObject).delete();
          j.b(paramFile, (File)localObject);
          return;
        }
        if (TbsDownloader.getOverSea(paramContext)) {}
        for (Object localObject = "x5.oversea.tbs.org";; localObject = "x5.tbs.org")
        {
          localObject = new File(localFile, (String)localObject);
          break;
        }
        return;
      }
      catch (Exception paramFile) {}
    }
  }
  
  private void a(String paramString)
  {
    paramString = new URL(paramString);
    if (this.t != null) {}
    try
    {
      this.t.disconnect();
      this.t = ((HttpURLConnection)paramString.openConnection());
      this.t.setRequestProperty("User-Agent", TbsDownloader.a(this.g));
      this.t.setRequestProperty("Accept-Encoding", "identity");
      this.t.setRequestMethod("GET");
      this.t.setInstanceFollowRedirects(false);
      this.t.setConnectTimeout(this.n);
      this.t.setReadTimeout(this.m);
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
  
  @TargetApi(8)
  static File b(Context paramContext)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 8)
      {
        Object localObject2 = a(paramContext, 4);
        Object localObject1 = localObject2;
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
        return localObject1;
      }
    }
    catch (Exception paramContext)
    {
      TbsLog.e("TbsDownload", "[TbsApkDownloader.backupApkPath] Exception is " + paramContext.getMessage());
      return null;
    }
    return null;
  }
  
  private void b(boolean paramBoolean)
  {
    v.a(this.g);
    Object localObject2 = TbsDownloadConfig.getInstance(this.g);
    ((TbsDownloadConfig)localObject2).a.put("request_full_package", Boolean.valueOf(false));
    ((TbsDownloadConfig)localObject2).a.put("tbs_needdownload", Boolean.valueOf(false));
    ((TbsDownloadConfig)localObject2).a.put("tbs_download_interrupt_code_reason", Integer.valueOf(-123));
    ((TbsDownloadConfig)localObject2).commit();
    Object localObject1 = QbSdk.m;
    File localFile;
    label172:
    int i2;
    if (paramBoolean)
    {
      i1 = 100;
      ((TbsListener)localObject1).onDownloadFinish(i1);
      i1 = ((TbsDownloadConfig)localObject2).mPreferences.getInt("tbs_responsecode", 0);
      TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_downloaddecouplecore", 0);
      if ((i1 != 3) && (i1 <= 10000)) {
        break label372;
      }
      localFile = a(this.g);
      if (localFile == null) {
        break label344;
      }
      if (!TbsDownloader.getOverSea(this.g)) {
        break label331;
      }
      localObject1 = "x5.oversea.tbs.org";
      localFile = new File(localFile, (String)localObject1);
      i2 = a.a(this.g, localFile);
      localObject1 = new File(this.k, "x5.tbs");
      if (!((File)localObject1).exists()) {
        break label338;
      }
    }
    label331:
    label338:
    for (localObject1 = ((File)localObject1).getAbsolutePath();; localObject1 = null)
    {
      int i3 = ((TbsDownloadConfig)localObject2).mPreferences.getInt("tbs_download_version", 0);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("operation", i1);
      ((Bundle)localObject2).putInt("old_core_ver", i2);
      ((Bundle)localObject2).putInt("new_core_ver", i3);
      ((Bundle)localObject2).putString("old_apk_location", localFile.getAbsolutePath());
      ((Bundle)localObject2).putString("new_apk_location", (String)localObject1);
      ((Bundle)localObject2).putString("diff_file_location", (String)localObject1);
      an.a().b(this.g, (Bundle)localObject2);
      return;
      i1 = 120;
      break;
      localObject1 = "x5.tbs.org";
      break label172;
    }
    label344:
    d();
    ((TbsDownloadConfig)localObject2).a.put("tbs_needdownload", Boolean.valueOf(true));
    ((TbsDownloadConfig)localObject2).commit();
    return;
    label372:
    int i1 = ((TbsDownloadConfig)localObject2).mPreferences.getInt("tbs_download_version", 0);
    an.a().a(this.g, new File(this.k, "x5.tbs").getAbsolutePath(), i1);
    a(new File(this.k, "x5.tbs"), this.g);
  }
  
  private boolean b(int paramInt)
  {
    boolean bool = false;
    try
    {
      File localFile1 = new File(this.k, "x5.tbs");
      File localFile2 = a(this.g);
      if (localFile2 != null)
      {
        if (TbsDownloader.getOverSea(this.g)) {}
        for (Object localObject = "x5.oversea.tbs.org";; localObject = "x5.tbs.org")
        {
          localObject = new File(localFile2, (String)localObject);
          localFile1.delete();
          j.b((File)localObject, localFile1);
          if (a.a(this.g, localFile1, 0L, paramInt)) {
            break;
          }
          TbsLog.i("TbsDownload", "[TbsApkDownloader.copyTbsApkFromBackupToInstall] verifyTbsApk error!!");
          return false;
        }
        bool = true;
      }
    }
    catch (Exception localException)
    {
      TbsLog.e("TbsDownload", "[TbsApkDownloader.copyTbsApkFromBackupToInstall] Exception is " + localException.getMessage());
      return false;
    }
    return bool;
  }
  
  public static void c(Context paramContext)
  {
    try
    {
      an.a();
      File localFile = an.t(paramContext);
      new File(localFile, "x5.tbs").delete();
      new File(localFile, "x5.tbs.temp").delete();
      paramContext = a(paramContext);
      if (paramContext != null)
      {
        new File(paramContext, "x5.tbs.org").delete();
        new File(paramContext, "x5.oversea.tbs.org").delete();
      }
      return;
    }
    catch (Exception paramContext) {}
  }
  
  private boolean c(boolean paramBoolean)
  {
    TbsLog.i("TbsDownload", "[TbsApkDownloader.deleteFile] isApk=" + paramBoolean);
    if (paramBoolean) {}
    for (File localFile = new File(this.k, "x5.tbs"); localFile.exists(); localFile = new File(this.k, "x5.tbs.temp")) {
      return localFile.delete();
    }
    return true;
  }
  
  private boolean c(boolean paramBoolean1, boolean paramBoolean2)
  {
    long l2 = 0L;
    TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1);
    Object localObject2 = this.k;
    Object localObject1;
    if (!paramBoolean1)
    {
      localObject1 = "x5.tbs";
      localObject1 = new File((File)localObject2, (String)localObject1);
      if (((File)localObject1).exists()) {
        break label71;
      }
    }
    label71:
    Object localObject3;
    do
    {
      return false;
      localObject1 = "x5.tbs.temp";
      break;
      localObject2 = TbsDownloadConfig.getInstance(this.g).mPreferences.getString("tbs_apk_md5", null);
      localObject3 = a.a((File)localObject1);
      if ((localObject2 != null) && (((String)localObject2).equals(localObject3))) {
        break label158;
      }
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1 + " md5 failed");
    } while (!paramBoolean1);
    this.v.setCheckErrorDetail("fileMd5 not match");
    return false;
    label158:
    TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] md5(" + (String)localObject3 + ") successful!");
    long l1 = l2;
    long l3;
    if (paramBoolean1)
    {
      l3 = TbsDownloadConfig.getInstance(this.g).mPreferences.getLong("tbs_apkfilesize", 0L);
      if (!((File)localObject1).exists()) {
        break label718;
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
            if (!paramBoolean1) {
              break;
            }
            this.v.setCheckErrorDetail("fileVersion:" + i2 + ",configVersion:" + i3);
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
          if (!paramBoolean1) {
            break;
          }
          localObject2 = this.v;
          localObject3 = new StringBuilder("signature:");
          if (str == null) {}
          for (localObject1 = "null";; localObject1 = Integer.valueOf(str.length()))
          {
            ((TbsLogReport.TbsLogInfo)localObject2).setCheckErrorDetail(localObject1);
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
          break label688;
        }
        a(109, a((Throwable)localObject1), true);
        return false;
      }
      paramBoolean2 = false;
      label688:
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] rename(" + paramBoolean2 + ") successful!");
      return true;
      label718:
      l1 = 0L;
    }
  }
  
  private void f()
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
  
  private void g()
  {
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
          if (TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_downloaddecouplecore", 0) != 1) {
            break label315;
          }
          TbsLogReport.getInstance(this.g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE, this.v);
          this.v.resetArgs();
          if (i1 != 100) {
            QbSdk.m.onDownloadFinish(i1);
          }
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
        if (!l())
        {
          a(101, null, true);
          continue;
          label315:
          TbsLogReport.getInstance(this.g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, this.v);
        }
      }
      TbsDownloader.a = false;
    }
  }
  
  private boolean h()
  {
    String str = j.a(this.g, 4);
    if (TbsDownloader.getOverSea(this.g)) {}
    for (Object localObject = "x5.oversea.tbs.org";; localObject = "x5.tbs.org")
    {
      localObject = new File(str, (String)localObject);
      int i2 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("use_backup_version", 0);
      int i1 = i2;
      if (i2 == 0) {
        i1 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_download_version", 0);
      }
      return a.a(this.g, (File)localObject, 0L, i1);
    }
  }
  
  private void i()
  {
    try
    {
      if (TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_downloaddecouplecore", 0) == 1) {
        return;
      }
      String str = j.a(this.g, 4);
      if (TbsDownloader.getOverSea(this.g)) {}
      for (Object localObject = "x5.oversea.tbs.org";; localObject = "x5.tbs.org")
      {
        localObject = new File(str, (String)localObject);
        if (!((File)localObject).exists()) {
          break;
        }
        ((File)localObject).delete();
        return;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private boolean j()
  {
    boolean bool = false;
    if (new File(this.k, "x5.tbs.temp").exists()) {
      bool = true;
    }
    return bool;
  }
  
  private long k()
  {
    long l1 = 0L;
    File localFile = new File(this.k, "x5.tbs.temp");
    if (localFile.exists()) {
      l1 = localFile.length();
    }
    return l1;
  }
  
  /* Error */
  private boolean l()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: invokestatic 636	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   6: astore 5
    //   8: aload 5
    //   10: new 107	java/lang/StringBuilder
    //   13: dup
    //   14: ldc_w 638
    //   17: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   20: ldc_w 640
    //   23: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokevirtual 644	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   32: invokevirtual 650	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   35: astore 7
    //   37: new 652	java/io/InputStreamReader
    //   40: dup
    //   41: aload 7
    //   43: invokespecial 655	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   46: astore 8
    //   48: new 657	java/io/BufferedReader
    //   51: dup
    //   52: aload 8
    //   54: invokespecial 660	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   57: astore 6
    //   59: iconst_0
    //   60: istore_1
    //   61: aload 6
    //   63: invokevirtual 663	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   66: astore 5
    //   68: iload 4
    //   70: istore_3
    //   71: aload 5
    //   73: ifnull +29 -> 102
    //   76: aload 5
    //   78: ldc_w 665
    //   81: invokevirtual 669	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   84: ifne +16 -> 100
    //   87: aload 5
    //   89: ldc_w 671
    //   92: invokevirtual 669	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   95: istore_3
    //   96: iload_3
    //   97: ifeq +25 -> 122
    //   100: iconst_1
    //   101: istore_3
    //   102: aload_0
    //   103: aload 7
    //   105: invokespecial 673	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   108: aload_0
    //   109: aload 8
    //   111: invokespecial 673	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   114: aload_0
    //   115: aload 6
    //   117: invokespecial 673	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   120: iload_3
    //   121: ireturn
    //   122: iload_1
    //   123: iconst_1
    //   124: iadd
    //   125: istore_2
    //   126: iload_2
    //   127: istore_1
    //   128: iload_2
    //   129: iconst_5
    //   130: if_icmplt -69 -> 61
    //   133: iload 4
    //   135: istore_3
    //   136: goto -34 -> 102
    //   139: astore 5
    //   141: aconst_null
    //   142: astore 5
    //   144: aconst_null
    //   145: astore 6
    //   147: aconst_null
    //   148: astore 7
    //   150: aload_0
    //   151: aload 7
    //   153: invokespecial 673	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   156: aload_0
    //   157: aload 6
    //   159: invokespecial 673	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   162: aload_0
    //   163: aload 5
    //   165: invokespecial 673	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   168: iconst_0
    //   169: ireturn
    //   170: astore 5
    //   172: aconst_null
    //   173: astore 6
    //   175: aconst_null
    //   176: astore 8
    //   178: aconst_null
    //   179: astore 7
    //   181: aload_0
    //   182: aload 7
    //   184: invokespecial 673	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   187: aload_0
    //   188: aload 8
    //   190: invokespecial 673	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   193: aload_0
    //   194: aload 6
    //   196: invokespecial 673	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   199: aload 5
    //   201: athrow
    //   202: astore 5
    //   204: aconst_null
    //   205: astore 6
    //   207: aconst_null
    //   208: astore 8
    //   210: goto -29 -> 181
    //   213: astore 5
    //   215: aconst_null
    //   216: astore 6
    //   218: goto -37 -> 181
    //   221: astore 5
    //   223: goto -42 -> 181
    //   226: astore 5
    //   228: aconst_null
    //   229: astore 5
    //   231: aconst_null
    //   232: astore 6
    //   234: goto -84 -> 150
    //   237: astore 5
    //   239: aconst_null
    //   240: astore 5
    //   242: aload 8
    //   244: astore 6
    //   246: goto -96 -> 150
    //   249: astore 5
    //   251: aload 6
    //   253: astore 5
    //   255: aload 8
    //   257: astore 6
    //   259: goto -109 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	262	0	this	ag
    //   60	68	1	i1	int
    //   125	6	2	i2	int
    //   70	66	3	bool1	boolean
    //   1	133	4	bool2	boolean
    //   6	82	5	localObject1	Object
    //   139	1	5	localThrowable1	Throwable
    //   142	22	5	localCloseable	Closeable
    //   170	30	5	localObject2	Object
    //   202	1	5	localObject3	Object
    //   213	1	5	localObject4	Object
    //   221	1	5	localObject5	Object
    //   226	1	5	localThrowable2	Throwable
    //   229	1	5	localObject6	Object
    //   237	1	5	localThrowable3	Throwable
    //   240	1	5	localObject7	Object
    //   249	1	5	localThrowable4	Throwable
    //   253	1	5	localObject8	Object
    //   57	201	6	localObject9	Object
    //   35	148	7	localInputStream	java.io.InputStream
    //   46	210	8	localInputStreamReader	java.io.InputStreamReader
    // Exception table:
    //   from	to	target	type
    //   8	37	139	java/lang/Throwable
    //   8	37	170	finally
    //   37	48	202	finally
    //   48	59	213	finally
    //   61	68	221	finally
    //   76	96	221	finally
    //   37	48	226	java/lang/Throwable
    //   48	59	237	java/lang/Throwable
    //   61	68	249	java/lang/Throwable
    //   76	96	249	java/lang/Throwable
  }
  
  private long m()
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
  private boolean n()
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
    //   12: aload_0
    //   13: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   16: invokestatic 589	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   19: iconst_3
    //   20: if_icmpne +267 -> 287
    //   23: iconst_1
    //   24: istore_3
    //   25: ldc 192
    //   27: new 107	java/lang/StringBuilder
    //   30: dup
    //   31: ldc_w 681
    //   34: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   37: iload_3
    //   38: invokevirtual 463	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   41: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 453	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: iload 5
    //   49: istore_2
    //   50: iload_3
    //   51: ifeq +135 -> 186
    //   54: aload_0
    //   55: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   58: invokestatic 684	com/tencent/smtt/utils/Apn:getWifiSSID	(Landroid/content/Context;)Ljava/lang/String;
    //   61: astore 6
    //   63: ldc 192
    //   65: new 107	java/lang/StringBuilder
    //   68: dup
    //   69: ldc_w 686
    //   72: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   75: aload 6
    //   77: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 453	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: new 236	java/net/URL
    //   89: dup
    //   90: ldc_w 688
    //   93: invokespecial 313	java/net/URL:<init>	(Ljava/lang/String;)V
    //   96: invokevirtual 324	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   99: checkcast 317	java/net/HttpURLConnection
    //   102: astore 7
    //   104: aload 7
    //   106: iconst_0
    //   107: invokevirtual 345	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   110: aload 7
    //   112: sipush 10000
    //   115: invokevirtual 348	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   118: aload 7
    //   120: sipush 10000
    //   123: invokevirtual 351	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   126: aload 7
    //   128: iconst_0
    //   129: invokevirtual 691	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   132: aload 7
    //   134: invokevirtual 692	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   137: pop
    //   138: aload 7
    //   140: invokevirtual 695	java/net/HttpURLConnection:getResponseCode	()I
    //   143: istore_1
    //   144: ldc 192
    //   146: new 107	java/lang/StringBuilder
    //   149: dup
    //   150: ldc_w 697
    //   153: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   156: iload_1
    //   157: invokevirtual 516	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   160: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 453	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   166: iload_1
    //   167: sipush 204
    //   170: if_icmpne +122 -> 292
    //   173: iload 4
    //   175: istore_2
    //   176: aload 7
    //   178: ifnull +193 -> 371
    //   181: aload 7
    //   183: invokevirtual 320	java/net/HttpURLConnection:disconnect	()V
    //   186: iload_2
    //   187: ifne +68 -> 255
    //   190: aload 6
    //   192: invokestatic 702	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   195: ifne +60 -> 255
    //   198: aload_0
    //   199: getfield 105	com/tencent/smtt/sdk/ag:A	Ljava/util/Set;
    //   202: aload 6
    //   204: invokeinterface 706 2 0
    //   209: ifne +46 -> 255
    //   212: aload_0
    //   213: getfield 105	com/tencent/smtt/sdk/ag:A	Ljava/util/Set;
    //   216: aload 6
    //   218: invokeinterface 709 2 0
    //   223: pop
    //   224: aload_0
    //   225: invokespecial 711	com/tencent/smtt/sdk/ag:o	()V
    //   228: aload_0
    //   229: getfield 713	com/tencent/smtt/sdk/ag:z	Landroid/os/Handler;
    //   232: sipush 150
    //   235: aload 6
    //   237: invokevirtual 719	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   240: astore 7
    //   242: aload_0
    //   243: getfield 713	com/tencent/smtt/sdk/ag:z	Landroid/os/Handler;
    //   246: aload 7
    //   248: ldc2_w 720
    //   251: invokevirtual 725	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   254: pop
    //   255: iload_2
    //   256: ifeq +29 -> 285
    //   259: aload_0
    //   260: getfield 105	com/tencent/smtt/sdk/ag:A	Ljava/util/Set;
    //   263: aload 6
    //   265: invokeinterface 706 2 0
    //   270: ifeq +15 -> 285
    //   273: aload_0
    //   274: getfield 105	com/tencent/smtt/sdk/ag:A	Ljava/util/Set;
    //   277: aload 6
    //   279: invokeinterface 728 2 0
    //   284: pop
    //   285: iload_2
    //   286: ireturn
    //   287: iconst_0
    //   288: istore_3
    //   289: goto -264 -> 25
    //   292: iconst_0
    //   293: istore_2
    //   294: goto -118 -> 176
    //   297: astore 7
    //   299: goto -113 -> 186
    //   302: astore 7
    //   304: aconst_null
    //   305: astore 7
    //   307: aload 7
    //   309: ifnull +56 -> 365
    //   312: aload 7
    //   314: invokevirtual 320	java/net/HttpURLConnection:disconnect	()V
    //   317: iload 5
    //   319: istore_2
    //   320: goto -134 -> 186
    //   323: astore 7
    //   325: iload 5
    //   327: istore_2
    //   328: goto -142 -> 186
    //   331: astore 6
    //   333: aload 8
    //   335: astore 7
    //   337: aload 7
    //   339: ifnull +8 -> 347
    //   342: aload 7
    //   344: invokevirtual 320	java/net/HttpURLConnection:disconnect	()V
    //   347: aload 6
    //   349: athrow
    //   350: astore 7
    //   352: goto -5 -> 347
    //   355: astore 6
    //   357: goto -20 -> 337
    //   360: astore 8
    //   362: goto -55 -> 307
    //   365: iload 5
    //   367: istore_2
    //   368: goto -182 -> 186
    //   371: goto -185 -> 186
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	374	0	this	ag
    //   143	28	1	i1	int
    //   49	319	2	bool1	boolean
    //   24	265	3	bool2	boolean
    //   7	167	4	bool3	boolean
    //   10	356	5	bool4	boolean
    //   4	274	6	str	String
    //   331	17	6	localObject1	Object
    //   355	1	6	localObject2	Object
    //   102	145	7	localObject3	Object
    //   297	1	7	localException1	Exception
    //   302	1	7	localThrowable1	Throwable
    //   305	8	7	localObject4	Object
    //   323	1	7	localException2	Exception
    //   335	8	7	localObject5	Object
    //   350	1	7	localException3	Exception
    //   1	333	8	localObject6	Object
    //   360	1	8	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   181	186	297	java/lang/Exception
    //   86	104	302	java/lang/Throwable
    //   312	317	323	java/lang/Exception
    //   86	104	331	finally
    //   342	347	350	java/lang/Exception
    //   104	166	355	finally
    //   104	166	360	java/lang/Throwable
  }
  
  private void o()
  {
    if (this.z == null) {
      this.z = new ah(this, al.a().getLooper());
    }
  }
  
  public void a(int paramInt)
  {
    try
    {
      File localFile = new File(this.k, "x5.tbs");
      int i1 = a.a(this.g, localFile);
      if ((-1 == i1) || ((paramInt > 0) && (paramInt == i1))) {
        localFile.delete();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean a()
  {
    TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #1");
    try
    {
      File localFile1 = new File(j.a(this.g, 4), "x5.tbs.decouple");
      if (localFile1.exists()) {
        TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #2");
      }
      while (a.a(this.g, localFile1, 0L, TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_decouplecoreversion", -1)))
      {
        TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #3");
        return an.a().e(this.g);
        File localFile2 = TbsDownloader.b(TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_decouplecoreversion", -1));
        if ((localFile2 != null) && (localFile2.exists())) {
          j.b(localFile2, localFile1);
        }
      }
      TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup no backup file !!!");
      localFile1 = new File(j.a(this.g, 4), "x5.tbs.decouple");
      if (localFile1.exists()) {
        localFile1.delete();
      }
    }
    catch (Exception localException) {}
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if ((paramBoolean) && (!n()) && ((!QbSdk.getDownloadWithoutWifi()) || (!Apn.isNetworkAvailable(this.g)))) {}
    while ((this.b == null) || (this.c < 0) || (this.c >= this.b.length)) {
      return false;
    }
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
    return true;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    paramBoolean1 = true;
    int i1 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("use_backup_version", 0);
    int i2 = an.a().j(this.g);
    if (i1 == 0) {
      i1 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_download_version", 0);
    }
    for (this.a = "by default key"; (i1 == 0) || (i1 == i2); this.a = "by new key")
    {
      paramBoolean1 = false;
      return paramBoolean1;
    }
    if (paramBoolean2)
    {
      File localFile = TbsDownloader.a(i1);
      Object localObject;
      if ((localFile != null) && (localFile.exists()))
      {
        String str = j.a(this.g, 4);
        if (TbsDownloader.getOverSea(this.g))
        {
          localObject = "x5.oversea.tbs.org";
          label136:
          localObject = new File(str, (String)localObject);
        }
      }
      for (;;)
      {
        try
        {
          if (TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_download_version_type", 0) == 1) {
            break label331;
          }
          j.b(localFile, (File)localObject);
          i2 = 1;
          if (!h()) {
            break label357;
          }
          if (!b(i1)) {
            break label380;
          }
          TbsDownloadConfig.getInstance(this.g).a.put("tbs_download_interrupt_code_reason", Integer.valueOf(-214));
          TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-214);
          b(false);
          if (i2 == 0) {
            break;
          }
          a(100, "use local backup apk in startDownload" + this.a, true);
          if (TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_downloaddecouplecore", 0) != 1) {
            break label337;
          }
          TbsLogReport.getInstance(this.g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE, this.v);
          this.v.resetArgs();
          return true;
        }
        catch (Exception localException) {}
        localObject = "x5.tbs.org";
        break label136;
        label331:
        i2 = 0;
        continue;
        label337:
        TbsLogReport.getInstance(this.g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, this.v);
      }
      label357:
      i();
      if (!a.a(this.g, localFile, 0L, i1)) {
        j.b(localFile);
      }
    }
    label380:
    if (c(false, paramBoolean2))
    {
      TbsDownloadConfig.getInstance(this.g).a.put("tbs_download_interrupt_code_reason", Integer.valueOf(-214));
      TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-214);
      b(false);
      return true;
    }
    if ((!c(true)) && (!c(true)))
    {
      TbsLog.e("TbsDownload", "[TbsApkDownloader] delete file failed!");
      TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-301);
    }
    return false;
  }
  
  public int b()
  {
    File localFile = a(this.g);
    if (localFile == null) {
      return 0;
    }
    Context localContext = this.g;
    if (TbsDownloader.getOverSea(this.g)) {}
    for (String str = "x5.oversea.tbs.org";; str = "x5.tbs.org") {
      return a.a(localContext, new File(localFile, str));
    }
  }
  
  /* Error */
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: invokestatic 130	com/tencent/smtt/sdk/an:a	()Lcom/tencent/smtt/sdk/an;
    //   3: aload_0
    //   4: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   7: invokevirtual 795	com/tencent/smtt/sdk/an:c	(Landroid/content/Context;)Z
    //   10: ifeq +25 -> 35
    //   13: iload_1
    //   14: ifne +21 -> 35
    //   17: iconst_0
    //   18: putstatic 626	com/tencent/smtt/sdk/TbsDownloader:a	Z
    //   21: aload_0
    //   22: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   25: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   28: sipush -322
    //   31: invokevirtual 777	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   34: return
    //   35: aload_0
    //   36: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   39: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   42: getfield 287	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   45: ldc_w 404
    //   48: iconst_0
    //   49: invokeinterface 295 3 0
    //   54: istore_3
    //   55: iload_3
    //   56: iconst_1
    //   57: if_icmpeq +13 -> 70
    //   60: iload_3
    //   61: iconst_2
    //   62: if_icmpeq +8 -> 70
    //   65: iload_3
    //   66: iconst_4
    //   67: if_icmpne +25 -> 92
    //   70: iconst_1
    //   71: istore 8
    //   73: iload_2
    //   74: ifne +24 -> 98
    //   77: aload_0
    //   78: iload_1
    //   79: iload 8
    //   81: invokevirtual 797	com/tencent/smtt/sdk/ag:a	(ZZ)Z
    //   84: ifeq +14 -> 98
    //   87: iconst_0
    //   88: putstatic 626	com/tencent/smtt/sdk/TbsDownloader:a	Z
    //   91: return
    //   92: iconst_0
    //   93: istore 8
    //   95: goto -22 -> 73
    //   98: aload_0
    //   99: iload_1
    //   100: putfield 799	com/tencent/smtt/sdk/ag:C	Z
    //   103: aload_0
    //   104: aload_0
    //   105: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   108: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   111: getfield 287	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   114: ldc_w 801
    //   117: aconst_null
    //   118: invokeinterface 472 3 0
    //   123: putfield 803	com/tencent/smtt/sdk/ag:h	Ljava/lang/String;
    //   126: aload_0
    //   127: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   130: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   133: getfield 287	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   136: ldc_w 805
    //   139: aconst_null
    //   140: invokeinterface 472 3 0
    //   145: astore 29
    //   147: ldc 192
    //   149: new 107	java/lang/StringBuilder
    //   152: dup
    //   153: ldc_w 807
    //   156: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   159: aload 29
    //   161: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: iconst_1
    //   168: invokestatic 810	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   171: aload_0
    //   172: aconst_null
    //   173: putfield 78	com/tencent/smtt/sdk/ag:b	[Ljava/lang/String;
    //   176: aload_0
    //   177: iconst_0
    //   178: putfield 80	com/tencent/smtt/sdk/ag:c	I
    //   181: iload_1
    //   182: ifne +36 -> 218
    //   185: aload 29
    //   187: ifnull +31 -> 218
    //   190: ldc 250
    //   192: aload 29
    //   194: invokevirtual 813	java/lang/String:trim	()Ljava/lang/String;
    //   197: invokevirtual 479	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   200: ifne +18 -> 218
    //   203: aload_0
    //   204: aload 29
    //   206: invokevirtual 813	java/lang/String:trim	()Ljava/lang/String;
    //   209: ldc_w 815
    //   212: invokevirtual 819	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   215: putfield 78	com/tencent/smtt/sdk/ag:b	[Ljava/lang/String;
    //   218: ldc 192
    //   220: new 107	java/lang/StringBuilder
    //   223: dup
    //   224: ldc_w 821
    //   227: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   230: aload_0
    //   231: getfield 803	com/tencent/smtt/sdk/ag:h	Ljava/lang/String;
    //   234: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: ldc_w 823
    //   240: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: aload 29
    //   245: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: ldc_w 825
    //   251: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: aload_0
    //   255: getfield 556	com/tencent/smtt/sdk/ag:j	Ljava/lang/String;
    //   258: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: ldc_w 827
    //   264: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload_0
    //   268: getfield 560	com/tencent/smtt/sdk/ag:r	Z
    //   271: invokevirtual 463	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   274: ldc_w 829
    //   277: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: aload_0
    //   281: getfield 315	com/tencent/smtt/sdk/ag:t	Ljava/net/HttpURLConnection;
    //   284: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   287: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokestatic 453	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   293: aload_0
    //   294: getfield 803	com/tencent/smtt/sdk/ag:h	Ljava/lang/String;
    //   297: ifnonnull +34 -> 331
    //   300: aload_0
    //   301: getfield 556	com/tencent/smtt/sdk/ag:j	Ljava/lang/String;
    //   304: ifnonnull +27 -> 331
    //   307: getstatic 397	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   310: bipush 110
    //   312: invokeinterface 402 2 0
    //   317: aload_0
    //   318: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   321: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   324: sipush -302
    //   327: invokevirtual 777	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   330: return
    //   331: aload_0
    //   332: getfield 315	com/tencent/smtt/sdk/ag:t	Ljava/net/HttpURLConnection;
    //   335: ifnull +34 -> 369
    //   338: aload_0
    //   339: getfield 560	com/tencent/smtt/sdk/ag:r	Z
    //   342: ifne +27 -> 369
    //   345: getstatic 397	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   348: bipush 110
    //   350: invokeinterface 402 2 0
    //   355: aload_0
    //   356: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   359: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   362: sipush -303
    //   365: invokevirtual 777	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   368: return
    //   369: iload_1
    //   370: ifne +54 -> 424
    //   373: aload_0
    //   374: getfield 105	com/tencent/smtt/sdk/ag:A	Ljava/util/Set;
    //   377: aload_0
    //   378: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   381: invokestatic 684	com/tencent/smtt/utils/Apn:getWifiSSID	(Landroid/content/Context;)Ljava/lang/String;
    //   384: invokeinterface 706 2 0
    //   389: ifeq +35 -> 424
    //   392: ldc 192
    //   394: ldc_w 831
    //   397: invokestatic 453	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   400: getstatic 397	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   403: bipush 110
    //   405: invokeinterface 402 2 0
    //   410: aload_0
    //   411: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   414: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   417: sipush -304
    //   420: invokevirtual 777	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   423: return
    //   424: aload_0
    //   425: invokespecial 142	com/tencent/smtt/sdk/ag:f	()V
    //   428: ldc 192
    //   430: ldc_w 833
    //   433: iconst_1
    //   434: invokestatic 810	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   437: aload_0
    //   438: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   441: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   444: invokevirtual 836	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMaxflow	()J
    //   447: lstore 27
    //   449: iconst_0
    //   450: istore_2
    //   451: aload_0
    //   452: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   455: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   458: getfield 287	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   461: ldc_w 838
    //   464: lconst_0
    //   465: invokeinterface 496 4 0
    //   470: lstore 13
    //   472: iload_1
    //   473: ifeq +249 -> 722
    //   476: aload_0
    //   477: getstatic 51	com/tencent/smtt/sdk/ag:e	I
    //   480: putfield 76	com/tencent/smtt/sdk/ag:B	I
    //   483: iload_2
    //   484: istore 5
    //   486: aload_0
    //   487: getfield 253	com/tencent/smtt/sdk/ag:p	I
    //   490: aload_0
    //   491: getfield 76	com/tencent/smtt/sdk/ag:B	I
    //   494: if_icmpgt +36 -> 530
    //   497: aload_0
    //   498: getfield 550	com/tencent/smtt/sdk/ag:q	I
    //   501: bipush 8
    //   503: if_icmple +229 -> 732
    //   506: aload_0
    //   507: bipush 123
    //   509: aconst_null
    //   510: iconst_1
    //   511: invokespecial 546	com/tencent/smtt/sdk/ag:a	(ILjava/lang/String;Z)V
    //   514: aload_0
    //   515: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   518: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   521: sipush -306
    //   524: invokevirtual 777	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   527: iload_2
    //   528: istore 5
    //   530: aload_0
    //   531: getfield 560	com/tencent/smtt/sdk/ag:r	Z
    //   534: ifne +183 -> 717
    //   537: iload 5
    //   539: istore_1
    //   540: aload_0
    //   541: getfield 562	com/tencent/smtt/sdk/ag:s	Z
    //   544: ifeq +102 -> 646
    //   547: iload 5
    //   549: istore_1
    //   550: aload_0
    //   551: getfield 78	com/tencent/smtt/sdk/ag:b	[Ljava/lang/String;
    //   554: ifnonnull +19 -> 573
    //   557: iload 5
    //   559: istore_1
    //   560: iload 5
    //   562: ifne +11 -> 573
    //   565: aload_0
    //   566: iconst_1
    //   567: iload 8
    //   569: invokespecial 788	com/tencent/smtt/sdk/ag:c	(ZZ)Z
    //   572: istore_1
    //   573: aload_0
    //   574: getfield 100	com/tencent/smtt/sdk/ag:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   577: astore 29
    //   579: iload_1
    //   580: ifeq +5746 -> 6326
    //   583: iconst_1
    //   584: istore_3
    //   585: aload 29
    //   587: iload_3
    //   588: invokevirtual 841	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setUnpkgFlag	(I)V
    //   591: iload 8
    //   593: ifne +5743 -> 6336
    //   596: aload_0
    //   597: getfield 100	com/tencent/smtt/sdk/ag:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   600: astore 29
    //   602: iload_1
    //   603: ifeq +5728 -> 6331
    //   606: iconst_1
    //   607: istore_3
    //   608: aload 29
    //   610: iload_3
    //   611: invokevirtual 844	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setPatchUpdateFlag	(I)V
    //   614: iload_1
    //   615: ifeq +5732 -> 6347
    //   618: aload_0
    //   619: iconst_1
    //   620: invokespecial 779	com/tencent/smtt/sdk/ag:b	(Z)V
    //   623: aload_0
    //   624: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   627: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   630: sipush -317
    //   633: invokevirtual 777	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   636: aload_0
    //   637: bipush 100
    //   639: ldc_w 846
    //   642: iconst_1
    //   643: invokespecial 546	com/tencent/smtt/sdk/ag:a	(ILjava/lang/String;Z)V
    //   646: aload_0
    //   647: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   650: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   653: astore 29
    //   655: iload_1
    //   656: ifeq +5713 -> 6369
    //   659: aload 29
    //   661: getfield 287	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   664: ldc_w 848
    //   667: iconst_0
    //   668: invokeinterface 295 3 0
    //   673: istore_3
    //   674: aload 29
    //   676: getfield 366	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   679: ldc_w 848
    //   682: iload_3
    //   683: iconst_1
    //   684: iadd
    //   685: invokestatic 389	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   688: invokeinterface 380 3 0
    //   693: pop
    //   694: aload 29
    //   696: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   699: aload_0
    //   700: getfield 100	com/tencent/smtt/sdk/ag:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   703: astore 29
    //   705: iload_1
    //   706: ifeq +5724 -> 6430
    //   709: iconst_1
    //   710: istore_3
    //   711: aload 29
    //   713: iload_3
    //   714: invokevirtual 851	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownFinalFlag	(I)V
    //   717: aload_0
    //   718: invokespecial 853	com/tencent/smtt/sdk/ag:g	()V
    //   721: return
    //   722: aload_0
    //   723: getstatic 49	com/tencent/smtt/sdk/ag:d	I
    //   726: putfield 76	com/tencent/smtt/sdk/ag:B	I
    //   729: goto -246 -> 483
    //   732: invokestatic 153	java/lang/System:currentTimeMillis	()J
    //   735: lstore 23
    //   737: lload 13
    //   739: lstore 9
    //   741: iload_1
    //   742: ifne +446 -> 1188
    //   745: lload 13
    //   747: lstore 15
    //   749: iload_2
    //   750: istore 5
    //   752: lload 13
    //   754: lstore 11
    //   756: lload 23
    //   758: aload_0
    //   759: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   762: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   765: getfield 287	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   768: ldc_w 855
    //   771: lconst_0
    //   772: invokeinterface 496 4 0
    //   777: lsub
    //   778: ldc2_w 856
    //   781: lcmp
    //   782: ifle +250 -> 1032
    //   785: lload 13
    //   787: lstore 15
    //   789: iload_2
    //   790: istore 5
    //   792: lload 13
    //   794: lstore 11
    //   796: ldc 192
    //   798: ldc_w 859
    //   801: invokestatic 453	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   804: lload 13
    //   806: lstore 15
    //   808: iload_2
    //   809: istore 5
    //   811: lload 13
    //   813: lstore 11
    //   815: aload_0
    //   816: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   819: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   822: getfield 366	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   825: ldc_w 855
    //   828: lload 23
    //   830: invokestatic 864	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   833: invokeinterface 380 3 0
    //   838: pop
    //   839: lload 13
    //   841: lstore 15
    //   843: iload_2
    //   844: istore 5
    //   846: lload 13
    //   848: lstore 11
    //   850: aload_0
    //   851: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   854: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   857: getfield 366	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   860: ldc_w 838
    //   863: lconst_0
    //   864: invokestatic 864	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   867: invokeinterface 380 3 0
    //   872: pop
    //   873: lload 13
    //   875: lstore 15
    //   877: iload_2
    //   878: istore 5
    //   880: lload 13
    //   882: lstore 11
    //   884: aload_0
    //   885: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   888: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   891: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   894: lconst_0
    //   895: lstore 17
    //   897: lload 17
    //   899: lstore 9
    //   901: lload 17
    //   903: lstore 15
    //   905: iload_2
    //   906: istore 5
    //   908: lload 17
    //   910: lstore 11
    //   912: aload_0
    //   913: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   916: invokestatic 866	com/tencent/smtt/utils/j:b	(Landroid/content/Context;)Z
    //   919: ifne +269 -> 1188
    //   922: lload 17
    //   924: lstore 15
    //   926: iload_2
    //   927: istore 5
    //   929: lload 17
    //   931: lstore 11
    //   933: ldc 192
    //   935: ldc_w 868
    //   938: iconst_1
    //   939: invokestatic 810	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   942: lload 17
    //   944: lstore 15
    //   946: iload_2
    //   947: istore 5
    //   949: lload 17
    //   951: lstore 11
    //   953: aload_0
    //   954: bipush 105
    //   956: aconst_null
    //   957: iconst_1
    //   958: invokespecial 546	com/tencent/smtt/sdk/ag:a	(ILjava/lang/String;Z)V
    //   961: lload 17
    //   963: lstore 15
    //   965: iload_2
    //   966: istore 5
    //   968: lload 17
    //   970: lstore 11
    //   972: aload_0
    //   973: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   976: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   979: sipush -308
    //   982: invokevirtual 777	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   985: iload_2
    //   986: istore 5
    //   988: iload_1
    //   989: ifne -459 -> 530
    //   992: aload_0
    //   993: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   996: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   999: getfield 366	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   1002: ldc_w 838
    //   1005: lload 17
    //   1007: invokestatic 864	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1010: invokeinterface 380 3 0
    //   1015: pop
    //   1016: aload_0
    //   1017: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   1020: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1023: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1026: iload_2
    //   1027: istore 5
    //   1029: goto -499 -> 530
    //   1032: lload 13
    //   1034: lstore 15
    //   1036: iload_2
    //   1037: istore 5
    //   1039: lload 13
    //   1041: lstore 11
    //   1043: ldc 192
    //   1045: new 107	java/lang/StringBuilder
    //   1048: dup
    //   1049: ldc_w 870
    //   1052: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1055: lload 13
    //   1057: invokevirtual 505	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1060: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1063: invokestatic 453	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1066: lload 13
    //   1068: lstore 17
    //   1070: lload 13
    //   1072: lload 27
    //   1074: lcmp
    //   1075: iflt -178 -> 897
    //   1078: lload 13
    //   1080: lstore 15
    //   1082: iload_2
    //   1083: istore 5
    //   1085: lload 13
    //   1087: lstore 11
    //   1089: ldc 192
    //   1091: ldc_w 872
    //   1094: iconst_1
    //   1095: invokestatic 810	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1098: lload 13
    //   1100: lstore 15
    //   1102: iload_2
    //   1103: istore 5
    //   1105: lload 13
    //   1107: lstore 11
    //   1109: aload_0
    //   1110: bipush 112
    //   1112: aconst_null
    //   1113: iconst_1
    //   1114: invokespecial 546	com/tencent/smtt/sdk/ag:a	(ILjava/lang/String;Z)V
    //   1117: lload 13
    //   1119: lstore 15
    //   1121: iload_2
    //   1122: istore 5
    //   1124: lload 13
    //   1126: lstore 11
    //   1128: aload_0
    //   1129: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   1132: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1135: sipush -307
    //   1138: invokevirtual 777	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   1141: iload_2
    //   1142: istore 5
    //   1144: iload_1
    //   1145: ifne -615 -> 530
    //   1148: aload_0
    //   1149: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   1152: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1155: getfield 366	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   1158: ldc_w 838
    //   1161: lload 13
    //   1163: invokestatic 864	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1166: invokeinterface 380 3 0
    //   1171: pop
    //   1172: aload_0
    //   1173: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   1176: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1179: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1182: iload_2
    //   1183: istore 5
    //   1185: goto -655 -> 530
    //   1188: lload 9
    //   1190: lstore 15
    //   1192: iload_2
    //   1193: istore 5
    //   1195: lload 9
    //   1197: lstore 11
    //   1199: aload_0
    //   1200: iconst_1
    //   1201: putfield 564	com/tencent/smtt/sdk/ag:y	Z
    //   1204: lload 9
    //   1206: lstore 15
    //   1208: iload_2
    //   1209: istore 5
    //   1211: lload 9
    //   1213: lstore 11
    //   1215: aload_0
    //   1216: getfield 556	com/tencent/smtt/sdk/ag:j	Ljava/lang/String;
    //   1219: ifnull +830 -> 2049
    //   1222: lload 9
    //   1224: lstore 15
    //   1226: iload_2
    //   1227: istore 5
    //   1229: lload 9
    //   1231: lstore 11
    //   1233: aload_0
    //   1234: getfield 556	com/tencent/smtt/sdk/ag:j	Ljava/lang/String;
    //   1237: astore 29
    //   1239: lload 9
    //   1241: lstore 15
    //   1243: iload_2
    //   1244: istore 5
    //   1246: lload 9
    //   1248: lstore 11
    //   1250: ldc 192
    //   1252: new 107	java/lang/StringBuilder
    //   1255: dup
    //   1256: ldc_w 874
    //   1259: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1262: aload 29
    //   1264: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1267: ldc_w 876
    //   1270: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1273: aload_0
    //   1274: getfield 253	com/tencent/smtt/sdk/ag:p	I
    //   1277: invokevirtual 516	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1280: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1283: iconst_1
    //   1284: invokestatic 810	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1287: lload 9
    //   1289: lstore 15
    //   1291: iload_2
    //   1292: istore 5
    //   1294: lload 9
    //   1296: lstore 11
    //   1298: aload 29
    //   1300: aload_0
    //   1301: getfield 878	com/tencent/smtt/sdk/ag:i	Ljava/lang/String;
    //   1304: invokevirtual 479	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1307: ifne +23 -> 1330
    //   1310: lload 9
    //   1312: lstore 15
    //   1314: iload_2
    //   1315: istore 5
    //   1317: lload 9
    //   1319: lstore 11
    //   1321: aload_0
    //   1322: getfield 100	com/tencent/smtt/sdk/ag:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   1325: aload 29
    //   1327: invokevirtual 881	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownloadUrl	(Ljava/lang/String;)V
    //   1330: lload 9
    //   1332: lstore 15
    //   1334: iload_2
    //   1335: istore 5
    //   1337: lload 9
    //   1339: lstore 11
    //   1341: aload_0
    //   1342: aload 29
    //   1344: putfield 878	com/tencent/smtt/sdk/ag:i	Ljava/lang/String;
    //   1347: lload 9
    //   1349: lstore 15
    //   1351: iload_2
    //   1352: istore 5
    //   1354: lload 9
    //   1356: lstore 11
    //   1358: aload_0
    //   1359: aload 29
    //   1361: invokespecial 883	com/tencent/smtt/sdk/ag:a	(Ljava/lang/String;)V
    //   1364: lconst_0
    //   1365: lstore 13
    //   1367: lload 9
    //   1369: lstore 15
    //   1371: iload_2
    //   1372: istore 5
    //   1374: lload 9
    //   1376: lstore 11
    //   1378: aload_0
    //   1379: getfield 558	com/tencent/smtt/sdk/ag:o	Z
    //   1382: ifne +154 -> 1536
    //   1385: lload 9
    //   1387: lstore 15
    //   1389: iload_2
    //   1390: istore 5
    //   1392: lload 9
    //   1394: lstore 11
    //   1396: aload_0
    //   1397: invokespecial 885	com/tencent/smtt/sdk/ag:k	()J
    //   1400: lstore 13
    //   1402: lload 9
    //   1404: lstore 15
    //   1406: iload_2
    //   1407: istore 5
    //   1409: lload 9
    //   1411: lstore 11
    //   1413: ldc 192
    //   1415: new 107	java/lang/StringBuilder
    //   1418: dup
    //   1419: ldc_w 887
    //   1422: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1425: lload 13
    //   1427: invokevirtual 505	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1430: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1433: invokestatic 453	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1436: lload 9
    //   1438: lstore 15
    //   1440: iload_2
    //   1441: istore 5
    //   1443: lload 9
    //   1445: lstore 11
    //   1447: aload_0
    //   1448: getfield 554	com/tencent/smtt/sdk/ag:l	J
    //   1451: lconst_0
    //   1452: lcmp
    //   1453: ifgt +616 -> 2069
    //   1456: lload 9
    //   1458: lstore 15
    //   1460: iload_2
    //   1461: istore 5
    //   1463: lload 9
    //   1465: lstore 11
    //   1467: ldc 192
    //   1469: new 107	java/lang/StringBuilder
    //   1472: dup
    //   1473: ldc_w 889
    //   1476: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1479: lload 13
    //   1481: invokevirtual 505	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1484: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1487: iconst_1
    //   1488: invokestatic 810	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1491: lload 9
    //   1493: lstore 15
    //   1495: iload_2
    //   1496: istore 5
    //   1498: lload 9
    //   1500: lstore 11
    //   1502: aload_0
    //   1503: getfield 315	com/tencent/smtt/sdk/ag:t	Ljava/net/HttpURLConnection;
    //   1506: ldc_w 891
    //   1509: new 107	java/lang/StringBuilder
    //   1512: dup
    //   1513: ldc_w 893
    //   1516: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1519: lload 13
    //   1521: invokevirtual 505	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1524: ldc_w 895
    //   1527: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1530: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1533: invokevirtual 332	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1536: lload 9
    //   1538: lstore 15
    //   1540: iload_2
    //   1541: istore 5
    //   1543: lload 9
    //   1545: lstore 11
    //   1547: aload_0
    //   1548: getfield 100	com/tencent/smtt/sdk/ag:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   1551: astore 29
    //   1553: lload 13
    //   1555: lconst_0
    //   1556: lcmp
    //   1557: ifne +787 -> 2344
    //   1560: iconst_0
    //   1561: istore_3
    //   1562: lload 9
    //   1564: lstore 15
    //   1566: iload_2
    //   1567: istore 5
    //   1569: lload 9
    //   1571: lstore 11
    //   1573: aload 29
    //   1575: iload_3
    //   1576: invokevirtual 898	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownloadCancel	(I)V
    //   1579: lload 9
    //   1581: lstore 15
    //   1583: iload_2
    //   1584: istore 5
    //   1586: lload 9
    //   1588: lstore 11
    //   1590: aload_0
    //   1591: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   1594: invokestatic 589	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   1597: istore_3
    //   1598: lload 9
    //   1600: lstore 15
    //   1602: iload_2
    //   1603: istore 5
    //   1605: lload 9
    //   1607: lstore 11
    //   1609: aload_0
    //   1610: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   1613: invokestatic 585	com/tencent/smtt/utils/Apn:getApnInfo	(Landroid/content/Context;)Ljava/lang/String;
    //   1616: astore 29
    //   1618: lload 9
    //   1620: lstore 15
    //   1622: iload_2
    //   1623: istore 5
    //   1625: lload 9
    //   1627: lstore 11
    //   1629: aload_0
    //   1630: getfield 144	com/tencent/smtt/sdk/ag:w	Ljava/lang/String;
    //   1633: ifnonnull +716 -> 2349
    //   1636: lload 9
    //   1638: lstore 15
    //   1640: iload_2
    //   1641: istore 5
    //   1643: lload 9
    //   1645: lstore 11
    //   1647: aload_0
    //   1648: getfield 146	com/tencent/smtt/sdk/ag:x	I
    //   1651: iconst_m1
    //   1652: if_icmpne +697 -> 2349
    //   1655: lload 9
    //   1657: lstore 15
    //   1659: iload_2
    //   1660: istore 5
    //   1662: lload 9
    //   1664: lstore 11
    //   1666: aload_0
    //   1667: aload 29
    //   1669: putfield 144	com/tencent/smtt/sdk/ag:w	Ljava/lang/String;
    //   1672: lload 9
    //   1674: lstore 15
    //   1676: iload_2
    //   1677: istore 5
    //   1679: lload 9
    //   1681: lstore 11
    //   1683: aload_0
    //   1684: iload_3
    //   1685: putfield 146	com/tencent/smtt/sdk/ag:x	I
    //   1688: lload 9
    //   1690: lstore 15
    //   1692: iload_2
    //   1693: istore 5
    //   1695: lload 9
    //   1697: lstore 11
    //   1699: aload_0
    //   1700: getfield 253	com/tencent/smtt/sdk/ag:p	I
    //   1703: ifle +28 -> 1731
    //   1706: lload 9
    //   1708: lstore 15
    //   1710: iload_2
    //   1711: istore 5
    //   1713: lload 9
    //   1715: lstore 11
    //   1717: aload_0
    //   1718: getfield 315	com/tencent/smtt/sdk/ag:t	Ljava/net/HttpURLConnection;
    //   1721: ldc_w 900
    //   1724: aload_0
    //   1725: getfield 803	com/tencent/smtt/sdk/ag:h	Ljava/lang/String;
    //   1728: invokevirtual 903	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1731: lload 9
    //   1733: lstore 15
    //   1735: iload_2
    //   1736: istore 5
    //   1738: lload 9
    //   1740: lstore 11
    //   1742: aload_0
    //   1743: getfield 315	com/tencent/smtt/sdk/ag:t	Ljava/net/HttpURLConnection;
    //   1746: invokevirtual 695	java/net/HttpURLConnection:getResponseCode	()I
    //   1749: istore_3
    //   1750: lload 9
    //   1752: lstore 15
    //   1754: iload_2
    //   1755: istore 5
    //   1757: lload 9
    //   1759: lstore 11
    //   1761: ldc 192
    //   1763: new 107	java/lang/StringBuilder
    //   1766: dup
    //   1767: ldc_w 905
    //   1770: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1773: iload_3
    //   1774: invokevirtual 516	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1777: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1780: invokestatic 453	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1783: lload 9
    //   1785: lstore 15
    //   1787: iload_2
    //   1788: istore 5
    //   1790: lload 9
    //   1792: lstore 11
    //   1794: aload_0
    //   1795: getfield 100	com/tencent/smtt/sdk/ag:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   1798: iload_3
    //   1799: invokevirtual 908	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setHttpCode	(I)V
    //   1802: iload_1
    //   1803: ifne +157 -> 1960
    //   1806: lload 9
    //   1808: lstore 15
    //   1810: iload_2
    //   1811: istore 5
    //   1813: lload 9
    //   1815: lstore 11
    //   1817: aload_0
    //   1818: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   1821: invokestatic 210	com/tencent/smtt/sdk/TbsDownloader:getOverSea	(Landroid/content/Context;)Z
    //   1824: ifne +136 -> 1960
    //   1827: lload 9
    //   1829: lstore 15
    //   1831: iload_2
    //   1832: istore 5
    //   1834: lload 9
    //   1836: lstore 11
    //   1838: aload_0
    //   1839: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   1842: invokestatic 589	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   1845: iconst_3
    //   1846: if_icmpeq +20 -> 1866
    //   1849: lload 9
    //   1851: lstore 15
    //   1853: iload_2
    //   1854: istore 5
    //   1856: lload 9
    //   1858: lstore 11
    //   1860: invokestatic 760	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   1863: ifeq +24 -> 1887
    //   1866: lload 9
    //   1868: lstore 15
    //   1870: iload_2
    //   1871: istore 5
    //   1873: lload 9
    //   1875: lstore 11
    //   1877: aload_0
    //   1878: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   1881: invokestatic 589	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   1884: ifne +76 -> 1960
    //   1887: lload 9
    //   1889: lstore 15
    //   1891: iload_2
    //   1892: istore 5
    //   1894: lload 9
    //   1896: lstore 11
    //   1898: aload_0
    //   1899: invokevirtual 910	com/tencent/smtt/sdk/ag:c	()V
    //   1902: lload 9
    //   1904: lstore 15
    //   1906: iload_2
    //   1907: istore 5
    //   1909: lload 9
    //   1911: lstore 11
    //   1913: getstatic 397	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   1916: ifnull +24 -> 1940
    //   1919: lload 9
    //   1921: lstore 15
    //   1923: iload_2
    //   1924: istore 5
    //   1926: lload 9
    //   1928: lstore 11
    //   1930: getstatic 397	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   1933: bipush 111
    //   1935: invokeinterface 402 2 0
    //   1940: lload 9
    //   1942: lstore 15
    //   1944: iload_2
    //   1945: istore 5
    //   1947: lload 9
    //   1949: lstore 11
    //   1951: ldc 192
    //   1953: ldc_w 912
    //   1956: iconst_0
    //   1957: invokestatic 810	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1960: lload 9
    //   1962: lstore 15
    //   1964: iload_2
    //   1965: istore 5
    //   1967: lload 9
    //   1969: lstore 11
    //   1971: aload_0
    //   1972: getfield 560	com/tencent/smtt/sdk/ag:r	Z
    //   1975: ifeq +518 -> 2493
    //   1978: lload 9
    //   1980: lstore 15
    //   1982: iload_2
    //   1983: istore 5
    //   1985: lload 9
    //   1987: lstore 11
    //   1989: aload_0
    //   1990: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   1993: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1996: sipush -309
    //   1999: invokevirtual 777	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2002: iload_2
    //   2003: istore 5
    //   2005: iload_1
    //   2006: ifne -1476 -> 530
    //   2009: aload_0
    //   2010: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   2013: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2016: getfield 366	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2019: ldc_w 838
    //   2022: lload 9
    //   2024: invokestatic 864	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2027: invokeinterface 380 3 0
    //   2032: pop
    //   2033: aload_0
    //   2034: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   2037: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2040: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2043: iload_2
    //   2044: istore 5
    //   2046: goto -1516 -> 530
    //   2049: lload 9
    //   2051: lstore 15
    //   2053: iload_2
    //   2054: istore 5
    //   2056: lload 9
    //   2058: lstore 11
    //   2060: aload_0
    //   2061: getfield 803	com/tencent/smtt/sdk/ag:h	Ljava/lang/String;
    //   2064: astore 29
    //   2066: goto -827 -> 1239
    //   2069: lload 9
    //   2071: lstore 15
    //   2073: iload_2
    //   2074: istore 5
    //   2076: lload 9
    //   2078: lstore 11
    //   2080: ldc 192
    //   2082: new 107	java/lang/StringBuilder
    //   2085: dup
    //   2086: ldc_w 914
    //   2089: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2092: lload 13
    //   2094: invokevirtual 505	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2097: ldc_w 916
    //   2100: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2103: aload_0
    //   2104: getfield 554	com/tencent/smtt/sdk/ag:l	J
    //   2107: invokevirtual 505	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2110: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2113: iconst_1
    //   2114: invokestatic 810	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   2117: lload 9
    //   2119: lstore 15
    //   2121: iload_2
    //   2122: istore 5
    //   2124: lload 9
    //   2126: lstore 11
    //   2128: aload_0
    //   2129: getfield 315	com/tencent/smtt/sdk/ag:t	Ljava/net/HttpURLConnection;
    //   2132: ldc_w 891
    //   2135: new 107	java/lang/StringBuilder
    //   2138: dup
    //   2139: ldc_w 893
    //   2142: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2145: lload 13
    //   2147: invokevirtual 505	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2150: ldc_w 895
    //   2153: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2156: aload_0
    //   2157: getfield 554	com/tencent/smtt/sdk/ag:l	J
    //   2160: invokevirtual 505	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2163: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2166: invokevirtual 332	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   2169: goto -633 -> 1536
    //   2172: astore 29
    //   2174: iload 5
    //   2176: istore 6
    //   2178: lload 15
    //   2180: lstore 11
    //   2182: aload 29
    //   2184: instanceof 918
    //   2187: ifeq +4036 -> 6223
    //   2190: iload_1
    //   2191: ifne +4032 -> 6223
    //   2194: lload 15
    //   2196: lstore 11
    //   2198: aload_0
    //   2199: getfield 78	com/tencent/smtt/sdk/ag:b	[Ljava/lang/String;
    //   2202: ifnull +4021 -> 6223
    //   2205: lload 15
    //   2207: lstore 11
    //   2209: aload_0
    //   2210: iconst_0
    //   2211: invokevirtual 920	com/tencent/smtt/sdk/ag:a	(Z)Z
    //   2214: ifeq +4009 -> 6223
    //   2217: lload 15
    //   2219: lstore 11
    //   2221: ldc 192
    //   2223: new 107	java/lang/StringBuilder
    //   2226: dup
    //   2227: ldc_w 922
    //   2230: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2233: aload_0
    //   2234: getfield 556	com/tencent/smtt/sdk/ag:j	Ljava/lang/String;
    //   2237: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2240: ldc_w 924
    //   2243: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2246: aload 29
    //   2248: invokevirtual 354	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2251: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2254: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2257: invokestatic 202	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2260: lload 15
    //   2262: lstore 11
    //   2264: aload_0
    //   2265: bipush 125
    //   2267: aconst_null
    //   2268: iconst_1
    //   2269: invokespecial 546	com/tencent/smtt/sdk/ag:a	(ILjava/lang/String;Z)V
    //   2272: lload 15
    //   2274: lstore 11
    //   2276: aload_0
    //   2277: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   2280: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2283: sipush -316
    //   2286: invokevirtual 777	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2289: lload 15
    //   2291: lstore 13
    //   2293: iload 6
    //   2295: istore_2
    //   2296: iload_1
    //   2297: ifne -1814 -> 483
    //   2300: aload_0
    //   2301: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   2304: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2307: getfield 366	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2310: ldc_w 838
    //   2313: lload 15
    //   2315: invokestatic 864	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2318: invokeinterface 380 3 0
    //   2323: pop
    //   2324: aload_0
    //   2325: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   2328: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2331: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2334: lload 15
    //   2336: lstore 13
    //   2338: iload 6
    //   2340: istore_2
    //   2341: goto -1858 -> 483
    //   2344: iconst_1
    //   2345: istore_3
    //   2346: goto -784 -> 1562
    //   2349: lload 9
    //   2351: lstore 15
    //   2353: iload_2
    //   2354: istore 5
    //   2356: lload 9
    //   2358: lstore 11
    //   2360: iload_3
    //   2361: aload_0
    //   2362: getfield 146	com/tencent/smtt/sdk/ag:x	I
    //   2365: if_icmpne +26 -> 2391
    //   2368: lload 9
    //   2370: lstore 15
    //   2372: iload_2
    //   2373: istore 5
    //   2375: lload 9
    //   2377: lstore 11
    //   2379: aload 29
    //   2381: aload_0
    //   2382: getfield 144	com/tencent/smtt/sdk/ag:w	Ljava/lang/String;
    //   2385: invokevirtual 479	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2388: ifne -700 -> 1688
    //   2391: lload 9
    //   2393: lstore 15
    //   2395: iload_2
    //   2396: istore 5
    //   2398: lload 9
    //   2400: lstore 11
    //   2402: aload_0
    //   2403: getfield 100	com/tencent/smtt/sdk/ag:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   2406: iconst_0
    //   2407: invokevirtual 598	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setNetworkChange	(I)V
    //   2410: lload 9
    //   2412: lstore 15
    //   2414: iload_2
    //   2415: istore 5
    //   2417: lload 9
    //   2419: lstore 11
    //   2421: aload_0
    //   2422: aload 29
    //   2424: putfield 144	com/tencent/smtt/sdk/ag:w	Ljava/lang/String;
    //   2427: lload 9
    //   2429: lstore 15
    //   2431: iload_2
    //   2432: istore 5
    //   2434: lload 9
    //   2436: lstore 11
    //   2438: aload_0
    //   2439: iload_3
    //   2440: putfield 146	com/tencent/smtt/sdk/ag:x	I
    //   2443: goto -755 -> 1688
    //   2446: astore 29
    //   2448: lload 11
    //   2450: lstore 9
    //   2452: iload_1
    //   2453: ifne +37 -> 2490
    //   2456: aload_0
    //   2457: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   2460: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2463: getfield 366	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2466: ldc_w 838
    //   2469: lload 9
    //   2471: invokestatic 864	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2474: invokeinterface 380 3 0
    //   2479: pop
    //   2480: aload_0
    //   2481: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   2484: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2487: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2490: aload 29
    //   2492: athrow
    //   2493: iload_3
    //   2494: sipush 200
    //   2497: if_icmpeq +10 -> 2507
    //   2500: iload_3
    //   2501: sipush 206
    //   2504: if_icmpne +2532 -> 5036
    //   2507: lload 9
    //   2509: lstore 15
    //   2511: iload_2
    //   2512: istore 5
    //   2514: lload 9
    //   2516: lstore 11
    //   2518: aload_0
    //   2519: aload_0
    //   2520: getfield 315	com/tencent/smtt/sdk/ag:t	Ljava/net/HttpURLConnection;
    //   2523: invokevirtual 927	java/net/HttpURLConnection:getContentLength	()I
    //   2526: i2l
    //   2527: lload 13
    //   2529: ladd
    //   2530: putfield 554	com/tencent/smtt/sdk/ag:l	J
    //   2533: lload 9
    //   2535: lstore 15
    //   2537: iload_2
    //   2538: istore 5
    //   2540: lload 9
    //   2542: lstore 11
    //   2544: ldc 192
    //   2546: new 107	java/lang/StringBuilder
    //   2549: dup
    //   2550: ldc_w 929
    //   2553: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2556: aload_0
    //   2557: getfield 554	com/tencent/smtt/sdk/ag:l	J
    //   2560: invokevirtual 505	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2563: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2566: invokestatic 453	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2569: lload 9
    //   2571: lstore 15
    //   2573: iload_2
    //   2574: istore 5
    //   2576: lload 9
    //   2578: lstore 11
    //   2580: aload_0
    //   2581: getfield 100	com/tencent/smtt/sdk/ag:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   2584: aload_0
    //   2585: getfield 554	com/tencent/smtt/sdk/ag:l	J
    //   2588: invokevirtual 932	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setPkgSize	(J)V
    //   2591: lload 9
    //   2593: lstore 15
    //   2595: iload_2
    //   2596: istore 5
    //   2598: lload 9
    //   2600: lstore 11
    //   2602: aload_0
    //   2603: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   2606: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2609: getfield 287	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   2612: ldc_w 492
    //   2615: lconst_0
    //   2616: invokeinterface 496 4 0
    //   2621: lstore 17
    //   2623: lload 17
    //   2625: lconst_0
    //   2626: lcmp
    //   2627: ifeq +390 -> 3017
    //   2630: lload 9
    //   2632: lstore 15
    //   2634: iload_2
    //   2635: istore 5
    //   2637: lload 9
    //   2639: lstore 11
    //   2641: aload_0
    //   2642: getfield 554	com/tencent/smtt/sdk/ag:l	J
    //   2645: lload 17
    //   2647: lcmp
    //   2648: ifeq +369 -> 3017
    //   2651: lload 9
    //   2653: lstore 15
    //   2655: iload_2
    //   2656: istore 5
    //   2658: lload 9
    //   2660: lstore 11
    //   2662: ldc 192
    //   2664: new 107	java/lang/StringBuilder
    //   2667: dup
    //   2668: ldc_w 934
    //   2671: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2674: lload 17
    //   2676: invokevirtual 505	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2679: ldc_w 936
    //   2682: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2685: aload_0
    //   2686: getfield 554	com/tencent/smtt/sdk/ag:l	J
    //   2689: invokevirtual 505	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2692: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2695: iconst_1
    //   2696: invokestatic 810	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   2699: iload_1
    //   2700: ifne +269 -> 2969
    //   2703: lload 9
    //   2705: lstore 15
    //   2707: iload_2
    //   2708: istore 5
    //   2710: lload 9
    //   2712: lstore 11
    //   2714: aload_0
    //   2715: invokespecial 357	com/tencent/smtt/sdk/ag:n	()Z
    //   2718: ifne +41 -> 2759
    //   2721: lload 9
    //   2723: lstore 15
    //   2725: iload_2
    //   2726: istore 5
    //   2728: lload 9
    //   2730: lstore 11
    //   2732: invokestatic 760	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   2735: ifeq +234 -> 2969
    //   2738: lload 9
    //   2740: lstore 15
    //   2742: iload_2
    //   2743: istore 5
    //   2745: lload 9
    //   2747: lstore 11
    //   2749: aload_0
    //   2750: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   2753: invokestatic 604	com/tencent/smtt/utils/Apn:isNetworkAvailable	(Landroid/content/Context;)Z
    //   2756: ifeq +213 -> 2969
    //   2759: lload 9
    //   2761: lstore 15
    //   2763: iload_2
    //   2764: istore 5
    //   2766: lload 9
    //   2768: lstore 11
    //   2770: aload_0
    //   2771: getfield 78	com/tencent/smtt/sdk/ag:b	[Ljava/lang/String;
    //   2774: ifnull +75 -> 2849
    //   2777: lload 9
    //   2779: lstore 15
    //   2781: iload_2
    //   2782: istore 5
    //   2784: lload 9
    //   2786: lstore 11
    //   2788: aload_0
    //   2789: iconst_0
    //   2790: invokevirtual 920	com/tencent/smtt/sdk/ag:a	(Z)Z
    //   2793: istore 6
    //   2795: iload 6
    //   2797: ifeq +52 -> 2849
    //   2800: lload 9
    //   2802: lstore 13
    //   2804: iload_1
    //   2805: ifne -2322 -> 483
    //   2808: aload_0
    //   2809: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   2812: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2815: getfield 366	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2818: ldc_w 838
    //   2821: lload 9
    //   2823: invokestatic 864	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2826: invokeinterface 380 3 0
    //   2831: pop
    //   2832: aload_0
    //   2833: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   2836: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2839: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2842: lload 9
    //   2844: lstore 13
    //   2846: goto -2363 -> 483
    //   2849: lload 9
    //   2851: lstore 15
    //   2853: iload_2
    //   2854: istore 5
    //   2856: lload 9
    //   2858: lstore 11
    //   2860: aload_0
    //   2861: bipush 113
    //   2863: new 107	java/lang/StringBuilder
    //   2866: dup
    //   2867: ldc_w 938
    //   2870: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2873: lload 17
    //   2875: invokevirtual 505	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2878: ldc_w 936
    //   2881: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2884: aload_0
    //   2885: getfield 554	com/tencent/smtt/sdk/ag:l	J
    //   2888: invokevirtual 505	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2891: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2894: iconst_1
    //   2895: invokespecial 546	com/tencent/smtt/sdk/ag:a	(ILjava/lang/String;Z)V
    //   2898: lload 9
    //   2900: lstore 15
    //   2902: iload_2
    //   2903: istore 5
    //   2905: lload 9
    //   2907: lstore 11
    //   2909: aload_0
    //   2910: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   2913: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2916: sipush -310
    //   2919: invokevirtual 777	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2922: iload_2
    //   2923: istore 5
    //   2925: iload_1
    //   2926: ifne -2396 -> 530
    //   2929: aload_0
    //   2930: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   2933: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2936: getfield 366	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2939: ldc_w 838
    //   2942: lload 9
    //   2944: invokestatic 864	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2947: invokeinterface 380 3 0
    //   2952: pop
    //   2953: aload_0
    //   2954: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   2957: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2960: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2963: iload_2
    //   2964: istore 5
    //   2966: goto -2436 -> 530
    //   2969: lload 9
    //   2971: lstore 15
    //   2973: iload_2
    //   2974: istore 5
    //   2976: lload 9
    //   2978: lstore 11
    //   2980: aload_0
    //   2981: bipush 101
    //   2983: ldc_w 940
    //   2986: iconst_1
    //   2987: invokespecial 546	com/tencent/smtt/sdk/ag:a	(ILjava/lang/String;Z)V
    //   2990: lload 9
    //   2992: lstore 15
    //   2994: iload_2
    //   2995: istore 5
    //   2997: lload 9
    //   2999: lstore 11
    //   3001: aload_0
    //   3002: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   3005: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3008: sipush -304
    //   3011: invokevirtual 777	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3014: goto -92 -> 2922
    //   3017: aconst_null
    //   3018: astore 33
    //   3020: aconst_null
    //   3021: astore 29
    //   3023: aconst_null
    //   3024: astore 31
    //   3026: lload 9
    //   3028: lstore 15
    //   3030: iload_2
    //   3031: istore 5
    //   3033: lload 9
    //   3035: lstore 11
    //   3037: ldc 192
    //   3039: ldc_w 942
    //   3042: invokestatic 453	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3045: aload_0
    //   3046: getfield 315	com/tencent/smtt/sdk/ag:t	Ljava/net/HttpURLConnection;
    //   3049: invokevirtual 692	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   3052: astore 30
    //   3054: aload 30
    //   3056: ifnull +1477 -> 4533
    //   3059: aload_0
    //   3060: getfield 315	com/tencent/smtt/sdk/ag:t	Ljava/net/HttpURLConnection;
    //   3063: invokevirtual 945	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   3066: astore 29
    //   3068: aload 29
    //   3070: ifnull +277 -> 3347
    //   3073: aload 29
    //   3075: ldc_w 947
    //   3078: invokevirtual 669	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3081: ifeq +266 -> 3347
    //   3084: new 949	java/util/zip/GZIPInputStream
    //   3087: dup
    //   3088: aload 30
    //   3090: invokespecial 950	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   3093: astore 29
    //   3095: sipush 8192
    //   3098: newarray byte
    //   3100: astore 31
    //   3102: new 952	java/io/FileOutputStream
    //   3105: dup
    //   3106: new 174	java/io/File
    //   3109: dup
    //   3110: aload_0
    //   3111: getfield 135	com/tencent/smtt/sdk/ag:k	Ljava/io/File;
    //   3114: ldc_w 457
    //   3117: invokespecial 215	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   3120: iconst_1
    //   3121: invokespecial 955	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   3124: astore 32
    //   3126: lload 9
    //   3128: lstore 11
    //   3130: lload 9
    //   3132: lstore 17
    //   3134: invokestatic 153	java/lang/System:currentTimeMillis	()J
    //   3137: lstore 15
    //   3139: iconst_0
    //   3140: istore_3
    //   3141: lload 13
    //   3143: lstore 21
    //   3145: iload_2
    //   3146: istore 5
    //   3148: lload 9
    //   3150: lstore 17
    //   3152: iload_2
    //   3153: istore 7
    //   3155: lload 9
    //   3157: lstore 19
    //   3159: aload_0
    //   3160: getfield 560	com/tencent/smtt/sdk/ag:r	Z
    //   3163: ifeq +396 -> 3559
    //   3166: iload_2
    //   3167: istore 5
    //   3169: lload 9
    //   3171: lstore 17
    //   3173: iload_2
    //   3174: istore 7
    //   3176: lload 9
    //   3178: lstore 19
    //   3180: ldc 192
    //   3182: ldc_w 957
    //   3185: iconst_1
    //   3186: invokestatic 810	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   3189: iload_2
    //   3190: istore 5
    //   3192: lload 9
    //   3194: lstore 17
    //   3196: iload_2
    //   3197: istore 7
    //   3199: lload 9
    //   3201: lstore 19
    //   3203: aload_0
    //   3204: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   3207: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3210: sipush -309
    //   3213: invokevirtual 777	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3216: iload_2
    //   3217: istore 6
    //   3219: lload 9
    //   3221: lstore 13
    //   3223: iload 6
    //   3225: istore_2
    //   3226: aload 29
    //   3228: astore 33
    //   3230: aload 32
    //   3232: astore 31
    //   3234: iload_3
    //   3235: ifeq +1308 -> 4543
    //   3238: lload 9
    //   3240: lstore 15
    //   3242: iload 6
    //   3244: istore 5
    //   3246: lload 9
    //   3248: lstore 11
    //   3250: aload_0
    //   3251: aload 32
    //   3253: invokespecial 673	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   3256: lload 9
    //   3258: lstore 15
    //   3260: iload 6
    //   3262: istore 5
    //   3264: lload 9
    //   3266: lstore 11
    //   3268: aload_0
    //   3269: aload 29
    //   3271: invokespecial 673	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   3274: lload 9
    //   3276: lstore 15
    //   3278: iload 6
    //   3280: istore 5
    //   3282: lload 9
    //   3284: lstore 11
    //   3286: aload_0
    //   3287: aload 30
    //   3289: invokespecial 673	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   3292: lload 9
    //   3294: lstore 13
    //   3296: iload 6
    //   3298: istore_2
    //   3299: iload_1
    //   3300: ifne -2817 -> 483
    //   3303: aload_0
    //   3304: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   3307: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3310: getfield 366	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   3313: ldc_w 838
    //   3316: lload 9
    //   3318: invokestatic 864	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3321: invokeinterface 380 3 0
    //   3326: pop
    //   3327: aload_0
    //   3328: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   3331: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3334: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   3337: lload 9
    //   3339: lstore 13
    //   3341: iload 6
    //   3343: istore_2
    //   3344: goto -2861 -> 483
    //   3347: aload 29
    //   3349: ifnull +203 -> 3552
    //   3352: aload 29
    //   3354: ldc_w 959
    //   3357: invokevirtual 669	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3360: ifeq +192 -> 3552
    //   3363: new 961	java/util/zip/InflaterInputStream
    //   3366: dup
    //   3367: aload 30
    //   3369: new 963	java/util/zip/Inflater
    //   3372: dup
    //   3373: iconst_1
    //   3374: invokespecial 965	java/util/zip/Inflater:<init>	(Z)V
    //   3377: invokespecial 968	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Inflater;)V
    //   3380: astore 29
    //   3382: goto -287 -> 3095
    //   3385: astore 34
    //   3387: aload 30
    //   3389: astore 29
    //   3391: aload 33
    //   3393: astore 32
    //   3395: aload 34
    //   3397: astore 30
    //   3399: iload_2
    //   3400: istore 6
    //   3402: aload 30
    //   3404: instanceof 970
    //   3407: ifne +11 -> 3418
    //   3410: aload 30
    //   3412: instanceof 972
    //   3415: ifeq +1268 -> 4683
    //   3418: aload_0
    //   3419: ldc_w 973
    //   3422: putfield 72	com/tencent/smtt/sdk/ag:m	I
    //   3425: aload_0
    //   3426: lconst_0
    //   3427: invokespecial 975	com/tencent/smtt/sdk/ag:a	(J)V
    //   3430: aload_0
    //   3431: bipush 103
    //   3433: aload_0
    //   3434: aload 30
    //   3436: invokespecial 544	com/tencent/smtt/sdk/ag:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3439: iconst_0
    //   3440: invokespecial 546	com/tencent/smtt/sdk/ag:a	(ILjava/lang/String;Z)V
    //   3443: lload 9
    //   3445: lstore 15
    //   3447: iload 6
    //   3449: istore 5
    //   3451: lload 9
    //   3453: lstore 11
    //   3455: aload_0
    //   3456: aload 32
    //   3458: invokespecial 673	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   3461: lload 9
    //   3463: lstore 15
    //   3465: iload 6
    //   3467: istore 5
    //   3469: lload 9
    //   3471: lstore 11
    //   3473: aload_0
    //   3474: aload 31
    //   3476: invokespecial 673	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   3479: lload 9
    //   3481: lstore 15
    //   3483: iload 6
    //   3485: istore 5
    //   3487: lload 9
    //   3489: lstore 11
    //   3491: aload_0
    //   3492: aload 29
    //   3494: invokespecial 673	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   3497: lload 9
    //   3499: lstore 13
    //   3501: iload 6
    //   3503: istore_2
    //   3504: iload_1
    //   3505: ifne -3022 -> 483
    //   3508: aload_0
    //   3509: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   3512: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3515: getfield 366	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   3518: ldc_w 838
    //   3521: lload 9
    //   3523: invokestatic 864	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3526: invokeinterface 380 3 0
    //   3531: pop
    //   3532: aload_0
    //   3533: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   3536: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3539: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   3542: lload 9
    //   3544: lstore 13
    //   3546: iload 6
    //   3548: istore_2
    //   3549: goto -3066 -> 483
    //   3552: aload 30
    //   3554: astore 29
    //   3556: goto -461 -> 3095
    //   3559: iload_2
    //   3560: istore 5
    //   3562: lload 9
    //   3564: lstore 17
    //   3566: iload_2
    //   3567: istore 7
    //   3569: lload 9
    //   3571: lstore 19
    //   3573: aload 29
    //   3575: aload 31
    //   3577: iconst_0
    //   3578: sipush 8192
    //   3581: invokevirtual 981	java/io/InputStream:read	([BII)I
    //   3584: istore 4
    //   3586: iload 4
    //   3588: ifgt +185 -> 3773
    //   3591: iload_2
    //   3592: istore 5
    //   3594: lload 9
    //   3596: lstore 17
    //   3598: iload_2
    //   3599: istore 7
    //   3601: lload 9
    //   3603: lstore 19
    //   3605: aload_0
    //   3606: getfield 78	com/tencent/smtt/sdk/ag:b	[Ljava/lang/String;
    //   3609: ifnull +86 -> 3695
    //   3612: iload_2
    //   3613: istore 5
    //   3615: lload 9
    //   3617: lstore 17
    //   3619: iload_2
    //   3620: istore 7
    //   3622: lload 9
    //   3624: lstore 19
    //   3626: aload_0
    //   3627: iconst_1
    //   3628: iload 8
    //   3630: invokespecial 788	com/tencent/smtt/sdk/ag:c	(ZZ)Z
    //   3633: ifne +62 -> 3695
    //   3636: iload_1
    //   3637: ifne +33 -> 3670
    //   3640: iload_2
    //   3641: istore 5
    //   3643: lload 9
    //   3645: lstore 17
    //   3647: iload_2
    //   3648: istore 7
    //   3650: lload 9
    //   3652: lstore 19
    //   3654: aload_0
    //   3655: iconst_0
    //   3656: invokevirtual 920	com/tencent/smtt/sdk/ag:a	(Z)Z
    //   3659: ifeq +11 -> 3670
    //   3662: iconst_1
    //   3663: istore_3
    //   3664: iload_2
    //   3665: istore 6
    //   3667: goto -448 -> 3219
    //   3670: iload_2
    //   3671: istore 5
    //   3673: lload 9
    //   3675: lstore 17
    //   3677: iload_2
    //   3678: istore 7
    //   3680: lload 9
    //   3682: lstore 19
    //   3684: aload_0
    //   3685: iconst_1
    //   3686: putfield 562	com/tencent/smtt/sdk/ag:s	Z
    //   3689: iconst_0
    //   3690: istore 6
    //   3692: goto -473 -> 3219
    //   3695: iload_2
    //   3696: istore 5
    //   3698: lload 9
    //   3700: lstore 17
    //   3702: iload_2
    //   3703: istore 7
    //   3705: lload 9
    //   3707: lstore 19
    //   3709: aload_0
    //   3710: iconst_1
    //   3711: putfield 562	com/tencent/smtt/sdk/ag:s	Z
    //   3714: iload_2
    //   3715: istore 6
    //   3717: iload_2
    //   3718: istore 5
    //   3720: lload 9
    //   3722: lstore 17
    //   3724: iload_2
    //   3725: istore 7
    //   3727: lload 9
    //   3729: lstore 19
    //   3731: aload_0
    //   3732: getfield 78	com/tencent/smtt/sdk/ag:b	[Ljava/lang/String;
    //   3735: ifnull +6 -> 3741
    //   3738: iconst_1
    //   3739: istore 6
    //   3741: iload 6
    //   3743: istore 5
    //   3745: lload 9
    //   3747: lstore 17
    //   3749: iload 6
    //   3751: istore 7
    //   3753: lload 9
    //   3755: lstore 19
    //   3757: aload_0
    //   3758: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   3761: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3764: sipush -311
    //   3767: invokevirtual 777	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3770: goto -551 -> 3219
    //   3773: iload_2
    //   3774: istore 5
    //   3776: lload 9
    //   3778: lstore 17
    //   3780: iload_2
    //   3781: istore 7
    //   3783: lload 9
    //   3785: lstore 19
    //   3787: aload 32
    //   3789: aload 31
    //   3791: iconst_0
    //   3792: iload 4
    //   3794: invokevirtual 985	java/io/FileOutputStream:write	([BII)V
    //   3797: iload_2
    //   3798: istore 5
    //   3800: lload 9
    //   3802: lstore 17
    //   3804: iload_2
    //   3805: istore 7
    //   3807: lload 9
    //   3809: lstore 19
    //   3811: aload 32
    //   3813: invokevirtual 988	java/io/FileOutputStream:flush	()V
    //   3816: lload 9
    //   3818: lstore 11
    //   3820: iload_1
    //   3821: ifne +265 -> 4086
    //   3824: iload 4
    //   3826: i2l
    //   3827: lload 9
    //   3829: ladd
    //   3830: lstore 9
    //   3832: lload 9
    //   3834: lload 27
    //   3836: lcmp
    //   3837: iflt +91 -> 3928
    //   3840: lload 9
    //   3842: lstore 11
    //   3844: lload 9
    //   3846: lstore 17
    //   3848: ldc 192
    //   3850: ldc_w 872
    //   3853: iconst_1
    //   3854: invokestatic 810	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   3857: lload 9
    //   3859: lstore 11
    //   3861: lload 9
    //   3863: lstore 17
    //   3865: aload_0
    //   3866: bipush 112
    //   3868: new 107	java/lang/StringBuilder
    //   3871: dup
    //   3872: ldc_w 990
    //   3875: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3878: lload 9
    //   3880: invokevirtual 505	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3883: ldc_w 992
    //   3886: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3889: lload 27
    //   3891: invokevirtual 505	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3894: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3897: iconst_1
    //   3898: invokespecial 546	com/tencent/smtt/sdk/ag:a	(ILjava/lang/String;Z)V
    //   3901: lload 9
    //   3903: lstore 11
    //   3905: lload 9
    //   3907: lstore 17
    //   3909: aload_0
    //   3910: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   3913: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3916: sipush -307
    //   3919: invokevirtual 777	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3922: iload_2
    //   3923: istore 6
    //   3925: goto -706 -> 3219
    //   3928: lload 9
    //   3930: lstore 11
    //   3932: lload 9
    //   3934: lstore 17
    //   3936: aload_0
    //   3937: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   3940: invokestatic 866	com/tencent/smtt/utils/j:b	(Landroid/content/Context;)Z
    //   3943: ifne +139 -> 4082
    //   3946: lload 9
    //   3948: lstore 11
    //   3950: lload 9
    //   3952: lstore 17
    //   3954: ldc 192
    //   3956: ldc_w 994
    //   3959: iconst_1
    //   3960: invokestatic 810	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   3963: lload 9
    //   3965: lstore 11
    //   3967: lload 9
    //   3969: lstore 17
    //   3971: aload_0
    //   3972: bipush 105
    //   3974: new 107	java/lang/StringBuilder
    //   3977: dup
    //   3978: ldc_w 996
    //   3981: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3984: invokestatic 998	com/tencent/smtt/utils/v:a	()J
    //   3987: invokevirtual 505	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3990: ldc_w 1000
    //   3993: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3996: aload_0
    //   3997: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   4000: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4003: invokevirtual 1003	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   4006: invokevirtual 505	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4009: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4012: iconst_1
    //   4013: invokespecial 546	com/tencent/smtt/sdk/ag:a	(ILjava/lang/String;Z)V
    //   4016: lload 9
    //   4018: lstore 11
    //   4020: lload 9
    //   4022: lstore 17
    //   4024: aload_0
    //   4025: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   4028: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4031: sipush -308
    //   4034: invokevirtual 777	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4037: iload_2
    //   4038: istore 6
    //   4040: goto -821 -> 3219
    //   4043: astore 31
    //   4045: lload 11
    //   4047: lstore 9
    //   4049: aload_0
    //   4050: aload 32
    //   4052: invokespecial 673	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   4055: aload_0
    //   4056: aload 29
    //   4058: invokespecial 673	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   4061: aload_0
    //   4062: aload 30
    //   4064: invokespecial 673	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   4067: aload 31
    //   4069: athrow
    //   4070: astore 29
    //   4072: lload 9
    //   4074: lstore 15
    //   4076: iload_2
    //   4077: istore 6
    //   4079: goto -1901 -> 2178
    //   4082: lload 9
    //   4084: lstore 11
    //   4086: iload 4
    //   4088: i2l
    //   4089: lstore 9
    //   4091: iload_2
    //   4092: istore 5
    //   4094: lload 11
    //   4096: lstore 17
    //   4098: iload_2
    //   4099: istore 7
    //   4101: lload 11
    //   4103: lstore 19
    //   4105: aload_0
    //   4106: lload 23
    //   4108: lload 9
    //   4110: invokespecial 1005	com/tencent/smtt/sdk/ag:a	(JJ)J
    //   4113: lstore 23
    //   4115: iload_2
    //   4116: istore 5
    //   4118: lload 11
    //   4120: lstore 17
    //   4122: iload_2
    //   4123: istore 7
    //   4125: lload 11
    //   4127: lstore 19
    //   4129: invokestatic 153	java/lang/System:currentTimeMillis	()J
    //   4132: lstore 25
    //   4134: lload 21
    //   4136: iload 4
    //   4138: i2l
    //   4139: ladd
    //   4140: lstore 21
    //   4142: lload 25
    //   4144: lload 15
    //   4146: lsub
    //   4147: ldc2_w 1006
    //   4150: lcmp
    //   4151: ifle +2414 -> 6565
    //   4154: iload_2
    //   4155: istore 5
    //   4157: lload 11
    //   4159: lstore 17
    //   4161: iload_2
    //   4162: istore 7
    //   4164: lload 11
    //   4166: lstore 19
    //   4168: ldc 192
    //   4170: new 107	java/lang/StringBuilder
    //   4173: dup
    //   4174: ldc_w 1009
    //   4177: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4180: lload 21
    //   4182: invokevirtual 505	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4185: ldc_w 916
    //   4188: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4191: aload_0
    //   4192: getfield 554	com/tencent/smtt/sdk/ag:l	J
    //   4195: invokevirtual 505	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4198: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4201: iconst_1
    //   4202: invokestatic 810	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   4205: iload_2
    //   4206: istore 5
    //   4208: lload 11
    //   4210: lstore 17
    //   4212: iload_2
    //   4213: istore 7
    //   4215: lload 11
    //   4217: lstore 19
    //   4219: getstatic 397	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   4222: ifnull +57 -> 4279
    //   4225: iload_2
    //   4226: istore 5
    //   4228: lload 11
    //   4230: lstore 17
    //   4232: iload_2
    //   4233: istore 7
    //   4235: lload 11
    //   4237: lstore 19
    //   4239: lload 21
    //   4241: l2d
    //   4242: aload_0
    //   4243: getfield 554	com/tencent/smtt/sdk/ag:l	J
    //   4246: l2d
    //   4247: ddiv
    //   4248: ldc2_w 1010
    //   4251: dmul
    //   4252: d2i
    //   4253: istore 4
    //   4255: iload_2
    //   4256: istore 5
    //   4258: lload 11
    //   4260: lstore 17
    //   4262: iload_2
    //   4263: istore 7
    //   4265: lload 11
    //   4267: lstore 19
    //   4269: getstatic 397	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   4272: iload 4
    //   4274: invokeinterface 1014 2 0
    //   4279: iload_1
    //   4280: ifne +2274 -> 6554
    //   4283: lload 21
    //   4285: lload 13
    //   4287: lsub
    //   4288: ldc2_w 1015
    //   4291: lcmp
    //   4292: ifle +2262 -> 6554
    //   4295: iload_2
    //   4296: istore 5
    //   4298: lload 11
    //   4300: lstore 17
    //   4302: iload_2
    //   4303: istore 7
    //   4305: lload 11
    //   4307: lstore 19
    //   4309: aload_0
    //   4310: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   4313: invokestatic 210	com/tencent/smtt/sdk/TbsDownloader:getOverSea	(Landroid/content/Context;)Z
    //   4316: ifne +194 -> 4510
    //   4319: iload_2
    //   4320: istore 5
    //   4322: lload 11
    //   4324: lstore 17
    //   4326: iload_2
    //   4327: istore 7
    //   4329: lload 11
    //   4331: lstore 19
    //   4333: aload_0
    //   4334: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   4337: invokestatic 589	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   4340: iconst_3
    //   4341: if_icmpeq +23 -> 4364
    //   4344: iload_2
    //   4345: istore 5
    //   4347: lload 11
    //   4349: lstore 17
    //   4351: iload_2
    //   4352: istore 7
    //   4354: lload 11
    //   4356: lstore 19
    //   4358: invokestatic 760	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   4361: ifeq +27 -> 4388
    //   4364: iload_2
    //   4365: istore 5
    //   4367: lload 11
    //   4369: lstore 17
    //   4371: iload_2
    //   4372: istore 7
    //   4374: lload 11
    //   4376: lstore 19
    //   4378: aload_0
    //   4379: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   4382: invokestatic 589	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   4385: ifne +125 -> 4510
    //   4388: iload_2
    //   4389: istore 5
    //   4391: lload 11
    //   4393: lstore 17
    //   4395: iload_2
    //   4396: istore 7
    //   4398: lload 11
    //   4400: lstore 19
    //   4402: aload_0
    //   4403: invokevirtual 910	com/tencent/smtt/sdk/ag:c	()V
    //   4406: iload_2
    //   4407: istore 5
    //   4409: lload 11
    //   4411: lstore 17
    //   4413: iload_2
    //   4414: istore 7
    //   4416: lload 11
    //   4418: lstore 19
    //   4420: getstatic 397	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   4423: ifnull +27 -> 4450
    //   4426: iload_2
    //   4427: istore 5
    //   4429: lload 11
    //   4431: lstore 17
    //   4433: iload_2
    //   4434: istore 7
    //   4436: lload 11
    //   4438: lstore 19
    //   4440: getstatic 397	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   4443: bipush 111
    //   4445: invokeinterface 402 2 0
    //   4450: iload_2
    //   4451: istore 5
    //   4453: lload 11
    //   4455: lstore 17
    //   4457: iload_2
    //   4458: istore 7
    //   4460: lload 11
    //   4462: lstore 19
    //   4464: ldc 192
    //   4466: ldc_w 1018
    //   4469: iconst_0
    //   4470: invokestatic 810	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   4473: iload_2
    //   4474: istore 5
    //   4476: lload 11
    //   4478: lstore 17
    //   4480: iload_2
    //   4481: istore 7
    //   4483: lload 11
    //   4485: lstore 19
    //   4487: aload_0
    //   4488: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   4491: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4494: sipush -304
    //   4497: invokevirtual 777	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4500: lload 11
    //   4502: lstore 9
    //   4504: iload_2
    //   4505: istore 6
    //   4507: goto -1288 -> 3219
    //   4510: lload 21
    //   4512: lstore 9
    //   4514: lload 25
    //   4516: lstore 13
    //   4518: lload 13
    //   4520: lstore 15
    //   4522: lload 9
    //   4524: lstore 13
    //   4526: lload 11
    //   4528: lstore 9
    //   4530: goto -1385 -> 3145
    //   4533: aconst_null
    //   4534: astore 33
    //   4536: aconst_null
    //   4537: astore 31
    //   4539: lload 9
    //   4541: lstore 13
    //   4543: lload 13
    //   4545: lstore 15
    //   4547: iload_2
    //   4548: istore 5
    //   4550: lload 13
    //   4552: lstore 11
    //   4554: aload_0
    //   4555: aload 31
    //   4557: invokespecial 673	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   4560: lload 13
    //   4562: lstore 15
    //   4564: iload_2
    //   4565: istore 5
    //   4567: lload 13
    //   4569: lstore 11
    //   4571: aload_0
    //   4572: aload 33
    //   4574: invokespecial 673	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   4577: lload 13
    //   4579: lstore 15
    //   4581: iload_2
    //   4582: istore 5
    //   4584: lload 13
    //   4586: lstore 11
    //   4588: aload_0
    //   4589: aload 30
    //   4591: invokespecial 673	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   4594: lload 13
    //   4596: lstore 15
    //   4598: iload_2
    //   4599: istore 5
    //   4601: lload 13
    //   4603: lstore 11
    //   4605: aload_0
    //   4606: getfield 562	com/tencent/smtt/sdk/ag:s	Z
    //   4609: ifne +27 -> 4636
    //   4612: lload 13
    //   4614: lstore 15
    //   4616: iload_2
    //   4617: istore 5
    //   4619: lload 13
    //   4621: lstore 11
    //   4623: aload_0
    //   4624: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   4627: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4630: sipush -319
    //   4633: invokevirtual 777	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4636: iload_2
    //   4637: istore 5
    //   4639: iload_1
    //   4640: ifne -4110 -> 530
    //   4643: aload_0
    //   4644: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   4647: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4650: getfield 366	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   4653: ldc_w 838
    //   4656: lload 13
    //   4658: invokestatic 864	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4661: invokeinterface 380 3 0
    //   4666: pop
    //   4667: aload_0
    //   4668: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   4671: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4674: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   4677: iload_2
    //   4678: istore 5
    //   4680: goto -4150 -> 530
    //   4683: iload_1
    //   4684: ifne +174 -> 4858
    //   4687: aload_0
    //   4688: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   4691: invokestatic 866	com/tencent/smtt/utils/j:b	(Landroid/content/Context;)Z
    //   4694: ifne +164 -> 4858
    //   4697: aload_0
    //   4698: bipush 105
    //   4700: new 107	java/lang/StringBuilder
    //   4703: dup
    //   4704: ldc_w 996
    //   4707: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4710: invokestatic 998	com/tencent/smtt/utils/v:a	()J
    //   4713: invokevirtual 505	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4716: ldc_w 1000
    //   4719: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4722: aload_0
    //   4723: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   4726: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4729: invokevirtual 1003	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   4732: invokevirtual 505	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4735: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4738: iconst_1
    //   4739: invokespecial 546	com/tencent/smtt/sdk/ag:a	(ILjava/lang/String;Z)V
    //   4742: aload_0
    //   4743: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   4746: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4749: sipush -308
    //   4752: invokevirtual 777	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4755: lload 9
    //   4757: lstore 15
    //   4759: iload 6
    //   4761: istore 5
    //   4763: lload 9
    //   4765: lstore 11
    //   4767: aload_0
    //   4768: aload 32
    //   4770: invokespecial 673	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   4773: lload 9
    //   4775: lstore 15
    //   4777: iload 6
    //   4779: istore 5
    //   4781: lload 9
    //   4783: lstore 11
    //   4785: aload_0
    //   4786: aload 31
    //   4788: invokespecial 673	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   4791: lload 9
    //   4793: lstore 15
    //   4795: iload 6
    //   4797: istore 5
    //   4799: lload 9
    //   4801: lstore 11
    //   4803: aload_0
    //   4804: aload 29
    //   4806: invokespecial 673	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   4809: iload 6
    //   4811: istore 5
    //   4813: iload_1
    //   4814: ifne -4284 -> 530
    //   4817: aload_0
    //   4818: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   4821: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4824: getfield 366	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   4827: ldc_w 838
    //   4830: lload 9
    //   4832: invokestatic 864	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4835: invokeinterface 380 3 0
    //   4840: pop
    //   4841: aload_0
    //   4842: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   4845: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4848: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   4851: iload 6
    //   4853: istore 5
    //   4855: goto -4325 -> 530
    //   4858: aload_0
    //   4859: lconst_0
    //   4860: invokespecial 975	com/tencent/smtt/sdk/ag:a	(J)V
    //   4863: aload_0
    //   4864: invokespecial 1020	com/tencent/smtt/sdk/ag:j	()Z
    //   4867: ifne +125 -> 4992
    //   4870: aload_0
    //   4871: bipush 106
    //   4873: aload_0
    //   4874: aload 30
    //   4876: invokespecial 544	com/tencent/smtt/sdk/ag:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   4879: iconst_0
    //   4880: invokespecial 546	com/tencent/smtt/sdk/ag:a	(ILjava/lang/String;Z)V
    //   4883: lload 9
    //   4885: lstore 15
    //   4887: iload 6
    //   4889: istore 5
    //   4891: lload 9
    //   4893: lstore 11
    //   4895: aload_0
    //   4896: aload 32
    //   4898: invokespecial 673	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   4901: lload 9
    //   4903: lstore 15
    //   4905: iload 6
    //   4907: istore 5
    //   4909: lload 9
    //   4911: lstore 11
    //   4913: aload_0
    //   4914: aload 31
    //   4916: invokespecial 673	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   4919: lload 9
    //   4921: lstore 15
    //   4923: iload 6
    //   4925: istore 5
    //   4927: lload 9
    //   4929: lstore 11
    //   4931: aload_0
    //   4932: aload 29
    //   4934: invokespecial 673	com/tencent/smtt/sdk/ag:a	(Ljava/io/Closeable;)V
    //   4937: lload 9
    //   4939: lstore 13
    //   4941: iload 6
    //   4943: istore_2
    //   4944: iload_1
    //   4945: ifne -4462 -> 483
    //   4948: aload_0
    //   4949: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   4952: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4955: getfield 366	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   4958: ldc_w 838
    //   4961: lload 9
    //   4963: invokestatic 864	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4966: invokeinterface 380 3 0
    //   4971: pop
    //   4972: aload_0
    //   4973: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   4976: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4979: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   4982: lload 9
    //   4984: lstore 13
    //   4986: iload 6
    //   4988: istore_2
    //   4989: goto -4506 -> 483
    //   4992: aload_0
    //   4993: bipush 104
    //   4995: aload_0
    //   4996: aload 30
    //   4998: invokespecial 544	com/tencent/smtt/sdk/ag:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   5001: iconst_0
    //   5002: invokespecial 546	com/tencent/smtt/sdk/ag:a	(ILjava/lang/String;Z)V
    //   5005: goto -122 -> 4883
    //   5008: astore 34
    //   5010: aload 31
    //   5012: astore 30
    //   5014: aload 29
    //   5016: astore 33
    //   5018: iload 6
    //   5020: istore_2
    //   5021: aload 34
    //   5023: astore 31
    //   5025: aload 30
    //   5027: astore 29
    //   5029: aload 33
    //   5031: astore 30
    //   5033: goto -984 -> 4049
    //   5036: iload_3
    //   5037: sipush 300
    //   5040: if_icmplt +229 -> 5269
    //   5043: iload_3
    //   5044: sipush 307
    //   5047: if_icmpgt +222 -> 5269
    //   5050: lload 9
    //   5052: lstore 15
    //   5054: iload_2
    //   5055: istore 5
    //   5057: lload 9
    //   5059: lstore 11
    //   5061: aload_0
    //   5062: getfield 315	com/tencent/smtt/sdk/ag:t	Ljava/net/HttpURLConnection;
    //   5065: ldc_w 1022
    //   5068: invokevirtual 1026	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   5071: astore 29
    //   5073: lload 9
    //   5075: lstore 15
    //   5077: iload_2
    //   5078: istore 5
    //   5080: lload 9
    //   5082: lstore 11
    //   5084: aload 29
    //   5086: invokestatic 702	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5089: ifne +90 -> 5179
    //   5092: lload 9
    //   5094: lstore 15
    //   5096: iload_2
    //   5097: istore 5
    //   5099: lload 9
    //   5101: lstore 11
    //   5103: aload_0
    //   5104: aload 29
    //   5106: putfield 556	com/tencent/smtt/sdk/ag:j	Ljava/lang/String;
    //   5109: lload 9
    //   5111: lstore 15
    //   5113: iload_2
    //   5114: istore 5
    //   5116: lload 9
    //   5118: lstore 11
    //   5120: aload_0
    //   5121: aload_0
    //   5122: getfield 550	com/tencent/smtt/sdk/ag:q	I
    //   5125: iconst_1
    //   5126: iadd
    //   5127: putfield 550	com/tencent/smtt/sdk/ag:q	I
    //   5130: lload 9
    //   5132: lstore 13
    //   5134: iload_1
    //   5135: ifne -4652 -> 483
    //   5138: aload_0
    //   5139: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   5142: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5145: getfield 366	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   5148: ldc_w 838
    //   5151: lload 9
    //   5153: invokestatic 864	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5156: invokeinterface 380 3 0
    //   5161: pop
    //   5162: aload_0
    //   5163: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   5166: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5169: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5172: lload 9
    //   5174: lstore 13
    //   5176: goto -4693 -> 483
    //   5179: lload 9
    //   5181: lstore 15
    //   5183: iload_2
    //   5184: istore 5
    //   5186: lload 9
    //   5188: lstore 11
    //   5190: aload_0
    //   5191: bipush 124
    //   5193: aconst_null
    //   5194: iconst_1
    //   5195: invokespecial 546	com/tencent/smtt/sdk/ag:a	(ILjava/lang/String;Z)V
    //   5198: lload 9
    //   5200: lstore 15
    //   5202: iload_2
    //   5203: istore 5
    //   5205: lload 9
    //   5207: lstore 11
    //   5209: aload_0
    //   5210: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   5213: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5216: sipush -312
    //   5219: invokevirtual 777	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5222: iload_2
    //   5223: istore 5
    //   5225: iload_1
    //   5226: ifne -4696 -> 530
    //   5229: aload_0
    //   5230: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   5233: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5236: getfield 366	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   5239: ldc_w 838
    //   5242: lload 9
    //   5244: invokestatic 864	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5247: invokeinterface 380 3 0
    //   5252: pop
    //   5253: aload_0
    //   5254: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   5257: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5260: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5263: iload_2
    //   5264: istore 5
    //   5266: goto -4736 -> 530
    //   5269: lload 9
    //   5271: lstore 15
    //   5273: iload_2
    //   5274: istore 5
    //   5276: lload 9
    //   5278: lstore 11
    //   5280: aload_0
    //   5281: bipush 102
    //   5283: iload_3
    //   5284: invokestatic 1029	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   5287: iconst_0
    //   5288: invokespecial 546	com/tencent/smtt/sdk/ag:a	(ILjava/lang/String;Z)V
    //   5291: iload_3
    //   5292: sipush 416
    //   5295: if_icmpne +185 -> 5480
    //   5298: lload 9
    //   5300: lstore 15
    //   5302: iload_2
    //   5303: istore 5
    //   5305: lload 9
    //   5307: lstore 11
    //   5309: aload_0
    //   5310: iconst_1
    //   5311: iload 8
    //   5313: invokespecial 788	com/tencent/smtt/sdk/ag:c	(ZZ)Z
    //   5316: ifeq +76 -> 5392
    //   5319: iconst_1
    //   5320: istore 5
    //   5322: iconst_1
    //   5323: istore_2
    //   5324: lload 9
    //   5326: lstore 15
    //   5328: lload 9
    //   5330: lstore 11
    //   5332: aload_0
    //   5333: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   5336: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5339: sipush -214
    //   5342: invokevirtual 777	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5345: iload_2
    //   5346: istore 5
    //   5348: iload_1
    //   5349: ifne -4819 -> 530
    //   5352: aload_0
    //   5353: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   5356: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5359: getfield 366	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   5362: ldc_w 838
    //   5365: lload 9
    //   5367: invokestatic 864	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5370: invokeinterface 380 3 0
    //   5375: pop
    //   5376: aload_0
    //   5377: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   5380: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5383: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5386: iload_2
    //   5387: istore 5
    //   5389: goto -4859 -> 530
    //   5392: lload 9
    //   5394: lstore 15
    //   5396: iload_2
    //   5397: istore 5
    //   5399: lload 9
    //   5401: lstore 11
    //   5403: aload_0
    //   5404: iconst_0
    //   5405: invokespecial 790	com/tencent/smtt/sdk/ag:c	(Z)Z
    //   5408: pop
    //   5409: lload 9
    //   5411: lstore 15
    //   5413: iload_2
    //   5414: istore 5
    //   5416: lload 9
    //   5418: lstore 11
    //   5420: aload_0
    //   5421: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   5424: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5427: sipush -313
    //   5430: invokevirtual 777	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5433: iload_2
    //   5434: istore 5
    //   5436: iload_1
    //   5437: ifne -4907 -> 530
    //   5440: aload_0
    //   5441: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   5444: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5447: getfield 366	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   5450: ldc_w 838
    //   5453: lload 9
    //   5455: invokestatic 864	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5458: invokeinterface 380 3 0
    //   5463: pop
    //   5464: aload_0
    //   5465: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   5468: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5471: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5474: iload_2
    //   5475: istore 5
    //   5477: goto -4947 -> 530
    //   5480: iload_3
    //   5481: sipush 403
    //   5484: if_icmpeq +10 -> 5494
    //   5487: iload_3
    //   5488: sipush 406
    //   5491: if_icmpne +96 -> 5587
    //   5494: lload 9
    //   5496: lstore 15
    //   5498: iload_2
    //   5499: istore 5
    //   5501: lload 9
    //   5503: lstore 11
    //   5505: aload_0
    //   5506: getfield 554	com/tencent/smtt/sdk/ag:l	J
    //   5509: ldc2_w 551
    //   5512: lcmp
    //   5513: ifne +74 -> 5587
    //   5516: lload 9
    //   5518: lstore 15
    //   5520: iload_2
    //   5521: istore 5
    //   5523: lload 9
    //   5525: lstore 11
    //   5527: aload_0
    //   5528: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   5531: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5534: sipush -314
    //   5537: invokevirtual 777	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5540: iload_2
    //   5541: istore 5
    //   5543: iload_1
    //   5544: ifne -5014 -> 530
    //   5547: aload_0
    //   5548: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   5551: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5554: getfield 366	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   5557: ldc_w 838
    //   5560: lload 9
    //   5562: invokestatic 864	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5565: invokeinterface 380 3 0
    //   5570: pop
    //   5571: aload_0
    //   5572: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   5575: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5578: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5581: iload_2
    //   5582: istore 5
    //   5584: goto -5054 -> 530
    //   5587: iload_3
    //   5588: sipush 202
    //   5591: if_icmpne +52 -> 5643
    //   5594: lload 9
    //   5596: lstore 13
    //   5598: iload_1
    //   5599: ifne -5116 -> 483
    //   5602: aload_0
    //   5603: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   5606: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5609: getfield 366	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   5612: ldc_w 838
    //   5615: lload 9
    //   5617: invokestatic 864	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5620: invokeinterface 380 3 0
    //   5625: pop
    //   5626: aload_0
    //   5627: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   5630: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5633: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5636: lload 9
    //   5638: lstore 13
    //   5640: goto -5157 -> 483
    //   5643: lload 9
    //   5645: lstore 15
    //   5647: iload_2
    //   5648: istore 5
    //   5650: lload 9
    //   5652: lstore 11
    //   5654: aload_0
    //   5655: getfield 253	com/tencent/smtt/sdk/ag:p	I
    //   5658: aload_0
    //   5659: getfield 76	com/tencent/smtt/sdk/ag:B	I
    //   5662: if_icmpge +176 -> 5838
    //   5665: iload_3
    //   5666: sipush 503
    //   5669: if_icmpne +169 -> 5838
    //   5672: lload 9
    //   5674: lstore 15
    //   5676: iload_2
    //   5677: istore 5
    //   5679: lload 9
    //   5681: lstore 11
    //   5683: aload_0
    //   5684: aload_0
    //   5685: getfield 315	com/tencent/smtt/sdk/ag:t	Ljava/net/HttpURLConnection;
    //   5688: ldc_w 1031
    //   5691: invokevirtual 1026	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   5694: invokestatic 1035	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   5697: invokespecial 975	com/tencent/smtt/sdk/ag:a	(J)V
    //   5700: lload 9
    //   5702: lstore 15
    //   5704: iload_2
    //   5705: istore 5
    //   5707: lload 9
    //   5709: lstore 11
    //   5711: aload_0
    //   5712: getfield 560	com/tencent/smtt/sdk/ag:r	Z
    //   5715: ifeq +74 -> 5789
    //   5718: lload 9
    //   5720: lstore 15
    //   5722: iload_2
    //   5723: istore 5
    //   5725: lload 9
    //   5727: lstore 11
    //   5729: aload_0
    //   5730: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   5733: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5736: sipush -309
    //   5739: invokevirtual 777	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5742: iload_2
    //   5743: istore 5
    //   5745: iload_1
    //   5746: ifne -5216 -> 530
    //   5749: aload_0
    //   5750: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   5753: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5756: getfield 366	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   5759: ldc_w 838
    //   5762: lload 9
    //   5764: invokestatic 864	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5767: invokeinterface 380 3 0
    //   5772: pop
    //   5773: aload_0
    //   5774: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   5777: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5780: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5783: iload_2
    //   5784: istore 5
    //   5786: goto -5256 -> 530
    //   5789: lload 9
    //   5791: lstore 13
    //   5793: iload_1
    //   5794: ifne -5311 -> 483
    //   5797: aload_0
    //   5798: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   5801: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5804: getfield 366	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   5807: ldc_w 838
    //   5810: lload 9
    //   5812: invokestatic 864	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5815: invokeinterface 380 3 0
    //   5820: pop
    //   5821: aload_0
    //   5822: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   5825: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5828: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5831: lload 9
    //   5833: lstore 13
    //   5835: goto -5352 -> 483
    //   5838: lload 9
    //   5840: lstore 15
    //   5842: iload_2
    //   5843: istore 5
    //   5845: lload 9
    //   5847: lstore 11
    //   5849: aload_0
    //   5850: getfield 253	com/tencent/smtt/sdk/ag:p	I
    //   5853: aload_0
    //   5854: getfield 76	com/tencent/smtt/sdk/ag:B	I
    //   5857: if_icmpge +185 -> 6042
    //   5860: iload_3
    //   5861: sipush 408
    //   5864: if_icmpeq +24 -> 5888
    //   5867: iload_3
    //   5868: sipush 504
    //   5871: if_icmpeq +17 -> 5888
    //   5874: iload_3
    //   5875: sipush 502
    //   5878: if_icmpeq +10 -> 5888
    //   5881: iload_3
    //   5882: sipush 408
    //   5885: if_icmpne +157 -> 6042
    //   5888: lload 9
    //   5890: lstore 15
    //   5892: iload_2
    //   5893: istore 5
    //   5895: lload 9
    //   5897: lstore 11
    //   5899: aload_0
    //   5900: lconst_0
    //   5901: invokespecial 975	com/tencent/smtt/sdk/ag:a	(J)V
    //   5904: lload 9
    //   5906: lstore 15
    //   5908: iload_2
    //   5909: istore 5
    //   5911: lload 9
    //   5913: lstore 11
    //   5915: aload_0
    //   5916: getfield 560	com/tencent/smtt/sdk/ag:r	Z
    //   5919: ifeq +74 -> 5993
    //   5922: lload 9
    //   5924: lstore 15
    //   5926: iload_2
    //   5927: istore 5
    //   5929: lload 9
    //   5931: lstore 11
    //   5933: aload_0
    //   5934: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   5937: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5940: sipush -309
    //   5943: invokevirtual 777	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5946: iload_2
    //   5947: istore 5
    //   5949: iload_1
    //   5950: ifne -5420 -> 530
    //   5953: aload_0
    //   5954: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   5957: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5960: getfield 366	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   5963: ldc_w 838
    //   5966: lload 9
    //   5968: invokestatic 864	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5971: invokeinterface 380 3 0
    //   5976: pop
    //   5977: aload_0
    //   5978: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   5981: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5984: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5987: iload_2
    //   5988: istore 5
    //   5990: goto -5460 -> 530
    //   5993: lload 9
    //   5995: lstore 13
    //   5997: iload_1
    //   5998: ifne -5515 -> 483
    //   6001: aload_0
    //   6002: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   6005: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6008: getfield 366	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   6011: ldc_w 838
    //   6014: lload 9
    //   6016: invokestatic 864	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6019: invokeinterface 380 3 0
    //   6024: pop
    //   6025: aload_0
    //   6026: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   6029: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6032: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6035: lload 9
    //   6037: lstore 13
    //   6039: goto -5556 -> 483
    //   6042: lload 9
    //   6044: lstore 15
    //   6046: iload_2
    //   6047: istore 5
    //   6049: lload 9
    //   6051: lstore 11
    //   6053: aload_0
    //   6054: invokespecial 885	com/tencent/smtt/sdk/ag:k	()J
    //   6057: lconst_0
    //   6058: lcmp
    //   6059: ifgt +93 -> 6152
    //   6062: lload 9
    //   6064: lstore 15
    //   6066: iload_2
    //   6067: istore 5
    //   6069: lload 9
    //   6071: lstore 11
    //   6073: aload_0
    //   6074: getfield 558	com/tencent/smtt/sdk/ag:o	Z
    //   6077: ifne +75 -> 6152
    //   6080: iload_3
    //   6081: sipush 410
    //   6084: if_icmpeq +68 -> 6152
    //   6087: lload 9
    //   6089: lstore 15
    //   6091: iload_2
    //   6092: istore 5
    //   6094: lload 9
    //   6096: lstore 11
    //   6098: aload_0
    //   6099: iconst_1
    //   6100: putfield 558	com/tencent/smtt/sdk/ag:o	Z
    //   6103: lload 9
    //   6105: lstore 13
    //   6107: iload_1
    //   6108: ifne -5625 -> 483
    //   6111: aload_0
    //   6112: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   6115: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6118: getfield 366	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   6121: ldc_w 838
    //   6124: lload 9
    //   6126: invokestatic 864	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6129: invokeinterface 380 3 0
    //   6134: pop
    //   6135: aload_0
    //   6136: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   6139: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6142: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6145: lload 9
    //   6147: lstore 13
    //   6149: goto -5666 -> 483
    //   6152: lload 9
    //   6154: lstore 15
    //   6156: iload_2
    //   6157: istore 5
    //   6159: lload 9
    //   6161: lstore 11
    //   6163: aload_0
    //   6164: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   6167: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6170: sipush -315
    //   6173: invokevirtual 777	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6176: iload_2
    //   6177: istore 5
    //   6179: iload_1
    //   6180: ifne -5650 -> 530
    //   6183: aload_0
    //   6184: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   6187: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6190: getfield 366	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   6193: ldc_w 838
    //   6196: lload 9
    //   6198: invokestatic 864	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6201: invokeinterface 380 3 0
    //   6206: pop
    //   6207: aload_0
    //   6208: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   6211: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6214: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6217: iload_2
    //   6218: istore 5
    //   6220: goto -5690 -> 530
    //   6223: lload 15
    //   6225: lstore 11
    //   6227: aload_0
    //   6228: lconst_0
    //   6229: invokespecial 975	com/tencent/smtt/sdk/ag:a	(J)V
    //   6232: lload 15
    //   6234: lstore 11
    //   6236: aload_0
    //   6237: bipush 107
    //   6239: aload_0
    //   6240: aload 29
    //   6242: invokespecial 544	com/tencent/smtt/sdk/ag:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   6245: iconst_0
    //   6246: invokespecial 546	com/tencent/smtt/sdk/ag:a	(ILjava/lang/String;Z)V
    //   6249: lload 15
    //   6251: lstore 11
    //   6253: aload_0
    //   6254: getfield 560	com/tencent/smtt/sdk/ag:r	Z
    //   6257: ifeq -3985 -> 2272
    //   6260: lload 15
    //   6262: lstore 11
    //   6264: aload_0
    //   6265: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   6268: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6271: sipush -309
    //   6274: invokevirtual 777	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6277: iload 6
    //   6279: istore 5
    //   6281: iload_1
    //   6282: ifne -5752 -> 530
    //   6285: aload_0
    //   6286: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   6289: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6292: getfield 366	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   6295: ldc_w 838
    //   6298: lload 15
    //   6300: invokestatic 864	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6303: invokeinterface 380 3 0
    //   6308: pop
    //   6309: aload_0
    //   6310: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   6313: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6316: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6319: iload 6
    //   6321: istore 5
    //   6323: goto -5793 -> 530
    //   6326: iconst_0
    //   6327: istore_3
    //   6328: goto -5743 -> 585
    //   6331: iconst_2
    //   6332: istore_3
    //   6333: goto -5725 -> 608
    //   6336: aload_0
    //   6337: getfield 100	com/tencent/smtt/sdk/ag:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   6340: iconst_0
    //   6341: invokevirtual 844	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setPatchUpdateFlag	(I)V
    //   6344: goto -5730 -> 614
    //   6347: aload_0
    //   6348: getfield 88	com/tencent/smtt/sdk/ag:g	Landroid/content/Context;
    //   6351: invokestatic 283	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6354: sipush -318
    //   6357: invokevirtual 777	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6360: aload_0
    //   6361: iconst_0
    //   6362: invokespecial 790	com/tencent/smtt/sdk/ag:c	(Z)Z
    //   6365: pop
    //   6366: goto -5720 -> 646
    //   6369: aload 29
    //   6371: getfield 287	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   6374: ldc_w 1037
    //   6377: iconst_0
    //   6378: invokeinterface 295 3 0
    //   6383: istore_3
    //   6384: aload 29
    //   6386: getfield 366	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   6389: astore 30
    //   6391: iload_3
    //   6392: iconst_1
    //   6393: iadd
    //   6394: istore_3
    //   6395: aload 30
    //   6397: ldc_w 1037
    //   6400: iload_3
    //   6401: invokestatic 389	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6404: invokeinterface 380 3 0
    //   6409: pop
    //   6410: iload_3
    //   6411: aload 29
    //   6413: invokevirtual 1040	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadFailedMaxRetrytimes	()I
    //   6416: if_icmpne -5722 -> 694
    //   6419: aload_0
    //   6420: getfield 100	com/tencent/smtt/sdk/ag:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   6423: iconst_2
    //   6424: invokevirtual 898	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownloadCancel	(I)V
    //   6427: goto -5733 -> 694
    //   6430: iconst_0
    //   6431: istore_3
    //   6432: goto -5721 -> 711
    //   6435: astore 29
    //   6437: goto -3985 -> 2452
    //   6440: astore 31
    //   6442: aconst_null
    //   6443: astore 29
    //   6445: aconst_null
    //   6446: astore 30
    //   6448: aconst_null
    //   6449: astore 32
    //   6451: goto -2402 -> 4049
    //   6454: astore 31
    //   6456: aconst_null
    //   6457: astore 29
    //   6459: aconst_null
    //   6460: astore 32
    //   6462: goto -2413 -> 4049
    //   6465: astore 31
    //   6467: aconst_null
    //   6468: astore 32
    //   6470: goto -2421 -> 4049
    //   6473: astore 31
    //   6475: iload 5
    //   6477: istore_2
    //   6478: lload 17
    //   6480: lstore 9
    //   6482: goto -2433 -> 4049
    //   6485: astore 30
    //   6487: iload_2
    //   6488: istore 6
    //   6490: aload 33
    //   6492: astore 32
    //   6494: goto -3092 -> 3402
    //   6497: astore 31
    //   6499: aload 30
    //   6501: astore 32
    //   6503: iload_2
    //   6504: istore 6
    //   6506: aload 31
    //   6508: astore 30
    //   6510: aload 29
    //   6512: astore 31
    //   6514: aload 32
    //   6516: astore 29
    //   6518: aload 33
    //   6520: astore 32
    //   6522: goto -3120 -> 3402
    //   6525: astore 31
    //   6527: lload 19
    //   6529: lstore 9
    //   6531: aload 30
    //   6533: astore 33
    //   6535: iload 7
    //   6537: istore 6
    //   6539: aload 31
    //   6541: astore 30
    //   6543: aload 29
    //   6545: astore 31
    //   6547: aload 33
    //   6549: astore 29
    //   6551: goto -3149 -> 3402
    //   6554: lload 13
    //   6556: lstore 9
    //   6558: lload 25
    //   6560: lstore 13
    //   6562: goto -2044 -> 4518
    //   6565: lload 13
    //   6567: lstore 9
    //   6569: lload 15
    //   6571: lstore 13
    //   6573: goto -2055 -> 4518
    //   6576: astore 31
    //   6578: aload 30
    //   6580: astore 33
    //   6582: lload 17
    //   6584: lstore 9
    //   6586: iload_2
    //   6587: istore 6
    //   6589: aload 31
    //   6591: astore 30
    //   6593: aload 29
    //   6595: astore 31
    //   6597: aload 33
    //   6599: astore 29
    //   6601: goto -3199 -> 3402
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	6604	0	this	ag
    //   0	6604	1	paramBoolean1	boolean
    //   0	6604	2	paramBoolean2	boolean
    //   54	6378	3	i1	int
    //   3584	689	4	i2	int
    //   484	5992	5	bool1	boolean
    //   2176	4412	6	bool2	boolean
    //   3153	3383	7	bool3	boolean
    //   71	5241	8	bool4	boolean
    //   739	5846	9	l1	long
    //   754	5509	11	l2	long
    //   470	6102	13	l3	long
    //   747	5823	15	l4	long
    //   895	5688	17	l5	long
    //   3157	3371	19	l6	long
    //   3143	1368	21	l7	long
    //   735	3379	23	l8	long
    //   4132	2427	25	l9	long
    //   447	3443	27	l10	long
    //   145	1920	29	localObject1	Object
    //   2172	251	29	localThrowable1	Throwable
    //   2446	45	29	localObject2	Object
    //   3021	1036	29	localObject3	Object
    //   4070	945	29	localThrowable2	Throwable
    //   5027	1385	29	localObject4	Object
    //   6435	1	29	localObject5	Object
    //   6443	157	29	localObject6	Object
    //   3052	3395	30	localObject7	Object
    //   6485	15	30	localIOException1	IOException
    //   6508	84	30	localIOException2	IOException
    //   3024	766	31	localObject8	Object
    //   4043	25	31	localObject9	Object
    //   4537	487	31	localObject10	Object
    //   6440	1	31	localObject11	Object
    //   6454	1	31	localObject12	Object
    //   6465	1	31	localObject13	Object
    //   6473	1	31	localObject14	Object
    //   6497	10	31	localIOException3	IOException
    //   6512	1	31	localObject15	Object
    //   6525	15	31	localIOException4	IOException
    //   6545	1	31	localObject16	Object
    //   6576	14	31	localIOException5	IOException
    //   6595	1	31	localObject17	Object
    //   3124	3397	32	localObject18	Object
    //   3018	3580	33	localObject19	Object
    //   3385	11	34	localIOException6	IOException
    //   5008	14	34	localObject20	Object
    // Exception table:
    //   from	to	target	type
    //   756	785	2172	java/lang/Throwable
    //   796	804	2172	java/lang/Throwable
    //   815	839	2172	java/lang/Throwable
    //   850	873	2172	java/lang/Throwable
    //   884	894	2172	java/lang/Throwable
    //   912	922	2172	java/lang/Throwable
    //   933	942	2172	java/lang/Throwable
    //   953	961	2172	java/lang/Throwable
    //   972	985	2172	java/lang/Throwable
    //   1043	1066	2172	java/lang/Throwable
    //   1089	1098	2172	java/lang/Throwable
    //   1109	1117	2172	java/lang/Throwable
    //   1128	1141	2172	java/lang/Throwable
    //   1199	1204	2172	java/lang/Throwable
    //   1215	1222	2172	java/lang/Throwable
    //   1233	1239	2172	java/lang/Throwable
    //   1250	1287	2172	java/lang/Throwable
    //   1298	1310	2172	java/lang/Throwable
    //   1321	1330	2172	java/lang/Throwable
    //   1341	1347	2172	java/lang/Throwable
    //   1358	1364	2172	java/lang/Throwable
    //   1378	1385	2172	java/lang/Throwable
    //   1396	1402	2172	java/lang/Throwable
    //   1413	1436	2172	java/lang/Throwable
    //   1447	1456	2172	java/lang/Throwable
    //   1467	1491	2172	java/lang/Throwable
    //   1502	1536	2172	java/lang/Throwable
    //   1547	1553	2172	java/lang/Throwable
    //   1573	1579	2172	java/lang/Throwable
    //   1590	1598	2172	java/lang/Throwable
    //   1609	1618	2172	java/lang/Throwable
    //   1629	1636	2172	java/lang/Throwable
    //   1647	1655	2172	java/lang/Throwable
    //   1666	1672	2172	java/lang/Throwable
    //   1683	1688	2172	java/lang/Throwable
    //   1699	1706	2172	java/lang/Throwable
    //   1717	1731	2172	java/lang/Throwable
    //   1742	1750	2172	java/lang/Throwable
    //   1761	1783	2172	java/lang/Throwable
    //   1794	1802	2172	java/lang/Throwable
    //   1817	1827	2172	java/lang/Throwable
    //   1838	1849	2172	java/lang/Throwable
    //   1860	1866	2172	java/lang/Throwable
    //   1877	1887	2172	java/lang/Throwable
    //   1898	1902	2172	java/lang/Throwable
    //   1913	1919	2172	java/lang/Throwable
    //   1930	1940	2172	java/lang/Throwable
    //   1951	1960	2172	java/lang/Throwable
    //   1971	1978	2172	java/lang/Throwable
    //   1989	2002	2172	java/lang/Throwable
    //   2060	2066	2172	java/lang/Throwable
    //   2080	2117	2172	java/lang/Throwable
    //   2128	2169	2172	java/lang/Throwable
    //   2360	2368	2172	java/lang/Throwable
    //   2379	2391	2172	java/lang/Throwable
    //   2402	2410	2172	java/lang/Throwable
    //   2421	2427	2172	java/lang/Throwable
    //   2438	2443	2172	java/lang/Throwable
    //   2518	2533	2172	java/lang/Throwable
    //   2544	2569	2172	java/lang/Throwable
    //   2580	2591	2172	java/lang/Throwable
    //   2602	2623	2172	java/lang/Throwable
    //   2641	2651	2172	java/lang/Throwable
    //   2662	2699	2172	java/lang/Throwable
    //   2714	2721	2172	java/lang/Throwable
    //   2732	2738	2172	java/lang/Throwable
    //   2749	2759	2172	java/lang/Throwable
    //   2770	2777	2172	java/lang/Throwable
    //   2788	2795	2172	java/lang/Throwable
    //   2860	2898	2172	java/lang/Throwable
    //   2909	2922	2172	java/lang/Throwable
    //   2980	2990	2172	java/lang/Throwable
    //   3001	3014	2172	java/lang/Throwable
    //   3037	3045	2172	java/lang/Throwable
    //   3250	3256	2172	java/lang/Throwable
    //   3268	3274	2172	java/lang/Throwable
    //   3286	3292	2172	java/lang/Throwable
    //   3455	3461	2172	java/lang/Throwable
    //   3473	3479	2172	java/lang/Throwable
    //   3491	3497	2172	java/lang/Throwable
    //   4554	4560	2172	java/lang/Throwable
    //   4571	4577	2172	java/lang/Throwable
    //   4588	4594	2172	java/lang/Throwable
    //   4605	4612	2172	java/lang/Throwable
    //   4623	4636	2172	java/lang/Throwable
    //   4767	4773	2172	java/lang/Throwable
    //   4785	4791	2172	java/lang/Throwable
    //   4803	4809	2172	java/lang/Throwable
    //   4895	4901	2172	java/lang/Throwable
    //   4913	4919	2172	java/lang/Throwable
    //   4931	4937	2172	java/lang/Throwable
    //   5061	5073	2172	java/lang/Throwable
    //   5084	5092	2172	java/lang/Throwable
    //   5103	5109	2172	java/lang/Throwable
    //   5120	5130	2172	java/lang/Throwable
    //   5190	5198	2172	java/lang/Throwable
    //   5209	5222	2172	java/lang/Throwable
    //   5280	5291	2172	java/lang/Throwable
    //   5309	5319	2172	java/lang/Throwable
    //   5332	5345	2172	java/lang/Throwable
    //   5403	5409	2172	java/lang/Throwable
    //   5420	5433	2172	java/lang/Throwable
    //   5505	5516	2172	java/lang/Throwable
    //   5527	5540	2172	java/lang/Throwable
    //   5654	5665	2172	java/lang/Throwable
    //   5683	5700	2172	java/lang/Throwable
    //   5711	5718	2172	java/lang/Throwable
    //   5729	5742	2172	java/lang/Throwable
    //   5849	5860	2172	java/lang/Throwable
    //   5899	5904	2172	java/lang/Throwable
    //   5915	5922	2172	java/lang/Throwable
    //   5933	5946	2172	java/lang/Throwable
    //   6053	6062	2172	java/lang/Throwable
    //   6073	6080	2172	java/lang/Throwable
    //   6098	6103	2172	java/lang/Throwable
    //   6163	6176	2172	java/lang/Throwable
    //   756	785	2446	finally
    //   796	804	2446	finally
    //   815	839	2446	finally
    //   850	873	2446	finally
    //   884	894	2446	finally
    //   912	922	2446	finally
    //   933	942	2446	finally
    //   953	961	2446	finally
    //   972	985	2446	finally
    //   1043	1066	2446	finally
    //   1089	1098	2446	finally
    //   1109	1117	2446	finally
    //   1128	1141	2446	finally
    //   1199	1204	2446	finally
    //   1215	1222	2446	finally
    //   1233	1239	2446	finally
    //   1250	1287	2446	finally
    //   1298	1310	2446	finally
    //   1321	1330	2446	finally
    //   1341	1347	2446	finally
    //   1358	1364	2446	finally
    //   1378	1385	2446	finally
    //   1396	1402	2446	finally
    //   1413	1436	2446	finally
    //   1447	1456	2446	finally
    //   1467	1491	2446	finally
    //   1502	1536	2446	finally
    //   1547	1553	2446	finally
    //   1573	1579	2446	finally
    //   1590	1598	2446	finally
    //   1609	1618	2446	finally
    //   1629	1636	2446	finally
    //   1647	1655	2446	finally
    //   1666	1672	2446	finally
    //   1683	1688	2446	finally
    //   1699	1706	2446	finally
    //   1717	1731	2446	finally
    //   1742	1750	2446	finally
    //   1761	1783	2446	finally
    //   1794	1802	2446	finally
    //   1817	1827	2446	finally
    //   1838	1849	2446	finally
    //   1860	1866	2446	finally
    //   1877	1887	2446	finally
    //   1898	1902	2446	finally
    //   1913	1919	2446	finally
    //   1930	1940	2446	finally
    //   1951	1960	2446	finally
    //   1971	1978	2446	finally
    //   1989	2002	2446	finally
    //   2060	2066	2446	finally
    //   2080	2117	2446	finally
    //   2128	2169	2446	finally
    //   2182	2190	2446	finally
    //   2198	2205	2446	finally
    //   2209	2217	2446	finally
    //   2221	2260	2446	finally
    //   2264	2272	2446	finally
    //   2276	2289	2446	finally
    //   2360	2368	2446	finally
    //   2379	2391	2446	finally
    //   2402	2410	2446	finally
    //   2421	2427	2446	finally
    //   2438	2443	2446	finally
    //   2518	2533	2446	finally
    //   2544	2569	2446	finally
    //   2580	2591	2446	finally
    //   2602	2623	2446	finally
    //   2641	2651	2446	finally
    //   2662	2699	2446	finally
    //   2714	2721	2446	finally
    //   2732	2738	2446	finally
    //   2749	2759	2446	finally
    //   2770	2777	2446	finally
    //   2788	2795	2446	finally
    //   2860	2898	2446	finally
    //   2909	2922	2446	finally
    //   2980	2990	2446	finally
    //   3001	3014	2446	finally
    //   3037	3045	2446	finally
    //   3250	3256	2446	finally
    //   3268	3274	2446	finally
    //   3286	3292	2446	finally
    //   3455	3461	2446	finally
    //   3473	3479	2446	finally
    //   3491	3497	2446	finally
    //   4554	4560	2446	finally
    //   4571	4577	2446	finally
    //   4588	4594	2446	finally
    //   4605	4612	2446	finally
    //   4623	4636	2446	finally
    //   4767	4773	2446	finally
    //   4785	4791	2446	finally
    //   4803	4809	2446	finally
    //   4895	4901	2446	finally
    //   4913	4919	2446	finally
    //   4931	4937	2446	finally
    //   5061	5073	2446	finally
    //   5084	5092	2446	finally
    //   5103	5109	2446	finally
    //   5120	5130	2446	finally
    //   5190	5198	2446	finally
    //   5209	5222	2446	finally
    //   5280	5291	2446	finally
    //   5309	5319	2446	finally
    //   5332	5345	2446	finally
    //   5403	5409	2446	finally
    //   5420	5433	2446	finally
    //   5505	5516	2446	finally
    //   5527	5540	2446	finally
    //   5654	5665	2446	finally
    //   5683	5700	2446	finally
    //   5711	5718	2446	finally
    //   5729	5742	2446	finally
    //   5849	5860	2446	finally
    //   5899	5904	2446	finally
    //   5915	5922	2446	finally
    //   5933	5946	2446	finally
    //   6053	6062	2446	finally
    //   6073	6080	2446	finally
    //   6098	6103	2446	finally
    //   6163	6176	2446	finally
    //   6227	6232	2446	finally
    //   6236	6249	2446	finally
    //   6253	6260	2446	finally
    //   6264	6277	2446	finally
    //   3059	3068	3385	java/io/IOException
    //   3073	3095	3385	java/io/IOException
    //   3352	3382	3385	java/io/IOException
    //   3134	3139	4043	finally
    //   3848	3857	4043	finally
    //   3865	3901	4043	finally
    //   3909	3922	4043	finally
    //   3936	3946	4043	finally
    //   3954	3963	4043	finally
    //   3971	4016	4043	finally
    //   4024	4037	4043	finally
    //   4049	4070	4070	java/lang/Throwable
    //   3402	3418	5008	finally
    //   3418	3443	5008	finally
    //   4687	4755	5008	finally
    //   4858	4883	5008	finally
    //   4992	5005	5008	finally
    //   4049	4070	6435	finally
    //   3045	3054	6440	finally
    //   3059	3068	6454	finally
    //   3073	3095	6454	finally
    //   3352	3382	6454	finally
    //   3095	3126	6465	finally
    //   3159	3166	6473	finally
    //   3180	3189	6473	finally
    //   3203	3216	6473	finally
    //   3573	3586	6473	finally
    //   3605	3612	6473	finally
    //   3626	3636	6473	finally
    //   3654	3662	6473	finally
    //   3684	3689	6473	finally
    //   3709	3714	6473	finally
    //   3731	3738	6473	finally
    //   3757	3770	6473	finally
    //   3787	3797	6473	finally
    //   3811	3816	6473	finally
    //   4105	4115	6473	finally
    //   4129	4134	6473	finally
    //   4168	4205	6473	finally
    //   4219	4225	6473	finally
    //   4239	4255	6473	finally
    //   4269	4279	6473	finally
    //   4309	4319	6473	finally
    //   4333	4344	6473	finally
    //   4358	4364	6473	finally
    //   4378	4388	6473	finally
    //   4402	4406	6473	finally
    //   4420	4426	6473	finally
    //   4440	4450	6473	finally
    //   4464	4473	6473	finally
    //   4487	4500	6473	finally
    //   3045	3054	6485	java/io/IOException
    //   3095	3126	6497	java/io/IOException
    //   3159	3166	6525	java/io/IOException
    //   3180	3189	6525	java/io/IOException
    //   3203	3216	6525	java/io/IOException
    //   3573	3586	6525	java/io/IOException
    //   3605	3612	6525	java/io/IOException
    //   3626	3636	6525	java/io/IOException
    //   3654	3662	6525	java/io/IOException
    //   3684	3689	6525	java/io/IOException
    //   3709	3714	6525	java/io/IOException
    //   3731	3738	6525	java/io/IOException
    //   3757	3770	6525	java/io/IOException
    //   3787	3797	6525	java/io/IOException
    //   3811	3816	6525	java/io/IOException
    //   4105	4115	6525	java/io/IOException
    //   4129	4134	6525	java/io/IOException
    //   4168	4205	6525	java/io/IOException
    //   4219	4225	6525	java/io/IOException
    //   4239	4255	6525	java/io/IOException
    //   4269	4279	6525	java/io/IOException
    //   4309	4319	6525	java/io/IOException
    //   4333	4344	6525	java/io/IOException
    //   4358	4364	6525	java/io/IOException
    //   4378	4388	6525	java/io/IOException
    //   4402	4406	6525	java/io/IOException
    //   4420	4426	6525	java/io/IOException
    //   4440	4450	6525	java/io/IOException
    //   4464	4473	6525	java/io/IOException
    //   4487	4500	6525	java/io/IOException
    //   3134	3139	6576	java/io/IOException
    //   3848	3857	6576	java/io/IOException
    //   3865	3901	6576	java/io/IOException
    //   3909	3922	6576	java/io/IOException
    //   3936	3946	6576	java/io/IOException
    //   3954	3963	6576	java/io/IOException
    //   3971	4016	6576	java/io/IOException
    //   4024	4037	6576	java/io/IOException
  }
  
  public void c()
  {
    this.r = true;
    TbsLogReport.TbsLogInfo localTbsLogInfo;
    if (TbsShareManager.isThirdPartyApp(this.g))
    {
      localTbsLogInfo = TbsLogReport.getInstance(this.g).tbsLogInfo();
      localTbsLogInfo.setErrorCode(-309);
      localTbsLogInfo.setFailDetail(new Exception());
      if (TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_downloaddecouplecore", 0) == 1) {
        TbsLogReport.getInstance(this.g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE, localTbsLogInfo);
      }
    }
    else
    {
      return;
    }
    TbsLogReport.getInstance(this.g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, localTbsLogInfo);
  }
  
  public void d()
  {
    c();
    c(false);
    c(true);
  }
  
  public boolean e()
  {
    TbsLog.i("TbsDownload", "[TbsApkDownloader.isDownloadForeground] mIsDownloadForeground=" + this.C);
    return this.C;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.smtt.sdk.ag
 * JD-Core Version:    0.7.0.1
 */