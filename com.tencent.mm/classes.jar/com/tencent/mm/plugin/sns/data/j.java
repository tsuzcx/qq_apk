package com.tencent.mm.plugin.sns.data;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.sns.ad.d.i;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.bub;
import com.tencent.mm.protocal.protobuf.daa;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bj;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class j
{
  private static void a(Context paramContext, Intent paramIntent, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(200054);
    if ((paramContext == null) || (paramIntent == null))
    {
      ac.e("SnsAdUtil", "startMarketActivity input param is error");
      AppMethodBeat.o(200054);
      return;
    }
    try
    {
      if (!(paramContext instanceof Activity)) {
        paramIntent.addFlags(268435456);
      }
      String str = bs.bG(x.getStringExtra(paramIntent, "market_app_name"), "");
      al.a(paramContext, paramIntent.getPackage(), "", paramIntent, str, new j.1(paramString2, paramString3, paramString4, paramString1));
      AppMethodBeat.o(200054);
      return;
    }
    catch (Throwable paramContext)
    {
      b(paramString2, paramString3, paramString4, 2, "1");
      AppMethodBeat.o(200054);
    }
  }
  
  public static void a(Context paramContext, String paramString1, ae paramae, int paramInt, long paramLong, String paramString2)
  {
    AppMethodBeat.i(200044);
    label433:
    for (;;)
    {
      try
      {
        Intent localIntent = new Intent();
        Object localObject = paramString1;
        if (!TextUtils.isEmpty(paramae.jyU))
        {
          localObject = paramString1;
          if (!TextUtils.isEmpty(paramae.yeO)) {
            localObject = al.n(paramString1, new String[] { "traceid=" + paramae.jyU + "&aid=" + paramae.yeO });
          }
        }
        paramString1 = paramae.yka;
        if (TextUtils.isEmpty(paramString1))
        {
          paramString1 = paramae.dtx;
          ac.i("SnsAdUtil", "adLandingJumpWebPageUI, use orig_UxInfo:".concat(String.valueOf(paramString1)));
          localObject = q.iV((String)localObject, paramString1);
          q.g(localIntent, paramString1);
          ac.i("SnsAdUtil", "open url %s", new Object[] { localObject });
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
            if (!bs.isNullOrNil(paramae))
            {
              paramLong = System.currentTimeMillis() / 1000L;
              if (bs.isNullOrNil(paramString1)) {
                break label433;
              }
              paramString1 = String.format("official_mall_%s_%s_%s_%s", new Object[] { paramString1, paramae, paramString2, String.valueOf(paramLong) });
              localIntent.putExtra("prePublishId", paramString1);
              localIntent.putExtra("KPublisherId", paramString1);
              localIntent.putExtra("pay_channel", 47);
            }
          }
          com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
          AppMethodBeat.o(200044);
        }
        else
        {
          ac.i("SnsAdUtil", "adLandingJumpWebPageUI, use updated_UxInfo:".concat(String.valueOf(paramString1)));
          continue;
        }
        paramString1 = "";
      }
      catch (Throwable paramContext)
      {
        ac.e("SnsAdUtil", "adLandingJumpWebPageUI exp=" + paramContext.toString());
        AppMethodBeat.o(200044);
        return;
      }
    }
  }
  
  public static void a(SnsAdClick paramSnsAdClick, i parami, p paramp, int paramInt)
  {
    long l2 = 0L;
    AppMethodBeat.i(200049);
    try
    {
      StringBuilder localStringBuilder = new StringBuilder("appendSnsAdClickParams, snsAdStatistic==null?");
      boolean bool;
      if (parami == null)
      {
        bool = true;
        ac.d("SnsAdUtil", bool + ", clickPos=" + paramInt);
        if (parami != null) {
          break label90;
        }
        l1 = 0L;
        label58:
        paramSnsAdClick.hTG = l1;
        if (parami != null) {
          break label104;
        }
      }
      label90:
      label104:
      for (long l1 = l2;; l1 = parami.wR(paramp.field_snsId))
      {
        paramSnsAdClick.hTH = l1;
        AppMethodBeat.o(200049);
        return;
        bool = false;
        break;
        l1 = parami.ex(paramp.dMu(), paramInt);
        break label58;
      }
      return;
    }
    catch (Exception paramSnsAdClick)
    {
      ac.e("SnsAdUtil", "appendSnsAdClickParams exp=" + paramSnsAdClick.toString() + ", clockPos=" + paramInt);
      AppMethodBeat.o(200049);
    }
  }
  
  private static boolean a(Context paramContext, p paramp, com.tencent.mm.plugin.sns.storage.a parama)
  {
    AppMethodBeat.i(210260);
    if ((paramp != null) && (parama != null)) {}
    for (;;)
    {
      try
      {
        if (parama.yfb != null)
        {
          if (!com.tencent.mm.pluginsdk.model.app.q.t(paramContext, parama.yfb.JG)) {
            continue;
          }
          ac.i("SnsAdUtil", "checkOpenApp isInstalled=true, " + parama.yfb.toString());
          String str = "";
          if (paramp.dFR() != null) {
            str = paramp.dFR().xOm;
          }
          boolean bool = a(paramContext, parama.yfb.appId, parama.yfb.JG, parama.yfb.appName, parama.yfb.yfc, parama.dtx, str, String.valueOf(paramp.field_snsId), 2);
          if (bool)
          {
            AppMethodBeat.o(210260);
            return true;
          }
          ac.e("SnsAdUtil", "checkOpenApp failed, " + parama.yfb.toString());
        }
      }
      catch (Throwable paramContext)
      {
        ac.e("SnsAdUtil", "checkOpenApp exp=" + paramContext.toString());
        continue;
      }
      AppMethodBeat.o(210260);
      return false;
      ac.e("SnsAdUtil", "checkOpenApp isInstalled=false, " + parama.yfb.toString());
    }
  }
  
  private static boolean a(Context paramContext, p paramp, com.tencent.mm.plugin.sns.storage.a parama, int paramInt)
  {
    AppMethodBeat.i(210262);
    if ((paramContext == null) || (paramp == null) || (parama == null))
    {
      ac.e("SnsAdUtil", "tryProcessAdAppMarket input param is wrong");
      AppMethodBeat.o(210262);
      return false;
    }
    String str3 = "";
    String str4 = "";
    String str2 = "";
    String str1;
    if (parama.yfb != null)
    {
      str1 = parama.yfb.appName;
      str3 = parama.yfb.appId;
      str4 = parama.yfb.yfc;
      str2 = parama.yfb.JG;
    }
    for (;;)
    {
      com.tencent.mm.plugin.sns.storage.b localb = paramp.dFR();
      String str5;
      Object localObject;
      if ((localb != null) && (localb.ygz == 1))
      {
        str5 = localb.xOm;
        localObject = localb.ygy;
        if ((!TextUtils.isEmpty(str2)) || (localObject == null)) {
          break label371;
        }
        str2 = x.getStringExtra(localb.ygy, "target_app_id");
      }
      label336:
      label371:
      for (;;)
      {
        if (str2 == null)
        {
          ac.e("SnsAdUtil", "the target package is empty!");
          AppMethodBeat.o(210262);
          return false;
        }
        if (com.tencent.mm.pluginsdk.model.app.q.t(paramContext, str2))
        {
          localObject = str1;
          if (TextUtils.isEmpty(str1)) {
            localObject = com.tencent.mm.plugin.sns.a.a.a.ba(paramContext, str2);
          }
          a(paramContext, str3, str2, (String)localObject, str4, parama.dtx, str5, String.valueOf(paramp.field_snsId), paramInt);
          AppMethodBeat.o(210262);
          return true;
        }
        if (com.tencent.mm.plugin.sns.device.appstore.a.aE((Intent)localObject)) {
          b(String.valueOf(paramp.field_snsId), parama.dtx, str5, 4, "0");
        }
        for (;;)
        {
          if (!com.tencent.mm.plugin.sns.device.appstore.a.aF((Intent)localObject)) {
            break label336;
          }
          b(String.valueOf(paramp.field_snsId), parama.dtx, str5, 1, "0");
          a(paramContext, (Intent)localObject, str2, String.valueOf(paramp.field_snsId), parama.dtx, str5);
          break;
          b(String.valueOf(paramp.field_snsId), parama.dtx, str5, 4, "1");
        }
        b(String.valueOf(paramp.field_snsId), parama.dtx, str5, 1, "1");
        AppMethodBeat.o(210262);
        return false;
        AppMethodBeat.o(210262);
        return false;
      }
      str1 = "";
    }
  }
  
  public static boolean a(Context paramContext, p paramp, com.tencent.mm.plugin.sns.storage.a parama, int paramInt, i parami)
  {
    int i = 2;
    AppMethodBeat.i(210259);
    if ((paramp == null) || (parama == null))
    {
      AppMethodBeat.o(210259);
      return false;
    }
    try
    {
      if (a(paramContext, paramp, parama))
      {
        ac.i("SnsAdUtil", "handleAdClickAction, checkOpenApp succ");
        if (paramInt == 0) {
          i = 1;
        }
        paramContext = new SnsAdClick(paramInt, i, paramp.field_snsId, 22, 34);
        a(paramContext, parami, paramp, 22);
        q.a(paramContext);
        AppMethodBeat.o(210259);
        return true;
      }
      if (a(paramContext, paramp, parama, 2))
      {
        ac.i("SnsAdUtil", "handleAdClickAction, tryProcessAdAppMarket succ");
        if (paramInt == 0) {
          i = 1;
        }
        paramContext = new SnsAdClick(paramInt, i, paramp.field_snsId, 22, 36);
        a(paramContext, parami, paramp, 22);
        q.a(paramContext);
        AppMethodBeat.o(210259);
        return true;
      }
      com.tencent.mm.plugin.sns.storage.b localb = paramp.dFR();
      if ((localb != null) && (localb.ygA != null) && (parama != null) && (parama.yez == 8)) {
        com.tencent.mm.plugin.sns.ad.a.a.a(paramContext, localb.ygA, parama.dtx);
      }
      for (int j = 1; j != 0; j = 0)
      {
        ac.i("SnsAdUtil", "handleAdClickAction, checkJumpScan succ");
        if (paramInt == 0) {
          i = 1;
        }
        paramContext = new SnsAdClick(paramInt, i, paramp.field_snsId, 22, 35);
        a(paramContext, parami, paramp, 22);
        q.a(paramContext);
        AppMethodBeat.o(210259);
        return true;
      }
      return false;
    }
    catch (Throwable paramContext)
    {
      ac.e("SnsAdUtil", "handleAdClickAction, exp=" + paramContext.toString());
      AppMethodBeat.o(210259);
    }
  }
  
  public static boolean a(Context paramContext, final String paramString1, final String paramString2, final String paramString3, String paramString4, final String paramString5, final String paramString6, final String paramString7, final int paramInt)
  {
    AppMethodBeat.i(210258);
    ac.i("SnsAdUtil", "openApp, appId = " + paramString1 + ", uxInfo = " + paramString5 + ", adExtInfo = " + paramString6);
    if ((paramContext == null) || (TextUtils.isEmpty(paramString2)))
    {
      ac.e("SnsAdUtil", "openApp, failed");
      AppMethodBeat.o(210258);
      return false;
    }
    h.a(paramString7, paramString1, 0, 2, paramString5, paramString6, paramInt);
    if (!TextUtils.isEmpty(paramString4))
    {
      paramString4 = new Intent("android.intent.action.VIEW", Uri.parse(paramString4));
      paramString4.addFlags(268435456);
      paramString2 = bs.aa(paramContext, paramString4);
      if ((paramString2 != null) && (!paramString2.isEmpty()))
      {
        if ((!TextUtils.isEmpty(paramString4.getPackage())) || (paramString2.size() != 1)) {
          break label233;
        }
        paramString2 = com.tencent.mm.pluginsdk.model.app.h.b((ResolveInfo)paramString2.get(0));
        if (!bs.nullAsNil(com.tencent.mm.sdk.platformtools.ai.getPackageName()).equals(paramString2)) {
          com.tencent.mm.ci.a.post(new j.2(paramContext, paramString4, paramString3, paramString7, paramString1, paramString5, paramString6, paramInt));
        }
      }
    }
    for (;;)
    {
      AdLandingPagesProxy.getInstance().reportDownloadInfo(9, paramString1);
      AppMethodBeat.o(210258);
      return true;
      label233:
      paramString2 = paramString4.getPackage();
      break;
      com.tencent.mm.ci.a.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(210256);
          Intent localIntent = this.val$context.getPackageManager().getLaunchIntentForPackage(paramString2);
          com.tencent.mm.pluginsdk.model.app.h.a(this.val$context, localIntent, paramString3, new j.3.1(this));
          AppMethodBeat.o(210256);
        }
      });
    }
  }
  
  public static boolean a(SnsObject paramSnsObject, String paramString)
  {
    AppMethodBeat.i(200045);
    for (;;)
    {
      try
      {
        Iterator localIterator = paramSnsObject.CommentUserList.iterator();
        if (!localIterator.hasNext()) {
          break label239;
        }
        daa localdaa = (daa)localIterator.next();
        if ((localdaa == null) || (bs.isNullOrNil(localdaa.Username)) || (!localdaa.Username.equals(paramString))) {
          continue;
        }
        bool1 = true;
        localIterator = paramSnsObject.LikeUserList.iterator();
        if (localIterator.hasNext())
        {
          localdaa = (daa)localIterator.next();
          if ((localdaa == null) || (bs.isNullOrNil(localdaa.Username)) || (!localdaa.Username.equals(paramString))) {
            continue;
          }
          bool2 = true;
          ac.i("SnsAdUtil", "isAdCommentOrLikedBySelf, snsId=" + q.wW(paramSnsObject.Id) + ", hasComment=" + bool1 + ", hasLiked=" + bool2);
          if ((bool1) || (bool2))
          {
            AppMethodBeat.o(200045);
            return true;
          }
          AppMethodBeat.o(200045);
          return false;
        }
      }
      catch (Exception paramSnsObject)
      {
        ac.e("SnsAdUtil", "isAdCommentOrLikedBySelf, exp=" + paramSnsObject.toString());
        AppMethodBeat.o(200045);
        return false;
      }
      boolean bool2 = false;
      continue;
      label239:
      boolean bool1 = false;
    }
  }
  
  public static JSONObject aB(Map<String, Object> paramMap)
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
  
  public static long asL(String paramString)
  {
    AppMethodBeat.i(200046);
    try
    {
      boolean bool = bs.isNullOrNil(paramString);
      if (bool)
      {
        AppMethodBeat.o(200046);
        return 0L;
      }
      if (paramString.startsWith("ad_table_"))
      {
        l = bs.aLz(paramString.substring(9));
        AppMethodBeat.o(200046);
        return l;
      }
      if (paramString.startsWith("sns_table_"))
      {
        l = bs.aLz(paramString.substring(10));
        AppMethodBeat.o(200046);
        return l;
      }
      long l = q.atd(paramString);
      AppMethodBeat.o(200046);
      return l;
    }
    catch (Throwable paramString)
    {
      ac.e("SnsAdUtil", paramString.toString());
      AppMethodBeat.o(200046);
    }
    return 0L;
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    AppMethodBeat.i(200055);
    ArrayMap localArrayMap = new ArrayMap();
    localArrayMap.put("outSns", Integer.valueOf(1));
    com.tencent.mm.plugin.sns.device.appstore.a.a(paramString1, paramString2, paramString3, paramInt, paramString4, localArrayMap);
    AppMethodBeat.o(200055);
  }
  
  public static boolean b(Context paramContext, p paramp, com.tencent.mm.plugin.sns.storage.a parama)
  {
    AppMethodBeat.i(210261);
    try
    {
      boolean bool = a(paramContext, paramp, parama, 0);
      AppMethodBeat.o(210261);
      return bool;
    }
    catch (Throwable paramContext)
    {
      ac.w("SnsAdUtil", "processAdAppMarket has something wrong");
      AppMethodBeat.o(210261);
    }
    return false;
  }
  
  public static boolean d(TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(176239);
    if ((paramTimeLineObject != null) && (paramTimeLineObject.FQo != null) && (paramTimeLineObject.FQo.Etz != null) && (paramTimeLineObject.FQo.Etz.size() > 0))
    {
      paramTimeLineObject = (btz)paramTimeLineObject.FQo.Etz.get(0);
      if ((paramTimeLineObject != null) && (paramTimeLineObject.Fjk != null) && (paramTimeLineObject.Fjk.FjY > 0.0F) && (paramTimeLineObject.Fjk.FjZ > 0.0F))
      {
        int i = (int)paramTimeLineObject.Fjk.FjY;
        if ((int)paramTimeLineObject.Fjk.FjZ > i)
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
  
  public static String eC(View paramView)
  {
    AppMethodBeat.i(176242);
    paramView = "[" + paramView.getPaddingLeft() + "," + paramView.getPaddingTop() + "," + paramView.getPaddingRight() + "," + paramView.getPaddingBottom() + "]";
    AppMethodBeat.o(176242);
    return paramView;
  }
  
  public static int i(p paramp)
  {
    AppMethodBeat.i(200047);
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
        if (paramp.Pe(32))
        {
          j = m;
          paramp = paramp.dFR();
          i = k;
          if (paramp != null)
          {
            i = k;
            j = m;
            if (!TextUtils.isEmpty(paramp.ygx))
            {
              j = m;
              long l = System.currentTimeMillis();
              j = m;
              if (!com.tencent.mm.pluginsdk.model.app.q.t(com.tencent.mm.sdk.platformtools.ai.getContext(), paramp.ygx)) {
                continue;
              }
              i = 2;
              j = i;
              ac.i("SnsAdUtil", "getAdAppInstallStatus, pkg=" + paramp.ygx + ", installState=" + i + ", timeCost=" + (System.currentTimeMillis() - l));
            }
          }
        }
      }
      catch (Throwable paramp)
      {
        ac.e("SnsAdUtil", "appInstalled exp=" + paramp.toString());
        i = j;
        continue;
      }
      AppMethodBeat.o(200047);
      return i;
      i = 1;
    }
  }
  
  public static void iU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(176241);
    try
    {
      if (com.tencent.mm.sdk.platformtools.ai.cin())
      {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.d locald = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.d(paramString1, paramString2);
        g.agS();
        g.agQ().ghe.a(locald, 0);
        ac.i("SnsAdUtil", "adChannelCgiReport, main, channel=" + paramString1 + ", content=" + paramString2);
        AppMethodBeat.o(176241);
        return;
      }
      if (com.tencent.mm.sdk.platformtools.ai.eVd())
      {
        AdLandingPagesProxy.getInstance().onAdLandingPageClick(paramString1, paramString2);
        ac.i("SnsAdUtil", "adChannelCgiReport, tools, channel=" + paramString1 + ", content=" + paramString2);
        AppMethodBeat.o(176241);
        return;
      }
    }
    catch (Exception paramString1)
    {
      ac.e("SnsAdUtil", "adChannelCgiReport, exp=" + paramString1.toString());
      AppMethodBeat.o(176241);
      return;
    }
    ac.e("SnsAdUtil", "adChannelCgiReport, process err");
    AppMethodBeat.o(176241);
  }
  
  public static int j(p paramp)
  {
    AppMethodBeat.i(200048);
    str1 = "";
    try
    {
      str2 = paramp.field_userName;
      l = System.currentTimeMillis();
      if ((paramp == null) || (!paramp.Pe(32)) || (TextUtils.isEmpty(str2))) {
        break label211;
      }
      g.agS();
      paramp = ((k)g.ab(k.class)).awB().aNt(str2);
      if (paramp == null) {
        break label211;
      }
      if ((int)paramp.fLJ <= 0) {
        break label206;
      }
      boolean bool = com.tencent.mm.n.b.ln(paramp.field_type);
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
          paramp = paramp.aaR();
          j = i;
          ac.i("SnsAdUtil", "getAdUserFollowStatus, userName=" + str2 + ", followStatus=" + i + ", displayName=" + paramp + ", timeCost=" + (System.currentTimeMillis() - l));
          AppMethodBeat.o(200048);
          return i;
        }
        catch (Throwable paramp)
        {
          int j;
          continue;
        }
        paramp = paramp;
        j = 1;
        ac.e("SnsAdUtil", "isContact exp=" + paramp.toString());
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.j
 * JD-Core Version:    0.7.0.1
 */