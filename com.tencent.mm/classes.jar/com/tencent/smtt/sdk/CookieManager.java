package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CookieManager
{
  public static String LOGTAG = "CookieManager";
  private static CookieManager d;
  ArrayList<CookieManager.b> a;
  String b;
  CookieManager.a c = CookieManager.a.a;
  private boolean e = false;
  private boolean f = false;
  
  public static CookieManager getInstance()
  {
    AppMethodBeat.i(63865);
    if (d == null) {}
    try
    {
      if (d == null) {
        d = new CookieManager();
      }
      CookieManager localCookieManager = d;
      AppMethodBeat.o(63865);
      return localCookieManager;
    }
    finally
    {
      AppMethodBeat.o(63865);
    }
  }
  
  public static int getROMCookieDBVersion(Context paramContext)
  {
    AppMethodBeat.i(63885);
    if (Build.VERSION.SDK_INT >= 11) {}
    for (paramContext = paramContext.getSharedPreferences("cookiedb_info", 4);; paramContext = paramContext.getSharedPreferences("cookiedb_info", 0))
    {
      int i = paramContext.getInt("db_version", -1);
      AppMethodBeat.o(63885);
      return i;
    }
  }
  
  public static void setROMCookieDBVersion(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(63886);
    if (Build.VERSION.SDK_INT >= 11) {}
    for (paramContext = paramContext.getSharedPreferences("cookiedb_info", 4);; paramContext = paramContext.getSharedPreferences("cookiedb_info", 0))
    {
      paramContext = paramContext.edit();
      paramContext.putInt("db_version", paramInt);
      paramContext.commit();
      AppMethodBeat.o(63886);
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
        AppMethodBeat.i(63882);
        this.f = true;
        if ((this.a == null) || (this.a.size() == 0))
        {
          AppMethodBeat.o(63882);
          return;
        }
        Object localObject1 = bz.a();
        if ((localObject1 == null) || (!((bz)localObject1).b())) {
          break;
        }
        localObject1 = this.a.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label298;
        }
        localObject3 = (CookieManager.b)((Iterator)localObject1).next();
        switch (((CookieManager.b)localObject3).a)
        {
        case 1: 
          setCookie(((CookieManager.b)localObject3).b, ((CookieManager.b)localObject3).c, ((CookieManager.b)localObject3).d);
          break;
        case 2: 
          setCookie(((CookieManager.b)localObject3).b, ((CookieManager.b)localObject3).c);
        }
      }
      finally {}
    }
    Iterator localIterator = this.a.iterator();
    for (;;)
    {
      Object localObject4;
      if (localIterator.hasNext()) {
        localObject4 = (CookieManager.b)localIterator.next();
      }
      switch (((CookieManager.b)localObject4).a)
      {
      case 1: 
        if (Build.VERSION.SDK_INT >= 21)
        {
          localObject3 = android.webkit.CookieManager.getInstance();
          String str1 = ((CookieManager.b)localObject4).b;
          String str2 = ((CookieManager.b)localObject4).c;
          localObject4 = ((CookieManager.b)localObject4).d;
          r.a(localObject3, "setCookie", new Class[] { String.class, String.class, android.webkit.ValueCallback.class }, new Object[] { str1, str2, localObject4 });
        }
        break;
      case 2: 
        android.webkit.CookieManager.getInstance().setCookie(((CookieManager.b)localObject4).b, ((CookieManager.b)localObject4).c);
        continue;
        label298:
        this.a.clear();
        AppMethodBeat.o(63882);
        break label34;
        break label60;
      }
    }
  }
  
  protected void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l2;
    long l1;
    label118:
    boolean bool;
    TbsLogReport.TbsLogInfo localTbsLogInfo;
    int k;
    int j;
    int i;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(63884);
        if ((this.c == CookieManager.a.a) || (paramContext == null) || (!TbsExtensionFunctionManager.getInstance().canUseFunction(paramContext, "cookie_switch.txt")) || (this.e))
        {
          AppMethodBeat.o(63884);
          return;
        }
        l2 = System.currentTimeMillis();
        l1 = 0L;
        TbsLog.i(LOGTAG, "compatiableCookieDatabaseIfNeed,isX5Inited:" + paramBoolean1 + ",useX5:" + paramBoolean2);
        if ((!paramBoolean1) && (!QbSdk.getIsSysWebViewForcedByOuter()) && (!QbSdk.a)) {
          break label503;
        }
        if ((QbSdk.getIsSysWebViewForcedByOuter()) || (QbSdk.a)) {
          break label528;
        }
        bool = TbsExtensionFunctionManager.getInstance().canUseFunction(paramContext, "usex5.txt");
        TbsLog.i(LOGTAG, "usex5 : mUseX5LastProcess->" + bool + ",useX5:" + paramBoolean2);
        TbsExtensionFunctionManager.getInstance().setFunctionEnable(paramContext, "usex5.txt", paramBoolean2);
        if (bool == paramBoolean2)
        {
          AppMethodBeat.o(63884);
          continue;
        }
        localTbsLogInfo = TbsLogReport.getInstance(paramContext).tbsLogInfo();
      }
      finally {}
      if (!TextUtils.isEmpty(this.b))
      {
        if ((ao.a().i(paramContext) > 0) && (ao.a().i(paramContext) < 36001))
        {
          AppMethodBeat.o(63884);
          continue;
        }
        if (bool)
        {
          k = y.d(paramContext);
          j = k;
          if (k <= 0) {
            break label427;
          }
          i = getROMCookieDBVersion(paramContext);
          if (i > 0) {
            break label519;
          }
          paramBoolean1 = true;
          j = k;
          break label533;
        }
      }
    }
    label519:
    label528:
    label533:
    for (;;)
    {
      label280:
      localTbsLogInfo.setErrorCode(702);
      label288:
      localTbsLogInfo.setFailDetail("x5->sys:" + bool + " from:" + j + " to:" + i + ",timeused:" + l1);
      TbsLogReport.getInstance(paramContext).eventReport(TbsLogReport.EventType.TYPE_COOKIE_DB_SWITCH, localTbsLogInfo);
      AppMethodBeat.o(63884);
      break;
      k = y.d(paramContext);
      j = k;
      if (k > 0)
      {
        String str = ao.a().d(paramContext, "cookies_database_version");
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
      label427:
      paramBoolean1 = false;
      i = 0;
      label503:
      do
      {
        do
        {
          if (i >= j)
          {
            localTbsLogInfo.setErrorCode(703);
            break label288;
          }
          y.a(paramContext, this.c, this.b, paramBoolean1, paramBoolean2);
          localTbsLogInfo.setErrorCode(704);
          l1 = System.currentTimeMillis() - l2;
          break label288;
          localTbsLogInfo.setErrorCode(701);
          i = 0;
          j = 0;
          break label288;
          bz.a().a(paramContext, null);
          AppMethodBeat.o(63884);
          break;
          paramBoolean1 = false;
          j = k;
          continue;
          paramBoolean2 = false;
          break label118;
        } while (paramBoolean1);
        if (j <= 0) {
          break label280;
        }
      } while (i > 0);
    }
  }
  
  public boolean acceptCookie()
  {
    AppMethodBeat.i(63879);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      bool = localbz.c().d();
      AppMethodBeat.o(63879);
      return bool;
    }
    boolean bool = android.webkit.CookieManager.getInstance().acceptCookie();
    AppMethodBeat.o(63879);
    return bool;
  }
  
  public boolean acceptThirdPartyCookies(WebView paramWebView)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(63874);
        Object localObject = bz.a();
        if ((localObject != null) && (((bz)localObject).b()))
        {
          localObject = ((bz)localObject).c().b();
          paramWebView = paramWebView.getView();
          paramWebView = ((DexLoader)localObject).invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptThirdPartyCookies", new Class[] { Object.class }, new Object[] { paramWebView });
          if (paramWebView != null)
          {
            bool = ((Boolean)paramWebView).booleanValue();
            AppMethodBeat.o(63874);
            return bool;
          }
          AppMethodBeat.o(63874);
          bool = true;
          continue;
        }
        if (Build.VERSION.SDK_INT < 21)
        {
          AppMethodBeat.o(63874);
          bool = true;
          continue;
        }
        localObject = android.webkit.CookieManager.getInstance();
        paramWebView = paramWebView.getView();
        paramWebView = r.a(localObject, "acceptThirdPartyCookies", new Class[] { android.webkit.WebView.class }, new Object[] { paramWebView });
        if (paramWebView != null)
        {
          bool = ((Boolean)paramWebView).booleanValue();
          AppMethodBeat.o(63874);
          continue;
        }
        AppMethodBeat.o(63874);
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public void flush()
  {
    AppMethodBeat.i(63870);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      localbz.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_flush", new Class[0], new Object[0]);
      AppMethodBeat.o(63870);
      return;
    }
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(63870);
      return;
    }
    r.a(android.webkit.CookieManager.getInstance(), "flush", new Class[0], new Object[0]);
    AppMethodBeat.o(63870);
  }
  
  public String getCookie(String paramString)
  {
    AppMethodBeat.i(63880);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      paramString = localbz.c().a(paramString);
      AppMethodBeat.o(63880);
      return paramString;
    }
    localbz = null;
    try
    {
      paramString = android.webkit.CookieManager.getInstance().getCookie(paramString);
      AppMethodBeat.o(63880);
      return paramString;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        paramString = localbz;
      }
    }
  }
  
  public boolean hasCookies()
  {
    AppMethodBeat.i(63878);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      bool = localbz.c().h();
      AppMethodBeat.o(63878);
      return bool;
    }
    boolean bool = android.webkit.CookieManager.getInstance().hasCookies();
    AppMethodBeat.o(63878);
    return bool;
  }
  
  public void removeAllCookie()
  {
    AppMethodBeat.i(63868);
    if (this.a != null) {
      this.a.clear();
    }
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      localbz.c().e();
      AppMethodBeat.o(63868);
      return;
    }
    android.webkit.CookieManager.getInstance().removeAllCookie();
    AppMethodBeat.o(63868);
  }
  
  public void removeAllCookies(ValueCallback<Boolean> paramValueCallback)
  {
    AppMethodBeat.i(63869);
    if (this.a != null) {
      this.a.clear();
    }
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      localbz.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookies", new Class[] { android.webkit.ValueCallback.class }, new Object[] { paramValueCallback });
      AppMethodBeat.o(63869);
      return;
    }
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(63869);
      return;
    }
    r.a(android.webkit.CookieManager.getInstance(), "removeAllCookies", new Class[] { android.webkit.ValueCallback.class }, new Object[] { paramValueCallback });
    AppMethodBeat.o(63869);
  }
  
  public void removeExpiredCookie()
  {
    AppMethodBeat.i(63871);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      localbz.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeExpiredCookie", new Class[0], new Object[0]);
      AppMethodBeat.o(63871);
      return;
    }
    android.webkit.CookieManager.getInstance().removeExpiredCookie();
    AppMethodBeat.o(63871);
  }
  
  public void removeSessionCookie()
  {
    AppMethodBeat.i(63866);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      localbz.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookie", new Class[0], new Object[0]);
      AppMethodBeat.o(63866);
      return;
    }
    android.webkit.CookieManager.getInstance().removeSessionCookie();
    AppMethodBeat.o(63866);
  }
  
  public void removeSessionCookies(ValueCallback<Boolean> paramValueCallback)
  {
    AppMethodBeat.i(63867);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      localbz.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookies", new Class[] { android.webkit.ValueCallback.class }, new Object[] { paramValueCallback });
      AppMethodBeat.o(63867);
      return;
    }
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(63867);
      return;
    }
    r.a(android.webkit.CookieManager.getInstance(), "removeSessionCookies", new Class[] { android.webkit.ValueCallback.class }, new Object[] { paramValueCallback });
    AppMethodBeat.o(63867);
  }
  
  /* Error */
  public void setAcceptCookie(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 397
    //   5: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 110	com/tencent/smtt/sdk/bz:a	()Lcom/tencent/smtt/sdk/bz;
    //   11: astore_2
    //   12: aload_2
    //   13: ifnull +57 -> 70
    //   16: aload_2
    //   17: invokevirtual 112	com/tencent/smtt/sdk/bz:b	()Z
    //   20: ifeq +50 -> 70
    //   23: aload_2
    //   24: invokevirtual 306	com/tencent/smtt/sdk/bz:c	()Lcom/tencent/smtt/sdk/ca;
    //   27: invokevirtual 318	com/tencent/smtt/sdk/ca:b	()Lcom/tencent/smtt/export/external/DexLoader;
    //   30: ldc_w 326
    //   33: ldc_w 399
    //   36: iconst_1
    //   37: anewarray 149	java/lang/Class
    //   40: dup
    //   41: iconst_0
    //   42: getstatic 403	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   45: aastore
    //   46: iconst_1
    //   47: anewarray 4	java/lang/Object
    //   50: dup
    //   51: iconst_0
    //   52: iload_1
    //   53: invokestatic 407	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   56: aastore
    //   57: invokevirtual 334	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   60: pop
    //   61: ldc_w 397
    //   64: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: aload_0
    //   68: monitorexit
    //   69: return
    //   70: invokestatic 146	android/webkit/CookieManager:getInstance	()Landroid/webkit/CookieManager;
    //   73: iload_1
    //   74: invokevirtual 409	android/webkit/CookieManager:setAcceptCookie	(Z)V
    //   77: ldc_w 397
    //   80: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: goto -16 -> 67
    //   86: astore_2
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_2
    //   90: athrow
    //   91: astore_2
    //   92: ldc_w 397
    //   95: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: goto -31 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	CookieManager
    //   0	101	1	paramBoolean	boolean
    //   11	13	2	localbz	bz
    //   86	4	2	localObject	Object
    //   91	1	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   2	12	86	finally
    //   16	67	86	finally
    //   70	77	86	finally
    //   77	83	86	finally
    //   92	98	86	finally
    //   70	77	91	java/lang/Throwable
  }
  
  public void setAcceptThirdPartyCookies(WebView paramWebView, boolean paramBoolean)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        AppMethodBeat.i(63873);
        localObject = bz.a();
        if ((localObject != null) && (((bz)localObject).b()))
        {
          localObject = ((bz)localObject).c().b();
          localClass = Boolean.TYPE;
          paramWebView = paramWebView.getView();
          ((DexLoader)localObject).invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptThirdPartyCookies", new Class[] { Object.class, localClass }, new Object[] { paramWebView, Boolean.valueOf(paramBoolean) });
          AppMethodBeat.o(63873);
          return;
        }
        if (Build.VERSION.SDK_INT < 21)
        {
          AppMethodBeat.o(63873);
          continue;
        }
        localObject = android.webkit.CookieManager.getInstance();
      }
      finally {}
      Class localClass = Boolean.TYPE;
      paramWebView = paramWebView.getView();
      r.a(localObject, "setAcceptThirdPartyCookies", new Class[] { android.webkit.WebView.class, localClass }, new Object[] { paramWebView, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(63873);
    }
  }
  
  public void setCookie(String paramString1, String paramString2)
  {
    try
    {
      AppMethodBeat.i(63875);
      setCookie(paramString1, paramString2, false);
      AppMethodBeat.o(63875);
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
    //   2: ldc_w 420
    //   5: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 110	com/tencent/smtt/sdk/bz:a	()Lcom/tencent/smtt/sdk/bz;
    //   11: astore 4
    //   13: aload 4
    //   15: ifnull +73 -> 88
    //   18: aload 4
    //   20: invokevirtual 112	com/tencent/smtt/sdk/bz:b	()Z
    //   23: ifeq +65 -> 88
    //   26: aload 4
    //   28: invokevirtual 306	com/tencent/smtt/sdk/bz:c	()Lcom/tencent/smtt/sdk/ca;
    //   31: invokevirtual 318	com/tencent/smtt/sdk/ca:b	()Lcom/tencent/smtt/export/external/DexLoader;
    //   34: ldc_w 326
    //   37: ldc_w 422
    //   40: iconst_3
    //   41: anewarray 149	java/lang/Class
    //   44: dup
    //   45: iconst_0
    //   46: ldc 151
    //   48: aastore
    //   49: dup
    //   50: iconst_1
    //   51: ldc 151
    //   53: aastore
    //   54: dup
    //   55: iconst_2
    //   56: ldc 153
    //   58: aastore
    //   59: iconst_3
    //   60: anewarray 4	java/lang/Object
    //   63: dup
    //   64: iconst_0
    //   65: aload_1
    //   66: aastore
    //   67: dup
    //   68: iconst_1
    //   69: aload_2
    //   70: aastore
    //   71: dup
    //   72: iconst_2
    //   73: aload_3
    //   74: aastore
    //   75: invokevirtual 334	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   78: pop
    //   79: ldc_w 420
    //   82: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: aload_0
    //   86: monitorexit
    //   87: return
    //   88: invokestatic 110	com/tencent/smtt/sdk/bz:a	()Lcom/tencent/smtt/sdk/bz;
    //   91: invokevirtual 423	com/tencent/smtt/sdk/bz:d	()Z
    //   94: ifne +65 -> 159
    //   97: new 8	com/tencent/smtt/sdk/CookieManager$b
    //   100: dup
    //   101: aload_0
    //   102: invokespecial 426	com/tencent/smtt/sdk/CookieManager$b:<init>	(Lcom/tencent/smtt/sdk/CookieManager;)V
    //   105: astore 4
    //   107: aload 4
    //   109: iconst_1
    //   110: putfield 127	com/tencent/smtt/sdk/CookieManager$b:a	I
    //   113: aload 4
    //   115: aload_1
    //   116: putfield 129	com/tencent/smtt/sdk/CookieManager$b:b	Ljava/lang/String;
    //   119: aload 4
    //   121: aload_2
    //   122: putfield 131	com/tencent/smtt/sdk/CookieManager$b:c	Ljava/lang/String;
    //   125: aload 4
    //   127: aload_3
    //   128: putfield 134	com/tencent/smtt/sdk/CookieManager$b:d	Lcom/tencent/smtt/sdk/ValueCallback;
    //   131: aload_0
    //   132: getfield 99	com/tencent/smtt/sdk/CookieManager:a	Ljava/util/ArrayList;
    //   135: ifnonnull +14 -> 149
    //   138: aload_0
    //   139: new 101	java/util/ArrayList
    //   142: dup
    //   143: invokespecial 427	java/util/ArrayList:<init>	()V
    //   146: putfield 99	com/tencent/smtt/sdk/CookieManager:a	Ljava/util/ArrayList;
    //   149: aload_0
    //   150: getfield 99	com/tencent/smtt/sdk/CookieManager:a	Ljava/util/ArrayList;
    //   153: aload 4
    //   155: invokevirtual 431	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   158: pop
    //   159: aload_0
    //   160: getfield 39	com/tencent/smtt/sdk/CookieManager:f	Z
    //   163: ifeq +69 -> 232
    //   166: getstatic 63	android/os/Build$VERSION:SDK_INT	I
    //   169: bipush 21
    //   171: if_icmpge +17 -> 188
    //   174: ldc_w 420
    //   177: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   180: goto -95 -> 85
    //   183: astore_1
    //   184: aload_0
    //   185: monitorexit
    //   186: aload_1
    //   187: athrow
    //   188: invokestatic 146	android/webkit/CookieManager:getInstance	()Landroid/webkit/CookieManager;
    //   191: ldc 147
    //   193: iconst_3
    //   194: anewarray 149	java/lang/Class
    //   197: dup
    //   198: iconst_0
    //   199: ldc 151
    //   201: aastore
    //   202: dup
    //   203: iconst_1
    //   204: ldc 151
    //   206: aastore
    //   207: dup
    //   208: iconst_2
    //   209: ldc 153
    //   211: aastore
    //   212: iconst_3
    //   213: anewarray 4	java/lang/Object
    //   216: dup
    //   217: iconst_0
    //   218: aload_1
    //   219: aastore
    //   220: dup
    //   221: iconst_1
    //   222: aload_2
    //   223: aastore
    //   224: dup
    //   225: iconst_2
    //   226: aload_3
    //   227: aastore
    //   228: invokestatic 158	com/tencent/smtt/utils/r:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   231: pop
    //   232: ldc_w 420
    //   235: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   238: goto -153 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	this	CookieManager
    //   0	241	1	paramString1	String
    //   0	241	2	paramString2	String
    //   0	241	3	paramValueCallback	ValueCallback<Boolean>
    //   11	143	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	13	183	finally
    //   18	85	183	finally
    //   88	149	183	finally
    //   149	159	183	finally
    //   159	180	183	finally
    //   188	232	183	finally
    //   232	238	183	finally
  }
  
  /* Error */
  public void setCookie(String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 433
    //   5: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 110	com/tencent/smtt/sdk/bz:a	()Lcom/tencent/smtt/sdk/bz;
    //   11: astore 4
    //   13: aload 4
    //   15: ifnull +64 -> 79
    //   18: aload 4
    //   20: invokevirtual 112	com/tencent/smtt/sdk/bz:b	()Z
    //   23: ifeq +56 -> 79
    //   26: aload 4
    //   28: invokevirtual 306	com/tencent/smtt/sdk/bz:c	()Lcom/tencent/smtt/sdk/ca;
    //   31: invokevirtual 318	com/tencent/smtt/sdk/ca:b	()Lcom/tencent/smtt/export/external/DexLoader;
    //   34: ldc_w 326
    //   37: ldc_w 422
    //   40: iconst_2
    //   41: anewarray 149	java/lang/Class
    //   44: dup
    //   45: iconst_0
    //   46: ldc 151
    //   48: aastore
    //   49: dup
    //   50: iconst_1
    //   51: ldc 151
    //   53: aastore
    //   54: iconst_2
    //   55: anewarray 4	java/lang/Object
    //   58: dup
    //   59: iconst_0
    //   60: aload_1
    //   61: aastore
    //   62: dup
    //   63: iconst_1
    //   64: aload_2
    //   65: aastore
    //   66: invokevirtual 334	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   69: pop
    //   70: ldc_w 433
    //   73: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: aload_0
    //   77: monitorexit
    //   78: return
    //   79: aload_0
    //   80: getfield 39	com/tencent/smtt/sdk/CookieManager:f	Z
    //   83: ifne +7 -> 90
    //   86: iload_3
    //   87: ifeq +11 -> 98
    //   90: invokestatic 146	android/webkit/CookieManager:getInstance	()Landroid/webkit/CookieManager;
    //   93: aload_1
    //   94: aload_2
    //   95: invokevirtual 159	android/webkit/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: invokestatic 110	com/tencent/smtt/sdk/bz:a	()Lcom/tencent/smtt/sdk/bz;
    //   101: invokevirtual 423	com/tencent/smtt/sdk/bz:d	()Z
    //   104: ifne +65 -> 169
    //   107: new 8	com/tencent/smtt/sdk/CookieManager$b
    //   110: dup
    //   111: aload_0
    //   112: invokespecial 426	com/tencent/smtt/sdk/CookieManager$b:<init>	(Lcom/tencent/smtt/sdk/CookieManager;)V
    //   115: astore 4
    //   117: aload 4
    //   119: iconst_2
    //   120: putfield 127	com/tencent/smtt/sdk/CookieManager$b:a	I
    //   123: aload 4
    //   125: aload_1
    //   126: putfield 129	com/tencent/smtt/sdk/CookieManager$b:b	Ljava/lang/String;
    //   129: aload 4
    //   131: aload_2
    //   132: putfield 131	com/tencent/smtt/sdk/CookieManager$b:c	Ljava/lang/String;
    //   135: aload 4
    //   137: aconst_null
    //   138: putfield 134	com/tencent/smtt/sdk/CookieManager$b:d	Lcom/tencent/smtt/sdk/ValueCallback;
    //   141: aload_0
    //   142: getfield 99	com/tencent/smtt/sdk/CookieManager:a	Ljava/util/ArrayList;
    //   145: ifnonnull +14 -> 159
    //   148: aload_0
    //   149: new 101	java/util/ArrayList
    //   152: dup
    //   153: invokespecial 427	java/util/ArrayList:<init>	()V
    //   156: putfield 99	com/tencent/smtt/sdk/CookieManager:a	Ljava/util/ArrayList;
    //   159: aload_0
    //   160: getfield 99	com/tencent/smtt/sdk/CookieManager:a	Ljava/util/ArrayList;
    //   163: aload 4
    //   165: invokevirtual 431	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   168: pop
    //   169: ldc_w 433
    //   172: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: goto -99 -> 76
    //   178: astore_1
    //   179: aload_0
    //   180: monitorexit
    //   181: aload_1
    //   182: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	CookieManager
    //   0	183	1	paramString1	String
    //   0	183	2	paramString2	String
    //   0	183	3	paramBoolean	boolean
    //   11	153	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	13	178	finally
    //   18	76	178	finally
    //   79	86	178	finally
    //   90	98	178	finally
    //   98	159	178	finally
    //   159	169	178	finally
    //   169	175	178	finally
  }
  
  public boolean setCookieCompatialbeMode(Context paramContext, CookieManager.a parama, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(63883);
    System.currentTimeMillis();
    if ((paramContext == null) || (!TbsExtensionFunctionManager.getInstance().canUseFunction(paramContext, "cookie_switch.txt")))
    {
      AppMethodBeat.o(63883);
      return false;
    }
    this.c = parama;
    if (paramString != null) {
      this.b = paramString;
    }
    if ((this.c != CookieManager.a.a) && (paramBoolean) && (!bz.a().d())) {
      bz.a().a(paramContext, null);
    }
    AppMethodBeat.o(63883);
    return true;
  }
  
  public void setCookies(Map<String, String[]> paramMap)
  {
    AppMethodBeat.i(63881);
    Object localObject = bz.a();
    if ((localObject != null) && (((bz)localObject).b())) {}
    for (boolean bool = ((bz)localObject).c().a(paramMap);; bool = false)
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
      AppMethodBeat.o(63881);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.CookieManager
 * JD-Core Version:    0.7.0.1
 */