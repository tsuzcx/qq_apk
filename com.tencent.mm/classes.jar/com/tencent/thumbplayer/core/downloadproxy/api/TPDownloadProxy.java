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
    AppMethodBeat.i(228133);
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        this.mIsInit = false;
        int i = TPDownloadProxyNative.getInstance().deInitService(this.mServiceType);
        AppMethodBeat.o(228133);
        return i;
      }
      finally
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "deinit failed, error:" + localObject.toString());
      }
    }
    AppMethodBeat.o(228133);
    return -1;
  }
  
  public String getClipPlayUrl(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(228182);
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
    finally
    {
      for (;;)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "getClipPlayUrl failed, error:" + localObject.toString());
      }
    }
    AppMethodBeat.o(228182);
    return str1;
  }
  
  public String getNativeInfo(int paramInt)
  {
    AppMethodBeat.i(228271);
    if (TPDownloadProxyNative.getInstance().isNativeLoaded())
    {
      String str = TPDLProxyUtils.byteArrayToString(TPDownloadProxyNative.getInstance().getNativeInfo(paramInt));
      AppMethodBeat.o(228271);
      return str;
    }
    AppMethodBeat.o(228271);
    return null;
  }
  
  public String getPlayErrorCodeStr(int paramInt)
  {
    AppMethodBeat.i(228189);
    String str3 = "";
    String str1 = str3;
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {}
    try
    {
      str1 = TPDLProxyUtils.byteArrayToString(TPDownloadProxyNative.getInstance().getErrorCodeStr(paramInt));
      AppMethodBeat.o(228189);
      return str1;
    }
    finally
    {
      for (;;)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "getPlayErrorCodeStr failed, error:" + localObject.toString());
        String str2 = str3;
      }
    }
  }
  
  public String getPlayUrl(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(228172);
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
    finally
    {
      for (;;)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "getPlayUrl failed, error:" + localObject.toString());
      }
    }
    AppMethodBeat.o(228172);
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
    //   4: ldc 120
    //   6: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: getfield 28	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxy:mIsInit	Z
    //   13: ifeq +22 -> 35
    //   16: ldc 12
    //   18: iconst_0
    //   19: ldc 58
    //   21: ldc 122
    //   23: invokestatic 124	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   26: ldc 120
    //   28: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload_0
    //   32: monitorexit
    //   33: iload_3
    //   34: ireturn
    //   35: invokestatic 45	com/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative:getInstance	()Lcom/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative;
    //   38: invokevirtual 49	com/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative:isNativeLoaded	()Z
    //   41: istore 4
    //   43: iload 4
    //   45: ifeq +299 -> 344
    //   48: aload_2
    //   49: invokevirtual 129	com/tencent/thumbplayer/core/downloadproxy/api/TPDLProxyInitParam:getAppVer	()Ljava/lang/String;
    //   52: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   55: ifne +13 -> 68
    //   58: aload_0
    //   59: ldc 137
    //   61: aload_2
    //   62: invokevirtual 129	com/tencent/thumbplayer/core/downloadproxy/api/TPDLProxyInitParam:getAppVer	()Ljava/lang/String;
    //   65: invokevirtual 141	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxy:setUserData	(Ljava/lang/String;Ljava/lang/Object;)V
    //   68: aload_2
    //   69: invokevirtual 144	com/tencent/thumbplayer/core/downloadproxy/api/TPDLProxyInitParam:getPlatform	()I
    //   72: ifle +16 -> 88
    //   75: aload_0
    //   76: ldc 146
    //   78: aload_2
    //   79: invokevirtual 144	com/tencent/thumbplayer/core/downloadproxy/api/TPDLProxyInitParam:getPlatform	()I
    //   82: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   85: invokevirtual 141	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxy:setUserData	(Ljava/lang/String;Ljava/lang/Object;)V
    //   88: aload_2
    //   89: invokevirtual 155	com/tencent/thumbplayer/core/downloadproxy/api/TPDLProxyInitParam:getGuid	()Ljava/lang/String;
    //   92: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   95: ifne +13 -> 108
    //   98: aload_0
    //   99: ldc 157
    //   101: aload_2
    //   102: invokevirtual 155	com/tencent/thumbplayer/core/downloadproxy/api/TPDLProxyInitParam:getGuid	()Ljava/lang/String;
    //   105: invokevirtual 141	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxy:setUserData	(Ljava/lang/String;Ljava/lang/Object;)V
    //   108: aload_2
    //   109: invokevirtual 160	com/tencent/thumbplayer/core/downloadproxy/api/TPDLProxyInitParam:getCacheDir	()Ljava/lang/String;
    //   112: astore 6
    //   114: aload 6
    //   116: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
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
    //   139: ldc 162
    //   141: invokestatic 168	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLFileSystem:getProperCacheDirectory	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   144: astore 7
    //   146: aload 6
    //   148: astore 5
    //   150: aload 7
    //   152: ifnull +10 -> 162
    //   155: aload 7
    //   157: invokevirtual 173	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   160: astore 5
    //   162: invokestatic 178	com/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager:getInstance	()Lcom/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager;
    //   165: invokevirtual 181	com/tencent/thumbplayer/core/downloadproxy/apiinner/TPListenerManager:initHandler	()V
    //   168: aload_2
    //   169: invokevirtual 184	com/tencent/thumbplayer/core/downloadproxy/api/TPDLProxyInitParam:getDataDir	()Ljava/lang/String;
    //   172: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   175: ifeq +179 -> 354
    //   178: aload_0
    //   179: getfield 26	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxy:mCurrentStoragePath	Ljava/lang/String;
    //   182: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   185: ifne +169 -> 354
    //   188: invokestatic 45	com/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative:getInstance	()Lcom/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative;
    //   191: aload_0
    //   192: getfield 30	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxy:mServiceType	I
    //   195: aload 5
    //   197: aload_0
    //   198: getfield 26	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxy:mCurrentStoragePath	Ljava/lang/String;
    //   201: aload_2
    //   202: invokevirtual 187	com/tencent/thumbplayer/core/downloadproxy/api/TPDLProxyInitParam:getConfigStr	()Ljava/lang/String;
    //   205: invokevirtual 191	com/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative:initService	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   208: istore_3
    //   209: new 193	android/content/IntentFilter
    //   212: dup
    //   213: invokespecial 194	android/content/IntentFilter:<init>	()V
    //   216: astore_2
    //   217: aload_2
    //   218: ldc 196
    //   220: invokevirtual 199	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   223: aload_2
    //   224: ldc 201
    //   226: invokevirtual 199	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   229: aload_2
    //   230: ldc 203
    //   232: invokevirtual 199	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   235: new 8	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxy$1
    //   238: dup
    //   239: aload_0
    //   240: invokespecial 206	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxy$1:<init>	(Lcom/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxy;)V
    //   243: astore 5
    //   245: aload_1
    //   246: ifnull +11 -> 257
    //   249: aload_1
    //   250: aload 5
    //   252: aload_2
    //   253: invokevirtual 212	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   256: pop
    //   257: iload_3
    //   258: ifne +8 -> 266
    //   261: aload_0
    //   262: iconst_1
    //   263: putfield 28	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxy:mIsInit	Z
    //   266: ldc 120
    //   268: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   271: goto -240 -> 31
    //   274: astore_1
    //   275: aload_0
    //   276: monitorexit
    //   277: aload_1
    //   278: athrow
    //   279: astore 5
    //   281: ldc 12
    //   283: iconst_0
    //   284: ldc 58
    //   286: new 60	java/lang/StringBuilder
    //   289: dup
    //   290: ldc 214
    //   292: invokespecial 65	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
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
    //   320: ldc 58
    //   322: new 60	java/lang/StringBuilder
    //   325: dup
    //   326: ldc 216
    //   328: invokespecial 65	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   331: aload_1
    //   332: invokevirtual 71	java/lang/Throwable:toString	()Ljava/lang/String;
    //   335: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokestatic 82	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   344: iconst_m1
    //   345: istore_3
    //   346: ldc 120
    //   348: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   351: goto -320 -> 31
    //   354: aload_2
    //   355: invokevirtual 184	com/tencent/thumbplayer/core/downloadproxy/api/TPDLProxyInitParam:getDataDir	()Ljava/lang/String;
    //   358: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   361: ifne +11 -> 372
    //   364: aload_0
    //   365: aload_2
    //   366: invokevirtual 184	com/tencent/thumbplayer/core/downloadproxy/api/TPDLProxyInitParam:getDataDir	()Ljava/lang/String;
    //   369: putfield 26	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxy:mCurrentStoragePath	Ljava/lang/String;
    //   372: invokestatic 45	com/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative:getInstance	()Lcom/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative;
    //   375: aload_0
    //   376: getfield 30	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxy:mServiceType	I
    //   379: aload 5
    //   381: aload_2
    //   382: invokevirtual 184	com/tencent/thumbplayer/core/downloadproxy/api/TPDLProxyInitParam:getDataDir	()Ljava/lang/String;
    //   385: aload_2
    //   386: invokevirtual 187	com/tencent/thumbplayer/core/downloadproxy/api/TPDLProxyInitParam:getConfigStr	()Ljava/lang/String;
    //   389: invokevirtual 191	com/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative:initService	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   392: istore_3
    //   393: goto -184 -> 209
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	396	0	this	TPDownloadProxy
    //   0	396	1	paramContext	Context
    //   0	396	2	paramTPDLProxyInitParam	TPDLProxyInitParam
    //   1	392	3	i	int
    //   41	85	4	bool	boolean
    //   123	128	5	localObject1	Object
    //   279	17	5	localObject2	Object
    //   311	69	5	str1	String
    //   112	198	6	str2	String
    //   144	12	7	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   4	31	274	finally
    //   35	43	274	finally
    //   266	271	274	finally
    //   317	344	274	finally
    //   346	351	274	finally
    //   138	146	279	finally
    //   155	162	279	finally
    //   48	68	316	finally
    //   68	88	316	finally
    //   88	108	316	finally
    //   108	121	316	finally
    //   162	209	316	finally
    //   209	245	316	finally
    //   249	257	316	finally
    //   261	266	316	finally
    //   281	309	316	finally
    //   354	372	316	finally
    //   372	393	316	finally
  }
  
  public int pauseDownload(int paramInt)
  {
    AppMethodBeat.i(228203);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(228203);
      return -1;
    }
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        paramInt = TPDownloadProxyNative.getInstance().pauseDownload(paramInt);
        AppMethodBeat.o(228203);
        return paramInt;
      }
      finally
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "pauseDownload failed, error:" + localObject.toString());
      }
    }
    AppMethodBeat.o(228203);
    return -1;
  }
  
  public void pushEvent(int paramInt)
  {
    AppMethodBeat.i(228260);
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        TPDownloadProxyNative.getInstance().pushEvent(paramInt);
        AppMethodBeat.o(228260);
        return;
      }
      finally
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "pushEvent failed, error:" + localObject.toString());
      }
    }
    AppMethodBeat.o(228260);
  }
  
  public int removeStorageCache(String paramString)
  {
    AppMethodBeat.i(228247);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(228247);
      return -1;
    }
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        int i = TPDownloadProxyNative.getInstance().deleteCache(this.mCurrentStoragePath, paramString);
        AppMethodBeat.o(228247);
        return i;
      }
      finally
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "deleteCache failed, error:" + paramString.toString());
      }
    }
    AppMethodBeat.o(228247);
    return -1;
  }
  
  public int resumeDownload(int paramInt)
  {
    AppMethodBeat.i(228208);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(228208);
      return -1;
    }
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        paramInt = TPDownloadProxyNative.getInstance().resumeDownload(paramInt);
        AppMethodBeat.o(228208);
        return paramInt;
      }
      finally
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "resumeDownload failed, error:" + localObject.toString());
      }
    }
    AppMethodBeat.o(228208);
    return -1;
  }
  
  /* Error */
  public boolean setClipInfo(int paramInt1, int paramInt2, String paramString, TPDownloadParam paramTPDownloadParam)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 8
    //   3: ldc 246
    //   5: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload 4
    //   10: invokevirtual 251	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadParam:getDlType	()I
    //   13: istore 6
    //   15: iload 6
    //   17: istore 5
    //   19: aload 4
    //   21: invokevirtual 254	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadParam:isOffline	()Z
    //   24: ifeq +11 -> 35
    //   27: iload 6
    //   29: sipush 300
    //   32: iadd
    //   33: istore 5
    //   35: iload 8
    //   37: istore 7
    //   39: invokestatic 45	com/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative:getInstance	()Lcom/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative;
    //   42: invokevirtual 49	com/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative:isNativeLoaded	()Z
    //   45: ifeq +37 -> 82
    //   48: invokestatic 45	com/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative:getInstance	()Lcom/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative;
    //   51: iload_1
    //   52: iload_2
    //   53: aload_3
    //   54: iload 5
    //   56: aload 4
    //   58: invokevirtual 257	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadParam:getCdnUrls	()Ljava/lang/String;
    //   61: aload 4
    //   63: invokevirtual 260	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadParam:getSavaPath	()Ljava/lang/String;
    //   66: aload 4
    //   68: invokevirtual 263	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadParam:getExtraJsonInfo	()Ljava/lang/String;
    //   71: invokevirtual 266	com/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative:setClipInfo	(IILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   74: istore_1
    //   75: iload_1
    //   76: iflt +14 -> 90
    //   79: iconst_1
    //   80: istore 7
    //   82: ldc 246
    //   84: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: iload 7
    //   89: ireturn
    //   90: iconst_0
    //   91: istore 7
    //   93: goto -11 -> 82
    //   96: astore_3
    //   97: ldc 12
    //   99: iconst_0
    //   100: ldc 58
    //   102: new 60	java/lang/StringBuilder
    //   105: dup
    //   106: ldc_w 268
    //   109: invokespecial 65	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   112: aload_3
    //   113: invokevirtual 71	java/lang/Throwable:toString	()Ljava/lang/String;
    //   116: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 82	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   125: iload 8
    //   127: istore 7
    //   129: goto -47 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	this	TPDownloadProxy
    //   0	132	1	paramInt1	int
    //   0	132	2	paramInt2	int
    //   0	132	3	paramString	String
    //   0	132	4	paramTPDownloadParam	TPDownloadParam
    //   17	38	5	i	int
    //   13	20	6	j	int
    //   37	91	7	bool1	boolean
    //   1	125	8	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   48	75	96	finally
  }
  
  public void setLogListener(ITPDLProxyLogListener paramITPDLProxyLogListener)
  {
    AppMethodBeat.i(228140);
    TPDLProxyLog.setLogListener(this.mServiceType, paramITPDLProxyLogListener);
    AppMethodBeat.o(228140);
  }
  
  public void setMaxStorageSizeMB(long paramLong)
  {
    AppMethodBeat.i(228244);
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        TPDownloadProxyNative.getInstance().setMaxStorageSizeMB(this.mServiceType, paramLong);
        AppMethodBeat.o(228244);
        return;
      }
      finally
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "setMaxStorageSizeMB failed, error:" + localObject.toString());
      }
    }
    AppMethodBeat.o(228244);
  }
  
  public void setPlayState(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(228266);
    if (paramInt1 <= 0)
    {
      AppMethodBeat.o(228266);
      return;
    }
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        TPDownloadProxyNative.getInstance().setPlayerState(paramInt1, paramInt2);
        AppMethodBeat.o(228266);
        return;
      }
      finally
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "setPlayState failed, error:" + localObject.toString());
      }
    }
    AppMethodBeat.o(228266);
  }
  
  public void setUserData(String paramString, Object paramObject)
  {
    AppMethodBeat.i(228253);
    if (TPDownloadProxyNative.getInstance().isNativeLoaded())
    {
      try
      {
        if (paramString.equalsIgnoreCase("app_version_name"))
        {
          TPDownloadProxyNative.getInstance().setUserData("app_version_name", (String)paramObject);
          AppMethodBeat.o(228253);
          return;
        }
        if (!paramString.equalsIgnoreCase("platform")) {
          break label107;
        }
        TPDownloadProxyNative.getInstance().setUserData("platform", paramObject.toString());
        AppMethodBeat.o(228253);
        return;
      }
      finally
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "setUserData failed, error:" + paramString.toString());
      }
    }
    else
    {
      AppMethodBeat.o(228253);
      return;
    }
    label107:
    if (paramString.equalsIgnoreCase("guid"))
    {
      TPDownloadProxyNative.getInstance().setUserData("guid", (String)paramObject);
      AppMethodBeat.o(228253);
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
      AppMethodBeat.o(228253);
      return;
      if (paramString.equalsIgnoreCase("carrier_pesudo_code"))
      {
        TPDownloadProxyNative.getInstance().setUserData("carrier_pesudo_code", (String)paramObject);
        AppMethodBeat.o(228253);
        return;
      }
      if (paramString.equalsIgnoreCase("carrier_pesudo_state"))
      {
        TPDownloadProxyNative.getInstance().setUserData("carrier_pesudo_state", paramObject.toString());
        AppMethodBeat.o(228253);
        return;
      }
      TPDownloadProxyNative.getInstance().setUserData(paramString, paramObject.toString());
      AppMethodBeat.o(228253);
      return;
    }
  }
  
  public int startClipOfflineDownload(String paramString, int paramInt, ITPOfflineDownloadListener paramITPOfflineDownloadListener)
  {
    AppMethodBeat.i(228229);
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
    finally
    {
      for (;;)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "startClipOfflineDownload failed, error:" + paramString.toString());
      }
    }
    AppMethodBeat.o(228229);
    return i;
  }
  
  public int startClipPlay(String paramString, int paramInt, ITPPlayListener paramITPPlayListener)
  {
    AppMethodBeat.i(228155);
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
    finally
    {
      for (;;)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "startClipPlay failed, error:" + paramString.toString());
      }
    }
    AppMethodBeat.o(228155);
    return i;
  }
  
  public int startOfflineDownload(String paramString, TPDownloadParam paramTPDownloadParam, ITPOfflineDownloadListener paramITPOfflineDownloadListener)
  {
    AppMethodBeat.i(228225);
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
      finally
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "stopOfflineDownload failed, error:" + paramString.toString());
        continue;
      }
      AppMethodBeat.o(228225);
      return i;
      i = j;
      paramString = paramTPDownloadParam.getKeyid();
    }
  }
  
  public int startPlay(String paramString, TPDownloadParam paramTPDownloadParam, ITPPlayListener paramITPPlayListener)
  {
    AppMethodBeat.i(228148);
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
    finally
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
      AppMethodBeat.o(228148);
      return j;
      j = k;
      paramString = paramTPDownloadParam.getKeyid();
    }
  }
  
  public int startPreload(String paramString, TPDownloadParam paramTPDownloadParam, ITPPreLoadListener paramITPPreLoadListener)
  {
    AppMethodBeat.i(228215);
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
      finally
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "startPreload failed, error:" + paramString.toString());
        continue;
      }
      AppMethodBeat.o(228215);
      return i;
      i = j;
      paramString = paramTPDownloadParam.getKeyid();
    }
  }
  
  public void startTask(int paramInt)
  {
    AppMethodBeat.i(228236);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(228236);
      return;
    }
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        TPDownloadProxyNative.getInstance().startDownload(paramInt);
        AppMethodBeat.o(228236);
        return;
      }
      finally
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "startTask failed, error:" + localObject.toString());
      }
    }
    AppMethodBeat.o(228236);
  }
  
  public void stopOfflineDownload(int paramInt)
  {
    AppMethodBeat.i(228233);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(228233);
      return;
    }
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        TPDownloadProxyNative.getInstance().stopDownload(paramInt);
        TPListenerManager.getInstance().removeOfflineDownloadListener(paramInt);
        AppMethodBeat.o(228233);
        return;
      }
      finally
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "stopOfflineDownload failed, error:" + localObject.toString());
      }
    }
    AppMethodBeat.o(228233);
  }
  
  public void stopPlay(int paramInt)
  {
    AppMethodBeat.i(228197);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(228197);
      return;
    }
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        TPDownloadProxyNative.getInstance().stopDownload(paramInt);
        TPListenerManager.getInstance().removePlayListener(paramInt);
        AppMethodBeat.o(228197);
        return;
      }
      finally
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "stopPlay failed, error:" + localObject.toString());
      }
    }
    AppMethodBeat.o(228197);
  }
  
  public void stopPreload(int paramInt)
  {
    AppMethodBeat.i(228219);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(228219);
      return;
    }
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        TPDownloadProxyNative.getInstance().stopDownload(paramInt);
        TPListenerManager.getInstance().removePreLoadListener(paramInt);
        AppMethodBeat.o(228219);
        return;
      }
      finally
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "stopPreload failed, error:" + localObject.toString());
      }
    }
    AppMethodBeat.o(228219);
  }
  
  public void updateStoragePath(String paramString)
  {
    AppMethodBeat.i(228241);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(228241);
      return;
    }
    try
    {
      this.mCurrentStoragePath = paramString;
      TPDownloadProxyNative.getInstance().updateStoragePath(this.mServiceType, paramString);
      AppMethodBeat.o(228241);
      return;
    }
    finally
    {
      TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "updateStoragePath failed, error:" + paramString.toString());
      AppMethodBeat.o(228241);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxy
 * JD-Core Version:    0.7.0.1
 */