package com.tencent.xweb;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal;
import com.tencent.xweb.internal.CookieInternal.ICookieSyncManagerInternal;
import com.tencent.xweb.internal.IWebStorage;
import com.tencent.xweb.internal.IWebView;
import com.tencent.xweb.internal.IWebViewDatabase;
import com.tencent.xweb.internal.WebViewWrapperFactory.IWebViewProvider;
import com.tencent.xweb.internal.b.c;
import com.tencent.xweb.xwalk.d;
import com.tencent.xweb.xwalk.updater.j;
import com.tencent.xweb.xwalk.updater.m;
import com.tencent.xweb.xwalk.updater.n;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtensionListener;
import org.xwalk.core.XWalkFileUtil;

public class XWebViewProvider
  implements WebViewWrapperFactory.IWebViewProvider
{
  public static final String TAG = "XWebViewProvider";
  private static XWebViewProvider sInstance;
  
  public static XWebViewProvider getInstance()
  {
    AppMethodBeat.i(213677);
    if (sInstance == null) {
      sInstance = new XWebViewProvider();
    }
    XWebViewProvider localXWebViewProvider = sInstance;
    AppMethodBeat.o(213677);
    return localXWebViewProvider;
  }
  
  /* Error */
  public static boolean tryLoadLocalAssetRuntime(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 37
    //   5: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 10
    //   10: ldc 39
    //   12: iload_1
    //   13: invokestatic 45	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   16: invokevirtual 49	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   19: invokestatic 54	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: aload_0
    //   23: invokestatic 60	org/xwalk/core/XWalkEnvironment:init	(Landroid/content/Context;)V
    //   26: iload_1
    //   27: ifeq +17 -> 44
    //   30: invokestatic 64	org/xwalk/core/XWalkEnvironment:getAvailableVersion	()I
    //   33: ldc 65
    //   35: if_icmpne +9 -> 44
    //   38: ldc 65
    //   40: invokestatic 71	com/tencent/xweb/xwalk/updater/f:aJS	(I)Z
    //   43: pop
    //   44: invokestatic 64	org/xwalk/core/XWalkEnvironment:getAvailableVersion	()I
    //   47: istore_2
    //   48: iload_2
    //   49: iconst_m1
    //   50: if_icmpeq +7 -> 57
    //   53: iload_1
    //   54: ifeq +114 -> 168
    //   57: aload_0
    //   58: invokevirtual 77	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   61: ldc 79
    //   63: invokevirtual 85	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   66: astore_3
    //   67: new 87	java/io/File
    //   70: dup
    //   71: ldc 65
    //   73: invokestatic 93	org/xwalk/core/XWalkFileUtil:getDownloadZipPath	(I)Ljava/lang/String;
    //   76: invokespecial 96	java/io/File:<init>	(Ljava/lang/String;)V
    //   79: astore 4
    //   81: aload 4
    //   83: invokevirtual 100	java/io/File:exists	()Z
    //   86: ifeq +9 -> 95
    //   89: aload 4
    //   91: invokevirtual 103	java/io/File:delete	()Z
    //   94: pop
    //   95: new 105	java/io/FileOutputStream
    //   98: dup
    //   99: aload 4
    //   101: invokespecial 108	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   104: astore 4
    //   106: ldc 109
    //   108: newarray byte
    //   110: astore 5
    //   112: aload_3
    //   113: aload 5
    //   115: invokevirtual 115	java/io/InputStream:read	([B)I
    //   118: istore_2
    //   119: iload_2
    //   120: iconst_m1
    //   121: if_icmpeq +59 -> 180
    //   124: aload 4
    //   126: aload 5
    //   128: iconst_0
    //   129: iload_2
    //   130: invokevirtual 119	java/io/FileOutputStream:write	([BII)V
    //   133: goto -21 -> 112
    //   136: astore 5
    //   138: aload 4
    //   140: astore_0
    //   141: aload 5
    //   143: astore 4
    //   145: ldc 10
    //   147: ldc 121
    //   149: aload 4
    //   151: invokestatic 124	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   154: invokevirtual 49	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   157: invokestatic 127	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: aload_3
    //   161: invokestatic 133	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   164: aload_0
    //   165: invokestatic 133	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   168: ldc 37
    //   170: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   173: iconst_0
    //   174: istore_1
    //   175: ldc 2
    //   177: monitorexit
    //   178: iload_1
    //   179: ireturn
    //   180: aload 4
    //   182: invokevirtual 136	java/io/FileOutputStream:flush	()V
    //   185: new 138	com/tencent/xweb/xwalk/o
    //   188: dup
    //   189: aload_0
    //   190: aconst_null
    //   191: invokespecial 141	com/tencent/xweb/xwalk/o:<init>	(Landroid/content/Context;Lcom/tencent/xweb/xwalk/updater/i;)V
    //   194: new 143	com/tencent/xweb/xwalk/updater/UpdateConfig
    //   197: dup
    //   198: ldc 79
    //   200: iconst_0
    //   201: ldc 65
    //   203: invokestatic 149	com/tencent/xweb/util/b:khw	()Ljava/lang/String;
    //   206: iconst_0
    //   207: invokespecial 152	com/tencent/xweb/xwalk/updater/UpdateConfig:<init>	(Ljava/lang/String;ZILjava/lang/String;I)V
    //   210: invokevirtual 156	com/tencent/xweb/xwalk/o:a	(Lcom/tencent/xweb/xwalk/updater/UpdateConfig;)Ljava/lang/Integer;
    //   213: pop
    //   214: invokestatic 159	org/xwalk/core/XWalkEnvironment:reset	()V
    //   217: aload_0
    //   218: invokestatic 60	org/xwalk/core/XWalkEnvironment:init	(Landroid/content/Context;)V
    //   221: aload_3
    //   222: invokestatic 133	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   225: aload 4
    //   227: invokestatic 133	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   230: iconst_1
    //   231: istore_1
    //   232: ldc 37
    //   234: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   237: goto -62 -> 175
    //   240: astore_0
    //   241: ldc 2
    //   243: monitorexit
    //   244: aload_0
    //   245: athrow
    //   246: astore_0
    //   247: aconst_null
    //   248: astore 4
    //   250: aconst_null
    //   251: astore_3
    //   252: aload_3
    //   253: invokestatic 133	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   256: aload 4
    //   258: invokestatic 133	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   261: ldc 37
    //   263: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   266: aload_0
    //   267: athrow
    //   268: astore_0
    //   269: aconst_null
    //   270: astore 4
    //   272: goto -20 -> 252
    //   275: astore_0
    //   276: goto -24 -> 252
    //   279: astore 5
    //   281: aload_0
    //   282: astore 4
    //   284: aload 5
    //   286: astore_0
    //   287: goto -35 -> 252
    //   290: astore 4
    //   292: aconst_null
    //   293: astore_0
    //   294: aconst_null
    //   295: astore_3
    //   296: goto -151 -> 145
    //   299: astore 4
    //   301: aconst_null
    //   302: astore_0
    //   303: goto -158 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	306	0	paramContext	Context
    //   0	306	1	paramBoolean	boolean
    //   47	83	2	i	int
    //   66	230	3	localInputStream	java.io.InputStream
    //   79	204	4	localObject1	Object
    //   290	1	4	localIOException1	java.io.IOException
    //   299	1	4	localIOException2	java.io.IOException
    //   110	17	5	arrayOfByte	byte[]
    //   136	6	5	localIOException3	java.io.IOException
    //   279	6	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   106	112	136	java/io/IOException
    //   112	119	136	java/io/IOException
    //   124	133	136	java/io/IOException
    //   180	221	136	java/io/IOException
    //   3	26	240	finally
    //   30	44	240	finally
    //   44	48	240	finally
    //   160	168	240	finally
    //   168	173	240	finally
    //   221	230	240	finally
    //   232	237	240	finally
    //   252	268	240	finally
    //   57	67	246	finally
    //   67	95	268	finally
    //   95	106	268	finally
    //   106	112	275	finally
    //   112	119	275	finally
    //   124	133	275	finally
    //   180	221	275	finally
    //   145	160	279	finally
    //   57	67	290	java/io/IOException
    //   67	95	299	java/io/IOException
    //   95	106	299	java/io/IOException
  }
  
  public void clearAllWebViewCache(Context paramContext, boolean paramBoolean) {}
  
  public IWebView createWebView(WebView paramWebView)
  {
    return null;
  }
  
  public IWebStorage createWebviewStorage()
  {
    return null;
  }
  
  public Object excute(String paramString, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(213723);
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(213723);
      return null;
      if (!paramString.equals("STR_CMD_EXXCUTE_CMD_FROM_CONFIG")) {
        break;
      }
      i = 0;
      break;
      if (!paramString.equals("STR_CMD_GET_DEBUG_VIEW")) {
        break;
      }
      i = 1;
      break;
      if (!paramString.equals("STR_CMD_GET_UPDATER")) {
        break;
      }
      i = 2;
      break;
      if (!paramString.equals("STR_CMD_GET_PLUGIN_UPDATER")) {
        break;
      }
      i = 3;
      break;
      if (!paramString.equals("STR_CMD_CLEAR_SCHEDULER")) {
        break;
      }
      i = 4;
      break;
      if (!paramString.equals("STR_CMD_SET_RECHECK_COMMAND")) {
        break;
      }
      i = 5;
      break;
      if (!paramString.equals("STR_CMD_SET_DEBUG_MODE_REPLACE_NOW")) {
        break;
      }
      i = 6;
      break;
      if ((paramArrayOfObject == null) || (paramArrayOfObject.length <= 0))
      {
        AppMethodBeat.o(213723);
        return null;
      }
      paramString = com.tencent.xweb.xwalk.a.hp(paramArrayOfObject[0]);
      AppMethodBeat.o(213723);
      return paramString;
      paramString = new d((WebView)paramArrayOfObject[0]);
      AppMethodBeat.o(213723);
      return paramString;
      paramString = new j();
      AppMethodBeat.o(213723);
      return paramString;
      paramString = new com.tencent.xweb.xwalk.a.l();
      AppMethodBeat.o(213723);
      return paramString;
      m.kkp().kjO();
      n.kkq().kjO();
      AppMethodBeat.o(213723);
      return null;
      try
      {
        paramString = com.tencent.xweb.xwalk.updater.a.bIr(XWalkFileUtil.getUpdateConfigFullPath());
        if (paramString == null)
        {
          Log.i("XWebViewProvider", "recheck cmds ConfigParser failed");
          AppMethodBeat.o(213723);
          return null;
        }
        a.keX().a(paramString.aiiW, paramString.aiiU, true);
        com.tencent.xweb.util.l.Br(68L);
        continue;
      }
      finally
      {
        Log.i("XWebViewProvider", "recheck cmds failed, error:".concat(String.valueOf(paramString)));
      }
      continue;
      tryLoadLocalAssetRuntime((Context)paramArrayOfObject[0], true);
      d.lJ((Context)paramArrayOfObject[0]);
    }
  }
  
  public CookieInternal.ICookieManagerInternal getCookieManager()
  {
    return null;
  }
  
  public CookieInternal.ICookieSyncManagerInternal getCookieSyncManager()
  {
    return null;
  }
  
  public IWebViewDatabase getWebViewDatabase()
  {
    return null;
  }
  
  public boolean hasInited()
  {
    return false;
  }
  
  public boolean hasInitedCallback()
  {
    return false;
  }
  
  public void initEnviroment(Context paramContext) {}
  
  public void initInterface() {}
  
  public void initWebViewExtensionListener(WebViewExtensionListener paramWebViewExtensionListener) {}
  
  public boolean initWebviewCore(Context paramContext, WebView.PreInitCallback paramPreInitCallback)
  {
    return false;
  }
  
  public boolean isCoreReady()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.XWebViewProvider
 * JD-Core Version:    0.7.0.1
 */