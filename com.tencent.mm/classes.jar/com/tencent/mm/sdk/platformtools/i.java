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
  public static int GqG;
  public static int GqH;
  public static String GqI;
  public static boolean GqJ;
  public static boolean GqK;
  public static boolean GqL;
  public static boolean GqM;
  public static int cGY;
  public static String cGZ;
  public static int cHa;
  public static int cHe;
  
  static
  {
    AppMethodBeat.i(125212);
    cHa = 0;
    cGY = 0;
    GqG = 0;
    cHe = 0;
    cGZ = Build.VERSION.SDK_INT;
    GqH = 0;
    GqI = "market://details?id=" + ai.getPackageName();
    GqJ = false;
    GqK = true;
    GqL = false;
    GqM = false;
    AppMethodBeat.o(125212);
  }
  
  public static String aA(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(125210);
    paramContext = c(paramContext, paramInt, GqJ);
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
      ac.d("MicroMsg.SDK.ChannelUtil", "minminor ".concat(String.valueOf(i)));
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
          ac.printErrStackTrace("MicroMsg.SDK.ChannelUtil", paramContext, "", new Object[0]);
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
      ac.d("MicroMsg.SDK.ChannelUtil", "full version: ".concat(String.valueOf(paramContext)));
      AppMethodBeat.o(125211);
      return paramContext;
    }
    label275:
    label326:
    return paramContext;
  }
  
  public static boolean eUv()
  {
    return cGY == 1;
  }
  
  public static boolean eUw()
  {
    return cGY == 1001;
  }
  
  public static void ip(Context paramContext)
  {
    AppMethodBeat.i(125206);
    try
    {
      cGY = Integer.parseInt((String)v.aKI(bs.convertStreamToString(paramContext.getAssets().open("channel.ini"))).get("CHANNEL"));
      AppMethodBeat.o(125206);
      return;
    }
    catch (Exception paramContext)
    {
      ac.e("MicroMsg.SDK.ChannelUtil", "setup channel id from channel.ini failed");
      ac.printErrStackTrace("MicroMsg.SDK.ChannelUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(125206);
    }
  }
  
  public static void iq(Context paramContext)
  {
    AppMethodBeat.i(125207);
    try
    {
      paramContext = v.aKI(bs.convertStreamToString(paramContext.getAssets().open("profile.ini")));
      String str = bs.nullAsNil((String)paramContext.get("PROFILE_DEVICE_TYPE"));
      cGZ = str;
      if (str.length() <= 0) {
        cGZ = Build.VERSION.SDK_INT;
      }
      cHa = parseInt((String)paramContext.get("UPDATE_MODE"));
      GqH = parseInt((String)paramContext.get("BUILD_REVISION"));
      GqL = parseBoolean((String)paramContext.get("GPRS_ALERT"));
      cHe = parseInt((String)paramContext.get("AUTO_ADD_ACOUNT"));
      GqM = parseBoolean((String)paramContext.get("NOKIA_AOL"));
      ac.w("MicroMsg.SDK.ChannelUtil", "profileDeviceType=" + cGZ);
      ac.w("MicroMsg.SDK.ChannelUtil", "updateMode=" + cHa);
      ac.w("MicroMsg.SDK.ChannelUtil", "shouldShowGprsAlert=" + GqL);
      ac.w("MicroMsg.SDK.ChannelUtil", "autoAddAccount=" + cHe);
      ac.w("MicroMsg.SDK.ChannelUtil", "isNokiaol=" + GqM);
      paramContext = (String)paramContext.get("MARKET_URL");
      if ((paramContext != null) && (paramContext.trim().length() != 0) && (Uri.parse(paramContext) != null)) {
        GqI = paramContext;
      }
      ac.w("MicroMsg.SDK.ChannelUtil", "marketURL=" + GqI);
      AppMethodBeat.o(125207);
      return;
    }
    catch (Exception paramContext)
    {
      ac.e("MicroMsg.SDK.ChannelUtil", "setup profile from profile.ini failed");
      ac.printErrStackTrace("MicroMsg.SDK.ChannelUtil", paramContext, "", new Object[0]);
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
      ac.printErrStackTrace("MicroMsg.SDK.ChannelUtil", paramString, "", new Object[0]);
      ac.w("MicroMsg.SDK.ChannelUtil", paramString.getMessage());
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
      ac.w("MicroMsg.SDK.ChannelUtil", paramString.getMessage());
      AppMethodBeat.o(125208);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.i
 * JD-Core Version:    0.7.0.1
 */