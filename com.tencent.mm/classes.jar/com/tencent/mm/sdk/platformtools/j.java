package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class j
{
  public static boolean IcA;
  public static int Icu;
  public static int Icv;
  public static String Icw;
  public static boolean Icx;
  public static boolean Icy;
  public static boolean Icz;
  public static int cSc;
  public static String cSd;
  public static int cSe;
  public static int cSi;
  
  static
  {
    AppMethodBeat.i(125212);
    cSe = 0;
    cSc = 0;
    Icu = 0;
    cSi = 0;
    cSd = Build.VERSION.SDK_INT;
    Icv = 0;
    Icw = "market://details?id=" + aj.getPackageName();
    Icx = false;
    Icy = true;
    Icz = false;
    IcA = false;
    AppMethodBeat.o(125212);
  }
  
  public static String aD(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(125210);
    paramContext = c(paramContext, paramInt, Icx);
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
  
  public static boolean fjZ()
  {
    return cSc == 1;
  }
  
  public static boolean fka()
  {
    return cSc == 1001;
  }
  
  public static void iA(Context paramContext)
  {
    AppMethodBeat.i(125207);
    try
    {
      paramContext = w.aQo(bt.convertStreamToString(paramContext.getAssets().open("profile.ini")));
      String str = bt.nullAsNil((String)paramContext.get("PROFILE_DEVICE_TYPE"));
      cSd = str;
      if (str.length() <= 0) {
        cSd = Build.VERSION.SDK_INT;
      }
      cSe = parseInt((String)paramContext.get("UPDATE_MODE"));
      Icv = parseInt((String)paramContext.get("BUILD_REVISION"));
      Icz = parseBoolean((String)paramContext.get("GPRS_ALERT"));
      cSi = parseInt((String)paramContext.get("AUTO_ADD_ACOUNT"));
      IcA = parseBoolean((String)paramContext.get("NOKIA_AOL"));
      ad.w("MicroMsg.SDK.ChannelUtil", "profileDeviceType=" + cSd);
      ad.w("MicroMsg.SDK.ChannelUtil", "updateMode=" + cSe);
      ad.w("MicroMsg.SDK.ChannelUtil", "shouldShowGprsAlert=" + Icz);
      ad.w("MicroMsg.SDK.ChannelUtil", "autoAddAccount=" + cSi);
      ad.w("MicroMsg.SDK.ChannelUtil", "isNokiaol=" + IcA);
      paramContext = (String)paramContext.get("MARKET_URL");
      if ((paramContext != null) && (paramContext.trim().length() != 0) && (Uri.parse(paramContext) != null)) {
        Icw = paramContext;
      }
      ad.w("MicroMsg.SDK.ChannelUtil", "marketURL=" + Icw);
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
  
  public static void iz(Context paramContext)
  {
    AppMethodBeat.i(125206);
    try
    {
      cSc = Integer.parseInt((String)w.aQo(bt.convertStreamToString(paramContext.getAssets().open("channel.ini"))).get("CHANNEL"));
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
 * Qualified Name:     com.tencent.mm.sdk.platformtools.j
 * JD-Core Version:    0.7.0.1
 */