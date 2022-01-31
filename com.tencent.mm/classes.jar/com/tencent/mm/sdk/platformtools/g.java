package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class g
{
  public static int bWA;
  public static int bWu;
  public static String bWv;
  public static int bWw;
  public static int ymI;
  public static int ymJ;
  public static String ymK;
  public static boolean ymL;
  public static boolean ymM;
  public static boolean ymN;
  public static boolean ymO;
  
  static
  {
    AppMethodBeat.i(115177);
    bWw = 0;
    bWu = 0;
    ymI = 0;
    bWA = 0;
    bWv = Build.VERSION.SDK_INT;
    ymJ = 0;
    ymK = "market://details?id=" + ah.getPackageName();
    ymL = false;
    ymM = true;
    ymN = false;
    ymO = false;
    AppMethodBeat.o(115177);
  }
  
  public static String au(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(115175);
    paramContext = d(paramContext, paramInt, ymL);
    AppMethodBeat.o(115175);
    return paramContext;
  }
  
  public static String d(Context paramContext, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(115176);
    int i = paramInt >> 8 & 0xFF;
    if (i == 0) {}
    String str2;
    for (String str1 = (paramInt >> 24 & 0xF) + "." + (paramInt >> 16 & 0xFF);; str1 = (paramInt >> 24 & 0xF) + "." + (paramInt >> 16 & 0xFF) + "." + i)
    {
      ab.d("MicroMsg.SDK.ChannelUtil", "minminor ".concat(String.valueOf(i)));
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
          ab.printErrStackTrace("MicroMsg.SDK.ChannelUtil", paramContext, "", new Object[0]);
          str2 = str1;
        }
        paramContext = str2.split("\\.");
        if ((paramContext != null) && (paramContext.length >= 4)) {
          break label275;
        }
        AppMethodBeat.o(115176);
        return str2;
        str1 = paramContext[0] + "." + paramContext[1];
        if (!paramContext[2].trim().equals("0")) {
          break label326;
        }
        AppMethodBeat.o(115176);
        return str1;
        paramContext = str1 + "." + paramContext[2];
        AppMethodBeat.o(115176);
      }
      if (!paramBoolean) {
        break;
      }
      paramContext = str2 + "_" + paramInt;
      ab.d("MicroMsg.SDK.ChannelUtil", "full version: ".concat(String.valueOf(paramContext)));
      AppMethodBeat.o(115176);
      return paramContext;
    }
    label275:
    label326:
    return paramContext;
  }
  
  public static boolean dsn()
  {
    return bWu == 1;
  }
  
  public static boolean dso()
  {
    return bWu == 1001;
  }
  
  public static void gC(Context paramContext)
  {
    AppMethodBeat.i(115171);
    try
    {
      bWu = Integer.parseInt((String)u.apd(bo.convertStreamToString(paramContext.getAssets().open("channel.ini"))).get("CHANNEL"));
      AppMethodBeat.o(115171);
      return;
    }
    catch (Exception paramContext)
    {
      ab.e("MicroMsg.SDK.ChannelUtil", "setup channel id from channel.ini failed");
      ab.printErrStackTrace("MicroMsg.SDK.ChannelUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(115171);
    }
  }
  
  public static void gD(Context paramContext)
  {
    AppMethodBeat.i(115172);
    try
    {
      paramContext = u.apd(bo.convertStreamToString(paramContext.getAssets().open("profile.ini")));
      String str = bo.nullAsNil((String)paramContext.get("PROFILE_DEVICE_TYPE"));
      bWv = str;
      if (str.length() <= 0) {
        bWv = Build.VERSION.SDK_INT;
      }
      bWw = parseInt((String)paramContext.get("UPDATE_MODE"));
      ymJ = parseInt((String)paramContext.get("BUILD_REVISION"));
      ymN = parseBoolean((String)paramContext.get("GPRS_ALERT"));
      bWA = parseInt((String)paramContext.get("AUTO_ADD_ACOUNT"));
      ymO = parseBoolean((String)paramContext.get("NOKIA_AOL"));
      ab.w("MicroMsg.SDK.ChannelUtil", "profileDeviceType=" + bWv);
      ab.w("MicroMsg.SDK.ChannelUtil", "updateMode=" + bWw);
      ab.w("MicroMsg.SDK.ChannelUtil", "shouldShowGprsAlert=" + ymN);
      ab.w("MicroMsg.SDK.ChannelUtil", "autoAddAccount=" + bWA);
      ab.w("MicroMsg.SDK.ChannelUtil", "isNokiaol=" + ymO);
      paramContext = (String)paramContext.get("MARKET_URL");
      if ((paramContext != null) && (paramContext.trim().length() != 0) && (Uri.parse(paramContext) != null)) {
        ymK = paramContext;
      }
      ab.w("MicroMsg.SDK.ChannelUtil", "marketURL=" + ymK);
      AppMethodBeat.o(115172);
      return;
    }
    catch (Exception paramContext)
    {
      ab.e("MicroMsg.SDK.ChannelUtil", "setup profile from profile.ini failed");
      ab.printErrStackTrace("MicroMsg.SDK.ChannelUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(115172);
    }
  }
  
  private static boolean parseBoolean(String paramString)
  {
    AppMethodBeat.i(115174);
    try
    {
      boolean bool = Boolean.parseBoolean(paramString);
      AppMethodBeat.o(115174);
      return bool;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("MicroMsg.SDK.ChannelUtil", paramString, "", new Object[0]);
      ab.w("MicroMsg.SDK.ChannelUtil", paramString.getMessage());
      AppMethodBeat.o(115174);
    }
    return false;
  }
  
  private static int parseInt(String paramString)
  {
    AppMethodBeat.i(115173);
    try
    {
      int i = Integer.parseInt(paramString);
      AppMethodBeat.o(115173);
      return i;
    }
    catch (Exception paramString)
    {
      ab.w("MicroMsg.SDK.ChannelUtil", paramString.getMessage());
      AppMethodBeat.o(115173);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.g
 * JD-Core Version:    0.7.0.1
 */