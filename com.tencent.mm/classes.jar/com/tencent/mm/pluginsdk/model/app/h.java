package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.comm.c.d;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.plugin.openapi.a.a.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.threadpool.e.e;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.List;

public final class h
{
  public static String a(Context paramContext, g paramg, String paramString)
  {
    AppMethodBeat.i(151706);
    if ((paramContext == null) || (paramg == null))
    {
      AppMethodBeat.o(151706);
      return paramString;
    }
    String str = lt(paramContext);
    Object localObject = null;
    if (str.equalsIgnoreCase("zh_CN")) {
      localObject = paramg.field_appName;
    }
    if (str.equalsIgnoreCase("en"))
    {
      if (Util.isNullOrNil(paramg.field_appName_en)) {
        localObject = paramg.field_appName;
      }
    }
    else
    {
      if (!str.equalsIgnoreCase("zh_TW"))
      {
        paramContext = (Context)localObject;
        if (!str.equalsIgnoreCase("zh_HK")) {}
      }
      else
      {
        if (str.equalsIgnoreCase("zh_HK"))
        {
          if (!Util.isNullOrNil(paramg.field_appName_hk)) {
            break label185;
          }
          localObject = paramg.field_appName_tw;
        }
        label115:
        paramContext = (Context)localObject;
        if (Util.isNullOrNil((String)localObject))
        {
          if (!Util.isNullOrNil(paramg.field_appName_tw)) {
            break label193;
          }
          paramContext = paramg.field_appName;
        }
      }
      label139:
      localObject = paramContext;
      if (Util.isNullOrNil(paramContext)) {
        if (!Util.isNullOrNil(paramg.field_appName_en)) {
          break label201;
        }
      }
    }
    label185:
    label193:
    label201:
    for (localObject = paramg.field_appName;; localObject = paramg.field_appName_en)
    {
      if (!Util.isNullOrNil((String)localObject)) {
        break label209;
      }
      AppMethodBeat.o(151706);
      return paramString;
      localObject = paramg.field_appName_en;
      break;
      localObject = paramg.field_appName_hk;
      break label115;
      paramContext = paramg.field_appName_tw;
      break label139;
    }
    label209:
    AppMethodBeat.o(151706);
    return localObject;
  }
  
  public static List<g> a(Context paramContext, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(151697);
    Object localObject = new ArrayList();
    if (a.a.gxu() == null)
    {
      Log.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
      AppMethodBeat.o(151697);
      return localObject;
    }
    List localList = avO(paramInt);
    localObject = null;
    if (paramBoolean)
    {
      localObject = new int[1];
      localObject[0] = 5;
    }
    if (localObject == null)
    {
      AppMethodBeat.o(151697);
      return localList;
    }
    localObject = a.a.gxu().K((int[])localObject);
    if (localObject != null)
    {
      while (((Cursor)localObject).moveToNext())
      {
        g localg = new g();
        localg.convertFrom((Cursor)localObject);
        if (localg.field_status == 1)
        {
          if (y(paramContext, localg.field_appId))
          {
            if (!Util.isNullOrNil(localg.field_signature)) {
              localList.add(localg);
            }
          }
          else
          {
            localg.field_status = 4;
            a.a.gxu().g(localg);
          }
        }
        else if (localg.field_signature != null) {
          localList.add(localg);
        }
      }
      ((Cursor)localObject).close();
    }
    AppMethodBeat.o(151697);
    return localList;
  }
  
