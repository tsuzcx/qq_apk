package com.tencent.mm.plugin.sns.data;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.sns.a.a.a;
import com.tencent.mm.plugin.sns.ad.d.o;
import com.tencent.mm.plugin.sns.device.appstore.e;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADInfo.a;
import com.tencent.mm.plugin.sns.storage.ADInfo.b;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ao;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.cvv;
import com.tencent.mm.protocal.protobuf.ejo;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class m
{
  private static void a(Context paramContext, Intent paramIntent, final String paramString1, final String paramString2, final String paramString3, final String paramString4, int paramInt, final SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(265961);
    if ((paramContext == null) || (paramIntent == null))
    {
      Log.e("SnsAdUtil", "startMarketActivity input param is error");
      AppMethodBeat.o(265961);
      return;
    }
    try
    {
      if (!(paramContext instanceof Activity)) {
        paramIntent.addFlags(268435456);
      }
      String str = Util.nullAs(IntentUtil.getStringExtra(paramIntent, "market_app_name"), "");
      final b localb = new b(paramString3, paramString4, paramSnsInfo.getAid(), paramSnsInfo.getTraceid(), paramSnsInfo.getPid());
      com.tencent.mm.plugin.sns.ad.d.b.a(localb, 1);
      if (paramInt != 2) {
        com.tencent.mm.plugin.sns.ad.d.b.i(localb);
      }
      ao.a(paramContext, paramIntent.getPackage(), "", paramIntent, str, new al()
      {
        public final void y(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
        {
          AppMethodBeat.i(227873);
          if (paramAnonymousBoolean1)
          {
            Object localObject;
            if (this.val$showType != 2)
            {
              m.b(paramString2, paramString3, paramString4, 2, "0");
              localObject = localb;
            }
            try
            {
              c.a locala = new c.a();
              locala.eventId = 4001002;
              locala.uxInfo = ((b)localObject).uxInfo;
              locala.adExtInfo = ((b)localObject).adExtInfo;
              locala.JEE = ((b)localObject).JEE;
              locala.nTp = ((b)localObject).nTp;
              locala.pId = ((b)localObject).pId;
              locala.iVf = 1;
              com.tencent.mm.plugin.sns.ad.i.j.a(locala.fNh());
              com.tencent.mm.plugin.sns.ad.d.b.b(localb, 1);
              localObject = e.a(paramString1, paramString2, paramString3, paramString4, paramSnsInfo);
              if (localObject != null) {
                com.tencent.mm.plugin.sns.device.appstore.d.a((e)localObject);
              }
              AppMethodBeat.o(227873);
              return;
            }
            catch (Throwable localThrowable)
            {
              for (;;)
              {
                Log.e("AdConversionOnlineReportHelper", localThrowable.toString());
              }
            }
          }
          if (this.val$showType != 2) {
            m.b(paramString2, paramString3, paramString4, 2, "2");
          }
          AppMethodBeat.o(227873);
        }
      }, paramInt);
      AppMethodBeat.o(265961);
      return;
    }
    catch (Throwable paramContext)
    {
      b(paramString2, paramString3, paramString4, 2, "1");
      AppMethodBeat.o(265961);
    }
  }
  
  public static void a(Context paramContext, String paramString1, ai paramai, int paramInt, long paramLong, String paramString2)
  {
    AppMethodBeat.i(265945);
    a(paramContext, paramString1, paramai, paramInt, paramLong, paramString2, true);
    AppMethodBeat.o(265945);
  }
  
  public static void a(Context paramContext, String paramString1, ai paramai, int paramInt, long paramLong, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(265947);
    label452:
    label458:
    for (;;)
    {
      try
      {
        Intent localIntent = new Intent();
        if ((TextUtils.isEmpty(paramai.nTp)) || (TextUtils.isEmpty(paramai.aid))) {
          break label458;
        }
        paramString1 = ao.m(paramString1, new String[] { "traceid=" + paramai.nTp + "&aid=" + paramai.aid });
        String str = paramai.fQE();
        if (TextUtils.isEmpty(str))
        {
          str = paramai.uxInfo;
          Log.i("SnsAdUtil", "adLandingJumpWebPageUI, use orig_UxInfo:".concat(String.valueOf(str)));
          Object localObject = paramString1;
          if (paramBoolean)
          {
            localObject = t.kw(paramString1, str);
            t.g(localIntent, str);
          }
          paramString1 = com.tencent.mm.plugin.sns.ad.c.a.a.aYo((String)localObject);
          Log.i("SnsAdUtil", "open url %s", new Object[] { paramString1 });
          localIntent.putExtra("rawUrl", paramString1);
          localIntent.putExtra("useJs", true);
          localIntent.putExtra("type", -255);
          localIntent.putExtra("geta8key_scene", 2);
          if (paramai.bizId == 0)
          {
            paramString1 = new SnsAdClick(paramInt, paramLong);
            localObject = new Bundle();
            ((Bundle)localObject).putParcelable("KSnsAdTag", paramString1);
            if (!TextUtils.isEmpty(str)) {
              ((Bundle)localObject).putString("KAnsUxInfo", str);
            }
            localIntent.putExtra("jsapiargs", (Bundle)localObject);
          }
          if (((paramContext instanceof Activity)) && (paramai.bizId == 2))
          {
            paramai = ((Activity)paramContext).getIntent().getStringExtra("sns_landing_pages_sessionId");
            paramString1 = ((Activity)paramContext).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
            if (!Util.isNullOrNil(paramai))
            {
              paramLong = System.currentTimeMillis() / 1000L;
              if (Util.isNullOrNil(paramString1)) {
                break label452;
              }
              paramString1 = String.format("official_mall_%s_%s_%s_%s", new Object[] { paramString1, paramai, paramString2, String.valueOf(paramLong) });
              localIntent.putExtra("prePublishId", paramString1);
              localIntent.putExtra("KPublisherId", paramString1);
              localIntent.putExtra("pay_channel", 47);
            }
          }
          com.tencent.mm.by.c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
          AppMethodBeat.o(265947);
        }
        else
        {
          Log.i("SnsAdUtil", "adLandingJumpWebPageUI, use updated_UxInfo:".concat(String.valueOf(str)));
          continue;
        }
        paramString1 = "";
      }
      catch (Throwable paramContext)
      {
        Log.e("SnsAdUtil", "adLandingJumpWebPageUI exp=" + paramContext.toString());
        AppMethodBeat.o(265947);
        return;
      }
    }
  }
  
  public static void a(SnsAdClick paramSnsAdClick, com.tencent.mm.plugin.sns.ad.f.l paraml, SnsInfo paramSnsInfo, int paramInt)
  {
    AppMethodBeat.i(265953);
    a(paramSnsAdClick, paraml, paramSnsInfo, paramInt, 0);
    AppMethodBeat.o(265953);
  }
  
  public static void a(SnsAdClick paramSnsAdClick, com.tencent.mm.plugin.sns.ad.f.l paraml, SnsInfo paramSnsInfo, int paramInt1, int paramInt2)
  {
    long l2 = 0L;
    AppMethodBeat.i(265955);
    try
    {
      StringBuilder localStringBuilder = new StringBuilder("appendSnsAdClickParams, snsAdStatistic==null?");
      boolean bool;
      if (paraml == null)
      {
        bool = true;
        Log.d("SnsAdUtil", bool + ", clickPos=" + paramInt1);
        if (paraml != null) {
          break label99;
        }
        l1 = 0L;
        label60:
        paramSnsAdClick.mbc = l1;
        if (paraml != null) {
          break label113;
        }
      }
      label99:
      label113:
      for (long l1 = l2;; l1 = paraml.Qo(paramSnsInfo.field_snsId))
      {
        paramSnsAdClick.mbd = l1;
        paramSnsAdClick.mbe = paramInt2;
        AppMethodBeat.o(265955);
        return;
        bool = false;
        break;
        l1 = paraml.fT(paramSnsInfo.getLocalid(), paramInt1);
        break label60;
      }
      return;
    }
    catch (Exception paramSnsAdClick)
    {
      Log.e("SnsAdUtil", "appendSnsAdClickParams exp=" + paramSnsAdClick.toString() + ", clockPos=" + paramInt1);
      AppMethodBeat.o(265955);
    }
  }
  
  private static boolean a(Context paramContext, SnsInfo paramSnsInfo, ADInfo paramADInfo)
  {
    AppMethodBeat.i(265958);
    if ((paramSnsInfo != null) && (paramADInfo != null)) {}
    for (;;)
    {
      try
      {
        if (paramADInfo.actionExtAppJump != null)
        {
          if (!q.u(paramContext, paramADInfo.actionExtAppJump.abY)) {
            continue;
          }
          Log.i("SnsAdUtil", "checkOpenApp isInstalled=true, " + paramADInfo.actionExtAppJump.toString());
          String str = "";
          if (paramSnsInfo.getAdXml() != null) {
            str = paramSnsInfo.getAdXml().adExtInfo;
          }
          com.tencent.mm.plugin.sns.ad.f.j localj = new com.tencent.mm.plugin.sns.ad.f.j(paramSnsInfo.getAid(), paramSnsInfo.getTraceid(), paramSnsInfo.getPid());
          boolean bool = a(paramContext, paramADInfo.actionExtAppJump.appId, paramADInfo.actionExtAppJump.abY, paramADInfo.actionExtAppJump.appName, paramADInfo.actionExtAppJump.JxO, paramADInfo.uxInfo, str, String.valueOf(paramSnsInfo.field_snsId), 2, 0, localj);
          com.tencent.mm.plugin.sns.ad.d.b.a(true, paramSnsInfo);
          if (bool)
          {
            AppMethodBeat.o(265958);
            return true;
          }
          Log.e("SnsAdUtil", "checkOpenApp failed, " + paramADInfo.actionExtAppJump.toString());
          com.tencent.mm.plugin.sns.ad.d.a.kl(paramADInfo.actionExtAppJump.abY, paramADInfo.actionExtAppJump.JxO);
        }
      }
      catch (Throwable paramContext)
      {
        Log.e("SnsAdUtil", "checkOpenApp exp=" + paramContext.toString());
        continue;
      }
      AppMethodBeat.o(265958);
      return false;
      Log.e("SnsAdUtil", "checkOpenApp isInstalled=false, " + paramADInfo.actionExtAppJump.toString());
      com.tencent.mm.plugin.sns.ad.d.a.kl(paramADInfo.actionExtAppJump.abY, paramADInfo.actionExtAppJump.JxO);
    }
  }
  
  private static boolean a(Context paramContext, SnsInfo paramSnsInfo, ADInfo paramADInfo, int paramInt)
  {
    AppMethodBeat.i(265960);
    if ((paramContext == null) || (paramSnsInfo == null) || (paramADInfo == null))
    {
      Log.e("SnsAdUtil", "tryProcessAdAppMarket input param is wrong");
      AppMethodBeat.o(265960);
      return false;
    }
    String str2 = "";
    String str3 = "";
    String str1 = "";
    Object localObject1;
    if (paramADInfo.actionExtAppJump != null)
    {
      localObject1 = paramADInfo.actionExtAppJump.appName;
      str2 = paramADInfo.actionExtAppJump.appId;
      str3 = paramADInfo.actionExtAppJump.JxO;
      str1 = paramADInfo.actionExtAppJump.abY;
    }
    for (;;)
    {
      ADXml localADXml = paramSnsInfo.getAdXml();
      String str4;
      Object localObject2;
      if ((localADXml != null) && (localADXml.toAdMarket == 1))
      {
        str4 = localADXml.adExtInfo;
        localObject2 = localADXml.appMarketIntent;
        if ((!TextUtils.isEmpty(str1)) || (localObject2 == null)) {
          break label423;
        }
        str1 = IntentUtil.getStringExtra(localADXml.appMarketIntent, "target_app_id");
      }
      label388:
      label423:
      for (;;)
      {
        if (str1 == null)
        {
          Log.e("SnsAdUtil", "the target package is empty!");
          AppMethodBeat.o(265960);
          return false;
        }
        if (paramInt == 1) {}
        for (int i = 2; q.u(paramContext, str1); i = 0)
        {
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = a.a.bM(paramContext, str1);
          }
          com.tencent.mm.plugin.sns.ad.d.b.a(true, paramSnsInfo);
          localObject1 = new com.tencent.mm.plugin.sns.ad.f.j(paramSnsInfo.getAid(), paramSnsInfo.getTraceid(), paramSnsInfo.getPid());
          a(paramContext, str2, str1, (String)localObject2, str3, paramADInfo.uxInfo, str4, String.valueOf(paramSnsInfo.field_snsId), paramInt, i, (com.tencent.mm.plugin.sns.ad.f.j)localObject1);
          AppMethodBeat.o(265960);
          return true;
        }
        if (com.tencent.mm.plugin.sns.device.appstore.a.aU((Intent)localObject2)) {
          b(String.valueOf(paramSnsInfo.field_snsId), paramADInfo.uxInfo, str4, 4, "0");
        }
        for (;;)
        {
          if (!com.tencent.mm.plugin.sns.device.appstore.a.aV((Intent)localObject2)) {
            break label388;
          }
          b(String.valueOf(paramSnsInfo.field_snsId), paramADInfo.uxInfo, str4, 1, "0");
          com.tencent.mm.plugin.sns.ad.d.b.a(false, paramSnsInfo);
          a(paramContext, (Intent)localObject2, str1, String.valueOf(paramSnsInfo.field_snsId), paramADInfo.uxInfo, str4, i, paramSnsInfo);
          break;
          b(String.valueOf(paramSnsInfo.field_snsId), paramADInfo.uxInfo, str4, 4, "1");
        }
        b(String.valueOf(paramSnsInfo.field_snsId), paramADInfo.uxInfo, str4, 1, "1");
        AppMethodBeat.o(265960);
        return false;
        AppMethodBeat.o(265960);
        return false;
      }
      localObject1 = "";
    }
  }
  
  public static boolean a(Context paramContext, SnsInfo paramSnsInfo, ADInfo paramADInfo, int paramInt, com.tencent.mm.plugin.sns.ad.f.l paraml)
  {
    int i = 2;
    AppMethodBeat.i(265957);
    if ((paramSnsInfo == null) || (paramADInfo == null))
    {
      AppMethodBeat.o(265957);
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
        a(paramContext, paraml, paramSnsInfo, 22);
        t.a(paramContext);
        AppMethodBeat.o(265957);
        return true;
      }
      if (a(paramContext, paramSnsInfo, paramADInfo, 2))
      {
        Log.i("SnsAdUtil", "handleAdClickAction, tryProcessAdAppMarket succ");
        if (paramInt == 0) {
          i = 1;
        }
        paramContext = new SnsAdClick(paramInt, i, paramSnsInfo.field_snsId, 22, 36);
        a(paramContext, paraml, paramSnsInfo, 22);
        t.a(paramContext);
        AppMethodBeat.o(265957);
        return true;
      }
      com.tencent.mm.plugin.sns.ad.d.b.a(false, paramSnsInfo);
      ADXml localADXml = paramSnsInfo.getAdXml();
      if ((localADXml != null) && (localADXml.adScanJumpInfo != null) && (paramADInfo != null) && (paramADInfo.adActionType == 8)) {
        o.a(paramContext, localADXml.adScanJumpInfo, paramADInfo.uxInfo);
      }
      for (int j = 1; j != 0; j = 0)
      {
        Log.i("SnsAdUtil", "handleAdClickAction, checkJumpScan succ");
        if (paramInt == 0) {
          i = 1;
        }
        paramContext = new SnsAdClick(paramInt, i, paramSnsInfo.field_snsId, 22, 35);
        a(paramContext, paraml, paramSnsInfo, 22);
        t.a(paramContext);
        AppMethodBeat.o(265957);
        return true;
      }
      if (com.tencent.mm.plugin.sns.ad.d.l.a(paramContext, paramSnsInfo.getAdXml(), paramADInfo, paramSnsInfo.field_snsId))
      {
        if (paramInt == 0) {
          i = 1;
        }
        paramContext = new SnsAdClick(paramInt, i, paramSnsInfo.field_snsId, 22, 37);
        a(paramContext, paraml, paramSnsInfo, 22);
        t.a(paramContext);
        AppMethodBeat.o(265957);
        return true;
      }
    }
    catch (Throwable paramContext)
    {
      Log.e("SnsAdUtil", "handleAdClickAction, exp=" + paramContext.toString());
      AppMethodBeat.o(265957);
    }
    return false;
  }
  
  public static boolean a(final Context paramContext, final String paramString1, final String paramString2, final String paramString3, String paramString4, final String paramString5, final String paramString6, final String paramString7, final int paramInt1, final int paramInt2, final com.tencent.mm.plugin.sns.ad.f.j paramj)
  {
    AppMethodBeat.i(265956);
    Log.i("SnsAdUtil", "openApp, appId = " + paramString1 + ", uxInfo = " + paramString5 + ", adExtInfo = " + paramString6 + ", appPageUrl=" + paramString4 + ", pkgName=" + paramString2);
    if ((paramContext == null) || (TextUtils.isEmpty(paramString2)))
    {
      Log.e("SnsAdUtil", "openApp, failed");
      AppMethodBeat.o(265956);
      return false;
    }
    if (paramInt2 != 2) {
      k.a(paramString7, paramString1, 0, 2, paramString5, paramString6, paramInt1);
    }
    final Intent localIntent;
    if (!TextUtils.isEmpty(paramString4))
    {
      localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString4));
      localIntent.addFlags(268435456);
      paramString4 = Util.queryIntentActivities(paramContext, localIntent);
      if ((paramString4 != null) && (!paramString4.isEmpty())) {
        if ((TextUtils.isEmpty(localIntent.getPackage())) && (paramString4.size() == 1))
        {
          paramString4 = com.tencent.mm.pluginsdk.model.app.h.b((ResolveInfo)paramString4.get(0));
          Log.i("SnsAdUtil", "queryIntentActivities, pkg=".concat(String.valueOf(paramString4)));
          if (Util.nullAsNil(MMApplicationContext.getPackageName()).equals(paramString4)) {
            break label298;
          }
          com.tencent.mm.co.a.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(225513);
              final b localb = new b(this.JAp, paramj.owd, paramj.enterScene, paramString6, paramj.JEE, paramj.nTp, paramj.pId);
              try
              {
                locala = new c.a();
                locala.eventId = 4002001;
                locala.uxInfo = localb.uxInfo;
                locala.owd = localb.owd;
                locala.enterScene = localb.enterScene;
                locala.adExtInfo = localb.adExtInfo;
                locala.JEE = localb.JEE;
                locala.nTp = localb.nTp;
                locala.pId = localb.pId;
                locala.JPR = 1;
                locala.JPS = 1;
                com.tencent.mm.plugin.sns.ad.i.j.a(locala.fNh());
                if (paramInt2 == 2) {}
              }
              catch (Throwable localThrowable1)
              {
                try
                {
                  c.a locala = new c.a();
                  locala.eventId = 4002007;
                  locala.uxInfo = localb.uxInfo;
                  locala.owd = localb.owd;
                  locala.enterScene = localb.enterScene;
                  locala.adExtInfo = localb.adExtInfo;
                  locala.JEE = localb.JEE;
                  locala.nTp = localb.nTp;
                  locala.pId = localb.pId;
                  locala.JPR = 1;
                  locala.JPS = 1;
                  com.tencent.mm.plugin.sns.ad.i.j.a(locala.fNh());
                  com.tencent.mm.pluginsdk.model.app.h.a(paramContext, localIntent, paramString3, paramInt2, new al()
                  {
                    public final void y(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
                    {
                      AppMethodBeat.i(268798);
                      Log.i("SnsAdUtil", "appPageUrl!=null, onLaunchApp=" + paramAnonymous2Boolean1 + ", launchCancel=" + paramAnonymous2Boolean2);
                      b localb;
                      if (paramAnonymous2Boolean1) {
                        if (m.1.this.val$showType != 2)
                        {
                          k.a(m.1.this.mhm, m.1.this.val$appId, 1, 2, m.1.this.JAp, m.1.this.JAq, m.1.this.JQY);
                          localb = localb;
                        }
                      }
                      try
                      {
                        locala = new c.a();
                        locala.eventId = 4002009;
                        locala.uxInfo = localb.uxInfo;
                        locala.owd = localb.owd;
                        locala.enterScene = localb.enterScene;
                        locala.adExtInfo = localb.adExtInfo;
                        locala.JEE = localb.JEE;
                        locala.nTp = localb.nTp;
                        locala.pId = localb.pId;
                        locala.JPR = 1;
                        locala.JPS = 1;
                        com.tencent.mm.plugin.sns.ad.i.j.a(locala.fNh());
                        localb = localb;
                      }
                      catch (Throwable localThrowable1)
                      {
                        try
                        {
                          c.a locala = new c.a();
                          locala.eventId = 4002011;
                          locala.uxInfo = localb.uxInfo;
                          locala.owd = localb.owd;
                          locala.enterScene = localb.enterScene;
                          locala.adExtInfo = localb.adExtInfo;
                          locala.JEE = localb.JEE;
                          locala.nTp = localb.nTp;
                          locala.pId = localb.pId;
                          locala.JPR = 1;
                          locala.JPS = 1;
                          com.tencent.mm.plugin.sns.ad.i.j.a(locala.fNh());
                          if (!paramAnonymous2Boolean1) {
                            ao.ic(m.1.this.val$context);
                          }
                          AppMethodBeat.o(268798);
                          return;
                          localThrowable1 = localThrowable1;
                          Log.e("AdConversionOnlineReportHelper", localThrowable1.toString());
                        }
                        catch (Throwable localThrowable2)
                        {
                          for (;;)
                          {
                            Log.e("AdConversionOnlineReportHelper", localThrowable2.toString());
                          }
                        }
                      }
                    }
                  }, null);
                  AppMethodBeat.o(225513);
                  return;
                  localThrowable1 = localThrowable1;
                  Log.e("AdConversionOnlineReportHelper", localThrowable1.toString());
                }
                catch (Throwable localThrowable2)
                {
                  for (;;)
                  {
                    Log.e("AdConversionOnlineReportHelper", localThrowable2.toString());
                  }
                }
              }
            }
          });
        }
      }
    }
    for (;;)
    {
      AdLandingPagesProxy.getInstance().reportOpenAppInfo(9, paramString1, paramString2);
      AppMethodBeat.o(265956);
      return true;
      paramString4 = localIntent.getPackage();
      break;
      label298:
      Log.e("SnsAdUtil", "err queryIntent pkg equals mm");
      continue;
      Log.e("SnsAdUtil", "queryIntentActivities, empty");
      continue;
      com.tencent.mm.co.a.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(269077);
          Intent localIntent = this.val$context.getPackageManager().getLaunchIntentForPackage(paramString2);
          com.tencent.mm.pluginsdk.model.app.h.a(this.val$context, localIntent, paramString3, paramInt2, new al()
          {
            public final void y(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
            {
              AppMethodBeat.i(270060);
              Log.i("SnsAdUtil", "onLaunchApp=" + paramAnonymous2Boolean1 + ", launchCancel=" + paramAnonymous2Boolean2);
              if ((paramAnonymous2Boolean1) && (m.2.this.val$showType != 2)) {
                k.a(m.2.this.mhm, m.2.this.val$appId, 1, 2, m.2.this.JAp, m.2.this.JAq, m.2.this.JQY);
              }
              if (!paramAnonymous2Boolean1) {
                ao.ic(m.2.this.val$context);
              }
              AppMethodBeat.o(270060);
            }
          }, null);
          AppMethodBeat.o(269077);
        }
      });
    }
  }
  
  public static boolean a(SnsObject paramSnsObject, String paramString)
  {
    AppMethodBeat.i(265948);
    for (;;)
    {
      try
      {
        Iterator localIterator = paramSnsObject.CommentUserList.iterator();
        if (!localIterator.hasNext()) {
          break label239;
        }
        ejo localejo = (ejo)localIterator.next();
        if ((localejo == null) || (Util.isNullOrNil(localejo.Username)) || (!localejo.Username.equals(paramString))) {
          continue;
        }
        bool1 = true;
        localIterator = paramSnsObject.LikeUserList.iterator();
        if (localIterator.hasNext())
        {
          localejo = (ejo)localIterator.next();
          if ((localejo == null) || (Util.isNullOrNil(localejo.Username)) || (!localejo.Username.equals(paramString))) {
            continue;
          }
          bool2 = true;
          Log.i("SnsAdUtil", "isAdCommentOrLikedBySelf, snsId=" + t.Qu(paramSnsObject.Id) + ", hasComment=" + bool1 + ", hasLiked=" + bool2);
          if ((bool1) || (bool2))
          {
            AppMethodBeat.o(265948);
            return true;
          }
          AppMethodBeat.o(265948);
          return false;
        }
      }
      catch (Exception paramSnsObject)
      {
        Log.e("SnsAdUtil", "isAdCommentOrLikedBySelf, exp=" + paramSnsObject.toString());
        AppMethodBeat.o(265948);
        return false;
      }
      boolean bool2 = false;
      continue;
      label239:
      boolean bool1 = false;
    }
  }
  
  public static JSONObject aD(Map<String, Object> paramMap)
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
  
  public static long aYS(String paramString)
  {
    AppMethodBeat.i(265949);
    try
    {
      boolean bool = Util.isNullOrNil(paramString);
      if (bool)
      {
        AppMethodBeat.o(265949);
        return 0L;
      }
      if (paramString.startsWith("ad_table_"))
      {
        l = Util.safeParseLong(paramString.substring(9));
        AppMethodBeat.o(265949);
        return l;
      }
      if (paramString.startsWith("sns_table_"))
      {
        l = Util.safeParseLong(paramString.substring(10));
        AppMethodBeat.o(265949);
        return l;
      }
      long l = t.aZs(paramString);
      AppMethodBeat.o(265949);
      return l;
    }
    catch (Throwable paramString)
    {
      Log.e("SnsAdUtil", paramString.toString());
      AppMethodBeat.o(265949);
    }
    return 0L;
  }
  
  public static String aYT(String paramString)
  {
    AppMethodBeat.i(265966);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(265966);
      return "";
    }
    paramString = paramString.split("\\|");
    if ((paramString != null) && (paramString.length > 0))
    {
      paramString = paramString[0];
      AppMethodBeat.o(265966);
      return paramString;
    }
    AppMethodBeat.o(265966);
    return "";
  }
  
  public static u aYU(String paramString)
  {
    AppMethodBeat.i(265967);
    u localu = new u();
    try
    {
      paramString = new JSONObject(paramString);
      localu.pageId = paramString.optString("canvasId");
      localu.uxInfo = paramString.optString("uxInfo");
      localu.owf = aYm(localu.uxInfo);
      Log.i("SnsAdUtil", "pageId = " + localu.pageId + ", uxInfo = " + localu.uxInfo + ", adInfoXml = " + localu.owf);
      AppMethodBeat.o(265967);
      return localu;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        Log.e("SnsAdUtil", paramString.toString());
      }
    }
  }
  
  public static boolean aYV(String paramString)
  {
    AppMethodBeat.i(265969);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("<usePreferedInfo>1</usePreferedInfo>")))
    {
      AppMethodBeat.o(265969);
      return true;
    }
    AppMethodBeat.o(265969);
    return false;
  }
  
  public static int aYW(String paramString)
  {
    AppMethodBeat.i(265972);
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = paramString.split("-");
        if ((paramString != null) && (paramString.length > 0))
        {
          int i = Util.safeParseInt(paramString[0]);
          AppMethodBeat.o(265972);
          return i;
        }
      }
    }
    catch (Throwable paramString)
    {
      Log.e("SnsAdUtil", "getRawRequestType, exp=" + paramString.toString());
      AppMethodBeat.o(265972);
    }
    return 0;
  }
  
  public static String aYX(String paramString)
  {
    AppMethodBeat.i(265976);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(265976);
      return "";
    }
    try
    {
      paramString = Util.nullAsNil(paramString.split("\\|")[0]);
      AppMethodBeat.o(265976);
      return paramString;
    }
    catch (Throwable paramString)
    {
      Log.e("SnsAdUtil", paramString.toString());
      AppMethodBeat.o(265976);
    }
    return "";
  }
  
  public static String aYY(String paramString)
  {
    AppMethodBeat.i(265977);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(265977);
      return "";
    }
    try
    {
      paramString = Util.nullAsNil(paramString.split("\\|")[1]);
      AppMethodBeat.o(265977);
      return paramString;
    }
    catch (Throwable paramString)
    {
      Log.e("SnsAdUtil", paramString.toString());
      AppMethodBeat.o(265977);
    }
    return "";
  }
  
  public static String aYZ(String paramString)
  {
    AppMethodBeat.i(265978);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(265978);
      return "";
    }
    try
    {
      paramString = Util.nullAsNil(paramString.split("\\|")[7]);
      AppMethodBeat.o(265978);
      return paramString;
    }
    catch (Throwable paramString)
    {
      Log.e("SnsAdUtil", paramString.toString());
      AppMethodBeat.o(265978);
    }
    return "";
  }
  
  public static String aYm(String paramString)
  {
    AppMethodBeat.i(265968);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("SnsAdUtil", "uxInfo is null");
      AppMethodBeat.o(265968);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<ADInfo><uxInfo>").append(paramString).append("</uxInfo></ADInfo>");
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(265968);
    return paramString;
  }
  
  public static String aZa(String paramString)
  {
    AppMethodBeat.i(265979);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(265979);
      return "";
    }
    try
    {
      Log.i("SnsAdUtil", "getUxinfoFromAdInfoXml, xml=".concat(String.valueOf(paramString)));
      paramString = XmlParser.parseXml(paramString, "ADInfo", null);
      if (paramString != null)
      {
        paramString = Util.nullAs((String)paramString.get(".ADInfo.uxInfo"), "");
        AppMethodBeat.o(265979);
        return paramString;
      }
    }
    catch (Throwable paramString)
    {
      Log.e("SnsAdUtil", "getUxinfoFromAdInfoXml, exp=" + paramString.toString());
      AppMethodBeat.o(265979);
    }
    return "";
  }
  
  public static boolean afz(int paramInt)
  {
    return (paramInt == 14) || (paramInt == 27) || (paramInt == 28) || (paramInt == 29) || (paramInt == 30) || (paramInt == 31);
  }
  
  public static HashSet<String> b(SnsObject paramSnsObject)
  {
    AppMethodBeat.i(265984);
    HashSet localHashSet = new HashSet();
    if (paramSnsObject == null)
    {
      AppMethodBeat.o(265984);
      return localHashSet;
    }
    paramSnsObject = paramSnsObject.LikeUserList.iterator();
    if (paramSnsObject != null) {
      while (paramSnsObject.hasNext()) {
        localHashSet.add(Util.nullAsNil(((ejo)paramSnsObject.next()).Username));
      }
    }
    AppMethodBeat.o(265984);
    return localHashSet;
  }
  
  public static HashSet<String> b(HashSet<String> paramHashSet1, HashSet<String> paramHashSet2)
  {
    AppMethodBeat.i(265986);
    HashSet localHashSet = new HashSet();
    if (!com.tencent.mm.plugin.sns.ad.i.d.isEmpty(paramHashSet1)) {
      localHashSet.addAll(paramHashSet1);
    }
    if (!com.tencent.mm.plugin.sns.ad.i.d.isEmpty(paramHashSet2)) {
      localHashSet.addAll(paramHashSet2);
    }
    AppMethodBeat.o(265986);
    return localHashSet;
  }
  
  public static void b(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(265971);
    Log.i("SnsAdUtil", "reportAdPicDownload, result=" + paramInt1 + ", scene=" + paramInt2 + ", downloader=" + paramInt3 + ", imgUrl=" + paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      try
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(21534, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
        if (paramInt2 == 0)
        {
          if (paramInt1 == 0)
          {
            com.tencent.mm.plugin.report.service.h.IzE.el(1560, 1);
            AppMethodBeat.o(265971);
            return;
          }
          com.tencent.mm.plugin.report.service.h.IzE.el(1560, 2);
          AppMethodBeat.o(265971);
          return;
        }
      }
      catch (Throwable paramString)
      {
        Log.e("SnsAdUtil", "reportAdPicDownload, exp=" + paramString.toString());
        AppMethodBeat.o(265971);
        return;
      }
      if (paramInt2 == 1)
      {
        if (paramInt1 == 0)
        {
          com.tencent.mm.plugin.report.service.h.IzE.el(1560, 3);
          AppMethodBeat.o(265971);
          return;
        }
        com.tencent.mm.plugin.report.service.h.IzE.el(1560, 4);
      }
      AppMethodBeat.o(265971);
      return;
    }
    Log.e("SnsAdUtil", "reportAdPicDownload, url is empty");
    AppMethodBeat.o(265971);
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    AppMethodBeat.i(265962);
    ArrayMap localArrayMap = new ArrayMap();
    localArrayMap.put("outSns", Integer.valueOf(1));
    com.tencent.mm.plugin.sns.device.appstore.a.a(paramString1, paramString2, paramString3, paramInt, paramString4, localArrayMap);
    AppMethodBeat.o(265962);
  }
  
  public static boolean b(Context paramContext, SnsInfo paramSnsInfo, ADInfo paramADInfo)
  {
    AppMethodBeat.i(265959);
    try
    {
      boolean bool = a(paramContext, paramSnsInfo, paramADInfo, 0);
      AppMethodBeat.o(265959);
      return bool;
    }
    catch (Throwable paramContext)
    {
      Log.w("SnsAdUtil", "processAdAppMarket has something wrong");
      AppMethodBeat.o(265959);
    }
    return false;
  }
  
  public static boolean b(SnsInfo paramSnsInfo, int paramInt)
  {
    AppMethodBeat.i(265964);
    if (paramInt == 2) {}
    for (paramSnsInfo = paramSnsInfo.getAtAdInfo(); (paramSnsInfo == null) || (paramSnsInfo.actionExtWeApp == null); paramSnsInfo = paramSnsInfo.getAdInfo())
    {
      AppMethodBeat.o(265964);
      return false;
    }
    if (paramSnsInfo.adActionType != 4)
    {
      AppMethodBeat.o(265964);
      return false;
    }
    if (Util.isNullOrNil(paramSnsInfo.actionExtWeApp.appUserName))
    {
      AppMethodBeat.o(265964);
      return false;
    }
    AppMethodBeat.o(265964);
    return true;
  }
  
  public static HashSet<String> c(SnsObject paramSnsObject)
  {
    AppMethodBeat.i(265985);
    HashSet localHashSet = new HashSet();
    if (paramSnsObject == null)
    {
      AppMethodBeat.o(265985);
      return localHashSet;
    }
    paramSnsObject = paramSnsObject.CommentUserList.iterator();
    if (paramSnsObject != null) {
      while (paramSnsObject.hasNext()) {
        localHashSet.add(Util.nullAsNil(((ejo)paramSnsObject.next()).Username));
      }
    }
    AppMethodBeat.o(265985);
    return localHashSet;
  }
  
  public static boolean d(TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(176239);
    if ((paramTimeLineObject != null) && (paramTimeLineObject.ContentObj != null) && (paramTimeLineObject.ContentObj.Sqr != null) && (paramTimeLineObject.ContentObj.Sqr.size() > 0))
    {
      paramTimeLineObject = (cvt)paramTimeLineObject.ContentObj.Sqr.get(0);
      if ((paramTimeLineObject != null) && (paramTimeLineObject.TDH != null) && (paramTimeLineObject.TDH.TEu > 0.0F) && (paramTimeLineObject.TDH.TEv > 0.0F))
      {
        int i = (int)paramTimeLineObject.TDH.TEu;
        if ((int)paramTimeLineObject.TDH.TEv > i)
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
  
  public static String gn(View paramView)
  {
    AppMethodBeat.i(176242);
    paramView = "[" + paramView.getPaddingLeft() + "," + paramView.getPaddingTop() + "," + paramView.getPaddingRight() + "," + paramView.getPaddingBottom() + "]";
    AppMethodBeat.o(176242);
    return paramView;
  }
  
  public static void jC(int paramInt1, int paramInt2)
  {
    int i = 1;
    AppMethodBeat.i(265975);
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
          com.tencent.mm.plugin.report.service.h.IzE.el(1606, paramInt2);
        }
        AppMethodBeat.o(265975);
        return;
      }
      catch (Throwable localThrowable)
      {
        AppMethodBeat.o(265975);
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
  
  public static String kp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(265974);
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
    AppMethodBeat.o(265974);
    return paramString1;
  }
  
  public static void ks(String paramString1, String paramString2)
  {
    AppMethodBeat.i(176241);
    try
    {
      if (MMApplicationContext.isMainProcess())
      {
        g localg = new g(paramString1, paramString2);
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHF().kcd.a(localg, 0);
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
  
  public static String kt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(265970);
    StringBuilder localStringBuilder = new StringBuilder("isChatRoom=");
    if ((paramString2 != null) && ((paramString2.endsWith("@chatroom")) || (paramString2.endsWith("@im.chatroom")))) {
      localStringBuilder.append("1");
    }
    for (;;)
    {
      localStringBuilder.append("&fromUsername=").append(paramString1);
      localStringBuilder.append("&chatName=").append(paramString2);
      paramString1 = localStringBuilder.toString();
      AppMethodBeat.o(265970);
      return paramString1;
      localStringBuilder.append("0");
    }
  }
  
  public static String ku(String paramString1, String paramString2)
  {
    AppMethodBeat.i(265980);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(265980);
      return "";
    }
    if (Util.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(265980);
      return paramString1;
    }
    paramString1 = paramString2 + paramString1;
    AppMethodBeat.o(265980);
    return paramString1;
  }
  
  public static String kv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(265982);
    Log.i("ParamsToLocalId", "clearParamsToLocalId, localIdAppendParams = ".concat(String.valueOf(paramString1)));
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(265982);
      return "";
    }
    if ((Util.isNullOrNil(paramString2)) || (!paramString1.contains(paramString2)))
    {
      AppMethodBeat.o(265982);
      return paramString1;
    }
    int i = paramString1.indexOf(paramString2);
    if (i < 0)
    {
      AppMethodBeat.o(265982);
      return paramString1;
    }
    try
    {
      paramString2 = paramString1.substring(0, i) + paramString1.substring(i + paramString2.length());
      paramString1 = paramString2;
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        Log.e("ParamsToLocalId", "clearParamsToLocalId, " + paramString2.toString());
      }
    }
    AppMethodBeat.o(265982);
    return paramString1;
  }
  
  public static int r(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(265950);
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
              if (!q.u(MMApplicationContext.getContext(), paramSnsInfo.firstDownloadApkPkgName)) {
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
      AppMethodBeat.o(265950);
      return i;
      i = 1;
    }
  }
  
  public static int s(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(265952);
    str1 = "";
    try
    {
      str2 = paramSnsInfo.getUserName();
      l = System.currentTimeMillis();
      if ((paramSnsInfo == null) || (!paramSnsInfo.isAd()) || (TextUtils.isEmpty(str2))) {
        break label209;
      }
      com.tencent.mm.kernel.h.aHH();
      paramSnsInfo = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(str2);
      if (paramSnsInfo == null) {
        break label209;
      }
      if ((int)paramSnsInfo.jxt <= 0) {
        break label204;
      }
      boolean bool = com.tencent.mm.contact.d.rk(paramSnsInfo.field_type);
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
          paramSnsInfo = paramSnsInfo.ayr();
          j = i;
          Log.i("SnsAdUtil", "getAdUserFollowStatus, userName=" + str2 + ", followStatus=" + i + ", displayName=" + paramSnsInfo + ", timeCost=" + (System.currentTimeMillis() - l));
          AppMethodBeat.o(265952);
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
    AppMethodBeat.i(265965);
    if (paramSnsInfo == null)
    {
      AppMethodBeat.o(265965);
      return false;
    }
    try
    {
      ADXml localADXml = paramSnsInfo.getAdXml();
      int i = localADXml.isValidJumpCanvas;
      if (i == 1)
      {
        AppMethodBeat.o(265965);
        return true;
      }
      i = localADXml.isValidJumpCanvas;
      if (i == 0)
      {
        AppMethodBeat.o(265965);
        return false;
      }
      if ((localADXml.isLandingPagesAd()) && (i.bbf(paramSnsInfo.getAdSnsInfo().field_adxml))) {
        if (!bool) {
          break label102;
        }
      }
      label102:
      for (localADXml.isValidJumpCanvas = 1;; localADXml.isValidJumpCanvas = 0)
      {
        AppMethodBeat.o(265965);
        return bool;
        bool = false;
        break;
      }
      return false;
    }
    catch (Throwable paramSnsInfo)
    {
      Log.e("SnsAdUtil", paramSnsInfo.toString());
      AppMethodBeat.o(265965);
    }
  }
  
  public static int u(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(265983);
    if (com.tencent.mm.plugin.sns.ad.timeline.c.b.a.fLE())
    {
      if (paramSnsInfo.isTwistAd())
      {
        AppMethodBeat.o(265983);
        return 28;
      }
      if (paramSnsInfo.isGestureAd())
      {
        AppMethodBeat.o(265983);
        return 29;
      }
      if (paramSnsInfo.isLongPressGestureAd())
      {
        AppMethodBeat.o(265983);
        return 30;
      }
      if (paramSnsInfo.isShakeAd())
      {
        AppMethodBeat.o(265983);
        return 31;
      }
      AppMethodBeat.o(265983);
      return 27;
    }
    AppMethodBeat.o(265983);
    return 14;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.m
 * JD-Core Version:    0.7.0.1
 */