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
    AppMethodBeat.i(191425);
    if (!TPDownloadProxyFactory.canUseService())
    {
      AppMethodBeat.o(191425);
      return "";
    }
    if (offlineVinfoAdapter != null)
    {
      paramString1 = offlineVinfoAdapter.checkVideoStatus(paramString1, paramString2);
      AppMethodBeat.o(191425);
      return paramString1;
    }
    paramString1 = TPProxyAdapterManager.getInstance().checkVideoStatus(paramString1, paramString2);
    AppMethodBeat.o(191425);
    return paramString1;
  }
  
  public static Context getContext()
  {
    return applicationContext;
  }
  
  public static String getHLSOfflineExttag(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(191429);
    try
    {
      if (TPDownloadProxyNative.getInstance().isNativeLoaded())
      {
        paramString1 = TPDLProxyUtils.byteArrayToString(TPDownloadProxyNative.getInstance().getHLSOfflineExttag(paramString1, paramString2, paramInt, paramLong));
        AppMethodBeat.o(191429);
        return paramString1;
      }
    }
    catch (Throwable paramString1)
    {
      TPDLProxyLog.e("TPDownloadProxyHelper", 0, "tpdlnative", "get exttag failed, error:" + paramString1.toString());
      AppMethodBeat.o(191429);
    }
    return "";
  }
  
  public static String getNativeLibVersion()
  {
    AppMethodBeat.i(191422);
    String str = TPDownloadProxyFactory.getNativeVersion();
    AppMethodBeat.o(191422);
    return str;
  }
  
  public static int getRecordDuration(String paramString1, String paramString2)
  {
    AppMethodBeat.i(191426);
    if (offlineVinfoAdapter != null)
    {
      i = offlineVinfoAdapter.getRecordDuration(paramString1, paramString2);
      AppMethodBeat.o(191426);
      return i;
    }
    int i = TPProxyAdapterManager.getInstance().getRecordDuration(paramString1, paramString2);
    AppMethodBeat.o(191426);
    return i;
  }
  
  public static boolean isReadyForDownload()
  {
    AppMethodBeat.i(191424);
    boolean bool = TPDownloadProxyFactory.isReadyForDownload();
    AppMethodBeat.o(191424);
    return bool;
  }
  
  public static boolean isReadyForPlay()
  {
    AppMethodBeat.i(191423);
    boolean bool = TPDownloadProxyFactory.isReadyForPlay();
    AppMethodBeat.o(191423);
    return bool;
  }
  
  public static void setContext(Context paramContext)
  {
    applicationContext = paramContext;
  }
  
  public static void setNativeLibLoader(ITPDLProxyNativeLibLoader paramITPDLProxyNativeLibLoader)
  {
    AppMethodBeat.i(191421);
    TPDownloadProxyNative.getInstance().setLibLoader(paramITPDLProxyNativeLibLoader);
    AppMethodBeat.o(191421);
  }
  
  public static void setTPOfflineVinfoAdapter(ITPOfflineVinfoAdapter paramITPOfflineVinfoAdapter)
  {
    offlineVinfoAdapter = paramITPOfflineVinfoAdapter;
  }
  
  public static void setTPProxyAdapter(ITPProxyAdapter paramITPProxyAdapter)
  {
    AppMethodBeat.i(191427);
    TPProxyAdapterManager.getInstance().setProxyAdapter(paramITPProxyAdapter);
    AppMethodBeat.o(191427);
  }
  
  public static void setUseService(boolean paramBoolean)
  {
    AppMethodBeat.i(191420);
    TPDownloadProxyFactory.setUseService(paramBoolean);
    AppMethodBeat.o(191420);
  }
  
  public static void updateProxyMessage(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    AppMethodBeat.i(191428);
    TPProxyAdapterManager.getInstance().updateProxyMessage(paramInt, paramObject1, paramObject2, paramObject3, paramObject4);
    AppMethodBeat.o(191428);
  }
  
  public static long verifyOfflineCacheSync(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(191430);
    try
    {
      if (TPDownloadProxyNative.getInstance().isNativeLoaded())
      {
        long l = TPDownloadProxyNative.getInstance().verifyOfflineCacheSync(paramString1, paramInt, paramString2, paramString3);
        AppMethodBeat.o(191430);
        return l;
      }
    }
    catch (Throwable paramString1)
    {
      TPDLProxyLog.e("TPDownloadProxyHelper", 0, "tpdlnative", "verify offline cache failed, error:" + paramString1.toString());
      AppMethodBeat.o(191430);
    }
    return -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyHelper
 * JD-Core Version:    0.7.0.1
 */