package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.ba.a.a;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.e.g;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.protocal.protobuf.ddx;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.ah.d;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/widget/PreloadWebViewStubCallback;", "Lcom/tencent/mm/plugin/webview/stub/DefaultWebViewStubCallback;", "controller", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "(Ljava/lang/ref/WeakReference;)V", "bounceBackgroundColor", "", "getBounceBackgroundColor", "()I", "setBounceBackgroundColor", "(I)V", "context", "Landroid/content/Context;", "getController", "()Ljava/lang/ref/WeakReference;", "disableBounceScroll", "", "getDisableBounceScroll", "()Z", "setDisableBounceScroll", "(Z)V", "jsContext", "Lcom/tencent/mm/plugin/webview/core/IWebViewJsApiContext;", "setNavigationBarColorBundle", "Landroid/os/Bundle;", "getSetNavigationBarColorBundle", "()Landroid/os/Bundle;", "setSetNavigationBarColorBundle", "(Landroid/os/Bundle;)V", "attachContext", "", "attachJsContext", "callback", "actionCode", "data", "closeWindow", "bundle", "getCommitUrl", "", "getCurrentUrl", "invokeAsResult", "onHandleEnd", "callbackId", "ret", "retData", "dealNext", "setFontSizeCb", "fontSize", "Companion", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class s
  extends com.tencent.mm.plugin.webview.stub.b
{
  public static final a Xrr;
  private final WeakReference<BaseWebViewController> Wzi;
  WeakReference<com.tencent.mm.plugin.webview.core.b> Xrs;
  Bundle Xrt;
  boolean Xru;
  int Xrv;
  WeakReference<Context> context;
  
  static
  {
    AppMethodBeat.i(297982);
    Xrr = new a((byte)0);
    AppMethodBeat.o(297982);
  }
  
  public s(WeakReference<BaseWebViewController> paramWeakReference)
  {
    AppMethodBeat.i(297970);
    this.Wzi = paramWeakReference;
    this.Xrv = MMApplicationContext.getContext().getResources().getColor(a.a.webview_logo_bg_color);
    AppMethodBeat.o(297970);
  }
  
  private static final void a(com.tencent.mm.plugin.webview.jsapi.j paramj, String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(297975);
    if (paramj != null) {
      try
      {
        paramj.a(paramString1, paramString2, p.bm(paramBundle), paramBoolean);
        AppMethodBeat.o(297975);
        return;
      }
      finally
      {
        Log.e("MicroMsg.PreloadWebViewStubCallback", "In jsapi onHandleEnd method, it happens something unwanted!");
      }
    }
    AppMethodBeat.o(297975);
  }
  
  private static final void a(s params, Bundle paramBundle, com.tencent.mm.plugin.webview.jsapi.j paramj)
  {
    AppMethodBeat.i(297980);
    kotlin.g.b.s.u(params, "this$0");
    for (;;)
    {
      int i;
      try
      {
        params = (BaseWebViewController)params.Wzi.get();
        if (params == null)
        {
          params = null;
          if ((paramBundle == null) || (paramBundle.containsKey("jsapi_preverify_fun_list") != true)) {
            break label132;
          }
          i = 1;
          break label121;
          if (params == null) {
            break label137;
          }
          bool = true;
          Log.e("MicroMsg.PreloadWebViewStubCallback", "has JSAPI_CONTROL_BYTES wvPerm %b", new Object[] { Boolean.valueOf(bool) });
          if (paramj != null)
          {
            paramj.itz();
            AppMethodBeat.o(297980);
          }
        }
        else
        {
          params = params.sLD;
          continue;
          params.br(paramBundle);
          continue;
        }
        if (i == 0) {
          continue;
        }
      }
      catch (Exception params)
      {
        Log.e("MicroMsg.PreloadWebViewStubCallback", kotlin.g.b.s.X("stubCallback.callback(AC_ON_UPDATE_JSAPI_CONTROL_BYTES), exception:", params));
        AppMethodBeat.o(297980);
        return;
      }
      for (;;)
      {
        label121:
        if (params != null) {
          break label135;
        }
        break;
        label132:
        i = 0;
      }
      label135:
      continue;
      label137:
      boolean bool = false;
    }
  }
  
  public final boolean a(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(298009);
    Log.v("MicroMsg.PreloadWebViewStubCallback", "getCurrentUrl");
    for (;;)
    {
      try
      {
        localObject = (BaseWebViewController)this.Wzi.get();
        if (localObject != null) {
          continue;
        }
        localObject = null;
        h.ahAA.bk(new s..ExternalSyntheticLambda0((com.tencent.mm.plugin.webview.jsapi.j)localObject, paramString1, paramString2, paramBundle, paramBoolean));
      }
      finally
      {
        Object localObject;
        Log.e("MicroMsg.PreloadWebViewStubCallback", "In onHandleEnd method, it happens something unwanted!");
        continue;
      }
      AppMethodBeat.o(298009);
      return false;
      localObject = ((BaseWebViewController)localObject).getJsapi();
    }
  }
  
  public final void aF(Bundle paramBundle)
  {
    AppMethodBeat.i(298006);
    paramBundle = this.Xrs;
    if (paramBundle != null)
    {
      paramBundle = (com.tencent.mm.plugin.webview.core.b)paramBundle.get();
      if (paramBundle != null) {
        paramBundle.isg();
      }
    }
    AppMethodBeat.o(298006);
  }
  
  public final void bif(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(298016);
    final ah.d locald = new ah.d();
    try
    {
      int j = Util.getInt(paramString, 0);
      i = j;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.PreloadWebViewStubCallback", kotlin.g.b.s.X("setFontSizeCb, ex = ", paramString.getMessage()));
      }
    }
    locald.aixb = i;
    d.uiThread((a)new b(this, locald));
    AppMethodBeat.o(298016);
  }
  
  public final String cxY()
  {
    AppMethodBeat.i(297999);
    Log.v("MicroMsg.PreloadWebViewStubCallback", "getCommitUrl");
    try
    {
      Object localObject = (BaseWebViewController)this.Wzi.get();
      if (localObject == null)
      {
        AppMethodBeat.o(297999);
        return "";
      }
      localObject = ((BaseWebViewController)localObject).Wwz;
      if (localObject == null)
      {
        AppMethodBeat.o(297999);
        return "";
      }
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.PreloadWebViewStubCallback", localThrowable, "getCommitUrl exception", new Object[0]);
      AppMethodBeat.o(297999);
      return "";
    }
    AppMethodBeat.o(297999);
    return localThrowable;
  }
  
  public final String getCurrentUrl()
  {
    AppMethodBeat.i(298004);
    Log.v("MicroMsg.PreloadWebViewStubCallback", "getCurrentUrl");
    try
    {
      Object localObject = (BaseWebViewController)this.Wzi.get();
      if (localObject == null)
      {
        AppMethodBeat.o(298004);
        return "";
      }
      localObject = ((BaseWebViewController)localObject).getCurrentUrl();
      if (localObject == null)
      {
        AppMethodBeat.o(298004);
        return "";
      }
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.PreloadWebViewStubCallback", localThrowable, "getCommitUrl exception", new Object[0]);
      AppMethodBeat.o(298004);
      return "";
    }
    AppMethodBeat.o(298004);
    return localThrowable;
  }
  
  public boolean i(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(298025);
    Object localObject1 = (BaseWebViewController)this.Wzi.get();
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((BaseWebViewController)localObject1).getJsapi()) {
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(298025);
        return true;
      }
    }
    if (localObject1 != null) {}
    for (;;)
    {
      LinkedList localLinkedList;
      String str1;
      String str2;
      Object localObject2;
      try
      {
        localLinkedList = new LinkedList();
        if (paramBundle == null)
        {
          str1 = null;
          if (str1 != null) {
            break label307;
          }
          AppMethodBeat.o(298025);
          return false;
        }
        str1 = paramBundle.getString("__appId");
        continue;
        if (str2 == null)
        {
          AppMethodBeat.o(298025);
          return false;
          str2 = paramBundle.getString("__url");
          continue;
        }
        if (paramBundle.containsKey("__webComptList")) {
          if (paramBundle == null)
          {
            localObject2 = null;
            if (localObject2 == null) {
              break label263;
            }
            localObject2 = ((Iterable)localObject2).iterator();
            if (!((Iterator)localObject2).hasNext()) {
              break label263;
            }
            String str3 = (String)((Iterator)localObject2).next();
            ddx localddx = new ddx();
            localddx.parseFrom(paramBundle.getByteArray(str3));
            localLinkedList.add(localddx);
            continue;
            AppMethodBeat.o(298025);
          }
        }
      }
      catch (IOException paramBundle)
      {
        Log.printErrStackTrace("MicroMsg.PreloadWebViewStubCallback", (Throwable)paramBundle, "parse webCompt", new Object[0]);
      }
      for (;;)
      {
        return true;
        localObject2 = paramBundle.getStringArrayList("__webComptList");
        break;
        label263:
        paramBundle = ((com.tencent.mm.plugin.webview.jsapi.j)localObject1).itJ();
        if (paramBundle != null) {
          paramBundle.c(str1, str2, localLinkedList);
        }
      }
      h.ahAA.bk(new s..ExternalSyntheticLambda1(this, paramBundle, (com.tencent.mm.plugin.webview.jsapi.j)localObject1));
      break;
      label307:
      if (paramBundle == null) {
        str2 = null;
      }
    }
  }
  
  public final WeakReference<BaseWebViewController> iCz()
  {
    return this.Wzi;
  }
  
  public Bundle m(int paramInt, Bundle paramBundle)
  {
    Object localObject2 = null;
    Context localContext = null;
    AppMethodBeat.i(298031);
    Log.d("MicroMsg.PreloadWebViewStubCallback", kotlin.g.b.s.X("invokeAsResult actionCode=", Integer.valueOf(paramInt)));
    Bundle localBundle = new Bundle();
    switch (paramInt)
    {
    }
    label429:
    label477:
    label480:
    for (;;)
    {
      AppMethodBeat.o(298031);
      return localBundle;
      try
      {
        localObject2 = this.context;
        if (localObject2 == null) {}
        while (localContext == null)
        {
          AppMethodBeat.o(298031);
          return localBundle;
          localContext = (Context)((WeakReference)localObject2).get();
        }
        if (paramBundle == null) {
          continue;
        }
        paramBundle.setClassLoader(localContext.getClassLoader());
        localObject2 = paramBundle.getBundle("open_ui_with_webview_ui_extras");
        String str1 = IntentUtil.getString(paramBundle, "open_ui_with_webview_ui_plugin_name");
        String str2 = IntentUtil.getString(paramBundle, "open_ui_with_webview_ui_plugin_entry");
        Intent localIntent = new Intent();
        paramBundle = (Bundle)localObject2;
        if (localObject2 == null) {
          paramBundle = new Bundle();
        }
        c.b(localContext, str1, str2, localIntent.putExtras(paramBundle));
        continue;
      }
      finally
      {
        Log.e("MicroMsg.PreloadWebViewStubCallback", "In invokeAsResult method, it happens something unwanted!");
      }
      continue;
      if (paramBundle == null) {}
      for (paramBundle = (Bundle)localObject2; paramBundle == null; paramBundle = paramBundle.getString("key_set_bounce_background_color"))
      {
        AppMethodBeat.o(298031);
        return localBundle;
      }
      try
      {
        paramInt = Color.parseColor(paramBundle);
        this.Xrv = paramInt;
        paramBundle = this.Xrs;
        if (paramBundle == null) {
          continue;
        }
        paramBundle = (com.tencent.mm.plugin.webview.core.b)paramBundle.get();
        if (paramBundle == null) {
          continue;
        }
        paramBundle.atr(paramInt);
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.PreloadWebViewStubCallback", "Failed to parse color: %s", new Object[] { paramBundle });
        AppMethodBeat.o(298031);
        return localBundle;
      }
      this.Xrt = paramBundle;
      Object localObject1 = this.Xrs;
      if (localObject1 != null)
      {
        localObject1 = (com.tencent.mm.plugin.webview.core.b)((WeakReference)localObject1).get();
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.webview.core.b)localObject1).bl(paramBundle);
          continue;
          kotlin.g.b.s.checkNotNull(paramBundle);
          if (paramBundle.getInt("webview_disable_bounce_scroll_top", 0) <= 0)
          {
            AppMethodBeat.o(298031);
            return null;
          }
          this.Xru = true;
          paramBundle = this.Xrs;
          if (paramBundle != null)
          {
            paramBundle = (com.tencent.mm.plugin.webview.core.b)paramBundle.get();
            if (paramBundle != null)
            {
              paramBundle.ish();
              continue;
              paramBundle = this.context;
              if (paramBundle == null)
              {
                paramBundle = null;
                if (!(paramBundle instanceof Activity)) {
                  break label477;
                }
              }
              for (paramBundle = (Activity)paramBundle;; paramBundle = null)
              {
                if (paramBundle == null) {
                  break label480;
                }
                localBundle.putParcelable("delegate", (Parcelable)ActivityStarterIpcDelegate.bq((Context)paramBundle));
                break;
                paramBundle = (Context)paramBundle.get();
                break label429;
              }
            }
          }
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/widget/PreloadWebViewStubCallback$Companion;", "", "()V", "TAG", "", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<ah>
  {
    b(s params, ah.d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.s
 * JD-Core Version:    0.7.0.1
 */