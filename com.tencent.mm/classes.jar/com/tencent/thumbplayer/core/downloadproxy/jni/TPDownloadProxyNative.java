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
  private byte _hellAccFlag_;
  private ITPDLProxyNativeLibLoader mLibLoader;
  
  public static TPDownloadProxyNative getInstance()
  {
    AppMethodBeat.i(227988);
    TPDownloadProxyNative localTPDownloadProxyNative = SingletonHolder.INSTANCE;
    AppMethodBeat.o(227988);
    return localTPDownloadProxyNative;
  }
  
  private static int nativeIntMessageCallback(int paramInt1, int paramInt2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    AppMethodBeat.i(228020);
    paramInt1 = TPListenerManager.getInstance().handleIntCallbackMessage(paramInt1, paramInt2, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5);
    AppMethodBeat.o(228020);
    return paramInt1;
  }
  
  private static void nativeLogCallback(int paramInt1, byte[] paramArrayOfByte1, int paramInt2, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    AppMethodBeat.i(228049);
    if (paramInt1 == 6)
    {
      TPDLProxyLog.e(TPDLProxyUtils.byteArrayToString(paramArrayOfByte1), paramInt2, TPDLProxyUtils.byteArrayToString(paramArrayOfByte2), TPDLProxyUtils.byteArrayToString(paramArrayOfByte3));
      AppMethodBeat.o(228049);
      return;
    }
    if (paramInt1 == 5)
    {
      TPDLProxyLog.w(TPDLProxyUtils.byteArrayToString(paramArrayOfByte1), paramInt2, TPDLProxyUtils.byteArrayToString(paramArrayOfByte2), TPDLProxyUtils.byteArrayToString(paramArrayOfByte3));
      AppMethodBeat.o(228049);
      return;
    }
    if ((paramInt1 != 4) && (paramInt1 == 3))
    {
      TPDLProxyLog.d(TPDLProxyUtils.byteArrayToString(paramArrayOfByte1), paramInt2, TPDLProxyUtils.byteArrayToString(paramArrayOfByte2), TPDLProxyUtils.byteArrayToString(paramArrayOfByte3));
      AppMethodBeat.o(228049);
      return;
    }
    TPDLProxyLog.i(TPDLProxyUtils.byteArrayToString(paramArrayOfByte1), paramInt2, TPDLProxyUtils.byteArrayToString(paramArrayOfByte2), TPDLProxyUtils.byteArrayToString(paramArrayOfByte3));
    AppMethodBeat.o(228049);
  }
  
  private static void nativeMessageCallback(int paramInt1, int paramInt2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    AppMethodBeat.i(228004);
    TPListenerManager.getInstance().handleCallbackMessage(paramInt1, paramInt2, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5);
    AppMethodBeat.o(228004);
  }
  
  private static String nativeStringMessageCallback(int paramInt1, int paramInt2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    AppMethodBeat.i(228034);
    paramObject1 = TPListenerManager.getInstance().handleStringCallbackMessage(paramInt1, paramInt2, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5);
    AppMethodBeat.o(228034);
    return paramObject1;
  }
  
  public native int createDownloadTask(int paramInt1, String paramString, int paramInt2, int paramInt3);
  
  public native int deInitService(int paramInt);
  
  public native int deleteCache(String paramString1, String paramString2);
  
  public native byte[] getClipPlayUrl(int paramInt1, int paramInt2, int paramInt3);
  
  public native byte[] getErrorCodeStr(int paramInt);
  
  public native byte[] getHLSOfflineExttag(String paramString1, String paramString2, int paramInt, long paramLong);
  
  public native byte[] getNativeInfo(int paramInt);
  
  public String getNativeVersion()
  {
    AppMethodBeat.i(228265);
    String str = "2.10.0.00334";
    if (isLoadDownloadProxySucceed) {
      str = TPDLProxyUtils.byteArrayToString(getVersion());
    }
    TPDLProxyLog.i("TPDownloadProxyNative", 0, "tpdlnative", "get native version:".concat(String.valueOf(str)));
    AppMethodBeat.o(228265);
    return str;
  }
  
  public native byte[] getVersion();
  
  public native int initService(int paramInt, String paramString1, String paramString2, String paramString3);
  
  /* Error */
  public boolean isNativeLoaded()
  {
    // Byte code:
    //   0: ldc 135
    //   2: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 25	com/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative:isLoadDownloadProxySucceed	Z
    //   8: ifne +151 -> 159
    //   11: aload_0
    //   12: getfield 137	com/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative:mLibLoader	Lcom/tencent/thumbplayer/core/downloadproxy/api/ITPDLProxyNativeLibLoader;
    //   15: ifnull +56 -> 71
    //   18: aload_0
    //   19: getfield 137	com/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative:mLibLoader	Lcom/tencent/thumbplayer/core/downloadproxy/api/ITPDLProxyNativeLibLoader;
    //   22: ldc 139
    //   24: aload_0
    //   25: invokevirtual 141	com/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative:getNativeVersion	()Ljava/lang/String;
    //   28: invokeinterface 147 3 0
    //   33: putstatic 25	com/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative:isLoadDownloadProxySucceed	Z
    //   36: new 149	java/lang/StringBuilder
    //   39: dup
    //   40: ldc 151
    //   42: invokespecial 154	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   45: astore_3
    //   46: getstatic 25	com/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative:isLoadDownloadProxySucceed	Z
    //   49: ifeq +121 -> 170
    //   52: ldc 156
    //   54: astore_2
    //   55: ldc 13
    //   57: iconst_0
    //   58: ldc 118
    //   60: aload_3
    //   61: aload_2
    //   62: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokestatic 82	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   71: getstatic 25	com/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative:isLoadDownloadProxySucceed	Z
    //   74: ifne +85 -> 159
    //   77: new 165	com/tencent/mm/hellhoundlib/b/a
    //   80: dup
    //   81: invokespecial 166	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   84: ldc 139
    //   86: invokevirtual 170	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   89: astore_2
    //   90: new 4	java/lang/Object
    //   93: dup
    //   94: invokespecial 31	java/lang/Object:<init>	()V
    //   97: astore_3
    //   98: aload_3
    //   99: aload_2
    //   100: invokevirtual 174	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
    //   103: ldc 175
    //   105: ldc 176
    //   107: ldc 177
    //   109: ldc 179
    //   111: ldc 181
    //   113: ldc 182
    //   115: invokestatic 188	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   118: aload_2
    //   119: iconst_0
    //   120: invokevirtual 192	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
    //   123: checkcast 122	java/lang/String
    //   126: invokestatic 196	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   129: aload_3
    //   130: ldc 175
    //   132: ldc 176
    //   134: ldc 177
    //   136: ldc 179
    //   138: ldc 181
    //   140: ldc 182
    //   142: invokestatic 200	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   145: iconst_1
    //   146: putstatic 25	com/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative:isLoadDownloadProxySucceed	Z
    //   149: ldc 13
    //   151: iconst_0
    //   152: ldc 118
    //   154: ldc 202
    //   156: invokestatic 82	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   159: getstatic 25	com/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative:isLoadDownloadProxySucceed	Z
    //   162: istore_1
    //   163: ldc 135
    //   165: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   168: iload_1
    //   169: ireturn
    //   170: ldc 204
    //   172: astore_2
    //   173: goto -118 -> 55
    //   176: astore_2
    //   177: iconst_0
    //   178: putstatic 25	com/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative:isLoadDownloadProxySucceed	Z
    //   181: ldc 13
    //   183: iconst_0
    //   184: ldc 118
    //   186: new 149	java/lang/StringBuilder
    //   189: dup
    //   190: ldc 206
    //   192: invokespecial 154	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   195: aload_2
    //   196: invokevirtual 209	java/lang/Throwable:toString	()Ljava/lang/String;
    //   199: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 74	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   208: goto -137 -> 71
    //   211: astore_2
    //   212: iconst_0
    //   213: putstatic 25	com/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative:isLoadDownloadProxySucceed	Z
    //   216: ldc 13
    //   218: iconst_0
    //   219: ldc 118
    //   221: new 149	java/lang/StringBuilder
    //   224: dup
    //   225: ldc 211
    //   227: invokespecial 154	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   230: aload_2
    //   231: invokevirtual 209	java/lang/Throwable:toString	()Ljava/lang/String;
    //   234: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 74	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   243: goto -84 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	this	TPDownloadProxyNative
    //   162	7	1	bool	boolean
    //   54	119	2	localObject1	Object
    //   176	20	2	localObject2	Object
    //   211	20	2	localObject3	Object
    //   45	85	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   11	52	176	finally
    //   55	71	176	finally
    //   71	159	211	finally
  }
  
  public native boolean isNativeReadyForWork();
  
  public boolean isReadyForWork()
  {
    AppMethodBeat.i(228289);
    if (isLoadDownloadProxySucceed)
    {
      boolean bool = isNativeReadyForWork();
      AppMethodBeat.o(228289);
      return bool;
    }
    AppMethodBeat.o(228289);
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
    AppMethodBeat.i(228274);
    TPDLProxyLog.i("TPDownloadProxyNative", 0, "tpdlnative", "set third module so loader!!!");
    this.mLibLoader = paramITPDLProxyNativeLibLoader;
    AppMethodBeat.o(228274);
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
      AppMethodBeat.i(228012);
      INSTANCE = new TPDownloadProxyNative(null);
      AppMethodBeat.o(228012);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative
 * JD-Core Version:    0.7.0.1
 */