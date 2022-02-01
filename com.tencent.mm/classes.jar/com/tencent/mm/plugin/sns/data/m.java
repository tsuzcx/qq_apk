package com.tencent.mm.plugin.sns.data;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.b.a.a;
import com.tencent.mm.plugin.sns.device.appstore.e;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADInfo.a;
import com.tencent.mm.plugin.sns.storage.ADInfo.b;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ar;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.dnb;
import com.tencent.mm.protocal.protobuf.fdv;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class m
{
  public static void a(long paramLong, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(306559);
    Intent localIntent = new Intent();
    localIntent.putExtra("sns_landing_pages_pageid", paramLong);
    localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
    localIntent.putExtra("sns_landig_pages_from_source", paramInt);
    localIntent.putExtra("sns_landing_pages_ad_info", paramString1);
    if (!TextUtils.isEmpty(paramString2)) {
      localIntent.putExtra("sns_landing_pages_extra_param", paramString2);
    }
    com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", localIntent);
    AppMethodBeat.o(306559);
  }
  
  private static void a(Context paramContext, Intent paramIntent, final String paramString1, final String paramString2, final String paramString3, final String paramString4, int paramInt, final SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(306525);
    if ((paramContext == null) || (paramIntent == null))
    {
      Log.e("SnsAdUtil", "startMarketActivity input param is error");
      AppMethodBeat.o(306525);
      return;
    }
    try
    {
      if (!(paramContext instanceof Activity)) {
        paramIntent.addFlags(268435456);
      }
      String str = Util.nullAs(IntentUtil.getStringExtra(paramIntent, "market_app_name"), "");
      final b localb = new b(paramString3, paramString4, paramSnsInfo.getAid(), paramSnsInfo.getTraceid(), paramSnsInfo.getPid());
      com.tencent.mm.plugin.sns.ad.d.c.a(localb, 1);
      if (paramInt != 2) {
        com.tencent.mm.plugin.sns.ad.d.c.i(localb);
      }
      ar.a(paramContext, paramIntent.getPackage(), "", paramIntent, str, new ap()
      {
        public final void onLaunchApp(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
        {
          AppMethodBeat.i(306363);
          if (paramAnonymousBoolean1)
          {
            Object localObject1;
            if (this.val$showType != 2)
            {
              m.b(paramString2, paramString3, paramString4, 2, "0");
              localObject1 = localb;
            }
            try
            {
              c.a locala = new c.a();
              locala.eventId = 4001002;
              locala.uxInfo = ((b)localObject1).uxInfo;
              locala.adExtInfo = ((b)localObject1).adExtInfo;
              locala.PVG = ((b)localObject1).PVG;
              locala.qTb = ((b)localObject1).qTb;
              locala.pId = ((b)localObject1).pId;
              locala.lxk = 1;
              com.tencent.mm.plugin.sns.ad.j.j.a(locala.heI());
              com.tencent.mm.plugin.sns.ad.d.c.b(localb, 1);
              localObject1 = e.a(paramString1, paramString2, paramString3, paramString4, paramSnsInfo);
              if (localObject1 != null) {
                com.tencent.mm.plugin.sns.device.appstore.d.a((e)localObject1);
              }
              AppMethodBeat.o(306363);
              return;
            }
            finally
            {
              for (;;)
              {
                Log.e("AdConversionOnlineReportHelper", localObject2.toString());
              }
            }
          }
          if (this.val$showType != 2) {
            m.b(paramString2, paramString3, paramString4, 2, "2");
          }
          AppMethodBeat.o(306363);
        }
      }, paramInt);
      AppMethodBeat.o(306525);
      return;
    }
    finally
    {
      b(paramString2, paramString3, paramString4, 2, "1");
      AppMethodBeat.o(306525);
    }
  }
  
  public static void a(Context paramContext, String paramString1, ai paramai, int paramInt, long paramLong, String paramString2)
  {
    AppMethodBeat.i(306428);
    a(paramContext, paramString1, paramai, paramInt, paramLong, paramString2, true);
    AppMethodBeat.o(306428);
  }
  
  public static void a(Context paramContext, String paramString1, ai paramai, int paramInt, long paramLong, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(306453);
    label455:
    label461:
    for (;;)
    {
      try
      {
        Intent localIntent = new Intent();
        if ((TextUtils.isEmpty(paramai.qTb)) || (TextUtils.isEmpty(paramai.aid))) {
          break label461;
        }
        paramString1 = ar.n(paramString1, new String[] { "traceid=" + paramai.qTb + "&aid=" + paramai.aid });
        String str = paramai.hiC();
        if (TextUtils.isEmpty(str))
        {
          str = paramai.uxInfo;
          Log.i("SnsAdUtil", "adLandingJumpWebPageUI, use orig_UxInfo:".concat(String.valueOf(str)));
          Object localObject = paramString1;
          if (paramBoolean)
          {
            localObject = t.lY(paramString1, str);
            t.i(localIntent, str);
          }
          paramString1 = com.tencent.mm.plugin.sns.ad.c.a.a.aWj((String)localObject);
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
                break label455;
              }
              paramString1 = String.format("official_mall_%s_%s_%s_%s", new Object[] { paramString1, paramai, paramString2, String.valueOf(paramLong) });
              localIntent.putExtra("prePublishId", paramString1);
              localIntent.putExtra("KPublisherId", paramString1);
              localIntent.putExtra("pay_channel", 47);
            }
          }
          com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
          AppMethodBeat.o(306453);
        }
        else
        {
          Log.i("SnsAdUtil", "adLandingJumpWebPageUI, use updated_UxInfo:".concat(String.valueOf(str)));
          continue;
        }
        paramString1 = "";
      }
      finally
      {
        Log.e("SnsAdUtil", "adLandingJumpWebPageUI exp=" + paramContext.toString());
        AppMethodBeat.o(306453);
        return;
      }
    }
  }
  
  public static void a(SnsAdClick paramSnsAdClick, com.tencent.mm.plugin.sns.ad.g.l paraml, SnsInfo paramSnsInfo, int paramInt)
  {
    AppMethodBeat.i(306479);
    a(paramSnsAdClick, paraml, paramSnsInfo, paramInt, 0);
    AppMethodBeat.o(306479);
  }
  
  public static void a(SnsAdClick paramSnsAdClick, com.tencent.mm.plugin.sns.ad.g.l paraml, SnsInfo paramSnsInfo, int paramInt1, int paramInt2)
  {
    long l2 = 0L;
    AppMethodBeat.i(306484);
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
        paramSnsAdClick.oTW = l1;
        if (paraml != null) {
          break label113;
        }
      }
      label99:
      label113:
      for (long l1 = l2;; l1 = paraml.uv(paramSnsInfo.field_snsId))
      {
        paramSnsAdClick.oTX = l1;
        paramSnsAdClick.oTY = paramInt2;
        AppMethodBeat.o(306484);
        return;
        bool = false;
        break;
        l1 = paraml.gM(paramSnsInfo.getLocalid(), paramInt1);
        break label60;
      }
      return;
    }
    catch (Exception paramSnsAdClick)
    {
      Log.e("SnsAdUtil", "appendSnsAdClickParams exp=" + paramSnsAdClick.toString() + ", clockPos=" + paramInt1);
      AppMethodBeat.o(306484);
    }
  }
  
  private static boolean a(Context paramContext, SnsInfo paramSnsInfo, ADInfo paramADInfo)
  {
    AppMethodBeat.i(306509);
    if ((paramSnsInfo != null) && (paramADInfo != null)) {}
    for (;;)
    {
      try
      {
        if (paramADInfo.actionExtAppJump != null)
        {
          if (!u.y(paramContext, paramADInfo.actionExtAppJump.bJH)) {
            continue;
          }
          Log.i("SnsAdUtil", "checkOpenApp isInstalled=true, " + paramADInfo.actionExtAppJump.toString());
          String str = "";
          if (paramSnsInfo.getAdXml() != null) {
            str = paramSnsInfo.getAdXml().adExtInfo;
          }
          com.tencent.mm.plugin.sns.ad.g.j localj = new com.tencent.mm.plugin.sns.ad.g.j(paramSnsInfo.getAid(), paramSnsInfo.getTraceid(), paramSnsInfo.getPid());
          boolean bool = a(paramContext, paramADInfo.actionExtAppJump.appId, paramADInfo.actionExtAppJump.bJH, paramADInfo.actionExtAppJump.appName, paramADInfo.actionExtAppJump.PLD, paramADInfo.uxInfo, str, String.valueOf(paramSnsInfo.field_snsId), 2, 0, localj);
          com.tencent.mm.plugin.sns.ad.d.c.a(true, paramSnsInfo);
          if (bool)
          {
            AppMethodBeat.o(306509);
            return true;
          }
          Log.e("SnsAdUtil", "checkOpenApp failed, " + paramADInfo.actionExtAppJump.toString());
          com.tencent.mm.plugin.sns.ad.d.b.lK(paramADInfo.actionExtAppJump.bJH, paramADInfo.actionExtAppJump.PLD);
        }
      }
      finally
      {
        Log.e("SnsAdUtil", "checkOpenApp exp=" + paramContext.toString());
        continue;
      }
      AppMethodBeat.o(306509);
      return false;
      Log.e("SnsAdUtil", "checkOpenApp isInstalled=false, " + paramADInfo.actionExtAppJump.toString());
      com.tencent.mm.plugin.sns.ad.d.b.lK(paramADInfo.actionExtAppJump.bJH, paramADInfo.actionExtAppJump.PLD);
    }
  }
  
  private static boolean a(Context paramContext, SnsInfo paramSnsInfo, ADInfo paramADInfo, int paramInt)
  {
    AppMethodBeat.i(306515);
    if ((paramContext == null) || (paramSnsInfo == null) || (paramADInfo == null))
    {
      Log.e("SnsAdUtil", "tryProcessAdAppMarket input param is wrong");
      AppMethodBeat.o(306515);
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
      str3 = paramADInfo.actionExtAppJump.PLD;
      str1 = paramADInfo.actionExtAppJump.bJH;
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
          AppMethodBeat.o(306515);
          return false;
        }
        if (paramInt == 1) {}
        for (int i = 2; u.y(paramContext, str1); i = 0)
        {
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = a.a.bP(paramContext, str1);
          }
          com.tencent.mm.plugin.sns.ad.d.c.a(true, paramSnsInfo);
          localObject1 = new com.tencent.mm.plugin.sns.ad.g.j(paramSnsInfo.getAid(), paramSnsInfo.getTraceid(), paramSnsInfo.getPid());
          a(paramContext, str2, str1, (String)localObject2, str3, paramADInfo.uxInfo, str4, String.valueOf(paramSnsInfo.field_snsId), paramInt, i, (com.tencent.mm.plugin.sns.ad.g.j)localObject1);
          AppMethodBeat.o(306515);
          return true;
        }
        if (com.tencent.mm.plugin.sns.device.appstore.a.bu((Intent)localObject2)) {
          b(String.valueOf(paramSnsInfo.field_snsId), paramADInfo.uxInfo, str4, 4, "0");
        }
        for (;;)
        {
          if (!com.tencent.mm.plugin.sns.device.appstore.a.bv((Intent)localObject2)) {
            break label388;
          }
          b(String.valueOf(paramSnsInfo.field_snsId), paramADInfo.uxInfo, str4, 1, "0");
          com.tencent.mm.plugin.sns.ad.d.c.a(false, paramSnsInfo);
          a(paramContext, (Intent)localObject2, str1, String.valueOf(paramSnsInfo.field_snsId), paramADInfo.uxInfo, str4, i, paramSnsInfo);
          break;
          b(String.valueOf(paramSnsInfo.field_snsId), paramADInfo.uxInfo, str4, 4, "1");
        }
        b(String.valueOf(paramSnsInfo.field_snsId), paramADInfo.uxInfo, str4, 1, "1");
        AppMethodBeat.o(306515);
        return false;
        AppMethodBeat.o(306515);
        return false;
      }
      localObject1 = "";
    }
  }
  
  public static boolean a(Context paramContext, SnsInfo paramSnsInfo, ADInfo paramADInfo, int paramInt, com.tencent.mm.plugin.sns.ad.g.l paraml)
  {
    int i = 2;
    AppMethodBeat.i(306495);
    if ((paramSnsInfo == null) || (paramADInfo == null))
    {
      AppMethodBeat.o(306495);
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
        AppMethodBeat.o(306495);
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
        AppMethodBeat.o(306495);
        return true;
      }
      com.tencent.mm.plugin.sns.ad.d.c.a(false, paramSnsInfo);
      ADXml localADXml = paramSnsInfo.getAdXml();
      if ((localADXml != null) && (localADXml.adScanJumpInfo != null) && (paramADInfo != null) && (paramADInfo.adActionType == 8)) {
        com.tencent.mm.plugin.sns.ad.d.s.a(paramContext, localADXml.adScanJumpInfo, paramADInfo.uxInfo, 7);
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
        AppMethodBeat.o(306495);
        return true;
      }
      if (com.tencent.mm.plugin.sns.ad.d.n.a(paramContext, paramSnsInfo.getAdXml(), paramADInfo, paramSnsInfo.field_snsId))
      {
        if (paramInt == 0) {
          i = 1;
        }
        paramContext = new SnsAdClick(paramInt, i, paramSnsInfo.field_snsId, 22, 37);
        a(paramContext, paraml, paramSnsInfo, 22);
        t.a(paramContext);
        AppMethodBeat.o(306495);
        return true;
      }
    }
    finally
    {
      Log.e("SnsAdUtil", "handleAdClickAction, exp=" + paramContext.toString());
      AppMethodBeat.o(306495);
    }
    return false;
  }
  
  public static boolean a(Context paramContext, SnsInfo paramSnsInfo, ADInfo paramADInfo, int paramInt1, com.tencent.mm.plugin.sns.ad.g.l paraml, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(306503);
    if ((paramSnsInfo == null) || (paramADInfo == null))
    {
      AppMethodBeat.o(306503);
      return false;
    }
    int i;
    if (paramInt1 == 0) {
      i = 1;
    }
    try
    {
      SnsAdClick localSnsAdClick;
      for (;;)
      {
        localSnsAdClick = new SnsAdClick(paramInt1, i, paramSnsInfo.field_snsId, paramInt2, 0);
        a(localSnsAdClick, paraml, paramSnsInfo, paramInt2, paramInt3);
        if (!a(paramContext, paramSnsInfo, paramADInfo)) {
          break;
        }
        Log.i("SnsAdUtil", "handleAdClickDownloadAction, checkOpenApp success");
        localSnsAdClick.oTQ = 34;
        t.a(localSnsAdClick);
        AppMethodBeat.o(306503);
        return true;
        i = 2;
      }
      if (a(paramContext, paramSnsInfo, paramADInfo, 2))
      {
        Log.i("SnsAdUtil", "handleAdClickDownloadAction, tryProcessAdAppMarket success");
        localSnsAdClick.oTQ = 36;
        t.a(localSnsAdClick);
        AppMethodBeat.o(306503);
        return true;
      }
      com.tencent.mm.plugin.sns.ad.d.c.a(false, paramSnsInfo);
    }
    finally
    {
      for (;;)
      {
        Log.e("SnsAdUtil", "handleAdClickDownloadAction, exp=" + paramContext.toString());
      }
    }
    AppMethodBeat.o(306503);
    return false;
  }
  
  public static boolean a(final Context paramContext, final String paramString1, final String paramString2, final String paramString3, String paramString4, final String paramString5, final String paramString6, final String paramString7, final int paramInt1, final int paramInt2, final com.tencent.mm.plugin.sns.ad.g.j paramj)
  {
    AppMethodBeat.i(306488);
    Log.i("SnsAdUtil", "openApp, appId = " + paramString1 + ", uxInfo = " + paramString5 + ", adExtInfo = " + paramString6 + ", appPageUrl=" + paramString4 + ", pkgName=" + paramString2);
    if ((paramContext == null) || (TextUtils.isEmpty(paramString2)))
    {
      Log.e("SnsAdUtil", "openApp, failed");
      AppMethodBeat.o(306488);
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
          com.tencent.mm.ci.a.post(new Runnable()
          {
            /* Error */
            public final void run()
            {
              // Byte code:
              //   0: ldc 56
              //   2: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
              //   5: new 64	com/tencent/mm/plugin/sns/data/b
              //   8: dup
              //   9: aload_0
              //   10: getfield 32	com/tencent/mm/plugin/sns/data/m$1:PPX	Ljava/lang/String;
              //   13: aload_0
              //   14: getfield 34	com/tencent/mm/plugin/sns/data/m$1:QnJ	Lcom/tencent/mm/plugin/sns/ad/g/j;
              //   17: getfield 69	com/tencent/mm/plugin/sns/ad/g/j:rzx	Ljava/lang/String;
              //   20: aload_0
              //   21: getfield 34	com/tencent/mm/plugin/sns/data/m$1:QnJ	Lcom/tencent/mm/plugin/sns/ad/g/j;
              //   24: getfield 72	com/tencent/mm/plugin/sns/ad/g/j:enterScene	I
              //   27: aload_0
              //   28: getfield 36	com/tencent/mm/plugin/sns/data/m$1:PPY	Ljava/lang/String;
              //   31: aload_0
              //   32: getfield 34	com/tencent/mm/plugin/sns/data/m$1:QnJ	Lcom/tencent/mm/plugin/sns/ad/g/j;
              //   35: getfield 75	com/tencent/mm/plugin/sns/ad/g/j:PVG	Ljava/lang/String;
              //   38: aload_0
              //   39: getfield 34	com/tencent/mm/plugin/sns/data/m$1:QnJ	Lcom/tencent/mm/plugin/sns/ad/g/j;
              //   42: getfield 78	com/tencent/mm/plugin/sns/ad/g/j:qTb	Ljava/lang/String;
              //   45: aload_0
              //   46: getfield 34	com/tencent/mm/plugin/sns/data/m$1:QnJ	Lcom/tencent/mm/plugin/sns/ad/g/j;
              //   49: getfield 81	com/tencent/mm/plugin/sns/ad/g/j:pId	Ljava/lang/String;
              //   52: invokespecial 84	com/tencent/mm/plugin/sns/data/b:<init>	(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
              //   55: astore_1
              //   56: new 86	com/tencent/mm/plugin/sns/data/c$a
              //   59: dup
              //   60: invokespecial 87	com/tencent/mm/plugin/sns/data/c$a:<init>	()V
              //   63: astore_2
              //   64: aload_2
              //   65: ldc 88
              //   67: putfield 91	com/tencent/mm/plugin/sns/data/c$a:eventId	I
              //   70: aload_2
              //   71: aload_1
              //   72: getfield 94	com/tencent/mm/plugin/sns/data/b:uxInfo	Ljava/lang/String;
              //   75: putfield 95	com/tencent/mm/plugin/sns/data/c$a:uxInfo	Ljava/lang/String;
              //   78: aload_2
              //   79: aload_1
              //   80: getfield 96	com/tencent/mm/plugin/sns/data/b:rzx	Ljava/lang/String;
              //   83: putfield 97	com/tencent/mm/plugin/sns/data/c$a:rzx	Ljava/lang/String;
              //   86: aload_2
              //   87: aload_1
              //   88: getfield 98	com/tencent/mm/plugin/sns/data/b:enterScene	I
              //   91: putfield 99	com/tencent/mm/plugin/sns/data/c$a:enterScene	I
              //   94: aload_2
              //   95: aload_1
              //   96: getfield 102	com/tencent/mm/plugin/sns/data/b:adExtInfo	Ljava/lang/String;
              //   99: putfield 103	com/tencent/mm/plugin/sns/data/c$a:adExtInfo	Ljava/lang/String;
              //   102: aload_2
              //   103: aload_1
              //   104: getfield 104	com/tencent/mm/plugin/sns/data/b:PVG	Ljava/lang/String;
              //   107: putfield 105	com/tencent/mm/plugin/sns/data/c$a:PVG	Ljava/lang/String;
              //   110: aload_2
              //   111: aload_1
              //   112: getfield 106	com/tencent/mm/plugin/sns/data/b:qTb	Ljava/lang/String;
              //   115: putfield 107	com/tencent/mm/plugin/sns/data/c$a:qTb	Ljava/lang/String;
              //   118: aload_2
              //   119: aload_1
              //   120: getfield 108	com/tencent/mm/plugin/sns/data/b:pId	Ljava/lang/String;
              //   123: putfield 109	com/tencent/mm/plugin/sns/data/c$a:pId	Ljava/lang/String;
              //   126: aload_2
              //   127: iconst_1
              //   128: putfield 112	com/tencent/mm/plugin/sns/data/c$a:Qmy	I
              //   131: aload_2
              //   132: iconst_1
              //   133: putfield 115	com/tencent/mm/plugin/sns/data/c$a:Qmz	I
              //   136: aload_2
              //   137: invokevirtual 119	com/tencent/mm/plugin/sns/data/c$a:heI	()Lcom/tencent/mm/plugin/sns/data/c;
              //   140: invokestatic 124	com/tencent/mm/plugin/sns/ad/j/j:a	(Lcom/tencent/mm/plugin/sns/ad/j/j$a;)V
              //   143: aload_0
              //   144: getfield 38	com/tencent/mm/plugin/sns/data/m$1:val$showType	I
              //   147: iconst_2
              //   148: if_icmpeq +90 -> 238
              //   151: new 86	com/tencent/mm/plugin/sns/data/c$a
              //   154: dup
              //   155: invokespecial 87	com/tencent/mm/plugin/sns/data/c$a:<init>	()V
              //   158: astore_2
              //   159: aload_2
              //   160: ldc 125
              //   162: putfield 91	com/tencent/mm/plugin/sns/data/c$a:eventId	I
              //   165: aload_2
              //   166: aload_1
              //   167: getfield 94	com/tencent/mm/plugin/sns/data/b:uxInfo	Ljava/lang/String;
              //   170: putfield 95	com/tencent/mm/plugin/sns/data/c$a:uxInfo	Ljava/lang/String;
              //   173: aload_2
              //   174: aload_1
              //   175: getfield 96	com/tencent/mm/plugin/sns/data/b:rzx	Ljava/lang/String;
              //   178: putfield 97	com/tencent/mm/plugin/sns/data/c$a:rzx	Ljava/lang/String;
              //   181: aload_2
              //   182: aload_1
              //   183: getfield 98	com/tencent/mm/plugin/sns/data/b:enterScene	I
              //   186: putfield 99	com/tencent/mm/plugin/sns/data/c$a:enterScene	I
              //   189: aload_2
              //   190: aload_1
              //   191: getfield 102	com/tencent/mm/plugin/sns/data/b:adExtInfo	Ljava/lang/String;
              //   194: putfield 103	com/tencent/mm/plugin/sns/data/c$a:adExtInfo	Ljava/lang/String;
              //   197: aload_2
              //   198: aload_1
              //   199: getfield 104	com/tencent/mm/plugin/sns/data/b:PVG	Ljava/lang/String;
              //   202: putfield 105	com/tencent/mm/plugin/sns/data/c$a:PVG	Ljava/lang/String;
              //   205: aload_2
              //   206: aload_1
              //   207: getfield 106	com/tencent/mm/plugin/sns/data/b:qTb	Ljava/lang/String;
              //   210: putfield 107	com/tencent/mm/plugin/sns/data/c$a:qTb	Ljava/lang/String;
              //   213: aload_2
              //   214: aload_1
              //   215: getfield 108	com/tencent/mm/plugin/sns/data/b:pId	Ljava/lang/String;
              //   218: putfield 109	com/tencent/mm/plugin/sns/data/c$a:pId	Ljava/lang/String;
              //   221: aload_2
              //   222: iconst_1
              //   223: putfield 112	com/tencent/mm/plugin/sns/data/c$a:Qmy	I
              //   226: aload_2
              //   227: iconst_1
              //   228: putfield 115	com/tencent/mm/plugin/sns/data/c$a:Qmz	I
              //   231: aload_2
              //   232: invokevirtual 119	com/tencent/mm/plugin/sns/data/c$a:heI	()Lcom/tencent/mm/plugin/sns/data/c;
              //   235: invokestatic 124	com/tencent/mm/plugin/sns/ad/j/j:a	(Lcom/tencent/mm/plugin/sns/ad/j/j$a;)V
              //   238: aload_0
              //   239: getfield 40	com/tencent/mm/plugin/sns/data/m$1:val$context	Landroid/content/Context;
              //   242: aload_0
              //   243: getfield 42	com/tencent/mm/plugin/sns/data/m$1:val$intent	Landroid/content/Intent;
              //   246: aload_0
              //   247: getfield 44	com/tencent/mm/plugin/sns/data/m$1:qHo	Ljava/lang/String;
              //   250: aload_0
              //   251: getfield 38	com/tencent/mm/plugin/sns/data/m$1:val$showType	I
              //   254: new 13	com/tencent/mm/plugin/sns/data/m$1$1
              //   257: dup
              //   258: aload_0
              //   259: aload_1
              //   260: invokespecial 128	com/tencent/mm/plugin/sns/data/m$1$1:<init>	(Lcom/tencent/mm/plugin/sns/data/m$1;Lcom/tencent/mm/plugin/sns/data/b;)V
              //   263: aconst_null
              //   264: invokestatic 133	com/tencent/mm/pluginsdk/model/app/h:a	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;ILcom/tencent/mm/pluginsdk/model/app/ap;Landroid/os/Bundle;)Z
              //   267: pop
              //   268: ldc 56
              //   270: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   273: return
              //   274: astore_2
              //   275: ldc 138
              //   277: aload_2
              //   278: invokevirtual 144	java/lang/Throwable:toString	()Ljava/lang/String;
              //   281: invokestatic 150	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
              //   284: goto -141 -> 143
              //   287: astore_2
              //   288: ldc 138
              //   290: aload_2
              //   291: invokevirtual 144	java/lang/Throwable:toString	()Ljava/lang/String;
              //   294: invokestatic 150	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
              //   297: goto -59 -> 238
              // Local variable table:
              //   start	length	slot	name	signature
              //   0	300	0	this	1
              //   55	205	1	localb	b
              //   63	169	2	locala	c.a
              //   274	4	2	localObject1	Object
              //   287	4	2	localObject2	Object
              // Exception table:
              //   from	to	target	type
              //   56	143	274	finally
              //   151	238	287	finally
            }
          });
        }
      }
    }
    for (;;)
    {
      AdLandingPagesProxy.getInstance().reportOpenAppInfo(9, paramString1, paramString2);
      AppMethodBeat.o(306488);
      return true;
      paramString4 = localIntent.getPackage();
      break;
      label298:
      Log.e("SnsAdUtil", "err queryIntent pkg equals mm");
      AppMethodBeat.o(306488);
      return false;
      Log.e("SnsAdUtil", "queryIntentActivities, empty");
      AppMethodBeat.o(306488);
      return false;
      com.tencent.mm.ci.a.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(306379);
          Intent localIntent = m.this.getPackageManager().getLaunchIntentForPackage(paramString2);
          com.tencent.mm.pluginsdk.model.app.h.a(m.this, localIntent, paramString3, paramInt2, new ap()
          {
            public final void onLaunchApp(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
            {
              AppMethodBeat.i(306409);
              Log.i("SnsAdUtil", "onLaunchApp=" + paramAnonymous2Boolean1 + ", launchCancel=" + paramAnonymous2Boolean2);
              if ((paramAnonymous2Boolean1) && (m.2.this.val$showType != 2)) {
                k.a(m.2.this.paw, m.2.this.etl, 1, 2, m.2.this.PPX, m.2.this.PPY, m.2.this.QnK);
              }
              if (!paramAnonymous2Boolean1) {
                ar.jS(m.this);
              }
              AppMethodBeat.o(306409);
            }
          }, null);
          AppMethodBeat.o(306379);
        }
      });
    }
  }
  
  public static boolean a(SnsObject paramSnsObject, String paramString)
  {
    AppMethodBeat.i(306464);
    for (;;)
    {
      try
      {
        Iterator localIterator = paramSnsObject.CommentUserList.iterator();
        if (!localIterator.hasNext()) {
          break label239;
        }
        fdv localfdv = (fdv)localIterator.next();
        if ((localfdv == null) || (Util.isNullOrNil(localfdv.Username)) || (!localfdv.Username.equals(paramString))) {
          continue;
        }
        bool1 = true;
        localIterator = paramSnsObject.LikeUserList.iterator();
        if (localIterator.hasNext())
        {
          localfdv = (fdv)localIterator.next();
          if ((localfdv == null) || (Util.isNullOrNil(localfdv.Username)) || (!localfdv.Username.equals(paramString))) {
            continue;
          }
          bool2 = true;
          Log.i("SnsAdUtil", "isAdCommentOrLikedBySelf, snsId=" + t.uA(paramSnsObject.Id) + ", hasComment=" + bool1 + ", hasLiked=" + bool2);
          if ((bool1) || (bool2))
          {
            AppMethodBeat.o(306464);
            return true;
          }
          AppMethodBeat.o(306464);
          return false;
        }
      }
      catch (Exception paramSnsObject)
      {
        Log.e("SnsAdUtil", "isAdCommentOrLikedBySelf, exp=" + paramSnsObject.toString());
        AppMethodBeat.o(306464);
        return false;
      }
      boolean bool2 = false;
      continue;
      label239:
      boolean bool1 = false;
    }
  }
  
  public static JSONObject aU(Map<String, Object> paramMap)
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
  
  public static String aWg(String paramString)
  {
    AppMethodBeat.i(306561);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("SnsAdUtil", "uxInfo is null");
      AppMethodBeat.o(306561);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<ADInfo><uxInfo>").append(paramString).append("</uxInfo></ADInfo>");
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(306561);
    return paramString;
  }
  
  public static long aXe(String paramString)
  {
    AppMethodBeat.i(306465);
    try
    {
      boolean bool = Util.isNullOrNil(paramString);
      if (bool)
      {
        AppMethodBeat.o(306465);
        return 0L;
      }
      if (paramString.startsWith("ad_table_"))
      {
        l = Util.safeParseLong(paramString.substring(9));
        AppMethodBeat.o(306465);
        return l;
      }
      if (paramString.startsWith("sns_table_"))
      {
        l = Util.safeParseLong(paramString.substring(10));
        AppMethodBeat.o(306465);
        return l;
      }
      long l = t.aXD(paramString);
      AppMethodBeat.o(306465);
      return l;
    }
    finally
    {
      Log.e("SnsAdUtil", paramString.toString());
      AppMethodBeat.o(306465);
    }
    return 0L;
  }
  
  public static String aXf(String paramString)
  {
    AppMethodBeat.i(306557);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(306557);
      return "";
    }
    paramString = paramString.split("\\|");
    if ((paramString != null) && (paramString.length > 0))
    {
      paramString = paramString[0];
      AppMethodBeat.o(306557);
      return paramString;
    }
    AppMethodBeat.o(306557);
    return "";
  }
  
  public static boolean aXg(String paramString)
  {
    AppMethodBeat.i(306564);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("<usePreferedInfo>1</usePreferedInfo>")))
    {
      AppMethodBeat.o(306564);
      return true;
    }
    AppMethodBeat.o(306564);
    return false;
  }
  
  public static int aXh(String paramString)
  {
    AppMethodBeat.i(306578);
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = paramString.split("-");
        if ((paramString != null) && (paramString.length > 0))
        {
          int i = Util.safeParseInt(paramString[0]);
          AppMethodBeat.o(306578);
          return i;
        }
      }
    }
    finally
    {
      Log.e("SnsAdUtil", "getRawRequestType, exp=" + paramString.toString());
      AppMethodBeat.o(306578);
    }
    return 0;
  }
  
  public static String aXi(String paramString)
  {
    AppMethodBeat.i(306596);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(306596);
      return "";
    }
    try
    {
      paramString = Util.nullAsNil(paramString.split("\\|")[0]);
      AppMethodBeat.o(306596);
      return paramString;
    }
    finally
    {
      Log.e("SnsAdUtil", paramString.toString());
      AppMethodBeat.o(306596);
    }
    return "";
  }
  
  public static String aXj(String paramString)
  {
    AppMethodBeat.i(306598);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(306598);
      return "";
    }
    try
    {
      paramString = Util.nullAsNil(paramString.split("\\|")[1]);
      AppMethodBeat.o(306598);
      return paramString;
    }
    finally
    {
      Log.e("SnsAdUtil", paramString.toString());
      AppMethodBeat.o(306598);
    }
    return "";
  }
  
  public static String aXk(String paramString)
  {
    AppMethodBeat.i(306600);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(306600);
      return "";
    }
    try
    {
      paramString = Util.nullAsNil(paramString.split("\\|")[7]);
      AppMethodBeat.o(306600);
      return paramString;
    }
    finally
    {
      Log.e("SnsAdUtil", paramString.toString());
      AppMethodBeat.o(306600);
    }
    return "";
  }
  
  public static String aXl(String paramString)
  {
    AppMethodBeat.i(306605);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(306605);
      return "";
    }
    try
    {
      Log.i("SnsAdUtil", "getUxinfoFromAdInfoXml, xml=".concat(String.valueOf(paramString)));
      paramString = XmlParser.parseXml(paramString, "ADInfo", null);
      if (paramString != null)
      {
        paramString = Util.nullAs((String)paramString.get(".ADInfo.uxInfo"), "");
        AppMethodBeat.o(306605);
        return paramString;
      }
    }
    finally
    {
      Log.e("SnsAdUtil", "getUxinfoFromAdInfoXml, exp=" + paramString.toString());
      AppMethodBeat.o(306605);
    }
    return "";
  }
  
  public static float akn(int paramInt)
  {
    AppMethodBeat.i(306652);
    Context localContext = MMApplicationContext.getContext();
    float f1 = com.tencent.mm.cd.a.bs(localContext, paramInt);
    float f2 = jO(localContext);
    AppMethodBeat.o(306652);
    return f2 * f1;
  }
  
  public static int ako(int paramInt)
  {
    AppMethodBeat.i(306678);
    paramInt = Math.round(com.tencent.mm.ce.c.iRA() * paramInt);
    AppMethodBeat.o(306678);
    return paramInt;
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    AppMethodBeat.i(306534);
    ArrayMap localArrayMap = new ArrayMap();
    localArrayMap.put("outSns", Integer.valueOf(1));
    com.tencent.mm.plugin.sns.device.appstore.a.a(paramString1, paramString2, paramString3, paramInt, paramString4, localArrayMap);
    AppMethodBeat.o(306534);
  }
  
  public static boolean b(Context paramContext, SnsInfo paramSnsInfo, ADInfo paramADInfo)
  {
    AppMethodBeat.i(306510);
    try
    {
      boolean bool = a(paramContext, paramSnsInfo, paramADInfo, 0);
      AppMethodBeat.o(306510);
      return bool;
    }
    finally
    {
      Log.w("SnsAdUtil", "processAdAppMarket has something wrong");
      AppMethodBeat.o(306510);
    }
    return false;
  }
  
  public static HashSet<String> c(SnsObject paramSnsObject)
  {
    AppMethodBeat.i(306626);
    HashSet localHashSet = new HashSet();
    if (paramSnsObject == null)
    {
      AppMethodBeat.o(306626);
      return localHashSet;
    }
    paramSnsObject = paramSnsObject.LikeUserList.iterator();
    if (paramSnsObject != null) {
      while (paramSnsObject.hasNext()) {
        localHashSet.add(Util.nullAsNil(((fdv)paramSnsObject.next()).Username));
      }
    }
    AppMethodBeat.o(306626);
    return localHashSet;
  }
  
  public static HashSet<String> c(HashSet<String> paramHashSet1, HashSet<String> paramHashSet2)
  {
    AppMethodBeat.i(306639);
    HashSet localHashSet = new HashSet();
    if (!com.tencent.mm.plugin.sns.ad.j.d.isEmpty(paramHashSet1)) {
      localHashSet.addAll(paramHashSet1);
    }
    if (!com.tencent.mm.plugin.sns.ad.j.d.isEmpty(paramHashSet2)) {
      localHashSet.addAll(paramHashSet2);
    }
    AppMethodBeat.o(306639);
    return localHashSet;
  }
  
  public static boolean c(SnsInfo paramSnsInfo, int paramInt)
  {
    AppMethodBeat.i(306543);
    if (paramInt == 2) {}
    for (paramSnsInfo = paramSnsInfo.getAtAdInfo(); (paramSnsInfo == null) || (paramSnsInfo.actionExtWeApp == null); paramSnsInfo = paramSnsInfo.getAdInfo())
    {
      AppMethodBeat.o(306543);
      return false;
    }
    if (paramSnsInfo.adActionType != 4)
    {
      AppMethodBeat.o(306543);
      return false;
    }
    if (Util.isNullOrNil(paramSnsInfo.actionExtWeApp.appUserName))
    {
      AppMethodBeat.o(306543);
      return false;
    }
    AppMethodBeat.o(306543);
    return true;
  }
  
  public static String cW(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(306646);
    String str1 = paramString;
    try
    {
      if (!Util.isNullOrNil(paramString))
      {
        str1 = paramString;
        if (paramBoolean) {
          str1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.o(paramString, new String[] { String.format("gdt_clicktime=%s", new Object[] { Long.valueOf(System.currentTimeMillis()) }) });
        }
      }
    }
    finally
    {
      for (;;)
      {
        Log.e("SnsAdUtil", localObject.toString());
        String str2 = paramString;
      }
    }
    AppMethodBeat.o(306646);
    return str1;
  }
  
  public static HashSet<String> d(SnsObject paramSnsObject)
  {
    AppMethodBeat.i(306632);
    HashSet localHashSet = new HashSet();
    if (paramSnsObject == null)
    {
      AppMethodBeat.o(306632);
      return localHashSet;
    }
    paramSnsObject = paramSnsObject.CommentUserList.iterator();
    if (paramSnsObject != null) {
      while (paramSnsObject.hasNext()) {
        localHashSet.add(Util.nullAsNil(((fdv)paramSnsObject.next()).Username));
      }
    }
    AppMethodBeat.o(306632);
    return localHashSet;
  }
  
  public static void d(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(306573);
    Log.i("SnsAdUtil", "reportAdPicDownload, result=" + paramInt1 + ", scene=" + paramInt2 + ", downloader=" + paramInt3 + ", imgUrl=" + paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      try
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(21534, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
        if (paramInt2 == 0)
        {
          if (paramInt1 == 0)
          {
            com.tencent.mm.plugin.report.service.h.OAn.kJ(1560, 1);
            AppMethodBeat.o(306573);
            return;
          }
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1560, 2);
          AppMethodBeat.o(306573);
          return;
        }
      }
      finally
      {
        Log.e("SnsAdUtil", "reportAdPicDownload, exp=" + paramString.toString());
        AppMethodBeat.o(306573);
        return;
      }
      if (paramInt2 == 1)
      {
        if (paramInt1 == 0)
        {
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1560, 3);
          AppMethodBeat.o(306573);
          return;
        }
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1560, 4);
      }
      AppMethodBeat.o(306573);
      return;
    }
    Log.e("SnsAdUtil", "reportAdPicDownload, url is empty");
    AppMethodBeat.o(306573);
  }
  
  public static boolean d(TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(176239);
    if ((paramTimeLineObject != null) && (paramTimeLineObject.ContentObj != null) && (paramTimeLineObject.ContentObj.Zpr != null) && (paramTimeLineObject.ContentObj.Zpr.size() > 0))
    {
      paramTimeLineObject = (dmz)paramTimeLineObject.ContentObj.Zpr.get(0);
      if ((paramTimeLineObject != null) && (paramTimeLineObject.aaTn != null) && (paramTimeLineObject.aaTn.aaUb > 0.0F) && (paramTimeLineObject.aaTn.aaUc > 0.0F))
      {
        int i = (int)paramTimeLineObject.aaTn.aaUb;
        if ((int)paramTimeLineObject.aaTn.aaUc > i)
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
  
  public static int heN()
  {
    AppMethodBeat.i(306684);
    try
    {
      int i = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getInt("current_text_size_index_key", 1);
      AppMethodBeat.o(306684);
      return i;
    }
    finally
    {
      Log.e("SnsAdUtil", "getFontScaleIndex, exp=" + localObject.toString());
      AppMethodBeat.o(306684);
    }
    return 1;
  }
  
  private static float jO(Context paramContext)
  {
    AppMethodBeat.i(306657);
    float f = 1.0F;
    if (com.tencent.mm.cd.a.mq(paramContext)) {
      if (!com.tencent.mm.cd.a.ml(paramContext)) {
        break label34;
      }
    }
    label34:
    for (f = 1.12F;; f = 1.1F)
    {
      AppMethodBeat.o(306657);
      return f;
    }
  }
  
  public static boolean jP(Context paramContext)
  {
    AppMethodBeat.i(306688);
    if (paramContext == null)
    {
      Log.w("SnsAdUtil", "isAdapterElder() called with: context = [" + paramContext + "]");
      AppMethodBeat.o(306688);
      return false;
    }
    if (com.tencent.mm.cd.a.getScaleSize(paramContext) > 1.1F)
    {
      AppMethodBeat.o(306688);
      return true;
    }
    AppMethodBeat.o(306688);
    return false;
  }
  
  public static String jr(View paramView)
  {
    AppMethodBeat.i(176242);
    paramView = "[" + paramView.getPaddingLeft() + "," + paramView.getPaddingTop() + "," + paramView.getPaddingRight() + "," + paramView.getPaddingBottom() + "]";
    AppMethodBeat.o(176242);
    return paramView;
  }
  
  public static String lP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(306588);
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
    AppMethodBeat.o(306588);
    return paramString1;
  }
  
  public static void lU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(176241);
    try
    {
      if (MMApplicationContext.isMainProcess())
      {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.h localh = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.h(paramString1, paramString2);
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baD().mCm.a(localh, 0);
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
    finally
    {
      Log.e("SnsAdUtil", "adChannelCgiReport, exp=" + paramString1.toString());
      AppMethodBeat.o(176241);
      return;
    }
    AdLandingPagesProxy.getInstance().onAdLandingPageClick(paramString1, paramString2);
    Log.i("SnsAdUtil", "adChannelCgiReport, other process, channel=" + paramString1 + ", content=" + paramString2);
    AppMethodBeat.o(176241);
  }
  
  public static String lV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(306567);
    StringBuilder localStringBuilder = new StringBuilder("isChatRoom=");
    if ((paramString2 != null) && ((paramString2.endsWith("@chatroom")) || (paramString2.endsWith("@im.chatroom")))) {
      localStringBuilder.append("1");
    }
    for (;;)
    {
      localStringBuilder.append("&fromUsername=").append(paramString1);
      localStringBuilder.append("&chatName=").append(paramString2);
      paramString1 = localStringBuilder.toString();
      AppMethodBeat.o(306567);
      return paramString1;
      localStringBuilder.append("0");
    }
  }
  
  public static String lW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(306613);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(306613);
      return "";
    }
    if (Util.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(306613);
      return paramString1;
    }
    paramString1 = paramString2 + paramString1;
    AppMethodBeat.o(306613);
    return paramString1;
  }
  
  public static String lX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(306619);
    Log.i("ParamsToLocalId", "clearParamsToLocalId, localIdAppendParams = ".concat(String.valueOf(paramString1)));
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(306619);
      return "";
    }
    if ((Util.isNullOrNil(paramString2)) || (!paramString1.contains(paramString2)))
    {
      AppMethodBeat.o(306619);
      return paramString1;
    }
    int i = paramString1.indexOf(paramString2);
    if (i < 0)
    {
      AppMethodBeat.o(306619);
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
    AppMethodBeat.o(306619);
    return paramString1;
  }
  
  public static void ln(int paramInt1, int paramInt2)
  {
    int i = 1;
    AppMethodBeat.i(306594);
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
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1606, paramInt2);
        }
      }
      finally
      {
        AppMethodBeat.o(306594);
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
  
  public static void q(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(306664);
    if (paramTextView == null)
    {
      AppMethodBeat.o(306664);
      return;
    }
    try
    {
      paramTextView.setTextSize(0, akn(paramInt));
      AppMethodBeat.o(306664);
      return;
    }
    finally
    {
      Log.e("SnsAdUtil", "setLimitedScaleFontSize, exp=" + paramTextView.toString());
      AppMethodBeat.o(306664);
    }
  }
  
  public static void r(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(306670);
    if (paramTextView == null)
    {
      AppMethodBeat.o(306670);
      return;
    }
    try
    {
      paramTextView.setTextSize(0, com.tencent.mm.cd.a.bs(paramTextView.getContext(), paramInt));
      AppMethodBeat.o(306670);
      return;
    }
    finally
    {
      Log.e("SnsAdUtil", "setFixedFontSize, exp=" + paramTextView.toString());
      AppMethodBeat.o(306670);
    }
  }
  
  public static int t(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(306470);
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
              if (!u.y(MMApplicationContext.getContext(), paramSnsInfo.firstDownloadApkPkgName)) {
                continue;
              }
              i = 2;
              j = i;
              Log.i("SnsAdUtil", "getAdAppInstallStatus, pkg=" + paramSnsInfo.firstDownloadApkPkgName + ", installState=" + i + ", timeCost=" + (System.currentTimeMillis() - l));
            }
          }
        }
      }
      finally
      {
        Log.e("SnsAdUtil", "appInstalled exp=" + paramSnsInfo.toString());
        i = j;
        continue;
      }
      AppMethodBeat.o(306470);
      return i;
      i = 1;
    }
  }
  
  public static int u(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(306475);
    str1 = "";
    try
    {
      str2 = paramSnsInfo.getUserName();
      l = System.currentTimeMillis();
      if ((paramSnsInfo == null) || (!paramSnsInfo.isAd()) || (TextUtils.isEmpty(str2))) {
        break label209;
      }
      com.tencent.mm.kernel.h.baF();
      paramSnsInfo = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(str2);
      if (paramSnsInfo == null) {
        break label209;
      }
      if ((int)paramSnsInfo.maN <= 0) {
        break label204;
      }
      boolean bool = com.tencent.mm.contact.d.rs(paramSnsInfo.field_type);
      if (!bool) {
        break label204;
      }
      i = 2;
    }
    finally
    {
      for (;;)
      {
        try
        {
          String str2;
          long l;
          paramSnsInfo = paramSnsInfo.aSU();
          j = i;
          Log.i("SnsAdUtil", "getAdUserFollowStatus, userName=" + str2 + ", followStatus=" + i + ", displayName=" + paramSnsInfo + ", timeCost=" + (System.currentTimeMillis() - l));
          AppMethodBeat.o(306475);
          return i;
        }
        finally
        {
          int j;
          continue;
        }
        paramSnsInfo = finally;
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
  
  public static boolean v(SnsInfo paramSnsInfo)
  {
    boolean bool = true;
    AppMethodBeat.i(306550);
    if (paramSnsInfo == null)
    {
      AppMethodBeat.o(306550);
      return false;
    }
    try
    {
      ADXml localADXml = paramSnsInfo.getAdXml();
      int i = localADXml.isValidJumpCanvas;
      if (i == 1)
      {
        AppMethodBeat.o(306550);
        return true;
      }
      i = localADXml.isValidJumpCanvas;
      if (i == 0)
      {
        AppMethodBeat.o(306550);
        return false;
      }
      if ((localADXml.isLandingPagesAd()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.aZJ(paramSnsInfo.getAdSnsInfo().field_adxml))) {
        if (!bool) {
          break label102;
        }
      }
      label102:
      for (localADXml.isValidJumpCanvas = 1;; localADXml.isValidJumpCanvas = 0)
      {
        AppMethodBeat.o(306550);
        return bool;
        bool = false;
        break;
      }
      return false;
    }
    finally
    {
      Log.e("SnsAdUtil", paramSnsInfo.toString());
      AppMethodBeat.o(306550);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.m
 * JD-Core Version:    0.7.0.1
 */