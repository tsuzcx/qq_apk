package com.tencent.thumbplayer.d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.utils.g;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  private static String RYZ = "";
  private static String RZa;
  private static String RZb;
  private static int RZc = -1;
  private static String RZd;
  private static boolean RZe;
  private static String RZf = "";
  private static int RZg = 0;
  private static String RZh = "";
  private static boolean RZi = true;
  private static int RZj = -1;
  public static String RZk = "";
  public static String RZl = "";
  private static String RZm = "";
  private static String RZn = "\\.";
  private static long RZo = -1L;
  private static String appVersion = "";
  private static String appVersionName;
  
  public static void DT(boolean paramBoolean)
  {
    RZi = paramBoolean;
  }
  
  public static void DU(boolean paramBoolean)
  {
    RZe = paramBoolean;
  }
  
  public static void arn(int paramInt)
  {
    RZg = paramInt;
  }
  
  public static void bqA(String paramString)
  {
    RZf = paramString;
  }
  
  public static void bqB(String paramString)
  {
    RZh = paramString;
  }
  
  public static void bqy(String paramString)
  {
    AppMethodBeat.i(189143);
    if (TextUtils.isEmpty(paramString))
    {
      g.w("TPPlayerConfig", "parseHostConfig, config is null.");
      AppMethodBeat.o(189143);
      return;
    }
    RZm = paramString;
    g.i("TPPlayerConfig", "parseHostConfig:".concat(String.valueOf(paramString)));
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("player_host_config"))
      {
        paramString = paramString.getJSONObject("player_host_config");
        if (paramString.has("beacon_policy_host")) {
          RZk = paramString.getString("beacon_policy_host");
        }
        if (paramString.has("beacon_log_host")) {
          RZl = paramString.getString("beacon_log_host");
        }
      }
      AppMethodBeat.o(189143);
      return;
    }
    catch (Throwable paramString)
    {
      g.w("TPPlayerConfig", "parseHostConfig exception: " + paramString.toString());
      AppMethodBeat.o(189143);
    }
  }
  
  public static void bqz(String paramString)
  {
    RZd = paramString;
  }
  
  public static String getAppVersionName(Context paramContext)
  {
    AppMethodBeat.i(189146);
    if (!TextUtils.isEmpty(appVersionName))
    {
      paramContext = appVersionName;
      AppMethodBeat.o(189146);
      return paramContext;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(189146);
      return "";
    }
    try
    {
      String str = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      appVersionName = str;
      paramContext = str;
      if (str == null) {
        paramContext = "";
      }
      AppMethodBeat.o(189146);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(189146);
    }
    return "";
  }
  
  public static String getGuid()
  {
    return RYZ;
  }
  
  public static int getPlatform()
  {
    return RZj;
  }
  
  public static boolean hnj()
  {
    return RZi;
  }
  
  public static String hnk()
  {
    return RZa;
  }
  
  public static String hnl()
  {
    return RZb;
  }
  
  public static String hnm()
  {
    AppMethodBeat.i(189145);
    Object localObject = new JSONObject();
    if (!TextUtils.isEmpty(RZm)) {}
    try
    {
      ((JSONObject)localObject).put("host_config", new JSONObject(RZm));
      localObject = ((JSONObject)localObject).toString();
      AppMethodBeat.o(189145);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        g.e("TPPlayerConfig", localJSONException);
      }
    }
  }
  
  public static String hnn()
  {
    return RZd;
  }
  
  public static String hno()
  {
    return RZf;
  }
  
  public static int hnp()
  {
    return RZg;
  }
  
  public static String hnq()
  {
    return RZh;
  }
  
  public static boolean hnr()
  {
    return RZe;
  }
  
  public static int hns()
  {
    if ((RZc == -1) && (RZj != -1)) {
      return RZj;
    }
    return RZc;
  }
  
  public static long li(Context paramContext)
  {
    AppMethodBeat.i(189147);
    long l;
    if (-1L != RZo)
    {
      l = RZo;
      AppMethodBeat.o(189147);
      return l;
    }
    try
    {
      l = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).getLongVersionCode();
      RZo = l;
      AppMethodBeat.o(189147);
      return l;
    }
    catch (Throwable paramContext)
    {
      g.e("TPPlayerConfig", "getLongVersionCode less api 28");
      l = RZo;
      AppMethodBeat.o(189147);
    }
    return l;
  }
  
  public static void setDebugEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(189144);
    g.setDebugEnable(paramBoolean);
    AppMethodBeat.o(189144);
  }
  
  public static void setGuid(String paramString)
  {
    RYZ = paramString;
  }
  
  public static void setPlatform(int paramInt)
  {
    RZj = paramInt;
  }
  
  public static void setProxyServiceType(int paramInt)
  {
    RZc = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.d.a
 * JD-Core Version:    0.7.0.1
 */