package com.tencent.mm.sandbox.monitor;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mm.b.c;
import com.tencent.mm.b.g;
import com.tencent.mm.b.p;
import com.tencent.mm.b.s;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae;
import java.io.File;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Pattern;

public final class a
{
  static final HashMap<String, Integer> fIg;
  
  static
  {
    HashMap localHashMap = new HashMap(16);
    fIg = localHashMap;
    localHashMap.put("exception", Integer.valueOf(10001));
    fIg.put("anr", Integer.valueOf(10002));
    fIg.put("handler", Integer.valueOf(10003));
    fIg.put("sql", Integer.valueOf(10004));
    fIg.put("permission", Integer.valueOf(10005));
    fIg.put("main_thread_watch", Integer.valueOf(10006));
  }
  
  private static int B(String paramString1, String paramString2, boolean paramBoolean)
  {
    String str2 = ae.FfH + "crash/" + paramString1 + "." + paramString2 + ".crashini";
    long l1 = bt.f(com.tencent.mm.sdk.e.a.kV(str2, "count"));
    long l2 = bt.f(com.tencent.mm.sdk.e.a.kV(str2, "lasttime"));
    long l3 = bt.eGO();
    if (paramBoolean) {}
    for (String str1 = ae.FfH + "crash/" + paramString1 + "." + paramString2 + ".preventcrashlog";; str1 = ae.FfH + "crash/" + paramString1 + "." + paramString2 + ".crashlog")
    {
      int i = d.aEL(str1);
      ad.d("MicroMsg.CrashUpload", "dkcrash count:" + l1 + " t:" + (l3 - l2) + " len:" + i);
      if (i < 5242880) {
        aP(paramString1, paramString2, str1);
      }
      d.deleteFile(str1);
      com.tencent.mm.sdk.e.a.kW(str2, "count");
      com.tencent.mm.sdk.e.a.A(str2, "lasttime", bt.eGO());
      return 1;
    }
  }
  
