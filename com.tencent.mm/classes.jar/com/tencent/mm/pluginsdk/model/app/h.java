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
import com.tencent.e.e.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.s.a.a.a;
import com.tencent.mm.pluginsdk.d.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.widget.a.f.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class h
{
  public static int Un(int paramInt)
  {
    AppMethodBeat.i(151699);
    new ArrayList();
    if (a.a.cZX() == null)
    {
      ad.e("MicroMsg.AppInfoLogic", "getServiceByAppInfoFlagAndShowFlag, getISubCorePluginBase() == null");
      AppMethodBeat.o(151699);
      return 0;
    }
    Cursor localCursor = a.a.cZX().gv(0, paramInt);
    if (localCursor == null)
    {
      AppMethodBeat.o(151699);
      return 0;
    }
    paramInt = localCursor.getCount();
    localCursor.close();
    AppMethodBeat.o(151699);
    return paramInt;
  }
  
  public static int Uo(int paramInt)
  {
    if (paramInt == 1) {
      return 19;
    }
    return -1;
  }
  
  public static String a(Context paramContext, g paramg, String paramString)
  {
    AppMethodBeat.i(151706);
    if ((paramContext == null) || (paramg == null))
    {
      AppMethodBeat.o(151706);
      return paramString;
    }
    String str = hd(paramContext);
    Object localObject = null;
    if (str.equalsIgnoreCase("zh_CN")) {
      localObject = paramg.field_appName;
    }
    if (str.equalsIgnoreCase("en"))
    {
      if (bt.isNullOrNil(paramg.field_appName_en)) {
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
          if (!bt.isNullOrNil(paramg.field_appName_hk)) {
            break label185;
          }
          localObject = paramg.field_appName_tw;
        }
        label115:
        paramContext = (Context)localObject;
        if (bt.isNullOrNil((String)localObject))
        {
          if (!bt.isNullOrNil(paramg.field_appName_tw)) {
            break label193;
          }
          paramContext = paramg.field_appName;
        }
      }
      label139:
      localObject = paramContext;
      if (bt.isNullOrNil(paramContext)) {
        if (!bt.isNullOrNil(paramg.field_appName_en)) {
          break label201;
        }
      }
    }
    label185:
    label193:
    label201:
    for (localObject = paramg.field_appName;; localObject = paramg.field_appName_en)
    {
      if (!bt.isNullOrNil((String)localObject)) {
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
    if (a.a.cZX() == null)
    {
      ad.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
      AppMethodBeat.o(151697);
      return localObject;
    }
    List localList = iK(1, paramInt);
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
    localObject = a.a.cZX().C((int[])localObject);
    if (localObject != null)
    {
      while (((Cursor)localObject).moveToNext())
      {
        g localg = new g();
        localg.convertFrom((Cursor)localObject);
        if (localg.field_status == 1)
        {
          if (t(paramContext, localg.field_appId))
          {
            if (!bt.isNullOrNil(localg.field_signature)) {
              localList.add(localg);
            }
          }
          else
          {
            localg.field_status = 4;
            a.a.cZX().g(localg);
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
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      ad.e("MicroMsg.AppInfoLogic", "getAppInfoASync, appId is null");
      parama.a(null);
      AppMethodBeat.o(151689);
      return;
    }
    com.tencent.e.h.Iye.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151679);
        Object localObject = ax.aFD("key_open_sdk_pkg");
        if (localObject == null)
        {
          this.BPI.a(null);
          AppMethodBeat.o(151679);
          return;
        }
        ((ax)localObject).encode(paramString1, paramString2);
        localObject = h.cn(paramString1, true);
        this.BPI.a((g)localObject);
        AppMethodBeat.o(151679);
      }
    }, "GetAppInfoASyncThread");
    AppMethodBeat.o(151689);
  }
  
  public static boolean a(Context paramContext, Intent paramIntent, String paramString, int paramInt, am paramam, Bundle paramBundle)
  {
    AppMethodBeat.i(151723);
    if ((paramContext == null) || (paramIntent == null))
    {
      ad.i("MicroMsg.AppInfoLogic", "launchApp failed, context or intent is null.");
      if (paramam != null) {
        paramam.u(false, false);
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
      localObject = bt.M(paramContext, paramIntent);
      if ((localObject == null) || (((List)localObject).isEmpty())) {
        break label370;
      }
      if ((!TextUtils.isEmpty(paramIntent.getPackage())) || (((List)localObject).size() != 1)) {
        break label201;
      }
    }
    label201:
    for (Object localObject = b((ResolveInfo)((List)localObject).get(0));; localObject = paramIntent.getPackage())
    {
      ad.d("MicroMsg.AppInfoLogic", "launchApp, wxpkg : %s.", new Object[] { aj.getPackageName() });
      if (!bt.nullAsNil(aj.getPackageName()).equals(localObject)) {
        break label210;
      }
      ad.i("MicroMsg.AppInfoLogic", "launchApp failed, can not launch wechat page.");
      if (paramam != null) {
        paramam.u(false, false);
      }
      AppMethodBeat.o(151723);
      return false;
      paramBundle = "";
      str = "";
      break;
    }
    label210:
    ad.i("MicroMsg.AppInfoLogic", "launchApp(pkg : %s) by wechat with intent", new Object[] { localObject });
    if (paramInt == 2)
    {
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.adn(), "com/tencent/mm/pluginsdk/model/app/AppInfoLogic", "launchAppByWeChat", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;ILcom/tencent/mm/pluginsdk/model/app/OnLaunchAppCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/pluginsdk/model/app/AppInfoLogic", "launchAppByWeChat", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;ILcom/tencent/mm/pluginsdk/model/app/OnLaunchAppCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      if (paramam != null) {
        paramam.u(true, false);
      }
      AppMethodBeat.o(151723);
      return true;
    }
    boolean bool = ((Boolean)com.tencent.e.e.e.fnU().fnY().a(new h.7(paramString, paramContext, paramIntent, (String)localObject, paramBundle, str, paramam)).take()).booleanValue();
    AppMethodBeat.o(151723);
    return bool;
    label370:
    ad.w("MicroMsg.AppInfoLogic", "launchApp failed, not activity can resolve the intent.");
    if (paramam != null) {
      paramam.u(false, false);
    }
    AppMethodBeat.o(151723);
    return false;
  }
  
  public static boolean a(Context paramContext, Intent paramIntent, String paramString, am paramam)
  {
    AppMethodBeat.i(151721);
    boolean bool = a(paramContext, paramIntent, paramString, paramam, null);
    AppMethodBeat.o(151721);
    return bool;
  }
  
  public static boolean a(Context paramContext, Intent paramIntent, String paramString, am paramam, Bundle paramBundle)
  {
    AppMethodBeat.i(151722);
    boolean bool = a(paramContext, paramIntent, paramString, 0, paramam, paramBundle);
    AppMethodBeat.o(151722);
    return bool;
  }
  
  public static boolean a(Context paramContext, g paramg)
  {
    AppMethodBeat.i(151702);
    if (paramg == null)
    {
      ad.w("MicroMsg.AppInfoLogic", "app is null");
      AppMethodBeat.o(151702);
      return false;
    }
    if ((paramg.field_packageName == null) || (paramg.field_packageName.length() == 0))
    {
      ad.w("MicroMsg.AppInfoLogic", "field_packageName is null");
      AppMethodBeat.o(151702);
      return false;
    }
    boolean bool = q.t(paramContext, paramg.field_packageName);
    AppMethodBeat.o(151702);
    return bool;
  }
  
  public static boolean a(Context paramContext, String paramString, WXMediaMessage paramWXMediaMessage, int paramInt, am paramam, Bundle paramBundle)
  {
    AppMethodBeat.i(151716);
    if (paramContext == null)
    {
      ad.e("MicroMsg.AppInfoLogic", "launch app failed: context is null");
      if (paramam != null) {
        paramam.u(false, false);
      }
      AppMethodBeat.o(151716);
      return false;
    }
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.AppInfoLogic", "launch app failed: appid is null or nil");
      if (paramam != null) {
        paramam.u(false, false);
      }
      AppMethodBeat.o(151716);
      return false;
    }
    if (paramWXMediaMessage == null)
    {
      ad.e("MicroMsg.AppInfoLogic", "launch app failed: wxMsg is null");
      if (paramam != null) {
        paramam.u(false, false);
      }
      AppMethodBeat.o(151716);
      return false;
    }
    if (Looper.myLooper() == Looper.getMainLooper()) {}
    for (g localg = fv(paramString, 2147483647); localg == null; localg = cn(paramString, false))
    {
      ad.e("MicroMsg.AppInfoLogic", "get appinfo is null, appid is : [%s]", new Object[] { paramString });
      if (paramam != null) {
        paramam.u(false, false);
      }
      AppMethodBeat.o(151716);
      return false;
    }
    if (localg.field_status == 3)
    {
      ad.e("MicroMsg.AppInfoLogic", "requestAppShow fail, app is in blacklist, packageName = " + localg.field_packageName);
      if (paramam != null) {
        paramam.u(false, false);
      }
      AppMethodBeat.o(151716);
      return false;
    }
    boolean bool = a(paramContext, localg.field_packageName, paramWXMediaMessage, paramString, localg.field_openId, paramInt, paramam, paramBundle);
    AppMethodBeat.o(151716);
    return bool;
  }
  
  public static boolean a(Context paramContext, String paramString1, WXMediaMessage paramWXMediaMessage, String paramString2, String paramString3, int paramInt, am paramam, Bundle paramBundle)
  {
    AppMethodBeat.i(151717);
    ad.d("MicroMsg.AppInfoLogic", "request pkg = " + paramString1 + ", openId = " + paramString3);
    boolean bool = a(paramContext, paramString1, paramString2, b(paramContext, paramWXMediaMessage, paramString3), paramInt, paramam, paramBundle);
    AppMethodBeat.o(151717);
    return bool;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, ShowMessageFromWX.Req paramReq, int paramInt, am paramam, Bundle paramBundle)
  {
    AppMethodBeat.i(151718);
    if (paramReq == null)
    {
      ad.i("MicroMsg.AppInfoLogic", "launchApp failed, req is null.");
      if (paramam != null) {
        paramam.u(false, false);
      }
      AppMethodBeat.o(151718);
      return false;
    }
    if ((TextUtils.isEmpty(paramString1)) || (!q.t(paramContext, paramString1)))
    {
      ad.i("MicroMsg.AppInfoLogic", "launchApp failed, pkg is null or application has not installed.");
      com.tencent.e.h.Iye.aN(new h.2(paramContext));
      if (paramam != null) {
        paramam.u(false, false);
      }
      AppMethodBeat.o(151718);
      return false;
    }
    ad.i("MicroMsg.AppInfoLogic", "launchApp(pkg : %s) with appId(%s)", new Object[] { paramString1, paramString2 });
    if (bt.nullAsNil(aj.getPackageName()).equals(paramString1))
    {
      ad.i("MicroMsg.AppInfoLogic", "launchApp failed, can not launch wechat page.");
      if (paramam != null) {
        paramam.u(false, false);
      }
      AppMethodBeat.o(151718);
      return false;
    }
    h.3 local3 = new h.3(paramReq, paramString1, paramContext, paramam);
    if (paramInt == 2)
    {
      ad.i("MicroMsg.AppInfoLogic", "launchApp with show confirm dialog(%s).", new Object[] { paramString1 });
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
      localObject = j(paramString2, true, false);
      if ((localObject == null) || (bt.isNullOrNil(a(paramContext, (g)localObject, null)))) {
        break label429;
      }
      localObject = paramContext.getString(2131760631, new Object[] { a(paramContext, (g)localObject, null) });
      if (paramString2 != null) {
        break label441;
      }
      paramString2 = "";
      aAO(paramString2);
      ad.i("MicroMsg.AppInfoLogic", "launchApp with args(showType : %s, pkg : %s)", new Object[] { Integer.valueOf(paramInt), paramString1 });
      locala = new f.a(paramContext);
      locala.aMo((String)localObject).aMs(paramContext.getString(2131760627)).aMt(paramContext.getString(2131755691)).b(new h.5(paramString1, paramReq, paramBundle, paramString2, local3)).a(new h.4(paramString1, paramReq, paramBundle, paramString2, paramam));
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
      localObject = paramContext.getString(2131760630);
      break label290;
      label441:
      break label297;
      label444:
      com.tencent.e.e.e.fnU().fnY().a(new com.tencent.e.e.a() {}).take();
    }
  }
  
  private static boolean a(g paramg, int paramInt)
  {
    return (paramg == null) || (paramg.field_appVersion < paramInt);
  }
  
  public static boolean aAM(String paramString)
  {
    AppMethodBeat.i(184267);
    if ((bt.kU("wx485a97c844086dc9", paramString)) || (bt.kU("wxaf060266bfa9a35c", paramString)))
    {
      AppMethodBeat.o(184267);
      return true;
    }
    paramString = j(paramString, true, false);
    if ((paramString != null) && (!bt.isNullOrNil(paramString.field_packageName)) && (!bt.isNullOrNil(paramString.field_signature)))
    {
      AppMethodBeat.o(184267);
      return true;
    }
    AppMethodBeat.o(184267);
    return false;
  }
  
  public static boolean aAN(String paramString)
  {
    AppMethodBeat.i(151712);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(151712);
      return false;
    }
    boolean bool = m(j(paramString, true, false));
    AppMethodBeat.o(151712);
    return bool;
  }
  
  private static void aAO(String paramString)
  {
    AppMethodBeat.i(151719);
    if ("wx073f4a4daff0abe8".equalsIgnoreCase(paramString)) {
      com.tencent.mm.plugin.report.service.h.vKh.f(15413, new Object[] { Integer.valueOf(1), "", "" });
    }
    AppMethodBeat.o(151719);
  }
  
  public static boolean aAP(String paramString)
  {
    AppMethodBeat.i(190746);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(190746);
      return false;
    }
    if (paramString.startsWith("content"))
    {
      if ((aAQ(paramString)) && (com.tencent.mm.vfs.i.eK(paramString)))
      {
        AppMethodBeat.o(190746);
        return true;
      }
      AppMethodBeat.o(190746);
      return false;
    }
    if ((bt.aGt(paramString)) && (com.tencent.mm.vfs.i.eK(paramString)))
    {
      AppMethodBeat.o(190746);
      return true;
    }
    AppMethodBeat.o(190746);
    return false;
  }
  
  private static boolean aAQ(String paramString)
  {
    AppMethodBeat.i(190747);
    String str = Uri.parse(paramString).getAuthority();
    if ((str != null) && ((str.contains("com.tencent.mm")) || (str.contains("com.tencent.wmpf"))))
    {
      ad.e("MicroMsg.AppInfoLogic", "checkContentUri not valid: %s", new Object[] { paramString });
      AppMethodBeat.o(190747);
      return false;
    }
    AppMethodBeat.o(190747);
    return true;
  }
  
  public static boolean ag(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(151695);
    Long localLong = d.a.aAn(String.valueOf(paramInt));
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
  
  public static g ajX(String paramString)
  {
    AppMethodBeat.i(203573);
    paramString = j(paramString, true, false);
    AppMethodBeat.o(203573);
    return paramString;
  }
  
  public static ShowMessageFromWX.Req b(Context paramContext, WXMediaMessage paramWXMediaMessage, String paramString)
  {
    AppMethodBeat.i(151724);
    ShowMessageFromWX.Req localReq = new ShowMessageFromWX.Req();
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = aj.getContext();
    }
    localReq.message = paramWXMediaMessage;
    localReq.transaction = com.tencent.mm.b.g.getMessageDigest(bt.eGO().getBytes());
    localReq.openId = paramString;
    localReq.lang = ac.f(localContext.getSharedPreferences(aj.eFD(), 0));
    localReq.country = ((String)com.tencent.mm.kernel.g.afB().afk().get(274436, null));
    AppMethodBeat.o(151724);
    return localReq;
  }
  
  public static String b(Context paramContext, g paramg, String paramString)
  {
    AppMethodBeat.i(151707);
    if ((paramContext == null) || (paramg == null))
    {
      AppMethodBeat.o(151707);
      return paramString;
    }
    String str = hd(paramContext);
    paramContext = null;
    if (str.equalsIgnoreCase("zh_CN")) {
      paramContext = paramg.field_appName;
    }
    if (str.equalsIgnoreCase("en"))
    {
      if (bt.isNullOrNil(paramg.field_appName_en)) {
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
        if (!bt.isNullOrNil(paramg.field_appName_hk)) {
          break label164;
        }
        paramContext = paramg.field_appName_tw;
      }
      label117:
      localObject = paramContext;
      if (bt.isNullOrNil(paramContext)) {
        if (!bt.isNullOrNil(paramg.field_appName_tw)) {
          break label172;
        }
      }
    }
    label164:
    label172:
    for (Object localObject = paramg.field_appName;; localObject = paramg.field_appName_tw)
    {
      if (!bt.isNullOrNil((String)localObject)) {
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
    Object localObject1 = com.tencent.mm.plugin.s.a.cZQ();
    Object localObject2 = new StringBuilder(256);
    ((StringBuilder)localObject2).append("select * from AppInfo");
    ((StringBuilder)localObject2).append(" where ");
    ((StringBuilder)localObject2).append(" ( appSupportContentType & ").append(paramLong).append(" ) != 0");
    ((StringBuilder)localObject2).append(" and  ( svrAppSupportContentType & ").append(paramLong).append(" ) != 0");
    ((StringBuilder)localObject2).append(" and  ( appInfoFlag & 8192 ) != 0");
    ((StringBuilder)localObject2).append(" and status != 4");
    if (!paramBoolean) {
      ((StringBuilder)localObject2).append(" and  ( appInfoFlag & 16384 ) == 0");
    }
    ad.v("MicroMsg.AppInfoStorage", "getAppInfoByContentFlag sql %s", new Object[] { ((StringBuilder)localObject2).toString() });
    localObject2 = ((j)localObject1).rawQuery(((StringBuilder)localObject2).toString(), new String[0]);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      ad.e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
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
        if (t(paramContext, ((g)localObject2).field_appId))
        {
          if (!bt.isNullOrNil(((g)localObject2).field_signature)) {
            localArrayList.add(localObject2);
          }
        }
        else
        {
          ((g)localObject2).field_status = 4;
          a.a.cZX().g((g)localObject2);
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
    if ((paramg == null) || (bt.isNullOrNil(paramg.field_appId)))
    {
      AppMethodBeat.o(151714);
      return false;
    }
    if ((paramg.field_appInfoFlag & paramInt) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.AppInfoLogic", "isAppHasFlag, appid = %s, flag = %s, ret = %b", new Object[] { paramg.field_appId, Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      ad.i("MicroMsg.AppInfoLogic", "appInfoFlag = " + paramg.field_appInfoFlag);
      AppMethodBeat.o(151714);
      return bool;
    }
  }
  
  public static Bitmap c(String paramString, int paramInt, float paramFloat)
  {
    AppMethodBeat.i(151692);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.AppInfoLogic", "getAppIcon, appId is null");
      AppMethodBeat.o(151692);
      return null;
    }
    if (!com.tencent.mm.kernel.g.afz().aeI())
    {
      AppMethodBeat.o(151692);
      return null;
    }
    if (!com.tencent.mm.kernel.g.afB().isSDCardAvailable())
    {
      if (aj.getContext() == null)
      {
        AppMethodBeat.o(151692);
        return null;
      }
      if (aj.getContext().getResources() == null)
      {
        AppMethodBeat.o(151692);
        return null;
      }
      switch (paramInt)
      {
      default: 
        ad.e("MicroMsg.AppInfoLogic", "getAppIcon, unknown iconType = ".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(151692);
        return null;
      case 1: 
      case 3: 
      case 4: 
      case 5: 
        paramString = BitmapFactory.decodeResource(aj.getContext().getResources(), 2131234029);
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
    Bitmap localBitmap = a.a.cZX().a(paramString, paramInt, paramFloat);
    if (localBitmap == null)
    {
      ad.w("MicroMsg.AppInfoLogic", "getAppIcon, bm does not exist or has been recycled");
      a.a.cZX().ec(paramString, paramInt);
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
  
  public static g cn(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(151688);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.AppInfoLogic", "getAppInfo, appId is null");
      AppMethodBeat.o(151688);
      return null;
    }
    com.tencent.mm.plugin.s.a.a locala = a.a.cZX();
    if (locala == null)
    {
      ad.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
      AppMethodBeat.o(151688);
      return null;
    }
    if (paramBoolean)
    {
      paramString = locala.ajY(paramString);
      AppMethodBeat.o(151688);
      return paramString;
    }
    g localg = locala.ajX(paramString);
    if (localg == null)
    {
      paramString = locala.ajY(paramString);
      AppMethodBeat.o(151688);
      return paramString;
    }
    locala.ajZ(paramString);
    AppMethodBeat.o(151688);
    return localg;
  }
  
  public static boolean eM(String paramString)
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
  
  public static boolean eN(String paramString)
  {
    AppMethodBeat.i(151709);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(151709);
      return false;
    }
    g localg = j(paramString, false, false);
    if (localg == null)
    {
      ad.w("MicroMsg.AppInfoLogic", "app is null, appId = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(151709);
      return false;
    }
    boolean bool = localg.CZ();
    AppMethodBeat.o(151709);
    return bool;
  }
  
  public static List<g> evH()
  {
    AppMethodBeat.i(151700);
    ArrayList localArrayList = new ArrayList();
    if (a.a.cZX() == null)
    {
      ad.e("MicroMsg.AppInfoLogic", "getAllServices, getISubCorePluginBase() == null");
      AppMethodBeat.o(151700);
      return localArrayList;
    }
    Cursor localCursor = a.a.cZX().cZW();
    if (localCursor == null)
    {
      AppMethodBeat.o(151700);
      return localArrayList;
    }
    while (localCursor.moveToNext())
    {
      g localg = new g();
      localg.convertFrom(localCursor);
      if (!bt.isNullOrNil(localg.field_openId)) {
        localArrayList.add(localg);
      }
    }
    localCursor.close();
    AppMethodBeat.o(151700);
    return localArrayList;
  }
  
  public static g fv(String paramString, int paramInt)
  {
    AppMethodBeat.i(151687);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.AppInfoLogic", "getAppInfo, appId is null");
      AppMethodBeat.o(151687);
      return null;
    }
    if (a.a.cZX() == null)
    {
      ad.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
      AppMethodBeat.o(151687);
      return null;
    }
    g localg = a.a.cZX().ajX(paramString);
    if (a(localg, paramInt)) {
      a.a.cZX().ajZ(paramString);
    }
    AppMethodBeat.o(151687);
    return localg;
  }
  
  public static boolean h(Context paramContext, Uri paramUri)
  {
    AppMethodBeat.i(190745);
    if ((paramContext == null) || (paramUri == null))
    {
      ad.i("MicroMsg.AppInfoLogic", "launchApp failed, context or uri is null.");
      AppMethodBeat.o(190745);
      return false;
    }
    ad.i("MicroMsg.AppInfoLogic", "try to launchApp with uri.");
    paramUri = new Intent("android.intent.action.VIEW", paramUri);
    paramUri.addFlags(268435456);
    boolean bool = a(paramContext, paramUri, null, null, null);
    AppMethodBeat.o(190745);
    return bool;
  }
  
  public static List<g> hc(Context paramContext)
  {
    AppMethodBeat.i(151696);
    ArrayList localArrayList = new ArrayList();
    if (a.a.cZX() == null)
    {
      ad.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
      AppMethodBeat.o(151696);
      return localArrayList;
    }
    Cursor localCursor = a.a.cZX().cZU();
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
        if (t(paramContext, localg.field_appId))
        {
          if (!bt.isNullOrNil(localg.field_signature)) {
            localArrayList.add(localg);
          }
        }
        else
        {
          localg.field_status = 4;
          a.a.cZX().g(localg);
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
  
  public static String hd(Context paramContext)
  {
    AppMethodBeat.i(151708);
    paramContext = ac.f(paramContext.getSharedPreferences(aj.eFD(), 0));
    if ((paramContext == null) || (paramContext.length() == 0) || (paramContext.equalsIgnoreCase("zh_CN")))
    {
      AppMethodBeat.o(151708);
      return "zh_CN";
    }
    AppMethodBeat.o(151708);
    return paramContext;
  }
  
  public static boolean i(g paramg)
  {
    AppMethodBeat.i(184266);
    if (!bt.isNullOrNil(paramg.field_packageName))
    {
      AppMethodBeat.o(184266);
      return true;
    }
    AppMethodBeat.o(184266);
    return false;
  }
  
  public static List<g> iK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(151698);
    ArrayList localArrayList = new ArrayList();
    if (a.a.cZX() == null)
    {
      ad.e("MicroMsg.AppInfoLogic", "getServiceByAppInfoFlagAndShowFlag, getISubCorePluginBase() == null");
      AppMethodBeat.o(151698);
      return localArrayList;
    }
    Cursor localCursor = a.a.cZX().gv(paramInt1, paramInt2);
    if (localCursor == null)
    {
      AppMethodBeat.o(151698);
      return localArrayList;
    }
    while (localCursor.moveToNext())
    {
      g localg = new g();
      localg.convertFrom(localCursor);
      localArrayList.add(localg);
    }
    localCursor.close();
    ad.i("MicroMsg.AppInfoLogic", "getServiceByAppInfoFlagAndShowFlag: size is %s", new Object[] { Integer.valueOf(localArrayList.size()) });
    AppMethodBeat.o(151698);
    return localArrayList;
  }
  
  public static g j(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(184265);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.AppInfoLogic", "getAppInfo, appId is null");
      AppMethodBeat.o(184265);
      return null;
    }
    if (a.a.cZX() == null)
    {
      ad.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
      AppMethodBeat.o(184265);
      return null;
    }
    g localg = a.a.cZX().ajX(paramString);
    if ((paramBoolean1) && ((j(localg)) || ((paramBoolean2) && (i(localg))))) {
      a.a.cZX().ajZ(paramString);
    }
    AppMethodBeat.o(184265);
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
    if ((paramg == null) || (bt.isNullOrNil(paramg.field_appId)))
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
    if ((paramg == null) || (bt.isNullOrNil(paramg.field_appId)))
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
  
  public static boolean n(g paramg)
  {
    AppMethodBeat.i(151713);
    if ((paramg == null) || (bt.isNullOrNil(paramg.field_appId)))
    {
      AppMethodBeat.o(151713);
      return false;
    }
    if ((paramg.field_appInfoFlag & 0x40) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.v("MicroMsg.AppInfoLogic", "canReadMMMsg, appid = %s, ret = %b", new Object[] { paramg.field_appId, Boolean.valueOf(bool) });
      AppMethodBeat.o(151713);
      return bool;
    }
  }
  
  public static boolean o(g paramg)
  {
    AppMethodBeat.i(151715);
    if ((paramg == null) || (bt.isNullOrNil(paramg.field_appId)))
    {
      AppMethodBeat.o(151715);
      return false;
    }
    int i;
    HashMap localHashMap;
    if ((paramg.field_appInfoFlag & 0x80) > 0)
    {
      i = 1;
      if (1 != i) {
        break label124;
      }
      paramg = paramg.field_appId;
      localHashMap = new HashMap();
      u.q(localHashMap);
      if (!localHashMap.containsKey(paramg)) {
        break label111;
      }
    }
    label111:
    for (paramg = (String)localHashMap.get(paramg);; paramg = null)
    {
      if ((paramg != null) && (!paramg.equals("0"))) {
        break label116;
      }
      AppMethodBeat.o(151715);
      return true;
      i = 0;
      break;
    }
    label116:
    AppMethodBeat.o(151715);
    return false;
    label124:
    AppMethodBeat.o(151715);
    return false;
  }
  
  public static boolean q(Context paramContext, long paramLong)
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
  
  public static String r(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(151704);
    paramContext = a(paramContext, fv(paramString, paramInt), null);
    AppMethodBeat.o(151704);
    return paramContext;
  }
  
  public static String s(Context paramContext, String paramString)
  {
    AppMethodBeat.i(151705);
    paramContext = a(paramContext, j(paramString, true, false), null);
    AppMethodBeat.o(151705);
    return paramContext;
  }
  
  public static boolean t(Context paramContext, String paramString)
  {
    AppMethodBeat.i(151701);
    if ((paramContext == null) || (paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.AppInfoLogic", "isAppInstalled, invalid arguments");
      AppMethodBeat.o(151701);
      return false;
    }
    boolean bool = a(paramContext, j(paramString, true, false));
    AppMethodBeat.o(151701);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract void a(g paramg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.h
 * JD-Core Version:    0.7.0.1
 */