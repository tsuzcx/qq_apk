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
import com.tencent.mm.g.c.au;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.sns.device.appstore.e;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.bpk;
import com.tencent.mm.protocal.protobuf.cud;
import com.tencent.mm.protocal.protobuf.cuo;
import com.tencent.mm.protocal.protobuf.dg;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.bg;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class j
{
  private static void a(Context paramContext, Intent paramIntent, final String paramString1, String paramString2, final String paramString3, final String paramString4)
  {
    AppMethodBeat.i(187274);
    if ((paramContext == null) || (paramIntent == null))
    {
      com.tencent.mm.sdk.platformtools.ad.e("SnsAdUtil", "startMarketActivity input param is error");
      AppMethodBeat.o(187274);
      return;
    }
    try
    {
      if (!(paramContext instanceof Activity)) {
        paramIntent.addFlags(268435456);
      }
      String str = bt.by(y.getStringExtra(paramIntent, "market_app_name"), "");
      al.a(paramContext, paramIntent.getPackage(), "", paramIntent, str, new am()
      {
        public final void u(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
        {
          AppMethodBeat.i(187260);
          if (paramAnonymousBoolean1)
          {
            j.a(this.hzE, paramString3, paramString4, 2, "0");
            e locale = e.v(paramString1, this.hzE, paramString3, paramString4);
            if (locale != null) {
              com.tencent.mm.plugin.sns.device.appstore.d.a(locale);
            }
            AppMethodBeat.o(187260);
            return;
          }
          j.a(this.hzE, paramString3, paramString4, 2, "2");
          AppMethodBeat.o(187260);
        }
      });
      AppMethodBeat.o(187274);
      return;
    }
    catch (Throwable paramContext)
    {
      a(paramString2, paramString3, paramString4, 2, "1");
      AppMethodBeat.o(187274);
    }
  }
  
  public static void a(Context paramContext, String paramString1, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad paramad, int paramInt, long paramLong, String paramString2)
  {
    AppMethodBeat.i(187264);
    label434:
    for (;;)
    {
      try
      {
        Intent localIntent = new Intent();
        Object localObject = paramString1;
        if (!TextUtils.isEmpty(paramad.iYE))
        {
          localObject = paramString1;
          if (!TextUtils.isEmpty(paramad.wSi)) {
            localObject = al.n(paramString1, new String[] { "traceid=" + paramad.iYE + "&aid=" + paramad.wSi });
          }
        }
        paramString1 = paramad.wXl;
        if (TextUtils.isEmpty(paramString1))
        {
          paramString1 = paramad.dvK;
          com.tencent.mm.sdk.platformtools.ad.i("SnsAdUtil", "use orig_UxInfo:".concat(String.valueOf(paramString1)));
          localObject = q.iy((String)localObject, paramString1);
          q.g(localIntent, paramString1);
          com.tencent.mm.sdk.platformtools.ad.i("SnsAdUtil", "open url %s", new Object[] { localObject });
          localIntent.putExtra("rawUrl", (String)localObject);
          localIntent.putExtra("useJs", true);
          localIntent.putExtra("type", -255);
          localIntent.putExtra("geta8key_scene", 2);
          if (paramad.bizId == 0)
          {
            localObject = new SnsAdClick(paramInt, paramLong);
            Bundle localBundle = new Bundle();
            localBundle.putParcelable("KSnsAdTag", (Parcelable)localObject);
            if (!TextUtils.isEmpty(paramString1)) {
              localBundle.putString("KAnsUxInfo", paramString1);
            }
            localIntent.putExtra("jsapiargs", localBundle);
          }
          if (((paramContext instanceof Activity)) && (paramad.bizId == 2))
          {
            paramad = ((Activity)paramContext).getIntent().getStringExtra("sns_landing_pages_sessionId");
            paramString1 = ((Activity)paramContext).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
            if (!bt.isNullOrNil(paramad))
            {
              paramLong = System.currentTimeMillis() / 1000L;
              if (bt.isNullOrNil(paramString1)) {
                break label434;
              }
              paramString1 = String.format("official_mall_%s_%s_%s_%s", new Object[] { paramString1, paramad, paramString2, String.valueOf(paramLong) });
              localIntent.putExtra("prePublishId", paramString1);
              localIntent.putExtra("KPublisherId", paramString1);
              localIntent.putExtra("pay_channel", 47);
            }
          }
          com.tencent.mm.bs.d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
          AppMethodBeat.o(187264);
        }
        else
        {
          com.tencent.mm.sdk.platformtools.ad.i("SnsAdUtil", "use updated_UxInfo:".concat(String.valueOf(paramString1)));
          continue;
        }
        paramString1 = "";
      }
      catch (Throwable paramContext)
      {
        com.tencent.mm.sdk.platformtools.ad.e("SnsAdUtil", "adLandingJumpWebPageUI exp=" + paramContext.toString());
        AppMethodBeat.o(187264);
        return;
      }
    }
  }
  
  public static void a(SnsAdClick paramSnsAdClick, com.tencent.mm.plugin.sns.a.b.i parami, p paramp, int paramInt)
  {
    long l2 = 0L;
    AppMethodBeat.i(187269);
    try
    {
      StringBuilder localStringBuilder = new StringBuilder("appendSnsAdClickParams, snsAdStatistic==null?");
      boolean bool;
      if (parami == null)
      {
        bool = true;
        com.tencent.mm.sdk.platformtools.ad.d("SnsAdUtil", bool + ", clickPos=" + paramInt);
        if (parami != null) {
          break label93;
        }
        l1 = 0L;
        label60:
        paramSnsAdClick.hte = l1;
        if (parami != null) {
          break label107;
        }
      }
      label93:
      label107:
      for (long l1 = l2;; l1 = parami.so(paramp.field_snsId))
      {
        paramSnsAdClick.htf = l1;
        AppMethodBeat.o(187269);
        return;
        bool = false;
        break;
        l1 = parami.ep(paramp.dxX(), paramInt);
        break label60;
      }
      return;
    }
    catch (Exception paramSnsAdClick)
    {
      com.tencent.mm.sdk.platformtools.ad.e("SnsAdUtil", "appendSnsAdClickParams exp=" + paramSnsAdClick.toString() + ", clockPos=" + paramInt);
      AppMethodBeat.o(187269);
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    AppMethodBeat.i(187275);
    ArrayMap localArrayMap = new ArrayMap();
    localArrayMap.put("outSns", Integer.valueOf(1));
    com.tencent.mm.plugin.sns.device.appstore.a.a(paramString1, paramString2, paramString3, paramInt, paramString4, localArrayMap);
    AppMethodBeat.o(187275);
  }
  
  public static boolean a(Context paramContext, p paramp, com.tencent.mm.plugin.sns.storage.a parama)
  {
    AppMethodBeat.i(187272);
    try
    {
      boolean bool = b(paramContext, paramp, parama);
      AppMethodBeat.o(187272);
      return bool;
    }
    catch (Throwable paramContext)
    {
      com.tencent.mm.sdk.platformtools.ad.w("SnsAdUtil", "processAdAppMarket has something wrong");
      AppMethodBeat.o(187272);
    }
    return false;
  }
  
  public static boolean a(Context paramContext, p paramp, com.tencent.mm.plugin.sns.storage.a parama, int paramInt, com.tencent.mm.plugin.sns.a.b.i parami)
  {
    AppMethodBeat.i(187271);
    if ((paramp != null) && (parama != null)) {}
    label220:
    while ((paramp == null) || (parama == null))
    {
      try
      {
        if (parama.wSv == null) {
          continue;
        }
        if (!com.tencent.mm.pluginsdk.model.app.q.t(paramContext, parama.wSv.IK)) {
          break label220;
        }
        com.tencent.mm.sdk.platformtools.ad.i("SnsAdUtil", "checkOpenApp isInstalled=true, " + parama.wSv.toString());
        String str = "";
        if (paramp.dxs() != null) {
          str = paramp.dxs().wBR;
        }
        if (a(paramContext, parama.wSv.appId, parama.wSv.IK, parama.wSv.appName, parama.wSv.wSw, parama.dvK, str, String.valueOf(paramp.field_snsId)))
        {
          if (paramInt == 0) {}
          for (int i = 1;; i = 2)
          {
            paramContext = new SnsAdClick(paramInt, i, paramp.field_snsId, 22, 34);
            a(paramContext, parami, paramp, 22);
            q.a(paramContext);
            AppMethodBeat.o(187271);
            return true;
          }
        }
        com.tencent.mm.sdk.platformtools.ad.e("SnsAdUtil", "checkOpenApp failed, " + parama.wSv.toString());
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          boolean bool;
          com.tencent.mm.sdk.platformtools.ad.e("SnsAdUtil", "checkOpenApp exp=" + paramContext.toString());
        }
      }
      AppMethodBeat.o(187271);
      return false;
      com.tencent.mm.sdk.platformtools.ad.e("SnsAdUtil", "checkOpenApp isInstalled=false, " + parama.wSv.toString());
      bool = b(paramContext, paramp, parama);
      AppMethodBeat.o(187271);
      return bool;
    }
    bool = b(paramContext, paramp, parama);
    AppMethodBeat.o(187271);
    return bool;
  }
  
  public static boolean a(Context paramContext, final String paramString1, final String paramString2, final String paramString3, final String paramString4, final String paramString5, final String paramString6, final String paramString7)
  {
    AppMethodBeat.i(187270);
    com.tencent.mm.sdk.platformtools.ad.i("SnsAdUtil", "openApp, appId = " + paramString1 + ", uxInfo = " + paramString5 + ", adExtInfo = " + paramString6);
    if ((paramContext == null) || (TextUtils.isEmpty(paramString2)))
    {
      com.tencent.mm.sdk.platformtools.ad.e("SnsAdUtil", "openApp, failed");
      AppMethodBeat.o(187270);
      return false;
    }
    h.a(paramString7, paramString1, 0, 2, paramString5, paramString6);
    if (!TextUtils.isEmpty(paramString4))
    {
      paramString4 = new Intent("android.intent.action.VIEW", Uri.parse(paramString4));
      paramString4.addFlags(268435456);
      paramString2 = bt.M(paramContext, paramString4);
      if ((paramString2 != null) && (!paramString2.isEmpty()))
      {
        if ((!TextUtils.isEmpty(paramString4.getPackage())) || (paramString2.size() != 1)) {
          break label229;
        }
        paramString2 = com.tencent.mm.pluginsdk.model.app.h.b((ResolveInfo)paramString2.get(0));
        if (!bt.nullAsNil(aj.getPackageName()).equals(paramString2)) {
          com.tencent.mm.cj.a.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(187257);
              com.tencent.mm.pluginsdk.model.app.h.a(this.val$context, paramString4, paramString3, new am()
              {
                public final void u(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
                {
                  AppMethodBeat.i(187256);
                  if (paramAnonymous2Boolean1) {
                    h.a(j.3.this.hzE, j.3.this.val$appId, 1, 2, j.3.this.wAQ, j.3.this.wAR);
                  }
                  if (!paramAnonymous2Boolean1) {
                    al.fV(j.3.this.val$context);
                  }
                  AppMethodBeat.o(187256);
                }
              });
              AppMethodBeat.o(187257);
            }
          });
        }
      }
    }
    for (;;)
    {
      AdLandingPagesProxy.getInstance().reportDownloadInfo(9, paramString1);
      AppMethodBeat.o(187270);
      return true;
      label229:
      paramString2 = paramString4.getPackage();
      break;
      com.tencent.mm.cj.a.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(187259);
          Intent localIntent = this.val$context.getPackageManager().getLaunchIntentForPackage(paramString2);
          com.tencent.mm.pluginsdk.model.app.h.a(this.val$context, localIntent, paramString3, new am()
          {
            public final void u(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
            {
              AppMethodBeat.i(187258);
              if (paramAnonymous2Boolean1) {
                h.a(j.4.this.hzE, j.4.this.val$appId, 1, 2, j.4.this.wAQ, j.4.this.wAR);
              }
              if (!paramAnonymous2Boolean1) {
                al.fV(j.4.this.val$context);
              }
              AppMethodBeat.o(187258);
            }
          });
          AppMethodBeat.o(187259);
        }
      });
    }
  }
  
  public static boolean a(SnsObject paramSnsObject, String paramString)
  {
    AppMethodBeat.i(187265);
    for (;;)
    {
      try
      {
        Iterator localIterator = paramSnsObject.CommentUserList.iterator();
        if (!localIterator.hasNext()) {
          break label239;
        }
        cuo localcuo = (cuo)localIterator.next();
        if ((localcuo == null) || (bt.isNullOrNil(localcuo.Username)) || (!localcuo.Username.equals(paramString))) {
          continue;
        }
        bool1 = true;
        localIterator = paramSnsObject.LikeUserList.iterator();
        if (localIterator.hasNext())
        {
          localcuo = (cuo)localIterator.next();
          if ((localcuo == null) || (bt.isNullOrNil(localcuo.Username)) || (!localcuo.Username.equals(paramString))) {
            continue;
          }
          bool2 = true;
          com.tencent.mm.sdk.platformtools.ad.i("SnsAdUtil", "isAdCommentOrLikedBySelf, snsId=" + q.st(paramSnsObject.Id) + ", hasComment=" + bool1 + ", hasLiked=" + bool2);
          if ((bool1) || (bool2))
          {
            AppMethodBeat.o(187265);
            return true;
          }
          AppMethodBeat.o(187265);
          return false;
        }
      }
      catch (Exception paramSnsObject)
      {
        com.tencent.mm.sdk.platformtools.ad.e("SnsAdUtil", "isAdCommentOrLikedBySelf, exp=" + paramSnsObject.toString());
        AppMethodBeat.o(187265);
        return false;
      }
      boolean bool2 = false;
      continue;
      label239:
      boolean bool1 = false;
    }
  }
  
  public static boolean a(dg paramdg)
  {
    AppMethodBeat.i(187262);
    try
    {
      if ((!ay.isWifi(aj.getContext())) && (!ay.is4G(aj.getContext())) && (!ay.is5G(aj.getContext())))
      {
        com.tencent.mm.sdk.platformtools.ad.w("SnsAdUtil", "checkVideoAd, network is not wifi or 4G,5G");
        AppMethodBeat.o(187262);
        return false;
      }
      boolean bool = e(com.tencent.mm.modelsns.g.zn(z.b(paramdg.CxS.ElO.ObjectDesc)));
      AppMethodBeat.o(187262);
      return bool;
    }
    catch (Throwable paramdg)
    {
      com.tencent.mm.sdk.platformtools.ad.e("SnsAdUtil", "checkVideoAd, exp2=" + paramdg.toString());
      AppMethodBeat.o(187262);
    }
    return false;
  }
  
  public static long anz(String paramString)
  {
    AppMethodBeat.i(187266);
    try
    {
      boolean bool = bt.isNullOrNil(paramString);
      if (bool)
      {
        AppMethodBeat.o(187266);
        return 0L;
      }
      if (paramString.startsWith("ad_table_"))
      {
        l = bt.aGi(paramString.substring(9));
        AppMethodBeat.o(187266);
        return l;
      }
      if (paramString.startsWith("sns_table_"))
      {
        l = bt.aGi(paramString.substring(10));
        AppMethodBeat.o(187266);
        return l;
      }
      long l = q.anR(paramString);
      AppMethodBeat.o(187266);
      return l;
    }
    catch (Throwable paramString)
    {
      com.tencent.mm.sdk.platformtools.ad.e("SnsAdUtil", paramString.toString());
      AppMethodBeat.o(187266);
    }
    return 0L;
  }
  
  public static JSONObject ax(Map<String, Object> paramMap)
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
  
  private static boolean b(Context paramContext, p paramp, com.tencent.mm.plugin.sns.storage.a parama)
  {
    AppMethodBeat.i(187273);
    if ((paramContext == null) || (paramp == null) || (parama == null))
    {
      com.tencent.mm.sdk.platformtools.ad.e("SnsAdUtil", "tryProcessAdAppMarket input param is wrong");
      AppMethodBeat.o(187273);
      return false;
    }
    String str3 = "";
    String str4 = "";
    String str2 = "";
    String str1;
    if (parama.wSv != null)
    {
      str1 = parama.wSv.appName;
      str3 = parama.wSv.appId;
      str4 = parama.wSv.wSw;
      str2 = parama.wSv.IK;
    }
    for (;;)
    {
      com.tencent.mm.plugin.sns.storage.b localb = paramp.dxs();
      String str5;
      Object localObject;
      if ((localb != null) && (localb.wTP == 1))
      {
        str5 = localb.wBR;
        localObject = localb.wTO;
        if ((!TextUtils.isEmpty(str2)) || (localObject == null)) {
          break label367;
        }
        str2 = y.getStringExtra(localb.wTO, "target_app_id");
      }
      label332:
      label367:
      for (;;)
      {
        if (str2 == null)
        {
          com.tencent.mm.sdk.platformtools.ad.e("SnsAdUtil", "the target package is empty!");
          AppMethodBeat.o(187273);
          return false;
        }
        if (com.tencent.mm.pluginsdk.model.app.q.t(paramContext, str2))
        {
          localObject = str1;
          if (TextUtils.isEmpty(str1)) {
            localObject = com.tencent.mm.plugin.sns.b.a.a.aZ(paramContext, str2);
          }
          a(paramContext, str3, str2, (String)localObject, str4, parama.dvK, str5, String.valueOf(paramp.field_snsId));
          AppMethodBeat.o(187273);
          return true;
        }
        if (com.tencent.mm.plugin.sns.device.appstore.a.aC((Intent)localObject)) {
          a(String.valueOf(paramp.field_snsId), parama.dvK, str5, 4, "0");
        }
        for (;;)
        {
          if (!com.tencent.mm.plugin.sns.device.appstore.a.aD((Intent)localObject)) {
            break label332;
          }
          a(String.valueOf(paramp.field_snsId), parama.dvK, str5, 1, "0");
          a(paramContext, (Intent)localObject, str2, String.valueOf(paramp.field_snsId), parama.dvK, str5);
          break;
          a(String.valueOf(paramp.field_snsId), parama.dvK, str5, 4, "1");
        }
        a(String.valueOf(paramp.field_snsId), parama.dvK, str5, 1, "1");
        AppMethodBeat.o(187273);
        return false;
        AppMethodBeat.o(187273);
        return false;
      }
      str1 = "";
    }
  }
  
  public static boolean c(TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(176239);
    if ((paramTimeLineObject != null) && (paramTimeLineObject.Etm != null) && (paramTimeLineObject.Etm.DaC != null) && (paramTimeLineObject.Etm.DaC.size() > 0))
    {
      paramTimeLineObject = (bpi)paramTimeLineObject.Etm.DaC.get(0);
      if ((paramTimeLineObject != null) && (paramTimeLineObject.DMT != null) && (paramTimeLineObject.DMT.DNH > 0.0F) && (paramTimeLineObject.DMT.DNI > 0.0F))
      {
        int i = (int)paramTimeLineObject.DMT.DNH;
        if ((int)paramTimeLineObject.DMT.DNI > i)
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
  
  public static boolean d(TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(187261);
    try
    {
      if ((!ay.isWifi(aj.getContext())) && (!ay.is4G(aj.getContext())) && (!ay.is5G(aj.getContext())))
      {
        com.tencent.mm.sdk.platformtools.ad.w("SnsAdUtil", "checkVideoAd, network is not wifi or 4G,5G");
        AppMethodBeat.o(187261);
        return false;
      }
      boolean bool = e(paramTimeLineObject);
      AppMethodBeat.o(187261);
      return bool;
    }
    catch (Throwable paramTimeLineObject)
    {
      com.tencent.mm.sdk.platformtools.ad.e("SnsAdUtil", "checkVideoAd, exp=" + paramTimeLineObject.toString());
      AppMethodBeat.o(187261);
    }
    return false;
  }
  
  private static boolean e(TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(187263);
    for (;;)
    {
      try
      {
        if (paramTimeLineObject.Etm.DaB != 15)
        {
          com.tencent.mm.sdk.platformtools.ad.w("SnsAdUtil", "checkVideoAd, ContentStyle is not video, snsId=" + paramTimeLineObject.Id);
          AppMethodBeat.o(187263);
          return false;
        }
        if ((paramTimeLineObject.Etm.DaC == null) || (paramTimeLineObject.Etm.DaC.isEmpty()))
        {
          com.tencent.mm.sdk.platformtools.ad.w("SnsAdUtil", "checkVideoAd, MediaObjList is empty, snsId=" + paramTimeLineObject.Id);
          AppMethodBeat.o(187263);
          return false;
        }
        final bpi localbpi = (bpi)paramTimeLineObject.Etm.DaC.get(0);
        String str1 = paramTimeLineObject.Id;
        String str2 = an.iF(com.tencent.mm.plugin.sns.model.af.getAccSnsPath(), localbpi.Id);
        String str3 = q.i(localbpi);
        str2 = str2 + str3;
        if (com.tencent.mm.vfs.i.eK(str2))
        {
          com.tencent.mm.sdk.platformtools.ad.w("SnsAdUtil", "checkVideoAd, preloadVideo, fileExists, snsId=" + str1 + ", mediaId=" + localbpi.Id + ", filePath=" + str2);
          paramTimeLineObject = paramTimeLineObject.Id;
          str1 = an.iF(com.tencent.mm.plugin.sns.model.af.getAccSnsPath(), localbpi.Id);
          str2 = q.d(localbpi);
          if (com.tencent.mm.vfs.i.eK(str1 + str2))
          {
            com.tencent.mm.sdk.platformtools.ad.w("SnsAdUtil", "checkVideoAd, preloadThumb, fileExists, snsId=" + paramTimeLineObject + ", mediaId=" + localbpi.Id);
            AppMethodBeat.o(187263);
            return true;
          }
        }
        else
        {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(187254);
              try
              {
                com.tencent.mm.sdk.platformtools.ad.i("SnsAdUtil", "checkVideoAd, preloadVideo, snsId=" + this.hzE + ", mediaId=" + localbpi.Id);
                com.tencent.mm.plugin.sns.model.af.dtp().a(localbpi, 4, null, bc.FzF);
                AppMethodBeat.o(187254);
                return;
              }
              catch (Throwable localThrowable)
              {
                com.tencent.mm.sdk.platformtools.ad.e("SnsAdUtil", "checkVideoAd, preloadVideo exp=" + localThrowable.toString());
                AppMethodBeat.o(187254);
              }
            }
          });
          continue;
        }
        aq.f(new Runnable()
        {
          public final void run()
          {
            int i = 1;
            AppMethodBeat.i(187255);
            try
            {
              com.tencent.mm.sdk.platformtools.ad.i("SnsAdUtil", "checkVideoAd, preloadThumb, snsId=" + this.hzE + ", mediaId=" + localbpi.Id);
              m localm = new m(localbpi);
              localm.wBd = 1;
              localm.dnB = localbpi.Id;
              com.tencent.mm.plugin.sns.model.b localb = com.tencent.mm.plugin.sns.model.af.dtp();
              bpi localbpi = localbpi;
              if (localbpi.mBH == 6) {
                i = 5;
              }
              localb.a(localbpi, i, localm, bc.FzF);
              AppMethodBeat.o(187255);
              return;
            }
            catch (Throwable localThrowable)
            {
              com.tencent.mm.sdk.platformtools.ad.e("SnsAdUtil", "checkVideoAd, preloadThumb exp=" + localThrowable.toString());
              AppMethodBeat.o(187255);
            }
          }
        });
      }
      catch (Throwable paramTimeLineObject)
      {
        com.tencent.mm.sdk.platformtools.ad.e("SnsAdUtil", "checkVideoAd, doCheckVideoAd exp=" + paramTimeLineObject.toString());
        AppMethodBeat.o(187263);
        return false;
      }
    }
  }
  
  public static String ep(View paramView)
  {
    AppMethodBeat.i(176242);
    paramView = "[" + paramView.getPaddingLeft() + "," + paramView.getPaddingTop() + "," + paramView.getPaddingRight() + "," + paramView.getPaddingBottom() + "]";
    AppMethodBeat.o(176242);
    return paramView;
  }
  
  public static int i(p paramp)
  {
    AppMethodBeat.i(187267);
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
        if (paramp.Nb(32))
        {
          j = m;
          paramp = paramp.dxs();
          i = k;
          if (paramp != null)
          {
            i = k;
            j = m;
            if (!TextUtils.isEmpty(paramp.wTN))
            {
              j = m;
              long l = System.currentTimeMillis();
              j = m;
              if (!com.tencent.mm.pluginsdk.model.app.q.t(aj.getContext(), paramp.wTN)) {
                continue;
              }
              i = 2;
              j = i;
              com.tencent.mm.sdk.platformtools.ad.i("SnsAdUtil", "getAdAppInstallStatus, pkg=" + paramp.wTN + ", installState=" + i + ", timeCost=" + (System.currentTimeMillis() - l));
            }
          }
        }
      }
      catch (Throwable paramp)
      {
        com.tencent.mm.sdk.platformtools.ad.e("SnsAdUtil", "appInstalled exp=" + paramp.toString());
        i = j;
        continue;
      }
      AppMethodBeat.o(187267);
      return i;
      i = 1;
    }
  }
  
  public static void ix(String paramString1, String paramString2)
  {
    AppMethodBeat.i(176241);
    try
    {
      if (aj.cbe())
      {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.d locald = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.d(paramString1, paramString2);
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afA().gcy.a(locald, 0);
        com.tencent.mm.sdk.platformtools.ad.i("SnsAdUtil", "adChannelCgiReport, main, channel=" + paramString1 + ", content=" + paramString2);
        AppMethodBeat.o(176241);
        return;
      }
      if (aj.eFJ())
      {
        AdLandingPagesProxy.getInstance().onAdLandingPageClick(paramString1, paramString2);
        com.tencent.mm.sdk.platformtools.ad.i("SnsAdUtil", "adChannelCgiReport, tools, channel=" + paramString1 + ", content=" + paramString2);
        AppMethodBeat.o(176241);
        return;
      }
    }
    catch (Exception paramString1)
    {
      com.tencent.mm.sdk.platformtools.ad.e("SnsAdUtil", "adChannelCgiReport, exp=" + paramString1.toString());
      AppMethodBeat.o(176241);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.e("SnsAdUtil", "adChannelCgiReport, process err");
    AppMethodBeat.o(176241);
  }
  
  public static int j(p paramp)
  {
    AppMethodBeat.i(187268);
    str1 = "";
    try
    {
      str2 = paramp.field_userName;
      l = System.currentTimeMillis();
      if ((paramp == null) || (!paramp.Nb(32)) || (TextUtils.isEmpty(str2))) {
        break label211;
      }
      com.tencent.mm.kernel.g.afC();
      paramp = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().aHY(str2);
      if (paramp == null) {
        break label211;
      }
      if ((int)paramp.fId <= 0) {
        break label206;
      }
      boolean bool = com.tencent.mm.n.b.ls(paramp.field_type);
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
          paramp = paramp.ZW();
          j = i;
          com.tencent.mm.sdk.platformtools.ad.i("SnsAdUtil", "getAdUserFollowStatus, userName=" + str2 + ", followStatus=" + i + ", displayName=" + paramp + ", timeCost=" + (System.currentTimeMillis() - l));
          AppMethodBeat.o(187268);
          return i;
        }
        catch (Throwable paramp)
        {
          int j;
          continue;
        }
        paramp = paramp;
        j = 1;
        com.tencent.mm.sdk.platformtools.ad.e("SnsAdUtil", "isContact exp=" + paramp.toString());
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