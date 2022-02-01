package com.tencent.thumbplayer.core.downloadproxy.jni;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyNativeLibLoader;
import com.tencent.thumbplayer.core.downloadproxy.apiinner.TPListenerManager;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils;

public class TPDownloadProxyNative
{
  private static final String FILE_NAME = "TPDownloadProxyNative";
  private static Context appContext = null;
  private static boolean isLoadDownloadProxySucceed = false;
  private ITPDLProxyNativeLibLoader mLibLoader;
  
  public static TPDownloadProxyNative getInstance()
  {
    AppMethodBeat.i(191530);
    TPDownloadProxyNative localTPDownloadProxyNative = SingletonHolder.INSTANCE;
    AppMethodBeat.o(191530);
    return localTPDownloadProxyNative;
  }
  
  private static int nativeIntMessageCallback(int paramInt1, int paramInt2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    AppMethodBeat.i(191532);
    paramInt1 = TPListenerManager.getInstance().handleIntCallbackMessage(paramInt1, paramInt2, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5);
    AppMethodBeat.o(191532);
    return paramInt1;
  }
  
  private static void nativeLogCallback(int paramInt1, byte[] paramArrayOfByte1, int paramInt2, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    AppMethodBeat.i(191534);
    if (paramInt1 == 10)
    {
      TPDLProxyLog.e(TPDLProxyUtils.byteArrayToString(paramArrayOfByte1), paramInt2, TPDLProxyUtils.byteArrayToString(paramArrayOfByte2), TPDLProxyUtils.byteArrayToString(paramArrayOfByte3));
      AppMethodBeat.o(191534);
      return;
    }
    if (paramInt1 == 20)
    {
      TPDLProxyLog.w(TPDLProxyUtils.byteArrayToString(paramArrayOfByte1), paramInt2, TPDLProxyUtils.byteArrayToString(paramArrayOfByte2), TPDLProxyUtils.byteArrayToString(paramArrayOfByte3));
      AppMethodBeat.o(191534);
      return;
    }
    if ((paramInt1 != 40) && (paramInt1 == 50))
    {
      TPDLProxyLog.d(TPDLProxyUtils.byteArrayToString(paramArrayOfByte1), paramInt2, TPDLProxyUtils.byteArrayToString(paramArrayOfByte2), TPDLProxyUtils.byteArrayToString(paramArrayOfByte3));
      AppMethodBeat.o(191534);
      return;
    }
    TPDLProxyLog.i(TPDLProxyUtils.byteArrayToString(paramArrayOfByte1), paramInt2, TPDLProxyUtils.byteArrayToString(paramArrayOfByte2), TPDLProxyUtils.byteArrayToString(paramArrayOfByte3));
    AppMethodBeat.o(191534);
  }
  
  private static void nativeMessageCallback(int paramInt1, int paramInt2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    AppMethodBeat.i(191531);
    TPListenerManager.getInstance().handleCallbackMessage(paramInt1, paramInt2, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5);
    AppMethodBeat.o(191531);
  }
  
  private static String nativeStringMessageCallback(int paramInt1, int paramInt2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    AppMethodBeat.i(191533);
    paramObject1 = TPListenerManager.getInstance().handleStringCallbackMessage(paramInt1, paramInt2, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5);
    AppMethodBeat.o(191533);
    return paramObject1;
  }
  
  public native int createDownloadTask(int paramInt1, String paramString, int paramInt2, int paramInt3);
  
  public native int deInitService(int paramInt);
  
  public native int deleteOfflineCache(String paramString);
  
  public native byte[] getClipPlayUrl(int paramInt1, int paramInt2);
  
  public native byte[] getErrorCodeStr(int paramInt);
  
  public native byte[] getHLSOfflineExttag(String paramString1, String paramString2, int paramInt, long paramLong);
  
