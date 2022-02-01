package com.tencent.mm.plugin.sns.data;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.b;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.a.a.a;
import com.tencent.mm.plugin.sns.device.appstore.d;
import com.tencent.mm.plugin.sns.device.appstore.e;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADInfo.a;
import com.tencent.mm.plugin.sns.storage.ADInfo.b;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.cnd;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class k
{
  private static void a(Context paramContext, Intent paramIntent, final String paramString1, final String paramString2, final String paramString3, final String paramString4, int paramInt)
  {
    AppMethodBeat.i(202603);
    if ((paramContext == null) || (paramIntent == null))
    {
      Log.e("SnsAdUtil", "startMarketActivity input param is error");
      AppMethodBeat.o(202603);
      return;
    }
    try
    {
      if (!(paramContext instanceof Activity)) {
        paramIntent.addFlags(268435456);
      }
      String str = Util.nullAs(IntentUtil.getStringExtra(paramIntent, "market_app_name"), "");
      ap.a(paramContext, paramIntent.getPackage(), "", paramIntent, str, new al()
      {
        public final void v(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
        {
          AppMethodBeat.i(202591);
          if (paramAnonymousBoolean1)
          {
            if (this.val$showType != 2) {
              k.b(paramString2, paramString3, paramString4, 2, "0");
            }
            e locale = e.C(paramString1, paramString2, paramString3, paramString4);
            if (locale != null) {
              d.a(locale);
            }
            AppMethodBeat.o(202591);
            return;
          }
          if (this.val$showType != 2) {
            k.b(paramString2, paramString3, paramString4, 2, "2");
          }
          AppMethodBeat.o(202591);
        }
      }, paramInt);
      AppMethodBeat.o(202603);
      return;
    }
    catch (Throwable paramContext)
    {
      b(paramString2, paramString3, paramString4, 2, "1");
      AppMethodBeat.o(202603);
    }
  }
  
  public static void a(Context paramContext, String paramString1, ah paramah, int paramInt, long paramLong, String paramString2)
  {
    AppMethodBeat.i(202592);
    label440:
    for (;;)
    {
      try
      {
        Intent localIntent = new Intent();
        Object localObject = paramString1;
        if (!TextUtils.isEmpty(paramah.kZe))
        {
          localObject = paramString1;
          if (!TextUtils.isEmpty(paramah.aid)) {
            localObject = ap.n(paramString1, new String[] { "traceid=" + paramah.kZe + "&aid=" + paramah.aid });
          }
        }
        paramString1 = paramah.DZW;
        if (TextUtils.isEmpty(paramString1))
        {
          paramString1 = paramah.uxInfo;
          Log.i("SnsAdUtil", "adLandingJumpWebPageUI, use orig_UxInfo:".concat(String.valueOf(paramString1)));
          localObject = r.kb((String)localObject, paramString1);
          r.h(localIntent, paramString1);
          localObject = com.tencent.mm.plugin.sns.ad.d.a.a.aND((String)localObject);
          Log.i("SnsAdUtil", "open url %s", new Object[] { localObject });
          localIntent.putExtra("rawUrl", (String)localObject);
          localIntent.putExtra("useJs", true);
          localIntent.putExtra("type", -255);
          localIntent.putExtra("geta8key_scene", 2);
          if (paramah.bizId == 0)
          {
            localObject = new SnsAdClick(paramInt, paramLong);
            Bundle localBundle = new Bundle();
            localBundle.putParcelable("KSnsAdTag", (Parcelable)localObject);
            if (!TextUtils.isEmpty(paramString1)) {
              localBundle.putString("KAnsUxInfo", paramString1);
            }
            localIntent.putExtra("jsapiargs", localBundle);
          }
          if (((paramContext instanceof Activity)) && (paramah.bizId == 2))
          {
            paramah = ((Activity)paramContext).getIntent().getStringExtra("sns_landing_pages_sessionId");
            paramString1 = ((Activity)paramContext).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
            if (!Util.isNullOrNil(paramah))
            {
              paramLong = System.currentTimeMillis() / 1000L;
              if (Util.isNullOrNil(paramString1)) {
                break label440;
              }
              paramString1 = String.format("official_mall_%s_%s_%s_%s", new Object[] { paramString1, paramah, paramString2, String.valueOf(paramLong) });
              localIntent.putExtra("prePublishId", paramString1);
              localIntent.putExtra("KPublisherId", paramString1);
              localIntent.putExtra("pay_channel", 47);
            }
          }
          com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
          AppMethodBeat.o(202592);
        }
        else
        {
          Log.i("SnsAdUtil", "adLandingJumpWebPageUI, use updated_UxInfo:".concat(String.valueOf(paramString1)));
          continue;
        }
        paramString1 = "";
      }
      catch (Throwable paramContext)
      {
        Log.e("SnsAdUtil", "adLandingJumpWebPageUI exp=" + paramContext.toString());
        AppMethodBeat.o(202592);
        return;
      }
    }
  }
  
  public static void a(SnsAdClick paramSnsAdClick, com.tencent.mm.plugin.sns.ad.g.k paramk, SnsInfo paramSnsInfo, int paramInt)
  {
    long l2 = 0L;
    AppMethodBeat.i(202597);
    try
    {
      StringBuilder localStringBuilder = new StringBuilder("appendSnsAdClickParams, snsAdStatistic==null?");
      boolean bool;
      if (paramk == null)
      {
        bool = true;
        Log.d("SnsAdUtil", bool + ", clickPos=" + paramInt);
        if (paramk != null) {
          break label91;
        }
        l1 = 0L;
        label59:
        paramSnsAdClick.jlb = l1;
        if (paramk != null) {
          break label105;
        }
      }
      label91:
      label105:
      for (long l1 = l2;; l1 = paramk.IV(paramSnsInfo.field_snsId))
      {
        paramSnsAdClick.jlc = l1;
        AppMethodBeat.o(202597);
        return;
        bool = false;
        break;
        l1 = paramk.fr(paramSnsInfo.getLocalid(), paramInt);
        break label59;
      }
      return;
    }
    catch (Exception paramSnsAdClick)
    {
      Log.e("SnsAdUtil", "appendSnsAdClickParams exp=" + paramSnsAdClick.toString() + ", clockPos=" + paramInt);
      AppMethodBeat.o(202597);
    }
  }
  
  private static boolean a(Context paramContext, SnsInfo paramSnsInfo, ADInfo paramADInfo)
  {
    AppMethodBeat.i(202600);
    if ((paramSnsInfo != null) && (paramADInfo != null)) {}
    for (;;)
    {
      try
      {
        if (paramADInfo.actionExtAppJump != null)
        {
          if (!q.s(paramContext, paramADInfo.actionExtAppJump.LG)) {
            continue;
          }
          Log.i("SnsAdUtil", "checkOpenApp isInstalled=true, " + paramADInfo.actionExtAppJump.toString());
          String str = "";
          if (paramSnsInfo.getAdXml() != null) {
            str = paramSnsInfo.getAdXml().adExtInfo;
          }
          boolean bool = a(paramContext, paramADInfo.actionExtAppJump.appId, paramADInfo.actionExtAppJump.LG, paramADInfo.actionExtAppJump.appName, paramADInfo.actionExtAppJump.appPageUrl, paramADInfo.uxInfo, str, String.valueOf(paramSnsInfo.field_snsId), 2, 0);
          if (bool)
          {
            AppMethodBeat.o(202600);
            return true;
          }
          Log.e("SnsAdUtil", "checkOpenApp failed, " + paramADInfo.actionExtAppJump.toString());
          jZ(paramADInfo.actionExtAppJump.LG, paramADInfo.actionExtAppJump.appPageUrl);
        }
      }
      catch (Throwable paramContext)
      {
        Log.e("SnsAdUtil", "checkOpenApp exp=" + paramContext.toString());
        continue;
      }
      AppMethodBeat.o(202600);
      return false;
      Log.e("SnsAdUtil", "checkOpenApp isInstalled=false, " + paramADInfo.actionExtAppJump.toString());
      jZ(paramADInfo.actionExtAppJump.LG, paramADInfo.actionExtAppJump.appPageUrl);
    }
  }
  
  private static boolean a(Context paramContext, SnsInfo paramSnsInfo, ADInfo paramADInfo, int paramInt)
  {
    AppMethodBeat.i(202602);
    if ((paramContext == null) || (paramSnsInfo == null) || (paramADInfo == null))
    {
      Log.e("SnsAdUtil", "tryProcessAdAppMarket input param is wrong");
      AppMethodBeat.o(202602);
      return false;
    }
    String str3 = "";
    String str4 = "";
    String str2 = "";
    String str1;
    if (paramADInfo.actionExtAppJump != null)
    {
      str1 = paramADInfo.actionExtAppJump.appName;
      str3 = paramADInfo.actionExtAppJump.appId;
      str4 = paramADInfo.actionExtAppJump.appPageUrl;
      str2 = paramADInfo.actionExtAppJump.LG;
    }
    for (;;)
    {
      ADXml localADXml = paramSnsInfo.getAdXml();
      String str5;
      Object localObject;
      if ((localADXml != null) && (localADXml.toAdMarket == 1))
      {
        str5 = localADXml.adExtInfo;
        localObject = localADXml.appMarketIntent;
        if ((!TextUtils.isEmpty(str2)) || (localObject == null)) {
          break label389;
        }
        str2 = IntentUtil.getStringExtra(localADXml.appMarketIntent, "target_app_id");
      }
      label389:
      for (;;)
      {
        if (str2 == null)
        {
          Log.e("SnsAdUtil", "the target package is empty!");
          AppMethodBeat.o(202602);
          return false;
        }
        if (paramInt == 1) {}
        for (int i = 2; q.s(paramContext, str2); i = 0)
        {
          localObject = str1;
          if (TextUtils.isEmpty(str1)) {
            localObject = a.a.by(paramContext, str2);
          }
          a(paramContext, str3, str2, (String)localObject, str4, paramADInfo.uxInfo, str5, String.valueOf(paramSnsInfo.field_snsId), paramInt, i);
          AppMethodBeat.o(202602);
          return true;
        }
        if (com.tencent.mm.plugin.sns.device.appstore.a.aU((Intent)localObject)) {
          b(String.valueOf(paramSnsInfo.field_snsId), paramADInfo.uxInfo, str5, 4, "0");
        }
        for (;;)
        {
          if (!com.tencent.mm.plugin.sns.device.appstore.a.aV((Intent)localObject)) {
            break label354;
          }
          b(String.valueOf(paramSnsInfo.field_snsId), paramADInfo.uxInfo, str5, 1, "0");
          a(paramContext, (Intent)localObject, str2, String.valueOf(paramSnsInfo.field_snsId), paramADInfo.uxInfo, str5, i);
          break;
          b(String.valueOf(paramSnsInfo.field_snsId), paramADInfo.uxInfo, str5, 4, "1");
        }
        label354:
        b(String.valueOf(paramSnsInfo.field_snsId), paramADInfo.uxInfo, str5, 1, "1");
        AppMethodBeat.o(202602);
        return false;
        AppMethodBeat.o(202602);
        return false;
      }
      str1 = "";
    }
  }
  
  public static boolean a(Context paramContext, SnsInfo paramSnsInfo, ADInfo paramADInfo, int paramInt, com.tencent.mm.plugin.sns.ad.g.k paramk)
  {
    int i = 2;
    AppMethodBeat.i(202599);
    if ((paramSnsInfo == null) || (paramADInfo == null))
    {
      AppMethodBeat.o(202599);
      return false;
    }
    try
    {
      if (a(paramContext, paramSnsInfo, paramADInfo))
      {
        Log.i("SnsAdUtil", "handleAdClickAction, checkOpenApp succ");
        if (paramInt == 0) {
          i = 1;
        }
        paramContext = new SnsAdClick(paramInt, i, paramSnsInfo.field_snsId, 22, 34);
        a(paramContext, paramk, paramSnsInfo, 22);
        r.a(paramContext);
        AppMethodBeat.o(202599);
        return true;
      }
      if (a(paramContext, paramSnsInfo, paramADInfo, 2))
      {
        Log.i("SnsAdUtil", "handleAdClickAction, tryProcessAdAppMarket succ");
        if (paramInt == 0) {
          i = 1;
        }
        paramContext = new SnsAdClick(paramInt, i, paramSnsInfo.field_snsId, 22, 36);
        a(paramContext, paramk, paramSnsInfo, 22);
        r.a(paramContext);
        AppMethodBeat.o(202599);
        return true;
      }
      ADXml localADXml = paramSnsInfo.getAdXml();
      if ((localADXml != null) && (localADXml.adScanJumpInfo != null) && (paramADInfo != null) && (paramADInfo.adActionType == 8)) {
        com.tencent.mm.plugin.sns.ad.e.k.a(paramContext, localADXml.adScanJumpInfo, paramADInfo.uxInfo);
      }
      for (int j = 1; j != 0; j = 0)
      {
        Log.i("SnsAdUtil", "handleAdClickAction, checkJumpScan succ");
        if (paramInt == 0) {
          i = 1;
        }
        paramContext = new SnsAdClick(paramInt, i, paramSnsInfo.field_snsId, 22, 35);
        a(paramContext, paramk, paramSnsInfo, 22);
        r.a(paramContext);
        AppMethodBeat.o(202599);
        return true;
      }
      return false;
    }
    catch (Throwable paramContext)
    {
      Log.e("SnsAdUtil", "handleAdClickAction, exp=" + paramContext.toString());
      AppMethodBeat.o(202599);
    }
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202598);
    Log.i("SnsAdUtil", "openApp, appId = " + paramString1 + ", uxInfo = " + paramString5 + ", adExtInfo = " + paramString6 + ", appPageUrl=" + paramString4 + ", pkgName=" + paramString2);
    if ((paramContext == null) || (TextUtils.isEmpty(paramString2)))
    {
      Log.e("SnsAdUtil", "openApp, failed");
      AppMethodBeat.o(202598);
      return false;
    }
    if (paramInt2 != 2) {
      i.a(paramString7, paramString1, 0, 2, paramString5, paramString6, paramInt1);
    }
    if (!TextUtils.isEmpty(paramString4))
    {
      paramString4 = new Intent("android.intent.action.VIEW", Uri.parse(paramString4));
      paramString4.addFlags(268435456);
      paramString2 = Util.queryIntentActivities(paramContext, paramString4);
      if ((paramString2 != null) && (!paramString2.isEmpty())) {
        if ((TextUtils.isEmpty(paramString4.getPackage())) && (paramString2.size() == 1))
        {
          paramString2 = com.tencent.mm.pluginsdk.model.app.h.b((ResolveInfo)paramString2.get(0));
          Log.i("SnsAdUtil", "queryIntentActivities, pkg=".concat(String.valueOf(paramString2)));
          if (Util.nullAsNil(MMApplicationContext.getPackageName()).equals(paramString2)) {
            break label286;
          }
          com.tencent.mm.ch.a.post(new k.1(paramContext, paramString4, paramString3, paramInt2, paramString7, paramString1, paramString5, paramString6, paramInt1));
        }
      }
    }
    for (;;)
    {
      AdLandingPagesProxy.getInstance().reportDownloadInfo(9, paramString1);
      AppMethodBeat.o(202598);
      return true;
      paramString2 = paramString4.getPackage();
      break;
      label286:
      Log.e("SnsAdUtil", "err queryIntent pkg equals mm");
      continue;
      Log.e("SnsAdUtil", "queryIntentActivities, empty");
      continue;
      com.tencent.mm.ch.a.post(new k.2(paramContext, paramString2, paramString3, paramInt2, paramString7, paramString1, paramString5, paramString6, paramInt1));
    }
  }
  
  public static boolean a(SnsInfo paramSnsInfo, int paramInt)
  {
    AppMethodBeat.i(202607);
    if (paramInt == 2) {}
    for (paramSnsInfo = paramSnsInfo.getAtAdInfo(); (paramSnsInfo == null) || (paramSnsInfo.actionExtWeApp == null); paramSnsInfo = paramSnsInfo.getAdInfo())
    {
      AppMethodBeat.o(202607);
      return false;
    }
    if (paramSnsInfo.adActionType != 4)
    {
      AppMethodBeat.o(202607);
      return false;
    }
    if (Util.isNullOrNil(paramSnsInfo.actionExtWeApp.appUserName))
    {
      AppMethodBeat.o(202607);
      return false;
    }
    AppMethodBeat.o(202607);
    return true;
  }
  
  public static boolean a(SnsObject paramSnsObject, String paramString)
  {
    AppMethodBeat.i(202593);
    for (;;)
    {
      try
      {
        Iterator localIterator = paramSnsObject.CommentUserList.iterator();
        if (!localIterator.hasNext()) {
          break label239;
        }
        dzo localdzo = (dzo)localIterator.next();
        if ((localdzo == null) || (Util.isNullOrNil(localdzo.Username)) || (!localdzo.Username.equals(paramString))) {
          continue;
        }
        bool1 = true;
        localIterator = paramSnsObject.LikeUserList.iterator();
        if (localIterator.hasNext())
        {
          localdzo = (dzo)localIterator.next();
          if ((localdzo == null) || (Util.isNullOrNil(localdzo.Username)) || (!localdzo.Username.equals(paramString))) {
            continue;
          }
          bool2 = true;
          Log.i("SnsAdUtil", "isAdCommentOrLikedBySelf, snsId=" + r.Jb(paramSnsObject.Id) + ", hasComment=" + bool1 + ", hasLiked=" + bool2);
          if ((bool1) || (bool2))
          {
            AppMethodBeat.o(202593);
            return true;
          }
          AppMethodBeat.o(202593);
          return false;
        }
      }
      catch (Exception paramSnsObject)
      {
        Log.e("SnsAdUtil", "isAdCommentOrLikedBySelf, exp=" + paramSnsObject.toString());
        AppMethodBeat.o(202593);
        return false;
      }
      boolean bool2 = false;
      continue;
      label239:
      boolean bool1 = false;
    }
  }
  
  public static JSONObject aJ(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(176240);
    localJSONObject = new JSONObject();
    try
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localJSONObject.put(str, paramMap.get(str));
      }
      return localJSONObject;
    }
    catch (Exception paramMap)
    {
      AppMethodBeat.o(176240);
    }
  }
  
  public static long aOa(String paramString)
  {
    AppMethodBeat.i(202594);
    try
    {
      boolean bool = Util.isNullOrNil(paramString);
      if (bool)
      {
        AppMethodBeat.o(202594);
        return 0L;
      }
      if (paramString.startsWith("ad_table_"))
      {
        l = Util.safeParseLong(paramString.substring(9));
        AppMethodBeat.o(202594);
        return l;
      }
      if (paramString.startsWith("sns_table_"))
      {
        l = Util.safeParseLong(paramString.substring(10));
        AppMethodBeat.o(202594);
        return l;
      }
      long l = r.aOw(paramString);
      AppMethodBeat.o(202594);
      return l;
    }
    catch (Throwable paramString)
    {
      Log.e("SnsAdUtil", paramString.toString());
      AppMethodBeat.o(202594);
    }
    return 0L;
  }
  
  public static String aOb(String paramString)
  {
    AppMethodBeat.i(202609);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(202609);
      return "";
    }
    paramString = paramString.split("\\|");
    if ((paramString != null) && (paramString.length > 0))
    {
      paramString = paramString[0];
      AppMethodBeat.o(202609);
      return paramString;
    }
    AppMethodBeat.o(202609);
    return "";
  }
  
  public static s aOc(String paramString)
  {
    AppMethodBeat.i(202610);
    s locals = new s();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        locals.pageId = paramString.optString("canvasId");
        locals.uxInfo = paramString.optString("uxInfo");
        paramString = locals.uxInfo;
        if (!Util.isNullOrNil(paramString)) {
          continue;
        }
        Log.e("SnsAdUtil", "uxInfo is null");
        paramString = "";
        locals.lAP = paramString;
        Log.i("SnsAdUtil", "pageId = " + locals.pageId + ", uxInfo = " + locals.uxInfo + ", adInfoXml = " + locals.lAP);
      }
      catch (Throwable paramString)
      {
        StringBuilder localStringBuilder;
        Log.e("SnsAdUtil", paramString.toString());
        continue;
      }
      AppMethodBeat.o(202610);
      return locals;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("<ADInfo><uxInfo>").append(paramString).append("</uxInfo></ADInfo>");
      paramString = localStringBuilder.toString();
    }
  }
  
  public static boolean aOd(String paramString)
  {
    AppMethodBeat.i(202611);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("<usePreferedInfo>1</usePreferedInfo>")))
    {
      AppMethodBeat.o(202611);
      return true;
    }
    AppMethodBeat.o(202611);
    return false;
  }
  
  public static int aOe(String paramString)
  {
    AppMethodBeat.i(202614);
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = paramString.split("-");
        if ((paramString != null) && (paramString.length > 0))
        {
          int i = Util.safeParseInt(paramString[0]);
          AppMethodBeat.o(202614);
          return i;
        }
      }
    }
    catch (Throwable paramString)
    {
      Log.e("SnsAdUtil", "getRawRequestType, exp=" + paramString.toString());
      AppMethodBeat.o(202614);
    }
    return 0;
  }
  
  public static String aoz()
  {
    AppMethodBeat.i(202606);
    try
    {
      String str = ((TelephonyManager)MMApplicationContext.getContext().getSystemService("phone")).getDeviceId();
      AppMethodBeat.o(202606);
      return str;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(202606);
    }
    return "";
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    AppMethodBeat.i(202604);
    ArrayMap localArrayMap = new ArrayMap();
    localArrayMap.put("outSns", Integer.valueOf(1));
    com.tencent.mm.plugin.sns.device.appstore.a.a(paramString1, paramString2, paramString3, paramInt, paramString4, localArrayMap);
    AppMethodBeat.o(202604);
  }
  
  public static boolean b(Context paramContext, SnsInfo paramSnsInfo, ADInfo paramADInfo)
  {
    AppMethodBeat.i(202601);
    try
    {
      boolean bool = a(paramContext, paramSnsInfo, paramADInfo, 0);
      AppMethodBeat.o(202601);
      return bool;
    }
    catch (Throwable paramContext)
    {
      Log.w("SnsAdUtil", "processAdAppMarket has something wrong");
      AppMethodBeat.o(202601);
    }
    return false;
  }
  
  public static void c(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(202613);
    Log.i("SnsAdUtil", "reportAdPicDownload, result=" + paramInt1 + ", scene=" + paramInt2 + ", downloader=" + paramInt3 + ", imgUrl=" + paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      try
      {
        com.tencent.mm.plugin.report.service.h.CyF.a(21534, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
        if (paramInt2 == 0)
        {
          if (paramInt1 == 0)
          {
            com.tencent.mm.plugin.report.service.h.CyF.dN(1560, 1);
            AppMethodBeat.o(202613);
            return;
          }
          com.tencent.mm.plugin.report.service.h.CyF.dN(1560, 2);
          AppMethodBeat.o(202613);
          return;
        }
      }
      catch (Throwable paramString)
      {
        Log.e("SnsAdUtil", "reportAdPicDownload, exp=" + paramString.toString());
        AppMethodBeat.o(202613);
        return;
      }
      if (paramInt2 == 1)
      {
        if (paramInt1 == 0)
        {
          com.tencent.mm.plugin.report.service.h.CyF.dN(1560, 3);
          AppMethodBeat.o(202613);
          return;
        }
        com.tencent.mm.plugin.report.service.h.CyF.dN(1560, 4);
      }
      AppMethodBeat.o(202613);
      return;
    }
    Log.e("SnsAdUtil", "reportAdPicDownload, url is empty");
    AppMethodBeat.o(202613);
  }
  
  public static boolean d(TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(176239);
    if ((paramTimeLineObject != null) && (paramTimeLineObject.ContentObj != null) && (paramTimeLineObject.ContentObj.LoV != null) && (paramTimeLineObject.ContentObj.LoV.size() > 0))
    {
      paramTimeLineObject = (cnb)paramTimeLineObject.ContentObj.LoV.get(0);
      if ((paramTimeLineObject != null) && (paramTimeLineObject.MsB != null) && (paramTimeLineObject.MsB.Mto > 0.0F) && (paramTimeLineObject.MsB.Mtp > 0.0F))
      {
        int i = (int)paramTimeLineObject.MsB.Mto;
        if ((int)paramTimeLineObject.MsB.Mtp > i)
        {
          AppMethodBeat.o(176239);
          return true;
        }
        AppMethodBeat.o(176239);
        return false;
      }
    }
    AppMethodBeat.o(176239);
    return false;
  }
  
  public static String fg(View paramView)
  {
    AppMethodBeat.i(176242);
    paramView = "[" + paramView.getPaddingLeft() + "," + paramView.getPaddingTop() + "," + paramView.getPaddingRight() + "," + paramView.getPaddingBottom() + "]";
    AppMethodBeat.o(176242);
    return paramView;
  }
  
  public static void it(int paramInt1, int paramInt2)
  {
    int i = 1;
    AppMethodBeat.i(202616);
    if (paramInt1 == 1) {
      if (paramInt2 == 0) {
        paramInt2 = i;
      }
    }
    for (;;)
    {
      try
      {
        Log.d("SnsAdUtil", "reportAdFinderTopicImageDownload scene is " + paramInt1 + ", result is " + paramInt2);
        if (paramInt2 != 0) {
          com.tencent.mm.plugin.report.service.h.CyF.dN(1606, paramInt2);
        }
        AppMethodBeat.o(202616);
        return;
      }
      catch (Throwable localThrowable)
      {
        AppMethodBeat.o(202616);
        return;
      }
      paramInt2 = 2;
      continue;
      if (paramInt1 == 2)
      {
        if (paramInt2 == 0) {
          paramInt2 = 3;
        } else {
          paramInt2 = 4;
        }
      }
      else if (paramInt1 == 3)
      {
        if (paramInt2 == 0) {
          paramInt2 = 5;
        } else {
          paramInt2 = 6;
        }
      }
      else {
        paramInt2 = 0;
      }
    }
  }
  
  public static String jV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(202615);
    str = Util.nullAsNil(paramString1);
    paramString1 = str;
    try
    {
      if (!TextUtils.isEmpty(str))
      {
        paramString1 = str;
        if (!TextUtils.isEmpty(paramString2)) {
          paramString1 = String.format("#%02x%s", new Object[] { Integer.valueOf((int)(Util.safeParseDouble(paramString2) * 255.0D)), str.substring(1) });
        }
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        Log.e("SnsAdUtil", "parseColor exp=" + paramString1.toString());
        paramString1 = str;
      }
    }
    AppMethodBeat.o(202615);
    return paramString1;
  }
  
  public static void jY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(176241);
    try
    {
      if (MMApplicationContext.isMainProcess())
      {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g localg = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g(paramString1, paramString2);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(localg, 0);
        Log.i("SnsAdUtil", "adChannelCgiReport, main, channel=" + paramString1 + ", content=" + paramString2);
        AppMethodBeat.o(176241);
        return;
      }
      if (MMApplicationContext.isToolsProcess())
      {
        AdLandingPagesProxy.getInstance().onAdLandingPageClick(paramString1, paramString2);
        Log.i("SnsAdUtil", "adChannelCgiReport, tools, channel=" + paramString1 + ", content=" + paramString2);
        AppMethodBeat.o(176241);
        return;
      }
    }
    catch (Exception paramString1)
    {
      Log.e("SnsAdUtil", "adChannelCgiReport, exp=" + paramString1.toString());
      AppMethodBeat.o(176241);
      return;
    }
    Log.e("SnsAdUtil", "adChannelCgiReport, process err");
    AppMethodBeat.o(176241);
  }
  
  public static void jZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(202605);
    Log.i("SnsAdUtil", "writeDelayDeepLink, pkg=" + paramString1 + ", pageUrl=" + paramString2);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(202605);
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("wx_ad_pkgname", paramString1);
      localJSONObject.put("wx_ad_deeplink", paramString2);
      ClipboardHelper.setText(MMApplicationContext.getContext(), "wx_ad_deeplink", localJSONObject.toString());
      AppMethodBeat.o(202605);
      return;
    }
    catch (Throwable paramString1)
    {
      Log.e("SnsAdUtil", "writeDelayDeepLink exp=" + paramString1.toString());
      AppMethodBeat.o(202605);
    }
  }
  
  public static String ka(String paramString1, String paramString2)
  {
    AppMethodBeat.i(202612);
    StringBuilder localStringBuilder = new StringBuilder("isChatRoom=");
    if ((paramString2 != null) && ((paramString2.endsWith("@chatroom")) || (paramString2.endsWith("@im.chatroom")))) {
      localStringBuilder.append("1");
    }
    for (;;)
    {
      localStringBuilder.append("&fromUsername=").append(paramString1);
      localStringBuilder.append("&chatName=").append(paramString2);
      paramString1 = localStringBuilder.toString();
      AppMethodBeat.o(202612);
      return paramString1;
      localStringBuilder.append("0");
    }
  }
  
  public static int r(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(202595);
    int m = 0;
    int k = 0;
    i = k;
    if (paramSnsInfo != null)
    {
      i = k;
      j = m;
    }
    for (;;)
    {
      try
      {
        if (paramSnsInfo.isAd())
        {
          j = m;
          paramSnsInfo = paramSnsInfo.getAdXml();
          i = k;
          if (paramSnsInfo != null)
          {
            i = k;
            j = m;
            if (!TextUtils.isEmpty(paramSnsInfo.firstDownloadApkPkgName))
            {
              j = m;
              long l = System.currentTimeMillis();
              j = m;
              if (!q.s(MMApplicationContext.getContext(), paramSnsInfo.firstDownloadApkPkgName)) {
                continue;
              }
              i = 2;
              j = i;
              Log.i("SnsAdUtil", "getAdAppInstallStatus, pkg=" + paramSnsInfo.firstDownloadApkPkgName + ", installState=" + i + ", timeCost=" + (System.currentTimeMillis() - l));
            }
          }
        }
      }
      catch (Throwable paramSnsInfo)
      {
        Log.e("SnsAdUtil", "appInstalled exp=" + paramSnsInfo.toString());
        i = j;
        continue;
      }
      AppMethodBeat.o(202595);
      return i;
      i = 1;
    }
  }
  
  public static int s(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(202596);
    str1 = "";
    try
    {
      str2 = paramSnsInfo.getUserName();
      l = System.currentTimeMillis();
      if ((paramSnsInfo == null) || (!paramSnsInfo.isAd()) || (TextUtils.isEmpty(str2))) {
        break label209;
      }
      com.tencent.mm.kernel.g.aAi();
      paramSnsInfo = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(str2);
      if (paramSnsInfo == null) {
        break label209;
      }
      if ((int)paramSnsInfo.gMZ <= 0) {
        break label204;
      }
      boolean bool = com.tencent.mm.contact.c.oR(paramSnsInfo.field_type);
      if (!bool) {
        break label204;
      }
      i = 2;
    }
    catch (Throwable paramSnsInfo)
    {
      for (;;)
      {
        try
        {
          String str2;
          long l;
          paramSnsInfo = paramSnsInfo.arI();
          j = i;
          Log.i("SnsAdUtil", "getAdUserFollowStatus, userName=" + str2 + ", followStatus=" + i + ", displayName=" + paramSnsInfo + ", timeCost=" + (System.currentTimeMillis() - l));
          AppMethodBeat.o(202596);
          return i;
        }
        catch (Throwable paramSnsInfo)
        {
          int j;
          continue;
        }
        paramSnsInfo = paramSnsInfo;
        j = 1;
        Log.e("SnsAdUtil", "isContact exp=" + paramSnsInfo.toString());
        int i = j;
        continue;
        i = 1;
        continue;
        i = 1;
        paramSnsInfo = str1;
      }
    }
    j = i;
  }
  
  public static boolean t(SnsInfo paramSnsInfo)
  {
    boolean bool = true;
    AppMethodBeat.i(202608);
    if (paramSnsInfo == null)
    {
      AppMethodBeat.o(202608);
      return false;
    }
    try
    {
      ADXml localADXml = paramSnsInfo.getAdXml();
      int i = localADXml.isValidJumpCanvas;
      if (i == 1)
      {
        AppMethodBeat.o(202608);
        return true;
      }
      i = localADXml.isValidJumpCanvas;
      if (i == 0)
      {
        AppMethodBeat.o(202608);
        return false;
      }
      if ((localADXml.isLandingPagesAd()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.aQg(paramSnsInfo.getAdSnsInfo().field_adxml))) {
        if (!bool) {
          break label102;
        }
      }
      label102:
      for (localADXml.isValidJumpCanvas = 1;; localADXml.isValidJumpCanvas = 0)
      {
        AppMethodBeat.o(202608);
        return bool;
        bool = false;
        break;
      }
      return false;
    }
    catch (Throwable paramSnsInfo)
    {
      Log.e("SnsAdUtil", paramSnsInfo.toString());
      AppMethodBeat.o(202608);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.k
 * JD-Core Version:    0.7.0.1
 */