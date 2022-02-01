package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class i
{
  public static int ETt;
  public static int ETu;
  public static String ETv;
  public static boolean ETw;
  public static boolean ETx;
  public static boolean ETy;
  public static boolean ETz;
  public static int cJR;
  public static String cJS;
  public static int cJT;
  public static int cJX;
  
  static
  {
    AppMethodBeat.i(125212);
    cJT = 0;
    cJR = 0;
    ETt = 0;
    cJX = 0;
    cJS = Build.VERSION.SDK_INT;
    ETu = 0;
    ETv = "market://details?id=" + aj.getPackageName();
    ETw = false;
    ETx = true;
    ETy = false;
    ETz = false;
    AppMethodBeat.o(125212);
  }
  
  public static String au(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(125210);
    paramContext = c(paramContext, paramInt, ETw);
    AppMethodBeat.o(125210);
    return paramContext;
  }
  
  public static String c(Context paramContext, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(125211);
    int i = paramInt >> 8 & 0xFF;
    if (i == 0) {}
    String str2;
    for (String str1 = (paramInt >> 24 & 0xF) + "." + (paramInt >> 16 & 0xFF);; str1 = (paramInt >> 24 & 0xF) + "." + (paramInt >> 16 & 0xFF) + "." + i)
    {
      ad.d("MicroMsg.SDK.ChannelUtil", "minminor ".concat(String.valueOf(i)));
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
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.SDK.ChannelUtil", paramContext, "", new Object[0]);
          str2 = str1;
        }
        paramContext = str2.split("\\.");
        if ((paramContext != null) && (paramContext.length >= 4)) {
          break label275;
        }
        AppMethodBeat.o(125211);
        return str2;
        str1 = paramContext[0] + "." + paramContext[1];
        if (!paramContext[2].trim().equals("0")) {
          break label326;
        }
        AppMethodBeat.o(125211);
        return str1;
        paramContext = str1 + "." + paramContext[2];
        AppMethodBeat.o(125211);
      }
      if (!paramBoolean) {
        break;
      }
      paramContext = str2 + "_" + paramInt;
      ad.d("MicroMsg.SDK.ChannelUtil", "full version: ".concat(String.valueOf(paramContext)));
      AppMethodBeat.o(125211);
      return paramContext;
    }
    label275:
    label326:
    return paramContext;
  }
  
  public static boolean eFb()
  {
    return cJR == 1;
  }
  
  public static boolean eFc()
  {
    return cJR == 1001;
  }
  
  public static void ie(Context paramContext)
  {
    AppMethodBeat.i(125206);
    try
    {
      cJR = Integer.parseInt((String)w.aFr(bt.convertStreamToString(paramContext.getAssets().open("channel.ini"))).get("CHANNEL"));
      AppMethodBeat.o(125206);
      return;
    }
    catch (Exception paramContext)
    {
      ad.e("MicroMsg.SDK.ChannelUtil", "setup channel id from channel.ini failed");
      ad.printErrStackTrace("MicroMsg.SDK.ChannelUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(125206);
    }
  }
  
  public static void jdMethod_if(Context paramContext)
  {
    AppMethodBeat.i(125207);
    try
    {
      paramContext = w.aFr(bt.convertStreamToString(paramContext.getAssets().open("profile.ini")));
      String str = bt.nullAsNil((String)paramContext.get("PROFILE_DEVICE_TYPE"));
      cJS = str;
      if (str.length() <= 0) {
        cJS = Build.VERSION.SDK_INT;
      }
      cJT = parseInt((String)paramContext.get("UPDATE_MODE"));
      ETu = parseInt((String)paramContext.get("BUILD_REVISION"));
      ETy = parseBoolean((String)paramContext.get("GPRS_ALERT"));
      cJX = parseInt((String)paramContext.get("AUTO_ADD_ACOUNT"));
      ETz = parseBoolean((String)paramContext.get("NOKIA_AOL"));
      ad.w("MicroMsg.SDK.ChannelUtil", "profileDeviceType=" + cJS);
      ad.w("MicroMsg.SDK.ChannelUtil", "updateMode=" + cJT);
      ad.w("MicroMsg.SDK.ChannelUtil", "shouldShowGprsAlert=" + ETy);
      ad.w("MicroMsg.SDK.ChannelUtil", "autoAddAccount=" + cJX);
      ad.w("MicroMsg.SDK.ChannelUtil", "isNokiaol=" + ETz);
      paramContext = (String)paramContext.get("MARKET_URL");
      if ((paramContext != null) && (paramContext.trim().length() != 0) && (Uri.parse(paramContext) != null)) {
        ETv = paramContext;
      }
      ad.w("MicroMsg.SDK.ChannelUtil", "marketURL=" + ETv);
      AppMethodBeat.o(125207);
      return;
    }
    catch (Exception paramContext)
    {
      ad.e("MicroMsg.SDK.ChannelUtil", "setup profile from profile.ini failed");
      ad.printErrStackTrace("MicroMsg.SDK.ChannelUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(125207);
    }
  }
  
  private static boolean parseBoolean(String paramString)
  {
    AppMethodBeat.i(125209);
    try
    {
      boolean bool = Boolean.parseBoolean(paramString);
      AppMethodBeat.o(125209);
      return bool;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.SDK.ChannelUtil", paramString, "", new Object[0]);
      ad.w("MicroMsg.SDK.ChannelUtil", paramString.getMessage());
      AppMethodBeat.o(125209);
    }
    return false;
  }
  
  private static int parseInt(String paramString)
  {
    AppMethodBeat.i(125208);
    try
    {
      int i = Integer.parseInt(paramString);
      AppMethodBeat.o(125208);
      return i;
    }
    catch (Exception paramString)
    {
      ad.w("MicroMsg.SDK.ChannelUtil", paramString.getMessage());
      AppMethodBeat.o(125208);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.i
 * JD-Core Version:    0.7.0.1
 */