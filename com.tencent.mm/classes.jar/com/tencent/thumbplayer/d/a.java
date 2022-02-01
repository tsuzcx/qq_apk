package com.tencent.thumbplayer.d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.config.TPPlayerCoreConfig;
import com.tencent.thumbplayer.utils.g;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  private static String ahGM = "";
  private static String ahGN;
  private static String ahGO;
  private static int ahGP = -1;
  private static String ahGQ;
  private static boolean ahGR;
  private static String ahGS = "";
  private static int ahGT = 0;
  private static String ahGU = "";
  private static boolean ahGV = true;
  private static int ahGW = -1;
  public static String ahGX = "";
  public static String ahGY = "";
  private static String ahGZ = "";
  private static String ahHa = "\\.";
  private static long ahHb = -1L;
  private static String appVersion = "";
  private static String appVersionName;
  
  public static void Ow(boolean paramBoolean)
  {
    ahGV = paramBoolean;
  }
  
  public static void Ox(boolean paramBoolean)
  {
    ahGR = paramBoolean;
  }
  
  public static void aHN(int paramInt)
  {
    ahGT = paramInt;
  }
  
  public static void bFZ(String paramString)
  {
    AppMethodBeat.i(226929);
    if (TextUtils.isEmpty(paramString))
    {
      g.w("TPPlayerConfig", "parseHostConfig, config is null.");
      AppMethodBeat.o(226929);
      return;
    }
    ahGZ = paramString;
    g.i("TPPlayerConfig", "parseHostConfig:".concat(String.valueOf(paramString)));
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("player_host_config"))
      {
        paramString = paramString.getJSONObject("player_host_config");
        if (paramString.has("beacon_policy_host")) {
          ahGX = paramString.getString("beacon_policy_host");
        }
        if (paramString.has("beacon_log_host")) {
          ahGY = paramString.getString("beacon_log_host");
        }
      }
      AppMethodBeat.o(226929);
      return;
    }
    finally
    {
      g.w("TPPlayerConfig", "parseHostConfig exception: " + paramString.toString());
      AppMethodBeat.o(226929);
    }
  }
  
  public static void bGa(String paramString)
  {
    ahGQ = paramString;
  }
  
  public static void bGb(String paramString)
  {
    ahGS = paramString;
  }
  
  public static void bGc(String paramString)
  {
    ahGU = paramString;
  }
  
  public static String getAppVersionName(Context paramContext)
  {
    AppMethodBeat.i(227011);
    if (!TextUtils.isEmpty(appVersionName))
    {
      paramContext = appVersionName;
      AppMethodBeat.o(227011);
      return paramContext;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(227011);
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
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(227011);
    }
    return "";
  }
  
  public static String getGuid()
  {
    return ahGM;
  }
  
  public static int getPlatform()
  {
    return ahGW;
  }
  
  public static boolean kag()
  {
    return ahGV;
  }
  
  public static String kah()
  {
    return ahGN;
  }
  
  public static String kai()
  {
    return ahGO;
  }
  
  public static String kaj()
  {
    AppMethodBeat.i(226960);
    Object localObject = new JSONObject();
    if (!TextUtils.isEmpty(ahGZ)) {}
    try
    {
      ((JSONObject)localObject).put("host_config", new JSONObject(ahGZ));
      localObject = ((JSONObject)localObject).toString();
      AppMethodBeat.o(226960);
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
  
  public static String kak()
  {
    return ahGQ;
  }
  
  public static String kal()
  {
    return ahGS;
  }
  
  public static int kam()
  {
    return ahGT;
  }
  
  public static String kan()
  {
    return ahGU;
  }
  
  public static boolean kao()
  {
    return ahGR;
  }
  
  public static int kap()
  {
    if ((ahGP == -1) && (ahGW != -1)) {
      return ahGW;
    }
    return ahGP;
  }
  
  public static long ot(Context paramContext)
  {
    AppMethodBeat.i(227017);
    long l;
    if (-1L != ahHb)
    {
      l = ahHb;
      AppMethodBeat.o(227017);
      return l;
    }
    try
    {
      l = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).getLongVersionCode();
      ahHb = l;
      AppMethodBeat.o(227017);
      return l;
    }
    finally
    {
      g.e("TPPlayerConfig", "getLongVersionCode less api 28");
      l = ahHb;
      AppMethodBeat.o(227017);
    }
    return l;
  }
  
  public static void setDebugEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(226932);
    g.setDebugEnable(paramBoolean);
    AppMethodBeat.o(226932);
  }
  
  public static void setGuid(String paramString)
  {
    ahGM = paramString;
  }
  
  public static void setPlatform(int paramInt)
  {
    ahGW = paramInt;
  }
  
  public static void setProxyServiceType(int paramInt)
  {
    ahGP = paramInt;
  }
  
  public static void setVideoMediaCodecStuckCheck(boolean paramBoolean)
  {
    AppMethodBeat.i(227021);
    TPPlayerCoreConfig.setVideoMediaCodecStuckCheck(paramBoolean);
    AppMethodBeat.o(227021);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.d.a
 * JD-Core Version:    0.7.0.1
 */