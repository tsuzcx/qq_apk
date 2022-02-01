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
import com.tencent.mm.g.a.uh;
import com.tencent.mm.g.a.uh.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.ad.b.a.a;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af;
import com.tencent.mm.plugin.sns.ui.widget.ad.ScrollableLayout;
import com.tencent.mm.plugin.sns.ui.widget.ad.ScrollableLayout.a;
import com.tencent.mm.plugin.sns.ui.widget.ad.ScrollableLayout.b;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.l;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.j.j;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.mm.ui.widget.MMWebView.b;
import com.tencent.mm.vfs.k;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.WebView;
import com.tencent.xweb.x.a;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public final class e
  extends m
  implements ScrollableLayout.a, ScrollableLayout.b
{
  MMWebView hLV;
  private c<uh> hMn;
  ScrollableLayout zTP;
  View zTQ;
  BaseWebViewController zTR;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e zTS;
  a zTT;
  private boolean zTU;
  com.tencent.mm.plugin.webview.stub.b zTV;
  
  public e(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e parame, ViewGroup paramViewGroup)
  {
    super(paramContext, parame, paramViewGroup);
    AppMethodBeat.i(219403);
    this.zTU = false;
    this.zTV = new com.tencent.mm.plugin.webview.stub.b()
    {
      public final boolean a(final String paramAnonymousString1, final String paramAnonymousString2, final Bundle paramAnonymousBundle, final boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(219388);
        Object localObject = e.this.zTR;
        if (localObject == null)
        {
          AppMethodBeat.o(219388);
          return false;
        }
        try
        {
          localObject = ((BaseWebViewController)localObject).getJsapi();
          com.tencent.e.h.MqF.aM(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(219384);
              try
              {
                if (this.zTX != null) {
                  this.zTX.a(paramAnonymousString1, paramAnonymousString2, l.aB(paramAnonymousBundle), paramAnonymousBoolean);
                }
                AppMethodBeat.o(219384);
                return;
              }
              catch (Throwable localThrowable)
              {
                ae.e("AdLandingFloatWebView", "In jsapi onHandleEnd method, it happens something unwanted!");
                AppMethodBeat.o(219384);
              }
            }
          });
          AppMethodBeat.o(219388);
          return false;
        }
        catch (Throwable paramAnonymousString1)
        {
          for (;;)
          {
            ae.e("AdLandingFloatWebView", "In onHandleEnd method, it happens something unwanted!");
          }
        }
      }
      
      public final String eaf()
      {
        AppMethodBeat.i(219387);
        try
        {
          Object localObject = e.this.zTR;
          if (localObject != null)
          {
            localObject = ((BaseWebViewController)localObject).DXY;
            AppMethodBeat.o(219387);
            return localObject;
          }
        }
        catch (Throwable localThrowable)
        {
          ae.e("AdLandingFloatWebView", "callback: getCommitUrl failed");
          AppMethodBeat.o(219387);
        }
        return "";
      }
      
      public final boolean g(int paramAnonymousInt, final Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(219390);
        try
        {
          Object localObject = e.this.zTR;
          if (localObject == null)
          {
            AppMethodBeat.o(219390);
            return true;
          }
          final f localf = ((BaseWebViewController)localObject).getJsapi();
          localObject = ((BaseWebViewController)localObject).lzU;
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(219390);
            return true;
            com.tencent.e.h.MqF.aM(new Runnable()
            {
              public final void run()
              {
                boolean bool = true;
                AppMethodBeat.i(219385);
                try
                {
                  if ((!paramAnonymousBundle.containsKey("jsapi_preverify_fun_list")) || (this.zUd == null)) {
                    if (this.zUd != null) {
                      ae.e("AdLandingFloatWebView", "has JSAPI_CONTROL_BYTES wvPerm %b", new Object[] { Boolean.valueOf(bool) });
                    }
                  }
                  for (;;)
                  {
                    localf.eSm();
                    AppMethodBeat.o(219385);
                    return;
                    bool = false;
                    break;
                    this.zUd.aF(paramAnonymousBundle);
                  }
                  return;
                }
                catch (Throwable localThrowable)
                {
                  ae.e("AdLandingFloatWebView", "In onCallback method, it happens something unwanted!");
                  AppMethodBeat.o(219385);
                }
              }
            });
          }
          return true;
        }
        catch (Throwable paramAnonymousBundle)
        {
          ae.e("AdLandingFloatWebView", "In callback method, it happens something unwanted!");
          AppMethodBeat.o(219390);
        }
      }
      
      public final String getCurrentUrl()
      {
        AppMethodBeat.i(219386);
        try
        {
          Object localObject = e.this.zTR;
          if (localObject != null)
          {
            localObject = ((BaseWebViewController)localObject).getCurrentUrl();
            AppMethodBeat.o(219386);
            return localObject;
          }
        }
        catch (Throwable localThrowable)
        {
          ae.e("AdLandingFloatWebView", "callback: getCurrentUrl failed");
          AppMethodBeat.o(219386);
        }
        return "";
      }
      
      public final Bundle k(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(219389);
        Bundle localBundle = new Bundle();
        Object localObject = e.this.context;
        switch (paramAnonymousInt)
        {
        }
        do
        {
          AppMethodBeat.o(219389);
          return localBundle;
        } while ((localObject == null) || (paramAnonymousBundle == null));
        for (;;)
        {
          try
          {
            paramAnonymousBundle.setClassLoader(((Context)localObject).getClassLoader());
            localObject = paramAnonymousBundle.getBundle("open_ui_with_webview_ui_extras");
            String str1 = z.m(paramAnonymousBundle, "open_ui_with_webview_ui_plugin_name");
            String str2 = z.m(paramAnonymousBundle, "open_ui_with_webview_ui_plugin_entry");
            Context localContext = e.this.context;
            Intent localIntent = new Intent();
            if (localObject == null) {
              break label140;
            }
            paramAnonymousBundle = (Bundle)localObject;
            com.tencent.mm.br.d.b(localContext, str1, str2, localIntent.putExtras(paramAnonymousBundle));
          }
          catch (Throwable paramAnonymousBundle)
          {
            ae.e("AdLandingFloatWebView", "In invokeAsResult method, it happens something unwanted!");
          }
          break;
          label140:
          paramAnonymousBundle = new Bundle();
        }
      }
    };
    try
    {
      this.zTS = parame;
      if (this.hMn == null)
      {
        this.hMn = new c()
        {
          private boolean a(uh paramAnonymousuh)
          {
            AppMethodBeat.i(219393);
            for (;;)
            {
              try
              {
                localObject1 = e.this;
                if (paramAnonymousuh != null)
                {
                  i = paramAnonymousuh.dJQ.EN;
                  if ((i != 0) && (i == 1))
                  {
                    i = paramAnonymousuh.dJQ.requestCode;
                    j = paramAnonymousuh.dJQ.bZU;
                    localIntent = paramAnonymousuh.dJQ.dyD;
                    if (i == 2003)
                    {
                      locala = ((e)localObject1).zTT;
                      if (locala != null)
                      {
                        localObject1 = (Activity)((e)localObject1).context;
                        if (i == 2003)
                        {
                          if ((locala.zUe != null) || (locala.zUf != null)) {
                            continue;
                          }
                          ae.w("AdLandingFloatWebView", "uploadFileCallback is null.");
                        }
                      }
                    }
                  }
                }
              }
              catch (Throwable paramAnonymousuh)
              {
                Object localObject1;
                Intent localIntent;
                e.a locala;
                ae.w("AdLandingFloatWebView", "resizing layout has wrong!");
                continue;
                paramAnonymousuh = null;
                continue;
                paramAnonymousuh = localIntent.getData();
                continue;
                paramAnonymousuh = bu.k((Context)localObject1, paramAnonymousuh);
                ae.i("AdLandingFloatWebView", "get file path:[%s]", new Object[] { paramAnonymousuh });
                if (bu.isNullOrNil(paramAnonymousuh)) {
                  continue;
                }
                Object localObject2 = com.tencent.mm.pluginsdk.ui.tools.x.aPg(paramAnonymousuh);
                ae.d("AdLandingFloatWebView", "get file mime type [%s]", new Object[] { localObject2 });
                if (!bu.isNullOrNil(locala.zUg)) {
                  continue;
                }
                int i = 1;
                if (i == 0) {
                  continue;
                }
                if (localIntent.getData() != null) {
                  continue;
                }
                paramAnonymousuh = o.a((Context)localObject1, new k(paramAnonymousuh));
                continue;
                String[] arrayOfString1 = locala.zUg.split(",");
                int j = arrayOfString1.length;
                i = 0;
                if (i >= j) {
                  continue;
                }
                Object localObject3 = arrayOfString1[i].replace(" ", "");
                if (!bu.isNullOrNil((String)localObject3)) {
                  continue;
                }
                boolean bool = true;
                continue;
                if (bu.isNullOrNil((String)localObject2)) {
                  continue;
                }
                if ((((String)localObject3).contains("/")) && (((String)localObject2).contains("/"))) {
                  continue;
                }
                bool = ((String)localObject3).equals(localObject2);
                continue;
                localObject3 = ((String)localObject3).split("/");
                String[] arrayOfString2 = ((String)localObject2).split("/");
                if (!bu.nullAsNil(localObject3[0]).equals(arrayOfString2[0])) {
                  continue;
                }
                if (bu.nullAsNil(localObject3[1]).equals("*")) {
                  continue;
                }
                if (!bu.nullAsNil(localObject3[1]).equals(arrayOfString2[1])) {
                  continue;
                }
                continue;
                paramAnonymousuh = localIntent.getData();
                continue;
                paramAnonymousuh = new k(com.tencent.mm.plugin.webview.j.d.aIR(locala.zUh));
                if (!paramAnonymousuh.exists()) {
                  continue;
                }
                paramAnonymousuh = o.a((Context)localObject1, paramAnonymousuh);
                continue;
                if (locala.zUf == null) {
                  continue;
                }
                if (paramAnonymousuh != null) {
                  continue;
                }
                locala.zUf.onReceiveValue(null);
                continue;
                locala.zUf.onReceiveValue(new Uri[] { paramAnonymousuh });
                continue;
                paramAnonymousuh = null;
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
                paramAnonymousuh = null;
                continue;
              }
              AppMethodBeat.o(219393);
              return true;
              if (j != -1) {
                continue;
              }
              if (localIntent == null) {
                continue;
              }
              paramAnonymousuh = null;
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
              paramAnonymousuh = (Uri)((Bundle)localObject2).getParcelable("android.intent.extra.STREAM");
              continue;
              if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qAH, 1) != 1) || (paramAnonymousuh == null)) {
                continue;
              }
              ae.i("AdLandingFloatWebView", "result = ".concat(String.valueOf(paramAnonymousuh)));
              if (locala.zUe == null) {
                continue;
              }
              locala.zUe.onReceiveValue(paramAnonymousuh);
            }
          }
        };
        this.hMn.alive();
      }
      AppMethodBeat.o(219403);
      return;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(219403);
    }
  }
  
  private String aBc(String paramString)
  {
    AppMethodBeat.i(219411);
    localObject1 = paramString;
    try
    {
      af localaf = eaD();
      localObject2 = paramString;
      if (localaf != null)
      {
        localObject2 = paramString;
        localObject1 = paramString;
        if (!TextUtils.isEmpty(paramString))
        {
          localObject1 = paramString;
          localObject2 = localaf.zRP;
          Object localObject3 = localObject2;
          localObject1 = paramString;
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = paramString;
            localObject3 = localaf.dGD;
          }
          localObject2 = paramString;
          localObject1 = paramString;
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            localObject1 = paramString;
            localObject2 = r.jo(paramString, (String)localObject3);
          }
          localObject1 = localObject2;
          localObject2 = a.ayT((String)localObject2);
        }
      }
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        ae.e("AdLandingFloatWebView", "fill url param occur error!");
        Object localObject2 = localObject1;
      }
    }
    AppMethodBeat.o(219411);
    return localObject2;
  }
  
  static boolean aF(Activity paramActivity)
  {
    AppMethodBeat.i(219409);
    if ((paramActivity != null) && (!paramActivity.isFinishing()) && (!paramActivity.isDestroyed()))
    {
      AppMethodBeat.o(219409);
      return true;
    }
    AppMethodBeat.o(219409);
    return false;
  }
  
  final int QV(int paramInt)
  {
    AppMethodBeat.i(219410);
    try
    {
      int j = an.gp(this.context)[1];
      i = paramInt;
      if (paramInt == j)
      {
        i = paramInt;
        if (al.aH(this.context))
        {
          i = al.aG(this.context);
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
    AppMethodBeat.o(219410);
    return i;
  }
  
  public final void aD(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(219408);
    if (paramInt == 0) {}
    try
    {
      android.support.v4.content.d locald = android.support.v4.content.d.V(this.context);
      Intent localIntent = new Intent("com.tencent.mm.adlanding.video.action.PAUSE_OR_RESUME");
      if (paramBoolean) {}
      for (paramInt = 1;; paramInt = 2)
      {
        localIntent.putExtra("TRY_PAUSE_OR_RESUME", paramInt);
        localIntent.putExtra("identity", this.context.hashCode());
        locald.b(localIntent);
        AppMethodBeat.o(219408);
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.w("AdLandingFloatWebView", "onScrollChanged method has something wrong");
      AppMethodBeat.o(219408);
    }
  }
  
  public final void dUI()
  {
    AppMethodBeat.i(219405);
    super.dUI();
    if (!this.zTU)
    {
      this.zTU = true;
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
        AppMethodBeat.o(219405);
        return;
      }
      catch (Throwable localThrowable) {}
    }
    AppMethodBeat.o(219405);
  }
  
  protected final void dUJ()
  {
    AppMethodBeat.i(219404);
    try
    {
      if (this.zTR == null)
      {
        String str = aBc(this.zTS.zPX);
        Intent localIntent = new Intent();
        localIntent.putExtra("rawUrl", str);
        localIntent.putExtra("useJs", true);
        localIntent.putExtra("type", -255);
        localIntent.putExtra("geta8key_scene", 2);
        this.zTR = ((com.tencent.mm.api.x)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.x.class)).a(this.hLV);
        this.zTR.a(new com.tencent.mm.plugin.webview.core.i()
        {
          public final void eag()
          {
            AppMethodBeat.i(219391);
            try
            {
              e.this.zTR.lzT.a(e.this.zTV, e.this.zTR.eQU());
              AppMethodBeat.o(219391);
              return;
            }
            catch (Throwable localThrowable)
            {
              ae.e("AdLandingFloatWebView", "bind webview callback failed");
              AppMethodBeat.o(219391);
            }
          }
        });
        this.hLV.setWebChromeClient(new MMWebView.b(new c((Activity)this.context, this.zTR.lzU, this.zTT)));
        this.zTR.init();
        this.zTR.au(localIntent);
        ae.d("AdLandingFloatWebView", "url is ".concat(String.valueOf(str)));
      }
      AppMethodBeat.o(219404);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.e("AdLandingFloatWebView", "bind webview callback failed");
      AppMethodBeat.o(219404);
    }
  }
  
  public final void dUM()
  {
    AppMethodBeat.i(219407);
    super.dUM();
    try
    {
      ae.i("AdLandingFloatWebView", "the view is going to destroy");
      if (this.hMn != null) {
        this.hMn.dead();
      }
      if (this.zTR != null) {
        this.zTR.onDestroy();
      }
      if (this.hLV != null) {
        this.hLV.destroy();
      }
      AppMethodBeat.o(219407);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.w("AdLandingFloatWebView", "the destroy method has something wrong");
      AppMethodBeat.o(219407);
    }
  }
  
  protected final View eae()
  {
    AppMethodBeat.i(219406);
    for (;;)
    {
      try
      {
        this.zTP = new ScrollableLayout(this.context);
        localObject2 = this.zTS.zPX;
        localObject1 = null;
        if (j.aKZ((String)localObject2)) {
          localObject1 = MMWebView.a.kN(this.context);
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = MMWebView.a.kO(this.context);
        }
        this.hLV = ((MMWebView)localObject2);
        localObject1 = new LinearLayout.LayoutParams(-1, -1);
        this.zTQ = new Space(this.context);
        this.zTQ.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.zTP.addView(this.zTQ);
        this.zTT = new a();
        this.zTP.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.zTP.setDescendantScrollStatusHunter(this);
        this.zTP.setOnScrollStatusListener(this);
        localObject1 = new LinearLayout.LayoutParams(-1, -1);
        localObject2 = this.zTP;
        localMMWebView = this.hLV;
      }
      catch (Throwable localThrowable2)
      {
        Object localObject2;
        Object localObject1;
        MMWebView localMMWebView;
        ae.w("AdLandingFloatWebView", "the customLayout method has something wrong");
        continue;
      }
      try
      {
        ((ScrollableLayout)localObject2).addView(localMMWebView, (ViewGroup.LayoutParams)localObject1);
        ((ScrollableLayout)localObject2).AVw = localMMWebView;
        localObject1 = this.zTP;
        AppMethodBeat.o(219406);
        return localObject1;
      }
      catch (Throwable localThrowable1)
      {
        ae.w("ScrollLinearLayout", "the addView has something wrong!");
      }
    }
  }
  
  static final class a
  {
    ValueCallback<Uri> zUe;
    ValueCallback<Uri[]> zUf;
    String zUg;
    String zUh;
  }
  
  final class b
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    b() {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(219395);
      try
      {
        ae.i("AdLandingFloatWebView", "viewTreeObserver OnGlobalLayoutListener is called");
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
            AppMethodBeat.o(219395);
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
              if ((((e)localObject1).zTQ != null) && (((e)localObject1).zTP != null) && (((e)localObject1).hLV != null))
              {
                ae.d("AdLandingFloatWebView", "on event center information: the  height is ".concat(String.valueOf(i)));
                ae.d("AdLandingFloatWebView", "on event center information: the  height of mPlaceHolderView is " + ((e)localObject1).zTQ.getHeight());
                ae.d("AdLandingFloatWebView", "on event center information: the  height of mScrollableLayout is " + ((e)localObject1).zTP.getHeight());
                ae.d("AdLandingFloatWebView", "on event center information: the  height of mWebView is " + ((e)localObject1).hLV.getHeight());
                localObject2 = ((e)localObject1).zTQ.getLayoutParams();
                ((ViewGroup.LayoutParams)localObject2).height = i;
                ((e)localObject1).zTQ.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                localObject2 = ((e)localObject1).hLV.getLayoutParams();
                ((ViewGroup.LayoutParams)localObject2).height = ((e)localObject1).QV(((e)localObject1).zTP.getHeight());
                ((e)localObject1).hLV.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                ((e)localObject1).zTP.setMaxYScrollOffset(i);
                ((e)localObject1).zTP.requestLayout();
              }
            }
          }
        }
        label334:
        AppMethodBeat.o(219395);
        return;
      }
      catch (Throwable localThrowable)
      {
        AppMethodBeat.o(219395);
      }
    }
  }
  
  static final class c
    extends com.tencent.xweb.x
  {
    private final e.a zTT;
    private com.tencent.mm.plugin.webview.e.g zUi;
    private Reference<Activity> znT;
    
    protected c(Activity paramActivity, com.tencent.mm.plugin.webview.e.g paramg, e.a parama)
    {
      AppMethodBeat.i(219398);
      this.znT = new WeakReference(paramActivity);
      this.zUi = paramg;
      this.zTT = parama;
      AppMethodBeat.o(219398);
    }
    
    public final void a(WebView paramWebView, int paramInt)
    {
      AppMethodBeat.i(219399);
      ae.d("AdLandingFloatWebView", "onProgressChanged %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(219399);
    }
    
    public final boolean a(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, x.a parama)
    {
      Object localObject2 = null;
      Object localObject1 = null;
      AppMethodBeat.i(219401);
      Activity localActivity;
      String str1;
      Object localObject3;
      for (;;)
      {
        try
        {
          localActivity = (Activity)this.znT.get();
          if (((e.aF(localActivity)) && (parama.getMode() == 0)) || (parama.getMode() == 1))
          {
            if ((parama.getAcceptTypes() == null) || (parama.getAcceptTypes().length <= 0))
            {
              ae.i("AdLandingFloatWebView", "onShowFileChooser, mode = MODE_OPEN, but params.getAcceptTypes is null");
              AppMethodBeat.o(219401);
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
              localObject3 = this.zTT;
              parama = this.zUi;
              if (e.aF(localActivity)) {
                continue;
              }
              ae.i("AdLandingFloatWebView", "activity is finished.");
              AppMethodBeat.o(219401);
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
            ae.e("AdLandingFloatWebView", "openFileChooser fail, wvPerm is null");
            continue;
          }
          if (parama.eUS().mC(56)) {
            break;
          }
        }
        catch (Throwable paramWebView)
        {
          ae.e("AdLandingFloatWebView", "onShowFileChooser has something wrong");
          AppMethodBeat.o(219401);
          return false;
        }
        label191:
        ae.e("AdLandingFloatWebView", "open file chooser failed, permission fail");
      }
      ((e.a)localObject3).zUe = null;
      ((e.a)localObject3).zUf = paramValueCallback;
      ((e.a)localObject3).zUg = str1;
      ((e.a)localObject3).zUh = String.valueOf(System.currentTimeMillis());
      label266:
      String str2;
      label308:
      int i;
      if (!"user".equalsIgnoreCase(paramWebView))
      {
        parama = paramWebView;
        if (!"environment".equalsIgnoreCase(paramWebView))
        {
          str2 = ((e.a)localObject3).zUh;
          localObject3 = new Intent("android.intent.action.GET_CONTENT");
          ((Intent)localObject3).addCategory("android.intent.category.OPENABLE");
          if (bu.isNullOrNil(str1))
          {
            ((Intent)localObject3).setType("*/*");
            if (bu.isNullOrNil(parama)) {
              break label620;
            }
            if (!"camera".equalsIgnoreCase(parama)) {
              break label438;
            }
            paramWebView = new Intent[1];
            paramWebView[0] = com.tencent.mm.plugin.webview.j.d.aIS(str2);
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
            paramValueCallback.putExtra("android.intent.extra.TITLE", ak.getContext().getString(2131766455));
            paramValueCallback.putExtra("android.intent.extra.INTENT", (Parcelable)localObject3);
          }
          for (paramWebView = paramValueCallback;; paramWebView = paramWebView[0])
          {
            if (com.tencent.mm.pluginsdk.permission.b.n(localActivity, "android.permission.CAMERA")) {
              break label666;
            }
            com.tencent.mm.pluginsdk.permission.b.b(localActivity, "android.permission.CAMERA", 119);
            ae.e("AdLandingFloatWebView", "openFileChooser no Permission");
            break;
            ((Intent)localObject3).setType(str1);
            break label308;
            label438:
            if ("camcorder".equalsIgnoreCase(parama))
            {
              paramWebView = new Intent[1];
              paramWebView[0] = com.tencent.mm.plugin.webview.j.d.eUh();
              i = 0;
              break label340;
            }
            if ("microphone".equalsIgnoreCase(parama))
            {
              paramWebView = new Intent[1];
              paramWebView[0] = com.tencent.mm.plugin.webview.j.d.eUi();
              i = 0;
              break label340;
            }
            if ((!"*".equalsIgnoreCase(parama)) && (!"true".equalsIgnoreCase(parama)))
            {
              paramValueCallback = localObject2;
              if (!"false".equalsIgnoreCase(parama)) {
                break label698;
              }
            }
            if (str1.equalsIgnoreCase("image/*"))
            {
              paramWebView = new Intent[1];
              paramWebView[0] = com.tencent.mm.plugin.webview.j.d.aIS(str2);
            }
            for (;;)
            {
              if ("false".equalsIgnoreCase(parama)) {
                break label712;
              }
              paramValueCallback = paramWebView;
              if (!"*".equalsIgnoreCase(parama)) {
                break;
              }
              break label712;
              if (str1.equalsIgnoreCase("audio/*"))
              {
                paramWebView = new Intent[1];
                paramWebView[0] = com.tencent.mm.plugin.webview.j.d.eUi();
              }
              else
              {
                paramWebView = localObject1;
                if (str1.equalsIgnoreCase("video/*"))
                {
                  paramWebView = new Intent[1];
                  paramWebView[0] = com.tencent.mm.plugin.webview.j.d.eUh();
                }
              }
            }
            label620:
            paramValueCallback = localObject2;
            if (!com.tencent.mm.compatible.util.d.lB(16)) {
              break label698;
            }
            ae.i("MicroMsg.WebJSSDKUtil", "android API version is below 16.");
            paramWebView = new Intent[1];
            paramWebView[0] = com.tencent.mm.plugin.webview.j.d.aIS(str2);
            i = 0;
            break label340;
          }
          try
          {
            label666:
            localActivity.startActivityForResult(paramWebView, 2003);
          }
          catch (Exception paramWebView)
          {
            ae.e("AdLandingFloatWebView", "openFileChooser e = %s", new Object[] { paramWebView });
          }
        }
        break;
        label698:
        i = 0;
        paramWebView = paramValueCallback;
        continue;
        parama = "true";
        break label266;
        label712:
        i = 1;
      }
    }
    
    public final boolean a(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
    {
      return false;
    }
    
    public final boolean b(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
    {
      AppMethodBeat.i(219402);
      ae.d("AdLandingFloatWebView", "onJsConfirm");
      boolean bool = super.b(paramWebView, paramString1, paramString2, paramJsResult);
      AppMethodBeat.o(219402);
      return bool;
    }
    
    public final void onGeolocationPermissionsShowPrompt(final String paramString, final GeolocationPermissions.Callback paramCallback)
    {
      AppMethodBeat.i(219400);
      ae.i("AdLandingFloatWebView", "onGeolocationPermissionsShowPrompt, origin = %s", new Object[] { paramString });
      try
      {
        final Activity localActivity = (Activity)this.znT.get();
        if ((!e.aF(localActivity)) || (paramCallback == null))
        {
          ae.w("AdLandingFloatWebView", "the activity is finished.");
          AppMethodBeat.o(219400);
          return;
        }
        if (com.tencent.mm.pluginsdk.permission.b.n(localActivity, "android.permission.ACCESS_COARSE_LOCATION"))
        {
          com.tencent.mm.ui.base.h.a(localActivity, false, localActivity.getString(2131766453, new Object[] { paramString }), localActivity.getString(2131766454), localActivity.getString(2131755835), localActivity.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(219396);
              ae.i("AdLandingFloatWebView", "onGeolocationPermissionsShowPrompt ok");
              try
              {
                paramCallback.invoke(paramString, true, true);
                an.aG(localActivity);
                AppMethodBeat.o(219396);
                return;
              }
              catch (Throwable paramAnonymousDialogInterface)
              {
                ae.e("AdLandingFloatWebView", "GeolocationPermissions.Callback has something wrong!");
                AppMethodBeat.o(219396);
              }
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(219397);
              ae.i("AdLandingFloatWebView", "onGeolocationPermissionsShowPrompt cancel");
              try
              {
                paramCallback.invoke(paramString, false, false);
                an.aG(localActivity);
                AppMethodBeat.o(219397);
                return;
              }
              catch (Throwable paramAnonymousDialogInterface)
              {
                ae.e("AdLandingFloatWebView", "GeolocationPermissions.Callback has something wrong!");
                AppMethodBeat.o(219397);
              }
            }
          });
          AppMethodBeat.o(219400);
          return;
        }
      }
      catch (Throwable paramString)
      {
        ae.w("AdLandingFloatWebView", "the application has no geo permission.");
        AppMethodBeat.o(219400);
        return;
      }
      ae.w("AdLandingFloatWebView", "the application has no geo permission.");
      AppMethodBeat.o(219400);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e
 * JD-Core Version:    0.7.0.1
 */