package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.widget.Space;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.ValueCallback;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ud;
import com.tencent.mm.g.a.ud.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae;
import com.tencent.mm.plugin.sns.ui.widget.ad.ScrollableLayout;
import com.tencent.mm.plugin.sns.ui.widget.ad.ScrollableLayout.a;
import com.tencent.mm.plugin.sns.ui.widget.ad.ScrollableLayout.b;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.j.j;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.n;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.mm.ui.widget.MMWebView.b;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.WebView;
import com.tencent.xweb.x.a;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public final class e
  extends l
  implements ScrollableLayout.a, ScrollableLayout.b
{
  MMWebView hJc;
  private c<ud> hJu;
  ScrollableLayout zCN;
  View zCO;
  BaseWebViewController zCP;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e zCQ;
  a zCR;
  private boolean zCS;
  com.tencent.mm.plugin.webview.stub.b zCT;
  
  public e(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e parame, ViewGroup paramViewGroup)
  {
    super(paramContext, parame, paramViewGroup);
    AppMethodBeat.i(197906);
    this.zCS = false;
    this.zCT = new com.tencent.mm.plugin.webview.stub.b()
    {
      public final boolean a(final String paramAnonymousString1, final String paramAnonymousString2, final Bundle paramAnonymousBundle, final boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(197891);
        Object localObject = e.this.zCP;
        if (localObject == null)
        {
          AppMethodBeat.o(197891);
          return false;
        }
        try
        {
          localObject = ((BaseWebViewController)localObject).getJsapi();
          com.tencent.e.h.LTJ.aP(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(197887);
              try
              {
                if (this.zCV != null) {
                  this.zCV.a(paramAnonymousString1, paramAnonymousString2, com.tencent.mm.plugin.webview.c.l.aA(paramAnonymousBundle), paramAnonymousBoolean);
                }
                AppMethodBeat.o(197887);
                return;
              }
              catch (Throwable localThrowable)
              {
                ad.e("AdLandingFloatWebView", "In jsapi onHandleEnd method, it happens something unwanted!");
                AppMethodBeat.o(197887);
              }
            }
          });
          AppMethodBeat.o(197891);
          return false;
        }
        catch (Throwable paramAnonymousString1)
        {
          for (;;)
          {
            ad.e("AdLandingFloatWebView", "In onHandleEnd method, it happens something unwanted!");
          }
        }
      }
      
      public final String dWD()
      {
        AppMethodBeat.i(197890);
        try
        {
          Object localObject = e.this.zCP;
          if (localObject != null)
          {
            localObject = ((BaseWebViewController)localObject).DGb;
            AppMethodBeat.o(197890);
            return localObject;
          }
        }
        catch (Throwable localThrowable)
        {
          ad.e("AdLandingFloatWebView", "callback: getCommitUrl failed");
          AppMethodBeat.o(197890);
        }
        return "";
      }
      
      public final boolean g(int paramAnonymousInt, final Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(197893);
        try
        {
          Object localObject = e.this.zCP;
          if (localObject == null)
          {
            AppMethodBeat.o(197893);
            return true;
          }
          final f localf = ((BaseWebViewController)localObject).getJsapi();
          localObject = ((BaseWebViewController)localObject).lvw;
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(197893);
            return true;
            com.tencent.e.h.LTJ.aP(new Runnable()
            {
              public final void run()
              {
                boolean bool = true;
                AppMethodBeat.i(197888);
                try
                {
                  if ((!paramAnonymousBundle.containsKey("jsapi_preverify_fun_list")) || (this.zDb == null)) {
                    if (this.zDb != null) {
                      ad.e("AdLandingFloatWebView", "has JSAPI_CONTROL_BYTES wvPerm %b", new Object[] { Boolean.valueOf(bool) });
                    }
                  }
                  for (;;)
                  {
                    localf.eOB();
                    AppMethodBeat.o(197888);
                    return;
                    bool = false;
                    break;
                    this.zDb.aE(paramAnonymousBundle);
                  }
                  return;
                }
                catch (Throwable localThrowable)
                {
                  ad.e("AdLandingFloatWebView", "In onCallback method, it happens something unwanted!");
                  AppMethodBeat.o(197888);
                }
              }
            });
          }
          return true;
        }
        catch (Throwable paramAnonymousBundle)
        {
          ad.e("AdLandingFloatWebView", "In callback method, it happens something unwanted!");
          AppMethodBeat.o(197893);
        }
      }
      
      public final String getCurrentUrl()
      {
        AppMethodBeat.i(197889);
        try
        {
          Object localObject = e.this.zCP;
          if (localObject != null)
          {
            localObject = ((BaseWebViewController)localObject).getCurrentUrl();
            AppMethodBeat.o(197889);
            return localObject;
          }
        }
        catch (Throwable localThrowable)
        {
          ad.e("AdLandingFloatWebView", "callback: getCurrentUrl failed");
          AppMethodBeat.o(197889);
        }
        return "";
      }
      
      public final Bundle k(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(197892);
        Bundle localBundle = new Bundle();
        Object localObject = e.this.context;
        switch (paramAnonymousInt)
        {
        }
        do
        {
          AppMethodBeat.o(197892);
          return localBundle;
        } while ((localObject == null) || (paramAnonymousBundle == null));
        for (;;)
        {
          try
          {
            paramAnonymousBundle.setClassLoader(((Context)localObject).getClassLoader());
            localObject = paramAnonymousBundle.getBundle("open_ui_with_webview_ui_extras");
            String str1 = y.m(paramAnonymousBundle, "open_ui_with_webview_ui_plugin_name");
            String str2 = y.m(paramAnonymousBundle, "open_ui_with_webview_ui_plugin_entry");
            Context localContext = e.this.context;
            Intent localIntent = new Intent();
            if (localObject == null) {
              break label140;
            }
            paramAnonymousBundle = (Bundle)localObject;
            com.tencent.mm.bs.d.b(localContext, str1, str2, localIntent.putExtras(paramAnonymousBundle));
          }
          catch (Throwable paramAnonymousBundle)
          {
            ad.e("AdLandingFloatWebView", "In invokeAsResult method, it happens something unwanted!");
          }
          break;
          label140:
          paramAnonymousBundle = new Bundle();
        }
      }
    };
    try
    {
      this.zCQ = parame;
      if (this.hJu == null)
      {
        this.hJu = new c()
        {
          private boolean a(ud paramAnonymousud)
          {
            AppMethodBeat.i(197896);
            for (;;)
            {
              try
              {
                localObject1 = e.this;
                if (paramAnonymousud != null)
                {
                  i = paramAnonymousud.dIC.EN;
                  if ((i != 0) && (i == 1))
                  {
                    i = paramAnonymousud.dIC.requestCode;
                    j = paramAnonymousud.dIC.bZU;
                    localIntent = paramAnonymousud.dIC.dxy;
                    if (i == 3)
                    {
                      locala = ((e)localObject1).zCR;
                      if (locala != null)
                      {
                        localObject1 = (Activity)((e)localObject1).context;
                        if (i == 3)
                        {
                          if ((locala.zDc != null) || (locala.zDd != null)) {
                            continue;
                          }
                          ad.w("AdLandingFloatWebView", "uploadFileCallback is null.");
                        }
                      }
                    }
                  }
                }
              }
              catch (Throwable paramAnonymousud)
              {
                Object localObject1;
                Intent localIntent;
                e.a locala;
                ad.w("AdLandingFloatWebView", "resizing layout has wrong!");
                continue;
                paramAnonymousud = null;
                continue;
                paramAnonymousud = localIntent.getData();
                continue;
                paramAnonymousud = bt.k((Context)localObject1, paramAnonymousud);
                ad.i("AdLandingFloatWebView", "get file path:[%s]", new Object[] { paramAnonymousud });
                if (bt.isNullOrNil(paramAnonymousud)) {
                  continue;
                }
                Object localObject2 = com.tencent.mm.pluginsdk.ui.tools.x.aNJ(paramAnonymousud);
                ad.d("AdLandingFloatWebView", "get file mime type [%s]", new Object[] { localObject2 });
                if (!bt.isNullOrNil(locala.zDe)) {
                  continue;
                }
                int i = 1;
                if (i == 0) {
                  continue;
                }
                if (localIntent.getData() != null) {
                  continue;
                }
                paramAnonymousud = n.a((Context)localObject1, new com.tencent.mm.vfs.e(paramAnonymousud));
                continue;
                String[] arrayOfString1 = locala.zDe.split(",");
                int j = arrayOfString1.length;
                i = 0;
                if (i >= j) {
                  continue;
                }
                Object localObject3 = arrayOfString1[i].replace(" ", "");
                if (!bt.isNullOrNil((String)localObject3)) {
                  continue;
                }
                boolean bool = true;
                continue;
                if (bt.isNullOrNil((String)localObject2)) {
                  continue;
                }
                if ((((String)localObject3).contains("/")) && (((String)localObject2).contains("/"))) {
                  continue;
                }
                bool = ((String)localObject3).equals(localObject2);
                continue;
                localObject3 = ((String)localObject3).split("/");
                String[] arrayOfString2 = ((String)localObject2).split("/");
                if (!bt.nullAsNil(localObject3[0]).equals(arrayOfString2[0])) {
                  continue;
                }
                if (bt.nullAsNil(localObject3[1]).equals("*")) {
                  continue;
                }
                if (!bt.nullAsNil(localObject3[1]).equals(arrayOfString2[1])) {
                  continue;
                }
                continue;
                paramAnonymousud = localIntent.getData();
                continue;
                paramAnonymousud = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.webview.j.d.aHy(locala.zDf));
                if (!paramAnonymousud.exists()) {
                  continue;
                }
                paramAnonymousud = n.a((Context)localObject1, paramAnonymousud);
                continue;
                if (locala.zDd == null) {
                  continue;
                }
                if (paramAnonymousud != null) {
                  continue;
                }
                locala.zDd.onReceiveValue(null);
                continue;
                locala.zDd.onReceiveValue(new Uri[] { paramAnonymousud });
                continue;
                paramAnonymousud = null;
                continue;
                continue;
                if (!bool) {
                  continue;
                }
                i = 1;
                continue;
                bool = true;
                continue;
                bool = false;
                continue;
                bool = false;
                continue;
                i += 1;
                continue;
                i = 0;
                continue;
                paramAnonymousud = null;
                continue;
              }
              AppMethodBeat.o(197896);
              return true;
              if (j != -1) {
                continue;
              }
              if (localIntent == null) {
                continue;
              }
              paramAnonymousud = null;
              if (localIntent.getData() != null) {
                continue;
              }
              localObject2 = localIntent.getExtras();
              if (localObject2 == null) {
                continue;
              }
              if (((Bundle)localObject2).getParcelable("android.intent.extra.STREAM") == null) {
                continue;
              }
              paramAnonymousud = (Uri)((Bundle)localObject2).getParcelable("android.intent.extra.STREAM");
              continue;
              if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qtT, 1) != 1) || (paramAnonymousud == null)) {
                continue;
              }
              ad.i("AdLandingFloatWebView", "result = ".concat(String.valueOf(paramAnonymousud)));
              if (locala.zDc == null) {
                continue;
              }
              locala.zDc.onReceiveValue(paramAnonymousud);
            }
          }
        };
        this.hJu.alive();
      }
      AppMethodBeat.o(197906);
      return;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(197906);
    }
  }
  
  static boolean aE(Activity paramActivity)
  {
    AppMethodBeat.i(197912);
    if ((paramActivity != null) && (!paramActivity.isFinishing()) && (!paramActivity.isDestroyed()))
    {
      AppMethodBeat.o(197912);
      return true;
    }
    AppMethodBeat.o(197912);
    return false;
  }
  
  private String azL(String paramString)
  {
    AppMethodBeat.i(197914);
    try
    {
      ae localae = dWZ();
      str2 = paramString;
      if (localae != null)
      {
        str2 = paramString;
        if (!TextUtils.isEmpty(paramString))
        {
          str2 = localae.zAP;
          String str1 = str2;
          if (TextUtils.isEmpty(str2)) {
            str1 = localae.dFy;
          }
          str2 = paramString;
          if (!TextUtils.isEmpty(str1)) {
            str2 = q.jh(paramString, str1);
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ad.e("AdLandingFloatWebView", "fill url param occur error!");
        String str2 = paramString;
      }
    }
    AppMethodBeat.o(197914);
    return str2;
  }
  
  final int Qo(int paramInt)
  {
    AppMethodBeat.i(197913);
    try
    {
      int j = am.gk(this.context)[1];
      i = paramInt;
      if (paramInt == j)
      {
        i = paramInt;
        if (al.aG(this.context))
        {
          i = al.aF(this.context);
          i = j - i;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        int i = paramInt;
      }
    }
    AppMethodBeat.o(197913);
    return i;
  }
  
  public final void aA(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(197911);
    if (paramInt == 0) {}
    try
    {
      android.support.v4.content.d locald = android.support.v4.content.d.U(this.context);
      Intent localIntent = new Intent("com.tencent.mm.adlanding.video.action.PAUSE_OR_RESUME");
      if (paramBoolean) {}
      for (paramInt = 1;; paramInt = 2)
      {
        localIntent.putExtra("TRY_PAUSE_OR_RESUME", paramInt);
        localIntent.putExtra("identity", this.context.hashCode());
        locald.b(localIntent);
        AppMethodBeat.o(197911);
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.w("AdLandingFloatWebView", "onScrollChanged method has something wrong");
      AppMethodBeat.o(197911);
    }
  }
  
  public final void dRk()
  {
    AppMethodBeat.i(197908);
    super.dRk();
    if (!this.zCS)
    {
      this.zCS = true;
      try
      {
        Object localObject = this.contentView;
        if (localObject != null)
        {
          localObject = ((View)localObject).getViewTreeObserver();
          if (((ViewTreeObserver)localObject).isAlive()) {
            ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(new b());
          }
        }
        AppMethodBeat.o(197908);
        return;
      }
      catch (Throwable localThrowable) {}
    }
    AppMethodBeat.o(197908);
  }
  
  protected final void dRl()
  {
    AppMethodBeat.i(197907);
    try
    {
      if (this.zCP == null)
      {
        String str = azL(this.zCQ.zyy);
        Intent localIntent = new Intent();
        localIntent.putExtra("rawUrl", str);
        localIntent.putExtra("useJs", true);
        localIntent.putExtra("type", -255);
        localIntent.putExtra("geta8key_scene", 2);
        this.zCP = ((com.tencent.mm.api.x)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.x.class)).a(this.hJc);
        this.zCP.a(new com.tencent.mm.plugin.webview.core.i()
        {
          public final void dWE()
          {
            AppMethodBeat.i(197894);
            try
            {
              e.this.zCP.lvv.a(e.this.zCT, e.this.zCP.eNj());
              AppMethodBeat.o(197894);
              return;
            }
            catch (Throwable localThrowable)
            {
              ad.e("AdLandingFloatWebView", "bind webview callback failed");
              AppMethodBeat.o(197894);
            }
          }
        });
        this.hJc.setWebChromeClient(new MMWebView.b(new c((Activity)this.context, this.zCP.lvw, this.zCR)));
        this.zCP.init();
        this.zCP.at(localIntent);
        ad.d("AdLandingFloatWebView", "url is ".concat(String.valueOf(str)));
      }
      AppMethodBeat.o(197907);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("AdLandingFloatWebView", "bind webview callback failed");
      AppMethodBeat.o(197907);
    }
  }
  
  public final void dRo()
  {
    AppMethodBeat.i(197910);
    super.dRo();
    try
    {
      ad.i("AdLandingFloatWebView", "the view is going to destroy");
      if (this.hJu != null) {
        this.hJu.dead();
      }
      if (this.zCP != null) {
        this.zCP.onDestroy();
      }
      if (this.hJc != null) {
        this.hJc.destroy();
      }
      AppMethodBeat.o(197910);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.w("AdLandingFloatWebView", "the destroy method has something wrong");
      AppMethodBeat.o(197910);
    }
  }
  
  protected final View dWC()
  {
    AppMethodBeat.i(197909);
    for (;;)
    {
      try
      {
        this.zCN = new ScrollableLayout(this.context);
        localObject2 = this.zCQ.zyy;
        localObject1 = null;
        if (j.aJD((String)localObject2)) {
          localObject1 = MMWebView.a.kG(this.context);
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = MMWebView.a.kH(this.context);
        }
        this.hJc = ((MMWebView)localObject2);
        localObject1 = new LinearLayout.LayoutParams(-1, -1);
        this.zCO = new Space(this.context);
        this.zCO.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.zCN.addView(this.zCO);
        this.zCR = new a();
        this.zCN.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.zCN.setDescendantScrollStatusHunter(this);
        this.zCN.setOnScrollStatusListener(this);
        localObject1 = new LinearLayout.LayoutParams(-1, -1);
        localObject2 = this.zCN;
        localMMWebView = this.hJc;
      }
      catch (Throwable localThrowable2)
      {
        Object localObject2;
        Object localObject1;
        MMWebView localMMWebView;
        ad.w("AdLandingFloatWebView", "the customLayout method has something wrong");
        continue;
      }
      try
      {
        ((ScrollableLayout)localObject2).addView(localMMWebView, (ViewGroup.LayoutParams)localObject1);
        ((ScrollableLayout)localObject2).ADT = localMMWebView;
        localObject1 = this.zCN;
        AppMethodBeat.o(197909);
        return localObject1;
      }
      catch (Throwable localThrowable1)
      {
        ad.w("ScrollLinearLayout", "the addView has something wrong!");
      }
    }
  }
  
  static final class a
  {
    ValueCallback<Uri> zDc;
    ValueCallback<Uri[]> zDd;
    String zDe;
    String zDf;
  }
  
  final class b
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    b() {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(197898);
      try
      {
        ad.i("AdLandingFloatWebView", "viewTreeObserver OnGlobalLayoutListener is called");
        Object localObject1 = e.this.contentView;
        if ((localObject1 != null) && (((View)localObject1).getViewTreeObserver().isAlive()))
        {
          ((View)localObject1).getViewTreeObserver().removeOnGlobalLayoutListener(this);
          Object localObject2 = ((View)localObject1).getRootView();
          if (localObject2 == null) {}
          for (;;)
          {
            localObject1 = ((View)localObject1).findViewById(2131306298);
            if ((!(localObject1 instanceof ViewGroup)) || (((ViewGroup)localObject1).getChildCount() <= 0)) {
              break label334;
            }
            localObject1 = ((ViewGroup)localObject1).getChildAt(0);
            if (localObject1 != null) {
              break;
            }
            AppMethodBeat.o(197898);
            return;
            localObject1 = localObject2;
          }
          localObject1 = ((View)localObject1).findViewById(2131298763);
          if (((localObject1 instanceof ViewGroup)) && (((ViewGroup)localObject1).getChildCount() > 0))
          {
            localObject2 = ((ViewGroup)localObject1).getChildAt(0);
            if (localObject2 != null)
            {
              localObject1 = e.this;
              ((View)localObject2).getWidth();
              int i = ((View)localObject2).getHeight();
              if ((((e)localObject1).zCO != null) && (((e)localObject1).zCN != null) && (((e)localObject1).hJc != null))
              {
                ad.d("AdLandingFloatWebView", "on event center information: the  height is ".concat(String.valueOf(i)));
                ad.d("AdLandingFloatWebView", "on event center information: the  height of mPlaceHolderView is " + ((e)localObject1).zCO.getHeight());
                ad.d("AdLandingFloatWebView", "on event center information: the  height of mScrollableLayout is " + ((e)localObject1).zCN.getHeight());
                ad.d("AdLandingFloatWebView", "on event center information: the  height of mWebView is " + ((e)localObject1).hJc.getHeight());
                localObject2 = ((e)localObject1).zCO.getLayoutParams();
                ((ViewGroup.LayoutParams)localObject2).height = i;
                ((e)localObject1).zCO.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                localObject2 = ((e)localObject1).hJc.getLayoutParams();
                ((ViewGroup.LayoutParams)localObject2).height = ((e)localObject1).Qo(((e)localObject1).zCN.getHeight());
                ((e)localObject1).hJc.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                ((e)localObject1).zCN.setMaxYScrollOffset(i);
                ((e)localObject1).zCN.requestLayout();
              }
            }
          }
        }
        label334:
        AppMethodBeat.o(197898);
        return;
      }
      catch (Throwable localThrowable)
      {
        AppMethodBeat.o(197898);
      }
    }
  }
  
  static final class c
    extends com.tencent.xweb.x
  {
    private Reference<Activity> yXr;
    private final e.a zCR;
    private com.tencent.mm.plugin.webview.e.g zDg;
    
    protected c(Activity paramActivity, com.tencent.mm.plugin.webview.e.g paramg, e.a parama)
    {
      AppMethodBeat.i(197901);
      this.yXr = new WeakReference(paramActivity);
      this.zDg = paramg;
      this.zCR = parama;
      AppMethodBeat.o(197901);
    }
    
    public final void a(WebView paramWebView, int paramInt)
    {
      AppMethodBeat.i(197902);
      ad.d("AdLandingFloatWebView", "onProgressChanged %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(197902);
    }
    
    public final boolean a(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, x.a parama)
    {
      Object localObject2 = null;
      Object localObject1 = null;
      AppMethodBeat.i(197904);
      Activity localActivity;
      String str1;
      Object localObject3;
      for (;;)
      {
        try
        {
          localActivity = (Activity)this.yXr.get();
          if (((e.aE(localActivity)) && (parama.getMode() == 0)) || (parama.getMode() == 1))
          {
            if ((parama.getAcceptTypes() == null) || (parama.getAcceptTypes().length <= 0))
            {
              ad.i("AdLandingFloatWebView", "onShowFileChooser, mode = MODE_OPEN, but params.getAcceptTypes is null");
              AppMethodBeat.o(197904);
              return true;
            }
            str1 = parama.getAcceptTypes()[0];
            localObject3 = "*";
            paramWebView = (WebView)localObject3;
            if (parama.isCaptureEnabled())
            {
              if ("image/*".equalsIgnoreCase(str1)) {
                paramWebView = "camera";
              }
            }
            else
            {
              localObject3 = this.zCR;
              parama = this.zDg;
              if (e.aE(localActivity)) {
                continue;
              }
              ad.i("AdLandingFloatWebView", "activity is finished.");
              AppMethodBeat.o(197904);
              return true;
            }
            paramWebView = (WebView)localObject3;
            if (!"video/*".equalsIgnoreCase(str1)) {
              continue;
            }
            paramWebView = "camcorder";
            continue;
            if (parama != null) {
              break label191;
            }
            ad.e("AdLandingFloatWebView", "openFileChooser fail, wvPerm is null");
            continue;
          }
          if (parama.eRg().mz(56)) {
            break;
          }
        }
        catch (Throwable paramWebView)
        {
          ad.e("AdLandingFloatWebView", "onShowFileChooser has something wrong");
          AppMethodBeat.o(197904);
          return false;
        }
        label191:
        ad.e("AdLandingFloatWebView", "open file chooser failed, permission fail");
      }
      ((e.a)localObject3).zDc = null;
      ((e.a)localObject3).zDd = paramValueCallback;
      ((e.a)localObject3).zDe = str1;
      ((e.a)localObject3).zDf = String.valueOf(System.currentTimeMillis());
      label266:
      String str2;
      label308:
      int i;
      if (!"user".equalsIgnoreCase(paramWebView))
      {
        parama = paramWebView;
        if (!"environment".equalsIgnoreCase(paramWebView))
        {
          str2 = ((e.a)localObject3).zDf;
          localObject3 = new Intent("android.intent.action.GET_CONTENT");
          ((Intent)localObject3).addCategory("android.intent.category.OPENABLE");
          if (bt.isNullOrNil(str1))
          {
            ((Intent)localObject3).setType("*/*");
            if (bt.isNullOrNil(parama)) {
              break label620;
            }
            if (!"camera".equalsIgnoreCase(parama)) {
              break label438;
            }
            paramWebView = new Intent[1];
            paramWebView[0] = com.tencent.mm.plugin.webview.j.d.aHz(str2);
            i = 0;
          }
        }
      }
      for (;;)
      {
        for (;;)
        {
          label340:
          if ((i != 0) || (paramWebView == null) || (paramWebView.length == 0))
          {
            paramValueCallback = new Intent("android.intent.action.CHOOSER");
            paramValueCallback.putExtra("android.intent.extra.INITIAL_INTENTS", paramWebView);
            paramValueCallback.putExtra("android.intent.extra.TITLE", aj.getContext().getString(2131766455));
            paramValueCallback.putExtra("android.intent.extra.INTENT", (Parcelable)localObject3);
          }
          for (paramWebView = paramValueCallback;; paramWebView = paramWebView[0])
          {
            if (com.tencent.mm.pluginsdk.permission.b.n(localActivity, "android.permission.CAMERA")) {
              break label666;
            }
            com.tencent.mm.pluginsdk.permission.b.b(localActivity, "android.permission.CAMERA", 119);
            ad.e("AdLandingFloatWebView", "openFileChooser no Permission");
            break;
            ((Intent)localObject3).setType(str1);
            break label308;
            label438:
            if ("camcorder".equalsIgnoreCase(parama))
            {
              paramWebView = new Intent[1];
              paramWebView[0] = com.tencent.mm.plugin.webview.j.d.eQv();
              i = 0;
              break label340;
            }
            if ("microphone".equalsIgnoreCase(parama))
            {
              paramWebView = new Intent[1];
              paramWebView[0] = com.tencent.mm.plugin.webview.j.d.eQw();
              i = 0;
              break label340;
            }
            if ((!"*".equalsIgnoreCase(parama)) && (!"true".equalsIgnoreCase(parama)))
            {
              paramValueCallback = localObject2;
              if (!"false".equalsIgnoreCase(parama)) {
                break label696;
              }
            }
            if (str1.equalsIgnoreCase("image/*"))
            {
              paramWebView = new Intent[1];
              paramWebView[0] = com.tencent.mm.plugin.webview.j.d.aHz(str2);
            }
            for (;;)
            {
              if ("false".equalsIgnoreCase(parama)) {
                break label710;
              }
              paramValueCallback = paramWebView;
              if (!"*".equalsIgnoreCase(parama)) {
                break;
              }
              break label710;
              if (str1.equalsIgnoreCase("audio/*"))
              {
                paramWebView = new Intent[1];
                paramWebView[0] = com.tencent.mm.plugin.webview.j.d.eQw();
              }
              else
              {
                paramWebView = localObject1;
                if (str1.equalsIgnoreCase("video/*"))
                {
                  paramWebView = new Intent[1];
                  paramWebView[0] = com.tencent.mm.plugin.webview.j.d.eQv();
                }
              }
            }
            label620:
            paramValueCallback = localObject2;
            if (!com.tencent.mm.compatible.util.d.lz(16)) {
              break label696;
            }
            ad.i("MicroMsg.WebJSSDKUtil", "android API version is below 16.");
            paramWebView = new Intent[1];
            paramWebView[0] = com.tencent.mm.plugin.webview.j.d.aHz(str2);
            i = 0;
            break label340;
          }
          try
          {
            label666:
            localActivity.startActivityForResult(paramWebView, 3);
          }
          catch (Exception paramWebView)
          {
            ad.e("AdLandingFloatWebView", "openFileChooser e = %s", new Object[] { paramWebView });
          }
        }
        break;
        label696:
        i = 0;
        paramWebView = paramValueCallback;
        continue;
        parama = "true";
        break label266;
        label710:
        i = 1;
      }
    }
    
    public final boolean a(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
    {
      return false;
    }
    
    public final boolean b(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
    {
      AppMethodBeat.i(197905);
      ad.d("AdLandingFloatWebView", "onJsConfirm");
      boolean bool = super.b(paramWebView, paramString1, paramString2, paramJsResult);
      AppMethodBeat.o(197905);
      return bool;
    }
    
    public final void onGeolocationPermissionsShowPrompt(final String paramString, final GeolocationPermissions.Callback paramCallback)
    {
      AppMethodBeat.i(197903);
      ad.i("AdLandingFloatWebView", "onGeolocationPermissionsShowPrompt, origin = %s", new Object[] { paramString });
      try
      {
        final Activity localActivity = (Activity)this.yXr.get();
        if ((!e.aE(localActivity)) || (paramCallback == null))
        {
          ad.w("AdLandingFloatWebView", "the activity is finished.");
          AppMethodBeat.o(197903);
          return;
        }
        if (com.tencent.mm.pluginsdk.permission.b.n(localActivity, "android.permission.ACCESS_COARSE_LOCATION"))
        {
          com.tencent.mm.ui.base.h.a(localActivity, false, localActivity.getString(2131766453, new Object[] { paramString }), localActivity.getString(2131766454), localActivity.getString(2131755835), localActivity.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(197899);
              ad.i("AdLandingFloatWebView", "onGeolocationPermissionsShowPrompt ok");
              try
              {
                paramCallback.invoke(paramString, true, true);
                am.aF(localActivity);
                AppMethodBeat.o(197899);
                return;
              }
              catch (Throwable paramAnonymousDialogInterface)
              {
                ad.e("AdLandingFloatWebView", "GeolocationPermissions.Callback has something wrong!");
                AppMethodBeat.o(197899);
              }
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(197900);
              ad.i("AdLandingFloatWebView", "onGeolocationPermissionsShowPrompt cancel");
              try
              {
                paramCallback.invoke(paramString, false, false);
                am.aF(localActivity);
                AppMethodBeat.o(197900);
                return;
              }
              catch (Throwable paramAnonymousDialogInterface)
              {
                ad.e("AdLandingFloatWebView", "GeolocationPermissions.Callback has something wrong!");
                AppMethodBeat.o(197900);
              }
            }
          });
          AppMethodBeat.o(197903);
          return;
        }
      }
      catch (Throwable paramString)
      {
        ad.w("AdLandingFloatWebView", "the application has no geo permission.");
        AppMethodBeat.o(197903);
        return;
      }
      ad.w("AdLandingFloatWebView", "the application has no geo permission.");
      AppMethodBeat.o(197903);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e
 * JD-Core Version:    0.7.0.1
 */