  public static void a(final String paramString1, final String paramString2, a parama)
  {
    AppMethodBeat.i(151689);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)) || (parama == null))
    {
      Log.e("MicroMsg.AppInfoLogic", "getAppInfoASync, appId is null");
      if (parama != null) {
        parama.a(null);
      }
      AppMethodBeat.o(151689);
      return;
    }
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151679);
        Object localObject = MultiProcessMMKV.getSingleMMKV("key_open_sdk_pkg");
        if (localObject == null)
        {
          h.this.a(null);
          AppMethodBeat.o(151679);
          return;
        }
        ((MultiProcessMMKV)localObject).encode(paramString1, paramString2);
        localObject = h.dV(paramString1, true);
        h.this.a((g)localObject);
        AppMethodBeat.o(151679);
      }
    }, "GetAppInfoASyncThread");
    AppMethodBeat.o(151689);
  }
  
  public static boolean a(Context paramContext, Intent paramIntent, String paramString, int paramInt, ap paramap, Bundle paramBundle)
  {
    AppMethodBeat.i(151723);
    if ((paramContext == null) || (paramIntent == null))
    {
      Log.i("MicroMsg.AppInfoLogic", "launchApp failed, context or intent is null.");
      if (paramap != null) {
        paramap.onLaunchApp(false, false);
      }
      AppMethodBeat.o(151723);
      return false;
    }
    String str1;
    String str3;
    String str2;
    if (paramBundle != null)
    {
      localObject = paramBundle.getString("current_page_url", "");
      str1 = paramBundle.getString("current_page_appid", "");
      str3 = paramBundle.getString("current_page_biz_info", "");
      str2 = paramBundle.getString("current_page_source_info", "");
      paramBundle = (Bundle)localObject;
      localObject = Util.queryIntentActivities(paramContext, paramIntent);
      if ((localObject == null) || (((List)localObject).isEmpty())) {
        break label423;
      }
      if ((!TextUtils.isEmpty(paramIntent.getPackage())) || (((List)localObject).size() != 1)) {
        break label231;
      }
    }
    label231:
    for (Object localObject = b((ResolveInfo)((List)localObject).get(0));; localObject = paramIntent.getPackage())
    {
      Log.d("MicroMsg.AppInfoLogic", "launchApp, wxpkg : %s.", new Object[] { MMApplicationContext.getPackageName() });
      if (!Util.nullAsNil(MMApplicationContext.getPackageName()).equals(localObject)) {
        break label240;
      }
      Log.i("MicroMsg.AppInfoLogic", "launchApp failed, can not launch wechat page.");
      if (paramap != null) {
        paramap.onLaunchApp(false, false);
      }
      AppMethodBeat.o(151723);
      return false;
      paramBundle = "";
      str1 = "";
      str3 = "";
      str2 = "";
      break;
    }
    label240:
    p.dh((String)localObject, 1);
    Log.i("MicroMsg.AppInfoLogic", "launchApp(pkg : %s) by wechat with intent", new Object[] { localObject });
    if (paramInt == 2) {
      try
      {
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/pluginsdk/model/app/AppInfoLogic", "launchAppByWeChat", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;ILcom/tencent/mm/pluginsdk/model/app/OnLaunchAppCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramIntent.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/pluginsdk/model/app/AppInfoLogic", "launchAppByWeChat", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;ILcom/tencent/mm/pluginsdk/model/app/OnLaunchAppCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        if (paramap != null) {
          paramap.onLaunchApp(true, false);
        }
        AppMethodBeat.o(151723);
        return true;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          Log.i("MicroMsg.AppInfoLogic", paramContext.getMessage());
        }
      }
    }
    boolean bool = ((Boolean)e.jZg().jZl().a(new h.7(paramString, paramContext, paramIntent, (String)localObject, paramBundle, str1, str2, str3, paramap)).jZk()).booleanValue();
    AppMethodBeat.o(151723);
    return bool;
    label423:
    Log.w("MicroMsg.AppInfoLogic", "launchApp failed, not activity can resolve the intent.");
    if (paramap != null) {
      paramap.onLaunchApp(false, false);
    }
    AppMethodBeat.o(151723);
    return false;
  }
  
  public static boolean a(Context paramContext, Intent paramIntent, String paramString, ap paramap, Bundle paramBundle)
  {
    AppMethodBeat.i(151722);
    boolean bool = a(paramContext, paramIntent, paramString, 0, paramap, paramBundle);
    AppMethodBeat.o(151722);
    return bool;
  }
  
  public static boolean a(Context paramContext, g paramg)
  {
    AppMethodBeat.i(151702);
    if (paramg == null)
    {
      Log.w("MicroMsg.AppInfoLogic", "app is null");
      AppMethodBeat.o(151702);
      return false;
    }
    if ((paramg.field_packageName == null) || (paramg.field_packageName.length() == 0))
    {
      Log.w("MicroMsg.AppInfoLogic", "field_packageName is null");
      AppMethodBeat.o(151702);
      return false;
    }
    boolean bool = u.y(paramContext, paramg.field_packageName);
    AppMethodBeat.o(151702);
    return bool;
  }
  
  public static boolean a(Context paramContext, String paramString, WXMediaMessage paramWXMediaMessage, int paramInt, ap paramap, Bundle paramBundle)
  {
    AppMethodBeat.i(151716);
    if (paramContext == null)
    {
      Log.e("MicroMsg.AppInfoLogic", "launch app failed: context is null");
      if (paramap != null) {
        paramap.onLaunchApp(false, false);
      }
      AppMethodBeat.o(151716);
      return false;
    }
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.AppInfoLogic", "launch app failed: appid is null or nil");
      if (paramap != null) {
        paramap.onLaunchApp(false, false);
      }
      AppMethodBeat.o(151716);
      return false;
    }
    if (paramWXMediaMessage == null)
    {
      Log.e("MicroMsg.AppInfoLogic", "launch app failed: wxMsg is null");
      if (paramap != null) {
        paramap.onLaunchApp(false, false);
      }
      AppMethodBeat.o(151716);
      return false;
    }
    if (Looper.myLooper() == Looper.getMainLooper()) {}
    for (g localg = is(paramString, 2147483647); localg == null; localg = dV(paramString, false))
    {
      Log.e("MicroMsg.AppInfoLogic", "get appinfo is null, appid is : [%s]", new Object[] { paramString });
      if (paramap != null) {
        paramap.onLaunchApp(false, false);
      }
      AppMethodBeat.o(151716);
      return false;
    }
    if (localg.field_status == 3)
    {
      Log.e("MicroMsg.AppInfoLogic", "requestAppShow fail, app is in blacklist, packageName = " + localg.field_packageName);
      if (paramap != null) {
        paramap.onLaunchApp(false, false);
      }
      AppMethodBeat.o(151716);
      return false;
    }
    boolean bool = a(paramContext, localg.field_packageName, paramWXMediaMessage, paramString, localg.field_openId, paramInt, paramap, paramBundle);
    AppMethodBeat.o(151716);
    return bool;
  }
  
  public static boolean a(Context paramContext, String paramString1, WXMediaMessage paramWXMediaMessage, String paramString2, String paramString3, int paramInt, ap paramap, Bundle paramBundle)
  {
    AppMethodBeat.i(151717);
    Log.d("MicroMsg.AppInfoLogic", "request pkg = " + paramString1 + ", openId = " + paramString3);
    boolean bool = a(paramContext, paramString1, paramString2, c(paramContext, paramWXMediaMessage, paramString3), paramInt, paramap, paramBundle);
    AppMethodBeat.o(151717);
    return bool;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, ShowMessageFromWX.Req paramReq, int paramInt, ap paramap, Bundle paramBundle)
  {
    AppMethodBeat.i(151718);
    if (paramReq == null)
    {
      Log.i("MicroMsg.AppInfoLogic", "launchApp failed, req is null.");
      if (paramap != null) {
        paramap.onLaunchApp(false, false);
      }
      AppMethodBeat.o(151718);
      return false;
    }
    if ((TextUtils.isEmpty(paramString1)) || (!u.y(paramContext, paramString1)))
    {
      Log.i("MicroMsg.AppInfoLogic", "launchApp failed, pkg is null or application has not installed.");
      p.dh(paramString1, 1);
      com.tencent.threadpool.h.ahAA.bk(new h.2(paramContext));
      if (paramap != null) {
        paramap.onLaunchApp(false, false);
      }
      AppMethodBeat.o(151718);
      return false;
    }
    Log.i("MicroMsg.AppInfoLogic", "launchApp(pkg : %s) with appId(%s)", new Object[] { paramString1, paramString2 });
    if (Util.nullAsNil(MMApplicationContext.getPackageName()).equals(paramString1))
    {
      Log.i("MicroMsg.AppInfoLogic", "launchApp failed, can not launch wechat page.");
      if (paramap != null) {
        paramap.onLaunchApp(false, false);
      }
      AppMethodBeat.o(151718);
      return false;
    }
    p.dh(paramString1, 1);
    h.3 local3 = new h.3(paramReq, paramString1, paramContext, paramap);
    if (paramInt == 2)
    {
      Log.i("MicroMsg.AppInfoLogic", "launchApp with show confirm dialog(%s).", new Object[] { paramString1 });
      local3.run();
      AppMethodBeat.o(151718);
      return true;
    }
    Object localObject;
    String str2;
    String str1;
    label326:
    label333:
    g.a locala;
    if (paramBundle != null)
    {
      paramReq = paramBundle.getString("current_page_url", "");
      localObject = paramBundle.getString("current_page_appid", "");
      str2 = paramBundle.getString("current_page_biz_info", "");
      str1 = paramBundle.getString("current_page_source_info", "");
      paramBundle = (Bundle)localObject;
      localObject = s(paramString2, true, false);
      if ((localObject == null) || (Util.isNullOrNil(a(paramContext, (g)localObject, null)))) {
        break label481;
      }
      localObject = paramContext.getString(c.h.launch_3rd_detail_app_tips, new Object[] { a(paramContext, (g)localObject, null) });
      if (paramString2 != null) {
        break label493;
      }
      paramString2 = "";
      bpM(paramString2);
      Log.i("MicroMsg.AppInfoLogic", "launchApp with args(showType : %s, pkg : %s)", new Object[] { Integer.valueOf(paramInt), paramString1 });
      locala = new g.a(paramContext);
      locala.bDE((String)localObject).bDI(paramContext.getString(c.h.launch_3rd_app_confirm)).bDJ(paramContext.getString(c.h.app_cancel)).b(new h.5(paramString1, paramReq, paramBundle, str1, str2, paramString2, local3)).a(new h.4(paramString1, paramReq, paramBundle, str1, str2, paramString2, paramap));
      if (Looper.myLooper() != Looper.getMainLooper()) {
        break label496;
      }
      locala.show();
    }
    for (;;)
    {
      AppMethodBeat.o(151718);
      return true;
      paramReq = "";
      paramBundle = "";
      str2 = "";
      str1 = "";
      break;
      label481:
      localObject = paramContext.getString(c.h.launch_3rd_app_tips);
      break label326;
      label493:
      break label333;
      label496:
      e.jZg().jZl().a(new com.tencent.threadpool.e.a() {}).jZk();
    }
  }
  
  private static boolean a(g paramg, int paramInt)
  {
    return (paramg == null) || (paramg.field_appVersion < paramInt);
  }
  
  public static g aQY(String paramString)
  {
    AppMethodBeat.i(369597);
    paramString = s(paramString, true, false);
    AppMethodBeat.o(369597);
    return paramString;
  }
  
  private static List<g> avO(int paramInt)
  {
    AppMethodBeat.i(244956);
    ArrayList localArrayList = new ArrayList();
    if (a.a.gxu() == null)
    {
      Log.e("MicroMsg.AppInfoLogic", "getServiceByAppInfoFlagAndShowFlag, getISubCorePluginBase() == null");
      AppMethodBeat.o(244956);
      return localArrayList;
    }
    Cursor localCursor = a.a.gxu().kr(1, paramInt);
    if (localCursor == null)
    {
      AppMethodBeat.o(244956);
      return localArrayList;
    }
    while (localCursor.moveToNext())
    {
      g localg = new g();
      localg.convertFrom(localCursor);
      localArrayList.add(localg);
    }
    localCursor.close();
    Log.i("MicroMsg.AppInfoLogic", "getServiceByAppInfoFlagAndShowFlag: size is %s", new Object[] { Integer.valueOf(localArrayList.size()) });
    AppMethodBeat.o(244956);
    return localArrayList;
  }
  
  public static int avP(int paramInt)
  {
    if (paramInt == 1) {
      return 19;
    }
    return -1;
  }
  
  public static String b(Context paramContext, g paramg, String paramString)
  {
    AppMethodBeat.i(151707);
    if ((paramContext == null) || (paramg == null))
    {
      AppMethodBeat.o(151707);
      return paramString;
    }
    String str = lt(paramContext);
    paramContext = null;
    if (str.equalsIgnoreCase("zh_CN")) {
      paramContext = paramg.field_appName;
    }
    if (str.equalsIgnoreCase("en"))
    {
      if (Util.isNullOrNil(paramg.field_appName_en)) {
        paramContext = paramg.field_appName;
      }
    }
    else if (!str.equalsIgnoreCase("zh_TW"))
    {
      localObject = paramContext;
      if (!str.equalsIgnoreCase("zh_HK")) {}
    }
    else
    {
      if (str.equalsIgnoreCase("zh_HK"))
      {
        if (!Util.isNullOrNil(paramg.field_appName_hk)) {
          break label164;
        }
        paramContext = paramg.field_appName_tw;
      }
      label117:
      localObject = paramContext;
      if (Util.isNullOrNil(paramContext)) {
        if (!Util.isNullOrNil(paramg.field_appName_tw)) {
          break label172;
        }
      }
    }
    label164:
    label172:
    for (Object localObject = paramg.field_appName;; localObject = paramg.field_appName_tw)
    {
      if (!Util.isNullOrNil((String)localObject)) {
        break label180;
      }
      AppMethodBeat.o(151707);
      return paramString;
      paramContext = paramg.field_appName_en;
      break;
      paramContext = paramg.field_appName_hk;
      break label117;
    }
    label180:
    AppMethodBeat.o(151707);
    return localObject;
  }
  
  public static String b(ResolveInfo paramResolveInfo)
  {
    AppMethodBeat.i(151725);
    if (paramResolveInfo == null)
    {
      AppMethodBeat.o(151725);
      return null;
    }
    String str2 = paramResolveInfo.resolvePackageName;
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (paramResolveInfo.activityInfo != null) {
        str1 = paramResolveInfo.activityInfo.packageName;
      }
    }
    AppMethodBeat.o(151725);
    return str1;
  }
  
  public static boolean b(Context paramContext, Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(151720);
    boolean bool = a(paramContext, paramIntent, paramString, null, null);
    AppMethodBeat.o(151720);
    return bool;
  }
  
  public static boolean b(g paramg, int paramInt)
  {
    AppMethodBeat.i(151714);
    if ((paramg == null) || (Util.isNullOrNil(paramg.field_appId)))
    {
      AppMethodBeat.o(151714);
      return false;
    }
    if ((paramg.field_appInfoFlag & paramInt) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.AppInfoLogic", "isAppHasFlag, appid = %s, flag = %s, ret = %b", new Object[] { paramg.field_appId, Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      Log.i("MicroMsg.AppInfoLogic", "appInfoFlag = " + paramg.field_appInfoFlag);
      AppMethodBeat.o(151714);
      return bool;
    }
  }
  
  public static boolean bj(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(151695);
    Long localLong = com.tencent.mm.pluginsdk.e.a.boO(String.valueOf(paramInt));
    if (localLong == null)
    {
      AppMethodBeat.o(151695);
      return false;
    }
    paramContext = c(paramContext, localLong.longValue(), true);
    if ((paramContext == null) || (paramContext.size() == 0))
    {
      AppMethodBeat.o(151695);
      return false;
    }
    AppMethodBeat.o(151695);
    return true;
  }
  
  public static boolean bpJ(String paramString)
  {
    AppMethodBeat.i(184267);
    if ((Util.isEqual("wx485a97c844086dc9", paramString)) || (Util.isEqual("wxaf060266bfa9a35c", paramString)))
    {
      AppMethodBeat.o(184267);
      return true;
    }
    paramString = s(paramString, true, false);
    if ((paramString != null) && (!Util.isNullOrNil(paramString.field_packageName)) && (!Util.isNullOrNil(paramString.field_signature)))
    {
      AppMethodBeat.o(184267);
      return true;
    }
    AppMethodBeat.o(184267);
    return false;
  }
  
  public static boolean bpK(String paramString)
  {
    AppMethodBeat.i(151712);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(151712);
      return false;
    }
    boolean bool = m(s(paramString, true, false));
    AppMethodBeat.o(151712);
    return bool;
  }
  
  public static boolean bpL(String paramString)
  {
    AppMethodBeat.i(244996);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(244996);
      return false;
    }
    boolean bool = n(s(paramString, true, false));
    AppMethodBeat.o(244996);
    return bool;
  }
  
  private static void bpM(String paramString)
  {
    AppMethodBeat.i(151719);
    if ("wx073f4a4daff0abe8".equalsIgnoreCase(paramString)) {
      com.tencent.mm.plugin.report.service.h.OAn.b(15413, new Object[] { Integer.valueOf(1), "", "" });
    }
    AppMethodBeat.o(151719);
  }
  
  public static boolean bpN(String paramString)
  {
    AppMethodBeat.i(245023);
    if (paramString != null) {}
    try
    {
      paramString = new com.tencent.mm.vfs.u(paramString);
      if ((paramString.jKS()) && (paramString.jKQ()))
      {
        AppMethodBeat.o(245023);
        return true;
      }
      AppMethodBeat.o(245023);
      return false;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.AppInfoLogic", paramString, "isFileExistAndReadable exception", new Object[0]);
      AppMethodBeat.o(245023);
    }
    AppMethodBeat.o(245023);
    return false;
    return false;
  }
  
  public static boolean bpO(String paramString)
  {
    AppMethodBeat.i(245026);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(245026);
      return false;
    }
    if (paramString.startsWith("content"))
    {
      if ((r(Uri.parse(paramString))) && (bpN(paramString)))
      {
        AppMethodBeat.o(245026);
        return true;
      }
      AppMethodBeat.o(245026);
      return false;
    }
    if ((Util.isFilePathSafeToBeCopySrc(paramString)) && (bpN(paramString)))
    {
      AppMethodBeat.o(245026);
      return true;
    }
    AppMethodBeat.o(245026);
    return false;
  }
  
  public static Bitmap c(String paramString, int paramInt, float paramFloat)
  {
    AppMethodBeat.i(151692);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.AppInfoLogic", "getAppIcon, appId is null");
      AppMethodBeat.o(151692);
      return null;
    }
    if (!com.tencent.mm.kernel.h.baC().aZN())
    {
      AppMethodBeat.o(151692);
      return null;
    }
    if (!com.tencent.mm.kernel.h.baE().isSDCardAvailable())
    {
      if (MMApplicationContext.getContext() == null)
      {
        AppMethodBeat.o(151692);
        return null;
      }
      if (MMApplicationContext.getContext().getResources() == null)
      {
        AppMethodBeat.o(151692);
        return null;
      }
      switch (paramInt)
      {
      default: 
        Log.e("MicroMsg.AppInfoLogic", "getAppIcon, unknown iconType = ".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(151692);
        return null;
      case 1: 
      case 3: 
      case 4: 
      case 5: 
        paramString = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), c.d.sharemore_nosdcard_icon);
        if ((paramString == null) || (paramString.isRecycled()))
        {
          AppMethodBeat.o(151692);
          return null;
        }
        AppMethodBeat.o(151692);
        return paramString;
      }
      AppMethodBeat.o(151692);
      return null;
    }
    Bitmap localBitmap = a.a.gxu().a(paramString, paramInt, paramFloat);
    if (localBitmap == null)
    {
      Log.w("MicroMsg.AppInfoLogic", "getAppIcon, bm does not exist or has been recycled");
      a.a.gxu().gt(paramString, paramInt);
      AppMethodBeat.o(151692);
      return null;
    }
    if (localBitmap.isRecycled())
    {
      AppMethodBeat.o(151692);
      return null;
    }
    AppMethodBeat.o(151692);
    return localBitmap;
  }
  
  public static ShowMessageFromWX.Req c(Context paramContext, WXMediaMessage paramWXMediaMessage, String paramString)
  {
    AppMethodBeat.i(151724);
    ShowMessageFromWX.Req localReq = new ShowMessageFromWX.Req();
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = MMApplicationContext.getContext();
    }
    localReq.message = paramWXMediaMessage;
    localReq.transaction = com.tencent.mm.b.g.getMessageDigest(Util.nowMilliSecond().getBytes());
    localReq.openId = paramString;
    localReq.lang = LocaleUtil.loadApplicationLanguage(localContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), localContext);
    localReq.country = ((String)com.tencent.mm.kernel.h.baE().ban().d(274436, null));
    AppMethodBeat.o(151724);
    return localReq;
  }
  
  public static List<g> c(Context paramContext, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(151693);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = com.tencent.mm.plugin.openapi.a.gxn();
    Object localObject2 = new StringBuilder(256);
    ((StringBuilder)localObject2).append("select * from AppInfo");
    ((StringBuilder)localObject2).append(" where ");
    ((StringBuilder)localObject2).append(" ( appSupportContentType & ").append(paramLong).append(" ) != 0");
    ((StringBuilder)localObject2).append(" and  ( svrAppSupportContentType & ").append(paramLong).append(" ) != 0");
    ((StringBuilder)localObject2).append(" and  ( appInfoFlag & 8192").append(" ) != 0");
    ((StringBuilder)localObject2).append(" and status != 4");
    if (!paramBoolean) {
      ((StringBuilder)localObject2).append(" and  ( appInfoFlag & 16384").append(" ) == 0");
    }
    Log.v("MicroMsg.AppInfoStorage", "getAppInfoByContentFlag sql %s", new Object[] { ((StringBuilder)localObject2).toString() });
    localObject2 = ((j)localObject1).rawQuery(((StringBuilder)localObject2).toString(), new String[0]);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      Log.e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
      localObject1 = null;
    }
    if (localObject1 == null)
    {
      AppMethodBeat.o(151693);
      return localArrayList;
    }
    while (((Cursor)localObject1).moveToNext())
    {
      localObject2 = new g();
      ((g)localObject2).convertFrom((Cursor)localObject1);
      if (((g)localObject2).field_status == 1)
      {
        if (y(paramContext, ((g)localObject2).field_appId))
        {
          if (!Util.isNullOrNil(((g)localObject2).field_signature)) {
            localArrayList.add(localObject2);
          }
        }
        else
        {
          ((g)localObject2).field_status = 4;
          a.a.gxu().g((g)localObject2);
        }
      }
      else if (((g)localObject2).field_signature != null) {
        localArrayList.add(localObject2);
      }
    }
    ((Cursor)localObject1).close();
    AppMethodBeat.o(151693);
    return localArrayList;
  }
  
  public static boolean c(Context paramContext, Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(245007);
    boolean bool = a(paramContext, paramIntent, paramString, null, null);
    AppMethodBeat.o(245007);
    return bool;
  }
  
  public static g dV(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(151688);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.AppInfoLogic", "getAppInfo, appId is null");
      AppMethodBeat.o(151688);
      return null;
    }
    com.tencent.mm.plugin.openapi.a.a locala = a.a.gxu();
    if (locala == null)
    {
      Log.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
      AppMethodBeat.o(151688);
      return null;
    }
    if (paramBoolean)
    {
      paramString = locala.aQZ(paramString);
      AppMethodBeat.o(151688);
      return paramString;
    }
    g localg = locala.aQY(paramString);
    if (localg == null)
    {
      paramString = locala.aQZ(paramString);
      AppMethodBeat.o(151688);
      return paramString;
    }
    locala.aRb(paramString);
    AppMethodBeat.o(151688);
    return localg;
  }
  
  public static boolean i(g paramg)
  {
    AppMethodBeat.i(184266);
    if (!Util.isNullOrNil(paramg.field_packageName))
    {
      AppMethodBeat.o(184266);
      return true;
    }
    AppMethodBeat.o(184266);
    return false;
  }
  
  public static boolean iA(String paramString)
  {
    AppMethodBeat.i(151703);
    if ((paramString == null) || (paramString.trim().length() == 0) || (paramString.equals("weixinfile")) || (paramString.equals("invalid_appname")))
    {
      AppMethodBeat.o(151703);
      return false;
    }
    AppMethodBeat.o(151703);
    return true;
  }
  
  public static boolean iB(String paramString)
  {
    AppMethodBeat.i(151709);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(151709);
      return false;
    }
    g localg = s(paramString, false, false);
    if (localg == null)
    {
      Log.w("MicroMsg.AppInfoLogic", "app is null, appId = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(151709);
      return false;
    }
    boolean bool = localg.aqJ();
    AppMethodBeat.o(151709);
    return bool;
  }
  
  public static List<g> iIv()
  {
    AppMethodBeat.i(151700);
    ArrayList localArrayList = new ArrayList();
    if (a.a.gxu() == null)
    {
      Log.e("MicroMsg.AppInfoLogic", "getAllServices, getISubCorePluginBase() == null");
      AppMethodBeat.o(151700);
      return localArrayList;
    }
    Cursor localCursor = a.a.gxu().gxt();
    if (localCursor == null)
    {
      AppMethodBeat.o(151700);
      return localArrayList;
    }
    while (localCursor.moveToNext())
    {
      g localg = new g();
      localg.convertFrom(localCursor);
      if (!Util.isNullOrNil(localg.field_openId)) {
        localArrayList.add(localg);
      }
    }
    localCursor.close();
    AppMethodBeat.o(151700);
    return localArrayList;
  }
  
  public static g is(String paramString, int paramInt)
  {
    AppMethodBeat.i(151687);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.AppInfoLogic", "getAppInfo, appId is null");
      AppMethodBeat.o(151687);
      return null;
    }
    if (a.a.gxu() == null)
    {
      Log.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
      AppMethodBeat.o(151687);
      return null;
    }
    g localg = a.a.gxu().aQY(paramString);
    if (a(localg, paramInt)) {
      a.a.gxu().aRb(paramString);
    }
    AppMethodBeat.o(151687);
    return localg;
  }
  
  private static boolean j(g paramg)
  {
    AppMethodBeat.i(151691);
    if ((paramg == null) || (paramg.field_appName == null) || (paramg.field_appName.length() == 0))
    {
      AppMethodBeat.o(151691);
      return true;
    }
    AppMethodBeat.o(151691);
    return false;
  }
  
  public static boolean k(g paramg)
  {
    AppMethodBeat.i(151710);
    if ((paramg == null) || (Util.isNullOrNil(paramg.field_appId)))
    {
      AppMethodBeat.o(151710);
      return false;
    }
    if ((paramg.field_appInfoFlag & 0x1) > 0)
    {
      AppMethodBeat.o(151710);
      return true;
    }
    AppMethodBeat.o(151710);
    return false;
  }
  
  public static boolean l(g paramg)
  {
    if (paramg == null) {}
    while ((paramg.field_appInfoFlag & 0x2) == 0) {
      return true;
    }
    return false;
  }
  
  public static List<g> ls(Context paramContext)
  {
    AppMethodBeat.i(151696);
    ArrayList localArrayList = new ArrayList();
    if (a.a.gxu() == null)
    {
      Log.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
      AppMethodBeat.o(151696);
      return localArrayList;
    }
    Cursor localCursor = a.a.gxu().gxr();
    if (localCursor == null)
    {
      AppMethodBeat.o(151696);
      return localArrayList;
    }
    while (localCursor.moveToNext())
    {
      g localg = new g();
      localg.convertFrom(localCursor);
      if (localg.field_status == 1)
      {
        if (y(paramContext, localg.field_appId))
        {
          if (!Util.isNullOrNil(localg.field_signature)) {
            localArrayList.add(localg);
          }
        }
        else
        {
          localg.field_status = 4;
          a.a.gxu().g(localg);
        }
      }
      else if (localg.field_signature != null) {
        localArrayList.add(localg);
      }
    }
    localCursor.close();
    AppMethodBeat.o(151696);
    return localArrayList;
  }
  
  public static String lt(Context paramContext)
  {
    AppMethodBeat.i(151708);
    paramContext = LocaleUtil.loadApplicationLanguage(paramContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), paramContext);
    if ((paramContext == null) || (paramContext.length() == 0) || (paramContext.equalsIgnoreCase("zh_CN")))
    {
      AppMethodBeat.o(151708);
      return "zh_CN";
    }
    AppMethodBeat.o(151708);
    return paramContext;
  }
  
  private static boolean m(g paramg)
  {
    AppMethodBeat.i(151711);
    if ((paramg == null) || (Util.isNullOrNil(paramg.field_appId)))
    {
      AppMethodBeat.o(151711);
      return false;
    }
    if (paramg.field_appId.equals("wx7fa037cc7dfabad5"))
    {
      AppMethodBeat.o(151711);
      return true;
    }
    if ((paramg.field_appInfoFlag & 0x8) > 0)
    {
      AppMethodBeat.o(151711);
      return true;
    }
    AppMethodBeat.o(151711);
    return false;
  }
  
  private static boolean n(g paramg)
  {
    AppMethodBeat.i(244997);
    if ((paramg == null) || (Util.isNullOrNil(paramg.field_appId)))
    {
      AppMethodBeat.o(244997);
      return false;
    }
    if ((paramg.field_appInfoFlag & 0x20) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.v("MicroMsg.AppInfoLogic", "canShowSNSTail, appid = %s, ret = %b", new Object[] { paramg.field_appId, Boolean.valueOf(bool) });
      AppMethodBeat.o(244997);
      return bool;
    }
  }
  
  public static boolean o(g paramg)
  {
    AppMethodBeat.i(151713);
    if ((paramg == null) || (Util.isNullOrNil(paramg.field_appId)))
    {
      AppMethodBeat.o(151713);
      return false;
    }
    if ((paramg.field_appInfoFlag & 0x40) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.v("MicroMsg.AppInfoLogic", "canReadMMMsg, appid = %s, ret = %b", new Object[] { paramg.field_appId, Boolean.valueOf(bool) });
      AppMethodBeat.o(151713);
      return bool;
    }
  }
  
  public static boolean p(g paramg)
  {
    AppMethodBeat.i(151715);
    if ((paramg == null) || (Util.isNullOrNil(paramg.field_appId)))
    {
      AppMethodBeat.o(151715);
      return false;
    }
    int i;
    if ((paramg.field_appInfoFlag & 0x80) > 0) {
      i = 1;
    }
    while (1 == i)
    {
      paramg = z.IB(paramg.field_appId);
      if ((paramg == null) || (paramg.equals("0")))
      {
        AppMethodBeat.o(151715);
        return true;
        i = 0;
      }
      else
      {
        AppMethodBeat.o(151715);
        return false;
      }
    }
    AppMethodBeat.o(151715);
    return false;
  }
  
  private static boolean r(Uri paramUri)
  {
    AppMethodBeat.i(245031);
    String str = paramUri.getAuthority();
    if ((str != null) && ((str.contains("com.tencent.mm")) || (str.contains("com.tencent.wmpf")) || (str.contains(MMApplicationContext.getApplicationId()))))
    {
      Log.e("MicroMsg.AppInfoLogic", "checkContentUri not valid: %s", new Object[] { paramUri.toString() });
      AppMethodBeat.o(245031);
      return false;
    }
    AppMethodBeat.o(245031);
    return true;
  }
  
  public static g s(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(184265);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.AppInfoLogic", "getAppInfo, appId is null");
      AppMethodBeat.o(184265);
      return null;
    }
    if (a.a.gxu() == null)
    {
      Log.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
      AppMethodBeat.o(184265);
      return null;
    }
    g localg = a.a.gxu().aQY(paramString);
    if ((paramBoolean1) && ((j(localg)) || ((paramBoolean2) && (i(localg))))) {
      a.a.gxu().aRb(paramString);
    }
    AppMethodBeat.o(184265);
    return localg;
  }
  
  public static String u(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(151704);
    paramContext = a(paramContext, is(paramString, paramInt), null);
    AppMethodBeat.o(151704);
    return paramContext;
  }
  
  public static String x(Context paramContext, String paramString)
  {
    AppMethodBeat.i(151705);
    paramContext = a(paramContext, s(paramString, true, false), null);
    AppMethodBeat.o(151705);
    return paramContext;
  }
  
  public static boolean x(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(151694);
    paramContext = c(paramContext, paramLong, true);
    if ((paramContext == null) || (paramContext.size() == 0))
    {
      AppMethodBeat.o(151694);
      return false;
    }
    AppMethodBeat.o(151694);
    return true;
  }
  
  public static boolean y(Context paramContext, String paramString)
  {
    AppMethodBeat.i(151701);
    if ((paramContext == null) || (paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.AppInfoLogic", "isAppInstalled, invalid arguments");
      AppMethodBeat.o(151701);
      return false;
    }
    boolean bool = a(paramContext, s(paramString, true, false));
    AppMethodBeat.o(151701);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract void a(g paramg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.h
 * JD-Core Version:    0.7.0.1
 */