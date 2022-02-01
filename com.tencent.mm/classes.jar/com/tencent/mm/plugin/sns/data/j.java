package com.tencent.mm.plugin.sns.data;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae;
import com.tencent.mm.plugin.sns.storage.a.b;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.byp;
import com.tencent.mm.protocal.protobuf.dfn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bp;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class j
{
  private static void a(Context paramContext, Intent paramIntent, final String paramString1, final String paramString2, final String paramString3, final String paramString4, int paramInt)
  {
    AppMethodBeat.i(197772);
    if ((paramContext == null) || (paramIntent == null))
    {
      ad.e("SnsAdUtil", "startMarketActivity input param is error");
      AppMethodBeat.o(197772);
      return;
    }
    try
    {
      if (!(paramContext instanceof Activity)) {
        paramIntent.addFlags(268435456);
      }
      String str = bt.bI(y.getStringExtra(paramIntent, "market_app_name"), "");
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.am.a(paramContext, paramIntent.getPackage(), "", paramIntent, str, new al()
      {
        public final void v(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
        {
          AppMethodBeat.i(197760);
          if (paramAnonymousBoolean1)
          {
            if (this.val$showType != 2) {
              j.b(paramString2, paramString3, paramString4, 2, "0");
            }
            com.tencent.mm.plugin.sns.device.appstore.e locale = com.tencent.mm.plugin.sns.device.appstore.e.y(paramString1, paramString2, paramString3, paramString4);
            if (locale != null) {
              com.tencent.mm.plugin.sns.device.appstore.d.a(locale);
            }
            AppMethodBeat.o(197760);
            return;
          }
          if (this.val$showType != 2) {
            j.b(paramString2, paramString3, paramString4, 2, "2");
          }
          AppMethodBeat.o(197760);
        }
      }, paramInt);
      AppMethodBeat.o(197772);
      return;
    }
    catch (Throwable paramContext)
    {
      b(paramString2, paramString3, paramString4, 2, "1");
      AppMethodBeat.o(197772);
    }
  }
  
  public static void a(Context paramContext, String paramString1, ae paramae, int paramInt, long paramLong, String paramString2)
  {
    AppMethodBeat.i(197761);
    label433:
    for (;;)
    {
      try
      {
        Intent localIntent = new Intent();
        Object localObject = paramString1;
        if (!TextUtils.isEmpty(paramae.jSR))
        {
          localObject = paramString1;
          if (!TextUtils.isEmpty(paramae.zuP)) {
            localObject = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.am.n(paramString1, new String[] { "traceid=" + paramae.jSR + "&aid=" + paramae.zuP });
          }
        }
        paramString1 = paramae.zAP;
        if (TextUtils.isEmpty(paramString1))
        {
          paramString1 = paramae.dFy;
          ad.i("SnsAdUtil", "adLandingJumpWebPageUI, use orig_UxInfo:".concat(String.valueOf(paramString1)));
          localObject = q.jh((String)localObject, paramString1);
          q.g(localIntent, paramString1);
          ad.i("SnsAdUtil", "open url %s", new Object[] { localObject });
          localIntent.putExtra("rawUrl", (String)localObject);
          localIntent.putExtra("useJs", true);
          localIntent.putExtra("type", -255);
          localIntent.putExtra("geta8key_scene", 2);
          if (paramae.bizId == 0)
          {
            localObject = new SnsAdClick(paramInt, paramLong);
            Bundle localBundle = new Bundle();
            localBundle.putParcelable("KSnsAdTag", (Parcelable)localObject);
            if (!TextUtils.isEmpty(paramString1)) {
              localBundle.putString("KAnsUxInfo", paramString1);
            }
            localIntent.putExtra("jsapiargs", localBundle);
          }
          if (((paramContext instanceof Activity)) && (paramae.bizId == 2))
          {
            paramae = ((Activity)paramContext).getIntent().getStringExtra("sns_landing_pages_sessionId");
            paramString1 = ((Activity)paramContext).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
            if (!bt.isNullOrNil(paramae))
            {
              paramLong = System.currentTimeMillis() / 1000L;
              if (bt.isNullOrNil(paramString1)) {
                break label433;
              }
              paramString1 = String.format("official_mall_%s_%s_%s_%s", new Object[] { paramString1, paramae, paramString2, String.valueOf(paramLong) });
              localIntent.putExtra("prePublishId", paramString1);
              localIntent.putExtra("KPublisherId", paramString1);
              localIntent.putExtra("pay_channel", 47);
            }
          }
          com.tencent.mm.bs.d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
          AppMethodBeat.o(197761);
        }
        else
        {
          ad.i("SnsAdUtil", "adLandingJumpWebPageUI, use updated_UxInfo:".concat(String.valueOf(paramString1)));
          continue;
        }
        paramString1 = "";
      }
      catch (Throwable paramContext)
      {
        ad.e("SnsAdUtil", "adLandingJumpWebPageUI exp=" + paramContext.toString());
        AppMethodBeat.o(197761);
        return;
      }
    }
  }
  
  public static void a(SnsAdClick paramSnsAdClick, com.tencent.mm.plugin.sns.ad.d.i parami, p paramp, int paramInt)
  {
    long l2 = 0L;
    AppMethodBeat.i(197766);
    try
    {
      StringBuilder localStringBuilder = new StringBuilder("appendSnsAdClickParams, snsAdStatistic==null?");
      boolean bool;
      if (parami == null)
      {
        bool = true;
        ad.d("SnsAdUtil", bool + ", clickPos=" + paramInt);
        if (parami != null) {
          break label93;
        }
        l1 = 0L;
        label60:
        paramSnsAdClick.ina = l1;
        if (parami != null) {
          break label107;
        }
      }
      label93:
      label107:
      for (long l1 = l2;; l1 = parami.zr(paramp.field_snsId))
      {
        paramSnsAdClick.inb = l1;
        AppMethodBeat.o(197766);
        return;
        bool = false;
        break;
        l1 = parami.eP(paramp.dYK(), paramInt);
        break label60;
      }
      return;
    }
    catch (Exception paramSnsAdClick)
    {
      ad.e("SnsAdUtil", "appendSnsAdClickParams exp=" + paramSnsAdClick.toString() + ", clockPos=" + paramInt);
      AppMethodBeat.o(197766);
    }
  }
  
  private static boolean a(Context paramContext, p paramp, com.tencent.mm.plugin.sns.storage.a parama)
  {
    AppMethodBeat.i(197769);
    if ((paramp != null) && (parama != null)) {}
    for (;;)
    {
      try
      {
        if (parama.zvc != null)
        {
          if (!com.tencent.mm.pluginsdk.model.app.q.s(paramContext, parama.zvc.Lw)) {
            continue;
          }
          ad.i("SnsAdUtil", "checkOpenApp isInstalled=true, " + parama.zvc.toString());
          String str = "";
          if (paramp.dRL() != null) {
            str = paramp.dRL().zeg;
          }
          boolean bool = a(paramContext, parama.zvc.appId, parama.zvc.Lw, parama.zvc.appName, parama.zvc.zve, parama.dFy, str, String.valueOf(paramp.field_snsId), 2, 0);
          if (bool)
          {
            AppMethodBeat.o(197769);
            return true;
          }
          ad.e("SnsAdUtil", "checkOpenApp failed, " + parama.zvc.toString());
          jg(parama.zvc.Lw, parama.zvc.zve);
        }
      }
      catch (Throwable paramContext)
      {
        ad.e("SnsAdUtil", "checkOpenApp exp=" + paramContext.toString());
        continue;
      }
      AppMethodBeat.o(197769);
      return false;
      ad.e("SnsAdUtil", "checkOpenApp isInstalled=false, " + parama.zvc.toString());
      jg(parama.zvc.Lw, parama.zvc.zve);
    }
  }
  
  private static boolean a(Context paramContext, p paramp, com.tencent.mm.plugin.sns.storage.a parama, int paramInt)
  {
    AppMethodBeat.i(197771);
    if ((paramContext == null) || (paramp == null) || (parama == null))
    {
      ad.e("SnsAdUtil", "tryProcessAdAppMarket input param is wrong");
      AppMethodBeat.o(197771);
      return false;
    }
    String str3 = "";
    String str4 = "";
    String str2 = "";
    String str1;
    if (parama.zvc != null)
    {
      str1 = parama.zvc.appName;
      str3 = parama.zvc.appId;
      str4 = parama.zvc.zve;
      str2 = parama.zvc.Lw;
    }
    for (;;)
    {
      com.tencent.mm.plugin.sns.storage.b localb = paramp.dRL();
      String str5;
      Object localObject;
      if ((localb != null) && (localb.zwA == 1))
      {
        str5 = localb.zeg;
        localObject = localb.zwz;
        if ((!TextUtils.isEmpty(str2)) || (localObject == null)) {
          break label389;
        }
        str2 = y.getStringExtra(localb.zwz, "target_app_id");
      }
      label389:
      for (;;)
      {
        if (str2 == null)
        {
          ad.e("SnsAdUtil", "the target package is empty!");
          AppMethodBeat.o(197771);
          return false;
        }
        if (paramInt == 1) {}
        for (int i = 2; com.tencent.mm.pluginsdk.model.app.q.s(paramContext, str2); i = 0)
        {
          localObject = str1;
          if (TextUtils.isEmpty(str1)) {
            localObject = com.tencent.mm.plugin.sns.a.a.a.bd(paramContext, str2);
          }
          a(paramContext, str3, str2, (String)localObject, str4, parama.dFy, str5, String.valueOf(paramp.field_snsId), paramInt, i);
          AppMethodBeat.o(197771);
          return true;
        }
        if (com.tencent.mm.plugin.sns.device.appstore.a.aJ((Intent)localObject)) {
          b(String.valueOf(paramp.field_snsId), parama.dFy, str5, 4, "0");
        }
        for (;;)
        {
          if (!com.tencent.mm.plugin.sns.device.appstore.a.aK((Intent)localObject)) {
            break label354;
          }
          b(String.valueOf(paramp.field_snsId), parama.dFy, str5, 1, "0");
          a(paramContext, (Intent)localObject, str2, String.valueOf(paramp.field_snsId), parama.dFy, str5, i);
          break;
          b(String.valueOf(paramp.field_snsId), parama.dFy, str5, 4, "1");
        }
        label354:
        b(String.valueOf(paramp.field_snsId), parama.dFy, str5, 1, "1");
        AppMethodBeat.o(197771);
        return false;
        AppMethodBeat.o(197771);
        return false;
      }
      str1 = "";
    }
  }
  
  public static boolean a(Context paramContext, p paramp, com.tencent.mm.plugin.sns.storage.a parama, int paramInt, com.tencent.mm.plugin.sns.ad.d.i parami)
  {
    int i = 2;
    AppMethodBeat.i(197768);
    if ((paramp == null) || (parama == null))
    {
      AppMethodBeat.o(197768);
      return false;
    }
    try
    {
      if (a(paramContext, paramp, parama))
      {
        ad.i("SnsAdUtil", "handleAdClickAction, checkOpenApp succ");
        if (paramInt == 0) {
          i = 1;
        }
        paramContext = new SnsAdClick(paramInt, i, paramp.field_snsId, 22, 34);
        a(paramContext, parami, paramp, 22);
        q.a(paramContext);
        AppMethodBeat.o(197768);
        return true;
      }
      if (a(paramContext, paramp, parama, 2))
      {
        ad.i("SnsAdUtil", "handleAdClickAction, tryProcessAdAppMarket succ");
        if (paramInt == 0) {
          i = 1;
        }
        paramContext = new SnsAdClick(paramInt, i, paramp.field_snsId, 22, 36);
        a(paramContext, parami, paramp, 22);
        q.a(paramContext);
        AppMethodBeat.o(197768);
        return true;
      }
      com.tencent.mm.plugin.sns.storage.b localb = paramp.dRL();
      if ((localb != null) && (localb.zwD != null) && (parama != null) && (parama.zuA == 8)) {
        com.tencent.mm.plugin.sns.ad.b.b.a(paramContext, localb.zwD, parama.dFy);
      }
      for (int j = 1; j != 0; j = 0)
      {
        ad.i("SnsAdUtil", "handleAdClickAction, checkJumpScan succ");
        if (paramInt == 0) {
          i = 1;
        }
        paramContext = new SnsAdClick(paramInt, i, paramp.field_snsId, 22, 35);
        a(paramContext, parami, paramp, 22);
        q.a(paramContext);
        AppMethodBeat.o(197768);
        return true;
      }
      return false;
    }
    catch (Throwable paramContext)
    {
      ad.e("SnsAdUtil", "handleAdClickAction, exp=" + paramContext.toString());
      AppMethodBeat.o(197768);
    }
  }
  
  public static boolean a(Context paramContext, final String paramString1, final String paramString2, final String paramString3, final String paramString4, final String paramString5, final String paramString6, final String paramString7, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(197767);
    ad.i("SnsAdUtil", "openApp, appId = " + paramString1 + ", uxInfo = " + paramString5 + ", adExtInfo = " + paramString6);
    if ((paramContext == null) || (TextUtils.isEmpty(paramString2)))
    {
      ad.e("SnsAdUtil", "openApp, failed");
      AppMethodBeat.o(197767);
      return false;
    }
    if (paramInt2 != 2) {
      h.a(paramString7, paramString1, 0, 2, paramString5, paramString6, paramInt1);
    }
    if (!TextUtils.isEmpty(paramString4))
    {
      paramString4 = new Intent("android.intent.action.VIEW", Uri.parse(paramString4));
      paramString4.addFlags(268435456);
      paramString2 = bt.ac(paramContext, paramString4);
      if ((paramString2 != null) && (!paramString2.isEmpty()))
      {
        if ((!TextUtils.isEmpty(paramString4.getPackage())) || (paramString2.size() != 1)) {
          break label241;
        }
        paramString2 = com.tencent.mm.pluginsdk.model.app.h.b((ResolveInfo)paramString2.get(0));
        if (!bt.nullAsNil(aj.getPackageName()).equals(paramString2)) {
          com.tencent.mm.ci.a.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(197757);
              com.tencent.mm.pluginsdk.model.app.h.a(this.val$context, paramString4, paramString3, paramInt2, new al()
              {
                public final void v(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
                {
                  AppMethodBeat.i(197756);
                  if ((paramAnonymous2Boolean1) && (j.1.this.val$showType != 2)) {
                    h.a(j.1.this.itA, j.1.this.val$appId, 1, 2, j.1.this.zdd, j.1.this.zde, j.1.this.zdf);
                  }
                  if (!paramAnonymous2Boolean1) {
                    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.am.gl(j.1.this.val$context);
                  }
                  AppMethodBeat.o(197756);
                }
              }, null);
              AppMethodBeat.o(197757);
            }
          });
        }
      }
    }
    for (;;)
    {
      AdLandingPagesProxy.getInstance().reportDownloadInfo(9, paramString1);
      AppMethodBeat.o(197767);
      return true;
      label241:
      paramString2 = paramString4.getPackage();
      break;
      com.tencent.mm.ci.a.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(197759);
          Intent localIntent = this.val$context.getPackageManager().getLaunchIntentForPackage(paramString2);
          com.tencent.mm.pluginsdk.model.app.h.a(this.val$context, localIntent, paramString3, paramInt2, new al()
          {
            public final void v(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
            {
              AppMethodBeat.i(197758);
              if ((paramAnonymous2Boolean1) && (j.2.this.val$showType != 2)) {
                h.a(j.2.this.itA, j.2.this.val$appId, 1, 2, j.2.this.zdd, j.2.this.zde, j.2.this.zdf);
              }
              if (!paramAnonymous2Boolean1) {
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.am.gl(j.2.this.val$context);
              }
              AppMethodBeat.o(197758);
            }
          }, null);
          AppMethodBeat.o(197759);
        }
      });
    }
  }
  
  public static boolean a(p paramp, int paramInt)
  {
    AppMethodBeat.i(197776);
    if (paramInt == 2) {}
    for (paramp = paramp.dYi(); (paramp == null) || (paramp.zuS == null); paramp = paramp.dRK())
    {
      AppMethodBeat.o(197776);
      return false;
    }
    if (paramp.zuA != 4)
    {
      AppMethodBeat.o(197776);
      return false;
    }
    if (bt.isNullOrNil(paramp.zuS.dtE))
    {
      AppMethodBeat.o(197776);
      return false;
    }
    AppMethodBeat.o(197776);
    return true;
  }
  
  public static boolean a(SnsObject paramSnsObject, String paramString)
  {
    AppMethodBeat.i(197762);
    for (;;)
    {
      try
      {
        Iterator localIterator = paramSnsObject.CommentUserList.iterator();
        if (!localIterator.hasNext()) {
          break label239;
        }
        dfn localdfn = (dfn)localIterator.next();
        if ((localdfn == null) || (bt.isNullOrNil(localdfn.Username)) || (!localdfn.Username.equals(paramString))) {
          continue;
        }
        bool1 = true;
        localIterator = paramSnsObject.LikeUserList.iterator();
        if (localIterator.hasNext())
        {
          localdfn = (dfn)localIterator.next();
          if ((localdfn == null) || (bt.isNullOrNil(localdfn.Username)) || (!localdfn.Username.equals(paramString))) {
            continue;
          }
          bool2 = true;
          ad.i("SnsAdUtil", "isAdCommentOrLikedBySelf, snsId=" + q.zw(paramSnsObject.Id) + ", hasComment=" + bool1 + ", hasLiked=" + bool2);
          if ((bool1) || (bool2))
          {
            AppMethodBeat.o(197762);
            return true;
          }
          AppMethodBeat.o(197762);
          return false;
        }
      }
      catch (Exception paramSnsObject)
      {
        ad.e("SnsAdUtil", "isAdCommentOrLikedBySelf, exp=" + paramSnsObject.toString());
        AppMethodBeat.o(197762);
        return false;
      }
      boolean bool2 = false;
      continue;
      label239:
      boolean bool1 = false;
    }
  }
  
  public static JSONObject aE(Map<String, Object> paramMap)
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
  
  public static String aar()
  {
    AppMethodBeat.i(197775);
    try
    {
      String str = ((TelephonyManager)aj.getContext().getSystemService("phone")).getDeviceId();
      AppMethodBeat.o(197775);
      return str;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(197775);
    }
    return "";
  }
  
  public static long axN(String paramString)
  {
    AppMethodBeat.i(197763);
    try
    {
      boolean bool = bt.isNullOrNil(paramString);
      if (bool)
      {
        AppMethodBeat.o(197763);
        return 0L;
      }
      if (paramString.startsWith("ad_table_"))
      {
        l = bt.aRf(paramString.substring(9));
        AppMethodBeat.o(197763);
        return l;
      }
      if (paramString.startsWith("sns_table_"))
      {
        l = bt.aRf(paramString.substring(10));
        AppMethodBeat.o(197763);
        return l;
      }
      long l = q.ayi(paramString);
      AppMethodBeat.o(197763);
      return l;
    }
    catch (Throwable paramString)
    {
      ad.e("SnsAdUtil", paramString.toString());
      AppMethodBeat.o(197763);
    }
    return 0L;
  }
  
  public static String axO(String paramString)
  {
    AppMethodBeat.i(197778);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(197778);
      return "";
    }
    paramString = paramString.split("\\|");
    if ((paramString != null) && (paramString.length > 0))
    {
      paramString = paramString[0];
      AppMethodBeat.o(197778);
      return paramString;
    }
    AppMethodBeat.o(197778);
    return "";
  }
  
  public static r axP(String paramString)
  {
    AppMethodBeat.i(197779);
    r localr = new r();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        localr.ktn = paramString.optString("canvasId");
        localr.dFy = paramString.optString("uxInfo");
        paramString = localr.dFy;
        if (!bt.isNullOrNil(paramString)) {
          continue;
        }
        ad.e("SnsAdUtil", "uxInfo is null");
        paramString = "";
        localr.kto = paramString;
        ad.i("SnsAdUtil", "canvasId = " + localr.ktn + ", uxInfo = " + localr.dFy + ", adInfoXml = " + localr.kto);
      }
      catch (Throwable paramString)
      {
        StringBuilder localStringBuilder;
        ad.e("SnsAdUtil", paramString.toString());
        continue;
      }
      AppMethodBeat.o(197779);
      return localr;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("<ADInfo><uxInfo>").append(paramString).append("</uxInfo></ADInfo>");
      paramString = localStringBuilder.toString();
    }
  }
  
  public static boolean axQ(String paramString)
  {
    AppMethodBeat.i(197780);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("<usePreferedInfo>1</usePreferedInfo>")))
    {
      AppMethodBeat.o(197780);
      return true;
    }
    AppMethodBeat.o(197780);
    return false;
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    AppMethodBeat.i(197773);
    ArrayMap localArrayMap = new ArrayMap();
    localArrayMap.put("outSns", Integer.valueOf(1));
    com.tencent.mm.plugin.sns.device.appstore.a.a(paramString1, paramString2, paramString3, paramInt, paramString4, localArrayMap);
    AppMethodBeat.o(197773);
  }
  
  public static boolean b(Context paramContext, p paramp, com.tencent.mm.plugin.sns.storage.a parama)
  {
    AppMethodBeat.i(197770);
    try
    {
      boolean bool = a(paramContext, paramp, parama, 0);
      AppMethodBeat.o(197770);
      return bool;
    }
    catch (Throwable paramContext)
    {
      ad.w("SnsAdUtil", "processAdAppMarket has something wrong");
      AppMethodBeat.o(197770);
    }
    return false;
  }
  
  public static boolean d(TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(176239);
    if ((paramTimeLineObject != null) && (paramTimeLineObject.HAT != null) && (paramTimeLineObject.HAT.GaQ != null) && (paramTimeLineObject.HAT.GaQ.size() > 0))
    {
      paramTimeLineObject = (byn)paramTimeLineObject.HAT.GaQ.get(0);
      if ((paramTimeLineObject != null) && (paramTimeLineObject.GSL != null) && (paramTimeLineObject.GSL.GTz > 0.0F) && (paramTimeLineObject.GSL.GTA > 0.0F))
      {
        int i = (int)paramTimeLineObject.GSL.GTz;
        if ((int)paramTimeLineObject.GSL.GTA > i)
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
  
  public static String eS(View paramView)
  {
    AppMethodBeat.i(176242);
    paramView = "[" + paramView.getPaddingLeft() + "," + paramView.getPaddingTop() + "," + paramView.getPaddingRight() + "," + paramView.getPaddingBottom() + "]";
    AppMethodBeat.o(176242);
    return paramView;
  }
  
  public static int j(p paramp)
  {
    AppMethodBeat.i(197764);
    int m = 0;
    int k = 0;
    i = k;
    if (paramp != null)
    {
      i = k;
      j = m;
    }
    for (;;)
    {
      try
      {
        if (paramp.QM(32))
        {
          j = m;
          paramp = paramp.dRL();
          i = k;
          if (paramp != null)
          {
            i = k;
            j = m;
            if (!TextUtils.isEmpty(paramp.zwy))
            {
              j = m;
              long l = System.currentTimeMillis();
              j = m;
              if (!com.tencent.mm.pluginsdk.model.app.q.s(aj.getContext(), paramp.zwy)) {
                continue;
              }
              i = 2;
              j = i;
              ad.i("SnsAdUtil", "getAdAppInstallStatus, pkg=" + paramp.zwy + ", installState=" + i + ", timeCost=" + (System.currentTimeMillis() - l));
            }
          }
        }
      }
      catch (Throwable paramp)
      {
        ad.e("SnsAdUtil", "appInstalled exp=" + paramp.toString());
        i = j;
        continue;
      }
      AppMethodBeat.o(197764);
      return i;
      i = 1;
    }
  }
  
  public static void jf(String paramString1, String paramString2)
  {
    AppMethodBeat.i(176241);
    try
    {
      if (aj.cmR())
      {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.d locald = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.d(paramString1, paramString2);
        g.ajD();
        g.ajB().gAO.a(locald, 0);
        ad.i("SnsAdUtil", "adChannelCgiReport, main, channel=" + paramString1 + ", content=" + paramString2);
        AppMethodBeat.o(176241);
        return;
      }
      if (aj.fkI())
      {
        AdLandingPagesProxy.getInstance().onAdLandingPageClick(paramString1, paramString2);
        ad.i("SnsAdUtil", "adChannelCgiReport, tools, channel=" + paramString1 + ", content=" + paramString2);
        AppMethodBeat.o(176241);
        return;
      }
    }
    catch (Exception paramString1)
    {
      ad.e("SnsAdUtil", "adChannelCgiReport, exp=" + paramString1.toString());
      AppMethodBeat.o(176241);
      return;
    }
    ad.e("SnsAdUtil", "adChannelCgiReport, process err");
    AppMethodBeat.o(176241);
  }
  
  public static void jg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(197774);
    ad.i("SnsAdUtil", "writeDelayDeepLink, pkg=" + paramString1 + ", pageUrl=" + paramString2);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(197774);
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("wx_ad_pkgname", paramString1);
      localJSONObject.put("wx_ad_deeplink", paramString2);
      ((ClipboardManager)aj.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("wx_ad_deeplink", localJSONObject.toString()));
      AppMethodBeat.o(197774);
      return;
    }
    catch (Throwable paramString1)
    {
      ad.e("SnsAdUtil", "writeDelayDeepLink exp=" + paramString1.toString());
      AppMethodBeat.o(197774);
    }
  }
  
  public static int k(p paramp)
  {
    AppMethodBeat.i(197765);
    str1 = "";
    try
    {
      str2 = paramp.field_userName;
      l = System.currentTimeMillis();
      if ((paramp == null) || (!paramp.QM(32)) || (TextUtils.isEmpty(str2))) {
        break label211;
      }
      g.ajD();
      paramp = ((l)g.ab(l.class)).azp().Bf(str2);
      if (paramp == null) {
        break label211;
      }
      if ((int)paramp.gfj <= 0) {
        break label206;
      }
      boolean bool = com.tencent.mm.o.b.lM(paramp.field_type);
      if (!bool) {
        break label206;
      }
      i = 2;
    }
    catch (Throwable paramp)
    {
      for (;;)
      {
        try
        {
          String str2;
          long l;
          paramp = paramp.adu();
          j = i;
          ad.i("SnsAdUtil", "getAdUserFollowStatus, userName=" + str2 + ", followStatus=" + i + ", displayName=" + paramp + ", timeCost=" + (System.currentTimeMillis() - l));
          AppMethodBeat.o(197765);
          return i;
        }
        catch (Throwable paramp)
        {
          int j;
          continue;
        }
        paramp = paramp;
        j = 1;
        ad.e("SnsAdUtil", "isContact exp=" + paramp.toString());
        int i = j;
        continue;
        i = 1;
        continue;
        i = 1;
        paramp = str1;
      }
    }
    j = i;
  }
  
  public static boolean l(p paramp)
  {
    boolean bool = true;
    AppMethodBeat.i(197777);
    if (paramp == null)
    {
      AppMethodBeat.o(197777);
      return false;
    }
    try
    {
      com.tencent.mm.plugin.sns.storage.b localb = paramp.dRL();
      int i = localb.zwE;
      if (i == 1)
      {
        AppMethodBeat.o(197777);
        return true;
      }
      i = localb.zwE;
      if (i == 0)
      {
        AppMethodBeat.o(197777);
        return false;
      }
      if ((localb.dVU()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.azV(paramp.dYU().field_adxml))) {
        if (!bool) {
          break label102;
        }
      }
      label102:
      for (localb.zwE = 1;; localb.zwE = 0)
      {
        AppMethodBeat.o(197777);
        return bool;
        bool = false;
        break;
      }
      return false;
    }
    catch (Throwable paramp)
    {
      ad.e("SnsAdUtil", paramp.toString());
      AppMethodBeat.o(197777);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.j
 * JD-Core Version:    0.7.0.1
 */