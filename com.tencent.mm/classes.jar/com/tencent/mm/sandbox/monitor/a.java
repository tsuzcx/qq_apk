package com.tencent.mm.sandbox.monitor;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import com.tencent.mm.a.c;
import com.tencent.mm.a.g;
import com.tencent.mm.a.p;
import com.tencent.mm.a.r;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sandbox.updater.AppUpdaterUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimerTask;
import java.util.regex.Pattern;

public final class a
{
  static final HashMap<String, Integer> euI;
  
  static
  {
    HashMap localHashMap = new HashMap(16);
    euI = localHashMap;
    localHashMap.put("exception", Integer.valueOf(10001));
    euI.put("anr", Integer.valueOf(10002));
    euI.put("handler", Integer.valueOf(10003));
    euI.put("sql", Integer.valueOf(10004));
    euI.put("permission", Integer.valueOf(10005));
    euI.put("main_thread_watch", Integer.valueOf(10006));
  }
  
  public static int a(String paramString1, String paramString2, b.a parama)
  {
    if (bo.isNullOrNil(parama.toString())) {
      return -1;
    }
    Object localObject = new File(ac.eQv + "crash/");
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdir();
    }
    localObject = ac.eQv + "crash/" + paramString1 + "." + paramString2 + ".crashini";
    com.tencent.mm.sdk.e.a.r((String)localObject, "count", bo.c(com.tencent.mm.sdk.e.a.ik((String)localObject, "count")) + 1L);
    if (bo.c(com.tencent.mm.sdk.e.a.ik((String)localObject, "lasttime")) == 0L) {
      com.tencent.mm.sdk.e.a.r((String)localObject, "lasttime", bo.aoy());
    }
    localObject = ac.eQv + "crash/" + paramString1 + "." + paramString2 + ".crashlog";
    ab.d("MicroMsg.CrashUpload", "crash:[%s] len:[%d]", new Object[] { localObject, Integer.valueOf(parama.toString().length()) });
    a(parama);
    a((String)localObject, parama);
    return ic(paramString1, paramString2);
  }
  
  private static void a(b.a parama)
  {
    if (!parama.yjX) {
      return;
    }
    Object localObject = new File(com.tencent.mm.compatible.util.e.eQA);
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
        if (bo.hl(localSimpleDateFormat.lastModified()) > 604800000L)
        {
          ab.i("MicroMsg.CrashUpload", "dealWithSdcardCrash del old file: %s", new Object[] { localSimpleDateFormat.getPath() });
          localSimpleDateFormat.delete();
        }
        i += 1;
      }
    }
    localObject = new Date();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
    localObject = com.tencent.mm.compatible.util.e.eQA + "crash_" + localSimpleDateFormat.format((Date)localObject) + ".txt";
    ab.i("MicroMsg.CrashUpload", "dealWithSdcardCrash %s", new Object[] { localObject });
    a((String)localObject, parama);
  }
  
  private static void a(String paramString, b.a parama)
  {
    int i;
    StringBuilder localStringBuilder;
    Object localObject;
    if (!new File(paramString).exists())
    {
      i = ah.getContext().getSharedPreferences("system_config_prefs", 0).getInt("default_uin", 0);
      localStringBuilder = new StringBuilder();
      if (i != 0) {
        break label335;
      }
      localObject = q.bP(false);
      if (bo.isNullOrNil((String)localObject)) {
        break label261;
      }
      localStringBuilder.append("uin[" + (String)localObject + "] ");
    }
    for (;;)
    {
      localStringBuilder.append(ab.getSysInfo());
      localStringBuilder.append(" BRAND:[" + Build.BRAND + "] ");
      localObject = q.LQ();
      localStringBuilder.append("c1[" + localObject[0] + "] ");
      localStringBuilder.append("c2[" + localObject[1] + "] ");
      localStringBuilder.append("\n");
      com.tencent.mm.a.e.e(paramString, localStringBuilder.toString().getBytes());
      if (com.tencent.mm.a.e.cM(paramString) > 10485760) {
        com.tencent.mm.a.e.deleteFile(paramString);
      }
      com.tencent.mm.a.e.e(paramString, (parama.toString() + "\n").getBytes());
      return;
      label261:
      localObject = Build.DEVICE + Build.FINGERPRINT + Build.MANUFACTURER + Build.MODEL;
      localStringBuilder.append("uin[" + Integer.toString(((String)localObject).hashCode()) + "] ");
      continue;
      label335:
      localStringBuilder.append("uin[" + p.getString(i) + "] ");
    }
  }
  
  private static void aC(String paramString1, String paramString2, String paramString3)
  {
    byte[] arrayOfByte = com.tencent.mm.a.e.j(paramString3, 0, -1);
    if (bo.ce(arrayOfByte)) {
      return;
    }
    int i = arrayOfByte.length;
    paramString3 = g.w(String.format("weixin#$()%d%d", new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.whH), Integer.valueOf(i) }).getBytes()).toLowerCase();
    arrayOfByte = r.compress(arrayOfByte);
    PByteArray localPByteArray = new PByteArray();
    c.a(localPByteArray, arrayOfByte, paramString3.getBytes());
    com.tencent.mm.sdk.g.d.post(new a.2(i, paramString3, paramString2, paramString1, localPByteArray), "CrashUpload_upload");
  }
  
  public static int drs()
  {
    Object localObject = new File(ac.eQv + "crash/");
    if (!((File)localObject).exists()) {
      ab.w("MicroMsg.CrashUpload", "dkcrash checkUpload dir never create ?");
    }
    String[] arrayOfString;
    do
    {
      return -1;
      if (((File)localObject).isFile())
      {
        ((File)localObject).delete();
        ab.w("MicroMsg.CrashUpload", "dkcrash is the fucking file ??");
        return -1;
      }
      arrayOfString = ((File)localObject).list(new a.1());
    } while ((arrayOfString == null) || (arrayOfString.length == 0));
    Pattern localPattern = Pattern.compile(".");
    int j = arrayOfString.length;
    int i = 0;
    if (i < j)
    {
      localObject = localPattern.split(arrayOfString[i]);
      String str;
      if ((localObject != null) && (localObject.length > 0))
      {
        str = localObject[0];
        if (localObject.length < 2) {
          break label153;
        }
      }
      label153:
      for (localObject = localObject[1];; localObject = "")
      {
        ic(str, (String)localObject);
        i += 1;
        break;
      }
    }
    return 1;
  }
  
  private static int ic(String paramString1, String paramString2)
  {
    String str1 = ac.eQv + "crash/" + paramString1 + "." + paramString2 + ".crashini";
    long l1 = bo.c(com.tencent.mm.sdk.e.a.ik(str1, "count"));
    long l2 = bo.c(com.tencent.mm.sdk.e.a.ik(str1, "lasttime"));
    long l3 = bo.aoy();
    String str2 = ac.eQv + "crash/" + paramString1 + "." + paramString2 + ".crashlog";
    int i = com.tencent.mm.a.e.cM(str2);
    ab.d("MicroMsg.CrashUpload", "dkcrash count:" + l1 + " t:" + (l3 - l2) + " len:" + i);
    if (i < 5242880) {
      aC(paramString1, paramString2, str2);
    }
    com.tencent.mm.a.e.deleteFile(str2);
    com.tencent.mm.sdk.e.a.il(str1, "count");
    com.tencent.mm.sdk.e.a.r(str1, "lasttime", bo.aoy());
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sandbox.monitor.a
 * JD-Core Version:    0.7.0.1
 */