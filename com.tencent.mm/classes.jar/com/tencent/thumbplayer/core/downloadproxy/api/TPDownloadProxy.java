package com.tencent.thumbplayer.core.downloadproxy.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.downloadproxy.apiinner.TPListenerManager;
import com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils;

public class TPDownloadProxy
  implements ITPDownloadProxy
{
  private static final String FILE_NAME = "TPDownloadProxy";
  private String mCurrentStoragePath = "";
  private boolean mIsInit = false;
  private int mServiceType;
  
  public TPDownloadProxy(int paramInt)
  {
    this.mServiceType = paramInt;
  }
  
  public int deinit()
  {
    AppMethodBeat.i(255619);
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        this.mIsInit = false;
        int i = TPDownloadProxyNative.getInstance().deInitService(this.mServiceType);
        AppMethodBeat.o(255619);
        return i;
      }
      catch (Throwable localThrowable)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "deinit failed, error:" + localThrowable.toString());
      }
    }
    AppMethodBeat.o(255619);
    return -1;
  }
  
  public String getClipPlayUrl(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(255644);
    String str2 = "";
    String str1 = str2;
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      str1 = str2;
    }
    try
    {
      str2 = TPDLProxyUtils.byteArrayToString(TPDownloadProxyNative.getInstance().getClipPlayUrl(paramInt1, paramInt2, paramInt3));
      str1 = str2;
      if (paramInt3 != 2)
      {
        str1 = str2;
        TPDownloadProxyNative.getInstance().startDownload(paramInt1);
        str1 = str2;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "getClipPlayUrl failed, error:" + localThrowable.toString());
      }
    }
    AppMethodBeat.o(255644);
    return str1;
  }
  
  public String getPlayErrorCodeStr(int paramInt)
  {
    AppMethodBeat.i(255648);
    String str3 = "";
    String str1 = str3;
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {}
    try
    {
      str1 = TPDLProxyUtils.byteArrayToString(TPDownloadProxyNative.getInstance().getErrorCodeStr(paramInt));
      AppMethodBeat.o(255648);
      return str1;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "getPlayErrorCodeStr failed, error:" + localThrowable.toString());
        String str2 = str3;
      }
    }
  }
  
  public String getPlayUrl(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(255640);
    String str2 = "";
    String str1 = str2;
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      str1 = str2;
    }
    try
    {
      str2 = TPDLProxyUtils.byteArrayToString(TPDownloadProxyNative.getInstance().getClipPlayUrl(paramInt1, 1, paramInt2));
      str1 = str2;
      if (paramInt2 != 2)
      {
        str1 = str2;
        TPDownloadProxyNative.getInstance().startDownload(paramInt1);
        str1 = str2;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "getPlayUrl failed, error:" + localThrowable.toString());
      }
    }
    AppMethodBeat.o(255640);
    return str1;
  }
  
  /* Error */
  public int init(Context paramContext, TPDLProxyInitParam paramTPDLProxyInitParam)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 116
    //   6: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: getfield 28	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxy:mIsInit	Z
    //   13: ifeq +22 -> 35
    //   16: ldc 12
    //   18: iconst_0
    //   19: ldc 60
    //   21: ldc 118
    //   23: invokestatic 120	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   26: ldc 116
    //   28: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload_0
    //   32: monitorexit
    //   33: iload_3
    //   34: ireturn
    //   35: invokestatic 47	com/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative:getInstance	()Lcom/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative;
    //   38: invokevirtual 51	com/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative:isNativeLoaded	()Z
    //   41: istore 4
    //   43: iload 4
    //   45: ifeq +299 -> 344
    //   48: aload_2
    //   49: invokevirtual 125	com/tencent/thumbplayer/core/downloadproxy/api/TPDLProxyInitParam:getAppVer	()Ljava/lang/String;
    //   52: invokestatic 131	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   55: ifne +13 -> 68
    //   58: aload_0
    //   59: ldc 133
    //   61: aload_2
    //   62: invokevirtual 125	com/tencent/thumbplayer/core/downloadproxy/api/TPDLProxyInitParam:getAppVer	()Ljava/lang/String;
    //   65: invokevirtual 137	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxy:setUserData	(Ljava/lang/String;Ljava/lang/Object;)V
    //   68: aload_2
    //   69: invokevirtual 140	com/tencent/thumbplayer/core/downloadproxy/api/TPDLProxyInitParam:getPlatform	()I
    //   72: ifle +16 -> 88
    //   75: aload_0
    //   76: ldc 142
    //   78: aload_2
    //   79: invokevirtual 140	com/tencent/thumbplayer/core/downloadproxy/api/TPDLProxyInitParam:getPlatform	()I
    //   82: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   85: invokevirtual 137	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxy:setUserData	(Ljava/lang/String;Ljava/lang/Object;)V
    //   88: aload_2
    //   89: invokevirtual 151	com/tencent/thumbplayer/core/downloadproxy/api/TPDLProxyInitParam:getGuid	()Ljava/lang/String;
    //   92: invokestatic 131	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   95: ifne +13 -> 108
    //   98: aload_0
    //   99: ldc 153
    //   101: aload_2
    //   102: invokevirtual 151	com/tencent/thumbplayer/core/downloadproxy/api/TPDLProxyInitParam:getGuid	()Ljava/lang/String;
    //   105: invokevirtual 137	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxy:setUserData	(Ljava/lang/String;Ljava/lang/Object;)V
    //   108: aload_2
    //   109: invokevirtual 156	com/tencent/thumbplayer/core/downloadproxy/api/TPDLProxyInitParam:getCacheDir	()Ljava/lang/String;
    //   112: astore 6
    //   114: aload 6
    //   116: invokestatic 131	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   119: istore 4
    //   121: aload 6
    //   123: astore 5
    //   125: iload 4
    //   127: ifeq +35 -> 162
    //   130: aload 6
    //   132: astore 5
    //   134: aload_1
    //   135: ifnull +27 -> 162
    //   138: aload_1
    //   139: ldc 158
    //   141: invokestatic 164	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLFileSystem:getProperCacheDirectory	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   144: astore 7
    //   146: aload 6
    //   148: astore 5
    //   150: aload 7
    //   152: ifnull +10 -> 162
    //   155: aload 7
    //   157: invokevirtual 169	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   160: astore 5
    //   162: invokestatic 174	com/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager:getInstance	()Lcom/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager;
    //   165: invokevirtual 177	com/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager:initHandler	()V
    //   168: aload_2
    //   169: invokevirtual 180	com/tencent/thumbplayer/core/downloadproxy/api/TPDLProxyInitParam:getDataDir	()Ljava/lang/String;
    //   172: invokestatic 131	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   175: ifeq +179 -> 354
    //   178: aload_0
    //   179: getfield 26	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxy:mCurrentStoragePath	Ljava/lang/String;
    //   182: invokestatic 131	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   185: ifne +169 -> 354
    //   188: invokestatic 47	com/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative:getInstance	()Lcom/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative;
    //   191: aload_0
    //   192: getfield 30	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxy:mServiceType	I
    //   195: aload 5
    //   197: aload_0
    //   198: getfield 26	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxy:mCurrentStoragePath	Ljava/lang/String;
    //   201: aload_2
    //   202: invokevirtual 183	com/tencent/thumbplayer/core/downloadproxy/api/TPDLProxyInitParam:getConfigStr	()Ljava/lang/String;
    //   205: invokevirtual 187	com/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative:initService	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   208: istore_3
    //   209: new 189	android/content/IntentFilter
    //   212: dup
    //   213: invokespecial 190	android/content/IntentFilter:<init>	()V
    //   216: astore_2
    //   217: aload_2
    //   218: ldc 192
    //   220: invokevirtual 195	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   223: aload_2
    //   224: ldc 197
    //   226: invokevirtual 195	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   229: aload_2
    //   230: ldc 199
    //   232: invokevirtual 195	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   235: new 8	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxy$1
    //   238: dup
    //   239: aload_0
    //   240: invokespecial 202	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxy$1:<init>	(Lcom/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxy;)V
    //   243: astore 5
    //   245: aload_1
    //   246: ifnull +11 -> 257
    //   249: aload_1
    //   250: aload 5
    //   252: aload_2
    //   253: invokevirtual 208	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   256: pop
    //   257: iload_3
    //   258: ifne +8 -> 266
    //   261: aload_0
    //   262: iconst_1
    //   263: putfield 28	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxy:mIsInit	Z
    //   266: ldc 116
    //   268: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   271: goto -240 -> 31
    //   274: astore_1
    //   275: aload_0
    //   276: monitorexit
    //   277: aload_1
    //   278: athrow
    //   279: astore 5
    //   281: ldc 12
    //   283: iconst_0
    //   284: ldc 60
    //   286: new 62	java/lang/StringBuilder
    //   289: dup
    //   290: ldc 210
    //   292: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   295: aload 5
    //   297: invokevirtual 71	java/lang/Throwable:toString	()Ljava/lang/String;
    //   300: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: invokestatic 82	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   309: aload 6
    //   311: astore 5
    //   313: goto -151 -> 162
    //   316: astore_1
    //   317: ldc 12
    //   319: iconst_0
    //   320: ldc 60
    //   322: new 62	java/lang/StringBuilder
    //   325: dup
    //   326: ldc 212
    //   328: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   331: aload_1
    //   332: invokevirtual 71	java/lang/Throwable:toString	()Ljava/lang/String;
    //   335: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokestatic 82	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   344: iconst_m1
    //   345: istore_3
    //   346: ldc 116
    //   348: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   351: goto -320 -> 31
    //   354: aload_2
    //   355: invokevirtual 180	com/tencent/thumbplayer/core/downloadproxy/api/TPDLProxyInitParam:getDataDir	()Ljava/lang/String;
    //   358: invokestatic 131	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   361: ifne +11 -> 372
    //   364: aload_0
    //   365: aload_2
    //   366: invokevirtual 180	com/tencent/thumbplayer/core/downloadproxy/api/TPDLProxyInitParam:getDataDir	()Ljava/lang/String;
    //   369: putfield 26	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxy:mCurrentStoragePath	Ljava/lang/String;
    //   372: invokestatic 47	com/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative:getInstance	()Lcom/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative;
    //   375: aload_0
    //   376: getfield 30	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxy:mServiceType	I
    //   379: aload 5
    //   381: aload_2
    //   382: invokevirtual 180	com/tencent/thumbplayer/core/downloadproxy/api/TPDLProxyInitParam:getDataDir	()Ljava/lang/String;
    //   385: aload_2
    //   386: invokevirtual 183	com/tencent/thumbplayer/core/downloadproxy/api/TPDLProxyInitParam:getConfigStr	()Ljava/lang/String;
    //   389: invokevirtual 187	com/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative:initService	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   392: istore_3
    //   393: goto -184 -> 209
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	396	0	this	TPDownloadProxy
    //   0	396	1	paramContext	Context
    //   0	396	2	paramTPDLProxyInitParam	TPDLProxyInitParam
    //   1	392	3	i	int
    //   41	85	4	bool	boolean
    //   123	128	5	localObject	Object
    //   279	17	5	localThrowable	Throwable
    //   311	69	5	str1	String
    //   112	198	6	str2	String
    //   144	12	7	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   4	31	274	finally
    //   35	43	274	finally
    //   48	68	274	finally
    //   68	88	274	finally
    //   88	108	274	finally
    //   108	121	274	finally
    //   138	146	274	finally
    //   155	162	274	finally
    //   162	209	274	finally
    //   209	245	274	finally
    //   249	257	274	finally
    //   261	266	274	finally
    //   266	271	274	finally
    //   281	309	274	finally
    //   317	344	274	finally
    //   346	351	274	finally
    //   354	372	274	finally
    //   372	393	274	finally
    //   138	146	279	java/lang/Throwable
    //   155	162	279	java/lang/Throwable
    //   48	68	316	java/lang/Throwable
    //   68	88	316	java/lang/Throwable
    //   88	108	316	java/lang/Throwable
    //   108	121	316	java/lang/Throwable
    //   162	209	316	java/lang/Throwable
    //   209	245	316	java/lang/Throwable
    //   249	257	316	java/lang/Throwable
    //   261	266	316	java/lang/Throwable
    //   281	309	316	java/lang/Throwable
    //   354	372	316	java/lang/Throwable
    //   372	393	316	java/lang/Throwable
  }
  
  public int pauseDownload(int paramInt)
  {
    AppMethodBeat.i(255653);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(255653);
      return -1;
    }
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        paramInt = TPDownloadProxyNative.getInstance().pauseDownload(paramInt);
        AppMethodBeat.o(255653);
        return paramInt;
      }
      catch (Throwable localThrowable)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "pauseDownload failed, error:" + localThrowable.toString());
      }
    }
    AppMethodBeat.o(255653);
    return -1;
  }
  
  public void pushEvent(int paramInt)
  {
    AppMethodBeat.i(255683);
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        TPDownloadProxyNative.getInstance().pushEvent(paramInt);
        AppMethodBeat.o(255683);
        return;
      }
      catch (Throwable localThrowable)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "pushEvent failed, error:" + localThrowable.toString());
      }
    }
    AppMethodBeat.o(255683);
  }
  
  public int removeStorageCache(String paramString)
  {
    AppMethodBeat.i(255678);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(255678);
      return -1;
    }
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        int i = TPDownloadProxyNative.getInstance().deleteCache(this.mCurrentStoragePath, paramString);
        AppMethodBeat.o(255678);
        return i;
      }
      catch (Throwable paramString)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "deleteCache failed, error:" + paramString.toString());
      }
    }
    AppMethodBeat.o(255678);
    return -1;
  }
  
  public int resumeDownload(int paramInt)
  {
    AppMethodBeat.i(255656);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(255656);
      return -1;
    }
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        paramInt = TPDownloadProxyNative.getInstance().resumeDownload(paramInt);
        AppMethodBeat.o(255656);
        return paramInt;
      }
      catch (Throwable localThrowable)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "resumeDownload failed, error:" + localThrowable.toString());
      }
    }
    AppMethodBeat.o(255656);
    return -1;
  }
  
  public boolean setClipInfo(int paramInt1, int paramInt2, String paramString, TPDownloadParam paramTPDownloadParam)
  {
    bool2 = false;
    AppMethodBeat.i(255636);
    int j = paramTPDownloadParam.getDlType();
    int i = j;
    if (paramTPDownloadParam.isOffline()) {
      i = j + 300;
    }
    bool1 = bool2;
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {}
    for (;;)
    {
      try
      {
        paramInt1 = TPDownloadProxyNative.getInstance().setClipInfo(paramInt1, paramInt2, paramString, i, paramTPDownloadParam.getCdnUrls(), paramTPDownloadParam.getSavaPath(), paramTPDownloadParam.getExtraJsonInfo());
        if (paramInt1 < 0) {
          continue;
        }
        bool1 = true;
      }
      catch (Throwable paramString)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "setClipInfo failed, error:" + paramString.toString());
        bool1 = bool2;
        continue;
      }
      AppMethodBeat.o(255636);
      return bool1;
      bool1 = false;
    }
  }
  
  public void setLogListener(ITPDLProxyLogListener paramITPDLProxyLogListener)
  {
    AppMethodBeat.i(255623);
    TPDLProxyLog.setLogListener(this.mServiceType, paramITPDLProxyLogListener);
    AppMethodBeat.o(255623);
  }
  
  public void setMaxStorageSizeMB(long paramLong)
  {
    AppMethodBeat.i(255677);
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        TPDownloadProxyNative.getInstance().setMaxStorageSizeMB(this.mServiceType, paramLong);
        AppMethodBeat.o(255677);
        return;
      }
      catch (Throwable localThrowable)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "setMaxStorageSizeMB failed, error:" + localThrowable.toString());
      }
    }
    AppMethodBeat.o(255677);
  }
  
  public void setPlayState(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(255686);
    if (paramInt1 <= 0)
    {
      AppMethodBeat.o(255686);
      return;
    }
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        TPDownloadProxyNative.getInstance().setPlayerState(paramInt1, paramInt2);
        AppMethodBeat.o(255686);
        return;
      }
      catch (Throwable localThrowable)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "setPlayState failed, error:" + localThrowable.toString());
      }
    }
    AppMethodBeat.o(255686);
  }
  
  public void setUserData(String paramString, Object paramObject)
  {
    AppMethodBeat.i(255681);
    if (TPDownloadProxyNative.getInstance().isNativeLoaded())
    {
      try
      {
        if (paramString.equalsIgnoreCase("app_version_name"))
        {
          TPDownloadProxyNative.getInstance().setUserData("app_version_name", (String)paramObject);
          AppMethodBeat.o(255681);
          return;
        }
        if (!paramString.equalsIgnoreCase("platform")) {
          break label107;
        }
        TPDownloadProxyNative.getInstance().setUserData("platform", paramObject.toString());
        AppMethodBeat.o(255681);
        return;
      }
      catch (Throwable paramString)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "setUserData failed, error:" + paramString.toString());
      }
    }
    else
    {
      AppMethodBeat.o(255681);
      return;
    }
    label107:
    if (paramString.equalsIgnoreCase("guid"))
    {
      TPDownloadProxyNative.getInstance().setUserData("guid", (String)paramObject);
      AppMethodBeat.o(255681);
      return;
    }
    TPDownloadProxyNative localTPDownloadProxyNative;
    if (paramString.equalsIgnoreCase("qq_is_vip"))
    {
      localTPDownloadProxyNative = TPDownloadProxyNative.getInstance();
      if (!((Boolean)paramObject).booleanValue()) {
        break label256;
      }
    }
    label256:
    for (paramString = "1";; paramString = "0")
    {
      localTPDownloadProxyNative.setUserData("qq_is_vip", paramString);
      AppMethodBeat.o(255681);
      return;
      if (paramString.equalsIgnoreCase("carrier_pesudo_code"))
      {
        TPDownloadProxyNative.getInstance().setUserData("carrier_pesudo_code", (String)paramObject);
        AppMethodBeat.o(255681);
        return;
      }
      if (paramString.equalsIgnoreCase("carrier_pesudo_state"))
      {
        TPDownloadProxyNative.getInstance().setUserData("carrier_pesudo_state", paramObject.toString());
        AppMethodBeat.o(255681);
        return;
      }
      TPDownloadProxyNative.getInstance().setUserData(paramString, paramObject.toString());
      AppMethodBeat.o(255681);
      return;
    }
  }
  
  public int startClipOfflineDownload(String paramString, int paramInt, ITPOfflineDownloadListener paramITPOfflineDownloadListener)
  {
    AppMethodBeat.i(255668);
    int j = -1;
    int i = j;
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      i = j;
    }
    try
    {
      paramInt = TPDownloadProxyNative.getInstance().createDownloadTask(this.mServiceType, paramString, 102, paramInt);
      i = paramInt;
      TPListenerManager.getInstance().setOfflineDownloadListener(paramInt, paramITPOfflineDownloadListener);
      i = paramInt;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "startClipOfflineDownload failed, error:" + paramString.toString());
      }
    }
    AppMethodBeat.o(255668);
    return i;
  }
  
  public int startClipPlay(String paramString, int paramInt, ITPPlayListener paramITPPlayListener)
  {
    AppMethodBeat.i(255634);
    int j = -1;
    int i = j;
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      i = j;
    }
    try
    {
      paramInt = TPDownloadProxyNative.getInstance().createDownloadTask(this.mServiceType, paramString, 2, paramInt);
      i = paramInt;
      TPListenerManager.getInstance().setPlayListener(paramInt, paramITPPlayListener);
      i = paramInt;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "startClipPlay failed, error:" + paramString.toString());
      }
    }
    AppMethodBeat.o(255634);
    return i;
  }
  
  public int startOfflineDownload(String paramString, TPDownloadParam paramTPDownloadParam, ITPOfflineDownloadListener paramITPOfflineDownloadListener)
  {
    AppMethodBeat.i(255664);
    int j = -1;
    int i = j;
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      i = j;
    }
    for (;;)
    {
      try
      {
        int k = paramTPDownloadParam.getDlType() + 100;
        i = j;
        j = TPDownloadProxyNative.getInstance().createDownloadTask(this.mServiceType, paramString, k, paramTPDownloadParam.getClipCount());
        i = j;
        TPListenerManager.getInstance().setOfflineDownloadListener(j, paramITPOfflineDownloadListener);
        i = j;
        if (!TextUtils.isEmpty(paramTPDownloadParam.getKeyid())) {
          continue;
        }
        i = j;
        TPDownloadProxyNative.getInstance().setClipInfo(j, paramTPDownloadParam.getClipNo(), paramString, k, paramTPDownloadParam.getCdnUrls(), paramTPDownloadParam.getSavaPath(), paramTPDownloadParam.getExtraJsonInfo());
        i = j;
      }
      catch (Throwable paramString)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "stopOfflineDownload failed, error:" + paramString.toString());
        continue;
      }
      AppMethodBeat.o(255664);
      return i;
      i = j;
      paramString = paramTPDownloadParam.getKeyid();
    }
  }
  
  public int startPlay(String paramString, TPDownloadParam paramTPDownloadParam, ITPPlayListener paramITPPlayListener)
  {
    AppMethodBeat.i(255630);
    int k = -1;
    int j = paramTPDownloadParam.getDlType();
    int i = j;
    if (paramTPDownloadParam.isOffline()) {
      i = j + 300;
    }
    j = k;
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      j = k;
    }
    try
    {
      if ((!paramTPDownloadParam.isAdaptive()) || (i != 3)) {
        break label211;
      }
      i += 400;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "startPlay failed, error:" + paramString.toString());
      }
    }
    j = k;
    k = TPDownloadProxyNative.getInstance().createDownloadTask(this.mServiceType, paramString, i, paramTPDownloadParam.getClipCount());
    j = k;
    if (TextUtils.isEmpty(paramTPDownloadParam.getKeyid())) {}
    for (;;)
    {
      j = k;
      TPDownloadProxyNative.getInstance().setClipInfo(k, paramTPDownloadParam.getClipNo(), paramString, i, paramTPDownloadParam.getCdnUrls(), paramTPDownloadParam.getSavaPath(), paramTPDownloadParam.getExtraJsonInfo());
      j = k;
      TPListenerManager.getInstance().setPlayListener(k, paramITPPlayListener);
      j = k;
      AppMethodBeat.o(255630);
      return j;
      j = k;
      paramString = paramTPDownloadParam.getKeyid();
    }
  }
  
  public int startPreload(String paramString, TPDownloadParam paramTPDownloadParam, ITPPreLoadListener paramITPPreLoadListener)
  {
    AppMethodBeat.i(255658);
    int j = -1;
    int i = j;
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      i = j;
    }
    for (;;)
    {
      try
      {
        int k = paramTPDownloadParam.getDlType() + 200;
        i = j;
        j = TPDownloadProxyNative.getInstance().createDownloadTask(this.mServiceType, paramString, k, paramTPDownloadParam.getClipCount());
        i = j;
        TPListenerManager.getInstance().setPreLoadListener(j, paramITPPreLoadListener);
        i = j;
        if (!TextUtils.isEmpty(paramTPDownloadParam.getKeyid())) {
          continue;
        }
        i = j;
        TPDownloadProxyNative.getInstance().setClipInfo(j, paramTPDownloadParam.getClipNo(), paramString, k, paramTPDownloadParam.getCdnUrls(), paramTPDownloadParam.getSavaPath(), paramTPDownloadParam.getExtraJsonInfo());
        i = j;
        TPDownloadProxyNative.getInstance().startDownload(j);
        i = j;
      }
      catch (Throwable paramString)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "startPreload failed, error:" + paramString.toString());
        continue;
      }
      AppMethodBeat.o(255658);
      return i;
      i = j;
      paramString = paramTPDownloadParam.getKeyid();
    }
  }
  
  public void startTask(int paramInt)
  {
    AppMethodBeat.i(255671);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(255671);
      return;
    }
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        TPDownloadProxyNative.getInstance().startDownload(paramInt);
        AppMethodBeat.o(255671);
        return;
      }
      catch (Throwable localThrowable)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "startTask failed, error:" + localThrowable.toString());
      }
    }
    AppMethodBeat.o(255671);
  }
  
  public void stopOfflineDownload(int paramInt)
  {
    AppMethodBeat.i(255670);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(255670);
      return;
    }
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        TPDownloadProxyNative.getInstance().stopDownload(paramInt);
        TPListenerManager.getInstance().removeOfflineDownloadListener(paramInt);
        AppMethodBeat.o(255670);
        return;
      }
      catch (Throwable localThrowable)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "stopOfflineDownload failed, error:" + localThrowable.toString());
      }
    }
    AppMethodBeat.o(255670);
  }
  
  public void stopPlay(int paramInt)
  {
    AppMethodBeat.i(255651);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(255651);
      return;
    }
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        TPDownloadProxyNative.getInstance().stopDownload(paramInt);
        TPListenerManager.getInstance().removePlayListener(paramInt);
        AppMethodBeat.o(255651);
        return;
      }
      catch (Throwable localThrowable)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "stopPlay failed, error:" + localThrowable.toString());
      }
    }
    AppMethodBeat.o(255651);
  }
  
  public void stopPreload(int paramInt)
  {
    AppMethodBeat.i(255661);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(255661);
      return;
    }
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        TPDownloadProxyNative.getInstance().stopDownload(paramInt);
        TPListenerManager.getInstance().removePreLoadListener(paramInt);
        AppMethodBeat.o(255661);
        return;
      }
      catch (Throwable localThrowable)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "stopPreload failed, error:" + localThrowable.toString());
      }
    }
    AppMethodBeat.o(255661);
  }
  
  public void updateStoragePath(String paramString)
  {
    AppMethodBeat.i(255675);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(255675);
      return;
    }
    try
    {
      this.mCurrentStoragePath = paramString;
      TPDownloadProxyNative.getInstance().updateStoragePath(this.mServiceType, paramString);
      AppMethodBeat.o(255675);
      return;
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "updateStoragePath failed, error:" + paramString.toString());
      AppMethodBeat.o(255675);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxy
 * JD-Core Version:    0.7.0.1
 */