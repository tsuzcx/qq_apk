package com.tencent.smtt.sdk.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5CoreCacheManager;
import com.tencent.smtt.export.external.interfaces.IX5CoreCookieManager;
import com.tencent.smtt.export.external.interfaces.IX5CoreEntry;
import com.tencent.smtt.export.external.interfaces.IX5CoreGeolocationPermissions;
import com.tencent.smtt.export.external.interfaces.IX5CoreJsCore;
import com.tencent.smtt.export.external.interfaces.IX5CoreMessy;
import com.tencent.smtt.export.external.interfaces.IX5CoreNetwork;
import com.tencent.smtt.export.external.interfaces.IX5CoreOptimizedBitmap;
import com.tencent.smtt.export.external.interfaces.IX5CoreUrlUtil;
import com.tencent.smtt.export.external.interfaces.IX5CoreWebIconDB;
import com.tencent.smtt.export.external.interfaces.IX5CoreWebStorage;
import com.tencent.smtt.export.external.interfaces.IX5CoreWebViewDB;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsCoreLoadStat;
import com.tencent.smtt.sdk.TbsShareManager;
import com.tencent.smtt.utils.TbsLog;
import dalvik.system.DexClassLoader;
import java.lang.reflect.Method;
import java.util.Map;

public class b
  implements IX5CoreEntry
{
  DexLoader a;
  Context b;
  Context c;
  String d;
  String e;
  
  public b(DexLoader paramDexLoader, Context paramContext1, Context paramContext2, String paramString1, String paramString2)
  {
    this.a = paramDexLoader;
    this.b = paramContext1;
    this.c = paramContext2;
    this.d = paramString1;
    this.e = paramString2;
  }
  
  public boolean canLoadX5(Context paramContext)
  {
    return false;
  }
  
  public boolean canUseX5()
  {
    AppMethodBeat.i(197375);
    new Throwable();
    try
    {
      localObject1 = this.a.getClassLoader().loadClass("com.tencent.tbs.tbsshell.WebCoreProxy").getMethod("canUseX5", new Class[0]);
      ((Method)localObject1).setAccessible(true);
      localObject1 = ((Method)localObject1).invoke(null, new Object[0]);
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        Object localObject1;
        boolean bool;
        label86:
        Object localObject2 = null;
      }
    }
    try
    {
      if ((localObject1 instanceof Boolean))
      {
        TbsLog.d("DexLoaderX5CoreEntry", "canUseX5 objRet=".concat(String.valueOf(localObject1)));
        bool = ((Boolean)localObject1).booleanValue();
        AppMethodBeat.o(197375);
        return bool;
      }
    }
    catch (Throwable localThrowable2)
    {
      break label86;
    }
    bool = ((Boolean)localObject1).booleanValue();
    AppMethodBeat.o(197375);
    return bool;
  }
  
  public IX5WebViewBase createX5WebView(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(197380);
    localObject3 = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createSDKWebview", new Class[] { Context.class }, new Object[] { paramContext });
    if (localObject3 == null) {}
    for (;;)
    {
      try
      {
        localObject1 = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
        if ((localObject1 != null) && ((localObject1 instanceof Throwable))) {
          TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 325, (Throwable)localObject1);
        }
        if ((localObject1 != null) && ((localObject1 instanceof String))) {
          TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 325, new Throwable((String)localObject1));
        }
        localObject1 = null;
        localObject2 = null;
      }
      catch (Exception paramContext)
      {
        IX5WebViewBase localIX5WebViewBase;
        Object localObject1 = null;
        Object localObject2 = localObject3;
        continue;
        continue;
      }
      if (localObject2 == null)
      {
        AppMethodBeat.o(197380);
        return null;
        localIX5WebViewBase = (IX5WebViewBase)localObject3;
        localObject1 = localIX5WebViewBase;
        localObject2 = localObject3;
        if (localIX5WebViewBase == null) {
          continue;
        }
        localObject1 = localIX5WebViewBase;
        localObject2 = localObject3;
      }
      try
      {
        if (localIX5WebViewBase.getView() == null)
        {
          TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 325, new Throwable("x5webview.getView is null!"));
          localObject2 = null;
          localObject1 = localIX5WebViewBase;
        }
      }
      catch (Exception paramContext)
      {
        localObject1 = localIX5WebViewBase;
        localObject2 = localObject3;
      }
    }
    AppMethodBeat.o(197380);
    return localObject1;
  }
  
  public int getCoreVersion()
  {
    return 0;
  }
  
  public IX5CoreCacheManager getX5CoreCacheManager()
  {
    AppMethodBeat.i(197384);
    a locala = new a(this.a);
    AppMethodBeat.o(197384);
    return locala;
  }
  
  public IX5CoreCookieManager getX5CoreCookieManager()
  {
    AppMethodBeat.i(197383);
    j localj = new j(this.a);
    AppMethodBeat.o(197383);
    return localj;
  }
  
  public IX5CoreGeolocationPermissions getX5CoreGeolocationPermissions()
  {
    AppMethodBeat.i(197399);
    k localk = new k(this.a);
    AppMethodBeat.o(197399);
    return localk;
  }
  
  public IX5CoreJsCore getX5CoreJsCore()
  {
    AppMethodBeat.i(197397);
    n localn = new n(this.a);
    AppMethodBeat.o(197397);
    return localn;
  }
  
  public IX5CoreMessy getX5CoreMessy()
  {
    AppMethodBeat.i(197385);
    l locall = new l(this.a, this.b);
    AppMethodBeat.o(197385);
    return locall;
  }
  
  public IX5CoreNetwork getX5CoreNetwork()
  {
    AppMethodBeat.i(197387);
    m localm = new m(this.a);
    AppMethodBeat.o(197387);
    return localm;
  }
  
  public IX5CoreOptimizedBitmap getX5CoreOptimizedBitmap()
  {
    return null;
  }
  
  public IX5CoreUrlUtil getX5CoreUrlUtil()
  {
    AppMethodBeat.i(197388);
    f localf = new f(this.a);
    AppMethodBeat.o(197388);
    return localf;
  }
  
  public IX5CoreWebIconDB getX5CoreWebIconDB()
  {
    AppMethodBeat.i(197390);
    g localg = new g(this.a);
    AppMethodBeat.o(197390);
    return localg;
  }
  
  public IX5CoreWebStorage getX5CoreWebStorage()
  {
    AppMethodBeat.i(197393);
    h localh = new h(this.a);
    AppMethodBeat.o(197393);
    return localh;
  }
  
  public IX5CoreWebViewDB getX5CoreWebViewDB()
  {
    AppMethodBeat.i(197395);
    i locali = new i(this.a);
    AppMethodBeat.o(197395);
    return locali;
  }
  
  public void initRuntimeEnvironment()
  {
    AppMethodBeat.i(197364);
    Object localObject1;
    Object localObject2;
    Context localContext;
    Object localObject3;
    Object localObject4;
    String str1;
    String str2;
    String str3;
    int i;
    if ((this.c == null) && (TbsShareManager.getHostCorePathAppDefined() != null))
    {
      localObject1 = this.a;
      localObject2 = Integer.TYPE;
      localContext = this.b;
      localObject3 = this.c;
      localObject4 = this.a;
      str1 = this.d;
      str2 = this.e;
      str3 = QbSdk.getTbsCoreVersionString();
      String str4 = TbsShareManager.getHostCorePathAppDefined();
      localObject1 = ((DexLoader)localObject1).invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[] { Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, localObject2, String.class, String.class }, new Object[] { localContext, localObject3, localObject4, str1, str2, "4.4.0.0052", Integer.valueOf(44052), str3, str4 });
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = this.a;
        localObject2 = this.b;
        localContext = this.c;
        localObject3 = this.a;
        localObject4 = this.d;
        str1 = this.e;
        localObject2 = ((DexLoader)localObject1).invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[] { Context.class, Context.class, DexLoader.class, String.class, String.class }, new Object[] { localObject2, localContext, localObject3, localObject4, str1 });
      }
      if (localObject2 != null) {
        break label621;
      }
      i = -3;
    }
    for (;;)
    {
      if (i < 0)
      {
        localObject1 = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
        TbsLog.d("DexLoaderX5CoreEntry", "tbswizard.init --> getLoadFailureDetails:".concat(String.valueOf(localObject1)));
        if ((localObject1 instanceof Throwable))
        {
          localObject1 = (Throwable)localObject1;
          new StringBuilder("#").append(((Throwable)localObject1).getMessage()).append("; cause: ").append(((Throwable)localObject1).getCause()).append("; th: ").append(localObject1);
        }
      }
      AppMethodBeat.o(197364);
      return;
      TbsLog.i("DexLoaderX5CoreEntry", "initTesRuntimeEnvironment callerContext is " + this.b + " mHostContext is " + this.c + " mDexLoader is " + this.a + " mtbsInstallLocation is " + this.d + " mDexOptPath is " + this.e);
      localObject1 = this.a;
      localObject2 = Integer.TYPE;
      localContext = this.b;
      localObject3 = this.c;
      localObject4 = this.a;
      str1 = this.d;
      str2 = this.e;
      str3 = QbSdk.getTbsCoreVersionString();
      localObject1 = ((DexLoader)localObject1).invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[] { Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, localObject2, String.class }, new Object[] { localContext, localObject3, localObject4, str1, str2, "4.4.0.0052", Integer.valueOf(44052), str3 });
      break;
      label621:
      if ((localObject2 instanceof Integer))
      {
        i = ((Integer)localObject2).intValue();
      }
      else if ((localObject2 instanceof Throwable))
      {
        TbsCoreLoadStat.getInstance().setLoadErrorCode(this.b, 328, (Throwable)localObject2);
        i = -5;
      }
      else
      {
        i = -4;
      }
    }
  }
  
  public void initSettings(Map paramMap)
  {
    AppMethodBeat.i(197366);
    paramMap = this.a;
    Map localMap = QbSdk.mSettings;
    paramMap.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTbsSettings", new Class[] { Map.class }, new Object[] { localMap });
    AppMethodBeat.o(197366);
  }
  
  public void setQua1(String paramString) {}
  
  public void setQua2_v3(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean) {}
  
  public void setSdkVersionCode(int paramInt)
  {
    AppMethodBeat.i(197370);
    this.a.setStaticField("com.tencent.tbs.tbsshell.TBSShell", "VERSION", Integer.valueOf(44052));
    AppMethodBeat.o(197370);
  }
  
  public void setSdkVersionName(String paramString)
  {
    AppMethodBeat.i(197368);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "setTesSdkVersionName", new Class[] { String.class }, new Object[] { "4.4.0.0052" });
    AppMethodBeat.o(197368);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.b.b
 * JD-Core Version:    0.7.0.1
 */