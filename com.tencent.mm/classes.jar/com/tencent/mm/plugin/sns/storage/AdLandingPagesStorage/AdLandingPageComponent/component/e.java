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
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.aa;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.vf;
import com.tencent.mm.g.a.vf.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.ad.d.a.a;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.ui.widget.ad.ScrollableLayout;
import com.tencent.mm.plugin.sns.ui.widget.ad.ScrollableLayout.a;
import com.tencent.mm.plugin.sns.ui.widget.ad.ScrollableLayout.b;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.j;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.k.k;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.mm.ui.widget.MMWebView.b;
import com.tencent.mm.vfs.o;
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
  ScrollableLayout EbX;
  View EbY;
  BaseWebViewController EbZ;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e Eca;
  a Ecb;
  private boolean Ecc;
  com.tencent.mm.plugin.webview.stub.b Ecd;
  MMWebView iGY;
  private IListener<vf> iHq;
  
  public e(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e parame, ViewGroup paramViewGroup)
  {
    super(paramContext, parame, paramViewGroup);
    AppMethodBeat.i(202853);
    this.Ecc = false;
    this.Ecd = new com.tencent.mm.plugin.webview.stub.b()
    {
      public final boolean a(final String paramAnonymousString1, final String paramAnonymousString2, final Bundle paramAnonymousBundle, final boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(202838);
        Object localObject = e.this.EbZ;
        if (localObject == null)
        {
          AppMethodBeat.o(202838);
          return false;
        }
        try
        {
          localObject = ((BaseWebViewController)localObject).getJsapi();
          com.tencent.f.h.RTc.aV(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(202834);
              try
              {
                if (this.Ecf != null) {
                  this.Ecf.a(paramAnonymousString1, paramAnonymousString2, n.aN(paramAnonymousBundle), paramAnonymousBoolean);
                }
                AppMethodBeat.o(202834);
                return;
              }
              catch (Throwable localThrowable)
              {
                Log.e("AdLandingFloatWebView", "In jsapi onHandleEnd method, it happens something unwanted!");
                AppMethodBeat.o(202834);
              }
            }
          });
          AppMethodBeat.o(202838);
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
      
      public final String ePp()
      {
        AppMethodBeat.i(202837);
        try
        {
          Object localObject = e.this.EbZ;
          if (localObject != null)
          {
            localObject = ((BaseWebViewController)localObject).IJP;
            AppMethodBeat.o(202837);
            return localObject;
          }
        }
        catch (Throwable localThrowable)
        {
          Log.e("AdLandingFloatWebView", "callback: getCommitUrl failed");
          AppMethodBeat.o(202837);
        }
        return "";
      }
      
      public final boolean f(int paramAnonymousInt, final Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(202840);
        try
        {
          Object localObject = e.this.EbZ;
          if (localObject == null)
          {
            AppMethodBeat.o(202840);
            return true;
          }
          final com.tencent.mm.plugin.webview.d.h localh = ((BaseWebViewController)localObject).getJsapi();
          localObject = ((BaseWebViewController)localObject).mHi;
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(202840);
            return true;
            com.tencent.f.h.RTc.aV(new Runnable()
            {
              public final void run()
              {
                boolean bool = true;
                AppMethodBeat.i(202835);
                try
                {
                  if ((!paramAnonymousBundle.containsKey("jsapi_preverify_fun_list")) || (this.Ecl == null)) {
                    if (this.Ecl != null) {
                      Log.e("AdLandingFloatWebView", "has JSAPI_CONTROL_BYTES wvPerm %b", new Object[] { Boolean.valueOf(bool) });
                    }
                  }
                  for (;;)
                  {
                    localh.gaY();
                    AppMethodBeat.o(202835);
                    return;
                    bool = false;
                    break;
                    this.Ecl.aR(paramAnonymousBundle);
                  }
                  return;
                }
                catch (Throwable localThrowable)
                {
                  Log.e("AdLandingFloatWebView", "In onCallback method, it happens something unwanted!");
                  AppMethodBeat.o(202835);
                }
              }
            });
          }
          return true;
        }
        catch (Throwable paramAnonymousBundle)
        {
          Log.e("AdLandingFloatWebView", "In callback method, it happens something unwanted!");
          AppMethodBeat.o(202840);
        }
      }
      
      public final String getCurrentUrl()
      {
        AppMethodBeat.i(202836);
        try
        {
          Object localObject = e.this.EbZ;
          if (localObject != null)
          {
            localObject = ((BaseWebViewController)localObject).getCurrentUrl();
            AppMethodBeat.o(202836);
            return localObject;
          }
        }
        catch (Throwable localThrowable)
        {
          Log.e("AdLandingFloatWebView", "callback: getCurrentUrl failed");
          AppMethodBeat.o(202836);
        }
        return "";
      }
      
      public final Bundle j(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(202839);
        Bundle localBundle = new Bundle();
        Object localObject = e.this.context;
        switch (paramAnonymousInt)
        {
        }
        do
        {
          AppMethodBeat.o(202839);
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
      this.Eca = parame;
      if (this.iHq == null)
      {
        this.iHq = new IListener()
        {
          private boolean a(vf paramAnonymousvf)
          {
            AppMethodBeat.i(202843);
            for (;;)
            {
              try
              {
                localObject1 = e.this;
                if (paramAnonymousvf != null)
                {
                  i = paramAnonymousvf.ebD.EX;
                  if ((i != 0) && (i == 1))
                  {
                    i = paramAnonymousvf.ebD.requestCode;
                    j = paramAnonymousvf.ebD.resultCode;
                    localIntent = paramAnonymousvf.ebD.dQs;
                    if (i == 2003)
                    {
                      locala = ((e)localObject1).Ecb;
                      if (locala != null)
                      {
                        localObject1 = (Activity)((e)localObject1).context;
                        if (i == 2003)
                        {
                          if ((locala.Ecm != null) || (locala.Ecn != null)) {
                            continue;
                          }
                          Log.w("AdLandingFloatWebView", "uploadFileCallback is null.");
                        }
                      }
                    }
                  }
                }
              }
              catch (Throwable paramAnonymousvf)
              {
                Object localObject1;
                Intent localIntent;
                e.a locala;
                Log.w("AdLandingFloatWebView", "resizing layout has wrong!");
                continue;
                paramAnonymousvf = null;
                continue;
                paramAnonymousvf = localIntent.getData();
                continue;
                paramAnonymousvf = Util.getFilePath((Context)localObject1, paramAnonymousvf);
                Log.i("AdLandingFloatWebView", "get file path:[%s]", new Object[] { paramAnonymousvf });
                if (Util.isNullOrNil(paramAnonymousvf)) {
                  continue;
                }
                Object localObject2 = z.getMimeTypeByFilePath(paramAnonymousvf);
                Log.d("AdLandingFloatWebView", "get file mime type [%s]", new Object[] { localObject2 });
                if (!Util.isNullOrNil(locala.Eco)) {
                  continue;
                }
                int i = 1;
                if (i == 0) {
                  continue;
                }
                if (localIntent.getData() != null) {
                  continue;
                }
                paramAnonymousvf = FileProviderHelper.getUriForFile((Context)localObject1, new o(paramAnonymousvf));
                continue;
                String[] arrayOfString1 = locala.Eco.split(",");
                int j = arrayOfString1.length;
                i = 0;
                if (i >= j) {
                  continue;
                }
                Object localObject3 = arrayOfString1[i].replace(" ", "");
                if (!Util.isNullOrNil((String)localObject3)) {
                  continue;
                }
                boolean bool = true;
                continue;
                if (Util.isNullOrNil((String)localObject2)) {
                  continue;
                }
                if ((((String)localObject3).contains("/")) && (((String)localObject2).contains("/"))) {
                  continue;
                }
                bool = ((String)localObject3).equals(localObject2);
                continue;
                localObject3 = ((String)localObject3).split("/");
                String[] arrayOfString2 = ((String)localObject2).split("/");
                if (!Util.nullAsNil(localObject3[0]).equals(arrayOfString2[0])) {
                  continue;
                }
                if (Util.nullAsNil(localObject3[1]).equals("*")) {
                  continue;
                }
                if (!Util.nullAsNil(localObject3[1]).equals(arrayOfString2[1])) {
                  continue;
                }
                continue;
                paramAnonymousvf = localIntent.getData();
                continue;
                paramAnonymousvf = new o(com.tencent.mm.plugin.webview.k.d.aYW(locala.Ecp));
                if (!paramAnonymousvf.exists()) {
                  continue;
                }
                paramAnonymousvf = FileProviderHelper.getUriForFile((Context)localObject1, paramAnonymousvf);
                continue;
                if (locala.Ecn == null) {
                  continue;
                }
                if (paramAnonymousvf != null) {
                  continue;
                }
                locala.Ecn.onReceiveValue(null);
                continue;
                locala.Ecn.onReceiveValue(new Uri[] { paramAnonymousvf });
                continue;
                paramAnonymousvf = null;
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
                paramAnonymousvf = null;
                continue;
              }
              AppMethodBeat.o(202843);
              return true;
              if (j != -1) {
                continue;
              }
              if (localIntent == null) {
                continue;
              }
              paramAnonymousvf = null;
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
              paramAnonymousvf = (Uri)((Bundle)localObject2).getParcelable("android.intent.extra.STREAM");
              continue;
              if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rSV, 1) != 1) || (paramAnonymousvf == null)) {
                continue;
              }
              Log.i("AdLandingFloatWebView", "result = ".concat(String.valueOf(paramAnonymousvf)));
              if (locala.Ecm == null) {
                continue;
              }
              locala.Ecm.onReceiveValue(paramAnonymousvf);
            }
          }
        };
        this.iHq.alive();
      }
      AppMethodBeat.o(202853);
      return;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(202853);
    }
  }
  
  static boolean aJ(Activity paramActivity)
  {
    AppMethodBeat.i(202859);
    if ((paramActivity != null) && (!paramActivity.isFinishing()) && (!paramActivity.isDestroyed()))
    {
      AppMethodBeat.o(202859);
      return true;
    }
    AppMethodBeat.o(202859);
    return false;
  }
  
  private String aPV(String paramString)
  {
    AppMethodBeat.i(202861);
    localObject1 = paramString;
    try
    {
      ah localah = fds();
      localObject2 = paramString;
      if (localah != null)
      {
        localObject2 = paramString;
        localObject1 = paramString;
        if (!TextUtils.isEmpty(paramString))
        {
          localObject1 = paramString;
          localObject2 = localah.DZW;
          Object localObject3 = localObject2;
          localObject1 = paramString;
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = paramString;
            localObject3 = localah.uxInfo;
          }
          localObject2 = paramString;
          localObject1 = paramString;
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            localObject1 = paramString;
            localObject2 = r.kb(paramString, (String)localObject3);
          }
          localObject1 = localObject2;
          localObject2 = a.aND((String)localObject2);
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
    AppMethodBeat.o(202861);
    return localObject2;
  }
  
  final int YT(int paramInt)
  {
    AppMethodBeat.i(202860);
    try
    {
      int j = ap.ha(this.context)[1];
      i = paramInt;
      if (paramInt == j)
      {
        i = paramInt;
        if (ao.aQ(this.context))
        {
          i = ao.aP(this.context);
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
    AppMethodBeat.o(202860);
    return i;
  }
  
  public final void aS(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(202858);
    if (paramInt == 0) {}
    try
    {
      android.support.v4.content.d locald = android.support.v4.content.d.W(this.context);
      Intent localIntent = new Intent("com.tencent.mm.adlanding.video.action.PAUSE_OR_RESUME");
      if (paramBoolean) {}
      for (paramInt = 1;; paramInt = 2)
      {
        localIntent.putExtra("TRY_PAUSE_OR_RESUME", paramInt);
        localIntent.putExtra("identity", this.context.hashCode());
        locald.b(localIntent);
        AppMethodBeat.o(202858);
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.w("AdLandingFloatWebView", "onScrollChanged method has something wrong");
      AppMethodBeat.o(202858);
    }
  }
  
  protected final void eWT()
  {
    AppMethodBeat.i(202854);
    try
    {
      if (this.EbZ == null)
      {
        String str = aPV(this.Eca.DXV);
        Intent localIntent = new Intent();
        localIntent.putExtra("rawUrl", str);
        localIntent.putExtra("useJs", true);
        localIntent.putExtra("type", -255);
        localIntent.putExtra("geta8key_scene", 2);
        this.EbZ = ((aa)com.tencent.mm.kernel.g.af(aa.class)).a(this.iGY);
        this.EbZ.a(new j()
        {
          public final void ePr()
          {
            AppMethodBeat.i(202841);
            try
            {
              e.this.EbZ.mHh.a(e.this.Ecd, e.this.EbZ.fZu());
              AppMethodBeat.o(202841);
              return;
            }
            catch (Throwable localThrowable)
            {
              Log.e("AdLandingFloatWebView", "bind webview callback failed");
              AppMethodBeat.o(202841);
            }
          }
        });
        this.iGY.setWebChromeClient(new MMWebView.b(new c((Activity)this.context, this.EbZ.mHi, this.Ecb)));
        this.EbZ.init();
        this.EbZ.aB(localIntent);
        Log.d("AdLandingFloatWebView", "url is ".concat(String.valueOf(str)));
      }
      AppMethodBeat.o(202854);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("AdLandingFloatWebView", "bind webview callback failed");
      AppMethodBeat.o(202854);
    }
  }
  
  protected final View eWY()
  {
    AppMethodBeat.i(202856);
    for (;;)
    {
      try
      {
        this.EbX = new ScrollableLayout(this.context);
        localObject2 = this.Eca.DXV;
        localObject1 = null;
        if (k.bbp((String)localObject2)) {
          localObject1 = MMWebView.a.kK(this.context);
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = MMWebView.a.kL(this.context);
        }
        this.iGY = ((MMWebView)localObject2);
        localObject1 = new LinearLayout.LayoutParams(-1, -1);
        this.EbY = new Space(this.context);
        this.EbY.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.EbX.addView(this.EbY);
        this.Ecb = new a();
        this.EbX.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.EbX.setDescendantScrollStatusHunter(this);
        this.EbX.setOnScrollStatusListener(this);
        localObject1 = new LinearLayout.LayoutParams(-1, -1);
        localObject2 = this.EbX;
        localMMWebView = this.iGY;
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
        ((ScrollableLayout)localObject2).Fgd = localMMWebView;
        localObject1 = this.EbX;
        AppMethodBeat.o(202856);
        return localObject1;
      }
      catch (Throwable localThrowable1)
      {
        Log.w("ScrollLinearLayout", "the addView has something wrong!");
      }
    }
  }
  
  public final void eXd()
  {
    AppMethodBeat.i(202857);
    super.eXd();
    try
    {
      Log.i("AdLandingFloatWebView", "the view is going to destroy");
      if (this.iHq != null) {
        this.iHq.dead();
      }
      if (this.EbZ != null) {
        this.EbZ.onDestroy();
      }
      if (this.iGY != null) {
        this.iGY.destroy();
      }
      AppMethodBeat.o(202857);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.w("AdLandingFloatWebView", "the destroy method has something wrong");
      AppMethodBeat.o(202857);
    }
  }
  
  public final void eXe()
  {
    AppMethodBeat.i(202855);
    super.eXe();
    if (!this.Ecc)
    {
      this.Ecc = true;
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
        AppMethodBeat.o(202855);
        return;
      }
      catch (Throwable localThrowable) {}
    }
    AppMethodBeat.o(202855);
  }
  
  static final class a
  {
    ValueCallback<Uri> Ecm;
    ValueCallback<Uri[]> Ecn;
    String Eco;
    String Ecp;
  }
  
  final class b
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    b() {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(202845);
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
            localObject1 = ((View)localObject1).findViewById(2131309711);
            if ((!(localObject1 instanceof ViewGroup)) || (((ViewGroup)localObject1).getChildCount() <= 0)) {
              break label334;
            }
            localObject1 = ((ViewGroup)localObject1).getChildAt(0);
            if (localObject1 != null) {
              break;
            }
            AppMethodBeat.o(202845);
            return;
            localObject1 = localObject2;
          }
          localObject1 = ((View)localObject1).findViewById(2131299207);
          if (((localObject1 instanceof ViewGroup)) && (((ViewGroup)localObject1).getChildCount() > 0))
          {
            localObject2 = ((ViewGroup)localObject1).getChildAt(0);
            if (localObject2 != null)
            {
              localObject1 = e.this;
              ((View)localObject2).getWidth();
              int i = ((View)localObject2).getHeight();
              if ((((e)localObject1).EbY != null) && (((e)localObject1).EbX != null) && (((e)localObject1).iGY != null))
              {
                Log.d("AdLandingFloatWebView", "on event center information: the  height is ".concat(String.valueOf(i)));
                Log.d("AdLandingFloatWebView", "on event center information: the  height of mPlaceHolderView is " + ((e)localObject1).EbY.getHeight());
                Log.d("AdLandingFloatWebView", "on event center information: the  height of mScrollableLayout is " + ((e)localObject1).EbX.getHeight());
                Log.d("AdLandingFloatWebView", "on event center information: the  height of mWebView is " + ((e)localObject1).iGY.getHeight());
                localObject2 = ((e)localObject1).EbY.getLayoutParams();
                ((ViewGroup.LayoutParams)localObject2).height = i;
                ((e)localObject1).EbY.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                localObject2 = ((e)localObject1).iGY.getLayoutParams();
                ((ViewGroup.LayoutParams)localObject2).height = ((e)localObject1).YT(((e)localObject1).EbX.getHeight());
                ((e)localObject1).iGY.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                ((e)localObject1).EbX.setMaxYScrollOffset(i);
                ((e)localObject1).EbX.requestLayout();
              }
            }
          }
        }
        label334:
        AppMethodBeat.o(202845);
        return;
      }
      catch (Throwable localThrowable)
      {
        AppMethodBeat.o(202845);
      }
    }
  }
  
  static final class c
    extends x
  {
    private Reference<Activity> Duf;
    private final e.a Ecb;
    private com.tencent.mm.plugin.webview.f.g Ecq;
    
    protected c(Activity paramActivity, com.tencent.mm.plugin.webview.f.g paramg, e.a parama)
    {
      AppMethodBeat.i(202848);
      this.Duf = new WeakReference(paramActivity);
      this.Ecq = paramg;
      this.Ecb = parama;
      AppMethodBeat.o(202848);
    }
    
    public final void a(WebView paramWebView, int paramInt)
    {
      AppMethodBeat.i(202849);
      Log.d("AdLandingFloatWebView", "onProgressChanged %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(202849);
    }
    
    public final boolean a(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, x.a parama)
    {
      Object localObject2 = null;
      Object localObject1 = null;
      AppMethodBeat.i(202851);
      Activity localActivity;
      String str1;
      Object localObject3;
      for (;;)
      {
        try
        {
          localActivity = (Activity)this.Duf.get();
          if (((e.aJ(localActivity)) && (parama.getMode() == 0)) || (parama.getMode() == 1))
          {
            if ((parama.getAcceptTypes() == null) || (parama.getAcceptTypes().length <= 0))
            {
              Log.i("AdLandingFloatWebView", "onShowFileChooser, mode = MODE_OPEN, but params.getAcceptTypes is null");
              AppMethodBeat.o(202851);
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
              localObject3 = this.Ecb;
              parama = this.Ecq;
              if (e.aJ(localActivity)) {
                continue;
              }
              Log.i("AdLandingFloatWebView", "activity is finished.");
              AppMethodBeat.o(202851);
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
            Log.e("AdLandingFloatWebView", "openFileChooser fail, wvPerm is null");
            continue;
          }
          if (parama.gdH().pP(56)) {
            break;
          }
        }
        catch (Throwable paramWebView)
        {
          Log.e("AdLandingFloatWebView", "onShowFileChooser has something wrong");
          AppMethodBeat.o(202851);
          return false;
        }
        label191:
        Log.e("AdLandingFloatWebView", "open file chooser failed, permission fail");
      }
      ((e.a)localObject3).Ecm = null;
      ((e.a)localObject3).Ecn = paramValueCallback;
      ((e.a)localObject3).Eco = str1;
      ((e.a)localObject3).Ecp = String.valueOf(System.currentTimeMillis());
      label266:
      String str2;
      label308:
      int i;
      if (!"user".equalsIgnoreCase(paramWebView))
      {
        parama = paramWebView;
        if (!"environment".equalsIgnoreCase(paramWebView))
        {
          str2 = ((e.a)localObject3).Ecp;
          localObject3 = new Intent("android.intent.action.GET_CONTENT");
          ((Intent)localObject3).addCategory("android.intent.category.OPENABLE");
          if (Util.isNullOrNil(str1))
          {
            ((Intent)localObject3).setType("*/*");
            if (Util.isNullOrNil(parama)) {
              break label620;
            }
            if (!"camera".equalsIgnoreCase(parama)) {
              break label438;
            }
            paramWebView = new Intent[1];
            paramWebView[0] = com.tencent.mm.plugin.webview.k.d.aYX(str2);
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
            paramValueCallback.putExtra("android.intent.extra.TITLE", MMApplicationContext.getContext().getString(2131768609));
            paramValueCallback.putExtra("android.intent.extra.INTENT", (Parcelable)localObject3);
          }
          for (paramWebView = paramValueCallback;; paramWebView = paramWebView[0])
          {
            if (com.tencent.mm.pluginsdk.permission.b.n(localActivity, "android.permission.CAMERA")) {
              break label666;
            }
            com.tencent.mm.pluginsdk.permission.b.b(localActivity, "android.permission.CAMERA", 119);
            Log.e("AdLandingFloatWebView", "openFileChooser no Permission");
            break;
            ((Intent)localObject3).setType(str1);
            break label308;
            label438:
            if ("camcorder".equalsIgnoreCase(parama))
            {
              paramWebView = new Intent[1];
              paramWebView[0] = com.tencent.mm.plugin.webview.k.d.gcV();
              i = 0;
              break label340;
            }
            if ("microphone".equalsIgnoreCase(parama))
            {
              paramWebView = new Intent[1];
              paramWebView[0] = com.tencent.mm.plugin.webview.k.d.gcW();
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
              paramWebView[0] = com.tencent.mm.plugin.webview.k.d.aYX(str2);
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
                paramWebView[0] = com.tencent.mm.plugin.webview.k.d.gcW();
              }
              else
              {
                paramWebView = localObject1;
                if (str1.equalsIgnoreCase("video/*"))
                {
                  paramWebView = new Intent[1];
                  paramWebView[0] = com.tencent.mm.plugin.webview.k.d.gcV();
                }
              }
            }
            label620:
            paramValueCallback = localObject2;
            if (!com.tencent.mm.compatible.util.d.oE(16)) {
              break label698;
            }
            Log.i("MicroMsg.WebJSSDKUtil", "android API version is below 16.");
            paramWebView = new Intent[1];
            paramWebView[0] = com.tencent.mm.plugin.webview.k.d.aYX(str2);
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
            Log.e("AdLandingFloatWebView", "openFileChooser e = %s", new Object[] { paramWebView });
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
      AppMethodBeat.i(202852);
      Log.d("AdLandingFloatWebView", "onJsConfirm");
      boolean bool = super.b(paramWebView, paramString1, paramString2, paramJsResult);
      AppMethodBeat.o(202852);
      return bool;
    }
    
    public final void onGeolocationPermissionsShowPrompt(final String paramString, final GeolocationPermissions.Callback paramCallback)
    {
      AppMethodBeat.i(202850);
      Log.i("AdLandingFloatWebView", "onGeolocationPermissionsShowPrompt, origin = %s", new Object[] { paramString });
      try
      {
        final Activity localActivity = (Activity)this.Duf.get();
        if ((!e.aJ(localActivity)) || (paramCallback == null))
        {
          Log.w("AdLandingFloatWebView", "the activity is finished.");
          AppMethodBeat.o(202850);
          return;
        }
        if (com.tencent.mm.pluginsdk.permission.b.n(localActivity, "android.permission.ACCESS_FINE_LOCATION"))
        {
          com.tencent.mm.ui.base.h.a(localActivity, false, localActivity.getString(2131768562, new Object[] { paramString }), localActivity.getString(2131768563), localActivity.getString(2131755921), localActivity.getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(202846);
              Log.i("AdLandingFloatWebView", "onGeolocationPermissionsShowPrompt ok");
              try
              {
                paramCallback.invoke(paramString, true, true);
                ap.aK(localActivity);
                AppMethodBeat.o(202846);
                return;
              }
              catch (Throwable paramAnonymousDialogInterface)
              {
                Log.e("AdLandingFloatWebView", "GeolocationPermissions.Callback has something wrong!");
                AppMethodBeat.o(202846);
              }
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(202847);
              Log.i("AdLandingFloatWebView", "onGeolocationPermissionsShowPrompt cancel");
              try
              {
                paramCallback.invoke(paramString, false, false);
                ap.aK(localActivity);
                AppMethodBeat.o(202847);
                return;
              }
              catch (Throwable paramAnonymousDialogInterface)
              {
                Log.e("AdLandingFloatWebView", "GeolocationPermissions.Callback has something wrong!");
                AppMethodBeat.o(202847);
              }
            }
          });
          AppMethodBeat.o(202850);
          return;
        }
      }
      catch (Throwable paramString)
      {
        Log.w("AdLandingFloatWebView", "the application has no geo permission.");
        AppMethodBeat.o(202850);
        return;
      }
      Log.w("AdLandingFloatWebView", "the application has no geo permission.");
      AppMethodBeat.o(202850);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e
 * JD-Core Version:    0.7.0.1
 */