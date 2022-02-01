package com.tencent.mm.xwebutil;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.aen;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.f.q;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView.PreInitCallback;
import com.tencent.xweb.WebView.WebViewKind;
import com.tencent.xweb.ao;
import com.tencent.xweb.r.a;
import com.tencent.xweb.x5.a.e;
import java.util.HashMap;

public final class c
{
  private static a agZF = null;
  private static final String agZG = null;
  private static final String agZH = null;
  
  private static void a(Context paramContext, WebView.WebViewKind paramWebViewKind, WebView.PreInitCallback paramPreInitCallback)
  {
    AppMethodBeat.i(231679);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = MMApplicationContext.getContext();
    }
    nU(localContext);
    ao.initWebviewCore(localContext, paramWebViewKind, getModuleName(), b(paramPreInitCallback));
    AppMethodBeat.o(231679);
  }
  
  public static void a(a parama)
  {
    try
    {
      AppMethodBeat.i(231702);
      Log.i("XWeb.MM.XWebUtil", "setExpansionImp:%s", new Object[] { parama });
      agZF = parama;
      AppMethodBeat.o(231702);
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
    AppMethodBeat.i(231671);
    a(MMWebView.afUn, paramPreInitCallback);
    AppMethodBeat.o(231671);
  }
  
  public static void a(WebView.WebViewKind paramWebViewKind)
  {
    AppMethodBeat.i(231665);
    a(paramWebViewKind, null);
    AppMethodBeat.o(231665);
  }
  
  public static void a(WebView.WebViewKind paramWebViewKind, WebView.PreInitCallback paramPreInitCallback)
  {
    AppMethodBeat.i(152950);
    a(MMApplicationContext.getContext(), paramWebViewKind, paramPreInitCallback);
    AppMethodBeat.o(152950);
  }
  
  private static WebView.PreInitCallback b(WebView.PreInitCallback paramPreInitCallback)
  {
    AppMethodBeat.i(231682);
    paramPreInitCallback = new WebView.PreInitCallback()
    {
      public final void aDm()
      {
        AppMethodBeat.i(152943);
        Log.i("XWeb.MM.XWebUtil", "onCoreInitFailed");
        aen localaen = new aen();
        localaen.ijf.success = false;
        localaen.publish();
        if (c.this != null) {
          c.this.aDm();
        }
        AppMethodBeat.o(152943);
      }
      
      public final void onCoreInitFinished()
      {
        AppMethodBeat.i(152942);
        Log.i("XWeb.MM.XWebUtil", "onCoreInitFinished");
        aen localaen = new aen();
        localaen.ijf.success = true;
        localaen.publish();
        if (c.this != null) {
          c.this.onCoreInitFinished();
        }
        AppMethodBeat.o(152942);
      }
    };
    AppMethodBeat.o(231682);
    return paramPreInitCallback;
  }
  
  public static void bFh(String paramString)
  {
    AppMethodBeat.i(152945);
    bFi(paramString);
    bFj(paramString);
    AppMethodBeat.o(152945);
  }
  
  private static void bFi(String paramString)
  {
    AppMethodBeat.i(152947);
    if (("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS".equals(paramString)) && (!MMApplicationContext.isProcessExist(MMApplicationContext.getPackageName() + ":tools")))
    {
      AppMethodBeat.o(152947);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName(f.q.adwK, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
    localIntent.putExtra("tools_process_action_code_key", paramString);
    MMApplicationContext.getContext().sendBroadcast(localIntent);
    AppMethodBeat.o(152947);
  }
  
  private static void bFj(String paramString)
  {
    AppMethodBeat.i(152948);
    if (com.tencent.mm.br.c.aYM())
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
    localIntent.setComponent(new ComponentName(f.q.adwK, "com.tencent.mm.booter.MMReceivers$ToolsMpProcessReceiver"));
    localIntent.putExtra("tools_process_action_code_key", paramString);
    MMApplicationContext.getContext().sendBroadcast(localIntent);
    AppMethodBeat.o(152948);
  }
  
  public static void cs(Intent paramIntent)
  {
    AppMethodBeat.i(152946);
    paramIntent.setComponent(new ComponentName(f.q.adwK, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
    MMApplicationContext.getContext().sendBroadcast(paramIntent);
    if (com.tencent.mm.br.c.aYM())
    {
      AppMethodBeat.o(152946);
      return;
    }
    paramIntent.setComponent(new ComponentName(f.q.adwK, "com.tencent.mm.booter.MMReceivers$ToolsMpProcessReceiver"));
    MMApplicationContext.getContext().sendBroadcast(paramIntent);
    AppMethodBeat.o(152946);
  }
  
  public static String getModuleName()
  {
    AppMethodBeat.i(231694);
    String str = MMApplicationContext.getProcessName();
    if (str == null)
    {
      AppMethodBeat.o(231694);
      return "";
    }
    if (str.contains(":"))
    {
      str = str.substring(str.lastIndexOf(":") + 1).toLowerCase();
      if (str.startsWith("appbrand"))
      {
        AppMethodBeat.o(231694);
        return "appbrand";
      }
      AppMethodBeat.o(231694);
      return str;
    }
    if (str.contains("."))
    {
      str = str.substring(str.lastIndexOf(".") + 1).toLowerCase();
      AppMethodBeat.o(231694);
      return str;
    }
    AppMethodBeat.o(231694);
    return str;
  }
  
  public static boolean isCurrentSupportCustomContext()
  {
    AppMethodBeat.i(152954);
    boolean bool = ao.isCurrentSupportCustomContext();
    AppMethodBeat.o(152954);
    return bool;
  }
  
  private static void jQB()
  {
    AppMethodBeat.i(152953);
    HashMap localHashMap = new HashMap();
    localHashMap.put("isgpversion", Boolean.valueOf(ChannelUtil.isGPVersion()));
    localHashMap.put("processname", MMApplicationContext.getProcessName());
    localHashMap.put("is64bitabi", Boolean.valueOf(q.awm()));
    localHashMap.put("deviceModel", q.aPo());
    localHashMap.put("packageName", MMApplicationContext.getApplicationId());
    Log.i("XWeb.MM.XWebUtil", "initXWebEnvArgs, gpVersion:%s, processName:%s, is64Abi:%s, model:%s, package:%s", new Object[] { Boolean.valueOf(ChannelUtil.isGPVersion()), MMApplicationContext.getProcessName(), Boolean.valueOf(q.awm()), q.aPo(), MMApplicationContext.getApplicationId() });
    ao.setXWebInitArgs(localHashMap);
    AppMethodBeat.o(152953);
  }
  
  public static void jQC()
  {
    AppMethodBeat.i(231689);
    ao.jQC();
    AppMethodBeat.o(231689);
  }
  
  private static void jQD()
  {
    AppMethodBeat.i(231699);
    int i;
    try
    {
      if (h.ax(com.tencent.mm.plugin.expt.b.c.class) == null)
      {
        Log.i("XWeb.MM.XWebUtil", "checkAbTestConfigs, IExptService is null");
        AppMethodBeat.o(231699);
        return;
      }
      i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zuU, 0);
      Log.i("XWeb.MM.XWebUtil", "checkAbTestConfigs, clicfg_xweb_debug_check_value:%s", new Object[] { Integer.valueOf(i) });
      if (i != 1)
      {
        AppMethodBeat.o(231699);
        return;
      }
    }
    finally
    {
      Log.e("XWeb.MM.XWebUtil", "xweb abtest get clicfg_xweb_debug_check_value error:".concat(String.valueOf(localObject1)));
      AppMethodBeat.o(231699);
      return;
    }
    try
    {
      if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zuT, 0) == 1)
      {
        Log.i("XWeb.MM.XWebUtil", "checkAbTestConfigs, turnonDebugMode is true");
        ao.oS(MMApplicationContext.getContext());
      }
      i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zuV, 0);
      int j = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zuW, 0);
      int k = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zuY, 0);
      int m = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zuX, 0);
      Log.i("XWeb.MM.XWebUtil", "checkAbTestConfigs, moduleToolsType:%s; moduleAppbrandType:%s; moduleMMType:%s; moduleToolsMpType:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(j) });
      ao.a(MMApplicationContext.getContext(), "tools", WebView.WebViewKind.values()[i]);
      ao.a(MMApplicationContext.getContext(), "toolsmp", WebView.WebViewKind.values()[j]);
      ao.a(MMApplicationContext.getContext(), "mm", WebView.WebViewKind.values()[k]);
      ao.a(MMApplicationContext.getContext(), "appbrand", WebView.WebViewKind.values()[m]);
      String str1;
      String str2;
      return;
    }
    finally
    {
      for (;;)
      {
        try
        {
          str1 = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zuZ, "");
          if (!TextUtils.isEmpty(str1))
          {
            str2 = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zva, "");
            Log.i("XWeb.MM.XWebUtil", "checkAbTestConfigs, base config url:%s, date:%s", new Object[] { str1, str2 });
            ao.qV(str1, str2);
          }
          str1 = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zvb, "");
          if (!TextUtils.isEmpty(str1))
          {
            str2 = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zvc, "");
            Log.i("XWeb.MM.XWebUtil", "checkAbTestConfigs, plugin config url:%s, date:%s", new Object[] { str1, str2 });
            ao.setTempPluginConfigUrl(str1, str2);
          }
          AppMethodBeat.o(231699);
          return;
        }
        finally
        {
          Log.e("XWeb.MM.XWebUtil", "xweb abtest set config url error:".concat(String.valueOf(localObject3)));
          AppMethodBeat.o(231699);
        }
        localObject2 = finally;
        Log.e("XWeb.MM.XWebUtil", "xweb abtest set webview kind error:".concat(String.valueOf(localObject2)));
      }
    }
  }
  
  public static void jQE()
  {
    AppMethodBeat.i(152944);
    bFi("com.tencent.mm.intent.ACTION_START_MPTOOLS_PROCESS");
    bFj("com.tencent.mm.intent.ACTION_START_MPTOOLS_PROCESS");
    AppMethodBeat.o(152944);
  }
  
  public static void jQF()
  {
    AppMethodBeat.i(369549);
    bFi("com.tencent.mm.intent.ACTION_START_MPTOOLS_PROCESS");
    AppMethodBeat.o(369549);
  }
  
  public static void jQG()
  {
    AppMethodBeat.i(369550);
    bFj("com.tencent.mm.intent.ACTION_START_MPTOOLS_PROCESS");
    AppMethodBeat.o(369550);
  }
  
  public static void nU(Context paramContext)
  {
    AppMethodBeat.i(152952);
    if (paramContext == null) {
      paramContext = MMApplicationContext.getContext();
    }
    for (;;)
    {
      ao.a(new r.a()
      {
        public final void DA(String paramAnonymousString)
        {
          AppMethodBeat.i(231662);
          k.DA(paramAnonymousString);
          AppMethodBeat.o(231662);
        }
      });
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE))
      {
        ao.setTempBaseConfigUrl("https://dldir1v6.qq.com/weixin/android/wxweb/updateConfig_test.xml");
        ao.setTempPluginConfigUrl("https://dldir1v6.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig_exp.xml");
        ao.kgi();
        ao.kgj();
      }
      for (;;)
      {
        jQD();
        if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (Log.getLogLevel() <= 1)) {
          ao.oS(MMApplicationContext.getContext());
        }
        if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {
          ao.oR(MMApplicationContext.getContext());
        }
        boolean bool = ChannelUtil.isGPVersion();
        ao.kgs();
        ao.setAppClientVersion(BuildInfo.CLIENT_VERSION_INT);
        ao.kgf();
        ao.OT(bool);
        jQB();
        if (bool)
        {
          e.forceSysWebView();
          ao.appendAppInfo("GP_USER");
        }
        if (("mm".equals(getModuleName())) && (aw.isDarkMode())) {
          ao.kgr();
        }
        String str = LocaleUtil.getApplicationLanguage();
        Log.i("XWeb.MM.XWebUtil", "initXWebEnviroment, application language:".concat(String.valueOf(str)));
        ao.a(paramContext, LocaleUtil.transLanguageToLocale(str), b.agZB, b.agZE, b.agZC, b.agZD);
        AppMethodBeat.o(152952);
        return;
        if (d.Yxk)
        {
          ao.kgi();
          ao.kgj();
        }
        else if (d.Yxj)
        {
          ao.qV(agZG, "20200615");
          ao.setTempPluginConfigUrl(agZH, "20200615");
          ao.kgi();
          ao.kgj();
        }
      }
    }
  }
  
  public static boolean nV(Context paramContext)
  {
    AppMethodBeat.i(152949);
    if ((ao.kgm()) && (ao.getUsingTbsCoreVersion(paramContext) <= 36541))
    {
      Log.i("XWeb.MM.XWebUtil", "isRespSupportSourceType, lower version of x5 not support source type");
      AppMethodBeat.o(152949);
      return false;
    }
    AppMethodBeat.o(152949);
    return true;
  }
  
  public static void setSandBoxProcessCrashDumpPath(String paramString1, String paramString2)
  {
    AppMethodBeat.i(231691);
    ao.setSandBoxProcessCrashDumpPath(paramString1, paramString2);
    AppMethodBeat.o(231691);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.xwebutil.c
 * JD-Core Version:    0.7.0.1
 */