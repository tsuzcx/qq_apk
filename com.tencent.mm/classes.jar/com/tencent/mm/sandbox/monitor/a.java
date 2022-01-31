package com.tencent.mm.sandbox.monitor;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import com.tencent.mm.a.c;
import com.tencent.mm.a.g;
import com.tencent.mm.a.o;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sandbox.updater.AppUpdaterUI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  static final HashMap<String, Integer> dBh;
  
  static
  {
    HashMap localHashMap = new HashMap(16);
    dBh = localHashMap;
    localHashMap.put("exception", Integer.valueOf(10001));
    dBh.put("anr", Integer.valueOf(10002));
    dBh.put("handler", Integer.valueOf(10003));
    dBh.put("sql", Integer.valueOf(10004));
    dBh.put("permission", Integer.valueOf(10005));
    dBh.put("main_thread_watch", Integer.valueOf(10006));
  }
  
  public static int a(String paramString1, String paramString2, b.a parama)
  {
    if (bk.bl(parama.toString())) {
      return -1;
    }
    Object localObject = new File(ac.dOP + "crash/");
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdir();
    }
    localObject = ac.dOP + "crash/" + paramString1 + "." + paramString2 + ".crashini";
    com.tencent.mm.sdk.e.a.i((String)localObject, "count", bk.c(com.tencent.mm.sdk.e.a.gj((String)localObject, "count")) + 1L);
    if (bk.c(com.tencent.mm.sdk.e.a.gj((String)localObject, "lasttime")) == 0L) {
      com.tencent.mm.sdk.e.a.i((String)localObject, "lasttime", bk.UY());
    }
    localObject = ac.dOP + "crash/" + paramString1 + "." + paramString2 + ".crashlog";
    y.d("MicroMsg.CrashUpload", "crash:[%s] len:[%d]", new Object[] { localObject, Integer.valueOf(parama.toString().length()) });
    a(parama);
    a((String)localObject, parama);
    return gb(paramString1, paramString2);
  }
  
  private static void a(b.a parama)
  {
    if (!parama.ubI) {
      return;
    }
    Object localObject = new File(com.tencent.mm.compatible.util.e.dOR);
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
        if (bk.co(localSimpleDateFormat.lastModified()) > 604800000L)
        {
          y.i("MicroMsg.CrashUpload", "dealWithSdcardCrash del old file: %s", new Object[] { localSimpleDateFormat.getPath() });
          localSimpleDateFormat.delete();
        }
        i += 1;
      }
    }
    localObject = new Date();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
    localObject = com.tencent.mm.compatible.util.e.dOR + "crash_" + localSimpleDateFormat.format((Date)localObject) + ".txt";
    y.i("MicroMsg.CrashUpload", "dealWithSdcardCrash %s", new Object[] { localObject });
    a((String)localObject, parama);
  }
  
  private static void a(String paramString, b.a parama)
  {
    int i;
    StringBuilder localStringBuilder;
    Object localObject;
    if (!new File(paramString).exists())
    {
      i = ae.getContext().getSharedPreferences("system_config_prefs", 0).getInt("default_uin", 0);
      localStringBuilder = new StringBuilder();
      if (i != 0) {
        break label323;
      }
      localObject = bk.fP(ae.getContext());
      if (bk.bl((String)localObject)) {
        break label251;
      }
      localStringBuilder.append("uin[" + (String)localObject + "] ");
    }
    for (;;)
    {
      localStringBuilder.append(y.getSysInfo());
      localStringBuilder.append(" BRAND:[" + Build.BRAND + "] ");
      localObject = com.tencent.mm.compatible.e.q.zm();
      localStringBuilder.append("c1[" + localObject[0] + "] ");
      localStringBuilder.append("c2[" + localObject[1] + "] ");
      localStringBuilder.append("\n");
      com.tencent.mm.a.e.e(paramString, localStringBuilder.toString().getBytes());
      if (com.tencent.mm.a.e.bJ(paramString) > 10485760) {
        com.tencent.mm.a.e.deleteFile(paramString);
      }
      com.tencent.mm.a.e.e(paramString, (parama.toString() + "\n").getBytes());
      return;
      label251:
      localObject = Build.DEVICE + Build.FINGERPRINT + Build.MANUFACTURER + Build.MODEL;
      localStringBuilder.append("uin[" + Integer.toString(((String)localObject).hashCode()) + "] ");
      continue;
      label323:
      localStringBuilder.append("uin[" + o.getString(i) + "] ");
    }
  }
  
  public static int cpE()
  {
    Object localObject = new File(ac.dOP + "crash/");
    if (!((File)localObject).exists()) {
      y.w("MicroMsg.CrashUpload", "dkcrash checkUpload dir never create ?");
    }
    String[] arrayOfString;
    do
    {
      return -1;
      if (((File)localObject).isFile())
      {
        ((File)localObject).delete();
        y.w("MicroMsg.CrashUpload", "dkcrash is the fucking file ??");
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
        gb(str, (String)localObject);
        i += 1;
        break;
      }
    }
    return 1;
  }
  
  private static int gb(String paramString1, String paramString2)
  {
    String str1 = ac.dOP + "crash/" + paramString1 + "." + paramString2 + ".crashini";
    long l1 = bk.c(com.tencent.mm.sdk.e.a.gj(str1, "count"));
    long l2 = bk.c(com.tencent.mm.sdk.e.a.gj(str1, "lasttime"));
    long l3 = bk.UY();
    String str2 = ac.dOP + "crash/" + paramString1 + "." + paramString2 + ".crashlog";
    int i = com.tencent.mm.a.e.bJ(str2);
    y.d("MicroMsg.CrashUpload", "dkcrash count:" + l1 + " t:" + (l3 - l2) + " len:" + i);
    if (i < 5242880)
    {
      byte[] arrayOfByte = com.tencent.mm.a.e.d(str2, 0, -1);
      if (!bk.bE(arrayOfByte))
      {
        i = arrayOfByte.length;
        String str3 = g.o(String.format("weixin#$()%d%d", new Object[] { Integer.valueOf(d.spa), Integer.valueOf(i) }).getBytes()).toLowerCase();
        arrayOfByte = com.tencent.mm.a.q.l(arrayOfByte);
        PByteArray localPByteArray = new PByteArray();
        c.a(localPByteArray, arrayOfByte, str3.getBytes());
        com.tencent.mm.sdk.f.e.post(new a.2(i, str3, paramString2, paramString1, localPByteArray), "CrashUpload_upload");
      }
    }
    com.tencent.mm.a.e.deleteFile(str2);
    new com.tencent.mm.sdk.e.a(str1).dq("count", 0);
    com.tencent.mm.sdk.e.a.i(str1, "lasttime", bk.UY());
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sandbox.monitor.a
 * JD-Core Version:    0.7.0.1
 */