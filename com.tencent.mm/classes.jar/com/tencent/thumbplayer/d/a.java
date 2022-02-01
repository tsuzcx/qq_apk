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
  private static String ZBJ = "";
  private static String ZBK;
  private static String ZBL;
  private static int ZBM = -1;
  private static String ZBN;
  private static boolean ZBO;
  private static String ZBP = "";
  private static int ZBQ = 0;
  private static String ZBR = "";
  private static boolean ZBS = true;
  private static int ZBT = -1;
  public static String ZBU = "";
  public static String ZBV = "";
  private static String ZBW = "";
  private static String ZBX = "\\.";
  private static long ZBY = -1L;
  private static String appVersion = "";
  private static String appVersionName;
  
  public static void Iu(boolean paramBoolean)
  {
    ZBS = paramBoolean;
  }
  
  public static void Iv(boolean paramBoolean)
  {
    ZBO = paramBoolean;
  }
  
  public static void aBa(int paramInt)
  {
    ZBQ = paramInt;
  }
  
  public static void bDs(String paramString)
  {
    AppMethodBeat.i(220247);
    if (TextUtils.isEmpty(paramString))
    {
      g.w("TPPlayerConfig", "parseHostConfig, config is null.");
      AppMethodBeat.o(220247);
      return;
    }
    ZBW = paramString;
    g.i("TPPlayerConfig", "parseHostConfig:".concat(String.valueOf(paramString)));
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("player_host_config"))
      {
        paramString = paramString.getJSONObject("player_host_config");
        if (paramString.has("beacon_policy_host")) {
          ZBU = paramString.getString("beacon_policy_host");
        }
        if (paramString.has("beacon_log_host")) {
          ZBV = paramString.getString("beacon_log_host");
        }
      }
      AppMethodBeat.o(220247);
      return;
    }
    catch (Throwable paramString)
    {
      g.w("TPPlayerConfig", "parseHostConfig exception: " + paramString.toString());
      AppMethodBeat.o(220247);
    }
  }
  
  public static void bDt(String paramString)
  {
    ZBN = paramString;
  }
  
  public static void bDu(String paramString)
  {
    ZBP = paramString;
  }
  
  public static void bDv(String paramString)
  {
    ZBR = paramString;
  }
  
  public static String getAppVersionName(Context paramContext)
  {
    AppMethodBeat.i(220262);
    if (!TextUtils.isEmpty(appVersionName))
    {
      paramContext = appVersionName;
      AppMethodBeat.o(220262);
      return paramContext;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(220262);
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
      AppMethodBeat.o(220262);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(220262);
    }
    return "";
  }
  
  public static String getGuid()
  {
    return ZBJ;
  }
  
  public static int getPlatform()
  {
    return ZBT;
  }
  
  public static boolean iqK()
  {
    return ZBS;
  }
  
  public static String iqL()
  {
    return ZBK;
  }
  
  public static String iqM()
  {
    return ZBL;
  }
  
  public static String iqN()
  {
    AppMethodBeat.i(220254);
    Object localObject = new JSONObject();
    if (!TextUtils.isEmpty(ZBW)) {}
    try
    {
      ((JSONObject)localObject).put("host_config", new JSONObject(ZBW));
      localObject = ((JSONObject)localObject).toString();
      AppMethodBeat.o(220254);
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
  
  public static String iqO()
  {
    return ZBN;
  }
  
  public static String iqP()
  {
    return ZBP;
  }
  
  public static int iqQ()
  {
    return ZBQ;
  }
  
  public static String iqR()
  {
    return ZBR;
  }
  
  public static boolean iqS()
  {
    return ZBO;
  }
  
  public static int iqT()
  {
    if ((ZBM == -1) && (ZBT != -1)) {
      return ZBT;
    }
    return ZBM;
  }
  
  public static long mg(Context paramContext)
  {
    AppMethodBeat.i(220263);
    long l;
    if (-1L != ZBY)
    {
      l = ZBY;
      AppMethodBeat.o(220263);
      return l;
    }
    try
    {
      l = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).getLongVersionCode();
      ZBY = l;
      AppMethodBeat.o(220263);
      return l;
    }
    catch (Throwable paramContext)
    {
      g.e("TPPlayerConfig", "getLongVersionCode less api 28");
      l = ZBY;
      AppMethodBeat.o(220263);
    }
    return l;
  }
  
  public static void setDebugEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(220248);
    g.setDebugEnable(paramBoolean);
    AppMethodBeat.o(220248);
  }
  
  public static void setGuid(String paramString)
  {
    ZBJ = paramString;
  }
  
  public static void setPlatform(int paramInt)
  {
    ZBT = paramInt;
  }
  
  public static void setProxyServiceType(int paramInt)
  {
    ZBM = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.d.a
 * JD-Core Version:    0.7.0.1
 */