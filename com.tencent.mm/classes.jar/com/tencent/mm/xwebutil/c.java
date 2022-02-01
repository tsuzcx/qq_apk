package com.tencent.mm.xwebutil;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.f.a.aco;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.f.p;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.PreInitCallback;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.aj;
import com.tencent.xweb.ak;
import com.tencent.xweb.al;
import com.tencent.xweb.p.a;
import com.tencent.xweb.y;
import java.util.HashMap;
import org.xwalk.core.XWalkEnvironment;

public final class c
{
  static a ZaT = null;
  static boolean ZaU = false;
  static boolean ZaV = false;
  static String ZaW = "20200615";
  static String ZaX = null;
  static String ZaY = null;
  static int ZaZ = 3600000;
  static long Zba = 3600000L;
  
  private static void a(Context paramContext, WebView.c paramc, WebView.PreInitCallback paramPreInitCallback)
  {
    AppMethodBeat.i(152951);
    WebView.PreInitCallback local1 = new WebView.PreInitCallback()
    {
      public final void bEj()
      {
        AppMethodBeat.i(152943);
        com.tencent.mm.sdk.platformtools.Log.i("XWebUtil", "onCoreInitFailed");
        aco localaco = new aco();
        localaco.gcP.success = false;
        EventCenter.instance.publish(localaco);
        if (this.Zbb != null) {
          this.Zbb.bEj();
        }
        AppMethodBeat.o(152943);
      }
      
      public final void onCoreInitFinished()
      {
        AppMethodBeat.i(152942);
        com.tencent.mm.sdk.platformtools.Log.i("XWebUtil", "onCoreInitFinished");
        aco localaco = new aco();
        localaco.gcP.success = true;
        EventCenter.instance.publish(localaco);
        if (this.Zbb != null) {
          this.Zbb.onCoreInitFinished();
        }
        AppMethodBeat.o(152942);
      }
    };
    paramPreInitCallback = paramContext;
    if (paramContext == null) {
      paramPreInitCallback = MMApplicationContext.getContext();
    }
    lQ(paramPreInitCallback);
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.Log.getLogLevel() <= 1)) {}
    try
    {
      y.iwp().iws();
      WebView.initWebviewCore(paramPreInitCallback, paramc, b.getModuleName(), local1);
      if (("mm".equals(b.getModuleName())) && (ar.isDarkMode())) {
        aj.iwO();
      }
      if (ikm()) {
        XWalkEnvironment.setUsingCustomContext(true);
      }
      AppMethodBeat.o(152951);
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        org.xwalk.core.Log.e("XWebUtil", "turn on xweb debug failed , exp = " + paramContext.getMessage());
      }
    }
  }
  
  public static void a(a parama)
  {
    try
    {
      AppMethodBeat.i(225023);
      ZaT = parama;
      iki();
      com.tencent.mm.sdk.platformtools.Log.i("XWebUtil", "setExpansionImp stack = ");
      AppMethodBeat.o(225023);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public static void a(WebView.PreInitCallback paramPreInitCallback)
  {
    AppMethodBeat.i(225038);
    a(MMWebView.Yct, paramPreInitCallback);
    AppMethodBeat.o(225038);
  }
  
  public static void a(WebView.c paramc)
  {
    AppMethodBeat.i(225036);
    a(paramc, null);
    AppMethodBeat.o(225036);
  }
  
  public static void a(WebView.c paramc, WebView.PreInitCallback paramPreInitCallback)
  {
    AppMethodBeat.i(152950);
    a(MMApplicationContext.getContext(), paramc, paramPreInitCallback);
    AppMethodBeat.o(152950);
  }
  
  public static void bCD(String paramString)
  {
    AppMethodBeat.i(152945);
    bCE(paramString);
    bCF(paramString);
    AppMethodBeat.o(152945);
  }
  
  private static void bCE(String paramString)
  {
    AppMethodBeat.i(152947);
    if (("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS".equals(paramString)) && (!MMApplicationContext.isProcessExist(MMApplicationContext.getPackageName() + ":tools")))
    {
      AppMethodBeat.o(152947);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName(f.p.VSB, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
    localIntent.putExtra("tools_process_action_code_key", paramString);
    MMApplicationContext.getContext().sendBroadcast(localIntent);
    AppMethodBeat.o(152947);
  }
  
  public static void bCF(String paramString)
  {
    AppMethodBeat.i(152948);
    if (com.tencent.mm.by.c.aFM())
    {
      AppMethodBeat.o(152948);
      return;
    }
    if (("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS".equals(paramString)) && (!MMApplicationContext.isProcessExist(MMApplicationContext.getPackageName() + ":toolsmp")))
    {
      AppMethodBeat.o(152948);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName(f.p.VSB, "com.tencent.mm.booter.MMReceivers$ToolsMpProcessReceiver"));
    localIntent.putExtra("tools_process_action_code_key", paramString);
    MMApplicationContext.getContext().sendBroadcast(localIntent);
    AppMethodBeat.o(152948);
  }
  
  public static void bN(Intent paramIntent)
  {
    AppMethodBeat.i(152946);
    paramIntent.setComponent(new ComponentName(f.p.VSB, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
    MMApplicationContext.getContext().sendBroadcast(paramIntent);
    if (com.tencent.mm.by.c.aFM())
    {
      AppMethodBeat.o(152946);
      return;
    }
    paramIntent.setComponent(new ComponentName(f.p.VSB, "com.tencent.mm.booter.MMReceivers$ToolsMpProcessReceiver"));
    MMApplicationContext.getContext().sendBroadcast(paramIntent);
    AppMethodBeat.o(152946);
  }
  
  public static void ikh()
  {
    AppMethodBeat.i(152944);
    bCE("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
    bCF("com.tencent.mm.intent.ACTION_START_MPTOOLS_PROCESS");
    AppMethodBeat.o(152944);
  }
  
  /* Error */
  private static void iki()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 261
    //   6: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 28	com/tencent/mm/xwebutil/c:ZaT	Lcom/tencent/mm/xwebutil/c$a;
    //   12: ifnonnull +25 -> 37
    //   15: ldc 143
    //   17: ldc_w 263
    //   20: invokestatic 266	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: iconst_0
    //   24: invokestatic 271	com/tencent/xweb/ak:IM	(Z)V
    //   27: ldc_w 261
    //   30: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: ldc 2
    //   35: monitorexit
    //   36: return
    //   37: ldc 143
    //   39: ldc_w 273
    //   42: invokestatic 175	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: getstatic 28	com/tencent/mm/xwebutil/c:ZaT	Lcom/tencent/mm/xwebutil/c$a;
    //   48: invokeinterface 276 1 0
    //   53: istore_0
    //   54: iload_0
    //   55: invokestatic 271	com/tencent/xweb/ak:IM	(Z)V
    //   58: iload_0
    //   59: ifeq +14 -> 73
    //   62: getstatic 28	com/tencent/mm/xwebutil/c:ZaT	Lcom/tencent/mm/xwebutil/c$a;
    //   65: invokeinterface 279 1 0
    //   70: invokestatic 282	com/tencent/xweb/ak:bFr	(Ljava/lang/String;)V
    //   73: ldc_w 261
    //   76: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: goto -46 -> 33
    //   82: astore_1
    //   83: ldc 2
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   53	6	0	bool	boolean
    //   82	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	33	82	finally
    //   37	58	82	finally
    //   62	73	82	finally
    //   73	79	82	finally
  }
  
  private static y ikj()
  {
    AppMethodBeat.i(225051);
    if (y.iwp() == null) {
      y.mA(MMApplicationContext.getContext());
    }
    y localy = y.iwp();
    AppMethodBeat.o(225051);
    return localy;
  }
  
  private static void ikk()
  {
    AppMethodBeat.i(225062);
    try
    {
      if (h.ae(com.tencent.mm.plugin.expt.b.b.class) == null)
      {
        com.tencent.mm.sdk.platformtools.Log.i("XWebUtil", "gMMKernel.service(IExptService.class) == null ");
        AppMethodBeat.o(225062);
        return;
      }
      int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wbz, 0);
      if (i != 1)
      {
        AppMethodBeat.o(225062);
        return;
      }
      com.tencent.mm.sdk.platformtools.Log.i("XWebUtil", "got  clicfg_xweb_debug_check_value == 1 ");
      int j;
      int k;
      int m;
      String str;
      return;
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wby, 0) == 1)
        {
          com.tencent.mm.sdk.platformtools.Log.i("XWebUtil", "turnonDebugMode is true ");
          ikj().iws();
        }
        i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wbA, 0);
        j = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wbB, 0);
        k = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wbD, 0);
        m = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wbC, 0);
        com.tencent.mm.sdk.platformtools.Log.i("XWebUtil", "moduleToolsType:" + i + ";moduleAppbrandType:" + m + ";moduleMMType" + k + ":moduleToolsMpType" + j);
        ikj().b("tools", WebView.c.values()[i]);
        ikj().b("toolsmp", WebView.c.values()[j]);
        ikj().b("mm", WebView.c.values()[k]);
        ikj().b("appbrand", WebView.c.values()[m]);
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.Log.e("XWebUtil", "xweb abtest crashed , exception = " + localThrowable2.getMessage());
        }
      }
      try
      {
        str = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wbE, "");
        if (!TextUtils.isEmpty(str)) {
          XWalkEnvironment.setTempUpdateConfigUrl(str, ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wbF, ""));
        }
        str = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wbG, "");
        if (!TextUtils.isEmpty(str)) {
          XWalkEnvironment.setTempUpdateConfigUrl(str, ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wbH, ""));
        }
        AppMethodBeat.o(225062);
        return;
      }
      catch (Throwable localThrowable3)
      {
        com.tencent.mm.sdk.platformtools.Log.e("XWebUtil", "xweb abtest set url crashed , exception = " + localThrowable3.getMessage());
        AppMethodBeat.o(225062);
      }
      localThrowable1 = localThrowable1;
      com.tencent.mm.sdk.platformtools.Log.e("XWebUtil", "xweb abtest clicfg_xweb_debug_check_value crashed , exception = " + localThrowable1.getMessage());
      AppMethodBeat.o(225062);
      return;
    }
  }
  
  private static void ikl()
  {
    AppMethodBeat.i(152953);
    HashMap localHashMap = new HashMap();
    localHashMap.put("isgpversion", Boolean.valueOf(ChannelUtil.isGPVersion()));
    localHashMap.put("processname", MMApplicationContext.getProcessName());
    localHashMap.put("is64bitabi", Boolean.valueOf(q.is64BitRuntime()));
    XWalkEnvironment.setXWebInitArgs(localHashMap);
    AppMethodBeat.o(152953);
  }
  
  public static boolean ikm()
  {
    AppMethodBeat.i(152954);
    if (WebView.getCurWebType() == WebView.c.aabm)
    {
      boolean bool = XWalkEnvironment.isCurrentVersionSupportCustomContext();
      AppMethodBeat.o(152954);
      return bool;
    }
    AppMethodBeat.o(152954);
    return false;
  }
  
  public static boolean lP(Context paramContext)
  {
    AppMethodBeat.i(152949);
    if ((WebView.isX5()) && (WebView.getUsingTbsCoreVersion(paramContext) <= 36541))
    {
      com.tencent.mm.sdk.platformtools.Log.i("XWebUtil", "lower version of x5 not support source type ");
      AppMethodBeat.o(152949);
      return false;
    }
    AppMethodBeat.o(152949);
    return true;
  }
  
  public static void lQ(Context paramContext)
  {
    AppMethodBeat.i(152952);
    if (paramContext == null) {
      paramContext = MMApplicationContext.getContext();
    }
    for (;;)
    {
      ikk();
      com.tencent.xweb.p.aaaw = new p.a()
      {
        public final void KW(String paramAnonymousString)
        {
          AppMethodBeat.i(200549);
          j.KW(paramAnonymousString);
          AppMethodBeat.o(200549);
        }
      };
      com.tencent.mm.sdk.platformtools.Log.i("XWebUtil", "[initXWebEnviroment] application language:" + LocaleUtil.getApplicationLanguage());
      al.a(paramContext, LocaleUtil.transLanguageToLocale(LocaleUtil.getApplicationLanguage()), b.ZaP, b.ZaS, b.ZaQ, b.ZaR);
      aj.iwN();
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG))
      {
        XWalkEnvironment.setTempUpdateConfigUrl("https://dldir1.qq.com/weixin/android/wxweb/updateConfig_test.xml");
        XWalkEnvironment.setTempPluginUpdateConfigUrl("https://dldir1.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig_exp.xml");
      }
      for (;;)
      {
        XWalkEnvironment.setTempPluginUpdatePeriod(ZaZ);
        XWalkEnvironment.setConfigFetchPeriod(Zba);
        do
        {
          iki();
          ak.IN(ChannelUtil.isGPVersion());
          XWalkEnvironment.setAppClientVersion(BuildInfo.CLIENT_VERSION_INT);
          ikl();
          if (ChannelUtil.isGPVersion())
          {
            com.tencent.xweb.x5.sdk.d.forceSysWebView();
            XWalkEnvironment.appendAppInfo("GP_USER");
          }
          AppMethodBeat.o(152952);
          return;
          if (com.tencent.mm.protocal.d.RAG) {
            break;
          }
        } while (!com.tencent.mm.protocal.d.RAF);
        if (ZaU) {
          XWalkEnvironment.setTempUpdateConfigUrl("https://dldir1.qq.com/weixin/android/wxweb/test_" + BuildInfo.CLIENT_VERSION + "_main.xml", ZaW);
        }
        for (;;)
        {
          if (!ZaV) {
            break label262;
          }
          XWalkEnvironment.setTempPluginUpdateConfigUrl("https://dldir1.qq.com/weixin/android/wxweb/plugin/test_" + BuildInfo.CLIENT_VERSION + "_plugin.xml", ZaW);
          break;
          XWalkEnvironment.setTempUpdateConfigUrl(ZaX, ZaW);
        }
        label262:
        XWalkEnvironment.setTempPluginUpdateConfigUrl(ZaX, ZaW);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean Vt();
    
    public abstract String dbg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.xwebutil.c
 * JD-Core Version:    0.7.0.1
 */