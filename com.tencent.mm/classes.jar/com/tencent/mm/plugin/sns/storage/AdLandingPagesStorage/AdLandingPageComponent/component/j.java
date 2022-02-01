package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.Intent;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.aa;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.g.a.vc;
import com.tencent.mm.g.a.vc.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.ad.landingpage.helper.a.a;
import com.tencent.mm.plugin.sns.ad.landingpage.helper.a.a.a;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.webview.ui.tools.widget.c.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.d;
import com.tencent.mm.plugin.webview.ui.tools.widget.f;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.xweb.WebView;
import java.io.OutputStream;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class j
  extends m
{
  IListener<vc> EcF;
  private final String[] EcG;
  private Runnable EcH;
  com.tencent.mm.plugin.sns.data.h EcI;
  MMWebView iGY;
  private com.tencent.mm.plugin.webview.d.h mHt;
  private volatile boolean mIsDestroyed;
  
  public j(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z paramz, ViewGroup paramViewGroup)
  {
    super(paramContext, paramz, paramViewGroup);
    AppMethodBeat.i(202887);
    this.mIsDestroyed = false;
    this.EcG = new String[] { "weixin.qq.com", "wxs.qq.com" };
    this.EcH = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176275);
        try
        {
          Object localObject = j.this.iGY;
          if ((localObject != null) && (((MMWebView)localObject).isAttachedToWindow()))
          {
            localObject = (ViewGroup)((MMWebView)localObject).getChildAt(0);
            if ((localObject != null) && (((ViewGroup)localObject).getChildCount() > 0))
            {
              ((ViewGroup)localObject).setPadding(0, 0, 0, 0);
              localObject = ((ViewGroup)localObject).getChildAt(0);
              if (localObject != null) {
                ((View)localObject).requestLayout();
              }
            }
          }
          AppMethodBeat.o(176275);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.w("AdLandingNewH5Comp", "there is something in wevView fix!");
          AppMethodBeat.o(176275);
        }
      }
    };
    this.EcI = null;
    AppMethodBeat.o(202887);
  }
  
  private boolean aPW(String paramString)
  {
    AppMethodBeat.i(202891);
    int i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rPj, 1);
    Log.d("AdLandingNewH5Comp", "checkDeviceInfoUrlPermission::expt value is ".concat(String.valueOf(i)));
    if (i == 0)
    {
      AppMethodBeat.o(202891);
      return false;
    }
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(202891);
      return false;
    }
    paramString = Uri.parse(paramString).getHost();
    if ((paramString != null) && (com.tencent.mm.plugin.sns.ad.i.c.x(this.EcG)))
    {
      String[] arrayOfString = this.EcG;
      int j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if ((str != null) && (paramString.contains(str)))
        {
          AppMethodBeat.o(202891);
          return true;
        }
        i += 1;
      }
    }
    Log.d("AdLandingNewH5Comp", "checkDeviceInfoUrlPermission::the domain is ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(202891);
    return false;
  }
  
  private static Method aW(Class<?> paramClass)
  {
    AppMethodBeat.i(202892);
    try
    {
      paramClass = paramClass.getMethod("getJsapi", new Class[0]);
      AppMethodBeat.o(202892);
      return paramClass;
    }
    catch (Throwable paramClass)
    {
      Log.e("AdLandingNewH5Comp", "there is no method named getJsapi");
      AppMethodBeat.o(202892);
    }
    return null;
  }
  
  private static Method aX(Class<?> paramClass)
  {
    AppMethodBeat.i(202893);
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
          if (!com.tencent.mm.plugin.sns.ad.i.c.w(arrayOfClass)) {
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
      AppMethodBeat.o(202893);
      return localObject1;
      i += 1;
    }
  }
  
  private void fdd()
  {
    AppMethodBeat.i(202894);
    if ((this.mHt == null) && (!this.mIsDestroyed)) {}
    for (;;)
    {
      try
      {
        localObject1 = (aa)g.af(aa.class);
        if (localObject1 == null) {
          break label235;
        }
        localObject1 = ((aa)localObject1).b(this.iGY);
        if (localObject1 == null) {
          continue;
        }
        Log.d("AdLandingNewH5Comp", "the jsApiHandler is set from service");
        this.mHt = ((com.tencent.mm.plugin.webview.d.h)localObject1);
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          long l = SystemClock.currentThreadTimeMillis();
          Class localClass = this.iGY.getClass();
          Method localMethod = aW(localClass);
          Object localObject1 = localMethod;
          if (localMethod != null) {
            continue;
          }
          Log.i("AdLandingNewH5Comp", "the js method is not found in getJsapiMethod, try to findJsapiMethod");
          localObject1 = aX(localClass);
          if (localObject1 != null) {
            continue;
          }
          Log.w("AdLandingNewH5Comp", "the js method is not found!");
          AppMethodBeat.o(202894);
          return;
          Log.w("AdLandingNewH5Comp", "the jsApiHandler is null from service!");
          continue;
          localThrowable1 = localThrowable1;
          Log.e("AdLandingNewH5Comp", "ensureJsApiHandlerFromService has something wrong!!");
          continue;
          Object localObject2 = localThrowable1.invoke(this.iGY, new Object[0]);
          if (!(localObject2 instanceof com.tencent.mm.plugin.webview.d.h)) {
            continue;
          }
          Log.i("AdLandingNewH5Comp", "the method return type is js api in ensureJsApiHandlerFromWebView");
          this.mHt = ((com.tencent.mm.plugin.webview.d.h)localObject2);
          Log.i("AdLandingNewH5Comp", "get the js api handler takes : " + (SystemClock.currentThreadTimeMillis() - l));
          AppMethodBeat.o(202894);
          return;
          Log.w("AdLandingNewH5Comp", "the method return value is null ??");
          continue;
          AppMethodBeat.o(202894);
        }
        catch (Throwable localThrowable2)
        {
          Log.e("AdLandingNewH5Comp", "there is no getJsApiHandler method, the jsApiHandler object may be null!!");
        }
      }
      if (this.mHt == null) {}
      return;
      label235:
      Object localObject3 = null;
    }
  }
  
  private void l(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(202890);
    HashMap localHashMap = new HashMap();
    localHashMap.put("ret", Integer.valueOf(paramInt));
    localHashMap.put("device_id", Util.nullAsNil(paramString3));
    g(paramString1, paramString2, localHashMap);
    AppMethodBeat.o(202890);
  }
  
  protected final void eWT()
  {
    AppMethodBeat.i(96462);
    WebView localWebView;
    Object localObject;
    String str1;
    if ((an)fdr() != null)
    {
      localWebView = (WebView)getView();
      localObject = (an)fdr();
      if (TextUtils.isEmpty(((an)localObject).url)) {
        break label222;
      }
      str1 = "uxinfo=" + fds().uxInfo;
      String str2 = AdLandingPagesProxy.getInstance().getUin();
      String str3 = "uin=".concat(String.valueOf(str2));
      str1 = ap.n(((an)localObject).url, new String[] { str1, str3 });
      if (((an)localObject).subType != 1) {
        break label238;
      }
      localObject = AdLandingPagesProxy.getInstance().getAdVoteInfo(((an)localObject).url, fds().uxInfo, str2);
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
          if (this.EcF == null)
          {
            this.EcF = new IListener()
            {
              private boolean a(vc paramAnonymousvc)
              {
                AppMethodBeat.i(202883);
                try
                {
                  j localj = j.this;
                  int i = paramAnonymousvc.ebu.ebv;
                  if (localj.EcF != null)
                  {
                    localj.EcF.dead();
                    localj.EcF = null;
                  }
                  if (5 == i)
                  {
                    paramAnonymousvc = localj.iGY;
                    if (paramAnonymousvc != null) {
                      paramAnonymousvc.setCleanOnDetached(true);
                    }
                  }
                }
                catch (Throwable paramAnonymousvc)
                {
                  label56:
                  break label56;
                }
                AppMethodBeat.o(202883);
                return false;
              }
            };
            this.EcF.alive();
          }
          AppMethodBeat.o(96462);
          return;
        }
        catch (Throwable localThrowable)
        {
          AppMethodBeat.o(96462);
          return;
        }
        str1 = ((an)localObject).url;
      }
    }
  }
  
  protected final void eWX()
  {
    AppMethodBeat.i(96463);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.EcX.paddingLeft, (int)this.EcX.paddingTop, (int)this.EcX.paddingRight, (int)this.EcX.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(96463);
  }
  
  protected final View eWY()
  {
    AppMethodBeat.i(96464);
    this.mIsDestroyed = false;
    this.iGY = com.tencent.mm.plugin.webview.ui.tools.widget.f.a.Jys.eK(this.context);
    this.iGY.setCleanOnDetached(false);
    this.iGY.getSettings().hsR();
    this.iGY.getSettings().hsV();
    this.iGY.getSettings().hsU();
    this.iGY.setWebViewClient(c.a.Jyr.a(this.iGY, false, new d()
    {
      public final boolean f(int paramAnonymousInt, Bundle paramAnonymousBundle)
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
            localObject = (an)j.this.fdr();
            paramAnonymousInt = paramAnonymousBundle.getInt("sns_landing_pages_ad_vote_index");
            paramAnonymousBundle = paramAnonymousBundle.getString("sns_landing_pages_ad_vote_result");
            AdLandingPagesProxy.getInstance().saveAdVoteInfo(((an)localObject).url, j.this.fds().uxInfo, j.this.fds().uin, paramAnonymousInt, 0, paramAnonymousBundle);
          }
        case 151: 
          for (;;)
          {
            try
            {
              localObject = new Intent();
              String str = ap.n(paramAnonymousBundle.getString("sns_landing_pages_ad_jumpurl"), new String[] { "traceid=" + j.this.fds().kZe, "aid=" + j.this.fds().aid });
              paramAnonymousBundle = j.this.fds().DZW;
              if (!TextUtils.isEmpty(paramAnonymousBundle)) {
                break label356;
              }
              paramAnonymousBundle = j.this.fds().uxInfo;
              Log.i("AdLandingNewH5Comp", "opJumpView, use orig_UxInfo:".concat(String.valueOf(paramAnonymousBundle)));
              str = r.kb(str, paramAnonymousBundle);
              r.h((Intent)localObject, paramAnonymousBundle);
              ((Intent)localObject).putExtra("rawUrl", str);
              ((Intent)localObject).putExtra("useJs", true);
              ((Intent)localObject).putExtra("type", -255);
              ((Intent)localObject).putExtra("geta8key_scene", 2);
              com.tencent.mm.br.c.b(j.this.context, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
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
        boolean bool = j.this.ks((String)localObject, paramAnonymousBundle);
        AppMethodBeat.o(96461);
        return bool;
      }
    }));
    MMWebView localMMWebView = this.iGY;
    AppMethodBeat.o(96464);
    return localMMWebView;
  }
  
  public final void eWZ()
  {
    AppMethodBeat.i(202888);
    super.eWZ();
    try
    {
      MMWebView localMMWebView = this.iGY;
      if (localMMWebView != null) {
        localMMWebView.postOnAnimation(this.EcH);
      }
      AppMethodBeat.o(202888);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(202888);
    }
  }
  
  public final void eXd()
  {
    AppMethodBeat.i(96465);
    super.eXd();
    WebView localWebView = (WebView)getView();
    if ((localWebView != null) && (localWebView.getParent() != null))
    {
      ((ViewGroup)localWebView.getParent()).removeView(localWebView);
      localWebView.setTag(null);
      localWebView.destroy();
    }
    this.mIsDestroyed = true;
    this.mHt = null;
    this.contentView = null;
    AppMethodBeat.o(96465);
  }
  
  final void g(String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(202895);
    fdd();
    com.tencent.mm.plugin.webview.d.h localh = this.mHt;
    if (localh != null)
    {
      Log.d("AdLandingNewH5Comp", "the js api handler is called!!");
      localh.a(paramString1, paramString2, paramMap, true);
      AppMethodBeat.o(202895);
      return;
    }
    Log.w("AdLandingNewH5Comp", "the js api handler is null!!");
    AppMethodBeat.o(202895);
  }
  
  final boolean ks(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(202889);
    try
    {
      Log.i("AdLandingNewH5Comp", "handleJSAPI, params=".concat(String.valueOf(paramString1)));
      paramString1 = new JSONObject(paramString1);
      localObject = paramString1.optString("funcName");
      if ("opUpdateContentHeight".equals(localObject)) {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(202879);
            if ((j.this.contentView != null) && (this.EcK >= 0)) {
              try
              {
                ViewGroup.LayoutParams localLayoutParams = j.this.contentView.getLayoutParams();
                int i = (int)i.a(this.EcK, 1, 750, 1);
                Log.i("AdLandingNewH5Comp", "adJuestHeight, curH=" + localLayoutParams.height + ", newH=" + this.EcK + ", newPx=" + i);
                if (localLayoutParams.height != i)
                {
                  ((an)j.this.fdr()).DZl = i;
                  j.this.fdp();
                }
                AppMethodBeat.o(202879);
                return;
              }
              catch (Exception localException)
              {
                Log.e("AdLandingNewH5Comp", "adJuestHeight exp=" + localException.toString());
              }
            }
            AppMethodBeat.o(202879);
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(202889);
        return false;
        if (!"opStartQRScan".equals(localObject)) {
          break;
        }
        paramString1.getString("scanUrl");
      }
    }
    catch (Exception paramString1)
    {
      Object localObject;
      label289:
      label296:
      do
      {
        for (;;)
        {
          Log.e("AdLandingNewH5Comp", "handleJSAPI, exp=" + paramString1.toString());
          continue;
          if (!"opEndQRScan".equals(localObject)) {
            break;
          }
          paramString2 = paramString1.getString("scanUrl");
          for (;;)
          {
            try
            {
              if (this.EcI == null)
              {
                localObject = new Bundle();
                paramString1 = (an)fdr();
                if (paramString1 == null) {
                  break label289;
                }
                paramString1 = paramString1.DYM;
                ((Bundle)localObject).putString("qrExtInfo", paramString1);
                this.EcI = new com.tencent.mm.plugin.sns.data.h(this.context, fds(), 2, (Bundle)localObject);
              }
              paramString1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kz("adId", paramString2);
              if ((TextUtils.isEmpty(paramString1)) || (!s.YS(paramString1))) {
                break label296;
              }
              Log.i("AdLandingNewH5Comp", "local file exists, imageUrl=".concat(String.valueOf(paramString2)));
              this.EcI.jX(paramString1, paramString2);
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
            localObject = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kz("adId", paramString2 + "_shoot");
            OutputStream localOutputStream = s.ap(new o((String)localObject));
            boolean bool = paramString1.compress(Bitmap.CompressFormat.JPEG, 100, localOutputStream);
            localOutputStream.flush();
            localOutputStream.close();
            if (bool)
            {
              Log.i("AdLandingNewH5Comp", "shoot save succ");
              this.EcI.jX((String)localObject, paramString2);
            }
          }
          com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(paramString2, ((an)fdr()).DZj, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a()
          {
            public final void aNH(String paramAnonymousString)
            {
              AppMethodBeat.i(202881);
              Log.i("AdLandingNewH5Comp", "onDownloaded, imageUrl=" + paramString2);
              AppMethodBeat.o(202881);
            }
            
            public final void eWN() {}
            
            public final void eWO()
            {
              AppMethodBeat.i(202880);
              Log.e("AdLandingNewH5Comp", "onDownloadError, imageUrl=" + paramString2);
              AppMethodBeat.o(202880);
            }
          });
        }
        if ("opGetLocation".equals(localObject))
        {
          paramString1 = paramString1.optString("type");
          paramString2 = a.a(this.context, new a(paramString2, this));
          if (paramString2 != null) {
            paramString2.request(paramString1);
          }
          AppMethodBeat.o(202889);
          return true;
        }
      } while (!"opGetDeviceInfo".equals(localObject));
      if (aPW(this.iGY.getUrl())) {
        break label530;
      }
    }
    l(paramString2, -2, "url permission denied", "");
    for (;;)
    {
      AppMethodBeat.o(202889);
      return true;
      label530:
      if (!com.tencent.mm.pluginsdk.permission.b.e(this.context, new String[] { "android.permission.READ_PHONE_STATE" }))
      {
        l(paramString2, -3, "system permission denied", "");
      }
      else
      {
        paramString1 = q.dr(false);
        if (TextUtils.isEmpty(paramString1)) {
          l(paramString2, -1, "id is empty", "");
        } else {
          l(paramString2, 0, "ok", MD5Util.getMD5String(paramString1));
        }
      }
    }
  }
  
  static final class a
    implements a.a
  {
    private String EcL;
    private Reference<j> EcM;
    
    a(String paramString, j paramj)
    {
      AppMethodBeat.i(202885);
      this.EcL = paramString;
      this.EcM = new WeakReference(paramj);
      AppMethodBeat.o(202885);
    }
    
    public final void aH(Map<String, Object> paramMap)
    {
      AppMethodBeat.i(202886);
      try
      {
        Log.i("AdLandingNewH5Comp", "onGeoCallback is called!");
        String str = this.EcL;
        j localj = (j)this.EcM.get();
        if ((str != null) && (localj != null)) {
          localj.g(str, "GEO", paramMap);
        }
        AppMethodBeat.o(202886);
        return;
      }
      catch (Throwable paramMap)
      {
        Log.e("AdLandingNewH5Comp", "there is a exception in onGeoCallback");
        AppMethodBeat.o(202886);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.j
 * JD-Core Version:    0.7.0.1
 */