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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ab;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.yc;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.ba.a.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.ui.widget.ad.ScrollableLayout;
import com.tencent.mm.plugin.sns.ui.widget.ad.ScrollableLayout.a;
import com.tencent.mm.plugin.sns.ui.widget.ad.ScrollableLayout.b;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.l;
import com.tencent.mm.plugin.webview.e.g;
import com.tencent.mm.plugin.webview.jsapi.j;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.mm.ui.widget.MMWebView.c;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.WebView;
import com.tencent.xweb.z;
import com.tencent.xweb.z.a;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public final class e
  extends n
  implements ScrollableLayout.a, ScrollableLayout.b
{
  private ScrollableLayout QNF;
  private View QNG;
  private BaseWebViewController QNH;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e QNI;
  private a QNJ;
  private boolean QNK;
  private com.tencent.mm.plugin.webview.stub.b QNL;
  private IListener<yc> ooQ;
  private MMWebView ooz;
  
  public e(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e parame, ViewGroup paramViewGroup)
  {
    super(paramContext, parame, paramViewGroup);
    AppMethodBeat.i(307083);
    this.QNK = false;
    this.QNL = new com.tencent.mm.plugin.webview.stub.b()
    {
      public final boolean a(final String paramAnonymousString1, final String paramAnonymousString2, final Bundle paramAnonymousBundle, final boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(306911);
        Object localObject = e.a(e.this);
        if (localObject == null)
        {
          AppMethodBeat.o(306911);
          return false;
        }
        try
        {
          localObject = ((BaseWebViewController)localObject).getJsapi();
          com.tencent.threadpool.h.ahAA.bk(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(307061);
              try
              {
                if (this.QNN != null) {
                  this.QNN.a(paramAnonymousString1, paramAnonymousString2, p.bm(paramAnonymousBundle), paramAnonymousBoolean);
                }
                AppMethodBeat.o(307061);
                return;
              }
              finally
              {
                Log.e("AdLandingFloatWebView", "In jsapi onHandleEnd method, it happens something unwanted!");
                AppMethodBeat.o(307061);
              }
            }
          });
          AppMethodBeat.o(306911);
          return false;
        }
        finally
        {
          for (;;)
          {
            Log.e("AdLandingFloatWebView", "In onHandleEnd method, it happens something unwanted!");
          }
        }
      }
      
      public final String cxY()
      {
        AppMethodBeat.i(306910);
        try
        {
          Object localObject1 = e.a(e.this);
          if (localObject1 != null)
          {
            localObject1 = ((BaseWebViewController)localObject1).Wwz;
            AppMethodBeat.o(306910);
            return localObject1;
          }
        }
        finally
        {
          Log.e("AdLandingFloatWebView", "callback: getCommitUrl failed");
          AppMethodBeat.o(306910);
        }
        return "";
      }
      
      public final String getCurrentUrl()
      {
        AppMethodBeat.i(306909);
        try
        {
          Object localObject1 = e.a(e.this);
          if (localObject1 != null)
          {
            localObject1 = ((BaseWebViewController)localObject1).getCurrentUrl();
            AppMethodBeat.o(306909);
            return localObject1;
          }
        }
        finally
        {
          Log.e("AdLandingFloatWebView", "callback: getCurrentUrl failed");
          AppMethodBeat.o(306909);
        }
        return "";
      }
      
      public final boolean i(int paramAnonymousInt, final Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(306913);
        try
        {
          Object localObject = e.a(e.this);
          if (localObject == null)
          {
            AppMethodBeat.o(306913);
            return true;
          }
          final j localj = ((BaseWebViewController)localObject).getJsapi();
          localObject = ((BaseWebViewController)localObject).sLD;
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(306913);
            return true;
            com.tencent.threadpool.h.ahAA.bk(new Runnable()
            {
              public final void run()
              {
                boolean bool = true;
                AppMethodBeat.i(307064);
                try
                {
                  if ((!paramAnonymousBundle.containsKey("jsapi_preverify_fun_list")) || (this.QNT == null)) {
                    if (this.QNT != null) {
                      Log.e("AdLandingFloatWebView", "has JSAPI_CONTROL_BYTES wvPerm %b", new Object[] { Boolean.valueOf(bool) });
                    }
                  }
                  for (;;)
                  {
                    localj.itz();
                    AppMethodBeat.o(307064);
                    return;
                    bool = false;
                    break;
                    this.QNT.br(paramAnonymousBundle);
                  }
                  return;
                }
                finally
                {
                  Log.e("AdLandingFloatWebView", "In onCallback method, it happens something unwanted!");
                  AppMethodBeat.o(307064);
                }
              }
            });
          }
          return true;
        }
        finally
        {
          Log.e("AdLandingFloatWebView", "In callback method, it happens something unwanted!");
          AppMethodBeat.o(306913);
        }
      }
      
      public final Bundle m(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(306912);
        Bundle localBundle = new Bundle();
        Object localObject = e.this.context;
        switch (paramAnonymousInt)
        {
        }
        do
        {
          AppMethodBeat.o(306912);
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
            com.tencent.mm.br.c.b(localContext, str1, str2, localIntent.putExtras(paramAnonymousBundle));
            break;
          }
          finally
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
      this.QNI = parame;
      if (this.ooQ == null)
      {
        this.ooQ = new AdLandingFloatWebViewComponent.3(this, f.hfK);
        this.ooQ.alive();
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(307083);
    }
  }
  
  static String aZt(String paramString)
  {
    AppMethodBeat.i(307090);
    if (("user".equalsIgnoreCase(paramString)) || ("environment".equalsIgnoreCase(paramString)))
    {
      AppMethodBeat.o(307090);
      return "true";
    }
    AppMethodBeat.o(307090);
    return paramString;
  }
  
  private String aZu(String paramString)
  {
    AppMethodBeat.i(307098);
    localObject1 = paramString;
    try
    {
      ai localai = hjn();
      localObject2 = paramString;
      if (localai != null)
      {
        localObject2 = paramString;
        localObject1 = paramString;
        if (!TextUtils.isEmpty(paramString))
        {
          localObject1 = paramString;
          localObject2 = localai.hiC();
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
            localObject2 = com.tencent.mm.plugin.sns.data.t.lY(paramString, (String)localObject3);
          }
          localObject1 = localObject2;
          localObject2 = com.tencent.mm.plugin.sns.ad.c.a.a.aWj((String)localObject2);
        }
      }
    }
    finally
    {
      for (;;)
      {
        Log.e("AdLandingFloatWebView", "fill url param occur error!");
        Object localObject2 = localObject1;
      }
    }
    AppMethodBeat.o(307098);
    return localObject2;
  }
  
  private int alc(int paramInt)
  {
    AppMethodBeat.i(307092);
    try
    {
      int j = ar.jR(this.context)[1];
      i = paramInt;
      if (paramInt == j)
      {
        i = paramInt;
        if (aw.bx(this.context))
        {
          i = aw.bw(this.context);
          i = j - i;
        }
      }
    }
    finally
    {
      for (;;)
      {
        int i = paramInt;
      }
    }
    AppMethodBeat.o(307092);
    return i;
  }
  
  static boolean br(Activity paramActivity)
  {
    AppMethodBeat.i(307086);
    if ((paramActivity != null) && (!paramActivity.isFinishing()) && (!paramActivity.isDestroyed()))
    {
      AppMethodBeat.o(307086);
      return true;
    }
    AppMethodBeat.o(307086);
    return false;
  }
  
  public final void Gs()
  {
    AppMethodBeat.i(307132);
    super.Gs();
    if (!this.QNK)
    {
      this.QNK = true;
      try
      {
        Object localObject1 = this.contentView;
        if (localObject1 != null)
        {
          localObject1 = ((View)localObject1).getViewTreeObserver();
          if (((ViewTreeObserver)localObject1).isAlive()) {
            ((ViewTreeObserver)localObject1).addOnGlobalLayoutListener(new b());
          }
        }
        AppMethodBeat.o(307132);
        return;
      }
      finally {}
    }
    AppMethodBeat.o(307132);
  }
  
  public final void bI(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(307150);
    if (paramInt == 0) {}
    try
    {
      androidx.i.a.a locala = androidx.i.a.a.al(this.context);
      Intent localIntent = new Intent("com.tencent.mm.adlanding.video.action.PAUSE_OR_RESUME");
      if (paramBoolean) {}
      for (paramInt = 1;; paramInt = 2)
      {
        localIntent.putExtra("TRY_PAUSE_OR_RESUME", paramInt);
        localIntent.putExtra("identity", this.context.hashCode());
        locala.d(localIntent);
        AppMethodBeat.o(307150);
        return;
      }
      return;
    }
    finally
    {
      Log.w("AdLandingFloatWebView", "onScrollChanged method has something wrong");
      AppMethodBeat.o(307150);
    }
  }
  
  protected final void had()
  {
    AppMethodBeat.i(307128);
    try
    {
      if (this.QNH == null)
      {
        String str = aZu(this.QNI.QJm);
        Intent localIntent = new Intent();
        localIntent.putExtra("rawUrl", str);
        localIntent.putExtra("useJs", true);
        localIntent.putExtra("type", -255);
        localIntent.putExtra("geta8key_scene", 2);
        this.QNH = ((ab)com.tencent.mm.kernel.h.ax(ab.class)).a(this.ooz);
        this.QNH.a(new l()
        {
          public final void cxX()
          {
            AppMethodBeat.i(306907);
            try
            {
              e.a(e.this).sLC.a(e.b(e.this), e.a(e.this).irL());
              AppMethodBeat.o(306907);
              return;
            }
            finally
            {
              Log.e("AdLandingFloatWebView", "bind webview callback failed");
              AppMethodBeat.o(306907);
            }
          }
        });
        this.ooz.setWebChromeClient(new MMWebView.c(new c((Activity)this.context, this.QNH.sLD, this.QNJ)));
        this.QNH.init();
        this.QNH.bJ(localIntent);
        Log.d("AdLandingFloatWebView", "url is ".concat(String.valueOf(str)));
      }
      AppMethodBeat.o(307128);
      return;
    }
    finally
    {
      Log.e("AdLandingFloatWebView", "bind webview callback failed");
      AppMethodBeat.o(307128);
    }
  }
  
  protected final View ham()
  {
    AppMethodBeat.i(307139);
    for (;;)
    {
      try
      {
        this.QNF = new ScrollableLayout(this.context);
        localObject4 = this.QNI.QJm;
        localObject1 = null;
        if (com.tencent.mm.plugin.webview.k.t.bnb((String)localObject4)) {
          localObject1 = MMWebView.a.nK(this.context);
        }
        localObject4 = localObject1;
        if (localObject1 == null) {
          localObject4 = MMWebView.a.nL(this.context);
        }
        this.ooz = ((MMWebView)localObject4);
        localObject1 = new LinearLayout.LayoutParams(-1, -1);
        this.QNG = new Space(this.context);
        this.QNG.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.QNF.addView(this.QNG);
        this.QNJ = new a();
        this.QNF.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.QNF.setDescendantScrollStatusHunter(this);
        this.QNF.setOnScrollStatusListener(this);
        localObject1 = new LinearLayout.LayoutParams(-1, -1);
        localObject4 = this.QNF;
        localMMWebView = this.ooz;
      }
      finally
      {
        Object localObject4;
        Object localObject1;
        MMWebView localMMWebView;
        Log.w("AdLandingFloatWebView", "the customLayout method has something wrong");
        continue;
      }
      try
      {
        ((ScrollableLayout)localObject4).addView(localMMWebView, (ViewGroup.LayoutParams)localObject1);
        ((ScrollableLayout)localObject4).RYj = localMMWebView;
        localObject1 = this.QNF;
        AppMethodBeat.o(307139);
        return localObject1;
      }
      finally
      {
        Log.w("ScrollLinearLayout", "the addView has something wrong!");
      }
    }
  }
  
  public final void has()
  {
    AppMethodBeat.i(307146);
    super.has();
    try
    {
      Log.i("AdLandingFloatWebView", "the view is going to destroy");
      if (this.ooQ != null) {
        this.ooQ.dead();
      }
      if (this.QNH != null) {
        this.QNH.onDestroy();
      }
      if (this.ooz != null) {
        this.ooz.destroy();
      }
      AppMethodBeat.o(307146);
      return;
    }
    finally
    {
      Log.w("AdLandingFloatWebView", "the destroy method has something wrong");
      AppMethodBeat.o(307146);
    }
  }
  
  static final class a
  {
    ValueCallback<Uri> QNU;
    ValueCallback<Uri[]> QNV;
    String QNW;
    String QNX;
  }
  
  final class b
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    b() {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(307008);
      try
      {
        Log.i("AdLandingFloatWebView", "viewTreeObserver OnGlobalLayoutListener is called");
        Object localObject1 = e.this.contentView;
        if ((localObject1 != null) && (((View)localObject1).getViewTreeObserver().isAlive()))
        {
          ((View)localObject1).getViewTreeObserver().removeOnGlobalLayoutListener(this);
          Object localObject3 = ((View)localObject1).getRootView();
          if (localObject3 == null) {}
          for (;;)
          {
            localObject1 = ((View)localObject1).findViewById(b.f.vertical_viewpager);
            if ((!(localObject1 instanceof ViewGroup)) || (((ViewGroup)localObject1).getChildCount() <= 0)) {
              break label156;
            }
            localObject1 = ((ViewGroup)localObject1).getChildAt(0);
            if (localObject1 != null) {
              break;
            }
            return;
            localObject1 = localObject3;
          }
          localObject1 = ((View)localObject1).findViewById(b.f.content_list);
          if (((localObject1 instanceof ViewGroup)) && (((ViewGroup)localObject1).getChildCount() > 0))
          {
            localObject1 = ((ViewGroup)localObject1).getChildAt(0);
            if (localObject1 != null)
            {
              localObject3 = e.this;
              ((View)localObject1).getWidth();
              e.a((e)localObject3, ((View)localObject1).getHeight());
            }
          }
        }
        label156:
        return;
      }
      finally
      {
        AppMethodBeat.o(307008);
      }
    }
  }
  
  static final class c
    extends z
  {
    private Reference<Activity> PUt;
    private final e.a QNJ;
    private g QNY;
    
    protected c(Activity paramActivity, g paramg, e.a parama)
    {
      AppMethodBeat.i(307012);
      this.PUt = new WeakReference(paramActivity);
      this.QNY = paramg;
      this.QNJ = parama;
      AppMethodBeat.o(307012);
    }
    
    public final void a(WebView paramWebView, int paramInt)
    {
      AppMethodBeat.i(307015);
      Log.d("AdLandingFloatWebView", "onProgressChanged %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(307015);
    }
    
    public final boolean a(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, z.a parama)
    {
      Object localObject2 = null;
      Object localObject1 = null;
      AppMethodBeat.i(307034);
      Activity localActivity;
      String str1;
      for (;;)
      {
        try
        {
          localActivity = (Activity)this.PUt.get();
          if (((e.br(localActivity)) && (parama.getMode() == 0)) || (parama.getMode() == 1))
          {
            if ((parama.getAcceptTypes() == null) || (parama.getAcceptTypes().length <= 0))
            {
              Log.i("AdLandingFloatWebView", "onShowFileChooser, mode = MODE_OPEN, but params.getAcceptTypes is null");
              AppMethodBeat.o(307034);
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
              parama = this.QNJ;
              localObject3 = this.QNY;
              if (e.br(localActivity)) {
                continue;
              }
              Log.i("AdLandingFloatWebView", "activity is finished.");
              AppMethodBeat.o(307034);
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
          if (((g)localObject3).iwo().sk(56)) {
            break;
          }
        }
        finally
        {
          Log.e("AdLandingFloatWebView", "onShowFileChooser has something wrong");
          AppMethodBeat.o(307034);
          return false;
        }
        label192:
        Log.e("AdLandingFloatWebView", "open file chooser failed, permission fail");
      }
      parama.QNU = null;
      parama.QNV = paramValueCallback;
      parama.QNW = str1;
      parama.QNX = String.valueOf(System.currentTimeMillis());
      Object localObject3 = e.aZt(paramWebView);
      String str2 = parama.QNX;
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
        paramWebView[0] = com.tencent.mm.plugin.webview.k.i.bkA(str2);
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
            paramValueCallback.putExtra("android.intent.extra.TITLE", MMApplicationContext.getContext().getString(a.e.webview_select_file_alert_title));
            paramValueCallback.putExtra("android.intent.extra.INTENT", parama);
          }
          for (paramWebView = paramValueCallback;; paramWebView = paramWebView[0])
          {
            if (com.tencent.mm.pluginsdk.permission.b.s(localActivity, "android.permission.CAMERA")) {
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
              paramWebView[0] = com.tencent.mm.plugin.webview.k.i.ivA();
              i = 0;
              break label319;
            }
            if ("microphone".equalsIgnoreCase((String)localObject3))
            {
              paramWebView = new Intent[1];
              paramWebView[0] = com.tencent.mm.plugin.webview.k.i.ivB();
              i = 0;
              break label319;
            }
            if ((!"*".equalsIgnoreCase((String)localObject3)) && (!"true".equalsIgnoreCase((String)localObject3)))
            {
              paramValueCallback = localObject2;
              if (!"false".equalsIgnoreCase((String)localObject3)) {
                break label719;
              }
            }
            if (str1.equalsIgnoreCase("image/*"))
            {
              paramWebView = new Intent[1];
              paramWebView[0] = com.tencent.mm.plugin.webview.k.i.bkA(str2);
            }
            for (;;)
            {
              if ("false".equalsIgnoreCase((String)localObject3)) {
                break label727;
              }
              paramValueCallback = paramWebView;
              if (!"*".equalsIgnoreCase((String)localObject3)) {
                break;
              }
              break label727;
              if (str1.equalsIgnoreCase("audio/*"))
              {
                paramWebView = new Intent[1];
                paramWebView[0] = com.tencent.mm.plugin.webview.k.i.ivB();
              }
              else
              {
                paramWebView = localObject1;
                if (str1.equalsIgnoreCase("video/*"))
                {
                  paramWebView = new Intent[1];
                  paramWebView[0] = com.tencent.mm.plugin.webview.k.i.ivA();
                }
              }
            }
            label606:
            paramValueCallback = localObject2;
            if (!d.rc(16)) {
              break label719;
            }
            Log.i("MicroMsg.WebJSSDKUtil", "android API version is below 16.");
            paramWebView = new Intent[1];
            paramWebView[0] = com.tencent.mm.plugin.webview.k.i.bkA(str2);
            i = 0;
            break label319;
          }
          try
          {
            label652:
            com.tencent.mm.hellhoundlib.a.a.a(localActivity, com.tencent.mm.hellhoundlib.b.c.a(2003, new com.tencent.mm.hellhoundlib.b.a()).cG(paramWebView).aYi(), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingFloatWebViewComponent$FileChooser", "doOpenFileChooser", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/webview/permission/WebViewPermission;Landroid/webkit/ValueCallback;Landroid/webkit/ValueCallback;Ljava/lang/String;Ljava/lang/String;)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
          }
          catch (Exception paramWebView)
          {
            Log.e("AdLandingFloatWebView", "openFileChooser e = %s", new Object[] { paramWebView });
          }
        }
        break;
        label719:
        i = 0;
        paramWebView = paramValueCallback;
        continue;
        label727:
        i = 1;
      }
    }
    
    public final boolean a(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
    {
      return false;
    }
    
    public final boolean b(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
    {
      AppMethodBeat.i(307041);
      Log.d("AdLandingFloatWebView", "onJsConfirm");
      boolean bool = super.b(paramWebView, paramString1, paramString2, paramJsResult);
      AppMethodBeat.o(307041);
      return bool;
    }
    
    public final void onGeolocationPermissionsShowPrompt(final String paramString, final GeolocationPermissions.Callback paramCallback)
    {
      AppMethodBeat.i(307020);
      Log.i("AdLandingFloatWebView", "onGeolocationPermissionsShowPrompt, origin = %s", new Object[] { paramString });
      try
      {
        final Activity localActivity = (Activity)this.PUt.get();
        if ((!e.br(localActivity)) || (paramCallback == null))
        {
          Log.w("AdLandingFloatWebView", "the activity is finished.");
          AppMethodBeat.o(307020);
          return;
        }
        if (com.tencent.mm.pluginsdk.permission.b.s(localActivity, "android.permission.ACCESS_FINE_LOCATION"))
        {
          k.a(localActivity, false, localActivity.getString(b.j.webview_get_location_msg, new Object[] { paramString }), localActivity.getString(b.j.webview_get_location_title), localActivity.getString(b.j.app_ok), localActivity.getString(b.j.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(306953);
              Log.i("AdLandingFloatWebView", "onGeolocationPermissionsShowPrompt ok");
              try
              {
                paramCallback.invoke(paramString, true, true);
                ar.bs(localActivity);
                AppMethodBeat.o(306953);
                return;
              }
              finally
              {
                Log.e("AdLandingFloatWebView", "GeolocationPermissions.Callback has something wrong!");
                AppMethodBeat.o(306953);
              }
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(306946);
              Log.i("AdLandingFloatWebView", "onGeolocationPermissionsShowPrompt cancel");
              try
              {
                paramCallback.invoke(paramString, false, false);
                ar.bs(localActivity);
                AppMethodBeat.o(306946);
                return;
              }
              finally
              {
                Log.e("AdLandingFloatWebView", "GeolocationPermissions.Callback has something wrong!");
                AppMethodBeat.o(306946);
              }
            }
          });
          AppMethodBeat.o(307020);
          return;
        }
      }
      finally
      {
        Log.w("AdLandingFloatWebView", "the application has no geo permission.");
        AppMethodBeat.o(307020);
        return;
      }
      Log.w("AdLandingFloatWebView", "the application has no geo permission.");
      AppMethodBeat.o(307020);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e
 * JD-Core Version:    0.7.0.1
 */