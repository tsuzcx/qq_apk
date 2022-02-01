package com.tencent.smtt.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.c;
import com.tencent.smtt.sdk.c.a;
import java.security.MessageDigest;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

public class l
{
  private static SharedPreferences a;
  private static SharedPreferences.Editor b;
  
  private static String a()
  {
    AppMethodBeat.i(53926);
    try
    {
      int i = new Random().nextInt(2147483646);
      String str = new UUID((i + Build.BOARD.length() % 10 + Build.BRAND.length() % 10 + Build.DEVICE.length() % 10 + Build.HARDWARE.length() % 10 + Build.ID.length() % 10 + Build.MODEL.length() % 10 + Build.PRODUCT.length() % 10 + Build.SERIAL.length() % 10).hashCode(), Build.SERIAL.hashCode()).toString();
      AppMethodBeat.o(53926);
      return str;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(53926);
    }
    return "";
  }
  
  public static String a(Context paramContext)
  {
    AppMethodBeat.i(53920);
    if (!b(paramContext))
    {
      AppMethodBeat.o(53920);
      return "";
    }
    Object localObject = paramContext.getApplicationContext().getSharedPreferences("tsui", 0);
    a = (SharedPreferences)localObject;
    if (localObject != null)
    {
      localObject = a.getString("tsui", "");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        AppMethodBeat.o(53920);
        return localObject;
      }
    }
    localObject = new StringBuilder();
    String str2 = c();
    String str3 = b.j(paramContext);
    String str4 = b();
    String str5 = a().replace("-", "");
    if ((str2 != null) && (str2.length() > 0))
    {
      ((StringBuilder)localObject).append(str2);
      ((StringBuilder)localObject).append("|");
    }
    if ((str3 != null) && (str3.length() > 0))
    {
      ((StringBuilder)localObject).append(str3);
      ((StringBuilder)localObject).append("|");
    }
    if ((str4 != null) && (str4.length() > 0))
    {
      ((StringBuilder)localObject).append(str4);
      ((StringBuilder)localObject).append("|");
    }
    if ((str5 != null) && (str5.length() > 0)) {
      ((StringBuilder)localObject).append(str5);
    }
    new StringBuilder("sbSDKUID is ").append(localObject);
    if (((StringBuilder)localObject).length() > 0) {
      try
      {
        localObject = a(a(((StringBuilder)localObject).toString()));
        if ((localObject != null) && (((String)localObject).length() > 0))
        {
          a(paramContext, "tsui", (String)localObject);
          AppMethodBeat.o(53920);
          return localObject;
        }
      }
      catch (Exception localException)
      {
        new StringBuilder("stack is ").append(Log.getStackTraceString(localException));
      }
    }
    String str1 = UUID.randomUUID().toString().replace("-", "");
    a(paramContext, "tsui", str1);
    AppMethodBeat.o(53920);
    return str1;
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(201168);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() == 1) {
        localStringBuilder.append("0");
      }
      localStringBuilder.append(str);
      i += 1;
    }
    paramArrayOfByte = localStringBuilder.toString().toUpperCase(Locale.CHINA);
    AppMethodBeat.o(201168);
    return paramArrayOfByte;
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(201164);
    if (a == null) {
      a = paramContext.getApplicationContext().getSharedPreferences("tsui", 0);
    }
    paramContext = a.edit();
    b = paramContext;
    paramContext.putString(paramString1, paramString2);
    b.commit();
    AppMethodBeat.o(201164);
  }
  
  private static byte[] a(String paramString)
  {
    AppMethodBeat.i(201169);
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA1");
      localMessageDigest.reset();
      localMessageDigest.update(paramString.getBytes("UTF-8"));
      paramString = localMessageDigest.digest();
      AppMethodBeat.o(201169);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = "".getBytes();
      AppMethodBeat.o(201169);
    }
    return paramString;
  }
  
  private static String b()
  {
    AppMethodBeat.i(201173);
    try
    {
      String str = Build.SERIAL;
      if ((TextUtils.isEmpty(str)) || (str.contains("unknown")))
      {
        str = c();
        AppMethodBeat.o(201173);
        return str;
      }
      AppMethodBeat.o(201173);
      return str;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(201173);
    }
    return "unknown";
  }
  
  private static boolean b(Context paramContext)
  {
    boolean bool1 = true;
    AppMethodBeat.i(201177);
    try
    {
      boolean bool2 = paramContext.getSharedPreferences("sai", 0).getBoolean("sui", true);
      bool1 = bool2;
      TbsLog.i("SDKUID", "isSDKUIDEnable is ".concat(String.valueOf(bool2)));
      bool1 = bool2;
      c.a().a(paramContext, Integer.valueOf(1002), new c.a()
      {
        public final void a(String paramAnonymousString)
        {
          AppMethodBeat.i(200032);
          SharedPreferences.Editor localEditor = this.a.getSharedPreferences("sai", 0).edit();
          localEditor.putBoolean("sui", false);
          localEditor.commit();
          TbsLog.e("TBSEmergency", "Execute command [1002](" + paramAnonymousString + ")");
          AppMethodBeat.o(200032);
        }
      });
      bool1 = bool2;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        TbsLog.i("SDKUID", "stack is " + Log.getStackTraceString(paramContext));
      }
    }
    AppMethodBeat.o(201177);
    return bool1;
  }
  
  private static String c()
  {
    AppMethodBeat.i(201175);
    int i = new Random().nextInt(2147483646);
    String str = Build.FINGERPRINT + i;
    AppMethodBeat.o(201175);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.utils.l
 * JD-Core Version:    0.7.0.1
 */