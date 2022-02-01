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
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.plugin.appbrand.openmaterial.j;
import com.tencent.mm.plugin.appbrand.openmaterial.j.a;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.webview.WebViewTransHelper;
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.c.e;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.d.n.a;
import com.tencent.mm.plugin.webview.f.g;
import com.tencent.mm.plugin.webview.m;
import com.tencent.mm.plugin.webview.model.ba;
import com.tencent.mm.plugin.webview.model.ba.d;
import com.tencent.mm.plugin.webview.n;
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
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.az;
import com.tencent.mm.ui.base.h.e;
import com.tencent.mm.ui.base.q.b;
import com.tencent.mm.ui.base.q.c;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.u;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.e.c;
import com.tencent.mm.ui.widget.a.e.f;
import com.tencent.neattextview.textview.view.NeatTextView;
import com.tencent.wework.api.IWWAPI;
import com.tencent.wework.api.IWWAPI.WWAppType;
import com.tencent.wework.api.WWAPIFactory;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
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
import java.util.concurrent.Callable;

public final class k
  extends a
{
  HashMap<String, Integer> QdA;
  public boolean QdB;
  public boolean QdC;
  Set<Integer> QdD;
  com.tencent.mm.ui.base.o QdE;
  ArrayList<com.tencent.mm.n.e.b> QdF;
  Boolean QdG;
  String QdH;
  AppBrandOpenMaterialCollection QdI;
  j QdJ;
  private b QdK;
  protected Map<String, SparseBooleanArray> Qdt;
  protected Map<String, Integer> Qdu;
  LruCache<String, Bitmap> Qdv;
  HashMap<String, String> Qdw;
  f Qdx;
  public HashMap<Integer, c> Qdy;
  public String Qdz;
  private int height;
  private String pwX;
  com.tencent.mm.ui.widget.a.e qXn;
  private int width;
  
  public k(WebViewUI paramWebViewUI)
  {
    super(paramWebViewUI);
    AppMethodBeat.i(79877);
    this.Qdt = new HashMap();
    this.Qdu = new HashMap();
    this.Qdv = new LruCache(12);
    this.Qdw = new HashMap();
    this.Qdx = new f(1);
    this.Qdy = new HashMap();
    this.pwX = "";
    this.QdA = new HashMap();
    this.QdB = true;
    this.QdC = false;
    this.QdD = new HashSet();
    this.QdH = null;
    this.QdI = null;
    this.QdJ = null;
    this.QdK = null;
    this.width = paramWebViewUI.getResources().getDisplayMetrics().widthPixels;
    this.height = paramWebViewUI.getResources().getDisplayMetrics().heightPixels;
    AppMethodBeat.o(79877);
  }
  
  static ResolveInfo a(WebViewUI paramWebViewUI, com.tencent.mm.plugin.webview.stub.e parame)
  {
    boolean bool = true;
    AppMethodBeat.i(226459);
    if (parame != null) {
      try
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("WebViewShare_wv_url", paramWebViewUI.elY());
        localBundle = parame.l(120000, localBundle);
        parame = localBundle.getString("default_browser_package_name", "");
        paramWebViewUI = com.tencent.mm.plugin.webview.ui.tools.browser.b.V(paramWebViewUI, parame, localBundle.getString("k_share_url", ""));
        if (paramWebViewUI != null) {}
        for (;;)
        {
          Log.i("MicroMsg.WebViewMenuHelper", "alvinluo getDefaultBrowser defaultBrowserPackageName: %s, defaultBrowser != null: %b", new Object[] { parame, Boolean.valueOf(bool) });
          AppMethodBeat.o(226459);
          return paramWebViewUI;
          bool = false;
        }
        AppMethodBeat.o(226459);
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
    paramInt = paramJsapiPermissionWrapper.arj(paramInt);
    if ((paramInt == 1) || (paramInt == 10))
    {
      AppMethodBeat.o(79882);
      return true;
    }
    AppMethodBeat.o(79882);
    return false;
  }
  
  static boolean a(com.tencent.mm.ui.base.o paramo, int paramInt, Drawable paramDrawable, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(226466);
    if (paramo == null)
    {
      AppMethodBeat.o(226466);
      return false;
    }
    if (paramo.findItem(45) != null)
    {
      Log.w("MicroMsg.WebViewMenuHelper", "alvinluo doAddDefaultBrowserMenuItem has added and ignore");
      AppMethodBeat.o(226466);
      return false;
    }
    Log.d("MicroMsg.WebViewMenuHelper", "alvinluo doAddDefaultBrowserMenuItem index: %s", new Object[] { Integer.valueOf(paramInt) });
    paramo = paramo.a(45, paramInt, paramString, 0, paramBoolean);
    ((com.tencent.mm.ui.base.p)paramo).WkR = TextUtils.TruncateAt.END;
    ((com.tencent.mm.ui.base.p)paramo).WkT = false;
    paramo.setIcon(paramDrawable);
    AppMethodBeat.o(226466);
    return true;
  }
  
  private void aoz(int paramInt)
  {
    AppMethodBeat.i(79891);
    String str2 = gXq().bju(gXq().PIQ.PFK);
    if ((TextUtils.isEmpty(gXq().PIQ.PFK)) || (TextUtils.isEmpty(str2)))
    {
      Log.i("MicroMsg.WebViewMenuHelper", "stev appId is null or empty");
      AppMethodBeat.o(79891);
      return;
    }
    Log.i("MicroMsg.WebViewMenuHelper", "stev appId %s", new Object[] { str2 });
    long l = Util.nowSecond();
    Log.d("MicroMsg.WebViewMenuHelper", "stev report(%s), clickTimestamp : %d, appID : %s, url : %s, sessionId : %s, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13377), Long.valueOf(l), str2, gXq().PIQ.PFK, gXq().sessionId, Integer.valueOf(3), Integer.valueOf(paramInt) });
    Object localObject = "";
    try
    {
      str1 = com.tencent.mm.compatible.util.q.an(gXq().PIQ.PFK, "UTF-8");
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
    i = gXq().bjD(gXq().getIntent().getStringExtra("geta8key_username"));
    str1 = "";
    if ((i == 7) || (i == 56)) {
      str1 = gXq().getIntent().getStringExtra("geta8key_username");
    }
    com.tencent.mm.plugin.report.service.h.IzE.a(13377, new Object[] { Long.valueOf(l), str2, localObject, gXq().sessionId, Integer.valueOf(3), Integer.valueOf(paramInt), Integer.valueOf(0), str1 });
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
    if (paramJsapiPermissionWrapper.arj(paramInt) == 10)
    {
      AppMethodBeat.o(79883);
      return true;
    }
    AppMethodBeat.o(79883);
    return false;
  }
  
  private boolean gXR()
  {
    AppMethodBeat.i(226379);
    try
    {
      JsapiPermissionWrapper localJsapiPermissionWrapper = gXq().PIQ.pGD.gWI();
      if ((aoy(7)) && (a(localJsapiPermissionWrapper, 45)) && (aox(7)) && (!b(localJsapiPermissionWrapper, 45)) && (!this.QdG.booleanValue()))
      {
        AppMethodBeat.o(226379);
        return true;
      }
      AppMethodBeat.o(226379);
      return false;
    }
    catch (Exception localException)
    {
      Log.w("MicroMsg.WebViewMenuHelper", "canShowOpenMaterials fail since ".concat(String.valueOf(localException)));
      AppMethodBeat.o(226379);
    }
    return false;
  }
  
  private ArrayList<com.tencent.mm.n.e.b> gXX()
  {
    AppMethodBeat.i(79888);
    if (gXq().pHS == null)
    {
      Log.w("MicroMsg.WebViewMenuHelper", "getCustomMenuList viewWV is null");
      AppMethodBeat.o(79888);
      return null;
    }
    Object localObject = gXq().pHS.getUrl();
    if (gXq().QfO.containsKey(localObject))
    {
      localObject = (ArrayList)gXq().QfO.get(localObject);
      AppMethodBeat.o(79888);
      return localObject;
    }
    AppMethodBeat.o(79888);
    return null;
  }
  
  final void De(final boolean paramBoolean)
  {
    AppMethodBeat.i(226393);
    Log.d("MicroMsg.WebViewMenuHelper", "loadOpenMaterialsIfNeedAndEnhanceBottomSheet, onBottomSheetCreate: ".concat(String.valueOf(paramBoolean)));
    com.tencent.mm.plugin.appbrand.service.i locali = (com.tencent.mm.plugin.appbrand.service.i)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.i.class);
    if (locali == null)
    {
      Log.w("MicroMsg.WebViewMenuHelper", "loadOpenMaterialsIfNeedAndEnhanceBottomSheet, openMaterialService is null");
      AppMethodBeat.o(226393);
      return;
    }
    if (!locali.c(com.tencent.mm.plugin.appbrand.openmaterial.model.b.qnp))
    {
      Log.i("MicroMsg.WebViewMenuHelper", "loadOpenMaterialsIfNeedAndEnhanceBottomSheet, openMaterialService is disabled");
      AppMethodBeat.o(226393);
      return;
    }
    Object localObject = gXq();
    if (localObject == null)
    {
      Log.w("MicroMsg.WebViewMenuHelper", "loadOpenMaterialsIfNeedAndEnhanceBottomSheet, webViewUI is null");
      AppMethodBeat.o(226393);
      return;
    }
    localObject = ((WebViewUI)localObject).PIQ;
    if (localObject == null)
    {
      Log.w("MicroMsg.WebViewMenuHelper", "loadOpenMaterialsIfNeedAndEnhanceBottomSheet, controller is null");
      AppMethodBeat.o(226393);
      return;
    }
    localObject = ((com.tencent.mm.plugin.webview.core.i)localObject).boj();
    Log.d("MicroMsg.WebViewMenuHelper", "loadOpenMaterialsIfNeedAndEnhanceBottomSheet, url: ".concat(String.valueOf(localObject)));
    if (Util.isNullOrNil((String)localObject))
    {
      Log.w("MicroMsg.WebViewMenuHelper", "loadOpenMaterialsIfNeedAndEnhanceBottomSheet, url is empty");
      com.tencent.e.h.ZvG.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(219496);
          k.this.De(paramBoolean);
          AppMethodBeat.o(219496);
        }
      }, 1000L);
      AppMethodBeat.o(226393);
      return;
    }
    if ((paramBoolean) && (this.QdJ != null))
    {
      this.QdJ.dead();
      this.QdJ = null;
    }
    if (((String)localObject).equals(this.QdH))
    {
      Log.i("MicroMsg.WebViewMenuHelper", "loadOpenMaterialsIfNeedAndEnhanceBottomSheet, already load");
      a(locali);
      AppMethodBeat.o(226393);
      return;
    }
    MaterialModel localMaterialModel = MaterialModel.alk((String)localObject);
    locali.alg(localMaterialModel.mimeType);
    locali.a(localMaterialModel, new a(this, (String)localObject, locali));
    AppMethodBeat.o(226393);
  }
  
  protected final void TF(final long paramLong)
  {
    AppMethodBeat.i(226449);
    if (elX())
    {
      Log.w("MicroMsg.WebViewMenuHelper", "showReaderModeMenu, webViewUI is finished");
      AppMethodBeat.o(226449);
      return;
    }
    this.QdF = gXX();
    if ((this.QdF != null) && (this.QdF.size() > 0))
    {
      bool = true;
      this.QdG = Boolean.valueOf(bool);
      bool = gXT();
      if (!bool)
      {
        if (!this.QdG.booleanValue()) {
          break label227;
        }
        this.qXn = new com.tencent.mm.ui.widget.a.e(gXq(), 1, false);
      }
      label103:
      if (bool) {
        break label247;
      }
    }
    Object localObject2;
    label227:
    label247:
    for (boolean bool = true;; bool = false)
    {
      De(bool);
      this.qXn.ODW = new q.b()
      {
        public final void a(ImageView paramAnonymousImageView, MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(224277);
          if (k.f(paramAnonymousMenuItem))
          {
            paramAnonymousImageView.setVisibility(8);
            AppMethodBeat.o(224277);
            return;
          }
          paramAnonymousMenuItem = paramAnonymousMenuItem.getTitle();
          if ((k.this.Qdv.get(paramAnonymousMenuItem) != null) && (!((Bitmap)k.this.Qdv.get(paramAnonymousMenuItem)).isRecycled()))
          {
            paramAnonymousImageView.setImageBitmap((Bitmap)k.this.Qdv.get(paramAnonymousMenuItem));
            AppMethodBeat.o(224277);
            return;
          }
          Log.w("MicroMsg.WebViewMenuHelper", "on attach icon, load from cache fail");
          try
          {
            Object localObject = k.this.gXq().PIQ.pGC.blL(paramAnonymousMenuItem);
            if (!Util.isNullOrNil((String)localObject))
            {
              localObject = e.bma((String)localObject);
              if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
              {
                paramAnonymousImageView.setImageBitmap((Bitmap)localObject);
                k.this.Qdv.put(paramAnonymousMenuItem, localObject);
              }
            }
            AppMethodBeat.o(224277);
            return;
          }
          catch (Exception paramAnonymousImageView)
          {
            Log.w("MicroMsg.WebViewMenuHelper", "getheadimg, ex = " + paramAnonymousImageView.getMessage());
            AppMethodBeat.o(224277);
          }
        }
      };
      this.qXn.ODX = new q.c()
      {
        public final void a(TextView paramAnonymousTextView, MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(259652);
          paramAnonymousMenuItem = paramAnonymousMenuItem.getTitle();
          if (paramAnonymousTextView != null)
          {
            String str = (String)k.this.Qdw.get(paramAnonymousMenuItem);
            if (Util.isNullOrNil(str))
            {
              paramAnonymousTextView.setText(paramAnonymousMenuItem);
              AppMethodBeat.o(259652);
              return;
            }
            paramAnonymousTextView.setText(com.tencent.mm.pluginsdk.ui.span.l.b(k.this.gXq(), str, paramAnonymousTextView.getTextSize()));
          }
          AppMethodBeat.o(259652);
        }
      };
      localObject2 = new q.g()
      {
        /* Error */
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          // Byte code:
          //   0: ldc 28
          //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   5: aload_0
          //   6: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   9: invokevirtual 38	com/tencent/mm/plugin/webview/ui/tools/k:elX	()Z
          //   12: ifeq +9 -> 21
          //   15: ldc 28
          //   17: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   20: return
          //   21: aload_1
          //   22: invokestatic 45	com/tencent/mm/plugin/webview/ui/tools/k:f	(Landroid/view/MenuItem;)Z
          //   25: ifeq +145 -> 170
          //   28: aload_1
          //   29: invokeinterface 51 1 0
          //   34: checkcast 53	com/tencent/mm/n/e$b
          //   37: astore 5
          //   39: aload 5
          //   41: ifnull +123 -> 164
          //   44: aload_0
          //   45: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   48: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   51: getfield 63	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PvJ	Lcom/tencent/mm/plugin/webview/d/h;
          //   54: astore_1
          //   55: aload_1
          //   56: getfield 69	com/tencent/mm/plugin/webview/d/h:NoX	Z
          //   59: ifne +16 -> 75
          //   62: ldc 71
          //   64: ldc 73
          //   66: invokestatic 79	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   69: ldc 28
          //   71: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   74: return
          //   75: ldc 71
          //   77: ldc 81
          //   79: invokestatic 83	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   82: new 85	java/util/HashMap
          //   85: dup
          //   86: invokespecial 86	java/util/HashMap:<init>	()V
          //   89: astore 6
          //   91: aload 6
          //   93: ldc 88
          //   95: aload 5
          //   97: getfield 91	com/tencent/mm/n/e$b:key	Ljava/lang/String;
          //   100: invokevirtual 95	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
          //   103: pop
          //   104: aload 6
          //   106: ldc 97
          //   108: aload 5
          //   110: getfield 99	com/tencent/mm/n/e$b:title	Ljava/lang/String;
          //   113: invokevirtual 95	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
          //   116: pop
          //   117: ldc 101
          //   119: aload 6
          //   121: aload_1
          //   122: getfield 104	com/tencent/mm/plugin/webview/d/h:PNx	Z
          //   125: aload_1
          //   126: getfield 107	com/tencent/mm/plugin/webview/d/h:EVx	Ljava/lang/String;
          //   129: invokestatic 113	com/tencent/mm/plugin/webview/d/n$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   132: astore 5
          //   134: aload_1
          //   135: getfield 117	com/tencent/mm/plugin/webview/d/h:PNp	Lcom/tencent/mm/ui/widget/MMWebView;
          //   138: new 119	java/lang/StringBuilder
          //   141: dup
          //   142: ldc 121
          //   144: invokespecial 124	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   147: aload 5
          //   149: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   152: ldc 130
          //   154: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   157: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   160: aconst_null
          //   161: invokevirtual 140	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   164: ldc 28
          //   166: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   169: return
          //   170: ldc 142
          //   172: ldc 144
          //   174: iconst_1
          //   175: anewarray 4	java/lang/Object
          //   178: dup
          //   179: iconst_0
          //   180: aload_1
          //   181: invokeinterface 148 1 0
          //   186: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   189: aastore
          //   190: invokestatic 157	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   193: aload_1
          //   194: invokeinterface 148 1 0
          //   199: tableswitch	default:+409 -> 608, 1:+660->859, 2:+895->1094, 3:+1213->1412, 4:+409->608, 5:+1326->1525, 6:+1736->1935, 7:+1831->2030, 8:+2603->2802, 9:+2761->2960, 10:+2861->3060, 11:+1460->1659, 12:+2926->3125, 13:+409->608, 14:+409->608, 15:+3057->3256, 16:+3122->3321, 17:+3187->3386, 18:+3252->3451, 19:+3317->3516, 20:+3919->4118, 21:+4116->4315, 22:+4274->4473, 23:+792->991, 24:+4680->4879, 25:+3382->3581, 26:+3623->3822, 27:+580->779, 28:+1638->1837, 29:+4962->5161, 30:+409->608, 31:+5026->5225, 32:+409->608, 33:+4471->4670, 34:+5150->5349, 35:+5248->5447, 36:+5334->5533, 37:+2590->2789, 38:+1083->1282, 39:+1148->1347, 40:+5490->5689, 41:+5490->5689, 42:+5490->5689, 43:+3382->3581, 44:+5520->5719, 45:+2274->2473, 46:+1290->1489, 47:+409->608, 48:+409->608, 49:+409->608, 50:+409->608, 51:+409->608, 52:+409->608, 53:+409->608, 54:+409->608, 55:+409->608, 56:+409->608, 57:+409->608, 58:+409->608, 59:+409->608, 60:+409->608, 61:+409->608, 62:+409->608, 63:+409->608, 64:+409->608, 65:+409->608, 66:+409->608, 67:+409->608, 68:+409->608, 69:+409->608, 70:+409->608, 71:+409->608, 72:+409->608, 73:+409->608, 74:+409->608, 75:+409->608, 76:+409->608, 77:+409->608, 78:+409->608, 79:+409->608, 80:+409->608, 81:+409->608, 82:+409->608, 83:+409->608, 84:+409->608, 85:+409->608, 86:+409->608, 87:+409->608, 88:+409->608, 89:+409->608, 90:+409->608, 91:+409->608, 92:+409->608, 93:+409->608, 94:+409->608, 95:+409->608, 96:+409->608, 97:+409->608, 98:+409->608, 99:+5391->5590
          //   609: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   612: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   615: getfield 161	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PIx	Lcom/tencent/mm/plugin/webview/model/ba;
          //   618: invokevirtual 167	com/tencent/mm/plugin/webview/model/ba:gWe	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   621: iconst_3
          //   622: anewarray 4	java/lang/Object
          //   625: dup
          //   626: iconst_0
          //   627: aload_0
          //   628: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   631: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   634: invokevirtual 170	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cDu	()Ljava/lang/String;
          //   637: aastore
          //   638: dup
          //   639: iconst_1
          //   640: bipush 16
          //   642: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   645: aastore
          //   646: dup
          //   647: iconst_2
          //   648: iconst_1
          //   649: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   652: aastore
          //   653: invokevirtual 176	com/tencent/mm/plugin/webview/model/ba$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   656: invokevirtual 179	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   659: new 119	java/lang/StringBuilder
          //   662: dup
          //   663: invokespecial 180	java/lang/StringBuilder:<init>	()V
          //   666: aload_1
          //   667: invokeinterface 184 1 0
          //   672: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
          //   675: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   678: astore 5
          //   680: aload 5
          //   682: invokestatic 193	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
          //   685: ifne +5410 -> 6095
          //   688: iconst_0
          //   689: istore_2
          //   690: new 195	android/os/Bundle
          //   693: dup
          //   694: invokespecial 196	android/os/Bundle:<init>	()V
          //   697: astore_1
          //   698: aload_1
          //   699: ldc 198
          //   701: aload 5
          //   703: invokevirtual 201	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
          //   706: aload_0
          //   707: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   710: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   713: getfield 205	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PIQ	Lcom/tencent/mm/plugin/webview/core/i;
          //   716: getfield 211	com/tencent/mm/plugin/webview/core/i:pGC	Lcom/tencent/mm/plugin/webview/stub/e;
          //   719: bipush 50
          //   721: aload_1
          //   722: invokeinterface 217 3 0
          //   727: astore_1
          //   728: aload_1
          //   729: ifnull +31 -> 760
          //   732: aload_1
          //   733: ldc 219
          //   735: invokevirtual 223	android/os/Bundle:getInt	(Ljava/lang/String;)I
          //   738: istore_2
          //   739: iload_2
          //   740: iconst_2
          //   741: if_icmpne +5139 -> 5880
          //   744: iconst_1
          //   745: istore_2
          //   746: aload_1
          //   747: ldc 219
          //   749: invokevirtual 223	android/os/Bundle:getInt	(Ljava/lang/String;)I
          //   752: istore_3
          //   753: iload_3
          //   754: iconst_3
          //   755: if_icmpne +5130 -> 5885
          //   758: iconst_1
          //   759: istore_2
          //   760: iload_2
          //   761: ifeq +5148 -> 5909
          //   764: aload_0
          //   765: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   768: aload 5
          //   770: invokevirtual 226	com/tencent/mm/plugin/webview/ui/tools/k:bmh	(Ljava/lang/String;)V
          //   773: ldc 28
          //   775: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   778: return
          //   779: aload_0
          //   780: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   783: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   786: getfield 161	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PIx	Lcom/tencent/mm/plugin/webview/model/ba;
          //   789: invokevirtual 167	com/tencent/mm/plugin/webview/model/ba:gWe	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   792: iconst_3
          //   793: anewarray 4	java/lang/Object
          //   796: dup
          //   797: iconst_0
          //   798: aload_0
          //   799: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   802: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   805: invokevirtual 170	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cDu	()Ljava/lang/String;
          //   808: aastore
          //   809: dup
          //   810: iconst_1
          //   811: bipush 32
          //   813: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   816: aastore
          //   817: dup
          //   818: iconst_2
          //   819: iconst_1
          //   820: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   823: aastore
          //   824: invokevirtual 176	com/tencent/mm/plugin/webview/model/ba$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   827: invokevirtual 179	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   830: aload_0
          //   831: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   834: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   837: invokevirtual 229	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:gUw	()Z
          //   840: ifne +5255 -> 6095
          //   843: aload_0
          //   844: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   847: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   850: invokevirtual 232	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:finish	()V
          //   853: ldc 28
          //   855: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   858: return
          //   859: aload_0
          //   860: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   863: invokevirtual 235	com/tencent/mm/plugin/webview/ui/tools/a:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   866: invokevirtual 239	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   869: ldc 241
          //   871: invokevirtual 247	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   874: astore_1
          //   875: aload_0
          //   876: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   879: invokevirtual 235	com/tencent/mm/plugin/webview/ui/tools/a:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   882: invokevirtual 239	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   885: ldc 249
          //   887: invokevirtual 247	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   890: astore 5
          //   892: aload_0
          //   893: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   896: invokevirtual 235	com/tencent/mm/plugin/webview/ui/tools/a:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   899: invokevirtual 239	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   902: ldc 251
          //   904: invokevirtual 247	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   907: astore 6
          //   909: aload_0
          //   910: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   913: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   916: getfield 161	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PIx	Lcom/tencent/mm/plugin/webview/model/ba;
          //   919: invokevirtual 167	com/tencent/mm/plugin/webview/model/ba:gWe	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   922: bipush 6
          //   924: anewarray 4	java/lang/Object
          //   927: dup
          //   928: iconst_0
          //   929: aload_0
          //   930: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   933: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   936: invokevirtual 170	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cDu	()Ljava/lang/String;
          //   939: aastore
          //   940: dup
          //   941: iconst_1
          //   942: iconst_1
          //   943: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   946: aastore
          //   947: dup
          //   948: iconst_2
          //   949: iconst_1
          //   950: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   953: aastore
          //   954: dup
          //   955: iconst_3
          //   956: aload_1
          //   957: aastore
          //   958: dup
          //   959: iconst_4
          //   960: aload 5
          //   962: aastore
          //   963: dup
          //   964: iconst_5
          //   965: aload 6
          //   967: aastore
          //   968: invokevirtual 176	com/tencent/mm/plugin/webview/model/ba$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   971: invokevirtual 179	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   974: aload_0
          //   975: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   978: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   981: iconst_0
          //   982: invokevirtual 254	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:aoE	(I)V
          //   985: ldc 28
          //   987: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   990: return
          //   991: new 243	android/content/Intent
          //   994: dup
          //   995: invokespecial 255	android/content/Intent:<init>	()V
          //   998: astore_1
          //   999: aload_0
          //   1000: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   1003: invokevirtual 235	com/tencent/mm/plugin/webview/ui/tools/a:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1006: invokevirtual 239	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   1009: ldc_w 257
          //   1012: invokevirtual 247	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   1015: astore 5
          //   1017: aload 5
          //   1019: ifnull +42 -> 1061
          //   1022: aload_1
          //   1023: ldc_w 259
          //   1026: iconst_1
          //   1027: invokevirtual 263	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
          //   1030: pop
          //   1031: aload_1
          //   1032: ldc_w 257
          //   1035: aload 5
          //   1037: invokevirtual 266	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
          //   1040: pop
          //   1041: aload_0
          //   1042: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   1045: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1048: ldc_w 268
          //   1051: aload_1
          //   1052: invokestatic 273	com/tencent/mm/by/c:f	(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V
          //   1055: ldc 28
          //   1057: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1060: return
          //   1061: aload_1
          //   1062: ldc_w 275
          //   1065: aload_0
          //   1066: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   1069: invokevirtual 235	com/tencent/mm/plugin/webview/ui/tools/a:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1072: invokevirtual 239	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   1075: ldc_w 277
          //   1078: ldc2_w 278
          //   1081: invokevirtual 283	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
          //   1084: invokestatic 288	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   1087: invokevirtual 291	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
          //   1090: pop
          //   1091: goto -50 -> 1041
          //   1094: aload_0
          //   1095: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   1098: invokevirtual 235	com/tencent/mm/plugin/webview/ui/tools/a:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1101: invokevirtual 239	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   1104: ldc 241
          //   1106: invokevirtual 247	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   1109: astore_1
          //   1110: aload_0
          //   1111: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   1114: invokevirtual 235	com/tencent/mm/plugin/webview/ui/tools/a:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1117: invokevirtual 239	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   1120: ldc 249
          //   1122: invokevirtual 247	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   1125: astore 5
          //   1127: aload_0
          //   1128: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   1131: invokevirtual 235	com/tencent/mm/plugin/webview/ui/tools/a:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1134: invokevirtual 239	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   1137: ldc 251
          //   1139: invokevirtual 247	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   1142: astore 6
          //   1144: aload_0
          //   1145: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   1148: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1151: getfield 161	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PIx	Lcom/tencent/mm/plugin/webview/model/ba;
          //   1154: invokevirtual 167	com/tencent/mm/plugin/webview/model/ba:gWe	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   1157: bipush 6
          //   1159: anewarray 4	java/lang/Object
          //   1162: dup
          //   1163: iconst_0
          //   1164: aload_0
          //   1165: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   1168: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1171: invokevirtual 170	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cDu	()Ljava/lang/String;
          //   1174: aastore
          //   1175: dup
          //   1176: iconst_1
          //   1177: iconst_2
          //   1178: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1181: aastore
          //   1182: dup
          //   1183: iconst_2
          //   1184: iconst_1
          //   1185: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1188: aastore
          //   1189: dup
          //   1190: iconst_3
          //   1191: aload_1
          //   1192: aastore
          //   1193: dup
          //   1194: iconst_4
          //   1195: aload 5
          //   1197: aastore
          //   1198: dup
          //   1199: iconst_5
          //   1200: aload 6
          //   1202: aastore
          //   1203: invokevirtual 176	com/tencent/mm/plugin/webview/model/ba$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   1206: invokevirtual 179	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   1209: iconst_0
          //   1210: istore_2
          //   1211: aload_0
          //   1212: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   1215: getfield 295	com/tencent/mm/plugin/webview/ui/tools/k:QdA	Ljava/util/HashMap;
          //   1218: aload_0
          //   1219: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   1222: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1225: getfield 298	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:pHS	Lcom/tencent/mm/ui/widget/MMWebView;
          //   1228: invokevirtual 301	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
          //   1231: invokevirtual 305	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
          //   1234: ifeq +33 -> 1267
          //   1237: aload_0
          //   1238: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   1241: getfield 295	com/tencent/mm/plugin/webview/ui/tools/k:QdA	Ljava/util/HashMap;
          //   1244: aload_0
          //   1245: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   1248: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1251: getfield 298	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:pHS	Lcom/tencent/mm/ui/widget/MMWebView;
          //   1254: invokevirtual 301	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
          //   1257: invokevirtual 309	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
          //   1260: checkcast 150	java/lang/Integer
          //   1263: invokevirtual 312	java/lang/Integer:intValue	()I
          //   1266: istore_2
          //   1267: aload_0
          //   1268: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   1271: iload_2
          //   1272: iconst_0
          //   1273: invokestatic 316	com/tencent/mm/plugin/webview/ui/tools/k:a	(Lcom/tencent/mm/plugin/webview/ui/tools/k;II)V
          //   1276: ldc 28
          //   1278: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1281: return
          //   1282: aload_0
          //   1283: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   1286: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1289: getfield 161	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PIx	Lcom/tencent/mm/plugin/webview/model/ba;
          //   1292: invokevirtual 167	com/tencent/mm/plugin/webview/model/ba:gWe	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   1295: iconst_3
          //   1296: anewarray 4	java/lang/Object
          //   1299: dup
          //   1300: iconst_0
          //   1301: aload_0
          //   1302: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   1305: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1308: invokevirtual 170	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cDu	()Ljava/lang/String;
          //   1311: aastore
          //   1312: dup
          //   1313: iconst_1
          //   1314: bipush 36
          //   1316: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1319: aastore
          //   1320: dup
          //   1321: iconst_2
          //   1322: iconst_1
          //   1323: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1326: aastore
          //   1327: invokevirtual 176	com/tencent/mm/plugin/webview/model/ba$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   1330: invokevirtual 179	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   1333: aload_0
          //   1334: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   1337: iconst_1
          //   1338: invokestatic 319	com/tencent/mm/plugin/webview/ui/tools/k:a	(Lcom/tencent/mm/plugin/webview/ui/tools/k;I)V
          //   1341: ldc 28
          //   1343: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1346: return
          //   1347: aload_0
          //   1348: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   1351: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1354: getfield 161	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PIx	Lcom/tencent/mm/plugin/webview/model/ba;
          //   1357: invokevirtual 167	com/tencent/mm/plugin/webview/model/ba:gWe	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   1360: iconst_3
          //   1361: anewarray 4	java/lang/Object
          //   1364: dup
          //   1365: iconst_0
          //   1366: aload_0
          //   1367: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   1370: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1373: invokevirtual 170	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cDu	()Ljava/lang/String;
          //   1376: aastore
          //   1377: dup
          //   1378: iconst_1
          //   1379: bipush 37
          //   1381: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1384: aastore
          //   1385: dup
          //   1386: iconst_2
          //   1387: iconst_1
          //   1388: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1391: aastore
          //   1392: invokevirtual 176	com/tencent/mm/plugin/webview/model/ba$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   1395: invokevirtual 179	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   1398: aload_0
          //   1399: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   1402: iconst_0
          //   1403: invokestatic 319	com/tencent/mm/plugin/webview/ui/tools/k:a	(Lcom/tencent/mm/plugin/webview/ui/tools/k;I)V
          //   1406: ldc 28
          //   1408: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1411: return
          //   1412: aload_0
          //   1413: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   1416: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1419: getfield 161	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PIx	Lcom/tencent/mm/plugin/webview/model/ba;
          //   1422: invokevirtual 167	com/tencent/mm/plugin/webview/model/ba:gWe	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   1425: iconst_3
          //   1426: anewarray 4	java/lang/Object
          //   1429: dup
          //   1430: iconst_0
          //   1431: aload_0
          //   1432: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   1435: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1438: invokevirtual 170	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cDu	()Ljava/lang/String;
          //   1441: aastore
          //   1442: dup
          //   1443: iconst_1
          //   1444: iconst_3
          //   1445: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1448: aastore
          //   1449: dup
          //   1450: iconst_2
          //   1451: iconst_1
          //   1452: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1455: aastore
          //   1456: invokevirtual 176	com/tencent/mm/plugin/webview/model/ba$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   1459: invokevirtual 179	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   1462: getstatic 325	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
          //   1465: ldc2_w 326
          //   1468: ldc2_w 328
          //   1471: lconst_1
          //   1472: iconst_0
          //   1473: invokevirtual 333	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
          //   1476: aload_0
          //   1477: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   1480: invokevirtual 336	com/tencent/mm/plugin/webview/ui/tools/k:gXY	()V
          //   1483: ldc 28
          //   1485: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1488: return
          //   1489: aload_0
          //   1490: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   1493: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1496: invokevirtual 340	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:gYn	()Lcom/tencent/mm/plugin/handoff/model/HandOffURL;
          //   1499: astore_1
          //   1500: aload_1
          //   1501: ifnull +4594 -> 6095
          //   1504: ldc_w 342
          //   1507: invokestatic 348	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
          //   1510: checkcast 342	com/tencent/mm/plugin/handoff/a/a
          //   1513: aload_1
          //   1514: invokeinterface 351 2 0
          //   1519: ldc 28
          //   1521: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1524: return
          //   1525: aload_0
          //   1526: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   1529: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1532: getfield 161	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PIx	Lcom/tencent/mm/plugin/webview/model/ba;
          //   1535: invokevirtual 167	com/tencent/mm/plugin/webview/model/ba:gWe	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   1538: iconst_3
          //   1539: anewarray 4	java/lang/Object
          //   1542: dup
          //   1543: iconst_0
          //   1544: aload_0
          //   1545: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   1548: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1551: invokevirtual 170	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cDu	()Ljava/lang/String;
          //   1554: aastore
          //   1555: dup
          //   1556: iconst_1
          //   1557: iconst_4
          //   1558: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1561: aastore
          //   1562: dup
          //   1563: iconst_2
          //   1564: iconst_1
          //   1565: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1568: aastore
          //   1569: invokevirtual 176	com/tencent/mm/plugin/webview/model/ba$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   1572: invokevirtual 179	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   1575: aload_0
          //   1576: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   1579: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1582: getfield 354	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:QfN	Ljava/util/HashMap;
          //   1585: aload_0
          //   1586: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   1589: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1592: getfield 298	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:pHS	Lcom/tencent/mm/ui/widget/MMWebView;
          //   1595: invokevirtual 301	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
          //   1598: invokevirtual 309	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
          //   1601: checkcast 356	java/lang/String
          //   1604: astore 5
          //   1606: aload 5
          //   1608: astore_1
          //   1609: aload 5
          //   1611: ifnonnull +19 -> 1630
          //   1614: aload_0
          //   1615: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   1618: invokevirtual 235	com/tencent/mm/plugin/webview/ui/tools/a:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1621: invokevirtual 239	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   1624: ldc 251
          //   1626: invokevirtual 247	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   1629: astore_1
          //   1630: aload_0
          //   1631: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   1634: ldc_w 358
          //   1637: bipush 43
          //   1639: invokevirtual 362	com/tencent/mm/plugin/webview/ui/tools/k:hf	(Ljava/lang/String;I)V
          //   1642: aload_0
          //   1643: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   1646: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1649: aload_1
          //   1650: invokevirtual 365	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bmo	(Ljava/lang/String;)V
          //   1653: ldc 28
          //   1655: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1658: return
          //   1659: aload_0
          //   1660: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   1663: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1666: getfield 161	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PIx	Lcom/tencent/mm/plugin/webview/model/ba;
          //   1669: invokevirtual 167	com/tencent/mm/plugin/webview/model/ba:gWe	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   1672: iconst_3
          //   1673: anewarray 4	java/lang/Object
          //   1676: dup
          //   1677: iconst_0
          //   1678: aload_0
          //   1679: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   1682: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1685: invokevirtual 170	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cDu	()Ljava/lang/String;
          //   1688: aastore
          //   1689: dup
          //   1690: iconst_1
          //   1691: bipush 8
          //   1693: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1696: aastore
          //   1697: dup
          //   1698: iconst_2
          //   1699: iconst_1
          //   1700: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1703: aastore
          //   1704: invokevirtual 176	com/tencent/mm/plugin/webview/model/ba$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   1707: invokevirtual 179	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   1710: aload_0
          //   1711: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   1714: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1717: getfield 369	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:QeZ	Landroid/view/View;
          //   1720: invokevirtual 374	android/view/View:getVisibility	()I
          //   1723: bipush 8
          //   1725: if_icmpne +51 -> 1776
          //   1728: aload_0
          //   1729: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   1732: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1735: getstatic 380	com/tencent/mm/plugin/webview/c$a:font_fade_in	I
          //   1738: invokestatic 386	android/view/animation/AnimationUtils:loadAnimation	(Landroid/content/Context;I)Landroid/view/animation/Animation;
          //   1741: astore_1
          //   1742: aload_0
          //   1743: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   1746: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1749: getfield 369	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:QeZ	Landroid/view/View;
          //   1752: aload_1
          //   1753: invokevirtual 390	android/view/View:startAnimation	(Landroid/view/animation/Animation;)V
          //   1756: aload_0
          //   1757: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   1760: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1763: getfield 369	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:QeZ	Landroid/view/View;
          //   1766: iconst_0
          //   1767: invokevirtual 393	android/view/View:setVisibility	(I)V
          //   1770: ldc 28
          //   1772: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1775: return
          //   1776: aload_0
          //   1777: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   1780: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1783: getstatic 396	com/tencent/mm/plugin/webview/c$a:font_fade_out	I
          //   1786: invokestatic 386	android/view/animation/AnimationUtils:loadAnimation	(Landroid/content/Context;I)Landroid/view/animation/Animation;
          //   1789: astore_1
          //   1790: aload_1
          //   1791: new 13	com/tencent/mm/plugin/webview/ui/tools/k$19$1
          //   1794: dup
          //   1795: aload_0
          //   1796: invokespecial 399	com/tencent/mm/plugin/webview/ui/tools/k$19$1:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/k$19;)V
          //   1799: invokevirtual 405	android/view/animation/Animation:setAnimationListener	(Landroid/view/animation/Animation$AnimationListener;)V
          //   1802: aload_0
          //   1803: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   1806: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1809: getfield 369	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:QeZ	Landroid/view/View;
          //   1812: aload_1
          //   1813: invokevirtual 390	android/view/View:startAnimation	(Landroid/view/animation/Animation;)V
          //   1816: aload_0
          //   1817: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   1820: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1823: getfield 369	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:QeZ	Landroid/view/View;
          //   1826: bipush 8
          //   1828: invokevirtual 393	android/view/View:setVisibility	(I)V
          //   1831: ldc 28
          //   1833: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1836: return
          //   1837: aload_0
          //   1838: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   1841: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1844: getfield 161	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PIx	Lcom/tencent/mm/plugin/webview/model/ba;
          //   1847: invokevirtual 167	com/tencent/mm/plugin/webview/model/ba:gWe	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   1850: iconst_3
          //   1851: anewarray 4	java/lang/Object
          //   1854: dup
          //   1855: iconst_0
          //   1856: aload_0
          //   1857: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   1860: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1863: invokevirtual 170	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cDu	()Ljava/lang/String;
          //   1866: aastore
          //   1867: dup
          //   1868: iconst_1
          //   1869: bipush 10
          //   1871: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1874: aastore
          //   1875: dup
          //   1876: iconst_2
          //   1877: iconst_1
          //   1878: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1881: aastore
          //   1882: invokevirtual 176	com/tencent/mm/plugin/webview/model/ba$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   1885: invokevirtual 179	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   1888: aload_0
          //   1889: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   1892: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1895: astore_1
          //   1896: aload_1
          //   1897: getfield 409	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PHJ	Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/h;
          //   1900: invokevirtual 414	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/h:bUK	()Z
          //   1903: ifeq +12 -> 1915
          //   1906: aload_1
          //   1907: getfield 409	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PHJ	Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/h;
          //   1910: iconst_0
          //   1911: invokevirtual 418	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/h:Dq	(Z)Z
          //   1914: pop
          //   1915: aload_1
          //   1916: getfield 205	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PIQ	Lcom/tencent/mm/plugin/webview/core/i;
          //   1919: ifnull +10 -> 1929
          //   1922: aload_1
          //   1923: getfield 205	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PIQ	Lcom/tencent/mm/plugin/webview/core/i;
          //   1926: invokevirtual 421	com/tencent/mm/plugin/webview/core/i:reload	()V
          //   1929: ldc 28
          //   1931: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1934: return
          //   1935: aload_0
          //   1936: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   1939: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1942: getfield 161	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PIx	Lcom/tencent/mm/plugin/webview/model/ba;
          //   1945: invokevirtual 167	com/tencent/mm/plugin/webview/model/ba:gWe	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   1948: iconst_3
          //   1949: anewarray 4	java/lang/Object
          //   1952: dup
          //   1953: iconst_0
          //   1954: aload_0
          //   1955: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   1958: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1961: invokevirtual 170	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cDu	()Ljava/lang/String;
          //   1964: aastore
          //   1965: dup
          //   1966: iconst_1
          //   1967: iconst_5
          //   1968: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1971: aastore
          //   1972: dup
          //   1973: iconst_2
          //   1974: iconst_1
          //   1975: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1978: aastore
          //   1979: invokevirtual 176	com/tencent/mm/plugin/webview/model/ba$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   1982: invokevirtual 179	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   1985: aload_0
          //   1986: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   1989: astore_1
          //   1990: aload_1
          //   1991: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1994: getfield 205	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PIQ	Lcom/tencent/mm/plugin/webview/core/i;
          //   1997: invokevirtual 424	com/tencent/mm/plugin/webview/core/i:boj	()Ljava/lang/String;
          //   2000: invokestatic 430	com/tencent/mm/sdk/platformtools/ClipboardHelper:setText	(Ljava/lang/CharSequence;)V
          //   2003: aload_1
          //   2004: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2007: aload_1
          //   2008: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2011: getstatic 435	com/tencent/mm/plugin/webview/c$i:wv_alert_copy_link_toast	I
          //   2014: invokevirtual 439	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   2017: iconst_0
          //   2018: invokestatic 445	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
          //   2021: invokevirtual 448	android/widget/Toast:show	()V
          //   2024: ldc 28
          //   2026: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2029: return
          //   2030: aload_0
          //   2031: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   2034: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2037: getfield 161	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PIx	Lcom/tencent/mm/plugin/webview/model/ba;
          //   2040: invokevirtual 167	com/tencent/mm/plugin/webview/model/ba:gWe	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   2043: iconst_3
          //   2044: anewarray 4	java/lang/Object
          //   2047: dup
          //   2048: iconst_0
          //   2049: aload_0
          //   2050: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   2053: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2056: invokevirtual 170	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cDu	()Ljava/lang/String;
          //   2059: aastore
          //   2060: dup
          //   2061: iconst_1
          //   2062: bipush 13
          //   2064: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2067: aastore
          //   2068: dup
          //   2069: iconst_2
          //   2070: iconst_1
          //   2071: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2074: aastore
          //   2075: invokevirtual 176	com/tencent/mm/plugin/webview/model/ba$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   2078: invokevirtual 179	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   2081: aload_0
          //   2082: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   2085: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2088: astore 6
          //   2090: aload_0
          //   2091: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   2094: astore_1
          //   2095: aload 6
          //   2097: getfield 452	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:QgH	Lcom/tencent/mm/plugin/webview/modeltools/a;
          //   2100: astore 7
          //   2102: aload 6
          //   2104: getfield 453	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:pGC	Lcom/tencent/mm/plugin/webview/stub/e;
          //   2107: astore 8
          //   2109: aload 6
          //   2111: invokevirtual 456	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:isFinishing	()Z
          //   2114: ifne +227 -> 2341
          //   2117: aload 7
          //   2119: new 458	java/lang/ref/WeakReference
          //   2122: dup
          //   2123: aload_1
          //   2124: invokespecial 461	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
          //   2127: putfield 467	com/tencent/mm/plugin/webview/modeltools/a:PWI	Ljava/lang/ref/WeakReference;
          //   2130: aload 6
          //   2132: invokevirtual 470	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:elY	()Ljava/lang/String;
          //   2135: astore 5
          //   2137: aload 5
          //   2139: invokestatic 193	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
          //   2142: ifeq +18 -> 2160
          //   2145: ldc_w 472
          //   2148: ldc_w 474
          //   2151: invokestatic 79	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   2154: ldc 28
          //   2156: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2159: return
          //   2160: aload 5
          //   2162: astore_1
          //   2163: aload 8
          //   2165: ifnull +13 -> 2178
          //   2168: aload 8
          //   2170: aload 5
          //   2172: invokeinterface 477 2 0
          //   2177: astore_1
          //   2178: aload_1
          //   2179: astore 5
          //   2181: aload_1
          //   2182: ldc_w 479
          //   2185: invokevirtual 482	java/lang/String:startsWith	(Ljava/lang/String;)Z
          //   2188: ifne +28 -> 2216
          //   2191: aload_1
          //   2192: astore 5
          //   2194: aload_1
          //   2195: ldc_w 484
          //   2198: invokevirtual 482	java/lang/String:startsWith	(Ljava/lang/String;)Z
          //   2201: ifne +15 -> 2216
          //   2204: ldc_w 479
          //   2207: aload_1
          //   2208: invokestatic 487	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
          //   2211: invokevirtual 490	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
          //   2214: astore 5
          //   2216: new 243	android/content/Intent
          //   2219: dup
          //   2220: ldc_w 492
          //   2223: aload 5
          //   2225: invokestatic 498	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
          //   2228: invokespecial 501	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
          //   2231: astore_1
          //   2232: aload 6
          //   2234: invokestatic 505	com/tencent/mm/sdk/platformtools/Util:isOverseasUser	(Landroid/content/Context;)Z
          //   2237: ifne +9 -> 2246
          //   2240: invokestatic 510	com/tencent/mm/sdk/platformtools/ChannelUtil:isGPVersion	()Z
          //   2243: ifeq +209 -> 2452
          //   2246: ldc_w 472
          //   2249: ldc_w 512
          //   2252: iconst_2
          //   2253: anewarray 4	java/lang/Object
          //   2256: dup
          //   2257: iconst_0
          //   2258: aload 6
          //   2260: invokestatic 505	com/tencent/mm/sdk/platformtools/Util:isOverseasUser	(Landroid/content/Context;)Z
          //   2263: invokestatic 517	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
          //   2266: aastore
          //   2267: dup
          //   2268: iconst_1
          //   2269: invokestatic 510	com/tencent/mm/sdk/platformtools/ChannelUtil:isGPVersion	()Z
          //   2272: invokestatic 517	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
          //   2275: aastore
          //   2276: invokestatic 157	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   2279: bipush 29
          //   2281: invokestatic 523	com/tencent/mm/compatible/util/d:qV	(I)Z
          //   2284: ifeq +87 -> 2371
          //   2287: aload 6
          //   2289: iconst_0
          //   2290: aload_1
          //   2291: ldc_w 524
          //   2294: invokestatic 530	android/app/PendingIntent:getActivity	(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
          //   2297: aload 6
          //   2299: iconst_1
          //   2300: aconst_null
          //   2301: new 532	com/tencent/mm/plugin/webview/modeltools/a$1
          //   2304: dup
          //   2305: aload 7
          //   2307: invokespecial 535	com/tencent/mm/plugin/webview/modeltools/a$1:<init>	(Lcom/tencent/mm/plugin/webview/modeltools/a;)V
          //   2310: aconst_null
          //   2311: invokevirtual 539	android/app/PendingIntent:send	(Landroid/content/Context;ILandroid/content/Intent;Landroid/app/PendingIntent$OnFinished;Landroid/os/Handler;)V
          //   2314: ldc 28
          //   2316: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2319: return
          //   2320: astore_1
          //   2321: ldc_w 472
          //   2324: ldc_w 541
          //   2327: iconst_1
          //   2328: anewarray 4	java/lang/Object
          //   2331: dup
          //   2332: iconst_0
          //   2333: aload_1
          //   2334: invokevirtual 544	java/lang/Exception:getMessage	()Ljava/lang/String;
          //   2337: aastore
          //   2338: invokestatic 546	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   2341: ldc 28
          //   2343: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2346: return
          //   2347: astore_1
          //   2348: ldc_w 472
          //   2351: ldc_w 548
          //   2354: iconst_1
          //   2355: anewarray 4	java/lang/Object
          //   2358: dup
          //   2359: iconst_0
          //   2360: aload_1
          //   2361: aastore
          //   2362: invokestatic 546	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   2365: aload 5
          //   2367: astore_1
          //   2368: goto -190 -> 2178
          //   2371: new 550	com/tencent/mm/hellhoundlib/b/a
          //   2374: dup
          //   2375: invokespecial 551	com/tencent/mm/hellhoundlib/b/a:<init>	()V
          //   2378: aload_1
          //   2379: invokevirtual 555	com/tencent/mm/hellhoundlib/b/a:bm	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
          //   2382: astore_1
          //   2383: aload 6
          //   2385: aload_1
          //   2386: invokevirtual 559	com/tencent/mm/hellhoundlib/b/a:aFh	()[Ljava/lang/Object;
          //   2389: ldc_w 561
          //   2392: ldc_w 563
          //   2395: ldc_w 565
          //   2398: ldc_w 567
          //   2401: ldc_w 569
          //   2404: ldc_w 571
          //   2407: invokestatic 576	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
          //   2410: aload 6
          //   2412: aload_1
          //   2413: iconst_0
          //   2414: invokevirtual 580	com/tencent/mm/hellhoundlib/b/a:sf	(I)Ljava/lang/Object;
          //   2417: checkcast 243	android/content/Intent
          //   2420: invokevirtual 582	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:startActivity	(Landroid/content/Intent;)V
          //   2423: aload 6
          //   2425: ldc_w 561
          //   2428: ldc_w 563
          //   2431: ldc_w 565
          //   2434: ldc_w 567
          //   2437: ldc_w 569
          //   2440: ldc_w 571
          //   2443: invokestatic 586	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
          //   2446: ldc 28
          //   2448: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2451: return
          //   2452: aload 6
          //   2454: aload 6
          //   2456: aload_1
          //   2457: aload 5
          //   2459: invokestatic 591	com/tencent/mm/plugin/webview/ui/tools/browser/b:a	(Landroid/app/Activity;Landroid/content/Intent;Ljava/lang/String;)Landroid/content/Intent;
          //   2462: bipush 6
          //   2464: invokevirtual 595	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:startActivityForResult	(Landroid/content/Intent;I)V
          //   2467: ldc 28
          //   2469: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2472: return
          //   2473: ldc_w 597
          //   2476: astore 5
          //   2478: aload_0
          //   2479: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   2482: getfield 601	com/tencent/mm/plugin/webview/ui/tools/k:Qdx	Lcom/tencent/mm/plugin/webview/ui/tools/browser/f;
          //   2485: getfield 607	com/tencent/mm/plugin/webview/ui/tools/browser/f:pN	Landroid/content/pm/ResolveInfo;
          //   2488: astore 6
          //   2490: aload 5
          //   2492: astore_1
          //   2493: aload 6
          //   2495: ifnull +29 -> 2524
          //   2498: aload 5
          //   2500: astore_1
          //   2501: aload 6
          //   2503: getfield 613	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
          //   2506: ifnull +18 -> 2524
          //   2509: aload 6
          //   2511: getfield 613	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
          //   2514: getfield 618	android/content/pm/ActivityInfo:packageName	Ljava/lang/String;
          //   2517: ldc_w 597
          //   2520: invokestatic 622	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
          //   2523: astore_1
          //   2524: aload_0
          //   2525: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   2528: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2531: getfield 161	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PIx	Lcom/tencent/mm/plugin/webview/model/ba;
          //   2534: invokevirtual 167	com/tencent/mm/plugin/webview/model/ba:gWe	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   2537: pop
          //   2538: aload_0
          //   2539: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   2542: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2545: invokevirtual 170	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cDu	()Ljava/lang/String;
          //   2548: astore 5
          //   2550: getstatic 325	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
          //   2553: sipush 11577
          //   2556: bipush 8
          //   2558: anewarray 4	java/lang/Object
          //   2561: dup
          //   2562: iconst_0
          //   2563: aload 5
          //   2565: aastore
          //   2566: dup
          //   2567: iconst_1
          //   2568: bipush 39
          //   2570: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2573: aastore
          //   2574: dup
          //   2575: iconst_2
          //   2576: iconst_3
          //   2577: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2580: aastore
          //   2581: dup
          //   2582: iconst_3
          //   2583: ldc_w 597
          //   2586: aastore
          //   2587: dup
          //   2588: iconst_4
          //   2589: ldc_w 597
          //   2592: aastore
          //   2593: dup
          //   2594: iconst_5
          //   2595: ldc_w 597
          //   2598: aastore
          //   2599: dup
          //   2600: bipush 6
          //   2602: iconst_0
          //   2603: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2606: aastore
          //   2607: dup
          //   2608: bipush 7
          //   2610: aload_1
          //   2611: aastore
          //   2612: invokevirtual 625	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
          //   2615: aload_0
          //   2616: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   2619: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2622: astore 7
          //   2624: aload 7
          //   2626: getfield 453	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:pGC	Lcom/tencent/mm/plugin/webview/stub/e;
          //   2629: astore 8
          //   2631: aload 7
          //   2633: invokevirtual 456	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:isFinishing	()Z
          //   2636: ifne +123 -> 2759
          //   2639: aload 7
          //   2641: invokevirtual 470	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:elY	()Ljava/lang/String;
          //   2644: astore 5
          //   2646: aload 5
          //   2648: invokestatic 193	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
          //   2651: ifeq +18 -> 2669
          //   2654: ldc_w 472
          //   2657: ldc_w 474
          //   2660: invokestatic 79	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   2663: ldc 28
          //   2665: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2668: return
          //   2669: aload 5
          //   2671: astore_1
          //   2672: aload 8
          //   2674: ifnull +13 -> 2687
          //   2677: aload 8
          //   2679: aload 5
          //   2681: invokeinterface 477 2 0
          //   2686: astore_1
          //   2687: aload_1
          //   2688: astore 5
          //   2690: aload_1
          //   2691: ldc_w 479
          //   2694: invokevirtual 482	java/lang/String:startsWith	(Ljava/lang/String;)Z
          //   2697: ifne +28 -> 2725
          //   2700: aload_1
          //   2701: astore 5
          //   2703: aload_1
          //   2704: ldc_w 484
          //   2707: invokevirtual 482	java/lang/String:startsWith	(Ljava/lang/String;)Z
          //   2710: ifne +15 -> 2725
          //   2713: ldc_w 479
          //   2716: aload_1
          //   2717: invokestatic 487	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
          //   2720: invokevirtual 490	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
          //   2723: astore 5
          //   2725: new 243	android/content/Intent
          //   2728: dup
          //   2729: ldc_w 492
          //   2732: aload 5
          //   2734: invokestatic 498	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
          //   2737: invokespecial 501	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
          //   2740: astore_1
          //   2741: aload_1
          //   2742: ldc_w 627
          //   2745: aload 5
          //   2747: invokevirtual 266	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
          //   2750: pop
          //   2751: aload 7
          //   2753: aload_1
          //   2754: aload 6
          //   2756: invokestatic 630	com/tencent/mm/plugin/webview/ui/tools/browser/b:a	(Landroid/content/Context;Landroid/content/Intent;Landroid/content/pm/ResolveInfo;)V
          //   2759: ldc 28
          //   2761: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2764: return
          //   2765: astore_1
          //   2766: ldc_w 472
          //   2769: ldc_w 548
          //   2772: iconst_1
          //   2773: anewarray 4	java/lang/Object
          //   2776: dup
          //   2777: iconst_0
          //   2778: aload_1
          //   2779: aastore
          //   2780: invokestatic 546	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   2783: aload 5
          //   2785: astore_1
          //   2786: goto -99 -> 2687
          //   2789: aload_0
          //   2790: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   2793: invokestatic 632	com/tencent/mm/plugin/webview/ui/tools/k:a	(Lcom/tencent/mm/plugin/webview/ui/tools/k;)V
          //   2796: ldc 28
          //   2798: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2801: return
          //   2802: aload_0
          //   2803: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   2806: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2809: getfield 161	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PIx	Lcom/tencent/mm/plugin/webview/model/ba;
          //   2812: invokevirtual 167	com/tencent/mm/plugin/webview/model/ba:gWe	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   2815: iconst_3
          //   2816: anewarray 4	java/lang/Object
          //   2819: dup
          //   2820: iconst_0
          //   2821: aload_0
          //   2822: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   2825: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2828: invokevirtual 170	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cDu	()Ljava/lang/String;
          //   2831: aastore
          //   2832: dup
          //   2833: iconst_1
          //   2834: bipush 15
          //   2836: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2839: aastore
          //   2840: dup
          //   2841: iconst_2
          //   2842: iconst_1
          //   2843: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2846: aastore
          //   2847: invokevirtual 176	com/tencent/mm/plugin/webview/model/ba$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   2850: invokevirtual 179	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   2853: aload_0
          //   2854: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   2857: astore_1
          //   2858: aload_1
          //   2859: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2862: getfield 63	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PvJ	Lcom/tencent/mm/plugin/webview/d/h;
          //   2865: ldc_w 634
          //   2868: iconst_1
          //   2869: invokevirtual 638	com/tencent/mm/plugin/webview/d/h:cZ	(Ljava/lang/String;Z)V
          //   2872: aload_1
          //   2873: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2876: getfield 63	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PvJ	Lcom/tencent/mm/plugin/webview/d/h;
          //   2879: astore_1
          //   2880: aload_1
          //   2881: getfield 69	com/tencent/mm/plugin/webview/d/h:NoX	Z
          //   2884: ifne +17 -> 2901
          //   2887: ldc 71
          //   2889: ldc_w 640
          //   2892: invokestatic 79	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   2895: ldc 28
          //   2897: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2900: return
          //   2901: ldc_w 642
          //   2904: new 85	java/util/HashMap
          //   2907: dup
          //   2908: invokespecial 86	java/util/HashMap:<init>	()V
          //   2911: aload_1
          //   2912: getfield 104	com/tencent/mm/plugin/webview/d/h:PNx	Z
          //   2915: aload_1
          //   2916: getfield 107	com/tencent/mm/plugin/webview/d/h:EVx	Ljava/lang/String;
          //   2919: invokestatic 113	com/tencent/mm/plugin/webview/d/n$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   2922: astore 5
          //   2924: aload_1
          //   2925: getfield 117	com/tencent/mm/plugin/webview/d/h:PNp	Lcom/tencent/mm/ui/widget/MMWebView;
          //   2928: new 119	java/lang/StringBuilder
          //   2931: dup
          //   2932: ldc 121
          //   2934: invokespecial 124	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   2937: aload 5
          //   2939: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   2942: ldc 130
          //   2944: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   2947: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   2950: aconst_null
          //   2951: invokevirtual 140	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   2954: ldc 28
          //   2956: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2959: return
          //   2960: aload_0
          //   2961: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   2964: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2967: getfield 161	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PIx	Lcom/tencent/mm/plugin/webview/model/ba;
          //   2970: invokevirtual 167	com/tencent/mm/plugin/webview/model/ba:gWe	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   2973: iconst_3
          //   2974: anewarray 4	java/lang/Object
          //   2977: dup
          //   2978: iconst_0
          //   2979: aload_0
          //   2980: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   2983: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2986: invokevirtual 170	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cDu	()Ljava/lang/String;
          //   2989: aastore
          //   2990: dup
          //   2991: iconst_1
          //   2992: bipush 7
          //   2994: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2997: aastore
          //   2998: dup
          //   2999: iconst_2
          //   3000: iconst_1
          //   3001: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3004: aastore
          //   3005: invokevirtual 176	com/tencent/mm/plugin/webview/model/ba$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   3008: invokevirtual 179	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   3011: aload_0
          //   3012: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   3015: astore_1
          //   3016: aload_1
          //   3017: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3020: aload_1
          //   3021: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3024: getstatic 645	com/tencent/mm/plugin/webview/c$i:app_delete_tips	I
          //   3027: invokevirtual 439	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   3030: aconst_null
          //   3031: aconst_null
          //   3032: aload_1
          //   3033: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3036: getstatic 648	com/tencent/mm/plugin/webview/c$i:app_delete	I
          //   3039: invokevirtual 439	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   3042: new 650	com/tencent/mm/plugin/webview/ui/tools/k$13
          //   3045: dup
          //   3046: aload_1
          //   3047: invokespecial 652	com/tencent/mm/plugin/webview/ui/tools/k$13:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/k;)V
          //   3050: invokestatic 657	com/tencent/mm/ui/base/h:a	(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lcom/tencent/mm/ui/base/h$e;)Landroid/app/Dialog;
          //   3053: pop
          //   3054: ldc 28
          //   3056: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3059: return
          //   3060: aload_0
          //   3061: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   3064: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3067: getfield 161	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PIx	Lcom/tencent/mm/plugin/webview/model/ba;
          //   3070: invokevirtual 167	com/tencent/mm/plugin/webview/model/ba:gWe	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   3073: iconst_3
          //   3074: anewarray 4	java/lang/Object
          //   3077: dup
          //   3078: iconst_0
          //   3079: aload_0
          //   3080: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   3083: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3086: invokevirtual 170	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cDu	()Ljava/lang/String;
          //   3089: aastore
          //   3090: dup
          //   3091: iconst_1
          //   3092: bipush 11
          //   3094: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3097: aastore
          //   3098: dup
          //   3099: iconst_2
          //   3100: iconst_1
          //   3101: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3104: aastore
          //   3105: invokevirtual 176	com/tencent/mm/plugin/webview/model/ba$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   3108: invokevirtual 179	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   3111: aload_0
          //   3112: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   3115: aconst_null
          //   3116: invokevirtual 660	com/tencent/mm/plugin/webview/ui/tools/k:bmi	(Ljava/lang/String;)V
          //   3119: ldc 28
          //   3121: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3124: return
          //   3125: aload_0
          //   3126: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   3129: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3132: getfield 161	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PIx	Lcom/tencent/mm/plugin/webview/model/ba;
          //   3135: invokevirtual 167	com/tencent/mm/plugin/webview/model/ba:gWe	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   3138: iconst_3
          //   3139: anewarray 4	java/lang/Object
          //   3142: dup
          //   3143: iconst_0
          //   3144: aload_0
          //   3145: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   3148: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3151: invokevirtual 170	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cDu	()Ljava/lang/String;
          //   3154: aastore
          //   3155: dup
          //   3156: iconst_1
          //   3157: bipush 6
          //   3159: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3162: aastore
          //   3163: dup
          //   3164: iconst_2
          //   3165: iconst_1
          //   3166: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3169: aastore
          //   3170: invokevirtual 176	com/tencent/mm/plugin/webview/model/ba$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   3173: invokevirtual 179	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   3176: new 243	android/content/Intent
          //   3179: dup
          //   3180: invokespecial 255	android/content/Intent:<init>	()V
          //   3183: astore_1
          //   3184: aload_1
          //   3185: ldc_w 662
          //   3188: iconst_2
          //   3189: invokevirtual 665	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
          //   3192: pop
          //   3193: aload_1
          //   3194: ldc_w 667
          //   3197: aload_0
          //   3198: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   3201: invokevirtual 235	com/tencent/mm/plugin/webview/ui/tools/a:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3204: invokevirtual 239	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   3207: ldc_w 669
          //   3210: ldc2_w 670
          //   3213: invokevirtual 283	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
          //   3216: invokevirtual 674	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
          //   3219: pop
          //   3220: aload_0
          //   3221: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   3224: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3227: ldc_w 676
          //   3230: aload_1
          //   3231: invokestatic 680	com/tencent/mm/plugin/fav/a/b:b	(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V
          //   3234: aload_0
          //   3235: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   3238: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3241: getfield 161	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PIx	Lcom/tencent/mm/plugin/webview/model/ba;
          //   3244: ldc_w 682
          //   3247: invokevirtual 685	com/tencent/mm/plugin/webview/model/ba:bkW	(Ljava/lang/String;)V
          //   3250: ldc 28
          //   3252: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3255: return
          //   3256: aload_0
          //   3257: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   3260: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3263: getfield 161	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PIx	Lcom/tencent/mm/plugin/webview/model/ba;
          //   3266: invokevirtual 167	com/tencent/mm/plugin/webview/model/ba:gWe	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   3269: iconst_3
          //   3270: anewarray 4	java/lang/Object
          //   3273: dup
          //   3274: iconst_0
          //   3275: aload_0
          //   3276: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   3279: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3282: invokevirtual 170	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cDu	()Ljava/lang/String;
          //   3285: aastore
          //   3286: dup
          //   3287: iconst_1
          //   3288: bipush 19
          //   3290: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3293: aastore
          //   3294: dup
          //   3295: iconst_2
          //   3296: iconst_1
          //   3297: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3300: aastore
          //   3301: invokevirtual 176	com/tencent/mm/plugin/webview/model/ba$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   3304: invokevirtual 179	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   3307: aload_0
          //   3308: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   3311: aload_1
          //   3312: invokestatic 688	com/tencent/mm/plugin/webview/ui/tools/k:a	(Lcom/tencent/mm/plugin/webview/ui/tools/k;Landroid/view/MenuItem;)V
          //   3315: ldc 28
          //   3317: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3320: return
          //   3321: aload_0
          //   3322: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   3325: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3328: getfield 161	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PIx	Lcom/tencent/mm/plugin/webview/model/ba;
          //   3331: invokevirtual 167	com/tencent/mm/plugin/webview/model/ba:gWe	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   3334: iconst_3
          //   3335: anewarray 4	java/lang/Object
          //   3338: dup
          //   3339: iconst_0
          //   3340: aload_0
          //   3341: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   3344: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3347: invokevirtual 170	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cDu	()Ljava/lang/String;
          //   3350: aastore
          //   3351: dup
          //   3352: iconst_1
          //   3353: bipush 21
          //   3355: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3358: aastore
          //   3359: dup
          //   3360: iconst_2
          //   3361: iconst_1
          //   3362: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3365: aastore
          //   3366: invokevirtual 176	com/tencent/mm/plugin/webview/model/ba$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   3369: invokevirtual 179	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   3372: aload_0
          //   3373: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   3376: aload_1
          //   3377: invokestatic 688	com/tencent/mm/plugin/webview/ui/tools/k:a	(Lcom/tencent/mm/plugin/webview/ui/tools/k;Landroid/view/MenuItem;)V
          //   3380: ldc 28
          //   3382: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3385: return
          //   3386: aload_0
          //   3387: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   3390: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3393: getfield 161	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PIx	Lcom/tencent/mm/plugin/webview/model/ba;
          //   3396: invokevirtual 167	com/tencent/mm/plugin/webview/model/ba:gWe	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   3399: iconst_3
          //   3400: anewarray 4	java/lang/Object
          //   3403: dup
          //   3404: iconst_0
          //   3405: aload_0
          //   3406: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   3409: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3412: invokevirtual 170	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cDu	()Ljava/lang/String;
          //   3415: aastore
          //   3416: dup
          //   3417: iconst_1
          //   3418: bipush 20
          //   3420: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3423: aastore
          //   3424: dup
          //   3425: iconst_2
          //   3426: iconst_1
          //   3427: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3430: aastore
          //   3431: invokevirtual 176	com/tencent/mm/plugin/webview/model/ba$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   3434: invokevirtual 179	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   3437: aload_0
          //   3438: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   3441: aload_1
          //   3442: invokestatic 688	com/tencent/mm/plugin/webview/ui/tools/k:a	(Lcom/tencent/mm/plugin/webview/ui/tools/k;Landroid/view/MenuItem;)V
          //   3445: ldc 28
          //   3447: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3450: return
          //   3451: aload_0
          //   3452: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   3455: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3458: getfield 161	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PIx	Lcom/tencent/mm/plugin/webview/model/ba;
          //   3461: invokevirtual 167	com/tencent/mm/plugin/webview/model/ba:gWe	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   3464: iconst_3
          //   3465: anewarray 4	java/lang/Object
          //   3468: dup
          //   3469: iconst_0
          //   3470: aload_0
          //   3471: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   3474: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3477: invokevirtual 170	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cDu	()Ljava/lang/String;
          //   3480: aastore
          //   3481: dup
          //   3482: iconst_1
          //   3483: bipush 22
          //   3485: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3488: aastore
          //   3489: dup
          //   3490: iconst_2
          //   3491: iconst_1
          //   3492: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3495: aastore
          //   3496: invokevirtual 176	com/tencent/mm/plugin/webview/model/ba$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   3499: invokevirtual 179	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   3502: aload_0
          //   3503: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   3506: aload_1
          //   3507: invokestatic 688	com/tencent/mm/plugin/webview/ui/tools/k:a	(Lcom/tencent/mm/plugin/webview/ui/tools/k;Landroid/view/MenuItem;)V
          //   3510: ldc 28
          //   3512: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3515: return
          //   3516: aload_0
          //   3517: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   3520: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3523: getfield 161	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PIx	Lcom/tencent/mm/plugin/webview/model/ba;
          //   3526: invokevirtual 167	com/tencent/mm/plugin/webview/model/ba:gWe	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   3529: iconst_3
          //   3530: anewarray 4	java/lang/Object
          //   3533: dup
          //   3534: iconst_0
          //   3535: aload_0
          //   3536: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   3539: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3542: invokevirtual 170	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cDu	()Ljava/lang/String;
          //   3545: aastore
          //   3546: dup
          //   3547: iconst_1
          //   3548: bipush 23
          //   3550: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3553: aastore
          //   3554: dup
          //   3555: iconst_2
          //   3556: iconst_1
          //   3557: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3560: aastore
          //   3561: invokevirtual 176	com/tencent/mm/plugin/webview/model/ba$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   3564: invokevirtual 179	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   3567: aload_0
          //   3568: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   3571: aload_1
          //   3572: invokestatic 688	com/tencent/mm/plugin/webview/ui/tools/k:a	(Lcom/tencent/mm/plugin/webview/ui/tools/k;Landroid/view/MenuItem;)V
          //   3575: ldc 28
          //   3577: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3580: return
          //   3581: aload_0
          //   3582: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   3585: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3588: getfield 161	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PIx	Lcom/tencent/mm/plugin/webview/model/ba;
          //   3591: invokevirtual 167	com/tencent/mm/plugin/webview/model/ba:gWe	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   3594: iconst_3
          //   3595: anewarray 4	java/lang/Object
          //   3598: dup
          //   3599: iconst_0
          //   3600: aload_0
          //   3601: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   3604: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3607: invokevirtual 170	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cDu	()Ljava/lang/String;
          //   3610: aastore
          //   3611: dup
          //   3612: iconst_1
          //   3613: bipush 26
          //   3615: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3618: aastore
          //   3619: dup
          //   3620: iconst_2
          //   3621: iconst_1
          //   3622: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3625: aastore
          //   3626: invokevirtual 176	com/tencent/mm/plugin/webview/model/ba$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   3629: invokevirtual 179	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   3632: aload_0
          //   3633: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   3636: astore 5
          //   3638: aload_1
          //   3639: invokeinterface 148 1 0
          //   3644: istore_2
          //   3645: aload 5
          //   3647: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3650: getfield 63	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PvJ	Lcom/tencent/mm/plugin/webview/d/h;
          //   3653: ldc_w 690
          //   3656: iconst_1
          //   3657: invokevirtual 638	com/tencent/mm/plugin/webview/d/h:cZ	(Ljava/lang/String;Z)V
          //   3660: aload 5
          //   3662: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3665: getfield 63	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PvJ	Lcom/tencent/mm/plugin/webview/d/h;
          //   3668: astore 5
          //   3670: iload_2
          //   3671: bipush 43
          //   3673: if_icmpne +29 -> 3702
          //   3676: ldc_w 692
          //   3679: astore_1
          //   3680: aload 5
          //   3682: getfield 69	com/tencent/mm/plugin/webview/d/h:NoX	Z
          //   3685: ifne +24 -> 3709
          //   3688: ldc 71
          //   3690: ldc_w 694
          //   3693: invokestatic 79	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   3696: ldc 28
          //   3698: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3701: return
          //   3702: ldc_w 696
          //   3705: astore_1
          //   3706: goto -26 -> 3680
          //   3709: ldc_w 698
          //   3712: new 85	java/util/HashMap
          //   3715: dup
          //   3716: invokespecial 86	java/util/HashMap:<init>	()V
          //   3719: aload 5
          //   3721: getfield 104	com/tencent/mm/plugin/webview/d/h:PNx	Z
          //   3724: aload 5
          //   3726: getfield 107	com/tencent/mm/plugin/webview/d/h:EVx	Ljava/lang/String;
          //   3729: invokestatic 113	com/tencent/mm/plugin/webview/d/n$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   3732: astore 6
          //   3734: aload 5
          //   3736: getfield 117	com/tencent/mm/plugin/webview/d/h:PNp	Lcom/tencent/mm/ui/widget/MMWebView;
          //   3739: new 119	java/lang/StringBuilder
          //   3742: dup
          //   3743: ldc 121
          //   3745: invokespecial 124	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   3748: aload 6
          //   3750: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3753: ldc 130
          //   3755: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3758: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   3761: aconst_null
          //   3762: invokevirtual 140	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   3765: aload 5
          //   3767: getfield 699	com/tencent/mm/plugin/webview/d/h:pGC	Lcom/tencent/mm/plugin/webview/stub/e;
          //   3770: ldc_w 701
          //   3773: aload_1
          //   3774: aload 5
          //   3776: getfield 704	com/tencent/mm/plugin/webview/d/h:PNz	I
          //   3779: invokeinterface 708 4 0
          //   3784: ldc 28
          //   3786: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3789: return
          //   3790: astore_1
          //   3791: ldc 71
          //   3793: new 119	java/lang/StringBuilder
          //   3796: dup
          //   3797: ldc_w 710
          //   3800: invokespecial 124	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   3803: aload_1
          //   3804: invokevirtual 544	java/lang/Exception:getMessage	()Ljava/lang/String;
          //   3807: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3810: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   3813: invokestatic 713	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
          //   3816: ldc 28
          //   3818: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3821: return
          //   3822: aload_0
          //   3823: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   3826: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3829: getfield 161	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PIx	Lcom/tencent/mm/plugin/webview/model/ba;
          //   3832: invokevirtual 167	com/tencent/mm/plugin/webview/model/ba:gWe	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   3835: iconst_3
          //   3836: anewarray 4	java/lang/Object
          //   3839: dup
          //   3840: iconst_0
          //   3841: aload_0
          //   3842: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   3845: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3848: invokevirtual 170	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cDu	()Ljava/lang/String;
          //   3851: aastore
          //   3852: dup
          //   3853: iconst_1
          //   3854: bipush 27
          //   3856: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3859: aastore
          //   3860: dup
          //   3861: iconst_2
          //   3862: iconst_1
          //   3863: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3866: aastore
          //   3867: invokevirtual 176	com/tencent/mm/plugin/webview/model/ba$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   3870: invokevirtual 179	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   3873: aload_0
          //   3874: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   3877: astore 6
          //   3879: aload 6
          //   3881: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3884: getfield 205	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PIQ	Lcom/tencent/mm/plugin/webview/core/i;
          //   3887: invokevirtual 424	com/tencent/mm/plugin/webview/core/i:boj	()Ljava/lang/String;
          //   3890: astore 5
          //   3892: aload 5
          //   3894: astore_1
          //   3895: aload 5
          //   3897: invokestatic 193	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
          //   3900: ifeq +12 -> 3912
          //   3903: aload 6
          //   3905: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3908: invokevirtual 170	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cDu	()Ljava/lang/String;
          //   3911: astore_1
          //   3912: new 119	java/lang/StringBuilder
          //   3915: dup
          //   3916: ldc_w 715
          //   3919: invokespecial 124	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   3922: aload_1
          //   3923: ldc_w 717
          //   3926: invokestatic 722	com/tencent/mm/compatible/util/q:an	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
          //   3929: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3932: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   3935: astore 5
          //   3937: aload 5
          //   3939: astore_1
          //   3940: ldc 142
          //   3942: ldc_w 724
          //   3945: iconst_1
          //   3946: anewarray 4	java/lang/Object
          //   3949: dup
          //   3950: iconst_0
          //   3951: aload_1
          //   3952: aastore
          //   3953: invokestatic 157	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   3956: new 243	android/content/Intent
          //   3959: dup
          //   3960: ldc_w 492
          //   3963: aload_1
          //   3964: invokestatic 498	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
          //   3967: invokespecial 501	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
          //   3970: astore_1
          //   3971: aload_1
          //   3972: ldc_w 725
          //   3975: invokevirtual 729	android/content/Intent:addFlags	(I)Landroid/content/Intent;
          //   3978: pop
          //   3979: aload 6
          //   3981: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3984: aload_1
          //   3985: invokestatic 733	com/tencent/mm/sdk/platformtools/Util:isIntentAvailable	(Landroid/content/Context;Landroid/content/Intent;)Z
          //   3988: ifeq +116 -> 4104
          //   3991: aload 6
          //   3993: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3996: astore 5
          //   3998: new 550	com/tencent/mm/hellhoundlib/b/a
          //   4001: dup
          //   4002: invokespecial 551	com/tencent/mm/hellhoundlib/b/a:<init>	()V
          //   4005: aload_1
          //   4006: invokevirtual 555	com/tencent/mm/hellhoundlib/b/a:bm	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
          //   4009: astore_1
          //   4010: aload 5
          //   4012: aload_1
          //   4013: invokevirtual 559	com/tencent/mm/hellhoundlib/b/a:aFh	()[Ljava/lang/Object;
          //   4016: ldc_w 735
          //   4019: ldc_w 737
          //   4022: ldc_w 738
          //   4025: ldc_w 567
          //   4028: ldc_w 569
          //   4031: ldc_w 571
          //   4034: invokestatic 576	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
          //   4037: aload 5
          //   4039: aload_1
          //   4040: iconst_0
          //   4041: invokevirtual 580	com/tencent/mm/hellhoundlib/b/a:sf	(I)Ljava/lang/Object;
          //   4044: checkcast 243	android/content/Intent
          //   4047: invokevirtual 582	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:startActivity	(Landroid/content/Intent;)V
          //   4050: aload 5
          //   4052: ldc_w 735
          //   4055: ldc_w 737
          //   4058: ldc_w 738
          //   4061: ldc_w 567
          //   4064: ldc_w 569
          //   4067: ldc_w 571
          //   4070: invokestatic 586	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
          //   4073: ldc 28
          //   4075: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4078: return
          //   4079: astore 5
          //   4081: ldc 142
          //   4083: ldc_w 740
          //   4086: iconst_1
          //   4087: anewarray 4	java/lang/Object
          //   4090: dup
          //   4091: iconst_0
          //   4092: aload 5
          //   4094: invokevirtual 544	java/lang/Exception:getMessage	()Ljava/lang/String;
          //   4097: aastore
          //   4098: invokestatic 546	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   4101: goto -161 -> 3940
          //   4104: ldc 142
          //   4106: ldc_w 742
          //   4109: invokestatic 79	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   4112: ldc 28
          //   4114: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4117: return
          //   4118: aload_0
          //   4119: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   4122: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4125: getfield 161	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PIx	Lcom/tencent/mm/plugin/webview/model/ba;
          //   4128: invokevirtual 167	com/tencent/mm/plugin/webview/model/ba:gWe	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   4131: iconst_3
          //   4132: anewarray 4	java/lang/Object
          //   4135: dup
          //   4136: iconst_0
          //   4137: aload_0
          //   4138: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   4141: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4144: invokevirtual 170	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cDu	()Ljava/lang/String;
          //   4147: aastore
          //   4148: dup
          //   4149: iconst_1
          //   4150: bipush 17
          //   4152: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4155: aastore
          //   4156: dup
          //   4157: iconst_2
          //   4158: iconst_1
          //   4159: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4162: aastore
          //   4163: invokevirtual 176	com/tencent/mm/plugin/webview/model/ba$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   4166: invokevirtual 179	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   4169: aload_0
          //   4170: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   4173: astore_1
          //   4174: aload_1
          //   4175: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4178: getfield 63	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PvJ	Lcom/tencent/mm/plugin/webview/d/h;
          //   4181: ldc_w 744
          //   4184: iconst_1
          //   4185: invokevirtual 638	com/tencent/mm/plugin/webview/d/h:cZ	(Ljava/lang/String;Z)V
          //   4188: aload_1
          //   4189: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4192: getfield 63	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PvJ	Lcom/tencent/mm/plugin/webview/d/h;
          //   4195: astore_1
          //   4196: aload_1
          //   4197: getfield 69	com/tencent/mm/plugin/webview/d/h:NoX	Z
          //   4200: ifne +17 -> 4217
          //   4203: ldc 71
          //   4205: ldc_w 746
          //   4208: invokestatic 79	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   4211: ldc 28
          //   4213: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4216: return
          //   4217: aload_1
          //   4218: iconst_1
          //   4219: invokevirtual 750	com/tencent/mm/plugin/webview/d/h:anI	(I)Landroid/os/Bundle;
          //   4222: astore 5
          //   4224: aload 5
          //   4226: ifnull +30 -> 4256
          //   4229: aload 5
          //   4231: ldc_w 752
          //   4234: iconst_0
          //   4235: invokevirtual 756	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
          //   4238: ifeq +18 -> 4256
          //   4241: aload_1
          //   4242: aload 5
          //   4244: ldc_w 744
          //   4247: invokevirtual 759	com/tencent/mm/plugin/webview/d/h:i	(Landroid/os/Bundle;Ljava/lang/String;)V
          //   4250: ldc 28
          //   4252: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4255: return
          //   4256: ldc_w 761
          //   4259: new 85	java/util/HashMap
          //   4262: dup
          //   4263: invokespecial 86	java/util/HashMap:<init>	()V
          //   4266: aload_1
          //   4267: getfield 104	com/tencent/mm/plugin/webview/d/h:PNx	Z
          //   4270: aload_1
          //   4271: getfield 107	com/tencent/mm/plugin/webview/d/h:EVx	Ljava/lang/String;
          //   4274: invokestatic 113	com/tencent/mm/plugin/webview/d/n$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   4277: astore 5
          //   4279: aload_1
          //   4280: getfield 117	com/tencent/mm/plugin/webview/d/h:PNp	Lcom/tencent/mm/ui/widget/MMWebView;
          //   4283: new 119	java/lang/StringBuilder
          //   4286: dup
          //   4287: ldc 121
          //   4289: invokespecial 124	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   4292: aload 5
          //   4294: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   4297: ldc 130
          //   4299: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   4302: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   4305: aconst_null
          //   4306: invokevirtual 140	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   4309: ldc 28
          //   4311: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4314: return
          //   4315: aload_0
          //   4316: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   4319: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4322: getfield 161	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PIx	Lcom/tencent/mm/plugin/webview/model/ba;
          //   4325: invokevirtual 167	com/tencent/mm/plugin/webview/model/ba:gWe	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   4328: iconst_3
          //   4329: anewarray 4	java/lang/Object
          //   4332: dup
          //   4333: iconst_0
          //   4334: aload_0
          //   4335: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   4338: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4341: invokevirtual 170	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cDu	()Ljava/lang/String;
          //   4344: aastore
          //   4345: dup
          //   4346: iconst_1
          //   4347: bipush 18
          //   4349: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4352: aastore
          //   4353: dup
          //   4354: iconst_2
          //   4355: iconst_1
          //   4356: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4359: aastore
          //   4360: invokevirtual 176	com/tencent/mm/plugin/webview/model/ba$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   4363: invokevirtual 179	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   4366: aload_0
          //   4367: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   4370: astore_1
          //   4371: aload_1
          //   4372: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4375: getfield 63	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PvJ	Lcom/tencent/mm/plugin/webview/d/h;
          //   4378: ldc_w 763
          //   4381: iconst_1
          //   4382: invokevirtual 638	com/tencent/mm/plugin/webview/d/h:cZ	(Ljava/lang/String;Z)V
          //   4385: aload_1
          //   4386: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4389: getfield 63	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PvJ	Lcom/tencent/mm/plugin/webview/d/h;
          //   4392: astore_1
          //   4393: aload_1
          //   4394: getfield 69	com/tencent/mm/plugin/webview/d/h:NoX	Z
          //   4397: ifne +17 -> 4414
          //   4400: ldc 71
          //   4402: ldc_w 765
          //   4405: invokestatic 79	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   4408: ldc 28
          //   4410: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4413: return
          //   4414: ldc_w 767
          //   4417: new 85	java/util/HashMap
          //   4420: dup
          //   4421: invokespecial 86	java/util/HashMap:<init>	()V
          //   4424: aload_1
          //   4425: getfield 104	com/tencent/mm/plugin/webview/d/h:PNx	Z
          //   4428: aload_1
          //   4429: getfield 107	com/tencent/mm/plugin/webview/d/h:EVx	Ljava/lang/String;
          //   4432: invokestatic 113	com/tencent/mm/plugin/webview/d/n$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   4435: astore 5
          //   4437: aload_1
          //   4438: getfield 117	com/tencent/mm/plugin/webview/d/h:PNp	Lcom/tencent/mm/ui/widget/MMWebView;
          //   4441: new 119	java/lang/StringBuilder
          //   4444: dup
          //   4445: ldc 121
          //   4447: invokespecial 124	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   4450: aload 5
          //   4452: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   4455: ldc 130
          //   4457: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   4460: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   4463: aconst_null
          //   4464: invokevirtual 140	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   4467: ldc 28
          //   4469: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4472: return
          //   4473: aload_0
          //   4474: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   4477: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4480: getfield 161	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PIx	Lcom/tencent/mm/plugin/webview/model/ba;
          //   4483: invokevirtual 167	com/tencent/mm/plugin/webview/model/ba:gWe	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   4486: iconst_3
          //   4487: anewarray 4	java/lang/Object
          //   4490: dup
          //   4491: iconst_0
          //   4492: aload_0
          //   4493: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   4496: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4499: invokevirtual 170	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cDu	()Ljava/lang/String;
          //   4502: aastore
          //   4503: dup
          //   4504: iconst_1
          //   4505: bipush 24
          //   4507: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4510: aastore
          //   4511: dup
          //   4512: iconst_2
          //   4513: iconst_1
          //   4514: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4517: aastore
          //   4518: invokevirtual 176	com/tencent/mm/plugin/webview/model/ba$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   4521: invokevirtual 179	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   4524: aload_0
          //   4525: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   4528: astore_1
          //   4529: aload_1
          //   4530: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4533: getfield 63	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PvJ	Lcom/tencent/mm/plugin/webview/d/h;
          //   4536: ldc_w 769
          //   4539: iconst_1
          //   4540: invokevirtual 638	com/tencent/mm/plugin/webview/d/h:cZ	(Ljava/lang/String;Z)V
          //   4543: aload_1
          //   4544: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4547: getfield 63	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PvJ	Lcom/tencent/mm/plugin/webview/d/h;
          //   4550: astore_1
          //   4551: aload_1
          //   4552: getfield 69	com/tencent/mm/plugin/webview/d/h:NoX	Z
          //   4555: ifne +17 -> 4572
          //   4558: ldc 71
          //   4560: ldc_w 771
          //   4563: invokestatic 79	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   4566: ldc 28
          //   4568: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4571: return
          //   4572: aload_1
          //   4573: iconst_1
          //   4574: invokevirtual 750	com/tencent/mm/plugin/webview/d/h:anI	(I)Landroid/os/Bundle;
          //   4577: astore 5
          //   4579: aload 5
          //   4581: ifnull +30 -> 4611
          //   4584: aload 5
          //   4586: ldc_w 752
          //   4589: iconst_0
          //   4590: invokevirtual 756	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
          //   4593: ifeq +18 -> 4611
          //   4596: aload_1
          //   4597: aload 5
          //   4599: ldc_w 769
          //   4602: invokevirtual 759	com/tencent/mm/plugin/webview/d/h:i	(Landroid/os/Bundle;Ljava/lang/String;)V
          //   4605: ldc 28
          //   4607: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4610: return
          //   4611: ldc_w 773
          //   4614: new 85	java/util/HashMap
          //   4617: dup
          //   4618: invokespecial 86	java/util/HashMap:<init>	()V
          //   4621: aload_1
          //   4622: getfield 104	com/tencent/mm/plugin/webview/d/h:PNx	Z
          //   4625: aload_1
          //   4626: getfield 107	com/tencent/mm/plugin/webview/d/h:EVx	Ljava/lang/String;
          //   4629: invokestatic 113	com/tencent/mm/plugin/webview/d/n$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   4632: astore 5
          //   4634: aload_1
          //   4635: getfield 117	com/tencent/mm/plugin/webview/d/h:PNp	Lcom/tencent/mm/ui/widget/MMWebView;
          //   4638: new 119	java/lang/StringBuilder
          //   4641: dup
          //   4642: ldc 121
          //   4644: invokespecial 124	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   4647: aload 5
          //   4649: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   4652: ldc 130
          //   4654: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   4657: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   4660: aconst_null
          //   4661: invokevirtual 140	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   4664: ldc 28
          //   4666: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4669: return
          //   4670: aload_0
          //   4671: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   4674: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4677: getfield 161	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PIx	Lcom/tencent/mm/plugin/webview/model/ba;
          //   4680: invokevirtual 167	com/tencent/mm/plugin/webview/model/ba:gWe	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   4683: iconst_3
          //   4684: anewarray 4	java/lang/Object
          //   4687: dup
          //   4688: iconst_0
          //   4689: aload_0
          //   4690: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   4693: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4696: invokevirtual 170	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cDu	()Ljava/lang/String;
          //   4699: aastore
          //   4700: dup
          //   4701: iconst_1
          //   4702: bipush 14
          //   4704: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4707: aastore
          //   4708: dup
          //   4709: iconst_2
          //   4710: iconst_1
          //   4711: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4714: aastore
          //   4715: invokevirtual 176	com/tencent/mm/plugin/webview/model/ba$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   4718: invokevirtual 179	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   4721: aload_0
          //   4722: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   4725: astore_1
          //   4726: aload_1
          //   4727: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4730: getfield 63	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PvJ	Lcom/tencent/mm/plugin/webview/d/h;
          //   4733: ldc_w 690
          //   4736: iconst_1
          //   4737: invokevirtual 638	com/tencent/mm/plugin/webview/d/h:cZ	(Ljava/lang/String;Z)V
          //   4740: aload_1
          //   4741: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4744: getfield 63	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PvJ	Lcom/tencent/mm/plugin/webview/d/h;
          //   4747: astore_1
          //   4748: aload_1
          //   4749: getfield 69	com/tencent/mm/plugin/webview/d/h:NoX	Z
          //   4752: ifne +17 -> 4769
          //   4755: ldc 71
          //   4757: ldc_w 775
          //   4760: invokestatic 79	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   4763: ldc 28
          //   4765: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4768: return
          //   4769: ldc_w 698
          //   4772: new 85	java/util/HashMap
          //   4775: dup
          //   4776: invokespecial 86	java/util/HashMap:<init>	()V
          //   4779: aload_1
          //   4780: getfield 104	com/tencent/mm/plugin/webview/d/h:PNx	Z
          //   4783: aload_1
          //   4784: getfield 107	com/tencent/mm/plugin/webview/d/h:EVx	Ljava/lang/String;
          //   4787: invokestatic 113	com/tencent/mm/plugin/webview/d/n$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   4790: astore 5
          //   4792: aload_1
          //   4793: getfield 117	com/tencent/mm/plugin/webview/d/h:PNp	Lcom/tencent/mm/ui/widget/MMWebView;
          //   4796: new 119	java/lang/StringBuilder
          //   4799: dup
          //   4800: ldc 121
          //   4802: invokespecial 124	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   4805: aload 5
          //   4807: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   4810: ldc 130
          //   4812: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   4815: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   4818: aconst_null
          //   4819: invokevirtual 140	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   4822: aload_1
          //   4823: getfield 699	com/tencent/mm/plugin/webview/d/h:pGC	Lcom/tencent/mm/plugin/webview/stub/e;
          //   4826: ldc_w 701
          //   4829: ldc_w 777
          //   4832: aload_1
          //   4833: getfield 704	com/tencent/mm/plugin/webview/d/h:PNz	I
          //   4836: invokeinterface 708 4 0
          //   4841: ldc 28
          //   4843: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4846: return
          //   4847: astore_1
          //   4848: ldc 71
          //   4850: new 119	java/lang/StringBuilder
          //   4853: dup
          //   4854: ldc_w 710
          //   4857: invokespecial 124	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   4860: aload_1
          //   4861: invokevirtual 544	java/lang/Exception:getMessage	()Ljava/lang/String;
          //   4864: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   4867: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   4870: invokestatic 713	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
          //   4873: ldc 28
          //   4875: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4878: return
          //   4879: aload_0
          //   4880: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   4883: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4886: getfield 161	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PIx	Lcom/tencent/mm/plugin/webview/model/ba;
          //   4889: invokevirtual 167	com/tencent/mm/plugin/webview/model/ba:gWe	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   4892: iconst_3
          //   4893: anewarray 4	java/lang/Object
          //   4896: dup
          //   4897: iconst_0
          //   4898: aload_0
          //   4899: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   4902: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4905: invokevirtual 170	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cDu	()Ljava/lang/String;
          //   4908: aastore
          //   4909: dup
          //   4910: iconst_1
          //   4911: bipush 16
          //   4913: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4916: aastore
          //   4917: dup
          //   4918: iconst_2
          //   4919: iconst_1
          //   4920: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4923: aastore
          //   4924: invokevirtual 176	com/tencent/mm/plugin/webview/model/ba$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   4927: invokevirtual 179	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   4930: aload_0
          //   4931: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   4934: astore_1
          //   4935: new 195	android/os/Bundle
          //   4938: dup
          //   4939: invokespecial 196	android/os/Bundle:<init>	()V
          //   4942: astore 5
          //   4944: aload 5
          //   4946: ldc_w 779
          //   4949: ldc_w 781
          //   4952: invokevirtual 201	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
          //   4955: aload_1
          //   4956: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4959: getfield 205	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PIQ	Lcom/tencent/mm/plugin/webview/core/i;
          //   4962: getfield 211	com/tencent/mm/plugin/webview/core/i:pGC	Lcom/tencent/mm/plugin/webview/stub/e;
          //   4965: bipush 71
          //   4967: aload 5
          //   4969: invokeinterface 217 3 0
          //   4974: ldc_w 781
          //   4977: invokevirtual 785	android/os/Bundle:getStringArrayList	(Ljava/lang/String;)Ljava/util/ArrayList;
          //   4980: astore 5
          //   4982: aload 5
          //   4984: ifnull +13 -> 4997
          //   4987: aload 5
          //   4989: invokevirtual 790	java/util/ArrayList:size	()I
          //   4992: istore_2
          //   4993: iload_2
          //   4994: ifgt +9 -> 5003
          //   4997: ldc 28
          //   4999: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   5002: return
          //   5003: aload 5
          //   5005: invokevirtual 790	java/util/ArrayList:size	()I
          //   5008: iconst_1
          //   5009: if_icmpne +22 -> 5031
          //   5012: aload_1
          //   5013: aload 5
          //   5015: iconst_0
          //   5016: invokevirtual 792	java/util/ArrayList:get	(I)Ljava/lang/Object;
          //   5019: checkcast 356	java/lang/String
          //   5022: invokevirtual 226	com/tencent/mm/plugin/webview/ui/tools/k:bmh	(Ljava/lang/String;)V
          //   5025: ldc 28
          //   5027: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   5030: return
          //   5031: aload_1
          //   5032: aload 5
          //   5034: invokevirtual 796	com/tencent/mm/plugin/webview/ui/tools/k:ja	(Ljava/util/List;)V
          //   5037: new 798	com/tencent/mm/ui/tools/m
          //   5040: dup
          //   5041: aload_1
          //   5042: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5045: invokespecial 801	com/tencent/mm/ui/tools/m:<init>	(Landroid/content/Context;)V
          //   5048: astore 6
          //   5050: aload 6
          //   5052: aload_1
          //   5053: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5056: getfield 298	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:pHS	Lcom/tencent/mm/ui/widget/MMWebView;
          //   5059: aload_1
          //   5060: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5063: aconst_null
          //   5064: invokevirtual 804	com/tencent/mm/ui/tools/m:a	(Landroid/view/View;Landroid/view/View$OnCreateContextMenuListener;Lcom/tencent/mm/ui/base/q$g;)V
          //   5067: aload 6
          //   5069: new 806	com/tencent/mm/plugin/webview/ui/tools/k$6
          //   5072: dup
          //   5073: aload_1
          //   5074: invokespecial 807	com/tencent/mm/plugin/webview/ui/tools/k$6:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/k;)V
          //   5077: putfield 811	com/tencent/mm/ui/tools/m:ODW	Lcom/tencent/mm/ui/base/q$b;
          //   5080: aload 6
          //   5082: new 813	com/tencent/mm/plugin/webview/ui/tools/k$7
          //   5085: dup
          //   5086: aload_1
          //   5087: invokespecial 814	com/tencent/mm/plugin/webview/ui/tools/k$7:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/k;)V
          //   5090: putfield 818	com/tencent/mm/ui/tools/m:ODX	Lcom/tencent/mm/ui/base/q$c;
          //   5093: aload 6
          //   5095: aload_1
          //   5096: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5099: getfield 298	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:pHS	Lcom/tencent/mm/ui/widget/MMWebView;
          //   5102: new 820	com/tencent/mm/plugin/webview/ui/tools/k$8
          //   5105: dup
          //   5106: aload_1
          //   5107: aload 5
          //   5109: invokespecial 823	com/tencent/mm/plugin/webview/ui/tools/k$8:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/k;Ljava/util/ArrayList;)V
          //   5112: new 825	com/tencent/mm/plugin/webview/ui/tools/k$9
          //   5115: dup
          //   5116: aload_1
          //   5117: invokespecial 826	com/tencent/mm/plugin/webview/ui/tools/k$9:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/k;)V
          //   5120: invokevirtual 828	com/tencent/mm/ui/tools/m:b	(Landroid/view/View;Landroid/view/View$OnCreateContextMenuListener;Lcom/tencent/mm/ui/base/q$g;)V
          //   5123: ldc 28
          //   5125: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   5128: return
          //   5129: astore_1
          //   5130: ldc 142
          //   5132: new 119	java/lang/StringBuilder
          //   5135: dup
          //   5136: ldc_w 830
          //   5139: invokespecial 124	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   5142: aload_1
          //   5143: invokevirtual 544	java/lang/Exception:getMessage	()Ljava/lang/String;
          //   5146: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   5149: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   5152: invokestatic 713	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
          //   5155: ldc 28
          //   5157: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   5160: return
          //   5161: aload_0
          //   5162: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   5165: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5168: getfield 161	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PIx	Lcom/tencent/mm/plugin/webview/model/ba;
          //   5171: invokevirtual 167	com/tencent/mm/plugin/webview/model/ba:gWe	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   5174: iconst_3
          //   5175: anewarray 4	java/lang/Object
          //   5178: dup
          //   5179: iconst_0
          //   5180: aload_0
          //   5181: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   5184: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5187: invokevirtual 170	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cDu	()Ljava/lang/String;
          //   5190: aastore
          //   5191: dup
          //   5192: iconst_1
          //   5193: bipush 31
          //   5195: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   5198: aastore
          //   5199: dup
          //   5200: iconst_2
          //   5201: iconst_1
          //   5202: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   5205: aastore
          //   5206: invokevirtual 176	com/tencent/mm/plugin/webview/model/ba$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   5209: invokevirtual 179	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   5212: aload_0
          //   5213: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   5216: invokevirtual 833	com/tencent/mm/plugin/webview/ui/tools/k:cxg	()V
          //   5219: ldc 28
          //   5221: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   5224: return
          //   5225: getstatic 325	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
          //   5228: ldc2_w 834
          //   5231: lconst_1
          //   5232: lconst_1
          //   5233: iconst_0
          //   5234: invokevirtual 333	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
          //   5237: aload_0
          //   5238: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   5241: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5244: getfield 161	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PIx	Lcom/tencent/mm/plugin/webview/model/ba;
          //   5247: invokevirtual 167	com/tencent/mm/plugin/webview/model/ba:gWe	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   5250: iconst_3
          //   5251: anewarray 4	java/lang/Object
          //   5254: dup
          //   5255: iconst_0
          //   5256: aload_0
          //   5257: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   5260: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5263: invokevirtual 170	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cDu	()Ljava/lang/String;
          //   5266: aastore
          //   5267: dup
          //   5268: iconst_1
          //   5269: bipush 28
          //   5271: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   5274: aastore
          //   5275: dup
          //   5276: iconst_2
          //   5277: iconst_1
          //   5278: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   5281: aastore
          //   5282: invokevirtual 176	com/tencent/mm/plugin/webview/model/ba$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   5285: invokevirtual 179	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   5288: aload_0
          //   5289: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   5292: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5295: getfield 839	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Qfj	Lcom/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter;
          //   5298: invokevirtual 844	com/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter:isShown	()Z
          //   5301: ifne +794 -> 6095
          //   5304: aload_0
          //   5305: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   5308: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5311: getfield 839	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Qfj	Lcom/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter;
          //   5314: invokevirtual 847	com/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter:reset	()V
          //   5317: aload_0
          //   5318: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   5321: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5324: getfield 839	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Qfj	Lcom/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter;
          //   5327: invokevirtual 850	com/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter:hcd	()V
          //   5330: aload_0
          //   5331: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   5334: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5337: getfield 839	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Qfj	Lcom/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter;
          //   5340: invokevirtual 851	com/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter:show	()V
          //   5343: ldc 28
          //   5345: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   5348: return
          //   5349: aload_0
          //   5350: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   5353: astore_1
          //   5354: ldc 142
          //   5356: ldc_w 853
          //   5359: invokestatic 83	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   5362: aload_1
          //   5363: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5366: getfield 63	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PvJ	Lcom/tencent/mm/plugin/webview/d/h;
          //   5369: ifnull +72 -> 5441
          //   5372: aload_1
          //   5373: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5376: getfield 63	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PvJ	Lcom/tencent/mm/plugin/webview/d/h;
          //   5379: astore_1
          //   5380: aload_1
          //   5381: getfield 69	com/tencent/mm/plugin/webview/d/h:NoX	Z
          //   5384: ifne +17 -> 5401
          //   5387: ldc 71
          //   5389: ldc_w 855
          //   5392: invokestatic 79	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   5395: ldc 28
          //   5397: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   5400: return
          //   5401: ldc 71
          //   5403: ldc_w 857
          //   5406: invokestatic 83	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   5409: new 859	com/tencent/mm/plugin/webview/d/h$22
          //   5412: dup
          //   5413: aload_1
          //   5414: ldc_w 861
          //   5417: new 85	java/util/HashMap
          //   5420: dup
          //   5421: invokespecial 86	java/util/HashMap:<init>	()V
          //   5424: aload_1
          //   5425: getfield 104	com/tencent/mm/plugin/webview/d/h:PNx	Z
          //   5428: aload_1
          //   5429: getfield 107	com/tencent/mm/plugin/webview/d/h:EVx	Ljava/lang/String;
          //   5432: invokestatic 113	com/tencent/mm/plugin/webview/d/n$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   5435: invokespecial 864	com/tencent/mm/plugin/webview/d/h$22:<init>	(Lcom/tencent/mm/plugin/webview/d/h;Ljava/lang/String;)V
          //   5438: invokestatic 870	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
          //   5441: ldc 28
          //   5443: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   5446: return
          //   5447: aload_0
          //   5448: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   5451: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5454: getfield 161	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PIx	Lcom/tencent/mm/plugin/webview/model/ba;
          //   5457: invokevirtual 167	com/tencent/mm/plugin/webview/model/ba:gWe	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   5460: iconst_3
          //   5461: anewarray 4	java/lang/Object
          //   5464: dup
          //   5465: iconst_0
          //   5466: aload_0
          //   5467: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   5470: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5473: invokevirtual 170	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cDu	()Ljava/lang/String;
          //   5476: aastore
          //   5477: dup
          //   5478: iconst_1
          //   5479: bipush 33
          //   5481: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   5484: aastore
          //   5485: dup
          //   5486: iconst_2
          //   5487: iconst_1
          //   5488: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   5491: aastore
          //   5492: invokevirtual 176	com/tencent/mm/plugin/webview/model/ba$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   5495: invokevirtual 179	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   5498: aload_0
          //   5499: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   5502: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5505: getfield 409	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PHJ	Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/h;
          //   5508: iconst_0
          //   5509: invokevirtual 418	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/h:Dq	(Z)Z
          //   5512: pop
          //   5513: aload_0
          //   5514: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   5517: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5520: getfield 874	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Qgt	Lcom/tencent/mm/plugin/webview/ui/tools/multitask/a;
          //   5523: iconst_1
          //   5524: invokevirtual 880	com/tencent/mm/plugin/webview/ui/tools/multitask/a:iW	(Z)V
          //   5527: ldc 28
          //   5529: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   5532: return
          //   5533: aload_0
          //   5534: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   5537: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5540: getfield 161	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PIx	Lcom/tencent/mm/plugin/webview/model/ba;
          //   5543: invokevirtual 167	com/tencent/mm/plugin/webview/model/ba:gWe	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   5546: iconst_3
          //   5547: anewarray 4	java/lang/Object
          //   5550: dup
          //   5551: iconst_0
          //   5552: aload_0
          //   5553: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   5556: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5559: invokevirtual 170	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cDu	()Ljava/lang/String;
          //   5562: aastore
          //   5563: dup
          //   5564: iconst_1
          //   5565: bipush 34
          //   5567: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   5570: aastore
          //   5571: dup
          //   5572: iconst_2
          //   5573: iconst_1
          //   5574: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   5577: aastore
          //   5578: invokevirtual 176	com/tencent/mm/plugin/webview/model/ba$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   5581: invokevirtual 179	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   5584: ldc 28
          //   5586: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   5589: return
          //   5590: aload_0
          //   5591: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   5594: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5597: getfield 161	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PIx	Lcom/tencent/mm/plugin/webview/model/ba;
          //   5600: invokevirtual 167	com/tencent/mm/plugin/webview/model/ba:gWe	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   5603: iconst_3
          //   5604: anewarray 4	java/lang/Object
          //   5607: dup
          //   5608: iconst_0
          //   5609: aload_0
          //   5610: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   5613: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5616: invokevirtual 170	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cDu	()Ljava/lang/String;
          //   5619: aastore
          //   5620: dup
          //   5621: iconst_1
          //   5622: bipush 99
          //   5624: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   5627: aastore
          //   5628: dup
          //   5629: iconst_2
          //   5630: iconst_1
          //   5631: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   5634: aastore
          //   5635: invokevirtual 176	com/tencent/mm/plugin/webview/model/ba$d:C	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   5638: invokevirtual 179	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   5641: aload_0
          //   5642: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   5645: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5648: astore_1
          //   5649: aload_1
          //   5650: getfield 205	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PIQ	Lcom/tencent/mm/plugin/webview/core/i;
          //   5653: ifnull +24 -> 5677
          //   5656: invokestatic 885	com/tencent/mm/plugin/webview/d/l:gUi	()Z
          //   5659: ifne +24 -> 5683
          //   5662: iconst_1
          //   5663: istore 4
          //   5665: iload 4
          //   5667: invokestatic 888	com/tencent/mm/plugin/webview/d/l:CV	(Z)V
          //   5670: aload_1
          //   5671: getfield 205	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PIQ	Lcom/tencent/mm/plugin/webview/core/i;
          //   5674: invokevirtual 421	com/tencent/mm/plugin/webview/core/i:reload	()V
          //   5677: ldc 28
          //   5679: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   5682: return
          //   5683: iconst_0
          //   5684: istore 4
          //   5686: goto -21 -> 5665
          //   5689: aload_0
          //   5690: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   5693: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5696: getfield 63	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PvJ	Lcom/tencent/mm/plugin/webview/d/h;
          //   5699: ldc_w 861
          //   5702: aconst_null
          //   5703: new 890	org/json/JSONObject
          //   5706: dup
          //   5707: invokespecial 891	org/json/JSONObject:<init>	()V
          //   5710: invokevirtual 894	com/tencent/mm/plugin/webview/d/h:b	(Ljava/lang/String;Ljava/util/Map;Lorg/json/JSONObject;)V
          //   5713: ldc 28
          //   5715: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   5718: return
          //   5719: invokestatic 900	com/tencent/mm/ui/az:hXf	()Lcom/huawei/easygo/sdk/EasyGo;
          //   5722: ifnonnull +16 -> 5738
          //   5725: aload_0
          //   5726: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   5729: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5732: invokevirtual 904	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getContext	()Landroidx/appcompat/app/AppCompatActivity;
          //   5735: invokestatic 907	com/tencent/mm/ui/az:kK	(Landroid/content/Context;)V
          //   5738: invokestatic 900	com/tencent/mm/ui/az:hXf	()Lcom/huawei/easygo/sdk/EasyGo;
          //   5741: aload_0
          //   5742: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   5745: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5748: invokevirtual 910	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getTaskId	()I
          //   5751: invokestatic 913	com/tencent/mm/ui/az:a	(Lcom/huawei/easygo/sdk/EasyGo;I)I
          //   5754: iconst_2
          //   5755: if_icmpne +82 -> 5837
          //   5758: invokestatic 900	com/tencent/mm/ui/az:hXf	()Lcom/huawei/easygo/sdk/EasyGo;
          //   5761: aload_0
          //   5762: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   5765: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5768: invokevirtual 910	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getTaskId	()I
          //   5771: iconst_0
          //   5772: invokestatic 916	com/tencent/mm/ui/az:a	(Lcom/huawei/easygo/sdk/EasyGo;II)V
          //   5775: invokestatic 922	com/tencent/mm/ui/u:hHB	()Lcom/miui/easygo/sdk/EasyGo;
          //   5778: ifnonnull +16 -> 5794
          //   5781: aload_0
          //   5782: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   5785: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5788: invokevirtual 904	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getContext	()Landroidx/appcompat/app/AppCompatActivity;
          //   5791: invokestatic 923	com/tencent/mm/ui/u:kK	(Landroid/content/Context;)V
          //   5794: invokestatic 922	com/tencent/mm/ui/u:hHB	()Lcom/miui/easygo/sdk/EasyGo;
          //   5797: aload_0
          //   5798: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   5801: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5804: invokevirtual 910	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getTaskId	()I
          //   5807: invokestatic 926	com/tencent/mm/ui/u:a	(Lcom/miui/easygo/sdk/EasyGo;I)I
          //   5810: iconst_2
          //   5811: if_icmpne +46 -> 5857
          //   5814: invokestatic 922	com/tencent/mm/ui/u:hHB	()Lcom/miui/easygo/sdk/EasyGo;
          //   5817: aload_0
          //   5818: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   5821: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5824: invokevirtual 910	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getTaskId	()I
          //   5827: iconst_0
          //   5828: invokestatic 929	com/tencent/mm/ui/u:a	(Lcom/miui/easygo/sdk/EasyGo;II)V
          //   5831: ldc 28
          //   5833: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   5836: return
          //   5837: invokestatic 900	com/tencent/mm/ui/az:hXf	()Lcom/huawei/easygo/sdk/EasyGo;
          //   5840: aload_0
          //   5841: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   5844: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5847: invokevirtual 910	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getTaskId	()I
          //   5850: iconst_2
          //   5851: invokestatic 916	com/tencent/mm/ui/az:a	(Lcom/huawei/easygo/sdk/EasyGo;II)V
          //   5854: goto -79 -> 5775
          //   5857: invokestatic 922	com/tencent/mm/ui/u:hHB	()Lcom/miui/easygo/sdk/EasyGo;
          //   5860: aload_0
          //   5861: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   5864: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5867: invokevirtual 910	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getTaskId	()I
          //   5870: iconst_2
          //   5871: invokestatic 929	com/tencent/mm/ui/u:a	(Lcom/miui/easygo/sdk/EasyGo;II)V
          //   5874: ldc 28
          //   5876: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   5879: return
          //   5880: iconst_0
          //   5881: istore_2
          //   5882: goto -5136 -> 746
          //   5885: iconst_0
          //   5886: istore_2
          //   5887: goto -5127 -> 760
          //   5890: astore_1
          //   5891: iconst_0
          //   5892: istore_2
          //   5893: ldc 142
          //   5895: aload_1
          //   5896: ldc_w 597
          //   5899: iconst_0
          //   5900: anewarray 4	java/lang/Object
          //   5903: invokestatic 933	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
          //   5906: goto -5146 -> 760
          //   5909: aload_0
          //   5910: getfield 19	com/tencent/mm/plugin/webview/ui/tools/k$19:QdM	Lcom/tencent/mm/plugin/webview/ui/tools/k;
          //   5913: astore_1
          //   5914: aload_1
          //   5915: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5918: getfield 63	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PvJ	Lcom/tencent/mm/plugin/webview/d/h;
          //   5921: ldc_w 690
          //   5924: iconst_0
          //   5925: invokevirtual 638	com/tencent/mm/plugin/webview/d/h:cZ	(Ljava/lang/String;Z)V
          //   5928: aload_1
          //   5929: invokevirtual 57	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5932: getfield 63	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:PvJ	Lcom/tencent/mm/plugin/webview/d/h;
          //   5935: astore_1
          //   5936: aload_1
          //   5937: getfield 69	com/tencent/mm/plugin/webview/d/h:NoX	Z
          //   5940: ifne +17 -> 5957
          //   5943: ldc 71
          //   5945: ldc_w 935
          //   5948: invokestatic 79	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   5951: ldc 28
          //   5953: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   5956: return
          //   5957: new 85	java/util/HashMap
          //   5960: dup
          //   5961: invokespecial 86	java/util/HashMap:<init>	()V
          //   5964: astore 6
          //   5966: aload 6
          //   5968: ldc_w 701
          //   5971: ldc_w 937
          //   5974: invokevirtual 95	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
          //   5977: pop
          //   5978: ldc_w 698
          //   5981: aload 6
          //   5983: aload_1
          //   5984: getfield 104	com/tencent/mm/plugin/webview/d/h:PNx	Z
          //   5987: aload_1
          //   5988: getfield 107	com/tencent/mm/plugin/webview/d/h:EVx	Ljava/lang/String;
          //   5991: invokestatic 113	com/tencent/mm/plugin/webview/d/n$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   5994: astore 6
          //   5996: aload_1
          //   5997: getfield 117	com/tencent/mm/plugin/webview/d/h:PNp	Lcom/tencent/mm/ui/widget/MMWebView;
          //   6000: new 119	java/lang/StringBuilder
          //   6003: dup
          //   6004: ldc 121
          //   6006: invokespecial 124	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   6009: aload 6
          //   6011: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   6014: ldc 130
          //   6016: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   6019: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   6022: aconst_null
          //   6023: invokevirtual 140	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   6026: aload_1
          //   6027: getfield 699	com/tencent/mm/plugin/webview/d/h:pGC	Lcom/tencent/mm/plugin/webview/stub/e;
          //   6030: ldc_w 939
          //   6033: aload 5
          //   6035: aload_1
          //   6036: getfield 704	com/tencent/mm/plugin/webview/d/h:PNz	I
          //   6039: invokeinterface 708 4 0
          //   6044: aload_1
          //   6045: getfield 699	com/tencent/mm/plugin/webview/d/h:pGC	Lcom/tencent/mm/plugin/webview/stub/e;
          //   6048: ldc_w 701
          //   6051: ldc_w 937
          //   6054: aload_1
          //   6055: getfield 704	com/tencent/mm/plugin/webview/d/h:PNz	I
          //   6058: invokeinterface 708 4 0
          //   6063: ldc 28
          //   6065: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   6068: return
          //   6069: astore_1
          //   6070: ldc 71
          //   6072: new 119	java/lang/StringBuilder
          //   6075: dup
          //   6076: ldc_w 710
          //   6079: invokespecial 124	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   6082: aload_1
          //   6083: invokevirtual 544	java/lang/Exception:getMessage	()Ljava/lang/String;
          //   6086: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   6089: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   6092: invokestatic 713	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
          //   6095: ldc 28
          //   6097: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   6100: return
          //   6101: astore_1
          //   6102: goto -209 -> 5893
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	6105	0	this	19
          //   0	6105	1	paramAnonymousMenuItem	MenuItem
          //   0	6105	2	paramAnonymousInt	int
          //   752	4	3	i	int
          //   5663	22	4	bool	boolean
          //   37	4014	5	localObject1	Object
          //   4079	14	5	localException	Exception
          //   4222	1812	5	localObject2	Object
          //   89	5921	6	localObject3	Object
          //   2100	652	7	localObject4	Object
          //   2107	571	8	locale	com.tencent.mm.plugin.webview.stub.e
          // Exception table:
          //   from	to	target	type
          //   2232	2246	2320	java/lang/Exception
          //   2246	2319	2320	java/lang/Exception
          //   2371	2451	2320	java/lang/Exception
          //   2452	2467	2320	java/lang/Exception
          //   2168	2178	2347	java/lang/Exception
          //   2677	2687	2765	java/lang/Exception
          //   3765	3784	3790	java/lang/Exception
          //   3912	3937	4079	java/lang/Exception
          //   4822	4841	4847	java/lang/Exception
          //   4935	4982	5129	java/lang/Exception
          //   4987	4993	5129	java/lang/Exception
          //   5003	5025	5129	java/lang/Exception
          //   5031	5123	5129	java/lang/Exception
          //   690	728	5890	java/lang/Exception
          //   732	739	5890	java/lang/Exception
          //   6026	6063	6069	java/lang/Exception
          //   746	753	6101	java/lang/Exception
        }
      };
      this.qXn.ODU = ((q.g)localObject2);
      this.qXn.Ymw = new e.c()
      {
        public final void onShow()
        {
          AppMethodBeat.i(258155);
          k.c localc = (k.c)k.this.Qdy.get(Integer.valueOf(45));
          if (localc == null)
          {
            AppMethodBeat.o(258155);
            return;
          }
          k.this.Qdy.remove(Integer.valueOf(45));
          int i;
          if ((k.this.qXn != null) && (k.this.qXn.isShowing()) && (k.this.QdE != null))
          {
            i = k.this.QdE.hJP();
            localObject = k.this.qXn;
            if ((((com.tencent.mm.ui.widget.a.e)localObject).mRecyclerView != null) && (((com.tencent.mm.ui.widget.a.e)localObject).mRecyclerView.getLayoutManager() != null) && (((com.tencent.mm.ui.widget.a.e)localObject).Yne != null))
            {
              ((com.tencent.mm.ui.widget.a.e)localObject).Yne.alG = i;
              ((com.tencent.mm.ui.widget.a.e)localObject).mRecyclerView.getLayoutManager().startSmoothScroll(((com.tencent.mm.ui.widget.a.e)localObject).Yne);
            }
          }
          Object localObject = k.this;
          if (localc != null)
          {
            i = localc.qgq;
            Bundle localBundle = localc.QdY;
            if ((localBundle != null) && (i == 45))
            {
              ResolveInfo localResolveInfo = (ResolveInfo)localBundle.getParcelable("show_browser_resolve_info");
              boolean bool = localBundle.getBoolean("show_browser_with_animation", false);
              if (localResolveInfo != null)
              {
                ((k)localObject).Qdx.Qjf = null;
                ((k)localObject).Qdx.pN = localResolveInfo;
                ((k)localObject).a(((k)localObject).gXq(), ((k)localObject).Qdx.pN, ((k)localObject).QdE, localc.qfB, bool);
              }
            }
          }
          AppMethodBeat.o(258155);
        }
      };
      this.qXn.XbB = new com.tencent.mm.ui.widget.a.e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(226321);
          if ((k.this.gXq().gYM()) && (k.this.gXq().PvJ != null)) {
            k.this.gXq().PvJ.onWindowFocusChanged(true);
          }
          AppMethodBeat.o(226321);
        }
      };
      if (gXq().pGD != null) {
        break label253;
      }
      Log.e("MicroMsg.WebViewMenuHelper", "get permission failed");
      AppMethodBeat.o(226449);
      return;
      bool = false;
      break;
      this.qXn = new com.tencent.mm.ui.widget.a.e(gXq(), 0, true);
      break label103;
    }
    label253:
    Object localObject3 = gXq().PIQ.pGD.gWI();
    this.qXn.ODT = new q.f()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymouso)
      {
        AppMethodBeat.i(225083);
        if (k.this.elX())
        {
          AppMethodBeat.o(225083);
          return;
        }
        k.this.QdE = paramAnonymouso;
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(480L, 0L, 1L, false);
        paramAnonymouso.clear();
        if (k.this.QdG.booleanValue())
        {
          j = k.this.QdF.size();
          i = 0;
          while (i < j)
          {
            localObject1 = (com.tencent.mm.n.e.b)k.this.QdF.get(i);
            localObject2 = (com.tencent.mm.ui.base.p)paramAnonymouso.d(((com.tencent.mm.n.e.b)localObject1).id, ((com.tencent.mm.n.e.b)localObject1).title);
            ((com.tencent.mm.ui.base.p)localObject2).WkU = ((ContextMenu.ContextMenuInfo)localObject1);
            ((com.tencent.mm.ui.base.p)localObject2).setIcon(null);
            ((com.tencent.mm.ui.base.p)localObject2).setIcon(0);
            i += 1;
          }
          AppMethodBeat.o(225083);
          return;
        }
        if ((k.this.aoy(1)) && (k.a(this.QdR, 21)) && (k.this.aox(1))) {
          paramAnonymouso.a(1, k.this.gXq().getString(c.i.readerapp_alert_retransmit), c.h.icons_filled_share, k.this.gXq().getResources().getColor(c.c.Brand), k.b(this.QdR, 21));
        }
        if ((k.this.aoy(2)) && (k.a(this.QdR, 23)) && (k.this.aox(2))) {
          paramAnonymouso.a(2, k.this.gXq().getString(c.i.readerapp_alert_share_to_timeline), c.h.bottomsheet_icon_moment, 0, k.b(this.QdR, 23));
        }
        int j = -1;
        m = -1;
        int i = j;
        try
        {
          localObject1 = new Bundle();
          i = j;
          ((Bundle)localObject1).putInt("WebViewShare_BinderID", k.this.gXq().PIQ.gSo());
          i = j;
          ((Bundle)localObject1).putString("WebViewShare_wv_url", k.this.gXq().PIQ.pHS.getUrl());
          i = j;
          localObject1 = k.this.gXq().PIQ.pGC.l(109, (Bundle)localObject1);
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
            if (!k.this.gXq().PIQ.pGC.l(78, null).getBoolean("isOpenForFaceBook", false)) {
              break label1134;
            }
            paramAnonymouso.a(33, k.this.gXq().getString(c.i.wv_share_to_facebook), c.h.default_facebookapp, 0, k.b(this.QdR, 31));
            if ((!k.this.aoy(26)) || (!k.a(this.QdR, 278)) || (!com.tencent.mm.plugin.webview.stub.a.ch(k.this.gXq(), k.this.gXq().pHS.getUrl())) || (!k.this.aox(26))) {
              break label1231;
            }
            paramAnonymouso.a(26, k.this.gXq().getString(c.i.wv_send_to_we_read), c.h.bottomsheet_icon_weread, 0, k.b(this.QdR, 278));
            if ((!k.this.aoy(7)) || (!k.a(this.QdR, 45)) || (!k.this.aox(7))) {
              break label1434;
            }
            bool = k.b(this.QdR, 45);
            paramAnonymouso.a(7, k.this.gXq().getString(c.i.wv_alert_open_in_browser), c.h.bottomsheet_icon_brower, k.this.gXq().getResources().getColor(c.c.Indigo), bool);
            if (k.this.Qdy.containsKey(Integer.valueOf(45))) {
              break label2445;
            }
            k.this.Qdx.pN = k.a(k.this.gXq(), k.this.gXq().pGC);
            Log.i("MicroMsg.WebViewMenuHelper", "alvinluo showReaderModeMenu defaultBrowser: %s", new Object[] { k.this.Qdx.pN });
            if (k.this.Qdx.pN == null) {
              break label1434;
            }
            k.this.a(k.this.gXq(), k.this.Qdx.pN, paramAnonymouso, bool, false);
            localObject1 = k.this.gXq().getIntent().getStringExtra("sns_local_id");
            l = k.this.gXq().getIntent().getLongExtra("msg_id", -9223372036854775808L);
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
                  if ((k.this.aoy(23)) && (k.this.gXq().PIQ.pGC.V(l, (String)localObject1))) {
                    paramAnonymouso.b(23, k.this.gXq().getString(c.i.download_other_open), c.h.bottomsheet_icon_other_mode);
                  }
                  if ((k.this.aoy(24)) && (k.a(this.QdR, 43)) && (k.this.aox(24)) && (!com.tencent.mm.pluginsdk.model.app.q.u(k.this.gXq(), "com.tencent.wework"))) {}
                  try
                  {
                    localObject1 = new Bundle();
                    ((Bundle)localObject1).putString("enterprise_action", "enterprise_has_connector");
                    localObject1 = k.this.gXq().PIQ.pGC.l(71, (Bundle)localObject1);
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
                      k.a(k.this, localException5);
                    }
                  }
                  if (bool) {
                    paramAnonymouso.a(24, k.this.gXq().getString(c.i.readerapp_send_to_enterprise), c.h.bottomsheet_icon_enterprise, k.b(this.QdR, 43));
                  }
                  if ((k.this.aoy(8)) && (k.a(this.QdR, 36)) && (k.this.aox(8))) {
                    localObject1 = null;
                  }
                  try
                  {
                    localObject2 = k.this.gXq().PIQ.pGC.gXa();
                    localObject1 = localObject2;
                  }
                  catch (Exception localException6)
                  {
                    String str;
                    k.c localc;
                    break label1744;
                  }
                  if (Util.isNullOrNil((String)localObject1)) {
                    break label2544;
                  }
                  paramAnonymouso.a(8, k.this.gXq().getString(c.i.wv_alert_send_mail), c.h.icons_filled_email, k.this.gXq().getResources().getColor(c.c.Indigo), k.b(this.QdR, 36));
                  if ((k.this.aoy(20)) && (k.a(this.QdR, 91)) && (com.tencent.mm.plugin.webview.stub.a.jb(k.this.gXq())) && (k.this.aox(20))) {
                    paramAnonymouso.a(20, k.this.gXq().getString(c.i.wv_share_to_qq), c.h.bottomsheet_icon_qq, 0, k.b(this.QdR, 91));
                  }
                  if ((k.this.aoy(22)) && (k.a(this.QdR, 133)) && (com.tencent.mm.plugin.webview.stub.a.jb(k.this.gXq())) && (k.this.aox(22))) {
                    paramAnonymouso.a(22, k.this.gXq().getString(c.i.wv_share_to_qzone), c.h.bottomsheet_icon_qzone, 0, k.b(this.QdR, 133));
                  }
                  try
                  {
                    if ((k.this.aoy(0)) && (k.a(this.QdR, 43)) && (k.this.aox(0)) && (k.this.gXq().PIQ.pGC.bjd()))
                    {
                      localObject1 = k.this.gXq().PIQ.pGC.bjc();
                      localObject2 = ((List)localObject1).iterator();
                      while (((Iterator)localObject2).hasNext()) {
                        paramAnonymouso.add((String)((Iterator)localObject2).next());
                      }
                    }
                    if (!k.this.aoy(27)) {
                      break label2171;
                    }
                  }
                  catch (Exception localException1)
                  {
                    Log.w("MicroMsg.WebViewMenuHelper", "builder add, ex = " + localException1.getMessage());
                  }
                  if ((k.this.gXq().Qfd != null) && (k.this.gXq().Qfd.getVisibility() == 0)) {
                    paramAnonymouso.b(27, k.this.gXq().getString(c.i.readerapp_finish_webview), c.h.bottomsheet_icon_exit);
                  }
                  str = k.this.gXq().bju(k.this.gXq().PIQ.PFK);
                  localObject2 = k.this.gXq().getIntent().getStringExtra("shortcut_user_name");
                  if ((!k.this.gXq().Qfx) && (!Util.isNullOrNil(str)) && (!Util.isNullOrNil((String)localObject2)) && (k.a(this.QdR, 255)) && (k.this.aox(29)) && (k.this.aoy(29))) {
                    paramAnonymouso.a(29, k.this.gXq().getString(c.i.readerapp_add_shortcut), c.h.webview_add_shortcut, k.b(this.QdR, 255));
                  }
                  k.this.qXn.gIa();
                  AppMethodBeat.o(225083);
                  return;
                  localException2 = localException2;
                  Log.e("MicroMsg.WebViewMenuHelper", "isSetHaoKan, e = " + localException2.getMessage());
                  int k = m;
                  continue;
                  if ((k.this.aox(39)) && (k == 1))
                  {
                    paramAnonymouso.a(39, k.this.gXq().getString(c.i.readerapp_cancel_haokan), c.h.bottomsheet_icon_cancel_hao_kan, k.this.gXq().getResources().getColor(c.c.Yellow));
                    continue;
                    localException3 = localException3;
                    Log.printErrStackTrace("MicroMsg.WebViewMenuHelper", localException3, "", new Object[0]);
                  }
                }
                localc = (k.c)k.this.Qdy.get(Integer.valueOf(45));
              } while (localc == null);
              localc.qfB = bool;
              localc.QdX = paramAnonymouso.size();
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
          if ((k.this.aoy(38)) && (k.this.aox(38)) && (k == 0)) {
            paramAnonymouso.a(38, k.this.gXq().getString(c.i.readerapp_haokan), c.h.bottomsheet_icon_hao_kan, k.this.gXq().getResources().getColor(c.c.Yellow));
          }
        }
        else
        {
          if ((k.this.aoy(3)) && ((!k.this.gXq().Qfu) || ((!Util.isNullOrNil(k.this.gXq().PIQ.PFK)) && (!Util.isNullOrNil(k.this.gXq().QgO)) && (!k.this.gXq().PIQ.PFK.startsWith(k.this.gXq().QgO)))) && (k.a(this.QdR, 323)) && (k.this.gYa()) && (k.this.aox(3))) {
            paramAnonymouso.a(3, k.this.gXq().getString(c.i.plugin_favorite_opt), c.h.bottomsheet_icon_fav, 0, k.b(this.QdR, 323));
          }
          localObject1 = k.this.gXq().elY();
          bool = ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).apb((String)localObject1);
          if ((((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).eBJ()) && (bool) && (k.this.gXq().gUC()) && (k.this.gXq().gYn() != null) && (k.a(this.QdR, 44))) {
            paramAnonymouso.a(46, k.this.gXq().getString(c.i.webview_open_in_computer), c.h.icons_outlined_colorful_handoff, 0, k.b(this.QdR, 44));
          }
          if ((k.this.aoy(25)) && (k.a(this.QdR, 322)) && (WWAPIFactory.mw(k.this.gXq()).a(IWWAPI.WWAppType.ZYc)) && (k.this.aox(25)))
          {
            localObject1 = WWAPIFactory.mw(k.this.gXq()).b(IWWAPI.WWAppType.ZYc);
            if (!WeChatBrands.AppInfo.current().isMainland()) {
              localObject1 = k.this.gXq().getString(c.i.wecom_name);
            }
            paramAnonymouso.a(25, k.this.gXq().getString(c.i.readerapp_send_to_wework, new Object[] { localObject1 }), c.h.bottomsheet_icon_wework, 0, k.b(this.QdR, 322));
          }
          if ((k.this.aoy(43)) && (k.a(this.QdR, 322)) && (WWAPIFactory.mw(k.this.gXq()).a(IWWAPI.WWAppType.ZYd)) && (k.this.aox(43)))
          {
            localObject1 = WWAPIFactory.mw(k.this.gXq()).b(IWWAPI.WWAppType.ZYd);
            paramAnonymouso.a(43, k.this.gXq().getString(c.i.readerapp_send_to_wework, new Object[] { localObject1 }), c.h.bottomsheet_icon_wework_local, 0, k.b(this.QdR, 322));
          }
          if ((!k.this.aoy(33)) || (!k.a(this.QdR, 31)) || (!k.this.aox(33))) {}
        }
      }
    };
    Object localObject4 = gXq().elY();
    gXq();
    Object localObject1 = p.bmu((String)localObject4);
    int i;
    if ((com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class) != null) && (((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).isMpUrl((String)localObject4))) {
      i = 1;
    }
    for (;;)
    {
      this.qXn.Ymx = new q.f()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymouso)
        {
          AppMethodBeat.i(251175);
          if (k.this.elX())
          {
            AppMethodBeat.o(251175);
            return;
          }
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(480L, 0L, 1L, false);
          paramAnonymouso.clear();
          if (k.this.QdG.booleanValue())
          {
            AppMethodBeat.o(251175);
            return;
          }
          if ((ar.hIO()) && (ar.hIH()))
          {
            az.kK(k.this.gXq().getContext());
            if ((az.a(az.hXf(), k.this.gXq().getTaskId()) != 2) && (u.a(u.hHB(), k.this.gXq().getTaskId()) != 2)) {
              break label369;
            }
            paramAnonymouso.b(44, k.this.gXq().getString(c.i.close_split_screen), c.h.icons_outlined_merge);
          }
          for (;;)
          {
            if ((k.this.gXq().Qgt != null) && (k.this.gXq().Qgt.cbH()) && (k.this.aoy(35)) && (k.this.aox(35))) {
              paramAnonymouso.b(35, k.this.gXq().getString(c.i.readerapp_minimize), c.h.icons_outlined_multitask);
            }
            switch (k.this.gXq().QgA)
            {
            }
            try
            {
              label256:
              LinkedList localLinkedList = k.this.gXq().gYU();
              int i;
              if (localLinkedList != null)
              {
                i = 0;
                label275:
                if ((i < localLinkedList.size()) && (i < 8))
                {
                  com.tencent.mm.n.e.a locala = (com.tencent.mm.n.e.a)localLinkedList.get(i);
                  com.tencent.mm.ui.base.p localp = null;
                  if ("index".equals(Util.nullAsNil(locala.id))) {
                    localp = (com.tencent.mm.ui.base.p)paramAnonymouso.b(15, k.this.gXq().getString(c.i.webview_jd_menu_title_index), c.h.bottomsheet_icon_jd_index);
                  }
                  for (;;)
                  {
                    if (localp != null) {
                      localp.ozt = locala.url;
                    }
                    i += 1;
                    break label275;
                    label369:
                    paramAnonymouso.b(44, k.this.gXq().getString(c.i.split_screen), c.h.icons_outlined_sperated);
                    break;
                    paramAnonymouso.b(40, k.this.gXq().getString(c.i.webview_tts_start), c.h.icon_outlined_talk);
                    break label256;
                    paramAnonymouso.b(41, k.this.gXq().getString(c.i.webview_tts_pause), c.h.icon_outlined_stoptalking);
                    break label256;
                    paramAnonymouso.b(42, k.this.gXq().getString(c.i.webview_tts_resume), c.h.icon_outlined_talk);
                    break label256;
                    if ("categories".equals(Util.nullAsNil(locala.id))) {
                      localp = (com.tencent.mm.ui.base.p)paramAnonymouso.b(16, k.this.gXq().getString(c.i.webview_jd_menu_title_categories), c.h.bottomsheet_icon_jd_collect_list);
                    } else if ("cart".equals(Util.nullAsNil(locala.id))) {
                      localp = (com.tencent.mm.ui.base.p)paramAnonymouso.b(17, k.this.gXq().getString(c.i.webview_jd_menu_title_cart), c.h.bottomsheet_icon_jd_cart);
                    } else if ("profile".equals(Util.nullAsNil(locala.id))) {
                      localp = (com.tencent.mm.ui.base.p)paramAnonymouso.b(18, k.this.gXq().getString(c.i.webview_jd_menu_title_profile), c.h.bottomsheet_icon_profile);
                    } else if ("member".equals(Util.nullAsNil(locala.id))) {
                      localp = (com.tencent.mm.ui.base.p)paramAnonymouso.b(19, k.this.gXq().getString(c.i.webview_jd_menu_title_member), c.h.bottomsheet_icon_jd_member);
                    }
                  }
                }
              }
              try
              {
                bool1 = k.this.gXq().PIQ.pGC.Qm((String)localObject);
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
                    k.this.gXq().PIQ.pGC.blR((String)localObject);
                    if (k.this.aox(10)) {
                      paramAnonymouso.b(10, k.this.gXq().getString(c.i.biz_report_text), c.h.icons_outlined_report_problem);
                    }
                    if ((k.this.aoy(6)) && (k.a(this.QdR, 44)) && (k.this.aox(6))) {
                      paramAnonymouso.a(6, k.this.gXq().getString(c.i.wv_alert_copy_link), c.h.icons_outlined_link, k.b(this.QdR, 44));
                    }
                    if ((k.this.aoy(28)) && (k.this.aox(28))) {
                      paramAnonymouso.b(28, k.this.gXq().getString(c.i.webview_bottomsheet_refresh), c.h.icons_outlined_refresh);
                    }
                    if (((paramLong & 1L) == 0L) && (k.this.aoy(31))) {
                      paramAnonymouso.b(31, k.this.gXq().getString(c.i.wv_search_content), c.h.actionbar_icon_dark_search);
                    }
                    if ((this.QdR.RBg != null) && (k.this.gXq().Qfu) && (!Util.isNullOrNil(k.this.gXq().PIQ.PFK)) && (!Util.isNullOrNil(k.this.gXq().QgO)) && (k.this.gXq().PIQ.PFK.startsWith(k.this.gXq().QgO)) && (k.this.gXq().getIntent().getBooleanExtra("key_detail_can_delete", true)) && (k.this.gYa()))
                    {
                      if ((k.this.aoy(12)) && (k.this.aox(12))) {
                        paramAnonymouso.b(12, k.this.gXq().getString(c.i.favorite_add_tag_tips), c.h.bottomsheet_icon_addtag);
                      }
                      if (k.this.aoy(9)) {
                        paramAnonymouso.b(9, k.this.gXq().getString(c.i.app_delete), c.h.bottomsheet_icon_del);
                      }
                    }
                    if (k.this.gXq().PHI.Qhm.gSf()) {
                      break label1767;
                    }
                    Log.i("MicroMsg.WebViewMenuHelper", "control close");
                    if (!k.this.aoy(37)) {
                      break label1762;
                    }
                    k.this.gXq();
                    if ((!com.tencent.mm.plugin.webview.r.b(k.this.gXq().pHS)) || (!k.this.aox(37))) {
                      break label1762;
                    }
                    bool1 = true;
                    if (bool1)
                    {
                      if ((n)k.this.gXq().PHI.Qhm.PFc.getValue() != n.PER) {
                        break label1780;
                      }
                      paramAnonymouso.b(37, k.this.gXq().getString(c.i.webview_menu_tranlate_revert), c.h.icons_outlined_stoptranslate);
                      k.this.gXq().PHI.Qhm.a(com.tencent.mm.plugin.webview.l.PEG, m.PEN);
                    }
                    if (((paramLong & 0x2) == 0L) && (k.this.aoy(11)) && (k.a(this.QdR, 18)) && (k.this.aox(11))) {
                      paramAnonymouso.a(11, k.this.gXq().getString(c.i.readerapp_alert_font), c.h.icons_outlined_font, k.b(this.QdR, 18));
                    }
                    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG) || (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vSN, 0) == 1))
                    {
                      localObject = k.this.gXq();
                      if (!com.tencent.mm.plugin.webview.d.l.gUi()) {
                        break label1828;
                      }
                      i = c.i.webview_menu_disable_debug;
                      paramAnonymouso.a(99, ((WebViewUI)localObject).getString(i), c.h.webview_menu_enable_debug, false);
                    }
                    k.this.qXn.gIa();
                    AppMethodBeat.o(251175);
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
                    bool1 = k.this.gXq().PIQ.pGC.Ql(localException2);
                    if (bool1)
                    {
                      bool1 = k.a(this.QdR, 19);
                      bool2 = k.b(this.QdR, 19);
                      boolean bool3 = k.this.gXq().PIQ.gSP();
                      if ((!k.this.aoy(5)) || (!bool1) || (!k.this.aox(5))) {
                        continue;
                      }
                      if (!bool3) {
                        break label1718;
                      }
                      paramAnonymouso.a(5, k.this.gXq().getString(c.i.wv_alert_show_subbiz_info), c.h.icons_outlined_official_accounts, bool2);
                    }
                  }
                  catch (Exception localException3)
                  {
                    for (;;)
                    {
                      Log.e("MicroMsg.WebViewMenuHelper", "sharebtn click fail, ex = " + localException3.getMessage());
                      bool1 = false;
                      continue;
                      bool1 = k.a(this.QdR, 20);
                      bool2 = k.b(this.QdR, 20);
                    }
                  }
                  if ((this.QdT == null) || (!this.QdT.PYi))
                  {
                    paramAnonymouso.a(5, k.this.gXq().getString(c.i.wv_alert_show_biz_info), c.h.icons_outlined_official_accounts, bool2);
                    continue;
                    bool1 = false;
                    continue;
                    bool1 = k.this.aoy(37);
                    continue;
                    paramAnonymouso.b(37, k.this.gXq().getString(c.i.webview_menu_tranlate), c.h.icons_outlined_translate);
                    k.this.gXq().PHI.Qhm.a(com.tencent.mm.plugin.webview.l.PEG, m.PEL);
                    continue;
                    i = c.i.webview_menu_enable_debug;
                  }
                }
              }
            }
            catch (Exception localException1)
            {
              Log.e("MicroMsg.WebViewMenuHelper", "exception in add jd menu, " + localException1.getMessage());
              localObject = k.this.gXq().getIntent().getStringExtra("srcUsername");
              if (Util.isNullOrNil((String)localObject)) {}
            }
          }
        }
      };
      this.qXn.YmA = ((q.g)localObject2);
      localObject2 = gXq().PIQ.getCurrentUrl();
      if (!Util.isNullOrNil((String)localObject2))
      {
        localObject3 = Uri.parse((String)localObject2).getHost();
        localObject4 = gXq().getString(c.i.webview_logo_url, new Object[] { localObject3 });
        if (Util.isNullOrNil(this.Qdz)) {
          if ((i != 0) && (localObject1 != null) && (((p.b)localObject1).isDataValid()))
          {
            localObject2 = LayoutInflater.from(gXq()).inflate(c.g.mm_webview_ui_bottom_sheet_title_brand, null);
            localObject3 = (ImageView)((View)localObject2).findViewById(c.f.iv_head_img);
            Object localObject5 = (TextView)((View)localObject2).findViewById(c.f.tv_nick_name);
            localObject4 = ((View)localObject2).findViewById(c.f.content_layout);
            ((TextView)localObject5).setText(((p.b)localObject1).QhF);
            localObject5 = new c.a();
            ((c.a)localObject5).lRC = true;
            ((c.a)localObject5).kPz = true;
            ((c.a)localObject5).lRP = c.e.default_avatar;
            com.tencent.mm.ay.a.a.bms().a(((p.b)localObject1).QhG, (ImageView)localObject3, ((c.a)localObject5).bmL());
            ((View)localObject4).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(216631);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bn(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/WebViewMenuHelper$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                k.this.hf("Contact_Scene", 173);
                k.this.gXq().PIx.gWe().C(new Object[] { k.this.gXq().cDu(), Integer.valueOf(38), Integer.valueOf(1) }).report();
                k.this.gXq().bmo(this.QdT.lFl);
                if (k.this.qXn != null) {
                  k.this.qXn.bYF();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewMenuHelper$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(216631);
              }
            });
            com.tencent.mm.ui.tools.p.E((View)localObject4, 0.7F);
            this.qXn.Z((View)localObject2, true);
            label585:
            if (!gXq().gYM()) {
              break label913;
            }
            this.qXn.pMF = true;
            this.qXn.pMG = true;
            com.tencent.e.h.ZvG.n(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(229002);
                if (k.this.gXq().PvJ != null) {
                  k.this.gXq().PvJ.onWindowFocusChanged(false);
                }
                AppMethodBeat.o(229002);
              }
            }, 500L);
            label631:
            if ((gXq().Qfj == null) || (!gXq().Qfj.isShown())) {
              break label932;
            }
            gXq().Qfj.hide();
          }
        }
      }
      try
      {
        for (;;)
        {
          this.qXn.eik();
          if (gXq().PvJ != null) {
            gXq().PvJ.bkd("");
          }
          AppMethodBeat.o(226449);
          return;
          i = 0;
          break;
          if (Util.isNullOrNil((String)localObject3)) {
            break label585;
          }
          this.qXn.j((CharSequence)localObject4, 1, 0);
          break label585;
          localObject3 = LayoutInflater.from(gXq()).inflate(c.g.mm_webview_ui_bottom_sheet_title_text, null);
          localObject1 = (MMNeat7extView)((View)localObject3).findViewById(c.f.desc_text);
          this.qXn.Z((View)localObject3, false);
          localObject3 = com.tencent.mm.pluginsdk.ui.span.l.k(((MMNeat7extView)localObject1).getContext(), Util.nullAsNil(this.Qdz), (int)((MMNeat7extView)localObject1).getTextSize());
          ((MMNeat7extView)localObject1).aL((CharSequence)localObject3);
          localObject3 = (ClickableSpan[])((SpannableString)localObject3).getSpans(0, ((SpannableString)localObject3).length(), ClickableSpan.class);
          if ((localObject3 == null) || (localObject3.length <= 0)) {
            break label585;
          }
          Log.i("MicroMsg.WebViewMenuHelper", "terry h5 apply show");
          com.tencent.mm.plugin.report.service.h.IzE.a(16337, new Object[] { localObject2, Integer.valueOf(1), Integer.valueOf(0) });
          ((MMNeat7extView)localObject1).setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.h((NeatTextView)localObject1, new com.tencent.mm.pluginsdk.ui.span.o(((MMNeat7extView)localObject1).getContext()))
          {
            public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
            {
              AppMethodBeat.i(246694);
              boolean bool = super.onTouch(paramAnonymousView, paramAnonymousMotionEvent);
              if (bool)
              {
                Log.i("MMNeatTouchListener", "terry h5 apply click");
                com.tencent.mm.plugin.report.service.h.IzE.a(16337, new Object[] { this.val$url, Integer.valueOf(1), Integer.valueOf(1) });
              }
              AppMethodBeat.o(246694);
              return bool;
            }
          });
          break label585;
          this.qXn.j(" ", 1, 0);
          break label585;
          label913:
          this.qXn.pMF = false;
          this.qXn.pMG = false;
          break label631;
          label932:
          gXq().hideVKB();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.WebViewMenuHelper", "tryShow ex %s", new Object[] { localException.getMessage() });
        }
      }
    }
  }
  
  final void a(com.tencent.mm.plugin.appbrand.service.i parami)
  {
    AppMethodBeat.i(226423);
    if (this.QdI == null)
    {
      Log.i("MicroMsg.WebViewMenuHelper", "enhanceBottomSheet, openMaterialCollection is null");
      AppMethodBeat.o(226423);
      return;
    }
    if (this.qXn == null)
    {
      Log.i("MicroMsg.WebViewMenuHelper", "enhanceBottomSheet, mmBottomSheet is null");
      AppMethodBeat.o(226423);
      return;
    }
    WebViewUI localWebViewUI = gXq();
    if (localWebViewUI == null)
    {
      Log.w("MicroMsg.WebViewMenuHelper", "enhanceBottomSheet, webViewUI is null");
      AppMethodBeat.o(226423);
      return;
    }
    if (!parami.a(this.qXn, this.QdI))
    {
      Log.i("MicroMsg.WebViewMenuHelper", "enhanceBottomSheet, not need enhance");
      AppMethodBeat.o(226423);
      return;
    }
    boolean bool = gXR();
    Log.i("MicroMsg.WebViewMenuHelper", "enhanceBottomSheet, canShowOpenMaterials: ".concat(String.valueOf(bool)));
    Object localObject;
    if (this.QdJ != null)
    {
      localObject = this.QdJ;
      if (bool) {}
      for (parami = j.a.qmM;; parami = j.a.qmO)
      {
        ((j)localObject).a(parami);
        AppMethodBeat.o(226423);
        return;
      }
    }
    if (bool)
    {
      this.QdJ = parami.a(com.tencent.mm.plugin.appbrand.openmaterial.model.b.qnp, localWebViewUI, this.qXn, this.QdI, null, null);
      localObject = this.QdK;
      parami = (com.tencent.mm.plugin.appbrand.service.i)localObject;
      if (localObject == null)
      {
        parami = new b();
        this.QdK = parami;
      }
      parami.a(localWebViewUI);
    }
    AppMethodBeat.o(226423);
  }
  
  final void a(WebViewUI paramWebViewUI, ResolveInfo paramResolveInfo, final com.tencent.mm.ui.base.o paramo, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(226463);
    String str1 = com.tencent.mm.plugin.webview.ui.tools.browser.b.b(paramWebViewUI, paramResolveInfo);
    final String str2 = String.format(paramWebViewUI.getString(c.i.webview_browser_open_title), new Object[] { str1 });
    if (this.Qdx.Qjf != null)
    {
      a(paramo, str2, this.Qdx.Qjf, paramBoolean1, paramBoolean2);
      AppMethodBeat.o(226463);
      return;
    }
    new com.tencent.mm.plugin.webview.ui.tools.browser.e(paramWebViewUI, str1, new com.tencent.mm.plugin.webview.ui.tools.browser.e.a()
    {
      public final void H(Drawable paramAnonymousDrawable)
      {
        AppMethodBeat.i(223108);
        k.this.Qdx.Qjf = paramAnonymousDrawable;
        if ((paramAnonymousDrawable != null) && (k.this.qXn != null) && (k.this.qXn.isShowing())) {
          k.this.a(paramo, str2, paramAnonymousDrawable, paramBoolean1, paramBoolean2);
        }
        AppMethodBeat.o(223108);
      }
    }).execute(new ResolveInfo[] { paramResolveInfo });
    AppMethodBeat.o(226463);
  }
  
  final void a(final com.tencent.mm.ui.base.o paramo, final String paramString, final Drawable paramDrawable, final boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(226464);
    Log.d("MicroMsg.WebViewMenuHelper", "alvinluo addDefaultBrowserMenuItem withAnimation: %s, title: %s, iconDrawable: %s, bitmap: %s", new Object[] { Boolean.valueOf(paramBoolean2), paramString, paramDrawable, null });
    if (this.qXn == null)
    {
      AppMethodBeat.o(226464);
      return;
    }
    if (!paramBoolean2)
    {
      if (a(paramo, Math.max(0, paramo.hJP()), paramDrawable, paramString, paramBoolean1)) {
        this.qXn.gIa();
      }
      AppMethodBeat.o(226464);
      return;
    }
    com.tencent.e.h.ZvG.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(237496);
        if ((k.this.qXn != null) && (k.this.qXn.isShowing()))
        {
          int i = Math.max(0, paramo.hJP());
          if (k.a(paramo, i, paramDrawable, paramString, paramBoolean1))
          {
            com.tencent.mm.ui.widget.a.e locale = k.this.qXn;
            int j = locale.ODY.size();
            if ((locale.YmQ != null) && (i >= 0) && (i < j)) {
              locale.YmQ.cM(i);
            }
          }
        }
        AppMethodBeat.o(237496);
      }
    }, 100L);
    AppMethodBeat.o(226464);
  }
  
  protected final boolean a(JsapiPermissionWrapper paramJsapiPermissionWrapper, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(79902);
    if (paramJsapiPermissionWrapper == null)
    {
      AppMethodBeat.o(79902);
      return false;
    }
    if ((paramJsapiPermissionWrapper.arj(paramInt1) == 1) && (aox(paramInt2)))
    {
      AppMethodBeat.o(79902);
      return true;
    }
    AppMethodBeat.o(79902);
    return false;
  }
  
  protected final boolean aox(int paramInt)
  {
    AppMethodBeat.i(79881);
    SparseBooleanArray localSparseBooleanArray = (SparseBooleanArray)this.Qdt.get(gXq().pHS.getUrl());
    if ((localSparseBooleanArray != null) && (localSparseBooleanArray.get(paramInt, false)))
    {
      AppMethodBeat.o(79881);
      return false;
    }
    AppMethodBeat.o(79881);
    return true;
  }
  
  final boolean aoy(int paramInt)
  {
    AppMethodBeat.i(226416);
    if ((!this.QdB) || (this.QdD.contains(Integer.valueOf(paramInt))))
    {
      AppMethodBeat.o(226416);
      return true;
    }
    AppMethodBeat.o(226416);
    return false;
  }
  
  public final void atk()
  {
    AppMethodBeat.i(79885);
    if (gXT()) {
      TF(0L);
    }
    AppMethodBeat.o(79885);
  }
  
  final void bmh(String paramString)
  {
    AppMethodBeat.i(79889);
    gXq().PvJ.cZ("sendAppMessage", false);
    com.tencent.mm.plugin.webview.d.h localh = gXq().PvJ;
    if (!localh.NoX)
    {
      Log.e("MicroMsg.JsApiHandler", "onSendToEnterprise fail, not ready");
      AppMethodBeat.o(79889);
      return;
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("scene", "enterprise");
    localObject = n.a.b("menu:share:appmessage", (Map)localObject, localh.PNx, localh.EVx);
    localh.PNp.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + (String)localObject + ")", null);
    try
    {
      localh.pGC.aw("connector_local_send", paramString, localh.PNz);
      localh.pGC.aw("scene", "enterprise", localh.PNz);
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
  protected final void bmi(String paramString)
  {
    // Byte code:
    //   0: ldc_w 1342
    //   3: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 754	com/tencent/mm/plugin/webview/ui/tools/a:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   10: invokevirtual 758	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   13: ldc_w 760
    //   16: invokevirtual 765	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   19: astore 7
    //   21: aload_0
    //   22: invokevirtual 261	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   25: invokevirtual 207	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:elY	()Ljava/lang/String;
    //   28: astore 8
    //   30: aconst_null
    //   31: astore 4
    //   33: aload 8
    //   35: invokestatic 437	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   38: ifne +13 -> 51
    //   41: aload 8
    //   43: invokestatic 1010	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   46: invokevirtual 1013	android/net/Uri:getHost	()Ljava/lang/String;
    //   49: astore 4
    //   51: aload 4
    //   53: invokestatic 437	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   56: ifne +500 -> 556
    //   59: aload 4
    //   61: getstatic 1345	com/tencent/mm/plugin/webview/c$i:host_mp_weixin_qq_com	I
    //   64: invokestatic 1350	com/tencent/mm/sdk/platformtools/WeChatHosts:domainString	(I)Ljava/lang/String;
    //   67: invokevirtual 1353	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   70: ifeq +486 -> 556
    //   73: getstatic 1358	com/tencent/mm/ui/f$e:VRY	Ljava/lang/String;
    //   76: iconst_1
    //   77: anewarray 238	java/lang/Object
    //   80: dup
    //   81: iconst_0
    //   82: aload 8
    //   84: ldc_w 1360
    //   87: invokestatic 753	com/tencent/mm/compatible/util/q:an	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   90: aastore
    //   91: invokestatic 1260	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   94: astore 4
    //   96: aload_0
    //   97: invokevirtual 261	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   100: aload_0
    //   101: invokevirtual 261	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   104: getfield 301	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:pHS	Lcom/tencent/mm/ui/widget/MMWebView;
    //   107: invokevirtual 392	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
    //   110: invokevirtual 722	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bju	(Ljava/lang/String;)Ljava/lang/String;
    //   113: astore 9
    //   115: ldc 234
    //   117: ldc_w 1362
    //   120: iconst_1
    //   121: anewarray 238	java/lang/Object
    //   124: dup
    //   125: iconst_0
    //   126: getstatic 1365	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   129: aastore
    //   130: invokestatic 689	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   133: aload 9
    //   135: invokestatic 728	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   138: ifne +176 -> 314
    //   141: aload_0
    //   142: invokevirtual 261	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   145: getfield 301	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:pHS	Lcom/tencent/mm/ui/widget/MMWebView;
    //   148: invokevirtual 392	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
    //   151: invokestatic 728	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   154: ifne +160 -> 314
    //   157: invokestatic 736	com/tencent/mm/sdk/platformtools/Util:nowSecond	()J
    //   160: lstore_2
    //   161: ldc 234
    //   163: ldc_w 1367
    //   166: bipush 7
    //   168: anewarray 238	java/lang/Object
    //   171: dup
    //   172: iconst_0
    //   173: sipush 13377
    //   176: invokestatic 609	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   179: aastore
    //   180: dup
    //   181: iconst_1
    //   182: lload_2
    //   183: invokestatic 743	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   186: aastore
    //   187: dup
    //   188: iconst_2
    //   189: aload 9
    //   191: aastore
    //   192: dup
    //   193: iconst_3
    //   194: aload_0
    //   195: invokevirtual 261	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   198: getfield 301	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:pHS	Lcom/tencent/mm/ui/widget/MMWebView;
    //   201: invokevirtual 392	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
    //   204: aastore
    //   205: dup
    //   206: iconst_4
    //   207: aload_0
    //   208: invokevirtual 261	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   211: getfield 746	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sessionId	Ljava/lang/String;
    //   214: aastore
    //   215: dup
    //   216: iconst_5
    //   217: iconst_4
    //   218: invokestatic 609	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   221: aastore
    //   222: dup
    //   223: bipush 6
    //   225: iconst_1
    //   226: invokestatic 609	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   229: aastore
    //   230: invokestatic 689	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   233: ldc 145
    //   235: astore 5
    //   237: aload_0
    //   238: invokevirtual 261	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   241: getfield 301	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:pHS	Lcom/tencent/mm/ui/widget/MMWebView;
    //   244: invokevirtual 392	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
    //   247: ldc_w 748
    //   250: invokestatic 753	com/tencent/mm/compatible/util/q:an	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   253: astore 6
    //   255: aload 6
    //   257: astore 5
    //   259: getstatic 775	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   262: sipush 13377
    //   265: bipush 6
    //   267: anewarray 238	java/lang/Object
    //   270: dup
    //   271: iconst_0
    //   272: lload_2
    //   273: invokestatic 743	java/lang/Long:valueOf	(J)Ljava/lang/Long;
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
    //   290: invokevirtual 261	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   293: getfield 746	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sessionId	Ljava/lang/String;
    //   296: aastore
    //   297: dup
    //   298: iconst_4
    //   299: iconst_4
    //   300: invokestatic 609	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   303: aastore
    //   304: dup
    //   305: iconst_5
    //   306: iconst_1
    //   307: invokestatic 609	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   310: aastore
    //   311: invokevirtual 778	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
    //   314: aload 4
    //   316: astore 5
    //   318: aload 4
    //   320: invokestatic 437	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   323: ifeq +23 -> 346
    //   326: getstatic 1370	com/tencent/mm/ui/f$e:VRX	Ljava/lang/String;
    //   329: iconst_1
    //   330: anewarray 238	java/lang/Object
    //   333: dup
    //   334: iconst_0
    //   335: bipush 34
    //   337: invokestatic 609	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   340: aastore
    //   341: invokestatic 1260	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   344: astore 5
    //   346: new 762	android/content/Intent
    //   349: dup
    //   350: invokespecial 1371	android/content/Intent:<init>	()V
    //   353: astore 4
    //   355: aload_1
    //   356: invokestatic 437	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   359: ifne +24 -> 383
    //   362: aload 4
    //   364: ldc_w 1373
    //   367: aload_1
    //   368: ldc_w 748
    //   371: invokevirtual 1377	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   374: bipush 11
    //   376: invokestatic 1383	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   379: invokevirtual 1387	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   382: pop
    //   383: ldc 234
    //   385: ldc_w 1389
    //   388: iconst_2
    //   389: anewarray 238	java/lang/Object
    //   392: dup
    //   393: iconst_0
    //   394: aload 8
    //   396: aastore
    //   397: dup
    //   398: iconst_1
    //   399: aload_0
    //   400: invokevirtual 261	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   403: invokevirtual 1392	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cDu	()Ljava/lang/String;
    //   406: aastore
    //   407: invokestatic 249	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   410: aload 4
    //   412: ldc_w 1394
    //   415: aload 5
    //   417: invokevirtual 1387	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   420: pop
    //   421: aload 4
    //   423: ldc_w 1396
    //   426: aload 8
    //   428: invokevirtual 1387	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   431: pop
    //   432: aload 4
    //   434: ldc_w 1398
    //   437: aload_0
    //   438: invokevirtual 261	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   441: invokevirtual 1392	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:cDu	()Ljava/lang/String;
    //   444: invokevirtual 1387	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   447: pop
    //   448: aload 4
    //   450: ldc_w 1400
    //   453: aload_0
    //   454: invokevirtual 261	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   457: aload 7
    //   459: invokevirtual 769	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bjD	(Ljava/lang/String;)I
    //   462: invokevirtual 1403	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   465: pop
    //   466: aload 4
    //   468: ldc_w 1405
    //   471: iconst_1
    //   472: invokevirtual 1408	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   475: pop
    //   476: aload_0
    //   477: invokevirtual 261	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   480: aload_0
    //   481: invokevirtual 261	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   484: getstatic 1411	com/tencent/mm/plugin/webview/c$i:webview_report_screenshot_alert	I
    //   487: invokevirtual 1256	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   490: ldc 145
    //   492: aload_0
    //   493: invokevirtual 261	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   496: getstatic 1414	com/tencent/mm/plugin/webview/c$i:app_agree	I
    //   499: invokevirtual 1256	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   502: aload_0
    //   503: invokevirtual 261	com/tencent/mm/plugin/webview/ui/tools/k:gXq	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   506: getstatic 1417	com/tencent/mm/plugin/webview/c$i:app_disagree	I
    //   509: invokevirtual 1256	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   512: iconst_0
    //   513: new 8	com/tencent/mm/plugin/webview/ui/tools/k$10
    //   516: dup
    //   517: aload_0
    //   518: aload 4
    //   520: invokespecial 1420	com/tencent/mm/plugin/webview/ui/tools/k$10:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/k;Landroid/content/Intent;)V
    //   523: new 10	com/tencent/mm/plugin/webview/ui/tools/k$11
    //   526: dup
    //   527: aload_0
    //   528: aload 4
    //   530: invokespecial 1421	com/tencent/mm/plugin/webview/ui/tools/k$11:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/k;Landroid/content/Intent;)V
    //   533: invokestatic 1424	com/tencent/mm/ui/base/h:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mm/ui/widget/a/d;
    //   536: pop
    //   537: ldc_w 1342
    //   540: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   543: return
    //   544: astore 4
    //   546: ldc 234
    //   548: aload 4
    //   550: invokevirtual 1425	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   553: invokestatic 978	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   556: aconst_null
    //   557: astore 4
    //   559: goto -463 -> 96
    //   562: astore 6
    //   564: ldc 234
    //   566: aload 6
    //   568: ldc 145
    //   570: iconst_0
    //   571: anewarray 238	java/lang/Object
    //   574: invokestatic 255	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   577: goto -318 -> 259
    //   580: astore_1
    //   581: ldc 234
    //   583: new 631	java/lang/StringBuilder
    //   586: dup
    //   587: ldc_w 1427
    //   590: invokespecial 635	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   593: aload_1
    //   594: invokevirtual 1425	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   597: invokevirtual 639	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: invokevirtual 644	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   603: invokestatic 978	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   606: goto -223 -> 383
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	609	0	this	k
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
  
  protected final void cxg()
  {
    AppMethodBeat.i(79897);
    String str1 = gXq().bju(gXq().PIQ.PFK);
    String str2 = gXq().getIntent().getStringExtra("shortcut_user_name");
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
      gXq().PIQ.pGC.l(80, localBundle);
      AppMethodBeat.o(79897);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.WebViewMenuHelper", "addShortcut, e = " + localException.getMessage());
      AppMethodBeat.o(79897);
    }
  }
  
  public final void g(String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(226408);
    SparseBooleanArray localSparseBooleanArray2 = (SparseBooleanArray)this.Qdt.get(paramString);
    SparseBooleanArray localSparseBooleanArray1 = localSparseBooleanArray2;
    if (localSparseBooleanArray2 == null)
    {
      localSparseBooleanArray1 = new SparseBooleanArray();
      this.Qdt.put(paramString, localSparseBooleanArray1);
    }
    if (localSparseBooleanArray1 != null)
    {
      localSparseBooleanArray1.put(34, true);
      localSparseBooleanArray1.put(10, paramIntent.getBooleanExtra("key_menu_hide_expose", false));
    }
    AppMethodBeat.o(226408);
  }
  
  public final void gXS()
  {
    AppMethodBeat.i(79879);
    this.Qdu.clear();
    this.Qdu.put("menuItem:share:brand", Integer.valueOf(0));
    this.Qdu.put("menuItem:share:appMessage", Integer.valueOf(1));
    this.Qdu.put("menuItem:share:dataMessage", Integer.valueOf(23));
    this.Qdu.put("menuItem:share:timeline", Integer.valueOf(2));
    this.Qdu.put("menuItem:favorite", Integer.valueOf(3));
    this.Qdu.put("menuItem:profile", Integer.valueOf(5));
    this.Qdu.put("menuItem:addContact", Integer.valueOf(5));
    this.Qdu.put("menuItem:copyUrl", Integer.valueOf(6));
    this.Qdu.put("menuItem:openWithSafari", Integer.valueOf(7));
    this.Qdu.put("menuItem:share:email", Integer.valueOf(8));
    this.Qdu.put("menuItem:delete", Integer.valueOf(9));
    this.Qdu.put("menuItem:exposeArticle", Integer.valueOf(10));
    this.Qdu.put("menuItem:setFont", Integer.valueOf(11));
    this.Qdu.put("menuItem:editTag", Integer.valueOf(12));
    this.Qdu.put("menuItem:share:qq", Integer.valueOf(20));
    this.Qdu.put("menuItem:share:weiboApp", Integer.valueOf(21));
    this.Qdu.put("menuItem:share:QZone", Integer.valueOf(22));
    this.Qdu.put("menuItem:share:facebook", Integer.valueOf(33));
    this.Qdu.put("menuItem:share:enterprise", Integer.valueOf(24));
    this.Qdu.put("menuItem:refresh", Integer.valueOf(28));
    this.Qdu.put("menuItem:share:wework", Integer.valueOf(25));
    this.Qdu.put("menuItem:share:wework_LOCAL", Integer.valueOf(43));
    this.Qdu.put("menuItem:share:weread", Integer.valueOf(26));
    this.Qdu.put("menuItem:addShortcut", Integer.valueOf(29));
    this.Qdu.put("menuItem:search", Integer.valueOf(31));
    this.Qdu.put("menuItem:readArticle", Integer.valueOf(34));
    this.Qdu.put("menuItem:minimize", Integer.valueOf(35));
    this.Qdu.put("menuItem:cancelMinimize", Integer.valueOf(36));
    this.Qdu.put("menuItem:translate", Integer.valueOf(37));
    this.Qdu.put("menuItem:haoKan", Integer.valueOf(38));
    this.Qdu.put("menuItem:cancelHaoKan", Integer.valueOf(39));
    this.Qdu.put("menuItem:ttsStart", Integer.valueOf(40));
    this.Qdu.put("menuItem:ttsPause", Integer.valueOf(41));
    this.Qdu.put("menuItem:ttsResume", Integer.valueOf(42));
    AppMethodBeat.o(79879);
  }
  
  public final boolean gXT()
  {
    AppMethodBeat.i(226411);
    if (this.qXn == null)
    {
      AppMethodBeat.o(226411);
      return false;
    }
    boolean bool = this.qXn.isShowing();
    AppMethodBeat.o(226411);
    return bool;
  }
  
  protected final void gXU()
  {
    AppMethodBeat.i(79884);
    if (!this.QdC)
    {
      AppMethodBeat.o(79884);
      return;
    }
    this.QdB = false;
    gXq().QgL = false;
    this.QdC = false;
    if (gXT()) {
      TF(0L);
    }
    AppMethodBeat.o(79884);
  }
  
  public final void gXV()
  {
    AppMethodBeat.i(79886);
    this.QdB = true;
    this.QdD.clear();
    if ((gXq() instanceof GameWebViewUI))
    {
      this.QdD.add(Integer.valueOf(11));
      this.QdD.add(Integer.valueOf(28));
      AppMethodBeat.o(79886);
      return;
    }
    this.QdD.add(Integer.valueOf(7));
    this.QdD.add(Integer.valueOf(11));
    this.QdD.add(Integer.valueOf(28));
    AppMethodBeat.o(79886);
  }
  
  public final void gXW()
  {
    AppMethodBeat.i(293052);
    TF(0L);
    AppMethodBeat.o(293052);
  }
  
  protected final void gXY()
  {
    AppMethodBeat.i(79892);
    if (gXq().PvJ != null)
    {
      gXq().PvJ.bkd("fav");
      gXq().PvJ.cZ("sendAppMessage", false);
      gXq().PvJ.d(gXZ(), 0);
      AppMethodBeat.o(79892);
      return;
    }
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putLong("msg_id", gXq().getIntent().getLongExtra("msg_id", -9223372036854775808L));
    ((Bundle)localObject1).putString("sns_local_id", gXq().getIntent().getStringExtra("sns_local_id"));
    ((Bundle)localObject1).putInt("news_svr_id", gXq().getIntent().getIntExtra("news_svr_id", 0));
    ((Bundle)localObject1).putString("news_svr_tweetid", gXq().getIntent().getStringExtra("news_svr_tweetid"));
    ((Bundle)localObject1).putInt("message_index", gXq().getIntent().getIntExtra("message_index", 0));
    ((Bundle)localObject1).putString("rawUrl", gXq().cDu());
    Object localObject2;
    if ((!Util.isNullOrNil(gXq().cDu())) && (gXq().cDu().endsWith("#rd")))
    {
      localObject2 = gXq().cDu().substring(0, gXq().cDu().length() - 3);
      if ((!Util.isNullOrNil(gXq().PIQ.PFK)) && (!gXq().PIQ.PFK.startsWith((String)localObject2)))
      {
        ((Bundle)localObject1).putString("rawUrl", gXq().PIQ.PFK);
        ((Bundle)localObject1).putLong("msg_id", -9223372036854775808L);
      }
    }
    for (;;)
    {
      localObject2 = gXq().getIntent();
      if (localObject2 != null)
      {
        ((Bundle)localObject1).putString("preChatName", ((Intent)localObject2).getStringExtra("preChatName"));
        ((Bundle)localObject1).putInt("preMsgIndex", ((Intent)localObject2).getIntExtra("preMsgIndex", 0));
        ((Bundle)localObject1).putString("prePublishId", ((Intent)localObject2).getStringExtra("prePublishId"));
        ((Bundle)localObject1).putString("preUsername", ((Intent)localObject2).getStringExtra("preUsername"));
      }
      try
      {
        localObject1 = gXq().PIQ.pGC.aU((Bundle)localObject1);
        if (((com.tencent.mm.plugin.webview.stub.c)localObject1).gWU())
        {
          gXq().PvJ.cZ("sendAppMessage", false);
          gXq().PvJ.d(gXZ(), 0);
          Log.i("MicroMsg.WebViewMenuHelper", "on favorite simple url");
          AppMethodBeat.o(79892);
          return;
          if ((!Util.isNullOrNil(gXq().PIQ.PFK)) && (!gXq().PIQ.PFK.startsWith(gXq().cDu())))
          {
            ((Bundle)localObject1).putString("rawUrl", gXq().PIQ.PFK);
            ((Bundle)localObject1).putLong("msg_id", -9223372036854775808L);
          }
        }
        else
        {
          com.tencent.mm.plugin.fav.ui.e.a(((com.tencent.mm.plugin.webview.stub.c)localObject1).getRet(), gXq(), gXq().CBU);
          if (((com.tencent.mm.plugin.webview.stub.c)localObject1).getRet() == 0)
          {
            aoz(1);
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
    aoz(2);
    AppMethodBeat.o(79892);
  }
  
  public final HashMap<String, String> gXZ()
  {
    AppMethodBeat.i(79893);
    if (!gXq().QgL)
    {
      AppMethodBeat.o(79893);
      return null;
    }
    Intent localIntent = gXq().getIntent();
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
  
  final boolean gYa()
  {
    AppMethodBeat.i(79896);
    try
    {
      boolean bool = gXq().PIQ.pGC.blP("favorite");
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
  
  public final void gYb()
  {
    AppMethodBeat.i(79899);
    if ((gXq() == null) || (gXq().pGD == null))
    {
      Log.e("MicroMsg.WebViewMenuHelper", "showShareMenu params failed");
      AppMethodBeat.o(79899);
      return;
    }
    final JsapiPermissionWrapper localJsapiPermissionWrapper = gXq().pGD.gWI();
    if ((!a(localJsapiPermissionWrapper, 21, 1)) && (!a(localJsapiPermissionWrapper, 23, 2)))
    {
      com.tencent.mm.ui.base.h.cO(gXq(), gXq().getString(c.i.wv_block_shared_tips));
      AppMethodBeat.o(79899);
      return;
    }
    com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(gXq(), 1, false);
    locale.ODT = new q.f()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymouso)
      {
        AppMethodBeat.i(221462);
        if (k.this.a(localJsapiPermissionWrapper, 21, 1)) {
          paramAnonymouso.a(1, k.this.gXq().getString(c.i.readerapp_alert_retransmit), c.h.bottomsheet_icon_transmit, false);
        }
        if (k.this.a(localJsapiPermissionWrapper, 23, 2)) {
          paramAnonymouso.a(2, k.this.gXq().getString(c.i.readerapp_alert_share_to_timeline), c.h.bottomsheet_icon_moment, false);
        }
        AppMethodBeat.o(221462);
      }
    };
    locale.ODU = new q.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        paramAnonymousInt = 0;
        AppMethodBeat.i(254117);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(254117);
          return;
          paramAnonymousMenuItem = k.this.gXq().getIntent().getStringExtra("KPublisherId");
          String str1 = k.this.gXq().getIntent().getStringExtra("KAppId");
          String str2 = k.this.gXq().getIntent().getStringExtra("srcUsername");
          k.this.gXq().PIx.gWe().C(new Object[] { k.this.gXq().cDu(), Integer.valueOf(1), Integer.valueOf(1), paramAnonymousMenuItem, str1, str2 }).report();
          k.this.gXq().aoE(1);
          AppMethodBeat.o(254117);
          return;
          paramAnonymousMenuItem = k.this.gXq().getIntent().getStringExtra("KPublisherId");
          str1 = k.this.gXq().getIntent().getStringExtra("KAppId");
          str2 = k.this.gXq().getIntent().getStringExtra("srcUsername");
          k.this.gXq().PIx.gWe().C(new Object[] { k.this.gXq().cDu(), Integer.valueOf(2), Integer.valueOf(1), paramAnonymousMenuItem, str1, str2 }).report();
          if (k.this.QdA.containsKey(k.this.gXq().pHS.getUrl())) {
            paramAnonymousInt = ((Integer)k.this.QdA.get(k.this.gXq().pHS.getUrl())).intValue();
          }
          k.a(k.this, paramAnonymousInt, 1);
        }
      }
    };
    locale.j(" ", 1, 0);
    locale.eik();
    AppMethodBeat.o(79899);
  }
  
  public final void gYc()
  {
    AppMethodBeat.i(79900);
    if ((gXq() == null) || (gXq().pHS == null) || (gXq().pGD == null))
    {
      Log.e("MicroMsg.WebViewMenuHelper", "setShareFuncFlag params failed");
      AppMethodBeat.o(79900);
      return;
    }
    String str = gXq().pHS.getUrl();
    if (!Util.isNullOrNil(str))
    {
      try
      {
        boolean bool = new URL(str).getHost().equals(WeChatHosts.domainString(c.i.host_mp_weixin_qq_com));
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
    int i = gYd();
    if (gXq().PvJ != null)
    {
      com.tencent.mm.plugin.webview.d.h localh = gXq().PvJ;
      if (localh.NoX)
      {
        Object localObject = new HashMap();
        ((HashMap)localObject).put("action", "setFuncFlag");
        ((HashMap)localObject).put("shareFuncFlag", Integer.valueOf(i));
        localObject = n.a.b("onMPPageAction", (Map)localObject, localh.PNx, localh.EVx);
        localh.PNp.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + (String)localObject + ")", null);
      }
    }
    AppMethodBeat.o(79900);
  }
  
  public final int gYd()
  {
    AppMethodBeat.i(79901);
    if ((gXq() == null) || (gXq().pGD == null))
    {
      Log.e("MicroMsg.WebViewMenuHelper", "getShareFuncFlag params failed");
      AppMethodBeat.o(79901);
      return -1;
    }
    JsapiPermissionWrapper localJsapiPermissionWrapper = gXq().pGD.gWI();
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
  
  public final void hf(String paramString, int paramInt)
  {
    AppMethodBeat.i(79895);
    if (gXq().PvJ != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt(paramString, paramInt);
      paramString = gXq().PvJ;
      try
      {
        paramString.pGC.a(21, localBundle, paramString.PNz);
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
  
  final void hpH()
  {
    AppMethodBeat.i(293051);
    if (this.qXn != null)
    {
      if (this.qXn.isShowing()) {
        this.qXn.bYF();
      }
      this.qXn.mContext = null;
      this.qXn = null;
    }
    this.QdE = null;
    AppMethodBeat.o(293051);
  }
  
  final void ja(List<String> paramList)
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
      if (this.Qdv.get(str2) != null) {
        Log.i("MicroMsg.WebViewMenuHelper", "find %s icon from cache ok", new Object[] { str2 });
      }
      for (;;)
      {
        if (!this.Qdw.containsKey(str2)) {
          break label216;
        }
        Log.i("MicroMsg.WebViewMenuHelper", "find %s nick from cache ok", new Object[] { str2 });
        break;
        Log.w("MicroMsg.WebViewMenuHelper", "not found %s icon from cache, try to load", new Object[] { str2 });
        try
        {
          paramList = gXq().PIQ.pGC.blL(str2);
          if (!Util.isNullOrNil(paramList))
          {
            paramList = e.bma(paramList);
            if (paramList != null)
            {
              Log.i("MicroMsg.WebViewMenuHelper", "load ok, and cache it");
              this.Qdv.put(str2, paramList);
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
        String str1 = gXq().PIQ.pGC.PJ(str2);
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
      this.Qdw.put(str2, paramList);
    }
    label308:
    AppMethodBeat.o(79894);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(79878);
    Iterator localIterator = this.Qdt.values().iterator();
    while (localIterator.hasNext())
    {
      SparseBooleanArray localSparseBooleanArray = (SparseBooleanArray)localIterator.next();
      if (localSparseBooleanArray != null) {
        localSparseBooleanArray.clear();
      }
    }
    this.Qdt.clear();
    this.QdA.clear();
    hpH();
    this.QdJ = null;
    AppMethodBeat.o(79878);
  }
  
  static final class a
    implements com.tencent.mm.plugin.appbrand.openmaterial.k
  {
    private final com.tencent.mm.plugin.appbrand.service.i QdV;
    private final WeakReference<k> sjt;
    private final String url;
    
    public a(k paramk, String paramString, com.tencent.mm.plugin.appbrand.service.i parami)
    {
      AppMethodBeat.i(219148);
      this.sjt = new WeakReference(paramk);
      this.url = paramString;
      this.QdV = parami;
      AppMethodBeat.o(219148);
    }
    
    public final void a(boolean paramBoolean, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
    {
      AppMethodBeat.i(219155);
      k localk = (k)this.sjt.get();
      if (localk == null)
      {
        Log.i("MicroMsg.WebViewMenuHelper", "onOpenMaterialsGot, menuHelper is null");
        AppMethodBeat.o(219155);
        return;
      }
      if (!paramBoolean)
      {
        Log.i("MicroMsg.WebViewMenuHelper", "onOpenMaterialsGot, fail");
        AppMethodBeat.o(219155);
        return;
      }
      localk.QdH = this.url;
      localk.QdI = paramAppBrandOpenMaterialCollection;
      localk.a(this.QdV);
      AppMethodBeat.o(219155);
    }
  }
  
  final class b
    implements com.tencent.mm.vending.e.a
  {
    private boolean QdW;
    
    public b()
    {
      AppMethodBeat.i(264800);
      this.QdW = false;
      Log.i("MicroMsg.WebViewMenuHelper", "<init>#OpenMaterialReleaser");
      AppMethodBeat.o(264800);
    }
    
    public final void a(WebViewUI paramWebViewUI)
    {
      AppMethodBeat.i(264801);
      Log.i("MicroMsg.WebViewMenuHelper", "keepMyself#OpenMaterialReleaser, isKept: " + this.QdW);
      if (!this.QdW)
      {
        paramWebViewUI.keep(this);
        this.QdW = true;
      }
      AppMethodBeat.o(264801);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(264802);
      Log.i("MicroMsg.WebViewMenuHelper", "dead#OpenMaterialReleaser, isKept: " + this.QdW);
      k.this.QdH = null;
      k.this.QdI = null;
      k.this.QdJ = null;
      this.QdW = false;
      AppMethodBeat.o(264802);
    }
  }
  
  public static final class c
  {
    public int QdX = -1;
    public Bundle QdY = null;
    public boolean qfB = false;
    public int qgq = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.k
 * JD-Core Version:    0.7.0.1
 */