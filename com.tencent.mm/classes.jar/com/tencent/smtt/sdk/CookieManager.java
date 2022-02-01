package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5CoreCookieManager;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.k;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class CookieManager
  extends x
{
  public static String LOGTAG = "CookieManager";
  private static CookieManager d;
  CopyOnWriteArrayList<b> a;
  String b;
  CookieManager.a c = CookieManager.a.a;
  private boolean e = false;
  private boolean f = false;
  
  public static CookieManager getInstance()
  {
    AppMethodBeat.i(54874);
    if (d == null) {}
    try
    {
      if (d == null) {
        d = new CookieManager();
      }
      CookieManager localCookieManager = d;
      AppMethodBeat.o(54874);
      return localCookieManager;
    }
    finally
    {
      AppMethodBeat.o(54874);
    }
  }
  
  public static int getROMCookieDBVersion(Context paramContext)
  {
    AppMethodBeat.i(54894);
    if (Build.VERSION.SDK_INT >= 11) {}
    for (paramContext = paramContext.getSharedPreferences("cookiedb_info", 4);; paramContext = paramContext.getSharedPreferences("cookiedb_info", 0))
    {
      int i = paramContext.getInt("db_version", -1);
      AppMethodBeat.o(54894);
      return i;
    }
  }
  
  public static void setROMCookieDBVersion(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(54895);
    if (Build.VERSION.SDK_INT >= 11) {}
    for (paramContext = paramContext.getSharedPreferences("cookiedb_info", 4);; paramContext = paramContext.getSharedPreferences("cookiedb_info", 0))
    {
      paramContext = paramContext.edit();
      paramContext.putInt("db_version", paramInt);
      paramContext.commit();
      AppMethodBeat.o(54895);
      return;
    }
  }
  
  void a()
  {
    label34:
    label60:
    Object localObject3;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(54891);
        this.f = true;
        if ((this.a == null) || (this.a.size() == 0))
        {
          AppMethodBeat.o(54891);
          return;
        }
        Object localObject1 = v.a();
        if ((localObject1 == null) || (!((v)localObject1).b())) {
          break;
        }
        localObject1 = this.a.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label298;
        }
        localObject3 = (b)((Iterator)localObject1).next();
        switch (((b)localObject3).a)
        {
        case 1: 
          setCookie(((b)localObject3).b, ((b)localObject3).c, ((b)localObject3).d);
          break;
        case 2: 
          setCookie(((b)localObject3).b, ((b)localObject3).c);
        }
      }
      finally {}
    }
    Iterator localIterator = this.a.iterator();
    for (;;)
    {
      Object localObject4;
      if (localIterator.hasNext()) {
        localObject4 = (b)localIterator.next();
      }
      switch (((b)localObject4).a)
      {
      case 1: 
        if (Build.VERSION.SDK_INT >= 21)
        {
          localObject3 = android.webkit.CookieManager.getInstance();
          String str1 = ((b)localObject4).b;
          String str2 = ((b)localObject4).c;
          localObject4 = ((b)localObject4).d;
          k.a(localObject3, "setCookie", new Class[] { String.class, String.class, android.webkit.ValueCallback.class }, new Object[] { str1, str2, localObject4 });
        }
        break;
      case 2: 
        android.webkit.CookieManager.getInstance().setCookie(((b)localObject4).b, ((b)localObject4).c);
        continue;
        label298:
        this.a.clear();
        AppMethodBeat.o(54891);
        break label34;
        break label60;
      }
    }
  }
  
  protected void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    Object localObject;
    long l2;
    long l1;
    label166:
    int k;
    int j;
    int i;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(54893);
        if ((this.c == CookieManager.a.a) || (paramContext == null) || (!TbsExtensionFunctionManager.getInstance().canUseFunction(paramContext, "cookie_switch.txt")) || (this.e))
        {
          localObject = new StringBuilder("compatiableCookieDatabaseIfNeed noneedCompatiable,context is null:");
          if (paramContext == null)
          {
            paramBoolean1 = bool2;
            ((StringBuilder)localObject).append(paramBoolean1).append("= or canUseFunction is false,isCompatiableed:").append(this.e);
            AppMethodBeat.o(54893);
            return;
          }
          paramBoolean1 = false;
          continue;
        }
        l2 = System.currentTimeMillis();
        l1 = 0L;
        TbsLog.i(LOGTAG, "compatiableCookieDatabaseIfNeed,isX5Inited:" + paramBoolean1 + ",useX5:" + paramBoolean2);
        if ((!paramBoolean1) && (!QbSdk.getIsSysWebViewForcedByOuter()) && (!QbSdk.a)) {
          break label593;
        }
        if ((QbSdk.getIsSysWebViewForcedByOuter()) || (QbSdk.a)) {
          break label618;
        }
        bool2 = TbsExtensionFunctionManager.getInstance().canUseFunction(paramContext, "usex5.txt");
        TbsLog.i(LOGTAG, "usex5 : mUseX5LastProcess->" + bool2 + ",useX5:" + paramBoolean2);
        TbsExtensionFunctionManager.getInstance().setFunctionEnable(paramContext, "usex5.txt", paramBoolean2);
        if (bool2 == paramBoolean2)
        {
          AppMethodBeat.o(54893);
          continue;
        }
        localObject = TbsLogReport.getInstance(paramContext).tbsLogInfo();
      }
      finally {}
      if (!TextUtils.isEmpty(this.b))
      {
        if ((o.a().i(paramContext) > 0) && (o.a().i(paramContext) < 36001))
        {
          AppMethodBeat.o(54893);
          continue;
        }
        if (bool2)
        {
          k = j.d(paramContext);
          j = k;
          if (k <= 0) {
            break label640;
          }
          i = getROMCookieDBVersion(paramContext);
          if (i > 0) {
            break label609;
          }
          j = k;
          paramBoolean1 = bool1;
          break label623;
          ((TbsLogReport.TbsLogInfo)localObject).setErrorCode(702);
          label337:
          ((TbsLogReport.TbsLogInfo)localObject).setFailDetail("x5->sys:" + bool2 + " from:" + j + " to:" + i + ",timeused:" + l1);
          TbsLogReport.getInstance(paramContext).eventReport(TbsLogReport.EventType.TYPE_COOKIE_DB_SWITCH, (TbsLogReport.TbsLogInfo)localObject);
          AppMethodBeat.o(54893);
          continue;
        }
        k = j.d(paramContext);
        j = k;
        if (k <= 0) {
          break label640;
        }
        String str = o.a().d(paramContext, "cookies_database_version");
        paramBoolean1 = TextUtils.isEmpty(str);
        j = k;
        if (paramBoolean1) {
          break label640;
        }
        try
        {
          i = Integer.parseInt(str);
          paramBoolean1 = false;
          j = k;
        }
        catch (Exception localException)
        {
          new StringBuilder("cannot cast toVersion:0,e:").append(localException.toString());
          j = k;
          break label640;
        }
      }
    }
    label640:
    label646:
    for (;;)
    {
      label498:
      if (i >= j)
      {
        new StringBuilder("INFO_COOKIE_SWITCH_NONEED, from :").append(j).append(",to:").append(i);
        ((TbsLogReport.TbsLogInfo)localObject).setErrorCode(703);
        break label337;
      }
      j.a(paramContext, this.c, this.b, paramBoolean1, paramBoolean2);
      ((TbsLogReport.TbsLogInfo)localObject).setErrorCode(704);
      l1 = System.currentTimeMillis() - l2;
      break label337;
      ((TbsLogReport.TbsLogInfo)localObject).setErrorCode(701);
      i = 0;
      j = 0;
      break label337;
      label593:
      v.a().a(paramContext, null);
      AppMethodBeat.o(54893);
      break;
      label609:
      paramBoolean1 = false;
      j = k;
      break label623;
      label618:
      paramBoolean2 = false;
      break label166;
      for (;;)
      {
        label623:
        if (paramBoolean1) {
          break label646;
        }
        if (j <= 0) {
          break;
        }
        if (i > 0) {
          break label498;
        }
        break;
        paramBoolean1 = false;
        i = 0;
      }
    }
  }
  
  public boolean acceptCookie()
  {
    AppMethodBeat.i(54888);
    if (isX5Core())
    {
      bool = getCookieManagerImpl().acceptCookie();
      AppMethodBeat.o(54888);
      return bool;
    }
    boolean bool = android.webkit.CookieManager.getInstance().acceptCookie();
    AppMethodBeat.o(54888);
    return bool;
  }
  
  public boolean acceptThirdPartyCookies(WebView paramWebView)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(54883);
        if (isX5Core())
        {
          bool = getCookieManagerImpl().acceptThirdPartyCookies(paramWebView.getView());
          AppMethodBeat.o(54883);
          return bool;
        }
        if (Build.VERSION.SDK_INT < 21)
        {
          AppMethodBeat.o(54883);
          continue;
        }
        localCookieManager = android.webkit.CookieManager.getInstance();
      }
      finally {}
      android.webkit.CookieManager localCookieManager;
      paramWebView = paramWebView.getView();
      paramWebView = k.a(localCookieManager, "acceptThirdPartyCookies", new Class[] { android.webkit.WebView.class }, new Object[] { paramWebView });
      if (paramWebView != null)
      {
        bool = ((Boolean)paramWebView).booleanValue();
        AppMethodBeat.o(54883);
      }
      else
      {
        AppMethodBeat.o(54883);
        bool = false;
      }
    }
  }
  
  public void flush()
  {
    AppMethodBeat.i(54879);
    if (isX5Core())
    {
      getCookieManagerImpl().flush();
      AppMethodBeat.o(54879);
      return;
    }
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(54879);
      return;
    }
    k.a(android.webkit.CookieManager.getInstance(), "flush", new Class[0], new Object[0]);
    AppMethodBeat.o(54879);
  }
  
  public String getCookie(String paramString)
  {
    AppMethodBeat.i(54889);
    if (isX5Core())
    {
      paramString = getCookieManagerImpl().getCookie(paramString);
      AppMethodBeat.o(54889);
      return paramString;
    }
    Object localObject = null;
    try
    {
      paramString = android.webkit.CookieManager.getInstance().getCookie(paramString);
      AppMethodBeat.o(54889);
      return paramString;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        paramString = localObject;
      }
    }
  }
  
  public boolean hasCookies()
  {
    AppMethodBeat.i(54887);
    if (isX5Core())
    {
      bool = getCookieManagerImpl().hasCookies();
      AppMethodBeat.o(54887);
      return bool;
    }
    boolean bool = android.webkit.CookieManager.getInstance().hasCookies();
    AppMethodBeat.o(54887);
    return bool;
  }
  
  public void removeAllCookie()
  {
    AppMethodBeat.i(54877);
    if (this.a != null) {
      this.a.clear();
    }
    if (isX5Core())
    {
      getCookieManagerImpl().removeAllCookie();
      AppMethodBeat.o(54877);
      return;
    }
    android.webkit.CookieManager.getInstance().removeAllCookie();
    AppMethodBeat.o(54877);
  }
  
  public void removeAllCookies(ValueCallback<Boolean> paramValueCallback)
  {
    AppMethodBeat.i(54878);
    if (this.a != null) {
      this.a.clear();
    }
    if (isX5Core())
    {
      getCookieManagerImpl().removeAllCookies(paramValueCallback);
      AppMethodBeat.o(54878);
      return;
    }
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(54878);
      return;
    }
    k.a(android.webkit.CookieManager.getInstance(), "removeAllCookies", new Class[] { android.webkit.ValueCallback.class }, new Object[] { paramValueCallback });
    AppMethodBeat.o(54878);
  }
  
  public void removeExpiredCookie()
  {
    AppMethodBeat.i(54880);
    if (isX5Core())
    {
      getCookieManagerImpl().removeExpiredCookie();
      AppMethodBeat.o(54880);
      return;
    }
    android.webkit.CookieManager.getInstance().removeExpiredCookie();
    AppMethodBeat.o(54880);
  }
  
  public void removeSessionCookie()
  {
    AppMethodBeat.i(54875);
    if (isX5Core())
    {
      getCookieManagerImpl().removeSessionCookie();
      AppMethodBeat.o(54875);
      return;
    }
    android.webkit.CookieManager.getInstance().removeSessionCookie();
    AppMethodBeat.o(54875);
  }
  
  public void removeSessionCookies(ValueCallback<Boolean> paramValueCallback)
  {
    AppMethodBeat.i(54876);
    if (isX5Core())
    {
      getCookieManagerImpl().removeSessionCookies(paramValueCallback);
      AppMethodBeat.o(54876);
      return;
    }
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(54876);
      return;
    }
    k.a(android.webkit.CookieManager.getInstance(), "removeSessionCookies", new Class[] { android.webkit.ValueCallback.class }, new Object[] { paramValueCallback });
    AppMethodBeat.o(54876);
  }
  
  public void setAcceptCookie(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(54881);
        if (isX5Core())
        {
          getCookieManagerImpl().setAcceptCookie(paramBoolean);
          AppMethodBeat.o(54881);
          return;
        }
      }
      finally
      {
        try
        {
          android.webkit.CookieManager.getInstance().setAcceptCookie(paramBoolean);
          AppMethodBeat.o(54881);
        }
        catch (Throwable localThrowable)
        {
          AppMethodBeat.o(54881);
        }
        localObject = finally;
      }
    }
  }
  
  public void setAcceptThirdPartyCookies(WebView paramWebView, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(54882);
        if (isX5Core())
        {
          getCookieManagerImpl().setAcceptThirdPartyCookies(paramWebView.getView(), paramBoolean);
          AppMethodBeat.o(54882);
          return;
        }
        if (Build.VERSION.SDK_INT < 21)
        {
          AppMethodBeat.o(54882);
          continue;
        }
        localCookieManager = android.webkit.CookieManager.getInstance();
      }
      finally {}
      android.webkit.CookieManager localCookieManager;
      Class localClass = Boolean.TYPE;
      paramWebView = paramWebView.getView();
      k.a(localCookieManager, "setAcceptThirdPartyCookies", new Class[] { android.webkit.WebView.class, localClass }, new Object[] { paramWebView, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(54882);
    }
  }
  
  public void setCookie(String paramString1, String paramString2)
  {
    try
    {
      AppMethodBeat.i(54884);
      setCookie(paramString1, paramString2, false);
      AppMethodBeat.o(54884);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  /* Error */
  public void setCookie(String paramString1, String paramString2, ValueCallback<Boolean> paramValueCallback)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 421
    //   5: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 319	com/tencent/smtt/sdk/CookieManager:isX5Core	()Z
    //   11: ifeq +23 -> 34
    //   14: invokestatic 323	com/tencent/smtt/sdk/CookieManager:getCookieManagerImpl	()Lcom/tencent/smtt/export/external/interfaces/IX5CoreCookieManager;
    //   17: aload_1
    //   18: aload_2
    //   19: aload_3
    //   20: invokeinterface 424 4 0
    //   25: ldc_w 421
    //   28: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: invokestatic 110	com/tencent/smtt/sdk/v:a	()Lcom/tencent/smtt/sdk/v;
    //   37: invokevirtual 426	com/tencent/smtt/sdk/v:d	()Z
    //   40: ifne +65 -> 105
    //   43: new 8	com/tencent/smtt/sdk/CookieManager$b
    //   46: dup
    //   47: aload_0
    //   48: invokespecial 429	com/tencent/smtt/sdk/CookieManager$b:<init>	(Lcom/tencent/smtt/sdk/CookieManager;)V
    //   51: astore 4
    //   53: aload 4
    //   55: iconst_1
    //   56: putfield 127	com/tencent/smtt/sdk/CookieManager$b:a	I
    //   59: aload 4
    //   61: aload_1
    //   62: putfield 129	com/tencent/smtt/sdk/CookieManager$b:b	Ljava/lang/String;
    //   65: aload 4
    //   67: aload_2
    //   68: putfield 131	com/tencent/smtt/sdk/CookieManager$b:c	Ljava/lang/String;
    //   71: aload 4
    //   73: aload_3
    //   74: putfield 134	com/tencent/smtt/sdk/CookieManager$b:d	Lcom/tencent/smtt/sdk/ValueCallback;
    //   77: aload_0
    //   78: getfield 99	com/tencent/smtt/sdk/CookieManager:a	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   81: ifnonnull +14 -> 95
    //   84: aload_0
    //   85: new 101	java/util/concurrent/CopyOnWriteArrayList
    //   88: dup
    //   89: invokespecial 430	java/util/concurrent/CopyOnWriteArrayList:<init>	()V
    //   92: putfield 99	com/tencent/smtt/sdk/CookieManager:a	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   95: aload_0
    //   96: getfield 99	com/tencent/smtt/sdk/CookieManager:a	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   99: aload 4
    //   101: invokevirtual 433	java/util/concurrent/CopyOnWriteArrayList:add	(Ljava/lang/Object;)Z
    //   104: pop
    //   105: aload_0
    //   106: getfield 39	com/tencent/smtt/sdk/CookieManager:f	Z
    //   109: ifeq +69 -> 178
    //   112: getstatic 63	android/os/Build$VERSION:SDK_INT	I
    //   115: bipush 21
    //   117: if_icmpge +17 -> 134
    //   120: ldc_w 421
    //   123: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: goto -95 -> 31
    //   129: astore_1
    //   130: aload_0
    //   131: monitorexit
    //   132: aload_1
    //   133: athrow
    //   134: invokestatic 146	android/webkit/CookieManager:getInstance	()Landroid/webkit/CookieManager;
    //   137: ldc 147
    //   139: iconst_3
    //   140: anewarray 149	java/lang/Class
    //   143: dup
    //   144: iconst_0
    //   145: ldc 151
    //   147: aastore
    //   148: dup
    //   149: iconst_1
    //   150: ldc 151
    //   152: aastore
    //   153: dup
    //   154: iconst_2
    //   155: ldc 153
    //   157: aastore
    //   158: iconst_3
    //   159: anewarray 155	java/lang/Object
    //   162: dup
    //   163: iconst_0
    //   164: aload_1
    //   165: aastore
    //   166: dup
    //   167: iconst_1
    //   168: aload_2
    //   169: aastore
    //   170: dup
    //   171: iconst_2
    //   172: aload_3
    //   173: aastore
    //   174: invokestatic 160	com/tencent/smtt/utils/k:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   177: pop
    //   178: ldc_w 421
    //   181: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   184: goto -153 -> 31
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	this	CookieManager
    //   0	187	1	paramString1	String
    //   0	187	2	paramString2	String
    //   0	187	3	paramValueCallback	ValueCallback<Boolean>
    //   51	49	4	localb	b
    // Exception table:
    //   from	to	target	type
    //   2	31	129	finally
    //   34	95	129	finally
    //   95	105	129	finally
    //   105	126	129	finally
    //   134	178	129	finally
    //   178	184	129	finally
  }
  
  /* Error */
  public void setCookie(String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 435
    //   5: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 319	com/tencent/smtt/sdk/CookieManager:isX5Core	()Z
    //   11: ifeq +22 -> 33
    //   14: invokestatic 323	com/tencent/smtt/sdk/CookieManager:getCookieManagerImpl	()Lcom/tencent/smtt/export/external/interfaces/IX5CoreCookieManager;
    //   17: aload_1
    //   18: aload_2
    //   19: invokeinterface 436 3 0
    //   24: ldc_w 435
    //   27: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: new 181	java/lang/StringBuilder
    //   36: dup
    //   37: ldc_w 438
    //   40: invokespecial 186	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   43: aload_0
    //   44: getfield 39	com/tencent/smtt/sdk/CookieManager:f	Z
    //   47: invokevirtual 190	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload_0
    //   52: getfield 39	com/tencent/smtt/sdk/CookieManager:f	Z
    //   55: ifne +7 -> 62
    //   58: iload_3
    //   59: ifeq +11 -> 70
    //   62: invokestatic 146	android/webkit/CookieManager:getInstance	()Landroid/webkit/CookieManager;
    //   65: aload_1
    //   66: aload_2
    //   67: invokevirtual 161	android/webkit/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: invokestatic 110	com/tencent/smtt/sdk/v:a	()Lcom/tencent/smtt/sdk/v;
    //   73: invokevirtual 426	com/tencent/smtt/sdk/v:d	()Z
    //   76: ifne +65 -> 141
    //   79: new 8	com/tencent/smtt/sdk/CookieManager$b
    //   82: dup
    //   83: aload_0
    //   84: invokespecial 429	com/tencent/smtt/sdk/CookieManager$b:<init>	(Lcom/tencent/smtt/sdk/CookieManager;)V
    //   87: astore 4
    //   89: aload 4
    //   91: iconst_2
    //   92: putfield 127	com/tencent/smtt/sdk/CookieManager$b:a	I
    //   95: aload 4
    //   97: aload_1
    //   98: putfield 129	com/tencent/smtt/sdk/CookieManager$b:b	Ljava/lang/String;
    //   101: aload 4
    //   103: aload_2
    //   104: putfield 131	com/tencent/smtt/sdk/CookieManager$b:c	Ljava/lang/String;
    //   107: aload 4
    //   109: aconst_null
    //   110: putfield 134	com/tencent/smtt/sdk/CookieManager$b:d	Lcom/tencent/smtt/sdk/ValueCallback;
    //   113: aload_0
    //   114: getfield 99	com/tencent/smtt/sdk/CookieManager:a	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   117: ifnonnull +14 -> 131
    //   120: aload_0
    //   121: new 101	java/util/concurrent/CopyOnWriteArrayList
    //   124: dup
    //   125: invokespecial 430	java/util/concurrent/CopyOnWriteArrayList:<init>	()V
    //   128: putfield 99	com/tencent/smtt/sdk/CookieManager:a	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   131: aload_0
    //   132: getfield 99	com/tencent/smtt/sdk/CookieManager:a	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   135: aload 4
    //   137: invokevirtual 433	java/util/concurrent/CopyOnWriteArrayList:add	(Ljava/lang/Object;)Z
    //   140: pop
    //   141: ldc_w 435
    //   144: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: goto -117 -> 30
    //   150: astore_1
    //   151: aload_0
    //   152: monitorexit
    //   153: aload_1
    //   154: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	this	CookieManager
    //   0	155	1	paramString1	String
    //   0	155	2	paramString2	String
    //   0	155	3	paramBoolean	boolean
    //   87	49	4	localb	b
    // Exception table:
    //   from	to	target	type
    //   2	30	150	finally
    //   33	58	150	finally
    //   62	70	150	finally
    //   70	131	150	finally
    //   131	141	150	finally
    //   141	147	150	finally
  }
  
  public boolean setCookieCompatialbeMode(Context paramContext, CookieManager.a parama, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(54892);
    long l = System.currentTimeMillis();
    if ((paramContext == null) || (!TbsExtensionFunctionManager.getInstance().canUseFunction(paramContext, "cookie_switch.txt")))
    {
      AppMethodBeat.o(54892);
      return false;
    }
    this.c = parama;
    if (paramString != null) {
      this.b = paramString;
    }
    if ((this.c != CookieManager.a.a) && (paramBoolean) && (!v.a().d())) {
      v.a().a(paramContext, null);
    }
    new StringBuilder("setKeyCookies,timeused:").append(System.currentTimeMillis() - l).append(", cookieCompatiableMode:").append(this.c.ordinal());
    AppMethodBeat.o(54892);
    return true;
  }
  
  public void setCookies(Map<String, String[]> paramMap)
  {
    AppMethodBeat.i(54890);
    if (isX5Core()) {}
    for (boolean bool = getCookieManagerImpl().setCookies(paramMap);; bool = false)
    {
      if (!bool)
      {
        Iterator localIterator = paramMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          String[] arrayOfString = (String[])paramMap.get(str);
          int j = arrayOfString.length;
          int i = 0;
          while (i < j)
          {
            setCookie(str, arrayOfString[i]);
            i += 1;
          }
        }
      }
      AppMethodBeat.o(54890);
      return;
    }
  }
  
  class b
  {
    int a;
    String b;
    String c;
    ValueCallback<Boolean> d;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.CookieManager
 * JD-Core Version:    0.7.0.1
 */