  public static int a(String paramString1, String paramString2, ErrLog.Error paramError, String paramString3, boolean paramBoolean)
  {
    if ((paramError == null) || (bt.isNullOrNil(paramError.toString()))) {
      return -1;
    }
    Object localObject = new File(ae.FfH + "crash/");
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdir();
    }
    localObject = ae.FfH + "crash/" + paramString1 + "." + paramString2 + ".crashini";
    com.tencent.mm.sdk.e.a.A((String)localObject, "count", bt.f(com.tencent.mm.sdk.e.a.kV((String)localObject, "count")) + 1L);
    if (bt.f(com.tencent.mm.sdk.e.a.kV((String)localObject, "lasttime")) == 0L) {
      com.tencent.mm.sdk.e.a.A((String)localObject, "lasttime", bt.eGO());
    }
    if (paramBoolean) {}
    for (localObject = ae.FfH + "crash/" + paramString1 + "." + paramString2 + ".preventcrashlog";; localObject = ae.FfH + "crash/" + paramString1 + "." + paramString2 + ".crashlog")
    {
      ad.d("MicroMsg.CrashUpload", "crash:[%s] len:[%d]", new Object[] { localObject, Integer.valueOf(paramError.toString().length()) });
      a(paramError);
      a((String)localObject, paramError);
      if (!bt.isNullOrNil(paramString3)) {
        d.deleteFile(paramString3);
      }
      return B(paramString1, paramString2, paramBoolean);
    }
  }
  
  private static void a(ErrLog.Error paramError)
  {
    if (!paramError.ENy) {
      return;
    }
    Object localObject = new File(com.tencent.mm.loader.j.b.aii());
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = ((File)localObject).listFiles();
    if (localObject != null)
    {
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        localSimpleDateFormat = localObject[i];
        if (bt.vM(localSimpleDateFormat.lastModified()) > 604800000L)
        {
          ad.i("MicroMsg.CrashUpload", "dealWithSdcardCrash del old file: %s", new Object[] { localSimpleDateFormat.getPath() });
          localSimpleDateFormat.delete();
        }
        i += 1;
      }
    }
    localObject = new Date();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
    localObject = com.tencent.mm.loader.j.b.aii() + "crash_" + localSimpleDateFormat.format((Date)localObject) + ".txt";
    ad.i("MicroMsg.CrashUpload", "dealWithSdcardCrash %s", new Object[] { localObject });
    a((String)localObject, paramError);
  }
  
  private static void a(String paramString, ErrLog.Error paramError)
  {
    int i;
    StringBuilder localStringBuilder;
    Object localObject;
    if (!new File(paramString).exists())
    {
      i = aj.getContext().getSharedPreferences("system_config_prefs", 0).getInt("default_uin", 0);
      localStringBuilder = new StringBuilder();
      if (i != 0) {
        break label334;
      }
      localObject = q.cG(false);
      if (bt.isNullOrNil((String)localObject)) {
        break label260;
      }
      localStringBuilder.append("uin[" + (String)localObject + "] ");
    }
    for (;;)
    {
      localStringBuilder.append(ad.getSysInfo());
      localStringBuilder.append(" BRAND:[" + Build.BRAND + "] ");
      localObject = q.Xg();
      localStringBuilder.append("c1[" + localObject[0] + "] ");
      localStringBuilder.append("c2[" + localObject[1] + "] ");
      localStringBuilder.append("\n");
      d.z(paramString, localStringBuilder.toString().getBytes());
      if (d.aEL(paramString) > 10485760) {
        d.deleteFile(paramString);
      }
      d.z(paramString, (paramError.toString() + "\n").getBytes());
      return;
      label260:
      localObject = Build.DEVICE + Build.FINGERPRINT + Build.MANUFACTURER + Build.MODEL;
      localStringBuilder.append("uin[" + Integer.toString(((String)localObject).hashCode()) + "] ");
      continue;
      label334:
      localStringBuilder.append("uin[" + p.getString(i) + "] ");
    }
  }
  
  private static void aP(final String paramString1, final String paramString2, final String paramString3)
  {
    byte[] arrayOfByte = d.aEM(paramString3);
    if (bt.cw(arrayOfByte)) {
      return;
    }
    int i = arrayOfByte.length;
    paramString3 = g.getMessageDigest(String.format("weixin#$()%d%d", new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.CpK), Integer.valueOf(i) }).getBytes()).toLowerCase();
    arrayOfByte = s.compress(arrayOfByte);
    final PByteArray localPByteArray = new PByteArray();
    c.a(localPByteArray, arrayOfByte, paramString3.getBytes());
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        Object localObject = aj.getContext().getSharedPreferences("system_config_prefs", 0);
        localObject = "http://" + ((SharedPreferences)localObject).getString("support.weixin.qq.com", "support.weixin.qq.com");
        localObject = new StringBuilder().append((String)localObject).append("/cgi-bin/mmsupport-bin/stackreport?version=").append(Integer.toHexString(com.tencent.mm.protocal.d.CpK)).append("&devicetype=").append(com.tencent.mm.protocal.d.glX).append("&filelength=").append(this.yTM).append("&sum=").append(paramString3).append("&reporttype=1&NewReportType=").append(bt.l((Integer)a.fIg.get(paramString2)));
        if ((paramString1 != null) && (!paramString1.equals(""))) {
          ((StringBuilder)localObject).append("&username=").append(paramString1);
        }
        ad.d("MicroMsg.CrashUpload", "dkcrash sb:" + ((StringBuilder)localObject).toString());
        a.y(((StringBuilder)localObject).toString(), localPByteArray.value);
      }
    }, "CrashUpload_upload");
  }
  
  public static String ba(Intent paramIntent)
  {
    if (paramIntent == null) {
      return "";
    }
    try
    {
      String str2 = paramIntent.getStringExtra("tag");
      String str1 = str2;
      if (str2 == null) {
        str1 = "exception";
      }
      paramIntent = paramIntent.getStringExtra("userName");
      return ae.FfH + "crashprevent/" + paramIntent + "." + str1 + "." + ce.asQ() + ".crashlog";
    }
    catch (Exception paramIntent)
    {
      ad.printErrStackTrace("MicroMsg.CrashUpload", paramIntent, "", new Object[0]);
    }
    return "";
  }
  
  public static int eDu()
  {
    int k = 1;
    Object localObject = new File(ae.FfH + "crash/");
    int i;
    if (!((File)localObject).exists())
    {
      ad.w("MicroMsg.CrashUpload", "dkcrash checkUpload dir never create ?");
      i = -1;
    }
    String[] arrayOfString;
    Pattern localPattern;
    int m;
    int j;
    do
    {
      return i;
      if (((File)localObject).isFile())
      {
        ((File)localObject).delete();
        ad.w("MicroMsg.CrashUpload", "dkcrash is the fucking file ??");
        return -1;
      }
      arrayOfString = ((File)localObject).list(new FilenameFilter()
      {
        public final boolean accept(File paramAnonymousFile, String paramAnonymousString)
        {
          return (paramAnonymousString.endsWith(".crashlog")) || (paramAnonymousString.endsWith(".preventcrashlog"));
        }
      });
      if ((arrayOfString == null) || (arrayOfString.length == 0)) {
        return -1;
      }
      localPattern = Pattern.compile(".");
      m = arrayOfString.length;
      j = 0;
      i = k;
    } while (j >= m);
    String str1 = arrayOfString[j];
    localObject = localPattern.split(str1);
    String str2;
    if ((localObject != null) && (localObject.length > 0))
    {
      str2 = localObject[0];
      if (localObject.length < 2) {
        break label198;
      }
      localObject = localObject[1];
      label168:
      if (!str1.endsWith(".preventcrashlog")) {
        break label206;
      }
    }
    label198:
    label206:
    for (boolean bool = true;; bool = false)
    {
      B(str2, (String)localObject, bool);
      j += 1;
      break;
      localObject = "";
      break label168;
    }
  }
  
  public static int eDv()
  {
    Object localObject1 = new File(ae.FfH + "crashprevent/");
    int k;
    if (!((File)localObject1).exists())
    {
      ad.w("MicroMsg.CrashUpload", "checkPreventUpload dir never create ?");
      k = -1;
    }
    String[] arrayOfString;
    int i;
    int m;
    int j;
    do
    {
      return k;
      if (((File)localObject1).isFile())
      {
        ((File)localObject1).delete();
        ad.w("MicroMsg.CrashUpload", "checkPreventUpload:crash is the fucking file ??");
        return -1;
      }
      arrayOfString = ((File)localObject1).list(new FilenameFilter()
      {
        public final boolean accept(File paramAnonymousFile, String paramAnonymousString)
        {
          return paramAnonymousString.endsWith(".crashlog");
        }
      });
      if ((arrayOfString == null) || (arrayOfString.length == 0)) {
        return -1;
      }
      i = 1;
      m = arrayOfString.length;
      j = 0;
      k = i;
    } while (j >= m);
    localObject1 = arrayOfString[j];
    String str = ae.FfH + "crashprevent/" + (String)localObject1;
    do
    {
      try
      {
        localObject1 = d.aEM(str);
        if (bt.cw((byte[])localObject1))
        {
          localObject1 = null;
        }
        else
        {
          localObject2 = Parcel.obtain();
          ((Parcel)localObject2).unmarshall((byte[])localObject1, 0, localObject1.length);
          ((Parcel)localObject2).setDataPosition(0);
          localObject1 = (ErrLog.PreventError)((Parcel)localObject2).readParcelable(ErrLog.PreventError.class.getClassLoader());
        }
      }
      catch (Exception localException)
      {
        d.deleteFile(str);
        ad.e("MicroMsg.CrashUpload", "checkPreventUpload crashPreventPath:%s Exception:%s %s", new Object[] { str, localException.getClass().getSimpleName(), localException.getMessage() });
        h.vKh.idkeyStat(1185L, 51L, 1L, true);
        break;
      }
      Object localObject2 = ((ErrLog.PreventError)localObject1).processName;
      ad.i("MicroMsg.CrashSecondReport", "secondReportCrash() process:%s", new Object[] { localObject2 });
      if (bt.kU((String)localObject2, "mm")) {
        h.vKh.idkeyStat(1185L, 21L, 1L, true);
      }
      for (;;)
      {
        ad.i("MicroMsg.CrashUpload", "checkPreventUpload processName:%s crashPreventPath:%s", new Object[] { ((ErrLog.PreventError)localObject1).processName, str });
        if (a(((ErrLog.PreventError)localObject1).username, ((ErrLog.PreventError)localObject1).tag, ((ErrLog.PreventError)localObject1).ENz, str, true) == 0)
        {
          i = 0;
          break;
          if (bt.kU((String)localObject2, "push")) {
            h.vKh.idkeyStat(1185L, 22L, 1L, true);
          } else if (bt.kU((String)localObject2, "other")) {
            h.vKh.idkeyStat(1185L, 23L, 1L, true);
          }
        }
        else
        {
          break;
        }
      }
    } while (localException != null);
    for (;;)
    {
      j += 1;
      break;
    }
  }
  
  public static void o(Intent paramIntent, String paramString)
  {
    if ((paramIntent == null) || (bt.isNullOrNil(paramString))) {
      return;
    }
    Object localObject1 = new File(ae.FfH + "crashprevent/");
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdir();
    }
    try
    {
      Object localObject2 = paramIntent.getStringExtra("tag");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "exception";
      }
      String str1 = paramIntent.getStringExtra("exceptionMsg");
      localObject2 = paramIntent.getStringExtra("userName");
      boolean bool = paramIntent.getBooleanExtra("exceptionWriteSdcard", true);
      String str2 = paramIntent.getStringExtra("exceptionProcess");
      paramIntent = new ErrLog.Error((String)localObject2, (String)localObject1, bt.aGK(), str1, bool);
      localObject1 = new ErrLog.PreventError((String)localObject2, (String)localObject1, paramIntent, str2);
      localObject2 = Parcel.obtain();
      ((Parcel)localObject2).writeParcelable((Parcelable)localObject1, 0);
      d.z(paramString, ((Parcel)localObject2).marshall());
      ad.i("MicroMsg.CrashUpload", "crashPreventPath:[%s] len:[%d]", new Object[] { paramString, Integer.valueOf(paramIntent.toString().length()) });
      if (aj.cbe())
      {
        ad.i("MicroMsg.CrashSecondReport", "reportWritePreventCrashFile() process:mm");
        h.vKh.idkeyStat(1185L, 31L, 1L, true);
        return;
      }
    }
    catch (Exception paramIntent)
    {
      ad.printErrStackTrace("MicroMsg.CrashUpload", paramIntent, "", new Object[0]);
      return;
    }
    if (aj.eFH())
    {
      ad.i("MicroMsg.CrashSecondReport", "reportWritePreventCrashFile() process:push");
      h.vKh.idkeyStat(1185L, 32L, 1L, true);
      return;
    }
    ad.i("MicroMsg.CrashSecondReport", "reportWritePreventCrashFile() process:other");
    h.vKh.idkeyStat(1185L, 33L, 1L, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sandbox.monitor.a
 * JD-Core Version:    0.7.0.1
 */