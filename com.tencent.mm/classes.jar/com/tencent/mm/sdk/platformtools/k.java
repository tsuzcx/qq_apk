package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class k
{
  public static int IwF;
  public static int IwG;
  public static String IwH;
  public static boolean IwI;
  public static boolean IwJ;
  public static boolean IwK;
  public static boolean IwL;
  public static int cSM;
  public static String cSN;
  public static int cSO;
  public static int cSS;
  
  static
  {
    AppMethodBeat.i(125212);
    cSO = 0;
    cSM = 0;
    IwF = 0;
    cSS = 0;
    cSN = Build.VERSION.SDK_INT;
    IwG = 0;
    IwH = "market://details?id=" + ak.getPackageName();
    IwI = false;
    IwJ = true;
    IwK = false;
    IwL = false;
    AppMethodBeat.o(125212);
  }
  
  public static String aD(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(125210);
    paramContext = c(paramContext, paramInt, IwI);
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
      ae.d("MicroMsg.SDK.ChannelUtil", "minminor ".concat(String.valueOf(i)));
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
          ae.printErrStackTrace("MicroMsg.SDK.ChannelUtil", paramContext, "", new Object[0]);
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
      ae.d("MicroMsg.SDK.ChannelUtil", "full version: ".concat(String.valueOf(paramContext)));
      AppMethodBeat.o(125211);
      return paramContext;
    }
    label275:
    label326:
    return paramContext;
  }
  
  public static boolean fnT()
  {
    return cSM == 1;
  }
  
  public static boolean fnU()
  {
    return cSM == 1001;
  }
  
  public static void iE(Context paramContext)
  {
    AppMethodBeat.i(125206);
    try
    {
      cSM = Integer.parseInt((String)x.aRL(bu.convertStreamToString(paramContext.getAssets().open("channel.ini"))).get("CHANNEL"));
      AppMethodBeat.o(125206);
      return;
    }
    catch (Exception paramContext)
    {
      ae.e("MicroMsg.SDK.ChannelUtil", "setup channel id from channel.ini failed");
      ae.printErrStackTrace("MicroMsg.SDK.ChannelUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(125206);
    }
  }
  
  public static void iF(Context paramContext)
  {
    AppMethodBeat.i(125207);
    try
    {
      paramContext = x.aRL(bu.convertStreamToString(paramContext.getAssets().open("profile.ini")));
      String str = bu.nullAsNil((String)paramContext.get("PROFILE_DEVICE_TYPE"));
      cSN = str;
      if (str.length() <= 0) {
        cSN = Build.VERSION.SDK_INT;
      }
      cSO = parseInt((String)paramContext.get("UPDATE_MODE"));
      IwG = parseInt((String)paramContext.get("BUILD_REVISION"));
      IwK = parseBoolean((String)paramContext.get("GPRS_ALERT"));
      cSS = parseInt((String)paramContext.get("AUTO_ADD_ACOUNT"));
      IwL = parseBoolean((String)paramContext.get("NOKIA_AOL"));
      ae.w("MicroMsg.SDK.ChannelUtil", "profileDeviceType=" + cSN);
      ae.w("MicroMsg.SDK.ChannelUtil", "updateMode=" + cSO);
      ae.w("MicroMsg.SDK.ChannelUtil", "shouldShowGprsAlert=" + IwK);
      ae.w("MicroMsg.SDK.ChannelUtil", "autoAddAccount=" + cSS);
      ae.w("MicroMsg.SDK.ChannelUtil", "isNokiaol=" + IwL);
      paramContext = (String)paramContext.get("MARKET_URL");
      if ((paramContext != null) && (paramContext.trim().length() != 0) && (Uri.parse(paramContext) != null)) {
        IwH = paramContext;
      }
      ae.w("MicroMsg.SDK.ChannelUtil", "marketURL=" + IwH);
      AppMethodBeat.o(125207);
      return;
    }
    catch (Exception paramContext)
    {
      ae.e("MicroMsg.SDK.ChannelUtil", "setup profile from profile.ini failed");
      ae.printErrStackTrace("MicroMsg.SDK.ChannelUtil", paramContext, "", new Object[0]);
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
      ae.printErrStackTrace("MicroMsg.SDK.ChannelUtil", paramString, "", new Object[0]);
      ae.w("MicroMsg.SDK.ChannelUtil", paramString.getMessage());
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
      ae.w("MicroMsg.SDK.ChannelUtil", paramString.getMessage());
      AppMethodBeat.o(125208);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.k
 * JD-Core Version:    0.7.0.1
 */