package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class ChannelUtil
{
  public static final int AUTO_ADD_ACOUNT_BIND_MOBILE = 1;
  public static final int AUTO_ADD_ACOUNT_NOT_ADD = 0;
  public static final int AUTO_ADD_ACOUNT_NOT_BIND_MOBILE = 2;
  public static final int CHANNEL_ID_CROWDTEST = 1001;
  public static final int CHANNEL_ID_GP = 1;
  public static final int CHANNEL_ID_INVAILD = -1;
  public static final int CHANNEL_ID_OFFICIAL = 0;
  public static final int FLAG_NULL = 0;
  public static final int FLAG_UPDATE_EXTERNAL = 1;
  public static final int FLAG_UPDATE_NOTIP = 2;
  private static final String TAG = "MicroMsg.SDK.ChannelUtil";
  public static int autoAddAccount;
  public static int buildRev;
  public static int channelId;
  public static boolean fullVersionInfo;
  public static int historyChannelId;
  public static boolean isNokiaAol;
  public static boolean isShowingGprsAlert;
  public static String marketURL;
  public static String profileDeviceType;
  public static boolean shouldShowGprsAlert;
  public static int updateMode;
  
  static
  {
    AppMethodBeat.i(125212);
    updateMode = 0;
    channelId = 0;
    historyChannelId = 0;
    autoAddAccount = 0;
    profileDeviceType = Build.VERSION.SDK_INT;
    buildRev = 0;
    marketURL = "market://details?id=" + MMApplicationContext.getPackageName();
    fullVersionInfo = false;
    isShowingGprsAlert = true;
    shouldShowGprsAlert = false;
    isNokiaAol = false;
    AppMethodBeat.o(125212);
  }
  
  public static String formatVersion(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(125210);
    paramContext = formatVersion(paramContext, paramInt, fullVersionInfo);
    AppMethodBeat.o(125210);
    return paramContext;
  }
  
  public static String formatVersion(Context paramContext, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(125211);
    if (!Util.isNullOrNil(BuildInfo.OVERRIDE_VERSION_NAME))
    {
      paramContext = BuildInfo.OVERRIDE_VERSION_NAME;
      AppMethodBeat.o(125211);
      return paramContext;
    }
    paramContext = formatVersionImpl(paramContext, paramInt, paramBoolean);
    AppMethodBeat.o(125211);
    return paramContext;
  }
  
  private static String formatVersionImpl(Context paramContext, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(200838);
    int i = paramInt >> 8 & 0xFF;
    if (i == 0) {}
    String str2;
    for (String str1 = (paramInt >> 24 & 0xF) + "." + (paramInt >> 16 & 0xFF);; str1 = (paramInt >> 24 & 0xF) + "." + (paramInt >> 16 & 0xFF) + "." + i)
    {
      Log.d("MicroMsg.SDK.ChannelUtil", "minminor ".concat(String.valueOf(i)));
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
          Log.printErrStackTrace("MicroMsg.SDK.ChannelUtil", paramContext, "", new Object[0]);
          str2 = str1;
        }
        paramContext = str2.split("\\.");
        if ((paramContext != null) && (paramContext.length >= 4)) {
          break label275;
        }
        AppMethodBeat.o(200838);
        return str2;
        str1 = paramContext[0] + "." + paramContext[1];
        if (!paramContext[2].trim().equals("0")) {
          break label326;
        }
        AppMethodBeat.o(200838);
        return str1;
        paramContext = str1 + "." + paramContext[2];
        AppMethodBeat.o(200838);
      }
      if (!paramBoolean) {
        break;
      }
      paramContext = str2 + "_" + paramInt;
      Log.d("MicroMsg.SDK.ChannelUtil", "full version: ".concat(String.valueOf(paramContext)));
      AppMethodBeat.o(200838);
      return paramContext;
    }
    label275:
    label326:
    return paramContext;
  }
  
  public static boolean isCrowdTestVersion()
  {
    return channelId == 1001;
  }
  
  public static boolean isGPVersion()
  {
    AppMethodBeat.i(200839);
    if ((WeChatSomeFeatureSwitch.forceGooglePlayChannel()) || (channelId == 1))
    {
      AppMethodBeat.o(200839);
      return true;
    }
    AppMethodBeat.o(200839);
    return false;
  }
  
  public static void loadProfile(Context paramContext)
  {
    AppMethodBeat.i(125207);
    try
    {
      paramContext = IniParser.parse(Util.convertStreamToString(paramContext.getAssets().open("profile.ini")));
      String str = Util.nullAsNil((String)paramContext.get("PROFILE_DEVICE_TYPE"));
      profileDeviceType = str;
      if (str.length() <= 0) {
        profileDeviceType = Build.VERSION.SDK_INT;
      }
      updateMode = parseInt((String)paramContext.get("UPDATE_MODE"));
      buildRev = parseInt((String)paramContext.get("BUILD_REVISION"));
      shouldShowGprsAlert = parseBoolean((String)paramContext.get("GPRS_ALERT"));
      autoAddAccount = parseInt((String)paramContext.get("AUTO_ADD_ACOUNT"));
      isNokiaAol = parseBoolean((String)paramContext.get("NOKIA_AOL"));
      Log.w("MicroMsg.SDK.ChannelUtil", "profileDeviceType=" + profileDeviceType);
      Log.w("MicroMsg.SDK.ChannelUtil", "updateMode=" + updateMode);
      Log.w("MicroMsg.SDK.ChannelUtil", "shouldShowGprsAlert=" + shouldShowGprsAlert);
      Log.w("MicroMsg.SDK.ChannelUtil", "autoAddAccount=" + autoAddAccount);
      Log.w("MicroMsg.SDK.ChannelUtil", "isNokiaol=" + isNokiaAol);
      paramContext = (String)paramContext.get("MARKET_URL");
      if ((paramContext != null) && (paramContext.trim().length() != 0) && (Uri.parse(paramContext) != null)) {
        marketURL = paramContext;
      }
      Log.w("MicroMsg.SDK.ChannelUtil", "marketURL=" + marketURL);
      AppMethodBeat.o(125207);
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.SDK.ChannelUtil", "setup profile from profile.ini failed");
      Log.printErrStackTrace("MicroMsg.SDK.ChannelUtil", paramContext, "", new Object[0]);
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
      Log.printErrStackTrace("MicroMsg.SDK.ChannelUtil", paramString, "", new Object[0]);
      Log.w("MicroMsg.SDK.ChannelUtil", paramString.getMessage());
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
      Log.w("MicroMsg.SDK.ChannelUtil", paramString.getMessage());
      AppMethodBeat.o(125208);
    }
    return 0;
  }
  
  public static void setupChannelId(Context paramContext)
  {
    AppMethodBeat.i(125206);
    try
    {
      channelId = Integer.parseInt((String)IniParser.parse(Util.convertStreamToString(paramContext.getAssets().open("channel.ini"))).get("CHANNEL"));
      AppMethodBeat.o(125206);
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.SDK.ChannelUtil", "setup channel id from channel.ini failed");
      Log.printErrStackTrace("MicroMsg.SDK.ChannelUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(125206);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ChannelUtil
 * JD-Core Version:    0.7.0.1
 */