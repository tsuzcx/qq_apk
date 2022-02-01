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
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.ad.e.j;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af;
import com.tencent.mm.plugin.sns.storage.a.b;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.bzj;
import com.tencent.mm.protocal.protobuf.dgh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.storage.bq;
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
    AppMethodBeat.i(219255);
    if ((paramContext == null) || (paramIntent == null))
    {
      ae.e("SnsAdUtil", "startMarketActivity input param is error");
      AppMethodBeat.o(219255);
      return;
    }
    try
    {
      if (!(paramContext instanceof Activity)) {
        paramIntent.addFlags(268435456);
      }
      String str = bu.bI(z.getStringExtra(paramIntent, "market_app_name"), "");
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.an.a(paramContext, paramIntent.getPackage(), "", paramIntent, str, new al()
      {
        public final void v(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
        {
          AppMethodBeat.i(219243);
          if (paramAnonymousBoolean1)
          {
            if (this.val$showType != 2) {
              k.b(paramString2, paramString3, paramString4, 2, "0");
            }
            com.tencent.mm.plugin.sns.device.appstore.e locale = com.tencent.mm.plugin.sns.device.appstore.e.y(paramString1, paramString2, paramString3, paramString4);
            if (locale != null) {
              com.tencent.mm.plugin.sns.device.appstore.d.a(locale);
            }
            AppMethodBeat.o(219243);
            return;
          }
          if (this.val$showType != 2) {
            k.b(paramString2, paramString3, paramString4, 2, "2");
          }
          AppMethodBeat.o(219243);
        }
      }, paramInt);
      AppMethodBeat.o(219255);
      return;
    }
    catch (Throwable paramContext)
    {
      b(paramString2, paramString3, paramString4, 2, "1");
      AppMethodBeat.o(219255);
    }
  }
  
  public static void a(Context paramContext, String paramString1, af paramaf, int paramInt, long paramLong, String paramString2)
  {
    AppMethodBeat.i(219244);
    label442:
    for (;;)
    {
      try
      {
        Intent localIntent = new Intent();
        Object localObject = paramString1;
        if (!TextUtils.isEmpty(paramaf.jWi))
        {
          localObject = paramString1;
          if (!TextUtils.isEmpty(paramaf.zMk)) {
            localObject = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.an.n(paramString1, new String[] { "traceid=" + paramaf.jWi + "&aid=" + paramaf.zMk });
          }
        }
        paramString1 = paramaf.zRP;
        if (TextUtils.isEmpty(paramString1))
        {
          paramString1 = paramaf.dGD;
          ae.i("SnsAdUtil", "adLandingJumpWebPageUI, use orig_UxInfo:".concat(String.valueOf(paramString1)));
          localObject = r.jo((String)localObject, paramString1);
          r.g(localIntent, paramString1);
          localObject = com.tencent.mm.plugin.sns.ad.b.a.a.ayT((String)localObject);
          ae.i("SnsAdUtil", "open url %s", new Object[] { localObject });
          localIntent.putExtra("rawUrl", (String)localObject);
          localIntent.putExtra("useJs", true);
          localIntent.putExtra("type", -255);
          localIntent.putExtra("geta8key_scene", 2);
          if (paramaf.bizId == 0)
          {
            localObject = new SnsAdClick(paramInt, paramLong);
            Bundle localBundle = new Bundle();
            localBundle.putParcelable("KSnsAdTag", (Parcelable)localObject);
            if (!TextUtils.isEmpty(paramString1)) {
              localBundle.putString("KAnsUxInfo", paramString1);
            }
            localIntent.putExtra("jsapiargs", localBundle);
          }
          if (((paramContext instanceof Activity)) && (paramaf.bizId == 2))
          {
            paramaf = ((Activity)paramContext).getIntent().getStringExtra("sns_landing_pages_sessionId");
            paramString1 = ((Activity)paramContext).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
            if (!bu.isNullOrNil(paramaf))
            {
              paramLong = System.currentTimeMillis() / 1000L;
              if (bu.isNullOrNil(paramString1)) {
                break label442;
              }
              paramString1 = String.format("official_mall_%s_%s_%s_%s", new Object[] { paramString1, paramaf, paramString2, String.valueOf(paramLong) });
              localIntent.putExtra("prePublishId", paramString1);
              localIntent.putExtra("KPublisherId", paramString1);
              localIntent.putExtra("pay_channel", 47);
            }
          }
          com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
          AppMethodBeat.o(219244);
        }
        else
        {
          ae.i("SnsAdUtil", "adLandingJumpWebPageUI, use updated_UxInfo:".concat(String.valueOf(paramString1)));
          continue;
        }
        paramString1 = "";
      }
      catch (Throwable paramContext)
      {
        ae.e("SnsAdUtil", "adLandingJumpWebPageUI exp=" + paramContext.toString());
        AppMethodBeat.o(219244);
        return;
      }
    }
  }
  
  public static void a(SnsAdClick paramSnsAdClick, j paramj, p paramp, int paramInt)
  {
    long l2 = 0L;
    AppMethodBeat.i(219249);
    try
    {
      StringBuilder localStringBuilder = new StringBuilder("appendSnsAdClickParams, snsAdStatistic==null?");
      boolean bool;
      if (paramj == null)
      {
        bool = true;
        ae.d("SnsAdUtil", bool + ", clickPos=" + paramInt);
        if (paramj != null) {
          break label93;
        }
        l1 = 0L;
        label60:
        paramSnsAdClick.ipU = l1;
        if (paramj != null) {
          break label107;
        }
      }
      label93:
      label107:
      for (long l1 = l2;; l1 = paramj.zQ(paramp.field_snsId))
      {
        paramSnsAdClick.ipV = l1;
        AppMethodBeat.o(219249);
        return;
        bool = false;
        break;
        l1 = paramj.eY(paramp.eco(), paramInt);
        break label60;
      }
      return;
    }
    catch (Exception paramSnsAdClick)
    {
      ae.e("SnsAdUtil", "appendSnsAdClickParams exp=" + paramSnsAdClick.toString() + ", clockPos=" + paramInt);
      AppMethodBeat.o(219249);
    }
  }
  
  private static boolean a(Context paramContext, p paramp, com.tencent.mm.plugin.sns.storage.a parama)
  {
    AppMethodBeat.i(219252);
    if ((paramp != null) && (parama != null)) {}
    for (;;)
    {
      try
      {
        if (parama.zMx != null)
        {
          if (!com.tencent.mm.pluginsdk.model.app.q.s(paramContext, parama.zMx.Lw)) {
            continue;
          }
          ae.i("SnsAdUtil", "checkOpenApp isInstalled=true, " + parama.zMx.toString());
          String str = "";
          if (paramp.dVj() != null) {
            str = paramp.dVj().zsJ;
          }
          boolean bool = a(paramContext, parama.zMx.appId, parama.zMx.Lw, parama.zMx.appName, parama.zMx.zMz, parama.dGD, str, String.valueOf(paramp.field_snsId), 2, 0);
          if (bool)
          {
            AppMethodBeat.o(219252);
            return true;
          }
          ae.e("SnsAdUtil", "checkOpenApp failed, " + parama.zMx.toString());
          jn(parama.zMx.Lw, parama.zMx.zMz);
        }
      }
      catch (Throwable paramContext)
      {
        ae.e("SnsAdUtil", "checkOpenApp exp=" + paramContext.toString());
        continue;
      }
      AppMethodBeat.o(219252);
      return false;
      ae.e("SnsAdUtil", "checkOpenApp isInstalled=false, " + parama.zMx.toString());
      jn(parama.zMx.Lw, parama.zMx.zMz);
    }
  }
  
  private static boolean a(Context paramContext, p paramp, com.tencent.mm.plugin.sns.storage.a parama, int paramInt)
  {
    AppMethodBeat.i(219254);
    if ((paramContext == null) || (paramp == null) || (parama == null))
    {
      ae.e("SnsAdUtil", "tryProcessAdAppMarket input param is wrong");
      AppMethodBeat.o(219254);
      return false;
    }
    String str3 = "";
    String str4 = "";
    String str2 = "";
    String str1;
    if (parama.zMx != null)
    {
      str1 = parama.zMx.appName;
      str3 = parama.zMx.appId;
      str4 = parama.zMx.zMz;
      str2 = parama.zMx.Lw;
    }
    for (;;)
    {
      com.tencent.mm.plugin.sns.storage.b localb = paramp.dVj();
      String str5;
      Object localObject;
      if ((localb != null) && (localb.zNW == 1))
      {
        str5 = localb.zsJ;
        localObject = localb.zNV;
        if ((!TextUtils.isEmpty(str2)) || (localObject == null)) {
          break label389;
        }
        str2 = z.getStringExtra(localb.zNV, "target_app_id");
      }
      label389:
      for (;;)
      {
        if (str2 == null)
        {
          ae.e("SnsAdUtil", "the target package is empty!");
          AppMethodBeat.o(219254);
          return false;
        }
        if (paramInt == 1) {}
        for (int i = 2; com.tencent.mm.pluginsdk.model.app.q.s(paramContext, str2); i = 0)
        {
          localObject = str1;
          if (TextUtils.isEmpty(str1)) {
            localObject = com.tencent.mm.plugin.sns.a.a.a.bf(paramContext, str2);
          }
          a(paramContext, str3, str2, (String)localObject, str4, parama.dGD, str5, String.valueOf(paramp.field_snsId), paramInt, i);
          AppMethodBeat.o(219254);
          return true;
        }
        if (com.tencent.mm.plugin.sns.device.appstore.a.aK((Intent)localObject)) {
          b(String.valueOf(paramp.field_snsId), parama.dGD, str5, 4, "0");
        }
        for (;;)
        {
          if (!com.tencent.mm.plugin.sns.device.appstore.a.aL((Intent)localObject)) {
            break label354;
          }
          b(String.valueOf(paramp.field_snsId), parama.dGD, str5, 1, "0");
          a(paramContext, (Intent)localObject, str2, String.valueOf(paramp.field_snsId), parama.dGD, str5, i);
          break;
          b(String.valueOf(paramp.field_snsId), parama.dGD, str5, 4, "1");
        }
        label354:
        b(String.valueOf(paramp.field_snsId), parama.dGD, str5, 1, "1");
        AppMethodBeat.o(219254);
        return false;
        AppMethodBeat.o(219254);
        return false;
      }
      str1 = "";
    }
  }
  
  public static boolean a(Context paramContext, p paramp, com.tencent.mm.plugin.sns.storage.a parama, int paramInt, j paramj)
  {
    int i = 2;
    AppMethodBeat.i(219251);
    if ((paramp == null) || (parama == null))
    {
      AppMethodBeat.o(219251);
      return false;
    }
    try
    {
      if (a(paramContext, paramp, parama))
      {
        ae.i("SnsAdUtil", "handleAdClickAction, checkOpenApp succ");
        if (paramInt == 0) {
          i = 1;
        }
        paramContext = new SnsAdClick(paramInt, i, paramp.field_snsId, 22, 34);
        a(paramContext, paramj, paramp, 22);
        r.a(paramContext);
        AppMethodBeat.o(219251);
        return true;
      }
      if (a(paramContext, paramp, parama, 2))
      {
        ae.i("SnsAdUtil", "handleAdClickAction, tryProcessAdAppMarket succ");
        if (paramInt == 0) {
          i = 1;
        }
        paramContext = new SnsAdClick(paramInt, i, paramp.field_snsId, 22, 36);
        a(paramContext, paramj, paramp, 22);
        r.a(paramContext);
        AppMethodBeat.o(219251);
        return true;
      }
      com.tencent.mm.plugin.sns.storage.b localb = paramp.dVj();
      if ((localb != null) && (localb.zNZ != null) && (parama != null) && (parama.zLR == 8)) {
        com.tencent.mm.plugin.sns.ad.c.e.a(paramContext, localb.zNZ, parama.dGD);
      }
      for (int j = 1; j != 0; j = 0)
      {
        ae.i("SnsAdUtil", "handleAdClickAction, checkJumpScan succ");
        if (paramInt == 0) {
          i = 1;
        }
        paramContext = new SnsAdClick(paramInt, i, paramp.field_snsId, 22, 35);
        a(paramContext, paramj, paramp, 22);
        r.a(paramContext);
        AppMethodBeat.o(219251);
        return true;
      }
      return false;
    }
    catch (Throwable paramContext)
    {
      ae.e("SnsAdUtil", "handleAdClickAction, exp=" + paramContext.toString());
      AppMethodBeat.o(219251);
    }
  }
  
  public static boolean a(Context paramContext, final String paramString1, final String paramString2, final String paramString3, final String paramString4, final String paramString5, final String paramString6, final String paramString7, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(219250);
    ae.i("SnsAdUtil", "openApp, appId = " + paramString1 + ", uxInfo = " + paramString5 + ", adExtInfo = " + paramString6);
    if ((paramContext == null) || (TextUtils.isEmpty(paramString2)))
    {
      ae.e("SnsAdUtil", "openApp, failed");
      AppMethodBeat.o(219250);
      return false;
    }
    if (paramInt2 != 2) {
      i.a(paramString7, paramString1, 0, 2, paramString5, paramString6, paramInt1);
    }
    if (!TextUtils.isEmpty(paramString4))
    {
      paramString4 = new Intent("android.intent.action.VIEW", Uri.parse(paramString4));
      paramString4.addFlags(268435456);
      paramString2 = bu.ac(paramContext, paramString4);
      if ((paramString2 != null) && (!paramString2.isEmpty()))
      {
        if ((!TextUtils.isEmpty(paramString4.getPackage())) || (paramString2.size() != 1)) {
          break label241;
        }
        paramString2 = h.b((ResolveInfo)paramString2.get(0));
        if (!bu.nullAsNil(ak.getPackageName()).equals(paramString2)) {
          com.tencent.mm.ch.a.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(219240);
              h.a(this.val$context, paramString4, paramString3, paramInt2, new al()
              {
                public final void v(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
                {
                  AppMethodBeat.i(219239);
                  if ((paramAnonymous2Boolean1) && (k.1.this.val$showType != 2)) {
                    i.a(k.1.this.iwu, k.1.this.val$appId, 1, 2, k.1.this.ztT, k.1.this.ztU, k.1.this.ztV);
                  }
                  if (!paramAnonymous2Boolean1) {
                    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.an.gq(k.1.this.val$context);
                  }
                  AppMethodBeat.o(219239);
                }
              }, null);
              AppMethodBeat.o(219240);
            }
          });
        }
      }
    }
    for (;;)
    {
      AdLandingPagesProxy.getInstance().reportDownloadInfo(9, paramString1);
      AppMethodBeat.o(219250);
      return true;
      label241:
      paramString2 = paramString4.getPackage();
      break;
      com.tencent.mm.ch.a.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(219242);
          Intent localIntent = this.val$context.getPackageManager().getLaunchIntentForPackage(paramString2);
          h.a(this.val$context, localIntent, paramString3, paramInt2, new al()
          {
            public final void v(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
            {
              AppMethodBeat.i(219241);
              if ((paramAnonymous2Boolean1) && (k.2.this.val$showType != 2)) {
                i.a(k.2.this.iwu, k.2.this.val$appId, 1, 2, k.2.this.ztT, k.2.this.ztU, k.2.this.ztV);
              }
              if (!paramAnonymous2Boolean1) {
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.an.gq(k.2.this.val$context);
              }
              AppMethodBeat.o(219241);
            }
          }, null);
          AppMethodBeat.o(219242);
        }
      });
    }
  }
  
  public static boolean a(p paramp, int paramInt)
  {
    AppMethodBeat.i(219259);
    if (paramInt == 2) {}
    for (paramp = paramp.ebM(); (paramp == null) || (paramp.zMn == null); paramp = paramp.dVi())
    {
      AppMethodBeat.o(219259);
      return false;
    }
    if (paramp.zLR != 4)
    {
      AppMethodBeat.o(219259);
      return false;
    }
    if (bu.isNullOrNil(paramp.zMn.duJ))
    {
      AppMethodBeat.o(219259);
      return false;
    }
    AppMethodBeat.o(219259);
    return true;
  }
  
  public static boolean a(SnsObject paramSnsObject, String paramString)
  {
    AppMethodBeat.i(219245);
    for (;;)
    {
      try
      {
        Iterator localIterator = paramSnsObject.CommentUserList.iterator();
        if (!localIterator.hasNext()) {
          break label239;
        }
        dgh localdgh = (dgh)localIterator.next();
        if ((localdgh == null) || (bu.isNullOrNil(localdgh.Username)) || (!localdgh.Username.equals(paramString))) {
          continue;
        }
        bool1 = true;
        localIterator = paramSnsObject.LikeUserList.iterator();
        if (localIterator.hasNext())
        {
          localdgh = (dgh)localIterator.next();
          if ((localdgh == null) || (bu.isNullOrNil(localdgh.Username)) || (!localdgh.Username.equals(paramString))) {
            continue;
          }
          bool2 = true;
          ae.i("SnsAdUtil", "isAdCommentOrLikedBySelf, snsId=" + r.zV(paramSnsObject.Id) + ", hasComment=" + bool1 + ", hasLiked=" + bool2);
          if ((bool1) || (bool2))
          {
            AppMethodBeat.o(219245);
            return true;
          }
          AppMethodBeat.o(219245);
          return false;
        }
      }
      catch (Exception paramSnsObject)
      {
        ae.e("SnsAdUtil", "isAdCommentOrLikedBySelf, exp=" + paramSnsObject.toString());
        AppMethodBeat.o(219245);
        return false;
      }
      boolean bool2 = false;
      continue;
      label239:
      boolean bool1 = false;
    }
  }
  
  public static JSONObject aK(Map<String, Object> paramMap)
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
  
  public static String aaA()
  {
    AppMethodBeat.i(219258);
    try
    {
      String str = ((TelephonyManager)ak.getContext().getSystemService("phone")).getDeviceId();
      AppMethodBeat.o(219258);
      return str;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(219258);
    }
    return "";
  }
  
  public static long aze(String paramString)
  {
    AppMethodBeat.i(219246);
    try
    {
      boolean bool = bu.isNullOrNil(paramString);
      if (bool)
      {
        AppMethodBeat.o(219246);
        return 0L;
      }
      if (paramString.startsWith("ad_table_"))
      {
        l = bu.aSC(paramString.substring(9));
        AppMethodBeat.o(219246);
        return l;
      }
      if (paramString.startsWith("sns_table_"))
      {
        l = bu.aSC(paramString.substring(10));
        AppMethodBeat.o(219246);
        return l;
      }
      long l = r.azz(paramString);
      AppMethodBeat.o(219246);
      return l;
    }
    catch (Throwable paramString)
    {
      ae.e("SnsAdUtil", paramString.toString());
      AppMethodBeat.o(219246);
    }
    return 0L;
  }
  
  public static String azf(String paramString)
  {
    AppMethodBeat.i(219261);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(219261);
      return "";
    }
    paramString = paramString.split("\\|");
    if ((paramString != null) && (paramString.length > 0))
    {
      paramString = paramString[0];
      AppMethodBeat.o(219261);
      return paramString;
    }
    AppMethodBeat.o(219261);
    return "";
  }
  
  public static s azg(String paramString)
  {
    AppMethodBeat.i(219262);
    s locals = new s();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        locals.pageId = paramString.optString("canvasId");
        locals.dGD = paramString.optString("uxInfo");
        paramString = locals.dGD;
        if (!bu.isNullOrNil(paramString)) {
          continue;
        }
        ae.e("SnsAdUtil", "uxInfo is null");
        paramString = "";
        locals.kwE = paramString;
        ae.i("SnsAdUtil", "pageId = " + locals.pageId + ", uxInfo = " + locals.dGD + ", adInfoXml = " + locals.kwE);
      }
      catch (Throwable paramString)
      {
        StringBuilder localStringBuilder;
        ae.e("SnsAdUtil", paramString.toString());
        continue;
      }
      AppMethodBeat.o(219262);
      return locals;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("<ADInfo><uxInfo>").append(paramString).append("</uxInfo></ADInfo>");
      paramString = localStringBuilder.toString();
    }
  }
  
  public static boolean azh(String paramString)
  {
    AppMethodBeat.i(219263);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("<usePreferedInfo>1</usePreferedInfo>")))
    {
      AppMethodBeat.o(219263);
      return true;
    }
    AppMethodBeat.o(219263);
    return false;
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    AppMethodBeat.i(219256);
    ArrayMap localArrayMap = new ArrayMap();
    localArrayMap.put("outSns", Integer.valueOf(1));
    com.tencent.mm.plugin.sns.device.appstore.a.a(paramString1, paramString2, paramString3, paramInt, paramString4, localArrayMap);
    AppMethodBeat.o(219256);
  }
  
  public static boolean b(Context paramContext, p paramp, com.tencent.mm.plugin.sns.storage.a parama)
  {
    AppMethodBeat.i(219253);
    try
    {
      boolean bool = a(paramContext, paramp, parama, 0);
      AppMethodBeat.o(219253);
      return bool;
    }
    catch (Throwable paramContext)
    {
      ae.w("SnsAdUtil", "processAdAppMarket has something wrong");
      AppMethodBeat.o(219253);
    }
    return false;
  }
  
  public static boolean d(TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(176239);
    if ((paramTimeLineObject != null) && (paramTimeLineObject.HUG != null) && (paramTimeLineObject.HUG.Gtx != null) && (paramTimeLineObject.HUG.Gtx.size() > 0))
    {
      paramTimeLineObject = (bzh)paramTimeLineObject.HUG.Gtx.get(0);
      if ((paramTimeLineObject != null) && (paramTimeLineObject.Hmm != null) && (paramTimeLineObject.Hmm.Hna > 0.0F) && (paramTimeLineObject.Hmm.Hnb > 0.0F))
      {
        int i = (int)paramTimeLineObject.Hmm.Hna;
        if ((int)paramTimeLineObject.Hmm.Hnb > i)
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
  
  public static String eR(View paramView)
  {
    AppMethodBeat.i(176242);
    paramView = "[" + paramView.getPaddingLeft() + "," + paramView.getPaddingTop() + "," + paramView.getPaddingRight() + "," + paramView.getPaddingBottom() + "]";
    AppMethodBeat.o(176242);
    return paramView;
  }
  
  public static void jm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(176241);
    try
    {
      if (ak.coh())
      {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.d locald = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.d(paramString1, paramString2);
        g.ajS();
        g.ajQ().gDv.a(locald, 0);
        ae.i("SnsAdUtil", "adChannelCgiReport, main, channel=" + paramString1 + ", content=" + paramString2);
        AppMethodBeat.o(176241);
        return;
      }
      if (ak.foC())
      {
        AdLandingPagesProxy.getInstance().onAdLandingPageClick(paramString1, paramString2);
        ae.i("SnsAdUtil", "adChannelCgiReport, tools, channel=" + paramString1 + ", content=" + paramString2);
        AppMethodBeat.o(176241);
        return;
      }
    }
    catch (Exception paramString1)
    {
      ae.e("SnsAdUtil", "adChannelCgiReport, exp=" + paramString1.toString());
      AppMethodBeat.o(176241);
      return;
    }
    ae.e("SnsAdUtil", "adChannelCgiReport, process err");
    AppMethodBeat.o(176241);
  }
  
  public static void jn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(219257);
    ae.i("SnsAdUtil", "writeDelayDeepLink, pkg=" + paramString1 + ", pageUrl=" + paramString2);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(219257);
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("wx_ad_pkgname", paramString1);
      localJSONObject.put("wx_ad_deeplink", paramString2);
      ((ClipboardManager)ak.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("wx_ad_deeplink", localJSONObject.toString()));
      AppMethodBeat.o(219257);
      return;
    }
    catch (Throwable paramString1)
    {
      ae.e("SnsAdUtil", "writeDelayDeepLink exp=" + paramString1.toString());
      AppMethodBeat.o(219257);
    }
  }
  
  public static int k(p paramp)
  {
    AppMethodBeat.i(219247);
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
        if (paramp.Rt(32))
        {
          j = m;
          paramp = paramp.dVj();
          i = k;
          if (paramp != null)
          {
            i = k;
            j = m;
            if (!TextUtils.isEmpty(paramp.zNU))
            {
              j = m;
              long l = System.currentTimeMillis();
              j = m;
              if (!com.tencent.mm.pluginsdk.model.app.q.s(ak.getContext(), paramp.zNU)) {
                continue;
              }
              i = 2;
              j = i;
              ae.i("SnsAdUtil", "getAdAppInstallStatus, pkg=" + paramp.zNU + ", installState=" + i + ", timeCost=" + (System.currentTimeMillis() - l));
            }
          }
        }
      }
      catch (Throwable paramp)
      {
        ae.e("SnsAdUtil", "appInstalled exp=" + paramp.toString());
        i = j;
        continue;
      }
      AppMethodBeat.o(219247);
      return i;
      i = 1;
    }
  }
  
  public static int l(p paramp)
  {
    AppMethodBeat.i(219248);
    str1 = "";
    try
    {
      str2 = paramp.field_userName;
      l = System.currentTimeMillis();
      if ((paramp == null) || (!paramp.Rt(32)) || (TextUtils.isEmpty(str2))) {
        break label211;
      }
      g.ajS();
      paramp = ((l)g.ab(l.class)).azF().BH(str2);
      if (paramp == null) {
        break label211;
      }
      if ((int)paramp.ght <= 0) {
        break label206;
      }
      boolean bool = c.lO(paramp.field_type);
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
          paramp = paramp.adF();
          j = i;
          ae.i("SnsAdUtil", "getAdUserFollowStatus, userName=" + str2 + ", followStatus=" + i + ", displayName=" + paramp + ", timeCost=" + (System.currentTimeMillis() - l));
          AppMethodBeat.o(219248);
          return i;
        }
        catch (Throwable paramp)
        {
          int j;
          continue;
        }
        paramp = paramp;
        j = 1;
        ae.e("SnsAdUtil", "isContact exp=" + paramp.toString());
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
  
  public static boolean m(p paramp)
  {
    boolean bool = true;
    AppMethodBeat.i(219260);
    if (paramp == null)
    {
      AppMethodBeat.o(219260);
      return false;
    }
    try
    {
      com.tencent.mm.plugin.sns.storage.b localb = paramp.dVj();
      int i = localb.zOc;
      if (i == 1)
      {
        AppMethodBeat.o(219260);
        return true;
      }
      i = localb.zOc;
      if (i == 0)
      {
        AppMethodBeat.o(219260);
        return false;
      }
      if ((localb.dZv()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.aBm(paramp.ecy().field_adxml))) {
        if (!bool) {
          break label102;
        }
      }
      label102:
      for (localb.zOc = 1;; localb.zOc = 0)
      {
        AppMethodBeat.o(219260);
        return bool;
        bool = false;
        break;
      }
      return false;
    }
    catch (Throwable paramp)
    {
      ae.e("SnsAdUtil", paramp.toString());
      AppMethodBeat.o(219260);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.k
 * JD-Core Version:    0.7.0.1
 */