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
import com.tencent.mm.loader.i.b;
import com.tencent.mm.model.cn;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ConfigFile;
import com.tencent.mm.storage.at;
import com.tencent.threadpool.i;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Pattern;

public final class a
{
  static final HashMap<String, Integer> maY;
  
  static
  {
    HashMap localHashMap = new HashMap(16);
    maY = localHashMap;
    localHashMap.put("exception", Integer.valueOf(10001));
    maY.put("anr", Integer.valueOf(10002));
    maY.put("handler", Integer.valueOf(10003));
    maY.put("sql", Integer.valueOf(10004));
    maY.put("permission", Integer.valueOf(10005));
    maY.put("main_thread_watch", Integer.valueOf(10006));
  }
  
  private static int L(String paramString1, String paramString2, boolean paramBoolean)
  {
    String str2 = at.acHq + "crash/" + paramString1 + "." + paramString2 + ".crashini";
    long l1 = Util.nullAsNil(ConfigFile.getLongValue(str2, "count"));
    long l2 = Util.nullAsNil(ConfigFile.getLongValue(str2, "lasttime"));
    long l3 = Util.nowMilliSecond();
    if (paramBoolean) {}
    for (String str1 = at.acHq + "crash/" + paramString1 + "." + paramString2 + ".preventcrashlog";; str1 = at.acHq + "crash/" + paramString1 + "." + paramString2 + ".crashlog")
    {
      int i = d.btZ(str1);
      Log.d("MicroMsg.CrashUpload", "dkcrash count:" + l1 + " t:" + (l3 - l2) + " len:" + i);
      if (i < 5242880) {
        bE(paramString1, paramString2, str1);
      }
      d.deleteFile(str1);
      ConfigFile.saveValue(str2, "count", 0);
      ConfigFile.saveValue(str2, "lasttime", Util.nowMilliSecond());
      return 1;
    }
  }
  
