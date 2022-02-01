package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.wg;
import com.tencent.mm.f.a.wg.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.webview.ui.tools.widget.f;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.g;
import com.tencent.mm.vfs.u;
import com.tencent.xweb.WebView;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class j
  extends m
{
  IListener<wg> Kqh;
  private final String[] Kqi;
  private Runnable Kqj;
  com.tencent.mm.plugin.sns.data.j Kqk;
  MMWebView lxa;
  private volatile boolean mIsDestroyed;
  private com.tencent.mm.plugin.webview.d.h pGO;
  
  public j(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa paramaa, ViewGroup paramViewGroup)
  {
    super(paramContext, paramaa, paramViewGroup);
    AppMethodBeat.i(203533);
    this.mIsDestroyed = false;
    this.Kqi = new String[] { "weixin.qq.com", "wxs.qq.com" };
    this.Kqj = new j.2(this);
    this.Kqk = null;
    AppMethodBeat.o(203533);
  }
  
  private boolean baU(String paramString)
  {
    AppMethodBeat.i(203550);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vvr, 1);
    Log.d("AdLandingNewH5Comp", "checkDeviceInfoUrlPermission::expt value is ".concat(String.valueOf(i)));
    if (i == 0)
    {
      AppMethodBeat.o(203550);
      return false;
    }
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(203550);
      return false;
    }
    paramString = Uri.parse(paramString).getHost();
    if ((paramString != null) && (com.tencent.mm.plugin.sns.ad.i.d.x(this.Kqi)))
    {
      String[] arrayOfString = this.Kqi;
      int j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if ((str != null) && (paramString.contains(str)))
        {
          AppMethodBeat.o(203550);
          return true;
        }
        i += 1;
      }
    }
    Log.d("AdLandingNewH5Comp", "checkDeviceInfoUrlPermission::the domain is ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(203550);
    return false;
  }
  
  private static Method br(Class<?> paramClass)
  {
    AppMethodBeat.i(203552);
    try
    {
      paramClass = paramClass.getMethod("getJsapi", new Class[0]);
      AppMethodBeat.o(203552);
      return paramClass;
    }
    catch (Throwable paramClass)
    {
      Log.e("AdLandingNewH5Comp", "there is no method named getJsapi");
      AppMethodBeat.o(203552);
    }
    return null;
  }
  
  private static Method bs(Class<?> paramClass)
  {
    AppMethodBeat.i(203554);
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    for (;;)
    {
      try
      {
        Method[] arrayOfMethod = paramClass.getDeclaredMethods();
        localObject1 = localObject3;
        int j = arrayOfMethod.length;
        i = 0;
        paramClass = localObject2;
        if (i < j)
        {
          paramClass = arrayOfMethod[i];
          localObject1 = localObject3;
          Class localClass = paramClass.getReturnType();
          localObject1 = localObject3;
          Class[] arrayOfClass = paramClass.getParameterTypes();
          if (localClass != com.tencent.mm.plugin.webview.d.h.class) {
            continue;
          }
          localObject1 = localObject3;
          if (!com.tencent.mm.plugin.sns.ad.i.d.w(arrayOfClass)) {
            continue;
          }
        }
        localObject1 = paramClass;
        if (paramClass == null)
        {
          localObject1 = paramClass;
          Log.w("AdLandingNewH5Comp", "there is no method satisfying the condition");
          localObject1 = paramClass;
        }
      }
      catch (Throwable paramClass)
      {
        int i;
        Log.e("AdLandingNewH5Comp", "finding the js method occurs something exception");
        continue;
      }
      AppMethodBeat.o(203554);
      return localObject1;
      i += 1;
    }
  }
  
  private void fQZ()
  {
    AppMethodBeat.i(203559);
    if ((this.pGO == null) && (!this.mIsDestroyed)) {}
    for (;;)
    {
      try
      {
        localObject1 = (com.tencent.mm.api.aa)com.tencent.mm.kernel.h.ae(com.tencent.mm.api.aa.class);
        if (localObject1 == null) {
          break label235;
        }
        localObject1 = ((com.tencent.mm.api.aa)localObject1).b(this.lxa);
        if (localObject1 == null) {
          continue;
        }
        Log.d("AdLandingNewH5Comp", "the jsApiHandler is set from service");
        this.pGO = ((com.tencent.mm.plugin.webview.d.h)localObject1);
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          long l = SystemClock.currentThreadTimeMillis();
          Class localClass = this.lxa.getClass();
          Method localMethod = br(localClass);
          Object localObject1 = localMethod;
          if (localMethod != null) {
            continue;
          }
          Log.i("AdLandingNewH5Comp", "the js method is not found in getJsapiMethod, try to findJsapiMethod");
          localObject1 = bs(localClass);
          if (localObject1 != null) {
            continue;
          }
          Log.w("AdLandingNewH5Comp", "the js method is not found!");
          AppMethodBeat.o(203559);
          return;
          Log.w("AdLandingNewH5Comp", "the jsApiHandler is null from service!");
          continue;
          localThrowable1 = localThrowable1;
          Log.e("AdLandingNewH5Comp", "ensureJsApiHandlerFromService has something wrong!!");
          continue;
          Object localObject2 = localThrowable1.invoke(this.lxa, new Object[0]);
          if (!(localObject2 instanceof com.tencent.mm.plugin.webview.d.h)) {
            continue;
          }
          Log.i("AdLandingNewH5Comp", "the method return type is js api in ensureJsApiHandlerFromWebView");
          this.pGO = ((com.tencent.mm.plugin.webview.d.h)localObject2);
          Log.i("AdLandingNewH5Comp", "get the js api handler takes : " + (SystemClock.currentThreadTimeMillis() - l));
          AppMethodBeat.o(203559);
          return;
          Log.w("AdLandingNewH5Comp", "the method return value is null ??");
          continue;
          AppMethodBeat.o(203559);
        }
        catch (Throwable localThrowable2)
        {
          Log.e("AdLandingNewH5Comp", "there is no getJsApiHandler method, the jsApiHandler object may be null!!");
        }
      }
      if (this.pGO == null) {}
      return;
      label235:
      Object localObject3 = null;
    }
  }
  
  private void n(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(203546);
    HashMap localHashMap = new HashMap();
    localHashMap.put("ret", Integer.valueOf(paramInt));
    localHashMap.put("device_id", Util.nullAsNil(paramString3));
    g(paramString1, paramString2, localHashMap);
    AppMethodBeat.o(203546);
  }
  
  protected final void fKe()
  {
    AppMethodBeat.i(96462);
    WebView localWebView;
    Object localObject;
    String str1;
    if ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ao)fRo() != null)
    {
      localWebView = (WebView)getView();
      localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ao)fRo();
      if (TextUtils.isEmpty(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ao)localObject).url)) {
        break label222;
      }
      str1 = "uxinfo=" + fRp().uxInfo;
      String str2 = AdLandingPagesProxy.getInstance().getUin();
      String str3 = "uin=".concat(String.valueOf(str2));
      str1 = ao.m(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ao)localObject).url, new String[] { str1, str3 });
      if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ao)localObject).subType != 1) {
        break label238;
      }
      localObject = AdLandingPagesProxy.getInstance().getAdVoteInfo(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ao)localObject).url, fRp().uxInfo, str2);
      if (Util.isNullOrNil((String)localObject)) {
        break label238;
      }
      str1 = str1 + "&" + (String)localObject;
    }
    label222:
    label238:
    for (;;)
    {
      Log.i("AdLandingNewH5Comp", "final url=".concat(String.valueOf(str1)));
      for (;;)
      {
        localWebView.loadUrl(str1);
        try
        {
          if (this.Kqh == null)
          {
            this.Kqh = new IListener()
            {
              private boolean a(wg paramAnonymouswg)
              {
                AppMethodBeat.i(201813);
                try
                {
                  j localj = j.this;
                  int i = paramAnonymouswg.fVt.fVu;
                  if (localj.Kqh != null)
                  {
                    localj.Kqh.dead();
                    localj.Kqh = null;
                  }
                  if (5 == i)
                  {
                    paramAnonymouswg = localj.lxa;
                    if (paramAnonymouswg != null) {
                      paramAnonymouswg.setCleanOnDetached(true);
                    }
                  }
                }
                catch (Throwable paramAnonymouswg)
                {
                  label56:
                  break label56;
                }
                AppMethodBeat.o(201813);
                return false;
              }
            };
            this.Kqh.alive();
          }
          AppMethodBeat.o(96462);
          return;
        }
        catch (Throwable localThrowable)
        {
          AppMethodBeat.o(96462);
          return;
        }
        str1 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ao)localObject).url;
      }
    }
  }
  
  protected final void fKi()
  {
    AppMethodBeat.i(96463);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.KqB.paddingLeft, (int)this.KqB.paddingTop, (int)this.KqB.paddingRight, (int)this.KqB.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(96463);
  }
  
  protected final View fKj()
  {
    AppMethodBeat.i(96464);
    this.mIsDestroyed = false;
    this.lxa = com.tencent.mm.plugin.webview.ui.tools.widget.f.a.QwC.eN(this.context);
    this.lxa.setCleanOnDetached(false);
    this.lxa.getSettings().iwz();
    this.lxa.getSettings().iwD();
    this.lxa.getSettings().iwC();
    this.lxa.setWebViewClient(com.tencent.mm.plugin.webview.ui.tools.widget.c.a.QwB.a(this.lxa, false, new com.tencent.mm.plugin.webview.ui.tools.widget.d()
    {
      public final boolean h(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(96461);
        Log.i("AdLandingNewH5Comp", "callback, actionCode=".concat(String.valueOf(paramAnonymousInt)));
        switch (paramAnonymousInt)
        {
        default: 
        case 150: 
          for (;;)
          {
            AppMethodBeat.o(96461);
            return false;
            localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ao)j.this.fRo();
            paramAnonymousInt = paramAnonymousBundle.getInt("sns_landing_pages_ad_vote_index");
            paramAnonymousBundle = paramAnonymousBundle.getString("sns_landing_pages_ad_vote_result");
            AdLandingPagesProxy.getInstance().saveAdVoteInfo(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ao)localObject).url, j.this.fRp().uxInfo, j.this.fRp().uin, paramAnonymousInt, 0, paramAnonymousBundle);
          }
        case 151: 
          for (;;)
          {
            try
            {
              localObject = new Intent();
              String str = ao.m(paramAnonymousBundle.getString("sns_landing_pages_ad_jumpurl"), new String[] { "traceid=" + j.this.fRp().nTp, "aid=" + j.this.fRp().aid });
              paramAnonymousBundle = j.this.fRp().fQE();
              if (!TextUtils.isEmpty(paramAnonymousBundle)) {
                break label356;
              }
              paramAnonymousBundle = j.this.fRp().uxInfo;
              Log.i("AdLandingNewH5Comp", "opJumpView, use orig_UxInfo:".concat(String.valueOf(paramAnonymousBundle)));
              str = t.kw(str, paramAnonymousBundle);
              t.g((Intent)localObject, paramAnonymousBundle);
              ((Intent)localObject).putExtra("rawUrl", str);
              ((Intent)localObject).putExtra("useJs", true);
              ((Intent)localObject).putExtra("type", -255);
              ((Intent)localObject).putExtra("geta8key_scene", 2);
              com.tencent.mm.by.c.b(j.this.context, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
              Log.i("AdLandingNewH5Comp", "jumpUrl, finalUrl=".concat(String.valueOf(str)));
            }
            catch (Exception paramAnonymousBundle)
            {
              Log.e("AdLandingNewH5Comp", "OptJump exp=" + paramAnonymousBundle.toString());
            }
            break;
            label356:
            Log.i("AdLandingNewH5Comp", "opJumpView, use updated_UxInfo:".concat(String.valueOf(paramAnonymousBundle)));
          }
        }
        Object localObject = paramAnonymousBundle.getString("sns_landing_pages_h5_params");
        paramAnonymousBundle = paramAnonymousBundle.getString("callbackId");
        boolean bool = j.this.kN((String)localObject, paramAnonymousBundle);
        AppMethodBeat.o(96461);
        return bool;
      }
    }));
    MMWebView localMMWebView = this.lxa;
    AppMethodBeat.o(96464);
    return localMMWebView;
  }
  
  public final void fKk()
  {
    AppMethodBeat.i(203537);
    super.fKk();
    try
    {
      MMWebView localMMWebView = this.lxa;
      if (localMMWebView != null) {
        localMMWebView.postOnAnimation(this.Kqj);
      }
      AppMethodBeat.o(203537);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(203537);
    }
  }
  
  public final void fKo()
  {
    AppMethodBeat.i(96465);
    super.fKo();
    WebView localWebView = (WebView)getView();
    if ((localWebView != null) && (localWebView.getParent() != null))
    {
      ((ViewGroup)localWebView.getParent()).removeView(localWebView);
      localWebView.setTag(null);
      localWebView.destroy();
    }
    this.mIsDestroyed = true;
    this.pGO = null;
    this.contentView = null;
    AppMethodBeat.o(96465);
  }
  
  final void g(String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(203562);
    fQZ();
    com.tencent.mm.plugin.webview.d.h localh = this.pGO;
    if (localh != null)
    {
      Log.d("AdLandingNewH5Comp", "the js api handler is called!!");
      localh.a(paramString1, paramString2, paramMap, true);
      AppMethodBeat.o(203562);
      return;
    }
    Log.w("AdLandingNewH5Comp", "the js api handler is null!!");
    AppMethodBeat.o(203562);
  }
  
  final boolean kN(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(203544);
    Object localObject2;
    Object localObject1;
    try
    {
      Log.i("AdLandingNewH5Comp", "handleJSAPI, params=".concat(String.valueOf(paramString1)));
      localObject2 = new JSONObject(paramString1);
      paramString1 = ((JSONObject)localObject2).optString("funcName");
      if ("opUpdateContentHeight".equals(paramString1)) {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(266089);
            if ((j.this.contentView != null) && (this.Kqm >= 0)) {
              try
              {
                ViewGroup.LayoutParams localLayoutParams = j.this.contentView.getLayoutParams();
                int i = (int)i.a(this.Kqm, 1, 750, 1);
                Log.i("AdLandingNewH5Comp", "adJuestHeight, curH=" + localLayoutParams.height + ", newH=" + this.Kqm + ", newPx=" + i);
                if (localLayoutParams.height != i)
                {
                  ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ao)j.this.fRo()).KmE = i;
                  j.this.fRm();
                }
                AppMethodBeat.o(266089);
                return;
              }
              catch (Exception localException)
              {
                Log.e("AdLandingNewH5Comp", "adJuestHeight exp=" + localException.toString());
              }
            }
            AppMethodBeat.o(266089);
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(203544);
        return false;
        if (!"opStartQRScan".equals(paramString1)) {
          break;
        }
        ((JSONObject)localObject2).getString("scanUrl");
      }
    }
    catch (Exception paramString1)
    {
      label290:
      label297:
      do
      {
        for (;;)
        {
          Log.e("AdLandingNewH5Comp", "handleJSAPI, exp=" + paramString1.toString());
          continue;
          if (!"opEndQRScan".equals(paramString1)) {
            break;
          }
          paramString2 = ((JSONObject)localObject2).getString("scanUrl");
          for (;;)
          {
            try
            {
              if (this.Kqk == null)
              {
                localObject1 = new Bundle();
                paramString1 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ao)fRo();
                if (paramString1 == null) {
                  break label290;
                }
                paramString1 = paramString1.Kmh;
                ((Bundle)localObject1).putString("qrExtInfo", paramString1);
                this.Kqk = new com.tencent.mm.plugin.sns.data.j(this.context, fRp(), 2, (Bundle)localObject1);
              }
              paramString1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kU("adId", paramString2);
              if ((TextUtils.isEmpty(paramString1)) || (!u.agG(paramString1))) {
                break label297;
              }
              Log.i("AdLandingNewH5Comp", "local file exists, imageUrl=".concat(String.valueOf(paramString2)));
              this.Kqk.kr(paramString1, paramString2);
            }
            catch (Throwable paramString1)
            {
              Log.e("AdLandingNewH5Comp", "handleQR, exp=" + paramString1.toString());
            }
            break;
            paramString1 = "";
          }
          paramString1 = BitmapUtil.getBitmapFromView(this.contentView);
          if (paramString1 != null)
          {
            Log.i("AdLandingNewH5Comp", "shoot webView succ");
            localObject1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kU("adId", paramString2 + "_shoot");
            localObject2 = u.an(new com.tencent.mm.vfs.q((String)localObject1));
            boolean bool = paramString1.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject2);
            ((OutputStream)localObject2).flush();
            ((OutputStream)localObject2).close();
            if (bool)
            {
              Log.i("AdLandingNewH5Comp", "shoot save succ");
              this.Kqk.kr((String)localObject1, paramString2);
            }
          }
          fRo();
          com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a("adId", paramString2, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a()
          {
            public final void aYs(String paramAnonymousString)
            {
              AppMethodBeat.i(204282);
              Log.i("AdLandingNewH5Comp", "onDownloaded, imageUrl=" + paramString2);
              AppMethodBeat.o(204282);
            }
            
            public final void fJU() {}
            
            public final void fJV()
            {
              AppMethodBeat.i(204281);
              Log.e("AdLandingNewH5Comp", "onDownloadError, imageUrl=" + paramString2);
              AppMethodBeat.o(204281);
            }
          });
        }
        if ("opGetLocation".equals(paramString1))
        {
          paramString1 = ((JSONObject)localObject2).optString("type");
          paramString2 = com.tencent.mm.plugin.sns.ad.landingpage.helper.b.a.a(this.context, new j.a(paramString2, this));
          if (paramString2 != null) {
            paramString2.request(paramString1);
          }
          AppMethodBeat.o(203544);
          return true;
        }
        if ("opGetDeviceInfo".equals(paramString1))
        {
          if (!baU(this.lxa.getUrl())) {
            n(paramString2, -2, "url permission denied", "");
          }
          for (;;)
          {
            AppMethodBeat.o(203544);
            return true;
            if (!com.tencent.mm.pluginsdk.permission.b.f(this.context, new String[] { "android.permission.READ_PHONE_STATE" }))
            {
              n(paramString2, -3, "system permission denied", "");
            }
            else
            {
              paramString1 = com.tencent.mm.compatible.deviceinfo.q.dR(false);
              if (TextUtils.isEmpty(paramString1)) {
                n(paramString2, -1, "id is empty", "");
              } else {
                n(paramString2, 0, "ok", MD5Util.getMD5String(paramString1));
              }
            }
          }
        }
      } while (!"requestBindPhoneNumber".equals(paramString1));
      paramString1 = AdLandingPagesProxy.getInstance().getPhoneNumber();
      localObject1 = ((JSONObject)localObject2).optString("requestName");
      localObject2 = ((JSONObject)localObject2).optString("requestIconUrl");
      localObject3 = new StringBuilder("handleBindPhoneNumber, phone.len=");
      if (paramString1 != null) {}
    }
    for (int i = 0;; i = paramString1.length())
    {
      Log.i("AdLandingNewH5Comp", i + ", name=" + (String)localObject1 + ", iconUrl=" + (String)localObject2);
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
        break;
      }
      paramString1 = new HashMap();
      paramString1.put("ret", "-3");
      paramString1.put("err_msg", "params error");
      g(paramString2, "params error", paramString1);
      Log.i("AdLandingNewH5Comp", "handleBindPhoneNumber, params error");
      AppMethodBeat.o(203544);
      return true;
    }
    Object localObject3 = new g(this.context, 0, 0, false);
    ((g)localObject3).oFW.setBackgroundColor(this.context.getResources().getColor(i.c.white));
    View localView1 = View.inflate(this.context, i.g.sns_ad_get_bind_phone, null);
    ImageView localImageView = (ImageView)localView1.findViewById(i.f.request_icon);
    TextView localTextView1 = (TextView)localView1.findViewById(i.f.request_name);
    TextView localTextView2 = (TextView)localView1.findViewById(i.f.phone_number_manager_dialog_item_phone);
    View localView5 = localView1.findViewById(i.f.phone_number_manager_dialog_item_remark);
    View localView6 = localView1.findViewById(i.f.button_group);
    View localView2 = localView1.findViewById(i.f.button_i_known);
    View localView3 = localView1.findViewById(i.f.request_cancel);
    View localView4 = localView1.findViewById(i.f.request_ok);
    if (TextUtils.isEmpty(paramString1))
    {
      localTextView2.setVisibility(0);
      localView5.setVisibility(8);
      localView6.setVisibility(8);
      localView2.setVisibility(0);
      localTextView2.setTextColor(this.context.getResources().getColor(i.c.hint_text_color));
      localTextView2.setText(this.context.getText(i.j.sns_ad_not_bind_phone_number));
    }
    for (;;)
    {
      localTextView1.setText(Util.nullAsNil((String)localObject1));
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = new com.tencent.mm.ay.a.a.c.a();
        ((com.tencent.mm.ay.a.a.c.a)localObject1).lRC = true;
        ((com.tencent.mm.ay.a.a.c.a)localObject1).lRP = i.i.default_avatar_round;
        ((com.tencent.mm.ay.a.a.c.a)localObject1).kPz = true;
        com.tencent.mm.ay.a.a.bms().a((String)localObject2, localImageView, ((com.tencent.mm.ay.a.a.c.a)localObject1).bmL());
      }
      localView3.setOnClickListener(new j.6(this, (g)localObject3, paramString2));
      localView4.setOnClickListener(new j.7(this, (g)localObject3, paramString1, paramString2));
      localView2.setOnClickListener(new j.8(this, (g)localObject3, paramString2));
      ((g)localObject3).setCustomView(localView1);
      ((g)localObject3).eik();
      break;
      localTextView2.setVisibility(0);
      localView5.setVisibility(0);
      localView6.setVisibility(0);
      localView2.setVisibility(8);
      localTextView2.setText(paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.j
 * JD-Core Version:    0.7.0.1
 */