package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.a;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.k;
import com.tencent.smtt.utils.y;
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

class ah
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
  
  public ah(Context paramContext)
  {
    AppMethodBeat.i(139195);
    this.m = 30000;
    this.n = 20000;
    this.B = d;
    this.b = null;
    this.c = 0;
    this.g = paramContext.getApplicationContext();
    this.v = TbsLogReport.getInstance(this.g).tbsLogInfo();
    this.A = new HashSet();
    this.u = ("tbs_downloading_" + this.g.getPackageName());
    ao.a();
    this.k = ao.s(this.g);
    if (this.k == null)
    {
      paramContext = new NullPointerException("TbsCorePrivateDir is null!");
      AppMethodBeat.o(139195);
      throw paramContext;
    }
    e();
    this.w = null;
    this.x = -1;
    AppMethodBeat.o(139195);
  }
  
  private long a(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(139203);
    long l1 = System.currentTimeMillis();
    this.v.setDownConsumeTime(l1 - paramLong1);
    this.v.setDownloadSize(paramLong2);
    AppMethodBeat.o(139203);
    return l1;
  }
  
  @TargetApi(8)
  static File a(Context paramContext)
  {
    AppMethodBeat.i(139219);
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 8)
        {
          paramContext = new File(k.a(paramContext, 4));
          if ((paramContext != null) && (!paramContext.exists()) && (!paramContext.isDirectory())) {
            paramContext.mkdirs();
          }
          AppMethodBeat.o(139219);
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        TbsLog.e("TbsDownload", "[TbsApkDownloader.backupApkPath] Exception is " + paramContext.getMessage());
        AppMethodBeat.o(139219);
        return null;
      }
      paramContext = null;
    }
  }
  
  private static File a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(139221);
    File localFile = new File(k.a(paramContext, paramInt));
    if ((!localFile.exists()) || (!localFile.isDirectory()))
    {
      AppMethodBeat.o(139221);
      return null;
    }
    if (TbsDownloader.getOverSea(paramContext)) {}
    for (paramContext = "x5.oversea.tbs.org"; new File(localFile, paramContext).exists(); paramContext = "x5.tbs.org")
    {
      AppMethodBeat.o(139221);
      return localFile;
    }
    AppMethodBeat.o(139221);
    return null;
  }
  
  private String a(Throwable paramThrowable)
  {
    AppMethodBeat.i(139205);
    paramThrowable = Log.getStackTraceString(paramThrowable);
    if (paramThrowable.length() > 1024)
    {
      paramThrowable = paramThrowable.substring(0, 1024);
      AppMethodBeat.o(139205);
      return paramThrowable;
    }
    AppMethodBeat.o(139205);
    return paramThrowable;
  }
  
  private String a(URL paramURL)
  {
    AppMethodBeat.i(139218);
    String str = "";
    try
    {
      paramURL = InetAddress.getByName(paramURL.getHost()).getHostAddress();
      AppMethodBeat.o(139218);
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
    AppMethodBeat.i(139204);
    if ((paramBoolean) || (this.p > this.B))
    {
      this.v.setErrorCode(paramInt);
      this.v.setFailDetail(paramString);
    }
    AppMethodBeat.o(139204);
  }
  
  private void a(long paramLong)
  {
    AppMethodBeat.i(139210);
    this.p += 1;
    long l1 = paramLong;
    if (paramLong <= 0L) {}
    try
    {
      l1 = l();
      Thread.sleep(l1);
      AppMethodBeat.o(139210);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(139210);
    }
  }
  
  private void a(Closeable paramCloseable)
  {
    AppMethodBeat.i(139209);
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        AppMethodBeat.o(139209);
        return;
      }
      catch (IOException paramCloseable) {}
    }
    AppMethodBeat.o(139209);
  }
  
  public static void a(File paramFile, Context paramContext)
  {
    int i1 = 0;
    AppMethodBeat.i(139226);
    if (paramFile != null) {}
    label449:
    for (;;)
    {
      try
      {
        if (!paramFile.exists()) {
          return;
        }
        File localFile;
        try
        {
          localFile = a(paramContext);
          if (localFile != null)
          {
            if (TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_download_version_type", 0) == 1)
            {
              localObject1 = new File(localFile, "x5.tbs.decouple");
              ((File)localObject1).delete();
              k.b(paramFile, (File)localObject1);
              if (!((File)localObject1).getName().contains("tbs.org")) {
                continue;
              }
              localObject1 = localFile.listFiles();
              Pattern localPattern = Pattern.compile("x5.backup(.*)");
              int i2 = localObject1.length;
              if (i1 >= i2) {
                continue;
              }
              Object localObject2 = localObject1[i1];
              if ((!localPattern.matcher(localObject2.getName()).find()) || (!localObject2.isFile()) || (!localObject2.exists())) {
                break label449;
              }
              localObject2.delete();
              break label449;
            }
            if (!TbsDownloader.getOverSea(paramContext)) {
              continue;
            }
            localObject1 = "x5.oversea.tbs.org";
            localObject1 = new File(localFile, (String)localObject1);
            continue;
          }
          localObject1 = "x5.tbs.org";
        }
        catch (Exception paramFile)
        {
          return;
        }
        continue;
        Object localObject1 = new File(localFile, "x5.backup.".concat(String.valueOf(TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_download_version", 0))));
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
          localObject1 = new File(localFile, "x5.tbs.decouple");
          if (a.a(paramContext, paramFile) != a.a(paramContext, (File)localObject1))
          {
            ((File)localObject1).delete();
            k.b(paramFile, (File)localObject1);
            continue;
            i1 += 1;
          }
        }
      }
      finally
      {
        AppMethodBeat.o(139226);
      }
    }
  }
  
  private void a(String paramString)
  {
    AppMethodBeat.i(139196);
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
      AppMethodBeat.o(139196);
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
    AppMethodBeat.i(139220);
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
          AppMethodBeat.o(139220);
          return localObject1;
        }
      }
      catch (Exception paramContext)
      {
        TbsLog.e("TbsDownload", "[TbsApkDownloader.backupApkPath] Exception is " + paramContext.getMessage());
        AppMethodBeat.o(139220);
        return null;
      }
      Object localObject1 = null;
    }
  }
  
  private boolean b(int paramInt)
  {
    AppMethodBeat.i(139198);
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
          k.b((File)localObject, localFile1);
          if (a.a(this.g, localFile1, 0L, paramInt)) {
            break;
          }
          TbsLog.i("TbsDownload", "[TbsApkDownloader.copyTbsApkFromBackupToInstall] verifyTbsApk error!!");
          AppMethodBeat.o(139198);
          return false;
        }
      }
      AppMethodBeat.o(139198);
      return false;
    }
    catch (Exception localException)
    {
      TbsLog.e("TbsDownload", "[TbsApkDownloader.copyTbsApkFromBackupToInstall] Exception is " + localException.getMessage());
      AppMethodBeat.o(139198);
      return false;
    }
    AppMethodBeat.o(139198);
    return true;
  }
  
  public static void c(Context paramContext)
  {
    AppMethodBeat.i(139227);
    try
    {
      ao.a();
      Object localObject1 = ao.s(paramContext);
      new File((File)localObject1, "x5.tbs").delete();
      new File((File)localObject1, "x5.tbs.temp").delete();
      paramContext = a(paramContext);
      if (paramContext != null)
      {
        new File(paramContext, "x5.tbs.org").delete();
        new File(paramContext, "x5.oversea.tbs.org").delete();
        paramContext = paramContext.listFiles();
        localObject1 = Pattern.compile("x5.backup(.*)");
        int i2 = paramContext.length;
        int i1 = 0;
        while (i1 < i2)
        {
          Object localObject2 = paramContext[i1];
          if ((((Pattern)localObject1).matcher(localObject2.getName()).find()) && (localObject2.isFile()) && (localObject2.exists())) {
            localObject2.delete();
          }
          i1 += 1;
        }
      }
      AppMethodBeat.o(139227);
      return;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(139227);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    AppMethodBeat.i(139206);
    y.a(this.g);
    Object localObject1 = TbsDownloadConfig.getInstance(this.g);
    ((TbsDownloadConfig)localObject1).a.put("request_full_package", Boolean.FALSE);
    ((TbsDownloadConfig)localObject1).a.put("tbs_needdownload", Boolean.FALSE);
    ((TbsDownloadConfig)localObject1).a.put("tbs_download_interrupt_code_reason", Integer.valueOf(-123));
    ((TbsDownloadConfig)localObject1).commit();
    Object localObject2 = QbSdk.m;
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
      AppMethodBeat.o(139206);
      return;
    }
    ao.a().b(this.g, (Bundle)localObject1);
    AppMethodBeat.o(139206);
    return;
    label165:
    if ((i1 == 3) || (i1 > 10000))
    {
      localObject2 = a(this.g);
      if (localObject2 != null)
      {
        localObject1 = a(i1, (File)localObject2, paramBoolean);
        ao.a().b(this.g, (Bundle)localObject1);
        AppMethodBeat.o(139206);
        return;
      }
      c();
      ((TbsDownloadConfig)localObject1).a.put("tbs_needdownload", Boolean.TRUE);
      ((TbsDownloadConfig)localObject1).commit();
      AppMethodBeat.o(139206);
      return;
    }
    i1 = ((TbsDownloadConfig)localObject1).mPreferences.getInt("tbs_download_version", 0);
    ao.a().a(this.g, new File(this.k, "x5.tbs").getAbsolutePath(), i1);
    a(new File(this.k, "x5.tbs"), this.g);
    AppMethodBeat.o(139206);
  }
  
  private boolean c(boolean paramBoolean1, boolean paramBoolean2)
  {
    long l2 = 0L;
    AppMethodBeat.i(139212);
    TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=".concat(String.valueOf(paramBoolean1)));
    Object localObject2 = this.k;
    if (!paramBoolean1) {}
    for (Object localObject1 = "x5.tbs";; localObject1 = "x5.tbs.temp")
    {
      localObject1 = new File((File)localObject2, (String)localObject1);
      if (((File)localObject1).exists()) {
        break;
      }
      AppMethodBeat.o(139212);
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
      AppMethodBeat.o(139212);
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
      AppMethodBeat.o(139212);
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
            AppMethodBeat.o(139212);
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
            AppMethodBeat.o(139212);
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
        AppMethodBeat.o(139212);
        return false;
      }
      paramBoolean2 = false;
      label723:
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] rename(" + paramBoolean2 + ") successful!");
      AppMethodBeat.o(139212);
      return true;
      label759:
      l1 = 0L;
    }
  }
  
  private boolean d(boolean paramBoolean)
  {
    AppMethodBeat.i(139213);
    TbsLog.i("TbsDownload", "[TbsApkDownloader.deleteFile] isApk=".concat(String.valueOf(paramBoolean)));
    File localFile;
    if (paramBoolean)
    {
      localFile = new File(this.k, "x5.tbs");
      if (!localFile.exists()) {
        break label78;
      }
    }
    label78:
    for (paramBoolean = localFile.delete();; paramBoolean = true)
    {
      AppMethodBeat.o(139213);
      return paramBoolean;
      localFile = new File(this.k, "x5.tbs.temp");
      break;
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
    AppMethodBeat.i(139197);
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
            QbSdk.m.onDownloadFinish(i1);
          }
          AppMethodBeat.o(139197);
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
      AppMethodBeat.o(139197);
    }
  }
  
  private boolean g()
  {
    AppMethodBeat.i(139211);
    String str = k.a(this.g, 4);
    if (TbsDownloader.getOverSea(this.g)) {}
    for (Object localObject = "x5.oversea.tbs.org";; localObject = "x5.tbs.org")
    {
      localObject = new File(str, (String)localObject);
      int i2 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("use_backup_version", 0);
      int i1 = i2;
      if (i2 == 0) {
        i1 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_download_version", 0);
      }
      boolean bool = a.a(this.g, (File)localObject, 0L, i1);
      AppMethodBeat.o(139211);
      return bool;
    }
  }
  
  private void h()
  {
    AppMethodBeat.i(139214);
    for (;;)
    {
      int i1;
      try
      {
        boolean bool = TbsDownloader.a(this.g);
        if (bool)
        {
          AppMethodBeat.o(139214);
          return;
        }
        Object localObject2 = k.a(this.g, 4);
        Object localObject1;
        if (TbsDownloader.getOverSea(this.g))
        {
          localObject1 = "x5.oversea.tbs.org";
          localObject1 = new File((String)localObject2, (String)localObject1);
          if (((File)localObject1).exists())
          {
            ((File)localObject1).delete();
            localObject1 = ((File)localObject1).getParentFile().listFiles();
            localObject2 = Pattern.compile("x5.backup(.*)");
            int i2 = localObject1.length;
            i1 = 0;
            if (i1 < i2)
            {
              Object localObject3 = localObject1[i1];
              if ((!((Pattern)localObject2).matcher(localObject3.getName()).find()) || (!localObject3.isFile()) || (!localObject3.exists())) {
                break label175;
              }
              localObject3.delete();
              break label175;
            }
          }
        }
        else
        {
          localObject1 = "x5.tbs.org";
          continue;
        }
        AppMethodBeat.o(139214);
        return;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(139214);
        return;
      }
      label175:
      i1 += 1;
    }
  }
  
  private boolean i()
  {
    AppMethodBeat.i(139215);
    boolean bool = false;
    if (new File(this.k, "x5.tbs.temp").exists()) {
      bool = true;
    }
    AppMethodBeat.o(139215);
    return bool;
  }
  
  private long j()
  {
    AppMethodBeat.i(139216);
    long l1 = 0L;
    File localFile = new File(this.k, "x5.tbs.temp");
    if (localFile.exists()) {
      l1 = localFile.length();
    }
    AppMethodBeat.o(139216);
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
    //   6: ldc_w 707
    //   9: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: invokestatic 713	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   15: astore 6
    //   17: aload 6
    //   19: ldc_w 715
    //   22: ldc_w 717
    //   25: invokestatic 720	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   28: invokevirtual 366	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   31: invokevirtual 724	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   34: invokevirtual 730	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   37: astore 8
    //   39: new 732	java/io/InputStreamReader
    //   42: dup
    //   43: aload 8
    //   45: invokespecial 735	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   48: astore 9
    //   50: new 737	java/io/BufferedReader
    //   53: dup
    //   54: aload 9
    //   56: invokespecial 740	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   59: astore 7
    //   61: iconst_0
    //   62: istore_1
    //   63: aload 7
    //   65: invokevirtual 743	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   68: astore 6
    //   70: iload 4
    //   72: istore_3
    //   73: aload 6
    //   75: ifnull +29 -> 104
    //   78: aload 6
    //   80: ldc_w 745
    //   83: invokevirtual 330	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   86: ifne +16 -> 102
    //   89: aload 6
    //   91: ldc_w 747
    //   94: invokevirtual 330	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   97: istore_3
    //   98: iload_3
    //   99: ifeq +31 -> 130
    //   102: iconst_1
    //   103: istore_3
    //   104: aload_0
    //   105: aload 8
    //   107: invokespecial 749	com/tencent/smtt/sdk/ah:a	(Ljava/io/Closeable;)V
    //   110: aload_0
    //   111: aload 9
    //   113: invokespecial 749	com/tencent/smtt/sdk/ah:a	(Ljava/io/Closeable;)V
    //   116: aload_0
    //   117: aload 7
    //   119: invokespecial 749	com/tencent/smtt/sdk/ah:a	(Ljava/io/Closeable;)V
    //   122: ldc_w 707
    //   125: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   161: invokespecial 749	com/tencent/smtt/sdk/ah:a	(Ljava/io/Closeable;)V
    //   164: aload_0
    //   165: aload 7
    //   167: invokespecial 749	com/tencent/smtt/sdk/ah:a	(Ljava/io/Closeable;)V
    //   170: aload_0
    //   171: aload 6
    //   173: invokespecial 749	com/tencent/smtt/sdk/ah:a	(Ljava/io/Closeable;)V
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
    //   196: invokespecial 749	com/tencent/smtt/sdk/ah:a	(Ljava/io/Closeable;)V
    //   199: aload_0
    //   200: aload 9
    //   202: invokespecial 749	com/tencent/smtt/sdk/ah:a	(Ljava/io/Closeable;)V
    //   205: aload_0
    //   206: aload 7
    //   208: invokespecial 749	com/tencent/smtt/sdk/ah:a	(Ljava/io/Closeable;)V
    //   211: ldc_w 707
    //   214: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	280	0	this	ah
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
    //   12: ldc_w 756
    //   15: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   18: aload_0
    //   19: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   22: invokestatic 657	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   25: iconst_3
    //   26: if_icmpne +252 -> 278
    //   29: iconst_1
    //   30: istore_3
    //   31: ldc 202
    //   33: ldc_w 758
    //   36: iload_3
    //   37: invokestatic 529	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   40: invokevirtual 366	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   43: invokestatic 389	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: iload 5
    //   48: istore_2
    //   49: iload_3
    //   50: ifeq +121 -> 171
    //   53: aload_0
    //   54: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   57: invokestatic 761	com/tencent/smtt/utils/Apn:getWifiSSID	(Landroid/content/Context;)Ljava/lang/String;
    //   60: astore 6
    //   62: ldc 202
    //   64: ldc_w 763
    //   67: aload 6
    //   69: invokestatic 720	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   72: invokevirtual 366	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   75: invokestatic 389	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: new 251	java/net/URL
    //   81: dup
    //   82: ldc_w 765
    //   85: invokespecial 393	java/net/URL:<init>	(Ljava/lang/String;)V
    //   88: invokevirtual 404	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   91: checkcast 397	java/net/HttpURLConnection
    //   94: astore 7
    //   96: aload 7
    //   98: iconst_0
    //   99: invokevirtual 425	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   102: aload 7
    //   104: sipush 10000
    //   107: invokevirtual 428	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   110: aload 7
    //   112: sipush 10000
    //   115: invokevirtual 431	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   118: aload 7
    //   120: iconst_0
    //   121: invokevirtual 768	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   124: aload 7
    //   126: invokevirtual 769	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   129: pop
    //   130: aload 7
    //   132: invokevirtual 772	java/net/HttpURLConnection:getResponseCode	()I
    //   135: istore_1
    //   136: ldc 202
    //   138: ldc_w 774
    //   141: iload_1
    //   142: invokestatic 362	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   145: invokevirtual 366	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   148: invokestatic 389	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: iload_1
    //   152: sipush 204
    //   155: if_icmpne +128 -> 283
    //   158: iload 4
    //   160: istore_2
    //   161: aload 7
    //   163: ifnull +205 -> 368
    //   166: aload 7
    //   168: invokevirtual 400	java/net/HttpURLConnection:disconnect	()V
    //   171: iload_2
    //   172: ifne +68 -> 240
    //   175: aload 6
    //   177: invokestatic 779	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   180: ifne +60 -> 240
    //   183: aload_0
    //   184: getfield 111	com/tencent/smtt/sdk/ah:A	Ljava/util/Set;
    //   187: aload 6
    //   189: invokeinterface 783 2 0
    //   194: ifne +46 -> 240
    //   197: aload_0
    //   198: getfield 111	com/tencent/smtt/sdk/ah:A	Ljava/util/Set;
    //   201: aload 6
    //   203: invokeinterface 786 2 0
    //   208: pop
    //   209: aload_0
    //   210: invokespecial 788	com/tencent/smtt/sdk/ah:n	()V
    //   213: aload_0
    //   214: getfield 790	com/tencent/smtt/sdk/ah:z	Landroid/os/Handler;
    //   217: sipush 150
    //   220: aload 6
    //   222: invokevirtual 796	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   225: astore 7
    //   227: aload_0
    //   228: getfield 790	com/tencent/smtt/sdk/ah:z	Landroid/os/Handler;
    //   231: aload 7
    //   233: ldc2_w 797
    //   236: invokevirtual 802	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   239: pop
    //   240: iload_2
    //   241: ifeq +29 -> 270
    //   244: aload_0
    //   245: getfield 111	com/tencent/smtt/sdk/ah:A	Ljava/util/Set;
    //   248: aload 6
    //   250: invokeinterface 783 2 0
    //   255: ifeq +15 -> 270
    //   258: aload_0
    //   259: getfield 111	com/tencent/smtt/sdk/ah:A	Ljava/util/Set;
    //   262: aload 6
    //   264: invokeinterface 805 2 0
    //   269: pop
    //   270: ldc_w 756
    //   273: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   305: invokevirtual 400	java/net/HttpURLConnection:disconnect	()V
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
    //   335: invokevirtual 400	java/net/HttpURLConnection:disconnect	()V
    //   338: ldc_w 756
    //   341: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	371	0	this	ah
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
    AppMethodBeat.i(139229);
    if (this.z == null) {
      this.z = new ai(this, am.a().getLooper());
    }
    AppMethodBeat.o(139229);
  }
  
  public Bundle a(int paramInt, File paramFile, boolean paramBoolean)
  {
    AppMethodBeat.i(139208);
    int i1;
    if (paramBoolean)
    {
      paramFile = new File(paramFile, "x5.tbs.decouple");
      i1 = a.a(this.g, paramFile);
      localObject = new File(this.k, "x5.tbs");
      if (!((File)localObject).exists()) {
        break label198;
      }
    }
    label198:
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
      AppMethodBeat.o(139208);
      return localBundle;
      if (TbsDownloader.getOverSea(this.g)) {}
      for (localObject = "x5.oversea.tbs.org";; localObject = "x5.tbs.org")
      {
        paramFile = new File(paramFile, (String)localObject);
        break;
      }
    }
  }
  
  public Bundle a(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(139207);
    Object localObject1;
    int i1;
    if (paramBoolean)
    {
      localObject1 = ao.a().p(this.g);
      i1 = ao.a().h(this.g);
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
      AppMethodBeat.o(139207);
      return null;
      localObject1 = ao.a().q(this.g);
      i1 = ao.a().i(this.g);
      break;
    }
    label109:
    int i2 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_download_version", 0);
    if (paramBoolean) {}
    for (File localFile = ao.a().f(this.g, 6);; localFile = ao.a().f(this.g, 5))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("operation", paramInt);
      localBundle.putInt("old_core_ver", i1);
      localBundle.putInt("new_core_ver", i2);
      localBundle.putString("old_apk_location", ((File)localObject1).getAbsolutePath());
      localBundle.putString("new_apk_location", localFile.getAbsolutePath());
      localBundle.putString("diff_file_location", (String)localObject2);
      localObject1 = k.a(this.g, 7);
      localObject2 = new File((String)localObject1);
      if (!((File)localObject2).exists()) {
        ((File)localObject2).mkdirs();
      }
      localBundle.putString("backup_apk", new File((String)localObject1, i2 + ".tbs").getAbsolutePath());
      AppMethodBeat.o(139207);
      return localBundle;
    }
  }
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(139225);
    if (ao.a().t(this.g))
    {
      ao.a().b();
      try
      {
        File localFile = new File(this.k, "x5.tbs");
        int i1 = a.a(this.g, localFile);
        if ((-1 == i1) || ((paramInt > 0) && (paramInt == i1))) {
          k.b(localFile);
        }
        AppMethodBeat.o(139225);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(139225);
  }
  
  public boolean a()
  {
    AppMethodBeat.i(139200);
    TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #1");
    try
    {
      File localFile1 = new File(k.a(this.g, 4), "x5.tbs.decouple");
      if (localFile1.exists()) {
        TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #2");
      }
      while (a.a(this.g, localFile1, 0L, TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_decouplecoreversion", -1)))
      {
        TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #3");
        boolean bool = ao.a().e(this.g);
        AppMethodBeat.o(139200);
        return bool;
        File localFile2 = TbsDownloader.b(TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_decouplecoreversion", -1));
        if ((localFile2 != null) && (localFile2.exists())) {
          k.b(localFile2, localFile1);
        }
      }
      return false;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(139200);
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    AppMethodBeat.i(139202);
    if ((paramBoolean) && (!m()) && ((!QbSdk.getDownloadWithoutWifi()) || (!Apn.isNetworkAvailable(this.g))))
    {
      AppMethodBeat.o(139202);
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
      AppMethodBeat.o(139202);
      return true;
    }
    AppMethodBeat.o(139202);
    return false;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(139199);
    if (Build.VERSION.SDK_INT == 23)
    {
      AppMethodBeat.o(139199);
      return false;
    }
    int i1 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("use_backup_version", 0);
    int i2 = ao.a().i(this.g);
    if (i1 == 0) {
      i1 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt("tbs_download_version", 0);
    }
    for (this.a = "by default key"; (i1 == 0) || (i1 == i2); this.a = "by new key")
    {
      AppMethodBeat.o(139199);
      return false;
    }
    if (paramBoolean2)
    {
      File localFile = TbsDownloader.a(i1);
      Object localObject;
      if ((localFile != null) && (localFile.exists()))
      {
        String str = k.a(this.g, 4);
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
            break label348;
          }
          k.b(localFile, (File)localObject);
          i2 = 1;
          if (!g()) {
            break label374;
          }
          if (!b(i1)) {
            break label397;
          }
          TbsDownloadConfig.getInstance(this.g).a.put("tbs_download_interrupt_code_reason", Integer.valueOf(-214));
          TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-214);
          c(false);
          if (i2 != 0)
          {
            a(100, "use local backup apk in startDownload" + this.a, true);
            if (!TbsDownloader.a(this.g)) {
              break label354;
            }
            TbsLogReport.getInstance(this.g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE, this.v);
            this.v.resetArgs();
          }
          AppMethodBeat.o(139199);
          return true;
        }
        catch (Exception localException) {}
        localObject = "x5.tbs.org";
        break;
        label348:
        i2 = 0;
        continue;
        label354:
        TbsLogReport.getInstance(this.g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, this.v);
      }
      label374:
      h();
      if (!a.a(this.g, localFile, 0L, i1)) {
        k.b(localFile);
      }
    }
    label397:
    if (c(false, paramBoolean2))
    {
      TbsDownloadConfig.getInstance(this.g).a.put("tbs_download_interrupt_code_reason", Integer.valueOf(-214));
      TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-214);
      c(false);
      AppMethodBeat.o(139199);
      return true;
    }
    if ((!d(true)) && (!d(true)))
    {
      TbsLog.e("TbsDownload", "[TbsApkDownloader] delete file failed!");
      TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-301);
    }
    AppMethodBeat.o(139199);
    return false;
  }
  
  public int b(boolean paramBoolean)
  {
    AppMethodBeat.i(139222);
    File localFile = a(this.g);
    int i1;
    if (paramBoolean)
    {
      if (localFile == null)
      {
        AppMethodBeat.o(139222);
        return 0;
      }
      i1 = a.a(this.g, new File(localFile, "x5.tbs.decouple"));
      AppMethodBeat.o(139222);
      return i1;
    }
    if (localFile == null)
    {
      AppMethodBeat.o(139222);
      return 0;
    }
    Context localContext = this.g;
    if (TbsDownloader.getOverSea(this.g)) {}
    for (String str = "x5.oversea.tbs.org";; str = "x5.tbs.org")
    {
      i1 = a.a(localContext, new File(localFile, str));
      AppMethodBeat.o(139222);
      return i1;
    }
  }
  
  public void b()
  {
    AppMethodBeat.i(139223);
    this.r = true;
    if (TbsShareManager.isThirdPartyApp(this.g))
    {
      TbsLogReport.TbsLogInfo localTbsLogInfo = TbsLogReport.getInstance(this.g).tbsLogInfo();
      localTbsLogInfo.setErrorCode(-309);
      localTbsLogInfo.setFailDetail(new Exception());
      if (TbsDownloader.a(this.g))
      {
        TbsLogReport.getInstance(this.g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE, localTbsLogInfo);
        AppMethodBeat.o(139223);
        return;
      }
      TbsLogReport.getInstance(this.g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, localTbsLogInfo);
    }
    AppMethodBeat.o(139223);
  }
  
  /* Error */
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: ldc_w 925
    //   3: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 136	com/tencent/smtt/sdk/ao:a	()Lcom/tencent/smtt/sdk/ao;
    //   9: aload_0
    //   10: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   13: invokevirtual 927	com/tencent/smtt/sdk/ao:c	(Landroid/content/Context;)Z
    //   16: ifeq +31 -> 47
    //   19: iload_1
    //   20: ifne +27 -> 47
    //   23: iconst_0
    //   24: putstatic 694	com/tencent/smtt/sdk/TbsDownloader:a	Z
    //   27: aload_0
    //   28: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   31: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   34: sipush -322
    //   37: invokevirtual 899	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   40: ldc_w 925
    //   43: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: return
    //   47: aload_0
    //   48: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   51: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   54: getfield 305	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   57: ldc_w 378
    //   60: iconst_0
    //   61: invokeinterface 313 3 0
    //   66: istore_3
    //   67: iload_3
    //   68: iconst_1
    //   69: if_icmpeq +13 -> 82
    //   72: iload_3
    //   73: iconst_2
    //   74: if_icmpeq +8 -> 82
    //   77: iload_3
    //   78: iconst_4
    //   79: if_icmpne +31 -> 110
    //   82: iconst_1
    //   83: istore 8
    //   85: iload_2
    //   86: ifne +30 -> 116
    //   89: aload_0
    //   90: iload_1
    //   91: iload 8
    //   93: invokevirtual 929	com/tencent/smtt/sdk/ah:a	(ZZ)Z
    //   96: ifeq +20 -> 116
    //   99: iconst_0
    //   100: putstatic 694	com/tencent/smtt/sdk/TbsDownloader:a	Z
    //   103: ldc_w 925
    //   106: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: return
    //   110: iconst_0
    //   111: istore 8
    //   113: goto -28 -> 85
    //   116: aload_0
    //   117: iload_1
    //   118: putfield 931	com/tencent/smtt/sdk/ah:C	Z
    //   121: aload_0
    //   122: aload_0
    //   123: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   126: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   129: getfield 305	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   132: ldc_w 933
    //   135: aconst_null
    //   136: invokeinterface 535 3 0
    //   141: putfield 935	com/tencent/smtt/sdk/ah:h	Ljava/lang/String;
    //   144: aload_0
    //   145: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   148: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   151: getfield 305	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   154: ldc_w 937
    //   157: aconst_null
    //   158: invokeinterface 535 3 0
    //   163: astore 29
    //   165: ldc 202
    //   167: ldc_w 939
    //   170: aload 29
    //   172: invokestatic 720	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   175: invokevirtual 366	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   178: iconst_1
    //   179: invokestatic 942	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   182: aload_0
    //   183: aconst_null
    //   184: putfield 84	com/tencent/smtt/sdk/ah:b	[Ljava/lang/String;
    //   187: aload_0
    //   188: iconst_0
    //   189: putfield 86	com/tencent/smtt/sdk/ah:c	I
    //   192: iload_1
    //   193: ifne +36 -> 229
    //   196: aload 29
    //   198: ifnull +31 -> 229
    //   201: ldc 249
    //   203: aload 29
    //   205: invokevirtual 945	java/lang/String:trim	()Ljava/lang/String;
    //   208: invokevirtual 542	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   211: ifne +18 -> 229
    //   214: aload_0
    //   215: aload 29
    //   217: invokevirtual 945	java/lang/String:trim	()Ljava/lang/String;
    //   220: ldc_w 947
    //   223: invokevirtual 951	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   226: putfield 84	com/tencent/smtt/sdk/ah:b	[Ljava/lang/String;
    //   229: ldc 202
    //   231: new 113	java/lang/StringBuilder
    //   234: dup
    //   235: ldc_w 953
    //   238: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   241: aload_0
    //   242: getfield 935	com/tencent/smtt/sdk/ah:h	Ljava/lang/String;
    //   245: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: ldc_w 955
    //   251: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: aload 29
    //   256: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: ldc_w 957
    //   262: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: aload_0
    //   266: getfield 623	com/tencent/smtt/sdk/ah:j	Ljava/lang/String;
    //   269: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: ldc_w 959
    //   275: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: aload_0
    //   279: getfield 627	com/tencent/smtt/sdk/ah:r	Z
    //   282: invokevirtual 545	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   285: ldc_w 961
    //   288: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: aload_0
    //   292: getfield 395	com/tencent/smtt/sdk/ah:t	Ljava/net/HttpURLConnection;
    //   295: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   298: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokestatic 389	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   304: aload_0
    //   305: getfield 935	com/tencent/smtt/sdk/ah:h	Ljava/lang/String;
    //   308: ifnonnull +40 -> 348
    //   311: aload_0
    //   312: getfield 623	com/tencent/smtt/sdk/ah:j	Ljava/lang/String;
    //   315: ifnonnull +33 -> 348
    //   318: getstatic 494	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   321: bipush 110
    //   323: invokeinterface 499 2 0
    //   328: aload_0
    //   329: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   332: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   335: sipush -302
    //   338: invokevirtual 899	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   341: ldc_w 925
    //   344: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   347: return
    //   348: aload_0
    //   349: getfield 395	com/tencent/smtt/sdk/ah:t	Ljava/net/HttpURLConnection;
    //   352: ifnull +40 -> 392
    //   355: aload_0
    //   356: getfield 627	com/tencent/smtt/sdk/ah:r	Z
    //   359: ifne +33 -> 392
    //   362: getstatic 494	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   365: bipush 110
    //   367: invokeinterface 499 2 0
    //   372: aload_0
    //   373: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   376: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   379: sipush -303
    //   382: invokevirtual 899	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   385: ldc_w 925
    //   388: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   391: return
    //   392: iload_1
    //   393: ifne +60 -> 453
    //   396: aload_0
    //   397: getfield 111	com/tencent/smtt/sdk/ah:A	Ljava/util/Set;
    //   400: aload_0
    //   401: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   404: invokestatic 761	com/tencent/smtt/utils/Apn:getWifiSSID	(Landroid/content/Context;)Ljava/lang/String;
    //   407: invokeinterface 783 2 0
    //   412: ifeq +41 -> 453
    //   415: ldc 202
    //   417: ldc_w 963
    //   420: invokestatic 389	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   423: getstatic 494	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   426: bipush 110
    //   428: invokeinterface 499 2 0
    //   433: aload_0
    //   434: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   437: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   440: sipush -304
    //   443: invokevirtual 899	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   446: ldc_w 925
    //   449: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   452: return
    //   453: aload_0
    //   454: invokespecial 150	com/tencent/smtt/sdk/ah:e	()V
    //   457: ldc 202
    //   459: ldc_w 965
    //   462: iconst_1
    //   463: invokestatic 942	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   466: aload_0
    //   467: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   470: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   473: invokevirtual 968	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMaxflow	()J
    //   476: lstore 27
    //   478: iconst_0
    //   479: istore_2
    //   480: aload_0
    //   481: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   484: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   487: getfield 305	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   490: ldc_w 970
    //   493: lconst_0
    //   494: invokeinterface 562 4 0
    //   499: lstore 13
    //   501: iload_1
    //   502: ifeq +255 -> 757
    //   505: aload_0
    //   506: getstatic 51	com/tencent/smtt/sdk/ah:e	I
    //   509: putfield 82	com/tencent/smtt/sdk/ah:B	I
    //   512: iload_2
    //   513: istore 5
    //   515: aload_0
    //   516: getfield 267	com/tencent/smtt/sdk/ah:p	I
    //   519: aload_0
    //   520: getfield 82	com/tencent/smtt/sdk/ah:B	I
    //   523: if_icmpgt +36 -> 559
    //   526: aload_0
    //   527: getfield 617	com/tencent/smtt/sdk/ah:q	I
    //   530: bipush 8
    //   532: if_icmple +235 -> 767
    //   535: aload_0
    //   536: bipush 123
    //   538: aconst_null
    //   539: iconst_1
    //   540: invokespecial 609	com/tencent/smtt/sdk/ah:a	(ILjava/lang/String;Z)V
    //   543: aload_0
    //   544: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   547: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   550: sipush -306
    //   553: invokevirtual 899	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   556: iload_2
    //   557: istore 5
    //   559: aload_0
    //   560: getfield 627	com/tencent/smtt/sdk/ah:r	Z
    //   563: ifne +183 -> 746
    //   566: iload 5
    //   568: istore_1
    //   569: aload_0
    //   570: getfield 629	com/tencent/smtt/sdk/ah:s	Z
    //   573: ifeq +102 -> 675
    //   576: iload 5
    //   578: istore_1
    //   579: aload_0
    //   580: getfield 84	com/tencent/smtt/sdk/ah:b	[Ljava/lang/String;
    //   583: ifnonnull +19 -> 602
    //   586: iload 5
    //   588: istore_1
    //   589: iload 5
    //   591: ifne +11 -> 602
    //   594: aload_0
    //   595: iconst_1
    //   596: iload 8
    //   598: invokespecial 907	com/tencent/smtt/sdk/ah:c	(ZZ)Z
    //   601: istore_1
    //   602: aload_0
    //   603: getfield 106	com/tencent/smtt/sdk/ah:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   606: astore 29
    //   608: iload_1
    //   609: ifeq +5736 -> 6345
    //   612: iconst_1
    //   613: istore_3
    //   614: aload 29
    //   616: iload_3
    //   617: invokevirtual 973	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setUnpkgFlag	(I)V
    //   620: iload 8
    //   622: ifne +5733 -> 6355
    //   625: aload_0
    //   626: getfield 106	com/tencent/smtt/sdk/ah:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   629: astore 29
    //   631: iload_1
    //   632: ifeq +5718 -> 6350
    //   635: iconst_1
    //   636: istore_3
    //   637: aload 29
    //   639: iload_3
    //   640: invokevirtual 976	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setPatchUpdateFlag	(I)V
    //   643: iload_1
    //   644: ifeq +5722 -> 6366
    //   647: aload_0
    //   648: iconst_1
    //   649: invokespecial 901	com/tencent/smtt/sdk/ah:c	(Z)V
    //   652: aload_0
    //   653: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   656: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   659: sipush -317
    //   662: invokevirtual 899	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   665: aload_0
    //   666: bipush 100
    //   668: ldc_w 978
    //   671: iconst_1
    //   672: invokespecial 609	com/tencent/smtt/sdk/ah:a	(ILjava/lang/String;Z)V
    //   675: aload_0
    //   676: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   679: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   682: astore 29
    //   684: iload_1
    //   685: ifeq +5703 -> 6388
    //   688: aload 29
    //   690: getfield 305	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   693: ldc_w 980
    //   696: iconst_0
    //   697: invokeinterface 313 3 0
    //   702: istore_3
    //   703: aload 29
    //   705: getfield 463	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   708: ldc_w 980
    //   711: iload_3
    //   712: iconst_1
    //   713: iadd
    //   714: invokestatic 486	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   717: invokeinterface 477 3 0
    //   722: pop
    //   723: aload 29
    //   725: invokevirtual 489	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   728: aload_0
    //   729: getfield 106	com/tencent/smtt/sdk/ah:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   732: astore 29
    //   734: iload_1
    //   735: ifeq +5714 -> 6449
    //   738: iconst_1
    //   739: istore_3
    //   740: aload 29
    //   742: iload_3
    //   743: invokevirtual 983	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownFinalFlag	(I)V
    //   746: aload_0
    //   747: invokespecial 985	com/tencent/smtt/sdk/ah:f	()V
    //   750: ldc_w 925
    //   753: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   756: return
    //   757: aload_0
    //   758: getstatic 49	com/tencent/smtt/sdk/ah:d	I
    //   761: putfield 82	com/tencent/smtt/sdk/ah:B	I
    //   764: goto -252 -> 512
    //   767: invokestatic 162	java/lang/System:currentTimeMillis	()J
    //   770: lstore 23
    //   772: lload 13
    //   774: lstore 9
    //   776: iload_1
    //   777: ifne +439 -> 1216
    //   780: lload 13
    //   782: lstore 15
    //   784: iload_2
    //   785: istore 5
    //   787: lload 13
    //   789: lstore 11
    //   791: lload 23
    //   793: aload_0
    //   794: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   797: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   800: getfield 305	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   803: ldc_w 987
    //   806: lconst_0
    //   807: invokeinterface 562 4 0
    //   812: lsub
    //   813: ldc2_w 988
    //   816: lcmp
    //   817: ifle +250 -> 1067
    //   820: lload 13
    //   822: lstore 15
    //   824: iload_2
    //   825: istore 5
    //   827: lload 13
    //   829: lstore 11
    //   831: ldc 202
    //   833: ldc_w 991
    //   836: invokestatic 389	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   839: lload 13
    //   841: lstore 15
    //   843: iload_2
    //   844: istore 5
    //   846: lload 13
    //   848: lstore 11
    //   850: aload_0
    //   851: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   854: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   857: getfield 463	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   860: ldc_w 987
    //   863: lload 23
    //   865: invokestatic 996	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   868: invokeinterface 477 3 0
    //   873: pop
    //   874: lload 13
    //   876: lstore 15
    //   878: iload_2
    //   879: istore 5
    //   881: lload 13
    //   883: lstore 11
    //   885: aload_0
    //   886: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   889: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   892: getfield 463	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   895: ldc_w 970
    //   898: lconst_0
    //   899: invokestatic 996	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   902: invokeinterface 477 3 0
    //   907: pop
    //   908: lload 13
    //   910: lstore 15
    //   912: iload_2
    //   913: istore 5
    //   915: lload 13
    //   917: lstore 11
    //   919: aload_0
    //   920: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   923: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   926: invokevirtual 489	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   929: lconst_0
    //   930: lstore 17
    //   932: lload 17
    //   934: lstore 9
    //   936: lload 17
    //   938: lstore 15
    //   940: iload_2
    //   941: istore 5
    //   943: lload 17
    //   945: lstore 11
    //   947: aload_0
    //   948: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   951: invokestatic 998	com/tencent/smtt/utils/k:b	(Landroid/content/Context;)Z
    //   954: ifne +262 -> 1216
    //   957: lload 17
    //   959: lstore 15
    //   961: iload_2
    //   962: istore 5
    //   964: lload 17
    //   966: lstore 11
    //   968: ldc 202
    //   970: ldc_w 1000
    //   973: iconst_1
    //   974: invokestatic 942	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   977: lload 17
    //   979: lstore 15
    //   981: iload_2
    //   982: istore 5
    //   984: lload 17
    //   986: lstore 11
    //   988: aload_0
    //   989: bipush 105
    //   991: aconst_null
    //   992: iconst_1
    //   993: invokespecial 609	com/tencent/smtt/sdk/ah:a	(ILjava/lang/String;Z)V
    //   996: lload 17
    //   998: lstore 15
    //   1000: iload_2
    //   1001: istore 5
    //   1003: lload 17
    //   1005: lstore 11
    //   1007: aload_0
    //   1008: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   1011: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1014: sipush -308
    //   1017: invokevirtual 899	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   1020: iload_2
    //   1021: istore 5
    //   1023: iload_1
    //   1024: ifne -465 -> 559
    //   1027: aload_0
    //   1028: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   1031: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1034: getfield 463	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   1037: ldc_w 970
    //   1040: lload 17
    //   1042: invokestatic 996	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1045: invokeinterface 477 3 0
    //   1050: pop
    //   1051: aload_0
    //   1052: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   1055: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1058: invokevirtual 489	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1061: iload_2
    //   1062: istore 5
    //   1064: goto -505 -> 559
    //   1067: lload 13
    //   1069: lstore 15
    //   1071: iload_2
    //   1072: istore 5
    //   1074: lload 13
    //   1076: lstore 11
    //   1078: ldc 202
    //   1080: ldc_w 1002
    //   1083: lload 13
    //   1085: invokestatic 1005	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1088: invokevirtual 366	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1091: invokestatic 389	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1094: lload 13
    //   1096: lstore 17
    //   1098: lload 13
    //   1100: lload 27
    //   1102: lcmp
    //   1103: iflt -171 -> 932
    //   1106: lload 13
    //   1108: lstore 15
    //   1110: iload_2
    //   1111: istore 5
    //   1113: lload 13
    //   1115: lstore 11
    //   1117: ldc 202
    //   1119: ldc_w 1007
    //   1122: iconst_1
    //   1123: invokestatic 942	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1126: lload 13
    //   1128: lstore 15
    //   1130: iload_2
    //   1131: istore 5
    //   1133: lload 13
    //   1135: lstore 11
    //   1137: aload_0
    //   1138: bipush 112
    //   1140: aconst_null
    //   1141: iconst_1
    //   1142: invokespecial 609	com/tencent/smtt/sdk/ah:a	(ILjava/lang/String;Z)V
    //   1145: lload 13
    //   1147: lstore 15
    //   1149: iload_2
    //   1150: istore 5
    //   1152: lload 13
    //   1154: lstore 11
    //   1156: aload_0
    //   1157: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   1160: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1163: sipush -307
    //   1166: invokevirtual 899	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   1169: iload_2
    //   1170: istore 5
    //   1172: iload_1
    //   1173: ifne -614 -> 559
    //   1176: aload_0
    //   1177: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   1180: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1183: getfield 463	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   1186: ldc_w 970
    //   1189: lload 13
    //   1191: invokestatic 996	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1194: invokeinterface 477 3 0
    //   1199: pop
    //   1200: aload_0
    //   1201: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   1204: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1207: invokevirtual 489	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1210: iload_2
    //   1211: istore 5
    //   1213: goto -654 -> 559
    //   1216: lload 9
    //   1218: lstore 15
    //   1220: iload_2
    //   1221: istore 5
    //   1223: lload 9
    //   1225: lstore 11
    //   1227: aload_0
    //   1228: iconst_1
    //   1229: putfield 631	com/tencent/smtt/sdk/ah:y	Z
    //   1232: lload 9
    //   1234: lstore 15
    //   1236: iload_2
    //   1237: istore 5
    //   1239: lload 9
    //   1241: lstore 11
    //   1243: aload_0
    //   1244: getfield 623	com/tencent/smtt/sdk/ah:j	Ljava/lang/String;
    //   1247: ifnull +809 -> 2056
    //   1250: lload 9
    //   1252: lstore 15
    //   1254: iload_2
    //   1255: istore 5
    //   1257: lload 9
    //   1259: lstore 11
    //   1261: aload_0
    //   1262: getfield 623	com/tencent/smtt/sdk/ah:j	Ljava/lang/String;
    //   1265: astore 29
    //   1267: lload 9
    //   1269: lstore 15
    //   1271: iload_2
    //   1272: istore 5
    //   1274: lload 9
    //   1276: lstore 11
    //   1278: ldc 202
    //   1280: new 113	java/lang/StringBuilder
    //   1283: dup
    //   1284: ldc_w 1009
    //   1287: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1290: aload 29
    //   1292: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1295: ldc_w 1011
    //   1298: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1301: aload_0
    //   1302: getfield 267	com/tencent/smtt/sdk/ah:p	I
    //   1305: invokevirtual 385	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1308: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1311: iconst_1
    //   1312: invokestatic 942	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1315: lload 9
    //   1317: lstore 15
    //   1319: iload_2
    //   1320: istore 5
    //   1322: lload 9
    //   1324: lstore 11
    //   1326: aload 29
    //   1328: aload_0
    //   1329: getfield 1013	com/tencent/smtt/sdk/ah:i	Ljava/lang/String;
    //   1332: invokevirtual 542	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1335: ifne +23 -> 1358
    //   1338: lload 9
    //   1340: lstore 15
    //   1342: iload_2
    //   1343: istore 5
    //   1345: lload 9
    //   1347: lstore 11
    //   1349: aload_0
    //   1350: getfield 106	com/tencent/smtt/sdk/ah:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   1353: aload 29
    //   1355: invokevirtual 1016	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownloadUrl	(Ljava/lang/String;)V
    //   1358: lload 9
    //   1360: lstore 15
    //   1362: iload_2
    //   1363: istore 5
    //   1365: lload 9
    //   1367: lstore 11
    //   1369: aload_0
    //   1370: aload 29
    //   1372: putfield 1013	com/tencent/smtt/sdk/ah:i	Ljava/lang/String;
    //   1375: lload 9
    //   1377: lstore 15
    //   1379: iload_2
    //   1380: istore 5
    //   1382: lload 9
    //   1384: lstore 11
    //   1386: aload_0
    //   1387: aload 29
    //   1389: invokespecial 1018	com/tencent/smtt/sdk/ah:a	(Ljava/lang/String;)V
    //   1392: lconst_0
    //   1393: lstore 13
    //   1395: lload 9
    //   1397: lstore 15
    //   1399: iload_2
    //   1400: istore 5
    //   1402: lload 9
    //   1404: lstore 11
    //   1406: aload_0
    //   1407: getfield 625	com/tencent/smtt/sdk/ah:o	Z
    //   1410: ifne +140 -> 1550
    //   1413: lload 9
    //   1415: lstore 15
    //   1417: iload_2
    //   1418: istore 5
    //   1420: lload 9
    //   1422: lstore 11
    //   1424: aload_0
    //   1425: invokespecial 1020	com/tencent/smtt/sdk/ah:j	()J
    //   1428: lstore 13
    //   1430: lload 9
    //   1432: lstore 15
    //   1434: iload_2
    //   1435: istore 5
    //   1437: lload 9
    //   1439: lstore 11
    //   1441: ldc 202
    //   1443: ldc_w 1022
    //   1446: lload 13
    //   1448: invokestatic 1005	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1451: invokevirtual 366	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1454: invokestatic 389	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1457: lload 9
    //   1459: lstore 15
    //   1461: iload_2
    //   1462: istore 5
    //   1464: lload 9
    //   1466: lstore 11
    //   1468: aload_0
    //   1469: getfield 621	com/tencent/smtt/sdk/ah:l	J
    //   1472: lconst_0
    //   1473: lcmp
    //   1474: ifgt +602 -> 2076
    //   1477: lload 9
    //   1479: lstore 15
    //   1481: iload_2
    //   1482: istore 5
    //   1484: lload 9
    //   1486: lstore 11
    //   1488: ldc 202
    //   1490: ldc_w 1024
    //   1493: lload 13
    //   1495: invokestatic 1005	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1498: invokevirtual 366	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1501: iconst_1
    //   1502: invokestatic 942	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1505: lload 9
    //   1507: lstore 15
    //   1509: iload_2
    //   1510: istore 5
    //   1512: lload 9
    //   1514: lstore 11
    //   1516: aload_0
    //   1517: getfield 395	com/tencent/smtt/sdk/ah:t	Ljava/net/HttpURLConnection;
    //   1520: ldc_w 1026
    //   1523: new 113	java/lang/StringBuilder
    //   1526: dup
    //   1527: ldc_w 1028
    //   1530: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1533: lload 13
    //   1535: invokevirtual 571	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1538: ldc_w 1030
    //   1541: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1544: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1547: invokevirtual 412	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1550: lload 9
    //   1552: lstore 15
    //   1554: iload_2
    //   1555: istore 5
    //   1557: lload 9
    //   1559: lstore 11
    //   1561: aload_0
    //   1562: getfield 106	com/tencent/smtt/sdk/ah:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   1565: astore 29
    //   1567: lload 13
    //   1569: lconst_0
    //   1570: lcmp
    //   1571: ifne +780 -> 2351
    //   1574: iconst_0
    //   1575: istore_3
    //   1576: lload 9
    //   1578: lstore 15
    //   1580: iload_2
    //   1581: istore 5
    //   1583: lload 9
    //   1585: lstore 11
    //   1587: aload 29
    //   1589: iload_3
    //   1590: invokevirtual 1033	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownloadCancel	(I)V
    //   1593: lload 9
    //   1595: lstore 15
    //   1597: iload_2
    //   1598: istore 5
    //   1600: lload 9
    //   1602: lstore 11
    //   1604: aload_0
    //   1605: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   1608: invokestatic 657	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   1611: istore_3
    //   1612: lload 9
    //   1614: lstore 15
    //   1616: iload_2
    //   1617: istore 5
    //   1619: lload 9
    //   1621: lstore 11
    //   1623: aload_0
    //   1624: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   1627: invokestatic 653	com/tencent/smtt/utils/Apn:getApnInfo	(Landroid/content/Context;)Ljava/lang/String;
    //   1630: astore 29
    //   1632: lload 9
    //   1634: lstore 15
    //   1636: iload_2
    //   1637: istore 5
    //   1639: lload 9
    //   1641: lstore 11
    //   1643: aload_0
    //   1644: getfield 152	com/tencent/smtt/sdk/ah:w	Ljava/lang/String;
    //   1647: ifnonnull +709 -> 2356
    //   1650: lload 9
    //   1652: lstore 15
    //   1654: iload_2
    //   1655: istore 5
    //   1657: lload 9
    //   1659: lstore 11
    //   1661: aload_0
    //   1662: getfield 154	com/tencent/smtt/sdk/ah:x	I
    //   1665: iconst_m1
    //   1666: if_icmpne +690 -> 2356
    //   1669: lload 9
    //   1671: lstore 15
    //   1673: iload_2
    //   1674: istore 5
    //   1676: lload 9
    //   1678: lstore 11
    //   1680: aload_0
    //   1681: aload 29
    //   1683: putfield 152	com/tencent/smtt/sdk/ah:w	Ljava/lang/String;
    //   1686: lload 9
    //   1688: lstore 15
    //   1690: iload_2
    //   1691: istore 5
    //   1693: lload 9
    //   1695: lstore 11
    //   1697: aload_0
    //   1698: iload_3
    //   1699: putfield 154	com/tencent/smtt/sdk/ah:x	I
    //   1702: lload 9
    //   1704: lstore 15
    //   1706: iload_2
    //   1707: istore 5
    //   1709: lload 9
    //   1711: lstore 11
    //   1713: aload_0
    //   1714: getfield 267	com/tencent/smtt/sdk/ah:p	I
    //   1717: ifle +28 -> 1745
    //   1720: lload 9
    //   1722: lstore 15
    //   1724: iload_2
    //   1725: istore 5
    //   1727: lload 9
    //   1729: lstore 11
    //   1731: aload_0
    //   1732: getfield 395	com/tencent/smtt/sdk/ah:t	Ljava/net/HttpURLConnection;
    //   1735: ldc_w 1035
    //   1738: aload_0
    //   1739: getfield 935	com/tencent/smtt/sdk/ah:h	Ljava/lang/String;
    //   1742: invokevirtual 1038	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1745: lload 9
    //   1747: lstore 15
    //   1749: iload_2
    //   1750: istore 5
    //   1752: lload 9
    //   1754: lstore 11
    //   1756: aload_0
    //   1757: getfield 395	com/tencent/smtt/sdk/ah:t	Ljava/net/HttpURLConnection;
    //   1760: invokevirtual 772	java/net/HttpURLConnection:getResponseCode	()I
    //   1763: istore_3
    //   1764: lload 9
    //   1766: lstore 15
    //   1768: iload_2
    //   1769: istore 5
    //   1771: lload 9
    //   1773: lstore 11
    //   1775: ldc 202
    //   1777: ldc_w 1040
    //   1780: iload_3
    //   1781: invokestatic 362	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1784: invokevirtual 366	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1787: invokestatic 389	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1790: lload 9
    //   1792: lstore 15
    //   1794: iload_2
    //   1795: istore 5
    //   1797: lload 9
    //   1799: lstore 11
    //   1801: aload_0
    //   1802: getfield 106	com/tencent/smtt/sdk/ah:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   1805: iload_3
    //   1806: invokevirtual 1043	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setHttpCode	(I)V
    //   1809: iload_1
    //   1810: ifne +157 -> 1967
    //   1813: lload 9
    //   1815: lstore 15
    //   1817: iload_2
    //   1818: istore 5
    //   1820: lload 9
    //   1822: lstore 11
    //   1824: aload_0
    //   1825: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   1828: invokestatic 221	com/tencent/smtt/sdk/TbsDownloader:getOverSea	(Landroid/content/Context;)Z
    //   1831: ifne +136 -> 1967
    //   1834: lload 9
    //   1836: lstore 15
    //   1838: iload_2
    //   1839: istore 5
    //   1841: lload 9
    //   1843: lstore 11
    //   1845: aload_0
    //   1846: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   1849: invokestatic 657	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   1852: iconst_3
    //   1853: if_icmpne +24 -> 1877
    //   1856: lload 9
    //   1858: lstore 15
    //   1860: iload_2
    //   1861: istore 5
    //   1863: lload 9
    //   1865: lstore 11
    //   1867: aload_0
    //   1868: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   1871: invokestatic 657	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   1874: ifne +93 -> 1967
    //   1877: lload 9
    //   1879: lstore 15
    //   1881: iload_2
    //   1882: istore 5
    //   1884: lload 9
    //   1886: lstore 11
    //   1888: invokestatic 883	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   1891: ifne +76 -> 1967
    //   1894: lload 9
    //   1896: lstore 15
    //   1898: iload_2
    //   1899: istore 5
    //   1901: lload 9
    //   1903: lstore 11
    //   1905: aload_0
    //   1906: invokevirtual 1044	com/tencent/smtt/sdk/ah:b	()V
    //   1909: lload 9
    //   1911: lstore 15
    //   1913: iload_2
    //   1914: istore 5
    //   1916: lload 9
    //   1918: lstore 11
    //   1920: getstatic 494	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   1923: ifnull +24 -> 1947
    //   1926: lload 9
    //   1928: lstore 15
    //   1930: iload_2
    //   1931: istore 5
    //   1933: lload 9
    //   1935: lstore 11
    //   1937: getstatic 494	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   1940: bipush 111
    //   1942: invokeinterface 499 2 0
    //   1947: lload 9
    //   1949: lstore 15
    //   1951: iload_2
    //   1952: istore 5
    //   1954: lload 9
    //   1956: lstore 11
    //   1958: ldc 202
    //   1960: ldc_w 1046
    //   1963: iconst_0
    //   1964: invokestatic 942	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1967: lload 9
    //   1969: lstore 15
    //   1971: iload_2
    //   1972: istore 5
    //   1974: lload 9
    //   1976: lstore 11
    //   1978: aload_0
    //   1979: getfield 627	com/tencent/smtt/sdk/ah:r	Z
    //   1982: ifeq +524 -> 2506
    //   1985: lload 9
    //   1987: lstore 15
    //   1989: iload_2
    //   1990: istore 5
    //   1992: lload 9
    //   1994: lstore 11
    //   1996: aload_0
    //   1997: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   2000: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2003: sipush -309
    //   2006: invokevirtual 899	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2009: iload_2
    //   2010: istore 5
    //   2012: iload_1
    //   2013: ifne -1454 -> 559
    //   2016: aload_0
    //   2017: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   2020: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2023: getfield 463	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2026: ldc_w 970
    //   2029: lload 9
    //   2031: invokestatic 996	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2034: invokeinterface 477 3 0
    //   2039: pop
    //   2040: aload_0
    //   2041: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   2044: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2047: invokevirtual 489	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2050: iload_2
    //   2051: istore 5
    //   2053: goto -1494 -> 559
    //   2056: lload 9
    //   2058: lstore 15
    //   2060: iload_2
    //   2061: istore 5
    //   2063: lload 9
    //   2065: lstore 11
    //   2067: aload_0
    //   2068: getfield 935	com/tencent/smtt/sdk/ah:h	Ljava/lang/String;
    //   2071: astore 29
    //   2073: goto -806 -> 1267
    //   2076: lload 9
    //   2078: lstore 15
    //   2080: iload_2
    //   2081: istore 5
    //   2083: lload 9
    //   2085: lstore 11
    //   2087: ldc 202
    //   2089: new 113	java/lang/StringBuilder
    //   2092: dup
    //   2093: ldc_w 1048
    //   2096: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2099: lload 13
    //   2101: invokevirtual 571	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2104: ldc_w 1050
    //   2107: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2110: aload_0
    //   2111: getfield 621	com/tencent/smtt/sdk/ah:l	J
    //   2114: invokevirtual 571	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2117: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2120: iconst_1
    //   2121: invokestatic 942	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   2124: lload 9
    //   2126: lstore 15
    //   2128: iload_2
    //   2129: istore 5
    //   2131: lload 9
    //   2133: lstore 11
    //   2135: aload_0
    //   2136: getfield 395	com/tencent/smtt/sdk/ah:t	Ljava/net/HttpURLConnection;
    //   2139: ldc_w 1026
    //   2142: new 113	java/lang/StringBuilder
    //   2145: dup
    //   2146: ldc_w 1028
    //   2149: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2152: lload 13
    //   2154: invokevirtual 571	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2157: ldc_w 1030
    //   2160: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2163: aload_0
    //   2164: getfield 621	com/tencent/smtt/sdk/ah:l	J
    //   2167: invokevirtual 571	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2170: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2173: invokevirtual 412	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   2176: goto -626 -> 1550
    //   2179: astore 29
    //   2181: iload 5
    //   2183: istore 6
    //   2185: lload 15
    //   2187: lstore 11
    //   2189: aload 29
    //   2191: instanceof 1052
    //   2194: ifeq +4048 -> 6242
    //   2197: iload_1
    //   2198: ifne +4044 -> 6242
    //   2201: lload 15
    //   2203: lstore 11
    //   2205: aload_0
    //   2206: getfield 84	com/tencent/smtt/sdk/ah:b	[Ljava/lang/String;
    //   2209: ifnull +4033 -> 6242
    //   2212: lload 15
    //   2214: lstore 11
    //   2216: aload_0
    //   2217: iconst_0
    //   2218: invokevirtual 1054	com/tencent/smtt/sdk/ah:a	(Z)Z
    //   2221: ifeq +4021 -> 6242
    //   2224: lload 15
    //   2226: lstore 11
    //   2228: ldc 202
    //   2230: new 113	java/lang/StringBuilder
    //   2233: dup
    //   2234: ldc_w 1056
    //   2237: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2240: aload_0
    //   2241: getfield 623	com/tencent/smtt/sdk/ah:j	Ljava/lang/String;
    //   2244: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2247: ldc_w 1058
    //   2250: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2253: aload 29
    //   2255: invokevirtual 434	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2258: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2261: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2264: invokestatic 212	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2267: lload 15
    //   2269: lstore 11
    //   2271: aload_0
    //   2272: bipush 125
    //   2274: aconst_null
    //   2275: iconst_1
    //   2276: invokespecial 609	com/tencent/smtt/sdk/ah:a	(ILjava/lang/String;Z)V
    //   2279: lload 15
    //   2281: lstore 11
    //   2283: aload_0
    //   2284: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   2287: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2290: sipush -316
    //   2293: invokevirtual 899	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2296: lload 15
    //   2298: lstore 13
    //   2300: iload 6
    //   2302: istore_2
    //   2303: iload_1
    //   2304: ifne -1792 -> 512
    //   2307: aload_0
    //   2308: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   2311: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2314: getfield 463	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2317: ldc_w 970
    //   2320: lload 15
    //   2322: invokestatic 996	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2325: invokeinterface 477 3 0
    //   2330: pop
    //   2331: aload_0
    //   2332: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   2335: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2338: invokevirtual 489	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2341: lload 15
    //   2343: lstore 13
    //   2345: iload 6
    //   2347: istore_2
    //   2348: goto -1836 -> 512
    //   2351: iconst_1
    //   2352: istore_3
    //   2353: goto -777 -> 1576
    //   2356: lload 9
    //   2358: lstore 15
    //   2360: iload_2
    //   2361: istore 5
    //   2363: lload 9
    //   2365: lstore 11
    //   2367: iload_3
    //   2368: aload_0
    //   2369: getfield 154	com/tencent/smtt/sdk/ah:x	I
    //   2372: if_icmpne +26 -> 2398
    //   2375: lload 9
    //   2377: lstore 15
    //   2379: iload_2
    //   2380: istore 5
    //   2382: lload 9
    //   2384: lstore 11
    //   2386: aload 29
    //   2388: aload_0
    //   2389: getfield 152	com/tencent/smtt/sdk/ah:w	Ljava/lang/String;
    //   2392: invokevirtual 542	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2395: ifne -693 -> 1702
    //   2398: lload 9
    //   2400: lstore 15
    //   2402: iload_2
    //   2403: istore 5
    //   2405: lload 9
    //   2407: lstore 11
    //   2409: aload_0
    //   2410: getfield 106	com/tencent/smtt/sdk/ah:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   2413: iconst_0
    //   2414: invokevirtual 666	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setNetworkChange	(I)V
    //   2417: lload 9
    //   2419: lstore 15
    //   2421: iload_2
    //   2422: istore 5
    //   2424: lload 9
    //   2426: lstore 11
    //   2428: aload_0
    //   2429: aload 29
    //   2431: putfield 152	com/tencent/smtt/sdk/ah:w	Ljava/lang/String;
    //   2434: lload 9
    //   2436: lstore 15
    //   2438: iload_2
    //   2439: istore 5
    //   2441: lload 9
    //   2443: lstore 11
    //   2445: aload_0
    //   2446: iload_3
    //   2447: putfield 154	com/tencent/smtt/sdk/ah:x	I
    //   2450: goto -748 -> 1702
    //   2453: astore 29
    //   2455: lload 11
    //   2457: lstore 9
    //   2459: iload_1
    //   2460: ifne +37 -> 2497
    //   2463: aload_0
    //   2464: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   2467: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2470: getfield 463	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2473: ldc_w 970
    //   2476: lload 9
    //   2478: invokestatic 996	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2481: invokeinterface 477 3 0
    //   2486: pop
    //   2487: aload_0
    //   2488: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   2491: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2494: invokevirtual 489	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2497: ldc_w 925
    //   2500: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2503: aload 29
    //   2505: athrow
    //   2506: iload_3
    //   2507: sipush 200
    //   2510: if_icmpeq +10 -> 2520
    //   2513: iload_3
    //   2514: sipush 206
    //   2517: if_icmpne +2538 -> 5055
    //   2520: lload 9
    //   2522: lstore 15
    //   2524: iload_2
    //   2525: istore 5
    //   2527: lload 9
    //   2529: lstore 11
    //   2531: aload_0
    //   2532: aload_0
    //   2533: getfield 395	com/tencent/smtt/sdk/ah:t	Ljava/net/HttpURLConnection;
    //   2536: invokevirtual 1061	java/net/HttpURLConnection:getContentLength	()I
    //   2539: i2l
    //   2540: lload 13
    //   2542: ladd
    //   2543: putfield 621	com/tencent/smtt/sdk/ah:l	J
    //   2546: lload 9
    //   2548: lstore 15
    //   2550: iload_2
    //   2551: istore 5
    //   2553: lload 9
    //   2555: lstore 11
    //   2557: ldc 202
    //   2559: new 113	java/lang/StringBuilder
    //   2562: dup
    //   2563: ldc_w 1063
    //   2566: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2569: aload_0
    //   2570: getfield 621	com/tencent/smtt/sdk/ah:l	J
    //   2573: invokevirtual 571	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2576: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2579: invokestatic 389	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2582: lload 9
    //   2584: lstore 15
    //   2586: iload_2
    //   2587: istore 5
    //   2589: lload 9
    //   2591: lstore 11
    //   2593: aload_0
    //   2594: getfield 106	com/tencent/smtt/sdk/ah:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   2597: aload_0
    //   2598: getfield 621	com/tencent/smtt/sdk/ah:l	J
    //   2601: invokevirtual 1066	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setPkgSize	(J)V
    //   2604: lload 9
    //   2606: lstore 15
    //   2608: iload_2
    //   2609: istore 5
    //   2611: lload 9
    //   2613: lstore 11
    //   2615: aload_0
    //   2616: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   2619: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2622: getfield 305	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   2625: ldc_w 558
    //   2628: lconst_0
    //   2629: invokeinterface 562 4 0
    //   2634: lstore 17
    //   2636: lload 17
    //   2638: lconst_0
    //   2639: lcmp
    //   2640: ifeq +390 -> 3030
    //   2643: lload 9
    //   2645: lstore 15
    //   2647: iload_2
    //   2648: istore 5
    //   2650: lload 9
    //   2652: lstore 11
    //   2654: aload_0
    //   2655: getfield 621	com/tencent/smtt/sdk/ah:l	J
    //   2658: lload 17
    //   2660: lcmp
    //   2661: ifeq +369 -> 3030
    //   2664: lload 9
    //   2666: lstore 15
    //   2668: iload_2
    //   2669: istore 5
    //   2671: lload 9
    //   2673: lstore 11
    //   2675: ldc 202
    //   2677: new 113	java/lang/StringBuilder
    //   2680: dup
    //   2681: ldc_w 1068
    //   2684: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2687: lload 17
    //   2689: invokevirtual 571	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2692: ldc_w 1070
    //   2695: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2698: aload_0
    //   2699: getfield 621	com/tencent/smtt/sdk/ah:l	J
    //   2702: invokevirtual 571	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2705: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2708: iconst_1
    //   2709: invokestatic 942	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   2712: iload_1
    //   2713: ifne +269 -> 2982
    //   2716: lload 9
    //   2718: lstore 15
    //   2720: iload_2
    //   2721: istore 5
    //   2723: lload 9
    //   2725: lstore 11
    //   2727: aload_0
    //   2728: invokespecial 438	com/tencent/smtt/sdk/ah:m	()Z
    //   2731: ifne +41 -> 2772
    //   2734: lload 9
    //   2736: lstore 15
    //   2738: iload_2
    //   2739: istore 5
    //   2741: lload 9
    //   2743: lstore 11
    //   2745: invokestatic 883	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   2748: ifeq +234 -> 2982
    //   2751: lload 9
    //   2753: lstore 15
    //   2755: iload_2
    //   2756: istore 5
    //   2758: lload 9
    //   2760: lstore 11
    //   2762: aload_0
    //   2763: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   2766: invokestatic 672	com/tencent/smtt/utils/Apn:isNetworkAvailable	(Landroid/content/Context;)Z
    //   2769: ifeq +213 -> 2982
    //   2772: lload 9
    //   2774: lstore 15
    //   2776: iload_2
    //   2777: istore 5
    //   2779: lload 9
    //   2781: lstore 11
    //   2783: aload_0
    //   2784: getfield 84	com/tencent/smtt/sdk/ah:b	[Ljava/lang/String;
    //   2787: ifnull +75 -> 2862
    //   2790: lload 9
    //   2792: lstore 15
    //   2794: iload_2
    //   2795: istore 5
    //   2797: lload 9
    //   2799: lstore 11
    //   2801: aload_0
    //   2802: iconst_0
    //   2803: invokevirtual 1054	com/tencent/smtt/sdk/ah:a	(Z)Z
    //   2806: istore 6
    //   2808: iload 6
    //   2810: ifeq +52 -> 2862
    //   2813: lload 9
    //   2815: lstore 13
    //   2817: iload_1
    //   2818: ifne -2306 -> 512
    //   2821: aload_0
    //   2822: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   2825: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2828: getfield 463	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2831: ldc_w 970
    //   2834: lload 9
    //   2836: invokestatic 996	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2839: invokeinterface 477 3 0
    //   2844: pop
    //   2845: aload_0
    //   2846: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   2849: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2852: invokevirtual 489	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2855: lload 9
    //   2857: lstore 13
    //   2859: goto -2347 -> 512
    //   2862: lload 9
    //   2864: lstore 15
    //   2866: iload_2
    //   2867: istore 5
    //   2869: lload 9
    //   2871: lstore 11
    //   2873: aload_0
    //   2874: bipush 113
    //   2876: new 113	java/lang/StringBuilder
    //   2879: dup
    //   2880: ldc_w 1072
    //   2883: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2886: lload 17
    //   2888: invokevirtual 571	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2891: ldc_w 1070
    //   2894: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2897: aload_0
    //   2898: getfield 621	com/tencent/smtt/sdk/ah:l	J
    //   2901: invokevirtual 571	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2904: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2907: iconst_1
    //   2908: invokespecial 609	com/tencent/smtt/sdk/ah:a	(ILjava/lang/String;Z)V
    //   2911: lload 9
    //   2913: lstore 15
    //   2915: iload_2
    //   2916: istore 5
    //   2918: lload 9
    //   2920: lstore 11
    //   2922: aload_0
    //   2923: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   2926: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2929: sipush -310
    //   2932: invokevirtual 899	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2935: iload_2
    //   2936: istore 5
    //   2938: iload_1
    //   2939: ifne -2380 -> 559
    //   2942: aload_0
    //   2943: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   2946: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2949: getfield 463	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2952: ldc_w 970
    //   2955: lload 9
    //   2957: invokestatic 996	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2960: invokeinterface 477 3 0
    //   2965: pop
    //   2966: aload_0
    //   2967: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   2970: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2973: invokevirtual 489	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2976: iload_2
    //   2977: istore 5
    //   2979: goto -2420 -> 559
    //   2982: lload 9
    //   2984: lstore 15
    //   2986: iload_2
    //   2987: istore 5
    //   2989: lload 9
    //   2991: lstore 11
    //   2993: aload_0
    //   2994: bipush 101
    //   2996: ldc_w 1074
    //   2999: iconst_1
    //   3000: invokespecial 609	com/tencent/smtt/sdk/ah:a	(ILjava/lang/String;Z)V
    //   3003: lload 9
    //   3005: lstore 15
    //   3007: iload_2
    //   3008: istore 5
    //   3010: lload 9
    //   3012: lstore 11
    //   3014: aload_0
    //   3015: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   3018: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3021: sipush -304
    //   3024: invokevirtual 899	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3027: goto -92 -> 2935
    //   3030: aconst_null
    //   3031: astore 33
    //   3033: aconst_null
    //   3034: astore 29
    //   3036: aconst_null
    //   3037: astore 31
    //   3039: lload 9
    //   3041: lstore 15
    //   3043: iload_2
    //   3044: istore 5
    //   3046: lload 9
    //   3048: lstore 11
    //   3050: ldc 202
    //   3052: ldc_w 1076
    //   3055: invokestatic 389	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3058: aload_0
    //   3059: getfield 395	com/tencent/smtt/sdk/ah:t	Ljava/net/HttpURLConnection;
    //   3062: invokevirtual 769	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   3065: astore 30
    //   3067: aload 30
    //   3069: ifnull +1483 -> 4552
    //   3072: aload_0
    //   3073: getfield 395	com/tencent/smtt/sdk/ah:t	Ljava/net/HttpURLConnection;
    //   3076: invokevirtual 1079	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   3079: astore 29
    //   3081: aload 29
    //   3083: ifnull +277 -> 3360
    //   3086: aload 29
    //   3088: ldc_w 1081
    //   3091: invokevirtual 330	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3094: ifeq +266 -> 3360
    //   3097: new 1083	java/util/zip/GZIPInputStream
    //   3100: dup
    //   3101: aload 30
    //   3103: invokespecial 1084	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   3106: astore 29
    //   3108: sipush 8192
    //   3111: newarray byte
    //   3113: astore 31
    //   3115: new 1086	java/io/FileOutputStream
    //   3118: dup
    //   3119: new 184	java/io/File
    //   3122: dup
    //   3123: aload_0
    //   3124: getfield 141	com/tencent/smtt/sdk/ah:k	Ljava/io/File;
    //   3127: ldc_w 455
    //   3130: invokespecial 226	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   3133: iconst_1
    //   3134: invokespecial 1089	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   3137: astore 32
    //   3139: lload 9
    //   3141: lstore 11
    //   3143: lload 9
    //   3145: lstore 17
    //   3147: invokestatic 162	java/lang/System:currentTimeMillis	()J
    //   3150: lstore 15
    //   3152: iconst_0
    //   3153: istore_3
    //   3154: lload 13
    //   3156: lstore 21
    //   3158: iload_2
    //   3159: istore 5
    //   3161: lload 9
    //   3163: lstore 17
    //   3165: iload_2
    //   3166: istore 7
    //   3168: lload 9
    //   3170: lstore 19
    //   3172: aload_0
    //   3173: getfield 627	com/tencent/smtt/sdk/ah:r	Z
    //   3176: ifeq +396 -> 3572
    //   3179: iload_2
    //   3180: istore 5
    //   3182: lload 9
    //   3184: lstore 17
    //   3186: iload_2
    //   3187: istore 7
    //   3189: lload 9
    //   3191: lstore 19
    //   3193: ldc 202
    //   3195: ldc_w 1091
    //   3198: iconst_1
    //   3199: invokestatic 942	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   3202: iload_2
    //   3203: istore 5
    //   3205: lload 9
    //   3207: lstore 17
    //   3209: iload_2
    //   3210: istore 7
    //   3212: lload 9
    //   3214: lstore 19
    //   3216: aload_0
    //   3217: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   3220: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3223: sipush -309
    //   3226: invokevirtual 899	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3229: iload_2
    //   3230: istore 6
    //   3232: lload 9
    //   3234: lstore 13
    //   3236: iload 6
    //   3238: istore_2
    //   3239: aload 29
    //   3241: astore 33
    //   3243: aload 32
    //   3245: astore 31
    //   3247: iload_3
    //   3248: ifeq +1314 -> 4562
    //   3251: lload 9
    //   3253: lstore 15
    //   3255: iload 6
    //   3257: istore 5
    //   3259: lload 9
    //   3261: lstore 11
    //   3263: aload_0
    //   3264: aload 32
    //   3266: invokespecial 749	com/tencent/smtt/sdk/ah:a	(Ljava/io/Closeable;)V
    //   3269: lload 9
    //   3271: lstore 15
    //   3273: iload 6
    //   3275: istore 5
    //   3277: lload 9
    //   3279: lstore 11
    //   3281: aload_0
    //   3282: aload 29
    //   3284: invokespecial 749	com/tencent/smtt/sdk/ah:a	(Ljava/io/Closeable;)V
    //   3287: lload 9
    //   3289: lstore 15
    //   3291: iload 6
    //   3293: istore 5
    //   3295: lload 9
    //   3297: lstore 11
    //   3299: aload_0
    //   3300: aload 30
    //   3302: invokespecial 749	com/tencent/smtt/sdk/ah:a	(Ljava/io/Closeable;)V
    //   3305: lload 9
    //   3307: lstore 13
    //   3309: iload 6
    //   3311: istore_2
    //   3312: iload_1
    //   3313: ifne -2801 -> 512
    //   3316: aload_0
    //   3317: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   3320: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3323: getfield 463	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   3326: ldc_w 970
    //   3329: lload 9
    //   3331: invokestatic 996	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3334: invokeinterface 477 3 0
    //   3339: pop
    //   3340: aload_0
    //   3341: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   3344: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3347: invokevirtual 489	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   3350: lload 9
    //   3352: lstore 13
    //   3354: iload 6
    //   3356: istore_2
    //   3357: goto -2845 -> 512
    //   3360: aload 29
    //   3362: ifnull +203 -> 3565
    //   3365: aload 29
    //   3367: ldc_w 1093
    //   3370: invokevirtual 330	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3373: ifeq +192 -> 3565
    //   3376: new 1095	java/util/zip/InflaterInputStream
    //   3379: dup
    //   3380: aload 30
    //   3382: new 1097	java/util/zip/Inflater
    //   3385: dup
    //   3386: iconst_1
    //   3387: invokespecial 1099	java/util/zip/Inflater:<init>	(Z)V
    //   3390: invokespecial 1102	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Inflater;)V
    //   3393: astore 29
    //   3395: goto -287 -> 3108
    //   3398: astore 34
    //   3400: aload 30
    //   3402: astore 29
    //   3404: aload 33
    //   3406: astore 32
    //   3408: aload 34
    //   3410: astore 30
    //   3412: iload_2
    //   3413: istore 6
    //   3415: aload 30
    //   3417: instanceof 1104
    //   3420: ifne +11 -> 3431
    //   3423: aload 30
    //   3425: instanceof 1106
    //   3428: ifeq +1274 -> 4702
    //   3431: aload_0
    //   3432: ldc_w 1107
    //   3435: putfield 78	com/tencent/smtt/sdk/ah:m	I
    //   3438: aload_0
    //   3439: lconst_0
    //   3440: invokespecial 1109	com/tencent/smtt/sdk/ah:a	(J)V
    //   3443: aload_0
    //   3444: bipush 103
    //   3446: aload_0
    //   3447: aload 30
    //   3449: invokespecial 607	com/tencent/smtt/sdk/ah:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3452: iconst_0
    //   3453: invokespecial 609	com/tencent/smtt/sdk/ah:a	(ILjava/lang/String;Z)V
    //   3456: lload 9
    //   3458: lstore 15
    //   3460: iload 6
    //   3462: istore 5
    //   3464: lload 9
    //   3466: lstore 11
    //   3468: aload_0
    //   3469: aload 32
    //   3471: invokespecial 749	com/tencent/smtt/sdk/ah:a	(Ljava/io/Closeable;)V
    //   3474: lload 9
    //   3476: lstore 15
    //   3478: iload 6
    //   3480: istore 5
    //   3482: lload 9
    //   3484: lstore 11
    //   3486: aload_0
    //   3487: aload 31
    //   3489: invokespecial 749	com/tencent/smtt/sdk/ah:a	(Ljava/io/Closeable;)V
    //   3492: lload 9
    //   3494: lstore 15
    //   3496: iload 6
    //   3498: istore 5
    //   3500: lload 9
    //   3502: lstore 11
    //   3504: aload_0
    //   3505: aload 29
    //   3507: invokespecial 749	com/tencent/smtt/sdk/ah:a	(Ljava/io/Closeable;)V
    //   3510: lload 9
    //   3512: lstore 13
    //   3514: iload 6
    //   3516: istore_2
    //   3517: iload_1
    //   3518: ifne -3006 -> 512
    //   3521: aload_0
    //   3522: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   3525: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3528: getfield 463	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   3531: ldc_w 970
    //   3534: lload 9
    //   3536: invokestatic 996	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3539: invokeinterface 477 3 0
    //   3544: pop
    //   3545: aload_0
    //   3546: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   3549: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3552: invokevirtual 489	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   3555: lload 9
    //   3557: lstore 13
    //   3559: iload 6
    //   3561: istore_2
    //   3562: goto -3050 -> 512
    //   3565: aload 30
    //   3567: astore 29
    //   3569: goto -461 -> 3108
    //   3572: iload_2
    //   3573: istore 5
    //   3575: lload 9
    //   3577: lstore 17
    //   3579: iload_2
    //   3580: istore 7
    //   3582: lload 9
    //   3584: lstore 19
    //   3586: aload 29
    //   3588: aload 31
    //   3590: iconst_0
    //   3591: sipush 8192
    //   3594: invokevirtual 1115	java/io/InputStream:read	([BII)I
    //   3597: istore 4
    //   3599: iload 4
    //   3601: ifgt +185 -> 3786
    //   3604: iload_2
    //   3605: istore 5
    //   3607: lload 9
    //   3609: lstore 17
    //   3611: iload_2
    //   3612: istore 7
    //   3614: lload 9
    //   3616: lstore 19
    //   3618: aload_0
    //   3619: getfield 84	com/tencent/smtt/sdk/ah:b	[Ljava/lang/String;
    //   3622: ifnull +86 -> 3708
    //   3625: iload_2
    //   3626: istore 5
    //   3628: lload 9
    //   3630: lstore 17
    //   3632: iload_2
    //   3633: istore 7
    //   3635: lload 9
    //   3637: lstore 19
    //   3639: aload_0
    //   3640: iconst_1
    //   3641: iload 8
    //   3643: invokespecial 907	com/tencent/smtt/sdk/ah:c	(ZZ)Z
    //   3646: ifne +62 -> 3708
    //   3649: iload_1
    //   3650: ifne +33 -> 3683
    //   3653: iload_2
    //   3654: istore 5
    //   3656: lload 9
    //   3658: lstore 17
    //   3660: iload_2
    //   3661: istore 7
    //   3663: lload 9
    //   3665: lstore 19
    //   3667: aload_0
    //   3668: iconst_0
    //   3669: invokevirtual 1054	com/tencent/smtt/sdk/ah:a	(Z)Z
    //   3672: ifeq +11 -> 3683
    //   3675: iconst_1
    //   3676: istore_3
    //   3677: iload_2
    //   3678: istore 6
    //   3680: goto -448 -> 3232
    //   3683: iload_2
    //   3684: istore 5
    //   3686: lload 9
    //   3688: lstore 17
    //   3690: iload_2
    //   3691: istore 7
    //   3693: lload 9
    //   3695: lstore 19
    //   3697: aload_0
    //   3698: iconst_1
    //   3699: putfield 629	com/tencent/smtt/sdk/ah:s	Z
    //   3702: iconst_0
    //   3703: istore 6
    //   3705: goto -473 -> 3232
    //   3708: iload_2
    //   3709: istore 5
    //   3711: lload 9
    //   3713: lstore 17
    //   3715: iload_2
    //   3716: istore 7
    //   3718: lload 9
    //   3720: lstore 19
    //   3722: aload_0
    //   3723: iconst_1
    //   3724: putfield 629	com/tencent/smtt/sdk/ah:s	Z
    //   3727: iload_2
    //   3728: istore 6
    //   3730: iload_2
    //   3731: istore 5
    //   3733: lload 9
    //   3735: lstore 17
    //   3737: iload_2
    //   3738: istore 7
    //   3740: lload 9
    //   3742: lstore 19
    //   3744: aload_0
    //   3745: getfield 84	com/tencent/smtt/sdk/ah:b	[Ljava/lang/String;
    //   3748: ifnull +6 -> 3754
    //   3751: iconst_1
    //   3752: istore 6
    //   3754: iload 6
    //   3756: istore 5
    //   3758: lload 9
    //   3760: lstore 17
    //   3762: iload 6
    //   3764: istore 7
    //   3766: lload 9
    //   3768: lstore 19
    //   3770: aload_0
    //   3771: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   3774: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3777: sipush -311
    //   3780: invokevirtual 899	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3783: goto -551 -> 3232
    //   3786: iload_2
    //   3787: istore 5
    //   3789: lload 9
    //   3791: lstore 17
    //   3793: iload_2
    //   3794: istore 7
    //   3796: lload 9
    //   3798: lstore 19
    //   3800: aload 32
    //   3802: aload 31
    //   3804: iconst_0
    //   3805: iload 4
    //   3807: invokevirtual 1119	java/io/FileOutputStream:write	([BII)V
    //   3810: iload_2
    //   3811: istore 5
    //   3813: lload 9
    //   3815: lstore 17
    //   3817: iload_2
    //   3818: istore 7
    //   3820: lload 9
    //   3822: lstore 19
    //   3824: aload 32
    //   3826: invokevirtual 1122	java/io/FileOutputStream:flush	()V
    //   3829: lload 9
    //   3831: lstore 11
    //   3833: iload_1
    //   3834: ifne +271 -> 4105
    //   3837: iload 4
    //   3839: i2l
    //   3840: lload 9
    //   3842: ladd
    //   3843: lstore 9
    //   3845: lload 9
    //   3847: lload 27
    //   3849: lcmp
    //   3850: iflt +91 -> 3941
    //   3853: lload 9
    //   3855: lstore 11
    //   3857: lload 9
    //   3859: lstore 17
    //   3861: ldc 202
    //   3863: ldc_w 1007
    //   3866: iconst_1
    //   3867: invokestatic 942	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   3870: lload 9
    //   3872: lstore 11
    //   3874: lload 9
    //   3876: lstore 17
    //   3878: aload_0
    //   3879: bipush 112
    //   3881: new 113	java/lang/StringBuilder
    //   3884: dup
    //   3885: ldc_w 1124
    //   3888: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3891: lload 9
    //   3893: invokevirtual 571	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3896: ldc_w 1126
    //   3899: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3902: lload 27
    //   3904: invokevirtual 571	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3907: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3910: iconst_1
    //   3911: invokespecial 609	com/tencent/smtt/sdk/ah:a	(ILjava/lang/String;Z)V
    //   3914: lload 9
    //   3916: lstore 11
    //   3918: lload 9
    //   3920: lstore 17
    //   3922: aload_0
    //   3923: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   3926: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3929: sipush -307
    //   3932: invokevirtual 899	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3935: iload_2
    //   3936: istore 6
    //   3938: goto -706 -> 3232
    //   3941: lload 9
    //   3943: lstore 11
    //   3945: lload 9
    //   3947: lstore 17
    //   3949: aload_0
    //   3950: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   3953: invokestatic 998	com/tencent/smtt/utils/k:b	(Landroid/content/Context;)Z
    //   3956: ifne +145 -> 4101
    //   3959: lload 9
    //   3961: lstore 11
    //   3963: lload 9
    //   3965: lstore 17
    //   3967: ldc 202
    //   3969: ldc_w 1128
    //   3972: iconst_1
    //   3973: invokestatic 942	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   3976: lload 9
    //   3978: lstore 11
    //   3980: lload 9
    //   3982: lstore 17
    //   3984: aload_0
    //   3985: bipush 105
    //   3987: new 113	java/lang/StringBuilder
    //   3990: dup
    //   3991: ldc_w 1130
    //   3994: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3997: invokestatic 1132	com/tencent/smtt/utils/y:a	()J
    //   4000: invokevirtual 571	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4003: ldc_w 1134
    //   4006: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4009: aload_0
    //   4010: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   4013: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4016: invokevirtual 1137	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   4019: invokevirtual 571	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4022: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4025: iconst_1
    //   4026: invokespecial 609	com/tencent/smtt/sdk/ah:a	(ILjava/lang/String;Z)V
    //   4029: lload 9
    //   4031: lstore 11
    //   4033: lload 9
    //   4035: lstore 17
    //   4037: aload_0
    //   4038: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   4041: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4044: sipush -308
    //   4047: invokevirtual 899	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4050: iload_2
    //   4051: istore 6
    //   4053: goto -821 -> 3232
    //   4056: astore 31
    //   4058: lload 11
    //   4060: lstore 9
    //   4062: aload_0
    //   4063: aload 32
    //   4065: invokespecial 749	com/tencent/smtt/sdk/ah:a	(Ljava/io/Closeable;)V
    //   4068: aload_0
    //   4069: aload 29
    //   4071: invokespecial 749	com/tencent/smtt/sdk/ah:a	(Ljava/io/Closeable;)V
    //   4074: aload_0
    //   4075: aload 30
    //   4077: invokespecial 749	com/tencent/smtt/sdk/ah:a	(Ljava/io/Closeable;)V
    //   4080: ldc_w 925
    //   4083: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4086: aload 31
    //   4088: athrow
    //   4089: astore 29
    //   4091: lload 9
    //   4093: lstore 15
    //   4095: iload_2
    //   4096: istore 6
    //   4098: goto -1913 -> 2185
    //   4101: lload 9
    //   4103: lstore 11
    //   4105: iload 4
    //   4107: i2l
    //   4108: lstore 9
    //   4110: iload_2
    //   4111: istore 5
    //   4113: lload 11
    //   4115: lstore 17
    //   4117: iload_2
    //   4118: istore 7
    //   4120: lload 11
    //   4122: lstore 19
    //   4124: aload_0
    //   4125: lload 23
    //   4127: lload 9
    //   4129: invokespecial 1139	com/tencent/smtt/sdk/ah:a	(JJ)J
    //   4132: lstore 23
    //   4134: iload_2
    //   4135: istore 5
    //   4137: lload 11
    //   4139: lstore 17
    //   4141: iload_2
    //   4142: istore 7
    //   4144: lload 11
    //   4146: lstore 19
    //   4148: invokestatic 162	java/lang/System:currentTimeMillis	()J
    //   4151: lstore 25
    //   4153: lload 21
    //   4155: iload 4
    //   4157: i2l
    //   4158: ladd
    //   4159: lstore 21
    //   4161: lload 25
    //   4163: lload 15
    //   4165: lsub
    //   4166: ldc2_w 1140
    //   4169: lcmp
    //   4170: ifle +2414 -> 6584
    //   4173: iload_2
    //   4174: istore 5
    //   4176: lload 11
    //   4178: lstore 17
    //   4180: iload_2
    //   4181: istore 7
    //   4183: lload 11
    //   4185: lstore 19
    //   4187: ldc 202
    //   4189: new 113	java/lang/StringBuilder
    //   4192: dup
    //   4193: ldc_w 1143
    //   4196: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4199: lload 21
    //   4201: invokevirtual 571	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4204: ldc_w 1050
    //   4207: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4210: aload_0
    //   4211: getfield 621	com/tencent/smtt/sdk/ah:l	J
    //   4214: invokevirtual 571	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4217: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4220: iconst_1
    //   4221: invokestatic 942	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   4224: iload_2
    //   4225: istore 5
    //   4227: lload 11
    //   4229: lstore 17
    //   4231: iload_2
    //   4232: istore 7
    //   4234: lload 11
    //   4236: lstore 19
    //   4238: getstatic 494	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   4241: ifnull +57 -> 4298
    //   4244: iload_2
    //   4245: istore 5
    //   4247: lload 11
    //   4249: lstore 17
    //   4251: iload_2
    //   4252: istore 7
    //   4254: lload 11
    //   4256: lstore 19
    //   4258: lload 21
    //   4260: l2d
    //   4261: aload_0
    //   4262: getfield 621	com/tencent/smtt/sdk/ah:l	J
    //   4265: l2d
    //   4266: ddiv
    //   4267: ldc2_w 1144
    //   4270: dmul
    //   4271: d2i
    //   4272: istore 4
    //   4274: iload_2
    //   4275: istore 5
    //   4277: lload 11
    //   4279: lstore 17
    //   4281: iload_2
    //   4282: istore 7
    //   4284: lload 11
    //   4286: lstore 19
    //   4288: getstatic 494	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   4291: iload 4
    //   4293: invokeinterface 1148 2 0
    //   4298: iload_1
    //   4299: ifne +2274 -> 6573
    //   4302: lload 21
    //   4304: lload 13
    //   4306: lsub
    //   4307: ldc2_w 1149
    //   4310: lcmp
    //   4311: ifle +2262 -> 6573
    //   4314: iload_2
    //   4315: istore 5
    //   4317: lload 11
    //   4319: lstore 17
    //   4321: iload_2
    //   4322: istore 7
    //   4324: lload 11
    //   4326: lstore 19
    //   4328: aload_0
    //   4329: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   4332: invokestatic 221	com/tencent/smtt/sdk/TbsDownloader:getOverSea	(Landroid/content/Context;)Z
    //   4335: ifne +194 -> 4529
    //   4338: iload_2
    //   4339: istore 5
    //   4341: lload 11
    //   4343: lstore 17
    //   4345: iload_2
    //   4346: istore 7
    //   4348: lload 11
    //   4350: lstore 19
    //   4352: aload_0
    //   4353: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   4356: invokestatic 657	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   4359: iconst_3
    //   4360: if_icmpne +27 -> 4387
    //   4363: iload_2
    //   4364: istore 5
    //   4366: lload 11
    //   4368: lstore 17
    //   4370: iload_2
    //   4371: istore 7
    //   4373: lload 11
    //   4375: lstore 19
    //   4377: aload_0
    //   4378: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   4381: invokestatic 657	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   4384: ifne +145 -> 4529
    //   4387: iload_2
    //   4388: istore 5
    //   4390: lload 11
    //   4392: lstore 17
    //   4394: iload_2
    //   4395: istore 7
    //   4397: lload 11
    //   4399: lstore 19
    //   4401: invokestatic 883	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   4404: ifne +125 -> 4529
    //   4407: iload_2
    //   4408: istore 5
    //   4410: lload 11
    //   4412: lstore 17
    //   4414: iload_2
    //   4415: istore 7
    //   4417: lload 11
    //   4419: lstore 19
    //   4421: aload_0
    //   4422: invokevirtual 1044	com/tencent/smtt/sdk/ah:b	()V
    //   4425: iload_2
    //   4426: istore 5
    //   4428: lload 11
    //   4430: lstore 17
    //   4432: iload_2
    //   4433: istore 7
    //   4435: lload 11
    //   4437: lstore 19
    //   4439: getstatic 494	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   4442: ifnull +27 -> 4469
    //   4445: iload_2
    //   4446: istore 5
    //   4448: lload 11
    //   4450: lstore 17
    //   4452: iload_2
    //   4453: istore 7
    //   4455: lload 11
    //   4457: lstore 19
    //   4459: getstatic 494	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   4462: bipush 111
    //   4464: invokeinterface 499 2 0
    //   4469: iload_2
    //   4470: istore 5
    //   4472: lload 11
    //   4474: lstore 17
    //   4476: iload_2
    //   4477: istore 7
    //   4479: lload 11
    //   4481: lstore 19
    //   4483: ldc 202
    //   4485: ldc_w 1152
    //   4488: iconst_0
    //   4489: invokestatic 942	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   4492: iload_2
    //   4493: istore 5
    //   4495: lload 11
    //   4497: lstore 17
    //   4499: iload_2
    //   4500: istore 7
    //   4502: lload 11
    //   4504: lstore 19
    //   4506: aload_0
    //   4507: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   4510: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4513: sipush -304
    //   4516: invokevirtual 899	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4519: lload 11
    //   4521: lstore 9
    //   4523: iload_2
    //   4524: istore 6
    //   4526: goto -1294 -> 3232
    //   4529: lload 21
    //   4531: lstore 9
    //   4533: lload 25
    //   4535: lstore 13
    //   4537: lload 13
    //   4539: lstore 15
    //   4541: lload 9
    //   4543: lstore 13
    //   4545: lload 11
    //   4547: lstore 9
    //   4549: goto -1391 -> 3158
    //   4552: aconst_null
    //   4553: astore 33
    //   4555: aconst_null
    //   4556: astore 31
    //   4558: lload 9
    //   4560: lstore 13
    //   4562: lload 13
    //   4564: lstore 15
    //   4566: iload_2
    //   4567: istore 5
    //   4569: lload 13
    //   4571: lstore 11
    //   4573: aload_0
    //   4574: aload 31
    //   4576: invokespecial 749	com/tencent/smtt/sdk/ah:a	(Ljava/io/Closeable;)V
    //   4579: lload 13
    //   4581: lstore 15
    //   4583: iload_2
    //   4584: istore 5
    //   4586: lload 13
    //   4588: lstore 11
    //   4590: aload_0
    //   4591: aload 33
    //   4593: invokespecial 749	com/tencent/smtt/sdk/ah:a	(Ljava/io/Closeable;)V
    //   4596: lload 13
    //   4598: lstore 15
    //   4600: iload_2
    //   4601: istore 5
    //   4603: lload 13
    //   4605: lstore 11
    //   4607: aload_0
    //   4608: aload 30
    //   4610: invokespecial 749	com/tencent/smtt/sdk/ah:a	(Ljava/io/Closeable;)V
    //   4613: lload 13
    //   4615: lstore 15
    //   4617: iload_2
    //   4618: istore 5
    //   4620: lload 13
    //   4622: lstore 11
    //   4624: aload_0
    //   4625: getfield 629	com/tencent/smtt/sdk/ah:s	Z
    //   4628: ifne +27 -> 4655
    //   4631: lload 13
    //   4633: lstore 15
    //   4635: iload_2
    //   4636: istore 5
    //   4638: lload 13
    //   4640: lstore 11
    //   4642: aload_0
    //   4643: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   4646: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4649: sipush -319
    //   4652: invokevirtual 899	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4655: iload_2
    //   4656: istore 5
    //   4658: iload_1
    //   4659: ifne -4100 -> 559
    //   4662: aload_0
    //   4663: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   4666: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4669: getfield 463	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   4672: ldc_w 970
    //   4675: lload 13
    //   4677: invokestatic 996	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4680: invokeinterface 477 3 0
    //   4685: pop
    //   4686: aload_0
    //   4687: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   4690: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4693: invokevirtual 489	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   4696: iload_2
    //   4697: istore 5
    //   4699: goto -4140 -> 559
    //   4702: iload_1
    //   4703: ifne +174 -> 4877
    //   4706: aload_0
    //   4707: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   4710: invokestatic 998	com/tencent/smtt/utils/k:b	(Landroid/content/Context;)Z
    //   4713: ifne +164 -> 4877
    //   4716: aload_0
    //   4717: bipush 105
    //   4719: new 113	java/lang/StringBuilder
    //   4722: dup
    //   4723: ldc_w 1130
    //   4726: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4729: invokestatic 1132	com/tencent/smtt/utils/y:a	()J
    //   4732: invokevirtual 571	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4735: ldc_w 1134
    //   4738: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4741: aload_0
    //   4742: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   4745: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4748: invokevirtual 1137	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   4751: invokevirtual 571	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4754: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4757: iconst_1
    //   4758: invokespecial 609	com/tencent/smtt/sdk/ah:a	(ILjava/lang/String;Z)V
    //   4761: aload_0
    //   4762: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   4765: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4768: sipush -308
    //   4771: invokevirtual 899	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4774: lload 9
    //   4776: lstore 15
    //   4778: iload 6
    //   4780: istore 5
    //   4782: lload 9
    //   4784: lstore 11
    //   4786: aload_0
    //   4787: aload 32
    //   4789: invokespecial 749	com/tencent/smtt/sdk/ah:a	(Ljava/io/Closeable;)V
    //   4792: lload 9
    //   4794: lstore 15
    //   4796: iload 6
    //   4798: istore 5
    //   4800: lload 9
    //   4802: lstore 11
    //   4804: aload_0
    //   4805: aload 31
    //   4807: invokespecial 749	com/tencent/smtt/sdk/ah:a	(Ljava/io/Closeable;)V
    //   4810: lload 9
    //   4812: lstore 15
    //   4814: iload 6
    //   4816: istore 5
    //   4818: lload 9
    //   4820: lstore 11
    //   4822: aload_0
    //   4823: aload 29
    //   4825: invokespecial 749	com/tencent/smtt/sdk/ah:a	(Ljava/io/Closeable;)V
    //   4828: iload 6
    //   4830: istore 5
    //   4832: iload_1
    //   4833: ifne -4274 -> 559
    //   4836: aload_0
    //   4837: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   4840: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4843: getfield 463	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   4846: ldc_w 970
    //   4849: lload 9
    //   4851: invokestatic 996	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4854: invokeinterface 477 3 0
    //   4859: pop
    //   4860: aload_0
    //   4861: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   4864: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4867: invokevirtual 489	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   4870: iload 6
    //   4872: istore 5
    //   4874: goto -4315 -> 559
    //   4877: aload_0
    //   4878: lconst_0
    //   4879: invokespecial 1109	com/tencent/smtt/sdk/ah:a	(J)V
    //   4882: aload_0
    //   4883: invokespecial 1154	com/tencent/smtt/sdk/ah:i	()Z
    //   4886: ifne +125 -> 5011
    //   4889: aload_0
    //   4890: bipush 106
    //   4892: aload_0
    //   4893: aload 30
    //   4895: invokespecial 607	com/tencent/smtt/sdk/ah:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   4898: iconst_0
    //   4899: invokespecial 609	com/tencent/smtt/sdk/ah:a	(ILjava/lang/String;Z)V
    //   4902: lload 9
    //   4904: lstore 15
    //   4906: iload 6
    //   4908: istore 5
    //   4910: lload 9
    //   4912: lstore 11
    //   4914: aload_0
    //   4915: aload 32
    //   4917: invokespecial 749	com/tencent/smtt/sdk/ah:a	(Ljava/io/Closeable;)V
    //   4920: lload 9
    //   4922: lstore 15
    //   4924: iload 6
    //   4926: istore 5
    //   4928: lload 9
    //   4930: lstore 11
    //   4932: aload_0
    //   4933: aload 31
    //   4935: invokespecial 749	com/tencent/smtt/sdk/ah:a	(Ljava/io/Closeable;)V
    //   4938: lload 9
    //   4940: lstore 15
    //   4942: iload 6
    //   4944: istore 5
    //   4946: lload 9
    //   4948: lstore 11
    //   4950: aload_0
    //   4951: aload 29
    //   4953: invokespecial 749	com/tencent/smtt/sdk/ah:a	(Ljava/io/Closeable;)V
    //   4956: lload 9
    //   4958: lstore 13
    //   4960: iload 6
    //   4962: istore_2
    //   4963: iload_1
    //   4964: ifne -4452 -> 512
    //   4967: aload_0
    //   4968: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   4971: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4974: getfield 463	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   4977: ldc_w 970
    //   4980: lload 9
    //   4982: invokestatic 996	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4985: invokeinterface 477 3 0
    //   4990: pop
    //   4991: aload_0
    //   4992: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   4995: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4998: invokevirtual 489	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5001: lload 9
    //   5003: lstore 13
    //   5005: iload 6
    //   5007: istore_2
    //   5008: goto -4496 -> 512
    //   5011: aload_0
    //   5012: bipush 104
    //   5014: aload_0
    //   5015: aload 30
    //   5017: invokespecial 607	com/tencent/smtt/sdk/ah:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   5020: iconst_0
    //   5021: invokespecial 609	com/tencent/smtt/sdk/ah:a	(ILjava/lang/String;Z)V
    //   5024: goto -122 -> 4902
    //   5027: astore 34
    //   5029: aload 31
    //   5031: astore 30
    //   5033: aload 29
    //   5035: astore 33
    //   5037: iload 6
    //   5039: istore_2
    //   5040: aload 34
    //   5042: astore 31
    //   5044: aload 30
    //   5046: astore 29
    //   5048: aload 33
    //   5050: astore 30
    //   5052: goto -990 -> 4062
    //   5055: iload_3
    //   5056: sipush 300
    //   5059: if_icmplt +229 -> 5288
    //   5062: iload_3
    //   5063: sipush 307
    //   5066: if_icmpgt +222 -> 5288
    //   5069: lload 9
    //   5071: lstore 15
    //   5073: iload_2
    //   5074: istore 5
    //   5076: lload 9
    //   5078: lstore 11
    //   5080: aload_0
    //   5081: getfield 395	com/tencent/smtt/sdk/ah:t	Ljava/net/HttpURLConnection;
    //   5084: ldc_w 1156
    //   5087: invokevirtual 1159	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   5090: astore 29
    //   5092: lload 9
    //   5094: lstore 15
    //   5096: iload_2
    //   5097: istore 5
    //   5099: lload 9
    //   5101: lstore 11
    //   5103: aload 29
    //   5105: invokestatic 779	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5108: ifne +90 -> 5198
    //   5111: lload 9
    //   5113: lstore 15
    //   5115: iload_2
    //   5116: istore 5
    //   5118: lload 9
    //   5120: lstore 11
    //   5122: aload_0
    //   5123: aload 29
    //   5125: putfield 623	com/tencent/smtt/sdk/ah:j	Ljava/lang/String;
    //   5128: lload 9
    //   5130: lstore 15
    //   5132: iload_2
    //   5133: istore 5
    //   5135: lload 9
    //   5137: lstore 11
    //   5139: aload_0
    //   5140: aload_0
    //   5141: getfield 617	com/tencent/smtt/sdk/ah:q	I
    //   5144: iconst_1
    //   5145: iadd
    //   5146: putfield 617	com/tencent/smtt/sdk/ah:q	I
    //   5149: lload 9
    //   5151: lstore 13
    //   5153: iload_1
    //   5154: ifne -4642 -> 512
    //   5157: aload_0
    //   5158: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   5161: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5164: getfield 463	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   5167: ldc_w 970
    //   5170: lload 9
    //   5172: invokestatic 996	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5175: invokeinterface 477 3 0
    //   5180: pop
    //   5181: aload_0
    //   5182: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   5185: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5188: invokevirtual 489	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5191: lload 9
    //   5193: lstore 13
    //   5195: goto -4683 -> 512
    //   5198: lload 9
    //   5200: lstore 15
    //   5202: iload_2
    //   5203: istore 5
    //   5205: lload 9
    //   5207: lstore 11
    //   5209: aload_0
    //   5210: bipush 124
    //   5212: aconst_null
    //   5213: iconst_1
    //   5214: invokespecial 609	com/tencent/smtt/sdk/ah:a	(ILjava/lang/String;Z)V
    //   5217: lload 9
    //   5219: lstore 15
    //   5221: iload_2
    //   5222: istore 5
    //   5224: lload 9
    //   5226: lstore 11
    //   5228: aload_0
    //   5229: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   5232: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5235: sipush -312
    //   5238: invokevirtual 899	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5241: iload_2
    //   5242: istore 5
    //   5244: iload_1
    //   5245: ifne -4686 -> 559
    //   5248: aload_0
    //   5249: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   5252: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5255: getfield 463	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   5258: ldc_w 970
    //   5261: lload 9
    //   5263: invokestatic 996	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5266: invokeinterface 477 3 0
    //   5271: pop
    //   5272: aload_0
    //   5273: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   5276: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5279: invokevirtual 489	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5282: iload_2
    //   5283: istore 5
    //   5285: goto -4726 -> 559
    //   5288: lload 9
    //   5290: lstore 15
    //   5292: iload_2
    //   5293: istore 5
    //   5295: lload 9
    //   5297: lstore 11
    //   5299: aload_0
    //   5300: bipush 102
    //   5302: iload_3
    //   5303: invokestatic 362	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   5306: iconst_0
    //   5307: invokespecial 609	com/tencent/smtt/sdk/ah:a	(ILjava/lang/String;Z)V
    //   5310: iload_3
    //   5311: sipush 416
    //   5314: if_icmpne +185 -> 5499
    //   5317: lload 9
    //   5319: lstore 15
    //   5321: iload_2
    //   5322: istore 5
    //   5324: lload 9
    //   5326: lstore 11
    //   5328: aload_0
    //   5329: iconst_1
    //   5330: iload 8
    //   5332: invokespecial 907	com/tencent/smtt/sdk/ah:c	(ZZ)Z
    //   5335: ifeq +76 -> 5411
    //   5338: iconst_1
    //   5339: istore 5
    //   5341: iconst_1
    //   5342: istore_2
    //   5343: lload 9
    //   5345: lstore 15
    //   5347: lload 9
    //   5349: lstore 11
    //   5351: aload_0
    //   5352: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   5355: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5358: sipush -214
    //   5361: invokevirtual 899	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5364: iload_2
    //   5365: istore 5
    //   5367: iload_1
    //   5368: ifne -4809 -> 559
    //   5371: aload_0
    //   5372: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   5375: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5378: getfield 463	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   5381: ldc_w 970
    //   5384: lload 9
    //   5386: invokestatic 996	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5389: invokeinterface 477 3 0
    //   5394: pop
    //   5395: aload_0
    //   5396: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   5399: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5402: invokevirtual 489	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5405: iload_2
    //   5406: istore 5
    //   5408: goto -4849 -> 559
    //   5411: lload 9
    //   5413: lstore 15
    //   5415: iload_2
    //   5416: istore 5
    //   5418: lload 9
    //   5420: lstore 11
    //   5422: aload_0
    //   5423: iconst_0
    //   5424: invokespecial 909	com/tencent/smtt/sdk/ah:d	(Z)Z
    //   5427: pop
    //   5428: lload 9
    //   5430: lstore 15
    //   5432: iload_2
    //   5433: istore 5
    //   5435: lload 9
    //   5437: lstore 11
    //   5439: aload_0
    //   5440: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   5443: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5446: sipush -313
    //   5449: invokevirtual 899	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5452: iload_2
    //   5453: istore 5
    //   5455: iload_1
    //   5456: ifne -4897 -> 559
    //   5459: aload_0
    //   5460: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   5463: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5466: getfield 463	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   5469: ldc_w 970
    //   5472: lload 9
    //   5474: invokestatic 996	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5477: invokeinterface 477 3 0
    //   5482: pop
    //   5483: aload_0
    //   5484: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   5487: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5490: invokevirtual 489	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5493: iload_2
    //   5494: istore 5
    //   5496: goto -4937 -> 559
    //   5499: iload_3
    //   5500: sipush 403
    //   5503: if_icmpeq +10 -> 5513
    //   5506: iload_3
    //   5507: sipush 406
    //   5510: if_icmpne +96 -> 5606
    //   5513: lload 9
    //   5515: lstore 15
    //   5517: iload_2
    //   5518: istore 5
    //   5520: lload 9
    //   5522: lstore 11
    //   5524: aload_0
    //   5525: getfield 621	com/tencent/smtt/sdk/ah:l	J
    //   5528: ldc2_w 618
    //   5531: lcmp
    //   5532: ifne +74 -> 5606
    //   5535: lload 9
    //   5537: lstore 15
    //   5539: iload_2
    //   5540: istore 5
    //   5542: lload 9
    //   5544: lstore 11
    //   5546: aload_0
    //   5547: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   5550: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5553: sipush -314
    //   5556: invokevirtual 899	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5559: iload_2
    //   5560: istore 5
    //   5562: iload_1
    //   5563: ifne -5004 -> 559
    //   5566: aload_0
    //   5567: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   5570: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5573: getfield 463	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   5576: ldc_w 970
    //   5579: lload 9
    //   5581: invokestatic 996	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5584: invokeinterface 477 3 0
    //   5589: pop
    //   5590: aload_0
    //   5591: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   5594: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5597: invokevirtual 489	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5600: iload_2
    //   5601: istore 5
    //   5603: goto -5044 -> 559
    //   5606: iload_3
    //   5607: sipush 202
    //   5610: if_icmpne +52 -> 5662
    //   5613: lload 9
    //   5615: lstore 13
    //   5617: iload_1
    //   5618: ifne -5106 -> 512
    //   5621: aload_0
    //   5622: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   5625: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5628: getfield 463	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   5631: ldc_w 970
    //   5634: lload 9
    //   5636: invokestatic 996	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5639: invokeinterface 477 3 0
    //   5644: pop
    //   5645: aload_0
    //   5646: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   5649: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5652: invokevirtual 489	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5655: lload 9
    //   5657: lstore 13
    //   5659: goto -5147 -> 512
    //   5662: lload 9
    //   5664: lstore 15
    //   5666: iload_2
    //   5667: istore 5
    //   5669: lload 9
    //   5671: lstore 11
    //   5673: aload_0
    //   5674: getfield 267	com/tencent/smtt/sdk/ah:p	I
    //   5677: aload_0
    //   5678: getfield 82	com/tencent/smtt/sdk/ah:B	I
    //   5681: if_icmpge +176 -> 5857
    //   5684: iload_3
    //   5685: sipush 503
    //   5688: if_icmpne +169 -> 5857
    //   5691: lload 9
    //   5693: lstore 15
    //   5695: iload_2
    //   5696: istore 5
    //   5698: lload 9
    //   5700: lstore 11
    //   5702: aload_0
    //   5703: aload_0
    //   5704: getfield 395	com/tencent/smtt/sdk/ah:t	Ljava/net/HttpURLConnection;
    //   5707: ldc_w 1161
    //   5710: invokevirtual 1159	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   5713: invokestatic 1165	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   5716: invokespecial 1109	com/tencent/smtt/sdk/ah:a	(J)V
    //   5719: lload 9
    //   5721: lstore 15
    //   5723: iload_2
    //   5724: istore 5
    //   5726: lload 9
    //   5728: lstore 11
    //   5730: aload_0
    //   5731: getfield 627	com/tencent/smtt/sdk/ah:r	Z
    //   5734: ifeq +74 -> 5808
    //   5737: lload 9
    //   5739: lstore 15
    //   5741: iload_2
    //   5742: istore 5
    //   5744: lload 9
    //   5746: lstore 11
    //   5748: aload_0
    //   5749: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   5752: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5755: sipush -309
    //   5758: invokevirtual 899	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5761: iload_2
    //   5762: istore 5
    //   5764: iload_1
    //   5765: ifne -5206 -> 559
    //   5768: aload_0
    //   5769: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   5772: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5775: getfield 463	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   5778: ldc_w 970
    //   5781: lload 9
    //   5783: invokestatic 996	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5786: invokeinterface 477 3 0
    //   5791: pop
    //   5792: aload_0
    //   5793: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   5796: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5799: invokevirtual 489	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5802: iload_2
    //   5803: istore 5
    //   5805: goto -5246 -> 559
    //   5808: lload 9
    //   5810: lstore 13
    //   5812: iload_1
    //   5813: ifne -5301 -> 512
    //   5816: aload_0
    //   5817: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   5820: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5823: getfield 463	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   5826: ldc_w 970
    //   5829: lload 9
    //   5831: invokestatic 996	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5834: invokeinterface 477 3 0
    //   5839: pop
    //   5840: aload_0
    //   5841: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   5844: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5847: invokevirtual 489	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5850: lload 9
    //   5852: lstore 13
    //   5854: goto -5342 -> 512
    //   5857: lload 9
    //   5859: lstore 15
    //   5861: iload_2
    //   5862: istore 5
    //   5864: lload 9
    //   5866: lstore 11
    //   5868: aload_0
    //   5869: getfield 267	com/tencent/smtt/sdk/ah:p	I
    //   5872: aload_0
    //   5873: getfield 82	com/tencent/smtt/sdk/ah:B	I
    //   5876: if_icmpge +185 -> 6061
    //   5879: iload_3
    //   5880: sipush 408
    //   5883: if_icmpeq +24 -> 5907
    //   5886: iload_3
    //   5887: sipush 504
    //   5890: if_icmpeq +17 -> 5907
    //   5893: iload_3
    //   5894: sipush 502
    //   5897: if_icmpeq +10 -> 5907
    //   5900: iload_3
    //   5901: sipush 408
    //   5904: if_icmpne +157 -> 6061
    //   5907: lload 9
    //   5909: lstore 15
    //   5911: iload_2
    //   5912: istore 5
    //   5914: lload 9
    //   5916: lstore 11
    //   5918: aload_0
    //   5919: lconst_0
    //   5920: invokespecial 1109	com/tencent/smtt/sdk/ah:a	(J)V
    //   5923: lload 9
    //   5925: lstore 15
    //   5927: iload_2
    //   5928: istore 5
    //   5930: lload 9
    //   5932: lstore 11
    //   5934: aload_0
    //   5935: getfield 627	com/tencent/smtt/sdk/ah:r	Z
    //   5938: ifeq +74 -> 6012
    //   5941: lload 9
    //   5943: lstore 15
    //   5945: iload_2
    //   5946: istore 5
    //   5948: lload 9
    //   5950: lstore 11
    //   5952: aload_0
    //   5953: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   5956: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5959: sipush -309
    //   5962: invokevirtual 899	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5965: iload_2
    //   5966: istore 5
    //   5968: iload_1
    //   5969: ifne -5410 -> 559
    //   5972: aload_0
    //   5973: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   5976: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5979: getfield 463	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   5982: ldc_w 970
    //   5985: lload 9
    //   5987: invokestatic 996	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5990: invokeinterface 477 3 0
    //   5995: pop
    //   5996: aload_0
    //   5997: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   6000: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6003: invokevirtual 489	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6006: iload_2
    //   6007: istore 5
    //   6009: goto -5450 -> 559
    //   6012: lload 9
    //   6014: lstore 13
    //   6016: iload_1
    //   6017: ifne -5505 -> 512
    //   6020: aload_0
    //   6021: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   6024: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6027: getfield 463	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   6030: ldc_w 970
    //   6033: lload 9
    //   6035: invokestatic 996	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6038: invokeinterface 477 3 0
    //   6043: pop
    //   6044: aload_0
    //   6045: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   6048: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6051: invokevirtual 489	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6054: lload 9
    //   6056: lstore 13
    //   6058: goto -5546 -> 512
    //   6061: lload 9
    //   6063: lstore 15
    //   6065: iload_2
    //   6066: istore 5
    //   6068: lload 9
    //   6070: lstore 11
    //   6072: aload_0
    //   6073: invokespecial 1020	com/tencent/smtt/sdk/ah:j	()J
    //   6076: lconst_0
    //   6077: lcmp
    //   6078: ifgt +93 -> 6171
    //   6081: lload 9
    //   6083: lstore 15
    //   6085: iload_2
    //   6086: istore 5
    //   6088: lload 9
    //   6090: lstore 11
    //   6092: aload_0
    //   6093: getfield 625	com/tencent/smtt/sdk/ah:o	Z
    //   6096: ifne +75 -> 6171
    //   6099: iload_3
    //   6100: sipush 410
    //   6103: if_icmpeq +68 -> 6171
    //   6106: lload 9
    //   6108: lstore 15
    //   6110: iload_2
    //   6111: istore 5
    //   6113: lload 9
    //   6115: lstore 11
    //   6117: aload_0
    //   6118: iconst_1
    //   6119: putfield 625	com/tencent/smtt/sdk/ah:o	Z
    //   6122: lload 9
    //   6124: lstore 13
    //   6126: iload_1
    //   6127: ifne -5615 -> 512
    //   6130: aload_0
    //   6131: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   6134: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6137: getfield 463	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   6140: ldc_w 970
    //   6143: lload 9
    //   6145: invokestatic 996	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6148: invokeinterface 477 3 0
    //   6153: pop
    //   6154: aload_0
    //   6155: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   6158: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6161: invokevirtual 489	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6164: lload 9
    //   6166: lstore 13
    //   6168: goto -5656 -> 512
    //   6171: lload 9
    //   6173: lstore 15
    //   6175: iload_2
    //   6176: istore 5
    //   6178: lload 9
    //   6180: lstore 11
    //   6182: aload_0
    //   6183: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   6186: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6189: sipush -315
    //   6192: invokevirtual 899	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6195: iload_2
    //   6196: istore 5
    //   6198: iload_1
    //   6199: ifne -5640 -> 559
    //   6202: aload_0
    //   6203: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   6206: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6209: getfield 463	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   6212: ldc_w 970
    //   6215: lload 9
    //   6217: invokestatic 996	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6220: invokeinterface 477 3 0
    //   6225: pop
    //   6226: aload_0
    //   6227: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   6230: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6233: invokevirtual 489	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6236: iload_2
    //   6237: istore 5
    //   6239: goto -5680 -> 559
    //   6242: lload 15
    //   6244: lstore 11
    //   6246: aload_0
    //   6247: lconst_0
    //   6248: invokespecial 1109	com/tencent/smtt/sdk/ah:a	(J)V
    //   6251: lload 15
    //   6253: lstore 11
    //   6255: aload_0
    //   6256: bipush 107
    //   6258: aload_0
    //   6259: aload 29
    //   6261: invokespecial 607	com/tencent/smtt/sdk/ah:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   6264: iconst_0
    //   6265: invokespecial 609	com/tencent/smtt/sdk/ah:a	(ILjava/lang/String;Z)V
    //   6268: lload 15
    //   6270: lstore 11
    //   6272: aload_0
    //   6273: getfield 627	com/tencent/smtt/sdk/ah:r	Z
    //   6276: ifeq -3997 -> 2279
    //   6279: lload 15
    //   6281: lstore 11
    //   6283: aload_0
    //   6284: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   6287: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6290: sipush -309
    //   6293: invokevirtual 899	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6296: iload 6
    //   6298: istore 5
    //   6300: iload_1
    //   6301: ifne -5742 -> 559
    //   6304: aload_0
    //   6305: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   6308: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6311: getfield 463	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   6314: ldc_w 970
    //   6317: lload 15
    //   6319: invokestatic 996	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6322: invokeinterface 477 3 0
    //   6327: pop
    //   6328: aload_0
    //   6329: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   6332: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6335: invokevirtual 489	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6338: iload 6
    //   6340: istore 5
    //   6342: goto -5783 -> 559
    //   6345: iconst_0
    //   6346: istore_3
    //   6347: goto -5733 -> 614
    //   6350: iconst_2
    //   6351: istore_3
    //   6352: goto -5715 -> 637
    //   6355: aload_0
    //   6356: getfield 106	com/tencent/smtt/sdk/ah:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   6359: iconst_0
    //   6360: invokevirtual 976	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setPatchUpdateFlag	(I)V
    //   6363: goto -5720 -> 643
    //   6366: aload_0
    //   6367: getfield 94	com/tencent/smtt/sdk/ah:g	Landroid/content/Context;
    //   6370: invokestatic 301	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6373: sipush -318
    //   6376: invokevirtual 899	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6379: aload_0
    //   6380: iconst_0
    //   6381: invokespecial 909	com/tencent/smtt/sdk/ah:d	(Z)Z
    //   6384: pop
    //   6385: goto -5710 -> 675
    //   6388: aload 29
    //   6390: getfield 305	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   6393: ldc_w 1167
    //   6396: iconst_0
    //   6397: invokeinterface 313 3 0
    //   6402: istore_3
    //   6403: aload 29
    //   6405: getfield 463	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   6408: astore 30
    //   6410: iload_3
    //   6411: iconst_1
    //   6412: iadd
    //   6413: istore_3
    //   6414: aload 30
    //   6416: ldc_w 1167
    //   6419: iload_3
    //   6420: invokestatic 486	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6423: invokeinterface 477 3 0
    //   6428: pop
    //   6429: iload_3
    //   6430: aload 29
    //   6432: invokevirtual 1170	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadFailedMaxRetrytimes	()I
    //   6435: if_icmpne -5712 -> 723
    //   6438: aload_0
    //   6439: getfield 106	com/tencent/smtt/sdk/ah:v	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   6442: iconst_2
    //   6443: invokevirtual 1033	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownloadCancel	(I)V
    //   6446: goto -5723 -> 723
    //   6449: iconst_0
    //   6450: istore_3
    //   6451: goto -5711 -> 740
    //   6454: astore 29
    //   6456: goto -3997 -> 2459
    //   6459: astore 31
    //   6461: aconst_null
    //   6462: astore 29
    //   6464: aconst_null
    //   6465: astore 30
    //   6467: aconst_null
    //   6468: astore 32
    //   6470: goto -2408 -> 4062
    //   6473: astore 31
    //   6475: aconst_null
    //   6476: astore 29
    //   6478: aconst_null
    //   6479: astore 32
    //   6481: goto -2419 -> 4062
    //   6484: astore 31
    //   6486: aconst_null
    //   6487: astore 32
    //   6489: goto -2427 -> 4062
    //   6492: astore 31
    //   6494: iload 5
    //   6496: istore_2
    //   6497: lload 17
    //   6499: lstore 9
    //   6501: goto -2439 -> 4062
    //   6504: astore 30
    //   6506: iload_2
    //   6507: istore 6
    //   6509: aload 33
    //   6511: astore 32
    //   6513: goto -3098 -> 3415
    //   6516: astore 31
    //   6518: aload 30
    //   6520: astore 32
    //   6522: iload_2
    //   6523: istore 6
    //   6525: aload 31
    //   6527: astore 30
    //   6529: aload 29
    //   6531: astore 31
    //   6533: aload 32
    //   6535: astore 29
    //   6537: aload 33
    //   6539: astore 32
    //   6541: goto -3126 -> 3415
    //   6544: astore 31
    //   6546: aload 30
    //   6548: astore 33
    //   6550: lload 19
    //   6552: lstore 9
    //   6554: iload 7
    //   6556: istore 6
    //   6558: aload 31
    //   6560: astore 30
    //   6562: aload 29
    //   6564: astore 31
    //   6566: aload 33
    //   6568: astore 29
    //   6570: goto -3155 -> 3415
    //   6573: lload 13
    //   6575: lstore 9
    //   6577: lload 25
    //   6579: lstore 13
    //   6581: goto -2044 -> 4537
    //   6584: lload 13
    //   6586: lstore 9
    //   6588: lload 15
    //   6590: lstore 13
    //   6592: goto -2055 -> 4537
    //   6595: astore 31
    //   6597: aload 30
    //   6599: astore 33
    //   6601: lload 17
    //   6603: lstore 9
    //   6605: iload_2
    //   6606: istore 6
    //   6608: aload 31
    //   6610: astore 30
    //   6612: aload 29
    //   6614: astore 31
    //   6616: aload 33
    //   6618: astore 29
    //   6620: goto -3205 -> 3415
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	6623	0	this	ah
    //   0	6623	1	paramBoolean1	boolean
    //   0	6623	2	paramBoolean2	boolean
    //   66	6385	3	i1	int
    //   3597	695	4	i2	int
    //   513	5982	5	bool1	boolean
    //   2183	4424	6	bool2	boolean
    //   3166	3389	7	bool3	boolean
    //   83	5248	8	bool4	boolean
    //   774	5830	9	l1	long
    //   789	5493	11	l2	long
    //   499	6092	13	l3	long
    //   782	5807	15	l4	long
    //   930	5672	17	l5	long
    //   3170	3381	19	l6	long
    //   3156	1374	21	l7	long
    //   770	3363	23	l8	long
    //   4151	2427	25	l9	long
    //   476	3427	27	l10	long
    //   163	1909	29	localObject1	Object
    //   2179	251	29	localThrowable1	Throwable
    //   2453	51	29	localObject2	Object
    //   3034	1036	29	localObject3	Object
    //   4089	945	29	localThrowable2	Throwable
    //   5046	1385	29	localObject4	Object
    //   6454	1	29	localObject5	Object
    //   6462	157	29	localObject6	Object
    //   3065	3401	30	localObject7	Object
    //   6504	15	30	localIOException1	IOException
    //   6527	84	30	localIOException2	IOException
    //   3037	766	31	localObject8	Object
    //   4056	31	31	localObject9	Object
    //   4556	487	31	localObject10	Object
    //   6459	1	31	localObject11	Object
    //   6473	1	31	localObject12	Object
    //   6484	1	31	localObject13	Object
    //   6492	1	31	localObject14	Object
    //   6516	10	31	localIOException3	IOException
    //   6531	1	31	localObject15	Object
    //   6544	15	31	localIOException4	IOException
    //   6564	1	31	localObject16	Object
    //   6595	14	31	localIOException5	IOException
    //   6614	1	31	localObject17	Object
    //   3137	3403	32	localObject18	Object
    //   3031	3586	33	localObject19	Object
    //   3398	11	34	localIOException6	IOException
    //   5027	14	34	localObject20	Object
    // Exception table:
    //   from	to	target	type
    //   791	820	2179	java/lang/Throwable
    //   831	839	2179	java/lang/Throwable
    //   850	874	2179	java/lang/Throwable
    //   885	908	2179	java/lang/Throwable
    //   919	929	2179	java/lang/Throwable
    //   947	957	2179	java/lang/Throwable
    //   968	977	2179	java/lang/Throwable
    //   988	996	2179	java/lang/Throwable
    //   1007	1020	2179	java/lang/Throwable
    //   1078	1094	2179	java/lang/Throwable
    //   1117	1126	2179	java/lang/Throwable
    //   1137	1145	2179	java/lang/Throwable
    //   1156	1169	2179	java/lang/Throwable
    //   1227	1232	2179	java/lang/Throwable
    //   1243	1250	2179	java/lang/Throwable
    //   1261	1267	2179	java/lang/Throwable
    //   1278	1315	2179	java/lang/Throwable
    //   1326	1338	2179	java/lang/Throwable
    //   1349	1358	2179	java/lang/Throwable
    //   1369	1375	2179	java/lang/Throwable
    //   1386	1392	2179	java/lang/Throwable
    //   1406	1413	2179	java/lang/Throwable
    //   1424	1430	2179	java/lang/Throwable
    //   1441	1457	2179	java/lang/Throwable
    //   1468	1477	2179	java/lang/Throwable
    //   1488	1505	2179	java/lang/Throwable
    //   1516	1550	2179	java/lang/Throwable
    //   1561	1567	2179	java/lang/Throwable
    //   1587	1593	2179	java/lang/Throwable
    //   1604	1612	2179	java/lang/Throwable
    //   1623	1632	2179	java/lang/Throwable
    //   1643	1650	2179	java/lang/Throwable
    //   1661	1669	2179	java/lang/Throwable
    //   1680	1686	2179	java/lang/Throwable
    //   1697	1702	2179	java/lang/Throwable
    //   1713	1720	2179	java/lang/Throwable
    //   1731	1745	2179	java/lang/Throwable
    //   1756	1764	2179	java/lang/Throwable
    //   1775	1790	2179	java/lang/Throwable
    //   1801	1809	2179	java/lang/Throwable
    //   1824	1834	2179	java/lang/Throwable
    //   1845	1856	2179	java/lang/Throwable
    //   1867	1877	2179	java/lang/Throwable
    //   1888	1894	2179	java/lang/Throwable
    //   1905	1909	2179	java/lang/Throwable
    //   1920	1926	2179	java/lang/Throwable
    //   1937	1947	2179	java/lang/Throwable
    //   1958	1967	2179	java/lang/Throwable
    //   1978	1985	2179	java/lang/Throwable
    //   1996	2009	2179	java/lang/Throwable
    //   2067	2073	2179	java/lang/Throwable
    //   2087	2124	2179	java/lang/Throwable
    //   2135	2176	2179	java/lang/Throwable
    //   2367	2375	2179	java/lang/Throwable
    //   2386	2398	2179	java/lang/Throwable
    //   2409	2417	2179	java/lang/Throwable
    //   2428	2434	2179	java/lang/Throwable
    //   2445	2450	2179	java/lang/Throwable
    //   2531	2546	2179	java/lang/Throwable
    //   2557	2582	2179	java/lang/Throwable
    //   2593	2604	2179	java/lang/Throwable
    //   2615	2636	2179	java/lang/Throwable
    //   2654	2664	2179	java/lang/Throwable
    //   2675	2712	2179	java/lang/Throwable
    //   2727	2734	2179	java/lang/Throwable
    //   2745	2751	2179	java/lang/Throwable
    //   2762	2772	2179	java/lang/Throwable
    //   2783	2790	2179	java/lang/Throwable
    //   2801	2808	2179	java/lang/Throwable
    //   2873	2911	2179	java/lang/Throwable
    //   2922	2935	2179	java/lang/Throwable
    //   2993	3003	2179	java/lang/Throwable
    //   3014	3027	2179	java/lang/Throwable
    //   3050	3058	2179	java/lang/Throwable
    //   3263	3269	2179	java/lang/Throwable
    //   3281	3287	2179	java/lang/Throwable
    //   3299	3305	2179	java/lang/Throwable
    //   3468	3474	2179	java/lang/Throwable
    //   3486	3492	2179	java/lang/Throwable
    //   3504	3510	2179	java/lang/Throwable
    //   4573	4579	2179	java/lang/Throwable
    //   4590	4596	2179	java/lang/Throwable
    //   4607	4613	2179	java/lang/Throwable
    //   4624	4631	2179	java/lang/Throwable
    //   4642	4655	2179	java/lang/Throwable
    //   4786	4792	2179	java/lang/Throwable
    //   4804	4810	2179	java/lang/Throwable
    //   4822	4828	2179	java/lang/Throwable
    //   4914	4920	2179	java/lang/Throwable
    //   4932	4938	2179	java/lang/Throwable
    //   4950	4956	2179	java/lang/Throwable
    //   5080	5092	2179	java/lang/Throwable
    //   5103	5111	2179	java/lang/Throwable
    //   5122	5128	2179	java/lang/Throwable
    //   5139	5149	2179	java/lang/Throwable
    //   5209	5217	2179	java/lang/Throwable
    //   5228	5241	2179	java/lang/Throwable
    //   5299	5310	2179	java/lang/Throwable
    //   5328	5338	2179	java/lang/Throwable
    //   5351	5364	2179	java/lang/Throwable
    //   5422	5428	2179	java/lang/Throwable
    //   5439	5452	2179	java/lang/Throwable
    //   5524	5535	2179	java/lang/Throwable
    //   5546	5559	2179	java/lang/Throwable
    //   5673	5684	2179	java/lang/Throwable
    //   5702	5719	2179	java/lang/Throwable
    //   5730	5737	2179	java/lang/Throwable
    //   5748	5761	2179	java/lang/Throwable
    //   5868	5879	2179	java/lang/Throwable
    //   5918	5923	2179	java/lang/Throwable
    //   5934	5941	2179	java/lang/Throwable
    //   5952	5965	2179	java/lang/Throwable
    //   6072	6081	2179	java/lang/Throwable
    //   6092	6099	2179	java/lang/Throwable
    //   6117	6122	2179	java/lang/Throwable
    //   6182	6195	2179	java/lang/Throwable
    //   791	820	2453	finally
    //   831	839	2453	finally
    //   850	874	2453	finally
    //   885	908	2453	finally
    //   919	929	2453	finally
    //   947	957	2453	finally
    //   968	977	2453	finally
    //   988	996	2453	finally
    //   1007	1020	2453	finally
    //   1078	1094	2453	finally
    //   1117	1126	2453	finally
    //   1137	1145	2453	finally
    //   1156	1169	2453	finally
    //   1227	1232	2453	finally
    //   1243	1250	2453	finally
    //   1261	1267	2453	finally
    //   1278	1315	2453	finally
    //   1326	1338	2453	finally
    //   1349	1358	2453	finally
    //   1369	1375	2453	finally
    //   1386	1392	2453	finally
    //   1406	1413	2453	finally
    //   1424	1430	2453	finally
    //   1441	1457	2453	finally
    //   1468	1477	2453	finally
    //   1488	1505	2453	finally
    //   1516	1550	2453	finally
    //   1561	1567	2453	finally
    //   1587	1593	2453	finally
    //   1604	1612	2453	finally
    //   1623	1632	2453	finally
    //   1643	1650	2453	finally
    //   1661	1669	2453	finally
    //   1680	1686	2453	finally
    //   1697	1702	2453	finally
    //   1713	1720	2453	finally
    //   1731	1745	2453	finally
    //   1756	1764	2453	finally
    //   1775	1790	2453	finally
    //   1801	1809	2453	finally
    //   1824	1834	2453	finally
    //   1845	1856	2453	finally
    //   1867	1877	2453	finally
    //   1888	1894	2453	finally
    //   1905	1909	2453	finally
    //   1920	1926	2453	finally
    //   1937	1947	2453	finally
    //   1958	1967	2453	finally
    //   1978	1985	2453	finally
    //   1996	2009	2453	finally
    //   2067	2073	2453	finally
    //   2087	2124	2453	finally
    //   2135	2176	2453	finally
    //   2189	2197	2453	finally
    //   2205	2212	2453	finally
    //   2216	2224	2453	finally
    //   2228	2267	2453	finally
    //   2271	2279	2453	finally
    //   2283	2296	2453	finally
    //   2367	2375	2453	finally
    //   2386	2398	2453	finally
    //   2409	2417	2453	finally
    //   2428	2434	2453	finally
    //   2445	2450	2453	finally
    //   2531	2546	2453	finally
    //   2557	2582	2453	finally
    //   2593	2604	2453	finally
    //   2615	2636	2453	finally
    //   2654	2664	2453	finally
    //   2675	2712	2453	finally
    //   2727	2734	2453	finally
    //   2745	2751	2453	finally
    //   2762	2772	2453	finally
    //   2783	2790	2453	finally
    //   2801	2808	2453	finally
    //   2873	2911	2453	finally
    //   2922	2935	2453	finally
    //   2993	3003	2453	finally
    //   3014	3027	2453	finally
    //   3050	3058	2453	finally
    //   3263	3269	2453	finally
    //   3281	3287	2453	finally
    //   3299	3305	2453	finally
    //   3468	3474	2453	finally
    //   3486	3492	2453	finally
    //   3504	3510	2453	finally
    //   4573	4579	2453	finally
    //   4590	4596	2453	finally
    //   4607	4613	2453	finally
    //   4624	4631	2453	finally
    //   4642	4655	2453	finally
    //   4786	4792	2453	finally
    //   4804	4810	2453	finally
    //   4822	4828	2453	finally
    //   4914	4920	2453	finally
    //   4932	4938	2453	finally
    //   4950	4956	2453	finally
    //   5080	5092	2453	finally
    //   5103	5111	2453	finally
    //   5122	5128	2453	finally
    //   5139	5149	2453	finally
    //   5209	5217	2453	finally
    //   5228	5241	2453	finally
    //   5299	5310	2453	finally
    //   5328	5338	2453	finally
    //   5351	5364	2453	finally
    //   5422	5428	2453	finally
    //   5439	5452	2453	finally
    //   5524	5535	2453	finally
    //   5546	5559	2453	finally
    //   5673	5684	2453	finally
    //   5702	5719	2453	finally
    //   5730	5737	2453	finally
    //   5748	5761	2453	finally
    //   5868	5879	2453	finally
    //   5918	5923	2453	finally
    //   5934	5941	2453	finally
    //   5952	5965	2453	finally
    //   6072	6081	2453	finally
    //   6092	6099	2453	finally
    //   6117	6122	2453	finally
    //   6182	6195	2453	finally
    //   6246	6251	2453	finally
    //   6255	6268	2453	finally
    //   6272	6279	2453	finally
    //   6283	6296	2453	finally
    //   3072	3081	3398	java/io/IOException
    //   3086	3108	3398	java/io/IOException
    //   3365	3395	3398	java/io/IOException
    //   3147	3152	4056	finally
    //   3861	3870	4056	finally
    //   3878	3914	4056	finally
    //   3922	3935	4056	finally
    //   3949	3959	4056	finally
    //   3967	3976	4056	finally
    //   3984	4029	4056	finally
    //   4037	4050	4056	finally
    //   4062	4089	4089	java/lang/Throwable
    //   3415	3431	5027	finally
    //   3431	3456	5027	finally
    //   4706	4774	5027	finally
    //   4877	4902	5027	finally
    //   5011	5024	5027	finally
    //   4062	4089	6454	finally
    //   3058	3067	6459	finally
    //   3072	3081	6473	finally
    //   3086	3108	6473	finally
    //   3365	3395	6473	finally
    //   3108	3139	6484	finally
    //   3172	3179	6492	finally
    //   3193	3202	6492	finally
    //   3216	3229	6492	finally
    //   3586	3599	6492	finally
    //   3618	3625	6492	finally
    //   3639	3649	6492	finally
    //   3667	3675	6492	finally
    //   3697	3702	6492	finally
    //   3722	3727	6492	finally
    //   3744	3751	6492	finally
    //   3770	3783	6492	finally
    //   3800	3810	6492	finally
    //   3824	3829	6492	finally
    //   4124	4134	6492	finally
    //   4148	4153	6492	finally
    //   4187	4224	6492	finally
    //   4238	4244	6492	finally
    //   4258	4274	6492	finally
    //   4288	4298	6492	finally
    //   4328	4338	6492	finally
    //   4352	4363	6492	finally
    //   4377	4387	6492	finally
    //   4401	4407	6492	finally
    //   4421	4425	6492	finally
    //   4439	4445	6492	finally
    //   4459	4469	6492	finally
    //   4483	4492	6492	finally
    //   4506	4519	6492	finally
    //   3058	3067	6504	java/io/IOException
    //   3108	3139	6516	java/io/IOException
    //   3172	3179	6544	java/io/IOException
    //   3193	3202	6544	java/io/IOException
    //   3216	3229	6544	java/io/IOException
    //   3586	3599	6544	java/io/IOException
    //   3618	3625	6544	java/io/IOException
    //   3639	3649	6544	java/io/IOException
    //   3667	3675	6544	java/io/IOException
    //   3697	3702	6544	java/io/IOException
    //   3722	3727	6544	java/io/IOException
    //   3744	3751	6544	java/io/IOException
    //   3770	3783	6544	java/io/IOException
    //   3800	3810	6544	java/io/IOException
    //   3824	3829	6544	java/io/IOException
    //   4124	4134	6544	java/io/IOException
    //   4148	4153	6544	java/io/IOException
    //   4187	4224	6544	java/io/IOException
    //   4238	4244	6544	java/io/IOException
    //   4258	4274	6544	java/io/IOException
    //   4288	4298	6544	java/io/IOException
    //   4328	4338	6544	java/io/IOException
    //   4352	4363	6544	java/io/IOException
    //   4377	4387	6544	java/io/IOException
    //   4401	4407	6544	java/io/IOException
    //   4421	4425	6544	java/io/IOException
    //   4439	4445	6544	java/io/IOException
    //   4459	4469	6544	java/io/IOException
    //   4483	4492	6544	java/io/IOException
    //   4506	4519	6544	java/io/IOException
    //   3147	3152	6595	java/io/IOException
    //   3861	3870	6595	java/io/IOException
    //   3878	3914	6595	java/io/IOException
    //   3922	3935	6595	java/io/IOException
    //   3949	3959	6595	java/io/IOException
    //   3967	3976	6595	java/io/IOException
    //   3984	4029	6595	java/io/IOException
    //   4037	4050	6595	java/io/IOException
  }
  
  public void c()
  {
    AppMethodBeat.i(139224);
    b();
    d(false);
    d(true);
    AppMethodBeat.o(139224);
  }
  
  public boolean d()
  {
    AppMethodBeat.i(139230);
    TbsLog.i("TbsDownload", "[TbsApkDownloader.isDownloadForeground] mIsDownloadForeground=" + this.C);
    boolean bool = this.C;
    AppMethodBeat.o(139230);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.smtt.sdk.ah
 * JD-Core Version:    0.7.0.1
 */