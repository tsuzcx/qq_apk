package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.landingpage.helper.a.a;
import com.tencent.mm.plugin.sns.ad.landingpage.helper.a.b;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.webview.ui.tools.widget.c;
import com.tencent.mm.plugin.webview.ui.tools.widget.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.e;
import com.tencent.xweb.WebView;
import com.tencent.xweb.z;
import java.io.OutputStream;
import java.lang.reflect.Method;
import org.json.JSONObject;

public final class j
  extends l
{
  MMWebView hJc;
  com.tencent.mm.plugin.webview.c.f lvH;
  volatile boolean mIsDestroyed;
  private Runnable zDw;
  com.tencent.mm.plugin.sns.data.g zDx;
  
  public j(Context paramContext, x paramx, ViewGroup paramViewGroup)
  {
    super(paramContext, paramx, paramViewGroup);
    AppMethodBeat.i(197937);
    this.mIsDestroyed = false;
    this.zDw = new j.2(this);
    this.zDx = null;
    AppMethodBeat.o(197937);
  }
  
  static Method aU(Class<?> paramClass)
  {
    AppMethodBeat.i(197940);
    try
    {
      paramClass = paramClass.getMethod("getJsapi", new Class[0]);
      AppMethodBeat.o(197940);
      return paramClass;
    }
    catch (Throwable paramClass)
    {
      ad.e("AdLandingNewH5Comp", "there is no method named getJsapi");
      AppMethodBeat.o(197940);
    }
    return null;
  }
  
  static Method aV(Class<?> paramClass)
  {
    AppMethodBeat.i(197941);
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
        ad.e("AdLandingNewH5Comp", "finding the js method occurs something exception");
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
        ad.w("AdLandingNewH5Comp", "there is no method satisfying the condition");
        localObject1 = paramClass;
      }
      AppMethodBeat.o(197941);
      return localObject1;
      j = 0;
      continue;
      i += 1;
    }
  }
  
  protected final void dRl()
  {
    AppMethodBeat.i(96462);
    WebView localWebView;
    Object localObject;
    String str1;
    if ((ak)dWY() != null)
    {
      localWebView = (WebView)getView();
      localObject = (ak)dWY();
      if (TextUtils.isEmpty(((ak)localObject).url)) {
        break label189;
      }
      str1 = "uxinfo=" + dWZ().dFy;
      String str2 = AdLandingPagesProxy.getInstance().getUin();
      String str3 = "uin=".concat(String.valueOf(str2));
      str1 = am.n(((ak)localObject).url, new String[] { str1, str3 });
      if (((ak)localObject).subType != 1) {
        break label197;
      }
      localObject = AdLandingPagesProxy.getInstance().getAdVoteInfo(((ak)localObject).url, dWZ().dFy, str2);
      if (bt.isNullOrNil((String)localObject)) {
        break label197;
      }
      str1 = str1 + "&" + (String)localObject;
    }
    label189:
    label197:
    for (;;)
    {
      ad.i("AdLandingNewH5Comp", "final url=".concat(String.valueOf(str1)));
      for (;;)
      {
        localWebView.loadUrl(str1);
        AppMethodBeat.o(96462);
        return;
        str1 = ((ak)localObject).url;
      }
    }
  }
  
  public final void dRm()
  {
    AppMethodBeat.i(197938);
    super.dRm();
    try
    {
      MMWebView localMMWebView = this.hJc;
      if (localMMWebView != null) {
        localMMWebView.postOnAnimation(this.zDw);
      }
      AppMethodBeat.o(197938);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(197938);
    }
  }
  
  public final void dRo()
  {
    AppMethodBeat.i(96465);
    super.dRo();
    WebView localWebView = (WebView)getView();
    if ((localWebView != null) && (localWebView.getParent() != null))
    {
      ((ViewGroup)localWebView.getParent()).removeView(localWebView);
      localWebView.setTag(null);
      localWebView.destroy();
    }
    this.mIsDestroyed = true;
    this.lvH = null;
    this.contentView = null;
    AppMethodBeat.o(96465);
  }
  
  protected final View dWC()
  {
    AppMethodBeat.i(96464);
    this.mIsDestroyed = false;
    this.hJc = com.tencent.mm.plugin.webview.ui.tools.widget.f.a.Eqm.eo(this.context);
    this.hJc.getSettings().gaY();
    this.hJc.getSettings().gbc();
    this.hJc.getSettings().gbb();
    this.hJc.setWebViewClient(c.a.Eql.a(this.hJc, false, new com.tencent.mm.plugin.webview.ui.tools.widget.d()
    {
      public final boolean g(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(96461);
        ad.i("AdLandingNewH5Comp", "callback, actionCode=".concat(String.valueOf(paramAnonymousInt)));
        switch (paramAnonymousInt)
        {
        default: 
        case 150: 
          for (;;)
          {
            AppMethodBeat.o(96461);
            return false;
            localObject = (ak)j.this.dWY();
            paramAnonymousInt = paramAnonymousBundle.getInt("sns_landing_pages_ad_vote_index");
            paramAnonymousBundle = paramAnonymousBundle.getString("sns_landing_pages_ad_vote_result");
            AdLandingPagesProxy.getInstance().saveAdVoteInfo(((ak)localObject).url, j.this.dWZ().dFy, j.this.dWZ().uin, paramAnonymousInt, 0, paramAnonymousBundle);
          }
        case 151: 
          for (;;)
          {
            try
            {
              localObject = new Intent();
              String str = am.n(paramAnonymousBundle.getString("sns_landing_pages_ad_jumpurl"), new String[] { "traceid=" + j.this.dWZ().jSR, "aid=" + j.this.dWZ().zuP });
              paramAnonymousBundle = j.this.dWZ().zAP;
              if (!TextUtils.isEmpty(paramAnonymousBundle)) {
                break label356;
              }
              paramAnonymousBundle = j.this.dWZ().dFy;
              ad.i("AdLandingNewH5Comp", "opJumpView, use orig_UxInfo:".concat(String.valueOf(paramAnonymousBundle)));
              str = q.jh(str, paramAnonymousBundle);
              q.g((Intent)localObject, paramAnonymousBundle);
              ((Intent)localObject).putExtra("rawUrl", str);
              ((Intent)localObject).putExtra("useJs", true);
              ((Intent)localObject).putExtra("type", -255);
              ((Intent)localObject).putExtra("geta8key_scene", 2);
              com.tencent.mm.bs.d.b(j.this.context, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
              ad.i("AdLandingNewH5Comp", "jumpUrl, finalUrl=".concat(String.valueOf(str)));
            }
            catch (Exception paramAnonymousBundle)
            {
              ad.e("AdLandingNewH5Comp", "OptJump exp=" + paramAnonymousBundle.toString());
            }
            break;
            label356:
            ad.i("AdLandingNewH5Comp", "opJumpView, use updated_UxInfo:".concat(String.valueOf(paramAnonymousBundle)));
          }
        }
        Object localObject = paramAnonymousBundle.getString("sns_landing_pages_h5_params");
        paramAnonymousBundle = paramAnonymousBundle.getString("callbackId");
        boolean bool = j.this.jy((String)localObject, paramAnonymousBundle);
        AppMethodBeat.o(96461);
        return bool;
      }
    }));
    MMWebView localMMWebView = this.hJc;
    AppMethodBeat.o(96464);
    return localMMWebView;
  }
  
  protected final void dWF()
  {
    AppMethodBeat.i(96463);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.zDK.paddingLeft, (int)this.zDK.paddingTop, (int)this.zDK.paddingRight, (int)this.zDK.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(96463);
  }
  
  final boolean jy(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(197939);
    try
    {
      ad.i("AdLandingNewH5Comp", "handleJSAPI, params=".concat(String.valueOf(paramString1)));
      paramString1 = new JSONObject(paramString1);
      localObject = paramString1.optString("funcName");
      if ("opUpdateContentHeight".equals(localObject)) {
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(197932);
            if ((j.this.contentView != null) && (this.zDz >= 0)) {
              try
              {
                ViewGroup.LayoutParams localLayoutParams = j.this.contentView.getLayoutParams();
                int i = (int)com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(this.zDz, 1, 750, 1);
                ad.i("AdLandingNewH5Comp", "adJuestHeight, curH=" + localLayoutParams.height + ", newH=" + this.zDz + ", newPx=" + i);
                if (localLayoutParams.height != i)
                {
                  ((ak)j.this.dWY()).zAj = i;
                  j.this.dWW();
                }
                AppMethodBeat.o(197932);
                return;
              }
              catch (Exception localException)
              {
                ad.e("AdLandingNewH5Comp", "adJuestHeight exp=" + localException.toString());
              }
            }
            AppMethodBeat.o(197932);
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(197939);
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
          ad.e("AdLandingNewH5Comp", "handleJSAPI, exp=" + paramString1.toString());
          continue;
          if (!"opEndQRScan".equals(localObject)) {
            break;
          }
          paramString2 = paramString1.getString("scanUrl");
          for (;;)
          {
            try
            {
              if (this.zDx == null)
              {
                localObject = new Bundle();
                paramString1 = (ak)dWY();
                if (paramString1 == null) {
                  break label289;
                }
                paramString1 = paramString1.zzN;
                ((Bundle)localObject).putString("qrExtInfo", paramString1);
                this.zDx = new com.tencent.mm.plugin.sns.data.g(this.context, dWZ(), 2, (Bundle)localObject);
              }
              paramString1 = h.jF("adId", paramString2);
              if ((TextUtils.isEmpty(paramString1)) || (!com.tencent.mm.vfs.i.fv(paramString1))) {
                break label296;
              }
              ad.i("AdLandingNewH5Comp", "local file exists, imageUrl=".concat(String.valueOf(paramString2)));
              this.zDx.je(paramString1, paramString2);
            }
            catch (Throwable paramString1)
            {
              ad.e("AdLandingNewH5Comp", "handleQR, exp=" + paramString1.toString());
            }
            break;
            paramString1 = "";
          }
          paramString1 = com.tencent.mm.sdk.platformtools.g.ga(this.contentView);
          if (paramString1 != null)
          {
            ad.i("AdLandingNewH5Comp", "shoot webView succ");
            localObject = h.jF("adId", paramString2 + "_shoot");
            OutputStream localOutputStream = com.tencent.mm.vfs.i.aj(new e((String)localObject));
            boolean bool = paramString1.compress(Bitmap.CompressFormat.JPEG, 100, localOutputStream);
            localOutputStream.flush();
            localOutputStream.close();
            if (bool)
            {
              ad.i("AdLandingNewH5Comp", "shoot save succ");
              this.zDx.je((String)localObject, paramString2);
            }
          }
          h.a(paramString2, ((ak)dWY()).zAh, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a()
          {
            public final void axG(String paramAnonymousString)
            {
              AppMethodBeat.i(197934);
              ad.i("AdLandingNewH5Comp", "onDownloaded, imageUrl=" + paramString2);
              AppMethodBeat.o(197934);
            }
            
            public final void dRW() {}
            
            public final void dRX()
            {
              AppMethodBeat.i(197933);
              ad.e("AdLandingNewH5Comp", "onDownloadError, imageUrl=" + paramString2);
              AppMethodBeat.o(197933);
            }
          });
        }
      } while (!"opGetLocation".equals(localObject));
      paramString1 = paramString1.optString("type");
      paramString2 = a.a(this.context, new j.a(paramString2, this));
      if (paramString2 != null) {
        paramString2.request(paramString1);
      }
      AppMethodBeat.o(197939);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.j
 * JD-Core Version:    0.7.0.1
 */