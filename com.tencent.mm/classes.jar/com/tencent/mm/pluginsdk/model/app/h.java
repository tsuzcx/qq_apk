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
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.r.a.a.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.vfs.o;
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
    String str = it(paramContext);
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
    if (a.a.eAZ() == null)
    {
      Log.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
      AppMethodBeat.o(151697);
      return localObject;
    }
    List localList = ahK(paramInt);
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
    localObject = a.a.eAZ().H((int[])localObject);
    if (localObject != null)
    {
      while (((Cursor)localObject).moveToNext())
      {
        g localg = new g();
        localg.convertFrom((Cursor)localObject);
        if (localg.field_status == 1)
        {
          if (s(paramContext, localg.field_appId))
          {
            if (!Util.isNullOrNil(localg.field_signature)) {
              localList.add(localg);
            }
          }
          else
          {
            localg.field_status = 4;
            a.a.eAZ().g(localg);
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
    com.tencent.f.h.RTc.b(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151679);
        Object localObject = MultiProcessMMKV.getSingleMMKV("key_open_sdk_pkg");
        if (localObject == null)
        {
          this.JVV.a(null);
          AppMethodBeat.o(151679);
          return;
        }
        ((MultiProcessMMKV)localObject).encode(paramString1, paramString2);
        localObject = h.cX(paramString1, true);
        this.JVV.a((g)localObject);
        AppMethodBeat.o(151679);
      }
    }, "GetAppInfoASyncThread");
    AppMethodBeat.o(151689);
  }
  
  public static boolean a(Context paramContext, Intent paramIntent, String paramString, int paramInt, al paramal, Bundle paramBundle)
  {
    AppMethodBeat.i(151723);
    if ((paramContext == null) || (paramIntent == null))
    {
      Log.i("MicroMsg.AppInfoLogic", "launchApp failed, context or intent is null.");
      if (paramal != null) {
        paramal.v(false, false);
      }
      AppMethodBeat.o(151723);
      return false;
    }
    String str;
    if (paramBundle != null)
    {
      localObject = paramBundle.getString("current_page_url", "");
      str = paramBundle.getString("current_page_appid", "");
      paramBundle = (Bundle)localObject;
      localObject = Util.queryIntentActivities(paramContext, paramIntent);
      if ((localObject == null) || (((List)localObject).isEmpty())) {
        break label381;
      }
      if ((!TextUtils.isEmpty(paramIntent.getPackage())) || (((List)localObject).size() != 1)) {
        break label201;
      }
    }
    label201:
    for (Object localObject = b((ResolveInfo)((List)localObject).get(0));; localObject = paramIntent.getPackage())
    {
      Log.d("MicroMsg.AppInfoLogic", "launchApp, wxpkg : %s.", new Object[] { MMApplicationContext.getPackageName() });
      if (!Util.nullAsNil(MMApplicationContext.getPackageName()).equals(localObject)) {
        break label210;
      }
      Log.i("MicroMsg.AppInfoLogic", "launchApp failed, can not launch wechat page.");
      if (paramal != null) {
        paramal.v(false, false);
      }
      AppMethodBeat.o(151723);
      return false;
      paramBundle = "";
      str = "";
      break;
    }
    label210:
    Log.i("MicroMsg.AppInfoLogic", "launchApp(pkg : %s) by wechat with intent", new Object[] { localObject });
    if (paramInt == 2) {
      try
      {
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/pluginsdk/model/app/AppInfoLogic", "launchAppByWeChat", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;ILcom/tencent/mm/pluginsdk/model/app/OnLaunchAppCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramIntent.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/pluginsdk/model/app/AppInfoLogic", "launchAppByWeChat", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;ILcom/tencent/mm/pluginsdk/model/app/OnLaunchAppCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        if (paramal != null) {
          paramal.v(true, false);
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
    boolean bool = ((Boolean)com.tencent.f.e.e.hmm().hmq().a(new h.7(paramString, paramContext, paramIntent, (String)localObject, paramBundle, str, paramal)).take()).booleanValue();
    AppMethodBeat.o(151723);
    return bool;
    label381:
    Log.w("MicroMsg.AppInfoLogic", "launchApp failed, not activity can resolve the intent.");
    if (paramal != null) {
      paramal.v(false, false);
    }
    AppMethodBeat.o(151723);
    return false;
  }
  
  public static boolean a(Context paramContext, Intent paramIntent, String paramString, al paramal, Bundle paramBundle)
  {
    AppMethodBeat.i(151722);
    boolean bool = a(paramContext, paramIntent, paramString, 0, paramal, paramBundle);
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
    boolean bool = q.s(paramContext, paramg.field_packageName);
    AppMethodBeat.o(151702);
    return bool;
  }
  
  public static boolean a(Context paramContext, String paramString, WXMediaMessage paramWXMediaMessage, int paramInt, al paramal, Bundle paramBundle)
  {
    AppMethodBeat.i(151716);
    if (paramContext == null)
    {
      Log.e("MicroMsg.AppInfoLogic", "launch app failed: context is null");
      if (paramal != null) {
        paramal.v(false, false);
      }
      AppMethodBeat.o(151716);
      return false;
    }
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.AppInfoLogic", "launch app failed: appid is null or nil");
      if (paramal != null) {
        paramal.v(false, false);
      }
      AppMethodBeat.o(151716);
      return false;
    }
    if (paramWXMediaMessage == null)
    {
      Log.e("MicroMsg.AppInfoLogic", "launch app failed: wxMsg is null");
      if (paramal != null) {
        paramal.v(false, false);
      }
      AppMethodBeat.o(151716);
      return false;
    }
    if (Looper.myLooper() == Looper.getMainLooper()) {}
    for (g localg = gE(paramString, 2147483647); localg == null; localg = cX(paramString, false))
    {
      Log.e("MicroMsg.AppInfoLogic", "get appinfo is null, appid is : [%s]", new Object[] { paramString });
      if (paramal != null) {
        paramal.v(false, false);
      }
      AppMethodBeat.o(151716);
      return false;
    }
    if (localg.field_status == 3)
    {
      Log.e("MicroMsg.AppInfoLogic", "requestAppShow fail, app is in blacklist, packageName = " + localg.field_packageName);
      if (paramal != null) {
        paramal.v(false, false);
      }
      AppMethodBeat.o(151716);
      return false;
    }
    boolean bool = a(paramContext, localg.field_packageName, paramWXMediaMessage, paramString, localg.field_openId, paramInt, paramal, paramBundle);
    AppMethodBeat.o(151716);
    return bool;
  }
  
  public static boolean a(Context paramContext, String paramString1, WXMediaMessage paramWXMediaMessage, String paramString2, String paramString3, int paramInt, al paramal, Bundle paramBundle)
  {
    AppMethodBeat.i(151717);
    Log.d("MicroMsg.AppInfoLogic", "request pkg = " + paramString1 + ", openId = " + paramString3);
    boolean bool = a(paramContext, paramString1, paramString2, c(paramContext, paramWXMediaMessage, paramString3), paramInt, paramal, paramBundle);
    AppMethodBeat.o(151717);
    return bool;
  }
  
  public static boolean a(final Context paramContext, final String paramString1, String paramString2, ShowMessageFromWX.Req paramReq, int paramInt, final al paramal, Bundle paramBundle)
  {
    AppMethodBeat.i(151718);
    if (paramReq == null)
    {
      Log.i("MicroMsg.AppInfoLogic", "launchApp failed, req is null.");
      if (paramal != null) {
        paramal.v(false, false);
      }
      AppMethodBeat.o(151718);
      return false;
    }
    if ((TextUtils.isEmpty(paramString1)) || (!q.s(paramContext, paramString1)))
    {
      Log.i("MicroMsg.AppInfoLogic", "launchApp failed, pkg is null or application has not installed.");
      com.tencent.f.h.RTc.aV(new h.2(paramContext));
      if (paramal != null) {
        paramal.v(false, false);
      }
      AppMethodBeat.o(151718);
      return false;
    }
    Log.i("MicroMsg.AppInfoLogic", "launchApp(pkg : %s) with appId(%s)", new Object[] { paramString1, paramString2 });
    if (Util.nullAsNil(MMApplicationContext.getPackageName()).equals(paramString1))
    {
      Log.i("MicroMsg.AppInfoLogic", "launchApp failed, can not launch wechat page.");
      if (paramal != null) {
        paramal.v(false, false);
      }
      AppMethodBeat.o(151718);
      return false;
    }
    Runnable local3 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(184258);
        Bundle localBundle = new Bundle();
        this.JVW.toBundle(localBundle);
        q.bo(localBundle);
        q.bp(localBundle);
        MMessageActV2.Args localArgs = new MMessageActV2.Args();
        localArgs.targetPkgName = paramString1;
        localArgs.bundle = localBundle;
        boolean bool = MMessageActV2.send(paramContext, localArgs);
        if (paramal != null) {
          paramal.v(bool, false);
        }
        AppMethodBeat.o(184258);
      }
    };
    if (paramInt == 2)
    {
      Log.i("MicroMsg.AppInfoLogic", "launchApp with show confirm dialog(%s).", new Object[] { paramString1 });
      local3.run();
      AppMethodBeat.o(151718);
      return true;
    }
    Object localObject;
    label290:
    label297:
    f.a locala;
    if (paramBundle != null)
    {
      paramReq = paramBundle.getString("current_page_url", "");
      paramBundle = paramBundle.getString("current_page_appid", "");
      localObject = o(paramString2, true, false);
      if ((localObject == null) || (Util.isNullOrNil(a(paramContext, (g)localObject, null)))) {
        break label429;
      }
      localObject = paramContext.getString(2131762143, new Object[] { a(paramContext, (g)localObject, null) });
      if (paramString2 != null) {
        break label441;
      }
      paramString2 = "";
      bdB(paramString2);
      Log.i("MicroMsg.AppInfoLogic", "launchApp with args(showType : %s, pkg : %s)", new Object[] { Integer.valueOf(paramInt), paramString1 });
      locala = new f.a(paramContext);
      locala.bow((String)localObject).boA(paramContext.getString(2131762139)).boB(paramContext.getString(2131755761)).b(new h.5(paramString1, paramReq, paramBundle, paramString2, local3)).a(new h.4(paramString1, paramReq, paramBundle, paramString2, paramal));
      if (Looper.myLooper() != Looper.getMainLooper()) {
        break label444;
      }
      locala.show();
    }
    for (;;)
    {
      AppMethodBeat.o(151718);
      return true;
      paramReq = "";
      paramBundle = "";
      break;
      label429:
      localObject = paramContext.getString(2131762142);
      break label290;
      label441:
      break label297;
      label444:
      com.tencent.f.e.e.hmm().hmq().a(new com.tencent.f.e.a() {}).take();
    }
  }
  
  private static boolean a(g paramg, int paramInt)
  {
    return (paramg == null) || (paramg.field_appVersion < paramInt);
  }
  
  public static g aJw(String paramString)
  {
    AppMethodBeat.i(258497);
    paramString = o(paramString, true, false);
    AppMethodBeat.o(258497);
    return paramString;
  }
  
  private static List<g> ahK(int paramInt)
  {
    AppMethodBeat.i(223745);
    ArrayList localArrayList = new ArrayList();
    if (a.a.eAZ() == null)
    {
      Log.e("MicroMsg.AppInfoLogic", "getServiceByAppInfoFlagAndShowFlag, getISubCorePluginBase() == null");
      AppMethodBeat.o(223745);
      return localArrayList;
    }
    Cursor localCursor = a.a.eAZ().hG(1, paramInt);
    if (localCursor == null)
    {
      AppMethodBeat.o(223745);
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
    AppMethodBeat.o(223745);
    return localArrayList;
  }
  
  public static int ahL(int paramInt)
  {
    if (paramInt == 1) {
      return 19;
    }
    return -1;
  }
  
  public static boolean ay(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(151695);
    Long localLong = com.tencent.mm.pluginsdk.e.a.bcU(String.valueOf(paramInt));
    if (localLong == null)
    {
      AppMethodBeat.o(151695);
      return false;
    }
    if (b(paramContext, localLong.longValue(), true).size() == 0)
    {
      AppMethodBeat.o(151695);
      return false;
    }
    AppMethodBeat.o(151695);
    return true;
  }
  
  public static String b(Context paramContext, g paramg, String paramString)
  {
    AppMethodBeat.i(151707);
    if ((paramContext == null) || (paramg == null))
    {
      AppMethodBeat.o(151707);
      return paramString;
    }
    String str = it(paramContext);
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
  
  public static List<g> b(Context paramContext, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(151693);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = com.tencent.mm.plugin.r.a.eAS();
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
        if (s(paramContext, ((g)localObject2).field_appId))
        {
          if (!Util.isNullOrNil(((g)localObject2).field_signature)) {
            localArrayList.add(localObject2);
          }
        }
        else
        {
          ((g)localObject2).field_status = 4;
          a.a.eAZ().g((g)localObject2);
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
  
  public static boolean bdA(String paramString)
  {
    AppMethodBeat.i(223746);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(223746);
      return false;
    }
    boolean bool = n(o(paramString, true, false));
    AppMethodBeat.o(223746);
    return bool;
  }
  
  private static void bdB(String paramString)
  {
    AppMethodBeat.i(151719);
    if ("wx073f4a4daff0abe8".equalsIgnoreCase(paramString)) {
      com.tencent.mm.plugin.report.service.h.CyF.a(15413, new Object[] { Integer.valueOf(1), "", "" });
    }
    AppMethodBeat.o(151719);
  }
  
  public static boolean bdC(String paramString)
  {
    AppMethodBeat.i(223750);
    if (paramString != null) {}
    try
    {
      paramString = new o(paramString);
      if ((paramString.exists()) && (paramString.canRead()))
      {
        AppMethodBeat.o(223750);
        return true;
      }
      AppMethodBeat.o(223750);
      return false;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.AppInfoLogic", paramString, "isFileExistAndReadable exception", new Object[0]);
      AppMethodBeat.o(223750);
    }
    AppMethodBeat.o(223750);
    return false;
    return false;
  }
  
  public static boolean bdD(String paramString)
  {
    AppMethodBeat.i(223751);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(223751);
      return false;
    }
    if (paramString.startsWith("content"))
    {
      if ((bdE(paramString)) && (bdC(paramString)))
      {
        AppMethodBeat.o(223751);
        return true;
      }
      AppMethodBeat.o(223751);
      return false;
    }
    if ((Util.isFilePathSafeToBeCopySrc(paramString)) && (bdC(paramString)))
    {
      AppMethodBeat.o(223751);
      return true;
    }
    AppMethodBeat.o(223751);
    return false;
  }
  
  private static boolean bdE(String paramString)
  {
    AppMethodBeat.i(223752);
    String str = Uri.parse(paramString).getAuthority();
    if ((str != null) && ((str.contains("com.tencent.mm")) || (str.contains("com.tencent.wmpf")) || (str.contains(MMApplicationContext.getApplicationId()))))
    {
      Log.e("MicroMsg.AppInfoLogic", "checkContentUri not valid: %s", new Object[] { paramString });
      AppMethodBeat.o(223752);
      return false;
    }
    AppMethodBeat.o(223752);
    return true;
  }
  
  public static boolean bdy(String paramString)
  {
    AppMethodBeat.i(184267);
    if ((Util.isEqual("wx485a97c844086dc9", paramString)) || (Util.isEqual("wxaf060266bfa9a35c", paramString)))
    {
      AppMethodBeat.o(184267);
      return true;
    }
    paramString = o(paramString, true, false);
    if ((paramString != null) && (!Util.isNullOrNil(paramString.field_packageName)) && (!Util.isNullOrNil(paramString.field_signature)))
    {
      AppMethodBeat.o(184267);
      return true;
    }
    AppMethodBeat.o(184267);
    return false;
  }
  
  public static boolean bdz(String paramString)
  {
    AppMethodBeat.i(151712);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(151712);
      return false;
    }
    boolean bool = m(o(paramString, true, false));
    AppMethodBeat.o(151712);
    return bool;
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
    if (!com.tencent.mm.kernel.g.aAf().azp())
    {
      AppMethodBeat.o(151692);
      return null;
    }
    if (!com.tencent.mm.kernel.g.aAh().isSDCardAvailable())
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
        paramString = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), 2131234868);
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
    Bitmap localBitmap = a.a.eAZ().a(paramString, paramInt, paramFloat);
    if (localBitmap == null)
    {
      Log.w("MicroMsg.AppInfoLogic", "getAppIcon, bm does not exist or has been recycled");
      a.a.eAZ().eZ(paramString, paramInt);
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
    localReq.country = ((String)com.tencent.mm.kernel.g.aAh().azQ().get(274436, null));
    AppMethodBeat.o(151724);
    return localReq;
  }
  
  public static boolean c(Context paramContext, Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(223749);
    boolean bool = a(paramContext, paramIntent, paramString, null, null);
    AppMethodBeat.o(223749);
    return bool;
  }
  
  public static g cX(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(151688);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.AppInfoLogic", "getAppInfo, appId is null");
      AppMethodBeat.o(151688);
      return null;
    }
    com.tencent.mm.plugin.r.a.a locala = a.a.eAZ();
    if (locala == null)
    {
      Log.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
      AppMethodBeat.o(151688);
      return null;
    }
    if (paramBoolean)
    {
      paramString = locala.aJx(paramString);
      AppMethodBeat.o(151688);
      return paramString;
    }
    g localg = locala.aJw(paramString);
    if (localg == null)
    {
      paramString = locala.aJx(paramString);
      AppMethodBeat.o(151688);
      return paramString;
    }
    locala.aJz(paramString);
    AppMethodBeat.o(151688);
    return localg;
  }
  
  public static g gE(String paramString, int paramInt)
  {
    AppMethodBeat.i(151687);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.AppInfoLogic", "getAppInfo, appId is null");
      AppMethodBeat.o(151687);
      return null;
    }
    if (a.a.eAZ() == null)
    {
      Log.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
      AppMethodBeat.o(151687);
      return null;
    }
    g localg = a.a.eAZ().aJw(paramString);
    if (a(localg, paramInt)) {
      a.a.eAZ().aJz(paramString);
    }
    AppMethodBeat.o(151687);
    return localg;
  }
  
  public static List<g> gmU()
  {
    AppMethodBeat.i(151700);
    ArrayList localArrayList = new ArrayList();
    if (a.a.eAZ() == null)
    {
      Log.e("MicroMsg.AppInfoLogic", "getAllServices, getISubCorePluginBase() == null");
      AppMethodBeat.o(151700);
      return localArrayList;
    }
    Cursor localCursor = a.a.eAZ().eAY();
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
  
  public static boolean gp(String paramString)
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
  
  public static boolean gq(String paramString)
  {
    AppMethodBeat.i(151709);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(151709);
      return false;
    }
    g localg = o(paramString, false, false);
    if (localg == null)
    {
      Log.w("MicroMsg.AppInfoLogic", "app is null, appId = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(151709);
      return false;
    }
    boolean bool = localg.NA();
    AppMethodBeat.o(151709);
    return bool;
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
  
  public static List<g> is(Context paramContext)
  {
    AppMethodBeat.i(151696);
    ArrayList localArrayList = new ArrayList();
    if (a.a.eAZ() == null)
    {
      Log.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
      AppMethodBeat.o(151696);
      return localArrayList;
    }
    Cursor localCursor = a.a.eAZ().eAW();
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
        if (s(paramContext, localg.field_appId))
        {
          if (!Util.isNullOrNil(localg.field_signature)) {
            localArrayList.add(localg);
          }
        }
        else
        {
          localg.field_status = 4;
          a.a.eAZ().g(localg);
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
  
  public static String it(Context paramContext)
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
  
  public static boolean k(Context paramContext, Uri paramUri)
  {
    AppMethodBeat.i(223748);
    if ((paramContext == null) || (paramUri == null))
    {
      Log.i("MicroMsg.AppInfoLogic", "launchApp failed, context or uri is null.");
      AppMethodBeat.o(223748);
      return false;
    }
    Log.i("MicroMsg.AppInfoLogic", "try to launchApp with uri.");
    paramUri = new Intent("android.intent.action.VIEW", paramUri);
    paramUri.addFlags(268435456);
    boolean bool = a(paramContext, paramUri, null, null, null);
    AppMethodBeat.o(223748);
    return bool;
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
    AppMethodBeat.i(223747);
    if ((paramg == null) || (Util.isNullOrNil(paramg.field_appId)))
    {
      AppMethodBeat.o(223747);
      return false;
    }
    if ((paramg.field_appInfoFlag & 0x20) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.v("MicroMsg.AppInfoLogic", "canShowSNSTail, appid = %s, ret = %b", new Object[] { paramg.field_appId, Boolean.valueOf(bool) });
      AppMethodBeat.o(223747);
      return bool;
    }
  }
  
  public static g o(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(184265);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.AppInfoLogic", "getAppInfo, appId is null");
      AppMethodBeat.o(184265);
      return null;
    }
    if (a.a.eAZ() == null)
    {
      Log.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
      AppMethodBeat.o(184265);
      return null;
    }
    g localg = a.a.eAZ().aJw(paramString);
    if ((paramBoolean1) && ((j(localg)) || ((paramBoolean2) && (i(localg))))) {
      a.a.eAZ().aJz(paramString);
    }
    AppMethodBeat.o(184265);
    return localg;
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
      paramg = z.Ip(paramg.field_appId);
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
  
  public static String q(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(151704);
    paramContext = a(paramContext, gE(paramString, paramInt), null);
    AppMethodBeat.o(151704);
    return paramContext;
  }
  
  public static String r(Context paramContext, String paramString)
  {
    AppMethodBeat.i(151705);
    paramContext = a(paramContext, o(paramString, true, false), null);
    AppMethodBeat.o(151705);
    return paramContext;
  }
  
  public static boolean s(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(151694);
    if (b(paramContext, paramLong, true).size() == 0)
    {
      AppMethodBeat.o(151694);
      return false;
    }
    AppMethodBeat.o(151694);
    return true;
  }
  
  public static boolean s(Context paramContext, String paramString)
  {
    AppMethodBeat.i(151701);
    if ((paramContext == null) || (paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.AppInfoLogic", "isAppInstalled, invalid arguments");
      AppMethodBeat.o(151701);
      return false;
    }
    boolean bool = a(paramContext, o(paramString, true, false));
    AppMethodBeat.o(151701);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract void a(g paramg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.h
 * JD-Core Version:    0.7.0.1
 */