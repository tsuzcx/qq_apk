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
    AppMethodBeat.i(228105);
    if (!TPDownloadProxyFactory.canUseService())
    {
      AppMethodBeat.o(228105);
      return "";
    }
    if (offlineVinfoAdapter != null)
    {
      paramString1 = offlineVinfoAdapter.checkVideoStatus(paramString1, paramString2);
      AppMethodBeat.o(228105);
      return paramString1;
    }
    AppMethodBeat.o(228105);
    return "";
  }
  
  public static Context getContext()
  {
    return applicationContext;
  }
  
  public static String getHLSOfflineExttag(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(228121);
    try
    {
      if (TPDownloadProxyNative.getInstance().isNativeLoaded())
      {
        paramString1 = TPDLProxyUtils.byteArrayToString(TPDownloadProxyNative.getInstance().getHLSOfflineExttag(paramString1, paramString2, paramInt, paramLong));
        AppMethodBeat.o(228121);
        return paramString1;
      }
    }
    finally
    {
      TPDLProxyLog.e("TPDownloadProxyHelper", 0, "tpdlnative", "get exttag failed, error:" + paramString1.toString());
      AppMethodBeat.o(228121);
    }
    return "";
  }
  
  public static String getNativeLibVersion()
  {
    AppMethodBeat.i(228088);
    String str = TPDownloadProxyFactory.getNativeVersion();
    AppMethodBeat.o(228088);
    return str;
  }
  
  public static int getRecordDuration(String paramString1, String paramString2)
  {
    AppMethodBeat.i(228113);
    if (offlineVinfoAdapter != null)
    {
      int i = offlineVinfoAdapter.getRecordDuration(paramString1, paramString2);
      AppMethodBeat.o(228113);
      return i;
    }
    AppMethodBeat.o(228113);
    return -1;
  }
  
  public static boolean isReadyForPlay()
  {
    AppMethodBeat.i(228095);
    boolean bool = TPDownloadProxyFactory.isReadyForPlay();
    AppMethodBeat.o(228095);
    return bool;
  }
  
  public static void setContext(Context paramContext)
  {
    applicationContext = paramContext;
  }
  
  public static void setNativeLibLoader(ITPDLProxyNativeLibLoader paramITPDLProxyNativeLibLoader)
  {
    AppMethodBeat.i(228077);
    TPDownloadProxyNative.getInstance().setLibLoader(paramITPDLProxyNativeLibLoader);
    AppMethodBeat.o(228077);
  }
  
  public static void setTPOfflineVinfoAdapter(ITPOfflineVinfoAdapter paramITPOfflineVinfoAdapter)
  {
    offlineVinfoAdapter = paramITPOfflineVinfoAdapter;
  }
  
  public static void setTPProxyAdapter(ITPProxyAdapter paramITPProxyAdapter) {}
  
  public static void setUseService(boolean paramBoolean)
  {
    AppMethodBeat.i(228070);
    TPDownloadProxyFactory.setUseService(paramBoolean);
    AppMethodBeat.o(228070);
  }
  
  public static void setUserData(String paramString, Object paramObject)
  {
    AppMethodBeat.i(228136);
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        TPDownloadProxyNative.getInstance().setUserData(paramString, paramObject.toString());
        AppMethodBeat.o(228136);
        return;
      }
      finally
      {
        TPDLProxyLog.e("TPDownloadProxyHelper", 0, "tpdlnative", "setUserData failed, error:" + paramString.toString());
      }
    }
    AppMethodBeat.o(228136);
  }
  
  public static long verifyOfflineCacheSync(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(228129);
    try
    {
      if (TPDownloadProxyNative.getInstance().isNativeLoaded())
      {
        long l = TPDownloadProxyNative.getInstance().verifyOfflineCacheSync(paramString1, paramInt, paramString2, paramString3);
        AppMethodBeat.o(228129);
        return l;
      }
    }
    finally
    {
      TPDLProxyLog.e("TPDownloadProxyHelper", 0, "tpdlnative", "verify offline cache failed, error:" + paramString1.toString());
      AppMethodBeat.o(228129);
    }
    return -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyHelper
 * JD-Core Version:    0.7.0.1
 */