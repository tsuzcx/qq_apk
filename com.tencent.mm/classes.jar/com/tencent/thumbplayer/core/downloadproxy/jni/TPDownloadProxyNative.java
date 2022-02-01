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
    AppMethodBeat.i(256004);
    TPDownloadProxyNative localTPDownloadProxyNative = SingletonHolder.INSTANCE;
    AppMethodBeat.o(256004);
    return localTPDownloadProxyNative;
  }
  
  private static int nativeIntMessageCallback(int paramInt1, int paramInt2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    AppMethodBeat.i(256008);
    paramInt1 = TPListenerManager.getInstance().handleIntCallbackMessage(paramInt1, paramInt2, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5);
    AppMethodBeat.o(256008);
    return paramInt1;
  }
  
  private static void nativeLogCallback(int paramInt1, byte[] paramArrayOfByte1, int paramInt2, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    AppMethodBeat.i(256010);
    if (paramInt1 == 6)
    {
      TPDLProxyLog.e(TPDLProxyUtils.byteArrayToString(paramArrayOfByte1), paramInt2, TPDLProxyUtils.byteArrayToString(paramArrayOfByte2), TPDLProxyUtils.byteArrayToString(paramArrayOfByte3));
      AppMethodBeat.o(256010);
      return;
    }
    if (paramInt1 == 5)
    {
      TPDLProxyLog.w(TPDLProxyUtils.byteArrayToString(paramArrayOfByte1), paramInt2, TPDLProxyUtils.byteArrayToString(paramArrayOfByte2), TPDLProxyUtils.byteArrayToString(paramArrayOfByte3));
      AppMethodBeat.o(256010);
      return;
    }
    if ((paramInt1 != 4) && (paramInt1 == 3))
    {
      TPDLProxyLog.d(TPDLProxyUtils.byteArrayToString(paramArrayOfByte1), paramInt2, TPDLProxyUtils.byteArrayToString(paramArrayOfByte2), TPDLProxyUtils.byteArrayToString(paramArrayOfByte3));
      AppMethodBeat.o(256010);
      return;
    }
    TPDLProxyLog.i(TPDLProxyUtils.byteArrayToString(paramArrayOfByte1), paramInt2, TPDLProxyUtils.byteArrayToString(paramArrayOfByte2), TPDLProxyUtils.byteArrayToString(paramArrayOfByte3));
    AppMethodBeat.o(256010);
  }
  
  private static void nativeMessageCallback(int paramInt1, int paramInt2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    AppMethodBeat.i(256007);
    TPListenerManager.getInstance().handleCallbackMessage(paramInt1, paramInt2, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5);
    AppMethodBeat.o(256007);
  }
  
  private static String nativeStringMessageCallback(int paramInt1, int paramInt2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    AppMethodBeat.i(256009);
    paramObject1 = TPListenerManager.getInstance().handleStringCallbackMessage(paramInt1, paramInt2, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5);
    AppMethodBeat.o(256009);
    return paramObject1;
  }
  
  public native int createDownloadTask(int paramInt1, String paramString, int paramInt2, int paramInt3);
  
  public native int deInitService(int paramInt);
  
  public native int deleteCache(String paramString1, String paramString2);
  
  public native byte[] getClipPlayUrl(int paramInt1, int paramInt2, int paramInt3);
  
  public native byte[] getErrorCodeStr(int paramInt);
  
  public native byte[] getHLSOfflineExttag(String paramString1, String paramString2, int paramInt, long paramLong);
  
  public native byte[] getNativeInfo(String paramString);
  
  public String getNativeVersion()
  {
    AppMethodBeat.i(256012);
    String str = "2.10.0.00109";
    if (isLoadDownloadProxySucceed) {
      str = TPDLProxyUtils.byteArrayToString(getVersion());
    }
    TPDLProxyLog.i("TPDownloadProxyNative", 0, "tpdlnative", "get native version:".concat(String.valueOf(str)));
    AppMethodBeat.o(256012);
    return str;
  }
  
  public native byte[] getVersion();
  
  public native int initService(int paramInt, String paramString1, String paramString2, String paramString3);
  
  public boolean isNativeLoaded()
  {
    AppMethodBeat.i(256011);
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
          AppMethodBeat.o(256011);
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
    AppMethodBeat.i(256014);
    if (isLoadDownloadProxySucceed)
    {
      boolean bool = isNativeReadyForWork();
      AppMethodBeat.o(256014);
      return bool;
    }
    AppMethodBeat.o(256014);
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
    AppMethodBeat.i(256013);
    TPDLProxyLog.i("TPDownloadProxyNative", 0, "tpdlnative", "set third module so loader!!!");
    this.mLibLoader = paramITPDLProxyNativeLibLoader;
    AppMethodBeat.o(256013);
  }
  
  public native int setMaxStorageSizeMB(int paramInt, long paramLong);
  
  public native void setPlayerState(int paramInt1, int paramInt2);
  
  public native void setUserData(String paramString1, String paramString2);
  
  public native int startDownload(int paramInt);
  
  public native int stopAllDownload(int paramInt);
  
  public native int stopDownload(int paramInt);
  
  public native void updatePlayerPlayMsg(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native int updateStoragePath(int paramInt, String paramString);
  
  public native long verifyOfflineCacheSync(String paramString1, int paramInt, String paramString2, String paramString3);
  
  static class SingletonHolder
  {
    private static final TPDownloadProxyNative INSTANCE;
    
    static
    {
      AppMethodBeat.i(255982);
      INSTANCE = new TPDownloadProxyNative(null);
      AppMethodBeat.o(255982);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative
 * JD-Core Version:    0.7.0.1
 */