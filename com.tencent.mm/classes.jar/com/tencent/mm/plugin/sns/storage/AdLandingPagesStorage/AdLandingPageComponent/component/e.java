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
import com.tencent.mm.g.a.tk;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae;
import com.tencent.mm.plugin.sns.ui.widget.ad.ScrollableLayout;
import com.tencent.mm.plugin.sns.ui.widget.ad.ScrollableLayout.a;
import com.tencent.mm.plugin.sns.ui.widget.ad.ScrollableLayout.b;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.l;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.mm.ui.widget.MMWebView.b;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.WebView;
import com.tencent.xweb.x.a;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public final class e
  extends k
  implements ScrollableLayout.a, ScrollableLayout.b
{
  MMWebView hqK;
  private c<tk> hrc;
  ScrollableLayout ylY;
  View ylZ;
  BaseWebViewController yma;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e ymb;
  private a ymc;
  private boolean ymd;
  com.tencent.mm.plugin.webview.stub.b yme;
  
  public e(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e parame, ViewGroup paramViewGroup)
  {
    super(paramContext, parame, paramViewGroup);
    AppMethodBeat.i(200155);
    this.ymd = false;
    this.yme = new com.tencent.mm.plugin.webview.stub.b()
    {
      public final boolean a(final String paramAnonymousString1, final String paramAnonymousString2, final Bundle paramAnonymousBundle, final boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(200140);
        Object localObject = e.this.yma;
        if (localObject == null)
        {
          AppMethodBeat.o(200140);
          return false;
        }
        try
        {
          localObject = ((BaseWebViewController)localObject).getJsapi();
          com.tencent.e.h.JZN.aQ(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(200136);
              try
              {
                if (this.ymg != null) {
                  this.ymg.a(paramAnonymousString1, paramAnonymousString2, l.at(paramAnonymousBundle), paramAnonymousBoolean);
                }
                AppMethodBeat.o(200136);
                return;
              }
              catch (Throwable localThrowable)
              {
                ac.e("AdLandingFloatWebView", "In jsapi onHandleEnd method, it happens something unwanted!");
                AppMethodBeat.o(200136);
              }
            }
          });
          AppMethodBeat.o(200140);
          return false;
        }
        catch (Throwable paramAnonymousString1)
        {
          for (;;)
          {
            ac.e("AdLandingFloatWebView", "In onHandleEnd method, it happens something unwanted!");
          }
        }
      }
      
      public final String dKq()
      {
        AppMethodBeat.i(200139);
        try
        {
          Object localObject = e.this.yma;
          if (localObject != null)
          {
            localObject = ((BaseWebViewController)localObject).Cdb;
            AppMethodBeat.o(200139);
            return localObject;
          }
        }
        catch (Throwable localThrowable)
        {
          ac.e("AdLandingFloatWebView", "callback: getCommitUrl failed");
          AppMethodBeat.o(200139);
        }
        return "";
      }
      
      public final boolean g(int paramAnonymousInt, final Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(200142);
        try
        {
          Object localObject = e.this.yma;
          if (localObject == null)
          {
            AppMethodBeat.o(200142);
            return true;
          }
          final f localf = ((BaseWebViewController)localObject).getJsapi();
          localObject = ((BaseWebViewController)localObject).kYu;
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(200142);
            return true;
            com.tencent.e.h.JZN.aQ(new Runnable()
            {
              public final void run()
              {
                boolean bool = true;
                AppMethodBeat.i(200137);
                try
                {
                  if ((!paramAnonymousBundle.containsKey("jsapi_preverify_fun_list")) || (this.ymm == null)) {
                    if (this.ymm != null) {
                      ac.e("AdLandingFloatWebView", "has JSAPI_CONTROL_BYTES wvPerm %b", new Object[] { Boolean.valueOf(bool) });
                    }
                  }
                  for (;;)
                  {
                    localf.ezL();
                    AppMethodBeat.o(200137);
                    return;
                    bool = false;
                    break;
                    this.ymm.ax(paramAnonymousBundle);
                  }
                  return;
                }
                catch (Throwable localThrowable)
                {
                  ac.e("AdLandingFloatWebView", "In onCallback method, it happens something unwanted!");
                  AppMethodBeat.o(200137);
                }
              }
            });
          }
          return true;
        }
        catch (Throwable paramAnonymousBundle)
        {
          ac.e("AdLandingFloatWebView", "In callback method, it happens something unwanted!");
          AppMethodBeat.o(200142);
        }
      }
      
      public final String getCurrentUrl()
      {
        AppMethodBeat.i(200138);
        try
        {
          Object localObject = e.this.yma;
          if (localObject != null)
          {
            localObject = ((BaseWebViewController)localObject).getCurrentUrl();
            AppMethodBeat.o(200138);
            return localObject;
          }
        }
        catch (Throwable localThrowable)
        {
          ac.e("AdLandingFloatWebView", "callback: getCurrentUrl failed");
          AppMethodBeat.o(200138);
        }
        return "";
      }
      
      public final Bundle k(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(200141);
        Bundle localBundle = new Bundle();
        Object localObject = e.this.context;
        switch (paramAnonymousInt)
        {
        }
        do
        {
          AppMethodBeat.o(200141);
          return localBundle;
        } while ((localObject == null) || (paramAnonymousBundle == null));
        for (;;)
        {
          try
          {
            paramAnonymousBundle.setClassLoader(((Context)localObject).getClassLoader());
            localObject = paramAnonymousBundle.getBundle("open_ui_with_webview_ui_extras");
            String str1 = com.tencent.mm.sdk.platformtools.x.n(paramAnonymousBundle, "open_ui_with_webview_ui_plugin_name");
            String str2 = com.tencent.mm.sdk.platformtools.x.n(paramAnonymousBundle, "open_ui_with_webview_ui_plugin_entry");
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
            ac.e("AdLandingFloatWebView", "In invokeAsResult method, it happens something unwanted!");
          }
          break;
          label140:
          paramAnonymousBundle = new Bundle();
        }
      }
    };
    try
    {
      this.ymb = parame;
      if (this.hrc == null)
      {
        this.hrc = new c()
        {
          private boolean a(tk paramAnonymoustk)
          {
            AppMethodBeat.i(200145);
            try
            {
              e.a(e.this, paramAnonymoustk);
              AppMethodBeat.o(200145);
              return true;
            }
            catch (Throwable paramAnonymoustk)
            {
              for (;;)
              {
                ac.w("AdLandingFloatWebView", "resizing layout has wrong!");
              }
            }
          }
        };
        this.hrc.alive();
      }
      AppMethodBeat.o(200155);
      return;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(200155);
    }
  }
  
  static boolean aE(Activity paramActivity)
  {
    AppMethodBeat.i(200163);
    if ((paramActivity != null) && (!paramActivity.isFinishing()) && (!paramActivity.isDestroyed()))
    {
      AppMethodBeat.o(200163);
      return true;
    }
    AppMethodBeat.o(200163);
    return false;
  }
  
  private String auE(String paramString)
  {
    AppMethodBeat.i(200165);
    try
    {
      ae localae = dKH();
      str2 = paramString;
      if (localae != null)
      {
        str2 = paramString;
        if (!TextUtils.isEmpty(paramString))
        {
          str2 = localae.yka;
          String str1 = str2;
          if (TextUtils.isEmpty(str2)) {
            str1 = localae.dtx;
          }
          str2 = paramString;
          if (!TextUtils.isEmpty(str1)) {
            str2 = q.iV(paramString, str1);
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ac.e("AdLandingFloatWebView", "fill url param occur error!");
        String str2 = paramString;
      }
    }
    AppMethodBeat.o(200165);
    return str2;
  }
  
  private boolean u(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(200162);
    if (paramViewGroup != null)
    {
      if (paramViewGroup.getScrollY() != 0)
      {
        AppMethodBeat.o(200162);
        return true;
      }
      int i = 0;
      while (i < paramViewGroup.getChildCount())
      {
        View localView = paramViewGroup.getChildAt(i);
        if ((localView instanceof ViewGroup))
        {
          if (u((ViewGroup)localView))
          {
            AppMethodBeat.o(200162);
            return true;
          }
        }
        else if ((localView != null) && (localView.getScrollY() != 0))
        {
          AppMethodBeat.o(200162);
          return true;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(200162);
    return false;
  }
  
  final int OG(int paramInt)
  {
    AppMethodBeat.i(200164);
    try
    {
      int j = al.gg(this.context)[1];
      i = paramInt;
      if (paramInt == j)
      {
        i = paramInt;
        if (aj.aG(this.context))
        {
          i = aj.aF(this.context);
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
    AppMethodBeat.o(200164);
    return i;
  }
  
  public final void av(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(200161);
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
        AppMethodBeat.o(200161);
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.w("AdLandingFloatWebView", "onScrollChanged method has something wrong");
      AppMethodBeat.o(200161);
    }
  }
  
  public final void dJW()
  {
    AppMethodBeat.i(200157);
    super.dJW();
    if (!this.ymd)
    {
      this.ymd = true;
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
        AppMethodBeat.o(200157);
        return;
      }
      catch (Throwable localThrowable) {}
    }
    AppMethodBeat.o(200157);
  }
  
  public final void dJX()
  {
    AppMethodBeat.i(200159);
    super.dJX();
    try
    {
      ac.i("AdLandingFloatWebView", "the view is going to destroy");
      if (this.hrc != null) {
        this.hrc.dead();
      }
      if (this.yma != null) {
        this.yma.onDestroy();
      }
      if (this.hqK != null) {
        this.hqK.destroy();
      }
      AppMethodBeat.o(200159);
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.w("AdLandingFloatWebView", "the destroy method has something wrong");
      AppMethodBeat.o(200159);
    }
  }
  
  protected final void dKm()
  {
    AppMethodBeat.i(200156);
    try
    {
      if (this.yma == null)
      {
        String str = auE(this.ymb.yiq);
        Intent localIntent = new Intent();
        localIntent.putExtra("rawUrl", str);
        localIntent.putExtra("useJs", true);
        localIntent.putExtra("type", -255);
        localIntent.putExtra("geta8key_scene", 2);
        this.yma = ((com.tencent.mm.api.x)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.x.class)).a(this.hqK);
        this.yma.a(new com.tencent.mm.plugin.webview.core.i()
        {
          public final void dKr()
          {
            AppMethodBeat.i(200143);
            try
            {
              e.this.yma.kYt.a(e.this.yme, e.this.yma.eyt());
              AppMethodBeat.o(200143);
              return;
            }
            catch (Throwable localThrowable)
            {
              ac.e("AdLandingFloatWebView", "bind webview callback failed");
              AppMethodBeat.o(200143);
            }
          }
        });
        this.hqK.setWebChromeClient(new MMWebView.b(new c((Activity)this.context, this.yma.kYu, this.ymc)));
        this.yma.init();
        this.yma.ao(localIntent);
        ac.d("AdLandingFloatWebView", "url is ".concat(String.valueOf(str)));
      }
      AppMethodBeat.o(200156);
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.e("AdLandingFloatWebView", "bind webview callback failed");
      AppMethodBeat.o(200156);
    }
  }
  
  protected final View dKp()
  {
    AppMethodBeat.i(200158);
    for (;;)
    {
      try
      {
        this.ylY = new ScrollableLayout(this.context);
        localObject2 = this.ymb.yiq;
        localObject1 = null;
        if (com.tencent.mm.plugin.webview.j.i.aEb((String)localObject2)) {
          localObject1 = MMWebView.a.ku(this.context);
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = MMWebView.a.kv(this.context);
        }
        this.hqK = ((MMWebView)localObject2);
        localObject1 = new LinearLayout.LayoutParams(-1, -1);
        this.ylZ = new Space(this.context);
        this.ylZ.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.ylY.addView(this.ylZ);
        this.ymc = new a();
        this.ylY.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.ylY.setDescendantScrollStatusHunter(this);
        this.ylY.setOnScrollStatusListener(this);
        localObject1 = new LinearLayout.LayoutParams(-1, -1);
        localObject2 = this.ylY;
        localMMWebView = this.hqK;
      }
      catch (Throwable localThrowable2)
      {
        Object localObject2;
        Object localObject1;
        MMWebView localMMWebView;
        ac.w("AdLandingFloatWebView", "the customLayout method has something wrong");
        continue;
      }
      try
      {
        ((ScrollableLayout)localObject2).addView(localMMWebView, (ViewGroup.LayoutParams)localObject1);
        ((ScrollableLayout)localObject2).zlH = localMMWebView;
        localObject1 = this.ylY;
        AppMethodBeat.o(200158);
        return localObject1;
      }
      catch (Throwable localThrowable1)
      {
        ac.w("ScrollLinearLayout", "the addView has something wrong!");
      }
    }
  }
  
  public final boolean eH(View paramView)
  {
    AppMethodBeat.i(200160);
    try
    {
      MMWebView localMMWebView = this.hqK;
      if (paramView != localMMWebView)
      {
        AppMethodBeat.o(200160);
        return false;
      }
      boolean bool = u(this.hqK);
      AppMethodBeat.o(200160);
      return bool;
    }
    catch (Throwable paramView)
    {
      ac.e("AdLandingFloatWebView", "hasDescendantScrolled method has something wrong");
      AppMethodBeat.o(200160);
    }
    return false;
  }
  
  static final class a
  {
    ValueCallback<Uri> ymn;
    ValueCallback<Uri[]> ymo;
    String ymp;
    String ymq;
  }
  
  final class b
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    b() {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(200147);
      try
      {
        ac.i("AdLandingFloatWebView", "viewTreeObserver OnGlobalLayoutListener is called");
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
            AppMethodBeat.o(200147);
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
              if ((((e)localObject1).ylZ != null) && (((e)localObject1).ylY != null) && (((e)localObject1).hqK != null))
              {
                ac.d("AdLandingFloatWebView", "on event center information: the  height is ".concat(String.valueOf(i)));
                ac.d("AdLandingFloatWebView", "on event center information: the  height of mPlaceHolderView is " + ((e)localObject1).ylZ.getHeight());
                ac.d("AdLandingFloatWebView", "on event center information: the  height of mScrollableLayout is " + ((e)localObject1).ylY.getHeight());
                ac.d("AdLandingFloatWebView", "on event center information: the  height of mWebView is " + ((e)localObject1).hqK.getHeight());
                localObject2 = ((e)localObject1).ylZ.getLayoutParams();
                ((ViewGroup.LayoutParams)localObject2).height = i;
                ((e)localObject1).ylZ.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                localObject2 = ((e)localObject1).hqK.getLayoutParams();
                ((ViewGroup.LayoutParams)localObject2).height = ((e)localObject1).OG(((e)localObject1).ylY.getHeight());
                ((e)localObject1).hqK.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                ((e)localObject1).ylY.setMaxYScrollOffset(i);
                ((e)localObject1).ylY.requestLayout();
              }
            }
          }
        }
        label334:
        AppMethodBeat.o(200147);
        return;
      }
      catch (Throwable localThrowable)
      {
        AppMethodBeat.o(200147);
      }
    }
  }
  
  static final class c
    extends com.tencent.xweb.x
  {
    private Reference<Activity> xId;
    private final e.a ymc;
    private com.tencent.mm.plugin.webview.e.g ymr;
    
    protected c(Activity paramActivity, com.tencent.mm.plugin.webview.e.g paramg, e.a parama)
    {
      AppMethodBeat.i(200150);
      this.xId = new WeakReference(paramActivity);
      this.ymr = paramg;
      this.ymc = parama;
      AppMethodBeat.o(200150);
    }
    
    public final void a(WebView paramWebView, int paramInt)
    {
      AppMethodBeat.i(200151);
      ac.d("AdLandingFloatWebView", "onProgressChanged %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(200151);
    }
    
    public final boolean a(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, x.a parama)
    {
      Object localObject2 = null;
      Object localObject1 = null;
      AppMethodBeat.i(200153);
      Activity localActivity;
      String str1;
      Object localObject3;
      for (;;)
      {
        try
        {
          localActivity = (Activity)this.xId.get();
          if (((e.aE(localActivity)) && (parama.getMode() == 0)) || (parama.getMode() == 1))
          {
            if ((parama.getAcceptTypes() == null) || (parama.getAcceptTypes().length <= 0))
            {
              ac.i("AdLandingFloatWebView", "onShowFileChooser, mode = MODE_OPEN, but params.getAcceptTypes is null");
              AppMethodBeat.o(200153);
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
              localObject3 = this.ymc;
              parama = this.ymr;
              if (e.aE(localActivity)) {
                continue;
              }
              ac.i("AdLandingFloatWebView", "activity is finished.");
              AppMethodBeat.o(200153);
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
            ac.e("AdLandingFloatWebView", "openFileChooser fail, wvPerm is null");
            continue;
          }
          if (parama.eCm().ma(56)) {
            break;
          }
        }
        catch (Throwable paramWebView)
        {
          ac.e("AdLandingFloatWebView", "onShowFileChooser has something wrong");
          AppMethodBeat.o(200153);
          return false;
        }
        label191:
        ac.e("AdLandingFloatWebView", "open file chooser failed, permission fail");
      }
      ((e.a)localObject3).ymn = null;
      ((e.a)localObject3).ymo = paramValueCallback;
      ((e.a)localObject3).ymp = str1;
      ((e.a)localObject3).ymq = String.valueOf(System.currentTimeMillis());
      label266:
      String str2;
      label308:
      int i;
      if (!"user".equalsIgnoreCase(paramWebView))
      {
        parama = paramWebView;
        if (!"environment".equalsIgnoreCase(paramWebView))
        {
          str2 = ((e.a)localObject3).ymq;
          localObject3 = new Intent("android.intent.action.GET_CONTENT");
          ((Intent)localObject3).addCategory("android.intent.category.OPENABLE");
          if (bs.isNullOrNil(str1))
          {
            ((Intent)localObject3).setType("*/*");
            if (bs.isNullOrNil(parama)) {
              break label620;
            }
            if (!"camera".equalsIgnoreCase(parama)) {
              break label438;
            }
            paramWebView = new Intent[1];
            paramWebView[0] = com.tencent.mm.plugin.webview.j.d.aBY(str2);
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
            paramValueCallback.putExtra("android.intent.extra.TITLE", ai.getContext().getString(2131766455));
            paramValueCallback.putExtra("android.intent.extra.INTENT", (Parcelable)localObject3);
          }
          for (paramWebView = paramValueCallback;; paramWebView = paramWebView[0])
          {
            if (com.tencent.mm.pluginsdk.permission.b.o(localActivity, "android.permission.CAMERA")) {
              break label666;
            }
            com.tencent.mm.pluginsdk.permission.b.b(localActivity, "android.permission.CAMERA", 119);
            ac.e("AdLandingFloatWebView", "openFileChooser no Permission");
            break;
            ((Intent)localObject3).setType(str1);
            break label308;
            label438:
            if ("camcorder".equalsIgnoreCase(parama))
            {
              paramWebView = new Intent[1];
              paramWebView[0] = com.tencent.mm.plugin.webview.j.d.eBB();
              i = 0;
              break label340;
            }
            if ("microphone".equalsIgnoreCase(parama))
            {
              paramWebView = new Intent[1];
              paramWebView[0] = com.tencent.mm.plugin.webview.j.d.eBC();
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
              paramWebView[0] = com.tencent.mm.plugin.webview.j.d.aBY(str2);
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
                paramWebView[0] = com.tencent.mm.plugin.webview.j.d.eBC();
              }
              else
              {
                paramWebView = localObject1;
                if (str1.equalsIgnoreCase("video/*"))
                {
                  paramWebView = new Intent[1];
                  paramWebView[0] = com.tencent.mm.plugin.webview.j.d.eBB();
                }
              }
            }
            label620:
            paramValueCallback = localObject2;
            if (!com.tencent.mm.compatible.util.d.la(16)) {
              break label696;
            }
            ac.i("MicroMsg.WebJSSDKUtil", "android API version is below 16.");
            paramWebView = new Intent[1];
            paramWebView[0] = com.tencent.mm.plugin.webview.j.d.aBY(str2);
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
            ac.e("AdLandingFloatWebView", "openFileChooser e = %s", new Object[] { paramWebView });
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
      AppMethodBeat.i(200154);
      ac.d("AdLandingFloatWebView", "onJsConfirm");
      boolean bool = super.b(paramWebView, paramString1, paramString2, paramJsResult);
      AppMethodBeat.o(200154);
      return bool;
    }
    
    public final void onGeolocationPermissionsShowPrompt(final String paramString, final GeolocationPermissions.Callback paramCallback)
    {
      AppMethodBeat.i(200152);
      ac.i("AdLandingFloatWebView", "onGeolocationPermissionsShowPrompt, origin = %s", new Object[] { paramString });
      try
      {
        final Activity localActivity = (Activity)this.xId.get();
        if ((!e.aE(localActivity)) || (paramCallback == null))
        {
          ac.w("AdLandingFloatWebView", "the activity is finished.");
          AppMethodBeat.o(200152);
          return;
        }
        if (com.tencent.mm.pluginsdk.permission.b.o(localActivity, "android.permission.ACCESS_COARSE_LOCATION"))
        {
          com.tencent.mm.ui.base.h.a(localActivity, false, localActivity.getString(2131766453, new Object[] { paramString }), localActivity.getString(2131766454), localActivity.getString(2131755835), localActivity.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(200148);
              ac.i("AdLandingFloatWebView", "onGeolocationPermissionsShowPrompt ok");
              try
              {
                paramCallback.invoke(paramString, true, true);
                al.aF(localActivity);
                AppMethodBeat.o(200148);
                return;
              }
              catch (Throwable paramAnonymousDialogInterface)
              {
                ac.e("AdLandingFloatWebView", "GeolocationPermissions.Callback has something wrong!");
                AppMethodBeat.o(200148);
              }
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(200149);
              ac.i("AdLandingFloatWebView", "onGeolocationPermissionsShowPrompt cancel");
              try
              {
                paramCallback.invoke(paramString, false, false);
                al.aF(localActivity);
                AppMethodBeat.o(200149);
                return;
              }
              catch (Throwable paramAnonymousDialogInterface)
              {
                ac.e("AdLandingFloatWebView", "GeolocationPermissions.Callback has something wrong!");
                AppMethodBeat.o(200149);
              }
            }
          });
          AppMethodBeat.o(200152);
          return;
        }
      }
      catch (Throwable paramString)
      {
        ac.w("AdLandingFloatWebView", "the application has no geo permission.");
        AppMethodBeat.o(200152);
        return;
      }
      ac.w("AdLandingFloatWebView", "the application has no geo permission.");
      AppMethodBeat.o(200152);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e
 * JD-Core Version:    0.7.0.1
 */