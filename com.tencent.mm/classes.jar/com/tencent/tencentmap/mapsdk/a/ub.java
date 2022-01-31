package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public final class ub
{
  private static int a = 160;
  private static final int b;
  private static final int c;
  
  static
  {
    Double.doubleToRawLongBits(0.0D);
    Double.doubleToRawLongBits(0.0D);
    b = Float.floatToRawIntBits(0.0F);
    c = Float.floatToRawIntBits(0.0F);
    Double.longBitsToDouble(4368491638549381120L);
    Double.longBitsToDouble(4503599627370496L);
  }
  
  public static int a(Object[] paramArrayOfObject)
  {
    return Arrays.hashCode(paramArrayOfObject);
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat)
  {
    if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
      return null;
    }
    int i = (int)(paramBitmap.getWidth() * paramFloat);
    int j = (int)(paramBitmap.getHeight() * paramFloat);
    try
    {
      paramBitmap = Bitmap.createScaledBitmap(paramBitmap, i, j, true);
      return paramBitmap;
    }
    catch (Exception paramBitmap) {}
    return null;
  }
  
  public static rx a(ry paramry)
  {
    return new rx((int)(paramry.b() * 1000000.0D), (int)(paramry.c() * 1000000.0D));
  }
  
  public static String a()
  {
    Object localObject2 = "";
    Context localContext = tn.a();
    Object localObject1;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject1 = localObject2;
      if (localContext != null)
      {
        localObject1 = localObject2;
        if (localContext.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) {}
      }
    }
    else
    {
      localObject1 = ((TelephonyManager)localContext.getSystemService("phone")).getDeviceId();
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = "noIMEI";
    }
    return a((String)localObject2);
  }
  
  public static String a(Context paramContext)
  {
    if (paramContext == null) {
      paramContext = "";
    }
    String str1;
    for (;;)
    {
      return paramContext;
      String str2 = "";
      str1 = str2;
      try
      {
        ApplicationInfo localApplicationInfo = paramContext.getPackageManager().getApplicationInfo(tn.a().getPackageName(), 128);
        str1 = str2;
        str2 = localApplicationInfo.metaData.getString("com.tencent.map.api_key");
        paramContext = str2;
        str1 = str2;
        if (TextUtils.isEmpty(str2))
        {
          str1 = str2;
          paramContext = localApplicationInfo.metaData.getString("TencentMapSDK");
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        new StringBuilder("error get mapkey:").append(paramContext.getMessage());
      }
    }
    return str1;
  }
  
  public static String a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return "";
    }
    paramString = paramString.replace("&", "").replace("#", "").replace("?", "");
    try
    {
      String str = URLEncoder.encode(paramString, "utf-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return paramString;
  }
  
  public static String a(String paramString, Object paramObject)
  {
    return paramString + "=" + String.valueOf(paramObject);
  }
  
  public static String a(String... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int k = paramVarArgs.length;
    int j = 0;
    int i = 0;
    while (j < k)
    {
      localStringBuilder.append(paramVarArgs[j]);
      if (i != paramVarArgs.length - 1) {
        localStringBuilder.append(",");
      }
      j += 1;
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static boolean a(float paramFloat1, float paramFloat2)
  {
    int j = Float.floatToRawIntBits(paramFloat1);
    int k = Float.floatToRawIntBits(0.0F);
    int i;
    if (((j ^ k) & 0x80000000) == 0) {
      if (Math.abs(j - k) <= 1) {
        i = 1;
      }
    }
    while ((i != 0) && (!Float.isNaN(paramFloat1)) && (!Float.isNaN(0.0F)))
    {
      return true;
      i = 0;
      continue;
      if (j < k)
      {
        i = k - b;
        j -= c;
      }
      for (;;)
      {
        if ((i > 1) || (j > 1 - i)) {
          break label111;
        }
        i = 1;
        break;
        i = j - b;
        j = k - c;
      }
      label111:
      i = 0;
    }
    return false;
  }
  
  public static boolean a(ry paramry, List<ry> paramList)
  {
    boolean bool;
    if ((paramList == null) || (paramList.size() < 3) || (paramry == null)) {
      bool = false;
    }
    int i;
    int k;
    int j;
    do
    {
      return bool;
      i = paramList.size();
      k = 0;
      j = i - 1;
      i = 0;
      bool = k;
    } while (i >= paramList.size());
    if (((((ry)paramList.get(i)).b() < paramry.b()) && (((ry)paramList.get(j)).b() >= paramry.b())) || ((((ry)paramList.get(j)).b() < paramry.b()) && (((ry)paramList.get(i)).b() >= paramry.b()) && ((((ry)paramList.get(i)).c() <= paramry.c()) || (((ry)paramList.get(j)).c() <= paramry.c())))) {
      if (((ry)paramList.get(i)).c() + (paramry.b() - ((ry)paramList.get(i)).b()) / (((ry)paramList.get(j)).b() - ((ry)paramList.get(i)).b()) * (((ry)paramList.get(j)).c() - ((ry)paramList.get(i)).c()) < paramry.c())
      {
        j = 1;
        label278:
        k ^= j;
      }
    }
    for (;;)
    {
      j = i;
      i += 1;
      break;
      j = 0;
      break label278;
    }
  }
  
  public static final boolean a(Collection<?> paramCollection)
  {
    return (paramCollection == null) || (paramCollection.size() <= 0);
  }
  
  public static int b(Context paramContext)
  {
    if (paramContext == null) {
      return a;
    }
    paramContext = paramContext.getResources().getDisplayMetrics();
    if (paramContext == null) {
      return a;
    }
    int i = paramContext.densityDpi;
    a = i;
    return i;
  }
  
  public static String c(Context paramContext)
  {
    if (paramContext == null) {
      return "unknown";
    }
    paramContext = paramContext.getResources().getDisplayMetrics();
    if (paramContext == null) {
      return "unknown";
    }
    return Integer.toString(paramContext.widthPixels) + "*" + Integer.toString(paramContext.heightPixels);
  }
  
  public static String d(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    PackageManager localPackageManager = paramContext.getPackageManager();
    Object localObject = null;
    try
    {
      paramContext = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 128);
      if (paramContext != null)
      {
        paramContext = paramContext.loadLabel(localPackageManager);
        try
        {
          paramContext = URLEncoder.encode(paramContext.toString(), "utf-8");
          return a(paramContext);
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            paramContext = "";
          }
        }
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = localObject;
        continue;
        paramContext = "can't find app name";
      }
    }
  }
  
  public static String e(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    String str1 = "";
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      String str2 = paramContext.versionName;
      int i = paramContext.versionCode;
      paramContext = str2 + Integer.toString(i);
      return a(paramContext);
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = str1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ub
 * JD-Core Version:    0.7.0.1
 */