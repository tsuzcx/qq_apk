package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.s.a.a.a;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class g
{
  public static int LB(int paramInt)
  {
    AppMethodBeat.i(79272);
    new ArrayList();
    if (a.a.caj() == null)
    {
      ab.e("MicroMsg.AppInfoLogic", "getServiceByAppInfoFlagAndShowFlag, getISubCorePluginBase() == null");
      AppMethodBeat.o(79272);
      return 0;
    }
    Cursor localCursor = a.a.caj().eZ(0, paramInt);
    if (localCursor == null)
    {
      AppMethodBeat.o(79272);
      return 0;
    }
    paramInt = localCursor.getCount();
    localCursor.close();
    AppMethodBeat.o(79272);
    return paramInt;
  }
  
  public static int LC(int paramInt)
  {
    if (paramInt == 1) {
      return 19;
    }
    return -1;
  }
  
  public static f WD(String paramString)
  {
    AppMethodBeat.i(156858);
    paramString = ca(paramString, true);
    AppMethodBeat.o(156858);
    return paramString;
  }
  
  public static List<f> a(Context paramContext, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(79270);
    Object localObject = new ArrayList();
    if (a.a.caj() == null)
    {
      ab.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
      AppMethodBeat.o(79270);
      return localObject;
    }
    List localList = gZ(1, paramInt);
    localObject = null;
    if (paramBoolean)
    {
      localObject = new int[1];
      localObject[0] = 5;
    }
    if (localObject == null)
    {
      AppMethodBeat.o(79270);
      return localList;
    }
    localObject = a.a.caj().z((int[])localObject);
    if (localObject != null)
    {
      while (((Cursor)localObject).moveToNext())
      {
        f localf = new f();
        localf.convertFrom((Cursor)localObject);
        if (localf.field_status == 1)
        {
          if (u(paramContext, localf.field_appId))
          {
            if (!bo.isNullOrNil(localf.field_signature)) {
              localList.add(localf);
            }
          }
          else
          {
            localf.field_status = 4;
            a.a.caj().g(localf);
          }
        }
        else if (localf.field_signature != null) {
          localList.add(localf);
        }
      }
      ((Cursor)localObject).close();
    }
    AppMethodBeat.o(79270);
    return localList;
  }
  
  public static void a(String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(151615);
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)))
    {
      ab.e("MicroMsg.AppInfoLogic", "getAppInfoASync, appId is null");
      parama.a(null);
      AppMethodBeat.o(151615);
      return;
    }
    d.ysm.b(new g.1(parama, paramString1, paramString2), "GetAppInfoASyncThread");
    AppMethodBeat.o(151615);
  }
  
  public static boolean a(Context paramContext, final Intent paramIntent, String paramString, int paramInt, final ai paramai, final Bundle paramBundle)
  {
    AppMethodBeat.i(79296);
    if ((paramContext == null) || (paramIntent == null))
    {
      ab.i("MicroMsg.AppInfoLogic", "launchApp failed, context or intent is null.");
      if (paramai != null) {
        paramai.dZ(false);
      }
      AppMethodBeat.o(79296);
      return false;
    }
    final String str;
    if (paramBundle != null)
    {
      localObject = paramBundle.getString("current_page_url", "");
      str = paramBundle.getString("current_page_appid", "");
      paramBundle = (Bundle)localObject;
      localObject = bo.H(paramContext, paramIntent);
      if ((localObject == null) || (((List)localObject).isEmpty())) {
        break label347;
      }
      if ((!TextUtils.isEmpty(paramIntent.getPackage())) || (((List)localObject).size() != 1)) {
        break label199;
      }
    }
    label199:
    for (Object localObject = b((ResolveInfo)((List)localObject).get(0));; localObject = paramIntent.getPackage())
    {
      ab.d("MicroMsg.AppInfoLogic", "launchApp, wxpkg : %s.", new Object[] { ah.getPackageName() });
      if (!bo.nullAsNil(ah.getPackageName()).equals(localObject)) {
        break label208;
      }
      ab.i("MicroMsg.AppInfoLogic", "launchApp failed, can not launch wechat page.");
      if (paramai != null) {
        paramai.dZ(false);
      }
      AppMethodBeat.o(79296);
      return false;
      paramBundle = "";
      str = "";
      break;
    }
    label208:
    ab.i("MicroMsg.AppInfoLogic", "launchApp(pkg : %s) by wechat with intent", new Object[] { localObject });
    if (paramInt == 2)
    {
      paramContext.startActivity(paramIntent);
      if (paramai != null) {
        paramai.dZ(true);
      }
      AppMethodBeat.o(79296);
      return true;
    }
    if (!TextUtils.isEmpty(paramString)) {}
    for (paramString = paramContext.getString(2131301023, new Object[] { paramString });; paramString = paramContext.getString(2131301022))
    {
      com.tencent.mm.ui.base.h.a(paramContext, paramString, "", paramContext.getString(2131301019), paramContext.getString(2131296888), false, new DialogInterface.OnClickListener()new g.6
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(79259);
          this.val$context.startActivity(paramIntent);
          com.tencent.mm.plugin.report.service.h.qsU.e(14102, new Object[] { Integer.valueOf(0), Integer.valueOf(1), "", Integer.valueOf(1), this.Cl, paramBundle, str });
          if (paramai != null) {
            paramai.dZ(true);
          }
          AppMethodBeat.o(79259);
        }
      }, new g.6((String)localObject, paramBundle, str, paramai));
      AppMethodBeat.o(79296);
      return true;
    }
    label347:
    ab.w("MicroMsg.AppInfoLogic", "launchApp failed, not activity can resolve the intent.");
    if (paramai != null) {
      paramai.dZ(false);
    }
    AppMethodBeat.o(79296);
    return false;
  }
  
  public static boolean a(Context paramContext, Intent paramIntent, String paramString, ai paramai)
  {
    AppMethodBeat.i(79294);
    boolean bool = a(paramContext, paramIntent, paramString, paramai, null);
    AppMethodBeat.o(79294);
    return bool;
  }
  
  public static boolean a(Context paramContext, Intent paramIntent, String paramString, ai paramai, Bundle paramBundle)
  {
    AppMethodBeat.i(79295);
    boolean bool = a(paramContext, paramIntent, paramString, 0, paramai, paramBundle);
    AppMethodBeat.o(79295);
    return bool;
  }
  
  public static boolean a(Context paramContext, f paramf)
  {
    AppMethodBeat.i(79275);
    if (paramf == null)
    {
      ab.w("MicroMsg.AppInfoLogic", "app is null");
      AppMethodBeat.o(79275);
      return false;
    }
    if ((paramf.field_packageName == null) || (paramf.field_packageName.length() == 0))
    {
      ab.w("MicroMsg.AppInfoLogic", "field_packageName is null");
      AppMethodBeat.o(79275);
      return false;
    }
    boolean bool = p.u(paramContext, paramf.field_packageName);
    AppMethodBeat.o(79275);
    return bool;
  }
  
  public static boolean a(Context paramContext, String paramString, WXMediaMessage paramWXMediaMessage, int paramInt, ai paramai, Bundle paramBundle)
  {
    AppMethodBeat.i(79289);
    if (paramContext == null)
    {
      ab.e("MicroMsg.AppInfoLogic", "launch app failed: context is null");
      if (paramai != null) {
        paramai.dZ(false);
      }
      AppMethodBeat.o(79289);
      return false;
    }
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.AppInfoLogic", "launch app failed: appid is null or nil");
      if (paramai != null) {
        paramai.dZ(false);
      }
      AppMethodBeat.o(79289);
      return false;
    }
    if (paramWXMediaMessage == null)
    {
      ab.e("MicroMsg.AppInfoLogic", "launch app failed: wxMsg is null");
      if (paramai != null) {
        paramai.dZ(false);
      }
      AppMethodBeat.o(79289);
      return false;
    }
    if (Looper.myLooper() == Looper.getMainLooper()) {}
    for (f localf = em(paramString, 2147483647); localf == null; localf = bZ(paramString, false))
    {
      ab.e("MicroMsg.AppInfoLogic", "get appinfo is null, appid is : [%s]", new Object[] { paramString });
      if (paramai != null) {
        paramai.dZ(false);
      }
      AppMethodBeat.o(79289);
      return false;
    }
    if (localf.field_status == 3)
    {
      ab.e("MicroMsg.AppInfoLogic", "requestAppShow fail, app is in blacklist, packageName = " + localf.field_packageName);
      if (paramai != null) {
        paramai.dZ(false);
      }
      AppMethodBeat.o(79289);
      return false;
    }
    boolean bool = a(paramContext, localf.field_packageName, paramWXMediaMessage, paramString, localf.field_openId, paramInt, paramai, paramBundle);
    AppMethodBeat.o(79289);
    return bool;
  }
  
  public static boolean a(Context paramContext, String paramString1, WXMediaMessage paramWXMediaMessage, String paramString2, String paramString3, int paramInt, ai paramai, Bundle paramBundle)
  {
    AppMethodBeat.i(79290);
    ab.d("MicroMsg.AppInfoLogic", "request pkg = " + paramString1 + ", openId = " + paramString3);
    boolean bool = a(paramContext, paramString1, paramString2, c(paramContext, paramWXMediaMessage, paramString3), paramInt, paramai, paramBundle);
    AppMethodBeat.o(79290);
    return bool;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, ShowMessageFromWX.Req paramReq, int paramInt, ai paramai, Bundle paramBundle)
  {
    AppMethodBeat.i(79291);
    if (paramReq == null)
    {
      ab.i("MicroMsg.AppInfoLogic", "launchApp failed, req is null.");
      if (paramai != null) {
        paramai.dZ(false);
      }
      AppMethodBeat.o(79291);
      return false;
    }
    if ((TextUtils.isEmpty(paramString1)) || (!p.u(paramContext, paramString1)))
    {
      ab.i("MicroMsg.AppInfoLogic", "launchApp failed, pkg is null or application has not installed.");
      com.tencent.mm.ui.base.h.bO(paramContext, paramContext.getString(2131298313));
      if (paramai != null) {
        paramai.dZ(false);
      }
      AppMethodBeat.o(79291);
      return false;
    }
    ab.i("MicroMsg.AppInfoLogic", "launchApp(pkg : %s) with appId(%s)", new Object[] { paramString1, paramString2 });
    if (bo.nullAsNil(ah.getPackageName()).equals(paramString1))
    {
      ab.i("MicroMsg.AppInfoLogic", "launchApp failed, can not launch wechat page.");
      if (paramai != null) {
        paramai.dZ(false);
      }
      AppMethodBeat.o(79291);
      return false;
    }
    g.2 local2 = new g.2(paramReq, paramString1, paramContext, paramai);
    if (paramInt == 2)
    {
      ab.i("MicroMsg.AppInfoLogic", "launchApp with show confirm dialog(%s).", new Object[] { paramString1 });
      local2.run();
      AppMethodBeat.o(79291);
      return true;
    }
    Object localObject;
    if (paramBundle != null)
    {
      paramReq = paramBundle.getString("current_page_url", "");
      paramBundle = paramBundle.getString("current_page_appid", "");
      localObject = ca(paramString2, true);
      if ((localObject == null) || (bo.isNullOrNil(b(paramContext, (f)localObject, null)))) {
        break label383;
      }
      localObject = paramContext.getString(2131301023, new Object[] { b(paramContext, (f)localObject, null) });
      label280:
      if (paramString2 != null) {
        break label395;
      }
      paramString2 = "";
    }
    label395:
    for (;;)
    {
      alq(paramString2);
      ab.i("MicroMsg.AppInfoLogic", "launchApp with args(showType : %s, pkg : %s)", new Object[] { Integer.valueOf(paramInt), paramString1 });
      com.tencent.mm.ui.base.h.a(paramContext, (String)localObject, "", paramContext.getString(2131301019), paramContext.getString(2131296888), false, new g.3(paramString1, paramReq, paramBundle, paramString2, local2), new g.4(paramString1, paramReq, paramBundle, paramString2, paramai));
      AppMethodBeat.o(79291);
      return true;
      paramReq = "";
      paramBundle = "";
      break;
      label383:
      localObject = paramContext.getString(2131301022);
      break label280;
    }
  }
  
  private static boolean a(f paramf, int paramInt)
  {
    return (paramf == null) || (paramf.field_appVersion < paramInt);
  }
  
  public static boolean ag(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(79268);
    Long localLong = c.a.akT(String.valueOf(paramInt));
    if (localLong == null)
    {
      AppMethodBeat.o(79268);
      return false;
    }
    if (b(paramContext, localLong.longValue(), true).size() == 0)
    {
      AppMethodBeat.o(79268);
      return false;
    }
    AppMethodBeat.o(79268);
    return true;
  }
  
  public static boolean alp(String paramString)
  {
    AppMethodBeat.i(79285);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(79285);
      return false;
    }
    boolean bool = l(ca(paramString, true));
    AppMethodBeat.o(79285);
    return bool;
  }
  
  private static void alq(String paramString)
  {
    AppMethodBeat.i(79292);
    if ("wx073f4a4daff0abe8".equalsIgnoreCase(paramString)) {
      com.tencent.mm.plugin.report.service.h.qsU.e(15413, new Object[] { Integer.valueOf(1), "", "" });
    }
    AppMethodBeat.o(79292);
  }
  
  public static Bitmap b(String paramString, int paramInt, float paramFloat)
  {
    AppMethodBeat.i(79265);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.e("MicroMsg.AppInfoLogic", "getAppIcon, appId is null");
      AppMethodBeat.o(79265);
      return null;
    }
    if (!com.tencent.mm.kernel.g.RJ().QU())
    {
      AppMethodBeat.o(79265);
      return null;
    }
    if (!com.tencent.mm.kernel.g.RL().isSDCardAvailable())
    {
      if (ah.getContext() == null)
      {
        AppMethodBeat.o(79265);
        return null;
      }
      if (ah.getContext().getResources() == null)
      {
        AppMethodBeat.o(79265);
        return null;
      }
      switch (paramInt)
      {
      default: 
        ab.e("MicroMsg.AppInfoLogic", "getAppIcon, unknown iconType = ".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(79265);
        return null;
      case 1: 
      case 3: 
      case 4: 
      case 5: 
        paramString = BitmapFactory.decodeResource(ah.getContext().getResources(), 2130840316);
        if ((paramString == null) || (paramString.isRecycled()))
        {
          AppMethodBeat.o(79265);
          return null;
        }
        AppMethodBeat.o(79265);
        return paramString;
      }
      AppMethodBeat.o(79265);
      return null;
    }
    Bitmap localBitmap = a.a.caj().a(paramString, paramInt, paramFloat);
    if (localBitmap == null)
    {
      ab.w("MicroMsg.AppInfoLogic", "getAppIcon, bm does not exist or has been recycled");
      a.a.caj().cX(paramString, paramInt);
      AppMethodBeat.o(79265);
      return null;
    }
    if (localBitmap.isRecycled())
    {
      AppMethodBeat.o(79265);
      return null;
    }
    AppMethodBeat.o(79265);
    return localBitmap;
  }
  
  public static String b(Context paramContext, f paramf, String paramString)
  {
    AppMethodBeat.i(79279);
    if ((paramContext == null) || (paramf == null))
    {
      AppMethodBeat.o(79279);
      return paramString;
    }
    String str = fR(paramContext);
    Object localObject = null;
    if (str.equalsIgnoreCase("zh_CN")) {
      localObject = paramf.field_appName;
    }
    if (str.equalsIgnoreCase("en"))
    {
      if (bo.isNullOrNil(paramf.field_appName_en)) {
        localObject = paramf.field_appName;
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
          if (!bo.isNullOrNil(paramf.field_appName_hk)) {
            break label193;
          }
          localObject = paramf.field_appName_tw;
        }
        label122:
        paramContext = (Context)localObject;
        if (bo.isNullOrNil((String)localObject))
        {
          if (!bo.isNullOrNil(paramf.field_appName_tw)) {
            break label201;
          }
          paramContext = paramf.field_appName;
        }
      }
      label146:
      localObject = paramContext;
      if (bo.isNullOrNil(paramContext)) {
        if (!bo.isNullOrNil(paramf.field_appName_en)) {
          break label209;
        }
      }
    }
    label193:
    label201:
    label209:
    for (localObject = paramf.field_appName;; localObject = paramf.field_appName_en)
    {
      if (!bo.isNullOrNil((String)localObject)) {
        break label217;
      }
      AppMethodBeat.o(79279);
      return paramString;
      localObject = paramf.field_appName_en;
      break;
      localObject = paramf.field_appName_hk;
      break label122;
      paramContext = paramf.field_appName_tw;
      break label146;
    }
    label217:
    AppMethodBeat.o(79279);
    return localObject;
  }
  
  public static String b(ResolveInfo paramResolveInfo)
  {
    AppMethodBeat.i(79298);
    if (paramResolveInfo == null)
    {
      AppMethodBeat.o(79298);
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
    AppMethodBeat.o(79298);
    return str1;
  }
  
  public static List<f> b(Context paramContext, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(79266);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = com.tencent.mm.plugin.s.a.cac();
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
    ab.v("MicroMsg.AppInfoStorage", "getAppInfoByContentFlag sql %s", new Object[] { ((StringBuilder)localObject2).toString() });
    localObject2 = ((i)localObject1).rawQuery(((StringBuilder)localObject2).toString(), new String[0]);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      ab.e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
      localObject1 = null;
    }
    if (localObject1 == null)
    {
      AppMethodBeat.o(79266);
      return localArrayList;
    }
    while (((Cursor)localObject1).moveToNext())
    {
      localObject2 = new f();
      ((f)localObject2).convertFrom((Cursor)localObject1);
      if (((f)localObject2).field_status == 1)
      {
        if (u(paramContext, ((f)localObject2).field_appId))
        {
          if (!bo.isNullOrNil(((f)localObject2).field_signature)) {
            localArrayList.add(localObject2);
          }
        }
        else
        {
          ((f)localObject2).field_status = 4;
          a.a.caj().g((f)localObject2);
        }
      }
      else if (((f)localObject2).field_signature != null) {
        localArrayList.add(localObject2);
      }
    }
    ((Cursor)localObject1).close();
    AppMethodBeat.o(79266);
    return localArrayList;
  }
  
  public static boolean b(Context paramContext, Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(79293);
    boolean bool = a(paramContext, paramIntent, paramString, null, null);
    AppMethodBeat.o(79293);
    return bool;
  }
  
  public static boolean b(f paramf, int paramInt)
  {
    AppMethodBeat.i(79287);
    if ((paramf == null) || (bo.isNullOrNil(paramf.field_appId)))
    {
      AppMethodBeat.o(79287);
      return false;
    }
    if ((paramf.field_appInfoFlag & paramInt) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.AppInfoLogic", "isAppHasFlag, appid = %s, flag = %s, ret = %b", new Object[] { paramf.field_appId, Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      ab.i("MicroMsg.AppInfoLogic", "appInfoFlag = " + paramf.field_appInfoFlag);
      AppMethodBeat.o(79287);
      return bool;
    }
  }
  
  public static f bZ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(79262);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.e("MicroMsg.AppInfoLogic", "getAppInfo, appId is null");
      AppMethodBeat.o(79262);
      return null;
    }
    com.tencent.mm.plugin.s.a.a locala = a.a.caj();
    if (locala == null)
    {
      ab.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
      AppMethodBeat.o(79262);
      return null;
    }
    if (paramBoolean)
    {
      paramString = locala.WE(paramString);
      AppMethodBeat.o(79262);
      return paramString;
    }
    f localf = locala.WD(paramString);
    if (localf == null)
    {
      paramString = locala.WE(paramString);
      AppMethodBeat.o(79262);
      return paramString;
    }
    locala.WF(paramString);
    AppMethodBeat.o(79262);
    return localf;
  }
  
  public static ShowMessageFromWX.Req c(Context paramContext, WXMediaMessage paramWXMediaMessage, String paramString)
  {
    AppMethodBeat.i(79297);
    ShowMessageFromWX.Req localReq = new ShowMessageFromWX.Req();
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = ah.getContext();
    }
    localReq.message = paramWXMediaMessage;
    localReq.transaction = com.tencent.mm.a.g.w(bo.aoy().getBytes());
    localReq.openId = paramString;
    localReq.lang = aa.f(localContext.getSharedPreferences(ah.dsP(), 0));
    localReq.country = ((String)com.tencent.mm.kernel.g.RL().Ru().get(274436, null));
    AppMethodBeat.o(79297);
    return localReq;
  }
  
  public static String c(Context paramContext, f paramf, String paramString)
  {
    AppMethodBeat.i(79280);
    if ((paramContext == null) || (paramf == null))
    {
      AppMethodBeat.o(79280);
      return paramString;
    }
    String str = fR(paramContext);
    paramContext = null;
    if (str.equalsIgnoreCase("zh_CN")) {
      paramContext = paramf.field_appName;
    }
    if (str.equalsIgnoreCase("en"))
    {
      if (bo.isNullOrNil(paramf.field_appName_en)) {
        paramContext = paramf.field_appName;
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
        if (!bo.isNullOrNil(paramf.field_appName_hk)) {
          break label169;
        }
        paramContext = paramf.field_appName_tw;
      }
      label122:
      localObject = paramContext;
      if (bo.isNullOrNil(paramContext)) {
        if (!bo.isNullOrNil(paramf.field_appName_tw)) {
          break label177;
        }
      }
    }
    label169:
    label177:
    for (Object localObject = paramf.field_appName;; localObject = paramf.field_appName_tw)
    {
      if (!bo.isNullOrNil((String)localObject)) {
        break label185;
      }
      AppMethodBeat.o(79280);
      return paramString;
      paramContext = paramf.field_appName_en;
      break;
      paramContext = paramf.field_appName_hk;
      break label122;
    }
    label185:
    AppMethodBeat.o(79280);
    return localObject;
  }
  
  public static f ca(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(79263);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.e("MicroMsg.AppInfoLogic", "getAppInfo, appId is null");
      AppMethodBeat.o(79263);
      return null;
    }
    if (a.a.caj() == null)
    {
      ab.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
      AppMethodBeat.o(79263);
      return null;
    }
    f localf = a.a.caj().WD(paramString);
    if ((paramBoolean) && (i(localf))) {
      a.a.caj().WF(paramString);
    }
    AppMethodBeat.o(79263);
    return localf;
  }
  
  public static boolean dF(String paramString)
  {
    AppMethodBeat.i(79276);
    if ((paramString == null) || (paramString.trim().length() == 0) || (paramString.equals("weixinfile")) || (paramString.equals("invalid_appname")))
    {
      AppMethodBeat.o(79276);
      return false;
    }
    AppMethodBeat.o(79276);
    return true;
  }
  
  public static boolean dG(String paramString)
  {
    AppMethodBeat.i(79282);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(79282);
      return false;
    }
    f localf = ca(paramString, false);
    if (localf == null)
    {
      ab.w("MicroMsg.AppInfoLogic", "app is null, appId = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(79282);
      return false;
    }
    boolean bool = localf.vY();
    AppMethodBeat.o(79282);
    return bool;
  }
  
  public static List<f> dlA()
  {
    AppMethodBeat.i(79273);
    ArrayList localArrayList = new ArrayList();
    if (a.a.caj() == null)
    {
      ab.e("MicroMsg.AppInfoLogic", "getAllServices, getISubCorePluginBase() == null");
      AppMethodBeat.o(79273);
      return localArrayList;
    }
    Cursor localCursor = a.a.caj().cai();
    if (localCursor == null)
    {
      AppMethodBeat.o(79273);
      return localArrayList;
    }
    while (localCursor.moveToNext())
    {
      f localf = new f();
      localf.convertFrom(localCursor);
      if (!bo.isNullOrNil(localf.field_openId)) {
        localArrayList.add(localf);
      }
    }
    localCursor.close();
    AppMethodBeat.o(79273);
    return localArrayList;
  }
  
  public static f em(String paramString, int paramInt)
  {
    AppMethodBeat.i(79261);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.e("MicroMsg.AppInfoLogic", "getAppInfo, appId is null");
      AppMethodBeat.o(79261);
      return null;
    }
    if (a.a.caj() == null)
    {
      ab.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
      AppMethodBeat.o(79261);
      return null;
    }
    f localf = a.a.caj().WD(paramString);
    if (a(localf, paramInt)) {
      a.a.caj().WF(paramString);
    }
    AppMethodBeat.o(79261);
    return localf;
  }
  
  public static List<f> fQ(Context paramContext)
  {
    AppMethodBeat.i(79269);
    ArrayList localArrayList = new ArrayList();
    if (a.a.caj() == null)
    {
      ab.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
      AppMethodBeat.o(79269);
      return localArrayList;
    }
    Cursor localCursor = a.a.caj().cag();
    if (localCursor == null)
    {
      AppMethodBeat.o(79269);
      return localArrayList;
    }
    while (localCursor.moveToNext())
    {
      f localf = new f();
      localf.convertFrom(localCursor);
      if (localf.field_status == 1)
      {
        if (u(paramContext, localf.field_appId))
        {
          if (!bo.isNullOrNil(localf.field_signature)) {
            localArrayList.add(localf);
          }
        }
        else
        {
          localf.field_status = 4;
          a.a.caj().g(localf);
        }
      }
      else if (localf.field_signature != null) {
        localArrayList.add(localf);
      }
    }
    localCursor.close();
    AppMethodBeat.o(79269);
    return localArrayList;
  }
  
  public static String fR(Context paramContext)
  {
    AppMethodBeat.i(79281);
    paramContext = aa.f(paramContext.getSharedPreferences(ah.dsP(), 0));
    if ((paramContext == null) || (paramContext.length() == 0) || (paramContext.equalsIgnoreCase("zh_CN")))
    {
      AppMethodBeat.o(79281);
      return "zh_CN";
    }
    AppMethodBeat.o(79281);
    return paramContext;
  }
  
  public static List<f> gZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(79271);
    ArrayList localArrayList = new ArrayList();
    if (a.a.caj() == null)
    {
      ab.e("MicroMsg.AppInfoLogic", "getServiceByAppInfoFlagAndShowFlag, getISubCorePluginBase() == null");
      AppMethodBeat.o(79271);
      return localArrayList;
    }
    Cursor localCursor = a.a.caj().eZ(paramInt1, paramInt2);
    if (localCursor == null)
    {
      AppMethodBeat.o(79271);
      return localArrayList;
    }
    while (localCursor.moveToNext())
    {
      f localf = new f();
      localf.convertFrom(localCursor);
      localArrayList.add(localf);
    }
    localCursor.close();
    ab.i("MicroMsg.AppInfoLogic", "getServiceByAppInfoFlagAndShowFlag: size is %s", new Object[] { Integer.valueOf(localArrayList.size()) });
    AppMethodBeat.o(79271);
    return localArrayList;
  }
  
  private static boolean i(f paramf)
  {
    AppMethodBeat.i(79264);
    if ((paramf == null) || (paramf.field_appName == null) || (paramf.field_appName.length() == 0))
    {
      AppMethodBeat.o(79264);
      return true;
    }
    AppMethodBeat.o(79264);
    return false;
  }
  
  public static boolean j(f paramf)
  {
    AppMethodBeat.i(79283);
    if ((paramf == null) || (bo.isNullOrNil(paramf.field_appId)))
    {
      AppMethodBeat.o(79283);
      return false;
    }
    if ((paramf.field_appInfoFlag & 0x1) > 0)
    {
      AppMethodBeat.o(79283);
      return true;
    }
    AppMethodBeat.o(79283);
    return false;
  }
  
  public static boolean k(f paramf)
  {
    if (paramf == null) {}
    while ((paramf.field_appInfoFlag & 0x2) == 0) {
      return true;
    }
    return false;
  }
  
  private static boolean l(f paramf)
  {
    AppMethodBeat.i(79284);
    if ((paramf == null) || (bo.isNullOrNil(paramf.field_appId)))
    {
      AppMethodBeat.o(79284);
      return false;
    }
    if (paramf.field_appId.equals("wx7fa037cc7dfabad5"))
    {
      AppMethodBeat.o(79284);
      return true;
    }
    if ((paramf.field_appInfoFlag & 0x8) > 0)
    {
      AppMethodBeat.o(79284);
      return true;
    }
    AppMethodBeat.o(79284);
    return false;
  }
  
  public static boolean m(f paramf)
  {
    AppMethodBeat.i(79286);
    if ((paramf == null) || (bo.isNullOrNil(paramf.field_appId)))
    {
      AppMethodBeat.o(79286);
      return false;
    }
    if ((paramf.field_appInfoFlag & 0x40) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ab.v("MicroMsg.AppInfoLogic", "canReadMMMsg, appid = %s, ret = %b", new Object[] { paramf.field_appId, Boolean.valueOf(bool) });
      AppMethodBeat.o(79286);
      return bool;
    }
  }
  
  public static boolean n(f paramf)
  {
    AppMethodBeat.i(79288);
    if ((paramf == null) || (bo.isNullOrNil(paramf.field_appId)))
    {
      AppMethodBeat.o(79288);
      return false;
    }
    int i;
    HashMap localHashMap;
    if ((paramf.field_appInfoFlag & 0x80) > 0)
    {
      i = 1;
      if (1 != i) {
        break label124;
      }
      paramf = paramf.field_appId;
      localHashMap = new HashMap();
      r.n(localHashMap);
      if (!localHashMap.containsKey(paramf)) {
        break label111;
      }
    }
    label111:
    for (paramf = (String)localHashMap.get(paramf);; paramf = null)
    {
      if ((paramf != null) && (!paramf.equals("0"))) {
        break label116;
      }
      AppMethodBeat.o(79288);
      return true;
      i = 0;
      break;
    }
    label116:
    AppMethodBeat.o(79288);
    return false;
    label124:
    AppMethodBeat.o(79288);
    return false;
  }
  
  public static boolean o(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(79267);
    if (b(paramContext, paramLong, true).size() == 0)
    {
      AppMethodBeat.o(79267);
      return false;
    }
    AppMethodBeat.o(79267);
    return true;
  }
  
  public static String q(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(79277);
    paramContext = b(paramContext, em(paramString, paramInt), null);
    AppMethodBeat.o(79277);
    return paramContext;
  }
  
  public static String t(Context paramContext, String paramString)
  {
    AppMethodBeat.i(79278);
    paramContext = b(paramContext, ca(paramString, true), null);
    AppMethodBeat.o(79278);
    return paramContext;
  }
  
  public static boolean u(Context paramContext, String paramString)
  {
    AppMethodBeat.i(79274);
    if ((paramContext == null) || (paramString == null) || (paramString.length() == 0))
    {
      ab.e("MicroMsg.AppInfoLogic", "isAppInstalled, invalid arguments");
      AppMethodBeat.o(79274);
      return false;
    }
    boolean bool = a(paramContext, ca(paramString, true));
    AppMethodBeat.o(79274);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract void a(f paramf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.g
 * JD-Core Version:    0.7.0.1
 */