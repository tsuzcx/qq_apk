package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.ValueCallback;
import android.widget.LinearLayout.LayoutParams;
import androidx.legacy.widget.Space;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.aa;
import com.tencent.mm.by.c;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.f.a.wj;
import com.tencent.mm.plugin.ay.a.a;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.ui.widget.ad.ScrollableLayout;
import com.tencent.mm.plugin.sns.ui.widget.ad.ScrollableLayout.a;
import com.tencent.mm.plugin.sns.ui.widget.ad.ScrollableLayout.b;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.j;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.k.p;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.mm.ui.widget.MMWebView.c;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.WebView;
import com.tencent.xweb.x;
import com.tencent.xweb.x.a;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public final class e
  extends m
  implements ScrollableLayout.a, ScrollableLayout.b
{
  private BaseWebViewController KpA;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e KpB;
  private a KpC;
  private boolean KpD;
  private com.tencent.mm.plugin.webview.stub.b KpE;
  private ScrollableLayout Kpy;
  private View Kpz;
  private MMWebView lxa;
  private IListener<wj> lxs;
  
  public e(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e parame, ViewGroup paramViewGroup)
  {
    super(paramContext, parame, paramViewGroup);
    AppMethodBeat.i(269876);
    this.KpD = false;
    this.KpE = new com.tencent.mm.plugin.webview.stub.b()
    {
      public final boolean a(final String paramAnonymousString1, final String paramAnonymousString2, final Bundle paramAnonymousBundle, final boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(196032);
        Object localObject = e.a(e.this);
        if (localObject == null)
        {
          AppMethodBeat.o(196032);
          return false;
        }
        try
        {
          localObject = ((BaseWebViewController)localObject).getJsapi();
          com.tencent.e.h.ZvG.bc(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(268213);
              try
              {
                if (this.KpG != null) {
                  this.KpG.a(paramAnonymousString1, paramAnonymousString2, n.aJ(paramAnonymousBundle), paramAnonymousBoolean);
                }
                AppMethodBeat.o(268213);
                return;
              }
              catch (Throwable localThrowable)
              {
                Log.e("AdLandingFloatWebView", "In jsapi onHandleEnd method, it happens something unwanted!");
                AppMethodBeat.o(268213);
              }
            }
          });
          AppMethodBeat.o(196032);
          return false;
        }
        catch (Throwable paramAnonymousString1)
        {
          for (;;)
          {
            Log.e("AdLandingFloatWebView", "In onHandleEnd method, it happens something unwanted!");
          }
        }
      }
      
      public final String bXN()
      {
        AppMethodBeat.i(196030);
        try
        {
          Object localObject = e.a(e.this);
          if (localObject != null)
          {
            localObject = ((BaseWebViewController)localObject).PFN;
            AppMethodBeat.o(196030);
            return localObject;
          }
        }
        catch (Throwable localThrowable)
        {
          Log.e("AdLandingFloatWebView", "callback: getCommitUrl failed");
          AppMethodBeat.o(196030);
        }
        return "";
      }
      
      public final String getCurrentUrl()
      {
        AppMethodBeat.i(196028);
        try
        {
          Object localObject = e.a(e.this);
          if (localObject != null)
          {
            localObject = ((BaseWebViewController)localObject).getCurrentUrl();
            AppMethodBeat.o(196028);
            return localObject;
          }
        }
        catch (Throwable localThrowable)
        {
          Log.e("AdLandingFloatWebView", "callback: getCurrentUrl failed");
          AppMethodBeat.o(196028);
        }
        return "";
      }
      
      public final boolean h(int paramAnonymousInt, final Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(196040);
        try
        {
          Object localObject = e.a(e.this);
          if (localObject == null)
          {
            AppMethodBeat.o(196040);
            return true;
          }
          final com.tencent.mm.plugin.webview.d.h localh = ((BaseWebViewController)localObject).getJsapi();
          localObject = ((BaseWebViewController)localObject).pGD;
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(196040);
            return true;
            com.tencent.e.h.ZvG.bc(new Runnable()
            {
              public final void run()
              {
                boolean bool = true;
                AppMethodBeat.i(224376);
                try
                {
                  if ((!paramAnonymousBundle.containsKey("jsapi_preverify_fun_list")) || (this.KpM == null)) {
                    if (this.KpM != null) {
                      Log.e("AdLandingFloatWebView", "has JSAPI_CONTROL_BYTES wvPerm %b", new Object[] { Boolean.valueOf(bool) });
                    }
                  }
                  for (;;)
                  {
                    localh.gTS();
                    AppMethodBeat.o(224376);
                    return;
                    bool = false;
                    break;
                    this.KpM.aN(paramAnonymousBundle);
                  }
                  return;
                }
                catch (Throwable localThrowable)
                {
                  Log.e("AdLandingFloatWebView", "In onCallback method, it happens something unwanted!");
                  AppMethodBeat.o(224376);
                }
              }
            });
          }
          return true;
        }
        catch (Throwable paramAnonymousBundle)
        {
          Log.e("AdLandingFloatWebView", "In callback method, it happens something unwanted!");
          AppMethodBeat.o(196040);
        }
      }
      
      public final Bundle l(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(196037);
        Bundle localBundle = new Bundle();
        Object localObject = e.this.context;
        switch (paramAnonymousInt)
        {
        }
        do
        {
          AppMethodBeat.o(196037);
          return localBundle;
        } while ((localObject == null) || (paramAnonymousBundle == null));
        for (;;)
        {
          try
          {
            paramAnonymousBundle.setClassLoader(((Context)localObject).getClassLoader());
            localObject = paramAnonymousBundle.getBundle("open_ui_with_webview_ui_extras");
            String str1 = IntentUtil.getString(paramAnonymousBundle, "open_ui_with_webview_ui_plugin_name");
            String str2 = IntentUtil.getString(paramAnonymousBundle, "open_ui_with_webview_ui_plugin_entry");
            Context localContext = e.this.context;
            Intent localIntent = new Intent();
            if (localObject == null) {
              break label140;
            }
            paramAnonymousBundle = (Bundle)localObject;
            c.b(localContext, str1, str2, localIntent.putExtras(paramAnonymousBundle));
          }
          catch (Throwable paramAnonymousBundle)
          {
            Log.e("AdLandingFloatWebView", "In invokeAsResult method, it happens something unwanted!");
          }
          break;
          label140:
          paramAnonymousBundle = new Bundle();
        }
      }
    };
    try
    {
      this.KpB = parame;
      if (this.lxs == null)
      {
        this.lxs = new IListener()
        {
          private boolean a(wj paramAnonymouswj)
          {
            AppMethodBeat.i(269626);
            try
            {
              e.a(e.this, paramAnonymouswj);
              AppMethodBeat.o(269626);
              return true;
            }
            catch (Throwable paramAnonymouswj)
            {
              for (;;)
              {
                Log.w("AdLandingFloatWebView", "resizing layout has wrong!");
              }
            }
          }
        };
        this.lxs.alive();
      }
      AppMethodBeat.o(269876);
      return;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(269876);
    }
  }
  
  static boolean aP(Activity paramActivity)
  {
    AppMethodBeat.i(269884);
    if ((paramActivity != null) && (!paramActivity.isFinishing()) && (!paramActivity.isDestroyed()))
    {
      AppMethodBeat.o(269884);
      return true;
    }
    AppMethodBeat.o(269884);
    return false;
  }
  
  private int agk(int paramInt)
  {
    AppMethodBeat.i(269886);
    try
    {
      int j = ao.ib(this.context)[1];
      i = paramInt;
      if (paramInt == j)
      {
        i = paramInt;
        if (ar.aN(this.context))
        {
          i = ar.aM(this.context);
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
    AppMethodBeat.o(269886);
    return i;
  }
  
  static String baS(String paramString)
  {
    AppMethodBeat.i(269885);
    if (("user".equalsIgnoreCase(paramString)) || ("environment".equalsIgnoreCase(paramString)))
    {
      AppMethodBeat.o(269885);
      return "true";
    }
    AppMethodBeat.o(269885);
    return paramString;
  }
  
  private String baT(String paramString)
  {
    AppMethodBeat.i(269887);
    localObject1 = paramString;
    try
    {
      ai localai = fRp();
      localObject2 = paramString;
      if (localai != null)
      {
        localObject2 = paramString;
        localObject1 = paramString;
        if (!TextUtils.isEmpty(paramString))
        {
          localObject1 = paramString;
          localObject2 = localai.fQE();
          Object localObject3 = localObject2;
          localObject1 = paramString;
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = paramString;
            localObject3 = localai.uxInfo;
          }
          localObject2 = paramString;
          localObject1 = paramString;
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            localObject1 = paramString;
            localObject2 = t.kw(paramString, (String)localObject3);
          }
          localObject1 = localObject2;
          localObject2 = com.tencent.mm.plugin.sns.ad.c.a.a.aYo((String)localObject2);
        }
      }
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        Log.e("AdLandingFloatWebView", "fill url param occur error!");
        Object localObject2 = localObject1;
      }
    }
    AppMethodBeat.o(269887);
    return localObject2;
  }
  
  public final void bb(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(269882);
    if (paramInt == 0) {}
    try
    {
      androidx.h.a.a locala = androidx.h.a.a.V(this.context);
      Intent localIntent = new Intent("com.tencent.mm.adlanding.video.action.PAUSE_OR_RESUME");
      if (paramBoolean) {}
      for (paramInt = 1;; paramInt = 2)
      {
        localIntent.putExtra("TRY_PAUSE_OR_RESUME", paramInt);
        localIntent.putExtra("identity", this.context.hashCode());
        locala.c(localIntent);
        AppMethodBeat.o(269882);
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.w("AdLandingFloatWebView", "onScrollChanged method has something wrong");
      AppMethodBeat.o(269882);
    }
  }
  
  protected final void fKe()
  {
    AppMethodBeat.i(269877);
    try
    {
      if (this.KpA == null)
      {
        String str = baT(this.KpB.Klf);
        Intent localIntent = new Intent();
        localIntent.putExtra("rawUrl", str);
        localIntent.putExtra("useJs", true);
        localIntent.putExtra("type", -255);
        localIntent.putExtra("geta8key_scene", 2);
        this.KpA = ((aa)com.tencent.mm.kernel.h.ae(aa.class)).a(this.lxa);
        this.KpA.a(new j()
        {
          public final void bXM()
          {
            AppMethodBeat.i(222267);
            try
            {
              e.a(e.this).pGC.a(e.b(e.this), e.a(e.this).gSo());
              AppMethodBeat.o(222267);
              return;
            }
            catch (Throwable localThrowable)
            {
              Log.e("AdLandingFloatWebView", "bind webview callback failed");
              AppMethodBeat.o(222267);
            }
          }
        });
        this.lxa.setWebChromeClient(new MMWebView.c(new c((Activity)this.context, this.KpA.pGD, this.KpC)));
        this.KpA.init();
        this.KpA.bj(localIntent);
        Log.d("AdLandingFloatWebView", "url is ".concat(String.valueOf(str)));
      }
      AppMethodBeat.o(269877);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("AdLandingFloatWebView", "bind webview callback failed");
      AppMethodBeat.o(269877);
    }
  }
  
  protected final View fKj()
  {
    AppMethodBeat.i(269879);
    for (;;)
    {
      try
      {
        this.Kpy = new ScrollableLayout(this.context);
        localObject2 = this.KpB.Klf;
        localObject1 = null;
        if (p.bno((String)localObject2)) {
          localObject1 = MMWebView.a.lG(this.context);
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = MMWebView.a.lH(this.context);
        }
        this.lxa = ((MMWebView)localObject2);
        localObject1 = new LinearLayout.LayoutParams(-1, -1);
        this.Kpz = new Space(this.context);
        this.Kpz.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.Kpy.addView(this.Kpz);
        this.KpC = new a();
        this.Kpy.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.Kpy.setDescendantScrollStatusHunter(this);
        this.Kpy.setOnScrollStatusListener(this);
        localObject1 = new LinearLayout.LayoutParams(-1, -1);
        localObject2 = this.Kpy;
        localMMWebView = this.lxa;
      }
      catch (Throwable localThrowable2)
      {
        Object localObject2;
        Object localObject1;
        MMWebView localMMWebView;
        Log.w("AdLandingFloatWebView", "the customLayout method has something wrong");
        continue;
      }
      try
      {
        ((ScrollableLayout)localObject2).addView(localMMWebView, (ViewGroup.LayoutParams)localObject1);
        ((ScrollableLayout)localObject2).LuI = localMMWebView;
        localObject1 = this.Kpy;
        AppMethodBeat.o(269879);
        return localObject1;
      }
      catch (Throwable localThrowable1)
      {
        Log.w("ScrollLinearLayout", "the addView has something wrong!");
      }
    }
  }
  
  public final void fKo()
  {
    AppMethodBeat.i(269881);
    super.fKo();
    try
    {
      Log.i("AdLandingFloatWebView", "the view is going to destroy");
      if (this.lxs != null) {
        this.lxs.dead();
      }
      if (this.KpA != null) {
        this.KpA.onDestroy();
      }
      if (this.lxa != null) {
        this.lxa.destroy();
      }
      AppMethodBeat.o(269881);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.w("AdLandingFloatWebView", "the destroy method has something wrong");
      AppMethodBeat.o(269881);
    }
  }
  
  public final void fKp()
  {
    AppMethodBeat.i(269878);
    super.fKp();
    if (!this.KpD)
    {
      this.KpD = true;
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
        AppMethodBeat.o(269878);
        return;
      }
      catch (Throwable localThrowable) {}
    }
    AppMethodBeat.o(269878);
  }
  
  static final class a
  {
    ValueCallback<Uri> KpN;
    ValueCallback<Uri[]> KpO;
    String KpP;
    String KpQ;
  }
  
  final class b
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    b() {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(256763);
      try
      {
        Log.i("AdLandingFloatWebView", "viewTreeObserver OnGlobalLayoutListener is called");
        Object localObject1 = e.this.contentView;
        if ((localObject1 != null) && (((View)localObject1).getViewTreeObserver().isAlive()))
        {
          ((View)localObject1).getViewTreeObserver().removeOnGlobalLayoutListener(this);
          Object localObject2 = ((View)localObject1).getRootView();
          if (localObject2 == null) {}
          for (;;)
          {
            localObject1 = ((View)localObject1).findViewById(i.f.vertical_viewpager);
            if ((!(localObject1 instanceof ViewGroup)) || (((ViewGroup)localObject1).getChildCount() <= 0)) {
              break label156;
            }
            localObject1 = ((ViewGroup)localObject1).getChildAt(0);
            if (localObject1 != null) {
              break;
            }
            AppMethodBeat.o(256763);
            return;
            localObject1 = localObject2;
          }
          localObject1 = ((View)localObject1).findViewById(i.f.content_list);
          if (((localObject1 instanceof ViewGroup)) && (((ViewGroup)localObject1).getChildCount() > 0))
          {
            localObject1 = ((ViewGroup)localObject1).getChildAt(0);
            if (localObject1 != null)
            {
              localObject2 = e.this;
              ((View)localObject1).getWidth();
              e.a((e)localObject2, ((View)localObject1).getHeight());
            }
          }
        }
        label156:
        AppMethodBeat.o(256763);
        return;
      }
      catch (Throwable localThrowable)
      {
        AppMethodBeat.o(256763);
      }
    }
  }
  
  static final class c
    extends x
  {
    private Reference<Activity> JDu;
    private final e.a KpC;
    private com.tencent.mm.plugin.webview.f.g KpR;
    
    protected c(Activity paramActivity, com.tencent.mm.plugin.webview.f.g paramg, e.a parama)
    {
      AppMethodBeat.i(230622);
      this.JDu = new WeakReference(paramActivity);
      this.KpR = paramg;
      this.KpC = parama;
      AppMethodBeat.o(230622);
    }
    
    public final void a(WebView paramWebView, int paramInt)
    {
      AppMethodBeat.i(230623);
      Log.d("AdLandingFloatWebView", "onProgressChanged %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(230623);
    }
    
    public final boolean a(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, x.a parama)
    {
      Object localObject2 = null;
      Object localObject1 = null;
      AppMethodBeat.i(230632);
      Activity localActivity;
      String str1;
      for (;;)
      {
        try
        {
          localActivity = (Activity)this.JDu.get();
          if (((e.aP(localActivity)) && (parama.getMode() == 0)) || (parama.getMode() == 1))
          {
            if ((parama.getAcceptTypes() == null) || (parama.getAcceptTypes().length <= 0))
            {
              Log.i("AdLandingFloatWebView", "onShowFileChooser, mode = MODE_OPEN, but params.getAcceptTypes is null");
              AppMethodBeat.o(230632);
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
              parama = this.KpC;
              localObject3 = this.KpR;
              if (e.aP(localActivity)) {
                continue;
              }
              Log.i("AdLandingFloatWebView", "activity is finished.");
              AppMethodBeat.o(230632);
              return true;
            }
            paramWebView = (WebView)localObject3;
            if (!"video/*".equalsIgnoreCase(str1)) {
              continue;
            }
            paramWebView = "camcorder";
            continue;
            if (localObject3 != null) {
              break label192;
            }
            Log.e("AdLandingFloatWebView", "openFileChooser fail, wvPerm is null");
            continue;
          }
          if (((com.tencent.mm.plugin.webview.f.g)localObject3).gWI().so(56)) {
            break;
          }
        }
        catch (Throwable paramWebView)
        {
          Log.e("AdLandingFloatWebView", "onShowFileChooser has something wrong");
          AppMethodBeat.o(230632);
          return false;
        }
        label192:
        Log.e("AdLandingFloatWebView", "open file chooser failed, permission fail");
      }
      parama.KpN = null;
      parama.KpO = paramValueCallback;
      parama.KpP = str1;
      parama.KpQ = String.valueOf(System.currentTimeMillis());
      Object localObject3 = e.baS(paramWebView);
      String str2 = parama.KpQ;
      parama = new Intent("android.intent.action.GET_CONTENT");
      parama.addCategory("android.intent.category.OPENABLE");
      label285:
      int i;
      if (Util.isNullOrNil(str1))
      {
        parama.setType("*/*");
        if (Util.isNullOrNil((String)localObject3)) {
          break label606;
        }
        if (!"camera".equalsIgnoreCase((String)localObject3)) {
          break label416;
        }
        paramWebView = new Intent[1];
        paramWebView[0] = com.tencent.mm.plugin.webview.k.g.bkR(str2);
        i = 0;
      }
      for (;;)
      {
        for (;;)
        {
          label319:
          if ((i != 0) || (paramWebView == null) || (paramWebView.length == 0))
          {
            paramValueCallback = new Intent("android.intent.action.CHOOSER");
            paramValueCallback.putExtra("android.intent.extra.INITIAL_INTENTS", paramWebView);
            paramValueCallback.putExtra("android.intent.extra.TITLE", MMApplicationContext.getContext().getString(a.a.webview_select_file_alert_title));
            paramValueCallback.putExtra("android.intent.extra.INTENT", parama);
          }
          for (paramWebView = paramValueCallback;; paramWebView = paramWebView[0])
          {
            if (com.tencent.mm.pluginsdk.permission.b.o(localActivity, "android.permission.CAMERA")) {
              break label652;
            }
            com.tencent.mm.pluginsdk.permission.b.b(localActivity, "android.permission.CAMERA", 119);
            Log.e("AdLandingFloatWebView", "openFileChooser no Permission");
            break;
            parama.setType(str1);
            break label285;
            label416:
            if ("camcorder".equalsIgnoreCase((String)localObject3))
            {
              paramWebView = new Intent[1];
              paramWebView[0] = com.tencent.mm.plugin.webview.k.g.gVS();
              i = 0;
              break label319;
            }
            if ("microphone".equalsIgnoreCase((String)localObject3))
            {
              paramWebView = new Intent[1];
              paramWebView[0] = com.tencent.mm.plugin.webview.k.g.gVT();
              i = 0;
              break label319;
            }
            if ((!"*".equalsIgnoreCase((String)localObject3)) && (!"true".equalsIgnoreCase((String)localObject3)))
            {
              paramValueCallback = localObject2;
              if (!"false".equalsIgnoreCase((String)localObject3)) {
                break label684;
              }
            }
            if (str1.equalsIgnoreCase("image/*"))
            {
              paramWebView = new Intent[1];
              paramWebView[0] = com.tencent.mm.plugin.webview.k.g.bkR(str2);
            }
            for (;;)
            {
              if ("false".equalsIgnoreCase((String)localObject3)) {
                break label692;
              }
              paramValueCallback = paramWebView;
              if (!"*".equalsIgnoreCase((String)localObject3)) {
                break;
              }
              break label692;
              if (str1.equalsIgnoreCase("audio/*"))
              {
                paramWebView = new Intent[1];
                paramWebView[0] = com.tencent.mm.plugin.webview.k.g.gVT();
              }
              else
              {
                paramWebView = localObject1;
                if (str1.equalsIgnoreCase("video/*"))
                {
                  paramWebView = new Intent[1];
                  paramWebView[0] = com.tencent.mm.plugin.webview.k.g.gVS();
                }
              }
            }
            label606:
            paramValueCallback = localObject2;
            if (!d.qW(16)) {
              break label684;
            }
            Log.i("MicroMsg.WebJSSDKUtil", "android API version is below 16.");
            paramWebView = new Intent[1];
            paramWebView[0] = com.tencent.mm.plugin.webview.k.g.bkR(str2);
            i = 0;
            break label319;
          }
          try
          {
            label652:
            localActivity.startActivityForResult(paramWebView, 2003);
          }
          catch (Exception paramWebView)
          {
            Log.e("AdLandingFloatWebView", "openFileChooser e = %s", new Object[] { paramWebView });
          }
        }
        break;
        label684:
        i = 0;
        paramWebView = paramValueCallback;
        continue;
        label692:
        i = 1;
      }
    }
    
    public final boolean a(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
    {
      return false;
    }
    
    public final boolean b(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
    {
      AppMethodBeat.i(230635);
      Log.d("AdLandingFloatWebView", "onJsConfirm");
      boolean bool = super.b(paramWebView, paramString1, paramString2, paramJsResult);
      AppMethodBeat.o(230635);
      return bool;
    }
    
    public final void onGeolocationPermissionsShowPrompt(final String paramString, final GeolocationPermissions.Callback paramCallback)
    {
      AppMethodBeat.i(230627);
      Log.i("AdLandingFloatWebView", "onGeolocationPermissionsShowPrompt, origin = %s", new Object[] { paramString });
      try
      {
        final Activity localActivity = (Activity)this.JDu.get();
        if ((!e.aP(localActivity)) || (paramCallback == null))
        {
          Log.w("AdLandingFloatWebView", "the activity is finished.");
          AppMethodBeat.o(230627);
          return;
        }
        if (com.tencent.mm.pluginsdk.permission.b.o(localActivity, "android.permission.ACCESS_FINE_LOCATION"))
        {
          com.tencent.mm.ui.base.h.a(localActivity, false, localActivity.getString(i.j.webview_get_location_msg, new Object[] { paramString }), localActivity.getString(i.j.webview_get_location_title), localActivity.getString(i.j.app_ok), localActivity.getString(i.j.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(194593);
              Log.i("AdLandingFloatWebView", "onGeolocationPermissionsShowPrompt ok");
              try
              {
                paramCallback.invoke(paramString, true, true);
                ao.aQ(localActivity);
                AppMethodBeat.o(194593);
                return;
              }
              catch (Throwable paramAnonymousDialogInterface)
              {
                Log.e("AdLandingFloatWebView", "GeolocationPermissions.Callback has something wrong!");
                AppMethodBeat.o(194593);
              }
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(266909);
              Log.i("AdLandingFloatWebView", "onGeolocationPermissionsShowPrompt cancel");
              try
              {
                paramCallback.invoke(paramString, false, false);
                ao.aQ(localActivity);
                AppMethodBeat.o(266909);
                return;
              }
              catch (Throwable paramAnonymousDialogInterface)
              {
                Log.e("AdLandingFloatWebView", "GeolocationPermissions.Callback has something wrong!");
                AppMethodBeat.o(266909);
              }
            }
          });
          AppMethodBeat.o(230627);
          return;
        }
      }
      catch (Throwable paramString)
      {
        Log.w("AdLandingFloatWebView", "the application has no geo permission.");
        AppMethodBeat.o(230627);
        return;
      }
      Log.w("AdLandingFloatWebView", "the application has no geo permission.");
      AppMethodBeat.o(230627);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e
 * JD-Core Version:    0.7.0.1
 */