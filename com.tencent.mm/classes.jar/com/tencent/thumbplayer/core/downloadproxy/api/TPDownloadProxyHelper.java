package com.tencent.thumbplayer.core.downloadproxy.api;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils;

public class TPDownloadProxyHelper
{
  private static final String FILE_NAME = "TPDownloadProxyHelper";
  private static Context applicationContext;
  private static ITPOfflineVinfoAdapter offlineVinfoAdapter = null;
  
  public static String checkVideoStatus(String paramString1, String paramString2)
  {
    AppMethodBeat.i(255787);
    if (!TPDownloadProxyFactory.canUseService())
    {
      AppMethodBeat.o(255787);
      return "";
    }
    if (offlineVinfoAdapter != null)
    {
      paramString1 = offlineVinfoAdapter.checkVideoStatus(paramString1, paramString2);
      AppMethodBeat.o(255787);
      return paramString1;
    }
    AppMethodBeat.o(255787);
    return "";
  }
  
  public static Context getContext()
  {
    return applicationContext;
  }
  
  public static String getHLSOfflineExttag(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(255792);
    try
    {
      if (TPDownloadProxyNative.getInstance().isNativeLoaded())
      {
        paramString1 = TPDLProxyUtils.byteArrayToString(TPDownloadProxyNative.getInstance().getHLSOfflineExttag(paramString1, paramString2, paramInt, paramLong));
        AppMethodBeat.o(255792);
        return paramString1;
      }
    }
    catch (Throwable paramString1)
    {
      TPDLProxyLog.e("TPDownloadProxyHelper", 0, "tpdlnative", "get exttag failed, error:" + paramString1.toString());
      AppMethodBeat.o(255792);
    }
    return "";
  }
  
  public static String getNativeLibVersion()
  {
    AppMethodBeat.i(255781);
    String str = TPDownloadProxyFactory.getNativeVersion();
    AppMethodBeat.o(255781);
    return str;
  }
  
  public static int getRecordDuration(String paramString1, String paramString2)
  {
    AppMethodBeat.i(255789);
    if (offlineVinfoAdapter != null)
    {
      int i = offlineVinfoAdapter.getRecordDuration(paramString1, paramString2);
      AppMethodBeat.o(255789);
      return i;
    }
    AppMethodBeat.o(255789);
    return -1;
  }
  
  public static boolean isReadyForPlay()
  {
    AppMethodBeat.i(255783);
    boolean bool = TPDownloadProxyFactory.isReadyForPlay();
    AppMethodBeat.o(255783);
    return bool;
  }
  
  public static void setContext(Context paramContext)
  {
    applicationContext = paramContext;
  }
  
  public static void setNativeLibLoader(ITPDLProxyNativeLibLoader paramITPDLProxyNativeLibLoader)
  {
    AppMethodBeat.i(255780);
    TPDownloadProxyNative.getInstance().setLibLoader(paramITPDLProxyNativeLibLoader);
    AppMethodBeat.o(255780);
  }
  
  public static void setTPOfflineVinfoAdapter(ITPOfflineVinfoAdapter paramITPOfflineVinfoAdapter)
  {
    offlineVinfoAdapter = paramITPOfflineVinfoAdapter;
  }
  
  public static void setTPProxyAdapter(ITPProxyAdapter paramITPProxyAdapter) {}
  
  public static void setUseService(boolean paramBoolean)
  {
    AppMethodBeat.i(255779);
    TPDownloadProxyFactory.setUseService(paramBoolean);
    AppMethodBeat.o(255779);
  }
  
  public static void setUserData(String paramString, Object paramObject)
  {
    AppMethodBeat.i(255795);
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        TPDownloadProxyNative.getInstance().setUserData(paramString, paramObject.toString());
        AppMethodBeat.o(255795);
        return;
      }
      catch (Throwable paramString)
      {
        TPDLProxyLog.e("TPDownloadProxyHelper", 0, "tpdlnative", "setUserData failed, error:" + paramString.toString());
      }
    }
    AppMethodBeat.o(255795);
  }
  
  public static long verifyOfflineCacheSync(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(255793);
    try
    {
      if (TPDownloadProxyNative.getInstance().isNativeLoaded())
      {
        long l = TPDownloadProxyNative.getInstance().verifyOfflineCacheSync(paramString1, paramInt, paramString2, paramString3);
        AppMethodBeat.o(255793);
        return l;
      }
    }
    catch (Throwable paramString1)
    {
      TPDLProxyLog.e("TPDownloadProxyHelper", 0, "tpdlnative", "verify offline cache failed, error:" + paramString1.toString());
      AppMethodBeat.o(255793);
    }
    return -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyHelper
 * JD-Core Version:    0.7.0.1
 */