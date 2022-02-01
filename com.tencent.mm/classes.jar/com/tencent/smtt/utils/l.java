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
    int i = new Random().nextInt(2147483646);
    String str = Build.FINGERPRINT + i;
    AppMethodBeat.o(53926);
    return str;
  }
  
  public static String a(Context paramContext)
  {
    AppMethodBeat.i(53920);
    if (!d(paramContext))
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
    String str2 = a();
    String str3 = b.k(paramContext);
    String str4 = c(paramContext);
    String str5 = b(paramContext).replace("-", "");
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
    AppMethodBeat.i(219334);
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
    AppMethodBeat.o(219334);
    return paramArrayOfByte;
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(219332);
    if (a == null) {
      a = paramContext.getApplicationContext().getSharedPreferences("tsui", 0);
    }
    paramContext = a.edit();
    b = paramContext;
    paramContext.putString(paramString1, paramString2);
    b.commit();
    AppMethodBeat.o(219332);
  }
  
  private static byte[] a(String paramString)
  {
    AppMethodBeat.i(219337);
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA1");
      localMessageDigest.reset();
      localMessageDigest.update(paramString.getBytes("UTF-8"));
      paramString = localMessageDigest.digest();
      AppMethodBeat.o(219337);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = "".getBytes();
      AppMethodBeat.o(219337);
    }
    return paramString;
  }
  
  private static String b(Context paramContext)
  {
    AppMethodBeat.i(219340);
    try
    {
      String str = r.d(paramContext);
      int i = new Random().nextInt(2147483646);
      paramContext = new UUID((i + Build.BOARD.length() % 10 + Build.BRAND.length() % 10 + Build.DEVICE.length() % 10 + Build.HARDWARE.length() % 10 + Build.ID.length() % 10 + str.length() % 10 + Build.PRODUCT.length() % 10 + c(paramContext).length() % 10).hashCode(), c(paramContext).hashCode()).toString();
      AppMethodBeat.o(219340);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(219340);
    }
    return "";
  }
  
  private static String c(Context paramContext)
  {
    AppMethodBeat.i(219345);
    try
    {
      paramContext = paramContext.getSharedPreferences("uifa", 0).getString("serial", "");
      if ((TextUtils.isEmpty(paramContext)) || (paramContext.contains("unknown")))
      {
        paramContext = a();
        AppMethodBeat.o(219345);
        return paramContext;
      }
      AppMethodBeat.o(219345);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(219345);
    }
    return "unknown";
  }
  
  private static boolean d(Context paramContext)
  {
    boolean bool1 = true;
    AppMethodBeat.i(53927);
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
          AppMethodBeat.i(219329);
          SharedPreferences.Editor localEditor = this.a.getSharedPreferences("sai", 0).edit();
          localEditor.putBoolean("sui", false);
          localEditor.commit();
          TbsLog.e("TBSEmergency", "Execute command [1002](" + paramAnonymousString + ")");
          AppMethodBeat.o(219329);
        }
      });
      bool1 = bool2;
    }
    finally
    {
      for (;;)
      {
        TbsLog.i("SDKUID", "stack is " + Log.getStackTraceString(paramContext));
      }
    }
    AppMethodBeat.o(53927);
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.utils.l
 * JD-Core Version:    0.7.0.1
 */