package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Build.VERSION;
import java.util.Map;

public final class e
{
  public static int bvj;
  public static String bvk = Build.VERSION.SDK_INT;
  public static int bvl = 0;
  public static int bvp;
  public static int ueh;
  public static int uei = 0;
  public static String uej = "market://details?id=" + ae.getPackageName();
  public static boolean uek = false;
  public static boolean uel = true;
  public static boolean uem = false;
  public static boolean uen = false;
  
  static
  {
    bvj = 0;
    ueh = 0;
    bvp = 0;
  }
  
  public static String ag(Context paramContext, int paramInt)
  {
    return d(paramContext, paramInt, uek);
  }
  
  public static boolean cqq()
  {
    return bvj == 1;
  }
  
  public static boolean cqr()
  {
    return bvj == 1001;
  }
  
  public static String d(Context paramContext, int paramInt, boolean paramBoolean)
  {
    int i = paramInt >> 8 & 0xFF;
    if (i == 0) {}
    for (str1 = (paramInt >> 24 & 0xF) + "." + (paramInt >> 16 & 0xFF);; str1 = (paramInt >> 24 & 0xF) + "." + (paramInt >> 16 & 0xFF) + "." + i)
    {
      y.d("MicroMsg.SDK.ChannelUtil", "minminor " + i);
      i = 0xFFFFFFF & paramInt;
      str2 = str1;
      paramInt = i;
      if (paramContext != null) {
        paramInt = i;
      }
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 128);
        str2 = str1;
        paramInt = i;
        if (paramContext != null)
        {
          paramInt = i;
          i = paramContext.versionCode;
          paramInt = i;
          str2 = paramContext.versionName;
          paramInt = i;
        }
      }
      catch (Exception paramContext)
      {
        String[] arrayOfString;
        do
        {
          do
          {
            do
            {
              for (;;)
              {
                y.printErrStackTrace("MicroMsg.SDK.ChannelUtil", paramContext, "", new Object[0]);
                str2 = str1;
              }
              arrayOfString = str2.split("\\.");
              paramContext = str2;
            } while (arrayOfString == null);
            paramContext = str2;
          } while (arrayOfString.length < 4);
          str1 = arrayOfString[0] + "." + arrayOfString[1];
          paramContext = str1;
        } while (arrayOfString[2].trim().equals("0"));
        return str1 + "." + arrayOfString[2];
      }
      if (!paramBoolean) {
        break;
      }
      paramContext = str2 + "_" + paramInt;
      y.d("MicroMsg.SDK.ChannelUtil", "full version: " + paramContext);
      return paramContext;
    }
  }
  
  public static void fp(Context paramContext)
  {
    try
    {
      bvj = Integer.parseInt((String)r.Zf(bk.convertStreamToString(paramContext.getAssets().open("channel.ini"))).get("CHANNEL"));
      return;
    }
    catch (Exception paramContext)
    {
      y.e("MicroMsg.SDK.ChannelUtil", "setup channel id from channel.ini failed");
      y.printErrStackTrace("MicroMsg.SDK.ChannelUtil", paramContext, "", new Object[0]);
    }
  }
  
  public static void fq(Context paramContext)
  {
    try
    {
      paramContext = r.Zf(bk.convertStreamToString(paramContext.getAssets().open("profile.ini")));
      String str = bk.pm((String)paramContext.get("PROFILE_DEVICE_TYPE"));
      bvk = str;
      if (str.length() <= 0) {
        bvk = Build.VERSION.SDK_INT;
      }
      bvl = parseInt((String)paramContext.get("UPDATE_MODE"));
      uei = parseInt((String)paramContext.get("BUILD_REVISION"));
      uem = parseBoolean((String)paramContext.get("GPRS_ALERT"));
      bvp = parseInt((String)paramContext.get("AUTO_ADD_ACOUNT"));
      uen = parseBoolean((String)paramContext.get("NOKIA_AOL"));
      y.w("MicroMsg.SDK.ChannelUtil", "profileDeviceType=" + bvk);
      y.w("MicroMsg.SDK.ChannelUtil", "updateMode=" + bvl);
      y.w("MicroMsg.SDK.ChannelUtil", "shouldShowGprsAlert=" + uem);
      y.w("MicroMsg.SDK.ChannelUtil", "autoAddAccount=" + bvp);
      y.w("MicroMsg.SDK.ChannelUtil", "isNokiaol=" + uen);
      paramContext = (String)paramContext.get("MARKET_URL");
      if ((paramContext != null) && (paramContext.trim().length() != 0) && (Uri.parse(paramContext) != null)) {
        uej = paramContext;
      }
      y.w("MicroMsg.SDK.ChannelUtil", "marketURL=" + uej);
      return;
    }
    catch (Exception paramContext)
    {
      y.e("MicroMsg.SDK.ChannelUtil", "setup profile from profile.ini failed");
      y.printErrStackTrace("MicroMsg.SDK.ChannelUtil", paramContext, "", new Object[0]);
    }
  }
  
  private static boolean parseBoolean(String paramString)
  {
    try
    {
      boolean bool = Boolean.parseBoolean(paramString);
      return bool;
    }
    catch (Exception paramString)
    {
      y.printErrStackTrace("MicroMsg.SDK.ChannelUtil", paramString, "", new Object[0]);
      y.w("MicroMsg.SDK.ChannelUtil", paramString.getMessage());
    }
    return false;
  }
  
  private static int parseInt(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString)
    {
      y.w("MicroMsg.SDK.ChannelUtil", paramString.getMessage());
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.e
 * JD-Core Version:    0.7.0.1
 */