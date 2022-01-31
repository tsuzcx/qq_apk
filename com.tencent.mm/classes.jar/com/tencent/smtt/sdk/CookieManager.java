package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CookieManager
{
  public static String LOGTAG = "CookieManager";
  private static CookieManager d;
  ArrayList<b> a;
  String b;
  CookieManager.a c = CookieManager.a.a;
  private boolean e = false;
  private boolean f = false;
  
  public static CookieManager getInstance()
  {
    if (d == null) {}
    try
    {
      if (d == null) {
        d = new CookieManager();
      }
      return d;
    }
    finally {}
  }
  
  public static int getROMCookieDBVersion(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    for (paramContext = paramContext.getSharedPreferences("cookiedb_info", 4);; paramContext = paramContext.getSharedPreferences("cookiedb_info", 0)) {
      return paramContext.getInt("db_version", -1);
    }
  }
  
  public static void setROMCookieDBVersion(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    for (paramContext = paramContext.getSharedPreferences("cookiedb_info", 4);; paramContext = paramContext.getSharedPreferences("cookiedb_info", 0))
    {
      paramContext = paramContext.edit();
      paramContext.putInt("db_version", paramInt);
      paramContext.commit();
      return;
    }
  }
  
  void a()
  {
    label26:
    label52:
    Object localObject3;
    for (;;)
    {
      try
      {
        this.f = true;
        if (this.a != null)
        {
          int i = this.a.size();
          if (i != 0) {}
        }
        else
        {
          return;
        }
        Object localObject1 = bv.a();
        if ((localObject1 == null) || (!((bv)localObject1).b())) {
          break;
        }
        localObject1 = this.a.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label292;
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
          q.a(localObject3, "setCookie", new Class[] { String.class, String.class, android.webkit.ValueCallback.class }, new Object[] { str1, str2, localObject4 });
        }
        break;
      case 2: 
        android.webkit.CookieManager.getInstance().setCookie(((b)localObject4).b, ((b)localObject4).c);
        continue;
        label292:
        this.a.clear();
        break label26;
        break label52;
      }
    }
  }
  
  protected void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      boolean bool;
      long l2;
      long l1;
      label112:
      TbsLogReport.TbsLogInfo localTbsLogInfo;
      label253:
      try
      {
        if ((this.c != CookieManager.a.a) && (paramContext != null) && (TbsExtensionFunctionManager.getInstance().canUseFunction(paramContext, "cookie_switch.txt")))
        {
          bool = this.e;
          if (!bool) {}
        }
        else
        {
          return;
        }
        l2 = System.currentTimeMillis();
        l1 = 0L;
        TbsLog.i(LOGTAG, "compatiableCookieDatabaseIfNeed,isX5Inited:" + paramBoolean1 + ",useX5:" + paramBoolean2);
        if ((!paramBoolean1) && (!QbSdk.getIsSysWebViewForcedByOuter()) && (!QbSdk.a)) {
          break label473;
        }
        if ((QbSdk.getIsSysWebViewForcedByOuter()) || (QbSdk.a)) {
          break label493;
        }
        bool = TbsExtensionFunctionManager.getInstance().canUseFunction(paramContext, "usex5.txt");
        TbsLog.i(LOGTAG, "usex5 : mUseX5LastProcess->" + bool + ",useX5:" + paramBoolean2);
        TbsExtensionFunctionManager.getInstance().setFunctionEnable(paramContext, "usex5.txt", paramBoolean2);
        if (bool == paramBoolean2) {
          continue;
        }
        localTbsLogInfo = TbsLogReport.getInstance(paramContext).tbsLogInfo();
        if (TextUtils.isEmpty(this.b)) {
          break label456;
        }
        if ((an.a().n(paramContext) > 0) && (an.a().n(paramContext) < 36001)) {
          continue;
        }
        if (!bool) {
          break label334;
        }
        k = x.d(paramContext);
        j = k;
        if (k <= 0) {
          break label397;
        }
        i = getROMCookieDBVersion(paramContext);
        if (i > 0) {
          break label484;
        }
        paramBoolean1 = true;
        j = k;
      }
      finally {}
      localTbsLogInfo.setErrorCode(702);
      label261:
      localTbsLogInfo.setFailDetail("x5->sys:" + bool + " from:" + j + " to:" + i + ",timeused:" + l1);
      TbsLogReport.getInstance(paramContext).eventReport(TbsLogReport.EventType.TYPE_COOKIE_DB_SWITCH, localTbsLogInfo);
      continue;
      label334:
      int k = x.d(paramContext);
      int j = k;
      if (k > 0)
      {
        String str = an.a().c(paramContext, "cookies_database_version");
        paramBoolean1 = TextUtils.isEmpty(str);
        j = k;
        if (!paramBoolean1) {
          try
          {
            i = Integer.parseInt(str);
            paramBoolean1 = false;
            j = k;
          }
          catch (Exception localException)
          {
            j = k;
          }
        }
      }
      label397:
      paramBoolean1 = false;
      int i = 0;
      label456:
      label473:
      label484:
      label493:
      do
      {
        do
        {
          if (i >= j)
          {
            localTbsLogInfo.setErrorCode(703);
            break label261;
          }
          x.a(paramContext, this.c, this.b, paramBoolean1, paramBoolean2);
          localTbsLogInfo.setErrorCode(704);
          l1 = System.currentTimeMillis() - l2;
          break label261;
          localTbsLogInfo.setErrorCode(701);
          i = 0;
          j = 0;
          break label261;
          bv.a().a(paramContext, null);
          break;
          paramBoolean1 = false;
          j = k;
          continue;
          paramBoolean2 = false;
          break label112;
        } while (paramBoolean1);
        if (j <= 0) {
          break label253;
        }
      } while (i > 0);
    }
  }
  
  public boolean acceptCookie()
  {
    bv localbv = bv.a();
    if ((localbv != null) && (localbv.b())) {
      return localbv.c().d();
    }
    return android.webkit.CookieManager.getInstance().acceptCookie();
  }
  
  /* Error */
  public boolean acceptThirdPartyCookies(WebView paramWebView)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 97	com/tencent/smtt/sdk/bv:a	()Lcom/tencent/smtt/sdk/bv;
    //   5: astore_3
    //   6: aload_3
    //   7: ifnull +72 -> 79
    //   10: aload_3
    //   11: invokevirtual 99	com/tencent/smtt/sdk/bv:b	()Z
    //   14: ifeq +65 -> 79
    //   17: aload_3
    //   18: invokevirtual 294	com/tencent/smtt/sdk/bv:c	()Lcom/tencent/smtt/sdk/bw;
    //   21: invokevirtual 305	com/tencent/smtt/sdk/bw:b	()Lcom/tencent/smtt/export/external/DexLoader;
    //   24: astore_3
    //   25: aload_1
    //   26: invokevirtual 311	com/tencent/smtt/sdk/WebView:getView	()Landroid/view/View;
    //   29: astore_1
    //   30: aload_3
    //   31: ldc_w 313
    //   34: ldc_w 315
    //   37: iconst_1
    //   38: anewarray 136	java/lang/Class
    //   41: dup
    //   42: iconst_0
    //   43: ldc 4
    //   45: aastore
    //   46: iconst_1
    //   47: anewarray 4	java/lang/Object
    //   50: dup
    //   51: iconst_0
    //   52: aload_1
    //   53: aastore
    //   54: invokevirtual 321	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   57: astore_1
    //   58: aload_1
    //   59: ifnull +15 -> 74
    //   62: aload_1
    //   63: checkcast 323	java/lang/Boolean
    //   66: invokevirtual 326	java/lang/Boolean:booleanValue	()Z
    //   69: istore_2
    //   70: aload_0
    //   71: monitorexit
    //   72: iload_2
    //   73: ireturn
    //   74: iconst_1
    //   75: istore_2
    //   76: goto -6 -> 70
    //   79: getstatic 52	android/os/Build$VERSION:SDK_INT	I
    //   82: bipush 21
    //   84: if_icmpge +8 -> 92
    //   87: iconst_1
    //   88: istore_2
    //   89: goto -19 -> 70
    //   92: invokestatic 133	android/webkit/CookieManager:getInstance	()Landroid/webkit/CookieManager;
    //   95: astore_3
    //   96: aload_1
    //   97: invokevirtual 311	com/tencent/smtt/sdk/WebView:getView	()Landroid/view/View;
    //   100: astore_1
    //   101: aload_3
    //   102: ldc_w 327
    //   105: iconst_1
    //   106: anewarray 136	java/lang/Class
    //   109: dup
    //   110: iconst_0
    //   111: ldc_w 329
    //   114: aastore
    //   115: iconst_1
    //   116: anewarray 4	java/lang/Object
    //   119: dup
    //   120: iconst_0
    //   121: aload_1
    //   122: aastore
    //   123: invokestatic 145	com/tencent/smtt/utils/q:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   126: astore_1
    //   127: aload_1
    //   128: ifnull +14 -> 142
    //   131: aload_1
    //   132: checkcast 323	java/lang/Boolean
    //   135: invokevirtual 326	java/lang/Boolean:booleanValue	()Z
    //   138: istore_2
    //   139: goto -69 -> 70
    //   142: iconst_0
    //   143: istore_2
    //   144: goto -74 -> 70
    //   147: astore_1
    //   148: aload_0
    //   149: monitorexit
    //   150: aload_1
    //   151: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	this	CookieManager
    //   0	152	1	paramWebView	WebView
    //   69	75	2	bool	boolean
    //   5	97	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	6	147	finally
    //   10	58	147	finally
    //   62	70	147	finally
    //   79	87	147	finally
    //   92	127	147	finally
    //   131	139	147	finally
  }
  
  public void flush()
  {
    bv localbv = bv.a();
    if ((localbv != null) && (localbv.b())) {
      localbv.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_flush", new Class[0], new Object[0]);
    }
    while (Build.VERSION.SDK_INT < 21) {
      return;
    }
    q.a(android.webkit.CookieManager.getInstance(), "flush", new Class[0], new Object[0]);
  }
  
  public String getCookie(String paramString)
  {
    bv localbv = bv.a();
    if ((localbv != null) && (localbv.b())) {
      return localbv.c().a(paramString);
    }
    try
    {
      paramString = android.webkit.CookieManager.getInstance().getCookie(paramString);
      return paramString;
    }
    catch (Throwable paramString) {}
    return null;
  }
  
  public boolean hasCookies()
  {
    bv localbv = bv.a();
    if ((localbv != null) && (localbv.b())) {
      return localbv.c().h();
    }
    return android.webkit.CookieManager.getInstance().hasCookies();
  }
  
  public void removeAllCookie()
  {
    if (this.a != null) {
      this.a.clear();
    }
    bv localbv = bv.a();
    if ((localbv != null) && (localbv.b()))
    {
      localbv.c().e();
      return;
    }
    android.webkit.CookieManager.getInstance().removeAllCookie();
  }
  
  public void removeAllCookies(ValueCallback<Boolean> paramValueCallback)
  {
    if (this.a != null) {
      this.a.clear();
    }
    bv localbv = bv.a();
    if ((localbv != null) && (localbv.b())) {
      localbv.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookies", new Class[] { android.webkit.ValueCallback.class }, new Object[] { paramValueCallback });
    }
    while (Build.VERSION.SDK_INT < 21) {
      return;
    }
    q.a(android.webkit.CookieManager.getInstance(), "removeAllCookies", new Class[] { android.webkit.ValueCallback.class }, new Object[] { paramValueCallback });
  }
  
  public void removeExpiredCookie()
  {
    bv localbv = bv.a();
    if ((localbv != null) && (localbv.b()))
    {
      localbv.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeExpiredCookie", new Class[0], new Object[0]);
      return;
    }
    android.webkit.CookieManager.getInstance().removeExpiredCookie();
  }
  
  public void removeSessionCookie()
  {
    bv localbv = bv.a();
    if ((localbv != null) && (localbv.b()))
    {
      localbv.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookie", new Class[0], new Object[0]);
      return;
    }
    android.webkit.CookieManager.getInstance().removeSessionCookie();
  }
  
  public void removeSessionCookies(ValueCallback<Boolean> paramValueCallback)
  {
    bv localbv = bv.a();
    if ((localbv != null) && (localbv.b())) {
      localbv.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookies", new Class[] { android.webkit.ValueCallback.class }, new Object[] { paramValueCallback });
    }
    while (Build.VERSION.SDK_INT < 21) {
      return;
    }
    q.a(android.webkit.CookieManager.getInstance(), "removeSessionCookies", new Class[] { android.webkit.ValueCallback.class }, new Object[] { paramValueCallback });
  }
  
  /* Error */
  public void setAcceptCookie(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 97	com/tencent/smtt/sdk/bv:a	()Lcom/tencent/smtt/sdk/bv;
    //   5: astore_2
    //   6: aload_2
    //   7: ifnull +51 -> 58
    //   10: aload_2
    //   11: invokevirtual 99	com/tencent/smtt/sdk/bv:b	()Z
    //   14: ifeq +44 -> 58
    //   17: aload_2
    //   18: invokevirtual 294	com/tencent/smtt/sdk/bv:c	()Lcom/tencent/smtt/sdk/bw;
    //   21: invokevirtual 305	com/tencent/smtt/sdk/bw:b	()Lcom/tencent/smtt/export/external/DexLoader;
    //   24: ldc_w 313
    //   27: ldc_w 377
    //   30: iconst_1
    //   31: anewarray 136	java/lang/Class
    //   34: dup
    //   35: iconst_0
    //   36: getstatic 381	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   39: aastore
    //   40: iconst_1
    //   41: anewarray 4	java/lang/Object
    //   44: dup
    //   45: iconst_0
    //   46: iload_1
    //   47: invokestatic 385	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   50: aastore
    //   51: invokevirtual 321	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   54: pop
    //   55: aload_0
    //   56: monitorexit
    //   57: return
    //   58: invokestatic 133	android/webkit/CookieManager:getInstance	()Landroid/webkit/CookieManager;
    //   61: iload_1
    //   62: invokevirtual 387	android/webkit/CookieManager:setAcceptCookie	(Z)V
    //   65: goto -10 -> 55
    //   68: astore_2
    //   69: goto -14 -> 55
    //   72: astore_2
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_2
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	CookieManager
    //   0	77	1	paramBoolean	boolean
    //   5	13	2	localbv	bv
    //   68	1	2	localThrowable	Throwable
    //   72	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   58	65	68	java/lang/Throwable
    //   2	6	72	finally
    //   10	55	72	finally
    //   58	65	72	finally
  }
  
  /* Error */
  public void setAcceptThirdPartyCookies(WebView paramWebView, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 97	com/tencent/smtt/sdk/bv:a	()Lcom/tencent/smtt/sdk/bv;
    //   5: astore_3
    //   6: aload_3
    //   7: ifnull +71 -> 78
    //   10: aload_3
    //   11: invokevirtual 99	com/tencent/smtt/sdk/bv:b	()Z
    //   14: ifeq +64 -> 78
    //   17: aload_3
    //   18: invokevirtual 294	com/tencent/smtt/sdk/bv:c	()Lcom/tencent/smtt/sdk/bw;
    //   21: invokevirtual 305	com/tencent/smtt/sdk/bw:b	()Lcom/tencent/smtt/export/external/DexLoader;
    //   24: astore_3
    //   25: getstatic 381	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   28: astore 4
    //   30: aload_1
    //   31: invokevirtual 311	com/tencent/smtt/sdk/WebView:getView	()Landroid/view/View;
    //   34: astore_1
    //   35: aload_3
    //   36: ldc_w 313
    //   39: ldc_w 391
    //   42: iconst_2
    //   43: anewarray 136	java/lang/Class
    //   46: dup
    //   47: iconst_0
    //   48: ldc 4
    //   50: aastore
    //   51: dup
    //   52: iconst_1
    //   53: aload 4
    //   55: aastore
    //   56: iconst_2
    //   57: anewarray 4	java/lang/Object
    //   60: dup
    //   61: iconst_0
    //   62: aload_1
    //   63: aastore
    //   64: dup
    //   65: iconst_1
    //   66: iload_2
    //   67: invokestatic 385	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   70: aastore
    //   71: invokevirtual 321	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   74: pop
    //   75: aload_0
    //   76: monitorexit
    //   77: return
    //   78: getstatic 52	android/os/Build$VERSION:SDK_INT	I
    //   81: bipush 21
    //   83: if_icmplt -8 -> 75
    //   86: invokestatic 133	android/webkit/CookieManager:getInstance	()Landroid/webkit/CookieManager;
    //   89: astore_3
    //   90: getstatic 381	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   93: astore 4
    //   95: aload_1
    //   96: invokevirtual 311	com/tencent/smtt/sdk/WebView:getView	()Landroid/view/View;
    //   99: astore_1
    //   100: aload_3
    //   101: ldc_w 392
    //   104: iconst_2
    //   105: anewarray 136	java/lang/Class
    //   108: dup
    //   109: iconst_0
    //   110: ldc_w 329
    //   113: aastore
    //   114: dup
    //   115: iconst_1
    //   116: aload 4
    //   118: aastore
    //   119: iconst_2
    //   120: anewarray 4	java/lang/Object
    //   123: dup
    //   124: iconst_0
    //   125: aload_1
    //   126: aastore
    //   127: dup
    //   128: iconst_1
    //   129: iload_2
    //   130: invokestatic 385	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   133: aastore
    //   134: invokestatic 145	com/tencent/smtt/utils/q:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   137: pop
    //   138: goto -63 -> 75
    //   141: astore_1
    //   142: aload_0
    //   143: monitorexit
    //   144: aload_1
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	CookieManager
    //   0	146	1	paramWebView	WebView
    //   0	146	2	paramBoolean	boolean
    //   5	96	3	localObject	Object
    //   28	89	4	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   2	6	141	finally
    //   10	75	141	finally
    //   78	138	141	finally
  }
  
  public void setCookie(String paramString1, String paramString2)
  {
    try
    {
      setCookie(paramString1, paramString2, false);
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
    //   2: invokestatic 97	com/tencent/smtt/sdk/bv:a	()Lcom/tencent/smtt/sdk/bv;
    //   5: astore 4
    //   7: aload 4
    //   9: ifnull +67 -> 76
    //   12: aload 4
    //   14: invokevirtual 99	com/tencent/smtt/sdk/bv:b	()Z
    //   17: ifeq +59 -> 76
    //   20: aload 4
    //   22: invokevirtual 294	com/tencent/smtt/sdk/bv:c	()Lcom/tencent/smtt/sdk/bw;
    //   25: invokevirtual 305	com/tencent/smtt/sdk/bw:b	()Lcom/tencent/smtt/export/external/DexLoader;
    //   28: ldc_w 313
    //   31: ldc_w 397
    //   34: iconst_3
    //   35: anewarray 136	java/lang/Class
    //   38: dup
    //   39: iconst_0
    //   40: ldc 138
    //   42: aastore
    //   43: dup
    //   44: iconst_1
    //   45: ldc 138
    //   47: aastore
    //   48: dup
    //   49: iconst_2
    //   50: ldc 140
    //   52: aastore
    //   53: iconst_3
    //   54: anewarray 4	java/lang/Object
    //   57: dup
    //   58: iconst_0
    //   59: aload_1
    //   60: aastore
    //   61: dup
    //   62: iconst_1
    //   63: aload_2
    //   64: aastore
    //   65: dup
    //   66: iconst_2
    //   67: aload_3
    //   68: aastore
    //   69: invokevirtual 321	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   72: pop
    //   73: aload_0
    //   74: monitorexit
    //   75: return
    //   76: invokestatic 97	com/tencent/smtt/sdk/bv:a	()Lcom/tencent/smtt/sdk/bv;
    //   79: invokevirtual 398	com/tencent/smtt/sdk/bv:d	()Z
    //   82: ifne +65 -> 147
    //   85: new 8	com/tencent/smtt/sdk/CookieManager$b
    //   88: dup
    //   89: aload_0
    //   90: invokespecial 401	com/tencent/smtt/sdk/CookieManager$b:<init>	(Lcom/tencent/smtt/sdk/CookieManager;)V
    //   93: astore 4
    //   95: aload 4
    //   97: iconst_1
    //   98: putfield 114	com/tencent/smtt/sdk/CookieManager$b:a	I
    //   101: aload 4
    //   103: aload_1
    //   104: putfield 116	com/tencent/smtt/sdk/CookieManager$b:b	Ljava/lang/String;
    //   107: aload 4
    //   109: aload_2
    //   110: putfield 118	com/tencent/smtt/sdk/CookieManager$b:c	Ljava/lang/String;
    //   113: aload 4
    //   115: aload_3
    //   116: putfield 121	com/tencent/smtt/sdk/CookieManager$b:d	Lcom/tencent/smtt/sdk/ValueCallback;
    //   119: aload_0
    //   120: getfield 86	com/tencent/smtt/sdk/CookieManager:a	Ljava/util/ArrayList;
    //   123: ifnonnull +14 -> 137
    //   126: aload_0
    //   127: new 88	java/util/ArrayList
    //   130: dup
    //   131: invokespecial 402	java/util/ArrayList:<init>	()V
    //   134: putfield 86	com/tencent/smtt/sdk/CookieManager:a	Ljava/util/ArrayList;
    //   137: aload_0
    //   138: getfield 86	com/tencent/smtt/sdk/CookieManager:a	Ljava/util/ArrayList;
    //   141: aload 4
    //   143: invokevirtual 406	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   146: pop
    //   147: aload_0
    //   148: getfield 39	com/tencent/smtt/sdk/CookieManager:f	Z
    //   151: ifeq -78 -> 73
    //   154: getstatic 52	android/os/Build$VERSION:SDK_INT	I
    //   157: bipush 21
    //   159: if_icmplt -86 -> 73
    //   162: invokestatic 133	android/webkit/CookieManager:getInstance	()Landroid/webkit/CookieManager;
    //   165: ldc 134
    //   167: iconst_3
    //   168: anewarray 136	java/lang/Class
    //   171: dup
    //   172: iconst_0
    //   173: ldc 138
    //   175: aastore
    //   176: dup
    //   177: iconst_1
    //   178: ldc 138
    //   180: aastore
    //   181: dup
    //   182: iconst_2
    //   183: ldc 140
    //   185: aastore
    //   186: iconst_3
    //   187: anewarray 4	java/lang/Object
    //   190: dup
    //   191: iconst_0
    //   192: aload_1
    //   193: aastore
    //   194: dup
    //   195: iconst_1
    //   196: aload_2
    //   197: aastore
    //   198: dup
    //   199: iconst_2
    //   200: aload_3
    //   201: aastore
    //   202: invokestatic 145	com/tencent/smtt/utils/q:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   205: pop
    //   206: goto -133 -> 73
    //   209: astore_1
    //   210: aload_0
    //   211: monitorexit
    //   212: aload_1
    //   213: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	this	CookieManager
    //   0	214	1	paramString1	String
    //   0	214	2	paramString2	String
    //   0	214	3	paramValueCallback	ValueCallback<Boolean>
    //   5	137	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	209	finally
    //   12	73	209	finally
    //   76	137	209	finally
    //   137	147	209	finally
    //   147	206	209	finally
  }
  
  /* Error */
  public void setCookie(String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 97	com/tencent/smtt/sdk/bv:a	()Lcom/tencent/smtt/sdk/bv;
    //   5: astore 4
    //   7: aload 4
    //   9: ifnull +58 -> 67
    //   12: aload 4
    //   14: invokevirtual 99	com/tencent/smtt/sdk/bv:b	()Z
    //   17: ifeq +50 -> 67
    //   20: aload 4
    //   22: invokevirtual 294	com/tencent/smtt/sdk/bv:c	()Lcom/tencent/smtt/sdk/bw;
    //   25: invokevirtual 305	com/tencent/smtt/sdk/bw:b	()Lcom/tencent/smtt/export/external/DexLoader;
    //   28: ldc_w 313
    //   31: ldc_w 397
    //   34: iconst_2
    //   35: anewarray 136	java/lang/Class
    //   38: dup
    //   39: iconst_0
    //   40: ldc 138
    //   42: aastore
    //   43: dup
    //   44: iconst_1
    //   45: ldc 138
    //   47: aastore
    //   48: iconst_2
    //   49: anewarray 4	java/lang/Object
    //   52: dup
    //   53: iconst_0
    //   54: aload_1
    //   55: aastore
    //   56: dup
    //   57: iconst_1
    //   58: aload_2
    //   59: aastore
    //   60: invokevirtual 321	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   63: pop
    //   64: aload_0
    //   65: monitorexit
    //   66: return
    //   67: aload_0
    //   68: getfield 39	com/tencent/smtt/sdk/CookieManager:f	Z
    //   71: ifne +7 -> 78
    //   74: iload_3
    //   75: ifeq +11 -> 86
    //   78: invokestatic 133	android/webkit/CookieManager:getInstance	()Landroid/webkit/CookieManager;
    //   81: aload_1
    //   82: aload_2
    //   83: invokevirtual 146	android/webkit/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: invokestatic 97	com/tencent/smtt/sdk/bv:a	()Lcom/tencent/smtt/sdk/bv;
    //   89: invokevirtual 398	com/tencent/smtt/sdk/bv:d	()Z
    //   92: ifne -28 -> 64
    //   95: new 8	com/tencent/smtt/sdk/CookieManager$b
    //   98: dup
    //   99: aload_0
    //   100: invokespecial 401	com/tencent/smtt/sdk/CookieManager$b:<init>	(Lcom/tencent/smtt/sdk/CookieManager;)V
    //   103: astore 4
    //   105: aload 4
    //   107: iconst_2
    //   108: putfield 114	com/tencent/smtt/sdk/CookieManager$b:a	I
    //   111: aload 4
    //   113: aload_1
    //   114: putfield 116	com/tencent/smtt/sdk/CookieManager$b:b	Ljava/lang/String;
    //   117: aload 4
    //   119: aload_2
    //   120: putfield 118	com/tencent/smtt/sdk/CookieManager$b:c	Ljava/lang/String;
    //   123: aload 4
    //   125: aconst_null
    //   126: putfield 121	com/tencent/smtt/sdk/CookieManager$b:d	Lcom/tencent/smtt/sdk/ValueCallback;
    //   129: aload_0
    //   130: getfield 86	com/tencent/smtt/sdk/CookieManager:a	Ljava/util/ArrayList;
    //   133: ifnonnull +14 -> 147
    //   136: aload_0
    //   137: new 88	java/util/ArrayList
    //   140: dup
    //   141: invokespecial 402	java/util/ArrayList:<init>	()V
    //   144: putfield 86	com/tencent/smtt/sdk/CookieManager:a	Ljava/util/ArrayList;
    //   147: aload_0
    //   148: getfield 86	com/tencent/smtt/sdk/CookieManager:a	Ljava/util/ArrayList;
    //   151: aload 4
    //   153: invokevirtual 406	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   156: pop
    //   157: goto -93 -> 64
    //   160: astore_1
    //   161: aload_0
    //   162: monitorexit
    //   163: aload_1
    //   164: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	CookieManager
    //   0	165	1	paramString1	String
    //   0	165	2	paramString2	String
    //   0	165	3	paramBoolean	boolean
    //   5	147	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	160	finally
    //   12	64	160	finally
    //   67	74	160	finally
    //   78	86	160	finally
    //   86	147	160	finally
    //   147	157	160	finally
  }
  
  public boolean setCookieCompatialbeMode(Context paramContext, CookieManager.a parama, String paramString, boolean paramBoolean)
  {
    System.currentTimeMillis();
    if ((paramContext == null) || (!TbsExtensionFunctionManager.getInstance().canUseFunction(paramContext, "cookie_switch.txt"))) {
      return false;
    }
    this.c = parama;
    if (paramString != null) {
      this.b = paramString;
    }
    if ((this.c != CookieManager.a.a) && (paramBoolean) && (!bv.a().d())) {
      bv.a().a(paramContext, null);
    }
    return true;
  }
  
  public void setCookies(Map<String, String[]> paramMap)
  {
    Object localObject = bv.a();
    if ((localObject != null) && (((bv)localObject).b())) {}
    for (boolean bool = ((bv)localObject).c().a(paramMap);; bool = false)
    {
      if (!bool)
      {
        localObject = paramMap.keySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.CookieManager
 * JD-Core Version:    0.7.0.1
 */