  public static int a(String paramString1, String paramString2, ErrLog.Error paramError, String paramString3, boolean paramBoolean)
  {
    if ((paramError == null) || (Util.isNullOrNil(paramError.toString()))) {
      return -1;
    }
    Object localObject = new File(at.acHq + "crash/");
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdir();
    }
    localObject = at.acHq + "crash/" + paramString1 + "." + paramString2 + ".crashini";
    ConfigFile.saveValue((String)localObject, "count", Util.nullAsNil(ConfigFile.getLongValue((String)localObject, "count")) + 1L);
    if (Util.nullAsNil(ConfigFile.getLongValue((String)localObject, "lasttime")) == 0L) {
      ConfigFile.saveValue((String)localObject, "lasttime", Util.nowMilliSecond());
    }
    if (paramBoolean) {}
    for (localObject = at.acHq + "crash/" + paramString1 + "." + paramString2 + ".preventcrashlog";; localObject = at.acHq + "crash/" + paramString1 + "." + paramString2 + ".crashlog")
    {
      Log.d("MicroMsg.CrashUpload", "crash:[%s] len:[%d]", new Object[] { localObject, Integer.valueOf(paramError.toString().length()) });
      a(paramError);
      a((String)localObject, paramError);
      if (!Util.isNullOrNil(paramString3)) {
        d.deleteFile(paramString3);
      }
      return L(paramString1, paramString2, paramBoolean);
    }
  }
  
  private static void a(ErrLog.Error paramError)
  {
    if (!paramError.acmN) {
      return;
    }
    Object localObject = new File(b.bmB());
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
        if (Util.milliSecondsToNow(localSimpleDateFormat.lastModified()) > 604800000L)
        {
          Log.i("MicroMsg.CrashUpload", "dealWithSdcardCrash del old file: %s", new Object[] { localSimpleDateFormat.getPath() });
          localSimpleDateFormat.delete();
        }
        i += 1;
      }
    }
    localObject = new Date();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
    localObject = b.bmB() + "crash_" + localSimpleDateFormat.format((Date)localObject) + ".txt";
    Log.i("MicroMsg.CrashUpload", "dealWithSdcardCrash %s", new Object[] { localObject });
    a((String)localObject, paramError);
  }
  
  private static void a(String paramString, ErrLog.Error paramError)
  {
    int i;
    StringBuilder localStringBuilder;
    Object localObject;
    if (!new File(paramString).exists())
    {
      i = MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0).getInt("default_uin", 0);
      localStringBuilder = new StringBuilder();
      if (i != 0) {
        break label353;
      }
      localObject = q.eD(false);
      if (Util.isNullOrNil((String)localObject)) {
        break label279;
      }
      localStringBuilder.append("uin[" + (String)localObject + "] ");
    }
    for (;;)
    {
      localStringBuilder.append(Log.getSysInfo());
      localStringBuilder.append(" BRAND:[" + Build.BRAND + "] ");
      localObject = q.aPn();
      if (localObject != null)
      {
        if (localObject.length > 0) {
          localStringBuilder.append("c1[" + localObject[0] + "] ");
        }
        if (localObject.length > 1) {
          localStringBuilder.append("c2[" + localObject[1] + "] ");
        }
      }
      localStringBuilder.append("\n");
      d.J(paramString, localStringBuilder.toString().getBytes());
      if (d.btZ(paramString) > 10485760) {
        d.deleteFile(paramString);
      }
      d.J(paramString, (paramError.toString() + "\n").getBytes());
      return;
      label279:
      localObject = Build.DEVICE + Build.FINGERPRINT + Build.MANUFACTURER + q.aPo();
      localStringBuilder.append("uin[" + Integer.toString(((String)localObject).hashCode()) + "] ");
      continue;
      label353:
      localStringBuilder.append("uin[" + p.getString(i) + "] ");
    }
  }
  
  private static void bE(final String paramString1, final String paramString2, final String paramString3)
  {
    byte[] arrayOfByte = d.bua(paramString3);
    if (Util.isNullOrNil(arrayOfByte)) {
      return;
    }
    int i = arrayOfByte.length;
    paramString3 = g.getMessageDigest(String.format("weixin#$()%d%d", new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.Yxh), Integer.valueOf(i) }).getBytes()).toLowerCase();
    arrayOfByte = s.compress(arrayOfByte);
    final PByteArray localPByteArray = new PByteArray();
    c.a(localPByteArray, arrayOfByte, paramString3.getBytes());
    com.tencent.threadpool.h.ahAA.bm(new com.tencent.threadpool.i.h()
    {
      public final String getKey()
      {
        return "CrashUpload_upload";
      }
      
      public final void run()
      {
        Object localObject = MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0);
        localObject = "https://" + ((SharedPreferences)localObject).getString("support.weixin.qq.com", "support.weixin.qq.com");
        localObject = new StringBuilder().append((String)localObject).append("/cgi-bin/mmsupport-bin/stackreport?version=").append(Integer.toHexString(com.tencent.mm.protocal.d.Yxh)).append("&devicetype=").append(com.tencent.mm.protocal.d.nsC).append("&filelength=").append(this.TQR).append("&sum=").append(paramString3).append("&reporttype=1&NewReportType=").append(Util.nullAsNil((Integer)a.maY.get(paramString2)));
        if ((paramString1 != null) && (!paramString1.equals(""))) {
          ((StringBuilder)localObject).append("&username=").append(paramString1);
        }
        Log.d("MicroMsg.CrashUpload", "dkcrash sb:" + ((StringBuilder)localObject).toString());
        a.I(((StringBuilder)localObject).toString(), localPByteArray.value);
      }
    });
  }
  
  public static String bW(Intent paramIntent)
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
      return at.acHq + "crashprevent/" + paramIntent + "." + str1 + "." + cn.bDu() + ".crashlog";
    }
    catch (Exception paramIntent)
    {
      Log.printErrStackTrace("MicroMsg.CrashUpload", paramIntent, "", new Object[0]);
    }
    return "";
  }
  
  public static int iRZ()
  {
    int i = -1;
    Object localObject = new File(at.acHq + "crash/");
    int k;
    if (!((File)localObject).exists())
    {
      Log.w("MicroMsg.CrashUpload", "dkcrash checkUpload dir never create ?");
      k = i;
    }
    String[] arrayOfString;
    Pattern localPattern;
    int m;
    int j;
    do
    {
      do
      {
        do
        {
          return k;
          if (((File)localObject).isFile())
          {
            ((File)localObject).delete();
            Log.w("MicroMsg.CrashUpload", "dkcrash is the fucking file ??");
            return -1;
          }
          arrayOfString = ((File)localObject).list(new a.1());
          k = i;
        } while (arrayOfString == null);
        k = i;
      } while (arrayOfString.length == 0);
      localPattern = Pattern.compile(".");
      m = arrayOfString.length;
      j = 0;
      i = 1;
      k = i;
    } while (j >= m);
    String str1 = arrayOfString[j];
    localObject = localPattern.split(str1);
    String str2;
    if ((localObject != null) && (localObject.length > 0))
    {
      str2 = localObject[0];
      if (localObject.length >= 2)
      {
        localObject = localObject[1];
        label172:
        if (!str1.endsWith(".preventcrashlog")) {
          break label216;
        }
      }
    }
    label216:
    for (boolean bool = true;; bool = false)
    {
      if (L(str2, (String)localObject, bool) == 0) {
        i = 0;
      }
      for (;;)
      {
        j += 1;
        break;
        localObject = "";
        break label172;
      }
    }
  }
  
  public static int iSa()
  {
    Object localObject1 = new File(at.acHq + "crashprevent/");
    int k;
    if (!((File)localObject1).exists())
    {
      Log.w("MicroMsg.CrashUpload", "checkPreventUpload dir never create ?");
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
        Log.w("MicroMsg.CrashUpload", "checkPreventUpload:crash is the fucking file ??");
        return -1;
      }
      arrayOfString = ((File)localObject1).list(new a.2());
      if ((arrayOfString == null) || (arrayOfString.length == 0)) {
        return -1;
      }
      i = 1;
      m = arrayOfString.length;
      j = 0;
      k = i;
    } while (j >= m);
    localObject1 = arrayOfString[j];
    String str = at.acHq + "crashprevent/" + (String)localObject1;
    do
    {
      try
      {
        localObject1 = d.bua(str);
        if (Util.isNullOrNil((byte[])localObject1))
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
        Log.e("MicroMsg.CrashUpload", "checkPreventUpload crashPreventPath:%s Exception:%s %s", new Object[] { str, localException.getClass().getSimpleName(), localException.getMessage() });
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1185L, 51L, 1L, true);
        break;
      }
      Object localObject2 = ((ErrLog.PreventError)localObject1).processName;
      Log.i("MicroMsg.CrashSecondReport", "secondReportCrash() process:%s", new Object[] { localObject2 });
      if (Util.isEqual((String)localObject2, "mm")) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1185L, 21L, 1L, true);
      }
      for (;;)
      {
        Log.i("MicroMsg.CrashUpload", "checkPreventUpload processName:%s crashPreventPath:%s", new Object[] { ((ErrLog.PreventError)localObject1).processName, str });
        if (a(((ErrLog.PreventError)localObject1).username, ((ErrLog.PreventError)localObject1).tag, ((ErrLog.PreventError)localObject1).acmO, str, true) == 0)
        {
          i = 0;
          break;
          if (Util.isEqual((String)localObject2, "push")) {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1185L, 22L, 1L, true);
          } else if (Util.isEqual((String)localObject2, "other")) {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1185L, 23L, 1L, true);
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
  
  public static void q(Intent paramIntent, String paramString)
  {
    if ((paramIntent == null) || (Util.isNullOrNil(paramString))) {
      return;
    }
    Object localObject1 = new File(at.acHq + "crashprevent/");
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
      paramIntent = new ErrLog.Error((String)localObject2, (String)localObject1, Util.nowSecond(), str1, bool);
      localObject1 = new ErrLog.PreventError((String)localObject2, (String)localObject1, paramIntent, str2);
      localObject2 = Parcel.obtain();
      ((Parcel)localObject2).writeParcelable((Parcelable)localObject1, 0);
      d.J(paramString, ((Parcel)localObject2).marshall());
      Log.i("MicroMsg.CrashUpload", "crashPreventPath:[%s] len:[%d]", new Object[] { paramString, Integer.valueOf(paramIntent.toString().length()) });
      if (MMApplicationContext.isMainProcess())
      {
        Log.i("MicroMsg.CrashSecondReport", "reportWritePreventCrashFile() process:mm");
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1185L, 31L, 1L, true);
        return;
      }
    }
    catch (Exception paramIntent)
    {
      Log.printErrStackTrace("MicroMsg.CrashUpload", paramIntent, "", new Object[0]);
      return;
    }
    if (MMApplicationContext.isPushProcess())
    {
      Log.i("MicroMsg.CrashSecondReport", "reportWritePreventCrashFile() process:push");
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1185L, 32L, 1L, true);
      return;
    }
    Log.i("MicroMsg.CrashSecondReport", "reportWritePreventCrashFile() process:other");
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1185L, 33L, 1L, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sandbox.monitor.a
 * JD-Core Version:    0.7.0.1
 */