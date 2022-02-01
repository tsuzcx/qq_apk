package com.tencent.qqvideo.proxy.httpproxy;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqvideo.proxy.api.IUtils;
import com.tencent.qqvideo.proxy.common.ConfigStorage;
import com.tencent.qqvideo.proxy.common.VcSystemInfo;
import org.json.JSONObject;

public class HttpproxyFacade
{
  private static String TAG = "TV_Httpproxy";
  private static final String dev_type = "2";
  private static Context mContext = null;
  private static HttpproxyFacade mInstance;
  private static boolean mbHttpProxyExist = false;
  private IUtils mUtils = null;
  
  static
  {
    mInstance = null;
  }
  
  public static void idKeyReport(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(89680);
    try
    {
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
      {
        HttpproxyFacade localHttpproxyFacade = instance();
        if (localHttpproxyFacade.mUtils != null)
        {
          new StringBuilder("idKeyReport:id=").append(paramString1).append(",key=").append(paramString2).append(",value=").append(paramString3);
          localHttpproxyFacade.mUtils.idKeyReport(paramString1, paramString2, paramString3);
          AppMethodBeat.o(89680);
          return;
        }
      }
    }
    catch (Throwable paramString1)
    {
      print(6, TAG, "idKeyReport exception");
      AppMethodBeat.o(89680);
    }
  }
  
  public static HttpproxyFacade instance()
  {
    try
    {
      AppMethodBeat.i(89676);
      if (mInstance == null) {
        mInstance = new HttpproxyFacade();
      }
      HttpproxyFacade localHttpproxyFacade = mInstance;
      AppMethodBeat.o(89676);
      return localHttpproxyFacade;
    }
    finally {}
  }
  
  public static boolean isLoadSuccess()
  {
    return mbHttpProxyExist;
  }
  
  /* Error */
  public static void javaUtilLog(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 90
    //   5: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 56	com/tencent/qqvideo/proxy/httpproxy/HttpproxyFacade:instance	()Lcom/tencent/qqvideo/proxy/httpproxy/HttpproxyFacade;
    //   11: astore_1
    //   12: aload_1
    //   13: getfield 35	com/tencent/qqvideo/proxy/httpproxy/HttpproxyFacade:mUtils	Lcom/tencent/qqvideo/proxy/api/IUtils;
    //   16: ifnull +26 -> 42
    //   19: aload_1
    //   20: getfield 35	com/tencent/qqvideo/proxy/httpproxy/HttpproxyFacade:mUtils	Lcom/tencent/qqvideo/proxy/api/IUtils;
    //   23: iconst_4
    //   24: getstatic 27	com/tencent/qqvideo/proxy/httpproxy/HttpproxyFacade:TAG	Ljava/lang/String;
    //   27: aload_0
    //   28: invokeinterface 92 4 0
    //   33: ldc 90
    //   35: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: ldc 2
    //   40: monitorexit
    //   41: return
    //   42: ldc 94
    //   44: aload_0
    //   45: invokestatic 100	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   48: invokevirtual 104	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   51: pop
    //   52: ldc 90
    //   54: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: goto -19 -> 38
    //   60: astore_0
    //   61: ldc 2
    //   63: monitorexit
    //   64: aload_0
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	paramString	String
    //   11	9	1	localHttpproxyFacade	HttpproxyFacade
    // Exception table:
    //   from	to	target	type
    //   3	38	60	finally
    //   42	57	60	finally
  }
  
