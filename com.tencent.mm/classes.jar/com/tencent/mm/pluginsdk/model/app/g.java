package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.q;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.comm.a.d;
import com.tencent.mm.plugin.comm.a.h;
import com.tencent.mm.plugin.z.a.a.a;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class g
{
  private static List<f> DJ(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (a.a.bru() == null) {
      y.e("MicroMsg.AppInfoLogic", "getServiceByAppInfoFlagAndShowFlag, getISubCorePluginBase() == null");
    }
    Cursor localCursor;
    do
    {
      return localArrayList;
      localCursor = a.a.bru().dz(1, paramInt);
    } while (localCursor == null);
    while (localCursor.moveToNext())
    {
      f localf = new f();
      localf.d(localCursor);
      if (!bk.bl(localf.field_openId)) {
        localArrayList.add(localf);
      }
    }
    localCursor.close();
    return localArrayList;
  }
  
  public static f KC(String paramString)
  {
    return by(paramString, true);
  }
  
  public static boolean S(Context paramContext, int paramInt)
  {
    Long localLong = b.a.Vx(String.valueOf(paramInt));
    if (localLong == null) {}
    while (b(paramContext, localLong.longValue(), true).size() == 0) {
      return false;
    }
    return true;
  }
  
  public static boolean VR(String paramString)
  {
    if (bk.bl(paramString)) {}
    do
    {
      do
      {
        return false;
        paramString = by(paramString, true);
      } while ((paramString == null) || (bk.bl(paramString.field_appId)));
      if (paramString.field_appId.equals("wx7fa037cc7dfabad5")) {
        return true;
      }
    } while ((paramString.field_appInfoFlag & 0x8) <= 0);
    return true;
  }
  
  public static List<f> a(Context paramContext, boolean paramBoolean, int paramInt)
  {
    Object localObject1 = new ArrayList();
    if (a.a.bru() == null) {
      y.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
    }
    List localList;
    Object localObject2;
    do
    {
      do
      {
        return localObject1;
        localList = DJ(paramInt);
        localObject2 = null;
        if (paramBoolean)
        {
          localObject2 = new int[1];
          localObject2[0] = 5;
        }
        localObject1 = localList;
      } while (localObject2 == null);
      localObject2 = a.a.bru().p((int[])localObject2);
      localObject1 = localList;
    } while (localObject2 == null);
    while (((Cursor)localObject2).moveToNext())
    {
      localObject1 = new f();
      ((f)localObject1).d((Cursor)localObject2);
      if (((f)localObject1).field_status == 1)
      {
        if (o(paramContext, ((f)localObject1).field_appId))
        {
          if (!bk.bl(((f)localObject1).field_signature)) {
            localList.add(localObject1);
          }
        }
        else
        {
          ((f)localObject1).field_status = 4;
          a.a.bru().e((f)localObject1);
        }
      }
      else if (((f)localObject1).field_signature != null) {
        localList.add(localObject1);
      }
    }
    ((Cursor)localObject2).close();
    return localList;
  }
  
  public static boolean a(Context paramContext, Intent paramIntent, String paramString)
  {
    return a(paramContext, paramIntent, paramString, null, null);
  }
  
  public static boolean a(Context paramContext, Intent paramIntent, String paramString, int paramInt, am paramam, Bundle paramBundle)
  {
    if ((paramContext == null) || (paramIntent == null))
    {
      y.i("MicroMsg.AppInfoLogic", "launchApp failed, context or intent is null.");
      if (paramam != null) {
        paramam.cW(false);
      }
      return false;
    }
    String str;
    if (paramBundle != null)
    {
      localObject = paramBundle.getString("current_page_url", "");
      str = paramBundle.getString("current_page_appid", "");
      paramBundle = (Bundle)localObject;
      localObject = bk.A(paramContext, paramIntent);
      if ((localObject == null) || (((List)localObject).isEmpty())) {
        break label325;
      }
      if ((!TextUtils.isEmpty(paramIntent.getPackage())) || (((List)localObject).size() != 1)) {
        break label184;
      }
    }
    label184:
    for (Object localObject = b((ResolveInfo)((List)localObject).get(0));; localObject = paramIntent.getPackage())
    {
      y.d("MicroMsg.AppInfoLogic", "launchApp, wxpkg : %s.", new Object[] { ae.getPackageName() });
      if (!bk.pm(ae.getPackageName()).equals(localObject)) {
        break label193;
      }
      y.i("MicroMsg.AppInfoLogic", "launchApp failed, can not launch wechat page.");
      if (paramam != null) {
        paramam.cW(false);
      }
      return false;
      paramBundle = "";
      str = "";
      break;
    }
    label193:
    y.i("MicroMsg.AppInfoLogic", "launchApp(pkg : %s) by wechat with intent", new Object[] { localObject });
    if (paramInt == 2)
    {
      paramContext.startActivity(paramIntent);
      if (paramam != null) {
        paramam.cW(true);
      }
      return true;
    }
    if (!TextUtils.isEmpty(paramString)) {}
    for (paramString = paramContext.getString(a.h.launch_3rd_detail_app_tips, new Object[] { paramString });; paramString = paramContext.getString(a.h.launch_3rd_app_tips))
    {
      com.tencent.mm.ui.base.h.a(paramContext, paramString, "", paramContext.getString(a.h.launch_3rd_app_confirm), paramContext.getString(a.h.app_cancel), false, new g.4(paramContext, paramIntent, (String)localObject, paramBundle, str, paramam), new g.5((String)localObject, paramBundle, str, paramam));
      return true;
    }
    label325:
    y.w("MicroMsg.AppInfoLogic", "launchApp failed, not activity can resolve the intent.");
    if (paramam != null) {
      paramam.cW(false);
    }
    return false;
  }
  
  public static boolean a(Context paramContext, Intent paramIntent, String paramString, am paramam)
  {
    return a(paramContext, paramIntent, paramString, paramam, null);
  }
  
  public static boolean a(Context paramContext, Intent paramIntent, String paramString, am paramam, Bundle paramBundle)
  {
    return a(paramContext, paramIntent, paramString, 0, paramam, paramBundle);
  }
  
  public static boolean a(Context paramContext, f paramf)
  {
    if (paramf == null)
    {
      y.w("MicroMsg.AppInfoLogic", "app is null");
      return false;
    }
    if ((paramf.field_packageName == null) || (paramf.field_packageName.length() == 0))
    {
      y.w("MicroMsg.AppInfoLogic", "field_packageName is null");
      return false;
    }
    return p.o(paramContext, paramf.field_packageName);
  }
  
  public static boolean a(Context paramContext, String paramString, WXMediaMessage paramWXMediaMessage, int paramInt, am paramam, Bundle paramBundle)
  {
    if (paramContext == null)
    {
      y.e("MicroMsg.AppInfoLogic", "launch app failed: context is null");
      if (paramam != null) {
        paramam.cW(false);
      }
    }
    f localf;
    label148:
    do
    {
      do
      {
        do
        {
          return false;
          if (!bk.bl(paramString)) {
            break;
          }
          y.e("MicroMsg.AppInfoLogic", "launch app failed: appid is null or nil");
        } while (paramam == null);
        paramam.cW(false);
        return false;
        if (paramWXMediaMessage != null) {
          break;
        }
        y.e("MicroMsg.AppInfoLogic", "launch app failed: wxMsg is null");
      } while (paramam == null);
      paramam.cW(false);
      return false;
      if (Looper.myLooper() == Looper.getMainLooper()) {}
      for (localf = dh(paramString, 2147483647);; localf = bx(paramString, false))
      {
        if (localf != null) {
          break label148;
        }
        y.e("MicroMsg.AppInfoLogic", "get appinfo is null, appid is : [%s]", new Object[] { paramString });
        if (paramam == null) {
          break;
        }
        paramam.cW(false);
        return false;
      }
      if (localf.field_status != 3) {
        break;
      }
      y.e("MicroMsg.AppInfoLogic", "requestAppShow fail, app is in blacklist, packageName = " + localf.field_packageName);
    } while (paramam == null);
    paramam.cW(false);
    return false;
    return a(paramContext, localf.field_packageName, paramWXMediaMessage, paramString, localf.field_openId, paramInt, paramam, paramBundle);
  }
  
  public static boolean a(Context paramContext, String paramString1, WXMediaMessage paramWXMediaMessage, String paramString2, String paramString3, int paramInt, am paramam, Bundle paramBundle)
  {
    y.d("MicroMsg.AppInfoLogic", "request pkg = " + paramString1 + ", openId = " + paramString3);
    return a(paramContext, paramString1, paramString2, c(paramContext, paramWXMediaMessage, paramString3), paramInt, paramam, paramBundle);
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, ShowMessageFromWX.Req paramReq, int paramInt, am paramam, Bundle paramBundle)
  {
    if (paramReq == null)
    {
      y.i("MicroMsg.AppInfoLogic", "launchApp failed, req is null.");
      if (paramam != null) {
        paramam.cW(false);
      }
      return false;
    }
    if ((TextUtils.isEmpty(paramString1)) || (!p.o(paramContext, paramString1)))
    {
      y.i("MicroMsg.AppInfoLogic", "launchApp failed, pkg is null or application has not installed.");
      com.tencent.mm.ui.base.h.bC(paramContext, paramContext.getString(a.h.chatting_send_app_not_installed));
      if (paramam != null) {
        paramam.cW(false);
      }
      return false;
    }
    y.i("MicroMsg.AppInfoLogic", "launchApp(pkg : %s) with appId(%s)", new Object[] { paramString1, paramString2 });
    if (bk.pm(ae.getPackageName()).equals(paramString1))
    {
      y.i("MicroMsg.AppInfoLogic", "launchApp failed, can not launch wechat page.");
      if (paramam != null) {
        paramam.cW(false);
      }
      return false;
    }
    g.1 local1 = new g.1(paramReq, paramString1, paramContext, paramam);
    if (paramInt == 2)
    {
      y.i("MicroMsg.AppInfoLogic", "launchApp with show confirm dialog(%s).", new Object[] { paramString1 });
      local1.run();
      return true;
    }
    Object localObject;
    if (paramBundle != null)
    {
      paramReq = paramBundle.getString("current_page_url", "");
      paramBundle = paramBundle.getString("current_page_appid", "");
      localObject = by(paramString2, true);
      if ((localObject == null) || (bk.bl(b(paramContext, (f)localObject, null)))) {
        break label386;
      }
      localObject = paramContext.getString(a.h.launch_3rd_detail_app_tips, new Object[] { b(paramContext, (f)localObject, null) });
      label251:
      if (paramString2 != null) {
        break label398;
      }
      paramString2 = "";
    }
    label386:
    label398:
    for (;;)
    {
      if ("wx073f4a4daff0abe8".equalsIgnoreCase(paramString2)) {
        com.tencent.mm.plugin.report.service.h.nFQ.f(15413, new Object[] { Integer.valueOf(1), "", "" });
      }
      y.i("MicroMsg.AppInfoLogic", "launchApp with args(showType : %s, pkg : %s)", new Object[] { Integer.valueOf(paramInt), paramString1 });
      com.tencent.mm.ui.base.h.a(paramContext, (String)localObject, "", paramContext.getString(a.h.launch_3rd_app_confirm), paramContext.getString(a.h.app_cancel), false, new g.2(paramString1, paramReq, paramBundle, paramString2, local1), new g.3(paramString1, paramReq, paramBundle, paramString2, paramam));
      return true;
      paramReq = "";
      paramBundle = "";
      break;
      localObject = paramContext.getString(a.h.launch_3rd_app_tips);
      break label251;
    }
  }
  
  public static boolean a(f paramf, int paramInt)
  {
    if ((paramf == null) || (bk.bl(paramf.field_appId))) {
      return false;
    }
    if ((paramf.field_appInfoFlag & paramInt) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.AppInfoLogic", "isAppHasFlag, appid = %s, flag = %s, ret = %b", new Object[] { paramf.field_appId, Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      y.i("MicroMsg.AppInfoLogic", "appInfoFlag = " + paramf.field_appInfoFlag);
      return bool;
    }
  }
  
  public static Bitmap b(String paramString, int paramInt, float paramFloat)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      y.e("MicroMsg.AppInfoLogic", "getAppIcon, appId is null");
    }
    Bitmap localBitmap;
    do
    {
      do
      {
        do
        {
          do
          {
            return null;
          } while (!com.tencent.mm.kernel.g.DN().Dc());
          if (com.tencent.mm.kernel.g.DP().isSDCardAvailable()) {
            break;
          }
        } while ((ae.getContext() == null) || (ae.getContext().getResources() == null));
        switch (paramInt)
        {
        case 2: 
        default: 
          y.e("MicroMsg.AppInfoLogic", "getAppIcon, unknown iconType = " + paramInt);
          return null;
        }
        paramString = BitmapFactory.decodeResource(ae.getContext().getResources(), a.d.sharemore_nosdcard_icon);
      } while ((paramString == null) || (paramString.isRecycled()));
      return paramString;
      localBitmap = a.a.bru().a(paramString, paramInt, paramFloat);
      if (localBitmap == null)
      {
        y.w("MicroMsg.AppInfoLogic", "getAppIcon, bm does not exist or has been recycled");
        a.a.bru().cf(paramString, paramInt);
        return null;
      }
    } while (localBitmap.isRecycled());
    return localBitmap;
  }
  
  public static String b(Context paramContext, f paramf, String paramString)
  {
    if ((paramContext == null) || (paramf == null)) {}
    label134:
    label175:
    label183:
    label191:
    label197:
    for (;;)
    {
      return paramString;
      String str = eR(paramContext);
      Object localObject = null;
      if (str.equalsIgnoreCase("zh_CN")) {
        localObject = paramf.field_appName;
      }
      if (str.equalsIgnoreCase("en"))
      {
        if (bk.bl(paramf.field_appName_en)) {
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
            if (!bk.bl(paramf.field_appName_hk)) {
              break label175;
            }
            localObject = paramf.field_appName_tw;
          }
          label110:
          paramContext = (Context)localObject;
          if (bk.bl((String)localObject))
          {
            if (!bk.bl(paramf.field_appName_tw)) {
              break label183;
            }
            paramContext = paramf.field_appName;
          }
        }
        localObject = paramContext;
        if (bk.bl(paramContext)) {
          if (!bk.bl(paramf.field_appName_en)) {
            break label191;
          }
        }
      }
      for (localObject = paramf.field_appName;; localObject = paramf.field_appName_en)
      {
        if (bk.bl((String)localObject)) {
          break label197;
        }
        return localObject;
        localObject = paramf.field_appName_en;
        break;
        localObject = paramf.field_appName_hk;
        break label110;
        paramContext = paramf.field_appName_tw;
        break label134;
      }
    }
  }
  
  public static String b(ResolveInfo paramResolveInfo)
  {
    Object localObject;
    if (paramResolveInfo == null) {
      localObject = null;
    }
    do
    {
      String str;
      do
      {
        return localObject;
        str = paramResolveInfo.resolvePackageName;
        localObject = str;
      } while (!TextUtils.isEmpty(str));
      localObject = str;
    } while (paramResolveInfo.activityInfo == null);
    return paramResolveInfo.activityInfo.packageName;
  }
  
  public static List<f> b(Context paramContext, long paramLong, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = com.tencent.mm.plugin.z.a.brn();
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
    y.v("MicroMsg.AppInfoStorage", "getAppInfoByContentFlag sql %s", new Object[] { ((StringBuilder)localObject2).toString() });
    localObject2 = ((i)localObject1).rawQuery(((StringBuilder)localObject2).toString(), new String[0]);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      y.e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
      localObject1 = null;
    }
    if (localObject1 == null) {
      return localArrayList;
    }
    while (((Cursor)localObject1).moveToNext())
    {
      localObject2 = new f();
      ((f)localObject2).d((Cursor)localObject1);
      if (((f)localObject2).field_status == 1)
      {
        if (o(paramContext, ((f)localObject2).field_appId))
        {
          if (!bk.bl(((f)localObject2).field_signature)) {
            localArrayList.add(localObject2);
          }
        }
        else
        {
          ((f)localObject2).field_status = 4;
          a.a.bru().e((f)localObject2);
        }
      }
      else if (((f)localObject2).field_signature != null) {
        localArrayList.add(localObject2);
      }
    }
    ((Cursor)localObject1).close();
    return localArrayList;
  }
  
  public static f bx(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      y.e("MicroMsg.AppInfoLogic", "getAppInfo, appId is null");
      return null;
    }
    com.tencent.mm.plugin.z.a.a locala = a.a.bru();
    if (locala == null)
    {
      y.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
      return null;
    }
    if (paramBoolean) {
      return locala.KD(paramString);
    }
    f localf = locala.KC(paramString);
    if (localf == null) {
      return locala.KD(paramString);
    }
    locala.KE(paramString);
    return localf;
  }
  
  public static f by(String paramString, boolean paramBoolean)
  {
    Object localObject = null;
    if ((paramString == null) || (paramString.length() == 0)) {
      y.e("MicroMsg.AppInfoLogic", "getAppInfo, appId is null");
    }
    f localf;
    do
    {
      return localObject;
      if (a.a.bru() == null)
      {
        y.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
        return null;
      }
      localf = a.a.bru().KC(paramString);
      localObject = localf;
    } while (!paramBoolean);
    if ((localf == null) || (localf.field_appName == null) || (localf.field_appName.length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      localObject = localf;
      if (i == 0) {
        break;
      }
      a.a.bru().KE(paramString);
      return localf;
    }
  }
  
  public static ShowMessageFromWX.Req c(Context paramContext, WXMediaMessage paramWXMediaMessage, String paramString)
  {
    ShowMessageFromWX.Req localReq = new ShowMessageFromWX.Req();
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = ae.getContext();
    }
    localReq.message = paramWXMediaMessage;
    localReq.transaction = com.tencent.mm.a.g.o(bk.UY().getBytes());
    localReq.openId = paramString;
    localReq.lang = x.d(localContext.getSharedPreferences(ae.cqR(), 0));
    localReq.country = ((String)com.tencent.mm.kernel.g.DP().Dz().get(274436, null));
    return localReq;
  }
  
  public static void ckQ()
  {
    SharedPreferences localSharedPreferences = ae.cqS();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putString("key_app_ids_registion_while_not_login", "").commit();
    }
  }
  
  public static boolean ct(String paramString)
  {
    return (paramString != null) && (paramString.trim().length() != 0) && (!paramString.equals("weixinfile")) && (!paramString.equals("invalid_appname"));
  }
  
  public static boolean cu(String paramString)
  {
    if (bk.bl(paramString)) {
      return false;
    }
    f localf = by(paramString, false);
    if (localf == null)
    {
      y.w("MicroMsg.AppInfoLogic", "app is null, appId = " + paramString);
      return false;
    }
    return localf.ZH();
  }
  
  public static f dh(String paramString, int paramInt)
  {
    Object localObject = null;
    if ((paramString == null) || (paramString.length() == 0))
    {
      y.e("MicroMsg.AppInfoLogic", "getAppInfo, appId is null");
      return localObject;
    }
    if (a.a.bru() == null)
    {
      y.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
      return null;
    }
    f localf = a.a.bru().KC(paramString);
    if ((localf == null) || (localf.field_appVersion < paramInt)) {}
    for (paramInt = 1;; paramInt = 0)
    {
      localObject = localf;
      if (paramInt == 0) {
        break;
      }
      a.a.bru().KE(paramString);
      return localf;
    }
  }
  
  public static List<f> eQ(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    if (a.a.bru() == null) {
      y.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
    }
    Cursor localCursor;
    do
    {
      return localArrayList;
      localCursor = a.a.bru().brr();
    } while (localCursor == null);
    while (localCursor.moveToNext())
    {
      f localf = new f();
      localf.d(localCursor);
      if (localf.field_status == 1)
      {
        if (o(paramContext, localf.field_appId))
        {
          if (!bk.bl(localf.field_signature)) {
            localArrayList.add(localf);
          }
        }
        else
        {
          localf.field_status = 4;
          a.a.bru().e(localf);
        }
      }
      else if (localf.field_signature != null) {
        localArrayList.add(localf);
      }
    }
    localCursor.close();
    return localArrayList;
  }
  
  public static String eR(Context paramContext)
  {
    String str = x.d(paramContext.getSharedPreferences(ae.cqR(), 0));
    if ((str != null) && (str.length() != 0))
    {
      paramContext = str;
      if (!str.equalsIgnoreCase("zh_CN")) {}
    }
    else
    {
      paramContext = "zh_CN";
    }
    return paramContext;
  }
  
  public static boolean g(f paramf)
  {
    if ((paramf == null) || (bk.bl(paramf.field_appId))) {}
    while ((paramf.field_appInfoFlag & 0x1) <= 0) {
      return false;
    }
    return true;
  }
  
  public static boolean h(f paramf)
  {
    if (paramf == null) {}
    while ((paramf.field_appInfoFlag & 0x2) == 0) {
      return true;
    }
    return false;
  }
  
  public static boolean i(f paramf)
  {
    if ((paramf == null) || (bk.bl(paramf.field_appId))) {
      return false;
    }
    if ((paramf.field_appInfoFlag & 0x40) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      y.v("MicroMsg.AppInfoLogic", "canReadMMMsg, appid = %s, ret = %b", new Object[] { paramf.field_appId, Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  public static boolean j(f paramf)
  {
    if ((paramf == null) || (bk.bl(paramf.field_appId))) {
      return false;
    }
    int i;
    HashMap localHashMap;
    if ((paramf.field_appInfoFlag & 0x80) > 0)
    {
      i = 1;
      if (1 != i) {
        break label100;
      }
      paramf = paramf.field_appId;
      localHashMap = new HashMap();
      q.j(localHashMap);
      if (!localHashMap.containsKey(paramf)) {
        break label93;
      }
    }
    label93:
    for (paramf = (String)localHashMap.get(paramf);; paramf = null)
    {
      if ((paramf != null) && (!paramf.equals("0"))) {
        break label98;
      }
      return true;
      i = 0;
      break;
    }
    label98:
    return false;
    label100:
    return false;
  }
  
  public static boolean m(Context paramContext, long paramLong)
  {
    boolean bool = true;
    if (b(paramContext, paramLong, true).size() == 0) {
      bool = false;
    }
    return bool;
  }
  
  public static String n(Context paramContext, String paramString)
  {
    return b(paramContext, by(paramString, true), null);
  }
  
  public static boolean o(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null) || (paramString.length() == 0))
    {
      y.e("MicroMsg.AppInfoLogic", "isAppInstalled, invalid arguments");
      return false;
    }
    return a(paramContext, by(paramString, true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.g
 * JD-Core Version:    0.7.0.1
 */