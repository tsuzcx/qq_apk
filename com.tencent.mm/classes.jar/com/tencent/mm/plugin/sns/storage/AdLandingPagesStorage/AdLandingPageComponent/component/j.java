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
import com.tencent.mm.g.a.ue;
import com.tencent.mm.g.a.ue.a;
import com.tencent.mm.plugin.sns.ad.landingpage.helper.a.a;
import com.tencent.mm.plugin.sns.ad.landingpage.helper.a.b;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.al;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.webview.ui.tools.widget.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.xweb.WebView;
import com.tencent.xweb.z;
import java.io.OutputStream;
import java.lang.reflect.Method;
import org.json.JSONObject;

public final class j
  extends m
{
  MMWebView hLV;
  com.tencent.mm.plugin.webview.c.f lAf;
  volatile boolean mIsDestroyed;
  com.tencent.mm.plugin.sns.data.h zUA;
  com.tencent.mm.sdk.b.c<ue> zUy;
  private Runnable zUz;
  
  public j(Context paramContext, y paramy, ViewGroup paramViewGroup)
  {
    super(paramContext, paramy, paramViewGroup);
    AppMethodBeat.i(219437);
    this.mIsDestroyed = false;
    this.zUz = new j.2(this);
    this.zUA = null;
    AppMethodBeat.o(219437);
  }
  
  static Method aU(Class<?> paramClass)
  {
    AppMethodBeat.i(219440);
    try
    {
      paramClass = paramClass.getMethod("getJsapi", new Class[0]);
      AppMethodBeat.o(219440);
      return paramClass;
    }
    catch (Throwable paramClass)
    {
      ae.e("AdLandingNewH5Comp", "there is no method named getJsapi");
      AppMethodBeat.o(219440);
    }
    return null;
  }
  
  static Method aV(Class<?> paramClass)
  {
    AppMethodBeat.i(219441);
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
          if (localClass != com.tencent.mm.plugin.webview.c.f.class) {
            continue;
          }
          localObject1 = localObject3;
          if (!com.tencent.mm.plugin.sns.ad.f.c.w(arrayOfClass)) {
            continue;
          }
        }
        localObject1 = paramClass;
        if (paramClass == null)
        {
          localObject1 = paramClass;
          ae.w("AdLandingNewH5Comp", "there is no method satisfying the condition");
          localObject1 = paramClass;
        }
      }
      catch (Throwable paramClass)
      {
        int i;
        ae.e("AdLandingNewH5Comp", "finding the js method occurs something exception");
        continue;
      }
      AppMethodBeat.o(219441);
      return localObject1;
      i += 1;
    }
  }
  
  protected final void dUJ()
  {
    AppMethodBeat.i(96462);
    WebView localWebView;
    Object localObject;
    String str1;
    if ((al)eaC() != null)
    {
      localWebView = (WebView)getView();
      localObject = (al)eaC();
      if (TextUtils.isEmpty(((al)localObject).url)) {
        break label216;
      }
      str1 = "uxinfo=" + eaD().dGD;
      String str2 = AdLandingPagesProxy.getInstance().getUin();
      String str3 = "uin=".concat(String.valueOf(str2));
      str1 = an.n(((al)localObject).url, new String[] { str1, str3 });
      if (((al)localObject).subType != 1) {
        break label231;
      }
      localObject = AdLandingPagesProxy.getInstance().getAdVoteInfo(((al)localObject).url, eaD().dGD, str2);
      if (bu.isNullOrNil((String)localObject)) {
        break label231;
      }
      str1 = str1 + "&" + (String)localObject;
    }
    label216:
    label231:
    for (;;)
    {
      ae.i("AdLandingNewH5Comp", "final url=".concat(String.valueOf(str1)));
      for (;;)
      {
        localWebView.loadUrl(str1);
        try
        {
          if (this.zUy == null)
          {
            this.zUy = new com.tencent.mm.sdk.b.c()
            {
              private boolean a(ue paramAnonymousue)
              {
                AppMethodBeat.i(219433);
                try
                {
                  j localj = j.this;
                  int i = paramAnonymousue.dJH.dJI;
                  if (localj.zUy != null)
                  {
                    localj.zUy.dead();
                    localj.zUy = null;
                  }
                  if (5 == i)
                  {
                    paramAnonymousue = localj.hLV;
                    if (paramAnonymousue != null) {
                      paramAnonymousue.setCleanOnDetached(true);
                    }
                  }
                }
                catch (Throwable paramAnonymousue)
                {
                  label56:
                  break label56;
                }
                AppMethodBeat.o(219433);
                return false;
              }
            };
            this.zUy.alive();
          }
          AppMethodBeat.o(96462);
          return;
        }
        catch (Throwable localThrowable)
        {
          AppMethodBeat.o(96462);
          return;
        }
        str1 = ((al)localObject).url;
      }
    }
  }
  
  public final void dUK()
  {
    AppMethodBeat.i(219438);
    super.dUK();
    try
    {
      MMWebView localMMWebView = this.hLV;
      if (localMMWebView != null) {
        localMMWebView.postOnAnimation(this.zUz);
      }
      AppMethodBeat.o(219438);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(219438);
    }
  }
  
  public final void dUM()
  {
    AppMethodBeat.i(96465);
    super.dUM();
    WebView localWebView = (WebView)getView();
    if ((localWebView != null) && (localWebView.getParent() != null))
    {
      ((ViewGroup)localWebView.getParent()).removeView(localWebView);
      localWebView.setTag(null);
      localWebView.destroy();
    }
    this.mIsDestroyed = true;
    this.lAf = null;
    this.contentView = null;
    AppMethodBeat.o(96465);
  }
  
  protected final View eae()
  {
    AppMethodBeat.i(96464);
    this.mIsDestroyed = false;
    this.hLV = com.tencent.mm.plugin.webview.ui.tools.widget.f.a.EIC.es(this.context);
    this.hLV.setCleanOnDetached(false);
    this.hLV.getSettings().gfA();
    this.hLV.getSettings().gfE();
    this.hLV.getSettings().gfD();
    this.hLV.setWebViewClient(c.a.EIB.a(this.hLV, false, new com.tencent.mm.plugin.webview.ui.tools.widget.d()
    {
      public final boolean g(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(96461);
        ae.i("AdLandingNewH5Comp", "callback, actionCode=".concat(String.valueOf(paramAnonymousInt)));
        switch (paramAnonymousInt)
        {
        default: 
        case 150: 
          for (;;)
          {
            AppMethodBeat.o(96461);
            return false;
            localObject = (al)j.this.eaC();
            paramAnonymousInt = paramAnonymousBundle.getInt("sns_landing_pages_ad_vote_index");
            paramAnonymousBundle = paramAnonymousBundle.getString("sns_landing_pages_ad_vote_result");
            AdLandingPagesProxy.getInstance().saveAdVoteInfo(((al)localObject).url, j.this.eaD().dGD, j.this.eaD().uin, paramAnonymousInt, 0, paramAnonymousBundle);
          }
        case 151: 
          for (;;)
          {
            try
            {
              localObject = new Intent();
              String str = an.n(paramAnonymousBundle.getString("sns_landing_pages_ad_jumpurl"), new String[] { "traceid=" + j.this.eaD().jWi, "aid=" + j.this.eaD().zMk });
              paramAnonymousBundle = j.this.eaD().zRP;
              if (!TextUtils.isEmpty(paramAnonymousBundle)) {
                break label356;
              }
              paramAnonymousBundle = j.this.eaD().dGD;
              ae.i("AdLandingNewH5Comp", "opJumpView, use orig_UxInfo:".concat(String.valueOf(paramAnonymousBundle)));
              str = r.jo(str, paramAnonymousBundle);
              r.g((Intent)localObject, paramAnonymousBundle);
              ((Intent)localObject).putExtra("rawUrl", str);
              ((Intent)localObject).putExtra("useJs", true);
              ((Intent)localObject).putExtra("type", -255);
              ((Intent)localObject).putExtra("geta8key_scene", 2);
              com.tencent.mm.br.d.b(j.this.context, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
              ae.i("AdLandingNewH5Comp", "jumpUrl, finalUrl=".concat(String.valueOf(str)));
            }
            catch (Exception paramAnonymousBundle)
            {
              ae.e("AdLandingNewH5Comp", "OptJump exp=" + paramAnonymousBundle.toString());
            }
            break;
            label356:
            ae.i("AdLandingNewH5Comp", "opJumpView, use updated_UxInfo:".concat(String.valueOf(paramAnonymousBundle)));
          }
        }
        Object localObject = paramAnonymousBundle.getString("sns_landing_pages_h5_params");
        paramAnonymousBundle = paramAnonymousBundle.getString("callbackId");
        boolean bool = j.this.jF((String)localObject, paramAnonymousBundle);
        AppMethodBeat.o(96461);
        return bool;
      }
    }));
    MMWebView localMMWebView = this.hLV;
    AppMethodBeat.o(96464);
    return localMMWebView;
  }
  
  protected final void eah()
  {
    AppMethodBeat.i(96463);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.zUP.paddingLeft, (int)this.zUP.paddingTop, (int)this.zUP.paddingRight, (int)this.zUP.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(96463);
  }
  
  final boolean jF(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(219439);
    try
    {
      ae.i("AdLandingNewH5Comp", "handleJSAPI, params=".concat(String.valueOf(paramString1)));
      paramString1 = new JSONObject(paramString1);
      localObject = paramString1.optString("funcName");
      if ("opUpdateContentHeight".equals(localObject)) {
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(219429);
            if ((j.this.contentView != null) && (this.zUC >= 0)) {
              try
              {
                ViewGroup.LayoutParams localLayoutParams = j.this.contentView.getLayoutParams();
                int i = (int)i.a(this.zUC, 1, 750, 1);
                ae.i("AdLandingNewH5Comp", "adJuestHeight, curH=" + localLayoutParams.height + ", newH=" + this.zUC + ", newPx=" + i);
                if (localLayoutParams.height != i)
                {
                  ((al)j.this.eaC()).zRj = i;
                  j.this.eaA();
                }
                AppMethodBeat.o(219429);
                return;
              }
              catch (Exception localException)
              {
                ae.e("AdLandingNewH5Comp", "adJuestHeight exp=" + localException.toString());
              }
            }
            AppMethodBeat.o(219429);
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(219439);
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
          ae.e("AdLandingNewH5Comp", "handleJSAPI, exp=" + paramString1.toString());
          continue;
          if (!"opEndQRScan".equals(localObject)) {
            break;
          }
          paramString2 = paramString1.getString("scanUrl");
          for (;;)
          {
            try
            {
              if (this.zUA == null)
              {
                localObject = new Bundle();
                paramString1 = (al)eaC();
                if (paramString1 == null) {
                  break label289;
                }
                paramString1 = paramString1.zQM;
                ((Bundle)localObject).putString("qrExtInfo", paramString1);
                this.zUA = new com.tencent.mm.plugin.sns.data.h(this.context, eaD(), 2, (Bundle)localObject);
              }
              paramString1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.jL("adId", paramString2);
              if ((TextUtils.isEmpty(paramString1)) || (!o.fB(paramString1))) {
                break label296;
              }
              ae.i("AdLandingNewH5Comp", "local file exists, imageUrl=".concat(String.valueOf(paramString2)));
              this.zUA.jl(paramString1, paramString2);
            }
            catch (Throwable paramString1)
            {
              ae.e("AdLandingNewH5Comp", "handleQR, exp=" + paramString1.toString());
            }
            break;
            paramString1 = "";
          }
          paramString1 = com.tencent.mm.sdk.platformtools.h.fZ(this.contentView);
          if (paramString1 != null)
          {
            ae.i("AdLandingNewH5Comp", "shoot webView succ");
            localObject = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.jL("adId", paramString2 + "_shoot");
            OutputStream localOutputStream = o.aj(new k((String)localObject));
            boolean bool = paramString1.compress(Bitmap.CompressFormat.JPEG, 100, localOutputStream);
            localOutputStream.flush();
            localOutputStream.close();
            if (bool)
            {
              ae.i("AdLandingNewH5Comp", "shoot save succ");
              this.zUA.jl((String)localObject, paramString2);
            }
          }
          com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(paramString2, ((al)eaC()).zRh, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a()
          {
            public final void ayY(String paramAnonymousString)
            {
              AppMethodBeat.i(219431);
              ae.i("AdLandingNewH5Comp", "onDownloaded, imageUrl=" + paramString2);
              AppMethodBeat.o(219431);
            }
            
            public final void dVu() {}
            
            public final void dVv()
            {
              AppMethodBeat.i(219430);
              ae.e("AdLandingNewH5Comp", "onDownloadError, imageUrl=" + paramString2);
              AppMethodBeat.o(219430);
            }
          });
        }
      } while (!"opGetLocation".equals(localObject));
      paramString1 = paramString1.optString("type");
      paramString2 = a.a(this.context, new j.a(paramString2, this));
      if (paramString2 != null) {
        paramString2.request(paramString1);
      }
      AppMethodBeat.o(219439);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.j
 * JD-Core Version:    0.7.0.1
 */