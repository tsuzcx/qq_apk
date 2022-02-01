package com.tencent.xweb;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Debug;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.WebViewWrapperFactory;
import com.tencent.xweb.internal.WebViewWrapperFactory.IWebViewProvider;
import com.tencent.xweb.xwalk.a.i;
import com.tencent.xweb.xwalk.a.n;
import java.util.Iterator;
import java.util.List;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkSharedPreferenceUtil;
import org.xwalk.core.XWalkUpdateConfigUtil;

public final class aa
{
  private static aa aifc = null;
  private WebView.WebViewKind aifd = WebView.WebViewKind.aifH;
  public boolean aife = false;
  public boolean aiff = false;
  public boolean aifg = false;
  public boolean aifh = false;
  public boolean aifi = false;
  public boolean aifj = false;
  public boolean aifk = false;
  public boolean aifl = false;
  private Context mContext;
  
  public static void OO(boolean paramBoolean)
  {
    AppMethodBeat.i(212540);
    Object localObject1 = XWalkSharedPreferenceUtil.getSharedPreferencesForWebDebug();
    if (localObject1 == null)
    {
      AppMethodBeat.o(212540);
      return;
    }
    localObject1 = ((SharedPreferences)localObject1).edit();
    if (localObject1 == null)
    {
      AppMethodBeat.o(212540);
      return;
    }
    ((SharedPreferences.Editor)localObject1).putBoolean("fr_disable_cache", paramBoolean);
    ((SharedPreferences.Editor)localObject1).commit();
    if (paramBoolean)
    {
      localObject1 = i.kjC().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (com.tencent.xweb.xwalk.a.g)((Iterator)localObject1).next();
        if ((localObject2 instanceof n))
        {
          int i = ((com.tencent.xweb.xwalk.a.g)localObject2).kjy();
          if (i >= 0)
          {
            localObject2 = ((com.tencent.xweb.xwalk.a.g)localObject2).aJN(i);
            if (!((String)localObject2).isEmpty()) {
              com.tencent.xweb.util.g.bHZ((String)localObject2);
            }
          }
        }
      }
    }
    AppMethodBeat.o(212540);
  }
  
  public static void OP(boolean paramBoolean)
  {
    AppMethodBeat.i(212546);
    Object localObject = XWalkSharedPreferenceUtil.getSharedPreferencesForWebDebug();
    if (localObject == null)
    {
      AppMethodBeat.o(212546);
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    if (localObject == null)
    {
      AppMethodBeat.o(212546);
      return;
    }
    ((SharedPreferences.Editor)localObject).putBoolean("fr_disable_crash_detect", paramBoolean);
    ((SharedPreferences.Editor)localObject).commit();
    AppMethodBeat.o(212546);
  }
  
  public static void OR(boolean paramBoolean)
  {
    AppMethodBeat.i(212550);
    XWalkSharedPreferenceUtil.getSharedPreferencesForWebDebug().edit().putBoolean("m_bEnableLocalDebug", true).commit();
    XWalkEnvironment.isTurnOnKVLog();
    AppMethodBeat.o(212550);
  }
  
  public static void OS(boolean paramBoolean)
  {
    AppMethodBeat.i(212555);
    XWalkSharedPreferenceUtil.getSharedPreferencesForWebDebug().edit().putBoolean("bEnableCheckStorage", paramBoolean).commit();
    AppMethodBeat.o(212555);
  }
  
  public static String a(String[] paramArrayOfString, h.a parama)
  {
    AppMethodBeat.i(156789);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      AppMethodBeat.o(156789);
      return "";
    }
    Object localObject = XWalkSharedPreferenceUtil.getSharedPreferencesForWebDebug();
    if (localObject == null)
    {
      AppMethodBeat.o(156789);
      return "";
    }
    localObject = ((SharedPreferences)localObject).edit();
    if (localObject == null)
    {
      AppMethodBeat.o(156789);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int k = paramArrayOfString.length;
    int i = 0;
    while (i < k)
    {
      String str1 = paramArrayOfString[i];
      String[] arrayOfString = h.aier;
      int m = arrayOfString.length;
      int j = 0;
      while (j < m)
      {
        String str2 = arrayOfString[j];
        if (str2.equalsIgnoreCase(str1))
        {
          ((SharedPreferences.Editor)localObject).putString("force_fr_" + str1.toLowerCase(), parama.toString());
          localStringBuilder.append(str2).append(",");
        }
        j += 1;
      }
      i += 1;
    }
    if (((SharedPreferences.Editor)localObject).commit())
    {
      paramArrayOfString = localStringBuilder.toString();
      AppMethodBeat.o(156789);
      return paramArrayOfString;
    }
    AppMethodBeat.o(156789);
    return "";
  }
  
  public static String a(String[] paramArrayOfString, h.c paramc)
  {
    AppMethodBeat.i(212535);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      AppMethodBeat.o(212535);
      return "";
    }
    Object localObject = XWalkSharedPreferenceUtil.getSharedPreferencesForWebDebug();
    if (localObject == null)
    {
      AppMethodBeat.o(212535);
      return "";
    }
    localObject = ((SharedPreferences)localObject).edit();
    if (localObject == null)
    {
      AppMethodBeat.o(212535);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int k = paramArrayOfString.length;
    int i = 0;
    while (i < k)
    {
      String str1 = paramArrayOfString[i];
      String[] arrayOfString = h.aier;
      int m = arrayOfString.length;
      int j = 0;
      while (j < m)
      {
        String str2 = arrayOfString[j];
        if (str2.equalsIgnoreCase(str1))
        {
          ((SharedPreferences.Editor)localObject).putString("force_use_office_reader_" + str1.toLowerCase(), paramc.toString());
          localStringBuilder.append(str2).append(",");
        }
        j += 1;
      }
      i += 1;
    }
    if (((SharedPreferences.Editor)localObject).commit())
    {
      paramArrayOfString = localStringBuilder.toString();
      AppMethodBeat.o(212535);
      return paramArrayOfString;
    }
    AppMethodBeat.o(212535);
    return "";
  }
  
  public static void bHF(String paramString)
  {
    AppMethodBeat.i(212511);
    XWalkSharedPreferenceUtil.getSharedPreferencesForWebDebug().edit().putString("strDebugProcess", paramString).commit();
    AppMethodBeat.o(212511);
  }
  
  public static h.a bHH(String paramString)
  {
    AppMethodBeat.i(156788);
    SharedPreferences localSharedPreferences = XWalkSharedPreferenceUtil.getSharedPreferencesForWebDebug();
    if (localSharedPreferences == null)
    {
      paramString = h.a.aiet;
      AppMethodBeat.o(156788);
      return paramString;
    }
    paramString = b.bHp(localSharedPreferences.getString("force_fr_" + paramString.toLowerCase(), ""));
    AppMethodBeat.o(156788);
    return paramString;
  }
  
  public static h.c bHI(String paramString)
  {
    AppMethodBeat.i(212529);
    try
    {
      SharedPreferences localSharedPreferences = XWalkSharedPreferenceUtil.getSharedPreferencesForWebDebug();
      if (localSharedPreferences == null)
      {
        paramString = h.c.aiey;
        AppMethodBeat.o(212529);
        return paramString;
      }
      paramString = b.bHo(localSharedPreferences.getString("force_use_office_reader_" + paramString.toLowerCase(), ""));
      AppMethodBeat.o(212529);
      return paramString;
    }
    finally
    {
      Log.e("WebDebugCfg", "getForceUseOfficeReader error:".concat(String.valueOf(paramString)));
      paramString = h.c.aiey;
      AppMethodBeat.o(212529);
    }
    return paramString;
  }
  
  public static aa kfE()
  {
    return aifc;
  }
  
  public static boolean kfF()
  {
    AppMethodBeat.i(156790);
    SharedPreferences localSharedPreferences = XWalkSharedPreferenceUtil.getSharedPreferencesForWebDebug();
    if (localSharedPreferences == null)
    {
      AppMethodBeat.o(156790);
      return false;
    }
    boolean bool = localSharedPreferences.getBoolean("fr_disable_cache", false);
    AppMethodBeat.o(156790);
    return bool;
  }
  
  public static boolean kfG()
  {
    AppMethodBeat.i(212542);
    SharedPreferences localSharedPreferences = XWalkSharedPreferenceUtil.getSharedPreferencesForWebDebug();
    if (localSharedPreferences == null)
    {
      AppMethodBeat.o(212542);
      return true;
    }
    boolean bool = localSharedPreferences.getBoolean("fr_disable_encry", true);
    AppMethodBeat.o(212542);
    return bool;
  }
  
  public static boolean kfH()
  {
    AppMethodBeat.i(156791);
    SharedPreferences localSharedPreferences = XWalkSharedPreferenceUtil.getSharedPreferencesForWebDebug();
    if (localSharedPreferences == null)
    {
      AppMethodBeat.o(156791);
      return false;
    }
    boolean bool = localSharedPreferences.getBoolean("fr_disable_crash_detect", false);
    AppMethodBeat.o(156791);
    return bool;
  }
  
  public static boolean kfI()
  {
    AppMethodBeat.i(156795);
    boolean bool = XWalkSharedPreferenceUtil.getSharedPreferencesForWebDebug().getBoolean("m_bEnableLocalDebug", false);
    AppMethodBeat.o(156795);
    return bool;
  }
  
  public static boolean kfJ()
  {
    AppMethodBeat.i(212558);
    boolean bool = XWalkSharedPreferenceUtil.getSharedPreferencesForWebDebug().getBoolean("bEnableCheckStorage", false);
    AppMethodBeat.o(212558);
    return bool;
  }
  
  public static void oP(Context paramContext)
  {
    AppMethodBeat.i(156781);
    if (aifc != null)
    {
      Log.w("WebDebugCfg", "load, already load");
      AppMethodBeat.o(156781);
      return;
    }
    Log.w("WebDebugCfg", "load start");
    aa localaa = new aa();
    aifc = localaa;
    localaa.mContext = paramContext.getApplicationContext();
    XWalkEnvironment.init(paramContext);
    aifc.aiff = XWalkSharedPreferenceUtil.getSharedPreferencesForWebDebug().getBoolean("bShowVersion", false);
    aifc.aifg = XWalkSharedPreferenceUtil.getSharedPreferencesForWebDebug().getBoolean("bShowX5Version", false);
    aifc.aifh = XWalkSharedPreferenceUtil.getSharedPreferencesForWebDebug().getBoolean("bShowSavePage", false);
    aifc.aife = XWalkSharedPreferenceUtil.getSharedPreferencesForXWalkCore().getBoolean("ENABLEREMOTEDEBUG", false);
    paramContext = XWalkUpdateConfigUtil.getTestBaseConfigUrl(paramContext);
    localaa = aifc;
    if ((paramContext != null) && (!paramContext.isEmpty())) {}
    for (boolean bool = true;; bool = false)
    {
      localaa.aifk = bool;
      aifc.aifi = XWalkSharedPreferenceUtil.getSharedPreferencesForWebDebug().getBoolean("bWaitforDebugger", false);
      if (aifc.aifi)
      {
        paramContext = XWalkSharedPreferenceUtil.getSharedPreferencesForWebDebug().getString("strDebugProcess", "");
        if ((paramContext != null) && (paramContext.equals(XWalkEnvironment.getProcessName())))
        {
          Debug.waitForDebugger();
          Log.w("WebDebugCfg", "load, strDebugProcess is ".concat(String.valueOf(paramContext)));
        }
      }
      aifc.aifj = XWalkSharedPreferenceUtil.getSharedPreferencesForWebDebug().getBoolean("ignore_crashwatch", false);
      aifc.aifl = XWalkSharedPreferenceUtil.getSharedPreferencesForWebDebug().getBoolean("show_fps", false);
      Log.w("WebDebugCfg", "load end");
      AppMethodBeat.o(156781);
      return;
    }
  }
  
  public final void ON(boolean paramBoolean)
  {
    AppMethodBeat.i(156787);
    if (paramBoolean == this.aifh)
    {
      AppMethodBeat.o(156787);
      return;
    }
    this.aifh = paramBoolean;
    XWalkSharedPreferenceUtil.getSharedPreferencesForWebDebug().edit().putBoolean("bShowSavePage", this.aifh).commit();
    AppMethodBeat.o(156787);
  }
  
  public final void OQ(boolean paramBoolean)
  {
    AppMethodBeat.i(156793);
    if (paramBoolean == this.aifk)
    {
      AppMethodBeat.o(156793);
      return;
    }
    this.aifk = paramBoolean;
    if (this.aifk)
    {
      if (com.tencent.xweb.util.b.khu()) {
        ao.setTestBaseConfigUrl("https://dldir1v6.qq.com/weixin/android/wxweb/updateConfig_x86_test.xml");
      }
      for (;;)
      {
        localObject = XWalkSharedPreferenceUtil.getSharedPreferencesForUpdateConfig().edit();
        ((SharedPreferences.Editor)localObject).putLong("nLastFetchConfigTime", 0L);
        ((SharedPreferences.Editor)localObject).commit();
        localObject = WebViewWrapperFactory.khn();
        if (localObject != null) {
          ((WebViewWrapperFactory.IWebViewProvider)localObject).excute("STR_CMD_CLEAR_SCHEDULER", null);
        }
        AppMethodBeat.o(156793);
        return;
        ao.setTestBaseConfigUrl("https://dldir1v6.qq.com/weixin/android/wxweb/updateConfig_test.xml");
      }
    }
    ao.setTestBaseConfigUrl("");
    Object localObject = XWalkSharedPreferenceUtil.getSharedPreferencesForUpdateConfig().edit();
    ((SharedPreferences.Editor)localObject).putLong("nLastFetchConfigTime", 0L);
    ((SharedPreferences.Editor)localObject).commit();
    localObject = WebViewWrapperFactory.khn();
    if (localObject != null) {
      ((WebViewWrapperFactory.IWebViewProvider)localObject).excute("STR_CMD_CLEAR_SCHEDULER", null);
    }
    AppMethodBeat.o(156793);
  }
  
  public final void a(String paramString, WebView.WebViewKind paramWebViewKind)
  {
    AppMethodBeat.i(156783);
    if ((this.mContext == null) || (paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(156783);
      return;
    }
    XWalkSharedPreferenceUtil.getMMKVSharedPreferenceForWebViewKind().edit().putString("HardCodeWebView".concat(String.valueOf(paramString)), paramWebViewKind.toString()).commit();
    AppMethodBeat.o(156783);
  }
  
  public final void b(String paramString, WebView.WebViewKind paramWebViewKind)
  {
    AppMethodBeat.i(156784);
    if ((this.mContext == null) || (paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(156784);
      return;
    }
    XWalkSharedPreferenceUtil.getMMKVSharedPreferenceForWebViewKind().edit().putString("ABTestWebView".concat(String.valueOf(paramString)), paramWebViewKind.toString()).commit();
    AppMethodBeat.o(156784);
  }
  
  /* Error */
  public final WebView.WebViewKind bHG(String paramString)
  {
    // Byte code:
    //   0: ldc_w 379
    //   3: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnull +17 -> 24
    //   10: aload_1
    //   11: invokevirtual 124	java/lang/String:isEmpty	()Z
    //   14: ifne +10 -> 24
    //   17: aload_0
    //   18: getfield 281	com/tencent/xweb/aa:mContext	Landroid/content/Context;
    //   21: ifnonnull +15 -> 36
    //   24: getstatic 32	com/tencent/xweb/WebView$WebViewKind:aifH	Lcom/tencent/xweb/WebView$WebViewKind;
    //   27: astore_1
    //   28: ldc_w 379
    //   31: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: aload_1
    //   35: areturn
    //   36: invokestatic 369	org/xwalk/core/XWalkSharedPreferenceUtil:getMMKVSharedPreferenceForWebViewKind	()Landroid/content/SharedPreferences;
    //   39: astore 4
    //   41: aload 4
    //   43: ifnonnull +15 -> 58
    //   46: getstatic 32	com/tencent/xweb/WebView$WebViewKind:aifH	Lcom/tencent/xweb/WebView$WebViewKind;
    //   49: astore_1
    //   50: ldc_w 379
    //   53: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: aload_1
    //   57: areturn
    //   58: aload 4
    //   60: ldc_w 371
    //   63: aload_1
    //   64: invokestatic 234	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   67: invokevirtual 238	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   70: ldc 152
    //   72: invokeinterface 211 3 0
    //   77: astore_3
    //   78: aload_3
    //   79: ifnull +25 -> 104
    //   82: aload_3
    //   83: invokevirtual 124	java/lang/String:isEmpty	()Z
    //   86: ifne +18 -> 104
    //   89: ldc 228
    //   91: ldc_w 381
    //   94: aload_3
    //   95: invokestatic 234	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   98: invokevirtual 238	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   101: invokestatic 383	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: aload_3
    //   105: ifnull +25 -> 130
    //   108: aload_3
    //   109: invokevirtual 124	java/lang/String:isEmpty	()Z
    //   112: ifne +18 -> 130
    //   115: aload_3
    //   116: astore_2
    //   117: aload_3
    //   118: getstatic 32	com/tencent/xweb/WebView$WebViewKind:aifH	Lcom/tencent/xweb/WebView$WebViewKind;
    //   121: invokevirtual 372	com/tencent/xweb/WebView$WebViewKind:toString	()Ljava/lang/String;
    //   124: invokevirtual 310	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   127: ifeq +55 -> 182
    //   130: aload 4
    //   132: ldc_w 376
    //   135: aload_1
    //   136: invokestatic 234	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   139: invokevirtual 238	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   142: ldc 152
    //   144: invokeinterface 211 3 0
    //   149: astore_1
    //   150: aload_1
    //   151: astore_2
    //   152: aload_1
    //   153: ifnull +29 -> 182
    //   156: aload_1
    //   157: astore_2
    //   158: aload_1
    //   159: invokevirtual 124	java/lang/String:isEmpty	()Z
    //   162: ifne +20 -> 182
    //   165: ldc 228
    //   167: ldc_w 385
    //   170: aload_1
    //   171: invokestatic 234	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   174: invokevirtual 238	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   177: invokestatic 383	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   180: aload_1
    //   181: astore_2
    //   182: aload_2
    //   183: ifnull +10 -> 193
    //   186: aload_2
    //   187: invokevirtual 124	java/lang/String:isEmpty	()Z
    //   190: ifeq +23 -> 213
    //   193: aload_0
    //   194: getstatic 32	com/tencent/xweb/WebView$WebViewKind:aifH	Lcom/tencent/xweb/WebView$WebViewKind;
    //   197: putfield 34	com/tencent/xweb/aa:aifd	Lcom/tencent/xweb/WebView$WebViewKind;
    //   200: aload_0
    //   201: getfield 34	com/tencent/xweb/aa:aifd	Lcom/tencent/xweb/WebView$WebViewKind;
    //   204: astore_1
    //   205: ldc_w 379
    //   208: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   211: aload_1
    //   212: areturn
    //   213: aload_0
    //   214: aload_2
    //   215: invokestatic 387	com/tencent/xweb/WebView$WebViewKind:valueOf	(Ljava/lang/String;)Lcom/tencent/xweb/WebView$WebViewKind;
    //   218: putfield 34	com/tencent/xweb/aa:aifd	Lcom/tencent/xweb/WebView$WebViewKind;
    //   221: goto -21 -> 200
    //   224: astore_1
    //   225: aload_0
    //   226: getstatic 32	com/tencent/xweb/WebView$WebViewKind:aifH	Lcom/tencent/xweb/WebView$WebViewKind;
    //   229: putfield 34	com/tencent/xweb/aa:aifd	Lcom/tencent/xweb/WebView$WebViewKind;
    //   232: goto -32 -> 200
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	235	0	this	aa
    //   0	235	1	paramString	String
    //   116	99	2	str1	String
    //   77	41	3	str2	String
    //   39	92	4	localSharedPreferences	SharedPreferences
    // Exception table:
    //   from	to	target	type
    //   213	221	224	finally
  }
  
  /* Error */
  public final WebView.WebViewKind eJ(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 390
    //   3: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnull +17 -> 24
    //   10: aload_1
    //   11: invokevirtual 124	java/lang/String:isEmpty	()Z
    //   14: ifne +10 -> 24
    //   17: aload_0
    //   18: getfield 281	com/tencent/xweb/aa:mContext	Landroid/content/Context;
    //   21: ifnonnull +15 -> 36
    //   24: getstatic 32	com/tencent/xweb/WebView$WebViewKind:aifH	Lcom/tencent/xweb/WebView$WebViewKind;
    //   27: astore_1
    //   28: ldc_w 390
    //   31: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: aload_1
    //   35: areturn
    //   36: invokestatic 369	org/xwalk/core/XWalkSharedPreferenceUtil:getMMKVSharedPreferenceForWebViewKind	()Landroid/content/SharedPreferences;
    //   39: astore_3
    //   40: aload_3
    //   41: ifnonnull +15 -> 56
    //   44: getstatic 32	com/tencent/xweb/WebView$WebViewKind:aifH	Lcom/tencent/xweb/WebView$WebViewKind;
    //   47: astore_1
    //   48: ldc_w 390
    //   51: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: aload_1
    //   55: areturn
    //   56: iload_2
    //   57: ifeq +53 -> 110
    //   60: aload_3
    //   61: ldc_w 376
    //   64: aload_1
    //   65: invokestatic 234	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   68: invokevirtual 238	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   71: ldc 152
    //   73: invokeinterface 211 3 0
    //   78: astore_1
    //   79: aload_1
    //   80: ifnull +10 -> 90
    //   83: aload_1
    //   84: invokevirtual 124	java/lang/String:isEmpty	()Z
    //   87: ifeq +45 -> 132
    //   90: aload_0
    //   91: getstatic 32	com/tencent/xweb/WebView$WebViewKind:aifH	Lcom/tencent/xweb/WebView$WebViewKind;
    //   94: putfield 34	com/tencent/xweb/aa:aifd	Lcom/tencent/xweb/WebView$WebViewKind;
    //   97: aload_0
    //   98: getfield 34	com/tencent/xweb/aa:aifd	Lcom/tencent/xweb/WebView$WebViewKind;
    //   101: astore_1
    //   102: ldc_w 390
    //   105: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: aload_1
    //   109: areturn
    //   110: aload_3
    //   111: ldc_w 371
    //   114: aload_1
    //   115: invokestatic 234	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   118: invokevirtual 238	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   121: ldc 152
    //   123: invokeinterface 211 3 0
    //   128: astore_1
    //   129: goto -50 -> 79
    //   132: aload_0
    //   133: aload_1
    //   134: invokestatic 387	com/tencent/xweb/WebView$WebViewKind:valueOf	(Ljava/lang/String;)Lcom/tencent/xweb/WebView$WebViewKind;
    //   137: putfield 34	com/tencent/xweb/aa:aifd	Lcom/tencent/xweb/WebView$WebViewKind;
    //   140: goto -43 -> 97
    //   143: astore_1
    //   144: aload_0
    //   145: getstatic 32	com/tencent/xweb/WebView$WebViewKind:aifH	Lcom/tencent/xweb/WebView$WebViewKind;
    //   148: putfield 34	com/tencent/xweb/aa:aifd	Lcom/tencent/xweb/WebView$WebViewKind;
    //   151: goto -54 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	aa
    //   0	154	1	paramString	String
    //   0	154	2	paramBoolean	boolean
    //   39	72	3	localSharedPreferences	SharedPreferences
    // Exception table:
    //   from	to	target	type
    //   132	140	143	finally
  }
  
  public final void setDebugEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(156785);
    if (paramBoolean == this.aife)
    {
      AppMethodBeat.o(156785);
      return;
    }
    this.aife = paramBoolean;
    XWalkSharedPreferenceUtil.getSharedPreferencesForXWalkCore().edit().putBoolean("ENABLEREMOTEDEBUG", paramBoolean).commit();
    AppMethodBeat.o(156785);
  }
  
  public final void setShowFps(boolean paramBoolean)
  {
    AppMethodBeat.i(156786);
    if (paramBoolean == this.aifl)
    {
      AppMethodBeat.o(156786);
      return;
    }
    this.aifl = paramBoolean;
    XWalkSharedPreferenceUtil.getSharedPreferencesForWebDebug().edit().putBoolean("show_fps", paramBoolean).commit();
    AppMethodBeat.o(156786);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.aa
 * JD-Core Version:    0.7.0.1
 */