  public static void jsonReport(String paramString)
  {
    AppMethodBeat.i(89679);
    for (;;)
    {
      String str1;
      try
      {
        str1 = VcSystemInfo.getDeviceID(mContext);
        String str2 = VcSystemInfo.getOsVersion();
        int i = VcSystemInfo.getNetWorkType(mContext);
        localObject = ((WifiManager)mContext.getSystemService("wifi")).getConnectionInfo();
        if (((WifiInfo)localObject).getBSSID() == null) {
          break label320;
        }
        localObject = String.valueOf(WifiManager.calculateSignalLevel(((WifiInfo)localObject).getRssi(), 5));
        String str3 = ConfigStorage.getHttpProxyVersion();
        String str4 = ConfigStorage.getConfigVersion();
        paramString = new JSONObject(paramString);
        paramString.put("dev_id", str1);
        paramString.put("dev_type", "2");
        paramString.put("os_ver", str2);
        paramString.put("net_type", i);
        paramString.put("net_stren", localObject);
        paramString.put("config_ver", str4);
        paramString.put("proxy_ver", str3);
        paramString = paramString.toString();
        "IUtils.MTA_Report:".concat(String.valueOf(paramString));
        str1 = paramString.replace(",", ";");
        if (!TextUtils.isEmpty(str1))
        {
          paramString = instance();
          if (paramString.mUtils == null) {
            break label303;
          }
          if (str1.length() <= 1000)
          {
            paramString.mUtils.httpproxyReport(new String[] { str1 });
            AppMethodBeat.o(89679);
            return;
          }
          int j = str1.length();
          i = j;
          if (j > 2000) {
            i = 2000;
          }
          localObject = str1.substring(0, 1000);
          str1 = str1.substring(1000, i);
          paramString.mUtils.httpproxyReport(new String[] { localObject, str1 });
          AppMethodBeat.o(89679);
        }
      }
      catch (Throwable paramString)
      {
        print(6, TAG, "reportMTA exception");
        AppMethodBeat.o(89679);
        return;
      }
      label303:
      "IUtils.MTA_Report:".concat(String.valueOf(str1));
      AppMethodBeat.o(89679);
      return;
      label320:
      Object localObject = "";
    }
  }
  
  public static void kvReport(String paramString)
  {
    AppMethodBeat.i(89681);
    try
    {
      String str1 = ConfigStorage.getHttpProxyVersionCode();
      String str2 = ConfigStorage.getConfigVersion();
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("DownloadResult");
      String str3 = ((JSONObject)localObject).optString("OptimalCDN");
      String str4 = ((JSONObject)localObject).optString("VideoRate");
      String str5 = ((JSONObject)localObject).optString("VideoTotalFileLength");
      String str6 = ((JSONObject)localObject).optString("VideoContentLength");
      String str7 = ((JSONObject)localObject).optString("DownloadTotalFlow");
      String str8 = ((JSONObject)localObject).optString("DownloadCostTime");
      String str9 = ((JSONObject)localObject).optString("DownloadAverageSpeed");
      String str10 = ((JSONObject)localObject).optString("DownloadMaxSpeed");
      localObject = ((JSONObject)localObject).optString("DownloadMinSpeed");
      HttpproxyFacade localHttpproxyFacade = instance();
      if (localHttpproxyFacade.mUtils != null)
      {
        localHttpproxyFacade.mUtils.kvReport(new String[] { paramString, str3, str1, str2, str4, str5, str6, str7, str8, str9, str10, localObject });
        AppMethodBeat.o(89681);
        return;
      }
    }
    catch (Throwable paramString)
    {
      print(6, TAG, "kvReport exception");
      AppMethodBeat.o(89681);
    }
  }
  
  public static void print(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(89678);
    HttpproxyFacade localHttpproxyFacade = instance();
    if (localHttpproxyFacade.mUtils != null)
    {
      localHttpproxyFacade.mUtils.javaUtilLog(paramInt, paramString1, paramString2);
      AppMethodBeat.o(89678);
      return;
    }
    "IUtils.javaUtilLog not init ".concat(String.valueOf(paramString2));
    AppMethodBeat.o(89678);
  }
  
  public static void setContext(Context paramContext)
  {
    mContext = paramContext;
  }
  
  public native String buildPlayURL(int paramInt);
  
  public native int cleanStorage();
  
  public native void deinit();
  
  public native int getCurrentOffset(int paramInt);
  
  public native int getLocalServerPort();
  
  public native int getTotalOffset(int paramInt);
  
  public native String getVersion();
  
  public native int init(String paramString1, String paramString2);
  
  public native int preLoad(int paramInt1, int paramInt2);
  
  public native void pushEvent(int paramInt);
  
  public native void setCookie(String paramString);
  
  public native int setMaxStorageSize(long paramLong);
  
  public native void setNetWorkState(int paramInt);
  
  public native void setPlayerState(int paramInt);
  
  public native void setRemainTime(int paramInt1, int paramInt2);
  
  public void setUtils(IUtils paramIUtils)
  {
    this.mUtils = paramIUtils;
  }
  
  public native int startPlay(String paramString1, int paramInt1, String paramString2, long paramLong, int paramInt2);
  
  public native void stopPlay(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqvideo.proxy.httpproxy.HttpproxyFacade
 * JD-Core Version:    0.7.0.1
 */