  public String getNativeVersion()
  {
    AppMethodBeat.i(191536);
    String str = "1.1.0.00016";
    if (isLoadDownloadProxySucceed) {
      str = TPDLProxyUtils.byteArrayToString(getVersion());
    }
    TPDLProxyLog.i("TPDownloadProxyNative", 0, "tpdlnative", "get native version:".concat(String.valueOf(str)));
    AppMethodBeat.o(191536);
    return str;
  }
  
  public native byte[] getVersion();
  
  public native int initService(int paramInt, String paramString1, String paramString2, String paramString3);
  
  public boolean isNativeLoaded()
  {
    AppMethodBeat.i(191535);
    if (!isLoadDownloadProxySucceed) {}
    try
    {
      if (this.mLibLoader == null) {
        break label71;
      }
      isLoadDownloadProxySucceed = this.mLibLoader.loadLib("DownloadProxy", getNativeVersion());
      localStringBuilder = new StringBuilder("third module so load ret:");
      if (!isLoadDownloadProxySucceed) {
        break label107;
      }
      str = "0";
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        for (;;)
        {
          StringBuilder localStringBuilder;
          if (!isLoadDownloadProxySucceed)
          {
            System.loadLibrary("DownloadProxy");
            isLoadDownloadProxySucceed = true;
            TPDLProxyLog.i("TPDownloadProxyNative", 0, "tpdlnative", "system so load success!");
          }
          boolean bool = isLoadDownloadProxySucceed;
          AppMethodBeat.o(191535);
          return bool;
          String str = "1";
          continue;
          localThrowable1 = localThrowable1;
          isLoadDownloadProxySucceed = false;
          TPDLProxyLog.e("TPDownloadProxyNative", 0, "tpdlnative", "third module so load failed, error:" + localThrowable1.toString());
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          isLoadDownloadProxySucceed = false;
          TPDLProxyLog.e("TPDownloadProxyNative", 0, "tpdlnative", "system so load failed, error:" + localThrowable2.toString());
        }
      }
    }
    TPDLProxyLog.i("TPDownloadProxyNative", 0, "tpdlnative", str);
  }
  
  public native boolean isNativeReadyForWork();
  
  public boolean isReadyForWork()
  {
    AppMethodBeat.i(191538);
    if (isLoadDownloadProxySucceed)
    {
      boolean bool = isNativeReadyForWork();
      AppMethodBeat.o(191538);
      return bool;
    }
    AppMethodBeat.o(191538);
    return false;
  }
  
  public native int pauseDownload(int paramInt);
  
  public native void pushEvent(int paramInt);
  
  public native int resumeDownload(int paramInt);
  
  public void setAppContext(Context paramContext)
  {
    appContext = paramContext;
  }
  
  public native int setClipInfo(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2, String paramString3, String paramString4);
  
  public void setLibLoader(ITPDLProxyNativeLibLoader paramITPDLProxyNativeLibLoader)
  {
    AppMethodBeat.i(191537);
    TPDLProxyLog.i("TPDownloadProxyNative", 0, "tpdlnative", "set third module so loader!!!");
    this.mLibLoader = paramITPDLProxyNativeLibLoader;
    AppMethodBeat.o(191537);
  }
  
  public native int setMaxStorageSizeMB(int paramInt, long paramLong);
  
  public native void setPlayerState(int paramInt1, int paramInt2);
  
  public native void setUserData(String paramString1, String paramString2);
  
  public native int startDownload(int paramInt);
  
  public native int stopAllDownload();
  
  public native int stopDownload(int paramInt);
  
  public native void updatePlayerPlayMsg(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native int updateStoragePath(int paramInt, String paramString);
  
  public native long verifyOfflineCacheSync(String paramString1, int paramInt, String paramString2, String paramString3);
  
  static class SingletonHolder
  {
    private static final TPDownloadProxyNative INSTANCE;
    
    static
    {
      AppMethodBeat.i(191529);
      INSTANCE = new TPDownloadProxyNative(null);
      AppMethodBeat.o(191529);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative
 * JD-Core Version:    0.7.0.1
 */