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
import com.tencent.mm.api.x;
import com.tencent.mm.g.a.tb;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.ui.widget.ad.ScrollableLayout;
import com.tencent.mm.plugin.sns.ui.widget.ad.ScrollableLayout.a;
import com.tencent.mm.plugin.sns.ui.widget.ad.ScrollableLayout.b;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.l;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.mm.ui.widget.MMWebView.b;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.WebView;
import com.tencent.xweb.w;
import com.tencent.xweb.w.a;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public final class e
  extends k
  implements ScrollableLayout.a, ScrollableLayout.b
{
  private c<tb> gQC;
  MMWebView gQk;
  ScrollableLayout wZk;
  View wZl;
  BaseWebViewController wZm;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e wZn;
  private a wZo;
  private boolean wZp;
  com.tencent.mm.plugin.webview.stub.b wZq;
  
  public e(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e parame, ViewGroup paramViewGroup)
  {
    super(paramContext, parame, paramViewGroup);
    AppMethodBeat.i(187358);
    this.wZp = false;
    this.wZq = new com.tencent.mm.plugin.webview.stub.b()
    {
      public final boolean a(final String paramAnonymousString1, final String paramAnonymousString2, final Bundle paramAnonymousBundle, final boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(187343);
        Object localObject = e.this.wZm;
        if (localObject == null)
        {
          AppMethodBeat.o(187343);
          return false;
        }
        try
        {
          localObject = ((BaseWebViewController)localObject).getJsapi();
          com.tencent.e.h.Iye.aN(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(187339);
              try
              {
                if (this.wZs != null) {
                  this.wZs.a(paramAnonymousString1, paramAnonymousString2, l.ap(paramAnonymousBundle), paramAnonymousBoolean);
                }
                AppMethodBeat.o(187339);
                return;
              }
              catch (Throwable localThrowable)
              {
                com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingFloatWebViewComponent", "In jsapi onHandleEnd method, it happens something unwanted!");
                AppMethodBeat.o(187339);
              }
            }
          });
          AppMethodBeat.o(187343);
          return false;
        }
        catch (Throwable paramAnonymousString1)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingFloatWebViewComponent", "In onHandleEnd method, it happens something unwanted!");
          }
        }
      }
      
      public final String dvR()
      {
        AppMethodBeat.i(187342);
        try
        {
          Object localObject = e.this.wZm;
          if (localObject != null)
          {
            localObject = ((BaseWebViewController)localObject).AKK;
            AppMethodBeat.o(187342);
            return localObject;
          }
        }
        catch (Throwable localThrowable)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingFloatWebViewComponent", "callback: getCommitUrl failed");
          AppMethodBeat.o(187342);
        }
        return "";
      }
      
      public final boolean f(int paramAnonymousInt, final Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(187345);
        try
        {
          Object localObject = e.this.wZm;
          if (localObject == null)
          {
            AppMethodBeat.o(187345);
            return true;
          }
          final f localf = ((BaseWebViewController)localObject).getJsapi();
          localObject = ((BaseWebViewController)localObject).kxg;
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(187345);
            return true;
            com.tencent.e.h.Iye.aN(new Runnable()
            {
              public final void run()
              {
                boolean bool = true;
                AppMethodBeat.i(187340);
                try
                {
                  if ((!paramAnonymousBundle.containsKey("jsapi_preverify_fun_list")) || (this.wZy == null)) {
                    if (this.wZy != null) {
                      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingFloatWebViewComponent", "has JSAPI_CONTROL_BYTES wvPerm %b", new Object[] { Boolean.valueOf(bool) });
                    }
                  }
                  for (;;)
                  {
                    localf.ekp();
                    AppMethodBeat.o(187340);
                    return;
                    bool = false;
                    break;
                    this.wZy.as(paramAnonymousBundle);
                  }
                  return;
                }
                catch (Throwable localThrowable)
                {
                  com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingFloatWebViewComponent", "In onCallback method, it happens something unwanted!");
                  AppMethodBeat.o(187340);
                }
              }
            });
          }
          return true;
        }
        catch (Throwable paramAnonymousBundle)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingFloatWebViewComponent", "In callback method, it happens something unwanted!");
          AppMethodBeat.o(187345);
        }
      }
      
      public final String getCurrentUrl()
      {
        AppMethodBeat.i(187341);
        try
        {
          Object localObject = e.this.wZm;
          if (localObject != null)
          {
            localObject = ((BaseWebViewController)localObject).getCurrentUrl();
            AppMethodBeat.o(187341);
            return localObject;
          }
        }
        catch (Throwable localThrowable)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingFloatWebViewComponent", "callback: getCurrentUrl failed");
          AppMethodBeat.o(187341);
        }
        return "";
      }
      
      public final Bundle j(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(187344);
        Bundle localBundle = new Bundle();
        Object localObject = e.this.context;
        switch (paramAnonymousInt)
        {
        }
        do
        {
          AppMethodBeat.o(187344);
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
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingFloatWebViewComponent", "In invokeAsResult method, it happens something unwanted!");
          }
          break;
          label140:
          paramAnonymousBundle = new Bundle();
        }
      }
    };
    try
    {
      this.wZn = parame;
      if (this.gQC == null)
      {
        this.gQC = new c()
        {
          private boolean a(tb paramAnonymoustb)
          {
            AppMethodBeat.i(187348);
            try
            {
              e.a(e.this, paramAnonymoustb);
              AppMethodBeat.o(187348);
              return true;
            }
            catch (Throwable paramAnonymoustb)
            {
              for (;;)
              {
                com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.Sns.AdLandingFloatWebViewComponent", "resizing layout has wrong!");
              }
            }
          }
        };
        this.gQC.alive();
      }
      AppMethodBeat.o(187358);
      return;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(187358);
    }
  }
  
  static boolean aA(Activity paramActivity)
  {
    AppMethodBeat.i(187366);
    if ((paramActivity != null) && (!paramActivity.isFinishing()) && (!paramActivity.isDestroyed()))
    {
      AppMethodBeat.o(187366);
      return true;
    }
    AppMethodBeat.o(187366);
    return false;
  }
  
  private String apt(String paramString)
  {
    AppMethodBeat.i(187368);
    try
    {
      Object localObject = dwi();
      str1 = paramString;
      if (localObject != null)
      {
        str1 = paramString;
        if (!TextUtils.isEmpty(paramString))
        {
          localObject = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)localObject).dvK;
          str1 = paramString;
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            str1 = q.iy(paramString, (String)localObject);
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        String str1;
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingFloatWebViewComponent", "fill url param occur error!");
        String str2 = paramString;
      }
    }
    AppMethodBeat.o(187368);
    return str1;
  }
  
  private boolean t(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(187365);
    if (paramViewGroup != null)
    {
      if (paramViewGroup.getScrollY() != 0)
      {
        AppMethodBeat.o(187365);
        return true;
      }
      int i = 0;
      while (i < paramViewGroup.getChildCount())
      {
        View localView = paramViewGroup.getChildAt(i);
        if ((localView instanceof ViewGroup))
        {
          if (t((ViewGroup)localView))
          {
            AppMethodBeat.o(187365);
            return true;
          }
        }
        else if ((localView != null) && (localView.getScrollY() != 0))
        {
          AppMethodBeat.o(187365);
          return true;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(187365);
    return false;
  }
  
  final int ME(int paramInt)
  {
    AppMethodBeat.i(187367);
    try
    {
      int j = al.fU(this.context)[1];
      i = paramInt;
      if (paramInt == j)
      {
        i = paramInt;
        if (ai.aF(this.context))
        {
          i = ai.aE(this.context);
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
    AppMethodBeat.o(187367);
    return i;
  }
  
  public final void as(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(187364);
    if (paramInt == 0) {}
    try
    {
      android.support.v4.content.d locald = android.support.v4.content.d.T(this.context);
      Intent localIntent = new Intent("com.tencent.mm.adlanding.video.action.PAUSE_OR_RESUME");
      if (paramBoolean) {}
      for (paramInt = 1;; paramInt = 2)
      {
        localIntent.putExtra("TRY_PAUSE_OR_RESUME", paramInt);
        localIntent.putExtra("identity", this.context.hashCode());
        locald.b(localIntent);
        AppMethodBeat.o(187364);
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.Sns.AdLandingFloatWebViewComponent", "onScrollChanged method has something wrong");
      AppMethodBeat.o(187364);
    }
  }
  
  protected final void dvN()
  {
    AppMethodBeat.i(187359);
    try
    {
      if (this.wZm == null)
      {
        String str = apt(this.wZn.wVC);
        Intent localIntent = new Intent();
        localIntent.putExtra("rawUrl", str);
        localIntent.putExtra("useJs", true);
        localIntent.putExtra("type", -255);
        localIntent.putExtra("geta8key_scene", 2);
        this.wZm = ((x)com.tencent.mm.kernel.g.ab(x.class)).a(this.gQk);
        this.wZm.a(new com.tencent.mm.plugin.webview.core.i()
        {
          public final void dvS()
          {
            AppMethodBeat.i(187346);
            try
            {
              e.this.wZm.kxf.a(e.this.wZq, e.this.wZm.eiZ());
              AppMethodBeat.o(187346);
              return;
            }
            catch (Throwable localThrowable)
            {
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingFloatWebViewComponent", "bind webview callback failed");
              AppMethodBeat.o(187346);
            }
          }
        });
        this.gQk.setWebChromeClient(new MMWebView.b(new c((Activity)this.context, this.wZm.kxg, this.wZo)));
        this.wZm.init();
        this.wZm.an(localIntent);
      }
      AppMethodBeat.o(187359);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingFloatWebViewComponent", "bind webview callback failed");
      AppMethodBeat.o(187359);
    }
  }
  
  protected final View dvQ()
  {
    AppMethodBeat.i(187361);
    for (;;)
    {
      try
      {
        this.wZk = new ScrollableLayout(this.context);
        localObject2 = this.wZn.wVC;
        localObject1 = null;
        if (com.tencent.mm.plugin.webview.j.i.ayK((String)localObject2)) {
          localObject1 = MMWebView.a.kj(this.context);
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = MMWebView.a.kk(this.context);
        }
        this.gQk = ((MMWebView)localObject2);
        localObject1 = new LinearLayout.LayoutParams(-1, -1);
        this.wZl = new Space(this.context);
        this.wZl.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.wZk.addView(this.wZl);
        this.wZo = new a();
        this.wZk.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.wZk.setDescendantScrollStatusHunter(this);
        this.wZk.setOnScrollStatusListener(this);
        localObject1 = new LinearLayout.LayoutParams(-1, -1);
        localObject2 = this.wZk;
        localMMWebView = this.gQk;
      }
      catch (Throwable localThrowable2)
      {
        Object localObject2;
        Object localObject1;
        MMWebView localMMWebView;
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.Sns.AdLandingFloatWebViewComponent", "the customLayout method has something wrong");
        continue;
      }
      try
      {
        ((ScrollableLayout)localObject2).addView(localMMWebView, (ViewGroup.LayoutParams)localObject1);
        ((ScrollableLayout)localObject2).xYK = localMMWebView;
        localObject1 = this.wZk;
        AppMethodBeat.o(187361);
        return localObject1;
      }
      catch (Throwable localThrowable1)
      {
        com.tencent.mm.sdk.platformtools.ad.w("ScrollLinearLayout", "the addView has something wrong!");
      }
    }
  }
  
  public final void dvx()
  {
    AppMethodBeat.i(187360);
    super.dvx();
    if (!this.wZp)
    {
      this.wZp = true;
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
        AppMethodBeat.o(187360);
        return;
      }
      catch (Throwable localThrowable) {}
    }
    AppMethodBeat.o(187360);
  }
  
  public final void dvy()
  {
    AppMethodBeat.i(187362);
    super.dvy();
    try
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sns.AdLandingFloatWebViewComponent", "the view is going to destroy");
      if (this.gQC != null) {
        this.gQC.dead();
      }
      if (this.wZm != null) {
        this.wZm.onDestroy();
      }
      if (this.gQk != null) {
        this.gQk.destroy();
      }
      AppMethodBeat.o(187362);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.Sns.AdLandingFloatWebViewComponent", "the destroy method has something wrong");
      AppMethodBeat.o(187362);
    }
  }
  
  public final boolean eu(View paramView)
  {
    AppMethodBeat.i(187363);
    try
    {
      MMWebView localMMWebView = this.gQk;
      if (paramView != localMMWebView)
      {
        AppMethodBeat.o(187363);
        return false;
      }
      boolean bool = t(this.gQk);
      AppMethodBeat.o(187363);
      return bool;
    }
    catch (Throwable paramView)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingFloatWebViewComponent", "hasDescendantScrolled method has something wrong");
      AppMethodBeat.o(187363);
    }
    return false;
  }
  
  static final class a
  {
    ValueCallback<Uri[]> wZA;
    String wZB;
    String wZC;
    ValueCallback<Uri> wZz;
  }
  
  final class b
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    b() {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(187350);
      try
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sns.AdLandingFloatWebViewComponent", "viewTreeObserver OnGlobalLayoutListener is called");
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
            AppMethodBeat.o(187350);
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
              if ((((e)localObject1).wZl != null) && (((e)localObject1).wZk != null) && (((e)localObject1).gQk != null))
              {
                com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sns.AdLandingFloatWebViewComponent", "on event center information: the  height is ".concat(String.valueOf(i)));
                com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sns.AdLandingFloatWebViewComponent", "on event center information: the  height of mPlaceHolderView is " + ((e)localObject1).wZl.getHeight());
                com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sns.AdLandingFloatWebViewComponent", "on event center information: the  height of mScrollableLayout is " + ((e)localObject1).wZk.getHeight());
                com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sns.AdLandingFloatWebViewComponent", "on event center information: the  height of mWebView is " + ((e)localObject1).gQk.getHeight());
                localObject2 = ((e)localObject1).wZl.getLayoutParams();
                ((ViewGroup.LayoutParams)localObject2).height = i;
                ((e)localObject1).wZl.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                localObject2 = ((e)localObject1).gQk.getLayoutParams();
                ((ViewGroup.LayoutParams)localObject2).height = ((e)localObject1).ME(((e)localObject1).wZk.getHeight());
                ((e)localObject1).gQk.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                ((e)localObject1).wZk.setMaxYScrollOffset(i);
                ((e)localObject1).wZk.requestLayout();
              }
            }
          }
        }
        label334:
        AppMethodBeat.o(187350);
        return;
      }
      catch (Throwable localThrowable)
      {
        AppMethodBeat.o(187350);
      }
    }
  }
  
  static final class c
    extends w
  {
    private Reference<Activity> wZD;
    private com.tencent.mm.plugin.webview.e.g wZE;
    private final e.a wZo;
    
    protected c(Activity paramActivity, com.tencent.mm.plugin.webview.e.g paramg, e.a parama)
    {
      AppMethodBeat.i(187353);
      this.wZD = new WeakReference(paramActivity);
      this.wZE = paramg;
      this.wZo = parama;
      AppMethodBeat.o(187353);
    }
    
    public final void a(WebView paramWebView, int paramInt)
    {
      AppMethodBeat.i(187354);
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sns.AdLandingFloatWebViewComponent", "onProgressChanged %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(187354);
    }
    
    public final boolean a(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, w.a parama)
    {
      Object localObject2 = null;
      Object localObject1 = null;
      AppMethodBeat.i(187356);
      Activity localActivity;
      String str1;
      Object localObject3;
      for (;;)
      {
        try
        {
          localActivity = (Activity)this.wZD.get();
          if (((e.aA(localActivity)) && (parama.getMode() == 0)) || (parama.getMode() == 1))
          {
            if ((parama.getAcceptTypes() == null) || (parama.getAcceptTypes().length <= 0))
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sns.AdLandingFloatWebViewComponent", "onShowFileChooser, mode = MODE_OPEN, but params.getAcceptTypes is null");
              AppMethodBeat.o(187356);
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
              localObject3 = this.wZo;
              parama = this.wZE;
              if (e.aA(localActivity)) {
                continue;
              }
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sns.AdLandingFloatWebViewComponent", "activity is finished.");
              AppMethodBeat.o(187356);
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
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingFloatWebViewComponent", "openFileChooser fail, wvPerm is null");
            continue;
          }
          if (parama.emR().mb(56)) {
            break;
          }
        }
        catch (Throwable paramWebView)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingFloatWebViewComponent", "onShowFileChooser has something wrong");
          AppMethodBeat.o(187356);
          return false;
        }
        label191:
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingFloatWebViewComponent", "open file chooser failed, permission fail");
      }
      ((e.a)localObject3).wZz = null;
      ((e.a)localObject3).wZA = paramValueCallback;
      ((e.a)localObject3).wZB = str1;
      ((e.a)localObject3).wZC = String.valueOf(System.currentTimeMillis());
      label266:
      String str2;
      label308:
      int i;
      if (!"user".equalsIgnoreCase(paramWebView))
      {
        parama = paramWebView;
        if (!"environment".equalsIgnoreCase(paramWebView))
        {
          str2 = ((e.a)localObject3).wZC;
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
            paramWebView[0] = com.tencent.mm.plugin.webview.j.d.awG(str2);
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
            if (com.tencent.mm.pluginsdk.permission.b.o(localActivity, "android.permission.CAMERA")) {
              break label666;
            }
            com.tencent.mm.pluginsdk.permission.b.b(localActivity, "android.permission.CAMERA", 119);
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingFloatWebViewComponent", "openFileChooser no Permission");
            break;
            ((Intent)localObject3).setType(str1);
            break label308;
            label438:
            if ("camcorder".equalsIgnoreCase(parama))
            {
              paramWebView = new Intent[1];
              paramWebView[0] = com.tencent.mm.plugin.webview.j.d.emf();
              i = 0;
              break label340;
            }
            if ("microphone".equalsIgnoreCase(parama))
            {
              paramWebView = new Intent[1];
              paramWebView[0] = com.tencent.mm.plugin.webview.j.d.emg();
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
              paramWebView[0] = com.tencent.mm.plugin.webview.j.d.awG(str2);
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
                paramWebView[0] = com.tencent.mm.plugin.webview.j.d.emg();
              }
              else
              {
                paramWebView = localObject1;
                if (str1.equalsIgnoreCase("video/*"))
                {
                  paramWebView = new Intent[1];
                  paramWebView[0] = com.tencent.mm.plugin.webview.j.d.emf();
                }
              }
            }
            label620:
            paramValueCallback = localObject2;
            if (!com.tencent.mm.compatible.util.d.lg(16)) {
              break label696;
            }
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebJSSDKUtil", "android API version is below 16.");
            paramWebView = new Intent[1];
            paramWebView[0] = com.tencent.mm.plugin.webview.j.d.awG(str2);
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
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingFloatWebViewComponent", "openFileChooser e = %s", new Object[] { paramWebView });
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
      AppMethodBeat.i(187357);
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sns.AdLandingFloatWebViewComponent", "onJsConfirm");
      boolean bool = super.b(paramWebView, paramString1, paramString2, paramJsResult);
      AppMethodBeat.o(187357);
      return bool;
    }
    
    public final void onGeolocationPermissionsShowPrompt(final String paramString, final GeolocationPermissions.Callback paramCallback)
    {
      AppMethodBeat.i(187355);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sns.AdLandingFloatWebViewComponent", "onGeolocationPermissionsShowPrompt, origin = %s", new Object[] { paramString });
      try
      {
        final Activity localActivity = (Activity)this.wZD.get();
        if ((!e.aA(localActivity)) || (paramCallback == null))
        {
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.Sns.AdLandingFloatWebViewComponent", "the activity is finished.");
          AppMethodBeat.o(187355);
          return;
        }
        if (com.tencent.mm.pluginsdk.permission.b.o(localActivity, "android.permission.ACCESS_COARSE_LOCATION"))
        {
          com.tencent.mm.ui.base.h.a(localActivity, false, localActivity.getString(2131766453, new Object[] { paramString }), localActivity.getString(2131766454), localActivity.getString(2131755835), localActivity.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(187351);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sns.AdLandingFloatWebViewComponent", "onGeolocationPermissionsShowPrompt ok");
              try
              {
                paramCallback.invoke(paramString, true, true);
                al.aB(localActivity);
                AppMethodBeat.o(187351);
                return;
              }
              catch (Throwable paramAnonymousDialogInterface)
              {
                com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingFloatWebViewComponent", "GeolocationPermissions.Callback has something wrong!");
                AppMethodBeat.o(187351);
              }
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(187352);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sns.AdLandingFloatWebViewComponent", "onGeolocationPermissionsShowPrompt cancel");
              try
              {
                paramCallback.invoke(paramString, false, false);
                al.aB(localActivity);
                AppMethodBeat.o(187352);
                return;
              }
              catch (Throwable paramAnonymousDialogInterface)
              {
                com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingFloatWebViewComponent", "GeolocationPermissions.Callback has something wrong!");
                AppMethodBeat.o(187352);
              }
            }
          });
          AppMethodBeat.o(187355);
          return;
        }
      }
      catch (Throwable paramString)
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.Sns.AdLandingFloatWebViewComponent", "the application has no geo permission.");
        AppMethodBeat.o(187355);
        return;
      }
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.Sns.AdLandingFloatWebViewComponent", "the application has no geo permission.");
      AppMethodBeat.o(187355);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e
 * JD-Core Version:    0.7.0.1
 */