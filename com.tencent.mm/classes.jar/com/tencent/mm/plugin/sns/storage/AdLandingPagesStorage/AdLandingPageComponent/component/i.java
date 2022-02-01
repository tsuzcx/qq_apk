package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.c.a.a.a;
import com.tencent.mm.plugin.sns.ad.c.a.a.a.a;
import com.tencent.mm.plugin.sns.ad.c.a.a.b;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.webview.ui.tools.widget.c;
import com.tencent.mm.plugin.webview.ui.tools.widget.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.e;
import com.tencent.xweb.WebView;
import com.tencent.xweb.z;
import java.io.OutputStream;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Map;
import org.json.JSONObject;

public final class i
  extends k
{
  MMWebView hqK;
  com.tencent.mm.plugin.webview.c.f kYF;
  volatile boolean mIsDestroyed = false;
  com.tencent.mm.plugin.sns.data.g ymD = null;
  
  public i(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x paramx, ViewGroup paramViewGroup)
  {
    super(paramContext, paramx, paramViewGroup);
  }
  
  static Method bG(Class<?> paramClass)
  {
    AppMethodBeat.i(210265);
    try
    {
      paramClass = paramClass.getMethod("getJsapi", new Class[0]);
      AppMethodBeat.o(210265);
      return paramClass;
    }
    catch (Throwable paramClass)
    {
      ac.e("AdLandingNewH5Comp", "there is no method named getJsapi");
      AppMethodBeat.o(210265);
    }
    return null;
  }
  
  static Method bH(Class<?> paramClass)
  {
    AppMethodBeat.i(210266);
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    for (;;)
    {
      try
      {
        Method[] arrayOfMethod = paramClass.getDeclaredMethods();
        localObject1 = localObject3;
        int k = arrayOfMethod.length;
        i = 0;
        paramClass = localObject2;
        if (i < k)
        {
          paramClass = arrayOfMethod[i];
          localObject1 = localObject3;
          Class localClass = paramClass.getReturnType();
          localObject1 = localObject3;
          Class[] arrayOfClass = paramClass.getParameterTypes();
          if (localClass != com.tencent.mm.plugin.webview.c.f.class) {
            continue;
          }
          if (arrayOfClass == null) {
            continue;
          }
          localObject1 = localObject3;
          if (arrayOfClass.length != 0) {
            continue;
          }
        }
      }
      catch (Throwable paramClass)
      {
        int i;
        ac.e("AdLandingNewH5Comp", "finding the js method occurs something exception");
        continue;
        int j = 1;
        if (j == 0) {
          continue;
        }
        continue;
      }
      localObject1 = paramClass;
      if (paramClass == null)
      {
        localObject1 = paramClass;
        ac.w("AdLandingNewH5Comp", "there is no method satisfying the condition");
        localObject1 = paramClass;
      }
      AppMethodBeat.o(210266);
      return localObject1;
      j = 0;
      continue;
      i += 1;
    }
  }
  
  public final void dJX()
  {
    AppMethodBeat.i(96465);
    super.dJX();
    WebView localWebView = (WebView)getView();
    if ((localWebView != null) && (localWebView.getParent() != null))
    {
      ((ViewGroup)localWebView.getParent()).removeView(localWebView);
      localWebView.setTag(null);
      localWebView.destroy();
    }
    this.mIsDestroyed = true;
    this.kYF = null;
    this.contentView = null;
    AppMethodBeat.o(96465);
  }
  
  protected final void dKm()
  {
    AppMethodBeat.i(96462);
    WebView localWebView;
    Object localObject;
    String str1;
    if ((aj)dKG() != null)
    {
      localWebView = (WebView)getView();
      localObject = (aj)dKG();
      if (TextUtils.isEmpty(((aj)localObject).url)) {
        break label189;
      }
      str1 = "uxinfo=" + dKH().dtx;
      String str2 = AdLandingPagesProxy.getInstance().getUin();
      String str3 = "uin=".concat(String.valueOf(str2));
      str1 = al.n(((aj)localObject).url, new String[] { str1, str3 });
      if (((aj)localObject).subType != 1) {
        break label197;
      }
      localObject = AdLandingPagesProxy.getInstance().getAdVoteInfo(((aj)localObject).url, dKH().dtx, str2);
      if (bs.isNullOrNil((String)localObject)) {
        break label197;
      }
      str1 = str1 + "&" + (String)localObject;
    }
    label189:
    label197:
    for (;;)
    {
      ac.i("AdLandingNewH5Comp", "final url=".concat(String.valueOf(str1)));
      for (;;)
      {
        localWebView.loadUrl(str1);
        AppMethodBeat.o(96462);
        return;
        str1 = ((aj)localObject).url;
      }
    }
  }
  
  protected final View dKp()
  {
    AppMethodBeat.i(96464);
    this.mIsDestroyed = false;
    this.hqK = com.tencent.mm.plugin.webview.ui.tools.widget.f.a.CMm.eo(this.context);
    this.hqK.getSettings().fJE();
    this.hqK.getSettings().fJI();
    this.hqK.getSettings().fJH();
    this.hqK.setWebViewClient(c.a.CMl.a(this.hqK, false, new com.tencent.mm.plugin.webview.ui.tools.widget.d()
    {
      public final boolean g(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(96461);
        ac.i("AdLandingNewH5Comp", "callback, actionCode=".concat(String.valueOf(paramAnonymousInt)));
        switch (paramAnonymousInt)
        {
        default: 
        case 150: 
          for (;;)
          {
            AppMethodBeat.o(96461);
            return false;
            localObject = (aj)i.this.dKG();
            paramAnonymousInt = paramAnonymousBundle.getInt("sns_landing_pages_ad_vote_index");
            paramAnonymousBundle = paramAnonymousBundle.getString("sns_landing_pages_ad_vote_result");
            AdLandingPagesProxy.getInstance().saveAdVoteInfo(((aj)localObject).url, i.this.dKH().dtx, i.this.dKH().uin, paramAnonymousInt, 0, paramAnonymousBundle);
          }
        case 151: 
          for (;;)
          {
            try
            {
              localObject = new Intent();
              String str = al.n(paramAnonymousBundle.getString("sns_landing_pages_ad_jumpurl"), new String[] { "traceid=" + i.this.dKH().jyU, "aid=" + i.this.dKH().yeO });
              paramAnonymousBundle = i.this.dKH().yka;
              if (!TextUtils.isEmpty(paramAnonymousBundle)) {
                break label356;
              }
              paramAnonymousBundle = i.this.dKH().dtx;
              ac.i("AdLandingNewH5Comp", "opJumpView, use orig_UxInfo:".concat(String.valueOf(paramAnonymousBundle)));
              str = q.iV(str, paramAnonymousBundle);
              q.g((Intent)localObject, paramAnonymousBundle);
              ((Intent)localObject).putExtra("rawUrl", str);
              ((Intent)localObject).putExtra("useJs", true);
              ((Intent)localObject).putExtra("type", -255);
              ((Intent)localObject).putExtra("geta8key_scene", 2);
              com.tencent.mm.br.d.b(i.this.context, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
              ac.i("AdLandingNewH5Comp", "jumpUrl, finalUrl=".concat(String.valueOf(str)));
            }
            catch (Exception paramAnonymousBundle)
            {
              ac.e("AdLandingNewH5Comp", "OptJump exp=" + paramAnonymousBundle.toString());
            }
            break;
            label356:
            ac.i("AdLandingNewH5Comp", "opJumpView, use updated_UxInfo:".concat(String.valueOf(paramAnonymousBundle)));
          }
        }
        Object localObject = paramAnonymousBundle.getString("sns_landing_pages_h5_params");
        paramAnonymousBundle = paramAnonymousBundle.getString("callbackId");
        boolean bool = i.this.jm((String)localObject, paramAnonymousBundle);
        AppMethodBeat.o(96461);
        return bool;
      }
    }));
    MMWebView localMMWebView = this.hqK;
    AppMethodBeat.o(96464);
    return localMMWebView;
  }
  
  protected final void dKs()
  {
    AppMethodBeat.i(96463);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.ymQ.paddingLeft, (int)this.ymQ.paddingTop, (int)this.ymQ.paddingRight, (int)this.ymQ.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(96463);
  }
  
  final boolean jm(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(200169);
    try
    {
      ac.i("AdLandingNewH5Comp", "handleJSAPI, params=".concat(String.valueOf(paramString1)));
      paramString1 = new JSONObject(paramString1);
      localObject = paramString1.optString("funcName");
      if ("opUpdateContentHeight".equals(localObject)) {
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(176275);
            if ((i.this.contentView != null) && (this.ymF >= 0)) {
              try
              {
                ViewGroup.LayoutParams localLayoutParams = i.this.contentView.getLayoutParams();
                int i = (int)com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(this.ymF, 1, 750, 1);
                ac.i("AdLandingNewH5Comp", "adJuestHeight, curH=" + localLayoutParams.height + ", newH=" + this.ymF + ", newPx=" + i);
                if (localLayoutParams.height != i)
                {
                  ((aj)i.this.dKG()).yjv = i;
                  i.this.dKE();
                }
                AppMethodBeat.o(176275);
                return;
              }
              catch (Exception localException)
              {
                ac.e("AdLandingNewH5Comp", "adJuestHeight exp=" + localException.toString());
              }
            }
            AppMethodBeat.o(176275);
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(200169);
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
          ac.e("AdLandingNewH5Comp", "handleJSAPI, exp=" + paramString1.toString());
          continue;
          if (!"opEndQRScan".equals(localObject)) {
            break;
          }
          paramString2 = paramString1.getString("scanUrl");
          for (;;)
          {
            try
            {
              if (this.ymD == null)
              {
                localObject = new Bundle();
                paramString1 = (aj)dKG();
                if (paramString1 == null) {
                  break label289;
                }
                paramString1 = paramString1.yjf;
                ((Bundle)localObject).putString("qrExtInfo", paramString1);
                this.ymD = new com.tencent.mm.plugin.sns.data.g(this.context, dKH(), 2, (Bundle)localObject);
              }
              paramString1 = h.js("adId", paramString2);
              if ((TextUtils.isEmpty(paramString1)) || (!com.tencent.mm.vfs.i.eA(paramString1))) {
                break label296;
              }
              ac.i("AdLandingNewH5Comp", "local file exists, imageUrl=".concat(String.valueOf(paramString2)));
              this.ymD.iT(paramString1, paramString2);
            }
            catch (Throwable paramString1)
            {
              ac.e("AdLandingNewH5Comp", "handleQR, exp=" + paramString1.toString());
            }
            break;
            paramString1 = "";
          }
          paramString1 = com.tencent.mm.sdk.platformtools.f.fL(this.contentView);
          if (paramString1 != null)
          {
            ac.i("AdLandingNewH5Comp", "shoot webView succ");
            localObject = h.js("adId", paramString2 + "_shoot");
            OutputStream localOutputStream = com.tencent.mm.vfs.i.ah(new e((String)localObject));
            boolean bool = paramString1.compress(Bitmap.CompressFormat.JPEG, 100, localOutputStream);
            localOutputStream.flush();
            localOutputStream.close();
            if (bool)
            {
              ac.i("AdLandingNewH5Comp", "shoot save succ");
              this.ymD.iT((String)localObject, paramString2);
            }
          }
          h.a(paramString2, ((aj)dKG()).yjt, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a()
          {
            public final void asD(String paramAnonymousString)
            {
              AppMethodBeat.i(176277);
              ac.i("AdLandingNewH5Comp", "onDownloaded, imageUrl=" + paramString2);
              AppMethodBeat.o(176277);
            }
            
            public final void dFC() {}
            
            public final void dFD()
            {
              AppMethodBeat.i(176276);
              ac.e("AdLandingNewH5Comp", "onDownloadError, imageUrl=" + paramString2);
              AppMethodBeat.o(176276);
            }
          });
        }
      } while (!"opGetLocation".equals(localObject));
      paramString1 = paramString1.optString("type");
      paramString2 = a.a(this.context, new a(paramString2, this));
      if (paramString2 != null) {
        paramString2.request(paramString1);
      }
      AppMethodBeat.o(200169);
    }
    return true;
  }
  
  static final class a
    implements a.a
  {
    private String ymG;
    private Reference<i> ymH;
    
    a(String paramString, i parami)
    {
      AppMethodBeat.i(200167);
      this.ymG = paramString;
      this.ymH = new WeakReference(parami);
      AppMethodBeat.o(200167);
    }
    
    public final void az(Map<String, Object> paramMap)
    {
      AppMethodBeat.i(200168);
      for (;;)
      {
        i locali;
        long l;
        try
        {
          ac.i("AdLandingNewH5Comp", "onGeoCallback is called!");
          str = this.ymG;
          locali = (i)this.ymH.get();
          if ((str == null) || (locali == null)) {
            break label344;
          }
          if (locali.kYF == null)
          {
            boolean bool = locali.mIsDestroyed;
            if (bool) {}
          }
          try
          {
            localObject1 = (com.tencent.mm.api.x)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.x.class);
            if (localObject1 == null) {
              break label350;
            }
            localObject1 = ((com.tencent.mm.api.x)localObject1).j(locali.hqK);
            if (localObject1 == null) {
              continue;
            }
            ac.d("AdLandingNewH5Comp", "the jsApiHandler is set from service");
            locali.kYF = ((com.tencent.mm.plugin.webview.c.f)localObject1);
          }
          catch (Throwable localThrowable1)
          {
            Object localObject1;
            Class localClass;
            Method localMethod;
            ac.e("AdLandingNewH5Comp", "ensureJsApiHandlerFromService has something wrong!!");
            continue;
          }
          localObject1 = locali.kYF;
          if (localObject1 != null) {}
        }
        catch (Throwable paramMap)
        {
          String str;
          ac.e("AdLandingNewH5Comp", "there is a exception in onGeoCallback");
          AppMethodBeat.o(200168);
          return;
        }
        try
        {
          l = SystemClock.currentThreadTimeMillis();
          localClass = locali.hqK.getClass();
          localMethod = i.bG(localClass);
          localObject1 = localMethod;
          if (localMethod == null)
          {
            ac.i("AdLandingNewH5Comp", "the js method is not found in getJsapiMethod, try to findJsapiMethod");
            localObject1 = i.bH(localClass);
          }
          if (localObject1 != null) {
            break label246;
          }
          ac.w("AdLandingNewH5Comp", "the js method is not found!");
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            Object localObject2;
            ac.e("AdLandingNewH5Comp", "there is no getJsApiHandler method, the jsApiHandler object may be null!!");
            break;
            ac.w("AdLandingNewH5Comp", "the method return value is null ??");
          }
          ac.w("AdLandingNewH5Comp", "the js api handler is null!!");
        }
        localObject1 = locali.kYF;
        if (localObject1 != null)
        {
          ac.d("AdLandingNewH5Comp", "the js api handler is called!!");
          ((com.tencent.mm.plugin.webview.c.f)localObject1).a(str, "GEO", paramMap, true);
          AppMethodBeat.o(200168);
          return;
          ac.w("AdLandingNewH5Comp", "the jsApiHandler is null from service!");
          continue;
          label246:
          localObject2 = localThrowable1.invoke(locali.hqK, new Object[0]);
          if ((localObject2 instanceof com.tencent.mm.plugin.webview.c.f))
          {
            ac.i("AdLandingNewH5Comp", "the method return type is js api in ensureJsApiHandlerFromWebView");
            locali.kYF = ((com.tencent.mm.plugin.webview.c.f)localObject2);
            ac.i("AdLandingNewH5Comp", "get the js api handler takes : " + (SystemClock.currentThreadTimeMillis() - l));
            continue;
          }
        }
        label344:
        AppMethodBeat.o(200168);
        return;
        label350:
        Object localObject3 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i
 * JD-Core Version:    0.7.0.1
 */