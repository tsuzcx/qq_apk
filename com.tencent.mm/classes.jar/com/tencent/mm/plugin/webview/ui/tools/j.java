package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.ClickableSpan;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.d.n.a;
import com.tencent.mm.plugin.webview.model.az;
import com.tencent.mm.plugin.webview.model.az.d;
import com.tencent.mm.plugin.webview.ui.tools.browser.f;
import com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.WhichApp;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.h.e;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.o.b;
import com.tencent.mm.ui.base.o.c;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.e.c;
import com.tencent.mm.ui.widget.a.e.f;
import com.tencent.mm.vfs.aa;
import com.tencent.neattextview.textview.view.NeatTextView;
import com.tencent.wework.api.IWWAPI;
import com.tencent.wework.api.IWWAPI.WWAppType;
import com.tencent.wework.api.WWAPIFactory;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class j
  extends a
{
  protected Map<String, SparseBooleanArray> Jgj;
  protected Map<String, Integer> Jgk;
  LruCache<String, Bitmap> Jgl;
  HashMap<String, String> Jgm;
  f Jgn;
  public HashMap<Integer, a> Jgo;
  public String Jgp;
  HashMap<String, Integer> Jgq;
  public boolean Jgr;
  public boolean Jgs;
  Set<Integer> Jgt;
  m Jgu;
  ArrayList<com.tencent.mm.n.e.b> Jgv;
  Boolean Jgw;
  String Jgx;
  AppBrandOpenMaterialCollection Jgy;
  private com.tencent.mm.plugin.appbrand.openmaterial.h Jgz;
  private int height;
  private String myD;
  com.tencent.mm.ui.widget.a.e nVN;
  private int width;
  
  public j(WebViewUI paramWebViewUI)
  {
    super(paramWebViewUI);
    AppMethodBeat.i(79877);
    this.Jgj = new HashMap();
    this.Jgk = new HashMap();
    this.Jgl = new LruCache(12);
    this.Jgm = new HashMap();
    this.Jgn = new f(1);
    this.Jgo = new HashMap();
    this.myD = "";
    this.Jgq = new HashMap();
    this.Jgr = true;
    this.Jgs = false;
    this.Jgt = new HashSet();
    this.Jgx = null;
    this.Jgy = null;
    this.Jgz = null;
    this.width = paramWebViewUI.getResources().getDisplayMetrics().widthPixels;
    this.height = paramWebViewUI.getResources().getDisplayMetrics().heightPixels;
    AppMethodBeat.o(79877);
  }
  
  static ResolveInfo a(WebViewUI paramWebViewUI, com.tencent.mm.plugin.webview.stub.e parame)
  {
    boolean bool = true;
    AppMethodBeat.i(211083);
    if (parame != null) {
      try
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("WebViewShare_wv_url", paramWebViewUI.fZM());
        localBundle = parame.j(120000, localBundle);
        parame = localBundle.getString("default_browser_package_name", "");
        paramWebViewUI = com.tencent.mm.plugin.webview.ui.tools.browser.b.N(paramWebViewUI, parame, localBundle.getString("k_share_url", ""));
        if (paramWebViewUI != null) {}
        for (;;)
        {
          Log.i("MicroMsg.WebViewMenuHelper", "alvinluo getDefaultBrowser defaultBrowserPackageName: %s, defaultBrowser != null: %b", new Object[] { parame, Boolean.valueOf(bool) });
          AppMethodBeat.o(211083);
          return paramWebViewUI;
          bool = false;
        }
        AppMethodBeat.o(211083);
      }
      catch (Exception paramWebViewUI)
      {
        Log.printErrStackTrace("MicroMsg.WebViewMenuHelper", paramWebViewUI, "alvinluo addDefaultBrowserMenuItem exception", new Object[0]);
      }
    }
    return null;
  }
  
  protected static boolean a(JsapiPermissionWrapper paramJsapiPermissionWrapper, int paramInt)
  {
    AppMethodBeat.i(79882);
    if (paramJsapiPermissionWrapper == null)
    {
      AppMethodBeat.o(79882);
      return false;
    }
    paramInt = paramJsapiPermissionWrapper.aiW(paramInt);
    if ((paramInt == 1) || (paramInt == 10))
    {
      AppMethodBeat.o(79882);
      return true;
    }
    AppMethodBeat.o(79882);
    return false;
  }
  
  static boolean a(m paramm, int paramInt, Drawable paramDrawable, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(211086);
    if (paramm == null)
    {
      AppMethodBeat.o(211086);
      return false;
    }
    if (paramm.findItem(45) != null)
    {
      Log.w("MicroMsg.WebViewMenuHelper", "alvinluo doAddDefaultBrowserMenuItem has added and ignore");
      AppMethodBeat.o(211086);
      return false;
    }
    Log.d("MicroMsg.WebViewMenuHelper", "alvinluo doAddDefaultBrowserMenuItem index: %s", new Object[] { Integer.valueOf(paramInt) });
    paramm = paramm.b(paramInt, paramString, paramBoolean);
    ((n)paramm).ORF = TextUtils.TruncateAt.END;
    ((n)paramm).ORG = false;
    paramm.setIcon(paramDrawable);
    AppMethodBeat.o(211086);
    return true;
  }
  
  private void agJ(int paramInt)
  {
    AppMethodBeat.i(79891);
    String str2 = geo().aXD(geo().gfu());
    if ((TextUtils.isEmpty(geo().gfu())) || (TextUtils.isEmpty(str2)))
    {
      Log.i("MicroMsg.WebViewMenuHelper", "stev appId is null or empty");
      AppMethodBeat.o(79891);
      return;
    }
    Log.i("MicroMsg.WebViewMenuHelper", "stev appId %s", new Object[] { str2 });
    long l = Util.nowSecond();
    Log.d("MicroMsg.WebViewMenuHelper", "stev report(%s), clickTimestamp : %d, appID : %s, url : %s, sessionId : %s, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13377), Long.valueOf(l), str2, geo().gfu(), geo().sessionId, Integer.valueOf(3), Integer.valueOf(paramInt) });
    Object localObject = "";
    try
    {
      str1 = com.tencent.mm.compatible.util.q.encode(geo().gfu(), "UTF-8");
      localObject = str1;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        String str1;
        int i;
        Log.printErrStackTrace("MicroMsg.WebViewMenuHelper", localUnsupportedEncodingException, "", new Object[0]);
      }
    }
    i = geo().aXI(geo().getIntent().getStringExtra("geta8key_username"));
    str1 = "";
    if ((i == 7) || (i == 56)) {
      str1 = geo().getIntent().getStringExtra("geta8key_username");
    }
    com.tencent.mm.plugin.report.service.h.CyF.a(13377, new Object[] { Long.valueOf(l), str2, localObject, geo().sessionId, Integer.valueOf(3), Integer.valueOf(paramInt), Integer.valueOf(0), str1 });
    AppMethodBeat.o(79891);
  }
  
  protected static boolean b(JsapiPermissionWrapper paramJsapiPermissionWrapper, int paramInt)
  {
    AppMethodBeat.i(79883);
    if (paramJsapiPermissionWrapper == null)
    {
      AppMethodBeat.o(79883);
      return false;
    }
    if (paramJsapiPermissionWrapper.aiW(paramInt) == 10)
    {
      AppMethodBeat.o(79883);
      return true;
    }
    AppMethodBeat.o(79883);
    return false;
  }
  
  private void geJ()
  {
    AppMethodBeat.i(211076);
    Log.d("MicroMsg.WebViewMenuHelper", "loadOpenMaterialsIfNeedAndEnhanceBottomSheet");
    if (!agI(7))
    {
      Log.i("MicroMsg.WebViewMenuHelper", "loadOpenMaterialsIfNeedAndEnhanceBottomSheet, can not show");
      AppMethodBeat.o(211076);
      return;
    }
    final com.tencent.mm.plugin.appbrand.service.i locali = (com.tencent.mm.plugin.appbrand.service.i)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.i.class);
    if (locali == null)
    {
      Log.w("MicroMsg.WebViewMenuHelper", "loadOpenMaterialsIfNeedAndEnhanceBottomSheet, openMaterialService is null");
      AppMethodBeat.o(211076);
      return;
    }
    if (!locali.c(com.tencent.mm.plugin.appbrand.openmaterial.model.b.nlM))
    {
      Log.i("MicroMsg.WebViewMenuHelper", "loadOpenMaterialsIfNeedAndEnhanceBottomSheet, openMaterialService is disabled");
      AppMethodBeat.o(211076);
      return;
    }
    Object localObject = geo();
    if (localObject == null)
    {
      Log.w("MicroMsg.WebViewMenuHelper", "loadOpenMaterialsIfNeedAndEnhanceBottomSheet, webViewUI is null");
      AppMethodBeat.o(211076);
      return;
    }
    localObject = ((WebViewUI)localObject).IMH;
    if (localObject == null)
    {
      Log.w("MicroMsg.WebViewMenuHelper", "loadOpenMaterialsIfNeedAndEnhanceBottomSheet, controller is null");
      AppMethodBeat.o(211076);
      return;
    }
    localObject = ((com.tencent.mm.plugin.webview.core.i)localObject).beU();
    Log.d("MicroMsg.WebViewMenuHelper", "loadOpenMaterialsIfNeedAndEnhanceBottomSheet, url: ".concat(String.valueOf(localObject)));
    if (Util.isNullOrNil((String)localObject))
    {
      Log.w("MicroMsg.WebViewMenuHelper", "loadOpenMaterialsIfNeedAndEnhanceBottomSheet, url is empty");
      com.tencent.f.h.RTc.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(211051);
          j.a(j.this);
          AppMethodBeat.o(211051);
        }
      }, 1000L);
      AppMethodBeat.o(211076);
      return;
    }
    if (((String)localObject).equals(this.Jgx))
    {
      Log.i("MicroMsg.WebViewMenuHelper", "loadOpenMaterialsIfNeedAndEnhanceBottomSheet, already load");
      a(locali);
      AppMethodBeat.o(211076);
      return;
    }
    MaterialModel localMaterialModel = MaterialModel.adp((String)localObject);
    if (!locali.adl(localMaterialModel.mimeType))
    {
      Log.i("MicroMsg.WebViewMenuHelper", "loadOpenMaterialsIfNeedAndEnhanceBottomSheet, openMaterialService is not support " + localMaterialModel.mimeType);
      AppMethodBeat.o(211076);
      return;
    }
    locali.a(localMaterialModel, new com.tencent.mm.plugin.appbrand.openmaterial.i()
    {
      public final void a(boolean paramAnonymousBoolean, AppBrandOpenMaterialCollection paramAnonymousAppBrandOpenMaterialCollection)
      {
        AppMethodBeat.i(211062);
        if (!paramAnonymousBoolean)
        {
          Log.i("MicroMsg.WebViewMenuHelper", "loadOpenMaterialsIfNeedAndEnhanceBottomSheet#onMyOpenMaterialsGot, fail");
          AppMethodBeat.o(211062);
          return;
        }
        j.this.Jgx = this.val$url;
        j.this.Jgy = paramAnonymousAppBrandOpenMaterialCollection;
        j.this.a(locali);
        AppMethodBeat.o(211062);
      }
    });
    AppMethodBeat.o(211076);
  }
  
  private ArrayList<com.tencent.mm.n.e.b> geO()
  {
    AppMethodBeat.i(79888);
    if (geo().pGj == null)
    {
      Log.w("MicroMsg.WebViewMenuHelper", "getCustomMenuList viewWV is null");
      AppMethodBeat.o(79888);
      return null;
    }
    Object localObject = geo().pGj.getUrl();
    if (geo().JiO.containsKey(localObject))
    {
      localObject = (ArrayList)geo().JiO.get(localObject);
      AppMethodBeat.o(79888);
      return localObject;
    }
    AppMethodBeat.o(79888);
    return null;
  }
  
  private void ik(List<String> paramList)
  {
    AppMethodBeat.i(79894);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(79894);
      return;
    }
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label308;
      }
      String str2 = (String)localIterator.next();
      if (this.Jgl.get(str2) != null) {
        Log.i("MicroMsg.WebViewMenuHelper", "find %s icon from cache ok", new Object[] { str2 });
      }
      for (;;)
      {
        if (!this.Jgm.containsKey(str2)) {
          break label216;
        }
        Log.i("MicroMsg.WebViewMenuHelper", "find %s nick from cache ok", new Object[] { str2 });
        break;
        Log.w("MicroMsg.WebViewMenuHelper", "not found %s icon from cache, try to load", new Object[] { str2 });
        try
        {
          paramList = geo().IMH.mHh.aZQ(str2);
          if (!Util.isNullOrNil(paramList))
          {
            paramList = e.baf(paramList);
            if (paramList != null)
            {
              Log.i("MicroMsg.WebViewMenuHelper", "load ok, and cache it");
              this.Jgl.put(str2, paramList);
            }
          }
        }
        catch (Exception paramList)
        {
          Log.w("MicroMsg.WebViewMenuHelper", "getheadimg, ex = " + paramList.getMessage());
        }
      }
      label216:
      Log.w("MicroMsg.WebViewMenuHelper", "not found %s nick from cache, try to load", new Object[] { str2 });
      paramList = null;
      try
      {
        String str1 = geo().IMH.mHh.getDisplayName(str2);
        paramList = str1;
        Log.i("MicroMsg.WebViewMenuHelper", "load nick ok");
        paramList = str1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.w("MicroMsg.WebViewMenuHelper", "onAttach, ex = " + localException.getMessage());
        }
      }
      this.Jgm.put(str2, paramList);
    }
    label308:
    AppMethodBeat.o(79894);
  }
  
  protected final void Mf(final long paramLong)
  {
    AppMethodBeat.i(211082);
    if (gcd())
    {
      Log.w("MicroMsg.WebViewMenuHelper", "showReaderModeMenu, webViewUI is finished");
      AppMethodBeat.o(211082);
      return;
    }
    this.Jgv = geO();
    boolean bool;
    if ((this.Jgv != null) && (this.Jgv.size() > 0))
    {
      bool = true;
      this.Jgw = Boolean.valueOf(bool);
      if (!geL()) {
        if (!this.Jgw.booleanValue()) {
          break label213;
        }
      }
    }
    Object localObject2;
    label213:
    for (this.nVN = new com.tencent.mm.ui.widget.a.e(geo(), 1, false);; this.nVN = new com.tencent.mm.ui.widget.a.e(geo(), 0, true))
    {
      geJ();
      this.nVN.HMa = new o.b()
      {
        public final void a(ImageView paramAnonymousImageView, MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(211068);
          if (j.e(paramAnonymousMenuItem))
          {
            paramAnonymousImageView.setVisibility(8);
            AppMethodBeat.o(211068);
            return;
          }
          paramAnonymousMenuItem = paramAnonymousMenuItem.getTitle();
          if ((j.this.Jgl.get(paramAnonymousMenuItem) != null) && (!((Bitmap)j.this.Jgl.get(paramAnonymousMenuItem)).isRecycled()))
          {
            paramAnonymousImageView.setImageBitmap((Bitmap)j.this.Jgl.get(paramAnonymousMenuItem));
            AppMethodBeat.o(211068);
            return;
          }
          Log.w("MicroMsg.WebViewMenuHelper", "on attach icon, load from cache fail");
          try
          {
            Object localObject = j.this.geo().IMH.mHh.aZQ(paramAnonymousMenuItem);
            if (!Util.isNullOrNil((String)localObject))
            {
              localObject = e.baf((String)localObject);
              if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
              {
                paramAnonymousImageView.setImageBitmap((Bitmap)localObject);
                j.this.Jgl.put(paramAnonymousMenuItem, localObject);
              }
            }
            AppMethodBeat.o(211068);
            return;
          }
          catch (Exception paramAnonymousImageView)
          {
            Log.w("MicroMsg.WebViewMenuHelper", "getheadimg, ex = " + paramAnonymousImageView.getMessage());
            AppMethodBeat.o(211068);
          }
        }
      };
      this.nVN.HMb = new o.c()
      {
        public final void a(TextView paramAnonymousTextView, MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(211069);
          paramAnonymousMenuItem = paramAnonymousMenuItem.getTitle();
          if (paramAnonymousTextView != null)
          {
            String str = (String)j.this.Jgm.get(paramAnonymousMenuItem);
            if (Util.isNullOrNil(str))
            {
              paramAnonymousTextView.setText(paramAnonymousMenuItem);
              AppMethodBeat.o(211069);
              return;
            }
            paramAnonymousTextView.setText(com.tencent.mm.pluginsdk.ui.span.l.b(j.this.geo(), str, paramAnonymousTextView.getTextSize()));
          }
          AppMethodBeat.o(211069);
        }
      };
      localObject2 = new o.g()
      {
        /* Error */
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          // Byte code:
          //   0: ldc 28
          //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   5: aload_0
          //   6: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   9: invokevirtual 38	com/tencent/mm/plugin/webview/ui/tools/j:gcd	()Z
          //   12: ifeq +9 -> 21
          //   15: ldc 28
          //   17: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   20: return
          //   21: aload_1
          //   22: invokestatic 45	com/tencent/mm/plugin/webview/ui/tools/j:e	(Landroid/view/MenuItem;)Z
          //   25: ifeq +145 -> 170
          //   28: aload_1
          //   29: invokeinterface 51 1 0
          //   34: checkcast 53	com/tencent/mm/n/e$b
          //   37: astore 4
          //   39: aload 4
          //   41: ifnull +123 -> 164
          //   44: aload_0
          //   45: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   48: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   51: getfield 63	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IBw	Lcom/tencent/mm/plugin/webview/d/h;
          //   54: astore_1
          //   55: aload_1
          //   56: getfield 69	com/tencent/mm/plugin/webview/d/h:GBl	Z
          //   59: ifne +16 -> 75
          //   62: ldc 71
          //   64: ldc 73
          //   66: invokestatic 78	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   69: ldc 28
          //   71: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   74: return
          //   75: ldc 71
          //   77: ldc 80
          //   79: invokestatic 82	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   82: new 84	java/util/HashMap
          //   85: dup
          //   86: invokespecial 85	java/util/HashMap:<init>	()V
          //   89: astore 5
          //   91: aload 5
          //   93: ldc 87
          //   95: aload 4
          //   97: getfield 90	com/tencent/mm/n/e$b:key	Ljava/lang/String;
          //   100: invokevirtual 94	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
          //   103: pop
          //   104: aload 5
          //   106: ldc 96
          //   108: aload 4
          //   110: getfield 98	com/tencent/mm/n/e$b:title	Ljava/lang/String;
          //   113: invokevirtual 94	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
          //   116: pop
          //   117: ldc 100
          //   119: aload 5
          //   121: aload_1
          //   122: getfield 103	com/tencent/mm/plugin/webview/d/h:IRj	Z
          //   125: aload_1
          //   126: getfield 106	com/tencent/mm/plugin/webview/d/h:zpY	Ljava/lang/String;
          //   129: invokestatic 112	com/tencent/mm/plugin/webview/d/n$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   132: astore 4
          //   134: aload_1
          //   135: getfield 116	com/tencent/mm/plugin/webview/d/h:IRa	Lcom/tencent/mm/ui/widget/MMWebView;
          //   138: new 118	java/lang/StringBuilder
          //   141: dup
          //   142: ldc 120
          //   144: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   147: aload 4
          //   149: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   152: ldc 129
          //   154: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   157: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   160: aconst_null
          //   161: invokevirtual 139	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   164: ldc 28
          //   166: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   169: return
          //   170: ldc 141
          //   172: ldc 143
          //   174: iconst_1
          //   175: anewarray 4	java/lang/Object
          //   178: dup
          //   179: iconst_0
          //   180: aload_1
          //   181: invokeinterface 147 1 0
          //   186: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   189: aastore
          //   190: invokestatic 156	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   193: aload_1
          //   194: invokeinterface 147 1 0
          //   199: tableswitch	default:+409 -> 608, 1:+660->859, 2:+895->1094, 3:+1213->1412, 4:+409->608, 5:+1326->1525, 6:+1705->1904, 7:+1768->1967, 8:+2512->2711, 9:+2670->2869, 10:+2770->2969, 11:+1460->1659, 12:+2835->3034, 13:+409->608, 14:+409->608, 15:+2966->3165, 16:+3031->3230, 17:+3096->3295, 18:+3161->3360, 19:+3226->3425, 20:+3596->3795, 21:+3793->3992, 22:+3951->4150, 23:+792->991, 24:+4357->4556, 25:+3291->3490, 26:+3532->3731, 27:+580->779, 28:+1638->1837, 29:+4421->4620, 30:+409->608, 31:+4485->4684, 32:+409->608, 33:+4148->4347, 34:+4609->4808, 35:+4707->4906, 36:+4793->4992, 37:+2448->2647, 38:+1083->1282, 39:+1148->1347, 40:+4917->5116, 41:+4917->5116, 42:+4917->5116, 43:+3291->3490, 44:+4947->5146, 45:+2211->2410, 46:+1290->1489, 47:+409->608, 48:+409->608, 49:+409->608, 50:+409->608, 51:+409->608, 52:+409->608, 53:+409->608, 54:+409->608, 55:+409->608, 56:+409->608, 57:+409->608, 58:+409->608, 59:+409->608, 60:+409->608, 61:+409->608, 62:+409->608, 63:+409->608, 64:+409->608, 65:+409->608, 66:+409->608, 67:+409->608, 68:+409->608, 69:+409->608, 70:+409->608, 71:+409->608, 72:+409->608, 73:+409->608, 74:+409->608, 75:+409->608, 76:+409->608, 77:+409->608, 78:+409->608, 79:+409->608, 80:+409->608, 81:+409->608, 82:+409->608, 83:+409->608, 84:+409->608, 85:+409->608, 86:+409->608, 87:+409->608, 88:+409->608, 89:+409->608, 90:+409->608, 91:+409->608, 92:+409->608, 93:+409->608, 94:+409->608, 95:+409->608, 96:+409->608, 97:+409->608, 98:+409->608, 99:+4850->5049
          //   609: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   612: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   615: getfield 160	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IMs	Lcom/tencent/mm/plugin/webview/model/az;
          //   618: invokevirtual 166	com/tencent/mm/plugin/webview/model/az:gdh	()Lcom/tencent/mm/plugin/webview/model/az$d;
          //   621: iconst_3
          //   622: anewarray 4	java/lang/Object
          //   625: dup
          //   626: iconst_0
          //   627: aload_0
          //   628: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   631: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   634: invokevirtual 169	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:coX	()Ljava/lang/String;
          //   637: aastore
          //   638: dup
          //   639: iconst_1
          //   640: bipush 16
          //   642: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   645: aastore
          //   646: dup
          //   647: iconst_2
          //   648: iconst_1
          //   649: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   652: aastore
          //   653: invokevirtual 175	com/tencent/mm/plugin/webview/model/az$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/az$d;
          //   656: invokevirtual 178	com/tencent/mm/plugin/webview/model/az$d:report	()V
          //   659: new 118	java/lang/StringBuilder
          //   662: dup
          //   663: invokespecial 179	java/lang/StringBuilder:<init>	()V
          //   666: aload_1
          //   667: invokeinterface 183 1 0
          //   672: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
          //   675: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   678: astore 4
          //   680: aload 4
          //   682: invokestatic 192	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
          //   685: ifne +4761 -> 5446
          //   688: iconst_0
          //   689: istore_2
          //   690: new 194	android/os/Bundle
          //   693: dup
          //   694: invokespecial 195	android/os/Bundle:<init>	()V
          //   697: astore_1
          //   698: aload_1
          //   699: ldc 197
          //   701: aload 4
          //   703: invokevirtual 200	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
          //   706: aload_0
          //   707: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   710: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   713: getfield 204	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IMH	Lcom/tencent/mm/plugin/webview/core/i;
          //   716: getfield 210	com/tencent/mm/plugin/webview/core/i:mHh	Lcom/tencent/mm/plugin/webview/stub/e;
          //   719: bipush 50
          //   721: aload_1
          //   722: invokeinterface 216 3 0
          //   727: astore_1
          //   728: aload_1
          //   729: ifnull +31 -> 760
          //   732: aload_1
          //   733: ldc 218
          //   735: invokevirtual 222	android/os/Bundle:getInt	(Ljava/lang/String;)I
          //   738: istore_2
          //   739: iload_2
          //   740: iconst_2
          //   741: if_icmpne +4490 -> 5231
          //   744: iconst_1
          //   745: istore_2
          //   746: aload_1
          //   747: ldc 218
          //   749: invokevirtual 222	android/os/Bundle:getInt	(Ljava/lang/String;)I
          //   752: istore_3
          //   753: iload_3
          //   754: iconst_3
          //   755: if_icmpne +4481 -> 5236
          //   758: iconst_1
          //   759: istore_2
          //   760: iload_2
          //   761: ifeq +4499 -> 5260
          //   764: aload_0
          //   765: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   768: aload 4
          //   770: invokevirtual 225	com/tencent/mm/plugin/webview/ui/tools/j:bam	(Ljava/lang/String;)V
          //   773: ldc 28
          //   775: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   778: return
          //   779: aload_0
          //   780: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   783: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   786: getfield 160	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IMs	Lcom/tencent/mm/plugin/webview/model/az;
          //   789: invokevirtual 166	com/tencent/mm/plugin/webview/model/az:gdh	()Lcom/tencent/mm/plugin/webview/model/az$d;
          //   792: iconst_3
          //   793: anewarray 4	java/lang/Object
          //   796: dup
          //   797: iconst_0
          //   798: aload_0
          //   799: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   802: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   805: invokevirtual 169	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:coX	()Ljava/lang/String;
          //   808: aastore
          //   809: dup
          //   810: iconst_1
          //   811: bipush 32
          //   813: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   816: aastore
          //   817: dup
          //   818: iconst_2
          //   819: iconst_1
          //   820: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   823: aastore
          //   824: invokevirtual 175	com/tencent/mm/plugin/webview/model/az$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/az$d;
          //   827: invokevirtual 178	com/tencent/mm/plugin/webview/model/az$d:report	()V
          //   830: aload_0
          //   831: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   834: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   837: invokevirtual 228	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:gbB	()Z
          //   840: ifne +4606 -> 5446
          //   843: aload_0
          //   844: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   847: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   850: invokevirtual 231	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:finish	()V
          //   853: ldc 28
          //   855: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   858: return
          //   859: aload_0
          //   860: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   863: invokevirtual 234	com/tencent/mm/plugin/webview/ui/tools/a:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   866: invokevirtual 238	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   869: ldc 240
          //   871: invokevirtual 246	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   874: astore_1
          //   875: aload_0
          //   876: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   879: invokevirtual 234	com/tencent/mm/plugin/webview/ui/tools/a:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   882: invokevirtual 238	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   885: ldc 248
          //   887: invokevirtual 246	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   890: astore 4
          //   892: aload_0
          //   893: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   896: invokevirtual 234	com/tencent/mm/plugin/webview/ui/tools/a:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   899: invokevirtual 238	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   902: ldc 250
          //   904: invokevirtual 246	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   907: astore 5
          //   909: aload_0
          //   910: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   913: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   916: getfield 160	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IMs	Lcom/tencent/mm/plugin/webview/model/az;
          //   919: invokevirtual 166	com/tencent/mm/plugin/webview/model/az:gdh	()Lcom/tencent/mm/plugin/webview/model/az$d;
          //   922: bipush 6
          //   924: anewarray 4	java/lang/Object
          //   927: dup
          //   928: iconst_0
          //   929: aload_0
          //   930: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   933: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   936: invokevirtual 169	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:coX	()Ljava/lang/String;
          //   939: aastore
          //   940: dup
          //   941: iconst_1
          //   942: iconst_1
          //   943: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   946: aastore
          //   947: dup
          //   948: iconst_2
          //   949: iconst_1
          //   950: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   953: aastore
          //   954: dup
          //   955: iconst_3
          //   956: aload_1
          //   957: aastore
          //   958: dup
          //   959: iconst_4
          //   960: aload 4
          //   962: aastore
          //   963: dup
          //   964: iconst_5
          //   965: aload 5
          //   967: aastore
          //   968: invokevirtual 175	com/tencent/mm/plugin/webview/model/az$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/az$d;
          //   971: invokevirtual 178	com/tencent/mm/plugin/webview/model/az$d:report	()V
          //   974: aload_0
          //   975: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   978: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   981: iconst_0
          //   982: invokevirtual 253	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:agO	(I)V
          //   985: ldc 28
          //   987: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   990: return
          //   991: new 242	android/content/Intent
          //   994: dup
          //   995: invokespecial 254	android/content/Intent:<init>	()V
          //   998: astore_1
          //   999: aload_0
          //   1000: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1003: invokevirtual 234	com/tencent/mm/plugin/webview/ui/tools/a:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1006: invokevirtual 238	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   1009: ldc_w 256
          //   1012: invokevirtual 246	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   1015: astore 4
          //   1017: aload 4
          //   1019: ifnull +42 -> 1061
          //   1022: aload_1
          //   1023: ldc_w 258
          //   1026: iconst_1
          //   1027: invokevirtual 262	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
          //   1030: pop
          //   1031: aload_1
          //   1032: ldc_w 256
          //   1035: aload 4
          //   1037: invokevirtual 265	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
          //   1040: pop
          //   1041: aload_0
          //   1042: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1045: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1048: ldc_w 267
          //   1051: aload_1
          //   1052: invokestatic 273	com/tencent/mm/br/c:f	(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V
          //   1055: ldc 28
          //   1057: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1060: return
          //   1061: aload_1
          //   1062: ldc_w 275
          //   1065: aload_0
          //   1066: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1069: invokevirtual 234	com/tencent/mm/plugin/webview/ui/tools/a:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1072: invokevirtual 238	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   1075: ldc_w 277
          //   1078: ldc2_w 278
          //   1081: invokevirtual 283	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
          //   1084: invokestatic 288	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   1087: invokevirtual 291	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
          //   1090: pop
          //   1091: goto -50 -> 1041
          //   1094: aload_0
          //   1095: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1098: invokevirtual 234	com/tencent/mm/plugin/webview/ui/tools/a:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1101: invokevirtual 238	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   1104: ldc 240
          //   1106: invokevirtual 246	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   1109: astore_1
          //   1110: aload_0
          //   1111: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1114: invokevirtual 234	com/tencent/mm/plugin/webview/ui/tools/a:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1117: invokevirtual 238	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   1120: ldc 248
          //   1122: invokevirtual 246	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   1125: astore 4
          //   1127: aload_0
          //   1128: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1131: invokevirtual 234	com/tencent/mm/plugin/webview/ui/tools/a:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1134: invokevirtual 238	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   1137: ldc 250
          //   1139: invokevirtual 246	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   1142: astore 5
          //   1144: aload_0
          //   1145: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1148: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1151: getfield 160	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IMs	Lcom/tencent/mm/plugin/webview/model/az;
          //   1154: invokevirtual 166	com/tencent/mm/plugin/webview/model/az:gdh	()Lcom/tencent/mm/plugin/webview/model/az$d;
          //   1157: bipush 6
          //   1159: anewarray 4	java/lang/Object
          //   1162: dup
          //   1163: iconst_0
          //   1164: aload_0
          //   1165: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1168: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1171: invokevirtual 169	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:coX	()Ljava/lang/String;
          //   1174: aastore
          //   1175: dup
          //   1176: iconst_1
          //   1177: iconst_2
          //   1178: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1181: aastore
          //   1182: dup
          //   1183: iconst_2
          //   1184: iconst_1
          //   1185: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1188: aastore
          //   1189: dup
          //   1190: iconst_3
          //   1191: aload_1
          //   1192: aastore
          //   1193: dup
          //   1194: iconst_4
          //   1195: aload 4
          //   1197: aastore
          //   1198: dup
          //   1199: iconst_5
          //   1200: aload 5
          //   1202: aastore
          //   1203: invokevirtual 175	com/tencent/mm/plugin/webview/model/az$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/az$d;
          //   1206: invokevirtual 178	com/tencent/mm/plugin/webview/model/az$d:report	()V
          //   1209: iconst_0
          //   1210: istore_2
          //   1211: aload_0
          //   1212: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1215: getfield 295	com/tencent/mm/plugin/webview/ui/tools/j:Jgq	Ljava/util/HashMap;
          //   1218: aload_0
          //   1219: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1222: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1225: getfield 298	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:pGj	Lcom/tencent/mm/ui/widget/MMWebView;
          //   1228: invokevirtual 301	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
          //   1231: invokevirtual 305	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
          //   1234: ifeq +33 -> 1267
          //   1237: aload_0
          //   1238: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1241: getfield 295	com/tencent/mm/plugin/webview/ui/tools/j:Jgq	Ljava/util/HashMap;
          //   1244: aload_0
          //   1245: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1248: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1251: getfield 298	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:pGj	Lcom/tencent/mm/ui/widget/MMWebView;
          //   1254: invokevirtual 301	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
          //   1257: invokevirtual 309	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
          //   1260: checkcast 149	java/lang/Integer
          //   1263: invokevirtual 312	java/lang/Integer:intValue	()I
          //   1266: istore_2
          //   1267: aload_0
          //   1268: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1271: iload_2
          //   1272: iconst_0
          //   1273: invokestatic 316	com/tencent/mm/plugin/webview/ui/tools/j:a	(Lcom/tencent/mm/plugin/webview/ui/tools/j;II)V
          //   1276: ldc 28
          //   1278: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1281: return
          //   1282: aload_0
          //   1283: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1286: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1289: getfield 160	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IMs	Lcom/tencent/mm/plugin/webview/model/az;
          //   1292: invokevirtual 166	com/tencent/mm/plugin/webview/model/az:gdh	()Lcom/tencent/mm/plugin/webview/model/az$d;
          //   1295: iconst_3
          //   1296: anewarray 4	java/lang/Object
          //   1299: dup
          //   1300: iconst_0
          //   1301: aload_0
          //   1302: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1305: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1308: invokevirtual 169	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:coX	()Ljava/lang/String;
          //   1311: aastore
          //   1312: dup
          //   1313: iconst_1
          //   1314: bipush 36
          //   1316: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1319: aastore
          //   1320: dup
          //   1321: iconst_2
          //   1322: iconst_1
          //   1323: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1326: aastore
          //   1327: invokevirtual 175	com/tencent/mm/plugin/webview/model/az$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/az$d;
          //   1330: invokevirtual 178	com/tencent/mm/plugin/webview/model/az$d:report	()V
          //   1333: aload_0
          //   1334: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1337: iconst_1
          //   1338: invokestatic 319	com/tencent/mm/plugin/webview/ui/tools/j:a	(Lcom/tencent/mm/plugin/webview/ui/tools/j;I)V
          //   1341: ldc 28
          //   1343: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1346: return
          //   1347: aload_0
          //   1348: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1351: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1354: getfield 160	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IMs	Lcom/tencent/mm/plugin/webview/model/az;
          //   1357: invokevirtual 166	com/tencent/mm/plugin/webview/model/az:gdh	()Lcom/tencent/mm/plugin/webview/model/az$d;
          //   1360: iconst_3
          //   1361: anewarray 4	java/lang/Object
          //   1364: dup
          //   1365: iconst_0
          //   1366: aload_0
          //   1367: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1370: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1373: invokevirtual 169	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:coX	()Ljava/lang/String;
          //   1376: aastore
          //   1377: dup
          //   1378: iconst_1
          //   1379: bipush 37
          //   1381: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1384: aastore
          //   1385: dup
          //   1386: iconst_2
          //   1387: iconst_1
          //   1388: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1391: aastore
          //   1392: invokevirtual 175	com/tencent/mm/plugin/webview/model/az$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/az$d;
          //   1395: invokevirtual 178	com/tencent/mm/plugin/webview/model/az$d:report	()V
          //   1398: aload_0
          //   1399: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1402: iconst_0
          //   1403: invokestatic 319	com/tencent/mm/plugin/webview/ui/tools/j:a	(Lcom/tencent/mm/plugin/webview/ui/tools/j;I)V
          //   1406: ldc 28
          //   1408: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1411: return
          //   1412: aload_0
          //   1413: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1416: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1419: getfield 160	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IMs	Lcom/tencent/mm/plugin/webview/model/az;
          //   1422: invokevirtual 166	com/tencent/mm/plugin/webview/model/az:gdh	()Lcom/tencent/mm/plugin/webview/model/az$d;
          //   1425: iconst_3
          //   1426: anewarray 4	java/lang/Object
          //   1429: dup
          //   1430: iconst_0
          //   1431: aload_0
          //   1432: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1435: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1438: invokevirtual 169	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:coX	()Ljava/lang/String;
          //   1441: aastore
          //   1442: dup
          //   1443: iconst_1
          //   1444: iconst_3
          //   1445: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1448: aastore
          //   1449: dup
          //   1450: iconst_2
          //   1451: iconst_1
          //   1452: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1455: aastore
          //   1456: invokevirtual 175	com/tencent/mm/plugin/webview/model/az$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/az$d;
          //   1459: invokevirtual 178	com/tencent/mm/plugin/webview/model/az$d:report	()V
          //   1462: getstatic 325	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
          //   1465: ldc2_w 326
          //   1468: ldc2_w 328
          //   1471: lconst_1
          //   1472: iconst_0
          //   1473: invokevirtual 333	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
          //   1476: aload_0
          //   1477: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1480: invokevirtual 336	com/tencent/mm/plugin/webview/ui/tools/j:geP	()V
          //   1483: ldc 28
          //   1485: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1488: return
          //   1489: aload_0
          //   1490: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1493: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1496: invokevirtual 340	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:gfe	()Lcom/tencent/mm/plugin/handoff/model/HandOffURL;
          //   1499: astore_1
          //   1500: aload_1
          //   1501: ifnull +3945 -> 5446
          //   1504: ldc_w 342
          //   1507: invokestatic 348	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
          //   1510: checkcast 342	com/tencent/mm/plugin/handoff/a/a
          //   1513: aload_1
          //   1514: invokeinterface 351 2 0
          //   1519: ldc 28
          //   1521: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1524: return
          //   1525: aload_0
          //   1526: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1529: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1532: getfield 160	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IMs	Lcom/tencent/mm/plugin/webview/model/az;
          //   1535: invokevirtual 166	com/tencent/mm/plugin/webview/model/az:gdh	()Lcom/tencent/mm/plugin/webview/model/az$d;
          //   1538: iconst_3
          //   1539: anewarray 4	java/lang/Object
          //   1542: dup
          //   1543: iconst_0
          //   1544: aload_0
          //   1545: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1548: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1551: invokevirtual 169	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:coX	()Ljava/lang/String;
          //   1554: aastore
          //   1555: dup
          //   1556: iconst_1
          //   1557: iconst_4
          //   1558: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1561: aastore
          //   1562: dup
          //   1563: iconst_2
          //   1564: iconst_1
          //   1565: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1568: aastore
          //   1569: invokevirtual 175	com/tencent/mm/plugin/webview/model/az$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/az$d;
          //   1572: invokevirtual 178	com/tencent/mm/plugin/webview/model/az$d:report	()V
          //   1575: aload_0
          //   1576: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1579: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1582: getfield 354	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:JiN	Ljava/util/HashMap;
          //   1585: aload_0
          //   1586: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1589: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1592: getfield 298	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:pGj	Lcom/tencent/mm/ui/widget/MMWebView;
          //   1595: invokevirtual 301	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
          //   1598: invokevirtual 309	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
          //   1601: checkcast 356	java/lang/String
          //   1604: astore 4
          //   1606: aload 4
          //   1608: astore_1
          //   1609: aload 4
          //   1611: ifnonnull +19 -> 1630
          //   1614: aload_0
          //   1615: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1618: invokevirtual 234	com/tencent/mm/plugin/webview/ui/tools/a:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1621: invokevirtual 238	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   1624: ldc 250
          //   1626: invokevirtual 246	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   1629: astore_1
          //   1630: aload_0
          //   1631: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1634: ldc_w 358
          //   1637: bipush 43
          //   1639: invokevirtual 362	com/tencent/mm/plugin/webview/ui/tools/j:gx	(Ljava/lang/String;I)V
          //   1642: aload_0
          //   1643: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1646: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1649: aload_1
          //   1650: invokevirtual 365	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bas	(Ljava/lang/String;)V
          //   1653: ldc 28
          //   1655: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1658: return
          //   1659: aload_0
          //   1660: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1663: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1666: getfield 160	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IMs	Lcom/tencent/mm/plugin/webview/model/az;
          //   1669: invokevirtual 166	com/tencent/mm/plugin/webview/model/az:gdh	()Lcom/tencent/mm/plugin/webview/model/az$d;
          //   1672: iconst_3
          //   1673: anewarray 4	java/lang/Object
          //   1676: dup
          //   1677: iconst_0
          //   1678: aload_0
          //   1679: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1682: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1685: invokevirtual 169	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:coX	()Ljava/lang/String;
          //   1688: aastore
          //   1689: dup
          //   1690: iconst_1
          //   1691: bipush 8
          //   1693: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1696: aastore
          //   1697: dup
          //   1698: iconst_2
          //   1699: iconst_1
          //   1700: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1703: aastore
          //   1704: invokevirtual 175	com/tencent/mm/plugin/webview/model/az$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/az$d;
          //   1707: invokevirtual 178	com/tencent/mm/plugin/webview/model/az$d:report	()V
          //   1710: aload_0
          //   1711: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1714: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1717: getfield 369	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Jib	Landroid/view/View;
          //   1720: invokevirtual 374	android/view/View:getVisibility	()I
          //   1723: bipush 8
          //   1725: if_icmpne +51 -> 1776
          //   1728: aload_0
          //   1729: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1732: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1735: ldc_w 375
          //   1738: invokestatic 381	android/view/animation/AnimationUtils:loadAnimation	(Landroid/content/Context;I)Landroid/view/animation/Animation;
          //   1741: astore_1
          //   1742: aload_0
          //   1743: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1746: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1749: getfield 369	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Jib	Landroid/view/View;
          //   1752: aload_1
          //   1753: invokevirtual 385	android/view/View:startAnimation	(Landroid/view/animation/Animation;)V
          //   1756: aload_0
          //   1757: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1760: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1763: getfield 369	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Jib	Landroid/view/View;
          //   1766: iconst_0
          //   1767: invokevirtual 388	android/view/View:setVisibility	(I)V
          //   1770: ldc 28
          //   1772: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1775: return
          //   1776: aload_0
          //   1777: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1780: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1783: ldc_w 389
          //   1786: invokestatic 381	android/view/animation/AnimationUtils:loadAnimation	(Landroid/content/Context;I)Landroid/view/animation/Animation;
          //   1789: astore_1
          //   1790: aload_1
          //   1791: new 13	com/tencent/mm/plugin/webview/ui/tools/j$20$1
          //   1794: dup
          //   1795: aload_0
          //   1796: invokespecial 392	com/tencent/mm/plugin/webview/ui/tools/j$20$1:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/j$20;)V
          //   1799: invokevirtual 398	android/view/animation/Animation:setAnimationListener	(Landroid/view/animation/Animation$AnimationListener;)V
          //   1802: aload_0
          //   1803: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1806: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1809: getfield 369	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Jib	Landroid/view/View;
          //   1812: aload_1
          //   1813: invokevirtual 385	android/view/View:startAnimation	(Landroid/view/animation/Animation;)V
          //   1816: aload_0
          //   1817: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1820: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1823: getfield 369	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Jib	Landroid/view/View;
          //   1826: bipush 8
          //   1828: invokevirtual 388	android/view/View:setVisibility	(I)V
          //   1831: ldc 28
          //   1833: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1836: return
          //   1837: aload_0
          //   1838: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1841: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1844: getfield 160	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IMs	Lcom/tencent/mm/plugin/webview/model/az;
          //   1847: invokevirtual 166	com/tencent/mm/plugin/webview/model/az:gdh	()Lcom/tencent/mm/plugin/webview/model/az$d;
          //   1850: iconst_3
          //   1851: anewarray 4	java/lang/Object
          //   1854: dup
          //   1855: iconst_0
          //   1856: aload_0
          //   1857: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1860: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1863: invokevirtual 169	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:coX	()Ljava/lang/String;
          //   1866: aastore
          //   1867: dup
          //   1868: iconst_1
          //   1869: bipush 10
          //   1871: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1874: aastore
          //   1875: dup
          //   1876: iconst_2
          //   1877: iconst_1
          //   1878: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1881: aastore
          //   1882: invokevirtual 175	com/tencent/mm/plugin/webview/model/az$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/az$d;
          //   1885: invokevirtual 178	com/tencent/mm/plugin/webview/model/az$d:report	()V
          //   1888: aload_0
          //   1889: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1892: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1895: invokevirtual 401	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:gfI	()V
          //   1898: ldc 28
          //   1900: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1903: return
          //   1904: aload_0
          //   1905: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1908: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1911: getfield 160	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IMs	Lcom/tencent/mm/plugin/webview/model/az;
          //   1914: invokevirtual 166	com/tencent/mm/plugin/webview/model/az:gdh	()Lcom/tencent/mm/plugin/webview/model/az$d;
          //   1917: iconst_3
          //   1918: anewarray 4	java/lang/Object
          //   1921: dup
          //   1922: iconst_0
          //   1923: aload_0
          //   1924: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1927: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1930: invokevirtual 169	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:coX	()Ljava/lang/String;
          //   1933: aastore
          //   1934: dup
          //   1935: iconst_1
          //   1936: iconst_5
          //   1937: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1940: aastore
          //   1941: dup
          //   1942: iconst_2
          //   1943: iconst_1
          //   1944: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1947: aastore
          //   1948: invokevirtual 175	com/tencent/mm/plugin/webview/model/az$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/az$d;
          //   1951: invokevirtual 178	com/tencent/mm/plugin/webview/model/az$d:report	()V
          //   1954: aload_0
          //   1955: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1958: invokestatic 403	com/tencent/mm/plugin/webview/ui/tools/j:b	(Lcom/tencent/mm/plugin/webview/ui/tools/j;)V
          //   1961: ldc 28
          //   1963: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1966: return
          //   1967: aload_0
          //   1968: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1971: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1974: getfield 160	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IMs	Lcom/tencent/mm/plugin/webview/model/az;
          //   1977: invokevirtual 166	com/tencent/mm/plugin/webview/model/az:gdh	()Lcom/tencent/mm/plugin/webview/model/az$d;
          //   1980: iconst_3
          //   1981: anewarray 4	java/lang/Object
          //   1984: dup
          //   1985: iconst_0
          //   1986: aload_0
          //   1987: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   1990: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1993: invokevirtual 169	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:coX	()Ljava/lang/String;
          //   1996: aastore
          //   1997: dup
          //   1998: iconst_1
          //   1999: bipush 13
          //   2001: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2004: aastore
          //   2005: dup
          //   2006: iconst_2
          //   2007: iconst_1
          //   2008: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2011: aastore
          //   2012: invokevirtual 175	com/tencent/mm/plugin/webview/model/az$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/az$d;
          //   2015: invokevirtual 178	com/tencent/mm/plugin/webview/model/az$d:report	()V
          //   2018: aload_0
          //   2019: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2022: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2025: astore 5
          //   2027: aload_0
          //   2028: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2031: astore_1
          //   2032: aload 5
          //   2034: getfield 407	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:JfY	Lcom/tencent/mm/plugin/webview/modeltools/a;
          //   2037: astore 6
          //   2039: aload 5
          //   2041: getfield 408	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:mHh	Lcom/tencent/mm/plugin/webview/stub/e;
          //   2044: astore 7
          //   2046: aload 5
          //   2048: invokevirtual 411	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:isFinishing	()Z
          //   2051: ifne +227 -> 2278
          //   2054: aload 6
          //   2056: new 413	java/lang/ref/WeakReference
          //   2059: dup
          //   2060: aload_1
          //   2061: invokespecial 416	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
          //   2064: putfield 422	com/tencent/mm/plugin/webview/modeltools/a:Jaq	Ljava/lang/ref/WeakReference;
          //   2067: aload 5
          //   2069: invokevirtual 425	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:fZM	()Ljava/lang/String;
          //   2072: astore 4
          //   2074: aload 4
          //   2076: invokestatic 192	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
          //   2079: ifeq +18 -> 2097
          //   2082: ldc_w 427
          //   2085: ldc_w 429
          //   2088: invokestatic 78	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   2091: ldc 28
          //   2093: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2096: return
          //   2097: aload 4
          //   2099: astore_1
          //   2100: aload 7
          //   2102: ifnull +13 -> 2115
          //   2105: aload 7
          //   2107: aload 4
          //   2109: invokeinterface 432 2 0
          //   2114: astore_1
          //   2115: aload_1
          //   2116: astore 4
          //   2118: aload_1
          //   2119: ldc_w 434
          //   2122: invokevirtual 437	java/lang/String:startsWith	(Ljava/lang/String;)Z
          //   2125: ifne +28 -> 2153
          //   2128: aload_1
          //   2129: astore 4
          //   2131: aload_1
          //   2132: ldc_w 439
          //   2135: invokevirtual 437	java/lang/String:startsWith	(Ljava/lang/String;)Z
          //   2138: ifne +15 -> 2153
          //   2141: ldc_w 434
          //   2144: aload_1
          //   2145: invokestatic 442	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
          //   2148: invokevirtual 445	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
          //   2151: astore 4
          //   2153: new 242	android/content/Intent
          //   2156: dup
          //   2157: ldc_w 447
          //   2160: aload 4
          //   2162: invokestatic 453	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
          //   2165: invokespecial 456	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
          //   2168: astore_1
          //   2169: aload 5
          //   2171: invokestatic 460	com/tencent/mm/sdk/platformtools/Util:isOverseasUser	(Landroid/content/Context;)Z
          //   2174: ifne +9 -> 2183
          //   2177: invokestatic 465	com/tencent/mm/sdk/platformtools/ChannelUtil:isGPVersion	()Z
          //   2180: ifeq +209 -> 2389
          //   2183: ldc_w 427
          //   2186: ldc_w 467
          //   2189: iconst_2
          //   2190: anewarray 4	java/lang/Object
          //   2193: dup
          //   2194: iconst_0
          //   2195: aload 5
          //   2197: invokestatic 460	com/tencent/mm/sdk/platformtools/Util:isOverseasUser	(Landroid/content/Context;)Z
          //   2200: invokestatic 472	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
          //   2203: aastore
          //   2204: dup
          //   2205: iconst_1
          //   2206: invokestatic 465	com/tencent/mm/sdk/platformtools/ChannelUtil:isGPVersion	()Z
          //   2209: invokestatic 472	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
          //   2212: aastore
          //   2213: invokestatic 156	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   2216: bipush 29
          //   2218: invokestatic 478	com/tencent/mm/compatible/util/d:oD	(I)Z
          //   2221: ifeq +87 -> 2308
          //   2224: aload 5
          //   2226: iconst_0
          //   2227: aload_1
          //   2228: ldc_w 479
          //   2231: invokestatic 485	android/app/PendingIntent:getActivity	(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
          //   2234: aload 5
          //   2236: iconst_1
          //   2237: aconst_null
          //   2238: new 487	com/tencent/mm/plugin/webview/modeltools/a$1
          //   2241: dup
          //   2242: aload 6
          //   2244: invokespecial 490	com/tencent/mm/plugin/webview/modeltools/a$1:<init>	(Lcom/tencent/mm/plugin/webview/modeltools/a;)V
          //   2247: aconst_null
          //   2248: invokevirtual 494	android/app/PendingIntent:send	(Landroid/content/Context;ILandroid/content/Intent;Landroid/app/PendingIntent$OnFinished;Landroid/os/Handler;)V
          //   2251: ldc 28
          //   2253: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2256: return
          //   2257: astore_1
          //   2258: ldc_w 427
          //   2261: ldc_w 496
          //   2264: iconst_1
          //   2265: anewarray 4	java/lang/Object
          //   2268: dup
          //   2269: iconst_0
          //   2270: aload_1
          //   2271: invokevirtual 499	java/lang/Exception:getMessage	()Ljava/lang/String;
          //   2274: aastore
          //   2275: invokestatic 501	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   2278: ldc 28
          //   2280: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2283: return
          //   2284: astore_1
          //   2285: ldc_w 427
          //   2288: ldc_w 503
          //   2291: iconst_1
          //   2292: anewarray 4	java/lang/Object
          //   2295: dup
          //   2296: iconst_0
          //   2297: aload_1
          //   2298: aastore
          //   2299: invokestatic 501	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   2302: aload 4
          //   2304: astore_1
          //   2305: goto -190 -> 2115
          //   2308: new 505	com/tencent/mm/hellhoundlib/b/a
          //   2311: dup
          //   2312: invokespecial 506	com/tencent/mm/hellhoundlib/b/a:<init>	()V
          //   2315: aload_1
          //   2316: invokevirtual 510	com/tencent/mm/hellhoundlib/b/a:bl	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
          //   2319: astore_1
          //   2320: aload 5
          //   2322: aload_1
          //   2323: invokevirtual 514	com/tencent/mm/hellhoundlib/b/a:axQ	()[Ljava/lang/Object;
          //   2326: ldc_w 516
          //   2329: ldc_w 518
          //   2332: ldc_w 520
          //   2335: ldc_w 522
          //   2338: ldc_w 524
          //   2341: ldc_w 526
          //   2344: invokestatic 531	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
          //   2347: aload 5
          //   2349: aload_1
          //   2350: iconst_0
          //   2351: invokevirtual 535	com/tencent/mm/hellhoundlib/b/a:pG	(I)Ljava/lang/Object;
          //   2354: checkcast 242	android/content/Intent
          //   2357: invokevirtual 537	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:startActivity	(Landroid/content/Intent;)V
          //   2360: aload 5
          //   2362: ldc_w 516
          //   2365: ldc_w 518
          //   2368: ldc_w 520
          //   2371: ldc_w 522
          //   2374: ldc_w 524
          //   2377: ldc_w 526
          //   2380: invokestatic 540	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
          //   2383: ldc 28
          //   2385: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2388: return
          //   2389: aload 5
          //   2391: aload 5
          //   2393: aload_1
          //   2394: aload 4
          //   2396: invokestatic 545	com/tencent/mm/plugin/webview/ui/tools/browser/b:a	(Landroid/app/Activity;Landroid/content/Intent;Ljava/lang/String;)Landroid/content/Intent;
          //   2399: bipush 6
          //   2401: invokevirtual 549	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:startActivityForResult	(Landroid/content/Intent;I)V
          //   2404: ldc 28
          //   2406: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2409: return
          //   2410: aload_0
          //   2411: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2414: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2417: getfield 160	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IMs	Lcom/tencent/mm/plugin/webview/model/az;
          //   2420: invokevirtual 166	com/tencent/mm/plugin/webview/model/az:gdh	()Lcom/tencent/mm/plugin/webview/model/az$d;
          //   2423: iconst_3
          //   2424: anewarray 4	java/lang/Object
          //   2427: dup
          //   2428: iconst_0
          //   2429: aload_0
          //   2430: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2433: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2436: invokevirtual 169	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:coX	()Ljava/lang/String;
          //   2439: aastore
          //   2440: dup
          //   2441: iconst_1
          //   2442: bipush 39
          //   2444: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2447: aastore
          //   2448: dup
          //   2449: iconst_2
          //   2450: iconst_1
          //   2451: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2454: aastore
          //   2455: invokevirtual 175	com/tencent/mm/plugin/webview/model/az$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/az$d;
          //   2458: invokevirtual 178	com/tencent/mm/plugin/webview/model/az$d:report	()V
          //   2461: aload_0
          //   2462: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2465: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2468: astore 5
          //   2470: aload_0
          //   2471: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2474: getfield 553	com/tencent/mm/plugin/webview/ui/tools/j:Jgn	Lcom/tencent/mm/plugin/webview/ui/tools/browser/f;
          //   2477: getfield 559	com/tencent/mm/plugin/webview/ui/tools/browser/f:resolveInfo	Landroid/content/pm/ResolveInfo;
          //   2480: astore 6
          //   2482: aload 5
          //   2484: getfield 408	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:mHh	Lcom/tencent/mm/plugin/webview/stub/e;
          //   2487: astore 7
          //   2489: aload 5
          //   2491: invokevirtual 411	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:isFinishing	()Z
          //   2494: ifne +123 -> 2617
          //   2497: aload 5
          //   2499: invokevirtual 425	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:fZM	()Ljava/lang/String;
          //   2502: astore 4
          //   2504: aload 4
          //   2506: invokestatic 192	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
          //   2509: ifeq +18 -> 2527
          //   2512: ldc_w 427
          //   2515: ldc_w 429
          //   2518: invokestatic 78	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   2521: ldc 28
          //   2523: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2526: return
          //   2527: aload 4
          //   2529: astore_1
          //   2530: aload 7
          //   2532: ifnull +13 -> 2545
          //   2535: aload 7
          //   2537: aload 4
          //   2539: invokeinterface 432 2 0
          //   2544: astore_1
          //   2545: aload_1
          //   2546: astore 4
          //   2548: aload_1
          //   2549: ldc_w 434
          //   2552: invokevirtual 437	java/lang/String:startsWith	(Ljava/lang/String;)Z
          //   2555: ifne +28 -> 2583
          //   2558: aload_1
          //   2559: astore 4
          //   2561: aload_1
          //   2562: ldc_w 439
          //   2565: invokevirtual 437	java/lang/String:startsWith	(Ljava/lang/String;)Z
          //   2568: ifne +15 -> 2583
          //   2571: ldc_w 434
          //   2574: aload_1
          //   2575: invokestatic 442	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
          //   2578: invokevirtual 445	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
          //   2581: astore 4
          //   2583: new 242	android/content/Intent
          //   2586: dup
          //   2587: ldc_w 447
          //   2590: aload 4
          //   2592: invokestatic 453	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
          //   2595: invokespecial 456	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
          //   2598: astore_1
          //   2599: aload_1
          //   2600: ldc_w 561
          //   2603: aload 4
          //   2605: invokevirtual 265	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
          //   2608: pop
          //   2609: aload 5
          //   2611: aload_1
          //   2612: aload 6
          //   2614: invokestatic 564	com/tencent/mm/plugin/webview/ui/tools/browser/b:a	(Landroid/content/Context;Landroid/content/Intent;Landroid/content/pm/ResolveInfo;)V
          //   2617: ldc 28
          //   2619: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2622: return
          //   2623: astore_1
          //   2624: ldc_w 427
          //   2627: ldc_w 503
          //   2630: iconst_1
          //   2631: anewarray 4	java/lang/Object
          //   2634: dup
          //   2635: iconst_0
          //   2636: aload_1
          //   2637: aastore
          //   2638: invokestatic 501	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   2641: aload 4
          //   2643: astore_1
          //   2644: goto -99 -> 2545
          //   2647: aload_0
          //   2648: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2651: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2654: getfield 160	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IMs	Lcom/tencent/mm/plugin/webview/model/az;
          //   2657: invokevirtual 166	com/tencent/mm/plugin/webview/model/az:gdh	()Lcom/tencent/mm/plugin/webview/model/az$d;
          //   2660: iconst_3
          //   2661: anewarray 4	java/lang/Object
          //   2664: dup
          //   2665: iconst_0
          //   2666: aload_0
          //   2667: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2670: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2673: invokevirtual 169	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:coX	()Ljava/lang/String;
          //   2676: aastore
          //   2677: dup
          //   2678: iconst_1
          //   2679: bipush 35
          //   2681: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2684: aastore
          //   2685: dup
          //   2686: iconst_2
          //   2687: iconst_1
          //   2688: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2691: aastore
          //   2692: invokevirtual 175	com/tencent/mm/plugin/webview/model/az$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/az$d;
          //   2695: invokevirtual 178	com/tencent/mm/plugin/webview/model/az$d:report	()V
          //   2698: aload_0
          //   2699: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2702: invokestatic 567	com/tencent/mm/plugin/webview/ui/tools/j:c	(Lcom/tencent/mm/plugin/webview/ui/tools/j;)V
          //   2705: ldc 28
          //   2707: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2710: return
          //   2711: aload_0
          //   2712: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2715: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2718: getfield 160	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IMs	Lcom/tencent/mm/plugin/webview/model/az;
          //   2721: invokevirtual 166	com/tencent/mm/plugin/webview/model/az:gdh	()Lcom/tencent/mm/plugin/webview/model/az$d;
          //   2724: iconst_3
          //   2725: anewarray 4	java/lang/Object
          //   2728: dup
          //   2729: iconst_0
          //   2730: aload_0
          //   2731: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2734: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2737: invokevirtual 169	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:coX	()Ljava/lang/String;
          //   2740: aastore
          //   2741: dup
          //   2742: iconst_1
          //   2743: bipush 15
          //   2745: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2748: aastore
          //   2749: dup
          //   2750: iconst_2
          //   2751: iconst_1
          //   2752: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2755: aastore
          //   2756: invokevirtual 175	com/tencent/mm/plugin/webview/model/az$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/az$d;
          //   2759: invokevirtual 178	com/tencent/mm/plugin/webview/model/az$d:report	()V
          //   2762: aload_0
          //   2763: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2766: astore_1
          //   2767: aload_1
          //   2768: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2771: getfield 63	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IBw	Lcom/tencent/mm/plugin/webview/d/h;
          //   2774: ldc_w 569
          //   2777: iconst_1
          //   2778: invokevirtual 573	com/tencent/mm/plugin/webview/d/h:cL	(Ljava/lang/String;Z)V
          //   2781: aload_1
          //   2782: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2785: getfield 63	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IBw	Lcom/tencent/mm/plugin/webview/d/h;
          //   2788: astore_1
          //   2789: aload_1
          //   2790: getfield 69	com/tencent/mm/plugin/webview/d/h:GBl	Z
          //   2793: ifne +17 -> 2810
          //   2796: ldc 71
          //   2798: ldc_w 575
          //   2801: invokestatic 78	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   2804: ldc 28
          //   2806: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2809: return
          //   2810: ldc_w 577
          //   2813: new 84	java/util/HashMap
          //   2816: dup
          //   2817: invokespecial 85	java/util/HashMap:<init>	()V
          //   2820: aload_1
          //   2821: getfield 103	com/tencent/mm/plugin/webview/d/h:IRj	Z
          //   2824: aload_1
          //   2825: getfield 106	com/tencent/mm/plugin/webview/d/h:zpY	Ljava/lang/String;
          //   2828: invokestatic 112	com/tencent/mm/plugin/webview/d/n$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   2831: astore 4
          //   2833: aload_1
          //   2834: getfield 116	com/tencent/mm/plugin/webview/d/h:IRa	Lcom/tencent/mm/ui/widget/MMWebView;
          //   2837: new 118	java/lang/StringBuilder
          //   2840: dup
          //   2841: ldc 120
          //   2843: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   2846: aload 4
          //   2848: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   2851: ldc 129
          //   2853: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   2856: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   2859: aconst_null
          //   2860: invokevirtual 139	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   2863: ldc 28
          //   2865: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2868: return
          //   2869: aload_0
          //   2870: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2873: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2876: getfield 160	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IMs	Lcom/tencent/mm/plugin/webview/model/az;
          //   2879: invokevirtual 166	com/tencent/mm/plugin/webview/model/az:gdh	()Lcom/tencent/mm/plugin/webview/model/az$d;
          //   2882: iconst_3
          //   2883: anewarray 4	java/lang/Object
          //   2886: dup
          //   2887: iconst_0
          //   2888: aload_0
          //   2889: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2892: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2895: invokevirtual 169	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:coX	()Ljava/lang/String;
          //   2898: aastore
          //   2899: dup
          //   2900: iconst_1
          //   2901: bipush 7
          //   2903: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2906: aastore
          //   2907: dup
          //   2908: iconst_2
          //   2909: iconst_1
          //   2910: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2913: aastore
          //   2914: invokevirtual 175	com/tencent/mm/plugin/webview/model/az$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/az$d;
          //   2917: invokevirtual 178	com/tencent/mm/plugin/webview/model/az$d:report	()V
          //   2920: aload_0
          //   2921: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2924: astore_1
          //   2925: aload_1
          //   2926: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2929: aload_1
          //   2930: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2933: ldc_w 578
          //   2936: invokevirtual 582	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   2939: aconst_null
          //   2940: aconst_null
          //   2941: aload_1
          //   2942: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2945: ldc_w 583
          //   2948: invokevirtual 582	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   2951: new 585	com/tencent/mm/plugin/webview/ui/tools/j$14
          //   2954: dup
          //   2955: aload_1
          //   2956: invokespecial 587	com/tencent/mm/plugin/webview/ui/tools/j$14:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/j;)V
          //   2959: invokestatic 592	com/tencent/mm/ui/base/h:a	(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lcom/tencent/mm/ui/base/h$e;)Landroid/app/Dialog;
          //   2962: pop
          //   2963: ldc 28
          //   2965: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2968: return
          //   2969: aload_0
          //   2970: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2973: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2976: getfield 160	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IMs	Lcom/tencent/mm/plugin/webview/model/az;
          //   2979: invokevirtual 166	com/tencent/mm/plugin/webview/model/az:gdh	()Lcom/tencent/mm/plugin/webview/model/az$d;
          //   2982: iconst_3
          //   2983: anewarray 4	java/lang/Object
          //   2986: dup
          //   2987: iconst_0
          //   2988: aload_0
          //   2989: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   2992: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2995: invokevirtual 169	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:coX	()Ljava/lang/String;
          //   2998: aastore
          //   2999: dup
          //   3000: iconst_1
          //   3001: bipush 11
          //   3003: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3006: aastore
          //   3007: dup
          //   3008: iconst_2
          //   3009: iconst_1
          //   3010: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3013: aastore
          //   3014: invokevirtual 175	com/tencent/mm/plugin/webview/model/az$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/az$d;
          //   3017: invokevirtual 178	com/tencent/mm/plugin/webview/model/az$d:report	()V
          //   3020: aload_0
          //   3021: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   3024: aconst_null
          //   3025: invokevirtual 595	com/tencent/mm/plugin/webview/ui/tools/j:ban	(Ljava/lang/String;)V
          //   3028: ldc 28
          //   3030: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3033: return
          //   3034: aload_0
          //   3035: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   3038: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3041: getfield 160	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IMs	Lcom/tencent/mm/plugin/webview/model/az;
          //   3044: invokevirtual 166	com/tencent/mm/plugin/webview/model/az:gdh	()Lcom/tencent/mm/plugin/webview/model/az$d;
          //   3047: iconst_3
          //   3048: anewarray 4	java/lang/Object
          //   3051: dup
          //   3052: iconst_0
          //   3053: aload_0
          //   3054: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   3057: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3060: invokevirtual 169	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:coX	()Ljava/lang/String;
          //   3063: aastore
          //   3064: dup
          //   3065: iconst_1
          //   3066: bipush 6
          //   3068: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3071: aastore
          //   3072: dup
          //   3073: iconst_2
          //   3074: iconst_1
          //   3075: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3078: aastore
          //   3079: invokevirtual 175	com/tencent/mm/plugin/webview/model/az$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/az$d;
          //   3082: invokevirtual 178	com/tencent/mm/plugin/webview/model/az$d:report	()V
          //   3085: new 242	android/content/Intent
          //   3088: dup
          //   3089: invokespecial 254	android/content/Intent:<init>	()V
          //   3092: astore_1
          //   3093: aload_1
          //   3094: ldc_w 597
          //   3097: iconst_2
          //   3098: invokevirtual 600	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
          //   3101: pop
          //   3102: aload_1
          //   3103: ldc_w 602
          //   3106: aload_0
          //   3107: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   3110: invokevirtual 234	com/tencent/mm/plugin/webview/ui/tools/a:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3113: invokevirtual 238	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   3116: ldc_w 604
          //   3119: ldc2_w 605
          //   3122: invokevirtual 283	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
          //   3125: invokevirtual 609	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
          //   3128: pop
          //   3129: aload_0
          //   3130: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   3133: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3136: ldc_w 611
          //   3139: aload_1
          //   3140: invokestatic 615	com/tencent/mm/plugin/fav/a/b:b	(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V
          //   3143: aload_0
          //   3144: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   3147: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3150: getfield 160	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IMs	Lcom/tencent/mm/plugin/webview/model/az;
          //   3153: ldc_w 617
          //   3156: invokevirtual 620	com/tencent/mm/plugin/webview/model/az:aZc	(Ljava/lang/String;)V
          //   3159: ldc 28
          //   3161: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3164: return
          //   3165: aload_0
          //   3166: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   3169: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3172: getfield 160	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IMs	Lcom/tencent/mm/plugin/webview/model/az;
          //   3175: invokevirtual 166	com/tencent/mm/plugin/webview/model/az:gdh	()Lcom/tencent/mm/plugin/webview/model/az$d;
          //   3178: iconst_3
          //   3179: anewarray 4	java/lang/Object
          //   3182: dup
          //   3183: iconst_0
          //   3184: aload_0
          //   3185: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   3188: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3191: invokevirtual 169	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:coX	()Ljava/lang/String;
          //   3194: aastore
          //   3195: dup
          //   3196: iconst_1
          //   3197: bipush 19
          //   3199: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3202: aastore
          //   3203: dup
          //   3204: iconst_2
          //   3205: iconst_1
          //   3206: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3209: aastore
          //   3210: invokevirtual 175	com/tencent/mm/plugin/webview/model/az$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/az$d;
          //   3213: invokevirtual 178	com/tencent/mm/plugin/webview/model/az$d:report	()V
          //   3216: aload_0
          //   3217: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   3220: aload_1
          //   3221: invokestatic 623	com/tencent/mm/plugin/webview/ui/tools/j:a	(Lcom/tencent/mm/plugin/webview/ui/tools/j;Landroid/view/MenuItem;)V
          //   3224: ldc 28
          //   3226: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3229: return
          //   3230: aload_0
          //   3231: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   3234: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3237: getfield 160	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IMs	Lcom/tencent/mm/plugin/webview/model/az;
          //   3240: invokevirtual 166	com/tencent/mm/plugin/webview/model/az:gdh	()Lcom/tencent/mm/plugin/webview/model/az$d;
          //   3243: iconst_3
          //   3244: anewarray 4	java/lang/Object
          //   3247: dup
          //   3248: iconst_0
          //   3249: aload_0
          //   3250: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   3253: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3256: invokevirtual 169	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:coX	()Ljava/lang/String;
          //   3259: aastore
          //   3260: dup
          //   3261: iconst_1
          //   3262: bipush 21
          //   3264: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3267: aastore
          //   3268: dup
          //   3269: iconst_2
          //   3270: iconst_1
          //   3271: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3274: aastore
          //   3275: invokevirtual 175	com/tencent/mm/plugin/webview/model/az$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/az$d;
          //   3278: invokevirtual 178	com/tencent/mm/plugin/webview/model/az$d:report	()V
          //   3281: aload_0
          //   3282: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   3285: aload_1
          //   3286: invokestatic 623	com/tencent/mm/plugin/webview/ui/tools/j:a	(Lcom/tencent/mm/plugin/webview/ui/tools/j;Landroid/view/MenuItem;)V
          //   3289: ldc 28
          //   3291: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3294: return
          //   3295: aload_0
          //   3296: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   3299: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3302: getfield 160	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IMs	Lcom/tencent/mm/plugin/webview/model/az;
          //   3305: invokevirtual 166	com/tencent/mm/plugin/webview/model/az:gdh	()Lcom/tencent/mm/plugin/webview/model/az$d;
          //   3308: iconst_3
          //   3309: anewarray 4	java/lang/Object
          //   3312: dup
          //   3313: iconst_0
          //   3314: aload_0
          //   3315: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   3318: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3321: invokevirtual 169	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:coX	()Ljava/lang/String;
          //   3324: aastore
          //   3325: dup
          //   3326: iconst_1
          //   3327: bipush 20
          //   3329: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3332: aastore
          //   3333: dup
          //   3334: iconst_2
          //   3335: iconst_1
          //   3336: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3339: aastore
          //   3340: invokevirtual 175	com/tencent/mm/plugin/webview/model/az$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/az$d;
          //   3343: invokevirtual 178	com/tencent/mm/plugin/webview/model/az$d:report	()V
          //   3346: aload_0
          //   3347: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   3350: aload_1
          //   3351: invokestatic 623	com/tencent/mm/plugin/webview/ui/tools/j:a	(Lcom/tencent/mm/plugin/webview/ui/tools/j;Landroid/view/MenuItem;)V
          //   3354: ldc 28
          //   3356: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3359: return
          //   3360: aload_0
          //   3361: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   3364: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3367: getfield 160	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IMs	Lcom/tencent/mm/plugin/webview/model/az;
          //   3370: invokevirtual 166	com/tencent/mm/plugin/webview/model/az:gdh	()Lcom/tencent/mm/plugin/webview/model/az$d;
          //   3373: iconst_3
          //   3374: anewarray 4	java/lang/Object
          //   3377: dup
          //   3378: iconst_0
          //   3379: aload_0
          //   3380: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   3383: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3386: invokevirtual 169	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:coX	()Ljava/lang/String;
          //   3389: aastore
          //   3390: dup
          //   3391: iconst_1
          //   3392: bipush 22
          //   3394: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3397: aastore
          //   3398: dup
          //   3399: iconst_2
          //   3400: iconst_1
          //   3401: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3404: aastore
          //   3405: invokevirtual 175	com/tencent/mm/plugin/webview/model/az$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/az$d;
          //   3408: invokevirtual 178	com/tencent/mm/plugin/webview/model/az$d:report	()V
          //   3411: aload_0
          //   3412: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   3415: aload_1
          //   3416: invokestatic 623	com/tencent/mm/plugin/webview/ui/tools/j:a	(Lcom/tencent/mm/plugin/webview/ui/tools/j;Landroid/view/MenuItem;)V
          //   3419: ldc 28
          //   3421: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3424: return
          //   3425: aload_0
          //   3426: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   3429: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3432: getfield 160	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IMs	Lcom/tencent/mm/plugin/webview/model/az;
          //   3435: invokevirtual 166	com/tencent/mm/plugin/webview/model/az:gdh	()Lcom/tencent/mm/plugin/webview/model/az$d;
          //   3438: iconst_3
          //   3439: anewarray 4	java/lang/Object
          //   3442: dup
          //   3443: iconst_0
          //   3444: aload_0
          //   3445: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   3448: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3451: invokevirtual 169	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:coX	()Ljava/lang/String;
          //   3454: aastore
          //   3455: dup
          //   3456: iconst_1
          //   3457: bipush 23
          //   3459: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3462: aastore
          //   3463: dup
          //   3464: iconst_2
          //   3465: iconst_1
          //   3466: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3469: aastore
          //   3470: invokevirtual 175	com/tencent/mm/plugin/webview/model/az$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/az$d;
          //   3473: invokevirtual 178	com/tencent/mm/plugin/webview/model/az$d:report	()V
          //   3476: aload_0
          //   3477: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   3480: aload_1
          //   3481: invokestatic 623	com/tencent/mm/plugin/webview/ui/tools/j:a	(Lcom/tencent/mm/plugin/webview/ui/tools/j;Landroid/view/MenuItem;)V
          //   3484: ldc 28
          //   3486: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3489: return
          //   3490: aload_0
          //   3491: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   3494: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3497: getfield 160	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IMs	Lcom/tencent/mm/plugin/webview/model/az;
          //   3500: invokevirtual 166	com/tencent/mm/plugin/webview/model/az:gdh	()Lcom/tencent/mm/plugin/webview/model/az$d;
          //   3503: iconst_3
          //   3504: anewarray 4	java/lang/Object
          //   3507: dup
          //   3508: iconst_0
          //   3509: aload_0
          //   3510: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   3513: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3516: invokevirtual 169	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:coX	()Ljava/lang/String;
          //   3519: aastore
          //   3520: dup
          //   3521: iconst_1
          //   3522: bipush 26
          //   3524: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3527: aastore
          //   3528: dup
          //   3529: iconst_2
          //   3530: iconst_1
          //   3531: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3534: aastore
          //   3535: invokevirtual 175	com/tencent/mm/plugin/webview/model/az$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/az$d;
          //   3538: invokevirtual 178	com/tencent/mm/plugin/webview/model/az$d:report	()V
          //   3541: aload_0
          //   3542: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   3545: astore 4
          //   3547: aload_1
          //   3548: invokeinterface 147 1 0
          //   3553: istore_2
          //   3554: aload 4
          //   3556: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3559: getfield 63	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IBw	Lcom/tencent/mm/plugin/webview/d/h;
          //   3562: ldc_w 625
          //   3565: iconst_1
          //   3566: invokevirtual 573	com/tencent/mm/plugin/webview/d/h:cL	(Ljava/lang/String;Z)V
          //   3569: aload 4
          //   3571: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3574: getfield 63	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IBw	Lcom/tencent/mm/plugin/webview/d/h;
          //   3577: astore 4
          //   3579: iload_2
          //   3580: bipush 43
          //   3582: if_icmpne +29 -> 3611
          //   3585: ldc_w 627
          //   3588: astore_1
          //   3589: aload 4
          //   3591: getfield 69	com/tencent/mm/plugin/webview/d/h:GBl	Z
          //   3594: ifne +24 -> 3618
          //   3597: ldc 71
          //   3599: ldc_w 629
          //   3602: invokestatic 78	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   3605: ldc 28
          //   3607: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3610: return
          //   3611: ldc_w 631
          //   3614: astore_1
          //   3615: goto -26 -> 3589
          //   3618: ldc_w 633
          //   3621: new 84	java/util/HashMap
          //   3624: dup
          //   3625: invokespecial 85	java/util/HashMap:<init>	()V
          //   3628: aload 4
          //   3630: getfield 103	com/tencent/mm/plugin/webview/d/h:IRj	Z
          //   3633: aload 4
          //   3635: getfield 106	com/tencent/mm/plugin/webview/d/h:zpY	Ljava/lang/String;
          //   3638: invokestatic 112	com/tencent/mm/plugin/webview/d/n$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   3641: astore 5
          //   3643: aload 4
          //   3645: getfield 116	com/tencent/mm/plugin/webview/d/h:IRa	Lcom/tencent/mm/ui/widget/MMWebView;
          //   3648: new 118	java/lang/StringBuilder
          //   3651: dup
          //   3652: ldc 120
          //   3654: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   3657: aload 5
          //   3659: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3662: ldc 129
          //   3664: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3667: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   3670: aconst_null
          //   3671: invokevirtual 139	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   3674: aload 4
          //   3676: getfield 634	com/tencent/mm/plugin/webview/d/h:mHh	Lcom/tencent/mm/plugin/webview/stub/e;
          //   3679: ldc_w 636
          //   3682: aload_1
          //   3683: aload 4
          //   3685: getfield 640	com/tencent/mm/plugin/webview/d/h:IRl	I
          //   3688: invokeinterface 644 4 0
          //   3693: ldc 28
          //   3695: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3698: return
          //   3699: astore_1
          //   3700: ldc 71
          //   3702: new 118	java/lang/StringBuilder
          //   3705: dup
          //   3706: ldc_w 646
          //   3709: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   3712: aload_1
          //   3713: invokevirtual 499	java/lang/Exception:getMessage	()Ljava/lang/String;
          //   3716: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3719: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   3722: invokestatic 649	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
          //   3725: ldc 28
          //   3727: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3730: return
          //   3731: aload_0
          //   3732: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   3735: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3738: getfield 160	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IMs	Lcom/tencent/mm/plugin/webview/model/az;
          //   3741: invokevirtual 166	com/tencent/mm/plugin/webview/model/az:gdh	()Lcom/tencent/mm/plugin/webview/model/az$d;
          //   3744: iconst_3
          //   3745: anewarray 4	java/lang/Object
          //   3748: dup
          //   3749: iconst_0
          //   3750: aload_0
          //   3751: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   3754: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3757: invokevirtual 169	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:coX	()Ljava/lang/String;
          //   3760: aastore
          //   3761: dup
          //   3762: iconst_1
          //   3763: bipush 27
          //   3765: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3768: aastore
          //   3769: dup
          //   3770: iconst_2
          //   3771: iconst_1
          //   3772: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3775: aastore
          //   3776: invokevirtual 175	com/tencent/mm/plugin/webview/model/az$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/az$d;
          //   3779: invokevirtual 178	com/tencent/mm/plugin/webview/model/az$d:report	()V
          //   3782: aload_0
          //   3783: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   3786: invokestatic 652	com/tencent/mm/plugin/webview/ui/tools/j:d	(Lcom/tencent/mm/plugin/webview/ui/tools/j;)V
          //   3789: ldc 28
          //   3791: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3794: return
          //   3795: aload_0
          //   3796: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   3799: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3802: getfield 160	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IMs	Lcom/tencent/mm/plugin/webview/model/az;
          //   3805: invokevirtual 166	com/tencent/mm/plugin/webview/model/az:gdh	()Lcom/tencent/mm/plugin/webview/model/az$d;
          //   3808: iconst_3
          //   3809: anewarray 4	java/lang/Object
          //   3812: dup
          //   3813: iconst_0
          //   3814: aload_0
          //   3815: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   3818: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3821: invokevirtual 169	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:coX	()Ljava/lang/String;
          //   3824: aastore
          //   3825: dup
          //   3826: iconst_1
          //   3827: bipush 17
          //   3829: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3832: aastore
          //   3833: dup
          //   3834: iconst_2
          //   3835: iconst_1
          //   3836: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3839: aastore
          //   3840: invokevirtual 175	com/tencent/mm/plugin/webview/model/az$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/az$d;
          //   3843: invokevirtual 178	com/tencent/mm/plugin/webview/model/az$d:report	()V
          //   3846: aload_0
          //   3847: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   3850: astore_1
          //   3851: aload_1
          //   3852: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3855: getfield 63	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IBw	Lcom/tencent/mm/plugin/webview/d/h;
          //   3858: ldc_w 654
          //   3861: iconst_1
          //   3862: invokevirtual 573	com/tencent/mm/plugin/webview/d/h:cL	(Ljava/lang/String;Z)V
          //   3865: aload_1
          //   3866: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3869: getfield 63	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IBw	Lcom/tencent/mm/plugin/webview/d/h;
          //   3872: astore_1
          //   3873: aload_1
          //   3874: getfield 69	com/tencent/mm/plugin/webview/d/h:GBl	Z
          //   3877: ifne +17 -> 3894
          //   3880: ldc 71
          //   3882: ldc_w 656
          //   3885: invokestatic 78	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   3888: ldc 28
          //   3890: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3893: return
          //   3894: aload_1
          //   3895: iconst_1
          //   3896: invokevirtual 660	com/tencent/mm/plugin/webview/d/h:afU	(I)Landroid/os/Bundle;
          //   3899: astore 4
          //   3901: aload 4
          //   3903: ifnull +30 -> 3933
          //   3906: aload 4
          //   3908: ldc_w 662
          //   3911: iconst_0
          //   3912: invokevirtual 666	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
          //   3915: ifeq +18 -> 3933
          //   3918: aload_1
          //   3919: aload 4
          //   3921: ldc_w 654
          //   3924: invokevirtual 669	com/tencent/mm/plugin/webview/d/h:i	(Landroid/os/Bundle;Ljava/lang/String;)V
          //   3927: ldc 28
          //   3929: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3932: return
          //   3933: ldc_w 671
          //   3936: new 84	java/util/HashMap
          //   3939: dup
          //   3940: invokespecial 85	java/util/HashMap:<init>	()V
          //   3943: aload_1
          //   3944: getfield 103	com/tencent/mm/plugin/webview/d/h:IRj	Z
          //   3947: aload_1
          //   3948: getfield 106	com/tencent/mm/plugin/webview/d/h:zpY	Ljava/lang/String;
          //   3951: invokestatic 112	com/tencent/mm/plugin/webview/d/n$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   3954: astore 4
          //   3956: aload_1
          //   3957: getfield 116	com/tencent/mm/plugin/webview/d/h:IRa	Lcom/tencent/mm/ui/widget/MMWebView;
          //   3960: new 118	java/lang/StringBuilder
          //   3963: dup
          //   3964: ldc 120
          //   3966: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   3969: aload 4
          //   3971: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3974: ldc 129
          //   3976: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3979: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   3982: aconst_null
          //   3983: invokevirtual 139	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   3986: ldc 28
          //   3988: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3991: return
          //   3992: aload_0
          //   3993: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   3996: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3999: getfield 160	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IMs	Lcom/tencent/mm/plugin/webview/model/az;
          //   4002: invokevirtual 166	com/tencent/mm/plugin/webview/model/az:gdh	()Lcom/tencent/mm/plugin/webview/model/az$d;
          //   4005: iconst_3
          //   4006: anewarray 4	java/lang/Object
          //   4009: dup
          //   4010: iconst_0
          //   4011: aload_0
          //   4012: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   4015: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4018: invokevirtual 169	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:coX	()Ljava/lang/String;
          //   4021: aastore
          //   4022: dup
          //   4023: iconst_1
          //   4024: bipush 18
          //   4026: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4029: aastore
          //   4030: dup
          //   4031: iconst_2
          //   4032: iconst_1
          //   4033: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4036: aastore
          //   4037: invokevirtual 175	com/tencent/mm/plugin/webview/model/az$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/az$d;
          //   4040: invokevirtual 178	com/tencent/mm/plugin/webview/model/az$d:report	()V
          //   4043: aload_0
          //   4044: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   4047: astore_1
          //   4048: aload_1
          //   4049: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4052: getfield 63	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IBw	Lcom/tencent/mm/plugin/webview/d/h;
          //   4055: ldc_w 673
          //   4058: iconst_1
          //   4059: invokevirtual 573	com/tencent/mm/plugin/webview/d/h:cL	(Ljava/lang/String;Z)V
          //   4062: aload_1
          //   4063: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4066: getfield 63	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IBw	Lcom/tencent/mm/plugin/webview/d/h;
          //   4069: astore_1
          //   4070: aload_1
          //   4071: getfield 69	com/tencent/mm/plugin/webview/d/h:GBl	Z
          //   4074: ifne +17 -> 4091
          //   4077: ldc 71
          //   4079: ldc_w 675
          //   4082: invokestatic 78	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   4085: ldc 28
          //   4087: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4090: return
          //   4091: ldc_w 677
          //   4094: new 84	java/util/HashMap
          //   4097: dup
          //   4098: invokespecial 85	java/util/HashMap:<init>	()V
          //   4101: aload_1
          //   4102: getfield 103	com/tencent/mm/plugin/webview/d/h:IRj	Z
          //   4105: aload_1
          //   4106: getfield 106	com/tencent/mm/plugin/webview/d/h:zpY	Ljava/lang/String;
          //   4109: invokestatic 112	com/tencent/mm/plugin/webview/d/n$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   4112: astore 4
          //   4114: aload_1
          //   4115: getfield 116	com/tencent/mm/plugin/webview/d/h:IRa	Lcom/tencent/mm/ui/widget/MMWebView;
          //   4118: new 118	java/lang/StringBuilder
          //   4121: dup
          //   4122: ldc 120
          //   4124: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   4127: aload 4
          //   4129: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   4132: ldc 129
          //   4134: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   4137: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   4140: aconst_null
          //   4141: invokevirtual 139	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   4144: ldc 28
          //   4146: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4149: return
          //   4150: aload_0
          //   4151: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   4154: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4157: getfield 160	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IMs	Lcom/tencent/mm/plugin/webview/model/az;
          //   4160: invokevirtual 166	com/tencent/mm/plugin/webview/model/az:gdh	()Lcom/tencent/mm/plugin/webview/model/az$d;
          //   4163: iconst_3
          //   4164: anewarray 4	java/lang/Object
          //   4167: dup
          //   4168: iconst_0
          //   4169: aload_0
          //   4170: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   4173: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4176: invokevirtual 169	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:coX	()Ljava/lang/String;
          //   4179: aastore
          //   4180: dup
          //   4181: iconst_1
          //   4182: bipush 24
          //   4184: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4187: aastore
          //   4188: dup
          //   4189: iconst_2
          //   4190: iconst_1
          //   4191: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4194: aastore
          //   4195: invokevirtual 175	com/tencent/mm/plugin/webview/model/az$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/az$d;
          //   4198: invokevirtual 178	com/tencent/mm/plugin/webview/model/az$d:report	()V
          //   4201: aload_0
          //   4202: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   4205: astore_1
          //   4206: aload_1
          //   4207: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4210: getfield 63	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IBw	Lcom/tencent/mm/plugin/webview/d/h;
          //   4213: ldc_w 679
          //   4216: iconst_1
          //   4217: invokevirtual 573	com/tencent/mm/plugin/webview/d/h:cL	(Ljava/lang/String;Z)V
          //   4220: aload_1
          //   4221: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4224: getfield 63	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IBw	Lcom/tencent/mm/plugin/webview/d/h;
          //   4227: astore_1
          //   4228: aload_1
          //   4229: getfield 69	com/tencent/mm/plugin/webview/d/h:GBl	Z
          //   4232: ifne +17 -> 4249
          //   4235: ldc 71
          //   4237: ldc_w 681
          //   4240: invokestatic 78	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   4243: ldc 28
          //   4245: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4248: return
          //   4249: aload_1
          //   4250: iconst_1
          //   4251: invokevirtual 660	com/tencent/mm/plugin/webview/d/h:afU	(I)Landroid/os/Bundle;
          //   4254: astore 4
          //   4256: aload 4
          //   4258: ifnull +30 -> 4288
          //   4261: aload 4
          //   4263: ldc_w 662
          //   4266: iconst_0
          //   4267: invokevirtual 666	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
          //   4270: ifeq +18 -> 4288
          //   4273: aload_1
          //   4274: aload 4
          //   4276: ldc_w 679
          //   4279: invokevirtual 669	com/tencent/mm/plugin/webview/d/h:i	(Landroid/os/Bundle;Ljava/lang/String;)V
          //   4282: ldc 28
          //   4284: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4287: return
          //   4288: ldc_w 683
          //   4291: new 84	java/util/HashMap
          //   4294: dup
          //   4295: invokespecial 85	java/util/HashMap:<init>	()V
          //   4298: aload_1
          //   4299: getfield 103	com/tencent/mm/plugin/webview/d/h:IRj	Z
          //   4302: aload_1
          //   4303: getfield 106	com/tencent/mm/plugin/webview/d/h:zpY	Ljava/lang/String;
          //   4306: invokestatic 112	com/tencent/mm/plugin/webview/d/n$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   4309: astore 4
          //   4311: aload_1
          //   4312: getfield 116	com/tencent/mm/plugin/webview/d/h:IRa	Lcom/tencent/mm/ui/widget/MMWebView;
          //   4315: new 118	java/lang/StringBuilder
          //   4318: dup
          //   4319: ldc 120
          //   4321: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   4324: aload 4
          //   4326: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   4329: ldc 129
          //   4331: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   4334: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   4337: aconst_null
          //   4338: invokevirtual 139	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   4341: ldc 28
          //   4343: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4346: return
          //   4347: aload_0
          //   4348: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   4351: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4354: getfield 160	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IMs	Lcom/tencent/mm/plugin/webview/model/az;
          //   4357: invokevirtual 166	com/tencent/mm/plugin/webview/model/az:gdh	()Lcom/tencent/mm/plugin/webview/model/az$d;
          //   4360: iconst_3
          //   4361: anewarray 4	java/lang/Object
          //   4364: dup
          //   4365: iconst_0
          //   4366: aload_0
          //   4367: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   4370: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4373: invokevirtual 169	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:coX	()Ljava/lang/String;
          //   4376: aastore
          //   4377: dup
          //   4378: iconst_1
          //   4379: bipush 14
          //   4381: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4384: aastore
          //   4385: dup
          //   4386: iconst_2
          //   4387: iconst_1
          //   4388: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4391: aastore
          //   4392: invokevirtual 175	com/tencent/mm/plugin/webview/model/az$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/az$d;
          //   4395: invokevirtual 178	com/tencent/mm/plugin/webview/model/az$d:report	()V
          //   4398: aload_0
          //   4399: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   4402: astore_1
          //   4403: aload_1
          //   4404: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4407: getfield 63	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IBw	Lcom/tencent/mm/plugin/webview/d/h;
          //   4410: ldc_w 625
          //   4413: iconst_1
          //   4414: invokevirtual 573	com/tencent/mm/plugin/webview/d/h:cL	(Ljava/lang/String;Z)V
          //   4417: aload_1
          //   4418: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4421: getfield 63	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IBw	Lcom/tencent/mm/plugin/webview/d/h;
          //   4424: astore_1
          //   4425: aload_1
          //   4426: getfield 69	com/tencent/mm/plugin/webview/d/h:GBl	Z
          //   4429: ifne +17 -> 4446
          //   4432: ldc 71
          //   4434: ldc_w 685
          //   4437: invokestatic 78	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   4440: ldc 28
          //   4442: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4445: return
          //   4446: ldc_w 633
          //   4449: new 84	java/util/HashMap
          //   4452: dup
          //   4453: invokespecial 85	java/util/HashMap:<init>	()V
          //   4456: aload_1
          //   4457: getfield 103	com/tencent/mm/plugin/webview/d/h:IRj	Z
          //   4460: aload_1
          //   4461: getfield 106	com/tencent/mm/plugin/webview/d/h:zpY	Ljava/lang/String;
          //   4464: invokestatic 112	com/tencent/mm/plugin/webview/d/n$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   4467: astore 4
          //   4469: aload_1
          //   4470: getfield 116	com/tencent/mm/plugin/webview/d/h:IRa	Lcom/tencent/mm/ui/widget/MMWebView;
          //   4473: new 118	java/lang/StringBuilder
          //   4476: dup
          //   4477: ldc 120
          //   4479: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   4482: aload 4
          //   4484: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   4487: ldc 129
          //   4489: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   4492: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   4495: aconst_null
          //   4496: invokevirtual 139	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   4499: aload_1
          //   4500: getfield 634	com/tencent/mm/plugin/webview/d/h:mHh	Lcom/tencent/mm/plugin/webview/stub/e;
          //   4503: ldc_w 636
          //   4506: ldc_w 687
          //   4509: aload_1
          //   4510: getfield 640	com/tencent/mm/plugin/webview/d/h:IRl	I
          //   4513: invokeinterface 644 4 0
          //   4518: ldc 28
          //   4520: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4523: return
          //   4524: astore_1
          //   4525: ldc 71
          //   4527: new 118	java/lang/StringBuilder
          //   4530: dup
          //   4531: ldc_w 646
          //   4534: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   4537: aload_1
          //   4538: invokevirtual 499	java/lang/Exception:getMessage	()Ljava/lang/String;
          //   4541: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   4544: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   4547: invokestatic 649	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
          //   4550: ldc 28
          //   4552: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4555: return
          //   4556: aload_0
          //   4557: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   4560: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4563: getfield 160	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IMs	Lcom/tencent/mm/plugin/webview/model/az;
          //   4566: invokevirtual 166	com/tencent/mm/plugin/webview/model/az:gdh	()Lcom/tencent/mm/plugin/webview/model/az$d;
          //   4569: iconst_3
          //   4570: anewarray 4	java/lang/Object
          //   4573: dup
          //   4574: iconst_0
          //   4575: aload_0
          //   4576: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   4579: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4582: invokevirtual 169	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:coX	()Ljava/lang/String;
          //   4585: aastore
          //   4586: dup
          //   4587: iconst_1
          //   4588: bipush 16
          //   4590: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4593: aastore
          //   4594: dup
          //   4595: iconst_2
          //   4596: iconst_1
          //   4597: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4600: aastore
          //   4601: invokevirtual 175	com/tencent/mm/plugin/webview/model/az$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/az$d;
          //   4604: invokevirtual 178	com/tencent/mm/plugin/webview/model/az$d:report	()V
          //   4607: aload_0
          //   4608: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   4611: invokestatic 689	com/tencent/mm/plugin/webview/ui/tools/j:e	(Lcom/tencent/mm/plugin/webview/ui/tools/j;)V
          //   4614: ldc 28
          //   4616: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4619: return
          //   4620: aload_0
          //   4621: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   4624: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4627: getfield 160	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IMs	Lcom/tencent/mm/plugin/webview/model/az;
          //   4630: invokevirtual 166	com/tencent/mm/plugin/webview/model/az:gdh	()Lcom/tencent/mm/plugin/webview/model/az$d;
          //   4633: iconst_3
          //   4634: anewarray 4	java/lang/Object
          //   4637: dup
          //   4638: iconst_0
          //   4639: aload_0
          //   4640: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   4643: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4646: invokevirtual 169	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:coX	()Ljava/lang/String;
          //   4649: aastore
          //   4650: dup
          //   4651: iconst_1
          //   4652: bipush 31
          //   4654: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4657: aastore
          //   4658: dup
          //   4659: iconst_2
          //   4660: iconst_1
          //   4661: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4664: aastore
          //   4665: invokevirtual 175	com/tencent/mm/plugin/webview/model/az$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/az$d;
          //   4668: invokevirtual 178	com/tencent/mm/plugin/webview/model/az$d:report	()V
          //   4671: aload_0
          //   4672: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   4675: invokevirtual 692	com/tencent/mm/plugin/webview/ui/tools/j:cjP	()V
          //   4678: ldc 28
          //   4680: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4683: return
          //   4684: getstatic 325	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
          //   4687: ldc2_w 693
          //   4690: lconst_1
          //   4691: lconst_1
          //   4692: iconst_0
          //   4693: invokevirtual 333	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
          //   4696: aload_0
          //   4697: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   4700: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4703: getfield 160	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IMs	Lcom/tencent/mm/plugin/webview/model/az;
          //   4706: invokevirtual 166	com/tencent/mm/plugin/webview/model/az:gdh	()Lcom/tencent/mm/plugin/webview/model/az$d;
          //   4709: iconst_3
          //   4710: anewarray 4	java/lang/Object
          //   4713: dup
          //   4714: iconst_0
          //   4715: aload_0
          //   4716: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   4719: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4722: invokevirtual 169	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:coX	()Ljava/lang/String;
          //   4725: aastore
          //   4726: dup
          //   4727: iconst_1
          //   4728: bipush 28
          //   4730: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4733: aastore
          //   4734: dup
          //   4735: iconst_2
          //   4736: iconst_1
          //   4737: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4740: aastore
          //   4741: invokevirtual 175	com/tencent/mm/plugin/webview/model/az$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/az$d;
          //   4744: invokevirtual 178	com/tencent/mm/plugin/webview/model/az$d:report	()V
          //   4747: aload_0
          //   4748: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   4751: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4754: getfield 698	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Jik	Lcom/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter;
          //   4757: invokevirtual 703	com/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter:isShown	()Z
          //   4760: ifne +686 -> 5446
          //   4763: aload_0
          //   4764: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   4767: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4770: getfield 698	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Jik	Lcom/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter;
          //   4773: invokevirtual 706	com/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter:reset	()V
          //   4776: aload_0
          //   4777: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   4780: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4783: getfield 698	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Jik	Lcom/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter;
          //   4786: invokevirtual 709	com/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter:giD	()V
          //   4789: aload_0
          //   4790: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   4793: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4796: getfield 698	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Jik	Lcom/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter;
          //   4799: invokevirtual 712	com/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter:show	()V
          //   4802: ldc 28
          //   4804: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4807: return
          //   4808: aload_0
          //   4809: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   4812: astore_1
          //   4813: ldc 141
          //   4815: ldc_w 714
          //   4818: invokestatic 82	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   4821: aload_1
          //   4822: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4825: getfield 63	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IBw	Lcom/tencent/mm/plugin/webview/d/h;
          //   4828: ifnull +72 -> 4900
          //   4831: aload_1
          //   4832: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4835: getfield 63	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IBw	Lcom/tencent/mm/plugin/webview/d/h;
          //   4838: astore_1
          //   4839: aload_1
          //   4840: getfield 69	com/tencent/mm/plugin/webview/d/h:GBl	Z
          //   4843: ifne +17 -> 4860
          //   4846: ldc 71
          //   4848: ldc_w 716
          //   4851: invokestatic 78	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   4854: ldc 28
          //   4856: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4859: return
          //   4860: ldc 71
          //   4862: ldc_w 718
          //   4865: invokestatic 82	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   4868: new 720	com/tencent/mm/plugin/webview/d/h$22
          //   4871: dup
          //   4872: aload_1
          //   4873: ldc_w 722
          //   4876: new 84	java/util/HashMap
          //   4879: dup
          //   4880: invokespecial 85	java/util/HashMap:<init>	()V
          //   4883: aload_1
          //   4884: getfield 103	com/tencent/mm/plugin/webview/d/h:IRj	Z
          //   4887: aload_1
          //   4888: getfield 106	com/tencent/mm/plugin/webview/d/h:zpY	Ljava/lang/String;
          //   4891: invokestatic 112	com/tencent/mm/plugin/webview/d/n$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   4894: invokespecial 725	com/tencent/mm/plugin/webview/d/h$22:<init>	(Lcom/tencent/mm/plugin/webview/d/h;Ljava/lang/String;)V
          //   4897: invokestatic 731	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
          //   4900: ldc 28
          //   4902: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4905: return
          //   4906: aload_0
          //   4907: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   4910: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4913: getfield 160	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IMs	Lcom/tencent/mm/plugin/webview/model/az;
          //   4916: invokevirtual 166	com/tencent/mm/plugin/webview/model/az:gdh	()Lcom/tencent/mm/plugin/webview/model/az$d;
          //   4919: iconst_3
          //   4920: anewarray 4	java/lang/Object
          //   4923: dup
          //   4924: iconst_0
          //   4925: aload_0
          //   4926: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   4929: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4932: invokevirtual 169	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:coX	()Ljava/lang/String;
          //   4935: aastore
          //   4936: dup
          //   4937: iconst_1
          //   4938: bipush 33
          //   4940: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4943: aastore
          //   4944: dup
          //   4945: iconst_2
          //   4946: iconst_1
          //   4947: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4950: aastore
          //   4951: invokevirtual 175	com/tencent/mm/plugin/webview/model/az$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/az$d;
          //   4954: invokevirtual 178	com/tencent/mm/plugin/webview/model/az$d:report	()V
          //   4957: aload_0
          //   4958: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   4961: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4964: getfield 735	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:ILF	Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/h;
          //   4967: iconst_0
          //   4968: invokevirtual 741	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/h:zs	(Z)Z
          //   4971: pop
          //   4972: aload_0
          //   4973: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   4976: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4979: getfield 745	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Jju	Lcom/tencent/mm/plugin/webview/ui/tools/multitask/a;
          //   4982: iconst_1
          //   4983: invokevirtual 751	com/tencent/mm/plugin/webview/ui/tools/multitask/a:ic	(Z)V
          //   4986: ldc 28
          //   4988: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4991: return
          //   4992: aload_0
          //   4993: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   4996: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4999: getfield 160	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IMs	Lcom/tencent/mm/plugin/webview/model/az;
          //   5002: invokevirtual 166	com/tencent/mm/plugin/webview/model/az:gdh	()Lcom/tencent/mm/plugin/webview/model/az$d;
          //   5005: iconst_3
          //   5006: anewarray 4	java/lang/Object
          //   5009: dup
          //   5010: iconst_0
          //   5011: aload_0
          //   5012: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   5015: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5018: invokevirtual 169	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:coX	()Ljava/lang/String;
          //   5021: aastore
          //   5022: dup
          //   5023: iconst_1
          //   5024: bipush 34
          //   5026: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   5029: aastore
          //   5030: dup
          //   5031: iconst_2
          //   5032: iconst_1
          //   5033: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   5036: aastore
          //   5037: invokevirtual 175	com/tencent/mm/plugin/webview/model/az$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/az$d;
          //   5040: invokevirtual 178	com/tencent/mm/plugin/webview/model/az$d:report	()V
          //   5043: ldc 28
          //   5045: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   5048: return
          //   5049: aload_0
          //   5050: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   5053: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5056: getfield 160	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IMs	Lcom/tencent/mm/plugin/webview/model/az;
          //   5059: invokevirtual 166	com/tencent/mm/plugin/webview/model/az:gdh	()Lcom/tencent/mm/plugin/webview/model/az$d;
          //   5062: iconst_3
          //   5063: anewarray 4	java/lang/Object
          //   5066: dup
          //   5067: iconst_0
          //   5068: aload_0
          //   5069: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   5072: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5075: invokevirtual 169	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:coX	()Ljava/lang/String;
          //   5078: aastore
          //   5079: dup
          //   5080: iconst_1
          //   5081: bipush 99
          //   5083: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   5086: aastore
          //   5087: dup
          //   5088: iconst_2
          //   5089: iconst_1
          //   5090: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   5093: aastore
          //   5094: invokevirtual 175	com/tencent/mm/plugin/webview/model/az$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/az$d;
          //   5097: invokevirtual 178	com/tencent/mm/plugin/webview/model/az$d:report	()V
          //   5100: aload_0
          //   5101: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   5104: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5107: invokevirtual 754	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:gfJ	()V
          //   5110: ldc 28
          //   5112: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   5115: return
          //   5116: aload_0
          //   5117: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   5120: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5123: getfield 63	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IBw	Lcom/tencent/mm/plugin/webview/d/h;
          //   5126: ldc_w 722
          //   5129: aconst_null
          //   5130: new 756	org/json/JSONObject
          //   5133: dup
          //   5134: invokespecial 757	org/json/JSONObject:<init>	()V
          //   5137: invokevirtual 760	com/tencent/mm/plugin/webview/d/h:b	(Ljava/lang/String;Ljava/util/Map;Lorg/json/JSONObject;)V
          //   5140: ldc 28
          //   5142: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   5145: return
          //   5146: invokestatic 766	com/tencent/mm/ui/aw:gWy	()Lcom/huawei/easygo/sdk/EasyGo;
          //   5149: ifnonnull +16 -> 5165
          //   5152: aload_0
          //   5153: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   5156: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5159: invokevirtual 770	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getContext	()Landroid/support/v7/app/AppCompatActivity;
          //   5162: invokestatic 774	com/tencent/mm/ui/aw:kA	(Landroid/content/Context;)V
          //   5165: invokestatic 766	com/tencent/mm/ui/aw:gWy	()Lcom/huawei/easygo/sdk/EasyGo;
          //   5168: aload_0
          //   5169: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   5172: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5175: invokevirtual 777	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getTaskId	()I
          //   5178: invokestatic 780	com/tencent/mm/ui/aw:a	(Lcom/huawei/easygo/sdk/EasyGo;I)I
          //   5181: iconst_2
          //   5182: if_icmpne +26 -> 5208
          //   5185: invokestatic 766	com/tencent/mm/ui/aw:gWy	()Lcom/huawei/easygo/sdk/EasyGo;
          //   5188: aload_0
          //   5189: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   5192: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5195: invokevirtual 777	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getTaskId	()I
          //   5198: iconst_0
          //   5199: invokestatic 783	com/tencent/mm/ui/aw:a	(Lcom/huawei/easygo/sdk/EasyGo;II)V
          //   5202: ldc 28
          //   5204: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   5207: return
          //   5208: invokestatic 766	com/tencent/mm/ui/aw:gWy	()Lcom/huawei/easygo/sdk/EasyGo;
          //   5211: aload_0
          //   5212: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   5215: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5218: invokevirtual 777	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getTaskId	()I
          //   5221: iconst_2
          //   5222: invokestatic 783	com/tencent/mm/ui/aw:a	(Lcom/huawei/easygo/sdk/EasyGo;II)V
          //   5225: ldc 28
          //   5227: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   5230: return
          //   5231: iconst_0
          //   5232: istore_2
          //   5233: goto -4487 -> 746
          //   5236: iconst_0
          //   5237: istore_2
          //   5238: goto -4478 -> 760
          //   5241: astore_1
          //   5242: iconst_0
          //   5243: istore_2
          //   5244: ldc 141
          //   5246: aload_1
          //   5247: ldc_w 785
          //   5250: iconst_0
          //   5251: anewarray 4	java/lang/Object
          //   5254: invokestatic 789	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
          //   5257: goto -4497 -> 760
          //   5260: aload_0
          //   5261: getfield 19	com/tencent/mm/plugin/webview/ui/tools/j$20:JgA	Lcom/tencent/mm/plugin/webview/ui/tools/j;
          //   5264: astore_1
          //   5265: aload_1
          //   5266: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5269: getfield 63	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IBw	Lcom/tencent/mm/plugin/webview/d/h;
          //   5272: ldc_w 625
          //   5275: iconst_0
          //   5276: invokevirtual 573	com/tencent/mm/plugin/webview/d/h:cL	(Ljava/lang/String;Z)V
          //   5279: aload_1
          //   5280: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5283: getfield 63	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:IBw	Lcom/tencent/mm/plugin/webview/d/h;
          //   5286: astore_1
          //   5287: aload_1
          //   5288: getfield 69	com/tencent/mm/plugin/webview/d/h:GBl	Z
          //   5291: ifne +17 -> 5308
          //   5294: ldc 71
          //   5296: ldc_w 791
          //   5299: invokestatic 78	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   5302: ldc 28
          //   5304: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   5307: return
          //   5308: new 84	java/util/HashMap
          //   5311: dup
          //   5312: invokespecial 85	java/util/HashMap:<init>	()V
          //   5315: astore 5
          //   5317: aload 5
          //   5319: ldc_w 636
          //   5322: ldc_w 793
          //   5325: invokevirtual 94	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
          //   5328: pop
          //   5329: ldc_w 633
          //   5332: aload 5
          //   5334: aload_1
          //   5335: getfield 103	com/tencent/mm/plugin/webview/d/h:IRj	Z
          //   5338: aload_1
          //   5339: getfield 106	com/tencent/mm/plugin/webview/d/h:zpY	Ljava/lang/String;
          //   5342: invokestatic 112	com/tencent/mm/plugin/webview/d/n$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   5345: astore 5
          //   5347: aload_1
          //   5348: getfield 116	com/tencent/mm/plugin/webview/d/h:IRa	Lcom/tencent/mm/ui/widget/MMWebView;
          //   5351: new 118	java/lang/StringBuilder
          //   5354: dup
          //   5355: ldc 120
          //   5357: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   5360: aload 5
          //   5362: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   5365: ldc 129
          //   5367: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   5370: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   5373: aconst_null
          //   5374: invokevirtual 139	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   5377: aload_1
          //   5378: getfield 634	com/tencent/mm/plugin/webview/d/h:mHh	Lcom/tencent/mm/plugin/webview/stub/e;
          //   5381: ldc_w 795
          //   5384: aload 4
          //   5386: aload_1
          //   5387: getfield 640	com/tencent/mm/plugin/webview/d/h:IRl	I
          //   5390: invokeinterface 644 4 0
          //   5395: aload_1
          //   5396: getfield 634	com/tencent/mm/plugin/webview/d/h:mHh	Lcom/tencent/mm/plugin/webview/stub/e;
          //   5399: ldc_w 636
          //   5402: ldc_w 793
          //   5405: aload_1
          //   5406: getfield 640	com/tencent/mm/plugin/webview/d/h:IRl	I
          //   5409: invokeinterface 644 4 0
          //   5414: ldc 28
          //   5416: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   5419: return
          //   5420: astore_1
          //   5421: ldc 71
          //   5423: new 118	java/lang/StringBuilder
          //   5426: dup
          //   5427: ldc_w 646
          //   5430: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   5433: aload_1
          //   5434: invokevirtual 499	java/lang/Exception:getMessage	()Ljava/lang/String;
          //   5437: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   5440: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   5443: invokestatic 649	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
          //   5446: ldc 28
          //   5448: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   5451: return
          //   5452: astore_1
          //   5453: goto -209 -> 5244
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	5456	0	this	20
          //   0	5456	1	paramAnonymousMenuItem	MenuItem
          //   0	5456	2	paramAnonymousInt	int
          //   752	4	3	i	int
          //   37	5348	4	localObject1	Object
          //   89	5272	5	localObject2	Object
          //   2037	576	6	localObject3	Object
          //   2044	492	7	locale	com.tencent.mm.plugin.webview.stub.e
          // Exception table:
          //   from	to	target	type
          //   2169	2183	2257	java/lang/Exception
          //   2183	2256	2257	java/lang/Exception
          //   2308	2388	2257	java/lang/Exception
          //   2389	2404	2257	java/lang/Exception
          //   2105	2115	2284	java/lang/Exception
          //   2535	2545	2623	java/lang/Exception
          //   3674	3693	3699	java/lang/Exception
          //   4499	4518	4524	java/lang/Exception
          //   690	728	5241	java/lang/Exception
          //   732	739	5241	java/lang/Exception
          //   5377	5414	5420	java/lang/Exception
          //   746	753	5452	java/lang/Exception
        }
      };
      this.nVN.HLY = ((o.g)localObject2);
      this.nVN.QNG = new e.c()
      {
        public final void onShow()
        {
          AppMethodBeat.i(211072);
          j.a locala = (j.a)j.this.Jgo.get(Integer.valueOf(45));
          if (locala == null)
          {
            AppMethodBeat.o(211072);
            return;
          }
          j.this.Jgo.remove(Integer.valueOf(45));
          int i;
          if ((j.this.nVN != null) && (j.this.nVN.isShowing()) && (j.this.Jgu != null))
          {
            i = j.this.Jgu.gKR();
            localObject = j.this.nVN;
            if ((((com.tencent.mm.ui.widget.a.e)localObject).mRecyclerView != null) && (((com.tencent.mm.ui.widget.a.e)localObject).mRecyclerView.getLayoutManager() != null) && (((com.tencent.mm.ui.widget.a.e)localObject).QOs != null))
            {
              ((com.tencent.mm.ui.widget.a.e)localObject).QOs.atO = i;
              ((com.tencent.mm.ui.widget.a.e)localObject).mRecyclerView.getLayoutManager().startSmoothScroll(((com.tencent.mm.ui.widget.a.e)localObject).QOs);
            }
          }
          Object localObject = j.this;
          if (locala != null)
          {
            i = locala.nfG;
            Bundle localBundle = locala.JgL;
            if ((localBundle != null) && (i == 45))
            {
              ResolveInfo localResolveInfo = (ResolveInfo)localBundle.getParcelable("show_browser_resolve_info");
              boolean bool = localBundle.getBoolean("show_browser_with_animation", false);
              if (localResolveInfo != null)
              {
                ((j)localObject).Jgn.JlN = null;
                ((j)localObject).Jgn.resolveInfo = localResolveInfo;
                ((j)localObject).a(((j)localObject).geo(), ((j)localObject).Jgn.resolveInfo, ((j)localObject).Jgu, locala.neT, bool);
              }
            }
          }
          AppMethodBeat.o(211072);
        }
      };
      this.nVN.PGl = new com.tencent.mm.ui.widget.a.e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(211073);
          if ((j.this.geo().gfB()) && (j.this.geo().IBw != null)) {
            j.this.geo().IBw.onWindowFocusChanged(true);
          }
          AppMethodBeat.o(211073);
        }
      };
      if (geo().mHi != null) {
        break label233;
      }
      Log.e("MicroMsg.WebViewMenuHelper", "get permission failed");
      AppMethodBeat.o(211082);
      return;
      bool = false;
      break;
    }
    label233:
    Object localObject3 = geo().IMH.mHi.gdH();
    this.nVN.HLX = new o.f()
    {
      public final void onCreateMMMenu(m paramAnonymousm)
      {
        AppMethodBeat.i(211074);
        if (j.this.gcd())
        {
          AppMethodBeat.o(211074);
          return;
        }
        j.this.Jgu = paramAnonymousm;
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(480L, 0L, 1L, false);
        paramAnonymousm.clear();
        if (j.this.Jgw.booleanValue())
        {
          j = j.this.Jgv.size();
          i = 0;
          while (i < j)
          {
            localObject1 = (com.tencent.mm.n.e.b)j.this.Jgv.get(i);
            localObject2 = (n)paramAnonymousm.d(((com.tencent.mm.n.e.b)localObject1).id, ((com.tencent.mm.n.e.b)localObject1).title);
            ((n)localObject2).ORH = ((ContextMenu.ContextMenuInfo)localObject1);
            ((n)localObject2).setIcon(null);
            ((n)localObject2).setIcon(0);
            i += 1;
          }
          AppMethodBeat.o(211074);
          return;
        }
        if ((j.this.agI(1)) && (j.a(this.JgH, 21)) && (j.this.agH(1))) {
          paramAnonymousm.a(1, j.this.geo().getString(2131764184), 2131690674, j.this.geo().getResources().getColor(2131099710), j.b(this.JgH, 21));
        }
        if ((j.this.agI(2)) && (j.a(this.JgH, 23)) && (j.this.agH(2))) {
          paramAnonymousm.a(2, j.this.geo().getString(2131764185), 2131689830, 0, j.b(this.JgH, 23));
        }
        int j = -1;
        m = -1;
        int i = j;
        try
        {
          localObject1 = new Bundle();
          i = j;
          ((Bundle)localObject1).putInt("WebViewShare_BinderID", j.this.geo().IMH.fZu());
          i = j;
          ((Bundle)localObject1).putString("WebViewShare_wv_url", j.this.geo().IMH.pGj.getUrl());
          i = j;
          localObject1 = j.this.geo().IMH.mHh.j(109, (Bundle)localObject1);
          k = m;
          i = j;
          if (localObject1 != null)
          {
            i = j;
            j = ((Bundle)localObject1).getInt("key_hao_kan_permission", 0);
            i = j;
            k = ((Bundle)localObject1).getInt("key_hao_kan_recommand", -1);
            i = j;
          }
        }
        catch (Exception localException3)
        {
          try
          {
            if (!j.this.geo().IMH.mHh.j(78, null).getBoolean("isOpenForFaceBook", false)) {
              break label1096;
            }
            paramAnonymousm.a(33, j.this.geo().getString(2131768799), 2131690049, 0, j.b(this.JgH, 31));
            if ((!j.this.agI(26)) || (!j.a(this.JgH, 278)) || (!com.tencent.mm.plugin.webview.stub.a.bW(j.this.geo(), j.this.geo().pGj.getUrl())) || (!j.this.agH(26))) {
              break label1193;
            }
            paramAnonymousm.a(26, j.this.geo().getString(2131768796), 2131689847, 0, j.b(this.JgH, 278));
            if ((!j.this.agI(7)) || (!j.a(this.JgH, 45)) || (!j.this.agH(7))) {
              break label1396;
            }
            bool = j.b(this.JgH, 45);
            paramAnonymousm.a(7, j.this.geo().getString(2131768763), 2131689809, j.this.geo().getResources().getColor(2131099762), bool);
            if (j.this.Jgo.containsKey(Integer.valueOf(45))) {
              break label2403;
            }
            j.this.Jgn.resolveInfo = j.a(j.this.geo(), j.this.geo().mHh);
            Log.i("MicroMsg.WebViewMenuHelper", "alvinluo showReaderModeMenu defaultBrowser: %s", new Object[] { j.this.Jgn.resolveInfo });
            if (j.this.Jgn.resolveInfo == null) {
              break label1396;
            }
            j.this.a(j.this.geo(), j.this.Jgn.resolveInfo, paramAnonymousm, bool, false);
            localObject1 = j.this.geo().getIntent().getStringExtra("sns_local_id");
            l = j.this.geo().getIntent().getLongExtra("msg_id", -9223372036854775808L);
          }
          catch (Exception localException3)
          {
            try
            {
              do
              {
                for (;;)
                {
                  long l;
                  if ((j.this.agI(23)) && (j.this.geo().IMH.mHh.N(l, (String)localObject1))) {
                    paramAnonymousm.b(23, j.this.geo().getString(2131758382), 2131689832);
                  }
                  if ((j.this.agI(24)) && (j.a(this.JgH, 43)) && (j.this.agH(24)) && (!com.tencent.mm.pluginsdk.model.app.q.s(j.this.geo(), "com.tencent.wework"))) {}
                  try
                  {
                    localObject1 = new Bundle();
                    ((Bundle)localObject1).putString("enterprise_action", "enterprise_has_connector");
                    localObject1 = j.this.geo().IMH.mHh.j(71, (Bundle)localObject1);
                    if (localObject1 == null) {
                      break;
                    }
                    bool = ((Bundle)localObject1).getBoolean("enterprise_has_connector");
                  }
                  catch (Exception localException5)
                  {
                    for (;;)
                    {
                      Log.w("MicroMsg.WebViewMenuHelper", "builder add, ex = " + localException5.getMessage());
                      bool = false;
                      continue;
                      Log.i("MicroMsg.WebViewMenuHelper", "get mail session key is null or nil, should not show send mail menu");
                      continue;
                      j.a(j.this, localException5);
                    }
                  }
                  if (bool) {
                    paramAnonymousm.a(24, j.this.geo().getString(2131764201), 2131689818, j.b(this.JgH, 43));
                  }
                  if ((j.this.agI(8)) && (j.a(this.JgH, 36)) && (j.this.agH(8))) {
                    localObject1 = null;
                  }
                  try
                  {
                    localObject2 = j.this.geo().IMH.mHh.gdY();
                    localObject1 = localObject2;
                  }
                  catch (Exception localException6)
                  {
                    String str;
                    j.a locala;
                    break label1706;
                  }
                  if (Util.isNullOrNil((String)localObject1)) {
                    break label2502;
                  }
                  paramAnonymousm.a(8, j.this.geo().getString(2131768765), 2131690546, j.this.geo().getResources().getColor(2131099762), j.b(this.JgH, 36));
                  if ((j.this.agI(20)) && (j.a(this.JgH, 91)) && (com.tencent.mm.plugin.webview.stub.a.hV(j.this.geo())) && (j.this.agH(20))) {
                    paramAnonymousm.a(20, j.this.geo().getString(2131768800), 2131689834, 0, j.b(this.JgH, 91));
                  }
                  if ((j.this.agI(22)) && (j.a(this.JgH, 133)) && (com.tencent.mm.plugin.webview.stub.a.hV(j.this.geo())) && (j.this.agH(22))) {
                    paramAnonymousm.a(22, j.this.geo().getString(2131768801), 2131689835, 0, j.b(this.JgH, 133));
                  }
                  try
                  {
                    if ((j.this.agI(0)) && (j.a(this.JgH, 43)) && (j.this.agH(0)) && (j.this.geo().IMH.mHh.aZN()))
                    {
                      localObject1 = j.this.geo().IMH.mHh.aZM();
                      localObject2 = ((List)localObject1).iterator();
                      while (((Iterator)localObject2).hasNext()) {
                        paramAnonymousm.add((String)((Iterator)localObject2).next());
                      }
                    }
                    if (!j.this.agI(27)) {
                      break label2133;
                    }
                  }
                  catch (Exception localException1)
                  {
                    Log.w("MicroMsg.WebViewMenuHelper", "builder add, ex = " + localException1.getMessage());
                  }
                  if ((j.this.geo().Jif != null) && (j.this.geo().Jif.getVisibility() == 0)) {
                    paramAnonymousm.b(27, j.this.geo().getString(2131764193), 2131689819);
                  }
                  str = j.this.geo().aXD(j.this.geo().gfu());
                  localObject2 = j.this.geo().getIntent().getStringExtra("shortcut_user_name");
                  if ((!j.this.geo().Jix) && (!Util.isNullOrNil(str)) && (!Util.isNullOrNil((String)localObject2)) && (j.a(this.JgH, 255)) && (j.this.agH(29)) && (j.this.agI(29))) {
                    paramAnonymousm.a(29, j.this.geo().getString(2131764182), 2131691769, j.b(this.JgH, 255));
                  }
                  j.this.nVN.fPw();
                  AppMethodBeat.o(211074);
                  return;
                  localException2 = localException2;
                  Log.e("MicroMsg.WebViewMenuHelper", "isSetHaoKan, e = " + localException2.getMessage());
                  int k = m;
                  continue;
                  if ((j.this.agH(39)) && (k == 1))
                  {
                    paramAnonymousm.a(39, j.this.geo().getString(2131764186), 2131689810, j.this.geo().getResources().getColor(2131099845));
                    continue;
                    localException3 = localException3;
                    Log.printErrStackTrace("MicroMsg.WebViewMenuHelper", localException3, "", new Object[0]);
                  }
                }
                locala = (j.a)j.this.Jgo.get(Integer.valueOf(45));
              } while (locala == null);
              locala.neT = bool;
              locala.JgK = paramAnonymousm.size();
            }
            catch (Exception localException4)
            {
              for (;;)
              {
                Log.printErrStackTrace("MicroMsg.WebViewMenuHelper", localException4, "", new Object[0]);
              }
            }
          }
        }
        if (i == 1)
        {
          if ((j.this.agI(38)) && (j.this.agH(38)) && (k == 0)) {
            paramAnonymousm.a(38, j.this.geo().getString(2131764194), 2131689824, j.this.geo().getResources().getColor(2131099845));
          }
        }
        else
        {
          if ((j.this.agI(3)) && ((!j.this.geo().Jiv) || ((!Util.isNullOrNil(j.this.geo().gfu())) && (!Util.isNullOrNil(j.this.geo().JjQ)) && (!j.this.geo().gfu().startsWith(j.this.geo().JjQ)))) && (j.a(this.JgH, 323)) && (j.this.geR()) && (j.this.agH(3))) {
            paramAnonymousm.a(3, j.this.geo().getString(2131763947), 2131689821, 0, j.b(this.JgH, 323));
          }
          localObject1 = j.this.geo().fZM();
          bool = ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ahv((String)localObject1);
          if ((((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).dYl()) && (bool) && (j.this.geo().gbH()) && (j.this.geo().gfe() != null)) {
            paramAnonymousm.a(46, j.this.geo().getString(2131768605), 2131690771, 0);
          }
          if ((j.this.agI(25)) && (j.a(this.JgH, 322)) && (WWAPIFactory.ly(j.this.geo()).a(IWWAPI.WWAppType.Sxc)) && (j.this.agH(25)))
          {
            localObject1 = WWAPIFactory.ly(j.this.geo()).b(IWWAPI.WWAppType.Sxc);
            if (!WeChatBrands.AppInfo.current().isMainland()) {
              localObject1 = j.this.geo().getString(2131768704);
            }
            paramAnonymousm.a(25, j.this.geo().getString(2131764202, new Object[] { localObject1 }), 2131689848, 0, j.b(this.JgH, 322));
          }
          if ((j.this.agI(43)) && (j.a(this.JgH, 322)) && (WWAPIFactory.ly(j.this.geo()).a(IWWAPI.WWAppType.Sxd)) && (j.this.agH(43)))
          {
            localObject1 = WWAPIFactory.ly(j.this.geo()).b(IWWAPI.WWAppType.Sxd);
            paramAnonymousm.a(43, j.this.geo().getString(2131764202, new Object[] { localObject1 }), 2131689849, 0, j.b(this.JgH, 322));
          }
          if ((!j.this.agI(33)) || (!j.a(this.JgH, 31)) || (!j.this.agH(33))) {}
        }
      }
    };
    Object localObject4 = geo().fZM();
    geo();
    Object localObject1 = o.baw((String)localObject4);
    int i;
    if ((com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class) != null) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).isMpUrl((String)localObject4)))
    {
      i = 1;
      this.nVN.QNH = new o.f()
      {
        public final void onCreateMMMenu(m paramAnonymousm)
        {
          AppMethodBeat.i(211075);
          if (j.this.gcd())
          {
            AppMethodBeat.o(211075);
            return;
          }
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(480L, 0L, 1L, false);
          paramAnonymousm.clear();
          if (j.this.Jgw.booleanValue())
          {
            AppMethodBeat.o(211075);
            return;
          }
          if ((ao.gJN()) && (aw.b(aw.gWy(), j.this.geo().getTaskId())))
          {
            aw.kA(j.this.geo().getContext());
            if (aw.a(aw.gWy(), j.this.geo().getTaskId()) != 2) {
              break label355;
            }
            paramAnonymousm.b(44, j.this.geo().getString(2131757649), 2131690831);
          }
          for (;;)
          {
            if ((j.this.geo().Jju != null) && (j.this.geo().Jju.bPq()) && (j.this.agI(35)) && (j.this.agH(35))) {
              paramAnonymousm.b(35, j.this.geo().getString(2131764199), 2131690846);
            }
            switch (j.this.geo().JjB)
            {
            }
            try
            {
              label244:
              LinkedList localLinkedList = j.this.geo().gfK();
              int i;
              if (localLinkedList != null)
              {
                i = 0;
                label263:
                if ((i < localLinkedList.size()) && (i < 8))
                {
                  com.tencent.mm.n.e.a locala = (com.tencent.mm.n.e.a)localLinkedList.get(i);
                  n localn = null;
                  if ("index".equals(Util.nullAsNil(locala.id))) {
                    localn = (n)paramAnonymousm.b(15, j.this.geo().getString(2131768568), 2131689827);
                  }
                  for (;;)
                  {
                    if (localn != null) {
                      localn.lDS = locala.url;
                    }
                    i += 1;
                    break label263;
                    label355:
                    paramAnonymousm.b(44, j.this.geo().getString(2131766359), 2131690910);
                    break;
                    paramAnonymousm.b(40, j.this.geo().getString(2131768623), 2131690458);
                    break label244;
                    paramAnonymousm.b(41, j.this.geo().getString(2131768621), 2131690457);
                    break label244;
                    paramAnonymousm.b(42, j.this.geo().getString(2131768622), 2131690458);
                    break label244;
                    if ("categories".equals(Util.nullAsNil(locala.id))) {
                      localn = (n)paramAnonymousm.b(16, j.this.geo().getString(2131768567), 2131689826);
                    } else if ("cart".equals(Util.nullAsNil(locala.id))) {
                      localn = (n)paramAnonymousm.b(17, j.this.geo().getString(2131768566), 2131689825);
                    } else if ("profile".equals(Util.nullAsNil(locala.id))) {
                      localn = (n)paramAnonymousm.b(18, j.this.geo().getString(2131768570), 2131689833);
                    } else if ("member".equals(Util.nullAsNil(locala.id))) {
                      localn = (n)paramAnonymousm.b(19, j.this.geo().getString(2131768569), 2131689828);
                    }
                  }
                }
              }
              try
              {
                bool1 = j.this.geo().IMH.mHh.IT((String)localObject);
                if (bool1) {}
              }
              catch (Exception localException4)
              {
                for (;;)
                {
                  boolean bool1;
                  try
                  {
                    Object localObject;
                    j.this.geo().IMH.mHh.aZW((String)localObject);
                    if (j.this.agH(10)) {
                      paramAnonymousm.b(10, j.this.geo().getString(2131756736), 2131690898);
                    }
                    if ((j.this.agI(6)) && (j.a(this.JgH, 44)) && (j.this.agH(6))) {
                      paramAnonymousm.a(6, j.this.geo().getString(2131768758), 2131690823, j.b(this.JgH, 44));
                    }
                    if ((j.this.agI(28)) && (j.this.agH(28))) {
                      paramAnonymousm.b(28, j.this.geo().getString(2131768534), 2131690895);
                    }
                    if (((paramLong & 1L) == 0L) && (j.this.agI(31))) {
                      paramAnonymousm.b(31, j.this.geo().getString(2131768793), 2131689496);
                    }
                    if ((this.JgH.Kzq != null) && (j.this.geo().Jiv) && (!Util.isNullOrNil(j.this.geo().gfu())) && (!Util.isNullOrNil(j.this.geo().JjQ)) && (j.this.geo().gfu().startsWith(j.this.geo().JjQ)) && (j.this.geo().getIntent().getBooleanExtra("key_detail_can_delete", true)) && (j.this.geR()))
                    {
                      if ((j.this.agI(12)) && (j.this.agH(12))) {
                        paramAnonymousm.b(12, j.this.geo().getString(2131759169), 2131689805);
                      }
                      if (j.this.agI(9)) {
                        paramAnonymousm.b(9, j.this.geo().getString(2131755778), 2131689814);
                      }
                    }
                    if (j.this.agI(37))
                    {
                      j.this.geo();
                      if ((com.tencent.mm.plugin.webview.c.a(j.this.geo().pGj)) && (j.this.agH(37))) {
                        paramAnonymousm.b(37, j.this.geo().getString(2131768596), 2131690925);
                      }
                    }
                    if (((paramLong & 0x2) == 0L) && (j.this.agI(11)) && (j.a(this.JgH, 18)) && (j.this.agH(11))) {
                      paramAnonymousm.a(11, j.this.geo().getString(2131764183), 2131690810, j.b(this.JgH, 18));
                    }
                    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG) || (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.siO, 0) == 1))
                    {
                      localObject = j.this.geo();
                      if (!com.tencent.mm.plugin.webview.d.l.gbo()) {
                        break label1632;
                      }
                      i = 2131768590;
                      paramAnonymousm.a(99, ((WebViewUI)localObject).getString(i), 2131691779, false);
                    }
                    j.this.nVN.fPw();
                    AppMethodBeat.o(211075);
                    return;
                    localException4 = localException4;
                    Log.e("MicroMsg.WebViewMenuHelper", "sharebtn click fail isBizContact, ex = " + localException4.getMessage());
                    bool1 = false;
                  }
                  catch (Exception localException2)
                  {
                    Log.e("MicroMsg.WebViewMenuHelper", "sharebtn click fail triggerGetContact, ex = " + localException2.getMessage());
                    continue;
                  }
                  boolean bool2;
                  try
                  {
                    bool1 = j.this.geo().IMH.mHh.IS(localException2);
                    if (bool1)
                    {
                      bool1 = j.a(this.JgH, 19);
                      bool2 = j.b(this.JgH, 19);
                      boolean bool3 = j.this.geo().fZV();
                      if ((!j.this.agI(5)) || (!bool1) || (!j.this.agH(5))) {
                        continue;
                      }
                      if (!bool3) {
                        break label1588;
                      }
                      paramAnonymousm.a(5, j.this.geo().getString(2131768770), 2131690857, bool2);
                    }
                  }
                  catch (Exception localException3)
                  {
                    for (;;)
                    {
                      Log.e("MicroMsg.WebViewMenuHelper", "sharebtn click fail, ex = " + localException3.getMessage());
                      bool1 = false;
                      continue;
                      bool1 = j.a(this.JgH, 20);
                      bool2 = j.b(this.JgH, 20);
                    }
                  }
                  if ((this.JgB == null) || (!this.JgB.JbC))
                  {
                    paramAnonymousm.a(5, j.this.geo().getString(2131768769), 2131690857, bool2);
                    continue;
                    i = 2131768591;
                  }
                }
              }
            }
            catch (Exception localException1)
            {
              Log.e("MicroMsg.WebViewMenuHelper", "exception in add jd menu, " + localException1.getMessage());
              localObject = j.this.geo().getIntent().getStringExtra("srcUsername");
              if (Util.isNullOrNil((String)localObject)) {}
            }
          }
        }
      };
      this.nVN.QNK = ((o.g)localObject2);
      localObject2 = geo().IMH.getCurrentUrl();
      if (Util.isNullOrNil((String)localObject2)) {
        break label874;
      }
      localObject3 = Uri.parse((String)localObject2).getHost();
      localObject4 = geo().getString(2131768587, new Object[] { localObject3 });
      if (!Util.isNullOrNil(this.Jgp)) {
        break label703;
      }
      if ((i == 0) || (localObject1 == null) || (!((o.a)localObject1).isDataValid())) {
        break label682;
      }
      localObject2 = LayoutInflater.from(geo()).inflate(2131495652, null);
      localObject3 = (ImageView)((View)localObject2).findViewById(2131302895);
      Object localObject5 = (TextView)((View)localObject2).findViewById(2131309510);
      localObject4 = ((View)localObject2).findViewById(2131299205);
      ((TextView)localObject5).setText(((o.a)localObject1).Jkn);
      localObject5 = new c.a();
      ((c.a)localObject5).jbe = true;
      ((c.a)localObject5).iaT = true;
      ((c.a)localObject5).jbq = 2131231957;
      com.tencent.mm.av.a.a.bdb().a(((o.a)localObject1).Jko, (ImageView)localObject3, ((c.a)localObject5).bdv());
      ((View)localObject4).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(211052);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewMenuHelper$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          j.this.gx("Contact_Scene", 173);
          j.this.geo().IMs.gdh().C(new Object[] { j.this.geo().coX(), Integer.valueOf(38), Integer.valueOf(1) }).report();
          j.this.geo().bas(this.JgB.brandUsername);
          if (j.this.nVN != null) {
            j.this.nVN.bMo();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewMenuHelper$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(211052);
        }
      });
      com.tencent.mm.ui.tools.o.hq((View)localObject4);
      this.nVN.V((View)localObject2, true);
      label562:
      if (!geo().gfB()) {
        break label888;
      }
      this.nVN.mLN = true;
      this.nVN.mLO = true;
      com.tencent.f.h.RTc.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(211054);
          if (j.this.geo().IBw != null) {
            j.this.geo().IBw.onWindowFocusChanged(false);
          }
          AppMethodBeat.o(211054);
        }
      }, 500L);
      label608:
      if ((geo().Jik == null) || (!geo().Jik.isShown())) {
        break label907;
      }
      geo().Jik.hide();
      this.nVN.dGm();
    }
    for (;;)
    {
      if (geo().IBw != null) {
        geo().IBw.aYi("");
      }
      AppMethodBeat.o(211082);
      return;
      i = 0;
      break;
      label682:
      if (Util.isNullOrNil((String)localObject3)) {
        break label562;
      }
      this.nVN.o((CharSequence)localObject4, 1);
      break label562;
      label703:
      localObject3 = LayoutInflater.from(geo()).inflate(2131495653, null);
      localObject1 = (MMNeat7extView)((View)localObject3).findViewById(2131299509);
      this.nVN.V((View)localObject3, false);
      localObject3 = com.tencent.mm.pluginsdk.ui.span.l.j(((MMNeat7extView)localObject1).getContext(), Util.nullAsNil(this.Jgp), (int)((MMNeat7extView)localObject1).getTextSize());
      ((MMNeat7extView)localObject1).aw((CharSequence)localObject3);
      localObject3 = (ClickableSpan[])((SpannableString)localObject3).getSpans(0, ((SpannableString)localObject3).length(), ClickableSpan.class);
      if ((localObject3 == null) || (localObject3.length <= 0)) {
        break label562;
      }
      Log.i("MicroMsg.WebViewMenuHelper", "terry h5 apply show");
      com.tencent.mm.plugin.report.service.h.CyF.a(16337, new Object[] { localObject2, Integer.valueOf(1), Integer.valueOf(0) });
      ((MMNeat7extView)localObject1).setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.h((NeatTextView)localObject1, new com.tencent.mm.pluginsdk.ui.span.o(((MMNeat7extView)localObject1).getContext()))
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(211053);
          boolean bool = super.onTouch(paramAnonymousView, paramAnonymousMotionEvent);
          if (bool)
          {
            Log.i("MMNeatTouchListener", "terry h5 apply click");
            com.tencent.mm.plugin.report.service.h.CyF.a(16337, new Object[] { this.val$url, Integer.valueOf(1), Integer.valueOf(1) });
          }
          AppMethodBeat.o(211053);
          return bool;
        }
      });
      break label562;
      label874:
      this.nVN.o(" ", 1);
      break label562;
      label888:
      this.nVN.mLN = false;
      this.nVN.mLO = false;
      break label608;
      label907:
      geo().hideVKB();
      this.nVN.dGm();
    }
  }
  
  final void a(com.tencent.mm.plugin.appbrand.service.i parami)
  {
    AppMethodBeat.i(211080);
    if (this.Jgy == null)
    {
      Log.i("MicroMsg.WebViewMenuHelper", "enhanceBottomSheet, openMaterialCollection is null");
      AppMethodBeat.o(211080);
      return;
    }
    if (this.nVN == null)
    {
      Log.i("MicroMsg.WebViewMenuHelper", "enhanceBottomSheet, mmBottomSheet is null");
      AppMethodBeat.o(211080);
      return;
    }
    WebViewUI localWebViewUI = geo();
    if (localWebViewUI == null)
    {
      Log.w("MicroMsg.WebViewMenuHelper", "enhanceBottomSheet, webViewUI is null");
      AppMethodBeat.o(211080);
      return;
    }
    if (this.Jgz != null) {
      this.Jgz.dead();
    }
    this.Jgz = parami.a(com.tencent.mm.plugin.appbrand.openmaterial.model.b.nlM, localWebViewUI, this.nVN, this.Jgy, null, null);
    AppMethodBeat.o(211080);
  }
  
  final void a(WebViewUI paramWebViewUI, ResolveInfo paramResolveInfo, final m paramm, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(211084);
    String str1 = com.tencent.mm.plugin.webview.ui.tools.browser.b.b(paramWebViewUI, paramResolveInfo);
    final String str2 = String.format(paramWebViewUI.getString(2131768537), new Object[] { str1 });
    if (this.Jgn.JlN != null)
    {
      a(paramm, str2, this.Jgn.JlN, paramBoolean1, paramBoolean2);
      AppMethodBeat.o(211084);
      return;
    }
    new com.tencent.mm.plugin.webview.ui.tools.browser.e(paramWebViewUI, str1, new com.tencent.mm.plugin.webview.ui.tools.browser.e.a()
    {
      public final void B(Drawable paramAnonymousDrawable)
      {
        AppMethodBeat.i(211055);
        j.this.Jgn.JlN = paramAnonymousDrawable;
        if ((paramAnonymousDrawable != null) && (j.this.nVN != null) && (j.this.nVN.isShowing())) {
          j.this.a(paramm, str2, paramAnonymousDrawable, paramBoolean1, paramBoolean2);
        }
        AppMethodBeat.o(211055);
      }
    }).execute(new ResolveInfo[] { paramResolveInfo });
    AppMethodBeat.o(211084);
  }
  
  final void a(final m paramm, final String paramString, final Drawable paramDrawable, final boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(211085);
    Log.d("MicroMsg.WebViewMenuHelper", "alvinluo addDefaultBrowserMenuItem withAnimation: %s, title: %s, iconDrawable: %s, bitmap: %s", new Object[] { Boolean.valueOf(paramBoolean2), paramString, paramDrawable, null });
    if (!paramBoolean2)
    {
      if (a(paramm, Math.max(0, paramm.gKR()), paramDrawable, paramString, paramBoolean1)) {
        this.nVN.fPw();
      }
      AppMethodBeat.o(211085);
      return;
    }
    com.tencent.f.h.RTc.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(211056);
        if ((j.this.nVN != null) && (j.this.nVN.isShowing()))
        {
          int i = Math.max(0, paramm.gKR());
          if (j.a(paramm, i, paramDrawable, paramString, paramBoolean1))
          {
            com.tencent.mm.ui.widget.a.e locale = j.this.nVN;
            int j = locale.HMc.size();
            if ((locale.QOd != null) && (i >= 0) && (i < j)) {
              locale.QOd.cj(i);
            }
          }
        }
        AppMethodBeat.o(211056);
      }
    }, 100L);
    AppMethodBeat.o(211085);
  }
  
  protected final boolean a(JsapiPermissionWrapper paramJsapiPermissionWrapper, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(79902);
    if (paramJsapiPermissionWrapper == null)
    {
      AppMethodBeat.o(79902);
      return false;
    }
    if ((paramJsapiPermissionWrapper.aiW(paramInt1) == 1) && (agH(paramInt2)))
    {
      AppMethodBeat.o(79902);
      return true;
    }
    AppMethodBeat.o(79902);
    return false;
  }
  
  protected final boolean agH(int paramInt)
  {
    AppMethodBeat.i(79881);
    SparseBooleanArray localSparseBooleanArray = (SparseBooleanArray)this.Jgj.get(geo().pGj.getUrl());
    if ((localSparseBooleanArray != null) && (localSparseBooleanArray.get(paramInt, false)))
    {
      AppMethodBeat.o(79881);
      return false;
    }
    AppMethodBeat.o(79881);
    return true;
  }
  
  final boolean agI(int paramInt)
  {
    AppMethodBeat.i(211079);
    if ((!this.Jgr) || (this.Jgt.contains(Integer.valueOf(paramInt))))
    {
      AppMethodBeat.o(211079);
      return true;
    }
    AppMethodBeat.o(211079);
    return false;
  }
  
  public final void ani()
  {
    AppMethodBeat.i(79885);
    if (geL()) {
      Mf(0L);
    }
    AppMethodBeat.o(79885);
  }
  
  final void bam(String paramString)
  {
    AppMethodBeat.i(79889);
    geo().IBw.cL("sendAppMessage", false);
    com.tencent.mm.plugin.webview.d.h localh = geo().IBw;
    if (!localh.GBl)
    {
      Log.e("MicroMsg.JsApiHandler", "onSendToEnterprise fail, not ready");
      AppMethodBeat.o(79889);
      return;
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("scene", "enterprise");
    localObject = n.a.b("menu:share:appmessage", (Map)localObject, localh.IRj, localh.zpY);
    localh.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + (String)localObject + ")", null);
    try
    {
      localh.mHh.an("connector_local_send", paramString, localh.IRl);
      localh.mHh.an("scene", "enterprise", localh.IRl);
      AppMethodBeat.o(79889);
      return;
    }
    catch (Exception paramString)
    {
      Log.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + paramString.getMessage());
      AppMethodBeat.o(79889);
    }
  }
  
  /* Error */
  protected final void ban(String paramString)
  {
    // Byte code:
    //   0: ldc_w 1301
    //   3: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 545	com/tencent/mm/plugin/webview/ui/tools/a:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   10: invokevirtual 549	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   13: ldc_w 551
    //   16: invokevirtual 556	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   19: astore 7
    //   21: aload_0
    //   22: invokevirtual 258	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   25: invokevirtual 197	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:fZM	()Ljava/lang/String;
    //   28: astore 8
    //   30: aconst_null
    //   31: astore 4
    //   33: aload 8
    //   35: invokestatic 444	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   38: ifne +13 -> 51
    //   41: aload 8
    //   43: invokestatic 676	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   46: invokevirtual 1021	android/net/Uri:getHost	()Ljava/lang/String;
    //   49: astore 4
    //   51: aload 4
    //   53: invokestatic 444	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   56: ifne +500 -> 556
    //   59: aload 4
    //   61: ldc_w 1302
    //   64: invokestatic 1307	com/tencent/mm/sdk/platformtools/WeChatHosts:domainString	(I)Ljava/lang/String;
    //   67: invokevirtual 1310	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   70: ifeq +486 -> 556
    //   73: getstatic 1315	com/tencent/mm/ui/e$e:OyV	Ljava/lang/String;
    //   76: iconst_1
    //   77: anewarray 228	java/lang/Object
    //   80: dup
    //   81: iconst_0
    //   82: aload 8
    //   84: ldc_w 666
    //   87: invokestatic 544	com/tencent/mm/compatible/util/q:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   90: aastore
    //   91: invokestatic 1217	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   94: astore 4
    //   96: aload_0
    //   97: invokevirtual 258	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   100: aload_0
    //   101: invokevirtual 258	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   104: getfield 270	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:pGj	Lcom/tencent/mm/ui/widget/MMWebView;
    //   107: invokevirtual 275	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
    //   110: invokevirtual 511	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:aXD	(Ljava/lang/String;)Ljava/lang/String;
    //   113: astore 9
    //   115: ldc 224
    //   117: ldc_w 1317
    //   120: iconst_1
    //   121: anewarray 228	java/lang/Object
    //   124: dup
    //   125: iconst_0
    //   126: getstatic 1320	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   129: aastore
    //   130: invokestatic 480	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   133: aload 9
    //   135: invokestatic 517	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   138: ifne +176 -> 314
    //   141: aload_0
    //   142: invokevirtual 258	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   145: getfield 270	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:pGj	Lcom/tencent/mm/ui/widget/MMWebView;
    //   148: invokevirtual 275	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
    //   151: invokestatic 517	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   154: ifne +160 -> 314
    //   157: invokestatic 527	com/tencent/mm/sdk/platformtools/Util:nowSecond	()J
    //   160: lstore_2
    //   161: ldc 224
    //   163: ldc_w 1322
    //   166: bipush 7
    //   168: anewarray 228	java/lang/Object
    //   171: dup
    //   172: iconst_0
    //   173: sipush 13377
    //   176: invokestatic 391	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   179: aastore
    //   180: dup
    //   181: iconst_1
    //   182: lload_2
    //   183: invokestatic 534	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   186: aastore
    //   187: dup
    //   188: iconst_2
    //   189: aload 9
    //   191: aastore
    //   192: dup
    //   193: iconst_3
    //   194: aload_0
    //   195: invokevirtual 258	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   198: getfield 270	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:pGj	Lcom/tencent/mm/ui/widget/MMWebView;
    //   201: invokevirtual 275	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
    //   204: aastore
    //   205: dup
    //   206: iconst_4
    //   207: aload_0
    //   208: invokevirtual 258	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   211: getfield 537	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sessionId	Ljava/lang/String;
    //   214: aastore
    //   215: dup
    //   216: iconst_5
    //   217: iconst_4
    //   218: invokestatic 391	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   221: aastore
    //   222: dup
    //   223: bipush 6
    //   225: iconst_1
    //   226: invokestatic 391	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   229: aastore
    //   230: invokestatic 480	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   233: ldc 137
    //   235: astore 5
    //   237: aload_0
    //   238: invokevirtual 258	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   241: getfield 270	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:pGj	Lcom/tencent/mm/ui/widget/MMWebView;
    //   244: invokevirtual 275	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
    //   247: ldc_w 539
    //   250: invokestatic 544	com/tencent/mm/compatible/util/q:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   253: astore 6
    //   255: aload 6
    //   257: astore 5
    //   259: getstatic 566	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
    //   262: sipush 13377
    //   265: bipush 6
    //   267: anewarray 228	java/lang/Object
    //   270: dup
    //   271: iconst_0
    //   272: lload_2
    //   273: invokestatic 534	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   276: aastore
    //   277: dup
    //   278: iconst_1
    //   279: aload 9
    //   281: aastore
    //   282: dup
    //   283: iconst_2
    //   284: aload 5
    //   286: aastore
    //   287: dup
    //   288: iconst_3
    //   289: aload_0
    //   290: invokevirtual 258	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   293: getfield 537	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sessionId	Ljava/lang/String;
    //   296: aastore
    //   297: dup
    //   298: iconst_4
    //   299: iconst_4
    //   300: invokestatic 391	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   303: aastore
    //   304: dup
    //   305: iconst_5
    //   306: iconst_1
    //   307: invokestatic 391	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   310: aastore
    //   311: invokevirtual 569	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
    //   314: aload 4
    //   316: astore 5
    //   318: aload 4
    //   320: invokestatic 444	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   323: ifeq +23 -> 346
    //   326: getstatic 1325	com/tencent/mm/ui/e$e:OyU	Ljava/lang/String;
    //   329: iconst_1
    //   330: anewarray 228	java/lang/Object
    //   333: dup
    //   334: iconst_0
    //   335: bipush 34
    //   337: invokestatic 391	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   340: aastore
    //   341: invokestatic 1217	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   344: astore 5
    //   346: new 553	android/content/Intent
    //   349: dup
    //   350: invokespecial 1326	android/content/Intent:<init>	()V
    //   353: astore 4
    //   355: aload_1
    //   356: invokestatic 444	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   359: ifne +24 -> 383
    //   362: aload 4
    //   364: ldc_w 1328
    //   367: aload_1
    //   368: ldc_w 539
    //   371: invokevirtual 1332	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   374: bipush 11
    //   376: invokestatic 1338	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   379: invokevirtual 1342	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   382: pop
    //   383: ldc 224
    //   385: ldc_w 1344
    //   388: iconst_2
    //   389: anewarray 228	java/lang/Object
    //   392: dup
    //   393: iconst_0
    //   394: aload 8
    //   396: aastore
    //   397: dup
    //   398: iconst_1
    //   399: aload_0
    //   400: invokevirtual 258	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   403: invokevirtual 662	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:coX	()Ljava/lang/String;
    //   406: aastore
    //   407: invokestatic 239	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   410: aload 4
    //   412: ldc_w 1346
    //   415: aload 5
    //   417: invokevirtual 1342	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   420: pop
    //   421: aload 4
    //   423: ldc_w 1348
    //   426: aload 8
    //   428: invokevirtual 1342	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   431: pop
    //   432: aload 4
    //   434: ldc_w 1350
    //   437: aload_0
    //   438: invokevirtual 258	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   441: invokevirtual 662	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:coX	()Ljava/lang/String;
    //   444: invokevirtual 1342	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   447: pop
    //   448: aload 4
    //   450: ldc_w 1352
    //   453: aload_0
    //   454: invokevirtual 258	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   457: aload 7
    //   459: invokevirtual 560	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:aXI	(Ljava/lang/String;)I
    //   462: invokevirtual 1355	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   465: pop
    //   466: aload 4
    //   468: ldc_w 1357
    //   471: iconst_1
    //   472: invokevirtual 1360	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   475: pop
    //   476: aload_0
    //   477: invokevirtual 258	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   480: aload_0
    //   481: invokevirtual 258	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   484: ldc_w 1361
    //   487: invokevirtual 582	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   490: ldc 137
    //   492: aload_0
    //   493: invokevirtual 258	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   496: ldc_w 1362
    //   499: invokevirtual 582	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   502: aload_0
    //   503: invokevirtual 258	com/tencent/mm/plugin/webview/ui/tools/j:geo	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   506: ldc_w 1363
    //   509: invokevirtual 582	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   512: iconst_0
    //   513: new 10	com/tencent/mm/plugin/webview/ui/tools/j$11
    //   516: dup
    //   517: aload_0
    //   518: aload 4
    //   520: invokespecial 1366	com/tencent/mm/plugin/webview/ui/tools/j$11:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/j;Landroid/content/Intent;)V
    //   523: new 14	com/tencent/mm/plugin/webview/ui/tools/j$13
    //   526: dup
    //   527: aload_0
    //   528: aload 4
    //   530: invokespecial 1367	com/tencent/mm/plugin/webview/ui/tools/j$13:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/j;Landroid/content/Intent;)V
    //   533: invokestatic 1370	com/tencent/mm/ui/base/h:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mm/ui/widget/a/d;
    //   536: pop
    //   537: ldc_w 1301
    //   540: invokestatic 183	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   543: return
    //   544: astore 4
    //   546: ldc 224
    //   548: aload 4
    //   550: invokevirtual 1371	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   553: invokestatic 730	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   556: aconst_null
    //   557: astore 4
    //   559: goto -463 -> 96
    //   562: astore 6
    //   564: ldc 224
    //   566: aload 6
    //   568: ldc 137
    //   570: iconst_0
    //   571: anewarray 228	java/lang/Object
    //   574: invokestatic 245	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   577: goto -318 -> 259
    //   580: astore_1
    //   581: ldc 224
    //   583: new 414	java/lang/StringBuilder
    //   586: dup
    //   587: ldc_w 1373
    //   590: invokespecial 418	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   593: aload_1
    //   594: invokevirtual 1371	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   597: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: invokevirtual 427	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   603: invokestatic 730	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   606: goto -223 -> 383
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	609	0	this	j
    //   0	609	1	paramString	String
    //   160	113	2	l	long
    //   31	498	4	localObject1	Object
    //   544	5	4	localUnsupportedEncodingException1	UnsupportedEncodingException
    //   557	1	4	localObject2	Object
    //   235	181	5	localObject3	Object
    //   253	3	6	str1	String
    //   562	5	6	localUnsupportedEncodingException2	UnsupportedEncodingException
    //   19	439	7	str2	String
    //   28	399	8	str3	String
    //   113	167	9	str4	String
    // Exception table:
    //   from	to	target	type
    //   73	96	544	java/io/UnsupportedEncodingException
    //   237	255	562	java/io/UnsupportedEncodingException
    //   362	383	580	java/io/UnsupportedEncodingException
  }
  
  protected final void cjP()
  {
    AppMethodBeat.i(79897);
    String str1 = geo().aXD(geo().gfu());
    String str2 = geo().getIntent().getStringExtra("shortcut_user_name");
    if ((Util.isNullOrNil(str1)) || (Util.isNullOrNil(str2)))
    {
      Log.e("MicroMsg.WebViewMenuHelper", "addShortcut, appid or username is null");
      AppMethodBeat.o(79897);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("KAppId", str1);
    localBundle.putString("shortcut_user_name", str2);
    localBundle.putInt("webviewui_binder_id", hashCode());
    try
    {
      geo().IMH.mHh.j(80, localBundle);
      AppMethodBeat.o(79897);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.WebViewMenuHelper", "addShortcut, e = " + localException.getMessage());
      AppMethodBeat.o(79897);
    }
  }
  
  public final void cpD()
  {
    AppMethodBeat.i(258618);
    Mf(0L);
    AppMethodBeat.o(258618);
  }
  
  public final void cpE()
  {
    AppMethodBeat.i(79900);
    if ((geo() == null) || (geo().pGj == null) || (geo().mHi == null))
    {
      Log.e("MicroMsg.WebViewMenuHelper", "setShareFuncFlag params failed");
      AppMethodBeat.o(79900);
      return;
    }
    String str = geo().pGj.getUrl();
    if (!Util.isNullOrNil(str))
    {
      try
      {
        boolean bool = new URL(str).getHost().equals(WeChatHosts.domainString(2131761726));
        if (bool) {
          break label138;
        }
        AppMethodBeat.o(79900);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.WebViewMenuHelper", "create url fail : " + localException.getLocalizedMessage());
        AppMethodBeat.o(79900);
        return;
      }
    }
    else
    {
      AppMethodBeat.o(79900);
      return;
    }
    label138:
    int i = geT();
    if (geo().IBw != null) {
      geo().IBw.gi("setFuncFlag", i);
    }
    AppMethodBeat.o(79900);
  }
  
  public final void g(String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(211077);
    SparseBooleanArray localSparseBooleanArray2 = (SparseBooleanArray)this.Jgj.get(paramString);
    SparseBooleanArray localSparseBooleanArray1 = localSparseBooleanArray2;
    if (localSparseBooleanArray2 == null)
    {
      localSparseBooleanArray1 = new SparseBooleanArray();
      this.Jgj.put(paramString, localSparseBooleanArray1);
    }
    if (localSparseBooleanArray1 != null)
    {
      localSparseBooleanArray1.put(34, true);
      localSparseBooleanArray1.put(10, paramIntent.getBooleanExtra("key_menu_hide_expose", false));
    }
    AppMethodBeat.o(211077);
  }
  
  public final void geK()
  {
    AppMethodBeat.i(79879);
    this.Jgk.clear();
    this.Jgk.put("menuItem:share:brand", Integer.valueOf(0));
    this.Jgk.put("menuItem:share:appMessage", Integer.valueOf(1));
    this.Jgk.put("menuItem:share:dataMessage", Integer.valueOf(23));
    this.Jgk.put("menuItem:share:timeline", Integer.valueOf(2));
    this.Jgk.put("menuItem:favorite", Integer.valueOf(3));
    this.Jgk.put("menuItem:profile", Integer.valueOf(5));
    this.Jgk.put("menuItem:addContact", Integer.valueOf(5));
    this.Jgk.put("menuItem:copyUrl", Integer.valueOf(6));
    this.Jgk.put("menuItem:openWithSafari", Integer.valueOf(7));
    this.Jgk.put("menuItem:share:email", Integer.valueOf(8));
    this.Jgk.put("menuItem:delete", Integer.valueOf(9));
    this.Jgk.put("menuItem:exposeArticle", Integer.valueOf(10));
    this.Jgk.put("menuItem:setFont", Integer.valueOf(11));
    this.Jgk.put("menuItem:editTag", Integer.valueOf(12));
    this.Jgk.put("menuItem:share:qq", Integer.valueOf(20));
    this.Jgk.put("menuItem:share:weiboApp", Integer.valueOf(21));
    this.Jgk.put("menuItem:share:QZone", Integer.valueOf(22));
    this.Jgk.put("menuItem:share:facebook", Integer.valueOf(33));
    this.Jgk.put("menuItem:share:enterprise", Integer.valueOf(24));
    this.Jgk.put("menuItem:refresh", Integer.valueOf(28));
    this.Jgk.put("menuItem:share:wework", Integer.valueOf(25));
    this.Jgk.put("menuItem:share:wework_LOCAL", Integer.valueOf(43));
    this.Jgk.put("menuItem:share:weread", Integer.valueOf(26));
    this.Jgk.put("menuItem:addShortcut", Integer.valueOf(29));
    this.Jgk.put("menuItem:search", Integer.valueOf(31));
    this.Jgk.put("menuItem:readArticle", Integer.valueOf(34));
    this.Jgk.put("menuItem:minimize", Integer.valueOf(35));
    this.Jgk.put("menuItem:cancelMinimize", Integer.valueOf(36));
    this.Jgk.put("menuItem:translate", Integer.valueOf(37));
    this.Jgk.put("menuItem:haoKan", Integer.valueOf(38));
    this.Jgk.put("menuItem:cancelHaoKan", Integer.valueOf(39));
    this.Jgk.put("menuItem:ttsStart", Integer.valueOf(40));
    this.Jgk.put("menuItem:ttsPause", Integer.valueOf(41));
    this.Jgk.put("menuItem:ttsResume", Integer.valueOf(42));
    AppMethodBeat.o(79879);
  }
  
  public final boolean geL()
  {
    AppMethodBeat.i(211078);
    if (this.nVN == null)
    {
      AppMethodBeat.o(211078);
      return false;
    }
    boolean bool = this.nVN.isShowing();
    AppMethodBeat.o(211078);
    return bool;
  }
  
  protected final void geM()
  {
    AppMethodBeat.i(79884);
    if (!this.Jgs)
    {
      AppMethodBeat.o(79884);
      return;
    }
    this.Jgr = false;
    geo().JjM = false;
    this.Jgs = false;
    if (geL()) {
      Mf(0L);
    }
    AppMethodBeat.o(79884);
  }
  
  public final void geN()
  {
    AppMethodBeat.i(79886);
    this.Jgr = true;
    this.Jgt.clear();
    if ((geo() instanceof GameWebViewUI))
    {
      this.Jgt.add(Integer.valueOf(11));
      this.Jgt.add(Integer.valueOf(28));
      AppMethodBeat.o(79886);
      return;
    }
    this.Jgt.add(Integer.valueOf(7));
    this.Jgt.add(Integer.valueOf(11));
    this.Jgt.add(Integer.valueOf(28));
    AppMethodBeat.o(79886);
  }
  
  protected final void geP()
  {
    AppMethodBeat.i(79892);
    if (geo().IBw != null)
    {
      geo().IBw.aYi("fav");
      geo().IBw.cL("sendAppMessage", false);
      geo().IBw.d(geQ(), 0);
      AppMethodBeat.o(79892);
      return;
    }
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putLong("msg_id", geo().getIntent().getLongExtra("msg_id", -9223372036854775808L));
    ((Bundle)localObject1).putString("sns_local_id", geo().getIntent().getStringExtra("sns_local_id"));
    ((Bundle)localObject1).putInt("news_svr_id", geo().getIntent().getIntExtra("news_svr_id", 0));
    ((Bundle)localObject1).putString("news_svr_tweetid", geo().getIntent().getStringExtra("news_svr_tweetid"));
    ((Bundle)localObject1).putInt("message_index", geo().getIntent().getIntExtra("message_index", 0));
    ((Bundle)localObject1).putString("rawUrl", geo().coX());
    Object localObject2;
    if ((!Util.isNullOrNil(geo().coX())) && (geo().coX().endsWith("#rd")))
    {
      localObject2 = geo().coX().substring(0, geo().coX().length() - 3);
      if ((!Util.isNullOrNil(geo().gfu())) && (!geo().gfu().startsWith((String)localObject2)))
      {
        ((Bundle)localObject1).putString("rawUrl", geo().gfu());
        ((Bundle)localObject1).putLong("msg_id", -9223372036854775808L);
      }
    }
    for (;;)
    {
      localObject2 = geo().getIntent();
      if (localObject2 != null)
      {
        ((Bundle)localObject1).putString("preChatName", ((Intent)localObject2).getStringExtra("preChatName"));
        ((Bundle)localObject1).putInt("preMsgIndex", ((Intent)localObject2).getIntExtra("preMsgIndex", 0));
        ((Bundle)localObject1).putString("prePublishId", ((Intent)localObject2).getStringExtra("prePublishId"));
        ((Bundle)localObject1).putString("preUsername", ((Intent)localObject2).getStringExtra("preUsername"));
      }
      try
      {
        localObject1 = geo().IMH.mHh.aY((Bundle)localObject1);
        if (((com.tencent.mm.plugin.webview.stub.c)localObject1).gdT())
        {
          geo().IBw.cL("sendAppMessage", false);
          geo().IBw.d(geQ(), 0);
          Log.i("MicroMsg.WebViewMenuHelper", "on favorite simple url");
          AppMethodBeat.o(79892);
          return;
          if ((!Util.isNullOrNil(geo().gfu())) && (!geo().gfu().startsWith(geo().coX())))
          {
            ((Bundle)localObject1).putString("rawUrl", geo().gfu());
            ((Bundle)localObject1).putLong("msg_id", -9223372036854775808L);
          }
        }
        else
        {
          com.tencent.mm.plugin.fav.ui.e.a(((com.tencent.mm.plugin.webview.stub.c)localObject1).getRet(), geo(), geo().xxK);
          if (((com.tencent.mm.plugin.webview.stub.c)localObject1).getRet() == 0)
          {
            agJ(1);
            AppMethodBeat.o(79892);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.WebViewMenuHelper", "edw, favoriteUrl fail, ex = " + localException.getMessage());
        AppMethodBeat.o(79892);
        return;
      }
    }
    agJ(2);
    AppMethodBeat.o(79892);
  }
  
  public final HashMap<String, String> geQ()
  {
    AppMethodBeat.i(79893);
    if (!geo().JjM)
    {
      AppMethodBeat.o(79893);
      return null;
    }
    Intent localIntent = geo().getIntent();
    String str1 = localIntent.getStringExtra("share_report_pre_msg_url");
    String str2 = localIntent.getStringExtra("share_report_pre_msg_title");
    String str3 = localIntent.getStringExtra("share_report_pre_msg_icon_url");
    HashMap localHashMap = new HashMap();
    localHashMap.put("share_report_pre_msg_url", str1);
    localHashMap.put("share_report_pre_msg_title", str2);
    localHashMap.put("share_report_pre_msg_desc", localIntent.getStringExtra("share_report_pre_msg_desc"));
    localHashMap.put("share_report_pre_msg_icon_url", str3);
    AppMethodBeat.o(79893);
    return localHashMap;
  }
  
  final boolean geR()
  {
    AppMethodBeat.i(79896);
    try
    {
      boolean bool = geo().IMH.mHh.aZU("favorite");
      AppMethodBeat.o(79896);
      return bool;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.WebViewMenuHelper", localException, "", new Object[0]);
      AppMethodBeat.o(79896);
    }
    return false;
  }
  
  public final void geS()
  {
    AppMethodBeat.i(79899);
    if ((geo() == null) || (geo().mHi == null))
    {
      Log.e("MicroMsg.WebViewMenuHelper", "showShareMenu params failed");
      AppMethodBeat.o(79899);
      return;
    }
    final JsapiPermissionWrapper localJsapiPermissionWrapper = geo().mHi.gdH();
    if ((!a(localJsapiPermissionWrapper, 21, 1)) && (!a(localJsapiPermissionWrapper, 23, 2)))
    {
      com.tencent.mm.ui.base.h.cD(geo(), geo().getString(2131768771));
      AppMethodBeat.o(79899);
      return;
    }
    com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(geo(), 1, false);
    locale.HLX = new o.f()
    {
      public final void onCreateMMMenu(m paramAnonymousm)
      {
        AppMethodBeat.i(211066);
        if (j.this.a(localJsapiPermissionWrapper, 21, 1)) {
          paramAnonymousm.a(1, j.this.geo().getString(2131764184), 2131689844, false);
        }
        if (j.this.a(localJsapiPermissionWrapper, 23, 2)) {
          paramAnonymousm.a(2, j.this.geo().getString(2131764185), 2131689830, false);
        }
        AppMethodBeat.o(211066);
      }
    };
    locale.HLY = new o.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        paramAnonymousInt = 0;
        AppMethodBeat.i(211067);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(211067);
          return;
          paramAnonymousMenuItem = j.this.geo().getIntent().getStringExtra("KPublisherId");
          String str1 = j.this.geo().getIntent().getStringExtra("KAppId");
          String str2 = j.this.geo().getIntent().getStringExtra("srcUsername");
          j.this.geo().IMs.gdh().C(new Object[] { j.this.geo().coX(), Integer.valueOf(1), Integer.valueOf(1), paramAnonymousMenuItem, str1, str2 }).report();
          j.this.geo().agO(1);
          AppMethodBeat.o(211067);
          return;
          paramAnonymousMenuItem = j.this.geo().getIntent().getStringExtra("KPublisherId");
          str1 = j.this.geo().getIntent().getStringExtra("KAppId");
          str2 = j.this.geo().getIntent().getStringExtra("srcUsername");
          j.this.geo().IMs.gdh().C(new Object[] { j.this.geo().coX(), Integer.valueOf(2), Integer.valueOf(1), paramAnonymousMenuItem, str1, str2 }).report();
          if (j.this.Jgq.containsKey(j.this.geo().pGj.getUrl())) {
            paramAnonymousInt = ((Integer)j.this.Jgq.get(j.this.geo().pGj.getUrl())).intValue();
          }
          j.a(j.this, paramAnonymousInt, 1);
        }
      }
    };
    locale.o(" ", 1);
    locale.dGm();
    AppMethodBeat.o(79899);
  }
  
  public final int geT()
  {
    AppMethodBeat.i(79901);
    if ((geo() == null) || (geo().mHi == null))
    {
      Log.e("MicroMsg.WebViewMenuHelper", "getShareFuncFlag params failed");
      AppMethodBeat.o(79901);
      return -1;
    }
    JsapiPermissionWrapper localJsapiPermissionWrapper = geo().mHi.gdH();
    if (a(localJsapiPermissionWrapper, 21, 1)) {}
    for (int i = 1;; i = 0)
    {
      int j = i;
      if (a(localJsapiPermissionWrapper, 23, 2)) {
        j = i | 0x2;
      }
      Log.i("MicroMsg.WebViewMenuHelper", "getShareFuncFlag %d", new Object[] { Integer.valueOf(j) });
      AppMethodBeat.o(79901);
      return j;
    }
  }
  
  public final void gx(String paramString, int paramInt)
  {
    AppMethodBeat.i(79895);
    if (geo().IBw != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt(paramString, paramInt);
      paramString = geo().IBw;
      try
      {
        paramString.mHh.a(21, localBundle, paramString.IRl);
        AppMethodBeat.o(79895);
        return;
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.JsApiHandler", paramString, "", new Object[0]);
        Log.w("MicroMsg.JsApiHandler", "updateJsapiArgsBundleKV, ex = ".concat(String.valueOf(paramString)));
      }
    }
    AppMethodBeat.o(79895);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(79878);
    Iterator localIterator = this.Jgj.values().iterator();
    while (localIterator.hasNext())
    {
      SparseBooleanArray localSparseBooleanArray = (SparseBooleanArray)localIterator.next();
      if (localSparseBooleanArray != null) {
        localSparseBooleanArray.clear();
      }
    }
    this.Jgj.clear();
    this.Jgq.clear();
    if ((this.nVN != null) && (this.nVN.isShowing())) {
      this.nVN.bMo();
    }
    AppMethodBeat.o(79878);
  }
  
  public static final class a
  {
    public int JgK = -1;
    public Bundle JgL = null;
    public boolean neT = false;
    public int nfG = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.j
 * JD-Core Version:    0.7.0.1
 */