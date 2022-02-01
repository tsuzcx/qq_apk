package com.tencent.thumbplayer.core.downloadproxy.api;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.downloadproxy.apiinner.TPProxyAdapterManager;
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
    AppMethodBeat.i(190065);
    if (!TPDownloadProxyFactory.canUseService())
    {
      AppMethodBeat.o(190065);
      return "";
    }
    if (offlineVinfoAdapter != null)
    {
      paramString1 = offlineVinfoAdapter.checkVideoStatus(paramString1, paramString2);
      AppMethodBeat.o(190065);
      return paramString1;
    }
    paramString1 = TPProxyAdapterManager.getInstance().checkVideoStatus(paramString1, paramString2);
    AppMethodBeat.o(190065);
    return paramString1;
  }
  
  public static Context getContext()
  {
    return applicationContext;
  }
  
  public static String getHLSOfflineExttag(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(190069);
    try
    {
      if (TPDownloadProxyNative.getInstance().isNativeLoaded())
      {
        paramString1 = TPDLProxyUtils.byteArrayToString(TPDownloadProxyNative.getInstance().getHLSOfflineExttag(paramString1, paramString2, paramInt, paramLong));
        AppMethodBeat.o(190069);
        return paramString1;
      }
    }
    catch (Throwable paramString1)
    {
      TPDLProxyLog.e("TPDownloadProxyHelper", 0, "tpdlnative", "get exttag failed, error:" + paramString1.toString());
      AppMethodBeat.o(190069);
    }
    return "";
  }
  
  public static String getNativeLibVersion()
  {
    AppMethodBeat.i(190062);
    String str = TPDownloadProxyFactory.getNativeVersion();
    AppMethodBeat.o(190062);
    return str;
  }
  
  public static int getRecordDuration(String paramString1, String paramString2)
  {
    AppMethodBeat.i(190066);
    if (offlineVinfoAdapter != null)
    {
      i = offlineVinfoAdapter.getRecordDuration(paramString1, paramString2);
      AppMethodBeat.o(190066);
      return i;
    }
    int i = TPProxyAdapterManager.getInstance().getRecordDuration(paramString1, paramString2);
    AppMethodBeat.o(190066);
    return i;
  }
  
  public static boolean isReadyForDownload()
  {
    AppMethodBeat.i(190064);
    boolean bool = TPDownloadProxyFactory.isReadyForDownload();
    AppMethodBeat.o(190064);
    return bool;
  }
  
  public static boolean isReadyForPlay()
  {
    AppMethodBeat.i(190063);
    boolean bool = TPDownloadProxyFactory.isReadyForPlay();
    AppMethodBeat.o(190063);
    return bool;
  }
  
  public static void setContext(Context paramContext)
  {
    applicationContext = paramContext;
  }
  
  public static void setNativeLibLoader(ITPDLProxyNativeLibLoader paramITPDLProxyNativeLibLoader)
  {
    AppMethodBeat.i(190061);
    TPDownloadProxyNative.getInstance().setLibLoader(paramITPDLProxyNativeLibLoader);
    AppMethodBeat.o(190061);
  }
  
  public static void setTPOfflineVinfoAdapter(ITPOfflineVinfoAdapter paramITPOfflineVinfoAdapter)
  {
    offlineVinfoAdapter = paramITPOfflineVinfoAdapter;
  }
  
  public static void setTPProxyAdapter(ITPProxyAdapter paramITPProxyAdapter)
  {
    AppMethodBeat.i(190067);
    TPProxyAdapterManager.getInstance().setProxyAdapter(paramITPProxyAdapter);
    AppMethodBeat.o(190067);
  }
  
  public static void setUseService(boolean paramBoolean)
  {
    AppMethodBeat.i(190060);
    TPDownloadProxyFactory.setUseService(paramBoolean);
    AppMethodBeat.o(190060);
  }
  
  public static void updateProxyMessage(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    AppMethodBeat.i(190068);
    TPProxyAdapterManager.getInstance().updateProxyMessage(paramInt, paramObject1, paramObject2, paramObject3, paramObject4);
    AppMethodBeat.o(190068);
  }
  
  public static long verifyOfflineCacheSync(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(190070);
    try
    {
      if (TPDownloadProxyNative.getInstance().isNativeLoaded())
      {
        long l = TPDownloadProxyNative.getInstance().verifyOfflineCacheSync(paramString1, paramInt, paramString2, paramString3);
        AppMethodBeat.o(190070);
        return l;
      }
    }
    catch (Throwable paramString1)
    {
      TPDLProxyLog.e("TPDownloadProxyHelper", 0, "tpdlnative", "verify offline cache failed, error:" + paramString1.toString());
      AppMethodBeat.o(190070);
    }
    return -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyHelper
 * JD-Core Version:    0.7.0.1
 */