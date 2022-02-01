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
  
  /* Error */
  public boolean canUseX5()
  {
    // Byte code:
    //   0: ldc 35
    //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 43	java/lang/Throwable
    //   8: dup
    //   9: invokespecial 44	java/lang/Throwable:<init>	()V
    //   12: pop
    //   13: aload_0
    //   14: getfield 21	com/tencent/smtt/sdk/b/b:a	Lcom/tencent/smtt/export/external/DexLoader;
    //   17: invokevirtual 50	com/tencent/smtt/export/external/DexLoader:getClassLoader	()Ldalvik/system/DexClassLoader;
    //   20: ldc 52
    //   22: invokevirtual 58	dalvik/system/DexClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   25: ldc 59
    //   27: iconst_0
    //   28: anewarray 61	java/lang/Class
    //   31: invokevirtual 65	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   34: astore_2
    //   35: aload_2
    //   36: iconst_1
    //   37: invokevirtual 71	java/lang/reflect/Method:setAccessible	(Z)V
    //   40: aload_2
    //   41: aconst_null
    //   42: iconst_0
    //   43: anewarray 4	java/lang/Object
    //   46: invokevirtual 75	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   49: astore_2
    //   50: aload_2
    //   51: instanceof 77
    //   54: ifeq +32 -> 86
    //   57: ldc 79
    //   59: ldc 81
    //   61: aload_2
    //   62: invokestatic 87	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   65: invokevirtual 91	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   68: invokestatic 96	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: aload_2
    //   72: checkcast 77	java/lang/Boolean
    //   75: invokevirtual 99	java/lang/Boolean:booleanValue	()Z
    //   78: istore_1
    //   79: ldc 35
    //   81: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: iload_1
    //   85: ireturn
    //   86: aload_2
    //   87: checkcast 77	java/lang/Boolean
    //   90: invokevirtual 99	java/lang/Boolean:booleanValue	()Z
    //   93: istore_1
    //   94: ldc 35
    //   96: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: iload_1
    //   100: ireturn
    //   101: astore_2
    //   102: aconst_null
    //   103: astore_2
    //   104: goto -18 -> 86
    //   107: astore_3
    //   108: goto -22 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	b
    //   78	22	1	bool	boolean
    //   34	53	2	localObject1	Object
    //   101	1	2	localObject2	Object
    //   103	1	2	localObject3	Object
    //   107	1	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   13	50	101	finally
    //   50	79	107	finally
  }
  
  public IX5WebViewBase createX5WebView(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(219871);
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
        AppMethodBeat.o(219871);
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
    AppMethodBeat.o(219871);
    return localObject1;
  }
  
  public int getCoreVersion()
  {
    return 0;
  }
  
  public IX5CoreCacheManager getX5CoreCacheManager()
  {
    AppMethodBeat.i(219882);
    a locala = new a(this.a);
    AppMethodBeat.o(219882);
    return locala;
  }
  
  public IX5CoreCookieManager getX5CoreCookieManager()
  {
    AppMethodBeat.i(219877);
    j localj = new j(this.a);
    AppMethodBeat.o(219877);
    return localj;
  }
  
  public IX5CoreGeolocationPermissions getX5CoreGeolocationPermissions()
  {
    AppMethodBeat.i(219900);
    k localk = new k(this.a);
    AppMethodBeat.o(219900);
    return localk;
  }
  
  public IX5CoreJsCore getX5CoreJsCore()
  {
    AppMethodBeat.i(219899);
    n localn = new n(this.a);
    AppMethodBeat.o(219899);
    return localn;
  }
  
  public IX5CoreMessy getX5CoreMessy()
  {
    AppMethodBeat.i(219886);
    l locall = new l(this.a, this.b);
    AppMethodBeat.o(219886);
    return locall;
  }
  
  public IX5CoreNetwork getX5CoreNetwork()
  {
    AppMethodBeat.i(219889);
    m localm = new m(this.a);
    AppMethodBeat.o(219889);
    return localm;
  }
  
  public IX5CoreOptimizedBitmap getX5CoreOptimizedBitmap()
  {
    return null;
  }
  
  public IX5CoreUrlUtil getX5CoreUrlUtil()
  {
    AppMethodBeat.i(219892);
    f localf = new f(this.a);
    AppMethodBeat.o(219892);
    return localf;
  }
  
  public IX5CoreWebIconDB getX5CoreWebIconDB()
  {
    AppMethodBeat.i(219893);
    g localg = new g(this.a);
    AppMethodBeat.o(219893);
    return localg;
  }
  
  public IX5CoreWebStorage getX5CoreWebStorage()
  {
    AppMethodBeat.i(219895);
    h localh = new h(this.a);
    AppMethodBeat.o(219895);
    return localh;
  }
  
  public IX5CoreWebViewDB getX5CoreWebViewDB()
  {
    AppMethodBeat.i(219897);
    i locali = new i(this.a);
    AppMethodBeat.o(219897);
    return locali;
  }
  
  public void initRuntimeEnvironment()
  {
    AppMethodBeat.i(219825);
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
      localObject1 = ((DexLoader)localObject1).invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[] { Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, localObject2, String.class, String.class }, new Object[] { localContext, localObject3, localObject4, str1, str2, "4.4.1.0038", Integer.valueOf(44138), str3, str4 });
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
      AppMethodBeat.o(219825);
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
      localObject1 = ((DexLoader)localObject1).invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[] { Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, localObject2, String.class }, new Object[] { localContext, localObject3, localObject4, str1, str2, "4.4.1.0038", Integer.valueOf(44138), str3 });
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
    AppMethodBeat.i(219833);
    paramMap = this.a;
    Map localMap = QbSdk.mSettings;
    paramMap.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTbsSettings", new Class[] { Map.class }, new Object[] { localMap });
    AppMethodBeat.o(219833);
  }
  
  public void setQua1(String paramString) {}
  
  public void setQua2_v3(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean) {}
  
  public void setSdkVersionCode(int paramInt)
  {
    AppMethodBeat.i(219847);
    this.a.setStaticField("com.tencent.tbs.tbsshell.TBSShell", "VERSION", Integer.valueOf(44138));
    AppMethodBeat.o(219847);
  }
  
  public void setSdkVersionName(String paramString)
  {
    AppMethodBeat.i(219841);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "setTesSdkVersionName", new Class[] { String.class }, new Object[] { "4.4.1.0038" });
    AppMethodBeat.o(219841);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.b.b
 * JD-Core Version:    0.7.0.1
 */